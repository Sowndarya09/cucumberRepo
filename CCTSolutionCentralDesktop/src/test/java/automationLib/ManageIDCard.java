package automationLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ManageIDCard {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	WebDriverWait wait;
	public ManageIDCard() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		utils.waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}



	@FindBy(xpath="//input[@id='IsSelected']")
	WebElement chkBxSelectAll;

	@FindBy(id="FulfillmentMethod")
	WebElement drpDownselectFulfillmentMethod;

	@FindBy(xpath="//div[text()='Submit']")
	WebElement btnSubmit;

	@FindBy(xpath="//button[@data-test-id='2016031917365406777346']//div[text()='Submit']")
	WebElement btnsubmit;
	
	@FindBy(xpath="(//div[text()='Submit'])[2]")
	WebElement btnSubmitInOrderIDCardTab;


	@FindBy(xpath="//button[@data-test-id='2016110211075709917301']")
	WebElement btnOrderIdcards;

	@FindBy(xpath="//label[@for='pyFullName']/parent::div//span")
	WebElement labelVerificationfullname;

	@FindBy(id="IsMemberNameVerified")
	WebElement chkbxVerificationMembernameverify;

	@FindBy(xpath="//div[contains(text(),'Order ID Card initiated successfully')]")
	WebElement txtSuccessMessage;

	@FindBy(xpath="//div[contains(text(),'System Error- ID Card cannot be initiated')]")
	WebElement txtErrorMessage;

	@FindBy(xpath="//table[@pl_prop='.IDCardInfo']")
	private WebElement memeberNametable;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSelectAllCheckBox
	 * #Description: This functionality performs click action in the Select All checkbox
	 * Type: Textbox
	 */
	public boolean clickSelectAllCheckBox() throws InterruptedException
	{
		Thread.sleep(2000);
		return utils.clickAnelemnt(this.chkBxSelectAll, "ManageIDCards", "Select All Check box");
	}



	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectMemberNameCheckBox
	 * #Description: This functionality gets the input name from the user and selects the respective check box of that member name.
	 * #Argument: membername
	 * Type: Textbox
	 */
	public boolean selectMemberNameCheckBox(String[] membername)
	{
		String xpath = "//span[contains(text(),'"+membername[0]+"')]//ancestor::td[@headers='a3']//preceding-sibling::td[@headers='a2']//input[@type='checkbox']";
		System.out.println("xpath is: " + xpath);
		utils.waitforpageload();
		Driver.pgDriver.findElement(By.xpath(xpath)).click();
		return true;
	}



	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectFulfillmentMethodOption
	 * #Description: This functionality selects the fulfillment method option in the manage id card page 
	 * #Argument: selectoption
	 * keys: Select#Mail#Digital
	 */
	public boolean selectFulfillmentMethodOption(String[] selectoption)
	{
		return utils.selectDropDownbyVisibleString(drpDownselectFulfillmentMethod, selectoption[0], "ManageIDCard", "Fulfillment option");
	}
	
	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;
	
	public void gotoLastIframe(){
		System.out.println("1");
		Driver.getPgDriver().switchTo().defaultContent();
		System.out.println("2");
		
		int i=this.iframes.size();
		System.out.println(i);
		Driver.getPgDriver().switchTo().frame(i-1);
		System.out.println("##########");
	}
	
	public boolean isMemberCompositeReached(){
		utils.waitforpageload();
		try {
			gotoLastIframe();
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			err.logError(e, "unhandled  alert error in switiching frame");
			e.printStackTrace();
		}
		return !utils.isProxyWebelement(tabMbrCompositeMember);

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickBtnSubmit
	 * #Description: This functionality performs the click action on the submit button in the manage id card page
	 * Type: Textbox
	 */

	public boolean clickBtnSubmit()
	{
		WebElement element = btnSubmit;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		//return utils.clickAnelemnt(this.btnSubmit, "ManageIDCard", "Submit");
		//utils.scrolltomiddle();
		if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment and Billing Action", "Submit Button"))
			return isMemberCompositeReached();
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickBtnSubmit
	 * #Description: This functionality performs the click action on the submit button in the manage id card page
	 * Type: Textbox
	 */

	public boolean clickSubmit()
	{
		WebElement element = btnsubmit;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		//return utils.clickAnelemnt(this.btnSubmit, "ManageIDCard", "Submit");
		//utils.scrolltomiddle();
		if(utils.clickAnelemnt(this.btnsubmit, "ManageID Card", "Submit Button"))
			return isMemberCompositeReached();
		return false;
	}

	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickBtnOrderIdCards
	 * #Description: This functionality performs the click action on the order id card button in the manage id card page
	 * Type: Textbox
	 */

	public boolean clickBtnOrderIdCards()
	{
		return utils.clickAnelemnt(this.btnOrderIdcards, "Manage ID Card", "Order Id cards");
	}

	
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifySuccessMessage
	 * #Description: This functionality verifies the success message displayed once user clicks on the Order ID card button.
	 * Type: Textbox
	 */
	public boolean verifySuccessMessage()
	{
		System.out.println("Entered into Method");
		String Succmessage =this.txtSuccessMessage.getText();
		System.out.println("Success Message displayed is: "+ Succmessage);
		String validateMessage = new String(Succmessage);
		System.out.println("Validate Message displayed is: "+ validateMessage);
		Assert.assertTrue(Succmessage.equals(validateMessage));
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyErrorMessage
	 * #Description: This functionality verifies the error message displayed once user clicks on the Order ID card button.
	 * Type: Textbox
	 */
	public boolean verifyErrorMessage()
	{
		System.out.println("Entered into Method");
		String Errormessage =this.txtErrorMessage.getText();
		System.out.println("Error Message displayed is: "+ Errormessage);
		String validateMessage = new String(Errormessage);
		System.out.println("Validate Message displayed is: "+ validateMessage);
		Assert.assertTrue(Errormessage.equals(validateMessage));
		return true;
	}

	@FindBy(xpath="//button[contains(@name,'OrderedIDInLast14Days_pyWorkPage')]//div[@class='pzbtn-mid']")
	WebElement btnYesInIDCard;

	@FindBy(xpath="//button[@data-test-id='201801110348330757144864']//div[@class='pzbtn-mid']")
	WebElement btnNoInIDCard;

	@FindBy(xpath="//a[contains(text(),'Clarity')]")
	WebElement lnkClarity;

	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionpzModalTemplateB']//button[@id='container_close']")
	WebElement btnCloseIcon;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickYesInTheIDCardPopUp
	 * #Description: This functionality performs click action on the Yes button in the ID Card Pop up section
	 * Type: Textbox
	 */
	public boolean clickYesInTheIDCardPopUp()
	{
		if(!utils.isProxyWebelement(btnYesInIDCard))
			return utils.clickAnelemnt(this.btnYesInIDCard, "ManageIDCard", "Yes button");
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickNoInTheIDCardPopUp
	 * #Description: This functionality performs click action on the No button in the ID Card Pop up section
	 * Type: Textbox
	 */
	public boolean clickNoInTheIDCardPopUp()
	{
		return utils.clickAnelemnt(this.btnNoInIDCard, "ManageIDCard", "No button");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickClarityLink
	 * #Description: This functionality performs click action on the Clarity Link in the ID Card page
	 * Type: Textbox
	 */
	public boolean clickClarityLink()
	{
		return utils.clickAnelemnt(this.lnkClarity, "ManageIDCard", "Clarity Link");
	}

	@FindBy(xpath="//label[contains(text(),'Manage ID Card')]")
	WebElement headerManageIDCard;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigatedToClarityLink
	 * #Description: This functionality clicks the clarity link and navigate to the child window and gets the title and then navigates back to the parent window.
	 * Type: Textbox
	 */
	public boolean navigatedToClarityLink()
	{
		String parent = Driver.pgDriver.getWindowHandle();
		if(utils.validateHeader(this.headerManageIDCard, "Manage ID Card")){
			if(this.lnkClarity.isDisplayed())
			{
				utils.clickAnelemnt(this.lnkClarity, "ManageIDCard", "Clarity Link");
				System.out.println(("Clarity Is Clicked.."));
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				System.out.println("No.ofwindows"+handles.size());
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				Driver.pgDriver.switchTo().window(childWindow);
				String title = Driver.pgDriver.getTitle();
				System.out.println("Title of the Child Window is: "+title);
				if(title.contains("Clarity Software Solutions"))
				{
					System.out.println("Clarity Is Launched and the title is: "+ title); 
					return true;
				}else
				{
					err.logcommonMethodError("ManageIDCard", "Error in switching to childwindow-Clarity");
					return false;
				}
			}
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCloseIcon
	 * #Description: This functionality performs click action on the Close icon in the ID Card pop -up.
	 * Type: Textbox
	 */
	public boolean clickCloseIcon()
	{
		return utils.clickAnelemnt(this.btnCloseIcon, "ManageIDCard", "Close Icon");
	}

	@FindBy(xpath="//*[@data-test-id='2017062617535909721302']")
	WebElement EnrolledInIDCards;

	public boolean verifyChooseFullfilment(String[] args) throws Exception {
		boolean flag = false;
		String s;
		if(utils.isvalueMatch_compareto(args[0], "")) {
			s = drpDownselectFulfillmentMethod.getAttribute("disabled");
			flag = utils.isvalueMatch_compareto(s, "true");
		}else if(utils.isvalueMatch_compareto(args[0], "No")) {
			flag = utils.validateValueinelement(this.EnrolledInIDCards, "No");
		}else if(utils.isvalueMatch_compareto(args[0], "Yes")){
			flag = utils.validateValueinelement(this.EnrolledInIDCards, "Yes");
		}

		return flag;
	}


	public boolean verifyOrderIDCardButtonDisabled() {
		String value =btnOrderIdcards.getAttribute("disabled");
		return utils.isvalueMatch_compareto(value, "true");
	}

	@FindBy(xpath="//*[@data-test-id='20161103134931086340536']")
	WebElement ErrorMessage;

	public boolean verifyErrorMessage(String[] args) {
		return utils.validateLabel(ErrorMessage, args[0]);
	}

	@FindBy(xpath="//*[text()='Other actions ']")
	WebElement OtherActions;

	@FindBy(xpath="//*[text()='Update ID Card Preference...']")
	WebElement UpdateIDCardPreference;

	public boolean navigateToUpdateIDCardPrefInOtherActions() {
		if(utils.clickAnelemnt(OtherActions, "ManageIDCard", "OtherActions")) 
			return utils.clickAnelemnt(UpdateIDCardPreference, "ManageIDCard", "UpdateIDCardPreference");
		return false;
	}

	@FindBy(xpath="//*[@data-test-id='20161103134931086139307']")
	WebElement SuccessMessage;

	public boolean verifySuccessMessage(String[] args) {
		utils.waitforpageload();
		return utils.validateLabel(SuccessMessage, args[0]);
	}

	@FindBy(xpath="//div[contains(text(),'Complete the')]")
	WebElement DialogMessage;

	public boolean verifyDialogMessage(String[] arg) throws Exception
	{			
		return utils.validateValueinelement(this.DialogMessage, arg[0]);
	}

	@FindBy(xpath="//a[text()='Send Email']")
	WebElement SendEmail;

	@FindBy(xpath="//*[@data-test-id='2018052217383103598310']")
	WebElement ErrorMsgNoCurrentCardsAvailable;

	public boolean clickSendEmail()
	{
		if(utils.isProxyWebelement(ErrorMsgNoCurrentCardsAvailable))
			return utils.clickAnelemnt(SendEmail, "ManageIDCard", "SendEmail");
		else
			return utils.setDataIssue(ErrorMsgNoCurrentCardsAvailable.getText());
	}

	@FindBy(xpath="//input[@data-test-id='2018053010505505844771']")
	WebElement EmailID;

	public boolean validatePrePopulatedEmailID(String[] arg)
	{
		String ExpectedEmail = arg[0];
		String actualEmail = utils.getValuefromTextBox1(EmailID, "ManageIDCard", "EmailID");
		//System.out.println(actualEmail);
		return utils.isvalueMatch_compareto(actualEmail, ExpectedEmail);
	}

	@FindBy(xpath="//div[text()='Send']")
	WebElement SendButton;

	public boolean clickSendButton()
	{
		return utils.clickAnelemnt(SendButton, "ManageIDCard", "SendButton");
	}

	@FindBy(xpath="//span[@id='TABSPAN']/span/label[contains(text(),'Virtual ID Card')]")
	WebElement VirtualIDCard;

	public boolean validateVirutalIDcardTab()
	{
		return !utils.isProxyWebelement(VirtualIDCard);
	}

	@FindBy(xpath="//div[contains(text(),'Email has been sent')]")
	WebElement EmailSuccessMsg; 

	public boolean validateEmailSuccessMsg() throws InterruptedException
	{
		System.out.println("Method is entered");
		utils.waitforpageload();
		Thread.sleep(2000);
		String ExpectedSuccessMsg ="Email has been sent";
		System.out.println("Email Success Msg is verified");
		return utils.validateLabel(EmailSuccessMsg, ExpectedSuccessMsg);

	}

	@FindBy(xpath="//div[@id='modaldialog_hd']/button[@id='container_close']")
	WebElement closeButton;

	public boolean clickCloseButton()
	{
		return utils.clickAnelemnt(closeButton, "ManageIDCard", "closeButton");
	}

	@FindBy(xpath="//a[@tabtitle='Order ID Card']")
	WebElement OrderIDCard;

	public boolean navigateToOrderIDCardTab()
	{
		return utils.clickAnelemnt(OrderIDCard,"ManageIDCard", "Order ID Card");
	}

	@FindBy(xpath="xpath=//div[@data-test-id='20161103134931086340536']")
	private WebElement MemberInfocusErrorMessage;


	public boolean verifyMemberInfocusErrorMessage() throws Exception
	{			
		return utils.validateValueinelement(this.MemberInfocusErrorMessage, "Member in focus is not participating in Digital ID Cards");
	}


	public boolean verifyFulfillmentMethodIsDisableForDepentantMember()
	{			
		return !drpDownselectFulfillmentMethod.isEnabled();
	}

	@FindBy(xpath="//button[@data-test-id='201801110348330757143647']")
	WebElement btnYesInWarningMessage;

	public boolean clickYesInWarningMessage()
	{
		return utils.clickAnelemnt(btnYesInWarningMessage, "ManageIDCard", "Yes");
	}

	@FindBy(xpath="//ul[@class='pageErrorList layout-noheader-errors']")
	WebElement ErrorMsg;

	/**Clicks button Submit and Verifies Error Message
	 * 
	 * @return
	 */
	public boolean clickBtnSubmitAndVerifyErrorMessage(String[] args)
	{
		if(utils.clickAnelemnt(this.btnSubmit, "ManageIDCard", "Submit"))
			return utils.validateLabel(ErrorMsg, args[0]);
		return false;
	}

	/**Clicks button Submit and Verifies Alert is displayed
	 * 
	 * @return
	 */
	public boolean clickBtnSubmitAndVerifyAlert() {
		if(utils.clickAnelemnt(this.btnSubmitInOrderIDCardTab, "ManageIDCard", "Submit"))
			return utils.isAlertPresent();
		return false;
	}

	@FindBy(id="ReasonForRequest")
	WebElement drpDownReasonForRequest;

	@FindBy(xpath="(//select[@id='ReasonForRequest'])[2]")
	WebElement drpDownReasonForRequestForOrderIDCard;

	/**Selects Reason for Request
	 * 
	 * @param requestoption
	 * @return
	 */
	public boolean selectReasonForRequestOption(String[] requestoption)
	{
		if(utils.waitForElementToBeVisible(drpDownReasonForRequest))
			return utils.selectDropDownbyVisibleString(drpDownReasonForRequest, requestoption[0], "CompleteManageIDCardReview", "Reason for Request option");
		else
			return utils.selectDropDownbyVisibleString(drpDownReasonForRequestForOrderIDCard, requestoption[0], "CompleteManageIDCardReview", "Reason for Request option");
	}

	@FindBy(id="Notes")
	WebElement txtNotes;

	@FindBy(xpath="(//*[@data-test-id='2016031012554602781281'])[2]")
	WebElement txtNotesForOrderIDCard;

	/**Enter the Notes and Submit
	 * 
	 * @param notes
	 * @return
	 */
	public boolean enterNotes(String[] notes)
	{
		if(utils.waitForElementToBeVisible(txtNotes)) {
			if(utils.enterTextinAnelemnt(txtNotes, notes[0], "ManageIDCard", "Notes"))
				return utils.clickAnelemnt(btnSubmit, "ManageIDCard", "btnSubmit");
		}else {
			if(utils.enterTextinAnelemnt(txtNotesForOrderIDCard, notes[0], "ManageIDCard", "Notes"))
				return utils.clickAnelemnt(btnSubmitInOrderIDCardTab, "ManageIDCard", "btnSubmit");
		}

		return false;

	}
	
/*	@FindBy(id="ReasonForRequest")
	WebElement drpDownReasonForRequest;*/
	
	public boolean selectReasonForRequest(String[] args) throws InterruptedException
	{
		drpDownReasonForRequest.isDisplayed();
		Thread.sleep(3000);
		WebElement element = drpDownReasonForRequest;
	   	((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.selectDropDownbyVisibleString(drpDownReasonForRequest, args[0], "ManageIDCard", "Reason For Request");
	}


}
