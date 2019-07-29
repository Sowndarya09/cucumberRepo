package automationLib;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ReviewEnrollmentAndBillingInformation extends Driver{

	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	public ReviewEnrollmentAndBillingInformation()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}


	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	
	@FindBy(xpath="//div[@title='Disclose Enrollment Related Inquiry']")
	WebElement collapseIndicatorEnrollmentRelatedEnquiry;
	
	@FindBy(xpath="//div[@title='Disclose Billing Related Inquiry']")
	WebElement collapseIndicatorBillingRelatedEnquiry;
	
	@FindBy(xpath="//div[@title='Disclose Group Contact Information']")
	WebElement collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry;
	
	@FindBy(id="EnrollmentSummaryReview")
	WebElement chkBxEnrollmentInfoDiscussed;
	
	@FindBy(id="BillingSummaryReview")
	WebElement chkBxBillingInfoDiscussed;
	
	@FindBy(xpath="//div[@node_name='EnrollmentRelatedInquiry']//p//span")
	WebElement labelInstructionalMsgForEnrollmentInquiry;
	
	@FindBy(xpath="//div[@node_name='BillingRelatedInquiry']//p//span")
	WebElement labelInstructionalMsgForBillingInquiry;
	
	@FindBy(xpath="//table[@pl_prop='.GroupContacts']")
	WebElement tblEmployeeGroupInformation;
	
	@FindBy(xpath="//table[@pl_prop='.SubGroupContacts']")
	WebElement tblProductGroupInformation;
	
	@FindBy(xpath="//span[contains(text(),'Any Enrollment and Billing')]")
	WebElement labelInstructionalTextForNationalMember;
	
	
	
	public boolean verifyEnrollmentRelatedEnquirySectionIsDisplayedInCollapsedModeOnReviewEAndBReviewPage()
	{
		return !utils.isProxyWebelement(collapseIndicatorEnrollmentRelatedEnquiry);
	}
	
	public boolean expandTheEnrollmentRelatedEnquirySectionOnReviewEAndBReviewPage()
	{
		return utils.clickAnelemnt(collapseIndicatorEnrollmentRelatedEnquiry, "ReviewEnrollmentAndBillingInformation", "Clicking on Collapse Indicator - Enrollment");
	}

	public boolean checkTheEnrollmentInfoDiscussedWithContactCheckBoxOnReviewEAndBReviewPage()
	{
		return utils.clickAnelemnt(chkBxEnrollmentInfoDiscussed, "ReviewEnrollmentAndBillingInformation", "Enrollment Info Discussed with contact");
	}
	
	public boolean validateTheEnrollmentRelatedEnquiryInstructionalTextOnReviewEAndBReviewPage()
	{
		String actualText = "To send this information to the Enrollment and Billing area use Request Enrollment and Billing Actions from Other Actions on Complete Enrollment and Billing Review screen.";
		String expectedText = labelInstructionalMsgForEnrollmentInquiry.getText().replaceAll(",", "");
		return utils.isvalueMatch_contain(actualText, expectedText);
	}
	
	
	public boolean verifyBillingRelatedEnquirySectionIsDisplayedInCollapsedModeOnReviewEAndBReviewPage()
	{
		return !utils.isProxyWebelement(collapseIndicatorBillingRelatedEnquiry);
	}
	
	public boolean expandTheBillingRelatedEnquirySectionOnReviewEAndBReviewPage()
	{
		return utils.clickAnelemnt(collapseIndicatorBillingRelatedEnquiry, "ReviewEnrollmentAndBillingInformation", "Clicking on Collapse Indicator - Billing");
	}

	public boolean checkTheBillingInfoDiscussedWithContactCheckBoxOnReviewEAndBReviewPage()
	{
		return utils.clickAnelemnt(chkBxBillingInfoDiscussed, "ReviewEnrollmentAndBillingInformation", "Billing Info Discussed with contact");
	}
	
	public boolean validateTheBillingRelatedEnquiryInstructionalTextOnReviewEAndBReviewPage()
	{
		String actualText = "You will need to contact the group administrator for any billing questions the member has keep the member on the call while you call the group because they will need to validate the member is on the phone with you before they can discuss any billing information with you and the member.";
		String expectedText = labelInstructionalMsgForBillingInquiry.getText().trim().replaceAll(",", "");
		return utils.isvalueMatch_contain(actualText, expectedText);
	}
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	public boolean clickSubmit()
	{
		//action.moveToElement(btnSubmit);
		WebElement element = this.btnSubmit;
	   	((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		 return utils.clickAnelemnt(this.btnSubmit, "UpdateOtherInsurance", "Submit");
		
	}
	
	
	public boolean verifyGroupContactInformationSectionInCollapsedModeOnExpandingBillingRelatedSection()
	{
		return !utils.isProxyWebelement(collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry);
	}
	
	
	public boolean expandGroupContactInformationSection()
	{
		return utils.clickAnelemnt(collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry, "ReviewEnrollmentAndBillingInformation", "Clicking on Collapse Indicator - Group Contact Information");
	}
	
	public boolean validateEmployerGroupInformationUnderGroupContactSection(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(tblEmployeeGroupInformation, tablevalues);
	}
	

	public boolean validateProductGroupInformationUnderGroupContactSection(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(tblProductGroupInformation, tablevalues);
	}
	
	public boolean validateTheInstructionalTextForNationalMembersOnReviewEAndBInformationPage()
	{
		String actualText = " Any Enrollment and Billing related requests for a member belonging to National Line of Business are currently ".trim();
		return utils.validateLabel(labelInstructionalTextForNationalMember, actualText);
	}
	
}
