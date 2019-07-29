package automationLib;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderVerifyClaimImage {
	
	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	public ProviderVerifyClaimImage()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement);
	}
	
	@FindBy(xpath="//*[@data-test-id='20160322220747064557314']")
	List<WebElement> AllOptionsItem;
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;

	/**This functionality selects all the  the options from the Verify Claim Image Page and Submit
	 * 
	 * @return
	 */
	public boolean selectAllOptionsAndSubmit() {
		boolean flag;
		for(WebElement item:AllOptionsItem) {
			flag = utils.clickAnelemnt(item, "VerifyClaimImage", "AllOptionsItem");
			if(!flag)
				return false;
		}
		return utils.clickAnelemnt(SubmitButton, "VerifyClaimImage", "SubmitButton");
	}
}
