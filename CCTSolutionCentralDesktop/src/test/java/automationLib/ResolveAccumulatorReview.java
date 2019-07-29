package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.JavascriptExecutor;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResolveAccumulatorReview {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement1;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement3;

	@FindBy(xpath="//label[contains(text(),'Resolve Accumulator Review')]")
	WebElement resolveAccReviewLbl;

	@FindBy(xpath="//span[@id][contains(text(),'Member Level')]//ancestor::div[@id='EXPAND-PLUSMINUS']//following-sibling::div//table[@class='gridTable ']")
	WebElement memberLevelAccumList;
	//span[@id][contains(text(),'Family Level')]//parent::div//parent::div//parent::div//following-sibling::div//*[@pl_prop='.FamilyLevelAccumList']
	//*[@param_name='EXPANDEDSubSectionReviewAccumsInfoBBB~pzLayout_1']
	//*[@pl_prop='.FamilyLevelAccumList']

	@FindBy(xpath="//span[@id][contains(text(),'Family Level')]//ancestor::div[@id='EXPAND-PLUSMINUS']//following-sibling::div//table[@class='gridTable ']")
	WebElement familyLevelAccumList;

	@FindBy(xpath="//table[@pl_prop='.BenefitLevelAccumList']")
	WebElement benefitLevelAccumList;

	public ResolveAccumulatorReview(){
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyResolveAccReviewPage
	 * Type:Textbox
	 * Description: To verify, user is navigated to "Resolve Accumulator Review" page.
	 */
	public boolean verifyResolveAccReviewPage(){
		//Resolve Accumulator Review     
		if(utils.validateHeader(this.resolveAccReviewLbl, "Resolve Accumulator Review")){
			System.out.println("ResolveAccumulatorReview - Resolve Accumulator Review page is displayed");
			//Check the Member Level ,Family Level and Benefit Level tables display Accum Code in the table header.
			return true;
		}
		return false;
	}

	@FindBy(xpath="//b[text()='Items Discussed During Accumulators']")
	WebElement itemsDiscussedDuringAcc;

	public WebElement getMemberlevelTable(){
		List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//table[contains(@pl_prop,'.FamilyLevelAccumList')]"));
		return tables.get(0);
	}

	public WebElement getFamilylevelTable(){
		List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//table[contains(@pl_prop,'.FamilyLevelAccumList')]"));
		return tables.get(1);
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateMemberAndFamilyLevelAccumHeaders
	 * Arguments:Column Headers to be entered -as comma separated values-"Network,Accum Code,Accumulator Description,Limit,Accumulated,Remaining"
	 * Type:Textbox
	 * Description: To validate column headers displayed upon search
	 */
	public boolean validateMemberAndFamilyLevelAccumHeaders(String[] args){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.itemsDiscussedDuringAcc);
		String space = " , , , ";
		StringBuilder input = new StringBuilder();
		System.out.println("Newly constructed Input:"+input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).append(",").append(args[5]).toString());
		String colHdrs[] = input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).append(",").append(args[5]).toString().split(",");
		if((utils.validateTableRowHeader(getMemberlevelTable(), colHdrs)) && (utils.validateTableRowHeader(getFamilylevelTable(), colHdrs)))
			return true;
		else 
			err.logError("ResolveAccumulatorReview", "Column headesr doesnt match- Member & Family Level Acc List ");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateBenefitLevelAccumHeaders
	 * Arguments:Column Headers to be entered -as comma separated values-"Primary Benefit,Accum Code,All Benefit(s) Included,Accumulator Limitation(s),Type,Limit,Accumulated,Remaining"
	 * Type:Textbox
	 * Description: To validate column headers displayed upon search - Benefit Level
	 */
	public boolean validateBenefitLevelAccumHeaders(String[] args){
		String space = " , , , ";
		StringBuilder input = new StringBuilder();
		System.out.println("Newly constructed Input:"+input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).append(space).append(",").append(args[5]).append(",").append(args[6]).append(",").append(args[7]).toString());
		String colHdrs[] = input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).append(space).append(",").append(args[5]).append(",").append(args[6]).append(",").append(args[7]).toString().split(",");
		if(utils.validateTableRowHeader(this.benefitLevelAccumList, colHdrs))
			return true;
		else 
		return false;
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateMemLevelAccList
	 * #Arguments:Accum Code, Description -KeyValuePair
	 * Type:Table
	 * Keys:#Accum Code#Accumulator Description
	 * Description: System should display the accumulator code next to the description
	 * in the service request being sent to the accumulator review area.
	 */
	public boolean validateMemLevelAccList(String[] args) throws InterruptedException{
		if(utils.clickontablerowbasedonvalues(getMemberlevelTable(),args))
			return true;
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateFamilyLevelAccList
	 * #Arguments:Accum Code, Description -KeyValuePair
	 * Type:Table
	 * Keys:#Accum Code#Accumulator Description
	 * Description: System should display the accumulator code next to the description
	 * in the service request being sent to the accumulator review area.
	 */
	public boolean validateFamilyLevelAccList(String[] args) throws InterruptedException{
		if(utils.clickontablerowbasedonvalues(getFamilylevelTable(),args))
			return true;
		return false;

	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateBenefitLevelAccList
	 * #Arguments:Accum Code,All Benefit(s) Included -KeyValuePair
	 * Type:Table
	 * Keys:#Accum Code#All Benefit(s) Included
	 * Description: System should display the accumulator code next to the description
	 * in the service request being sent to the accumulator review area.
	 */
	public boolean validateBenefitLevelAccList(String[] args) throws InterruptedException{
		if(utils.clickontablerowbasedonvalues(this.benefitLevelAccumList,args))
			return true;
		return false;

	}

	//Sprint 2.4

	@FindBy(xpath="//table[@pl_prop='.AccumulatorNotesList']")
	WebElement tblActivityLog;

	@FindBy(id="SelectNextAction")
	WebElement drpDownAccumsResponse;

	@FindBy(id="pyNote")
	WebElement txtNotes;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateActivityLogTableInResolveAccumulator
	 * Description: Validates the Activity log table displayed with the values given by the user
	 * #Arguments:Activity Log - Keyvaluepair
	 * Type:Table
	 * Keys:Created Date#Created By#Notes#Activity
	 */
	public boolean validateActivityLogTableInResolveAccumulator(String[] tablevalues)
	{
			WebElement element = this.tblActivityLog;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.validatetablerowbasedonvalues(this.tblActivityLog, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:Select_Accums_Team_Response
	 * Description: Selects the drop down option given by the user in the Accums Team Response drop down
	 * #Arguments:Accums Response
	 * Type:Dropdown
	 * Keys:Select#Pending Response from Other Area#Request Additional Information#Request Complete#Requested in Error
	 */
	public boolean Select_Accums_Team_Response(String[] args)
	{
		action.moveToElement(drpDownAccumsResponse);
		return utils.selectDropDownbyVisibleString(this.drpDownAccumsResponse,args[0], "ResolveAccumulatorReview", "Accums Response drop down");			
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterNotes
	 * Description: Enter the notes in the Notes section in Resolve Accumulator Page
	 * #Arguments:Notes
	 * Type:Textbox
	 */
	public boolean enterNotes(String[] args)
	{
			return utils.enterTextinAnelemnt(this.txtNotes,args[0], "ResolveAccumulatorReview", "Notes");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnBtnSubmit
	 * Description: Click the Submit button in the Resolve Accumulator Review page
	 * Type:Textbox
	 */
	public boolean clickOnBtnSubmit()
	{
			return utils.clickAnelemnt(this.btnSubmit,"ResolveAccumulatorReview", "Submit");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:SelectNextAction
	 * Description: Selects the drop down option given by the user in the Next Action drop down
	 * #Arguments:Next Action
	 * Type:Dropdown
	 * Keys:Send for review#Withdraw Request
	 */
	public boolean SelectNextAction(String[] args)
	{
			return utils.selectDropDownbyVisibleString(this.drpDownAccumsResponse,args[0], "ResolveAccumulatorReview", "Accums Response drop down");
	}

	//Sprint 3.4


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
				return true;
			}
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input Accumulator -FamilyLevel" + e);
			return false;
		}
		return false;
	}

	@FindBy(id="ReasonForPending")
	WebElement drpReasonForPending;

	public boolean selectReasonForPending(String[] args)
	{
		return 	utils.selectDropDownbyVisibleString(this.drpReasonForPending, args[0], "Resolve Accumulator", "Reason for pending");
	}

	@FindBy(xpath="//span[@data-test-id='20180716193156091377235']")
	WebElement FollowUpDate;

	public boolean verifyFollowUpDate()
	{
		String Followup = utils.getValuefromTextBox1(FollowUpDate, "Resolve Accumulator", "FollowUpDate");
		System.out.println("Follow up date for pend reason is "+Followup);
		return true;
	}

	@FindBy(id="ReasonForSending")
	private WebElement drpReasonForSending;

	public boolean selectReasonForSending(String[] args)
	{
		return 	utils.selectDropDownbyVisibleString(drpReasonForSending, args[0], "Resolve Accumulator", "Reason for sending");
	}

}
