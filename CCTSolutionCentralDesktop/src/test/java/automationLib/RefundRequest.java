package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;


public class RefundRequest {
	
	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement1;

	
	public RefundRequest()
	{
		try
		{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement1);// change the driver 
		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
		}
	}
	
	
	
	@FindBy (xpath="//input[@id='CheckClearedNo']")	
	private WebElement HasTheCheckClearedNo;

	@FindBy (xpath="//input[@id='CheckClearedYes']")	
	private WebElement HasTheCheckClearedYes;
	
	public boolean selectHasTheCheckCleared(String args[]){
			if(args[0].equalsIgnoreCase("Yes"))
				return utils.clickAnelemnt(HasTheCheckClearedYes,"RefundRequest", "HasTheCheckCleared Yes");
			else
				return utils.clickAnelemnt(HasTheCheckClearedNo,"RefundRequest", "HasTheCheckCleared No");
	}
	
	
	@FindBy(xpath="//*[@data-test-id='201809241239240178206501']")
	WebElement InstructionalText;
	
	
	public boolean validateInstructionalTextForCheckClearedNo(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(InstructionalText.getText());
		return utils.validateLabel(InstructionalText, args[0]);
	}

	
	
	@FindBy(name="$PpyWorkPage$pRequestedAction")
	private WebElement RequestedAction;
	
	public boolean selectRequestedActionDropdown(String[] args){
			return utils.selectDropDownbyVisibleString(RequestedAction, args[0], "RefundRequest", "Requested Action");   	
	}
	
	@FindBy (xpath="//span[text()='Is this for a Full or Partial Refund?']")	
	private WebElement IsThisForAFullOrPartialRefund;

	@FindBy (xpath="//input[@id='FullPartialRefundFull']")	
	private WebElement FullRefund;
	
	@FindBy (xpath="//input[@id='FullPartialRefundPartial']")	
	private WebElement PartialRefund;
	
	public boolean selectIsThisForFullOrPartialRefund(String[] args) throws InterruptedException{
		Thread.sleep(3000);
		utils.scrolltomiddle();
		System.out.println("Entered");
		/*WebElement element = FullRefund;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);*/
		if(args[0].contains("Full")){
			return utils.clickAnelemnt(FullRefund, "RefundRequest", "Full Radio Btn");
		}
		else if(args[0].contains("Partial")){
			return utils.clickAnelemnt(PartialRefund, "RefundRequest", "Partial Radio Btn");
		}
		else{
			System.out.println("Enter valid value to Select Refund Type");
			return false;
		}
	}
	
	@FindBy (xpath="//span[text()='Notes']")	
	private WebElement Notes;
	
	
	@FindBy (xpath="//textarea[@id='RefundRequestNotes']")	
	private WebElement NotesTxtbox;
	
	public boolean enterNotes(String[] notes)
	{
			return utils.enterTextinAnelemnt(this.NotesTxtbox, notes[0], "RefundRequest", "Notes textbox");
	}
	
	@FindBy (xpath="//a[@data-test-id='201708291535460418281322']")	
	private WebElement DocumentReferences;
	

	@FindBy (xpath="//select[@id='DocumentReferenceType1']")	
	private WebElement DCNDocumentReferenceType;
	
	@FindBy (xpath="//input[@id='DCNDocumentIDIndicator1']")	
	private WebElement DCNDocumentReferenceNumber;
	
	public boolean clickAddInDocReference()
	{
		return utils.clickAnelemnt(DocumentReferences, "RefundRequest", "Document References");
	}
	
	public boolean selectDocType(String[] args)
	{
		return utils.selectDropDownbyVisibleString(DCNDocumentReferenceType, args[0], "RefundRequest", "Document TYpe");
	}
	
	public boolean enterDocRefNumber(String[] args)
	{
		return utils.enterTextinAnelemnt(DCNDocumentReferenceNumber, args[0], "RefundRequest", "Document Number");
	}
	
	@FindBy (xpath="//button[@title='Complete this assignment']//div[text()='Submit']")	
	private WebElement clicksubmit;
	
	public boolean clickOnSubmit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(clicksubmit, "ResolveClaimAdjustmentRequest", "Submit");
	}

	@FindBy (xpath="//input[@id='CorrectedClaimNumber']")	
	private WebElement CorrectedClaimNumber;
	
	public boolean validateCorrectedClaimNumber(String[] notes)
	{
			return utils.enterTextinAnelemnt(this.CorrectedClaimNumber, notes[0], "RefundRequest", "Corrected ClaimNumber");
	}
	
	@FindBy (xpath="//input[@id='ReplacementClaimNumber']")	
	private WebElement ReplacementClaimNumber;
	
	public boolean validateReplacementClaimNumber(String[] notes)
	{
			return utils.enterTextinAnelemnt(this.ReplacementClaimNumber, notes[0], "RefundRequest", "Replacement ClaimNumber");
	}
	
	@FindBy (xpath="//input[@id='AdjustClaimNumber']")	
	private WebElement AdjustClaimNumber;
	
	@FindBy (xpath="//input[@id='ClaimNumberAboveDuplicateTo']")	
	private WebElement ClaimNumberAboveDuplicateTo;
	
	public boolean validateTheDuplicatePaymentsDetails(String args[]){
		try{
			boolean returnvar=true;         
			for(String iterator : args)
			{
				String keyvaluepair = iterator;
				if(!returnvar)
				{
					err.logcommonMethodError("validateTheDuplicatePaymentsDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				String key = iterator.substring(0, iterator.indexOf(":"));
				String value = iterator.substring(iterator.indexOf(":")+1);
				System.out.println("key " + key + "value  " + value);
				if(key.contains("Adjust")){
					try{
						utils.enterTextinAnelemnt(AdjustClaimNumber, value, "RefundRequest", "Adjust ClaimNumber");
						returnvar = true;
					}catch(Exception e){
						err.logError("RefundRequest", "Exception occured while entering value to field 'Adjust ClaimNumber'");
						returnvar = false;
					}
					continue;}
				else if(key.contains("Duplicate")){
					try{
						utils.enterTextinAnelemnt(ClaimNumberAboveDuplicateTo, value, "RefundRequest", "ClaimNumber Above Duplicate To");
						returnvar = true;	
					}catch(Exception e){
						err.logError("RefundRequest", "Exception occured while entering value to field 'ClaimNumber Above Duplicate To'");
						returnvar = false;
					}
				}
				if(returnvar)
				{
					System.out.println("No issues in Key value pair");
					return true;
				}else{
					System.out.println("Issues in Entering value - AdjustClaimNumber#ClaimNumberAboveDuplicateTo ");
					return false;
				}

			}
	
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "Unable to enter value to the field Representative Address::"+e);
			return false;
		}
		return false;
	}
	
	
	//Sprint 6.3
	
	@FindBy (id="MedicalRecordsNo")	
	private WebElement radioBtnMedicalRecordsNo;

	@FindBy (id="MedicalRecordsYes")	
	private WebElement radioBtnMedicalRecordsYes;
	
	
	/**
	 * This method selects if the member has medical records
	 * @param args
	 * @return
	 */
	public boolean selectMedicalRecordsYesOrnO(String args[]){

		if(args[0].equalsIgnoreCase("Yes"))
			return	utils.clickAnelemnt(radioBtnMedicalRecordsYes,"RefundRequest", "medicalRecords Yes");
		else
			return	utils.clickAnelemnt(radioBtnMedicalRecordsNo,"RefundRequest", "medicalRecords No");
	}

	@FindBy(id="PaymentType")
	private WebElement paymentType;
	
	/**
	 * This method selects the payment type dropdown
	 * @param args
	 * @return
	 */
	public boolean selectPaymentTypeFromDropdown(String[] args){
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(paymentType, args[0], "RefundRequest", "Payment Type");   
	}


	
}
