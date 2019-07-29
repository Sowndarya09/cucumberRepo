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
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;


public class GuidedFlows {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);
	//CommonUtilities utils = new CommonUtilities();
	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;
	@FindBy(id = "PegaGadget3Ifr")
	WebElement Iframeelement1;
	WebDriverWait wait;

	public GuidedFlows() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}
		catch(Exception e){
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
		
		
	}

	@FindBy(id = "DialogContent")
	WebElement txtGuideddialog;
	public boolean validateGuidedDialogue(String args[])
	{
		return utils.validateLabel(txtGuideddialog, args[0]);
	}
	
	@FindBy(className = "actionTitleBarLabelStyle")
	WebElement txtGuideddialogScreenname;
	public boolean verifyScreenNameGudiedFlows(String args[])
	{
	return utils.validateLabel(txtGuideddialogScreenname, args[0]);
	}
	
	@FindBy(xpath="//div[@data-test-id='201906111637080752143447']")
	WebElement txtServicesMbrCallingAbout;
	@FindBy(id="GuidedFlowType")
	WebElement DropDown;
	
	
	public boolean validateAndSelectDropDownForWhatServiceTheMemeberCallingAbout(String args[])
	{
		if(!utils.isProxyWebelement(txtServicesMbrCallingAbout))
			if(utils.selectDropDownbyVisibleString(DropDown, args[0], "Guided flows", "Drop down"))
				return true;
			return false;
	}
	
	@FindBy(xpath="//div[@class='FreeFormNotes ui-draggable']//div[@id='notesimg']")
	WebElement btnNotes;
	@FindBy(xpath="//*[@data-test-id='201509171745150881173224']//div[text()='Save']")
	WebElement btnSave;
	@FindBy(xpath="(//img[@class='pzbtn-img pzbtn-extimg'])[2]")
	WebElement btnTools;
	@FindBy(xpath="(//img[@class='pzbtn-img pzbtn-extimg'])[1]")
	WebElement btnAttachment;
	
	public boolean verifyNotesAndAttachmentButton()
	{
		if(!utils.isProxyWebelement(btnNotes) && (!utils.isProxyWebelement(btnSave))  && (!utils.isProxyWebelement(btnTools)))
			if(!utils.isProxyWebelement(btnAttachment))
				return true;
			return false;
		
	}
	@FindBy(xpath="//span[text()='Is the member emotional, stressed, or distraught?']/following::input[@id='IsMemberStressedNo']")
	WebElement rdbNo;
	public boolean validateMemberEmotionalTextAndSelectNoRadioButton()
	{
		return utils.clickAnelemnt(rdbNo, "gudied flows", "No radio button");
	}
	
  
	@FindBy(xpath="//span[text()='What stage of maternity/fertility is the member questioning?']")
	WebElement txtStageOfMaternity;
	public boolean validateTextStageOfMaternity()
	{
		return !utils.isProxyWebelement(txtStageOfMaternity);
	}
	
	@FindBy(id="GuidedFlowTypeStage")
	WebElement DrpDwnStageOfMaternity;
	public boolean validateStageOfMaternityDropDownValue()
	{
		String manualValues[]={"Select..","Attempting to Get Pregnant","Confirmed Pregnancy","Difficulty Getting Pregnant","Postpartum"};
		ArrayList<String> dropdownoptions = new ArrayList<String>();
		dropdownoptions.add("Select..");
		dropdownoptions.add("Attempting to Get Pregnant");
		dropdownoptions.add("Confirmed Pregnancy");
		dropdownoptions.add("Difficulty Getting Pregnant");
		dropdownoptions.add("Postpartum");
		if(utils.checkvaluesinDropDown(DrpDwnStageOfMaternity, dropdownoptions)){
			System.out.println("The values are matched");
			return true;
		}
		return false;
	}
	
	public boolean selectStageOfMaternityDropDownValue(String args[]){
		return utils.selectDropDownbyVisibleString(DrpDwnStageOfMaternity, args[0], "Guided flows", "dropdown");
	}
	
	@FindBy(xpath="//span[text()='Select the primary topics they would like to discuss from the below list. Offer to discuss ALL other topics in the list. At least one option must be selected.']")
	WebElement txtSecondary;
	public boolean validateSecondaryTextForPostpartum()
	{
		return !utils.isProxyWebelement(txtSecondary);
	}
	
	@FindBy(xpath="//div[@data-test-id='20190610111151054010169']")
	WebElement txtStatic;
	public boolean validateStaticText(String args[]){
		return utils.validateLabel(txtStatic, args[0]);
	}
	
	@FindBy(xpath="//div[text()='Clicking Next Step will open tasks based on the selections you have made. Review your selections before continuing.']")
	WebElement txtInformational;
	public boolean validateInformationalText()
	{
		return !utils.isProxyWebelement(txtInformational);
	}
	
	@FindBy(xpath="//span[contains(text(),'situation and check on the mother')]")
	WebElement txtPrimary;
	public boolean validatePrimaryTextForPostpartum(String args[])
	{
		return utils.validateLabel(txtPrimary, args[0]);
	}
	
	@FindBy(xpath="//table[@pl_prop='D_CheckListValuesList.pxResults']/tbody/tr/td[2]/div/span")
	List<WebElement> txtChecklist;
	
	@FindBy(xpath="//table[@pl_prop='D_CheckListValuesList.pxResults']/tbody/tr/td[2]/div/span[text()='Locating a Provider']")
	WebElement txtChecklist2;
	
	public boolean validateChecklistForPostpartum() 
	{
		boolean flag=false;
		utils.waitForElementToBeVisible(txtChecklist2);
		
	/*	((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.prvGATable);*/
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		for(WebElement check:txtChecklist)
		{
		String valuesFromApp1 = check.getText();
		valuesFromApp.add(valuesFromApp1);
		}
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("");
		valuesGivenManual.add("Maternity/Fertility Benefits and Cost");
		valuesGivenManual.add("Locating a Provider");
		valuesGivenManual.add("Employee Assistance Program (EAP)");
		valuesGivenManual.add("Behavioral Health Services (BH)");
		valuesGivenManual.add("Referral to Clinical/Health Advocate");
		valuesGivenManual.add("Employer-sponsored Programs");
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Column Headers in the checklist Table matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Column Headers in the checklist Table doesn't matched");
			return false;
		}
		
		
		
	}
	
	public boolean validateChecklistForDifficultyGettingPregnant(){
		boolean flag=false;
		utils.waitForElementToBeVisible(txtChecklist2);
		
	/*	((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.prvGATable);*/
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		for(WebElement check:txtChecklist)
		{
		String valuesFromApp1 = check.getText();
		valuesFromApp.add(valuesFromApp1);
		}
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("");
		valuesGivenManual.add("Maternity/Fertility Benefits and Cost");
		valuesGivenManual.add("Locating a Provider");
		valuesGivenManual.add("WIN Fertility Program");
		valuesGivenManual.add("Referral to Clinical/Health Advocate");
		valuesGivenManual.add("Employee Assistance Program (EAP)");
		valuesGivenManual.add("Employer-sponsored Programs");
		valuesGivenManual.add("Community Resources");
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Column Headers in the checklist Table matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Column Headers in the checklist Table doesn't matched");
			return false;
		}
		
	}
	
	@FindBy(xpath="//span[@data-test-id='20190617014020024914215']")
	WebElement txtPrimaryDifficulty;
	public boolean validatePrimaryTextForDifficultyGettingPregnant(String args[])
	{
		return utils.validateLabel(txtPrimaryDifficulty, args[0]);
	}
	
	@FindBy(xpath="//div[text()='Next Step']")
	WebElement btnNextStep;
	public boolean clickOnNextStep()
	{
		return utils.clickAnelemnt(btnNextStep, "gudied flows", "Next Step");
	}
	
	@FindBy(id = "PegaRULESErrorFlag")
	WebElement txtErrorMessage;
	public boolean verifyErrorMessageDisplayedWhenServicesDropDownIsNotSelected(String args[])
	{
		return utils.validateLabel(txtErrorMessage, args[0]);
	}
	
	
	public boolean verifyErrorMessageWhenMeMberEmotionalRadioButtonIsNotSelected(String args[])
	{
		return utils.validateLabel(txtErrorMessage, args[0]);
	}
	
	@FindBy(xpath="//span[@id='ERRORMESSAGES_ALL']//li[text()='At least one option must be selected before proceeding.']")
	WebElement txtErrorMsg;
	public boolean verifyErrorMessageDisplayedWhenChecklistIsNotTagged()
	{
		return !utils.isProxyWebelement(txtErrorMsg);
	}
	
	@FindBy(xpath="//span[text()='Is the member emotional, stressed, or distraught?']/following::input[@id='IsMemberStressedYes']")
	WebElement rdbYes;
	public boolean validateMemberEmotionalTextAndSelectYesRadioButton()
	{
		return utils.clickAnelemnt(rdbYes, "gudied flows", "Yes radio button");
	}
	
	

	
	@FindBy(xpath="//div[contains(text(),'If you identify any red flags, handle the call as a crisis call and escalate using the standard procedures.')]")
	WebElement instrtxt;
	public boolean validateInstructionalTextinRed()
	{
		return !utils.isProxyWebelement(instrtxt);
	}
	
	@FindBy(xpath="//span[@data-test-id='20190617014020024914215']")
	WebElement ackText;
	public boolean validateText()
	{
		return !utils.isProxyWebelement(ackText);
	}
	
	
	@FindBy(xpath="//span[@data-test-id='20190617014020025015762'][@class='leftJustifyStyle']")
	WebElement scriptingExample;
	public boolean clickscriptingexample()
	{
		return utils.clickAnelemnt(this.scriptingExample , "guided flows", "Expand");
	}
	
	
	public boolean validateChecklistForDistresedMemberFlow(){
		boolean flag=false;
		utils.waitForElementToBeVisible(txtChecklist2);
		
	/*	((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.prvGATable);*/
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		for(WebElement check:txtChecklist)
		{
		String valuesFromApp1 = check.getText();
		valuesFromApp.add(valuesFromApp1);
		}
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("");
		valuesGivenManual.add("Maternity/Fertility Benefits and Cost");
		valuesGivenManual.add("Locating a Provider");
		valuesGivenManual.add("Future Mom's Program");
		valuesGivenManual.add("Referral to Clinical/Health Advocate");
		valuesGivenManual.add("Employee Assistance Program (EAP)");
		valuesGivenManual.add("Behavioral Health Services (BH)");
		valuesGivenManual.add("Employer-sponsored Programs");
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Column Headers in the checklist Table matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Column Headers in the checklist Table doesn't matched");
			return false;
		}
		
	}

		@FindBy(xpath="//div[@data-test-id='20190610111151054010169']")
		WebElement txtbelowChecklist;
		public boolean validateTextbelowChecklist()
		{
			return !utils.isProxyWebelement(txtbelowChecklist);
		}
		
		public boolean validateChecklistForAttemptingToGetPregnantFlow(){
			boolean flag=false;
			utils.waitForElementToBeVisible(txtChecklist2);
			
		/*	((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.prvGATable);*/
			ArrayList<String> valuesFromApp = new ArrayList<String>();
			for(WebElement check:txtChecklist)
			{
			String valuesFromApp1 = check.getText();
			valuesFromApp.add(valuesFromApp1);
			}
			System.out.println("Values from the App: "+ valuesFromApp);
			ArrayList<String> valuesGivenManual = new ArrayList<String>();
			valuesGivenManual.add("");
			valuesGivenManual.add("Maternity/Fertility Benefits and Cost");
			valuesGivenManual.add("Locating a Provider");
			valuesGivenManual.add("Future Mom's Program");
			valuesGivenManual.add("Referral to Clinical/Health Advocate");
			valuesGivenManual.add("Employer-sponsored Programs");
			valuesGivenManual.add("Community Resources");
			
			if(valuesFromApp.equals(valuesGivenManual))
			{
				System.out.println("Values Matched");
				blogger.loginfo("Column Headers in the checklist Table matched");
				return true;
			}
			else
			{
				System.out.println("Values doesnt Matched");
				blogger.loginfo("Column Headers in the checklist Table doesn't matched");
				return false;
			}
			
		}
		
		public boolean validateChecklistForConfirmedPregnancyFlow(){
			boolean flag=false;
			utils.waitForElementToBeVisible(txtChecklist2);
			
		/*	((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.prvGATable);*/
			ArrayList<String> valuesFromApp = new ArrayList<String>();
			for(WebElement check:txtChecklist)
			{
			String valuesFromApp1 = check.getText();
			valuesFromApp.add(valuesFromApp1);
			}
			System.out.println("Values from the App: "+ valuesFromApp);
			ArrayList<String> valuesGivenManual = new ArrayList<String>();
			valuesGivenManual.add("");
			valuesGivenManual.add("Maternity/Fertility Benefits and Cost");
			valuesGivenManual.add("Locating a Provider");
			valuesGivenManual.add("Future Mom's Program");
			valuesGivenManual.add("Referral to Clinical/Health Advocate");
			valuesGivenManual.add("Employer-sponsored Programs");
			valuesGivenManual.add("Community Resources");
			
			if(valuesFromApp.equals(valuesGivenManual))
			{
				System.out.println("Values Matched");
				blogger.loginfo("Column Headers in the checklist Table matched");
				return true;
			}
			else
			{
				System.out.println("Values doesnt Matched");
				blogger.loginfo("Column Headers in the checklist Table doesn't matched");
				return false;
			}
			
		}
		
		@FindBy(xpath="//span[text()='Educate the caller on the different support roles offered by Service Experience and Clinical program.']")
		WebElement confirmedPregnancyTxt;
		public boolean validateConfirmedPregnancyText(String args[]){
			return utils.validateLabel(confirmedPregnancyTxt, args[0]);
		}
	
		@FindBy(xpath="//span[@data-test-id='20190617014020024914215']")
		WebElement txtPrimaryConfirmed;
		public boolean validatePrimaryTextForConfirmedPregnancyFlow(String args[])
		{
			return utils.validateLabel(txtPrimaryConfirmed, args[0]);
		}
		
		
	/*public boolean ValidateTextWhenHoverOverScriptingExample() throws InterruptedException
	{
		String Procedurecode=null;
		if(this.clickscriptingexample())
		{

			if(this.lnkhoverProcedurecode1.getText().isEmpty())
			{
				System.out.println("The xpath for procedurecode1 is empty");
				if(this.lnkhoverProcedurecode2.getText().isEmpty())
				{
					System.out.println("The xpath for procedurecode2 is empty");
					return false;
				}
				else
				{
					Actions action=new Actions(Driver.getPgDriver());
					action.moveToElement(this.lnkhoverProcedurecode2).build().perform();
					Procedurecode=this.lnkhovertextforProcedureCode.getText();
					System.out.println("The value of attribute is : "+Procedurecode); 
				}
			}
			else
			{
				Actions action=new Actions(Driver.getPgDriver());
				action.moveToElement(this.lnkhoverProcedurecode1).build().perform();
				Procedurecode=this.lnkhovertextforProcedureCode.getText();
				System.out.println("The value of attribute is : "+Procedurecode);
			}
		}

		return true;

	}*/

	//span[@data-test-id='20190617014020025015762']
	//action.moveToElement().
	//xxx.getA
	
	public boolean validateTextWhenHoverOverScriptingExample(String[] args) throws InterruptedException
	{
		String value= args[0];
		Actions action=new Actions(Driver.getPgDriver());
		action.moveToElement(this.scriptingExample).build().perform();
		String ScritpingExample=this.scriptingExample.getAttribute("aria-label");
	    return utils.isvalueMatch_contain(ScritpingExample, value);
		
		
	      	//ScritpingExample=this.lnkhovertextforProcedureCode.getText();
	    
		
		
		//return false;
	//
	
	//}
	
	}
	
	@FindBy(id="pySelected2")
	WebElement rdbLocatingProvider;
	public boolean clickLocatingAProviderRadioButton()
	{
		return utils.clickAnelemnt(rdbLocatingProvider, "GuidedFlowsReview", "Locating a provider");
	}
	
	@FindBy(id="pySelected3")
	WebElement rdbFutureMoms;
	public boolean clickFutureMomsRadioButton()
	{
		return utils.clickAnelemnt(rdbFutureMoms, "GuidedFlowsReview", "Future Moms");
	}
	
	@FindBy(id="pySelected4")
	WebElement rdbReferralToClinical;
	public boolean clickReferralToClinical()
	{
		return utils.clickAnelemnt(rdbReferralToClinical, "GuidedFlowsReview", "Referral To Clinical");
	}
	
	
}

