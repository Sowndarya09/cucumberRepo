package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class UpdateOtherInsurance {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());


	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	/**
	 * Constructor for the RequestAccumulatorReview class defining the Iframe and the Page Factory  
	 */
	public UpdateOtherInsurance() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}


	@FindBy(id="ReasonForContact")
	WebElement drpDownReasonForContact;

	@FindBy(xpath="//a[@name='UpdateOtherInsurance_pyWorkPage_9']/img")
	WebElement btnAdd;

	@FindBy(xpath="//a[@name='UpdateOtherInsurance_pyWorkPage_6']/img")
	WebElement btnUpdate;

	@FindBy(xpath="//a[@name='UpdateOtherInsurance_pyWorkPage_9'][@disabled]")
	WebElement btnAddDisabled;

	@FindBy(id="SelectOtherInsurance")
	WebElement drpDownOtherInsurance;

	@FindBy(id="SelectInsuranceToUpdate")
	WebElement drpDownOtherInsuranceToUpdate;

	@FindBy(id="OtherInsuranceCarrier")
	WebElement txtOtherInsuranceCarrier;

	@FindBy(id="OtherInsuranceIDNumber")
	WebElement txtOtherInsuranceIdNumber;

	@FindBy(id="OtherInsurancePolicyHolder")
	WebElement txtOtherInsurancePolicyHolder;

	@FindBy(id="OtherInsuranceSubscriber")
	WebElement txtOtherInsuranceSubscriber;

	@FindBy(id="EffectiveDate")
	WebElement txtOtherInsuranceEffectiveDate;

	@FindBy(id="ExpiryDate")
	WebElement txtOtherInsuranceExpiryDate;

	@FindBy(id="EmploymentStatus")
	WebElement drpDownEmploymentStatus;

	@FindBy(id="Custodial")
	WebElement drpDownCustoDial;

	@FindBy(id="PhoneNumber")
	WebElement txtOtherInsurancePhoneNumber;

	@FindBy(id="GroupNumber")
	WebElement txtOtherInsuranceGroupNumber;

	@FindBy(id="pySelected1_rdi_1")
	WebElement chkBxInsuranceMember;

	@FindBy(xpath="//button[@data-test-id='201804192334420841271443']")
	WebElement btnSubmit;

	@FindBy(xpath="//input[@id='HasNoOtherInsurance']")
	WebElement chkBxMemberDoNotHaveInsurance;

	@FindBy(id="NoOtherEffectiveDate")
	WebElement txtEffectiveDateForMemberDoNotHaveInsurance;

	@FindBy(id="MedicareBeneficiaryIdentifier")
	WebElement txtMedicareBeneficiaryIdentifier;

	@FindBy(id="QualifiedReason")
	WebElement txtQualifiedReason;

	@FindBy(id="ActivelyWorking")
	WebElement txtActivelyWorking;

	@FindBy(id="IsUrgentRequest")
	WebElement chkBxUrgentRequestMED;

	@FindBy(id="PartAEffectiveDate")
	WebElement txtPartAEffectiveDate;

	@FindBy(id="PartBEffectiveDate")
	WebElement txtPartBEffectiveDate;

	@FindBy(id="UpdateMedicarePartA_rdi_1")
	WebElement chkBxPartA;

	@FindBy(id="UpdateMedicarePartB_rdi_1")
	WebElement chkBxPartB;

	@FindBy(id="ReturntoCSR")
	WebElement chkBxOverrideDefaultToMe;

	@FindBy(id="IsUrgentRequest")
	WebElement chkBxUrgentRequest;

	@FindBy(id="UrgentReason")
	WebElement drpDownUrgentRequestReason;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectDropDownReasonForContact
	 * #Description: This functionality selects the value given by the user in the reason for contact drop down
	 * #Argument: reasonforcontact
	 * Type: Dropdown 
	 * keys:Select#Discuss Other Commercial Insurance#Discuss Medicare Coordination of Benefits#Update Other Insurance#Explain other insurance details
	 */
	public boolean selectDropDownReasonForContact(String[] reasonforcontact)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReasonForContact, reasonforcontact[0], "UpdateOtherInsurance", "Reason for Contact");

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAddIcon
	 * #Description: This functionality performs click action in the Add icon in the Update Insurance section
	 * Type: Textbox
	 */
	public boolean clickAddIcon()
	{
		return utils.clickAnelemnt(this.btnAdd, "UpdateOtherInsurance", "Add Icon");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectDrpDownOtherInsurance
	 * #Description: This functionality selects the value given by the user in the other insurance drop down
	 * #Argument: otherinsurance
	 * Type: Dropdown 
	 */
	public boolean selectDrpDownOtherInsurance(String[] otherinsurance)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownOtherInsurance, otherinsurance[0], "UpdateOtherInsurance", "Other Insurance");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectDrpDownOtherInsuranceToUpdate
	 * #Description: This functionality selects the value given by the user in the other insurance drop down
	 * #Argument: otherinsurance
	 * Type: Dropdown 
	 */
	public boolean selectDrpDownOtherInsuranceToUpdate(String[] otherinsurance)
	{
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(this.drpDownOtherInsuranceToUpdate, otherinsurance[0], "UpdateOtherInsurance", "Other Insurance");
	}

	public boolean enterOtherInsuranceCarrier(String carrier)
	{
		return utils.enterTextinAnelemnt(this.txtOtherInsuranceCarrier, carrier, "UpdateOtherInsurance", "Other Insurance Carrier");
	}

	public boolean enterOtherInsuranceIDNumber(String idnumber)
	{
		return utils.enterTextinAnelemnt(this.txtOtherInsuranceIdNumber, idnumber, "UpdateOtherInsurance", "Insurance ID Number");
	}

	public boolean enterPolicyHolder(String policyholder)
	{
		return utils.enterTextinAnelemnt(this.txtOtherInsurancePolicyHolder, policyholder, "UpdateOtherInsurance", "Policy Holder");
	}

	public boolean enterOtherInsuranceSubscriber(String subscriber)
	{
		return utils.enterTextinAnelemnt(this.txtOtherInsuranceSubscriber, subscriber, "UpdateOtherInsurance", "Subscriber");
	}

	public boolean enterOtherInsuranceEffectiveDate(String effdate)
	{
		return utils.enterTextinAnelemnt(this.txtOtherInsuranceEffectiveDate, effdate, "UpdateOtherInsurance", "Effective Date");
	}

	public boolean enterOtherInsuranceExpiryDate(String expdate)
	{
		return utils.enterTextinAnelemnt(this.txtOtherInsuranceExpiryDate, expdate, "UpdateOtherInsurance", "Expiry Date");
	}


	public boolean selectDrpDownOtherInsuranceEmpStatus(String empstatus)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownEmploymentStatus, empstatus, "UpdateOtherInsurance", "Employment Status");
	}

	public boolean selectDrpDownOtherInsuranceCustoDial(String custodial)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownCustoDial, custodial, "UpdateOtherInsurance", "Custo Dial");
	}

	public boolean selectMemberCheckbox()
	{
		return utils.clickAnelemnt(this.chkBxInsuranceMember, "UpdateOtherInsurance", "Member Check Box");
	}
	
	@FindBy(xpath="//select[@id=\"COBReasonCode\"]")
	WebElement drpReasonCode;
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectDropDownReasonCode
	 * #Description:This functionality  select the drop down for ReasonCode by first index 
	 * Type: Dropdown 
	 */
    public  boolean selectDrpDownReasonCode() throws InterruptedException {
    
		return utils.selectDropDownbyIndex(drpReasonCode, 1, "UpdateOtherInsurance", "dropDown");
     }
    
	public boolean clickSubmitButon()
	{
		WebElement element = this.btnSubmit;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(this.btnSubmit, "UpdateOtherInsurance", "Submit");

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterMandatoryDetailsInUpdateOtherInsurance
	 * #Description: This functionality enters all the mandatory details in the Update Other Insurance page and then clicks submit.
	 * #Argument: details
	 * Type: Textbox
	 */
	public boolean enterMandatoryDetailsInUpdateOtherInsurance(String[] details)
	{
		if(this.enterOtherInsuranceCarrier(details[0]))
			if(this.enterOtherInsuranceIDNumber(details[1]))
				if(this.enterPolicyHolder(details[2]))
					if(this.enterOtherInsuranceSubscriber(details[3]))
						if(this.enterOtherInsuranceEffectiveDate(details[4]))
							if(this.selectDrpDownOtherInsuranceEmpStatus(details[5]))
								if(this.selectDrpDownOtherInsuranceCustoDial(details[6]))
									return true;
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnMemberDoNotHaveInsuranceCheckBox
	 * #Description: This functionality clicks on the Member Do not have check box in the Update Other Insurance page.
	 * Type: Textbox
	 */
	public boolean clickOnMemberDoNotHaveInsuranceCheckBox()
	{
		return utils.clickAnelemnt(this.chkBxMemberDoNotHaveInsurance, "UpdateOtherInsurance", "Member Do Not Have Checkbox");

	}


	public static String effectivedateIns;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterEffectiveDateForMemebrDoNotHaveInsurance
	 * #Description: This functionality enters the effective date for the member who do not have insurance
	 * #Argument: effectivedate
	 * Type: Textbox
	 */
	public boolean enterEffectiveDateForMemebrDoNotHaveInsurance(String[] effectivedate)
	{
		effectivedateIns= effectivedate[0];
		return utils.enterTextinAnelemnt(this.txtEffectiveDateForMemberDoNotHaveInsurance, effectivedate[0], "UpdateOtherInsurance", "EffectiveDate");
	}


	public boolean enterMedicareBeneficiaryIdentifier(String beneficary)
	{
		return utils.enterTextinAnelemnt(this.txtMedicareBeneficiaryIdentifier, beneficary, "UpdateOtherInsurance", "Medicare Beneficiary");
	}

	public boolean enterQualifiedReason(String reason)
	{
		return utils.enterTextinAnelemnt(this.txtQualifiedReason, reason, "UpdateOtherInsurance", "Qualified Reason");
	}


	public boolean enterActivelyWorkingStatus(String status)
	{
		return utils.enterTextinAnelemnt(this.txtActivelyWorking, status, "UpdateOtherInsurance", "Actively Working");
	}

	public boolean clickOnPartACheckBox()
	{
		return utils.clickAnelemnt(this.chkBxPartA, "UpdateOtherInsurance", "Part A");
	}

	public boolean clickOnPartBCheckBox()
	{
		return utils.clickAnelemnt(this.chkBxPartB, "UpdateOtherInsurance", "Part B");
	}

	public boolean enterPartAEffectiveDate(String effdatePartA)
	{
		return utils.enterTextinAnelemnt(this.txtPartAEffectiveDate, effdatePartA, "UpdateOtherInsurance", "Part A Effective Date");
	}

	public boolean enterPartBEffectiveDate(String effdatePartA)
	{
		return utils.enterTextinAnelemnt(this.txtPartBEffectiveDate, effdatePartA, "UpdateOtherInsurance", "Part B Effective Date");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterMandatoryDetailsInMedSectionPartA
	 * #Description: This functionality enters all the Mandatory section in the Med Section for Part A.
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean enterMandatoryDetailsInMedSectionPartA(String[] args)
	{
		if(this.clickOnPartACheckBox())
			if(this.enterPartAEffectiveDate(args[0]))
				if(this.enterQualifiedReason(args[1]))
					if(this.enterActivelyWorkingStatus(args[2]))
						if(this.clickSubmitButon())
							return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterMandatoryDetailsInMedSectionPartB
	 * #Description: This functionality enters all the Mandatory section in the Med Section for Part B.
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean enterMandatoryDetailsInMedSectionPartB(String[] args)
	{
		if(this.enterMedicareBeneficiaryIdentifier(args[0]))
			if(this.clickOnPartBCheckBox())
				if(this.enterPartBEffectiveDate(args[1]))
					if(this.enterQualifiedReason(args[2]))
						if(this.enterActivelyWorkingStatus(args[3]))
							if(this.clickSubmitButon())
								return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCoveredMemberCheckBox
	 * #Description: This functionality clicks the covered member check box in the Update Insurance section.
	 * Type: Textbox
	 */
	public boolean clickCoveredMemberCheckBox(String[] membername)
	{
		String xpath = "//span[contains(text(),'"+membername[0]+"')]//ancestor::td[@headers='a2']//preceding-sibling::td//input[@type='checkbox']";
		System.out.println("xpath is: " + xpath);
		utils.waitforpageload();
		try{
			if(Driver.pgDriver.findElement(By.xpath(xpath)).getAttribute("checked").equalsIgnoreCase("true")){
				return true;
			}else{
				Driver.pgDriver.findElement(By.xpath(xpath)).click();
				return true;
			}}catch(Exception e){
				Driver.pgDriver.findElement(By.xpath(xpath)).click();
				return true;
			}
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOverrideDefaultToMeCheckBox
	 * #Description: This functionality clicks the Override Default to me chcek box in the Update Insurance section.
	 * Type: Textbox
	 */
	public boolean checkOverrrideDefaultRouting()
	{
		return utils.clickAnelemnt(this.chkBxOverrideDefaultToMe, "UpdateOtherInsurance", "Over Ride to me Check box"); 
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickUrgentRequestCheckBox
	 * #Description: This functionality clicks the Urgent Request check box in the Update Insurance section.
	 * Type: Textbox
	 */
	public boolean checkUrgentRequest(String[] reason)
	{
		if(utils.clickAnelemnt(this.chkBxUrgentRequest, "UpdateOtherInsurance", "Urgent Request Check box"))
		if(selectUrgentRequestDropDownReason(reason))
			return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectUrgentRequestDropDownReason
	 * #Description: This functionality selects the drop down value in the urgent request rason section in the Update Insurance section.
	 * #Argument: reason
	 * Type: Dropdown
	 * keys: Select#Cancellation in Error#Department of Insurance#Irate Member/Broker with Multiple Interactions#Member needs medical attention within 24 hours#Member needs medical attention within 24 to 72 hours#Potential Media Involvement
	 */
	public boolean selectUrgentRequestDropDownReason(String[] reason)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownUrgentRequestReason, reason[0], "UpdateOtherInsurance", "Urgent Request Reason");
	}



	//Sprint 1.4

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectOtherInsuranceType
	 * #Description: This functionality selects the drop down value in the Other Insurance Type in the Update Insurance section.
	 * #Argument: otherinsurance
	 * Type: Dropdown
	 * keys: MED#COB
	 */
	public boolean selectOtherInsuranceType(String[] otherinsurance)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownOtherInsurance, otherinsurance[0], "UpdateOtherInsurance", "Other Insurance Drop down");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyAddIconIsDisabled
	 * #Description: This functionality verifies that the Add Icon is disabled or not in the Update Other Insurance page.
	 * Type: Textbox
	 */
	public boolean verifyAddIconIsDisabled()
	{

		String bol = this.btnAddDisabled.getAttribute("disabled");
		System.out.println("Bol value is: "+bol);
		if(bol.contains("true"))
		{
			System.out.println("Add Icon is disabled");
			return true;
		}
		else
		{
			System.out.println("Add Icon is enabled");
			return false;
		}

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickUpdateIcon
	 * #Description: This functionality performs click action in the Update icon in the Update Insurance section
	 * Type: Textbox
	 */
	public boolean clickUpdateIcon()
	{
		return utils.clickAnelemnt(this.btnUpdate, "UpdateOtherInsurance", "Update Icon");
	}


	@FindBy(xpath="//div[@data-test-id='2018012816560805551366782']")
	WebElement txtNegativeInsuranceMessage;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyNegativeInsuranceMessage
	 * #Description: This functionality verifies the Negative Insurance message populated when user selects do  not have insurance option.
	 * Type: Textbox
	 */
	public boolean verifyNegativeInsuranceMessage()
	{
		String negativeInsuranceMsgFromUI = this.txtNegativeInsuranceMessage.getText().trim();
		String negativeInsuranceMsgShouldPopulate= "Updates indicating the member does not have other insurance should be submitted in CCB. Launch the External Search task to access CCB using Log Event and request the COB update.";
		return utils.isvalueMatch_contain(negativeInsuranceMsgFromUI, negativeInsuranceMsgShouldPopulate);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterMandatoryDetailsInUpdateOtherInsuranceWithoutCoveredMemberAndSubmit
	 * #Description: This functionality enters all the mandatory details in the Update Other Insurance page and then clicks submit.
	 * #Argument: details
	 * Type: Textbox
	 */
	public boolean enterMandatoryDetailsInUpdateOtherInsuranceWithoutCoveredMemberAndSubmit(String[] details)
	{
		if(this.enterOtherInsuranceCarrier(details[0]))
			if(this.enterOtherInsuranceIDNumber(details[1]))
				if(this.enterPolicyHolder(details[2]))
					if(this.enterOtherInsuranceSubscriber(details[3]))
						if(this.enterOtherInsuranceEffectiveDate(details[4]))
							if(this.selectDrpDownOtherInsuranceEmpStatus(details[5]))
								if(this.selectDrpDownOtherInsuranceCustoDial(details[6]))
									return true;
		return false;
	}

	String expectedTextForAlert; 
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click on the submit button on the Update Insurance page
	 * Type: Textbox
	 */
	public boolean clickOnSubmit()
	{
		//action.moveToElement(btnSubmit);
		WebElement element = this.btnSubmit;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(this.btnSubmit, "UpdateOtherInsurance", "Submit");

	}

	@FindBy(id="SelectInsuranceToUpdate")
	WebElement OtherInsuranceDrpDown;

	/**This functionality selects the value from the Other Insurance drop down*/
	public boolean selectDropDownOtherInsurance(String[] args) {
		return utils.selectDropDownbyVisibleString(OtherInsuranceDrpDown, args[0], "UpdateOtherInsurance", "OtherInsuranceDrpDown");
	}


	/**This functionality verifies the pre populated fields for the COB in Update Other Insurance page*/
	public boolean verifyCOBDetailsArePrePopulated(String[] args) {
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("Update Other Insurance", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"Other Insurance ID")){
				returnvar = utils.isvalueMatch_compareto(OtherInsuranceID.getAttribute("value"), value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Policy Holder")){
				returnvar = utils.isvalueMatch_compareto(PolicyHolder.getAttribute("value"),value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Effective Date")){
				returnvar = utils.isvalueMatch_compareto(EffDate.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Termination Date")){
				returnvar = utils.isvalueMatch_compareto(TerminationDate.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Phone Number")){
				returnvar = utils.isvalueMatch_compareto(PhoneNumber.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Group Number")){
				returnvar = utils.isvalueMatch_compareto(GrpNumber.getAttribute("value"),value);
				continue;
			}
			else 
				err.logcommonMethodError("Update Other Insurance", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			blogger.loginfo("Verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("Member Composite", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	//@FindBy(xpath="//*[@data-test-id='2018010202554209012881']")
	@FindBy(id="OtherInsuranceCarrier")
	WebElement OtherInsuranceCarrier;

	/**This functionality verifies the pre populated fields for the COB in Update Other Insurance page*/
	public boolean verifyOtherInsuranceCarrierIsPrePopulatedAndNonEditable(String[] args) {
		if(OtherInsuranceCarrier.getText().equals(args[0].substring(args[0].indexOf(":")+1))) {
			blogger.loginfo("PASS: Other Insurance Carrier is prepopulated");
			if(!OtherInsuranceCarrier.getTagName().equals("input")) {
				blogger.loginfo("PASS: Other Insurance Carrier is Non Editable");
				return true;
			}else {
				blogger.loginfo("FAIL: Other Insurance Carrier is not Non Editable");
				return false;
			}
		}else {
			blogger.loginfo("PASS: Other Insurance Carrier is not prepopulated");
			return false;
		}

	}

	@FindBy(xpath="//*[@data-test-id='20180102031709089399137']")
	WebElement InsuranceSubscriber;

	@FindBy(xpath="//*[@id='EmploymentStatus']")
	WebElement EmpStatus;

	@FindBy(xpath="//*[@id='Custodial']")
	WebElement CustDial;

	/**This functionality enters the details which is not pre populated in the Update Other Insurance  page*/
	public boolean enterCOBDetailsWhichIsNotPrePopulated(String[] args) {
		String[] values = args[0].split(";");
		if(utils.enterTextinAnelemnt(InsuranceSubscriber, values[0], "Update Other Insurance", "InsuranceSubscriber"))
			if(utils.selectDropDownbyVisibleString(EmpStatus, values[1], "Update Other Insurance", "EmpStatus"))
				if(utils.selectDropDownbyVisibleString(CustDial, values[2], "Update Other Insurance", "CustDial"))
					return true;
		return false;
	}

	/**This functionality verifies the pre populated fields for the COB in Update Other Insurance page*/
	public boolean verifyMEDDetailsArePrePopulated(String[] args) {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("Update Other Insurance", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"Medicare Beneficiary Identifier")){
				returnvar = utils.isvalueMatch_compareto(MedicareBeneficiaryIdentifier.getAttribute("value"), value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Effective Date PartA")){
				returnvar = utils.isvalueMatch_compareto(PartAEffectiveDate.getAttribute("value"),value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Termination Date PartA")){
				returnvar = utils.isvalueMatch_compareto(PartAExpiryDate.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Effective Date PartB")){
				returnvar = utils.isvalueMatch_compareto(this.PartBEffectiveDate.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Termination Date PartB")){
				returnvar = utils.isvalueMatch_compareto(this.PartBExpiryDate.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Effective Date PartD")){
				returnvar = utils.isvalueMatch_compareto(this.PartDEffectiveDate.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Termination Date PartD")){
				returnvar = utils.isvalueMatch_compareto(this.PartDExpiryDate.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Qualified Reason")){
				returnvar = utils.isvalueMatch_compareto(this.QualifiedReason.getAttribute("value"),value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Actively Working Status")){
				returnvar = utils.isvalueMatch_compareto(this.ActivelyWorkingStatus.getAttribute("value"),value);
				continue;
			}
			else 
				err.logcommonMethodError("Update Other Insurance", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			blogger.loginfo("Verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("Member Composite", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//*[@id='OtherInsuranceIDNumber']")
	WebElement OtherInsuranceID;

	@FindBy(xpath="//*[@id='OtherInsurancePolicyHolder']")
	WebElement PolicyHolder;

	@FindBy(xpath="//*[@id='EffectiveDate']")
	WebElement EffDate;

	@FindBy(xpath="//*[@id='ExpiryDate']")
	WebElement TerminationDate;

	@FindBy(xpath="//*[@id='PhoneNumber']")
	WebElement PhoneNumber;

	@FindBy(xpath="//*[@id='GroupNumber']")
	WebElement GrpNumber;

	/**This functionality verifies that the inputs are not pre populated fields for the COB in Update Other Insurance page*/

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyCOBDetailsAreNotPrePopulated
	 * #Description: This functionality validates that the COB Details fields are not pre populated when user adds the insurance.
	 * Type: Textbox
	 */
	public boolean verifyCOBDetailsAreNotPrePopulated() {
		if(utils.validateLabel(OtherInsuranceCarrier, "") && utils.validateLabel(OtherInsuranceID, "") && utils.validateLabel(PolicyHolder, "")&& utils.validateLabel(EffDate, "") && utils.validateLabel(TerminationDate, "")&& utils.validateLabel(PhoneNumber, "") && utils.validateLabel(GrpNumber, ""))
				return true;
			return false;
	}

	@FindBy(xpath="//*[@id='MedicareBeneficiaryIdentifier']")
	WebElement MedicareBeneficiaryIdentifier;

	@FindBy(xpath="//*[@id='PartAEffectiveDate']")
	WebElement PartAEffectiveDate;

	@FindBy(xpath="//*[@id='PartAExpiryDate']")
	WebElement PartAExpiryDate;

	@FindBy(xpath="//*[@id='PartBEffectiveDate']")
	WebElement PartBEffectiveDate;

	@FindBy(xpath="//*[@id='PartBExpiryDate']")
	WebElement PartBExpiryDate;

	@FindBy(xpath="//*[@id='PartDEffectiveDate']")
	WebElement PartDEffectiveDate;

	@FindBy(xpath="//*[@id='PartDExpiryDate']")
	WebElement PartDExpiryDate;

	@FindBy(xpath="//*[@id='QualifiedReason']")
	WebElement QualifiedReason;

	@FindBy(xpath="//*[@id='ActivelyWorking']")
	WebElement ActivelyWorkingStatus;


	/**This functionality verifies that the inputs are not pre populated fields for the MED in Update Other Insurance page*/

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyMEDDetailsAreNotPrePopulated
	 * #Description: This functionality validates that the MED Details fields are not pre populated when user adds the insurance.
	 * Type: Textbox
	 */
	public boolean verifyMEDDetailsAreNotPrePopulated() {
		if(utils.validateLabel(MedicareBeneficiaryIdentifier, "") &&  utils.validateLabel(PartAEffectiveDate, "")&& utils.validateLabel(PartAExpiryDate, "") && utils.validateLabel(PartBEffectiveDate, "")&& utils.validateLabel(PartBExpiryDate, "") && utils.validateLabel(PartDEffectiveDate, "")&& utils.validateLabel(PartDExpiryDate, "") && utils.validateLabel(QualifiedReason, "")&& utils.validateLabel(ActivelyWorkingStatus, ""))
				return true;
			return false;
	}

	@FindBy(xpath="//a[@name='UpdateOtherInsurance_pyWorkPage_6'][@disabled]")
	WebElement btnUpdateDisabled;

	/**This functionality verifies that the Update button is disabled*/

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyUpdateIconIsNotDisplayed
	 * #Description: This functionality verifies that the update icon is not displayed in the Update Other insurance page
	 * Type: Textbox
	 */
	public boolean verifyUpdateIconIsNotDisplayed() {
			return !utils.clickAnelemnt(btnUpdateDisabled, "UpdateOtherInsurance", "Update Icon");	
	}

	@FindBy(id="HasNoOtherInsurance_rdi_1")
	WebElement MemDoestNtHaveOtherIns;

	public boolean verifyMemDoesntHaveOtherInsuranceChckBoxDisplayed() {
		return !utils.isProxyWebelement(MemDoestNtHaveOtherIns);
	}

	public boolean verifyMemDoesntHaveOtherInsuranceChckBoxNtDisplayed() {
		return !utils.isProxyWebelement(MemDoestNtHaveOtherIns);
	}

	@FindBy(id="NoOtherExpiryDate")
	WebElement TerminationDateInUpdateNoOtherInsurance;

	public boolean verifyTerminationDatePrepopulated() {
		String terminDate = TerminationDateInUpdateNoOtherInsurance.getAttribute("value");
		return utils.isvalueMatch_compareto(terminDate, "12/30/2018");
	}

	@FindBy(xpath="//*[text()='Update No Other Insurance']")
	WebElement UpdateNoOtherInsuranceSection;

	public boolean verifyDisplayofUpdateNoOtherInsuranceSection() {
		return !utils.isProxyWebelement(UpdateNoOtherInsuranceSection);
	}

	@FindBy(id="ReasonForTermination")
	WebElement ReasonForTerminationDrpDown;

	public boolean verifyReasonForTerminationDisplayed() {
		return !utils.isProxyWebelement(ReasonForTerminationDrpDown);
	}

	@FindBy(xpath="//div[@node_name='pyCaseActionArea']//div[contains(text(),'Other actions')]")
	WebElement DrpDownOtherActions;

	@FindBy(xpath="//span[contains(text(),'View Other Insurance')]")
	WebElement lnkViewOtherInsurance;

	public boolean clickViewOtherInsuranceInOtherActionsDrpdown()	{
		if(utils.clickAnelemnt(DrpDownOtherActions, "UpdateOtherInsurance", "Other Actions"))
			if(utils.clickAnelemnt(lnkViewOtherInsurance, "ReasonForTerminationDrpDown", "lnkViewOtherInsurance"))
				return true;
		return false;
	}

	public boolean selectReasonForTerminationDrpdown(String[] args) {
		return utils.selectDropDownbyVisibleString(ReasonForTerminationDrpDown, args[0], "ReasonForTerminationDrpDown", "ReasonForTerminationDrpDown");
	}

	//Sprint 3.1

	@FindBy(xpath="//input[@id='MedicareBeneficiaryIdentifier']/following-sibling::div/span")
	WebElement errormsg;

	/*
	 * 
	 */
	public boolean verifyMedBenIdentifierAcceptMinMaxChar(String[] args)
	{
		try
		{
			txtMedicareBeneficiaryIdentifier.clear();
			if(utils.enterTextinAnelemnt(this.txtMedicareBeneficiaryIdentifier, args[0], "UpdateOtherInsurance", "Medicare Beneficiary Identifier"))
			this.txtMedicareBeneficiaryIdentifier.sendKeys(Keys.TAB);
			return true;
		}catch(Exception e) {
			err.logError("UpdateOtherInsurance", "verifyMedBenAcceptsMinMaxChar");
			return false;
		}
	}

	public boolean verifyMedBenIdentifierAcceptsTheRule(String[] args)
	{
			String expectedErrorMsg = errormsg.getText();
			return utils.isvalueMatch_contain(expectedErrorMsg, args[0]);
	}


	public boolean validateMedBenIdentifierMsgLessThan12Charcs(String[] args)
	{
			String expectedErrorMsg = errormsg.getText();
			return utils.isvalueMatch_contain(expectedErrorMsg, args[0]);
	}


	public boolean enterActivelyWorkingStatusForPrePopulated(String[] status)
	{
		return utils.enterTextinAnelemnt(this.txtActivelyWorking, status[0], "UpdateOtherInsurance", "Actively Working");
	}

	@FindBy(xpath="//span[@data-test-id='20180419131157079033198']")
	WebElement VerfiyText;

	@FindBy(xpath="//span[@data-test-id='201604081256400982365']")
	WebElement SR;

	@FindBy(xpath="//a[@class='Standard_task']")
	WebElement serviceReqDetails;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyNegativeInsuranceMessage
	 * #Description: This functionality verifies the Negative Insurance message populated when user selects do  not have insurance option.
	 * Type: Textbox
	 */
	public boolean verifyNoOtherInsuranceText(String[] userID)
	{
		String negativeInsuranceMsgFromUI = this.VerfiyText.getText().trim();
		String SrID = this.serviceReqDetails.getText().trim();
		String SRIDAfterSubstring = SrID.substring(SrID.indexOf("(")+1,SrID.indexOf(")")).trim();
		String negativeInsuranceMsgFromUser = "Per Solution Central "+SRIDAfterSubstring+", NOIC ,"+userID[0];
		return utils.isvalueMatch_contain(negativeInsuranceMsgFromUI, negativeInsuranceMsgFromUser);
	}

	//Sprint 3.2 Update No other insurance

	@FindBy(xpath="//*[text()='Update']")
	WebElement Update;

	public boolean clickUpdateButton()
	{
		return utils.clickAnelemnt(this.Update, "UpdateOtherInsurance", "Update Button");
	}

	@FindBy(xpath="//div[@data-test-id='20161103134931086340536']")
	WebElement NoOtherInsuranceupdateSuccessMsg;


	public boolean NoOtherInsuranceupdateSuccessMsg() throws InterruptedException
	{
		Thread.sleep(1000);
		String ActualMsg = NoOtherInsuranceupdateSuccessMsg.getText();
		String ExpectedMsg ="Member Does Not Have Other Insurance updated successfully.";
		return utils.isvalueMatch_contain(ActualMsg, ExpectedMsg);
	}

	//Sprint 3.4

	@FindBy(id="ActivelyWorkingYes_rdi_1")
	WebElement rdoBtnActivelyWorkingStatusYes;

	@FindBy(id="ActivelyWorkingNo_rdi_1")
	WebElement rdoBtnActivelyWorkingStatusNo;

	@FindBy(id="QualifiedReason")
	WebElement drpDownQualifiedReason;

	@FindBy(xpath="//div[@data-test-id='201801041727370822240851']")
	WebElement labelTextUnknownInActivelyWorkingStatus;


	public boolean verifyQualifiedReasonDropdownIsDisplayed()
	{
		return !utils.isProxyWebelement(drpDownQualifiedReason);
	}

	public boolean verifyTheActivelyWorkingStatusTextIsNotDisplayed()
	{
		return !utils.isProxyWebelement(labelTextUnknownInActivelyWorkingStatus);
	}


	public boolean verifyQualifiedReasonDropdownValues()
	{
		//utils.selectDropDownbyVisibleString(this.drpDownQualifiedReason, "Aged", "ManageOtherInsurance", "Qualified Reason");
		String[] qualifiedReason = {"Select","Aged","Disabled","Disabled & ESRD","ESRD","Medicare Cost","Not Applicable Member Does Not"};
		WebElement dropdown = Driver.pgDriver.findElement(By.id("QualifiedReason"));  
		Select select = new Select(dropdown);  

		List<WebElement> options = select.getOptions();  
		for(WebElement we:options)  
		{  
			for (int i=0; i<qualifiedReason.length; i++){
				if (we.getText().contains(qualifiedReason[i])){
					System.out.println("Matched");
					return true;
				} else
				{
					System.out.println("Doesn't Matched");
					return false;
				}
			}
		}
		return false;  

	}


	public boolean selectActivelyWorkingStatus(String[] args)
	{
		if(args[0].contains("Yes"))
			return utils.clickAnelemnt(rdoBtnActivelyWorkingStatusYes, "ManageOtherInsurance", "Yes in Actively Working Status");
		else if(args[0].contains("No"))
			return utils.clickAnelemnt(rdoBtnActivelyWorkingStatusNo, "ManageOtherInsurance", "No in Actively Working Status");
		return false;
	}

	public boolean clickOnSubmitForAlertMsg()
	{

		WebElement element = this.btnSubmit;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		btnSubmit.click();
		Alert alert = Driver.pgDriver.switchTo().alert();
		expectedTextForAlert = alert.getText();
		System.out.println("Expected Text: "+expectedTextForAlert);
		alert.accept();
		return true;
	}

	public boolean validateTheErrorMessageWhenTheMandatoryFieldsAreNotPopulatedAndSubmitted() throws InterruptedException
	{

		this.clickOnSubmitForAlertMsg();
		//System.out.println("Expected Text: "+expectedText);
		String actualText = "Please correct flagged fields before submitting the form!";
		return utils.isvalueMatch_contain(actualText, expectedTextForAlert);
	}
	
	@FindBy(xpath="//*[text()='Covered Member']/ancestor::table[@id='gridLayoutTable']//td[@class='dataValueRead gridCell ']//span")
	List<WebElement> TextCoveredMembers;

	@FindBy(xpath="//*[text()='Covered Member']/ancestor::table[@id='gridLayoutTable']//input[@type=\"checkbox\"]")
	List<WebElement> CheckBoxCoveredMembers;

	/**This functionality checks the check box of the Covered Member Name entered Update other insurance page for Provider flow
	 * 
	 * @return
	 */

	public boolean checkCoveredMembers(String[] args) {
		for(int i=0;i<TextCoveredMembers.size();i++) {
			System.out.println(TextCoveredMembers.get(i).getText());
			if(utils.isvalueMatch_contain(TextCoveredMembers.get(i).getText(), args[0]))
				return utils.clickAnelemnt(CheckBoxCoveredMembers.get(i), "ProviderManageOtherInsurance", "CheckboxCoveredMembers");
		}
		return false;
	}

	@FindBy(xpath="//*[@id='OtherInsuranceSubscriber']")
	WebElement OtherInsuranceSubscriber;



	@FindBy(xpath="//*[@id='EmploymentStatus']")
	WebElement EmploymentStatus;

	@FindBy(xpath="//*[@id='Custodial']")
	WebElement Custodial;

	@FindBy(id="SelectOtherInsurance")
	WebElement SelectOtherInsurance;

	@FindBy(id="AddCOBTypeC")
	WebElement AddCOBTypeC;

	@FindBy(id="AddCOBTypeD")
	WebElement AddCOBTypeD;

	/**Enter Add COB Other Insurance Required fields and select the EMployee Status and Custodial at Update Other Insurance page for ADD COB in Provider flow
	 * 	
	 * @return
	 */
	public boolean addCOBOtherInsuranceDetails(String[] args) {

		utils.selectDropDownbyVisibleString(SelectOtherInsurance, "COB","ProviderManageOtherInsurance","SelectOtherInsurance");
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ProviderManageOtherInsurance", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			if(utils.isvalueMatch_contain(key,"COB Type")) {
				if(utils.isvalueMatch_contain(value, "AddCOBTypeC")) {
					returnvar = utils.clickAnelemnt(AddCOBTypeC, "UpdateOtherInsurance", "AddCOBTypeC");
					continue;
				}
				else {
					returnvar = utils.clickAnelemnt(AddCOBTypeD, "UpdateOtherInsurance", "AddCOBTypeD");
					continue;
				}
			}
			else if(utils.isvalueMatch_contain(key,"Other Insurance ID")){
				returnvar = utils.enterTextinAnelemnt(OtherInsuranceID, value, "ProviderManageOtherInsurance", "OtherInsuranceID");
				continue;}
			else if(utils.isvalueMatch_contain(key,"Other Insurance Carrier")){
				returnvar = utils.enterTextinAnelemnt(OtherInsuranceCarrier, value, "ProviderManageOtherInsurance", "OtherInsuranceCarrier");
				continue;}
			else if(utils.isvalueMatch_contain(key,"Other Insurance Subscriber")){
				returnvar = utils.enterTextinAnelemnt(OtherInsuranceSubscriber, value, "ProviderManageOtherInsurance", "OtherInsuranceSubscriber");
				continue;}

			else if(utils.isvalueMatch_contain(key,"Policy Holder")){
				returnvar = utils.enterTextinAnelemnt(PolicyHolder, value, "ProviderManageOtherInsurance", "PolicyHolder");
				continue;}
			else if(utils.isvalueMatch_contain(key,"Effective Date")){
				returnvar = utils.enterTextinAnelemnt(EffDate, value, "ProviderManageOtherInsurance", "EffDate");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Termination Date")){
				returnvar = utils.enterTextinAnelemnt(TerminationDate, value, "ProviderManageOtherInsurance", "TerminationDate");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Phone Number")){
				returnvar = utils.enterTextinAnelemnt(PhoneNumber, value, "ProviderManageOtherInsurance", "PhoneNumber");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Group Number")){
				returnvar = utils.enterTextinAnelemnt(GrpNumber, value, "ProviderManageOtherInsurance", "GrpNumber");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Employment Status")){
				returnvar = utils.selectDropDownbyVisibleString(EmploymentStatus, value, "ProviderManageOtherInsurance", "EmploymentStatus");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"Custodial")){
				returnvar = utils.selectDropDownbyVisibleString(Custodial, value, "ProviderManageOtherInsurance", "Custodial");
				continue;
			}
			else 
				err.logcommonMethodError("Update Other Insurance", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			blogger.loginfo("Verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("Member Composite", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

//Sprint 7.2
	
	@FindBy(id="UpdateMedicarePartD_rdi_1")
	WebElement chkBxPartD;

	@FindBy(id="PartDEffectiveDate")
	WebElement txtPartDEffectiveDate;
	
	@FindBy(id="PartDExpiryDate")
	WebElement txtPartDTerminationDate;
	
	/**This method clicks the part D check box on the medicare update page
	 * 
	 * @return
	 */
	
	public boolean clickOnPartDCheckBox()
	{
		return utils.clickAnelemnt(this.chkBxPartD, "UpdateOtherInsurance", "Part D");
	}

	/**This method enters the  part D effective date on the medicare update page
	 * 
	 * @return
	 */
	public boolean enterPartDEffectiveDate(String[] effdatePartA)
	{
		return utils.enterTextinAnelemnt(this.txtPartDEffectiveDate, effdatePartA[0], "UpdateOtherInsurance", "Part D Effective Date");
	}

	/**This method enters the  part D termination date on the medicare update page
	 * 
	 * @return
	 */
	
	public boolean enterPartDTerminationDate(String[] effdatePartA)
	{
		return utils.enterTextinAnelemnt(this.txtPartDTerminationDate, effdatePartA[0], "UpdateOtherInsurance", "Part D Termination Date");
	}


}
