package automationLib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerEmailInteraction {

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err = new ErrorLogger();

	SeleniumUtilities utils = new SeleniumUtilities();

	public BrokerEmailInteraction() {

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	//Sprint 6.3

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;


	@FindBy(id="BrokerContactType")
	WebElement drpDownContactTypeEmailBroker;

	@FindBy(id="FullName")
	WebElement txtBxContactName;


	@FindBy(id="ContactEmailID")
	WebElement txtBxEmailAddressEmailBroker;

	@FindBy(id="CorrespondenceReceiveDate")
	WebElement txtBxCorrespondenceDateBroker;


	/**
	 * Enter the Mandatory field contract type in email interaction for broker page  .
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectContactTypeForEmailInteraction(String[] args) throws InterruptedException {
		return utils.selectDropDownbyVisibleString(drpDownContactTypeEmailBroker, args[0], "Broker_EmailInteraction","Contact Type");
	}

	/**
	 * Enter the Mandatory field  contract name in email interaction for broker page
	 * @param args
	 * @return
	 */

	public boolean enterContactNameForBrokerEmailInteraction(String[] args) {

		return (utils.enterTextinAnelemnt(txtBxContactName, args[0], "BrokerEmailInteraction", "Contact Name"));
	}

	/**
	 * 	 Enter the Mandatory field correspondence date in email interaction for broker page
	 * @param args
	 * @return
	 */

	public boolean enterCorrespondenceReceivedDateForEmailInteraction(String[] args) {

		return (utils.enterTextinAnelemnt(txtBxCorrespondenceDateBroker, args[0], "Broker_EmailInteraction", "First Name"));
	}
	/**
	 *  Enter the Mandatory field Email address  in email interaction for broker page
	 * @param args
	 * @return
	 */


	public boolean enterEmailAddressForEmailInteraction(String[] args) {
		return utils.enterTextinAnelemnt(txtBxEmailAddressEmailBroker, args[0], "Broker_EmailInteraction", "Email ID");
	}




	@FindBy(xpath = "//div[@id='$PpyWorkPage$pFullNameError']//span")
	WebElement imgContactNameError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pContactEmailIDError']//span")
	WebElement imgEmailIdError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pSearchStringTINError']//span")
	WebElement imgTinError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pBrokerContactTypeError']//span")
	WebElement imgContactTypeError;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pCorrespondenceReceiveDateError']//span")
	WebElement imgCorrespondenceDate;

	@FindBy(xpath = "//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	/**
	 * Clicks the Submit button and accepts the alert when no field values are entered
	 * @return
	 */
	public boolean clickOnSubmitWithAlert() {
		utils.scrolltomiddle();
		utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit");
		Driver.pgDriver.switchTo().alert().accept();
		return true;
	}


	/**
	 * Validate that flag is raised for each mandatory fields if it is unfilled.
	 * @return
	 */


	public boolean verifyFlagPointingToAllMandatoryFeilds() {
		try {

			return !utils.isProxyWebelement(imgTinError) && !utils.isProxyWebelement(imgEmailIdError)
					&& !utils.isProxyWebelement(imgContactNameError) && !utils.isProxyWebelement(imgContactTypeError)
					&& !utils.isProxyWebelement(imgContactTypeError);

		} catch (Exception e) {
			err.logcustomerrorwithmessage("Broker_EmailInteraction", "verifyFlagPointingToAllMandatoryFeilds",
					"Error Flag is not displayed");
			return false;
		}
	}
	/**
	 * Validate that flag is raised for each mandatory field Email Address
	 * @return
	 */

	public boolean validateEmailIDCriteria() {
		try {
			return !utils.isProxyWebelement(imgEmailIdError);

		} catch (Exception e) {
			err.logcustomerrorwithmessage("Broker_EmailInteraction", "verifyFlagPointingToEmailAddressFeild",
					"Error Flag is not displayed at EmailAddress feild");
			return false;
		}
	}

	@FindBy(id="BrokerSearchTypeTIN")
	WebElement rdoBtnTINAndSSNSearch;


	@FindBy(id="BrokerSearchTypeGROUPID")
	WebElement rdoBtnGroupNumber;


	@FindBy(id="BrokerSearchTypeGROUPNAME")
	WebElement rdoBtnGroupName;

	@FindBy(id="BrokerSearchTypeAGENCYNAME")
	WebElement rdoBtnAgencyName;

	@FindBy(id="BrokerSearchTypeAGENTID")
	WebElement rdoBtnAgencyID;

	@FindBy(xpath="//label[@data-test-id='20170522190915049723982-Label']//span[text()='TIN/SSN']")
	WebElement labelTINAndSSNSearch;


	@FindBy(xpath="//label[@data-test-id='20170522190915049723982-Label']//span[text()='Group Number']")
	WebElement labelGroupNumber;


	@FindBy(xpath="//label[@data-test-id='20170522190915049723982-Label']//span[text()='Group Name']")
	WebElement labelGroupName;

	@FindBy(xpath="//label[@data-test-id='20170522190915049723982-Label']//span[text()='Agency Name']")
	WebElement labelAgencyName;

	@FindBy(xpath="//label[@data-test-id='20180619141946079670668-Label']//span[text()='Agent ID']")
	WebElement labelAgencyID;

	@FindBy(id="KnownBrokerRelationship")
	WebElement chckBxSkipHippaVerification;

	@FindBy(id="IsNameVerified")
	WebElement chckBxHIPPAName;

	@FindBy(id="IsTINVerified")
	WebElement chckBxTINVerified;

	@FindBy(id="IsBusinessPhoneVerified")
	WebElement chckBxPhoneNumberPrimary;

	@FindBy(id="IsHomePhoneVerified")
	WebElement chckBxPhoneNumberSecondary;

	@FindBy(id="IsOtherPhoneVerified")
	WebElement chckBxPhoneNumberOther;

	@FindBy(id="IsAddressVerified")
	WebElement chckBxAddress;

	/**
	 * Validates all the available Search by options are present
	 * @return
	 */
	public boolean validateSearchByOptions()
	{
		return !utils.isProxyWebelement(rdoBtnTINAndSSNSearch) && !utils.isProxyWebelement(rdoBtnGroupNumber) && !utils.isProxyWebelement(rdoBtnGroupName) && !utils.isProxyWebelement(rdoBtnAgencyName) && !utils.isProxyWebelement(rdoBtnAgencyID);
	}

	/**
	 * Validates the TIN SSN Label present in Email Interaction Page
	 * @return
	 */
	public boolean validateTINSSNLabel()
	{
		if(utils.clickAnelemnt(rdoBtnTINAndSSNSearch, "BrokerEmailInteraction", "TIN / SSN search"))
			if(!utils.isProxyWebelement(labelTINAndSSNSearch))
				return true;
		return  false;
	}

	/**
	 * Validates the Group Name Label present in the Email Interaction page
	 * @return
	 */
	public boolean validateGroupNameLabel()
	{
		if(utils.clickAnelemnt(rdoBtnGroupName, "BrokerEmailInteraction", "Group Name"))
			if(!utils.isProxyWebelement(labelGroupName))
				return true;

		return false;
	}

	/**
	 * Validates the Group Number label present in the Email Interaction page
	 * @return
	 */
	public boolean validateGroupNumberLabel()
	{
		if(utils.clickAnelemnt(rdoBtnGroupNumber, "BrokerEmailInteraction", "Group Number"))
			if(!utils.isProxyWebelement(labelGroupNumber))
				return true;
		return  false;
	}

	/**
	 * Validates the Agency Label present in the Email Interaction page
	 * @return
	 */
	public boolean validateAgencyNameLabel()
	{
		if(utils.clickAnelemnt(rdoBtnAgencyName, "BrokerEmailInteraction", "Agency Name"))
			if(!utils.isProxyWebelement(labelAgencyName))
				return true;
		return  false;
	}

	/**
	 * Validates the Agent ID label present in the Email Interaction page
	 * @return
	 */
	public boolean validateAgentIDLabel()
	{
		if(utils.clickAnelemnt(rdoBtnAgencyID, "BrokerEmailInteraction", "Agency Number"))
			if(!utils.isProxyWebelement(labelAgencyID))
				return true;
		return  false;
	}

	/**
	 * Verifies Skip HIPPA check box is present in the Email Interaction page
	 * @return
	 */
	public boolean verifySkipHIPPAVerificationForTheKnownBrokerRelationshipCheckboxIsPresent()
	{
		return !utils.isProxyWebelement(chckBxSkipHippaVerification);
	}

	/**
	 * Verifies Skip HIPPA check box is not present in the Email Interaction page
	 * @return
	 */
	public boolean verifySkipHIPPAVerificationForTheKnownBrokerRelationshipCheckboxIsNotPresent()
	{
		return utils.isProxyWebelement(chckBxSkipHippaVerification);
	}


	/**
	 * Clicks Skip HIPPA check box in the Email Interaction page
	 * @return
	 */
	public boolean clickSkipHIPPAVerificationForTheKnownBrokerRelationshipCheckbox()
	{
		return utils.clickAnelemnt(chckBxSkipHippaVerification, "BrokerEmailInteraction", "Skipp HIPPA check box");
	}

	/**
	 * Verifies All HIPPA field check boxes are disabled
	 * @return
	 */
	public boolean verifyAllHIPPAFieldsCheckBoxesAreDisabled()
	{
		return !utils.isProxyWebelement(chckBxHIPPAName) && !utils.isProxyWebelement(chckBxTINVerified) && !utils.isProxyWebelement(chckBxPhoneNumberPrimary) && !utils.isProxyWebelement(chckBxPhoneNumberSecondary) && !utils.isProxyWebelement(chckBxPhoneNumberOther) && !utils.isProxyWebelement(chckBxAddress);
	}

	/**
	 * Clicks on submit button in the Email Interaction page
	 * @return
	 */
	public boolean clickOnSubmittButton() {
		return utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit");
	}

	@FindBy(xpath="//button[@data-test-id='2018082914403802395440']//img[2]")
	WebElement btnAttachment;


	@FindBy(name="$PpyAttachmentPage$ppxAttachName")
	WebElement iconAttachFiles;



	public boolean clickOnAccessAttachmentsIcon()
	{
		return utils.clickAnelemnt(btnAttachment, "PhoneCallBrokersearchBroker", "Attach Icon");
	}


	public boolean clickOnSelectFilesButtonAndAttachPDFDOCDOCXXLSRTFFile() throws Exception
	{
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("No.ofwindows"+handles.size());
		Iterator<String> iterator= handles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		Driver.pgDriver.switchTo().window(childWindow);
		String title = Driver.pgDriver.getTitle();
		System.out.println("Title of the Child Window is: "+title);
		if(title.contains("Broker Email Interaction -"))
		{
			System.out.println("Broker Attach Page is launched and the title is: "+ title); 
			if(utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File"))
				if(addPDFFile())
					if(utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File"))
						if(addDOCFile())
							if(utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File"))
								if(addDOCXFile())
									if(utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File"))
										if(addXLSFile())
											if(utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File"))
												if(addRFTFile())
													if(clickOnAttachButton()) {
														Thread.sleep(3000);
														utils.scrolltomiddle();
														return verifySuccessfulDocumentUploadedMessageIsDisplayed();
													}
			return false;
		}else
		{
			err.logcommonMethodError("PhoneCallBrokersearchBroker", "Error in switching to childwindow-WMDS");
			return false;
		}
	}


	public boolean clickOnSelectFilesButtonAndAttachXLSXTXTTIFTIFFMSGFile() throws Exception
	{
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("No.ofwindows"+handles.size());
		Iterator<String> iterator= handles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		Driver.pgDriver.switchTo().window(childWindow);
		String title = Driver.pgDriver.getTitle();
		System.out.println("Title of the Child Window is: "+title);
		if(title.contains("Broker Email Interaction -"))
		{
			System.out.println("Broker Attach Page is launched and the title is: "+ title); 
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addXLSXFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addTXTFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addTIFFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addMSGFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addTIFFFile();
			clickOnAttachButton();
			Thread.sleep(3000);
			utils.scrolltomiddle();
			verifySuccessfulDocumentUploadedMessageIsDisplayed();
			return true;
		}else
		{
			err.logcommonMethodError("PhoneCallBrokersearchBroker", "Error in switching to childwindow-WMDS");
			return false;
		}
	}


	public boolean clickOnSelectFilesButtonAndAttachMoreThanFiveFile() throws Exception
	{
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("No.ofwindows"+handles.size());
		Iterator<String> iterator= handles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		Driver.pgDriver.switchTo().window(childWindow);
		String title = Driver.pgDriver.getTitle();
		System.out.println("Title of the Child Window is: "+title);
		if(title.contains("Broker Email Interaction -"))
		{
			System.out.println("Broker Attach Page is launched and the title is: "+ title); 
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addXLSXFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addPNGFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addTIFFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addMSGFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addXLSFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addXLSXFile();
			clickOnAttachButton();
			Thread.sleep(3000);
			utils.scrolltomiddle();
			verifyErrorMessageIsDisplayed();
			return true;
		}else
		{
			err.logcommonMethodError("PhoneCallBrokersearchBroker", "Error in switching to childwindow-WMDS");
			return false;
		}
	}


	public boolean clickOnSelectFilesButtonAndAttachPNGJPGFile() throws Exception
	{
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("No.ofwindows"+handles.size());
		Iterator<String> iterator= handles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		Driver.pgDriver.switchTo().window(childWindow);
		String title = Driver.pgDriver.getTitle();
		System.out.println("Title of the Child Window is: "+title);
		if(title.contains("Broker Email Interaction -"))
		{
			System.out.println("Broker Attach Page is launched and the title is: "+ title); 
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addPNGFile();
			utils.clickAnelemnt(iconAttachFiles, "PhoneCallBrokersearchBroker", "Select File");
			addJPGFile();
			clickOnAttachButton();
			Thread.sleep(3000);
			utils.scrolltomiddle();
			verifySuccessfulDocumentUploadedMessageIsDisplayed();
			return true;
		}else
		{
			err.logcommonMethodError("PhoneCallBrokersearchBroker", "Error in switching to childwindow-WMDS");
			return false;
		}
	}


	public boolean addPDFFile() throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\PDFFile.pdf";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean addDOCXFile() throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\DOCXFile.docx";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}



	public boolean addMSGFile() throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\MSGFile.msg";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


	public boolean addDOCFile() throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\DOCFile.doc";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


	public boolean addXLSFile() throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\XLSFile.xls";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean addXLSXFile() throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\XLSXFile.xlsx";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean addTXTFile() throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\TXTFile.txt";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	public boolean addRFTFile(/*String[] filename*/) throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\RFTFile.rtf";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean addJPGFile(/*String[] filename*/) throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\JPGFile.jpg";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	public boolean addTIFFile(/*String[] filename*/) throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\TIFFile.tif";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	public boolean addTIFFFile(/*String[] filename*/) throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\TIFFFile.tiff";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	public boolean addPNGFile(/*String[] filename*/) throws Exception {
		try {
			String fileName = "C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\PNGFile.png";
			String autoITExecutable ="C:\\Users\\AF56975\\Documents\\Sprint6.4Reports\\Falcons\\FileUploadNew.exe " + fileName;
			Runtime.getRuntime().exec(autoITExecutable);
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	@FindBy(xpath="//div[contains(text(),'Attach')]")
	WebElement btnAttach;

	@FindBy(xpath="//div[@data-test-id='201808020544000403781488']")
	WebElement labelSuccessMsg;

	@FindBy(id="PegaRULESErrorFlag")
	WebElement labelErrorMsg;

	@FindBy(xpath="//div[contains(text(),'Close')]")
	WebElement btnClose;

	public boolean clickOnAttachButton()
	{
		return utils.clickAnelemnt(btnAttach, "PhoneCallBrokersearchBroker", "Attach");
	}

	public boolean verifySuccessfulDocumentUploadedMessageIsDisplayed()
	{
		return utils.validateLabel(labelSuccessMsg, "Document(s) attached and uploaded to FileNet Successfully");
	}

	public boolean verifyErrorMessageIsDisplayed()
	{
		return utils.validateLabel(labelErrorMsg, "Only 5 files at a time will be allowed to attach and upload to FileNet");
	}

	public boolean clickOnCloseButton()
	{
		return utils.clickAnelemnt(btnClose, "PhoneCallBrokersearchBroker", "Close");
	}

	//@FindBy(xpath = "//table[@pl_prop='D_GroupList.pxResults']")
	@FindBy(xpath="//table[@pl_prop='.clientSearch']")
	WebElement tblGroupSearchResults;
	
	
	/**
	 * This functionality expands the group row for which the user given as input
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
	
	//--> Pre Condition 
	
	@FindBy(id="SearchStringTIN")
	WebElement txtBxTINAndSSN;
	
	@FindBy(xpath="//button[@data-test-id='2015082811210004244498']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//table[@pl_prop='D_BrokerDetails.pxResults']")
	WebElement tblSearchResults;
	
	@FindBy(id = "IsNameVerified")
	WebElement chckBxAgencyName;

	@FindBy(id = "IsTINVerified")
	WebElement chckBxAgencyTIN;
	
	@FindBy(id="ContinueWithMember")
	WebElement chckBxContinueWithMember;
	
	@FindBy(id="IsGroupNameVerified")
	WebElement chbxGroupName;

	@FindBy(id="IsGrpNumberVerified")
	WebElement chbxGroupNumber; 
	
	@FindBy(id = "SearchGroupID")
	WebElement txtBoxGroupNumber;

	
	public boolean clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen()
	{
		return utils.clickAnelemnt(chckBxContinueWithMember, "PhoneCallBrokerSearchBroker", "Continue With Member");
	}
	
	
	public boolean searchbyTIN(String args) {
		utils.waitforpageload();
		if(utils.clickAnelemnt(rdoBtnTINAndSSNSearch, "PhoneCallBrokersearchBroker", "TIN Rdo Btn"))
			if(utils.enterTextinAnelemnt(txtBxTINAndSSN, args, "PhoneCallBrokerSearchBroker", "EncryptedTIN id"))
				if(utils.clickAnelemnt(btnSearch, "PhoneCallBrokerSearchBroker", "brkr srch"))
					return true;
		return false;

	}
	
	
	public boolean clickTinAndAgencyNameCombinationForHippaPass() {
		if (utils.clickAnelemnt(chckBxAgencyTIN, "PhoneCallBrokersearchBroker", "TIN"))
			if (utils.clickAnelemnt(chckBxAgencyName, "PhoneCallBrokersearchBroker", "Agency Name"))
				return true;
		return false;
	}
	
	
	public boolean selectContactTypeForEmailInteraction(String args) throws InterruptedException {
		return utils.selectDropDownbyVisibleString(drpDownContactTypeEmailBroker, args, "Broker_EmailInteraction","Contact Type");
	}


	public boolean enterContactNameForBrokerEmailInteraction(String args) {

		return (utils.enterTextinAnelemnt(txtBxContactName, args, "BrokerEmailInteraction", "Contact Name"));
	}


	public boolean enterCorrespondenceReceivedDateForEmailInteraction(String args) {

		return (utils.enterTextinAnelemnt(txtBxCorrespondenceDateBroker, args, "Broker_EmailInteraction", "First Name"));
	}


	public boolean enterEmailAddressForEmailInteraction(String args) {
		return utils.enterTextinAnelemnt(txtBxEmailAddressEmailBroker, args, "Broker_EmailInteraction", "Email ID");
	}
	
	public boolean clickOnSubmit() {
		utils.scrolltomiddle();
		return utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit");
	}
	
	public boolean verifyGroupNameAndGroupNumberForHippaPass()
	
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(chbxGroupName, "BrokerSearchForGroup", "TIN"))
			if(utils.clickAnelemnt(chbxGroupNumber, "BrokerSearchForGroup", "Agency Name"))
				if (utils.clickAnelemnt(btnSubmit, "PhoneCallBrokersearchBroker", "Submit"))
					return true;
		return false;
		
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
	
	
	@FindBy(xpath = "//table[@pl_prop='D_GroupList.pxResults']")
	WebElement tblSearchResultsForGroupAdminFlow;
	
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
	
	
	
	public boolean searchByGroupNumber(String args) {
		if (utils.clickAnelemnt(rdoBtnGroupNumber, "PhoneCallBrokersearchBroker", "Group Number Rdo Btn"))
			if (utils.enterTextinAnelemnt(txtBoxGroupNumber, args, "PhoneCallBrokerSearchBroker","EncryptedTIN id"))
				return utils.clickAnelemnt(btnSearch, "PhoneCallBrokerSearchBroker", "brkr srch"); 
		return false;
	}
	
	
	@FindBy(id = "IsGroupAdminVerified")
	WebElement chckBxGroupAdmin;
	@FindBy(id = "IsGroupNameVerified")
	WebElement chckBxGroupName;
	@FindBy(id = "IsGrpNumberVerified")
	WebElement chckBxGroupNumber;
	
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


	public boolean searchForBrokerUsingTINFlowForEmailInteraction(String[] values) throws InterruptedException
	{
		String[] args = values[1].split("%");
		if(searchbyTIN(args[0]))
			utils.waitforpageload();
			if(enterContactNameForBrokerEmailInteraction(args[1]))
				utils.waitforpageload();
				if(enterCorrespondenceReceivedDateForEmailInteraction(args[2]))
					if(enterEmailAddressForEmailInteraction(args[3]))
						if(selectContactTypeForEmailInteraction(args[4]))
							if(selectBrokerByTheValueGivenByTheUser(args[5]))
								if(clickTinAndAgencyNameCombinationForHippaPass())
									if(clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen())
										if(clickOnSubmit())
											if(selectGroupByTheValueGivenByTheUser(args[6]))
												utils.scrolltomiddle();
												if(verifyGroupNameAndGroupNumberForHippaPass())
													return true;
			return false;
				
	}
	
	
	
	public boolean searchForBrokerUsingTINFlowForEmailInteractionWithMemberNotInFocus(String[] values) throws InterruptedException
	{
		String[] args = values[1].split("%");
		if(searchbyTIN(args[0]))
			utils.waitforpageload();
			if(enterContactNameForBrokerEmailInteraction(args[1]))
				utils.waitforpageload();
				if(enterCorrespondenceReceivedDateForEmailInteraction(args[2]))
					if(enterEmailAddressForEmailInteraction(args[3]))
						if(selectContactTypeForEmailInteraction(args[4]))
							if(selectBrokerByTheValueGivenByTheUser(args[5]))
								if(clickTinAndAgencyNameCombinationForHippaPass())
									//if(clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen())
										if(clickOnSubmit())
											if(selectGroupByTheValueGivenByTheUser(args[6]))
												utils.scrolltomiddle();
												if(verifyGroupNameAndGroupNumberForHippaPass())
													return true;
			return false;
				
	}
	
	
	public boolean searchForBrokerUsingGroupAdminFlowForEmailInteraction(String[] values) throws InterruptedException
	{
		String[] args = values[1].split("%");
		if(searchByGroupNumber(args[0]))
			utils.waitforpageload();
			if(enterContactNameForBrokerEmailInteraction(args[1]))
				utils.waitforpageload();
				if(enterCorrespondenceReceivedDateForEmailInteraction(args[2]))
					if(enterEmailAddressForEmailInteraction(args[3]))
						if(selectContactTypeForEmailInteraction(args[4]))
							if(selectBrokerByTheValueGivenByTheUserForGroupAdmin(args[5]))
									if(clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen())
										if(clickGroupNameGroupNumberAndGroupAdminContactForHippaPass())
													return true;
			return false;
				
	}
	
	
	public boolean searchForBrokerUsingGroupAdminFlowForEmailInteractionWithMemberNotInFocus(String[] values) throws InterruptedException
	{
		String[] args = values[1].split("%");
		if(searchByGroupNumber(args[0]))
			utils.waitforpageload();
			if(enterContactNameForBrokerEmailInteraction(args[1]))
				utils.waitforpageload();
				if(enterCorrespondenceReceivedDateForEmailInteraction(args[2]))
					if(enterEmailAddressForEmailInteraction(args[3]))
						if(selectContactTypeForEmailInteraction(args[4]))
							if(selectBrokerByTheValueGivenByTheUserForGroupAdmin(args[5]))
									//if(clickContinueWithMemberSearchCheckBoxInSearchForBrokerScreen())
										if(clickGroupNameGroupNumberAndGroupAdminContactForHippaPass())
													return true;
			return false;
				
	}




}
