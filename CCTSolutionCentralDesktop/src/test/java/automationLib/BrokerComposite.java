package automationLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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

public class BrokerComposite extends Driver{


	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();

	WebDriverWait wait;

	public BrokerComposite()
	{
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			if(utils.isAlertPresent())
			{
				Driver.pgDriver.switchTo().alert().accept();
			}
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);

		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement); 
		}
	}

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForBroker;

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;



	@FindBy(xpath="//div[contains(text(),'Wrap Up')]")
	WebElement lnkWrapUp;

	@FindBy(xpath="//h3[contains(text(),'Member')]")
	WebElement tabMember;

	@FindBy(xpath="//div[contains(text(),'Change Member')]")
	WebElement btnChangeFocus;

	/**
	 * This functionality clicks the Wrap Up in the Broker composite screen
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickWrapUpInBrokerCompositeScreen() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement element = lnkWrapUp;
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", element);
		return true;
	}

	/**
	 * This functionality clicks the Change Focus Button in the Broker composite screen
	 * @return
	 */
	public boolean clickOnChangeFocusButtonInBrokerCompositeScreen()
	{
		return utils.clickAnelemnt(btnChangeFocus, "BrokerComposite", "Change Focus Button");
	}


	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMemberRow;

	@FindBy(xpath = "//*[@name='CPMHCFindProviderSearch_pyWorkPage_16']")
	private WebElement BtnsearchButton;

	@FindBy(xpath="//button[@id='submitButton']")
	WebElement btnSubmitInChangeFocus;

	@FindBy (id="SearchStringMemberID")	
	private WebElement txtbxMemberID;

	@FindBy(id="MemberSearchTypeMember ID")
	private WebElement rBtnMID;


	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Search']")	
	private WebElement btnSearchforMSearch;

	public WebElement gettxtbxMembeID() {
		return txtbxMemberID;
	}


	public WebElement getrBtnMID() {
		return rBtnMID;
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

	public WebElement getBtnSearchforMSearch() {
		return btnSearchforMSearch;
	}


	/**
	 * This functionality search the Member by Member ID in the Change Member Pop up
	 * @param sMemberID
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchbyMemberIDInPopUp(String[] sMemberID) throws InterruptedException
	{
		String value = sMemberID[0].substring(sMemberID[0].indexOf(":")+1);
		if(this.clickrbtnMemberID())
			if(this.setSuscriberID(value))
				if(this.clickMSearch()){
					Thread.sleep(2000);
					utils.waitforpageload();
					return true;
				}
		err.logError("Error in the HEader Page");
		return false;
	}


	/**
	 * This functionality selects the first member in the Search Results table in the Member screen
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectFirstMemberInPopUp(String[] args) throws InterruptedException {
		boolean flag= false;
		if(searchbyMemberIDInPopUp(args))
			if(utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -	firstRowofselectMembertable"))
			{
				JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
				executor.executeScript("arguments[0].click();", btnSubmitInChangeFocus);
				flag = true;
			}
		if(flag) {
			blogger.loginfo("PASS: Member Details completed");
			return true;
		}else {
			blogger.loginfo("FAIL: Member Details not completed");
			return false;
		}	

	}

	@FindBy(xpath= "//tr[@id='$PHCMemberPolicyList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstRow;

	@FindBy(xpath="//button[@data-test-id='20160304053605032428479']")
	WebElement SubmitBtnSelectContract;

	/**
	 * This functionality selects the first contract in the contract table
	 * @return
	 */

	public boolean selectfirstContractInPopUp() {
		boolean flag= false;
		if(utils.clickAnelemnt(rdoFirstRow, "MemberComposite", "Radio button -firstRowofselectContracttable"))
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

	@FindBy(xpath="//button[@data-test-id='201411140227290027156488']")
	WebElement btnCancelInPopUp;

	@FindBy(xpath="//div[@id='modaldialog_hd']")
	WebElement popUpChangeFocus;

	@FindBy(xpath="//span[@data-test-id='20180828231249081468848']")
	WebElement labelBrokerName;



	/**
	 * This functionality clicks the cancel button in the Change Member pop up
	 * @return
	 */
	public boolean clickCancelInPopUp()
	{
		return utils.clickAnelemnt(btnCancelInPopUp, "MemberComposite", "Cancel");
	}

	/**
	 * This functionality verifies that the Change Member pop up is not displayed after clicking cancel button
	 * @return
	 */
	public boolean verifyChangeFocusPopUpIsNotDisplayedOnClickingCancel()
	{
		return !utils.isProxyWebelement(popUpChangeFocus);
	}

	/**
	 * This functionality clicks the Member tab in the Broker Composite screen
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickMemberTab() throws InterruptedException
	{
		Thread.sleep(15000);
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", tabMember);
		return true;
	}

	/**
	 * This functionality verifies that the Broker Name is displayed on clicking Cancel in Pop up
	 * @return
	 */
	public boolean verifyBrokerNameIsDisplayedOnClickingCancelInPopUp()
	{
		return !utils.isProxyWebelement(labelBrokerName);
	}

	@FindBy(xpath="//button[@data-test-id='201809101051450876148905']")
	WebElement btnGroupChange;

	@FindBy(xpath="//h3[contains(text(),'Group')]")
	WebElement tabGroup;

	@FindBy(xpath="//button[@data-test-id='20180911100723016318231']")
	WebElement groupCancelButton;

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]//img[2]")	
	private WebElement btnAddTAsk;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;

	@FindBy(xpath="//*[contains(@id,'CPMTaskSearchInput')][1]")
	private WebElement SearchInput;

	@FindBy(id="po0")
	private WebElement addTaskMenu;


	@FindBy(xpath="//*[@data-test-id='20150527044600067319555' or contains(text(), 'Add task(s)')]")
	private WebElement lnkClickonAddTaskInDropdown;

	@FindBy(xpath="//button[@data-test-id=\"20180911100723016319175\"]")
	WebElement btnSubmitInGroupPopUp;

	@FindBy(xpath="//input[@data-test-id='20180703152859072027522']")
	WebElement txtBxGroupNumberInChangeGroupPopUp;


	@FindBy(xpath="//input[@data-test-id='20180703152859072228531']")
	WebElement txtBxGroupNameInChangeGroupPopUp;

	@FindBy(xpath="//button[@data-test-id='20180703152859072229535']")
	WebElement btnSearchInGroupPopUp;


	/**
	 * This functionality verifies that the Change Group button is displayed under Group Tab
	 * @return
	 */
	public boolean verifyChangeGroupButtonIsDisplayedOnClickingGroupTab()
	{
		return !utils.isProxyWebelement(btnGroupChange);	
	}

	/**
	 * This functionality clicks on the Change group button in the Broker Composite screen
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickOnChangeGroupButton() throws InterruptedException
	{
		Thread.sleep(10000);
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", btnGroupChange);
		return true;

	}

	/**
	 * This functionality clicks on the Group tab in the Broker Composite screen
	 * @return
	 */

	public boolean clickOnGroupTab()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(tabGroup, "Broker Composite", "Group Tab");

	}


	/**
	 * This functionality clicks on the Cancel button in the Change Group pop up in the Broker Composite screen
	 * @return
	 */

	public boolean clickCancelGroup()
	{
		return utils.clickAnelemnt(groupCancelButton, "BrokerComposite", "Cancel");
	}

	public WebElement getbtnAddTAsk()
	{
		return btnAddTAsk;
	}

	public boolean clickbtnAddTask()
	{
		utils.waitforpageload();
		try
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
			return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");
		}catch(Exception e)
		{
			Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement);
			return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");
		}

	}

	public WebElement getchkbxSEacrchInput()
	{
		return SearchInput;
	}



	public boolean setTxtFullContactName(String sFullName) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchInput.clear();
		return utils.enterTextinAnelemnt(this.getchkbxSEacrchInput(), sFullName, "Member Composite", "Application took a long time to load");

	}

	public boolean clicklnkClickonLinkafterSettingValue(String args) throws InterruptedException
	{
		boolean flag=false;
		try 
		{
			utils.waitforpageload();
			List<WebElement> allOptions = addTaskMenu.findElements(By.xpath("//a[@data-test-id='2014123005242607302524']"));
			for ( int i=0;i<=allOptions.size();i++) {
				if(allOptions.get(i).getText().contains(args)){
					allOptions.get(i).click();
					utils.waitforpageload();
					Actions action = new Actions(pgDriver);
					action.moveToElement(lnkClickonAddTaskInDropdown);
					new WebDriverWait(Driver.getPgDriver(),1).until(ExpectedConditions.visibilityOf(lnkClickonAddTaskInDropdown));
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

	/**
	 * This functionality navigates to the Promised Action from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOPromisedAction() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Promised Action"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Promised Action"))
				{
					utils.waitforpageload();
					blogger.loginfo("Pass : The Value 'Promised Action' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	}      


	/**
	 * This functionality navigates to the Manage Claims from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOManageClaims() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Manage Claims"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Manage Claims"))
				{
					utils.waitforpageload();
					blogger.loginfo("Pass : The Value 'Manage Claims' is entered in the text Field and is navigated to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	}      


	/**
	 * This functionality navigates to the Grievance and Appeal from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOGrievanceAndAppeals() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Grievance and Appeals"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Grievance and Appeals"))
				{
					utils.waitforpageload();
					blogger.loginfo("Pass : The Value 'Grievance and Appeal' is entered in the text Field and is navigated to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	}      


	/**
	 * This functionality navigates to the Consumer Driven Health Plan from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOConsumerDrivenHealthPlan() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Consumer Driven Health Plan"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Consumer Driven Health Plan"))
				{
					utils.waitforpageload();
					blogger.loginfo("Pass : The Value 'Consumer Driven Health Plan' is entered in the text Field and is navigated to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	}      



	/**
	 * This functionality navigates to the Manage ID Card from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOManageIDCard() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Manage ID Card"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Manage ID Card"))
				{
					blogger.loginfo("Pass : The Value 'Manage ID Card' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	}      


	/**
	 * This functionality navigates to the Member Maintenance from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOMemeberMaintenance() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Member Maintenance"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Member Maintenance"))
				{
					blogger.loginfo("Pass : The Value 'Member Maintenance' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	}      



	/**
	 * This functionality navigates to the Manage Authorization from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOManageAuthorization() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Manage Authorization"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Manage Authorization"))
				{
					utils.waitforpageload();
					Thread.sleep(3000);
					blogger.loginfo("Pass : The Value 'Manage Authorization' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	}      



	/**
	 * This functionality navigates to the Benefit And Cost from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOBenefitAndCost() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Benefits and Cost"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Benefits and Cost"))
				{
					blogger.loginfo("Pass : The Value 'Benefits And Cost' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	} 


	/**
	 * This functionality navigates to the Accumulators from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOAccumulators() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Accumulators"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Accumulators"))
				{
					blogger.loginfo("Pass : The Value 'Accumulators' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	} 

	/**
	 * This functionality clicks the Cancel button in the Broker Group Pop up
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickCancelButtonInBrokerGroupPopUp() throws InterruptedException
	{
		Thread.sleep(5000);
		return utils.clickAnelemnt(groupCancelButton, "BrokerComposite", "Cancel");
	}


	/**
	 * This functionality clicks the Submit button in the Change Group pop up dialog
	 * @return
	 */
	public boolean clickSubmitButtonInChangeGroupPopUp()
	{
		return utils.clickAnelemnt(btnSubmitInGroupPopUp, "BrokerComposite", "Cancel");
	}

	/**
	 * This functionality enters the Group name in the Change Group pop up dialog
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean enterGroupNameInChangeGroupPopUp(String[] args) throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement element = Driver.pgDriver.findElement(By.xpath("//input[@data-test-id='20180703152859072228531']"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		if(utils.enterTextinAnelemnt(txtBxGroupNameInChangeGroupPopUp, args[0], "BrokerComposite", "Group Name"))
		{
			if(utils.clickAnelemnt(btnSearchInGroupPopUp, "BrokerComposite", "Group Name"))
			{
				blogger.loginfo("Group Name is entered and searched");
				return true;
			}
		}
		return false;
	}

	/**
	 * This functionality enters the Group number in the Change Group pop up dialog
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean enterGroupNumberInChangeGroupPopUp(String[] args) throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement element = Driver.pgDriver.findElement(By.xpath("//input[@data-test-id='20180703152859072027522']"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		if(utils.enterTextinAnelemnt(txtBxGroupNumberInChangeGroupPopUp, args[0], "BrokerComposite", "Group Number"))
		{
			if(utils.clickAnelemnt(btnSearchInGroupPopUp, "BrokerComposite", "Group Number"))
			{
				blogger.loginfo("Group Number is entered and searched");
				return true;
			}
		}
		return false;
	}


	@FindBy(xpath="//h3[text()='Member Contract']")
	WebElement tabMemberContract;

	@FindBy(xpath="//h3[text()='Verification History']")
	WebElement tabVerificationHistory;

	@FindBy(xpath="//span[text()='Verified Providers']")
	WebElement lnkVerifiedProviders;

	@FindBy(xpath="//span[text()='Verified Members']")
	WebElement lnkVerifiedMembers;


	/**
	 * Verifies that the Billing Information tab is changed to Member Contract in Broker Composite page
	 * @return
	 */

	public boolean verifyBillingInformationTabIsChangedToMemberContract()
	{
		return !utils.isProxyWebelement(tabMemberContract);
	}

	/**
	 * Verifies that only 'Verified Provider' is not displayed under the Verification History tab
	 * @return
	 */

	public boolean verifyVerifiedProvidersIsNotDisplayedOnVerificationHistoryTab()
	{
		if(utils.clickAnelemnt(tabVerificationHistory, "BrokerComposite", "Verification History"))
			if(utils.isProxyWebelement(lnkVerifiedProviders) && !utils.isProxyWebelement(lnkVerifiedMembers) )
				return true;
		return false;
	}

	@FindBy(xpath="//div[contains(text(),'Close')]")
	WebElement lnkClose;

	public boolean clickOnCloseButton()
	{
		return utils.clickAnelemnt(lnkClose, "BrokerComposite", "Close");
	}

	public boolean acceptAlert()
	{
		utils.waitforpageload();
		Driver.pgDriver.switchTo().alert().accept();
		return true;
	}

	@FindBy(xpath="\\span[contains(text(),'** You have un-submitted service requests.')]")
	WebElement txtErrorMsg;

	public boolean validateErrorMessageForUnsubmittedRequests()
	{
		return utils.validateLabel(txtErrorMsg, "** You have un-submitted service requests.");
	}

	@FindBy(xpath="//h3[text()='Contract']")
	WebElement labelContract;

	/**
	 * Verifies that member contract tab is changed to contract
	 * @return
	 */

	public boolean verifyMemberContractTabIsChangedToContract()
	{
		if(utils.clickAnelemnt(labelContract, "BrokerComposite", "ContractTab"))
			if(!utils.isProxyWebelement(labelContract))
				return true;
		return false;
	}

	@FindBy(xpath="//*[text()='Interactions']")
	WebElement InteractionTab;

	/**This functionality clicks the interaction tab in broker composite screen
	 * 
	 * @return
	 */
	public boolean clickInteractionsTab() {
		return utils.clickAnelemnt(InteractionTab, "BrokerComposite", "InteractionTab");
	}

	/**This functionality navigates to Group Billing page by clicking Group billing under Add task option and by clicking Add Task option
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOGroupBilling() throws InterruptedException
	{
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			return clicklnkClickonLinkafterSettingValue("Group Billing");
		}
		return false; 
	}
	
	@FindBy(xpath="(//a[@title='Group Billing'])[1]")
	WebElement lnkGroupBillingTask;
	
	
	/**
	 * Verfies that the Bill Entity Drop down is enabled in the Group Billing task
	 * @return
	 * @throws InterruptedException 
	 */
	
	public boolean verifyGroupBillingTaskIsEnabled() throws InterruptedException
	{
		Thread.sleep(3000);
		if((this.clickbtnAddTask()))
			return !utils.isProxyWebelement(lnkGroupBillingTask);
		return false;
	}
	
	/**
	 * Verfies that the Bill Entity Drop down is disabled in the Group Billing task
	 * @return
	 */
	
	public boolean verifyGroupBillingTaskIsDisabled()
	{
		if((this.clickbtnAddTask()))
			return utils.isProxyWebelement(lnkGroupBillingTask);
		return false;
	}
	
	
	@FindBy(xpath="(//div[@data-test-id='2018062712272700362867'])[2]")
	WebElement labelMemberNotInFocusMsg;
	
	public boolean verifyErrorMessageIsDisplayedWhenMemberNotInFocus()
	{
		utils.waitforpageload();
		return utils.validateLabel(labelMemberNotInFocusMsg, "Member not in focus. Use Change Member to search and bring a Member in focus. ");
	}
	
	/**
	 * This functionality navigates to the Member Maintenance from the Broker Composite
	 * @return
	 * @throws InterruptedException
	 */
	public boolean  navigateTOManageOtherInsurance() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			utils.waitforpageload();
			if(setTxtFullContactName("Manage Other Insurance"))
			{
				utils.waitforpageload();
				if(this.clicklnkClickonLinkafterSettingValue("Manage Other Insurance"))
				{
					blogger.loginfo("Pass : The Value 'Manage Other Insurance' is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
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
