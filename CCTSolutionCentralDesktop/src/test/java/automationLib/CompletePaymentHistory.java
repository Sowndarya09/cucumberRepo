package automationLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;


/**
 * Complete History page 
 * @author Shardul Negi 
 *
 */
public class CompletePaymentHistory {

	/**
	 * Methods in the Program 
	 */

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCompletePaymentHistory;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public CompletePaymentHistory()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	@FindBy(linkText="Submit")
	private WebElement btnSubmit;
	@FindBy(id="CcbLogEventYes")
	private WebElement rdbtnCCBLaunchEventLogEvent;
	@FindBy(id="CcbLogEventNo")
	private WebElement rdbtnCCBLaunchEventViewMemberShip;

	@FindBy(xpath="//div[@class='pzbtn-mid'][text()='Launch CCB']")
	private WebElement btnLaunchCCB;

	@FindBy(xpath="//select[@id='CcbLocationName']")
	private WebElement dropDownLocationName;

	@FindBy(id="CcbOperatorId")
	private WebElement txtbxCCBOPeratorID;

	public WebElement getsHeaderCompletePaymentHistory() {
		return sHeaderCompletePaymentHistory;
	}

	public WebElement getRdbtnCCBLaunchEventLogEvent() {
		return rdbtnCCBLaunchEventLogEvent;
	}

	public WebElement getRdbtnCCBLaunchEventViewMemberShip() {
		return rdbtnCCBLaunchEventViewMemberShip;
	}

	public WebElement getBtnLaunchCCB() {
		return btnLaunchCCB;
	}

	public WebElement getDropDownLocationName() {
		return dropDownLocationName;
	}

	public WebElement getTxtbxCCBOPeratorID() {
		return txtbxCCBOPeratorID;
	}

	public boolean validateHeader(WebElement header, String sHeaderName)
	{
		return utils.validateLabel(header, sHeaderName);
	}

	public boolean clickgetBtnSubmit()
	{
		return utils.clickAnelemnt(this.getBtnSubmit(), "Complete Payment History", "Button clicked for Submit");
	}

	public boolean clickgetRdbtnCCBLaunchEventLogEvent()
	{
		System.out.println("Enter Complete Payment History");
		return utils.clickAnelemnt(this.getRdbtnCCBLaunchEventLogEvent(), "Complete Payment History", "Button clicked for Submit");
	}
	public boolean clickgetRdbtnCCBLaunchEventViewMemberShip()
	{
		return utils.clickAnelemnt(this.getRdbtnCCBLaunchEventViewMemberShip(), "Complete Payment History", "Button clicked for Submit");
	}
	public boolean clickgetBtnLaunchCCBOperator()
	{
		return utils.clickAnelemnt(this.getBtnLaunchCCB(), "Complete Payment History", "Button clicked for Launch CCB Operator");
	}

	public boolean setTxtCCBOperatorID(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtbxCCBOPeratorID(), sFullName, "Complete Payment History", "CCB Operator ID text Box");
	}

	public boolean selectDropDownInsuranceCarriersContactRoleTab(int iDropdownSelect) throws InterruptedException, AWTException
	{

		this.getTxtbxCCBOPeratorID().click();
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		utils.pressDownnTimes(iDropdownSelect);
		robot.keyPress(KeyEvent.VK_ENTER);
		return true;
	}

	public boolean navigateToCompletePaymentHistoryandSubmitLogEvent() throws InterruptedException, AWTException
	{
		if(this.validateHeader(this.getsHeaderCompletePaymentHistory(), "Complete Payment History"))
			if(this.clickgetRdbtnCCBLaunchEventLogEvent())
				if(this.clickgetRdbtnCCBLaunchEventViewMemberShip())
					if(this.setTxtCCBOperatorID("p480"))
						if(this.selectDropDownInsuranceCarriersContactRoleTab(1))
							if(this.clickgetBtnLaunchCCBOperator())
								return this.clickgetBtnSubmit();		
		return false;
	}

}
