package automationLib;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import extentmanager.ExtentManager;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class RequestClaimAdjustment {
	SeleniumUtilities utils= new SeleniumUtilities();
	WebDriverWait wait;

	ErrorLogger err = new ErrorLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy(id="PrimaryReasonforBilling")
	private WebElement drpdwnReasonforcontact;

	@FindBy(xpath="//a[@data-test-id='201603170553400905315601']")
	private WebElement lnktxtADD;

	@FindBy(id="ClaimID")
	WebElement drpdwnclaimnumber;

	@FindBy(id="ReasonForAdjustments")
	WebElement drpdwnreasonforadjustment;

	@FindBy(id="SelectNextAction")
	WebElement drpdwnnextaction;

	@FindBy(id="ClaimsVirtualPodAssociate")
	WebElement drpdwnVirtualpodassociate;

	@FindBy(xpath="//div[@id='DialogContent']")
	WebElement sectionMbrcomposite;

	@FindBy (xpath="//*[text()='Submit']//ancestor::button")	
	private WebElement btnSubmit;

	@FindBy(id="OtherTopic")
	WebElement txtbxOtherReason;

	/**
	 * Constructor 	
	 */

	public RequestClaimAdjustment()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	public boolean addclaimadjustment() throws InterruptedException
	{
		utils.scrolltomiddle();
			if(utils.selectDropDownbyIndex(this.drpdwnReasonforcontact, 3, "RequestClaimAdjustment", "reason drop down"))
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", lnktxtADD);
						if(utils.clickAnelemnt(this.lnktxtADD, "RequestClaimAdjustment", "Add button"))
					return true;
						else {
							if(ExtentManager.getErrorMessage().contains("is not clickable"))
								utils.scrolltoright();
								if(utils.clickAnelemnt(this.lnktxtADD, "RequestClaimAdjustment", "Add button"))
									return true;
											}
									return false;
	}
	
	public boolean fillRequiredDetails(String [] RequiredDetails)
	{
		Boolean flag = true;
		try
		{
			for(String iterator:RequiredDetails)
			{
				if(!flag) {
					blogger.loginfo("Actual and Expected result doest not match.");
					return false;
				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1);
				System.out.println("key " + key + "value  " + value);

				if(key.toLowerCase().contains("claimn"))
				{
					flag =utils.selectDropDownbyVisibleString(this.drpdwnclaimnumber, value.toUpperCase(), "RequestClaimAdjustemnt", "claim number drp down");
				}else if(key.toLowerCase().contains("reasonforcontact"))
				{
					utils.selectDropDownbyVisibleString(reasonForContact, value, "RequestClaimAdjustemnt", "reasonForContact");
				}
				else if(key.toLowerCase().contains("reasonforadjustment"))
				{
					flag =utils.selectDropDownbyVisibleString(this.drpdwnreasonforadjustment, value, "RequestClaimAdjustemnt", "Reason for adjustment");
					if(value.toLowerCase().contains("oth"))
					{
						flag =utils.enterTextinAnelemnt(this.txtbxOtherReason, "Test", "Request Claim Adjustment", "Other textbox");
					}

				}
				else if(key.toLowerCase().contains("action"))
				{
					flag =utils.selectDropDownbyVisibleString(this.drpdwnnextaction, value, "RequestClaimAdjustemnt", "Next Action DropDown");
				}
				else if (key.toLowerCase().contains("assoc"))
				{
					flag =utils.enterTextinAnelemnt(this.drpdwnVirtualpodassociate, value, "RequestClaimAdjustemnt", "Next Action DropDown");
				}
				else if (key.toLowerCase().contains("reasonforurgency"))
				{
					flag = utils.selectDropDownbyVisibleString(ReasonForUrgency, value, "RequestClaimAdjustemnt", "ReasonForUrgency");
				}

			}
			System.out.println("Value selections done");
			return true;
		}

		catch(Exception e)
		{
			System.out.println("catch block "+ e);
			return false;
		}
	}

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeader;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickonSubmit
	 * #Description:This method clicks on submit button in 'Request Claim Adjustment' page.
	 * Type:TextBox
	 */
	public boolean clickonSubmit()
	{
		utils.scrolltomiddle();
			/*if(utils.validateHeader(this.sHeader, "Request Claim Adjustment"))
				((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);", btnSubmit);*/
				return utils.clickAnelemnt(this.btnSubmit, "RequestClaimAdjustment", "Submit button");
	}

	BaseLogger blogger = new BaseLogger();

	@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	private WebElement errGAText;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateGAMsgInRequestClaimAdjustment
	 * #Description:This method validates message displayed when user submits with 'Grievance and Appeals Indicator' checked, but user doesnt launch 'Grievance and Appeals' task
	 * Type:Textbox
	 */
	public boolean validateGAMsgInRequestClaimAdjustment(){
			String errGAText=this.errGAText.getText().trim();
			return utils.isvalueMatch_contain(errGAText, "You have tagged Claim(s) indicating a Grievance or Appeal but have not opened a Grievance and Appeal Task. Open the Grievance and Appeal task from the other actions or uncheck the respective claim indicating a 'Grievance or Appeal' from 'View Claim Details' screen and click Submit.");
	}

	//Sprint - 2.4

	@FindBy(id="PrimaryReasonforBilling")
	WebElement reasonForContact;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectDropDownReasonForContact
	 * #Description:This functionality selects the value in the Reason For Contract drop down
	 * #Arguments:ReasonForContact ClaimType
	 * Type:Dropdown
	 * Keys:Select#Discuss deductible/coinsurance/copay/cost shares#Explain explanation of benefits (EOB)#Explain provider remittance advice (RA)#Explain how claim processed#Explain this letter or payment received#File a claim#Locate claim or payment#Provide additional information#Request an adjustment#Request correspondence or reprint#Update other insurance
	 */
	public boolean selectDropDownReasonForContact(String[] args){
			utils.waitforpageload();
			return utils.selectDropDownbyVisibleString(this.reasonForContact, args[0], "ManageClaimReview", "Reason for Contact");
	}


	//Sprint 3.3

	@FindBy(xpath="//table[@pl_prop='.ReviewedClaims']//img[@data-test-id='20160127122348051611158']")
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
			WebElement element = this.tblClaimsTaggedInGA;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return !utils.isProxyWebelement(imgOneDayGrievanceIndicator);
	}

	@FindBy(id="SelectNextAction")
	private WebElement drpSelectNxtAction;


	public boolean selectNextAction(String arg[]) 
	{
		return utils.selectDropDownbyVisibleString(this.drpSelectNxtAction,arg[0], "RequestClaimAdjustment", " drp down ");
	}

	public boolean chooseSelectNextAction(String[] args) {
		return utils.selectDropDownbyVisibleString(drpdwnnextaction, args[0], "RequestClaimAdjustment", "drpdwnnextaction");
	}

	@FindBy(id="ReasonForUrgency")
	WebElement ReasonForUrgency;

	public boolean validatePIREscalationAvailableInReseaonforUrgencydropdown() {

		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("PIR Escalation");
		return utils.checkvaluesinDropDown(ReasonForUrgency, valuestobechecked );
	}

	public boolean validateReseaonforUrgencydropdown() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Irate Member/Broker/Provider");
		return utils.checkvaluesinDropDown(ReasonForUrgency, valuestobechecked );
	}
	
	@FindBy(xpath="//*[contains(@id,'ReturntoCSR')]")
	WebElement OverrideCheckbox;
	
	/**This functionality clicks the Override default routing checkbox in the Request Claim Adjustment page
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickOverrideDefaultRoutingCheckbox() throws InterruptedException {
		Thread.sleep(1000);
		return utils.clickAnelemnt(OverrideCheckbox, "RequestClaimAdjustment", "OverrideCheckbox");
	}
	
	@FindBy(id="ReasonForOverride")
	WebElement ReasonForOverride;
	
	/**This functionality chooses the Reason For Override from the dropdown
	 * 
	 * @return
	 */
	public boolean selectReasonForOveride(String[] args) {
		utils.waitForElementToBeVisible(ReasonForOverride);
		return utils.selectDropDownbyVisibleString(ReasonForOverride, args[0], "RequestClaimAdjustment", "ReasonForOverride");
	}
	

	
	/**This functionality chooses the Reason For Urgency from the dropdown
	 * 
	 * @return
	 */
	public boolean selectReasonForUrgency(String[] args) {
		utils.waitForElementToBeVisible(ReasonForUrgency);
		return utils.selectDropDownbyVisibleString(ReasonForUrgency, args[0], "RequestClaimAdjustment", "ReasonForUrgency");
	}
	
	@FindBy(xpath="//*[text()='Authorization Number']/ancestor::table[@id='gridLayoutTable']")
	WebElement AuthorizationTable;
	
	/**Validate the Authorization attached to the Claim from View Claim Details
	 * 
	 * @return
	 */
	public boolean validateAuthTaggedToClaimFrmViewClaimDetails() {
		String authnumber = ViewClaimDetails.map.get("Authorization Number");
		String[] tablevalues = ("Authorization Number:"+authnumber).split(",");
		return utils.validatetablerowbasedonvalues(AuthorizationTable, tablevalues);
	}
	
	public boolean completeClaimAdjustmentWithGandAOpen(String [] RequiredDetails) throws InterruptedException
	{
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement);
		if(utils.selectDropDownbyIndex(this.reasonForContact, 1, "ManageClaimReview", "Reason for Contact"))
		if(addclaimadjustment())
		if(fillRequiredDetails(RequiredDetails))
		if(validateDefaultSelectNextActionforODG())
		if(validateOneDayGrievanceIndicator())
		return clickonSubmit();
		return false;
		
	}
	
	@FindBy(xpath="//select[@id='SelectNextAction']//option[@value='Send for urgent adjustment']")
	WebElement DefaultSelectNextActionforODG;
	
	public boolean validateDefaultSelectNextActionforODG()
	{
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement);
		return DefaultSelectNextActionforODG.isSelected();
	}
	
	@FindBy(xpath="//*[contains(text(),'One Day Grievance')]")
	WebElement ODG;
	
	
	
	public boolean validateOneDayGrievanceIndicator()
	{
		
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement);
		Date date=new Date();
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(date);
		System.out.println(timeStamp);
 		String ODGActual = ODG.getText()+ "-" +timeStamp;
		String ODGExpected = ODG.getText();
		return utils.isvalueMatch_contain(ODGActual, ODGExpected);
	}
	
	
}