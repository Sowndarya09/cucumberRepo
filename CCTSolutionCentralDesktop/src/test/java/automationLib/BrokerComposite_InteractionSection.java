package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerComposite_InteractionSection {


	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();

	WebDriverWait wait;
	
	public BrokerComposite_InteractionSection()
	
	{
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			if(utils.isAlertPresent())
			{
				Driver.pgDriver.switchTo().alert().accept();
			}
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);

		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement); 
		}
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Recent Inquiry Tracking')]")
	WebElement labelRecentInquiryTracking;
	
	@FindBy(xpath="//span[contains(text(),'Related/Linked Interactions')]")
	WebElement labelRelatedInteractions;
	
	@FindBy(xpath="//span[contains(text(),'Search for Service Requests for Contract')]")
	WebElement labelSearchForServiceRequest;
	
	
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	
	public boolean verifySearchForServiceRequestsForContractIsNotDispalyed()
	{
		return utils.isProxyWebelement(labelSearchForServiceRequest);
	}
	
	public boolean verifyRelatedLinkedInteractionsIsNotDispalyed()
	{
		return utils.isProxyWebelement(labelRelatedInteractions);
	}
	
	
	
}
