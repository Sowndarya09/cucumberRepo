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

public class ProviderManageOtherInsurance {

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
	public ProviderManageOtherInsurance() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}



	@FindBy(xpath="//div[@node_name='pyCaseActionAreaButtons']//div[contains(text(),'Submit')]")
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

	public boolean clickAddButtonInProviderOtherInsuarnce()
	{
		return utils.clickAnelemnt(clickAddButton, "ManageOtherInsurance", "clickAddButton");
	}


}
