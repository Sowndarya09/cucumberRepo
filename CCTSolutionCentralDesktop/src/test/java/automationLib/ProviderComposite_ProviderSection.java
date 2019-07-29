package automationLib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

public class ProviderComposite_ProviderSection extends Driver{


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	public ProviderComposite_ProviderSection()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		System.out.println("provider comp constructor");
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		System.out.println("PROVIDER comp frame swithced");
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;

	@FindBy(id="PegaGadget9Ifr")
	WebElement Iframeelement3;
	
	//@FindBy(id="PegaGadget4Ifr")
	//WebElement Iframeelement4;

	@FindBy(xpath="//label[@for='ProviderName']//following-sibling::div//span[@data-test-id='20170821155608018518784']")
	WebElement ProviderNameValue;

	@FindBy(xpath="//label[@for='TIN']//following-sibling::div//span[@data-test-id='20170821155608018518784']")
	WebElement TinValue;

	@FindBy(xpath="//*[@data-test-id='2017092422310108875828']")
	WebElement NpiValue;

	@FindBy(xpath="//label[@for='Speciality']//following-sibling::div//span[@data-test-id='20170821155608018518784']")
	WebElement SpecialityValue;

	@FindBy(xpath="//label[@for='LegacyID']//following-sibling::div//span[@data-test-id='20170821155608018518784']")
	WebElement LegacyIDValue;

	@FindBy(xpath="//label[@for='EffectivePeriod']//following-sibling::div//span[@data-test-id='20170821155608018518784']")
	WebElement EffectivePeriod;

	@FindBy(xpath="//label[@for='Status']//following-sibling::div//span[@data-test-id='20170821155608018518784']")
	WebElement Status;

	@FindBy(xpath="//label[@for='LastUpdatedDate']//following-sibling::div//span[@data-test-id='20170821155608018518784']")
	WebElement LastUpdateDate;

	@FindBy(xpath="//label[@for='AuditFlag']//following-sibling::div//span[@data-test-id='20170821155608018518784']")
	WebElement AuditFlag;

	@FindBy(xpath="//table[@pl_prop_class='Embed-PegaHC-Address']")
	WebElement tblAddress;

	@FindBy(xpath="//span[text()='Address and Contact Information']//ancestor::div[@class='header header-bar clearfix']")
	WebElement lnkAddressAndContactInfo;

	@FindBy(xpath="//div[text()='Change Focus']")
	WebElement changeFocus;

	@FindBy(name="$PpyWorkPage$pSearchNewMember")
	WebElement searchNewMember;

	@FindBy(xpath="//label[text()='Search for new provider']")
	WebElement searchNewProvider;

	@FindBy(name="$PpyWorkPage$pSelectVerifiedMembers")
	WebElement searchPreviouslyVerifiedMember;

	@FindBy(id="SelectVerifiedProviderstrue")
	WebElement searchPreviouslyVerifiedProvider;

	@FindBy(xpath="//button[@data-test-id='201807122330240188681176']")
	WebElement submitButton;

	@FindBy(xpath=" //span[@data-test-id='20170821155608018518784']")
	WebElement SiteID;



