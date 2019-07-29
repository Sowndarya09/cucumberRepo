package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class Broker_GroupBillingInformation {
	
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	WebDriver driver = Driver.getPgDriver();
	Actions actions = new Actions(driver);
	BaseLogger blogger = new BaseLogger();	
		
	public static WebDriver pgDriver;
	
	public Broker_GroupBillingInformation()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(xpath="//div[text()='Other actions ']")
	WebElement Otheractions;
	
	@FindBy(id="DialogContent")
	WebElement GuidedDialogue;
	
	
	public boolean selectValuesFromOtherActionDropDown(String[] args){
		return utils.selectValueFromListbyVisibleString(Otheractions, args[0], "Broker_GroupBillingInformation", "Otheractions");
	}
	
	@FindBy(xpath="//label[@data-test-id='20190210203542091257331-Label']")
	WebElement LblEffectiveDate;
	
	@FindBy(xpath="//label[@data-test-id='201902102216580814426461-Label']")
	WebElement LblRateType;
	
	@FindBy(xpath="//label[@data-test-id='201902102216580815427786-Label']")
	WebElement LblFirstOfMonth;
	
	@FindBy(xpath="//label[@data-test-id='201902102241430559610119-Label']")
	WebElement LblPaidToDate;
	
	@FindBy(xpath="//label[@data-test-id='201902102241430560611954-Label']")
	WebElement LblDeliquencyStatus;
	
	@FindBy(xpath="//label[@data-test-id='201902102241430560612279-Label']")
	WebElement LblBillToDate;
	
	@FindBy(xpath="//label[@data-test-id='201902102241430561616832-Label']")
	WebElement LblBillDate;
	
	@FindBy(xpath="//label[@data-test-id='201902102241430560613488-Label']")
	WebElement LblBillError;
	
	@FindBy(xpath="//label[@data-test-id='20190210224143056061474-Label']")
	WebElement LblCancelEffDate;
	
	@FindBy(xpath="//label[text()='Cancel Reason']")
	WebElement LblCancelReason;
	
	@FindBy(xpath="//label[@data-test-id='201902102241430560615600-Label']")
	WebElement LblCOBRSN;
	
	@FindBy(xpath="//label[text()='Anniversary Month']")
	WebElement LblAnniversaryMonth;
	
	@FindBy(xpath="//label[@data-test-id='20190214095237046482175-Label']")
	WebElement LblHCRIndicator;
	
	@FindBy(xpath="//label[@data-test-id='201902140952370465822345-Label']")
	WebElement LblEFTIndicator;
	
	@FindBy(xpath="//label[@data-test-id='201902140952370465823835-Label']")
	WebElement LblHoldBillIndicator;
	
	@FindBy(xpath="//label[@data-test-id='201902140952370465824343-Label']")
	WebElement LblBillFrequency;
	
	/**Verify Fields Present in Select Bill Entity
	 * 
	 * @return
	 */
	public boolean verifyFieldsPresentInSelectBillEntity(){
		if(!utils.isProxyWebelement(LblEffectiveDate) && !utils.isProxyWebelement(LblRateType)
				&& !utils.isProxyWebelement(LblFirstOfMonth) && !utils.isProxyWebelement(LblPaidToDate)
				&& !utils.isProxyWebelement(LblDeliquencyStatus) && !utils.isProxyWebelement(LblBillToDate)
				&& !utils.isProxyWebelement(LblBillDate) && !utils.isProxyWebelement(LblBillError)
				&& !utils.isProxyWebelement(LblCancelEffDate) && !utils.isProxyWebelement(LblCancelReason)
				&& !utils.isProxyWebelement(LblCOBRSN) && !utils.isProxyWebelement(LblAnniversaryMonth)
				&& !utils.isProxyWebelement(LblHCRIndicator) && !utils.isProxyWebelement(LblEFTIndicator)
				&& !utils.isProxyWebelement(LblHoldBillIndicator) && !utils.isProxyWebelement(LblBillFrequency))
			return true;
		return false;
	}
	
	@FindBy(xpath="//label[@data-test-id='201902130619290697821321-Label']")
	WebElement LblTotalAmountDue;
	
	@FindBy(xpath="//label[@data-test-id='201902130619290697820841-Label']")
	WebElement LblTotalUnprcessedCash;
	
	@FindBy(xpath="//label[@data-test-id='20190213061929069782222-Label']")
	WebElement LblBalanceAmountDue;
	
	@FindBy(xpath="//label[@data-test-id='201902130619290697823965-Label']")
	WebElement LblTotalRetroCredit;
	
	/**Verify Fields Present in Invoice Section
	 * 
	 * @return
	 */
	public boolean verifyFieldsPresentInInvoiceSection(){
		if(!utils.isProxyWebelement(LblTotalAmountDue) && !utils.isProxyWebelement(LblTotalUnprcessedCash)
				&& !utils.isProxyWebelement(LblBalanceAmountDue) && !utils.isProxyWebelement(LblTotalRetroCredit))
			return true;
		return false;
	}
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement SubmitButton;
	
	/**Clicks on Submit button
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickSubmit() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", SubmitButton);
		return utils.clickAnelemnt(SubmitButton, "Broker_GroupBillingInformation", "SubmitButton");
	}
	
	public boolean validateGuidedDialogue(String[] args){
		return utils.validateLabel(GuidedDialogue, args[0]);
			}
	
	
	
	@FindBy(xpath="//table[@pl_prop='D_GroupBillingHistory.pxResults']")
	WebElement tblInVoice;
	
	/**
	 * Verifies the values pulled for the Invoice table
	 * @param tablevalues
	 * @return
	 * @throws InterruptedException 
	 */
	
	public boolean validateInvoiceTableInputValues(String[] tablevalues) throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", tblInVoice);
		return utils.validatetablerowbasedonvalues(tblInVoice, tablevalues);
	}
	
	@FindBy(xpath="//span[@data-test-id='20190210203542091257331']")
	WebElement labelEffectiveDate;
	
	@FindBy(xpath="//span[@data-test-id='201902102241430559610119']")
	WebElement labelPaidToDate;
	
	@FindBy(xpath="//span[@data-test-id='201902102241430560611954']")
	WebElement labelDelinquencyStatus;
	
	@FindBy(xpath="//label[@for='AnniversaryDate']//following::span[@data-test-id='201902102241430561616832']")
	WebElement labelAnniversaryDate;
	
	@FindBy(xpath="//span[@data-test-id='201902102241430560612279']")
	WebElement labelBillToDate;
	
	@FindBy(xpath="//span[@data-test-id='201902102241430560613488']")
	WebElement labelBillError;
	
	@FindBy(xpath="//span[@data-test-id='201902140952370465823835']")
	WebElement labelHoldBillIndicator;
	
	@FindBy(xpath="//label[@for='OutStandingBal']//following-sibling::div//span[@data-test-id='201902130619290697821321']")
	WebElement labelTotalAmountDue;
	
	
	public boolean validateGroupBillingInformation(String[] grpgeninformationDetails) throws Exception {
		boolean returnvar = true;
				System.out.println("Entered into method");
				JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
				jse.executeScript("arguments[0].scrollIntoView();", labelEffectiveDate);
				String keyvaluepair = "";
				for (String iterator : grpgeninformationDetails) {
					if (!returnvar) {
						err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair+ " Either Your input is wrong or the value found on application is incorrect");
						return false;
					}
					keyvaluepair = iterator;
					String key = iterator.substring(0,iterator.indexOf(":")).toLowerCase();
					String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
					System.out.println("key " + key + "value  " + value);
					if(utils.isvalueMatch_contain(key.toLowerCase(), "effectivedate")){
						returnvar = utils.validateLabel(labelEffectiveDate, value);
						continue;
					} else if(utils.isvalueMatch_contain(key.toLowerCase(), "paiddate")){
						returnvar = utils.validateLabel(labelPaidToDate, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "delinquencystatus")) {
						returnvar = utils.validateLabel(labelDelinquencyStatus, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "billdate")) {
						returnvar = utils.validateLabel(labelBillToDate, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "error")) {
						returnvar = utils.validateLabel(labelBillError, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "anniversarydate")) {
						returnvar = utils.validateLabel(labelAnniversaryDate, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "holdbillind")) {
						returnvar = utils.validateLabel(labelHoldBillIndicator, value);
						continue;
					} else
						err.logcommonMethodError("Broker_GroupBilling","Check your key in yourkeypair. Make sure you are following the same pattern for input");
					return false;
				}
				if (returnvar) {
					System.out.println("Group Billing info checked Successfully");
					return true;
				} else {
					int tot_i = grpgeninformationDetails.length;
					err.logcommonMethodError("Broker_GroupBilling","the value " + grpgeninformationDetails[tot_i - 1].toString()+ " doesnt match with the one in application");
					return false;
				}
	}
	
	
	
	
	public boolean validateInvoiceInformation(String[] invoiceformationDetails) throws Exception {
		boolean returnvar = true;
				System.out.println("Entered into method");
				JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
				jse.executeScript("arguments[0].scrollIntoView();", labelTotalAmountDue);
				String keyvaluepair = "";
				for (String iterator : invoiceformationDetails) {
					if (!returnvar) {
						err.logcommonMethodError("validateInvoiceInformation", "Check your " + keyvaluepair+ " Either Your input is wrong or the value found on application is incorrect");
						return false;
					}
					keyvaluepair = iterator;
					String key = iterator.substring(0,iterator.indexOf(":")).toLowerCase();
					String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
					System.out.println("key " + key + "value  " + value);
					if(utils.isvalueMatch_contain(key.toLowerCase(), "totalamountdue")){
						returnvar = utils.validateLabel(labelTotalAmountDue, value);
						continue;
					} else
						err.logcommonMethodError("Broker_GroupBilling","Check your key in yourkeypair. Make sure you are following the same pattern for input");
					return false;
				}
				if (returnvar) {
					System.out.println("Invoice info checked Successfully");
					return true;
				} else {
					int tot_i = invoiceformationDetails.length;
					err.logcommonMethodError("validateInvoiceInformation","the value " + invoiceformationDetails[tot_i - 1].toString()+ " doesnt match with the one in application");
					return false;
				}
	}
	

	
	
	@FindBy(id="BillingRelatedInfo")
	WebElement chckBxBillingRelatedInfo;
	
	@FindBy(xpath="//div[text()='Confirm']")
	WebElement btnConfirm;
	
	
	/**
	 * Clicks Billing Related Information Discussed With Contact check box
	 * @return
	 */
	public boolean clickBillingRelatedInfoDiscussedWithContact()
	{
		return utils.clickAnelemnt(chckBxBillingRelatedInfo, "Broker_GroupBillingInformation", "Billing Discussed with Contact");
	}
	
	/**
	 * Clicks confirm button in the Confirmation Title page
	 */
	
	
	public boolean clickConfirmButton()
	{
		return utils.clickAnelemnt(btnConfirm, "Broker_GroupBillingInformation", "Confirm");
	}

	
	@FindBy(id="SelectedBillEntity")
	WebElement drpDownBillEntity;
	
	/**
	 * Verfies that the Bill Entity Drop down is enabled in the Group Billing task
	 * @return
	 */
	
	public boolean verifyBillEntityDropDownIsEnabled()
	{
		return !utils.isProxyWebelement(drpDownBillEntity);
	}
	
	/**
	 * Verfies that the Bill Entity Drop down is disabled in the Group Billing task
	 * @return
	 */
	
	public boolean verifyBillEntityDropDownIsDisabled()
	{
		return utils.isProxyWebelement(drpDownBillEntity);
	}
	
	/**
	 * Verifies the drop down values in the Bill Entity
	 * @param args
	 * @return
	 */
	public boolean verifyTheDropDownValuesInBillEntity(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		for(String arg: args)
		{
			al.add(arg);
		}
		return utils.checkvaluesinDropDown(drpDownBillEntity, al);
	}
	
	/**
	 * Selects the Bill Entity bes on the user input
	 */

	public boolean selectBillEntity(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownBillEntity, args[0], "Broker_GroupBillingInformation", "Bill Entity");
	}
	
	@FindBy(xpath="//h3[contains(text(),'Cash Detail')]")
	WebElement tabCashDetail;
	
	@FindBy(xpath="//label[@data-test-id='201903062042200966401661-Label']")
	WebElement labelProcessDateFrom;
	
	@FindBy(xpath="//label[@data-test-id='20190306204220096740253-Label']")
	WebElement labelProcessDateTo;
	
	@FindBy(xpath="(//table[@pl_prop='D_GroupBillingHistory.pxResults'])[2]")
	WebElement tblCashDetail;
	
	
	/**
	 * Clicks the Cash Detail Tab in Group Billing Information Page
	 * @return
	 */
	public boolean clickCashDetailTab()
	{
		return utils.clickAnelemnt(tabCashDetail, "Broker_GroupBillingInformation", "Cash Detail");
	}
	
	/**
	 * Verifies that the Process Date From and To is Displayed under Cash Detail Tab
	 * @return
	 */
	public boolean verifyProcessDateFromAndToIsDisplayedUnderCashDetailTab()
	{
		return !utils.isProxyWebelement(labelProcessDateFrom) && !utils.isProxyWebelement(labelProcessDateTo);
	}
	
	/**
	 * Verifies that the Cash Detail table is Displayed under Cash Detail Tab
	 * @return
	 */
	public boolean verifyCashDetailTableIsDisplayedUnderCashDetailTab()
	{
		return !utils.isProxyWebelement(tblCashDetail);
	}
	
	@FindBy(xpath="//img[@data-test-id='201903131435130044116671']")
	WebElement imgTaggableCheckBox;
	
	/**
	 * Verify Column/Table header of check box with Hover text as Invoice Discussed
	 */
	
	
	public boolean validateTaggableBoxColumnHoverText()
	{
		actions.moveToElement(imgTaggableCheckBox).build().perform();
		String hoverText = pgDriver.findElement(By.xpath("//*[contains(text(),'Invoice Discussed')]")).toString();
		String expectedText = "Invoice Discussed";
		return utils.isvalueMatch_contain(hoverText, expectedText);
	}
	
	@FindBy(id="pyRowSelected1")
	WebElement chckBxInvoicedTagged;
	
	@FindBy(xpath="//input[contains(@id,'pyRowSelected')]")
	List<WebElement> chckBoxesInvoicedTagged;
	
	/**
	 * Verify the taggable check box beside each Invoice line
	 */
	
	public boolean validateTaggableBoxBesideEachInvoiceLine()
	{
		for (WebElement ele : chckBoxesInvoicedTagged)
		{
			//ele.isDisplayed();
			return !utils.isProxyWebelement(ele);
		}
		return false;
	}
	
	@FindBy(xpath="(//span[text()='Request Enrollment and Bi...'])[4]")
	WebElement lnkRequestEnrolmentAndBilingAction;
	
	@FindBy(xpath="(//span[text()='Request Manager/OE Help'])[7]")
	WebElement lnkRequestManagerHelp;
	
	@FindBy(xpath="(//span[text()='Cancel this work'])[7]")
	WebElement lnkCancelThisWork;
	
	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement btnOtherActions;
	
	@FindBy(id="ReasonForContact")
	WebElement drpDownReasonForContact;
	
	@FindBy(id="WrapUpComments")
	WebElement txtBoxNotes;
	
	@FindBy(xpath="//span[text()='Document References']")
	WebElement lnkDocumentReferences;
	
	@FindBy(xpath="//div[@data-test-id='20190426122109001174600']")
	WebElement labelSubmit;
	
	
	
	public boolean verifyDropDownValuesInOtherActions()
	{
		return !utils.isProxyWebelement(lnkRequestEnrolmentAndBilingAction) && !utils.isProxyWebelement(lnkRequestEnrolmentAndBilingAction) && !utils.isProxyWebelement(lnkCancelThisWork);
	}
	
	public boolean selectValuesFromReasonForContactDropDown(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownReasonForContact, args[0], "Broker_GroupBillingInformation", "Reason For Contact");
	}
	
	public boolean enterNotesInGroupBillingReviewSection(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBoxNotes, args[0], "Broker_GroupBillingInformation", "Notes");
	}
	
	public boolean verifyDocumentReferencesIsPresent()
	{		
		return !utils.isProxyWebelement(lnkDocumentReferences);	
	}
	
	public boolean verifySubmitlabelinGroupBillingReviewSection(String[] args)
	{
		//String actual = args[0].replaceAll(", ");
		return utils.validateLabel(labelSubmit, args[0]);
	}
	
	public boolean verifyReasonForContactDropDownValues(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		for(String a: al)
		{
			al.add(a);
		}
		return utils.checkvaluesinDropDown(drpDownReasonForContact, al);
	}
	
	public boolean verifySubmitBtnIsEnabled()
	{
		boolean submitBtn = SubmitButton.isEnabled();
		if(submitBtn)
		{
			blogger.loginfo("Submit btn is enabled");
			return true;
		}else
		{
			err.logcustomerrorwithmessage("Broker_GroupBillingInformation", "verifySubmitBtnIsEnabled", "Submit Button is not enabled");
			return false;
		}
	}
	
	
	public boolean selectValuesFromOtherActionsDropDown(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(btnOtherActions, args[0], "Broker_GroupBillingInformation", "Other Actions");
	}
	
	
}
