package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ManageAlerts{

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget0Ifr")
	WebElement Iframeelement;

	public ManageAlerts(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(xpath="//img[contains(@alt,'Loading..')]")
	private WebElement LoadingIcon;

	@FindBy(xpath="//div[@class='tStrCntr']//ul[contains(@class,'headerTabsList')]")
	private WebElement adminTabHdr;

	

	@FindBy(xpath="//div[@class='header-content']//span[@role='heading']")
	private WebElement manageSearchAddUpdtHdr;

	@FindBy(xpath="//a[text()='+ Create New Alert']")
	WebElement CreateNewAlertLink;
	
	public boolean clickOnAddAlert(){
		return utils.clickAnelemnt(CreateNewAlertLink, "ManageAlerts", "CreateNewAlertLink");
	}
	
	
}
