package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class OutboundCall_SelectContract {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	WebDriverWait wait;

	public OutboundCall_SelectContract() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(xpath= "//tr[@id='$PHCMemberPolicyList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstRow;

	@FindBy(xpath= "//span[contains(text(), 'Select Contract')]")
	WebElement lblSelectContractTitle;


	@FindBy(xpath= "//*[@data-test-id='20160304053605032428479' or @data-test-id='2015021306370007097332']")//Added for Pega upgrade
	WebElement btnSubmit;

	/**This functionality selects the first contract in the contract page and Submit
	 * 
	 * @return
	 */
	public boolean selectfirstContract(){
		if(utils.clickAnelemnt(rdoFirstRow, "SelectContract", "Radio button -firstRowofselectContracttable"))
			if(utils.clickAnelemnt(lblSelectContractTitle, "SelectContract", "Title"))
				if (utils.clickAnelemnt(btnSubmit, "SelectContract", "Submit"))
					return true;
		return false;
	}


}
