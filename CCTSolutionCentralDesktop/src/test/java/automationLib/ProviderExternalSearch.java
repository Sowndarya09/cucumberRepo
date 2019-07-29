package automationLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.SeleniumUtilities;

public class ProviderExternalSearch {
SeleniumUtilities utils= new SeleniumUtilities();
	
	public ProviderExternalSearch() 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderES;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyExternalSearchPage
	 * #Description:This method verifies if user is on External Search page.
	 * Type:TextBox
	 */
	public boolean validateProviderExternalsearchScreenIsAvailable() throws InterruptedException{
		utils.waitforpageload();
		return utils.validateHeader(this.sHeaderES, "External Search");
	}
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickbtnSubmit
	 * Type:Textbox

	 */

	public boolean clickbtnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "External Search", "submit btn");
	}
}
