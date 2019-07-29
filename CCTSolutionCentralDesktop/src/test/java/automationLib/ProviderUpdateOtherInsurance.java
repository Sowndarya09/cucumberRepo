package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class ProviderUpdateOtherInsurance {

	SeleniumUtilities utils = new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(), 20);
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement2;

	@FindBy(xpath="COB Indicator CheckBox")
	private WebElement cobCheckBox;

	@FindBy(xpath="MED Indicator CheckBox")
	private WebElement medCheckBox;

	@FindBy(xpath="Submit button")
	private WebElement submit;

	@FindBy(linkText="Coordination of benefits details reviewed with the contact")
	private WebElement COBLink;

	@FindBy(linkText="Medicare details reviewed with the contact")
	private WebElement MEDLink;

	/**
	 * Constructor for the RequestAccumulatorReview class defining the Iframe and the Page Factory  
	 */
	public ProviderUpdateOtherInsurance() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}



	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	/**This functionality on Submit button at Update Other insurance page for Provider flow
	 * 
	 * @return
	 */
	public boolean clickSubmit()
	{
		WebElement element = this.btnSubmit;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(btnSubmit, "ManageOtherInsurance", "Submit");
	}


	@FindBy(xpath="//table[@pl_prop='D_OtherInsurance.pxResults']")
	WebElement tblViewOtherInsurance;
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyEffectiveDate
	 * #Description: This functionality validates the Effective date and the End Date in the View Other Insurance page.
	 * Type: Textbox
	 */
	public boolean verifyEffectiveDate(String[] tablevalues) throws InterruptedException
	{
		return utils.validatetablerowbasedonvalues(this.tblViewOtherInsurance, tablevalues);
	}

	@FindBy(xpath="//span[@data-test-id='20160205073151019455360']/ancestor::table[@class='gridTable ']")
	WebElement InsRecordTable;

	/**This method verifies and selects a particular row for the corresponding data input in Manage Other  Insurance table.
	 * @throws InterruptedException */
	public boolean selectAnInsuranceRecord(String[] args) throws InterruptedException {
		WebElement rows = utils.returntablerowbasedonvalues(tblViewOtherInsurance, args);
		List<WebElement> row = rows.findElements(By.tagName("input"));
		row.get(1).click();
		return true;


	}

	@FindBy(xpath ="//table[@pl_prop='D_OtherInsurance.pxResults']//tr//td//div[contains(text(),'No items')]")
	WebElement Noitems;


	public boolean verifyNoItems()
	{
		return !utils.isProxyWebelement(Noitems);
	}

	public boolean clickUpdateButton(String[] tablevalues)
	{
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblViewOtherInsurance, tablevalues);
			List<WebElement> rowValue = row.findElements(By.tagName("a"));
			rowValue.get(0).click();
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception e: "+e);
			err.logcustomerrorwithmessage("ManageOtherInsurance", "clickUpdateIcon", "Update Icon is not clicked");
			return false;
		}

	}

	@FindBy(xpath ="//a[@data-test-id='201603170553400905315601']")
	WebElement clickAddButton;

	/**This functionality perfoms click action on Add button in View other insurance  page for Provider flow
	 * 
	 * @return
	 */
	public boolean clickAddButtonInProviderOtherInsuarnce()
	{
		return utils.clickAnelemnt(clickAddButton, "ManageOtherInsurance", "clickAddButton");
	}

	@FindBy(xpath="//*[@id='OtherInsuranceIDNumber']")
	WebElement OtherInsuranceID;

	@FindBy(xpath="//*[@id='OtherInsuranceCarrier']")
	WebElement OtherInsuranceCarrier;

	@FindBy(xpath="//*[@id='OtherInsuranceSubscriber']")
	WebElement OtherInsuranceSubscriber;

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

	@FindBy(xpath="//*[@id='EmploymentStatus']")
	WebElement EmploymentStatus;

	@FindBy(xpath="//*[@id='Custodial']")
	WebElement Custodial;

	@FindBy(id="SelectOtherInsurance")
	WebElement SelectOtherInsurance;


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

			if(utils.isvalueMatch_contain(key,"Other Insurance ID")){
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


}
