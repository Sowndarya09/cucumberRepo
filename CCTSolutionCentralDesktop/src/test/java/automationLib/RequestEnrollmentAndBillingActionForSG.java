package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class RequestEnrollmentAndBillingActionForSG {

	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	public RequestEnrollmentAndBillingActionForSG()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}


	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(id="EnrollmentandBillingSelectionEnrollment")
	WebElement EnrollmentandBillingSelectionEnrollment;
	
	public boolean verifyEnrollmentRadioButtonPreSelected() {
		if(EnrollmentandBillingSelectionEnrollment.getAttribute("checked").equals("true"))
			return true;
		else
			return false;
	}
	
	@FindBy(id="PrimaryReasonforBilling")
	WebElement ReasonForBilling;
	
	public boolean verifyReasonForContactValues() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Select");
		valuestobechecked.add("Demographic changes");
		valuestobechecked.add("Other policy changes");
		valuestobechecked.add("Policy or dependent cancelled");
		valuestobechecked.add("Request policy/member cancellation");
		valuestobechecked.add("Request to add newborn/dependent");
		valuestobechecked.add("Requested a copy of a document");
		valuestobechecked.add("Unable to fill prescription");
		return utils.checkvaluesinDropDown(ReasonForBilling, valuestobechecked);
	}
	
	public boolean selectReasonForContact(String args[]) {
		return utils.selectDropDownbyVisibleString(ReasonForBilling, args[0], "RequestEnrollmentAndBillingActionForSG", "ReasonForBilling");
	}
	
	@FindBy(id="EnrollmentActionType")
	WebElement EnrollmentActionType;
	
	public boolean verifyRequestedActionValuesForDemographicChanges() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Select");
		valuestobechecked.add("Demographic changes - Phone number");
		valuestobechecked.add("Demographic changes - Address");
		valuestobechecked.add("Demographic changes - Name");
		valuestobechecked.add("Demographic changes - Gender");
		valuestobechecked.add("Demographic changes - Date of birth");
		valuestobechecked.add("Demographic changes - Email");
		valuestobechecked.add("Other");
		return utils.checkvaluesinDropDown(EnrollmentActionType, valuestobechecked);
	}
	
	public boolean verifyRequestedActionValuesForOtherPolicyChanges() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Select");
		valuestobechecked.add("Disability form received");
		valuestobechecked.add("Overage 26 dependent form received");
		valuestobechecked.add("Retroactive / Backdated PCP updates");
		valuestobechecked.add("Other");
		return utils.checkvaluesinDropDown(EnrollmentActionType, valuestobechecked);
	}
	
	public boolean verifyRequestedActionValuesForPolicyOrDependentCancelled() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Select");
		valuestobechecked.add("Reinstate due to Anthem error");
		valuestobechecked.add("Correct member termination error");
		valuestobechecked.add("Other");
		return utils.checkvaluesinDropDown(EnrollmentActionType, valuestobechecked);
	}
	
	public boolean verifyRequestedActionValuesForRequestPolicyOrMemberCancellation() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Select");
		valuestobechecked.add("Request cancellation");
		valuestobechecked.add("Other");
		return utils.checkvaluesinDropDown(EnrollmentActionType, valuestobechecked);
	}
	
	public boolean verifyRequestedActionValuesForRequestToAddNewbornOrDependent() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Select");
		valuestobechecked.add("Add newborn");
		valuestobechecked.add("Add dependent");
		valuestobechecked.add("Other");
		return utils.checkvaluesinDropDown(EnrollmentActionType, valuestobechecked);
	}
	
	public boolean verifyRequestedActionValuesForRequestedACopyOfDocument() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Select");
		valuestobechecked.add("Requested a copy of a document");
		valuestobechecked.add("Other");
		return utils.checkvaluesinDropDown(EnrollmentActionType, valuestobechecked);
	}
	
	public boolean verifyRequestedActionValuesForUnableToFillPrescription() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Select");
		valuestobechecked.add("Emergency add to Rx system");
		valuestobechecked.add("Other");
		return utils.checkvaluesinDropDown(EnrollmentActionType, valuestobechecked);
	}
	
	public boolean selectRequestedAction(String[] args) {
		return utils.selectDropDownbyVisibleString(EnrollmentActionType, args[0], "RequestEnrollmentAndBillingActionForSG", "EnrollmentActionType");
	}
	
	@FindBy(xpath="//*[@class='content-item content-paragraph item-1   ']//span")
	WebElement InstructionalText;
	
	public boolean verifyInstructionalTextForDemographicChangesPhoneAndAddress() {
		return utils.validateLabel(InstructionalText, " Go to the member maintenance task to update the phone number, email address and/ or mailing address.");
	}
	
	public boolean verifyInstructionalTextForRequestCancellation() {
		return utils.validateLabel(InstructionalText," When the member is requesting a cancellation this requires the member to submit the request in writing through their employer. Advice the member to work with their employer to request a cancellation");
	}
	
	@FindBy(id="EscalationUrgentIndicator")
	WebElement UrgentRequestCheckbox;
	
	public boolean verifyUrgentRequestCheckBox() {
		return !utils.isProxyWebelement(UrgentRequestCheckbox);
	}
	
	public boolean clickUrgentRequestCheckBox() {
		return utils.clickAnelemnt(UrgentRequestCheckbox, "RequestEnrollmentAndBillingActionForSG", "UrgentRequestCheckbox");
	}
	
	@FindBy(id="SelectUrgentOrCodeBlue")
	WebElement SelectUrgentOrCodeBlue;
	
	public boolean selectReasonForUrgentRequest(String[] args) {
		return utils.selectDropDownbyVisibleString(SelectUrgentOrCodeBlue, args[0], "RequestEnrollmentAndBillingActionForSG", "SelectUrgentOrCodeBlue");
	}
	
	@FindBy(xpath="//*[@class='content-item content-paragraph item-3   ']//span")
	WebElement InstructionalTextForUrgentRequest;
	
	public boolean validateInstructionalTextForMedicalAttention() {
		return utils.validateLabel(InstructionalTextForUrgentRequest,"“Urgent request?” is selected only when a member needs medical attention or a prescription within the next 24 to 48 hours");
	}
	
	@FindBy(xpath="//*[text()='Document References ']")
	WebElement DocumentReferences;
	
	public boolean verifyDocumentReferences() {
		return !utils.isProxyWebelement(DocumentReferences);
	}
	
	@FindBy(xpath="//*[@data-test-id='20151010172625047270589']")
	WebElement AddLink;
	
	public boolean clickAddInDocReference() {
		return utils.clickAnelemnt(AddLink, "RequestEnrollmentAndBillingActionForSG", "AddLink");
	}
	
	@FindBy(id="DocumentReferenceType1")
	WebElement DocumentReferenceType;
	
	public boolean selectDocType(String[] args) {
		return utils.selectDropDownbyVisibleString(DocumentReferenceType, args[0], "RequestEnrollmentAndBillingActionForSG", "DocumentReferenceType");
	}
	
	@FindBy(id="DCNDocumentIDIndicator1")
	WebElement ReferenceNumber;
	
	public boolean enterDocRefNumber(String[] args) {
		return utils.enterTextinAnelemnt(ReferenceNumber, args[0], "RequestEnrollmentAndBillingActionForSG", "ReferenceNumber");
	}
	
	@FindBy(xpath="//*[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']")
	WebElement VerifyItemsDiscusseDuringManageEAndBReviewSection;
	
	public boolean verifyItemsDiscusseDuringManageEAndBReviewSectionIsCollapsed() {
		return !utils.isProxyWebelement(VerifyItemsDiscusseDuringManageEAndBReviewSection);
	}
	
	public boolean expandTheItemsDiscusseDuringManageEAndBReviewSection() {
		return utils.clickAnelemnt(VerifyItemsDiscusseDuringManageEAndBReviewSection, "RequestEnrollmentAndBillingActionForSG", "VerifyItemsDiscusseDuringManageEAndBReviewSection");
	}
	
	@FindBy(xpath="//*[@title='Disclose Enrollment Related Inquiry']")
	WebElement DiscloseEnrollmentRelatedInquiry;
	
	public boolean expandTheEnrollmentRelatedEnquirySection() {
		return utils.clickAnelemnt(DiscloseEnrollmentRelatedInquiry, "RequestEnrollmentAndBillingActionForSG", "DiscloseEnrollmentRelatedInquiry");
	}
	
	@FindBy(xpath="//*[@node_name='EnrollmentRelatedInquiry']//nobr//label")
	WebElement EnrollmentInfoDiscussedText;
	
	public boolean verifyEnrollmentInfoDiscussedTextWithCheckMarkAndEnrollmentInstructionalTextIsDisplayed() {
		return utils.validateLabel(EnrollmentInfoDiscussedText, "Enrollment related information discussed with contact");
	}
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;
	
	public boolean clickSubmit() {
		return utils.clickAnelemnt(SubmitButton, "RequestEnrollmentAndBillingActionForSG", "SubmitButton");
	}
}
