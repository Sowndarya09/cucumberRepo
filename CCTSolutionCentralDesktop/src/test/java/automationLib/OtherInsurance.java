package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import stepdefinition.stepdefinition;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class OtherInsurance {



	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	
	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement;
	
	@FindBy(xpath="//div[@node_name='pyCaseActionArea']//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;
	
	@FindBy(xpath="//span[contains(text(),'Update Other Insurance')]")
	WebElement lnkUpdateOtherInsurance;
	
	@FindBy(xpath="//span[contains(text(),'Request Manager Help')]")
	WebElement lnkRequestManagerHelp;
	
	/**
	 * Constructor for the RequestAccumulatorReview class defining the Iframe and the Page Factory  
	 */
	public OtherInsurance() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToRequestManagerHelp
	 * #Description: This functionality navigates to the Request Manager Help from the Other Actions Section.
	 * Type: Textbox
	 */
	public boolean navigateToRequestManagerHelp()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "OtherInsurancePage", "Other Actions"))
			if(utils.clickAnelemnt(this.lnkRequestManagerHelp, "OtherInsurancePage", "Request Manager Help"))
					return true;
		return false;
		
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToUpdateOtherInsurance
	 * #Description: This functionality navigates to the Update Other Insurance from the Other Actions Section.
	 * Type: Textbox
	 */
	public boolean navigateToUpdateOtherInsurance()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "OtherInsurancePage", "Other Actions"))
			if(utils.clickAnelemnt(this.lnkUpdateOtherInsurance, "OtherInsurancePage", "Update Other Insurance"))
					return true;
			err.logError("OtherInsurancePage", "Navigating to Update Other Insurance is failed");
			stepdefinition.isServicedown=true;
			extentmanager.ExtentManager.setTeststatus("Warning - Possible role Issue");
			return false;
	}

}













