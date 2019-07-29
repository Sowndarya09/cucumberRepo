package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class RequestManagerHelp {

	/**
	 * Methods in the Program
	 */
	DataSet ds = new DataSet();
	ErrorLogger err = new ErrorLogger();
	SeleniumUtilities utils = new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	// Changes to the Heading HEader
	@FindBy(className = "actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id = "PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(id = "PegaGadget1Ifr")
	private WebElement Iframeelement1;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and
	 * the Page Factory
	 */
	public RequestManagerHelp() throws IOException {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}
	}

	@FindBy(xpath = "//table[@class='gridTable '][contains(@pl_prop,'TaggedItems')]")
	private WebElement tableItemsDiscussedDuringManageBillingReview;

	// REQUEST MANAGER HELP
	@FindBy(className = "actionTitleBarLabelStyle")
	WebElement labelManageBillingReqManagerHelpTitle;

	@FindBy(id = "HelpQuestion")
	WebElement txtbxManageBillingReqManagerHelpQuestion;

	@FindBy(id = "HelpResearchCompleted")
	WebElement txtbxManageBillingReqManagerHelpresearchcompleted;

	@FindBy(xpath = "//span[text()='Items Discussed During Manage Billing Review']")
	WebElement lableManageBillingReqManagerHelpItemsDiscussed;

	@FindBy(xpath = "//div[@node_name='ReviewTaggedItems']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableManageBillingReqManagerHelpReview;

	@FindBy(xpath = "//div[@title='Disclose Items Discussed During Manage Billing Review']")
	private WebElement lnktxtItemsDiscussedManageBillingReview;
	
	/*@FindBy(xpath = "//div[text()='Submit']")
	WebElement btnSubmit;*/

	public ErrorLogger getErr() {
		return err;
	}

	public SeleniumUtilities getUtils() {
		return utils;
	}

	public WebElement getsHeaderCompleteBilling() {
		return sHeaderCompleteBilling;
	}

	public WebElement getIframeelement() {
		return Iframeelement;
	}

	public WebElement getLabelManageBillingReqManagerHelpTitle() {
		return labelManageBillingReqManagerHelpTitle;
	}

	public WebElement getTxtbxManageBillingReqManagerHelpQuestion() {
		return txtbxManageBillingReqManagerHelpQuestion;
	}

	public WebElement getTxtbxManageBillingReqManagerHelpresearchcompleted() {
		return txtbxManageBillingReqManagerHelpresearchcompleted;}

	public WebElement getLableManageBillingReqManagerHelpItemsDiscussed() {
		return lableManageBillingReqManagerHelpItemsDiscussed;
	}

	public WebElement getTableManageBillingReqManagerHelpReview() {
		return tableManageBillingReqManagerHelpReview;
	}

	/**
	 * Checking HEader of the Page
	 * 
	 * @param header
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateHeader(WebElement header, String sCheckHEader) throws InterruptedException {
		Thread.sleep(3000);
		if(!utils.isProxyWebelement(header))
			if(utils.isvalueMatch_contain(header.getText().trim(), sCheckHEader))
				return true;
		return false;
	}

	// Check in Value in the Table

	public boolean clickgetBtnSubmit() {
		((JavascriptExecutor) Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",
				this.btnSubmit);
		return utils.clickAnelemnt(this.getBtnSubmit(), "Complete Villing Review ", "Text Box for entering ?Notes");
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Submit')]")
	private WebElement btnSubmit;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions ') or contains(text(),'Other Actions ')]")
	private WebElement btnOtherActions;

	@FindBy(xpath="//*[contains (text(), 'Request Manager Help')]")
	private WebElement lnkOtherReqMgrHelp;

	// Set methods with texts
	public boolean setTxtManageBillingReqManagerHelpQuestion(String sFullName) {
		return utils.enterTextinAnelemnt(this.getTxtbxManageBillingReqManagerHelpQuestion(), sFullName,"Complete Villing Review ", "Submit button");

	}

	public boolean setTxtManageBillingReqManagerHelpresearchcompleted(String sFullName) {
		return utils.enterTextinAnelemnt(this.getTxtbxManageBillingReqManagerHelpresearchcompleted(), sFullName,"Complete Villing Review ", "Submit button");

	}

	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean requestManagerHelpandSubmit() throws InterruptedException {
					if (this.setTxtManageBillingReqManagerHelpQuestion("Question for the customer"))
						if (this.setTxtManageBillingReqManagerHelpresearchcompleted(
								"I validated the records of the customer and have put the details for future reviews"))
							if (this.clickgetBtnSubmit())
								return true;
		return false;

	}

	@SuppressWarnings("unchecked")
	public boolean validatetaggedcheckboxes() {
		ArrayList<String> actual = null, expected = new ArrayList<String>();
		if (utils.clickAnelemnt(this.lnktxtItemsDiscussedManageBillingReview, "Complete Billing", "Items Discussed"))

			// GET THE ACTUAL VALUE FROm THE APPLICATION
			actual = utils.getcolumnStringFromTableByName(this.tableItemsDiscussedDuringManageBillingReview,
					"Description");
		actual.remove(0);
		// GET THE EXPECTED VALUE FROM HASHMAP

		for (Map.Entry<String, String> entry : ds.data.entrySet())
			expected.add(entry.getValue());

		Collections.reverse(expected);

		for (int i = 0; i < actual.size(); i++) {
			System.out.println(actual.get(i) + "---------" + expected.get(i));
			if (actual.get(i).equalsIgnoreCase(expected.get(i)))
				continue;
			else
				return false;
		}

		return true;
	}

	public boolean requestManagerHelpAndSubmit() throws InterruptedException {
			if (this.setTxtManageBillingReqManagerHelpQuestion("Question for the customer"))
				if (this.setTxtManageBillingReqManagerHelpresearchcompleted("I validated the records of the customer and have put the details for future reviews"))
					if (this.clickgetBtnSubmit())
						return true;
		return false;

	}

	public boolean enterTheTextInQuestionAndResearchCompleted(String args[]) throws Exception {
		if (this.setTxtManageBillingReqManagerHelpQuestion(args[0]))
			if (this.setTxtManageBillingReqManagerHelpresearchcompleted(args[1]))
				if (this.clickgetBtnSubmit())
					return true;
		return false;
	}

	// Sprint 3.3

	@FindBy(xpath = "//span[@data-test-id='201801251040560076186883']")
	private WebElement Type;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Category']//following-sibling::div//span")
	private WebElement Category;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Sub-Category']//following-sibling::div//span")
	private WebElement subCategory;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Corporate Received Date']//following-sibling::div//span")
	private WebElement corpReceivedDate;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Expedited?']//following-sibling::div//span")
	private WebElement Expedited;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Reason']//following-sibling::div//span")
	private WebElement ExpeditedReason;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Appeal Type']//following-sibling::div//span")
	private WebElement AppealType;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Incident Start Date']//following-sibling::div//span")
	private WebElement IncidentStartDate;

	@FindBy(xpath = "//label[@for='IsBehavioralHealth']//following-sibling::div//img[@title='Checked']")
	private WebElement BehavioralHealth;

	@FindBy(xpath = "//label[@for='IsPharmacy']//following-sibling::div//img[@title='Checked']")
	private WebElement Pharmacy;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Name of Medicine']//following-sibling::div//span")
	private WebElement MedicineName;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Dosage of the Medicine']//following-sibling::div//span")
	private WebElement MedicineDosage;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Incident End Date']//following-sibling::div//span")
	private WebElement IncidentEndDate;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Is the member in Collections']//following-sibling::div//span")
	private WebElement IsthememberinCollections;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Service Type']//following-sibling::div//span")
	private WebElement ServiceType;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Name of Collection Agency']//following-sibling::div//span")
	private WebElement NameofCollectionAgency;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Contact at Agency']//following-sibling::div//span")
	private WebElement ContactatAgency;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Phone Number']//following-sibling::div//span")
	private WebElement PhoneNumber;

	@FindBy(xpath = "//div[@node_name='GAndAReviewItems']//label[text()='Account Number']//following-sibling::div//span")
	private WebElement AccountNumber;

	@FindBy(xpath = "//span[@data-test-id='201801251050410516192922']")
	private WebElement memberIssue;

	@FindBy(xpath = "//span[@data-test-id='20180125105041051619338']")
	private WebElement memberResolution;

	/*
	 * @SCU #CommonMethodwithArgument:validateItemsDiscussedInGAReviewSection
	 * #Description:This method validates Items Discussed during Grievance and
	 * Appeals Review on Complete Grievance And Appeals Review page like
	 * Type,Category,Sub-Category,Level,Corporate Recieved
	 * Date,Expedited,Reason,Member Issue,Member Resolution
	 * #Arguments:ItemsDiscussed Type:Table Keys:Type#Appeal Type#Incident Start
	 * Date#Incident End Date#Category#Sub-Category#Service Type#Corporate
	 * Recieved Date#Expedited#Expedited Reason#Member Issue#Member
	 * Resolution#Is the member in Collections#Name of Collection Agency#Contact
	 * at Agency#Phone Number#Account Number
	 */
	public boolean validateItemsDiscussedInGAReviewSection(String args[]) {
		utils.waitforpageload();
		boolean returnvar = true;
		String type = "", category = "", subcategory = "", corporateReceivedDate = "", expedited = "", reason = "",
				level = "", member_issue = "", member_resolution = "", behavioral_health = "", pharmacy = "",
				name_of_medicine = "", dosage_of_medicine = "";
		String appeal_type = "", incident_start = "", incident_end = "", service_type = "", mem_in_collection = "",
				nameOfCollectionAgency = "", contactAtAgency = "", phoneNumber = "", accountNumber = "";
		String keyvaluepair = "";
		for (String iterator : args) {
			if (!returnvar) {
				err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":") + 1);
			System.out.println("key " + key + "value  " + value);

			if (key.equalsIgnoreCase("Type")) {
				type = value.trim();
				if (type.equalsIgnoreCase(this.Type.getText().trim())) {
					returnvar = true;
					System.out.println("Type matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Type mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Appeal Type")) {
				appeal_type = value.trim();
				if (appeal_type.equalsIgnoreCase(this.AppealType.getText().trim())) {
					returnvar = true;
					System.out.println("Appeal Type matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Appeal Type mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Incident Start Date")) {
				incident_start = value.trim();
				if (incident_start.equalsIgnoreCase(this.IncidentStartDate.getText().trim())) {
					returnvar = true;
					System.out.println("Incident Start Date matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Incident Start Date mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Behavioral Health")) {
				try {
					Pharmacy.isDisplayed();
					blogger.loginfo("Behavioral Health Checkbox is Displayed");
					System.out.println("Behavioral Health Checkbox is Displayed");
					return true;
				} catch (Exception e) {
					blogger.loginfo("Behavioral Health Checkbox is not Displayed");
					System.out.println("Behavioral Health Checkbox is not Displayed");
					return false;
				}
			} else if (key.equalsIgnoreCase("Pharmacy")) {
				try {
					Pharmacy.isDisplayed();
					blogger.loginfo("Pharmacy Checkbox is Displayed");
					System.out.println("Pharmacy Checkbox is Displayed");
					return true;
				} catch (Exception e) {
					blogger.loginfo("Pharmacy Checkbox is not Displayed");
					System.out.println("Pharmacy Checkbox is not Displayed");
					return false;
				}
			} else if (key.equalsIgnoreCase("Name of Medicine")) {
				name_of_medicine = value.trim();
				if (name_of_medicine.equalsIgnoreCase(this.MedicineName.getText().trim())) {
					returnvar = true;
					System.out.println("Medicine Name matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Medicine Name mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Dosage of The Medicine")) {
				dosage_of_medicine = value.trim();
				if (dosage_of_medicine.equalsIgnoreCase(this.MedicineDosage.getText().trim())) {
					returnvar = true;
					System.out.println("Medicine Dosage matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Medicine Dosage mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Incident End Date")) {
				incident_end = value.trim();
				if (incident_end.equalsIgnoreCase(this.IncidentEndDate.getText().trim())) {
					returnvar = true;
					System.out.println("Incident End Date matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Incident End Date mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Service Type")) {
				service_type = value.trim();
				if (service_type.equalsIgnoreCase(this.ServiceType.getText().trim())) {
					returnvar = true;
					System.out.println("Service Type matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Service Type mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Category")) {
				category = value.trim();
				if (category.equalsIgnoreCase(this.Category.getText().trim())) {
					returnvar = true;
					System.out.println("Category matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Category mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Sub-Category")) {
				subcategory = value.trim();
				if (subcategory.equalsIgnoreCase(this.subCategory.getText().trim())) {
					returnvar = true;
					System.out.println("subCategory matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"subCategory mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Corporate Recieved Date")) {
				corporateReceivedDate = value.trim();
				if (corporateReceivedDate.equalsIgnoreCase(this.corpReceivedDate.getText().trim())) {
					returnvar = true;
					System.out.println("corpReceivedDate matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"corpReceivedDate mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Expedited")) {
				expedited = value.trim();
				if (expedited.equalsIgnoreCase(this.Expedited.getText().trim())) {
					returnvar = true;
					System.out.println("Expedited matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Expedited mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Expedited Reason")) {
				reason = value.trim();
				if (reason.equalsIgnoreCase(this.ExpeditedReason.getText().trim())) {
					returnvar = true;
					System.out.println("ExpeditedReason matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"ExpeditedReason mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Is the member in Collections")) {
				mem_in_collection = value.trim();
				if (mem_in_collection.equalsIgnoreCase(this.IsthememberinCollections.getText().trim())) {
					returnvar = true;
					System.out.println("Is the member in Collections matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Is the member in Collections mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Name of Collection Agency")) {
				nameOfCollectionAgency = value.trim();
				if (nameOfCollectionAgency.equalsIgnoreCase(this.NameofCollectionAgency.getText().trim())) {
					returnvar = true;
					System.out.println("Name of Collection Agency matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Name of Collection Agency mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Contact at Agency")) {
				contactAtAgency = value.trim();
				if (contactAtAgency.equalsIgnoreCase(this.ContactatAgency.getText().trim())) {
					returnvar = true;
					System.out.println("Contact at Agency matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Contact at Agency mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Phone Number")) {
				phoneNumber = value.trim();
				if (phoneNumber.equalsIgnoreCase(this.PhoneNumber.getText().trim())) {
					returnvar = true;
					System.out.println("Phone Number matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Phone Number mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Account Number")) {
				accountNumber = value.trim();
				if (accountNumber.equalsIgnoreCase(this.AccountNumber.getText().trim())) {
					returnvar = true;
					System.out.println("Account Number matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"Account Number mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Member Issue")) {
				member_issue = value.trim();
				if (member_issue.equalsIgnoreCase(this.memberIssue.getText().trim())) {
					returnvar = true;
					System.out.println("memberIssue matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"memberIssue mis-matched with user input");
				}
			} else if (key.equalsIgnoreCase("Member Resolution")) {
				member_resolution = value.trim();
				if (member_resolution.equalsIgnoreCase(this.memberResolution.getText().trim())) {
					returnvar = true;
					System.out.println("memberResolution matched with user input");
					continue;
				} else {
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
							"memberResolution mis-matched with user input");
				}
			} else {
				err.logcommonMethodError("validateItemsDiscussedInGAReviewSection",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				returnvar = false;
			}
		}

		if (returnvar) {
			System.out
					.println("validateItemsDiscussedInGAReviewSection: All values for fields matched with user input");
			return true;
		} else {
			err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Couldnt match GA review fields");
			return false;
		}
	}

	// Sprint 4.2

	@FindBy(xpath = "//span[text()='Items Discussed During Manage Enrollment & Billing Review']")
	WebElement itemsDiscussedSectionEAndB;

	@FindBy(xpath = "//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']//i[@class='icon icon-openclose']")
	WebElement collapseIndicator;

	@FindBy(xpath = "")
	WebElement collapseIndicatorEnrollment;

	@FindBy(xpath = "")
	WebElement collapseIndicatorBilling;

	@FindBy(xpath = "(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[1]")
	WebElement enrollmentInfoCheck;

	@FindBy(xpath = "//span[starts-with(text(),'To send this information')]")
	WebElement enrollmentInstText;
	
	@FindBy(xpath = "(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[2]")
	WebElement billingInfoCheck;


	@FindBy(xpath = "//span[contains(text(),'You will')]")
	WebElement billingInstText;

	public boolean verifyItemsDiscusseDuringManageEAndBReviewSectionIsCollapsed() {
		return !utils.isProxyWebelement(collapseIndicator) && !utils.isProxyWebelement(itemsDiscussedSectionEAndB);
	}

	public boolean expandTheItemsDiscusseDuringManageEAndBReviewSection() {
			if(!utils.isProxyWebelement(collapseIndicator))
				return utils.clickAnelemnt(this.collapseIndicator, "Request Manager Help", "Expand image click");
			return false;
	}

	public boolean expandTheEnrollmentRelatedEnquirySection() {
		if(!utils.isProxyWebelement(collapseIndicatorEnrollment))
			return utils.clickAnelemnt(this.collapseIndicatorEnrollment, "Request Manager Help", "Expand image click");
		return false;
	}

	public boolean expandTheBillingRelatedEnquirySection() {
		if(!utils.isProxyWebelement(collapseIndicatorBilling))
			return utils.clickAnelemnt(this.collapseIndicatorBilling, "Request Manager Help", "Expand image click");
		return false;
	}

	public boolean verifyEnrollmentInfoDiscussedTextAndEnrollmentInstructionalTextIsDisplayed() {
			if(!utils.isProxyWebelement(enrollmentInfoCheck) && !utils.isProxyWebelement(enrollmentInfoCheck))
			{
				String actualText = "To send this information to the Enrollment and Billing area use Request Enrollment and Billing Actions from Other Actions on Complete Enrollment and Billing Review screen.";
				System.out.println("Actual Text: " + actualText);
				String expectedText = enrollmentInstText.getText().replaceAll(",", "").trim();
				System.out.println("Expected Text: " + expectedText);
				return utils.isvalueMatch_contain(actualText, expectedText);
			}
			return false;
				

	}
	
	public boolean clickOnSubmit(){
		
		WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@class='pzbtn-mid'][contains(text(),'Submit')]"));
	   	((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(btnSubmit,"RequestManagerHelp","Submit Button");
	}

	
	 
	public boolean verifyBillingInfoDiscussedTextAndBillingInstructionalTextIsDisplayed() {
			if(!utils.isProxyWebelement(billingInfoCheck) && !utils.isProxyWebelement(billingInstText))
			{
				String actualText = " You will need to contact the group administrator for any billing questions the member has keep the member on the call while you call the group because they will need to validate the member is on the phone with you before they can discuss any billing information with you and the member.";
				String expectedText = billingInstText.getText().replaceAll(",", "").trim();
				return utils.isvalueMatch_contain(actualText, expectedText);
			}
			return false;

	}
	

	public boolean enterTheTextInQuestionAndResearchCompletedWithoutClickingSubmit(String args[]) {
        if (this.setTxtManageBillingReqManagerHelpQuestion(args[0]))
               if (this.setTxtManageBillingReqManagerHelpresearchcompleted(args[1]))
                            return true;
        return false;
	}	

	//Sprint 4.2
	
	public boolean enterTheTextInQuestionAndResearchCompletedWithoutClickingSubmitt(String args[]) {
		if (this.setTxtManageBillingReqManagerHelpQuestion(args[0]))
			if (this.setTxtManageBillingReqManagerHelpresearchcompleted(args[1]))
					return true;
		return false;
	}
	
	
	@FindBy(xpath="//span[text()='Attachments to Solution Central']")
	WebElement AttachToSolutioncentral;
	
	@FindBy(xpath="//table[@pl_prop='D_AttachmentsList.pxResults']")
	WebElement tblattachSC;
	
	public boolean verifyAttachmentToSolutionCentral() throws Exception
	{
		
		utils.validateValueinelement(AttachToSolutioncentral, "Attachments to Solution Central", "Request Manager help", "AttachToSolutioncentral");
		System.out.println("Entered");
    	ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblattachSC);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Document Name");
		valuesGivenManual.add("FileNet Location");
		valuesGivenManual.add("Interaction ID");
		valuesGivenManual.add("Service Request ID");
		valuesGivenManual.add("Category");
		valuesGivenManual.add("");
		valuesGivenManual.add("Uploaded Date");
		valuesGivenManual.add("Uploaded By");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Values in the Attachments to Solution Central table is matched with the values expected");
		
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Values in the Attachments to Solution Central is not matched with the values expected");
			return false;
		}

			
	}
	
	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionItemsReviewedManageClaimsCollapsedB']")
	WebElement itemsReviewedDuringClaimsReview;
	
	public boolean validateClaimsTaggedForDiscussion(String args[]) 
			throws InterruptedException
	{
	utils.waitforpageload();	
	WebElement row =utils.getTablerowbasedonvalues(this.itemsReviewedDuringClaimsReview,args);
	List<WebElement> rowNo = row.findElements(By.tagName("input"));
	Boolean flag = rowNo.get(1).isSelected();
	return true;
	}

	@FindBy(xpath="//b[text()='Items Reviewed During Manage Claim Review']")
	WebElement collapseIndicatorClaimsReview;
	
	public boolean expandTheItemsDiscussedDuringManageClaimsReviewSection() {
		
			return utils.clickAnelemnt(collapseIndicatorClaimsReview, "Request Manager Help", "Expand image click");
	
	}
	
	@FindBy(xpath="//table[@pl_prop='.ReviewedClaims']")
	WebElement ManageClaimReviewTable;
	
	@FindBy(xpath="//h3[text()='Claim Details']")
	WebElement labelValidationMsg;
	
	public boolean clickClaimNumberAndValidateInManageReviewSection(String[] args) throws InterruptedException {
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.ManageClaimReviewTable,args);
		List<WebElement> rowNo = row.findElements(By.xpath(".//a[@data-test-id='2016052408260302164570']"));
		if(utils.clickAnelemnt(rowNo.get(0), "PerformNextAction", "Manage Claim Review section Claims link")) {
			Set<String> window = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+window.size());
			Iterator<String> iterator= window.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow);
			if(utils.validateLabel(labelValidationMsg, "Claim Details")) {
				Driver.pgDriver.switchTo().window(parentWindow);
				return true;
			}
		}
		return false;
	}
	
	@FindBy(xpath="(//span[text()='Request Enrollment and Bi...'])[4]")
	WebElement lnkRequestEnrolmentAndBilingAction;
	
	@FindBy(xpath="(//span[text()='Review Group Billing Info...'])[4]")
	WebElement lnkReviewGroupBillingInfo;
	
	@FindBy(xpath="(//span[text()='Request Manager/OE Help'])[7]")
	WebElement lnkRequestManagerHelp;
	
	@FindBy(xpath="//table[@pl_prop='.TaggedItems']")
	WebElement tblItesmDiscussed;
	
	
	/**
	 * Author: Gopi
	 * Verifies the drop down values present in the other actions drop down
	 */
	
	public boolean verifyTheDropDownValuesInOtherActions()
	{
		if(utils.clickAnelemnt(btnOtherActions, "RequestManagerHelp", "Other Actions"))
			return !utils.isProxyWebelement(lnkRequestEnrolmentAndBilingAction) && !utils.isProxyWebelement(lnkReviewGroupBillingInfo);
		return false;
	}
	
	public boolean verifyItemsDiscussedDuringGroupBillingReview(String[] args)
	{
		return utils.validatetablerowbasedonvalues(tblItesmDiscussed, args);
	}
}
