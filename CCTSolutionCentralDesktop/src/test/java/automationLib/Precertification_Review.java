package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class Precertification_Review
{
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());



	public Precertification_Review()
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

	@FindBy(id="ReasonForContact")
	WebElement ReasonForContact;
	
	public boolean SelectReasonforContact(String[] args) {
		return utils.selectDropDownbyVisibleString(ReasonForContact, args[0], "Precertification_Review", "ReasonForContact");
	}
	
	@FindBy(xpath="//*[text()='Submit']")	
	WebElement SubmitButton;

	public boolean ClickSubmit() {
		return utils.clickAnelemnt(SubmitButton, "PreCertification_Search", "SubmitButton");
	}
	

	@FindBy(xpath="//img[@src='webwb/tool_icon_13690228252.png!!.png']")
	WebElement wrenchicon;
	public boolean validateWrenchIconIsNotPresent()
	{
		return utils.isProxyWebelement(wrenchicon);
	}
	public boolean validateWrenchIconIsPresent()
	{
		return !utils.isProxyWebelement(wrenchicon);
	}
   

}
