package automationLib;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;
import java.text.SimpleDateFormat;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class SecureMessageMember_SearchMember {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	WebDriverWait wait;

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructer for the SecureMessageMember_SearchMember class defining the Iframe and the Page Factory  
	 * @throws IOException 
	 */
	public SecureMessageMember_SearchMember() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver

	}

	@FindBy(id="SecureMessageRefNum")
	WebElement txtBxSecureMsgRefNum;

	@FindBy(id="CorrespondenceReceiveDate")
	WebElement txtBxCorrespondenceReceiveDate;

	@FindBy(id="SearchStringMemberID")
	WebElement txtBxMemberID;


	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForMember;

	@FindBy(id="MemberSearchTypeMember ID")
	private WebElement rBtnMID;

	@FindBy (xpath="//*[@data-test-id='2015082811210004244498']")	
	private WebElement btnSearchforMSearch;

	@FindBy(xpath="//table[@pl_prop='HCMemberContactList.pxResults']")
	private WebElement searchResulttable;

	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMemberRow;

	@FindBy (xpath="//button[@title='Complete this assignment']")	
	private WebElement btnSubmit;

	@FindBy(id="IsContactMemberYes")
	private WebElement rBtnContactMemberYes;
	@FindBy(id="IsContactMemberNo")
	private WebElement rBtnContactMemberNo;


	@FindBy (id="pyFirstName")
	private WebElement txtbxOtherActionsGuestFirstName;


	@FindBy(xpath="//label[@data-test-id='20150908170657046839845']")
	WebElement  labelIscontacttheselected;


	/**
	 * Validate header of the page
	 * @param header
	 * @return
	 */

	public boolean getHeaderforTabsVerification(String sHeader)
	{
		return utils.isvalueMatch_contain(sHeader, sHeaderSearchForMember.getText());
	}



	public boolean clickrbtnMemberID()
	{
		return utils.clickAnelemnt(this.getrBtnMID(), PhoneCallMembersearchMember.class.getName(), "Radio MemberId");


	}
	public WebElement getrBtnMID() {
		return rBtnMID;
	}


	public boolean setSuscriberID(String sSuscriberID)
	{
		return utils.enterTextinAnelemnt(this.gettxtbxMembeID(), sSuscriberID, "Phone Call", "Text Box SubscriberID");

	}

	public WebElement gettxtbxMembeID() {
		return txtBxMemberID;
	}

	public boolean clickMSearch()
	{
		return utils.clickAnelemnt(this.getBtnSearchforMSearch(), "Phone Call", "Button Search");

	}

	public WebElement getBtnSearchforMSearch() {
		return btnSearchforMSearch;
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

	public boolean isSearchsuccess()
	{
		return (!utils.isServiceDown());

	}

	public boolean searchbyMemberID(String[] sMemberID) throws InterruptedException
	{

		if(getHeaderforTabsVerification("Search for Member"))
		{
			String value = sMemberID[0].substring(sMemberID[0].indexOf(":")+1);
			if(this.clickrbtnMemberID())
				if(this.setSuscriberID(value))
					if(this.clickMSearch())
						waitforpageload();
			if( this.isSearchsuccess())
				return true;
		}	
		return false;
	}


	public boolean validateIfCertainFieldsArePresent()
	{
		return !utils.isProxyWebelement(txtBxSecureMsgRefNum) && !utils.isProxyWebelement(txtBxCorrespondenceReceiveDate);
	}



	public boolean fillSecureMessageReferenceNumber(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxSecureMsgRefNum, args[0], "SecureMessageMemberSearchMember", "Ref Num");
	}

	public boolean fillCorrespondeceRecievedDate(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxCorrespondenceReceiveDate, args[0], "SecureMessageMemberSearchMember", "Correspondence Date");
	}
	
	
	@FindBy(xpath="//span[@id='ERRORMESSAGES_ALL']/ul/li")
	WebElement CorrespondenceReceiveDateErrorMsg;
	
	public boolean validateCorrespondenceReceiveDateErrorMessage()
	{
		String Actual = CorrespondenceReceiveDateErrorMsg.getText();
		return utils.isvalueMatch_compareto(Actual, "Correspondence Received Date cannot be a future date");
	}

	public ArrayList<String> getsearchResultbyColumn(String columnName){
		ArrayList<String> returnColumn =new ArrayList<String>();
		returnColumn=utils.getcolumnStringFromTableByName(this.gettblSearchresult(), columnName);
		return returnColumn;
	}

	public WebElement gettblSearchresult() {
		return this.searchResulttable;
	}

	public boolean clickselectColumnRadioButton (int row){
		ArrayList<WebElement> select = utils.getcolumnWebelemntFromTable(this.gettblSearchresult(),"input" );
		if(utils.clickAnelemnt(select.get(row),"Secure message member","resutlt table radio"))
			return true;
		else 
			return false;
	}

	public boolean selectMemberbyFirstName(String[] args){
		String value=args[0].substring(args[0].indexOf(":")+1);
		System.out.println(args[0]+"       "+value);
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=getsearchResultbyColumn("First Name");
		try{
			if(this.clickselectColumnRadioButton(utils.returnindexofelemntinanarray(firstnameColumn, value)))
				return true;
			else 
				err.logcommonMethodError("secure message Search member", "selectMemberbyFirstName");
			return false;
		}catch(Exception e)
		{if(!utils.isServiceDown())
			if(this.clickselectColumnRadioButton(utils.returnindexofelemntinanarray(firstnameColumn, value)))
				return true;
			else 
				err.logcommonMethodError("Secure message Search member", "selectMemberbyFirstName");
		return false;
		}

	}

	public boolean selectFirstMember(){
		return utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -firstRowofselectMembertable");
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public boolean clickOnSubmit()
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

	public WebElement getrBtnContactMemberYes() {
		return rBtnContactMemberYes;
	}

	public WebElement getrBtnContactMemberNo() {
		return rBtnContactMemberNo;
	}




	@FindBy(id="IsAllowedMemberContactYes")
	WebElement rdoBtnAllowedMemberContactYes;

	@FindBy(id="IsAllowedMemberContactNo")
	WebElement rdoBtnAllowedMemberContactNo;

	public boolean verifyAndSelectReviewMemberAccountYesOrNo(String[] args)
	{
		if(args[0].contains("Yes"))
			return utils.clickAnelemnt(rdoBtnAllowedMemberContactYes, "SecureMessageMember_SearchMember", "Yes - Radio Button");
		else
			return utils.clickAnelemnt(rdoBtnAllowedMemberContactNo, "SecureMessageMember_SearchMember", "Yes - Radio Button");
	}

	@FindBy(xpath="//label[@data-test-id='2018080316311909081683']")
	WebElement labelHIPPATemplateVerbiage;


	public boolean selectContactMemberYesOrNo(String[] args) {
		if(args[0].equalsIgnoreCase("Yes")) 
			return clickrbtnSecureMessageMemberContactmemberYes();
		else
			return clickrbtnSecureMessageMemberContactmemberNo();
	}

	public boolean clickrbtnSecureMessageMemberContactmemberYes()
	{
		if(this.rBtnContactMemberYes.isDisplayed())
			return utils.clickAnelemnt(this.getrBtnContactMemberYes(), "Phone Call", "Radio Button for Contact Member yes");
		else
			utils.scrolltomiddle();
		return utils.clickAnelemnt(this.getrBtnContactMemberYes(), "Phone Call", "Radio Button for Contact Member yes");
	}

	public boolean clickrbtnSecureMessageMemberContactmemberNo()
	{
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("window.scrollBy(0,450)","");
		return utils.clickAnelemnt(this.getrBtnContactMemberNo(), "Phone Call", "Radio Button for Contact Member no");
	}


	public boolean ClickSubmit()
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(this.getBtnSubmit(), "SecureMessage_search Member", "Submit"))
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


	public boolean selectfirstMember(){
		try{
			return utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -firstRowofselectMembertable");
		}
		catch(Exception e){
			utils.isServiceDown();
			System.out.println("Exception occured while selecting first member"+e);
			return false;
		}
	}



	public boolean txtBxSecureMsgRefNum(String snickName)
	{
		return utils.enterTextinAnelemnt(this.txtBxSecureMsgRefNum, snickName, "SecureMessage", "Reference Number");

	}

	public boolean fillCorrespondeceRecievedDate(String NreceiveDate)
	{
		return utils.enterTextinAnelemnt(this.txtBxCorrespondenceReceiveDate, NreceiveDate, "SecureMessage", "correspondence receive date");

	}

	public boolean fillsecuremessagereferencenumAndCorrespondencereceiveDate(){
		int a=1;
		try{
			a++;
			if(this.txtBxSecureMsgRefNum("123456789012"))
				if (this.fillCorrespondeceRecievedDate("01/01/2017"))
				{

					return true;
				}
				else{ 
					err.logcommonMethodError("secure message member search", "fillsecuremessagereferencenumAndCorrespondencereceiveDate");
					return false;}
			else {
				err.logcommonMethodError("secure message member search", "fillsecuremessagereferencenumAndCorrespondencereceiveDate");
				return false;
			}
		}catch(Exception e)
		{
			if(a>1)
			{
				fillsecuremessagereferencenumAndCorrespondencereceiveDate();
				return true;
			}
			else
				return false;
		}
	}

	/**This functionality allows the users to create secure message-Member interaction followed by search member,enter secure message reference number 
	 * and correspondence received date ,select the member based on input,select yes for contact the selected member and finally click submit button*/

	public boolean searchAndSubmitSecureMember(String[] args) throws InterruptedException {
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

				if(flag)
					if(fillsecuremessagereferencenumAndCorrespondencereceiveDate())
						if(clickrbtnSecureMessageMemberContactmemberYes()) {
							WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
							((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
							utils.scrolltomiddle();
							return utils.clickAnelemnt(btnSubmit, "Secure Member", "Submit");
						}
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
					if(fillsecuremessagereferencenumAndCorrespondencereceiveDate())
						if(clickrbtnSecureMessageMemberContactmemberYes()) {
							WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
							((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
							utils.scrolltomiddle();
							return utils.clickAnelemnt(btnSubmit, "Phone Call", "Submit");
						}
				return false;
			}
			return false;
		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}
	}



	@FindBy(id="IsAllowedMemberContactYes")
	WebElement ContactAllowedReviewYes;


	@FindBy(id="IsAllowedMemberContactNo")
	WebElement ContactAllowedReviewNo;

	/**
	 * This Method select yes or No for contact allowed to review members account through secure message interaction"
	 * @param args
	 * @return
	 */
	public boolean selectContactAllowedToReviewMemebersAccountYesorNo(String[] args)
	{
		if(args[0].equalsIgnoreCase("Yes")){ 
			return clickrbtnContactAllowedReviewYes();}
		else
			return clickrbtnContactAllowedReviewNo();
	}

	public boolean clickrbtnContactAllowedReviewYes()
	{
		return utils.clickAnelemnt(ContactAllowedReviewYes, "SecureMessagemember_searchMember", "ContactAllowedReviewYes");
	}

	public boolean clickrbtnContactAllowedReviewNo()
	{
		return utils.clickAnelemnt(ContactAllowedReviewNo, "SecureMessagemember_searchMember", "ContactAllowedReviewNo");
	}


	public boolean selectContactRadiobutton(String[] args)
	{

		String tempxpath ="//*[text()='"+args[0]+"']/ancestor::div[@class='content layout-content-inline content-inline  ']//*[@id='MemberList']"; 
		System.out.println(tempxpath);
		Driver.pgDriver.findElement(By.xpath("//*[text()='"+args[0]+"']/ancestor::div[@class='content layout-content-inline content-inline  ']//*[@id='MemberList']")).click();
		blogger.loginfo("select Contact Radiobutton is checked");
		return true;	
	}

	@FindBy(id="MemberName")
	WebElement ContactFullName;
	/*
	 * This Method allows the user to enter the contact full name in the contact full name field"
	 * 
	 */

	public boolean enterContactFullName(String[] args)
	{
		Driver.pgDriver.findElement(By.xpath("//*[text()='Contact Full Name']/ancestor::div[@class='content layout-content-inline content-inline  ']//*[@id='MemberList']")).click();
		if(utils.enterTextinAnelemnt(ContactFullName, args[0],"SecureMessage_Search Member","ContactFullName"))
			return true;
		return false;
	}

	@FindBy(id="HIPAATemplateReview")
	WebElement HIPAATemplatecheckbox;

	@FindBy(xpath="//label[@data-test-id='20180912152306092331459']")
	WebElement HIPAATemplateVerbiage;

	/**
	 * This Method validate the HIPAA template verbiage and select the check box tagged to it in Search member page through secure message interaction"
	 * @return
	 */
	public boolean selectandValidateHIPAAtemplateVerbiage()
	{
		if(utils.clickAnelemnt(HIPAATemplatecheckbox, "SecureMessage_Search Member","HIPAATemplatecheckbox"))
		{
			String ActualVerbiage=HIPAATemplateVerbiage.getText().replaceAll("\n","");
			String ExpectedVerbiage="HIPAA template verbiage : Our records indicate you are writing from another member's account. You are welcome to contact us, but please do so from your own account.You can register an account by using the identification number on your card, and your own name and date of birth. Please be advised, no action was taken on this inquiry.";
			return utils.isvalueMatch_compareto(ActualVerbiage, ExpectedVerbiage);
		}
		return false;
	}

	@FindBy(xpath="//div[@id=\"DialogContent\"]")
	WebElement labelGuidedDialog;

	public boolean validateGuidedDialog(String[] args){
		String message=labelGuidedDialog.getText().replaceAll("\n", "");
		return utils.isvalueMatch_contain(message, args[0]);
	}
	
	@FindBy(xpath="//span[@data-test-id='2018122801054902911865']")
	WebElement SMFollowUpDateActivityNotes;
	
	@FindBy(xpath="//span[@data-test-id='20181226184011027672360']")
	WebElement SMFollowUpDateActivityCreatedDate;
	
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT']/following::table[@pl_prop='HCMemberContactList.pxResults']")
	WebElement searchResultTable;
	
	public boolean verifyMemberSearchResults(String[] args)
	{
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(searchResultTable, args);
	}
	



}
