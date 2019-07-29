package automationLib;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.MainframeUtilities;
import utils.SeleniumUtilities;

public class MF_ReflectionHeader {
	
	public MF_ReflectionHeader(){
		System.out.println("In Constructor");
		//mf.setPagelevelXpath("//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]");
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		
	}
	
	static SeleniumUtilities utils = new SeleniumUtilities();
	MainframeUtilities mf=new MainframeUtilities();
	
	@FindBy(xpath="//div[@title='Disconnect']")
	public static WebElement disconnect;
	
	@FindBy(xpath="//span[@class='user-name']")
	public static WebElement lnkUserName;
	
	@FindBy(xpath="//a[@title='Macros']")
	WebElement Macro;
	
	static public boolean disconnectSession(){

		if(utils.clickAnelemnt(disconnect, "Header", "Disconnect"))
			if(utils.clickAnelemnt(lnkUserName, "Header", "User Name"))
				return true;
		return false;
			
		}

	public boolean runMacro(String[] args){

		if(utils.clickAnelemnt(Macro, "Header", "macro"))
			return utils.clickAnelemnt(Driver.pgDriver.findElement(By.xpath("//span[text()='"+args[0]+"']")), "Header", "macro"+args[0]);
			return false;
		}

}
