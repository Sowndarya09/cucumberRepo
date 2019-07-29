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

public class ManageOtherInsurance {

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
	public ManageOtherInsurance() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateAndReviewLimitedLiability
	 * #Description: This functionality clicks the COB Indicator, MED Indicator, and then performs submit and then validate the review Limited Liability[COB and Medicare only]
	 * Type:Text
	 */
	public boolean validateAndReviewLimitedLiability(){
		if(utils.clickAnelemnt(this.cobCheckBox, "Manage Other Insurance", "COB Indicator"))
			if(utils.clickAnelemnt(this.medCheckBox, "Manage Other Insurance", "MED Indicator"))
				if(utils.clickAnelemnt(this.submit, "Manage Other Insurance", "Submit"))
					if(this.COBLink.isDisplayed() && this.MEDLink.isDisplayed())
						if(utils.clickAnelemnt(this.COBLink, "Manage Other Insurance", "COB Link"))
							if(utils.clickAnelemnt(this.MEDLink, "Manage Other Insurance", "MED Link"))
								return true;
		return false;
	}

	@FindBy(xpath="//div[@node_name='pyCaseActionAreaButtons']//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	/*
	 * @SCU
	 * #CommonMethodWithSArgument: clickTheTypeInViewOtherInsurance
	 * #Description: This functionality performs click action on the User Specified type chcekbox in the insurance page
	 * #Argument: type
	 * Type: Textbox 
	 */
	public boolean clickTheTypeInViewOtherInsurance(String[] args)
	{ 
		boolean returnvar =true;
		String type= null,effdate= null,enddate = null,reasoncode= null,desc= null;
		ArrayList<String> expected= new ArrayList<String>();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("clickTheTypeInViewOtherInsurance", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("type"))
			{                    
				returnvar=true;
				type=value.toLowerCase().trim();                      
				continue;
			}
			else if(key.toLowerCase().contains("effective date"))
			{
				returnvar=true;
				effdate=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddate=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("reason code"))
			{
				returnvar=true;
				reasoncode=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("description"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;      
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}

		try{

			WebElement row =utils.getAccumulatortablerowbasedonvalues(this.tblViewOtherInsurance,args);
			List<WebElement> expand = row.findElements(By.tagName("td"));
			expand.get(0).click();
			List<WebElement> chckBoxes = row.findElements(By.tagName("input"));
			chckBoxes.get(1).click();
			//chckBoxes.get(3).click();
			System.out.println(row.getAttribute("pl_index"));
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{
			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click on the submit button on the View Insurance page
	 * Type: Textbox
	 */

	public boolean clickOnSubmit()
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

	public boolean clickAddButton()
	{
		return utils.clickAnelemnt(clickAddButton, "ManageOtherInsurance", "clickAddButton");
	}







}
