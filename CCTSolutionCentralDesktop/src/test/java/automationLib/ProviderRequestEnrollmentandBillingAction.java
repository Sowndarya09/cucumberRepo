package automationLib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderRequestEnrollmentandBillingAction extends Driver{

	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	public ProviderRequestEnrollmentandBillingAction()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelementtemp;
	@FindBy(id="EnrollmentandBillingSelectionEnrollment")
	private WebElement radioRequestEnrollmentEnrollment;
	@FindBy(id="EnrollmentandBillingSelectionBilling")
	private WebElement radioRequestEnrollmentBilling;
	@FindBy(id="PrimaryReasonforBilling")
	private WebElement drpdwnRequestEnrollmentReasonforContact;
	@FindBy(id="EnrollmentActionType")
	private WebElement drpdwnRequestEnrollmentRequestedAction;

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
	@FindBy(id="SelectUrgentOrCodeBlue")
	private WebElement drpdwnRequestEnrollmentReasonforUrgent;

	@FindBy(id="BillingEnrollmentNotes")
	private WebElement txtbxRequestEnrollmentNotesSection;
	@FindBy(id="pySelected1")
	WebElement chkbxBillingUncashCoverage;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement labelHeaderTitle;

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

	@FindBy(id="RequestedCancelDate")
	private WebElement txtbxEnrollmentCancelDate;

	@FindBy(id="MemberCancellationReason")
	private WebElement txtbxEnrollmentCancelReason;

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

	@FindBy(id="DocumentReferenceType1")
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

	@FindBy(id="IsAB2470Yes")
	WebElement radioAB2470Yes;

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
			return checkvaluesinReasonContact();
		}
	}

	public boolean checkvaluesinReasonforContract(String[] expectedvalues)
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "Billing radio")) {
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));

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
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Request Enrollment", "Enrollment Radio button")) {
			ArrayList<String> values=new ArrayList<String>();
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			for(String value:expectedvalues)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}

			return utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentRequestedAction,values);
		}
		return false;
	}

	public boolean checkvaluesinBillingRequestedAction(String[] expectedvalues)
	{
		try{
			utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "Biling Radio button");
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			ArrayList<String> values=new ArrayList<String>();
			for(String value:expectedvalues)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}

			if(utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentBillingRequestedAction,values))
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


	public boolean checkvaluesinUrgentReasonRequest(String[] expectedvalues)
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "Billing radio")) {
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

			return utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentReasonforUrgent,values);
		}
		return false;
	}


	public boolean checkvaluesinOverrideReason(String[] expectedvalues)
	{
		utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "Billing radio");
		try{
			if(!this.chkbxRequestEnrollmentUrgent.isSelected())
			{
				utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent,"Request Enrollment", "Override Reason checkbox");
			}
			utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Other", "Request Enrollment and Billing", "Drop down requested action");
			if(!this.chkbxRequestEnrollmentOverride.isSelected())
			{
				utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride,"Request Enrollment", "Override Reason checkbox");
			}

			ArrayList<String> values=new ArrayList<String>();
			for(String value:expectedvalues)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}

			if(utils.checkvaluesinDropDown(this.drpdwnRequestEnrollmentOverrideReason,values))
			{
				if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride,"Request Enrollment", "Override Reason checkbox"))
					return utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent,"Request Enrollment", "Override Reason checkbox");
			}
			return false;
		}
		catch(Exception e)
		{
			err.logError("request Enrollemnt", "Drop Down");
			return false;
		}

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

	public boolean EnrollmentAddNewBornUrgentOverride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
		{
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
										{ 
											utils.setAttribute(this.txtbxEnrollmentDOB,"date-value","01/10/2015");
											if(utils.selectDropDownbyVisibleString(this.drpdwnEnrollmentGender,"Male", "Request Enrollment", "Gender Radio Button"))
												if(utils.clickAnelemnt(this.radioEnrollmentAdopted, "Request Enrollment", "Adopted button"))
													if(utils.enterTextinAnelemnt(this.txtbxEnrollmentNewBornFullName,"Vincent Paul", "Request Enrollment", "New Full Born text Box"))

														if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
														{

															Driver.getPgDriver().switchTo().defaultContent();

															Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);

															if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())
																return true;
														}
										}
		}
		return false;
	}

	public boolean EnrollmentProcessRenewalUrgent() throws InterruptedException
	{ 
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Process Renewal", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 4, "Manage Billing", "Urgent Request dropdown"))
						{
							Assert.assertEquals(true, this.txtbxEnrollmentContractCode.isDisplayed());

							Assert.assertEquals(true, this.txtbxEnrollmentHCID.isDisplayed());
							Assert.assertEquals(true, this.txtbxEnrollmentIDNumber.isDisplayed());
							System.out.println("Check the validations ");
							if(utils.clickAnelemnt(this.btnSubmit,"Request Enrollment","Submit button"))
							{
								utils.waitforpageload();
								Driver.getPgDriver().switchTo().defaultContent();
								Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
								wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")));
								if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

									return true;
							}
						}
		}
		return false;
	}


	public boolean EnrollmentRequestCancellationOveride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 6, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Request Cancellation", "ManageBilling", "Requested Action dropdown"))

					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 4, "Manage Billing", "Override dropdown"))
						{
							utils.enterTextinAnelemnt(this.txtbxRequestEnrolmentOverrideReason, "Test", "Request Enrollment", "Override Reason Text Box");
							if(utils.clickAnelemnt(this.radioEnrollmentRequestCancellationMember, "Request Enrollment", "Add NEw Born Radio button"))
								if(utils.enterTextinAnelemnt(this.txtbxEnrollmentCancelDate,"11/10/2014", "Request Enrollment", "DOB"))
								{ 
									utils.setAttribute(this.txtbxEnrollmentCancelDate,"date-value","11/10/2014");


									if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
									{

										Driver.getPgDriver().switchTo().defaultContent();
										Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
										if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

											return true;
									}
								}
						}
		}

		return false;
	}



	public boolean EnrollmentUpdateAPTC() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 5, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Update APTC/Subsidy", "ManageBilling", "Requested Action dropdown"))
				{
					if(utils.enterTextinAnelemnt(this.txtbxEnrollmentIDNumber, "123456789", "Request Enrollment", "enrollment Number")	)
					{
						if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
						{

							Driver.getPgDriver().switchTo().defaultContent();
							Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
							if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

								return true;
						}
					}
				}
		}

		return false;

	}


	public boolean EnrollmentUpdateDemographicsUrgent() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 3, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Update Demographics (Policy/Member)", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 1, "Manage Billing", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.radioEnrollmentRequestCancellationMember, "Request Enrollment", "Member radio button"))

								if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
								{
									if(utils.validateHeader(this.labelHeaderTitle, "Request Enrollment & Billing Action"))
									{

										Driver.getPgDriver().switchTo().defaultContent();
										Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
										if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

											return true;
									}
								}
		}
		return false;

	}					   

	public boolean EnrollmentOtherUrgentOverride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 4, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentRequestedAction, "Other", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 3, "Manage Billing", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
								if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 0, "Manage Billing", "Override dropdown"))
								{
									utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section");
									if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
									{

										Driver.getPgDriver().switchTo().defaultContent();
										Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
										if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

											return true;
									}
								}
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:BillingApplyInitialPaymentUrgent
	 * Type:Textbox
	 */

	public boolean BillingApplyInitialPaymentUrgent() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Apply Initial Payment", "Request Enrollment", "Requested Action dropdown"))
				{
					if(this.chkbxRequestEnrollmentUrgent.isSelected())
					{
						utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent,"Request Enrollment", "Override Reason checkbox");
					}
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))              		 
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 2, "Request Enrollment", "Urgent Request dropdown"))
							if(utils.enterTextinAnelemnt(this.txtbxBillingInitialPayment, "$200", "Request Enrollment", "Initial Payment Amount "))
							{
								Driver.pgDriver.findElement(By.xpath("//span[text()='Apply Initial Payment']")).click();
								utils.clickAnelemnt(this.txtbxBillingInitialPaymentConfirmationNumber, "request Enrollment", "Initial payment confirmation number");
								if(utils.enterTextinAnelemnt(this.txtbxBillingInitialPaymentConfirmationNumber, "124", "request Enrollment", "Initial payment confirmation number"))
								{
									if(utils.selectDropDownbyVisibleString(this.drpdwnBillingInitialMethodPayment, "Credit Card", "Request Enrollment", "Payment Method"))
									{
										if(this.chkbxRequestEnrollmentOverride.isSelected())
										{
											utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride,"Request Enrollment", "Override Reason checkbox");
										}
										if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
										{
											utils.waitforpageload();
											Driver.getPgDriver().switchTo().defaultContent();
											Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
											if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

												return true;
										}
									}
								}
							}
				}
		}
		return false;


	}					   

	public boolean BillingApplyUnprocessedCashOverride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 3, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Apply Unprocessed Cash", "Request Enrollment", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 1, "Request Enrollment", "Override reason"))
							if(utils.enterTextinAnelemnt(this.txtbxBillingCheckID, "COID12345678912", "Request Enrollment", "CheckID "))
							{
								if(utils.clickAnelemnt(this.chkbxBillingUncashCoverage, "request Enrollment", "Coverage Checkboxr"))
								{

									if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
									{
										Driver.getPgDriver().switchTo().defaultContent();
										Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
										if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

											return true;
									}
								}
							}
		}
		return false;

	}	




	public boolean BillingMisappliedPaymentOverride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Correct Misapplied Payment", "Request Enrollment", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 3, "Request Enrollment", "Override checkbox"))
							if(utils.enterTextinAnelemnt(this.txtbxBillingInitialPayment1, "$200", "Request Enrollment", "Initial Payment Amount "))
							{
								if(utils.enterTextinAnelemnt(this.txtbxBillingInitialPaymentConfirmationNumber1, "124", "request Enrollment", "Initial payment confirmation number"))
								{
									if(utils.selectDropDownbyVisibleString(this.drpdwnBillingInitialMethodPayment1, "Credit Card", "Request Enrollment", "Payment Method"))
									{
										utils.selectDropDownbyIndex(this.drpdwnRequestEnrolmentBillingMisappliedReason, 1, "Request Enrollment", "Reason");
										if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
										{
											Driver.getPgDriver().switchTo().defaultContent();
											Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
											if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

												return true;
										}
									}

								}
							}
		}


		return false;


	}



	public boolean BillingRequestPaymentOverride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Request Payment History", "Request Enrollment", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 3, "Request Enrollment", "Override checkbox"))

							if(utils.clickAnelemnt(this.chkbxBillingUncashCoverage, "request Enrollment", "Coverage Checkboxr"))
							{

								if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
								{

									Driver.getPgDriver().switchTo().defaultContent();
									Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
									if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

										return true;
								}
							}
		}
		return false;

	}

	public boolean BillingRequestHelp() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 7, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Request Help", "Request Enrollment", "Requested Action dropdown"))

				{

					if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
					{

						Driver.getPgDriver().switchTo().defaultContent();
						Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
						if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

							return true;
					}
				}
		}
		return false;

	}


	public boolean BillingProcessRetroactive() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Process Retroactive Cancellation", "Request Enrollment", "Requested Action dropdown"))

				{
					utils.selectDropDownbyIndex(this.drpdwnBillingReasonForException, 1, "Request Enrollment", "Exception Drop Down ");
					if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
					{

						Driver.getPgDriver().switchTo().defaultContent();
						Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
						if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

							return true;
					}
				}
		}
		return false;

	}




	public boolean BillingEnrollSummaryBilling() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 2, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Enroll in Summary Billing", "Request Enrollment", "Requested Action dropdown"))

				{
					utils.clickAnelemnt(this.imgBillingAddButton, "Request Enrollment", "Add Button");
					utils.selectDropDownbyIndex(this.drpdwnrequestEnrollmentEnrollSummaryBill, 1, "Request Enrollment", "address type");
					utils.enterTextinAnelemnt(this.txtbxRequestEnrollemntEnrollSummaryBillingAddress, "Test Address", "Request Enrollment", "Address");

					if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
					{

						Driver.getPgDriver().switchTo().defaultContent();
						Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
						if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

							return true;
					}
				}
		}
		return false;

	}



	public boolean BillingChangeEffDateUrgentOverride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{

			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));

			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Change Effective Date of Policy/Member", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 3, "Manage Billing", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
								if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 2, "Manage Billing", "Override dropdown"))
								{ 
									if(utils.selectDropDownbyIndex(this.drpdwnBillingReasonForException, 1, "Request Enrollemnt", "Drop Down Exception Reason"))
									{
										if(utils.selectDropDownbyVisibleString(this.drpdwnBillingPolicyorMember, "Member", "Request Enrollemnt", "Drop Down member-policy"))
										{
											utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section");
											if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
											{

												Driver.getPgDriver().switchTo().defaultContent();
												Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
												if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

													return true;
											}
										}
									}
								}
		}
		return false;

	}

	public boolean BillingIssueRefundUrgentOverride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Billing Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 5, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Issue Refund", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 1, "Manage Billing", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
								if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentOverrideReason, 1, "Manage Billing", "Override dropdown"))
								{ 
									if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentBillingRefundAmount, "$500", "Request Enrollemnt", "refund Amount"))
									{
										if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentBillingRefundReason, 1, "Request Enrollemnt", "Issue Refund Reason"))
										{
											utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRefundAddress, "Home", "Request Enrollment", "Notes Section");
											if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
											{
												Driver.getPgDriver().switchTo().defaultContent();
												Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
												if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

													return true;
											}
										}
									}
								}
		}
		return false;


	}

	public boolean BillingInvestigatePremiumUrgent() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 3, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Investigate Premium Discrepancies", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 2, "Manage Billing", "Urgent Request dropdown"))


							if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
							{

								Driver.getPgDriver().switchTo().defaultContent();
								Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
								if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

									return true;
							}
		}
		return false;


	}




	public boolean BillingOtherUrgentOveride() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EnrollmentActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 5, "Manage Billing", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Other", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Manage Billing", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 1, "Manage Billing", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.chkbxRequestEnrollmentOverride, "Manage Billing", "Override Checkbox"))
								if(utils.clickAnelemnt(this.drpdwnRequestEnrollmentBillingExceptionReviewNo, "Manage Billing", "Exception review no"))
								{ 
									if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollemnt", "Notes Section"))
									{

										if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
										{

											Driver.getPgDriver().switchTo().defaultContent();
											Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
											if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

												return true;
										}
									}
								}
		}

		return false;


	}

	public boolean BillingReinstateMemberUrgent() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Reinstate Member", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Request Enrollment", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 5, "Request Enrollment", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.drpdwnRequestEnrollmentBillingExceptionReviewNo, "Request Enrollment", "Urgent Exception No"))
							{
								if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section"))
								{
									if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton"))
									{
										Driver.getPgDriver().switchTo().defaultContent();
										Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
										if(Driver.pgDriver.findElement(By.xpath("//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")).isDisplayed())

											return true;
									}
								}
							}
		}
		return false;


	}

	public boolean BillingReinstateMemberCheckAB2470() throws InterruptedException
	{
		if(utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Manage Billing", "Enrollment Radio Button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingActionType")));
			if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforContact, 1, "Request Enrollment", "Reason for Contract drop down"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnRequestEnrollmentBillingRequestedAction, "Reinstate Member", "ManageBilling", "Requested Action dropdown"))
					if(utils.clickAnelemnt(this.chkbxRequestEnrollmentUrgent, "Request Enrollment", "Urgent Checkbox"))
						if(utils.selectDropDownbyIndex(this.drpdwnRequestEnrollmentReasonforUrgent, 5, "Request Enrollment", "Urgent Request dropdown"))
							if(utils.clickAnelemnt(this.drpdwnRequestEnrollmentBillingExceptionReviewNo, "Request Enrollment", "Urgent Exception No"))
							{
								if(utils.enterTextinAnelemnt(this.txtbxRequestEnrollmentNotesSection, "TEST", "Request Enrollment", "Notes Section"))
								{
									if(this.labelIsAB2470message.getText().toString().contains("Is this AB2470"))
									{
										if(utils.clickAnelemnt(this.radioAB2470Yes, "Request Enrollment", "Radio Butto Yes"))
										{
											System.out.println("Yes selected");
										}
									}else
									{
										System.out.println("Wronf mseesage");
										err.logError("Request Enrollemnt", "Is AB2470 meesage");
									}
									return utils.clickAnelemnt(this.btnSubmit, "Request Enrollment", "Submit btton");
								}
							}
		}
		return false;

	}

	public boolean clickRadioBtnEnrollment()
	{
		return utils.clickAnelemnt(this.radioRequestEnrollmentEnrollment, "Request Enrollment", "Radio Button");

	}

	public boolean clickRadioBtnBilling()
	{
		return utils.clickAnelemnt(this.radioRequestEnrollmentBilling, "Request Enrollment", "radio buton Billing");
	}

	@FindBy(id="PrimaryReasonforBilling")
	WebElement drpDownReasonForContact;

	@FindBy(id="EnrollmentActionType")
	WebElement drpDownRequestedActionForEnrollment;

	@FindBy(id="BillingActionType")
	WebElement drpDownRequestedActionForBilling;

	@FindBy(id="OtherTopicBilling")
	WebElement txtOtherNotesInBilling;

	@FindBy(id="RequestExceptionReviewfalse")
	WebElement rdoBtnNoInExceptionReview;

	@FindBy(id="ReasonForRequestExceptionReview")
	WebElement drpDownResonForRequestExceptionReview;

	@FindBy(id="BillingEnrollmentNotes")
	WebElement txtBillingNotes;

	public boolean selectReasonForContact(String reasonforcontact)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReasonForContact, reasonforcontact, "RequestEnrollmentAndBillingAction", "Reason for Contact");

	}

	public boolean selectRequestedActionForEnrollment(String requestedActionforEnrollment)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownRequestedActionForEnrollment, requestedActionforEnrollment, "RequestEnrollmentAndBillingAction", "Reason for Contact");

	}

	public boolean selectRequestedActionForBilling(String requestedActionforBilling)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownRequestedActionForBilling, requestedActionforBilling, "RequestEnrollmentAndBillingAction", "Reason for Contact");

	}

	public boolean clickSubmitInRequestEnrollmentAndBilling()
	{
		return utils.clickAnelemnt(this.btnSubmit, "RequestEnrollmentAndBillingAction", "Submit");
	}

	public boolean enterOtherDescription(String otherdescription)
	{
		return utils.enterTextinAnelemnt(this.txtOtherNotesInBilling, otherdescription, "RequestEnrollmentAndBillingAction", "Other Description");
	}

	public boolean clickRdoBtnNoInExceptionReview()
	{
		return utils.clickAnelemnt(this.rdoBtnNoInExceptionReview, "RequestEnrollmentAndBillingAction", "NO");
	}


	public boolean selectReasonForRequestExceptionReview(String reasonforrequestedactionreview)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownResonForRequestExceptionReview, reasonforrequestedactionreview, "RequestEnrollmentAndBillingAction", "Reason for Contact");
	}

	public boolean enterBillingNotes(String billingnotes)
	{
		return utils.enterTextinAnelemnt(this.txtBillingNotes, billingnotes, "RequestEnrollmentAndBillingAction", "Other Description");
	}


	public boolean submitRequestEnrollmentViaEnrollment()
	{
		if(clickRadioBtnEnrollment())
			if(selectReasonForContact("Did not understand bill"))
				if(selectRequestedActionForEnrollment("Process Renewal"))
					return clickSubmitInRequestEnrollmentAndBilling();

		return false;									
	}

	public boolean submitRequestEnrollmentViaBilling()
	{
		if(clickRadioBtnBilling())
			if(selectReasonForContact("Did not understand bill"))
				if(selectRequestedActionForBilling("Other"))
					if(enterOtherDescription("Notes Entered"))
						if(clickRdoBtnNoInExceptionReview())
							return clickSubmitInRequestEnrollmentAndBilling();
		return false;									
	}

	@FindBy(xpath="//*[@id='EnrollmentandBillingSelectionBilling']")
	WebElement BillingRadioButton;



	public boolean verifyBillingRadioButtonIsDisabled() throws InterruptedException{
		Thread.sleep(3000);
		if(BillingRadioButton.getAttribute("disabled").equalsIgnoreCase("true"))
		{
			System.out.println("disabled");
			return true;
		}
		else {
			System.out.println("enabled");
			return false;
		}

	}

	@FindBy(xpath="//*[text()='Items Discussed During Manage Enrollment & Billing Review']")
	WebElement ItemsDiscussedDuringManageEnrollmentAndBillingReview;

	public boolean expandItemsDiscussedDuringManageEnrollmentAndBillingReview() throws InterruptedException{
		Thread.sleep(3000);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		return utils.clickAnelemnt(ItemsDiscussedDuringManageEnrollmentAndBillingReview, "ProviderRequestEnrollmentAndBillingAction", "ItemsDiscussedDuringManageEnrollmentAndBillingReview");

	}

	@FindBy(xpath="//*[@node_name='BillingRelatedInquiry']//p")
	WebElement BillingRelatedInquiryMSG;
	public boolean verifyTheInstructionalTextForSG(String[] message)throws InterruptedException{
		Thread.sleep(3000);
		String BillingRelatedInquiryMSG = message[0];
		System.out.println("Message Given by User: "+BillingRelatedInquiryMSG);
		String BillingRelatedInquiryMSGFromUI = this.BillingRelatedInquiryMSG.getText().replaceAll(",", "").replaceAll("  ", " ");
		System.out.println("Message from the Application: "+BillingRelatedInquiryMSGFromUI);
		return utils.isvalueMatch_compareto(BillingRelatedInquiryMSGFromUI, BillingRelatedInquiryMSG);

	}
}


