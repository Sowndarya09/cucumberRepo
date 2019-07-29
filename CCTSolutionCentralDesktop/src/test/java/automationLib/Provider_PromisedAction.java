package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class Provider_PromisedAction {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public Provider_PromisedAction()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}


	@FindBy(id="PACActivityTypeTask")
	WebElement RdBtnTypeTask;

	@FindBy(xpath="//input[@id='DueDate']")
	WebElement txtbxDueDate;

	@FindBy(xpath="//input[@id='DueTime']")
	WebElement txtbxDueTime;

	@FindBy(id="TimeZone")
	WebElement drpDownTimezone;


	@FindBy(id="Topic")
	WebElement contactdrpDownTopic;

	@FindBy(id="Notes")
	WebElement txtBoxNotes;

	@FindBy(id="PACScheduledForMy Team")
	WebElement rdBtnSchedulefrMyTeam;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Submit']")	
	WebElement btnSubmit;

	@FindBy (xpath="//span[text()='Eligibility']")	
	private WebElement serviceRequestType;


	/**Creates promised actions for Type task and submit
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean createPromisedActionforTypeTaskAndSubmit(String[] args) throws InterruptedException
	{
		if(utils.clickAnelemnt(RdBtnTypeTask, "Provider_PromisedAction", "RdBtnTypeTask"))
			if(utils.enterTextinAnelemnt(txtbxDueDate, args[0], "Create Promised Action ", "txtbxDueDate")) 
				Thread.sleep(5000);
				if(utils.enterTextinAnelemnt(txtbxDueTime, args[1], "Create Promised Action ", "txtbxDueDate"))
				//utils.waitforpageload();
					Thread.sleep(5000);
					if(utils.selectDropDownbyVisibleString(drpDownTimezone, args[2], "Promised action", "drpDownTimezone"))
						Thread.sleep(5000);
						if(utils.clickAnelemnt(serviceRequestType, "Provider_PromisedAction", "serviceRequestType"))
							Thread.sleep(3000);
							if(utils.enterTextinAnelemnt(txtBoxNotes, args[3], "Create Promised Action ", "txtBoxNotes"))
								Thread.sleep(2000);
								if(utils.clickAnelemnt(rdBtnSchedulefrMyTeam, "Provider_PromisedAction", "rdBtnSchedulefrMyTeam"))
									return utils.clickAnelemnt(btnSubmit, "Provider_PromisedAction", "btnSubmit");
		return false;			
	}

	@FindBy(xpath="//*[@data-test-id='20180212163147007222626']")
	WebElement ProviderName;

	@FindBy(id="StartDate")
	WebElement StartDate;

	@FindBy(id="StartTime")
	WebElement StartTime;

	@FindBy(id="EndTime")
	WebElement EndTime;

	@FindBy(xpath="//*[@class='content-item content-layout item-2   ']//*[@id='CommunicationChannel']")
	WebElement CommunicationChannel;

	@FindBy(id="Email")
	WebElement Email;

	/**Creates promised actions for Type Contact and submit
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean createPromisedActionforTypeContactWithEmailAndSubmit(String[] args) throws InterruptedException
	{ 
		Thread.sleep(1000);
		if(utils.enterTextinAnelemnt(StartDate, args[0], "Create Promised Action ", "StartDate"))
			if(utils.enterTextinAnelemnt(StartTime, args[1], "Create Promised Action ", "StartTime"))
				if(utils.enterTextinAnelemnt(EndTime, args[2], "Create Promised Action ", "EndTime"))
					if(utils.selectDropDownbyVisibleString(drpDownTimezone, "Eastern", "Promised action", "drpDownTimezone"))
						utils.waitForElementToBeVisible(CommunicationChannel);
						if(utils.selectDropDownbyVisibleString(CommunicationChannel, "Email", "Promised action", "CommunicationChannel"))
							if(utils.enterTextinAnelemnt(Email, args[3], "Create Promised Action ", "Email"))
							if(utils.clickAnelemnt(serviceRequestType, "Provider_PromisedAction", "serviceRequestType"))
								if(utils.enterTextinAnelemnt(txtBoxNotes, args[4], "Create Promised Action ", "txtBoxNotes"))
									if(utils.clickAnelemnt(rdBtnSchedulefrMyTeam, "Provider_PromisedAction", "rdBtnSchedulefrMyTeam"))
										return utils.clickAnelemnt(btnSubmit, "Provider_PromisedAction", "btnSubmit");
		return false;			
	}

	@FindBy(id="ReasonForPending")
	WebElement drpDownPending;
	
	public boolean verifyPendReasonOptions(String[] args)
	{
		
		ArrayList<String> drpDwn = new ArrayList<String>();
		
		for(String value:args)
		{
			drpDwn.add(value);
		}
		
		return utils.checkvaluesinDropDown(drpDownPending, drpDwn);
	}
	
	@FindBy(id="PACActivityTypeTask")
	WebElement radioBtnTask;
	
	
	public boolean clickTaskRadioButton()
	{
	return utils.clickAnelemnt(radioBtnTask, "Promised action", "Task button");
		
	}
	
	@FindBy(id="ContactType")
	WebElement elContact;
	
	public boolean selectContactType(String[] args)
	{
		return utils.selectDropDownbyVisibleString(elContact, args[0], "Promised action", "Contact type");
	}
	
	@FindBy(id="CommunicationChannel")
	WebElement ElCommType;
	
	public boolean verifyEmailCommunicationIsRemoved() {
		utils.clickAnelemnt(ElCommType, "Promised action", "Communication type");
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("Email");
		if(utils.checkvaluesinDropDown(ElCommType, ar))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@FindBy(id="PACScheduledForEscalated Callback")
	WebElement rdBtnSchedulefrEscalatedCallback;
	@FindBy(id="CallBackNumber")
	WebElement Phone;
	@FindBy(id="VoicemailNo")
	WebElement extensionrdbutton;
	
	public boolean createPromisedActionforTypeContactWithEmailEscalatedCallBackAndSubmit(String[] args) throws InterruptedException
	{ 
		Thread.sleep(1000);
		if(utils.enterTextinAnelemnt(StartDate, args[0], "Create Promised Action ", "StartDate"))
			if(utils.enterTextinAnelemnt(StartTime, args[1], "Create Promised Action ", "StartTime"))
				if(utils.enterTextinAnelemnt(EndTime, args[2], "Create Promised Action ", "EndTime"))
					if(utils.selectDropDownbyVisibleString(drpDownTimezone, "Eastern", "Promised action", "drpDownTimezone"))
						utils.waitForElementToBeVisible(CommunicationChannel);
						if(utils.selectDropDownbyVisibleString(CommunicationChannel, "Phone", "Promised action", "CommunicationChannel"))
							if(utils.enterTextinAnelemnt(Phone, args[5], "Create Promised Action ", "Phone"))
								if(utils.clickAnelemnt(extensionrdbutton, "Create Promised Action ", "extensionrdbutton"))
							if(utils.clickAnelemnt(serviceRequestType, "Provider_PromisedAction", "serviceRequestType"))
								if(utils.enterTextinAnelemnt(txtBoxNotes, args[6], "Create Promised Action ", "txtBoxNotes"))
									if(utils.clickAnelemnt(rdBtnSchedulefrEscalatedCallback, "Provider_PromisedAction", "rdBtnSchedulefrEscalatedCallback"))
										return utils.clickAnelemnt(btnSubmit, "Provider_PromisedAction", "btnSubmit");
		return false;			
	}
	
	@FindBy(id="PACScheduledForNon Escalated Callback")
	WebElement rdBtnSchedulefrNonEscalatedCallback;
	public boolean createPromisedActionforTypeContactWithEmailNonEscalatedCallBackAndSubmit(String[] args) throws InterruptedException
	{ 
		Thread.sleep(1000);
		if(utils.enterTextinAnelemnt(StartDate, args[0], "Create Promised Action ", "StartDate"))
			if(utils.enterTextinAnelemnt(StartTime, args[1], "Create Promised Action ", "StartTime"))
				if(utils.enterTextinAnelemnt(EndTime, args[2], "Create Promised Action ", "EndTime"))
					if(utils.selectDropDownbyVisibleString(drpDownTimezone, "Eastern", "Promised action", "drpDownTimezone"))
						utils.waitForElementToBeVisible(CommunicationChannel);
		if(utils.selectDropDownbyVisibleString(CommunicationChannel, "Phone", "Promised action", "CommunicationChannel"))
			if(utils.enterTextinAnelemnt(Phone, args[5], "Create Promised Action ", "Phone"))
				if(utils.clickAnelemnt(extensionrdbutton, "Create Promised Action ", "extensionrdbutton"))
							if(utils.clickAnelemnt(serviceRequestType, "Provider_PromisedAction", "serviceRequestType"))
								if(utils.enterTextinAnelemnt(txtBoxNotes, args[6], "Create Promised Action ", "txtBoxNotes"))
									if(utils.clickAnelemnt(rdBtnSchedulefrNonEscalatedCallback, "Provider_PromisedAction", "rdBtnSchedulefrEscalatedCallback"))
										return utils.clickAnelemnt(btnSubmit, "Provider_PromisedAction", "btnSubmit");
		return false;			
	}
	@FindBy(id="PACScheduledForMyself")
	WebElement rdBtnSchedulefrMySelf;

	public boolean createPromisedActionforTypeTaskMyselfAndSubmit(String[] args) throws InterruptedException
	{
		if(utils.clickAnelemnt(RdBtnTypeTask, "Provider_PromisedAction", "RdBtnTypeTask"))
			if(utils.enterTextinAnelemnt(txtbxDueDate, args[0], "Create Promised Action ", "txtbxDueDate")) 
				Thread.sleep(5000);
				if(utils.enterTextinAnelemnt(txtbxDueTime, args[1], "Create Promised Action ", "txtbxDueDate"))
				//utils.waitforpageload();
					Thread.sleep(5000);
					if(utils.selectDropDownbyVisibleString(drpDownTimezone, args[2], "Promised action", "drpDownTimezone"))
						Thread.sleep(5000);
						if(utils.clickAnelemnt(serviceRequestType, "Provider_PromisedAction", "serviceRequestType"))
							Thread.sleep(3000);
							if(utils.enterTextinAnelemnt(txtBoxNotes, args[3], "Create Promised Action ", "txtBoxNotes"))
								Thread.sleep(2000);
								if(utils.clickAnelemnt(rdBtnSchedulefrMySelf, "Provider_PromisedAction", "rdBtnSchedulefrMyTeam"))
									return utils.clickAnelemnt(btnSubmit, "Provider_PromisedAction", "btnSubmit");
		return false;			
	}

}

