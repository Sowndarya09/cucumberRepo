package automationLib;

import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumUtilities;

public class ProviderManageBilling extends Driver{

	SeleniumUtilities utils= new SeleniumUtilities();

	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 * @throws IOException 
	 */
	public ProviderManageBilling() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		waitforTransactionload();
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		System.out.println("frame switched");
	}


	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;	

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	public boolean clickOnSubmit()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(this.btnSubmit, "ProviderManageBilling ", "Submit button ")	;
	}

	public boolean waitforTransactionload()
	{
		try{
			Thread.sleep(2000);
			System.out.println("Checking if Loading icon is present");
			wait=new WebDriverWait(Driver.getPgDriver(),90);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
		}
		catch(Exception e){
			System.out.println("Loading icon exceeded time out ");

		}
		System.out.println("Came out");
		return true;
	}




}
