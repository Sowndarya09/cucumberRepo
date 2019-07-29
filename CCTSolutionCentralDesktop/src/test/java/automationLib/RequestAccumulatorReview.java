/**
 * 
 */
package automationLib;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;


public class RequestAccumulatorReview {
	
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;	

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement2;
	
	@FindBy(xpath="addHyperlink")
	private WebElement addLink;
	
	@FindBy(xpath="addAccumulatorDropdown")
	private WebElement addAccDrpdown;
	
	@FindBy(id="ReasonForReview")
	private WebElement reviewReason;
	
	@FindBy(xpath="nextActionDropdown")
	private WebElement nextAction;
	
	@FindBy(xpath="urgentRequestCheckbox")
	private WebElement urgentRequest;
	
	@FindBy(xpath="RequestExceptionReviewRadio")
	private WebElement reqExceptionReview;
	
	@FindBy(xpath="UrgentReasonDropdown")
	private WebElement urgentReason;
	
	@FindBy(xpath="//div[@node_name='RequestAccumulatorAdjustmentOptions']//textarea[@id='pyNote']")
	private WebElement notes;


	public WebElement getAddLink() {
		return addLink;
	}

	public WebElement getAddAccDrpdown() {
		return addAccDrpdown;
	}

	public WebElement getReviewReason() {
		return reviewReason;
	}

	public WebElement getNextAction() {
		return nextAction;
	}

	public WebElement getUrgentRequest() {
		return urgentRequest;
	}

	public WebElement getReqExceptionReview() {
		return reqExceptionReview;
	}

	public WebElement getUrgentReason() {
		return urgentReason;
	}

