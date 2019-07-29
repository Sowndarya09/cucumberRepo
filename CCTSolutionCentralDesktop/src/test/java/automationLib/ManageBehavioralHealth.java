package automationLib;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ManageBehavioralHealth {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement2;

	public ManageBehavioralHealth(){

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

	@FindBy(xpath="//a[@href='https://webhrs.antheminc.com/hrs2-web/']")//To Be Corrected
	private WebElement bhrc_hrslink;

	@FindBy(className="actionTitleBarLabelStyle")//To Be corrected
	private WebElement sHeaderMB;



	/** Description:This method  click the cancel work from the other actions and submit the cancel work
	 * 
	 * @return
	 */
	public boolean clickCancelWorkAndCancelTheWork()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageBehavioralHealth", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsCancelWork, "ManageBehavioralHealth", "Cancel Work");
		return false;
	}
	/** Description:This functionality validates whether the BHRC-HRS link is displayed in Manage Behavioral Health task page
	 * 
	 * @return
	 */
	public boolean verifyBHRCHRSLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderMB, "Manage Behavioral Health")){
			System.out.println("Manage Behavioral Health page is loaded");
			return !utils.isProxyWebelement(bhrc_hrslink);

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
