package automationLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.SeleniumUtilities;

public class OutOfNetworkReferralException {

	SeleniumUtilities utils= new SeleniumUtilities();

	public OutOfNetworkReferralException()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(xpath="//label[contains(text(),'Out-of-Network Referral Exception')]")
	WebElement Header;
	
	public boolean validateifOutOfNetworkReferralExceptionScreenIsDisplayed() {
		return !utils.isProxyWebelement(Header);
	}
	
	@FindBy(xpath="//a[@data-test-id='2016052408260302164570']")
	WebElement ClaimNumber;
	
	public boolean displayClaimNumberHyperlink() {
		return !utils.isProxyWebelement(ClaimNumber);
	}
	
	@FindBy(xpath="//span[@data-test-id='2016060305134407047952']")
	WebElement DateOfService;
	
	public boolean displayDateOfService() {
		return !utils.isProxyWebelement(DateOfService);
	}
	
	@FindBy(xpath="//span[@data-test-id='20160208014256055677221']")
	WebElement ChargeAmount;
	
	
	public boolean displayTotalChargedAmount() {
		return !utils.isProxyWebelement(ChargeAmount);
	}
	
	@FindBy(xpath="//span[@data-test-id='20160208014256055978159']")
	WebElement RenderingProviderName;
	
	
	public boolean displayRenderingProviderName() {
		return !utils.isProxyWebelement(RenderingProviderName);
	}
	
	@FindBy(xpath="//span[@data-test-id='20160208014714059445834']")
	WebElement PatientsName;
	
	public boolean displayPatientName() {
		return !utils.isProxyWebelement(PatientsName);
	}
	
	@FindBy(xpath="//label[text()='Patient DOB']/..//span[@data-test-id='2016020801495802784852']")
	WebElement PatientDOB;
	
	public boolean displayPatientDateOfBirth() {
		return !utils.isProxyWebelement(PatientDOB);
	}
	
	@FindBy(xpath="//label[text()='Employer Group Number']/..//span[@data-test-id='2016020801495802784852']")
	WebElement EmployeeGroupNumber;
	
	public boolean displayEmployerGroupNumber() {
		return !utils.isProxyWebelement(EmployeeGroupNumber);
	}
	
	@FindBy(xpath="//label[text()='Product Group Number']/..//span[@data-test-id='2016020801495802784852']")
	WebElement ProductGroupNumber;
	
	public boolean displayProductGroupNumber() {
		return !utils.isProxyWebelement(ProductGroupNumber);
	}
	
	@FindBy(xpath="//table[@pl_prop='TOP.MemberClaim.DPArray']")
	WebElement Membertable;
	
	public boolean selectCheckboxBasedOnValues(String[] args) throws InterruptedException {
		WebElement row = utils.returntablerowbasedonvalues(Membertable, args);
		List<WebElement> rowNo = row.findElements(By.tagName("input"));
		return utils.clickAnelemnt(rowNo.get(1), "OutOfNetworkReferralException", "Membertable");
	}
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement SubmitButton;
	
	public boolean clickOnSubmit() {
		return utils.clickAnelemnt(SubmitButton, "OutOfNetworkReferralException", "SubmitButton");
	}
}
