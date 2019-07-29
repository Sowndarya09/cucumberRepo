package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class GuidedFlowsReview {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);
	//CommonUtilities utils = new CommonUtilities();
	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;
	@FindBy(id = "PegaGadget3Ifr")
	WebElement Iframeelement1;
	WebDriverWait wait;

	public GuidedFlowsReview() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}
		catch(Exception e){
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
		

}
	
	@FindBy(xpath="//label[contains(text(),'Guided Flows: Review and Finalize')]")
	WebElement lblGuidedFlowsReview;
	public boolean verifySreenNameGuidedFlowsReviewAndFinalize(){
		return utils.isProxyWebelement(lblGuidedFlowsReview);
	}
	
	@FindBy(xpath="//span[contains(text(),'Review Tasks')]")
	WebElement lblReviewTasks;
	public boolean verifySectionReviewTasks(){
		return utils.isProxyWebelement(lblReviewTasks);
	}
	
	
}
