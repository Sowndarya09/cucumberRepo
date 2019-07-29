package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;
/**
 * Cancel Payment class 
 * @author AF02876
 *
 */
public class CancelPayment {

	/**
	 * Methods in the Program 
	 */
	DataSet ds=new DataSet();
	ErrorLogger err= new ErrorLogger();
	BaseLogger blog= new BaseLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public CancelPayment() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	@FindBy(className="actionTitleBarLabelStyle")
	WebElement labelManageBillingCancelPaymentTitle;


	@FindBy(xpath="//table[@class='gridTable '][contains(@pl_prop,'TaggedItems')]")
	private WebElement tableItemsDiscussedDuringManageBillingReview;

	@FindBy(xpath="//span[text()='Items Discussed During Manage Billing Review']")
	WebElement lableManageBillingCancelPaymentItemsDiscussed;

	@FindBy(xpath="//*[text()='Items Discussed During Manage Enrollment & Billing Review']")
	private WebElement lnktxtItemsDiscussedManageBillingReview;

	@FindBy(xpath="//div[@node_name='ReviewTaggedItems']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableManageBillingCancelPaymentReview;

	@FindBy(xpath="//a[text()='Client Console (CSI)']")
	WebElement linkManageBillingCancelPaymentClientConsole;

	public ErrorLogger getErr() {
		return err;
	}

	public SeleniumUtilities getUtils() {
		return utils;
	}

	public WebElement getsHeaderCompleteBilling() {
		return sHeaderCompleteBilling;
	}

	public WebElement getIframeelement() {
		return Iframeelement;
	}

	public WebElement getLabelManageBillingCancelPaymentTitle() {
		return labelManageBillingCancelPaymentTitle;
	}

	public WebElement getLableManageBillingCancelPaymentItemsDiscussed() {
		return lableManageBillingCancelPaymentItemsDiscussed;
	}

	public WebElement getTableManageBillingCancelPaymentReview() {
		return tableManageBillingCancelPaymentReview;
	}

	public WebElement getLinkManageBillingCancelPaymentClientConsole() {
		return linkManageBillingCancelPaymentClientConsole;
	}

	/**
	 * Checking HEader of the Page 
	 * @param header
	 * @return
	 */
	public boolean validateHeader(WebElement header , String sCheckHEader)
	{
		if(header.isDisplayed())
		{
			String lcsCheckHEader=sCheckHEader.toLowerCase();
			if(header.getText().trim().toLowerCase().contains(lcsCheckHEader))
			{
				System.out.println("Pass : The header "+header+" matches the specks and is displayed as required. \n\n");
				return true ;
			}
		}
		err.logError("The header does not match the specified text.");
		return false; 
	}


	public boolean clickgetBtnSubmit()
	{
		return utils.clickAnelemnt(this.getBtnSubmit(), "Complete Villing Review ", "Text Box for entering ?Notes");
	}
	
	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="//div[@title='Hide Items Discussed During Manage Enrollment & Billing Review']//i")
	WebElement lableManageBillingCancelPaymentItemsDiscussed3;

	public boolean checkCancelPaymentPage()
	{
		utils.waitforpageload();
		if(this.linkManageBillingCancelPaymentClientConsole.isDisplayed())
			if(utils.clickAnelemnt(lnktxtItemsDiscussedManageBillingReview,"Cancel Payment","view items discussed link"))
				if(!utils.isProxyWebelement(tableItemsDiscussedDuringManageBillingReview))
					if(this.clickgetBtnSubmit())
					{
						System.out.println("Pass : Successfully Submitted the Cancel Payment page after validating the details");
						return true;
					}
		return false;
	}



	public boolean validateTaggedcheckboxes() throws InterruptedException{
		Thread.sleep(1000); 
		ArrayList<String> actual = null,expected=new ArrayList<String>(); 

		if(utils.clickAnelemnt(this.lnktxtItemsDiscussedManageBillingReview, "Complete Billing", "Items Discussed"))
			utils.waitforpageload();
		actual=utils.getcolumnStringFromTableByName(this.tableItemsDiscussedDuringManageBillingReview,"Description");
		actual.remove(0);

		expected = ManageBilling.BillsAndLettersValue;

		Collections.reverse(expected);

		for(int i=0;i<actual.size();i++)
		{

			if(actual.get(i).equalsIgnoreCase(expected.get(i)))
			{
				blog.loginfo("actual value is " +actual.get(i)+ " ,Expected value is" +expected.get(i));
				continue;
			}
			else
				return false;
		}

		return true;
	}






}
