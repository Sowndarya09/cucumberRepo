package automationLib;

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


public class ManageEmployeeAssitanceProgram {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement2;

	public ManageEmployeeAssitanceProgram(){

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try
		{
			utils.refreshthepage();
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
			System.out.println("mem comp frame sithced");
		}catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			System.out.println("mem comp frame sithced");
		}
	}

	@FindBy(xpath="//a[contains(text(),'Manage Employee Assistance Program')]")
	WebElement labelManageEmployeeAssistanceProgram;

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Cancel this work')]")	
	WebElement lnkOthrActionsCancelWork;

	@FindBy(xpath="//a[@href='http://va10pwviss308/eap']")
	private WebElement eap_atracklink;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderMEAP;

	@FindBy(id="pySelected1")
	WebElement checkbox;

	/** Description:This method navigated to Manage Employee Assistance Program page by clicking Manage Employee Assistance Program in Consumer services tab in Add task page
	 * 
	 * @return
	 */
	public boolean navigateToManageEmployeeAssistanceProgram()
	{
		return utils.clickAnelemnt(this.labelManageEmployeeAssistanceProgram, "ManageEmployeeAssitanceProgram", "Manage Employee Assistance Program");
	}

	/** Description:This method  click the cancel work from the other actions and submit the cancel work
	 * 
	 * @return
	 */
	public boolean clickCancelWorkAndCancelTheWork()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageEmployeeAssitanceProgram", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsCancelWork, "ManageEmployeeAssitanceProgram", "Cancel Work");
		return false;
	}

	/** Description:This functionality validates whether the EAP-ATRACK link is displayed in Manage Employee Assitance Program task page
	 * 
	 * @return
	 */
	public boolean verifyEAPATrackLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderMEAP, "Manage Employee Assistance Program"))
		{
			System.out.println("Manage Employee Assistance Program page is loaded");
			return !utils.isProxyWebelement(eap_atracklink);

		}
		return false;
	}
	@FindBy(xpath="//*[text()='Specialty System Link']/ancestor::div[@id='RULE_KEY']//*[text()='Submit']")
	WebElement SubmitButton;

	@FindBy(xpath="//*[text()='Specialty System Link']/ancestor::table[@id='gridLayoutTable']")
	WebElement EmployeeAssistanceProgramTable;

	/**This functionality selects the checkbox based on the values by getting the input value from the user and submit
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectCheckboxBasedOnValues(String[] args) throws InterruptedException{
		WebElement rowNo = utils.returntablerowbasedonvalues(EmployeeAssistanceProgramTable, args);
		List<WebElement> row = rowNo.findElements(By.tagName("input"));
		row.get(1).click();
		return utils.clickAnelemnt(SubmitButton,"ManageEmployeeAssitanceProgram", "SubmitButton");
	}

	@FindBy(id="DialogContent")
	WebElement DialogContent;

	public boolean ValidateGuidedDialog() {
		return utils.validateLabel(DialogContent, "We will be developing this area, but please use the links below to complete your tasks.");
	}

	@FindBy(xpath="//*[@data-test-id='20180919140911009492961']")
	WebElement DescriptionMessage;

	public boolean ValidateDescriptionMessage(String[] args) {
		return utils.isvalueMatch_contain(DescriptionMessage.getText().replaceAll(",", ""), args[0]);
	}

}


