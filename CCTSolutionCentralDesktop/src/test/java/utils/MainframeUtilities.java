package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationLib.Driver;

public class MainframeUtilities {


	SeleniumUtilities utils = new SeleniumUtilities();	
	Actions action = new Actions(Driver.pgDriver);
	//String xpath="//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]";
	String xpath = "//div[@class='screen']";

	public boolean pressEnter()
	{

		action.sendKeys(Keys.ENTER).build().perform();
		return true;	
	}

	public boolean pressTAB()
	{

		action.sendKeys(Keys.TAB).build().perform();
		return true;	
	}


	public boolean pressF1KeyInMF()
	{

		action.sendKeys(Keys.F1).build().perform();
		return true;	
	}


	/*public boolean pressF3KeyInMF()
	{
		Actions ac = new Actions(Driver.pgDriver);
		action.sendKeys(Keys.F3).build().perform();
		return true;	
	}*/

	public boolean pressF4KeyInMF()
	{
		action.sendKeys(Keys.F4).build().perform();
		return true;
	}

	public boolean pressF3KeyInMF()
	{

		action.sendKeys(Keys.F3).build().perform();
		return true;
	}

	public boolean pressF6KeyInMF()
	{

		action.sendKeys(Keys.F6).build().perform();
		return true;
	}

	public boolean pressF7KeyInMF()
	{

		action.sendKeys(Keys.F7).build().perform();
		return true;
	}

	public boolean pressF8KeyInMF()
	{

		action.sendKeys(Keys.F8).build().perform();
		return true;
	}


	public boolean pressF10KeyInMF()
	{

		action.sendKeys(Keys.F10).build().perform();
		return true;
	}

	public boolean pressF11KeyInMF()
	{
		//Actions ac = new Actions(Driver.pgDriver);
		action.sendKeys(Keys.F11).build().perform();
		return true;
	}

	public boolean pressF5KeyInMF()
	{

		action.sendKeys(Keys.F5).build().perform();
		return true;
	}

	public boolean pressF9KeyInMF()
	{

		action.sendKeys(Keys.F9).build().perform();
		return true;
	}

	public boolean pressF2KeyInMF()
	{

		action.sendKeys(Keys.F2).build().perform();
		return true;
	}

	public String retrieveTextwithCordinates(List<WebElement> row,int colstart,int colend)  
	{
		String result =this.retrieveTextEntireRow(row);


		result=result.substring(colstart, colend)	;
		System.out.println(result);
		return result;
	}

	public String retrieveTextwithlength(List<WebElement> row,int colstart,int len)  
	{
		String result =this.retrieveTextEntireRow(row);
		result=result.substring(colstart, colstart+len);	
		System.out.println(result);
		return result;
	}

	public String retrieveTextEntireRow(List<WebElement> row)  
	{
		String result ="";
		for(WebElement iter:row)
			result=result+iter.getText();		
		System.out.println(result);
		return result;
	}

	public void enterText(WebElement element,String text)  
	{
		//if(!utils.isProxyWebelement(element))
		action.click(element).sendKeys(text).build().perform();

	}

	public boolean sendBreakKey() {		
		action.sendKeys(Keys.PAUSE).perform();
		return true;
	}

	public void setPagelevelXpath(String xpath){
		this.xpath= xpath;
	}

	public String getPagelevelXpath(){
		return xpath;
	}

	public WebElement getWebElement(String X,String Y){
		this.waitforpageload();
		String local=this.getPagelevelXpath()+"/div["+X+"]/span["+Y+"]";
		System.out.println(local);
		return Driver.pgDriver.findElement(By.xpath(local));
	}

	public boolean waitforpageload()
	{
		try{
			WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}

		catch(TimeoutException e){
			System.out.println("Mainframe is slow");
		}
		return true;

	}	

}
