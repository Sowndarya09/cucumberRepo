package automationLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderComposite_ResearchProvider extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	Actions action = new Actions(Driver.pgDriver);

	public ProviderComposite_ResearchProvider() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		gotoLastIframe();
	}

	// Webelements to be used in program

	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(xpath = "//span[text()='Search for Provider']")
	WebElement headerforproviderSearch;

	@FindBy(id = "CallerType")
	private WebElement txtbxcallerType; // dropdown

	@FindBy(id = "FirstName")
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

	@FindBy(id = "ProviderSearchTypeNPI")
	private WebElement rBtnNPI;

	@FindBy(id = "ProvNotFound")
	private WebElement rBtnProviderNotFound;

	@FindBy(id = "ProvLocatedExternal")
	private WebElement rBtnproviderLocatedExternal;

	// button to be used

	@FindBy(xpath = "//*[text()='Search']")
	private WebElement BtnsearchButton;

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
			return true;
		} catch (Exception e) {
			System.out.println("No loading icon. Continue " + e);
			return false;
		}
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
			return clickSearch();
		
	}

	public boolean selectProviderByName(String[] args) throws InterruptedException {

		String value = args[0].substring(args[0].indexOf(":") + 1);
		String[] valuetobechose = { "Provider Name:" + args[0] };
			return utils.clickontablerowbasedonvalues(this.searchResulttable, valuetobechose);
	}

	public boolean fillFirstNameAndCallerPhoneAndProviderName(String[] args) {
		if (this.setFirstNameInProvider(args[0]))
			if (this.setCallerPhoneInProvider(args[1]))
				if (this.setProviderNameInProvider(args[2]))
			return true;
		return false;
	}

	@FindBy(id="CaseOrTaskIcon")
	WebElement radioButton;

	public boolean selectfirstProvider(){
			if(utils.clickAnelemnt(radioButton, "SelectMember", "Radio button -	firstRowofselectMembertable"))
				return utils.clickAnelemnt(this.clickBTnSubmit(), "Phone Call", "Button for Submit");
			return false;
	}
	
	public boolean selectfirstProviderForChangeFocus(){
			return utils.clickAnelemnt(radioButton, "SelectMember", "Radio button -	firstRowofselectMembertable");
	}

	public boolean searchAndSubmitProvider(String[] args) throws InterruptedException {
		boolean flag = false;
		String npi = null, state = null, firstname = null;
		String[] argu = args[1].split("/");
		for(String iterator : argu)
		{		
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			if(utils.isvalueMatch_contain(key.toLowerCase(), "npi")) {
				npi = value;
				continue;}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"state")){
				state = value;
				continue;}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"providerfirstname")){
				firstname = value;
				continue;}
		}

		if(setProviderNPI(npi))
			if(setTxtStateName(state))
				Thread.sleep(1000);
		if(utils.clickAnelemnt(this.clickSearchButton(), "Phone Call", "Button Search"))
			if(firstname!=null) {
				String[] providerfirstname = firstname.split(",");
				selectProviderByName(providerfirstname);
				clickSubmitButton();
				flag =true;
			}else {
				selectfirstProvider();
			}

		if(flag) {
			blogger.loginfo("PASS: Search and Submit provider successful");
			return true;
		}
		else {
			blogger.loginfo("FAIL: Search and Submit provider not successful");
			return false;
		}
	}

	@FindBy(id="ContinueWithoutProvider")
	WebElement ContinueWitoutProviderChckbox;

	public boolean DisplayContinueWithoutProvider() {
		return !utils.isProxyWebelement(ContinueWitoutProviderChckbox);
	}
	
	public boolean ClickContinueWithoutProvider() {
		return utils.clickAnelemnt(ContinueWitoutProviderChckbox, "Research Provider", "ContinueWitoutProviderChckbox");
	}

	@FindBy(xpath="//*[@for='SearchStringNPI']//strong")
	WebElement NPIMandatoryField;

	@FindBy(xpath="//*[@for='ProvState']//strong")
	WebElement StateMandatoryField;

	public boolean MandatoryFieldsNotDisplayed() {
		if(NPIMandatoryField.getAttribute("class").equalsIgnoreCase("required-field-accessibility display-none")
				&& StateMandatoryField.getAttribute("class").equalsIgnoreCase("required-field-accessibility display-none")) {
			blogger.loginfo("PASS: Mandatory fields are not displayed");
			return true;
		}else {
			blogger.loginfo("FAIL:  Mandatory fields is displayed");
			return false;
		}
	}


	public boolean validateAddressInResearchProviderTable(String[] args)
	{
		return utils.validatetablerowbasedonvalues(searchResulttable, args);

	}

	@FindBy(id="ProviderSearchTypeTIN")
	WebElement TINRdoBtn;

	@FindBy(id="SearchStringTIN")
	WebElement TINTxtBox;

	public boolean searchByTaxID(String[] args) throws InterruptedException {
		boolean flag = false;
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
	
	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionProvSearchResultsBBBBBBB~pzLayout_7']")
	WebElement tableSearchResults;
	
	@FindBy(xpath="//span[@class='collapseRowDetails']")
	WebElement expandButton;
	
	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionPractitionerResultsFromTaxIDBBBBBB~pzLayout_4']")
	WebElement tblAffiliation;
	
	@FindBy(xpath="//a[@data-test-id='2018071217200708469314']")
	WebElement lnkAffiliation;
	
	public boolean expandProviderRecord(String[] args) throws InterruptedException
	{
		WebElement row = utils.returntablerowbasedonvalues(tableSearchResults, args);
		WebElement findElement = row.findElement(By.xpath("//span[@class='collapseRowDetails']"));
		return utils.clickAnelemnt(findElement, "Research RProivder", "Colapse button");
	}
	
	public boolean selectAffiliatedProviderRecord(String[] args) throws InterruptedException
	{
		WebElement row = utils.returntablerowbasedonvalues(tblAffiliation, args);
		WebElement affiliationLink = row.findElement(By.xpath("//a[@data-test-id='2018071217200708469314']"));
		return utils.clickAnelemnt(affiliationLink, "Research provider", "Affiliation link");
	}
	
	@FindBy(xpath="//button[@data-test-id='201807122330240188681176']")
	WebElement subChngFcs;
	
	public boolean submitInChangeFocus() {
		return utils.clickAnelemnt(subChngFcs, "Change focus", "Submit in change focus");
		
	}
	
	/* To click TIN Hyperlink*/

	@FindBy(xpath="//table[@pl_prop='ProviderList.pxResults']")
	WebElement tblProviderResults;
	
	public boolean clickOnTINHyerlinkBasedOnGridValues(String[] args) throws InterruptedException {
		utils.waitforpageload();
		try
		{
		WebElement row = utils.getTablerowbasedonvalues(tblProviderResults, args);
		List<WebElement> rowNo = row.findElements(By.tagName("a"));
		rowNo.get(0).click();
		return true;
		}catch(Exception e)
		{
			err.logcommonMethodError("ResearchProvider", "clickOnTINHyerlinkBasedOnGridValues");
			return false;
		}
	}
	
	@FindBy(xpath="//span[@data-test-id='20181029015047014022116']")
	WebElement ProviderTaxIdentifier;
	
	@FindBy(xpath="//table[@pl_prop='D_PriorAuthPassEligibility.pxResults']")
	WebElement tblProviderPriorAuthPass;
	
	/* To Validate details in Provider Prior Auth pass page*/
	
	public boolean validateDisplayPriorAuthPassWindowDetails(String[] args){
	boolean flag = false;
	utils.waitforpageload();
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+handles.size());
			Iterator<String> iterator= handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow);
			String title = Driver.pgDriver.getTitle();
			System.out.println("Title of the Child Window is: "+title);
			if(title.contains("Display Prior Auth Pass")){
				System.out.println("Window switched");
				if(utils.validateLabel(ProviderTaxIdentifier, "123456789"))
					if(utils.validatetablerowbasedonvalues(tblProviderPriorAuthPass, args))
						return true;			
				return false;
			}
			Driver.pgDriver.switchTo().window(parentWindow);
			return flag;
		
	}
	
	/*To Validate filter options in Provider Prior Auth Pass page*/
	
	public boolean validateDisplayPriorAuthPassWindowDetailsWithFilter(String[] args){
		boolean flag = false;
		utils.waitforpageload();
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				System.out.println("No.ofwindows"+handles.size());
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				Driver.pgDriver.switchTo().window(childWindow);
				String title = Driver.pgDriver.getTitle();
				System.out.println("Title of the Child Window is: "+title);
				if(title.contains("Display Prior Auth Pass")){
					System.out.println("Window switched");
					if(utils.validateLabel(ProviderTaxIdentifier, "123456789"))
						if(utils.validatetablerowbasedonvalues(tblProviderPriorAuthPass, args))
							if(selectFirstFilterAndValidate())
								if(selectSecondFilterAndValidate())
									if(selectThirdFilterAndValidate())
										return true;					
					return false;
				}
				Driver.pgDriver.switchTo().window(parentWindow);
				return flag;
			
		}

	

	@FindBy(xpath="//*[text()='Procedure Code']/../..//a[@id='pui_filter']")
	WebElement ProcedureCodeFilter;

	@FindBy(xpath="//*[text()='Line of Business']/../..//a[@id='pui_filter']")
	WebElement LineOfBusinessFilter;

	@FindBy(xpath="//*[text()='Product']/../..//a[@id='pui_filter']")
	WebElement ProductFilter;

	@FindBy(xpath="(//input[@id='gridCheckBox'])[1]")
	WebElement ProcedureCodeCheckbox;

	@FindBy(xpath="//input[@id='gridCheckBox']")
	WebElement LineOfBusinessCheckbox;

	@FindBy(xpath="(//input[@id='gridCheckBox'])[1]")
	WebElement ProductCheckbox;

	@FindBy(xpath="//div[text()='Apply']")
	WebElement ApplyBtn;
	
	

	/**Selects the first Filter and validate
	 * 
	 * @return
	 */
	public boolean selectFirstFilterAndValidate(){
		if(utils.clickAnelemnt(ProcedureCodeFilter, "ResearchProvider", "ProcedureCodeFilter"))
			if(utils.clickAnelemnt(ProcedureCodeCheckbox, "ResearchProvider", "ProcedureCodeCheckbox"))
				return utils.clickAnelemnt(ApplyBtn, "ResearchProvider", "ApplyBtn");
		return false;

	}

	/**Selects the Second Filter and validate
	 * 
	 * @return
	 */

	public boolean selectSecondFilterAndValidate(){
		if(utils.clickAnelemnt(LineOfBusinessFilter, "ResearchProvider", "LineOfBusinessFilter"))
			if(utils.clickAnelemnt(LineOfBusinessCheckbox, "ResearchProvider", "LineOfBusinessCheckbox"))
				if(utils.clickAnelemnt(ApplyBtn, "ResearchProvider", "ApplyBtn"))
					return true;
		return false;
	}
	/**Selects the Third Filter and validate
	 * 
	 * @return
	 */

	public boolean selectThirdFilterAndValidate(){
		if(utils.clickAnelemnt(ProductFilter, "ResearchProvider", "ProductFilter"))
			if(utils.clickAnelemnt(ProductCheckbox, "ResearchProvider", "ProductCheckbox"))
				if(utils.clickAnelemnt(ApplyBtn, "ResearchProvider", "ApplyBtn"))
					return true;
		return false;
	}
	
	/**Enters the NPI Number or TIN Number and enter the State and select the state and then clicks the search button
	 * 
	 * @return
	 */
	
	public boolean searchByTINOrNPI(String[] args) throws InterruptedException {
		utils.scrolltomiddle();
		if (verifyheaderforSearchProvider())
		{
			boolean returnvar;
			returnvar = true;
			String keyvaluepair = "";
			for (String iterator : args) {
				if (!returnvar) {
					err.logcommonMethodError("Change Focus", "Check your " + keyvaluepair
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
	
	/**Verify TIN/NPI Label is available at Change focus provider search page
	 * 
	 * @return
	 */
	
	@FindBy(xpath="//span[text()='TIN/NPI']")
	WebElement TINORNPILabel;
	
	public boolean validateTINOrNPILabelIsAvailable(){
		return !utils.isProxyWebelement(TINORNPILabel);
	}
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;

	public void gotoLastIframe(){
		System.out.println("1");
		Driver.getPgDriver().switchTo().defaultContent();
		System.out.println("2");
		
		int i=this.iframes.size();
		System.out.println(i);
		Driver.getPgDriver().switchTo().frame(i-1);
		System.out.println("##########");
	}

}




