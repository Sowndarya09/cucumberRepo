package automationLib;
import java.util.ArrayList;
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
import utils.Utilities;

public class MF_Login {


	public  MF_Login(){
		System.out.println("In Constructor");
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

	}

	SeleniumUtilities utils = new SeleniumUtilities();
	MainframeUtilities mf=new MainframeUtilities();
	Utilities comnutils = new Utilities();
	
	public WebElement username;
	public WebElement password;
	public WebElement tpxc;

	public WebElement getusername(){

		username=mf.getWebElement("14", "20");
		return username;
	}

	public WebElement getTPXC(){

	tpxc= mf.getWebElement("23", "48");
		return tpxc;
	}
	
	public String getPagelevelXpath(){
		//return "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]";
		return "//div[@class='screen']";
	}

	public WebElement getpassword(){

		password=mf.getWebElement("15", "20");
		return password;
	}

	//@FindBy(xpath = "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]/div[2]/span")
	@FindBy(xpath="//div[@class='screen']//div[2]/span")
	List<WebElement> headerRow;
	



	@FindBy(name="username")
	WebElement Username;

	@FindBy(name="password")
	WebElement Password;

	@FindBy(name="submit")
	WebElement Submit;

	@FindBy(xpath="//input[@class='form-control']")
	WebElement txtBxSession;

	@FindBy(xpath="(//input[@class='form-control']//following::a)[1]")
	WebElement lnkEnteredSession;

	Actions action=new Actions(Driver.pgDriver);

	public boolean login() throws InterruptedException{	
		String username = comnutils.getPropertyvalue("mainframeusername");
		String password = comnutils.getPropertyvalue("mainframepassword");
		mf.waitforpageload();
		mf.enterText(this.getTPXC(), "tpxc"+Keys.ENTER);
		//Thread.sleep(5000);
		mf.enterText(this.getusername(), username+Keys.TAB);
		mf.enterText(this.getpassword(), password+Keys.ENTER);
		//Thread.sleep(2000);
		return true;
		//return(!validateHeader()) ;
	}

	
	

	public boolean validateHeader(){
		return utils.isvalueMatch_contain(mf.retrieveTextEntireRow(headerRow),"ANTHEM BLUE CROSS - IBM SESSION MANAGER");
	}
	
	
	



}
