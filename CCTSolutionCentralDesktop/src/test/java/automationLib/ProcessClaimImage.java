package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProcessClaimImage {
	
	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	public ProcessClaimImage()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement);
	}

	@FindBy(id="ReasonforContact")
	WebElement ReasonforContact;
	
	/**This functionality Selects the reason for Contact options from the dropdown
	 * 
	 * @return
	 */
	public boolean reasonForContact(String[] args) {
		return utils.selectDropDownbyVisibleString(ReasonforContact, args[0], "ProcessClaimImage", "ReasonforContact");
	}
	
	@FindBy(id="RequestedAction")
	WebElement RequestedAction;
	
	/**This functionality Selects the Requested action options from the dropdown
	 * 
	 * @return
	 */
	public boolean requestedAction(String[] args) {
		return utils.selectDropDownbyVisibleString(RequestedAction, args[0], "ProcessClaimImage", "RequestedAction");
	}
	
	@FindBy(id="ReasonForUrgency")
	WebElement ReasonForUrgency;
	
	/**This functionality validates the reason for urgency dropdown options are available or not
	 * 
	 * @return
	 */
	public boolean ValidateReasonForUrgencyDropDownValuses(String[] args) {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		for(String value:args) {
			valuestobechecked.add(value);
		}
		return utils.checkvaluesinDropDown(ReasonForUrgency, valuestobechecked);
	}
	
	@FindBy(id="ClaimKeyed")
	WebElement ClaimKeyed;
	
	@FindBy(id="pyNote")
	WebElement Note;
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;
	
	/**Selects the Claim keyed, enter notes and click on submit
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectClaimKeyedEnterNotesAndSubmit() throws InterruptedException {
		if(utils.selectDropDownbyIndex(ClaimKeyed, 2, "ProcessClaimImage", "ClaimKeyed"))
			if(utils.enterTextinAnelemnt(Note, "Test", "ProcessClaimImage", "Note"))
				return utils.clickAnelemnt(SubmitButton, "ProcessClaimImage", "SubmitButton");
		return false;
	}
	
	
}
