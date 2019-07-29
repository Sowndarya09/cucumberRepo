package automationLib;

import java.util.ArrayList;
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

public class ProviderCSRReviewResolveRequest {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;	

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement3;	

	@FindBy(xpath="//label[contains(text(),'Resolve Accumulator Review')]")
	WebElement resolveAccReviewLbl;	

	public ProviderCSRReviewResolveRequest(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try
		{

			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement3);
		}catch(Exception e)
		{
			try {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
			}catch(Exception e1) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			}
		}
	}


	@FindBy(id="SelectNextAction")
	WebElement drpDownSelectNextAction;

	@FindBy(id="pyNote")
	WebElement txtNotes;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="//table[@pl_prop='.AccumulatorNotesList']")
	WebElement tblActivityLog;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectNextAction
	 * #Description: Selects the Next Action drop down value in the CSR Review Resolve Request page
	 * #Argument: Next Action
	 * Type: Dropdown
	 * Keys: Send for Review#withdraw Request
	 */
	public boolean selectNextAction(String[] args)
	{
			return utils.selectDropDownbyVisibleString(this.drpDownSelectNextAction, args[0], "CSRReviewResolveRequest", "Next Action");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterNotes
	 * #Description: Enter the Notes in the notes section in the CSR Review Resolve Request page
	 * #Argument: Notes
	 * Type: Textbox
	 */
	public boolean enterNotes(String[] args)
	{
			return utils.enterTextinAnelemnt(this.txtNotes, args[0], "CSRReviewResolveRequest", "Next Action");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnBtnSubmit
	 * #Description: Clicks on the Submit button in the CSR Review Resolve Request page
	 * Type: Textbox
	 */
	public boolean clickOnBtnSubmit()
	{
			return utils.clickAnelemnt(this.btnSubmit,"CSRReviewResolveRequest", "Next Action");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateActivityLogTableInCSRReview
	 * #Description: Validates the Activity log table value present with the values given by the user
	 * #Argument: Activity Log - Keyvaluepair
	 * Type: Table
	 * Keys: Create Date#Created By#Notes#Activity
	 */
	public boolean validateActivityLogTableInCSRReview(String[] tablevalues)
	{
			action.moveToElement(tblActivityLog);
			return utils.validatetablerowbasedonvalues(this.tblActivityLog, tablevalues);
	}
	
	@FindBy(xpath="imgOneDayGrievanceIndicator")
	WebElement imgOneDayGrievanceIndicator;

	@FindBy(xpath="//div[@gpropindex='PReviewedClaims2']//table[@pl_prop='.ReviewedClaims']")
	WebElement tblClaimsTaggedInGA;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimNumberGATaggedWithOneDayGrievance
	 * #Description:This method validates the Claim Number tagged with One Day Grievance Indicator checked.
	 * #Arguments:ClaimNumberTagged
	 * Type:Textbox
	 */
	public boolean validateClaimNumberWithOneDayGrievanceGATagged(String[] tablevalues){  
		try{
			WebElement row = utils.returntablerowbasedonvalues(tblClaimsTaggedInGA, tablevalues);
			List<WebElement> rowValues = row.findElements(By.tagName("td"));
			rowValues.get(4).click();
			return true;
		}
		catch (Exception e){
			System.out.println("Unable to verify - Claims Tagged For GA Review - Grievance and Appeal is not checked"+e);
			return false;
		}
	}


	public boolean verifyClaimHasOneDayGrievanceIndicatorIsDisplayedInItemsReviewedTable()
	{
		return !utils.isProxyWebelement(imgOneDayGrievanceIndicator);
	}
	
	@FindBy(xpath="//table[@pl_prop='.MiscellaneousAccumList']")
	WebElement tblMiscellanousAccumulator;

	@FindBy(xpath="//span[contains(text(),'Miscellaneous Accumulators')]")
	WebElement lnkMiscellanousAccumulators;

	public boolean verifyMiscellaneousAccumulatorsSectionIsDisplayed()
	{
		return !utils.isProxyWebelement(lnkMiscellanousAccumulators);
	}

	/*	
	 * @SCU
	 * #CommonMethodWithArgument:validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment
	 * #Description:This functionality validates the Miscellanous Accumulator tagged or reviewed.
	 * #Argument:MiscellanousAccumsLevelTagged
	 * Type:Table
	 * Keys:Name#Description#From Thru#Unit#Amount
	 */
	public boolean validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment(String args[]) throws InterruptedException{
			WebElement row =utils.returntablerowbasedonvalues(this.tblMiscellanousAccumulator,args);
			List<WebElement> chkbox = row.findElements(By.xpath("//td//img[@class='checkbox chkBxCtl']"));
			if(chkbox.get(0).isDisplayed()){
				return true;
			}
		return false;
	}

	@FindBy(id="ReasonForUrgency")
	WebElement ReasonForUrgency;

	/**This functionality validates the reason for urgency dropdown options are available or not
	 * 
	 * @return
	 */
	public boolean validateReasonForUrgencyDropDownValuses(String[] args) {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		for(String value:args) {
			valuestobechecked.add(value);
		}
		return utils.checkvaluesinDropDown(ReasonForUrgency, valuestobechecked);
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy(xpath="(//li[@title='Request Manager/OE Help'])[2]")
	WebElement RequestMgrHlpFrmCSRReview;

	/**
	 *  This method clicks on the Request Manager/OE help from other actions on the CSR review resolve request page
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectRequestManagerHelpFromOtherActions() throws InterruptedException
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "Request Manager/OE Help", "Provider CSR REview Resolve Request", "Request Manager/OE Help");
	}


	@FindBy(xpath="//*[@data-test-id='201801251040560076186883']")
	WebElement TypeValue;

	@FindBy(xpath="//*[@data-test-id='201801091013470060279']")
	WebElement CategoryValue;

	@FindBy(xpath="//*[@data-test-id='20180109101347006028258']")
	WebElement SubCategoryValue;

	@FindBy(xpath="//*[text()='Line Of Business']/../..//*[@data-test-id='20180109101347006028258']")
	WebElement LineOfBusinessValue;

	@FindBy(xpath="//*[text()='Describe the issue']/../..//*[@data-test-id='201510091322310162184450']")
	WebElement IssueValue;

	@FindBy(xpath="//*[text()='What is the expected resolution?']/../..//*[@data-test-id='201510091322310162184450']")
	WebElement ExpectedResolutionValue;

	@FindBy(xpath="//label[text()='Escalate']/../../..//img[@title='Checked']")
	WebElement EscalationValue;

	@FindBy(xpath="//span[@data-test-id='201811261709030824286536']")
	WebElement EscalationReasonValue;
	
	@FindBy(xpath="//label[text()='Is this related to more claims for other members?']/..//img[@title='Checked']")
	WebElement IsRelatedToOtherMembers;
	
	@FindBy(xpath="//label[text()='Is this related to more claims for this member?']/..//img[@title='Checked']")
	WebElement IsRelatedToThisMember;

	/**This method validate The Items Discussed During Payment Dispute Review
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateItemsDiscussedDuringPaymentDisputeReview(String[] args) {
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ProviderCSRReviewResolveRequest", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"type")){
				returnvar = utils.validateLabel(TypeValue, value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"category")){
				returnvar = utils.validateLabel(CategoryValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"sub-category")){
				returnvar = utils.validateLabel(SubCategoryValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"line of business")){
				returnvar = utils.validateLabel(LineOfBusinessValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"issue")){
				utils.scrolltomiddle();
				returnvar = utils.validateLabel(IssueValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"resolution")){
				returnvar = utils.validateLabel(ExpectedResolutionValue, value);
				continue;
			}else if(utils.isvalueMatch_contain(key,"escalate")) {
				if(utils.isvalueMatch_contain("yes", value))
					returnvar = !utils.isProxyWebelement(EscalationValue);
				continue;
			}else if(utils.isvalueMatch_contain(key,"escalation reason")) {
				returnvar = utils.validateLabel(EscalationReasonValue, value);
				continue;
			}else if(utils.isvalueMatch_contain(key,"is this related to more claims for other members")) {
				if(utils.isvalueMatch_contain("yes", value))
				returnvar = !utils.isProxyWebelement(IsRelatedToOtherMembers);
				continue;
			}else if(utils.isvalueMatch_contain(key,"is this related to more claims for this member")) {
					if(utils.isvalueMatch_contain("yes", value))
					returnvar = !utils.isProxyWebelement(IsRelatedToThisMember);
					continue;
			}
			else 
				err.logcommonMethodError("ProviderPaymentDisputeReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			blogger.loginfo("Verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ProviderCSRReviewResolveRequest", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}
	
	@FindBy(xpath="//*[@data-test-id='201809281344180664182217']")
	WebElement PDIcon;
	
	@FindBy(xpath="//*[@class='arrow top']/..//div[@id='poc0']")
	WebElement PDHovertext;
	
	/**This functionality validates the Payment Disputes Hover text as Payment Dispute at CLaims Details Grid in Claims Review Page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyPaymentDisputesHoverTextinPDServiceRequestDetailspage() throws InterruptedException {
		String actual = utils.hoverOverElementAndGetText(PDIcon, PDHovertext);
		System.out.println(actual);
		return utils.isvalueMatch_contain(actual, "Payment Dispute");
	}


}
