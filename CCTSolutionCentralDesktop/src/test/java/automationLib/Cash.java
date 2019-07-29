package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.SeleniumUtilities;

public class Cash {

	SeleniumUtilities utils= new SeleniumUtilities();
	
	public Cash() 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement submit;

	
	public boolean clickBtnSubmit()
	{
		return utils.clickAnelemnt(this.submit, "Cash", "Submit");
		
	}
	
	@FindBy(xpath="//*[text()='OnDemand']")
	WebElement linkOndemand;
	
	public boolean validateCashScreenAvailable(){
		
		return !utils.isProxyWebelement(linkOndemand);
	}
	
	
}

