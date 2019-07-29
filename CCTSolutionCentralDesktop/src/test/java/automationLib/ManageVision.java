package automationLib;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ManageVision {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement2;
	public ManageVision(){

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

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Cancel this work')]")	
	WebElement lnkOthrActionsCancelWork;

	@FindBy(xpath="//a[@href='https://www.eyemedvisioncare.com/groupmanagement/loginForm.emvc']")//To Be Corrected
	private WebElement eyemedlink;
	
	@FindBy(xpath="//a[@data-test-id='20180919141917013090641']")
	private WebElement BlueViewVision;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderMV;

	@FindBy(id="pySelected1")
	WebElement chckBxManageVision;



	/** Description:This functionality click the cancel work from the other actions and submit the cancel work
	 * 
	 * @return
	 */
	public boolean clickCancelWorkAndCancelTheWork()
	{

		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageVision", "Other Actions button"))

			return utils.clickAnelemnt(this.lnkOthrActionsCancelWork, "ManageVision", "Cancel Work");
		return false;
	}
	/** Description:This functionality validates whether the Eye Med link is displayed in Manage Vision task page
	 * 
	 * @return
	 */
	public boolean verifyEyeMedLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderMV, "Manage Vision")){
			System.out.println("Manage Vision page is loaded");
			return !utils.isProxyWebelement(eyemedlink);

		}
		return false;
	}
	
	public boolean verifyBlueViewVisionLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderMV, "Manage Vision")){
			System.out.println("Manage Vision page is loaded");
			if(!utils.isProxyWebelement(BlueViewVision))
				return utils.clickAnelemnt(BlueViewVision, "Manage Vision", "BlueViewVision");

		}
		return false;
	}
	
	public boolean clickOnSubmit() throws InterruptedException{
		Thread.sleep(5000);
		utils.scrolltomiddle();
		WebElement element = Driver.pgDriver.findElement(By.xpath("//*[@class='pzbtn-mid'][text()='Submit']"));
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", element);
		//		return utils.clickAnelemnt(this.btnSubmit,"ManageClaims","Submit Button");
		return true;
	}

	public boolean tagBlueViewVision() throws InterruptedException{
		utils.waitforpageload();
		if(utils.clickAnelemnt(chckBxManageVision, "Manage Vision", "Check Box")){
			clickOnSubmit();
			return true;
		}
		else return false;
		
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



