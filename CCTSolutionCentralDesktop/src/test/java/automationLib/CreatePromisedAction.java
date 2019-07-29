package automationLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ErrorLogger;
import utils.SeleniumUtilities;
/**
 * Create Promised Action selected from Add Skill dropdonw in the left hand pane of the page 
 * @param: here the frame change is there which is impersonated from the earlier one to one more 
 * 
 * @author Shardul Negi
 *
 */
public class CreatePromisedAction {

	/**
	 * Methods in the Program 
	 */

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	private WebElement sHeaderCreatePromisedAction;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public CreatePromisedAction()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;

	@FindBy (xpath="//img[contains(@src,'tool_icon_')]")	
	private WebElement btnImgTool;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;

	@FindBy(id="PACActivityTypeContact")
	private WebElement rdBtnTypeContact;
	@FindBy(id="PACActivityTypeTask")
	private WebElement rdBtnTypeTask;

	@FindBy(id="StartDate")
	private WebElement txtBoxStartDate;
	@FindBy(xpath="//input[@id='StartTime']")
	private WebElement txtBoxStartTime;
	@FindBy(xpath="//*[@id='$PpyWorkPage$pStartTimeSpan']/img")
	WebElement startTimeCalendar;
	
	@FindBy(id="EndTime")
	private WebElement txtBoxEndTime;
	@FindBy(xpath="//*[contains(@id,'EndTimeSpan')]/img")
	WebElement endTimeCalendar;

	@FindBy(xpath="//*[@id='applyLink']")
	WebElement linktimeApply;

	@FindBy(id="Notes")
	private WebElement txtBoxNotes;

	@FindBy(xpath="//input[@id='CallBackNumber']")
	private WebElement txtBoxPhoneResearch;

	@FindBy(id="PACScheduledForMyself")
	private WebElement rdBtnSchedulefrMysellf;
	@FindBy(id="PACScheduledForMy Team")
	private WebElement rdBtnSchedulefrMyTeam;

	@FindBy(id="TimeZone")
	private WebElement drpDownTimezone;

	@FindBy(xpath="//Select[@id='TimeZone']//option[@selected='']")
	private WebElement drpDownTimezoneSelected;
	
	@FindBy(id="CommunicationChannel")
	private WebElement drpDownCommunucationChannel;
	@FindBy(xpath="//Select[@id='CommunicationChannel']//option[@selected='']")
	private WebElement drpDownCommunucationChannelSelected;

	@FindBy(id="Topic")
	private WebElement contactdrpDownTopic;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Submit']")	
	private WebElement btnSubmit;

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Save')]")	
	private WebElement btnSave;

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Save')]")	
	private WebElement btnAddTAsk;
	@FindBy(xpath="//input[@id='Email']")
	private WebElement txtfieldCommnTypeEmail;

	@FindBy (xpath="//span[text()='Value cannot be blank']//parent::div")	
	private WebElement errorvaluecannotbeblankDiv;

	public WebElement gettxtfieldCommnTypeEmail() {
		return txtfieldCommnTypeEmail;
	}

	public SeleniumUtilities getUtils() {
		return utils;
	}

	public WebElement getsHeaderCreatePromisedAction() {
		return sHeaderCreatePromisedAction;
	}

