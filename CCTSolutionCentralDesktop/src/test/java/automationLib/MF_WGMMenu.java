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

public class MF_WGMMenu {

	SeleniumUtilities utils = new SeleniumUtilities();
	MainframeUtilities mf=new MainframeUtilities();
	public WebElement profileoptions;

	public  MF_WGMMenu(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	}


	public String getPagelevelXpath(){
		//return "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]";
		return "div[@class='screen']";
	}

	public WebElement getProfileOptions(){

		profileoptions= mf.getWebElement("5", "22");
		return profileoptions;
	}

	Actions action=new Actions(Driver.pgDriver);

	public boolean selectOptionAndEnter(String[] args) throws InterruptedException{
		mf.enterText(getProfileOptions(), args[0]);
		return true;
	}




}
