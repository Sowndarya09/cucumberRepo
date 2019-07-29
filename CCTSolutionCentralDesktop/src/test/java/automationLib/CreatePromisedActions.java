package automationLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationLib.Driver;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;
/**
 * Create Promised Action selected from Add Skill dropdonw in the left hand pane of the page 
 * @param: here the frame change is there which is impersonated from the earlier one to one more 
 * 
 * @author Shardul Negi
 *
 */
public class CreatePromisedActions {

	/**
	 * Methods in the Program 
	 */

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCreatePromisedAction;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public CreatePromisedActions()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
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

	@FindBy(id="VoicemailYes")
	WebElement radBtnVoicemailYes;

	@FindBy(id="PACActivityTypeContact")
	private WebElement rdBtnTypeContact;
	@FindBy(id="PACActivityTypeTask")
	private WebElement rdBtnTypeTask;


	@FindBy(id="StartDate")
	private WebElement txtBoxStartDate;
	@FindBy(xpath="//input[@id='StartTime']")
	private WebElement txtBoxStartTime;
	@FindBy(id="StartTime")
	WebElement startTimeCalendar;
	@FindBy(id="EndTime")
	private WebElement txtBoxEndTime;
	@FindBy(id="EndTime")
	WebElement endTimeCalendar;

	@FindBy(xpath="//*[@id='applyLink']")
	WebElement linktimeApply;

	@FindBy(id="Notes")
	private WebElement txtBoxNotes;
	@FindBy(id="PACScheduledForMyself")
	private WebElement rdBtnSchedulefrMysellf;
	@FindBy(id="PACScheduledForMy Team")
	private WebElement rdBtnSchedulefrMyTeam;

	@FindBy(id="TimeZone")
	private WebElement drpDownTimezone;

	@FindBy(id="TaskTopic")
	private WebElement drpDownTopic;
	@FindBy(xpath="//Select[@id='TaskTopic']//option[@selected='']")
	private WebElement drpDownTaskTopicSelected;
	@FindBy(xpath="//Select[@id='TimeZone']//option[@selected='']")
	private WebElement drpDownTimezoneSelected;

	@FindBy(xpath="//select[@id='CommunicationChannel']")
	private WebElement drpDownCommunucationChannel;
	@FindBy(xpath="//*[@class='content-item content-layout item-2   ']//*[@id='CommunicationChannel']")
	private WebElement drpDownCommunucationChannel1;
	@FindBy(xpath="//Select[@id='CommunicationChannel']//option[@selected='']")
	private WebElement drpDownCommunucationChannelSelected;
	@FindBy(xpath="//Select[@id='Topic']//option[@selected='']")
	private WebElement drpDownCommunucationTopicSelected;;
	@FindBy(name="$PpyWorkPage$pTopic")
	private WebElement contactdrpDownTopic;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Submit']")	
	private WebElement btnSubmit;

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Save')]")	
	private WebElement btnSave;

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Save')]")	
	private WebElement btnAddTAsk;
	@FindBy(xpath="//input[@id='Email']")
	private WebElement txtfieldCommnTypeEmail;

	@FindBy (xpath="//div[@class='radioTable']//input[@id='VoicemailYes']")
	WebElement radiobtnvoicemailYes;

	@FindBy (xpath="//div[@class='radioTable']//input[@id='VoicemailNo']")
	WebElement radiobtnvoicemailno;

	@FindBy (xpath="//span[text()='Value cannot be blank']//parent::div")	
	private WebElement errorvaluecannotbeblankDiv;

	@FindBy (xpath="//input[@data-test-id='201509261137240070368839'][@id='MemberName']")
	WebElement addresse;

	@FindBy (xpath="//input[@data-test-id='201509251318480401375374'][@name='$PpyWorkPage$pAddressLine1']")
	WebElement addressLine1;

	@FindBy (xpath="//input[@data-test-id='201509251318480406377291'][@name='$PpyWorkPage$ppyCity']")
	WebElement city;

	@FindBy (xpath="//input[@data-test-id='201509251318480406379191'][@name='$PpyWorkPage$pZipCode']")
	WebElement zipCode;

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

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate localDate = LocalDate.now().plusDays(1); 
	String Tdate=dtf.format(localDate );

	public boolean setTxtStartDate(String sFullName)
	{
		String sFullNamenew=sFullName.replaceAll("/","");
		return utils.enterTextinAnelemnt(this.getTxtBoxStartDate(), sFullNamenew, "Create Promised Action ", "Text Box Full  Name");
	}


	/*
	 * this method is written in a way it will always return true, after we enter the value for the first time it will check to see 
	 * if the cvalue cannot be blank is present . if present it will call by itself
	 */

	public boolean setTxtStartTime(String sFullName) throws InterruptedException
	{
		Date dNow = new Date( );
		SimpleDateFormat ft = 
				new SimpleDateFormat (" hh:mm:ss a");
		return utils.setAttribute(this.startTimeCalendar,"value",ft.format(dNow));
	}

	public boolean clickRadiobtnVoicemailno()
	{
		return utils.clickAnelemnt(this.radiobtnvoicemailno , "Create promice action", "Radio button");
	}

	public boolean setTxtEndTime(String sFullName) throws InterruptedException
	{
		Date dNow = new Date( );
		SimpleDateFormat ft = 
				new SimpleDateFormat (" hh:mm:ss a");
		return utils.setAttribute(this.endTimeCalendar,"value",ft.format(dNow));
	}

	public boolean settxtbxDueTime(String sFullName) throws InterruptedException
	{
		utils.waitForElementToBeVisible(gettxtbxDueTime());
		return utils.enterTextinAnelemnt(this.gettxtbxDueTime(), sFullName, "Create Promised Action ", "Text Box Full  Name");
	}

	public boolean clickRadiobtnVoicemail()
	{
		return utils.clickAnelemnt(this.radiobtnvoicemailYes , "Create promice action", "Radio button");
	}