	public WebElement getIframeelement() {
		return Iframeelement;
	}

	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}

	public WebElement getLnkOtherCancelThisWork() {
		return lnkOtherCancelThisWork;
	}

	public WebElement getBtnImgTool() {
		return btnImgTool;
	}

	public WebElement getLnkToolViewHistory() {
		return lnkToolViewHistory;
	}

	public WebElement getLnkToolConfigurationTools() {
		return lnkToolConfigurationTools;
	}

	public WebElement getBtnHelp() {
		return btnHelp;
	}

	public WebElement getRdBtnTypeContact() {
		return rdBtnTypeContact;
	}

	public WebElement getRdBtnTypeTask() {
		return rdBtnTypeTask;
	}

	public WebElement getTxtBoxStartDate() {
		return txtBoxStartDate;
	}

	public WebElement getTxtBoxStartTime() {
		return txtBoxStartTime;
	}

	public WebElement getTxtBoxEndTime() {
		return txtBoxEndTime;
	}

	public WebElement getTxtBoxNotes() {
		return txtBoxNotes;
	}

	public WebElement getRdBtnSchedulefrMysellf() {
		return rdBtnSchedulefrMysellf;
	}

	public WebElement getRdBtnSchedulefrMyTeam() {
		return rdBtnSchedulefrMyTeam;
	}

	public WebElement getDrpDownCommunucationChannel() {
		return drpDownCommunucationChannel;
	}

	public WebElement getcontactDrpDownTopic() {
		return contactdrpDownTopic;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getDrpDownTimeDown() {
		return drpDownTimezone;
	}

	public boolean setTxtStartDate(String sFullName) throws InterruptedException
	{
		Thread.sleep(3000);
		return utils.enterTextinAnelemnt(this.getTxtBoxStartDate(), sFullName, "Create Promised Action ", "Text Box Full  Name");

	}

	public boolean setTxtStartTime(String sFullName) throws InterruptedException
	{
		try
		{
			System.out.println("settxtstarttime");
			if(utils.clickAnelemnt(this.startTimeCalendar, "Promised Action", "Start Calendar"))
			return utils.clickAnelemnt(this.linktimeApply, "Promised action", "Start Apply Link");
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("starttimecatchblock");
			if (utils.isValueCannotbeBlankErrorPresent(this.errorvaluecannotbeblankDiv, "StartTimeError"))
				return setTxtStartTime(sFullName);
		}
		catch(Exception e)
		{
			System.out.println("starttimeNO ELEMENTcatchblock");
			return setTxtStartTime(sFullName);
		}
		return false;

	}
	
	public boolean setTxtEndTime(String sFullName) throws InterruptedException
	{
		try
		{
			if(utils.clickAnelemnt(this.endTimeCalendar, "Promised Action", "End Calendar"))
			return utils.clickAnelemnt(this.linktimeApply, "Promised action", "end Apply Link");
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("endtimecatchblock");
			if (utils.isValueCannotbeBlankErrorPresent(this.errorvaluecannotbeblankDiv, "StartTimeError"))
				return setTxtEndTime(sFullName);	
		}
		catch(Exception e)
		{
			System.out.println("starttimeNO ELEMENTcatchblock");
			return setTxtStartTime(sFullName);
		}
		return false;
	}

	public boolean setgettxtfieldCommnTypeEmail(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.gettxtfieldCommnTypeEmail(), sFullName, "Create Promised Action ", "Text Box Full  Name");
	}
	
	public boolean setTxtNotes(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBoxNotes(), sFullName, "Create Promised Action ", "Text Box Full  Name");
	}
	
	public boolean setTxtPhoneResearch(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.txtBoxPhoneResearch, sFullName, "Create Promised Action ", "Text Box Full  Name");
	}

	/**
	 * Select the option from the drop down 
	 * @param 
	 * sReason : Selecting reason for selecting to a drop down 
	 * @return
	 */
	public boolean selectcontactTopicDropDown(String sReason)
	{
		return utils.selectDropDownbyVisibleString(contactdrpDownTopic, sReason, "CreatePromisedAction", "contactdrpDownTopic");
	}

	public boolean selectDropDownInsuranceCarriersContactRoleTab(int iDropdownSelect) throws InterruptedException, AWTException
	{
		Thread.sleep(2000);
		Driver.pgDriver.findElement(By.xpath("//input[@id='EndTime']")).click();
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("Pass : Drop down Selected the value ");
		return true;

	}
	public boolean selectDropDownCommnChanneltRoleTab(int iDropdownSelect) throws InterruptedException, AWTException
	{
		Thread.sleep(2000);
		Driver.pgDriver.findElement(By.xpath("//input[@id='EndTime']")).click();
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		utils.pressDownnTimes(iDropdownSelect);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("Pass : Drop down Selected the value ");
		return true;
	}
	
	/*
	 * Method returns true if selection is successful, checking for the presence of selected tag to make sure selection is successfull
	 */
	public boolean selectDropDownCommunicationChannel(String svisibleString) throws InterruptedException, AWTException
	{
		if(utils.selectDropDownbyVisibleString(this.drpDownCommunucationChannel, svisibleString, "Create Promised action", "Communication Channel"))
		return (!utils.isProxyWebelement(this.drpDownCommunucationChannelSelected));
		return false;
	}

	@FindBy(xpath="//input[@id='FaxNumber']")
	private WebElement txtbxCommnTypeFax;

	@FindBy(tagName="Promised Action")
	private WebElement promisedAction;

	public WebElement gettxtbxCommnTypeFax() {
		return txtbxCommnTypeFax;
	}

	public boolean settxtbxCommnTypeFax(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.gettxtbxCommnTypeFax(), sFullName, "Create Promised Action ", "Text Box Full  Name");

	}
	
	/*
	 * method returns true if no alert is present, that means the submit is not success full
	 */
	public boolean clickgetBtnSubmit()
	{
		if(utils.clickAnelemnt(this.getBtnSubmit(), "Create Promised Action ", "Radio Buttoon  Verify Associate"))
		return (!utils.isAlertPresent());
		return false;
	}


	/**
	 * Here the details are entered in the sequence, but owing to stale error have put try and catch to click on the element twice. 
	 * @throws InterruptedException 
	 * @throws AWTException 
	 * 
	 */

	public boolean  createPromisedActionContactcommntypePhone(String[] args) throws InterruptedException, AWTException
	{
		if(this.setTxtStartDate(args[0]))
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("scroll(0, 100);");
			if(this.setTxtStartTime("5:47:00 PM"))
				if(this.setTxtEndTime("5:59:00 PM"))
					if(this.selectDropDownTimeZone("Eastern"))
						if(this.selectDropDownCommunicationChannel("Phone"))
							if(this.selectcontactTopicDropDown("Eligibility"))
								if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
									return this.clickgetBtnSubmit();
		}
		return false;

	}
	
	public boolean  createPromisedActionContactcommntypePhoneResearch(String[] args) throws InterruptedException, AWTException
	{

		System.out.println("Start : Promised Action Communication Phone Research");
		if(utils.validateHeader(this.sHeaderCreatePromisedAction, "Create Promised Action"))	
		if(this.setTxtStartDate(args[0]))
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("scroll(0, 100);");
			if(this.setTxtStartTime("5:47:00 PM"))
				if(this.setTxtEndTime("5:59:00 PM"))
					if(this.selectDropDownTimeZone("Eastern"))
						if(this.selectDropDownCommunicationChannel("Phone"))
							if(this.selectcontactTopicDropDown("Eligibility"))
								if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
									if(this.setTxtPhoneResearch("8884526266"))
										return this.clickgetBtnSubmit();
		}
		return false;
	}


	public boolean  createPromisedActionContactEmailscheduleTeam(String[] args) throws InterruptedException, AWTException
	{

		if(this.setTxtStartDate(args[0]))
			if(this.setTxtStartTime(""))
				if(this.setTxtEndTime(""))
					if(this.selectDropDownTimeZone("Central"))
						if(this.selectDropDownCommunicationChannel("Email"))
							if(this.setgettxtfieldCommnTypeEmail("test@test.com"))
								if(this.selectcontactTopicDropDown("Eligibility"))
									if(this.setTxtNotes("test"))
										return this.clickgetBtnSubmit();
		return false;

	}

	/**
	 * The address and all the methods are prepopulated here 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public boolean  createPromisedActionContactcommntypeMail(String[] args) throws InterruptedException, AWTException
	{
		if(this.setTxtStartDate(args[0]))
			if(this.setTxtStartTime(""))
				if(this.setTxtEndTime(""))
						if(this.selectDropDownInsuranceCarriersContactRoleTab(1))
							if(this.selectDropDownCommunicationChannel(""))
								if(this.selectcontactTopicDropDown("Eligibility"))
									if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
										return this.clickgetBtnSubmit();
		return false;
	}



	public boolean  createPromisedActionContactFaxscheduleTeam(String[] args) throws InterruptedException, AWTException
	{
		if(this.setTxtStartDate(args[0]))
			if(this.setTxtStartTime(""))
				if(this.setTxtEndTime(""))
					if(this.selectDropDownTimeZone("Eastern"))
						if(this.selectDropDownCommunicationChannel("Fax"))
							if(this.settxtbxCommnTypeFax("1234567890"))
								if(this.selectcontactTopicDropDown("Eligibility"))
									if(this.setTxtNotes("Test"))
										return this.clickgetBtnSubmit();
		return false;
	}


	@FindBy(xpath="//input[@id='PACActivityTypeTask']")
	private WebElement rdbtnTypeTask;

	@FindBy(xpath="//input[@id='DueDate']")
	private WebElement txtbxDueDate;

	@FindBy(xpath="//input[@id='DueTime']")
	private WebElement txtbxDueTime;
	@FindBy(xpath="//input[@id='OtherTopic']")
	private WebElement txtbxOtherTopic;

	public WebElement getrdbtnTypeTask() {
		return rdbtnTypeTask;
	}

	public boolean clickrdbtnTypeTask()
	{
		return utils.clickAnelemnt(this.getrdbtnTypeTask(), "Select Associate Contact", "Radio Buttoon  Verify Associate");
	}
	
	public WebElement gettxtbxDueDate() {
		return txtbxDueDate;
	}

	public WebElement gettxtbxOtherTopic() {
		return txtbxOtherTopic;
	}
	
	public WebElement gettxtbxDueTime() {
		return txtbxDueTime;
	}
	
	public boolean settxtbxOtherTopic(String sFullName) throws InterruptedException
	{
		return utils.enterTextinAnelemnt(this.gettxtbxOtherTopic(), sFullName, "Create Promised Action ", "Text Box Full  Name");	
	}

	public boolean settxtbxDueTime(String sFullName) throws InterruptedException
	{
			return utils.enterTextinAnelemnt(this.gettxtbxDueTime(), sFullName, "Create Promised Action ", "Text Box Full  Name");	
	}


	public boolean settxtbxDueDate(String sFullName) throws InterruptedException
	{
			return utils.enterTextinAnelemnt(this.gettxtbxDueDate(), sFullName, "Create Promised Action ", "Text Box Full  Name");
	}
	
	/*method returns true if selection was successful
	 * to make sure selection is successful we are checking for the presence of the selected element
	 * 
	 * 
	 * */
	public boolean selectDropDownTimeZone(String visibletext) 
	{
		return utils.selectDropDownbyVisibleString(this.drpDownTimezone, visibletext, "Promised action", "Timezone");
	}

	public boolean  createPromisedActionTaskcTopicResearch(String[] args) throws InterruptedException, AWTException
	{

		if(this.clickrdbtnTypeTask())
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("scroll(0, 100);");
			if(this.settxtbxDueDate(args[0]))
				if(this.settxtbxDueTime("5:59:00 PM"))
					if(!this.selectDropDownTimeZone(""))
							if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
								return this.clickgetBtnSubmit();
		}
		return false;

	}


	public boolean  createPromisedActionTaskcTopicOutreach(String[] args ) throws InterruptedException, AWTException
	{
		if(this.clickrdbtnTypeTask())
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("scroll(0, 100);");
			if(this.settxtbxDueDate(args[0]))
				if(this.settxtbxDueTime("5:59:00 PM"))
					if(!this.selectDropDownTimeZone("Central"))
							if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
								return this.clickgetBtnSubmit();
		}
		return false;
	}



	public boolean  createPromisedActionTaskcTopicInternalContact(String[] args) throws InterruptedException, AWTException
	{
		if(this.clickrdbtnTypeTask())
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("scroll(0, 100);");

			if(this.settxtbxDueDate(args[0]))
				if(this.settxtbxDueTime("5:59:00 PM"))
					if(!this.selectDropDownTimeZone(""))
							if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
								return this.clickgetBtnSubmit();
		}
		return false;

	}



	public boolean  createPromisedActionTaskcTopicOther(String[] args) throws InterruptedException, AWTException
	{

		if(this.clickrdbtnTypeTask())
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("scroll(0, 100);");
			if(this.settxtbxDueDate(args[0]))
				if(this.setTxtStartTime(""))
					if(this.setTxtEndTime(""))
					if(!this.selectDropDownTimeZone(""))
							if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
								if(this.settxtbxOtherTopic("Anthem Employee"))
									return this.clickgetBtnSubmit();
		}
		return false;

	}

}
