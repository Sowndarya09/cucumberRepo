package automationLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerComposite_GroupSection {

	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();

	WebDriverWait wait;
	
	public BrokerComposite_GroupSection()
	
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
	
	
	
	@FindBy(xpath="//button[@data-test-id='201809101051450876148905']")
	WebElement btnGroup;
	
	@FindBy(xpath="//table[@pl_prop='.clientSearch']")
	WebElement tblGroupSearch;
	
	@FindBy(id="IsGroupNameVerified")
	WebElement chbxGroupName;

	@FindBy(id="IsGrpNumberVerified")
	WebElement chbxGroupNumber;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnGrpsubmit;
	
	
	/**
	 * Clicks the Change Group Button
	 * @return
	 */
	public boolean clickOnChangeGroupButton()
	{
		return utils.clickAnelemnt(btnGroup, "BrokerComposite_GroupSection", "Group Btn");
	}
	
	/**
	 * This functionality validates the value given by the user in the Search result table and select the group
	 * @param tablevalues
	 * @return
	 */
	public boolean validateSearchResultTableAndSelectTheGroup(String[] tablevalues)
	{
		utils.waitforpageload();
		try
		{
		WebElement row = utils.returntablerowbasedonvalues(tblGroupSearch, tablevalues);
		List<WebElement> rowNo = row.findElements(By.tagName("input"));
		rowNo.get(0).click();
		return true;
		}catch (Exception e)
		{
			err.logError("BrokerSearchForGroup", "validateSearchResultTableAndSelectTheGroup");
			return false;
		}
	}
	
	
	/**
	 * Clicks the Group Name and the Group Number check box for HIPPA Verification in the Group Search page
	 * @return
	 */
	public boolean verifyGroupNameAndGroupNumberForHippaPass()
	
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(chbxGroupName, "BrokerSearchForGroup", "TIN"))
			return utils.clickAnelemnt(chbxGroupNumber, "BrokerSearchForGroup", "Agency Name");
		return false;
		
	}
	
	
	/**
	 * Clicks the submit button in the Group Search page
	 * @return
	 */

	public boolean clickOnSubmit()
	{
		WebElement element = btnGrpsubmit;
	   	((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(btnGrpsubmit,"BrokerSearchForGroup","Submit");
	}
	
	
}
