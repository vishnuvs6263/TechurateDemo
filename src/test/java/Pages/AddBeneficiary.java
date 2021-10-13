package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBeneficiary {
	WebDriver driver;

	public AddBeneficiary(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div[2]/div[1]/a[4]/h2")
	WebElement Transfers;

	public WebElement Transfers() {
		return Transfers;

	}
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/h2")
	WebElement AddBeneficiaryTransfers;

	public WebElement AddBeneficiaryTransfers() {
		return AddBeneficiaryTransfers;

	}
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/h2")
	WebElement internalBeneficiary;

	public WebElement internalBeneficiary() {
		return internalBeneficiary;

	}
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/input")
	WebElement NickNameinternalBeneficiary;

	public WebElement NickNameinternalBeneficiary() {
		return NickNameinternalBeneficiary;

	} 
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/input")
	WebElement AccountNointernalBeneficiary;

	public WebElement AccountNointernalBeneficiary() {
		return AccountNointernalBeneficiary;

	}
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[2]/div[1]/div/input")
	WebElement ConfirmAcNointernalBeneficiary;

	public WebElement ConfirmAcNointernalBeneficiary() {
		return ConfirmAcNointernalBeneficiary;

	} 
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[2]/div[2]/div/input")
	WebElement TransfersLimitInternalBeneficiary;

	public WebElement TransfersLimitInternalBeneficiary() {
		return TransfersLimitInternalBeneficiary;

	} 
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[3]/button/p")
	WebElement SubmitInternalBeneficiary;

	public WebElement SubmitInternalBeneficiary() {
		return SubmitInternalBeneficiary;

	}
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/div[8]/button/p")
	WebElement ConfirmSubmit;

	public WebElement ConfirmSubmit() {
		return ConfirmSubmit;
    }
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div[1]/input")
	WebElement OTP;

	public WebElement OTP() {
		return OTP;
    }
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/button/p")
	WebElement OTPSubmit;

	public WebElement OTPSubmit() {
		return OTPSubmit;
    }
 }