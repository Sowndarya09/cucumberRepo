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

public class ResolveUpdateDemographics {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	public ResolveUpdateDemographics(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	@FindBy(xpath="//select[@id='ResolveUpdateAddressResponse']")
	WebElement resolveUpdateAddressResponse;

	@FindBy(id="pyNote")
	WebElement enterNotes;

	@FindBy(xpath="//div[text()='Submit']")
	WebElement SubmitButton;

	/**
	 * This method allows user to select response from Manager based on action performed for this Service Request from his end
	 * @param args
	 * @return
	 */
	public boolean selectResponse(String[] args)
	{
		action.moveToElement(resolveUpdateAddressResponse);
		return utils.selectDropDownbyVisibleString(resolveUpdateAddressResponse, args[0], "ResolveUpdateDemographics", "TeamResponseDrpDown");
	}
	/**
	 * This method allows user to enter some text in the notes box for letting the initiator to provide some additional information
	 * @param args
	 * @return
	 */

	public boolean enterNotes(String[] args)
	{
		return utils.enterTextinAnelemnt(enterNotes, args[0], "ResolveUpdateDemographics", "Enter text in Notes box");
	}
	/**
	 * This Method allows user to click the submit button present in Resolve update Demographics page
	 * @return
	 */


	public boolean clickOnSubmit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(SubmitButton, "ResolveUpdateDemographics", "SubmitButton");
	}



}



