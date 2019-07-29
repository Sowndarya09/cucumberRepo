package automationLib;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderLimitedLiabilityReview extends Driver
{

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Update Limited Liability']")	
	private WebElement lnkOtherUpdtLL;

	public ProviderLimitedLiabilityReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Accumulators acc=new Accumulators();
	Actions action=new Actions(Driver.getPgDriver());

	/**Navigates to Update Limited Liability
	 * 
	 * @return
	 */
	public boolean navigatetoUpdateLimitedLiability()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Limited LiabilityLiability", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherUpdtLL, "Limited Liability Review", "Update Limited Liability"))
				return true;
		return false;

	}

}
