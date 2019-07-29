package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.SeleniumUtilities;

public class DisputeBenefit {

	SeleniumUtilities utils=new SeleniumUtilities();
	public DisputeBenefit() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//li[@title='Access Documents']")	
	private WebElement lnkOthrActionsAccessDocuments;

	public boolean navigatetoAccessDocuments()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			return (utils.clickAnelemnt(this.lnkOthrActionsAccessDocuments, "Billing Review", "Links"));
		return false;
	}

}
