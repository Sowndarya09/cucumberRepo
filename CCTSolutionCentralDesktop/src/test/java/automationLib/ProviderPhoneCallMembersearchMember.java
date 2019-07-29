package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ProviderPhoneCallMembersearchMember extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	public ProviderPhoneCallMembersearchMember()

	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		gotoLastIframe();//
	}

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForMember;
	private String sDDReasonforExitname= "$PpyWorkPage$pCancelReason"; 
	private String sDDReasonforExitid= "CancelReason"; 
	private String sCCBLocationNamename="$PpyWorkPage$pCcbLocationName";
	private String sCCBLocationNameid="CcbLocationName";

	/**
	 * 
	 * Webelements to be used in program
	 */
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;


	@FindBy(className="[Header_nav'][text()=' Phone Call']")
	private WebElement sHeaderPhoneCallTab;


	/**
	 * Radio Buttons with Member Functions 
	 */
	@FindBy(xpath="//*[contains(@id,'MemberSearchTypeSubscriber')]")
	private WebElement rBtnSubscriberSSN;
	@FindBy(id="MemberSearchTypeMember ID")
	private WebElement rBtnMID;
	@FindBy(id="MemberSearchTypeName and DOB")
	private WebElement rBtnMNameDOB;
	@FindBy(xpath="//input[@id='MemberSearchTypeMember SSN']")
	private WebElement rBtnMSearchSSN;
	@FindBy(id="MemberSearchTypeName and Group")
	private WebElement rBtnMNameGroup;
	@FindBy(id="MemberSearchTypeName and SSN")
	private WebElement rBtnMNameSSN;

	@FindBy(id="IsContactMemberYes")
	private WebElement rBtnContactMemberYes;
	@FindBy(id="IsContactMemberNo")
	private WebElement rBtnContactMemberNo;

	@FindBy(xpath="//*[@class='gridTable ']")
	private WebElement searchResulttable;

	@FindBy(xpath="//th//div[text()='Select']']")
	private WebElement searchResulttableHeaderselect;

	@FindBy(id="TCPAResponseAccept")
	WebElement radioBestNumberAccept;
	@FindBy(id="TCPAResponseDecline")
	WebElement radioDeclineNumberAccept;
	/**
	 * Text Boxed
	 */
	@FindBy (id="SearchStringMemberID")	
	private WebElement txtbxMemberID;
	@FindBy (id="SearchStringLastName")	
	private WebElement txtbxMSearchLastName;
	@FindBy (id="SearchStringFirstName")	
	private WebElement txtbxMSearchFirstName;
	@FindBy (id="SearchStringDOBText")	
	private WebElement txtbxMSearchDOB;
	@FindBy (id="SearchStringGroupNum")	
	private WebElement txtbxMSearchGroupNum;
	@FindBy (id="SearchStringSSN")	
	private WebElement txtbxMSearchSSN;
	@FindBy (id="SearchStringLast4SSN")	
	private WebElement txtbxMSearchLast4SSN;

	@FindBy (id="Nickname")	
	private WebElement txtbxNickName;
	@FindBy (id="CallBackNumber")	
	private WebElement txtbxCallBackNumber;
	@FindBy (id="CallBackNumExt")	
	private WebElement txtbxCallBackNumExt;
	@FindBy (id="pyFirstName")	
	private WebElement txtbxOtherActionsGuestFirstName;
	@FindBy (id="GroupName")	
	private WebElement txtbxOtherActionsGroupName;
	@FindBy (id="GuestSSN")	
	private WebElement txtbxOtherActionsGuestSSN;
	@FindBy (id="pyLastName")	
	private WebElement txtbxOtherActionsLastName;
	@FindBy (id="GroupNumber")	
	private WebElement txtbxOtherActionsGroupNumber;
	@FindBy (id="GuestPhoneNumber")	
	private WebElement txtbxOtherActionsGuestPhoneNumber;
	@FindBy (id="DateOfBirthText")	
	private WebElement txtbxOtherActionsDateofBirth;

	@FindBy (id="CcbOperatorId")	
	private WebElement txtbxExtrnlSerchCCBOprtorID;
	@FindBy (id="IQTTrackingNumber")	
	private WebElement txtbxExtrnlSerchIQTRequestNo;




	/**
	 * Buttons to be used 
	 */
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Search']")	
	private WebElement btnSearchforMSearch;

	@FindBy (xpath="//button[@title='Complete this assignment']")	
	private WebElement btnSubmit;
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Launch CCB']")	
	private WebElement btnLaunchCCB;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;
	@FindBy (xpath="//img[@src='webwb/tool_icon_13690228252.png!!.png']")	
	private WebElement btnImgTool;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Guest Contact']")	
	private WebElement lnkOtherActionsGuestContact;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement lnkOtherActionExitInteraction;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='External Search']")	
	private WebElement lnkOtherActionExternalSearch;

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	@FindBy (className="anthem_theme_header")	
	private WebElement headerForThemePage;

	@FindBy(xpath="//span[@class='iconRequired Standard_iconRequired'][contains(text(),'Is Contact the')]")
	WebElement  labelIscontacttheselected;
	@FindBy (xpath="//li[contains(text(),'Unable to retrieve data')]")
	private WebElement listunabletofinddata;

	@FindBy(xpath="//input[@id='CaseOrTaskIcon")
	private WebElement radioSelectContract;

	/**
	 * Check DropDown name 
	 * @return
	 */
	public String getsDDReasonforExitname() {
		return sDDReasonforExitname;
	}
	public String getsDDReasonforExitid() {
		return sDDReasonforExitid;
	}
	public String getsCCBLocationNamename() {
		return sCCBLocationNamename;
	}
	public String getsCCBLocationNameid() {
		return sCCBLocationNameid;
	}


	/**
	 * Buttons to click 
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
	 * Click on Link
	 * @return
	 */
	public WebElement getLnkToolViewHistory() {
		return lnkToolViewHistory;
	}
	public WebElement getLnkToolConfigurationTools() {
		return lnkToolConfigurationTools;
	}
	public WebElement getLnkOtherActionsGuestContact() {
		return lnkOtherActionsGuestContact;
	}
	public WebElement getLnkOtherActionExitInteraction() {
		return lnkOtherActionExitInteraction;
	}
	public WebElement getLnkOtherActionExternalSearch() {
		return lnkOtherActionExternalSearch;
	}

	/**
	 * Header 
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
	 * @param sMemberSuscriberSNN: Enter Text for Suscriber SSN
	 * @return
	 */
	public boolean searchByPhoneCallSuscriberSSN(String[] sMemberSuscriberSNN)
	{

		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMSuscriberID())
				if(setMSearchSN(sMemberSuscriberSNN[0]))
					return clickMSearch();
		return false;
	}


	/**
	 * Filling in the Text Boxes and clicking on Buttons
	 * 
	 * Here if the details are not put in correct so a Pop up appears which is to be handles. 
	 */

	public boolean clickMSubmit()
	{
		if(utils.clickAnelemnt(this.getBtnSubmit(), "Phone Call", "Submit"))
		{
			try{

			}
			catch(Exception e)
			{
				try
				{
					Driver.pgDriver.switchTo().alert().accept();

				}
				catch(Exception e1){
					System.out.println("Either an error or Some Mandatory fields were not entered");
					return false;

				}
				return false;
			}

		}

		return true;
	}


	/**
	 * Click on Search Button 
	 * @return
	 */
	public boolean clickMSearch()
	{
		return utils.clickAnelemnt(this.getBtnSearchforMSearch(), "Phone Call", "Button Search");
	}
	/**
	 * Set Suscribe Button Field 
	 * @param sSuscriberID: Suscribe no. 
	 */
	public boolean setSuscriberID(String sSuscriberID)
	{
		return utils.enterTextinAnelemnt(this.gettxtbxMembeID(), sSuscriberID, "Phone Call", "Text Box SubscriberID");

	}

	/**
	 * Enter Last Name in the Field 
	 * @param sSuscriberID: 
	 */
	public boolean setSearchLastName(String sLastName)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLastName(), sLastName, "Phone Call", "Text Box Last Name");

	}
	/**
	 * Enter Firts NAme 
	 * @param sFirstName: give name as parameter
	 * @return
	 */
	public boolean setTxtbxMSearchFirstName(String sFirstName)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchFirstName(), sFirstName, "Phone Call", "Text Box First Name");
	}

	/**
	 * 
	 * @param sDOB: Date of Birth in
	 * @return
	 */
	public boolean setTxtbxMSearchDOB(String sDOB)
	{

		return utils.enterTextinAnelemnt(this.getTxtbxMSearchDOB(), sDOB, "Phone Call", "Text Box DOB");

	}
	public boolean setMGroupNum(String sSuscriberID)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchGroupNum(), sSuscriberID, "Phone Call", "Text Box Group Name");
	}
	public boolean setMSearchLast4SSNDOB(String sSuscriberID)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchDOB(), sSuscriberID, "Phone Call", "Text Box LDOB");

	}
	public boolean setMSearchLast4SSNFirstName(String sSuscriberID)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchFirstName(), sSuscriberID, "Phone Call", "Text Box First Name");

	}
	public boolean setMSearchLast4SSNLastNAme(String sSuscriberID)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLastName(), sSuscriberID, "Phone Call", "Text Box Last Name");

	}
	public boolean setMSearchSN(String sSuscriberID)
	{
		try{
			return utils.enterTextinAnelemnt(this.getTxtbxMSearchSSN(), sSuscriberID, "Phone Call", "Text Box SSN");
		}
		catch(Exception e)
		{
			System.out.println(e+" Exception occured. Retrying");
			return utils.enterTextinAnelemnt(this.getTxtbxMSearchSSN(), sSuscriberID, "Phone Call", "Text Box SSN");
		}
	}
	public boolean setMSearchLast4SSN(String sSuscriberID)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLast4SSN(), sSuscriberID, "Phone Call", "Text Box Last 4 SSN");

	}

	public boolean setMNickname(String snickName)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxNickName(), snickName, "Phone Call", "Text Box NickName");

	}

	public boolean setMCallBackNumber(String scallBackNumber)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxCallBackNumber(), scallBackNumber, "Phone Call", "Text Box Call Back No.");

	}


	/**
	 * Click on Radio Button 
	 */
	public boolean clickrbtnMemberID()
	{
		return utils.clickAnelemnt(this.getrBtnMID(), PhoneCallMembersearchMember.class.getName(), "Radio MemberId");


	}


	public boolean clickrBtnMNameDOB()
	{
		return utils.clickAnelemnt(this.getrBtnMNameDOB(), "PhoneCallMember-Searchmember", "Radio Button Name&DOB");

	}




	/**
	 * Click on Yes and then click Yes on the Alert with that 
	 * @return
	 */
	public boolean clickrbtnPhoneMemberContactmemberYes()
	{
		if(this.rBtnContactMemberYes.isDisplayed())
			utils.clickAnelemnt(this.getrBtnContactMemberYes(), "Phone Call", "Radio Button for Contact Member yes");
		else
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("window.scrollBy(0,900)","");
			utils.clickAnelemnt(this.getrBtnContactMemberYes(), "Phone Call", "Radio Button for Contact Member yes");
		}
		return utils.clickAnelemnt(this.labelIscontacttheselected, "Phonecall", "nickname");
	}

	public boolean clickrbtnPhoneMemberContactmemberNo()
	{
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("window.scrollBy(0,450)","");
		if(utils.clickAnelemnt(this.getrBtnContactMemberNo(), "Phone Call", "Radio Button for Contact Member no"))
			return utils.clickAnelemnt(this.txtbxNickName, "Phonecall", "nickname");
		return false;
	}
	public boolean clickrbtnMSuscriberID()
	{
		return utils.clickAnelemnt(this.getrBtnSubscriberSSN(), "Phone Call", "Radio Buttoon  subscriberSSN");
	}

	public boolean clickrbtnMSearchSSN()
	{
		return utils.clickAnelemnt(this.getrBtnMSearchSSN(), "Phone Call", "Radio Button MemberSSN");
	}

	public boolean clickrbtnMNameGroup()
	{
		return utils.clickAnelemnt(this.getrBtnMNameGroup(), "Phone Call", "Radio Button name&group");

	}

	public boolean clickrbtnMNameSSN()
	{
		return utils.clickAnelemnt(this.getrBtnMNameSSN(), "Phone Call", "Radio Button MemberName&SSN");

	}

	public boolean clickbtnOtherActions()
	{
		return utils.clickAnelemnt(this.getBtnOtherActions(), "Phone Call", "Other actions button");
	}

	public boolean clicklinkexitInteraction()
	{
		return utils.clickAnelemnt(this.lnkOtherActionExitInteraction, "Phone Call", "Other Exitinteraction");

	}
	public boolean clicklinkGuestContact()
	{

		return utils.clickAnelemnt(this.getLnkOtherActionsGuestContact(), "Phone Call", "Other GuestContacts");
	}
	public boolean getHeaderforTabsVerification(String sHeader)
	{
		return utils.validateLabel(sHeaderSearchForMember, sHeader);
	}


	/**
	 * MEmber ID entry in page to enter the  value and check  the result only one entry is required
	 *  
	 * @param sMemberID
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean searchbyMemberID(String[] sMemberID) throws InterruptedException
	{
		String value = sMemberID[0].substring(sMemberID[0].indexOf(":")+1);
		if(this.clickrbtnMemberID())
			if(this.setSuscriberID(value))
				return this.clickMSearch();
		return false;
	}

	/**
	 * Suscribe SSN text box , only one entry required
	 * 
	 * @param sMemberSuscriberSNN: Enter Text for Suscriber SSN
	 * @return
	 */

	public boolean searchBySuscriberSSN(String[] sMemberSuscriberSNN)
	{
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMSuscriberID())
				if(setMSearchSN(sMemberSuscriberSNN[0]))
					if(clickMSearch())
						return this.isSearchsuccess();
		return false;
	}

	/**
	 * Search through SNN Last name, DOB and First name , 3
	 * @param sLastName
	 * @param sFirstName
	 * @param sDOB
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean searchByNameandDOB(String[] sData ) throws InterruptedException
	{

		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrBtnMNameDOB())
			{
				wait=new WebDriverWait(Driver.pgDriver,5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringFirstName")));
				if(setMSearchLast4SSNLastNAme(sData[0]))
					if(setMSearchLast4SSNFirstName(sData[1]))
						if(setMSearchLast4SSNDOB(sData[2]))
							if(clickMSearch())
								return this.isSearchsuccess();
			}

		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchByMemberSSN
	 * #Arguments:MemberSSN
	 * Type:Textbox
	 */

	public boolean searchByMemberSSN(String[] sMemberSNN )
	{
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMSearchSSN())
			{
				wait=new WebDriverWait(Driver.pgDriver,5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringSSN")));

				if(setMSearchSN(sMemberSNN[0]))
					if(clickMSearch())
						return this.isSearchsuccess();
			}
		return false;
	}

	/**
	 * Enter the values accoring to Nqame and Group 
	 * @param sLastName
	 * @param sFirstName
	 * @param sGroupName
	 * @return
	 */

	public boolean searchByNameandGroup(String[] sData )
	{
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMNameGroup())
			{
				wait=new WebDriverWait(Driver.pgDriver,5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringFirstName")));
				if(setMSearchLast4SSNLastNAme(sData[0]))
					if(setMSearchLast4SSNFirstName(sData[1]))
						if(setMGroupNum(sData[2]))
							if(clickMSearch())
								return this.isSearchsuccess();
			}
		return false;

	}

	/**
	 * Search through NAme and Group NAme 
	 * @param sLastName : Last Name 
	 * @param sFirstName: first Name 
	 * @param sGroupName: Group name 
	 * @return
	 */

	public boolean searchByNameandSSN(String[] sData )
	{
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMNameSSN())
			{
				wait=new WebDriverWait(Driver.pgDriver,10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringLast4SSN")));
				if(setMSearchLast4SSNLastNAme(sData[0]))
					if(setMSearchLast4SSNFirstName(sData[1]))
						if(setMSearchLast4SSN(sData[2]))
							if(clickMSearch())
								return this.isSearchsuccess();
			}
		return false;
	}



	@FindBy(className ="pageErrorList layout-noheader-errors")
	WebElement searchUnabletoretrivedata;

	public WebElement getsearchnosuccessError(){
		return this.searchUnabletoretrivedata;
	}


	/**
	 * To check if the error is appearing or not 
	 * @return
	 */
	public boolean isSearchsuccess()
	{
		if(!utils.isProxyWebelement(this.getsearchnosuccessError()))
			if(this.getsearchnosuccessError().isDisplayed())
				return false;
		return true;
	}

	/**
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean selectMemberbyFirstNameAndSubmit(String[] args) throws InterruptedException{

		utils.waitforpageload();
		String value=args[0].substring(args[0].indexOf(":")+1);
		System.out.println(args[0]+"       "+value);
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=getsearchResultbyColumn("First Name");
		String[] valuetobechose={"First Name:"+args[0]};
		if(utils.clickontablerowbasedonvalues(this.searchResulttable, valuetobechose))
			return this.clickMSubmit();
		return false;
	}

	public boolean selectMemberbyMultipleValues(String[] args) throws InterruptedException{
		return utils.clickontablerowbasedonvalues(this.searchResulttable, args);
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:fillNicknameandextension
	 * Type:Textbox


	 */
	public boolean fillNicknameandextension(){
		int a=1;
		try{
			a++;
			if(this.setMNickname("Nickname"))
				if (this.setMCallBackNumber("1234567890"))
				{
					return acceptbestphone();
				}
				else{ 
					err.logcommonMethodError("Phone call member search", "fillNicknameandextension");
					return false;}
			else {
				err.logcommonMethodError("Phone call member search", "fillNicknameandextension");
				return false;
			}
		}catch(Exception e)
		{
			if(a>1)
			{
				fillNicknameandextension();
				return true;
			}
			else
				return false;
		}
	}

	public boolean acceptbestphone()
	{
		return utils.clickAnelemnt(this.radioBestNumberAccept, "Phone Call-Member Search", "Accept best phone radio");
	}

	public boolean declinebestphone()
	{
		return utils.clickAnelemnt(this.radioDeclineNumberAccept, "Phone Call-Member Search", "Decline best phone radio");
	}
	public boolean fillNicknameandextension(String[] args){
		if(this.setMNickname(args[0]))
			return this.setMCallBackNumber(args[1]);
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectContractMemberandSubmit
	 * #Arguments:Yes/No
	 * Type:Textbox


	 */
	public boolean selectContractMemberandSubmit(String[] args){
		if((args[0]).trim().equalsIgnoreCase("yes"))
		{
			if(this.clickrbtnPhoneMemberContactmemberYes());
			else
				return false;
		}
		else if ((args[0]).trim().equalsIgnoreCase("no"))	
		{
			if(this.clickrbtnPhoneMemberContactmemberNo());
			else
				return false;
		}
		return this.clickMSubmit();

	}


	public ArrayList<String> getsearchResultbyColumn(String columnName){
		ArrayList<String> returnColumn =new ArrayList<String>();
		returnColumn=utils.getcolumnStringFromTableByName(this.gettblSearchresult(), columnName);
		return returnColumn;
	}

	public boolean clickselectColumnRadioButton (int row){
		ArrayList<WebElement> select = utils.getcolumnWebelemntFromTable(this.gettblSearchresult(),"input" );
		return utils.clickAnelemnt(select.get(row),"Phone cal member","resutlt table radio");
	}

	public boolean exitInteraction(){

		if(this.clickbtnOtherActions())
			return this.clicklinkexitInteraction();	
		return false;
	}


	/**
	 * Guest Contacts Navigation from Phone Call members
	 * 
	 * @return
	 */
	public boolean guestContacts(){

		if(this.clickbtnOtherActions())
			return this.clicklinkGuestContact();
		return false;
	}

	public boolean pagenavigate(String[] page)
	{
		if(page[0].toLowerCase().contains("back"))
		{
			utils.gotoback();
			return true;
		}
		else
			if(page[0].toLowerCase().contains("forward"))
			{
				utils.goforward();
				return true;
			}
		if(page[0].toLowerCase().contains("refresh"))
		{
			utils.refreshthepage();
			return true;
		}
		else
			return false;

	}

	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMemberRow;
	public boolean selectfirstMember(){
		return utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -	firstRowofselectMembertable");			
	}

	public boolean searchAndSubmitPhoneMember(String[] args) throws InterruptedException {
		boolean flag =false;
		String[] argu = args[2].split("/");
		String memberid = null, firstname = null;
		for(String iterator : argu)
		{		
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);


			if(utils.isvalueMatch_contain(key.toLowerCase(), "memberid")) {
				memberid = value;
				continue;}
			if(utils.isvalueMatch_contain(key.toLowerCase(), "memberfirstname")) {
				firstname = value;
				continue;}

		}

		String[] memberids = memberid.split(",");
		if(searchbyMemberID(memberids))
			if(firstname!=null) {
				String[] firstnames = firstname.split(",");
				selectMemberbyFirstNameAndSubmit(firstnames);
			}else {
				selectfirstMember();
				clickMSubmit();
				flag = true;
			}

		if(flag) {
			blogger.loginfo("PASS: Search and Submit provider Phone Member successful");
			return true;
		}
		else {
			blogger.loginfo("FAIL: Search and Submit provider Phone Member not successful");
			return false;
		}

	}
	
	@FindBy(xpath="//*[text()='HIPAA Verification & Disclosure Guide']")
	WebElement HIPAAGUIDELink;
	
	/**Verify HIPAA Verification And DIsclosure Link Is Available Under Search By at Search for Member page in Phone call Provider flow
	 * 
	 * @return
	 */
	public boolean verifyHIPAAVerificationAndDIsclosureIsAvailableMemberSearch(){
		return !utils.isProxyWebelement(HIPAAGUIDELink);
	}
	
	@FindBy(xpath="//input[@id='ContinueWithoutMember']")
	WebElement ContinueWithoutMember;
	
	/**Clicks the Continue Without Member check-box in the Search Member page in Phone call Provider flow
	 * 
	 * @return
	 */
	public boolean clickContinueWithoutMemberCheckbox(){
		return utils.clickAnelemnt(ContinueWithoutMember, "ProviderPhoneCallMembersearchMember", "ContinueWithoutMember");
	}
	
	
	@FindBy(xpath="//input[@id='ITSHostAccountYes']")
	WebElement ITSHostAccountYes;
	
	@FindBy(xpath="//input[@id='ITSHostAccountNo']")
	WebElement ITSHostAccountNo;
	
	
	public boolean clickIsThisAnItsHostAccountMemberRadioButton(String[] args) throws InterruptedException {
        utils.waitforpageload();
        if(args[0].equalsIgnoreCase("Yes")) {
        return clickrbtnIsthisanITSHOSTAccountmemberYes();
        }
        else
        return clickrbtnIsthisanITSHOSTAccountmemberNo();
 }

	/**
	 * Clicks Is this an ITS -HOST Account member radio button in Search Member Page using data 
	 * @return
	 */
	public boolean clickrbtnIsthisanITSHOSTAccountmemberYes()
	{
		if(ITSHostAccountYes.isDisplayed())
			if(utils.clickAnelemnt(ITSHostAccountYes, "ProviderPhoneCallMembersearchMember", "Yes Radio Button"))
		return true;
		return false;
	}

	public boolean clickrbtnIsthisanITSHOSTAccountmemberNo()
	{
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("window.scrollBy(0,450)","");
		if(utils.clickAnelemnt(ITSHostAccountNo, "ProviderPhoneCallMembersearchMember", "No Radio Button"))
		return true;
		return false;
	}
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement Submit;

	public boolean clickSubmit() throws InterruptedException
	{
		utils.waitforpageload();
		if(utils.scrolltomiddle())
		if (utils.clickAnelemnt(Submit, "Search Member", "Continue withour Mmeber"))
			return true;
		return false;
	}
	
	@FindBy(id="ITSHOSTRegionalSkill")
	WebElement ITSHOSTDropDOwn;
	
	/**This functionality selects the value given by the user in the ITS Host DropDown at the Member search screen in Phone call provider flow
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectITSHostRegion(String args[]){
		if(utils.clickAnelemnt(this.ITSHOSTDropDOwn, "ProviderPhoneCallMembersearchMember", "ITS Host Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			if(utils.checkvaluesinDropDown(this.ITSHOSTDropDOwn,dropdownValues))
				return utils.selectDropDownbyVisibleString(this.ITSHOSTDropDOwn, args[0], "ProviderPhoneCallMembersearchMember", "ITS Host Dropdown");
		}
		return false;
	}
	
	@FindBy(xpath="//span[text()='Is this an ITS -HOST Account member']")
	WebElement HostQuestion;
	
	//Validate that the  Is this an ITS -HOST Account member Question is available in Search for Member screen in Phone call Provider flow
	public boolean validateIsThisHostAccountQuestionisAvailable(){
		return !utils.isProxyWebelement(HostQuestion);
	}
		
	//Validate that the  Is this an ITS -HOST Account member Question is Not available in Search for Member screen in Phone call Provider flow
	public boolean validateIsThisHostAccountQuestionisNotAvailable(){
		return utils.isProxyWebelement(HostQuestion);
	}
	
	@FindBy(xpath="//div[text()='Transfer Interaction']")
	WebElement TrnsIntBtn;
	
//Validates that the Transfer Interaction BTN Available at the Member search screen for phone call provider flow	
	public boolean validateTransferInteractionBTNAvailable(){
		return !utils.isProxyWebelement(TrnsIntBtn);
	}
	
	public boolean clickOnTransferInteractionBTN()
	{
		return utils.clickAnelemnt(TrnsIntBtn, "ProviderPhoneCallMembersearchMember", "TrnsIntBtn");
	}
	
	@FindBy(id="USDomainID")
	WebElement USDomainIDTxtBox;
	
	@FindBy(id="wrapupnotes")
	WebElement NotesTXBBox;
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement SubmitBTN;
	
	
	public boolean enterReceivingAgentOperatorIDAndNotes(String[] args) throws InterruptedException{
		if(utils.enterTextinAnelemnt(USDomainIDTxtBox, args[0], "ProviderComposite", "USDomainIDTxtBox"))
	    	action.moveToElement(USDomainIDTxtBox).sendKeys(Keys.ENTER);
		 if(utils.enterTextinAnelemnt(NotesTXBBox, args[1], "ProviderComposite", "NotesTXBBox"))
		 return utils.clickAnelemnt(SubmitBTN, "ProviderComposite", "SubmitBTN");
		
		return false;
		
		
	}
	@FindBy(xpath="//div[@data-test-id='20180627130805021453709']")
	WebElement TrnsIntsFIrstMSG;
	@FindBy(xpath="//div[contains(@class,'content-inner')]//p")
	WebElement TrnsIntsSecondMSG;
	@FindBy(xpath="//div[text()='Close']")
	WebElement CloseBtn;
	
	public boolean validateMessageInTransferInteractionPopup(){
			
			String FirstMSG = "Complete transfer using phone system";
			String FirstMSGFromUI = this.TrnsIntsFIrstMSG.getText().replaceAll(",", "").replaceAll("  ", " ");
			if( utils.isvalueMatch_compareto(FirstMSGFromUI, FirstMSG))
				if(!utils.isProxyWebelement(TrnsIntsSecondMSG))
					return utils.clickAnelemnt(CloseBtn, "ProviderPhoneCallMembersearchMember", "CloseBtn");
						
			return false;
			

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
	

}



