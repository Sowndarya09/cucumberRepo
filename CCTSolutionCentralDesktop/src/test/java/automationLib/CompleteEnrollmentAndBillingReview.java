package automationLib;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

/**
 * On clicking Submit in Manage Billing we are navigated to this page 
 * @author Shardul Negi
 *
 */
public class CompleteEnrollmentAndBillingReview {
	/**
	 * Methods in the Program 
	 */
	DataSet ds=new DataSet();
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(),20);

	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public CompleteEnrollmentAndBillingReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	@FindBy(id="PrimaryReasonforBilling")
	WebElement drpDownReasonForContact;

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']")
	WebElement collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview;

	@FindBy(xpath="(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[1]")
	WebElement imgEnrollmentDiscussedWithContact;

	@FindBy(xpath="(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[2]")
	WebElement imgBillingDiscussedWithContact;


	public boolean selectTheReasonForContactDropdown(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownReasonForContact, args[0], "CompleteEnrollmentAndBillingReview", "Reason For Contact");
	}

	/**
	 * This functionality selects the value in the Other actions drop down
	 * @param args
	 * @return
	 */
	public boolean selectValuesFromOtherActions(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, args[0], "CompleteEnrollmentAndBillingReview", "Other Actions - " + args[0] );
	}

	public boolean verifyTheReasonForContactValuesForSGMembersOnCompleteEnrollmentAndBillingReviewPage()
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add("Select");
		al.add("Billing related inquiry");
		al.add("Requested Enrollment Action");
		return utils.checkvaluesinDropDown(drpDownReasonForContact, al);
	}

	@FindBy(xpath="//ul[contains(@id,'pyNavigation')]//li//a")
	WebElement otherActions;

	public boolean verifyOtherActionsValuesForSGMembersOnCompleteEnrollmentAndBillingReviewPage()
	{
		if(utils.clickAnelemnt(drpDownOtherActions, "CompleteEnrollmentAndBillingReview", "Other Actions")) {
			ArrayList<String> al1 = new ArrayList<String>();
			al1.add("Review Enrollment and Bil...");
			al1.add("Request Enrollment and Bi...");
			al1.add("Request Manager Help");
			return utils.checkvaluesinDropDown(otherActions, al1);
		}
		return false;
	}


	public boolean verifyItemsDiscusseDuringManageEAndBReviewSectionIsCollapsed()
	{
		return !utils.isProxyWebelement(collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview);
	}

	public boolean expandTheItemsDiscusseDuringManageEAndBReviewSection()
	{
		return utils.clickAnelemnt(collpaseIndicatorItemsReviewedDuringMangeEnrollmentAndReview, "CompleteEnrollmentAndBillingReview", "Expand the Collapse Indicator");
	}

	public boolean verifyEnrollmentInfoDiscussedTextAndEnrollmentInstructionalTextIsDisplayed()
	{
		return !utils.isProxyWebelement(imgEnrollmentDiscussedWithContact);
	}

	public boolean verifyBillingInfoDiscussedTextAndBillingInstructionalTextIsDisplayed()
	{
		return !utils.isProxyWebelement(imgBillingDiscussedWithContact);
	}

	@FindBy(xpath="//table[@pl_prop='.GroupContacts']")
	WebElement tblEmployeeGroupInformation;

	@FindBy(xpath="//table[@pl_prop='.SubGroupContacts']")
	WebElement tblProductGroupInformation;

	@FindBy(xpath="//div[@data-test-id='201807271120570878817']")
	WebElement labelNoItemsDiscussed;

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

	public boolean validateNoItesmDiscussedInCompleteEandBReviewPage()
	{
		return utils.validateLabel(labelNoItemsDiscussed, "No items discussed");
	}

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	public boolean clickOnSubmit()
	{
		WebElement element = this.btnSubmit;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(this.btnSubmit, "UpdateOtherInsurance", "Submit");

	}


	@FindBy(xpath="//div[@title='Disclose Group Contact Information']")
	WebElement collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry;

	public boolean expandGroupContactInformationSection()
	{
		return utils.clickAnelemnt(collapseIndicatorGroupContactInformationUnderBillingRelatedInquiry, "CompleteEnrollmentAndBillingReview", "Clicking on Collapse Indicator - Group Contact Information");
	}

	public boolean verifyTheReasonForContactValuesForMembersOnCompleteEnrollmentAndBillingReviewPage()
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add("Select");
		al.add("Billing related inquiry");
		al.add("Requested enrollment action");
		return utils.checkvaluesinDropDown(drpDownReasonForContact, al);

	}

	@FindBy(xpath="//label[@for='PrimaryReasonforBilling']//strong[text()='(Required)']")
	WebElement drpDownReasonForContactIsMandatory;

	public boolean verifyReasonForContactFieldIsMandatory()
	{
		return !utils.isProxyWebelement(drpDownReasonForContactIsMandatory);
	}

	@FindBy(id="Notes")
	WebElement txtBxNotes;

	public boolean enterNotes(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxNotes, args[0], "CompleteEnrollmentAndBillingReview", "Notes");
	}

	@FindBy(id="ERRORMESSAGES_ALL")
	WebElement softWarningPCIMessage;


	/** This method validates the PCI compliance soft warning message
	 * 
	 * @return
	 */
	public boolean validatePCIDataSoftWarningMessage()
	{
		return !utils.isProxyWebelement(softWarningPCIMessage);
	}
}



