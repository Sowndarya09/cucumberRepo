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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ManageReferral {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	public ManageReferral(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'View Programs')]")	
	WebElement lnkOthrActionsViewProgram;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Manage Alerts')]")	
	WebElement lnkOthrActionsManageAlert;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="Xpath of Manage Alerts")
	WebElement labelManageAlerts;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Cancel this work')]")	
	WebElement lnkOthrActionsCancelWork;

	@FindBy (xpath="//label[contains(text(),'Overview')]")	
	WebElement tabOverView;

	@FindBy (xpath="//label[contains(text(),'Referral History')]")	
	WebElement tabReferralHistory;

	@FindBy (xpath="//label[contains(text(),'Correspondence')]")	
	WebElement tabCorrespondence;

	@FindBy (xpath="//a[@data-test-id='20180215022514027144620']")	
	WebElement lnkAddIcon;

	@FindBy (xpath="//a[@name='ReferralOverviewDetails_pyWorkPage.ReferralOverviewList(1)_9']")	
	WebElement lnkDeleteIcon;

	@FindBy (xpath="//div[@node_name='ManageCorrespondenceList']//p/span")	
	WebElement txtErrorMsgInManageReferralSection;

	@FindBy(xpath="//table[@pl_prop='.ReferralClinicalHistoryList']")
	WebElement tblReferralHistorySection;

	@FindBy(xpath="//table[@pl_prop='.ReferralMemberContactHistoryList']")
	WebElement tblMemberContactSection;

	@FindBy(xpath="//table[@pl_prop='.ReferralCorrespondenceList']")
	WebElement tblCorrespondenceSection;

	@FindBy(xpath="//span[@data-test-id='20180214052948012827762']")
	WebElement labelReferralPromptedBy;

	@FindBy(xpath="//span[@data-test-id='2018021405294801282885']")
	WebElement labelReferralReason;

	@FindBy(xpath="//span[@data-test-id='20180214052948012929310']")
	WebElement labelReferralNotes;

	@FindBy(id="ReferralPromptedBy")
	WebElement drpDownReferralPromptedBy;

	@FindBy(id="ReferralReason")
	WebElement drpDownReferralReason;

	@FindBy(id="ReferralActionTransferOutcome")
	WebElement drpDownTransferOutcome;

	@FindBy(id="ReferralVendorProgram")
	WebElement drpDownReferralVendorProgram;

	@FindBy(id="ReferralVendorProgramCategory")
	WebElement drpDownReferralVendorProgramCategory;

	@FindBy(id="CallBackPrefferedDate")
	WebElement txtBxPreferredCallBackDate;

	@FindBy(id="CallBackPreferredTime")
	WebElement txtBxPreferredCallBackTime;

	@FindBy(id="PreferredTimeZone")
	WebElement drpDownTimeZone;

	@FindBy(id="CallBackNumber")
	WebElement txtBxPhoneNumber;

	@FindBy(id="CallBackNumExt")
	WebElement txtBxPhoneNumberExtension;

	@FindBy(xpath="//input[@value='Yes']")
	WebElement rdoBtnVoiceMailYes;

	@FindBy(xpath="//input[@value='No']")
	WebElement rdoBtnVoiceMailNo;

	@FindBy(id="Notes")
	WebElement txtBxReferralNotes;

	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionManageReferralHistoryBBBBBB~pzLayout_4']//a[contains(text(),'Next')]")
	WebElement lnkNextMemberContcat;

	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionManageReferralHistoryBBBB~pzLayout_2']//a[contains(text(),'Next')]")
	WebElement lnkNextReferralHistory;

	@FindBy(id="IsCorrespondenceInfoDiscussed")
	WebElement chckBxCorrespondenceInformation;

	@FindBy(id="IsReferralHistoryInformation")
	WebElement chckBxReferralHistory;



	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToManageAlert
	 * #Description: This functionality navigates to the Manage Alert section from the Manage Referrals page
	 * Type: Textbox
	 */
	public boolean navigateToManageAlert()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageReferral", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsManageAlert, "ManageReferral", "Manage Alert");
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToViewProgram
	 * #Description: This functionality navigates to the View Program section from the Manage Referrals page
	 * Type: Textbox
	 */
	public boolean navigateToViewProgram()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageReferral", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsViewProgram, "ManageReferral", "View Program");
		return false;
	}



	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCancelWorkAndCancelTheWork
	 * #Description: This functionality navigates to the cancel work section from the View Program page and cancels the work
	 * Type: Textbox
	 */
	public boolean clickCancelWorkAndCancelTheWork()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ViewProgram", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsCancelWork, "ViewProgram", "Cancel Work");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnOverviewTab
	 * #Description: This functionality performs click action on the Overview tab in the Manage Referrals page
	 * Type: Textbox
	 */
	public boolean clickOnOverViewTab()
	{
		return utils.clickAnelemnt(this.tabOverView, "ManageReferral", "Overview tab");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnReferalHistory
	 * #Description: This functionality performs click action on the Referral History tab in the Manage Referrals page
	 * Type: Textbox
	 */
	public boolean clickOnReferralHistoryTab()
	{	
		return utils.clickAnelemnt(this.tabReferralHistory, "ManageReferral", "Referral History tab");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnCorrespondenceTab
	 * #Description: This functionality performs click action on the Correspondence tab in the Manage Referrals page
	 * Type: Textbox
	 */
	public boolean clickOnCorrespondenceTab()
	{
		return utils.clickAnelemnt(this.tabCorrespondence, "ManageReferral", "Correspondence tab");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnAddIcon
	 * #Description: This functionality performs click action on the Add Icon in the Manage Referrals page
	 * Type: Textbox
	 */
	public boolean clickAddIcon()
	{
		return utils.clickAnelemnt(this.lnkAddIcon, "ManageReferral", "Add Icon");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnDeleteIcon
	 * #Description: This functionality performs click action on the Delete Icon in the Manage Referrals page
	 * Type: Textbox
	 */
	public boolean clickDeleteIcon()
	{
		return utils.clickAnelemnt(this.lnkDeleteIcon, "ManageReferral", "Delete Icon");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on the Submit button in the Manage Referral page
	 * #Type: Textbox
	 */
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "ManageReferral", "Submit");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyMessageDisplayedInManageReferral
	 * #Description: This functionality verifies that the no data found message is present in the Member Contact section in the Manage Referral page
	 * #Type: Textbox
	 */
	public boolean verifyMessageDisplayedInManageReferral()
	{
		try
		{
			String txtActualErrorMsg = this.txtErrorMsgInManageReferralSection.getText();
			System.out.println("Error msg in Manage Referral section is: "+txtActualErrorMsg);
			String txtExpectedErrorMsg = "The following correspondence information has been identified for this member.";
			if(txtActualErrorMsg.equalsIgnoreCase(txtExpectedErrorMsg))
			{
				blogger.loginfo("Actual Message and Expected message is same in Manage Referral section");
				return true;
			}
			else
			{
				blogger.loginfo("Actual Message and Expected message is not same in Manage Referral section");
				return false;
			}
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("ManageReferral", "verifyMessageDisplayedInManageReferral", "Message validation is failed in Manage Referral section");
			return false;
		}
	}

	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionManageCorrespondenceListBBB~pzLayout_2']//a[contains(text(),'Next')]")
	WebElement lnkNextCorrespondence;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyTheValuesDisplayedInTheCorrespondenceSection
	 * #Description: This functionality verifies the values given by user matches the value present in the correspondence table section
	 * #Type: Table
	 * Keys: Date#Program Name#Letter Description#Details
	 */
	public boolean verifyTheValuesDisplayedInTheCorrespondenceSection(String[] tablevalues) 
	{
		try
		{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.ReferralCorrespondenceList']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.getProviderResultsBasedOnValues(tblCorrespondenceSection, tablevalues);
			List<WebElement> chckBoxes = row.findElements(By.tagName("td"));
			chckBoxes.get(1).click();
			return true;
		}catch(Exception e)
		{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@param_name='EXPANDEDSubSectionManageCorrespondenceListBBB~pzLayout_2']//a[contains(text(),'Next')]"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			if(lnkNextCorrespondence.isDisplayed())
			{
				lnkNextCorrespondence.click();
				WebElement element1 = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.ReferralCorrespondenceList']"));
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element1);
				return verifyTheValuesDisplayedInTheCorrespondenceSection(tablevalues);
			}
			else
			{
				System.out.println("Entire row not matching for given input in Member Level" + e);
				return false;
			}
		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyTheValuesDisplayedInTheClinicalReferralHistoryTable
	 * #Description: This functionality verifies the values given by user matches the value present in the Referral History table section
	 * #Type: Table
	 * Keys: Referral Date#Referral ID#Referral Type#Contact Name#Related Interaction ID#Requested Call Back Time#Clinical Outcome#Related Case ID#Logged By
	 */
	public boolean verifyTheValuesDisplayedInTheClinicalReferralHistoryTable(String[] tablevalues)
	{
		boolean returnvar =true;
		String refdate= null,refid= null,reftype = null,contactname= null,relatedintid= null,reqcallbacktime=null,clinicaloutcome=null,refcaseid=null,loggedby=null;
		ArrayList<String> expected= new ArrayList<String>();      
		try
		{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='D_AHGReferralList.ReferralClinicalHistoryList']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.getTablerowbasedonvalues(tblReferralHistorySection, tablevalues);
			List<WebElement> expandpane = row.findElements(By.tagName("td"));
			expandpane.get(0).click();		
			return true;
		}catch(Exception e)	{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@param_name='EXPANDEDSubSectionManageReferralHistoryBBBB~pzLayout_2']//a[contains(text(),'Next')]"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			if(lnkNextReferralHistory.isDisplayed())
			{
				lnkNextReferralHistory.click();
				WebElement element1 = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='D_AHGReferralList.ReferralClinicalHistoryList']"));
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element1);
				return verifyTheValuesDisplayedInTheClinicalReferralHistoryTable(tablevalues);
			}
			else
			{
				System.out.println("Entire row not matching for given input in Member Level" + e);
				return false;
			}
		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyTheValuesDisplayedInTheMemberContactSection
	 * #Description: This functionality verifies the values given by user matches the value present in the Member Contact table section
	 * #Type: Table
	 * Keys: Contact Date#Clinical Interaction ID#Case ID#Program#Contact Purpose#Contact Name#Contact Type#Contact Outcome#Contact Phone
	 */
	public boolean verifyTheValuesDisplayedInTheMemberContactHistoryTable(String[] tablevalues)
	{
		try
		{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.ReferralMemberContactHistoryList']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.getProviderResultsBasedOnValues(tblMemberContactSection, tablevalues);
			List<WebElement> chckBoxes = row.findElements(By.tagName("td"));
			chckBoxes.get(1).click();
			return true;
		}catch(Exception e)
		{WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@param_name='EXPANDEDSubSectionManageReferralHistoryBBBBBB~pzLayout_4']//a[contains(text(),'Next')]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		if(lnkNextMemberContcat.isDisplayed())
		{
			lnkNextMemberContcat.click();
			return verifyTheValuesDisplayedInTheMemberContactHistoryTable(tablevalues);
		}
		else
		{
			System.out.println("Entire row not matching for given input in Member Level" + e);
			return false;
		}
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyTheValuesOfTheMatchedClinicalReferralHistory
	 * #Description: This functionality verifies the values given by user matches the value present in the matched referral history section
	 * #Type: Table
	 * Keys: Referral Prompted By#Referral Reason#Referral Notes
	 */
	public boolean verifyTheValuesOfTheMatchedClinicalReferralHistory(String[] referralhistoryvalues)
	{

		System.out.println("Entered into the method");
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : referralhistoryvalues)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyViewClaimDetailsInfo", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + " " + "value  " + value);

			if(key.equals("Referral Prompted By")){
				returnvar = utils.validateLabel(labelReferralPromptedBy, value);
				continue;}
			else if(key.equals("Referral Reason")){
				returnvar = utils.validateLabel(labelReferralPromptedBy, value);
				continue;}
			else if(key.contains("Referral Notes")){
				returnvar = utils.validateLabel(labelReferralPromptedBy, value);
				continue;
			}
			err.logcommonMethodError("verifyTheValuesOfTheMatchedClinicalReferralHistory", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("View Claim Details verified successfully");
			return true;	
		}
		else
		{
			int tot_i=referralhistoryvalues.length;
			err.logcommonMethodError("ViewClaimDetails", "the value "+referralhistoryvalues[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}		

	}


	public  boolean selectReferralPromptedByDropdown(String referralpromptedby)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReferralPromptedBy, referralpromptedby, "ManageReferral", "Referral Prompted By");
	}

	public  boolean selectReferralReasonDropdown(String referralreason)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReferralReason, referralreason, "ManageReferral", "Referral Reason");
	}

	public  boolean selectTransferOutcomeDropdown(String transferoutcome)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownTransferOutcome, transferoutcome, "ManageReferral", "Transfer Outcome");
	}

	public  boolean selectReferralVendorProgramDropdown(String referralvendorprogram)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReferralVendorProgram, referralvendorprogram, "ManageReferral", "Referral Vendor Program");
	}

	public  boolean selectReferralVendorProgramCategoryDropdown(String referralvendorprogramcategory)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReferralVendorProgramCategory, referralvendorprogramcategory, "ManageReferral", "Referral Vendor Program Category");
	}

	public  boolean selectTimeZoneDropdown(String timezone)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownTimeZone, timezone, "ManageReferral", "Time Zone");
	}

	public boolean enterPreferredCallBackDate(String date)
	{
		return utils.enterTextinAnelemnt(this.txtBxPreferredCallBackDate, date, "ManageReferral", "Date");
	}

	public boolean enterPreferredCallBackTime(String time)
	{
		return utils.enterTextinAnelemnt(this.txtBxPreferredCallBackTime, time, "ManageReferral", "Time");
	}

	public boolean enterPhoneNumber(String phno)
	{
		return utils.enterTextinAnelemnt(this.txtBxPhoneNumber, phno, "ManageReferral", "Phone No");
	}

	public boolean enterPhoneNumberExtension(String extno)
	{
		return utils.enterTextinAnelemnt(this.txtBxPhoneNumberExtension, extno, "ManageReferral", "Ext No");
	}

	public boolean enterReferralNotes(String notes)
	{
		return utils.enterTextinAnelemnt(this.txtBxReferralNotes, notes, "ManageReferral", "Notes");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectYesOrNoInVoiceMail
	 * #Description: This functionality selects the Yes/No options in the Voice mail section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean selectYesOrNoInVoiceMail(String args)
	{
		if((args).trim().equalsIgnoreCase("Yes")){
			try{
				this.rdoBtnVoiceMailYes.click();
				return true;
			}catch(Exception e){
				System.out.println("Error:in Selecting voice mail Yes Indicator");
				err.logError("ManageReferral", "Error:in Selecting voice mail Yes Indicator");

			}
		}else if ((args).trim().equalsIgnoreCase("No")){
			try{
				this.rdoBtnVoiceMailNo.click();
				return true;
			}catch(Exception e){
				System.out.println("'Error:in Selecting Voice mail No Indicator'");
				err.logError("Wrap up", "Error:in selecting Prior Inquiry No Indicator");
			}
		}else{
			System.out.println("Please enter valid option to select - either Yes or No");
		}
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterMandatoryDetailsInTheScheduledReferral
	 * #Description: This functionality enters all the Mandatory Details in the Manage Referral overview section
	 * #Argument: mandatorydetails
	 * Type: Textbox
	 */
	public boolean enterMandatoryDetailsInTheScheduledReferral(String[] mandatorydetails)
	{
		if(this.selectReferralPromptedByDropdown(mandatorydetails[0]))
			if(this.selectReferralReasonDropdown(mandatorydetails[1]))
				return this.selectTransferOutcomeDropdown(mandatorydetails[2]);
		return false;
	}



	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterDetailsInTheScheduledReferralSection
	 * #Description: This functionality enters all the required Details in the Manage Referral overview section
	 * #Argument: details
	 * Type: Textbox & Dropdown
	 */
	public boolean enterDetailsInTheScheduledReferralSection(String[] details)
	{
		if(this.selectReferralVendorProgramDropdown(details[0]))
			if(this.selectReferralVendorProgramCategoryDropdown(details[1]))
				if(this.enterPreferredCallBackDate(details[2]))
					if(this.enterPreferredCallBackTime(details[3]))
						if(this.selectTimeZoneDropdown(details[4]))
							if(this.enterPhoneNumber(details[5]))
								if(this.enterPhoneNumberExtension(details[6]))
									if(this.selectYesOrNoInVoiceMail(details[7]))
										return this.enterReferralNotes(details[8]);
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickReferralHistoryCheckboxInManageReferral
	 * #Description: This functionality performs click action on the Referral History checkbox in the Referral History section
	 * Type: Textbox
	 */

	public boolean clickReferralHistoryCheckboxInManageReferral()
	{
		return utils.clickAnelemnt(this.chckBxReferralHistory, "ManageReferral", "Referral History Checkbox");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCorrespondenceInformationCheckboxInManageReferral
	 * #Description: This functionality performs click action on the Correspondence Information checkbox in the Referral History section
	 * Type: Textbox
	 */
	public boolean clickCorrespondenceInformationCheckboxInManageReferral()
	{
		return utils.clickAnelemnt(this.chckBxCorrespondenceInformation, "ManageReferral", "Correspondence Information Checkbox");
	}

	WebDriverWait wait;

	public boolean verifyDropDownValues()
	{
		try
		{
			System.out.println("Entered into method");
			String[] actualValues = {"Select","Care Gap Alert","Clinical Out Of Range Alert","Clinical Outreach Alert","Consultative Listening","Healthways Out of Range Alert","Healthy Lifestyles Alert","System Speech Recognition"};
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReferralPromptedBy")));
			WebElement drpDown = Driver.pgDriver.findElement(By.id("ReferralPromptedBy"));
			Select dropDownOptions = new Select(drpDown);
			List<WebElement> allDrpdwnValues = dropDownOptions.getOptions();
			System.out.println("Drop Down Size: "+allDrpdwnValues.size());
			System.out.println("Dropdown Value: ");
			for(WebElement dvalue:allDrpdwnValues)
			{
				System.out.println(dvalue.getText());
				String ExpectedValues = dvalue.getText();
				for (int i=0; i<actualValues.length; i++)
				{
					if (dvalue.getText().equals(actualValues[i]))
					{
						System.out.println("Matched");
					} 
				}

			}
			return true;
		}catch(Exception e)
		{
			err.logcommonMethodError("ManageReferral", "verifyDropDownValues");
			return false;
		}
	}


	@FindBy (xpath="//td[@class='dataValueRead']/descendant::a[text()!='']")	
	WebElement lnkFileNet;	

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateTOFileNet
	 * #Description: This functionality performs click action on the Correspondence Information checkbox in the Referral History section
	 * Type: Textbox
	 */

	public boolean navigateTOFileNet() throws Exception {
		if (lnkFileNet.getText().contains("--")) {
			err.logError("ManageReferral", "Error in navigating to Filenet window.");
			return false;
		} else{
			utils.clickAnelemnt(this.lnkFileNet, "ManageReferral", "link Filenet");
			return true;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateTheGuidedDialogIsPresent
	 * #Description: This functionality verifies the presence of guided dialog in Manage Referral.
	 * Type: Textbox
	 */

	@FindBy(xpath="//div[@id='DialogContent' and contains(text(), 'You can find Referrals')]")
	WebElement txtGuidedDialog;

	@FindBy(xpath ="//div[@id='CT']/a[@disabled and @class='Add_task' and @title = 'Manage Referrals']")
	WebElement addTasksManageReferrals;

	public boolean validateTheGuidedDialogIsPresent(String[] args) {
		String guidedDialogText = "You can find Referrals for " + args[0] + " here." + "\n"
				+"View Overview, Referral History and Correspondence.";
		if(txtGuidedDialog.getText().trim().equals(guidedDialogText))
			return true;
		else{
			err.logError("ManageReferral", "Error in Validating the guided dialog text.");
			return false;
		}
	}	

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyTheManageReferralTaskIsDisabled
	 * #Description: This functionality verifies the Manage Referral task is disabled for the second time.
	 * a
	 */

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")	
	private WebElement btnAddTAsk;

	public WebElement getbtnAddTAsk()
	{
		return btnAddTAsk;
	}

	public boolean clickbtnAddTask() throws InterruptedException
	{
		return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");

	}

	public boolean verifyTheManageReferralTaskIsDisabled  () throws InterruptedException {
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(addTasksManageReferrals);
		return false;
	}

	@FindBy(xpath="(//div[@id='HARNESS_CONTENT']/child::table[@id='ERRORTABLE']/descendant::span[@id='ERRORMESSAGES_ALL']/ul/li)[1]")
	WebElement txtErrorMsgInManageReferral;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyTheErrorMessageDisplayedInManageReferral
	 * #Description: This functionality verifies the error message displayed in the Manage Referral page when user click on submit without tagging either capturing a referral or Referral History and Correspondence tab
	 * #Type: Textbox
	 */
	public boolean verifyTheErrorMessageDisplayedInManageReferral()
	{
		String txtActualErrorMsg = (String) ((JavascriptExecutor) Driver.pgDriver).executeScript("return arguments[0].innerHTML", txtErrorMsgInManageReferral);
		System.out.println("Error msg in Manage Referral section is: "+txtActualErrorMsg);
		String txtExpectedErrorMsg = "You have not recorded any Referral or tagged Referral History or Correspondence as being discussed. Record at least one  Referral, Referral History or Correspondence as being discussed if applicable and click Submit. Otherwise if you want to submit without any action as advised above use ‘Cancel this Work’ from Other actions.";
		if(txtActualErrorMsg.equalsIgnoreCase(txtExpectedErrorMsg))
		{
			blogger.loginfo("Actual Message and Expected message is same in Manage Referral section");
			return true;
		}
		else
		{
			blogger.loginfo("Actual Message and Expected message is not same in Manage Referral section");
			return true;
		}
	}

	@FindBy(xpath="//label[contains(text(),'Overview')]")
	WebElement labelOverView;

	public boolean verifyManageReferralsOverviewTabIsNotDisplayed()
	{
		return utils.isProxyWebelement(labelOverView);
	}

}
