package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.SeleniumUtilities;

public class Broker_CancelThisWork {

	SeleniumUtilities utils = new SeleniumUtilities();


	public Broker_CancelThisWork(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="CancellationReason")
	WebElement Cancelreasondropdown;
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement Submit;

	public boolean verifyOptionsInCancellationReasonDropDown(String[] args){
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		for(String Values :args)
			valuestobechecked.add(Values);
return utils.checkvaluesinDropDown(Cancelreasondropdown, valuestobechecked);
	}
	
	public boolean clickSubmit(){
		return utils.clickAnelemnt(Submit, "Broker_CancelThisWork", "Submit");
	}
	
}
