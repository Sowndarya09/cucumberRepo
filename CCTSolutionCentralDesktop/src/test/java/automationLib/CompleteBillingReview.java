package automationLib;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

/**
 * On clicking Submit in Manage Billing we are navigated to this page 
 * @author Shardul Negi
 *
 */
public class CompleteBillingReview {
	/**
	 * Methods in the Program 
	 */
	DataSet ds=new DataSet();
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(),20);

	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public CompleteBillingReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy (xpath="//img[contains(@src,'tool_icon_')]")	
	private WebElement btnImgTool;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;

	@FindBy(xpath="//select[@id='PrimaryReasonforBilling']")
	private WebElement dropdownReasonForContact;
	@FindBy(id="Notes")
	private WebElement txtBoxNotes;

	@FindBy(xpath="//table[@class='gridTable '][contains(@pl_prop,'TaggedItems')]")
	private WebElement tableItemsDiscussedDuringManageBillingReview;
	@FindBy(xpath="//table[@class='gridTable '][contains(@pl_prop,'BillingTeamNotes')]")
	private WebElement tableReviewBillingAction;

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


	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Billing Review']")
	private WebElement lnktxtItemsDiscussedManageBillingReview;
	@FindBy(linkText="Review Billing Action")
	private WebElement lnktxtReviewBillingActions;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions') or contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//li[@title='Reinstate Member']")	
	private WebElement lnkOthrActionsReinstateMember;
	@FindBy (xpath="//span[text()='Cancel Payment']/ancestor::a")	
	private WebElement lnkOthrActionsCancelPayment;

	@FindBy (xpath="//span[text()='Accept Payment']/ancestor::a")
	private WebElement lnkOthrActionsAcceptPayment;
	@FindBy (xpath="//li[@title='Request Manager/OE Help']")	
	private WebElement lnkOthrActionsReqstManagerHelp;
	@FindBy (xpath="//li[starts-with(@title,'Request Enrollment')]")	
	private WebElement lnkOthrActionsRequestBillingAction;
	@FindBy (xpath="//li[@title='Complete Payment History']")	
	private WebElement lnkOthrActionsRequestCompletePaymentHistory;
	@FindBy (xpath="//li[@title='Review Billing Informatio...']")	
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

	public boolean validateHeader(WebElement header)
	{
		utils.waitforpageload();
		if(header.isDisplayed())
		{
			if(header.getText().trim().equalsIgnoreCase("Complete Billing Review"))
			{
				System.out.println("Pass : The header matches the specks and is displayed as required. \n\n");
				return true ;
			}
		}
		err.logError("The header does not match the specified text.");
		return false; 
	}

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
						else
							System.out.println("Notes not present");
					else
						System.out.println("Created by not present");										
				else			
					System.out.println("Create Date not present");								
			else		
				System.out.println("Activity not present");				
		else	
			System.out.println("Billng action button not present");

		err.logError("Complete Billing Review", "review Billing Action table");
		return false;
	}

	public boolean completeBillingReviewandSubmitDidNotUnderStandBill()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Did not understand bill"))
				if(this.setTxtNotes("Test"))	
					return this.clickgetBtnSubmit();
		return false ;
	}

	public boolean completeBillingReviewandSubmitReceivedUnexpectedRefund()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Received unexpected refund"))
				if(this.setTxtNotes("Test"))	
					return this.clickgetBtnSubmit();
		return false ;
	}


	public boolean completeBillingReviewandSubmitRateorPremiumChanged()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Rate or premium changed"))
				if(this.setTxtNotes("Test"))	
					return this.clickgetBtnSubmit();
		return false ;
	}


	public boolean completeBillingReviewandSubmitPolicyCancelledUnexpected()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Policy cancelled"))
				if(this.setTxtNotes("Test"))	
					return this.clickgetBtnSubmit();
		return false ;
	}


	public boolean completeBillingReviewandSubmitRequestedCopyOfDocument()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Requested a copy of a document"))
				if(this.setTxtNotes("Test"))	
					return this.clickgetBtnSubmit();
		return false ;
	}


	public boolean completeBillingReviewandSubmitRequestedRefund()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Requested a refund"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}


	public boolean completeBillingReviewandSubmitUnabletofillprescription()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Unable to fill prescription"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}


	public boolean completeBillingReviewandSubmitMadePaymentNotLocatedInSystem()
	{
		if(this.validateHeader(this.getsHeaderCompleteBilling()))
			if(this.selectDropdownReasonForContact("Made a payment not located in system"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}


	public boolean navigatetoAcceptPayment()
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Accept Payment", "CompleteBillingReview", "btnOtherActions");
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
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsCancelPayment, "Billing Review", "cancelpaymentLinks"))
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
	public boolean navigatetoRequestEnrollment() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement element = btnOtherActions;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsRequestBillingAction, "Billing Review", "Links"))
				return true;
		return false;
	}

	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']//i")
	WebElement lableManageBillingCancelPaymentItemsDiscussed2;

	public boolean validatetaggedcheckboxes()
	{
		ArrayList<String> actual = null,expected=new ArrayList<String>(); 
		if(utils.clickAnelemnt(this.lableManageBillingCancelPaymentItemsDiscussed2, "Complete Billing", "Items Discussed"))

			actual=utils.getcolumnStringFromTableByName(this.tableItemsDiscussedDuringManageBillingReview,"Description");
		actual.remove(0);

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

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Premium Payment R...']")	
	WebElement lnkOthrActionsRequestPremiumPayment;


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigatetoRequestPremiumPaymentReport
	 * #Description: 
	 * Type:Textbox
	 */
	public boolean navigatetoRequestPremiumPayment()
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.drpDownOtherActions, "Billing Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsRequestPremiumPayment, "Billing Review", "Links"))
				return true;
		return false;
	}

	public boolean selectDropdownReasonForContactInCompBilling(String[] sReason)
	{
		return utils.selectDropDownbyVisibleString(this.dropdownReasonForContact, sReason[0], "Complete Billing Review ", "Drop Down to select the value");
	}

	public boolean selectValueFromOtherActions(String[] sReason)
	{
		return utils.selectValueFromListbyVisibleString(this.drpDownOtherActions, sReason[0], "Complete Billing Review ", "Value from Other Actions");
	}

	@FindBy(xpath="//input[@id='WCFNumber1']")
	WebElement WCFNumber;

	/**
	 * This method allows the user to enter the WCF number when premium payment report is generated through manage billing task
	 * @return
	 */

	public boolean enterWCFNumber()
	{
		return utils.enterTextinAnelemnt(WCFNumber,"1234567890","Complete Billing Review ", "WCF Number");
	}

	@FindBy(xpath="//label[@data-test-id='20181026122139083691236-Label']")
	WebElement fieldpasswordprovidedtoContract;

	@FindBy(xpath="//div[@class='field-item dataValueRead']/img")
	WebElement CheckboxPasswordprovidedtoContract;

	/**
	 * This Method validates the field label password provided to contact in complete billing review page
	 * @return
	 */

	public boolean validatePasswordProvidedtoContact()
	{
		String ActualField =fieldpasswordprovidedtoContract.getText();
		if( utils.isvalueMatch_compareto(ActualField, "Provided password to the contact"))
			return true;
		return false;
	}

	/**This method enters notes in the notes field
	 * 
	 */

	@FindBy(id="Notes")
	WebElement txtBxNotes;

	public boolean enterNotes(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxNotes, args[0], "CompleteBillingReview", "Notes");
	}
}
