package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerRequestEnrollmentAndBillingAction {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	WebDriver driver = Driver.getPgDriver();
	Actions actions = new Actions(driver);
	BaseLogger blogger = new BaseLogger();	
		
	public static WebDriver pgDriver;
	
	public BrokerRequestEnrollmentAndBillingAction()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	

	@FindBy(id="RequestBillingReason")
	WebElement drpDownReasonForContact;
	
	@FindBy(id="RequestBillingAction")
	WebElement drpDownRequestedAction;
	
	@FindBy(id="pyTemplateTextArea")
	WebElement txtNotes;
	
	@FindBy(xpath="//span[contains(text(),'Document References')]")
	WebElement lnkDocumentReferences;
	
	@FindBy(xpath="(//span[text()='Request Enrollment and Bi...'])[4]")
	WebElement lnkRequestEnrolmentAndBilingAction;
	
	@FindBy(xpath="(//span[text()='Request Manager/OE Help'])[7]")
	WebElement lnkRequestManagerHelp;
	
	@FindBy(xpath="(//span[text()='Cancel this work'])[7]")
	WebElement lnkCancelThisWork;
	
	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement btnOtherActions;
	
	@FindBy(id="EnrollmentandBillingSelectionBilling")
	WebElement rdoBtnBilling;
	
	@FindBy(id="EnrollmentandBillingSelectionEnrollment")
	WebElement rdoBtnEnrollment;
	
	@FindBy(id="UrgentRequest")
	WebElement chckBxUrgentRequest;
	
	@FindBy(id="Notes")
	WebElement txtBxNotes;
	
	public boolean verifyDropDownValuesInOtherActions()
	{
		return !utils.isProxyWebelement(lnkRequestEnrolmentAndBilingAction) && !utils.isProxyWebelement(lnkRequestEnrolmentAndBilingAction) && !utils.isProxyWebelement(lnkCancelThisWork);
	}
	
	public boolean selectValuesFromOtherActionsDropDown(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(btnOtherActions, args[0], "Broker_GroupBillingInformation", "Other Actions");
	}
	
	
	
	public boolean verifyDropDownValuesInReasonForContact(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		for(String a: al)
		{
			al.add(a);
		}
		return utils.checkvaluesinDropDown(drpDownReasonForContact, al);
	}
	
	public boolean verifyDropDownValuesInRequestedAction(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		for(String a: al)
		{
			al.add(a);
		}
		return utils.checkvaluesinDropDown(drpDownRequestedAction, al);
	}
	
	public boolean verifyBillingRdoBtnIsEnabled()
	{
		boolean billingRdoBtn = rdoBtnBilling.isEnabled();
		if(billingRdoBtn)
		{
			blogger.loginfo("Billing Radio Button is enabled");
			return true;
		}
		else
		{
			blogger.loginfo("Billing Radio Button is diabled");
			return false;
		}
	}
	
	public boolean verifyEnrollmentRdoBtnIsDisabled(String[] args)
	{
		boolean enrollmentRdoBtn = rdoBtnEnrollment.isEnabled();
		if(!enrollmentRdoBtn)
		{
			blogger.loginfo("Enrollment Radio Button is disabled");
			return true;
		}
		else
		{
			blogger.loginfo("Enrollment Radio Button is enabled");
			return false;
		}
	}


}
