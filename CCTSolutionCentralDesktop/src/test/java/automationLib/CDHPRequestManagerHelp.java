package automationLib;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CDHPRequestManagerHelp {

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the CDHPRequestManagerHelp class defining the Iframe and the Page Factory  
	 */
	public CDHPRequestManagerHelp() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCDHPRequestManagerHelp;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	public WebElement getHeader()
	{
		return sHeaderCDHPRequestManagerHelp;
	}
	/*
	 *@SCU
	 *#CommonMethodwithoutArgument:validateCDHPRequestManagerHelpPage
	 *#Description:This method validates if 'CDHP Request Manager Help' is displayed.
	 *Type:Textbox
	 */
	public boolean validateCDHPRequestManagerHelpPage(){
		utils.waitforpageload();
		try{
			if(utils.validateHeader(this.sHeaderCDHPRequestManagerHelp, "Request Manager Help")){
				System.out.println("User is successfully navigated to CDHP Request Manager Help screen");
				return true;
			}else{
				err.logcommonMethodError("CDHPRequestManagerHelp", "validateCDHPRequestManagerHelpPage - Header doesnt match on page");
				return false;
			}
		}catch(Exception e){
			err.logError("CDHPRequestManagerHelp - CDHP Request Manager Help page isnt loaded ");
			System.out.println("Exception occured while trying to load - CDHP Request Manager Help page."+e);
			return false;
		}
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Complete CDHP Review']")	
	private WebElement lnkOtherCompleteCDHPReview;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View Consumer Driven Heal...']")	
	private WebElement lnkOtherCDHPAccounts;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionReviewCDHPInformation
	 * #Description:This method clicks on Other Action and select Review CDHP Information 
	 * Type:Textbox
	 */
	public boolean clickOtherActionReviewCDHPInformation(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CDHPRequestManagerHelp", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherCompleteCDHPReview, "CDHPRequestManagerHelp", "Complete CDHP Review"))
				if(utils.validateHeader(this.sHeaderCDHPRequestManagerHelp,"Complete CDHP Review"))
					return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionViewCDHPAccountInfo
	 * #Description:This method clicks on Other Action and select View Consumer Driven Health Plan Accounts 
	 * Type:Textbox
	 */
	public boolean clickOtherActionViewCDHPAccountInfo(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CDHPRequestManagerHelp", "Other Actions button")) {
			List<WebElement> viewlink = Driver.pgDriver.findElements(By.xpath("//*[@class='menu-item-title'][text()='View Consumer Driven Heal...']"));
			if(utils.clickAnelemnt(viewlink.get(1), "CDHPRequestManagerHelp", "View Consumer Driven Health Plan Accounts"))
				if(utils.validateHeader(this.sHeaderCDHPRequestManagerHelp,"View Consumer Driven Health Plan Accounts"))
					return true;
		}

		return false;
	}
}
