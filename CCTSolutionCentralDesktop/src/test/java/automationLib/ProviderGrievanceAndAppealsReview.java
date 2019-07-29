package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderGrievanceAndAppealsReview {
	
	DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement1;
	
	public ProviderGrievanceAndAppealsReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		try{
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}catch(Exception e){
			System.out.println("Exception in costructor");
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	
	@FindBy (xpath="//li[@title='Request Manager/OE Help']")	
	private WebElement lnkOthrActionsRequestManagerHelp;

	/**This functionality navigates to the Request Manager or OE help page by clicking Other actions button
	 * 
	 * @return
	 */
	public boolean navigatetoRequestManagerorOEHelp() {
		if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsRequestManagerHelp, "Manage Claim Review", "Request Adjustment");
		return false;
	}

}
