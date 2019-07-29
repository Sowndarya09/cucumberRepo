package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ReviewBillingEnrollmentResponse {
	
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement1;
	
	public ReviewBillingEnrollmentResponse(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver
			}catch(Exception e){
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
			}
	}
	
	@FindBy(xpath="//table[@pl_prop='.EANDBCancelMemberList']")
	private WebElement selectMemberTable;
	@FindBy(xpath="//a[@issprite='true'][contains(@name,'CPMPortalRecents.pxResults')]")
	private WebElement closeResults;
	@FindBy(xpath="//*[@id='ModalButtonSubmit']")
	private WebElement modal_Yes;
	@FindBy(xpath="//label[contains(text(),'Review Enrollment Response')]")
	private WebElement reviewEnrollmentResponseLbl;
	
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
		if(utils.validateHeader(this.reviewEnrollmentResponseLbl, "Review Enrollment Response")){
			System.out.println("ReviewBillingEnrollmentResponse - Review Enrollment Response page is displayed");
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
				err.logError("ReviewBillingEnrollmentResponse", "validateSelectMemberSection");
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

	//Sprint 4.2
	
	@FindBy(id="CSRReviewResponse")
	WebElement drpDownSelectNextAction;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	@FindBy(id="Notes")
	WebElement txtBxNotes;
	
	public boolean selectNextAction(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownSelectNextAction, args[0], "ReviewBillingEnrollmentResponse", "Select Next Action");
	}
	
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(btnSubmit, "ReviewBillingEnrollmentResponse", "Submit");
	}
	
	public boolean enterNotes(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxNotes, args[0], "ReviewBillingEnrollmentResponse", "Notes");
	}
	
	@FindBy(xpath="//table[@pl_prop='.BillingTeamNotesList']")
	WebElement tblReviewEnrollmentAction;
	
	public boolean verifyActivityLOgDetailsTable(String[] tablevalues)
	{
			return utils.validatetablerowbasedonvalues(this.tblReviewEnrollmentAction, tablevalues);
	}
	
	//Sprint 4.2
	
	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']")
	WebElement collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview;
	
	@FindBy(xpath="//div[@title='Disclose Enrollment Related Inquiry']")
	WebElement collapseIndicatorEnrollmentRelatedEnquiry;
	
	@FindBy(xpath="(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[1]")
	WebElement imgEnrollmentDiscussedWithContact;
	
	@FindBy(xpath="//div[@title='Disclose Billing Related Inquiry']")
	WebElement collapseIndicatorBillingRelatedEnquiry;
	
	@FindBy(xpath="(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[2]")
	WebElement imgBillingDiscussedWithContact;
	
	@FindBy(xpath="//div[@title='Disclose Group Contact Information']")
	WebElement collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry;
	
	@FindBy(xpath="//table[@pl_prop='.GroupContacts']")
	WebElement tblEmployeeGroupInformation;
	
	@FindBy(xpath="//table[@pl_prop='.SubGroupContacts']")
	WebElement tblProductGroupInformation;

	

	public boolean verifyItemsDiscusseDuringManageEAndBReviewSectionIsCollapsed()
	{
		return !utils.isProxyWebelement(collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview);
	}
	
	
	public boolean expandTheItemsDiscusseDuringManageEAndBReviewSection()
	{
		return utils.clickAnelemnt(collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview, "ReviewBillingEnrollmentResponse", "Expand the Collapse Indicator");
	}
	
	

	public boolean expandTheEnrollmentRelatedEnquirySection()
	{
		return utils.clickAnelemnt(collapseIndicatorEnrollmentRelatedEnquiry, "ReviewBillingEnrollmentResponse", "Clicking on Collapse Indicator - Enrollment");
	}

	public boolean verifyEnrollmentInfoDiscussedTextAndEnrollmentInstructionalTextIsDisplayed()
	{
		return !utils.isProxyWebelement(imgEnrollmentDiscussedWithContact);
	}
	
	
	public boolean expandTheBillingRelatedEnquirySection()
	{
		return utils.clickAnelemnt(collapseIndicatorBillingRelatedEnquiry, "ReviewBillingEnrollmentResponse", "Clicking on Collapse Indicator - Billing");
	}
	
	public boolean verifyBillingInfoDiscussedTextAndBillingInstructionalTextIsDisplayed()
	{
		return !utils.isProxyWebelement(imgBillingDiscussedWithContact);
	}
	
	public boolean expandGroupContactInformationSection()
	{
		return utils.clickAnelemnt(collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry, "ReviewBillingEnrollmentResponse", "Clicking on Collapse Indicator - Group Contact Information");
	}

	
	public boolean validateEmployerGroupInformationUnderGroupContactSection(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(tblEmployeeGroupInformation, tablevalues);
	}
	
	public boolean validateProductGroupInformationUnderGroupContactSection(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(tblProductGroupInformation, tablevalues);
	}
	
	
	//Sprint 6.3
	
	@FindBy(xpath="(//li[@title='Request Manager/OE Help'])[2]")
	WebElement RequestMgrHlpFrmCSRReview;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	
	/**
	 *  This method clicks on the Request Manager/OE help from other actions on the Review billing response page
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectRequestManagerHelpFromOtherActions() throws InterruptedException
	{
	
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Manager/OE Help", "CSRREviewResolveRequest", "Request Manager/OE Help");
	}
	
}



