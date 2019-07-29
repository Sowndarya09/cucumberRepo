package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderExitInteration {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();

	public ProviderExitInteration()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		System.out.println("provider Exit interation  constructor");
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		System.out.println("PROVIDER Exit interation frame switched");
	}


	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;


	@FindBy(xpath = "//select[@name='$PpyWorkPage$pCancelReason']")
	WebElement dropdownReasonForExisting;

	@FindBy(xpath = "//button[@title='Complete this assignment']")
	WebElement btnSubmit;

	public WebElement ClickReasonForExistingButton(){			
		return dropdownReasonForExisting;
	}

	public boolean selectContactFailedValidationFromReasonForExisting() {
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(this.ClickReasonForExistingButton(),"Contact failed validation" , "ProviderExitInteration",
				"Drop Down Contact failed validation");

	}

	public boolean clickSubmitButton(){

		return utils.clickAnelemnt(this.btnSubmit, "ProviderExitInteration", "Submit Button");
	}

}


