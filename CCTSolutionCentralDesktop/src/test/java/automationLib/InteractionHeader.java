package automationLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class InteractionHeader extends Driver {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	public static String getmemberID;

	

	public InteractionHeader() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
	}

	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(xpath = "//img[contains(@src, 'happyinteraction')]")
	WebElement imageInteractionHeaderSmiley;

	@FindBy(xpath = "//*[@data-test-id='201509171111100835311891']")
	WebElement labelInteractionHeaderfullname;

	@FindBy(xpath = "//*[@data-test-id='201509180929400234553780']")
	WebElement labelInteractionHeaderID;

	@FindBy(xpath = "//*[@data-test-id='201509171111100835312438']")
	WebElement labelInteractionHeaderAge;
	
	@FindBy(xpath = "//*[@data-test-id='201509101150000520548586']")
	WebElement labelInteractionHeaderFundingType;

	@FindBy(xpath = "//div[@node_name='CPMInteractionHeader']//a[text()='Disclosure Matrix']")
	WebElement lnktextInteractionHeaderDisclosureMatrixLink;

	@FindBy(className = "PrivacyAlertColor")
	WebElement lnktextInteractionHeaderPrivacyAlert;

	@FindBy(xpath = "//div[@node_name='CPMInteractionHeader'][text()='Unable to retrieve data. Please try again or contact your system administrator.']")
	WebElement labelInteractionHeaderunabletoretrieve;

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Refresh']")
	WebElement btnInteractionHeaderRefresh;

	@FindBy(xpath = "//div[@node_name='CPMInteractionHeader']//label[@for='MemberPhoneNumber']/parent::div//span")
	WebElement labelInteractionHeaderphone;

	@FindBy(xpath = "//*[@data-test-id='201509180925340197147539-Label']/../*[@class='field-item dataValueRead']")
	WebElement labelInteractionHeaderLastInteractionDate;

	@FindBy(id = "CallBackNumber")
	WebElement txtbxInteractionHeaderCallbackNumber;

	@FindBy(id = "Nickname")
	WebElement txtbxInteractionHeaderNickName;

	@FindBy(id = "CallBackNumExt")
	WebElement txtbxInteractionHeaderCallBackExtension;

	@FindBy(xpath = "//img[contains(@data-hover,'ActiveCIRSRecord')]")
	WebElement imgInteractionHeaderprivacyalerticon;

	@FindBy(xpath = "//div[@node_name='CPMInteractionHeader']//label[@for='pyID']/parent::div//span")
	WebElement getReviewInteractionID;

	public boolean verifyInteractionHeader(String[] iDetails) throws Exception {
		boolean returnvar;
		returnvar = true;

		wait = new WebDriverWait(Driver.pgDriver, 20);
		wait.until(ExpectedConditions.visibilityOf(this.labelInteractionHeaderfullname));
		for (String iterator : iDetails) {
			String keyvaluepair = iterator;
			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if (key.toLowerCase().contains("membername")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderfullname, value);
				continue;
			} else if (key.toLowerCase().contains("id")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderID, value);
				continue;
			}

			else if (key.toLowerCase().contains("age")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderAge, value);
				continue;
			} else if (key.toLowerCase().contains("lastinteraction")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderLastInteractionDate, value);

				continue;
			} else if (key.toLowerCase().contains("phone")) {
				returnvar = utils.isvalueMatch_contain(
						this.labelInteractionHeaderphone.getAttribute("value").toLowerCase(), value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("nickname")) {
				String text = this.txtbxInteractionHeaderNickName.getAttribute("value");
				returnvar = utils.isvalueMatch_contain(text.toLowerCase(), value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("callbacknumber")) {
				System.out.println(this.txtbxInteractionHeaderCallbackNumber.getAttribute("value"));
				returnvar = utils.isvalueMatch_contain(
						this.txtbxInteractionHeaderCallbackNumber.getAttribute("value").toLowerCase(),
						value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("callbackextension")) {
				returnvar = utils.isvalueMatch_contain(
						this.txtbxInteractionHeaderCallBackExtension.getAttribute("value").toLowerCase(),
						value.toLowerCase());
				continue;
			} else
				err.logcommonMethodError("Interaction Header",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if (returnvar) {
			System.out.println("Interaction Header Details checked successfully");
			return true;
		} else {
			int tot_i = iDetails.length;
			err.logcommonMethodError("Interaction Header",
					"the value " + iDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}
	}

	
	public static String getInteractionID;
	
	public static String getInteractionID() {
			
			return getInteractionID;
		
	}

	public String getMemberName() {
		if (this.labelInteractionHeaderfullname.isDisplayed()) {
			System.out.println("Member Info is checked");
		}
		String name = this.labelInteractionHeaderfullname.getText().trim();
		return name;
	}

	public String getUserName() {
		if (this.labelInteractionHeaderfullname.isDisplayed()) {
			System.out.println("Member Info is checked");
		}
		String name = this.labelInteractionHeaderfullname.getText().trim();
		return name;
	}

	@FindBy(xpath = "//*[@data-test-id='20150113070710091218785']")
	private WebElement contactname;

	/*
	 * @SCU #CommonMethodwithoutArgument:verifyContact #Description:verifys
	 * contact field in review interaction page Type:TextBox
	 */
	public boolean verifyContact() throws Exception {
		return utils.validateValueinelement(this.contactname, "Nickname");
	}

	/*
	 * @SCU #CommonMethodwithArgument:createNewAlert #Description:verifys
	 * contact field in review interaction page #Arguments:arg Type:TextBox
	 */
	public boolean verifyContact(String[] arg) throws Exception {
		return utils.validateValueinelement(this.contactname, arg[0]);
	}

	@FindBy(xpath = "//*[@data-test-id='2014111304463909631305']")
	WebElement TabValue;

	public boolean verifyProviderTabName(String[] args) {
		utils.waitforpageload();
		return utils.isvalueMatch_compareto(TabValue.getText(), args[0]);
	}

	@FindBy(xpath = "//*[@class='header-title']")
	WebElement ContactInformation;

	@FindBy(xpath = "//*[text()='Contact Type']")
	WebElement ContactType;

	public boolean displayContactInformation() {
		return utils.validateLabel(ContactInformation, "Contact Information");
	}

	public boolean displayContactType() {
		return !utils.isProxyWebelement(ContactType);
	}

	@FindBy(xpath = "(//img[@data-test-id='2017050118083306006711']")
	WebElement MessageAlertsIcon;

	@FindBy(xpath = "//a[@data-test-id='2016021609070306584948']")
	WebElement InformationalAlertsIcon;

	@FindBy(xpath = "//label[@data-test-id='20160309172148043429830-Label']")
	WebElement PrivacyAlertsIcon;

	public boolean validateProminentAlertIconForInformationalAlerts() throws Exception {
		return !utils.isProxyWebelement(InformationalAlertsIcon);
	}

	public boolean validateProminentAlertIconForMessageAlerts() throws Exception {
		return !utils.isProxyWebelement(MessageAlertsIcon);
	}

	public boolean validateProminentAlertIconForprivacyAlert() throws Exception {
		return !utils.isProxyWebelement(PrivacyAlertsIcon);
	}

	@FindBy(xpath="//label[@for='BrokerName']//following-sibling::div/span[@data-test-id='201509171111100835311891']")
	WebElement labelName;

	@FindBy(xpath="//label[@for='AgencyTIN']//following-sibling::div/span[@data-test-id='201509171111100835311891']")
	WebElement labelTINSSN;

	@FindBy(xpath="//label[@for='BusinessPhone']//following-sibling::div/span[@data-test-id='201509171111100835311891']")
	WebElement labelPhoneNumber;

	@FindBy(xpath="//label[@for='pyFullName']//following-sibling::div/span[@data-test-id='201509171111100835311891']")
	WebElement labelMemberName;

	@FindBy(xpath="//label[@for='HCIDDisplay']//following-sibling::div/span[@data-test-id='201509180929400234553780']")
	WebElement labelMemberID;

	@FindBy(xpath="//label[@for='Age']//following-sibling::div/span[@data-test-id='201509171111100835312438']")
	WebElement labelAge;

	@FindBy(xpath="//label[@for='pyID']//following-sibling::div/span[@data-test-id='20160916102637026797140']")
	WebElement labelInteractionID;

	@FindBy(xpath="//span[@data-test-id='20180718233004092340775']")
	WebElement labelBrokerContactType;

	@FindBy(xpath="//label[@for='FirstName']//following-sibling::div//span[@data-test-id='20150909171019070035344']")
	WebElement labelFirstName;

	@FindBy(xpath="//label[@for='LastName']//following-sibling::div//span[@data-test-id='20150909171019070035344']")
	WebElement labelLastName;

	@FindBy(xpath="//label[@for='CallBackNumber']//following-sibling::div//span[@data-test-id='20150917120800012541416']")
	WebElement labelCallBackNumber;

	@FindBy(xpath="//label[@for='CallBackNumExt']//following-sibling::div//span[@data-test-id='201509221139580130119425']")
	WebElement labelExtension;

	@FindBy(xpath="//label[@for='ContactEmailID']//following-sibling::div//span[@data-test-id='2017112119552307987514']")
	WebElement labelEmailID;

	@FindBy(xpath="//label[@for='FaxNumber']//following-sibling::div//span[@data-test-id='20150917120800012541416']")
	WebElement labelFaxID;

	@FindBy(xpath="//label[@for='GroupAdminName']//following-sibling::div/span[@data-test-id='201509171111100835311891']")
	WebElement labelGroupAdminName;

	@FindBy(xpath="//label[@for='BrokerGroupName']//following-sibling::div/span[@data-test-id='201509171111100835311891']")
	WebElement labelGroupName;

	@FindBy(xpath="//label[@for='BrokerGroupNumber']//following-sibling::div/span[@data-test-id='201509171111100835311891']")
	WebElement labelGroupNumber;



	/**
	 * Verifies the pre populated Name field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyNameFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelName, args[0]);
	}

	/**
	 * Verifies the pre populated TIN field with the user input data
	 * @param args
	 * @return
	 */
	public boolean validateTINSSNFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelTINSSN, args[0]);
	}

	/**
	 * Verifies the pre populated Phone Number field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyPhoneNumberFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelPhoneNumber, args[0]);
	}

	/**
	 * Verifies the pre populated Member Name field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyMemberNameFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelMemberName, args[0]);
	}

	/**
	 * Verifies the pre populated Member ID field with the user input data
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyMemberIDFieldIsPopulated(String[] args) throws InterruptedException
	{
		Thread.sleep(10000);
		return utils.validateLabel(labelMemberID, args[0]);
	}

	/**
	 * Verifies the pre populated Age field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyAgeFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelAge, args[0]);
	}

	/**
	 * Verifies the pre populated Interaction ID field with the user input data
	 * @return
	 */	
	public boolean verifyInteractionIDFieldIsPopulated()
	{
		return utils.isvalueMatch_contain(labelInteractionID.getText(), labelInteractionID.getText());
	}

	/**
	 * Verifies the pre populated Contact Type field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyContactTypeDropDownIsPrePopulated(String[] args)
	{

		utils.waitforpageload();
		return utils.validateLabel(labelBrokerContactType, args[0]);
	}

	/**
	 * Verifies the pre populated First Name and last Name field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyFirstNameLastNameFieldIsPopulated(String[] args)
	{
		if(utils.validateLabel(labelFirstName, args[0]))
			if(utils.validateLabel(labelLastName, args[1]))
				return true;
		return false;
	}

	/**
	 * Verifies the pre populated Call Back Number field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyCallbackNumberFieldIsPopulated(String[] args)
	{
		utils.waitforpageload();
		return utils.validateLabel(labelCallBackNumber, args[0]);
	}

	/**
	 * Verifies the pre populated Extension field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyExtensionFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelExtension, args[0]);
	}

	/**
	 * Verifies the pre populated Email ID field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyEmailIDFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelEmailID, args[0]);
	}

	/**
	 * Verifies the pre populated Fax ID field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyFaxIDFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelFaxID, args[0]);
	}

	/**
	 * Verifies the pre populated Group Admin Name field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyGroupAdminNameFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelGroupAdminName, args[0]);
	}

	/**
	 * Verifies the pre populated Group Number field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyGroupNumberFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelGroupNumber, args[0]);
	}

	/**
	 * Verifies the pre populated Group Name field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyGroupNameFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelGroupName, args[0]);
	}

	@FindBy(xpath="//span[@data-test-id='20150909171019070035344']")
	WebElement labelContactName;

	@FindBy(xpath="//label[@for='CorrespondenceReceiveDate']//following-sibling::div/span[@data-test-id='20150909171019070035344']")
	WebElement labelDateOfCorrespondence;


	/**
	 * Verifies the pre populated Contact Name field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyContactNameFieldIsPopulated(String[] args)
	{
		utils.waitforpageload();
		return utils.validateLabel(labelContactName, args[0]);
	}

	/**
	 * Verifies the pre populated Date of Correspondence field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyDateOfCorrespondenceFieldIsPopulated(String[] args)
	{
		return utils.validateLabel(labelDateOfCorrespondence, args[0]);
	}

	@FindBy(xpath="//div[contains(text(),'Research Interaction')]")
	WebElement clickResearchInteraction;

	public boolean clickResearchInteractionButton()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(clickResearchInteraction,"Interaction Header", "Research Interaction button");
	}


	@FindBy(xpath="//label[@for='BrokerName']//following-sibling::div//span[@data-test-id='201509171111100835311891']")
	WebElement labelBrokerNameValue;

	@FindBy(xpath="//label[@for='AgencyTIN']//following-sibling::div//span[@data-test-id='201509180929400234553780']")
	WebElement labelTINValue;

	@FindBy(xpath="//label[@for='CAParentID']//following-sibling::div//a[@data-test-id='20160220155047038739106']")
	WebElement linkInteractionIDValue;

	@FindBy(xpath="//label[@for='pyFullName']//following-sibling::div//span[@data-test-id='201509171111100835311891']")
	WebElement labelMemberNameValue;

	@FindBy(xpath="//label[@for='HCIDDisplay']//following-sibling::div//span[@data-test-id='201509180929400234553780']")
	WebElement labelMemberIDValue;

	@FindBy(xpath="//label[@for='Age']//following-sibling::div//span[@data-test-id='201509171111100835312438']")
	WebElement labelAgeValue;

	@FindBy(xpath="//label[@for='PolicyState']//following-sibling::div//span[@data-test-id='20160220155047038739106']")
	WebElement labelPolicyBasedOutValue;

	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForEmailInteractionForOpen()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(linkInteractionIDValue))
					if(!utils.isProxyWebelement(labelMemberNameValue))
						if(!utils.isProxyWebelement(labelMemberIDValue))
							if(!utils.isProxyWebelement(labelAgeValue))
								return true;

		return false;
	}

	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForPhoneInteractionForOpen()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(linkInteractionIDValue))
					if(!utils.isProxyWebelement(labelMemberNameValue))
						if(!utils.isProxyWebelement(labelMemberIDValue))
							if(!utils.isProxyWebelement(labelAgeValue))
								return true;

		return false;
	}

	@FindBy(xpath="//label[@for='Age']//following-sibling::div//span[@data-test-id='20160220155047038739106']")
	WebElement labelAgeValueGroupAdmin;

	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForResearchInteraction()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(linkInteractionIDValue))
					if(!utils.isProxyWebelement(labelMemberNameValue))
						if(!utils.isProxyWebelement(labelMemberIDValue))
							if(!utils.isProxyWebelement(labelAgeValue))
								if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
									return true;

		return false;
	}



	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForEmailInteraction()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(linkInteractionIDValue))
					if(!utils.isProxyWebelement(labelMemberNameValue))
						if(!utils.isProxyWebelement(labelMemberIDValue))
							if(!utils.isProxyWebelement(labelAgeValue))
								if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
									return true;

		return false;
	}



	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForPhoneInteraction()
	{	
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(linkInteractionIDValue))
					if(!utils.isProxyWebelement(labelMemberNameValue))
						if(!utils.isProxyWebelement(labelMemberIDValue))
							if(!utils.isProxyWebelement(labelAgeValue))
								if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
									return true;

		return false;
	}

	@FindBy(xpath="//label[@for='BrokerGroupName']//following-sibling::div//span[@data-test-id='201509171111100835311891']")
	WebElement labelGroupNameValue;

	@FindBy(xpath="//label[@for='BrokerGroupNumber']//following-sibling::div//span[@data-test-id='201509180929400234553780']")
	WebElement labelGroupNumberValue;

	@FindBy(xpath="//label[@for='GroupAdminName']//following-sibling::div//span[@data-test-id='201509171111100835312438']")
	WebElement labelGroupAdminNameValue;


	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForEmailInteractionForGroupAdmin()
	{	
		if(!utils.isProxyWebelement(labelGroupNameValue))
			if(!utils.isProxyWebelement(labelGroupNumberValue))
				if(!utils.isProxyWebelement(labelGroupAdminNameValue))
					if(!utils.isProxyWebelement(linkInteractionIDValue))
						if(!utils.isProxyWebelement(labelMemberNameValue))
							if(!utils.isProxyWebelement(labelMemberIDValue))
								if(!utils.isProxyWebelement(labelAgeValueGroupAdmin))
									if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
										return true;

		return false;
	}


	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForPhoneInteractionForGroupAdmin()
	{	
		if(!utils.isProxyWebelement(labelGroupNameValue))
			if(!utils.isProxyWebelement(labelGroupNumberValue))
				if(!utils.isProxyWebelement(labelGroupAdminNameValue))
					if(!utils.isProxyWebelement(linkInteractionIDValue))
						if(!utils.isProxyWebelement(labelMemberNameValue))
							if(!utils.isProxyWebelement(labelMemberIDValue))
								if(!utils.isProxyWebelement(labelAgeValueGroupAdmin))
									if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
										return true;

		return false;
	}


	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForResearchInteractionForGroupAdmin()
	{	
		if(!utils.isProxyWebelement(labelGroupNameValue))
			if(!utils.isProxyWebelement(labelGroupNumberValue))
				if(!utils.isProxyWebelement(labelGroupAdminNameValue))
					if(!utils.isProxyWebelement(linkInteractionIDValue))
						if(!utils.isProxyWebelement(labelMemberNameValue))
							if(!utils.isProxyWebelement(labelMemberIDValue))
								if(!utils.isProxyWebelement(labelAgeValueGroupAdmin))
									if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
										return true;

		return false;
	}
	
	
	@FindBy(xpath="//label[@for='SecureMessageRefNum']")
	WebElement SMRefNumLabel;
	
	@FindBy(xpath="//label[@for='SecureMessageRefNum']/../child::div/span")
	WebElement SMRefNumValue;
	
	public boolean verifySMReferenceNumber(String[] args)
	{
		utils.waitForElementToBeVisible(SMRefNumLabel);
		if(!utils.isProxyWebelement(SMRefNumLabel));
		String Actual = SMRefNumValue.getText();
		return utils.isvalueMatch_compareto(Actual, args[0]);
	}
	
	
	@FindBy(xpath="//label[@for='CorrespondenceReceiveDate']")
	WebElement CorrespondenceReceiveDateLabel;
	
	@FindBy(xpath="//label[@for='CorrespondenceReceiveDate']/../child::div/span")
	WebElement CorrespondenceReceiveDateValue;
	
	public boolean verifySMRCorrespondenceReceiveDate(String[] args)
	{
		utils.waitForElementToBeVisible(CorrespondenceReceiveDateLabel);
		if(!utils.isProxyWebelement(CorrespondenceReceiveDateLabel));
		String Actual = CorrespondenceReceiveDateValue.getText();
		return utils.isvalueMatch_compareto(Actual, args[0]);
	}
	
	
	@FindBy(xpath="//label[text()='Interaction Status']")
	WebElement InteractionStatusLabel;
	
	@FindBy(xpath="//span[@data-test-id='201903011016000789118940']")
	WebElement InteractionStatusValue;
	
	public boolean verifyInteractionStatus(String[] args)
	{
		utils.waitForElementToBeVisible(InteractionStatusLabel);
		if(!utils.isProxyWebelement(InteractionStatusLabel));
		String Actual = InteractionStatusValue.getText();
		return utils.isvalueMatch_compareto(Actual, args[0]);
	}
	
	
	
	/**Clicks the collapse button on the interaction header
	 * 
	 */
	
	@FindBy(xpath="//button[@data-test-id='20190204161848004273239']")
	WebElement clickCollapse;

	public boolean clickCollapseButton()
	{
		return utils.clickAnelemnt(clickCollapse,"Header","Collapse Button");
	}

	/**Clicks the expand button on the interaction header
	 * 
	 */
	
	@FindBy(xpath="//button[@data-test-id='201902041510400947272129']")
	WebElement clickExpand;

	public boolean clickExpandButton()
	{
		return utils.clickAnelemnt(clickExpand,"Header","Expand Button");
	}
	
	public boolean MemberExpandedDetails(String[] iDetails) throws Exception {
		boolean returnvar;
		returnvar = true;

		wait = new WebDriverWait(Driver.pgDriver, 20);
		wait.until(ExpectedConditions.visibilityOf(this.labelInteractionHeaderfullname));
		for (String iterator : iDetails) {
			String keyvaluepair = iterator;
			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if (key.toLowerCase().contains("membername")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderfullname, value);
				continue;
			} else if (key.toLowerCase().contains("id")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderID, value);
				continue;
			}

			else if (key.toLowerCase().contains("age")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderAge, value);
				continue;
			}

			else if (key.toLowerCase().contains("fundingtype")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderFundingType, value);
				continue;
				
			} else if (key.toLowerCase().contains("lastinteraction")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderLastInteractionDate, value);

				continue;
			} else if (key.toLowerCase().contains("phone")) {
				returnvar = utils.isvalueMatch_contain(
						this.labelInteractionHeaderphone.getAttribute("value").toLowerCase(), value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("nickname")) {
				String text = this.txtbxInteractionHeaderNickName.getAttribute("value");
				returnvar = utils.isvalueMatch_contain(text.toLowerCase(), value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("callbacknumber")) {
				System.out.println(this.txtbxInteractionHeaderCallbackNumber.getAttribute("value"));
				returnvar = utils.isvalueMatch_contain(
						this.txtbxInteractionHeaderCallbackNumber.getAttribute("value").toLowerCase(),
						value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("callbackextension")) {
				returnvar = utils.isvalueMatch_contain(
						this.txtbxInteractionHeaderCallBackExtension.getAttribute("value").toLowerCase(),
						value.toLowerCase());
				continue;
			} else
				err.logcommonMethodError("Interaction Header",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if (returnvar) {
			System.out.println("Interaction Header Details checked successfully");
			return true;
		} else {
			int tot_i = iDetails.length;
			err.logcommonMethodError("Interaction Header",
					"the value " + iDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}
	}

	
	@FindBy(xpath = "//label[text()='Member Name:']/..//span[@data-test-id='20190131151417017822991']")
	WebElement labelInteractionHeaderfullnameCollapsed;

	@FindBy(xpath = "//*[@data-test-id='20190131153520091856751']")
	WebElement labelInteractionHeaderIDCollapsed;

	@FindBy(xpath = "//*[@data-test-id='20190131153114037925182']")
	WebElement labelInteractionHeaderAgeCollapsed;
	
	public boolean MemberCollapsedDetails(String[] iDetails) throws Exception {
		boolean returnvar;
		returnvar = true;

		wait = new WebDriverWait(Driver.pgDriver, 20);
		wait.until(ExpectedConditions.visibilityOf(this.labelInteractionHeaderfullnameCollapsed));
		for (String iterator : iDetails) {
			String keyvaluepair = iterator;
			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if (key.toLowerCase().contains("membername")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderfullnameCollapsed, value);
				continue;
			} else if (key.toLowerCase().contains("id")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderIDCollapsed, value);
				continue;
			}

			else if (key.toLowerCase().contains("age")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderAgeCollapsed, value);
				continue;
			}

			else if (key.toLowerCase().contains("fundingtype")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderFundingType, value);
				continue;
				
			} else if (key.toLowerCase().contains("lastinteraction")) {
				returnvar = utils.validateValueinelement(this.labelInteractionHeaderLastInteractionDate, value);

				continue;
			} else if (key.toLowerCase().contains("phone")) {
				returnvar = utils.isvalueMatch_contain(
						this.labelInteractionHeaderphone.getAttribute("value").toLowerCase(), value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("nickname")) {
				String text = this.txtbxInteractionHeaderNickName.getAttribute("value");
				returnvar = utils.isvalueMatch_contain(text.toLowerCase(), value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("callbacknumber")) {
				System.out.println(this.txtbxInteractionHeaderCallbackNumber.getAttribute("value"));
				returnvar = utils.isvalueMatch_contain(
						this.txtbxInteractionHeaderCallbackNumber.getAttribute("value").toLowerCase(),
						value.toLowerCase());
				continue;
			} else if (key.toLowerCase().contains("callbackextension")) {
				returnvar = utils.isvalueMatch_contain(
						this.txtbxInteractionHeaderCallBackExtension.getAttribute("value").toLowerCase(),
						value.toLowerCase());
				continue;
			} else
				err.logcommonMethodError("Interaction Header",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if (returnvar) {
			System.out.println("Interaction Header Details checked successfully");
			return true;
		} else {
			int tot_i = iDetails.length;
			err.logcommonMethodError("Interaction Header",
					"the value " + iDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}
	}

	
	@FindBy (id="Nickname")	
	private WebElement txtbxNickName;
	
	public boolean validateTheContactNameFieldAndValue(String[] args){
		
		return utils.validateLabel(txtbxNickName, args[0]);
	}
	
	public boolean editTheContactName(String[] args){
		
		return utils.enterTextinAnelemnt(txtbxNickName,args[0], "Search Member", "Contact First and Last name");

		}
	@FindBy(xpath="//*[@data-test-id='201509180929400234553780-Label']")
	WebElement providerid;
	
	public boolean validateProviderIdType(String[] args)
	{
		String actaulMsg = args[0];
		String expectedMsg = providerid.getText();
		return utils.isvalueMatch_contain(actaulMsg, expectedMsg);
	}
	public boolean InteractionID() throws IOException {
		if (!utils.isProxyWebelement(getReviewInteractionID)) {
		//System.out.println("Interaction ID is displayed ");
		getInteractionID = this.getReviewInteractionID.getText();
		System.out.println(getInteractionID); 
		return true;	
}
		return false;
}
	public boolean memberID(){
	
		if (!utils.isProxyWebelement(labelMemberIDValue)) {
			getmemberID = this.labelMemberIDValue.getText();
			System.out.println(getmemberID); 
			return true;	
		
	}
		return false;
}
}




