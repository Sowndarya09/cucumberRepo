package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ReportProviderNetworkIssue {

	public ReportProviderNetworkIssue() throws IOException{
		
	PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	if(!utils.checkIfErrorPage())
	{
		utils.refreshthepage();
	}
	Driver.getPgDriver().switchTo().defaultContent();
	Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
}

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(xpath="//a[text()='Consumer Account Database (CAD)']")
	WebElement lnkCAD;
	
	@FindBy(xpath="//a[text()='ePact']")
	WebElement lnkEPact;
	
	@FindBy(xpath="//a[text()='Provider Finder Xpress']")
	WebElement lnkProviderFinderExpress;
	
	public boolean verifyCADLinkIsPresent()
	{
		return !utils.isProxyWebelement(lnkCAD);
	}
	
	public boolean verifyePactLinkIsPresent()
	{
		return !utils.isProxyWebelement(lnkEPact);
	}
	
	public boolean verifyProviderFinderXpressLinkIsPresent()
	{
		return !utils.isProxyWebelement(lnkProviderFinderExpress);
	}

	
}
