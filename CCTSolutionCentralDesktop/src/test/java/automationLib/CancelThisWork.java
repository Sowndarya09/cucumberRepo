package automationLib;

import java.util.List;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CancelThisWork {
	
	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	
	public CancelThisWork() {

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		utils.gotoLastIframe(iframes);
	}
		
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions ') or contains(text(),'Other Actions ')]")
	WebElement btnOtherActions;
	
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;
	
	@FindBy(id="CancellationReason")
	WebElement drpdwnCancellationreason;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	
	/**Cancels Work and submit the task
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean cancelThisWork() throws InterruptedException{
		utils.scrolltoright();
		if(utils.clickAnelemnt(btnOtherActions, "Cancel this Work", "Other Actions Button"))
			if(utils.clickAnelemnt(lnkOtherCancelThisWork, "Cancel this Work", "Cancel this Work"))
				if(utils.selectDropDownbyIndex(drpdwnCancellationreason, 1, "Cancel this Work", "Cancel reason"))
					if(utils.clickAnelemnt(btnSubmit, "Cancel this Work", "Submit button on cancel billing"))
						return isMemberCompositeReached();
		return false;
	}
	
	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;
	
	public boolean isMemberCompositeReached(){
		utils.waitforpageload();
		try {
			utils.gotoLastIframe(iframes);
		} catch (UnhandledAlertException e) {
			err.logError(e, "unhandled  alert error in switiching frame");
			e.printStackTrace();
		}
		return !utils.isProxyWebelement(tabMbrCompositeMember);

	}
	@FindBy(xpath="//select[@id='CancellationReason']")
	WebElement CancellationReason;
	@FindBy(xpath="//option[text()='Unable to verify member']")
	WebElement UnableToVerifyMemeber;
   public boolean validateUnableToVerifyMemeberOption()
   {
	utils.clickAnelemnt(CancellationReason, "Cancel this Work", "CancellationReason");
	return !utils.isProxyWebelement(UnableToVerifyMemeber);
   }
}
