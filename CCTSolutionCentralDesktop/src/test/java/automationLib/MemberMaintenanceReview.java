package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class MemberMaintenanceReview {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(id="PegaGadget2Ifr")	
	private WebElement Iframeelement;


	public MemberMaintenanceReview() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	@FindBy(id="ReasonForContact")	
	private WebElement reasonForContact;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:selectReasonForContact
	 * #Description: This functionality selects 'Reason for Contact' in MemberMaintenanceReview page
	 * #Argument:ReasonforContact
	 * Type:Dropdown
	 * Keys:Update Address#Update Contact Preferences#Update Digital ID Preferences#Update Email#Update Phone Number#Update Race and Ethnicity
	 */
	public boolean selectReasonForContact(String[] args)
	{
		return utils.selectDropDownbyVisibleString(this.reasonForContact, args[0], "MemberMaintenanceReview", "ReasonForContact");
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement BtnSubmit;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:clickOnSubmit
	 * #Description: This method clicks on submit button in MemberMaintenanceReview page.
	 * Type:Textbox 
	 */
	public boolean clickOnSubmit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.BtnSubmit, "MemberMaintenanceReview", "Button to click Submit");
	}


	@FindBy(xpath="//*[@data-test-id='201803152154500342622740']")
	WebElement StatusMessage;

	public boolean verifyStatusMessage(String args[]) {
		return utils.validateLabel(StatusMessage, args[0]);
	}

	@FindBy(xpath="//table[@pl_prop='.TaggedMemberMaintenance']")
	WebElement tblItemsUpdated;
	/**
	 * To verify the table values on the preference update made by user in member maintenance page
	 * @param tablevalues
	 * @return
	 */
	public boolean verifyItemsUpdatedDuringMMReview(String[] tablevalues)
	{
		utils.scrolltomiddle();
		return utils.validatetablerowbasedonvalues(tblItemsUpdated, tablevalues);
	}
}

