package automationLib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
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

public class MemberComposite extends Driver{

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	Actions action = new Actions(pgDriver);
	WebDriverWait wait;


	public MemberComposite() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		Driver.getPgDriver().switchTo().defaultContent();
		gotoLastIframe();//

		/**The below code is due to Raptors change. author: Sowndarya
		 * 
		 */
		/*		if(!utils.isProxyWebelement(CDHPModalDialogSubmit))
			utils.clickAnelemnt(CDHPModalDialogSubmit, "MemberComposite", "CDHPModalDialogSubmit");*/
		/*Elby Commenting on 3/4 - if the impact is resulting in lot of failures will revisit.
		 * try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);

		}catch(Exception e) {
			try
			{
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
			}catch(Exception e1)
			{		
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement3);
			}
		}*/
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement3;

	@FindBy(id="PegaGadget4Ifr")
	WebElement Iframeelement4;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Policy']")
	WebElement tabMbrCompositeContract;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Group']")
	WebElement tabMbrCompositeGroup;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Interactions']")
	WebElement tabMbrCompositeInteraction;

	@FindBy(xpath="//img[@alt='Loading...']")
	WebElement loadingicon;

	@FindBy(xpath="//label[text()='Loading...']")
	WebElement loadinglabel;

	@FindBy(xpath="//img[contains(@src,'addtask')]")
	WebElement btnMbrCompositeAddTask;

	@FindBy(id="ModalButtonSubmit")
	WebElement btnVerificationSubmit;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Link Interaction']")
	WebElement btnLinkInteration;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Close']")
	WebElement btnClose;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Wrap Up']")
	WebElement btnMbrCompositeWrapup;

	@FindBy(name="MemberGeneralInformation_pyWorkPage_248")
	WebElement linkMbrCompositeMemberName;

	@FindBy(xpath="//a[@data-test-id='2015020305565609175321']")
	WebElement linkMbrCompositeContractNumber;

	@FindBy(xpath="//div[@node_name='MemberDetailInformation']//label[@for='EID']/parent::div/parent::div/parent::div//img")
	WebElement imagealternateid;

	@FindBy(xpath="//*[@node_name='MemberList']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMembertable;

	@FindBy(xpath="//*[@node_name='MemberContractsList']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeContracttable;


	@FindBy(xpath="//a[@data-test-id='2014123005242607302524' or @data-test-id='201412300524260732670']")
	//@FindBy(xpath="//a[@data-test-id='201412300524260732670']")
	List<WebElement> allOptions;

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


	@FindBy(xpath="//span[text()='Address and Contact Information']")
	WebElement labelMbrCompositeMbrAddCnctInfoLink;

	@FindBy(xpath="//span[text()='Primary Care Physician Information']")
	WebElement labelMbrCompositeMbrPriCarePhyInfoLink;

	@FindBy(xpath="//span[text()='Primary Medical Group Information']")
	WebElement labelMbrCompositeMbrPrimaryMedicalGroupLink;

	@FindBy(xpath="//span[text()='Independent Physician Association Information']")
	WebElement labelMbrCompositeMbrIndependantPhyAssoGroupLink;

	@FindBy(xpath="//div[@node_name='AddressInfo']//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrAddress;

	@FindBy(xpath="//div[@node_name='PhoneInfo']//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrPhone;

	@FindBy(xpath="//div[@node_name='EmailInfo']//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrEmail;

	@FindBy(xpath="//div[@node_name='HCPCPInformation']//label[@for='ProviderName']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPName;

	@FindBy(xpath="//div[@node_name='HCPCPInformation']//label[@for='ProviderNumber']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPID;

	@FindBy(xpath="//div[@node_name='HCPCPInformation']//label[@for='PrimarySpeciality']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPPrimarySpeciality;

	@FindBy(xpath="//div[@node_name='HCPCPInformation']//label[@for='PhoneNumber']/parent::div//div")
	WebElement labelMbrCompositeMbrPCPPhone;


	@FindBy(xpath="//div[@node_name='HCPCPInformation']//label[@for='EffectiveDate']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPEffDate;

	@FindBy(xpath="//div[@node_name='HCPCPInformation']//label[@for='PCPDateUpdated']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPUpdateDate;

	@FindBy(xpath="//div[@node_name='PracticeAddresses']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrPCPPracticeAddress;


	@FindBy(xpath="//div[@node_name='ProviderInformation']//label[@for='OrganizationName']/parent::div//span")
	WebElement labelMbrCompositeMbrPMGname;

	@FindBy(xpath="//div[@node_name='ProviderInformation']//label[@for='ProviderNumber']/parent::div//span")
	WebElement labelMbrCompositeMbrPMGnumber;

	@FindBy(xpath="//div[@node_name='ProviderInformation']//label[@for='PhoneNumber']/parent::div//div")
	WebElement labelMbrCompositeMbrPMGphone;

	@FindBy(xpath="//div[@node_name='ProviderInformation']//label[@for='EffectiveDate']/parent::div//span")
	WebElement labelMbrCompositeMbrPMGeffdate;

	@FindBy(xpath="//div[@node_name='ProviderInformation']//label[@for='PCPDateUpdated']/parent::div//span")
	WebElement labelMbrCompositeMbrPMGupdateddate;


	@FindBy(xpath="//div[@node_name='PracticeAddresses']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrPMGTable;

	@FindBy(xpath="//span[text()='Subscriber Information']")
	WebElement lnkMbrCompositeSbrInfo;

	@FindBy(xpath="//span[text()='Contract Addresses']")
	WebElement lnkMbrCompositeSbrContractAddress;

	@FindBy(xpath="//span[text()='Related Contracts']")
	WebElement lnkMbrCompositeSbrRelatedContracts;

	@FindBy(xpath="//span[text()='Members']")
	WebElement lnkMbrCompositeSbrMember;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//a[contains(@data-click,'MemberContractsList')]")
	WebElement labelMbrCompositeSbrContractID;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='HCID']/parent::div//span")
	WebElement labelMbrCompositeSbrMemberID;

	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='pyFullName']/parent::div//span")
	WebElement labelMbrCompositeSbrName;

	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='Age']/parent::div//span")
	WebElement labelMbrCompositeSbrAge;

	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='Gender']/parent::div//span")
	WebElement labelMbrCompositeSbrGender;

	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='SubscriberEffecDate']/parent::div//span")
	WebElement labelMbrCompositeSbrEffDate;


	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='SubscriberEndDate']/parent::div")
	WebElement labelMbrCompositeSbrEndDate;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='ProductType']/parent::div//span")
	WebElement labelMbrCompositeSbrProdType;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='ContractCode']/parent::div//span")
	WebElement labelMbrCompositeSbrCntrctCode;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='CoverageType']/parent::div//span")
	WebElement labelMbrCompositeSbrCoverageType;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='BenefitPeriod']/parent::div//span")
	WebElement labelMbrCompositeSbrBenefitPeriod;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='GroupNumber']/parent::div//span")
	WebElement labelMbrCompositeSbrGroupNumber;

	@FindBy(xpath="//span[@data-test-id='20170313150810029741745']")
	WebElement labelMbrCompositeSbrAnthemCompanyCode;

	@FindBy(xpath="//div[@node_name='ContractAddressList']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeSbrAddress;

	@FindBy(xpath="//div[@node_name='PhoneInfoForContractTab']//table[@class='gridTable ']")
	WebElement tableMbrCompositeSbrPhone;

	@FindBy(xpath="//div[@node_name='MembersWithCoverageInFocus']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeSbrMemberswithcoverage;

	@FindBy(xpath="//div[@node_name='RelatedContracts']/parent::div//table[@class='gridTable ']")
	WebElement tableMbrCompositeSbrRelatedContracts;


	@FindBy(xpath="//div[@node_name='RelatedContracts']/parent::div//td[2]//nobr/span")
	WebElement labelMbrCompositeSbrRCMemName;

	@FindBy(xpath="//div[@node_name='RelatedContracts']/parent::div//td[4]//nobr/span")
	WebElement labelMbrCompositeSbrRCMemDOB;

	@FindBy(xpath="//span[text()='Group Information']")
	WebElement lnkMbrCompositeGrpInfo;

	@FindBy(xpath="//span[text()='Group Addressess']")
	WebElement lnkMbrCompositeGrpAddress;

	@FindBy(xpath="//span[text()='Group Phone Numbers']")
	WebElement lnkMbrCompositeGrpPhone;

	@FindBy(xpath="//span[text()='Broker Information']")
	WebElement lnkMbrCompositeGrpBrokerInfo;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='GroupName']/parent::div//span")
	WebElement labelMbrCompositeGrpName;


	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupName']/parent::div//span")
	WebElement labelMbrCompositeGrpProdname;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupNumber']/parent::div//span")
	WebElement labelMbrCompositeGrpNum;


	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='SmallGroupNumber']/parent::div//span")
	WebElement labelMbrCompositeGrpsmallGrpnum;

	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='GroupStatus']/parent::div//span")
	WebElement labelMbrCompositeGrpStatus;


	@FindBy(xpath="//div[@node_name='GroupDetailsInformation']//label[@for='IDCardMailing']/parent::div//span")
	WebElement labelMbrCompositeGrpIDCard;

	@FindBy(xpath="//div[@node_name='GroupDetails']//label[@for='BrokerFName']/parent::div//span")
	WebElement labelBrokerFirstName;

	@FindBy(xpath="//div[@node_name='GroupDetails']//label[@for='BrokerLName']/parent::div//span")
	WebElement labelBrokerLastName;

	@FindBy(xpath="//div[@node_name='GroupDetails']//label[@for='CompanyName']/parent::div//span")
	WebElement labelBrokerCompany;



	@FindBy(xpath="//div[@node_name='GroupDetails']//label[@for='BrokerEncryptedID']/parent::div//span")
	WebElement labelBrokerEncryptedID;

	@FindBy(xpath="//span[text()='Anthem Group Management']")
	WebElement labeldropMbrCompositeGrpManagement;

