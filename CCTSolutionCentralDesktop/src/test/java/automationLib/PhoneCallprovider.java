package automationLib;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.ArrayList;

import org.apache.poi.util.SystemOutLogger;
import org.jboss.netty.util.internal.SystemPropertyUtil;
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

public class PhoneCallprovider {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);


	public PhoneCallprovider()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//span[text()='Search for Provider']")
	private WebElement lblSearchProvider;

	@FindBy(id = "CallerType")
	private WebElement txtbxcallerType;

	@FindBy(id = "OfficeName")
	private WebElement txtbxproviderName;

	@FindBy(id = "FirstNameProvider")
	private WebElement txtbxfirstName;

	@FindBy(id = "CallBackNumber")
	private WebElement txtbxcallBackNumber;

	@FindBy(xpath = "//*[text()='Search']")
	private WebElement BtnsearchButton;

	@FindBy(id = "SearchStringNPI")
	private WebElement txtbxsearchStringNPI;

	@FindBy(xpath = "//*[@name='$PpyWorkPage$pProvState']")
	private WebElement txtbxsearchState;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:createNewInteractionResearchmember
	 * Type:Textbox

	 */


	public boolean validateSearchproviderpage(){
		return (!utils.isProxyWebelement(this.lblSearchProvider));
	}

	public boolean setFirstNameInProvider(String args) {
		return utils.enterTextinAnelemnt(txtbxfirstName, args, "Phone Call", "Text Box Last Name");
	}

	public boolean setCallerPhoneInProvider(String args) {
		return utils.enterTextinAnelemnt(txtbxcallBackNumber, args, "Phone Call", "Text Box CallerPhone");
	}

	public boolean setProviderNameInProvider(String args) {
		return utils.enterTextinAnelemnt(txtbxproviderName, args, "Phone Call", "Text Box providername");
	}

	public boolean setProviderNPI(String NPI) {
		return utils.enterTextinAnelemnt(txtbxsearchStringNPI, NPI, "Phone Call", "Text Box NPI");
	}

	public boolean setTxtStateName(String string) {
		return utils.enterTextinAnelemnt(txtbxsearchState, string, "Phone Call", "Enter State");
	}

	@FindBy(xpath = "//table[@pl_prop='ProviderList.pxResults']")
	private WebElement searchResulttable;

	public ArrayList<String> getsearchResultbyColumn(String columnName) {
		ArrayList<String> returnColumn = new ArrayList<String>();
		returnColumn = utils.getcolumnStringFromTableByName(searchResulttable, columnName);
		return returnColumn;
	}

	public boolean selectProviderByName(String[] args) {
		utils.waitforpageload();
		String[] valuetobechose = { "Provider Name:" + args[0] };
		try {
			if(utils.clickontablerowbasedonvalues(this.searchResulttable, valuetobechose))
				if(verifyProviderDetailsWithoutData())
					return clickSubmitButton();
			return false;
		} catch (Exception e) {
			err.logcommonMethodError("Phone call Search provider", "selectProviderbyName");
			return false;
		}

	}

	@FindBy(xpath = "//button[@title='Complete this assignment']")
	private WebElement btnSubmitButton;

	public boolean clickSubmitButton() {
		utils.scrolltomiddle();
		return utils.clickAnelemnt(btnSubmitButton, "Phone Call", "Button for Submit");
	}

	@FindBy(id="CaseOrTaskIcon")
	WebElement radioButton;

	public boolean selectfirstProvider(){
		try{
			if(utils.clickAnelemnt(radioButton, "SelectMember", "Radio button -	firstRowofselectMembertable")) 
				if(verifyProviderDetailsWithoutData()) {
					utils.scrolltomiddle();
					((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", btnSubmitButton);
				}
			utils.scrolltomiddle();
			return utils.clickAnelemnt(btnSubmitButton, "Phone Call", "Button for Submit");
		}catch(Exception e){
			blogger.loginfo("Exception occured while selecting first member"+e);
			return false;
		}
	}

	public boolean searchAndSubmitProvider(String[] args) {
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
		if(utils.selectDropDownbyVisibleString(txtbxcallerType, "Billing Office", "Phone Call","Drop Down CallerType"))
			if(setFirstNameInProvider("FirstName"))
				if(setCallerPhoneInProvider("1234567890"))
					if(setProviderNameInProvider("Provider Name"))
						if(setProviderNPI(npi))
							if(setTxtStateName(state))
								if(utils.clickAnelemnt(BtnsearchButton, "Phone Call", "Button Search"))
									if(firstname!=null) {
										String[] providerfirstname = firstname.split(",");
										selectProviderByName(providerfirstname);
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

	public boolean verifyProviderDetailsWithoutData()
	{
		try
		{
			utils.waitforpageload();
			boolean flag = false;
			if(clickCheckBoxProviderName())
				if(clickCheckBoxNPIorTIN())
					flag=true;
			if(flag) {
				blogger.loginfo("PASS: verifyProviderDetailsWithoutData successful");
				return true;
			}
			else {
				blogger.loginfo("FAIL: verifyProviderDetailsWithoutData not successful");
				return false;
			}
		}catch(Exception e)
		{
			err.logError("VerifyProvider", "Provider Verification");
			return false;
		}
	}

	@FindBy(id = "IsProviderNameVerified")
	WebElement chkbxVerificationProvidernameverify;

	@FindBy(id="IsNPIVerified")
	WebElement NPICheckbox;

	@FindBy(id="IsTINVerified")
	WebElement TINCheckbox;

	public boolean clickCheckBoxProviderName()
	{
		if(!chkbxVerificationProvidernameverify.isSelected())
			return utils.clickAnelemnt(chkbxVerificationProvidernameverify, "ProviderVerify", "Provider name verify checkbox");;
		return false;		
	}

	public boolean clickCheckBoxNPIorTIN()
	{
		if(NPICheckbox.getAttribute("disabled") == null)
			if(!NPICheckbox.isSelected())
				return utils.clickAnelemnt(NPICheckbox, "ProviderVerify", "Provider name verify checkbox");
			else
				if(!TINCheckbox.isSelected())
					return utils.clickAnelemnt(TINCheckbox, "ProviderVerify", "Provider name verify checkbox");
		return true;
	}

}
