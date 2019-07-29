package automationLib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.xerces.impl.dv.dtd.NMTOKENDatatypeValidator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResolveEnrollmentActions {



	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCreatePromisedAction;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement1;
	
	
	public ResolveEnrollmentActions()
	{
	PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	gotoLastIframe();
	/*try{
	Driver.getPgDriver().switchTo().defaultContent();
	Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver
	}catch(Exception e){
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
	}*/
		
	}


	//Sprint 3.1
	
	@FindBy(id="BillingTeamResponse")
	WebElement drpDownSelectEnrollmentTeamResponse;
	
	@FindBy(name="$PpyWorkPage$pReasonForPending")
	WebElement drpDownReasonForPending;
	
	@FindBy(id="FollowUpDate")
	WebElement txtFollowUpDate;
	
	@FindBy(id="Notes")
	WebElement txtNotes;
	
	@FindBy(id="//span[@id='PegaRULESErrorFlag']")
	WebElement labelErrorMsg;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//span[@data-test-id='2015011307071009054871']")
	WebElement labelStatusResponse;
	
	@FindBy(xpath="//table[@pl_prop='.BillingTeamNotesList']")
	WebElement tblReviewEnrollmentAction;
	
	
	
	public boolean selectEnrollmentTeamResponse(String[] args)
	{
			return utils.selectDropDownbyVisibleString(this.drpDownSelectEnrollmentTeamResponse, args[0], "ResolveEnrollmentActions", "Enrollment Team Response");	
	}
	
	public boolean verifyReasonForPendingIsDisplayed()
	{
			return !utils.isProxyWebelement(drpDownReasonForPending);
	}
	
	public boolean verifyNoReasonForPendingIsDisplayed()
	{
			return utils.isProxyWebelement(drpDownReasonForPending);
	}
	
	
	public boolean selectReasonForPendingForEnrollment(String[] args)
	{
			return utils.selectDropDownbyVisibleString(this.drpDownReasonForPending, args[0], "ResolveEnrollmentActions", "Reason For Pending");	
	}
	
	
	public boolean verifyFollowUpDateFieldIsDisplayed()
	{
			return !utils.isProxyWebelement(txtFollowUpDate);
	}
	
	public boolean verifyNoFollowUpDateFieldIsDisplayed()
	{
			return utils.isProxyWebelement(txtFollowUpDate);
	}
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate localDate = LocalDate.now().plusDays(1); 
	String Tdate=dtf.format(localDate );
	
	public boolean enterFollowUpDate(String[] args)
	{
			return utils.enterTextinAnelemnt(this.txtFollowUpDate, args[0], "ResolveEnrollmentActions", "Follow Up Date");	
	}
	
	
	public boolean enterFollowUpDateAsTodayplusone()
	{			
			return utils.enterTextinAnelemnt(this.txtFollowUpDate,Tdate, "ResolveEnrollmentActions", "Follow Up Date");	
	}
	
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "ResolveEnrollmentActions", "Submit");
	}
	
	public boolean enterNotes(String[] args)
	{
		return utils.enterTextinAnelemnt(this.txtNotes, args[0], "ResolveEnrollmentActions", "Notes");	
	}
	
	
	public boolean verifyTheErrorMsgInFollowUpDateWhenPastDateIsDisplayed(String[] args)
	{
			String actualText = args[0];
			String expectedText = this.labelStatusResponse.getText();
			return utils.isvalueMatch_contain(actualText, expectedText);
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
			return utils.validatetablerowbasedonvalues(this.tblReviewEnrollmentAction, tablevalues);
	}
	
	//Sprint 3.1
	
	
	
	public boolean verifyActivityLOgDetailsTable(String[] tablevalues)
	{
			return utils.validatetablerowbasedonvalues(this.tblReviewEnrollmentAction, tablevalues);
	}
	
	
	//Sprint 4.2
	
	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']")
	WebElement collapseIndicatorItemsDiscussed;
	
	@FindBy(xpath="//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png']")
	WebElement imgCheckMarkEnrollmentInquiry;
	
	@FindBy(xpath="//div[@node_name='EnrollmentRelatedInquiry']//p//span")
	WebElement labelInstructionalTextEnrollmentInquiry;
	
	@FindBy(id="BillingTeamResponse")
	WebElement drpDownEnrollmentTeamResponse;
	
	public boolean verifyItemsDiscusseDuringManageEAndBReviewSectionIsCollapsed()
	{
		return !utils.isProxyWebelement(collapseIndicatorItemsDiscussed);
	}
	
	public boolean expandTheItemsDiscusseDuringManageEAndBReviewSection()
	{
		return utils.clickAnelemnt(collapseIndicatorItemsDiscussed, "ResolveEnrollmentActions", "Click the Items Discussed");
	}
	
	public boolean verifyEnrollmentInfoDiscussedTextWithCheckMarkAndEnrollmentInstructionalTextIsDisplayed()
	{
		if(!utils.isProxyWebelement(imgCheckMarkEnrollmentInquiry))
			if(!utils.isProxyWebelement(labelInstructionalTextEnrollmentInquiry))
				return true;
		return false;
	}
	
	
	public boolean selectEnrollmentAndBillingTeamResponse(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownEnrollmentTeamResponse, args[0], "ResolveEnrollmentActions", "Enrollment Team Response");

	}
	
	@FindBy(id= "ReasonForExceptionReview")
	private WebElement dprodownReasonForExceptionReview;
	
	public boolean selectReasonforExceptionReview(String[] args)
	{		
		return utils.selectDropDownbyVisibleString(this.dprodownReasonForExceptionReview, args[0], "ResolveEnrollmentActions", "ExceptionReview");	
		
	}
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;

	public void gotoLastIframe(){
		System.out.println("1");
		Driver.getPgDriver().switchTo().defaultContent();
		System.out.println("2");
		int i=this.iframes.size();
		Driver.getPgDriver().switchTo().frame(i-1);
		System.out.println("##########");
	}	
	
	/**This functionality validates the skills assigned to the SR in the service request details page for COVA changes
	 * 
	 * @param args
	 * @return
	 */
	@FindBy(xpath="//*[text()='Skill Name']/ancestor::table[@id='bodyTbl_right']")
	WebElement SkillRequiredTable;
	
	@FindBy(xpath="(//div[@role='button'])[1]")
	WebElement clickToolIcon;


	@FindBy(xpath="//span[text()='View Skills']")
	WebElement clickOnViewSkills;

	/**This methods clicks the view skills option on clicking the tool icon on Service Request details page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickViewSkillsFromToolIcon() throws InterruptedException{
		Thread.sleep(3000);
		utils.scrolltoright();
		if(utils.clickAnelemnt(clickToolIcon, "ResolveUpdateOtherInsuranceRequest", "Tool icon"))
			if(utils.clickAnelemnt(clickOnViewSkills, "ResolveUpdateOtherInsuranceRequest", "View Skills"))
				return true;
		return false;

	}
	
	/**This functionality validates the skills assigned to the SR in the service request details page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateTheSRSkills(String[] args) {
		return utils.validatetablerowbasedonvalues(SkillRequiredTable, args);
	}
 }