	public WebElement getNotes() {
		return notes;
	}


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	/**
	 * Constructor for the RequestAccumulatorReview class defining the Iframe and the Page Factory  
	 */
	public RequestAccumulatorReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:addAccumulatorAdjustment
	 * #Arguments:Textbox
	 * Description:Select the Accumulators for Adjustment
	 */
	public boolean addAccumulatorAdjustment(String[] args){
		//User to click on Add Accumulator hyperlink
		if(utils.clickAnelemnt(this.getAddLink(), "RequestAccumulatorReview", "Add"))
		//User should choose value from Add Accumulator dropdown
		if(utils.selectDropDownbyVisibleString(this.getAddAccDrpdown(), args[0], "RequestAccumulatorReview", "Add Accumulator"))
			return true;
		return true;
	} 

	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:submitStandardAccumAdjustment
	 * #Arguments:reviewreason, nextaction and notes
	 * Type:Text
	 * Description:Enter mandatory fields(Reason for review and notes), Select Next action-Send for Adjustment, Urgent- Unchecked, Exception - NO
	 */
	public boolean submitStandardAccumAdjustment(String[] args){
		// Choose Reason for Review from dropdown
		if (utils.selectDropDownbyVisibleString(this.getReviewReason(), args[0], "Request Accumulator Review",
				"Reason for Review"))
			// Choose Next action from dropdown
			if (utils.selectDropDownbyVisibleString(this.getNextAction(), args[1], "Request Accumulator Review",
					"Next action"))
				// Choose "No" in Request Exception review radio
				// selection[default]
				if (utils.clickAnelemnt(this.getReqExceptionReview(), "Request Accumulator Review",
						"Request Exception review"))
					// Enter notes in the text area
					if (utils.enterTextinAnelemnt(this.getNotes(), args[1], "Request Accumulator Review ",
							"Notes Section"))
					return true;
		return false;
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:submitUrgentAccumAdjustment
	 * #Arguments:reviewreason, nextaction, urgentreason and notes
	 * Type:Text
	 * Description:Enter mandatory fields(Reason for review and notes), Select Next action-Send for Adjustment, Urgent- Checked, Reason-Any value, Exception - NO
	 */
	public boolean submitUrgentAccumAdjustment(String[] args){
		// Choose Reason for Review from dropdown
		if (utils.selectDropDownbyVisibleString(this.getReviewReason(), args[0], "Request Accumulator Review",
				"Reason for Review"))
			// Choose Next action from dropdown
			if (utils.selectDropDownbyVisibleString(this.getNextAction(), args[1], "Request Accumulator Review",
					"Next action"))
				// Check Urgent request checkbox
				if (utils.clickAnelemnt(this.getUrgentRequest(), "Request Accumulator Review",
						"Urgent request checkbox"))
					// Choose "No" in Request Exception review radio
					// selection[default]
					if (utils.clickAnelemnt(this.getReqExceptionReview(), "Request Accumulator Review",
							"Request Exception review"))
						// Choose urgent reason from dropdown
						if (utils.selectDropDownbyVisibleString(this.getUrgentReason(), args[2],
								"Request Accumulator Review", "Urgent Reason"))
							// Enter notes in the text area
							if (utils.enterTextinAnelemnt(this.getNotes(), args[3], "Request Accumulator Review ",
									"Notes Section"))
							return true;
		return false;
	}
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	//@FindBy(xpath="//div[@node_name='RequestAccumulatorsAdjustmentwrapper']//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	public boolean selectValuesInReasonforReview()
	{
		return utils.selectDropDownbyVisibleString(this.reviewReason, "Accumulator Credit Transfer (policy to policy)", "RequestAccumulatorReview", "Reason for Review");
	}
	
	public boolean enterNotes()
	{
		return utils.enterTextinAnelemnt(this.notes, "Notes Entered", "RequestAccumulatorReview", "Notes");
	}
	
	public boolean clickBtnSubmit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit, "RequestAccumulatorReview", "Submit");
	}
	
	public boolean SubmitInRequestAccumulatorsReview()
	{
		if(selectValuesInReasonforReview())
			if(enterNotes())
				if(clickBtnSubmit())
					return true;
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectReasonForContact
	 * #Description: This functionality selects the dropdown value from the Reason For Contact  in the Request Accumulator Review page
	 * #Arguments:  reasonforcontact
	 * Type: Dropdown
	 * keys: Select#Discuss deductible/coinsurance/copay/cost shares#Explain explanation of benefits (EOB)#Explain how claim processed#Explain this letter or payment received#File a claim#Locate claim or payment#Provide additional information#Request an adjustment#Request correspondence or reprint#Update other insurance
	 */
	public boolean selectReasonForContact(String[] reasonforcontact)
	{
		return utils.selectDropDownbyVisibleString(this.addAccDrpdown, reasonforcontact[0], "RequestAccumulatorReview", "Reason For Contact");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectReasonForReview
	 * #Description: This functionality selects the dropdown value from the Reason For Review  in the Request Accumulator Review page
	 * #Arguments:  reasonforreview
	 * Type: Dropdown
	 * keys: Select#Accumulator Credit Transfer (policy to policy)#Comingled Policy - Pharmacy, Dental, Vision missing#LITES out of sync with ODS#Member request Accumulator Audit#Over applied Accumulator (cost share based)#Prior Carrier Deductible Credit not applied
	 */
	public boolean selectReasonForReview(String[] reasonforreview)
	{
	
		return utils.selectDropDownbyVisibleString(this.reviewReason, reasonforreview[0], "RequestAccumulatorReview", "Reason For Review");
	
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterNotes
	 * #Description: This functionality enters the notes in the Request Accumulator Review page
	 * #Arguments:  notes
	 * Type: Textbox
	 * 
	 */
	public boolean enterNotes(String[] notes)
	{
		return  utils.enterTextinAnelemnt(this.notes, notes[0], "RequestAccumulatorReview", "Notes");	
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
	 * #Description:This functionality validates the Miscellanous Accumulator tagged.
	 * #Argument:MiscellanousAccumsLevelTagged
	 * Type:Table
	 * Keys:Name#Description#From Thru#Unit#Amount
	 */
	public boolean validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment(String tablevalues[]){
			return utils.validatetablerowbasedonvalues(tblMiscellanousAccumulator, tablevalues);
	}
	
	
	
	@FindBy(id="ReturntoCSR")
	private WebElement chbxReturntoCSR;
	
	@FindBy(id="ReasonForOverride")
	private WebElement drpReasonForOverride;
	
	public boolean selectOverrideCheckbox(String[] drpDownReason1) {
		if (utils.clickAnelemnt(this.chbxReturntoCSR,"RequestAccumulatorReview","Override check box")) {
			utils.waitForElementToBeVisible(drpReasonForOverride);
			return utils.selectDropDownbyVisibleString(this.drpReasonForOverride,drpDownReason1[0] ,"RequestAccumulatorReview", "drop down");
		}
		return false;
		   
	}
	@FindBy(id="SelectUrgentOrCodeBlue")
	private WebElement drpSelectUrgentOrCodeBlue;
	
	@FindBy(id="EscalationUrgentIndicator")
	private WebElement chbxEscalationUrgentIndicator;
	
	
	public boolean selectUrgencyCheckbox(String[] drpDownReason) {
		 if(utils.clickAnelemnt(this.chbxEscalationUrgentIndicator,"RequestAccumulatorReview","urgency check box"))
			 return utils.selectDropDownbyVisibleString(this.drpSelectUrgentOrCodeBlue,drpDownReason[0] ,"RequestAccumulatorReview", "drop down");
		return false;
	}

}