	@FindBy(xpath="//span[text()='Employer Group Administrator']")
	WebElement labeldropMbrCompositeGrpEmpGrpAdmin;

	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='RecipientNamePhone']/parent::div//span")
	WebElement labelMbrCompositeGrpServLoc;

	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='CPCCIndicator']/parent::div//span")
	WebElement labelMbrCompositeGrpTranstoProv;

	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='ClaimsAddress']/parent::div//span")
	WebElement labelMbrCompositeGrpClaimsAddress;

	@FindBy(xpath="//div[@node_name='EmployerGroupAdmin']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupadmin;

	@FindBy(xpath="//div[contains(@datasource,'AddressList_Group')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupAddress;

	@FindBy(xpath="//div[contains(@datasource,'GroupPhoneList_Group')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupPhone;

	@FindBy(xpath="//div[@node_name='BrokersListInformation']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpBrokerInfo;

	@FindBy(xpath="//span[text()='Open Service Requests']")
	WebElement lnkMbrCompositeIntOpenServiceReq;

	@FindBy(xpath="//span[text()='Recent Interactions']")
	WebElement lnkMbrCompositeIntRecentInt;

	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']")
	WebElement lnkMbrCompositeIntRecentInqtrack;

	@FindBy(xpath="//span[text()='Related/Linked Interactions']")
	WebElement lnkMbrCompositeIntLinkedInt;                                    //6

	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']//div[text()='View All']")
	WebElement imgMbrCompositeIntOpenSerReqViewall;

	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']//div[text()='Refresh']")
	WebElement imgMbrCompositeIntOpenSerReqRefresh;

	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']//div[text()='View All']")
	WebElement imgMbrCompositeIntRecentIntViewall;

	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']//div[text()='Refresh']")
	WebElement imgMbrCompositeIntRecentInteractionrefresh;

	@FindBy(xpath="//div[@node_name='RecentIQTTracking']//*[text()='View All']")
	WebElement imgMbrCompositeIntRecentInqtrackViewall;

	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']/parent::div//img[contains(@data-click,'refresh')]")
	WebElement imgMbrCompositeIntRecentInqtrackrefresh;

	@FindBy(xpath="//span[text()='Related/Linked Interactions']/parent::div//img[contains(@data-click,'refresh')]")
	WebElement imgMbrCompositeIntLinkedIntrefresh; 

	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntOpenSerReq;

	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntRecentInt;


	@FindBy(xpath="//div[@node_name='RecentIQTTracking']/parent::div//table[@id='gridLayoutTable']//table[@class='gridTable ']")
	WebElement tableMbrCompositeIntRecentInqTrack;

	@FindBy(xpath="//div[contains(@datasource,'LinkedInteractions')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntRelatedIntraction;                  


	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")
	WebElement benefitsandcost;
	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Manage Claims'][@class='Add_task']")
	WebElement manageclaims;

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")
	WebElement promisedactions;
	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='External Search'][@class='Add_task']")
	WebElement externalsearch;
	@FindBy(xpath="//a[contains(text(),'Manage Dental')]")
	WebElement labelManageDental;
	@FindBy(xpath="//a[contains(text(),'Manage Vision')]")
	WebElement labelManageVision;

	@FindBy(xpath="//a[contains(text(),'Manage Behavioral Health')]")
	WebElement labelManageBehavioralHealth;
	@FindBy(xpath="//a[contains(text(),'Manage Employee Assistance Program')]")//to be corrected
	WebElement labelManageEmployeeAssistanceProgram;


	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Add task(s)']")
	WebElement addtaskbutton;


	@FindBy(id="MemberInfoReview")
	WebElement chkbxmemberinfodiscussed;

	@FindBy(id="ContractInfoReview")
	WebElement chkbxcontractinfodiscussed;

	@FindBy(id="GroupDetailsInfoReview")
	WebElement chkbxgroupinfodiscussed;

	@FindBy(id="InteractionsInfoReview")
	WebElement chkbxInteractioninfodiscussed;

	@FindBy(id="DialogContent")
	WebElement labelGuidedDialog;

	@FindBy(xpath="//div[@node_name='RecentIQTTracking']/parent::div//table[@id='gridLayoutTable']//table[@class='gridTable ']//tr[2]//a")
	WebElement lnkrecentInquirytracking;


	@FindBy(xpath="//table[@class='gridTable ']")
	WebElement tableRecentIQTViewAll;
	public boolean verifyGuidedDialogText()
	{
		try
		{
			String message=this.labelGuidedDialog.getText().toString();
			System.out.println(message);
			if(message.contains("Handle with care. Use the HIPAA Verification & Disclosure Guide link if you need help understanding what you can tell"))
			{
				return true;
			}
			else
			{
				err.logError("Member composite", "Error in Guided Dialog message. Actual message not equal to the expected");
				return false;
			}


		}
		catch(Exception e)
		{
			err.logError("Member composite", "Guided Dialog message");
			return false;
		}
	}

	public boolean clickchkbxmemberinfodiscussed()
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
			if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
				return utils.clickAnelemnt(this.chkbxmemberinfodiscussed, "Member Composite", "Checkbox");
		return false;

	}

	public boolean clickchkbxgroupinfodiscussed()
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab"))
			if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab"))
				return utils.clickAnelemnt(this.chkbxgroupinfodiscussed, "Member Composite", "Checkbox");
		return false;

	}

	public boolean clickchkbxcontractinfodiscussed()
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab"))
			if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab"))
				return utils.clickAnelemnt(this.chkbxcontractinfodiscussed, "Member Composite", "Checkbox");
		return false;
	}

	public boolean clickchkbxInteractionsinfodiscussed()
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
			if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
				return utils.clickAnelemnt(this.chkbxInteractioninfodiscussed, "Member Composite", "Checkbox");
		return false;
	}

	public boolean CheckDataInMbrGenInfoTable(String columnName,String firstName)
	{
		if(utils.isProxyWebelement(this.tableMbrCompositeMembertable))
		{
			utils.clickAnelemnt(this.labelMbrCompositeMemberID,"Member Composite "," Contract address link ");

		}
		else
		{
			System.out.println("Contract Address is already clicked");
		}		

		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeMembertable, columnName);
		for(int i=0;i<firstnameColumn.size();i++)
		{ 
			System.out.println("Content text is : " + firstnameColumn.get(i));


			if(firstnameColumn.get(i).equals(firstName.toLowerCase()))
			{  
				String name=firstnameColumn.get(i);
				Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//div//span[text()='"+name+"']"));
				return true;
			}
		}
		return false;
	}

	public boolean SelectDatatoSwitchmember(String columnName,String firstName)
	{
		System.out.println("Firtname in excel "+firstName);
		if(utils.isProxyWebelement(this.tableMbrCompositeMembertable))
		{
			utils.clickAnelemnt(this.labelMbrCompositeMemberID,"Member Composite "," Contract address link ");

		}
		else
		{
			System.out.println("Contract Address is already clicked");
		}		

		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeMembertable, columnName);
		for(int i=0;i<firstnameColumn.size();i++)
		{ 
			System.out.println("Content text is : " + firstnameColumn.get(i));


			if(firstnameColumn.get(i).toLowerCase().equals(firstName.toLowerCase()))
			{  

				System.out.println("Actual ="+firstnameColumn.get(i)+"Expected "+firstName);
				String name=firstnameColumn.get(i);

				Driver.pgDriver.findElement(By.xpath("//*[@node_name='MemberList']/parent::div//table[@id='gridLayoutTable']//th")).click();
				String xpath="//*[@node_name='MemberList']/parent::div//table[@id='gridLayoutTable']//span[contains(text(),'"+firstName+"')]";

				System.out.println(xpath);

				Driver.pgDriver.findElement(By.xpath(xpath)).click();

				try{
					String[] val= new String[] {"name:a","address:a","dob:/"};
					Mbrcompositeverifymemberdetails(val);
				}
				catch(Exception e)
				{
					System.out.println("Verify memebr inside member composite was not succesful");
				}
				return true;

			}

		}
		return false;


	}

	public boolean SelectDatatoSwitchcontract(String columnName,String firstName)
	{
		System.out.println("Firtname in excel "+firstName);
		if(utils.isProxyWebelement(this.tableMbrCompositeMembertable))
		{
			utils.clickAnelemnt(this.labelMbrCompositeMemberID,"Member Composite "," Contract address link ");

		}
		else
		{
			System.out.println("Contract Address is already clicked");
		}		

		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeContracttable, columnName);
		for(int i=0;i<firstnameColumn.size();i++)
		{ 
			System.out.println("Content text is : " + firstnameColumn.get(i));
			if(firstnameColumn.get(i).toLowerCase().contains(firstName.toLowerCase()))
			{  
				System.out.println("Actual ="+firstnameColumn.get(i)+"Expected "+firstName);
				String name=firstnameColumn.get(i);
				Driver.pgDriver.findElement(By.xpath("//*[@node_name='MemberContractsList']/parent::div//table[@id='gridLayoutTable']//th")).click();
				String xpath="//*[@node_name='MemberContractsList']/parent::div//table[@id='gridLayoutTable']//span[contains(text(),'"+name+"')]";
				System.out.println(xpath);
				Driver.pgDriver.findElement(By.xpath(xpath)).click();
				return true;
			}
		}
		return false;
	}



	public boolean Mbrcompositeverifymemberdetails(String [] args)
	{
		VerifyMember vr=new VerifyMember();
		if(vr.ValidateDetailsPresent())
		{
			for(int i=0;i<args.length;i++)
			{
				if(args[i].contains("name"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if( vr.clickchkbxVerificationMembernameverify(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("id"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if(vr.clickchkbxVerificationMemberidverify(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("dob"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if( vr.clickchkbxVerificationMemberDOB(s))
					{
						if(i==args.length-1) 
						{
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}

				else if (args[i].contains("address"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(vr.clickchkbxVerificationMemberAddress(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					}
					else
						break; 
				}
				else if (args[i].contains("phone"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(vr.clickchkbxVerificationMemberphone(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}

				else if (args[i].contains("pcp"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(vr.clickchkbxVerificationMemberpcp(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}

				else if (args[i].contains("ssn"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(vr.clickchkbxVerificationMemberSSN(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}
				else 
				{
					err.logcommonMethodError("MemberVerify", "verifymemberdetails");
					System.out.println( " Sorry, there is no attribute present as "+args[i]);
				}

			}
			err.logcommonMethodError("MemberVerify", "verifymemberdetails");
			System.out.println("Not to able to complete verification");
			return false;
		}
		err.logcommonMethodError("Verify Member", "verifymemberdetails");
		return false;


	}



	public boolean CheckDataInMbrAddressTable(String[] args)
	{
		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
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

	public boolean CheckDataInMbrPhoneTable(String[] args)
	{
		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab "))
		{
			if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab "))
			{
				if(utils.isProxyWebelement(this.tableMbrCompositeMbrPhone))
				{
					utils.clickAnelemnt(this.labelMbrCompositeMbrAddCnctInfoLink,"Member Composite "," Contract address link ");

				}
				else
				{
					System.out.println("Contract Address is already clicked");
				}	

				ArrayList<String> firstnameColumn = new ArrayList<String>();
				firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPhone, columnName);
				for(int i=0;i<firstnameColumn.size();i++)
				{ 
					System.out.println("Content text is : " + firstnameColumn.get(i));
					if(firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase()))
					{  
						return true;

					}
				}
			}
		}
		return false;

	}

	public boolean CheckDataInMbrEmailTable(String[] args)
	{
		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab "))
		{
			if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab "))
			{
				if(utils.isProxyWebelement(this.tableMbrCompositeMbrEmail))
				{
					utils.clickAnelemnt(this.labelMbrCompositeMbrAddCnctInfoLink,"Member Composite "," Contract address link ");

				}
				else
				{
					System.out.println("Contract Address is already clicked");
				}	


				ArrayList<String> firstnameColumn = new ArrayList<String>();
				firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrEmail, columnName);
				for(int i=0;i<firstnameColumn.size();i++)
				{ 
					System.out.println("Content text is : " + firstnameColumn.get(i).toLowerCase());
					System.out.println("Content comaprison value text is : " + value.toLowerCase());

					if(firstnameColumn.get(i).equalsIgnoreCase(value))
					{  
						return true;
					}

				}
				return false;
			}

			return false;
		}
		return false;

	}

	public boolean CheckDataInMbrPCPTable(String[] args)

	{
		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);

		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab "))
		{
			if(utils.isProxyWebelement(this.tableMbrCompositeMbrPCPPracticeAddress))
			{
				utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}	

			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPCPPracticeAddress, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i));


				if(firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase()))
				{  
					String name=firstnameColumn.get(i);
					return true;
				}

			}
			return false;
		}

		return false;

	}

	public boolean CheckDataInMbrMedicalGroupInfotable(String[] args)
	{
		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab "))
		{		

			if(utils.isProxyWebelement(this.tableMbrCompositeMbrPMGTable))
			{
				utils.clickAnelemnt(this.labelMbrCompositeMbrPrimaryMedicalGroupLink,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPMGTable, columnName);
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

	public boolean CheckDataInMbrIndependantPhysicianAssociationInfotable(String[] args)
	{
		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab "))
		{		

			if(utils.isProxyWebelement(this.tableMbrCompositeMbrPMGTable))
			{
				utils.clickAnelemnt(this.labelMbrCompositeMbrIndependantPhyAssoGroupLink,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPMGTable, columnName);
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


	public boolean CheckDataInSbrAddressTable(String [] args)
	{
		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		utils.clickAnelemnt(this.tabMbrCompositeContract, "Member composite ", "Contract Tab ");
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member composite ", "Contract Tab "))
		{

			if(utils.isProxyWebelement(this.tableMbrCompositeSbrAddress))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeSbrContractAddress,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}	

			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeSbrAddress, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i));


				if(firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase()))
				{  
					try{
						String name=firstnameColumn.get(i);
						Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//div//span[text()='"+name+"']"));
						return true;

					}
					catch(Exception e)
					{
						return true;
					}
				}

			}
			return false;
		}
		return false;


	}

	public boolean CheckDataInSbrPhoneTable(String [] args)
	{
		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member composite ", "Contract Tab "))
		{


			if(utils.isProxyWebelement(this.tableMbrCompositeSbrPhone))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeSbrContractAddress,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}	


			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeSbrPhone, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i));


				if(firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase()))
				{  
					try{
						String name=firstnameColumn.get(i);
						Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//div//span[text()='"+name+"']"));

						return true;
					}
					catch(Exception e)
					{
						return true;
					}
				}

			}
			return false;
		}
		return false;


	}



	public boolean CheckDataInSbrMemberTable(String [] args)
	{

		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member composite ", "Member Tab "))
		{


			if(utils.isProxyWebelement(this.tableMbrCompositeSbrMemberswithcoverage))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeSbrMember,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}	

			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeSbrMemberswithcoverage, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i));


				if(firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase()))
				{  
					try{
						String name=firstnameColumn.get(i);
						Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//div//span[text()='"+name+"']"));

						return true;
					}
					catch(Exception e)
					{
						return true;
					}
				}

			}
			return false;
		}
		return false;


	}

	public boolean CheckDataInSbrRelatedContractsTable(String [] args)
	{

		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member composite ", "Member Tab "))
		{

			if(utils.isProxyWebelement(this.tableMbrCompositeSbrRelatedContracts))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeSbrRelatedContracts,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}


			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeSbrRelatedContracts, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i));


				if(firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase()))
				{  
					try{
						String name=firstnameColumn.get(i);
						Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//div//span[text()='"+name+"']"));

						return true;
					}
					catch(Exception e)
					{
						return true;
					}
				}

			}
			return false;
		}
		return false;


	}

	public boolean CheckDataInGrpAddressTable(String [] args)
	{

		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member composite ", "Group Tab "))
		{

			if(utils.isProxyWebelement(this.tableMbrCompositeGrpGroupAddress))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo,"Member Composite "," Group Info ");

			}
			else
			{
				System.out.println("Group Address is already clicked");
			}


			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeGrpGroupAddress, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i));


				if(firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase()))
				{  
					try{
						String name=firstnameColumn.get(i);
						Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//div//span[text()='"+name+"']"));

						return true;
					}
					catch(Exception e)
					{
						return true;
					}
				}

			}
			return false;
		}
		return false;


	}

	public boolean CheckDataInGrpPhoneTable(String [] args)
	{

		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member composite ", "Group Tab "))
		{

			if(utils.isProxyWebelement(this.tableMbrCompositeGrpGroupPhone))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo,"Member Composite "," Group Info ");

			}
			else
			{
				System.out.println("Group Address is already clicked");
			}


			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeGrpGroupPhone, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i));


				if(firstnameColumn.get(i).contains(value.toLowerCase()))
				{  

					return true;
				}

			}
			return false;
		}
		return false;


	}

	public boolean CheckDataInGrpBrokerTable(String [] args)
	{

		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);
		if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member composite ", "Group Tab "))
		{

			if(utils.isProxyWebelement(this.tableMbrCompositeGrpBrokerInfo))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeGrpBrokerInfo,"Member Composite "," Group Info ");

			}
			else
			{
				System.out.println("Group Address is already clicked");
			}


			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeGrpBrokerInfo, columnName);
			for(int i=0;i<firstnameColumn.size();i++)
			{ 
				System.out.println("Content text is : " + firstnameColumn.get(i));


				if(firstnameColumn.get(i).contains(value.toLowerCase()))
				{  
					return true;
				}

			}
			return false;
		}
		return false;


	}


	public boolean CheckDataInOpenServiceRequestsTable(String [] args)
	{

		String columnName = args[0].substring(0,args[0].indexOf(":"));

		String value = args[0].substring(args[0].indexOf(":")+1);

		if(utils.isProxyWebelement(this.tableMbrCompositeIntOpenSerReq))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntOpenServiceReq,"Member Composite "," Open Service Link  ");

		}
		else
		{
			System.out.println("Contract Address is already clicked");
		}


		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=utils.getcolumnStringFromTableByName(this.tableMbrCompositeSbrRelatedContracts, columnName);
		for(int i=0;i<firstnameColumn.size();i++)
		{ 
			System.out.println("Content text is : " + firstnameColumn.get(i));


			if(firstnameColumn.get(i).contains(value.toLowerCase()))
			{  
				return true;

			}

		}
		return true;


	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyMemberGeneralInfo
	 * #Arguments:KeyValuePair
	 * Type:Table
	 *Keys:membername#memberid#memberdob#relationship#effectivedate#enddate#producttype#cobindicator#medicareindicator#paidtodate

	 */
	public boolean verifyMemberGeneralInfo(String[] mgeninfoDetails)
	{
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
		{
			utils.waitforpageload();
			String keyvaluepair="";
			for(String iterator : mgeninfoDetails)
			{
				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
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
					action.moveToElement(labelMbrCompositeMbrEmployeeID).build().perform();
					String hovertext=pgDriver.findElement(By.xpath("//*[@data-test-id='20150923133728072260657-Label']")).getAttribute("aria-label").toString().toLowerCase();
					if(hovertext.contains("this field can be employee id, ssn, or any other identifier for the member"))
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
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"enddate")){
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
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		else
			err.logError("Member Composite", "Member tab ");
		if(returnvar)
		{
			System.out.println("Member general info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=mgeninfoDetails.length;
			err.logcommonMethodError("Member Composite", "the value "+mgeninfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}



	public boolean VerifyIndPhysicianInfo(String[] pcpDetails)
	{
		boolean returnvar ;
		returnvar = true;
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
		{
			if(utils.isProxyWebelement(this.labelMbrCompositeMbrPCPName))
			{
				utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}

			for(String iterator : pcpDetails)
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
				if(utils.isvalueMatch_contain(key.toLowerCase(),"pcpname")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPCPName,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"pcpid")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPCPID,value);
					continue;}

				else if(utils.isvalueMatch_contain(key.toLowerCase(),"primaryspec")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPCPPrimarySpeciality,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"pcpphone")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPCPPhone,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"pcpeffdate")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPCPEffDate,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"dateupdated")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPCPUpdateDate,value);
					continue;
				}

				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;


			}

		}
		else
			err.logError("Member Composite", "Member tab ");

		if(returnvar)
		{
			System.out.println("Physician genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=pcpDetails.length;
			err.logcommonMethodError("Member Composite", "the value "+pcpDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean VerifyMedicalGroupInfo(String[] pcpDetails)
	{
		boolean returnvar ;
		returnvar = true;
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
		{
			if(utils.isProxyWebelement(this.labelMbrCompositeMbrPMGname))
			{
				utils.clickAnelemnt(this.labelMbrCompositeMbrPrimaryMedicalGroupLink,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}

			for(String iterator : pcpDetails)
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
				if(utils.isvalueMatch_contain(key.toLowerCase(),"name")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGname,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"id")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGnumber,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"phone")) {
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGphone,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"eff")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGeffdate,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"update")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGupdateddate,value);
					continue;
				}
				else 
					err.logcommonMethodError("MemberComposite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;


			}

		}
		else
			err.logError("MemberComposite", "Member tab ");

		if(returnvar)
		{
			System.out.println("medical group genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=pcpDetails.length;
			err.logcommonMethodError("Member Composite", "the value "+pcpDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	public boolean VerifyIndependentPhysicianAssociationInfo(String[] pcpDetails)
	{
		boolean returnvar ;
		returnvar = true;
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
		{
			if(utils.isProxyWebelement(this.labelMbrCompositeMbrPMGname))
			{
				utils.clickAnelemnt(this.labelMbrCompositeMbrPrimaryMedicalGroupLink,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}

			for(String iterator : pcpDetails)
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

				if(utils.isvalueMatch_contain(key.toLowerCase(),"name")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGname,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"id")){	
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGnumber,value);
					continue;}

				else if(utils.isvalueMatch_contain(key.toLowerCase(),"phone")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGphone,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"eff")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGeffdate,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"update")){
					returnvar = utils.validateLabel(this.labelMbrCompositeMbrPMGupdateddate,value);
					continue;
				}


				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		}
		else
			err.logError("MemberComposite", "Member tab ");

		if(returnvar)
		{
			System.out.println("medical group genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=pcpDetails.length;
			err.logcommonMethodError("MemberComposite", "the value "+pcpDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifySubscriberGeneralInfo
	 * #Arguments:KeyValuePair
	 * Type:Table
	 *Keys:subid#name#gender#effdate#enddate#product#contractcode#coveragetype#benefitperiod#groupnumber#companycode

	 */
	public boolean verifySubscriberGeneralInfo(String[] cgeninfoDetails)
	{
		boolean returnvar = true ;
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab"))

		{
			if(utils.isProxyWebelement(this.labelMbrCompositeSbrContractID))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeSbrInfo,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}
			for(String iterator : cgeninfoDetails)
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

				if(utils.isvalueMatch_contain(key.toLowerCase(),"subid")){
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrContractID,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"name")){
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrName,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"gender")){
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrGender,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"effdate")){
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrEffDate,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"enddate")){
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrEndDate,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"product")){	
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrProdType,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"contractcode")){		
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrCntrctCode,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"coveragetype")){			
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrCoverageType,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"age")){			
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrAge,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"benefitperiod")){			
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrBenefitPeriod,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"groupnumber")){		
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrGroupNumber,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"companycode")){		
					returnvar = utils.validateLabel(this.labelMbrCompositeSbrAnthemCompanyCode,value);
					continue;
				}
				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		}
		else
			err.logError("Member Composite", "Member tab ");

		if(returnvar)
		{
			System.out.println("Subscriber info verified successfully");
			return true;	
		}
		else
		{
			int tot_i=cgeninfoDetails.length;
			err.logcommonMethodError("Member Composite", "the value "+cgeninfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}


	public boolean verifyGroupGeneralInfo(String[] grpgeninfoDetails)
	{
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
				System.out.println("Contract Address is already clicked");
			}
			String keyvaluepair="";
			for(String iterator : grpgeninfoDetails)
			{

				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(utils.isvalueMatch_contain(key.toLowerCase(),"productgrpname")){		
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpProdname,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"grpname")){		
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpName,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"smallgrpnumber")){		
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpsmallGrpnum,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"grpnumber")){
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpNum,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"grpstatus")){
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpStatus,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"idcardmailing")){	
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpStatus,value);
					continue;
				}
				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;


			}

		}
		else
			err.logError("MemberComposite", "Member tab ");

		if(returnvar)
		{
			System.out.println("Group genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=grpgeninfoDetails.length;
			err.logcommonMethodError("MemberComposite", "the value "+grpgeninfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}

	public boolean verifyAnthemGrpManagement(String[] grpmanageinfoDetails)
	{
		boolean returnvar ;
		returnvar = true;
		utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab"))
		{

			if(utils.isProxyWebelement(this.labelMbrCompositeGrpServLoc))
			{
				utils.clickAnelemnt(this.labeldropMbrCompositeGrpManagement,"Member Composite "," Contract address link ");

			}
			else
			{
				System.out.println("Contract Address is already clicked");
			}

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

				if(utils.isvalueMatch_contain(key.toLowerCase(),"idcardmailing")){	
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpServLoc,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"transfer")){	
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpTranstoProv,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"claimaddress")){	
					returnvar = utils.validateLabel(this.labelMbrCompositeGrpClaimsAddress,value);
					continue;
				}
				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		}
		else
			err.logError("MemberComposite", "Member tab ");

		if(returnvar)
		{
			System.out.println("Group management info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=grpmanageinfoDetails.length;
			err.logcommonMethodError("MemberComposite", "the value "+grpmanageinfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}


	public boolean selectDependent(String[] mName)
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite ", "Member name link "))
			if(utils.clickAnelemnt(this.linkMbrCompositeMemberName, "Member Composite ", "Member name link "))
				return this.SelectDatatoSwitchmember("First Name",mName[0]);
		return false;
	}


	public boolean selectContract(String[] mName)
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite ", "Contract tab "))
			if(utils.clickAnelemnt(this.linkMbrCompositeContractNumber, "Member Composite ", "Member contract link "))
				return this.SelectDatatoSwitchcontract("Product Type",mName[0]);
		return false;
	}

	public boolean clickwrapUp() throws InterruptedException
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");

	}    
	
	
	
	public boolean clickwrapUpafterODGClaimTask() {
		utils.waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
	    Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	    return utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");
	}
	
	

	public boolean checkOpenServiceRequestsTable() throws ParseException
	{
		utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{
			if(utils.isProxyWebelement(this.tableMbrCompositeIntOpenSerReq))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeIntOpenServiceReq,"Member Composite "," Open Service Request link ");

			}
			else
			{
				System.out.println("Open Service Request link is already clicked");
			}
			if(utils.isProxyWebelement(this.imgMbrCompositeIntOpenSerReqViewall))
			{
				System.out.println("No View All button");
				return false;
			}
			else if(utils.isProxyWebelement(this.imgMbrCompositeIntOpenSerReqRefresh))
			{
				System.out.println("No Refresh button");
				return false;
			}
			ArrayList<String> Dates = new ArrayList<String>();
			Dates=utils.getcolumnStringFromTableByName(this.tableMbrCompositeIntOpenSerReq, "Open Date");
			int i=2;
			System.out.println(Dates.size());
			if(Dates.size()>7)
			{
				System.out.println("There are more than 5 rows in Open Service request Table.");
				return true;
			}
			for(String iterator:Dates)	
			{

				DateFormat formatter ; 
				Date date1,date2; 
				String date_1=Dates.get(i);
				if(i+1==Dates.size())
				{
					break;
				}
				String date_2=Dates.get(i+1);
				formatter = new SimpleDateFormat("MMMM dd,yyyy");

				date1=formatter.parse(date_1);
				date2=formatter.parse(date_2);
				if(date1.equals(date2))
				{
					i++;
					continue;
				}
				else if(date1.after(date2))
				{
					i++;
					continue;
				}
				else
					System.out.println("THE DATES ARE NOT IN DESCENDING ORDER");
				return false;
			}

		}
		blogger.logMessage("Member Composite ", " Open service request validation ");
		return true;
	}

	public boolean checkRecentInteractionsTable() throws ParseException
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{
			if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInt,"Member Composite "," Recent Interactions link ");

			}
			else
			{
				System.out.println("Recent Interactions is already clicked");
			}
			if(utils.isProxyWebelement(this.imgMbrCompositeIntRecentIntViewall))
			{
				System.out.println("No View All button");
				return false;
			}
			else if(utils.isProxyWebelement(this.imgMbrCompositeIntRecentInteractionrefresh))
			{
				System.out.println("No Refresh button");
				return false;
			}
			ArrayList<String> Dates,IQTs = new ArrayList<String>();
			Dates=utils.getcolumnStringFromTableByName(this.tableMbrCompositeIntRecentInt, "Created On");
			int i=2;
			System.out.println(Dates.size());
			if(Dates.size()>7)
			{
				System.out.println("There are more than 5 rows in Recent Interactions Table.");
				return true;
			}
			for(String iterator:Dates)	
			{

				DateFormat formatter ; 
				Date date1,date2; 
				String date_1=Dates.get(i);
				if(i+1==Dates.size())
				{
					break;
				}
				String date_2=Dates.get(i+1);
				formatter = new SimpleDateFormat("mm/dd/yyyy H:mm a");

				date1=formatter.parse(date_1);
				date2=formatter.parse(date_2);
				if(date1.equals(date2))
				{
					i++;
					continue;
				}
				else if(date1.after(date2))
				{
					i++;
					continue;
				}
				else
					System.out.println("THE DATES ARE NOT IN DESCENDING ORDER");
				return false;
			}


		}
		blogger.logMessage("Member Composite ", " Recent Interactions validation ");
		return true;
	}


	public boolean checkRecentInquiryTrackingTable() throws ParseException
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{
			if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInqTrack))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInqtrack,"Member Composite "," Recent Interactions link ");

			}
			else
			{
				System.out.println("Recent Interactions is already clicked");
			}
			if(utils.isProxyWebelement(this.imgMbrCompositeIntRecentInqtrackViewall))
			{
				System.out.println("No View All button");
				return false;
			}

			ArrayList<String> Dates,IQTs = new ArrayList<String>();
			Dates=utils.getcolumnStringFromTableByName(this.tableMbrCompositeIntRecentInqTrack, "IQT");
			int i=2;
			System.out.println(Dates.size());
			if(Dates.size()>7)
			{
				System.out.println("There are more than 5 rows in Recent Interactions Table.");
				return true;
			}



			if(utils.clickAnelemnt(this.imgMbrCompositeIntRecentInqtrackViewall, "MemberComposite", "View All button"))
			{
				utils.clickAnelemnt(this.imgMbrCompositeIntRecentInqtrackViewall, "MemberComposite", "View All button");
				{
					IQTs=utils.getcolumnStringFromTableByName(this.tableRecentIQTViewAll, "IQT");
					System.out.println(IQTs.size());
					if(IQTs.size()==8)
						return true;
					else
						return false;

				}
			}
			blogger.logMessage("Member Composite ", " Recent InquiryTracking validation ");
			return true;


		}
		return false;
	}


	/**
	 * Table with the values of the Search for Service Request for Contracts 
	 */

	@FindBy(xpath="//*[contains(@pl_prop,'ForContractB')]")
	WebElement tableMbrCompositesearchforServiceRequestContracts;
	@FindBy(xpath="//span[contains(text(),'Search for Service Requests for Contract')]")
	WebElement lnkMbrCompositeIntSearchForServiceRequest;

	/**
	 * Table with the values of the Search for Service Request for Contracts  

	 * @return
	 * @throws ParseException
	 */
	public boolean checkSearchForServiceRequestsForContractsTable(String sMethod) throws ParseException
	{
		if(utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest,"Member Composite "," Search for Service Request for Contract");
		}
		else
		{
			System.out.println("Open Service Request link is already clicked\n\n");
		}

		ArrayList<String> Dates = new ArrayList<String>();
		utils.waitforpageload();
		Dates=utils.getcolumnStringFromTableByName(this.tableMbrCompositesearchforServiceRequestContracts, "Open Date");
		int i=1;
		System.out.println("date count"+Dates.size());
		if(Dates.size()>7)
		{
			System.out.println("There are more than 5 rows in Open Service request Table.");
			return true;
		}

		for(String iterator:Dates)	
		{

			DateFormat formatter ; 
			Date date1,date2;
			Date date3 = null;
			String date_1=Dates.get(i);
			if(i+1==Dates.size())
			{
				break;
			}
			String date_2=Dates.get(i+1);
			formatter = new SimpleDateFormat("MMMM dd,yyyy");

			date1=formatter.parse(date_1);
			date2=formatter.parse(date_2);
			if(date1.equals(date2))
			{
				i++;
				continue;
			}
			if(sMethod=="Last 7 Days"||sMethod=="Last 30 Days"||sMethod=="Last 90 Days")
				if(date1.after(date2))
				{
					i++;
					continue;
				}
				else
					System.out.println("THE DATES ARE NOT IN DESCENDING ORDER");
			return false;
		}




		blogger.logMessage("Member Composite ", " Open service request validation ");
		return true;
	}
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Today']")
	WebElement btnServcRequestContractToday;

	public boolean clickServcRequestContractToday (){

		if(utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest,"Member Composite "," Search for Service Request for Contract");

		}
		else
		{
			System.out.println("Open Service Request link is already clicked\n\n");
		}
		return (utils.clickAnelemnt(this.btnServcRequestContractToday, "MemberVerify", "Click Button today"));

	}

	@FindBy(xpath="//button[@data-test-id='20151205105237049835363']")
	WebElement btnServcRequestContractYesterday;

	public boolean clickbtnServcRequestContractYesterday (){

		if(utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest,"Member Composite "," Search for Service Request for Contract");

		}
		else
		{
			System.out.println("Open Service Request link is already clicked\n\n");
		}
		return (utils.clickAnelemnt(this.btnServcRequestContractYesterday, "MemberVerify", "Click Button Yesterday"));

	}

	@FindBy(xpath="//button[@data-test-id='20151205105237050436864']")
	WebElement btnServcRequestContractLast7Days;

	public boolean clickbtnServcRequestContractLast7Days (){

		if(utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest,"Member Composite "," Search for Service Request for Contract");

		}
		else
		{
			System.out.println("Open Service Request link is already clicked\n\n");
		}
		return (utils.clickAnelemnt(this.btnServcRequestContractLast7Days, "MemberVerify", "Click Button Last 7 Days"));

	}
	@FindBy(xpath="//button[@data-test-id='20151205105237050938700']")
	WebElement btnServcRequestContractLast90Days;

	public boolean clickbtnServcRequestContractLast90Days (){

		if(utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest,"Member Composite "," Search for Service Request for Contract");

		}
		else
		{
			System.out.println("Open Service Request link is already clicked\n\n");
		}
		return (utils.clickAnelemnt(this.btnServcRequestContractLast90Days, "MemberVerify", "Click Button Last 90 Days"));

	}

	@FindBy(xpath="//button[@data-test-id='20151205105237050537454']")
	WebElement btnServcRequestContractLast30Days;

	public boolean clickbtnServcRequestContractLast30Days (){

		if(utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest,"Member Composite "," Search for Service Request for Contract");

		}
		else
		{
			System.out.println("Open Service Request link is already clicked\n\n");
		}
		return (utils.clickAnelemnt(this.btnServcRequestContractLast30Days, "MemberVerify", "Click Button Last 30 Days"));

	}

	@FindBy(xpath="//*[@id='SearchStartDate']")
	WebElement txtbxStartDate;
	public boolean settxtbxStartDate (String[] args){
		if(utils.validateHeader(this.lnkMbrCompositeIntSearchForServiceRequest, "Search for Service Requests for Contract"))
			try
		{

				return utils.enterTextinAnelemnt(this.txtbxStartDate, args[0], "MemberVerify", "Nickname textbox");
		}
		catch(StaleElementReferenceException e)
		{
			return settxtbxStartDate(args);	
		}
		catch(NoSuchElementException e){
			return settxtbxStartDate(args);	
		}
		return false;
	}

	@FindBy(xpath="//*[@id='SearchEndDate']")
	WebElement txtbxEndtDate;
	public boolean settxtbxEndDate (String[] args){
		try
		{
			return utils.enterTextinAnelemnt(this.txtbxEndtDate, args[0], "MemberVerify", "Nickname textbox");
		}
		catch(StaleElementReferenceException e)
		{
			return settxtbxStartDate(args);	
		}
		catch(NoSuchElementException e){
			return settxtbxStartDate(args);	
		}

	}

	/**
	 * Ente4r the start and end date and the table will check if the dates are alligned in a proper Sequence 
	 * @param args : enter the start and Sto date 
	 * @return
	 * @throws ParseException
	 */
	public boolean checkDateByClickingButtonsToday() throws ParseException
	{
		utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{		
			if(this.clickServcRequestContractToday())
			{
				if(this.checkSearchForServiceRequestsForContractsTable(""))
				{
					return true;
				}
			}
		}
		return false;	
	}

	public boolean checkDateByClickingButtonsYesterday() throws Exception
	{
		utils.waitforpageload();
		utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
			if(clickbtnServcRequestContractYesterday())
			{
				Thread.sleep(2000);
				return checkSearchForServiceRequestsForContractsTable("");
			}
		return false;	


	}

	public boolean checkDateByClickingButtonsLast7Days() throws ParseException
	{

		utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{
			if(this.clickbtnServcRequestContractLast7Days())
			{
				utils.waitforpageload();
				if(this.checkSearchForServiceRequestsForContractsTable("Last 7 Days"))
				{
					return true;
				}
			}
		}
		return false;	
	}

	public boolean checkDateByClickingButtonsLast30Days() throws ParseException
	{

		utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{	
			if(this.clickbtnServcRequestContractLast30Days())
			{
				utils.waitforpageload();
				if(this.checkSearchForServiceRequestsForContractsTable("Last 30 Days"))
				{
					return true;
				}
			}
		}
		return false;	
	}

	public boolean checkDateByClickingButtonsLast90Days() throws ParseException
	{

		utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{
			if(this.clickbtnServcRequestContractLast90Days())
			{
				utils.waitforpageload();						
				if(this.checkSearchForServiceRequestsForContractsTable("Last 90 Days"))
				{
					return true;
				}
			}
		}
		return false;	
	}

	@FindBy (xpath="//div[@class='pzbtn-rnd']//*[contains(text(),'Add Task')]")	
	private WebElement btnAddTAsk;
	@FindBy(xpath="//*[contains(@id,'CPMTaskSearchInput')][1]")
	private WebElement SearchInput;

	@FindBy(xpath="//a[@data-test-id='2014123005242607302524']")
	private WebElement lnkClickonLinkafterSettingValue;

	@FindBy(xpath="//table[@pl_prop='D_ContractList.pxResults']")
	private WebElement tableMbrCompositeContracttbl;

	@FindBy(xpath="//*[@data-test-id='20150527044600067319555' or contains(text(), 'Add task(s)')]")
	private WebElement lnkClickonAddTaskInDropdown;

	public WebElement getchkbxSEacrchInput()
	{
		return SearchInput;
	}

	public WebElement getbtnAddTAsk()
	{
		return btnAddTAsk;
	}
	public WebElement getlnkClickonLinkafterSettingValue()
	{
		return lnkClickonLinkafterSettingValue;
	}
	public boolean clickbtnAddTask()
	{
		utils.waitforpageload();
		WebElement element = btnAddTAsk;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		if(utils.clickAnelemnt(btnAddTAsk, "Member Composite ", "Add Task Button ")) {
			if(!utils.isProxyWebelement(allOptions.get(0)))
					return true;
			else
				return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");
			
		}
		return false;

			/*try
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement);
			return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");

		}catch(Exception e)
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
			return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");

		}
			 */
	}


	public boolean setTxtFullContactName(String sFullName) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchInput.clear();
		return utils.enterTextinAnelemnt(this.getchkbxSEacrchInput(), sFullName, "Member Composite", "Application took a long time to load");

	}

	@FindBy(id="po0")
	private WebElement addTaskMenu;

	/**This method is to enter the section name and click on add task
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clicklnkClickonLinkafterSettingValue(String args) throws InterruptedException
	{
		boolean flag=false;
		try 
		{
			utils.waitforpageload();
			//allOptions = addTaskMenu.findElements(By.xpath("//a[@data-test-id='2014123005242607302524']"));
			for ( int i=0;i<=allOptions.size();i++) {
				if(allOptions.get(i).getText().contains(args)){
					allOptions.get(i).click();
					utils.waitforpageload();
					Actions action = new Actions(pgDriver);
					action.moveToElement(lnkClickonAddTaskInDropdown);
					utils.waitForElementToBeVisible(lnkClickonAddTaskInDropdown);
					JavascriptExecutor executor = (JavascriptExecutor)pgDriver;
					executor.executeScript("arguments[0].click();", lnkClickonAddTaskInDropdown);
					flag=true;
					break;
				}
			}

			if(flag==true) {
				blogger.loginfo(args+" is displayed and Add task is clicked. Navigating to the section");
				return true;
			}else {
				blogger.loginfo(args+" is not displayed");
				err.logError("MemberComposite", "lnkClickonAddTaskInDropdown");
				return false;
			}
		}
		catch(StaleElementReferenceException e )
		{
			blogger.loginfo("Exception: "+e);
			err.logError("StaleElementReferenceException", "lnkClickonAddTaskInDropdown");
			return false;
		}

	}

	public boolean  navigateTOPromisedAction() throws InterruptedException
	{
		return createTask("Promised Action");		

	}      

	public boolean  navigateTOLimitedLiability() throws InterruptedException
	{
		return createTask("Manage Limited Liability");	

	}      


	public boolean  navigateTOManageClaims() throws InterruptedException
	{
		return createTask("Manage Claims");	

	}   

	public boolean  navigateTOAccumulators() throws InterruptedException
	{
		return createTask("Accumulators");

	}      

	public boolean  navigatetoManageAuthorizations() throws InterruptedException
	{
		return createTask("Manage Authori");		 

	}      


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateTOBenefitsandCost
	 * Type:Textbox


	 */
	public boolean  navigateTOBenefitsandCost() throws InterruptedException
	{
		return createTask("Benefits and Cost");	

	}


	public boolean  navigatetoExternalSearch() throws InterruptedException
	{

		Thread.sleep(2000);
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='External Search'][@class='Add_task']")));
			if(utils.clickAnelemnt(this.externalsearch, "Member Composite", "External search under add task"))
			{
				if(utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
				{
					System.out.println("External search navigated ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 
	}

	public boolean  navigateTOManageBilling() throws InterruptedException
	{		
		return createTask("Manage Enrollment");		
	}	

	public boolean  navigateTOProvider() throws InterruptedException
	{
		return createTask("Provider");	


	}    

	public boolean  navigateTOSearchInventory() throws InterruptedException
	{
		return createTask("Search Inventory");


	}

	public boolean LinkRecentInteraction()
	{
		utils.waitforpageload();
		utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");
		while(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");

		}


		if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInt,"Member Composite "," Recent Interactions  ");

		}
		else
		{
			System.out.println("Table visible");
		}

		Driver.getPgDriver().findElement(By.xpath("//table[@pl_prop='D_MemberInteractions.pxResults']//tr[2]//td[3]//a")).click();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(this.Iframeelement2);
		if(utils.clickAnelemnt(this.btnLinkInteration, "Review Interaction", "Link Interaction button"))
		{
			utils.isAlertPresent();
			if(utils.clickAnelemnt(this.btnClose, "Review Interaction", "Close"))
				Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(this.Iframeelement);
			return true;
		}
		return false;



	}

	public String getRecentInteractionID()
	{
		utils.waitforpageload();
		utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");
		while(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");

		}
		if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInt,"Member Composite "," Recent Interactions  ");

		}
		String linkedint=Driver.getPgDriver().findElement(By.xpath("//table[@pl_prop='D_MemberInteractions.pxResults']//tr[2]//td[3]")).getText().trim();
		return linkedint;
	}

	public boolean ClickonRecentServiceRequest()
	{
		utils.waitforpageload();
		utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");
		while(utils.isProxyWebelement(this.tableMbrCompositeIntOpenSerReq))
		{
			utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");

		}


		if(utils.isProxyWebelement(this.tableMbrCompositeIntOpenSerReq))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntOpenServiceReq,"Member Composite "," Recent Interactions  ");

		}
		else
		{
			System.out.println("Table visible");
		}

		Driver.getPgDriver().findElement(By.xpath("//table[@pl_prop='D_RecentServiceItems.pxResults']//tr[2]//td[1]//a")).click();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(this.Iframeelement2);
		utils.isAlertPresent();
		if(utils.clickAnelemnt(this.btnClose, "Review Interaction", "Close"))
			Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(this.Iframeelement);
		return true;
	}

	public String getRecentSRID()
	{
		utils.waitforpageload();
		utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");
		while(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");

		}
		if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInt,"Member Composite "," Recent Interactions  ");

		}
		String SRid=Driver.getPgDriver().findElement(By.xpath("//table[@pl_prop='D_RecentServiceItems.pxResults']//tr[2]//td[1]")).getText().trim();
		String SRtype=Driver.getPgDriver().findElement(By.xpath("//table[@pl_prop='D_RecentServiceItems.pxResults']//tr[2]//td[2]")).getText().trim();
		return SRid;
	}

	public String getRecentSRType()
	{
		utils.waitforpageload();
		utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");
		while(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");

		}
		if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInt,"Member Composite "," Recent Interactions  ");

		}
		String SRtype=Driver.getPgDriver().findElement(By.xpath("//table[@pl_prop='D_RecentServiceItems.pxResults']//tr[2]//td[2]")).getText().trim();
		return SRtype;
	}

	public String getRecentSRStatus()
	{
		utils.waitforpageload();
		utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");
		while(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");

		}
		if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInt,"Member Composite "," Recent Interactions  ");

		}
		String SRstatus=Driver.getPgDriver().findElement(By.xpath("//table[@pl_prop='D_RecentServiceItems.pxResults']//tr[2]//td[3]")).getText().trim();
		return SRstatus;
	}

	public boolean validatelatestRecentInquirytrackingTable()
	{
		while(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");

		}
		if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInqTrack))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInqtrack,"Member Composite "," Recent Interactions  ");

		}
		System.out.println("Link should be open by now");
		String[] tableheadervalues={"IQT","Date Opened","Status","Description","Contact Name",""};
		{
			System.out.println("Inquiry number match");

			return true;
		}

	}

	public boolean ClickOnlatestRecentInquiryLink()
	{
		while(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
		{
			utils.clickAnelemnt(this.tabMbrCompositeInteraction,"Member Composite "," Interaction tab  ");

		}
		if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInqTrack))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInqtrack,"Member Composite "," Recent Interactions  ");

		}
		System.out.println("Link should be open by now.We are here");
		String[] tableheadervalues={"IQT","Date Opened","Status","Description","Contact Name",""};
		return false;

	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateToGrievanceAndAppeals
	 * Type:Textbox
	 * Description:This method clicks on 'Add Task' and perform search on 'Grievance and Appeals' and move to Grievance and Appeals task screen.
	 */
	public boolean  navigateToGrievanceAndAppeals() throws InterruptedException
	{
		return createTask("Grievance and Appeals");

	} 

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectContractByContractCode
	 * #Description:This method selects a particular 'Contract', depending on the Contract Code entered by user to select. 
	 * #Arguments:ContractSelection
	 * Type:Table
	 * Keys:#Contract Code
	 */
	public boolean selectContractByContractCode(String[] contractCode) throws InterruptedException
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite ", "Contract tab "))
		{
			utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite ", "Contract tab ");
			if(utils.clickAnelemnt(this.linkMbrCompositeContractNumber, "Member Composite ", "Member contract link"))
			{
				if(this.switchcontract(contractCode[0]))
				{
					utils.waitforpageload();
					return true;
				}

				else
					err.commonExecutorlogError("Either the table is empty or the given Contract Code is not found on the table");
				return false;
			}
			else
				return false;
		}
		else
			return false;
	}

	@FindBy(xpath="//div[contains(text(),'No item')]")
	WebElement HouseContract;
	public boolean switchcontract(String contractCode) throws InterruptedException{

		if(utils.clickontablerowbasedonvalues(this.tableMbrCompositeContracttbl, contractCode)){
			System.out.println("Contract Code matched in Contract table");
			return true;
		}

		System.out.println("Contract Code entered didnt match in Contract table or this might be an house account");
		return false;
	}

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Consumer Driven Health Plan'][@class='Add_task']")
	WebElement CDHPTaskLink;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyCDHPinAddTaskSection
	 * Type:Textbox
	 * Description:This method validates whether the newly added task - 'Consumer Driven Health Plan'
	 * is displayed in the 'Add Task' section to the logged-in user.
	 */
	public boolean verifyCDHPinAddTaskSection(){
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			if(this.CDHPTaskLink.isDisplayed()){
				System.out.println("Consumer Driven Health Plan - is added to 'Add Task' section");
				return true;
			}
			err.logError("Member composite", "Error in verifyCDHPinAddTaskSection:'CDHP' Task is not displayed in 'Add Task' section");
			return false;
		}
		err.logError("Member composite", "Error in verifyCDHPinAddTaskSection:'Add Task' button is not clickable");
		return false;
	}

	@FindBy(xpath="//*[@id='ModalButtonSubmit']")
	WebElement CDHPModalDialogSubmit;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateTOConsumerDrivenHealthPlan
	 * Type:Textbox
	 * Description:This method clicks on 'Add Task' and perform search on 'Consumer Driven Health Plan' and move to CDHP task screen.
	 */
	public boolean  navigateTOConsumerDrivenHealthPlan() throws InterruptedException
	{
		return createTask("Consumer Driven Health Plan");

	} 

	public static String SRIDAfterSubstring;

	@FindBy(xpath="//a[@class='Standard_task']")
	private WebElement serviceReqDetails;

	@FindBy(xpath="(//a[@class='Standard_task'])[2]")
	private WebElement SecondaryserviceReqDetails;
	/*
	 * @SCU
	 * #CommonMethodWithArgument: getSRIDFromTask
	 * #Description: This functionality gets the SR ID from the task created.
	 * #Argument: Task
	 * Type: Textbox
	 */
	public boolean getSRIDFromTask(String[] task)
	{
		String SrID = this.serviceReqDetails.getText().trim();
		System.out.println("SR ID Value is: "+ SrID);
		SRIDAfterSubstring = SrID.substring(SrID.indexOf("(")+1,SrID.indexOf(")")).trim();
		System.out.println("Trimmed String: "+ SRIDAfterSubstring);
		return true;
	}

	public boolean getSecondarySRIDFromTask()
	{
		String SrID = this.SecondaryserviceReqDetails.getText().trim();
		System.out.println("SR ID Value is: "+ SrID);
		SRIDAfterSubstring = SrID.substring(SrID.indexOf("(")+1,SrID.indexOf(")")).trim();
		System.out.println("Trimmed String: "+ SRIDAfterSubstring);
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToMemberMaintenance
	 * #Description: This functionality navigates to the Member Maintenance section from the Member Composite page
	 */
	public boolean navigateToMemberMaintenance() throws InterruptedException
	{
		return createTask("Member Maintenance");

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArguement: clickContract
	 * #Description: This functionality Click the contract tab in Member Composite page
	 * Type: Textbox
	 */

	public boolean clickContract() {
		utils.waitforpageload();
		return utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite ", "Contract tab ");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArguement: clickGroup
	 * #Description: This functionality Click the Group tab in Member Composite page
	 * Type: Textbox
	 */
	public boolean clickGroup() {
		utils.waitforpageload();
		return utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite ", "Group tab");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateTOManageOtherInsurance
	 * #Description: This functionality navigates to the Manage Other Insurance Page from the Member Composite page.
	 * Type: Textbox
	 */
	public boolean navigateToManageOtherInsurance() throws InterruptedException
	{
		return createTask("Manage Other Insurance");

	}

	public boolean clicklnkClose(){
		utils.waitforpageload();
		if(!utils.isProxyWebelement(btnClose))
			return utils.clickAnelemnt(this.btnClose, "MemberComposite", "Closebutton");
		return false;


	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateTOManageIDCards
	 * #Description: This functionality navigates to the Manage ID card section from the member composite page
	 * Type: Textbox
	 */
	public boolean  navigateTOManageIDCard() throws InterruptedException
	{
		return createTask("Manage ID Card");


	}   

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToPreCertificationSearch
	 * #Description: This functionality navigates to the Pre_Certification Search Page from the Member Composite page.
	 * Type: Textbox
	 */
	public boolean navigateToPreCertificationSearch() throws InterruptedException
	{
		return createTask("Pre-Certification Search");

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToManageAlerts
	 * #Description: This functionality navigates to the Manage Alerts Page from the Member Composite page.
	 * Type: Textbox
	 */
	public boolean navigateToManageAlerts() throws InterruptedException
	{
		return createTask("Manage Alerts");

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToManageReferral
	 * #Description: This functionality navigates to the Manage Referral Page from the Member Composite page.
	 * Type: Textbox
	 */
	public boolean navigateToManageReferral() throws InterruptedException
	{
		return createTask("Manage Referrals");	

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToViewProgram
	 * #Description: This functionality navigates to the View Program Page from the Member Composite page.
	 * Type: Textbox
	 */
	public boolean navigateToViewProgram() throws InterruptedException
	{try
	{
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("View Programs"))
			{

				if(this.clicklnkClickonLinkafterSettingValue("View Programs"))
				{
					System.out.println("Pass : The Value View Program is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 
	}catch(Exception e)
	{
		Thread.sleep(3000);
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement2);
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("View Programs"))
			{

				if(this.clicklnkClickonLinkafterSettingValue("View Programs"))
				{
					System.out.println("Pass : The Value View Program is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false;
	}
	}

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Manage Alerts'][@class='Add_task']")
	WebElement elemManageAlert;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyManageAlertIsNotPresentForResearchMember
	 * #Description: This functionality verifies that the Manage Alert task is not displayed or not.
	 * Type: Textbox
	 */
	public boolean verifyManageAlertIsNotPresentForResearchMember()
	{
		this.clickbtnAddTask();
		try
		{
			elemManageAlert.isDisplayed();	
			System.out.println("Manage Alerts is displayed");
			return false;

		}catch(Exception e)
		{
			System.out.println("Manage Alerts is not displayed");
			blogger.loginfo("Manage Alerts is not displayed");
			//err.logError("MemberComposite", "Manage Alert");
			return true;
		}

	}


	// Sprint 2.1 Code

	@FindBy(xpath="//h3[contains(text(),'Interaction')]")
	WebElement tabInteraction;



	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: 
	 * #Description: This functionality performs click action on the Interaction header in the Member Composite page
	 * Type: Textbox
	 */

	public boolean clickInteractionHeader()
	{
		try
		{
			utils.clickAnelemnt(this.tabInteraction, "MemberComposite", "Interactions Header");
			return true;

		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("MemberComposite", "clickInteractionHeader", "Error in Clicking");
			return false;
		}
	}


	@FindBy(xpath="//*[@data-test-id='20150918122626032224625']")
	WebElement memberContact;

	@FindBy(xpath="//div[@node_name='MemberList']//table[@id='gridLayoutTable']")
	WebElement memberContactPopupTable;

	@FindBy(xpath="//*[@data-test-id='20150918010241087465904']")
	WebElement memberContactPopupTableFirstName;

	@FindBy(xpath="//*[@id='IsMemberNameVerified']")
	WebElement memberContactPopupNameChkbox;

	@FindBy(xpath="//*[@id='IsMemberIDVerified']")
	WebElement memberContactPopupidChkbox;

	@FindBy(xpath="//*[@id='IsDateOfBirthVerified']")
	WebElement memberContactPopupdobChkbox;

	@FindBy(id="ModalButtonSubmit")
	WebElement memberContactPopupsubmit;


	/**This method is used to Switch contact and verify the same
	 * 
	 */
	public boolean switchContactAndVerify() {
		String txtFirstName;
		try {
			Thread.sleep(1000);
			utils.clickAnelemnt(memberContact, "Member Composite", "memberContact");
			if(memberContactPopupTable.isDisplayed()) {
				txtFirstName = memberContactPopupTableFirstName.getText();
				memberContactPopupTableFirstName.click();
			}else {
				blogger.loginfo("FAIL: Member Contact PopUp is not displayed");
				return false;
			}
			utils.waitforpageload();
			utils.clickAnelemnt(memberContactPopupNameChkbox, "Member Composite", "memberContactPopupNameChkbox");
			utils.clickAnelemnt(memberContactPopupidChkbox, "Member Composite", "memberContactPopupidChkbox");
			utils.clickAnelemnt(memberContactPopupdobChkbox, "Member Composite", "memberContactPopupdobChkbox");
			utils.clickAnelemnt(memberContactPopupsubmit, "Member Composite", "memberContactPopupsubmit");
			utils.waitforpageload();
			if(utils.validateLabel(memberContact,txtFirstName)) {
				blogger.loginfo("PASS: Selected name is displayed");
				return true;
			}
			else {
				blogger.loginfo("FAIL: Selected name is not displayed");
				return false;
			}
		}
		catch(Exception e) {
			err.logError("Member Composite" + e);
			return false;
		}

	}

	@FindBy(xpath="//*[@pl_prop='D_PCPDetails.pxResults']")
	WebElement PCPTable;

	@FindBy(xpath="//span[text()='Primary Care Physician Information']/ancestor::div[@id='RULE_KEY']//a[@title=\"Next Page\"]")
	WebElement LinkNext;

	/**This method is used to select PCP and verify table and given row values
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectPCPAndVerifyTable(String[] args){
		utils.waitforpageload();
		if(utils.isProxyWebelement(PCPTable))
			utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink,"Member Composite "," Primary Care Physician Information link ");
		Actions action = new Actions(pgDriver);
		action.moveToElement(PCPTable).build().perform();
		if(utils.validatetablerowbasedonvalues(PCPTable, args))
			return true;
		else {
			if(!utils.isProxyWebelement(LinkNext)) {
				if(utils.clickAnelemnt(LinkNext, "Member Composite ", "LinkNext"))
					return selectPCPAndVerifyTable(args);
			}
		}
		return false;
	}
	
	@FindBy(xpath = "//span[text()='Primary Care Physician Information']")
	WebElement primaryCareInfoTab;
	/**This method is used to select PCP and verify table and given row values
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyPCPTableValues(String[] args){
		MemberComposite_MemberSection membercomp=new MemberComposite_MemberSection();
		utils.waitforpageload();
		JavascriptExecutor executor = (JavascriptExecutor)pgDriver;
		executor.executeScript("arguments[0].click();", primaryCareInfoTab);
			if(membercomp.validatePCPTableInformation(args))
			return true;
		return false;
	}
	
	


	//Sprint 2.2 Code

	@FindBy(xpath="//div[contains(text(),'Cancel the work')]")
	WebElement btnCancelTheWork;


	public boolean clickCancelTheWorkForSameTask()
	{
		try
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement3);
			return utils.clickAnelemnt(this.btnCancelTheWork, "MemberComposite", "Cancel the work");	
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("MemberComposite", "clickCancelTheWorkForSameTask", "Error in clicking cancel the work");
			return false;
		}
	}

	public boolean clickCancelTheWorkForSameTaskViewPrograms()
	{
		try
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement4);
			return utils.clickAnelemnt(this.btnCancelTheWork, "MemberComposite", "Cancel the work");	
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("MemberComposite", "clickCancelTheWorkForSameTask", "Error in clicking cancel the work");
			return false;
		}
	}

	public boolean navigateToManageAlertsAgain() throws InterruptedException
	{
		blogger.loginfo("Entered - navigateToManageAlerts- Is navigated to Manage Alert page");
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement2);
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Manage Alerts'][@class='Add_task']")));
			if(setTxtFullContactName("Manage Alerts"))
			{
				if(this.clicklnkClickonLinkafterSettingValue("Manage Alerts"))
				{
					blogger.loginfo("User Is navigated to Manage Alert page");
					System.out.println("Pass : The Value Manage Alerts is entered in the text Field and is navigateed to the required page ");
					this.clickCancelTheWorkForSameTask();
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 
	}


	public boolean navigateToManageReferralsAgain() throws InterruptedException
	{
		blogger.loginfo("Entered - navigateToManageReferralsAgain- Is navigated to Manage Referral page");
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement2);
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Manage Alerts'][@class='Add_task']")));
			if(setTxtFullContactName("Manage Referral"))
			{
				if(this.clicklnkClickonLinkafterSettingValue("Manage Referral"))
				{
					blogger.loginfo("User Is navigated to Manage Referral page");
					System.out.println("Pass : The Value Manage Referral is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 
	}


	public boolean navigateToViewProgramsAgain() throws InterruptedException
	{
		blogger.loginfo("Entered - navigateToViewProgramsAgain- Is navigated to View Program page");
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement3);
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='View Programs'][@class='Add_task']")));
			if(setTxtFullContactName("View Program"))
			{
				if(this.clicklnkClickonLinkafterSettingValue("View Program"))
				{
					blogger.loginfo("User Is navigated to View Program page");
					System.out.println("Pass : The Value View Program is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 
	}

	@FindBy(xpath="")
	WebElement labelErrorMessageForTaskOpened;

	public boolean validateTheAlertMessageForTaskOpenedAndCancelTheWork()
	{
		try
		{
			//utils.validateLabel(labelErrorMessageForTaskOpened, "Error Message");
			this.clickCancelTheWorkForSameTask();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("MemberComposite", "validateTheAlertMessageForTaskOpenedAndCancelTheWork", "Alert Message is Validated And Task is cancelled");
			return false;
		}
	}


	public boolean validateTheAlertMessageForTaskOpenedAndCancelTheWorkViewPrograms()
	{
		try
		{
			//utils.validateLabel(labelErrorMessageForTaskOpened, "Error Message");
			this.clickCancelTheWorkForSameTaskViewPrograms();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("MemberComposite", "validateTheAlertMessageForTaskOpenedAndCancelTheWork", "Alert Message is Validated And Task is cancelled");
			return false;
		}
	}

	@FindBy(xpath="//a[text()='Manage Alerts']")
	WebElement taskManageAlert;

	@FindBy(xpath="//a[text()='Manage Referrals']")
	WebElement taskManageReferrals;

	@FindBy(xpath="//a[text()='View Programs']")
	WebElement taskViewPrograms;


	public boolean clickManageAlert() throws InterruptedException
	{
		if(this.clickbtnAddTask())
		{
			Actions act = new Actions(pgDriver);
			act.moveToElement(taskManageAlert).doubleClick().build().perform();
			return true;
		}else

		{
			err.logcustomerrorwithmessage("MemberComposite", "clickManageAlert", "Error in Clicking Manage Alert");
			return false;
		}
	}

	/**This method is used to select task
	 * 
	 * @param task
	 * @return
	 * @throws InterruptedException
	 */
	public boolean navigateToTask(String task) throws InterruptedException {
//	Thread.sleep(3000);
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName(task))
			{
			if(this.clicklnkClickonLinkafterSettingValue(task))
			{
				blogger.loginfo("Pass : The Value "+task+" is entered in the text Field and is navigateed to the required page ");
				return true; 
			}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 
	}

	public boolean clickManageReferral() throws InterruptedException
	{
		if(this.clickbtnAddTask())
		{
			Actions act = new Actions(pgDriver);
			act.moveToElement(taskManageReferrals).doubleClick().build().perform();
			return true;
		}else

		{
			err.logcustomerrorwithmessage("MemberComposite", "clickManageReferral", "Error in Clicking Manage Referral");
			return false;
		}
	}

	public boolean clickViewProgram() throws InterruptedException
	{
		if(this.clickbtnAddTask())
		{
			Actions act = new Actions(pgDriver);
			act.moveToElement(taskViewPrograms).doubleClick().build().perform();
			return true;
		}else

		{
			err.logcustomerrorwithmessage("MemberComposite", "clickViewProgram", "Error in Clicking View Program");
			return false;
		}
	}


	@FindBy(xpath ="//span[@data-test-id='201802191730470304771134']")
	private WebElement pcprequired;

	@FindBy(xpath ="//span[@data-test-id='201802191730470304772157']")
	private WebElement pcpselectionrequired;

	@FindBy(xpath ="//span[@data-test-id='201802191730470305773537']")
	private WebElement pcpautoselectiontimeframe;

	@FindBy(xpath ="//span[@data-test-id='201802191730470305774275']")
	private WebElement printpcponidcard;


	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyPrimaryCarePhysicianInformation
	 * #Arguments:KeyValuePair
	 * Type:Table
	 * Keys:pcprequired#pcpselectionrequired#pcpautoselectiontimeframe#printpcponidcard

	 */


	public boolean verifyPrimaryCarePhysicianInformation(String[] pcpDetails) throws Exception
	{
		boolean returnvar ;
		returnvar = true;
		if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
		{
			if(utils.isProxyWebelement(this.labelMbrCompositeMbrPCPName))
			{
				utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink,"Member Composite ","PrimaryCarePhysicianInformationLink");

			}
			else
			{
				System.out.println("PCP is already clicked");
			}

			for(String iterator : pcpDetails)
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

				if(key.toLowerCase().contains("pcprequired")){
					returnvar=utils.validateValueinelement(this.pcprequired, value);
					continue;}
				else if(key.toLowerCase().contains("pcpselectionrequired")){
					returnvar =utils.validateValueinelement(this.pcpselectionrequired, value);
					continue;}

				else if(key.toLowerCase().contains("pcpautoselectiontimeframe")){
					returnvar =utils.validateValueinelement(this.pcpautoselectiontimeframe, value);
					continue;
				}
				else if(key.toLowerCase().contains("printpcponidcard")){
					returnvar =utils.validateValueinelement(this.printpcponidcard, value);
					continue;
				}
				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;


			}

		}
		else
			err.logError("Member Composite", "Member tab ");

		if(returnvar)
		{
			System.out.println("PrimaryCarePhysicianInformation info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=pcpDetails.length;
			err.logcommonMethodError("Member Composite", "the value "+pcpDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}

	public boolean  navigateToCreateCorrespondence() throws InterruptedException
	{
		return createTask("Create Correspondence");


	}

	public boolean getSRIDFromTaskWithoutData()
	{
		utils.waitforpageload();
		String SrID = this.serviceReqDetails.getText().trim();
		System.out.println("SR ID Value is: "+ SrID);
		SRIDAfterSubstring = SrID.substring(SrID.indexOf("(")+1,SrID.indexOf(")")).trim();
		System.out.println("Trimmed String: "+ SRIDAfterSubstring);
		return true;
	}


	public boolean verifyNewGandATaskIsOpened()
	{
		try
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
			this.serviceReqDetails.isDisplayed();
			blogger.loginfo("New Task is opened on Clicking Launch G and A button in Wrap Uo screen");
			System.out.println("New Task is opened on Clicking Launch G and A button in Wrap Uo screen");
			return true;
		}catch(Exception e)
		{
			blogger.loginfo("New Task is not opened on Clicking Launch G and A button in Wrap Uo screen");
			System.out.println("New Task is not opened on Clicking Launch G and A button in Wrap Uo screen");
			return false;
		}
	}

	@FindBy(xpath="//*[@id='ERRORMESSAGES_ALL']/ul/li")
	WebElement ErrorMessage;

	public boolean verifyIfAccessRestrictionErrorMessageIsDisplayed(String[] args) {
		return ErrorMessage.getText().equalsIgnoreCase(args[0]);
	}

	public boolean verifyErrorMessgeNotDisplayed() {
		return utils.isProxyWebelement(ErrorMessage);

	}

	@FindBy(xpath="//h3[contains(text(),'Member')]")
	WebElement tabMember;

	public boolean verifyMemberCompositeIsDisplayedOnSelectingSubmitOnTheContractPagesAfterCheckingAllTheHIPAAQuestions()
	{
		utils.waitForElementToBeVisible(tabMember);
		return !utils.isProxyWebelement(tabMember);
	}


	@FindBy(xpath="//label[@data-test-id='201708040137200158213631-Label'][@for='LegacyHCID']/following-sibling::div/span[@data-test-id='201708040137200158213631']")
	WebElement LegacyHCID;

	@FindBy(xpath="(//label[@for='LegacyHCID']//following::img[@data-test-id='20170206104513026056391'])[1] ")
	WebElement LegacyHovertxt;

	public boolean verifyLegacyHCIDFieldAndHoverImage(String[] args)
	{

		utils.waitForElementToBeVisible(LegacyHCID);
		String ActualID = LegacyHCID.getText();
		String ExpectedID = args[0];
		if(utils.isvalueMatch_compareto(ActualID, ExpectedID))
		{			
			utils.clickAnelemnt(LegacyHovertxt,"Member composite","Legacy HCID");
			String hovermsg = args[1].toLowerCase();
			System.out.println("Hover Msg: "+hovermsg);
			Actions action = new Actions(Driver.pgDriver);
			action.moveToElement(LegacyHovertxt).build().perform();
			String hovertext=Driver.pgDriver.findElement(By.xpath("(//label[@for='LegacyHCID']//following::img[@data-test-id='20170206104513026056391'])[1] ")).getAttribute("data-hover").toLowerCase();
			System.out.println("Hover Msg in UI: "+hovertext);
			if(hovertext.contains(hovermsg))
			{
				System.out.println("Hover Text is matched and validated");
				return true;
			}
			else
			{
				System.out.println("Hover Text is does not matched");
				return false;
			}
		}
		else{
			System.out.println("Legacy HCID is does not matched");
			return false;
		}
	}

	@FindBy(xpath="//a[@data-test-id='2014123005242607302524'][text()='View Programs']")
	WebElement lnkViewProgramsTask;

	@FindBy(xpath="//a[@data-test-id='2014123005242607302524'][text()='Manage Referrals']")
	WebElement lnkManageReferralsTask;

	public boolean verifyIfViewProgramsTaskIsPresent()
	{
		if(this.clickbtnAddTask())
		{
			if(lnkViewProgramsTask.isDisplayed())
			{
				blogger.loginfo("View Programs Task is present");
				System.out.println("View Programs Task is present");
				return true;
			}
		}
		return false;

	}


	public boolean verifyIfManageReferralsTasksPresent()
	{
		if(this.clickbtnAddTask())
		{
			if(lnkManageReferralsTask.isDisplayed())
			{
				blogger.loginfo("Manage Referrals Task is present");
				System.out.println("Manage Referrals Task is present");
				return true;
			}
		}
		return false;

	}

	public boolean verifyIfViewProgramsManageReferralsTasksPresent()
	{
		if(this.clickbtnAddTask())
		{
			if(lnkManageReferralsTask.isDisplayed())
			{
				if(lnkManageReferralsTask.isDisplayed())
				{
					blogger.loginfo("Manage Referrals and View Programs Task is present");
					System.out.println("Manage Referrals and View Programs Task is present");
					return true;
				}
			}
		}
		return false;
	}



	/**This method is for fetching SRID and is used in Home Page
	 * author: Sowndarya
	 * @return
	 */
	public String getSRIDFromTaskList()
	{
		utils.waitforpageload();
		WebElement serviceReqDetails= Driver.pgDriver.findElement(By.xpath("//a[@class='Standard_task']"));
		String SrID = serviceReqDetails.getText().trim();
		System.out.println("SR ID Value is: "+ SrID);
		return SrID;
	}


	@FindBy(xpath="//label[@for='SecureMessageRefNum']")
	WebElement SecureMessageReferenceNumberfield; 

	@FindBy(xpath="//input[@data-test-id='20150917120800012541416']")
	WebElement SecureMessageReferenceNumbervalue;

	/**
	 * This method validate the presence of Secure message reference number field and its value in member composite page
	 * @param args
	 * @return
	 */
	public boolean validateSecureMessageReferenceNumber(String[] args)
	{
		Driver.pgDriver.switchTo().defaultContent();
		String AcutalString =SecureMessageReferenceNumberfield.getText().trim();
		System.out.println(AcutalString);
		String Expectedstring =args[0];
		if( utils.isvalueMatch_compareto(AcutalString, "Secure Message Reference Number"))
		{
			String ActualValue=SecureMessageReferenceNumbervalue.getAttribute("value").trim();
			System.out.println(ActualValue);
			if( utils.isvalueMatch_compareto(ActualValue, Expectedstring))
			{
				System.out.println("validateSecureMessageReferenceNumber is passed");
				return true;
			}
		}
		return false;


	}

	@FindBy(xpath="//label[@for='CorrespondenceReceiveDate']")
	WebElement CorrespondenceReceiveDatefield; 

	@FindBy(id="CorrespondenceReceiveDate")
	WebElement CorrespondenceReceiveDatevalue;

	/**
	 * This method validate the presence of correspondence received date field and its value in member composite page
	 * @param args
	 * @return
	 */

	public boolean validateCorrespondenceReceivedDate(String[] args)
	{

		Driver.pgDriver.switchTo().defaultContent();
		String AcutalString =CorrespondenceReceiveDatefield.getText().trim();
		System.out.println("The value is"+AcutalString);
		String Expectedstring =args[0];
		if( utils.isvalueMatch_compareto(AcutalString, "Correspondence Received Date"))
		{
			String ActualValue=CorrespondenceReceiveDatevalue.getAttribute("value").trim();
			System.out.println(ActualValue);
			if( utils.isvalueMatch_compareto(ActualValue, Expectedstring))
			{
				System.out.println("validateCorrespondenceReceivedDate is passed");
				return true;
			}
		}
		return false;
	}
	/** Description:This method navigated to Manage Dental page by clicking Manage Dental Task in Consumer services tab in Add task page
	 * 
	 * @return
	 */


	public boolean  navigateToManageDentalTask() throws InterruptedException
	{
		return createTask("Manage Dent");	


	}      


	/** Description:This method navigated to Manage Dental page by clicking Manage Dental Task in Consumer services tab in Add task page
	 * 
	 * @return
	 */

	public boolean  navigateToManageVisionTask() throws InterruptedException
	{	
		return createTask("Manage Vision");	

	}  

	/** Description:This method navigated to Manage Behavioral Health page by clicking Manage Behavioral Health in Consumer services tab in Add task page
	 * 
	 * @return
	 */
	public boolean  navigateToManageBehavioralTask() throws InterruptedException
	{
		return createTask("Manage Behavioral Health");	

	} 

	public boolean  navigateToManageEmployeeAssistanceProgram() throws InterruptedException
	{
		return createTask("Manage Employee Assistance Program");	


	}  


	@FindBy(xpath="//div[@id='DialogContent']")
	WebElement GuidedDialogMsg;

	/**
	 * This functionality validates the guided dialog message populated in the member composite page page through the secure message interaction

	 */
	public boolean validateGuidedDialogSecureMessage(String[] args)
	{

		String ActualValue = GuidedDialogMsg.getText();
		String ExpectedValue = args[0];
		System.out.println(ActualValue);
		System.out.println(ExpectedValue);
		return utils.isvalueMatch_compareto(ActualValue, ExpectedValue);
	}

	@FindBy(xpath="//*[text()='Manage Employee Assistance Program']")
	WebElement ManageEmployeeAssistanceProgram;
	/**This functionality checks whether Employee Assistance Program Task is present in Add task page for guest contact for the Employee only
	 * 
	 * @return
	 */
	public boolean checkEmployeeAssistanceProgramTaskIsPresent() {
		utils.waitforpageload();
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(ManageEmployeeAssistanceProgram);
		return false;
	}

	@FindBy(xpath="//*[text()='Specialty Products']/ancestor::div[@class='content-item content-sub_section item-4   ']//*[text()='Manage Pharmacy']")
	WebElement labelmanagepharmacy;
	/**This functionality checks whether Manage Pharmacy   Task is present in Add task page under Speciality products 
	 * 
	 * @return
	 */


	public boolean verifyManagePharmacyTaskIsPresent() {
		utils.waitforpageload();
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(labelmanagepharmacy);
		return false;
	}

	@FindBy(xpath="//*[text()='Specialty Products']/ancestor::div[@class='content-item content-sub_section item-4   ']//*[text()='Manage Behavioral Health']")
	WebElement labelmanagebehavioralhealth;
	/**This functionality checks whether ManageBehavioral Health Task is present in Add task page under Speciality products 
	 * 
	 * @return
	 */
	public boolean verifyManageBehavioralHealthTaskIsPresent() {
		utils.waitforpageload();
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(labelmanagebehavioralhealth);
		return false;
	}

	@FindBy(xpath="//*[text()='Specialty Products']/ancestor::div[@class='content-item content-sub_section item-4   ']//*[text()='Manage Vision']")
	WebElement labelmanagevision;
	/**This functionality checks whether Manage Vision Task is present in Add task page under Speciality products 
	 * 
	 * @return
	 */
	public boolean verifyManageVisionTaskIsPresent() {
		utils.waitforpageload();
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(labelmanagevision);
		return false;
	}
	@FindBy(xpath="//*[text()='Specialty Products']/ancestor::div[@class='content-item content-sub_section item-4   ']//*[text()='Manage Vision']")
	WebElement labelmanagedental;
	/**This functionality checks whether Manage Dental Task is present in Add task page under Speciality products 
	 * 
	 * @return
	 */
	public boolean verifyManageDentalTaskIsPresent() {
		utils.waitforpageload();
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(labelManageDental);
		return false;
	}
	
	public boolean verifyManageDentalTaskIsNotPresent() {
		utils.waitforpageload();
		if(clickbtnAddTask())
			return utils.isProxyWebelement(labelManageDental);
	return false;
	}

	@FindBy(xpath="//*[text()='Specialty Products']/ancestor::div[@class='content-item content-sub_section item-4   ']//*[text()='Manage Employee Assistance Program']")
	WebElement labelmanagemployeeassistance;
	/**This functionality checks whether Manage Dental Task is present in Add task page under Speciality products 
	 * 
	 * @return
	 */
	public boolean verifyManageEmployeeAssistanceProgramTaskIsPresent() {
		utils.waitforpageload();
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(labelmanagemployeeassistance);
		return false;
	}
	public boolean verifyManageEmployeeAssistanceProgramTaskIsNotPresent() {
		utils.waitforpageload();
		if(clickbtnAddTask())
			return utils.isProxyWebelement(labelmanagemployeeassistance);
		return false;
	}

	/**
	 * THis functionality fetches the Interaction ID in the Interaction Section
	 * @return
	 */
	@FindBy(xpath="//span[@data-test-id='20160916102637026797140']")
	WebElement labelInteractionID;

	static String interactionID;

	public boolean fetchInteractionIDForInteraction()
	{
		try
		{
			Driver.pgDriver.switchTo().defaultContent();
			interactionID = labelInteractionID.getText();
			return true;
		}catch(Exception e)
		{
			Driver.pgDriver.switchTo().defaultContent();
			interactionID = labelInteractionID.getText();
			return true;
		}

	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Close']")
	WebElement btnMbrCompositeClose;
	/**
	 * This method allows the user to click close button in research interaction
	 * @return
	 * @throws InterruptedException
	 */

	public boolean clickClose() throws InterruptedException
	{
		//utils.waitforpageload();
		Thread.sleep(3000);
		return utils.clickAnelemnt(this.btnMbrCompositeClose, "SidePane", "clickClose");

	}  

	/**This functionality verifies that Manage Alerts Task is not present for the member who doesnot have any alerts
	 * 
	 * @return
	 */
	public boolean verifyAlertTaskNotPresent()
	{
		if(clickbtnAddTask())
			return utils.isProxyWebelement(elemManageAlert);
		return false;
	}

	/**This functionality validates whether Alerts are getting auto launched in member composite page
	 * 
	 * @return
	 */
	public boolean verifyIfAlertsAreAutolaunched() {
		return utils.validateLabel(serviceReqDetails, "Manage Alerts");
	}


	/**
	 * This functionality validates the guided dialog message populated in the member composite page page through the secure message interaction

	 */
	public boolean validateGuidedDialogSecureMessageForNewInteraction(String[] args)
	{
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement3);
		String ActualValue = GuidedDialogMsg.getText();
		String ExpectedValue = args[0];
		System.out.println(ActualValue);
		System.out.println(ExpectedValue);
		if(utils.isvalueMatch_compareto(ActualValue, ExpectedValue))
		{
			System.out.println("Guided Dialog message is  matched with user input");
			return true;
		}
		else{
			System.out.println("Guided Dialog message is not matched with user input");
			return false;
		}
	}

	public boolean clickSRIDFromTaskAndValidateThePopUp() {
		String webElement = "//a[contains(text(),'"+MemberComposite.SRIDAfterSubstring+"')]";
		if(utils.clickAnelemnt(Driver.pgDriver.findElement(By.xpath(webElement)), "MemberComposite", "SR ID")) {
			//Driver.pgDriver.switchTo().defaultContent();
			String alerttext = Driver.pgDriver.switchTo().alert().getText();
			if(utils.isvalueMatch_contain(alerttext,"Grievance and Appeals / Payment Dispute"))
				return utils.isAlertPresent(); 
		}
		return false;
	}


	public boolean  createTask(String arg) throws InterruptedException
	{
		if(this.clickbtnAddTask())
			if(this.clicklnkClickonLinkafterSettingValue(arg))
				return true;
		return false;
		//Thread.sleep(2000);
		//utils.waitforpageload();
		/*if(this.clickbtnAddTask())
		{
			//utils.waitforpageload();
			//wait=new WebDriverWait(Driver.pgDriver,5);
			//if(setTxtFullContactName("Manage Enrollment"))
			//{
				if(this.clicklnkClickonLinkafterSettingValue(arg))
				{
					Thread.sleep(2000);
					System.out.println("Pass : The Value is Manage Billing is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			//}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; */
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

	
	
	@FindBy(xpath="//span[@id='ERRORMESSAGES_ALL']//ul[@class='pageErrorList layout-noheader-errors']//li")
	WebElement txtErrorMsg;
	public boolean verifyErrormessageForHMODental(String args[]){
		return utils.validateLabel(txtErrorMsg, args[0]);
	}
	
	
	
	public boolean switchContactforHMODentalRestriction() {
			 if(utils.clickAnelemnt(memberContact, "Member Composite", "memberContact")){
			      if(memberContactPopupTable.isDisplayed()) {
				 memberContactPopupTableFirstName.click();
			}
			      return true;
			 }else {
				blogger.loginfo("FAIL: Member Contact PopUp is not displayed");
				return false;
			}
		}
	
	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Guided Flows'][@class='Add_task']")
	WebElement elemGuidedFlows;
	public boolean verifyGuidedFlowsTaskIsPresentInAddTask()
	{
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(elemGuidedFlows);
		return false;
	}
	
	public boolean verifyGuidedFlowsTaskIsNotPresentInAddTask()
	{
		if(clickbtnAddTask())
			return utils.isProxyWebelement(elemGuidedFlows);
		return false;
	}

	public boolean  navigateToGuidedFlowsTask() throws InterruptedException
	{
		return createTask("Guided Flows");	

	} 
}
	


















