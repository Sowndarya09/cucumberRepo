package automationLib;

import org.openqa.selenium.By;
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

public class RequestClaimsMedicalReview {

	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeader;
	
	public RequestClaimsMedicalReview()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	
	@FindBy(id="pyNote")
	private WebElement notesTxt;
	
	@FindBy(id="MedicalReviewResponse")
	private WebElement customerreason;
	
	
	
	public boolean Customerservicereason(String[] reason)
	{
			return utils.selectDropDownbyVisibleString(this.customerreason, reason[0], "RequestClaimsMedicalReview", "Reason For Contact");
	}
	
	

	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterNotesText
	 * #Description:This method enters Notes text in 'Request Claims Medical Review' page.
	 * #Arguments:Notes
	 * Type:TextBox
	 */
	public boolean enterNotes(String args[]){
	
			return utils.enterTextinAnelemnt(this.notesTxt, args[0], "RequestClaimsMedicalReview", "Notes textarea");
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
			return utils.isvalueMatch_contain(errGAText, "You have tagged Claim(s) indicating a Grievance or Appeal but have not opened a Grievance and Appeal Task. Open the Grievance and Appeal task from the other actions or uncheck the respective claim indicating a 'Grievance or Appeal' from 'View Claim Details' screen and click Submit.");
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
		
		@FindBy(xpath="//table[@pl_prop='.DocumentReferenceNumber']//a[text()=' Add']")
		WebElement addDocumentReferenceForMedicalReview;
		
		
		@FindBy(xpath="//select[contains(@id,'ClaimID')]")
		WebElement selectClaimNumberForMedicalReview;
		
		@FindBy(xpath="//select[contains(@id,'DocumentReferenceType')]")
		WebElement drpDownDocumentReference;
		
		@FindBy(xpath="//input[contains(@id,'DCNDocumentIDIndicator1')]")
		WebElement txtBxDocumentReferenceNumber;
		
		@FindBy(xpath="//input[@id='AdjustmentDate']")
		WebElement adjustmentdate;
		
		public boolean Adjdate(){
			return utils.enterTextinAnelemnt(adjustmentdate,"01012019", "RequestClaimsmedicalReview", "adjdate");
		}
		
		
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
				 utils.waitforpageload();
				 return utils.selectDropDownbyVisibleString(this.selectClaimNumberForMedicalReview, claimNumber[0], "RequestClaimsMedicalReview", "Select ClaimNumber For MedicalReview");
		
		}
		
		public boolean addDocumnetReferenceForMedicalReview(String[] args)
		{
				if(utils.clickAnelemnt(this.addDocumentReferenceForMedicalReview, "RequestClaimsMedicalReview", "Add Button In ClaimNumber For MedicalReview"))
					wait.until(ExpectedConditions.visibilityOf(this.drpDownDocumentReference));
				if(utils.selectDropDownbyVisibleString(this.drpDownDocumentReference, args[0], "RequestClaimsMedicalReview", "Select ClaimNumber For MedicalReview"))
					return utils.enterTextinAnelemnt(txtBxDocumentReferenceNumber, args[1], "RequestClaimsMedicalReview", "Document Reference Number");
				return false;
		}
		
		
		
	
	
}
