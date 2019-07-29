package automationLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.MainframeUtilities;
import utils.SeleniumUtilities;

public class MF_MemberEnquiry {
	
	public  MF_MemberEnquiry(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	}
	
	
	SeleniumUtilities utils = new SeleniumUtilities();
	MainframeUtilities mf=new MainframeUtilities();
	Actions action=new Actions(Driver.pgDriver);
	
	public WebElement option;
	
	public String getPagelevelXpath(){
		//return "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]";
		return "//div[@class='screen']";
	}
	
	public WebElement getOption(){

		option= mf.getWebElement("5", "22");
		return option;
	}
	
	public boolean enterProfileOption(String[] args) throws InterruptedException {
		//Thread.sleep(5000);
		mf.enterText(this.getOption(), args[0] +Keys.ENTER);
		return true;
	}

}
