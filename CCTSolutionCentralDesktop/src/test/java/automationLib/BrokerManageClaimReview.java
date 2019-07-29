package automationLib;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerManageClaimReview {


	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();
	
	WebDriverWait wait;

	public BrokerManageClaimReview()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		utils.waitforpageload();
	}

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForBroker;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="ContactType")
	WebElement drpDownContactType;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;
	
	
	
	/**
	 * This functionality navigates to the Request Adjustment from the Broker Manage Claim Review page
	 * @return
	 */
	public boolean navigatetoRequestAdjusment()
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "Request Adjustment", "BrokerManageClaims", "Request Adjustment");
	}

	/**
	 * This functionality navigates to the Request Manager from the Broker Manage Claim Review page
	 * @return
	 */
	public boolean clickOtherActionsRequestManagerHelp()
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "Request Manager/OE Help", "BrokerManageClaims", "Request Manager/OE Help");
	}


}
