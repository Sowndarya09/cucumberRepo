package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.CustomException;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResolveBillingActions {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;
	
	@FindBy(xpath="//label[contains(text(),'Resolve Billing Actions')]")
	private WebElement resolveBillingActionLbl;
	
	@FindBy(xpath="//label[contains(text(),'Resolve Enrollment Actions')]")
	private WebElement resolveEnrollmentActionLbl;
	
	@FindBy(id="BillingTeamResponse")
	private WebElement responseDrpDown;
	
	public ResolveBillingActions(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyResolveBillingActionsPage
	 * Type:Textbox
	 * Description: To verify, user is navigated to "Resolve Billing Actions" page.
	 */
	public boolean verifyResolveBillingActionsPage(){
		//ResolveBillingActions
		return utils.validateHeader(this.resolveBillingActionLbl, "Resolve Billing Actions");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyResolveEnrollmentActionsPage
	 * Type:Textbox
	 * Description: To verify, user is navigated to "Resolve Enrollment Actions" page.
	 */
	public boolean verifyResolveEnrollmentActionsPage(){
		//ResolveEnrollmentActions
		return utils.validateHeader(this.resolveEnrollmentActionLbl, "Resolve Enrollment Actions");
	}
	
	@FindBy(id="ProdSupportLogNumber")
	private WebElement PSLTxtBox;
	
	@FindBy(name="$PpyWorkPage$pNotes")
	private WebElement addtNotesTxtBox;
	
	@FindBy(xpath="//*[@id='$PpyWorkPage$pNotesError']/span")
	private WebElement NotesError;
	
	@FindBy(xpath="//*[@id='$PpyWorkPage$pProdSupportLogNumberError']/span")
	private WebElement PSLError;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement BtnSubmit;
	
	@FindBy(xpath="//table[@pl_prop='.BillingTeamNotesList']")
	private WebElement reviewBillingActionTbl;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validatePSLDisplay
	 * #Arguments:Billing Team response
	 * Type:Dropdown
	 * Keys:Request Additional Information#Request Complete#Requested in Error#Route for Exception Review#System Issue
	 * Description: This method validates the display of (PSL#) box when “System Issue” is picked from the Billing/Enrollment Team Response dropdown
	 */
	public boolean validatePSLDisplay(String[] args){
		if(utils.selectDropDownbyVisibleString(this.responseDrpDown, args[0], "ResolveBillingActions", "Billing Team Response"))
		if(args[0].equalsIgnoreCase("System Issue"))
			return !utils.isProxyWebelement(PSLTxtBox);
		else
			return utils.isProxyWebelement(PSLTxtBox);
		return false;
	}

	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateIsMandatoryPSL
	 * #Type:TextBox
	 * Description: This method checks for error msg when mandatory field -PSL# Textbox is not filled -“System Issue” is picked from the Billing/Enrollment Team Response dropdown.
	 */
	public boolean validateIsMandatoryPSL(){
		if(utils.selectDropDownbyVisibleString(this.responseDrpDown, "System Issue", "ResolveBillingActions", "Billing Team Response"))
			if(utils.enterTextinAnelemnt(this.addtNotesTxtBox,"Test", "ResolveBillingActions", "Additional Notes"))
				if(utils.clickAnelemnt(this.BtnSubmit, "ResolveBillingActions", "Submit Button"))
					Driver.pgDriver.switchTo().alert().accept();
			return utils.isvalueMatch_contain(PSLError.getText().trim(), "Value cannot be blank");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateIsAlphanumericPSL
	 * #Arguments:PSL Number
	 * Type:TextBox
	 * Description: This method validates the pattern value entered in PSL# Textbox - to check maxlength of 10 alphanumeric characters.
	 */
	public boolean validateIsAlphanumericPSL(String[] args){
		Pattern p = Pattern.compile("[^a-zA-Z0-9]");
		if(utils.selectDropDownbyVisibleString(this.responseDrpDown, "System Issue", "ResolveBillingActions", "Billing Team Response"))
			if(utils.enterTextinAnelemnt(this.PSLTxtBox, args[0], "ResolveBillingActions", "PSL TextBox"))
				if(utils.enterTextinAnelemnt(this.addtNotesTxtBox,"Test", "ResolveBillingActions", "Additional Notes"))
					if(this.PSLTxtBox.getAttribute("maxlength").equals("10"))
						if(!p.matcher(this.PSLTxtBox.getText()).find())
			return true;
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:fillBillAndEnrolResponseAsSystemIssueAndSubmit
	 * #Arguments:PSL Number
	 * Type:TextBox
	 * Description: In this method, user selects Response as "System Issue" and enters PSL# and performs submit. 
	 */
	public boolean fillBillAndEnrolResponseAsSystemIssueAndSubmit(String[] arg){
		if(utils.selectDropDownbyVisibleString(this.responseDrpDown, "System Issue", "ResolveBillingActions", "Billing Team Response"))
			if(utils.enterTextinAnelemnt(this.PSLTxtBox, arg[0], "ResolveBillingActions", "PSL TextBox"))
				if(utils.enterTextinAnelemnt(this.addtNotesTxtBox,"Test", "ResolveBillingActions", "Additional Notes"))
					if(utils.clickAnelemnt(this.BtnSubmit, "ResolveBillingActions", "Submit"))
						return true;
			return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateReviewBillingActionTbl
	 * #Arguments:Activity-KeyValuePair
	 * Type:Table
	 * Keys:Activity
	 * Description: This method validates the Activity column corresponds to PSL Details, submitted.
	 */
	public boolean validateReviewBillingActionTbl(String[] args) throws InterruptedException{
		if(utils.clickontablerowbasedonvalues(this.reviewBillingActionTbl, args))
			return true;
		else
			return false;
	
	}
	
	@FindBy(xpath="//table[@pl_prop='.EANDBCancelMemberList']")
	private WebElement selectMemberTable;
	@FindBy(xpath="//a[@issprite='true'][contains(@name,'CPMPortalRecents.pxResults')]")
	private WebElement closeResults;
	@FindBy(xpath="//*[@id='ModalButtonSubmit']")
	private WebElement modal_Yes;
	
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateSelectMemberSection
	 * #Description:This method would validate if the selected members are displayed as checked in 'Select Member' Section - Resolve Enrollment Action page.
	 * #Arguments:Member name
	 * Type:Textbox
	 */
	public boolean validateSelectMemberSection(String args[]){
		ArrayList<String> matchedList = new ArrayList();
		ArrayList<String> unmatchedList = new ArrayList();
		List<String> datainput = new ArrayList(Arrays.asList(args));
		if(utils.validateHeader(this.resolveEnrollmentActionLbl, "Resolve Enrollment Actions")){
			System.out.println("ResolveBillingActions - Resolve Enrollment Actions page is displayed");
			}
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.selectMemberTable);
		for(String s:args){
			String fname = "First Name";
			StringBuilder input = new StringBuilder();
			String sinput = input.append(fname).append(":").append(s).toString();
			try {
				if(utils.validatetablerowbasedonvalues(this.selectMemberTable,sinput)){
					matchedList.add(s);
				}else{
					System.out.println("Element not selected in UI:"+s);
					unmatchedList.add(s);
				}
			} catch (Exception e) {
				err.logError("Request Enrollment and Billing Action", "validateSelectMemberSection");
				System.out.println("Member name is not checked/selected"+e);
			}
		}
		
		if(unmatchedList.size()>0){
	 		System.out.println("Active member who aren't checked::"+unmatchedList);
	 		Driver.getPgDriver().switchTo().defaultContent();
	 		action.moveToElement(this.closeResults).click().build().perform();
			this.modal_Yes.click();
	 	}
		
		if(unmatchedList.size()==0){
			if(matchedList.size()==datainput.size()){
			Driver.getPgDriver().switchTo().defaultContent();
			action.moveToElement(this.closeResults).click().build().perform();
			this.modal_Yes.click();
			return true;
			}
		}
		return false;
	}
	
	//Sprint 3.1
	
	@FindBy(id="BillingTeamResponse")
	WebElement drpDownSelectBillingTeamResponse;
	
	@FindBy(id="ReasonForPending")
	WebElement drpDownReasonForPending;
	
	@FindBy(id="FollowUpDate")
	WebElement txtFollowUpDate;
	
	@FindBy(id="Notes")
	WebElement txtNotes;
	
	@FindBy(xpath="//span[@id='PegaRULESErrorFlag']")
	WebElement labelErrorMsg;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//span[@data-test-id='2015011307071009054871']")
	WebElement labelStatusResponse;
	
	@FindBy(xpath="//table[@pl_prop='.BillingTeamNotesList']")
	WebElement tblReviewBillingAction;
	
	
	
	public boolean selectBillingTeamResponse(String[] args)
	{
			return utils.selectDropDownbyVisibleString(this.drpDownSelectBillingTeamResponse, args[0], "ResolveBillingActions", "Billing Team Response");	
	}
	
	public boolean verifyReasonForPendingIsDisplayed()
	{
			return !utils.isProxyWebelement(drpDownReasonForPending);
	}
	
	
	public boolean verifyNoReasonForPendingDropDownIsDisplayed()
	{
			return !utils.isProxyWebelement(drpDownReasonForPending);
	}
	
	
	public boolean selectReasonForPendingForBilling(String[] args)
	{
			return utils.selectDropDownbyVisibleString(this.drpDownReasonForPending, args[0], "ResolveBillingActions", "Reason For Pending");	
	}
	
	
	public boolean verifyFollowUpDateIsDisplayed()
	{
			return !utils.isProxyWebelement(txtFollowUpDate);
	}
	
	public boolean verifyNoFollowUpDateFieldIsDisplayed()
	{
			return utils.isProxyWebelement(txtFollowUpDate);
	}
	
	public boolean enterFollowUpDate(String[] args)
	{
			return utils.enterTextinAnelemnt(this.txtFollowUpDate, args[0], "ResolveBillingActions", "Follow Up Date");	
	}
	
	
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "ResolveBillingActions", "Submit");
	}
	
	public boolean enterNotes(String[] args)
	{
			return utils.enterTextinAnelemnt(this.txtNotes, args[0], "ResolveBillingActions", "Notes");	
	}
	
	public boolean verifyTheErrorMsgIsDisplayedInFollowUpDateWhenPastDateIsEntered()
	{
			 return !utils.isProxyWebelement(labelErrorMsg);
	}
	
	
	public boolean verifyTheErrorMsgInFollowUpDateWhenPastDateIsEntered(String[] args)
	{
			return utils.validateLabel(this.labelErrorMsg, args[0]);
	}
	
	
	public boolean verifyStatusResponseIsPending()
	{
			String actualText = "Pending-Response";
			Driver.pgDriver.switchTo().defaultContent();
			String expectedText = this.labelStatusResponse.getText();
			return utils.isvalueMatch_contain(actualText, expectedText);
	}
	
	public boolean verifyReviewEnrollmentAction(String[] tablevalues)
	{
			return utils.validatetablerowbasedonvalues(this.tblReviewBillingAction, tablevalues);
	}
	
	//Sprint 3.1
	
	
	
		public boolean verifyActivityLOgDetailsTable(String[] tablevalues)
		{
				return utils.validatetablerowbasedonvalues(this.tblReviewBillingAction, tablevalues);
		}
	
	
}
