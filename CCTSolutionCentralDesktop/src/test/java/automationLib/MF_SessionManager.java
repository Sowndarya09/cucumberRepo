package automationLib;
import utils.SeleniumUtilities;
import utils.ErrorLogger;
import utils.MainframeUtilities;
import utils.BaseLogger;
import utils.Utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import automationLib.MF_Cordinates;

public class MF_SessionManager {

	SeleniumUtilities utils = new SeleniumUtilities();
	MainframeUtilities mf=new MainframeUtilities();
	public WebElement region;
	public WebElement lob;

	public  MF_SessionManager(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	}

	public WebElement getRegion(){

		region= mf.getWebElement("21", "7");
		return region;
	}
	
	
	public WebElement getlob(){

		lob= mf.getWebElement("1", "1");
		return lob;
	}

	//@FindBy(xpath = "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]/div[20]/span")
	@FindBy(xpath="//div[@class='screen']/div[20]/span")
	List<WebElement> EndCommandText;

	public String getPagelevelXpath(){
		//return "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]";
		return "//div[@class='screen']";
	}


	Actions action=new Actions(Driver.pgDriver);

	public boolean enterTestRegion(String[] args) throws InterruptedException{
		boolean flag = true;
		//Thread.sleep(5000);
		mf.enterText(this.getRegion(), "end "+args[0] +Keys.ENTER);
		//Thread.sleep(2000);
		String text = mf.retrieveTextEntireRow(EndCommandText);
		flag = utils.isvalueMatch_contain(text, "END Command accepted") ||utils.isvalueMatch_contain(text, "ended") ;
		//Thread.sleep(5000);
		mf.enterText(this.getRegion(), args[0] +Keys.ENTER);
		return flag;
	}



	public boolean enterGroupID(String[] args) throws InterruptedException {
		//Thread.sleep(5000);
		mf.sendBreakKey();
		Thread.sleep(5000);
		mf.enterText(this.getlob(), args[0] +Keys.ENTER);
		return true;
	}
	
ArrayList<WebElement> al = new ArrayList<WebElement>();
	
	@FindBy(xpath="//div[@class='screen']/div")
	List<WebElement> allRow;
	
	public boolean getText()
	{
		System.out.println("Entered in for...");
		for(int i=0;i<allRow.size();i++)
		{
			String s = "//div[@class='screen']/div["+i+"]";
			List<WebElement> ls = Driver.pgDriver.findElements(By.xpath(s));
			String text1 = mf.retrieveTextEntireRow(ls);
			System.out.println(text1);
			//return true;
		}
		return true;
		//String text1 = mf.retrieveTextEntireRow(allRow.get(0));
		//System.out.println(text1);
		//return true;
	}



}
