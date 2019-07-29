package automationLib;

import java.util.ArrayList;
import java.util.Arrays;

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

public class ChatMember {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	@FindBy(id = "PegaGadget1Ifr")
	WebElement Iframeelement;

	WebDriverWait wait;

	public ChatMember() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver
	}

	@FindBy(className = "[Header_nav'][text()=' Phone Call']")
	private WebElement sHeaderPhoneCallTab;

	/**
	 * Radio Buttons with Member Functions
	 */
	@FindBy(xpath = "//*[contains(@id,'MemberSearchTypeSubscriber')]")
	private WebElement rBtnSubscriberSSN;
	@FindBy(id = "MemberSearchTypeMember ID")
	private WebElement rBtnMID;
	@FindBy(id = "MemberSearchTypeName and DOB")
	private WebElement rBtnMNameDOB;
	@FindBy(xpath = "//input[@id='MemberSearchTypeMember SSN']")
	private WebElement rBtnMSearchSSN;
	@FindBy(id = "MemberSearchTypeName and Group")
	private WebElement rBtnMNameGroup;
	@FindBy(id = "$PHCMemberContactList$ppxResults$l1")
	private WebElement firstRowfromtable;
	@FindBy(id = "MemberSearchTypeName and SSN")
	private WebElement rBtnMNameSSN;

	@FindBy(id = "IsContactMemberYes")
	private WebElement rBtnContactMemberYes;
	@FindBy(id = "IsContactMemberNo")
	private WebElement rBtnContactMemberNo;

	@FindBy(xpath = "//table[@pl_prop='HCMemberContactList.pxResults']")
	private WebElement searchResulttable;
	@FindBy(xpath = "//th//div[text()='Select']']")
	private WebElement searchResulttableHeaderselect;

	@FindBy(className = "anthem_theme_header")
	private WebElement sHeaderSearchForMember;

	@FindBy(id = "TCPAResponseAccept")
	WebElement radioBestNumberAccept;
	@FindBy(id = "TCPAResponseDecline")
	WebElement radioDeclineNumberAccept;

	@FindBy(id = "SearchStringMemberID")
	private WebElement txtbxMemberID;
	@FindBy(id = "SearchStringLastName")
	private WebElement txtbxMSearchLastName;
	@FindBy(id = "SearchStringFirstName")
	private WebElement txtbxMSearchFirstName;
	@FindBy(id = "SearchStringDOBText")
	private WebElement txtbxMSearchDOB;
	@FindBy(id = "SearchStringGroupNum")
	private WebElement txtbxMSearchGroupNum;
	@FindBy(id = "SearchStringSSN")
	private WebElement txtbxMSearchSSN;
	@FindBy(id = "SearchStringLast4SSN")
	private WebElement txtbxMSearchLast4SSN;

	@FindBy(id = "Nickname")
	private WebElement txtbxNickName;
	@FindBy(id = "CallBackNumber")
	private WebElement txtbxCallBackNumber;
	@FindBy(id = "CallBackNumExt")
	private WebElement txtbxCallBackNumExt;
	@FindBy(id="ContactEmailID")
	private WebElement txtbxEmailID;

	@FindBy(id = "pyFirstName")
	private WebElement txtbxOtherActionsGuestFirstName;
	@FindBy(id = "GroupName")
	private WebElement txtbxOtherActionsGroupName;
	@FindBy(id = "GuestSSN")
	private WebElement txtbxOtherActionsGuestSSN;
	@FindBy(id = "pyLastName")
	private WebElement txtbxOtherActionsLastName;
	@FindBy(id = "GroupNumber")
	private WebElement txtbxOtherActionsGroupNumber;
	@FindBy(id = "GuestPhoneNumber")
	private WebElement txtbxOtherActionsGuestPhoneNumber;
	@FindBy(id = "DateOfBirthText")
	private WebElement txtbxOtherActionsDateofBirth;

	@FindBy(id = "CcbOperatorId")
	private WebElement txtbxExtrnlSerchCCBOprtorID;
	@FindBy(id = "IQTTrackingNumber")
	private WebElement txtbxExtrnlSerchIQTRequestNo;

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Search']")
	private WebElement btnSearchforMSearch;

	@FindBy(xpath = "//div[contains(text(),'Submit')]")
	private WebElement btnSubmit;
	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Launch CCB']")
	private WebElement btnLaunchCCB;

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()=' Help']")
	private WebElement btnHelp;
	@FindBy(xpath = "//img[@src='webwb/tool_icon_13690228252.png!!.png']")
	private WebElement btnImgTool;

	@FindBy(xpath = "//*[@class='menu-item-title'][text()='View History']")
	private WebElement lnkToolViewHistory;
	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Configuration Tools']")
	private WebElement lnkToolConfigurationTools;

	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Guest Contact']")
	private WebElement lnkOtherActionsGuestContact;
	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Exit Interaction']")
	private WebElement lnkOtherActionExitInteraction;
	@FindBy(xpath = "//*[@class='menu-item-title'][text()='External Search']")
	private WebElement lnkOtherActionExternalSearch;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	@FindBy(className = "anthem_theme_header")
	private WebElement headerForThemePage;

	@FindBy(xpath = "//span[@class='iconRequired Standard_iconRequired'][contains(text(),'Is Contact the')]")
	WebElement labelIscontacttheselected;

	@FindBy(xpath = "//li[contains(text(),'Unable to retrieve data')]")
	private WebElement listunabletofinddata;

	@FindBy(xpath = "//input[@id='CaseOrTaskIcon")
	private WebElement radioSelectContract;

	@FindBy(xpath = "//span[contains(text(),'First Impression')]")
	WebElement firstImpression;

	@FindBy(xpath = "//table[@pl_prop='HCMemberContactList.pxResults']")
	WebElement searchResultsTbl;


	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMemberRow;

	/**
	 * Buttons to click
	 * 
	 * @return
	 */
	public WebElement getrBtnContactMemberYes() {
		return rBtnContactMemberYes;
	}

	public WebElement getrBtnContactMemberNo() {
		return rBtnContactMemberNo;
	}



	/**
	 * Text Boxes
	 * 
	 * @return
	 */
	public WebElement getTxtbxNickName() {
		return txtbxNickName;
	}

	public WebElement getTxtbxCallBackNumber() {
		return txtbxCallBackNumber;
	}

	public WebElement getTxtbxCallBackNumExt() {
		return txtbxCallBackNumExt;
	}

	public WebElement getTxtbxEmailID() {
		return txtbxEmailID;
	}


	public WebElement getTxtbxOtherActionsGuestFirstName() {
		return txtbxOtherActionsGuestFirstName;
	}

	public WebElement getTxtbxOtherActionsGroupName() {
		return txtbxOtherActionsGroupName;
	}

	public WebElement getTxtbxOtherActionsGuestSSN() {
		return txtbxOtherActionsGuestSSN;
	}

	public WebElement getTxtbxOtherActionsLastName() {
		return txtbxOtherActionsLastName;
	}

	public WebElement getTxtbxOtherActionsGroupNumber() {
		return txtbxOtherActionsGroupNumber;
	}

	public WebElement getTxtbxOtherActionsGuestPhoneNumber() {
		return txtbxOtherActionsGuestPhoneNumber;
	}

	public WebElement getTxtbxOtherActionsDateofBirth() {
		return txtbxOtherActionsDateofBirth;
	}

	/**
	 * Buttons to Click
	 * 
	 * @return
	 */
	public WebElement getBtnSearchforMSearch() {
		return btnSearchforMSearch;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getBtnLaunchCCB() {
		return btnLaunchCCB;
	}

	public WebElement getBtnHelp() {
		return btnHelp;
	}

	public WebElement getBtnImgTool() {
		return btnImgTool;
	}

	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}

	/**
	 * Header
	 * 
	 * @return
	 */
	public WebElement getHeaderForThemePage() {
		return headerForThemePage;
	}

	public void setsPhoneCallTab(WebElement sPhoneCallTab) {
		this.sHeaderPhoneCallTab = sPhoneCallTab;
	}

	/**
	 * Getters Functions
	 * 
	 * @return
	 */

	public WebElement gettxtbxMembeID() {
		return txtbxMemberID;
	}

	public WebElement getsPhoneCallTab() {
		return sHeaderPhoneCallTab;
	}

	public WebElement getrBtnSubscriberSSN() {
		return rBtnSubscriberSSN;
	}

	public WebElement getrBtnMID() {
		return rBtnMID;
	}

	public WebElement getrBtnMNameDOB() {
		return rBtnMNameDOB;
	}

	public WebElement getrBtnMSearchSSN() {
		return rBtnMSearchSSN;
	}

	public WebElement getrBtnMNameGroup() {
		return rBtnMNameGroup;
	}

	public WebElement getrBtnMNameSSN() {
		return rBtnMNameSSN;
	}

	/**
	 * Text boxes to Click
	 * 
	 */

	public WebElement getTxtbxMemberID() {
		return txtbxMemberID;
	}

	public WebElement getTxtbxMSearchLastName() {
		return txtbxMSearchLastName;
	}

	public WebElement getTxtbxMSearchFirstName() {
		return txtbxMSearchFirstName;
	}

	public WebElement getTxtbxMSearchDOB() {
		return txtbxMSearchDOB;
	}

	public WebElement getTxtbxMSearchGroupNum() {
		return txtbxMSearchGroupNum;
	}

	public WebElement getTxtbxMSearchSSN() {
		return txtbxMSearchSSN;
	}

	public WebElement getTxtbxMSearchLast4SSN() {
		return txtbxMSearchLast4SSN;
	}

	public WebElement gettblSearchresult() {
		return this.searchResulttable;
	}

	public WebElement gettblSearchresultheaderselect() {
		return this.searchResulttableHeaderselect;
	}

	/**
	 * Suscribe SSN text box , only one entry required
	 * 
	 * @param sMemberSuscriberSNN:
	 *            Enter Text for Suscriber SSN
	 * @return
	 */
	public boolean searchByChatSuscriberSSN(String[] sMemberSuscriberSNN) {
		if (getHeaderforTabsVerification("Search for Member")) 
			if (this.clickrbtnMSuscriberID()) 
				if (setMSearchSN(sMemberSuscriberSNN[0])) 
					return clickMSearch();
		return false;
	}

	/**
	 * Filling in the Text Boxes and clicking on Buttons
	 * 
	 * Here if the details are not put in correct so a Pop up appears which is to be
	 * handles.
	 */

	public boolean clickMSubmit() {
		return utils.clickAnelemnt(this.getBtnSubmit(), "Phone Call", "Submit");

	}

	public WebElement getLnkOtherActionsGuestContact() {
		return lnkOtherActionsGuestContact;
	}

	/**
	 * Click on Search Button
	 * 
	 * @return
	 */
	public boolean clickMSearch() {
		if(utils.clickAnelemnt(this.getBtnSearchforMSearch(), "Phone Call", "Button Search")) {
			utils.waitforpageload();
			return !utils.isProxyWebelement(this.firstRowfromtable);
		}
		return false;
	}

	/**
	 * Set Suscribe Button Field
	 * 
	 * @param sSuscriberID:
	 *            Suscribe no.
	 */
	public boolean setSuscriberID(String sSuscriberID) {
		return utils.enterTextinAnelemnt(this.gettxtbxMembeID(), sSuscriberID, "Chat", "Text Box SubscriberID");

	}

	/**
	 * Enter Last Name in the Field
	 * 
	 * @param sSuscriberID:
	 */
	public boolean setSearchLastName(String sLastName) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLastName(), sLastName, "Chat", "Text Box Last Name");

	}

	/**
	 * Enter Firts NAme
	 * 
	 * @param sFirstName:
	 *            give name as parameter
	 * @return
	 */
	public boolean setTxtbxMSearchFirstName(String sFirstName) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchFirstName(), sFirstName, "Chat", "Text Box First Name");
	}

	/**
	 * 
	 * @param sDOB:
	 *            Date of Birth in
	 * @return
	 */
	public boolean setTxtbxMSearchDOB(String sDOB) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchDOB(), sDOB, "Chat", "Text Box DOB");

	}

	public boolean setMGroupNum(String sSuscriberID) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchGroupNum(), sSuscriberID, "Chat", "Text Box Group Name");
	}

	public boolean setMSearchLast4SSNDOB(String sSuscriberID) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchDOB(), sSuscriberID, "Chat", "Text Box LDOB");

	}

	public boolean setMSearchLast4SSNFirstName(String sSuscriberID) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchFirstName(), sSuscriberID, "Chat", "Text Box First Name");

	}

	public boolean setMSearchLast4SSNLastNAme(String sSuscriberID) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLastName(), sSuscriberID, "Chat", "Text Box Last Name");

	}

	public boolean setMSearchSN(String sSuscriberID) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchSSN(), sSuscriberID, "Chat", "Text Box SSN");
	}

	public boolean setMSearchLast4SSN(String sSuscriberID) {
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLast4SSN(), sSuscriberID, "Chat", "Text Box Last 4 SSN");

	}

	public boolean setMNickname(String snickName) {
		return utils.enterTextinAnelemnt(this.getTxtbxNickName(), snickName, "Chat", "Text Box NickName");

	}

	public boolean setMCallBackNumber(String scallBackNumber) {
		return utils.enterTextinAnelemnt(this.getTxtbxCallBackNumber(), scallBackNumber, "Chat",
				"Text Box Call Back No.");

	}

	public boolean setTxtbxEmailID(String txtbxEmailID) {
		return utils.enterTextinAnelemnt(this.getTxtbxEmailID(), txtbxEmailID, "Chat", "Email ID");
	}

	/**
	 * Click on Radio Button
	 */
	public boolean clickrbtnMemberID() {
		return utils.clickAnelemnt(this.getrBtnMID(), PhoneCallMembersearchMember.class.getName(), "Radio MemberId");

	}

	public boolean clickrBtnMNameDOB() {
		return utils.clickAnelemnt(this.getrBtnMNameDOB(), "ChatMember", "Radio Button Name&DOB");

	}

	/**
	 * Click on Yes and then click Yes on the Alert with that
	 * 
	 * @return
	 */
	public boolean clickrbtnChatMemberContactmemberYes() {
		if (this.rBtnContactMemberYes.isDisplayed())
			utils.clickAnelemnt(this.getrBtnContactMemberYes(), "ChatMember", "Radio Button for Contact Member yes");
		else {
			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("window.scrollBy(0,900)", "");
			utils.clickAnelemnt(this.getrBtnContactMemberYes(), "ChatMember", "Radio Button for Contact Member yes");
		}
		return utils.clickAnelemnt(this.labelIscontacttheselected, "ChatMember", "nickname");
	}

	public boolean clickrbtnChatMemberContactmemberNo() {
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("window.scrollBy(0,450)", "");
		if(utils.clickAnelemnt(this.getrBtnContactMemberNo(), "ChatMember", "Radio Button for Contact Member no"))
			return utils.clickAnelemnt(this.txtbxNickName, "ChatMember", "nickname");
		return false;
	}

	public boolean clickrbtnMSuscriberID() {
		return utils.clickAnelemnt(this.getrBtnSubscriberSSN(), "ChatMember", "Radio Buttoon  subscriberSSN");

	}

	public boolean clickrbtnMSearchSSN() {
		return utils.clickAnelemnt(this.getrBtnMSearchSSN(), "ChatMember", "Radio Button MemberSSN");

	}

	public boolean clickrbtnMNameGroup() {
		return utils.clickAnelemnt(this.getrBtnMNameGroup(), "ChatMember", "Radio Button name&group");

	}

	public boolean clickrbtnMNameSSN() {
		return utils.clickAnelemnt(this.getrBtnMNameSSN(), "ChatMember", "Radio Button MemberName&SSN");

	}

	public boolean clickbtnOtherActions() {
		return utils.clickAnelemnt(this.getBtnOtherActions(), "ChatMember", "Other actions button");
	}

	public boolean clicklinkexitInteraction() {
		return utils.clickAnelemnt(this.lnkOtherActionExitInteraction, "ChatMember", "Other Exitinteraction");
	}

	public boolean clicklinkGuestContact() {
		return utils.clickAnelemnt(this.getLnkOtherActionsGuestContact(), "ChatMember", "Other GuestContacts");
	}

	public boolean getHeaderforTabsVerification(String sHeader) {
		if (sHeader.contains(sHeaderSearchForMember.getText())) {
			System.out.println("The text matches ");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * MEmber ID entry in page to enter the value and check the result only one
	 * entry is required
	 * 
	 * @param sMemberID
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchbyMemberID(String[] sMemberID) throws InterruptedException {
		if (getHeaderforTabsVerification("Search for Member")) {
			String value = sMemberID[0].substring(sMemberID[0].indexOf(":") + 1);
			if (this.clickrbtnMemberID()) {
				if (this.setSuscriberID(value)) {
					if (this.clickMSearch()) {
						utils.waitforpageload();
						return !utils.isServiceDown();
					} 
				}
			}
		}		
		return false;
	}

	/**
	 * Suscribe SSN text box , only one entry required
	 * 
	 * @param sMemberSuscriberSNN:
	 *            Enter Text for Suscriber SSN
	 * @return
	 */

	public boolean searchBySuscriberSSN(String[] sMemberSuscriberSNN) {
		if (getHeaderforTabsVerification("Search for Member")) 
			if (this.clickrbtnMSuscriberID()) 
				if (setMSearchSN(sMemberSuscriberSNN[0])) 
					if (clickMSearch()) 
						if (this.isSearchsuccess()) 
							return true;		
		return false;
	}

	/**
	 * Search through SNN Last name, DOB and First name , 3
	 * 
	 * @param sLastName
	 * @param sFirstName
	 * @param sDOB
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchByNameandDOB(String[] sData) throws InterruptedException {
		if (getHeaderforTabsVerification("Search for Member")) 
			if (this.clickrBtnMNameDOB()) {
				wait = new WebDriverWait(Driver.pgDriver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringFirstName")));
				if (setMSearchLast4SSNLastNAme(sData[0])) 
					if (setMSearchLast4SSNFirstName(sData[1])) 
						if (setMSearchLast4SSNDOB(sData[2])) 
							if (clickMSearch()) 
								if (this.isSearchsuccess()) 
									return true;
			}
		return false;

	}

	/*
	 * @SCU #CommonMethodwithArgument:searchByMemberSSN #Arguments:MemberSSN
	 * Type:Textbox
	 * 
	 * 
	 */
	public boolean searchByMemberSSN(String[] sMemberSNN) {
		if (getHeaderforTabsVerification("Search for Member"))
			if (this.clickrbtnMSearchSSN()) {
				wait = new WebDriverWait(Driver.pgDriver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringSSN")));
				if (setMSearchSN(sMemberSNN[0])) 
					if (clickMSearch()) 
						if (this.isSearchsuccess()) 
							return true;
			}
		return false;
	}

	/**
	 * Enter the values accoring to Nqame and Group
	 * 
	 * @param sLastName
	 * @param sFirstName
	 * @param sGroupName
	 * @return
	 */
	public boolean searchByNameandGroup(String[] sData) {

		if (getHeaderforTabsVerification("Search for Member")) 
			if (this.clickrbtnMNameGroup()) {
				wait = new WebDriverWait(Driver.pgDriver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringFirstName")));
				if (setMSearchLast4SSNLastNAme(sData[0])) 
					if (setMSearchLast4SSNFirstName(sData[1]))
						if (setMGroupNum(sData[2])) 
							if (clickMSearch())
								if (this.isSearchsuccess()) 
									return true;
			}
		return false;
	}

	/**
	 * Search through NAme and Group NAme
	 * 
	 * @param sLastName
	 *            : Last Name
	 * @param sFirstName:
	 *            first Name
	 * @param sGroupName:
	 *            Group name
	 * @return
	 */
	public boolean searchByNameandSSN(String[] sData) {

		if (getHeaderforTabsVerification("Search for Member")) 
			if (this.clickrbtnMNameSSN()) {
				wait = new WebDriverWait(Driver.pgDriver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringLast4SSN")));
				if (setMSearchLast4SSNLastNAme(sData[0])) 
					if (setMSearchLast4SSNFirstName(sData[1])) 
						if (setMSearchLast4SSN(sData[2])) 
							if (clickMSearch()) 
								if (this.isSearchsuccess()) 
									return true;
			}
		return false;
	}

	@FindBy(className = "pageErrorList layout-noheader-errors")
	WebElement searchUnabletoretrivedata;

	public WebElement getsearchnosuccessError() {
		return this.searchUnabletoretrivedata;
	}

	/**
	 * To check if the error is appearing or not
	 * 
	 * @return
	 */
	public boolean isSearchsuccess() {
		if (!utils.isProxyWebelement(this.getsearchnosuccessError())) {
			if (this.getsearchnosuccessError().isDisplayed()) {
				return false;
			}
		}
		return true;

	}

	/**
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectMemberbyFirstName(String[] args) throws InterruptedException {
		String value = args[0].substring(args[0].indexOf(":") + 1);
		System.out.println(args[0] + "       " + value);
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn = getsearchResultbyColumn("First Name");
		String[] valuetobechose = { "First Name:" + args[0] };
		return utils.clickontablerowbasedonvalues(this.searchResulttable, valuetobechose);
	}

	public boolean selectMemberbyMultipleValues(String[] args) throws InterruptedException {
		return utils.clickontablerowbasedonvalues(this.searchResulttable, args);

	}


	/*
	 * @SCU #CommonMethodwithoutArgument:fillNicknameandextension Type:Textbox
	 * 
	 * 
	 */
	public boolean fillNicknameandCallbacknumber() {
		int a = 1;
		try {
			a++;
			if (this.setMNickname("Nickname"))
				return this.setMCallBackNumber("1234567890");
		} catch (Exception e) {
			if (a > 1) 
				return fillNicknameandCallbacknumber();
		}
		return false;
	}

	public boolean acceptbestphone() {
		utils.waitforpageload();
		return utils.clickAnelemnt(this.radioBestNumberAccept, "ChatMember", "Accept best phone radio");
	}

	public boolean declinebestphone() {
		return utils.clickAnelemnt(this.radioDeclineNumberAccept, "ChatMember", "Decline best phone radio");
	}

	public boolean fillNicknameAndCallbacknumber(String[] args) {
		if (this.setMNickname(args[0]))
			if (this.setMCallBackNumber(args[1]))
				return true;
		return false;
	}


	public boolean fillEMailID(String[] email)
	{
		return setTxtbxEmailID(email[0]);
	}

	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT']/following::table[@pl_prop='HCMemberContactList.pxResults']")
	WebElement searchResultTable;
	
	public boolean verifyMemberSearchResults(String[] args)
	{
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(searchResultTable, args);
	}
	

	/*
	 * @SCU #CommonMethodwithArgument:selectContractMemberandSubmit
	 * #Arguments:Yes/No Type:Textbox
	 * 
	 * 
	 */
	public boolean selectContractMemberandSubmit(String[] args) {
		PhoneCallMembersearchMember.isHippaAuthverified=false;
		if ((args[0]).trim().equalsIgnoreCase("yes")) {
			if (this.clickrbtnChatMemberContactmemberYes()) {
				PhoneCallMembersearchMember.isSelectedMember="Yes";
			return clickMSubmit();
			
		} else if ((args[0]).trim().equalsIgnoreCase("no")) {
			if (this.clickrbtnChatMemberContactmemberNo()) {
				PhoneCallMembersearchMember.isSelectedMember="No";
			return clickMSubmit();
			}
		}
		}
		return false;
	}

	public ArrayList<String> getsearchResultbyColumn(String columnName) {
		ArrayList<String> returnColumn = new ArrayList<String>();
		returnColumn = utils.getcolumnStringFromTableByName(this.gettblSearchresult(), columnName);
		return returnColumn;
	}

	public boolean clickselectColumnRadioButton(int row) {
		ArrayList<WebElement> select = utils.getcolumnWebelemntFromTable(this.gettblSearchresult(),
				"input");
		return utils.clickAnelemnt(select.get(row), "ChatMember", "resutlt table radio");
	}

	public boolean exitInteraction() {
		if (this.clickbtnOtherActions())
			return this.clicklinkexitInteraction();
		return false;

	}

	/**
	 * Guest Contacts Navigation from Phone Call members
	 * 
	 * @return
	 */
	public boolean guestContacts() {
		if (this.clickbtnOtherActions())
			return this.clicklinkGuestContact();
		return false;
	}

	public boolean pagenavigate(String[] page) {
		if (page[0].toLowerCase().contains("back")) {
			utils.gotoback();
			return true;
		} else if (page[0].toLowerCase().contains("forward")) {
			utils.goforward();
			return true;
		}
		if (page[0].toLowerCase().contains("refresh")) {
			utils.refreshthepage();
			return true;
		} else
			return false;

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectfirstMember
	 * #Description: This functionality selects the first member row in the member search result table.
	 * Type: Textbox
	 */
	public boolean selectfirstMember(){
		if(utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -firstRowofselectMembertable"))
			return utils.clickAnelemnt(btnSubmit, "SelectMember", "Submit");
		return false;
	}

	/**This method is to search member, select first member, fill Nickname and call back number and click on submit
	 * @throws InterruptedException 
	 * 
	 */
	public boolean searchAndSubmitChatMember(String[] args) throws InterruptedException {
		try {
			boolean flag = false;
			String[] value = args[2].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			if(searchbyMemberID(memberid)) {
				int i = utils.getIndexValueOfStringArray(value,"MemberFirstName");
				if(i != 0) {
					String[] firstname = value[i].substring(value[i].indexOf(":")+1).split(",");
					flag = selectMemberbyFirstName(firstname);
				}else {
					flag = selectfirstMember();
				}
				if(flag) {
					String[] email = {"Test@gmail.com"};
					if(fillNicknameandCallbacknumber())
						if(fillEMailID(email))
							if(acceptbestphone())
								if(clickrbtnChatMemberContactmemberYes()) 
									if(selectHIPAAverificationDetails()) {
										WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
										((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
										utils.scrolltomiddle();
										return utils.clickAnelemnt(btnSubmit, "Phone Call", "Submit");
									}


				}
			}
			return false;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			String[] value = args[1].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			if(searchbyMemberID(memberid)) {
				String[] email = {"Test@gmail.com"};
				if(fillNicknameandCallbacknumber())
					if(fillEMailID(email))
						if(acceptbestphone())
							if(clickrbtnChatMemberContactmemberYes())
								if(selectfirstMember()) 
									if(selectHIPAAverificationDetails()) {
										WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
										((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
										utils.scrolltomiddle();
										return utils.clickAnelemnt(btnSubmit, "Phone Call", "Submit");
									}
			}
			return false;
		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}
	}

	@FindBy(id="IsMemberIDVerified")
	WebElement chckBxMemberId;

	@FindBy(id="IsMemberNameVerified")
	WebElement chckBxName;

	@FindBy(id="IsDateOfBirthVerified")
	WebElement chckBxDOB;

	public boolean selectHIPAAverificationDetails()
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.chckBxName, "PhoneCallMemberSearchMember", "Member name verify checkbox"))
			if(utils.clickAnelemnt(this.chckBxDOB, "PhoneCallMemberSearchMember", "Member DOB verify checkbox"))
				if(chckBxName.isSelected() && chckBxMemberId.isSelected() && chckBxDOB.isSelected())
					return true;
				else {
					if(!chckBxName.isSelected())
						utils.clickAnelemnt(this.chckBxName, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					if(!chckBxMemberId.isSelected())
						utils.clickAnelemnt(this.chckBxMemberId, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					if(!chckBxDOB.isSelected())
						utils.clickAnelemnt(this.chckBxDOB, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					return chckBxName.isSelected() && chckBxMemberId.isSelected() && chckBxDOB.isSelected();
				}

		return false;

	}



}
