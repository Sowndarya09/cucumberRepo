package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderNotFound extends Driver{


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();

	public ProviderNotFound()

	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		System.out.println("provider Not found frame switched");
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;	

	@FindBy(xpath="//a[text()='NPI Registry']")
	private WebElement linkNPIRegistry;

	@FindBy(xpath="//a[text()='NEHP']")
	private WebElement linkNEHPRegistry;


	@FindBy(xpath ="//button[@title='Complete this assignment']")
	private WebElement btnSubmit;

	public WebElement getlinkNPIRegistry(){		
		return linkNPIRegistry;		
	}	
	public WebElement getlinkNEHPRegistry(){
		return linkNEHPRegistry;		
	}

	public WebElement getSubmitButton(){
		return btnSubmit;		
	}

	public boolean clicklinkNPIRegistry(){

		return utils.clickAnelemnt(this.getlinkNPIRegistry(), "ProviderNotFound", "linkNPIRegistry");
	}

	public boolean clicklinkNEHPRegistry(){

		return utils.clickAnelemnt(this.getlinkNEHPRegistry(), "ProviderNotFound", "linkNEHPRegistry");
	}

	public boolean clickSubmit(){

		return utils.clickAnelemnt(this.getSubmitButton(), "ProviderNotFound", "submit button");
	}


}
