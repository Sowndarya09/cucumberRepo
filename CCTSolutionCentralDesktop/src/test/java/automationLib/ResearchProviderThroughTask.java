package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ResearchProviderThroughTask {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	Actions action = new Actions(Driver.pgDriver);

	public ResearchProviderThroughTask() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(Iframeelement3);
		}
		catch(Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(Iframeelement);
		}
	}

	@FindBy(id = "PegaGadget3Ifr")
	WebElement Iframeelement3;

	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="ProviderSearchTypeTIN")
	WebElement TINRdoBtn;

	@FindBy(id="ProviderSearchTypeNCS")
	WebElement PracRdoBtn;

	@FindBy(id="SearchStringTIN")
	WebElement TINTxtBox;
	@FindBy(id="ProviderFirstName")
	WebElement ProviderFirstName;

	@FindBy(id="ProviderLastName")
	WebElement ProviderLastName;

	@FindBy(id="ProviderCity")
	WebElement ProviderCity;


	@FindBy(id="ProviderSearchTypeORGS")
	WebElement OrganisationRdoBtn;

	@FindBy(id="SearchStringOrgName")
	WebElement OrganisationTxtBox;

	@FindBy(id="ProviderSearchTypeTIN")
	WebElement PractionerRdoBtn;

	@FindBy(id="SearchStringTIN")
	WebElement PractionerTxtBox;

	@FindBy(xpath = "//div[text()='Search']")
	WebElement BtnsearchButton;

	@FindBy(xpath = "//*[@name='$PpyWorkPage$pProvState']")
	WebElement txtbxsearchState;

	@FindBy(id = "SearchStringNPI")
	WebElement txtbxsearchStringNPI;

	@FindBy(xpath ="//table[@pl_prop='ProviderList.pxResults']")
	WebElement searchResulttable;


	public boolean searchByTaxIDInResearchProviderTask(String args[]) {
		if(utils.clickAnelemnt(TINRdoBtn, "ResearchProvider", "TINRdoBtn")) 
			if(utils.enterTextinAnelemnt(TINTxtBox, args[0],"ResearchProvider","TINTxtBox"))
				if(utils.enterTextinAnelemnt(txtbxsearchState, args[1],"ResearchProvider","txtbxsearchState"))
					return utils.clickAnelemnt(BtnsearchButton, "Phone Call", "Button Search");
		return false;
	}

	public boolean searchByOrganizationNameInResearchProviderTask(String args[]) {
		if(utils.clickAnelemnt(OrganisationRdoBtn, "ResearchProvider", "OrganisationRdoBtn")) 
			if(utils.enterTextinAnelemnt(OrganisationTxtBox, args[0],"ResearchProvider","OrganisationTxtBox"))
				if(utils.enterTextinAnelemnt(txtbxsearchState, args[1],"ResearchProvider","txtbxsearchState"))
					return utils.clickAnelemnt(BtnsearchButton, "Phone Call", "Button Search");
		return false;
	}

	public boolean searchByPractitionerNameInResearchProviderTask(String args[]) {
		if(utils.clickAnelemnt(PracRdoBtn, "ResearchProvider", "PracRdoBtn")) 
			if(utils.enterTextinAnelemnt(ProviderFirstName, args[0],"ResearchProvider","ProviderFirstName"))
				if(utils.enterTextinAnelemnt(ProviderLastName, args[1],"ResearchProvider","ProviderLastName"))
					if(utils.enterTextinAnelemnt(ProviderCity, args[2],"ResearchProvider","ProviderCity"))
						if(utils.enterTextinAnelemnt(txtbxsearchState, args[3],"ResearchProvider","txtbxsearchState"))
							return utils.clickAnelemnt(BtnsearchButton, "Phone Call", "Button Search");
		return false;
	}

	public boolean searchByNPIInResearchProviderTask(String[] args) {
		if(utils.enterTextinAnelemnt(txtbxsearchStringNPI, args[0], "Phone Call", "Text Box NPI"))
			if(utils.enterTextinAnelemnt(txtbxsearchState, args[1], "Phone call", "text box state"))
				if(utils.enterTextinAnelemnt(txtbxsearchState, args[1],"ResearchProvider","txtbxsearchState"))
					return utils.clickAnelemnt(BtnsearchButton, "Phone Call", "Button Search");
		return false;
	}

	public boolean validateAddressInResearchProviderTableInResearchProviderTask(String[] args) throws InterruptedException {
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(searchResulttable, args);
	}

	@FindBy(xpath="//*[@data-test-id='201807091557020135404977']")
	WebElement InstructionalText;

	public boolean validateInstructionalTextInResearchProviderTask(String[] args) {
		return utils.isvalueMatch_compareto(InstructionalText.getText().replaceAll(",", ""), args[0]);
	}

	@FindBy(xpath="//*[text()='Affiliated Provider Name']/ancestor::table[@class='gridTable repeatReadOnly']")
	WebElement tblAffiliation;

	public boolean selectAffiliatedProviderRecordInResearchProviderTask(String[] args) throws InterruptedException {
		Thread.sleep(3000);
		WebElement row = utils.returntablerowbasedonvalues(tblAffiliation, args);
		WebElement affiliationLink = row.findElement(By.xpath("//a[@data-test-id='2018071217200708469314']"));
		return utils.clickAnelemnt(affiliationLink, "Research provider", "Affiliation link");
	}

	@FindBy(xpath="//*[text()='Select']/ancestor::table[@class='gridTable repeatReadWrite']")
	WebElement tableSearchResults;

	@FindBy(xpath="//span[@class='collapseRowDetails']")
	WebElement expandButton;

	public boolean expandProviderRecordInResearchProviderTask(String[] args) throws InterruptedException {
		Thread.sleep(1000);
		WebElement row = utils.returntablerowbasedonvalues(tableSearchResults, args);
		WebElement findElement = row.findElement(By.xpath("//span[@class='expandRowDetails']"));
		return utils.clickAnelemnt(findElement, "Research RProivder", "Colapse button");
	}

	@FindBy(id="CaseOrTaskIcon")
	WebElement CaseOrTaskIcon;

	public boolean selectfirstProviderInResearchProviderTask() {
		return utils.clickAnelemnt(CaseOrTaskIcon, "Research provider", "CaseOrTaskIcon");
	}

	@FindBy(xpath="//*[text()='Submit']")
	WebElement Submit;

	public boolean clickSubmitButtonInResearchProviderTask() {
		return utils.clickAnelemnt(Submit, "Research provider", "Submit");
	}

	/** Code foe checking research provider auto validation**/

	@FindBy(xpath="//a[@data-test-id='201604081256400982365'][contains(text(),'Research Provider')]")
	WebElement tskResearchProvider;

	public boolean validateResearchProviderisAutoLaunched()
	{
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(tskResearchProvider));
		return (!utils.isProxyWebelement(tskResearchProvider));

	}
	
	@FindBy(id="IsHMOSearch")
	WebElement ChckBxHMO;
	
	/**This functionality clicks the HMO Checkbox in the Provider Search Page
	 * 
	 */
	public boolean clickHMOcheckbox() {
		return utils.clickAnelemnt(ChckBxHMO, "Research provider", "IsHMOSearch");
	}
	
	@FindBy(id="HMOProviderSearchTypeSITEID")
	WebElement RdoBtnSiteID;
	
	@FindBy(id="SearchStringSiteID")
	WebElement TxtBoxSiteID;
	
	public boolean searchBySiteID(String[] args) {
		if(utils.clickAnelemnt(RdoBtnSiteID, "Research provider", "RdoBtnSiteID"))
		if(utils.enterTextinAnelemnt(TxtBoxSiteID, args[0], "Research provider", "TxtBoxSiteID"))
		return utils.clickAnelemnt(BtnsearchButton, "Research provider", "BtnsearchButton");
		return false;
	}
	
	@FindBy(xpath="//span[text()='Cancel this work']")
	WebElement cnclWork;
	
	@FindBy(xpath="//button[@data-test-id='20150917174441083821622']")
	WebElement otherActions;
	
	@FindBy(xpath="//button[@title='Complete this assignment']/div/div/div/div[contains(text(),'Submit')]")
	WebElement btnSbmt;
	
	public boolean clickCancelWork() {
		
		if(utils.clickAnelemnt(otherActions, "Researchprovider", "other actions"))
			if(utils.clickAnelemnt(cnclWork, "Research provider", "Cancel work"))
			{
				WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(), 10);
				wait.until(ExpectedConditions.visibilityOf(btnSbmt));
				return utils.clickAnelemnt(btnSbmt, "Research Provider", "Submit button");}
		return false;
	}
	/**Verify TIN/NPI Label is available at Research provider task Screen
	 * 
	 * @return
	 */
	
	@FindBy(xpath="//span[text()='TIN/NPI']")
	WebElement TINORNPILabel;
	
	public boolean validateTINOrNPILabelIsAvailable(){
		return !utils.isProxyWebelement(TINORNPILabel);
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
