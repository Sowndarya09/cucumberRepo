package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ErrorLogger;
import utils.SeleniumUtilities;
/**
 * Class for Base Objects of Exit Interaction Page from Other Actions Page
 * @author AF02876
 *
 */
public class ExitInteraction {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	public ExitInteraction()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement buttonMOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement dropDownoTherActionExitInteraction;
	@FindBy (className="anthem_theme_header")	
	private WebElement headerForThePage;
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Submit']")	
	private WebElement buttonSubmit;

	@FindBy (id="CancelReason")	
	private WebElement selectDropDown;
	@FindBy (id="CancelNotes")	
	private WebElement sTextCommentsOther;

	@FindBy(xpath="//textarea[@data-test-id='20170524181312011868128']")
	private WebElement txtotherDescription;

	public WebElement getHeaderForThemePage() {
		return headerForThePage;
	}

	public WebElement getBtnSubmit() {
		return buttonSubmit;
	}

	public WebElement getSelectDropDown() {
		return selectDropDown;
	}

	public WebElement getsTextCommentsOther() {
		return sTextCommentsOther;
	}

	/**
	 * Entering Value
	 * @return
	 */
	public boolean setOthersValue(String sData)
	{
		return utils.enterTextinAnelemnt(this.getsTextCommentsOther(), sData, "Exit Interaction", "Text Button");
	}

	public boolean clickButtonSubmitButton()
	{
		if(utils.clickAnelemnt(this.getBtnSubmit(), "Exit Interaction ", "Button to Click"))
			return !utils.isAlertPresent();
		return false;
	}

	public boolean selectDropDown(String sReason)
	{
		return utils.selectDropDownbyVisibleString(getSelectDropDown(), sReason, "Exit Interaction ", "Select Dropdown");
	}


	public boolean checkHeaderExitInteraction()
	{
		return utils.validateLabel(headerForThePage, "Exit Interaction");
	}

	/**
	 * Navigating from phone/Research to Exit Interaction and Submitting  the result
	 * @param sData : Data Should contain arr[Reason] and arr [1] is optional for entry in others Field
	 * @return
	 */

	public boolean navigateToExitInteractionContactdisconnect()
	{
		if(checkHeaderExitInteraction())
			if(selectDropDown("Contact disconnect"))	
				return clickButtonSubmitButton();
		return false;
	}

	/**
	 * To Select a drop down from the Exit interactions
	 * @return
	 */
	public boolean navigateToExitInteractionContactfailedvalidationSubmit()
	{
		if(checkHeaderExitInteraction())
			if(selectDropDown("Contact failed validation"))	
				return clickButtonSubmitButton();
		return false;
	}

	/**
	 * Enter Data for Others Dropdown in Exit Interaction 
	 * @param sData : Data for entering in the Fild 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean navigateToExitInteractionOtherSubmit() throws InterruptedException
	{
		if(checkHeaderExitInteraction())
			if(selectDropDown("Other"))		
				if(setOthersValue("TEST "))
					if (utils.enterTextinAnelemnt(txtotherDescription, "test", "ExitInteraction", "OtherdescriptionText"))
						return clickButtonSubmitButton();
		return false;

	}

	public boolean navigateToExitInteractionNoresponsefromcontactSubmit()
	{
		if(checkHeaderExitInteraction())
			if(selectDropDown("No response from contact"))	
				return clickButtonSubmitButton();
		return false;
	}

	/**
	 *  This functionality select the dropdown values present under reason for exiting field in Exit interaction page
	 * @param args
	 * @return
	 */
	public boolean selectReasonForExiting(String[] args)
	{
		return utils.selectDropDownbyVisibleString(selectDropDown, args[0], "ExitInteraction", "Reason For Exiting");
	}

	@FindBy(id="OtherTopic")
	WebElement txtBxOtherDescription;

	public boolean enterOtherDescription(String[] args)
	{
		return  utils.enterTextinAnelemnt(txtBxOtherDescription, args[0], "ExitInteraction", "Description");
	}

	/**
	 *  This functionality select the dropdown values present under Call Trasfer to field in Exit interaction page
	 */
	@FindBy(id="CallTransferTo")
	WebElement CallTransferTo;

	public boolean selectCallTransferTO(String[] args)
	{
		return utils.selectDropDownbyVisibleString(CallTransferTo, args[0], "ExitInteraction", "Call Transfer to");
	}

	/**
	 *  This functionality performs submit action present in Exit interaction page
	 * @return
	 */

	public boolean clickbtnSubmit()
	{
		return utils.clickAnelemnt(this.getBtnSubmit(), "Exit Interaction ", "Button to Click");
	}

	public boolean validateOptionsInReasonForExiting(String[] args) {
		ArrayList<String> valuestobechecked = new ArrayList<String>();

		for(String value:args)
			valuestobechecked.add(value);

		return utils.checkvaluesinDropDown(selectDropDown, valuestobechecked);
	}

}








