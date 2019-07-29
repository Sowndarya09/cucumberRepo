package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtilities;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Helpdeskloginpage {
	
	WebDriver driver;
	SeleniumUtilities utils = new SeleniumUtilities();
	String pgname="HelpdeskLoginPortal";
	
	@FindBy(xpath="//input[@id='txtUserID']")//id("txtUserID")
	WebElement UserID;
	//By UserID = By.xpath("//input[@id='txtUserID']");//id("txtUserID");
	@FindBy(id="txtPassword")//id("txtUserID")
	WebElement  Password;
	//By Password = By.id("txtPassword");
	By Loginbutton = By.id("sub");
	By Screen = By.xpath("//a[contains(@title,'Take a screenshot')]");
	By WorkBasketButton = By.xpath("//*[contains(text(),'My Work Baskets')]");
			
	public Helpdeskloginpage(WebDriver driver) {
		
		this.driver = driver;
		 
	}
	
public Helpdeskloginpage() {
		
	PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	if(!utils.checkIfErrorPage())
	{
		utils.refreshthepage();
	}
		 
	}
	
	public boolean enterLoginDetails(String[] args) throws InterruptedException
	{
		//System.out.println(uid);
		//Thread.sleep(3000);
		//driver.findElement(UserID).click();
		
		//driver.findElement(UserID).sendKeys(uid);
		//driver.findElement(Password).sendKeys(pwd);
		
		if(utils.enterTextinAnelemnt(UserID,args[0], pgname, "UserID"))
		if(utils.enterTextinAnelemnt(Password, args[1],pgname, "password"))
		
		return true;
		return false;
		
	}
	
	 
	
	
	public Helpdeskloginpage clicklogin()
	{
		driver.findElement(Loginbutton).click();
				
		return this;
		
	}
	
	public Helpdeskloginpage ClickWorkBasket()
	{
		driver.findElement(WorkBasketButton).click();
		return this;
	}
	
	public Helpdeskloginpage ScreenshotValidate()
	{
	driver.findElement(Screen).click();
	
		return this;
	}
	
	
	
	

}
