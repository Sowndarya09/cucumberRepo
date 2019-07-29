package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderMemberMaintenance {


	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	public ProviderMemberMaintenance() 
	{
		
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		
	}
	
	@FindBy(xpath="//table[@pl_prop='.Address']")
	WebElement memberAddressTbl;
	
	@FindBy(xpath="//table[@pl_prop='.PhoneCommunication']")
	WebElement memberPhoneAndFaxTbl;
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyUpdateAddressIsntDisplayed
	 * #Description:This functionality validates 'update' Member address isnt displayed in Member Maintenance page.
	 * #Arguments:MemberAddress
	 * Type:Table
	 * Keys:Type#Address Line 1#Address Line 2#City#State#Zip Code#County
	 */
	public boolean verifyUpdateAddressIsntDisplayed(String args[]) throws InterruptedException
	{
		utils.waitforpageload();
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.memberAddressTbl);
		try{
		WebElement row = utils.getTablerowbasedonvalues(this.memberAddressTbl, args);
		row.findElement(By.xpath(".//a[text()='Update']")).click();
		utils.waitforpageload();
		err.logError("Update link is displayed for a specific Member address");
		return false;
		}catch(Exception e){
			blogger.loginfo("Update link isnt displayed for a specific Member address"+ e);
			return true;
		}
	}
	/*
	 * @SCU
	 * #CommonMethodWithArgument:clickUpdateMemberPhoneAndFax
	 * #Description:This functionality validates 'update' link in Member Phone and Fax isnt displayed in Member Maintenance page.
	 * #Arguments:MemberPhoneAndFax
	 * Type:Table
	 * Keys:Type#Number
	 */
	public boolean verifyUpdatePhoneAndFaxIsntDisplayed(String args[]) throws InterruptedException
	{
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.memberPhoneAndFaxTbl);
		try{
		WebElement row = utils.getTablerowbasedonvalues(this.memberPhoneAndFaxTbl, args);
		row.findElement(By.xpath(".//a[text()='Update']")).click();
		err.logError("Update link is displayed for a specific Member PhoneAndFax");
		return false;
		}catch(Exception e){
			blogger.loginfo("Update link isnt displayed for a specific Member PhoneAndFax"+ e);
			return true;
		}
	}
}
