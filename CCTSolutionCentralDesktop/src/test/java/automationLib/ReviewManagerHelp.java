package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ReviewManagerHelp {

	/**
	 * Methods in the Program
	 */
	DataSet ds = new DataSet();
	ErrorLogger err = new ErrorLogger();
	SeleniumUtilities utils = new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	// Changes to the Heading HEader
	@FindBy(className = "actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id = "PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(id = "PegaGadget1Ifr")
	private WebElement Iframeelement1;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and
	 * the Page Factory
	 */
	public ReviewManagerHelp() throws IOException {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}
	}


	
	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Submit')]")
	private WebElement btnSubmit;

	/**
	 * Clicks the Submit button in the Review Manager Help page
	 * @return
	 */
	public boolean clickOnSubmit(){
		
		WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@class='pzbtn-mid'][contains(text(),'Submit')]"));
	   	((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(btnSubmit,"RequestManagerHelp","Submit Button");

	}

	
	 
	
	

}
