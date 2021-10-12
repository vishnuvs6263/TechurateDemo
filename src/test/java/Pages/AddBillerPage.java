package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBillerPage {
	WebDriver driver;

	public AddBillerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath= "(//h2[text()='Payments'])[2]")WebElement PaymentsModule;
	@FindBy(xpath= "//span[text()='Maintain a service provider beneficiary']")WebElement AddBillerBtn;
	@FindBy(xpath= "//select[@name='merchant']")WebElement SelectMerchantDropDown;
	@FindBy(xpath= "//input[@name='serviceNumber']")WebElement AccountNumberField;
	@FindBy(xpath= "//input[@name='shortName']")WebElement ShortNameField;
	@FindBy(xpath= "//p[text()='Submit']")WebElement SubmitBtn;
	
	public WebElement PaymentsModule()
	{
		return PaymentsModule;
	}
	
	public WebElement AddBillerBtn()
	{
		return AddBillerBtn;
	}
	
	public WebElement SelectMerchantDropDown()
	{
		return SelectMerchantDropDown;
	}
	
	public WebElement AccountNumberField()
	{
		return AccountNumberField;
	}
	
	public WebElement ShortNameField()
	{
		return ShortNameField;
	}
	public WebElement SubmitBtn()
	{
		return SubmitBtn;
	}

}
