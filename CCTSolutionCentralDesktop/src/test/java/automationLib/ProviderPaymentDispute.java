package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderPaymentDispute {

	SeleniumUtilities utils = new SeleniumUtilities();

	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);
	WebDriverWait wait = new WebDriverWait(Driver.pgDriver, 10);

	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id = "PegaGadget3Ifr")
	WebElement Iframeelement3;

	public ProviderPaymentDispute() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement3);
		} catch (Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}

	@FindBy(xpath = "//*[text()='Items Reviewed During Manage Claim Review']/ancestor::div[@class='layout layout-outline layout-outline-nested']")
	WebElement ItemsReviewedTable;

	/**
	 * This method validates the Table Items Reviewed During Manage Claims
	 * Review in Payment dispute Review Page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateTheTableItemsReviewedDuringManageClaimsReview(String[] args) {
		return utils.validatetablerowbasedonvalues(ItemsReviewedTable, args);
	}

	@FindBy(id = "GACategory")
	WebElement Category;

	@FindBy(id = "GASubCategory")
	WebElement SubCategory;

	@FindBy(id = "GAMemberIssue")
	WebElement DescribeIssue;

	@FindBy(id = "GAMemberExpectedResolution")
	WebElement ExpectedResolution;

	/**
	 * This method Selects the value from Category Drop down and select the
	 * Subcategory from Sub Category drop down, Enter Text in Describe the issue
	 * and What is the expected resolution textboxes in Payment Dispute Page
	 * 
	 * @param args
	 * @return
	 */
	public boolean requiredValuesForPaymentDIspute(String[] args) {
		if (utils.selectDropDownbyVisibleString(Category, args[0], "ProviderPaymentDispute", "Category"))
			if (utils.selectDropDownbyVisibleString(SubCategory, args[1], "ProviderPaymentDispute", "SubCategory"))
				if (utils.selectDropDownbyVisibleString(LineOfBusiness, args[2], "ProviderPaymentDispute",
						"LineOfBusiness"))
					if (utils.enterTextinAnelemnt(DescribeIssue, args[3], "ProviderPaymentDispute", "DescribeIssue"))
						if (utils.enterTextinAnelemnt(ExpectedResolution, args[4], "ProviderPaymentDispute",
								"DescribeIssue"))
							return true;
		return false;
	}

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement SubmitButton;

	/**
	 * This method clicks on submit button in Payment Dispute Page
	 * 
	 * @return
	 */
	public boolean clickOnSubmit() {
		utils.scrolltomiddle();
		return utils.clickAnelemnt(SubmitButton, "ProviderPaymentDispute", "SubmitButton");
	}

	@FindBy(xpath = "//span[text()='Previous Payment Dispute cases for this member from NextGen']")
	WebElement PreviousPaymentDisputeLink;

	/**
	 * This functionality expands Previous Claims Disputes For This Provider For
	 * This Member in Payment Dispute page
	 * 
	 * @return
	 */
	public boolean expandPreviousClaimsDisputesForThisProviderForThisMember() {
		return utils.clickAnelemnt(PreviousPaymentDisputeLink, "ProviderPaymentDispute", "PreviousPaymentDisputeLink");
	}

	@FindBy(xpath = "//span[text()='Previous Payment Dispute cases for this member from NextGen']/ancestor::*[@id='EXPAND-OUTERFRAME']//table[@id='EXPAND-OUTERFRAME']")
	WebElement PreviousPaymentDisputeTable;

	/**
	 * This method validates The Values On Expanded NextGen Case Record
	 * 
	 * @return
	 */
	public boolean validateTheValuesOnExpandedNextGenCaseRecord(String[] tablevalues) {
		return utils.validatetablerowbasedonvalues(PreviousPaymentDisputeTable, tablevalues);
	}

	@FindBy(xpath = "//a[@data-test-id='2018051416515401314027']")
	List<WebElement> NextGenCaseID;

	@FindBy(xpath = "//label[@for='RequestType']/following-sibling::div")
	WebElement Requesttype;

	@FindBy(xpath = "//label[text()='NextGen Case ID']/..//span[@data-test-id='20160208012641035648291']")
	WebElement NextGenCaseIDValue;

	@FindBy(xpath = "//label[text()='Case Type']/..//span[@data-test-id='20160208012641035648291']")
	WebElement CaseTypeValue;

	@FindBy(xpath = "//label[text()='Request Type']/..//span[@data-test-id='20160208012641035648291']")
	WebElement RequestTypeValue;

	@FindBy(xpath = "//label[text()='Company Received Date']/..//span[@data-test-id='20160208012641035648291']")
	WebElement CompanyReceivedDateValue;

	@FindBy(xpath = "//label[text()='Case Status']/..//span[@data-test-id='20160208012641035648291']")
	WebElement CaseStatusValue;

	/**
	 * This method Click on NextGen case ID and validates the values in NextGen
	 * case Details Pop-up and close the Op-up
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickOnNextGenCaseIDAndValidateDeatilsInNextGenPopUp(String[] args) throws InterruptedException {
		boolean flag = false;
		for (int i = 0; i < NextGenCaseID.size(); i++) {
			if (utils.validateLabel(NextGenCaseID.get(i), args[0]))
				flag = utils.clickAnelemnt(NextGenCaseID.get(i), "ProviderPaymentDispute", "NextGenCaseID");
		}

		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("Number" + handles.size());
		Iterator<String> iterator1 = handles.iterator();
		while (iterator1.hasNext()) {
			subWindowHandler = iterator1.next();
			System.out.println("subWindowHandler" + subWindowHandler);
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		Thread.sleep(2000);

		args[0] = null;
		args = Arrays.stream(args).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);

		boolean returnvar;
		returnvar = true;
		String keyvaluepair = "";
		for (String iterator : args) {
			keyvaluepair = iterator;
			if (!returnvar) {
				err.logcommonMethodError("ProviderCSRReviewResolveRequest", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1);

			if (utils.isvalueMatch_contain(key, "nextgen case")) {
				returnvar = utils.validateLabel(NextGenCaseIDValue, value);
				continue;
			} else if (utils.isvalueMatch_compareto(key, "case type")) {
				returnvar = utils.validateLabel(CaseTypeValue, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "request")) {
				returnvar = utils.validateLabel(RequestTypeValue, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "company")) {
				returnvar = utils.validateLabel(CompanyReceivedDateValue, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "case status")) {
				returnvar = utils.validateLabel(CaseStatusValue, value);
				continue;
			} else
				err.logcommonMethodError("ProviderPaymentDisputeReview",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		Driver.pgDriver.switchTo().window(parentWindowHandler);
		if (returnvar) {
			blogger.loginfo("Verified successfully");
			return true;
		} else
			return false;
	}

	@FindBy(xpath = "//div[@class='pz-po-c smarttip-container']")
	WebElement LOBHoverText;

	/**
	 * This functionality validates that the appropriate description for the
	 * Line of Business is displayed when we hover over the the Line of Business
	 * dropdown in Payment Dispute Page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyLineofBuisnessWhenHover(String[] args) throws InterruptedException {
		String actual = utils.hoverOverElementAndGetText(LineOfBusiness, LOBHoverText);
		System.out.println(actual);
		return utils.isvalueMatch_contain(actual, args[0]);
	}

	@FindBy(id = "LOBForPD")
	WebElement LineOfBusiness;

	/**
	 * This functionality validates the Line of Buisness dropdown options are
	 * available or not in the Payment Dispute Page
	 * 
	 * @return
	 */
	public boolean validateLineofBuisnessDropDownValuses(String[] args) {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) {
			valuestobechecked.add(args[0]);
		}

		return utils.checkvaluesinDropDown(LineOfBusiness, valuestobechecked);
	}

	@FindBy(id = "IsPDEscalation")
	WebElement EscalationCheckBox;

	@FindBy(id = "PDEscalationReason")
	WebElement EscalationReason;

	/**
	 * This functionality checks the escalation checkBox and selects the
	 * escalation reason in the Provider payment dispute page
	 * 
	 * @return
	 */
	public boolean checkEscalationAndSelectEscalationReason(String[] args) {
		if (utils.clickAnelemnt(EscalationCheckBox, "ProviderPaymentDispute", "EscalationCheckBox"))
			return utils.selectDropDownbyVisibleString(EscalationReason, args[0], "ProviderPaymentDispute",
					"EscalationReason");
		return false;
	}

	/**
	 * This functionality validates the escalation reason dropdown values in
	 * Provider Payment Dispute Page
	 * 
	 * @return
	 */
	public boolean validateEscalationReason(String[] args) {

		ArrayList<String> valuestobechecked = new ArrayList<String>();

		for (int i = 0; i < args.length; i++)
			valuestobechecked.add(args[i]);

		return utils.checkvaluesinDropDown(EscalationReason, valuestobechecked);
	}

	@FindBy(xpath = "//table[@pl_prop='D_NextGenCases.pxResults']")
	WebElement NextGenTable;

	/**
	 * This method validates The Values On Expanded NextGen Case Record
	 * 
	 * @param tablevalues
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateTheValuesandExpandTheNextGenCaseRecord(String[] tablevalues) throws InterruptedException {
		WebElement row = utils.returntablerowbasedonvalues(NextGenTable, tablevalues);
		List<WebElement> rowNo = row.findElements(By.tagName("td"));
		rowNo.get(0).click();
		return !utils.isProxyWebelement(PreviousPaymentDisputeTable);
	}

	@FindBy(xpath = "//span[text()='Associated Case Details']")
	WebElement AssociatedCaseDetails;

	@FindBy(xpath = "(//label[text()='Case Type']/..//span[@data-test-id='20160208012641035648291'])[2]")
	WebElement CaseType;

	@FindBy(xpath = "//label[text()='Claim ID']/..//span[@data-test-id='20160208012641035648291']")
	WebElement ClaimID;

	@FindBy(xpath = "(//label[text()='Case Status']/..//span[@data-test-id='20160208012641035648291'])[2]")
	WebElement CaseStatus;

	@FindBy(xpath = "//label[text()='Reason']/..//span[@data-test-id='20160208012641035648291']")
	WebElement Reason;

	@FindBy(xpath = "//label[text()='Sub Reason']/..//span[@data-test-id='20160208012641035648291']")
	WebElement SubReason;

	@FindBy(xpath = "//label[text()='Priority']/..//span[@data-test-id='20160208012641035648291']")
	WebElement Priority;

	@FindBy(xpath = "//label[text()='Level']/..//span[@data-test-id='20160208012641035648291']")
	WebElement Level;

	@FindBy(xpath = "//label[text()='Service Type']/..//span[@data-test-id='20160208012641035648291']")
	WebElement ServiceType;

	/**
	 * This method expands Associated CaseDeails In NextGenPop and validates the
	 * values under Case Details in NextGen Pop-up
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean expandAssociatedCaseDeailsInNextGenPop(String[] args) throws InterruptedException {

		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("Number" + handles.size());
		Iterator<String> iterator1 = handles.iterator();
		while (iterator1.hasNext()) {
			subWindowHandler = iterator1.next();
			System.out.println("subWindowHandler" + subWindowHandler);
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		Thread.sleep(2000);

		utils.clickAnelemnt(AssociatedCaseDetails, "ProviderPaymentDispute", "AssociatedCaseDetails");

		utils.waitforpageload();
		boolean returnvar;
		returnvar = true;
		String keyvaluepair = "";
		for (String iterator : args) {
			keyvaluepair = iterator;
			if (!returnvar) {
				err.logcommonMethodError("ProviderCSRReviewResolveRequest", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":") + 1);

			if (utils.isvalueMatch_contain(key, "Associated Case ID")) {
				WebElement element = Driver.pgDriver.findElement(By.xpath("//span[text()='" + value + "']"));
				returnvar = utils.clickAnelemnt(element, "ProviderPaymentDispute", "Case ID Link");
				continue;
			} else if (utils.isvalueMatch_compareto(key, "Case Type")) {
				returnvar = utils.validateLabel(CaseType, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "Claim ID")) {
				returnvar = utils.validateLabel(ClaimID, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "Case Status")) {
				returnvar = utils.validateLabel(CaseStatus, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "Reason")) {
				utils.scrolltomiddle();
				returnvar = utils.validateLabel(Reason, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "Sub Reason")) {
				returnvar = utils.validateLabel(SubReason, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "Priority")) {
				returnvar = utils.validateLabel(Priority, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "Level")) {
				returnvar = utils.validateLabel(Level, value);
				continue;
			} else if (utils.isvalueMatch_contain(key, "Service Type")) {
				returnvar = utils.validateLabel(ServiceType, value);
				continue;
			} else
				err.logcommonMethodError("ProviderPaymentDisputeReview",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if (returnvar) {
			blogger.loginfo("Verified successfully");
			return true;
		} else {
			int tot_i = args.length;
			err.logcommonMethodError("ProviderCSRReviewResolveRequest",
					"the value " + args[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}
	}

	/**
	 * This functionality selects the escalate radio button from the previously
	 * submited payment dispute based on the SR ID Payment dispute Page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectEscalationRadioButtonForPreviouslySubmitedPaymentDispute() throws InterruptedException {
		System.out.println("String Value is: " + MemberComposite.SRIDAfterSubstring);
		String[] tablevalues = { "SR-ID:" + MemberComposite.SRIDAfterSubstring, "Escalated:No" };
		WebElement row = utils.returntablerowbasedonvalues(NextGenTable, tablevalues);
		List<WebElement> rowNo = row.findElements(By.tagName("td"));
		rowNo.get(1).click();
		return !utils.isProxyWebelement(EscalationReason);

	}

	/**
	 * This functionality selects the escalation reason for an existing payment
	 * dispute and enter the notes in the Payment dispute Page
	 * 
	 * @return
	 */
	public boolean selectEscalationReasonForExistingPaymentDispute(String[] args) {
		return utils.selectDropDownbyVisibleString(EscalationReason, args[0], "ProviderPaymentDispute",
				"EscalationReason");
	}

	@FindBy(xpath = "//div[text()='Clear Selected Escalation']")
	WebElement ClearSelectedEscalationButton;

	/**
	 * This method validates the Clear Selected Escalation button in Payment
	 * Dispute Page is Active
	 * 
	 * @return
	 */
	public boolean validateClearSelectedEscalationIsActive() {
		if (!utils.isProxyWebelement(ClearSelectedEscalationButton)) {
			String color = ClearSelectedEscalationButton.getCssValue("color");
			String disabledvalue = ClearSelectedEscalationButton.getAttribute("disabled");
			if (utils.isvalueMatch_contain(color, "blue") && utils.isvalueMatch_contain(disabledvalue, "null"))
				return true;
		}
		return false;

	}

	@FindBy(id = "IsRelatedToOtherMember")
	WebElement IsRelatedToOtherMember;

	/**
	 * This functionality selects the Is this related to more claims for other
	 * members radio button on the Payment dispute Page
	 * 
	 * @return
	 */
	public boolean selectIsThisRelatedToMoreClaimsForOtherMembersButton() {
		return utils.clickAnelemnt(IsRelatedToOtherMember, "ProviderPaymentDispute", "IsRelatedToOtherMember");
	}

	@FindBy(id = "IsRelatedToMember")
	WebElement IsRelatedToMember;

	/**
	 * This functionality selects the Is this related to more claims for this
	 * member radio button on the Payment dispute Page
	 * 
	 * @return
	 */
	public boolean selectIsThisRelatedToMoreClaimsForThisMemberButton() {
		return utils.clickAnelemnt(IsRelatedToMember, "ProviderPaymentDispute", "IsRelatedToMember");
	}

	@FindBy(id = "DialogContent")
	WebElement DialogContent;

	/**
	 * This functionality validates the Guided Dialog Message in the Payment
	 * Dispute Page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateGuidedDialogMessage(String[] args) {
		String actual = DialogContent.getText().replaceAll("\n", "").replaceAll(",", "");
		System.out.println(actual);
		String expected = args[0];
		System.out.println(expected);
		return utils.isvalueMatch_contain(actual, expected);
	}

	/**
	 * This method validates the name of Clear Selected Escalation button in
	 * Payment Dispute Page
	 * 
	 * @return
	 */
	public boolean validateNameOfClearSelectedEscalation() {
		return !utils.isProxyWebelement(ClearSelectedEscalationButton);
	}

	/**
	 * This method validates the Clear Selected Escalation button in Payment
	 * Dispute Page is greyed out
	 * 
	 * @return
	 */
	public boolean validateClearSelectedEscalationIsGreyedOut() {
		String disabledvalue = ClearSelectedEscalationButton.getAttribute("disabled");
		return utils.isvalueMatch_contain(disabledvalue, "null");
	}

	@FindBy(xpath = "//*[@data-test-id='201809281344180664182217']")
	WebElement PDIcon;

	@FindBy(xpath = "//*[@class='arrow top']/..//div[@id='poc0']")
	WebElement PDHovertext;

	/**
	 * This functionality validates the Payment Disputes Hover text as Payment
	 * Dispute at CLaims Details Grid in Claims Review Page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyPaymentDisputesHoverTextinPDpage() throws InterruptedException {
		String actual = utils.hoverOverElementAndGetText(PDIcon, PDHovertext);
		System.out.println(actual);
		return utils.isvalueMatch_contain(actual, "Payment Dispute");
	}
	
	/**This functionality selects the SR id from the previously submited payment dispute based on the fetched SR ID in Payment dispute Page
	 * 
	 * @return
	 */
	public boolean selectSrIdForPreviouslySubmitedPaymentDispute() {
		String webElement = "//a[text()='"+MemberComposite.SRIDAfterSubstring+"']";
		if(utils.clickAnelemnt(Driver.pgDriver.findElement(By.xpath(webElement)), "Payment Dispute", "SR ID")) {
			String alerttext = Driver.pgDriver.switchTo().alert().getText();
			if(utils.isvalueMatch_contain(alerttext,"Grievance and Appeals / Payment Dispute"))
				return utils.isAlertPresent(); 
		}
		return false;
			
	}

	@FindBy(xpath = "//select[@id='LOBForPD']")
	WebElement LOBDropDown;

	/**
	 *This functionality Validates the Line of business based on the Provider state in the Payment Dispute Page
	 */
	public boolean validateLOBInPaymentDispute(String args[]) {
		
			Select sel = new Select(LOBDropDown);
			String lobDefaultValue = sel.getFirstSelectedOption().getText();
			return utils.isvalueMatch_contain(lobDefaultValue, args[0]);
			
		
		}

	@FindBy(id="PrefMOC")
	WebElement PreferredMethodOfContact;
	
	public boolean verifyValuesInPreferredMethodOfcontact(String[] args) {
		
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		
		for(String value:args)
			valuestobechecked.add(value);
		
		return utils.checkvaluesinDropDown(PreferredMethodOfContact, valuestobechecked);
	}
	
	
	public boolean selectMethodOfContact(String[] args) {
		return utils.selectDropDownbyVisibleString(PreferredMethodOfContact, args[0], "ProviderPaymentDispute", "PreferredMethodOfContact");
	}
	
	@FindBy(xpath="//div[@data-test-id='201902280746070026462201']")
	WebElement labelDisclaimerMessage;
	
	public boolean validateDisclaimerMessage(String[] args)
	{
		String actaulMsg = args[0];
		String expectedMsg = labelDisclaimerMessage.getText();
		return utils.isvalueMatch_contain(actaulMsg, expectedMsg);
	}
	
	public boolean validateDisclaimerMessageNotPresent()
	{
		return utils.isProxyWebelement(labelDisclaimerMessage);
	}
}
