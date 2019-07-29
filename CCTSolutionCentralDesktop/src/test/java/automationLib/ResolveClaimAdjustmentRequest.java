package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResolveClaimAdjustmentRequest {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCreatePromisedAction;
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement2;


	public ResolveClaimAdjustmentRequest()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
		}catch(Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}

	}

	@FindBy(xpath="//select[@id='ClaimTeamResponse']")
	WebElement drpdwnClaimsTeamResponse;

	@FindBy(id="ReasonForSending")
	WebElement drpdwnReasonfrSending;

	@FindBy(id="pyNote")
	WebElement txtbxNotes;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="//div[contains(@datasource,'MemberClaim.ActivityLogList')]//table[@class='gridTable ']")
	WebElement tableActivityLog;

	public boolean TagServiceRequesttoMyTeam(String[] reasonforsending)
	{
			String value;
			if(reasonforsending[0].contains(":"))
			{
				String key = reasonforsending[0].substring(0, reasonforsending[0].indexOf(":")).toLowerCase();
				value = reasonforsending[0].substring(reasonforsending[0].indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
			}else
				value=reasonforsending[0];

			if(utils.selectDropDownbyVisibleString(this.drpdwnClaimsTeamResponse, "Send to my Team", "Resolve Claim Adjustment", " Claim team response Drop Down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnReasonfrSending, value, "Resolve Claim Adjustment", "Reason for Sending Drop Down"))
					if(utils.clickAnelemnt(this.btnSubmit, "Resolve Claim Adjustment", "Submit button"))
						return true;
				return false;
	}

	public boolean validateActivityLogTable(String[] values)
	{
		if(utils.validateRowValues(this.tableActivityLog, values))
			return true;
		else
			return false;
	}



	//Sprint 1.4

	@FindBy(id="ReasonForPending")
	WebElement drpdwnReasonfrPending;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:Select_Reason_For_Pending
	 * #Description: This functionality selects the reason for pending by getting the drop down value from the user.
	 * #Arguments:Reason_For_Pending
	 * Type:Dropdown
	 * Keys:Select#COB Update#External Pricing#Finance (RM)#Help Requested#Provider Update#PSCCR - Medical Review#System Issue
	 */

	public boolean Select_Reason_For_Pending(String[] reasonforpending)
	{
			return utils.selectDropDownbyVisibleString(drpdwnReasonfrPending, reasonforpending[0], "ResolveClaimAdjustmentRequest", "Sending Reason");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:Select_Submit
	 * #Description: This functionality performs selecting the submit button in Resolve Claim Adjustment request page.
	 * Type:Textbox
	 */
	public boolean Select_Submit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(btnSubmit, "ResolveClaimAdjustmentRequest", "Submit");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgumnet: enterNotes
	 * #Description: This functionality enters the notes in the notes section in the Resolve Claim Adjustment Request page
	 * #Argument: Notes
	 * Type: Textbox
	 */
	public boolean enterNotes(String[] notes)
	{
		return utils.enterTextinAnelemnt(txtbxNotes, notes[0], "ResolveClaimAdjustmentRequest", "Notes");

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:Select_Claims_Team_response
	 * #Description: This functionality selects the claims team response by getting the drop down value from the user. 
	 * #Arguments:Select_Claims_Team_response
	 * Type:Dropdown
	 * Keys:Select#Pending Reason from Other Area#Request Additional Information#Request Complete#Requested in Error#Send to My Team
	 */

	public boolean Select_Claims_Team_response(String[] drpdwnval)
	{
		return 	utils.selectDropDownbyVisibleString(drpdwnClaimsTeamResponse, drpdwnval[0], "ResolveClaimAdjustmentRequest", "Response Reason");

	}


	//Sprint 2.4

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateActivityLogTable
	 * #Description: This functionality validates the value given by the user with the value present in the Activity log table
	 * #Argument: Activity Log - Keyvaluepair
	 * Type: Table
	 * Keys: Created Date#Created By#Notes#Activity
	 */
	public boolean validateActivityLogTableInClaimResolve(String[] tablevalues)
	{
		utils.waitForElementToBeVisible(tableActivityLog);
			WebElement element = this.tableActivityLog;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.validatetablerowbasedonvalues(this.tableActivityLog, tablevalues);
	}


	//Sprint 3.1

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDropDownValuesInSelectReasonForPending
	 * #Description:This method validates the dropdown values displayed for 'Reason For Pending' on 'Resolve Claim Adjustment' page.
	 * Type:TextBox
	 */
	public boolean verifyDropDownValuesInSelectReasonForPending(){
		String action[] = {"Behavior Health","Eligibility Update","High Dollar Audit","Missouri Mercy","OrthoNet","PrePay Review","SIU","Subrogation/Worker's Comp"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(action));
		if(utils.checkvaluesinDropDown(this.drpdwnReasonfrPending,al)){
			System.out.println("Values in UI matched for related fields in 'Select Next Action' dropdown");
			return true;
		}else{
			err.logError("ResolveGrievanceAndAppeals", "validateSelectNextActionDrpdown - Values in UI didnt match for fields in 'Select Next Action' dropdown");
			return false;
		}

	}

	//Sprint 3.2



	/*
	 * @SCU
	 * #CommonMethodwithArgument:Select_Reason_For_Sending
	 * #Description: This functionality selects the reason for sending by getting the drop down value from the user.
	 * #Arguments:Reason_For_Sending
	 * Type:Dropdown
	 * Keys:Select#COB Update#External Pricing#Finance (RM)#Help Requested#Provider Update#PSCCR - Medical Review#System Issue
	 */

	public boolean Select_Reason_For_Sending(String[] reasonforsending)
	{
			return utils.selectDropDownbyVisibleString(drpdwnReasonfrSending, reasonforsending[0], "ResolveClaimAdjustmentRequest", "Sending Reason");
	}

	//Sprint 3.3

	@FindBy(xpath="//label[@for='IsOneDayGrievance']//following-sibling::div")
	WebElement imgOneDayGrievanceChecked;

	@FindBy(xpath="//img[@data-test-id='20160127122348051611158']")
	WebElement imgOneDayGrievanceIndicator;

	@FindBy(xpath="//table[@pl_prop='.ReviewedClaims']")
	WebElement tblClaimsTaggedInGA;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimNumberGATaggedWithOneDayGrievance
	 * #Description:This method validates the Claim Number tagged with One Day Grievance Indicator checked.
	 * #Arguments:ClaimNumberTagged
	 * Type:Textbox
	 */
	public boolean validateClaimNumberWithOneDayGrievanceGATagged(String[] tablevalues) throws InterruptedException{  
			WebElement row = utils.returntablerowbasedonvalues(tblClaimsTaggedInGA, tablevalues);
			WebElement imgOneDayGrievance = row.findElement(By.xpath("//td[7]//img"));
			return !utils.isProxyWebelement(imgOneDayGrievance);
	}


	public boolean verifyClaimHasOneDayGrievanceIndicatorIsDisplayedInItemsReviewedTable()
	{
			return !utils.isProxyWebelement(imgOneDayGrievanceIndicator);
	}


	public boolean validateOneDayGrievanveSectionIsChecked()
	{
			return !utils.isProxyWebelement(imgOneDayGrievanceChecked);
	}


	public boolean validateOneDayGrievanveSectionIsNotChecked()
	{
			boolean bol = imgOneDayGrievanceChecked.isDisplayed();
			System.out.println("Boolean value: "+bol);
			if(bol==true)
			{
				blogger.loginfo("One Day Grievance checked is Displayed");
				System.out.println("One Day Grievance checked is Displayed");
				return false;
			}else
			{
				blogger.loginfo("One Day Grievance checked is not Displayed");
				System.out.println("One Day Grievance checked is not Displayed");
				return true;
			}
	}


	public boolean verifyNoDropDownIsDisplayedWhenChoosingOtherThanPendingFromOtherArea()
	{
			return utils.isProxyWebelement(drpdwnReasonfrPending);
	}

	/**This functionality selects the claims team response by getting the drop down value from the user and selct submit
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectClaimsTeamResponseAndSubmit(String[] args) {
		if(utils.selectDropDownbyVisibleString(drpdwnClaimsTeamResponse, args[0], "ResolveClaimAdjustmentRequest", "Response Reason"))
			if(utils.enterTextinAnelemnt(txtbxNotes, args[1], "ResolveClaimAdjustmentRequest", "Notes"))
				utils.scrolltomiddle();
				return utils.clickAnelemnt(btnSubmit, "ResolveClaimAdjustmentRequest", "Submit");
	}
	
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


