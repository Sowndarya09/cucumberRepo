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

public class MemberComposite_GroupSection extends Driver {
	WebDriverWait wait;
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	public MemberComposite_GroupSection() {

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

	@FindBy(xpath = "//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Group']")
	WebElement tabMbrCompositeGroup;

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

	// GROUP INFORMATION
	// ___________________________________________________________________________

	// Group links

	@FindBy(xpath = "//span[text()='Group Information']")
	WebElement lnkMbrCompositeGrpInfo;

	@FindBy(xpath = "//span[text()='Group Addressess']")
	WebElement lnkMbrCompositeGrpAddress;

	@FindBy(xpath = "//span[text()='Group Phone Numbers']")
	WebElement lnkMbrCompositeGrpPhone;

	@FindBy(xpath = "//span[text()='Broker Information']")
	WebElement lnkMbrCompositeGrpBrokerInfo;

	// EMPLOYER GROUP INFORMATION

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupName']/parent::div//span")
	WebElement labelMbrCompositeGrpName;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupName']/parent::div//span")
	WebElement labelMbrCompositeGrpProdname;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupNumber']/parent::div//span")
	WebElement labelMbrCompositeGrpNum;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='SmallGroupNumber']/parent::div//span")
	WebElement labelMbrCompositeGrpsmallGrpnum;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupStatus']/parent::div//span")
	WebElement labelMbrCompositeGrpStatus;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupTapeUpdateDate']/parent::div//span")
	WebElement labelMbrCompositeGrpTapeLastUpdateDate;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='RateGuaranteeDate']/parent::div//span")
	WebElement labelMbrCompositeGrpOpenEnrollmentMonth;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupTerminationDate']/parent::div//span")
	WebElement labelMbrCompositeGrpTerminationDate;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='AccountType']/parent::div//span")
	WebElement labelMbrCompositeGrpAccountType;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupStatus']/parent::div//span")
	WebElement labelMbrCompositeGrpEmployeeRetirementIncomeSecurityAct;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='IDCardMailing']/parent::div//span")
	WebElement labelMbrCompositeGrpIDCard;

	@FindBy(xpath = "//div[@node_name='GroupDetails']//label[@for='BrokerFName']/parent::div//span")
	WebElement labelBrokerFirstName;

	@FindBy(xpath = "//div[@node_name='GroupDetails']//label[@for='BrokerLName']/parent::div//span")
	WebElement labelBrokerLastName;

	@FindBy(xpath = "//div[@node_name='GroupDetails']//label[@for='CompanyName']/parent::div//span")
	WebElement labelBrokerCompany;

	@FindBy(xpath = "//div[@node_name='GroupDetails']//label[@for='BrokerEncryptedID']/parent::div//span")
	WebElement labelBrokerEncryptedID;

	// PRODUCT GROUP INFORMATION

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupName']/parent::div//span")
	WebElement labelMbrCompositeProdGrpname;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupNumber']/parent::div//span")
	WebElement labelMbrCompositeProdGrpNum;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='SmallGroupNumber']/parent::div//span")
	WebElement labelMbrCompositeProdGrpsmallGrpnum;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupTerminationDate']/parent::div//span")
	WebElement labelMbrCompositeProdGrpTerminationDate;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='RateMethodCode']/parent::div//span")
	WebElement labelMbrCompositeProdGrpRateMethodCode;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupStatus']/parent::div//span")
	WebElement labelMbrCompositeProdGrpIDCardMailing;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupStatus']/parent::div//span")
	WebElement labelMbrCompositeProdGrpFundingType;

	// Anthemgroup management under Group info -------------------------------

	@FindBy(xpath = "//span[text()='Anthem Group Management']")
	WebElement labeldropMbrCompositeGrpManagement;

	@FindBy(xpath = "//span[text()='Employer Group Administrator']")
	WebElement labeldropMbrCompositeGrpEmpGrpAdmin;

	// ELEMENTS UDNER ANTHEM GROUP MANAGEMENT

	@FindBy(xpath = "//label[@for='RecipientNamePhone']/following-sibling::div")
	WebElement labelMbrCompositeGrpServLoc;

	@FindBy(xpath = "//label[@for='CPCCIndicator']/following-sibling::div")
	WebElement labelMbrCompositeGrpTranstoProv;

	@FindBy(xpath = "//label[@for='ClaimsAddress']/following-sibling::div")
	WebElement labelMbrCompositeGrpClaimsAddress;

	// ELEMENTS UNDER EMPLOYER GROUP ADMINISTRATOR

	@FindBy(xpath = "//div[@node_name='EmployerGroupAdmin']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupadmin;

	// ELEMENTS UNDER GROUP INFORMATION

	@FindBy(xpath = "//div[contains(@datasource,'AddressList_Group')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupAddress;

	@FindBy(xpath = "//div[contains(@datasource,'GroupPhoneList_Group')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpGroupPhone;

	@FindBy(xpath = "//div[@node_name='BrokersListInformation']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeGrpBrokerInfo;

//NAVIGATIOn to OTHER PAGES

	@FindBy(xpath = "//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")
	WebElement benefitsandcost;
	@FindBy(xpath = "//div[@node_name='pyOverlayTemplate']//a[@title='Manage Claims'][@class='Add_task']")
	WebElement manageclaims;

	@FindBy(xpath = "//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")
	WebElement promisedactions;

//ADD TASK button

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Add task(s)']")
	WebElement addtaskbutton;

//New CHECKBBOX BUTTONS ADDED----------------

	@FindBy(id = "MemberInfoReview")
	WebElement chkbxmemberinfodiscussed;

	@FindBy(id = "ContractInfoReview")
	WebElement chkbxcontractinfodiscussed;

	@FindBy(id = "GroupDetailsInfoReview")
	WebElement chkbxgroupinfodiscussed;

	@FindBy(id = "InteractionsInfoReview")
	WebElement chkbxInteractioninfodiscussed;

	// Guided Dialog message

	@FindBy(id = "DialogContent")
	WebElement labelGuidedDialog;

//Checkbox common methods 

	public boolean verifyGuidedDialogText() {
		String message = this.labelGuidedDialog.getText().toString();
		return utils.isvalueMatch_contain(message,
				"Handle with care. Use the HIPAA Verification & Disclosure Guide link if you need help understanding what you can tell");
	}

	public boolean CheckDataInGrpAddressTable(String[] args) {
		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		if (utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member composite ", "Group Tab ")) {
			if (utils.isProxyWebelement(this.tableMbrCompositeGrpGroupAddress)) {
				utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo, "Member Composite ", " Group Info ");
			} else {
				System.out.println("Group Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeGrpGroupAddress, columnName);
			for (int i = 0; i < firstnameColumn.size(); i++) {
				System.out.println("Content text is : " + firstnameColumn.get(i));
				if (firstnameColumn.get(i).toLowerCase().contains(value.toLowerCase())) {
					try {
						String name = firstnameColumn.get(i);
						Driver.pgDriver.findElement(
								By.xpath("//table[@class='gridTable ']//div//span[text()='" + name + "']"));
						return true;
					} catch (Exception e) {
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}

	public boolean CheckDataInGrpPhoneTable(String[] args) {
		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		if (utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member composite ", "Group Tab ")) {
			if (utils.isProxyWebelement(this.tableMbrCompositeGrpGroupPhone)) {
				utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo, "Member Composite ", " Group Info ");
			} else {
				System.out.println("Group Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeGrpGroupPhone, columnName);
			for (int i = 0; i < firstnameColumn.size(); i++) {
				System.out.println("Content text is : " + firstnameColumn.get(i));
				if (firstnameColumn.get(i).contains(value.toLowerCase())) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public boolean CheckDataInGrpBrokerTable(String[] args) {

		String columnName = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":") + 1);
		if (utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member composite ", "Group Tab ")) {
			if (utils.isProxyWebelement(this.tableMbrCompositeGrpBrokerInfo)) {
				utils.clickAnelemnt(this.lnkMbrCompositeGrpBrokerInfo, "Member Composite ", " Group Info ");
			} else {
				System.out.println("Group Address is already clicked");
			}
			ArrayList<String> firstnameColumn = new ArrayList<String>();
			firstnameColumn = utils.getcolumnStringFromTableByName(this.tableMbrCompositeGrpBrokerInfo, columnName);
			for (int i = 0; i < firstnameColumn.size(); i++) {
				System.out.println("Content text is : " + firstnameColumn.get(i));
				if (firstnameColumn.get(i).contains(value.toLowerCase())) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public boolean verifyGroupGeneralInfo(String[] grpgeninfoDetails) {
		boolean returnvar;
		returnvar = true;
		utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab");
		if (utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab")) {
			if (utils.isProxyWebelement(this.labelMbrCompositeGrpName)) {
				utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo, "Member Composite ", " Contract address link ");
			} else {
				System.out.println("Contract Address is already clicked");
			}
			String keyvaluepair = "";
			for (String iterator : grpgeninfoDetails) {
				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
				if (key.toLowerCase().contains("productgrpname")) {
					returnvar = this.labelMbrCompositeGrpProdname.getText().toLowerCase().contains(value);
					continue;
				} else if (key.toLowerCase().contains("grpname")) {
					returnvar = this.labelMbrCompositeGrpName.getText().toLowerCase().contains(value);
					continue;
				}

				else if (key.toLowerCase().contains("smallgrpnumber")) {
					System.out.println("samall group value" + this.labelMbrCompositeGrpsmallGrpnum.getText());
					returnvar = this.labelMbrCompositeGrpsmallGrpnum.getText().toLowerCase().contains(value);
					continue;
				} else if (key.toLowerCase().contains("grpnumber")) {
					returnvar = this.labelMbrCompositeGrpNum.getText().toLowerCase().contains(value);
					continue;
				} else if (key.toLowerCase().contains("grpstatus")) {
					returnvar = this.labelMbrCompositeGrpStatus.getText().toLowerCase().contains(value);
					continue;
				} else if (key.toLowerCase().contains("idcardmailing")) {
					returnvar = this.labelMbrCompositeGrpIDCard.getText().toLowerCase().contains(value);
					continue;
				} else
					err.logcommonMethodError("Member Composite",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		} else
			err.logError("Member Composite", "Member tab ");

		if (returnvar) {
			System.out.println("Group genral info checked Successfully");
			return true;
		} else {
			int tot_i = grpgeninfoDetails.length;
			err.logcommonMethodError("Member Composite", "the value " + grpgeninfoDetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}
	}

	public boolean verifyAnthemGrpManagement(String[] grpmanageinfoDetails) throws Exception {
		boolean returnvar;
		returnvar = true;
		utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab");
		if (utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab")) {

			utils.waitforpageload();
			if (utils.clickAnelemnt(this.labeldropMbrCompositeGrpManagement, "Member Composite ",
					" Contract address link "))
				utils.waitforpageload();

//			if(utils.isProxyWebelement(this.labelMbrCompositeGrpServLoc))
//			{
//				utils.clickAnelemnt(this.labeldropMbrCompositeGrpManagement,"Member Composite "," Contract address link ");
//				utils.waitforpageload();
//
//			}
//			else
//			{
//				System.out.println("Contract Address is already clicked");
//				utils.clickAnelemnt(this.labeldropMbrCompositeGrpManagement,"Member Composite "," Contract address link ");
//
//			}

			for (String iterator : grpmanageinfoDetails) {
				String keyvaluepair = iterator;
				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if (key.toLowerCase().contains("servicelocation")) {
					System.out.println(this.labelMbrCompositeGrpServLoc.getText());
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpServLoc, value, "MemberComposite",
							"labelMbrCompositeGrpServLoc");
					continue;
				} else if (key.toLowerCase().contains("transfer")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpTranstoProv, value,
							"MemberComposite", "labelMbrCompositeGrpTranstoProv");
					continue;
				} else if (key.toLowerCase().contains("claimaddress")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpClaimsAddress, value,
							"MemberComposite", "labelMbrCompositeGrpClaimsAddress");
					continue;
				} else
					err.logcommonMethodError("Member Composite",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		} else
			err.logError("Member Composite", "Member tab ");
		if (returnvar) {
			System.out.println("Group management info checked Successfully");
			return true;
		} else {
			int tot_i = grpmanageinfoDetails.length;
			err.logcommonMethodError("Member Composite", "the value " + grpmanageinfoDetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}
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
				settxtbxStartDate(args);
			} catch (NoSuchElementException e) {
				settxtbxStartDate(args);
			}
		return true;

	}

	// entering the value for the two dates in the pace
	@FindBy(xpath = "//*[@id='SearchEndDate']")
	WebElement txtbxEndtDate;

	public boolean settxtbxEndDate(String[] args) {
		try {
			return utils.enterTextinAnelemnt(this.txtbxEndtDate, args[0], "MemberVerify", "Nickname textbox");
		} catch (StaleElementReferenceException e) {
			settxtbxStartDate(args);
		} catch (NoSuchElementException e) {
			settxtbxStartDate(args);
		}
		return true;

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
		Thread.sleep(2000);
		// utils.PressEnter(this.lnkClickonLinkafterSettingValue, "Member Composite",
		// "Text Box Add Task Options");
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

	public boolean navigateTOBenefitsandCost() throws InterruptedException

	{
		Thread.sleep(2000);
		waitforpageload();
		if (this.clickbtnAddTask())
			waitforpageload();
		wait = new WebDriverWait(Driver.pgDriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")));
		if (utils.clickAnelemnt(this.benefitsandcost, "Member Composite", "Benefits and cost under add task"))
			if (utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
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
	 * @SCU #CommonMethodWithArgument: verifyEmployerGroupGeneralInformation
	 * #Description: This functionality verifies the employer group general
	 * information with the details present in the application with the input values
	 * given. #Argument: grpgeninformationDetails Type: Table keys: Group Name#Group
	 * Number#Group Status#Group Termination Date#Group Tape Enrollment Ind#Group
	 * Tape Last Update Date#Open Enrollment Month#Account Type#Employee Retirement
	 * Income Security Act
	 */
	public boolean verifyEmployerGroupGeneralInformation(String[] grpgeninformationDetails) throws Exception {
		utils.waitforpageload();
		boolean returnvar;
		returnvar = true;
		utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab");
		if (utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab")) {
			if (!utils.isProxyWebelement(this.labelMbrCompositeGrpName)) {
				// utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo,"Member Composite ","
				// Contract address link ");

			} else {
				System.out.println("Group Address is already clicked");
			}
			String keyvaluepair = "";
			for (String iterator : grpgeninformationDetails) {

				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if (key.toLowerCase().equals("productgrpname")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpProdname, value);
					continue;
				} else if (key.equals("grpname") || key.equalsIgnoreCase("Name")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpName, value);
					continue;
				} else if (key.equals("smallgrpnumber") || key.equalsIgnoreCase("Number")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpsmallGrpnum, value);
					continue;
				} else if (key.equals("grpnumber") || key.equalsIgnoreCase("Group Number")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpNum, value);
					continue;
				}

				else if (key.equals("grpstatus") || key.equalsIgnoreCase("Status")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpStatus, value);
					continue;
				} else if (key.equals("grpterminationdate")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpTerminationDate, value);
					continue;
				} else if (key.equals("grptapeenrollmentind") || key.equalsIgnoreCase("Enrollment")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpTapeEnrollmentInd, value);
					continue;
				} else if (key.equalsIgnoreCase("grptapelastupdatedate")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpTapeLastUpdateDate, value);
					continue;
				} else if (key.equalsIgnoreCase("rateguaranteedate")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpOpenEnrollmentMonth, value);
					continue;
				} else if (key.equalsIgnoreCase("grpacounttype") || key.equalsIgnoreCase("Account Type")) {
					returnvar = utils.validateValueinelement(this.labelMbrCompositeGrpAccountType, value);
					continue;
				} else if (key.equalsIgnoreCase("grpemployeeretirementincomesecurity")) {
					returnvar = utils.validateValueinelement(
							this.labelMbrCompositeGrpEmployeeRetirementIncomeSecurityAct, value);
					continue;
				} else
					err.logcommonMethodError("Member Composite",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		} else
			err.logError("Member Composite", "Member tab ");
		if (returnvar) {
			System.out.println("Group genral info checked Successfully");
			return !utils.isServiceDown();
		} else {
			int tot_i = grpgeninformationDetails.length;
			err.logcommonMethodError("Member Composite", "the value " + grpgeninformationDetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}
	}

	/*
	 * @SCU #CommonMethodWithArgument: verifyProductGroupGeneralInformation
	 * #Description: This functionality verifies the product group general
	 * information with the details present in the application with the input values
	 * given. #Argument: prodgeninformationDetails Type: Table keys: Group
	 * Name#Group Number#Group Status#Group Termination Date#Rate Method Code#ID
	 * Card Mailing#Funding Type
	 */
	public boolean verifyProductGroupGeneralInformation(String[] prodgeninformationDetails) {
		boolean returnvar;
		returnvar = true;
		utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab");
		if (utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab")) {
			if (utils.isProxyWebelement(this.labelMbrCompositeGrpName)) {
				// utils.clickAnelemnt(this.lnkMbrCompositeGrpInfo,"Member Composite ","
				// Contract address link ");

			} else {
				System.out.println("Group Address is already clicked");
			}
			String keyvaluepair = "";
			for (String iterator : prodgeninformationDetails) {

				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if (key.toLowerCase().contains("productgrpname") || key.equalsIgnoreCase("Name")) {
					returnvar = this.labelMbrCompositeGrpProdname.getText().toLowerCase().contains(value);
					continue;
				} else if (key.equalsIgnoreCase("grpname")) {
					returnvar = this.labelMbrCompositeGrpName.getText().toLowerCase().contains(value);
					continue;
				} else if (key.equalsIgnoreCase("smallgrpnumber")) {
					System.out.println("samall group value" + this.labelMbrCompositeGrpsmallGrpnum.getText());
					returnvar = this.labelMbrCompositeGrpsmallGrpnum.getText().toLowerCase().contains(value);
					continue;
				} else if (key.equalsIgnoreCase("grpnumber") || key.equalsIgnoreCase("Number")) {
					returnvar = this.labelMbrCompositeGrpNum.getText().toLowerCase().contains(value);
					continue;
				} else if (key.equalsIgnoreCase("grpstatus")) {
					returnvar = this.labelMbrCompositeGrpStatus.getText().toLowerCase().contains(value);
					continue;
				} else if (key.equalsIgnoreCase("grpterminationdate")) {
					returnvar = this.labelMbrCompositeProdGrpTerminationDate.getText().toLowerCase().contains(value);
					continue;
				} else if (key.equalsIgnoreCase("grpratemethodcode") || key.equalsIgnoreCase("Rate Method Code")) {
					returnvar = this.labelMbrCompositeProdGrpRateMethodCode.getText().toLowerCase().contains(value);
					continue;
				} else if (key.equalsIgnoreCase("grpidcardmailing") || key.equalsIgnoreCase("ID Card Mailing")) {
					returnvar = this.labelMbrCompositeProdGrpIDCardMailing.getText().toLowerCase().contains(value);
					continue;
				} else if (key.equalsIgnoreCase("grpfundingtype") || key.equalsIgnoreCase("Funding Type")) {
					returnvar = this.labelMbrCompositeProdGrpFundingType.getText().toLowerCase().contains(value);
					continue;
				} else
					err.logcommonMethodError("Member Composite",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		} else
			err.logError("Member Composite", "Member tab ");
		if (returnvar) {
			System.out.println("Group genral info checked Successfully");
			return true;
		} else {
			int tot_i = prodgeninformationDetails.length;
			err.logcommonMethodError("Member Composite", "the value " + prodgeninformationDetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}
	}

	// @FindBy(xpath="//*[@data-test-id='201509210134060567140195']/ancestor::div//table[@id='bodyTbl_right']")
	@FindBy(xpath = "(//div[@node_name='BrokerAddressList']//table[@pl_prop='.AddressList'])[1]")
	WebElement BrokerInfoTable;

	/**
	 * This method is used to select Broker info and verify table and given row
	 * values
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectBrokerInfoLinkAndVerifyTable(String[] args) throws InterruptedException {
		Thread.sleep(3000);
		Actions action = new Actions(pgDriver);
		action.moveToElement(lnkMbrCompositeGrpBrokerInfo).build().perform();
		if (utils.clickAnelemnt(lnkMbrCompositeGrpBrokerInfo, "Member Composite_GroupSection ",
				" Broker information Link "))
			action.moveToElement(BrokerInfoTable).build().perform();
		return utils.validatetablerowbasedonvalues(BrokerInfoTable, args);
	}

	@FindBy(xpath = "//span[@role='heading'][text()='Broker Information']")
	WebElement brokerInfoTxt;

	@FindBy(xpath = "//label[text()='Broker Name']//following-sibling::div//span")
	List<WebElement> brokerNameTxt;

	@FindBy(xpath = "//label[text()='Tax ID']//following-sibling::div//span")
	List<WebElement> taxIDTxt;

	@FindBy(xpath = "//label[text()='Encrypted ID']//following-sibling::div//span")
	List<WebElement> encryptedIDTxt;

	@FindBy(xpath = "//label[text()='Email']//following-sibling::div//span")
	List<WebElement> brokerEmailTxt;

	/*
	 * @SCU #CommonMethodWithArgument:validateBrokerInformationSection
	 * #Description:This functionality validates the Broker Information section in
	 * Group page #Arguments:BrokerInformation Type:Table Keys:Broker Name#Tax
	 * ID#Encrypted ID#Email
	 */
	public boolean validateBrokerInformationSection(String args[]) {
		((JavascriptExecutor) Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",
				this.brokerInfoTxt);
		utils.clickAnelemnt(this.brokerInfoTxt, "MemberComposite_Group", "Broker Information section");
		boolean returnvar = true;
		for (String iterator : args) {
			String keyvaluepair = iterator;
			if (!returnvar) {
				err.logcommonMethodError("validateBrokerInformationSection", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":") + 1);
			System.out.println("key " + key + "value  " + value);

			if (key.contains("Broker Name")) {
				for (WebElement s : this.brokerNameTxt) {
					if (utils.isvalueMatch_contain(s.getText().trim(), value)) {
						System.out.println("Broker Name matched");
						returnvar = true;
						break;
					} else {
						returnvar = false;
					}
				}
				continue;
			} else if (key.contains("Tax ID")) {
				for (WebElement s : this.taxIDTxt) {
					if (utils.isvalueMatch_contain(s.getText().trim(), value)) {
						System.out.println("Broker Info - TaxID matched");
						returnvar = true;
						break;
					} else {
						returnvar = false;
					}
				}
				continue;

			} else if (key.contains("Encrypted ID")) {
				for (WebElement s : this.encryptedIDTxt) {
					if (utils.isvalueMatch_contain(s.getText().trim(), value)) {
						System.out.println("Broker Info - Encrypted ID matched");
						returnvar = true;
						break;
					} else {
						returnvar = false;
					}
				}
				continue;

			} else if (key.contains("Email")) {
				for (WebElement s : this.brokerEmailTxt) {
					if (utils.isvalueMatch_contain(s.getText().trim(), value)) {
						System.out.println("Broker Info - Email matched");
						returnvar = true;
						break;
					} else {
						returnvar = false;
					}
				}
				continue;

			} else {
				err.logcommonMethodError("validateBrokerInformationSection",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		return true;
	}

	// @FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupDetailsBBBB']//table[@pl_prop='.AddressList']")
	@FindBy(xpath = "//div[@node_name='BrokerAddressList']//table[@pl_prop='.AddressList']")
	List<WebElement> brokerAddressesTable;

	// @FindBy(xpath="//div[@param_name='EXPANDEDSubSectionGroupDetailsBBBB']//table[@pl_prop='.PhoneCommunication']")
	@FindBy(xpath = "//div[@node_name='BrokerPhoneList']//table[@pl_prop='.PhoneCommunication']")
	List<WebElement> brokerPhoneNosTable;


	public boolean clickGroup() {
		if (utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Contract tab"))
			if (waitforpageload())
				return true;
		return false;

	}

	public boolean clickGroupInformationDiscussedWithContactCheckbox() {
		if (utils.clickAnelemnt(this.chkbxgroupinfodiscussed, "Member Composite", "Checkbox"))
			return true;
		return false;
	}

	// EMPLOYER GROUP INFORMATION CASE

	@FindBy(xpath = "//div[@title='Hide Employer Group Information (Case)']")
	WebElement enplyerGroupExpandIcon;

	@FindBy(xpath = "//div[@title='Hide Product Information (Group or Entity)']")
	WebElement productInformationExpandIcon;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupName']/parent::div//span")
	WebElement empGroupInfoName;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='SmallGroupNumber']/parent::div//span")
	WebElement empGroupInfocasenumber;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupStatus']/parent::div//span")
	WebElement empGroupInfoStatus;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupTerminationDate']/parent::div//span")
	WebElement empGroupInfoCaseTermination;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='AccountType']/parent::div//span")
	WebElement empGroupInfoAccountType;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupTapeUpdateDate']/parent::div//span")
	WebElement empGroupInfoLastTapeUpdate;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='RateGuaranteeDate']/parent::div//span")
	WebElement empGroupInfoRateGuaranteeEnd;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ErisaIndicator']/parent::div//span")
	WebElement empGroupInfoERISA;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ClaimsStopDate']/parent::div//span")
	WebElement empGroupInfoClaimStopDate;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ClaimStopDesc']/parent::div//span")
	WebElement empGroupInfoClaimStopReason;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='GroupTapeInd']/parent::div//span")
	WebElement labelMbrCompositeGrpTapeEnrollmentInd;

	public boolean validateEmployerGroupInformation(String[] grpgeninformationDetails) throws Exception {
		boolean returnvar;
		returnvar = true;
		if (!utils.isProxyWebelement(enplyerGroupExpandIcon))
			if (!utils.isProxyWebelement(productInformationExpandIcon)) {
				System.out.println("Entered into method");
				JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
				jse.executeScript("arguments[0].scrollIntoView();", enplyerGroupExpandIcon);

				String keyvaluepair = "";
				for (String iterator : grpgeninformationDetails) {

					if (!returnvar) {
						err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
								+ " Either Your input is wrong or the value found on application is incorrect");
						return false;

					}
					keyvaluepair = iterator;
					String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
					String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
					System.out.println("key " + key + "value  " + value);

					if (key.toLowerCase().contains("employername")) {
						returnvar = utils.validateValueinelement(empGroupInfoName, value);
						continue;
					} else if (key.toLowerCase().contains("casenumber")) {
						returnvar = utils.validateValueinelement(empGroupInfocasenumber, value);
						continue;
					} else if (key.toLowerCase().contains("status")) {
						returnvar = utils.validateValueinelement(empGroupInfoStatus, value);
						continue;
					} else if (key.toLowerCase().contains("accounttype")) {
						returnvar = utils.validateValueinelement(empGroupInfoAccountType, value);
						continue;
					}

					else if (key.toLowerCase().contains("erisa")) {
						returnvar = utils.validateValueinelement(empGroupInfoERISA, value);
						continue;
					} else if (key.toLowerCase().contains("casetermination")) {
						returnvar = utils.validateValueinelement(empGroupInfoCaseTermination, value);
						continue;
					} else if (key.toLowerCase().contains("tapeenrollment")) {
						returnvar = utils.validateValueinelement(labelMbrCompositeGrpTapeEnrollmentInd, value);
						continue;
					} else if (key.toLowerCase().contains("lasttapeupdate")) {
						returnvar = utils.validateValueinelement(empGroupInfoLastTapeUpdate, value);
						continue;
					} else if (key.toLowerCase().contains("rateguaranteeend")) {
						returnvar = utils.validateValueinelement(empGroupInfoRateGuaranteeEnd, value);
						continue;
					} else if (key.toLowerCase().contains("claimstopdate")) {
						returnvar = utils.validateValueinelement(empGroupInfoClaimStopDate, value);
						continue;
					} else if (key.toLowerCase().contains("claimstopreason")) {
						returnvar = utils.validateValueinelement(empGroupInfoClaimStopReason, value);
						continue;
					} else
						err.logcommonMethodError("Member Composite",
								"Check your key in yourkeypair. Make sure you are following the same pattern for input");
					return false;
				}
				if (returnvar) {
					System.out.println("Group genral info checked Successfully");
					return true;
				} else {
					int tot_i = grpgeninformationDetails.length;
					err.logcommonMethodError("Member Composite",
							"the value " + grpgeninformationDetails[tot_i - 1].toString()
									+ " doesnt match with the one in application");
					return false;
				}
			}
		return false;
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

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']/parent::div/..//label[@for='ErisaIndicator']")
	WebElement erisahovertext;

	public boolean verifyERISAHoverText(String hoverMessage[]) {
		if (mouseHover(erisahovertext, "Member Composite", "Group Tab")) {
			String hovertext1 = erisahovertext.getAttribute("aria-label").toString();
			if (utils.isvalueMatch_contain(hovertext1, hoverMessage[0])) {
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

	// PRODUCTINFORMATION GROUP OR ENTITY

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupName']/parent::div//span")
	WebElement productInfoEntityName;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupNumber']/parent::div//span")
	WebElement productInfoEntityProductNumber;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ProductGroupTerminationDate']/parent::div//span")
	WebElement productInfoTerminationDate;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='IDCardMailing']/parent::div//span")
	WebElement productInfoIDCard;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ReRateMonth']/parent::div//span")
	WebElement productInfoReRateMonth;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='FundingType']/parent::div//span")
	WebElement productInfoFundingType;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='RateMethodCode']/parent::div//span")
	WebElement productInfoRateMethodCode;

	public boolean validateProductInformation(String[] productinformationDetails) throws Exception {
		boolean returnvar;
		returnvar = true;

		System.out.println("Entered into method");
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", productInformationExpandIcon);

		String keyvaluepair = "";
		for (String iterator : productinformationDetails) {

			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if (key.toLowerCase().contains("entityname")) {
				returnvar = utils.validateValueinelement(productInfoEntityName, value);
				continue;
			} else if (key.toLowerCase().contains("productnumber")) {
				returnvar = utils.validateValueinelement(productInfoEntityProductNumber, value);
				continue;
			}

			else if (key.toLowerCase().contains("producttermination")) {
				returnvar = utils.validateValueinelement(productInfoTerminationDate, value);
				continue;
			} else if (key.toLowerCase().contains("idcard")) {
				returnvar = utils.validateValueinelement(productInfoIDCard, value);
				continue;
			} else if (key.toLowerCase().contains("reratemonth")) {
				returnvar = utils.validateValueinelement(productInfoReRateMonth, value);
				continue;
			}

			else if (key.toLowerCase().contains("fundingtype")) {
				returnvar = utils.validateValueinelement(productInfoFundingType, value);
				continue;
			} else if (key.toLowerCase().contains("ratemethodcode")) {
				returnvar = utils.validateValueinelement(productInfoRateMethodCode, value);
				continue;
			}

			else
				err.logcommonMethodError("Member Composite",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if (returnvar) {
			System.out.println("Product Information (Group or Entity) info checked Successfully");
			return true;
		} else {
			int tot_i = productinformationDetails.length;
			err.logcommonMethodError("Member Composite", "the value " + productinformationDetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='FundingType']")
	WebElement fundingTypehovertext;

	public boolean verifyFundingTypeHoverText(String hoverMessage[]) {
		if (mouseHover(fundingTypehovertext, "Member Composite", "Group Tab")) {
			String hovertext1 = fundingTypehovertext.getAttribute("aria-label").toString();
			if (utils.isvalueMatch_contain(hovertext1, hoverMessage[0])) {
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
//Anthem group management

	@FindBy(xpath = "//div[@title='Disclose Anthem Group Management']")
	WebElement agmExpandIcon;

	@FindBy(xpath = "//span[text()='Anthem Group Management']")
	WebElement agmInfoTab;

	public boolean clickAnthemGroupManagement() throws Exception {
		if (!utils.isProxyWebelement(agmExpandIcon)) {
			blogger.loginfo("Anthem Group Management is collapsed by default");
			if (utils.clickAnelemnt(agmInfoTab, "Member Composite", "Member Tab"))
				if (waitforpageload())
					return true;
			return false;
		}
		return false;
	}

//div[@aria-label='Hide Anthem Group Management']/../..//label[@for='RecipientNamePhone']/parent::div

	@FindBy(xpath = "//div[@aria-label='Hide Anthem Group Management']/../..//label[@for='RecipientNamePhone']/parent::div//div")
	WebElement anthemgroupmangeservlocation;

	@FindBy(xpath = "//div[@aria-label='Hide Anthem Group Management']/../..//label[@for='CPCCIndicator']/parent::div//div")
	WebElement anthemgroupmangetransfertoprovider;

	@FindBy(xpath = "//div[@aria-label='Hide Anthem Group Management']/../..//label[@for='ProviderCarePhone']/parent::div//div")
	WebElement anthemgroupmangeproviderservice;

	@FindBy(xpath = "//div[@node_name='GroupDetailsInformation']//label[@for='ClaimsAddress']/parent::div//span")
	WebElement anthemgroupmangeclaimaddress;

	public boolean verifyAnthemGroupManagement(String[] productinformationDetails) throws Exception {
		boolean returnvar;
		returnvar = true;

		System.out.println("Entered into method");
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", productInformationExpandIcon);

		String keyvaluepair = "";
		for (String iterator : productinformationDetails) {

			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if (key.toLowerCase().contains("servicelocation")) {
				returnvar = utils.validateValueinelement(anthemgroupmangeservlocation, value);
				continue;
			} else if (key.toLowerCase().contains("transfertoprovider")) {
				returnvar = utils.validateValueinelement(anthemgroupmangetransfertoprovider, value);
				continue;
			}

			else if (key.toLowerCase().contains("providerservice")) {
				returnvar = utils.validateValueinelement(anthemgroupmangeproviderservice, value);
				continue;
			} else if (key.toLowerCase().contains("claimsaddress")) {
				returnvar = utils.validateValueinelement(anthemgroupmangeclaimaddress, value);
				continue;
			}

			else
				err.logcommonMethodError("Member Composite",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if (returnvar) {
			System.out.println("Anthem group management info checked Successfully");
			return true;
		} else {
			int tot_i = productinformationDetails.length;
			err.logcommonMethodError("Member Composite", "the value " + productinformationDetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}
	}

//Emplyer group Contacts

	@FindBy(xpath = "//div[@title='Disclose Employer Group Contacts']")
	WebElement emplyergroupExpandIcon;

	@FindBy(xpath = "//span[text()='Employer Group Contacts']")
	WebElement emplyergroupTab;

	public boolean clickEmployerGroupContacts() throws Exception {
		if (!utils.isProxyWebelement(emplyergroupExpandIcon)) {
			blogger.loginfo("Emplyer Group contacts is collapsed by default");
			if (utils.clickAnelemnt(emplyergroupTab, "Member Composite", "Member Tab"))
				if (waitforpageload())
					return true;
			return false;
		}
		return false;
	}

	@FindBy(xpath = "//div[@node_name='EmployerGroupAdmin']/parent::div//table[@id='gridLayoutTable']")
	WebElement employerGroupContactTable;

	@FindBy(xpath = "//div[contains(@datasource,'AddressList_Group')]//parent::div//table[@id='gridLayoutTable']")
	WebElement employerGroupAddress;

	@FindBy(xpath = "//div[contains(@datasource,'GroupPhoneList_Group')]/parent::div//table[@id='gridLayoutTable']")
	WebElement employerGroupPhoneNumbers;

	public boolean verifyEmployerGroupContact(String args[]) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", employerGroupContactTable);
			return utils.validatetablerowbasedonvalues(employerGroupContactTable, args);
		} catch (Exception ex) {
			blogger.loginfo("Failed to validate Employer Group Contact details");
			return false;
		}

	}

	public boolean verifyEmployerGroupAddresses(String args[]) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", employerGroupAddress);
			return utils.validatetablerowbasedonvalues(employerGroupAddress, args);
		} catch (Exception ex) {
			blogger.loginfo("Failed to validate Employer Group Address details");
			return false;
		}

	}

//PRODUCT OR ENTITY

	@FindBy(xpath = "//div[@title='Disclose Product or Entity Contacts']")
	WebElement productEntityExpandIcon;

	@FindBy(xpath = "//span[text()='Product or Entity Contacts']")
	WebElement productEntityTab;

	public boolean clickProductOrEntityContacts() throws Exception {
		if (!utils.isProxyWebelement(productEntityExpandIcon)) {
			blogger.loginfo("Product or Entity contacts is collapsed by default");
			if (utils.clickAnelemnt(productEntityTab, "Member Composite", "Group Tab"))
				if (waitforpageload())
					return true;
			return false;
		}
		return false;
	}

	@FindBy(xpath = "//div[@node_name='ProductGroupContract']/parent::div//table[@id='gridLayoutTable']")
	WebElement productGroupContactTable;

	@FindBy(xpath = "//div[contains(@datasource,'SubGroupAddressList_GroupDetailsInformation')]//table[@class='gridTable ']")
	WebElement productrGroupAddress;

	@FindBy(xpath = "//div[contains(@datasource,'SubGroupPhoneList_GroupDetailsInformation')]//table[@class='gridTable ']")
	WebElement productGroupPhoneNumbers;

	public boolean verifyProductGroupContact(String args[]) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", productGroupContactTable);
			return utils.validatetablerowbasedonvalues(productGroupContactTable, args);
		} catch (Exception ex) {
			blogger.loginfo("Failed to validate Product Group Contact details");
			return false;
		}

	}

	public boolean verifyProductGroupAddresses(String args[]) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", productrGroupAddress);
			return utils.validatetablerowbasedonvalues(productrGroupAddress, args);
		} catch (Exception ex) {
			blogger.loginfo("Failed to validate Employer Group Address details");
			return false;
		}

	}

	public boolean verifyProductGroupPhoneNumbers(String args[]) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", productGroupPhoneNumbers);
			return utils.validatetablerowbasedonvalues(productGroupPhoneNumbers, args);
		} catch (Exception ex) {
			blogger.loginfo("Failed to validate Product Group Phone details");
			return false;
		}

	}

//BROKER INFORMATION

//div[@aria-label='Hide Broker Information']/../..//label[@for='BrokerName']/parent::div//div

	@FindBy(xpath = "//div[@title='Disclose Broker Information']")
	WebElement brokerInforExpandIcon;

	@FindBy(xpath = "//span[text()='Broker Information']")
	WebElement brokerInforInfoTab;

	public boolean clickBrokerInformation() throws Exception {
		if (!utils.isProxyWebelement(brokerInforExpandIcon)) {
			blogger.loginfo("Broker Information is collapsed by default");
			if (utils.clickAnelemnt(brokerInforInfoTab, "Member Composite", "Member Tab"))
				if (waitforpageload())
					return true;
			return false;
		}
		return false;
	}

//Broker fields

	@FindBy(xpath = "//div[@aria-label='Hide Broker Information']/../..//label[@for='BrokerName']/parent::div//div")
	WebElement brokerInfoName;

	@FindBy(xpath = "//div[@aria-label='Hide Broker Information']/../..//label[@for='BrokerTaxID']/parent::div//div")
	WebElement brokerInfotaxid;

	@FindBy(xpath = "//div[@aria-label='Hide Broker Information']/../..//label[@for='BrokerEncryptedID']/parent::div//div")
	WebElement brokerInfoEncryptedId;

	@FindBy(xpath = "//div[@aria-label='Hide Broker Information']/../..//label[@for='BrokerEmail']/parent::div//div")
	WebElement brokerInfoEmail;

	public boolean verifyBrokerFields(String[] productinformationDetails) throws Exception {
		boolean returnvar;
		returnvar = true;

		System.out.println("Entered into method");
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", productInformationExpandIcon);

		String keyvaluepair = "";
		for (String iterator : productinformationDetails) {

			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if (key.toLowerCase().contains("brokername")) {
				returnvar = utils.validateValueinelement(brokerInfoName, value);
				continue;
			} else if (key.toLowerCase().contains("taxid")) {
				returnvar = utils.validateValueinelement(brokerInfotaxid, value);
				continue;
			}

			else if (key.toLowerCase().contains("encryptedid")) {
				returnvar = utils.validateValueinelement(brokerInfoEncryptedId, value);
				continue;
			} else if (key.toLowerCase().contains("email")) {
				returnvar = utils.validateValueinelement(brokerInfoEmail, value);
				continue;
			}

			else
				err.logcommonMethodError("Member Composite",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if (returnvar) {
			System.out.println("Broker Information fields checked Successfully");
			return true;
		} else {
			int tot_i = productinformationDetails.length;
			err.logcommonMethodError("Member Composite", "the value " + productinformationDetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath = "//div[contains(@datasource,'AddressList_BrokerAddressList')]//table[@class='gridTable ']")
	WebElement brokerAddress;

	//@FindBy(xpath = "//div[contains(@datasource,'PhoneCommunication_BrokerPhoneList')]//table[@class='gridTable ']")
	@FindBy(xpath = "//*[@pl_prop='.PhoneCommunication']")
	WebElement brokerPhone;

	public boolean validateBrokerAddresses(String args[]) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", brokerAddress);
			return utils.validatetablerowbasedonvalues(brokerAddress, args);
		} catch (Exception ex) {
			blogger.loginfo("Failed to validate broker address details");
			return false;
		}

	}

	public boolean validateBrokerPhoneNumbers(String args[]) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView();", brokerPhone);
			return utils.validatetablerowbasedonvalues(brokerPhone, args);
		} catch (Exception ex) {
			blogger.loginfo("Failed to validate broker phone details");
			return false;
		}

	}
	
	

}
