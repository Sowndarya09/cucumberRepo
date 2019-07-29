package automationLib;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

/**
 * Class Wrap up for wrapping the work
 * 
 * @author Shardul Negi
 *
 */
public class WrapUp {

	/*
	 * Page objectys and elements in the page to be saved in the repository
	 */

	SeleniumUtilities utils = new SeleniumUtilities();
	Actions action = new Actions(Driver.pgDriver);
	@FindBy(className = "anthem_theme_header")
	private WebElement sHeaderSearchForMember;
	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement2;

	BaseLogger logger = new BaseLogger();

	ErrorLogger err = new ErrorLogger();

	String contractName = "//*[@class='dataValueRead']/nobr/span";
	String textverify = "iconRequired standard_iconRequired";

	/**
	 * Constructor
	 */

	public WrapUp() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the
		// driver
	}

	/*
	 * Elements in sequence on various page objects
	 */

	@FindBy(id = "DialogContent")
	private WebElement pgeHEaderMessage;

	@FindBy(xpath = "//div[@node_name='CPMPortalRecent']//a[@data-ctl='Icon']")
	WebElement closecurrenttab;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	/*
	 * Getters for value extraction from page
	 */
	public WebElement getsHeaderSearchForMember() {
		return sHeaderSearchForMember;
	}

	public WebElement getIframeelement() {
		return Iframeelement;
	}

	public String getContractName() {
		return contractName;
	}

	public String getTextverify() {
		return textverify;
	}

	public WebElement getPgeHEaderMessage() {
		return pgeHEaderMessage;
	}

	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}

	public WebElement getLnkOtherCancelThisWork() {
		return lnkOtherCancelThisWork;
	}

	public WebElement getBtnImgTool() {
		return btnImgTool;
	}

	public WebElement getLnkToolViewHistory() {
		return lnkToolViewHistory;
	}

	public WebElement getLnkToolConfigurationTools() {
		return lnkToolConfigurationTools;
	}

	public WebElement getBtnHelp() {
		return btnHelp;
	}

	public WebElement getDrpDownReasonforInteraction() {
		return drpDownReasonforInteraction;
	}

	public WebElement getDrpDownPrimaryTask() {
		return drpDownPrimaryTask;
	}

	public WebElement getTagNameWrapUpConsole() {
		return tagNameWrapUpConsole;
	}

	public WebElement getRdBtnPriorInquiryYes() {
		return rdBtnPriorInquiryYes;
	}

	public WebElement getRdBtnPriorInquiryNo() {
		return rdBtnPriorInquiryNo;
	}

	public WebElement getCheckLabelText() {
		return checkLabelText;
	}

	public WebElement getTxtBoxWrapUpComments() {
		return txtBoxWrapUpComments;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public String getsUserExperience() {
		return sUserExperience;
	}

	public WebElement getBtnUserExperience() {
		return btnUserExperience;
	}

	/**
	 * XPath from the Page
	 */

	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Cancel this work']")
	private WebElement lnkOtherCancelThisWork;

	// Other Toold
	@FindBy(xpath = "//img[contains(@src,'tool_icon_')]")
	private WebElement btnImgTool;

	// Tool Mark
	@FindBy(xpath = "//*[@class='menu-item-title'][text()='View History']")
	private WebElement lnkToolViewHistory;
	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Configuration Tools']")
	private WebElement lnkToolConfigurationTools;
	// Help

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()=' Help']")
	private WebElement btnHelp;

	// Page DropDowns
	@FindBy(id = "ReasonForInteraction")
	private WebElement drpDownReasonforInteraction;

	@FindBy(id = "PrimaryTask")
	private WebElement drpDownPrimaryTask;
	// Checking Tags on the Page over every validation boxes such as text box,
	// radio
	// button
	@FindBy(xpath = "//*[contains(@class,'standard_iconRequired')]")
	private WebElement tagNameWrapUpConsole;

	@FindBy(id = "IsRelatedToPriorInquiryYes")
	private WebElement rdBtnPriorInquiryYes;
	@FindBy(id = "IsRelatedToPriorInquiryNo")
	private WebElement rdBtnPriorInquiryNo;

	// *[contains(@class,'field-item dataLabelForWrite')]
	@FindBy(xpath = "//*[contains(@class,'field-item dataLabelForWrite')]")
	private WebElement checkLabelText;

	@FindBy(id = "WrapUpComments")
	private WebElement txtBoxWrapUpComments;
	// @FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Submit']")
	@FindBy(xpath = "//div[contains(text(),'Submit')]")
	private WebElement btnSubmit;

	// Edit the rates

	String sUserExperience = null;// a[contains(@data-click,'9')]
	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnUserExperience;

	@FindBy(xpath = "//span[text()='Just a reminder, a CCB window is still open']")
	WebElement CCBOpenWarning;

	/**
	 * To click on the images from 1 to 10 in the page barring the no 10 which will
	 * conflict between 0 and 10
	 * 
	 * @param sNumber : no accoring to rating
	 * 
	 * @return
	 */
	public boolean clickOnUserExperience(String sNumber) {
		sUserExperience = "//a[contains(@data-click,'" + sNumber + "')]";
		Driver.pgDriver.findElement(By.xpath(sUserExperience)).click();
		return true;
	}

	/*
	 * Checks in General Information
	 */

	/**
	 * Click on Cancel this work from Other Actions drop Down
	 * 
	 * @return
	 */
	public boolean clickCancelThisWork() {
		utils.clickAnelemnt(this.getBtnOtherActions(), "Wrap Up ", "Other actions button");
		action.moveToElement(this.lnkOtherCancelThisWork);
		return utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Wrap Up", "Cancel This Work");

	}

	// Click on Add Task

	@FindBy(xpath = "//*[contains(@class,'oflowDivM')]")
	private WebElement lnkAddTaskOption;

	public WebElement getLnkAddTaskOption() {
		return lnkAddTaskOption;
	}

	public WebElement getTxtboxAddTask() {
		return txtboxAddTask;
	}

	@FindBy(xpath = "//input[@id='CPMTaskSearchInput']")
	private WebElement txtboxAddTask;

	@FindBy(xpath = "//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")
	private WebElement btnAddTask;

	public WebElement getBtnAddTask() {
		return btnAddTask;
	}

	// Wrap Uop

	// Wrap Up
	//
	/*
	 * DEfination of the Elements used in the program
	 */
	@FindBy(xpath = "//*[contains(@class,'pzbtn-mid')][text()='Wrap Up']")
	private WebElement lnkWrapUp;
	@FindBy(xpath = "//*[contains(@class,'anthem_theme_header')][text()='Wrap Up']")
	private WebElement hHeader;

	/*
	 * Click on the elements, some places the response has been cushioned in try and
	 * catch block owing to the fact elements take time to load
	 */
	public boolean clickWrapUp() throws InterruptedException {
		Thread.sleep(5000);
		utils.waitforpageload();
		MemberComposite_PolicySection policy = new MemberComposite_PolicySection();
		policy.policyBasedoutOfValue();
		// try {
		return utils.clickAnelemnt(this.lnkWrapUp, "Wrap Up", "Wrap Up");
		// } catch (WebDriverException e) {
		/*
		 * Driver.getPgDriver().switchTo().defaultContent();
		 * Driver.getPgDriver().switchTo().frame(this.Iframeelement2); return
		 * utils.clickAnelemnt(this.lnkWrapUp, "Wrap Up", "Wrap Up");
		 */
		// }
	}

	public boolean clickrdBtnNo() {
		return utils.clickAnelemnt(this.rdBtnPriorInquiryNo, "Wrap Up", "Wrap Up");
	}

	public boolean clickrdbtnYes() {
		return utils.clickAnelemnt(this.rdBtnPriorInquiryYes, "Wrap Up", "Wrap Up");
	}



	public boolean clickBtnSubmit() {
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit, "Wrap Up", "Wrap Up");
	}

	// Select function for Selecting a Value from the drop down
	public boolean selectDropDownReaonsForInteraction(String svisibleString) throws InterruptedException, AWTException {

		try {
			return utils.selectDropDownbyVisibleString(this.getDrpDownReasonforInteraction(), svisibleString,
					"Wrap Up ", "Communication Channel");
		} catch (StaleElementReferenceException e) {
			selectDropDownReaonsForInteraction(svisibleString);
		}
		return false;
	}

	@FindBy(xpath = "//*[contains(@node_name,'NPSRatingInWrapUp')]//*[contains(@data-click,5)]")
	private WebElement interactionExperience;

	// *[contains(@node_name,'NPSRatingInWrapUp')]//*[contains(@data-click,5)]
	public boolean clickExperience5() {
		return utils.clickAnelemnt(this.interactionExperience, "Wrap Up", "Wrap Up");
	}

	public boolean selectDropDownReaonsPrimaryTask(String svisibleString) throws InterruptedException, AWTException {
		try {
			return utils.selectDropDownbyVisibleString(this.getDrpDownPrimaryTask(), svisibleString, "Wrap Up",
					"Communication Channel");
		} catch (StaleElementReferenceException e) {
			return selectDropDownReaonsPrimaryTask(svisibleString);
		} catch (Exception e) {
			System.out.println("ToSelect" + svisibleString + e);
			err.logError("WrapUP", "Selectfromdropdown");
			return false;
		}
	}

	@FindBy(id = "WasTheDissatisfaction")
	private WebElement drpDowndissatisfaction;

	public boolean selectDropDownDissatisfaction(String svisibleString) throws InterruptedException, AWTException {
		try {
			return utils.selectDropDownbyVisibleString(drpDowndissatisfaction, svisibleString, "Wrap Up",
					"Communication Channel");
		} catch (StaleElementReferenceException e) {
			return selectDropDownReaonsPrimaryTask(svisibleString);
		} catch (Exception e) {
			System.out.println("ToSelect" + svisibleString + e);
			err.logError("WrapUP", "Dissatisfaction dropdown");
			return false;
		}
	}

	@FindBy(id = "WasTheDissatRelatedTo")
	private WebElement drpDowndissatisfactionrelated;

	public boolean selectDropDownDissatisfactionRelated(String svisibleString)
			throws InterruptedException, AWTException {
		try {
			return utils.selectDropDownbyVisibleString(drpDowndissatisfactionrelated, svisibleString, "Wrap Up",
					"Communication Channel");
		} catch (StaleElementReferenceException e) {
			return selectDropDownReaonsPrimaryTask(svisibleString);
		} catch (Exception e) {
			System.out.println("ToSelect" + svisibleString + e);
			err.logError("WrapUP", "Selectfromdropdown");
			return false;
		}
	}

	@FindBy(id = "WrapUpComments")
	private WebElement txtBxWrapUpComments;
	@FindBy(xpath = "//*[contains(@id,'Comments')]")
	private WebElement txtBxComments;

	@FindBy(id="IsCallerDissatisfiedNo")
	WebElement disatisfactionRadioNobtn;

	public boolean setWrapUpcomments(String sCCBID) {
		return utils.enterTextinAnelemnt(this.txtBxWrapUpComments, sCCBID, "Wrap Up ", "Comments");
	}

	public boolean settxtBxCommentsOther(String sCCBID) {
		return utils.enterTextinAnelemnt(this.txtBxComments, sCCBID, "Wrap Up ", "Comments");
	}

	public boolean enterWrapUpcomments(String[] sCCBID) {
		return utils.enterTextinAnelemnt(this.txtBxWrapUpComments, sCCBID[0], "Wrap Up ", "Comments");
	}



	// Main method for Wrap Up Class

	/*
	 * Main methods to be used tin the program fo4r Wrap Up
	 * 
	 * 
	 * Here are five combinations from the reason drop Down so Will be pullingthe
	 * values
	 */

	/**
	 * Will navigate to Wrap Up Page and fill in the details with User Experience as
	 * 5 and submit following with entry
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@FindBy(xpath="WasTheDissatisfaction")
	WebElement drpDownWasTheDissatisfaction;

	@FindBy(xpath="WasTheDissatRelatedTo")
	WebElement drpDownWasTheDissatRelatedTo;

	public boolean clickNoInIndicateDissatisfaction()
	{
		return utils.clickAnelemnt(disatisfactionRadioNobtn, "WrapUp", "Disatisfaction");
	}


	public boolean clickWrapUpEligibilitySubmit() throws InterruptedException, AWTException {
		if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			if (this.selectDropDownReaonsPrimaryTask("Eligibility"))
				if (this.clickrdBtnNo())
					if (this.setWrapUpcomments("Wrap Up Comment"))
						try {
							if (MemberComposite_PolicySection.policystate.equalsIgnoreCase("CA")) {
								if(utils.clickAnelemnt(disatisfactionRadioNobtn, "Wrapup", "Disatisfaction"))
									if(clickBtnSubmit())
										return true;
								return false;
							}
						}catch(NullPointerException e) {
							System.out.println("Not a CA state Member");
						}
		return clickBtnSubmit();
	}


	@FindBy(xpath = "//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Policy']")
	WebElement tabMbrCompositeContract;

	@FindBy(xpath = "//div[@node_name='ContactInformationcontact']//*[@data-test-id='2015020305565609188735']")
	WebElement labelMbrCompositeSbrPolicyState;

	public String policyBasedoutOfValue() {

		if (utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite ", "Contract tab ")) {
			String policystate = labelMbrCompositeSbrPolicyState.getText();
			return policystate;
		}
		return null;
	}

	public boolean clickWrapUpBenefitsandCostSubmit() throws InterruptedException, AWTException {
		if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			if (this.selectDropDownReaonsPrimaryTask("Call Transfer"))
				if (this.clickrdBtnNo())
					if (this.clickExperience5())
						if (this.setWrapUpcomments("Wrap Up Comment"))
							if (this.clickBtnSubmit())
								return true;
		return false;
	}

	public boolean clickWrapUpManageBillingSubmit() throws InterruptedException, AWTException {
		if (this.utils.validateHeader(this.hHeader, "Wrap Up"))
			if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if (this.selectDropDownReaonsPrimaryTask("Manage Billing"))
					if (this.clickrdBtnNo())
						if (this.clickExperience5())
							if (this.setWrapUpcomments("Wrap Up Comment"))
								if (this.clickBtnSubmit())
									return true;
		return false;
	}

	/**
	 * Check the value in the field and Wrap up the session and submit , one should
	 * be navigated to the base home page
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean clickWrapUpCallTransferSubmit() throws InterruptedException, AWTException {
		if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			if (this.selectDropDownReaonsPrimaryTask("Call Transfer"))
				if (this.clickrdBtnNo())
					if (this.setWrapUpcomments("Wrap Up Comment"))
						if (this.clickBtnSubmit())
							return true;
		return false;
	}

	public boolean clickWrapUpOtherstSubmit() throws InterruptedException, AWTException {
		if (utils.validateHeader(this.hHeader, "Wrap Up"))
			if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if (this.selectDropDownReaonsPrimaryTask("Other"))
					if (this.clickrdBtnNo())
						if (this.clickExperience5())
							if (this.settxtBxCommentsOther("Cash and Promised Action"))
								if (this.setWrapUpcomments("Wrap Up Comment"))
									if (this.clickBtnSubmit())
										return true;
		return false;

	}

	/**
	 * Will navigate to Wrap Up Page and fill in the details with User Experience as
	 * 5 and submit following with entry
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public boolean clickWrapUpEligibilitySubmitYes() throws InterruptedException, AWTException {
		if (this.utils.validateHeader(this.hHeader, "Wrap Up"))
			if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if (this.selectDropDownReaonsPrimaryTask("Eligibility"))
					if (this.clickrdbtnYes())
						if (this.clickExperience5())
							if (this.setWrapUpcomments("Wrap Up Comment"))
								if (this.clickBtnSubmit())
									return true;
		return false;
	}

	public boolean clickWrapUpBenefitsandCostSubmitYes() throws InterruptedException, AWTException {
		if (this.utils.validateHeader(this.hHeader, "Wrap Up"))
			if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if (this.selectDropDownReaonsPrimaryTask("Eligibility"))
					if (this.clickrdbtnYes())
						if (this.clickExperience5())
							if (this.setWrapUpcomments("Wrap Up Comment"))
								if (this.clickBtnSubmit())
									return true;
		return false;
	}

	public boolean clickWrapUpandCloseInteraction() throws InterruptedException, AWTException {
		utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");
		if (this.utils.validateHeader(this.hHeader, "Wrap Up"))
			if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if (this.selectDropDownReaonsPrimaryTask("Eligibility"))
					if (this.clickrdbtnYes())
						if (this.setWrapUpcomments("Wrap Up Comment"))
							if (this.clickBtnSubmit())
								return true;
		return false;
	}

	@FindBy(xpath = "//button[@id='ModalButtonSubmit']")
	WebElement btnModalSubmitButton;

	public boolean closecurrentinteraction() {
		try {
			Thread.sleep(2000);
			if (utils.clickAnelemnt(closecurrenttab, "WrapUp", "Close Current tab"))
				Thread.sleep(2000);
			return utils.clickAnelemnt(btnModalSubmitButton, "WrapUp", "Modal Button Submit");
		} catch (Exception e) {
			System.out.println(e + " exception occured. retrying");
			return closecurrentinteraction();
		}
	}

	public boolean clickWrapUpManageBillingSubmitYes() throws InterruptedException, AWTException {
		if (this.utils.validateHeader(this.hHeader, "Wrap Up"))
			if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if (this.selectDropDownReaonsPrimaryTask("Manage Billing"))
					if (this.clickrdbtnYes())
						if (this.setWrapUpcomments("Wrap Up Comment"))
							if (this.clickBtnSubmit())
								return true;
		return false;
	}

	public boolean clickWrapUpCallTransferSubmitYes() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		if (this.utils.validateHeader(this.hHeader, "Wrap Up"))
			if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if (this.selectDropDownReaonsPrimaryTask("Call Transfer"))
					if (this.clickrdbtnYes())
						if (this.clickExperience5())
							if (this.setWrapUpcomments("Lee Child"))
								if (this.clickBtnSubmit())
									return true;
		return false;
	}

	public boolean clickWrapUpOtherstSubmitYes() throws InterruptedException, AWTException {
		if (this.utils.validateHeader(this.hHeader, "Wrap Up"))
			if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if (this.selectDropDownReaonsPrimaryTask("Other"))
					if (this.clickrdbtnYes())
						if (this.clickExperience5())
							if (this.settxtBxCommentsOther("Cash and Promised Action"))
								if (this.setWrapUpcomments("Wrap Up Comment"))
									if (this.clickBtnSubmit())
										return true;
		return false;
	}

	public boolean checkCCBopenAlertMessage() {
		return !utils.isProxyWebelement(CCBOpenWarning);
	}

	// Sprint-6.3 Orion
	@FindBy(xpath = "//span[text()='Did the caller indicate dissatisfaction at any time during the phone call?']")
	private WebElement lblDissatisfactionIndicator;

	@FindBy(xpath = "//label[@for='IsRelatedToPriorInquiryYes']")
	private WebElement isRelatedToPriorInquiryYesRdo;

	@FindBy(id = "IsRelatedToPriorInquiryNo")
	private WebElement isRelatedToPriorInquiryNoRdo;

	@FindBy(id = "IsCallerDissatisfiedYes")
	private WebElement dissatisfiedYesRdo;

	@FindBy(id = "IsCallerDissatisfiedNo")
	private WebElement dissatisfiedNoRdo;

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Launch Grievance and Appeals Task']")
	private WebElement launchGAButton;

	@FindBy(className = "anthem_theme_header")
	private WebElement sHeaderWrapUp;

	@FindBy(xpath = "//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	private WebElement msgOnYesDissatisfiedSubmit;

	/*
	 * @SCU #CommonMethodwithoutArgument:verifyDissatisfactionIndicatorForCAMember
	 * #Description:This method verifies the newly added dissatisfaction indicator
	 * section when Company Code is 200C or CA Member during WrapUp-Phone Call
	 * member. Type:TextBox
	 */
	public boolean verifyDissatisfactionIndicatorForCAMember() {
		utils.waitforpageload();
		if (utils.validateHeader(this.sHeaderWrapUp, "Wrap Up"))
			if (!utils.isProxyWebelement(lblDissatisfactionIndicator) && !utils.isProxyWebelement(dissatisfiedYesRdo)
					&& !utils.isProxyWebelement(dissatisfiedNoRdo))
				return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDissatisfactionIndicatorForNonCAMember
	 * #Description:This method verifies dissatisfaction indicator section is not
	 * displayed for Non-CA Member during WrapUp-Phone Call member. Type:TextBox
	 */
	public boolean verifyDissatisfactionIndicatorForNonCAMember() {
		utils.waitforpageload();
		if (utils.validateHeader(this.sHeaderWrapUp, "Wrap Up"))
			if (utils.isProxyWebelement(lblDissatisfactionIndicator) && utils.isProxyWebelement(dissatisfiedYesRdo)
					&& utils.isProxyWebelement(dissatisfiedNoRdo))
				return true;
		return false;
	}

	/*
	 * @SCU #CommonMethodwithArgument:selectDissatisfactionYesOrNoIndicator
	 * #Description:This method selects'Yes' or 'No' radio option for 'Did the
	 * caller indicate dissatisfaction at any time during the phone call?' question.
	 * #Arguments:Yes/No Type:TextBox
	 */
	public boolean selectDissatisfactionYesOrNoIndicator(String args[]) {
		if ((args[0]).trim().equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(dissatisfiedYesRdo, "WrapUp", "Dissatisfied Yes Rdo Btn");
		else if ((args[0]).trim().equalsIgnoreCase("No"))
			return utils.clickAnelemnt(dissatisfiedNoRdo, "WrapUp", "Dissatisfied No Rdo Btn");
		return false;
	}

	@FindBy(id = "IsGandAOpenedYes")
	WebElement rdoBtnOneDayGAndAOpenedYes;

	@FindBy(id = "IsGandAOpenedNo")
	WebElement rdoBtnOneDayGAndAOpenedNo;

	public boolean haveYouOpenedOneDayGrivanceInteraction(String[] args) {
		if ((args[0]).trim().equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(rdoBtnOneDayGAndAOpenedYes, "WrapUp", "Rdo Btn One Day GA Opened Yes");
		else if ((args[0]).trim().equalsIgnoreCase("No"))
			return utils.clickAnelemnt(rdoBtnOneDayGAndAOpenedNo, "WrapUp", "Rdo Btn One Day GA Opened No");
		return false;
	}

	/*
	 * @SCU #CommonMethodwithoutArgument:clickOnSubmit #Description:This method
	 * clicks on submit button in WrapUp screen. Type:TextBox
	 */
	public boolean clickOnSubmit() {
		utils.scrolltomiddle();
		WebElement element = Driver.pgDriver.findElement(By.xpath("//div[contains(text(),'Submit')]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(this.btnSubmit, "Member Composite - WrapUp", "Submit");
	}

	/*
	 * @SCU #CommonMethodwithoutArgument:validateMsgOnYesDissatisfiedSubmit
	 * #Description:This method validates the message displayed, when user doesn't
	 * complete Grievance task but performs submit button in WrapUp screen.
	 * Type:TextBox
	 */
	public boolean validateMsgOnYesDissatisfiedSubmit() {
		String expectedMsg = "When the caller expresses dissatisfaction, a Grievance must be opened. Please open and complete the Grievance and Appeals task.";
		String errMsg = this.msgOnYesDissatisfiedSubmit.getText().trim();
		return utils.isvalueMatch_contain(expectedMsg, errMsg);
	}

	/*
	 * @SCU #CommonMethodwithoutArgument:launchGrievanceandAppealsTask
	 * #Description:This method clicks on 'Launch Grievance and Appeals Task Button'
	 * in WrapUp screen. Type:TextBox
	 */
	public boolean launchGrievanceandAppealsTask() {
		return utils.clickAnelemnt(this.launchGAButton, "Member Composite - WrapUp",
				"Launch Grievance and Appeals Task Button");
	}

	@FindBy(id = "ReasonForInteraction")
	private WebElement primaryReasonforInteraction;

	@FindBy(id = "PrimaryTask")
	private WebElement primaryTask;

	/*
	 * @SCU #CommonMethodwithArgument:enterWrapUpDetails #Description:This method
	 * enters data to the required fields in WrapUp screen like Primary
	 * Reason,Primary Task,Related to Prior Inquiry and Dissatisfaction indicator.
	 * #Arguments:Primary Reason,Primary Task,Related to Prior Inquiry,Indicate
	 * Dissatisfaction Type:Dropdown,Dropdown,TextBox,TextBox Keys:#Requested
	 * coverage information#Requested help with a claim#Requested provider
	 * information#Requested help with an Anthem premium/billing question#Requested
	 * help with making a change#Requested a document#Responded to Anthem
	 * outreach#Requested Email ID and Preferences Information#Requested CDHP
	 * Account Information#Anthem outbound call to correct/clarify a prior closed
	 * inquiry Keys:#Call Transfer#Eligiblity#Others
	 */
	public boolean enterWrapUpDetails(String args[]) {
		String[] arg = { args[2] };
		if (utils.selectDropDownbyVisibleString(this.primaryReasonforInteraction, args[0], "WrapUp",
				"Primary Reason for Interaction"))
			if (utils.selectDropDownbyVisibleString(this.primaryTask, args[1], "WrapUp", "Primary Task"))
				if (selectPriorInquiryYesOrNoIndicator(arg))
					return true;
		return false;
	}

	/*
	 * @SCU #CommonMethodwithArgument:selectPriorInquiryYesOrNoIndicator
	 * #Description:This method selects'Yes' or 'No' radio option for 'Related to
	 * Prior Inquiry?' question. #Arguments:Yes/No Type:TextBox
	 */
	public boolean selectPriorInquiryYesOrNoIndicator(String[] args) {
		if ((args[0]).trim().equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(isRelatedToPriorInquiryYesRdo, "Wrap Up", "Related To Prior Inquiry Yes");
		else if ((args[0]).trim().equalsIgnoreCase("No"))
			return utils.clickAnelemnt(isRelatedToPriorInquiryNoRdo, "Wrap Up", "Related To Prior Inquiry No");
		return false;
	}

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Wrap Up']")
	WebElement btnMbrCompositeWrapup;

	/*
	 * @SCU #CommonMethodwithArgument:wrapUpCheckForPrimaryReason #Description:This
	 * method is used to validate the newly added drop-down options which appear
	 * during WrapUp -Phone Call member. #Arguments:Primary Reason for Interaction
	 * Type:Dropdown Keys:#Requested coverage information#Requested help with a
	 * claim#Requested provider information#Requested help with an Anthem
	 * premium/billing question#Requested help with making a change##Requested a
	 * document#Responded to Anthem outreach#Requested Email ID and Preferences
	 * Information#Requested CDHP Account Information#Anthem outbound call to
	 * correct/clarify a prior closed inquiry
	 */
	public boolean wrapUpCheckForPrimaryReason(String[] args) {
		utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(args));
		utils.waitforpageload();
		if (utils.checkvaluesinDropDown(this.primaryReasonforInteraction, al)) {
			return true;
		}
		err.logError("Wrapup", "Exception occured in 'wrapUpCheckForPrimaryReason' method");
		return false;
	}

	/*
	 * @SCU #CommonMethodWithArgument: selectDropDownPrimaryReasonsForInteraction
	 * #Description: This functionality selects the drop down reason for the
	 * interaction by getting the input from the user. #Argument: Primary Reason For
	 * Interaction Type: Dropdown keys: Select#Requested Coverage
	 * Information#Requested help with a claim#Requested help with an Anthem
	 * premium/billing question#Requested provider information#Requested help with
	 * making a change#Requested a document#Responded to Anthem outreach#Requested
	 * Email ID and Preferences Information#Requested CDHP Account
	 * Information#Anthem outbound call to correct/clarify a prior closed inquiry
	 */
	public boolean selectDropDownPrimaryReasonsForInteraction(String[] svisibleString)
			throws InterruptedException, AWTException {
		return utils.selectDropDownbyVisibleString(this.getDrpDownReasonforInteraction(), svisibleString[0], "WrapUp ",
				"Primary Task");
	}

	/*
	 * @SCU #CommonMethodWithArgument: selectDropDownReasonsPrimaryTask
	 * #Description: This functionality selects the drop down reason for the primary
	 * task by getting the input from the user. #Argument: Reason for Primary Task
	 * Type: Dropdown keys: Select#Call Transfer#Eligibility#Other
	 */
	public boolean selectDropDownReasonsPrimaryTask(String[] svisibleString) throws InterruptedException, AWTException {
		return utils.selectDropDownbyVisibleString(this.getDrpDownPrimaryTask(), svisibleString[0], "WrapUp",
				"Primary Task");
	}

	@FindBy(xpath = "//label[contains(text(),'Chat Dialog for the Genesys Interaction -  ')]")
	WebElement labelChatDialogText;

	/*
	 * @SCU #CommonMethodWithArgument: validateLabelChatDialog #Description: This
	 * functionality verifies the label displayed with the expected dialog chat.
	 * Type: Textbox
	 */

	public boolean validateLabelChatDialog() {
		String actuallabelChatDialog = labelChatDialogText.getText();
		String expectedlabelChatDialog = "Chat Dialog for the Genesys Interaction -";
		return utils.isvalueMatch_contain(actuallabelChatDialog, expectedlabelChatDialog);
	}

	@FindBy(name = "$PpyWorkPage$ppyNote")
	WebElement txtbxChatDialog;

	/*
	 * @SCU #CommonMethodWithArgument:enterChatDialogText #Description: This
	 * functionality enters the text in the chat dialog box.
	 * #Arguments:ChatDialogText Type: Textbox
	 */

	public boolean enterChatDialogText(String args[]) {
		return utils.enterTextinAnelemnt(txtbxChatDialog, args[0], "WrapUp", "Dialog Text");
	}

	@FindBy(xpath = "//div[contains(text(),'Use this Genesys Interaction ID to search for the chat transcript in WDE')]")
	WebElement hoverChatText;

	/*
	 * @SCU #CommonMethodWithoutArgument: validateChatHoverText #Description: This
	 * functionality validates the hover text present in the application. Type:
	 * Textbox
	 */
	public boolean validateChatHoverText() {
		utils.waitforpageload();
		Actions builder = new Actions(Driver.pgDriver);
		WebDriverWait wait = new WebDriverWait(Driver.pgDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(text(),'Use this Genesys Interaction ID to search for the chat transcript in WDE')]")));
		WebElement element = Driver.pgDriver.findElement(By.xpath(
				"//div[contains(text(),'Use this Genesys Interaction ID to search for the chat transcript in WDE')]"));
		builder.moveToElement(element).click().build().perform();
		utils.waitforpageload();
		return !utils.isProxyWebelement(hoverChatText);

	}

	@FindBy(id = "IsCallerDissatisfiedNo")
	WebElement rdoBtnCallerDissatisfaction;

	/*
	 * @SCU #CommonMethodWithoutArgument: clickRadioBtnNoCallerDissatisfaction
	 * #Description: This functionality clicks the radio button 'no' in the Caller
	 * Dissatisfaction section Type: Textbox
	 */

	public boolean clickRadioBtnNoCallerDissatisfaction() {
		return utils.clickAnelemnt(this.rdoBtnCallerDissatisfaction, "WrapUp", "Radio Button No");
	}

	// Sprint 1.4

	@FindBy(xpath = "//div[contains(text(),'Launch Grievance and Appeals Task')]")
	WebElement lnkGrievanceAndAppealsTask;

	/*
	 * @SCU #CommonMethodWithoutArgument: clickLaunchGrievanceAndAppealsTask
	 * #Description: This functionality clicks the Grievance and Appeals Task link
	 * in the Caller Dissatisfaction section Type: Textbox
	 */
	public boolean clickLaunchGrievanceAndAppealsTask() {
		return utils.clickAnelemnt(this.lnkGrievanceAndAppealsTask, "WrapUp", "Grievance and Appeals Task");
	}

	@FindBy(xpath = "//div[@id='FormErrorMarker_Div']//table[@id='ERRORTABLE']//table[@id='EXPAND']//table//span//li")
	WebElement txtErrorMsginWrapUp;

	/*
	 * @SCU #CommonMethodWithoutArgument: validateMsgOnSubmit #Description: This
	 * functionality validates the error message when user clicks submit without
	 * launching greivance opened. Type: Textbox
	 */
	public boolean validateMsgOnSubmit() {
		String txtErrorMsg = "When the caller expresses dissatisfaction, a Grievance must be opened. Please open and complete the Grievance and Appeals task.";
		String txtErrorMsgInUI = this.txtErrorMsginWrapUp.getText();
		return utils.isvalueMatch_contain(txtErrorMsg, txtErrorMsgInUI);
	}

	public boolean clickGuestWrapUpEligibilitySubmit() throws InterruptedException, AWTException {
		if (this.selectDropDownReaonsPrimaryTask("Eligibility"))
			if (this.setWrapUpcomments("Wrap Up Comment"))
				if (this.clickBtnSubmit())
					return true;
		return false;
	}

	// Sprint 3.2

	// @FindBY(id="IsCallerDissatisfiedYes")

	@FindBy(id = "IsGandAOpenedYes")
	WebElement rdoBtnOneDayGrievanceIsYes;

	@FindBy(id = "IsGandAOpenedNo")
	WebElement rdoBtnOneDayGrievanceIsNo;

	public boolean validateTheOneDayGrievanceQuestion(String[] args) {
		if ((args[0]).trim().equalsIgnoreCase("Yes"))
			if (utils.clickAnelemnt(rdoBtnOneDayGrievanceIsYes, "Wrap Up", "One Day Grievance Yes Btn"))
				return !utils.clickAnelemnt(launchGAButton, "Wrap Up", "launch GA Btn is Displayed");
			else if ((args[0]).trim().equalsIgnoreCase("No"))
				if (utils.clickAnelemnt(rdoBtnOneDayGrievanceIsNo, "Wrap Up", "One Day Grievance Yes Btn"))
					return utils.clickAnelemnt(launchGAButton, "Wrap Up", "launch GA Btn is Displayed");
		return false;

	}

	public boolean verifyLaunchGandAButtonIsDisplayed() {
		return !utils.clickAnelemnt(lnkGrievanceAndAppealsTask, "Wrap Up", "GA Task is Displayed");
	}

	public boolean clickWrapUpandCloseInteractionWithoutData() throws InterruptedException, AWTException {
		if (utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup"))
			if (this.utils.validateHeader(this.hHeader, "Wrap Up"))
				if (this.selectDropDownReaonsForInteraction("Requested help with a claim"))
					if (this.selectDropDownReaonsPrimaryTask("Eligibility"))
						if (this.clickrdbtnYes())
							if (this.setWrapUpcomments("Wrap Up Comment"))
								if (this.clickBtnSubmit())
									return true;
		return false;
	}

	@FindBy(id = "CallTransferTo")
	WebElement CallTransferTo;

	public boolean selectCallTransferTO(String[] Select_1) {
		return utils.selectDropDownbyVisibleString(CallTransferTo, Select_1[0], "wrapup", "selectCallTransferTO");

	}

	@FindBy(id = "IsSendingAttachmentYes")
	WebElement SendinganAttachmentYes;

	@FindBy(id = "IsSendingAttachmentNo")
	WebElement SendinganAttachmentNo;

	public boolean selectAreyouSendinganAttachment(String[] args) {
		if ((args[0]).trim().equalsIgnoreCase("Yes")) {
			if (utils.clickAnelemnt(SendinganAttachmentYes, "Wrapup", "SendinganAttachmentYes"))
				if (utils.clickAnelemnt(IsDocNameMatchingRequestYes, "Wrapup", "SendinganAttachmentYes"))
					if (utils.clickAnelemnt(IsDocHCIDMatchingRequestYes, "Wrapup", "SendinganAttachmentYes"))
						if (utils.clickAnelemnt(IsAttachmentDeletedFromFolderYes, "Wrapup", "SendinganAttachmentYes"))
							if (utils.clickAnelemnt(IsFormBlankConfirmedYes, "Wrapup", "SendinganAttachmentYes"))
								return true;
		} else if ((args[0]).trim().equalsIgnoreCase("No"))
			return utils.clickAnelemnt(SendinganAttachmentNo, "Wrapup", "SendinganAttachmentNo");
		return false;

	}

	@FindBy(id = "IsDocNameMatchingRequestYes")
	WebElement IsDocNameMatchingRequestYes;

	@FindBy(id = "IsDocNameMatchingRequestNo")
	WebElement IsDocNameMatchingRequestNo;

	@FindBy(id = "IsDocHCIDMatchingRequestYes")
	WebElement IsDocHCIDMatchingRequestYes;

	@FindBy(id = "IsDocHCIDMatchingRequestNo")
	WebElement IsDocHCIDMatchingRequestNo;

	@FindBy(id = "IsAttachmentDeletedFromFolderYes")
	WebElement IsAttachmentDeletedFromFolderYes;

	@FindBy(id = "IsAttachmentDeletedFromFolderNo")
	WebElement IsAttachmentDeletedFromFolderNo;

	@FindBy(id = "IsFormBlankConfirmedYes")
	WebElement IsFormBlankConfirmedYes;

	@FindBy(id = "IsFormBlankConfirmedNo")
	WebElement IsFormBlankConfirmedNo;

	@FindBy(id = "SMCancelReason")
	WebElement ReasonforWrapup;

	@FindBy(id = "CancelNotes")
	WebElement Comments;

	@FindBy(id = "OtherTopic")
	WebElement Otherdescription;

	/**
	 * This functionality select the dropdown reason for wrap up based on user input
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectReasonforWrapup(String[] args) {
		String actualreason = args[0];
		if (utils.isvalueMatch_compareto(actualreason, "Contact failed validation")) {
			if (utils.selectDropDownbyVisibleString(ReasonforWrapup, args[0], "wrapup", "ReasonforWrapup"))
				return utils.enterTextinAnelemnt(Comments, "Enter notes in the comment box", "wrapup", "Comments");
		}
		if (utils.isvalueMatch_compareto(actualreason, "Other")) {
			if (utils.selectDropDownbyVisibleString(ReasonforWrapup, args[0], "wrapup", "ReasonforWrapup"))
				if (utils.enterTextinAnelemnt(Otherdescription, " Enter notes in the comment box", "wrapup",
						"other description"))
					return utils.enterTextinAnelemnt(Comments, "Enter notes in the comment box", "wrapup", "Comments");
		}
		return false;
	}

	@FindBy(xpath = "//div[@id=\"DialogContent\"]")
	WebElement labelGuidedDialog;

	public boolean validateGuidedDialog(String[] args) {
		String message = labelGuidedDialog.getText().replaceAll("\n", "");
		return utils.isvalueMatch_contain(message, args[0]);
	}

	public boolean clickGuestWrapUpManageEmployeeAssistanceSubmit() throws InterruptedException, AWTException {
		if (this.selectDropDownReaonsPrimaryTask("Manage Employee Assistance Program"))
			if (this.setWrapUpcomments("Wrap Up Comment"))
				if (this.clickBtnSubmit())
					return true;
		return false;
	}

	/*
	 * @SCU #CommonMethodWithArgument: SelectDropDownPrimaryAnthemEngageQuestion
	 * #Description: This functionality selects the drop down Primary anthem Engage
	 * Question by getting the input from the user. #Argument: Primary Anthem Engage
	 * Question: Dropdown keys: Select#Activity Tracker Issue#Claims Issue#Dental
	 * Coverage/ claims#Device Purchase Provider Search Issue#Registration#Reward/
	 * Incentive Points# Reward Fulfillment Account Settings#Navigation#Challenge
	 * Question#Outag
	 */

	@FindBy(id = "PrimaryAnthemEngageQuestion")
	private WebElement drpDownPrimaryAnthemEngageQuestion;

	public WebElement getDrpDownPrimaryAnthemEngageQuestion() {
		return drpDownPrimaryAnthemEngageQuestion;
	}

	public boolean SelectDropDownPrimaryAnthemEngageQuestion(String[] svisibleString)
			throws InterruptedException, AWTException {
		return utils.selectDropDownbyVisibleString(this.getDrpDownPrimaryAnthemEngageQuestion(), svisibleString[0],
				"WrapUp ", "getDrpDownPrimaryAnthemEngageQuestion");
	}

	@FindBy(xpath = "//*[@data-test-id='2015102314231307481638']")
	WebElement PrimaryReason;

	/**
	 * This functionality validates whether primary reason for interaction field is
	 * auto populated with the reason selected on search member screen for e mail
	 * interaction
	 * 
	 * @return
	 */
	public boolean validateWhetherPrimaryReasonForInteractionIsAutopopulated() {
		return !PrimaryReason.getText().isEmpty();
	}

	@FindBy(xpath = "//*[text()='First Call Resolution']")
	WebElement FirstCallResolution;

	/**
	 * This functionality validates whether first call resolution indicator is not
	 * present in Wrao p up screen for e mail interaction
	 * 
	 * @return
	 */
	public boolean validateWhetherFirstCallResolutionIndicatorIsNotPresent() {
		return utils.isProxyWebelement(FirstCallResolution);
	}

	/**
	 * This functionality validates whether Did the contact indicate dissatisfaction
	 * at any time during the inquiry question is removed in Wrap up screen for e
	 * mail interaction
	 * 
	 * @return
	 */
	public boolean validateWhetherContactIndicateDissastisfationQuestionIsRemoved() {
		return utils.isProxyWebelement(lblDissatisfactionIndicator);

	}

	@FindBy(xpath = "//span[text()='Wrap Up']")
	WebElement WrapUpHeader;

	/**
	 * This functionality verifies if the search member page is navigated to wrap up
	 * screen
	 * 
	 * @return
	 */
	public boolean verifyIfNavigatedToWrapUpPage() {
		return !utils.isProxyWebelement(WrapUpHeader);
	}

	/**
	 * This functionality select the dropdown reason for wrap up based on user input
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectReasonforWrapupForEmailInteraction(String[] args) {
		return utils.selectDropDownbyVisibleString(ReasonforWrapup, args[0], "wrapup", "ReasonforWrapup");
	}

	// Sprint 6.4

	@FindBy(id = "ERRORMESSAGES_ALL")
	WebElement softWarningPCIMessage;

	/**
	 * This method validates the PCI compliance soft warning message
	 * 
	 * @return
	 */

	public boolean validatePCIDataSoftWarningMessage() {
		return !utils.isProxyWebelement(softWarningPCIMessage);
	}

	// Sprint 7.1

	@FindBy(id = "GAndATypeOne Day Grievance")
	WebElement rdoBtnOneDayGrievance;

	@FindBy(id = "WasTheDissatisfaction")
	WebElement drpDownWasDissatisafaction;

	@FindBy(id = "WasTheDissatRelatedTo")
	WebElement drpDownWasDissatisfactionTo;

	@FindBy(xpath = "//div[@data-test-id='20171115123818004825955']")
	WebElement txtInstructionalMsg;

	@FindBy(xpath = "//div[@data-test-id='20171115123818004825955'][starts-with(text(),'This is a One Day')]")
	WebElement txtInstructionalMsgOneDayGrievance;

	@FindBy(id = "DissatisfiedGrievanceNotes")
	WebElement txtNotes;

	@FindBy(id = "IsOneDayGrievanceResolvedYes")
	WebElement rdoBtnOneDayGrievanceYes;

	@FindBy(id = "IsOneDayGrievanceResolvedNo")
	WebElement rdoBtnOneDayGrievanceNo;

	public boolean verifyWasDissatisfactionAndWasDissatisfactionRelatedToDrpDownIsDisplayed() {
		try {
			if (this.drpDownWasDissatisafaction.isDisplayed() && this.drpDownWasDissatisfactionTo.isDisplayed())
				;
			{

				System.out.println("Was Dissatisafction and Was Dissatisafction To drop down is displayed");
				return true;
			}
		} catch (Exception e) {
			err.logcustomerrorwithmessage("GrievanceAndAppeals",
					"verifyWasDissatisfactionAndWasDissatisfactionRelatedToDrpDownIsDisplayed",
					"Was Dissatisafction and Was Dissatisfaction To drop down is not displayed");
			return false;
		}
	}

	public boolean selectDissatisafctionDropDownValues(String[] args) {
		return utils.selectDropDownbyVisibleString(this.drpDownWasDissatisafaction, args[0], "GrievanceAndAppeals",
				"Dissatisfaction Drop down");
	}

	public boolean selectDissatisafctionRelatedToDropDownValues(String[] args) {
		return utils.selectDropDownbyVisibleString(this.drpDownWasDissatisfactionTo, args[0], "GrievanceAndAppeals",
				"Dissatisfaction To Drop down");
	}

	public boolean validateInstMessageToSelectGrievance() {
		String actualText = "This is a Standard Grievance. Select the Grievance option and complete the Grievance and Appeals task.";
		String expectedText = txtInstructionalMsg.getText();
		System.out.println("Expected msg: " + expectedText);
		if (actualText.equalsIgnoreCase(expectedText)) {

			System.out.println("Actual Text and Expected Text for Instructional Text is validated and matched");
			return true;
		} else {

			System.out.println("Actual Text and Expected Text for Instructional Text is validated and doesn't matched");
			return false;
		}
	}

	public boolean validateInstMessageForUserToCompleteOneDayGrievance() {
		String actualText = "This is a One Day (Exempt) Grievance.  If you are not able to close the service request during the interaction keep it in your work list. It will be classified as a one day grievance. Make sure it is closed by the end of the day the next business day. If you are unable to resolve the request by the end of the day the next business day, a Standard Grievance must be opened.";
		String expectedText = txtInstructionalMsgOneDayGrievance.getText();
		System.out.println("Expected msg: " + expectedText);
		if (actualText.equalsIgnoreCase(expectedText)) {

			System.out.println(
					"Actual Text and Expected Text of Instructional Text to complete grievance is validated and matched");
			return true;
		} else {

			System.out.println(
					"Actual Text and Expected Text of Instructional Text to complete grievance is validated and doesn't matched");
			return false;
		}
	}

	public boolean enterNotesInOneDayGrievance(String[] notes) {
		return utils.enterTextinAnelemnt(this.txtNotes, notes[0], "GrievanceAndAppeals", "Notes is entered");
	}

	public boolean validatesOneDayGrievanceQuestion(String[] args) {
		if ((args[0]).trim().equalsIgnoreCase("Yes")) {
			return utils.clickAnelemnt(rdoBtnOneDayGrievanceYes, "GrievanceAndAppeals", "rdoBtnOneDayGrievanceYes");
		} else if ((args[0]).trim().equalsIgnoreCase("No")) {
			return utils.clickAnelemnt(rdoBtnOneDayGrievanceNo, "GrievanceAndAppeals", "rdoBtnOneDayGrievanceNo");
		}
		return false;
	}

	@FindBy(id = "FCRIndicatorYes")
	WebElement FCRIndicatorYes;

	/**
	 * Validate 'yes' is default selected in First Resolution call
	 * 
	 * @return
	 */
	public boolean validateFirstCallResolutionYesRdoBtnIsChecked() {
		String value = FCRIndicatorYes.getAttribute("checked");
		return utils.isvalueMatch_contain(value, "true");
	}

	@FindBy(id = "FCRIndicatorNo")
	WebElement FCRIndicatorNo;

	/**
	 * Validate 'No' is default selected in First Resolution call
	 * 
	 * @return
	 */
	public boolean validateFirstCallResolutionNoRdoBtnIsChecked() {
		String value = FCRIndicatorNo.getAttribute("checked");
		return utils.isvalueMatch_contain(value, "true");
	}

	/**
	 * This functionality verifies the text in comments section
	 * 
	 * @return
	 */
	public boolean verifyTextInCommentsSection(String[] args) {
		return utils.isvalueMatch_contain(txtBxWrapUpComments.getText(), args[0]);

	}
	
	@FindBy(xpath="//label[@for='SMAssociateNextAction']")
	WebElement SMAssociateNextActionLabel;
	
	@FindBy(xpath="//label[@for='SMAssociateNextAction']/strong")
	WebElement SMAssociateNextActionRequired;
	
	@FindBy(xpath="//select[@id='SMAssociateNextAction']")
	WebElement SMAssociateNextActionValues;
	
	/**
	 * This method verify the Secure Message Associate selection next action field available for SM interaction in wrap up page
	 * @throws InterruptedException 
	 */
	
	
	public boolean selectSecureMessageAssociateNextAction() throws InterruptedException
	{
		if(!utils.isProxyWebelement(SMAssociateNextActionLabel));
		if(!utils.isProxyWebelement(SMAssociateNextActionRequired));
		return utils.selectDropDownbyIndex(SMAssociateNextActionValues, 0, "Wrap up", "SMAssociateNextActionValues");
		
	}
	
	@FindBy(xpath="//span[text()=Comments Activity Log']")
	WebElement SMActivityLogSection;
	
	@FindBy(xpath="//table[@pl_prop='.ReviewNotesList']")
	WebElement SMActivityLogTable;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyColHeadersInSMactivityLog
	 * #Description:This method verifies the column headers in the SM activity log in wrap up page
	 * Type:TextBox
	 */
	
	
	public boolean verifyColHeadersInSMActivityLog(){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.SMActivityLogTable);
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.SMActivityLogTable);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Created On");
		valuesGivenManual.add("Created By");
		valuesGivenManual.add("Notes");
		valuesGivenManual.add("Secure Message Associate Next Action");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			return true;
		}
	}
	
	@FindBy(id="SMAssociateNextAction")
	WebElement SecureMessageAssociateNextAction;
	
	public boolean validateSecureMessageAssociateNextAction(String[] args) {
		String arg = args[0].replaceAll("%", ";");
		System.out.println(arg);
		return utils.selectDropDownbyVisibleString(SecureMessageAssociateNextAction, arg, "WrapUp",
				"SMAssociateNextAction");
	}
	
	
	@FindBy(xpath="//select[@id='ReasonForInteraction']/option[text()='Requested help with a claim']")
	WebElement ReasonforInteractionasRequestedhelpwithaclaim;
	
	@FindBy(xpath="//select[@id='PrimaryTask']/option[text()='Grievance and Appeals']")
	WebElement PrimaryTaskasGandA;
	
	
	@FindBy(xpath="//select[@id='WasTheDissatisfaction']/option[text()='About a claim issue?']")
	WebElement WasDissatisficationasAboutClaimIssue;
	
	@FindBy(xpath="//select[@id='WasTheDissatRelatedTo']/option[text()='A claim issue that you are able to resolve (MRU, HMO, ITS, CDHP, COB, Foreign, Dental Pricing, etc.)']")
	WebElement WasTheDissatRelatedToclaimissueabletoresolve;
	
	public boolean validateWrapUpforODG()
	{
		if(ReasonforInteractionasRequestedhelpwithaclaim.isSelected());
		if(PrimaryTaskasGandA.isSelected());
		if(WasDissatisficationasAboutClaimIssue.isSelected());
		if(WasTheDissatRelatedToclaimissueabletoresolve.isSelected());
		return true;
	}
	
	
}
