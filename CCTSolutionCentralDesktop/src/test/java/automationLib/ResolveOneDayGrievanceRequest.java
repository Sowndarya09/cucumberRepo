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

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ResolveOneDayGrievanceRequest {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement1;

	public ResolveOneDayGrievanceRequest(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
	}


	@FindBy(name="$PpyWorkPage$pGrievanceNextAction")
	WebElement drpDownSelectNextAction;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	public boolean selectValueFromSelectNextActionDropDown(String[] args)
	{
			return utils.selectDropDownbyVisibleString(drpDownSelectNextAction, args[0], "ResolveOneDayGrievanceAndAppeals", "Select Next Action");
	}
	
	@FindBy(xpath="//textarea[@data-test-id='201510091322310162184450']")
	WebElement txtNotes;
	
	public boolean enterNotes() {
		return utils.enterTextinAnelemnt(txtNotes, "Notes", "Grievance and Appeal", "Notes");	
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method allows the user to click on Submit in Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
			return utils.clickAnelemnt(this.btnSubmit, "ResolveOneDayGrievanceAndAppeals", "Submit button");
	}





	}