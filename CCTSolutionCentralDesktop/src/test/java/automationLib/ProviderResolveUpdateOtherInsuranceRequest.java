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

public class ProviderResolveUpdateOtherInsuranceRequest {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	public ProviderResolveUpdateOtherInsuranceRequest(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(xpath="//*[@data-test-id='20180104033407088518136']")
	WebElement EffDate;

	@FindBy(xpath="//*[@data-test-id='20180402144743056438671']")
	WebElement ReasonForTermination;

	public boolean verifyUpdateOtherInsRequest(String[] args) {
		if(utils.validateLabel(EffDate, args[0]))
			return utils.validateLabel(ReasonForTermination, args[1]);
		return false;

	}

	@FindBy(id="COBTeamResponse")
	WebElement TeamResponseDrpDown;

	@FindBy(id="pyNote")
	WebElement NotesSection;

	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;


	public boolean selectCOBorMedTeamResponse(String[] args) {
		boolean flag = false;
		action.moveToElement(TeamResponseDrpDown);
		if(utils.selectDropDownbyVisibleString(TeamResponseDrpDown, args[0], "ResolveUpdateOtherInsuranceRequest", "TeamResponseDrpDown")) 
			if(utils.enterTextinAnelemnt(NotesSection, args[1], "ResolveUpdateOtherInsuranceRequest", "NotesSection"))
				return utils.clickAnelemnt(SubmitButton, "ResolveUpdateOtherInsuranceRequest", "SubmitButton");
		return false;

	}

}