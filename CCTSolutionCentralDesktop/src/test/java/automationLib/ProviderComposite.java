package automationLib;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ProviderComposite extends Driver{


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);
	public ProviderComposite()
	{
		try
		{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		System.out.println("provider comp constructor");
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
		System.out.println("PROVIDER comp frame sithced");
		}catch(Exception e)
		{PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		System.out.println("provider comp constructor");
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		System.out.println("PROVIDER comp frame sithced");
			
		}
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Add task(s)']")
	WebElement addtaskbutton;

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")
	WebElement promisedactions;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Wrap Up']")
	WebElement btnproviderCompositeWrapup;

	@FindBy(id="DialogContent")
	WebElement providerCompositeHeader;

	@FindBy(xpath="//*[contains(@id,'CPMTaskSearchInput')][1]")
	private WebElement SearchInput;

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")	
	private WebElement btnAddTAsk;

	@FindBy(xpath="//*[@id='$PTaskMenuSearchResults$ppxResults$l1']")
	private WebElement lnkClickonLinkafterSettingValue;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	private WebElement tabproviderCompositeMember;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Contract']")
	private WebElement tabproviderCompositeContract;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Group']")
	private WebElement tabproviderCompositeGroup;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Interactions']")
	private WebElement tabproviderCompositeInteraction;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Provider']")
	private WebElement tabproviderCompositeProvider;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Verification History']")
	private WebElement tabproviderVerificationHistory;

	@FindBy(xpath="//*[@title='Manage ID Card']")
	WebElement ManageIDCardOption;

	public boolean verifyProvider(){
		return utils.validateHeader(this.tabproviderCompositeProvider, "Provider");
	}

	public boolean verifyMember(){		
		return utils.validateHeader(this.tabproviderCompositeMember,"Member");
	}

	public boolean verifyContract(){
		return utils.validateHeader(this.tabproviderCompositeContract,"Contract");
	}

	public boolean verifyGroup(){
		return utils.validateHeader(this.tabproviderCompositeGroup,"Group");
	}

	public boolean verifyInteractions(){
		return utils.validateHeader(this.tabproviderCompositeInteraction,"Interactions");
	}

	public boolean verifyVerificationHistory(){
		return utils.validateHeader(this.tabproviderVerificationHistory,"Verification History");
	}

	public WebElement getbtnAddTAsk()
	{
		return btnAddTAsk;
	}

	public WebElement getchkbxSEacrchInput()	{
		return SearchInput;
	}

	public WebElement getlnkClickonLinkafterSettingValue()
	{
		return lnkClickonLinkafterSettingValue;
	}


	public boolean verifyProviderCompositeComponents()
	{
		utils.waitforpageload();
		if(this.verifyProvider() && this.verifyContract() && this.verifyMember() && this.verifyGroup() && this.verifyInteractions() && this.verifyVerificationHistory())
			return true;
		else
			return false;

	}

	public boolean clickbtnAddTask()
	{
		
		return utils.clickAnelemnt(this.getbtnAddTAsk(), "Provider Composite ", "Add Task Button ");

	}

	public boolean setTxtFullContactName(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getchkbxSEacrchInput(), sFullName, "Member Composite", "Application took a long time to load");

	}

	public boolean clicklnkClickonLinkafterSettingValue() throws InterruptedException
	{
		Thread.sleep(2000);
		return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValue, "Member Composite", "Text Box Add Task Options");

	}



	public boolean verifyproviderCompositeHeaderFromProviderNotFound(){

		utils.waitforpageload();
		return utils.validateHeader(providerCompositeHeader,"For information on becoming an Anthem network provider please visit our website Anthem.com.");

	}

	public boolean  navigateToManageBilling() throws InterruptedException
	{
		Thread.sleep(2000);
		utils.waitforpageload();
		try{
			clickbtnAddTask();
			utils.waitforpageload();
		}
		catch(Exception e)
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
			clickbtnAddTask();
			utils.waitforpageload();
		}
		utils.waitforpageload();
		wait=new WebDriverWait(Driver.pgDriver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")));
		return clicklnkClickonLinkafterSettingValue("Manage Enrollment");
	}



	public boolean  navigateToPromisedAction() throws InterruptedException
	{
		Thread.sleep(2000);
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			wait=new WebDriverWait(Driver.pgDriver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")));
			if(utils.clickAnelemnt(this.promisedactions, "Provider Composite", "Promised actions under add task"))
				return utils.clickAnelemnt(this.addtaskbutton, "Provider Composite", "Add task(s) button ");
		}
		return false; 
	}



	public boolean clickWrapUp()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(this.btnproviderCompositeWrapup, "Provider Composite", "Wrapup");

	}    


	public boolean  navigateToManageAuthorizations() throws InterruptedException
	{
		Thread.sleep(2000);
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Manage Authori"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}    


	public boolean navigateToManageClaims() throws InterruptedException
	{
		utils.waitforpageload();

		try{
			this.clickbtnAddTask();
			utils.waitforpageload();
		}
		catch(Exception e)
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
			this.clickbtnAddTask();
		}			
		if(this.clicklnkClickonLinkafterSettingValue("Manage Claims"))
		{
			System.out.println("Pass : The Value is Manage Claims is entered in the text Field and is navigateed to the required page ");
			return true; 
		}
		return false; 

	}


	public boolean navigateToManangeIDCard() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{			
			wait=new WebDriverWait(Driver.pgDriver,25);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Manage ID Card'][@class='Add_task']")));
			if(setTxtFullContactName("Manage ID Card"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value is Manage ID Card is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}

		System.out.println("Fail : There is some error with naviagted value");
		return false; 

	}

	public static String SRIDAfterSubstring;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: getSRIDFromTask
	 * #Description: This functionality gets the SR ID from the task created.
	 * #Argument: Task
	 * Type: Textbox
	 */
	public boolean getSRIDFromTask(String[] task)
	{

		String SrID = Driver.pgDriver.findElement(By.xpath("//a[contains(text(),'"+task[0]+"')]")).getText().trim();
		System.out.println("SR ID Value is: "+ SrID);
		SRIDAfterSubstring = SrID.substring(SrID.indexOf("(")+1,SrID.indexOf(")")).trim();
		System.out.println("Trimmed String: "+ SRIDAfterSubstring);
		return true;
	}

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Manage Alerts'][@class='Add_task']")
	WebElement elemManageAlert;

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Manage Referrals'][@class='Add_task']")
	WebElement elemManageReferral;

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='View Programs'][@class='Add_task']")
	WebElement elemViewProgram;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyManageAlertIsNotPresentForProvider
	 * #Description: This functionality verifies that the Manage Alert task is not displayed or not for the provider flow.
	 * Type: Textbox
	 */
	public boolean verifyManageAlertIsNotPresentForProvider() throws InterruptedException
	{
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement2);
		this.clickbtnAddTask();
		return utils.isProxyWebelement(elemManageAlert);

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyManageReferralIsNotPresentForProvider
	 * #Description: This functionality verifies that the Manage Referral task is not displayed or not for the provider flow.
	 * Type: Textbox
	 */
	public boolean verifyManageReferralIsNotPresentForProvider() throws InterruptedException
	{
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement2);
		this.clickbtnAddTask();
		return utils.isProxyWebelement(elemManageAlert);
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyViewProgramIsNotPresentForProvider
	 * #Description: This functionality verifies that the View Program task is not displayed or not for the provider flow.
	 * Type: Textbox
	 */
	public boolean verifyViewProgramIsNotPresentForProvider() throws InterruptedException
	{
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement2);
		this.clickbtnAddTask();
		return utils.isProxyWebelement(elemManageAlert);

	}


	public boolean  navigateTOLimitedLiability() throws InterruptedException
	{
		Thread.sleep(2000);
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			Thread.sleep(2000);
			if(setTxtFullContactName("Limited Liability"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value 'Limited Liability' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with naviagted value");
		return false; 
	}      

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateTOCDHP
	 * Type:Textbox
	 * Description:This method clicks on 'Add Task' and perform search on 'Consumer Driven Health Plan' and move to CDHP task screen.
	 */
	public boolean  navigateToCDHP() throws InterruptedException
	{
		utils.waitforpageload();

		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Consumer Driven Health Plan"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					blogger.loginfo("Pass : The Value is 'Consumer Driven Health Plan' is entered in the text Field and is navigated to the required page");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with navigated value");
		return false; 

	} 

	@FindBy(xpath="//div[contains(text(),'Change Focus')]")
	WebElement btnChangeFocus;

	@FindBy(xpath="//button[@id='submitButton']")
	WebElement btnSubmitInChangeFocus;

	public boolean clickChangeFocus()
	{
		return utils.clickAnelemnt(this.btnChangeFocus, "ProviderComposite", "Change Focus button");
	}

	public boolean clickSubmitInChangeFocusPopUp()
	{
		return utils.clickAnelemnt(this.btnSubmitInChangeFocus, "ProviderComposite", "Submit button");
	}


	@FindBy(id="MemberSearchTypeMember ID")
	private WebElement rBtnMID;

	@FindBy (id="SearchStringMemberID")	
	private WebElement txtbxMemberID;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Search']")	
	private WebElement btnSearchforMSearch;

	public WebElement getrBtnMID() {
		return rBtnMID;
	}

	public WebElement gettxtbxMembeID() {
		return txtbxMemberID;
	}

	public WebElement getBtnSearchforMSearch() {
		return btnSearchforMSearch;
	}

	public boolean clickrbtnMemberID()
	{
		return utils.clickAnelemnt(this.getrBtnMID(), PhoneCallMembersearchMember.class.getName(), "Radio MemberId");
	}

	public boolean setSuscriberID(String sSuscriberID)
	{
		return utils.enterTextinAnelemnt(this.gettxtbxMembeID(), sSuscriberID, "Phone Call", "Text Box SubscriberID");
	}

	public boolean clickMSearch()
	{
		return utils.clickAnelemnt(this.getBtnSearchforMSearch(), "Phone Call", "Button Search");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchbyMemberID
	 * #Arguments:memberID
	 * Type:Textbox
	 */
	public boolean searchbyMemberID(String[] sMemberID) throws InterruptedException
	{
		String value = sMemberID[0].substring(sMemberID[0].indexOf(":")+1);
		if(this.clickrbtnMemberID()){
			if(this.setSuscriberID(value)){
				if(this.clickMSearch()){
					Thread.sleep(2000);
					utils.waitforpageload();
					return true;
				}
			}
		}
		return false;

	}

	public boolean  navigateToProvider() throws InterruptedException
	{
		Thread.sleep(2000);
		utils.waitforpageload();
		try{
			this.clickbtnAddTask();
			utils.waitforpageload();
		}
		catch(Exception e)
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
			this.clickbtnAddTask();
		}
		return this.clicklnkClickonLinkafterSettingValue();

	}    



	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateToGrievanceAndAppeals
	 * Type:Textbox
	 * Description:This method clicks on 'Add Task' and perform search on 'Grievance and Appeals' and move to Grievance and Appeals task screen.
	 */
	public boolean  navigateToGrievanceAndAppeals() throws InterruptedException
	{
		utils.waitforpageload();

		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Grievance and Appeals"))
			{

				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The value 'Grievance and Appeals' is entered in the text Field and is navigated to the required page");
					return true; 
				}
			}
		}
		System.out.println("Fail : There is some error with navigated value");
		return false; 

	} 

	@FindBy(id="po0")
	private WebElement addTaskMenu;

	@FindBy(xpath="//*[@data-test-id='20150527044600067319555' or contains(text(), 'Add task(s)')]")
	private WebElement lnkClickonAddTaskInDropdown;

	public boolean clicklnkClickonLinkafterSettingValue(String args) throws InterruptedException
	{
		boolean flag=false;
		try 
		{
			utils.waitforpageload();
			List<WebElement> allOptions = addTaskMenu.findElements(By.xpath("//a[@class='Add_task']"));
			for ( int i=0;i<=allOptions.size();i++) {
				if(allOptions.get(i).getText().contains(args)){
					allOptions.get(i).click();
					utils.waitforpageload();
					Actions action = new Actions(pgDriver);
					action.moveToElement(lnkClickonAddTaskInDropdown);
					JavascriptExecutor executor = (JavascriptExecutor)pgDriver;
					executor.executeScript("arguments[0].click();", lnkClickonAddTaskInDropdown);
					flag=true;
					break;
				}
			}

			if(flag==true) {
				blogger.loginfo(args+" is displayed and Add task is clicked. Navigating to the section");
				return true;
			}else {
				blogger.loginfo(args+" is not displayed");
				err.logError("MemberComposite", "lnkClickonAddTaskInDropdown");
				return false;
			}
		}
		catch(StaleElementReferenceException e )
		{
			blogger.loginfo("Exception: "+e);
			err.logError("StaleElementReferenceException", "lnkClickonAddTaskInDropdown");
			return false;
		}

	}

	public boolean navigateToTask(String task) throws InterruptedException {
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			if(this.clicklnkClickonLinkafterSettingValue(task))
			{
				blogger.loginfo("Pass : The Value "+task+" is entered in the text Field and is navigateed to the required page ");
				return true; 
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 
	}

	public boolean navigateToMemberMaintenance() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			wait=new WebDriverWait(Driver.pgDriver,25);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Member Maintenance'][@class='Add_task']")));
			if(setTxtFullContactName("Member Maintenance"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value is Member Maintenance is entered in the text Field and is navigated to the required page");
					return true; 
				}
			}
		}

		System.out.println("Fail : There is some error with navigated value");
		return false; 

	}

	public boolean clickInteractionTab() {
		boolean flag;
		try{
			flag =  utils.clickAnelemnt(tabproviderCompositeInteraction, "ProviderComposite", "tabproviderCompositeInteraction");

		}
		catch(Exception e)
		{
			utils.waitforpageload();
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
			flag = utils.clickAnelemnt(tabproviderCompositeInteraction, "ProviderComposite", "tabproviderCompositeInteraction");
		}
		return flag;
	}

	@FindBy(xpath="//div[text()='Close']")
	WebElement CloseLink;

	public boolean ClickClose() {
		return utils.clickAnelemnt(CloseLink, "ProviderComposite", "CloseLink");
	}

	public boolean navigateToAccumulators() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			wait=new WebDriverWait(Driver.pgDriver,25);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Accumulators'][@class='Add_task']")));
			if(setTxtFullContactName("Accumulators"))
			{
				if(this.clicklnkClickonLinkafterSettingValue())
				{
					System.out.println("Pass : The Value is Accumulators is entered in the text Field and is navigated to the required page");
					return true; 
				}
			}
		}

		System.out.println("Fail : There is some error with navigated value");
		return false; 

	}

	@FindBy(id="SearchNewProviderSearch for new provider")
	WebElement rdoSearchNewProviderSearch;

	public boolean clickOnSearchForNewProviderPopUp() {
		return utils.clickAnelemnt(rdoSearchNewProviderSearch, "ProviderComposite", "rdoSearchNewProviderSearch");
	}

	@FindBy(id="CaseOrTaskIcon")
	WebElement radioButton;

	@FindBy(xpath = "//button[@title='Complete this assignment']")
	private WebElement btnSubmitButton;

	@FindBy(id = "ProviderSearchTypeNPI")
	private WebElement rBtnNPI;

	@FindBy(id = "SearchStringNPI")
	private WebElement txtbxsearchStringNPI;

	@FindBy(xpath = "//*[@name='$PpyWorkPage$pProvState']")
	private WebElement txtbxsearchState;

	@FindBy(xpath = "//*[@name='CPMHCFindProviderSearch_pyWorkPage_16']")
	private WebElement BtnsearchButton;

	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMemberRow;

	public boolean selectProviderDetailsInPopUp(String[] args) throws InterruptedException {
		boolean flag= false;
		if(utils.clickAnelemnt(rBtnNPI, "Phone Call", "Radio Button NPI"))
			if(utils.enterTextinAnelemnt(txtbxsearchStringNPI, args[0], "Phone Call", "Text Box NPI"))
				if(utils.enterTextinAnelemnt(txtbxsearchState, args[1], "Phone call", "text box state"))
					if(utils.clickAnelemnt(BtnsearchButton, "Phone Call", "Button Search"))
						if(utils.clickAnelemnt(radioButton, "SelectMember", "Radio button -	firstRowofselectMembertable")) {
							utils.scrolltomiddle();
							return utils.clickAnelemnt(this.btnSubmitInChangeFocus, "ProviderComposite", "Submit button");	
						}
		return false;
	}

	public boolean selectMemberDetailsInPopUp(String[] args) throws InterruptedException {
		boolean flag= false;
		if(searchbyMemberID(args))
			if(utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -	firstRowofselectMembertable"))
			{
				JavascriptExecutor executor = (JavascriptExecutor)pgDriver;
				executor.executeScript("arguments[0].click();", btnSubmitInChangeFocus);
				flag = true;
			}
		return flag;	

	}

	@FindBy(xpath= "//tr[@id='$PHCMemberPolicyList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstRow;

	@FindBy(xpath="//button[@data-test-id='20160304053605032428479']")
	WebElement SubmitBtnSelectContract;

	public boolean selectfirstContractInPopUp() {
		boolean flag= false;
		if(utils.clickAnelemnt(rdoFirstRow, "SelectContract", "Radio button -firstRowofselectContracttable"))
			if(utils.clickAnelemnt(SubmitBtnSelectContract, "ProviderComposite", "Submit button"))
				return true;
		if(flag) {
			blogger.loginfo("PASS: Select Contract Details completed");
			return true;
		}else {
			blogger.loginfo("FAIL: Select Contract Details not completed");
			return false;
		}		

	}

	@FindBy(xpath="//div[@id='DialogContent']")
	WebElement guidedDialgue;

	public boolean validateTheProviderCompositeGuidedDialogueForPhoneCallProvider()
	{
		String guidedDialogueProvider = guidedDialgue.getText();
		return utils.isvalueMatch_contain(guidedDialogueProvider.replaceAll("\n", " "), "Clarify the caller’s request and add the appropriate task.");
	}

	public boolean validateTheProviderCompositeGuidedDialogueForResearchProvider()
	{
		String guidedDialogueProvider = guidedDialgue.getText();
		System.out.println("guided dialogue" + guidedDialogueProvider);
		return utils.isvalueMatch_contain(guidedDialogueProvider, "Review Provider Information and Interactions, Change Provider and/or Member in Focus or Add Task as needed.");
	}

	@FindBy(xpath="//a[@class='Standard_task']")
	WebElement serviceReqDetails;

	public boolean getSRIDFromTaskWithoutData()
	{
		String SrID = serviceReqDetails.getText().trim();
		System.out.println("SR ID Value is: "+ SrID);
		SRIDAfterSubstring = SrID.substring(SrID.indexOf("(")+1,SrID.indexOf(")")).trim();
		System.out.println("Trimmed String: "+ SRIDAfterSubstring);
		return true;
	}

	@FindBy(xpath="//button[@data-test-id='20180311105349088018279']")
	WebElement btnCancel;

	public boolean manageIdCardTaskNotAvailableForProvider() {
		if (utils.clickAnelemnt(btnAddTAsk, "ProviderComposite", "btnAddTAsk")) {
			if(utils.isProxyWebelement(ManageIDCardOption))
				return utils.clickAnelemnt(btnCancel, "Add task", "cancel button");
		}
		return false;
	}

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Group']")
	WebElement tabMbrCompositeGroup;

	/*
	 * @SCU
	 * #CommonMethodWithoutArguement: clickGroup
	 * #Description: This functionality Click the Group tab in Member Composite page
	 * Type: Textbox
	 */
	public boolean clickGroupTab() {
		utils.waitforpageload();
		return utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite ", "Group tab");
	}

	public boolean clickMemberTab() throws InterruptedException {
		Thread.sleep(1000);
		utils.waitforpageload();
			return utils.clickAnelemnt(tabproviderCompositeMember, "Provider Composite", "tabproviderCompositeMember");
	}

	public boolean clickContractTab() {
		utils.waitforpageload();
			return utils.clickAnelemnt(tabproviderCompositeContract, "Provider Composite", "tabproviderCompositeContract");
	}

	@FindBy(xpath="//*[text()='Research Provider']")
	WebElement ResearchProvider;

	public boolean verifyResearchProviderTaskIsAvailableForProvider() {
		if(utils.clickAnelemnt(btnAddTAsk, "Provider Composite", "addtaskbutton"))
			return !utils.isProxyWebelement(ResearchProvider);
		return false;
	}

	@FindBy(xpath="//h3[text()='Provider']")
	WebElement providerTab;


	public boolean clickProviderTab()
	{
		return utils.clickAnelemnt(providerTab, "Provider composite", "Provider tab");
	}



	@FindBy(xpath="//span[@data-test-id='20160916102637026797140']")
	WebElement labelInteractionID;

	static String interactionID;

	/**
	 * THis functionality fetches the Interaction ID in the Interaction Section
	 * @return
	 */
	public boolean fetchInteractionIDForInteraction()
	{
		try
		{
			Driver.pgDriver.switchTo().defaultContent();
			interactionID = labelInteractionID.getText();
			System.out.println("Interaction ID: "+interactionID);
			return true;
		}catch(Exception e)
		{
			Driver.pgDriver.switchTo().defaultContent();
			interactionID = labelInteractionID.getText();
			System.out.println("Interaction ID: "+interactionID);
			return true;
		}

	}
	
	@FindBy(xpath="//a[@data-test-id='201412300524260732670'][text()='Create Correspondence']")
	WebElement btnCreateCorrespondance;
	/**This method navigates to the Create Correspondence page from the Provider Composite page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateToCreateCorrespondence() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Create Correspondence"))
				return this.clicklnkClickonLinkafterSettingValue("Create Correspondence");
		return false; 
		 

	}
	
	/**This method navigates to the Group Search page from the Provider Composite page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateToGroupSearch() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Group Search"))
				return this.clicklnkClickonLinkafterSettingValue("Group Search");
		return false; 

	}
	/**This method navigates to the External Search page from the Provider Composite page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	
	
	public boolean  navigateToExternalSearch() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("External Search"))
				return this.clicklnkClickonLinkafterSettingValue("External Search");
		return false; 

	}
	
	/**This method navigates to the Cash page from the Provider Composite page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	
	public boolean  navigateToCash() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Cash"))
				return this.clicklnkClickonLinkafterSettingValue("Cash");
		return false; 

	}
	
	public boolean  navigateToEngagePlantoPlan() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Engage Plan to Plan"))
				return this.clicklnkClickonLinkafterSettingValue("Engage Plan to Plan");
		return false; 
		 

	}
	
	public boolean  navigateToSearchInventory() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Search Inventory"))
				return this.clicklnkClickonLinkafterSettingValue("Search Inventory");
		return false; 
		 

	}
	
	@FindBy(xpath="//a[@data-test-id='2014123005242607302524' or @data-test-id='201412300524260732670']")
	//@FindBy(xpath="//a[@data-test-id='201412300524260732670']")
	List<WebElement> allOptions; 
	
	public boolean validateTasksForHostFlow(){
		
	    List<String> inp=Arrays.asList("Create Correspondence","Engage Plan to Plan","External Search","Cash","Research Provider","Manage Claims","Promised Action","Search Inventory"); 
		//String[] inputs={"Create Correspondence","Engage Plan to Plan","External Search","Cash","Research Provider","Manage Claims","Promised Action","Search Inventory"};
	       if(this.clickbtnAddTask()){ 
	     
	   
	    System.out.println(allOptions.size());
	    ArrayList<String> l1=new ArrayList<String>();
	    for(WebElement lis:allOptions){
	       String tempval=lis.getText();
	              tempval=tempval.trim();
	              l1.add(tempval);
	        }

	   // if(l1.contains(inputs)){
	    if(l1.removeAll(inp)){
	   
	        System.out.println("Passed");
	    }
	    
	    else
	       
	       return false;
	        }
	       return true;
	}
	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='HMO']")
	WebElement tabHMOCompositeGroup;

	public boolean clickHMOTab() {
		utils.waitforpageload();
		return utils.clickAnelemnt(this.tabHMOCompositeGroup, "Member Composite ", "HMO tab");
	}
	
	@FindBy(xpath="//div[text()='Transfer Interaction']")
	WebElement TrnsIntBtn;
	//Validates that the Transfer Interaction BTN Available at the Provider composite screen for phone call provider flow
	public boolean validateTransferInteractionBTNAvailable(){
		return !utils.isProxyWebelement(TrnsIntBtn);
	}
	
	//Validates that the Transfer Interaction BTN is not Available at the Provider Composite screen for Research provider flow
	public boolean validateTransferInteractionBTNNotAvailable(){
		return utils.isProxyWebelement(TrnsIntBtn);
	}
	
	
	public boolean clickOnTransferInteractionBTN()
	{
		return utils.clickAnelemnt(TrnsIntBtn, "ProviderComposite", "TrnsIntBtn");
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
		    action.moveToElement(USDomainIDTxtBox).sendKeys(Keys.ENTER);
		 if(utils.enterTextinAnelemnt(NotesTXBBox, args[1], "ProviderComposite", "NotesTXBBox")){
			 action.moveToElement(SubmitBTN);
		 return utils.clickAnelemnt(SubmitBTN, "ProviderComposite", "SubmitBTN");
		 }
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
	
	
}









