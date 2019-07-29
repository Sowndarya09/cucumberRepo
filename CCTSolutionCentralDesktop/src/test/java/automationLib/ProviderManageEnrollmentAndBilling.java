package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderManageEnrollmentAndBilling {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	public ProviderManageEnrollmentAndBilling()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(xpath="//*[text()=' WEM']")
	WebElement WEMLink;

	@FindBy(xpath="//*[text()='OnDemand']")
	WebElement OnDemandLink;

	@FindBy(xpath="//*[text()='Transcentra']")
	WebElement TranscentraLink;

	@FindBy(xpath="//*[text()='Customer Account Database (CAD)']")
	WebElement CADLink;

	@FindBy(xpath="//*[text()='Member Payment CSR Portal'] ")
	WebElement MemberPaymentCSRPortalLink;
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;
	
	@FindBy(xpath="//*[text()='Billing Related Inquiry']")
	WebElement BillingRelatedInquiry;
	
	

	public boolean verifyWEMLinkIsNotDisplayed() {
		return utils.isProxyWebelement(WEMLink);
	}

	public boolean verifyOnDemandLinkIsNotDisplayed() {
		return utils.isProxyWebelement(OnDemandLink);
	}

	public boolean verifyTranscentraLinkIsNotDisplayed() {
		return utils.isProxyWebelement(TranscentraLink);
	}

	public boolean verifyCADLinkIsNotDisplayed() {
		return utils.isProxyWebelement(CADLink);
	}

	public boolean verifyMemberPaymentCSRPortalLinkIsNotDisplayed() {
		return utils.isProxyWebelement(MemberPaymentCSRPortalLink);
	}


	public boolean clickSubmit(){
		return utils.clickAnelemnt(SubmitButton, "ProviderManageEnrollmentAndBilling", "SubmitButton");
	}

	public boolean expandBillingRelatedInquiry(){
		return utils.clickAnelemnt(BillingRelatedInquiry, "ProviderManageEnrollmentAndBilling", "BillingRelatedInquiry");
	
	}
	
	@FindBy(xpath="//*[@id='BillingSummaryReview']")
	WebElement BillingSummaryCheckbox;
	public boolean checkBillingRelatedInformationDiscussedWithContractCheckBox(){
		return utils.clickAnelemnt(BillingSummaryCheckbox, "ProviderManageEnrollmentAndBilling", "BillingSummaryCheckbox");
	}
	
	@FindBy(xpath="//div[@node_name='BillingRelatedInquiry']//p")
	WebElement BillingRelatedInquiryMSG;
	public boolean verifyTheInstructionalTextForSG(String[] message)
	
	{
		String BillingRelatedInquiryMSG = message[0];
		System.out.println("Message Given by User: "+BillingRelatedInquiryMSG);
		String BillingRelatedInquiryMSGFromUI = this.BillingRelatedInquiryMSG.getText().replaceAll(",", "").replaceAll("  ", " ");
		System.out.println("Message from the Application: "+BillingRelatedInquiryMSGFromUI);
		return utils.isvalueMatch_compareto(BillingRelatedInquiryMSGFromUI, BillingRelatedInquiryMSG);

	}
	
	
}
