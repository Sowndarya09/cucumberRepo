package automationLib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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

public class ProviderComposite_GroupSection extends Driver {
	WebDriverWait wait;
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	public ProviderComposite_GroupSection()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Group']")
	WebElement tabMbrCompositeGroup;

	@FindBy(xpath="//span[text()='Group Information']")
	WebElement lnkMbrCompositeGrpInfo;


	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='GroupStatus']/parent::div//span")
	WebElement labelMbrCompositeGrpStatus;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='GroupTapeUpdateDate']/parent::div//span")
	WebElement labelMbrCompositeGrpTapeLastUpdateDate;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='RateGuaranteeDate']/parent::div//span")
	WebElement labelMbrCompositeGrpOpenEnrollmentMonth;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='GroupTerminationDate']/parent::div//span")
	WebElement labelMbrCompositeGrpTerminationDate;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='GroupTapeInd']/parent::div//span")
	WebElement labelMbrCompositeGrpTapeEnrollmentInd;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='AccountType']/parent::div//span")
	WebElement labelMbrCompositeGrpAccountType;

	@FindBy(xpath="//*[@data-test-id='20170223124008051611269']")
	WebElement labelMbrCompositeGrpEmployeeRetirementIncomeSecurityAct;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='GroupName']/parent::div//span")
	WebElement labelMbrCompositeGrpName;


	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupName']/parent::div//span")
	WebElement labelMbrCompositeGrpProdname;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupNumber']/parent::div//span")
	WebElement labelMbrCompositeGrpNum;


	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='SmallGroupNumber']/parent::div//span")
	WebElement labelMbrCompositeGrpsmallGrpnum;
	

	@FindBy(xpath="//label[@for='CPCCIndicator']/..//div/span")
	WebElement transferToProvider;


	public boolean validateSubscriberInformation(String[] args) throws Exception {
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		utils.clickAnelemnt(this.tabMbrCompositeGroup, "ProviderComposite_GroupSection", "Group tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "ProviderComposite_GroupSection", "Group tab"))
		{
			if(utils.isProxyWebelement(this.labelMbrCompositeGrpName))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo,"ProviderComposite_GroupSection"," Contract address link ");

			}
			else
			{
				System.out.println("Group Address is already clicked");
			}
			String keyvaluepair="";
			for(String iterator : args)
			{

				if(!returnvar)				{
					err.logcommonMethodError("ProviderComposite_GroupSection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(key.toLowerCase().contains("productgrpname"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpProdname, value);
					continue;
				}
				else if(key.toLowerCase().contains("grpname")||key.toLowerCase().contains("Group Name"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpName, value);
					continue;
				}
				else if(key.toLowerCase().contains("smallgrpnumber")||key.toLowerCase().contains("Small Group Number"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpsmallGrpnum, value);
					continue;
				}
				else if(key.toLowerCase().contains("grpnumber")||key.toLowerCase().contains("Group Number"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpNum, value);					
					continue;
				}

				else if(key.toLowerCase().contains("grpstatus"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpStatus, value);
					continue;
				}
				else if(key.toLowerCase().contains("grpterminationdate"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpTerminationDate, value);
					continue;
				}
				else if(key.toLowerCase().contains("grptapeenrollmentind"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpTapeEnrollmentInd, value);
					continue;
				}
				else if(key.toLowerCase().contains("grptapelastupdatedate"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpTapeLastUpdateDate, value);
					continue;
				}
				else if(key.toLowerCase().contains("rateguaranteedate"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpOpenEnrollmentMonth, value);
					continue;
				}
				else if(key.toLowerCase().contains("grpacounttype"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpAccountType, value);
					continue;
				}
				else if(key.toLowerCase().contains("grpemployeeretirementincomesecurity"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpEmployeeRetirementIncomeSecurityAct, value);
					continue;
				}	
				else 
					err.logcommonMethodError("ProviderComposite_GroupSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		else
			err.logError("ProviderComposite_GroupSection", "Member tab ");
		if(returnvar)
		{
			System.out.println("Group genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ProviderComposite_GroupSection", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateEmployerGroupInformation(String[] args) throws Exception{

		try{
			boolean flag = utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab");
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement2);
			}

		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
		}

		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab"))
		{
			if(utils.isProxyWebelement(this.labelMbrCompositeGrpName))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Group Address is already clicked");
			}
			String keyvaluepair="";
			for(String iterator : args)
			{

				if(!returnvar)
				{
					err.logcommonMethodError("ProviderComposite_GroupSection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(key.toLowerCase().contains("groupname"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpName, value);
					continue;
				}

				else if(key.toLowerCase().contains("groupnumber"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpNum, value);					
					continue;
				}

				else if(key.toLowerCase().contains("groupstatus"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpStatus, value);
					continue;
				}
				else if(key.toLowerCase().contains("grouptapeenrollmentid"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpTapeEnrollmentInd, value);
					continue;
				}
				else if(key.toLowerCase().contains("accounttype"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpAccountType, value);
					continue;
				}
				else if(key.toLowerCase().contains("enrollmentincomesecurityact"))
				{
					returnvar=utils.validateValueinelement(this.labelMbrCompositeGrpEmployeeRetirementIncomeSecurityAct, value);
					continue;
				}	
				else 
					err.logcommonMethodError("ProviderComposite_GroupSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		else
			err.logError("ProviderComposite_GroupSection", "Member tab ");
		if(returnvar)
		{
			System.out.println("Group genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ProviderComposite_GroupSection", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupTerminationDate']/parent::div//span")
	WebElement labelMbrCompositeProdGrpTerminationDate;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='RateMethodCode']/parent::div//span")
	WebElement labelMbrCompositeProdGrpRateMethodCode;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='IDCardMailing']/parent::div//span")
	WebElement labelMbrCompositeProdGrpIDCardMailing;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='FundingType']/parent::div//span")
	WebElement labelMbrCompositeProdGrpFundingType;

	@FindBy(xpath="//*[@class='content-item content-field item-7   ']//*[@data-test-id='201509101150000520548586']")
	WebElement labelMbrCompositeProdGrpRerateMonth;

	public boolean validateProductGroupInformation(String[] prodgeninformationDetails)
	{
		try{
			boolean flag = utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab");
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement2);
			}
		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
		}
		boolean returnvar ;
		returnvar = true;
		if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab"))
		{
			if(utils.isProxyWebelement(this.labelMbrCompositeGrpName))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo,"Member Composite "," Contract address link ");
			}
			else
			{
				System.out.println("Group Address is already clicked");
			}
			String keyvaluepair="";
			for(String iterator : prodgeninformationDetails)
			{
				if(!returnvar)
				{
					err.logcommonMethodError("ProviderComposite_GroupSection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(key.toLowerCase().contains("groupname"))
				{
					returnvar = this.labelMbrCompositeGrpProdname.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("groupnumber"))
				{
					returnvar = this.labelMbrCompositeGrpNum.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("ratemethodcode"))
				{
					returnvar = this.labelMbrCompositeProdGrpRateMethodCode.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("idcardmailing"))
				{
					returnvar = this.labelMbrCompositeProdGrpIDCardMailing.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("fundingtype"))
				{
					returnvar = this.labelMbrCompositeProdGrpFundingType.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("reratemonth"))
				{
					returnvar = this.labelMbrCompositeProdGrpRerateMonth.getText().toLowerCase().contains(value);
					continue;
				}
				else 
					err.logcommonMethodError("ProviderComposite_GroupSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		else
			err.logError("ProviderComposite_GroupSection", "Member tab ");
		if(returnvar)
		{
			System.out.println("Group genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=prodgeninformationDetails.length;
			err.logcommonMethodError("ProviderComposite_GroupSection", "the value "+prodgeninformationDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	//Sprint 4.1


	@FindBy(xpath="//span[text()='Anthem Group Management']")
	WebElement labeldropMbrCompositeGrpManagement;


	//ELEMENTS UDNER ANTHEM GROUP MANAGEMENT


	@FindBy(xpath="//label[@for='RecipientNamePhone']/following-sibling::div")
	WebElement labelMbrCompositeGrpServLoc;

	@FindBy(xpath="//label[@for='CPCCIndicator']/following-sibling::div")
	WebElement labelMbrCompositeGrpTranstoProv;

	@FindBy(xpath="//label[@for='ClaimsAddress']/following-sibling::div")
	WebElement labelMbrCompositeGrpClaimsAddress;

	@FindBy(xpath="//label[@for='ProviderCarePhone']/following-sibling::div")
	WebElement labelMbrCompositeGrpProviderServiceTelephone;

	@FindBy(xpath="//label[@for='ProviderCarePhone']")
	WebElement labelProviderCompositeGrpProviderServiceTelephone;
	
	@FindBy(xpath="//*[text()='Anthem Group Management']")
	WebElement AnthemGroupManagementlink;
	
	public boolean expandAnthemGroupManagement(){
		action.moveToElement(AnthemGroupManagementlink);
		return utils.clickAnelemnt(AnthemGroupManagementlink, "ProviderComposite_GroupSection", "AnthemGroupManagementlink");
	}

	public boolean verifyAnthemGrpManagement(String[] grpmanageinfoDetails) throws Exception
	{
		boolean returnvar ;
		returnvar = true;
		action.moveToElement(labeldropMbrCompositeGrpManagement);
		if(utils.clickAnelemnt(this.labeldropMbrCompositeGrpManagement,"Member Composite "," Contract address link "))
		utils.waitforpageload();

		for(String iterator : grpmanageinfoDetails)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			if(utils.isvalueMatch_contain(key.toLowerCase(),"servicelocation")){
				returnvar = utils.validateLabel(labelMbrCompositeGrpServLoc,value);
				continue;}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"transfer")){
				returnvar = utils.validateLabel(labelMbrCompositeGrpTranstoProv,value);
				continue;}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"claimaddress")){
				returnvar = utils.validateLabel(labelMbrCompositeGrpClaimsAddress,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key.toLowerCase(),"provider service telephone")){
				String exp = labelMbrCompositeGrpProviderServiceTelephone.getText();
				returnvar = utils.validateLabel(labelMbrCompositeGrpProviderServiceTelephone,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key.toLowerCase(), "transfer to provider?"))
			{
				returnvar= utils.validateLabel(transferToProvider, value);
				continue;
			}
			else 
				err.logcommonMethodError("ProviderComposite_GroupSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("Group management info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=grpmanageinfoDetails.length;
			err.logcommonMethodError("ProviderComposite_GroupSection", "the value "+grpmanageinfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}


	public boolean verifyProviderServiceTelePhoneIsDisplayedUnderAnthemGroupManagementInGroupSection()
	{
		if(utils.clickAnelemnt(labeldropMbrCompositeGrpManagement, "ProviderComposite_GroupSection", "Anthem Group Management"))
			if(!utils.isProxyWebelement(labelProviderCompositeGrpProviderServiceTelephone))
				return true;
		return false;
			
	}

	@FindBy(xpath="//*[@class='content-item content-layout item-6   ']//*[@data-test-id='201509101150000520548586-Label']")
	WebElement FundingType;

	public boolean verifyFundingTypeDescriptionWhenHover(String args[]) {
		utils.waitforpageload();
		utils.clickAnelemnt(FundingType, "", "FundingType");
		String expectedtext = args[0];
		String actualtext = FundingType.getAttribute("aria-label");
		return utils.isvalueMatch_contain(actualtext, expectedtext);
	}
	

	

}





