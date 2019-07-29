package automationLib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class MemberComposite_SecureMessageSection {
	WebDriverWait wait;
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	public MemberComposite_SecureMessageSection() {

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		// PageFactory.initElements(Driver.getPgDriver(), this);

		{
			utils.refreshthepage();
		}
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
		} catch (Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}
	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;
	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement2;


	// Guided Dialog message

	@FindBy(id = "DialogContent")
	WebElement labelGuidedDialog;

	// Checkbox common methods


	public boolean verifyGuidedDialogText() {
		String message = this.labelGuidedDialog.getText().toString();
		return utils.isvalueMatch_contain(message,
				"Handle with care. Use the HIPAA Verification & Disclosure Guide link if you need help understanding what you can disclose");
	}


	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//following::h3[text()='Secure Message']")
	WebElement SecureMessageSection;

	@FindBy(xpath="//label[@data-test-id='20181213190608019736455-Label']")
	WebElement FollowUpDateQuestion;

	@FindBy(id="UpdateWithFollowUpDateYes")
	WebElement FollowUpDateYes;

	@FindBy(id="UpdateWithFollowUpDateNo")
	WebElement FollowUpDateNo;

	@FindBy(xpath="//div[@id='$PpyWorkPage$pUpdateWithFollowUpDateError']/span")
	WebElement FollowUpDateErrorMsg;

	@FindBy(xpath="//span[text()='Follow Up Date']")
	WebElement FollowUpDateLabel;

	@FindBy(xpath="//label[@data-test-id='20181213190845033219059-Label'][@for='DueDate']/strong")
	WebElement FollowUpDateRequired;

	@FindBy(id="DueDate")
	WebElement FollowUpDateValue;

	@FindBy(xpath="//span[text()='Follow Up Time']")
	WebElement FollowUpTimeLabel;

	@FindBy(xpath="//label[@data-test-id='20181213190845033219059-Label'][@for='DueTime']/strong")
	WebElement FollowUpTimeRequired;

	@FindBy(id="DueTime")
	WebElement FollowUpTimeValue;

	@FindBy(xpath="//span[@id='$PpyWorkPage$pDueTimeSpan']/img")
	WebElement FollowUpTimePicker;

	@FindBy(xpath="//a[text()='Apply']")
	WebElement FollowUpTimeApply;

	@FindBy(xpath="//span[text()='TimeZone']")
	WebElement TimeZoneLabel;

	@FindBy(xpath="//label[@data-test-id='20181213190845033219059-Label'][@for='TimeZone']/strong")
	WebElement TimeZoneRequired;

	@FindBy(id="TimeZone")
	WebElement TimeZoneValue;

	@FindBy(xpath="//label[@for='SMFollowUpDate']")
	WebElement LocalFollowUpDateTimeLabel;

	@FindBy(xpath="//span[@data-test-id='20181213190845033219059']")
	WebElement LocalFollowUpDateTimeValue;	

	@FindBy(xpath="//span[text()='Secure Message Follow Up Date Activity']")
	WebElement SMFollowUpDateActivity;

	@FindBy(xpath="//table[@pl_prop='.SMActivityLog']")
	WebElement SMFollowUpActivityLog;

	@FindBy(id="Notes")
	WebElement NotesBox;

	@FindBy(id="//div[@data-test-id='20181226181222027689251']")
	WebElement NotesInstructionalText;

	@FindBy(id="$PpyWorkPage$pNotes_counter")
	WebElement NotesBoxCharacterCount;

	@FindBy(xpath="//button[@data-test-id='201812131910100393125589']")
	WebElement SaveButton;


	public static String getInteractionID;
	
	/**
	 * validateSecureMessageSection - This Method verify the secure message tab is present in member composite page for SM interactions.
	 * @return
	 */

	public boolean validateSecureMessageSection()
	{
		InteractionHeader IH =new InteractionHeader();
		getInteractionID = IH.getInteractionID();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		String Actual = SecureMessageSection.getText();
		return utils.isvalueMatch_compareto(Actual, "Secure Message");

	}
	
	/**
	 * verifyFollowUpDateQuestion - This Method validates the question for follow up date to displayed in Secure Message tab.
	 * @return
	 */

	public boolean verifyFollowUpDateQuestion()
	{
		String Actual =FollowUpDateQuestion.getText();
		System.out.println(Actual);
		return utils.isvalueMatch_compareto(Actual,"Do you want to update Secure Message with Follow Up Date?(Required)");
	}

	/**
	 * enterFollowUpDateChoice -  This Methods select the choice as Yes or No for follow up date question based on user input.
	 * @param args
	 * @return
	 */
	public boolean enterFollowUpDateChoice(String[] args)
	{
		if ((args[0]).trim().equalsIgnoreCase("Yes")) {
			return utils.clickAnelemnt(FollowUpDateYes, "MemberComposite_SecureMessageSection", "FollowUpDateYes");
		} else if ((args[0]).trim().equalsIgnoreCase("No")) {
			return utils.clickAnelemnt(FollowUpDateNo, "MemberComposite_SecureMessageSection", "FollowUpDateNo");
		}
		return false;
	}
	
	/**
	 * validateFollowUpDateErrorMessage - This Method validate the follow up Date error message when user click wrap up button without saving details for Follow up date provided as "Yes"
	 * @return
	 */

	public boolean validateFollowUpDateErrorMessage()
	{
		String Actual =FollowUpDateErrorMsg.getText();
		String Expected ="Follow Up Date has not been saved! Either save the follow up date or change your selection to \"No\" and Wrap Up.";
		System.out.println("The Actual value is "+Actual);
		System.out.println("The Expected value is "+Expected);
		return utils.isvalueMatch_compareto(Actual, Expected);
	}

	/**
	 * validateFollowUpDateChoiceAsNoByDefault - This method validates follow up Date choice will be marked as No by default when users lands on secure Message in member composite page.
	 * @return
	 */
	public boolean validateFollowUpDateChoiceAsNoByDefault()
	{
		String Acutal = FollowUpDateNo.getAttribute("checked");
		return utils.isvalueMatch_compareto(Acutal, "true");
	}

	/**
	 * enterFollowUpDateValue - This Method allows to enter the follow up date value provided by user.
	 * @param args
	 * @return
	 */
	public boolean enterFollowUpDateValue(String[] args)
	{
		if(!utils.isProxyWebelement(FollowUpDateLabel));
		if(!utils.isProxyWebelement(FollowUpDateRequired));
		return utils.enterTextinAnelemnt(this.FollowUpDateValue, args[0], "MemberComposite_SecureMessageSection", "Follow up Date value is entered");
	}
	
	/**
	 * enterFollowUpTimeValue - This Method allows to enter the follow up time value provided by user.
	 * @param args
	 * @return
	 */

	public boolean enterFollowUpTimeValue(String[] args)
	{
		if(!utils.isProxyWebelement(FollowUpTimeLabel));
		if(!utils.isProxyWebelement(FollowUpTimeRequired));
		return utils.enterTextinAnelemnt(this.FollowUpTimeValue, args[0], "MemberComposite_SecureMessageSection", "Follow up Timie value is entered");
	}
	
	/**
	 * enterFollowUpTimeValue - This method will perform the selection of default time available in time picker in follow up time field value.
	 * @return
	 */

	public boolean enterFollowUpTimeValue()
	{
		if(!utils.isProxyWebelement(FollowUpTimeLabel));
		if(!utils.isProxyWebelement(FollowUpTimeRequired));
		if(utils.clickAnelemnt(FollowUpTimePicker,  "MemberComposite_SecureMessageSection", "Follow up Timie value is entered"));
		if(utils.clickAnelemnt(FollowUpTimeApply,"MemberComposite_SecureMessageSection", "Follow up Timie value is entered"));
		return true;
	}
	
	/**
	 * selectTimeZoneValue - This method selects the dropdown based on user keyed in from the Time zone value in secure message tab.
	 * @param args
	 * @return
	 */

	public boolean selectTimeZoneValue(String[] args)
	{
		if(!utils.isProxyWebelement(TimeZoneLabel));
		if(!utils.isProxyWebelement(TimeZoneRequired));
		return utils.selectDropDownbyVisibleString(TimeZoneValue, args[0],"MemberComposite_SecureMessageSection", "time zone is selected");
	}
	
	/**
	 * validateLocalFollowUpDateTimeValue - This Method verify the field label Local follow up Date Time value is present and print the value in console"
	 * @return
	 */

	public boolean validateLocalFollowUpDateTimeValue()
	{
		if(!utils.isProxyWebelement(LocalFollowUpDateTimeLabel));
		{
			utils.waitforpageload();
			System.out.println(LocalFollowUpDateTimeValue.getText());
			return true;
		}
	}
	
	/**
	 * enterNotesInSecureMessageSection - This methods allows to enter the notes in the text box provided by the user.
	 * @param notes
	 * @return
	 */

	public boolean enterNotesInSecureMessageSection(String[] notes) {
		return utils.enterTextinAnelemnt(this.NotesBox, notes[0], "MemberComposite_SecureMessageSection", "Notes is entered");
		//return !utils.isProxyWebelement(NotesInstructionalText);
	}
	
	/**
	 * clickSaveButton - This method will perform a click on the save button present in secure message tab.
	 * @return
	 */

	public boolean clickSaveButton()
	{
		return	utils.clickAnelemnt(SaveButton, "MemberComposite_SecureMessageSection", "SaveButton");
	}
	
	/**
	 * verifySMFollowUpDateActivity - This method will verify the label of SM follow up Date Activity present in secure message tab.
	 * @return
	 */

	public boolean verifySMFollowUpDateActivity()
	{
		return !utils.isProxyWebelement(SMFollowUpDateActivity);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyColHeadersInSMactivityLog
	 * #Description:This method verifies the column headers in the SM activity log in wrap up page
	 * Type:TextBox
	 */
	
	/**
	 * verifyColHeadersInSMFollowUpDateActivity - This method will verify the list of column header present in SM follow up Date activity section in SM tab.
	 * @return
	 */

	public boolean verifyColHeadersInSMFollowUpDateActivity(){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.SMFollowUpActivityLog);
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.SMFollowUpActivityLog);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Create Date");
		valuesGivenManual.add("Created By");
		valuesGivenManual.add("Follow Up Needed");
		valuesGivenManual.add("Follow Up Date");
		valuesGivenManual.add("Notes");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			return false;
		}
	}



}