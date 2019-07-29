package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class SendMedicalReview {

	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement1;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeader;

	public SendMedicalReview()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}
		catch(Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}

	@FindBy(id="pyNote")
	private WebElement notesTxt;



	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterNotesText
	 * #Description:This method enters Notes text in 'Request Claims Medical Review' page.
	 * #Arguments:Notes
	 * Type:TextBox
	 */
	public boolean enterNotes(String args[]){
			if(utils.validateHeader(this.sHeader, "Request Claims Medical Review"))
				return utils.enterTextinAnelemnt(this.notesTxt, args[0], "RequestClaimsMedicalReview", "Notes textarea");
			return false;
				
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in 'Request Claim Medical Review' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit,"RequestClaimsMedicalReview","Submit Button");
	}

	@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	private WebElement errGAText;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateGAMsgInRequestClaimsMedicalReview
	 * #Description:This method validates message displayed when user submits with 'Grievance and Appeals Indicator' checked, but user doesnt launch 'Grievance and Appeals' task
	 * Type:Textbox
	 */
	public boolean validateGAMsgInRequestClaimsMedicalReview(){
			String errGAText=this.errGAText.getText().trim();
			System.out.println(errGAText);
			String actualText = "You have tagged Claim(s) indicating a Grievance or Appeal but have not opened a Grievance and Appeal Task. Open the Grievance and Appeal task from the other actions or uncheck the respective claim indicating a 'Grievance or Appeal' from 'View Claim Details' screen and click Submit.";
			return utils.isvalueMatch_contain(actualText, errGAText);
	}


	//Regression

	@FindBy(id="PrimaryReasonforBilling")
	WebElement drpDownReasonForContact;

	/*
	 * @SCU
	 * #CommonMethodwithArgument: selectReasonForContact
	 * #Description:This method selects the value given by the user in the Reason for contact dropdown
	 * Type: Dropdown
	 */

	public boolean selectReasonForContact(String[] reason)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReasonForContact, reason[0], "RequestClaimsMedicalReview", "Reason For Contact");
	}

	@FindBy(xpath="//table[@pl_prop='.MedicalReviewClaims']//a[text()=' Add']")
	WebElement addClaimNumberForMedicalReview;

	@FindBy(xpath="//select[@id='ClaimID']")
	WebElement selectClaimNumberForMedicalReview;

	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);
	/*
	 * @SCU
	 * #CommonMethodwithArgument:addClaimNumberForMedicalReview
	 * #Description:This method adds a Claim Number For MedicalReview
	 * #Arguments:ClaimNumber
	 * Type:Textbox
	 */

	public boolean addClaimNumberForMedicalReview(String[] claimNumber)
	{
			if(utils.clickAnelemnt(this.addClaimNumberForMedicalReview, "RequestClaimsMedicalReview", "Add Button In ClaimNumber For MedicalReview"))
			wait.until(ExpectedConditions.visibilityOf(this.selectClaimNumberForMedicalReview));
			return utils.selectDropDownbyVisibleString(this.selectClaimNumberForMedicalReview, claimNumber[0], "RequestClaimsMedicalReview", "Select ClaimNumber For MedicalReview");
	}

	@FindBy(xpath="//select[@id='MedicalReviewResponse']")
	WebElement DrpDwnCustomerServiceResponse;

	public boolean VerifyDrpDwnCustomerServiceResponse(String[] DrpdwnValues)
	{
		System.out.println("Entered into the method");
		ArrayList<String> dropdownoptions = new ArrayList<String>();
		int length=DrpdwnValues.length;
		for(int i=0;i<length;i++)  
		{
			String tempval=DrpdwnValues[i];
			tempval=tempval.toLowerCase().trim();
			dropdownoptions.add(tempval);
			System.out.println("The drop down value is"+tempval);
		}
		try
		{
			wait.until(ExpectedConditions.visibilityOf(this.DrpDwnCustomerServiceResponse));
			return utils.checkvaluesinDropDown(DrpDwnCustomerServiceResponse, dropdownoptions);
		}catch(Exception e)
		{
			err.logcommonMethodError("RequestClaimsMedicalReview", "selectReasonForContact");
			return false;
		}
	}

	/**Selects Customer service dropdown and clicks on submit
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectCustomerServiceDrpdownAndSubmit(String[] args) {
		if(utils.selectDropDownbyVisibleString(DrpDwnCustomerServiceResponse, args[0], "Send Medical Review", "DrpDwnCustomerServiceResponse"))
			if(utils.scrolltomiddle())
			return utils.clickAnelemnt(this.btnSubmit,"RequestClaimsMedicalReview","Submit Button");
		return false;
	}
	
	public boolean selectCustomerServiceDrpdown(String[] args) {
		return utils.selectDropDownbyVisibleString(DrpDwnCustomerServiceResponse, args[0], "Send Medical Review", "DrpDwnCustomerServiceResponse");
			
	}

}
