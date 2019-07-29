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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class MemberComposite_MemberSection {
	WebDriverWait wait;
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	public MemberComposite_MemberSection() {

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		// PageFactory.initElements(Driver.getPgDriver(), this);

		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;
	// TABS__________________________________________________________________________

	@FindBy(xpath = "//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;

	@FindBy(xpath = "//img[@alt='Loading...']")
	WebElement loadingicon;

	@FindBy(xpath = "//label[text()='Loading...']")
	WebElement loadinglabel;

	@FindBy(xpath = "//img[contains(@src,'addtask')]")
	WebElement btnMbrCompositeAddTask;

	@FindBy(id = "ModalButtonSubmit")
	WebElement btnVerificationSubmit;

	// @FindBy(className="Wrap_up_button pzhc")
	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Wrap Up']")
	WebElement btnMbrCompositeWrapup;

	// MEMBER TAB
	// ---------------------------------------------------------------------------------

	@FindBy(xpath = "//a[@data-test-id='20150918122626032224625']")
	WebElement linkMbrCompositeMemberName;

	@FindBy(name = "SubscriberInformation_pyWorkPage_1")
	WebElement linkMbrCompositeContractNumber;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='EID']/parent::div/parent::div/parent::div[@bsimplelayout='true']")
	WebElement imagealternateid;

	@FindBy(xpath = "//*[@pl_prop='D_MembersOnContract.pxResults']")
	WebElement tableMbrCompositeMembertable;

	@FindBy(xpath = "//*[@node_name='MemberContractsList']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeContracttable;

	@FindBy(xpath = "//div[@node_name='MemberGeneralInformation']//label[@for='pyFullName']/parent::div//span//a")
	WebElement labelMbrCompositeMemName;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='HCIDDisplay']/parent::div//span")
	WebElement labelMbrCompositeMemberID;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='EID']/parent::div//span")
	WebElement labelMbrCompositeMbrEmployeeID;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='LegacyHCID']/parent::div//span")
	WebElement labelMbrCompositeMbrLegacyHCID;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='Relationship']/parent::div//span")
	WebElement labelMbrCompositeMbrRelationship;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='DateOfBirth']/parent::div//span")
	WebElement labelMbrCompositeMbrDOB;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='Age']/parent::div//span//span")
	WebElement labelMbrCompositeMbrAge;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='EffectiveDate']/parent::div//span")
	WebElement labelMbrCompositeMbrEffDate;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='EndDate']/parent::div/div")
	WebElement labelMbrCompositeMbrEndDate;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='MBUName']/parent::div/div")
	WebElement labelMbrCompositeMbrMBUName;

	// @FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='WrittenLanguage']/parent::div/div")
	// WebElement labelMbrCompositeMbrWrittenLanguage;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='SpokenLanguage']/parent::div/div")
	WebElement labelMbrCompositeMbrSpokenLanguage;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='Race']/parent::div/div")
	WebElement labelMbrCompositeMbrRace;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='Ethnicity']/parent::div/div")
	WebElement labelMbrCompositeMbrEthnicity;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='LegacyHCID']/parent::div//span")
	WebElement labelMbrCompositeMbrLegacyId;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='EID']/parent::div//span")
	WebElement labelMbrCompositeMbrAlternateId;

	@FindBy(xpath = "//a[contains(@onclick,'DueDtReviewed')]//img")
	WebElement chkbxMbrCompositeMbrTerminationDate;

	@FindBy(xpath = "//a[contains(@onclick,'EffecDtReviewed'')]//img")
	WebElement chkbxMbrCompositeMbrEffDate;

	////

	// New Object
	@FindBy(xpath = "//*[contains(text(),'This field can')]")
	WebElement alternateIDText;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='ProductType']/parent::div//span")
	WebElement labelMbrCompositeMbrProductType;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='COBIndicator']/parent::div//span")
	WebElement labelMbrCompositeMbrCOBIndicator;

	@FindBy(xpath = "//img[contains(@data-hover,'COB')]")
	WebElement imgMbrCompositeMbrCOBIndicator;

	@FindBy(xpath = "//img[contains(@data-hover,'Medicare indicator')]")
	WebElement imgMbrCompositeMbrMedicareindicator;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='MedicareIndicator']/parent::div//span")
	WebElement labelMbrCompositeMbrMedicareIndicator;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='PaidToDate']/parent::div//span")
	WebElement labelMbrCompositeMbrPaidToDate;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='ExchangeInd']/parent::div//span")
	WebElement labelMbrCompositeMbrExchangeInd;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='HomePostalCode']//parent::div//span")
	WebElement labelMbrCompositeMbrZipcode;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='EndDate']/parent::div//div")
	WebElement labelMbrCompositeterminationEndDate;

	// LINKS
	// _______________________________________________________________________________

	@FindBy(xpath = "//span[text()='Address and Contact Information']")
	WebElement labelMbrCompositeMbrAddCnctInfoLink;

	@FindBy(xpath = "//span[text()='Primary Care Physician Information']")
	WebElement labelMbrCompositeMbrPriCarePhyInfoLink;

	@FindBy(xpath = "//span[text()='Primary Medical Group Information']")
	WebElement labelMbrCompositeMbrPrimaryMedicalGroupLink;

	@FindBy(xpath = "//span[text()='Independent Physician Association Information']")
	WebElement labelMbrCompositeMbrIndependantPhyAssoGroupLink;

	// ADDRESS AND CONTACT INFORMATION
	// ________________________________________________

	// Address Table
	@FindBy(xpath = "//div[@node_name='AddressInfo']//table[@class='gridTable ']")
	WebElement tableMbrCompositeMbrAddress;

	// Phone Table
	@FindBy(xpath = "//div[@node_name='PhoneInfo']//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrPhone;

	// Email table
	@FindBy(xpath = "//div[@node_name='EmailInfo']//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrEmail;

	////////////////////////////////////////////////

	// PRIMARY CARE PHYSICIAN INFORMATION______________________________________

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='ProviderName']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPName;

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='ProviderNumber']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPID;

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='PrimarySpeciality']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPPrimarySpeciality;

	// div[@node_name='HCPCPInformation']//label[@for='PhoneNumber']/parent::div//dash
	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='PhoneNumber']/parent::div//div")
	WebElement labelMbrCompositeMbrPCPPhone;

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='EffectiveDate']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPEffDate;

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='PCPDateUpdated']/parent::div//span")
	WebElement labelMbrCompositeMbrPCPUpdateDate;

	@FindBy(xpath = "//div[@node_name='PracticeAddresses']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrPCPPracticeAddress;

	// INDEPENDENT PHYSICIAN ASSOCIATION INFORMATION

	// PRIMARY MEDICAL GROUP INFORMATON

	@FindBy(xpath = "//div[@node_name='ProviderInformation']//label[@for='OrganizationName']/parent::div//span")
	WebElement labelMbrCompositeMbrPMGname;

	@FindBy(xpath = "//div[@node_name='ProviderInformation']//label[@for='ProviderNumber']/parent::div//span")
	WebElement labelMbrCompositeMbrPMGnumber;

	@FindBy(xpath = "//div[@node_name='ProviderInformation']//label[@for='PhoneNumber']/parent::div//div")
	WebElement labelMbrCompositeMbrPMGphone;

	@FindBy(xpath = "//div[@node_name='ProviderInformation']//label[@for='EffectiveDate']/parent::div//span")
	WebElement labelMbrCompositeMbrPMGeffdate;

	@FindBy(xpath = "//div[@node_name='ProviderInformation']//label[@for='PCPDateUpdated']/parent::div//span")
	WebElement labelMbrCompositeMbrPMGupdateddate;

	@FindBy(xpath = "//div[@node_name='PracticeAddresses']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeMbrPMGTable;

	@FindBy(xpath = "//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")
	WebElement benefitsandcost;
	@FindBy(xpath = "//div[@node_name='pyOverlayTemplate']//a[@title='Manage Claims'][@class='Add_task']")
	WebElement manageclaims;

	@FindBy(xpath = "//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")
	WebElement promisedactions;

	// ADD TASK button

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Add task(s)']")
	WebElement addtaskbutton;

	// Guided Dialog message

	@FindBy(id = "DialogContent")
	WebElement labelGuidedDialog;
	
	public boolean verifyGuidedDialogText() {
		String message = this.labelGuidedDialog.getText().toString();
		return utils.isvalueMatch_contain(message,
				"Handle with care. Use the HIPAA Verification & Disclosure Guide link if you need help understanding what you can tell");
	}

	// New CHECKBBOX BUTTONS ADDED----------------

		@FindBy(id = "MemberInfoReview")
		WebElement chkbxmemberandsubscriberinfodiscussed;
		
		@FindBy(id = "MemberSectionInfoReview")
		WebElement chkbxmemberinfodiscussed;
		
		@FindBy(id = "SubscriberInfoReview")
		WebElement chkbxsubscriberinfodiscussed;
		
		@FindBy(id = "MemberAddressInfoReview")
		WebElement chkbxmemberaddressinfodiscussed;
		
		@FindBy(id = "MemberPhoneNumberInfoReview")
		WebElement chkbxmemberphonenumberinfodiscussed;
		
		@FindBy(id = "MemberEmailInfoReview")
		WebElement chkbxmemberemailinfodiscussed;
		
		@FindBy(id = "SubscriberAddressInfoReview")
		WebElement chkbxsubscriberaddressinfodiscussed;
		
		@FindBy(id = "SubscriberPhoneNumberInfoReview")
		WebElement chkbxsubscriberphonenumberinfodiscussed;
		
		@FindBy(id = "GeneralInfoReview")
		WebElement chkbxgeneralinfodiscussed;
		
		@FindBy(id = "PCPInfoReview")
		WebElement chkbxpcpinfodiscussed;
					

		@FindBy(id = "ContractInfoReview")
		WebElement chkbxcontractinfodiscussed;

		@FindBy(id = "GroupDetailsInfoReview")
		WebElement chkbxgroupinfodiscussed;

		@FindBy(id = "InteractionsInfoReview")
		WebElement chkbxInteractioninfodiscussed;

	// Checkbox common methods

	public boolean clickMemberAndSubscriberInformationDiscussedWithContactCheckbox() {
		
		if (utils.clickAnelemnt(this.chkbxmemberandsubscriberinfodiscussed, "Member Composite", "Member and Subcriber Info Checkbox"))
			return true;
		return false;
	}
	
	public boolean clickMemberInformationDiscussedWithContactCheckbox() {
		utils.waitforpageload();
		if (utils.clickAnelemnt(this.chkbxmemberinfodiscussed, "Member Composite", "Member Info Checkbox"))
			return true;
		return false;
	}
	
	public boolean clickSubscriberInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxsubscriberinfodiscussed, "Member Composite", "Subscriber Info Checkbox"))
			return true;
		return false;
	}
	
	public boolean clickMemberAddressInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxmemberaddressinfodiscussed, "Member Composite", "Member Address Info Checkbox"))
			return true;
		return false;
	}
	
	public boolean clickMemberPhoneNumberInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxmemberphonenumberinfodiscussed, "Member Composite", "Member Phone Number Info Checkbox"))
			return true;
		return false;
	}
	
	public boolean clickMemberEmailInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxmemberemailinfodiscussed, "Member Composite", "Member Email Info Checkbox"))
			return true;
		return false;
	}
	
	public boolean clickSubscriberAddressInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxsubscriberaddressinfodiscussed, "Member Composite", "Subscriber Address Info Checkbox"))
			return true;
		return false;
	}
	
	public boolean clickSubscriberPhoneNumberInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxsubscriberphonenumberinfodiscussed, "Member Composite", "Subscriber Phone Number Info Checkbox"))
			return true;
		return false;
	}
		
	public boolean clickGeneralInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxgeneralinfodiscussed, "Member Composite", "General Info Checkbox"))
			return true;
		return false;
	}
	
	public boolean clickPCPInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxpcpinfodiscussed, "Member Composite", "PCP Info Checkbox"))
			return true;
		return false;
	}
	
	
	/* public boolean clickchkbxmemberinfodiscussed() {
	if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
			if (utils.clickAnelemnt(this.chkbxmemberinfodiscussed, "Member Composite", "Checkbox"))
				return true;
	return false;
}

*/
	
	// MEMBER TAB TABLES ____________________________________---------------------

	public boolean checkDataInMbrGenInfoTable(String columnName, String firstName) {
		if (utils.isProxyWebelement(this.tableMbrCompositeMembertable)) {
			utils.clickAnelemnt(this.labelMbrCompositeMemberID, "Member Composite ", " Contract address link ");
		} else {
			System.out.println("Contract Address is already clicked");
		}

		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMembertable, columnName);
		for (int i = 0; i < firstnameColumn.size(); i++) {
			System.out.println("Content text is : " + firstnameColumn.get(i));
			if (firstnameColumn.get(i).equals(firstName.toLowerCase())) {
				String name = firstnameColumn.get(i);
				Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//div//span[text()='" + name + "']"));
				return true;
			}
		}

		return false;
	}

	public boolean switchToParticularMember(String columnName, String firstName) {
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMembertable, columnName);
		for (int i = 0; i < firstnameColumn.size(); i++) {
			System.out.println("Content text is : " + firstnameColumn.get(i));
			if (firstnameColumn.get(i).toLowerCase().equals(firstName.toLowerCase())) {
				System.out.println("Actual =" + firstnameColumn.get(i) + "Expected " + firstName);
				String name = firstnameColumn.get(i);
				// Driver.pgDriver.findElement(By.xpath("//*[@pl_prop='D_MembersOnContract.pxResults']//th")).click();
				// Driver.pgDriver.findElement(By.xpath("//*[@node_name='MemberList']/parent::div//table[@id='gridLayoutTable']//span[contains(text(),'TESTSTS')]")).click();
				String xpath = "//*[@pl_prop='D_MembersOnContract.pxResults']//span[contains(text(),'" + name + "')]";
				Driver.pgDriver.findElement(By.xpath(xpath)).click();
				waitforpageload();
				return true;
			}
		}
		return false;
	}

	public boolean SelectDatatoSwitchcontract(String columnName, String firstName) {
		System.out.println("Firtname in excel " + firstName);
		if (utils.isProxyWebelement(this.tableMbrCompositeMembertable)) {
			utils.clickAnelemnt(this.labelMbrCompositeMemberID, "Member Composite ", " Contract address link ");
		} else {
			System.out.println("Contract Address is already clicked");
		}
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeContracttable, columnName);
		for (int i = 0; i < firstnameColumn.size(); i++) {
			System.out.println("Content text is : " + firstnameColumn.get(i));
			if (firstnameColumn.get(i).toLowerCase().contains(firstName.toLowerCase())) {
				System.out.println("Actual =" + firstnameColumn.get(i) + "Expected " + firstName);
				String name = firstnameColumn.get(i);

				Driver.pgDriver
						.findElement(By.xpath(
								"//*[@node_name='MemberContractsList']/parent::div//table[@id='gridLayoutTable']//th"))
						.click();
				// Driver.pgDriver.findElement(By.xpath("//*[@node_name='MemberList']/parent::div//table[@id='gridLayoutTable']//span[contains(text(),'TESTSTS')]")).click();
				String xpath = "//*[@node_name='MemberContractsList']/parent::div//table[@id='gridLayoutTable']//span[contains(text(),'"
						+ name + "')]";

				System.out.println(xpath);

				Driver.pgDriver.findElement(By.xpath(xpath)).click();
				return true;
			}
		}
		return false;
	}

	public boolean Mbrcompositeverifymemberdetails(String[] args) {
		VerifyMember vr = new VerifyMember();
		if (vr.ValidateDetailsPresent()) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].contains("name")) {
					String s1 = args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s = new String[] { s1 };
					// s = s.substring(0, s.indexOf(";"));
					if (vr.clickchkbxVerificationMembernameverify(s)) {
						if (i == args.length - 1) {
							if (utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					} else
						break;
				} else if (args[i].contains("id")) {
					String s1 = args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s = new String[] { s1 };

					if (vr.clickchkbxVerificationMemberidverify(s)) {
						if (i == args.length - 1) {
							if (utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					} else
						break;
				} else if (args[i].contains("dob")) {
					String s1 = args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s = new String[] { s1 };
					if (vr.clickchkbxVerificationMemberDOB(s)) {
						if (i == args.length - 1) {
							if (utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					} else
						break;
				}

				else if (args[i].contains("address")) {
					String s1 = args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s = new String[] { s1 };
					if (vr.clickchkbxVerificationMemberAddress(s)) {
						if (i == args.length - 1) {
							if (utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					} else
						break;
				} else if (args[i].contains("phone")) {
					String s1 = args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s = new String[] { s1 };
					if (vr.clickchkbxVerificationMemberphone(s)) {
						if (i == args.length - 1) {
							if (utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					} else
						break;
				}

				else if (args[i].contains("pcp")) {
					String s1 = args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s = new String[] { s1 };
					if (vr.clickchkbxVerificationMemberpcp(s)) {
						if (i == args.length - 1) {
							if (utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					} else
						break;
				}

				else if (args[i].contains("ssn")) {
					String s1 = args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s = new String[] { s1 };
					if (vr.clickchkbxVerificationMemberSSN(s)) {
						if (i == args.length - 1) {
							if (utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
						}
						continue;
					} else
						break;
				} else {
					err.logcommonMethodError("MemberVerify", "verifymemberdetails");
					System.out.println(" Sorry, there is no attribute present as " + args[i]);
				}

			}
			err.logcommonMethodError("MemberVerify", "verifymemberdetails");
			System.out.println("Not to able to complete verification");
			return false;
		}
		err.logcommonMethodError("Verify Member", "verifymemberdetails");
		return false;

	}

	public boolean CheckDataInMbrAddressTable(String[] args) {
		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
			if (utils.isProxyWebelement(this.tableMbrCompositeMbrAddress)) {
				utils.clickAnelemnt(this.labelMbrCompositeMbrAddCnctInfoLink, "Member Composite ",
						" Contract address link ");
			} else {
				System.out.println("Contract Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrAddress, columnName);
			for (int i = 0; i < firstnameColumn.size(); i++) {
				System.out.println("Content text is : " + firstnameColumn.get(i).toLowerCase());
				System.out.println("Content comaprison value text is : " + value.toLowerCase());
				if (firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase())) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public boolean CheckDataInMbrPhoneTable(String[] args) {
		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
			if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
				if (utils.isProxyWebelement(this.tableMbrCompositeMbrPhone)) {
					utils.clickAnelemnt(this.labelMbrCompositeMbrAddCnctInfoLink, "Member Composite ",
							" Contract address link ");
				} else {
					System.out.println("Contract Address is already clicked");
				}
				ArrayList<String> firstnameColumn = new ArrayList<String>();
				firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPhone, columnName);
				for (int i = 0; i < firstnameColumn.size(); i++) {
					System.out.println("Content text is : " + firstnameColumn.get(i));
					if (firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase())) {
						return true;
					}
				}
				return false;
			}
			return false;
		}
		return false;
	}

	public boolean CheckDataInMbrPhoneTableNew(String[] args) {
		boolean isFound = false;
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
			if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
				if (utils.isProxyWebelement(this.tableMbrCompositeMbrPhone)) {
					utils.clickAnelemnt(this.labelMbrCompositeMbrAddCnctInfoLink, "Member Composite ",
							" Contract address link ");
				} else {
					System.out.println("Contract Address is already clicked");
				}
				System.out.println(args[0]);
				String completeTable[] = args[0].split("/");
				for (int i = 0; i < completeTable.length; i++) {

					String columnName = completeTable[i].substring(0, completeTable[i].indexOf(":"));
					String value = completeTable[i].substring(completeTable[i].indexOf(":") + 1);
					ArrayList<String> firstnameColumn = new ArrayList<String>();
					firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPhone, columnName);
					for (int col = 0; col < firstnameColumn.size(); col++) {
						System.out.println("Content text is : " + firstnameColumn.get(col));
						if (firstnameColumn.get(col).toLowerCase().contains(value.toLowerCase())) {
							isFound = true;
						}
					}

					if (isFound) {
						blogger.loginfo("PASS:Values are matched under column Name:" + columnName);
					} else {

						blogger.loginfo("FAIL:Values are not matched under column Name:" + columnName);
						return false;
					}
				}
				if (isFound) {
					blogger.loginfo("PASS:All the values are correctly reflecting under Phone Tab in Member Tab");
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	public boolean CheckDataInMbrEmailTable(String[] args) {
		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
			if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
				if (utils.isProxyWebelement(this.tableMbrCompositeMbrEmail)) {
					utils.clickAnelemnt(this.labelMbrCompositeMbrAddCnctInfoLink, "Member Composite ",
							" Contract address link ");
				} else {
					System.out.println("Contract Address is already clicked");
				}
				ArrayList<String> firstnameColumn = new ArrayList<String>();
				firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrEmail, columnName);
				for (int i = 0; i < firstnameColumn.size(); i++) {
					System.out.println("Content text is : " + firstnameColumn.get(i).toLowerCase());
					System.out.println("Content comaprison value text is : " + value.toLowerCase());
					if (firstnameColumn.get(i).equalsIgnoreCase(value)) {
						return true;
					}
				}
				return false;
			}
			return false;
		}
		return false;
	}

	public boolean CheckDataInMbrPCPTable(String[] args) {
		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
			if (utils.isProxyWebelement(this.tableMbrCompositeMbrPCPPracticeAddress)) {
				utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink, "Member Composite ",
						" Contract address link ");
			} else {
				System.out.println("Contract Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPCPPracticeAddress,
					columnName);
			for (int i = 0; i < firstnameColumn.size(); i++) {
				System.out.println("Content text is : " + firstnameColumn.get(i));
				if (firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase())) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public boolean CheckDataInMbrMedicalGroupInfotable(String[] args) {
		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
			if (utils.isProxyWebelement(this.tableMbrCompositeMbrPMGTable)) {
				utils.clickAnelemnt(this.labelMbrCompositeMbrPrimaryMedicalGroupLink, "Member Composite ",
						" Contract address link ");
			} else {
				System.out.println("Contract Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPMGTable, columnName);
			for (int i = 0; i < firstnameColumn.size(); i++) {
				System.out.println("Content text is : " + firstnameColumn.get(i).toLowerCase());
				System.out.println("Content comaprison value text is : " + value.toLowerCase());
				if (firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase())) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public boolean CheckDataInMbrIndependantPhysicianAssociationInfotable(String[] args) {
		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ");
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member composite ", "Member Tab ")) {
			if (utils.isProxyWebelement(this.tableMbrCompositeMbrPMGTable)) {
				utils.clickAnelemnt(this.labelMbrCompositeMbrIndependantPhyAssoGroupLink, "Member Composite ",
						" Contract address link ");
			} else {
				System.out.println("Contract Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeMbrPMGTable, columnName);
			for (int i = 0; i < firstnameColumn.size(); i++) {
				System.out.println("Content text is : " + firstnameColumn.get(i).toLowerCase());
				System.out.println("Content comaprison value text is : " + value.toLowerCase());
				if (firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase())) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	// MEMBER INFORMATION

	@FindBy(xpath = "//div[@title='Hide Member Information']")
	WebElement memberExpandIcon;

	@FindBy(xpath = "//div[@title='Hide Subscriber Information']")
	WebElement subscriberExpandIcon;

	public boolean validateMemberInformation(String[] mgeninfoDetails) throws Exception {
		boolean returnvar;
		returnvar = true;
		if (!utils.isProxyWebelement(memberExpandIcon))
			if (!utils.isProxyWebelement(subscriberExpandIcon)) {
				System.out.println("Entered into method");
				String keyvaluepair = "";
				for (String iterator : mgeninfoDetails) {
					if (!returnvar) {
						err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
								+ " Either Your input is wrong or the value found on application is incorrect");
						return false;
					}
					keyvaluepair = iterator;
					String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
					String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
					System.out.println("key " + key + "value  " + value);
					if (key.toLowerCase().contains("membername")) {
						returnvar = this.linkMbrCompositeMemberName.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("memberid")) {
						returnvar = this.labelMbrCompositeMemberID.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("alternate")) {
						utils.waitForElementToBeClickabale(imagealternateid);
						Actions action = new Actions(Driver.pgDriver);
						action.moveToElement(imagealternateid).build().perform();
						String hovertext = this.imagealternateid.getAttribute("aria-label").toString().toLowerCase();
						System.out.println(hovertext);
						if (hovertext
								.contains("this field can be employee id, ssn, or any other identifier for the member"))
							System.out.println("hover text present");
						returnvar = this.labelMbrCompositeMbrEmployeeID.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("relationship")) {
						returnvar = this.labelMbrCompositeMbrRelationship.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("dateofbirth")) {
						returnvar = this.labelMbrCompositeMbrDOB.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("age")) {
						returnvar = this.labelMbrCompositeMbrAge.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("effectivedate")) {
						returnvar = this.labelMbrCompositeMbrEffDate.getText().toLowerCase().contains(value);
						returnvar = utils.validateValueinelement(this.labelMbrCompositeMbrEffDate, value);
						continue;
					} else if (key.toLowerCase().contains("enddate")) {
						returnvar = this.labelMbrCompositeMbrEndDate.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("producttype")) {
						returnvar = this.labelMbrCompositeMbrProductType.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("cobindicator")) {
						returnvar = this.labelMbrCompositeMbrCOBIndicator.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("zipcode")) {
						returnvar = this.labelMbrCompositeMbrZipcode.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("paidtodate")) {
						returnvar = this.labelMbrCompositeMbrPaidToDate.getText().toLowerCase().contains(value);
						continue;
					}

					else if (key.toLowerCase().contains("businessunit")) {
						returnvar = this.labelMbrCompositeMbrMBUName.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("exchange")) {
						returnvar = this.labelMbrCompositeMbrExchangeInd.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("terminationdate")) {
						returnvar = labelMbrCompositeterminationEndDate.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("legacyhcid")) {
						returnvar = this.labelMbrCompositeMbrLegacyId.getText().toLowerCase().contains(value);
						continue;
					} else if (key.toLowerCase().contains("alternateid")) {
						returnvar = this.labelMbrCompositeMbrAlternateId.getText().toLowerCase().contains(value);
						continue;
					} else
						err.logcommonMethodError("Member Composite",
								"Check your key in yourkeypair. Make sure you are following the same pattern for input");
					return false;

				}
			}
		if (returnvar) {
			System.out.println("Member genral info checked Successfully");
			return true;
		} else {
			int tot_i = mgeninfoDetails.length;
			err.logcommonMethodError("Member Composite",
					"the value " + mgeninfoDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}
	}

	// SUBSCRIBER INFO

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='pyFullName']//parent::div//span")
	WebElement subscriberName;

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='DateOfBirth']//parent::div//span")
	WebElement subscriberDOB;

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='Age']//parent::div//span")
	WebElement subscriberAge;

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='Gender']//parent::div//span[@data-ctl='Text']")
	WebElement subscriberGender;

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='SubscriberEffecDate']/parent::div//span")
	WebElement subscriberEffectiveDate;

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='SubscriberEndDate']//parent::div")
	WebElement subscriberTerminationDate;

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='HireDate']//parent::div//span")
	WebElement subscriberHireDate;

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='GroupTypeDescription']//parent::div//span")
	WebElement subscriberEmployeeStatus;

	@FindBy(xpath = "//div[@node_name='SubscriberDetailInformation']//label[@for='SubscriberProductType']//parent::div//span")
	WebElement subscriberProductType;

	public boolean verifySubscriberInformation(String[] mgeninfoDetails) throws Exception {
		System.out.println("Entered into method");

		boolean returnvar;
		returnvar = true;
		String keyvaluepair = "";
		for (String iterator : mgeninfoDetails) {
			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			if (key.toLowerCase().contains("subscribername")) {
				returnvar = this.subscriberName.getText().toLowerCase().contains(value);
				continue;
			} else if (key.toLowerCase().contains("dateofbirth")) {
				returnvar = this.subscriberDOB.getText().toLowerCase().contains(value);
				continue;

			} else if (key.toLowerCase().contains("age")) {
				returnvar = this.subscriberAge.getText().toLowerCase().contains(value);
				continue;
			} else if (key.toLowerCase().contains("effectivedate")) {
				returnvar = this.subscriberEffectiveDate.getText().toLowerCase().contains(value);
				continue;

			} else if (key.toLowerCase().contains("gender")) {
				returnvar = this.subscriberGender.getText().toLowerCase().contains(value);
				continue;
			} else if (key.toLowerCase().contains("terminationdate")) {
				returnvar = this.subscriberTerminationDate.getText().toLowerCase().contains(value);
				returnvar = utils.validateValueinelement(this.subscriberTerminationDate, value);
				continue;
			} else if (key.toLowerCase().contains("hiredate")) {
				returnvar = this.subscriberHireDate.getText().toLowerCase().contains(value);
				continue;

			} else if (key.toLowerCase().contains("employeestatus")) {
				returnvar = this.subscriberEmployeeStatus.getText().toLowerCase().contains(value);
				continue;
			} else if (key.toLowerCase().contains("producttype")) {
				returnvar = this.subscriberProductType.getText().toLowerCase().contains(value);
				continue;
			} else
				err.logcommonMethodError("Member Composite",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;

		}
		if (returnvar) {
			System.out.println("Subscriber info checked Successfully");
			return true;
		} else {
			int tot_i = mgeninfoDetails.length;
			err.logcommonMethodError("Member Composite",
					"the value " + mgeninfoDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}
	}

	// GENERAL INFORMATION

	@FindBy(xpath = "//div[@title='Disclose General Information']")
	WebElement generalInfoExpandIcon;

	@FindBy(xpath = "//span[text()='General Information']")
	WebElement generalInfoTab;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='COBIndicator']/..//img")
	WebElement cobIndicatorhoverText;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='MedicareIndicator']/..//img")
	WebElement medicareIndicatorhoverText;

	public boolean verifyCOBIndicatorHoverText(String hoverMessage[]) {
		if (mouseHover(cobIndicatorhoverText, "Member Composite", "Member Tab")) {
			String hovertext = cobIndicatorhoverText.getAttribute("aria-label").replace(",","").toString();
			if (utils.isvalueMatch_contain(hovertext, hoverMessage[0])) {
				return true;
			} else {
				blogger.loginfo("Failed to validate the hover text message");
				return false;
			}
		} else {
			blogger.loginfo("Failed to validate the hover text message");
			return false;
		}

	}

	public boolean verifyMedicareIndicatorHoverText(String hoverMessage[]) {
		if (mouseHover(medicareIndicatorhoverText, "Member Composite", "Member Tab")) {
			String hovertext = medicareIndicatorhoverText.getAttribute("aria-label").toString().replace(",","");
					if (utils.isvalueMatch_contain(hovertext, hoverMessage[0])) {
				return true;
			} else {
				blogger.loginfo("Failed to validate the hover text message");
				return false;
			}
		} else {
			blogger.loginfo("Failed to validate the hover text message");
			return false;
		}

	}

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='Other Insurance']/..//div")
	WebElement generalInfoOtherInsurance;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='WrittenLanguage']/..//div")
	WebElement generalInfoWrittenLang;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='MedicareIndicator']/..//div")
	WebElement generalInfoMedicareIndicator;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='COBIndicator']/..//div")
	WebElement generalInfoCOBIndicator;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='SpokenLanguage']/..//div")
	WebElement generalInfoSpokenLang;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='Race']/..//div")
	WebElement generalInfoRace;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='Ethnicity']/..//div")
	WebElement generalInfoEthinicity;

	@FindBy(xpath = "//div[@aria-label='Hide General Information']/parent::div/..//label[@for='ExemptTypeCode']/..//div")
	WebElement generalInfoReligiousIndicator;

	public boolean clickGeneralInformation() {
		if (!utils.isProxyWebelement(generalInfoExpandIcon)) {
			blogger.loginfo("PASS:General Information is collapsed by default");
			if (utils.clickAnelemnt(generalInfoTab, "Member Composite", "Member Tab")) {
				return true;
			} else {
				blogger.loginfo("Failed to click General Information");
				return false;
			}
		} else {
			blogger.loginfo("Failed to click General Information");
			return false;
		}
	}

	public boolean validateGeneralInformation(String[] mgeninfoDetails) throws Exception {
		boolean returnvar;
		returnvar = true;
		System.out.println("Entered into method");
		utils.scrolltomiddle();
		String keyvaluepair = "";
		for (String iterator : mgeninfoDetails) {
			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			if (key.toLowerCase().contains("otherinsurance")) {
				returnvar = this.generalInfoOtherInsurance.getText().toLowerCase().contains(value);
				continue;
			}

			else if (key.toLowerCase().contains("cobindicator")) {
				returnvar = utils.validateLabel(generalInfoCOBIndicator, value);
				// returnvar =
				// this.labelMbrCompositeMbrWrittenLanguage.getText().toLowerCase().contains(value);
				continue;
			}

			else if (key.toLowerCase().contains("medicareindicator")) {
				returnvar = utils.validateLabel(generalInfoMedicareIndicator, value);
				// returnvar =
				// this.labelMbrCompositeMbrWrittenLanguage.getText().toLowerCase().contains(value);
				continue;
			} else if (key.toLowerCase().contains("written")) {
				returnvar = utils.validateLabel(generalInfoWrittenLang, value);
				// returnvar =
				// this.labelMbrCompositeMbrWrittenLanguage.getText().toLowerCase().contains(value);
				continue;
			} else if (key.toLowerCase().contains("spoken")) {
				returnvar = utils.validateLabel(generalInfoSpokenLang, value);
				// returnvar =
				// this.labelMbrCompositeMbrWrittenLanguage.getText().toLowerCase().contains(value);
				continue;
			} else if (key.toLowerCase().contains("race")) {
				returnvar = utils.validateLabel(generalInfoRace, value);
				continue;
			} else if (key.toLowerCase().contains("ethnicity")) {
				returnvar = utils.validateLabel(generalInfoEthinicity, value);
				continue;
			} else if (key.toLowerCase().contains("religiousindicator")) {
				returnvar = utils.validateLabel(generalInfoReligiousIndicator, value);
				continue;

			} else
				err.logcommonMethodError("Member Composite",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;

		}

		if (returnvar) {
			System.out.println("Member genral info checked Successfully");
			return true;
		} else {
			int tot_i = mgeninfoDetails.length;
			err.logcommonMethodError("Member Composite",
					"the value " + mgeninfoDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}

	}
	// PRIMARY CARE PHYSICIAN INFORMATION

	@FindBy(xpath = "//div[@title='Disclose Primary Care Physician Information']")
	WebElement primaryCarePhysicianExpandIcon;

	@FindBy(xpath = "//span[text()='Primary Care Physician Information']")
	WebElement primaryCareInfoTab;

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//table[@pl_prop='D_PCPDetails.pxResults']")
	WebElement primaryCareInfoTableVlaues;

	public boolean verifyPrimaryCarePhysicianInfoDetails(String args[]) throws Exception {
		if (!utils.isProxyWebelement(primaryCarePhysicianExpandIcon)) {
			blogger.loginfo("PASS:Primary Care Physician Information is collapsed by default");
			if (utils.clickAnelemnt(primaryCareInfoTab, "Member Composite", "Member Tab"))
				if(validateLabelTextsInPCPInformation(args))
					return true;
			return false;
		}
		return false;

	}

	public boolean validatePCPTableInformation(String args[]) {
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", primaryCareInfoTableVlaues);
		if (utils.validatetablerowbasedonvalues(primaryCareInfoTableVlaues, args))
			return true;
		return false;
	}


	
	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='PCPIndicator']//parent::div//div")
	WebElement primaryCarepcprequired;

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='PCPSelectionRequiredDesc']//parent::div//div")
	WebElement primaryCarepcpselectionrequired;

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='PCPAutopickDeadlineDesc']//parent::div//div")
	WebElement primaryCarepcpautoselection;

	@FindBy(xpath = "//div[@node_name='HCPCPInformation']//label[@for='PCPPrintCardIndDesc']//parent::div//div")
	WebElement primaryCarepcpidcard;

	public boolean validateLabelTextsInPCPInformation(String[] pcpDetails) {
		boolean returnvar;
		returnvar = true;
		for (String iterator : pcpDetails) {
			String keyvaluepair = iterator;
			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if (key.toLowerCase().contains("pcprequired")) {
				returnvar = utils.validateLabel(primaryCarepcprequired, value);
				continue;
			} else if (key.toLowerCase().contains("pcpselectionrequired")) {
				returnvar = utils.validateLabel(primaryCarepcpselectionrequired, value);
				continue;
			}

			else if (key.toLowerCase().contains("pcpautoselection")) {
				returnvar = utils.validateLabel(primaryCarepcpautoselection, value);
				continue;
			} else if (key.toLowerCase().contains("pcpidcard")) {
				returnvar = utils.validateLabel(primaryCarepcpidcard, value);
				continue;
			}

			else
				err.logcommonMethodError("Member Composite",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if (returnvar) {
			System.out.println("Physician genral info checked Successfully");
			return true;
		} else {
			int tot_i = pcpDetails.length;
			err.logcommonMethodError("Member Composite",
					"the value " + pcpDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}
	}

	public boolean VerifyMedicalGroupInfo(String[] pcpDetails) {
		boolean returnvar;
		returnvar = true;
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab")) {
			if (utils.isProxyWebelement(this.labelMbrCompositeMbrPMGname)) {
				utils.clickAnelemnt(this.labelMbrCompositeMbrPrimaryMedicalGroupLink, "Member Composite ",
						" Contract address link ");
			} else {
				System.out.println("Contract Address is already clicked");
			}

			for (String iterator : pcpDetails) {
				String keyvaluepair = iterator;
				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
				if (key.toLowerCase().contains("name")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGname, value);

					continue;
				} else if (key.toLowerCase().contains("id")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGnumber, value);

					continue;
				}

				else if (key.toLowerCase().contains("phone")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGphone, value);

					continue;
				} else if (key.toLowerCase().contains("eff")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGeffdate, value);
					continue;
				} else if (key.toLowerCase().contains("update")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGupdateddate, value);
					continue;
				} else
					err.logcommonMethodError("Member Composite",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		} else
			err.logError("Member Composite", "Member tab ");

		if (returnvar) {
			System.out.println("medical group genral info checked Successfully");
			return true;
		} else {
			int tot_i = pcpDetails.length;
			err.logcommonMethodError("Member Composite",
					"the value " + pcpDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}

	}

	public boolean VerifyIndependentPhysicianAssociationInfo(String[] pcpDetails) {
		boolean returnvar;
		returnvar = true;
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab")) {
			if (utils.isProxyWebelement(this.labelMbrCompositeMbrPMGname)) {
				utils.clickAnelemnt(this.labelMbrCompositeMbrPrimaryMedicalGroupLink, "Member Composite ",
						" Contract address link ");
			} else {
				System.out.println("Contract Address is already clicked");
			}
			for (String iterator : pcpDetails) {
				String keyvaluepair = iterator;
				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
				if (key.toLowerCase().contains("name")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGname, value);
					continue;
				} else if (key.toLowerCase().contains("id")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGnumber, value);
					continue;
				}

				else if (key.toLowerCase().contains("phone")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGphone, value);
					continue;
				} else if (key.toLowerCase().contains("eff")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGeffdate, value);
					continue;
				} else if (key.toLowerCase().contains("update")) {
					returnvar = utils.validateLabel(labelMbrCompositeMbrPMGupdateddate, value);
					continue;
				}

				else
					err.logcommonMethodError("Member Composite",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		} else
			err.logError("Member Composite", "Member tab ");
		if (returnvar) {
			System.out.println("medical group genral info checked Successfully");
			return true;
		} else {
			int tot_i = pcpDetails.length;
			err.logcommonMethodError("Member Composite",
					"the value " + pcpDetails[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}

	}

	public boolean selectDependent(String[] mName) {
		if (utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite ", "Member name link "))
			if (utils.clickAnelemnt(this.linkMbrCompositeMemberName, "Member Composite ", "Member name link "))
				if (this.switchToParticularMember("First Name", mName[0]))
					return true;
		return false;
	}

	public boolean clickwrapUp() {
		waitforpageload();
		return utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");
	}

	/**
	 * Table with the values of the Search for Service Request for Contracts
	 */

	@FindBy(xpath = "//*[contains(@pl_prop,'ForContractB')]")
	WebElement tableMbrCompositesearchforServiceRequestContracts;
	@FindBy(xpath = "//span[contains(text(),'Search for Service Requests for Contract')]")
	WebElement lnkMbrCompositeIntSearchForServiceRequest;

	/**
	 * Table with the values of the Search for Service Request for Contracts
	 * 
	 * @return
	 * @throws ParseException
	 */
	public boolean checkSearchForServiceRequestsForContractsTable(String sMethod) throws ParseException {
		// Checking if the table is present or not and validating if it is already
		// openened
		if (utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts)) {
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest, "Member Composite ",
					" Search for Service Request for Contract");

		} else {
			System.out.println("Open Service Request link is already clicked\n\n");
		}
		// Checking if dates are equal

		// array list top storwe all the values and the dates in the Table
		ArrayList<String> Dates = new ArrayList<String>();
		// wil save the values in an array list
		Dates = utils.getcolumnStringFromTableByName(this.tableMbrCompositesearchforServiceRequestContracts,
				"Open Date");
		int i = 2;
		System.out.println(Dates.size());
		if (Dates.size() > 7) {
			System.out.println("There are more than 5 rows in Open Service request Table.");
			return false;
		}
		// Iterating the dates from the stored values
		for (String iterator : Dates) {
			DateFormat formatter;
			Date date1, date2;
			Date date3 = null;
			String date_1 = Dates.get(i);
			if (i + 1 == Dates.size()) {
				break;
			}
			String date_2 = Dates.get(i + 1);
			formatter = new SimpleDateFormat("MMMM dd,yyyy");

			date1 = formatter.parse(date_1);
			date2 = formatter.parse(date_2);
			if (date1.equals(date2)) {
				i++;
				continue;
			}
			if (sMethod == "Last 7 Days" || sMethod == "Last 30 Days" || sMethod == "Last 90 Days")
				if (date1.after(date2)) {
					i++;
					continue;
				} else
					System.out.println("THE DATES ARE NOT IN DESCENDING ORDER");
			return false;
		}
		blogger.logMessage("Member Composite ", " Open service request validation ");
		return true;
	}

	// Checking Dates for the Table

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Today']")
	WebElement btnServcRequestContractToday;

	public boolean clickServcRequestContractToday() {
		return (utils.clickAnelemnt(this.btnServcRequestContractToday, "MemberVerify", "Click Button today"));
	}

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Yesterday']")
	WebElement btnServcRequestContractYesterday;

	public boolean clickbtnServcRequestContractYesterday() {
		return (utils.clickAnelemnt(this.btnServcRequestContractYesterday, "MemberVerify", "Click Button Yesterday"));
	}

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Last 7 Days']")
	WebElement btnServcRequestContractLast7Days;

	public boolean clickbtnServcRequestContractLast7Days() {
		return (utils.clickAnelemnt(this.btnServcRequestContractLast7Days, "MemberVerify", "Click Button Last 7 Days"));
	}

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Last 90 Days']")
	WebElement btnServcRequestContractLast90Days;

	public boolean clickbtnServcRequestContractLast90Days() {
		return (utils.clickAnelemnt(this.btnServcRequestContractLast90Days, "MemberVerify",
				"Click Button Last 90 Days"));
	}

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Last 30 Days']")
	WebElement btnServcRequestContractLast30Days;

	public boolean clickbtnServcRequestContractLast30Days() {
		return (utils.clickAnelemnt(this.btnServcRequestContractLast30Days, "MemberVerify",
				"Click Button Last 30 Days"));
	}

	@FindBy(xpath = "//*[@id='SearchStartDate']")
	WebElement txtbxStartDate;

	public boolean settxtbxStartDate(String[] args) {

		// Checking the header
		if (utils.validateHeader(this.lnkMbrCompositeIntSearchForServiceRequest,
				"Search for Service Requests for Contract"))
			try {
				return utils.enterTextinAnelemnt(this.txtbxStartDate, args[0], "MemberVerify", "Nickname textbox");
			} catch (StaleElementReferenceException e) {
				return settxtbxStartDate(args);

			} catch (NoSuchElementException e) {
				return settxtbxStartDate(args);
			}
		return false;

	}

	// entering the value for the two dates in the pace
	@FindBy(xpath = "//*[@id='SearchEndDate']")
	WebElement txtbxEndtDate;

	public boolean settxtbxEndDate(String[] args) {
		try {
			return utils.enterTextinAnelemnt(this.txtbxEndtDate, args[0], "MemberVerify", "Nickname textbox");
		} catch (StaleElementReferenceException e) {
			return settxtbxStartDate(args);
		} catch (NoSuchElementException e) {
			return settxtbxStartDate(args);
		}

	}

	/**
	 * Ente4r the start and end date and the table will check if the dates are
	 * alligned in a proper Sequence
	 * 
	 * @param args : enter the start and Sto date
	 * @return
	 * @throws ParseException
	 */
	// *[@id='SearchEndDate']

	// Objects .....................

	@FindBy(xpath = "//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")
	private WebElement btnAddTAsk;
	@FindBy(xpath = "//*[contains(@id,'CPMTaskSearchInput')][1]")
	private WebElement SearchInput;

	@FindBy(xpath = "//*[@id='$PTaskMenuSearchResults$ppxResults$l1']")
	private WebElement lnkClickonLinkafterSettingValue;

	// Getters

	public WebElement getchkbxSEacrchInput() {
		return SearchInput;
	}

	public WebElement getbtnAddTAsk() {
		return btnAddTAsk;
	}

	public WebElement getlnkClickonLinkafterSettingValue() {
		return lnkClickonLinkafterSettingValue;
	}

	public boolean clickbtnAddTask() {
		return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");
	}

	// Set text
	public boolean setTxtFullContactName(String sFullName) {
		return utils.enterTextinAnelemnt(this.getchkbxSEacrchInput(), sFullName, "Member Composite",
				"Application took a long time to load");
	}

	// click on Selected link
	public boolean clicklnkClickonLinkafterSettingValue() throws InterruptedException {
		return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValue, "Member Composite",
				"Text Box Add Task Options");
	}

	/*
	 * Main methods
	 */
	public boolean navigateTOPromisedAction() throws InterruptedException {

		Thread.sleep(2000);
		waitforpageload();
		if (this.clickbtnAddTask())
			waitforpageload();
		wait = new WebDriverWait(Driver.pgDriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")));
		if (utils.clickAnelemnt(this.promisedactions, "Member Composite", "Promised actions under add task"))
			if (utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
				return true;
		return false;

	}

	public boolean navigateTOLimitedLiability() throws InterruptedException {
		Thread.sleep(2000);
		waitforpageload();
		if (this.clickbtnAddTask())
			if (setTxtFullContactName("Limited Liability"))
				if (this.clicklnkClickonLinkafterSettingValue())
					return true;
		return false;

	}

	public boolean navigateTOManageClaims() throws InterruptedException {
		Thread.sleep(2000);
		waitforpageload();
		if (this.clickbtnAddTask())
			wait = new WebDriverWait(Driver.pgDriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")));
		if (utils.clickAnelemnt(this.manageclaims, "Member Composite", "Manage Claims under add task"))
			if (utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
				return true;
		return false;

	}

	public boolean navigateTOAccumulators() throws InterruptedException {
		Thread.sleep(2000);
		waitforpageload();
		if (this.clickbtnAddTask())
			if (setTxtFullContactName("Accumulators"))
				if (this.clicklnkClickonLinkafterSettingValue())
					return true;
		return false;
	}

	public boolean waitforpageload() {
		try {
			Thread.sleep(3000);
			System.out.println("Checking for Loading Icon");
			wait = new WebDriverWait(Driver.getPgDriver(), 100);
			System.out.println("Checkingggg" + System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg" + System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg" + System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
		} catch (Exception e) {
			System.out.println("No loading icon. Continue " + e);

		}
		System.out.println("Came out");
		return true;
	}

	public boolean navigateTOBenefitsandCost() throws InterruptedException {
		if (this.clickbtnAddTask())
			if (setTxtFullContactName("Benefits and Cost"))
				if (this.clicklnkClickonLinkafterSettingValue())
					return true;
		return false;

	}

	public boolean navigateTOManageBilling() throws InterruptedException {
		Thread.sleep(2000);
		waitforpageload();
		if (this.clickbtnAddTask())
			if (setTxtFullContactName("Manage Enrollment"))
				if (this.clicklnkClickonLinkafterSettingValue())
					return true;
		return false;

	}

	public boolean navigateTOProvider() throws InterruptedException {
		Thread.sleep(2000);
		waitforpageload();
		if (this.clickbtnAddTask())
			if (setTxtFullContactName("Provider"))
				if (this.clicklnkClickonLinkafterSettingValue())
					return true;
		return false;

	}

	public boolean navigateTOSearchInventory() throws InterruptedException {
		Thread.sleep(2000);
		waitforpageload();
		if (this.clickbtnAddTask())
			if (setTxtFullContactName("Search Inventory"))
				if (this.clicklnkClickonLinkafterSettingValue())
					return true;
		return false;
	}

	/*
	 * @SCU CommonMethodWithoutArgument: validateAlternateIDhovertext Type: Textbox
	 * Description: To validate Alternate ID Hover Text in Member Section
	 */
	public boolean validateAlternateIDhovertext() throws InterruptedException {
		Actions builder = new Actions(Driver.pgDriver);
		wait = new WebDriverWait(Driver.pgDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[contains(text(),'Alternate ID')]//img[@src='webwb/pzDomTreeInspectorInfo.png']")));
		WebElement element = Driver.pgDriver.findElement(
				By.xpath("//label[contains(text(),'Alternate ID')]//img[@src='webwb/pzDomTreeInspectorInfo.png']"));
		builder.moveToElement(element).click().build().perform();
		utils.waitforpageload();
		return !utils.isProxyWebelement(alternateIDText);

	}

	@FindBy(xpath = "//span[@data-test-id='2017081815112305525693']")
	WebElement productTypeHoverText;

	@FindBy(xpath = "//div[@node_name='MemberDetailInformation']//label[@for='ProductType']/parent::div/parent::div/parent::div[@bsimplelayout='true']")
	WebElement productTypeImageIcon;

	/*
	 * Description: To validate Alternate ID Hover Text in Member Section
	 */
	
	
	 public boolean verifyMemberProductTypeHoverText(String hoverMessage[]) throws InterruptedException {
		if (mouseHover(productTypeImageIcon, "Member Composite", "Member Tab")) {
			String hovertext = productTypeHoverText.getText();
			if (utils.isvalueMatch_contain(hovertext, hoverMessage[0])) {
				return true;
			} else {
				blogger.loginfo("Failed to validate the hover text message");
				return false;
			}
		} else {
			blogger.loginfo("Failed to validate the hover text message");
			return false;
		}

	}

		/*
	 * Description: To validate Alternate ID Hover Text in Member Section
	 */
	public boolean verifyAlternateIDHoverText(String hoverMessage[]) throws InterruptedException {
		if (mouseHover(imagealternateid, "Member Composite", "Member Tab")) {
			String hovertext = this.imagealternateid.getAttribute("aria-label").toLowerCase().replace(",", "");
			if (utils.isvalueMatch_contain(hovertext, hoverMessage[0])) {
				return true;
			} else {
				blogger.loginfo("Failed to validate the hover text message");
				return false;
			}
		} else {
			blogger.loginfo("Failed to validate the hover text message");
			return false;
		}

	}

	@FindBy(xpath = "//span[@data-test-id='2017081815112305525693']")
	WebElement subscriberproductTypeHoverText;

	@FindBy(xpath = "//label[@for='SubscriberProductType']/img[@src='webwb/pzDomTreeInspectorInfo.png']")
	WebElement subscriberproductTypeImageIcon;

	/*
	 * Description: To validate Alternate ID Hover Text in Member Section
	 */
	public boolean verifySubscriberProductTypeHoverText(String hoverMessage[]) throws InterruptedException {
		if (mouseHover(subscriberproductTypeImageIcon, "Member Composite", "Member Tab")) {
			String hovertext = subscriberproductTypeHoverText.getText();
			if (utils.isvalueMatch_contain(hovertext, hoverMessage[0])) {
				return true;
			} else {
				blogger.loginfo("Failed to validate the hover text message");
				return false;
			}
		} else {
			blogger.loginfo("Failed to validate the hover text message");
			return false;
		}

	}

	public boolean mouseHover(WebElement element, String pgname, String elename) {
		Actions action = new Actions(Driver.pgDriver);
		try {
			action.moveToElement(element).build().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exception occured  in the double click");
			action.moveToElement(element).build().perform();
		}
		blogger.logMessage(pgname, elename);
		return true;

	}

	public boolean clickAddressandContactInformation() {
		if (!utils.isProxyWebelement(addressAndContInfoExpandIcon)) {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].click();", addressAndContInfoExpandIcon);
			return true;
		} else {
			return !utils.isProxyWebelement(tableMbrCompositeMbrAddress);
		}

	}

	@FindBy(xpath = "//div[@node_name='AddressInfo']//table[@id='gridLayoutTable']")
	private WebElement empgrptable;

	// ADDRESS AND CONTACT INFORMATION

	@FindBy(xpath = "//div[@title='Disclose Address and Contact Information']")
	WebElement addressAndContInfoExpandIcon;

	public boolean validateMemberAddresses(String[] memaddress) throws InterruptedException {
		if (clickAddressandContactInformation()) {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", tableMbrCompositeMbrAddress);
			return utils.validatetablerowbasedonvalues(this.tableMbrCompositeMbrAddress, memaddress);
		}
		return false;
	}

	@FindBy(xpath = "//div[@node_name='AddressInfo']//table[@id='gridLayoutTable']//img")
	WebElement memberAddresshoverIcon;

	@FindBy(xpath = "//label[@data-test-id='20150924135348062313995-Label']")
	WebElement membAddresshoverField;

	@FindBy(xpath = "//label[@data-test-id='20150924135348062313995-Label']/..//span")
	WebElement membAddresshoverFieldValue;

	public boolean verifyMemberAddressTypeHoverText(String args[]) throws Exception {
		
		//utils.waitforpageload();
		String[] tablevalues = args[0].split("\\\\");
		String[] value = tablevalues[0].split(",");
		WebElement row = utils.returntablerowbasedonvalues(tableMbrCompositeMbrAddress, value);
		WebElement rowNo= row.findElement(By.xpath(".//img"));
		if (mouseHover(rowNo, "Member Composite", "Member Tab")) {
			String hovertextField = membAddresshoverField.getText();
			String hovertextFieldVal = membAddresshoverFieldValue.getText();
			String ActualHoverText = hovertextField + hovertextFieldVal;
			if (utils.isvalueMatch_contain(ActualHoverText, tablevalues[1])) {
				return true;
			} else {
				blogger.loginfo("Failed to validate the hover text message for Member Address");
				return false;
			}
		} else {
			blogger.loginfo("Failed to validate the hover text message for Member Address");
			return false;
		}

	}

	@FindBy(xpath = "//div[@node_name='PhoneInfoForContractTab']//table[@id='gridLayoutTable']")
	WebElement subscriberPhoneInfotable;

	public boolean validateSubscriberPhoneNumbers(String[] memphoneinfo) throws InterruptedException {
		if (!utils.isProxyWebelement(subscriberPhoneInfotable)) {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", subscriberPhoneInfotable);
			return utils.validatetablerowbasedonvalues(this.subscriberPhoneInfotable, memphoneinfo);
		}
		return false;

	}

	@FindBy(xpath = "//div[@node_name='ContractAddressList']//table[@class='gridTable ']")
	WebElement subscriberAddressInfotable;

	public boolean validateSubscriberAddresses(String[] memaddress) throws InterruptedException {
		if (!utils.isProxyWebelement(subscriberAddressInfotable)) {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", subscriberAddressInfotable);
			return utils.validatetablerowbasedonvalues(this.subscriberAddressInfotable, memaddress);
		}
		return false;

	}

	// div[@node_name='AddressInfo']//table[@id='gridLayoutTable']//div//span[text()='Billing Address']

	@FindBy(xpath = "//div[@node_name='ContractAddressList']//table[@id='gridLayoutTable']//img")
	WebElement subscriberAddresshoverIcon;

	@FindBy(xpath = "//label[@data-test-id='20150924135348062313995-Label']")
	WebElement subscriberAddresshoverField;

	@FindBy(xpath = "//label[@data-test-id='20150924135348062313995-Label']/..//span")
	WebElement subscriberAddresshoverFieldValue;

	public boolean verifySubscriberAddressTypeHoverText(String args[]) throws Exception {
		String[] tablevalues = args[0].split("\\\\");
		String[] value = tablevalues[0].split(",");
		WebElement row = utils.returntablerowbasedonvalues(subscriberAddressInfotable, value);
		WebElement rowNo= row.findElement(By.xpath(".//img"));
		if (mouseHover(rowNo, "Member Composite", "Member Tab")) {
			String hovertextField = subscriberAddresshoverField.getText().trim();
			String hovertextFieldVal = subscriberAddresshoverFieldValue.getText().trim();
			String ActualHoverText = hovertextField + hovertextFieldVal;
			if (utils.isvalueMatch_contain(ActualHoverText, args[0])) {
				return true;
			} else {
				blogger.loginfo("Failed to validate the hover text message for Member Address");
				return false;
			}
		} else {
			blogger.loginfo("Failed to validate the hover text message for Member Address");
			return false;
		}

	}

	@FindBy(xpath = "//span[@data-test-id='20150924113610027734550']")
	private WebElement memberEmail;

	public boolean validateMemberPhoneNumbers(String[] memaddress) throws InterruptedException {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", tableMbrCompositeMbrPhone);
			return utils.validatetablerowbasedonvalues(this.tableMbrCompositeMbrPhone, memaddress);
		} catch (Exception ex) {

			blogger.loginfo("Failed to validate Memebr Phone number");
			return false;
		}
	}

	public boolean validateMemberEmail(String[] memaddress) throws InterruptedException {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", tableMbrCompositeMbrEmail);
			return utils.validatetablerowbasedonvalues(this.tableMbrCompositeMbrEmail, memaddress);
		} catch (Exception ex) {
			blogger.loginfo("Failed to validate member email address");
			return false;
		}
	}

	@FindBy(xpath = "//label[contains(text(),'Date Updated :') ]")
	private WebElement AddressesHoverText;

	public boolean VerifyaddressHoverText(String[] arg) throws Exception {
		return utils.validateValueinelement(this.AddressesHoverText, arg[0], "MemberComposite_MemberSection",
				"verify AddressHoverText");
	}

	@FindBy(xpath = "//div[text()='Attribution information is for internal use; attributed PCP should not be discussed with contact.']")
	private WebElement pcpAttributionmessage;

	@FindBy(xpath = "//div[@title='Disclose Primary Care Physician Information']")
	private WebElement labelMbrCompositeMbrPriCarePhyInfoLink2;

	public boolean VerifyAttributeMessageIsDisplayed() {
		if (utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink2, "Member Composite ",
				" Contract address link "))
			if (utils.isProxyWebelement(this.labelMbrCompositeMbrPCPName))
				if (utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink2, "Member Composite ",
						" Contract address link "))
					return !utils.isProxyWebelement(pcpAttributionmessage);
		return false;
	}

	public boolean VerifyAttributeMessageIsNotDisplayed() {
		if (utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink2, "Member Composite ",
				" Contract address link "))
			if (utils.isProxyWebelement(this.labelMbrCompositeMbrPCPName))
				if (utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink2, "Member Composite ",
						" Contract address link "))
					return !utils.isProxyWebelement(pcpAttributionmessage);
		return false;

	}

	public boolean verifyDisplayOfPrimaryCarePhysicianInfo() {
		if (!utils.isProxyWebelement(primaryCarePhysicianExpandIcon))
			return true;
		return false;

	}

	public boolean clickPrimaryCarePhysicianInformation() {
		if (utils.clickAnelemnt(primaryCarePhysicianExpandIcon, "Member Composite", "Primary Care Tab")) {
			return true;
		} else {
			blogger.loginfo("Failed to click Physician Information");
			return false;
		}

	}

	@FindBy(xpath = "//th[@data-attribute-name='PCP ID']/parent::tr/parent::tbody/parent::table")
	private WebElement pcpTable;

	public boolean validatePCPTable(String[] arg) {
		if (utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink2, "Member Composite ",
				" Contract address link "))
			if (utils.isProxyWebelement(this.labelMbrCompositeMbrPCPName))
				if (utils.clickAnelemnt(this.labelMbrCompositeMbrPriCarePhyInfoLink2, "Member Composite ",
						" Contract address link "))
					return utils.validatetablerowbasedonvalues(this.pcpTable, arg);
		return false;
	}

	@FindBy(xpath = "//span[@data-test-id='20170622194445011327503']")
	private WebElement businessUnit;

	public boolean verifyBusinessUnit(String[] args) {
		String Expectedvalue = args[0];
		return utils.isvalueMatch_compareto(businessUnit.getText(), Expectedvalue);
	}

	@FindBy(xpath = "//span[@data-test-id='20150914102046032213295']")
	private WebElement exchangeIndicator;

	public boolean verifyExchangeIndicator(String[] args) {
		String Expectedvalue = args[0];
		return utils.isvalueMatch_compareto(exchangeIndicator.getText(), Expectedvalue);
	}
}
