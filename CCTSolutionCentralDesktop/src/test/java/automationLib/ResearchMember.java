package automationLib;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

import com.google.common.primitives.Ints;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

/**
 * Objects in the 
 * @author shardul.singh.negi
 *
 */
public class ResearchMember  extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	/**
	 * Constructor for Initializing and Switching to the respecting driver 
	 * 
	 */

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForMember;
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);

	public ResearchMember()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}




	private String sDDReasonforExitname= "$PpyWorkPage$pCancelReason"; 
	private String sDDReasonforExitid= "CancelReason"; 
	private String sCCBLocationNamename="$PpyWorkPage$pCcbLocationName";
	private String sCCBLocationNameid="CcbLocationName";
	/**
	 * 
	 * Webelements to be used in program
	 */


	@FindBy(id="PegaGadget0Ifr")
	WebElement IframeelementBase;
	@FindBy(xpath="//*[@class='Header_nav'][text()=' Research']")
	private WebElement sHeaderResearchTab;

	/**
	 * Radio Buttons with Member Functions 
	 */
	@FindBy(id="MemberSearchTypeSubscriber SSN")
	private WebElement rBtnSubscriberSSN;
	@FindBy(id="MemberSearchTypeMember ID")
	private WebElement rBtnMID;
	@FindBy(id="MemberSearchTypeName and DOB")
	private WebElement rBtnMNameDOB;
	@FindBy(id="MemberSearchTypeMember SSN")
	private WebElement rBtnMSearchSSN;
	@FindBy(id="MemberSearchTypeName and Group")
	private WebElement rBtnMNameGroup;
	@FindBy(id="MemberSearchTypeName and SSN")
	private WebElement rBtnMNameSSN;

	@FindBy(id="IsContactMemberYes")
	private WebElement rBtnContactMemberYes;
	@FindBy(id="IsContactMemberNo")
	private WebElement rBtnContactMemberNo;
	@FindBy(xpath="//img[@alt='Loading...']")
	WebElement loadingicon;

	@FindBy(tagName="CaseOrTaskIcon")
	private WebElement rdioSearchresults;

	// External search 
	@FindBy(id="CcbLogEventYes")
	private WebElement rBtnExtSerchLogEvent;
	@FindBy(id="CcbLogEventNo")
	private WebElement rBtnExtSerchViewMembrshp;


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


	// Guest Contact Page 
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



	/**
	 * Buttons to be used 
	 */
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Search']")	
	private WebElement btnSearchforMSearch;

	//Xpath for Submit throughout is same class
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Submit']")	
	private WebElement btnSubmit;
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Launch CCB']")	
	private WebElement btnLaunchCCB;




	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;
	@FindBy (xpath="//img[contains(@src,'tool_icon_')]")	
	private WebElement btnImgTool;

	// Tool Mark 
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;

	// Other Actions 

	@FindBy (xpath="//span[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement lnkOtherActionExitInteraction;

	//TODO
	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;




	//Header for the Page 

	@FindBy (className="anthem_theme_header")	
	private WebElement headerForThemePage;


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
	public WebElement getrBtnExtSerchLogEvent() {
		return rBtnExtSerchLogEvent;
	}
	public WebElement getrBtnExtSerchViewMembrshp() {
		return rBtnExtSerchViewMembrshp;
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





	/**
	 * Header 
	 * @return
	 */
	public WebElement getHeaderForThemePage() {
		return headerForThemePage;
	}
	public void setsPhoneCallTab(WebElement sPhoneCallTab) {
		this.sHeaderResearchTab = sPhoneCallTab;
	}


	/**
	 * Radio Button 
	 * @param rBtnSubscriberSSN
	 */

	public void setTxtbxMemberID(WebElement txtbxMemberID) {
		this.txtbxMemberID = txtbxMemberID;
	}
	public void setTxtbxMSearchLastName(WebElement txtbxMSearchLastName) {
		this.txtbxMSearchLastName = txtbxMSearchLastName;
	}
	public void setTxtbxMSearchFirstName(WebElement txtbxMSearchFirstName) {
		this.txtbxMSearchFirstName = txtbxMSearchFirstName;
	}
	public void setTxtbxMSearchDOB(WebElement txtbxMSearchDOB) {
		this.txtbxMSearchDOB = txtbxMSearchDOB;
	}
	public void setTxtbxMSearchGroupNum(WebElement txtbxMSearchGroupNum) {
		this.txtbxMSearchGroupNum = txtbxMSearchGroupNum;
	}
	public void setTxtbxMSearchSSN(WebElement txtbxMSearchSSN) {
		this.txtbxMSearchSSN = txtbxMSearchSSN;
	}
	public void setTxtbxMSearchLast4SSN(WebElement txtbxMSearchLast4SSN) {
		this.txtbxMSearchLast4SSN = txtbxMSearchLast4SSN;
	}




	/**
	 * Getters Functions 
	 * @return
	 */

	public WebElement gettxtbxMembeID() {
		return txtbxMemberID;
	}
	public WebElement getsPhoneCallTab() {
		return sHeaderResearchTab;
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


	/**
	 * Filling in the Text Boxes
	 * 
	 * @param sSuscriberID
	 */
	public boolean setSuscriberID(String sData)
	{
		return utils.enterTextinAnelemnt(this.gettxtbxMembeID(), sData, "Research", "Text Box SubscriberID");

	}
	public boolean setSearchLastName(String sData)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLastName(), sData, "Research", "Text Box Last Name");

	}
	public boolean setTxtbxMSearchFirstName(String sData)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchFirstName(), sData, "Research", "Text Box First Name");

	}
	public boolean setTxtbxMSearchDOB(String sData)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchDOB(), sData, "Research", "Text Box DOB");

	}
	public boolean setMGroupNum(String sGroupNum)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchGroupNum(), sGroupNum, "Research", "Text Box GroupNum");

	}
	public boolean setMSearchSN(String sData)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchSSN(), sData, "Research", "Text Box SSN");

	}
	public boolean setMSearchLast4SSN(String sData)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLast4SSN(), sData, "Research", "Text Box Last 4 SSN");

	}

	/*
	 * Radio Button 
	 */
	public boolean clickrbtnMSearchSSN()
	{
		return utils.clickAnelemnt(this.getrBtnMSearchSSN(), "Research", "Radio Button MemberSSN");


	}

	public boolean clickrbtnMSubSSN()
	{
		return utils.clickAnelemnt(this.getrBtnSubscriberSSN(), "Research", "Radio Button SubscriberSSN");
	}

	public boolean clickrbtnMNameSSN()
	{
		return utils.clickAnelemnt(this.getrBtnMNameSSN(), "Research", "Radio Button MemberName&SSN");

	}
	public boolean clickrbtnMNameGroup()
	{
		return utils.clickAnelemnt(this.getrBtnMNameGroup(), "Research", "Radio Button name&group");

	}
	public boolean clickrBtnMNameDOB()
	{
		return utils.clickAnelemnt(this.getrBtnMNameDOB(), "Research", "Radio Button Name&DOB");

	}




	/*
	 * Set Value 
	 */
	public boolean setMSearchLast4SSNLastNAme(String sData)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchLastName(), sData, "Research", "Text Box Last Name");

	}
	public boolean setMSearchLast4SSNFirstName(String sData)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchFirstName(), sData, "Research", "Text Box First Name");

	}
	public boolean setMSearchLast4SSNDOB(String sData)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxMSearchDOB(), sData, "Research", "Text Box DOB");

	}

	// Checking header for the Page 
	public boolean getHeaderSearchforMember()
	{
		if("Search for Member".contains(sHeaderSearchForMember.getText()))
			return true;
		else
			return false; 
	}

	/**
	 * Click on Radio Button 
	 */
	public boolean clickMemberID()
	{
		return utils.clickAnelemnt(this.getrBtnMID(),"Research", "RadioMemberId");
	}


	public boolean clickMNameDOB()
	{
		return utils.clickAnelemnt(this.getrBtnMNameDOB(), "Research", "Radio Button Name&DOB");
	}

	public boolean clickMSuscriberID()
	{
		return utils.clickAnelemnt(this.getrBtnSubscriberSSN(), "Research", "Radio Button subscriberSSN");
	}

	public boolean clickMSearchSSN()
	{
		return utils.clickAnelemnt(this.getrBtnMSearchSSN(), "Research", "Radio Button MemberSSN");
	}

	public boolean clickMNameGroup()
	{
		return utils.clickAnelemnt(this.getrBtnMNameGroup(), "Research", "Radio Button name&group");
	}

	public boolean clickMNameSSN()
	{
		return utils.clickAnelemnt(this.getrBtnMNameSSN(), "Research", "Radio Button MemberName&SSN");
	}


	/**
	 * Click on Search in Research Member Page 
	 */
	public boolean clickMSearch()
	{
		action.moveToElement(getBtnSearchforMSearch());
		return utils.clickAnelemnt(this.getBtnSearchforMSearch(), "Research", "Button Search");			
	}


	public boolean clickMSubmit()
	{
		utils.waitforpageload();
		WebElement element = Driver.pgDriver.findElement(By.xpath("//*[@class='pzbtn-mid'][text()='Submit']"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		action.moveToElement(getBtnSubmit());
		if(utils.clickAnelemnt(this.getBtnSubmit(), "Research Member", "Submit"))
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


	public boolean clickrbtnMemberID()
	{
		return utils.clickAnelemnt(this.getrBtnMID(), PhoneCallMembersearchMember.class.getName(), "Radio MemberId");
	}


	public boolean getHeaderforTabsVerification(String sHeader)
	{
		return utils.isvalueMatch_contain(sHeader, sHeaderSearchForMember.getText());
	}



	@FindBy(className ="pageErrorList layout-noheader-errors")
	WebElement searchUnabletoretrivedata;


	public WebElement getsearchnosuccessError(){
		return this.searchUnabletoretrivedata;
	}



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
	 * MEmber ID entry in page to enter the  value and checvk  the result  
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
			if(this.clickrbtnMemberID())
				if(this.setSuscriberID(sMemberID[0]))
					if(this.clickMSearch())
						if( this.isSearchsuccess())  
							return true;
		return false;
	}

	/*public boolean searchByMemberID(String[] sMemberID) throws InterruptedException
	{
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMemberID())
				if(this.setSuscriberID(sMemberID[0]))
					if(this.clickMSearch())
						if( this.isSearchsuccess())  
							return true;
		return false;
	}*/
	/**
	 * Suscriber SSN text box
	 * @param sMemberSuscriberSNN: Enter Text for Suscriber SSN
	 * @return
	 */



	public boolean searchByMemberSuscriberSSN(String[] sMemberSuscriberSNN)
	{
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMSubSSN())
				if(setMSearchSN(sMemberSuscriberSNN[0]))
					if(clickMSearch())
						if( this.isSearchsuccess())
							return true;
		err.logError("Error in the HEader Page");
		return false;
	}



	/**
	 * Search through SNN Last name, DOB and First name 
	 * @param sLastName
	 * @param sFirstName
	 * @param sDOB
	 * @return
	 */
	public boolean searchByNameandDOB(String[] sData ) throws InterruptedException
	{

		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrBtnMNameDOB())
				wait=new WebDriverWait(Driver.pgDriver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringFirstName")));
		if(setMSearchLast4SSNLastNAme(sData[0]))
			if(setMSearchLast4SSNFirstName(sData[1]))
				if(setMSearchLast4SSNDOB(sData[2]))
					if(clickMSearch())
						if( this.isSearchsuccess())
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
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMSearchSSN())
				wait=new WebDriverWait(Driver.pgDriver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringSSN")));
		if(setMSearchSN(sMemberSNN[0]))
			if(clickMSearch())
				if( this.isSearchsuccess())
					return true;
		return false;

	}

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
				wait=new WebDriverWait(Driver.pgDriver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringFirstName")));
		if(setMSearchLast4SSNLastNAme(sData[0]))
			if(setMSearchLast4SSNFirstName(sData[1]))
				if(setMGroupNum(sData[2]))
					if(clickMSearch())
						if( this.isSearchsuccess())
							return true;
		return false;
	}

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
				wait=new WebDriverWait(Driver.pgDriver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchStringLast4SSN")));
		if(setMSearchLast4SSNLastNAme(sData[0]))
			if(setMSearchLast4SSNFirstName(sData[1]))
				if(setMSearchLast4SSN(sData[2]))
					if(clickMSearch())
						if( this.isSearchsuccess())
							return true;
		return false;
	}


	public boolean clickbtnOtherActions()
	{
		return utils.clickAnelemnt(this.getBtnOtherActions(), "Research searchmember", "Other actions button");
	}

	public boolean clickselectColumnRadioButton (int row){
		ArrayList<WebElement> select = utils.getcolumnWebelemntFromTable(this.gettblSearchresult(),"input" );
		if(utils.clickAnelemnt(select.get(row),"Research member","resutlt table radio"))
			return true;
		else 
			return false;
	}


	//@FindBy(xpath="//*[@class='gridTable ']")
	@FindBy(xpath="//table[@pl_prop='HCMemberContactList.pxResults']")
	private WebElement searchResulttable;

	@FindBy(xpath="//th//div[text()='Select']']")
	private WebElement searchResulttableHeaderselect;

	@FindBy(xpath="//table[contains(@pl_prop,'HCMemberContactList.pxResults')]//tr[@id='$PHCMemberContactList$ppxResults$l1']")
	private WebElement SearchResultSuccess;

	@FindBy(xpath="//table[contains(@pl_prop,'HCMemberContactList.pxResults')]//tr[@id='Grid_NoResults']")
	private WebElement SearchResultFail;

	public WebElement gettblSearchresultheaderselect() {
		return this.searchResulttableHeaderselect;
	}
	public WebElement gettblSearchresult() {
		return this.searchResulttable;
	}

	public boolean selectMemberbyFirstName(String[] args){
		utils.waitforpageload();
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=getsearchResultbyColumn("First Name");
		if(this.clickselectColumnRadioButton(utils.returnindexofelemntinanarray(firstnameColumn, args[0])))
			return true;
		else 
			err.logcommonMethodError("Research Search member", "selectMemberbyFirstName");
		return false;

	}

	public ArrayList<String> getsearchResultbyColumn(String columnName){
		ArrayList<String> returnColumn =new ArrayList<String>();
		returnColumn=utils.getcolumnStringFromTableByName(this.gettblSearchresult(), columnName);
		return returnColumn;
	}

	public boolean setMNickname(String snickName)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxNickName(), snickName, "Member-SearchLast4SNN", "TxtBoxSubscriberID");
	}

	public boolean setMCallBackNumber(String scallBackNumber)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxCallBackNumber(), scallBackNumber, "Member-SearchLast4SNN", "TxtBoxSubscriberID");
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:fillNicknameandextension
	 * Type:Textbox


	 */
	int count1;
	public boolean selectSubmit() throws InterruptedException{
		utils.waitforpageload();
		utils.scrolltomiddle();
		return utils.clickAnelemnt(btnSubmit, "ResearchMember", "Submit");
	}


	public boolean clicklinkexitInteraction()
	{
		return utils.clickAnelemnt(this.getLnkOtherActionExitInteraction(), "Research searchmember", "Other Exitinteraction");
	}

	public WebElement getLnkOtherActionExitInteraction() {
		return lnkOtherActionExitInteraction;
	}



	/**
	 * Exit Interaction Navigation from Phone Call members
	 * 
	 * @return
	 */
	public boolean exitInteraction(){

		if(this.clickbtnOtherActions())
			if(this.clicklinkexitInteraction())	
				return true;
			else 
				return false;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectfirstMember
	 * #Description: This functionality selects the first member row in the member search result table.
	 * Type: Textbox
	 */
	public boolean selectfirstMember(){
		if(utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -	firstRowofselectMembertable")) {
			utils.scrolltomiddle();
			return utils.clickAnelemnt(btnSubmit, "SelectMember", "Submit");
		}
		return false;

	}

	/**This method is to search member, select first member and click on submit
	 * @throws InterruptedException 
	 * 
	 */
	public boolean searchAndSubmitMember(String[] args) throws InterruptedException {
		Thread.sleep(2000);
		Boolean flag = false;
		try {
			String[] value = args[2].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			if(searchbyMemberID(memberid)) {
				utils.waitforpageload();
				int i = utils.getIndexValueOfStringArray(value,"MemberFirstName");
				if(i != 0) {
					String[] firstname = value[i].substring(value[i].indexOf(":")+1).split(",");
					flag = selectMemberbyFirstName(firstname);
				}else {
					flag = selectfirstMember();
				}

				if(flag)
					return selectSubmit();
				return false;
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

				if(flag)
					return selectSubmit();
				return false;
			}
			return false;

		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}

	}

	@FindBy(id="ContinueWithoutMember")
	WebElement ContinueWithoutMember;

	public boolean clickContinueWithoutMember() {
		utils.waitforpageload();
		return utils.clickAnelemnt(ContinueWithoutMember, "ResearchMember", "ContinueWithoutMember");
	}

	public boolean displayContinueWithoutMember() {
		utils.waitforpageload();
		return !utils.isProxyWebelement(ContinueWithoutMember);
	}

	@FindBy(xpath="//span[contains(text(),'HIPAA Verification')]")
	WebElement labelHipaaVerification;

	@FindBy(xpath="//span[contains(text(),'HIPAA Verification')]")
	WebElement labelGuidedDialog;

	public boolean verifyGuidedDialogsAreNotPresent()
	{
		return utils.isProxyWebelement(labelGuidedDialog);
	}

	public boolean verifyHIPPAVerficationFieldIsNotPresent()
	{
		return utils.isProxyWebelement(labelHipaaVerification);
	}

	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT']/following::table[@pl_prop='HCMemberContactList.pxResults']")
	WebElement searchResultTable;

	public boolean verifyMemberSearchResults(String[] args)
	{
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(searchResultTable, args);
	}







	/** Search Member using DB Integration
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean searchbyMemberIDUsingDB() throws InterruptedException, ClassNotFoundException, SQLException
	{
		//Intialize DB class
		DB_Validation db = new DB_Validation();

		//Returns key value from DB, which is stored in a map
		Map<String, ArrayList<String>> map 
		= db.fetchDataFromDB("UATMember", "select distinct * from ehub_mbr_sds.memberinsights WHERE ROWNUM <= 3");

		//Get the data by using column name which is same as in the ehub DB, and get any rows present in the result
		String HCID = map.get("HCID").get(0); //map.get("HCID").get(i); 

		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMemberID())
				if(this.setSuscriberID(map.get("HCID").get(0)))
					if(this.clickMSearch())
						if( this.isSearchsuccess())  
							return true;
		return false;
	}
	
	@FindBy(xpath= "//tr[@id='$PHCMemberPolicyList$ppxResults$l1']//input[contains(@id,'CaseOrTaskIcon')]")
	WebElement rdoFirstRow;

	
	/**This method is to search member, select first member and click on submit
	 * @throws InterruptedException 
	 * 
	 */
	public boolean searchAndSubmitMemberForPhonecallProvider(String[] args) throws InterruptedException {
		Thread.sleep(2000);
		Boolean flag = false;
		try {
			String[] value = args[2].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			if(searchbyMemberID(memberid)) {
				utils.waitforpageload();
				int i = utils.getIndexValueOfStringArray(value,"MemberFirstName");
				if(i != 0) {
					String[] firstname = value[i].substring(value[i].indexOf(":")+1).split(",");
					flag = selectMemberbyFirstName(firstname);
				}else {
					flag= selectfirstMember();
				}

				if(!utils.waitForElementToBeVisible(rdoFirstRow)) {
					Thread.sleep(3000);
					if(!utils.waitForElementToBeVisible(rdoFirstRow))
						return false;
				}
				if(flag)
					//return selectSubmit();
					return true;
				return false;
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
					//return selectSubmit();
					return true;
				return false;
			}
			return false;

		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}

	}


}