	public boolean setgettxtfieldCommnTypeEmail(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.gettxtfieldCommnTypeEmail(), sFullName, "Create Promised Action ", "Text Box Full  Name");

	}


	@FindBy(xpath="//span[text()='Eligibility']")
	private WebElement Topics; 

	public boolean selectTopics()
	{
		return utils.clickAnelemnt(Topics, "Create Promised Action ", "ClickService Request");
	}

	public boolean setTxtNotes(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBoxNotes(), sFullName, "Create Promised Action ", "Text Box Full  Name");

	}

	/**
	 * Select the option from the drop down 
	 * @param 
	 * sReason : Selecting reason for selecting to a drop down 
	 * @return
	 */

	public boolean selectcontactTopicDropDown(String sReason)
	{
		try{
			return utils.selectDropDownbyVisibleString(this.contactdrpDownTopic, sReason, "Create Promised action", "Communication Channel");
		}
		catch(StaleElementReferenceException e){
			return this.selectcontactTopicDropDown(sReason);
		}
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

	/*
	 * Method returns true if selection is successful, checking for the presence of selected tag to make sure selection is successfull
	 */
	public boolean selectDropDownCommunicationChannel(String svisibleString) throws InterruptedException, AWTException
	{
		//Thread.sleep(5000);
		try {
			if(utils.selectDropDownbyVisibleString(this.drpDownCommunucationChannel, svisibleString, "Create Promised action", "Communication Channel"))
				return (!utils.isProxyWebelement(this.drpDownCommunucationChannelSelected));
			return false;
		}catch(ElementNotVisibleException e1) {
			if(utils.selectDropDownbyVisibleString(drpDownCommunucationChannel1, svisibleString, "Create Promised action", "Communication Channel"))
			return (!utils.isProxyWebelement(this.drpDownCommunucationChannelSelected));
			return false;
		}
		/*		try
		{
			utils.selectDropDownbyVisibleString(this.drpDownCommunucationChannel, svisibleString, "Create Promised action", "Communication Channel");
		}
		catch(StaleElementReferenceException e)
		{
			selectDropDownCommunicationChannel(svisibleString);
		}catch(ElementNotVisibleException e1) {
			utils.selectDropDownbyVisibleString(drpDownCommunucationChannel1, svisibleString, "Create Promised action", "Communication Channel");
		}
		return (!utils.isProxyWebelement(this.drpDownCommunucationChannelSelected));*/
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

	public boolean clickgetBtnSubmit()
	{
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", btnSubmit);
		if(utils.clickAnelemnt(this.getBtnSubmit(), "Create Promised Action ", "Radio Buttoon  Verify Associate"))
			return (!utils.isAlertPresent());
		return false;
	}

	public boolean clickgetBtnRdBtnSchedulefrMysellf()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.getRdBtnSchedulefrMysellf(), "Create Promised Action ", "Radio Buttoon  Verify Associate");
	}

	/**
	 * Here the details are entered in the sequence, but owing to stale error have put try and catch to click on the element twice. 
	 * @throws InterruptedException 
	 * @throws AWTException 
	 * 
	 */

	public boolean  createPromisedActionContactPhoneScheduleTeam(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.setTxtStartDate(args[0]))
				if(this.setTxtStartTime("11:49:00 AM"))
					if(this.setTxtEndTime("12:37:00 AM"))
						if(this.selectDropDownTimeZone("Central", args[0]))
							if(this.selectDropDownCommunicationChannel("Phone"))
								if(this.selectcontactTopicDropDown("Eligibility"))
									if(this.setTxtNotes("test"))
										return this.clickgetBtnSubmit();
		return false;
	}


	@FindBy(xpath="//input[@id='CallBackNumber']")
	private WebElement txtBoxPhoneResearch;

	public boolean setTxtPhoneResearch(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.txtBoxPhoneResearch, sFullName, "Create Promised Action ", "Text Box Full  Name");
	}



	public boolean  createPromisedActionContactPhoneScheduleMyself(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.setTxtStartDate(args[0]))
				if(this.setTxtStartTime(""))
					if(this.setTxtEndTime(""))
						if(this.selectDropDownTimeZone("Central", args[0]))
							if(this.selectDropDownCommunicationChannel("Phone"))
								if(this.clickRadiobtnVoicemailno())
									if(this.clickServiceRequestTypeEligibility())
										if(this.setTxtNotes("test"))
											if(this.clickgetBtnRdBtnSchedulefrMysellf())
												return this.clickgetBtnSubmit();
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactEmailscheduleTeam
	 * #Arguments:StartDate
	 * Type:TextBox
	 */
	@FindBy(xpath="//input[@id='PACScheduledForMy Team']")
	WebElement clickRdoBtnMyTeam;

	public boolean clickRdoBtnMyTeam()
	{
		return utils.clickAnelemnt(clickRdoBtnMyTeam, "Created Promised actions", "clickRdoBtnMyTeam");

	}

	public boolean  createPromisedActionContactEmailscheduleTeam(String[] args) throws InterruptedException, AWTException
	{
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		Date date=new Date();
		String todaydate=df.format(date);
		Date newDate=DateUtils.addMonths(date, 1);
		String dateafteronemonth=df.format(newDate);
		
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.setTxtStartDate(args[0]))
				if(this.setTxtStartTime(""))
					if(this.setTxtEndTime(""))
						if(this.selectDropDownTimeZone("Central", todaydate))
							if(this.selectDropDownCommunicationChannel("Email"))
								if(this.setgettxtfieldCommnTypeEmail("test@test.com"))
									if(this.setTxtNotes("test"))
										if(this.selectTopics())
											if(this.clickRdoBtnMyTeam())
												return this.clickgetBtnSubmit();
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactEmailscheduleMySelf
	 * #Arguments:StartDate
	 * Type:TextBox

	 */
	public boolean  createPromisedActionContactEmailscheduleMySelf(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.setTxtStartDate(args[0]))
				if(this.setTxtStartTime(""))
					if(this.setTxtEndTime(""))
						if(this.selectDropDownTimeZone("Central", args[0]))
							if(this.selectDropDownCommunicationChannel("Email"))
								if(this.setgettxtfieldCommnTypeEmail("test@test.com"))
									if(this.clickServiceRequestTypeEligibility())
										if(this.setTxtNotes("test"))
											if(this.clickgetBtnRdBtnSchedulefrMysellf())
												return this.clickgetBtnSubmit();
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactMailScheduleTeam
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and then selects the communication channel as mail and then enters mail address and then selects the myself radio button and then enter notes and then clicks the submit button. 
	 * #Arguments:args
	 * Type:TextBox
	 */	
	public boolean  createPromisedActionContactMailScheduleTeam(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.setTxtStartTime(""))
				if(this.setTxtEndTime(""))
					if(this.selectDropDownTimeZone("Central", args[0]))
						if(this.setTxtStartDate(args[0]))
							if(this.selectDropDownCommunicationChannel("Mail"))
								if(this.clickServiceRequestTypeEligibility())
									if(this.setTxtNotes("test"))
										return this.clickgetBtnSubmit();
		return false;
	}

	public boolean  createPromisedActionContactMailScheduleMyself(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.setTxtStartDate(args[0]))
				if(this.setTxtStartTime(""))
					if(this.setTxtEndTime(""))
						if(this.selectDropDownTimeZone("Central", args[0]))
							if(this.selectDropDownCommunicationChannel("Mail"))
								if(this.selectcontactTopicDropDown("Eligibility"))
									if(this.setTxtNotes("test"))
										if(this.clickgetBtnRdBtnSchedulefrMysellf())
											return this.clickgetBtnSubmit();
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactEmailscheduleTeam
	 * #Arguments:StartDate
	 * Type:TextBox

	 */
	public boolean  createPromisedActionContactFaxscheduleTeam(String[] args) throws InterruptedException, AWTException
	{

		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.setTxtStartDate(args[0]))
				if(this.setTxtStartTime(""))
					if(this.setTxtEndTime(""))
						if(this.selectDropDownTimeZone("Central", args[0]))
							if(this.selectDropDownCommunicationChannel("Fax"))
								if(this.settxtbxCommnTypeFax("1234567890"))
									if(this.selectcontactTopicDropDown("Eligibility"))
										if(this.setTxtNotes("Test"))
											return clickgetBtnSubmit();
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactFaxscheduleMyself
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and selects the communication channel as Fax and then user enters the fax number and then selects the myself radio button and then enter notes and then clicks the submit button. 
	 * #Arguments:args
	 * Type:TextBox
	 */	

	public boolean  createPromisedActionContactFaxscheduleMyself(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.setTxtStartDate(args[0]))
				if(this.setTxtStartTime(""))
					if(this.setTxtEndTime(""))
						if(this.selectDropDownTimeZone("Central", args[0]))
							if(this.selectDropDownCommunicationChannel("Fax"))
								if(this.settxtbxCommnTypeFax("1234567890"))
									if(this.clickServiceRequestTypeEligibility())
										if(this.setTxtNotes("Test"))
											if(this.clickgetBtnRdBtnSchedulefrMysellf())
												return this.clickgetBtnSubmit();
		return false;
	}

	@FindBy(xpath="//input[@id='PACActivityTypeTask']")
	private WebElement rdbtnTypeTask;

	@FindBy(id="DueDate")
	private WebElement txtbxDueDate;

	@FindBy(id="DueTime")
	private WebElement txtbxDueTime;
	@FindBy(xpath="//*[@id='OtherTopic']")
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


	public boolean settxtbxDueDate(String sFullName) throws InterruptedException
	{
		return utils.enterTextinAnelemnt(this.gettxtbxDueDate(), sFullName, "Create Promised Action ", "TextBox Date");
	}

	public boolean selectDropDownTimeZone(String visibletext, String date) 
	{
		try
		{
			return utils.selectDropDownbyVisibleString(this.drpDownTimezone, visibletext, "Promised action", "Timezone");
		}
		catch(Exception e)
		{
			return selectDropDownTimeZone(visibletext, date);
		}
	}

	public boolean selectDropDownTopicRadiobtnTask(String visibletext) throws InterruptedException, AWTException
	{
		if(utils.selectDropDownbyVisibleString(this.drpDownTopic, visibletext, "Promised action", "Topic Task"))
			return (!utils.isProxyWebelement(this.drpDownTaskTopicSelected));
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionTaskTeamTopicResearch
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and then enter notes and then clicks the submit button. 
	 * #Arguments:sDate
	 * Type:TextBox
	 */	
	public boolean  createPromisedActionTaskTeamTopicResearch() throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.clickrdbtnTypeTask())
				if(this.settxtbxDueDate(Tdate))
					if(this.setDueTime())
						if(this.selectDropDownTimeZone("Central", Tdate))
							if(this.clickServiceRequestTypeEligibility())
								if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
									return this.clickgetBtnSubmit();
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionTaskMyselfTopicResearch
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and then selects the myself radio button and then enter notes and then clicks the submit button. 
	 * #Arguments:sDate
	 * Type:TextBox
	 */	
	public boolean  createPromisedActionTaskMyselfTopicResearch(String[] sDate) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
			if(this.clickrdbtnTypeTask())
				if(this.settxtbxDueDate(sDate[0]))
					if(this.settxtbxDueTime("5:59:00 PM"))
						if(this.selectDropDownTimeZone("Central", sDate[0]))
							if(this.clickServiceRequestTypeEligibility())
								if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
									if(this.clickgetBtnRdBtnSchedulefrMysellf())
										return this.clickgetBtnSubmit();
		return false;
	}

	public boolean  createPromisedActionTaskTeamTopicOutreach(String[] sDate) throws InterruptedException, AWTException
	{

		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.clickrdbtnTypeTask())
			{
				JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
				jse.executeScript("scroll(0, 100);");
				// Owing to Stale element process we have to use try and catch 
				if(this.settxtbxDueDate(sDate[0]))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.settxtbxDueTime("5:59:00 PM"))
					{

						if(this.selectDropDownTimeZone("Central", sDate[0]))
						{	if(this.selectDropDownTopicRadiobtnTask("Outreach"))
						{
							if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
							{
								if(this.clickgetBtnSubmit())
								{
									System.out.println("Pass : Create Promised Action Page is able to save the details. ");
									return true; 
								}

							}
						}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}

	public boolean  createPromisedActionTaskMyselfTopicOutreach(String[] sDate) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.clickrdbtnTypeTask())
			{
				JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
				jse.executeScript("scroll(0, 100);");
				// Owing to Stale element process we have to use try and catch 
				if(this.settxtbxDueDate(sDate[0]))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.settxtbxDueTime("5:59:00 PM"))
					{

						if(this.selectDropDownTimeZone("Central", sDate[0]))
						{
							if(this.selectDropDownTopicRadiobtnTask("Outreach"))
							{

								if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
								{


									if(this.clickgetBtnRdBtnSchedulefrMysellf())
									{

										if(this.clickgetBtnSubmit())
										{
											System.out.println("Pass : Create Promised Action Page is able to save the details. ");
											return true; 
										}
									}

								}
							}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionTaskTeamTopicInternalContact
	 * #Description: This functionality validates the header and enter the notes and then validates the header of the Other and the Myself label 
	 * #Arguments:sDate
	 * Type:TextBox
	 */	

	public boolean  createPromisedActionTaskTeamTopicInternalContact(String[] sDate) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.clickrdbtnTypeTask())
			{
				JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
				jse.executeScript("scroll(0, 100);");
				// Owing to Stale element process we have to use try and catch 
				if(this.settxtbxDueDate(sDate[0]))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.settxtbxDueTime("5:59:00 PM"))
					{

						if(this.selectDropDownTimeZone("Central", sDate[0]))
						{
							if(this.clickServiceRequestTypeEligibility())
							{

								if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
								{
									if(this.clickgetBtnSubmit())
									{
										System.out.println("Pass : Create Promised Action Page is able to save the details. ");
										return true; 
									}


								}
							}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}

	public boolean  createPromisedActionTaskMyselfTopicInternalContact(String[] sDate) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.clickrdbtnTypeTask())
			{
				JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
				jse.executeScript("scroll(0, 100);");
				// Owing to Stale element process we have to use try and catch 
				if(this.settxtbxDueDate( sDate[0]))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.settxtbxDueTime("5:59:00 PM"))
					{

						if(this.selectDropDownTimeZone("Central", sDate[0]))
						{
							if(this.selectDropDownTopicRadiobtnTask("Internal Contact"))
							{

								if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
								{

									if(this.clickgetBtnRdBtnSchedulefrMysellf())
									{

										if(this.clickgetBtnSubmit())
										{
											System.out.println("Pass : Create Promised Action Page is able to save the details. ");
											return true; 
										}

									}
								}
							}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}

	public boolean  createPromisedActionTaskTeamTopicOther(String[] sDate) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.clickrdbtnTypeTask())
			{
				JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
				jse.executeScript("scroll(0, 100);");
				// Owing to Stale element process we have to use try and catch 
				if(this.settxtbxDueDate(sDate[0]))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.settxtbxDueTime("5:59:00 PM"))
					{

						if(this.selectDropDownTimeZone("Central",  sDate[0]))
						{
							if(this.clickServiceRequestTypeEligibility())

								//if(this.selectDropDownTopicRadiobtnTask("Other"))
							{


								if(this.setTxtNotes("Please enter my details son. I am in a bit of crises right now. so just get me help 991"))
								{

									//	if(this.settxtbxOtherTopic("Anthem Employee"))
									{


										if(this.clickgetBtnSubmit())
										{
											System.out.println("Pass : Create Promised Action Page is able to save the details. ");
											return true; 
										}


									}
								}
							}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}


	// Negetive testing is left in this case 


	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionTaskMyselfTopicOther
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and then selects the myself radio button and then enter notes and then clicks the submit button. 
	 * #Arguments:sDate
	 * Type:TextBox
	 */	

	public boolean  createPromisedActionTaskMyselfTopicOther(String[] sDate) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.clickrdbtnTypeTask())
			{
				JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
				jse.executeScript("scroll(0, 100);");
				// Owing to Stale element process we have to use try and catch 
				if(this.settxtbxDueDate(sDate[0]))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.settxtbxDueTime("5:59:00 PM"))
					{
						if(this.selectDropDownTimeZone("Central", sDate[0]))
						{
							if(this.clickServiceRequestTypeEligibility())
							{
								if(this.setTxtNotes("Please enter my details son. I am in a bit of crises right now. so just get me help 991"))
								{
									//if(this.settxtbxOtherTopic("Anthem Employee"))
									//{
									if(this.clickgetBtnRdBtnSchedulefrMysellf())
									{
										if(this.clickgetBtnSubmit())
										{
											System.out.println("Pass : Create Promised Action Page is able to save the details. ");
											return true; 
										}

									}
									//}
								}
							}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}



	// Next Step for the Program 



	@FindBy(xpath= "//*[contains(@class,'header-title')][text()='Service Request Details']")
	WebElement sHeaderPromisedActionServiceRequest ;


	@FindBy(xpath="//*[contains(@class,'content-inline_middle')]//*[contains(@class,'RecentTab')]/*[contains(@class,'item-2')]//*[contains(@class,'Value')]")
	WebElement closePresentTab;



	public boolean clickclosePromisedActionTab()
	{
		return utils.clickAnelemnt(this.closePresentTab, "Create Promised Action ", "CloseButton");
	}
	/**
	 * Close the present page to land back to the home page 
	 * @return
	 */


	public boolean closePromisedActionTab()
	{
		Driver.getPgDriver().switchTo().defaultContent();
		return clickclosePromisedActionTab();
	}

	public boolean validateDateEntered() throws InterruptedException, AWTException
	{
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		Date date=new Date();
		String todaydate=df.format(date);
		Date newDate=DateUtils.addMonths(date, 1);
		String dateafteronemonth=df.format(newDate);

		if(utils.clickAnelemnt(rdbtnTypeTask, "Promised Action", "Radio button task"))
		{
			if(this.settxtbxDueDate(dateafteronemonth))
				System.out.println("Pass : Was success ful in entering the Date ");
			if(this.settxtbxDueTime("5:59:00 PM"))
			{

				if(this.selectDropDownTimeZone("Central", "05/15/2017"))
				{
					if(this.selectDropDownTopicRadiobtnTask("Other"))
					{

						if(this.setTxtNotes("Please enter my details son. I am in a bit of crises right now. so just get me help 991"))
						{
							if(this.settxtbxOtherTopic("Anthem Employee"))
							{
								if(this.clickgetBtnRdBtnSchedulefrMysellf())
								{
									if(this.clickgetBtnSubmit())
									{
										//Driver.pgDriver.switchTo().alert().accept();
										if(Driver.pgDriver.getPageSource().contains("Start Date cannot be more than 30"))
											System.out.println("Pass : Error thrown ");
										return true; 
									}
									else
										return false;

								}
							}
						}
					}
				}
			}
		}
		return false;
	}


	public boolean createPromisedActionResearchContactPhoneScheduleMyself(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{


			if(this.setTxtStartDate(args[0]))
			{

				// Owing to Stale element process we have to use try and catch 
				if(this.setTxtStartTime(""))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.setTxtEndTime(""))
					{

						if(this.selectDropDownTimeZone("Central", args[0]))
						{
							if(this.selectDropDownCommunicationChannel("Phone"))
							{


								if(this.selectcontactTopicDropDown("Eligibility"))
								{

									this.clickRadiobtnVoicemail();

									if(this.setTxtNotes("test"))
									{
										if(this.setTxtPhoneResearch("8797988799"))
										{
											if(this.clickgetBtnRdBtnSchedulefrMysellf())
											{
												if(this.clickgetBtnSubmit())
												{

													System.out.println("Pass : Create Promised Action Page is able to save the details. ");
													return true; 
												}
											}
										}

									}

								}
							}
						}
					}

				}
			} 
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}
	@FindBy (xpath="//span[text()='Eligibility']")	
	private WebElement serviceRequestType;
	public boolean clickServiceRequestTypeEligibility()
	{
		return utils.clickAnelemnt(this.serviceRequestType, "Create Promised Action ", "Click on Eligibility");
	}

	public boolean  createPromisedActionResearchContactPhoneScheduleTeam(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.setTxtStartDate(args[0]))
			{


				// Owing to Stale element process we have to use try and catch 
				if(this.setTxtStartTime("11:49:00 AM"))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.setTxtEndTime("12:37:00 AM"))
					{

						if(this.selectDropDownTimeZone("Central", args[0]))
						{
							if(this.selectDropDownCommunicationChannel("Phone"))
							{

								this.clickRadiobtnVoicemailno();

								if(this.selectcontactTopicDropDown("Eligibility"))
								{


									if(this.setTxtNotes("test"))
									{
										if(this.setTxtPhoneResearch("8797988799"))
										{
											if(this.clickgetBtnSubmit())
											{

												System.out.println("Pass : Create Promised Action Page is able to save the details. ");
												return true; 
											}




										}
									}
								}
							}

						}
					} 
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}


	public boolean  createPromisedActionByTaskTeamTopicInternalContact(String[] sDate) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.clickrdbtnTypeTask())
			{
				JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
				jse.executeScript("scroll(0, 100);");
				// Owing to Stale element process we have to use try and catch 
				if(this.settxtbxDueDate(sDate[0]))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.settxtbxDueTime("5:59:00 PM"))
					{

						if(this.selectDropDownTimeZone("Central", sDate[0]))
						{
							if(this.clickServiceRequestTypeEligibility())
							{

								if(this.setTxtNotes("Please enter my details son. i am in a bit of crises right now. so just get me help 991"))
								{

									if(this.clickgetBtnSubmit())
									{
										System.out.println("Pass : Create Promised Action Page is able to save the details. ");
										return true; 
									}
								}
							}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}


	public boolean  createPromisedActionTaskMyselfTopicOthers(String[] sDate) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.clickrdbtnTypeTask())
			{
				JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
				jse.executeScript("scroll(0, 100);");
				// Owing to Stale element process we have to use try and catch 
				if(this.settxtbxDueDate(Tdate))
				{
					if(this.setDueTime())
					{
						if(this.selectDropDownTimeZone("Central", Tdate))
						{
							if(this.clickServiceRequestTypeEligibility())
							{
								if(this.setTxtNotes("Please enter my details son. I am in a bit of crises right now. so just get me help 991"))
								{
									if(this.clickgetBtnRdBtnSchedulefrMysellf())
									{
										if(this.clickgetBtnSubmit())
										{
											System.out.println("Pass : Create Promised Action Page is able to save the details. ");
											return true; 
										}

									}
									//}
								}
							}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}

	@FindBy(id="ContactType")
	WebElement drpDownContactType;


	public boolean selectContactType(String args)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownContactType, args, "CreatePromisedActions", "Contact Type");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactPhoneScheduleTeamForProviderContactType
	 * #Description: This functionality creates the promised action by validating the header and enter the start date given by the user , sets the start time and end time, selects the time zone , selects the communication channel as email and enters the email and enter the notes and then clicks submit.
	 * #Arguments:args
	 * Type:TextBox and DropDown
	 * Keys:Member,Provider
	 */

	public boolean  createPromisedActionContactPhoneScheduleTeamForProviderContactType(String[] args) throws InterruptedException, AWTException
	{


		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.selectContactType(args[0]))
			{

				if(this.enterProviderName(args[1]))
				{


					if(this.setTxtStartDate(args[2]))
					{


						// Owing to Stale element process we have to use try and catch 
						if(this.setTxtStartTime("11:49:00 AM"))
						{
							System.out.println("Pass : Was success ful in entering the Date ");
							// For end date 
							if(this.setTxtEndTime("12:37:00 AM"))
							{

								if(this.selectDropDownTimeZone("Central", args[2]))
								{
									if(this.selectDropDownCommunicationChannel("Phone"))
									{
										if(this.enterPhoneNumber(args[3]))
										{
											if(utils.clickAnelemnt(this.radBtnVoicemailYes, "CreatePromisedActions", "Radio Button VM Yes"))
											{
												if(this.clickServiceRequestTypeEligibility())
												{
													if(this.setTxtNotes("test"))
													{
														if(this.clickgetBtnSubmit())
														{											
															System.out.println("Pass : Create Promised Action Page is able to save the details. ");
															return true;
														}
													}
												}
											}
										}	
									}
								}
							} 
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}

	//Sprint 2.1 changes



	@FindBy(id="ProviderName")
	WebElement txtBxproviderName;

	public boolean enterProviderName(String provName)
	{
		return utils.enterTextinAnelemnt(txtBxproviderName, provName,"CreatePromisedActions", "Provider name");
	}

	@FindBy(id="CallBackNumber")
	WebElement txtBxphneNumber;

	public boolean enterPhoneNumber(String phneNumber)
	{	
		int len=phneNumber.length();
		String phoneNo=txtBxphneNumber.getText();
		System.out.println("Phone Numnber: "+phoneNo);
		int phonelength = phoneNo.length();
		System.out.println("Legeth of Numnber: "+phonelength);
		if((phonelength<1)&&(len==10))
			return utils.enterTextinAnelemnt(txtBxphneNumber, phneNumber,"CreatePromisedActions", "Phone Number");
		return false;
	}

	public boolean enterMailDetails()
	{
		if(utils.enterTextinAnelemnt(addresse, "Test", "CreatePromisedActions", "Addresse name"))
			if(utils.enterTextinAnelemnt(addressLine1, "Testing", "CreatePromisedActions", "Address line name"))
				if(utils.enterTextinAnelemnt(city, "Test", "CreatePromisedActions", "city name"))
					return utils.enterTextinAnelemnt(zipCode, "90001", "CreatePromisedActions", "Zip Code");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactPhoneScheduleMyselfForProviderContactType
	 * #Description: This functionality creates the promised action by validating the header and enter the start date given by the user , sets the start time and end time, selects the time zone , selects the communication channel as email and enters the email and enter the notes and then clicks submit.
	 * #Arguments:args
	 * Type:TextBox and DropDown
	 * Keys:Member,Provider
	 */

	public boolean  createPromisedActionContactPhoneScheduleMyselfForProviderContactType(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.selectContactType(args[0]))
			{

				if(this.enterProviderName(args[1]))
				{

					if(this.setTxtStartDate(args[2]))
					{

						// Owing to Stale element process we have to use try and catch 
						if(this.setTxtStartTime(""))
						{
							System.out.println("Pass : Was success ful in entering the Date ");
							// For end date 
							if(this.setTxtEndTime(""))
							{

								if(this.selectDropDownTimeZone("Central", args[2]))
								{
									if(this.selectDropDownCommunicationChannel("Phone"))
									{
										if(this.enterPhoneNumber(args[3]))
										{
											if(utils.clickAnelemnt(this.radBtnVoicemailYes, "CreatePromisedActions", "Radio Button VM Yes"))
											{
												if(this.clickServiceRequestTypeEligibility())
												{
													if(this.setTxtNotes("test"))
													{
														if(this.clickgetBtnRdBtnSchedulefrMysellf())
														{
															if(this.clickgetBtnSubmit())
															{

																System.out.println("Pass : Create Promised Action Page is able to save the details. ");
																return true; 
															}
														}
													}
												}
											}
										}	
									}
								}
							} 
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactEmailscheduleTeamForProviderContactType
	 * #Description: This functionality creates the promised action by validating the header and enter the start date given by the user , sets the start time and end time, selects the time zone , selects the communication channel as email and enters the email and enter the notes and then clicks submit.
	 * #Arguments:args
	 * Type:TextBox and DropDown
	 * Keys:Member,Provider
	 */

	public boolean  createPromisedActionContactEmailscheduleTeamForProviderContactType(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.selectContactType(args[0]))
			{

				if(this.enterProviderName(args[1]))
				{
					if(this.setTxtStartDate(args[2]))
					{
						// Owing to Stale element process we have to use try and catch 
						if(this.setTxtStartTime(""))
						{
							System.out.println("Pass : Was success ful in entering the Date ");
							// For end date 
							if(this.setTxtEndTime(""))
							{

								if(this.selectDropDownTimeZone("Central", args[2]))
								{
									if(this.selectDropDownCommunicationChannel("Email"))
									{
										if(this.setgettxtfieldCommnTypeEmail("test@test.com"))
										{

											if(this.clickServiceRequestTypeEligibility())
											{
												if(this.setTxtNotes("test"))
												{
													if(this.clickgetBtnSubmit())
													{

														System.out.println("Pass : Create Promised Action Page is able to save the details. ");
														return true; 
													}

												}
											}
										}
									}
								}
							}
						}
					}
				}
			} 
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactEmailscheduleMySelfForProviderContactType
	 * #Description: This functionality creates the promised action by validating the header and enter the start date given by the user , sets the start time and end time, selects the time zone , selects the communication channel as email and enters the email and enter the notes and then clicks submit.
	 * #Arguments:args
	 * Type:TextBox and DropDown
	 * Keys:Member,Provider
	 */


	public boolean  createPromisedActionContactEmailscheduleMySelfForProviderContactType(String[] args) throws InterruptedException, AWTException
	{


		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.selectContactType(args[0]))
			{

				if(this.enterProviderName(args[1]))
				{
					if(this.setTxtStartDate(args[2]))
					{


						// Owing to Stale element process we have to use try and catch 
						if(this.setTxtStartTime(""))
						{
							System.out.println("Pass : Was success ful in entering the Date ");
							// For end date 
							if(this.setTxtEndTime(""))
							{

								if(this.selectDropDownTimeZone("Central", args[2]))
								{
									if(this.selectDropDownCommunicationChannel("Email"))
									{
										if(this.setgettxtfieldCommnTypeEmail("test@test.com"))
										{

											if(this.clickServiceRequestTypeEligibility())
											{


												if(this.setTxtNotes("test"))
												{
													if(this.clickgetBtnRdBtnSchedulefrMysellf())
													{

														if(this.clickgetBtnSubmit())
														{

															System.out.println("Pass : Create Promised Action Page is able to save the details. ");
															return true; 
														}

													}
												}

											}
										}
									}
								}
							}
						}
					} 
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactMailScheduleTeamForProviderContactType
	 * #Description: This functionality creates the promised action by validating the header and enter the start date given by the user , sets the start time and end time, selects the time zone , selects the communication channel as email and enters the email and enter the notes and then clicks submit.
	 * #Arguments:args
	 * Type:TextBox and DropDown
	 * Keys:Member,Provider
	 */

	public boolean  createPromisedActionContactMailScheduleTeamForProviderContactType(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.selectContactType(args[0]))
			{

				if(this.enterProviderName(args[1]))
				{
					if(this.setTxtStartDate(args[2]))
					{
						// Owing to Stale element process we have to use try and catch 
						if(this.setTxtStartTime(""))
						{
							System.out.println("Pass : Was success ful in entering the Date ");
							// For end date 
							if(this.setTxtEndTime(""))
							{
								if(this.selectDropDownTimeZone("Central", args[2]))
								{
									if(this.selectDropDownCommunicationChannel("Mail"))
									{
										if(this.enterMailDetails())
										{
											if(this.clickServiceRequestTypeEligibility())
											{
												if(this.setTxtNotes("test"))
												{


													if(this.clickgetBtnSubmit())
													{
														System.out.println("Pass : Create Promised Action Page is able to save the details. ");
														return true; 
													}
												}
											}
										}
									}
								}
							}
						}
					}
				} 
			}
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactMailScheduleMyselfForProviderContactType
	 * #Description: This functionality creates the promised action by validating the header and enter the start date given by the user , sets the start time and end time, selects the time zone , selects the communication channel as email and enters the email and enter the notes and then clicks submit.
	 * #Arguments:args
	 * Type:TextBox and DropDown
	 * Keys:Member,Provider
	 */

	public boolean  createPromisedActionContactMailScheduleMyselfForProviderContactType(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.selectContactType(args[0]))
			{

				if(this.enterProviderName(args[1]))
				{

					if(this.setTxtStartDate(args[2]))
					{


						// Owing to Stale element process we have to use try and catch 
						if(this.setTxtStartTime(""))
						{
							System.out.println("Pass : Was success ful in entering the Date ");
							// For end date 
							if(this.setTxtEndTime(""))
							{

								if(this.selectDropDownTimeZone("Central", args[2]))
								{
									if(this.selectDropDownCommunicationChannel("Mail"))
									{
										if(this.enterMailDetails())
										{
											if(this.clickServiceRequestTypeEligibility())
											{


												if(this.setTxtNotes("test"))
												{
													if(this.clickgetBtnRdBtnSchedulefrMysellf())
													{


														if(this.clickgetBtnSubmit())
														{

															System.out.println("Pass : Create Promised Action Page is able to save the details. ");
															return true; 
														}

													}
												}

											}
										}
									}
								}
							}
						}
					}
				} 
			}
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactFaxscheduleTeamForProviderContactType
	 * #Description: This functionality creates the promised action by validating the header and enter the start date given by the user , sets the start time and end time, selects the time zone , selects the communication channel as email and enters the email and enter the notes and then clicks submit.
	 * #Arguments:args
	 * Type:TextBox and DropDown
	 * Keys:Member,Provider
	 */

	public boolean  createPromisedActionContactFaxscheduleTeamForProviderContactType(String[] args) throws InterruptedException, AWTException
	{

		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.selectContactType(args[0]))
			{

				if(this.enterProviderName(args[1]))
				{


					if(this.setTxtStartDate(args[2]))
					{

						if(this.setTxtStartTime(""))
						{
							System.out.println("Pass : Was success ful in entering the Date ");
							// For end date 
							if(this.setTxtEndTime(""))
							{

								if(this.selectDropDownTimeZone("Central", args[2]))
								{
									if(this.selectDropDownCommunicationChannel("Fax"))
									{
										System.out.println("DropDown Selected");
										if(this.settxtbxCommnTypeFax("1234567890"))
										{
											//if(clickFaxNumberVerifiedWithContactCheckbox())
											if(this.clickServiceRequestTypeEligibility())
											{
												if(this.setTxtNotes("Test"))
												{
													if(this.clickgetBtnSubmit())
													{
														System.out.println("Pass : Create Promised Action Page is able to save the details. ");
														return true; 
													}

												}

											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		err.logError("Error in one of the fields with entering the value");
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactFaxscheduleMyselfForProviderContactType
	 * #Description: This functionality creates the promised action by validating the header and enter the start date given by the user , sets the start time and end time, selects the time zone , selects the communication channel as email and enters the email and enter the notes and then clicks submit.
	 * #Arguments:args
	 * Type:TextBox and DropDown
	 * Keys:Member,Provider
	 */

	public boolean  createPromisedActionContactFaxscheduleMyselfForProviderContactType(String[] args) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.selectContactType(args[0]))
			{

				if(this.enterProviderName(args[1]))
				{
					if(this.setTxtStartDate(Tdate))
					{
						if(this.setTxtStartTime(""))
						{
							if(this.setTxtEndTime(""))
							{
								//Thread.sleep(3000);
								if(utils.selectDropDownbyVisibleString(drpDownTimezone, "Central", "Promised Action", "Time Zone"))
								{
									if(this.selectDropDownCommunicationChannel("Fax"))
									{
										System.out.println("DropDown Selected");
										if(this.settxtbxCommnTypeFax("1234567890"))
										{
											if(this.clickServiceRequestTypeEligibility())
											{
												if(this.setTxtNotes("Test"))
												{
													if(this.clickgetBtnRdBtnSchedulefrMysellf())
													{
														if(this.clickgetBtnSubmit())
														{
															System.out.println("Pass : Create Promised Action Page is able to save the details. ");
															return true; 
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}		err.logError("Error in one of the fields with entering the value");
		return false;

	}


	@FindBy(xpath="//input[@data-test-id='20150925005544000718744']")
	private WebElement phonenumber;

	@FindBy(xpath="//input[@data-test-id='20150925005544000718744']/parent::span/div/span")
	private WebElement phoneNumberErrorMessage;


	public boolean verifyPhonenumber() throws Exception{

		return utils.validateValueinelement(this.phonenumber,"(123) 456-7890");
	}

	public boolean verifyPhonenumberErorMessage() throws Exception{

		return utils.validateValueinelement(this.phoneNumberErrorMessage,"cannot be blank");
	}	


	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactPhoneScheduleMyselfAndVerifyPhoneNumber
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and then selects the myself radio button and then enter notes and then clicks the submit button. 
	 * #Arguments:sDate
	 * Type:TextBox
	 */	

	public boolean createPromisedActionContactPhoneScheduleMyselfAndVerifyPhoneNumber(String[] args) throws Exception
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.setTxtStartDate(args[0]))
			{

				// Owing to Stale element process we have to use try and catch 
				if(this.setTxtStartTime(""))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.setTxtEndTime(""))
					{

						if(this.selectDropDownTimeZone("Central", args[0]))
						{
							if(this.selectDropDownCommunicationChannel("Phone"))
							{
								utils.waitforpageload();
								this.verifyPhonenumber();
								this.clickRadiobtnVoicemailno();

								if(this.clickServiceRequestTypeEligibility())
								{

									if(this.setTxtNotes("test"))
									{
										if(this.clickgetBtnRdBtnSchedulefrMysellf())
										{
											if(this.clickgetBtnSubmit())
											{

												System.out.println("Pass : Create Promised Action Page is able to save the details. ");
												return true; 
											}
										}

									}

								}
							}
						}
					}

				}
			} 
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}


	public boolean clickSubmit()
	{		
		return utils.clickAnelemnt(this.getBtnSubmit(), "Create Promised Action ", "Radio Buttoon  Verify Associate");
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactPhoneScheduleMyselfAndVerifyPhoneNumberErrorMessage
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and then selects the myself radio button and then enter notes and then clicks the submit button. 
	 * #Arguments:sDate
	 * Type:TextBox
	 */	
	public boolean  createPromisedActionContactPhoneScheduleMyselfAndVerifyPhoneNumberErrorMessage(String[] args) throws Exception
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.setTxtStartDate(args[0]))
			{

				// Owing to Stale element process we have to use try and catch 
				if(this.setTxtStartTime(""))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.setTxtEndTime(""))
					{

						if(this.selectDropDownTimeZone("Central", args[0]))
						{
							if(this.selectDropDownCommunicationChannel("Phone"))
							{
								utils.waitforpageload();
								this.clickRadiobtnVoicemailno();

								if(this.clickServiceRequestTypeEligibility())
								{

									if(this.setTxtNotes("test"))
									{
										if(this.clickgetBtnRdBtnSchedulefrMysellf())
										{
											if(this.clickSubmit())
											{
												utils.verifyAlertText("Please correct flagged fields before submitting the form!");
												System.out.println("Pass : Create Promised Action Page is able to save the details. ");
												this.verifyPhonenumberErorMessage();

												return true; 
											}
										}

									}

								}
							}
						}
					}

				}
			} 
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}



	/*
	 * @SCU
	 * #CommonMethodwithArgument:createPromisedActionContactPhoneScheduleMyselfForResearchMember
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and then selects the myself radio button and then enter notes and then clicks the submit button. 
	 * #Arguments:sDate
	 * Type:TextBox
	 */	

	public boolean createPromisedActionContactPhoneScheduleMyselfForResearchMember(String[] args) throws Exception
	{
		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{

			if(this.setTxtStartDate(args[0]))
			{

				// Owing to Stale element process we have to use try and catch 
				if(this.setTxtStartTime(""))
				{
					System.out.println("Pass : Was success ful in entering the Date ");
					// For end date 
					if(this.setTxtEndTime(""))
					{

						if(this.selectDropDownTimeZone("Central", args[0]))
						{
							if(this.selectDropDownCommunicationChannel("Phone"))
							{
								utils.waitforpageload();
								utils.enterTextinAnelemnt(this.phonenumber, "1234567890", "CreatePromisedActions", "PhonenumberTxtbox");
								this.clickRadiobtnVoicemailno();

								if(this.clickServiceRequestTypeEligibility())
								{

									if(this.setTxtNotes("test"))
									{
										if(this.clickgetBtnRdBtnSchedulefrMysellf())
										{
											if(this.clickgetBtnSubmit())
											{

												System.out.println("Pass : Create Promised Action Page is able to save the details. ");
												return true; 
											}
										}

									}

								}
							}
						}
					}

				}
			} 
		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;

	}

	@FindBy(xpath="//*[@id='PAVerifiedProviderFAX']")
	WebElement VerifiedFAXChckBox;

	public boolean clickFaxNumberVerifiedWithContactCheckbox() {
		return utils.clickAnelemnt(VerifiedFAXChckBox, "CreatePromisedActions", "VerifiedFAXChckBox");
	}

	@FindBy(xpath="//*[@id='ERRORMESSAGES_ALL']//ul")
	WebElement ErrorMsg;

	public boolean validateErrorMessageWhenMandatoryFieldsNotFilled(String[] args) {
		return utils.validateLabel(ErrorMsg, args[0]);
	}

	public boolean validateFaxNumberVerifiedWithContactCheckboxisDisplayed() {
		return !utils.isProxyWebelement(VerifiedFAXChckBox);
	}

	public boolean selectCommunicationTypeDropdown(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		try
		{
			utils.selectDropDownbyVisibleString(this.drpDownCommunucationChannel, args[0], "Create Promised action", "Communication Channel");
		}
		catch(ElementNotVisibleException e1) {
			utils.selectDropDownbyVisibleString(drpDownCommunucationChannel1, args[0], "Create Promised action", "Communication Channel");
		}
		return (!utils.isProxyWebelement(this.drpDownCommunucationChannelSelected));

	}

	public boolean ValidateProviderFaxNumberForFax(String[] args) {
		return settxtbxCommnTypeFax(args[0]);
	}

	public boolean ValidateNoProviderFaxNumber() {
		return utils.validateLabel(txtbxCommnTypeFax, "");
	}

	public boolean ValidateNoProviderCorrespondenceAddress() {
		return utils.validateLabel(addresse, "") && utils.validateLabel(addressLine1, "") && utils.validateLabel(zipCode, "");
	}

	@FindBy(id="pyState")
	WebElement State;

	public boolean ValidateProviderPrimaryCorrespondenceAddressForMail(String[] args) throws Exception {
		boolean returnvar ;
		returnvar = true;

		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("Create Promised Actions", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("addressee")){
				returnvar=addresse.getAttribute("value").equalsIgnoreCase(value);
				continue;}
			else if(key.toLowerCase().contains("address line 1")){
				returnvar =addressLine1.getAttribute("value").equalsIgnoreCase(value);
				continue;}

			else if(key.toLowerCase().contains("city")){
				returnvar =city.getAttribute("value").equalsIgnoreCase(value);
				continue;
			}
			else if(key.toLowerCase().contains("state")){
				Select se = new Select(State);
				String state = se.getFirstSelectedOption().getText();
				returnvar =utils.isvalueMatch_contain(state, value);
				continue;
			}
			else if(key.toLowerCase().contains("zip code")){
				returnvar =zipCode.getAttribute("value").equalsIgnoreCase(value);
				continue;
			}
			else 
				err.logcommonMethodError("Create Promised Actions", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}


		if(returnvar)
		{
			System.out.println("Create Promised Actions info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("Create Promised Actions", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(id="PAVerifiedProviderMail")
	WebElement VerifiedMailChckBox;

	public boolean clickMailingAddressVerifiedWithContactCheckbox() {
		return utils.clickAnelemnt(VerifiedMailChckBox, "CreatePromisedActions", "VerifiedMailChckBox");
	}

	@FindBy(xpath="//*[@data-test-id='20150925005544000717994-Label']//img")
	WebElement CommunicationHoverImg;

	public boolean validateCommunicationTypeHover() throws InterruptedException {
		Actions action = new Actions(Driver.pgDriver);
		action.moveToElement(CommunicationHoverImg).click().build().perform();
		Thread.sleep(1000);
		String actualText = CommunicationHoverImg.getAttribute("aria-label");
		return utils.isvalueMatch_contain(actualText, "Remember to verify");
	}

	public boolean selectContactTypeDropdown(String[] args) {
		return selectContactType(args[0]);
	}

	public boolean validateMailingAddressVerifiedWithContactCheckboxisDisplayed() {
		return !utils.isProxyWebelement(VerifiedMailChckBox);
	}

	@FindBy(xpath="//table[@pl_prop='D_GetSRsListForPATopics.pxResults']//span[text()='Grievance and Appeals']")
	WebElement taskServiceRequestType;

	@FindBy(id="PACActivityTypeTask")
	WebElement rdoBtnTask;

	@FindBy(xpath="(//img[@class='inactvIcon'])[2]")
	WebElement imgDueTime;

	@FindBy(xpath="//a[@id='applyLink']")
	WebElement lnkApplyForDueTime;

	public boolean clickServiceRequestTypeGA()
	{
		return utils.clickAnelemnt(this.taskServiceRequestType, "CreatePromisedActions", "Click on GA Task");
	}

	public boolean clickRdoBtnTask()
	{
		return utils.clickAnelemnt(this.rdoBtnTask, "CreatePromisedActions", "Click on GA Task");
	}

	public boolean clickRdoBtnMyself()
	{
		return utils.clickAnelemnt(this.rdBtnSchedulefrMysellf, "CreatePromisedActions", "Click on Myself");
	}

	public boolean setDueTime() throws InterruptedException
	{
		Thread.sleep(3000);
		if(utils.clickAnelemnt(imgDueTime, "CreatePromisedActions", "Due Time Img Picker")) 
			return utils.clickAnelemnt(lnkApplyForDueTime, "CreatePromisedActions", "Click Apply Link");
		return false;

	}

	public boolean createPromisedActionAfterCompletingGATask(String[] date) throws InterruptedException, AWTException
	{


		if(utils.validateHeader(this.getsHeaderCreatePromisedAction(), "Create Promised Action"))
		{
			if(this.clickRdoBtnTask())
			{
				// Owing to Stale element process we have to use try and catch 
				if(this.setDueTime())
				{
					if(this.selectDropDownTimeZone("Central", date[0]))
					{
						if(this.settxtbxDueDate(date[0]))
						{
							if(this.clickServiceRequestTypeEligibility())
							{
								if(this.clickServiceRequestTypeGA())
								{
									if(this.setTxtNotes("test"))
									{
										if(this.clickRdoBtnMyself())
										{
											if(this.clickgetBtnSubmit())
											{
												System.out.println("Pass : Create Promised Action Page is able to save the details. ");
												return true; 
											}
										}

									}
								}
							}
						}
					}

				}
			}

		}
		err.logError("Error in one of the fields with entering the value");
		// need to write a method to correct the error and resubmit the form
		return false;


	}

	@FindBy(xpath="//div[@id='DialogContent']")
	WebElement labelGuidedDialogtext;

	public boolean validateGuidedDialog(String[] args){
		String message=labelGuidedDialogtext.getText().replaceAll("\n", "");
		return utils.isvalueMatch_contain(message, args[0]);
	}

	/**This functionality verifies whether Myteam is disabled in promised action page
	 * 
	 * @return
	 */
	public boolean validateWhetherMyTeamisDisabled() {
		String value = rdBtnSchedulefrMyTeam.getAttribute("disabled");
		System.out.println(value);
		return utils.isvalueMatch_contain(value, "true");
	}
}


















