package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResearchProviderComposite_HMOSection {
	
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);
	
	public ResearchProviderComposite_HMOSection() {
		utils.waitforpageload();
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(Iframeelement);// change the
		}catch(Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(Iframeelement1);	
		}
	}
		
		@FindBy(id = "PegaGadget2Ifr")
		WebElement Iframeelement;


		@FindBy(id = "PegaGadget1Ifr")
		WebElement Iframeelement1;
		
		@FindBy(xpath="//table[@pl_prop='D_InAreaZip.pxResults']")
		WebElement tb1AreaZipCodes;
		
	public boolean validateInAreaZipCodes(String[] args) {
		return utils.validatetablerowbasedonvalues(tb1AreaZipCodes, args);
	}
	
	
	@FindBy(xpath="//span[text()='HMO Service Type']")
	WebElement HMOServicetype;

	@FindBy(xpath="//label[text()='Eff Date']//parent::div//span")
	WebElement effdate;

	@FindBy(xpath="//label[text()='Term Date']//parent::div//span")
	WebElement Termdate;

	@FindBy(xpath="//label[text()='DOFR Status']//parent::div//span")
	WebElement DOFRStatus;

	@FindBy(xpath="//label[text()='Service From']//parent::div//span")
	WebElement ServiceFrom;

	@FindBy(xpath="//label[text()='Service Thru']//parent::div//span")
	WebElement ServiceThru;

	@FindBy(xpath="//table[@pl_prop='D_HMOServType.pxResults']")
	WebElement tb1HMOServicetype;

	public boolean validateHMOServiceType(String[] args) {		
		if(utils.clickAnelemnt(HMOServicetype,"ProviderComposite_HMOSection","HMOServicetype"))
			if(utils.validateLabel(effdate, args[0]))
				if(utils.validateLabel(Termdate, args[1]))
					if(utils.validateLabel(ServiceFrom, args[2]))
						if(utils.validateLabel(ServiceThru, args[3]))
							if(utils.validateLabel(DOFRStatus, args[4])){
									return true;
							}
		return false;
	}
	
	public boolean validateHMOServiceTypeTable(String[] args)
	{
		if(utils.validatetablerowbasedonvalues(tb1HMOServicetype, args))
			return true;

return false;
	}


	@FindBy(xpath="//label[text()='Office Co-pay Price Tier Effective Date']//parent::div//span")
	WebElement OfficeCopayPriceTierEffectiveDate;
	
	@FindBy(xpath="//label[text()='Tier Indicator']//parent::div//span")
	WebElement TierIndicator;
	
	@FindBy(xpath="//label[text()='Office Co-pay Price Tier End Date']//parent::div//span")
	WebElement OfficeCopayPriceTierEndDate;
	
	@FindBy(xpath="//label[text()='Last Update Date']//parent::div//span")
	WebElement LastUpdateDate;
	
	public boolean validateOfficeCopay(String[] args) {
		if(utils.validateLabel(OfficeCopayPriceTierEffectiveDate, args[0]))
			if(utils.validateLabel(TierIndicator, args[1]))
				if(utils.validateLabel(OfficeCopayPriceTierEndDate, args[2]))
					if(utils.validateLabel(LastUpdateDate, args[3]))
						return true;
		return false;
	}
	
	@FindBy(xpath="//label[text()='Site']//parent::div//span")
	WebElement Site;
	
	@FindBy(xpath="//label[@data-test-id='201904281229020863335924-Label']//parent::div//span")
	WebElement NPI;
	
	public boolean validateHMOProviderInformation(String[] args) {
		if(utils.validateLabel(Site, args[0]))
			if(utils.validateLabel(NPI, args[1]))
				return true;
		return false;
	}
	
	@FindBy(xpath="//table[@pl_prop='.HMOEnrollmentProtection'] ")
	WebElement EnrollmentProtectionTable;
	
	@FindBy(xpath="//span[text()='Enrollment Protection'] ")
	WebElement EnrollmentProtection;
	
	public boolean validateEnrollmentProtection(String[] args) {
		if(utils.clickAnelemnt(EnrollmentProtection ,"ResearchProviderComposite_HMOSection", "EnrollmentProtection"))
			if(utils.validatetablerowbasedonvalues(EnrollmentProtectionTable, args))
		
				return true;
		return false;
}
	@FindBy(xpath="//div[contains(@datasource,'ProvCompositeNetworkInfo')]//table[@class='gridTable '] ")
	WebElement NetworkIDInformationTable;
	
	@FindBy(xpath="//span[text()='Network ID Information'] ")
	WebElement NetworkIDInformation;
	
	public boolean validateNetworkIDInformation(String[] args)
	{
		if(utils.clickAnelemnt(NetworkIDInformation ,"ResearchProviderComposite_HMOSection", "NetworkIDInformation"))
			if(utils.validatetablerowbasedonvalues(NetworkIDInformationTable, args))
			return true;

return false;
	}
	
	@FindBy(xpath="//span[text()='Site Details']")
	WebElement SiteDetails;
	
	@FindBy(xpath="//span[text()=\"Additional Info\"]")
	WebElement ClickAdditionalInfo;
	
	@FindBy(xpath="//span[text()=\"Urgent Care Info\"]")
	WebElement ClickUrgentInfo;
	
	@FindBy(xpath="//table[@pl_prop='.HmoSiteSummary.officeSchedule'] ")
	WebElement OfficeDaysandHours;
	
	@FindBy(xpath="//table[@pl_prop='.HmoSiteSummary.languages'] ")
	WebElement ListOfLanguages;
	
	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionHMOSiteDetailsBBBBBBB']//div[@class='field-item dataValueRead']/span ")
	WebElement AdditionalInfo;
	
	@FindBy(xpath="//div[@aria-label='Hide Urgent Care Info']/../..//span[@data-test-id='201906151358230386404583'] ")
	WebElement UrgentCareInfo;
	
	public boolean validateSiteDetails(String[] args) {
		String s= AdditionalInfo.getText();
		System.out.println(s);
		if(utils.clickAnelemnt(SiteDetails ,"ResearchProviderComposite_HMOSection", "SiteDetails"))
			if(utils.validatetablerowbasedonvalues(OfficeDaysandHours, args[0]))
				if(utils.validatetablerowbasedonvalues(ListOfLanguages, args[1]))
					if(utils.clickAnelemnt(ClickAdditionalInfo, "ResearchProviderComposite_HMOSection", "ClickAdditionalInfo" ))
						if(utils.isvalueMatch_compareto(s, args[2]))
					if(utils.validateLabel(AdditionalInfo, args[2]))
						if(utils.clickAnelemnt(ClickUrgentInfo, "ResearchProviderComposite_HMOSection", "ClickUrgentInfo" ))
						if(utils.validateLabel(UrgentCareInfo, args[3]))
							return true;
		return false;
}
	
	@FindBy(xpath="//span[text()='Membership'] ")
	WebElement Membership;
	
	@FindBy(xpath="//div[contains(@datasource,'HMOMembershipDetails')]//table[@class='gridTable '] ")
	WebElement MembershipTable;
	
	public boolean validateMembership(String[] args)
	{
		if(utils.clickAnelemnt(Membership ,"ResearchProviderComposite_HMOSection", "NetworkIDInformation"))
			if(utils.validatetablerowbasedonvalues(MembershipTable, args))
			return true;

return false;
	}

}



