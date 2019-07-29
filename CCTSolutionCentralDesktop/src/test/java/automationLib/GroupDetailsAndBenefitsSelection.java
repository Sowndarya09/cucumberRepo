package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class GroupDetailsAndBenefitsSelection {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	public GroupDetailsAndBenefitsSelection() 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	@FindBy(xpath="//div[@node_name='GroupDetailsBenefits']//h3[contains(text(),'Group Details')]")
	WebElement tabGroupDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBB']//label[@for='GroupName']//following-sibling::div//span")
	WebElement labelEmpGrpInfoGroupName;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBB']//label[@for='SmallGroupNumber']//following-sibling::div//span")
	WebElement labelEmpGrpInfoGroupNumber;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBB']//label[@for='GroupStatus']//following-sibling::div//span")
	WebElement labelEmpGrpInfoGroupStatus;

	@FindBy(xpath="xpath for Employer Group Name value")
	WebElement labelEmpGrpInfoGroupTerminationDate;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBB']//label[@for='GroupTapeInd']//following-sibling::div//span")
	WebElement labelEmpGrpInfoGroupTapeEnrolmentInd;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBB']//label[@for='pyTemplateInputBox']//following-sibling::div//span")
	WebElement labelEmpGrpInfoGroupTapeLastUpdateDate;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBB']//label[contains(text(),'Open Enrollment')]//following-sibling::div//span")
	WebElement labelEmpGrpInfoGroupOpenEnrollmentMonth;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBB']//label[contains(text(),'Account Type')]//following-sibling::div//span")
	WebElement labelEmpGrpInfoAccountType;


	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBBB']//label[@for='ProductGroupName']//following-sibling::div//span")
	WebElement labelProdGrpInfoGroupName;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBBB']//label[@for='ProductGroupNumber']//following-sibling::div//span")
	WebElement labelProdGrpInfoGroupNumber;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBBB']//label[@for='FundingType']//following-sibling::div//span")
	WebElement labelProdGrpInfoFundTypeCD;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBBB']//label[@for='pyTemplateInputBox']//following-sibling::div//span")
	WebElement labelProdGrpInfoRateMethodCode;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBBB']//label[@for='IDCardMailing']//following-sibling::div//span")
	WebElement labelProdGrpInfoIDCardMailing;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBBB']//label[contains(text(),'Prefix')]//following-sibling::div//span")
	WebElement labelProdGrpInfoPrefix;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupSearchGroupDetailsBBB']//label[@for='PolicyState']//following-sibling::div//span")
	WebElement labelProdGrpInfoStateHQ;

	@FindBy(xpath="Xpath for Contract Information Table")
	WebElement tblContractInformation;

	@FindBy(xpath="//span[contains(text(),'Anthem Group Management')]")
	WebElement grpMgmtInfo;

	@FindBy(xpath="//a[contains(text(),'Provider Services Job Aid')]")
	WebElement lnkproviderServicesJobAid;

	@FindBy(xpath="//span[contains(text(),'Address and Contact Information')]")
	WebElement lnkAddressAndContactInformation;

	@FindBy(xpath="//table[@pl_prop='.AddressList']")
	WebElement tblEmployerGroupAddress;

	@FindBy(xpath="//table[@pl_prop='.SubGroupAddressList']")
	WebElement tblProductGroupAddress;

	@FindBy(xpath="//table[@pl_prop='.GroupPhoneList']")
	WebElement tblEmployerGroupPhoneNumbers;

	@FindBy(xpath="//table[@pl_prop='.SubGroupPhoneList']")
	WebElement tblProductGroupPhoneNumbers;

	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='RecipientNamePhone']//following-sibling::div")
	WebElement labelAnthemGrpInfoServiceLocation;

	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='CPCCIndicator']//following-sibling::div//span")
	WebElement labelAnthemGrpInfoTransferToProvider;

	@FindBy(xpath="//div[@node_name='AnthemGroupManagement']//label[@for='ClaimsAddress']//following-sibling::div//span")
	WebElement labelAnthemGrpInfoClaimsAddress;

	@FindBy(xpath="//span[contains(text(),'Broker Information')]")
	WebElement lnkBrokerInformation;

	@FindBy(xpath="//div[@node_name='BrokersListInformation']//label[@for='BrokerFName']//following-sibling::div//span")
	WebElement labelBrokerInfoFirstName;

	@FindBy(xpath="//div[@node_name='BrokersListInformation']//label[@for='BrokerLName']//following-sibling::div//span")
	WebElement labelBrokerInfoLastName;

	@FindBy(xpath="//div[@node_name='BrokersListInformation']//label[@for='CompanyName']//following-sibling::div//span")
	WebElement labelBrokerInfoCompanyName;

	@FindBy(xpath="//div[@node_name='BrokersListInformation']//label[@for='BrokerTaxID']//following-sibling::div//span")
	WebElement labelBrokerInfoTaxID;

	@FindBy(xpath="//div[@node_name='BrokersListInformation']//label[@for='BrokerEncryptedID']//following-sibling::div//span")
	WebElement labelBrokerInfoEncryptedID;

	@FindBy(xpath ="//table[@param_name='EXPANDEDSubSectionBrokerAddressListB~pzLayout_1']//table[@pl_prop='.AddressList']")
	WebElement tblBrokerAddress;


	@FindBy(xpath ="//table[@pl_prop='.SubGroupContacts']")
	WebElement tblProdGrpContact;

	@FindBy(xpath ="//table[@pl_prop='.GroupContacts']")
	WebElement tblEmpGrpContact;

	@FindBy(name="$PpyWorkPage$pGroupDetailsInfoReview")
	WebElement chkboxGroupDetailsDisccused;


	@FindBy(xpath="//span[contains(text(),'Anthem Group Management')]")
	WebElement lnkAnthemGrpMgmt;


	@FindBy(xpath="//span[contains(text(),'Product Group Contact')]")
	WebElement lnkProductGrpContact;

	@FindBy(xpath="//span[contains(text(),'Employer Group Contact')]")
	WebElement lnkEmployerGrpContact;


	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="//h3[contains(text(),'Benefits Selection')]")
	WebElement tabBenefitSelection;

	@FindBy(xpath="xpath of the date of service text box")
	WebElement txtBoxDateOfService;

	@FindBy(xpath="//label[contains(text(),'Benefits Overview')]")
	WebElement tabBenefitsOverview;

	@FindBy(name="BenefitsDetails_tmpBenefitsInsightPage_368")
	WebElement lnkBenefitsMajor;

	@FindBy(name="BenefitsDetails_tmpBenefitsInsightPage_465")
	WebElement lnkBenefitsCategory;

	@FindBy(name="BenefitsDetails_tmpBenefitsInsightPage_507")
	WebElement lnkBenefitsDefaultView;

	@FindBy(id="SelectBenefitsForCont1")
	WebElement chkbxGeneralProvisionsBenefits;

	@FindBy(id="SelectBenefitsForCont2")
	WebElement chkbxEligibilityBenefits;

	@FindBy(id="SelectBenefitsForCont5")
	WebElement chkbxContractAdministratioBenefits;

	@FindBy(id="SelectBenefitsForCont7")
	WebElement chkbxComprehensiveMajorMedicalBenefits;

	@FindBy(id="SelectBenefitsForCont8")
	WebElement chkbxIndivAndFamilyDeductiblesBenefits;

	@FindBy(id="SelectBenefitsForCont13")
	WebElement chkbxGeneralBasisOfPaymentBenefits;

	@FindBy(id="pySelected1")
	WebElement chkbxGeneralProvisionsBenefitsAdmin;

	@FindBy(id="pySelected2")
	WebElement chkbxGeneralBenefitsAdmin;

	@FindBy(id="pySelected4")
	WebElement chkbxEligibilityBenefitsAdmin;

	@FindBy(id="pySelected7")
	WebElement chkbxExclusionsAndLimitationsBenefitsAdmin;


	@FindBy(xpath="//button[@data-test-id='2016031917365406777346']//div[@class='pzbtn-mid'][text()='Submit']")
	WebElement btnSubmitBenfitsSelection;

	@FindBy(id="ContactReason")
	WebElement drpDownReasonForContact;

	@FindBy(xpath="//span[contains(text(),'Group Details Reviewed with Contact on Group Search')]")
	WebElement lnkGroupDetailsReviewedWithContact;



	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickGroupDetailsHeader
	 * #Description: This functionality performs click action on the Group Details header tab
	 * Type: Textbox 
	 */
	public boolean clickGroupDetailsHeader()
	{
		return utils.clickAnelemnt(tabGroupDetails, "GroupDetailsAndBenefitsSelection", "Group Details Header");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickChkBxGroupDetails
	 * #Description: This functionality performs the click action on the Group Details discussing check box
	 * Type: Textbox
	 */
	public boolean clickChkBxGroupDetails()
	{
		return utils.clickAnelemnt(chkboxGroupDetailsDisccused, "GroupDetailsAndBenefitsSelection", "Group Details check box");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyEmployerGroupInformation
	 * #Description: This functionality verifies the Employer Group Information in the Group Details section
	 * #Arguments: grpinfoDetails
	 * Type: Table
	 * keys:Group Name#Group Number#Group Status#Termination Date#Tape Enroll Ind#Last Update Date#Open Enroll Mon#Acc Type 
	 */
	public boolean verifyEmployerGroupInformation(String[] grpinfoDetails)
	{
		System.out.println("Entered into the method");
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";

		for(String iterator : grpinfoDetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("grpname")){
				returnvar = this.labelEmpGrpInfoGroupName.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("grpnumber")){
				returnvar = this.labelEmpGrpInfoGroupNumber.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("grpstatus")){
				returnvar = this.labelEmpGrpInfoGroupStatus.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("tapeenrollind")){
				returnvar = this.labelEmpGrpInfoGroupTapeEnrolmentInd.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("lastupdatedate")){
				returnvar = this.labelEmpGrpInfoGroupTapeLastUpdateDate.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("openenrollmon")){
				returnvar = this.labelEmpGrpInfoGroupOpenEnrollmentMonth.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("acctype")){
				returnvar = this.labelEmpGrpInfoAccountType.getText().toLowerCase().contains(value);
				continue;
			}
			else 
				err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("Group Information verified successfully");
			return true;	
		}
		else
		{
			int tot_i=grpinfoDetails.length;
			err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "the value "+grpinfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyProductGroupInformation
	 * #Description: This functionality verifies the Product Group Information in the Group Details section
	 * #Arguments: prodinfoDetails
	 * Type: Table
	 * keys:Group Name#Group Number#Fund Type CD#Rate Method Code#ID Card Mailing#Prefix#State HQ 
	 */

	public boolean verifyProductGroupInformation(String[] prodinfoDetails)
	{
		System.out.println("Entered into the method");
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";

		for(String iterator : prodinfoDetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("grpname")){
				returnvar = this.labelProdGrpInfoGroupName.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("grpnumber")){
				returnvar = this.labelProdGrpInfoGroupNumber.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("fundtypecd")){
				returnvar = this.labelProdGrpInfoFundTypeCD.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("ratemthdcode")){
				returnvar = this.labelProdGrpInfoRateMethodCode.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("idcardmailing")){
				returnvar = this.labelProdGrpInfoIDCardMailing.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("prefix")){
				returnvar = this.labelProdGrpInfoPrefix.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("statehq")){
				returnvar = this.labelProdGrpInfoStateHQ.getText().toLowerCase().contains(value);
				continue;
			}
			else 
				err.logcommonMethodError("Group Details", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("Group Information verified successfully");
			return true;	
		}
		else
		{
			int tot_i=prodinfoDetails.length;
			err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "the value "+prodinfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyContractInformation
	 * #Description: This functionality verifies the values in the contract information table in group details section.
	 * #Arguments: continfodetails
	 * Type: Table
	 * keys:Contract Code#Effective Date#End Date#Product Type#Product Family#Product Indicator
	 */
	public boolean verifyContractInformation(String[] continfodetails)
	{
		boolean returnvar =true;
		String concode= null,effdate= null,enddate = null,prodtype= null,prodfamily= null,prodindicator= null;
		ArrayList<String> expected= new ArrayList<String>();
		for(String iterator : continfodetails)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyContractInformation", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("Contract Code"))
			{			
				returnvar=true;
				concode=value.toLowerCase();				
				continue;		
			}
			else if(key.toLowerCase().contains("Effective Date"))
			{
				returnvar=true;
				effdate=value.toLowerCase();
				continue;	
			}
			else if(key.toLowerCase().contains("End Date"))
			{
				returnvar=true;
				enddate=value.toLowerCase();
				continue;	
			}
			else if(key.toLowerCase().contains("Product Type"))
			{
				returnvar=true;
				prodtype=value.toLowerCase();
				continue;	
			}
			else if(key.toLowerCase().contains("Product Family"))
			{
				returnvar=true;
				prodfamily=value;
				continue;	
			}
			else if(key.toLowerCase().contains("Product Indicator"))
			{
				returnvar=true;
				prodindicator=value.toLowerCase();
				continue;
			}
			else
			{
				err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		try{
			WebElement row =utils.returntablerowbasedonvalues(this.tblContractInformation,continfodetails );
			List<WebElement> allcolumns = row.findElements(By.tagName("td"));
			System.out.println("Values Matched in a row");
			return true;	
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level");
		}
		if(!returnvar)
		{
			System.out.println("Matching rows not found for given input");	
			return false;
		}
		return true;
	}

	public boolean clickAnthemGroupMgmtLink()
	{
		return utils.clickAnelemnt(lnkAnthemGrpMgmt, "GroupDetailsAndBenefitsSelection", "Anthem Group Management link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyAnthemGrpMgmtInfo
	 * #Description: This functionality verifies the information in the Anthem Group Management section
	 * #Arguments: grpmgmtinfodetails
	 * Type: Table
	 * keys:Service Location#Transfer to provider#Claim Address
	 */
	public boolean verifyAnthemGrpMgmtInfo(String[] grpmgmtinfodetails)
	{
		this.clickAnthemGroupMgmtLink();
		System.out.println("Anthem Group Management link is clicked");
		System.out.println("Entered into the method");
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";		
		for(String iterator : grpmgmtinfodetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;	
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			if(key.toLowerCase().contains("servicelocation")){
				returnvar = this.labelAnthemGrpInfoServiceLocation.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("transfer")){
				returnvar = this.labelAnthemGrpInfoTransferToProvider.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("claimsaddress")){
				returnvar = this.labelAnthemGrpInfoClaimsAddress.getText().toLowerCase().contains(value);
				continue;
			}
			else 
				err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		err.logError("GroupDetailsAndBenefitsSelection", "Group Details Tab");
		if(returnvar)
		{
			System.out.println("Group Information verified successfully");
			return true;	
		}
		else
		{
			int tot_i=grpmgmtinfodetails.length;
			err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "the value "+grpmgmtinfodetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAdvertiseLink
	 * #Description: This functionality performs click action in the advertisement link
	 * Type: Textbox
	 */
	public boolean clickAdvertiseLink() throws InterruptedException
	{
		if(utils.clickAnelemnt(lnkproviderServicesJobAid, "GroupDetailsAndBenefitsSelection", "Add Link"))
			return this.clickCloseIconInAddLinkPage();
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCloseIconInAddLinkPage
	 * #Description: This functionality navigates to the advertisement link page and clicks the close icon. 
	 */
	public boolean clickCloseIconInAddLinkPage() throws InterruptedException{
		String parent = Driver.pgDriver.getWindowHandle();
		if(this.lnkproviderServicesJobAid.isDisplayed()){
			utils.clickAnelemnt(this.lnkproviderServicesJobAid, "GroupDetailsAndBenefitsSElection", "Provider Services Job Aid");
			System.out.println("User clicks the Provider Services Job Aid link");
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+handles.size());
			Iterator<String> iterator= handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow);
			String title = Driver.pgDriver.getTitle();
			if(title.contains("Provider Service Contact Numbers – ACA Contact Centers")){
				System.out.println("Provider Service Add is launched - Title is"+ title);
				Driver.pgDriver.close();
				return true;
			}else{
				err.logcommonMethodError("ConsumerDrivenHealthPlan", "Error in switching to childwindow-Provider Sevice Aid");
				return false;
			}
		}
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "Tier1 / Tier2 Document link is not displayed in - View Consumer Driven Health Plan Accounts");
		return false;
	}


	public boolean clickAddressandContactInformationLink()
	{
		return utils.clickAnelemnt(lnkAddressAndContactInformation, "Group Details", "Address and Contact Information Link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyEmployerGroupAddress
	 * #Description: This functionality verifies the values in the Employer group address table
	 * #Arguments: empgrpaddress
	 * Type: Table
	 * keys:Type#Name#Address Line1#Address Line2#City#State#Zip Code
	 */
	public boolean verifyEmployerGroupAddress(String[] empgrpaddress) throws InterruptedException
	{
		if(this.clickAddressandContactInformationLink()) {
			WebElement empgrptable = Driver.pgDriver.findElement(By.xpath ("//table[@pl_prop='.AddressList']"));
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", empgrptable);
			return utils.validatetablerowbasedonvalues(this.tblEmployerGroupAddress,empgrpaddress);
		}
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyProductGroupAddress
	 * #Description: This functionality verifies the values in the Product Group Address table
	 * #Arguments: prodgrpaddress
	 * Type: Table
	 * keys:Type#Name#Address Line1#Address Line2#City#State#Zip Code
	 */
	public boolean verifyProductGroupAddress(String[] prodgrpaddress) throws InterruptedException
	{
		WebElement prodgrptable = Driver.pgDriver.findElement(By.xpath ("//table[@pl_prop='.AddressList']"));
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", prodgrptable);
		return utils.validatetablerowbasedonvalues(this.tblProductGroupAddress,prodgrpaddress);
	}


	/*
	 * @SCU
	 * #CommmonMethodWithArgument: verifyEmployerGroupPhoneNumbers
	 * #Description: This functionality verifies the values in the Employer Group Phone Number table
	 * #Arguments: empgrpphno
	 * Type: Table
	 * keys:Type#Number#Extension
	 */
	public boolean verifyEmployerGroupPhoneNumbers(String[] empgrpphno) throws InterruptedException
	{
		WebElement empgrpphonetable = Driver.pgDriver.findElement(By.xpath ("//table[@pl_prop='.GroupPhoneList']"));
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", empgrpphonetable);
		return utils.validatetablerowbasedonvalues(this.tblEmployerGroupPhoneNumbers,empgrpphno);
	}


	/*
	 * @SCU
	 * #CommmonMethodWithArgument: verifyProdGroupPhoneNumbers
	 * #Description: This functionality verifies the values in the Product Group Phone Number table
	 * #Arguments: prodgrpphno
	 * Type: Table
	 * keys:Type#Number#Extension
	 */
	public boolean verifyProdGroupPhoneNumbers(String[] prodgrpphno) throws InterruptedException
	{
		WebElement prodgrpphonetable = Driver.pgDriver.findElement(By.xpath ("//table[@pl_prop='.SubGroupPhoneList']"));
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", prodgrpphonetable);
		return utils.validatetablerowbasedonvalues(this.tblProductGroupPhoneNumbers,prodgrpphno);
	}

	public boolean clickBrokerInformation()
	{
		return utils.clickAnelemnt(lnkBrokerInformation, "GroupDetails", "Broker Information Link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyBrokerInformation
	 * #Description: This functionality verifies the Broker Information in the Group Details section
	 * #Arguments: brokerinfoDetails
	 * Type: Table
	 * keys:First Name#Last Name#Company Name#Tax ID#Encrypted ID 
	 */
	public boolean verifyBrokerInformation(String[] brokerinfoDetails)
	{
		this.clickBrokerInformation();
		System.out.println("Broker Information Link is clicked");
		System.out.println("Entered into the method");
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";			
		for(String iterator : brokerinfoDetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;	
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);		
			if(key.toLowerCase().contains("firstname")){
				returnvar = this.labelBrokerInfoFirstName.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("lastname")){
				returnvar = this.labelBrokerInfoLastName.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("companyname")){
				returnvar = this.labelBrokerInfoCompanyName.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("taxid")){
				returnvar = this.labelBrokerInfoTaxID.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("encrypid")){
				returnvar = this.labelBrokerInfoEncryptedID.getText().toLowerCase().contains(value);
				continue;
			}
			else 
				err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		err.logError("GroupDetailsAndBenefitsSelection", "Group Details Tab");
		if(returnvar)
		{
			System.out.println("Broker Information verified successfully");
			return true;	
		}
		else
		{
			int tot_i=brokerinfoDetails.length;
			err.logcommonMethodError("GroupDetailsAndBenefitsSelection", "the value "+brokerinfoDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}


	/*
	 * @SCU
	 * #CommmonMethodWithArgument: verifyProductGroupAddress
	 * #Description: This functionality verifies the values in the Broker Address table
	 * #Arguments: brokeraddress
	 * Type: Table
	 * keys:Type#Name#Address Line1#Address Line2#City#State#Zip Code
	 */
	public boolean verifyBrokerAddress(String[] brokeraddress) throws InterruptedException
	{
		WebElement brokeraddresstable = Driver.pgDriver.findElement(By.xpath ("//table[@param_name='EXPANDEDSubSectionBrokerAddressListB~pzLayout_1']//table[@pl_prop='.AddressList']"));
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", brokeraddresstable);
		return utils.validatetablerowbasedonvalues(this.tblBrokerAddress,brokeraddress);
	}


	public boolean clickSubmit()
	{
		return utils.clickAnelemnt(btnSubmit, "GroupDetailsAndBenefitsSelection", "Submit");
	}


	public boolean clickProductGroupContact()
	{
		WebElement prodgrptable = Driver.pgDriver.findElement(By.xpath ("//span[contains(text(),'Product Group Contact')]"));
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", prodgrptable);
		return utils.clickAnelemnt(prodgrptable, "GroupDetailsAndBenefitsSelection", "Product Group Contact Link");
	}

	public Hashtable<String,String[]> parseTableRowData(WebElement tbl)
	{
		Hashtable<String,String[]> result = new Hashtable<String,String[]>();
		List<WebElement> allRows = tbl.findElements(By.tagName("tr"));
		if(allRows.size()>0) 
		{
			for(WebElement row:allRows)
			{
				List<WebElement>  allColsRow = row.findElements(By.tagName("td"));
				if(allColsRow.size()>0)
				{
					String[] values = new String[allColsRow.size()];
					System.out.println("key: " + allColsRow.get(1).getText());
					System.out.println("Values: ");
					for(int i=0; i<allColsRow.size(); i++)
					{
						if(i!=1)
						{
							if(i<1)
							{
								values[i] = allColsRow.get(i).getText();
								System.out.println(values[i]);
							}else
							{
								values[i-1] = allColsRow.get(i).getText();
								System.out.println(values[i-1]);	
							}
						}
					}
					result.put(allColsRow.get(1).getText(), values);
				}
			}
		}
		return result;		
	}

	public boolean validateKeyValueCombinations(WebElement tbl, String[] inputvalues)
	{
		String inputKey, inputValue;
		Hashtable<String,String[]> actualKeyValuePairs =  new Hashtable<String,String[]>();
		actualKeyValuePairs = parseTableRowData(tbl);
		for(String key: actualKeyValuePairs.keySet())
		{
			System.out.println(key + " : " + Arrays.toString(actualKeyValuePairs.get(key)));
		}
		for(String item : inputvalues)
		{
			String[] inputVals = item.split(":");
			inputKey = inputVals[0];
			inputValue = inputVals[1];
			System.out.println("input key: " + inputKey + ", Input Value: " + inputValue);
			String[] actualValuesList = actualKeyValuePairs.get(inputKey);
			System.out.println("Values List: " + Arrays.toString(actualValuesList));
			if(Arrays.asList(actualValuesList).contains(inputValue))
			{
				System.out.println(inputValue + " available in "+ Arrays.toString(actualValuesList));
				continue;
			}
			else
			{
				System.out.println(inputValue + " not available in "+ Arrays.toString(actualValuesList));
				return false;
			}	
		}
		return true ;
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: checkValuesinProductGrpContactTable
	 * #Description: This functionality validates the values in the product group table
	 * #Argument: ProductGroupValues
	 * keys: 
	 */
	public boolean checkValuesinProductGrpContactTable(String[] inputvalues)
	{
		if(this.clickProductGroupContact())
			return this.validateKeyValueCombinations(tblProdGrpContact, inputvalues);
		return false;
	}


	public boolean clickEmployerGroupContact()
	{
		WebElement empgrptable = Driver.pgDriver.findElement(By.xpath ("//span[contains(text(),'Employer Group Contact')]"));
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", empgrptable);
		return utils.clickAnelemnt(empgrptable, "Group Details", "Employer Group Contact Link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: checkValuesinProductGrpContactTable
	 * #Description: This functionality validates the values in the product group table
	 * #Argument: EmployerGroupValues
	 * keys: 
	 */
	public boolean checkValuesinEmployerGrpContactTable(String[] inputvalues)
	{
		if(this.clickEmployerGroupContact())
			return this.validateKeyValueCombinations(tblEmpGrpContact, inputvalues);
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickBenefitsSelectionHeader
	 * #Description: This functionality performs click action on the Benefits Selection header tab
	 * Type: Textbox 
	 */
	public boolean clickBenefitsSelectionHeader()
	{
		return utils.clickAnelemnt(tabBenefitSelection, "GroupDetailsAndBenefitsSelection", "Group Details Header");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterDateOfService
	 * #Description: This functionality enters the Date of Service in the date section
	 * #Argument: date
	 * Type: Textbox
	 */
	public boolean enterDateOfService(String[] date)
	{
		return utils.enterTextinAnelemnt(txtBoxDateOfService, date[0], "GroupDetailsAndBenefitsSelection", "Date of Service");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickBenefitsOverViewTab
	 * #Description: This functionality performs click action on the Benefits overview tab
	 * Type: Textbox
	 */
	public boolean clickBenefitsOverViewTab()
	{
		return utils.clickAnelemnt(tabBenefitsOverview, "GroupDetailsAndBenefitsSelection", "Benefits Overview tab");
	}

	public boolean clickBenefitCheckboxes(String[] checkboxname)
	{
		String BenefitXpath ="//span[contains(text(),'"+checkboxname[0]+"')]//parent::td//ancestor::tr[contains(@id,'BenefitsContingencyDetails')]//input[@type='checkbox']";
		System.out.println("Benefit Xpath is: " + BenefitXpath);
		Driver.pgDriver.findElement(By.xpath(BenefitXpath)).click();
		return true;
	}

	public boolean clickBenefitAdminCheckboxes(String[] checkboxname)
	{
		String BenefitAdminXpath ="//span[contains(text(),'"+checkboxname[0]+"')]//parent::td//ancestor::tr[contains(@id,'BenefitsContingencyAdminDetails')]//input[@type='checkbox']";
		System.out.println("Benefit Admin Xpath is: " + BenefitAdminXpath);
		Driver.pgDriver.findElement(By.xpath(BenefitAdminXpath)).click();
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: getSelectedCategoriesCheckBoxes
	 * #Description: This functionality selects the checkboxes in the Benefits and Benefits Admin section based on the input given by the user.
	 * #Argument: inputValues
	 * Type: Table
	 * keys: #Benefits-GENERAL PROVISIONS#Benefits-ELIGIBILITY#Benefits-CONTRACT ADMINISTRATION#Benefits-COMPREHENSIVE MAJOR MEDICAL#Benefits-INDIV AND FAMILY DEDUCTIBLES#Benefits-GENERAL BASIS OF PAYMENT#Benefits Admin-GENERAL PROVISIONS#Benefits-GENERAl#Benefits Admin-ELIGIBILITY#Benefits Admin-EXCLUSIONS AND LIMITATIONS
	 */

	public List<String> getSelectedCategoriesCheckBoxes(String[] inputValues){
		List<String> selectionList = new ArrayList<String>();		
		for(String item : inputValues){
			String[] input = item.split(":");
			String chkBx = input[0];
			String selection = input[1];
			String[] result = chkBx.split("-");
			String sectionName = result[0];
			String checkBxName = result[1];
			try
			{
				if(sectionName.equalsIgnoreCase("Benefits"))
				{
					String BenefitXpath ="//span[contains(text(),'"+checkBxName+"')]//parent::td//ancestor::tr[contains(@id,'BenefitsContingencyDetails')]//input[@type='checkbox']";
					System.out.println("Benefit Xpath is: " + BenefitXpath);
					Driver.pgDriver.findElement(By.xpath(BenefitXpath)).click();
				}
				else if(sectionName.equalsIgnoreCase("Benefits Admin"))
				{
					String BenefitAdminXpath ="//span[contains(text(),'"+checkBxName+"')]//parent::td//ancestor::tr[contains(@id,'BenefitsContingencyAdminDetails')]//input[@type='checkbox']";
					System.out.println("Benefit Admin Xpath is: " + BenefitAdminXpath);
					Driver.pgDriver.findElement(By.xpath(BenefitAdminXpath)).click();
				}
				selectionList.add(chkBx);
				System.out.println("Values in Selection List is: "+ selectionList);
			}catch(Exception e)
			{
				err.logError("GroupDetailsAndBenefitsSelection", "checkbox -"+ checkBxName + "clicked is failed");
			}
		}
		try
		{
			System.out.println("Entered into Submit blocked.");
			utils.clickAnelemnt(btnSubmitBenfitsSelection, "GroupDetailsAndBenefitsSelection", "Submit is clicked");
		}catch(Exception e)
		{
			err.logError("GroupDetailsAndBenefitsSelection", "Submit is failed");
		}
		return selectionList;
	}



	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickMajorLink
	 * #Description: This functionality performs click action on the major link under the benefits section
	 * Type: Textbox
	 */
	public boolean clickMajorLink()
	{
		return utils.clickAnelemnt(lnkBenefitsMajor, "GroupDetailsAndBenefitsSelection", "Major Link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickMajorLink
	 * #Description: This functionality performs click action on the category link under the benefits section
	 * Type: Textbox
	 */
	public boolean clickCategoryLink()
	{
		return utils.clickAnelemnt(lnkBenefitsCategory, "GroupDetailsAndBenefitsSelection", "Category Link");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickDefaultViewLink
	 * #Description: This functionality performs click action on the default view link under the benefits section
	 * Type: Textbox
	 */
	public boolean clickDefaultViewLink()
	{
		return utils.clickAnelemnt(lnkBenefitsDefaultView, "GroupDetailsAndBenefitsSelection", "Default View Link");

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSubmitInBenefitsSelection
	 * #Description: This functionality clicks the submit button in the BenfitsSelection page
	 * Type: Textbox
	 */
	public boolean clickSubmitInBenefitsSelection() 
	{
		return utils.clickAnelemnt(btnSubmitBenfitsSelection, "GroupDetailsAndBenefitsSelection", "Submit Btn");
	}


}
