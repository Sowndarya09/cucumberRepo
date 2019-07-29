package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import extentmanager.ExtentManager;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ViewClaimDetails extends Driver {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement1;
	
	@FindBy(xpath="//iframe")
	List<WebElement> iframes;

	public ViewClaimDetails()
	{
		//try
		//{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			utils.gotoLastIframe(iframes);
			/*Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}*/
	}


	//Objects

	//Links

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBB']//font[contains(text(),'Claim Details')]")
	WebElement lnkClaimDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBB']//font[contains(text(),'Claim Calculations')]")
	WebElement lnkClaimCalculations;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBB']//font[contains(text(),'Payment Details')]")
	WebElement lnkPaymentDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBB']//font[contains(text(),'Accumulator Details')]")
	WebElement lnkAccumulatorDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBB']//font[contains(text(),'Patient Details')]")
	WebElement lnkPatientDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBBB']//font[contains(text(),'Billing Provider Details')]")
	WebElement lnkBillingProviderDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBBBB']//font[contains(text(),'Rendering Provider Details')]")
	WebElement lnkRenderingProviderDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBBBBB']//font[contains(text(),'Other Insurance')]")
	WebElement lnkOtherInsurance;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBBBBBB']//font[contains(text(),'Medicare')]")
	WebElement lnkMedicare;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBBBBBBB']//font[contains(text(),'Processing Details')]")
	WebElement lnkProcessingDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBBBBBBBB']//font[contains(text(),'Pricing Details')]")
	WebElement lnkPricingDetails;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBBBBBBBBB']//font[contains(text(),'ITS Specific Details')]")
	WebElement lnkITSSpecificDetails;


	//View Claim Details

	@FindBy(xpath="//div[@node_name='ViewClaimDetailsMultiple']//label[@for='ClaimID']/parent::div//span")
	WebElement labelViewClaimNumber;

	@FindBy(xpath="//div[@node_name='ViewClaimDetailsMultiple']//label[@for='ServiceDates']/parent::div//span")
	WebElement labelViewClaimDatesOfService;

	@FindBy(xpath="//div[@node_name='ViewClaimDetailsMultiple']//label[@for='TotalChargedAmount']/parent::div//span//span")
	WebElement labelViewClaimTotalChargedAmount;

	@FindBy(xpath="//div[@node_name='ViewClaimDetailsMultiple']//label[@for='OrganizationName']/parent::div//span")
	WebElement labelViewClaimRenderingProviderName;

	@FindBy(xpath="//div[@node_name='ViewClaimDetailsMultiple']//label[@for='FullName']/parent::div//span")
	WebElement labelViewClaimPatientName;

	@FindBy(xpath="//div[@node_name='ViewClaimDetailsMultiple']//label[@for='DateOfBirth']/parent::div//span")
	WebElement labelViewClaimPatientDOB;

	@FindBy(xpath="//div[@node_name='ViewClaimDetailsMultiple']//label[@for='GroupNumber']/parent::div//span")
	WebElement labelViewClaimEmployerGroupNumber;

	@FindBy(xpath="//div[@node_name='ViewClaimDetailsMultiple']//label[@for='ProductGroupNumber']/parent::div//span")
	WebElement labelViewClaimProductGroupNumber;




	//Claim Details

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ClaimID']/parent::div//span")
	WebElement labelClaimNumber;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='OriginalClaimNumber']/parent::div//span")
	WebElement labelOriginalClaimNumber;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ClaimTypeCode']/parent::div//span//span")
	WebElement labelClaimType;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='MemberCode']/parent::div//span")
	WebElement labelMemberID;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='AuthorizationCode']/parent::div//span")
	WebElement labelAuthorizationNumber;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ContractCode']/parent::div//span")
	WebElement labelContractCode;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ITS']/parent::div//span")
	WebElement labelITS;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='SCCF']/parent::div//span")
	WebElement labelSCCF;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='AdjustedSCCF']/parent::div//span")
	WebElement labelAdjustedSCCF;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='NCNClaim']/parent::div//span")
	WebElement labelNCNClaim;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='PayeeCode']/parent::div//span")
	WebElement labelPayee;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ClaimImageNo']/parent::div//span//a")
	WebElement labelClaimImageNo;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='PaidAs']/parent::div//span")
	WebElement labelPaidAs;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='DiagnosisCode']/parent::div//span//a")
	WebElement labelDiagnosis;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ReceivedDate']/parent::div//span")
	WebElement labelReceivedDate;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ProcessedDate']/parent::div//span")
	WebElement labelProcessedDate;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ClaimStatus']/parent::div//span")
	WebElement labelStatus;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ActionCode']/parent::div//span")
	WebElement labelActionCode;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='PMG']/parent::div//span")
	WebElement labelPMG;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='IPA']/parent::div//span")
	WebElement labelIPA;

	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='ERISA']/parent::div//span")
	WebElement labelERISA;


	//Claim Calculations

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='ServiceFromDate']/parent::div//span")
	WebElement labelFirstDateOfService;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='ServiceToDate']/parent::div//span")
	WebElement labelLastDateOfService;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='TotalChargedAmount']/parent::div//span//span")
	WebElement labelTotalChargedAmount;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='AllowedAmount']/parent::div//span//span")
	WebElement labelAllowedAmount;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='ProviderWriteOffAmount']/parent::div//span//span")
	WebElement labelProviderWriteOffAmount;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='MemberLiabilityAmount']/parent::div//span//span")
	WebElement labelMemberLiablityAmount;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='PaidAmount']/parent::div//span//span")
	WebElement labelPaidAmount;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='HRAStartingBalance']/parent::div//span//span")
	WebElement labelHRAStartingBalance;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='HRAPaidAmount']/parent::div//span//span")
	WebElement labelHRAPaidAmount;

	@FindBy(xpath="//div[@node_name='ClaimCalculations']//label[@for='HRAEndingBalance']/parent::div//span//span")
	WebElement labelHRAEndingBalance;


	//Payment Details

	@FindBy(xpath="//div[@node_name='PaymentDetails']//label[@for='CheckAmount']/parent::div//span")
	WebElement labelCheckAmount;

	@FindBy(xpath="//div[@node_name='PaymentDetails']//label[@for='CheckIssueDate']/parent::div//span")
	WebElement labelCheckIssueDate;

	@FindBy(xpath="//div[@node_name='PaymentDetails']//label[@for='CheckNumber']/parent::div//span")
	WebElement labelCheckNumber;

	@FindBy(xpath="//div[@node_name='PaymentDetails']//label[@for='BankAccountNumber']/parent::div//span")
	WebElement labelBankAccountNumber;

	@FindBy(xpath="//div[@node_name='PaymentDetails']//label[@for='Payee']/parent::div//span")
	WebElement labelPaymentDetailsPayee;

	@FindBy(xpath="//div[@node_name='PaymentDetails']//label[@for='CheckAddress']/parent::div//span")
	WebElement labelCheckAddress;

	@FindBy(xpath="//div[@node_name='PaymentDetails']//label[@for='CheckStatus']/parent::div//span")
	WebElement labelCheckStatus;

	@FindBy(xpath="//div[@node_name='PaymentDetails']//label[@for='CheckStatusDate']/parent::div//span")
	WebElement labelCheckStatusDate;

	//Patient Details

	@FindBy(xpath="//div[@node_name='PatientDetails']//label[@for='FullName']/parent::div//span")
	WebElement labelPatientName;

	@FindBy(xpath="//div[@node_name='PatientDetails']//label[@for='DateOfBirth']/parent::div//span")
	WebElement labelPatientDateOfBirth;

	@FindBy(xpath="//div[@node_name='PatientDetails']//label[@for='PatientAccountNumber']/parent::div//span")
	WebElement labelPatientAccountNumber;

	@FindBy(xpath="//div[@node_name='PatientDetails']//label[@for='Relationship']/parent::div//span")
	WebElement labelPatientRelationship;

	//Billing Provider Details

	@FindBy(xpath="//div[@node_name='BillingProviderDetails']//label[@for='ProviderName']/parent::div//span")
	WebElement labelBillingProviderDetailslName;

	@FindBy(xpath="//div[@node_name='BillingProviderDetails']//label[@for='TaxID']/parent::div//span")
	WebElement labelBillingProviderDetailsTaxID;

	@FindBy(xpath="//div[@node_name='BillingProviderDetails']//label[@for='NPI']/parent::div//span")
	WebElement labelBillingProviderDetailsNPI;

	@FindBy(xpath="//div[@node_name='BillingProviderDetails']//label[@for='Address']/parent::div//span")
	WebElement labelBillingProviderDetailsAddress;

	@FindBy(xpath="//div[@node_name='BillingProviderDetails']//label[@for='PhoneNumber']/parent::div//span")
	WebElement labelBillingProviderDetailsPhoneNumber;

	//Rendering Provider Details

	@FindBy(xpath="//div[@node_name='RenderingProviderDetails']//label[@for='OrganizationName']/parent::div//span")
	WebElement labelRenderingProviderDetailsName;

	@FindBy(xpath="//div[@node_name='RenderingProviderDetails']//label[@for='TaxonomyCode']/parent::div//span")
	WebElement labelRenderingProviderDetailsTaxID;

	@FindBy(xpath="//div[@node_name='RenderingProviderDetails']//label[@for='NationalProviderIdentfier']/parent::div//span")
	WebElement labelRenderingProviderDetailsNPI;

	@FindBy(xpath="//div[@node_name='RenderingProviderDetails']//label[@for='AddressLine1']/parent::div//span")
	WebElement labelRenderingProviderDetailsAddress;

	@FindBy(xpath="//div[@node_name='RenderingProviderDetails']//label[@for='PhoneNumber']/parent::div//span")
	WebElement labelRenderingProviderDetailsPhoneNumber;

	@FindBy(xpath="//div[@node_name='RenderingProviderDetails']//label[@for='PlanNetworkNumber']/parent::div//span")
	WebElement labelRenderingProviderDetailsPlanNetworkStatus;

	@FindBy(xpath="//div[@node_name='RenderingProviderDetails']//label[@for='Type']/parent::div//span")
	WebElement labelRenderingProviderDetailsType;

	@FindBy(xpath="//div[@node_name='RenderingProviderDetails']//label[@for='PrimarySpeciality']/parent::div//span")
	WebElement labelRenderingProviderDetailsSpeciality;

	@FindBy(xpath="//span[@data-test-id='2017082116310803999154']")
	WebElement valueRenderingProviderLegacyID;

	@FindBy(xpath="//label[@for='ProviderSpecialtyContractID']//following-sibling::div//following-sibling::span[@data-test-id='20170821163101065892188']")
	WebElement valueRenderingProviderSpecialityContractID;

	@FindBy(xpath="//label[@data-test-id='2017082116310803999154-Label'][@for='ProviderLegacyID']")
	WebElement labelRenderingProviderLegacyID;

	@FindBy(xpath="//label[@data-test-id='20170821163101065892188-Label'][@for='ProviderSpecialtyContractID']")
	WebElement labelRenderingProviderSpecialityContractID;

	@FindBy(xpath="//label[@data-test-id='2017082116310803999154-Label']")
	WebElement hoverRenderingProviderLegacyID;

	@FindBy(xpath="//label[@data-test-id='20170821163101065892188-Label']")
	WebElement hoverRenderingProviderSpecialityContractID;



	//Other Insurance

	@FindBy(xpath="//div[@node_name='InsuranceDetails']//label[@for='TotalOtherInsuranceAllowedAmount']/parent::div//span")
	WebElement labelInsuranceTotalOtherInsuranceAllowedAmount;

	@FindBy(xpath="//div[@node_name='InsuranceDetails']//label[@for='TotalOtherInsurancePaidAmount']/parent::div//span")
	WebElement labelInsuranceTotalOtherInsurancePaidAmount;

	@FindBy(xpath="//div[@node_name='InsuranceDetails']//label[@for='COBIndicator']/parent::div//span")
	WebElement labelInsuranceCOBIndicator;

	@FindBy(xpath="//div[@node_name='InsuranceDetails']//label[@for='WorkersCompensationIndicator']/parent::div//span")
	WebElement labelInsuranceWorkersCompensationIndicator;

	//Medicare

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='MedicareAssignmentCode']/parent::div//span")
	WebElement labelMedicareAssignment;

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='MedicareCoverageIndicator']/parent::div//span")
	WebElement labelMedicareCrossover;

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='MedicalRecordNumber']/parent::div//span")
	WebElement labelMedicareHICNumber;

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='TotalMedicareAllowedAmount']/parent::div//span//span")
	WebElement labelTotalMedicareAllowedAmount;

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='TotalMedicareCoinsuranceAmount']/parent::div//span//span")
	WebElement labelTotalMedicareCoinsuranceAmount;

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='TotalMedicareDeductibleAmount']/parent::div//span//span")
	WebElement labelTotalMedicareDeductibleAmount;

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='TotalMedicarePaidAmount']/parent::div//span//span")
	WebElement labelTotalMedicarePaidAmount;

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='TotalMedicareNonCoveredAmount']/parent::div//span//span")
	WebElement labelTotalMedicareNonCoveredAmount;

	@FindBy(xpath="//div[@node_name='MedicareDetails']//label[@for='TotalMedicareProviderWriteOffAmount']/parent::div//span//span")
	WebElement labelTotalMedicareProviderWriteOffAmount;


	//ITS Specific Details

	@FindBy(xpath="//table[@pl_prop='.ITSSpecificDetails']")
	WebElement tblITSSpecificDetails;

	//Accumulator Details

	@FindBy(xpath="//table[@pl_prop='.ClaimAccumDetails']")
	WebElement tblAccumulatorDetails;

	//Processing Details Link

	@FindBy(xpath="//div[@node_name='ProcessingDetails']//a[contains(text(),'Claim Text')]")
	WebElement lnkProcessingDetailsClaimText;

	@FindBy(xpath="//table[@pl_prop='.ClaimEditList']")
	WebElement tblClaimEditList;

	public boolean clickClaimDetailsLink()
	{
		return utils.clickAnelemnt(lnkClaimDetails, "ViewClaimDetails", "Claim Details Link");
	}

	public boolean clickClaimCalculationsLink()
	{
		return utils.clickAnelemnt(lnkClaimCalculations, "ViewClaimDetails", "Claim Calculations Link");
	}

	public boolean clickPaymentDetailsLink()
	{
		return utils.clickAnelemnt(lnkPaymentDetails, "ViewClaimDetails", "Payment Details Link");
	}

	public boolean clickAccumulatorDetailsLink()
	{
		return utils.clickAnelemnt(lnkAccumulatorDetails, "ViewClaimDetails", "Accumulator Details Link");
	}

	public boolean clickPatientDetailsLink()
	{
		return utils.clickAnelemnt(lnkPatientDetails, "ViewClaimDetails", "Patient Details Link");
	}

	public boolean clickBillingProviderDetailsLink()
	{
		return utils.clickAnelemnt(lnkBillingProviderDetails, "ViewClaimDetails", "Billing Provider Details Link");
	}

	public boolean clickRenderingProviderDetailsLink()
	{
		return utils.clickAnelemnt(lnkRenderingProviderDetails, "ViewClaimDetails", "Rendering Provider Details Link");
	}

	public boolean clickOtherInsuranceLink()
	{
		return utils.clickAnelemnt(lnkOtherInsurance, "ViewClaimDetails", "Other Insurance");
	}

	public boolean clickMedicareLink()
	{
		return utils.clickAnelemnt(lnkMedicare, "ViewClaimDetails", "Medicare Link");
	}

	public boolean clickProcessingDetailsLink()
	{
		return utils.clickAnelemnt(lnkProcessingDetails, "ViewClaimDetails", "Processing Details Link");
	}

	public boolean clickProcessingDetailsLinks()
	{
		WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@param_name='EXPANDEDSubSectionClaimSummaryDetailsMutiLevelBBBBBBBBBBB']//font[contains(text(),'Processing Details')]"));
		Actions actions = new Actions(Driver.pgDriver);
		actions.moveToElement(element).click().build().perform();
		return true;
	}
	public boolean clickPricingDetailsLink()
	{
		return utils.clickAnelemnt(lnkPricingDetails, "ViewClaimDetails", "Pricing Details Link");
	}

	public boolean clcikITSSpecificDetailsLink()
	{
		return utils.clickAnelemnt(lnkITSSpecificDetails, "ViewClaimDetails", "ITS Specific Details Link");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyClaimDetails
	 * #Description: This functionality validated the information present in  the Claim Details section
	 * #Argument: claimdetails
	 * #Type: Table
	 * keys: Claim Number#Claim Type#Member ID#Contract Code#ITS#Payee#Claim Image Number#Paid as#Diagnosis#Received Date#Processed Date#Status#Action Code#ERISA
	 */

	public boolean verifyClaimDetailsInfo(String[] claimdetails)
	{
		System.out.println("Entered into the method");
		utils.waitforpageload();
		this.clickClaimDetailsLink();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : claimdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + " " + "value  " + value);

			if(utils.isvalueMatch_contain(key,"Claim Number")){
				returnvar = utils.validateLabel(this.labelClaimNumber,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Original Claim Number")){
				returnvar = utils.validateLabel(this.labelOriginalClaimNumber,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Claim Type")){	
				returnvar = utils.validateLabel(this.labelClaimType,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Member ID")){
				returnvar = utils.validateLabel(this.labelMemberID,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Authorization Number")){
				returnvar = utils.validateLabel(this.labelAuthorizationNumber,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Contract Code")){
				returnvar = utils.validateLabel(this.labelContractCode,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"ITS")){
				returnvar = utils.validateLabel(this.labelITS,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"SCCF")){
				returnvar = utils.validateLabel(this.labelSCCF,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Adjusted SCCF")){
				returnvar = utils.validateLabel(this.labelAdjustedSCCF,value);
				continue;
			}	
			else if(utils.isvalueMatch_contain(key,"NCN Claim")){
				returnvar = utils.validateLabel(this.labelNCNClaim,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Payee")){	
				returnvar = utils.validateLabel(this.labelPayee,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Claim Image Number")){	
				returnvar = utils.validateLabel(this.labelClaimImageNo,value);
				continue;
			}	
			else if(utils.isvalueMatch_contain(key,"Paid as")){	
				returnvar = utils.validateLabel(this.labelPaidAs,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Diagnosis")){	
				returnvar = utils.validateLabel(this.labelDiagnosis,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Received Date")){	
				returnvar = utils.validateLabel(this.labelReceivedDate,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Processed Date")){	
				returnvar = utils.validateLabel(this.labelProcessedDate,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Status")){
				returnvar = utils.validateLabel(this.labelStatus,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Action Code")){
				returnvar = utils.validateLabel(this.labelActionCode,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"PMG")){
				returnvar = utils.validateLabel(this.labelPMG,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"IPA")){
				returnvar = utils.validateLabel(this.labelIPA,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"ERISA")){
				returnvar = utils.validateLabel(this.labelERISA,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickClaimDetailsLink();
		if(returnvar)
		{
			System.out.println("Claim Details verified successfully");
			return true;	
		}
		else
		{
			int tot_i=claimdetails.length;
			err.logcommonMethodError("View Claim Details", "the value "+claimdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyClaimCalulationsInfo
	 * #Description: This functionality validates the information in the Payment Details section.
	 * #Argument: claimcalculations
	 * Type: Table
	 * keys: First Date Of Sevice#Last Date Of Service#Total Charged Amount#Allowed Amount#Provider Write Off Amount#Member Liablity Amount#Paid Amount#HRA Starting Balance#HRA Paid Amount#HRA Ending Balance
	 */
	public boolean verifyClaimCalulationsInfo(String[] claimcalculations)
	{
		System.out.println("Entered into the method");
		this.clickClaimCalculationsLink();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : claimcalculations)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimCalulations", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + " " + "value  " + value);

			if(utils.isvalueMatch_contain(key,"First Date Of Service")){
				returnvar = utils.validateLabel(this.labelFirstDateOfService,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Last Date Of Service")){
				returnvar = utils.validateLabel(this.labelLastDateOfService,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Total Charged Amount")){
				returnvar = utils.validateLabel(this.labelTotalChargedAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Allowed Amount")){
				returnvar = utils.validateLabel(this.labelAllowedAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Write Off Amount")){
				returnvar = utils.validateLabel(this.labelProviderWriteOffAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Member Liablity Amount")){
				returnvar = utils.validateLabel(this.labelMemberLiablityAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Paid Amount")){
				returnvar = utils.validateLabel(this.labelPaidAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"HRA Starting Balance")){
				returnvar = utils.validateLabel(this.labelHRAStartingBalance,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"HRA Paid Amount")){
				returnvar = utils.validateLabel(this.labelHRAPaidAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"HRA Ending Balance")){
				returnvar = utils.validateLabel(this.labelHRAEndingBalance,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickClaimCalculationsLink();
		if(returnvar)
		{
			System.out.println("Claim Calculations verified successfully");
			return true;	
		}
		else
		{
			int tot_i=claimcalculations.length;
			err.logcommonMethodError("View Claim Details", "the value "+claimcalculations[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyPaymentDetailsInfo
	 * #Description: This functionality validates the information in the Payment Details section.
	 * #Argument: paymentdetails
	 * Type: Table
	 * keys: Check Amount#Check Issue Date#Check  Number#Account Number#Payee#Check Address#Check Status#Check Status Date
	 */
	public boolean verifyPaymentDetailsInfo(String[] paymentdetails)
	{
		System.out.println("Entered into the method");
		this.clickPaymentDetailsLink();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : paymentdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimCalulations", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + " " + "value  " + value);

			if(utils.isvalueMatch_contain(key,"Check Amount")){
				returnvar = utils.validateLabel(this.labelCheckAmount,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Check Issue Date")){	
				returnvar = utils.validateLabel(this.labelCheckIssueDate,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Check Number")){	
				returnvar = utils.validateLabel(this.labelCheckNumber,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Account Number")){
				returnvar = utils.validateLabel(this.labelBankAccountNumber,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Payee")){
				returnvar = utils.validateLabel(this.labelPaymentDetailsPayee,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Check Address")){
				returnvar = utils.validateLabel(this.labelCheckAddress,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Check Status")){
				returnvar = utils.validateLabel(this.labelCheckStatus,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Check Status Date")){
				returnvar = utils.validateLabel(this.labelCheckStatusDate,value);

				continue;
			}
			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickPaymentDetailsLink();
		if(returnvar)
		{
			System.out.println("Payment Details verified successfully");
			return true;	
		}
		else
		{
			int tot_i=paymentdetails.length;
			err.logcommonMethodError("View Claim Details", "the value "+paymentdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyPatientDetailsInfo
	 * #Description: This functionality validates the information in the Patient Details section.
	 * #Argument: patientdetails
	 * Type: Table
	 * keys: Patient Name#Patinet DOB#Patient Account#Relationship
	 */
	public boolean verifyPatientDetailsInfo(String[] patientdetails)
	{
		System.out.println("Entered into the method");
		this.clickPatientDetailsLink();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : patientdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimCalulations", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + " " + "value  " + value);

			if(utils.isvalueMatch_contain(key,"Patient Name")){
				returnvar = utils.validateLabel(this.labelPatientName,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Patient DOB")){
				returnvar = utils.validateLabel(this.labelPatientDateOfBirth,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Patient account")){
				returnvar = utils.validateLabel(this.labelPatientAccountNumber,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Relationship")){
				returnvar = utils.validateLabel(this.labelPatientRelationship,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickPatientDetailsLink();
		if(returnvar)
		{
			System.out.println("Patient Details Verified Successfully");
			return true;	
		}
		else
		{
			int tot_i=patientdetails.length;
			err.logcommonMethodError("ViewClaimDetails", "the value "+patientdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyBillingProviderDetailsInfo
	 * #Description: This functionality validates the information in the Billing Provider Details section.
	 * #Argument: billingproviderdetails
	 * Type: Table
	 * keys: Name#Tax ID#NPI#Address#Phone Number
	 */
	public boolean verifyBillingProviderDetailsInfo(String[] billingproviderdetails)
	{
		System.out.println("Entered into the method");
		this.clickBillingProviderDetailsLink();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : billingproviderdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimCalulations", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			if(utils.isvalueMatch_contain(key,"Name")){
				returnvar = utils.validateLabel(this.labelBillingProviderDetailslName,value);
				continue;}
			if(utils.isvalueMatch_contain(key,"Tax ID")){
				returnvar = utils.validateLabel(this.labelBillingProviderDetailsTaxID,value);
				continue;}
			if(utils.isvalueMatch_contain(key,"NPI")){
				returnvar = utils.validateLabel(this.labelBillingProviderDetailsNPI,value);
				continue;
			}
			if(utils.isvalueMatch_contain(key,"Address")){
				returnvar = utils.validateLabel(this.labelBillingProviderDetailsAddress,value);
				continue;
			}
			if(utils.isvalueMatch_contain(key,"Phone Number")){
				returnvar = utils.validateLabel(this.labelBillingProviderDetailsPhoneNumber,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickBillingProviderDetailsLink();
		if(returnvar)
		{
			System.out.println("Billing Provider Details Verified Successfully");
			return true;	
		}
		else
		{
			int tot_i=billingproviderdetails.length;
			err.logcommonMethodError("View Claim Details", "the value "+billingproviderdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyRenderingProviderDetailsInfo
	 * #Description: This functionality validates the information in the Rendering Provider Details section.
	 * #Argument: renderingproviderdetails
	 * Type: Table
	 * keys: Name#Tax ID#NPI#Address on Claim#Phone Number#Plan Network Status#Type#Speciality
	 */
	public boolean verifyRenderingProviderDetailsInfo(String[] renderingproviderdetails)
	{
		System.out.println("Entered into the method");
		this.clickRenderingProviderDetailsLink();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : renderingproviderdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimCalulations", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			if(utils.isvalueMatch_contain(key,"Name")){
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsName,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Tax ID")){
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsTaxID,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"NPI")){
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsNPI,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Address on Claim")){	
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsAddress,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Phone Number")){	
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsPhoneNumber,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Plan Network Status")){		
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsPlanNetworkStatus,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Type")){		
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsType,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Speciality")){		
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsSpeciality,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickRenderingProviderDetailsLink();
		if(returnvar)
		{
			System.out.println("Rendering Provider Details Verified Successfully");
			return true;	
		}
		else
		{
			int tot_i=renderingproviderdetails.length;
			err.logcommonMethodError("View Claim Details", "the value "+renderingproviderdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyOtherInsuranceDetailsInfo
	 * #Description: This functionality validates the information in the Other Insurance section.
	 * #Argument: otherinsurancedetails
	 * Type: Table
	 * keys: Total Other Insurance Allowed Amount#Total Other Insurance Paid Amount#COB Method Applied#Workers Compensation Indicator
	 */
	public boolean verifyOtherInsuranceDetailsInfo(String[] otherinsurancedetails)
	{
		System.out.println("Entered into the method");
		this.clickOtherInsuranceLink();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : otherinsurancedetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimCalulations", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			if(utils.isvalueMatch_contain(key,"Total Other Insurance Allowed Amount")){		
				returnvar = utils.validateLabel(this.labelInsuranceTotalOtherInsuranceAllowedAmount,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Total Other Insurance Paid Amount")){	
				returnvar = utils.validateLabel(this.labelInsuranceTotalOtherInsurancePaidAmount,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"COB Method Applied")){	
				returnvar = utils.validateLabel(this.labelInsuranceCOBIndicator,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Workers Compensation Indicator")){	
				returnvar = utils.validateLabel(this.labelInsuranceWorkersCompensationIndicator,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickOtherInsuranceLink();
		if(returnvar)
		{
			System.out.println("Other Insurance Details Verified Successfully");
			return true;	
		}
		else
		{
			int tot_i=otherinsurancedetails.length;
			err.logcommonMethodError("View Claim Details", "the value "+otherinsurancedetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyMedicareDetailsInfo
	 * #Description: This functionality validates the information in the Medicare section.
	 * #Argument: medicaredetails
	 * Type: Table
	 * keys: Medicare Assignment#Medicare Crossover#Medicare HIC Number#Total Medicare Allowed Amount#Total Medicare Coinsurance Amount#Total Medicare Deductible Amount#Total Medicare Paid Amount#Total Medicare Non Covered Amount#Total Medicare Provider Write Off Amount
	 */
	public boolean verifyMedicareDetailsInfo(String[] medicaredetails)
	{
		System.out.println("Entered into the method");
		this.clickMedicareLink();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : medicaredetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimCalulations", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			if(utils.isvalueMatch_contain(key,"Medicare Assignment")){
				returnvar = utils.validateLabel(this.labelMedicareAssignment,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Medicare Crossover")){
				returnvar = utils.validateLabel(this.labelMedicareCrossover,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Medicare HIC Number")){
				returnvar = utils.validateLabel(this.labelMedicareHICNumber,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Total Medicare Allowed Amount")){
				returnvar = utils.validateLabel(this.labelTotalMedicareAllowedAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Total Medicare Coinsurance Amount")){
				returnvar = utils.validateLabel(this.labelTotalMedicareCoinsuranceAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Total Medicare Deductible Amount")){
				returnvar = utils.validateLabel(this.labelTotalMedicareDeductibleAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Total Medicare Paid Amount")){
				returnvar = utils.validateLabel(this.labelTotalMedicarePaidAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Total Medicare Non Covered Amount")){
				returnvar = utils.validateLabel(this.labelTotalMedicareNonCoveredAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Total Medicare Provider Write Off Amount")){
				returnvar = utils.validateLabel(this.labelTotalMedicareProviderWriteOffAmount,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickMedicareLink();
		if(returnvar)
		{
			System.out.println("Medicare Details Verified Successfully");
			return true;	
		}
		else
		{
			int tot_i=medicaredetails.length;
			err.logcommonMethodError("View Claim Details", "the value "+medicaredetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	@FindBy(xpath="//*[text()='ITS Specific Details']")
	WebElement ExpandITS;
	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyITSSpecificDetailsInfo
	 * #Description: This functionality verifies the data present in the ITS Specific details table.
	 * #Argument: itsspecificdetails
	 * Type: Table
	 * keys: #SCCF#Type#Date
	 */
	public boolean verifyITSSpecificDetailsInfo(String[] itsspecificdetails) throws InterruptedException
	{
		if(utils.clickAnelemnt(ExpandITS, "View Claim Details", "itsspecificdetails"))
			utils.scrolltomiddle();
		return utils.validatetablerowbasedonvalues(tblITSSpecificDetails, itsspecificdetails);

	}

	public Hashtable<String,String[]> parseTableRowData(WebElement tbl)
	{
		Hashtable<String,String[]> result = new Hashtable<String,String[]>();
		List<WebElement> allRows = tbl.findElements(By.tagName("tr"));
		if(allRows.size()>0) 
		{
			for(WebElement row:allRows)
			{
				List<WebElement>  allColsRow = row.findElements(By.tagName("td"));
				if(allColsRow.size()>0)
				{
					String[] values = new String[allColsRow.size()-1];
					System.out.println("key: " + allColsRow.get(0).getText());
					System.out.println("Values: ");
					for(int i=1; i<allColsRow.size(); i++)
					{
						values[i-1] = allColsRow.get(i).getText();
						System.out.println(values[i-1]);
					}
					result.put(allColsRow.get(0).getText(), values);
				}
			}
		}
		return result;		
	}

	public boolean validateKeyValueCombinations(WebElement tbl, String[] inputvalues)
	{
		String inputKey, inputValue;
		Hashtable<String,String[]> actualKeyValuePairs =  new Hashtable<String,String[]>();
		actualKeyValuePairs = parseTableRowData(tbl);
		for(String key: actualKeyValuePairs.keySet())
		{
			System.out.println(key + " : " + Arrays.toString(actualKeyValuePairs.get(key)));
		}
		for(String item : inputvalues)
		{
			String[] inputVals = item.split(":");
			inputKey = inputVals[0];
			inputValue = inputVals[1];
			System.out.println("input key: " + inputKey + ", Input Value: " + inputValue);
			String[] actualValuesList = actualKeyValuePairs.get(inputKey);
			System.out.println("Values List: " + Arrays.toString(actualValuesList));
			if(Arrays.asList(actualValuesList).contains(inputValue))
			{
				System.out.println(inputValue + " available in "+ Arrays.toString(actualValuesList));
				continue;
			}
			else
			{
				System.out.println(inputValue + " not available in "+ Arrays.toString(actualValuesList));
				return false;
			}	
		}
		return true ;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyAccumulatorDetails
	 * #Description: This functionality validates the information in the Accumulator table section.
	 * #Argument: accumulatorvalues
	 * Type: Table
	 * keys: FAMILY DEDUCTIBLE AGG DOL CY#FAM OPP CY INCLUDES DED#INDIVIDUAL DEDUCTIBLE CAL YR#IND OOP CY INCLUDES DD
	 */
	public boolean verifyAccumulatorDetails(String[] accumulatorvalues)
	{
		this.clickAccumulatorDetailsLink();
		return this.validateKeyValueCombinations(tblAccumulatorDetails, accumulatorvalues);
	}

	public boolean clickClaimTextLink()
	{
		return utils.clickAnelemnt(lnkProcessingDetailsClaimText, "ViewClaimDetails", "Claim Text Link");
	}


	public boolean switchWindow(String[] sUrl)
	{
		this.clickProcessingDetailsLink();
		if(utils.clickAnelemnt(lnkProcessingDetailsClaimText, "ViewClaimDetails", "Claim Edit Link"))
			return utils.TabHandles(sUrl[0]);
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickProcessingDetailsInnerLinks
	 * #Description: This functionality clicks the Processing details and clicks the links in the processing details and then validates the information in the open window and then close the child window.
	 * Type: Textbox
	 */
	public boolean clickProcessingDetailsInnerLinks(String[] sUrl)
	{

		if(utils.clickAnelemnt(lnkProcessingDetails, "ViewClaimDetails", "Processing Details Link"))
			if(utils.clickAnelemnt(lnkProcessingDetailsClaimText, "ViewClaimDetails", "Claim Edit Link"))
				return utils.TabHandles(sUrl[0]);
		return false;
	}

	public boolean verifyViewClaimDetailsInfo(String[] viewclaimdetails)
	{
		System.out.println("Entered into the method");
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : viewclaimdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyViewClaimDetailsInfo", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			if(utils.isvalueMatch_contain(key,"Claim Number")){
				returnvar = utils.validateLabel(this.labelViewClaimNumber,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Date(s) Of Service")){
				returnvar = utils.validateLabel(this.labelViewClaimDatesOfService,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Total Charged Amount")){
				returnvar = utils.validateLabel(this.labelViewClaimTotalChargedAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Rendering Provider Name")){
				returnvar = utils.validateLabel(this.labelViewClaimRenderingProviderName,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Patient Name")){
				returnvar = utils.validateLabel(this.labelViewClaimPatientName,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Patient DOB")){
				returnvar = utils.validateLabel(this.labelViewClaimPatientDOB,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Employer Group Number")){
				returnvar = utils.validateLabel(this.labelViewClaimEmployerGroupNumber,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Product Group Number")){
				returnvar = utils.validateLabel(this.labelViewClaimProductGroupNumber,value);
				continue;
			}
			err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("View Claim Details verified successfully");
			return true;	
		}
		else
		{
			int tot_i=viewclaimdetails.length;
			err.logcommonMethodError("ViewClaimDetails", "the value "+viewclaimdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	//Sprint 1.3

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions ')]")
	WebElement drpDownOtherActions;
	//@FindBy(xpath="//div[contains(text(),'Other actions')]")

	@FindBy (xpath="//li[@title='View Remit']")	
	WebElement lnkOthrActionsViewRemit;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToViewRemit
	 * #Description: This functionality navigates to the View Remit section from the View Claim Details page
	 * Type: Textbox
	 */
	public boolean navigateToViewRemit()
	{
		utils.scrolltomiddle();
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "View Remit", "ViewClaimDetails", "Navigate to View Remit");
	}

	@FindBy(xpath="//label[contains(text(),'View Claim Details')]")
	WebElement sHeader;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateTheTitleOnClickingSubmit
	 * #Description: This functionality validates the Title of the page displayed after clicking submit in the View Remit page
	 * Type: Textbox
	 */
	public boolean validateTheTitleOnClickingSubmit()
	{
		return utils.validateHeader(sHeader, "View Claim Details");

	}

	//Sprint 1.4


	@FindBy(xpath="//div[@node_name='ClaimDetails']//label[@for='PaidAs']/img")
	private WebElement paidAsHoverIcon;

	/*@FindBy (xpath="//li[@title='View EOB']/a/span/span")	
		WebElement lnkOthrActionsViewEOB;*/

	@FindBy (xpath="//li[@title='View/Send EOB']")	
	private WebElement lnkOthrActionsViewEOB;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyHoverTextInPaidAs
	 * #Description:This method validates the hover text displayed on hovering Paid As Icon in View Claim Details section.
	 * Type:Textbox
	 */
	public boolean verifyHoverTextInPaidAs(String[] hovermessage)
	{
		this.clickClaimDetailsLink();
		String hovermsg = hovermessage[0].toLowerCase();
		System.out.println("Hover Msg: "+hovermsg);
		Actions action = new Actions(Driver.pgDriver);
		action.moveToElement(paidAsHoverIcon).build().perform();
		//waitforpageload();
		String hovertext=Driver.pgDriver.findElement(By.xpath("//div[@node_name='ClaimDetails']//label[@for='PaidAs'][@data-test-id='20160518050023029419310-Label']/img")).getAttribute("aria-label").toString().replaceAll(",", "").toLowerCase();
		System.out.println("Hover Msg in UI: "+hovertext);
		return utils.isvalueMatch_contain(hovertext, hovermsg);

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToViewEOB
	 * #Description: This functionality navigates to the View EOB section from the View Claim Details page
	 * Type: Textbox
	 */
	public boolean navigateToViewEOB()
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "View/Send EOB", "ViewClaimDetails", "View EOB");

	}

	@FindBy(xpath="//input[contains(@id,'CheckReviewForContact')]")
	WebElement rdBtnClaimDiscussed;

	@FindBy(xpath="//input[contains(@id,'Adjustable')]")
	WebElement rdBtnClaimRequiresAdjustment;

	public boolean clickrdBtnClaimDiscussed()
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.rdBtnClaimDiscussed , "Manage claims", "Radio button Claim Discussed")) {
			utils.scrolltomiddle();
			utils.scrolltoright();
			return utils.clickAnelemnt(this.btnSubmit, "View Claims", "Submit Button");
		}
		return false;
	}

	public boolean clickrdBtnClaimRequiresAdjustment()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(this.rdBtnClaimRequiresAdjustment , "Manage claims", "Radio button Requiring Adjust");

	}


	//Regression Codes

	@FindBy(xpath="//a[@tabtitle='Line Details']")
	WebElement tabLineDetails;

	@FindBy(xpath="//table[@pl_prop='.ClaimLinePage.ClaimCalculationList']")
	WebElement tblLineDetails;

	@FindBy(xpath="//div[@node_name='ClaimLineDetails']//label[@for='CoinsuranceAmount']//following-sibling::div/span[@data-test-id='2016020405573204502064']")
	WebElement labelCoinsuranceAmount;

	@FindBy(xpath="//div[@node_name='ClaimLineDetails']//label[@for='CoinsurancePayPercentage']//following-sibling::div/span[@data-test-id='2016020405573204502064']")
	WebElement labelCoinsurancePercentage;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickLineDetails
	 * #Description: This functionality clicks on the Line Details tab.
	 * #Type: Textbox
	 */
	public boolean clickLineDetails()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.tabLineDetails, "ViewClaimDetails", "Line Details");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateLineDetailsAndClickTheRow
	 * #Description: This functionality validated the information present in  the Line Details row section
	 * #Argument: Row Details
	 * #Type: Table
	 * keys: Line#Date(s) of Service#Procedure Code#Line Charged Amount#Allowed Amount#Write Off Amount#Member Liability Amount#Paid Amount
	 */
	public boolean validateLineDetailsAndClickTheRow(String[] tablevalues) throws InterruptedException
	{
		return utils.clickontablerowbasedonvalues(tblLineDetails, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyLineDetailsInfo
	 * #Description: This functionality validated the information present in  the Line Details section
	 * #Argument: linedetails
	 * #Type: Table
	 * keys: Coinsurance Amount#Coinsurance Percentage
	 */

	public boolean verifyLineDetailsInfo(String[] linedetails)
	{

		System.out.println("Entered into the method");
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : linedetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyLineDetailsInfo", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"Coinsurance Amount")){
				returnvar = utils.validateLabel(this.labelCoinsuranceAmount,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Coinsurance Percentage")){
				returnvar = utils.validateLabel(this.labelCoinsurancePercentage,value);
				continue;
			}

			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("Claim Details verified successfully");
			return true;	
		}
		else
		{
			int tot_i=linedetails.length;
			err.logcommonMethodError("ViewClaimDetails", "the value "+linedetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	//@FindBy(id="TagGandA_rdi_1")
	@FindBy(xpath="//input[contains(@id,'TagGandA')]")
	private WebElement GAChkBox;

	@FindBy(xpath="//input[@id='TagGandA'][@checked]")
	private WebElement GAChked;

	@FindBy(xpath="//label[text()='Claim has Grievance and/ or Appeal']")
	private WebElement GAChkBoxLbl;

	@FindBy(id="CheckReviewForContact_rdi_1")
	private WebElement claimDiscussedChkBox;

	@FindBy(xpath="//input[@id='CheckReviewForContact'][@checked]")
	private WebElement claimDiscussedChked;

	@FindBy(xpath="//label[text()='Claim discussed with contact']")
	private WebElement claimDiscussedChkBoxLbl;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyClaimHasGrievanceAndAppealsCheckBox
	 * #Description:This method verifies 'Claim Has Grievance And Appeals CheckBox' in View Claim Details page.
	 * Type:Textbox
	 */
	public boolean verifyClaimHasGrievanceAndAppealsCheckBox(){
		return !utils.isProxyWebelement(GAChkBox) && !utils.isProxyWebelement(GAChkBoxLbl);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectClaimHasGACheckBox
	 * #Description:This method selects 'Claim Has Grievance And Appeals CheckBox' in View Claim Details page.
	 * Type:Textbox
	 */
	public boolean selectClaimHasGACheckBox() throws InterruptedException{
		Thread.sleep(3000);
		return utils.clickAnelemnt(this.GAChkBox, "ViewClaimDetails", "Claim has Grievance and/ or Appeal checkbox");
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectClaimDiscussedWithContactCheckBox
	 * #Description:This method selects 'Claim Discussed With Contact CheckBox' in View Claim Details page.
	 * Type:Textbox
	 */
	public boolean selectClaimDiscussedWithContactCheckBox(){
		utils.waitforpageload();
		return utils.clickAnelemnt(this.claimDiscussedChkBox, "ViewClaimDetails", "Claim Discussed With Contact CheckBox");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyClaimHasGAIsChecked
	 * #Description:This method verifies if 'Claim Has Grievance And Appeals CheckBox' in View Claim Details page is checked
	 * Type:Textbox
	 */
	public boolean verifyClaimHasGAIsChecked(){	
		if(this.GAChked.getAttribute("checked").equalsIgnoreCase("true")){
			blogger.loginfo("Claim has Grievance and/ or Appeal checkbox is checked");
			return true;
		}else{
			blogger.loginfo("Claim has Grievance and/ or Appeal checkbox isnt checked");
			return false;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyClaimDiscussedWithContactIsChecked
	 * #Description:This method verifies if 'Claim Discussed With Contact CheckBox' in View Claim Details page is checked.
	 * Type:Textbox
	 */
	public boolean verifyClaimDiscussedWithContactIsChecked(){
		if(this.claimDiscussedChked.getAttribute("checked").equalsIgnoreCase("true")){
			blogger.loginfo("Claim Discussed With Contact CheckBox is checked");
			return true;
		}else{
			blogger.loginfo("Claim Discussed With Contact CheckBox isnt checked");
			return false;
		}
	}
	@FindBy(xpath="//input[@id='ClaimAdjustable'][@disabled]")
	private WebElement claimRequiresAdjustmentDisabled;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyClaimRequiresAdjustmentIsDisabled
	 * #Description:This method verifies if 'Claim Requires Adjustment CheckBox' in View Claim Details page is disabled
	 * Type:Textbox
	 */
	public boolean verifyClaimRequiresAdjustmentIsDisabled(){
		utils.waitforpageload();
		if(this.claimRequiresAdjustmentDisabled.getAttribute("disabled").equalsIgnoreCase("true")){
			blogger.loginfo("Claim Requires Adjustment CheckBox is disabled");
			return true;
		}else{
			blogger.loginfo("Claim Requires Adjustment CheckBox isnt disabled");
			return false;
		}
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in 'View Claim Details' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmit() throws InterruptedException{
		Thread.sleep(3000);
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit,"ViewClaimDetails","Submit Button");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in 'View Claim Details' page.
	 * Type:TextBox
	 */
	public boolean clickSubmit() throws InterruptedException{
		Thread.sleep(3000);
		return utils.clickAnelemnt(this.btnSubmit,"ViewClaimDetails","Submit Button");
	}


	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Empowerment Guidelines']")
	private WebElement EmpowermentGuidelinesBtn;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyEmpowermentGuidelinesBtn
	 * #Description:This method verifies the display of Empowerment Guidelines Button in View Claim Details page.
	 * Type:TextBox
	 */
	public boolean verifyEmpowermentGuidelinesBtn(){
		return !utils.isProxyWebelement(EmpowermentGuidelinesBtn);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickEmpowermentGuidelinesBtn
	 * #Description:This method clicks on Empowerment Guidelines Button in View Claim Details page.
	 * Type:TextBox
	 */
	public boolean clickEmpowermentGuidelinesBtn(){
		return utils.clickAnelemnt(this.EmpowermentGuidelinesBtn,"ViewClaimDetails","EmpowermentGuidelines Button");
	}

	@FindBy(xpath="//span[@id='modaldialog_hd_title'][contains(text(),'View Authorizations')]")
	private WebElement viewAuthorizationAlertHeader;

	@FindBy(xpath="//*[@data-test-id='201802151530130904210905']")
	private WebElement viewAuthorizationEmpMsg;


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDisplayOfViewAuthPopUp
	 * #Description:This method verifies the display of View Authorization pop-up and validates the text displayed, when user clicks on Empowerment Guidelines Button in View Claim Details page.
	 * Type:TextBox
	 */
	public boolean verifyDisplayOfViewAuthPopUp(){
		String empMsg = "Select the Authorization that qualifies the Out of Network claims to be processed as an In Network Claims under the empowerment guidelines.";
		String actaulMsg = viewAuthorizationEmpMsg.getText();
		return utils.isvalueMatch_contain(empMsg, actaulMsg);
	}

	@FindBy(xpath="//table[@pl_prop='D_Authorizations.pxResults']")
	private WebElement viewAuthorizationDetailsTable;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:expandAuthorizationDetail
	 * #Description:This method clicks on expand icon pertaining to Authorization detail in View Authorization pop-up.
	 * #Argument:AuthorizationDetails
	 * Type:Table
	 * Keys:Creation Date#Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean expandAuthorizationDetail(String[] args)
	{
		try{
			WebElement result = utils.returntablerowbasedonvalues(viewAuthorizationDetailsTable,args);
			List<WebElement> tdList = result.findElements(By.tagName("td"));
			tdList.get(0).click();
			return true;
		}catch(Exception e){
			err.logError("ViewClaimDetails", "expandAuthorizationDetail - Couldnt find matching Authorization details to expand");
			System.out.println("Exception occured in expandAuthorizationDetail"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:selectAuthorizationDetail
	 * #Description:This method selects an Authorization detail in View Authorization pop-up.
	 * #Argument:Select Authorization
	 * Type:Table
	 * Keys:Creation Date#Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean selectAuthorizationDetail(String[] args)
	{
		try{
			WebElement result = utils.returntablerowbasedonvalues(viewAuthorizationDetailsTable,args);
			List<WebElement> tdList = result.findElements(By.tagName("td"));
			tdList.get(1).click();
			return true;
		}catch(Exception e){
			err.logError("ViewClaimDetails", "selectAuthorizationDetail - Couldnt select Authorization details");
			System.out.println("Exception occured in selectAuthorizationDetail"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyAuthorizationNumberIsNotClickable
	 * #Description:This method verifies the Authorization number field is not-clickable in View Authorization pop-up.
	 * #Argument:AuthorizationNumber
	 * Type:Table
	 * Keys:Service From Date#Service To Date#Authorization Number#Service Provider#Service Provider Location#Record Type#PreAuth Type#Authorization Type#Status
	 */
	public boolean verifyAuthorizationNumberIsNotClickable(String[] args)
	{
		try{
			WebElement result = utils.returntablerowbasedonvalues(viewAuthorizationDetailsTable,args);
			List<WebElement> tdList = result.findElements(By.tagName("td"));
			tdList.get(2).click();
			return true;
		}catch(Exception e){
			err.logError("ViewClaimDetails", "verifyAuthorizationNumberIsNotClickable -View Authorization");
			System.out.println("Exception occured in verifyAuthorizationNumberIsNotClickable"+e);
			return false;
		}
	}

	@FindBy(id="ModalButtonCancel")
	private WebElement cancelInViewAuthPopUp;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:cancelInViewAuthPopUp
	 * #Description:This method clicks on cancel button in View Authorization pop-up, and validate View Claims Details page is displayed.
	 * Type:TextBox
	 */
	public boolean cancelInViewAuthPopUp(){
		if(utils.clickAnelemnt(this.cancelInViewAuthPopUp, "ViewClaimDetails", "Cancel Button in View Authorization Popup"))
			if(utils.validateHeader(this.sHeader, "View Claim Details"))
				return true;		
		return false;
	}

	@FindBy(id="ModalButtonSubmit")
	private WebElement submitInViewAuthPopUp;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:submitInViewAuthPopUp
	 * #Description:This method clicks on submit button in View Authorization pop-up.
	 * Type:TextBox
	 */
	public boolean submitInViewAuthPopUp(){
		return utils.clickAnelemnt(this.submitInViewAuthPopUp, "ViewClaimDetails", "Submit Button in View Authorization Popup");
	}

	@FindBy(xpath="//input[contains(@id,'ClaimAdjustable')][@checked]")
	private WebElement ClaimRequiresAdjustmentChked;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyClaimRequiresAdjustmentIsChecked
	 * #Description:This method verifies if 'Claim Requires Adjustment CheckBox' in View Claim Details page is checked.
	 * Type:TextBox
	 */
	public boolean verifyClaimRequiresAdjustmentIsChecked(){
		if(this.ClaimRequiresAdjustmentChked.getAttribute("checked").equalsIgnoreCase("true")){
			blogger.loginfo("Claim Requires Adjustment Is Checked in 'View Claim Details' page - successful");
			return true;
		}else{
			blogger.loginfo("Claim Requires Adjustment checkbox isnt checked");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyClaimRequiresAdjustmentIsNotChecked
	 * #Description:This method verifies if 'Claim Requires Adjustment CheckBox' in View Claim Details page is not checked.
	 * Type:TextBox
	 */
	public boolean verifyClaimRequiresAdjustmentIsNotChecked(){			
		if(this.ClaimRequiresAdjustmentChked.getAttribute("checked").equalsIgnoreCase("true")){
			err.logError("Claim Requires Adjustment Is Checked in 'View Claim Details' page - negative test");
			return false;
		}else{
			blogger.loginfo("verifyClaimRequiresAdjustmentIsNotChecked", "Claim Requires Adjustment Isnt Checked in 'View Claim Details' page");
			return true;
		}
	}

	@FindBy(id="ReasonForAdjustments")
	private WebElement reasonForAdjustment;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectReasonForAdjustment
	 * #Description:This method allows user to select the 'Reason for Adjustment' in View Claim Details page
	 * #Arguments:ReasonForAdjustment
	 * Type:Dropdown
	 * Keys:COB Adjustments#Provider Contract or Pricing Review#Medical Review Denial#Authorization#Referral# Retroactive Review Request#Coding Change or Question#Corrected Claim#Duplicate Claim Review#Incorrect Benefits Applied or Quoted#Other
	 */
	public boolean selectReasonForAdjustment(String[] args){
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(this.reasonForAdjustment, args[0], "ViewClaimDetails", "Reason for Adjustment");
	}

	@FindBy(id="pyNote")
	private WebElement NotesMsg;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateNotesMsg
	 * #Description:This method validates the message text populated in Notes section in View Claim Details page
	 * #Arguments:AuthorizationNo
	 * Type:Textbox
	 */
	public boolean validateNotesMsg(String[] args){
		try{
			String notesText=this.NotesMsg.getText().trim();
			System.out.println(notesText);
			if(notesText.equalsIgnoreCase("")){
				blogger.loginfo("validateNotesMsg successful in View Claim Details page");
				return true;
			}else{
				err.logcommonMethodError("validateNotesMsg","Notes message doesnt match in View Claim Details page");
				return false;
			}
		}catch (Exception e){
			err.logError("validateNotesMsg", "Notes Message - couldnt be retrieved");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:EmpAuthWarningPopUp
	 * #Description:This method validates the display of Empowerment Authorization Warning pop-up, when user doesnt select any authorization but proceeds to submit
	 * Type:Textbox
	 */
	public boolean EmpAuthWarningPopUp(String[] args){
		try{
			return true;  
		}
		catch (Exception e){
			err.logError("EmpAuthWarningPopUp", "Empowerment Authorization Warning PopUp - couldnt be retrieved");
			return false;
		}
	}

	@FindBy(id="")
	private WebElement submitInEmpAuthWarningPopUp;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickSubmitInEmpAuthWarningPopUp
	 * #Description:This method clicks on submit button in Empowerment Authorization Warning pop-up
	 * Type:Textbox
	 */
	public boolean clickSubmitInEmpAuthWarningPopUp(String[] args){
		return utils.clickAnelemnt(this.submitInEmpAuthWarningPopUp, "ViewClaimDetails","Submit Button In Emp Auth Warning PopUp");
	}

	@FindBy(id="")
	private WebElement cancelInEmpAuthWarningPopUp;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickCancelInEmpAuthWarningPopUp
	 * #Description:This method clicks on Cancel button in Empowerment Authorization Warning pop-up
	 * Type:Textbox
	 */
	public boolean clickCancelInEmpAuthWarningPopUp(String[] args){
		return utils.clickAnelemnt(this.cancelInEmpAuthWarningPopUp,"ViewClaimDetails", "Cancel Button In Emp Auth Warning PopUp");
	}

	@FindBy(xpath="//*[contains(text(),'Other actions')]")
	private WebElement otherAction;		

	@FindBy(xpath="//li[@title='Search Related Images']")
	private WebElement SearchRelatedImages;

	@FindBy(xpath="//label[contains(text(),'Claim requires medical review')]")
	private WebElement ClaimRequiresMedicalReview;	

	@FindBy(xpath="//label[contains(text(),'Claim requires medical review')]/preceding-sibling::input[@type='checkbox']")
	private WebElement chkBoxClaimRequiresMedicalReview;	


	public boolean clickOtherAction(){
		return utils.clickAnelemnt(this.otherAction, "ViewClaimDetails", "clickOtherAction");
	}


	public boolean clickSearchRelatedImages(){
		if(clickOtherAction())
			if(utils.clickAnelemnt(this.SearchRelatedImages, "ViewClaimDetails", "clickSearchRelatedImages"))
				return true;
		return false;
	}

	@FindBy (xpath="//li[@title='Search Related Images']")	
	private WebElement lnkOthrActionsSearchRelatedImages;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderViewClaimDetails;
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:navigateToSearchRelatedImages
	 * #Description: This functionality navigates to the Search Related Images screen from the View Claim Details page
	 * Type: Textbox
	 */
	public boolean navigateToSearchRelatedImages() throws Exception
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ViewClaimDetails", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsSearchRelatedImages, "ViewClaimDetails", "Search Related Images"))
				if(utils.validateHeader(this.sHeaderViewClaimDetails, "Search Related Images"))
					return true;
		return false;
	}

	@FindBy(id="CheckRequiresMedicalReview_rdi_1")
	private WebElement claimMedicalReviewChkBox;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectClaimRequiresMedicalReviewCheckBox
	 * #Description:This method selects 'Claim requires medical review CheckBox' in View Claim Details page.
	 * Type:Textbox
	 */
	public boolean selectClaimRequiresMedicalReviewCheckBox(){	
		return utils.clickAnelemnt(this.claimMedicalReviewChkBox, "ViewClaimDetails", "Claim requires medical review CheckBox");
	}


	@FindBy(linkText="Interest Paid (IP)")
	private WebElement linkInterestPaid;

	public boolean clickInterestPaidLink()
	{
		return utils.clickAnelemnt(linkInterestPaid, "ViewClaimDetails", "InterestPaidLink");
	}



	@FindBy(xpath ="//label[contains(text(),'Calculation From Date')]/following-sibling::div")
	private WebElement calculationFromDate;

	@FindBy(xpath ="//label[contains(text(),'Last Processed Date')]/following-sibling::div")
	private WebElement LastProcessedDate;

	@FindBy(xpath ="//label[contains(text(),'Claim Paid Amount')]/following-sibling::div")
	private WebElement claimPaidAmount;

	@FindBy(xpath ="//label[contains(text(),'Pricing State')]/following-sibling::div")
	private WebElement pricingState;


	@FindBy(xpath ="//label[contains(text(),'Total Interest Amount Paid')]/following-sibling::div")
	private WebElement totalInterestAmountPaid;

	@FindBy(xpath ="//label[contains(text(),'MCS Settlement')]/following-sibling::div")
	private WebElement MCSSettlement;

	@FindBy(xpath ="//label[contains(text(),'Interest Base Amount')]/following-sibling::div")
	private WebElement interestBaseAmount;

	@FindBy(xpath ="//label[contains(text(),'Claim Processed in (Days)')]/following-sibling::div")
	private WebElement ClaimProcessedinDays;

	@FindBy(xpath ="//label[contains(text(),'Days for Mailing')]/following-sibling::div")
	private WebElement DaysforMailing;

	@FindBy(xpath ="//label[contains(text(),'Claim Late by (Days)')]/following-sibling::div")
	private WebElement ClaimLatebyDays;

	@FindBy(xpath ="//label[contains(text(),'Daily Interest Amount')]/following-sibling::div")
	private WebElement DailyInterestAmount;


	@FindBy(xpath ="//label[contains(text(),'Total Interest Amount Calculated')]/following-sibling::div")
	private WebElement totalInterestAmountCalculated;

	@FindBy(xpath ="//label[contains(text(),'Total Interest Amount to be Paid')]/following-sibling::div")
	private WebElement TotalInterestAmounttobePaid;

	@FindBy(xpath ="//label[contains(text(),'Total Penalty Amount to be Paid')]/following-sibling::div")
	private WebElement TotalPenaltyAmounttobePaid;

	@FindBy(xpath ="//label[contains(text(),'Carve Out Date')]/following-sibling::div")
	private WebElement CarveOutDate;

	@FindBy(xpath ="//label[contains(text(),'Carved Out Days')]/following-sibling::div")
	private WebElement CarvedOutDays;

	@FindBy(xpath ="//label[contains(text(),'Minimum Days to Process')]/following-sibling::div")
	private WebElement MinimumDaystoProcess;

	@FindBy(xpath ="//label[contains(text(),'Business/ Calendar Days')]/following-sibling::div")
	private WebElement BusinessCalendarDays;

	@FindBy(xpath ="//label[contains(text(),'Paper / EDI')]/following-sibling::div")
	private WebElement PaperEDI;

	@FindBy(xpath ="//label[contains(text(),'Interest Percentage')]/following-sibling::div")
	private WebElement InterestPercentage;					

	@FindBy(xpath ="//label[contains(text(),'Penalty Percentage')]/following-sibling::div")
	private WebElement PenaltyPercentage;

	@FindBy(xpath ="//label[contains(text(),'Annual / Monthly')]/following-sibling::div")
	private WebElement AnnualMonthly;

	@FindBy(xpath ="//label[contains(text(),'Minimum Pay Amount')]/following-sibling::div")
	private WebElement MinimumPayAmount;

	@FindBy(xpath ="//label[contains(text(),'Product Type')]/following-sibling::div")
	private WebElement ProductType;

	@FindBy(xpath ="//label[contains(text(),'ER Minimum Pay')]/following-sibling::div")
	private WebElement ERMinimumPay;

	@FindBy(xpath ="//label[contains(text(),'Carveout RSNCD')]/following-sibling::div")
	private WebElement CarveoutRSNCD;

	@FindBy(xpath ="//label[contains(text(),'Check Number')]/following-sibling::div")
	private WebElement CheckNumber;

	@FindBy(xpath ="//label[contains(text(),'Check Date')]/following-sibling::div")
	private WebElement CheckDate;

	@FindBy(xpath ="//label[contains(text(),'Check Amount')]/following-sibling::div")
	private WebElement CheckAmount;

	@FindBy(xpath ="//label[contains(text(),'Account Number')]/following-sibling::div")
	private WebElement AccountNumber;					

	@FindBy(xpath ="//label[contains(text(),'Penalty Percentage')]/following-sibling::div")
	private WebElement BankCode;

	@FindBy(xpath ="//label[contains(text(),'Out Sequence')]/following-sibling::div")
	private WebElement OutSequence;

	@FindBy(xpath ="//label[contains(text(),'Bank Withhold Amount')]/following-sibling::div")
	private WebElement BankWithholdAmount;



	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyPricingDetailsInterestPaid
	 * #Description: This functionality validates the information in the PricingDetails section.
	 * #Argument: PricingDetails
	 * Type: Table
	 * keys: calculationFromDate#LastProcessedDate#claimPaidAmount#pricingState#totalInterestAmountPaid#MCSSettlement#interestBaseAmount#ClaimProcessedinDays#DaysforMailing#ClaimLatebyDays#DailyInterestAmount#totalInterestAmountCalculated#TotalInterestAmounttobePaid#TotalPenaltyAmounttobePaid#CarveOutDateCarveOutDate#CarvedOutDays#MinimumDaystoProcess#BusinessCalendarDays#PaperEDI#InterestPercentage#PenaltyPercentage#AnnualMonthly#MinimumPayAmount#ProductType#ERMinimumPay#CarveoutRSNCD#CheckNumber#CheckDate#CheckAmount#AccountNumber#BankCode#OutSequence#BankWithholdAmount
	 */
	public boolean verifyPricingDetailsInterestPaid(String[] PricingDetails) throws Exception
	{
		System.out.println("Entered into the method");
		this.clickPricingDetailsLink();
		utils.waitforpageload();
		this.clickInterestPaidLink();
		utils.waitforpageload();
		utils.TabHandles("Pricing Details Popup");						
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : PricingDetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyPricingDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + " " + "value  " + value);

			if(key.equals("calculationFromDate")){
				returnvar = utils.validateValueinelement(this.calculationFromDate, value);
				continue;}
			else if(key.equals("LastProcessedDate")){
				returnvar =utils.validateValueinelement(this.LastProcessedDate, value);
				continue;}
			else if(key.equals("claimPaidAmount")){
				returnvar =utils.validateValueinelement(this.claimPaidAmount, value);
				continue;
			}
			else if(key.equals("pricingState")){
				returnvar =utils.validateValueinelement(this.pricingState, value);
				continue;
			}
			else if(key.equals("totalInterestAmountPaid")){
				returnvar = utils.validateValueinelement(this.totalInterestAmountPaid, value);
				continue;
			}
			else if(key.equals("MCSSettlement")){
				returnvar =utils.validateValueinelement(this.MCSSettlement, value);
				continue;
			}
			else if(key.equals("interestBaseAmount")){
				returnvar = utils.validateValueinelement(this.interestBaseAmount, value);
				continue;
			}
			else if(key.equals("ClaimProcessedinDays")){
				returnvar = utils.validateValueinelement(this.ClaimProcessedinDays, value);
				continue;
			}
			else if(key.equals("DaysforMailing")){
				returnvar = utils.validateValueinelement(this.DaysforMailing, value);
				continue;
			}

			else if(key.equals("ClaimLatebyDays")){
				returnvar = utils.validateValueinelement(this.ClaimLatebyDays, value);
				continue;
			}
			else if(key.equals("DailyInterestAmount")){
				returnvar = utils.validateValueinelement(this.DailyInterestAmount, value);
				continue;
			}

			else if(key.equals("totalInterestAmountCalculated")){
				returnvar = utils.validateValueinelement(this.totalInterestAmountCalculated, value);
				continue;
			}

			else if(key.equals("TotalInterestAmounttobePaid")){
				returnvar = utils.validateValueinelement(this.TotalInterestAmounttobePaid, value);
				continue;
			}

			else if(key.equals("TotalPenaltyAmounttobePaid")){
				returnvar = utils.validateValueinelement(this.TotalPenaltyAmounttobePaid, value);
				continue;
			}

			else if(key.equals("BusinessCalendarDays")){
				returnvar = utils.validateValueinelement(this.BusinessCalendarDays, value);
				continue;
			}

			else if(key.equals("PaperEDI")){
				returnvar = utils.validateValueinelement(this.PaperEDI, value);
				continue;
			}

			else if(key.equals("MinimumDaystoProcess")){
				returnvar = utils.validateValueinelement(this.MinimumDaystoProcess, value);
				continue;
			}

			else if(key.equals("InterestPercentage")){
				returnvar = utils.validateValueinelement(this.InterestPercentage, value);
				continue;
			}

			else if(key.equals("PenaltyPercentage")){
				returnvar = utils.validateValueinelement(this.PenaltyPercentage, value);
				continue;
			}

			else if(key.equals("AnnualMonthly")){
				returnvar = utils.validateValueinelement(this.AnnualMonthly, value);
				continue;
			}
			else if(key.equals("MinimumPayAmount")){
				returnvar = utils.validateValueinelement(this.MinimumPayAmount, value);
				continue;
			}

			else if(key.equals("ProductType")){
				returnvar = utils.validateValueinelement(this.ProductType, value);
				continue;
			}

			else if(key.equals("ERMinimumPay")){
				returnvar = utils.validateValueinelement(this.ERMinimumPay, value);
				continue;
			}

			else if(key.equals("CheckNumber")){
				returnvar = utils.validateValueinelement(this.CheckNumber, value);
				continue;
			}

			else if(key.equals("CheckDate")){
				returnvar = utils.validateValueinelement(this.CheckDate, value);
				continue;
			}

			else if(key.equals("CheckAmount")){
				returnvar = utils.validateValueinelement(this.CheckAmount, value);
				continue;
			}

			else if(key.equals("AccountNumber")){
				returnvar = utils.validateValueinelement(this.AccountNumber, value);
				continue;
			}
			else if(key.equals("BankCode")){
				returnvar = utils.validateValueinelement(this.BankCode, value);
				continue;
			}

			else if(key.equals("OutSequence")){
				returnvar = utils.validateValueinelement(this.OutSequence, value);
				continue;
			}								

			else if(key.equals("BankWithholdAmount")){
				returnvar = utils.validateValueinelement(this.BankWithholdAmount, value);
				continue;
			}

			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("Claim Calculations verified successfully");
			return true;	
		}
		else
		{
			int tot_i=PricingDetails.length;
			err.logcommonMethodError("ViewClaimDetails", "the value "+PricingDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	public boolean expandRenderingProviderDetails()
	{

		return utils.clickAnelemnt(lnkRenderingProviderDetails, "ViewClaimDetails" , "Rendering Provider Details Link");
	}


	public boolean validateRenderingProviderDetails(String[] renderingproviderdetails)
	{
		System.out.println("Entered into the method");
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : renderingproviderdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimCalulations", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			if(utils.isvalueMatch_contain(key,"Name")){
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsName,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Tax ID")){
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsTaxID,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"NPI")){
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsNPI,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Address on Claim")){	
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsAddress,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Phone Number")){	
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsPhoneNumber,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Plan Network Status")){		
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsPlanNetworkStatus,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Type")){		
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsType,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Speciality")){		
				returnvar = utils.validateLabel(this.labelRenderingProviderDetailsSpeciality,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Provider Legacy ID")){		
				returnvar = utils.validateLabel(this.valueRenderingProviderLegacyID,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Provider Specialty Contract ID")){		
				returnvar = utils.validateLabel(this.valueRenderingProviderSpecialityContractID,value);
				continue;
			}

			else 
				err.logcommonMethodError("ViewClaimDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		this.clickRenderingProviderDetailsLink();
		if(returnvar)
		{
			System.out.println("Rendering Provider Details Verified Successfully");
			return true;	
		}
		else
		{
			int tot_i=renderingproviderdetails.length;
			err.logcommonMethodError("View Claim Details", "the value "+renderingproviderdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}


	public boolean hoverProviderLegacyID()
	{

		action.moveToElement(labelRenderingProviderLegacyID).build().perform();
		System.out.println("sdgsdgb");
		utils.clickAnelemnt(hoverRenderingProviderLegacyID, "ViewPageDetails", "");
		String hovertext=hoverRenderingProviderLegacyID.getAttribute("aria-label").toLowerCase();
		System.out.println("HOVERTEXT:"+hovertext);
		return utils.isvalueMatch_contain(hovertext, "alternate id for this rendering provider");
	}

	public boolean hoverProviderSpecialityContractID(String[] ProviderSpecialityContractID)
	{

		action.moveToElement(labelRenderingProviderSpecialityContractID).build().perform();
		utils.clickAnelemnt(hoverRenderingProviderSpecialityContractID, "ViewPageDetails", "");
		String hovertext=hoverRenderingProviderSpecialityContractID.getAttribute("aria-label").toString().toLowerCase();
		System.out.println(hovertext);
		String userHoverText= ProviderSpecialityContractID[0].toLowerCase();
		System.out.println("User hover "+userHoverText);
		return utils.isvalueMatch_contain(hovertext, userHoverText);
	}

	public boolean VerifyErrorMessageNotPresentForClaimLineDetail(){
		clickLineDetails();
		return !utils.isProxyWebelement(tblLineDetails);
	}

	//Sprint 3.2

	@FindBy(id="ClaimAdjustable")
	private WebElement claimRequiresAdjChkBox;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectClaimRequiresAdjustmentCheckBox
	 * #Description:This method selects 'Claim Requires Adjustment CheckBox' in View Claim Details page.
	 * Type:Textbox
	 */
	public boolean selectClaimRequiresAdjustmentCheckBox(){
		return utils.clickAnelemnt(this.claimRequiresAdjChkBox, "ViewClaimDetails", "Claim Requires Adjustment CheckBox");
	}


	//Sprint 3.2


	@FindBy(xpath="//div[@node_name='pzModalTemplate']")
	WebElement modalDialog;

	@FindBy(xpath="//span[@id='modaldialog_hd_title']")
	WebElement labelModalDialogHeader;

	@FindBy(xpath="//table[@pl_prop='parent.ClaimTextList']")
	WebElement tblClaimTexts;

	@FindBy(xpath="//div[@data-test-id='201802151530130904210905']")
	WebElement labelInstructionalTexts;

	@FindBy(id="ModalButtonSubmit")
	WebElement btnSubmitInModalDialog;

	@FindBy(id="ModalButtonCancel")
	WebElement btnCancelInModalDialog;

	@FindBy(id="pyNote")
	WebElement txtNotes;





	public boolean validateViewClaimTextModalPopUpIsDisplayed()
	{
		return !utils.isProxyWebelement(modalDialog);
	}



	public boolean validatesTheClaimTextInTheModalDialog(String[] tablevalues)
	{
		try
		{
			System.out.println("Entered");
			WebElement table = this.tblClaimTexts;
			List<WebElement> rowValues = table.findElements(By.tagName("td"));
			if(rowValues.contains(tablevalues[0]))
			{
				System.out.println("Value is found in the Claim texts table");
				return true;
			}else
			{
				System.out.println("Value is not found in the Claim texts table");
				return false;
			}

			//return utils.validatetablerowbasedonvalues(this.tblClaimTexts, tablevalues);

		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("ViewClaimDetails", "validatesTheClaimTextInTheModalDialog", "View Claim Text is not validated");
			return false;
		}
	}


	public boolean validateInstTextOnViewClaimTextModalPopUp()
	{
		return utils.validateLabel(this.labelInstructionalTexts, "If the Claims Text qualifies the Out of Network claims to be processed as In Network claims under the empowerment guideline, click Submit. If it does not, click Cancel.");
	}


	public boolean clickCancelOnModalPopUp()
	{
		return utils.clickAnelemnt(this.btnCancelInModalDialog, "ViewClaimDetails", "Cancel button in Modal Dialog is failed");
	}

	public boolean clickSubmitOnModalPopUp()
	{
		return utils.clickAnelemnt(this.btnSubmitInModalDialog, "ViewClaimDetails", "Submit button in Modal Dialog is failed");
	}


	public boolean validateModalPopUpIsClosed()
	{
		return !utils.isProxyWebelement(modalDialog);
	}



	public boolean validateNotesFieldIsPopulatedWithDefaultValue()
	{
		return utils.validateLabel(this.txtNotes, "Out of Network Claim can be adjusted as an In Network Claim because the referring doctor is an in-network provider for this date of service.");
	}


	public boolean validateClaimRequiresAdjustmentIsNotAutoChecked()
	{
		try
		{
			this.claimDiscussedChkBox.isSelected();
			blogger.loginfo("Claims Required Checkbox is auto checked");
			return false;	
		}catch(Exception e)
		{
			blogger.loginfo("Claims Required Checkbox is not auto checked");
			return true;
		}
	}

	public boolean validateNotesFieldIsNotAutoPopulated()
	{
		try
		{
			this.txtNotes.isDisplayed();
			blogger.loginfo("Notes Field is Auto Populated");
			return false;
		}catch(Exception e)
		{
			blogger.loginfo("Notes Field is not Auto Populated");
			return true;
		}
	}



	//Sprint 3.3


	//@FindBy(id="IsOneDayGrievance_rdi_1")
	@FindBy(xpath="//input[@id='IsOneDayGrievance']")
	WebElement rdoBtnClaimHasOneDayGrievance;
	
	@FindBy(xpath="//input[@id='TagGandA_rdi_1']")
	WebElement rdoBtnClaimHasGandA;


	public boolean verifyClaimHasOneDayGrievanceChkBoxIsDisplayedForCAMember()
	{
		try
		{
			this.rdoBtnClaimHasOneDayGrievance.isDisplayed();
			blogger.loginfo("Claim Has One Day Grievance Check Box is Displayed");
			return true;
		}catch(Exception e)
		{
			blogger.loginfo("Claim Has One Day Grievance Check Box is Displayed");
			return false;
		}
	}


	public boolean verifyClaimHasOneDayGrievanceChkBoxIsNotDisplayedForNonCAMember()
	{
		try
		{
			this.rdoBtnClaimHasOneDayGrievance.isDisplayed();
			blogger.loginfo("Claim Has One Day Grievance Check Box is Displayed");
			return false;
		}catch(Exception e)
		{
			blogger.loginfo("Claim Has One Day Grievance Check Box is not Displayed");
			return true;
		}
	}

@FindBy(xpath="//div[@show_when='.TagGandA']//p/..")
WebElement InstructionalTextforGandA;

@FindBy(xpath="//div[@show_when='.IsOneDayGrievance']//p/..")
WebElement InstructionalTextforODG;
	
	public boolean clickClaimHasOneDayGrievanceCheckBox() 
	{
		
		return utils.clickAnelemnt(rdoBtnClaimHasOneDayGrievance, "ViewClaimDetails", "Claim Has One Day Grievance Check Box");
		

	}
	
	public boolean validateInstructionalTextforODG(String[] args)
	{
		String actualText = args[0];
		System.out.println("Actual Text: "+actualText);
		String expectedText = InstructionalTextforODG.getText().trim();
		String expectedtext1=expectedText.replaceAll("\n","");
		System.out.println("Expected Text: "+expectedtext1);
		return utils.isvalueMatch_contain(actualText, expectedtext1);
	}
	
	public boolean clickClaimHasGandACheckBox() 
	{
		
		return utils.clickAnelemnt(rdoBtnClaimHasGandA, "ViewClaimDetails", "Claim Has One Day Grievance Check Box");
			}
	
	
	@FindBy(xpath="//input[@id='ClaimAdjustable_rdi_1']")
	WebElement rdoBtnClaimRequiresAdjustment;
	
	public boolean clickClaimRequiresAdjustmentCheckBox() 
	{
		
		return utils.clickAnelemnt(rdoBtnClaimRequiresAdjustment, "ViewClaimDetails", "Claim Has One Day Grievance Check Box");
			}
	public boolean validateInstructionalTextforGandA(String[] args)
	{
		String actualText = args[0];
		System.out.println("Actual Text: "+actualText);
		String expectedText = InstructionalTextforGandA.getText().trim();
		String expectedtext1=expectedText.replaceAll("\n","");
		System.out.println("Expected Text: "+expectedtext1);
		return utils.isvalueMatch_contain(actualText, expectedtext1);
	}
	



	@FindBy(xpath="//div[@class='smarttip-content']")
	private WebElement HoverTextforClaimType;

	public boolean verifyActionCodeHoverText(String[] arg) throws Exception
	{
		this.clickClaimDetailsLink();
		action.moveToElement(labelActionCode).click().build().perform();
		System.out.println(HoverTextforClaimType.getText());
		String expectedMsg = HoverTextforClaimType.getText();
		String actualMsg = arg[0];
		return utils.isvalueMatch_contain(actualMsg, expectedMsg);
	}

	@FindBy(xpath="//div[contains(text(),'Rejection Reason:')]")
	private WebElement ActionCodeIntheDialogContent;

	public boolean verifyActionCodeIntheDialogContent(String[] arg) throws Exception
	{						
		return utils.validateValueinelement(this.ActionCodeIntheDialogContent, arg[0]);				
	}


	@FindBy(xpath="//table[@pl_prop='D_ProviderClaimPaymentResults.pxResults']")
	private WebElement MemberPaymentAmountTable;

	public boolean verifyMemberPaymentAmountTable(String[] arg) throws Exception
	{			
		this.clickPaymentDetailsLink();
		return utils.validatetablerowbasedonvalues(this.MemberPaymentAmountTable, arg);			
	}



	//Sprint 4.3

	@FindBy(xpath="Claims Research")
	WebElement lnkClaimsSearch;

	@FindBy(xpath="//textarea[@id='pyNote']")
	WebElement labelNotesPrePopulatedValue;

	@FindBy(xpath="//div[@node_name='CPMDisplaySuggestedTask']")
	WebElement lnkManageOtherInsuranceInSuggestedTask;

	public boolean verifyAndClickClaimsResearchFromOtherActions(String[] args)
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, args[0], "ViewClaimDetails", "Claims Research");
	}

	public boolean verifyClaimsResearchValueIsNotDisplayedInOtherActions()
	{

		if(utils.clickAnelemnt(drpDownOtherActions, "ViewClaimDetails", "Other Octions"))
			return utils.isProxyWebelement(lnkClaimsSearch);
		return false;
	}

	public boolean validateTheNotesFieldIsPrefilledFromClaimsResearch(String[] args)
	{
		try {
			boolean returnvar ;
			returnvar = true;
			int count = 0;
			for(int i=0;i<args.length;i++) 
			{
				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check Either Your input is wrong or the value found on application is incorrect");
					return false;

				}

				String key = args[i].substring(0, args[i].indexOf(":")).toLowerCase();
				String value = args[i].substring(args[i].indexOf(":")+1);
				returnvar = false;
				if(utils.isvalueMatch_compareto(key,"Notes")) {
					returnvar = utils.isvalueMatch_compareto(labelNotesPrePopulatedValue.getText().replaceAll(",", ""),value);
					count++;
					break;
				}
			}

			if(returnvar && count==args.length){
				blogger.loginfo("PASS: Values are prepopulated");
				return true;	
			}else{
				blogger.loginfo("ViewClaimDetails", "FAIL: Values are not prepopulated");
				return false;
			}
		}catch(Exception e) {
			err.logError("ViewClaimDetails"+e);
			return false;
		}

	}

	public boolean verifyManageOtherInsuranceUnderSuggestedTasks()
	{
		return !utils.isProxyWebelement(lnkManageOtherInsuranceInSuggestedTask);
	}


	@FindBy(xpath="//table[@id='gridLayoutTable']")
	WebElement RFPopUp;

	@FindBy(xpath="//a[text()='RF']")
	WebElement RFLink;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateRFPopup
	 * #Description:This method validate the field label along with values populated in RF pop up.
	 * Type:Textbox
	 */
	public boolean validateRFPopup(String[] RFdetails) throws InterruptedException
	{
		WebElement element = RFLink;
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", element);
		boolean flag = false;
		Thread.sleep(4000);
		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		System.out.println("parentWindowHandler"+parentWindowHandler);
		String subWindowHandler = null;
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("Number"+handles.size());
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
			System.out.println("subWindowHandler"+subWindowHandler);
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		Thread.sleep(2000);
		utils.validatetablerowbasedonvalues(RFPopUp, RFdetails);
		flag = true;
		Driver.pgDriver.close();
		Driver.pgDriver.switchTo().window(parentWindowHandler);	
		return flag;		
	}


	//Sprint 5.3

	@FindBy(xpath="//input[@id='TagRefund_rdi_1']")
	WebElement RefundRequestChkBox;


	public boolean checkClaimRequiresRefundCheckbox() 
	{
		return utils.clickAnelemnt(RefundRequestChkBox, "ViewClaimDetails", "Claim Has Refund request Check Box");

	}

	/**This method validates whether view claim details page is displayed when we click submit on Assosiate empowerment guided line notification screen
	 * 
	 * @return
	 */
	public boolean validatewhetherViewClaimDetailsPageIsDisplayed() {
		return utils.validateHeader(sHeader, "View Claim Details");
	}



	//Sprint 6.4

	@FindBy(xpath="//span[contains(text(),'Previous Claim Adjustment cases created')]")
	WebElement clickPreviousClaimAdjustment;

	/**This method clicks and expands the previous adjustment cases section
	 * 
	 * @return
	 */
	public boolean clickPreviousClaimAdjustmentCasesSection()
	{
		return utils.clickAnelemnt(clickPreviousClaimAdjustment, "ViewClaimDetails", "Expand Previous Claim Adjustment");

	}

	@FindBy(xpath="//table[@pl_prop='D_AdjustmentsByClaimID.pxResults']")
	WebElement validatePreviousClaimAdjustmentHeader;

	/**This method validates the previous adjustment cases table header
	 * 
	 * @return
	 */
	public boolean validatePreviousClaimAdjustmentCasesTableHeader()
	{

		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(validatePreviousClaimAdjustmentHeader);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("SR ID");
		valuesGivenManual.add("Reason for Adjustment");
		valuesGivenManual.add("Selected Next Action");
		valuesGivenManual.add("Status");
		valuesGivenManual.add("Case Created Date");
		valuesGivenManual.add("Case Resolved On");
		valuesGivenManual.add("Member Name");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Values in the previous adjustment cases table is matched with the values expected");

			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Values in the previous adjustment cases table is not matched with the values expected");
			return false;
		}

	}

	/** This method validates the table values according to the input given by the user
	 * 
	 * @param args
	 * @return
	 */

	public boolean validatePreviousClaimAdjustmentCasesTableValues(String[] args)
	{
		return utils.validatetablerowbasedonvalues(validatePreviousClaimAdjustmentHeader,args);

	}

	/** This method validates and clicks the SR ID according to the input given by the user
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean clickAndValidatePreviousClaimAdjustmentCasesTableValues(String[] args) throws InterruptedException
	{
		WebElement row = utils.getProviderResultsBasedOnValues(validatePreviousClaimAdjustmentHeader,args);
		List<WebElement> expand = row.findElements(By.tagName("a"));
		expand.get(0).click();
		return true;

	}

	@FindBy(xpath="//label[text()='Authorization Number']/../../..//img[@class='pzbtn-img pzbtn-extimg']")
	WebElement AuthorizationRoboButton;

	@FindBy(xpath="//div[text()='Close']")
	WebElement ManageAuthPopUpCloseButton;

	@FindBy(xpath="//span[@data-test-id='20170511195819004220949']")
	WebElement ManageAuthPopUpAuthNumber;

	static Map<String,String> map = new HashMap<String, String>();

	/**Click on the Authorization Number Robo button, validate the pop up and click on close button
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean clickOnAuthorizationRoboButtonValidatePopUpAndClose() throws IOException {
		action.moveToElement(AuthorizationRoboButton);
		if(utils.clickAnelemnt(AuthorizationRoboButton, "ViewClaimDetails", "AuthorizationRoboButton")) {
			utils.waitforpageload();
			String parentWindowHandler = Driver.pgDriver.getWindowHandle();
			String subWindowHandler = null;
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("Number"+handles.size());
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
				subWindowHandler = iterator.next();
				System.out.println("subWindowHandler"+subWindowHandler);
			}
			Driver.pgDriver.switchTo().window(subWindowHandler);
			utils.waitforpageload();
			utils.takescreenshot("AuthorizationRoboButton Pop Up");
			utils.waitforpageload();
			if(utils.clickAnelemnt(ManageAuthPopUpCloseButton, "ViewClaimDetails", "ManageAuthPopUpCloseButton")) {
				Driver.pgDriver.switchTo().window(parentWindowHandler);
				return true;
			}
			return false;
		}
		return false;
	}

	@FindBy(xpath="//a[@data-test-id='201810021537400735242471']")
	WebElement ManageAuthPopUpLaunchManageAuthButton;

	/**Click on the Authorization Number Robo button, validate the pop up, Click on the Launch Manage Authorization link and click on close button
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean clickOnAuthRoboBtnValidatePopUpClickOnManageAuthAndClose() throws IOException {
		action.moveToElement(AuthorizationRoboButton);
		if(utils.clickAnelemnt(AuthorizationRoboButton, "ViewClaimDetails", "AuthorizationRoboButton")) {
			utils.waitforpageload();
			String parentWindowHandler = Driver.pgDriver.getWindowHandle();
			String subWindowHandler = null;
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("Number"+handles.size());
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
				subWindowHandler = iterator.next();
				System.out.println("subWindowHandler"+subWindowHandler);
			}
			Driver.pgDriver.switchTo().window(subWindowHandler);
			utils.waitForElementToBeVisible(ManageAuthPopUpCloseButton);
			utils.takescreenshot("AuthorizationRoboButton Pop Up");
			if(utils.clickAnelemnt(ManageAuthPopUpLaunchManageAuthButton, "ViewClaimDetails", "ManageAuthPopUpLaunchManageAuthButton")) {
				utils.waitForElementToBeClickabale(ManageAuthPopUpCloseButton);
				if(utils.clickAnelemnt(ManageAuthPopUpCloseButton, "ViewClaimDetails", "ManageAuthPopUpCloseButton")) {
					Driver.pgDriver.switchTo().window(parentWindowHandler);
					return true;
				}
			}
			return false;
		}
		return false;
	}

	@FindBy(xpath="//div[text()='Attach to Claim']")
	WebElement ManageAuthPopUpAttachToClaim;

	/**Click on the Authorization Number Robo button, validate the pop up and click on close button
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean clickOnAuthRoboBtnValidatePopUpClickAttachToClaim() throws IOException {
		action.moveToElement(AuthorizationRoboButton);
		if(utils.clickAnelemnt(AuthorizationRoboButton, "ViewClaimDetails", "AuthorizationRoboButton")) {
			utils.waitforpageload();
			String parentWindowHandler = Driver.pgDriver.getWindowHandle();
			String subWindowHandler = null;
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("Number"+handles.size());
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
				subWindowHandler = iterator.next();
				System.out.println("subWindowHandler"+subWindowHandler);
			}
			Driver.pgDriver.switchTo().window(subWindowHandler);
			utils.waitForElementToBeVisible(ManageAuthPopUpCloseButton);
			utils.takescreenshot("AuthorizationRoboButton Pop Up");
			map.put("Authorization Number", ManageAuthPopUpAuthNumber.getText());
			if(utils.clickAnelemnt(ManageAuthPopUpAttachToClaim, "ViewClaimDetails", "ManageAuthPopUpCloseButton")) {
				Driver.pgDriver.switchTo().window(parentWindowHandler);
				return true;
			}
			return false;
		}
		return false;
	}

	@FindBy(xpath="//*[contains(@id,'CheckReviewForContact')]")
	List<WebElement> ManageAuthPopUpCheckbox;

	@FindBy(xpath="//a[@data-test-id='201705092338250213198772']")
	List<WebElement> ManageAuthPopUpAuthorizationNumber;


	/**Click on the Authorization Number Robo button, validate the pop up and click on close button
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean clickOnAuthRoboBtnValidatePopUpSelectAuthClickAttachToClaim() throws IOException {
		action.moveToElement(AuthorizationRoboButton);
		if(utils.clickAnelemnt(AuthorizationRoboButton, "ViewClaimDetails", "AuthorizationRoboButton")) {
			utils.waitforpageload();
			String parentWindowHandler = Driver.pgDriver.getWindowHandle();
			String subWindowHandler = null;
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("Number"+handles.size());
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
				subWindowHandler = iterator.next();
				System.out.println("subWindowHandler"+subWindowHandler);
			}
			Driver.pgDriver.switchTo().window(subWindowHandler);
			utils.waitForElementToBeVisible(ManageAuthPopUpCloseButton);
			utils.takescreenshot("AuthorizationRoboButton Pop Up");
			map.put("Authorization Number", ManageAuthPopUpAuthorizationNumber.get(0).getText());
			if(utils.clickAnelemnt(ManageAuthPopUpCheckbox.get(0), "ViewClaimDetails", "ManageAuthPopUpCloseButton")) {
				if(utils.clickAnelemnt(ManageAuthPopUpAttachToClaim, "ViewClaimDetails", "ManageAuthPopUpCloseButton")) {
					Driver.pgDriver.switchTo().window(parentWindowHandler);
					return true;
				}
			}
			return false;
		}
		return false;
	}

	@FindBy(xpath="//a[text()='Snapshot']")
	List<WebElement> ManageAuthPopUpSnapshot;

	@FindBy(xpath="//*[@id='modaldialog_hd']/ancestor::table")
	WebElement ManageAuthPopUpSnapshotPopUp;

	@FindBy(xpath="//*[@id='modaldialog_hd']/ancestor::div[@id='modalContent']//button[@id='ModalButtonSubmit']")
	WebElement ManageAuthPopUpSubmitButton;

	/**Click on the Authorization Number Robo button, validate the pop up, Click on the Launch Manage Authorization link and click on close button
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean clickOnAuthRoboBtnValidatePopUpSnapshotAndClose() throws IOException {
		action.moveToElement(AuthorizationRoboButton);
		if(utils.clickAnelemnt(AuthorizationRoboButton, "ViewClaimDetails", "AuthorizationRoboButton")) {
			utils.waitforpageload();
			String parentWindowHandler = Driver.pgDriver.getWindowHandle();
			String subWindowHandler = null;
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("Number"+handles.size());
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
				subWindowHandler = iterator.next();
				System.out.println("subWindowHandler"+subWindowHandler);
			}
			Driver.pgDriver.switchTo().window(subWindowHandler);
			utils.waitForElementToBeVisible(ManageAuthPopUpCloseButton);
			utils.takescreenshot("AuthorizationRoboButton Pop Up");
			utils.waitForElementToBeClickabale(ManageAuthPopUpCloseButton);
			if(utils.clickAnelemnt(ManageAuthPopUpSnapshot.get(0), "ViewClaimDetails", "ManageAuthPopUpSnapshot")) {
				if(!utils.isProxyWebelement(ManageAuthPopUpSnapshotPopUp)) {
					utils.takescreenshot("AuthorizationRoboButton Pop Up - ManageAuthPopUpSnapshotPopUp");
					if(utils.clickAnelemnt(ManageAuthPopUpSubmitButton, "ViewClaimDetails", "ManageAuthPopUpSubmitButton"))
						if(utils.clickAnelemnt(ManageAuthPopUpCloseButton, "ViewClaimDetails", "ManageAuthPopUpCloseButton")) {
							Driver.pgDriver.switchTo().window(parentWindowHandler);
							return true;
						}
				}
			}
			return false;
		}
		return false;
	}
	
	
	
	@FindBy(xpath="//button[@data-test-id='201805221255340820139487']")
	WebElement btnBenefitsReview;
	
	@FindBy(xpath="//span[text()='Benefits Review']")
	WebElement labelHeaderBenefitsReview;
	
	
	public boolean clickOnBenefitsReviewButonAndValidateTheDetails() throws InterruptedException
	{
		utils.waitforpageload();
		Thread.sleep(3000);
		//String parent = Driver.pgDriver.getWindowHandle();
//		WebElement row = utils.returntablerowbasedonvalues(tblLineDetails, args);
//		List<WebElement> rowNo = row.findElements(By.tagName("input"));
//		rowNo.get(3).click();
//		if(utils.clickAnelemnt(btnBenefitsReview,"ManageClaims","Compare Claims"))
//		{
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+handles.size());
			Iterator<String> iterator= handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow);
			String title = Driver.pgDriver.getTitle();
			System.out.println("Title of the Child Window is: "+title);
			Thread.sleep(5000);
			if(title.contains("Benefits Review"))
			{
				if(!utils.isProxyWebelement(labelHeaderBenefitsReview))
					if(utils.validateLabel(labelHeaderBenefitsReview, "Benefits Review"))
									return true;
			}
			else
			{
				return false;
			}
//		}
//		return false;
			return false;
	}
	
	public boolean clickOnBenefitsReview(String[] args) throws InterruptedException
	{
		utils.scrolltomiddle();
		Thread.sleep(3000);
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblLineDetails, args);
			List<WebElement> rowNo = row.findElements(By.tagName("td"));
			rowNo.get(14).click();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@FindBy(xpath="//font[text()='ITS Specific Details']")
	WebElement ITSspecificdetails;
	
	
	public boolean expandITSclaimsdetails()
	{
		return utils.clickAnelemnt(ITSspecificdetails, "ViewClaimDetails", "Expand ITS specific details");
	}
	
	@FindBy(xpath="//a[text()='SF']")
	WebElement SFHyperlink;
	
	public boolean clickSFLink() {
		return utils.clickAnelemnt(SFHyperlink, "ViewClaimDetails", "SF Hyperlink");
	}
	
	@FindBy(xpath="//label[text()='SFMC']//following::span[@data-test-id='2018072423380502061706583']")
	WebElement SFMCLabel;
	
	public boolean validateSFMCLabel(String[] args){
		boolean flag = false;
		utils.waitforpageload();
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				System.out.println("No.ofwindows"+handles.size());
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				Driver.pgDriver.switchTo().window(childWindow);
				String title = Driver.pgDriver.getTitle();
				System.out.println("Title of the Child Window is: "+title);
				if(title.contains("SF Details - Google chrome")){
					System.out.println("Window switched");
					if(utils.validateLabel(SFMCLabel, "1059"))
						
				return true;		
								
					return false;
				}
				Driver.pgDriver.switchTo().window(parentWindow);
				return flag;
			
		}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	
	/**
	 * This method will allow user to navigate Grievance and appeals task through other action from view claim detail page
	 * @return
	 */
	public boolean navigatetoRequestGrievanceAndAppeals()
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Grievance and App...", "ManageClaimReview", "Request Medical Review");
	}

	
	@FindBy(xpath="//table[@id='ERRORTABLE']//ul[@class='pageErrorList layout-noheader-errors']")
	WebElement ErrorMessageforNotLaunchGandA;
	
	

	/**
	 * This Method will validate the error message displayed when user click submit button without launching G &A from claim detail page for CA member whose company code is 200C
	 * @param args
	 * @return
	 */
	public boolean validateErrorMessageForNotLaunchGandA(String[] args)
	{
		String ActualMessage = args[0];
		String ExpectedMessage =ErrorMessageforNotLaunchGandA.getText();
		System.out.println(ExpectedMessage);
		return utils.isvalueMatch_contain(ActualMessage, ExpectedMessage);
		
	}
	
	@FindBy(xpath="//a[@data-test-id='2016040812564009881146'][contains(text(),'Manage Claims')]")
	WebElement ManageClaims;
	
	public boolean navigateToManageClaimSR(){
		utils.clickAnelemnt(ManageClaims, "Member composite", "ManageClaims");
		utils.waitforpageload();
		return true;
		
	}
	
	public boolean clickOnSubmitAfterGandA() throws InterruptedException{
		Thread.sleep(3000);
		utils.scrolltomiddle();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement);
		return utils.clickAnelemnt(this.btnSubmit,"ViewClaimDetails","Submit Button");
	}

}
