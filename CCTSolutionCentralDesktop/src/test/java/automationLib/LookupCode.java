package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class LookupCode extends Driver {

	public LookupCode() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}
	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	Home home=new Home();

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	@FindBy(id="SearchStringApplicableKeys")
	WebElement drpdwnlookUpCodeType;
	@FindBy(id="CodeSearch")
	WebElement txtbxlookUpCode;

	@FindBy(xpath="//*[@data-test-id='201603092353240840457435']")
	WebElement labelLookUpCodeAgeRange;

	@FindBy(xpath="//*[@data-test-id='201603092353240855461281']")
	WebElement labelLookUpCodeValidGender;

	@FindBy(xpath="//*[@data-test-id='201603092353240850459799']")
	WebElement labelLookUpCodeAssistantSurgeon;

	@FindBy(xpath="//*[@data-test-id='201603092353240853460654']")
	WebElement labelLookUpCodeCo_Surgeon;

	@FindBy(xpath="//*[contains(@class , 'content-item content-field item-7')]//*[@data-test-id='201603092353240840457435']")
	WebElement labelLookUpCodeDiagnosisICDAgeRange;

	@FindBy(xpath="//*[@data-test-id='201603092353240855461281']")
	WebElement labelLookUpCodeDiagnosisICDValidGender;

	@FindBy(xpath="//*[contains(@class , 'content-item content-field item-9')]//*[@data-test-id='201603092353240815451407']")
	WebElement labelLookUpCodeDiagnosisICDVersion;

	@FindBy(xpath="//*[@data-test-id='201603092353240840457435']")
	WebElement labelLookUpCodeICDAgeRange;

	@FindBy(xpath="//*[@data-test-id='201603092353240855461281']")
	WebElement labelLookUpCodeICDValidGender;

	@FindBy(xpath="//*[contains(@class , 'content-item content-field item-9')]//*[@data-test-id='201603092353240815451407']")
	WebElement labelLookUpCodeICDICDVersion;

	@FindBy(xpath="//*[contains(@class , 'content-item content-field item-1')]//*[@data-test-id='201603092353240817452490']")
	WebElement labelLookUpCodeICDCorporatePolicyLengthofStay;

	@FindBy(xpath="//*[@for='CodeorNameCode']")
	WebElement radioLookUpCodeCode;

	@FindBy(xpath="//div[@node_name='MasterDrugNDCCodeName']//div[@title='Disclose Product / Manufacturer Data']")
	WebElement arrowlnkLookUpCodeProductManufacture;

	@FindBy(xpath="//div[@node_name='MasterDrugNDCCodeName']//div[@title='Disclose Generic Data']")
	WebElement arrowlnkLookUpCodeGenericdata;

	@FindBy(xpath="//div[@node_name='MasterDrugNDCCodeName']//div[@title='Disclose Packaging Data']")
	WebElement arrowlnkLookUpCodePackagingdata;

	@FindBy(xpath="//div[@node_name='MasterDrugNDCCodeName']//div[@section_index='2'][@id='EXPAND-INNERDIV']//label[@for='ID']/parent::div/div//span")
	WebElement labelLookUpCodeProductName;

	@FindBy(xpath="//*[@data-test-id='201603231354460514100290']")
	WebElement labelLookUpCodeManufacturer;

	@FindBy(xpath="//*[@data-test-id='2016041515005308221015236']")
	WebElement labelLookUpCode2ndLastUpdatedDate;

	@FindBy(xpath="//*[@data-test-id='201603231354460524109212']")
	WebElement labelLookUpCodeGenericProductID;

	@FindBy(xpath="//*[@data-test-id='20160323135446051399262']")
	WebElement labelLookUpCodeGenericName;

	@FindBy(xpath="//*[@data-test-id='2016041515005308271023808']")
	WebElement labelLookUpCode3rdLastUpdatedDate;

	@FindBy(xpath="//*[@data-test-id='20160415082109050124265']")
	WebElement labelLookUpCodePackageSize;

	@FindBy(xpath="//*[contains(@class , 'content-item content-field item-2')]//*[@data-test-id='201604150821090504243781']")
	WebElement labelLookUpCodePackageQuantity;

	@FindBy(xpath="//*[contains(@class , 'content-item content-field item-3')]//*[@data-test-id='201604150821090504243781']")
	WebElement labelLookUpCodeTotalPackageQuantity;


	@FindBy(xpath="//*[@data-test-id='201604151508460846619376']")
	WebElement labelLookUpCodeMedicineDescription;

	@FindBy(xpath="//*[@data-test-id='201604150821090508245369']")
	WebElement labelLookUpCodeDosageForm;

	@FindBy(xpath="//*[@data-test-id='201604150821090510246140']")
	WebElement labelLookUpCode4thLastUpdatedDate;

	@FindBy(xpath="//div[@node_name='HCPCSModifierData']//label[@for='Description']/parent::div//span")
	WebElement labelLookUpCodeProcedureModifierDescription;

	@FindBy(xpath="//div[@node_name='HCPCSModifierData']//label[@for='LastUpdatedDate']/parent::div//span")
	WebElement labelLookUpCodeProcedureModifierEffectiveDate;

	@FindBy(xpath="//div[@node_name='HCPCSModifierData']//label[@for='EndDate']/parent::div//span")
	WebElement labelLookUpCodeProcedureModifierEnddate;

	@FindBy(xpath="//div[@node_name='DisplayUB92RevenueCode']//label[@for='AgeRange']/parent::div//span")
	WebElement labelLookUpCodefacilityBasedAge;

	@FindBy(xpath="//div[@node_name='DisplayUB92RevenueCode']//label[@for='ValidSex']/parent::div//span")
	WebElement labelLookUpCodeFacilityBasedGender;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Search']")
	WebElement btnLookUpcodeSearch;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Close']")
	WebElement btnClosebtn;

	@FindBy(xpath="//*[@node_name='SearchResults']")
	WebElement errormessage;

	@FindBy(xpath="//div[@node_name='HCPCSModifierData']//div//span[starts-with(text(),'  ')]")
	WebElement sectionProcedureModifierCode;

	@FindBy(xpath="//div[@node_name='HCPCSProcedureDetails']//div//span[starts-with(text(),'  ')]")
	WebElement sectionProcedureCode_diagnosisCode;

	@FindBy(xpath="//div[@node_name='DisplayICDDetails']//div//span[starts-with(text(),'  ')]")
	WebElement sectionICDProcedureCode;
	@FindBy(xpath="//div[@node_name='ICDDiagnosisResults']//div//span[starts-with(text(),'  ')]")
	WebElement sectiondiagnosisCodeICD;

	@FindBy(xpath="//div[@node_name='MasterDrugNDCCode']//div//span[starts-with(text(),'  ')]")
	WebElement sectionNationalDrugCode;
	@FindBy(xpath="//div[@node_name='DisplayUB92RevenueCode']//div//span[starts-with(text(),'  ')]")
	WebElement sectionFacilityBased;

	@FindBy(xpath="//*[contains(text(),'Unable to retrieve data')]")
	WebElement UnableToRetrieveData;

	public boolean validateProcedureCode_DiagnosisCode(String[] code) throws InterruptedException
	{
		String value=code[0];
		if(code[0].contains(":"))
			value = code[0].substring(code[0].indexOf(":")+1).toUpperCase();
		if(utils.selectDropDownbyVisibleString(this.drpdwnlookUpCodeType, "Procedure Code (HCPCS) / Diagnosis Code (ICD-10)", "LookUpCode", "Code Type Dropdown"))
			if(utils.enterTextinAnelemnt(this.txtbxlookUpCode, value, "LookUpCode", "Code text"))
				if(utils.clickAnelemnt(this.btnLookUpcodeSearch,"Lookup Code","Search button"))
				{
					utils.waitforpageload();
					/*if(!utils.isProxyWebelement(UnableToRetrieveData)) 
						utils.isServiceDown();*/
					if(!this.labelLookUpCodeAgeRange.getText().contains("   ")) {
						if(!this.labelLookUpCodeAssistantSurgeon.getText().contains("   "))
							if(!this.labelLookUpCodeCo_Surgeon.getText().contains("   "))
								if(!this.labelLookUpCodeValidGender.getText().contains("   "))
									return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
					}else if(!utils.isProxyWebelement(UnableToRetrieveData)) 
						utils.isServiceDown();


					/*Assert.assertEquals(true, !(this.labelLookUpCodeAgeRange.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCodeAssistantSurgeon.getText().contains("   ")));
				Assert.assertEquals(true, !this.labelLookUpCodeCo_Surgeon.getText().contains("   "));
				Assert.assertEquals(true, !this.labelLookUpCodeValidGender.getText().contains("   "));*/
					/*try{
					wait=new WebDriverWait(Driver.pgDriver,2);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='HCPCSProcedureDetails']//div//span[starts-with(text(),'  ')]")));
					err.logcommonMethodError("LookUpCode", "Empty Space is present ");
					return false;
				}
				catch(Exception e)
				{
					return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
				}*/
				}
		return false;	
	}

	public boolean validateDiagnosisCode_ICD9(String[] code)
	{
		String value=code[0];
		if(code[0].contains(":"))
			value = code[0].substring(code[0].indexOf(":")+1).toUpperCase();

		if(utils.selectDropDownbyVisibleString(this.drpdwnlookUpCodeType, "Diagnosis Code (ICD-9)", "LookUpCode", "Code Type Dropdown"))
			if(utils.enterTextinAnelemnt(this.txtbxlookUpCode, value, "LookUpCode", "Code text"))
				if(utils.clickAnelemnt(this.btnLookUpcodeSearch,"Lookup Code","Search button"))
				{
					utils.waitforpageload();
					if(!(this.labelLookUpCodeDiagnosisICDAgeRange.getText().contains("   ")))
						if(!(this.labelLookUpCodeDiagnosisICDValidGender.getText().contains("   ")))
							if(!this.labelLookUpCodeDiagnosisICDVersion.getText().contains("   "))
								return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
				}

		/*	
				Assert.assertEquals(true, !(this.labelLookUpCodeDiagnosisICDAgeRange.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCodeDiagnosisICDValidGender.getText().contains("   ")));
				Assert.assertEquals(true, !this.labelLookUpCodeDiagnosisICDVersion.getText().contains("   "));

				try{
					wait=new WebDriverWait(Driver.pgDriver,2);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='ICDDiagnosisResults']//div//span[starts-with(text(),'  ')]")));
					err.logcommonMethodError("LookUpCode", "Empty Space is present ");
					return false;
				}
				catch(Exception e)
				{
					return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
				}
			}
			else*/
		return false;
	}	

	public boolean validateICD_ProcedureCode(String[] code)
	{
		String value=code[0];
		if(code[0].contains(":"))
			value = code[0].substring(code[0].indexOf(":")+1).toUpperCase();

		if(utils.selectDropDownbyVisibleString(this.drpdwnlookUpCodeType, "ICD - Procedure Code (ICD-PCS)", "LookUpCode", "Code Type Dropdown"))
			if(utils.enterTextinAnelemnt(this.txtbxlookUpCode, value, "LookUpCode", "Code text"))
				if(utils.clickAnelemnt(this.btnLookUpcodeSearch,"Lookup Code","Search button"))
				{
					utils.waitforpageload();
					if(!(this.labelLookUpCodeICDAgeRange.getText().contains("   "))) {
						if( !(this.labelLookUpCodeICDValidGender.getText().contains("   ")))
							if(!this.labelLookUpCodeICDICDVersion.getText().contains("   "))
								if(!this.labelLookUpCodeICDCorporatePolicyLengthofStay.getText().contains("   "))
									return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
					}else if(!utils.isProxyWebelement(UnableToRetrieveData))
						utils.isServiceDown();
				}	



		/*
				wait=new WebDriverWait(Driver.pgDriver,5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test-id='201603092353240840457435']")));
				Assert.assertEquals(true, !(this.labelLookUpCodeICDAgeRange.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCodeICDValidGender.getText().contains("   ")));
				Assert.assertEquals(true, !this.labelLookUpCodeICDICDVersion.getText().contains("   "));
				Assert.assertEquals(true, !this.labelLookUpCodeICDCorporatePolicyLengthofStay.getText().contains("   "));

				try{
					wait=new WebDriverWait(Driver.pgDriver,2);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='DisplayICDDetails']//div//span[starts-with(text(),'  ')]")));
					err.logcommonMethodError("LookUpCode", "Empty Space is present ");
					return false;
				}
				catch(Exception e)
				{
					return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
				}
			}
			else*/
		return false;
	}

	public boolean validateNationalDrugCode(String[] code)
	{
		String value=code[0];
		if(code[0].contains(":"))
			value = code[0].substring(code[0].indexOf(":")+1).toUpperCase();
		if(utils.selectDropDownbyVisibleString(this.drpdwnlookUpCodeType, "National Drug Code / Name (NDC)", "LookUpCode", "Code Type Dropdown"))

			if(utils.clickAnelemnt(this.radioLookUpCodeCode,  "LookUpCode", "Code radiobutton"))
				if(utils.enterTextinAnelemnt(this.txtbxlookUpCode, value, "LookUpCode", "Code text"))
					if(utils.clickAnelemnt(this.btnLookUpcodeSearch,"Lookup Code","Search button"))
					{

						if(utils.clickAnelemnt(this.arrowlnkLookUpCodeProductManufacture,"LookUpCode","Disclose product manufacture")) {
							if(utils.clickAnelemnt(this.arrowlnkLookUpCodePackagingdata,"LookUpCode","Disclose Packaging data"))
								if(utils.clickAnelemnt(this.arrowlnkLookUpCodeGenericdata,"LookUpCode","Disclose Generic data"))
									if(!(this.labelLookUpCode2ndLastUpdatedDate.getText().contains("   ")))
										if(!(this.labelLookUpCode3rdLastUpdatedDate.getText().contains("   ")))
											if(!this.labelLookUpCode4thLastUpdatedDate.getText().contains("   "))
												if(!this.labelLookUpCodeDosageForm.getText().contains("   "))
													if(!(this.labelLookUpCodePackageQuantity.getText().contains("   ")))
														if(!(this.labelLookUpCodeGenericName.getText().contains("   ")))
															if(!this.labelLookUpCodeGenericProductID.getText().contains("   "))
																if(!this.labelLookUpCodeManufacturer.getText().contains("   "))
																	if(!(this.labelLookUpCodeMedicineDescription.getText().contains("   ")))
																		if(!(this.labelLookUpCodePackageSize.getText().contains("   ")))
																			if(!(this.labelLookUpCodeTotalPackageQuantity.getText().contains("   ")))
																				return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
						}else if(!utils.isProxyWebelement(UnableToRetrieveData))
							utils.isServiceDown();

					}

		/*wait=new WebDriverWait(Driver.pgDriver,5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='MasterDrugNDCCodeName']//div[@title='Disclose Product / Manufacturer Data']")));
				utils.clickAnelemnt(this.arrowlnkLookUpCodeProductManufacture,"LookUpCode","Disclose product manufacture");
				utils.clickAnelemnt(this.arrowlnkLookUpCodePackagingdata,"LookUpCode","Disclose Packaging data");
				utils.clickAnelemnt(this.arrowlnkLookUpCodeGenericdata,"LookUpCode","Disclose Generic data");
				Assert.assertEquals(true, !(this.labelLookUpCode2ndLastUpdatedDate.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCode3rdLastUpdatedDate.getText().contains("   ")));
				Assert.assertEquals(true, !this.labelLookUpCode4thLastUpdatedDate.getText().contains("   "));
				Assert.assertEquals(true, !this.labelLookUpCodeDosageForm.getText().contains("   "));
				Assert.assertEquals(true, !(this.labelLookUpCodePackageQuantity.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCodeGenericName.getText().contains("   ")));
				Assert.assertEquals(true, !this.labelLookUpCodeGenericProductID.getText().contains("   "));
				Assert.assertEquals(true, !this.labelLookUpCodeManufacturer.getText().contains("   "));
				Assert.assertEquals(true, !(this.labelLookUpCodeMedicineDescription.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCodePackageSize.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCodeTotalPackageQuantity.getText().contains("   ")));


				try{
					wait=new WebDriverWait(Driver.pgDriver,2);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='MasterDrugNDCCodeName']//div//span[starts-with(text(),'  ')]")));
					err.logcommonMethodError("LookUpCode", "Empty Space is present ");
					return false;
				}
				catch(Exception e)
				{
					return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");

				}
			}*/
		//else
		return false;
	}

	public boolean validateProcedureModifierCode(String[] code)
	{
		String value=code[0];
		if(code[0].contains(":"))
			value = code[0].substring(code[0].indexOf(":")+1).toUpperCase();

		if(utils.selectDropDownbyVisibleString(this.drpdwnlookUpCodeType, "Procedure Modifier Code", "LookUpCode", "Code Type Dropdown"))
			if(utils.enterTextinAnelemnt(this.txtbxlookUpCode, value, "LookUpCode", "Code text"))
				if(utils.clickAnelemnt(this.btnLookUpcodeSearch,"Lookup Code","Search button"))
				{

					if(!(this.labelLookUpCodeProcedureModifierDescription.getText().contains("   ")))
						if(!(this.labelLookUpCodeProcedureModifierEffectiveDate.getText().contains("   ")))
							if(!this.labelLookUpCodeProcedureModifierEnddate.getText().contains("   "))
								return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
				}
		/*wait=new WebDriverWait(Driver.pgDriver,5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test-id='2016032314064707631177784']")));
				System.out.println("dd"+ this.labelLookUpCodeProcedureModifierDescription.getText()+"end");
				Assert.assertEquals(true, !(this.labelLookUpCodeProcedureModifierDescription.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCodeProcedureModifierEffectiveDate.getText().contains("   ")));
				Assert.assertEquals(true, !this.labelLookUpCodeProcedureModifierEnddate.getText().contains("   "));

				try{
					wait=new WebDriverWait(Driver.pgDriver,2);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='HCPCSModifierData']//div//span[starts-with(text(),'  ')]")));
					err.logcommonMethodError("LookUpCode", "Empty Space is present ");
					return false;
				}
				catch(Exception e)
				{
					return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
				}
			}
			else*/
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateFacilityBasedRevenue
	 * #Arguments:Code
	 * Type:Textbox
	 */
	public boolean validateFacilityBasedRevenue(String[] code)
	{
		String value=code[0];
		if(code[0].contains(":"))
			value = code[0].substring(code[0].indexOf(":")+1).toUpperCase();

		if(utils.selectDropDownbyVisibleString(this.drpdwnlookUpCodeType, "Facility Based Revenue Code", "LookUpCode", "Code Type Dropdown"))
			if(utils.enterTextinAnelemnt(this.txtbxlookUpCode, value, "LookUpCode", "Code text"))
				if(utils.clickAnelemnt(this.btnLookUpcodeSearch,"Lookup Code","Search button"))
				{
					if(!(this.labelLookUpCodefacilityBasedAge.getText().contains("   ")))
						if(!(this.labelLookUpCodeFacilityBasedGender.getText().contains("   ")))
							return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
				}

		/*wait=new WebDriverWait(Driver.pgDriver,5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test-id='2016032314064707631177784']")));
				System.out.println("dd"+ this.labelLookUpCodefacilityBasedAge.getText()+"end");
				Assert.assertEquals(true, !(this.labelLookUpCodefacilityBasedAge.getText().contains("   ")));
				Assert.assertEquals(true, !(this.labelLookUpCodeFacilityBasedGender.getText().contains("   ")));


				try{
					wait=new WebDriverWait(Driver.pgDriver,2);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='DisplayUB92RevenueCode']//div//span[starts-with(text(),'  ')]")));
					err.logcommonMethodError("LookUpCode ", "Empty Space is present ");
					return false;
				}
				catch(Exception e)
				{
					return utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button");
				}
			}
			else*/
		return false;
		//}

	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateErrorMessage
	 * Type:Textbox
	 */
	public boolean validateErrorMessage() throws InterruptedException
	{
		if(utils.selectDropDownbyIndex(this.drpdwnlookUpCodeType, 2, "LookUpCode", "CodeType-dropDown"))
			if(utils.enterTextinAnelemnt(this.txtbxlookUpCode, "0", "Look up code", "Code"))
				if(utils.clickAnelemnt(this.btnLookUpcodeSearch,"Lookupcode", "Seacrh")) {
					utils.waitforpageload();
					return utils.validateLabel(errormessage, "Search is not recognized as a valid code. Enter a valid code to continue");
				}
		return false;
	}
}
