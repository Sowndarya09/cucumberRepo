package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

/**
 * Methods for Accept Payment Page 
 * @author AF02876
 * test
 */

public class AcceptPayment {


	/**
	 * Methods in the Program 
	 * test
	 */
	DataSet ds=new DataSet();
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();


	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteBilling;

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public AcceptPayment() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(className="actionTitleBarLabelStyle")
	WebElement labelManageBillingAcceptPaymentTitle;

	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Billing Review']")
	private WebElement lnktxtItemsDiscussedManageBillingReview;

	@FindBy(xpath="//span[text()='Items Discussed During Manage Billing Review']")
	WebElement lableManageBillingAcceptPaymentItemsDiscussed;

	@FindBy(xpath="//div[@node_name='ReviewTaggedItems']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableManageBillingAcceptPaymentReview;

	@FindBy(xpath="//a[text()='Client Console (CSI)']")
	WebElement linkManageBillingAcceptPaymentClientConsole;

	@FindBy(xpath="//table[@class='gridTable '][contains(@pl_prop,'TaggedItems')]")
	private WebElement tableItemsDiscussedDuringManageBillingReview;

	public ErrorLogger getErr() {
		return err;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	public SeleniumUtilities getUtils() {
		return utils;
	}

	public WebElement getsHeaderCompleteBilling() {
		return sHeaderCompleteBilling;
	}

	public WebElement getIframeelement() {
		return Iframeelement;
	}

	public WebElement getLabelManageBillingAcceptPaymentTitle() {
		return labelManageBillingAcceptPaymentTitle;
	}

	public WebElement getLableManageBillingAcceptPaymentItemsDiscussed() {
		return lableManageBillingAcceptPaymentItemsDiscussed;
	}

	public WebElement getTableManageBillingAcceptPaymentReview() {
		return tableManageBillingAcceptPaymentReview;
	}

	public WebElement getLinkManageBillingAcceptPaymentClientConsole() {
		return linkManageBillingAcceptPaymentClientConsole;
	}


	/**
	 * Validate header of the page
	 * @param header
	 * @return
	 */
	public boolean validateHeader(WebElement header , String sCheckHEader)
	{
		String lcsCheckHEader=sCheckHEader.toLowerCase();
		return utils.validateHeader(header, lcsCheckHEader);
	}

	/**Clicks on Submit button
	 * @return
	 */
	public boolean clickgetBtnSubmit()
	{
		return utils.clickAnelemnt(this.getBtnSubmit(), "Complete Villing Review ", "Text Box for entering ?Notes");
	}

	@FindBy(xpath="//div[@title='Hide Items Discussed During Manage Enrollment & Billing Review']//i")
	WebElement lableManageBillingCancelPaymentItemsDiscussedHide;

	/**This functionality validates that if the user is in accept payment page with Client Console link 
		displayed and user clicks the Items discussed link and performs submit*/
	public boolean checkAcceptPaymentPage() throws InterruptedException
	{
		utils.waitforpageload();
		if(this.validateHeader(this.getLabelManageBillingAcceptPaymentTitle(), "Accept Payment"))
			if(this.linkManageBillingAcceptPaymentClientConsole.isDisplayed())
				return clickgetBtnSubmit();
		return false;
	}

	@FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']//i")
	WebElement lableShowManageBillingCancelPaymentItemsDiscussed;


	/**This functionality clicks the complete billing and get all the values from the table
	 * 
	 * @return
	 */
	public boolean validateTaggedcheckboxes()
	{
		utils.waitforpageload();
		ArrayList<String> actual = null,expected=new ArrayList<String>(); 
		if(utils.clickAnelemnt(this.lableShowManageBillingCancelPaymentItemsDiscussed, "Complete Billing", "Items Discussed"))
			utils.waitforpageload();	
		actual=utils.getcolumnStringFromTableByName(this.tableItemsDiscussedDuringManageBillingReview,"Description");
		actual.remove(0);
		for(Map.Entry<String, String> entry:ds.data.entrySet())
			expected.add(entry.getValue());
		Collections.reverse(expected);
		for(int i=0;i<actual.size();i++)
		{
			if(actual.get(i).equalsIgnoreCase(expected.get(i)))
				continue;
			else
				return false;
		}
		utils.takescreenshot("Validate Tagged Checkboxes");
		return utils.clickAnelemnt(lableManageBillingCancelPaymentItemsDiscussedHide, "Accept payment", "Hide items discussed link");
	}
}
