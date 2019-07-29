package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.By;
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

public class PhoneCallMembersearchProvider extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	public PhoneCallMembersearchProvider() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement);// change the
		// driver
	}

	// Webelements to be used in program

	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(xpath = "//span[text()='Search for Provider']")
	WebElement headerforproviderSearch;

	@FindBy(id = "CallerType")
	private WebElement txtbxcallerType; // dropdown

	@FindBy(id = "FirstNameProvider")
	private WebElement txtbxfirstName;

	@FindBy(id = "LastName")
	private WebElement txtbxlastName;

	@FindBy(id = "Nickname")
	private WebElement txtbxnickName;

	@FindBy(id = "CallBackNumber")
	private WebElement txtbxcallBackNumber;

	@FindBy(id = "CallBackNumExt")
	private WebElement txtbxcallBackNumExt;

	@FindBy(id = "OfficeName")
	private WebElement txtbxproviderName;

	@FindBy(id = "SearchStringNPI")
	private WebElement txtbxsearchStringNPI;

	@FindBy(xpath = "//*[@name='$PpyWorkPage$pProvState']")
	private WebElement txtbxsearchState;

	@FindBy(id = "AddressLine1")
	private WebElement txtbxaddressLine1;

	@FindBy(xpath = "//*[@name='$PTempProvNotFoundPge$pCity']")
	private WebElement txtbxcity;

	@FindBy(xpath = "//*[@name='$PpyWorkPage$pProvNotFoundState']")
	private WebElement providerNotFoundState;

	@FindBy(id = "ProviderSearchTypeTIN/NPI")
	private WebElement rBtnNPI;

	@FindBy(id = "ProvNotFound")
	private WebElement rBtnProviderNotFound;

	@FindBy(id = "ProvLocatedExternal")
	private WebElement rBtnproviderLocatedExternal;

	// button to be used

	@FindBy(xpath = "//*[@data-test-id='2015082811210004244498']")
	private WebElement BtnsearchButton;

	//*[@data-test-id='2015082811210004244498']

	@FindBy(xpath = "//button[@title='Complete this assignment']")
	private WebElement btnSubmitButton;

	@FindBy(xpath = "//div[contains(text(),'Other Actions')]")
	private WebElement btnOtherAction;

	@FindBy(xpath = "//li[@title='Exit Interaction']")
	private WebElement btnExitInteraction;

	@FindBy(xpath = "//li[@title='External Search']")
	private WebElement btnExternalSearch;

	@FindBy(xpath = "//li[@title='Provider not found search']")
	private WebElement btnProviderNotFound;

	// table

	@FindBy(xpath = "//table[@pl_prop='ProviderList.pxResults']")
	private WebElement searchResulttable;

	// Text Box Methods

	public WebElement gettxbxcallerType() {
		return txtbxcallerType;
	}

	public WebElement getTxtbxfirstName() {
		return txtbxfirstName;
	}

	public WebElement getTxtbxlastName() {
		return txtbxlastName;
	}

	public WebElement getTxtbxNickName() {
		return txtbxnickName;
	}

	public WebElement getTxtbxCallerPhone() {
		return txtbxcallBackNumber;
	}

	public WebElement getTxtbxProviderName() {
		return txtbxproviderName;
	}

	public WebElement getTxtbxNPI() {
		return txtbxsearchStringNPI;
	}

	public WebElement getTxtbxAddress() {
		return txtbxaddressLine1;
	}

	public WebElement getTxtbxCity() {
		return txtbxcity;
	}

	public WebElement getTxtbxState() {
		return txtbxsearchState;
	}

	public WebElement getTxtbxStateForProvierNotFound() {
		return providerNotFoundState;
	}
	// click functions methods

	public WebElement clickProviderSearchTypeNPI() {
		return rBtnNPI;
	}

	public WebElement clickrBtnProviderNotFound() {
		return rBtnProviderNotFound;
	}

	public WebElement clickrBtnproviderLocatedExternal() {
		return rBtnproviderLocatedExternal;
	}

	/*
	 * public WebElement clickTxtbxStateAfterSettingValue() { return
	 * TxtbxStateAfterSettingValue; }
	 */

	public WebElement clickBTnSubmit() {
		return btnSubmitButton;
	}

	// button click functions

	public WebElement clickSearchButton() {
		return BtnsearchButton;

	}

	public WebElement ClickOtherActionsButton() {
		return btnOtherAction;
	}

	// other action

	public WebElement clickExitInteraction() {
		return btnExitInteraction;
	}

	public WebElement clickExternalSearch() {
		return btnExternalSearch;
	}

	public WebElement clickProviderNotFoundSearch() {
		return btnProviderNotFound;
	}

	// header for provider search
	public WebElement headerForProviderSearch() {
		return headerforproviderSearch;
	}

	// Column

	public WebElement gettblSearchresult() {
		return this.searchResulttable;
	}

	// select callertype

	public boolean selectCallerType(String[] visibleString) {
		return utils.selectDropDownbyVisibleString(this.gettxbxcallerType(), visibleString[0], "Phone Call",
				"Drop Down CallerType");

	}

	// set lastname
	public boolean setFirstName(String[] args) {
		return utils.enterTextinAnelemnt(this.getTxtbxfirstName(), args[0], "Phone Call", "Text Box Last Name");

	}

	public boolean setFirstNameInProvider(String args) {
		return utils.enterTextinAnelemnt(this.getTxtbxfirstName(), args, "Phone Call", "Text Box Last Name");

	}

	// set callerphone
	public boolean setCallerPhone(String[] callerphone) {
		return utils.enterTextinAnelemnt(this.getTxtbxCallerPhone(), callerphone[0], "Phone Call", "Text Box CallerPhone");

	}

	public boolean setCallerPhoneInProvider(String callerphone) {
		return utils.enterTextinAnelemnt(this.getTxtbxCallerPhone(), callerphone, "Phone Call", "Text Box CallerPhone");

	}

	// set providername
	public boolean setProviderName(String[] providername) {
		return utils.enterTextinAnelemnt(this.getTxtbxProviderName(), providername[0], "Phone Call", "Text Box providername");

	}

	public boolean setProviderNameInProvider(String providername) {
		return utils.enterTextinAnelemnt(this.getTxtbxProviderName(), providername, "Phone Call", "Text Box providername");
	}

	// click NPI radio button
	public boolean clickradioButtonNPI() {
		return utils.clickAnelemnt(this.rBtnNPI, "Phone Call", "Radio Button NPI");
	}

	// click search button
	public boolean clickSearch() {
		waitforpageload();
		return utils.clickAnelemnt(this.clickSearchButton(), "Phone Call", "Button Search");
	}

	// set NPI value
	public boolean setNPI(String[] NPI) {
		return utils.enterTextinAnelemnt(this.getTxtbxNPI(), NPI[0], "Phone Call", "Text Box NPI");
	}

	public boolean setProviderNPI(String NPI) {
		return utils.enterTextinAnelemnt(this.getTxtbxNPI(), NPI, "Phone Call", "Text Box NPI");
	}

	// select state ----------doubt
	public boolean clickOnTheState() {
		return utils.clickAnelemnt(this.getTxtbxState(), "Phone Call", "Text Box tate");
	}

	// enter state

	public boolean setTxtStateName(String string) {
		return utils.enterTextinAnelemnt(this.getTxtbxState(), string, "Phone Call", "Enter State");
	}

	public boolean setTxtStateNameForProviderNotFound(String string) {
		return utils.enterTextinAnelemnt(this.getTxtbxStateForProvierNotFound(), string, "Phone Call","Enter State for provider not found");
	}

	// set address

	public boolean clickradioButtonForProviderNotfound() {
		return utils.clickAnelemnt(this.rBtnProviderNotFound, "Phone Call", "Radio Button Provider not found");
	}

	public boolean setAddress(String[] address) {
		return utils.enterTextinAnelemnt(this.getTxtbxAddress(), address[0], "Phone Call", "Text Box Address");
	}

	public boolean setCity(String[] city) {
		return utils.enterTextinAnelemnt(this.getTxtbxCity(), city[0], "Phone Call", "Text Box City");
	}

	public boolean clickradioButtonForProviderLocatedExternally() {
		return utils.clickAnelemnt(this.rBtnproviderLocatedExternal, "Phone Call", "Radio Button for LocatedExternal");
	}

	// click other actions

	public boolean clickOnOtherAction() {
		return utils.clickAnelemnt(this.btnOtherAction, "Phone call", "other actions");
	}

	// select other action field

	public boolean selectExitInteractionforOtherAction() {
		return utils.clickAnelemnt(this.clickExitInteraction(), "Phone call", "other actions-Exit interaction");
	}

	public boolean selectExternalSearchforOtherAction() {
		return utils.clickAnelemnt(this.btnExternalSearch, "Phone call", "other actions-ExternalSearch");
	}

	public boolean selectProviderNotFoundSearchforOtherAction() {
		return utils.clickAnelemnt(this.clickProviderNotFoundSearch(), "Phone call", "ProviderNotFoundSearch");
	}

	public boolean selectState(String[] arg) {
		return utils.enterTextinAnelemnt(this.txtbxsearchState, arg[0], "Phone call", "text box state");
	}

	public boolean selectStateForProvider(String arg) {
		return utils.enterTextinAnelemnt(this.txtbxsearchState, arg, "Phone call", "text box state");
	}

	public boolean selectStateForProviderNotFound(String[] arg) throws InterruptedException {
		return utils.enterTextinAnelemnt(this.getTxtbxStateForProvierNotFound(), arg[0], "Phone call","text box state for provider not found");
	}

	public boolean clickSubmitButton() {
		waitforpageload();
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.clickBTnSubmit(), "Phone Call", "Button for Submit");
	}

	public boolean selectExitInterationFromOtheractionButton() {
		if (clickOnOtherAction())
			if (this.selectExitInteractionforOtherAction())
				return true;
		return false;
	}

	public boolean selectExternalSearchFromOtheractionButton() {
		if (clickOnOtherAction())
			if (this.selectExternalSearchforOtherAction())
				return true;
		return false;
	}

	public boolean selectProviderNotFoundFromOtheractionButton() {
		if (clickOnOtherAction())
			if (this.selectProviderNotFoundSearchforOtherAction())
				return true;
		return false;
	}

	// wait for page to load

	public boolean waitforpageload() {
		try {
			Thread.sleep(3000);
			System.out.println("Checking for Loading Icon");
			wait = new WebDriverWait(Driver.getPgDriver(), 100);
			System.out.println("Checkingggg" + System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg" + System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg" + System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
		} catch (Exception e) {
			System.out.println("No loading icon. Continue " + e);
		}
		System.out.println("Came out");
		return true;
	}

	// get column name

	public ArrayList<String> getsearchResultbyColumn(String columnName) {
		ArrayList<String> returnColumn = new ArrayList<String>();
		returnColumn = utils.getcolumnStringFromTableByName(this.gettblSearchresult(), columnName);
		return returnColumn;
	}

	// verify header

	public boolean verifyheaderforSearchProvider() {
		return utils.validateHeader(this.headerForProviderSearch(), "Search for Provider");
	}

	// Search by provider ID

	public boolean searchByNPI(String[] args) throws InterruptedException {
		utils.scrolltomiddle();
		if (verifyheaderforSearchProvider())
		{
			boolean returnvar;
			returnvar = true;
			String keyvaluepair = "";
			for (String iterator : args) {
				if (!returnvar) {
					err.logcommonMethodError("Phone call", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
				if (key.toLowerCase().contains("npi")) {
					try {
						this.clickradioButtonNPI();
						this.setProviderNPI(value);
					} catch (Exception e) {
						System.out.println("unexpected exception found");
						e.printStackTrace();
					}
					continue;
				}
				else if (key.toLowerCase().contains("state")) {
					try {
						this.selectStateForProvider(value.toUpperCase());
					} catch (Exception e) {
						System.out.println("unexpected exception found");
						e.printStackTrace();
					}
					continue;
				}
				else
					err.logcommonMethodError("Phone call",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
			return this.clickSearch();
		}
		return false;
	}

	public boolean selectProviderByName(String[] args) throws InterruptedException {
		utils.waitforpageload();
		String value = args[0].substring(args[0].indexOf(":") + 1);
		System.out.println(args[0] + "       " + value);
		String[] valuetobechose = { "Provider Name:" + args[0] };
		try {
			return utils.clickontablerowbasedonvalues(this.searchResulttable, valuetobechose);
		} catch (Exception e) {
			err.logcommonMethodError("Phone call Search provider", "selectProviderbyName");
			return false;
		}

	}

	public boolean fillFirstNameAndCallerPhoneAndProviderName(String[] args) {
		if (this.setFirstNameInProvider(args[0]))
			if (this.setCallerPhoneInProvider(args[1]))
				return setProviderNameInProvider(args[2]);
		return false;
	}

	@FindBy(id="ProviderSearchTypeTIN")
	WebElement TINRdoBtn;

	@FindBy(id="SearchStringTIN")
	WebElement TINTxtBox;

	public boolean searchByTaxID(String[] args) throws InterruptedException {
		boolean flag = false;
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(TINRdoBtn, "ResearchProvider", "TINRdoBtn")) 
			if(utils.enterTextinAnelemnt(TINTxtBox, args[0],"ResearchProvider","TINTxtBox"))
				if(utils.enterTextinAnelemnt(txtbxsearchState, args[1],"ResearchProvider","txtbxsearchState"))
					if(clickSearch())
						flag= true;
					else
						flag= false;

		if(flag) {
			blogger.loginfo("PASS: Search successful");
			return true;
		}else {
			blogger.loginfo("FAIL: Search successful");
			return false;
		}

	}

	@FindBy(id="HMOProviderSearchTypeTIN")
	WebElement hmoTINRdoBtn;

	public boolean searchByTaxIDHmo(String[] args) throws InterruptedException {
		boolean flag = false;
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(hmoTINRdoBtn, "ResearchProvider", "TINRdoBtn")) 
			if(utils.enterTextinAnelemnt(TINTxtBox, args[0],"ResearchProvider","TINTxtBox"))
				if(clickSearch())
					flag= true;
				else
					flag= false;

		if(flag) {
			blogger.loginfo("PASS: Search successful");
			return true;
		}else {
			blogger.loginfo("FAIL: Search successful");
			return false;
		}

	}

	@FindBy(xpath="//*[text()='Capture Contact Details']")
	WebElement CaptureContactDetails;

	@FindBy(xpath="//*[text()='Contact Type']")
	WebElement ContactType;

	@FindBy(xpath="//*[text()='Contact Phone']")
	WebElement ContactPhone;


	public boolean displayCaptureContactDetails() {
		return !utils.isProxyWebelement(CaptureContactDetails);
	}

	public boolean displayContactType() {
		return !utils.isProxyWebelement(ContactType);	
	}

	public boolean displayContactPhone() {
		return !utils.isProxyWebelement(ContactPhone);
	}

	@FindBy(xpath="//input[@id='IsAllSourceSystems']")
	WebElement chkAllSource;

	public boolean clickSelectAllSourceSystem()
	{
		return utils.clickAnelemnt(chkAllSource, "Search for provider", "Select all source system");
	}


	@FindBy(xpath="//label[text()='Site Name']//following::span[@data-test-id='20170619145720027438108']")
	WebElement siteName; 

	@FindBy(xpath="//input[@id='IsSiteNameVerified']")
	WebElement chkSiteName;

	public boolean validateVerificationCheckboxisPrechecked(String[] args)
	{
		System.out.println("actual text site name : "+siteName.getText());
		if(utils.isvalueMatch_compareto(siteName.getText(), args[0]))
			if(chkSiteName.isEnabled())
				return true;
		return false;
	}

	@FindBy(xpath="//input[@id='IsHMOSearch']")
	WebElement chkHMO;

	public boolean clickHMOcheckbox() {
		return utils.clickAnelemnt(chkHMO, "Search for provider", "check box");
	}


	@FindBy(xpath = "//*[text()='Submit']")
	WebElement btnSubmit;

	@FindBy(id="CaseOrTaskIcon")
	WebElement radioButton;

	public boolean selectFirstProvider(){
		if(utils.clickAnelemnt(radioButton, "SelectMember", "Radio button -	firstRowofselectMembertable")){
			utils.scrolltomiddle();
			return utils.clickAnelemnt(btnSubmit, "Phone Call", "Button for Submit");
		}
		return false;
	}

	public boolean selectFirstProviderWithoutSubmit() throws InterruptedException{
		Thread.sleep(10000);
		utils.waitforpageload();
		return utils.clickAnelemnt(radioButton, "SelectMember", "Radio button -	firstRowofselectMembertable");
	}

	@FindBy(xpath="//label[text()='Physical Address']/../../..//input[@type='checkbox']")
	WebElement PhysicalAddressCheckBox;

	@FindBy(xpath="//label[text()='Phone Number']/../../..//input[@type='checkbox']")
	WebElement PhoneNumberCheckBox;

	/**This functionality validates that the Providers Address Checkbox is not autochecked in the Provider Search Page
	 * 
	 * @return
	 */
	public boolean validateProviderAddressCheckbox() {
		String physicaladdress = PhysicalAddressCheckBox.getAttribute("checked");
		try {
			return utils.isvalueMatch_contain(physicaladdress, "null");
		}catch(NullPointerException e) {
			blogger.loginfo("Provider Address is not checked");
			return true;
		}

	}

	/**This functionality validates that the Providers Phone number Checkbox is not autochecked in the Provider Search Page
	 * 
	 * @return
	 */
	public boolean validateProviderPhoneNumberCheckbox() {
		String phonenumber = PhoneNumberCheckBox.getAttribute("checked");
		try {
			return utils.isvalueMatch_contain(phonenumber, "null");
		}catch(NullPointerException e) {
			blogger.loginfo("Provider Address is not checked");
			return true;
		}
	}

	@FindBy(id="ProviderSearchTypeNCS")
	WebElement PractionerRdoButton;

	@FindBy(xpath="//span[text()='Last Name']/../..//input[@data-test-id='20170522190915049723982']")
	WebElement PractionerName;

	/**This functionality enters the Practitioner First Name Last Name City and enters the State and then clicks the search button
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchByPractitionerName(String[] args) throws InterruptedException {
		boolean flag = false;
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(PractionerRdoButton, "ResearchProvider", "PractionerRdoButton")) 
			if(utils.enterTextinAnelemnt(PractionerName, args[0],"ResearchProvider","PractionerName"))
				if(utils.enterTextinAnelemnt(txtbxsearchState, args[1],"ResearchProvider","txtbxsearchState"))
					if(clickSearch())
						flag= true;
					else
						flag= false;

		if(flag) {
			blogger.loginfo("PASS: Search successful");
			return true;
		}else {
			blogger.loginfo("FAIL: Search successful");
			return false;
		}

	}

	@FindBy(id="ProviderSearchTypeORGS")
	WebElement OrganisationRdoButton;

	@FindBy(id="SearchStringOrgName")
	WebElement OrganisationName;

	/**This functionality enters the Organization Name and enters the State and then clicks the search button
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchByOrganizationName(String[] args) throws InterruptedException {
		boolean flag = false;
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(OrganisationRdoButton, "ResearchProvider", "PractionerRdoButton")) 
			if(utils.enterTextinAnelemnt(OrganisationName, args[0],"ResearchProvider","PractionerName"))
				if(utils.enterTextinAnelemnt(txtbxsearchState, args[1],"ResearchProvider","txtbxsearchState"))
					if(clickSearch())
						flag= true;
					else
						flag= false;

		if(flag) {
			blogger.loginfo("PASS: Search successful");
			return true;
		}else {
			blogger.loginfo("FAIL: Search successful");
			return false;
		}

	}

	@FindBy(id="HMOProviderSearchTypeNPI")
	WebElement NPIRadioButtonHMO;

	/**SEarch by NPI
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchByNPIhmo(String[] args) throws InterruptedException {
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(NPIRadioButtonHMO, "ResearchProvider", "NPIRadioButtonHMO")) 
			if(utils.enterTextinAnelemnt(txtbxsearchStringNPI, args[0],"ResearchProvider","txtbxsearchStringNPI"))
				return clickSearch();
		return false;
	}
	
	@FindBy(id="HMOProviderSearchTypePCPID")
	WebElement PCPRadioButtonHMO;
	
	@FindBy(id="SearchStringPCPID")
	WebElement txtboxSearchStringPCPID;

	/**SEarch by PCPID
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchByPCPIDhmo(String[] args) throws InterruptedException {
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(PCPRadioButtonHMO, "ResearchProvider", "PCPRadioButtonHMO")) 
			if(utils.enterTextinAnelemnt(txtboxSearchStringPCPID, args[0],"ResearchProvider","txtboxSearchStringPCPID"))
				return clickSearch();
		return false;
	}
	
	@FindBy(id="HMOProviderSearchTypeSITEID")
	WebElement SITERadioButtonHMO;
	
	@FindBy(id="SearchStringSiteID")
	WebElement txtboxSearchStringSITEID;

	/**SEarch by PCPID
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchBySiteID(String[] args) throws InterruptedException {
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(SITERadioButtonHMO, "ResearchProvider", "SITERadioButtonHMO")) 
			if(utils.enterTextinAnelemnt(txtboxSearchStringSITEID, args[0],"ResearchProvider","txtboxSearchStringSITEID"))
				return clickSearch();
		return false;
	}
	@FindBy(xpath = "//select[@id='CallerType']")
	WebElement ContactTypeDropDown;

	/**
	 *This functionality validates that the Contact Type is default to Billing Office option in the Provider Search Page
	 */
	public boolean validateContactTypeDefaultToBillingOffice(String args[]) {
		
			Select sel = new Select(ContactTypeDropDown);
			String ContacttypeDefaultValue = sel.getFirstSelectedOption().getText();
			return utils.isvalueMatch_contain(ContacttypeDefaultValue, args[0]);
			
		
		}
	
	@FindBy(xpath="//*[text()='HIPAA Verification & Disclosure Guide']")
	WebElement HIPAAGUIDELink;
	
	/**Verify HIPAA Verification And DIsclosure Link Is Available Under Search By at Search for provider page in Phone call provider flow
	 * 
	 * @return
	 */
	public boolean verifyHIPAAVerificationAndDIsclosureIsAvailableProviderFlow(){
		return !utils.isProxyWebelement(HIPAAGUIDELink);
	}
	
	
	@FindBy(xpath="//input[@id='ContinueWithoutProvider']")
	WebElement ContinueWithoutProvider;
	
	/**Click Continue Without Provider Check-box at Search for provider page in Phone call provider flow
	 * 
	 * @return
	 */	
	public boolean clickContinueWithoutProvider(){
		return utils.clickAnelemnt(ContinueWithoutProvider, "PhoneCallMembersearchProvider", "ContinueWithoutProvider");
	}
	
	
	@FindBy(xpath="//span[text()='Provider Verification']")
	WebElement VerificationHeader;
	/**Verifies that the HIPPA Validation section is hidden on clicking Continue Without Provider Check-box Phone call provider flow
	 * 
	 * @return
	 */
	public boolean verifyHippaValidationSectionIsHidden(){
		return utils.isProxyWebelement(VerificationHeader);
	}
	
	public boolean searchByTINOrNPI(String[] args) throws InterruptedException {
		utils.scrolltomiddle();
		if (verifyheaderforSearchProvider())
		{
			boolean returnvar;
			returnvar = true;
			String keyvaluepair = "";
			for (String iterator : args) {
				if (!returnvar) {
					err.logcommonMethodError("Phone call", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
				if (key.toLowerCase().contains("npi")) {
					try {
						this.clickradioButtonNPI();
						this.setProviderNPI(value);
					} catch (Exception e) {
						System.out.println("unexpected exception found");
						e.printStackTrace();
					}
					continue;
				}
				else if (key.toLowerCase().contains("state")) {
					try {
						this.selectStateForProvider(value.toUpperCase());
					} catch (Exception e) {
						System.out.println("unexpected exception found");
						e.printStackTrace();
					}
					continue;
				}
				else
					err.logcommonMethodError("Phone call",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
			return this.clickSearch();
		}
		return false;
	}
	/**Verify Alpha Prefix Router Is Available Under Search By at Search for provider page in Phone call provider flow
	 * 
	 * @return
	 */
	
	@FindBy(xpath="//a[text()='Alpha Prefix Router']")
	WebElement AlphaPrefixLink;
	
	public boolean validateAlphaPrefixRouterLinkIsAvailable(){
		return !utils.isProxyWebelement(AlphaPrefixLink);
	}
	
	/**Verify TIN/NPI Label is available at provider search page in Phone call provider flow
	 * 
	 * @return
	 */
	
	@FindBy(xpath="//span[text()='TIN/NPI']")
	WebElement TINORNPILabel;
	
	public boolean validateTINOrNPILabelIsAvailable(){
		return !utils.isProxyWebelement(TINORNPILabel);
	}
	
	/**Validate that the error message Please enter a 9 digit TIN or a 10 digit NPI in Search for provider screen
	 * 
	 * @return
	 */
	
	
	
	@FindBy(xpath="//ul[@class='pageErrorList layout-noheader-errors']//li")
	WebElement TINOrNPIError;
	
	public boolean validateErrorMessageForInvalidTINOrNPI(){
		
		String TIN0rNPIErrorMsg = "Please enter a valid 9 digit TIN or 10 digit NPI";
		String TIN0rNPIErrorMsgUI = this.TINOrNPIError.getText().replaceAll(",", "").replaceAll("  ", " ");
		return utils.isvalueMatch_compareto(TIN0rNPIErrorMsgUI, TIN0rNPIErrorMsg);
}
	@FindBy(xpath="//div[text()='Transfer Interaction']")
	WebElement TrnsIntBtn;
	//Validates that the Transfer Interaction BTN Available in the Provider Search Page
	public boolean validateTransferInteractionBTNAvailable(){
		return !utils.isProxyWebelement(TrnsIntBtn);
	}
	
	@FindBy(id="HMOProviderSearchTypeORGS")
	WebElement RdoBtnOrganizationName;
	
	@FindBy(id="SearchStringOrgName")
	WebElement TxtBoxOrganizationName;
	
	public boolean searchByHMOOrganizationName(String[] args) {
		if(utils.clickAnelemnt(RdoBtnOrganizationName, "Research provider", "RdoBtnOrganizationName"))
		if(utils.enterTextinAnelemnt(TxtBoxOrganizationName, args[0], "Research provider", "TxtBoxOrganizationName"))
				if(utils.scrolltomiddle())
					 if(utils.clickAnelemnt(BtnsearchButton, "Research provider", "BtnsearchButton"))
					return true;
		return false;
	} 
}
