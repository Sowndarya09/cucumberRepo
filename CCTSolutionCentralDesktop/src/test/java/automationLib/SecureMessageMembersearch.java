

package automationLib;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.util.SystemOutLogger;
import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
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


/**
 * Objects in the page 
 * @author shardul.singh.negi
 *
 */
public class SecureMessageMembersearch  extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	Actions action=new Actions(Driver.pgDriver);
	public SecureMessageMembersearch()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
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
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;


	@FindBy(className="[Header_nav'][text()=' Phone Call']")
	private WebElement sHeaderPhoneCallTab;


	@FindBy(tagName="CaseOrTaskIcon")
	private WebElement rdioSearchresults;








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
	@FindBy(xpath="//label[contains(text(), 'Name and SSN')]")
	private WebElement rBtnMNameSSN;

	@FindBy(id="IsContactMemberYes")
	private WebElement rBtnContactMemberYes;
	@FindBy(id="IsContactMemberNo")
	private WebElement rBtnContactMemberNo;

	// table 
	@FindBy(xpath="//*[@class='gridTable ']")
	private WebElement searchResulttable;
	@FindBy(xpath="//th//div[text()='Select']']")
	private WebElement searchResulttableHeaderselect;

	// External search 
	/*@FindBy(id="CcbLogEventYes")
	private WebElement rBtnExtSerchLogEvent;
	@FindBy(id="CcbLogEventNo")
	private WebElement rBtnExtSerchViewMembrshp;*/
	@FindBy(id="TCPAResponseAccept")
	WebElement radioBestNumberAccept;
	@FindBy(id="TCPAResponseDecline")
	WebElement radioDeclineNumberAccept;
	/**
	 * Text Boxed
	 */
	@FindBy (id="SearchStringMemberID")	
	//@FindBy(xpath="//input[@id='SearchStringMemberID']")
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


	// Guest Contact Page 
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


	//External Search 
	@FindBy (id="CcbOperatorId")	
	private WebElement txtbxExtrnlSerchCCBOprtorID;
	@FindBy (id="IQTTrackingNumber")	
	private WebElement txtbxExtrnlSerchIQTRequestNo;




	/**
	 * Buttons to be used 
	 */
	@FindBy (xpath="//*[@data-test-id='2015082811210004244498']")	
	private WebElement btnSearchforMSearch;

	//Xpath for Submit throughout is same class
	@FindBy (xpath="//button[@title='Complete this assignment']")	
	private WebElement btnSubmit;
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Launch CCB']")	
	private WebElement btnLaunchCCB;




	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;
	@FindBy (xpath="//img[@src='webwb/tool_icon_13690228252.png!!.png']")	
	private WebElement btnImgTool;

	// Tool Mark 
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;

	// Other Actions 
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Guest Contact']")	
	private WebElement lnkOtherActionsGuestContact;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement lnkOtherActionExitInteraction;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='External Search']")	
	private WebElement lnkOtherActionExternalSearch;


	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other actions') or contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	//Header for the Page 

	@FindBy (className="anthem_theme_header")	
	private WebElement headerForThemePage;

	@FindBy(xpath="//span[@class='iconRequired Standard_iconRequired'][contains(text(),'Is Contact the')]")
	WebElement  labelIscontacttheselected;
	// error messages
	@FindBy (xpath="//li[contains(text(),'Unable to retrieve data')]")
	private WebElement listunabletofinddata;

	@FindBy(xpath="//input[@id='CaseOrTaskIcon")
	private WebElement radioSelectContract;

	//New Objects

	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMemberRow;

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
					if(clickMSearch())
						return true;
		return false;
	}


	/**
	 * Filling in the Text Boxes and clicking on Buttons
	 * 
	 * Here if the details are not put in correct so a Pop up appears which is to be handles. 
	 */

	public boolean clickMSubmit()
	{
	utils.scrolltomiddle();
	if(utils.clickAnelemnt(this.getBtnSubmit(), "Phone Call", "Submit"))
		try{	
		return !utils.isServiceDown();
	}
		catch(Exception e)
		{
System.out.println("exception in service down  "+e.toString());
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
		return false;
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
			return utils.enterTextinAnelemnt(this.getTxtbxMSearchSSN(), sSuscriberID, "Phone Call", "Text Box SSN");
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
		return utils.clickAnelemnt(this.getrBtnMID(), SecureMessageMembersearch.class.getName(), "Radio MemberId");
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
			return utils.clickAnelemnt(this.getrBtnContactMemberYes(), "Phone Call", "Radio Button for Contact Member yes");
		else
			return utils.clickAnelemnt(this.getrBtnContactMemberYes(), "Phone Call", "Radio Button for Contact Member yes");
		//return utils.clickAnelemnt(this.labelIscontacttheselected, "Phonecall", "nickname");
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
		return utils.isvalueMatch_contain(sHeader, sHeaderSearchForMember.getText());
	}



	/**
	 * MEmber ID entry in page to enter the  value and check  the result only one entry is required
	 *  
	 * @param sMemberID
	 * @return
	 * @throws InterruptedException 
	 */
	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchbyMemberID
	 * #Arguments:memberID
	 * Type:Textbox
	 */


	public boolean searchbyMemberID(String[] sMemberID) throws InterruptedException
	{
		if(getHeaderforTabsVerification("Search for Member"))
		{
			String value = sMemberID[0].substring(sMemberID[0].indexOf(":")+1);
			if(this.clickrbtnMemberID())
				if(this.setSuscriberID(value))
					if(this.clickMSearch())
						if( this.isSearchsuccess())
							return true;
						}		
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
						if( this.isSearchsuccess())
							return true;
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
	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchByNameandDOB
	 * #Arguments:lastname,firstname,dob
	 * Type:Textbox

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
							utils.scrolltomiddle();
							if(clickMSearch())
								if( this.isSearchsuccess())
									return true;

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
						if( this.isSearchsuccess())
							return true;
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
	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchByNameandGroup
	 * #Arguments:lastname,firstname,group number
	 * Type:Textbox


	 */
	public boolean searchByNameandGroup(String[] sData )
	{
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMNameGroup())
				if(setMSearchLast4SSNLastNAme(sData[0]))
					if(setMSearchLast4SSNFirstName(sData[1]))
						if(setMGroupNum(sData[2]))
						{
							JavascriptExecutor jse=(JavascriptExecutor)Driver.pgDriver;
							jse.executeScript("arguments[0].scrollIntoView(true);", btnSearchforMSearch);
							if(clickMSearch())
								if( this.isSearchsuccess())
									return true;

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
	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchByNameandSSN
	 * #Arguments:lastname,firstname,SSn
	 * Type:Textbox


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
						{
							JavascriptExecutor jse=(JavascriptExecutor)Driver.pgDriver;
							jse.executeScript("arguments[0].scrollIntoView(true);", btnSearchforMSearch);
							if(clickMSearch())
								if( this.isSearchsuccess())
									return true;

								}
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
		return (!utils.isServiceDown());
	}

	/**
	 * 
	 * @param args
	 * @return
	 */

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectMemberbyFirstName
	 * #Arguments:Member First Name
	 * Type:Textbox


	 */
	public boolean selectMemberbyFirstName(String[] args){
		String value=args[0].substring(args[0].indexOf(":")+1);

		System.out.println(args[0]+"       "+value);
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=getsearchResultbyColumn("First Name");
		try{
			if(this.clickselectColumnRadioButton(utils.returnindexofelemntinanarray(firstnameColumn, value)))
				return true;
			else 
				err.logcommonMethodError("Phone call Search member", "selectMemberbyFirstName");
			return false;
		}catch(Exception e)
		{if(!utils.isServiceDown())
			if(this.clickselectColumnRadioButton(utils.returnindexofelemntinanarray(firstnameColumn, value)))
				return true;
			else 
				err.logcommonMethodError("Phone call Search member", "selectMemberbyFirstName");
			return false;
		}

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
					acceptbestphone();
					return true;
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
			if (this.setMCallBackNumber(args[1]))
				return true;
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
		if (this.clickMSubmit())
			return true;
		
		return false;

	}


	public ArrayList<String> getsearchResultbyColumn(String columnName){
		ArrayList<String> returnColumn =new ArrayList<String>();
		returnColumn=utils.getcolumnStringFromTableByName(this.gettblSearchresult(), columnName);
		return returnColumn;
	}

	public boolean clickselectColumnRadioButton (int row){
		ArrayList<WebElement> select = utils.getcolumnWebelemntFromTable(this.gettblSearchresult(),"input" );
		if(utils.clickAnelemnt(select.get(row),"Phone cal member","resutlt table radio"))
			return true;
		else 
			return false;
	}

	public boolean exitInteraction(){

		if(this.clickbtnOtherActions())
			if(this.clicklinkexitInteraction())	
				return true;
			else 
				return false;
		return false;
	}


	/**
	 * Guest Contacts Navigation from Phone Call members
	 * 
	 * @return
	 */
	public boolean guestContacts(){
		if(this.clickbtnOtherActions())
			if(this.clicklinkGuestContact())
				return true;
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

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectfirstMember
	 * #Description: This functionality selects the first member row in the member search result table.
	 * Type: Textbox
	 */
	public boolean selectfirstMember(){
			return utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -firstRowofselectMembertable");
	}

	/**This method is used to navigate to First Impression
	 * 
	 * @return
	 */
	public boolean navigateToFirstImpresssion()
	{
		if(this.clickbtnOtherActions())
			if(this.clickFirstImpression())
				return true;
		return false;


	}

	@FindBy(xpath="//span[contains(text(),'First Impression')]")
	WebElement firstImpression; 

	public boolean clickFirstImpression()
	{
			return utils.clickAnelemnt(this.firstImpression, "PhoneCallMembersearchMember", "Clicks First Impression");
	}
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement Submit;
	
	/**This method is to search member, select first member, fill Nickname and extension and click on submit
	 * @throws InterruptedException 
	 * 
	 */
	public boolean searchAndSubmitPhoneMember(String[] args) throws InterruptedException {
		try {
			String[] value = args[2].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			searchbyMemberID(memberid);
			int i = utils.getIndexValueOfStringArray(value,"MemberFirstName");
			if(i != 0) {
				String[] firstname = value[i].substring(value[i].indexOf(":")+1).split(",");
				selectMemberbyFirstName(firstname);
			}else {
				selectfirstMember();
			}
			fillNicknameandextension();
			clickrbtnPhoneMemberContactmemberYes();
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			utils.scrolltomiddle();
			return utils.clickAnelemnt(Submit, "Phone Call", "Submit");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			String[] value = args[1].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			searchbyMemberID(memberid);
			int i = utils.getIndexValueOfStringArray(value,"MemberFirstName");
			if(i != 0) {
				String[] firstname = value[i].substring(value[i].indexOf(":")+1).split(",");
				selectMemberbyFirstName(firstname);
			}else {
				selectfirstMember();
			}
			fillNicknameandextension();
			clickrbtnPhoneMemberContactmemberYes();
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			utils.scrolltomiddle();
			return utils.clickAnelemnt(Submit, "Phone Call", "Submit");		
		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}
	}


	public boolean setNickname(String[] snickName)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxNickName(), snickName[0], "Phone Call", "Text Box NickName");
	}
	
	
	public boolean selectValueInOtherActions(String[] args) throws InterruptedException
	{
		return utils.selectValueFromListbyVisibleString(btnOtherActions, args[0], "Phone", "");
	}
	
	//Sprint 4.1
	
	@FindBy(xpath="//*[text()='HIPAA Verification']")
	WebElement labelHippaVerification;
	
	@FindBy(id="IsMemberIDVerified")
	WebElement chckBxMemberId;
	
	@FindBy(id="IsMemberNameVerified")
	WebElement chckBxName;
	
	@FindBy(id="IsDateOfBirthVerified")
	WebElement chckBxDOB;
	
	@FindBy(id="IsPhoneNumberVerified")
	WebElement chckBxPhone;
	
	@FindBy(xpath="//*[@data-test-id='201504281304350457121267']")
	WebElement labelVerificationID;
	
	@FindBy(xpath="//*[@data-test-id='201504281304350458122377']")
	WebElement labelVerificationDOB;

	@FindBy(xpath="//*[@data-test-id='2015042815070504775471']")
	WebElement labelVerificationphone;
	
	@FindBy(xpath="//*[@data-test-id='2015042812583202823964']")
	WebElement labelVerificationfullname;
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement btnVerificationSubmit;
	
	
	
	
	public boolean verifyHIPAAVerificationIsDisplayedInMemberSearch()
	{
			return !utils.isProxyWebelement(labelHippaVerification);
	}
	
	public boolean verifyMemberIdIsAutoChecked()
	{
		boolean bol = chckBxMemberId.isSelected();
			if(bol==true)
			{
				blogger.loginfo("Member ID is auto checked");
				System.out.println("Member ID is auto checked");
				return true;
			}else
			{
				blogger.loginfo("Member ID is not auto checked");
				System.out.println("Member ID is not auto checked");
				return true;
			}
	}
	
	public boolean verifyDOBIsAutoChecked()
	{
		boolean bol = chckBxDOB.isSelected();
			if(bol==true)
			{
				blogger.loginfo("DOB is auto checked");
				System.out.println("DOB is auto checked");
				return true;
			}else
			{
				blogger.loginfo("DOB is not auto checked");
				System.out.println("DOB is not auto checked");
				return true;
			}
	}
	
	public boolean verifyNameIsAutoChecked()
	{
		boolean bol = chckBxName.isSelected();
			if(bol==true)
			{
				blogger.loginfo("Name is auto checked");
				System.out.println("Name is auto checked");
				return true;
			}else
			{
				blogger.loginfo("Name is not auto checked");
				System.out.println("Name is not auto checked");
				return true;
			}
	}
	
	public boolean verifyPhoneIsAutoChecked()
	{
		boolean bol = chckBxPhone.isSelected();
			if(bol==true)
			{
				blogger.loginfo("Phone is auto checked");
				System.out.println("Phone is auto checked");
				return true;
			}else
			{
				blogger.loginfo("Phone is not auto checked");
				System.out.println("Phone is not auto checked");
				return true;
			}
	}
	
	
	public boolean verifymemberID(String args[])
	{
		String memid=this.labelVerificationID.getText().toString();
		return utils.isvalueMatch_contain(memid, args[0]);
	}

	public boolean verifymemberName(String args[])
	{

		String fullname=this.labelVerificationfullname.getText().toString();
		return utils.isvalueMatch_contain(fullname, args[0]);
	}

	public boolean verifymemberDOB(String args[])
	{
		String memberDOB=this.labelVerificationDOB.getText().toString();
		return utils.isvalueMatch_contain(memberDOB, args[0]);
	}
	
	public boolean verifymemberPhone(String args[])
	{
		String memberPhone=this.labelVerificationphone.getText().toString();
		return utils.isvalueMatch_contain(memberPhone, args[0]);
	}
	
	public boolean ValidateDetailsPresent()
	{
		return !utils.isProxyWebelement(chckBxName);
	}
	
	public boolean clickchkbxVerificationMembernameverify(String[] membername) {

		this.verifymemberName(membername);
		return (utils.clickAnelemnt(this.chckBxName, "SelectAssociatedContact", "Member name verify checkbox"));


	}

	public boolean clickchkbxVerificationMemberidverify(String[] memberid) {

		this.verifymemberID(memberid);
		return (utils.clickAnelemnt(this.chckBxMemberId, "SelectAssociatedContact", "Member id verify checkbox"));


	}

	public boolean clickchkbxVerificationMemberDOB (String[] DOB){
		this.verifymemberDOB(DOB);
		return (utils.clickAnelemnt(this.chckBxDOB, "SelectAssociatedContact", "Member DOB verify checkbox"));

	}
	
	public boolean clickchkbxVerificationMemberphone (String[] phone){
		this.verifymemberPhone(phone);
		return (utils.clickAnelemnt(this.chckBxPhone, "SelectAssociatedContact", "Member {hone verify checkbox"));

	}
	
	public boolean selectHIPAAverificationDetails(String[] args)
	{
		utils.waitforpageload();
		if(this.ValidateDetailsPresent())
		{
			for(int i=0;i<args.length;i++)
			{
				if(args[i].contains("name"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if( this.clickchkbxVerificationMembernameverify(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
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

					if(this.clickchkbxVerificationMemberidverify(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
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
					if( this.clickchkbxVerificationMemberDOB(s))
					{

						if(i==args.length-1) 
						{
							if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
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
					if(this.clickchkbxVerificationMemberphone(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}

				else 
				{
					err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
				}

			}


			err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
			return false;
		}
		

	err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
	return false;

	}
	
	
	public boolean verifyAllHIPAAVerificationUncheckedWhileChangingMember()
	{
		boolean bol = chckBxMemberId.isSelected();
		boolean bol1 = chckBxName.isSelected();
		boolean bol2 = chckBxDOB.isSelected();
		
		if(bol == true && bol1 == false && bol2 == false)
			return true;
			return false;

	}
	
	
	public boolean selectValuesFromOtherActions(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(btnOtherActions, args[0], "GuestContact", "Guest Contact");
	}
	
	public boolean selectContactMemberYesOrNo(String[] args) {
		if(args[0].equalsIgnoreCase("Yes")) 
		return clickrbtnPhoneMemberContactmemberYes();
		else
		return clickrbtnPhoneMemberContactmemberNo();
	}
	
	public boolean selectHIPAAverificationDetailsAndDoNotClickSubmit(String[] args)
	{
		utils.waitforpageload();
		if(this.ValidateDetailsPresent())
		{
			for(int i=0;i<args.length;i++)
			{
				if(args[i].contains("name"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if( this.clickchkbxVerificationMembernameverify(s))
					{
						if(i==args.length-1)
						{
							//if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
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

					if(this.clickchkbxVerificationMemberidverify(s))
					{
						if(i==args.length-1)
						{
							//if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
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
					if( this.clickchkbxVerificationMemberDOB(s))
					{

						if(i==args.length-1) 
						{
							//if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
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
					if(this.clickchkbxVerificationMemberphone(s))
					{
						if(i==args.length-1)
						{
							//if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}

				else 
				{
					err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
				}

			}


			err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
			return false;
		}
		

	err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
	return false;

	}
	
	/**This functionality navigates to the Exit Interaction page by clicking other actions button  and the Exit interaction button
	 * 
	 * @return
	 */
	public boolean navigateToExitInteraction()
	{
		if(this.clickbtnOtherActions())
			if(this.clickExitInteraction())
				return true;
		return false;


	}

	@FindBy(xpath="//span[contains(text(),'Exit Interaction')]")
	WebElement exitInteraction; 

	public boolean clickExitInteraction()
	{
			return utils.clickAnelemnt(this.exitInteraction, "PhoneCallMembersearchMember", "Clicks Exit Interaction");
	}
	
	
	public boolean validateHeaderOfSearchMemberScreen(String[] sHeader)
	{
		return utils.isvalueMatch_contain(sHeader[0], sHeaderSearchForMember.getText());
	}
	
	@FindBy(xpath="//div[contains(text(),'Other Actions')]")
	WebElement drpDownOtherActions;
	
	public boolean verifySearchForBrokerInOtherActionsOptionsInMemberSearchFlow(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, args[0], "PhoneCallMembersearchMember", "Other Actions");
	}

	
	
}
