package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderCSRResolveReview {
	
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	Actions action = new Actions(Driver.pgDriver);

	public ProviderCSRResolveReview() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(Iframeelement2);
	}
	
	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement2;
	
	@FindBy(xpath="//table[@pl_prop='.ResearchedProvider']")
	WebElement TableResearchProvider;
	
	public boolean validateHMOProviderReviewGrid(String[] args) {
		return utils.validatetablerowbasedonvalues(TableResearchProvider, args);
	}
	
	public boolean validateAddressInResearchProviderReviewGrid(String[] args) {
		return utils.validatetablerowbasedonvalues(TableResearchProvider, args);
	}

}
