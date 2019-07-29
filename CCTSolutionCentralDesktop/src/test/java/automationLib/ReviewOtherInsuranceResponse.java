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

public class ReviewOtherInsuranceResponse {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	public ReviewOtherInsuranceResponse(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	
	@FindBy(id="CSRReviewResponse")
	WebElement NextActionDrpDown;
	
	@FindBy(id="pyNote")
	WebElement NotesSection;
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;
	
	
	public boolean selectFromNextActionDrpdownAndEnterNotes(String[] args) {
		boolean flag = false;
		action.moveToElement(NextActionDrpDown);
		if(utils.selectDropDownbyVisibleString(NextActionDrpDown, args[0], "ReviewOtherInsuranceResponse", "NextActionDrpDown")) {
		if(utils.enterTextinAnelemnt(NotesSection, args[1], "ReviewOtherInsuranceResponse", "NotesSection")) {
		flag= utils.clickAnelemnt(SubmitButton, "ReviewOtherInsuranceResponse", "SubmitButton");
		}
	}
		if(flag) {
			blogger.loginfo("PASS: Next Action Dropdown selected, Notes entered in Notes Section and Submit is clicked");
			return true;
		}else {
			blogger.loginfo("FAIL: Next Action Dropdown not selected/Notes not entered in Notes Section/Submit is not clicked");
			return false;
		}
	}
	
	@FindBy(xpath="(//li[@title='Request Manager/OE Help'])[2]")
	WebElement RequestMgrHlpFrmReviewOtherInsurance;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	/**
	 *  This method clicks on the Request Manager/OE help from other actions on the  review other insurance response page
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectRequestManagerHelpFromOtherActions() throws InterruptedException
	{

		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Manager/OE Help", "ReviewOtherInsuranceResponse", "Request Manager/OE Help");
	}



}