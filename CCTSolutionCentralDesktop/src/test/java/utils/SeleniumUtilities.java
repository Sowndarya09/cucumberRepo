package utils;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import automationLib.Driver;
import cucumber.api.PendingException;
import extentmanager.ExtentManager;
import stepdefinition.stepdefinition;

public class SeleniumUtilities  {

	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();	
	WebDriver driver = Driver.getPgDriver();
	public static long startTime, endtime;
	Actions action=new Actions(driver);
	Date date = new Date();
	WebDriverWait wait;
	public  String name="";
	Utilities comnutils;
	ExtentReports reports = ExtentManager.getInstance();
	public static ArrayList<String> screenshotpath=new ArrayList<String>();;
	public static Map<String, String> valuebox= new HashMap<String, String>();
	
	public ArrayList<String> getcolumnStringFromTableByName(WebElement tbl, String columnName){
		stepdefinition.executionTime+=10;
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		//System.out.println(allRows.size());
		//MbrSrchResults[] msr = null;
		int rowindex=0;
		int columnindex=0;
		int iterator =0; 
		ArrayList<String> resultarray = new ArrayList<String>();
		if (allRows.size() > 0){
			System.out.println("All rows size" +allRows.size());
			ArrayList<String> headerrow = new ArrayList<String>();
			headerrow= getheaderrowFromTable(tbl);
			if(headerrow.size()>0){
				columnindex=returnindexofelemntinanarray(headerrow, columnName);
				resultarray.add(columnName);
				//System.out.println(columnName+" is found at the position of "+columnindex);
			}
			//msr = new MbrSrchResults[allRows.size()];
			for (WebElement row : allRows) {
				List<WebElement> allColsByRow=null;
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));				
					if(allColsByRow.size()>0)

						resultarray.add(allColsByRow.get(columnindex).getText());					

				}
				catch(Exception e)
				{
					continue;
				}
				//System.out.println(allColsByRow.size());



			}

		}
		//System.out.println(resultarray);
		if(!(resultarray.size()>1))
			blogger.loginfo("Table Column did not return any value, please checck the Header is correct");
		return resultarray;
	}

	public ArrayList<String> getcolumnStringFromTableByNameMC(WebElement tbl, String columnName){
		stepdefinition.executionTime+=10;
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		//System.out.println(allRows.size());
		//MbrSrchResults[] msr = null;
		int rowindex=0;
		int columnindex=0;
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();
		if (allRows.size() > 0){
			ArrayList<String> headerrow = new ArrayList<String>();
			headerrow= getheaderrowFromTable(tbl);
			if(headerrow.size()>0){
				columnindex=returnindexofelemntinanarray(headerrow, columnName);
				resultarray.add(columnName);
			}
			//msr = new MbrSrchResults[allRows.size()];
			for (WebElement row : allRows) {
				List<WebElement> allColsByRow=null;
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));
					for(int i=0;i<allColsByRow.size();i++)
						//System.out.println(allColsByRow.get(i).getText());

						if(allColsByRow.size()>0)	

							resultarray.add(allColsByRow.get(columnindex+2).getText());


				}
				catch(Exception e)
				{
					continue;
				}
				System.out.println(allColsByRow.size());



			}

		}
		System.out.println(resultarray);
		return resultarray;
	}
	public ArrayList<String> getcolumnStringFromTablefrRT(WebElement tbl, String columnName){

		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		System.out.println(allRows.size());
		//MbrSrchResults[] msr = null;
		int rowindex=0;
		int columnindex=0;
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();
		if (allRows.size() > 0){
			ArrayList<String> headerrow = new ArrayList<String>();
			headerrow= getheaderrowFromTable(tbl);
			if(headerrow.size()>0){
				columnindex=returnindexofelemntinanarray(headerrow, columnName);
				resultarray.add(columnName);
				System.out.println(columnName+" is found at the position of "+columnindex);
			}
			//msr = new MbrSrchResults[allRows.size()];
			for (WebElement row : allRows) {
				//System.out.println(allRows.size());
				List<WebElement> allColsByRow=null;
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));
					for(int i=0;i<allColsByRow.size();i++)
						System.out.println(i+"----"+allColsByRow.get(i).getText());
					//System.out.println(allColsByRow.size());
					if(allColsByRow.size()>0)	
						System.out.println(resultarray.get(0));
					if(resultarray.get(0)!="Generated Date"&resultarray.get(0)!="Date"&resultarray.get(0)!="Bill Date"&resultarray.get(0)!="City")
						resultarray.add(allColsByRow.get(columnindex).getText());

					else
						resultarray.add(allColsByRow.get(columnindex+1).getText());

				}
				catch(Exception e)
				{
					continue;
				}
				//System.out.println(allColsByRow.size());



			}

		}
		System.out.println(resultarray);
		return resultarray;
	}



	public ArrayList<String> getColumnsBasedonIndex(WebElement tbl, int columnNo){
		stepdefinition.executionTime+=20;
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		//MbrSrchResults[] msr = null;
		System.out.println(allRows.size());
		int rowindex=0;
		int columnindex=columnNo;
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();
		if (allRows.size() > 0){
			ArrayList<String> headerrow = new ArrayList<String>();
			headerrow= null;

			//		
			for (WebElement row : allRows) {
				try{
					List<WebElement> allColsByRow =row.findElements(By.tagName("td"));
					//System.out.println(allColsByRow.size());
					if(allColsByRow.size()>0)	

						resultarray.add(allColsByRow.get(columnindex).getText());
				}
				catch(Exception e)
				{
					List<WebElement> allColsByRow =row.findElements(By.tagName("span"));
					//if(allColsByRow.size()>0)	
					//System.out.println(allColsByRow);
					//resultarray.add(allColsByRow.get(columnindex).getText());
				}

				//System.out.println(resultarray);								
			}

		}
		//System.out.println(resultarray);
		return resultarray;
	}

	public ArrayList<WebElement> getcolumnWebelemntFromTable(WebElement tbl,String elementType){

		WebElement srchResults = tbl;
		WebElement cell = null;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		//MbrSrchResults[] msr = null;
		int rowindex=0;
		int columnindex=0;
		int iterator =0;
		ArrayList<WebElement> resultarray = new ArrayList<WebElement>();
		if (allRows.size() > 0){
			ArrayList<String> headerrow = new ArrayList<String>();
			headerrow= getheaderrowFromTable(tbl);
			/*if(headerrow.size()>0){
		columnindex=returnindexofelemntinanarray(headerrow, columnName.getText());
		resultarray.add(columnName);
			}*/
			//msr = new MbrSrchResults[allRows.size()];
			for (WebElement row : allRows) {
				List<WebElement> allColsByRow =row.findElements(By.tagName("td"));
				if(allColsByRow.size()>0)	
					cell = allColsByRow.get(columnindex).findElement(By.tagName(elementType));
				resultarray.add(cell);	

			}

		}
		//System.out.println(resultarray);

		return resultarray;
	}

	public ArrayList<WebElement> getcolumnWebelemntFromTable(WebElement tbl, int columnNo, String elementType){

		WebElement srchResults = tbl;
		WebElement cell = null;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));

		//MbrSrchResults[] msr = null;
		int rowindex=0;
		int columnindex=0;
		int iterator =0;
		ArrayList<WebElement> resultarray = new ArrayList<WebElement>();
		if (allRows.size() > 0){
			//ArrayList<String> headerrow = new ArrayList<String>();
			//headerrow= getheaderrowFromTable(tbl);
			/*if(headerrow.size()>0){
		columnindex=returnindexofelemntinanarray(headerrow, columnName.getText());
		resultarray.add(columnName);
			}*/
			//msr = new MbrSrchResults[allRows.size()];
			for (WebElement row : allRows) {
				List<WebElement> allColsByRow =row.findElements(By.tagName("td"));

				if(allColsByRow.size()>0)	
					try{
						cell = allColsByRow.get(columnindex).findElement(By.tagName(elementType));
					}
				catch(Exception e){
					cell=null;
				}
				resultarray.add(cell);	

			}

		}

		return resultarray;
	}



	public int returnindexofelemntinanarray(ArrayList<String> sourcearray, String searchvalue){
		int iterator;
		iterator =0;
		for(String elements:sourcearray)
		{
			System.out.println(iterator+"---------"+sourcearray.get(iterator));
			if(sourcearray.get(iterator).toLowerCase().contains(searchvalue.toLowerCase()))
				break;
			iterator++;
		}
		return iterator;	
	}
	public ArrayList<String> getheaderrowFromTable(WebElement tbl){
		stepdefinition.executionTime+=15;
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		int rowindex = 0;
		int columnindex = 0;
		int iterator = 0;
		ArrayList<String> resultarray = new ArrayList<String>();
		if (allRows.size() > 0) {
			for (WebElement row : allRows) {
				if (iterator > 0)
					break;
				List<WebElement> allColsByRow = row.findElements(By.tagName("th"));
				if (allColsByRow.size() > 0) {
					for (WebElement column : allColsByRow) {
						// System.out.println(allColsByRow.get(iterator).getText());
						String columnName = allColsByRow.get(iterator).getText().trim();
						if(columnName.contains("\n"))
						{
							columnName = columnName.replaceAll("\n", " ");
						}
						resultarray.add(columnName);
						iterator++;
					}
				}
			}
		}
		System.out.println("The values in the result array is:" + resultarray);
		return resultarray;
	}




	// pagefactoryinit initailizes all the objects with a proxy content, so if the @findby did not return
	// web ellemnt the object still have proxy element which is used for handling the error which might get on incorrect locators

	public boolean isProxyWebelement(WebElement element) {
		if(element.toString().contains("Proxy")){
			blogger.loginfo(element+" is Not Present");
			return true;
		}

		else{
			//blogger.loginfo(element+" is Present");
			return false;
		}
	}

	public void takescreenshot(String screenshotname)
	{
		stepdefinition.executionTime+=20;
		try{
			String imagepath = takescreenshot("value_Check",screenshotname);
			ExtentTest logger=ExtentManager.getLogger();
			logger.pass(screenshotname,MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		}
		catch(Exception e)
		{
			System.out.println("Not able to take screen shot due to "+e);
		}
	}
	
	private void takescreenshot(WebElement el) 
	{
		stepdefinition.executionTime+=20;
		try{
			if(screenshotpath.size()==0)
				screenshotpath.add("Header");
			//int TCloop=MainDriverTest.loopvar;
			//String currenttestcase=MainDriverTest.testcases.get(1),currentpage,currentaction;
			//if(MainDriverTest.testcases.get(TCloop)!="")
			{
				//currenttestcase=MainDriverTest.testcases.get(TCloop);
			}
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
			//currentpage=MainDriverTest.pageName.get(TCloop);
			//currentaction=MainDriverTest.actions.get(TCloop);

			// Screen shot taken 
			File scrFile = ((TakesScreenshot)Driver.pgDriver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(scrFile, new File("C:/SolutionCentralEngine/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png")); 

			// in case screen shot of the element 
			System.out.println("====================**********************+++++++++++++++++++++++++++++++");
			//Get entire page screenshot
			File screenshot = ((TakesScreenshot)Driver.pgDriver).getScreenshotAs(OutputType.FILE);
			BufferedImage  fullImg = ImageIO.read(screenshot);
			//Get the location of element on the page
			org.openqa.selenium.Point point = el.getLocation();
			//Get width and height of the element
			int eleWidth = el.getSize().getWidth()+80;
			int eleHeight = el.getSize().getHeight()+80;

			Graphics2D g = (fullImg).createGraphics();
			g.setColor(new Color(177,177,0,77)); //yellow + 30% transparency
			g.fillRect(point.getX(), point.getY(), eleWidth,eleHeight);
			System.out.println(g);
			System.out.println(fullImg);
			//Crop the entire page screenshot to get only element screenshot
			//BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,eleHeight);
			ImageIO.write(fullImg, "png", screenshot);
			//Copy the element screenshot to disk

			//String loc="C:/SolutionCentralEngine/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png";

			// screenshotpath.add(loc);
			//File screenshotLocation = new File(loc);
			// FileUtils.copyFile(screenshot, screenshotLocation);
			//if(screenshotpath.size()<TCloop)
			screenshotpath.add("");


		} 
		catch(Exception e ){
			screenshotpath.add("");
			System.out.println(e);
		}
	}
	public boolean clickAnelemnt(WebElement el,String pgname, String elename) 
	{
		stepdefinition.executionTime+=10;
		if(!this.isProxyWebelement(el)){
			//el.click();
			System.out.println(el);
			try{
				action.moveToElement(el).click().build().perform();;
			}
			catch(Exception e)
			{
				System.out.println("Exception occured");
				try {
					action.moveToElement(el).click().build().perform();;
				} catch (WebDriverException e1) {
					err.logError(e1, "error in clicking the element, could mean that element is not in clickable, or something is overlapping the elemnt");
					e1.printStackTrace();
					return false;
				}
			}
			blogger.logMessage(pgname, elename);
			return true;
			//JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			// while(!jse.executeScript("return document.readyState").equals("complete"))
			/** Commented out to check whether issue occurs - long time execution*/
		/*	try
			{
				while(!(Boolean)jse.executeScript("return !!window.jQuery && window.jQuery.active == 0"))
				{
					System.out.println("Waiting");
				}

				return true;
			}
			catch(Exception e)
			{
				return true;
			}*/
		}
		else{
			err.logError(pgname, elename);
			takescreenshot(el);
			return false;
		}

	}

	public WebElement returntablerowbasedonvalues(WebElement table,String[] tablevalues) throws InterruptedException{
		//String keyvaluepairstring = "Service:Ambulatory Surgical Center - Oral Surgery,Place Of Service:Ambulatory Surgical Center,Network Type:In-Network";

		String[] keyvaleupair = tablevalues;

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =-1;
		int i=0;
		//Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		ArrayList<String>    returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");       
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].contains(value)){
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);     
					if(columnvalues[j].contains(value)){
						k=k+1;
						continue;}
					else{
						index=-1;
						break;
					}
				}
			}

		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if(index!=-1){
			if(allRows.size()>0)
				return allRows.get(index);}
		else return null;    
		System.out.println("The row with the matching arguements" + index);  
		Thread.sleep(1000);
		return null;  
	}

	public boolean checkvaluesinDropDown(WebElement table,ArrayList<String> valuestobechecked)
	{
		stepdefinition.executionTime+=10;
		try{
			List<WebElement> lists = table.findElements(By.tagName("option"));
			System.out.println(lists.size());
			ArrayList<String> dropdownoptions = new ArrayList<String>();

			for(WebElement element: lists)  
			{
				String tempval=element.getText();
				tempval=tempval.toLowerCase().trim();
				dropdownoptions.add(tempval);
			}


			for(int i=0;i<valuestobechecked.size();i++)
			{
				System.out.println("Options "+dropdownoptions);
				if(dropdownoptions.contains(valuestobechecked.get(i).toLowerCase()) )
					continue;
				else
				{
					System.out.println("The value "+valuestobechecked.get(i) +" is not present in the applciation drop down");

					return false;
				}
			}

			return true;
		}
		catch(Exception e)
		{
			/*checkvaluesinDropDown(table,valuestobechecked);
			return true;*/
			blogger.loginfo("Element not found");
			return false;
		}
	}

	//	public boolean clickAnelemnt(WebElement el,String pgname, String elename) 
	//    {
	//		if(screenshotpath.size()==0)
	//			screenshotpath.add("Header");
	//		int TCloop=MainDriver.loopvar;
	//		String currenttestcase=MainDriver.testcases.get(1),currentpage,currentaction;
	//		if(MainDriver.testcases.get(TCloop)!="")
	//		{
	//		currenttestcase=MainDriver.testcases.get(TCloop);
	//		}
	//		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
	//		currentpage=MainDriver.pageName.get(TCloop);
	//		currentaction=MainDriver.actions.get(TCloop);
	//           if(!this.isProxyWebelement(el)){
	//                  //el.click();
	//                  Actions action=new Actions(Driver.getPgDriver());
	//                  action.moveToElement(el).click().build().perform();
	//                  blogger.logMessage(pgname, elename);
	//                  JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
	//                  // while(!jse.executeScript("return document.readyState").equals("complete"))
	//                  while(!(Boolean)jse.executeScript("return !!window.jQuery && window.jQuery.active == 0"))
	//                    {
	//                          System.out.println("Waiting");
	//                    }
	////                  try{
	////                        
	////                        
	////                  // Screen shot taken 
	////                    File scrFile = ((TakesScreenshot)Driver.pgDriver).getScreenshotAs(OutputType.FILE);
	////                    FileUtils.copyFile(scrFile, new File("C:/SolutionCentralEngine/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png")); 
	////                    
	////                    // in case screen shot of the element 
	////                    System.out.println("====================**********************+++++++++++++++++++++++++++++++");
	////                        //Get entire page screenshot
	////                        File screenshot = ((TakesScreenshot)Driver.pgDriver).getScreenshotAs(OutputType.FILE);
	////                        BufferedImage  fullImg = ImageIO.read(screenshot);
	////                        //Get the location of element on the page
	////                        org.openqa.selenium.Point point = el.getLocation();
	////                        //Get width and height of the element
	////                        int eleWidth = el.getSize().getWidth()+80;
	////                        int eleHeight = el.getSize().getHeight()+80;
	////                        
	////                        Graphics2D g = (fullImg).createGraphics();
	////                        g.setColor(new Color(177,177,0,77)); //yellow + 30% transparency
	////                        g.fillRect(point.getX(), point.getY(), eleWidth,eleHeight);
	////             System.out.println(g);
	////                        System.out.println(fullImg);
	////                        //Crop the entire page screenshot to get only element screenshot
	////                        //BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,eleHeight);
	////                        ImageIO.write(fullImg, "png", screenshot);
	////                        //Copy the element screenshot to disk
	////                        
	////                        String loc="C:/SolutionCentralEngine/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png";
	////                       
	////                        screenshotpath.add(loc);
	////                        File screenshotLocation = new File(loc);
	////                        FileUtils.copyFile(screenshot, screenshotLocation);
	////                        if(screenshotpath.size()<TCloop)
	////                        	screenshotpath.add("");
	////                        	
	////           
	////                  } 
	////                  catch(Exception e ){
	////                	  screenshotpath.add("");
	////                        System.out.println(e);
	////                  }
	//           }
	//                  
	//                  return true;
	//          
	//		
	//           }


	public boolean enterTextinAnelemnt(WebElement el,String input, String pgname, String elename)
	{
		stepdefinition.executionTime+=15;
		stepdefinition.executionTime+=30;
		try{
			if(!this.isProxyWebelement(el)){
				el.clear();
				el.sendKeys(input);
				blogger.logMessage(pgname, elename);
				return true;
			}
			else{
				err.logError(pgname, elename);
				return false;
			}
		}
		catch(Exception e)
		{
			if(!this.isProxyWebelement(el)){
				el.clear();
				el.sendKeys(input);
				blogger.logMessage(pgname, elename);
				return true;
			}
			else{
				err.logError(pgname, elename);
				return false;
			}

		}

	}	
	/**
	 * Getting value from a text box with prepopulated value 
	 * @param el
	 * @param pgname
	 * @param elename
	 * @return
	 */



	public String  getValuefromTextBox1(WebElement el, String pgname, String elename)
	{
		if(!this.isProxyWebelement(el)){

			blogger.logMessage(pgname, elename);
			System.out.println(el.getAttribute("value"));
			return el.getAttribute("value");
		}
		else{
			err.logError(pgname, elename);

		}
		return "Error";
	}

	public void pressDownnTimes(int n ) throws AWTException, InterruptedException
	{
		Robot robot= new Robot();
		for(int i= 1; i <= n ; i++){
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
		}

	}

	public boolean scrolltoright()
	{stepdefinition.executionTime+=5;
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("window.scrollTo(document.body.scrollWidth,0)") ;
		this.waitforpageload();
		return true;
	}
	
	public boolean scrolltomiddle()
	{stepdefinition.executionTime+=5;
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)") ;
		this.waitforpageload();
		return true;
	}

	public boolean selectDropDownbyVisibleString(WebElement el,String svisibleString,String pgname, String elename ) 
	{stepdefinition.executionTime+=15;
		//waitforpageload();
		System.out.println("Moving to dropdown element ");
		//action.moveToElement(el);
		if(!this.isProxyWebelement(el)){
			action.moveToElement(el);
			Select sel;
			try {
				sel = new Select(el);
				el.click();
			} catch (StaleElementReferenceException e) {
				sel = new Select(el);
				el.click();
			}
			try{sel.selectByVisibleText(svisibleString);
			}
			catch(NoSuchElementException ex){
				ex.printStackTrace();
				err.setErrormessage("Dropdown text is wrong please check");
			}

			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("return document.readyState").equals("complete");
			//return sel.getFirstSelectedOption().getText().equalsIgnoreCase(svisibleString);
			waitforpageload();
			return true;
		}
		else{
			err.logError(pgname, elename);
			return false;
		}

	}

	public boolean selectDropDownbyIndex(WebElement el,int index,String pgname, String elename ) throws InterruptedException
	{
		//waitforpageload();
		System.out.println("Selecting drop down by index");
		//action.moveToElement(el);
		if(!this.isProxyWebelement(el)){
			action.moveToElement(el);
			Select sel= new Select(el);
			el.click();
			System.out.println("Drop down click done");
			Thread.sleep(500);
			sel.selectByIndex(index);
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("return document.readyState").equals("complete");
			//return sel.getFirstSelectedOption().getText().equalsIgnoreCase(svisibleString);
			return true;
		}
		else{
			err.logError(pgname, elename);
			return false;
		}

	}



	public boolean pressEnter(WebElement el, String pgname, String elename)
	{stepdefinition.executionTime+=2;
		if(!this.isProxyWebelement(el)){
			action.moveToElement(el);//.sendKeys(Keys.ENTER).build().perform();

			el.sendKeys(Keys.ENTER);
			blogger.logMessage(pgname, elename);
			return true;
		}
		else{
			err.logError(pgname, elename);
			return false;
		}

	}

	public boolean setAttribute(WebElement element, String attName, String attValue) 
	{
		try{
			JavascriptExecutor js = (JavascriptExecutor) Driver.pgDriver;
			js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", 
					element, attName, attValue);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Not able to set value with exception "+e);
			return false;
		}
	}
	/* i need to wrap the exception around invocation target exception for the ..cucumber exceptions to work
	 * as the exception will be eventually handled as an invocation target exception here that is the reason a 
	 * custom exception class is written
	 */

	public boolean executeMethod(String classname, String methodname,String[] arlist)  {
		try {
			System.out.println("Entered the executemethod");
			boolean returnvalue = false;
			Object returnvalueObject= null;

			Object classobject = Class.forName(classname).newInstance();
			Object castedObject = Class.forName(classname).cast(classobject);
			Class [] argtypes = new Class [] {String[].class};
			//Method method = classobject.getClass().getMethod(methodname,String.class,String.class);
			Method method = classobject.getClass().getMethod(methodname,argtypes);

			try {
				returnvalueObject= method.invoke(classobject,(Object)arlist);
				returnvalue =(Boolean)returnvalueObject;
				//if(returnvalue==false)
				//MainDriverTest.finalresult.add("FAIL");

				//returnvalue=(boolean) method.invoke(classobject,(Object)arlist);
			} catch (IllegalArgumentException e) {
				//MainDriverTest.finalresult.add( "FAIL");
				// TODO Auto-generated catch block
				err.logcommonMethodError(classname, methodname, e);
				e.printStackTrace();
				return returnvalue;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				//MainDriverTest.finalresult.add( "FAIL");
				err.logcommonMethodError(classname, methodname, e);
				e.printStackTrace();
				return returnvalue;
			}
			//takescreenshot();
			return returnvalue;
		}
		catch (InstantiationException e) {
			//MainDriverTest.finalresult.add( "FAIL");
			// TODO Auto-generated catch block
			err.logcommonMethodError(classname, methodname, e);
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e) {
			//MainDriverTest.finalresult.add( "FAIL");
			// TODO Auto-generated catch block
			err.logcommonMethodError(classname, methodname, e);
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//MainDriverTest.finalresult.add( "FAIL");
			err.logcommonMethodError(classname, methodname, e);
			e.printStackTrace();
			return false;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			//MainDriverTest.finalresult.add("FAIL");
			err.commonExecutorlogError("Function");
			e.printStackTrace();
			return false;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			//MainDriverTest.finalresult.add(MainDriverTest.loopvar, "FAIL");
			err.logcommonMethodError(classname, methodname, e);
			e.printStackTrace();
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			//MainDriverTest.finalresult.add( "FAIL");
			err.logcommonMethodError(classname, methodname, e);
			return false;
		}



	}
	public boolean executeMethod(String classname, String methodname)  {
		try {
			boolean returnvalue = false;
			Object returnvalueObject= null;
			Object classobject = Class.forName(classname).newInstance();
			//Object castedObject = Class.forName(classname).cast(classobject);
			Class[] argtypes = new Class[] {};
			//Method method = classobject.getClass().getMethod(methodname,String.class,String.class);
			Method method = classobject.getClass().getMethod(methodname,argtypes);


			try {
				returnvalueObject=method.invoke(classobject);
				returnvalue= (Boolean)returnvalueObject;
				//if(returnvalue==false)
				//MainDriverTest.finalresult.add("FAIL");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				//MainDriverTest.finalresult.add( "FAIL");
				System.out.println("--------------------------------------------------> "+e);
				err.logcommonMethodError(classname, methodname, e);

				e.printStackTrace();
				return returnvalue;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				//MainDriverTest.finalresult.add( "FAIL");
				System.out.println("--------------------------------------------------> "+e);
				err.logcommonMethodError(classname, methodname, e);
				e.printStackTrace();
				return returnvalue;
			}
			catch (NullPointerException e) {
				// TODO Auto-generated catch block
				//MainDriverTest.finalresult.add("FAIL");
				System.out.println("There is no return defined in the Method");
				e.printStackTrace();
				System.out.println("--------------------------------------------------> "+e);
				err.logcommonMethodError(classname, methodname, e);
				return returnvalue;
			}
			//takescreenshot();
			return returnvalue;
		}
		catch (InstantiationException e) {
			//MainDriverTest.finalresult.add( "FAIL");
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			//MainDriverTest.finalresult.add( "FAIL");
			e.printStackTrace();
			System.out.println("--------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//MainDriverTest.finalresult.add( "FAIL");
			e.printStackTrace();
			System.out.println("--------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			//MainDriverTest.finalresult.add( "FAIL");
			e.printStackTrace();
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			//MainDriverTest.finalresult.add( "FAIL");
			e.printStackTrace();
			System.out.println("--------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch(Exception e){
			e.printStackTrace();
			//MainDriverTest.finalresult.add( "FAIL");
			System.out.println("Common Exception  --------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		}


	}
	// need to handle the exceptions
	public WebElement returnWebelement(String classname, String elename)  throws Exception {
		System.out.println("converting to webelemetn");
		Object classobject = Class.forName("automationLib."+classname).newInstance();
		Field elf = classobject.getClass().getDeclaredField(elename);
		elf.setAccessible(true);
		Object elementObject = elf.get(classobject);
		//Object returnobject =method.invoke(classobject);
		//WebElement el = (WebElement)returnobject;
		return (WebElement)elementObject;


	}

	public  ArrayList<String> conditionArguements(String args){
		String value = args;
		Integer pos = 0;
		Integer length =0;

		ArrayList<String> returnArray = new ArrayList<String>();
		if(value.contains(",")){
			for(int i=0;i<args.length();i++){
				if(args.charAt(i)==','){
					returnArray.add(value.substring( pos,i));
					pos=i+1;}


			}
			returnArray.add(value.substring(pos, args.length()));
		}
		else{
			returnArray.add(args);
		}
		return returnArray;
	}
	public String[] stringarrayListtoStringarray(ArrayList<String> arlist){

		String[] rtnstringarray = new String[arlist.size()];
		rtnstringarray= arlist.toArray(rtnstringarray);
		return rtnstringarray;
	}
	public ArrayList<String> stringarraytoStringarrayList(String[] arlist){

		ArrayList<String> rtnstringarray = (ArrayList<String>) Arrays.asList(arlist);

		return rtnstringarray;
	}
	public  ArrayList<String> makearraysequalsize(ArrayList<String> arrayneedsequalization, ArrayList<String> araaytowhichtobeequalledto){

		if(!(araaytowhichtobeequalledto.size()== arrayneedsequalization.size())){
			for (int i = 2;i<araaytowhichtobeequalledto.size();i++)
				arrayneedsequalization.add("");

		}
		return arrayneedsequalization;
	}

	public boolean checkIfErrorPage()
	{


		if((Driver.pgDriver.getPageSource().contains("internal error"))||(Driver.pgDriver.getPageSource().contains("page not found")))
		{
			return false;

		}
		else
			return true;


	}

	public void refreshthepage()
	{
		int count=0;
		try
		{
			count++;

			do{
				if(!checkIfErrorPage())
				{
					Driver.pgDriver.navigate().refresh();
				}
				else
					break;
			}while(count<3);


		}
		catch(Exception e)
		{

		}
	}

	public void refreshPage()
	{
		try{
			Driver.pgDriver.navigate().refresh();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}



	public void gotoback()
	{
		try{
			Driver.pgDriver.navigate().back();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void goforward()
	{
		try{
			Driver.pgDriver.navigate().forward();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public  int findNextest(ArrayList<String> testcase, int errorrow){

		int nexttestrow =0;
		for(int i=errorrow+1;i<testcase.size();i++){
			if(!testcase.get(i).equals("")){
				nexttestrow =i;
				break;
			}


		}

		return nexttestrow;
	}

	public boolean isAlertPresent(){ 
		try{ /*3/4 - Elby the alert is present methods defult time setting is being changed to 5 secondd, ther emight be extra logic need
		need to be added to handle this better as the driver may not show up alerts within 5 seconds
		
		 	*/
			Alert a = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
			if(a!=null){
				System.out.println("Alert is present");
				driver.switchTo().alert().accept();
				return true;
			}else{
				throw new Throwable();
			}
		} 
		catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false; 
		} 

	} 
	public String getValuefromTextBox(WebElement ele, String page, String elementname){
		return "String";
	}

	public boolean isValueCannotbeBlankErrorPresent(WebElement el, String identifier){
		stepdefinition.executionTime+=5;
		if(!this.isProxyWebelement(el)){
			return el.getAttribute("id").contains(identifier);
		}
		else return false;
	}

	public boolean iselementhavefocus( String attribute, String value){

		WebElement activeelement = Driver.getPgDriver().switchTo().activeElement();
		String actelemntattributevalue ="";
		actelemntattributevalue= activeelement.getAttribute(attribute);
		System.out.println(actelemntattributevalue);
		System.out.println(actelemntattributevalue.length());


		if(actelemntattributevalue.equals(value)){
			System.out.println("returning true");
			return true;
		}             
		else if(!(actelemntattributevalue.length()>0)){
			System.out.println("calling is focus again");
			this.iselementhavefocus(attribute, value);
		}else return false;

		return true;
	}

	public boolean validateHeader(WebElement header , String sCheckHEader)
	{stepdefinition.executionTime+=10;
		this.waitforpageload();
		if(header.isDisplayed())
		{
			if(header.getText().trim().equalsIgnoreCase(sCheckHEader))
			{
				System.out.println("Pass : The header matches the specks and is displayedfor the text :"+ sCheckHEader+ "\n\n");
				return true ;
			}
		}
		err.logError("The header does not match the specified text."+ sCheckHEader+ "Instead the header present is "+header.getText().toString()+"\n\n");
		return false; 


	}

	public WebElement getAccumulatortablerowbasedonvalues(WebElement table,String[] tablevalues) throws InterruptedException{
		//String keyvaluepairstring = "Service:Ambulatory Surgical Center - Oral Surgery,Place Of Service:Ambulatory Surgical Center,Network Type:In-Network";

		String[] keyvaleupair = tablevalues;

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =0;
		int i=0;
		//Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		ArrayList<String>    returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");       
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].equalsIgnoreCase(value)){
				System.out.println("Performing the check. Entered the loop");
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);     
					if(columnvalues[j].equalsIgnoreCase(value)){
						k=k+1;
						continue;}
					else{
						index=-1;
						break;
					}
				}
			}
			System.out.println("Didnt enter loop");

		}
		//List<WebElement> allRows = table.findElements(By.tagname("tr")));
		List<WebElement> allRows = table.findElements(By.xpath("//tr[@pl_index]"));
		if(index!=-1){
			if(allRows.size()>0)       	   
				return allRows.get(index-1);
			System.out.println("The row with the matching arguements" + (index-1));
			// allRows.get(index).click();
		}

		else return null;   
		System.out.println("The row with the matching arguements" + (index-1));  
		Thread.sleep(1000); 
		return null;
	} 


	public void lognotexecuted(int start,int end, int lastrowinexcel){
		if(!(end==0)){
			for (int i=start;i<end;i++)	
				screenshotpath.add("Not Executed");

		}
		else{
			for (int i=start;i<=lastrowinexcel;i++)	
				screenshotpath.add("Not Executed");
		}
	}


	public void writeHTMLFile(String FileName,ArrayList<String> testcase,ArrayList<String> page, ArrayList<String> actions,ArrayList<String> arguements, ArrayList<String> result,ArrayList<String> screenshotpath,ArrayList<String> finalresult) throws IOException {	
		try {
			Date date1=new Date();
			ArrayList<Integer> TCindex=new ArrayList<Integer>();
			String resultExcel = FileName;//name of excel file
			String sheetName = "Result";
			int indexoflastslash = FileName.lastIndexOf("\\");
			String testcaseName= FileName.substring(indexoflastslash+1,FileName.length()-5 );
			String folder = FileName.substring(0,indexoflastslash);
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date1);
			System.out.println(timeStamp);
			//String reportIn = FileUtils.readFileToString(file);
			final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
			SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
			String currentdate=sdfr.format( date );	  
			String reportIn="<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"C:/SolutionCentralEngine/Report_style/config.css\"><title>Report generated on #DATETIME#</title><script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script></head><div class=\"header\"><img src=\"C:/SolutionCentralEngine/Report_style/Anthem.png\" alt=\"logo\" /><body><h3>Test results</h3><table border=\"1\"><col width=\"500\"><col width=\"80\"><tr><th align=\"left\">TestCase</th><th align=\"left\">Result</th></tr><!-- INSERT_RESULTS --></table><script>function showDetails(elemntid) {$(document).ready(function(){var target =$('#'+elemntid).attr(\"id\");$(\"table[title=\"+target).toggle();});}</script></body>";
			String temp=reportIn;
			temp = temp.replaceFirst("#DATETIME#",currentdate );
			int flag=0;
			int testcasestart=0;	//TO HAVE A POINTER ON THE RESULKT ARRAY
			int testcasecount=0;
			for(int i=0;i<testcase.size();i++)
			{
				if(testcase.get(i)!="")
				{

					TCindex.add(testcase.indexOf(testcase.get(i)));  //1,7,15
				}

			}
			TCindex.add(testcase.size());



			try{


				for(int i=1;i<=TCindex.size();i++)
				{
					int loopcount=0;
					//System.out.print("Size :"+TCindex.size()+"   Index:"+TCindex.get(i));

					temp = temp.replaceFirst(resultPlaceholder,"<tr id=\""+testcase.get(TCindex.get(i))+"\" onclick=\"showDetails(this.id)\"><td><b>" + testcase.get(TCindex.get(i)) +"</b></td><td>"+finalresult.get(i)+"</td></tr>"+ resultPlaceholder);

					temp=temp.replaceFirst(resultPlaceholder,"<tr><td><table title=\"" +testcase.get(TCindex.get(i))+"\" style =\"display:none\" ><tr><th colspan=\"3\">Page</th><th colspan=\"3\">Action</th><th colspan=\"3\">Result</th><th colspan=\"3\">Screen Shot</th></tr><tr> "+resultPlaceholder);
					for (int k = 1; k <=(TCindex.get(i+1)-TCindex.get(i));k++)
					{
						//System.out.println("     "+(TCindex.get(i+1)-TCindex.get(i)));
						loopcount++;

						if(result.get(k+testcasestart)!="Not Executed")
							temp = temp.replaceFirst(resultPlaceholder,"<tr><td colspan=\"3\">" + page.get(k+testcasestart) + "</td><td colspan=\"3\">" + actions.get(k+testcasestart) + "</td><td colspan=\"3\">"  + result.get(k+testcasestart) +"</td><td colspan=\"3\"><a href='"+screenshotpath.get(k+testcasestart)+"'\">click here</a></td></tr>"+ resultPlaceholder);

						//temp = temp.replaceFirst(resultPlaceholder,"<tr><td colspan=\"3\">" + page.get(k+testcasestart) + "</td><td colspan=\"3\">" + actions.get(k+testcasestart) + "</td><td colspan=\"3\">" + arguements.get(k+testcasestart) + "</td><td colspan=\"3\">"  + result.get(k+testcasestart) +"</td><td colspan=\"3\"><a href='"+screenshotpath.get(k+testcasestart)+"'\">click here</a></td></tr>"+ resultPlaceholder);
						else
							temp = temp.replaceFirst(resultPlaceholder,"<tr><td colspan=\"3\">" + page.get(k+testcasestart) + "</td><td colspan=\"3\">" + actions.get(k+testcasestart) + "</td><td colspan=\"3\">"  + result.get(k+testcasestart) +"</td><td colspan=\"3\">Not Executed</td></tr>"+ resultPlaceholder);	
					}
					testcasestart=testcasestart+loopcount;
					temp=temp.replaceFirst(resultPlaceholder,"</table></td></tr>"+resultPlaceholder);



				}


			}
			catch(Exception e)
			{


				temp=temp.replaceFirst(resultPlaceholder,"</table></td></tr>"+resultPlaceholder);
				System.out.println("Error in testcase indexloop");
			}

			String reportPath = folder+"\\"+testcaseName+"_result_"+timeStamp+ ".html";
			BufferedWriter bw = new BufferedWriter(new FileWriter(reportPath));
			bw.write(temp);
			bw.close();
			//Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);

		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}

	public boolean getcolumnStringFromTableByNamesetofElements(WebElement tbl, String sData, int sSubstring){

		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		//MbrSrchResults[] msr = null;
		int rowindex=0;
		int columnindex=0;
		int iterator =0;
		System.out.println(allRows.size());
		for (WebElement row : allRows) {
			List<WebElement> allColsByRow =row.findElements(By.tagName("td"));
			{
				System.out.println("Row "+rowindex++ +" : "+row.getText());
				if(row.getText().length()>2){
					if(row.getText().substring(0, sSubstring).equalsIgnoreCase(sData))
					{
						iterator++;
						System.out.println(iterator);
						continue;
					}
				}

			}
		}
		if(iterator==(allRows.size()-1))
		{
			System.out.println("Pass : The following table contains the values to be checked with the substring.\n\n");
			return true;
		}
		return false;
	}

	public boolean validateLabel(WebElement label , String sCheckHEader)
	{String actualvalue="";
	stepdefinition.executionTime+=10;
	if(label.isDisplayed())

	{action.moveToElement(label).build().perform();
	takescreenshot("value_Check", sCheckHEader);

	actualvalue = label.getText().trim();
	if (isvalueMatch_contain(actualvalue, sCheckHEader))              
		return true ;             
	else if(isvalueMatch_contain(actualvalue.toLowerCase(), sCheckHEader.toLowerCase())){
		blogger.loginfo("The values are matched by converting to lowercase");
		return true;}

	else 
	{
		err.logerrormessage("The values does not match expected: "+sCheckHEader+" but actual value is "+actualvalue);
		return false;
	}
	}
	err.logerrormessage("The values does not match expected: "+sCheckHEader+" but actual value is "+actualvalue);
	return false; 
	}

	public boolean validateBenefitRowValues(WebElement tbl,String[] tablevalues)
	{stepdefinition.executionTime+=30;
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		Boolean varstate=false;
		int k=1;
		ArrayList<String> resultarray = new ArrayList<String>();
		//	if (allRows.size() > 0){
		//	ArrayList<String> headerrow = new ArrayList<String>();
		//	headerrow= getheaderrowFromTable(tbl);
		//	if(headerrow.size()>0){
		//	columnindex=returnindexofelemntinanarray(headerrow, columnName);
		//	resultarray.add(columnName);

		//msr = new MbrSrchResults[allRows.size()];
		for (WebElement row : allRows) {
			List<WebElement> allColsByRow=null;
			try
			{
				allColsByRow =row.findElements(By.tagName("td"));
				System.out.println(allColsByRow.size());
				for(int i=0;i<allColsByRow.size();i++)
				{
					System.out.println("------>"+allColsByRow.get(0).getText()+"\n");
					System.out.println("xxxxxxxxxxxxxxxx>"+tablevalues[0].trim()+"\n");
					if(allColsByRow.get(1).getText().contains(tablevalues[0].trim()))
					{
						System.out.println("The Amount you pay : In Network value"+allColsByRow.get(2).getText().replace(",","").replace("\n", " ")+"end");
						System.out.println("The Amount you pay : Out Network value"+allColsByRow.get(7).getText().replace(",","").replace("\n", " ")+"end");
						System.out.println("The value"+tablevalues[1].trim()+" end");
						System.out.println("The value"+tablevalues[2].trim()+" end");

						if(allColsByRow.get(2).getText().replace(",","").replace("\n", " ").contains(tablevalues[1].trim()))
						{
							if(allColsByRow.get(7).getText().replace(",","").replace("\n", " ").contains(tablevalues[2].trim()))
							{
								varstate=true;
								return true;
							}
							else
							{
								varstate=false;
								break;

							}

						}
						else
						{
							varstate=false;
							break;

						}
					}

					else
						break;
				}


			}

			catch(Exception e)
			{
				continue;
			}


		}
		if(!varstate)
		{
			err.logError("Benefit Selection", "Values dont match with the expected ones");
			return false;

		}
		else
			return true;


	}

	public boolean validateRowValues(WebElement tbl,String[] tablevalues)
	{
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		Boolean varstate=false;
		System.out.println(tablevalues+"Size  "+tablevalues.length);
		ArrayList<String> resultarray = new ArrayList<String>();


		for (WebElement row : allRows) {
			List<WebElement> allColsByRow=null;
			try
			{
				allColsByRow =row.findElements(By.tagName("td"));


				if(allColsByRow.get(0).getText().contains(tablevalues[0]))
				{
					for(int j=1;j<=tablevalues.length-1;j++)
					{

						for(int k=0;k<allColsByRow.size();k++)
						{
							System.out.println("Actual "+allColsByRow.get(k).getText()+" Expected "+tablevalues[j]);
							if(allColsByRow.get(k).getText().contains(tablevalues[j]))
							{
								varstate=true;
								break;
							}
							else
							{

								varstate=false;

							}

						}
						if(varstate==false)
						{
							System.out
							.println(tablevalues[j-1] +" doesnt match with the value on the applciation");
							err.logError("Benefit Selection", "Values dont match");
							return false;
						}
						else
							continue;

					}



				}
				else
					break;
			}


			catch(Exception e)
			{
				continue;

			}



		}
		if(!varstate)
		{
			System.out.println("Values dont match");
			err.logError("Benefit Selection", "Values dont match");
			return false;

		}
		else
		{
			System.out.println("Values match");
			return true;
		}

	}

	public int getRowNumber(WebElement tbl,String[] tablevalues)
	{
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));

		int rowno=0;
		ArrayList<String> resultarray = new ArrayList<String>();

		outerloop:
			for (WebElement row : allRows) {
				rowno++;
				List<WebElement> allColsByRow=null;
				try
				{
					allColsByRow =row.findElements(By.tagName("td"));


					if(allColsByRow.get(0).getText().contains(tablevalues[0]))
					{
						for(int j=1;j<tablevalues.length;j++)
						{

							for(int k=0;k<allColsByRow.size();k++)
							{

								if(allColsByRow.get(k).getText().toLowerCase().contains(tablevalues[2].toLowerCase()))
								{
									System.out.println("col no "+k+allColsByRow.get(k).getText()+" row num   "+rowno);
									break outerloop;
								}


							}


						}


					}
					else
						break;
				}




				catch(Exception e)
				{
					continue;
				}




			}
		return rowno;

	}


	public boolean validateValueinelement(WebElement el, String value,String pgname,String elementname) throws Exception{
		stepdefinition.executionTime+=10;
		return validateLabel(el,value);
	}

	public boolean validateValueinelement(WebElement el, String value) throws Exception{
		stepdefinition.executionTime+=10;
		return validateLabel(el, value);
	}

	public boolean clickontablebasedonrowandcolumn(WebElement tbl,int rowno,int columnno)
	{
		stepdefinition.executionTime+=30;
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		//System.out.println(allRows.size());
		//MbrSrchResults[] msr = null;


		if (allRows.size() > 0){
			//ArrayList<String> headerrow = new ArrayList<String>();
			//headerrow= getheaderrowFromTable(tbl);
			//if(headerrow.size()>0){
			//columnindex=returnindexofelemntinanarray(headerrow, columnName);
			//resultarray.add(columnName);
			//System.out.println(columnName+" is found at the position of "+columnindex);
			//}
			//msr = new MbrSrchResults[allRows.size()];


			List<WebElement> allColsByRow=null;
			try
			{
				allColsByRow =allRows.get(rowno).findElements(By.tagName("td"));
				allColsByRow.get(columnno).click();

			}
			catch(Exception e)
			{
				return false;
			}



		}


		return true;

	}

	public boolean clickontablerowbasedonvalues(WebElement table,String[] tablevalues) throws InterruptedException{
		//String keyvaluepairstring = "Service:Ambulatory Surgical Center - Oral Surgery,Place Of Service:Ambulatory Surgical Center,Network Type:In-Network";
		stepdefinition.executionTime+=30;
		String[] keyvaleupair = tablevalues;

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =0;
		int i=0;
		//Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		ArrayList<String>    returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");       
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].contains(value)){
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);     
					if(columnvalues[j].contains(value)){
						k=k+1;
						continue;}
					else{
						index=-1;
						break;
					}
				}
			}

		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if(index!=-1){
			if(allRows.size()>0)
				allRows.get(index).click();}
		else return false;   
		System.out.println("The row with the matching arguements" + index);  
		Thread.sleep(1000);
		return true;  
	}

	public boolean clickontablerowbasedonvalues(WebElement table,String tablevalues) throws InterruptedException{
		//String keyvaluepairstring = "Service:Ambulatory Surgical Center - Oral Surgery,Place Of Service:Ambulatory Surgical Center,Network Type:In-Network";
		stepdefinition.executionTime+=30;
		String[] keyvaleupair = tablevalues.split(",");

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =0;
		int i=0;
		//Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		ArrayList<String>	 returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");		
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].equalsIgnoreCase(value)){
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);	
					if(columnvalues[j].equalsIgnoreCase(value)){
						k=k+1;
						continue;}
					break;
				}
			}

		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if(allRows.size()>0)
			allRows.get(index).click();

		System.out.println("The row with the matching arguements" + index);	
		Thread.sleep(1000);
		return true;	
	}

	public boolean TabHandles(String sUrl ) {

		//Get the list of all window handles
		//WebDriverWait wait=new WebDriverWait(Driver.pgDriver,20);
		//wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> windowHandles = new ArrayList<String>(Driver.pgDriver.getWindowHandles());
		System.out.println(windowHandles.size());
		System.out.println(windowHandles.toString());
		ArrayList<String> windowHandles1 = new ArrayList<String>(Driver.pgDriver.getWindowHandles());
		System.out.println(windowHandles1.toString());
		for (String window:windowHandles1){
			System.out.println(window );
			System.out.println("Title of the page---------------"+Driver.pgDriver.getTitle().toString());
			System.out.println("URL of the page---------------"+Driver.pgDriver.getCurrentUrl());
			try{
				Driver.pgDriver.switchTo().window(window);
			}
			catch(Exception e)
			{
				System.out.println("exception part");
				continue;
			}
			if(Driver.pgDriver.getCurrentUrl().contains(sUrl))
			{
				Driver.getPgDriver().manage().window().maximize();
				System.out.println("Maximised->currenturl");
				return true;
			}
			else if(Driver.pgDriver.getTitle().toString().contains(sUrl))
			{
				Driver.getPgDriver().manage().window().maximize();
				System.out.println("Maximised->titile");
				return true;
			}else{
				System.out.println("Urlnot match ");
				continue;

			}

		}
		return false;
	}

	public boolean validateTableRowHeader(WebElement tbl,String[] tablevalues)
	{stepdefinition.executionTime+=20;
		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		Boolean varstate=false;
		System.out.println(tablevalues+"Size  "+tablevalues.length);
		ArrayList<String> resultarray = new ArrayList<String>();


		for (WebElement row : allRows) {
			List<WebElement> allColsByRow=null;
			try
			{
				allColsByRow =row.findElements(By.tagName("th"));
				for(int g=0;g<allColsByRow.size();g++)
					System.out.println("Value in "+g + " column "+allColsByRow.get(g).getText());       

				if(allColsByRow.get(0).getText().contains(tablevalues[0]))
				{
					for(int j=0;j<=tablevalues.length;j++)
					{

						for(int k=0;k<allColsByRow.size();k++)
						{
							if(allColsByRow.get(k).getText().toLowerCase().contains(tablevalues[j].toLowerCase()))
							{
								System.out.println("Column "+k+allColsByRow.get(k).getText() +" ----- "+ tablevalues[j]+"samptocheckspace");

								varstate=true;
								break;
							}
							else
							{

								varstate=false;

							}

						}
						if(varstate==false)
						{
							System.out
							.println(tablevalues[j] +" doesnt match with the value on the applciation");
							err.logError("Benefit Selection", "Values dont match");
							return false;
						}
						else
							continue;

					}


				}
				else
					break;
			}




			catch(Exception e)
			{
				continue;
			}




		}
		if(!varstate)
		{
			System.out.println("Values dont match");
			err.logError("Benefit Selection", "Values dont match");
			return false;

		}
		else
		{
			System.out.println("Values match");
			return true;
		}

	}

	public boolean waitforpageload()
	{
		stepdefinition.executionTime+=12;
		try{

			WebDriverWait wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='SolutionCenterContainerr'']")));
			System.out.println("Checking for Loading Icon");
		}
		catch(TimeoutException e){
			System.out.println("No loading icon. Continue " +e);
			return true;
		}
		try{
			wait=new WebDriverWait(Driver.getPgDriver(),100);
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));


		}
		catch(TimeoutException e){
			if(!stepdefinition.isServicedown){
			System.out.println("Loading for too long ");
			ExtentManager.setTeststatus("Warning - Application Slowness");
			stepdefinition.isServicedown=true;
			}
			return true;

		}
		System.out.println("Came out");
		return true;
	}

	public void storeDataTemp(String valuetocheck)
	{
		String key = valuetocheck.substring(0, valuetocheck.indexOf(":")).toLowerCase();
		String value = valuetocheck.substring(valuetocheck.indexOf(":")+1).toLowerCase();
		System.out.println("key " + key + "value  " + value);
		valuebox.put(key, value);
	}

	public String getDataTemp(String keyval)
	{
		String key ;
		System.out.println( valuebox.get(keyval));
		return valuebox.get(keyval);

	}

	public WebElement getTablerowbasedonvalues(WebElement table,String[] tablevalues) throws InterruptedException{
		stepdefinition.executionTime+=20;
		String[] keyvaleupair = tablevalues;

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =0;
		int i=0;
		//Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		ArrayList<String>    returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");       
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].replace("\n"," ").trim().contains(value)){
				System.out.println("Performing the check. Entered the loop");
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);     
					if(columnvalues[j].replace("\n"," ").trim().contains(value)){
						k=k+1;
						continue;}
					else{
						index=-1;
						break;
					}
				}
			}
			System.out.println("Didnt enter loop");

		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if(index!=-1){
			if(allRows.size()>0) 
				System.out.println("The row with the matching arguments" + (index));  
			return allRows.get(index);         
		}
		else return null;   
	}

	public boolean validatetablerowbasedonvalues(WebElement table, String tablevalues){
		stepdefinition.executionTime+=30;
		String[] keyvaleupair = tablevalues.split(",");

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =0;
		int i=0;
		//Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		ArrayList<String>    returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");       
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].equalsIgnoreCase(value)){
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);     
					if(columnvalues[j].equalsIgnoreCase(value)){
						k=k+1;
						continue;}
					break;
				}
			}

		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if(allRows.size()>0){
			try{
				if(allRows.get(index).findElement(By.xpath(".//img")).isDisplayed()){
					allRows.get(index).click();
				}
			}catch(Exception e){
				System.out.println("Element is not selected: Check Input");   
				return false;
			}
		}


		System.out.println("The row with the matching arguements" + index);  
		return true;  


	}
	public boolean validatetablerowbasedonvalues(WebElement table, String[] tablevalues){
		String[] keyvaleupair = tablevalues;
		System.out.println("Keyvaluepair size is: "+ keyvaleupair.length);
		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][] = new String[keyvaleupair.length][2];
		String[] keys = keyvaleupair;
		int index = 0;
		int i = 0;
		ArrayList<String> returncolumn = new ArrayList<String>();
		int somevalue = 1;
		for (String iterator : keyvaleupair) { 
			keys = iterator.split(":");
			inputcolumnvaluemap[i][0] = keys[0];
			inputcolumnvaluemap[i][1] = keys[1];
			i = i + 1;
			returncolumn = getcolumnStringFromTableByName(table, keys[0].replaceAll("\n", " "));
			if(!(returncolumn.size()>1))				
				return false;			
			System.out.println("Values in return column: "+returncolumn);
			String[] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
			//System.out.println("Values in columnvaluesmap are: "+ columnvaluesmap.toString());
		}
		int k = 0;
		for (int j = 0; j < returncolumn.size(); j++) {
			if (k == keyvaleupair.length)
				break;
			String column = inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);
			columnvalues[j]= columnvalues[j].toString().replaceAll("\n", "").trim();
			if (columnvalues[j].equalsIgnoreCase(value)) {
				index = j;

				while (k < keyvaleupair.length) {
					column = inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);
					System.out.println("Input value: "+ value + " " + "And the value in the tables are: " + columnvalues[j]);
					if (columnvalues[j].equalsIgnoreCase(value)) {
						System.out.println("K size is: "+ k);
						k = k + 1;
						continue;
					} else {
						index = -1;
						break;
					}
				}
			}
		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if (index != -1) {
			if (allRows.size() > 0)
				//allRows.get(index).click();
				System.out.println("Values matched with the row");
			System.out.println("The row with the matching arguements" + index);
			return true;
		} else {
			System.out.println("Values doesnt matched with row");
			return false;
		}
		
		//return true;
	}

	public WebElement getProviderResultsBasedOnValues(WebElement table,String[] tablevalues) throws InterruptedException{  
		String[] keyvaleupair = tablevalues;

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =0;
		int i=0;

		ArrayList<String>    returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");       
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].replace("\n"," ").trim().contains(value.toUpperCase())){
				System.out.println("Performing the check. Entered the loop");
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);     
					if(columnvalues[j].replace("\n"," ").trim().contains(value.toUpperCase())){
						k=k+1;
						continue;}
					else{
						index=-1;
						break;
					}
				}
			}
			System.out.println("Didnt enter loop");

		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if(index!=-1&&index!=0){
			if(allRows.size()>0)
				System.out.println("The row with the matching arguments" + (index));
			allRows.get(index).click();
			return allRows.get(index);
		}
		else return null;
	}

	public boolean doubleclickanelement(WebElement element,String pgname, String elename)
	{stepdefinition.executionTime+=10;
		if(!this.isProxyWebelement(element)){
		//el.click();
		System.out.println(element);
		try{
			action.moveToElement(element).doubleClick().build().perform();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured  in the double click");
			action.moveToElement(element).doubleClick().build().perform();;
		}
		blogger.logMessage(pgname, elename);
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		// while(!jse.executeScript("return document.readyState").equals("complete"))
		try
		{
			while(!(Boolean)jse.executeScript("return !!window.jQuery && window.jQuery.active == 0"))
			{
				System.out.println("Waiting");
			}

			return true;
		}
		catch(Exception e)
		{
			return true;
		}
	}
	else{
		err.logError(pgname, elename);
		takescreenshot(element);
		return false;
	}

	}

	public boolean rightClickanElement(WebElement element, String pgname, String elementname){

		if(!this.isProxyWebelement(element)){
			//el.click();
			System.out.println(element);
			try{
				action.moveToElement(element).contextClick().build().perform();
			}
			catch(Exception e)
			{
				System.out.println("Exception occured  in the double click");
				action.moveToElement(element).contextClick().build().perform();;
			}
			blogger.logMessage(pgname, elementname);
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			// while(!jse.executeScript("return document.readyState").equals("complete"))
			try
			{
				while(!(Boolean)jse.executeScript("return !!window.jQuery && window.jQuery.active == 0"))
				{
					System.out.println("Waiting");
				}

				return true;
			}
			catch(Exception e)
			{
				return true;
			}
		}
		else{
			err.logError(pgname, elementname);
			takescreenshot(element);
			return false;
		}


	}

	/*public void takescreenshot(String methodname,String classname)
	{stepdefinition.executionTime+=20;
		String loc=null;
		try{

			if(screenshotpath.size()==0)
				screenshotpath.add("Header");
			//int TCloop=MainDriver.loopvar;
			String currentpage,currentaction;
			//String currenttestcase="TC_"+count;
			//String currenttestcase=MainDriver.testcases.get(1),currentpage,currentaction;

			//String currenttestcase=name;

			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
			currentpage=classname;
			currentaction=methodname;

			// Screen shot taken 
			File scrFile = ((TakesScreenshot)Driver.pgDriver).getScreenshotAs(OutputType.FILE);

			String reportLocation=System.getProperty("TEST_EXECUTION_REPORT");
			String buildNumber= System.getProperty("TEST_BUILD");
			try{
				if(!reportLocation.isEmpty() && !buildNumber.isEmpty()) {
					reportLocation=reportLocation+"//TestExecutionRecords//"+buildNumber;
					FileUtils.copyFile(scrFile, new File(reportLocation+"/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png")); 
					loc="../../"+buildNumber+"/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png";
				}else if(reportLocation.isEmpty()&& !buildNumber.isEmpty()){
					reportLocation="TestExecutionRecords//"+buildNumber+"//";
					FileUtils.copyFile(scrFile, new File(reportLocation+"/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png")); 
					loc="../../"+buildNumber+"/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png";
				} else {
					reportLocation="C://SolutionCentralEngine";
					FileUtils.copyFile(scrFile, new File(reportLocation+"/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png")); 
					loc="../Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png";
				}

			}catch(NullPointerException e){
				reportLocation="C://SolutionCentralEngine";
				//reportLocation="C://SolutionCentralEngine//Screenshots";
				FileUtils.copyFile(scrFile, new File(reportLocation+"/Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png")); 
				loc="../Screenshots/"+currenttestcase+"_"+currentpage+"_"+currentaction+"_"+ timeStamp +".png";
			}

		}
		catch(Exception e)
		{
			System.out.println("Not able to take screen shot due to "+e);
			err.logError(e, methodname);
		}
		try {
			if (loc!=null)
				stepdefinition.logger.info(methodname+"  ",MediaEntityBuilder.createScreenCaptureFromPath(loc).build());
		}
		catch(IOException e){
			blogger.logMessage(classname, methodname);
		}
	}*/
	public boolean isvalueMatch_contain(String actual, String expected){
		stepdefinition.executionTime+=10;

		if(actual.trim().contains(expected.trim()))
		{
			blogger.loginfo(expected, actual);
			return true;
		}
		else if(actual.trim().length()>0){
			if(expected.trim().contains(actual.trim()))
			{
				blogger.loginfo(expected, actual);
				return true;
			}
			return false;
		}
		else{
			stepdefinition.isServicedown=true;
			err.logvaluenotmatch(actual, expected);
			setServiceDown("Actual Result from Application:"+actual);
			return false;
		}

	}

	public boolean isvalueMatch_compareto(String actual, String expected){
		stepdefinition.executionTime+=10;
		int compare=actual.trim().compareToIgnoreCase(expected.trim());
		if(compare==0)
		{
			blogger.loginfo(expected, actual);
			return true;
		}


		else{
			err.logvaluenotmatch(actual, expected);
			return false;
		}

	}


	public boolean verifyAlertText(String value) throws Exception
	{
		String alertMessage=null;
		Alert a = new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
		if(a!=null)
		{	       	         
			alertMessage=driver.switchTo().alert().getText();
			System.out.println("presented text in alert is:"+alertMessage);
		}	        
		isAlertPresent();
		if(alertMessage.trim().toLowerCase().contains(value.toLowerCase()))
		{
			System.out.println("+++++++++++++++++++++++Alert Message Verified++++++++++++++++++++++++++"+value);
			return true;
		}
		else 
		{
			System.out.println("FAIL");
			err.logvaluenotmatch(alertMessage, value);
			throw new CustomException("alert text mismatches");
		}


	}

	public int getIndexValueOfStringArray(String[] value, String args) {
		int index = 0;
		for (int i=0;i<value.length;i++) {
			if (value[i].contains(args)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public boolean isServiceDown(){
		stepdefinition.executionTime+=5;
		try{
			this.waitforpageload();
			WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(), 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Unable')])[1] | //div[contains(text(),'No results')]")));
			clickAnelemnt((Driver.getPgDriver().findElement(By.xpath("(//*[contains(text(),'Unable')])[1] | //div[contains(text(),'No results')]"))),"Service Down", "Service Down");
			err.logerrormessage("service down-unable to retrive data");
			blogger.logserviceDown();
			ExtentManager.setTeststatus("Warning - Service Down");
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
		catch(NoSuchElementException e){
			return false;
		}

	}

	public boolean switchToLastWindow(){

		Set<String> Windows=driver.getWindowHandles();

		System.out.println("THe window Size is: "+Windows.size());	
		int i=1;
		try {
			for (String window:Windows){				
				driver.switchTo().window(window);
				System.out.println("The "+i+"st window switched");
				i++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}




	public boolean selectValueFromListbyVisibleString(WebElement el,String svisibleString,String pgname, String elename )
	{stepdefinition.executionTime+=10;
		boolean eleClicked = false;
		try
		{
				el.click();
				Thread.sleep(1000);
				List<WebElement> allElement = Driver.pgDriver.findElements(By.xpath("//ul[contains(@id,'pyNavigation')]//li//a"));
				for(WebElement ele : allElement)
				{

					String ele1 = ele.getText();
					System.out.println("Elem: "+ele1);
					if(svisibleString.equalsIgnoreCase(ele1))
					{
						ele.click();
						eleClicked =  true;
						break;
					}

				}
		}
		catch(Exception ex){
			ex.printStackTrace();
			eleClicked =  false;
		}
		
		if(eleClicked) {
			blogger.loginfo("Element clicked");
			return true;
		}else {
			blogger.loginfo("Element not clicked");
			return false;
		}
	}



	public boolean waitForElementToBeClickabale(WebElement element)
	{
		try
		{

			WebDriverWait wait=new WebDriverWait(Driver.pgDriver,6);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			blogger.loginfo("Element clickable");
			return true;
		}catch(Exception e)
		{
			blogger.loginfo("Element not clickable" +e);
			return false;
		}
	}
	
	public boolean waitForElementToBeVisible(WebElement element)
	{
		try
		{

			WebDriverWait wait=new WebDriverWait(Driver.pgDriver,2);
			wait.until(ExpectedConditions.visibilityOf(element));
			blogger.loginfo("Element visible");
			return true;
		}catch(Exception e)
		{
			blogger.loginfo("Element not visible" +e);
			return false;
		}
	}
	
	public boolean waitForChildWindowToBeVisible(int windownumber)
	{stepdefinition.executionTime+=20;
		try
		{
			new WebDriverWait(Driver.getPgDriver(), 40).until(ExpectedConditions.numberOfWindowsToBe(windownumber));
			blogger.loginfo("Child window is displayed");
			return true;
		}catch(Exception e)
		{
			blogger.loginfo("Child window is not displayed" +e);
			return false;
		}
	}
	
	/**Perform Hover Over Element functionality 
	 * 
	 * @param element
	 * @return
	 */
	public String hoverOverElementAndGetText(WebElement element, WebElement element1) {
		waitforpageload();
		action.moveToElement(element).perform();
		String hovertext = element1.getText();
		return hovertext;
	}
	
	/** Sets warning for data issue's
	 * 
	 * @return
	 */
	public boolean setDataIssue(String args){
		stepdefinition.executionTime+=5;
		stepdefinition.isDataIssue = true;
		try{
			err.logerrormessage("Data Issue: "+args);
			blogger.logserviceDown();
			ExtentManager.setTeststatus("Warning - Data Issue");
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
		catch(NoSuchElementException e){
			return false;
		}

	}

	/** Sets warning for service down
	 * 
	 * @return
	 */
	public boolean setServiceDown(String args){
		stepdefinition.executionTime+=5;
		try{
			err.logerrormessage("Service Down: "+args);
			blogger.logserviceDown();
			ExtentManager.setTeststatus("Warning - Service down, Data not populated in application "+args);
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
		catch(NoSuchElementException e){
			return false;
		}

	}
	
	private String takescreenshot(String methodname,String classname) {

		String loc=null;

		try{
			if(screenshotpath.size()==0) screenshotpath.add("Header");
			
			System.out.println("#TAKESCREENSHOT# : methodname = '" + methodname + "'");
			System.out.println("#TAKESCREENSHOT# : classname = '" + classname + "'");
			
			//int TCloop=MainDriver.loopvar;
			String currentpage, currentaction, screenShotName;
			//String currenttestcase="TC_"+count;
			//String currenttestcase=MainDriver.testcases.get(1),currentpage,currentaction;

			String currenttestcase = name;
			
			System.out.println("#TAKESCREENSHOT# : currenttestcase = '" + currenttestcase + "'");

			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
			currentpage = classname;
			currentaction = methodname;
			
			System.out.println("#TAKESCREENSHOT# : Before Replace : currentpage = '" + currentpage + "'");
			System.out.println("#TAKESCREENSHOT# : Before Replace : currentaction = '" + currentaction + "'");
			
			currentpage = currentpage.replaceAll("\\\\|/|:|\\*|\\?|\"| |<|>|\\|", "_");
			currentaction = currentaction.replaceAll("\\\\|/|:|\\*|\\?|\"| |<|>|\\|", "_");
			
			System.out.println("#TAKESCREENSHOT# : After Replace : currentpage = '" + currentpage + "'");
			System.out.println("#TAKESCREENSHOT# : After Replace : currentaction = '" + currentaction +"'");
			
			screenShotName = "/Screenshots/" + currentpage + "_" + currentaction + "_" + timeStamp + ".png";
			loc = ".." + screenShotName;
			
			// Screen shot taken 
			File scrFile = ((TakesScreenshot)Driver.pgDriver).getScreenshotAs(OutputType.FILE);

			String reportName = System.getProperty("TEST_EXECUTION_REPORT");
			String buildNumber = System.getProperty("TEST_BUILD");
			String reportLocation = System.getProperty("user.dir");
			
			System.out.println("#TAKESCREENSHOT# : reportName = '" + reportName + "'");
			System.out.println("#TAKESCREENSHOT# : buildNumber = '" + buildNumber + "'");
			System.out.println("#TAKESCREENSHOT# : reportLocation = '" + reportLocation + "'");
			System.out.println("#TAKESCREENSHOT# : screenShotName = '" + screenShotName + "'");
			
			
			try{
				if (!reportName.isEmpty() && !buildNumber.isEmpty()) {
					reportLocation = reportLocation + "/TestExecutionRecords/" + buildNumber + "/" + reportName + "_" + buildNumber;
					System.out.println("#TAKESCREENSHOT# : IF : reportLocation + screenShotName = '" + reportLocation + screenShotName + "'");
					FileUtils.copyFile(scrFile, new File(reportLocation + screenShotName)); 
				} else {
					reportLocation = "C://SolutionCentralEngine";
					System.out.println("#TAKESCREENSHOT# : ELSE : reportLocation + screenShotName = '" + reportLocation + screenShotName + "'");
					FileUtils.copyFile(scrFile, new File(reportLocation + screenShotName)); 
				}

			} catch (NullPointerException e) {
				reportLocation = "C://SolutionCentralEngine";
				System.out.println("#TAKESCREENSHOT# : NullPointerException : reportLocation + screenShotName = '" + reportLocation + screenShotName + "'");
				FileUtils.copyFile(scrFile, new File(reportLocation + screenShotName)); 
			}

		} catch (WebDriverException e) {
			System.out.println("Not able to take screen shot due to " + e);
			err.logError(e, methodname);
			ExtentManager.setTeststatus("Warning - Browser Closed unexpectedly");
			throw new PendingException();
		}catch (IOException e) {
			Driver.customServlet.terminatePirateProcess();
			System.out.println("#takescreenshot# Process terminated.");
			System.out.println("Not able to take screen shot due to " + e);
			err.logError(e, methodname);
		}
		
		System.out.println("#TAKESCREENSHOT# : loc = '" + loc + "'");
		
		return loc;
	}

public void logMethodResultAndAttachScreenShot(String methodname,String classname,String loginfo,boolean isSuccess) throws Throwable{
	
	String imagepath;
	ExtentTest logger=ExtentManager.getLogger();
	if(!isSuccess)
	{
		
		
		imagepath=takescreenshot(methodname,classname);
		//logger.log(LogStatus.INFO, methodname, logger.addScreenCapture(imagepath));
		if (imagepath!=null)
			logger.info(loginfo,MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		//throw new CustomException(err.getErrormessage(),reports,logger,mongotest);
		if(!stepdefinition.isServicedown)
			isServiceDown();
		if(!stepdefinition.isServicedown)	
			throw new CustomException(err.getErrormessage(),reports,logger);
		else{

			logger.warning(extentmanager.ExtentManager.getTeststatus());
			throw new PendingException();
		}



	}
	else
	{
		imagepath=takescreenshot(methodname,classname);
		//logger.log(LogStatus.INFO, methodname, logger.addScreenCapture(imagepath));
		//logger.addScreenCapture(imagepath);
		//logger.log(LogStatus.PASS, classname,classname+" step passed on the page "+classname);
		if (imagepath!=null)
			logger.pass(loginfo,MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		//logger.log(LogStatus.PASS, classname,classname+" step passed on the page "+classname);
		else
			logger.pass(loginfo+"passed");
	}	


}
public void gotoLastIframe(List<WebElement> iframes) throws UnhandledAlertException{
	System.out.println("1");
	Driver.getPgDriver().switchTo().defaultContent();
	System.out.println("2");
	int i=iframes.size();
	//System.out.println("Size" +iframe.size());
	//WebElement lastfr=iframes.get(i-1);
	Driver.getPgDriver().switchTo().frame(i-1);
	//Driver.getPgDriver().switchTo().frame(lastfr);
	System.out.println("##########");
	
	// change the driver
	//System.out.println("hello"+this.iframes.get(iframe.size()-1).getAttribute("id"));
}

}










