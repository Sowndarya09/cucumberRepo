

package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;
import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
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
import utils.DataStore;


/**
 * Objects in the page 
 * @author shardul.singh.negi
 *
 */
public class PhoneCallMembersearchMember  extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	Actions action=new Actions(Driver.pgDriver);
	public PhoneCallMembersearchMember()
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

	@FindBy(xpath="//table[contains(@pl_prop,'HCMemberContactList.pxResults')]//tr[@id='$PHCMemberContactList$ppxResults$l1']")
	private WebElement SearchResultSuccess;

	static String isSelectedMember;
	static boolean isHippaAuthverified;
	
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
	
	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMember;
	
	@FindBy(xpath= "//*[@id='$PD_MembersOnContract_pa3141806783632408pz$ppxResults$l2']//input[@id='GridSelectIcon']")
	WebElement rdofirstasscontact;


	@FindBy(xpath="//table[contains(@pl_prop,'HCMemberContactList.pxResults')]//tr[@id='Grid_NoResults']")
	private WebElement SearchResultFail;	
	/**
	 * Radio Buttons with Member Functions 
	 */

	@FindBy(xpath="//*[contains(@id,'MemberSearchTypeSubscriber')]")
	private WebElement rBtnSubscriberSSN;
	
	@FindBy(xpath="//*[contains(@id,'MemberSearchTypeName and SSN')]")
	private WebElement rBtnSSNandname;
	
	/*@FindBy(xpath="//*[contains(@id,'MemberSearchTypeSubscriber SSN')]")
	private WebElement rBtnSubscriberSSN;*/
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
	/*@FindBy(id="AssociatedContactType")
	private WebElement drpcontacttype;*/
	@FindBy(id="IsContactMemberNo")
	private WebElement rBtnContactMemberNo;

	// table 

	@FindBy(xpath="//table[contains(@pl_prop,'HCMemberContactList.pxResults')]")
	private WebElement searchResulttable;
	@FindBy(xpath="//th//div[text()='Select']']")
	private WebElement searchResulttableHeaderselect;
	@FindBy(xpath="//table[contains(@pl_prop,'HCMemberContactList.pxResults')]//tr[@id='Grid_NoResults']")
	private WebElement NoItemsSearchResult;

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
	
	@FindBy (xpath="//button[@class='Strong pzhc']//div[text()='Submit']")	
	private WebElement submitButton;

	


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

	@FindBy(xpath= "//table[@pl_prop='HCMemberContactList.pxResults']//input[@type='radio']")
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
	 * Filling in the Text Boxes and clicking on Buttons
	 * 
	 * Here if the details are not put in correct so a Pop up appears which is to be handles. 
	 */

	public boolean clickSubmitInMemberSearchBF()
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(submitButton, "Phone Call", "Submit"))
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
		utils.scrolltomiddle();
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
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchDOB(), sSuscriberID, "Phone Call", "Text Box DOB");
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
		return utils.clickAnelemnt(this.getrBtnMID(), PhoneCallMembersearchMember.class.getName(), "Radio MemberId");
	}


	public boolean clickrBtnMNameDOB()
	{
		return utils.clickAnelemnt(this.getrBtnMNameDOB(), "PhoneCallMember-Searchmember", "Radio Button Name&DOB");
	}




	/**
	 * Click on Yes and then click Yes on the Alert with that 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickrbtnPhoneMemberContactmemberYes() throws InterruptedException
	{
		/*utils.waitforpageload();
		if(!utils.isProxyWebelement(AssociatedContactType))
			return selectContactTypeForPhoneInteraction();
		else
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("window.scrollBy(0,900)","");
			return selectContactTypeForPhoneInteraction();
		}*/
		
		utils.waitforpageload();
		if(!utils.isProxyWebelement(rBtnContactMemberYes))
			return utils.clickAnelemnt(this.getrBtnContactMemberYes(), "Phone Call", "Radio Button for Contact Member yes");
		else
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("window.scrollBy(0,900)","");
			return utils.clickAnelemnt(this.getrBtnContactMemberYes(), "Phone Call", "Radio Button for Contact Member yes");
		}

	}

	public boolean clickrbtnPhoneMemberContactmemberNo()
	{
		/*if(!utils.isProxyWebelement(AssociatedContactType))
			return selectContactTypeForPhoneInteractionForAssocContract();
		else
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("window.scrollBy(0,900)","");
			return selectContactTypeForPhoneInteractionForAssocContract();
		}*/
		if(!utils.isProxyWebelement(rBtnContactMemberNo))
			return utils.clickAnelemnt(this.getrBtnContactMemberNo(), "Phone Call", "Radio Button for Contact Member no");
		else
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("window.scrollBy(0,900)","");
			return utils.clickAnelemnt(this.getrBtnContactMemberNo(), "Phone Call", "Radio Button for Contact Member no");
		}

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
	public boolean searchbyMemberID(String[] sMemberID) throws InterruptedException
	{
		String value = sMemberID[0].substring(sMemberID[0].indexOf(":")+1);
		if(clickrbtnMemberID())
			if(setSuscriberID(value))
				if(clickMSearch())
					if(isSearchsuccess())
						return true;

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
		isHippaAuthverified=false;
		if(getHeaderforTabsVerification("Search for Member"))
			if(clickrbtnMSuscriberID())
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
			if(clickrBtnMNameDOB())
				if(setMSearchLast4SSNLastNAme(sData[0]))
					if(setMSearchLast4SSNFirstName(sData[1]))
						if(setMSearchLast4SSNDOB(sData[2]))
							if(clickMSearch())
								if(isSearchsuccess())
									return true;
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
		isHippaAuthverified=false;
		if(getHeaderforTabsVerification("Search for Member"))
			if(clickrbtnMSearchSSN())
				if(setMSearchSN(sMemberSNN[0]))
					if(clickMSearch())
						if( this.isSearchsuccess())
							return true;
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
		isHippaAuthverified=false;
		if (getHeaderforTabsVerification("Search for Member"))
			if (clickrbtnMNameGroup())
				if (setMSearchLast4SSNLastNAme(sData[0]))
					if (setMSearchLast4SSNFirstName(sData[1]))
						if (setMGroupNum(sData[2]))
							if (clickMSearch())
								if (isSearchsuccess())
									return true;
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
			if(clickrbtnMNameSSN())
				if(setMSearchLast4SSNLastNAme(sData[0]))
					if(setMSearchLast4SSNFirstName(sData[1]))
						if(setMSearchLast4SSN(sData[2]))
							if(clickMSearch())
								if(isSearchsuccess())
									return true;				
		return false;
	}







	@FindBy(xpath ="//ul[@class='pageErrorList layout-noheader-errors']")
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
		if (!utils.isProxyWebelement(SearchResultSuccess))
			return true;
		else 
		{
			if(utils.isProxyWebelement(SearchResultFail))	
				if(!utils.isServiceDown())
					return !utils.isProxyWebelement(SearchResultSuccess);	
			return false;
		}
	}


	/**
	 * 
	 * @param args
	 * @return
	 * @throws Exception 
	 */

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectMemberbyFirstName
	 * #Arguments:Member First Name
	 * Type:Textbox


	 */
	public boolean selectMemberbyFirstName(String[] args) throws Exception{
		List<WebElement> rowCol = null;
		utils.waitforpageload();
		String[] ar = ("First Name:"+args[0]).split("-");
		WebElement tablerow = utils.returntablerowbasedonvalues(gettblSearchresult(), ar);
		rowCol = tablerow.findElements(By.xpath(".//input[@type='radio']"));
		return utils.clickAnelemnt(rowCol.get(0), "Select Member", "Radio Button");
		
		
		/*String value=args[0].substring(args[0].indexOf(":")+1);
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
		}*/

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
			if(setMNickname("FirstName"))
				if (setMCallBackNumber("1234567890"))
					return acceptbestphone();
			return false;
		}catch(Exception e)
		{
			if(a>1)
			{
				return fillNicknameandextension();
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
		
		utils.waitForElementToBeClickabale(rBtnContactMemberYes);
		if((args[0]).trim().equalsIgnoreCase("yes")) {
			if(this.rBtnContactMemberYes.isDisplayed())
			isSelectedMember="Yes";
			//if(selectContactTypeForPhoneInteraction())
			if(utils.clickAnelemnt(rBtnContactMemberYes, "Phone Call", "Radio Button for Contact Member yes"))
				if(selectHIPAAverificationDetails())
					if(utils.scrolltomiddle())
						return clickMSubmit();
		}
		else if ((args[0]).trim().equalsIgnoreCase("no")) {
			isSelectedMember="No";
			//if(selectContactTypeForPhoneInteractionForAssocContract())
			//if(clickrbtnPhoneMemberContactmemberNo())
			if(utils.clickAnelemnt(rBtnContactMemberNo, "Phone Call", "Radio Button for Contact Member yes"))
				if(selectHIPAAverificationDetails())
				if(utils.scrolltomiddle())
					return clickMSubmit();
		}
		return false;

	}


	public ArrayList<String> getsearchResultbyColumn(String columnName){
		ArrayList<String> returnColumn =new ArrayList<String>();
		returnColumn=utils.getcolumnStringFromTableByName(this.gettblSearchresult(), columnName);
		return returnColumn;
	}
	//Driver.getPgDriver().findElement(By.id("$PHCMemberContactList$ppxResults$l$pSelectMember")).click();
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
		err.logError("First Impression", "Other Options and First Impression");
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
	 * @throws Exception 
	 * 
	 */
	public boolean searchAndSubmitPhoneMember(String[] args) throws Exception {
		Boolean flag = false;
		try {
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
				if(!utils.waitForElementToBeVisible(rdoFirstRow)) {
					Thread.sleep(3000);
					if(!utils.waitForElementToBeVisible(rdoFirstRow))
						return false;
				}
				if(flag)
					
						if(selectContactTypeForPhoneInteraction())
							if(fillNicknameandextension())
						//if(clickrbtnPhoneMemberContactmemberYes())
							return selectHIPAAverificationDetails();
								/*Dataset.datamap.put("isHippaAuthverified", "Yes");
								Dataset.datamap.put("isHippaAuthverified", "No");*/
								//return clickMSubmit();
				//return false;
			}
			return false;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			String[] value = args[1].split("/");
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
				if(!utils.waitForElementToBeVisible(rdoFirstRow)) {
					Thread.sleep(3000);
					if(!utils.waitForElementToBeVisible(rdoFirstRow))
						return false;
				}
				if(flag)
					
						if(selectContactTypeForPhoneInteraction())
							if(fillNicknameandextension())
						//if(clickrbtnPhoneMemberContactmemberYes())
							return selectHIPAAverificationDetails();
								/*Dataset.datamap.put("isHippaAuthverified", "Yes");
								Dataset.datamap.put("isHippaAuthverified", "No");*/
								//return clickMSubmit();
				//return false;
			}
			return false;

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

	@FindBy(xpath="//label[text()='Member Phone Number']")
	WebElement labelPhoneNo;

	@FindBy(xpath="//*[@data-test-id='201504281304350457121267']")
	WebElement labelVerificationID;

	@FindBy(xpath="//*[@data-test-id='201504281304350458122377']")
	WebElement labelVerificationDOB;

	@FindBy(xpath="//*[@data-test-id='2015042815070504775471-Label']")
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
			return true;
		}else
		{
			blogger.loginfo("Member ID is not auto checked");
			return false;
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

	public boolean verifyPhoneNoIsNotDisplayed()
	{
		utils.scrolltomiddle();
		boolean bol = utils.isProxyWebelement(labelVerificationphone);
		if(bol==true)
		{
			blogger.loginfo("Phone Number is not displayed");
			System.out.println("Phone Number is not displayed");
			return true;
		}else
		{
			blogger.loginfo("Phone Number is  displayed");
			System.out.println("Phone Number is  displayed");
			return false;
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

		if (verifymemberName(membername))
			return utils.clickAnelemnt(this.chckBxName, "SelectAssociatedContact", "Member name verify checkbox");
		return false;
	}

	public boolean clickchkbxVerificationMemberidverify(String[] memberid) {

		if (verifymemberID(memberid))
			return (utils.clickAnelemnt(this.chckBxMemberId, "SelectAssociatedContact", "Member id verify checkbox"));
		return false;

	}

	public boolean clickchkbxVerificationMemberDOB(String[] DOB) {
		if (verifymemberDOB(DOB))
			return (utils.clickAnelemnt(this.chckBxDOB, "SelectAssociatedContact", "Member DOB verify checkbox"));
		return false;

	}

	public boolean clickchkbxVerificationMemberphone(String[] phone) {
		if (verifymemberPhone(phone))
			return (utils.clickAnelemnt(this.labelPhoneNo, "SelectAssociatedContact", "Member {hone verify checkbox"));
		return false;

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
		{
			blogger.loginfo("All Hippa Details are unchecked except for Member ID");
			System.out.println("All Hippa Details are unchecked except for Member ID");
			return true;
		}
		else
		{
			blogger.loginfo("All Hippa Details are checked");
			System.out.println("All Hippa Details are checked");
			return false;
		}
	}


	public boolean selectValuesFromOtherActions(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(btnOtherActions, args[0], "GuestContact", "Guest Contact");
	}

	public boolean selectContactMemberYesOrNo(String[] args) throws InterruptedException {
		utils.waitforpageload();
		if(args[0].equalsIgnoreCase("Yes")) {
			isSelectedMember="Yes";
			return clickrbtnPhoneMemberContactmemberYes();
		}
		else
			isSelectedMember="No";
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
		err.logError("Exit Interaction", "Other Options and Exit Interaction");
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
		utils.waitforpageload();
		return utils.isvalueMatch_contain(sHeader[0], sHeaderSearchForMember.getText());

	}

	@FindBy(xpath="//div[contains(text(),'Other Actions')]")
	WebElement drpDownOtherActions;

	public boolean verifySearchForBrokerInOtherActionsOptionsInMemberSearchFlow(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, args[0], "PhoneCallMembersearchMember", "Other Actions");
	}

	public boolean searchbyMemberIDInChangeFocus(String[] sMemberID) throws InterruptedException
	{
		String value = sMemberID[0].substring(sMemberID[0].indexOf(":")+1);
		if(this.clickrbtnMemberID())
			if(this.setSuscriberID(value))
				if(this.clickMSearch())
					return true;
		return false;
	}


	//Sprint 6.3

	@FindBy(id="IsContactMemberYes")
	WebElement rdoBtnContactMemberYesForHIPPAEmail;

	@FindBy(id="IsContactMemberNo")
	WebElement rdoBtnContactMemberNoForHIPPAEmail;

	@FindBy(id="ReasonForInteraction")
	WebElement drpDownReasonForContactEmail;

	@FindBy(id="IsAllowedMemberContactYes")
	WebElement rdoBtnAllowedMemberContactYes;

	@FindBy(id="IsAllowedMemberContactNo")
	WebElement rdoBtnAllowedMemberContactNo;

	@FindBy(id="MemberName")
	WebElement txtBxContactFullName;


	public boolean clickSelectForContactAndReasonForContact(String[] args)
	{
		if(utils.clickAnelemnt(rdoBtnContactMemberYesForHIPPAEmail, "PhoneCallMemberSearchMember", "Select Contact"))
			if(utils.selectDropDownbyVisibleString(drpDownReasonForContactEmail, args[0], "PhoneCallMemberSearchMember", "Reason For Contact"))
				if(utils.clickAnelemnt(btnVerificationSubmit, "PhoneCallMemberSearchMember", "Submit"))				
					return true;
		return false;
	}


	public boolean clickYesOrNoInSelectForContact(String[] args)
	{
		if(args[0].equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(rdoBtnContactMemberYesForHIPPAEmail, "PhoneCallMemberSearchMember", "Select Contact");
		else
			return utils.clickAnelemnt(rdoBtnContactMemberNoForHIPPAEmail, "PhoneCallMemberSearchMember", "Select Contact");
	}

	public boolean selectReasonForContact(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownReasonForContactEmail, args[0], "PhoneCallMemberSearchMember", "Reason For Contact");		
	}


	public boolean clickYesOrNoInContactAllowedToReviewMembersAccount(String[] args)
	{
		if(args[0].equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(rdoBtnAllowedMemberContactYes, "PhoneCallMemberSearchMember", "Yes in Member Account");
		else
			return utils.clickAnelemnt(rdoBtnAllowedMemberContactNo, "PhoneCallMemberSearchMember", "No in Member Account");
	}

	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(btnVerificationSubmit, "PhoneCallMemberSearchMember", "Submit");
	}

	@FindBy(id="MemberList")
	WebElement rdoContactFullName;


	public boolean enterContactFullName(String[] args) throws InterruptedException
	{
		Thread.sleep(3000);
		if(utils.clickAnelemnt(rdoContactFullName, "PhoneCallMemberSearchMember", "Contact Full Name")) {
			Thread.sleep(3000);
			txtBxContactFullName.clear();
			if(utils.enterTextinAnelemnt(txtBxContactFullName, args[0], "PhoneCallMemberSearchMember", "Contcat Full Name")) {
				txtBxContactFullName.sendKeys(Keys.TAB);
				return true;
			}
		}
		return false;

	}

	//sprint 6.4

	//verify guided dialogue with user input data

	@FindBy(id="DialogContent")
	WebElement GuidedDialog;

	public boolean VerifyGuidedDialog(String[] args){
		return utils.isvalueMatch_contain(GuidedDialog.getText().trim().replaceAll("\n", "").replaceAll(",", ""), args[0]);
	}


	@FindBy(id="IsConnectedToMemberYes")
	WebElement RdBtnConnectMemberYes;

	@FindBy(id="IsConnectedToMemberYes")
	WebElement RdBtnConnectMemberNo;

	/*
	This Functionality enables the user to select Yes or No based on Input provided for connect with member
	 */

	public boolean selectConnectMemberYesOrNo(String[] args) throws InterruptedException {
		//Dataset.datamap.put("iscontacttheselectedmember", args[0]);
		utils.waitforpageload();
		if(args[0].equalsIgnoreCase("Yes")) {
			isSelectedMember="Yes";
			return utils.clickAnelemnt(RdBtnConnectMemberYes,  "Phone Call", "Radio Button for Connect Member yes");
		}
		else {
			isSelectedMember="No";
			return utils.clickAnelemnt(RdBtnConnectMemberNo, "Phone Call", "Radio Button for Connect Member No");
		}
	}


	@FindBy(id="IsAllMemSystemsSearch")
	WebElement IsAllMemSystemsSearch;

	/**Clicks on Checkbox Search All Source Systems
	 * 
	 */
	public boolean clickOnSourceSystemCheckbox() {
		return utils.clickAnelemnt(IsAllMemSystemsSearch, "Phone Call Member Search", "IsAllMemSystemsSearch");
	}

	/**Validate Unable to retrieve data is present
	 * 
	 * @return
	 */
	public boolean validateErrorMessage(String[] args) {
		System.out.println(searchUnabletoretrivedata.getText());
		System.out.println(args[0]);
		return utils.isvalueMatch_contain(searchUnabletoretrivedata.getText(),args[0]);
	}

	/**Validate Checkbox Search All Source Systems
	 * 
	 */
	public boolean validateSourceSystemCheckbox () {
		return !utils.isProxyWebelement(IsAllMemSystemsSearch);
	}


	/**This method is to search member, select first member, fill Nickname and extension and click on submit
	 * @throws Exception 
	 * 
	 */
	public boolean searchAndSubmitPhoneMemberForBrokerFlow(String[] args) throws Exception {
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
			/*fillNicknameandextension();
			clickrbtnPhoneMemberContactmemberYes();*/
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			utils.scrolltomiddle();
			utils.clickAnelemnt(Submit, "Phone Call", "Submit");
			blogger.loginfo("PASS: Searched Member, Selected firstname, filled in Nickname and Extension, Selected Yes for Contact Member and clicked on Submit");
			return true;
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
			/*fillNicknameandextension();
			clickrbtnPhoneMemberContactmemberYes();*/
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			utils.scrolltomiddle();
			utils.clickAnelemnt(Submit, "Phone Call", "Submit");
			blogger.loginfo("PASS: Searched Member, Selected firstname, filled in Nickname and Extension, Selected Yes for Contact Member and clicked on Submit");
			return true;

		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}
	}

	public boolean verifySSNFieldIsNotDisplayed() {
		return utils.isProxyWebelement(rBtnSubscriberSSN);
	}

	public boolean selectHIPAAverificationDetailsNew()
	{
		utils.waitforpageload();
		
				if(chckBxName.isSelected() && chckBxMemberId.isSelected() && chckBxDOB.isSelected())
					return true;
				else {
					if(!chckBxMemberId.isEnabled())	
						return false;
					if(!chckBxName.isSelected())
						if(utils.clickAnelemnt(this.chckBxName, "PhoneCallMemberSearchMember", "Member name verify checkbox"))
							if(!chckBxMemberId.isSelected())
								if(utils.clickAnelemnt(this.chckBxMemberId, "PhoneCallMemberSearchMember", "Member name verify checkbox"))
										if(!chckBxDOB.isSelected())
											if(utils.clickAnelemnt(this.chckBxDOB, "PhoneCallMemberSearchMember", "Member name verify checkbox"))
					return chckBxName.isSelected() && chckBxDOB.isSelected()&&chckBxMemberId.isSelected();
				}

				return false;
	}
