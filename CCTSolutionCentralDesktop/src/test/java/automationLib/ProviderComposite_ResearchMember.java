package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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
public class ProviderComposite_ResearchMember  extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	/**
	 * Constructor for Initializing and Switching to the respecting driver 
	 * 
	 */

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForMember;
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);

	public ProviderComposite_ResearchMember()
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
	//@FindBy (xpath="//img[@src='webwb/pzgrid_downarrow_12514994499.png!!.png']")	
	//@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
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
		String expectedText = sHeaderSearchForMember.getText();
		return utils.isvalueMatch_contain("Search for Member", expectedText);
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


	/*
	 * Click on Button 
	 * 
	 */
	/**
	 * Click on Search in Research Member Page 
	 */
	public boolean clickMSearch()
	{
		return utils.clickAnelemnt(this.getBtnSearchforMSearch(), "Research", "Button Search");
	}


	public boolean clickMSubmit()
	{
		utils.waitforpageload();
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
		String expectedText = sHeaderSearchForMember.getText();
		return utils.isvalueMatch_contain(sHeader, expectedText);
	}



	@FindBy(xpath ="//ul[@class='pageErrorList layout-noheader-errors']")
	WebElement searchUnabletoretrivedata;


	public WebElement getsearchnosuccessError(){
		return this.searchUnabletoretrivedata;
	}



	public boolean isSearchsuccess()
	{
		if(!utils.isServiceDown())
			return true;
		return false;

	}
	/*
	 * Methods to Follow the sequence
	 */


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

		if(this.clickrbtnMemberID())
			if(this.setSuscriberID(sMemberID[0]))
				utils.scrolltomiddle();
		if(this.clickMSearch())
			if( this.isSearchsuccess())
				return true;	
		return false;
	}

	public boolean searchByMemberID(String[] sMemberID) throws InterruptedException
	{
		if(getHeaderforTabsVerification("Search for Member"))
			if(this.clickrbtnMemberID())
				if(this.setSuscriberID(sMemberID[0]))
					if(this.clickMSearch())
						if( this.isSearchsuccess()) 
							return true;
		return false;
	}

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
		return false;
	}



	/**
	 * Search through SNN Last name, DOB and First name 
	 * @param sLastName
	 * @param sFirstName
	 * @param sDOB
	 * @return
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


	@FindBy(xpath="//*[@class='gridTable ']")
	private WebElement searchResulttable;
	@FindBy(xpath="//th//div[text()='Select']']")
	private WebElement searchResulttableHeaderselect;
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




	/**
	 * Contact Member  and click on submit
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:fillNicknameandextension
	 * Type:Textbox


	 */
	public boolean selectSubmit() throws InterruptedException{
		if (this.clickMSubmit())
		{
			try{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("*[@class='pzbtn-mid'][text()='Search']")));
			}catch(Exception e)
			{
				this.clickMSubmit();
			}
			return true;
		}

		else 
			return false;
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
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectfirstMember
	 * #Description: This functionality selects the first member row in the member search result table.
	 * Type: Textbox
	 */
	public boolean selectfirstMember(){
		return utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -	firstRowofselectMembertable");
	}

	/**This method is to search member, select first member and click on submit
	 * @throws InterruptedException 
	 * 
	 */
	public boolean searchAndSubmitMember(String[] args) throws InterruptedException {
		try {
			String[] value = args[2].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			searchbyMemberID(memberid);
			utils.waitforpageload();
			int i = utils.getIndexValueOfStringArray(value,"MemberFirstName");
			if(i != 0) {
				String[] firstname = value[i].substring(value[i].indexOf(":")+1).split(",");
				selectMemberbyFirstName(firstname);
			}else {
				selectfirstMember();
			}
			selectSubmit();
			blogger.loginfo("PASS: Searched Member, Selected firstname and clicked on Submit");
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
			selectSubmit();
			blogger.loginfo("PASS: Searched Member, Selected firstname and clicked on Submit");
			return true;

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

	/**Validate Unable to retrieve data is present
	 * 
	 * @return
	 */
	public boolean validateErrorMessage(String[] args) {
		System.out.println(searchUnabletoretrivedata.getText());
		System.out.println(args[0]);
		return utils.isvalueMatch_contain(searchUnabletoretrivedata.getText(),args[0]);
	}

	@FindBy(id="IsAllMemSystemsSearch")
	WebElement IsAllMemSystemsSearch;

	/**Clicks on Checkbox Search All Source Systems
	 * 
	 */
	public boolean clickOnSourceSystemCheckbox() {
		return utils.clickAnelemnt(IsAllMemSystemsSearch, "Phone Call Member Search", "IsAllMemSystemsSearch");
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
	 * Clicks Is this an ITS -HOST Account member radio button in Change Focus Search Member Section using data 
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
	
	@FindBy(id="ITSHOSTRegionalSkill")
	WebElement ITSHOSTDropDOwn;
	
	/**This functionality selects the value given by the user in the ITS Host DropDown at the Member search screen in change focus
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
	
	/**Verify Alpha Prefix Router Is Available Under Search By at Search for Member at change focus screen in Phone call provider flow
	 * 
	 * @return
	 */
	
	@FindBy(xpath="//a[text()='Alpha Prefix Router']")
	WebElement AlphaPrefixLink;
	
	public boolean validateAlphaPrefixRouterLinkIsAvailable(){
		return !utils.isProxyWebelement(AlphaPrefixLink);
	}
	@FindBy(xpath="//div[@data-test-id='20190528060134088518343']")
	WebElement HostNoteMSG;
	
	public boolean validateHostNoteforProviderInFocus(){
		
		String HostNoteMSGValue = "**Note: A provider must be put in focus and have an appropriate HOST Skills to initiate any HOST interaction.";
		String HostNoteMSGValueFromUI = this.HostNoteMSG.getText().replaceAll(",", "").replaceAll("  ", " ");
		System.out.println(HostNoteMSGValueFromUI);
		return utils.isvalueMatch_compareto(HostNoteMSGValueFromUI, HostNoteMSGValue);

}
	@FindBy(xpath="//span[text()='Is this an ITS -HOST Account member']")
	WebElement HostQuestion;
	
	//Validate that the  Is this an ITS -HOST Account member Question is available in Search for Member screen in Research Provider flow
	public boolean validateIsThisHostAccountQuestionisAvailable(){
		return !utils.isProxyWebelement(HostQuestion);
	}
		
	//Validate that the  Is this an ITS -HOST Account member Question is Not available in Search for Member screen in Research Provider flow
	public boolean validateIsThisHostAccountQuestionisNotAvailable(){
		return utils.isProxyWebelement(HostQuestion);
	}
	
	
	
}


