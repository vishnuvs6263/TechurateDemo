package stepDefnition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoginPageObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

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
		
		
	}

}
