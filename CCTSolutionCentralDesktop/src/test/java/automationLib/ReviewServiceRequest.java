package automationLib;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ReviewServiceRequest extends Driver {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCreatePromisedAction;
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement1;
	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement3;
	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public ReviewServiceRequest()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		gotoLastIframe();
	}

	@FindBy(xpath="//a[@class='Header_nav'][contains(text(),'Home')]")
	WebElement HomeTab;


	@FindBy(xpath="//div[contains(@datasource,'ActivityLogList_')]//table[@class='gridTable ']")
	WebElement tableActivityLog;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='pyFullName']/parent::div//span")
	WebElement labelIHmembername;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='HCIDDisplay']/parent::div//span")
	WebElement labelIHmemberid;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='Age']/parent::div//span")
	WebElement labelIHIHmemberage;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='CAParentID']/parent::div//span")
	WebElement labelIHmemberinteractionID;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='pyLabel']/parent::div//span")
	WebElement labelIHmemberSRType;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='pxCreateOpName']/parent::div//span")
	WebElement labelIHcreatedBy;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='pxResolvedUserName']/parent::div//span")
	WebElement labelIHresolvedBy;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='AssignmentGoalTime']/parent::div//span")
	WebElement labelIHgoalTime;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='pyStatusWork']/parent::div//span")
	WebElement labelIHSRStatus;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='pyResolvedTimestamp']/parent::div//span")
	WebElement labelIHResolvedOn;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='AssignmentDeadlineTime']/parent::div//span")
	WebElement labelIHDeadLineDate;


	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='AssignmentUrgency']/parent::div//span")
	WebElement labelIHUrgency;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='pxCreateDateTime']/parent::div//span")
	WebElement labelIHCreatedON;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//label[@for='ContactName']/parent::div//span")
	WebElement labelIHContact;

	@FindBy(xpath="//div[@node_name='ServiceCaseHeaderWrapper']//span[starts-with(text(),' ')]")
	WebElement checkIHBlankSpace;

	@FindBy(xpath="//div[@node_name='ServiceRequestActivity']//table[@id='bodyTbl_right']")
	WebElement tableServiceRequestActivity;


	@FindBy(xpath="//div[@node_name='CPMInteractionHistoryDetails']//table[@id='bodyTbl_right']")
	WebElement tableServiceRequestInteractionHeader;

	@FindBy(xpath="//div[@node_name='NotesList']//table[@id='bodyTbl_right']")
	WebElement tableServiceRequestPreviousNotes;

	@FindBy(xpath="//div[@node_name='ReviewTaggedItems']//table[@id='bodyTbl_right']")
	WebElement tableServiceRequestSummary;

	@FindBy(xpath="//span[text()='Disclaimers quoted with Contact']")
	WebElement disclaimerDiscussed;

	@FindBy(xpath="//table[@pl_prop='.TaggedDisclaimerQuotes']")
	WebElement tblDiscusedDisclaimer;


	//SERVICE REQUEST DETAILS----Contact type

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='PACActivityType']/parent::div//span")
	WebElement labelRSRDetailsType;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='StartDate']/parent::div//span")
	WebElement labelRSRDetailsStartDate;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='StartTime']/parent::div//span")
	WebElement labelRSRDetailsStarttime;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='EndTime']/parent::div//span")
	WebElement labelRSRDetailsEndTime;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='TimeZone']/parent::div//span")
	WebElement labelRSRDetailsTimeZone;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='pyStartDateTime']/parent::div//span")
	WebElement labelRSRDetailsLocalstartdatetime;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='CommunicationChannel']/parent::div//span")
	WebElement labelRSRDetailsCommunicationType;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='Email']/parent::div//span")
	WebElement labelRSRDetailsEmail;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='PACScheduledFor']/parent::div//span")
	WebElement labelRSRDetailsScheduledFor;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='Notes']/parent::div//span")
	WebElement labelRSRDetailsNotes;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='Topic']/parent::div//span")
	WebElement labelRSRDetailsTopic;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='DueDate']/parent::div//span")
	WebElement labelRSRDetailsduedate;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='DueTime']/parent::div//span")
	WebElement labelRSRDetailsduetime;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//label[@for='PAResolutionOutcome']/parent::div//span")
	WebElement labelRSRDetailsResolution;

	@FindBy(xpath="//label[@for='PolicyState']/following-sibling::div/span")
	WebElement labelPolicyState;


	//PREVIOUS NOTES

	@FindBy(xpath="//div[@title='Disclose Previous Notes']")
	WebElement disclosepreviousnotes;

	@FindBy(xpath="//div[@title='Disclose Summary']")
	WebElement disclosesummary;
	@FindBy(xpath="//div[@title='Disclose Action Required from the Billing Team']")
	WebElement discloseActionRequired;

	@FindBy(xpath="//div[@title='Disclose Request Help from OE/Manager']")
	WebElement discloseRequestHelpfromOEmanager;

	@FindBy(xpath="//div[@node_name='CPMWorkSpecificDetails']//*[@title='Disclose Resolve Task']")
	WebElement discloseresolvetask;


	//Billing
	@FindBy(xpath="//div[@node_name='RequestBillingActionDetails']//label[@for='EnrollmentandBillingSelection']/parent::div//div")
	WebElement labelRSRDetailsBillingSelectone;

	@FindBy(xpath="//div[@node_name='RequestBillingActionDetails']//label[@for='PrimaryReasonforBilling']/parent::div//div//span")
	WebElement labelRSRDetailsBillingReasonforContact;

	@FindBy(xpath="//div[@node_name='RequestBillingActionDetails']//label[@for='BillingActionType']/parent::div//div//span")
	WebElement labelRSRDetailsBillingRequestedAction;

	@FindBy(xpath="//div[@node_name='RequestBillingActionDetails']//label[@for='SelectUrgentOrCodeBlue']/parent::div//div//span")
	WebElement labelRSRDetailsBillingrequestedActionreason;

	@FindBy(xpath="//div[@node_name='RequestBillingActionDetails']//label[@for='OverrideReason']/parent::div//div//span")
	WebElement labelRSRDetailsBillingReasonforOverride;

	@FindBy(xpath="//div[@node_name='RequestBillingActionDetails']//label[@for='BillingEnrollmentNotes']/parent::div//div//span")
	WebElement labelRSRDetailsBillingNotes;

	//Request Manager Help


	@FindBy(xpath="//label[@for='HelpQuestion']/parent::div//div//span")
	WebElement labelRSRDetailsRequestManagerHelpHelpQuestion;

	@FindBy(xpath="//label[@for='HelpResearchCompleted']/parent::div//div//span")
	WebElement labelRSRDetailsRequestManagerHelpResearchCompelted;

	@FindBy(xpath="//label[@for='HelpResponse']/parent::div//div//span")
	WebElement labelRSRDetailsRequestManagerHelpHelpResponse;



	public void switchbetweenframes(String el)
	{
		try{ 
			Boolean varstate=false;
			Driver.pgDriver.switchTo().defaultContent();	
			List <WebElement>frame_Collection=Driver.pgDriver.findElements(By.tagName("iframe"));
			System.out.println("No.of frames:"+frame_Collection.size());

			for(int i=0;i<frame_Collection.size();i++)
			{
				//			for(WebElement iframe:frame_Collection)
				//			{
				//			System.out.println("Frame ID :"+iframe.getAttribute("id"));
				//			System.out.println("Frame Name :"+iframe.getAttribute("name"));
				//			Driver.pgDriver.switchTo().frame(iframe);

				Driver.pgDriver.switchTo().frame(i);

				try
				{
					wait=new WebDriverWait(Driver.pgDriver,3);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(el)));
					varstate=true;
					System.out.println("found");
					break;

				}
				catch(Exception e)
				{
					Driver.pgDriver.switchTo().defaultContent();
					System.out.println("no element");
					continue;
				}

			}

			if(!varstate)
			{
				System.out.println("No element found");
				err.logcommonMethodError("Review Service Request", "Could not find element in any frame");
			}
		}
		catch(Exception e){
			System.out.println("There is some error" + e);

		}


	}

	public void chooseIDfromRecentInteraction()
	{
		Home home=new Home();
		String[]samp={" "," "};
		home.checkandclickRecentSR();
	}



	public boolean validateInteractionHeader(String[] values)
	{
		Boolean returnvar=true;
		chooseIDfromRecentInteraction();
		Driver.getPgDriver().switchTo().defaultContent();
		wait=new WebDriverWait(Driver.pgDriver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='CPMServiceCaseHeader']")));

		int spacecount=Driver.pgDriver.findElements(By.xpath("//div[@node_name='ServiceCaseHeaderWrapper']//span[starts-with(text(),' ')]")).size();
		if(spacecount>0)
		{
			System.out.println("Empty space present ");
			err.logError("Review Service Request", "Empty -Space present insted of hyphen");
			return false;
		}
		String keyvaluepair="";
		for(String iterator : values)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("Review Service Request", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("name")){
				returnvar = this.labelIHmembername.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("memberid")){
				returnvar = this.labelIHmemberid.getText().toLowerCase().contains(value);
				continue;}

			else if(key.toLowerCase().contains("age")){
				returnvar = this.labelIHIHmemberage.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("interactionid")){
				returnvar = this.labelIHmemberinteractionID.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("type")){
				returnvar = this.labelIHmemberSRType.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("createdby")){
				returnvar = this.labelIHcreatedBy.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("resolvedby")){
				returnvar = this.labelIHresolvedBy.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("status")){
				returnvar = this.labelIHSRStatus.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("urgency")){
				returnvar = this.labelIHSRStatus.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("createdon")){
				returnvar = this.labelIHCreatedON.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("resolvedon")){
				returnvar = this.labelIHResolvedOn.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("goal")){
				returnvar = this.labelIHgoalTime.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("deadline")){
				returnvar = this.labelIHDeadLineDate.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("contact")){
				returnvar = this.labelIHContact.getText().toLowerCase().contains(value);
				continue;
			}

			else if(key.toLowerCase().contains("policy based out of")){
				returnvar = this.labelPolicyState.getText().toLowerCase().contains(value);
				continue;
			}

			else 
				err.logcommonMethodError("Review Service Request", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;




		}


		if(returnvar)
		{
			System.out.println("Member genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=values.length;
			err.logcommonMethodError("Member Composite", "the value "+values[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}



	}

	public boolean validatePromisedActionsServiceRequestDetails(String[] values)
	{
		Boolean returnvar=true;
		chooseIDfromRecentInteraction();
		Driver.getPgDriver().switchTo().defaultContent();
		wait=new WebDriverWait(Driver.pgDriver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='CPMServiceCaseHeader']")));

		int spacecount=Driver.pgDriver.findElements(By.xpath("//div[@node_name='CPMWorkSpecificDetails']//span[starts-with(text(),' ')]")).size();
		if(spacecount>0)
		{
			System.out.println("Empty space present ");
			err.logError("Review Service Request", "Empty -Space present insted of hyphen");
			return false;
		}
		switchbetweenframes("//div[@node_name='CPMWorkSpecificDetails']//label[@for='PACActivityType']/parent::div//span");
		String keyvaluepair="";
		for(String iterator : values)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("Review Service Request", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("type")){
				returnvar = this.labelRSRDetailsType.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("startdate")){
				returnvar = this.labelRSRDetailsStartDate.getText().toLowerCase().contains(value);
				continue;}

			else if(key.toLowerCase().contains("starttime")){
				returnvar = this.labelRSRDetailsStarttime.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("endtime")){
				returnvar = this.labelRSRDetailsEndTime.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("timezone")){
				returnvar = this.labelRSRDetailsTimeZone.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("local")){
				returnvar = this.labelRSRDetailsLocalstartdatetime.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("commu")){
				returnvar = this.labelRSRDetailsCommunicationType.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("email")){
				returnvar = this.labelRSRDetailsEmail.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("schedule")){
				returnvar = this.labelRSRDetailsScheduledFor.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("notes")){
				returnvar = this.labelRSRDetailsNotes.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("topic")){
				returnvar = this.labelRSRDetailsTopic.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("duedate")){
				returnvar = this.labelRSRDetailsduedate.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("duetime")){
				returnvar = this.labelRSRDetailsduetime.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("resolution")){
				this.discloseresolvetask.click();

				returnvar = this.labelRSRDetailsResolution.getText().toLowerCase().contains(value);
				continue;
			}



			else 
				err.logcommonMethodError("Review Service Request", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;




		}


		if(returnvar)
		{
			System.out.println("Member genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=values.length;
			err.logcommonMethodError("Member Composite", "the value "+values[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}



	}

	public boolean validateServiceRequestActivity(String[] rowvalues)
	{
		try
		{


			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@node_name='CPMServiceCaseHeader']//label[@for='pyFullName']/parent::div//span")));
		}
		catch(Exception e)
		{
			chooseIDfromRecentInteraction();
		}
		switchbetweenframes("//div[@node_name='ServiceRequestActivity']//table[@id='bodyTbl_right']");
		ArrayList<String> expectedheaderarray=new ArrayList<String>();
		expectedheaderarray.addAll(Arrays.asList("Description","Category","Owner"));
		ArrayList<String> actualheaderarray=new ArrayList<String>();
		actualheaderarray=utils.getheaderrowFromTable(this.tableServiceRequestActivity);
		System.out.println("Length _____________________>>>."+rowvalues.length);
		if(rowvalues.length<=1)
			return true;
		for(int i=0;i<actualheaderarray.size();i++)
		{
			System.out.println(actualheaderarray.get(i)+"---------"+expectedheaderarray.get(i));
			if(actualheaderarray.get(i).contains(expectedheaderarray.get(i)))
				continue;
			else
				return false;
		}


		if(utils.validateRowValues(this.tableServiceRequestActivity, rowvalues))
			return true;
		else
			return false;
	}

	public boolean validateServiceRequestInteractionHistory(String[] rowvalues)
	{
		try
		{


			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@node_name='CPMServiceCaseHeader']//label[@for='pyFullName']/parent::div//span")));
		}
		catch(Exception e)
		{
			chooseIDfromRecentInteraction();
		}
		switchbetweenframes("//div[@node_name='CPMInteractionHistoryDetails']//table[@id='bodyTbl_right']");
		ArrayList<String> expectedheaderarray=new ArrayList<String>();
		expectedheaderarray.addAll(Arrays.asList("","Interaction ID","Interaction Type","Created By","Created On","Wrapped By"));
		ArrayList<String> actualheaderarray=new ArrayList<String>();
		actualheaderarray=utils.getheaderrowFromTable(this.tableServiceRequestInteractionHeader);
		if(rowvalues.length<=1)
			return true;
		for(int i=0;i<actualheaderarray.size();i++)
		{
			System.out.println(actualheaderarray.get(i)+"---------"+expectedheaderarray.get(i));
			if(actualheaderarray.get(i).contains(expectedheaderarray.get(i)))
				continue;
			else
				return false;
		}
		System.out.println("Before adiing " +rowvalues);
		List <String> myList=new ArrayList<String>(Arrays.asList(rowvalues));
		myList.add(0,"");
		rowvalues=myList.toArray(new String[myList.size()]);
		System.out.println("After adiing " +rowvalues);
		if(utils.validateRowValues(this.tableServiceRequestInteractionHeader, rowvalues))
			return true;
		else
			return false;
	}

	public boolean validatePromisedActionPreviousNotes(String[] rowvalues)
	{
		try
		{


			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@node_name='CPMServiceCaseHeader']//label[@for='pyFullName']/parent::div//span")));
		}
		catch(Exception e)
		{
			chooseIDfromRecentInteraction();
		}
		switchbetweenframes("//div[@node_name='NotesList']//table[@id='bodyTbl_right']");
		ArrayList<String> expectedheaderarray=new ArrayList<String>();
		this.disclosepreviousnotes.click();
		if(this.labelRSRDetailsType.getText().toLowerCase().contains("contact"))
		{
			expectedheaderarray.addAll(Arrays.asList("Create Date","Created By","Notes","Start Date","Start Time","End Time"));
			System.out.println("CONTACTTTTTTTT");
		}
		else if(this.labelRSRDetailsType.getText().toLowerCase().contains("task"))
		{
			expectedheaderarray.addAll(Arrays.asList("Create Date","Created By","Notes","Due Date","Due Time"));
			System.out.println("TTTTTTTASSSkkkk");
		}
		ArrayList<String> actualheaderarray=new ArrayList<String>();
		System.out.println(expectedheaderarray.toString());
		actualheaderarray=utils.getheaderrowFromTable(this.tableServiceRequestPreviousNotes);
		if(rowvalues.length<=1)
			return true;
		for(int i=0;i<actualheaderarray.size();i++)
		{
			System.out.println(actualheaderarray.get(i)+"---------"+expectedheaderarray.get(i));
			if(actualheaderarray.get(i).contains(expectedheaderarray.get(i)))
				continue;
			else
				return false;
		}
		System.out.println("Before adiing " +rowvalues);
		List <String> myList=new ArrayList<String>(Arrays.asList(rowvalues));
		myList.add(0,"");
		rowvalues=myList.toArray(new String[myList.size()]);
		System.out.println("After adiing " +rowvalues);
		if(utils.validateRowValues(this.tableServiceRequestPreviousNotes, rowvalues))
			return true;
		else
			return false;
	}

	public boolean validateManageBillingPreviousNotes(String[] rowvalues)
	{
		try
		{


			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@node_name='CPMServiceCaseHeader']//label[@for='pyFullName']/parent::div//span")));
		}
		catch(Exception e)
		{
			chooseIDfromRecentInteraction();
		}
		switchbetweenframes("//div[@node_name='NotesList']//table[@id='bodyTbl_right']");
		this.disclosepreviousnotes.click();
		ArrayList<String> expectedheaderarray=new ArrayList<String>();

		expectedheaderarray.addAll(Arrays.asList("Create Date","Created By","Notes"));

		ArrayList<String> actualheaderarray=new ArrayList<String>();
		actualheaderarray=utils.getheaderrowFromTable(this.tableServiceRequestPreviousNotes);
		if(rowvalues.length<=1)
			return true;
		for(int i=0;i<actualheaderarray.size();i++)
		{
			System.out.println(actualheaderarray.get(i)+"---------"+expectedheaderarray.get(i));
			if(actualheaderarray.get(i).contains(expectedheaderarray.get(i)))
				continue;
			else
				return false;
		}
		System.out.println("Before adiing " +rowvalues.toString());
		List <String> myList=new ArrayList<String>(Arrays.asList(rowvalues));
		myList.add(0,"");
		rowvalues=myList.toArray(new String[myList.size()]);
		System.out.println("After adiing " +rowvalues.toString());
		if(utils.validateRowValues(this.tableServiceRequestPreviousNotes, rowvalues))
			return true;
		else
			return false;
	}

	public boolean validateManageBillingDescription(String[] rowvalues)
	{
		try
		{
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@node_name='CPMServiceCaseHeader']//label[@for='pyFullName']/parent::div//span")));
		}
		catch(Exception e)
		{
			chooseIDfromRecentInteraction();
		}
		switchbetweenframes("//div[@node_name='ReviewTaggedItems']//table[@id='bodyTbl_right']");
		this.disclosesummary.click();
		ArrayList<String> expectedheaderarray=new ArrayList<String>();

		expectedheaderarray.addAll(Arrays.asList("Description"));

		ArrayList<String> actualheaderarray=new ArrayList<String>();
		actualheaderarray=utils.getheaderrowFromTable(this.tableServiceRequestSummary);
		if(rowvalues.length<=1)
			return true;
		for(int i=0;i<actualheaderarray.size();i++)
		{
			System.out.println(actualheaderarray.get(i)+"---------"+expectedheaderarray.get(i));
			if(actualheaderarray.get(i).contains(expectedheaderarray.get(i)))
				continue;
			else
				return false;
		}

		if(utils.validateRowValues(this.tableServiceRequestSummary, rowvalues))
			return true;
		else
			return false;
	}

	public boolean validateManageBillingActionRequiredFromBillingTeam(String[] values)
	{
		Boolean returnvar=true;	
		try
		{
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@node_name='CPMServiceCaseHeader']//label[@for='pyFullName']/parent::div//span")));
		}
		catch(Exception e)
		{
			chooseIDfromRecentInteraction();
		}
		switchbetweenframes("//div[@node_name='ReviewTaggedItems']//table[@id='bodyTbl_right']");
		this.discloseActionRequired.click();
		int spacecount=Driver.pgDriver.findElements(By.xpath("//div[@node_name='ServiceCaseHeaderWrapper']//span[starts-with(text(),' ')]")).size();
		if(spacecount>0)
		{
			System.out.println("Empty space present ");
			err.logError("Review Service Request", "Empty -Space present insted of hyphen");
			return false;
		}
		String keyvaluepair="";
		for(String iterator : values)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("Review Service Request", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("select")){
				returnvar = this.labelRSRDetailsBillingSelectone.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("reasonforcontact")){
				returnvar = this.labelRSRDetailsBillingReasonforContact.getText().toLowerCase().contains(value);
				continue;}

			else if(key.toLowerCase().contains("requestedaction")){
				returnvar = this.labelRSRDetailsBillingRequestedAction.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("reasonforoverride")){
				returnvar = this.labelRSRDetailsBillingReasonforOverride.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("reason")){
				returnvar = this.labelRSRDetailsBillingrequestedActionreason.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("notes")){
				returnvar = this.labelRSRDetailsBillingNotes.getText().toLowerCase().contains(value);
				continue;
			}


			else 
				err.logcommonMethodError("Review Service Request", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}


		if(returnvar)
		{
			System.out.println("Review Service Request checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=values.length;
			err.logcommonMethodError("Member Composite", "the value "+values[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}



	}

	public boolean validateManageBillingRequestHelpfromOEManager(String[] values)
	{
		Boolean returnvar=true;	
		try
		{
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@node_name='CPMServiceCaseHeader']//label[@for='pyFullName']/parent::div//span")));
		}
		catch(Exception e)
		{
			chooseIDfromRecentInteraction();
		}
		switchbetweenframes("//div[@title='Disclose Request Help from OE/Manager']");
		this.discloseRequestHelpfromOEmanager.click();
		int spacecount=Driver.pgDriver.findElements(By.xpath("//div[@node_name='CAWorkSpecific']//span[starts-with(text(),' ')]")).size();
		if(spacecount>0)
		{
			System.out.println("Empty space present ");
			err.logError("Review Service Request", "Empty -Space present insted of hyphen");
			return false;
		}
		String keyvaluepair="";
		for(String iterator : values)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("Review Service Request", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("question")){
				returnvar = this.labelRSRDetailsRequestManagerHelpHelpQuestion.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("research")){
				returnvar = this.labelRSRDetailsRequestManagerHelpResearchCompelted.getText().toLowerCase().contains(value);
				continue;}

			else if(key.toLowerCase().contains("response")){
				returnvar = this.labelRSRDetailsRequestManagerHelpHelpResponse.getText().toLowerCase().contains(value);
				continue;
			}

			else 
				err.logcommonMethodError("Review Service Request", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}


		if(returnvar)
		{
			System.out.println("Review Service Request checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=values.length;
			err.logcommonMethodError("Review Service Request", "the value "+values[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateActiveLogTable(String[] activelogrowvalue){
		action.moveToElement(tableActivityLog);
		return utils.validatetablerowbasedonvalues(tableActivityLog, activelogrowvalue);		
	}

	@FindBy(xpath="//table[@pl_prop='.EANDBCancelMemberList']")
	private WebElement selectMemberTable;
	@FindBy(xpath="//a[@issprite='true']")
	private WebElement closeResults;
	@FindBy(xpath="//span[text()='Action Required from the Enrollment Team']")
	private WebElement actionRequired;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateSelectMemberSection
	 * #Description:This method would validate if the selected members are displayed as checked in 'Select Member' Section - Review Service Request page.
	 * #Arguments:Member name
	 * Type:Textbox
	 */
	public boolean validateSelectMemberSection(String args[]){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.actionRequired);
		this.actionRequired.click();
		utils.waitforpageload();
		ArrayList<String> matchedList = new ArrayList<String>();
		ArrayList<String> unmatchedList = new ArrayList<String>();
		List<String> datainput = new ArrayList<String>(Arrays.asList(args));

		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.selectMemberTable);
		for(String s:args){
			String fname = "First Name";
			StringBuilder input = new StringBuilder();
			String sinput = input.append(fname).append(":").append(s).toString();
			try {
				if(utils.validatetablerowbasedonvalues(this.selectMemberTable,sinput)){
					matchedList.add(s);
				}else{
					System.out.println("Element not selected in UI:"+s);
					unmatchedList.add(s);
				}
			} catch (Exception e) {
				err.logError("ReviewServiceRequest", "validateSelectMemberSection");
				System.out.println("Member name is not checked/selected"+e);
			}
		}

		if(unmatchedList.size()>0){
			System.out.println("Active member who aren't checked::"+unmatchedList);
			Driver.getPgDriver().switchTo().defaultContent();
			List<WebElement> closeBtn = Driver.pgDriver.findElements(By.xpath("//a[@issprite='true']"));
			action.moveToElement(closeBtn.get(1)).click().build().perform();
		}

		if(unmatchedList.size()==0){
			if(matchedList.size()==datainput.size()){
				Driver.getPgDriver().switchTo().defaultContent();
				List<WebElement> closeBtn = Driver.pgDriver.findElements(By.xpath("//a[@issprite='true']"));
				action.moveToElement(closeBtn.get(1)).click().build().perform();
				return true;
			}
		}
		return false;
	}	

	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyOwnerInSRactivity
	 * #Description:This method validates if request is assigned and routed to appropriate Owner or Workbasket.
	 * #Arguments:OwnerName/WorkBasket
	 * Type:Table
	 * Keys:OwnerName#WorkBasket
	 */
	public boolean verifyOwnerInSRactivity(String args[]){
		return true;
	}


	@FindBy(xpath="//table[@pl_prop='D_ServicedetailsInWorkbasket.pxResults']//td[3]")
	private WebElement ownerValuesInApplication;

	public boolean validateServiceRequestTableOwnerValue(String[] owner) throws Exception
	{
		String ownerValuesGivenByInput = owner[0];
		return utils.validateValueinelement(this.ownerValuesInApplication, ownerValuesGivenByInput);
	}


	public boolean validateActivityReuquestTableActivityValue(String[] activity)
	{
		String activityValueGivenByInput = activity[0];
		String activityValueInApplication = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.AccumulatorNotesList']//tr[contains(@id,'$PpyWorkPage$pAccumulatorNotesList')]//td[5]//span")).getText();
		return utils.isvalueMatch_contain(activityValueGivenByInput, activityValueInApplication);
	
	}
	@FindBy(xpath="//table[@pl_prop='D_ServicedetailsInWorkbasket.pxResults']")
	private WebElement ServiceRequestActivityTable;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateTheSROwner
	 * #Description:This method validates the owner of the SR in SR Review page
	 * #Arguments:Owner
	 * Type:Table
	 * Keys:#Owner
	 */
	public boolean validateTheSROwner(String args[]) throws InterruptedException{
		//Driver.pgDriver.findElement(By.xpath("//*[@class='Standard_task'][contains (text(),' Grievance and App...')]")).click();
		utils.waitforpageload();	
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.ServiceRequestActivityTable);
			return utils.clickontablerowbasedonvalues(this.ServiceRequestActivityTable, args);
	}

	@FindBy(xpath="//span[@data-test-id='2015011307071009054871']")
	private WebElement SRstatus;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateTheSRStatus
	 * #Description:This method validates the owner of the G&A SR in SR Review page
	 * #Arguments:Status
	 * Type:Table
	 * Keys:#Status
	 */
	public boolean validateTheSRStatus(String args[]) throws InterruptedException{				
		utils.waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
		return utils.validateLabel(SRstatus, args[0]);
	}



	//SR for Alerts, Referrals and View Programs

	@FindBy(xpath="//span[text()='Reason for Contact']//parent::label//parent::div/div//span")
	private WebElement txtReasonForContact;

	@FindBy(xpath="//*[@data-test-id='20180226042510096512841']")
	private WebElement txtNotes;

	@FindBy(xpath="//table[@pl_prop='.DocumentReferenceNumber']")
	private WebElement tblDocumentReferences;


	@FindBy(xpath="//table[@pl_prop='.ReferralOverviewList']")
	private WebElement tblItemsScheduledDuringManageReferral;

	@FindBy(xpath="//span[contains(text(),'Items Discussed During Manage Referrals')]")
	WebElement lnkItemsDiscussed;

	@FindBy(xpath="//span[contains(text(),'Items Scheduled During Manage Referrals')]")
	WebElement lnkItemsScheduled;

	@FindBy(xpath="//img[@title='Checked']")
	WebElement labelRefHistoryCheckBox;

	public boolean clickItemsScheduled()
	{
		return utils.clickAnelemnt(this.lnkItemsScheduled, "ReviewServiceRequest", "Item Scheduled");
	}

	public boolean clickItemsDiscussed()
	{
		return utils.clickAnelemnt(this.lnkItemsDiscussed, "ReviewServiceRequest", "Item Discussed");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateServiceRequestInteractionHistoryDetails
	 * #Description:This functionality validates the Service Request Interaction History details on the service request for Alerts, Referrals  and View Programs page.
	 * #Arguments:Status
	 * Type:Table
	 * Keys:Arguments:Interatcion ID#Interaction Type#Created By#Created On#Wrapped By
	 */

	public boolean validateServiceRequestInteractionHistoryDetails(String[] tablevalues) throws InterruptedException
	{
		//Thread.sleep(50000);
		switchbetweenframes("//div[@node_name='CPMInteractionHistoryDetails']//table[@id='bodyTbl_right']");
		if (utils.validatetablerowbasedonvalues(this.tableServiceRequestInteractionHeader, tablevalues))
			return true;
		else
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateReasonForContactAndNotesOFServiceRequestDetails
	 * #Description:This functionality validates the Service Request details of notes and reason for contact and notes of Referrals,Alerts and View Programs review page
	 * #Arguments:#Reason for contact#notes
	 * Type:Text
	 */

	public boolean validateReasonForContactAndNotesOFServiceRequestDetails(String[] args){
		switchbetweenframes("//span[text()='Reason for Contact']//parent::label//parent::div/div//span");
		String ref = txtReasonForContact.getText();
		String ref2 = txtNotes.getText();
		System.out.println(ref +""+ ref2);
		if(!(ref.equalsIgnoreCase(args[0]))){
			err.logcommonMethodError("ReviewServiceRequest", "Reason for contact is mis-matched with user input");
			return false;
		}
		if(!(ref2.equalsIgnoreCase(args[1]))){
			err.logcommonMethodError("ReviewServiceRequest", "Notes is mis-matched with user input");
			return false;
		}
		System.out.println("Both Reason for contact and Notes are matched with the UI.");
		return true;
	}	



	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateDocumentReferences
	 * #Description:This functionality validates the Document References on the service request details for Referrals,Alerts and View Programs review page
	 * #Arguments:Reference Type and Reference Number
	 * Type:Table
	 * Keys:Reference Type#Reference Number
	 */
	public boolean validateDocumentReferences(String[] tablevalues){
		switchbetweenframes("//table[@pl_prop='.DocumentReferenceNumber']");
		if (utils.validatetablerowbasedonvalues(this.tblDocumentReferences, tablevalues))
			return true;
		else
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateItemsScheduledDuringManageReferrals
	 * #Description:This functionality validates the Items scheduled in Service Request details on the service request for Referrals review page
	 * #Arguments:Reference Type and Reference Number
	 * Type:Table
	 * Keys:Referral Reason#Action/TransferOutcome#Rferral Vendor Program#Call Back date#Call Back Time
	 */

	public boolean validateItemsScheduledDuringManageReferrals(String[] tablevalues){
		switchbetweenframes("//table[@pl_prop='.ReferralOverviewList']");
		clickItemsScheduled();
		if(utils.validatetablerowbasedonvalues(this.tblItemsScheduledDuringManageReferral, tablevalues))
			return true;
		else
			return false;	
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyThatTheReferralHistoryInformationIsDisplyaedUnderItemsDiscussed
	 * #Description: This functionality verifies that the Referral History Information is Displayed under Items discussed section.
	 * Type: Textbox
	 */
	public boolean verifyThatTheReferralHistoryInformationIsDisplyaedUnderItemsDiscussed()
	{
		switchbetweenframes("//span[contains(text(),'Items Discussed')]");
			if(this.clickItemsDiscussed())
				return !utils.isProxyWebelement(labelRefHistoryCheckBox);
			return false;
	}

	@FindBy(xpath="//*[@data-test-id='20151125003339020631974']")
	List<WebElement> ActivityColumnActivityLog;

	public boolean verifyActivityStatusIsClosed() {
		WebElement element = ActivityColumnActivityLog.get(0);
		return utils.validateLabel(element, "Close Request");
	}

	//Sprint 2.4

	@FindBy(xpath="//table[@pl_prop='.BillingTeamNotesList']")
	WebElement tblActivityLog;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateActivityLogTableInCSRReview
	 * #Description: Validates the Activity log table value present with the values given by the user
	 * #Argument: Activity Log
	 * Type: Table
	 * Keys: Create Date#Created By#Notes#Activity
	 */
	public boolean validateActivityLogDetails(String[] tablevalues) throws InterruptedException
	{
			Thread.sleep(3000);
			WebElement element = this.tableActivityLog;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.validatetablerowbasedonvalues(this.tblActivityLog, tablevalues);
	}

	@FindBy(xpath="//table[@pl_prop_class='Antm-FW-CSFW-Data-Notes']")
	private WebElement table;

	public boolean VerifyManageEnrollmentAndBillingTable(String[] tablevalues)
	{
		utils.waitforpageload();			
		return utils.validatetablerowbasedonvalues(table, tablevalues);

	}

	@FindBy(xpath="//*[text()='Batch Auto Letters']")
	WebElement BatchAutoLettersLnk;

	public boolean clickBatchAutoLettersLink() {
		if(utils.isProxyWebelement(BatchAutoLettersTable))
			return utils.clickAnelemnt(BatchAutoLettersLnk, "ReviewServiceRequest", "BatchAutoLettersLnk");
		else
			return true;
	}

	@FindBy(xpath="//*[text()='Batch Auto Letters']/ancestor::div[@class='layout layout-outline layout-outline-nested']//table[@class='gridTable ']")
	WebElement BatchAutoLettersTable;

	int count =0 ;

	public boolean batchAutoLetterValidation(String[] args) throws InterruptedException {
		boolean flag = false;
		try {
			if(!utils.isProxyWebelement(BatchAutoLettersTable))
				utils.clickAnelemnt(BatchAutoLettersLnk, "ReviewServiceRequest", "BatchAutoLettersLnk");
			else {
				flag = utils.validatetablerowbasedonvalues(BatchAutoLettersTable, args);
				if(flag) {
					flag = true;
				}else {
					Thread.sleep(300000); // 5 mins
					utils.refreshPage();
					count++;
					if(count==15) {
						flag=false;
					}else {
						batchAutoLetterValidation(args);
					}
				}
			}
		}catch(Exception e) {
			Thread.sleep(300000); // 5 mins
			utils.refreshPage();
			count++;
			if(count==15) {
				flag=false;
			}else {
				batchAutoLetterValidation(args);
			}
		}

		if(flag==true) {
			blogger.loginfo("PASS: Auto Letter validation successful");
			return true;
		}else {
			blogger.loginfo("FAIL: Auto Letter validation not successful after waiting for 30 minutes");
			return false;
		}
	}

	@FindBy(xpath="//*[text()='Contact']")
	WebElement ContactLabel;

	public boolean displayContactinInteractionHeader() {
		//Driver.getPgDriver().switchTo().defaultContent();
		return !utils.isProxyWebelement(ContactLabel);
	}


	@FindBy(xpath="//label[text()='FAX number verified with Contact']")
	WebElement FAXnumberverifiedwithContactLbl;

	public boolean validateFaxNumberVerifiedWithContactisDisplayed() {
		return !utils.isProxyWebelement(FAXnumberverifiedwithContactLbl);
	}

	//Sprint 3.3

	@FindBy(xpath="//img[@data-test-id='20160127122348051611158']")
	WebElement imgOneDayGrievanceIndicator;

	@FindBy(xpath="//div[@gpropindex='PReviewedClaims2']//table[@pl_prop='.ReviewedClaims']")
	WebElement tblClaimsTaggedInGA;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimNumberGATaggedWithOneDayGrievance
	 * #Description:This method validates the Claim Number tagged with One Day Grievance Indicator checked.
	 * #Arguments:ClaimNumberTagged
	 * Type:Textbox
	 */
	public boolean validateClaimNumberWithOneDayGrievanceGATagged(String[] tablevalues) throws InterruptedException{  
			WebElement row = utils.returntablerowbasedonvalues(tblClaimsTaggedInGA, tablevalues);
			WebElement imgOneDayGrievance = row.findElement(By.xpath("//td[7]//img"));
			return !utils.isProxyWebelement(imgOneDayGrievance);
	}


	public boolean verifyClaimHasOneDayGrievanceIndicatorIsDisplayedInItemsReviewedTable()
	{
		return !utils.isProxyWebelement(imgOneDayGrievanceIndicator);
	}

	@FindBy(xpath="//label[text()='Mailing address verified with Contact']")
	WebElement MailingAddressVerifiedWithContactLbl;

	public boolean validateMailingAddressVerifiedWithContactisDisplayed() {
			wait = new WebDriverWait(Driver.pgDriver,10);
			return !utils.isProxyWebelement(MailingAddressVerifiedWithContactLbl);
	}


	@FindBy(xpath="//label[@for='IsOneDayGrievance']//following-sibling::div")
	WebElement imgOneDayGrievanceChecked;


	public boolean validateOneDayGrievanveSectionIsChecked()
	{
		try
		{
			boolean bol = imgOneDayGrievanceChecked.isDisplayed();
			System.out.println("Boolean value: "+bol);
			if(bol==true)
			{
				blogger.loginfo("One Day Grievance checked is Displayed");
				System.out.println("One Day Grievance checked is Displayed");
				return true;
			}else
			{
				blogger.loginfo("One Day Grievance checked is not Displayed");
				System.out.println("One Day Grievance checked is not Displayed");
				return false;
			}
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("ResolveClaimAdjustmentRequest","validateOneDayGrievanveSectionIsNotChecked", "Onne Day Grievance is not checked");
			return true;
		}
	}


	public boolean validateOneDayGrievanveSectionIsNotChecked()
	{
		return !utils.isProxyWebelement(imgOneDayGrievanceChecked);
	}


	//Sprint 3.4


	@FindBy(xpath="//table[@pl_prop='.MiscellaneousAccumList']")
	WebElement tblMiscellanousAccumulator;

	@FindBy(xpath="//span[contains(text(),'Miscellaneous Accumulators')]")
	WebElement lnkMiscellanousAccumulators;

	public boolean verifyMiscellaneousAccumulatorsSectionIsDisplayed()
	{
		return !utils.isProxyWebelement(lnkMiscellanousAccumulators);
	}

	/*	
	 * @SCU
	 * #CommonMethodWithArgument:validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment
	 * #Description:This functionality validates the Miscellanous Accumulator tagged or reviewed.
	 * #Argument:MiscellanousAccumsLevelTagged
	 * Type:Table
	 * Keys:Name#Description#From Thru#Unit#Amount
	 */
	public boolean validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment(String args[]){
		try{
			/*Driver.pgDriver.switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement1);*/
			WebElement row =utils.returntablerowbasedonvalues(this.tblMiscellanousAccumulator,args);
			List<WebElement> chkbox = row.findElements(By.xpath("//td//img[@class='checkbox chkBxCtl']"));
			if(chkbox.get(0).isDisplayed()){
				System.out.println("Review Requested is checked");
				return true;
				//Driver.pgDriver.switchTo().defaultContent();
			}
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input Accumulator -FamilyLevel" + e);
			return false;
		}
		return false;
	}


	public boolean expandDiscalimerQuotedWithContact() throws InterruptedException
	{
/*		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement1);*/
		return utils.clickAnelemnt(disclaimerDiscussed, "Complete Benefits review", "Disclaimer discuseed with contact");
	}

	public boolean validateDiscalimerQuotedWithContact(String[] args)
	{
		/*Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement1);*/
		return utils.validatetablerowbasedonvalues(tblDiscusedDisclaimer, args);

	}


	//Sprint 4.2

	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']")
	WebElement collapseIndicatorItemsDiscussed;

	public boolean verifyItemsDiscusseDuringManageEAndBReviewSectionIsCollapsed()
	{
		return !utils.isProxyWebelement(collapseIndicatorItemsDiscussed);
	}

	@FindBy(xpath="//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png']")
	WebElement imgCheckMarkEnrollmentInquiry;

	@FindBy(xpath="//div[@node_name='EnrollmentRelatedInquiry']//p//span")
	WebElement labelInstructionalTextEnrollmentInquiry;

	public boolean verifyEnrollmentInfoDiscussedTextWithCheckMarkAndEnrollmentInstructionalTextIsDisplayed()
	{
		if(!utils.isProxyWebelement(imgCheckMarkEnrollmentInquiry))
			if(!utils.isProxyWebelement(labelInstructionalTextEnrollmentInquiry))
				return true;
		return false;
	}


	@FindBy(xpath="//table[@pl_prop_class='Antm-FW-CSFW-Data-Claim']//th[8]//img[@data-test-id='20160204063348045687300']")
	WebElement claimIterationNo;

	public boolean validateIterationIndicatorisDisplayedinThirdColumn() {
		return !utils.isProxyWebelement(claimIterationNo);
	}


	//Sprint 5.1

	@FindBy(xpath="//div[@node_name='GAndAReviewRO']//p//span")
	WebElement ClaimsTextMessage;

	@FindBy(xpath="//div[@node_name='GAndAReviewRO']//p//span")
	WebElement AuthorizationTextMessage;

	public boolean validateTheClaimText(String[] args)
	{
		utils.waitforpageload();
		String actualText = args[0];
		String expectedText = ClaimsTextMessage.getText().replaceAll(",", " ").trim();
		return utils.isvalueMatch_contain(actualText, expectedText);
	
	}


	public boolean validateTheAuthorizationText(String[] args)
	{
		utils.waitforpageload();
		String actualText = args[0];
		String expectedText = AuthorizationTextMessage.getText().replaceAll(",", " ").trim();
		return utils.isvalueMatch_contain(actualText, expectedText);

	}

	@FindBy(xpath="//label[text()='NextGen Case ID']")
	WebElement labelNextGencaseID;

	@FindBy(xpath="//span[@data-test-id='20180316161348000643466']")
	WebElement labelNextGenCaseIDWithValue;


	public boolean validateNextGenIdIsDisplayed() {
		return !utils.isProxyWebelement(labelNextGencaseID) && !utils.isProxyWebelement(labelNextGenCaseIDWithValue);
	}

	//Sprint 5.2

	@FindBy(xpath="(//div[@role='button'])[1]")
	WebElement clickToolIcon;


	@FindBy(xpath="//span[text()='View Skills']")
	WebElement clickOnViewSkills;

	@FindBy(xpath="//span[text()='ClaimsForeignClaim']")
	WebElement ClaimsForeignSkill;

	@FindBy(xpath="//span[contains(text(),'All provider post-service')]")
	WebElement ProviderMedAppealText;

	@FindBy(xpath="//*[text()='Skill Name']/ancestor::table[@id='bodyTbl_right']")
	WebElement SkillRequiredTable;

	public boolean clickViewSkillsFromToolIcon() throws InterruptedException{
		Thread.sleep(3000);
		utils.scrolltoright();
		if(utils.clickAnelemnt(clickToolIcon, "ReviewServiceRequest", "Tool icon"))
			if(utils.clickAnelemnt(clickOnViewSkills, "ReviewServiceRequest", "View Skills"))
				return true;
		return false;

	}

	public boolean validateTheSRSkills(String[] args) {
		return utils.validatetablerowbasedonvalues(SkillRequiredTable, args);
	}

	public boolean validateTheProviderMedicalAppealInstText(String[] args) {
		System.out.println(ProviderMedAppealText.getText());
		return utils.validateLabel(ProviderMedAppealText, args[0]);
	}




	//Sprint 6.1

	@FindBy(id="ReviewResolveNotes")
	WebElement txtBxNotes;

	@FindBy(xpath="//div[contains(text(),'Add Notes')]")
	WebElement btnAddNotes;

	@FindBy(xpath="//table[@pl_prop='.ReviewNotesList']")
	WebElement tblAdditionalNotes;

	public boolean enterAdditionalNotes(String[] args)
	{
		if(utils.enterTextinAnelemnt(txtBxNotes, args[0], "ReviewServiceRequest", "enterAdditionalNotes"))
			if(utils.clickAnelemnt(btnAddNotes, "ReviewServiceRequest", "Add Notes"))
				return true;
		return false;
	}

	public boolean validateTheAdditionalNotesDetails(String[] args)
	{
		return utils.validatetablerowbasedonvalues(tblAdditionalNotes, args);
	}

	@FindBy(xpath="//span[text()='Rendering Provider Name']/../..//span[@data-test-id='201811121057460175185611']")
	WebElement RenderingProviderName;

	@FindBy(xpath="//span[text()='Rendering Provider NPI']/../..//span[@data-test-id='201811121101250417327420']")
	WebElement RenderingProviderNpi;

	@FindBy(xpath="//span[text()='Received Date']/../..//span[@data-test-id='20171208121557064355646']")
	WebElement ReceivedDate;

	@FindBy(xpath="//span[text()='Processing System']/../..//span[@data-test-id='20181108222422098680314']")
	WebElement ProcessingSystem;

	@FindBy(xpath="//span[text()='Date of Service']/../..//span[@data-test-id='20171208121557064355646']")
	WebElement DateOfService;

	@FindBy(xpath="//span[text()='Total Charges']/../..//span[@data-test-id='20160222033830024916286']")
	WebElement TotalCharges;
	
	@FindBy(xpath="//span[text()='Message ID']/../..//span[@data-test-id='201811281104290340129948']")
	WebElement MessageID;
	
	@FindBy(xpath="//label[text()='Member ID']/..//span[@data-test-id='201509180929400234553780']")
	WebElement MemberID;

	static Map<String,String> map;

	/**Get All Service Request Details
	 * 
	 * @return
	 */
	public boolean getProvideProcessingDetails() {
		map = new HashMap<String,String>();
		map.put("RenderingProviderName", RenderingProviderName.getText());
		map.put("RenderingProviderNpi", RenderingProviderNpi.getText());
		map.put("ReceivedDate", ReceivedDate.getText());
		map.put("ProcessingSystem", ProcessingSystem.getText());
		map.put("DateOfService", DateOfService.getText());
		map.put("TotalCharges", TotalCharges.getText());
		map.put("MessageID", MessageID.getText());
		Driver.getPgDriver().switchTo().defaultContent();
		map.put("MemberID", MemberID.getText());
		return true;
	}

	static String pathWithFileName; 

	@FindBy(xpath="//label[text()='Reference Number']/..//a[@data-test-id='201603160303060842204371']")
	WebElement ReferenceNumberLink;

	/**Click on Reference Number Link
	 * 
	 * @return
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public boolean clickOnReferenceNumberLink() throws IOException, InterruptedException {
		utils.waitforpageload();
		Boolean flag;
		flag = utils.clickAnelemnt(ReferenceNumberLink,"ReviewServiceRequest","ReferenceNumberLink");
		Thread.sleep(2000);
		String path = System.getProperty("user.home")+"\\Downloads\\";
		System.out.println(path);
		File fileName = getLatestFilefromDir(path);
		System.out.println(fileName);
		String pathWithFileNamefrchange = path + fileName.getName();
		Path source = Paths.get(pathWithFileNamefrchange);
		String[] filenameonly = fileName.getName().split("\\.");
		Files.move(source, source.resolveSibling(filenameonly[0]+".jpg"));
		File fileName1 = getLatestFilefromDir(path);
		String filename = fileName1.getName();
		pathWithFileName = path+filename;
		System.out.println(pathWithFileName);
		return flag;
	}

	/**
	 * @throws Exception
	 * @desc This method gets the latest updated file from downloads folder
	 */
	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	//Sprint 6.4
	
	@FindBy(xpath="//span[contains(text(),'Service Request Details')]")
	WebElement serviceRequestDetailsHead;
	
	public boolean validateTheServiceRequestDetailsHeader() 
	
	{
		return utils.validateHeader(serviceRequestDetailsHead,"Service Request Details");
		
	}
	
	/**Trigger RPA Process
	 * 
	 * @return
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public boolean triggerRPAProcess() throws IOException, InterruptedException {
		System.out.println("COMMAND PROMPT started");
	
		String path = System.getProperty("user.dir")+"\\ShocFlow\\RPA.bat";
		Runtime.getRuntime().exec(path);
		waitfortastcompletion();
		
		System.out.println("COMMAND PROMPT completed");
		return true;
	}
	
	
	private static void waitfortastcompletion() throws IOException, InterruptedException {
		String line;
		String pidInfo = null;
		Process p =Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
		BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));
		while ((line = input.readLine()) != null) {
		    pidInfo+=line; 
		}

		input.close();

		if(pidInfo.contains("OpenSpan.Runtime.exe"))
		{
		    System.out.println("OpenSpan.Runtime.exe is present");
		    Thread.sleep(10000);
		    waitfortastcompletion();
		}else {
			System.out.println("OpenSpan.Runtime.exe is not present");
		}
		
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	
	@FindBy(xpath="//div[contains(text(),'Close')]")
	WebElement btnClose;
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method allows the user to click on Submit in Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
			return utils.clickAnelemnt(this.btnSubmit, "ResolveOneDayGrievanceAndAppeals", "Submit button");
		
	}
	
	
	public boolean clickOnClose(){
		utils.scrolltomiddle();
			return utils.clickAnelemnt(this.btnClose, "ResolveOneDayGrievanceAndAppeals", "Close button");
		
	}
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;
	
	public void gotoLastIframe(){
		System.out.println("1");
		Driver.getPgDriver().switchTo().defaultContent();
		System.out.println("2");
		int i=this.iframes.size();
		Driver.getPgDriver().switchTo().frame(i-1);
		System.out.println("##########");
	}
	
	@FindBy(xpath="//div[@class='layout layout-noheader layout-noheader-grey_bg_8_px']")
	WebElement validateItemsDiscussed;
	
	@FindBy(xpath="//div[@class='layout layout-noheader layout-noheader-default']//label[text()='Interaction ID']//following::div/span[@data-test-id='20160916102637026797140']")
	WebElement InteractionId;
	
	public boolean validateItemsDiscussed(){
		return !utils.isProxyWebelement(validateItemsDiscussed);
	}
		

}