	public boolean VerifyProviderGeneralInfo(String[] args) {

		utils.waitforpageload();
		boolean flag =ProviderNameValue.isDisplayed();
		if(!flag)
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement3);
		}

		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ProviderComposite_ProviderSection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			if(utils.isvalueMatch_contain(key.toLowerCase(),"providername")){
				returnvar = utils.validateLabel(ProviderNameValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"tin")){
				returnvar = utils.validateLabel(TinValue,value);
				continue;}
			if(utils.isvalueMatch_contain(key.toLowerCase(),"npi")){
				returnvar = utils.validateLabel(NpiValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"speciality")){
				returnvar = utils.validateLabel(SpecialityValue,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"legacyid")){
				returnvar = utils.validateLabel(LegacyIDValue,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"effectiveperiod")){
				returnvar = utils.validateLabel(EffectivePeriod,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"status")){
				returnvar = utils.validateLabel(Status,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"lastupdatedate")){
				returnvar = utils.validateLabel(LastUpdateDate,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"auditflag")){
				returnvar = utils.validateLabel(AuditFlag,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"SiteID")){
					returnvar = utils.validateLabel(SiteID,value);
					continue;
			}
			else 
				err.logcommonMethodError("ProviderComposite_ProviderSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("Verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ProviderComposite_ProviderSection", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}	
	}


	public boolean VerifyProviderAddressInfo(String[] args)
	{
		return utils.validatetablerowbasedonvalues(tblAddress, args);
	}


	public boolean validateHoverMessage(String[] args) throws InterruptedException {
		WebElement row = utils.returntablerowbasedonvalues(tblAddress, args);
		WebElement ele1 = row.findElement(By.tagName("img"));
		System.out.println("hover" + ele1.getAttribute("data-hover"));
		if(ele1.getAttribute("data-hover").contains("Primary"))
		{
			System.out.println("Hover message validated");
			return true;
		}
		else
		{
			System.out.println("Hover message validation failed");
			return false;
		}


	}

	public boolean expandAddressInfo()
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(lnkAddressAndContactInfo, "Provider Composite ","Provider Composite provider section"))
			if (!utils.isProxyWebelement(tblAddress))
				return true;
					
		return false;
	}

	@FindBy(xpath="//*[@data-test-id='2018062712272700362867']")
	WebElement PopUpMshMemberNotInFocus;
	public boolean validatePopupMessgaeNotDisplayed() {
		return utils.isProxyWebelement(PopUpMshMemberNotInFocus);
	}

	public boolean validateNoMemberInFocusPopupMessgae() {
		utils.waitforpageload();
		return !utils.isProxyWebelement(PopUpMshMemberNotInFocus);
	}

	public boolean clickChangeFocus()
	{
		action.moveToElement(changeFocus);
		return utils.clickAnelemnt(changeFocus, "Provider Composite ","Provider Composite provider section");
	}

	public boolean clickSearchforNewMember()
	{
		return utils.clickAnelemnt(searchNewMember, "Search Member", "Change focus search for new member");
	}

	public boolean clickSearchforNewProvider() throws InterruptedException
	{
		utils.scrolltomiddle();
		utils.scrolltomiddle();
		Thread.sleep(5000);
		return utils.clickAnelemnt(searchNewProvider, "Search Provider", "Change focus search for new Provider");
	}

	public boolean clickSearchfromPreviouslyVerifiedMember(String[] args) throws InterruptedException
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(searchPreviouslyVerifiedMember, "Search Member", "Change focus search for previously verified member"))
			return selectPreviouslyVerifiedMembers(args);
		return false;
	}

	@FindBy(xpath="//table[@pl_prop='D_MembersVerifiedInteraction.pxResults']")
	WebElement tblPreviouslyMembers;

	@FindBy(xpath="//table[@pl_prop='D_ProvidersVerifiedInteraction.pxResults']")
	WebElement tblPreviouslyProviders;


	public boolean selectPreviouslyVerifiedMembers(String[] args) throws InterruptedException
	{
		try
		{
			System.out.println();
			utils.waitforpageload();
			WebElement row = utils.returntablerowbasedonvalues(tblPreviouslyMembers, args);
			List<WebElement> rowno = row.findElements(By.tagName("td"));
			rowno.get(0).click();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("Provider composite", "selectPreviouslyVerifiedMembers", "Table not present");
			return false;
		}


	}

	public boolean selectPreviouslyVerifiedProviders(String[] args) throws InterruptedException
	{
		try
		{	utils.waitforpageload();
		WebElement row = utils.returntablerowbasedonvalues(tblPreviouslyProviders, args);
		List<WebElement> rowno = row.findElements(By.tagName("td"));
		rowno.get(0).click();
		return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("Provider composite", "selectPreviouslyVerifiedMembers", "Table not present");
			return false;
		}


	}


	public boolean clickSearchfromPreviouslyVerifiedProvider(String[] args) throws InterruptedException
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(searchPreviouslyVerifiedProvider, "Search Provider", "Change focus search for previously verified Provider"))
			return selectPreviouslyVerifiedProviders(args);
		return false;
	}

	public boolean clickSubmitInChangeFocusPopUp()
	{
		return utils.clickAnelemnt(submitButton, "Change focus", "Change focus");
	}

	@FindBy(xpath="//*[text()='LegacyID ']//img")
	WebElement hvrLegacyId;

	@FindBy(xpath="//*[@data-test-id='2018070600333000162859']")
	WebElement hvrLegacyIdPopUp;

	public boolean validateLegacyIDHover(String[] args)
	{

		action.moveToElement(hvrLegacyId).build().perform();	
		utils.clickAnelemnt(hvrLegacyId, "ProviderComposite_ProviderSection", "hvrLegacyId");
		//String hvrLegacyActual = hvrLegacyId.getAttribute("aria-label").toLowerCase().trim();
		String hvrLegacyActual = hvrLegacyIdPopUp.getText().trim();
		System.out.println("Actual legacy ID "+hvrLegacyActual.toLowerCase().trim().replaceAll(",",""));
		String hvrLegacyExpected = args[0].toLowerCase();
		System.out.println("Expected legacy ID "+hvrLegacyExpected);
		if(utils.isvalueMatch_contain(hvrLegacyActual, hvrLegacyExpected))
			return true;
		return false;
	}

	@FindBy(linkText = "More")
	WebElement moreBUtton;

	public boolean clickMoreHyperlink()
	{
		return utils.clickAnelemnt(moreBUtton, "Provider composite provider section", "Provider composite provider section");
	}

	@FindBy(xpath="//label[@for='W9Date']/following-sibling::div/span[@data-test-id='20170821155608018518784']")
	WebElement w9Date;

	@FindBy(xpath="//label[@for='TaxonomyCode']/following-sibling::div/span[@data-test-id='20170821155608018518784']")
	WebElement taxonomy;

	@FindBy(xpath="//label[@for='MppId']/following-sibling::div/span[@data-test-id='20170821155608018518784']")
	WebElement mppID;

	@FindBy(xpath="//label[@for='Gender']/following-sibling::div/span[@data-test-id='20170821155608018518784']")
	WebElement gender;

	@FindBy(xpath="//label[@for='Language']/following-sibling::div/span[@data-test-id='20170821155608018518784']")
	WebElement language;

	@FindBy(xpath="//label[@for='MedicalSchool']/following-sibling::div/span[@data-test-id='20170821155608018518784']")
	WebElement medicalSchool;

	@FindBy(xpath="//label[@for='DEANumber']/following-sibling::div/span[@data-test-id='20170821155608018518784']")
	WebElement DEANumber;

	@FindBy(xpath="//label[@for='DEAExpirationDate']/following-sibling::div/span[@data-test-id='20170821155608018518784']")
	WebElement DEAExpirationDate;



	public boolean validateProviderInfoPopup(String[] args)
	{
		boolean returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{

			if(!returnvar )
			{
				err.logcommonMethodError("ProviderComposite_providerSection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			if(utils.isvalueMatch_contain(key, "w9 date")) {
				returnvar = utils.validateLabel(w9Date,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Taxonomy Code")){
				returnvar = utils.validateLabel(taxonomy,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"MPP ID")){
				returnvar = utils.validateLabel(mppID,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Gender")){
				returnvar = utils.validateLabel(gender,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Language")){
				returnvar = utils.validateLabel(language,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Medical School")){
				returnvar = utils.validateLabel(medicalSchool,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"DEA Number")){
				returnvar = utils.validateLabel(DEANumber,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"DEA Expiration")){
				returnvar = utils.validateLabel(DEAExpirationDate,value);
				continue;
			}
			else 
				err.logcommonMethodError("ProviderComposite_providerSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("Provider attributes  info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ProviderComposite_ProviderSection", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	@FindBy(xpath="//span[text()='Affiliations']")
	WebElement affiliations;

	public boolean expandAffiliationsInfo() {
		return utils.clickAnelemnt(affiliations, "ProviderComposite_providerSection", "Affiliation section");
	}

	@FindBy(xpath="//a[@data-test-id='20180710212357045715739']")
	WebElement changeFocusLink;

	public boolean clickChangeFocusinAffiliationRecord(String[] args)
	{
		utils.waitforpageload();
		utils.waitForElementToBeVisible(changeFocusLink);
		boolean returnvar= true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar )
			{
				err.logcommonMethodError("ProviderComposite_providerSection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			if(utils.isvalueMatch_contain(key.toLowerCase(), "tax id")) {
				returnvar = utils.clickAnelemnt(changeFocusLink, "ProviderComposite_providerSection", "Change focus");
			}else if(utils.isvalueMatch_contain(key.toLowerCase(), "business name"))
			{
				returnvar = utils.clickAnelemnt(changeFocusLink, "ProviderComposite_providerSection", "Change focus");
			}else if(utils.isvalueMatch_contain(key.toLowerCase(), "affiliation type"))
			{
				returnvar = utils.clickAnelemnt(changeFocusLink, "ProviderComposite_providerSection", "Change focus");
			}else if(utils.isvalueMatch_contain(key.toLowerCase(), "practitioner name"))
			{
				returnvar = utils.clickAnelemnt(changeFocusLink, "ProviderComposite_providerSection", "Change focus");
			}else if(utils.isvalueMatch_contain(key.toLowerCase(), "npi"))
			{
				returnvar = utils.clickAnelemnt(changeFocusLink, "ProviderComposite_providerSection", "Change focus");
			}else if(utils.isvalueMatch_contain(key.toLowerCase(), "title"))
			{
				returnvar = utils.clickAnelemnt(changeFocusLink, "ProviderComposite_providerSection", "Change focus");

			}else if(utils.isvalueMatch_contain(key.toLowerCase(), "speciality description board certified"))
			{
				returnvar = utils.clickAnelemnt(changeFocusLink, "ProviderComposite_providerSection", "Change focus");
			}
			else
			{
				err.logcommonMethodError("ProviderComposite_providerSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("Change focus is clicked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ProviderComposite_ProviderSection", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	@FindBy(xpath="//span[text()='Network Information']")
	WebElement NetworkInformationLink;

	public boolean expandNetworkInfo() {
		utils.waitforpageload();
		return utils.clickAnelemnt(NetworkInformationLink, "ProviderComposite_ProviderSection", "NetworkInformationLink");
	}

	@FindBy(xpath="//*[text()='ORG IND']/ancestor::table[@id='gridLayoutTable']")
	WebElement NetworkInfoTable;

	public boolean VerifyProviderNetworkInfo(String args[]) {
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(NetworkInfoTable, args);
	}

	@FindBy(xpath="//button[@data-test-id='201411140227290027156488']")
	WebElement btnCancel;

	public boolean clickCancelInChangeFocusPopUp()
	{
		return utils.clickAnelemnt(btnCancel, "Change focus popup", "Cancel button");
	}

	@FindBy(xpath="//*[@pl_prop_class='PegaHC-Data-ProviderContractProducts']")
	WebElement netwrokHMO;

	public boolean validateHMOProviderNetworkInformation(String[] args)
	{
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(netwrokHMO, args);
	}

	@FindBy(xpath="//img[@data-test-id='201707121205450500113660']")
	WebElement hvrPvp;

	@FindBy(xpath="//*[@class='pz-po-c smarttip-container']")
	WebElement hvrPvpMsg;

	public boolean  validatePVTPHover() {

		Actions action = new Actions(Driver.getPgDriver());
		action.moveToElement(hvrPvp).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(), 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(hvrPvpMsg));
		System.out.println("hover text actual :"+hvrPvpMsg.getText());
		String acText = hvrPvpMsg.getText();
		return utils.isvalueMatch_compareto(acText, "PVTP/DOFR is the financial arrangement that Anthem has with the provider");
	}
	/* To click TIN Hyperlink*/
	
	@FindBy(xpath="//a[@data-test-id='2018102900312805961684']")
	private WebElement TINHyperlink;
	
	public boolean clickOnTINHyperlink() {
		return utils.clickAnelemnt(TINHyperlink, "ProviderComposite_ProviderSection", "TINHyperlink");
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
			//if(title.contains("Display Prior Auth Pass"))
				System.out.println("Window switched");
				if(utils.validateLabel(ProviderTaxIdentifier, "123456789"))
					if(utils.validatetablerowbasedonvalues(tblProviderPriorAuthPass, args))
						return true;			
				return false;
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
				if(utils.clickAnelemnt(ApplyBtn, "ResearchProvider", "ApplyBtn"))
					return true;
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

	public boolean validateNoMemberInFocusPopupMessgaeNotDisplayed() {
		utils.waitforpageload();
		return utils.isProxyWebelement(PopUpMshMemberNotInFocus);
	}

	@FindBy(xpath="//table[@pl_prop='D_Affiliations.pxResults']")
	WebElement tblAffiliatedProv;
	
	public boolean expandAffiliatedRecord(String[] args) throws InterruptedException
	{
		return utils.clickontablerowbasedonvalues(tblAffiliatedProv, args);
	}
	
	@FindBy(xpath="//table[@pl_prop='.AddressList']")
	WebElement tblAddressAffiliated;
	
	public boolean validateAffiliatedProviderAddress(String[] args)
	{
		return utils.validatetablerowbasedonvalues(tblAddressAffiliated, args);
	}
	 
	@FindBy(xpath="//div[text()='ACA PAR/NPAR']")
	WebElement acaparnpar;
 
	public boolean clickACAParNpar()
	 {
		 return utils.clickAnelemnt(acaparnpar, "ProviderComposite_ProviderSection", "acaparnpar");
	 }
	 
	@FindBy(xpath="//div[@data-test-id='201903052045310444344698']")
	WebElement parnparmessage;
	
	public boolean validateACAParNparMessage(String[] args)
	{
		String actaulMsg = args[0];
		String expectedMsg = parnparmessage.getText();
		return utils.isvalueMatch_contain(actaulMsg, expectedMsg);

	}
	
	@FindBy(xpath="//*[@data-test-id='20170920205241046333557']")
	WebElement primaryflag;
	
	public boolean validateHovericon()
	{
	
		return !(utils.isProxyWebelement(primaryflag));
	}


@FindBy(xpath="//label[text()='HMO']")
WebElement HMOcheckbox;

public boolean clickHMOCheckboxInChangeFocusPopUp() {
	return utils.clickAnelemnt(HMOcheckbox, "ProviderComposite_ProviderSection", "HMOcheckbox");
}
 
@FindBy(xpath="//label[text()='Site ID']")
WebElement RdoBtnSiteID;

@FindBy(xpath="//input[@id='SearchStringSiteID']")
WebElement TxtBoxSiteID;

@FindBy(xpath="//div[text()='Search']")
WebElement BtnsearchButton;

@FindBy(xpath="//div[text()='Collapse']")
WebElement Btncollapse;

public boolean searchBySiteID(String[] args) {
	Driver.pgDriver.switchTo().defaultContent();
	if(utils.clickAnelemnt(Btncollapse, "ProviderComposite_ProviderSection", "Btncollapse"))
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		if(utils.scrolltomiddle())
		utils.waitforpageload();
	if(utils.clickAnelemnt(RdoBtnSiteID, "ProviderComposite_ProviderSection", "RdoBtnSiteID"))
	if(utils.enterTextinAnelemnt(TxtBoxSiteID, args[0], "ProviderComposite_ProviderSection", "TxtBoxSiteID"))	
				 if(utils.clickAnelemnt(BtnsearchButton, "ProviderComposite_ProviderSection", "BtnsearchButton"))
				return true;
	return false;
} 

@FindBy(xpath="//label[text()='PCP ID']")
WebElement RdoBtnPCPID;

@FindBy(xpath="//input[@id='SearchStringPCPID']")
WebElement TxtBoxPCPID;

public boolean searchByPCPID(String[] args) {
	Driver.pgDriver.switchTo().defaultContent();
	if(utils.clickAnelemnt(Btncollapse, "ProviderComposite_ProviderSection", "Btncollapse"))
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		if(utils.scrolltomiddle())
		utils.waitforpageload();
	if(utils.clickAnelemnt(RdoBtnPCPID, "ProviderComposite_ProviderSection", "RdoBtnPCPID"))
	if(utils.enterTextinAnelemnt(TxtBoxPCPID, args[0], "ProviderComposite_ProviderSection", "TxtBoxPCPID"))	
				 if(utils.clickAnelemnt(BtnsearchButton, "ProviderComposite_ProviderSection", "BtnsearchButton"))
				return true;
	return false;
} 

@FindBy(xpath="//input[@id='SearchStringNPI']")
WebElement TxtBoxNPI;

public boolean searchByNPI(String[] args) {
	Driver.pgDriver.switchTo().defaultContent();
	if(utils.clickAnelemnt(Btncollapse, "ProviderComposite_ProviderSection", "Btncollapse"))
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		if(utils.scrolltomiddle())
		utils.waitforpageload();
	if(utils.enterTextinAnelemnt(TxtBoxNPI, args[0], "ProviderComposite_ProviderSection", "TxtBoxNPI"))	
				 if(utils.clickAnelemnt(BtnsearchButton, "ProviderComposite_ProviderSection", "BtnsearchButton"))
				return true;
	return false;
} 
@FindBy(xpath="//input[@id='CaseOrTaskIcon']")
WebElement radioButton;

@FindBy(xpath="//div[text()='Submit']")
WebElement btnSubmitbutton;

public boolean selectfirstProvider(){
	if(utils.clickAnelemnt(radioButton, "ProviderComposite_Provider Section", "Radio button -	firstRowofselectMembertable"))
		utils.scrolltomiddle();
		return utils.clickAnelemnt(btnSubmitbutton, "ProviderComposite_Provider Section", "Button for Submit");
}
}
  





