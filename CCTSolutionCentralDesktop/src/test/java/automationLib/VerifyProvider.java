package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class VerifyProvider {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	public VerifyProvider() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		// PageFactory.initElements(Driver.getPgDriver(), this);
		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		// waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	// Objects .....................

	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id = "IsProviderNameVerified")
	WebElement chkbxVerificationProviderNameverify;

	@FindBy(xpath = "//*[text()='Provider Verification']")
	WebElement providerVerificationHeader;

	@FindBy(xpath = "//label[@for='ProviderName']/parent::div//span")
	WebElement labelVerificationfullname;

	@FindBy(xpath = "//label[@for='TIN']/parent::div//span")
	WebElement labelVerificationTIN;

	@FindBy(xpath = "//label[@for='PhoneNumber']/parent::div//span")
	WebElement labelVerificationPhoneNumber;

	@FindBy(id = "IsProviderNameVerified")
	WebElement chkbxVerificationProvidernameverify;

	@FindBy(id = "IsPhoneNumberVerified")
	WebElement chkbxVerificationPhoneNumberverify;

	@FindBy(id = "IsTINVerified")
	WebElement chkbxVerificatiTINverify;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement btnVerificationSubmit;

	public boolean ValidateProviderVerifyPage() {

		utils.waitforpageload();
		return utils.validateHeader(this.providerVerificationHeader, "Provider Verification");
	}

	public boolean verifyProviderName(String args[]) {

		String fullname = this.labelVerificationfullname.getText().toString();
		String expected = args[0];
		return utils.isvalueMatch_contain(fullname, expected);
	}

	public boolean verifyProviderTIN(String args[]) {

		String fullname = this.labelVerificationTIN.getText().toString();
		String expected = args[0];
		return utils.isvalueMatch_contain(fullname, expected);
	}

	public boolean verifyProviderPhoneNumber(String args[]) {

		String fullname = this.labelVerificationPhoneNumber.getText().toString();
		String expected = args[0];
		return utils.isvalueMatch_contain(fullname, expected);
	}

	public boolean ValidateDetailsPresent() {
		return !utils.isProxyWebelement(chkbxVerificationProviderNameverify);
	}

	public boolean clickchkbxVerificationProvidernameverify(String[] providername) {

		this.verifyProviderName(providername);
		return (utils.clickAnelemnt(this.chkbxVerificationProvidernameverify, "ProviderVerify", "Provider name verify checkbox"));
	}

	public boolean clickchkbxVerificationProviderTIN(String[] TIN) {

		this.verifyProviderTIN(TIN);
		return (utils.clickAnelemnt(this.chkbxVerificatiTINverify, "ProviderVerify", "Provider name verify checkbox"));

	}

	public boolean clickchkbxVerificationProviderPhoneNumber(String[] providername) {

		this.verifyProviderPhoneNumber(providername);
		return (utils.clickAnelemnt(this.chkbxVerificationPhoneNumberverify, "ProviderVerify", "Provider name verify checkbox"));
	}

	public boolean verifyProviderdetails(String[] args) {

		if (this.ValidateProviderVerifyPage()) {
			if (this.ValidateDetailsPresent()) {
				for (int i = 0; i < args.length; i++) {
					if (args[i].contains("ProviderName")) {
						String s1 = args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s = new String[] { s1 };
						// s = s.substring(0, s.indexOf(";"));

						if (this.clickchkbxVerificationProvidernameverify(s)) {
							if (i == args.length - 1) {
								// JavascriptExecutor jse =
								// (JavascriptExecutor)Driver.pgDriver;
								// jse.executeScript("scroll(0, 250);");
								if (utils.clickAnelemnt(btnVerificationSubmit, "Provider Verify", "submit button "))
									return true;
							}
							continue;
						} else
							break;

					} else if (args[i].contains("TIN")) {
						String s1 = args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s = new String[] { s1 };

						if (this.clickchkbxVerificationProviderTIN(s)) {
							if (i == args.length - 1) {
								// JavascriptExecutor jse =
								// (JavascriptExecutor)Driver.pgDriver;
								// jse.executeScript("scroll(0, 250);");
								if (utils.clickAnelemnt(btnVerificationSubmit, "Provider Verify", "submit button "))
									return true;
							}
							continue;
						} else
							break;
					} else if (args[i].contains("PhoneNumber")) {
						String s1 = args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s = new String[] { s1 };
						if (this.clickchkbxVerificationProviderPhoneNumber(s)) {

							if (i == args.length - 1) {
								// JavascriptExecutor jse =
								// (JavascriptExecutor)Driver.pgDriver;
								// jse.executeScript("scroll(0, 250);");
								if (utils.clickAnelemnt(btnVerificationSubmit, "Provider Verify", "submit button "))
									return true;
							}
							continue;
						} else
							break;
					}

					else {
						err.logcommonMethodError("ProviderVerify", "verifyProviderdetails");
						System.out.println(
								" Sorry, there is no attribute present as...please chose the attributes ProviderName or TIN or PhoneNumber"
										+ args[i]);
					}

				}

				err.logcommonMethodError("Provider Verify", "verifyProviderdetails");
				System.out.println("Not to able to complete verification");
				return false;
			}
			err.logcommonMethodError("Provider Verify", "verifyProviderdetails");
			return false;
		}
		err.logcommonMethodError("Provider Verify", "verifyProviderdetails");
		return false;

	}

	public boolean clickCheckBoxProviderName()
	{
		return utils.clickAnelemnt(this.chkbxVerificationProvidernameverify, "ProviderVerify", "Provider name verify checkbox");
	}

	public boolean clickCheckBoxTIN()
	{
		return utils.clickAnelemnt(this.chkbxVerificatiTINverify, "ProviderVerify", "Provider name verify checkbox");
	}

	public boolean verifyProviderDetailsWithoutData()
	{
		try
		{
			utils.waitforpageload();
			boolean flag = false;
			if(clickCheckBoxProviderName())
				if(clickCheckBoxTIN())
					if( utils.clickAnelemnt(btnVerificationSubmit, "VerifyMember", "Submit"))
						flag=true;
			if(flag) {
				blogger.loginfo("PASS: verifyProviderDetailsWithoutData successful");
				return true;
			}
			else {
				blogger.loginfo("FAIL: verifyProviderDetailsWithoutData not successful");
				return false;
			}
		}catch(Exception e)
		{
			err.logError("VerifyProvider", "Provider Verification");
			return false;
		}
	}


}
