package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class OtherInsuranceReview {



	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(xpath="//div[@node_name='pyCaseActionArea']//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;
	
	@FindBy(xpath="//li[@title='Update Other Insurance']//span[contains(text(),'Update Other Insurance')]")
	WebElement lnkUpdateOtherInsurance;
	
	@FindBy(xpath="//li[@title='Request Manager/OE Help']")
	WebElement lnkRequestManagerHelp;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	/**
	 * Constructor for the RequestAccumulatorReview class defining the Iframe and the Page Factory  
	 */
	public OtherInsuranceReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToRequestManagerHelp
	 * #Description: This functionality navigates to the Request Manager Help from the Other Actions Section.
	 * Type: Textbox
	 */
	public boolean navigateToRequestManagerHelp()
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "Request Manager/OE Help", "OtherInsurancePage", "Request Manager Help");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToUpdateOtherInsurance
	 * #Description: This functionality navigates to the Update Other Insurance from the Other Actions Section.
	 * Type: Textbox
	 */
	public boolean navigateToUpdateOtherInsurance()
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "Update Other Insurance", "OtherInsurancePage", "Request Manager Help");
	}
	
	@FindBy(id="ReasonForContact")
	WebElement ReasonForContact;
	
	public boolean selectReasonForContact() throws InterruptedException {
		if(utils.selectDropDownbyIndex(ReasonForContact, 1, "OtherInsurancePage", "ReasonForContact"))
			return utils.clickAnelemnt(this.btnSubmit, "OtherInsuranceReview", "Submit");
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSubmit
	 * #Description: This functionality performs click on the submit button on the View Insurance page
	 * Type: Textbox
	 */
	public boolean clickSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "OtherInsuranceReview", "Submit");
		
	}

}













