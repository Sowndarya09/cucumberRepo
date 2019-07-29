package automationLib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
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

public class RequestEnrollmentandBillingAction extends Driver{

	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);
	public RequestEnrollmentandBillingAction()
	{
		try{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			gotoLastIframe();
			//Driver.getPgDriver().switchTo().defaultContent();
			//Driver.getPgDriver().switchTo().frame(this.Iframeelement1);// change the driver
		}
		catch(Exception e)
		{
			System.out.println("here"+e.toString());
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}


	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement1;
	@FindBy(id="PegaGadget1Ifr")	
	private WebElement Iframeelementtemp;
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;
	@FindBy(id="EnrollmentandBillingSelectionEnrollment")
	private WebElement radioRequestEnrollmentEnrollment;
	@FindBy(id="EnrollmentandBillingSelectionBilling")
	private WebElement radioRequestEnrollmentBilling;
	@FindBy(id="PrimaryReasonforBilling")
	private WebElement drpdwnRequestEnrollmentReasonforContact;
	@FindBy(id="EnrollmentActionType")
	private WebElement drpdwnRequestEnrollmentRequestedAction;

	//@FindBy(xpath="//*[@id='EnrollmentActionType'][@validationtype='required']")
	//private WebElement drpdwnRequestEnrollmentRequestedAction;
	@FindBy(id="BillingActionType")
	WebElement drpdwnRequestEnrollmentBillingRequestedAction;
	@FindBy(id="OverrideDefaultRouting")
	private WebElement chkbxRequestEnrollmentOverride;
	@FindBy(id="OverrideReason")
	private WebElement drpdwnRequestEnrollmentOverrideReason;
	@FindBy(id="EscalationUrgentIndicator")
	private WebElement chkbxRequestEnrollmentUrgent;
	@FindBy (xpath="//div[@node_name='DocumentReferenceNumbers']")
	private WebElement tableRequestEnrollemntDocumentreference;
	@FindBy(xpath="//select[@id='ReasonForRequestExceptionReview']")
	private WebElement drpdwnRequestEnrollmentReasonforUrgent;

	@FindBy(id="BillingEnrollmentNotes")
	private WebElement txtbxRequestEnrollmentNotesSection;
	@FindBy(id="pySelected1")
	WebElement chkbxBillingUncashCoverage;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement labelHeaderTitle;
	/*REQUESTED ACTION
	 * 
	 * DROP DOWN ELEMENTS
	 */

	@FindBy(id="AddNewbornRadioButtonNewborn")
	private WebElement radioEnrollmentAddnewBorn;

	@FindBy(id="AddNewbornRadioButtonDependent")
	private WebElement  radioEnrollmentAddDepedant;

	@FindBy(id="HCID")
	private WebElement txtbxEnrollmentHCID;

	@FindBy(id="DependentsFullName")
	private WebElement txtbxEnrollmentDependantName;

	@FindBy(id="DateOfBirthText")
	private WebElement txtbxEnrollmentDOB;

	@FindBy(id="WEMIDNumber")
	private WebElement txtbxEnrollmentIDNumber;

	@FindBy(id="NewbornsFullName")
	private WebElement txtbxEnrollmentNewBornFullName;

	@FindBy(id="NewbornsGender")
	private WebElement drpdwnEnrollmentGender;

	@FindBy(id="NewbornTypeBiological")
	private WebElement radioEnrollmentBiological;

	@FindBy(id="NewbornTypeAdopted")
	private WebElement radioEnrollmentAdopted;

	@FindBy(id="ContractCode")
	private WebElement txtbxEnrollmentContractCode;

	@FindBy(id="IsPolicyOrMemberPolicy")
	private WebElement radioEnrollmentRequestCancellationPolicy;

	@FindBy(id="IsPolicyOrMemberMember")
	private WebElement radioEnrollmentRequestCancellationMember;

	@FindBy(id="SelectCoverageType")
	private WebElement drpdwnEnrollmentSelectCoverage;

	@FindBy(xpath="//input[contains(@id,'RequestedCancelDate')]")
	private WebElement txtbxEnrollmentCancelDate;

	@FindBy(xpath="//*[@data-test-id='201605242322470999212903']")
	private WebElement txtbxEnrollmentCancelReasonPolicy;

	@FindBy(xpath="//*[@data-test-id='201605242322480004280411']")
	private WebElement txtbxEnrollmentCancelReasonMember;

	@FindBy(id="SelectMemberID")
	private WebElement drpdownEnrollmentMember;

	@FindBy(id="MemberNewName")
	private WebElement txtbxEnrollmentNewName;

	@FindBy(id="UpdateMemberDOB")
	private WebElement txtbxEnrollmentNewDOB;

	@FindBy(id="MemberAddressType")
	private WebElement drpdownEnrollmentAddressType;

	@FindBy(id="InitialPayment")
	private WebElement txtbxBillingInitialPayment;

	@FindBy(id="PaymentAmount")
	private WebElement txtbxBillingInitialPayment1;

	@FindBy(id="InitialPaymentConfirmationNumber")
	private WebElement txtbxBillingInitialPaymentConfirmationNumber;


	@FindBy(id="ConfirmationNumber")
	private WebElement txtbxBillingInitialPaymentConfirmationNumber1;

	@FindBy(id="InitialPaymentReceivedDate")
	private WebElement txtbxBillingInitialPaymentReceivedDate;

	@FindBy(id="MethodOfPaymentInfo")
	private WebElement drpdwnBillingInitialMethodPayment;

	@FindBy(id="MisappliedMethodOfPayment")
	private WebElement drpdwnBillingInitialMethodPayment1;

	@FindBy(id="CheckID")
	private WebElement txtbxBillingCheckID;

	@FindBy(id="ReasonForRequestExceptionReview")
	private WebElement drpdwnBillingReasonForException;
	@FindBy(id="IsPolicyOrMember")
	private WebElement drpdwnBillingPolicyorMember;

	@FindBy(xpath="//*[contains(@id,'DocumentReferenceType')]")
	private WebElement drpdwnDocumentReference;

	@FindBy(xpath="//img[contains(@src,'rpadd')]")
	WebElement imgBillingAddButton;

	@FindBy(id="AddressType1")
	WebElement drpdwnrequestEnrollmentEnrollSummaryBill;

	@FindBy(id="BillingAddress1")
	WebElement txtbxRequestEnrollemntEnrollSummaryBillingAddress;

	@FindBy(id="OverrideReasonOther")
	WebElement txtbxRequestEnrolmentOverrideReason;

	@FindBy(id="MisappliedPaymentReason")
	WebElement txtbxRequestEnrolmentBillingMisappliedReason;

	@FindBy(id="MisappliedPaymentReason")
	WebElement drpdwnRequestEnrolmentBillingMisappliedReason;

	@FindBy(id="RefundAmount")
	WebElement txtbxRequestEnrollmentBillingRefundAmount;

	@FindBy(id="RequestRefundReason")
	WebElement drpdwnRequestEnrollmentBillingRefundReason;

	@FindBy(id="AddressType")
	WebElement drpdwnRequestEnrollmentBillingRefundAddress;

	@FindBy(id="RequestExceptionReviewfalse")
	WebElement drpdwnRequestEnrollmentBillingExceptionReviewNo;

	@FindBy(xpath="//label[@for='IsAB2470']//span")
	WebElement labelIsAB2470message;
	
	@FindBy(xpath="//span[@data-test-id='20170620165645062797638']")
	WebElement labelIsAB2470Newmessage;
	
	

	@FindBy(id="IsAB2470Yes")
	WebElement radioAB2470Yes;
	// Member COMPOSITE 

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;



	public boolean validateRadiobtns()
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Request Enrollment", "Radio Button"))
			return utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "radio buton Billing");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:checkvaluesinReasonContact
	 * Type:Textbox


	 */

	public boolean checkvaluesinReasonContact()
	{
		try{
			List<WebElement> lists = this.drpdwnRequestEnrollmentReasonforContact.findElements(By.tagName("option"));
			System.out.println(lists.size());
			ArrayList<String> dropdownoptions = new ArrayList<String>();
			String[] values={"Did not understand bill","Made a payment not located in system","Policy cancelled unexpectedly","Rate or premium changed","Received unexpected refund","Requested a copy of a document","I am a patient","Requested a refund","Unable to fill prescription"};
			ArrayList<String> valuestobechecked=new ArrayList<String>();
			valuestobechecked.addAll(Arrays.asList(values));
			for(WebElement element: lists)  
			{
				dropdownoptions.add(element.getAttribute("value"));
			}


			for(int i=0;i<values.length;i++)
			{

				if(dropdownoptions.contains(valuestobechecked.get(i)) )
					continue;
				else
				{
					System.out.println("The value "+valuestobechecked.get(i) +" is not present in the applciation drop down");
					return false;
				}
			}

			return true;
		}
		catch(Exception e)
		{
			checkvaluesinReasonContact();
			return true;
		}
	}

	public boolean checkvaluesinReasonforContract(String[] expectedvalues)
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "Billing radio")) {
			ArrayList<String> values=new ArrayList<String>();
			for(String value:expectedvalues)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}

			return utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentReasonforContact,values);
		}
		return false;
	}


	public boolean checkvaluesinEnrollmentRequestedAction(String[] expectedvalues)
	{
		try{
			utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Request Enrollment", "Enrollment Radio button");
			ArrayList<String> values=new ArrayList<String>();
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			for(String value:expectedvalues)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}

			if(utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentRequestedAction,values))
				return true;
			else
				return false;


		}
		catch(Exception e)
		{
			err.logError("request Enrollemnt", "Drop Down");
		}
		return true;
	}

	public boolean checkvaluesinBillingRequestedAction(String[] expectedvalues)
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "Biling Radio button")) {
			utils.waitForElementToBeVisible(drpdwnRequestEnrollmentBillingRequestedAction);
			ArrayList<String> values=new ArrayList<String>();
			for(String value:expectedvalues)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}
			return utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentBillingRequestedAction,values);
		}
		return false;
	}


	public boolean checkvaluesinUrgentReasonRequest(String[] expectedvalues)
	{
		try{
			utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "Billing radio");
			if(!this.chkbxRequestEnrollmentUrgent.isSelected())
			{
				utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent,"Request Enrollment", "Override Reason checkbox");
			}
			ArrayList<String> values=new ArrayList<String>();
			for(String value:expectedvalues)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}

			if(utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentReasonforUrgent,values))
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			err.logError("request Enrollemnt", "Drop Down");
			return false;
		}


	}


	public boolean checkvaluesinOverrideReason(String[] expectedvalues) throws InterruptedException
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "Billing radio"))
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Other", "Request Enrollment and Billing", "Drop down requested action"))
					if( utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent,"Request Enrollment", "Override Reason checkbox"))
						utils.waitforpageload();
		if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride,"Request Enrollment", "Override Reason checkbox")) {
			ArrayList<String> values=new ArrayList<String>();
			for(String value:expectedvalues)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}

			return utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentOverrideReason,values);
		}
		return false;

	}

	public boolean waitforTransactionload()
	{

		try{
			Thread.sleep(2000);
			System.out.println("Checking if Loading icon is present");
			wait=new WebDriverWait(Driver.getPgDriver(),90);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));

		}
		catch(Exception e){
			System.out.println("Loading icon exceeded time out ");

		}
		System.out.println("Came out");
		return true;
	}


	/* FLOW METHODS FOR THE PAGE
	 * 
	 * THE FOLLOWING METHODS DEFINES THE FOLLOW
	 */

	public boolean EnrollmentAddNewBornUrgentOverride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
			wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
		if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Manage Billing", "Reason for Contract drop down"))
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Add Newborn/Dependent", "ManageBilling", "Requested Action dropdown"))
				if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
					if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 2, "Manage Billing", "Urgent Request dropdown"))
						if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
							if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 2, "Manage Billing", "Override dropdown"))
								if(utils.clickAnelemnt(this.radioEnrollmentAddnewBorn, "Request Enrollment", "Add NEw Born Radio button"))
									if(utils.enterTextinAnelemnt(this.txtbxEnrollmentDOB,"01/10/2015", "Request Enrollment", "DOB"))
										utils.setAttribute(this.txtbxEnrollmentDOB,"date-value","01/10/2015");
		if(utils.selectDropDownbyVisibleString(this.drpdwnEnrollmentGender,"Male", "Request Enrollment", "Gender Radio Button"))
			if(utils.clickAnelemnt(this.radioEnrollmentAdopted, "Request Enrollment", "Adopted button"))
				if(utils.enterTextinAnelemnt(this.txtbxEnrollmentNewBornFullName,"Vincent Paul", "Request Enrollment", "New Full Born text Box"))
					if(clickOnSubmit())
						return true;
		return false;
	}

	@SuppressWarnings("deprecation")
	public boolean EnrollmentProcessRenewalUrgent() throws InterruptedException
	{ 
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
			wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
		if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Manage Billing", "Reason for Contract drop down"))
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Process Renewal", "ManageBilling", "Requested Action dropdown"))
				if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
					/*							Assert.assertEquals(true, this.txtbxEnrollmentContractCode.isDisplayed());

							Assert.assertEquals(true, this.txtbxEnrollmentHCID.isDisplayed());
							Assert.assertEquals(true, this.txtbxEnrollmentIDNumber.isDisplayed());*/
					System.out.println("Check the validations ");
		if(clickOnSubmit())	
			return true;
		return false;
	}

	public boolean EnrollmentRequestCancellationOveride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
			wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
		if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 6, "Manage Billing", "Reason for Contract drop down"))
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Request Cancellation", "ManageBilling", "Requested Action dropdown"))
				if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
					if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 4, "Manage Billing", "Override dropdown"))
						if(utils.enterTextinAnelemnt(this.txtbxRequestEnrolmentOverrideReason, "Test", "Request Enrollment", "Override Reason Text Box"))
							if(utils.clickAnelemnt(this.radioEnrollmentRequestCancellationMember, "Request Enrollment", "Add NEw Born Radio button"))
								if(utils.enterTextinAnelemnt(this.txtbxEnrollmentCancelDate,"11/10/2014", "Request Enrollment", "DOB"))
									if(utils.setAttribute(this.txtbxEnrollmentCancelDate,"date-value","11/10/2014"))
										if(clickOnSubmit());
		return true;
	}



	public boolean EnrollmentUpdateAPTC() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
			wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
		if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 5, "Manage Billing", "Reason for Contract drop down"))
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Update APTC/Subsidy", "ManageBilling", "Requested Action dropdown"))
				if(utils.enterTextinAnelemnt(this.txtbxEnrollmentIDNumber, "123456789", "Request Enrollment", "enrollment Number")	)
					if(clickOnSubmit())
						return true;		
		return false;
	}





	public boolean EnrollmentUpdateDemographicsUrgent() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
			wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
		if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 3, "Manage Billing", "Reason for Contract drop down"))
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Update Demographics (Policy/Member)", "ManageBilling", "Requested Action dropdown"))
				if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
					if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 1, "Manage Billing", "Urgent Request dropdown"))
						if(utils.clickAnelemnt(this.radioEnrollmentRequestCancellationMember, "Request Enrollment", "Member radio button"))
							if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
								if(clickOnSubmit())
									return true;	
		return false;

	}					   

	public boolean EnrollmentOtherUrgentOverride() throws InterruptedException 
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
			wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
		if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 4, "Manage Billing", "Reason for Contract drop down"))
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Other", "ManageBilling", "Requested Action dropdown"))
				if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
					if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 3, "Manage Billing", "Urgent Request dropdown"))
						if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
							if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 0, "Manage Billing", "Override dropdown"))
								utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section");
		if(clickOnSubmit());
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:BillingApplyInitialPaymentUrgent
	 * Type:Textbox


	 */

	@FindBy(id="OverrideReason")
	WebElement drpDownOverRideReason;


	public boolean BillingApplyInitialPaymentUrgent() throws InterruptedException
	{
		/** Commented below few lines as per requirement - Gobinath - 01/02/2019
		 * 
		 */
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
			wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Apply Initial Payment", "Request Enrollment", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent,"Request Enrollment", "Code Blue Request"))
						//if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Code Blue Request Checkbox"))              		 
						if(utils.enterTextinAnelemnt(this.txtbxBillingInitialPayment, "$200", "Request Enrollment", "Initial Payment Amount ")) {
							//Driver.pgDriver.findElement(By.xpath("//*[@data-test-id='2015100913580004521633765']")).click();
							//if(utils.clickAnelemnt(this.txtbxBillingInitialPaymentConfirmationNumber, "request Enrollment", "Initial payment confirmation number"))
							if(utils.enterTextinAnelemnt(this.txtbxBillingInitialPaymentConfirmationNumber, "124", "request Enrollment", "Initial payment confirmation number"))
								if(utils.selectDropDownbyVisibleString(this.drpdwnBillingInitialMethodPayment, "Credit Card", "Request Enrollment", "Payment Method")) {
									utils.waitforpageload();
									if(!this.chkbxRequestEnrollmentOverride.isSelected())
										utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride,"Request Enrollment", "Override Reason checkbox");
										if(utils.selectDropDownbyVisibleString(drpDownOverRideReason, "Irate Member", "Request Enrollment", "Override Reason"))
											//}
											if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton")) {
												utils.waitforpageload();
												Driver.getPgDriver().switchTo().defaultContent();
												Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
												if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

													return true;
											}
									
									}
								}
							return false;
						}		


		public boolean BillingApplyInitialPaymentsUrgent() throws InterruptedException
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			if(utils.clickAnelemnt(radioRequestEnrollmentBilling, "RequestEnrollmentAndBilling", "Billing radio button"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));	
				if(utils.selectDropDownbyIndex(drpdwnRequestEnrollmentReasonforContact, 1, "RequestEnrollmentAndBilling", "Reason for Contact"))
					Thread.sleep(2000);
					if(utils.selectDropDownbyIndex(drpdwnRequestEnrollmentBillingRequestedAction, 1, "RequestEnrollmentAndBilling", "Requested Action"))
						if(utils.clickAnelemnt(chkbxRequestEnrollmentUrgent, "RequestEnrollmentAndBilling", "Code Blue Request"))
							if(utils.enterTextinAnelemnt(txtbxBillingInitialPayment, "$10.00", "RequestEnrollmentAndBilling", "Amount"))
								if(utils.enterTextinAnelemnt(txtbxBillingInitialPaymentConfirmationNumber, "0123456789", "RequestEnrollmentAndBilling", "Payment Conformation NUmber"))
									if(utils.selectDropDownbyIndex(drpdwnBillingInitialMethodPayment, 1, "RequestEnrollmentAndBilling", "Method of Payment"))
										if(clickOnSubmit())
											return true;
			return false;
		}

		public boolean BillingApplyUnprocessedCashOverride() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));	
				if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 3, "Request Enrollment", "Reason for Contract drop down"))
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Apply Unprocessed Cash", "Request Enrollment", "Requested Action dropdown"))
				utils.waitforpageload();
				if(!chkbxRequestEnrollmentOverride.isSelected())
					utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox");
			utils.scrolltomiddle();
			//action.moveToElement(drpdwnRequestEnrollmentOverrideReason);
			//utils.waitForElementToBeVisible(drpdwnRequestEnrollmentOverrideReason);
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 1, "Request Enrollment", "Override reason"))
				if(utils.enterTextinAnelemnt(this.txtbxBillingCheckID, "COID12345678912", "Request Enrollment", "CheckID "))
					if(utils.clickAnelemnt(this.chkbxBillingUncashCoverage, "request Enrollment", "Coverage Checkboxr"))
						if(clickOnSubmit())
							return true;											

			return false;
		}	




		public boolean BillingMisappliedPaymentOverride() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Correct Misapplied Payment", "Request Enrollment", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 3, "Request Enrollment", "Override checkbox"))
							if(utils.enterTextinAnelemnt(this.txtbxBillingInitialPayment1, "$200", "Request Enrollment", "Initial Payment Amount "))
								if(utils.enterTextinAnelemnt(this.txtbxBillingInitialPaymentConfirmationNumber1, "124", "request Enrollment", "Initial payment confirmation number"))
									if(utils.selectDropDownbyVisibleString(this.drpdwnBillingInitialMethodPayment1, "Credit Card", "Request Enrollment", "Payment Method"))
										utils.selectDropDownbyIndex(this.drpdwnRequestEnrolmentBillingMisappliedReason, 1, "Request Enrollment", "Reason");
			if(clickOnSubmit())			
				return true;												
			return false;
		}



		public boolean BillingRequestPaymentOverride() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Request Payment History", "Request Enrollment", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 3, "Request Enrollment", "Override checkbox"))
							if(utils.clickAnelemnt(this.chkbxBillingUncashCoverage, "request Enrollment", "Coverage Checkboxr"))
								if(clickOnSubmit())								
									return true;
			return false;
		}

		public boolean BillingRequestHelp() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 7, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Request Help", "Request Enrollment", "Requested Action dropdown"))
					utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section");		   
			if(clickOnSubmit())
				return true;
			return false;
		}


		public boolean BillingProcessRetroactive() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Process Retroactive Cancellation", "Request Enrollment", "Requested Action dropdown"))
					utils.selectDropDownbyIndex(this.drpdwnBillingReasonForException, 1, "Request Enrollment", "Exception Drop Down ");
			if(clickOnSubmit())
				return true;					
			return false;
		}




		public boolean BillingEnrollSummaryBilling() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Enroll in Summary Billing", "Request Enrollment", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.imgBillingAddButton, "Request Enrollment", "Add Button"))
						if(utils.selectDropDownbyIndex(this.drpdwnrequestEnrollmentEnrollSummaryBill, 1, "Request Enrollment", "address type"))
							if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollemntEnrollSummaryBillingAddress, "Test Address", "Request Enrollment", "Address"))
							{
								JavascriptExecutor jse=(JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("arguments[0].scrollIntoView(true);", btnSubmit);
								return utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton");
							}

			return false;
		}



		public boolean BillingChangeEffDateUrgentOverride() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Change Effective Date of Policy/Member", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 3, "Manage Billing", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
								if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 2, "Manage Billing", "Override dropdown"))
									if(utils.selectDropDownbyIndex(this.drpdwnBillingReasonForException, 1, "Request Enrollemnt", "Drop Down Exception Reason"))
										if(utils.selectDropDownbyVisibleString(this.drpdwnBillingPolicyorMember, "Member", "Request Enrollemnt", "Drop Down member-policy"))
											utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section");
			if(clickOnSubmit())
				return true;																			
			return false;	
		}

		public boolean BillingIssueRefundUrgentOverride() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Billing Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 5, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Issue Refund", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "code blue request checkbox"))						
						if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
							if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 1, "Manage Billing", "Override dropdown"))
								if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentBillingRefundAmount, "$500", "Request Enrollemnt", "refund Amount"))
									if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentBillingRefundReason, 1, "Request Enrollemnt", "Issue Refund Reason"))
										utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRefundAddress, "Home", "Request Enrollment", "Notes Section");
			if(clickOnSubmit())
				return true;
			return false;		
		}

		//	BillingInvestigatePremiumUrgent

		public boolean BillingInvestigatePremiumUrgent() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 3, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Investigate Premium Discrepancies", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 2, "Manage Billing", "Urgent Request dropdown"))
							if(clickOnSubmit())
								return true;									
			return false;
		}




		public boolean BillingOtherUrgentOveride() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 5, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Other", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 1, "Manage Billing", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
								if(utils.clickAnelemnt(this.drpdwnRequestEnrollmentBillingExceptionReviewNo, "Manage Billing", "Exception review no"))
									if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollemnt", "Notes Section"))
										if(clickOnSubmit())
											return true;																
			return false;
		}


		//	

		public boolean BillingReinstateMemberUrgent() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Reinstate Member", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Request Enrollment", "code blue request checkbox"))
						if(utils.clickAnelemnt(this.drpdwnRequestEnrollmentBillingExceptionReviewNo, "Request Enrollment", "Urgent Exception No"))
							if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section"))
								//if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
								if(clickOnSubmit())
									/*waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
		if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())*/
									return true;
			return false;
		}

		public boolean BillingReinstateMemberCheckAB2470() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentReasonforContact, "Policy cancelled improperly", "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Reinstate Member", "ManageBilling", "Requested Action dropdown"))
					/*if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Request Enrollment", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 1, "Request Enrollment", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.drpdwnRequestEnrollmentBillingExceptionReviewNo, "Request Enrollment", "Urgent Exception No"))*/
								if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section"))
									if(this.labelIsAB2470Newmessage.getText().toString().contains("AB2470 Request"))
										//if(utils.clickAnelemnt(this.radioAB2470Yes, "Request Enrollment", "Radio Butto Yes"))
											if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
												return true;
			return false;
		}

		//Changes start here for Sprint - 6.2 Orion

		@FindBy(id="IsPolicyOrMemberPolicy")
		WebElement policy_rdoBtn;

		@FindBy(id="IsPolicyOrMemberMember")
		WebElement member_rdoBtn;

		/*
		 * @SCU
		 * #CommonMethodwithArgument:enrollReq_SelectReasonAndActionDrpDown
		 * #Description:This method selects 'Reason for Contact' and 'Requested Action' dropdown options for an Enrollment request in Request Enrollment & Billing Action page.
		 * #Arguments:'Reason for Contact' and 'Requested Action'
		 * Type:Dropdown
		 * Keys:#Did not understand bill#Need to renew Plan#Request policy/member cancellation#Request to add newborn/dependent#Unable to fill prescription#Update address/other demographics#Update my policy/contract
		 * Keys:#Add Newborn/Dependent#Process Renewal#Request Cancellation#Update APTC/Subsidy#Update Demographics (Policy/Member)#Other
		 */
		public boolean enrollReq_SelectReasonAndActionDrpDown(String[] args){
			utils.waitforpageload();
			if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Request Enrollment", "Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PrimaryReasonforBilling")));
			if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentReasonforContact, args[0], "Request Enrollment and Billing Action", "Reason for Contact"))
				return utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, args[1], "Request Enrollment and Billing Action", "Requested Action");
			return false;
		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:selectPolicyOrMemberRadioOption
		 * #Description:This method selects either 'Policy' or 'Member' radio option in Request Enrollment & Billing Action
		 * #Arguments:Policy/Member
		 * Type:Textbox
		 */
		public boolean selectPolicyOrMemberRadioOption(String[] args){
			if((args[0]).trim().equalsIgnoreCase("Policy"))
				return this.clickPolicyRadioBtn();
			else if ((args[0]).trim().equalsIgnoreCase("Member"))
				return this.clickMemberRadioBtn();
			return false;
		}

		/**
		 * Click on Policy radio button - Request Enrollment and Billing Action page 
		 * @return
		 */
		public boolean clickPolicyRadioBtn()
		{
			if(!utils.isProxyWebelement(policy_rdoBtn))
				return utils.clickAnelemnt(this.policy_rdoBtn, "Request Enrollment and Billing Action", "Radio Button for Policy");
			return false;
		}

		/**
		 * Click on Member radio button - Request Enrollment and Billing Action page 
		 * @return
		 */
		public boolean clickMemberRadioBtn()
		{
			if(!utils.isProxyWebelement(member_rdoBtn))
				return utils.clickAnelemnt(this.member_rdoBtn, "Request Enrollment and Billing Action", "Radio Button for Member");
			return false;
		}

		@FindBy(xpath="//*[text()='Request Policy Cancellation']")
		private WebElement hdrRequestPolicyCancellation;

		@FindBy(xpath="//*[@data-test-id='20160516011631003128474-Label']/span")
		private WebElement lbl_HCID;

		@FindBy(xpath="//label[@for='SelectCoverageType']/span")
		private WebElement lbl_SelectContract;

		@FindBy(xpath="//label[@for='WEMIDNumber']")
		private WebElement lbl_WEMIDNumber;


		@FindBy(xpath="//label[@for='RequestedCancelDate']/span")
		private WebElement lbl_RequestedCancelDate;

		@FindBy(xpath="//label[@for='MemberCancellationReason']")
		private WebElement lbl_CancelReason;

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:validateLblsInRequestPolicyCancellationSection
		 * #Description:This method validates the labels displayed in 'Request Policy Cancellation' section
		 * Type:TextBox
		 */
		public boolean validateLblsInRequestPolicyCancellationSection(){
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.hdrRequestPolicyCancellation);
			ArrayList<String> fieldsNotPresent = new ArrayList<String>();
			utils.waitforpageload();

			try{
				if(this.hdrRequestPolicyCancellation.isDisplayed()){blogger.loginfo("Request Policy Cancellation section Header is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "Request Policy Cancellation section Header is not displayed");
				blogger.loginfo("Exception occured:Request Policy Cancellation - section Header is not displayed"+e);
				fieldsNotPresent.add("Request Policy Cancellation Header");
			}

			try{
				if(this.lbl_HCID.isDisplayed()){blogger.loginfo("HCID is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "HCID is not displayed");
				blogger.loginfo("Exception occured:HCID label is not displayed"+e);
				fieldsNotPresent.add("HCID");
			}

			try{
				if(this.lbl_SelectContract.isDisplayed()){blogger.loginfo("Select Contract is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "Select Contract is not displayed");
				blogger.loginfo("Exception occured: Select Contract label is not displayed"+e);
				fieldsNotPresent.add("Select Contract");
			}

			try{
				if(this.lbl_WEMIDNumber.isDisplayed()){blogger.loginfo("WEM/Application ID Number is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "WEM/Application ID Number is not displayed");
				blogger.loginfo("Exception occured:WEM/Application ID Number label is not displayed"+e);
				fieldsNotPresent.add("WEM/Application ID Number");
			}

			try{
				if(this.lbl_RequestedCancelDate.isDisplayed()){blogger.loginfo("Requested Cancel Date is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "Requested Cancel Date is not displayed");
				blogger.loginfo("Exception occured:Requested Cancel Date label is not displayed"+e);
				fieldsNotPresent.add("Requested Cancel Date");
			}

			try{
				if(this.lbl_CancelReason.isDisplayed()){blogger.loginfo("Cancel Reason is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "Cancel Reason is not displayed");
				blogger.loginfo("Exception occured:Cancel Reason label is not displayed"+e);
				fieldsNotPresent.add("Cancel Reason");
			}

			if(fieldsNotPresent.size()>0){
				blogger.loginfo("Fields not present in RequestPolicyCancellation section"+fieldsNotPresent);
				return false;
			}
			return true;
		}


		@FindBy(xpath="//span[text()='Request Member(s) Cancellation']")
		private WebElement hdrRequestMemberCancellation;

		@FindBy(xpath="//div[text()='Select Member(s) ']")
		private WebElement lbl_SelectMember;

		@FindBy(xpath="//label[@for='WEMIDNumber']")
		private WebElement lbl_mWEMIDNumber;

		@FindBy(xpath="//label[@for='RequestedCancelDate']/span")
		private WebElement lbl_mRequestedCancelDate;

		@FindBy(xpath="//label[@for='MemberCancellationReason']")
		private WebElement lbl_mCancelReason;

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:validateLblsInRequestMemberCancellationSection
		 * #Description:This method validates the labels displayed in 'Request Member Cancellation' section
		 * Type:TextBox
		 */
		public boolean validateLblsInRequestMemberCancellationSection(){
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.hdrRequestMemberCancellation);
			ArrayList<String> fieldsNotPresent = new ArrayList<String>();

			try{
				if(this.hdrRequestMemberCancellation.isDisplayed()){System.out.println("Request Member Cancellation section Header is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "Request Member Cancellation section Header is not displayed");
				System.out.println("Exception occured:Request Member Cancellation - section Header is not displayed"+e);
				fieldsNotPresent.add("Request Member Cancellation Header");
			}

			try{
				if(this.lbl_SelectMember.isDisplayed()){System.out.println("Select Member is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "SelectMember is not displayed");
				System.out.println("Exception occured:Select Member label is not displayed"+e);
				fieldsNotPresent.add("Select Member");
			}


			try{
				if(this.lbl_mWEMIDNumber.isDisplayed()){System.out.println("WEM/Application ID Number is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "WEM/Application ID Number is not displayed");
				System.out.println("Exception occured:WEM/Application ID Number label is not displayed"+e);
				fieldsNotPresent.add("WEM/Application ID Number");
			}

			try{
				if(this.lbl_mRequestedCancelDate.isDisplayed()){System.out.println("Requested Cancel Date is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "Requested Cancel Date is not displayed");
				System.out.println("Exception occured:Requested Cancel Date label is not displayed"+e);
				fieldsNotPresent.add("Requested Cancel Date");
			}

			try{
				if(this.lbl_mCancelReason.isDisplayed()){System.out.println("Cancel Reason is displayed");}
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "Cancel Reason is not displayed");
				System.out.println("Exception occured:Cancel Reason label is not displayed"+e);
				fieldsNotPresent.add("Cancel Reason");
			}

			if(fieldsNotPresent.size()>0){
				System.out.println("Fields not present in RequestMemberCancellation section"+fieldsNotPresent);
				return false;
			}
			return true;
		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:selectContractInRequestPolicyCancellationSection
		 * #Description:This method would select the contract in 'Request Policy Cancellation' Section
		 * #Arguments:ContractID
		 * Type:Textbox
		 */
		public boolean selectContractInRequestPolicyCancellationSection(String args[]){
			return utils.selectDropDownbyVisibleString(this.drpdwnEnrollmentSelectCoverage, args[0], "Request Enrollment and Billing Action", "Select Contract");
		}

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:verifyDefaultValueInRequestedCancelDateField
		 * #Description:This method validates the default date which is displayed in 'Requested Cancel Date' to be first of the next month also validated the cancel reason is present.
		 * Type:Textbox
		 */
		public boolean verifyDefaultValueInRequestedCancelDateField(){
			try{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate currentDate = LocalDate.now();
				LocalDate nextMonthStartDate = currentDate.plusMonths(1).withDayOfMonth(1);

				String todayDateTime = currentDate.format(formatter);
				String nextMonthStartDateTime = nextMonthStartDate.format(formatter);
				System.out.println("Current day:Today:"+todayDateTime);
				System.out.println("Next Month Start Date:"+nextMonthStartDateTime);

				//this.txtbxEnrollmentCancelDate.sendKeys(Keys.TAB);
				String defaultDateInUI = this.txtbxEnrollmentCancelDate.getAttribute("value").trim();
				System.out.println("Default Date in UI:"+defaultDateInUI);
				//Retrieve default date which is populated in  'RequestedCancelDate' Field
				if(!utils.isProxyWebelement(this.txtbxEnrollmentCancelReasonMember)){				
					if(defaultDateInUI.matches(nextMonthStartDateTime) || (defaultDateInUI.matches(todayDateTime) && currentDate.getDayOfMonth()==1))

						//System.out.println("Default value in UI matched with Next Month Start Date:"+nextMonthStartDateTime);
						return true;
					else	{
						System.out.println("Default value in UI doesnt match with Next Month Start Date:"+nextMonthStartDateTime);
						err.logError("Request Enrollment and Billing Action", "verifyDefaultValueInRequestedCancelDateField");
						return false;
					}	

				}
				err.logerrormessage("Cancel reason for member is not dipalyed or the elemnt identifier is worng");
				return false;
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "verifyDefaultValueInRequestedCancelDateField");
				System.out.println("Default Value In Requested Cancel Date Field, is not first of next month"+e);
				return false;
			}
		}

		@FindBy(xpath="//span[@id='PegaRULESErrorFlag'][@role='alert']")
		WebElement exceptionMsg;

		@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
		WebElement errMsg;
		/*
		 * @SCU
		 * #CommonMethodwithArgument:enterPriorCancellationDateForOffExchangePolicy
		 * #Description:This method enters a prior date to 'Requested Cancel Date' field and validates the error message displayed - OffExchangePolicy.
		 * #Arguments: Prior 'Requested Cancel Date' and Company name
		 * Type:Textbox
		 */
		public boolean enterPriorCancellationDateForOffExchangePolicy(String args[]){
			String msgTxt = "";
			//Date validation
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate currentDate = LocalDate.now();
			LocalDate nextMonthStartDate = currentDate.plusMonths(1).withDayOfMonth(1);

			//Read the date parameter from script
			String tDate=args[0].toString();
			String todayDateTime = currentDate.format(formatter).toString();
			String nextMonthStartDateTime = nextMonthStartDate.format(formatter).toString();
			LocalDate ld = LocalDate.parse(tDate ,formatter);
			System.out.println("Entered date by user:"+ ld.getDayOfMonth());

			try{
				String selectAll = Keys.chord(Keys.CONTROL,"a");
				Actions action = new Actions(Driver.pgDriver); 
				action.moveToElement(this.txtbxEnrollmentCancelDate).click().sendKeys(selectAll,Keys.BACK_SPACE).build().perform();

				utils.enterTextinAnelemnt(this.txtbxEnrollmentCancelDate, args[0], "Request Enrollment and Billing Action", "Enrollment Cancel Date");
				//this.txtbxEnrollmentCancelDate.sendKeys(Keys.TAB);
				utils.clickAnelemnt(this.txtbxEnrollmentCancelReasonMember, "Request Enrollment and Billing Action", "Cancel Reason");
				Driver.pgDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "enterPriorCancellationDateForOffExchangePolicy");;
				System.out.println("Issue in entering values to fields - PriorCancellationDate For OffExchange Policy"+e);
				return false;
			}

			try {
				System.out.println("Entered date"+sdf.parse(tDate)+"\nTodays Date"+sdf.parse(todayDateTime)+"\nNext Month Date"+sdf.parse(nextMonthStartDateTime));
				//7-day logic 
				if((currentDate.getDayOfMonth()==1||currentDate.getDayOfMonth()==2||currentDate.getDayOfMonth()==3||currentDate.getDayOfMonth()==4||currentDate.getDayOfMonth()==5||currentDate.getDayOfMonth()==6||currentDate.getDayOfMonth()==7) && sdf.parse(tDate).before(sdf.parse(todayDateTime)) && currentDate.getMonthValue()==ld.getMonthValue() && ld.getDayOfMonth()==1){
					//No error message is expected for Request cancellation within first 7 days of month 
					msgTxt = "";
					System.out.println("Validation message to be displayed is"+msgTxt);
				}else if(sdf.parse(tDate).before(sdf.parse(todayDateTime)) || (tDate.matches(todayDateTime) && ld.getDayOfMonth()!=1)){
					msgTxt ="The contact must send in the request to '"+args[1]+"' in writing when requesting a policy be cancelled with a date other than the first of the following month or if today is after the seventh of the current month.";
					System.out.println("Validation message to be displayed is"+msgTxt);
				}else if((tDate.matches(todayDateTime) && ld.getDayOfMonth()==1)||(sdf.parse(tDate).after(sdf.parse(todayDateTime)) && ld.getDayOfMonth()==1)){
					//No error message is expected in this scenario - since Today is 1st of Month or any Future date is first of month. 
					msgTxt = "";
					System.out.println("Validation message to be displayed is"+msgTxt);
				}
				else if(sdf.parse(tDate).after(sdf.parse(todayDateTime)) && ld.getDayOfMonth()!=1){
					msgTxt = "When cancelling a policy, the Cancel Date must be a first of the month.";
					System.out.println("Validation message to be displayed is"+msgTxt);
				}else{
					System.out.print("Invalid date is entered, Please enter valid date");
					return false;
				}
			} catch (ParseException e1) {
				System.out.println("Parse exception occured - Invalid date is entered, Please enter valid date");
				e1.printStackTrace();
			}

			try{

				//			if(this.exceptionMsg.getText().trim().equalsIgnoreCase(msgTxt.trim())){
				if(utils.validateValueinelement(this.exceptionMsg, msgTxt)) {
					System.out.println("Validation message matches for - PriorCancellationDate For OffExchange Policy"+this.exceptionMsg.getText().trim());
					return true;
				}else{
					err.logError("Request Enrollment and Billing Action", "enterPriorCancellationDateForOffExchangePolicy");
					System.out.println("Validation message doesnt match for - PriorCancellationDate For OffExchange Policy"+this.exceptionMsg.getText().trim());
					return false;
				}
			}catch(Exception e){
				System.out.println("No Exception message is displayed:"+e);
				return true;
			}


		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:enterPriorCancellationDateForLegacyPolicy
		 * #Description:This method enters a prior date to 'Requested Cancel Date' field and validates the error message displayed - Legacy Policy.
		 * #Arguments: Prior 'Requested Cancel Date'
		 * Type:Textbox
		 */
		public boolean enterPriorCancellationDateForLegacyPolicy(String args[]){
			String msgTxt = "";
			//Date validation
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate currentDate = LocalDate.now();
			LocalDate nextMonthStartDate = currentDate.plusMonths(1).withDayOfMonth(1);

			//Read the date parameter from script
			String tDate=args[0].toString();
			String todayDateTime = currentDate.format(formatter).toString();
			String nextMonthStartDateTime = nextMonthStartDate.format(formatter).toString();
			LocalDate ld = LocalDate.parse(tDate ,formatter);
			System.out.println("Entered date by user:"+ ld.getDayOfMonth());

			try{
				String selectAll = Keys.chord(Keys.CONTROL,"a");
				Actions action = new Actions(Driver.pgDriver); 
				action.moveToElement(this.txtbxEnrollmentCancelDate).click().sendKeys(selectAll,Keys.BACK_SPACE).build().perform();

				utils.enterTextinAnelemnt(this.txtbxEnrollmentCancelDate, args[0], "Request Enrollment and Billing Action", "Enrollment Cancel Date");
				//this.txtbxEnrollmentCancelDate.sendKeys(Keys.TAB);
				utils.clickAnelemnt(this.txtbxEnrollmentCancelReasonMember, "Request Enrollment and Billing Action", "Cancel Reason");
				Driver.pgDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "enterPriorCancellationDateForLegacyPolicy");;
				System.out.println("Issue in entering values to fields - PriorCancellationDate For Legacy Policy"+e);
				return false;
			}

			try {
				System.out.println("Entered date"+sdf.parse(tDate)+"\nTodays Date"+sdf.parse(todayDateTime)+"\nNext Month Date"+sdf.parse(nextMonthStartDateTime));
				if((currentDate.getDayOfMonth()==1||currentDate.getDayOfMonth()==2||currentDate.getDayOfMonth()==3||currentDate.getDayOfMonth()==4||currentDate.getDayOfMonth()==5||currentDate.getDayOfMonth()==6||currentDate.getDayOfMonth()==7) && sdf.parse(tDate).before(sdf.parse(todayDateTime)) && currentDate.getMonthValue()==ld.getMonthValue() && ld.getDayOfMonth()==1){
					//No error message is expected for Request cancellation within first 7 days of month 
					msgTxt = "";
					System.out.println("Validation message to be displayed is"+msgTxt);
				}else if(sdf.parse(tDate).before(sdf.parse(todayDateTime)) || (tDate.matches(todayDateTime) && ld.getDayOfMonth()!=1)){
					msgTxt ="The contact must send in the request in writing when requesting a policy be cancelled with a date other than first of the following month or if today is the first of the current month. Go to the External Search and log into CCB and select the Service Location to send the request.";
					System.out.println("Validation message to be displayed is"+msgTxt);
				}else if((tDate.matches(todayDateTime) && ld.getDayOfMonth()==1)||(sdf.parse(tDate).after(sdf.parse(todayDateTime)) && ld.getDayOfMonth()==1)){
					//No error message is expected in this scenario - since Today is 1st of Month or any Future date is first of month. 
					msgTxt = "";
					System.out.println("Validation message to be displayed is"+msgTxt);
				}
				else if(sdf.parse(tDate).after(sdf.parse(todayDateTime))&& ld.getDayOfMonth()!=1){
					msgTxt = "When cancelling a policy, the Cancel Date must be a first of the month.";
					System.out.println("Validation message to be displayed is"+msgTxt);
				}else{
					System.out.print("Invalid date is entered, Please enter valid date");
					return false;}
			}catch (ParseException e1) {
				System.out.println("Parse exception occured - Invalid date is entered, Please enter valid date");
				e1.printStackTrace();
			}
			try{
				if(this.exceptionMsg.getText().trim().equalsIgnoreCase(msgTxt)){
					System.out.println("Validation message matches for - PriorCancellationDate For Legacy Policy"+this.exceptionMsg.getText().trim());
					return true;
				}else{
					err.logError("Request Enrollment and Billing Action", "enterPriorCancellationDateForLegacyPolicy");
					System.out.println("Validation message doesnt match for - PriorCancellationDate For Legacy Policy"+this.exceptionMsg.getText().trim());
					return false;
				}
			}catch(Exception e){
				System.out.println("No Exception message is displayed:"+e);
				return true;
			}
		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:enterFutureDateNotInFirstOfMonth
		 * #Description:This method enters a future date to 'Requested Cancel Date' field, which is not first of next month and validates the message displayed - Off Exchange and Legacy Policy.
		 * #Arguments: Future 'Requested Cancel Date'
		 * Type:Textbox
		 */
		public boolean enterFutureDateNotInFirstOfMonth(String args[]){

			String msgTxt = "";
			//Date validation
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate currentDate = LocalDate.now();
			LocalDate nextMonthStartDate = currentDate.plusMonths(1).withDayOfMonth(1);

			//Read the date parameter from script
			String tDate=args[0].toString();
			String todayDateTime = currentDate.format(formatter).toString();
			String nextMonthStartDateTime = nextMonthStartDate.format(formatter).toString();
			LocalDate ld = LocalDate.parse(tDate ,formatter);
			blogger.loginfo("Entered date by user:"+ ld.getDayOfMonth());

			try{
				String selectAll = Keys.chord(Keys.CONTROL,"a");
				Actions action = new Actions(Driver.pgDriver); 
				action.moveToElement(this.txtbxEnrollmentCancelDate).click().sendKeys(selectAll,Keys.BACK_SPACE).build().perform();
				utils.enterTextinAnelemnt(this.txtbxEnrollmentCancelDate, args[0], "Request Enrollment and Billing Action", "Enrollment Cancel Date");
				utils.clickAnelemnt(this.txtbxEnrollmentCancelReasonMember, "Request Enrollment and Billing Action", "Cancel Reason");
				Driver.pgDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			}catch(Exception e){
				err.logError("Request Enrollment and Billing Action", "enterFutureDateNotInFirstOfMonth");;
				blogger.loginfo("Issue in entering values to fields - Future Date Not In First Of Month"+e);
				return false;
			}

			try {
				blogger.loginfo("Entered date"+sdf.parse(tDate)+"\nTodays Date"+sdf.parse(todayDateTime)+"\nNext Month Date"+sdf.parse(nextMonthStartDateTime));
				if(sdf.parse(tDate).after(sdf.parse(todayDateTime))&& ld.getDayOfMonth()!=1){
					msgTxt = "When cancelling a policy, the Cancel Date must be a first of the month.";
				}else if((tDate.matches(todayDateTime) && ld.getDayOfMonth()==1) || (sdf.parse(tDate).after(sdf.parse(todayDateTime)) && ld.getDayOfMonth()==1)){
					blogger.loginfo("It is Todays' date or Future Date entered is first of month");
					msgTxt = "";
				}else{
					blogger.loginfo("Invalid date is entered, Please enter valid date to this method");
					return false;}
			}catch (ParseException e1) {
				blogger.loginfo("Parse exception occured- Invalid date is entered, Please enter valid date to this method");
				e1.printStackTrace();
			}

			try{
				if(this.exceptionMsg.getText().trim().equalsIgnoreCase(msgTxt)){
					blogger.loginfo("Validation message matches for - Future Date Not In First Of Month"+this.exceptionMsg.getText().trim());
					return true;
				}else{
					err.logError("Request Enrollment and Billing Action", "enterFutureDateNotInFirstOfMonth");
					blogger.loginfo("Validation message doesnt match for - Future Date Not In First Of Month"+this.exceptionMsg.getText().trim());
					return false;
				}
			}catch(Exception e){
				blogger.loginfo("No Exception message is displayed:"+e+ "Future Date entered is first of month");
				return true;
			}

		}

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:performSubmitWithPriorDate
		 * #Description:This method performs submit action with prior date entered in 'Requested Cancel Date' field, and validates the message displayed - Off Exchange and Legacy Policy.
		 * Type:Textbox
		 */
		public boolean performSubmitWithPriorDate(){

			if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment and Billing Action", "Submit Button")){
				utils.waitforpageload();

				String msgTxt = "Billing Action Data:** Go to Other Actions and select Complete Billing Review to submit this request or correct the Requested Cancel Date.";
				utils.waitforpageload();
				return utils.isvalueMatch_contain(errMsg.getText(), msgTxt);
			}
			return false;
		}

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:performSubmitWithFutureDate
		 * #Description:This method performs submit action with future date entered in 'Requested Cancel Date' field, and validates the message displayed - Off Exchange and Legacy Policy.
		 * Type:Textbox
		 */
		public boolean performSubmitWithFutureDate() throws ParseException{

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate currentDate = LocalDate.now();
			String todayDateTime = currentDate.format(formatter).toString();
			String enrolCancelDate = this.txtbxEnrollmentCancelDate.getAttribute("value").trim();
			LocalDate ld = LocalDate.parse(enrolCancelDate ,formatter);

			if(sdf.parse(enrolCancelDate).after(sdf.parse(todayDateTime)) && ld.getDayOfMonth()!=1){
				try{
					utils.clickAnelemnt(this.btnSubmit, "Request Enrollment and Billing Action", "Submit Button");
					utils.waitforpageload();
					String msgTxt = "Billing Action Data:** Go to Other Actions and select Complete Billing Review to submit this request or correct the Requested Cancel Date.";
					if(this.errMsg.getText().trim().equalsIgnoreCase(msgTxt)){
						System.out.println("Validation message matches on Submit for - Submit With Future Date"+this.errMsg.getText().trim());
						return true;
					}else{
						err.logError("Request Enrollment and Billing Action", "performSubmitWithFutureDate");
						System.out.println("Validation message doesnt matches on Submit for - Submit With Future Date"+this.errMsg.getText().trim());
						return false;
					}
				}catch(Exception e){
					err.logError("Request Enrollment and Billing Action", "performSubmitWithFutureDate");
					System.out.println("Issue in clicking submit - Submit With Future Date"+e);
					return false;
				}

			}else if(sdf.parse(enrolCancelDate).after(sdf.parse(todayDateTime)) && ld.getDayOfMonth()==1){
				System.out.println("Future Date entered is first of month");
				try{
					utils.clickAnelemnt(this.btnSubmit, "Request Enrollment and Billing Action", "Submit Button");
					utils.waitforpageload();
					if(this.exceptionMsg.isDisplayed()){
						System.out.println("Submit failed with Default Cancellation Date");
						err.logError("Request Enrollment and Billing Action", "performSubmitWithFutureDate");
						return false;
					}else 
						return true;

				}catch(Exception e){
					System.out.println("Submit successful with \"Future Date entered is first of month\" Cancellation Date"+e);
					return true;
				}
			}else{
				System.out.print("Invalid date is entered, Please enter valid date to this method");
				return false;
			}		

		}

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:performSubmitWithDefaultCancellationDate
		 * #Description:This method performs action with default date populated in 'Requested Cancel Date' field, and validates no message is displayed - Off Exchange and Legacy Policy.
		 * Type:Textbox
		 */
		public boolean performSubmitWithDefaultCancellationDate(){
			if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment and Billing Action", "Submit Button"))
				return utils.isProxyWebelement(exceptionMsg);
			return false;
		}

		@FindBy(xpath="//div[text()='Refer contact back to the Exchange for any policy changes.']")
		WebElement onExchangeTextMsg;
		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:validateOnExchangePolicyORMemberMsgOnCancel
		 * #Description:This method validates message is displayed while cancelling Enrollment - On Exchange [Policy or Member]
		 * Type:Textbox
		 */
		public boolean validateOnExchangePolicyORMemberMsgOnCancel(){
			return !utils.isProxyWebelement(onExchangeTextMsg);
		}

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:verifyNoSectionDisplayForOnExchangePolicy
		 * #Description:This method validates that no sections are displayed while cancelling Enrollment - On Exchange [Policy].
		 * Type:Textbox
		 */
		public boolean verifyNoSectionDisplayForOnExchangePolicy(){
			return !utils.isProxyWebelement(hdrRequestPolicyCancellation);	
		}

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:verifyNoSectionDisplayForOnExchangeMember
		 * #Description:This method validates that no sections are displayed while cancelling Enrollment - On Exchange [Member].
		 * Type:Textbox
		 */
		public boolean verifyNoSectionDisplayForOnExchangeMember(){
			try{
				if(this.hdrRequestMemberCancellation.isDisplayed()){
					err.logError("Request Enrollment and Billing Action", "verifyNoSectionDisplayForOnExchangeMember");
					System.out.println("Request Member Cancellation section Header is displayed");
					return false;
				}else{
					return true;
				}
			}catch(Exception e){
				System.out.println("Sections are not displayed while cancelling Enrollment - On Exchange [Member]."+e);
				return true;
			}
		}

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:performSubmitForOnExchange
		 * #Description:This method performs submit action for an OnExchange Policy/Member and validates for the message displayed.
		 * Type:Textbox
		 */
		public boolean performSubmitForOnExchange(){
			if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment and Billing Action", "Submit Button"))
				utils.waitforpageload();
			String msgTxt = "Go to Other Actions and select Complete Billing Review to submit this request and refer contact back to the Exchange for any policy changes.";
			return utils.isvalueMatch_contain(errMsg.getText().trim(), msgTxt);

		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:verifyMembersInSelectMemberSection
		 * #Description:This method would verify the members displayed in 'Select Member' Section
		 * #Arguments:Member names should be entered by comma separated values
		 * Type:Textbox
		 */
		public boolean verifyMembersInSelectMemberSection(String args[]){
			utils.waitforpageload();
			if(retrieveMemberInSelectMemberSection(this.selectMemberTable,args))
				return true;
			else
				err.logError("Request Enrollment and Billing Action", "verifyMembersInSelectMemberSection");
			return false;
		}

		@FindBy(xpath="//table[@pl_prop='.EANDBCancelMemberList']")
		private WebElement selectMemberTable;
		/*
		 * @SCU
		 * #CommonMethodwithArgument:verifyActiveMembersInSelectMemberSection
		 * #Description:This method would verify the active members displayed in 'Select Member' Section and ensure checkbox is enabled.
		 * #Arguments:Active Member names should be entered by comma separated values
		 * Type:Textbox
		 */
		public boolean verifyActiveMembersInSelectMemberSection(String args[]){
			utils.waitforpageload();
			if(checkActiveMember(this.selectMemberTable,args))
				return true;
			else
				err.logError("Request Enrollment and Billing Action", "verifyActiveMembersInSelectMemberSection");
			return false;
		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:verifyInActiveMembersInSelectMemberSection
		 * #Description:This method would verify the Inactive members displayed in 'Select Member' Section and ensure checkbox is disabled.
		 * #Arguments:InActive Member names should be entered by comma separated values
		 * Type:Textbox
		 */
		public boolean verifyInActiveMembersInSelectMemberSection(String args[]){
			utils.waitforpageload();
			if(checkInActiveMember(this.selectMemberTable,args)){
				return true;
			}else{
				err.logError("Request Enrollment and Billing Action", "verifyInActiveMembersInSelectMemberSection");
				System.out.println("InActive Member names entered do not match");
				return false;
			}
		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:verifyDefaultMemberSelection
		 * #Description:This method would verify the default active member selected in 'Select Member' Section.
		 * #Arguments:Member name
		 * Type:Textbox
		 */
		public boolean verifyDefaultMemberSelection(String args[]){
			utils.waitforpageload();
			if(retrieveDefaultMembers(this.selectMemberTable,args))
				return true;
			else
				err.logError("Request Enrollment and Billing Action", "verifyDefaultMemberSelection");
			return false;				
		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:selectMemberInSelectMemberSection
		 * #Description:This method would select a member in 'Select Member' Section.
		 * #Arguments:Member name
		 * Type:Textbox
		 */
		public boolean selectMemberInSelectMemberSection(String args[]){
			if(selectMember(this.selectMemberTable,args))
				return true;
			else
				err.logError("Request Enrollment and Billing Action", "selectMemberInSelectMemberSection");
			return false;
		}

		public boolean retrieveMemberInSelectMemberSection(WebElement table,String[] tablevalues){
			ArrayList<String> matchedList = new ArrayList<String>();
			ArrayList<String> unmatchedList = new ArrayList<String>();
			List<String> s = new ArrayList<String>(Arrays.asList(tablevalues));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));

			for (WebElement row : allRows) {
				List<WebElement> allColsByRow=null;
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));
					String text = allColsByRow.get(2).getText().trim();
					String name = text.substring(0,text.indexOf("-"));
					if(s.contains(name)){                
						System.out.println("Name matched:"+allColsByRow.get(2).getText());
						matchedList.add(name);
					}else{
						System.out.println("Values not entered in search, but present in UI:"+name);
						unmatchedList.add(name);
					}        	
				}catch(Exception e){
					continue;
				}
			}
			/*if(unmatchedList.size()==0){
		 		System.out.println("unMatched List is empty");
		 		if(matchedList.size()>0 && matchedList.size()==s.size()){
		 			System.out.println("All Matched Names"+matchedList);
					return true;
		 		}
		 	}

			if(unmatchedList.size()>0){
		 		System.out.println("Please ensure valid member names are entered::unMatched Names"+unmatchedList);
		 		return false;
		 	}*/
			if(!matchedList.isEmpty()){
				System.out.println("Matched Names::"+matchedList);
				return true;
			}else{
				System.out.println("No entered value(s)"+tablevalues+" matched in UI::"+unmatchedList);
				return false;
			}
		}

		public boolean retrieveDefaultMembers(WebElement table,String[] tablevalues){
			ArrayList<String> defaultMemList = new ArrayList<String>();
			ArrayList<String> disabledList = new ArrayList<String>();
			ArrayList<String> invalidList = new ArrayList<String>();
			List<String> s = new ArrayList<String>(Arrays.asList(tablevalues));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));

			for (WebElement row : allRows) {
				List<WebElement> allColsByRow=null;
				String name, text="";
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));
					text = allColsByRow.get(2).getText().trim();
					name = text.substring(0,text.indexOf("-"));
					if(s.contains(name)){ 
						System.out.println("Name matched:"+allColsByRow.get(2).getText());
						try{
							String Ischecked = allColsByRow.get(1).findElement(By.xpath(".//input[@type='checkbox']")).getAttribute("checked");
							if(Ischecked.equalsIgnoreCase("true")){
								defaultMemList.add(name);
								System.out.println("Default Member on load: Selected is"+name);
							}
						}catch(Exception e){
							disabledList.add(name);
							System.out.println("Active member who aren't checked or Inactive member appear disabled:"+name);
							continue;
						}
					}else{
						System.out.println("Name appears in UI, but not in 'Default Member' input:"+name);
						invalidList.add(name);
					}        	
				}catch(Exception e){
					continue;
				}
			}

			if(disabledList.size()>0){
				System.out.println("Active member who aren't checked or Inactive appear disabled::"+disabledList);
			}

			if(invalidList.size()>0){
				System.out.println("Name appears in UI, but not in 'Default Member' input:"+invalidList);
			}
			if(disabledList.size()==0){
				if(defaultMemList.size()>0 && defaultMemList.size()==s.size()){
					System.out.println("Default Member on load: Selected is"+defaultMemList);
					return true;
				}
			}

			return false;
		}

		public boolean checkActiveMember(WebElement table,String[] tablevalues){
			ArrayList<String> inactiveMemList = new ArrayList<String>();
			ArrayList<String> activeMemList = new ArrayList<String>();
			ArrayList<String> invalidInputList = new ArrayList<String>();
			List<String> s = new ArrayList<String>(Arrays.asList(tablevalues));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));

			for (WebElement row : allRows) {
				List<WebElement> allColsByRow=null;
				String name, text="";
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));
					text = allColsByRow.get(2).getText().trim();
					name = text.substring(0,text.indexOf("-"));
					if(s.contains(name)){ 
						System.out.println("Name matched:"+allColsByRow.get(2).getText());
						try{
							String Isdisabled = allColsByRow.get(1).findElement(By.xpath(".//input[@type='checkbox']")).getAttribute("disabled");
							if(Isdisabled.equalsIgnoreCase("true")){
								inactiveMemList.add(name);
								System.out.println("Inactive Member on load is:"+name);
							}
						}catch(Exception e){
							activeMemList.add(name);
							System.out.println("Active member is present in Data entered:"+name);
							continue;
						}
					}else{
						System.out.println("Other Name's appearing in UI, but not in 'Active' input:"+name);
						invalidInputList.add(name);
					} 
				}catch(Exception e){
					continue;
				}
			}

			if(inactiveMemList.size()>0){
				System.out.println("InActive member is present in Data entered::"+inactiveMemList);
			}

			if(invalidInputList.size()>0){
				System.out.println("Other Name's appearing in UI::"+invalidInputList);
			}
			if(inactiveMemList.size()==0){
				if(activeMemList.size()>0 && activeMemList.size()==s.size()){
					System.out.println("Active Member on load is::"+activeMemList);
					return true;
				}
			}
			return false;
		}

		public boolean checkInActiveMember(WebElement table,String[] tablevalues){
			ArrayList<String> inactiveMemList = new ArrayList<String>();
			ArrayList<String> activeMemList = new ArrayList<String>();
			ArrayList<String> invalidInputList = new ArrayList<String>();
			List<String> s = new ArrayList<String>(Arrays.asList(tablevalues));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));

			for (WebElement row : allRows) {
				List<WebElement> allColsByRow=null;
				String name, text="";
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));
					text = allColsByRow.get(2).getText().trim();
					name = text.substring(0,text.indexOf("-"));
					if(s.contains(name)){ 
						System.out.println("Name matched:"+allColsByRow.get(2).getText());
						try{
							String Isdisabled = allColsByRow.get(1).findElement(By.xpath(".//input[@type='checkbox']")).getAttribute("disabled");
							if(Isdisabled.equalsIgnoreCase("true")){
								inactiveMemList.add(name);
								System.out.println("Inactive Member on load is:"+name);
							}
						}catch(Exception e){
							activeMemList.add(name);
							System.out.println("Active member is present in Data entered:"+name);
							continue;
						}
					}else{
						System.out.println("Other Name appearing in UI, but not in 'InActive' input:"+name);
						invalidInputList.add(name);
					} 
				}catch(Exception e){
					continue;
				}
			}

			if(activeMemList.size()>0){
				System.out.println("Active member is present in Data entered::"+activeMemList);
			}

			if(invalidInputList.size()>0){
				System.out.println("Other Name's appearing in UI::"+invalidInputList);
			}
			if(activeMemList.size()==0){
				if(inactiveMemList.size()>0 && inactiveMemList.size()==s.size()){
					System.out.println("Inactive Member on load is::"+inactiveMemList);
					return true;
				}
			}
			return false;
		}

		public boolean selectMember(WebElement table,String[] tablevalues){
			ArrayList<String> inactiveMemList = new ArrayList<String>();
			ArrayList<String> activeMemList = new ArrayList<String>();
			ArrayList<String> uiList = new ArrayList<String>();
			List<String> s = new ArrayList<String>(Arrays.asList(tablevalues));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));

			for (WebElement row : allRows) {
				List<WebElement> allColsByRow=null;
				String name, text="";
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));
					text = allColsByRow.get(2).getText().trim();
					name = text.substring(0,text.indexOf("-"));
					if(s.contains(name)){ 
						System.out.println("Name matched:"+allColsByRow.get(2).getText());
						try{
							String Isdisabled = allColsByRow.get(1).findElement(By.xpath(".//input[@type='checkbox']")).getAttribute("disabled");
							if(Isdisabled.equalsIgnoreCase("true")){
								System.out.println("The member is Inactive:"+name);
								inactiveMemList.add(name);
							}
						}catch(Exception e){
							allColsByRow.get(1).findElement(By.xpath(".//input[@type='checkbox']")).click();
							System.out.println("Active member is clicked:"+name);
							activeMemList.add(name);
							continue;
						}
					}else{
						System.out.println("Other Name's appearing in UI, but not in 'Active' input:"+name);
						uiList.add(name);
					} 
				}catch(Exception e){
					continue;
				}
			}
			if(inactiveMemList.size()>0){
				System.out.println("InActive member is present in Data entered::"+inactiveMemList);
			}

			if(uiList.size()>0){
				System.out.println("Other Name's appearing in UI::"+uiList);
			}
			if(inactiveMemList.size()==0){
				if(activeMemList.size()>0 && activeMemList.size()==s.size()){
					System.out.println("Active Member selected::"+activeMemList);
					return true;
				}
			}
			return false;
		}

		@FindBy(id="WEMIDNumber")
		private WebElement txtbxWEMApplicationIDNumber;
		/*
		 * @SCU
		 * #CommonMethodwithArgument:enterWEMIDNumberForMemberSelection
		 * #Description:This method enters value to WEMIDNumber field on member selection
		 * #Arguments:WEMIDNumber
		 * Type:Textbox
		 */
		public boolean enterWEMIDNumberForMemberSelection(String args[]){
			return utils.enterTextinAnelemnt(this.txtbxWEMApplicationIDNumber, args[0], "RequestEnrollmentandBillingAction", "WEM/Application ID Number");
		}

		/*
		 * @SCU
		 * #CommonMethodwithoutArgument:clickOnSubmit
		 * #Description:This method clicks on submit button in Request Enrollment and Billing page and verifies if membercomposite page is reached
		 * Type:Textbox
		 */
		public boolean clickOnSubmit()
		{	
			utils.scrolltomiddle();
			if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment and Billing Action", "Submit Button"))
				return isMemberCompositeReached();
			return false;
		}


		public boolean EnrollmentUpdateAPTCWithNotes() throws InterruptedException
		{
			if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
				wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 5, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Update APTC/Subsidy", "ManageBilling", "Requested Action dropdown"))
					if(utils.enterTextinAnelemnt(this.txtbxEnrollmentIDNumber, "123456789", "Request Enrollment", "enrollment Number")	)
						if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section"))		   
							if(clickOnSubmit())
								return true;
			return false;
		}

		//Sprint 3.2

		@FindBy(id="BillingEnrollmentNotes")
		WebElement txtBillingNotes;

		/*
		 * @SCU
		 * #CommonMethodwithArgument:enrollBilling_SelectReasonAndActionDrpDown
		 * #Description:This method selects 'Reason for Contact' and 'Requested Action' dropdown options for an Billing request in Request Enrollment & Billing Action page.
		 * #Arguments:'Reason for Contact' and 'Requested Action'
		 * Type:Dropdown
		 * Keys:#Did not understand bill#Need to renew Plan#Request policy/member cancellation#Request to add newborn/dependent#Unable to fill prescription#Update address/other demographics#Update my policy/contract
		 * Keys:#Add Newborn/Dependent#Process Renewal#Request Cancellation#Update APTC/Subsidy#Update Demographics (Policy/Member)#Other
		 */
		public boolean enrollBilling_SelectReasonAndActionDrpDown(String[] args){
			utils.waitforpageload();
			if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Billing", "Radio Button"))
				//wait=new WebDriverWait(Driver.pgDriver,20);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PrimaryReasonforBilling")));
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentReasonforContact, args[0], "Request Enrollment and Billing Action", "Reason for Contact"))					
					if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, args[1], "Request Enrollment and Billing Action", "Requested Action"))
						return utils.enterTextinAnelemnt(this.txtBillingNotes, args[2], "Request Enrollment and Billing Action", "Notes");
			return false;
		}


		//Sprint 4.1

		@FindBy(id="EscalationUrgentIndicator")
		WebElement chckBxCodeBlueRequest;

		@FindBy(xpath="//span[contains(text(),'Code Blue')]")
		WebElement labelCodeBlueMsg;

		@FindBy(xpath="//div[@node_name='CPMCoachingTipDialogWrapper']//div[@id='DialogContent']")
		WebElement labelGuidedDialog;

		public boolean verifyTheGuidedDialougeToRemindWhenToSelectCodeBlue()
		{
			System.out.println("Dialog: "+labelGuidedDialog.getText());
			return utils.validateLabel(labelGuidedDialog, "Provide as much information as you can to help enrollment or billing complete your request.");
		}


		public boolean selectCodeBlueRequestCheckBoxOnTheRequestEnrollAndBillingActionPage()
		{
			return utils.clickAnelemnt(chckBxCodeBlueRequest, "Request Enrollment and Billing Action", "Code Blue Request");
		}


		public boolean verifyCodeBlueRequestTextIsDisplayedOnTheRequestEnrollAndBillingActionPage()
		{
			return !utils.isProxyWebelement(labelCodeBlueMsg);
		}


		public boolean verifyTheDefaultInstructionalTextWhenCodeBlueRequestIsChecked()
		{
			String actualText = "Code Blue request is selected only when a member needs medical care or a prescription within 24 hours.";
			String expectedText = labelCodeBlueMsg.getText().trim();
			System.out.println("Exopected: "+expectedText);
			return utils.isvalueMatch_contain(actualText, expectedText);
		}

		//Sprint 4.2

		public boolean verifyEnrollmentRadioButtonPreSelected()
		{
			try
			{
				boolean bol = radioRequestEnrollmentEnrollment.isSelected();
				System.out.println("Bol: "+bol);
				if(bol==true)
				{
					blogger.loginfo("Enrollment is Pre-Selected");
					System.out.println("Enrollment is Pre-Selected");
					return true;
				}
			}catch(Exception e)
			{
				blogger.loginfo("Enrollment is not Pre-Selected");
				System.out.println("Enrollment is not Pre-Selected");
				return false;
			}
			return false;
		}

		@FindBy(xpath="//span[contains(text(),'Document References')]")
		WebElement collapseIndicatorDocumentReference;

		@FindBy(xpath="//a[@data-test-id='20151010172625047270589']")
		WebElement lnkAddIconInDocReference;

		@FindBy(xpath="//*[contains(@id,'DCNDocumentIDIndicator')]")
		WebElement txtBxDCNDocumentIDIndicator1;

		@FindBy(xpath="//div[@title='Disclose Document References']")
		WebElement lnkDRpDownReference;

		public boolean selectNewBornGender()
		{
			return utils.selectDropDownbyVisibleString(drpdwnEnrollmentGender, "Male", "RequestEnrollmentAndBillingAction", "Gender");
		}

		public boolean performSubmitActionOnRequestEAndBActionPageForRouting(String[] args) throws InterruptedException
		{
			if(utils.selectDropDownbyVisibleString(drpdwnRequestEnrollmentReasonforContact, args[0], "RequestEnrollmentAndBillingAction", "Reason For Contact"))
				if(utils.selectDropDownbyVisibleString(drpdwnRequestEnrollmentRequestedAction, args[1], "RequestEnrollmentAndBillingAction", "Requested Action"))
					if(utils.enterTextinAnelemnt(txtbxEnrollmentNewBornFullName, args[2], "RequestEnrollmentAndBillingAction", "New Born's Full Name"))
						if(utils.enterTextinAnelemnt(txtbxEnrollmentDOB, args[3], "RequestEnrollmentAndBillingAction", "DOB"))
							Thread.sleep(5000);
			if(utils.clickAnelemnt(radioEnrollmentBiological, "RequestEnrollmentAndBillingAction", "Biological"))
				if(selectNewBornGender())
					utils.clickAnelemnt(lnkDRpDownReference, "RequestEnrollmentAndBillingAction", "Drop Down Reference");
			if(utils.clickAnelemnt(lnkAddIconInDocReference, "RequestEnrollmentAndBillingAction", "Add Icon"))
				if(utils.selectDropDownbyVisibleString(drpdwnDocumentReference, args[4], "RequestEnrollmentAndBillingAction", "Document Type"))
					if(utils.enterTextinAnelemnt(txtBxDCNDocumentIDIndicator1, args[5], "RequestEnrollmentAndBillingAction", "Documnet Number"))
						return true;
			return false;
		}

		public boolean selectGender(String[] args)
		{
			return utils.selectDropDownbyVisibleString(drpdwnEnrollmentGender, args[0], "RequestEnrollmentAndBillingAction", "Gender");
		}

		/**
		 * This methods selects the reason for contact values on Request E and B Action page
		 * @param args
		 * @return
		 */

		public boolean selectReasonForContact(String[] args)
		{
			return utils.selectDropDownbyVisibleString(drpdwnRequestEnrollmentReasonforContact, args[0], "RequestEnrollmentAndBillingAction", "Rewson For Contact");
		}

		public boolean selectRequestedAction(String[] args)
		{
			return utils.selectDropDownbyVisibleString(drpdwnRequestEnrollmentRequestedAction, args[0], "RequestEnrollmentAndBillingAction", "Requested Action");
		}

		public boolean clickUrgentRequestCheckBox()
		{
			return utils.clickAnelemnt(chkbxRequestEnrollmentUrgent, "RequestEnrollmentAndBillingAction", "Urgent Checkbox");
		}

		public boolean selectReasonForUrgentRequest(String[] args)
		{
			return utils.selectDropDownbyVisibleString(drpdwnRequestEnrollmentReasonforUrgent, args[0], "RequestEnrollmentAndBillingAction", "Urgent Request Drop Down");
		}

		public boolean selectNewGender(String[] args)
		{
			return utils.selectDropDownbyVisibleString(drpdwnEnrollmentGender, args[0], "RequestEnrollmentAndBillingAction", "Urgent Request Drop Down");
		}

		public boolean clickAddInDocReference()
		{
			return utils.clickAnelemnt(lnkAddIconInDocReference, "RequestEnrollmentAndBillingAction", "Add Link");
		}

		public boolean selectDocType(String[] args)
		{
			return utils.selectDropDownbyVisibleString(drpdwnDocumentReference, args[0], "RequestEnrollmentAndBillingAction", "Document TYpe");
		}

		public boolean enterDocRefNumber(String[] args)
		{
			return utils.enterTextinAnelemnt(txtBxDCNDocumentIDIndicator1, args[0], "RequestEnrollmentAndBillingAction", "Document Number");
		}



		//Sprint 4.4

		@FindBy(id="HCID")
		WebElement txtBxHCID;

		@FindBy(id="UpdateMemberDOB")
		WebElement txtBxDOB;

		@FindBy(id="SelectMemberID")
		WebElement drpDownMemberID;

		@FindBy(id="MemberID")
		WebElement txtBxMemberName;


		public boolean updateMemberDemographicNameDetails(String[] args)
		{
			txtBxHCID.clear();
			if(utils.enterTextinAnelemnt(txtBxHCID, args[0], "RequestEnrollmentAndBillingAction", "HCID"))
				if(utils.enterTextinAnelemnt(txtBxMemberName, args[1], "RequestEnrollmentAndBillingAction", "Name"))
					if(utils.selectDropDownbyVisibleString(drpDownMemberID, args[2], "RequestEnrollmentAndBillingAction", "Member ID"))
						return true;
			return false;
		}

		public boolean updateMemberDemographicGenderDetails(String[] args)
		{
			txtBxHCID.clear();
			if(utils.enterTextinAnelemnt(txtBxHCID, args[0], "RequestEnrollmentAndBillingAction", "HCID"))
				if(utils.selectDropDownbyVisibleString(drpdwnEnrollmentGender, args[1], "RequestEnrollmentAndBillingAction", "Gender"))
					if(utils.selectDropDownbyVisibleString(drpDownMemberID, args[2], "RequestEnrollmentAndBillingAction", "Member ID"))
						return true;
			return false;
		}

		public boolean updateMemberDemographicDOBDetails(String[] args)
		{
			txtBxHCID.clear();
			if(utils.enterTextinAnelemnt(txtBxHCID, args[0], "RequestEnrollmentAndBillingAction", "HCID"))
				if(utils.enterTextinAnelemnt(txtBxDOB, args[1], "RequestEnrollmentAndBillingAction", "Name"))
					if(utils.selectDropDownbyVisibleString(drpDownMemberID, args[2], "RequestEnrollmentAndBillingAction", "Member ID"))
						return true;
			return false;
		}

		@FindBy(xpath="//span[starts-with(text(),'When the member is adding')]")
		WebElement labelInstructionalTextForAddingDependent;

		@FindBy(id="pyDescription")
		WebElement txtBxOtherDescription;

		@FindBy(xpath="//span[contains(text(),'The employer of the member')]")
		WebElement labelInstructionalTextForEnrollIndicatorYes;

		@FindBy(id="OverrideDefaultRouting")
		WebElement chckBxOverrideDefaultReturningToMe;

		public boolean validateAddDependentInstructionalText(String[] args)
		{
			return utils.validateLabel(labelInstructionalTextForAddingDependent, args[0]);
		}

		public boolean updateMemberDemographicsOtherDetails(String[] args)
		{
			txtBxHCID.clear();
			if(utils.enterTextinAnelemnt(txtBxHCID, args[0], "RequestEnrollmentAndBillingAction", "HCID"))
				if(utils.enterTextinAnelemnt(txtBxDOB, args[1], "RequestEnrollmentAndBillingAction", "Name"))
					if(utils.selectDropDownbyVisibleString(drpDownMemberID, args[2], "RequestEnrollmentAndBillingAction", "Member ID"))
						if(utils.enterTextinAnelemnt(txtBxOtherDescription, args[3], "RequestEnrollmentAndBillingAction", "Other"))
							return true;
			return false;
		}

		public boolean validateInstTextForEnrollIndicatorYes(String[] args)
		{
			return utils.validateLabel(labelInstructionalTextForEnrollIndicatorYes, args[0]);
		}

		public boolean clickOverrideDefaultReturnToMeCheckBox()
		{
			return utils.clickAnelemnt(chckBxOverrideDefaultReturningToMe, "RequestEnrollmentAndBillingAction", "Override Default Returning To Me Check Box");
		}

		//Sprint 4.4

		@FindBy(xpath="//table[@pl_prop='.GroupContacts']")
		WebElement tblEmployeeGroupInformation;

		@FindBy(xpath="//table[@pl_prop='.SubGroupContacts']")
		WebElement tblProductGroupInformation;

		@FindBy(xpath="(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[1]")
		WebElement imgEnrollmentRelatedEnquiry;

		@FindBy(xpath="(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[2]")
		WebElement imgBillingRelatedEnquiry;

		@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']")
		WebElement collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview;

		@FindBy(xpath="(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[1]//following::span[starts-with(text(),'To send this information')]")
		WebElement labelInstructionalTextForEnrollment;

		@FindBy(xpath="(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[2]//following::span[contains(text(),'You will need to contact')]")
		WebElement labelInstructionalTextForBilling;

		@FindBy(xpath="//span[contains(text(),'The employer of the member')]")
		WebElement labelInstructionalTextForPhoneNumberAndAddress;



		/**
		 * This method validates the employer group information under group contact information section On complete E and B review page
		 **/

		public boolean validateEmployerGroupInformationUnderGroupContactSection(String[] tablevalues)
		{
			return utils.validatetablerowbasedonvalues(tblEmployeeGroupInformation, tablevalues);
		}

		/**
		 * This method validates the product group information under group contact information section On complete E and B review page
		 **/

		public boolean validateProductGroupInformationUnderGroupContactSection(String[] tablevalues)
		{
			return utils.validatetablerowbasedonvalues(tblProductGroupInformation, tablevalues);
		}

		public boolean verifyItemsDiscusseDuringManageEAndBReviewSectionIsCollapsed()
		{
			return !utils.isProxyWebelement(collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview);
		}

		/**
		 * This methods expands the items discussed during E and B review section on complete E and B review page
		 * @return
		 */
		public boolean expandTheItemsDiscusseDuringManageEAndBReviewSection()
		{
			return utils.clickAnelemnt(collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview, "CompleteEnrollmentAndBillingReview", "Expand the Collapse Indicator");
		}

		@FindBy(xpath="//div[@title='Disclose Group Contact Information']")
		WebElement collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry;

		public boolean ExpandGroupContactInformationSection()
		{
			return utils.clickAnelemnt(collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry, "ReviewEnrollmentAndBillingInformation", "Clicking on Collapse Indicator - Group Contact Information");
		}

		@FindBy(xpath="//div[@data-test-id='201807271120570878817']")
		WebElement labelNoItemsDiscussed;

		public boolean validateNoItesmDiscussedInCompleteEandBReviewPage()
		{
			return utils.validateLabel(labelNoItemsDiscussed, "No items discussed");
		}

		public boolean verifyEnrollmentInfoDiscussedTextWithCheckMarkAndEnrollmentInstructionalTextIsDisplayed()
		{
			return !utils.isProxyWebelement(imgEnrollmentRelatedEnquiry) && !utils.isProxyWebelement(labelInstructionalTextForEnrollment);
		}


		public boolean verifyBillingInfoDiscussedTextWithCheckMarkAndBillingInstructionalTextIsDisplayed()
		{
			return !utils.isProxyWebelement(imgBillingRelatedEnquiry) && !utils.isProxyWebelement(labelInstructionalTextForBilling);
		}

		public boolean verifyInstructionalTextForDemographicChangesPhoneAndAddress()
		{
			String actualText = " The employer of the member in focus opted to use an electronic enrollment file feed. Advise the member to contact their employer to have the information updated.".trim();
			return utils.validateLabel(labelInstructionalTextForPhoneNumberAndAddress, actualText);
		}

		@FindBy(xpath="//span[contains(text(),'next 24 to 48 hours')]")
		WebElement labelInstructionalTextUrgentRequest;

		public boolean validateInstructionalTextForMedicalAttention()
		{
			return utils.validateLabel(labelInstructionalTextUrgentRequest, "“Urgent request?” is selected only when a member needs medical attention or a prescription within the next 24 to 48 hours");
		}

		public boolean verifyRequestedActionValuesForDemographicChanges() 
		{
			ArrayList<String> al = new ArrayList<String>();
			al.add("Select");
			//al.add("Demographic changes - Phone number"); - Removed by Avengers
			//al.add("Demographic changes - Address");Removed by Avengers
			al.add("Demographic changes - Name");
			al.add("Demographic changes - Gender");
			al.add("Demographic changes - Date of birth");
			//al.add("Demographic changes - Email");Removed by Avengers
			al.add("Other");
			return utils.checkvaluesinDropDown(drpdwnRequestEnrollmentRequestedAction, al);
		}



		public boolean verifyRequestedActionValuesForOtherPolicyChanges() 
		{
			ArrayList<String> al = new ArrayList<String>();
			al.add("Select");
			al.add("Disability form received");
			al.add("Overage 26 dependent form received");
			al.add("Retroactive / Backdated PCP updates");
			al.add("Other");
			return utils.checkvaluesinDropDown(drpdwnRequestEnrollmentRequestedAction, al);
		}


		public boolean verifyRequestedActionValuesForPolicyOrDependentCancelled() 
		{
			ArrayList<String> al = new ArrayList<String>();
			al.add("Select");
			al.add("Reinstate due to Anthem error");
			al.add("Correct member termination error");
			al.add("Other");
			return utils.checkvaluesinDropDown(drpdwnRequestEnrollmentRequestedAction, al);
		}

		public boolean selectReasonToOverrideDefaultReturn(String[] args)
		{
			return utils.selectDropDownbyVisibleString(drpdwnRequestEnrollmentOverrideReason, args[0], "RequestEnrollmentandBillingAction", "Override Reason");
		}

		@FindBy(xpath="//span[starts-with(text(),'When making PCP updates ')]")
		WebElement labelRetroactivePCPInstructionalText1;

		@FindBy(xpath="//span[starts-with(text(),'The list of members')]")
		WebElement labelRetroactivePCPInstructionalText2;


		public boolean validateRetroactivePCPInstructionalText(String[] args)
		{
			String actualText1 = labelRetroactivePCPInstructionalText1.getText().replaceAll(",", "");
			String actualText2 = labelRetroactivePCPInstructionalText2.getText().replaceAll(",", "");
			if(utils.isvalueMatch_contain(args[0], actualText1))
				if(utils.isvalueMatch_contain(args[1], actualText2))
					return true;
			return false;
		}


		public boolean selectMemberForThePCPUpdates(String[] membername)
		{

			String xpath = "//span[contains(text(),'"+membername[0]+"')]//ancestor::div[@node_name='PCPUpdateMemberInfo']//preceding-sibling::div//input[@type='checkbox']";
			System.out.println("xpath is: " + xpath);
			utils.waitforpageload();
			try{
				if(Driver.pgDriver.findElement(By.xpath(xpath)).getAttribute("checked").equalsIgnoreCase("true")){
					return true;
				}else{
					Driver.pgDriver.findElement(By.xpath(xpath)).click();
					return true;
				}}catch(Exception e){
					Driver.pgDriver.findElement(By.xpath(xpath)).click();
					return true;
				}

		}


		@FindBy(id="pyLabel")
		WebElement txtBxPCPID;

		@FindBy(id="pyNote")
		WebElement txtBxPCPName;

		@FindBy(id="pyCity")
		WebElement txtBxAddress;

		@FindBy(id="CallBackNumber")
		WebElement txtBxPhoneNumber;

		@FindBy(id="pyLabelRef")
		WebElement txtBxEffectiveDate;

		@FindBy(id="ReasonForUpdatePCP")
		WebElement drpDownReasonForUpdate;




		public boolean updatePCPDetails(String[] args)
		{
			txtBxHCID.clear();
			if(utils.enterTextinAnelemnt(txtBxHCID, args[0], "RequestEnrollmentandBillingAction", "HCID"))
				if(utils.enterTextinAnelemnt(txtBxDOB, args[1], "RequestEnrollmentandBillingAction", "DOB"))
					if(utils.enterTextinAnelemnt(txtBxPCPID, args[2], "RequestEnrollmentandBillingAction", "PCP ID"))
						if(utils.enterTextinAnelemnt(txtBxPCPName, args[3], "RequestEnrollmentandBillingAction", "PCP Name"))
							if(utils.enterTextinAnelemnt(txtBxAddress, args[4], "RequestEnrollmentandBillingAction", "Address"))
								if(utils.enterTextinAnelemnt(txtBxPhoneNumber, args[5], "RequestEnrollmentandBillingAction", "Phone Number"))
									if(utils.enterTextinAnelemnt(txtBxEffectiveDate, args[6], "RequestEnrollmentandBillingAction", "Effective Date"))
										if(utils.selectDropDownbyVisibleString(drpDownReasonForUpdate, args[7], "RequestEnrollmentandBillingAction", "Reason For Update"))
											return true;
			return false;
		}


		@FindBy(xpath="//img[@src='webwb/requiredstar.gif']")
		WebElement imgMandatoryIconMandatoryReference;;

		public boolean verifyDocumentReferencesIsMandatory()
		{
			return !utils.isProxyWebelement(imgMandatoryIconMandatoryReference);
		}


		@FindBy(xpath="//span[contains(text(),'When the member')]")
		WebElement labelInstructionalTextForRequestCancellation;

		public boolean verifyInstructionalTextForRequestCancellation()
		{
			return utils.validateLabel(labelInstructionalTextForRequestCancellation, " When the member is requesting a cancellation this requires the member to submit the request in writing through their employer. Advice the member to work with their employer to request a cancellation");
		}


		@FindBy(xpath="//div[@id='DialogContent']")
		WebElement guidedDialgue;
		/**
		 * 
		 * This Method validate the Guided dialog for SG & LG member for guidance of user to launch member maintenance for demographic update"
		 * @param args
		 * @return
		 */
		public boolean validateGuidedDialogforSGandLGMembers(String[] args)
		{
			String guidedDialogueISGMember = guidedDialgue.getText();
			return utils.isvalueMatch_compareto(guidedDialogueISGMember.replaceAll("\n", " "), args[0]);

		}

		//Sprint 6.4

		/**This method enters notes in the notes field
		 * 
		 */

		@FindBy(id="Notes")
		WebElement txtBxNotes;

		public boolean enterNotes(String[] args)
		{
			return utils.enterTextinAnelemnt(txtBxNotes, args[0], "CompleteEnrollmentAndBillingReview", "Notes");
		}

		//Sprint 7.2

		@FindBy(id="ReasonForRequestExceptionReview")
		WebElement dropDownReasonForExceptionReview;

		/**This method selects the reason for Exception review
		 * 
		 * @param args
		 * @return
		 */
		public boolean selectReasonForExceptionReview(String[] args){
			utils.waitforpageload();
			return utils.selectDropDownbyVisibleString(dropDownReasonForExceptionReview,args[0], "Request Enrollment and Billing Action", "reason For Exception Review");
		}

		@FindBy(id="IsPolicyOrMember")
		WebElement selectPolicyOrMember;

		/** This method selects policy or member drop down value
		 * 
		 * @param args
		 * @return
		 */
		public boolean selectPolicyOrMember(String[] args){
			utils.waitforpageload();
			return utils.selectDropDownbyVisibleString(selectPolicyOrMember,args[0], "Request Enrollment and Billing Action", "Policy or Member");
		}
		public void gotoLastIframe() throws UnhandledAlertException{
			System.out.println("1");
			Driver.getPgDriver().switchTo().defaultContent();
			System.out.println("2");
			int i=this.iframes.size();
			//System.out.println("Size" +iframe.size());
			//WebElement lastfr=iframes.get(i-1);
			Driver.getPgDriver().switchTo().frame(i-1);
			//Driver.getPgDriver().switchTo().frame(lastfr);
			System.out.println("##########");

			// change the driver
			//System.out.println("hello"+this.iframes.get(iframe.size()-1).getAttribute("id"));
		}
		public boolean isMemberCompositeReached(){
			utils.waitforpageload();
			try {
				gotoLastIframe();
			} catch (UnhandledAlertException e) {
				// TODO Auto-generated catch block
				err.logError(e, "unhandled  alert error in switiching frame");
				e.printStackTrace();
			}
			return !utils.isProxyWebelement(tabMbrCompositeMember);

		}
		@FindBy(xpath="//*[text()='Skill Name']/ancestor::table[@id='bodyTbl_right']")
		WebElement SkillRequiredTable;
		
		@FindBy(xpath="(//div[@role='button'])[1]")
		WebElement clickToolIcon;


		@FindBy(xpath="//span[text()='View Skills']")
		WebElement clickOnViewSkills;

		/**This methods clicks the view skills option on clicking the tool icon on Service Request details page
		 * 
		 * @return
		 * @throws InterruptedException
		 */
		public boolean clickViewSkillsFromToolIcon() throws InterruptedException{
			Thread.sleep(3000);
			utils.scrolltoright();
			if(utils.clickAnelemnt(clickToolIcon, "ResolveUpdateOtherInsuranceRequest", "Tool icon"))
				if(utils.clickAnelemnt(clickOnViewSkills, "ResolveUpdateOtherInsuranceRequest", "View Skills"))
					return true;
			return false;

		}
		
		/**This functionality validates the skills assigned to the SR in the service request details page
		 * 
		 * @param args
		 * @return
		 */
		public boolean validateTheSRSkills(String[] args) {
			return utils.validatetablerowbasedonvalues(SkillRequiredTable, args);
		}
	}