@FindBy(xpath="//*[@data-test-id='20150914172816087067636']/../../../../../..//div[@class='field-item dataValueRead']//span[@class='header_bold_text']")
List<WebElement> HIPAACheck;

@FindBy(xpath="//div[contains(@class,'dataLabelWrite green_text')]")
WebElement HIPAAVerificationMsg;
	
	public boolean selectHIPAAverificationDetails() 
	{
		/*boolean flag=false;
		utils.waitforpageload();
		try {
		for(WebElement eachHIPAACheck:HIPAACheck) {
			if(utils.clickAnelemnt(eachHIPAACheck, "Search Member", "Search Results")) 
				flag=true;
		}
		if(flag) {
			return utils.validateLabel(HIPAAVerificationMsg,"HIPAA Verified. Proceed.");
		}
		}catch(Exception ex) {
			return false;
		}
		return false;*/
		if(utils.clickAnelemnt(this.chckBxName, "PhoneCallMemberSearchMember", "Member name verify checkbox"))
			if(utils.clickAnelemnt(this.chckBxDOB, "PhoneCallMemberSearchMember", "Member DOB verify checkbox"))
				if(chckBxName.isSelected() && chckBxMemberId.isSelected() && chckBxDOB.isSelected()) {
					isHippaAuthverified=true;
					return true;
				}
				else {
					if(!chckBxName.isSelected())
						utils.clickAnelemnt(this.chckBxName, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					if(!chckBxMemberId.isSelected() && chckBxMemberId.isEnabled())
						utils.clickAnelemnt(this.chckBxMemberId, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					if(!chckBxDOB.isSelected())
						utils.clickAnelemnt(this.chckBxDOB, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					return chckBxName.isSelected() && chckBxDOB.isSelected();
				}
		return false;
	}
	
	public boolean selectContractWithoutHIPPACerification(String[] args) throws InterruptedException{
		utils.waitForElementToBeClickabale(rBtnContactMemberYes);
		if((args[0]).trim().equalsIgnoreCase("yes")) {
			isSelectedMember="Yes";
			//if(selectContactTypeForPhoneInteraction())
			if(utils.clickAnelemnt(rBtnContactMemberYes, "Phone Call", "Radio Button for Contact Member yes"))
					if(utils.scrolltomiddle())
						return clickMSubmit();
		}
		else if ((args[0]).trim().equalsIgnoreCase("no")) {
			isSelectedMember="No";
			//if(selectContactTypeForPhoneInteractionForAssocContract())
			if(utils.clickAnelemnt(rBtnContactMemberNo, "Phone Call", "Radio Button for Contact Member yes"))
				if(utils.scrolltomiddle())
					return clickMSubmit();
		}
		return false;

	}
	
	

	@FindBy(xpath="//span[@id='ERRORMESSAGES_ALL']/ul/li")
	WebElement errorMessage;
	
	/**To validate the error message when user enter HCID greater than 9 digit
	 * 
	 * @return
	 */
	public boolean validateErrorMessageForHCIDGreaterThan9Digit(String[] args) {
	//	String value = sMemberID[0].substring(sMemberID[0].indexOf(":")+1);
		if(clickrbtnMemberID())
			if(setSuscriberID(args[0]))
				if(clickMSearch())
				return utils.isvalueMatch_contain(errorMessage.getText(),args[1]);
		return false;
	}
	
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT']/following::table[@pl_prop='HCMemberContactList.pxResults']")
	WebElement searchResultTable;
	
	public boolean verifyMemberSearchResults(String[] args)
	{
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(searchResultTable, args);
	}
	
	
	
	@FindBy(id="MemberContactType")
	WebElement AssociatedContactType;
	
	@FindBy(xpath="//label[@for='MemberContactType']")
	WebElement AssociatedContactTypeLabel;
	
	@FindBy(xpath="//label[@for='MemberContactType']/strong[@class='required-field-accessibility']")
	WebElement AssociatedContactTypeRequired;
	
	public boolean verifyAndEnterValueInContactType(String[] args){
		if(!utils.isProxyWebelement(AssociatedContactTypeLabel));
		if(!utils.isProxyWebelement(AssociatedContactTypeRequired));
	return utils.selectDropDownbyVisibleString(AssociatedContactType, args[0],  "Search Member", "Associated name");

	}
	
	public boolean selectContactTypeForPhoneInteraction(){
	if(!utils.isProxyWebelement(AssociatedContactTypeRequired))
	return utils.selectDropDownbyVisibleString(AssociatedContactType,"Member about self",  "Search Member", "Associated name");
	return false;

	}
	
	public boolean selectContactTypeForPhoneInteractionForAssocContract(){
		if(!utils.isProxyWebelement(AssociatedContactTypeRequired))
		return utils.selectDropDownbyVisibleString(AssociatedContactType,"Parent/Custodial Parent",  "Search Member", "Associated name");
		return false;

		}
	
	
	// Hipaa Redesign
	
		@FindBy(xpath="//label[@data-test-id='2015090812402005351861-Label']/span[text()='Contact's First and Last Name']")
		WebElement ContactFirstAndLastNameLabel;
		
		@FindBy(xpath="//label[@data-test-id='2015090812402005351861-Label']/strong[@class='required-field-accessibility']")
		WebElement ContactFirstAndLastNameRequired;
		
		@FindBy(xpath="//span[text()='Contact Type']/following-sibling::strong[text()='(Required)']/../..//select[@id='AssociatedContactType']")
		WebElement drpdownassociatecncttype;
		
		@FindBy(id="USDomainID")
		WebElement domainid;
		
		@FindBy(id="IsVerifiedAnthemAssociatedYes")
		WebElement rdoBtVerifiedAssociateYes;
		
		@FindBy(id="IsVerifiedAnthemAssociatedNo")
		WebElement rdoBtVerifiedAssociateNo;
		
		@FindBy(id="ContactTypeAttorney")
		WebElement txtBxNameofFirm;
		
		@FindBy(id="IsVerReqLawAdd")
		WebElement chkbxVerballyRequestAddressLaw;
		
		@FindBy(id="IsVerReqLawPhone")
		WebElement chkbxVerballyRequestNumberLaw;
		
		@FindBy(xpath="//span[text()='Exchange Name']/following-sibling::strong[text()='(Required)']/../..//select[@id='ExchangeName']")
		WebElement drpdownexchangename;
		
		@FindBy (xpath="//span[text()='Exchange Name']/following-sibling::strong[text()='(Required)']/../..//input[@id='OtherExchangeName']")
		WebElement txtboxexchangenameother;

		@FindBy(id="ProviderFirstName")
		WebElement txtBxProviderName;
		
		@FindBy(id="ProviderNumber")
		WebElement txtBxProviderNumber;

		@FindBy(id="IsVerReqProviderAdd")
		WebElement chkBtVerifiedAddress;
		
		@FindBy(id="IsVerReqProviderPhone")
		WebElement chkBtVerifiedPhoneNumber;
		
		@FindBy(id="OtherContactTypeRelation")
		WebElement txtBxContctTypeRelation;
		
		@FindBy(id="OtherContactBusinessName")
		WebElement txtBxContctBusinessName;
		
		@FindBy(xpath = "//button[@title='Complete this assignment']")
		WebElement btnSubmitButton;
		
		public boolean verifyAndEnterValueInContactFirstNameAndLastNameField(String[] args){
			if(!utils.isProxyWebelement(ContactFirstAndLastNameLabel));
			if(!utils.isProxyWebelement(ContactFirstAndLastNameRequired));
		return utils.enterTextinAnelemnt(txtbxNickName,args[0], "Search Member", "Contact First and Last name");

		}
		
		public boolean verifyTheContactTypeDropDownValues() {
			
			String [] valuestobchecked = new String[]{"Select Contact Type","Agent/Broker","Anthem Associate","Attorney","Parent/Custodial Parent","Friend/Relative","Group","Group Business Associate","Guardian/Representative","Insurance Carriers","Provider","Third Party Administrator","Member about self","Other member on Contract","Market Place/Exchange","Other"};
			ArrayList<String> associatecontacttypedrpdown = new ArrayList<String>();
			associatecontacttypedrpdown=utils.stringarraytoStringarrayList(valuestobchecked);
			
		return utils.checkvaluesinDropDown(drpdownassociatecncttype, associatecontacttypedrpdown);	
		}
		
		public boolean selectTheContactType(String[] args){
			
		return	utils.selectDropDownbyVisibleString(drpdownassociatecncttype, args[0], "Member search", "Contact Type");
		}
		
		
		public boolean selectContactTypeAsAnthemAssociateYes(String[] args){
			
			if(utils.selectDropDownbyVisibleString(drpdownassociatecncttype, args[0], "Member search", "Contact Type"))
			if(utils.enterTextinAnelemnt(domainid, args[1], "Member Search", "Domain Id"))
				return (utils.clickAnelemnt(rdoBtVerifiedAssociateYes, "Member Search", "Verified Associate Yes"));
			
			return false;
				
		}
		

		public boolean selectContactTypeAsAnthemAssociateNo(String[] args){
			
			if(utils.selectDropDownbyVisibleString(drpdownassociatecncttype, args[0], "Member search", "Contact Type"))
			if(utils.enterTextinAnelemnt(domainid, args[1], "Member Search", "Domain Id"))
				return (utils.clickAnelemnt(rdoBtVerifiedAssociateNo, "Member Search", "Verified Associate Yes"));
			
			return false;
			
		}
		
		public boolean selectContactTypeAsAttorney(String[] args){
			
			if(utils.selectDropDownbyVisibleString(drpdownassociatecncttype, args[0], "Member search", "Contact Type"))
				if(utils.enterTextinAnelemnt(txtBxNameofFirm, args[1], "Member Search", "Firm Name"))
					if(utils.clickAnelemnt(chkbxVerballyRequestAddressLaw, "Member Search", "Law Firm Address"))
						return (utils.clickAnelemnt(chkbxVerballyRequestNumberLaw, "Member Search", "Law Firm Phonenumber"));
			
			return false;
			
		}
		
		public boolean selectContactTypeAsMarketPlaceOrExchange(String[] args){
			
			if(utils.selectDropDownbyVisibleString(drpdownassociatecncttype, args[0], "Member search", "Contact Type"))
				return (utils.selectDropDownbyVisibleString(drpdownexchangename, args[1], "Member search", "Contact Type"));
			
		return false;
			
		}
		
		public boolean selectContactTypeAsProvider(String[] args){
			
			if(utils.selectDropDownbyVisibleString(drpdownassociatecncttype, args[0], "Member search", "Contact Type"))
				if(utils.enterTextinAnelemnt(txtBxProviderName, args[1], "Member search", "Provider name"))
					if(utils.enterTextinAnelemnt(txtBxProviderNumber, args[2], "Member search", "Provider number"))
						if(utils.clickAnelemnt(chkBtVerifiedAddress, "Member Search", "Verify Provider Address"))
							return (utils.clickAnelemnt(chkBtVerifiedPhoneNumber, "Member Search", "Verify Provider number"));
			
			return false;
			
		}

		public boolean selectContactTypeAsOther(String[] args){

			if(utils.selectDropDownbyVisibleString(drpdownassociatecncttype, args[0], "Member search", "Contact Type"))
				if(utils.enterTextinAnelemnt(txtBxContctTypeRelation, args[1], "Member search", "Member Realtionship"))
					return (utils.enterTextinAnelemnt(txtBxContctBusinessName, args[2], "Member search", "Firm name"));

			return false;
		}
		
		public boolean clickSubmitButton() {
			utils.scrolltomiddle();
			return utils.clickAnelemnt(btnSubmitButton, "Phone Call", "Button for Submit");
		}
		
		/*
		 * @SCU
		 * #CommonMethodwithArgument:selectContractMemberandSubmit
		 * #Arguments:Yes/No
		 * Type:Textbox
		 */
		public boolean selectContactTypeandClickSubmit(String[] args){
			if((args[0]).trim().equalsIgnoreCase("yes")) {
				isSelectedMember="Yes";
				if(selectContactTypeForPhoneInteraction())
						if(utils.scrolltomiddle())
							return clickMSubmit();
			}
			else if ((args[0]).trim().equalsIgnoreCase("no")) {
				isSelectedMember="No";
				if(selectContactTypeForPhoneInteractionForAssocContract())
					if(utils.scrolltomiddle())
						return clickMSubmit();
			}
			return false;
		}
		
		private List<WebElement> iframes;
		
		@FindBy(xpath="//select[contains(@id,'AssociatedContactType')]")
		WebElement Selectcontacttype;
		
		

		@FindBy(xpath="//select[contains(@id, 'BrokerTaxID')]")
		WebElement Brokerfirmname;
		
		@FindBy(xpath="//input[contains(@id, 'AgencyName')]")
		WebElement brokername;
		
		@FindBy(xpath="//input[contains(@id, 'AgencyNumber')]")
		WebElement brokernumber;
		
		
		@FindBy(xpath="//input[contains(@id, 'ContactTypeAttorney')]")
		WebElement lawfirm;
		
		@FindBy(xpath="//input[contains(@id, 'IsVerReqLawAdd')]")
		WebElement lawfirmaddr;
		
		@FindBy(xpath="//input[contains(@id, 'IsVerReqLawPhone')]")
		WebElement lawfirmphone;
        
        @FindBy(xpath="//input[contains(@id, 'ProviderFirstName')]")
		WebElement textgrppracname;
        
        @FindBy(xpath="//input[contains(@id, 'ProviderNumber')]")
		WebElement textgrpprovnumber;
        
        @FindBy(xpath="//select[contains(@id, 'AssociatedContactRole')]")
		WebElement drpcontctrole;
        
        @FindBy(xpath="//input[contains(@id, 'pyCompany')]")
		WebElement txtboxinsurname;
        
        @FindBy(xpath="//input[contains(@id, 'InsuranceTaxID')]")
		WebElement txtboxtaxid;
				
		@FindBy(xpath="//input[contains(@id, 'GridOrCaseOrTaskIcon')]")
		WebElement rdbfirstcontract;
		
		@FindBy(xpath="//input[contains(@id,'IsSSNVerified')]")
		WebElement chkbxVerificationMemberSSN;
		
		@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
		WebElement tabMbrCompositeMember;
		
		public void gotoLastIframe(){
			System.out.println("1");
			Driver.getPgDriver().switchTo().defaultContent();
			System.out.println("2");
			
			int i=this.iframes.size();
			System.out.println(i);
			Driver.getPgDriver().switchTo().frame(i-1);
			System.out.println("##########");
		}
		
		
		public boolean isMemberCompositeReached(){
			utils.waitforpageload();
			try {
				gotoLastIframe();
			} catch (UnhandledAlertException e) {
				// TODO Auto-generated catch block
				err.logError(e, "unhandled  alert error in switiching frame");
				e.printStackTrace();
			}
			return !utils.isProxyWebelement(tabMbrCompositeMember);

		}
		
	
     
     public boolean contcttypebroker(String[] args){
    	 utils.waitforpageload();
    	 if(utils.enterTextinAnelemnt(txtbxNickName, args[0], "PhoneCallMembersearchMember", "nickname"))
    		 if(utils.selectDropDownbyVisibleString(Selectcontacttype, args[1], "PhoneCallMembersearchMember", "contacttype"))
    			 if(utils.clickAnelemnt(rdoFirstMember, "PhoneCallMembersearchMember", "firstmember")){
    				 utils.waitforpageload();
    			 }
    				 if(utils.clickAnelemnt(radioDeclineNumberAccept, "PhoneCallMembersearchMember", "Decline"))
    					 if(utils.clickAnelemnt(rdbfirstcontract,"PhoneCallMembersearchMember","firstcontract"))
    					 {utils.scrolltomiddle();
    					 }
    					 
    					 if(utils.clickAnelemnt(chckBxDOB, "PhoneCallMembersearchMember", "DOB"))
    						 if(utils.clickAnelemnt(chckBxName, "PhoneCallMembersearchMember", "Name"))
    							 if(utils.clickAnelemnt(chckBxMemberId, "PhoneCallMembersearchMember", "memberid"))
    							 if(utils.clickAnelemnt(chkbxVerificationMemberSSN, "PhoneCallMembersearchMember", "Ssnverification"))							 
    									 if(utils.selectDropDownbyVisibleString(Brokerfirmname, args[2], "PhoneCallMembersearchMember", "Brokerfirmname"))
    										 if(utils.enterTextinAnelemnt(brokername, args[3],"PhoneCallMembersearchMember","brokername"))
    											 if(utils.enterTextinAnelemnt(brokernumber, args[4], "PhoneCallMembersearchMember", "Brokerfirmname"))
    												 return brokernumber.isDisplayed();
    	 return false;

    	 
     }
     
     public boolean contcttypeattorney(String[] args){
    	 utils.waitforpageload();
    		 if(utils.selectDropDownbyVisibleString(Selectcontacttype, args[0], "PhoneCallMembersearchMember", "contacttype"))   			 				 
    					if(utils.enterTextinAnelemnt(lawfirm, args[1], "PhoneCallMembersearchMember", "firmname"))
    						if(utils.clickAnelemnt(lawfirmaddr, "PhoneCallMembersearchMember", "lawfirmadd"))
    							if(utils.clickAnelemnt(lawfirmphone, "PhoneCallMembersearchMember", "lawfirmphone"))
    								 return lawfirmphone.isSelected();
    	 return false;
     
}
     public boolean contcttypeprovider(){
    	 utils.waitforpageload();
    		 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Provider", "PhoneCallMembersearchMember", "contacttype"))
    			 if(utils.enterTextinAnelemnt(textgrppracname, "Test", "PhoneCallMembersearchMember", "grppractname"))
    				 if(utils.enterTextinAnelemnt(textgrpprovnumber, "12345", "PhoneCallMembersearchMember", "grpprovnum"))
    					 return textgrpprovnumber.isDisplayed();
    		 return false;
     
}
     public boolean contcttypeinsurance(){
    	 utils.waitforpageload();
    		 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Insurance Carriers", "PhoneCallMembersearchMember", "contacttype"))
    			 if(utils.selectDropDownbyVisibleString(drpcontctrole, "Government Rep", "PhoneCallMembersearchMember","contctrole"))
    			 if(utils.enterTextinAnelemnt(txtboxinsurname, "Test", "PhoneCallMembersearchMember", "grppractname"))
    				 if(utils.enterTextinAnelemnt(txtboxtaxid, "12345", "PhoneCallMembersearchMember", "grpprovnum"))
    					 return txtboxtaxid.isDisplayed();
    		 return false;
}
     
     
     @FindBy(xpath="//input[contains(@id, 'IsVerifiedAnthemAssociatedYes')]")
		WebElement rdbverifyassciate;
     
     @FindBy(xpath="//input[contains(@id, 'USDomainID')]")
		WebElement txtboxUSid;
     
     public boolean contcttypeanthemasso(){
    	 utils.waitforpageload();
    		 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Anthem Associate", "PhoneCallMembersearchMember", "contacttype"))
    			 if(utils.clickAnelemnt(rdbverifyassciate, "PhoneCallMembersearchMember", "anthemverify"))
    			 if(utils.enterTextinAnelemnt(txtboxUSid, "AF23096", "PhoneCallMembersearchMember", "USid"))
    				 return txtboxUSid.isDisplayed();
    		 return false;
}
     
 	@FindBy(xpath= "//tr[@id='$PHCMemberPolicyList$ppxResults$l1']//input[contains(@id,'CaseOrTaskIcon')]")
	WebElement rdoFirstRow;


	 public boolean searchbySSN(String[] args) throws Exception{
    	 utils.waitforpageload();
    			 if(utils.clickAnelemnt(rdoFirstMember, "PhoneCallMembersearchMember", "firstmember")){
    				 utils.waitforpageload();
    			 }
    	 if(!utils.waitForElementToBeVisible(rdoFirstRow)) {
				Thread.sleep(3000);
				if(!utils.waitForElementToBeVisible(rdoFirstRow))
					return false;
			}
    		 if(utils.selectDropDownbyVisibleString(Selectcontacttype, args[1], "PhoneCallMembersearchMember", "contacttype"))
    			 if(utils.enterTextinAnelemnt(txtbxNickName, args[0], "PhoneCallMembersearchMember", "nickname"))
    				 if(utils.clickAnelemnt(radioDeclineNumberAccept, "PhoneCallMembersearchMember", "Decline"))
    					Thread.sleep(2000);
    		 			if(utils.clickAnelemnt(chckBxName, "PhoneCallMembersearchMember", "Name"))
    		 				 Thread.sleep(1000);
    					 if(utils.clickAnelemnt(chckBxDOB, "PhoneCallMembersearchMember", "DOB"))
    						 Thread.sleep(1000);
    							 if(utils.clickAnelemnt(rdoFirstRow, "SelectContract", "Radio button -firstRowofselectContracttable"))
    								 if(!utils.waitForElementToBeVisible(chkbxVerificationMemberSSN)) {
    										Thread.sleep(3000);
    										if(!utils.waitForElementToBeVisible(chkbxVerificationMemberSSN))
    											return false;
    									}
    							 if(utils.clickAnelemnt(chkbxVerificationMemberSSN, "PhoneCallMembersearchMember", "Ssnverification"))
    								 if(utils.clickAnelemnt(btnSubmitButton, "PhoneCallMembersearchMember", "submit"))
    									 return !utils.isProxyWebelement(tabMbrCompositeMember); 
   	 return false;

    	 
     }
	 
  @FindBy(xpath="//Select[contains(@id, 'GroupAdmins')]")
		WebElement drpgroup;
  
  @FindBy(xpath="//input[contains(@id, 'IsGroupNumberVerified')]")
		WebElement chkboxgrpnum;
  
  @FindBy(xpath="//input[contains(@id, 'IsGroupNameVerified')]")
		WebElement chkboxgrpname;
  
  @FindBy(xpath="//input[contains(@id, 'IsMemberAvailableToSpeakWithYes')]")
		WebElement rdbmemavailyes;
  
  @FindBy(xpath="//input[contains(@id, 'IsAnyActiveRecordPresentYes')]")
	WebElement rdbactiverecordyes;
  
  @FindBy(xpath="//input[contains(@id, 'IsActiveConfidentialCommunicationNo')]")
	WebElement rdbactiveconfidentialsno;
  
  @FindBy(xpath="//input[contains(@id, 'HasPHIPermissionYes')]")
	WebElement rdbphipermissyes;
  
  @FindBy(xpath="//input[contains(@id, 'GroupBAName')]")
 	WebElement txtbxcompaname;
  
  @FindBy(xpath="//input[contains(@id, 'ThirdPartyAdmin')]")
	WebElement txtbxthirdpartname;
  
  @FindBy(xpath="//input[contains(@id, 'PhoneNumber')]")
 	WebElement txtbxphnnum;
  
  @FindBy(xpath="//input[contains(@id, 'IsQCPhoneNumberVerified')]")
 	WebElement rdbphnnumverified;
  
  @FindBy(xpath="//input[contains(@id, 'OtherContactTypeRelation')]")
 	WebElement txtbxotherrelation;
  
  @FindBy(xpath="//input[contains(@id, 'OtherContactBusinessName')]")
	WebElement txtbxotherbusinessname;
  
  @FindBy(xpath="//select[contains(@id, 'ExchangeName')]")
	WebElement drpexchangename;
  
	 public boolean contcttypegroup(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Anthem Associate", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.selectDropDownbyVisibleString(drpgroup, "STAR", "PhoneCallMembersearchMember", "group"))
					 if(utils.clickAnelemnt(chkboxgrpnum, "PhoneCallMembersearchMember", "grpnum"))
						 if(utils.clickAnelemnt(chkboxgrpname, "PhoneCallMembersearchMember", "grpname"))
				 return chkboxgrpname.isSelected();
			 return false;
	}
	 public boolean contcttypefriend(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Friend/Relative", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.clickAnelemnt(rdbmemavailyes, "PhoneCallMembersearchMember", "memberavailableyes"))
					 if(utils.clickAnelemnt(rdbactiverecordyes,"PhoneCallMembersearchMember","activerecordyes"))
						 if(utils.clickAnelemnt(rdbactiveconfidentialsno, "PhoneCallMembersearchMember", "activerights"))
							 if(utils.clickAnelemnt(rdbphipermissyes, "PhoneCallMembersearchMember", "phiyes"))
								 return rdbphipermissyes.isSelected();
			 return false;
	}
	 public boolean contcttypecustodial(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Custodial Parent", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.clickAnelemnt(rdbmemavailyes, "PhoneCallMembersearchMember", "memberavailableyes"))
					 if(utils.clickAnelemnt(rdbactiverecordyes,"PhoneCallMembersearchMember","activerecordyes"))
						 if(utils.clickAnelemnt(rdbactiveconfidentialsno, "PhoneCallMembersearchMember", "activerights"))
							 if(utils.clickAnelemnt(rdbphipermissyes, "PhoneCallMembersearchMember", "phiyes"))
								 return rdbphipermissyes.isSelected();
			 return false;
	}
	 
	 public boolean contcttypegrpbusasso(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Group Business Associate", "PhoneCallMembersearchMember", "contacttype"))
				if(utils.enterTextinAnelemnt(txtbxcompaname, "Test", "PhoneCallMembersearchMember", "companyname"))
					if(utils.clickAnelemnt(chkboxgrpname, "PhoneCallMembersearchMember", "groupnam"))
						if(utils.clickAnelemnt(chkboxgrpnum, "PhoneCallMembersearchMember", "grpnum"))
							if(utils.enterTextinAnelemnt(txtbxphnnum, "1234567890", "PhoneCallMembersearchMember", "phonenum"))
								if(utils.clickAnelemnt(rdbphnnumverified,  "PhoneCallMembersearchMember", "verifyphonenumber"))
									return rdbphnnumverified.isSelected();
			 return false;
	}
	 public boolean contcttypeguardian(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Guardian/Representative", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.clickAnelemnt(rdbmemavailyes, "PhoneCallMembersearchMember", "memberavailableyes"))
					 if(utils.clickAnelemnt(rdbactiverecordyes,"PhoneCallMembersearchMember","activerecordyes"))
						 if(utils.clickAnelemnt(rdbactiveconfidentialsno, "PhoneCallMembersearchMember", "activerights"))
							 if(utils.clickAnelemnt(rdbphipermissyes, "PhoneCallMembersearchMember", "phiyes"))
								 return rdbphipermissyes.isSelected();
			 return false;
	}
	 public boolean contcttypemarket(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Market Place/Exchange", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.selectDropDownbyVisibleString(drpexchangename, "Access Health Connecticut", "PhoneCallMembersearchMember", "exchangename1"))
					 if(utils.selectDropDownbyVisibleString(drpexchangename, "Covered California", "PhoneCallMembersearchMember", "exchangename2"))
						 if(utils.selectDropDownbyVisibleString(drpexchangename, "Connect for Health Colorado", "PhoneCallMembersearchMember", "exchangename3"))
							 if(utils.selectDropDownbyVisibleString(drpexchangename, "New York State of Health", "PhoneCallMembersearchMember", "exchangename4"))
								 if(utils.selectDropDownbyVisibleString(drpexchangename, "Federal Marketplace/HealthCare.gov", "PhoneCallMembersearchMember", "exchangename5"))
									 return drpexchangename.isEnabled();
			 return false;
	}
	 public boolean contcttypeparent(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Parent", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.clickAnelemnt(rdbmemavailyes, "PhoneCallMembersearchMember", "memberavailableyes"))
					 if(utils.clickAnelemnt(rdbactiverecordyes,"PhoneCallMembersearchMember","activerecordyes"))
						 if(utils.clickAnelemnt(rdbactiveconfidentialsno, "PhoneCallMembersearchMember", "activerights"))
							 if(utils.clickAnelemnt(rdbphipermissyes, "PhoneCallMembersearchMember", "phiyes"))
								 return rdbphipermissyes.isSelected();
			 return false;
	}
	 public boolean contcttypethirdparty(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Third Party Administrator", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.enterTextinAnelemnt(txtbxthirdpartname, "Test", "PhoneCallMembersearchMember", "Thirdpartyname"))
				 if(utils.clickAnelemnt(chkboxgrpname, "PhoneCallMembersearchMember", "groupnam"))
						if(utils.clickAnelemnt(chkboxgrpnum, "PhoneCallMembersearchMember", "grpnum")) 
							return chkboxgrpnum.isEnabled();
			 return false;
	}
	 public boolean contcttypeother(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Other", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.enterTextinAnelemnt(txtbxotherrelation, "Testing", "PhoneCallMembersearchMember", "relationname"))
					 if(utils.enterTextinAnelemnt(txtbxotherbusinessname, "test", "PhoneCallMembersearchMember", "businessname"))
						 return txtbxotherbusinessname.isDisplayed();
			 return false;
	 }
	 public boolean contcttypothermembers(){
		 utils.waitforpageload();
			 if(utils.selectDropDownbyVisibleString(Selectcontacttype, "Other member on Contract", "PhoneCallMembersearchMember", "contacttype"))
				 if(utils.clickAnelemnt(rdofirstasscontact, "PhoneCallMembersearchMember", "First-asscontact"))
					 if(utils.clickAnelemnt(rdbmemavailyes, "PhoneCallMembersearchMember", "memberavailableyes"))
						 if(utils.clickAnelemnt(rdbactiverecordyes,"PhoneCallMembersearchMember","activerecordyes"))
							 if(utils.clickAnelemnt(rdbactiveconfidentialsno, "PhoneCallMembersearchMember", "activerights"))
								 if(utils.clickAnelemnt(rdbphipermissyes, "PhoneCallMembersearchMember", "phiyes"))
									 return rdbphipermissyes.isSelected(); 
			 return false;
	 }
	}

	 
	 



		






