package automationLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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

public class BrokerComposite_ContractSection extends Driver{


	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();

	WebDriverWait wait;
	
	public BrokerComposite_ContractSection()
	
	{
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			if(utils.isAlertPresent())
			{
				Driver.pgDriver.switchTo().alert().accept();
			}
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);

		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement); 
		}
	}
	

	//BrokerCompositeTab
	
	
	
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	
	//CONTRACT TAB
	
	@FindBy(xpath="//span[text()='Subscriber Information']")
	WebElement lnkBrkrCompositeSbrInfo;
	
	@FindBy(xpath="//span[text()='Plan Rules & Administration']")
	WebElement lnkBrkrCompositeSbrPlanRulesAdmin;
	
	@FindBy(xpath="//span[text()='Vendor Information']")
	WebElement lnkBrkrCompositeSbrVendorInfo;
	
	@FindBy(xpath="//span[text()='Reference Based Benefits']")
	WebElement lnkBrkrCompositeSbrRefBasedObjects;
	
	@FindBy(xpath="//span[text()='AIM Specialty Health']")
	WebElement lnkBrkrCompositeSbrAIMSpecialityHealth;
	
	@FindBy(xpath="//span[text()='Consumer Driven Health Plan' and @class='header-element header-title']")
	WebElement lnkBrkrCompositeSbrCDHP;
	
	@FindBy(xpath="//span[text()='Other']")
	WebElement lnkBrkrCompositeSbrOther;
	
	@FindBy(xpath="//span[text()='Contract Notes']")
	WebElement lnkBrkrCompositeSbrContractNotes;
	
	@FindBy(xpath="//span[text()='Eligibility Determination']")
	WebElement lnkBrkrCompositeSbrEligibilityDetermination;
	
	@FindBy(xpath="//span[text()='Contract Addresses']")
	WebElement lnkBrkrCompositeSbrContractAddresses;
	
	@FindBy(xpath="//span[text()='Members']")
	WebElement lnkBrkrCompositeSbrMembers;
	
	@FindBy(xpath="//span[text()='Related Contracts']")
	WebElement lnkBrkrCompositeSbrRelatedContracts;
	
	//SUBSCRIBER INFORMATION
	
	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='pyFullName']/parent::div//span")
	WebElement labelBrkrCompositeSbrName;
	
	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='DateOfBirth']/parent::div//span")
	WebElement labelBrkrCompositeSbrDOB;
	
	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='Age']/parent::div//span")
	WebElement labelBrkrCompositeSbrAge;
	
	@FindBy(xpath="(//div[@node_name='SubscriberDetailInformation']//label[@for='Gender']/parent::div//span)[1]")
	WebElement labelBrkrCompositeSbrGender;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='PolicyState']/parent::div//span//span[@data-test-id='2015020305565609188735']")
	WebElement labelBrkrCompositeSbrPolicyState;
	
	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='SubscriberEffecDate']/parent::div//span")
	WebElement labelBrkrCompositeSbrEffDate;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='SubscriberEndDate']/parent::div//div")
	WebElement labelBrkrCompositeSbrTerminationDate;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//span[text()='PPO PRUDENT BUYER INCENTIVE']/parent::div//span")
	WebElement labelBrkrCompositeSbrProdType;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='ContractCode']/parent::div//span")
	WebElement labelBrkrCompositeSbrCntrctCode;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='CoverageType']/parent::div//span")
	WebElement labelBrkrCompositeSbrCoverageType;
	
	@FindBy(xpath="//*[contains(@class,'content-item content-field item-10')]//*[@data-test-id='20150914102046032213295']")
	WebElement labelBrkrCompositeSbrBenefitPeriod;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='AsOfDt']/parent::div//span")
	WebElement labelBrkrCompositeSbrAsOfDate;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='GroupNumber']/parent::div//span")
	WebElement labelBrkrCompositeSbrGroupNumber;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='AntmCompanyCodeName']/parent::div//span[@data-test-id='20170313150810029741745']")
	WebElement labelBrkrCompositeSbrAntmCompanyCodeName;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='NetworkName']/parent::div//span[@data-test-id='20170313150810029741745']")
	WebElement labelBrkrCompositeSbrNetworkName;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='HireDate']/parent::div//div")
	WebElement labelBrkrCompositeSbrHireDate;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='DateOfBirth']/parent::div//div")
	WebElement labelBrkrCompositeSbrDateOfBirth;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='GroupTypeDescription']/parent::div//div")
	WebElement labelBrkrCompositeSbrEmployeeGroupType;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='ExemptTypeCode']/parent::div//div")
	WebElement labelBrkrCompositeSbrReligiousIndicator;
	
	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='ExemptEffPeriod']/parent::div//div")
	WebElement labelBrkrCompositeSbrEffDateTermDate;
	
	//PLAN RULES AND ADMINISTRATION
	
	@FindBy(xpath="//div[@node_name='ClaimFilingLimit']//label[@for='GrandFatherStatus']/parent::div//div")
	WebElement labelBrkrCompositePRAACAGrandfathered;
	
	@FindBy(xpath="//div[@node_name='ClaimFilingLimit']//label[@for='ClaimFilingLimit']/parent::div//span")
	WebElement labelBrkrCompositePRASubmitClaimsWithin;
	
	@FindBy(xpath="//div[@node_name='ClaimFilingLimit']//label[@for='DependentmaxAgeLimit']/parent::div//span")
	WebElement labelBrkrCompositePRADependentMaxAgeLimit;
	
	//ELIGIBILITY DETERMINATION
	
	@FindBy(xpath="//div[@node_name='ContractEligibilityDetermination']/parent::div//table[@class='gridTable ']")
	WebElement tableBrkrCompositeSbrElgDetermination;
	
	//CONTRACT ADDRESSS
	
	@FindBy(xpath="//div[@node_name='ContractAddressList']/parent::div//table[@pl_prop='.Address']")
	WebElement tableBrkrCompositeSbrContractAddresses;
	
	//CONTRACT PHONE NUMBERS
	
	@FindBy(xpath="//div[@node_name='ContractAddressList']/parent::div//table[@pl_prop='.PhoneCommunication']")
	WebElement tableBrkrCompositeSbrContractPhNumbers;
	
	//MEMBERS
	
	@FindBy(xpath="//div[@node_name='MembersWithCoverageInFocus']/parent::div//table[@class='gridTable ']")
	WebElement tableBrkrCompositeSbrMembers;
	
	//RELATED CONTRACTS
	
	@FindBy(xpath="//div[@node_name='RelatedContracts']/parent::div//table[@class='gridTable ']")
	WebElement tableBrkrCompositeRelatedContracts;
	
	
	/*
	 * @SCU
	 * CommonMethodWithArgument: verifySubscriberGeneralInformation
	 * #Description: This functionality validates the subscriber general information in the contract section.
	 * #Argument: congeninfodetils
	 * Type: Table
	 * Keys:#SubscriberName#Age#Gender#PolicyBasedOutOf#EffectiveDate#TerminationDate#SubscriberProductType#ContractCode#CoverageType#BenefitPeriod#AsOfDate#GroupNumber#AnthemCompanyCodeName#NetworkName#HireDate#DateofBirth#Employee/GroupType#ReligiousIndicator#EffDate/TermDate  
	 */
	
	public boolean verifySubscriberInformation(String[] congeninfoDetails)
	{
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";
		utils.scrolltomiddle();
		
		
		
		for(String iterator : congeninfoDetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("Broker Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().equalsIgnoreCase("subscriberName")){
				returnvar = this.labelBrkrCompositeSbrName.getText().toLowerCase().contains(value);			
				continue;}
			else if(key.toLowerCase().equalsIgnoreCase("dob")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrDOB, value);
				continue;}
			else if(key.toLowerCase().equalsIgnoreCase("age")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrAge, value);
				continue;}
			else if(key.toLowerCase().equalsIgnoreCase("Gender")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrGender, value);
				continue;
			}
			else if(key.toLowerCase().equalsIgnoreCase("PolicyBasedOutOf")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrPolicyState, value);
				continue;
			}

			else if(key.toLowerCase().equalsIgnoreCase("EffectiveDate")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrEffDate, value);
				continue;
			}

			else if(key.toLowerCase().equalsIgnoreCase("TerminationDate")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrTerminationDate, value);

				continue;
			}
			else if(key.toLowerCase().equalsIgnoreCase("SubscriberProductType")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrProdType, value);

				continue;
			}
			else if(key.toLowerCase().equalsIgnoreCase("ContractCode")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrCntrctCode, value);
				continue;
			}
			else if(key.toLowerCase().equalsIgnoreCase("CoverageType")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrCoverageType, value);
				continue;
			}
			else if(key.toLowerCase().equalsIgnoreCase("BenefitPeriod")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrBenefitPeriod, value);
				continue;
			}
			else if(key.toLowerCase().equalsIgnoreCase("AsOfDate")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrAsOfDate, value);
				continue;
			}
			else if(key.toLowerCase().equalsIgnoreCase("GroupNumber")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrGroupNumber, value);
				continue;
			}
			else if(key.toLowerCase().equalsIgnoreCase("AnthemCompanyCodeName")){
				returnvar = utils.validateLabel(labelBrkrCompositeSbrAntmCompanyCodeName, value);
				continue;
			}

			else if(key.toLowerCase().equalsIgnoreCase("Employee/GroupType")) {
				returnvar = utils.validateLabel(labelBrkrCompositeSbrEmployeeGroupType, value);
				continue;
			}		
			else 
				err.logcommonMethodError("Broker Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("Subscriber info verified successfully");
			return true;	
		}
		else
		{
			int tot_i=congeninfoDetails.length;
			err.logcommonMethodError("Broker Composite", "the value "+congeninfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}
	
	
	/**
	 * To verify the field and value populated under Plan rules and administration at contract tab
	 * @param congeninfoDetails
	 * @return
	 */
	
	
	public boolean verifyPlanRulesAndAdministration(String[] congeninfoDetails)
	{
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";
		utils.scrolltomiddle();
		utils.clickAnelemnt(lnkBrkrCompositeSbrPlanRulesAdmin,"BrokerComposite_ContractSection","Expand PRAA");
		
		for(String iterator : congeninfoDetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("Broker Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().equalsIgnoreCase("ACAGrandfathered")){
				returnvar = utils.validateLabel(labelBrkrCompositePRAACAGrandfathered, value);
				continue;}
			else if(key.toLowerCase().equalsIgnoreCase("SubmitClaimsWithin")){
				returnvar = utils.validateLabel(labelBrkrCompositePRASubmitClaimsWithin, value);
				continue;}
			else if(key.toLowerCase().equalsIgnoreCase("DependentMaxAgeLimit")){
				returnvar = utils.validateLabel(labelBrkrCompositePRADependentMaxAgeLimit, value);
				continue;
			}
			else 
				err.logcommonMethodError("Broker Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		//err.logError("Member Composite", "Contract tab ");

		if(returnvar)
		{
			System.out.println("Plan rules and administration info verified successfully");
			return true;	
		}
		else
		{
			int tot_i=congeninfoDetails.length;
			err.logcommonMethodError("Broker Composite", "the value "+congeninfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}
	
	/**
	 * To verify the sections present under the vendor information subsection
	 * @param congeninfoDetails
	 * @return
	 */
	
	public boolean verifyVendorInformationSubSections()
	{
		
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(lnkBrkrCompositeSbrVendorInfo,"BrokerComposite_ContractSection","Expand VendorInfo"))
			if((!utils.isProxyWebelement(lnkBrkrCompositeSbrRefBasedObjects)) && (!utils.isProxyWebelement(lnkBrkrCompositeSbrAIMSpecialityHealth)) &&  (!utils.isProxyWebelement(lnkBrkrCompositeSbrCDHP)) && (!utils.isProxyWebelement(lnkBrkrCompositeSbrOther)))
				return true;
		return false;
	
	
	}
	
	/**
	 * To verify Contract notes sub section is present
	 * @param congeninfoDetails
	 * @return
	 */
	
	public boolean verifyContractNotesIsPresent()
	{
		utils.scrolltomiddle();
			if(!utils.isProxyWebelement(lnkBrkrCompositeSbrContractNotes))
				return true;
		return false;
	}
	
	
	/**
	 * To verify table values of eligibility determination
	 * @param congeninfoDetails
	 * @return
	 */
	
	public boolean verifyEligibilityDetermination(String[] congeninfoDetails)
	
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(lnkBrkrCompositeSbrEligibilityDetermination,"BrokerComposite_ContractSection","Expand EligibiltyDetermination"))
		if(utils.validatetablerowbasedonvalues(tableBrkrCompositeSbrElgDetermination, congeninfoDetails))
			return true;
		return false;
	}
	
	
	/**
	 * To verify table values of contact addresses and phone numbers
	 * @param congeninfoDetails
	 * @return
	 */
	
	public boolean verifyContractAddresses(String[] congeninfoDetails)
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(lnkBrkrCompositeSbrContractAddresses, "BrokerComposite_ContractSection", "Expand CntractAddresses"))
			if(utils.validatetablerowbasedonvalues(tableBrkrCompositeSbrContractAddresses, congeninfoDetails) )
					return true;
		return false;
	
	}
	
	public boolean verifyContractPhoneNumbers(String[] congeninfoDetails)
	{
		utils.scrolltomiddle();
			if(utils.validatetablerowbasedonvalues(tableBrkrCompositeSbrContractPhNumbers, congeninfoDetails))
					return true;
		return false;
	
	}
	
	/**
	 * To verify table values of members
	 * @param congeninfoDetails
	 * @return
	 */
	
	public boolean verifyMembers(String[] congeninfoDetails)
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(lnkBrkrCompositeSbrMembers, "BrokerComposite_ContractSection", "Expand Members"))
			if(utils.validatetablerowbasedonvalues(tableBrkrCompositeSbrMembers, congeninfoDetails))
					return true;
		return false;
	
	}
	
	
	/**
	 * To verify table values of members
	 * @param congeninfoDetails
	 * @return
	 */
	
	public boolean verifyRelatedContracts(String[] congeninfoDetails)
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(lnkBrkrCompositeSbrRelatedContracts, "BrokerComposite_ContractSection", "Expand RelatedContracts"))
			if(utils.validatetablerowbasedonvalues(tableBrkrCompositeRelatedContracts, congeninfoDetails))
					return true;
		return false;
	
	}
	
	@FindBy(xpath="//table[contains(@param_name,'EXPANDEDSubSectionContractAddressList')]//table[@pl_prop='.Address']")
	WebElement tblSubscriberAddress;
	
	@FindBy(xpath="//table[contains(@param_name,'EXPANDEDSubSectionPhoneInfoForContractTab')]//table[@pl_prop='.PhoneCommunication']")
	WebElement tblSubscriberPhoneNumber;
	
	@FindBy(xpath="//span[text()='Address and Contact Information']")
	WebElement lnkAddressAndContactInformation;
	
	/**
	 * Verifies the Subscriber Address Table information
	 * @throws InterruptedException 
	 */
	
	public boolean validateSubscriberAddress(String[] tablevalues) throws InterruptedException
	{
		utils.clickAnelemnt(lnkAddressAndContactInformation, "BrokerComposite_ContractInforamtion", "Address And Contact Inforamtion");
		Thread.sleep(2000);
		WebElement element = tblSubscriberAddress;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		if(utils.validatetablerowbasedonvalues(tblSubscriberAddress, tablevalues))
			return utils.clickAnelemnt(lnkAddressAndContactInformation, "BrokerComposite_ContractInforamtion", "Address And Contact Inforamtion");
		return false;
	}
	
	/**
	 * Verifies the Subscriber Phone Number Table information
	 * @throws InterruptedException 
	 */
	
	public boolean validateSubscriberPhoneNumber(String[] tablevalues) throws InterruptedException
	{
		Thread.sleep(3000);
		utils.clickAnelemnt(lnkAddressAndContactInformation, "BrokerComposite_ContractInforamtion", "Address And Contact Inforamtion");
		Thread.sleep(3000);
		WebElement element = tblSubscriberPhoneNumber;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		if(utils.validatetablerowbasedonvalues(tblSubscriberPhoneNumber, tablevalues))
			return utils.clickAnelemnt(lnkAddressAndContactInformation, "BrokerComposite_ContractInforamtion", "Address And Contact Inforamtion");
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}