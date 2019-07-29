package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerComposite_VerificationHistory {


	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();

	WebDriverWait wait;
	
	public BrokerComposite_VerificationHistory()
	
	{
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			if(utils.isAlertPresent())
			{
				Driver.pgDriver.switchTo().alert().accept();
			}
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);

		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement); 
		}
	}
	
	
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(xpath="//h3[text()='Verification History']")
	WebElement tabVerificationHistory;

	@FindBy(xpath="//span[text()='Verified Providers']")
	WebElement lnkVerifiedProviders;

	@FindBy(xpath="//span[text()='Verified Members']")
	WebElement lnkVerifiedMembers;
	
	
	@FindBy(xpath="//table[@pl_prop='D_MembersVerified.pxResults']")
	WebElement tblVerifiedMembers;
	
	
	
	
	/**
	 * Verifies that only 'Verified Provider' is not displayed under the Verification History tab
	 * @return
	 */

	public boolean verifyVerifiedProvidersIsNotDisplayedOnVerificationHistoryTab()
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(tabVerificationHistory, "BrokerComposite", "Verification History"))
			if(utils.isProxyWebelement(lnkVerifiedProviders) && !utils.isProxyWebelement(lnkVerifiedMembers) )
				return true;
		return false;
	}
	
	public boolean verifyVerfiedMembers(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(tblVerifiedMembers, tablevalues);
	}

}
