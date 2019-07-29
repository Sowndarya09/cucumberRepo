package automationLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class ProviderPreCertification_Search
{
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());



	public ProviderPreCertification_Search()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try{
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
	}catch(Exception e){
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}

	@FindBy(xpath="//div[text()='Pre-Certification search is allowed for Medical coverage only']")
	WebElement labelNonMedicalError;

	@FindBy(xpath="//*[text()='Category and Date field plus at least one other field are mandatory for Pre-Certification Search.']")
	WebElement labelInSufficientInputError;

	@FindBy(xpath="//*[contains(text(),'No Items Found. Review All Contract Rules')]")
	WebElement labelNoResultsMessageError;

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement1;
	
	@FindBy(id="CPTCode")
	WebElement txtbxCPTCode;

	@FindBy(id="Category")
	WebElement drpdwnCategory;

	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	WebElement headerpage;

	@FindBy(xpath="//button[@title='Save your work']")
	WebElement btnsave;

	@FindBy(xpath="//div[@title='Disclose Additional Options']//i[@class='icon icon-openclose']")
	WebElement lnkAdditionalOptions;

	@FindBy(id="Date")
	WebElement txtbxDate;

	@FindBy(id="ClaimType")
	WebElement drpdwnClaimType;

	@FindBy(id="PlaceOfService")
	WebElement drpdwnPlaceOfService;

	@FindBy(id="RevenueCode")
	WebElement txtboxRevenueCode;

	@FindBy(id="DiagnosisCode")
	WebElement txtboxDiagonsisCode;

	@FindBy(id="ProviderTaxId")
	WebElement txtbxProviderTaxId;

	@FindBy(xpath="//label[@for='pyCategoryName']/following-sibling::div")
	WebElement txtbxProviderSpeciality;

	@FindBy(xpath="//button[contains(@data-click,'SearchPreCert')]")
	WebElement btnSearch;

	@FindBy(xpath="//button[contains(@data-click,'Clear')]")
	WebElement btnClearSearch;


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateErrorMessageonInSufficientInput
	 * Description:This functionality validates the error message on insufficientInput for search
	 * Type:Textbox
	 * 
	 */
	public boolean validateErrorMessageonInSufficientInput()
	{
		if(clickSearch())
			return !utils.isProxyWebelement(labelInSufficientInputError);
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:Validate_Error_Message_For_Non_MedicalCoverage
	 * Description:This functionality validates the Error Message when you use Non Medical Coverage Data
	 * Type:Textbox
	 * 
	 */

	public boolean Validate_Error_Message_For_Non_MedicalCoverage()
	{
		return !utils.isProxyWebelement(labelNonMedicalError);

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validate_Place_of_Service_dropdownvalues
	 * #Description:This method is used to validate the CPT Code Field. It enters data into the field and checks if the field can take only a maximum of 5 characters
	 * #Arguments:Primary Reason for Interaction
	 * Type:TextBox
	 * 
	 */
	public boolean validate_CPT_Code_Field()
	{
		if(utils.enterTextinAnelemnt(this.txtbxCPTCode, "A1f4g7kl", "PreCertification_Search", "validate_CPT_Code_Field"))
			if(utils.clickAnelemnt(this.btnsave, "PreCertification_Search", "validate_CPT_Code_Field")) {
				utils.waitforpageload();
				String enteredtext=this.txtbxCPTCode.getAttribute("value").toString();
				return utils.isvalueMatch_contain(enteredtext, "A1f4g");
			}
		return false;
	}

	@FindBy(xpath="//div[text()='Search']")
	private WebElement bnSearch;

	public boolean searchPrecertificationwithvalues(String[] val)
	{
		utils.clickAnelemnt(this.lnkAdditionalOptions, "PreCertification", "Additional Option btn");
		for(String iterator:val)
		{
			if(iterator.contains(":")){
				String key = iterator.substring(0, iterator.indexOf(":"));
				String value = iterator.substring(iterator.indexOf(":")+1);
				System.out.println("key " + key + "value  " + value);

				if(key.toLowerCase().contains("date")){
					utils.enterTextinAnelemnt(this.txtbxDate, value, "PreCertification", "Date Parameter");
					continue;}
				else if(key.toLowerCase().contains("revenue")){
					utils.selectDropDownbyVisibleString(this.txtboxRevenueCode, value, "PreCertification", "Category drop down");
					continue;}
				else if(key.toLowerCase().contains("cpt")){
					utils.enterTextinAnelemnt(this.txtbxCPTCode, value, "PreCertification", "Category drop down");
					continue;}
				else if(key.toLowerCase().contains("diag")){
					utils.selectDropDownbyVisibleString(this.txtboxDiagonsisCode, value, "PreCertification", "Category drop down");
					continue;}
				else if(key.toLowerCase().contains("tax")){
					utils.enterTextinAnelemnt(this.txtbxProviderTaxId, value, "PreCertification", "Category drop down");
					continue;}
				else
					return false;
			}
		}		
		return utils.clickAnelemnt(this.bnSearch, "PreCertification", "Additional Option btn");
	}

	@FindBy(id="Category")
	WebElement drpDownCategory;

	@FindBy(id="ClaimType")
	WebElement drpDownClaimType;

	@FindBy(id="PlaceOfService")
	WebElement drpDownPlaceOfService;

	@FindBy(xpath="//button[contains(@name,'PreCertificationSearch_pyWorkPage')]//div[contains(text(),'Search')]")
	WebElement btnSearchPre;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectCategoryDropDown
	 * #Description: This functionality selects the category drop down value given by the user in the Pre_Certification Search
	 * #Type: Dropdown
	 * Keys: Select#Behavioral Health#Medical
	 */
	public boolean selectCategoryDropDown(String[] category)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownCategory, category[0], "PreCertificaton_Search", "Category");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickLinkAdditionalOptions
	 * #Description: This functionality performs clicks on the Additional Options link
	 * #Type: Textbox
	 */
	public boolean clickLinkAdditionalOptions()
	{
		return utils.clickAnelemnt(this.lnkAdditionalOptions, "PreCertificaton_Search", "Additional Options");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectClaimType
	 * #Description: This functionality selects the claim type drop down value given by the user in the Pre_Certification Search
	 * #Type: Dropdown
	 * Keys: Select#Inpatient#Outpatient#Professional#Skilled Nursing
	 */
	public boolean selectClaimType(String[] claimtype)
	{
		utils.waitForElementToBeVisible(drpDownClaimType);
		return utils.selectDropDownbyVisibleString(this.drpDownClaimType, claimtype[0], "PreCertificaton_Search", "Claim Type");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectPlaceOfService
	 * #Description: This functionality selects the Place of Service drop down value given by the user in the Pre_Certification Search
	 * #Type: Dropdown
	 * Keys: 
	 */
	public boolean selectPlaceOfService(String[] placeofservice)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownPlaceOfService, placeofservice[0], "PreCertificaton_Search", "Place Of Service");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSearch
	 * #Description: This functionality performs click action on the Search button in the Pre_Certification Search page
	 * #Type: Textbox
	 */
	public boolean clickSearch()
	{
		return utils.clickAnelemnt(this.btnSearchPre, "PreCertificaton_Search", "Search");

	}

	@FindBy(xpath="//table[@pl_prop='.PartialMatchList']")
	WebElement tblPartialMatch;

	@FindBy(xpath="//table[@pl_prop='.FullMatchList']")
	WebElement tblFullMatch;

	@FindBy(xpath="//table[@pl_prop='.NoMatchList']")
	WebElement tblNoMatch;

	@FindBy(xpath="")
	WebElement lnkClickOnLinkAfterSettingValue;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validatePartialSearchTable
	 * #Description: This functionality validates the value present in the Partial Match table row.
	 * #Type: Table
	 * Keys: UM Rule Description#Exclusion Indicator
	 */
	public boolean validatePartialSearchTable(String[] tablevalues)
	{
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(this.tblPartialMatch, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateFullSearchTable
	 * #Description: This functionality validates the value present in the Full Match table row.
	 * #Type: Table
	 * Keys: UM Rule Description#Exclusion Indicator
	 */
	public boolean validateFullSearchTable(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(this.tblFullMatch, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAllContractRulesSearchTable
	 * #Description: This functionality validates the value present in the All Contract Rules table row.
	 * #Type: Table
	 * Keys: UM Rule Description#Exclusion Indicator
	 */
	public boolean validateAllContractRulesSearchTable(String[] tablevalues)
	{
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(this.tblNoMatch, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterCPTCode
	 * #Description: This functionality enters the CPT Code in the CPT code section.
	 * #Argument: cptcode
	 * #Type: Textbox
	 */
	public boolean enterCPTCode(String[] cptcode)
	{
		return utils.enterTextinAnelemnt(this.txtbxCPTCode, cptcode[0], "PreCertification_Search", "CPT Code");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterRevenueCode
	 * #Description: This functionality enters the Revenue Code in the Revenue code section.
	 * #Argument: revcode
	 * #Type: Textbox
	 */
	public boolean enterRevenueCode(String[] revcode)
	{
		return utils.enterTextinAnelemnt(this.txtboxRevenueCode, revcode[0], "PreCertification_Search", "Revenue Code");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterDiagnosisCode
	 * #Description: This functionality enters the Diagnosis Code in the Diagnosis code section.
	 * #Argument: diagcode
	 * #Type: Textbox
	 */
	public boolean enterDiagnosisCode(String diagcode)
	{

		return utils.enterTextinAnelemnt(this.txtboxDiagonsisCode, diagcode, "PreCertification_Search", "Diagnosis Code"); 
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterTaxID
	 * #Description: This functionality enters the Tax ID  in the Tax Id section.
	 * #Argument: diagcode
	 * #Type: Textbox
	 */
	public boolean enterTaxID(String taxid)
	{
		return utils.enterTextinAnelemnt(this.txtbxProviderTaxId, taxid, "PreCertification_Search", "Tax ID");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterRevCodeAndDiagCodeAndTaxID
	 * #Description: This functionality enters the Revenue Code, Diagnosis Code and then Tax ID  in the respective section.
	 * #Argument: args
	 * #Type: Textbox
	 */
	public boolean enterRevCodeAndDiagCodeAndTaxID(String[] args)
	{
		if(this.enterRevenueCode(args))
			if(this.enterDiagnosisCode(args[1]))
				return this.enterTaxID(args[2]);
		return false;
	}


	public boolean enterProviderSpeciality(String provspeciality)
	{
		return utils.enterTextinAnelemnt(this.txtbxProviderSpeciality, provspeciality, "PreCertification_Search", "Provider Speciality");
	}

	public boolean clcikTheSearchOfProviderSpeciality()
	{
		return utils.clickAnelemnt(this.lnkClickOnLinkAfterSettingValue, "PreCertification_Search", "Provider Speciality");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterProviderSpecialityAndClick
	 * #Description: This functionality enters the Provider Speciality in the  respective section.
	 * #Argument: args
	 * #Type: Textbox
	 */
	public boolean enterProviderSpecialityAndClick(String[] args)
	{
		if(this.enterProviderSpeciality(args[0]))
			return this.clcikTheSearchOfProviderSpeciality();
		return false;
	}

	@FindBy(xpath="//span[contains(text(),'All Contract Rules')]")
	WebElement lnkAllContractRules;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAllContractRules
	 * #Description: This functionality performs click action on the AllContractRules  in the Pre_Certification Search page
	 * #Type: Textbox
	 */

	public boolean clickAllContractRules()
	{
		action.moveToElement(lnkAllContractRules);
		return utils.clickAnelemnt(this.lnkAllContractRules, "PreCertification_Search", "No Match");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: Verify_presence_of_initial_search_results
	 * #Description: This functionality validates the header row of the Pre_Certification Search table
	 * Type: Textbox
	 */
	public boolean Verify_presence_of_initial_search_results()
	{
		utils.waitforpageload();
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblFullMatch);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("");
		valuesGivenManual.add("UM Rule Description");
		valuesGivenManual.add("Exclusion Indicator");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		return valuesFromApp.equals(valuesGivenManual);	
	}


	@FindBy(xpath="//*[text()='Additional Options']")
	WebElement AdditionalOptionsLnk;

	public boolean clickAdditionalOptions() {
		return utils.clickAnelemnt(AdditionalOptionsLnk, "PreCertification_Search", "AdditionalOptionsLnk");
	}

	@FindBy(xpath="//*[text()='Submit']")	
	WebElement SubmitButton;

	public boolean clickSubmit() {
		utils.waitforpageload();
		return utils.clickAnelemnt(SubmitButton, "PreCertification_Search", "SubmitButton");
	}

	@FindBy(xpath="//*[text()='Full Match']/ancestor::div[@class='layout layout-outline layout-outline-white_bg_blue_header']//table[@id='gridLayoutTable']")
	WebElement FullMatchTable;
	
	@FindBy(xpath="//*[text()='All Contract Rules']//following::div[@class='repeatContainer gridDefault    readOnlyGrid ']")
	WebElement NoMatchTable;
	
	public boolean validateFullMatchTable(String[] args) {
		utils.waitforpageload();
		return utils.validatetablerowbasedonvalues(FullMatchTable, args);
	}

	public boolean validateNoMatchTable(String[] args) {
		return utils.validatetablerowbasedonvalues(NoMatchTable, args);
	}

	public boolean validateNoResultsMessage() {
		return !utils.isProxyWebelement(labelNoResultsMessageError);
	}

	@FindBy(xpath="//*[text()='Partial Match']/ancestor::div[@class='layout layout-outline layout-outline-white_bg_blue_header']//table[@id='gridLayoutTable']")
	WebElement PartialMatchTable;

	public boolean validatePartialMatchTable(String[] args) {
		return utils.validatetablerowbasedonvalues(PartialMatchTable, args);
	}

	public boolean ClickUMRuleDescription(String[] args) throws InterruptedException {
		try {
			System.out.println("Entered");
		Thread.sleep(10000);
		utils.waitforpageload();
		utils.scrolltomiddle();
		WebElement ele=Driver.getPgDriver().findElement(By.xpath("//a[contains(text(),'"+args[0]+"')]"));
		JavascriptExecutor executor = (JavascriptExecutor)Driver.getPgDriver();
		executor.executeScript("arguments[0].click();", ele);
		return true;
		}catch(Exception ex) {
			return false;
		}
	}

	public boolean enterDiagCode(String[] diagcode) {
		return enterDiagnosisCode(diagcode[0]);

	}

	/**
	 * This functionality validates the UM Rule Details Populated in Pre-certification Details Page
	 * @param args
	 * @return
	 */

	@FindBy(xpath="//table[@pl_prop='.UMRuleDetails']")
	WebElement tblUMRuleDetails;

	public boolean validateUMRuleDetailsTable(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(tblUMRuleDetails, tablevalues);
	}
	
	@FindBy(xpath="//label[text()='Procedure Code']")
	
	WebElement PrcedurecodeLabel;
	
	/**
	 * This functionality validates that the CPT code name label changed to Procedure code in Pre-certification Search Screeen
	 * 
	 * @return
	 */
	public boolean validateProcedureCodeName(){
		return !utils.isProxyWebelement(PrcedurecodeLabel);
	}
	
	//Validate that the contract code value in Pre-cert search screen in Provider flow
		@FindBy(xpath="//*[@data-test-id='2016012805263503715878']")
		WebElement ContractCode;

		public boolean validateContractCode(String[] value){
				
				String ContractCodeValue = value[0];
				String ContractCodeValueFromUI = this.ContractCode.getText().replaceAll(",", "").replaceAll("  ", " ");
				return utils.isvalueMatch_compareto(ContractCodeValueFromUI, ContractCodeValue);

		}
	
		
		//Validate that the Pre-Cert Guided Dialog in Pre-cert search screen in Provider flow
				@FindBy(id="DialogContent")
				WebElement PreCertGuidedDialog;

				public boolean validatePrecertificationGuidedDialog(String[] value){
						
						String GuidedDialog = value[0];
						String GuidedDialogFromUI = this.PreCertGuidedDialog.getText().replaceAll(",", "").replaceAll("  ", " ");
						return utils.isvalueMatch_compareto(GuidedDialogFromUI, GuidedDialog);

				}
				
				@FindBy(xpath="//a[text()='Lookup Code']")
				WebElement LookupCodeLink;
				
				public boolean VerifyandclickLookUpcodeInPrecertSearch(){
					if(!utils.isProxyWebelement(LookupCodeLink));
					return utils.clickAnelemnt(LookupCodeLink, "ProviderPreCertification_Search", "LookupCodeLink");
									
				}
				
				@FindBy(id="SearchStringApplicableKeys")
				WebElement drpdwnlookUpCodeType;
				
				@FindBy(id="CodeSearch")
				WebElement txtbxlookUpCode;
				
				@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Search']")
				WebElement btnLookUpcodeSearch;
				
				@FindBy(xpath="//div[@node_name='HCPCSModifierData']//label[@for='Description']/parent::div//span")
				WebElement labelLookUpCodeProcedureModifierDescription;
				
				@FindBy(xpath="//div[@node_name='HCPCSModifierData']//label[@for='LastUpdatedDate']/parent::div//span")
				WebElement labelLookUpCodeProcedureModifierEffectiveDate;
				
				@FindBy(xpath="//div[@node_name='HCPCSModifierData']//label[@for='EndDate']/parent::div//span")
				WebElement labelLookUpCodeProcedureModifierEnddate;
				
				@FindBy(xpath="//div[text()='Close Window']")
				WebElement btnClosebtn;
				
				public boolean validateProcedureModifierCode(String[] code) throws Exception
				{
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
					Thread.sleep(4000);
					String value=code[0];
					if(code[0].contains(":"))
					value = code[0].substring(code[0].indexOf(":")+1).toUpperCase();
					if(utils.selectDropDownbyVisibleString(this.drpdwnlookUpCodeType, "Procedure Modifier Code", "LookUpCode", "Code Type Dropdown"))
						if(utils.enterTextinAnelemnt(this.txtbxlookUpCode, value, "LookUpCode", "Code text"))
							if(utils.clickAnelemnt(this.btnLookUpcodeSearch,"Lookup Code","Search button"))
							{
								if((this.labelLookUpCodeProcedureModifierDescription.getText().contains("SIGNIF,SEP IDENTIF E/M SERVICE BY SAME PHY ON SAME DAY PROCD")))
									if((this.labelLookUpCodeProcedureModifierEffectiveDate.getText().contains("08/13/2014")))
										if(this.labelLookUpCodeProcedureModifierEnddate.getText().contains("12/31/9999"))
											if(utils.clickAnelemnt(this.btnClosebtn, "LookUp Code", "Close Button"))
												Driver.getPgDriver().switchTo().window(parentWindowHandler);
								return true;
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
				
				@FindBy(xpath="//img[@src='webwb/tool_icon_13690228252.png!!.png']")
				WebElement wrenchicon;
				public boolean validateWrenchIconIsNotPresent()
				{
					return utils.isProxyWebelement(wrenchicon);
				}
				
		       public boolean validateWrenchIconIsPresent()
				{
					return !utils.isProxyWebelement(wrenchicon);
				}
		       
				public boolean switchToChildWindow(String parentWindow) throws InterruptedException {

		              try {

		                     Set<String> s2 = Driver.getPgDriver().getWindowHandles();
		                     Iterator<String> i2 = s2.iterator();

		                     while (i2.hasNext()) {
		                           String childWindow = i2.next();

		                           if (!parentWindow.equalsIgnoreCase(childWindow)) {
		                                  System.out.println("in child window");
		                                  Driver.getPgDriver().switchTo().window(childWindow);
		                                  // Driver.getPgDriver().manage().window().maximize();
		                                  Thread.sleep(2000);
		                                  String titleOfthePage = Driver.pgDriver.getTitle();
		                                  System.out.println(titleOfthePage);
		                                  return true;
		                           }

		                     }
		              } catch (Exception ex) {

		                     System.out.println("Failed to switch to child window");
		                     return false;
		              }
		              return false;
		       }     
				
				public boolean validateUMRuleTableValuesInFullmatch(String[] tablevalues)
				{
					return utils.validatetablerowbasedonvalues(tblUMRuleDetails, tablevalues);
				}
				
				public boolean validateUMRuleTableValuesInPartialmatch(String[] tablevalues)
				{
					return utils.validatetablerowbasedonvalues(tblUMRuleDetails, tablevalues);
				}
				public boolean validateUMRuleTableValuesInAllContracts(String[] tablevalues)
				{
					return utils.validatetablerowbasedonvalues(tblUMRuleDetails, tablevalues);
				}
				
				
				
				
				
				public boolean expandUMRuleinFullMatch(String[] args) throws Exception{
					
					WebElement tableValues=utils.returntablerowbasedonvalues(FullMatchTable, args);
					List<WebElement> row=tableValues.findElements(By.xpath(".//span[@title='press enter to expand row']"));
					return utils.clickAnelemnt(row.get(0), "precertification search", "table");
						 
					 }
					
					}
					
				
				
				
		      


