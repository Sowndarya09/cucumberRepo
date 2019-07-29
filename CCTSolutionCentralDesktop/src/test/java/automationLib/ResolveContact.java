package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ResolveContact {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement1;

	public ResolveContact(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}catch(Exception e) {
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}


	@FindBy(xpath="//Select[@id='PAResolutionOutcome']")
	WebElement PAResolutionOutcome;

	/**This functionality validate the user to select the dropdown values from select outcome of the contact in the Resolve contact page
	 *
	 */

	public boolean SelectOutcomeoftheContact(String[] Resolution)
	{
		System.out.println("Method is working now");
		if(utils.waitForElementToBeVisible(PAResolutionOutcome))
			return utils.selectDropDownbyVisibleString(PAResolutionOutcome, Resolution[0], "Resolve Contact", "PAResolutionOutcome");
		return false;

	}

	@FindBy(xpath="//input[@data-test-id='201509251329210606702338']")
	WebElement Email;

	/** This functionality validate the user to enter Email in the Resolve contact page
	 * 

	 */
	public boolean enterEmail(String[] email)
	{
		Email.clear();
		return utils.enterTextinAnelemnt(Email, email[0], "Resolve Contact", "Email");

	}

	/**This functionality validate the user to enter notes in the Resolve contact page
	 * 
	 */

	@FindBy(id="Notes")
	WebElement txtNotes;

	public boolean enterNotes(String[] Notes)
	{
		return utils.enterTextinAnelemnt(txtNotes, Notes[0], "ResolveTask", "Notes Entered");
	}


	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	/**Clicks on the Submit button in the Resolve Contact page
	 * 

	 */
	public boolean clickOnSubmit(){
			return utils.clickAnelemnt(this.btnSubmit, "ResolveOneDayGrievanceAndAppeals", "Submit button");
	}



}