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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CSRReviewResolveRequest {


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

	public CSRReviewResolveRequest(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
		}catch(Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}

	}
	@FindBy(id="SelectNextAction")
	WebElement drpDownSelectNextAction;

	@FindBy(id="RequestedAction")
	WebElement RequestedAction;

	@FindBy(id="pyNote")
	WebElement txtNotes;

	@FindBy(xpath="//div[text()='Submit']")
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

		if(!utils.isProxyWebelement(drpDownSelectNextAction)) {
			action.moveToElement(drpDownSelectNextAction);
			return utils.selectDropDownbyVisibleString(drpDownSelectNextAction, args[0], "CSRReviewResolveRequest", "Next Action");
		}
		else {
			action.moveToElement(RequestedAction);
			return utils.selectDropDownbyVisibleString(RequestedAction, args[0], "CSRReviewResolveRequest", "RequestedAction");
		}
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
		utils.scrolltomiddle();
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].click();", btnSubmit);
		return true;
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
			WebElement element = this.tblActivityLog;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.validatetablerowbasedonvalues(this.tblActivityLog, tablevalues);
	}

	@FindBy(xpath="//div[@gpropindex='PReviewedClaims2']//table[@pl_prop='.ReviewedClaims']")
	WebElement tblClaimsTaggedInGA;

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
	public boolean validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment(String args[]){
		try{
			WebElement row =utils.returntablerowbasedonvalues(this.tblMiscellanousAccumulator,args);
			List<WebElement> chkbox = row.findElements(By.xpath("//td//img[@class='checkbox chkBxCtl']"));
			if(chkbox.get(0).isDisplayed()){
				System.out.println("Review Requested is checked");
			}
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input Accumulator -FamilyLevel" + e);
			return false;
		}
		return true;
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

	@FindBy(xpath="(//li[@title='Request Manager/OE Help'])[2]")
	WebElement RequestMgrHlpFrmCSRReview;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	/**
	 *  This method clicks on the Request Manager/OE help from other actions on the CSR review resolve request page
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectRequestManagerHelpFromOtherActions() throws InterruptedException
	{

		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Manager/OE Help", "CSRREviewResolveRequest", "Request Manager/OE Help");
	}

	@FindBy(id="CSResponse")
	WebElement drpDownNextActionAfterReviewManagerHelp;

	@FindBy(id="Notes")
	WebElement txtNotesAfterReviewManagerHelp;

	public boolean selectNextActionAfterClickingSubmitInReviewManagerHelp(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownNextActionAfterReviewManagerHelp, args[0], "CSRREviewResolveRequest", "Next Action");
	}

	public boolean enterNotesAfterClickingSubmitInReviewManagerHelp(String[] args)
	{
		return utils.enterTextinAnelemnt(this.txtNotesAfterReviewManagerHelp, args[0], "CSRReviewResolveRequest", "Next Action");

	}

	@FindBy(id="ReviewerCSResponse")
	WebElement drpDownSelectNextActionInCSR;

	public boolean selectNextActionInCSRReviewResolveRequest(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownSelectNextActionInCSR, args[0], "CSRREviewResolveRequest", "Next Action");
	}

}
