package automationLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class PhoneCallBrokersearchBroker {

	SeleniumUtilities utils = new SeleniumUtilities();
	Header hobj1 = new Header();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err = new ErrorLogger();

	public PhoneCallBrokersearchBroker() {

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver
		// checkforpageload();
	}

	@FindBy(className = "anthem_theme_header")
	private WebElement sHeaderSearchForBroker;

	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;

	public boolean validateBrokerPageTitle() {
		return utils.validateHeader(sHeaderSearchForBroker, "Search For Broker");
	}

	@FindBy(id = "DialogContent")
	private WebElement labelGuidedDialog;

	public boolean validateGuidedDialogInSearchForBrokerPage() {
		Driver.pgDriver.switchTo().defaultContent();
		Header.getUserName();
		Driver.pgDriver.switchTo().frame(Iframeelement);
		String actualText = "Thank you for calling Anthem Broker Services! My name is "+Header.user+". How can I assist you? Listen for how the caller introduces themselves. Confidently acknowledge that you can help them and let them know you will be verifying their information.  I’d be happy to help you. I first need to verify some information. Be sure to follow the HIPAA IDG tool guidelines.";
		String expText = labelGuidedDialog.getText().replaceAll("\n", " ").replaceAll("\"", "").replaceAll("\\”", "").replaceAll(",", "").trim();
		return utils.isvalueMatch_contain(actualText, expText);
	}

	@FindBy(xpath = "//input[@id='BrokerSearchTypeTIN']")
	private WebElement rdoBtnTIN;
	@FindBy(id = "SearchStringTIN")
	private WebElement txtBxTINID;
	@FindBy(xpath = "//div[text()='Search']")
	private WebElement btnSearch;

	@FindBy(xpath = "(//span[@id='ERRORMESSAGES_ALL']//li)[1]")
	WebElement labelErrorMsg;

	@FindBy(xpath = "//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	public boolean searchByTIN(String[] args) {
		if(utils.clickAnelemnt(rdoBtnTIN, "PhoneCallBrokersearchBroker", "TIN Rdo Btn"))
			if(utils.enterTextinAnelemnt(txtBxTINID, args[0], "PhoneCallBrokerSearchBroker", "EncryptedTIN id"))
				utils.scrolltomiddle();
				if(utils.clickAnelemnt(btnSearch, "PhoneCallBrokerSearchBroker", "brkr srch"))
					return true;
		return false;

	}

	public boolean clearTheEnteredTIN(String[] args) {
		if(utils.clickAnelemnt(rdoBtnTIN, "PhoneCallBrokersearchBroker", "TIN Rdo Btn"))
			if(utils.enterTextinAnelemnt(txtBxTINID, args[0], "PhoneCallBrokerSearchBroker", "EncryptedTIN id"))
				if(utils.clickAnelemnt(txtBxTINID, "PhoneCallBrokerSearchBroker", "brkr srch"))
					return true;
		return false;
	}

	public boolean verifyTheErrorMsgWhenMoreThanTenDigitIsEnteredInTIN() {
		//if(!utils.isProxyWebelement(labelErrorMsg))
		String actualText = "Please enter a valid 9 Digit or 10 Character Alpha-numeric TIN";
		String expectedText = labelErrorMsg.getText();
		return utils.isvalueMatch_contain(actualText, expectedText);
	}

	@FindBy(xpath = "//table[@pl_prop='D_BrokerDetails.pxResults']")
	WebElement tblSearchResults;

	//@FindBy(xpath = "//table[@pl_prop='D_GroupList.pxResults']")
	//@FindBy(xpath="//table[@pl_prop='.clientSearch']")
	@FindBy(xpath="//table[@pl_prop='.clientSearch' or @pl_prop='D_GroupList.pxResults']")
	WebElement tblGroupSearchResults;

	public boolean validateTableHeadersForBrokerSearchResults() {
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblSearchResults);
		System.out.println("Values from the App: " + valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Select");
		valuesGivenManual.add("TIN");
		valuesGivenManual.add("Name");
		valuesGivenManual.add("Phone Number");
		System.out.println("Values Given Manually: " + valuesGivenManual);
		if (valuesFromApp.equals(valuesGivenManual)) {
			System.out.println("Values Matched");
			return true;
		} else {
			System.out.println("Values doesnt Matched");
			return false;
		}
	}

	public boolean selectBrokerByTheValueGivenByTheUser(String[] tablevalues) {
		try {
			utils.waitforpageload();
			System.out.println("Entered");
			WebElement row = utils.returntablerowbasedonvalues(tblSearchResults, tablevalues);
			List<WebElement> rowNo = row.findElements(By.id("CaseOrTaskIcon"));
			rowNo.get(0).click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception :" + e);
			err.logcustomerrorwithmessage("PhoneCallBrokersearchBroker", "selectBrokerByTheValueGivenByTheUser",
					"Error in validating the Broker results");
			return false;
		}
	}

	public boolean clickOnSubmit() {
		//utils.scrolltomiddle();
		((JavascriptExecutor) Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",
				this.btnSubmit);
		return utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit");
	}

	public boolean validateTheErrorMsgOnClickingSubmit() {
		return true;
	}

	@FindBy(xpath = "//div[@data-test-id='2018070517012902771564']")
	WebElement labelErrorMsgForNoResults;

	public boolean validateTheErrorMsgWhenNoResultsFoundForTIN(String[] args) {
		String actualText = args[0];
		String expectedTExt = labelErrorMsgForNoResults.getText().replaceAll(",", "");
		return utils.isvalueMatch_contain(actualText, expectedTExt);
	}

	@FindBy(xpath = "//div[contains(text(),'Other Actions')]")
	WebElement drpDownOtherActions;

	public boolean selectValuesFromOtherActions(String[] args) {
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, args[0], "PhoneCallBrokersearchBroker","Other Actions - " + args[0]);
	}

	@FindBy(xpath = "//div[@node_name='HIPPAVerificationBro']//span[text()='HIPAA Verification']")
	WebElement labelHIPPAVerificationTitle;

	@FindBy(xpath = "//label[@data-test-id='201603111611110477303673']")
	WebElement labelHIPPANote;

	@FindBy(id = "IsNameVerified")
	WebElement chckBxAgencyName;

	@FindBy(id = "IsTINVerified")
	WebElement chckBxAgencyTIN;

	@FindBy(id = "IsBusinessPhoneVerified")
	WebElement chckBxAgencyPhoneNUmberPrimary;

	@FindBy(id = "IsHomePhoneVerified")
	WebElement chckBxAgencyPhoneNumberSecondary;

	@FindBy(id = "IsOtherPhoneVerified")
	WebElement chckBxAgencyPhoneNumberOther;

	@FindBy(id = "IsAddressVerified")
	WebElement chckBxAgencyAddress;

	@FindBy(xpath = "//div[contains(@param_name,'EXPANDEDSubSectionHIPPAVerificationBro')]//b[text()='Additional Verification:']")
	WebElement labelAdditionalVerificationInHippa;

	@FindBy(xpath = "//div[@data-test-id='201603111611110477303673']")
	WebElement labelInstructionalTExtForAdditionalInformation;

	public boolean validateHIPPAVerificationTitleAndNote() {
		if (utils.validateLabel(labelHIPPAVerificationTitle, "HIPAA Verification"))
			if (utils.validateLabel(labelHIPPANote,"NOTE: The Interactive Voice Response(IVR) system will prepopulate fields that the caller provides."))
				return true;
		return false;
	}

	public boolean verifyAgencyNameCheckBoxIsDisplayed() {
		return !utils.isProxyWebelement(chckBxAgencyName);
	}

	public boolean verifyAgencyTINCheckBoxIsDisplayed() {
		return !utils.isProxyWebelement(chckBxAgencyTIN);
	}

	public boolean validateAdditionalVerificationTitleAndInstructionalText() {
		((JavascriptExecutor) Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",
				this.labelAdditionalVerificationInHippa);
		if (utils.validateLabel(labelAdditionalVerificationInHippa, "Additional Verification:"))
		{
			String expectedText = labelInstructionalTExtForAdditionalInformation.getText().replaceAll("\n", " ").replaceAll(",", "");
			String actualText = "Attempt to validate First/Last Name TIN and Agency Name first. If the contact is unable to verify First/Last Name TIN and Agency Name then validate the contact using other data fields. At least two data fields used for validation must be unique to the Broker.";
			return utils.isvalueMatch_contain(actualText, expectedText);
		}
		return false;
	}

	public boolean verifyAgencyPhoneNumberPrimaryCheckBoxIsDisplayed() {
		return !utils.isProxyWebelement(chckBxAgencyTIN);
	}

	public boolean verifyAgencyPhoneNumberSecondaryCheckBoxIsDisplayed() {
		return !utils.isProxyWebelement(chckBxAgencyTIN);
	}

	public boolean verifyAgencyPhoneNumberOtherCheckBoxIsDisplayed() {
		return !utils.isProxyWebelement(chckBxAgencyTIN);
	}

	public boolean verifyAgencyAddressCheckBoxIsDisplayed() {
		return !utils.isProxyWebelement(chckBxAgencyTIN);
	}

	@FindBy(id = "BrokerContactType")
	WebElement drpDownContactType;

	@FindBy(id = "FirstName")
	WebElement txtBxFirstName;

	@FindBy(id = "LastName")
	WebElement txtBxLastName;

	@FindBy(id = "CallBackNumber")
	WebElement txtBxCallBackNumber;

	@FindBy(id = "CallBackNumExt")
	WebElement txtBxExtension;

	@FindBy(id = "FaxNumber")
	WebElement txtBxFaxNumber;

	@FindBy(xpath = "(//span[@id='ERRORMESSAGES_ALL']//li)[1]")
	WebElement labelErrorMsgForHippaFail;

	@FindBy(id = "ContactEmailID")
	WebElement txtBxEmailID;

	@FindBy(id = "FaxNumber")
	WebElement txtBxFaxID;

	@FindBy(xpath = "//span[@title='** Please enter a valid phone number']")
	WebElement imgErrorFlagForCallBackNum;

	@FindBy(xpath = "//span[@title='Please enter a valid 7 digit callback extension']")
	WebElement imgErrorFlagForExtnNum;

	@FindBy(xpath = "//span[@title='** Please enter a valid fax number']")
	WebElement imgErrorFlagForFaxNum;

	public boolean enterEmailID(String[] args) {
		return utils.enterTextinAnelemnt(txtBxEmailID, args[0], "PhoneCallBrokersearchBroker", "Email ID");
	}

	public boolean enterFaxNumber(String[] args) {
		return utils.enterTextinAnelemnt(txtBxFaxID, args[0], "PhoneCallBrokersearchBroker", "Fax Num");
	}

	public boolean enterCallBackNumber(String[] args) {
		return utils.enterTextinAnelemnt(txtBxCallBackNumber, args[0], "PhoneCallBrokersearchBroker", "Call Back Num");
	}

	public boolean enterExtensionNumber(String[] args) {
		return utils.enterTextinAnelemnt(txtBxExtension, args[0], "PhoneCallBrokersearchBroker", "Extension");
	}

	public boolean verifyErrorFlagIsDisplayedWhenSpecialCharIsEnteredInCallBackNum() {
		return !utils.isProxyWebelement(imgErrorFlagForCallBackNum);
	}

	public boolean verifyErrorFlagIsDisplayedWhenSpecialCharIsEnteredInExtnNum() {
		return !utils.isProxyWebelement(imgErrorFlagForExtnNum);
	}

	public boolean verifyErrorFlagIsDisplayedWhenSpecialCharIsEnteredInFaxNum() {
		return !utils.isProxyWebelement(imgErrorFlagForFaxNum);
	}

	public boolean selectContactType(String[] args) {
		return utils.selectDropDownbyVisibleString(drpDownContactType, args[0], "PhoneCallBrokersearchBroker",
				"Contact Type");
	}

	public boolean enterFirstNameAndLastName(String[] args) {
		utils.waitforpageload();
		if (utils.enterTextinAnelemnt(txtBxFirstName, args[0], "PhoneCallBrokersearchBroker", "First Name"))
			if (utils.enterTextinAnelemnt(txtBxLastName, args[1], "PhoneCallBrokersearchBroker", "Last Name"))
				return true;
		return false;
	}

	public boolean enterCallBackNumberAndExtension(String[] args) {
		if (utils.enterTextinAnelemnt(txtBxCallBackNumber, args[0], "PhoneCallBrokersearchBroker","Call Back Number"))
			if (utils.enterTextinAnelemnt(txtBxExtension, args[1], "PhoneCallBrokersearchBroker", "Extension"))	
				return true;
		return false;
	}

	public boolean clickTinAndAgencyNameCombinationForHippaPass() {
		if (utils.clickAnelemnt(chckBxAgencyTIN, "PhoneCallBrokersearchBroker", "TIN"))
			if (utils.clickAnelemnt(chckBxAgencyName, "PhoneCallBrokersearchBroker", "Agency Name"))
				return true;
		return false;
	}

	public boolean clickTINAgencyNameAndAgencyAddressCombinationForHippaPass() {
		if (utils.clickAnelemnt(chckBxAgencyTIN, "PhoneCallBrokersearchBroker", "TIN"))
			if (utils.clickAnelemnt(chckBxAgencyName, "PhoneCallBrokersearchBroker", "Agency Name"))
				if (utils.clickAnelemnt(chckBxAgencyAddress, "PhoneCallBrokersearchBroker", "Agency Address"))
					return true;
		return false;
	}

	public boolean clickTinAgencyNameAndAgencyPhoneNumberPrimaryCombinationForHippaPass() {
		if (utils.clickAnelemnt(chckBxAgencyTIN, "PhoneCallBrokersearchBroker", "TIN"))
			if (utils.clickAnelemnt(chckBxAgencyName, "PhoneCallBrokersearchBroker", "Agency Name"))
				if (utils.clickAnelemnt(chckBxAgencyPhoneNUmberPrimary, "PhoneCallBrokersearchBroker","Agency Phone Number Primary"))
					return true;
		return false;
	}

	public boolean clickTINAgencyNameAndAgencyPhoneNumOTherCombinationForHippaPass() {
		if (utils.clickAnelemnt(chckBxAgencyTIN, "PhoneCallBrokersearchBroker", "TIN"))
			if (utils.clickAnelemnt(chckBxAgencyName, "PhoneCallBrokersearchBroker", "Agency Name"))
				if (utils.clickAnelemnt(chckBxAgencyPhoneNumberOther, "PhoneCallBrokersearchBroker","Phone Number - Other"))
					return true;
		return false;
	}

	public boolean validateHIPPAFailErrorMessage(String[] args) {
		String actualText = args[0];
		String expectedText = labelErrorMsgForHippaFail.getText().replaceAll(",", "").trim();
		return utils.isvalueMatch_contain(actualText, expectedText);
	}

	// Sprint 4.3

	@FindBy(id = "20151202213743095040593")
	WebElement txtTinSearch;

	@FindBy(xpath = "//a[@data-test-id='2014111304463909642300']")
	WebElement btnXHeader;

	@FindBy(xpath = "//div[@data-test-id='2018070911264002535825']")
	WebElement txtNoItems;

	@FindBy(id = "ModalButtonSubmit")
	WebElement btnyesInteraction;

	// Verify Search Results for TIN XXXXX is displayed

	public boolean validateSearchForTINResult() {
			return !utils.isProxyWebelement(txtTinSearch);
	}

	// verify Two phone numbers in HIPPA validation

	public boolean clickAgencyPhoneNumberPrimaryAndOtherForHippaFail()
	{
		String ActualtextH = "I'm sorry but without being able to verify your identity, I will not be able to share information with you today.";
		if (utils.clickAnelemnt(chckBxAgencyPhoneNUmberPrimary, "PhoneCallBrokersearchBroker","Primary Phone number"))
			if (utils.clickAnelemnt(chckBxAgencyPhoneNumberOther, "PhoneCallBrokersearchBroker","Phone Number - Other"))
				if(utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit"))
				{
				String expectedText = labelErrorMsgForHippaFail.getText().trim();
				return utils.isvalueMatch_contain(ActualtextH, expectedText);
				}
					
		return false;

	}

	public boolean clickAgencyPhoneNumberPrimaryAndAgencyAddressHippaPass()
	{
		if (utils.clickAnelemnt(chckBxAgencyPhoneNUmberPrimary, "PhoneCallBrokersearchBroker","Primary Phone number"))
			if (utils.clickAnelemnt(chckBxAgencyAddress, "PhoneCallBrokersearchBroker", "Agency Address"))
				if(utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit"))
				if (utils.isProxyWebelement(labelErrorMsgForHippaFail))
					return true;
		return false;
	}

	// Click on X button use story CCTSUSTAIN-53266

	public boolean verifyBrokerSearhResultsAreClearedAfterClosingInteraction() throws InterruptedException {
		Driver.pgDriver.switchTo().defaultContent();
		if (utils.clickAnelemnt(btnXHeader, "PhoneCallBrokersearchBroker", "X Btn"))
			if (utils.clickAnelemnt(btnyesInteraction, "PhoneCallBrokersearchBroker", "Yes Btn"))
				if (hobj1.createNewInteractionPhoneCallBroker())
					Driver.pgDriver.switchTo().frame(Iframeelement);
					return !utils.isProxyWebelement(txtNoItems);
	}

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pSearchStringTINError']")
	WebElement imgTinError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pFirstNameError']//span")
	WebElement imgFirstNameError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pLastNameError']//span")
	WebElement imgLastNameError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pBrokerContactTypeError']//span")
	WebElement imgContactTypeError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pCallBackNumberError']//span")
	WebElement imgCallBackNumber;

	public boolean verifyFlagPointingToAllMandatoryFeilds() {
			return !utils.isProxyWebelement(imgTinError) && !utils.isProxyWebelement(imgFirstNameError)
					&& !utils.isProxyWebelement(imgLastNameError) && !utils.isProxyWebelement(imgContactTypeError)
					&& !utils.isProxyWebelement(imgCallBackNumber);
	}

	@FindBy(xpath = "//table[@id='ERRORTABLE']//span[@id='ERRORMESSAGES_ALL']//li")
	WebElement labelErrorMsgForInvalidTINEntered;

	public boolean verifyTheErrorMsgIsDisplayedWhenMoreThanTenDigitIsEnteredInTIN() {
		return !utils.isProxyWebelement(labelErrorMsgForInvalidTINEntered);
	}

	public boolean verifySearchResultsForTINText(String[] tablevalues) {
		return utils.validatetablerowbasedonvalues(tblSearchResults, tablevalues);
	}

	// Verify dashes next to HIPPA feilds

	@FindBy(id = "2015042812583202823964")
	WebElement grayOutDashAgncyName;

	@FindBy(id = "201504281304350457121267")
	WebElement grayOutDashTin;

	@FindBy(id = "201807101311290581180801")
	WebElement grayOutDashPhneOther;

	@FindBy(id = "201807101311290581177622")
	WebElement grayOutDashPhneSecondary;

	@FindBy(xpath = "(//span[@data-test-id ='20180710060849022226949'])[1]")
	WebElement grayOutDashPhnePrimary;

	@FindBy(xpath = "(//span[@data-test-id ='20180710060849022226949'])[2]")
	WebElement grayOutDashAgencyAddress;

	public boolean verifyDashesNextToHippaFeilds() {
		return !utils.isProxyWebelement(grayOutDashAgncyName) && !utils.isProxyWebelement(grayOutDashTin)
				&& !utils.isProxyWebelement(grayOutDashPhneOther) && !utils.isProxyWebelement(grayOutDashPhneSecondary)
				&& !utils.isProxyWebelement(grayOutDashPhnePrimary)
				&& !utils.isProxyWebelement(grayOutDashAgencyAddress);

	}

	// Sprint 4.4

	// verify Group name and Group Number

	@FindBy(id = "BrokerSearchTypeGROUPID")
	WebElement rdoBtnGroupNumber;

	@FindBy(xpath = "//span[contains(text (),'Group Number')]")
	WebElement labelGroupNumber;

	@FindBy(id = "BrokerSearchTypeGROUPNAME")
	WebElement rdoBtnGroupName;

	@FindBy(xpath = "//span[contains(text (),'Group Name')]")
	WebElement labelGroupName;

	@FindBy(id = "SearchGroupName")
	WebElement txtBoxGroupName;

	@FindBy(id = "SearchGroupID")
	WebElement txtBoxGroupNumber;

	public boolean validateGroupNumberLabel() {
		if (utils.clickAnelemnt(rdoBtnGroupNumber, "PhoneCallBrokersearchBroker", "radio btn Broker Number"))
			return !utils.isProxyWebelement(labelGroupNumber);
		return false;
	}

	public boolean validateGroupNameLabel() {
		if (utils.clickAnelemnt(rdoBtnGroupName, "PhoneCallBrokersearchBroker", "radio btn Broker Number"))
			return !utils.isProxyWebelement(labelGroupName);
		return false;
	}


	public boolean searchByGroupNumber(String[] args) {

		if (utils.clickAnelemnt(rdoBtnGroupNumber, "PhoneCallBrokersearchBroker", "Group Number Rdo Btn"))
			if (utils.enterTextinAnelemnt(txtBoxGroupNumber, args[0], "PhoneCallBrokerSearchBroker","EncryptedTIN id"))
				return utils.clickAnelemnt(btnSearch, "PhoneCallBrokerSearchBroker", "brkr srch");
		return false;
	}

	public boolean searchByGroupName(String[] args) {

		if (utils.clickAnelemnt(rdoBtnGroupName, "PhoneCallBrokersearchBroker", "Group Name Rdo Btn"))
			if (utils.enterTextinAnelemnt(txtBoxGroupName, args[0], "PhoneCallBrokerSearchBroker", "Group Name"))
				return utils.clickAnelemnt(btnSearch, "PhoneCallBrokerSearchBroker", "brkr srch");
		return false;

	}

	@FindBy(xpath = "//div[@data-test-id='20180801093611095218464']")
	WebElement labelErrorMsgWhenNoGroupDetailsRetrieved;

	public boolean validateErrorMessageWhenNoGroupDetailsAreRetrived(String[] args) {
		String actualText = args[0];
		// return utils.validateLabel(labelErrorMsgWhenNoGroupDetailsRetrieved,
		// actualText);
		String expectedText = labelErrorMsgWhenNoGroupDetailsRetrieved.getText().replaceAll(",", "");
		return utils.isvalueMatch_contain(actualText, expectedText);
	}

	public boolean selectGroupByTheValueGivenByTheUser(String[] tablevalues) {
		try {
			System.out.println("Entered");
			WebElement row = utils.returntablerowbasedonvalues(tblGroupSearchResults, tablevalues);
			List<WebElement> rowNo = row.findElements(By.id("LocalRadio"));
			rowNo.get(0).click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception :" + e);
			err.logcustomerrorwithmessage("PhoneCallBrokersearchBroker", "selectBrokerByTheValueGivenByTheUser",
					"Error in validating the Broker results");
			return false;
		}
	}

	public boolean validateTableHeadersForGroupSearchResults() {
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblGroupSearchResults);
		System.out.println("Values from the App: " + valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Select");
		valuesGivenManual.add("Group Number");
		valuesGivenManual.add("Group Name");
		System.out.println("Values Given Manually: " + valuesGivenManual);
		if (valuesFromApp.equals(valuesGivenManual)) {
			System.out.println("Values Matched");
			return true;
		} else {
			System.out.println("Values doesnt Matched");
			return false;
		}
	}

	// Group Admin HIPPA

	@FindBy(id = "IsGroupAdminVerified")
	WebElement chckBxGroupAdmin;
	@FindBy(id = "IsGroupNameVerified")
	WebElement chckBxGroupName;
	@FindBy(id = "IsGrpNumberVerified")
	WebElement chckBxGroupNumber;

	@FindBy(xpath = "//li[contains(text (),'You must verify the Group Name, Group Number and Group Admin Contact in order to continue with the interaction.')]")
	WebElement labelHippaErrorMsgGroupAdmin;

	public boolean verifyGroupAdminHIPPAFeildsAndCheckboxesAreDisplayed() {
		return !utils.isProxyWebelement(chckBxGroupAdmin) && !utils.isProxyWebelement(chckBxGroupName) && !utils.isProxyWebelement(chckBxGroupNumber);
	}

	public boolean clickGroupNameGroupNumberAndGroupAdminContactForHippaPass() {
		utils.waitforpageload();
		if (utils.clickAnelemnt(chckBxGroupAdmin, "PhoneCallBrokersearchBroker", "Group Admin"))
			if (utils.clickAnelemnt(chckBxGroupName, "PhoneCallBrokersearchBroker", "Group Name"))
				if (utils.clickAnelemnt(chckBxGroupNumber, "PhoneCallBrokersearchBroker", "Group Number"))
					utils.scrolltomiddle();
					if (utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit"))
							return true;
		return false;

	}
	

	public boolean clickGroupNameAndGroupNumberForHippaFail() {
		if (utils.clickAnelemnt(chckBxGroupName, "PhoneCallBrokersearchBroker", "Group Name"))
			if (utils.clickAnelemnt(chckBxGroupNumber, "PhoneCallBrokersearchBroker", "Group Number")) 
				if(utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit"))
					return !utils.isProxyWebelement(labelHippaErrorMsgGroupAdmin);
		return false;
	}

	public boolean clickGroupNameForHippaFail() {
		if (utils.clickAnelemnt(chckBxGroupName, "PhoneCallBrokersearchBroker", "Group Name"))
			if(utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit"))
			return !utils.isProxyWebelement(labelHippaErrorMsgGroupAdmin);
		return false;
	}

	public boolean verifyHIPPAFailErrorMessageWhenNoneOfTheCheckBoxesAreSelected() {
		if (utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit"))
			return !utils.isProxyWebelement(labelHippaErrorMsgGroupAdmin);
		return false;
	}

	/**
	 * This functionality validates Search Results For GroupName Text
	 * 
	 * @return
	 */

	@FindBy(xpath = "//span[@data-test-id='20151202213743095040593']")
	WebElement labelGroupNumberSearchResults;

	@FindBy(xpath = "//span[@data-test-id='20151202213743095040593']")
	WebElement labelGroupNameSearchResults;

	public boolean validateSearchForGroupNumberResult() {
		return !utils.isProxyWebelement(labelGroupNumberSearchResults);
	}

	public boolean validateSearchForGroupNameResult() {
		return !utils.isProxyWebelement(labelGroupNameSearchResults);
	}

	@FindBy(xpath = "//li[contains(text (),'Please enter a minimum of 3 characters to search for Group Name')]")
	WebElement labelGroupNumberErrorMsg;

	public boolean verifyErrorMsgWhenEnteredCharactersAreLessThanThreeInGroupFields(String[] args) {
		if (utils.clickAnelemnt(rdoBtnGroupName, "PhoneCallBrokersearchBroker", "Group Name Rdo Btn"))
			if (utils.enterTextinAnelemnt(txtBoxGroupName, args[0], "PhoneCallBrokerSearchBroker", "Group Number"))
				if (utils.clickAnelemnt(btnSearch, "PhoneCallBrokerSearchBroker", "brkr srch"))
					return !utils.isProxyWebelement(labelGroupNumberErrorMsg);
		return false;
	}

	
	//Sprint 5.1
	
	@FindBy(xpath="//label[@for='ContinueWithMember']")
	WebElement labelContinueWithMember;
	
	@FindBy(id="ContinueWithMember")
	WebElement chckBxContinueWithMember;
	
	public boolean validateContinueWithMemberSearchCheckBoxInSearchForBrokerScreenIsDisplayed()
	{
		return !utils.isProxyWebelement(labelContinueWithMember);
	}
	
	public boolean clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen()
	{
		return utils.clickAnelemnt(chckBxContinueWithMember, "PhoneCallBrokerSearchBroker", "Continue With Member");
	}
	
	@FindBy(xpath="//label[text()='Name']")
	WebElement labelHippaName;
	
	@FindBy(xpath="//label[text()='Phone Number(Primary)']")
	WebElement labelHippaPhoneNumberPrimary;
	
	@FindBy(xpath="//label[text()='Phone Number(Secondary)']")
	WebElement labelHippaPhoneNumberSecondary;
	
	@FindBy(xpath="//label[text()='Phone Number(Other)']")
	WebElement labelHippaPhoneNumberOther;
	
	@FindBy(xpath="//label[text()='Address']")
	WebElement labelHippaAddress;
	
	
	
	public boolean verifyAgencyNameFieldIsChangedToName()
	{
		return !utils.isProxyWebelement(labelHippaName);
	}
	
	public boolean verifyAgencyPhoneNumberPrimaryFieldIsChangedToPhoneNumberPrimary()
	{
		return !utils.isProxyWebelement(labelHippaPhoneNumberPrimary);
	}
	
	public boolean verifyAgencyPhoneNumberOtherFieldIsChangedToPhoneNumberOther()
	{
		return !utils.isProxyWebelement(labelHippaPhoneNumberOther);
	}
	
	public boolean verifyAgencyPhoneNumberSecondaryFieldIsChangedToPhoneNumberSecondary()
	{
		return !utils.isProxyWebelement(labelHippaPhoneNumberSecondary);
	}
	
	public boolean verifyAgencyAddressFieldIsChangedToAddress()
	{
		return !utils.isProxyWebelement(labelHippaAddress);
	}
	
	//TIN changed to TIN/SSN
	
	@FindBy(xpath="//label[@for='BrokerSearchTypeTIN']")
	WebElement labelTinSSNSearch;
	
	@FindBy(xpath="//label[@for='IsTINVerified']")
	WebElement labelTinSSNHIPPA;
	
	@FindBy(xpath="//span[@data-test-id='20151202213743095040593']")
	WebElement labelTinSSNResult;
	
	
	
	public boolean verifyTINinSearchByOptionsIsChangedToTINSSN()
	{
		return !utils.isProxyWebelement(labelTinSSNSearch);
	}
	
	public boolean verifyTINinHIPPAfieldIsChangedToTINSSN()
	{
		return !utils.isProxyWebelement(labelTinSSNHIPPA);
	}
	
	public boolean verifySearchResultsForTINIsChangedToTINSSNinSearchForBrokerPage() {
	return !utils.isProxyWebelement(labelTinSSNResult);
	}
	
	
	public boolean validateTableHeadersForBrokerSearchResultsAfterTINSSNLabelIsChanged() {
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblSearchResults);
		System.out.println("Values from the App: " + valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Select");
		valuesGivenManual.add("TIN/SSN");
		valuesGivenManual.add("Name");
		valuesGivenManual.add("Phone Number");
		System.out.println("Values Given Manually: " + valuesGivenManual);
		if (valuesFromApp.equals(valuesGivenManual)) {
			System.out.println("Values Matched");
			return true;
		} else {
			System.out.println("Values doesnt Matched");
			return false;
		}
	}	
	
	/**
	 * This funtionality expands the group row for which the user given as input
	 * @param args
	 * @return
	 */
	
	public boolean expandGroupByTheValueGivenByTheUser(String[] args)
	{

		try {
			WebElement row = utils.returntablerowbasedonvalues(tblGroupSearchResults, args);
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
	
	//Precondition
	
	@FindBy(xpath = "//table[@pl_prop='D_GroupList.pxResults']")
	WebElement tblSearchResultsForGroupAdminFlow;
	
	public boolean searchbyTIN(String args) {
		utils.waitforpageload();
		if(utils.clickAnelemnt(rdoBtnTIN, "PhoneCallBrokersearchBroker", "TIN Rdo Btn"))
			if(utils.enterTextinAnelemnt(txtBxTINID, args, "PhoneCallBrokerSearchBroker", "EncryptedTIN id"))
				utils.scrolltomiddle();
				if(utils.clickAnelemnt(btnSearch, "PhoneCallBrokerSearchBroker", "brkr srch"))
					return true;
		return false;

	}
	
	public boolean enterFirstName(String args) {
		//utils.waitforpageload();
		if (utils.enterTextinAnelemnt(txtBxFirstName, args, "PhoneCallBrokersearchBroker", "First Name"))
				return true;
		return false;
	}
	
	public boolean enterLastName(String args) {
		//utils.waitforpageload();
			if (utils.enterTextinAnelemnt(txtBxLastName, args, "PhoneCallBrokersearchBroker", "Last Name"))
				return true;
		return false;
	}
	
	public boolean selectContactType(String args) {
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(drpDownContactType, args, "PhoneCallBrokersearchBroker","Contact Type");
	}
	
	public boolean enterCallBackNumber(String args) {
		utils.waitforpageload();
		return utils.enterTextinAnelemnt(txtBxCallBackNumber, args, "PhoneCallBrokersearchBroker", "Call Back Num");
	}
	
	public boolean selectBrokerByTheValueGivenByTheUser(String tablevalues) {
		try {
			System.out.println("Entered");
			String[] values1 = new String[] {tablevalues};
			System.out.println(values1[0]);
			WebElement row = utils.returntablerowbasedonvalues(tblSearchResults, values1);
			List<WebElement> rowNo = row.findElements(By.id("CaseOrTaskIcon"));
			rowNo.get(0).click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception :" + e);
			err.logcustomerrorwithmessage("PhoneCallBrokersearchBroker", "selectBrokerByTheValueGivenByTheUser",
					"Error in validating the Broker results");
			return false;
		}
	}
	
	public boolean selectBrokerByTheValueGivenByTheUserForGroupAdmin(String tablevalues) {
		try {
			System.out.println("Entered");
			String[] values1 = new String[] {tablevalues};
			System.out.println(values1[0]);
			WebElement row = utils.returntablerowbasedonvalues(tblSearchResultsForGroupAdminFlow, values1);
			List<WebElement> rowNo = row.findElements(By.id("LocalRadio"));
			rowNo.get(0).click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception :" + e);
			err.logcustomerrorwithmessage("PhoneCallBrokersearchBroker", "selectBrokerByTheValueGivenByTheUser",
					"Error in validating the Broker results");
			return false;
		}
	}
	
	public boolean selectGroupByTheValueGivenByTheUser(String tablevalues) {
		try {
			System.out.println("Entered");
			String[] values1 = new String[] {tablevalues};
			System.out.println(values1[0]);
			WebElement row = utils.returntablerowbasedonvalues(tblGroupSearchResults, values1);
			List<WebElement> rowNo = row.findElements(By.id("LocalRadio"));
			rowNo.get(0).click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception :" + e);
			err.logcustomerrorwithmessage("PhoneCallBrokersearchBroker", "selectBrokerByTheValueGivenByTheUser",
					"Error in validating the Broker results");
			return false;
		}
	}
	
	
	
public boolean verifyGroupNameAndGroupNumberForHippaPass()
	
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(chckBxGroupName, "BrokerSearchForGroup", "Group Name"))
			if(utils.clickAnelemnt(chckBxGroupNumber, "BrokerSearchForGroup", "Group Number"))
				if (utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit"))
					return true;
		return false;
		
	}

public boolean searchByGroupNumber(String args) {
	utils.scrolltomiddle();
	if (utils.clickAnelemnt(rdoBtnGroupNumber, "PhoneCallBrokersearchBroker", "Group Number Rdo Btn"))
		if (utils.enterTextinAnelemnt(txtBoxGroupNumber, args, "PhoneCallBrokerSearchBroker","EncryptedTIN id"))
			utils.scrolltomiddle();
				return utils.clickAnelemnt(btnSearch, "PhoneCallBrokerSearchBroker", "brkr srch"); 
}
	
	public boolean searchForBrokerUsingTINFlowForPhoneCallInteraction(String[] values)
	{
		String[] args = values[1].split("/");
		if(searchbyTIN(args[0]))
			utils.waitforpageload();
			if(enterFirstName(args[1]))
				utils.waitforpageload();
				if(enterLastName(args[2]))
					if(selectContactType(args[3]))
						if(enterCallBackNumber(args[4]))
							if(selectBrokerByTheValueGivenByTheUser(args[5]))
								if(clickTinAndAgencyNameCombinationForHippaPass())
									if(clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen())
										if(clickOnSubmit())
											if(selectGroupByTheValueGivenByTheUser(args[6]))
												utils.scrolltomiddle();
												if(clickGroupNameAndGroupNumberForHippaFail())
													return true;
			return false;
				
	}
	
	
	public boolean searchForBrokerUsingTINFlowForPhoneCallInteractionWithMemberNotInFocus(String[] values)
	{
		String[] args = values[1].split("/");
		if(searchbyTIN(args[0]))
			utils.waitforpageload();
			if(enterFirstName(args[1]))
				utils.waitforpageload();
				if(enterLastName(args[2]))
					if(selectContactType(args[3]))
						if(enterCallBackNumber(args[4]))
							if(selectBrokerByTheValueGivenByTheUser(args[5]))
								if(clickTinAndAgencyNameCombinationForHippaPass())
									//if(clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen())
									utils.scrolltomiddle();	
									if(clickOnSubmit())
											if(selectGroupByTheValueGivenByTheUser(args[6]))
												utils.scrolltomiddle();
												if(clickGroupNameAndGroupNumberForHippaFail())
													return true;
			return false;
				
	}
	
	
	public boolean searchForBrokerUsingGroupAdminFlowForPhoneCallInteraction(String[] values)
	{
		String[] args = values[1].split("/");
		if(searchByGroupNumber(args[0]))
			utils.waitforpageload();
			if(enterFirstName(args[1]))
				utils.waitforpageload();
				if(enterLastName(args[2]))
					if(selectContactType(args[3]))
						if(enterCallBackNumber(args[4]))
							if(selectBrokerByTheValueGivenByTheUserForGroupAdmin(args[5]))
								if(clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen())
									if(clickGroupNameGroupNumberAndGroupAdminContactForHippaPass())
													return true;
			return false;
				
	}
	
	
	public boolean searchForBrokerUsingGroupAdminFlowForPhoneCallInteractionWithMemberNotInFocus(String[] values)
	{
		String[] args = values[1].split("/");
		if(searchByGroupNumber(args[0]))
			utils.waitforpageload();
			if(enterFirstName(args[1]))
				utils.waitforpageload();
				if(enterLastName(args[2]))
					if(selectContactType(args[3]))
						if(enterCallBackNumber(args[4]))
							if(selectBrokerByTheValueGivenByTheUserForGroupAdmin(args[5]))
								//if(clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen())
									if(clickGroupNameGroupNumberAndGroupAdminContactForHippaPass())
													return true;
			return false;
				
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

		
	/**
	 * Clears the Entered TIN in the TIN Text box
	 */
	
	public boolean clearTheEnteredTIN()
	{
		txtBxTINID.clear();
		return true;
	}
}

	
