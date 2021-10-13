package stepDefnition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.AddBillerPage;
import Pages.AddBeneficiary;
import Pages.LoginPageObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

@RunWith(Cucumber.class)
public class LoginStep {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on the landing page$")
	public void user_is_on_the_landing_page(DataTable data) throws Throwable {
		List<List<String>> obj = data.asLists();
		// Getting the automation project path
		String ProjectPath = System.getProperty("user.dir");

		// Initialize the driver
		System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(obj.get(0).get(0));

	}

	@When("^User login into the application with username password and OTP$")
	public void user_login_into_the_application_with_username_password_and_otp(DataTable data) throws Throwable {
		LoginPageObjects objects = new LoginPageObjects(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.LoginBtn()));
		objects.LoginBtn().click();
		List<List<String>> obj = data.asLists();
		wait.until(ExpectedConditions.elementToBeClickable(objects.UsernameField()));
		objects.UsernameField().sendKeys(obj.get(0).get(0));
		objects.PasswordField().sendKeys(obj.get(0).get(1));
		objects.LoginBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.OTPField()));
		objects.OTPField().sendKeys(obj.get(0).get(2));
		Thread.sleep(3000);
		objects.LoginBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getUserName()));
		String ActualUserName = objects.getUserName().getText();
		if (ActualUserName.contains(obj.get(0).get(3))) {
			Assert.assertTrue(true);
			System.out.println("Verify user login executed and passed successfully");

		} else {
			Assert.fail();
			System.out.println("Test case verification failed");

		}
		
		
	}

	@Then("^Navigate to payments module and add biller$")
	public void navigate_to_payments_module_and_add_biller() throws Throwable {

		AddBillerPage objects = new AddBillerPage(driver);
		System.out.println("executed add biller");
		wait.until(ExpectedConditions.elementToBeClickable(objects.PaymentsModule()));
		objects.PaymentsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddBillerBtn()));
		objects.AddBillerBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SubmitBtn()));
		Select select = new Select(objects.SelectMerchantDropDown());
		select.selectByValue("MLife");
		Random rnd = new Random();
		int n = 1000000000 + rnd.nextInt(900000000);
		String accnumber = String.valueOf(n);
		objects.AccountNumberField().sendKeys(accnumber);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mmss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String BillerName = "Test Demo Biller";
		objects.ShortNameField().sendKeys(BillerName);
		objects.SubmitBtn().click();
		String SuccessMSg = objects.VerifySuccessMsg().getText();
		if (SuccessMSg.contains("Biller Beneficiary Added Successfully")) {
			Assert.assertTrue(true);
			System.out.println("Verify user add biller executed and passed successfully");

		} else {
			Assert.fail();
			System.out.println("Test case verification failed");

		}
		wait.until(ExpectedConditions.elementToBeClickable(objects.DoneBtn()));
		objects.DoneBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.DeleteBtn()));
		objects.DeleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CnfrmBtn()));
		objects.CnfrmBtn().click();


	}
	
	@Then("^user is able to add beneficiary$")
	public void user_is_able_to_add_beneficiary(DataTable data) {
		System.out.println("user is able to add beneficiary");
		AddBeneficiary objects = new AddBeneficiary(driver);
		List<List<String>> obj = data.asLists();
		Random rnd = new Random();
		int n = 1000000000 + rnd.nextInt(900000000);
		String accnumber = String.valueOf(n);
		objects.Transfers().click();
		objects.AddBeneficiaryTransfers().click();
		objects.internalBeneficiary().click();
		objects.NickNameinternalBeneficiary().sendKeys(obj.get(0).get(0));
		objects.AccountNointernalBeneficiary().sendKeys(accnumber);
		objects.ConfirmAcNointernalBeneficiary().sendKeys(accnumber);
		objects.TransfersLimitInternalBeneficiary().sendKeys("3");
		objects.SubmitInternalBeneficiary().click();
		objects.ConfirmSubmit().click();
		objects.OTP().sendKeys("1234");
		objects.OTPSubmit().click();
		
	}

}
