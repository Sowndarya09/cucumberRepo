package automationLib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class EmailInteraction_SearchMember {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	public EmailInteraction_SearchMember(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement);
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//input[@data-test-id='201509021145130521847854']")
	WebElement MemberSearchBox;

	@FindBy(xpath="//*[text()='Search']")
	WebElement SearchButton;

	/**This functionality Searches for the member using the member ID given by the user. This functionality clicks on the search by member id radio, enters the member id and clicks on search button
	 * 
	 * @param args
	 * @return
	 */
	public boolean searchbyMemberID(String[] args) {
		if(utils.enterTextinAnelemnt(MemberSearchBox, args[0], "EmailInteraction_SearchMember", "MemberSearchBox"))
			return utils.clickAnelemnt(SearchButton, "EmailInteraction_SearchMember", "SearchButton");
		return false;
	}

	@FindBy(id="ContactEmailID")
	WebElement EmailID;

	/**This functionality enters the Email ID in the email ID text box in the Email interaction search member page
	 * 
	 * @param args
	 * @return
	 */
	public boolean enterEmailID(String[] args) {
		return utils.enterTextinAnelemnt(EmailID, args[0], "EmailInteraction_SearchMember", "EmailID");
	}

	@FindBy(id="CorrespondenceReceiveDate")
	WebElement CorrespondenceReceiveDate;

	/**This functionality enters the Email received date in the email received date text box in the Email interaction search member page
	 * 
	 * @param args
	 * @return
	 */
	public boolean enterEmailReceivedDate(String[] args) {
		return utils.enterTextinAnelemnt(CorrespondenceReceiveDate, args[0], "EmailInteraction_SearchMember", "CorrespondenceReceiveDate");
	}

	@FindBy(id="CaseOrTaskIcon")
	WebElement MemberRadioButton;

	/**This functionality selects the first member row in the member search result table
	 * 
	 * @return
	 */
	public boolean selectFirstMember() {
		return utils.clickAnelemnt(MemberRadioButton, "EmailInteraction_SearchMember", "MemberRadioButton");
	}

	@FindBy(id="IsContactMemberYes")
	WebElement IsContactMemberYes;

	@FindBy(id="IsContactMemberNo")
	WebElement IsContactMemberNo;

	/**This functionality Select yes or no from the select contract member option based on the user input
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectContactMemberYesOrNo(String[] args) {
		if(args[0].equalsIgnoreCase("yes"))
			return  utils.clickAnelemnt(IsContactMemberYes, "EmailInteraction_SearchMember", "IsContactMemberYes");
		else
			return utils.clickAnelemnt(IsContactMemberNo, "EmailInteraction_SearchMember", "IsContactMemberNo");
	}

	@FindBy(id="ReasonForInteraction")
	WebElement ReasonForContact;

	/** This method selects Reason for contact in HIPAA Verification section
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectReasonForContactDropdown(String[] args) {
		return utils.selectDropDownbyVisibleString(ReasonForContact, args[0], "EmailInteraction_SearchMember", "ReasonForContact");
	}

	@FindBy(id="HIPAADecisionGuide")
	WebElement HIPAADecisionGuideChckBox;

	@FindBy(className="Standard_Underline")
	WebElement HippaLink;

	/**This functionality verifies the link is displayed and the checkBox is clicked
	 * 
	 * @return
	 */
	public boolean clickCheckboxVerifyHIPAAlinkIsDisplayed() {
		action.moveToElement(HIPAADecisionGuideChckBox);
		if(!utils.isProxyWebelement(HippaLink))
			return utils.clickAnelemnt(HIPAADecisionGuideChckBox, "EmailInteraction_SearchMember", "HIPAADecisionGuideChckBox");
		return false;
	}

	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;

	/**This functionality clicks on the submit button in the E mail Interaction  page
	 * 
	 * @return
	 */
	public boolean selectSubmit() {

		if(utils.clickAnelemnt(SubmitButton, "EmailInteraction_SearchMember", "SubmitButton")) 
			return !utils.isAlertPresent();
		return false;
	}

	/**This functionality verifies the HIPAA link is not displayed
	 * 
	 * @return
	 */
	public boolean verifyHIPAALinkNotdisplayed() {
		
		if(utils.isProxyWebelement(HippaLink))
			return (utils.isProxyWebelement(HIPAADecisionGuideChckBox));
		return false;
	}
	
	@FindBy(id ="IsAllowedMemberContactYes")
	WebElement IsAllowedMemberContactYes;
	
	@FindBy(id = "IsAllowedMemberContactNo")
	WebElement IsAllowedMemberContactNo;
	
	/**This functionality selects Yes/No to  the contact allowed to review members account question
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectContactReviewMembersAccount(String args []) {
		if(args[0].equalsIgnoreCase("yes"))
			return  utils.clickAnelemnt(IsAllowedMemberContactYes, "EmailInteraction_SearchMember", "IsAllowedMemberContactYes");
		else
			return utils.clickAnelemnt(IsAllowedMemberContactNo, "EmailInteraction_SearchMember", "IsAllowedMemberContactNo");
	}
	
	@FindBy(id="HIPAATemplateForEmail1")
	WebElement HIPAATemplateForEmail1;
	
	@FindBy(id="HIPAATemplateForEmail2")
	WebElement HIPAATemplateForEmail2;
	
	@FindBy(xpath="//input[@id='HIPAATemplateForEmail1']/../../..//*[@data-test-id=\"20180912152306092331459\"]")
	WebElement HIPAATemplateForEmail1Verbiage;
	
	@FindBy(xpath="//input[@id='HIPAATemplateForEmail2']/../../..//*[@data-test-id=\"20180912152306092331459\"]")
	WebElement HIPAATemplateForEmail2Verbiage;
	
	/**This functionality selects the checkbox and validate the  first HIPAA template verbiage in search member page for e mail interaction
	 * 
	 * @return
	 */
	public boolean selectandValidateFirstHIPAAtemplateVerbiage() {
		if(!utils.isProxyWebelement(HIPAATemplateForEmail1Verbiage))
			return utils.clickAnelemnt(HIPAATemplateForEmail1, "EmailInteraction_SearchMember", "HIPAATemplateForEmail1");
		return false;
	}
	
	/**This functionality selects the checkbox and validate the  second HIPAA template verbiage in search member page for e mail interaction
	 * 
	 * @return
	 */
	public boolean selectandValidateSecondHIPAAtemplateVerbiage() {
		if(!utils.isProxyWebelement(HIPAATemplateForEmail2Verbiage))
			return utils.clickAnelemnt(HIPAATemplateForEmail2, "EmailInteraction_SearchMember", "HIPAATemplateForEmail2");
		return false;
	}
	
	@FindBy(xpath="//div[text()='Other Actions ']")
	WebElement OtherActions;
	
	@FindBy(xpath="//span[text()='Exit Interaction']")
	WebElement ExitInteraction;
	
	@FindBy(xpath="//span[text()='External Search']")
	WebElement ExternalSearch;
	
	/**
	 * This functionality verifies if the exit interaction and external search option is present in other actions drop down in select contract page for e mail interaction
	 * @return
	 */
	public boolean validateOtherActionsDropDown() {
	if(utils.clickAnelemnt(OtherActions, "EmailInteraction_SearchMember", "OtherActions"))
		return !utils.isProxyWebelement(ExitInteraction) && !utils.isProxyWebelement(ExternalSearch);
	return false;
	}
	
	@FindBy(xpath="//input[@id='MemberList']")
	List<WebElement> MemberList;
	
	/**This functionality selects the first contact name displayed
	 * 
	 * @return
	 */
	public boolean selectFirstContact() {
		return utils.clickAnelemnt(MemberList.get(0), "EmailInteraction_SearchMember", "MemberList");
	}
	
	//---> Pre Condition
	
	@FindBy(xpath="//table[contains(@pl_prop,'HCMemberContactList.pxResults')]")
	private WebElement searchResulttable;
	
	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMemberRow;
	
	public ArrayList<String> getsearchResultbyColumn(String columnName){
		ArrayList<String> returnColumn =new ArrayList<String>();
		returnColumn=utils.getcolumnStringFromTableByName(searchResulttable, columnName);
		return returnColumn;
	}
	
	public boolean clickselectColumnRadioButton (int row){
		ArrayList<WebElement> select = utils.getcolumnWebelemntFromTable(searchResulttable,"input" );
		if(utils.clickAnelemnt(select.get(row),"Phone cal member","resutlt table radio"))
			return true;
		else 
			return false;
	}
	
	public boolean selectReasonForContactDropdown() {
		return utils.selectDropDownbyVisibleString(ReasonForContact, "COB", "EmailInteraction_SearchMember", "ReasonForContact");
	}
	
	
	public boolean selectContactReviewMembersAccountYes() {
			return  utils.clickAnelemnt(IsAllowedMemberContactYes, "EmailInteraction_SearchMember", "IsAllowedMemberContactYes");
	}
	
	@FindBy(id="MemberList")
	WebElement rdoContactFullName;
	
	@FindBy(id="MemberName")
	WebElement txtBxContactName;
	
	public boolean clickContactNameAndEnterContactName() throws InterruptedException
	{
		if(utils.clickAnelemnt(rdoContactFullName, "EmailInteraction_SearchMember", "Contact Full Name"))
			Thread.sleep(2000);
			if(utils.enterTextinAnelemnt(txtBxContactName, "Test", "EmailInteraction_SearchMember", "Contact Full Name"))
				return true;
		return false;
	}
	
	
	public boolean selectMemberbyFirstName(String[] args){
		utils.waitforpageload();
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
	
	public boolean selectfirstMember(){
		return utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -firstRowofselectMembertable");
	}
	
	
	/**This method is to search member, select first member, fill Nickname and extension and click on submit
	 * @throws InterruptedException 
	 * 
	 */
	public boolean searchAndSubmitEmailMemberForBrokerFlow(String[] args) throws InterruptedException {
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
			selectReasonForContactDropdown();
			selectContactReviewMembersAccountYes();
			clickContactNameAndEnterContactName();
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			utils.scrolltomiddle();
			utils.clickAnelemnt(SubmitButton, "Phone Call", "Submit");
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
			selectReasonForContactDropdown();
			selectContactReviewMembersAccountYes();
			clickContactNameAndEnterContactName();
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[text()='Submit']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			utils.scrolltomiddle();
			utils.clickAnelemnt(SubmitButton, "Phone Call", "Submit");
			blogger.loginfo("PASS: Searched Member, Selected firstname, filled in Nickname and Extension, Selected Yes for Contact Member and clicked on Submit");
			return true;
			
		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate localDate = LocalDate.now()/*.plusDays(1)*/; 
	String Tdate=dtf.format(localDate );
	
	public boolean searchAndSubmitEmailMember(String[] args) throws InterruptedException {
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
					if(utils.enterTextinAnelemnt(EmailID,"Test@test.com", "EmailInteraction_SearchMember", "EmailID"))
						if(utils.enterTextinAnelemnt(CorrespondenceReceiveDate, Tdate, "EmailInteraction_SearchMember", "CorrespondenceReceiveDate"))
						if(utils.clickAnelemnt(IsContactMemberYes, "EmailInteraction_SearchMember", "IsContactMemberYes"))
						if(utils.selectDropDownbyIndex(ReasonForContact,1, "EmailInteraction_SearchMember", "ReasonForContact"))	
						{
							utils.scrolltomiddle();
							return utils.clickAnelemnt(SubmitButton, "EmailInteraction_SearchMember", "SubmitButton");
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
					if(utils.enterTextinAnelemnt(EmailID,"Test@test.com", "EmailInteraction_SearchMember", "EmailID"))
						if(utils.enterTextinAnelemnt(CorrespondenceReceiveDate, Tdate, "EmailInteraction_SearchMember", "CorrespondenceReceiveDate"))
						if(utils.clickAnelemnt(IsContactMemberYes, "EmailInteraction_SearchMember", "IsContactMemberYes"))
						if(utils.selectDropDownbyIndex(ReasonForContact,1, "EmailInteraction_SearchMember", "ReasonForContact"))	
						{
							utils.scrolltomiddle();
							return utils.clickAnelemnt(SubmitButton, "EmailInteraction_SearchMember", "SubmitButton");
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


}
