package automationLib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import utils.SeleniumUtilities;

/**
 * Check the Pgae with the values from the Page Promised action
 * @author Shardul Negi
 *
 */
public class PromisedActionVerify extends Driver{


	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	public PromisedActionVerify()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}



	// storing the value in an array for the value 
	@FindBy(xpath="//*[contains(@class,'content-item content-layout item-1 remove-bottom-spacing   ')]//*[@class='field-item dataValueRead']")
	WebElement labelServiceRequestType;
	//content-item content-layout item-2 remove-bottom-spacing   
	@FindBy(xpath="//*[contains(@class,'content-item content-layout item-2 remove-bottom-spacing   ')]//*[@class='field-item dataValueRead']")
	WebElement labelCreatedBy;
	//content-item content-layout item-4 remove-bottom-spacing   

	@FindBy(xpath="//*[contains(@class,'content-item content-layout item-4 remove-bottom-spacing   ')]//*[@class='field-item dataValueRead']")
	WebElement labelGoalDate;


	//*[contains(@class,'layout layout-noheader layout-noheader-default set-width-auto')]//*[@class='field-item dataValueRead']
	@FindBy(xpath="//*[contains(@class,'layout layout-noheader layout-noheader-default set-width-auto')]//*[@class='field-item dataValueRead']")
	WebElement dataONPageServiceRequestDetails;

	//*[contains(@class,'header-element header-title')][contains(text(),'Previous')]"
	@FindBy(xpath="//*[contains(@class,'header-element header-title')][contains(text(),'Previous')]")
	WebElement headerPreviousNotes;



	@FindBy(xpath="//*[contains(@class,'content-item content-layout item-1 remove-bottom-spacing   ')]//*[@class='field-caption dataLabelForRead']")
	WebElement headersServiceRequestStatus;
	/**
	 * First box in the list which checks the value for 
	 * Service Request Type
	 * Status
	 * 
	 * @param args
	 * @return
	 */
	public boolean checkValue_box_1_ServiceRequest_Status(String[] args)
	{

		// Taqke values from that 
		List<WebElement> allRows = Driver.pgDriver.findElements((By) labelServiceRequestType);
		List<WebElement> allHeaders = Driver.pgDriver.findElements((By) headersServiceRequestStatus);
		int num=0;
		// Looping with all the headers and checking all the values respectively 
		for(WebElement headersno : allHeaders)
		{
			//checking the header with entry
			if(headersno.toString().trim().equalsIgnoreCase(args[num].split(":")[0].trim()))
			{
				// Check the values from the list from the input value  
				for (WebElement row : allRows) {
					if(row.toString().trim().equalsIgnoreCase(args[num].split(":")[1]))
					{
						num++;
					}

				}
			}
		}

		if(num==args.length)
		{
			return true;
		}
		//List<> nValue= new Lis<>;
		return false;
	}



	/**
	 * 2nd Box in the page with values to check 
	 * Created By 
	 * Created on with Time 
	 * @param args
	 * @return
	 */

	public boolean checkValue_box_2(String[] args)
	{

		// Taqke values from that 
		List<WebElement> allRows = Driver.pgDriver.findElements((By) labelCreatedBy);
		int num=0;
		// Check the values from teh list 
		for (WebElement row : allRows) {

			if(row.toString().trim().equalsIgnoreCase(args[num].split(":")[1]))
			{
				num++;
			}
		}

		if(num==3)
		{
			return true;
		}
		//List<> nValue= new Lis<>;
		return false;
	}



	/**
	 * Leaving box 3 as resolved will always be empty 
	 * 
	 * @return
	 */

	//Depending on urgency the date will be diffrent  
	/**
	 * Here the data is generated automatically
	 * @return
	 */
	public boolean checkValue_box_4(String[] args)
	{

		// Taqke values from that 
		List<WebElement> allRows = Driver.pgDriver.findElements((By) labelServiceRequestType);
		int num=0;
		// Check the values from teh list 
		for (WebElement row : allRows) {

			if(row.toString().trim().length()>0)
			{
				num++;
			}
		}

		if(num==args.length)
		{
			return true;
		}
		return false;
	}


	@FindBy(xpath="//*[contains(@class,'layout layout-noheader layout-noheader-default set-width-auto')]//*[@class='field-caption dataLabelForRead']")
	WebElement headingsServiceRequest;

	//Service Request Details 
	/**
	 * Will check the values appearing in the page and will verify the values
	 * @param args
	 * @return
	 */
	public boolean check_dataONPageServiceRequestDetails(String[] args)
	{
		// Taqke values from that 
		List<WebElement> allRows = Driver.pgDriver.findElements((By) dataONPageServiceRequestDetails);
		List<WebElement> allHeaders = Driver.pgDriver.findElements((By) headingsServiceRequest);
		int num=0;
		for(WebElement headersno : allHeaders)
		{
			//checking the header 
			if(headersno.toString().trim().equalsIgnoreCase(args[num].split(":")[0].trim()))
			{
				// Complementing the same with the same div under that and checking teh value 
				for (WebElement row : allRows) {
					if(row.toString().trim().equalsIgnoreCase(args[num].split(":")[1].trim()))
					{
						num++;
						break;
					}
				}
			}
		}
		//checking if the number of inputs is equal to headers it navigate to 
		if(num==args.length)
		{
			return true;
		}
		//List<> nValue= new Lis<>;
		return false;
	}

	SeleniumUtilities utils= new SeleniumUtilities();

	public boolean clickgetBtnSubmit()
	{
		return utils.clickAnelemnt(this.headerPreviousNotes, "Create Promised Action ", "Radio Buttoon  Verify Associate");
	}




	//====================================================================Main Methods to be used in the Page =====================================================
	/*
	 * Main Methods to be used in the page for checking the value of various methods in the page 
	 */

	@FindBy(xpath="//*[@node_name='PAResolveContact']//label[@for='CommunicationChannel']/parent::div//span")
	WebElement labelCommunicationType;

	@FindBy(xpath="//label[@for='CallBackNumber']/parent::div//span")
	WebElement labelPhoneEmailNumber;
	//*[@node_name='PAResolveContact']//*[contains(@class,'item-5')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-4')]//*[contains(@class,'ValueRead')]/span
	
	@FindBy(xpath="//label[@for='Email']/parent::div//span")
	WebElement labelEmail;
	
	
	@FindBy(xpath="//*[@node_name='PAResolveContact']//label[@for='CommunicationChannel']/parent::div//span")
	WebElement labelEmailNumber;
	@FindBy(xpath="//*[@node_name='PAResolveContact']//label[@for='FaxNumber']/parent::div//span")
	WebElement labelFax;
	//@FindBy(xpath="//*[@node_name='PAResolveContact']//label[@for='Topic']/parent::div//span")
	@FindBy(xpath="//span[text()='Eligibility']")
	WebElement labelContactTopic;
	
	//*[@node_name='PAResolveContact']//*[contains(@class,'item-5')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-5')]//*[contains(@class,'ValueRead')]/span
	@FindBy(xpath="//*[@node_name='PAResolveContact']//label[@for='PACScheduledFor']/parent::div/div")
	WebElement labelContactSchedulefor;

	@FindBy(xpath="//*[@node_name='PAResolveTask']//label[@for='PACScheduledFor']/parent::div/div")
	WebElement labelContactScheduleforRT;
	//*[text()='My Team']
	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	WebElement sHeaderPromisedActionPage;
	@FindBy(xpath="//*[@id='Notes']")
	WebElement txtbxNotes;
	@FindBy(xpath="//*[text()='My Team']")
	WebElement labelMyTeam;
	
	
	@FindBy(xpath="//label[@for='PACScheduledFor']/parent::div/div")
	WebElement labelMySelf;
	@FindBy(xpath="//*[contains(@node_name,'PACTypeTask')]//label[@for='DueDate']/parent::div//div//span")
	WebElement labelDueDate;
	@FindBy(xpath="//*[contains(@node_name,'PACTypeTask')]//label[@for='DueTime']/parent::div//div//span")
	WebElement labelDueTime;
	@FindBy(xpath="//*[contains(@node_name,'PACTypeTask')]//label[@for='TimeZone']/parent::div//div//span")
	WebElement labelTimeZone;
	//*[contains(@node_name,'PACTypeTask')]//*[contains(@class,'item-3')][@string_type='layout']//*[contains(@class,'ValueRead')]/span
	@FindBy(xpath="//*[contains(@node_name,'PACTypeTask')]//*[contains(@class,'item-3')][@string_type='layout']//*[contains(@class,'ValueRead')]/span")
	WebElement labelTopic;
	@FindBy(xpath="//select[contains(@id,'Resolution')]")
	WebElement dropDownResolution;
	@FindBy(xpath="//Select[contains(@id,'Resolution')]//option[@selected='']")
	private WebElement dropDownViewResolutionSelected;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	//*[@class='pzbtn-mid'][text()='Submit']
	/**
	 * Select Dropdown 
	 * @param visibletext
	 * @param date
	 * @return
	 */
	public boolean selectdropDownViewForQueue(String visibletext) 
	{
		if(utils.selectDropDownbyVisibleString(this.dropDownResolution, visibletext, "Home Page", "View for Queue"))
		{
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
		//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+date+"')]")));
		return (!utils.isProxyWebelement(this.dropDownViewResolutionSelected));
		}
		return false;
	}


	public boolean setTxtNotes(String sNotes)
	{
		return utils.enterTextinAnelemnt(this.txtbxNotes, sNotes, "Promised Action", "Text Box Notes");
	}

	public boolean clickBtnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "Promised Action ", "Button Submit");
	}



	/*
	 * Methods to be used in the sheet 
	 */


	/**
	 * Selecting the Drop down Value from the View for Queue DropDown Box
	 * Enter the Due Date which was entered in the Last step 
	 * @return
	 */
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectCompletedRTcheckDueDateTimeZone
	 * #Description: This functionality validates the header of the task and then selects the drop down value in the queue given by the user and then validates the time zone
	 * #Arguments:StartDate
	 * Type:TextBox
	 */	
	public boolean selectCompletedRTcheckDueDateTimeZone()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.selectdropDownViewForQueue("Completed"))
					if(utils.validateHeader(this.labelTimeZone, "Central")) // For Central which has been given as default in the script 
						return true;
		return false;
	}
	
	
	/**
	 * Select the Value
	 * @param args
	 * @return
	 */
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectCreatedinErrorRTcheckDueDateTimeZone
	 * #Description: This functionality validates the header and then selected the drop down option for queue from the user. 
	 * Type:TextBox
	 */	
	public boolean selectCreatedinErrorRTcheckDueDateTimeZone()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.selectdropDownViewForQueue("Created in error"))
						return true;
		return false;
	}



	@FindBy(id="DueDate")    // USING JAVA EXECUTOR for SETTING VALUE in RESCHEDULE SCENARIO
	private WebElement txtbxDueDate;
	@FindBy(id="DueTime")   // USING JAVA EXECUTOR for SETTING VALUE in RESCHEDULE SCENARIO
	private WebElement txtbxDueTime;

	public boolean settxtbxDueTime(String sFullName) throws InterruptedException
	{
		try
		{
			return utils.enterTextinAnelemnt(this.txtbxDueTime, sFullName, "Create Promised Action ", "Text Box Full  Name");
		}
		catch(StaleElementReferenceException e)
		{

			return settxtbxDueTime(sFullName);
			//System.out.println("Stale Error"+ e);
		}
		catch(NoSuchElementException e){
			//System.out.println(e);
			return settxtbxDueTime(sFullName);	
		}
	}

	
	
	public boolean settxtbxDueDate(String sFullName) throws InterruptedException
	{
		try
		{
			return utils.enterTextinAnelemnt(this.txtbxDueDate, sFullName, "Create Promised Action ", "Text Box Full  Name");
		}
		catch(StaleElementReferenceException e)
		{
			return settxtbxDueDate(sFullName);
		}
		catch(NoSuchElementException e){
			return settxtbxDueDate(sFullName);	
		}
		catch(ElementNotVisibleException e)
		{
			Thread.sleep(5000);
			return settxtbxDueDate(sFullName);
		}
	}
	
	
	public boolean settxtbxDueDatenew(String sFullName) throws InterruptedException
	{
			return utils.setAttribute(this.txtbxDueDate,"value",sFullName);
	}

	public boolean settxtbxDueTimenew(String sFullName) throws InterruptedException
	{
			return utils.setAttribute(this.txtbxDueTime,"value",sFullName);

	}
	
	/**
	 * Enter the new details with the Due Date as the entry
	 * @param args : Data to be given as the Date in the format Due Date : something 
	 * @return
	 * @throws InterruptedException
	 */
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectRescheduleRT
	 * #Description: This functionality validates the header of the the page and then selects the drop down option given by the user 
	 * #Arguments:StartDate
	 * Type:TextBox
	 */	
	public boolean selectRescheduleRT() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.selectdropDownViewForQueue("Reschedule"))
						return true;
		return false;
	}


	//*[contains(@node_name,'PACTypeTask')]//*[contains(@class,'item-3')]//*[text()='Outreach']
	@FindBy(xpath="//*[contains(@node_name,'PACTypeTask')]//*[contains(@class,'item-3')]//*[text()='Outreach']")
	private WebElement labelOutreach;
	@FindBy(xpath="//span[text()='Eligibility']")
	private WebElement labelResearch;
	@FindBy(xpath="//*[contains(@node_name,'PACTypeTask')]//*[contains(@class,'item-3')]//*[text()='Other']")
	private WebElement labelOther;
	@FindBy(xpath="//*[contains(@node_name,'PACTypeTask')]//label[@for='TaskTopic']/parent::div//div//span")
	private WebElement labelInternalcontact;
	/**
	 * Checking the details in the Page Promised Actions with the headers and Labels from the Paqge 
	 * @param args[] : enter the Due Date which was earlier entered in My Team
	 * @return
	 */
	public boolean submitRTPromisedActionMyTeamTaskOutReach()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelOutreach, "Outreach"))
					if(utils.validateHeader(this.labelMyTeam, "My Team")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:submitRTPromisedActionTeamTaskResearch
	 * #Description: This functionality validates that the header of the task and then enter the notes and then validates the header of the assignee and then clicks submit.
	 * Type:TextBox
	 */	
	public boolean submitRTPromisedActionTeamTaskResearch()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelResearch, "Eligibility"))
					if(utils.validateHeader(this.labelMyTeam, "My Team")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	public boolean submitRTPromisedActionTeamTaskInternalContact()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelInternalcontact, "Internal Contact"))
					if(utils.validateHeader(this.labelMyTeam, "My Team")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	public boolean submitRTPromisedActionTeamTaskOther()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelOther, "Other"))
					if(utils.validateHeader(this.labelMyTeam, "My Team")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	//============================================== For Myself now ================================================


	public boolean submitRTPromisedActionMyselfTaskOutReach()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelOutreach, "Outreach"))
					if(utils.validateHeader(this.labelMySelf, "Eligibility")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:submitRTPromisedActioMyselfTaskResearch
	 * #Description: This functionality validates the header of the task, enter the notes and then validate the header Eligibility and Myself and then clicks submit.
	 * #Arguments:StartDate
	 * Type:TextBox
	 */	
	
	public boolean submitRTPromisedActioMyselfTaskResearch()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelResearch, "Eligibility"))
					if(utils.validateHeader(this.labelMySelf, "Myself")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	public boolean submitRTPromisedActionMyselfTaskInternalContact()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelInternalcontact, "Internal Contact"))
					if(utils.validateHeader(this.labelMySelf, "Myself")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:submitRTPromisedActionMyselfTaskOther
	 * #Description: This functionality validates the header and enter the notes and then validates the header of the Other and the Myself label 
	 * #Arguments:StartDate
	 * Type:TextBox
	 */	

	public boolean submitRTPromisedActionMyselfTaskOther()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelContactTopic, "Eligibility"))
					if(utils.validateHeader(this.labelMySelf, "Myself")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	//=================================================================================contact Page Second flow of the same ===================================================



	/*
	 * Checking Value from the ID and the page that it lands to 
	 */

	@FindBy(xpath="//select[contains(@id,'ContactList')]")
	WebElement dropDownWhereYouReach;
	@FindBy(xpath="//Select[contains(@id,'ContactList')]//option[@selected='']")
	private WebElement dropDownWhereYouReachSelected;


	//*[@class='pzbtn-mid'][text()='Submit']
	/**
	 * Select Dropdown 
	 * @param visibletext
	 * @param date
	 * @return
	 */
	public boolean selectdropDownWhereYouReach(String visibletext) 
	{
		utils.selectDropDownbyVisibleString(this.dropDownWhereYouReach, visibletext, "Home Page", "Where You Reached");
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
		//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+date+"')]")));
		return (!utils.isProxyWebelement(this.dropDownWhereYouReachSelected));

	}

	@FindBy(xpath="//select[contains(@id,'ContinueValidationReasons')]")
	WebElement dropDownContinueValidationReasons;
	@FindBy(xpath="//Select[contains(@id,'ContinueValidationReasons')]//option[@selected='']")
	private WebElement dropDownContinueValidationReasonsSelected;


	//*[@class='pzbtn-mid'][text()='Submit']
	/**
	 * Select Dropdown 
	 * @param visibletext
	 * @param date
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectdropContinueValidationReasons(String visibletext) throws InterruptedException 
	{
		Thread.sleep(3000);
		return utils.selectDropDownbyVisibleString(this.dropDownContinueValidationReasons, visibletext, "Home Page", "Where You Reached");


	}
	@FindBy(xpath="//select[contains(@id,'ResolutionOutcome')]")
	WebElement dropDownOutcomeofContact;
	@FindBy(xpath="//Select[contains(@id,'ResolutionOutcome')]//option[@selected='']")
	private WebElement dropDownOutcomeofContactSelected;


	//*[@class='pzbtn-mid'][text()='Submit']
	/**
	 * Select Dropdown 
	 * @param visibletext
	 * @param date
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectdropDownOutcomeofContact(String visibletext) throws InterruptedException 
	{
		Thread.sleep(5000);
		if(utils.selectDropDownbyVisibleString(this.dropDownOutcomeofContact, visibletext, "Home Page", "Out come of Contact "))
			return !utils.isProxyWebelement(this.dropDownOutcomeofContactSelected);
		return false;

	}



	//sHeaderPromisedActionPage

	public boolean submitResolveContactPromisedActionMyTeamTaskOther()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelOther, "Other"))
					if(utils.validateHeader(this.labelMyTeam, "My Team")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	public boolean submitResolveContactPromisedActionMySelfTaskOther()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
				if(utils.validateHeader(this.labelOther, "Other"))
					if(utils.validateHeader(this.labelMySelf, "Myself")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}

	// Selecting Various Where did you reach 


	@FindBy(xpath="//input[contains(@id,'HealthPlanClient')]")
	WebElement chkbxVerifyHealthPlanIsEitherClientorHealthBenefit;
	//input[contains(@id,'ContinueValidation')]

	public boolean clickchkbxVerifyHealthPlanIsEitherClientorHealthBenefit()
	{
		return utils.clickAnelemnt(this.chkbxVerifyHealthPlanIsEitherClientorHealthBenefit, "Promised Action ", "Check Box");
	}
	
	@FindBy(xpath="//input[contains(@id,'ContinueValidation')]")
	WebElement chkbxVerifyContinueWithoutVerification;
	//input[contains(@id,'ContinueValidation')]

	public boolean clickchkbxVerifyContinueWithoutVerification()
	{
		return utils.clickAnelemnt(this.chkbxVerifyContinueWithoutVerification, "Promised Action ", "Check Box");
	}

	/**
	 * Select the Drop down Who did you Reach and Select the respective changes in the screen 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectBenefitCentreVerify() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
		{
			WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'HealthPlanClient')]")));
			if(this.selectdropDownWhereYouReach("Benefit Center"))
					if(this.clickchkbxVerifyHealthPlanIsEitherClientorHealthBenefit())
						return true;
		}
		return false;
	}
	
	public boolean selectBenefitCentreContinueWithoutVerify()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
		{
			WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'HealthPlanClient')]")));
			if(this.selectdropDownWhereYouReach("Benefit Center"))
				if(this.clickchkbxVerifyContinueWithoutVerification())
					return true;
		}
		return false;
	}



	/**
	 * Selecting Member Voicemail from the Dropdown and moving ahead with the execution
	 * @return
	 */
	public boolean selectMemberVoiceMail()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("Member-Voicemail"))
				return true;
		return false;
	}


	//input[contains(@id,'ContinueValidation')]

	@FindBy(xpath="//input[contains(@id,'IsAnyActiveRecordPresentNo')]")
	WebElement rdbtnActiveRecordsPresentNo;
	public boolean clickrdbtnActiveRecordsPresentNo()
	{
			return utils.clickAnelemnt(this.rdbtnActiveRecordsPresentNo, "Promised Action ", "Radio Button No");
	}
	
	@FindBy(xpath="//input[contains(@id,'IsDateOfBirthVerified')]")
	WebElement chckbxIsDateOfBirthVerified;
	public boolean clickrchckbxIsDateOfBirthVerified()
	{
		return utils.clickAnelemnt(this.chckbxIsDateOfBirthVerified, "Promised Action ", "DOB");
	}
	
	@FindBy(xpath="//input[contains(@id,'IsMemberIDVerified')]")
	WebElement chkbxIsMemberIDVerified;
	public boolean clickchkbxIsMemberIDVerified()
	{
		return utils.clickAnelemnt(this.chkbxIsMemberIDVerified, "Promised Action ", "ID verify");
	}
	
	@FindBy(xpath="//input[contains(@id,'ContinueValidation')]")
	WebElement chkbxContinueValidation;
	public boolean clickchkbxContinueValidation()
	{
		return utils.clickAnelemnt(this.chkbxContinueValidation, "Promised Action ", "Continue Validation");
	}

	/**
	 * Method for Member Verifying DOB
	 * @return
	 */

	public boolean selectMemberNumberVerifyIDDOB()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("Member"))
				if(this.clickrdbtnActiveRecordsPresentNo())
				if(this.clickrchckbxIsDateOfBirthVerified())
					if(this.clickchkbxIsMemberIDVerified())
						return true;
		return false;
	}
	
	public boolean selectMemberContinuewithoutVerify() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("Member"))
				if(this.clickrdbtnActiveRecordsPresentNo())
				if(this.clickchkbxContinueValidation())
					if(this.selectdropContinueValidationReasons("Same Day Contact"))
						return true;
		return false;
	}
	
	@FindBy(xpath="//input[contains(@id,'PersonalRep')]")
	WebElement txtbxPersonalRepresentaiveName;


	public boolean settxtbxPersonalRepresentaiveName(String sFullName) throws InterruptedException
	{
		try
		{
			Thread.sleep(3000);
			return utils.enterTextinAnelemnt(this.txtbxPersonalRepresentaiveName, sFullName, " Promised Action ", "Text Box Full  Name");
		}
		catch(StaleElementReferenceException e)
		{

			this.settxtbxDueTime(sFullName);
			System.out.println("Stale Error"+ e);
		}
		catch(NoSuchElementException e){
			System.out.println(e);
			this.settxtbxDueTime(sFullName);	
		}
		return true;
	}


	/**
	 * Member Representative DropDown from Resolve Contact 
	 * @return
	 * @throws InterruptedException 
	 */
	//input[contains(@id,'PersonalRep')]
	public boolean selectMemberRepresentativeVerifyIdDOB() throws InterruptedException
	{
		System.out.println("Start : Verify from  Member and check in Continue checking on DOB and ID check box");
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("Member's Representative"))
				if(this.settxtbxPersonalRepresentaiveName("Lee Child"))
				if(this.clickrdbtnActiveRecordsPresentNo())
					if(this.clickrchckbxIsDateOfBirthVerified())
						if(this.clickchkbxIsMemberIDVerified())
							return true;
		return false;
	}
	
	public boolean selectMemberRepresentativeContinuewithoutVerify() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("Member's Representative"))
			if(this.settxtbxPersonalRepresentaiveName("Lee Child"))
				if(this.clickrdbtnActiveRecordsPresentNo())
					if(this.clickchkbxContinueValidation())
						if(this.selectdropContinueValidationReasons("Same Day Contact"))
							return true;
		return false;
	}


	/**
	 * Provider 
	 */
	//input[contains(@id,'MemberRelatedToProvider')]
	@FindBy(xpath="//input[contains(@id,'PhysicianListedRecord')]")
	WebElement chkbxPhysicianListedRecord;


	public boolean clickchkbxPhysicianListedRecord()
	{
		return utils.clickAnelemnt(this.chkbxPhysicianListedRecord, "Promised Action ", "check box");
	}
	
	@FindBy(xpath="//input[contains(@id,'MemberRelatedToProvider')]")
	WebElement chkbxMemberRelatedToProvider;
	public boolean clickchkbxMemberRelatedToProvider()
	{
		return utils.clickAnelemnt(this.chkbxMemberRelatedToProvider, "Promised Action ", "check box");
	}

	/**
	 * Select Provider from DropDown and Click on check boxes for Physician Record and Related to Provider 
	 * @return
	 * @throws InterruptedException
	 */
	
	public boolean selectProviderVerifyPhysicianorMember() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("Provider"))
				if(this.clickchkbxPhysicianListedRecord())
					if(this.clickchkbxMemberRelatedToProvider())
						return true;
		return false;
	}

	public boolean selectProviderContinueWithoutVerify() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("Provider"))
				if(this.clickchkbxContinueValidation())
					if(this.selectdropContinueValidationReasons("Same Day Contact"))
						return true;
		return false;
	}




	/*
	 * Provider Voicemail
	 */

	/**
	 * Selecting Provider Voicemail from the Dropdown and moving ahead with the execution
	 * @return
	 */
	public boolean selectPrioviderVoiceMail()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("Provider Voicemail"))
				return true;
		return false;
	}


	/*
	 * No Answer 
	 */

	//input[contains(@id,'ContactResolvedYes')]
	//input[contains(@id,'ContactResolvedNo')]
	@FindBy(xpath="//input[contains(@id,'ContactResolvedYes')]")
	WebElement rdbtnContactResolvedYes;
	public boolean clickrdbtnContactResolvedYes()
	{
		return utils.clickAnelemnt(this.rdbtnContactResolvedYes, "Promised Action ", "radio button");
	}
	
	@FindBy(xpath="//input[contains(@id,'ContactResolvedNo')]")
	WebElement rdbtnContactResolvedNor;
	public boolean clickrdbtnContactResolvedNor()
	{
		return utils.clickAnelemnt(this.rdbtnContactResolvedNor, "Promised Action ", "radio button");
	}

	/**
	 * SElect Drop down No answer and Click on Yes
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectNoAnswerYes(String[] args) throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("No Answer"))
				if(this.clickrdbtnContactResolvedYes())
					Thread.sleep(3000);
					if(utils.validateLabel(this.labelStartDateNoAnswer, args[0]))
						if(utils.validateLabel(this.labelNoanswerCommunicationTypePhone, "Phone"))
							if(utils.validateLabel(this.labelNoAnsswerTopic, "Eligibility"))
								if(this.setTxtNotes("HElp!!  "))
									if(this.clickBtnSubmit())
										return true;
		return false;
	}

	@FindBy(xpath="//*[@node_name='PAResolveContact']//*[contains(@class,'item-6')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-1')]//*[contains(@class,'ValueRead')]/span")
	WebElement labelNoAnsswerTopic;
	@FindBy(xpath="//*[@node_name='PAResolveContact']//*[contains(@class,'item-1')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-1')]//*[contains(@class,'ValueRead')]/span")
	WebElement labelStartDateNoAnswer;
	//*[@node_name='PAResolveContact']//*[contains(@class,'item-4')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-1')]//*[contains(@class,'ValueRead')]/span
	@FindBy(xpath="//*[@node_name='PAResolveContact']//*[contains(@class,'item-4')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-1')]//*[contains(@class,'ValueRead')]/span")
	WebElement labelNoanswerCommunicationTypePhone;

	public boolean selectNoAnswerNo()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownWhereYouReach("No Answer"))
				if(this.clickrdbtnContactResolvedNor())
					return true;
		return false;
	}



	// ============================================================== ANother Part of the



	//selectdropDownOutcomeofContact


	@FindBy(xpath="//*[@node_name='PAResolveContact']//*[contains(@class,'item-2')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-1')]//*[contains(@class,'ValueRead')]/span")
	WebElement labelStartDate;
	@FindBy(xpath="//*[@node_name='PAResolveContact']//*[contains(@class,'item-3')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-3')]//*[contains(@class,'ValueRead')]/span")
	WebElement labelResolveContactTimeZone;
	/**
	 * Enter Start Date for the same for Reached contact - Completed  
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate localDate = LocalDate.now().plusDays(1); 
	String Tdate=dtf.format(localDate );
	public boolean selectReachedContactCompleted() throws InterruptedException
	{
		if(this.selectdropDownOutcomeofContact("Reached Contact-Completed"))
		utils.waitforpageload();
			if(utils.validateLabel(this.labelStartDate, Tdate))
					return true;	
		return false;
	}

	public boolean selectLeftMessageCompleted(String[] args) throws InterruptedException
	{
		if(this.selectdropDownOutcomeofContact("Left Message-Completed"))
			if(utils.validateLabel(this.labelStartDate, args[0].split(":")[1]))
					return true;	
		return false;
	}

	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectEmailSuccessful
	 * #Description: This functionality validates the header of the task and then selects the drop down value given by the user. 
	 * Type:TextBox
	 */	
	public boolean selectEmailSuccessful() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownOutcomeofContact("Email Successful"))
						return true;	
		return false;
	}
	
	
	public boolean selectEmailFailure(String[] args) throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownOutcomeofContact("Email Failure"))
				if(utils.validateLabel(this.labelStartDate, args[0].split(":")[1]))
						return true;	
		return false;
	}


	// Fax from the drop down 

	public boolean selectFaxSuccessful(String[] args) throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownOutcomeofContact("Fax Failure"))
				if(utils.validateLabel(this.labelStartDate, args[0].split(":")[1]))
						return true;	
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectFaxFailure
	 * #Description: This functionality creates the promised action by validating the header and gets the start date as input from the user, sets the start time and end time, selects the time zone and then selects the eligibility criteria and then selects the myself radio button and then enter notes and then clicks the submit button. 
	 * #Arguments:StartDate
	 * Type:TextBox
	 */	
	public boolean selectFaxFailure() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownOutcomeofContact("Fax Failure"))
						return true;	
		return false;
	}




	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectMailSent
	 * #Description: This functionality validates the header and selects the drop down contact option given by the user.
	 * Type:TextBox
	 */	
	
	public boolean selectMailSent() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownOutcomeofContact("Mail sent"))
						return true;
		return false;
	}
	
	//*[@node_name='PAResolveContact']//*[contains(@class,'item-5')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-1')]//*[contains(@class,'ValueRead')]/span
	//*[@node_name='PAResolveContact']//*[contains(@class,'item-5')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-2')]//*[contains(@class,'ValueRead')]/span
	//*[@node_name='PAResolveContact']//*[contains(@class,'item-7')][contains(@string_type,'layout')]//*[contains(@class,'triple')]//*[contains(@class,'item-1')]//*[contains(@class,'ValueRead')]/span
	//*[@node_name='PAResolveContact']//*[contains(@class,'item-8')][contains(@string_type,'layout')]//*[contains(@class,'ValueRead')]


	/**
	 * Check the value of Email for all Four combinations 
	 * @return
	 */
	
	public boolean submitRCComnEmailTEligibilityMyself()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Email"))
			if(utils.validateHeader(this.labelEmailNumber, "test@test.com"))	
				if(utils.validateLabel(this.labelContactSchedulefor, "Myself"))
					if(utils.validateLabel(this.labelContactTopic, "Eligibility"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}
	
	public boolean submitRCValuecheckComnEmaillMyself()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Email"))
			if(utils.validateHeader(this.labelPhoneEmailNumber, "test@test.com"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "Myself"))
					if(utils.validateHeader(this.labelContactTopic, "Eligibility"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}


	
	
	
	// Main methods 
	
	
	public boolean submitRCValuecheckComnEmailEligibilityTeam()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Email"))
			if(utils.validateHeader(this.labelEmail, "test@test.com"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "My Team"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}
	
	
	public boolean submitValuecheckEmailTopicMyTeam()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Email"))
			if(utils.validateHeader(this.labelEmail, "test@test.com"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "My Team"))
					if(utils.validateHeader(this.labelContactTopic, "Promised Action"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}

	/**Using Phone from the Selecting body 
	 * 
	 * @return
	 */
	public boolean submitRCPhoneTopicEligibilityMyself()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Phone"))
			if(utils.validateHeader(this.labelPhoneEmailNumber, "(123) 456-7890"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "Myself"))
					if(utils.validateHeader(this.labelContactTopic, "Eligibility"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: submitValuecheckPhoneEligibilityMyself
	 * #Description: This functionality validates the header of the Communication channel, address of the channel, and the task assigned.
	 * Type: Textbox
	 */
	public boolean submitValuecheckPhoneEligibilityMyself()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Phone"))
			if(utils.validateHeader(this.labelPhoneEmailNumber, "(123) 456-7890"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "Myself"))
					if(utils.validateHeader(this.labelContactTopic, "Eligibility"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}


	public boolean submitValuecheckPhoneEligibilityMyTeam()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Phone"))
			if(utils.validateHeader(this.labelPhoneEmailNumber, "(123) 456-7890"))		
				if(utils.validateHeader(this.labelContactSchedulefor, "My Team"))
					if(utils.validateHeader(this.labelContactTopic, "Eligibility"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}
	
	public boolean submitValuecheckFaxTopicMyTeam()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Phone"))
			if(utils.validateHeader(this.labelPhoneEmailNumber, "(123) 456-7890"))		
				if(utils.validateHeader(this.labelContactSchedulefor, "My Team"))
					if(utils.validateHeader(this.labelContactTopic, "Promised Action"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}





	/**
	 * 
	 * Checking the Value from Fax with the value
	 * @return
	 */

	@FindBy(xpath="//label[@for='FaxNumber']/parent::div//span")
	WebElement labelFaxNumber;
	//(123) 456-7890
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:submitRCFaxTopicEligibilityMyself
	 * #Description: This functionality validates the header of the task, phone and the task assigned and enter the notes and then click submit. 
	 * Type:TextBox
	 */	
	public boolean submitRCFaxTopicEligibilityMyself()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Fax"))
			if(utils.validateHeader(this.labelFaxNumber, "(123) 456-7890"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "Myself"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}
	
	
	public boolean submitValuecheckFaxTopicMyself()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Fax"))
			if(utils.validateHeader(this.labelPhoneEmailNumber, "(123) 456-7890"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "Myself"))
					if(utils.validateHeader(this.labelContactTopic, "Promised Action"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}


	
	public boolean submitRCFaxTopicEligibilityTeam()
	{

		if(utils.validateHeader(this.labelCommunicationType, "Fax"))
			if(utils.validateHeader(this.labelPhoneEmailNumber, "(123) 456-7890"))		
				if(utils.validateHeader(this.labelContactSchedulefor, "My Team"))
					if(utils.validateHeader(this.labelContactTopic, "Eligibility"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}




	// Mail 

	public boolean submitRCMailTopicEligibilityMyself()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Mail"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "Myself"))
					if(utils.validateHeader(this.labelContactTopic, "Eligibility"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:submitValuecheckMailTopicMyTeam
	 * #Description: This functionality validates the header of the Email and the task assigned and enter the notes and then click submit. 
	 * Type:TextBox
	 */	

	public boolean submitValuecheckMailTopicMyTeam()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Mail"))
				if(utils.validateHeader(this.labelContactSchedulefor, "My Team"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}

	public boolean submitRCFaxTopicEligibilityMyTeam()
	{
		if(utils.validateHeader(this.labelCommunicationType, "Fax"))
			if(utils.validateHeader(this.labelFax, "(123) 456-7890"))	
				if(utils.validateHeader(this.labelContactSchedulefor, "My Team"))
					if(utils.validateHeader(this.labelContactTopic, "Eligibility"))
						if(this.setTxtNotes("HElp!!  "))
							if(this.clickBtnSubmit())
								return true;
		return false;
	}
	
	

	@FindBy(xpath="//input[@id='StartDate']")
	WebElement txtneedCallBackstartDate;
	@FindBy(xpath="//input[@id='EndTime']")
	WebElement txtneedCallBackEndTime;
	@FindBy(xpath="//input[@id='StartTime']")
	WebElement txtneedCallBackstartTime;

	public boolean setTxtStartTime(String sFullName) throws InterruptedException
	{
		try
		{
			return utils.enterTextinAnelemnt(this.txtneedCallBackstartTime, sFullName, "Create Promised Action ", "Text Box Full  Name");
		}
		catch(StaleElementReferenceException e){
			return this.setTxtStartTime(sFullName);	
		}
	}
	
	public boolean setTxtEndTime(String sFullName) throws InterruptedException
	{
		try
		{
			return utils.enterTextinAnelemnt(this.txtneedCallBackstartTime, sFullName, "Create Promised Action ", "Text Box Full  Name");

		}
		catch(StaleElementReferenceException e){
			return this.setTxtEndTime(sFullName);
		}

	}


	public boolean setTxtStartDate(String sFullName) throws InterruptedException
	{
		try
		{
			return utils.enterTextinAnelemnt(this.txtneedCallBackstartDate, sFullName, "Create Promised Action ", "Text Box Full  Name");
		}
		catch(StaleElementReferenceException e){
			return this.setTxtEndTime(sFullName);
		}
	}

	public boolean selectOutcomeofReachedContactNeedCallback(String[] args) throws InterruptedException
	{
		if(this.selectdropDownOutcomeofContact("Reached Contact-Need Callback"))
			Thread.sleep(5000);
			if(this.setTxtStartDate(args[0].split(":")[1].trim()))
				if(this.setTxtStartTime("4:28:00 PM"))
					if(this.setTxtEndTime("4:28:00 PM"))
							return true;	
		return false;
	}


	public boolean selectOutcomeofLeftMessageNeedCallback(String[] args) throws InterruptedException
	{
		if(this.selectdropDownOutcomeofContact("Reached Contact-Need Callback"))
			if(this.setTxtStartDate(args[0].split(":")[1].trim()))
				if(this.setTxtStartTime("4:28:00 PM"))
					if(this.setTxtEndTime("4:28:00 PM"))
							return true;	
		return false;
	}

	// Change for Regression suite -- Gopi
	public boolean selectCreatedinErrorRTcheckDueDateTimeZones()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.selectdropDownViewForQueue("Created in error"))
						return true;
		return false;
	}

	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:submitRTPromisedActionTeamTaskResearch
	 * #Description: This functionality validates that the header of the task and then enter the notes and then validates the header of the assignee and then clicks submit.
	 * Type:TextBox
	 */	
	
	public boolean submitRTPromisedActionTeamTask()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
					if(utils.validateHeader(this.labelMyTeam, "My Team")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	}
	
	
	public boolean selectCompletedRTcheckDueDateTimeZones()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.selectdropDownViewForQueue("Completed"))
					return true;
		return false;
	}
	
	public boolean submitRTPromisedActionMyselfTaskOthers()
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Task"))
			if(this.setTxtNotes("Enter the new changes which needs to be reflected."))
					if(utils.validateHeader(this.labelMySelf, "Myself")) // For Central which has been given as default in the script 
						if(this.clickBtnSubmit())
							return true;
		return false;
	};
	
	
	public boolean selectEmailSuccessfulForPromisedAction() throws InterruptedException
	{
		if(utils.validateHeader(this.sHeaderPromisedActionPage, "Resolve Contact"))
			if(this.selectdropDownOutcomeofContact("Email Successful"))
					return true;
		return false;
	}

	// Main methods 
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:submitRCValuecheckComEmailEligibilityTeam
	 * #Description: This functionality validates the header of the task, Email and the task assigned and enter the notes and then click submit. 
	 * Type:TextBox
	 */	

		public boolean submitRCValuecheckComEmailEligibilityTeam()
		{
			if(utils.validateHeader(this.labelCommunicationType, "Email"))
				if(utils.validateHeader(this.labelEmail, "test@test.com"))	
					if(utils.validateHeader(this.labelContactSchedulefor, "My Team"))
							if(this.setTxtNotes("HElp!!  "))
								if(this.clickBtnSubmit())
									return true;
			return false;
		}
}
