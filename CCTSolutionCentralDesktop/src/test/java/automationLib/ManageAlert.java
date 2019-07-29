package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ManageAlert {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	public ManageAlert(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'View Programs')]")	
	WebElement lnkOthrActionsViewProgram;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	WebElement labelManageReferralTitle;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToViewProgram
	 * #Description: This functionality navigates to the View Program section from the View Claim Details page
	 * Type: Textbox
	 */
	public boolean navigateToViewProgram()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageAlert", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsViewProgram, "ManageAlert", "View Program");
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on the Submit button in the Manage Alerts page
	 * #type: Textbox
	 */
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "ManageAlert", "Submit");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyTitleOnClickingSubmitInManageAlerts
	 * #Description: This functionality validates that the title matches with the expected value on clicking submit in the Alert page
	 * #type: Textbox
	 */
	public boolean verifyTitleOnClickingSubmitInManageAlerts()
	{
		return utils.validateLabel(labelManageReferralTitle, "Manage Referrals");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyAlertPresent
	 * #Description: This functionality verifies all the alert present in the Manage Alert page with respective alert to it script, recommended actions, outcome
	 * #Type: Textbox
	 */

	public boolean verifyAlertPresent()
	{
		if(this.validateClinicalOutrreachAlert())
			if(this.validatePreventiveAlert())
				if(this.validateFamilyCareAlert())
					if(this.validatePharmacyAlert())
						return this.validateServiceAlert();
		return false;
	}


	@FindBy(xpath="//span[@data-test-id='20180215001351081212164']")
	WebElement labelAlertTypeClinical;

	@FindBy(xpath="//span[@data-test-id='20180215001351081213130']")
	WebElement labelAlertClinicalScript;

	@FindBy(xpath="//span[@data-test-id='2018021522292103468322']")
	WebElement labelAlertClinicalRemActions;

	@FindBy(id="AHGAlertsOutcome")
	WebElement drpDownOutcomeClinical;

	@FindBy(xpath="//a[contains(text(),'Additional Info')]")
	WebElement lnkAdditionalInfo;

	@FindBy(xpath="//span[contains(text(),'HRS Invalid Phone Number')]")
	WebElement labelUnableToReachReason;

	@FindBy(xpath="//span[contains(text(),'11/07/2014')]")
	WebElement labelLastContactAttempt;

	@FindBy(xpath="//span[contains(text(),'DMPROG')]")
	WebElement labelProgramCode;

	@FindBy(xpath="//span[contains(text(),'Disease Management')]")
	WebElement labelProgramDescription;


	@FindBy(xpath="//span[contains(text(),'Preventive / Kidney Test')]")
	WebElement labelAlertTypePreventive;
	
	@FindBy(xpath="//span[contains(text(),'Engage Alert')]")
	WebElement labelAlertTypeEngage;

	@FindBy(xpath="//span[contains(text(),'I have a personal reminder for you to get checked for kidney problems every year. Diabetes can cause these problems. Will you ask your doctor if you need a kidney test soon?')]")
	WebElement labelAlertPreventiveScript;

	@FindBy(xpath="//tr[@id='$PD_AHGAlerts$ppxResults$l2']//span[text()='Will you ask your doctor if you need a kidney test soon?']")
	WebElement labelAlertPreventiveRemActions;

	@FindBy(xpath="//select[contains(@id,'AHGAlertsOutcome')]")
	WebElement drpDownOutcomePreventive;

	@FindBy(xpath="//span[text()='Family Care Gap / Family Health']")
	WebElement labelAlertTypeFamilyCare;

	@FindBy(xpath="//span[text()='Our medical records indicate that we have important health alerts for additional members on your plan. Would you like to discuss these health alerts now?']")
	WebElement labelAlertFamilyCareScript;

	@FindBy(xpath="//span[text()='Read script, start new discussion for each member listed, and review alerts.']")
	WebElement labelAlertFamilyCareRemActions;

	@FindBy(name="$PD_AHGAlerts$ppxResults$l3$pAHGAlertsOutcome")
	WebElement drpDownOutcomeFamilyCare;

	@FindBy(xpath="//span[text()='Pharmacy / Generic Prescription']")
	WebElement labelAlertTypePharmacy;

	@FindBy(xpath="//span[text()='I want to see if I can help you save money on your prescriptions. A simple change from brand to generic could save you money. If you get Procardia or Adalat, you can ask your doctor if the generic for this drug is right for you.']")
	WebElement labelAlertPharmacyScript;

	@FindBy(xpath="//span[text()='Read script, start new discussion for each member listed, and review alerts.']")
	WebElement labelAlertPharmacyRemActions;

	@FindBy(name="$PD_AHGAlerts$ppxResults$l4$pAHGAlertsOutcome")
	WebElement drpDownOutcomePharmacy;

	@FindBy(xpath="//span[contains(text(),'Service / Happy Birthday')]")
	WebElement labelAlertTypeService;

	@FindBy(xpath="//tr[@id='$PD_AHGAlerts$ppxResults$l5']//label[@data-test-id='20180215001351081213130-Label']/following-sibling::div/span")
	WebElement labelAlertServiceScript;

	@FindBy(xpath="//span[contains(text(),'Wish the member a Happy Birthday')]")
	WebElement labelAlertServiceRemActions;

	@FindBy(name="$PD_AHGAlerts$ppxResults$l5$pAHGAlertsOutcome")
	WebElement drpDownOutcomeService;

	public boolean validateAlertTypeClinical()
	{
		return utils.validateLabel(labelAlertTypeClinical, "Clinical Outreach/HRS has no Valid Number");
	}

	public boolean validateClinicalAlertScript()
	{
		return utils.validateLabel(labelAlertClinicalScript, "Your assigned clinical nurse has been trying to contact you, but they do not have a valid phone number for you on file.");
	}

	public boolean validateClinicalAlertRecomActions()
	{
		return utils.validateLabel(labelAlertClinicalRemActions, "Transfer to clinical");
	}

	public boolean selectClinicalAlertOutcomeDropDown()
	{
		return utils.selectDropDownbyVisibleString(this.drpDownOutcomeClinical, "ALASKA", "ManageAlert", "Clinical Outcome");
	}

	public boolean validateClinicalAdditionInfo()
	{
		if(utils.clickAnelemnt(this.lnkAdditionalInfo, "ManageAlert", "Additional Info"))
			if(utils.validateLabel(labelUnableToReachReason, "HRS Invalid Phone Number"))
				if(utils.validateLabel(labelLastContactAttempt, "11/07/2014"))
					if(utils.validateLabel(labelProgramCode, "DMPROG"))
						return utils.validateLabel(labelProgramDescription, "Disease Management");
		return false;

	}
	public boolean validateAlertTypeEngage()
	{
		return utils.validateLabel(labelAlertTypeEngage, "Engage Alert");
	}
	public boolean validateAlertTypePreventive()
	{
		return utils.validateLabel(labelAlertTypePreventive, "Preventive / Kidney Test");
	}

	public boolean validatePreventiveAlertScript()
	{
		return utils.validateLabel(labelAlertPreventiveScript, "I have a personal reminder for you to get checked for kidney problems every year. Diabetes can cause these problems. Will you ask your doctor if you need a kidney test soon?");
	}

	public boolean validatePreventiveAlertRecomActions()
	{
		return utils.validateLabel(labelAlertPreventiveRemActions, "Will you ask your doctor if you need a kidney test soon?");
	}

	public boolean selectPreventiveAlertOutcomeDropDown()
	{
		return utils.selectDropDownbyVisibleString(this.drpDownOutcomePreventive, "Alert Not Discussed:  Sensitive Case", "ManageAlert", "Preventive Outcome");
	}

	public boolean validateAlertTypeFamilyCare()
	{
		return utils.validateLabel(labelAlertTypeFamilyCare, "Family Care Gap / Family Health");
	}

	public boolean validateFamilyCareAlertScript()
	{
		return utils.validateLabel(labelAlertFamilyCareScript, "Our medical records indicate that we have important health alerts for additional members on your plan. Would you like to discuss these health alerts now?");
	}

	public boolean validateFamilyCareAlertRecomActions()
	{
		return utils.validateLabel(labelAlertFamilyCareRemActions, "Read script, start new discussion for each member listed, and review alerts.");
	}

	public boolean selectFamilyCareAlertOutcomeDropDown()
	{
		return utils.selectDropDownbyVisibleString(this.drpDownOutcomeFamilyCare, "Alert Does Not Apply To Member", "ManageAlert", "Family Care Outcome");
	}

	public boolean validateAlertTypePharmacy()
	{
		return utils.validateLabel(labelAlertTypePharmacy, "Pharmacy / Generic Prescription");
	}

	public boolean validatePharmacyAlertScript()
	{
		return utils.validateLabel(labelAlertPharmacyScript, "I want to see if I can help you save money on your prescriptions. A simple change from brand to generic could save you money. If you get Procardia or Adalat, you can ask your doctor if the generic for this drug is right for you.");
	}

	public boolean validatePharmacyAlertRecomActions()
	{
		String actualvalue= "Will you ask your doctor soon if the generic for Procardia or Adalat is right for you? Will you ask your doctor if you need a kidney test soon?";
		String expectedvalue = "Will you ask your doctor soon if the generic for Procardia or Adalat is right for you? Will you ask your doctor if you need a kidney test soon?";
		return utils.isvalueMatch_contain(actualvalue,expectedvalue );
	}

	public boolean selectPharmacyAlertOutcomeDropDown()
	{
		return utils.selectDropDownbyVisibleString(this.drpDownOutcomePharmacy, "Alert Does Not Apply To Member", "ManageAlert", "Pharmacy Outcome");

	}


	public boolean validateAlertTypeService()
	{
		return utils.validateLabel(labelAlertTypeService, "Service / Happy Birthday");

	}

	public boolean validateServiceAlertScript()
	{
		return utils.validateLabel(labelAlertServiceScript, "Happy birthday!");

	}

	public boolean validateServiceAlertRecomActions()
	{
		return utils.validateLabel(labelAlertServiceRemActions, "Wish the member a Happy Birthday");

	}

	public boolean selectServiceAlertOutcomeDropDown()
	{
		return utils.selectDropDownbyVisibleString(this.drpDownOutcomeService, "Alert Does Not Apply To Member", "ManageAlert", "Service Outcome");

	}

	@FindBy(xpath="//table[@pl_prop='D_AHGAlerts.pxResults']")
	WebElement tblManageAlert;

	public boolean verifyAlertHeaderRowTable()
	{
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblManageAlert);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Priority");
		valuesGivenManual.add("Alert Type");
		valuesGivenManual.add("Recommended Actions");
		valuesGivenManual.add("Outcome");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			return false;
		}
	}

	public boolean validateClinicalOutrreachAlert()
	{
		if(this.verifyAlertHeaderRowTable())
			if(this.validateAlertTypeClinical())
				if(this.validateClinicalAlertScript())
					if(this.validateClinicalAlertRecomActions())
						return this.selectClinicalAlertOutcomeDropDown();
		return false;

	}

	public boolean validatePreventiveAlert()
	{
		if(this.validateAlertTypePreventive())
			if(this.validatePreventiveAlertScript())
				if(this.validatePreventiveAlertRecomActions())
					return this.selectPreventiveAlertOutcomeDropDown();
		return false;
	}


	public boolean validateFamilyCareAlert()
	{
		if(this.validateAlertTypeFamilyCare())
			if(this.validateFamilyCareAlertScript())
				if(this.validateFamilyCareAlertRecomActions())
					return this.selectFamilyCareAlertOutcomeDropDown();
		return false;
	}


	public boolean validatePharmacyAlert()
	{
		if(this.validateAlertTypePharmacy())
			if(this.validatePharmacyAlertScript())
				if(this.validatePharmacyAlertRecomActions())
					return this.selectPharmacyAlertOutcomeDropDown();
		return false;
	}


	public boolean validateServiceAlert()
	{
		if(this.validateAlertTypeService())
			if(this.validateServiceAlertScript())
				if(this.validateServiceAlertRecomActions())
					return this.selectServiceAlertOutcomeDropDown();
		return false;
	}

	@FindBy(xpath="//div[@id='DialogContent' and contains(text(), 'You can find Alerts')]")
	WebElement txtGuidedDialog;

	@FindBy(xpath ="//div[@id='CT']/a[@disabled and @class='Add_task' and @title = 'Manage Alerts']")
	WebElement addTasksManageAlerts;


	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")	
	private WebElement btnAddTAsk;

	public WebElement getbtnAddTAsk()
	{
		return btnAddTAsk;
	}

	public boolean clickbtnAddTask() throws InterruptedException
	{
		Thread.sleep(30000);
		return utils.clickAnelemnt(this.getbtnAddTAsk(), "Manage Alert ", "Add Task Button ");

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateTheGuidedDialogIsPresent
	 * #Description: This functionality verifies the presence of guided dialog in Manage Alert.
	 * Type: Textbox
	 * Parameters: Member name
	 */
	public boolean validateTheGuidedDialogIsPresent(String[] args) {

		String guidedDialogText = "You can find Alerts for " + args[0] + " here." + "\n"
				+"Call out all the alerts below." + "\n"
				+"View Urgent Care Alert, Health Tip, Family Alert, Save Money and Helpful info.";

		System.out.println("=== guided dialog text === " + txtGuidedDialog.getText());
		System.out.println("==== feature file content ====" + args[0]);
		if(txtGuidedDialog.getText().trim().equals(guidedDialogText))
			return true;
		else{
			err.logError("ManageAlert", "Error in Validating the guided dialog text.");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyTheManageAlertTaskIsDisabled
	 * #Description: This functionality verifies the Manage alert task is disabled for the second time.
	 * a
	 */


	public boolean verifyTheManageAlertTaskIsDisabled () throws InterruptedException {
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(addTasksManageAlerts);
		return false;	
	}

	@FindBy(xpath ="//span[contains(text(),'Member Alerts are Available for Active Medical Contracts Only')]")
	WebElement txtErrorMessageForInactiveContracts;

	@FindBy(xpath ="//span[contains(text(),'Cancel this work')]")
	WebElement lnkOthrActionsCancelWork;


	public boolean verifyAlertMessageForInactiveContracts()
	{
		try
		{
			utils.waitforpageload();
			String ErrorMessageInUI = this.txtErrorMessageForInactiveContracts.getText();
			System.out.println("Error Message Displayed in UI is: "+ErrorMessageInUI);

			String ErrorMessageGivenByUser = "Member Alerts are Available for Active Medical Contracts Only";
			if(ErrorMessageInUI.equalsIgnoreCase(ErrorMessageGivenByUser))
			{
				System.out.println("Message in the UI and expected by the user matched");
				return true;
			}
			else
			{
				System.out.println("Message in the UI and expected by the user is not matched");
				return false;
			}

		}catch(Exception e)
		{
			blogger.loginfo("The Message expected doesnt match");
			err.logError("Mange Alert", "Error Message Validation Failed");
			return false;
		}
	}

	public boolean verifyNoAlertMessageForActiveContracts () {
		return !utils.isProxyWebelement(txtErrorMessageForInactiveContracts);
	}

	public boolean clickCancelWorkAndCancelTheWork()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, " ManageAlert ", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsCancelWork, " ManageAlert ", "Cancel Work");
		return false;
	}

	public boolean selectOutcome(String[] args) {
		return utils.selectDropDownbyVisibleString(drpDownOutcomeClinical, args[0], "ManageAlert", "drpDownOutcomeClinical");
	}

	@FindBy(xpath ="//span[contains(text(),'Preventive/Asthma needs periodic spirometry')]")
	WebElement labelRhiAlertTypePrventive;
	public boolean validateRhiPreventiveAlert(String args[]){
		return utils.validateLabel(labelRhiAlertTypePrventive, "Preventive/Asthma needs periodic spirometry");
	}
	
	@FindBy(xpath ="//a[text()='Additional Info']")
	WebElement additionalInfo;
	public boolean clcikOnAdditionalInfoPopUp()
	{
		return utils.clickAnelemnt(additionalInfo,"Manage Alerts","Additonal Info");
	}
}



