package automationLib;

import java.util.ArrayList;
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

public class BrokerSearchForGroup {

	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();

	public BrokerSearchForGroup()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForBroker;

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="DialogContent")
	WebElement labelGroupGuidedDialog;

	@FindBy(xpath="//input[@data-test-id='20180703152859072027522']")
	WebElement txtBxGroupNumber;

	@FindBy(xpath="//input[@data-test-id='20180703152859072228531']")
	WebElement txtBxGroupName;


	@FindBy(xpath="//div[contains(text(),'Search')]")
	WebElement btnSearch;

	@FindBy(xpath="//div[contains(text(),'Clear')]")
	WebElement btnClear;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnGrpsubmit;

	@FindBy(xpath="//div[contains(text(),'Other Actions')]")
	WebElement drpDownOtherActions;
	
	@FindBy(id="SearchGroupName")
	WebElement txtGroupName;
	
	@FindBy(id="SearchGroupNumber")
	WebElement txtGroupNumber;
	
	/**
	 * This functionality validates the guided dialog for the group search page
	 * @return
	 */
	public boolean verifyGuidedlineInSearchForGroupScreen()
	{
		return utils.validateLabel(labelGroupGuidedDialog, "Be Patient. You may need to explain to the caller that these questions help us keep private patient information protected");
	}


	/**
	 * This functionality verifies the Group Number and Group Name field is displayed in the Group Search page
	 * @return
	 */
	public boolean verifyGroupNumberAndGroupNameFeildsIsDisplayed()
	{
		if(utils.isProxyWebelement(txtBxGroupNumber))
			if(utils.isProxyWebelement(txtBxGroupName))
				return true;
		return false;
	}
	
	/**
	 * This functionality clicks the submit button in the Group Search page
	 * @return
	 */

	public boolean clickOnSubmit()
	{
		WebElement element = btnGrpsubmit;
	   	((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(btnGrpsubmit,"BrokerSearchForGroup","Submit");
	}
	
	/**
	 * This functionality verifies that the Search and clear button is displayed in the Broker Search group page
	 * @return
	 */

	public boolean verifySearchAndClearButtonIsDisplayed()
	{		
		 if(utils.isProxyWebelement(btnSearch))
			 if(utils.isProxyWebelement(btnClear))
				 return true;
		 return false;
	}

	
	/**
	 * This functionality verifies that the Other Actions is displayed in the Group Search page
	 * @return
	 */

	public boolean validateOtherActionInSearchForGroupScreenIsDisplayed()
	{
		return utils.isProxyWebelement(drpDownOtherActions);
	}
	
	@FindBy(xpath="//span[contains(text(),'HIPAA Verification for Group')]")
	WebElement labelGroupAdditionalVerificationInHippa;
	
	@FindBy(xpath="//label[@data-test-id='201603111611110477303673']")
	WebElement labelGroupInstructionalTExtForAdditionalInformation;
	

	@FindBy(xpath="//li[contains(text(),'You must verify the Group Name and Group Number in order to continue with the interaction.')]")
	WebElement labelErrorMsgForGroupHippaFail; 
	
	@FindBy(id="IsGroupNameVerified")
	WebElement chbxGroupName;

	@FindBy(id="IsGrpNumberVerified")
	WebElement chbxGroupNumber; 

	/**
	 * This functionality validates the HIPPA Verification title and the Instructional text for the Additional Information in the Group Search page
	 * @return
	 */
	
	public boolean validateHippaVerificationTitle()
	{
		if(utils.validateLabel(labelGroupAdditionalVerificationInHippa, "HIPAA Verification for Group"))
			if(utils.validateLabel(labelGroupInstructionalTExtForAdditionalInformation, "NOTE: The Interactive Voice Response(IVR) system will prepopulate fields that the caller provides."))
				return true;
		return false;
		

	}
	
	/**
	 * This functionality validates the HIPPA failure error message in the Group Search page
	 * @return
	 */
	public boolean validateHIPPAFailErrorMessage()
	{
		return utils.validateLabel(labelErrorMsgForGroupHippaFail, "You must verify the Group Name and Group Number in order to continue with the interaction.");
	}

	
	/**
	 * This functionality clicks the Group Name and the Group Number check box for HIPPA Verification in the Group Search page
	 * @return
	 */
	public boolean verifyGroupNameAndGroupNumberForHippaPass()
	
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(chbxGroupName, "BrokerSearchForGroup", "TIN"))
			return utils.clickAnelemnt(chbxGroupNumber, "BrokerSearchForGroup", "Agency Name");
		return false;
		
	}
	
	@FindBy(xpath="//table[@pl_prop='.clientSearch']")
	WebElement tblGroupSearch;
	
	@FindBy(xpath="//div[@id='FormErrorMarker_Div']//span[@id='ERRORMESSAGES_ALL']//li[starts-with(text(),'You must verify')]")
	WebElement labelErrorMsgWhenNoGroupResultsIsSelected;
	
	
	/**
	 * This functionality enters the Group name in the group name text box in the Group search page
	 * @param args
	 * @return
	 */
	public boolean enterGroupName(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxGroupName, args[0], "BrokerSearchForGroup", "Group Name");
	}
	
	/**
	 * This functionality enters the Group number in the group number text box in the Group search page
	 * @param args
	 * @return
	 */
	public boolean enterGroupNumber(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxGroupNumber, args[0], "BrokerSearchForGroup", "Group Number");
	}
	
	/**
	 * This functionality performs the click action on the Search button
	 * @return
	 */
	public boolean clickOnSearchButton()
	{
		return utils.clickAnelemnt(btnSearch, "BrokerSearchForGroup", "Search button");
	}
	
	/**
	 * This functionality performs the click action on the Clear button
	 * @return
	 */
	public boolean clickOnClearButton()
	{
		return utils.clickAnelemnt(btnClear, "BrokerSearchForGroup", "Clear button");
	}
	
	@FindBy(xpath="//ul[contains(@id,'pyNavigation')]//li[@title='Exit Interaction']")
	WebElement lnkExitInteraction;
	
	/**
	 * This functionality validates that the Exit Interaction is displayed in the Other Action drop down at Group Search page
	 * @return
	 */
	public boolean validateOtherActionDropDownForExitInteraction()
	{
		WebElement element = drpDownOtherActions;
	   	((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		utils.clickAnelemnt(drpDownOtherActions, "BrokerSearchForGroup", "Other Actions");
		return !utils.isProxyWebelement(lnkExitInteraction);
	}
		
		
	/**
	 * This functionality validates the value given by the user in the Search result table and select the group
	 * @param tablevalues
	 * @return
	 */
	public boolean validateSearchResultTableAndSelectTheGroup(String[] tablevalues)
	{
		utils.waitforpageload();
		
		try
		{
		WebElement row = utils.returntablerowbasedonvalues(tblGroupSearch, tablevalues);
		List<WebElement> rowNo = row.findElements(By.tagName("input"));
		rowNo.get(0).click();
		return true;
		}catch (Exception e)
		{
			err.logError("BrokerSearchForGroup", "validateSearchResultTableAndSelectTheGroup");
			return false;
		}
	}
	
	/**
	 * This functionality validates the error message when no group details are selected
	 * @param args
	 * @return
	 */
	public boolean validateErrorMessageWhenNoGroupDetailsAreSelected(String[] args)
	{
		return utils.validateLabel(labelErrorMsgWhenNoGroupResultsIsSelected, args[0]);
	}
	
	@FindBy(id="")
	WebElement rdoBtnFirstRow;

	/**
	 * This functionality verifies that the Group is auto selected when the search results has only one group result in the table
	 * @return
	 */
	public boolean selectGroupDetailFromSearchResults_AutoSelect()
	{
		int rowCount = tblGroupSearch.findElements(By.tagName("tr")).size();
		System.out.println("Row Count is: "+rowCount);
		if(rowCount == 2)
		{
			boolean bol = rdoBtnFirstRow.isSelected();
			System.out.println("Bol is: "+bol);
			if(bol == true)
			{
				blogger.loginfo("First row is auto selected");
				System.out.println("First row is auto selected");
				return true;
			}else
			{
				blogger.loginfo("First row is not auto selected");
				System.out.println("First row is not auto selected");
				return true;
			}
		}else
		{
			System.out.println("There are more than a single row");
			return false;
		}
	}
	
	/**
	 * This functionality enters the Group Name and Group Number less the 3 digit and clicks the search button
	 * @param args
	 * @return
	 */
	public boolean enterGroupNameAndGroupNumberLessThan3Digit(String[] args)
	{
		if(utils.enterTextinAnelemnt(txtBxGroupNumber, args[0], "BrokerSearchForGroup", "Group Number"))
		{
			if(utils.enterTextinAnelemnt(txtBxGroupName, args[1], "BrokerSearchForGroup", "Group Name"))
			{
				if(utils.clickAnelemnt(btnSearch, "BrokerSearchForGroup", "Search"))
				{
					blogger.loginfo("Group Name and Group Number is entered and search is clicked");
					return true;
				}
			}
		}
		return false;
	}
	
	@FindBy(id="$PpyWorkPage$pSearchGroupNumberError")
	WebElement labelErrorForGroupNumberSection;
	
	@FindBy(id="$PpyWorkPage$pSearchGroupNameError")
	WebElement labelErrorForGroupNameSection;
	
	/**
	 * This functionality validates the error message displayed when group name and group number is entered less than 3 digit
	 * @return
	 */
	public boolean validateThatTheErrorMsgIsDisplayedForGroupNameAndGroupNumberWhenLessThan3DigitIsEntered()
	{
		if(!utils.isProxyWebelement(labelErrorForGroupNumberSection))
		{
			if(!utils.isProxyWebelement(labelErrorForGroupNumberSection))
			{
				blogger.loginfo("Error message for Group Name and Group Number is displayed");
				return true;
			}
		}
		return false;
	}
	
	@FindBy(id="FirstName")
	WebElement txtBxFirstName;

	@FindBy(id="LastName")
	WebElement txtBxLastName;
	
	@FindBy(id="CallBackNumber")
	WebElement txtBxCallBackNumber;
	
	@FindBy(id="CallBackNumExt")
	WebElement txtBxCallBackExtension;
	
	@FindBy(id="ContactEmailID")
	WebElement txtBxEmail;
	
	@FindBy(id="FaxNumber")
	WebElement txtBxFax;
	
	
	/**
	 * This functionality verifies that the first name, last name, callback number, extension are pre populated
	 * @param args
	 * @return
	 */
	public boolean validateCaptureCallerInfoFieldsArePrePopulated(String[] args)
	{

			boolean returnvar ;
			returnvar = true;

			for(int i=0;i<args.length;i++) 
			{
				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check Either Your input is wrong or the value found on application is incorrect");
					return false;

				}

				String key = args[i].substring(0, args[i].indexOf(":")).toLowerCase();
				String value = args[i].substring(args[i].indexOf(":")+1);
				
				if(utils.isvalueMatch_contain(key.toLowerCase(), "First Name")) {
					returnvar = utils.validateLabel(txtBxFirstName,value);
					continue;}

				else if(utils.isvalueMatch_contain(key.toLowerCase(), "Last Name")) {
					returnvar = utils.validateLabel(txtBxLastName,value);
					continue;}

				else if(utils.isvalueMatch_contain(key.toLowerCase(), "CallBack Number")) {
					returnvar = utils.validateLabel(txtBxCallBackNumber,value);
					continue;}

				else if(utils.isvalueMatch_contain(key.toLowerCase(), "Extension")) {
					returnvar = utils.validateLabel(txtBxCallBackExtension,value);
					continue;}
				
			}
			if(returnvar)
			{
				System.out.println("Values are pre populated and verified successfully");
				return true;	
			}
			else
			{
				int tot_i=args.length;
				err.logcommonMethodError("BrokerSearchForGroup", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
				return false;
			}
		}
	
	/**
	 * This functionality edits the caller information in the Group Search page
	 * @param args
	 * @return
	 */
	public boolean editCallerInfoFeilds(String[] args)
	{
		if(utils.enterTextinAnelemnt(txtBxFirstName, args[0], "BrokerSearchForGroup", "First Name"))
		{
			if(utils.enterTextinAnelemnt(txtBxLastName, args[1], "BrokerSearchForGroup", "Last Name"))
			{
				if(utils.enterTextinAnelemnt(txtBxCallBackNumber, args[2], "BrokerSearchForGroup", "Call Back Number"))
				{
					if(utils.enterTextinAnelemnt(txtBxCallBackExtension, args[3], "BrokerSearchForGroup", "Extension"))
					{
						if(utils.enterTextinAnelemnt(txtBxEmail, args[4], "BrokerSearchForGroup", "Email"))
						{
							if(utils.enterTextinAnelemnt(txtBxFax, args[5], "BrokerSearchForGroup", "Fax"))
							{
								blogger.loginfo("Caller details are edited");
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
		@FindBy(xpath="//label[@for='ContinueWithMember']")
		WebElement labelContinueWithMember;
		
		@FindBy(id="ContinueWithMember")
		WebElement chckBxContinueWithMember;
		
		/**
		 * This functionality validates that the 'Continue With Member' is displayed in the Group Search page
		 * @return
		 */
		
		public boolean validateContinueWithMemberSearchCheckBoxInSearchForBrokerScreenIsDisplayed()
		{
			return !utils.isProxyWebelement(labelContinueWithMember);
		}
		
		/**
		 * This function clicks the 'Continue With Member' checkbox in the Group search page
		 * @return
		 */
		public boolean clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen()
		{
			return utils.clickAnelemnt(chckBxContinueWithMember, "PhoneCallBrokerSearchBroker", "Continue With Member");
	
		}
		
		@FindBy(xpath="//span[@data-test-id='20151202213743095040593']")
		WebElement labelTinSSNResultGroup;
		
		/**
		 * This functionality verifies that the TIN/SSN result group is displayed in the Group search page
		 * @return
		 */
		public boolean verifySearchResultsForTINIsChangedToTINSSNinSearchForGroupPage() {
			return !utils.isProxyWebelement(labelTinSSNResultGroup);
		}
		
		@FindBy(xpath = "//div[@node_name='HIPPAVerificationBro']//span[text()='HIPAA Verification']")
		WebElement labelHIPPAVerificationTitle;
		
		@FindBy(id = "DialogContent")
		private WebElement labelGuidedDialog;

		@FindBy(id = "CallBackNumExt")
		WebElement txtBxExtension;
		
		@FindBy(id = "ContactEmailID")
		WebElement txtBxEmailID;
		
		@FindBy(id = "FaxNumber")
		WebElement txtBxFaxID;
		
		public boolean verifyCallerInfoFieldsAreNotPresent()
		{
			return utils.isProxyWebelement(txtBxCallBackNumber) && utils.isProxyWebelement(txtBxExtension) && utils.isProxyWebelement(txtBxEmailID) && utils.isProxyWebelement(txtBxFaxID) && utils.isProxyWebelement(txtBxFirstName) && utils.isProxyWebelement(txtBxLastName);
		}
		
		
		public boolean verifyHIPPAVerficationFieldIsNotPresent()
		{
			return utils.isProxyWebelement(labelHIPPAVerificationTitle);
		}
		
		
		public boolean verifyGuidedDialogsAreNotPresent()
		{
			return utils.isProxyWebelement(labelGuidedDialog);
		}
		
		
		/**
		 * This functionality expands the group row for which the user given as input
		 * @param args
		 * @return
		 */
		
		public boolean expandGroupByTheValueGivenByTheUser(String[] args)
		{

			try {
				WebElement row = utils.returntablerowbasedonvalues(tblGroupSearch, args);
				List<WebElement> rowNo1 = row.findElements(By.tagName("input"));
				rowNo1.get(0).click();
				Thread.sleep(5000);
				List<WebElement> rowNo = row.findElements(By.tagName("td"));
				rowNo.get(0).click();
				return true;
			} catch (Exception e) {
				System.out.println("Exception :" + e);
				err.logcustomerrorwithmessage("PhoneCallBrokersearchBroker", "selectBrokerByTheValueGivenByTheUser",
						"Error in validating the Broker results");
				return false;
			}
		
		}
		
		@FindBy(xpath="//table[@pl_prop='.ProductGroupList']//tr[2]//input[@id='CaseOrTaskIcon']")
		WebElement firstRdoBtnInSubGroupList;
		
		/**
		 * This functionality verifies whether that the first sub group is auto selected
		 * @return
		 */
		public boolean verifyFirstSubGroupIsAutoSelected()
		{
			boolean bol = firstRdoBtnInSubGroupList.isSelected();
			if(bol==true)
			{
				blogger.loginfo("First Sub Group is Auto Selected");
				return true;
			}
			else
			{
				blogger.loginfo("First Sub Group is not Auto Selected");
				return false;
			}
		}
		
		@FindBy(xpath="//table[@pl_prop='.ProductGroupList']")
		WebElement tblSubGroupList;
		
		/**
		 * This functionality selects the sub group details by the value given by the user
		 * @param args
		 * @return
		 */
		
		public boolean selectSubGroupDetails(String[] args)
		{

			try {
				WebElement row = utils.returntablerowbasedonvalues(tblSubGroupList, args);
				List<WebElement> rowNo = row.findElements(By.tagName("input"));
				rowNo.get(0).click();
				return true;
			} catch (Exception e) {
				System.out.println("Exception :" + e);
				err.logcustomerrorwithmessage("PhoneCallBrokersearchBroker", "selectBrokerByTheValueGivenByTheUser",
						"Error in validating the Broker results");
				return false;
			}
		
		}
		
		/**
		 * This functionality verifies whether that the first sub group is auto selected
		 * @return
		 */
		public boolean verifySubGroupIsAutoSelectedForSubGroupSearch()
		{
			boolean bol = firstRdoBtnInSubGroupList.isSelected();
			if(bol==true)
			{
				blogger.loginfo("First Sub Group is Auto Selected");
				return true;
			}
			else
			{
				blogger.loginfo("First Sub Group is not Auto Selected");
				return false;
			}
		}
		
		
		//Sprint 8.1
		
		@FindBy(id="KnownBrokerRelationship")
		WebElement chckBxSkipHippaVerificationForBroker;
		
		
		public boolean verifySkipHIPPAVerificationForTheKnownBrokerRelationshipCheckboxIsNotPresent()
		{
			return utils.isProxyWebelement(chckBxSkipHippaVerificationForBroker);
		}
		
		public boolean verifySkipHIPPAVerificationForTheKnownBrokerRelationshipCheckboxIsPresent()
		{
			return !utils.isProxyWebelement(chckBxSkipHippaVerificationForBroker);
		}
		
		public boolean clickSkipHIPPAVerificationForTheKnownBrokerRelationshipCheckbox()
		{
			return utils.clickAnelemnt(chckBxSkipHippaVerificationForBroker, "PhoneCallBrokersearchBroker", "Skip Hippa Verification");
		}

		public boolean verifySkipHIPPAVerificationForTheKnownBrokerRelationshipCheckboxIsAlreadySelected()
		{
			boolean chckBx = chckBxSkipHippaVerificationForBroker.isSelected();
			if(chckBx==true)
			{
				blogger.loginfo("Skip Hippa Verification for Known Broker Relationship is already selected");
				return true;
			}
			else
			{
				blogger.loginfo("Skip Hippa Verification for Known Broker Relationship is not already selected");
				return false;
			}
		}
		
		
		/**
		 * Navigates to Search Broker Screen from Search Group page
		 */
		
		public boolean navigateToSearchBroker()	
		{
			utils.waitforpageload();
			return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "Search Broker", "BrokerSearchForGroup", "Search Broker");
		}
}



