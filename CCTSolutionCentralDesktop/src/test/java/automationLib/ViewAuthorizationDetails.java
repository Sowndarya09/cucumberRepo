package automationLib;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ViewAuthorizationDetails {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();

	Actions action=new Actions(Driver.pgDriver);
	public ViewAuthorizationDetails()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	//Objects .....................

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//div[@node_name='AuthorizationLetters']//table[@class='gridTable ']")
	WebElement tableAuthorizationLetters;


	//View Auth Details
	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='AuthorizationNumber']/parent::div//span")
	WebElement labelAuthorizationNumber;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='CreationDate']/parent::div//span")
	WebElement labelCreationDate;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='ProviderName']/parent::div//span")
	WebElement labelRequestingProvider;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='ProviderLocation']/parent::div//span")
	WebElement labelServiceProviderLocation;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='AuthorizationType']/parent::div//span")
	WebElement labelAuthorizationType;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='PreAuthType']/parent::div//span")
	WebElement labelPreAuthType;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@data-test-id='201705111958190046215100-Label']/parent::div//span")
	WebElement labelStatus;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='StatusDate']/parent::div//span")
	WebElement labelStatusDate;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='PatientName']/parent::div//span")
	WebElement labelPatientName;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='PatientDOB']/parent::div//span")
	WebElement labelPatientDOB;

	@FindBy(xpath="//div[@node_name='ViewAuthorizationDetailsWrapper']//label[@for='ContractCode']/parent::div//span")
	WebElement labelContractCode;

	@FindBy(id="AuthorizationServiceNumber")
	WebElement drpDownAuthNumber;

	@FindBy(xpath="//font[contains(text(),'Authorization Details')]")
	WebElement lnkAuthDetails;

	@FindBy(xpath="//div[@node_name='pyCaseActionAreaButtons']//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="//label[contains(text(),'Letters')]")
	WebElement tabLetters;

	@FindBy(xpath="//table[@pl_prop='.LetterSummaryList']")
	WebElement tblLetters;

	@FindBy(xpath="//a[contains(text(),'Viewer URL')]")
	WebElement lnkViewerURL;

	@FindBy(xpath="//label[contains(text(),'View Authorizations')]")
	WebElement labelViewAuthorizations;

	//Auth Details

	@FindBy(xpath="//div[@node_name='AuthorizationSummaryDetails']//label[@for='AuthorizationNumber']/parent::div//span")
	WebElement labelAuthNumber;

	@FindBy(xpath="//div[@node_name='AuthorizationSummaryDetails']//label[@for='ServiceFromDate']/parent::div//span")
	WebElement labelServiceFromDate;

	@FindBy(xpath="//div[@node_name='AuthorizationSummaryDetails']//label[@for='ServiceToDate']/parent::div//span")
	WebElement labelServiceToDate;

	@FindBy(xpath="//div[@node_name='AuthorizationSummaryDetails']//label[@for='RecordType']/parent::div//span")
	WebElement labelRecordType;

	@FindBy(xpath="//div[@node_name='AuthorizationSummaryDetails']//label[@for='CaseStatus']/parent::div//span")
	WebElement labelAuthStatus;

	@FindBy(xpath="//div[@node_name='AuthorizationSummaryDetails']//label[@for='ServiceStatusReason']/parent::div//span")
	WebElement labelServiceStatusReason;

	@FindBy(xpath="//div[@node_name='AuthorizationSummaryDetails']//label[@for='ReviewDate']/parent::div//span")
	WebElement labelReviewDate;
	
	


	public boolean validateLetterDetailsbyRow(String[] rowvalues)
	{
			String headervalues="Identifier,Name,Number,From Date,To Date,Code,Viewer";
			String[] headerValues=headervalues.toLowerCase().split(",");
			if(utils.clickAnelemnt(this.tabLetters,"ViewAuthorisationDetails", "Letters tab"))
				if(utils.validateTableRowHeader(this.tableAuthorizationLetters, headerValues))
					if(utils.validateRowValues(this.tableAuthorizationLetters, rowvalues))
						return true;
			return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyViewAuthorizationDetailsInfo
	 * #Description: This functionality validated the information present in  the View Authorization Details Page
	 * #Argument: View Auth Details
	 * #Type: Table
	 * keys: Authorization Number#Creation Date#Requesting Provide#Service Provider Location#Authorization Type#Pre Auth Type#Status#Status Date#Patient Name#Patient DOB#Contract Code
	 */

	public boolean verifyViewAuthorizationDetailsInfo(String[] viewauthdetails)
	{
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : viewauthdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"Authorization Number")){
				returnvar = utils.validateLabel(labelAuthorizationNumber, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Creation Date")){
				returnvar = utils.validateLabel(this.labelCreationDate,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Requesting Provider")){
				returnvar = utils.validateLabel(this.labelRequestingProvider,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Service Provider Location")){
				returnvar = utils.validateLabel(this.labelServiceProviderLocation,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Authorization Type")){
				returnvar = utils.validateLabel(this.labelAuthorizationType,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Pre Auth Type")){
				returnvar = utils.validateLabel(this.labelPreAuthType,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Status")){
				returnvar = utils.validateLabel(this.labelStatus,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Status Date")){
				returnvar = utils.validateLabel(this.labelStatusDate,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Patient Name")){
				returnvar = utils.validateLabel(this.labelPatientName,value);
				continue;
			}

			else if(utils.isvalueMatch_compareto(key,"Patient DOB")){
				returnvar = utils.validateLabel(this.labelPatientDOB,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Contract Code")){
				returnvar = utils.validateLabel(this.labelContractCode,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			System.out.println("Subscriber info verified successfully");
			return true;	
		}
		else
		{
			int tot_i=viewauthdetails.length;
			err.logcommonMethodError("Member Composite", "the value "+viewauthdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectDrpDownAuthorizationServiceDetails
	 * #Description: This functionality selects the drop down values in the Authorization Details section
	 * #Argument: drpdown
	 * Type: Drop down
	 * key:
	 */

	public boolean selectDrpDownAuthorizationServiceDetails(String[] drpdown)
	{
			return utils.selectDropDownbyVisibleString(drpDownAuthNumber, drpdown[0], "ViewAuthorizationDetails", "Auth Number selected");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAuthorizationDetails
	 * #Description: This functionality performs click action on the Authorization Details link
	 * Type: Textbox
	 */
	public boolean clickAuthorizationDetails()
	{
			return utils.clickAnelemnt(lnkAuthDetails, "ViewAuthorizationDetails", "Auth Details Link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyAuthDetails
	 * #Description: This functionality validated the information present in  the Auth Details section in View Authorization Details Page
	 * #Argument: Auth Details
	 * #Type: Table
	 * keys: Authorization Number#Service From Date#Service To Date#Record Type#Status#Service Status Reason#Review Date
	 */

	public boolean verifyAuthDetails(String[] authdetails)
	{
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";

		for(String iterator : authdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();

			if(utils.isvalueMatch_compareto(key, "authnumber")){
				returnvar = utils.validateLabel(this.labelAuthNumber, value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"servicefromdate")){
				returnvar = utils.validateLabel(this.labelServiceFromDate,value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"servicetodate")){
				returnvar = utils.validateLabel(this.labelServiceToDate,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"recordtype")){
				returnvar = utils.validateLabel(this.labelRecordType,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"status")){
				returnvar = utils.validateLabel(this.labelAuthStatus,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"servicestatusreason")){
				returnvar = utils.validateLabel(this.labelServiceStatusReason,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"reviewdate")){
				returnvar = utils.validateLabel(this.labelReviewDate,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar)
		{
			return true;	
		}
		else
		{
			int tot_i=authdetails.length;
			err.logcommonMethodError("Member Composite", "the value "+authdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSubmitInViewAuthDetails
	 * #Description: This functionality performs click action on the submit button in the View Authorization Details Page
	 * Type: Textbox
	 */
	public boolean clickSubmitInViewAuthDetails()
	{
			return utils.clickAnelemnt(btnSubmit, "ViewAuthorizationDetails", "Submit");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickLettersTab
	 * #Description: This functionality performs click action on the Letters tab in the View Authorization Details Page
	 * Type: Textbox
	 */
	public boolean clickLettersTab()
	{
			return utils.clickAnelemnt(tabLetters, "ViewAuthorizationDetails", "Letters");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateLettersTable
	 * #Description: This functionality validated the information present in  the Letters table in View Authorization Details Page
	 * #Argument: tablevalues
	 * #Type: Table
	 * keys: Letter Identifier#Letter Name#Authorization Number#Service From Date#Service To Date#Service Code#Letter Viewer
	 */
	public boolean validateLettersTable(String[] tablevalues) throws InterruptedException
	{
		return utils.validateRowValues(tblLetters, tablevalues);
	}

	public boolean clickOnViewURLLink()
	{
			return utils.clickAnelemnt(lnkViewerURL, "ViewAuthorizationDetails", "View URL Link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyViewAuthorizationResultsTitle
	 * #Description: This functionality validates the Header of the page once submit button is clicked.
	 * Type: Textbox
	 */
	public boolean verifyViewAuthorizationResultsTitle()
	{
			return utils.validateHeader(labelViewAuthorizations, "View Authorizations");
	}

	//Sprint 2.1 - Orion
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="TagGandA")
	private WebElement GAChkBox;

	@FindBy(xpath="//input[@id='TagGandA'][@checked]")
	private WebElement GAChked;

	@FindBy(xpath="//label[text()='Member has Grievance and/ or Appeal for this Authorization']")
	private WebElement GAChkBoxLbl;

	@FindBy(id="CheckReviewForContact")
	private WebElement viewAuthDetailDiscussedChkBox;

	@FindBy(xpath="//input[@id='CheckReviewForContact'][@checked]")
	private WebElement viewAuthDetailDiscussedChked;

	@FindBy(xpath="//label[text()='Authorization discussed with contact']")
	private WebElement viewAuthDetailDiscussedChkBoxLbl;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyAuthorizationHasGrievanceAndAppealsCheckBox
	 * #Description:This method verifies 'Authorization Has Grievance And Appeals CheckBox' in View Authorization Details page.
	 * Type:Textbox
	 */
	public boolean verifyAuthorizationHasGrievanceAndAppealsCheckBox(){
		return !utils.isProxyWebelement(GAChkBox) && !utils.isProxyWebelement(GAChkBoxLbl);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectAuthorizationHasGACheckBox
	 * #Description:This method selects 'Authorization Has Grievance And Appeals CheckBox' in View Authorization Details page
	 * Type:Textbox
	 */
	public boolean selectAuthorizationHasGACheckBox(){
			return utils.clickAnelemnt(this.GAChkBox, "ViewAuthorizationDetails", "Authorization has Grievance and/ or Appeal checkbox");
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectAuthorizationDiscussedWithContactCheckBox
	 * #Description:This method selects 'Authorization Discussed With Contact CheckBox' in View Authorization Details page.
	 * Type:Textbox
	 */
	public boolean selectAuthorizationDiscussedWithContactCheckBox(){
			return utils.clickAnelemnt(this.viewAuthDetailDiscussedChkBox, "ViewAuthorizationDetails", "Authorization Discussed With Contact CheckBox");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyAuthorizationHasGAIsChecked
	 * #Description:This method verifies if 'Authorization Has Grievance And Appeals CheckBox' in View Authorization Details page is checked
	 * Type:Textbox
	 */
	public boolean verifyAuthorizationHasGAIsChecked(){	
			if(this.GAChked.getAttribute("checked").equalsIgnoreCase("true")){
				blogger.loginfo("Authorization has Grievance and/ or Appeal checkbox is checked");
				return true;
			}else{
				blogger.loginfo("Authorization has Grievance and/ or Appeal checkbox isnt checked");
				return false;
			}
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyAuthorizationDiscussedWithContactIsChecked
	 * #Description:This method verifies if 'Authorization Discussed With Contact CheckBox' in View Authorization Details page is checked
	 * Type:Textbox
	 */
	public boolean verifyAuthorizationDiscussedWithContactIsChecked(){
			if(this.viewAuthDetailDiscussedChked.getAttribute("checked").equalsIgnoreCase("true")){
				blogger.loginfo("Authorization Discussed With Contact CheckBox is checked");
				return true;
			}else{
				blogger.loginfo("Authorization Discussed With Contact CheckBox isnt checked");
				return false;
			}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on the submit button in the View Authorization Details page
	 * Type:TextBox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
			return utils.clickAnelemnt(this.btnSubmit,"ViewAuthorizationDetails","Submit Button");
	}

	@FindBy(xpath="//label[contains(text(),'View Authorization Details')]")
	WebElement labelViewAuthorizationDetails;

	/**This method is used to verify View Authorization Details Titls
	 * 
	 * @return
	 */
	public boolean verifyViewAuthorizationDetailsTitle()
	{
			return utils.validateHeader(labelViewAuthorizationDetails, "View Authorization Details");
	}

	/**Verify Authorization Service Number Present*/
	public boolean verifyAuthNumberInServiceDetails(String[] args) {
		return utils.validateLabel(drpDownAuthNumber, args[0]);		
	}

	/**This functionality validates the Authorization General Information in the Authorization Details  section.*/
	public boolean verifyAuthDetailsInformation(String[] authdetails)
	{
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";

		for(String iterator : authdetails)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();

			if(utils.isvalueMatch_compareto(key, "authnumber")){
				returnvar = utils.validateLabel(this.labelAuthNumber, value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"servicefromdate")){
				returnvar = utils.validateLabel(this.labelServiceFromDate,value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"servicetodate")){
				returnvar = utils.validateLabel(this.labelServiceToDate,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"recordtype")){
				returnvar = utils.validateLabel(this.labelRecordType,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"status")){
				returnvar = utils.validateLabel(this.labelAuthStatus,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"servicestatusreason")){
				returnvar = utils.validateLabel(this.labelServiceStatusReason,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"reviewdate")){
				returnvar = utils.validateLabel(this.labelReviewDate,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar)
		{
			return true;	
		}
		else
		{
			int tot_i=authdetails.length;
			err.logcommonMethodError("Member Composite", "the value "+authdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	@FindBy(xpath="//font[contains(text(),'Service Details')]")
	WebElement LnkServiceDetails;

	/**This method is to click on Service Details tab*/
	public boolean clickServiceDetails()
	{
		return utils.clickAnelemnt(LnkServiceDetails, "ViewAuthorizationDetails", "LnkServiceDetails");
	}

	@FindBy(xpath="//font[contains(text(),'Inpatient Information')]")
	WebElement LnkInpatientInfo;

	/**This method is to click on Service Details tab*/
	public boolean clickInpatientInfo()
	{
		return utils.clickAnelemnt(LnkInpatientInfo, "ViewAuthorizationDetails", "LnkInpatientInfo");
	}

	@FindBy(xpath="//font[contains(text(),'Provider Details')]")
	WebElement LnkProviderDetails;

	/**This method is to click on Service Details tab*/
	public boolean clickProviderDetails()
	{
		return utils.clickAnelemnt(LnkProviderDetails, "ViewAuthorizationDetails", "LnkProviderDetails");
	}

	@FindBy(xpath="//span[@data-test-id='201706061303470187497713']/ancestor::table[@class='gridTable ']")
	WebElement ServiceDetailsTable;

	@FindBy(xpath="//span[@data-test-id='201705161611180752115713']/ancestor::table[@class='gridTable ']")
	WebElement ServiceDetailsDiagnosisTable;

	/**Validates the Service Details Information in Authorization Details tab*/
	public boolean verifyServiceDetailInformation(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arr1 = new ArrayList<String>();

		String[] array = new String[arr.size()];
		String[] array1 = new String[arr1.size()];

		for(int i=0;i<args.length;i++)
		{
			String[] value = args[i].split(":");

			if(utils.isvalueMatch_contain(value[0],"Diagnosis Code") || utils.isvalueMatch_contain(value[0],"Description")) {
				arr.add(args[i]);
				continue;}
			else if(utils.isvalueMatch_contain(value[0],"Code Type") || utils.isvalueMatch_contain(value[0],"Procedure Code")|| utils.isvalueMatch_contain(value[0],"Modifier") || utils.isvalueMatch_contain(value[0],"Quantity")) { 
				arr1.add(args[i]);
				continue;}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(utils.validatetablerowbasedonvalues(ServiceDetailsTable, arr.toArray(array)) && utils.validatetablerowbasedonvalues(ServiceDetailsDiagnosisTable, arr1.toArray(array1))) {
			blogger.loginfo("Service Details Verification Passed");
			return true;
		}else {
			blogger.loginfo("Service Details Verification Failed");
			return false;
		}

	}

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionInpatientInformationBBBB~pzLayout_2']//*[@pl_prop_class='Antm-FW-CSFW-Data-Authorization']")
	WebElement InpatientInfoTable;
	
	/**Validates the Service Details Information in Authorization Details tab*/
	public boolean verifyInpatientInformation(String[] args) {
		
		
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arr1 = new ArrayList<String>();

		String[] array = new String[arr.size()];
		String[] array1 = new String[arr1.size()];

		for(int i=0;i<args.length;i++)
		{
			String[] value = args[i].split(":");

			if(utils.isvalueMatch_contain(value[0],"Admission Date") || utils.isvalueMatch_compareto(value[0],"Discharge Date") || utils.isvalueMatch_compareto(value[0],"Discharge") || utils.isvalueMatch_contain(value[0],"DaysRequested") || utils.isvalueMatch_contain(value[0],"Days Approved") || utils.isvalueMatch_contain(value[0],"Days Denied")) {
				arr.add(args[i]);
				continue;}
			else if(utils.isvalueMatch_contain(value[0],"Requested Date") || utils.isvalueMatch_contain(value[0],"Action")|| utils.isvalueMatch_contain(value[0],"Service From") || utils.isvalueMatch_contain(value[0],"Service To") || utils.isvalueMatch_contain(value[0],"Bed Type") || utils.isvalueMatch_contain(value[0],"Length of Stay") || utils.isvalueMatch_contain(value[0],"Reason")) { 
				arr1.add(args[i]);
				continue;}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(utils.validatetablerowbasedonvalues(InpatientInfoTable, arr1.toArray(array1)) && verifyInPatientDetailsSection(arr.toArray(array))) {
			blogger.loginfo("Inpatient Info Verification Passed");
			return true;
		}else {
			blogger.loginfo("Inpatient Info Verification Failed");
			return false;
		}
	}
	
	@FindBy(xpath="//*[@data-test-id='201705161538580525106852']")
	WebElement AdmissionDate;
	
	@FindBy(xpath="//*[@data-test-id='201705161538580526107693']")
	WebElement DischargeDate;
	
	@FindBy(xpath="//*[@data-test-id='201705161538580527108837']")
	WebElement Discharge;
	
	@FindBy(xpath="//*[@data-test-id='201705161538580527109120']")
	WebElement DaysRequested;
	
	@FindBy(xpath="//*[@data-test-id='201705161538580528110794']")
	WebElement DaysApproved;
	
	@FindBy(xpath="//*[@data-test-id='20170516153858052811140']")
	WebElement DaysDenied;
	
	public boolean verifyInPatientDetailsSection(String[] args) {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_compareto(key,"Admission Date")){
				returnvar = utils.validateLabel(AdmissionDate, value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"Discharge Date")){
				returnvar = utils.validateLabel(DischargeDate,value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"Discharge")){
				returnvar = utils.validateLabel(Discharge,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"DaysRequested")){
				returnvar = utils.validateLabel(DaysRequested,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Days Approved")){
				returnvar = utils.validateLabel(DaysApproved,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Days Denied")){
				returnvar = utils.validateLabel(DaysDenied,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			blogger.loginfo("Requester Provider Information verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ViewAuthorizationDetails", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
		
		

	}

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='20160128042601028824550']")
	WebElement RequestInfo_Name;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='20160201052925089382246-Label']/../div/span")
	WebElement RequestInfo_Phone;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='2017060222003608525784']")
	WebElement RequestInfo_Address;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='20160128042601029225569-Label']/../div/span")
	WebElement RequestInfo_NPI;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='20160201052546042119913-Label']/../div/span")
	WebElement RequestInfo_Tax;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='20160128043234017514399-Label']/../div/span")
	WebElement RequestInfo_Legacy;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='2016012805263503746814-Label']/../div/span")
	WebElement RequestInfo_MediCare;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='2016012805263503767983-Label']/../../../div[@class='content-item content-field item-8   ']//span")
	WebElement RequestInfo_SplCode;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionRequestingProviderInformationB']//*[@data-test-id='2016012805263503767983-Label']/../../../div[@class='content-item content-field item-9   ']//span")
	WebElement RequestInfo_ProviderGrp;

	public boolean verifyProviderDetails_RequestProviderInfo(String[] args) {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"Name")){
				returnvar = utils.validateLabel(RequestInfo_Name, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Phone")){
				returnvar = utils.validateLabel(RequestInfo_Phone,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Provider Address")){
				returnvar = utils.validateLabel(RequestInfo_Address,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"NPI")){
				returnvar = utils.validateLabel(RequestInfo_NPI,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Tax ID")){
				returnvar = utils.validateLabel(RequestInfo_Tax,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Legacy ID")){
				returnvar = utils.validateLabel(RequestInfo_Legacy,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Medicare ID")){
				returnvar = utils.validateLabel(RequestInfo_MediCare,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Speciality Code")){
				returnvar = utils.validateLabel(RequestInfo_SplCode,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Provider Group")){
				returnvar = utils.validateLabel(RequestInfo_ProviderGrp,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			blogger.loginfo("Requester Provider Information verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ViewAuthorizationDetails", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='20160128042601028824550']")
	WebElement ServiceInfo_Name;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='20160201052925089382246-Label']/../div/span")
	WebElement ServiceInfo_Phone;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='2017060222003608525784']")
	WebElement ServiceInfo_Address;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='20160128042601029225569-Label']/../div/span")
	WebElement ServiceInfo_NPI;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='20160201052546042119913-Label']/../div/span")
	WebElement ServiceInfo_Tax;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='20160128043234017514399-Label']/../div/span")
	WebElement ServiceInfo_Legacy;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='2016012805263503746814-Label']/../div/span")
	WebElement ServiceInfo_MediCare;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='2016012805263503767983-Label']/../../../div[@class='content-item content-field item-8   ']//span")
	WebElement ServiceInfo_SplCode;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServicingProviderInformationB']//*[@data-test-id='2016012805263503767983-Label']/../../../div[@class='content-item content-field item-9   ']//span")
	WebElement ServiceInfo_ProviderGrp;

	public boolean verifyProviderDetails_ServiceProviderInfo(String[] args) {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"Name")){
				returnvar = utils.validateLabel(ServiceInfo_Name, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Phone")){
				returnvar = utils.validateLabel(ServiceInfo_Phone,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Provider Address")){
				returnvar = utils.validateLabel(ServiceInfo_Address,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"NPI")){
				returnvar = utils.validateLabel(ServiceInfo_NPI,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Tax ID")){
				returnvar = utils.validateLabel(ServiceInfo_Tax,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Legacy ID")){
				returnvar = utils.validateLabel(ServiceInfo_Legacy,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Medicare ID")){
				returnvar = utils.validateLabel(ServiceInfo_MediCare,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Speciality Code")){
				returnvar = utils.validateLabel(ServiceInfo_SplCode,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Provider Group")){
				returnvar = utils.validateLabel(ServiceInfo_ProviderGrp,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			blogger.loginfo("Requester Provider Information verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ViewAuthorizationDetails", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServiceLocationProviderB']//*[@data-test-id='20160128042601028824550']")
	WebElement ServiceLocInfo_Name;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServiceLocationProviderB']//*[@data-test-id='20160201052925089382246-Label']/../div/span")
	WebElement ServiceLocInfo_Phone;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServiceLocationProviderB']//*[@data-test-id='2017060222003608525784']")
	WebElement ServiceLocInfo_Address;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServiceLocationProviderB']//*[@data-test-id='20160128042601029225569-Label']/../div/span")
	WebElement ServiceLocInfo_NPI;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServiceLocationProviderB']//*[@data-test-id='20160201052546042119913-Label']/../div/span")
	WebElement ServiceLocInfo_Tax;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServiceLocationProviderB']//*[@data-test-id='20160128043234017514399-Label']/../div/span")
	WebElement ServiceLocInfo_Legacy;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServiceLocationProviderB']//*[@data-test-id='2016012805263503746814-Label']/../div/span")
	WebElement ServiceLocInfo_MediCare;

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionServiceLocationProviderB']//*[@data-test-id='2016012805263503767983-Label']/../../../div[@class='content-item content-field item-8   ']//span")
	WebElement ServiceLocInfo_SplCode;

	public boolean verifyProviderDetails_ServiceLocationProviderInfo(String[] args) {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"Name")){
				returnvar = utils.validateLabel(ServiceLocInfo_Name, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Phone")){
				returnvar = utils.validateLabel(ServiceLocInfo_Phone,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Provider Address")){
				returnvar = utils.validateLabel(ServiceLocInfo_Address,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"NPI")){
				returnvar = utils.validateLabel(ServiceLocInfo_NPI,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Tax ID")){
				returnvar = utils.validateLabel(ServiceLocInfo_Tax,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Legacy ID")){
				returnvar = utils.validateLabel(ServiceLocInfo_Legacy,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Medicare ID")){
				returnvar = utils.validateLabel(ServiceLocInfo_MediCare,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Speciality Code")){
				returnvar = utils.validateLabel(ServiceLocInfo_SplCode,value);
				continue;
			}
			else 
				err.logcommonMethodError("ViewAuthorizationDetails", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			blogger.loginfo("Requester Provider Information verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ViewAuthorizationDetails", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	// Sprint 6.1
	
	@FindBy(xpath="//font[contains(text(),'Service Details')]")
	WebElement lnkServiceDetails;
	
	@FindBy(xpath="//table[@pl_prop='.DiagnosisList']")
	WebElement tblDiagnosisList;

	/**
	 * This functionality clicks the Service Details link in the View Authorization Details page
	 * @return
	 */
	
	public boolean expandServiceDetails()
	{
		return utils.clickAnelemnt(lnkServiceDetails, "ViewAuthorizations", "Service Details");
	}
	
	public boolean verifyDiagnosisDescription(String[] tablevalues)
	{
		utils.scrolltomiddle();
		return utils.validatetablerowbasedonvalues(tblDiagnosisList, tablevalues);
	}
	
	

	//Sprint 6.1
	
	/*@FindBy(xpath="//li[@title='Letters']")
	WebElement tabLetters;*/
	
	@FindBy(xpath="//table[@pl_prop='.LetterSummaryList']")
	WebElement tableLetters;
	
	/**
	 * This functionality performs click action on the Letter tab in the View Authorization screen
	 * @return
	 */
	
	public boolean clickOnLetterInViewAuthorizationsScreen()
	{
		return utils.clickAnelemnt(tabLetters, "ViewAuthorizations", "Letters");
	}
	
	/**
	 * This functionality clicks the View URL in the letters table of the matching input row given by the user
	 * @param tablevalues
	 * @return
	 */
	public boolean clickOnViewerURLInViewAuthorizationsScreen(String[] tablevalues)
	{
		try
		{
		WebElement row = utils.getTablerowbasedonvalues(tableLetters, tablevalues);
		List<WebElement> rowNo = row.findElements(By.tagName("a"));
		rowNo.get(0).click();
		return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("ViewAuthorizations", "clickOnViewerURLInViewAuthorizationsScreen", "Error in clicking Voew URL");
			return false;
		}
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions ') or contains(text(),'Other Actions ')]")
	WebElement btnOtherActions;
	
	@FindBy(xpath="//span[text()='Request Grievance and App...']")
	WebElement LinkGrievanceAndAppeal;
	
	public boolean validateGrievanceAndAppealOptionInOtherActions() {
		if(utils.clickAnelemnt(btnOtherActions, "ViewAuthorization", "btnOtherActions")) {
			return !utils.isProxyWebelement(LinkGrievanceAndAppeal);
		}
		return false;
	}
	


}


