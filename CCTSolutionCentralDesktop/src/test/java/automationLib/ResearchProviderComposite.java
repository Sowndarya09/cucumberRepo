package automationLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResearchProviderComposite {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;

	public ResearchProviderComposite() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement);
	}

	@FindBy(xpath="//a[text()='More']")
	WebElement MoreLink;

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[text()='Address and Contact Information']")
	WebElement AddressContactInfo;

	@FindBy(xpath="//*[text()='W9 Date']/ancestor::td[@class='dataLabelWrite']//*[text()='Cancel']")
	WebElement CancelLinkPopUp;

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[text()='Network Information']")
	WebElement NetworkInfoLink;

	public boolean expandGeneralInfo() {
		return true;
	}

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[@data-test-id='20170821155608018518784']")
	WebElement ProviderName;

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[text()='TIN']/..//*[@data-test-id='20170821155608018518784']")
	WebElement TIN;

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[text()='NPI']/..//*[@data-test-id='2017092422310108875828']")
	WebElement NPI;

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[text()='Speciality']/..//*[@data-test-id='20170821155608018518784']")
	WebElement Speciality;

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[text()='Effective Period']/..//*[@data-test-id='20170821155608018518784']")
	WebElement EffectivePeriod;

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[text()='Status']/..//*[@data-test-id='20170821155608018518784']")
	WebElement Status;

	@FindBy(xpath="//*[contains(text(),'Research Provider Composite')]/ancestor::*[@class='content layout-content-simple_list content-simple_list  ']//*[text()='Last Update Date']/..//*[@data-test-id='20170821155608018518784']")
	WebElement LastUpdateDate;

	public boolean VerifyProviderGeneralInfo(String[] args) {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(utils.isvalueMatch_contain(key, "ProviderName")) {
				returnvar = utils.validateLabel(ProviderName,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"TIN")){
				returnvar = utils.validateLabel(TIN,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"NPI")){
				returnvar = utils.validateLabel(NPI,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Speciality")){
				returnvar = utils.validateLabel(Speciality,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"EffectivePeriod")){
				returnvar = utils.validateLabel(EffectivePeriod,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Status")){
				returnvar = utils.validateLabel(Status,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"LastUpdateDate")){
				returnvar = utils.validateLabel(LastUpdateDate,value);
				continue;}
			else 
				err.logcommonMethodError("ResearchProviderComposite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar)
			return true;	
		else
			return false;
	}

	public boolean clickMoreHyperlink() {
		return utils.clickAnelemnt(MoreLink, "ResearchProviderComposite", "MoreLink");
	}

	@FindBy(xpath="//*[text()='W9 Date']/../..//*[@data-test-id='20170821155608018518784']")
	WebElement W9DateInpopUp;

	public boolean validateProviderInfoPopup(String[] args) {
		return utils.validateLabel(W9DateInpopUp, args[0]);
	}

	public boolean clickCancelinProviderInfoPopup() {
		return utils.clickAnelemnt(CancelLinkPopUp, "ResearchProviderComposite", "CancelLinkPopUp");
	}

	public boolean expandAddressInfo() {
		return utils.clickAnelemnt(AddressContactInfo, "ResearchProviderComposite", "AddressContactInfo");
	}

	@FindBy(xpath="//*[@aria-label='Hide Address and Contact Information']/../..//*[text()='Type']/ancestor::table[@id='gridLayoutTable']")
	WebElement AddressTable;

	public boolean VerifyProviderAddressInfo(String[] args) {
		return utils.validatetablerowbasedonvalues(AddressTable, args);
	}

	@FindBy(xpath="//*[@data-test-id='20170920205241046333557']")
	WebElement HoverIcon;

	public boolean validateHovericon() {
		return !utils.isProxyWebelement(HoverIcon);
	}

	@FindBy(xpath="//*[@class='smarttip-content']")
	WebElement HoverSmartTip;
	
	public boolean validateHoverMessage(String[] args) throws InterruptedException {
		utils.clickAnelemnt(HoverIcon, "ResearchProviderComposite", "HoverIcon");
		return utils.validateLabel(HoverSmartTip, "Primary");
	}

	public boolean expandNetworkInfo() {
		return utils.clickAnelemnt(NetworkInfoLink, "ResearchProviderComposite", "NetworkInfoLink");
	}

	@FindBy(xpath="//*[text()='ORG IND']/ancestor::table[@id='gridLayoutTable']")
	WebElement NetworkTable;

	public boolean VerifyProviderNetworkInfo(String[] args) {
		return utils.validatetablerowbasedonvalues(NetworkTable, args);
	}
	/* To click TIN Hyperlink*/

	@FindBy(xpath="//a[@data-test-id='2018102900312805961684']")
	private WebElement TINHyperlink;
	
	public boolean clickOnTINHyperlink() {
		return utils.clickAnelemnt(TINHyperlink, "ResearchProviderComposite", "TINHyperlink");
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
			if(utils.clickAnelemnt(ProcedureCodeCheckbox, "ResearchProvider", "ProcedureCodeCheckbox")){
				if(utils.clickAnelemnt(ApplyBtn, "ResearchProvider", "ApplyBtn"))
					return true;
			}
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
	
	@FindBy(id="ReasonForContact")
	WebElement ReasonForContact;

	/**This functionality validates the Reason For Contact dropdown options are available or not in the Research Provider Review  Page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateReasonForContactDropDownValuses(String[] args) {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		
		for(String valuestobeadded:args)
			valuestobechecked.add(valuestobeadded);
		
		return utils.checkvaluesinDropDown(ReasonForContact, valuestobechecked);
	}
	
	/**This functionality selects Reason for contact from Reason for contact Drop down in Research Provider Review page
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectReasonForContact(String[] args) {
		return utils.selectDropDownbyVisibleString(ReasonForContact, args[0], "ResearchProvider", "ReasonForContact");
	}
	
	@FindBy(id="Notes")
	WebElement Notes;
	
	/**This method enters the Notes in the Research Provider Review Page
	 * 
	 * @param args
	 * @return
	 */
	public boolean enterNotes(String[] args) {
		return utils.enterTextinAnelemnt(Notes, args[0], "ResearchProvider", "Notes");
	}
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement Submit;
	
	/**This method clicks on submit button in Research Provider Page
	 * 
	 * @return
	 */
	public boolean clickOnSubmit() {
		return utils.clickAnelemnt(Submit, "ResearchProvider", "Submit");
	}

	@FindBy(xpath="//div[@node_name='ResearchProvCompositeWrapper']//div[@role='tablist']//h3[text()='HMO']")
	WebElement tabHMOCompositeGroup;

	public boolean clickHMOTab() {
		utils.waitforpageload();
		return utils.clickAnelemnt(this.tabHMOCompositeGroup, "Research Provider Composite ", "HMO tab");
	}

}
