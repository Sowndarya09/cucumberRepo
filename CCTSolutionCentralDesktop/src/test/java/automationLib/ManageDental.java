package automationLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ManageDental {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement2;

	public ManageDental()
	{

		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			System.out.println("mem comp constructor");
			{
				utils.refreshthepage();
			}
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
			System.out.println("mem comp frame sithced");
		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			System.out.println("mem comp constructor");
			{
				utils.refreshthepage();
			}
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			System.out.println("mem comp frame sithced");
		}
	}


	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Cancel this work')]")	
	WebElement lnkOthrActionsCancelWork;

	@FindBy(xpath="//a[@href='http://apps.decare.com/nav/login/login.jsp']")
	private WebElement dds_crmlink;

	@FindBy(xpath="//a[@href='https://callcare.wellpoint.com/dental']")
	private WebElement wdslink;

	@FindBy(xpath="//label[contains(text(),'Manage Dental')]")
	private WebElement sHeaderMD;




	/** Description:This method  click the cancel work from the other actions and submit the cancel work
	 * 
	 * @return
	 */
	public boolean clickCancelWorkAndCancelTheWork()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageDental", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsCancelWork, "ManageDental", "Cancel Work");
		return false;

	}
	/** Description:This functionality validates whether the DDS-CRM link is displayed in Manage Dental task page
	 * 
	 * @return
	 */

	public boolean verifyDDSCRMLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderMD, "Manage Dental")){
			System.out.println("Manage Dental page is loaded");
			return !utils.isProxyWebelement(dds_crmlink);

		}
		return false;
	}

	/** Description:This functionality validates whether the WDS link is displayed in Manage Dental task page
	 * 
	 * @return
	 */

	public boolean verifyWDSLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderMD, "Manage Dental")){
			System.out.println("Manage 	Dental page is loaded");
			return !utils.isProxyWebelement(wdslink);

		}
		return false;
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
