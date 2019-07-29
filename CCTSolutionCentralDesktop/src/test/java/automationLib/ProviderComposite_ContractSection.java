package automationLib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderComposite_ContractSection {
	WebDriverWait wait;
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();

	public ProviderComposite_ContractSection()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		//PageFactory.initElements(Driver.getPgDriver(), this);

		{
			utils.refreshthepage();
		}
		try {
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}catch(Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}
	}

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement1;
	//TABS__________________________________________________________________________



	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Contract']")
	WebElement tabMbrCompositeContract;



	@FindBy(xpath="//img[@alt='Loading...']")
	WebElement loadingicon;

	@FindBy(xpath="//label[text()='Loading...']")
	WebElement loadinglabel;


	@FindBy(xpath="//img[contains(@src,'addtask')]")
	WebElement btnMbrCompositeAddTask;

	@FindBy(id="ModalButtonSubmit")
	WebElement btnVerificationSubmit;

	//@FindBy(className="Wrap_up_button pzhc")
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Wrap Up']")
	WebElement btnMbrCompositeWrapup;



	////////////////////////////////////////////////
	//SUBSCRIBER TAB

	//LINKS

	//Subscriber Link

	@FindBy(xpath="//span[text()='Subscriber Information']")
	WebElement lnkMbrCompositeSbrInfo;

	@FindBy(xpath="//span[text()='Contract Addresses']")
	WebElement lnkMbrCompositeSbrContractAddress;

	@FindBy(xpath="//span[text()='Related Contracts']")
	WebElement lnkMbrCompositeSbrRelatedContracts;

	@FindBy(xpath="//span[text()='Members']")
	WebElement lnkMbrCompositeSbrMember;


	//SUBSCRIBER INFORMATION	

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


	@FindBy(xpath="//div[@node_name='SubscriberDetailInformation']//label[@for='SubscriberEndDate']/parent::div//div")
	WebElement labelMbrCompositeSbrEndDate;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='SubscriberProductType']/parent::div//span")
	WebElement labelMbrCompositeSbrProdType;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='ContractCode']/parent::div//span")
	WebElement labelMbrCompositeSbrCntrctCode;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='CoverageType']/parent::div//span")
	WebElement labelMbrCompositeSbrCoverageType;

	@FindBy(xpath="//*[contains(@class,'content-item content-field item-10')]//*[@data-test-id='20150914102046032213295']")
	WebElement labelMbrCompositeSbrBenefitPeriod;

	@FindBy(xpath="//div[@node_name='SubscriberInformation']//label[@for='GroupNumber']/parent::div//span")
	WebElement labelMbrCompositeSbrGroupNumber;

	@FindBy(xpath="//div[@class='content-item content-field item-15   ']//*[@data-test-id='201711061821560131144379']")
	WebElement labelMbrCompositeSbrDOB;

	@FindBy(xpath="//*[contains(@class,'content-item content-field item-15')]//*[@data-test-id='201711061821560131144379']")
	WebElement labelMbrCompositeDateofBirth;

	@FindBy(xpath="//*[contains(@class,'content-item content-field item-14')]//*[@data-test-id='201711061821560130143668']")
	WebElement labelMbrCompositeHireDate;

	@FindBy(xpath="//*[contains(@class,'content-item content-field item-16')]//*[@data-test-id='20170313150810029741745']")
	WebElement labelMbrCompositeEmployeeType;


	//SUBSCRIBER CONTACT INFORMATION_________________________________________________________


	@FindBy(xpath="//div[@node_name='ContractAddressList']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeSbrAddress;

	@FindBy(xpath="//div[@node_name='PhoneInfoForContractTab']//table[@class='gridTable ']")
	WebElement tableMbrCompositeSbrPhone;

	//MEMBERS______________
	@FindBy(xpath="//div[@node_name='MembersWithCoverageInFocus']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeSbrMemberswithcoverage;

	//RELATED CONTRACTS________
	@FindBy(xpath="//div[@node_name='RelatedContracts']/parent::div//table[@class='gridTable ']")
	WebElement tableMbrCompositeSbrRelatedContracts;


	@FindBy(xpath="//div[@node_name='RelatedContracts']/parent::div//td[2]//nobr/span")
	WebElement labelMbrCompositeSbrRCMemName;

	@FindBy(xpath="//div[@node_name='RelatedContracts']/parent::div//td[4]//nobr/span")
	WebElement labelMbrCompositeSbrRCMemDOB;

	//GROUP INFORMATION ___________________________________________________________________________

	//Group links

	@FindBy(xpath="//span[text()='Group Information']")
	WebElement lnkMbrCompositeGrpInfo;

	@FindBy(xpath="//span[text()='Group Addressess']")
	WebElement lnkMbrCompositeGrpAddress;

	@FindBy(xpath="//span[text()='Group Phone Numbers']")
	WebElement lnkMbrCompositeGrpPhone;

	@FindBy(xpath="//span[text()='Broker Information']")
	WebElement lnkMbrCompositeGrpBrokerInfo;


	//GROUP INFORMATION

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
	//Anthemgroup management under Group info -------------------------------

	@FindBy(xpath="//span[text()='Anthem Group Management']")
	WebElement labeldropMbrCompositeGrpManagement;

	@FindBy(xpath="//span[text()='Employer Group Administrator']")
	WebElement labeldropMbrCompositeGrpEmpGrpAdmin;

	//ELEMENTS UDNER ANTHEM GROUP MANAGEMENT


	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='RecipientNamePhone']/parent::div//span")
	WebElement labelMbrCompositeGrpServLoc;

	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='CPCCIndicator']/parent::div//span")
	WebElement labelMbrCompositeGrpTranstoProv;

	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='ClaimsAddress']/parent::div//span")
	WebElement labelMbrCompositeGrpClaimsAddress;

	//ELEMENTS UNDER EMPLOYER GROUP ADMINISTRATOR

	@FindBy(xpath="//div[@node_name='EmployerGroupAdmin']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupadmin;


	//ELEMENTS UNDER GROUP INFORMATION

	@FindBy(xpath="//div[contains(@datasource,'AddressList_Group')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupAddress;

	@FindBy(xpath="//div[contains(@datasource,'GroupPhoneList_Group')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupPhone;

	@FindBy(xpath="//div[@node_name='BrokersListInformation']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpBrokerInfo;


	//INTERACTIONS TAB

	//LINKS UNDER INTERACTIOn TAB


	@FindBy(xpath="//span[text()='Open Service Requests']")
	WebElement lnkMbrCompositeIntOpenServiceReq;

	@FindBy(xpath="//span[text()='Recent Interactions']")
	WebElement lnkMbrCompositeIntRecentInt;

	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']")
	WebElement lnkMbrCompositeIntRecentInqtrack;

	@FindBy(xpath="//span[text()='Related/Linked Interactions']")
	WebElement lnkMbrCompositeIntLinkedInt;                                    //6


	//INTERACTIONS TAB - VIEWALL AND REFRESH BUTTONS



	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']//div[text()='View All']")
	WebElement imgMbrCompositeIntOpenSerReqViewall;

	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']//div[text()='Refresh']")
	WebElement imgMbrCompositeIntOpenSerReqRefresh;

	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']//div[text()='View All']")
	WebElement imgMbrCompositeIntRecentIntViewall;

	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']//div[text()='Refresh']")
	WebElement imgMbrCompositeIntRecentInteractionrefresh;

	@FindBy(xpath="//a[contains(@data-click,'ViewAllInq')][text()='View All']")
	WebElement imgMbrCompositeIntRecentInqtrackViewall;

	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']/parent::div//img[contains(@data-click,'refresh')]")
	WebElement imgMbrCompositeIntRecentInqtrackrefresh;

	@FindBy(xpath="//span[text()='Related/Linked Interactions']/parent::div//img[contains(@data-click,'refresh')]")
	WebElement imgMbrCompositeIntLinkedIntrefresh; 



	//INTERACTION TAB - TABLES

	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntOpenSerReq;

	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntRecentInt;


	@FindBy(xpath="//div[@node_name='RecentIQTTracking']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntRecentInqTrack;


	@FindBy(xpath="//div[contains(@datasource,'LinkedInteractions')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntRelatedIntraction;                  

	//NAVIGATIOn to OTHER PAGES

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")
	WebElement benefitsandcost;
	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Manage Claims'][@class='Add_task']")
	WebElement manageclaims;

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")
	WebElement promisedactions;

	//ADD TASK button

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Add task(s)']")
	WebElement addtaskbutton;

	//New CHECKBBOX BUTTONS ADDED----------------

	@FindBy(id="MemberInfoReview")
	WebElement chkbxmemberinfodiscussed;

	@FindBy(id="ContractInfoReview")
	WebElement chkbxcontractinfodiscussed;

	@FindBy(id="GroupDetailsInfoReview")
	WebElement chkbxgroupinfodiscussed;

	@FindBy(id="InteractionsInfoReview")
	WebElement chkbxInteractioninfodiscussed;

	//Guided Dialog message

	@FindBy(id="DialogContent")
	WebElement labelGuidedDialog;

	//Checkbox common methods 

	public boolean verifyGuidedDialogText()
	{
			String message=this.labelGuidedDialog.getText().toString();
			String actualMsg = "Handle with care. Use the HIPAA Verification & Disclosure Guide link if you need help understanding what you can tell";
			return utils.isvalueMatch_contain(message, actualMsg);
	}





	public boolean clickchkbxcontractinfodiscussed()
	{
			if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab"))
				if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab"))
					if(utils.clickAnelemnt(this.chkbxcontractinfodiscussed, "Member Composite", "Checkbox"))
				return true;
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
					// s = s.substring(0, s.indexOf(";"));

					if( vr.clickchkbxVerificationMembernameverify(s))
					{
						if(i==args.length-1)
						{
							//						 JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
							//						  jse.executeScript("scroll(0, 250);");
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
							//						  JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
							//						  jse.executeScript("scroll(0, 250);");
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
							//						 JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
							//						  jse.executeScript("scroll(0, 250);");
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
							//						  JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
							//						  jse.executeScript("scroll(0, 250);");
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
							//						  JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
							//						  jse.executeScript("scroll(0, 250);");
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
							//						  JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
							//						  jse.executeScript("scroll(0, 250);");
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
							//						  JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
							//						  jse.executeScript("scroll(0, 250);");
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







	//CONTRACT TAB TABLES ____________________________________---------------------

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


	public boolean validateSubscriberInformation(String[] cgeninfoDetails)
	{
		boolean returnvar ;
		returnvar = true;
		utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab"))
		{
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
				if(key.toLowerCase().contains("name")){
					returnvar = this.labelMbrCompositeSbrName.getText().toLowerCase().trim().contains(value);
					continue;}
				else if(key.toLowerCase().contains("gender")){
					returnvar = this.labelMbrCompositeSbrGender.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("effdate")){
					returnvar = this.labelMbrCompositeSbrEffDate.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("enddate")){
					returnvar = this.labelMbrCompositeSbrEndDate.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("product")){
					returnvar = this.labelMbrCompositeSbrProdType.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("contractcode")){
					returnvar = this.labelMbrCompositeSbrCntrctCode.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("coveragetype")){
					returnvar = this.labelMbrCompositeSbrCoverageType.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("age")){
					returnvar = this.labelMbrCompositeSbrAge.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("benefitperiod")){
					returnvar = this.labelMbrCompositeSbrBenefitPeriod.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("groupnumber")){
					returnvar = this.labelMbrCompositeSbrGroupNumber.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("groupnumber")){
					returnvar = this.labelMbrCompositeSbrGroupNumber.getText().toLowerCase().contains(value);
					continue;
				}
				else if(key.toLowerCase().contains("dateofbirth")){
					returnvar = this.labelMbrCompositeSbrDOB.getText().toLowerCase().contains(value);
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

	public boolean clickwrapUp()
	{
		waitforpageload();
		return utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");
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

		// Checking if the table is present or not and validating if it is already openened 
		if(utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest,"Member Composite "," Search for Service Request for Contract");
		}
		else
		{
			System.out.println("Open Service Request link is already clicked\n\n");
		}

		//Checking if dates are equal 

		// array list top storwe all the values and the dates in the Table 
		ArrayList<String> Dates = new ArrayList<String>();
		// wil save the values in an array list 
		Dates=utils.getcolumnStringFromTableByName(this.tableMbrCompositesearchforServiceRequestContracts, "Open Date");
		int i=2;
		System.out.println(Dates.size());
		if(Dates.size()>7)
		{
			System.out.println("There are more than 5 rows in Open Service request Table.");
			return false;
		}


		// Iterating  the dates from the stored values 
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



	// Checking Dates for the Table 

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Today']")
	WebElement btnServcRequestContractToday;

	public boolean clickServcRequestContractToday (){
		return (utils.clickAnelemnt(this.btnServcRequestContractToday, "MemberVerify", "Click Button today"));

	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Yesterday']")
	WebElement btnServcRequestContractYesterday;

	public boolean clickbtnServcRequestContractYesterday (){
		return (utils.clickAnelemnt(this.btnServcRequestContractYesterday, "MemberVerify", "Click Button Yesterday"));

	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Last 7 Days']")
	WebElement btnServcRequestContractLast7Days;

	public boolean clickbtnServcRequestContractLast7Days (){
		return (utils.clickAnelemnt(this.btnServcRequestContractLast7Days, "MemberVerify", "Click Button Last 7 Days"));

	}
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Last 90 Days']")
	WebElement btnServcRequestContractLast90Days;

	public boolean clickbtnServcRequestContractLast90Days (){
		return (utils.clickAnelemnt(this.btnServcRequestContractLast90Days, "MemberVerify", "Click Button Last 90 Days"));

	}
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Last 30 Days']")
	WebElement btnServcRequestContractLast30Days;

	public boolean clickbtnServcRequestContractLast30Days (){
		return (utils.clickAnelemnt(this.btnServcRequestContractLast30Days, "MemberVerify", "Click Button Last 30 Days"));

	}

	@FindBy(xpath="//*[@id='SearchStartDate']")
	WebElement txtbxStartDate;
	public boolean settxtbxStartDate (String[] args){

		// Checking the header 
		if(utils.validateHeader(this.lnkMbrCompositeIntSearchForServiceRequest, "Search for Service Requests for Contract"))
			try
		{
				return utils.enterTextinAnelemnt(this.txtbxStartDate, args[0], "MemberVerify", "Nickname textbox");
		}
		catch(StaleElementReferenceException e)
		{
			settxtbxStartDate(args);	
		}
		catch(NoSuchElementException e){
			settxtbxStartDate(args);	
		}
		return false;

	}



	// entering the value for the two dates in the pace 
	@FindBy(xpath="//*[@id='SearchEndDate']")
	WebElement txtbxEndtDate;
	public boolean settxtbxEndDate (String[] args){
		try
		{
			return utils.enterTextinAnelemnt(this.txtbxEndtDate, args[0], "MemberVerify", "Nickname textbox");
		}
		catch(StaleElementReferenceException e)
		{
			settxtbxStartDate(args);	
		}
		catch(NoSuchElementException e){
			settxtbxStartDate(args);	
		}
		return false;

	}




	/**
	 * Ente4r the start and end date and the table will check if the dates are alligned in a proper Sequence 
	 * @param args : enter the start and Sto date 
	 * @return
	 * @throws ParseException
	 */
	//*[@id='SearchEndDate']

	//Objects .....................

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")	
	private WebElement btnAddTAsk;
	@FindBy(xpath="//*[contains(@id,'CPMTaskSearchInput')][1]")
	private WebElement SearchInput;

	@FindBy(xpath="//*[@id='$PTaskMenuSearchResults$ppxResults$l1']")
	private WebElement lnkClickonLinkafterSettingValue;



	// Getters 



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
		return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");
	}


	// Set text 
	public boolean setTxtFullContactName(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getchkbxSEacrchInput(), sFullName, "Member Composite", "Application took a long time to load");
	}


	//click on Selected link 
	public boolean clicklnkClickonLinkafterSettingValue() throws InterruptedException
	{
		try 
		{
			Thread.sleep(2000);
			// wait for the drop down value to populate 
			//   utils.PressEnter(this.lnkClickonLinkafterSettingValue, "Member Composite", "Text Box Add Task Options");
			return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValue, "Member Composite", "Text Box Add Task Options");
		}
		catch(StaleElementReferenceException e )
		{
			Thread.sleep(3000);
			System.out.println("Stale Error: Will click again ");
			return false;
			//return utils.clickAnelemnt(this.getlnkClickonLinkafterSettingValue(), "Select Associate Contact", "Text Box Full  Name");
		}
		finally 
		{

		}

	}

	/*
	 * Main methods 
	 */
	public boolean  navigateTOPromisedAction() throws InterruptedException
	{

		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
		{
			waitforpageload();
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")));
			if(utils.clickAnelemnt(this.promisedactions, "Member Composite", "Promised actions under add task"))
			{

				if(utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
				{
					//utils.PressEnter(this.addtaskbutton, "Member composite", "Add task(s) button ");
					System.out.println("Benefits and cost navigated ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}


	public boolean  navigateTOLimitedLiability() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Limited Liability"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value 'Limited Liability' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}      


	public boolean navigateTOManageClaims() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
		{
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")));
			if(utils.clickAnelemnt(this.manageclaims, "Member Composite", "Manage Claims under add task"))
			{

				if(utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
				{
					System.out.println("Manage Claims navigated ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}

	public boolean  navigateTOAccumulators() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();

		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Accumulators"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value is Accumulators is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}      



	public boolean waitforpageload()
	{

		try{

			Thread.sleep(3000);
			System.out.println("Checking for Loading Icon");
			wait=new WebDriverWait(Driver.getPgDriver(),100);
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
		}
		catch(Exception e){
			System.out.println("No loading icon. Continue " +e);

		}
		System.out.println("Came out");
		return true;
	}

	public boolean  navigateTOBenefitsandCost() throws InterruptedException

	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
		{
			waitforpageload();
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")));
			if(utils.clickAnelemnt(this.benefitsandcost, "Member Composite", "Benefits and cost under add task"))
			{
				if(utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
				{
					System.out.println("Benefits and cost navigated ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}


	public boolean  navigateTOManageBilling() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Manage Enrollment"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value is Manage Billing is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}	

	public boolean  navigateTOProvider() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Provider"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value is Provider is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}    

	public boolean  navigateTOSearchInventory() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Search Inventory"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value 'Search Inventory' is entered in the text Field and is navigated to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with navigated value");
		return false; 
	}

	public void validateAlternateIDhovertext()
	{

	}


	/*
	 * @SCU
	 * CommonMethodWithoutArguement: validateTerminationDate
	 * Type: Textbox
	 * Description: Validate the Termination Date in the Member Contract Section 
	 */
	/*Elby Commented
		public boolean validateTerminationDate() {

			String terminationDateText =this.labelMbrCompositeSbrTermDate.getText().toLowerCase();
			System.out.println("The Text in Termination Date is: " + terminationDateText);
			if(terminationDateText.equalsIgnoreCase("Future Active"))
			return true;
			else
			{
				err.logcommonMethodError("MemberComposite", "validateTerminationDate");
				return false;
			}

		}
	 */


	/*
	 * @SCU
	 * CommonMethodWithArgument: verifySubscriberGeneralInformation
	 * #Description: This functionality validates the subscriber general information in the contract section.
	 * #Argument: congeninfodetils
	 * Type: Table
	 * Keys:#subid#name#gender#effdate#enddate#product#contractcode#coveragetype#age#benefitperiod#groupnumber#hire#dateofbirth
	 */
	public boolean verifySubscriberGeneralInformation(String[] congeninfoDetails)
	{
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";

		for(String iterator : congeninfoDetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("subid")){
				returnvar = this.labelMbrCompositeSbrMemberID.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("name")){
				returnvar = this.labelMbrCompositeSbrName.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("age")){
				returnvar = this.labelMbrCompositeSbrAge.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("gender")){
				returnvar = this.labelMbrCompositeSbrGender.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("effdate")){
				returnvar = this.labelMbrCompositeSbrEffDate.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("enddate")){
				returnvar = this.labelMbrCompositeSbrEndDate.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("product")){
				returnvar = this.labelMbrCompositeSbrProdType.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("contractcode")){
				//elby Comemnted
				//returnvar = this.labelMbrCompositeSbrContrctCode.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("coveragetype")){
				returnvar = this.labelMbrCompositeSbrCoverageType.getText().toLowerCase().contains(value);
				continue;
			}

			else if(key.toLowerCase().contains("benefitperiod")){
				returnvar = this.labelMbrCompositeSbrBenefitPeriod.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("groupnumber")){
				returnvar = this.labelMbrCompositeSbrGroupNumber.getText().toLowerCase().contains(value);
				continue;
			}

			else if(key.toLowerCase().contains("hire")) {
				returnvar = this.labelMbrCompositeHireDate.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("dateofbirth")) {
				returnvar = this.labelMbrCompositeDateofBirth.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("employeetype")) {
				returnvar = this.labelMbrCompositeEmployeeType.getText().toLowerCase().contains(value);
				continue;
			}
			else 
				err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
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
			err.logcommonMethodError("Member Composite", "the value "+congeninfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: contractaddress
	 * #Description: This functionality validates the contract address information in the address table
	 * #Argument: contractaddress
	 * Type: Table
	 * keys: Type#Address Line 1#Address Line 2#City#State#Zip Code#County
	 */
	public boolean validateContractAddressInformation(String[] contractaddress) throws InterruptedException
	{
		this.clickAddressandContactInformationLink();
		return utils.validatetablerowbasedonvalues(this.tableMbrCompositeSbrAddress,contractaddress);
	}

	public boolean clickAddressandContactInformationLink()
	{
		return utils.clickAnelemnt(this.lnkMbrCompositeSbrContractAddress, "MemberComposite_ContractSection", "Address and Contact Information Link");
	}

	@FindBy(xpath="//a[@data-test-id='2015020305565609175321']//img")
	WebElement selectContract;

	/**This method is used to click contact number
	 * 
	 */
	public boolean clickContractInContractSection()
	{
		utils.waitforpageload();
		return utils.doubleclickanelement(this.selectContract, "MemberComposite_ContractSection", "selectContract");

	}

	@FindBy(xpath="//*[@class='gridTable ']//*[@data-test-id='20150910133318034719310']")
	WebElement contractCodeInPopup;

	@FindBy(xpath="//*[@class='content-item content-field item-8   ']//*[@data-test-id='201509101229430562277900']")
	WebElement contractCode;

	String txtContractCode;

	/**This method is used to Switch contact and verify the same
	 * 
	 */
	public boolean switchContract() throws InterruptedException {		
			if(clickContractInContractSection())
			waitforpageload();
			if(!utils.isProxyWebelement(contractCodeInPopup))
				txtContractCode = contractCodeInPopup.getText();
				return utils.clickAnelemnt(contractCodeInPopup, "ProviderComposite_ContractSection", "Contract Code");
	}

	/**This method is used to verify switched contract and has a dependency of method "switchContract"
	 * 
	 */
	public boolean verifySwitchedContract() throws InterruptedException{
			utils.waitforpageload();
			return utils.validateLabel(contractCode,txtContractCode);
	}


	//Sprint 2.2 Code

	@FindBy(xpath="(//div[@node_name='RelatedContracts']//a[contains(text(),'Expand/Collapse All')])[1]")
	WebElement lnkExpandCollapseAll;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickExpandCollapseAll
	 * #Description: This functionality performs click action on the Expand and collapse all link in the Select Contract page
	 * Type: Textbox
	 */
	public boolean clickExpandCollapseAll()
	{
			return utils.clickAnelemnt(this.lnkExpandCollapseAll, "SelectContract", "Expand Collapse All");		
	}

	@FindBy(xpath="//table[@pl_prop='.Coverages']")
	WebElement tblSubTableOfSelectedContracts;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifySelectedContractsSubTable
	 * #Description: This functionality validates the input values given by the user with the values present in the Sub Contract table
	 * #Argument: tablevlaues
	 * Type: Table
	 * Keys: Eligibility Effective Date#Eligibility End Date#Contract Code
	 */
	public boolean verifySelectedContractsSubTable(String[] tablevalues) throws InterruptedException
	{
		return utils.validatetablerowbasedonvalues(tblSubTableOfSelectedContracts, tablevalues);
	}

	@FindBy(xpath="//table[@pl_prop='HCMemberPolicyList.pxResults']")
	WebElement tblRelatedContracts;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectExpandPaneByContracts
	 * #Description: This functionality validates the input values given by the user with the values present in the Sub Contract table
	 * Type: Table
	 * Keys: Relationship#Status#Coverage Type#Contract Effective Period#Employer Group Name#Product Group Number#Source
	 */
	public boolean selectExpandPaneByContracts(String[] args)
	{
		try{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='HCMemberPolicyList.pxResults']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.getProviderResultsBasedOnValues(this.tblRelatedContracts, args);	
			row.findElement(By.xpath(".//span[@title='press enter to expand row']")).click();					
			return true;
		}catch(Exception e){
			return false;	
		}

	}

	//Sprint 2.4

	@FindBy(xpath="//span[contains(text(),'Vendor Information')]")
	WebElement lnkVendorInformationIndicator;

	@FindBy(xpath="//div[@node_name='VendorInformation']//span[contains(text(),'Consumer Driven Health Plan')]")
	WebElement lnkCDHPInformationIndicator;

	@FindBy(xpath="//table[@pl_prop='.OtherVendorList']")
	WebElement tblCDHPUnderCDHPIdicator;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyVendorIndicatorIsDisplayedUnderContractTab
	 * #Description: Verifies that the Vendor Information Indicator is displayed under Contrcat tab
	 * Type: Textbox
	 */
	public boolean  verifyVendorIndicatorIsDisplayedUnderContractTab()
	{
			WebElement element = this.lnkVendorInformationIndicator;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return !utils.isProxyWebelement(lnkVendorInformationIndicator);
	}

	public boolean clickVendorInformationIndicator()
	{
		return utils.clickAnelemnt(this.lnkVendorInformationIndicator, "MemberComposite_ContractSection", "Vendor Information Indicator");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyCDHPDropDownIsDisplayedUnderVendor
	 * #Description: Verifies that the CDHP Indicator is displayed under Vendor Information Indicator
	 * Type: Textbox
	 */
	public boolean  verifyCDHPDropDownIsDisplayedUnderVendor()
	{
			WebElement element = this.lnkVendorInformationIndicator;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			if(clickVendorInformationIndicator())
				if(!utils.isProxyWebelement(lnkCDHPInformationIndicator))
					return true;
			return false;	

	}


	public boolean clickCDHPInformationIndicator()
	{
		return utils.clickAnelemnt(this.lnkCDHPInformationIndicator, "MemberComposite_ContractSection", "Vendor Information Indicator");
	}


	/*
	 * @SCU
	 * #Description: Verifies the CDHP Information displayed for the CDHP Account members
	 * #Argument: CDHP Information-KeyValuePair
	 * Type: Table
	 * Keys: Name#Termination Date#Effective Date
	 */
	public boolean verifyCDHPInformationIsDisplayedUnderCDHPIndicator(String[] tablevalues)
	{
			this.clickCDHPInformationIndicator();
			return utils.validatetablerowbasedonvalues(this.tblCDHPUnderCDHPIdicator, tablevalues);
	}

	@FindBy(xpath="//table[@pl_prop='.OtherVendorList']//div[contains(text(),'No items')]")
	WebElement txtNoItemsForCDHPAccounts;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyErrorMessageIsDisplayedUnderCDHPIndicatorForNonCDHPAccounts
	 * #Description: Verifies that 'No Items' message is displayed in the CDHP Information table when members doesn't have CDHP accounts
	 * Type: Textbox
	 */
	public boolean verifyErrorMessageIsDisplayedUnderCDHPIndicatorForNonCDHPAccounts()
	{
			if(clickCDHPInformationIndicator())
				if(!utils.isProxyWebelement(txtNoItemsForCDHPAccounts))
					return true;
			return false;
	}

	@FindBy(xpath="//*[@data-test-id='2015112013594604362587']")
	WebElement RestrictMessage;

	@FindBy(id="ModalButtonSubmit")
	WebElement OkButtonInPopUp;

	public boolean RestrictMessageToSwitchContractWhenTaskIsOpen() {
		if(!utils.isProxyWebelement(RestrictMessage))
			return utils.clickAnelemnt(OkButtonInPopUp, "ProviderComposite_ContractSection", "OkButtonInPopUp");
		return false;

	}

	@FindBy(xpath="//div[@node_name='MemberContractsList']//table[@pl_prop_class='Antm-FW-CSFW-Data-Product']")
	WebElement SelectContractPopUpTable;

	public boolean SwitchContractBasedOnValues(String[] args) throws InterruptedException {
		utils.waitforpageload();
		if( utils.clickAnelemnt(this.selectContract, "MemberComposite_ContractSection", "selectContract"))
			return utils.clickontablerowbasedonvalues(SelectContractPopUpTable, args);
		return false;
	}
	
	public boolean refreshPage() {
		utils.refreshthepage();
		return true;
	}
	
	/* code for clicking vendor information link*/
    
    @FindBy(xpath="//span[text()='Vendor Information']")
    WebElement VendorInformation;
    
    public boolean expandVendorInformation()
    {
           return utils.clickAnelemnt(VendorInformation, "ProviderComposite_ContractSection", "Vendor Information");
    }
    
	  /* code for clicking AIM Speciality health link*/
    
    @FindBy(xpath="//span[text()='AIM Specialty Health']")
    WebElement AIMSpecialityHealth;

    public boolean expandAIMSpecialityHealth()
    {
           return utils.clickAnelemnt(AIMSpecialityHealth, "ProviderComposite_ContractSection", "AIMSpecialityHealth");
    }
    
    
    
    @FindBy(xpath="//table[@pl_prop='.AIMVendorList']")
    WebElement AIMSpecialityHealthTable;
    
    public boolean validateAIMSpecialityHealthTable(String[] args) { 
           
           return utils.validatetablerowbasedonvalues(AIMSpecialityHealthTable, args);
    }
    
    @FindBy(xpath="//table[@pl_prop='.AIMVendorList']//span[@data-ctl='expCollIcon']")
    WebElement AIMSpecialityHealthPrograms;
    
    @FindBy(xpath="//table[@pl_prop='.ProgramList']")
    WebElement AIMSpecialityProgramName;
    
    
    public boolean expandAIMSpecialityHealthTableANdValidateDetails(String[] args) {
           
           if(utils.clickAnelemnt(AIMSpecialityHealthPrograms, "ProviderComposite_ContractSection", "AIMSpecialityHealthPrograms"))
           {
                 return utils.validatetablerowbasedonvalues(AIMSpecialityProgramName, args);
                 
           }
           return false;
    }
    
    /*//span[@data-ctl='expCollIcon']*/
    
    
}


	
	



