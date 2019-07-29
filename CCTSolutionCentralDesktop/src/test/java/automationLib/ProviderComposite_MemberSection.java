package automationLib;

import java.util.ArrayList;
import java.util.List;

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

public class ProviderComposite_MemberSection extends Driver{


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();

	public ProviderComposite_MemberSection()
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

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement3;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='ProductType']/parent::div//span")
	WebElement labelMbrCompositeMbrProductType;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='COBIndicator']/parent::div//span")
	WebElement labelMbrCompositeMbrCOBIndicator;

	@FindBy(xpath="//img[contains(@data-hover,'COB')]")
	WebElement imgMbrCompositeMbrCOBIndicator;

	@FindBy(xpath="//img[contains(@data-hover,'Medicare indicator')]")
	WebElement imgMbrCompositeMbrMedicareindicator;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='MedicareIndicator']/parent::div//span")
	WebElement labelMbrCompositeMbrMedicareIndicator;

	@FindBy(xpath="//*[contains(@class ,'content-item content-field item-14 remove-top-spacing remove-bottom-spacing')]//*[@data-test-id='2015020305565609188735']")
	WebElement labelMbrCompositeMbrPaidToDate;

	@FindBy(xpath="//*[@data-test-id='20150914102046032213295']")
	WebElement labelMbrCompositeMbrExchangeInd;

	@FindBy(xpath="//*[@data-test-id='20150918122626032224625']")
	WebElement linkMbrCompositeMemberName;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='HCIDDisplay']/parent::div//span")
	WebElement labelMbrCompositeMemberID;

	@FindBy(xpath="//*[@data-test-id='20150923133728072260657-Label']")
	WebElement labelMbrCompositeMbrEmployeeID;

	@FindBy(xpath="//*[@data-test-id='20150923133728072260657']")

	WebElement labelalternateId;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='Relationship']/parent::div//span")
	WebElement labelMbrCompositeMbrRelationship;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='DateOfBirth']/parent::div//span")
	WebElement labelMbrCompositeMbrDOB;


	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='Age']/parent::div//span//span")
	WebElement labelMbrCompositeMbrAge;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='EffectiveDate']/parent::div//span")
	WebElement labelMbrCompositeMbrEffDate;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='EndDate']/parent::div/div")
	WebElement labelMbrCompositeMbrEndDate;

	@FindBy(xpath="//a[contains(@onclick,'DueDtReviewed')]//img")
	WebElement chkbxMbrCompositeMbrTerminationDate;

	@FindBy(xpath="//a[contains(@onclick,'EffecDtReviewed'')]//img")
	WebElement chkbxMbrCompositeMbrEffDate;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;

	public boolean VerifyMemberGeneralInfo(String[] args) throws InterruptedException {
		Thread.sleep(1000);
		utils.waitforpageload();
		try {
			boolean flag =utils.clickAnelemnt(tabMbrCompositeMember, "ProviderComposite_MemberSection", "Member tab");

			if(!flag)
			{
				Driver.pgDriver.switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement3);
			}
		}
		catch(Exception e) {
			Driver.pgDriver.switchTo().defaultContent();
			try {
				Driver.pgDriver.switchTo().frame(Iframeelement3);
				utils.clickAnelemnt(tabMbrCompositeMember, "ProviderComposite_MemberSection", "Member tab");
			}
			catch(Exception e1) {
				Driver.pgDriver.switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement2);
				utils.clickAnelemnt(tabMbrCompositeMember, "ProviderComposite_MemberSection", "Member tab");
			}
		}

		utils.waitForElementToBeVisible(linkMbrCompositeMemberName);
		boolean returnvar ;
		returnvar = true;
		if(utils.clickAnelemnt(tabMbrCompositeMember, "ProviderComposite_MemberSection", "Member tab"))
		{
			String keyvaluepair="";
			for(String iterator : args)
			{
				if(!returnvar)
				{
					err.logcommonMethodError("ProviderComposite_MemberSection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(utils.isvalueMatch_contain(key.toLowerCase(), "membername")) {
					returnvar = utils.validateLabel(linkMbrCompositeMemberName,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"memberid")){
					returnvar = utils.validateLabel(labelMbrCompositeMemberID,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"alternate")){
					Actions action = new Actions(pgDriver);
					action.moveToElement(labelMbrCompositeMbrEmployeeID).build().perform();
					String hovertext=pgDriver.findElement(By.xpath("//*[@data-test-id='20150923133728072260657-Label']")).getAttribute("aria-label").toString().toLowerCase();
					if(hovertext.contains("this field can be employee id, ssn, or any other identifier for the member"))
						System.out.println("hover text present");
					returnvar = utils.validateLabel(labelalternateId,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"relationship")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrRelationship,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"dob")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrDOB,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"age")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrAge,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"effective")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrEffDate,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"terminationdate")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrEndDate,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"producttype")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrProductType,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"cobindicator")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrCOBIndicator,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"medicareindicator")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrMedicareIndicator,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"paidtodate")){
					returnvar=utils.validateLabel(labelMbrCompositeMbrPaidToDate, value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"exchangeind")){
					returnvar = utils.validateLabel(labelMbrCompositeMbrExchangeInd,value);
					continue;
				}
				else 
					err.logcommonMethodError("ProviderComposite_MemberSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		else
			err.logError("ProviderComposite_MemberSection", "Member tab ");
		if(returnvar)
		{
			System.out.println("Member general info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ProviderComposite_MemberSection", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	@FindBy(xpath="//span[text()='Address and Contact Information']")
	WebElement labelMbrCompositeMbrAddCnctInfoLink;

	@FindBy(xpath="//div[@node_name='AddressInfo']//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrAddress;

	public boolean ValidateAddressTableInformation(String[] args) {
		try{
			boolean flag = utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
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

		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab "))
		{		
			if(utils.isProxyWebelement(this.tableMbrCompositeMbrAddress))
			{
				utils.clickAnelemnt(this.labelMbrCompositeMbrAddCnctInfoLink,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrAddress, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i).toLowerCase());
				System.out.println("Content comaprison value text is : " + value.toLowerCase());


				if(firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase()))
				{  


					return true;

				}

			}
			return false;
		}
		return false;
	}

	public boolean selectDependentInProviderFlow(String[] mName)
	{
		if(utils.clickAnelemnt(linkMbrCompositeMemberName, "Member Composite ", "Member name link "))
			if(this.selectDatatoSwitchmember("First Name",mName[0]))
				return true;
		return false;
	}

	@FindBy(xpath="//*[@pl_prop='D_MembersOnContract.pxResults']")
	WebElement tableMbrCompositeMembertable;

	public boolean selectDatatoSwitchmember(String columnName,String firstName)
	{
		boolean flag = false;
		if(utils.isProxyWebelement(this.tableMbrCompositeMembertable))
			utils.clickAnelemnt(this.labelMbrCompositeMemberID,"Member Composite "," Contract address link ");
		else
			System.out.println("Contract Address is already clicked");	
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=utils.getcolumnStringFromTableByName(tableMbrCompositeMembertable, columnName);
		for(int i=0;i<firstnameColumn.size();i++)
		{ 
			System.out.println("Content text is : " + firstnameColumn.get(i));
			if(firstnameColumn.get(i).toLowerCase().equals(firstName.toLowerCase()))
			{  
				System.out.println("Actual ="+firstnameColumn.get(i)+"Expected "+firstName);
				String name=firstnameColumn.get(i);
				String xpath="//*[@pl_prop='D_MembersOnContract.pxResults']//span[contains(text(),'"+name+"')]";
				System.out.println(xpath);
				Driver.pgDriver.findElement(By.xpath(xpath)).click();
				flag = true;
			}
		}
		return flag;
	}

	public boolean clickOnSelectMember() {
		utils.waitforpageload();
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
			return utils.clickAnelemnt(linkMbrCompositeMemberName, "Member Composite ", "Member name link ");
		}
		catch(Exception e) {
			return utils.clickAnelemnt(linkMbrCompositeMemberName, "Member Composite ", "Member name link ");
		}
	}

	@FindBy(xpath="//*[@data-test-id='2015112013594604362587']")
	WebElement RestrictMessage;

	@FindBy(id="ModalButtonSubmit")
	WebElement OkButtonInPopUp;

	public boolean restrictMessageToSwitchMemberWhenTaskIsOpen() {
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
			if(!utils.isProxyWebelement(RestrictMessage))
				return utils.clickAnelemnt(OkButtonInPopUp, "ProviderComposite_ContractSection", "OkButtonInPopUp");
			return false;
		}catch(Exception e) {
			if(!utils.isProxyWebelement(RestrictMessage))
				return utils.clickAnelemnt(OkButtonInPopUp, "ProviderComposite_ContractSection", "OkButtonInPopUp");
			return false;
		}

	}

	@FindBy(id="IsMemberNameVerified")
	WebElement MemberNameCheckbox;

	@FindBy(id="IsMemberIDVerified")
	WebElement MemberIDCheckbox;

	@FindBy(id="IsDateOfBirthVerified")
	WebElement DOBCheckBox;

	@FindBy(id="ModalButtonSubmit")
	WebElement Submit;


	public boolean verifymemberdetailsDuringMemberSwitch(String [] args) throws InterruptedException
	{
		if(utils.clickAnelemnt(MemberNameCheckbox, "", ""))
			if(utils.clickAnelemnt(MemberIDCheckbox, "", ""))
				if(utils.clickAnelemnt(DOBCheckBox, "", ""))
					return utils.clickAnelemnt(Submit, "ProviderComposite_MemberSection", "Submit");
		return false;
	}

	@FindBy(xpath="//*[@data-test-id='20160526121928016917722']")
	WebElement COBIndicator1;

	@FindBy(xpath="//*[@data-test-id='20180725182647009271535']")
	WebElement COBIndicator2;

	public boolean verifyOtherInsuranceCompanyNameAndDesighnationOfCOB(String[] args) {
		return utils.validateLabel(COBIndicator1, args[0]) && utils.validateLabel(COBIndicator2, args[1]);
	}

	//the Grace Period Message for Oh state and other states at Member Tab in Provider flow
	@FindBy(xpath="//*[@class='content-item content-paragraph item-1   ']")
	WebElement GracePeriodMessage;

	public boolean verifyGracePeriodMessage(String[] message){
		String GracePeriodMessage = message[0];
		String GracePeriodMessageFromUI = this.GracePeriodMessage.getText().replaceAll(",", "").replaceAll("  ", " ");
		return utils.isvalueMatch_compareto(GracePeriodMessageFromUI, GracePeriodMessage);

	}


	//the Grace Period at Member Tab in Provider flow
	@FindBy(xpath="//*[text()='Grace Month']/..//*[@data-test-id='201708040137200159215447']")
	WebElement GracePeriod;

	public boolean verifyGracePeriod(String[] value){
		if(expandGeneralInfo()) {	
			String GracePeriod = value[0];
			String GracePeriodFromUI = this.GracePeriod.getText().replaceAll(",", "").replaceAll("  ", " ");
			return utils.isvalueMatch_compareto(GracePeriodFromUI, GracePeriod);
		}
		return false;

	}

	/**Code to expand the member pcp**/

	@FindBy(xpath="//span[text()='Primary Care Physician Information']")
	WebElement pcpLnk;

	public boolean expandMemberPCPInfo() {
		return utils.clickAnelemnt(pcpLnk, "Provider composite", "PCP");
	}

	@FindBy(xpath="//table[@pl_prop='D_PCPDetails.pxResults']")
	WebElement pcpInfo;

	@FindBy(xpath="//a[@data-test-id='20181115130702064014591']")
	WebElement pcpLink;

	public boolean clickPCPID(String[] args) throws InterruptedException
	{
		WebElement row = utils.returntablerowbasedonvalues(pcpInfo, args);
		WebElement findElement = row.findElement(By.xpath("//a[@data-test-id='20181115130702064014591']"));
		return utils.clickAnelemnt(findElement, "member composite", "PCPlink");
	}

	@FindBy(xpath="//div[@title='Disclose General Information']")
	WebElement LnkGeneralInfo;
	
	public boolean expandGeneralInfo() {
		if(utils.clickAnelemnt(LnkGeneralInfo, "Provider composite", "LnkGeneralInfo")) 
			if(!utils.isProxyWebelement(GracePeriod))
				return true;
			else
				if(utils.clickAnelemnt(LnkGeneralInfo, "Provider composite", "LnkGeneralInfo"))
					return !utils.isProxyWebelement(GracePeriod);
		return false;
	}

}







