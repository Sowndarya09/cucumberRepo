package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class GuestContact_InteractionsTab {




	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	public GuestContact_InteractionsTab()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	@FindBy(xpath="//table[@pl_prop='D_MemberInteractions.pxResults']")
	WebElement tblRecentInteractions;
	@FindBy(xpath="//span[text()='Recent Interactions']")
	WebElement lnkGuestCompositeIntRecentInt;

	public boolean verifyRecentnteractionColumnHeadersTablesInGuestInteractions()
	{
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblRecentInteractions);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("");
		valuesGivenManual.add("");
		valuesGivenManual.add("Interaction ID");
		valuesGivenManual.add("Created On");
		valuesGivenManual.add("Created By");
		valuesGivenManual.add("");
		valuesGivenManual.add("Primary Task");
		valuesGivenManual.add("Service Experience");
		valuesGivenManual.add("Contact Name");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			blogger.loginfo("Table Headers in the Recent Interaction table matched with expected values");
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			blogger.loginfo("Table Headers in the Recent Interaction table doesn't matched with expected values");
			System.out.println("Values doesnt Matched");
			return false;
		}
	}
	public boolean clickRecentInteractionLink() {
		utils.waitforpageload();
		return utils.clickAnelemnt(this.lnkGuestCompositeIntRecentInt,"GuestContact_InteractionsTab"," Recent Interaction Link");
	}

	public boolean validateRowsInRecentInteration(String[] args) {

		utils.waitforpageload();
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);",this.tblRecentInteractions);
		return utils.validatetablerowbasedonvalues(tblRecentInteractions, args);
	}
}

