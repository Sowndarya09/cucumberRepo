package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class RequestPremiumPaymentReport {



	SeleniumUtilities utils = new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(), 20);
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	public RequestPremiumPaymentReport() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	
	}
	
	
	@FindBy(id="PrimaryReasonforBilling")
	WebElement drpDownReasonForContact;
	
	@FindBy(id="PremiumPaymentReportType")
	WebElement drpDownPremiumPaymentReportType;
	
	@FindBy(id="FaxNumber")
	WebElement txtBxFaxNumber;
	
	@FindBy(id="MemberName")
	WebElement txtBxMemberName;
	
	@FindBy(id="AddressLine1")
	WebElement txtBxAddressLine1;
	
	@FindBy(id="pyCity")
	WebElement txtBxCity;
	
	@FindBy(id="pyPostalCode")
	WebElement txtBxZipCode;
	
	@FindBy(id="pyState")
	WebElement drpDownState;
	
	@FindBy(id="id of the WCF Number")
	WebElement txtBxWCFNumber;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectReasonForContact
	 * #Description: This functionality selects the dropdown value from the Reason For Contact  in the Request Accumulator Review page
	 * #Arguments:  reasonforcontact
	 * Type: Dropdown
	 * keys: Select#Did not understand bill#Made a payment#Need to renew Plan#Policy cancelled#Policy cancelled improperly#Rate or premium changed#Received unexpected refund#Request policy/member cancellation#Request to add newborn/dependent#Requested a copy of a document#Requested a refund#Request update to Automatic Withdrawal#Unable to fill prescription#Update address/other demographics#Update my policy/contract#Request Premium Payment Report by Mail#Request Premium Payment Report by Email#Request Premium Payment Report by Fax
	 */
	public boolean selectReasonForContact(String[] reasonforcontact)
	{
		return	utils.selectDropDownbyVisibleString(this.drpDownReasonForContact, reasonforcontact[0], "RequestPremiumPaymentReport", "Reason For Contact");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectPremiumPaymentReportType
	 * #Description: This functionality selects the dropdown value from the Premium Payment Report Type  in the Request Premium Payment page
	 * #Arguments:  paymentreporttype
	 * Type: Dropdown
	 * keys: Mail#Fax#Upload to WCF
	 */
	public boolean selectPremiumPaymentReportType(String[] paymentreporttype)
	{
		return 		utils.selectDropDownbyVisibleString(this.drpDownPremiumPaymentReportType, paymentreporttype[0], "RequestPremiumPaymentReport", "Reason For Contact");

	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterFaxNumber
	 * #Description: This functionality enters the fax number in the fax number textbox in Request Premium Payment Page
	 * #Argument: faxnumber
	 * Type: Textbox
	 */
	public boolean enterFaxNumber(String[] faxnumber)
	{
		return utils.enterTextinAnelemnt(this.txtBxFaxNumber, faxnumber[0], "RequestPremiumPaymentReport", "Fax Number");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeMemberName
	 * #Description: This functionality changes the member name in the name textbox in Request Premium Payment Page
	 * #Argument: memname
	 * Type: Textbox
	 */
	public boolean changeMemberName(String[] memname)
	{
		return utils.enterTextinAnelemnt(this.txtBxMemberName, memname[0], "RequestPremiumPaymentReport", "Member Name");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeAddressLine1
	 * #Description: This functionality changes the address Line1 in the address textbox in Request Premium Payment Page
	 * #Argument: addresLine1
	 * Type: Textbox
	 */
	public boolean changeAddressLine1(String[] addresLine1)
	{
		return utils.enterTextinAnelemnt(this.txtBxAddressLine1, addresLine1[0], "RequestPremiumPaymentReport", "Address Line 1");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeCity
	 * #Description: This functionality changes the city in the city textbox in Request Premium Payment Page
	 * #Argument: addresLine1
	 * Type: Textbox
	 */
	public boolean changeCity(String[] city)
	{
		return utils.enterTextinAnelemnt(this.txtBxCity, city[0], "RequestPremiumPaymentReport", "City");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterZipCode
	 * #Description: This functionality changes the zip code in the zip code textbox in Request Premium Payment Page
	 * #Argument: zipcode
	 * Type: Textbox
	 */
	public boolean enterZipCode(String[] zipcode)
	{
		return utils.enterTextinAnelemnt(this.txtBxZipCode, zipcode[0], "RequestPremiumPaymentReport", "Zip Code");
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeState
	 * #Description: This functionality changes the state in the state dropdown in Request Premium Payment Page
	 * #Argument: zipcode
	 * Type: Textbox
	 */
	public boolean changeState(String[] state)
	{
		return utils.selectDropDownbyVisibleString(this.txtBxFaxNumber, state[0], "RequestPremiumPaymentReport", "State");
	}
	
	
	public boolean enterWCFNumber(String[] wcfnumber)
	{
		return utils.enterTextinAnelemnt(this.txtBxZipCode, wcfnumber[0], "RequestPremiumPaymentReport", "WCF Number");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickSubmitBtn
	 * #Description: This functionality clicks the Submit button in Request Premium Payment Page
	 * Type: Textbox
	 */
	public boolean clickSubmitBtn()
	{
		if(utils.clickAnelemnt(this.btnSubmit, "RequestPremiumPaymentReport", "Submit")) {
			utils.waitforpageload();
		return true;
		}
		return false;

	}
	

}
