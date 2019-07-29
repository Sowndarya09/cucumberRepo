package automationLib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class PerformNextAction_Adjustment {
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	ErrorLogger err = new ErrorLogger();

	public PerformNextAction_Adjustment()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		utils.gotoLastIframe(iframes);
	}

	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;

	@FindBy(xpath="//span[text()='Request Claim Adjustment']")
	WebElement RequestClaimAdjustment;

	@FindBy(id="PrimaryReasonforBilling")
	WebElement ResonForContact;

	@FindBy(id="IsAdjustmentBulkAction")
	WebElement BulkActionsCheckBox;

	@FindBy(id="SelectNextAction")
	WebElement SelectNextAction;

	@FindBy(id="ReasonForAdjustments")
	WebElement ReasonForAdjustments;

	@FindBy(id="pyNote")
	WebElement Notes;

	@FindBy(xpath="//button[@data-test-id='20190402125503045832759']")
	WebElement ApplyButton;

	@FindBy(xpath="//button[@data-test-id='2019040517203608417519']")
	WebElement SubmitButton;

	public boolean selectUsingBulkOptionAndSubmit() throws InterruptedException {
		if(utils.clickAnelemnt(RequestClaimAdjustment, "PerformNextAction", "RequestAdjustment"))
			if(utils.selectDropDownbyIndex(ResonForContact, 1, "PerformNextAction", "ResonForContact"))
				if(utils.clickAnelemnt(BulkActionsCheckBox,"PerformNextAction","BulkActionsCheckBox"))
					if(utils.selectDropDownbyIndex(SelectNextAction, 1, "PerformNextAction", "SelectNextAction"))
						if(utils.selectDropDownbyIndex(ReasonForAdjustments, 1, "PerformNextAction", "ReasonForAdjustments"))
							if(utils.enterTextinAnelemnt(Notes, "Testing", "PerformNextAction", "Notes"))
								if(utils.clickAnelemnt(ApplyButton,"PerformNextAction","ApplyButton"))
									return clickSubmit();
		return false;						
	}

	public boolean clickSubmit() {
		utils.scrolltomiddle();
		return utils.clickAnelemnt(SubmitButton, "PerformNextAction", "SubmitButton");
	}

	@FindBy(xpath="//table[@pl_prop='.ReviewedClaims']")
	WebElement ManageClaimReviewTable;

	@FindBy(xpath="//*[@node_name='NextActionsListReview']//table[@id='gridLayoutTable']")
	WebElement NextActionTable;

	@FindBy(xpath="//h3[text()='Claim Details']")
	WebElement labelValidationMsg;

	public boolean clickClaimNumberAndValidateInManageReviewSection(String[] args) throws InterruptedException {
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.ManageClaimReviewTable,args);
		//List<WebElement> rowNo = row.findElements(By.xpath(".//a[@data-test-id='2016052408260302164570']"));
		//if(utils.clickAnelemnt(rowNo.get(2), "PerformNextAction", "Manage Claim Review section Claims link")) {
		WebElement clmno=row.findElement(By.xpath("//table[@id='gridLayoutTable']//a[@data-test-id='2016052408260302164570']"));
		if(utils.clickAnelemnt(clmno, "PerformNextAction", "Manage Claim Review section Claims link")) {
			utils.waitforpageload();	
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

	public boolean clickClaimNumberAndValidateInNextActionSection(String[] args) throws InterruptedException {
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.NextActionTable,args);
		//List<WebElement> rowNo = row.findElements(By.xpath(".//a[@data-test-id='2016052408260302164570']"));
		//if(utils.clickAnelemnt(rowNo.get(0), "PerformNextAction", "Manage Claim Review section Claims link")) {
		WebElement clmno=row.findElement(By.xpath("//table[@pl_prop='.NextActionsList']//a[@data-test-id='20160127123013028739253']"));
		if(utils.clickAnelemnt(clmno, "PerformNextAction", "Next action section Claims link")) {
			utils.waitforpageload();
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


	@FindBy(xpath="//*[@data-test-id='20190301153514070548966']")
	WebElement ClaimDetailsSection_ClaimNumber;

	@FindBy(xpath="//*[@data-test-id='201903031119070492191000']")
	WebElement ClaimDetailsSection_ActionCode;

	public boolean vaildateClaimDetails(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//*[text()='Check Amount']/..//*[@data-test-id='2019030805185409136205']")
	WebElement ClaimDetailsSection_CheckAmount;

	@FindBy(xpath="//*[text()='Check Issue Date']/..//*[@data-test-id='2019030805185409136205']")
	WebElement ClaimDetailsSection_CheckIssueDate;


	public boolean vaildatePaymentDetails(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("check amount"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_CheckAmount,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("issue date"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_CheckIssueDate,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//*[@data-test-id='20190308075518018862456']")
	WebElement ClaimDetailsSection_FirstDateOfService;

	@FindBy(xpath="//*[@data-test-id='20190308075518018963821']")
	WebElement ClaimDetailsSection_TotalChargedAmount;


	public boolean validateClaimCalculations(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("first date of service"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_FirstDateOfService,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("total charged amount"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_TotalChargedAmount,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validatePatientDetails(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateBillingProviderDetails(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateRenderingProviderDetails(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateProcessingDetails(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateReferingProviderDetails(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateITSSpecificDetails(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateOtherInsuance(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	public boolean validateMedicare(String[] args) {
		boolean returnvar = true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ManageClaims", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{                    
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);                    
				continue;

			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar = utils.validateLabel(ClaimDetailsSection_ClaimNumber,value);   
				continue;
			}else 
				err.logcommonMethodError("Manage Claims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar) {
			return true;
		}else {
			int tot_i=args.length;
			err.logcommonMethodError("Manage Claims", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//span[text()='As part of the Associate Empowerment']")
	WebElement OONnotes;

	@FindBy(xpath="//span[text()='OON Referral Exception to Pay at INN Level']")
	WebElement OONadjust;

	@FindBy(xpath="//span[text()='Send for adjustment']")
	WebElement OONcontact;

	public boolean validatePreFilledFieldsForOONFlow(){
		String note2="As part of the Associate Empowerment";
		String adjustReason2="OON Referral Exception to Pay at INN Level";
		String ReasonForContact2="Send for adjustment";
		if(OONnotes.getText().equalsIgnoreCase(note2))
			if(OONadjust.getText().equalsIgnoreCase(adjustReason2))
				if(OONcontact.getText().equalsIgnoreCase(ReasonForContact2))
					return true;
		return false;

	}

	@FindBy(xpath="//span[text()='Request Claim Adjustment']")
	WebElement RequestAdjustment;

	public boolean expandRequestAdjustment(){
		utils.waitforpageload();
		return utils.clickAnelemnt(RequestAdjustment, "PerformNextAction_Adjustment", "RequestAdjustment");
	}





}
