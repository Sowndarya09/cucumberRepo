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

public class ProviderResolveClaimAdjustmentRequest {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCreatePromisedAction;
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement2;


	public ProviderResolveClaimAdjustmentRequest()
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
				return utils.clickAnelemnt(this.btnSubmit, "Resolve Claim Adjustment", "Submit button");
		return false;

	}

	public boolean validateActivityLogTable(String[] values)
	{
		return utils.validateRowValues(this.tableActivityLog, values);
	}

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

		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		return 	utils.selectDropDownbyVisibleString(drpdwnClaimsTeamResponse, drpdwnval[0], "ResolveClaimAdjustmentRequest", "Response Reason");

	}

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
		WebElement element = this.tableActivityLog;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.validatetablerowbasedonvalues(this.tableActivityLog, tablevalues);
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDropDownValuesInSelectReasonForPending
	 * #Description:This method validates the dropdown values displayed for 'Reason For Pending' on 'Resolve Claim Adjustment' page.
	 * Type:TextBox
	 */
	public boolean verifyDropDownValuesInSelectReasonForPending(){
		String action[] = {"Behavior Health","Eligibility Update","High Dollar Audit","Missouri Mercy","OrthoNet","PrePay Review","SIU","Subrogation/Worker's Comp"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(action));
		return utils.checkvaluesinDropDown(this.drpdwnReasonfrPending,al);
	}

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
	public boolean validateClaimNumberWithOneDayGrievanceGATagged(String[] tablevalues){  
		try{
			WebElement row = utils.returntablerowbasedonvalues(tblClaimsTaggedInGA, tablevalues);
			WebElement imgOneDayGrievance = row.findElement(By.xpath("//td[7]//img"));
			if(imgOneDayGrievance.isDisplayed())
			{
				System.out.println("One Day Grievance checked icon is displayed");
				blogger.loginfo("One Day Grievance checked icon is displayed");
				return true;
			}else
			{
				System.out.println("One Day Grievance checked icon is not displayed");
				blogger.loginfo("One Day Grievance checked icon is not displayed");
				return false;
			}

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


	public boolean validateOneDayGrievanveSectionIsChecked()
	{
		return !utils.isProxyWebelement(imgOneDayGrievanceChecked);
	}


	public boolean validateOneDayGrievanveSectionIsNotChecked()
	{
		return utils.isProxyWebelement(imgOneDayGrievanceChecked);
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
			if(utils.enterTextinAnelemnt(txtbxNotes, args[1], "ResolveClaimAdjustmentRequest", "Notes")) {
				utils.scrolltomiddle();
				return utils.clickAnelemnt(btnSubmit, "ResolveClaimAdjustmentRequest", "Submit");
			}
		return false;
	}
}


