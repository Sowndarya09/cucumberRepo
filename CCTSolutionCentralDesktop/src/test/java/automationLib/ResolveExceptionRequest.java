package automationLib;
import java.util.List;
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
public class ResolveExceptionRequest {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;	
	

	public ResolveExceptionRequest(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try {
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
		}catch(Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);	
		}
	}
	
	@FindBy(xpath="//textarea[@data-test-id='201603070136470880108291']")
	private WebElement enternotes;
	
	@FindBy(xpath="//div[contains(text(), 'Approve')]")
	private WebElement approve;
	
	public boolean enterNotes(String arg[])
	{
		return utils.enterTextinAnelemnt(this.enternotes, arg[0], "ResolveExceptionRequest", "notes");
	}
	
	public boolean clickOnApprove()
	{
		((JavascriptExecutor) Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);", approve);		
		return utils.clickAnelemnt(this.approve, "ResolveExceptionRequest", "click");
	}
	
	
	
}
