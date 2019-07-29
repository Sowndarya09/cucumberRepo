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

public class RefundRequestReview {

	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	
	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement;

	
	public RefundRequestReview()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	@FindBy(xpath="//select[@id='ReasonForContact']")
	private WebElement ReasonForContact ;
	
	public boolean selectReasonForContact(String[] args){
			return utils.selectDropDownbyVisibleString(ReasonForContact, args[0], "RefundRequestReview", "Reason for Contact");   
	}
	
	@FindBy (xpath="//button[@title='Complete this assignment']//div[text()='Submit']")	
	private WebElement Clicksubmit;
	
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(Clicksubmit, "RefundRequestReview", "Submit");
	}
		
		
}
