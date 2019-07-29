package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderCompleteBillingReview extends Driver{

	

	 DataSet ds=new DataSet();
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	// Changes to the Heading HEader 
	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public ProviderCompleteBillingReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	/*
	 * Page objects for elements in the page 
	 */

	/*
	 * Capturing the Elements form the page
	 */

	// Other Tools
	@FindBy (xpath="//img[contains(@src,'tool_icon_')]")	
	private WebElement btnImgTool;

	// Tool Mark 
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;
	// Help 

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;




	@FindBy(xpath="//select[@id='PrimaryReasonforBilling']")
	private WebElement dropdownReasonForContact;
	@FindBy(id="Notes")
	private WebElement txtBoxNotes;

	// Tables 
	@FindBy(xpath="//table[@class='gridTable '][contains(@pl_prop,'TaggedItems')]")
	private WebElement tableItemsDiscussedDuringManageBillingReview;
	@FindBy(xpath="//table[@class='gridTable '][contains(@pl_prop,'BillingTeamNotes')]")
	private WebElement tableReviewBillingAction;

	//DropDown Link for the Two Tables above 
	@FindBy(xpath="//*[@title='Hide Items Discussed During Manage Billing Review']")
	private WebElement lnkDrpdnItemsDiscussedManageBillingReview;
	@FindBy(xpath="//*[@title='Disclose Review Billing Action']")
	private WebElement lnkDrpdnReviewBillingAction;
	@FindBy(xpath="//div[@node_name='BillingTeamNotesList']//div[contains(text(),'Create Date')]")
	private WebElement labelCompleteBillingReviewBillingCreateDate;
	@FindBy(xpath="//div[@node_name='BillingTeamNotesList']//div[contains(text(),'Created By')]")
	private WebElement labelCompleteBillingReviewBillingCreatedBy;
	@FindBy(xpath="//div[@node_name='BillingTeamNotesList']//div[contains(text(),'Notes')]")
	private WebElement labelCompleteBillingReviewBillingNotes;
	@FindBy(xpath="//div[@node_name='BillingTeamNotesList']//div[contains(text(),'Activity')]")
	private WebElement labelCompleteBillingReviewBillingActivity;
	
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	//Check links

	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage  Enrollment & Billing Review']")
	private WebElement lnktxtItemsDiscussedManageBillingReview;
	@FindBy(linkText="Review Billing Action")
	private WebElement lnktxtReviewBillingActions;
	/**
	 * Objects for Other Actions Button at the top right corner of the Frame
	 */
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//li[@title='Reinstate Member']")	
	private WebElement lnkOthrActionsReinstateMember;
	@FindBy (xpath="//li/a[contains(@data-click,'CancelPayment')]")	
	private WebElement lnkOthrActionsCancelPayment;
	@FindBy (xpath="//li/a[contains(@data-click,'AcceptPayment')]")	
	private WebElement lnkOthrActionsAcceptPayment;
	@FindBy (xpath="//li//span[contains(text(),'Request Manager Help')]")	
	private WebElement lnkOthrActionsReqstManagerHelp;
	@FindBy (xpath="//li//span[contains(text(),'Request Enrollment &')]")	
	private WebElement lnkOthrActionsRequestBillingAction;
	@FindBy (xpath="//li//span[contains(text(),'Complete Payment History')]")	
	private WebElement lnkOthrActionsRequestCompletePaymentHistory;
	@FindBy (xpath="//li//span[contains(text(),'Review Billing Informatio...')]")	
	private WebElement lnkOthrActionsReviewBillingInformation;
	
	
	
	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}


	public WebElement getLnkOthrActionsReinstateMember() {
		return lnkOthrActionsReinstateMember;
	}


	public WebElement getLnkOthrActionsCancelPayment() {
		return lnkOthrActionsCancelPayment;
	}


	public WebElement getLnkOthrActionsAcceptPayment() {
		return lnkOthrActionsAcceptPayment;
	}


	public WebElement getLnkOthrActionsReqstManagerHelp() {
		return lnkOthrActionsReqstManagerHelp;
	}


	public WebElement getLnkOthrActionsRequestBillingAction() {
		return lnkOthrActionsRequestBillingAction;
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




	/*
	 * Getters for the Objects in the Page 
	 */

	public WebElement getsHeaderCompleteBilling() {
		return sHeaderCompleteBilling;
	}


	public WebElement getDropdownReasonForContact() {
		return dropdownReasonForContact;
	}


	public WebElement getTxtBoxNotes() {
		return txtBoxNotes;
	}


	public WebElement getTableItemsDiscussedDuringManageBillingReview() {
		return tableItemsDiscussedDuringManageBillingReview;
	}


	public WebElement getTableReviewBillingAction() {
		return tableReviewBillingAction;
	}


	public WebElement getLnkDrpdnItemsDiscussedManageBillingReview() {
		return lnkDrpdnItemsDiscussedManageBillingReview;
	}


	public WebElement getLnkDrpdnReviewBillingAction() {
		return lnkDrpdnReviewBillingAction;
	}


	public WebElement getBtnSubmit() {
		return btnSubmit;
	}


	public WebElement getLnktxtItemsDiscussedManageBillingReview() {
		return lnktxtItemsDiscussedManageBillingReview;
	}


	public WebElement getLnktxtReviewBillingActions() {
		return lnktxtReviewBillingActions;
	}

	public boolean setTxtNotes(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBoxNotes(), sFullName, "Complete Villing Review ", "Notes Section");
	}
	public boolean clickgetBtnSubmit()
	{
		return utils.clickAnelemnt(this.getBtnSubmit(), "Complete Billing Review ", "Submit button");
	}
	
	
	
	
	// Methods for Billing Review 

	// check header is true 

	public boolean validateHeader(WebElement header)
	{
		String expMsg = header.getText().trim();
		if(!utils.isProxyWebelement(header))
			if(utils.isvalueMatch_contain(expMsg, "Complete Billing Review"))
				return true ;
		return false; 
	}

	/*
	 * 
	 * 
	 * 
	 * The methods in the program for checking the value on teh page 
	 */
	
	
	// Select the appropriate drop down and Submit 
	public boolean selectDropdownReasonForContact(String sReason)
	{
		return utils.selectDropDownbyVisibleString(this.getDropdownReasonForContact(), sReason, "Complete Villing Review ", "Drop Down to select the value");
	}
	
	
	public boolean checkReviewBillingActionsection()
	{
		if(utils.clickAnelemnt(this.lnkDrpdnReviewBillingAction, "Manage Billing", "Review Billign Action Link"))
			if(this.labelCompleteBillingReviewBillingActivity.isDisplayed())
				if(this.labelCompleteBillingReviewBillingCreateDate.isDisplayed())
					if(this.labelCompleteBillingReviewBillingCreatedBy.isDisplayed())
						if(this.labelCompleteBillingReviewBillingNotes.isDisplayed())
							return true;
		return false;
		
				
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:completeBillingReviewandSubmitDidNotUnderStandBill
	 * Type:Textbox
	 
	
	 */
	public boolean completeBillingReviewandSubmitDidNotUnderStandBill()
	{
		utils.waitforpageload();
		if(validateHeader(getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Did not understand bill"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		return false ;
	}


	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:completeBillingReviewandSubmitReceivedUnexpectedRefund
	 * Type:Textbox
	 
	
	 */
	
	public boolean completeBillingReviewandSubmitReceivedUnexpectedRefund()
	{

		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Received unexpected refund"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		return false ;
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:completeBillingReviewandSubmitRateorPremiumChanged
	 * Type:Textbox
	 
	
	 */
	
	public boolean completeBillingReviewandSubmitRateorPremiumChanged()
	{

		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Rate or premium changed"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		return false ;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:completeBillingReviewandSubmitPolicyCancelledUnexpected
	 * Type:Textbox
	 */
	
	public boolean completeBillingReviewandSubmitPolicyCancelledUnexpected()
	{

		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Policy cancelled improperly"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true;
		return false ;
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:completeBillingReviewandSubmitRequestedCopyOfDocument
	 * Type:Textbox
	 */
	
	public boolean completeBillingReviewandSubmitRequestedCopyOfDocument()
	{

		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Requested a copy of a document"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		return false ;
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:completeBillingReviewandSubmitRequestedRefund
	 * Type:Textbox
	 
	
	 */
	
	public boolean completeBillingReviewandSubmitRequestedRefund()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Requested a refund"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		return false ;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:completeBillingReviewandSubmitUnabletofillprescription
	 * Type:Textbox
	 
	
	 */
	public boolean completeBillingReviewandSubmitUnabletofillprescription()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Unable to fill prescription"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		return false ;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:completeBillingReviewandSubmitMadePaymentNotLocatedInSystem
	 * Type:Textbox
	 
	
	 */
	public boolean completeBillingReviewandSubmitMadePaymentNotLocatedInSystem()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Made a payment not located in system"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		return false ;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigatetoAcceptPayment
	 * Type:Textbox
	 
	
	 */
	
	public boolean navigatetoAcceptPayment()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsAcceptPayment, "Billing Review", "Links"))
				return true;
			return false;
	}
	
	
	public boolean navigatetoReinstateMember()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsReinstateMember, "Billing Review", "Links"))
				return true;
			return false;
	}
	
	
	
	public boolean navigatetoRequestManagerHelp()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsReqstManagerHelp, "Billing Review", "Links"))
				return true;
			return false;
	}
	
	public boolean navigatetoReviewBillingInfo()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsRequestBillingAction, "Billing Review", "Links"))
				return true;
			return false;
	}
	
	public boolean navigatetoCancelPayment()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsCancelPayment, "Billing Review", "Links"))
				return true;
			return false;
	}

	public boolean navigatetoCompletePaymentHistory()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsRequestCompletePaymentHistory, "Billing Review", "Links"))
				return true;
			return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigatetoRequestEnrollment
	 * Type:Textbox
	 
	
	 */
	public boolean navigatetoRequestEnrollment()
	{
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		  jse.executeScript("window.scrollBy(0,850)","");
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsRequestBillingAction, "Billing Review", "Links"))
				return true;
			return false;
	}

	@SuppressWarnings("unchecked")
	public boolean validatetaggedcheckboxes()
	{
		ArrayList<String> actual = null,expected=new ArrayList<String>(); 
		if(utils.clickAnelemnt(this.lnktxtItemsDiscussedManageBillingReview, "Complete Billing", "Items Discussed"))
			// GET THE ACTUAL VALUE FROm THE APPLICATION		
			actual=utils.getcolumnStringFromTableByName(this.tableItemsDiscussedDuringManageBillingReview,"Description");
		    actual.remove(0);
		//GET THE EXPECTED VALUE FROM HASHMAP 
		for(Map.Entry<String, String> entry:ds.data.entrySet())
			expected.add(entry.getValue());
		Collections.reverse(expected);
		for(int i=0;i<actual.size();i++)
		{
			System.out.println(actual.get(i)+"---------"+expected.get(i));
			if(actual.get(i).equalsIgnoreCase(expected.get(i)))
				continue;
			else
				return false;
		}
		return true;
	}


	@FindBy(xpath="//*[text()='Other actions ']")
	WebElement OtherActions;
	
	@FindBy(xpath="//*[contains(text(),'Request Enrollment and B')]")
	WebElement RequestEnrollmentAndBillingOption;
	
	@FindBy(xpath="//*[text()='Request Premium Payment R...']")
	WebElement RequestPremiumPaymentReportOption;
	
	@FindBy(xpath="//*[text()='Reinstate Member']")
	WebElement ReinstateMemberOption;
	
	@FindBy(xpath="//*[text()='Accept Payment']")
	WebElement AcceptPaymentOption;
	
	@FindBy(xpath="//*[text()='Cancel Payment']")
	WebElement CancelPaymentOption;
	
	@FindBy(xpath="//*[text()='Unlock Accounts']")
	WebElement UnlockAccountsOption;
	
	@FindBy(xpath="//*[@class='menu-item-title-wrap']/..//*[text()='Complete Payment History']")
	WebElement CompletePaymentHistoryOption;
	
	//clicks on Other Actions at Complete Billing Review Page in Provider Flow
	public boolean clickonOtherActions(){
		return utils.clickAnelemnt(OtherActions, "ProviderCompleteBillingReview", "OtherActions");
	}

	//select Request Enrollment And Billing Action From Other actions at Complete Billing Review Page in Provider Flow
	public boolean selectRequestEnrollmentAndBillingActionFromOtheractions()throws InterruptedException{
		Thread.sleep(3000);
		return utils.clickAnelemnt(RequestEnrollmentAndBillingOption, "ProviderCompleteBillingReview", "RequestEnrollmentAndBillingOption");
	
	}
	
	//Request Premium Payment Report Is Not Available in Other actions Drop Down at Complete Billing Review Page in Provider Flow
	public boolean verifyRequestPremiumPaymentReportIsNotAvilable() {
		return utils.isProxyWebelement(RequestPremiumPaymentReportOption);
	}
	
	//Reinstate Member Is Not Available in Other actions Drop Down at Complete Billing Review Page in Provider Flow
	public boolean verifyReinstateMemberIsNotAvilable() {
		return utils.isProxyWebelement(ReinstateMemberOption);
	}
	
	//Accept Payment Is Not Available in Other actions Drop Down at Complete Billing Review Page in Provider Flow
	public boolean verifyAcceptPaymentIsNotAvilable() {
		return utils.isProxyWebelement(AcceptPaymentOption);
	}
	
	//Cancel Payment Is Not Available in Other actions Drop Down at Complete Billing Review Page in Provider Flow
	public boolean verifyCancelPaymentIsNotAvilable() {
		return utils.isProxyWebelement(CancelPaymentOption);
	}
	
	//Unlock Accounts Is Not Available in Other actions Drop Down at Complete Billing Review Page in Provider Flow
	public boolean verifyUnlockAccountsIsNotAvilable() {
		return utils.isProxyWebelement(UnlockAccountsOption);
	}
	
	//Complete Payment History Is Not Avilable in Otheractions Drop Down at Complete Billing Review Page in Provider Flow
	public boolean verifyCompletePaymentHistoryIsNotAvilable() {
		return utils.isProxyWebelement(CompletePaymentHistoryOption);
	}
	
	//expands the Items Discussed During Manage Enrollment and Billing Review For Small Group members at Complete Enrollment and Billing Review Page in Provider Flow
	@FindBy(xpath="//*[text()='Items Discussed During Manage Enrollment & Billing Review']")
	WebElement ItemsDiscussedDuringManageEnrollmentAndBillingReview;

	public boolean expandItemsDiscussedDuringManageEnrollmentAndBillingReview() throws InterruptedException{
		Thread.sleep(3000);
		
	return utils.clickAnelemnt(ItemsDiscussedDuringManageEnrollmentAndBillingReview, "ProviderCompleteBillingReview", "ItemsDiscussedDuringManageEnrollmentAndBillingReview");
	}
	
	//Instructional Text for SG Members Under Items Discussed During Manage Enrollment and Billing Review For Small Group members at Complete Enrollment and Billing Review Page in Provider Flow
	@FindBy(xpath="//div//*[@node_name='BillingRelatedInquiry']//P")
	WebElement BillingRelatedInquiryMSG;
	public boolean verifyTheInstructionalTextForSG(String[] message)
	{
		String BillingRelatedInquiryMSG = message[0];
		String BillingRelatedInquiryMSGFromUI = this.BillingRelatedInquiryMSG.getText().replaceAll(",", "").replaceAll("  ", " ");
		return utils.isvalueMatch_compareto(BillingRelatedInquiryMSGFromUI, BillingRelatedInquiryMSG);
	}
	
	@FindBy (xpath="//li[@title='Request Manager/OE Help']")	
	private WebElement lnkOthrActionsRequestManagerHelp;

	/**This functionality navigates to the Request Manager or OE help page by clicking Other actions button
	 * 
	 * @return
	 */
	public boolean navigatetoRequestManagerorOEHelp() {
		if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsRequestManagerHelp, "Manage Claim Review", "Request Adjustment");
		return false;
	}
}


