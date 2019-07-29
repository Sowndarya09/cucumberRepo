package automationLib;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Accumulators extends Driver
{


	@FindBy(xpath= "//*[@node_name='ViewAccumulatorsLatest']/table/tbody//*[@class='dataValueRead']")
	private WebElement Contract_Code;
	@FindBy(xpath= "//select[@id='AccumCoveragePeriod']")
	WebElement Select_Coverage_Period;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Go']")
	WebElement BtnGo;
	@FindBy(xpath="//*[text()=' Expand/Collapse All']")
	WebElement lnktxt_Expand_Collapse;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement BtnSubmit;


	@FindBy(xpath="//div[@node_name='MemberLevelAccumulator']//table[@pl_prop='.FamilyLevelAccumList']")
	WebElement MemberLevelTable;
	@FindBy(xpath=("//*[@node_name='FamilyLevelAccumulator']"))
	WebElement FamilyLevelTable;
	@FindBy(xpath=("//*[@node_name='BenefitLevelAccumulatorOther']"))
	WebElement BenefitLevelTable;


	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderAccums;
	@FindBy(id="CancellationReason")
	WebElement drpdwnCancellationreason;

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Accumulators class defining the Iframe and the Page Factory  
	 */
	public Accumulators() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	DataSet ds=new DataSet();
	public static ArrayList<String>  rowelements=new ArrayList<String>();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	public WebElement getIframeelement() 
	{
		return Iframeelement;
	}
	public WebElement getContract_Code()
	{
		return Contract_Code;
	}
	public WebElement getSelect_Coverage_Period()
	{
		return Select_Coverage_Period;
	}
	public WebElement getBtnGo()
	{
		return BtnGo;
	}
	public WebElement getExpCollapseLink()
	{
		return lnktxt_Expand_Collapse;
	}
	public WebElement getHeader()
	{
		return sHeaderAccums;
	}


	public boolean selectDrpdwnCoveragePeriod(String period[]) throws InterruptedException
	{
		checkforpageload();
		boolean returnvar =true;
		String from_date = null,to_date=null,cvgPrd=null;
		for(String iterator : period)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("View Accumulators", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("from"))
			{			
				returnvar=true;
				from_date=value.toLowerCase().trim();
				continue;			
			}
			else if(key.toLowerCase().contains("to"))
			{
				returnvar=true;
				to_date=value.toLowerCase().trim();
				continue;		
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in your keypair. Make sure you are following the same pattern for input");
				returnvar= false;
				return false;
			}		
		}
		cvgPrd=from_date+" - "+to_date;
		System.out.println("Coverage Period :"+cvgPrd);
		wait=new WebDriverWait(Driver.pgDriver,20);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(this.Select_Coverage_Period));
		}
		catch(Exception e)
		{
			System.out.println("Coverage period drop down not found");
		}
		if(utils.selectDropDownbyVisibleString(this.Select_Coverage_Period, cvgPrd, "View Accumulators", "Coverage Drop Down box"))
		{
			if(this.clickBtnGo())
			{
				checkforpageload();
				System.out.println("Pass : The table fetches the Values and Go button clicked in Accums screen");
				return true;
			}
			else
			{
				err.logError("Fail:issue in Go button click");
				return false;
			}
		}
		else
		{
			err.logError("Fail:issue in Coverage drop down");
			return false;
		}
	}
	public boolean clickBtnGo()
	{
		return utils.clickAnelemnt(this.getBtnGo(), "View Accumulators", "Button to click Go");

	}
	public boolean clickButtonSubmit() throws InterruptedException
	{
		Thread.sleep(5000);
		((JavascriptExecutor) Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",
				this.BtnSubmit);
		return utils.clickAnelemnt(this.BtnSubmit, "View Accumulators", "Button to click Submit");
	}
	
	@FindBy(xpath="//img[contains(@alt,'Loading..')]")
	private WebElement LoadingIcon;
	private WebElement chckbox1;
	private WebElement chckbox;
	
	public boolean checkforpageload()
	{
		int count=0;
		try
		{
			if(this.LoadingIcon.isDisplayed())
			{
				count++;
				wait=new WebDriverWait(Driver.pgDriver,20);
				try{
					wait.until(ExpectedConditions.visibilityOf(this.BtnGo));
				}
				catch(Exception e)
				{
					System.out.println("page Loading..");
				}

				return true;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			if(count>0)
			{
				System.out.println("Applcation took a long time to load");
				return false;
			}
			else
				return true;
		}

	}


	public boolean validateArrayvalues(ArrayList<String> actualval,ArrayList<String> expectval)
	{
		if(expectval.equals(actualval))
		{
			System.out.println("Pass:actual and expected values are  matching");
			return true;
		}
		else
		{
			System.out.println("Fail:actual and expected values are not matching");
			return false;
		}

	}
	public String removeCommas(String textwithcomma)
	{
		String amountwithoutcomma;
		if(textwithcomma.contains(","))
			amountwithoutcomma=textwithcomma.replace(",","");
		else
			amountwithoutcomma=textwithcomma;	
		return amountwithoutcomma;
	}
	public String removeDollar(String textwithdollar)
	{
		String amountwithoutdollar;
		if(textwithdollar.contains("$"))
			amountwithoutdollar=textwithdollar.replace("$","");
		else
			amountwithoutdollar=textwithdollar;

		return amountwithoutdollar;
	}

	public boolean validateAccumsInfoFamilyLevel(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		ArrayList<String> actual=new ArrayList<String>();
		ArrayList<String> actualReview=new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("View Accumulators", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);		
			if(key.toLowerCase().contains("level"))
			{			
				returnvar=true;
				level=value.toLowerCase().trim();				
				continue;			
			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				expected.add(NW);
				continue;		
			}
			else if(key.toLowerCase().contains("desc"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				expected.add(desc);
				continue;			
			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				expected.add(limit);
				continue;			
			}
			else if(key.toLowerCase().contains("accum"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				expected.add(accums);
				continue;				
			}
			else if(key.toLowerCase().contains("remain"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				expected.add(remain);
				continue;			
			}
			else if(key.toLowerCase().contains("start"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				expected.add(startdt);
				continue;			
			}
			else if(key.toLowerCase().contains("end"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				expected.add(enddt);
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");

				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}


		try{
			wait=new WebDriverWait(Driver.pgDriver,20);
			wait.until(ExpectedConditions.visibilityOf(this.FamilyLevelTable));
		}
		catch(Exception e)
		{
			System.out.println("Family level table not found");
		}			
		List<WebElement> allRows = FamilyLevelTable.findElements(By.xpath("//div[@node_name='FamilyLevelAccumulator']//*[contains(@id,'$PpyWorkPage$pFamilyLevelAccumList$')]"));
		System.out.println(allRows.size());
		Boolean returnvar1=true;
		for(int k=2;k<=allRows.size()+1;k++)
		{
			wait=new WebDriverWait(Driver.pgDriver,25);
			WebElement ele=Driver.pgDriver.findElement(By.xpath("(//div[@node_name='FamilyLevelAccumulator']//tr["+k+"][contains(@id,'$PpyWorkPage$pFamilyLevelAccumList$')]//*[@class='work_identifier'])[position()=2]"));
			String expdesc=ele.getText().toLowerCase().trim();
			if(expdesc.contains(desc))  
			{
				for(int j=1;j<=5;j++)
				{
					wait=new WebDriverWait(Driver.pgDriver,20);
					String val1=Driver.pgDriver.findElement(By.xpath("(//*[@node_name='FamilyLevelAccumulator']//tr["+k+"][contains(@id,'$PpyWorkPage$pFamilyLevelAccumList$')]//*[@class='work_identifier'])[position()="+j+"]")).getText().toLowerCase().trim();
					actualReview.add(val1);
					val1=this.removeCommas(val1);
					val1=this.removeDollar(val1);
					actual.add(val1);          	 
				}
				System.out.println("actual arraylist"+actual);
				System.out.println("expected arraylist"+expected);
				System.out.println("Row number "+(k-1)+" matching with description");
				if(this.validateArrayvalues(actual,expected))
				{
					wait=new WebDriverWait(Driver.pgDriver,20);
					chckbox1=Driver.pgDriver.findElement(By.xpath("(//div[@node_name='FamilyLevelAccumulator']//tr["+k+"]//*[@type='checkbox'])"));
					utils.clickAnelemnt(this.chckbox1, "Accumulators", "Accumulator Family Level verify checkbox");
					rowelements=actualReview;
					returnvar1= true;
				}
				else
				{
					System.out.println("Entire row not matching for given input in Family Level");
					returnvar1=false;
					return false;
				}
				break;
			}

		}
		if(!returnvar1)
		{
			System.out.println("Matching rows not found for given input");	
			return false;
		}
		return true;
	}
	public boolean validateAccumsInfoMemberLevel(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		ArrayList<String> actual=new ArrayList<String>();
		ArrayList<String> actualReview=new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("View Accumulators", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("level"))
			{			
				returnvar=true;
				level=value.toLowerCase().trim();		
				continue;				
			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				expected.add(NW);
				continue;			
			}
			else if(key.toLowerCase().contains("desc"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				expected.add(desc);
				continue;			
			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				expected.add(limit);
				continue;			
			}
			else if(key.toLowerCase().contains("accum"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				expected.add(accums);
				continue;			
			}
			else if(key.toLowerCase().contains("remain"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				expected.add(remain);
				continue;			
			}
			else if(key.toLowerCase().contains("start"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				expected.add(startdt);
				continue;			
			}
			else if(key.toLowerCase().contains("end"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				expected.add(enddt);
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");

				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}


		try{
			wait=new WebDriverWait(Driver.pgDriver,20);
			wait.until(ExpectedConditions.visibilityOf(this.MemberLevelTable));
		}
		catch(Exception e)
		{
			System.out.println("Member level table not found");
		}

		List<WebElement> allRows = FamilyLevelTable.findElements(By.xpath("//div[@node_name='MemberLevelAccumulator']//*[contains(@id,'$PpyWorkPage$pFamilyLevelAccumList$')]"));
		System.out.println(allRows.size());
		Boolean returnvar1=true;
		for(int k=2;k<=allRows.size()+1;k++)
		{
			wait=new WebDriverWait(Driver.pgDriver,25);
			WebElement ele=Driver.pgDriver.findElement(By.xpath("(//div[@node_name='MemberLevelAccumulator']//tr["+k+"][contains(@id,'$PpyWorkPage$pFamilyLevelAccumList$')]//*[@class='work_identifier'])[position()=2]"));
			String expdesc=ele.getText().toLowerCase().trim();
			if(expdesc.contains(desc))  
			{
				for(int j=1;j<=5;j++)
				{
					wait=new WebDriverWait(Driver.pgDriver,20);
					String val1=Driver.pgDriver.findElement(By.xpath("(//*[@node_name='MemberLevelAccumulator']//tr["+k+"][contains(@id,'$PpyWorkPage$pFamilyLevelAccumList$')]//*[@class='work_identifier'])[position()="+j+"]")).getText().toLowerCase().trim();
					actualReview.add(val1);
					val1=this.removeCommas(val1);
					val1=this.removeDollar(val1);
					actual.add(val1);

				}
				System.out.println("actual arraylist"+actual);
				System.out.println("expected arraylist"+expected);
				System.out.println("Row number "+(k-1)+" matching with description");
				if(this.validateArrayvalues(actual,expected))
				{
					wait=new WebDriverWait(Driver.pgDriver,20);
					chckbox1=Driver.pgDriver.findElement(By.xpath("(//div[@node_name='MemberLevelAccumulator']//tr["+k+"]//*[@type='checkbox'])"));
					utils.clickAnelemnt(this.chckbox1, "Accumulators", "Accumulator Member Level verify checkbox");
					rowelements=actualReview;
					returnvar1= true;
				}
				else
				{
					System.out.println("Entire row not matching for given input in Member Level");
					returnvar1=false;
					return false;
				}
				break;
			}			 
		}
		if(!returnvar1)
		{
			System.out.println("Matching rows not found for given input");	
			return false;
		}	
		return true;
	}

	public boolean 	CollapseAll()
	{	
		utils.clickAnelemnt(this.lnktxt_Expand_Collapse, "Accumulators", "Expand and collapse Link");
		String col=this.lnktxt_Expand_Collapse.getAttribute("isexpanded").toLowerCase();
		if(col.contains("false"))
		{
			System.out.println("Results are displaying Collapse mode");
			return true;
		}
		else if(col.contains("true"))
		{
			System.out.println("Results are displaying Expanded mode");
			return false;
		}
		return true;
	}
	@FindBy(xpath="//*[contains(@id,'IsMemberAccum')]")
	private WebElement checkboxes;
	public boolean UnTagallAccums()
	{
		wait=new WebDriverWait(Driver.pgDriver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'IsMemberAccum')]")));
		List<WebElement> untag= null;	
		try {
			untag=this.checkboxes.findElements(By.xpath("//*[contains(@id,'IsMemberAccum')][@pn='.IsMemberAccumReviewed']"));		 		
		} catch (Exception e1) {
			untag=this.checkboxes.findElements(By.xpath("//*[contains(@id,'IsMemberAccum')][@pn='.IsMemberAccumReviewed']"));
		}
		if(untag.isEmpty())
		{
			System.out.println("None of the Elements were previously tagged in Accumulators screen");
			return false;

		}
		else
		{	
			for(WebElement e: untag)
			{
				action.moveToElement(e).click().build().perform();	
				return true;
			}
		}
		return false;
	}
	public boolean tagAllAccumsFamilyLevel() throws IOException
	{

		Boolean returnvar1=true;
		List<WebElement> count=null;
		try{
			wait=new WebDriverWait(Driver.pgDriver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='FamilyLevelAccumulator']")));  		  
		}
		catch(Exception e)
		{
			System.out.println("checkbox element not found in Family level table");
			returnvar1=false;
		}
		count=Driver.pgDriver.findElements(By.xpath("//*[@node_name='FamilyLevelAccumulator']//*[contains(@id,'IsMemberAccum')]"));   		
		if(!(count.isEmpty()))
		{
			for (int i=2;i<count.size()+2;i++)
			{
				String xpath5="//*[@node_name='FamilyLevelAccumulator']//tr["+i+"]//*[contains(@id,'IsMemberAccum')]";
				Driver.pgDriver.findElement(By.xpath(xpath5)).click();
				for(int j=1;j<=5;j++)
				{
					String xpath1="(//div[@node_name='FamilyLevelAccumulator']//tr["+i+"]//*[@class='work_identifier'])[position()="+j+"]";
					WebElement ele=Driver.pgDriver.findElement(By.xpath(xpath1));
					String toStore=ele.getText().toLowerCase().trim();
					rowelements.add(toStore);
					returnvar1=true;
				}		
			}
		}
		else
		{
			returnvar1=false;
		}

		if(!returnvar1)		
		{
			err.logError("Family level Accumulators Table doesnot contain any value");
			return false;
		}
		return true;
	}
	public boolean tagAllAccumsMemberLevel() throws IOException
	{	
		Boolean returnvar1=true;	
		List<WebElement> count=null;	
		try{
			wait=new WebDriverWait(Driver.pgDriver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='MemberLevelAccumulator']")));	 
		}
		catch(Exception e)
		{
			System.out.println("checkbox element not found in Member level table");
			returnvar1=false;
		}
		count=Driver.pgDriver.findElements(By.xpath("//*[@node_name='MemberLevelAccumulator']//*[contains(@id,'IsMemberAccum')]"));
		if(!(count.isEmpty()))
		{
			for (int i=2;i<count.size()+2;i++)
			{
				String xpath5="//*[@node_name='MemberLevelAccumulator']//tr["+i+"]//*[contains(@id,'IsMemberAccum')]";
				Driver.pgDriver.findElement(By.xpath(xpath5)).click();
				for(int j=1;j<=5;j++)
				{
					String xpath1="(//div[@node_name='MemberLevelAccumulator']//tr["+i+"]//*[@class='work_identifier'])[position()="+j+"]";
					WebElement ele=Driver.pgDriver.findElement(By.xpath(xpath1));
					String toStore=ele.getText().toLowerCase().trim();
					rowelements.add(toStore);
					returnvar1=true;
				}			
			}
		}
		else
		{
			returnvar1=false;
		}	
		if(!returnvar1)			
		{
			err.logError("Member Level Accumulators Table doesnot contain any value ");
			return false;
		}
		return true;
	}
	public boolean tagAllAccumsBenefitLevel() throws IOException
	{	
		Boolean returnvar1=true;
		List<WebElement> count=null,count1=null;
		try{
			wait=new WebDriverWait(Driver.pgDriver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='BenefitLevelAccumulatorOther']//*[contains(@id,'IsMemberAccum')]")));

		}
		catch(Exception e)
		{
			System.out.println("checkbox element not found in Benefit level table");
			returnvar1=false;
		}
		count=Driver.pgDriver.findElements(By.xpath("//*[@node_name='BenefitLevelAccumulatorOther']//*[contains(@id,'IsMemberAccum')]"));
		count1=Driver.pgDriver.findElements(By.xpath("//div[@node_name='BenefitLevelAccumulatorOther']//*[@class='gridTable ']//td"));	

		if(!(count.isEmpty()))
		{
			for (int i=2;i<count.size()+2;i++)
			{
				String xpath5="//*[@node_name='BenefitLevelAccumulatorOther']//tr["+i+"]//*[contains(@id,'IsMemberAccum')]";
				Driver.pgDriver.findElement(By.xpath(xpath5)).click();									
			}
			for(int i=2;i<=9;i++)
			{
				for(int j=1;j<=count.size();j++)
				{
					String xp="(//div[@node_name='BenefitLevelAccumulatorOther']//*[@class='gridTable ']//td["+i+"])[position()="+j+"]";
					WebElement q= Driver.pgDriver.findElement(By.xpath(xp));
					String toStore=q.getText().toLowerCase().trim();
					rowelements.add(toStore);
				}
			}		 
		}
		else
		{
			returnvar1=false;
		}	
		if(!returnvar1)			
		{		
			err.logError("Benefit Level Accumulators Table doesnot contain any value ");
			return false;
		}
		return true;
	}    

	public boolean CancelAccumulators(String[] cancelreason)
	{
		boolean returnvar=true;
		String reason=null;
		for(String iterator : cancelreason)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("View Accumulators", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;	
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);		
			if(key.toLowerCase().contains("reason"))
			{			
				returnvar=true;
				reason=value.toLowerCase().trim();
				if(reason.contains("error"))
					reason="Created in Error";
				else if(reason.contains("request"))
					reason="Contact Withdrew Request";
				else if(reason.contains("duplicate"))
					reason="Duplicate";
				else if(reason.contains("end"))
					reason="interaction Ended";
				else
				{
					err.logcommonMethodError("Cancel Accumulators", "Check your Reason for Cancellation");
				}
				continue;				
			}		
			else
			{
				err.logcommonMethodError("Cancel Accumulators", "Check your key in your keypair. Make sure you are following the same pattern for input");
				return false;
			}		
		}
		if(utils.clickAnelemnt(this.btnOtherActions, "Accumulators", "Other Actions Button"))
		{
			if(utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Accumulators", "Cancel this Work"))
			{
				if(utils.validateHeader(this.getHeader(),"Cancel this work"))
				{
					if(utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, reason, "Cancel Accumulators", "Cancel reason"))
					{
						if(utils.clickAnelemnt(this.BtnSubmit, "Cancel Accumulators", "Submit button on cancel Accumulators"));
						return true;
					}
					else
						return false;
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	public boolean validateCoverageDateFormat()
	{
		boolean returnvar=true;			
		returnvar=true;			
		String va=this.Select_Coverage_Period.getText().toLowerCase().trim();
		if(va.contains("-"))
		{
			String[] output=va.split("-");		
			String ch1=output[0];
			if(!ch1.isEmpty())
			{
				Pattern p=Pattern.compile("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)");
				Matcher m=p.matcher(ch1.trim());
				if(m.matches())
				{

					returnvar=true;
				}
				else
					returnvar=false;

			}
			else
			{
				System.out.println("Input is empty");
			}
			String ch2=output[1];
			if(!ch2.isEmpty())
			{
				Pattern p=Pattern.compile("(\t)(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)");
				Matcher m=p.matcher(ch2.trim());
				if(m.matches())
				{

					returnvar=true;
				}
				else

					returnvar=false;
			}
			else
			{
				System.out.println("Input is empty");
			}

		}
		else
		{
			System.out.println("Format is not matching with MM/dd/yyyy - MM/dd/yyyy");
		}
		if(!returnvar)
			err.logError("Format is not matching with MM/dd/yyyy - MM/dd/yyyy");



		return true;
	}



	@FindBy(xpath="(//input[contains(@id,'IsMemberAccumReviewed')])[1]")
	WebElement chkBoxFirstInMemberLevelAccumsDiscussed;

	@FindBy(xpath="(//input[contains(@id,'IsAccumAdjustmentRequested')])[1]")
	WebElement chkBoxFirstInMemberLeveReviewRequested;

	public boolean clickFirstCheckBoxInMemberLevel() 
	{
		if(utils.clickAnelemnt(chkBoxFirstInMemberLevelAccumsDiscussed, "Accumulator", "Member Level Check Box"))
			if(utils.clickAnelemnt(chkBoxFirstInMemberLeveReviewRequested, "Accumulator", "Member Level Check Box"))
				return true;
		return false;
	}

	@FindBy(xpath="//table[@pl_prop='.FamilyLevelAccumList']")
	List<WebElement> MemLevelTable;
	@FindBy(xpath=("//*[@node_name='FamilyLevelAccumulator'] //table[@class='gridTable ']"))
	WebElement FamLevelTable;
	@FindBy(xpath=("//*[@node_name='BenefitLevelAccumulatorOther'] //table[@class='gridTable ']"))
	WebElement BenftLevelTable;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoMemberLevel
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Member Level section.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumulatorInfoMemberLevel(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;                
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("level"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;                              
			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("accumulator description"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;           
			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;                     
			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;                
			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;                
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		try{
			selectAccumulatorInMemberLevelTable(this.MemLevelTable.get(0),args);
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;

	}

	@FindBy(xpath="//span[text()='Family Level']")
	WebElement familyLevelLbl;
	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoFamilyLevel
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Family Level section.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumulatorInfoFamilyLevel(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoFamilyLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;              
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("level"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;                              
			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("accumulator description"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}

		try{
			selectAccumulatorInFamilyLevelTable(this.MemLevelTable.get(1),args);
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;

	}


	public boolean selectAccumulatorInMemberLevelTable(WebElement table,String[] tablevalues) throws InterruptedException{    
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
			returncolumn = utils.getcolumnStringFromTableByName(table,keys[0]);
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
					else{
						index=-1;
						break;
					}
				}
			}

		}
		List<WebElement> allRows = table.findElements(By.xpath(".//tr[contains(@class,'cellCont')]"));
		if(index!=-1){
			if(allRows.size()>0)
				allRows.get(index).findElement(By.xpath(".//input[contains(@id,'IsMemberAccumReviewed')]")).click();
			allRows.get(index).findElement(By.xpath(".//input[contains(@id,'IsAccumAdjustmentRequested')]")).click();
		}
		else return false;   
		System.out.println("The row with the matching arguements" + index);  
		Thread.sleep(1000);
		return true;  
	}

	public boolean selectAccumulatorInFamilyLevelTable(WebElement table,String[] tablevalues) throws InterruptedException{    
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
			returncolumn = utils.getcolumnStringFromTableByName(table,keys[0]);
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
					else{
						index=-1;
						break;
					}
				}
			}

		}
		List<WebElement> allRows = table.findElements(By.xpath(".//tr[contains(@class,'cellCont')]"));
		if(index!=-1){
			if(allRows.size()>0)
				allRows.get(index).findElement(By.xpath(".//input[contains(@id,'IsMemberAccumReviewed')]")).click();
			allRows.get(index).findElement(By.xpath(".//input[contains(@id,'IsAccumAdjustmentRequested')]")).click();
		}
		else return false;   
		System.out.println("The row with the matching arguements" + index);  
		Thread.sleep(1000);
		return true;  
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoBenefitLevel
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Benefit Level section.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumulatorInfoBenefitLevel(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("level"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;

			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("accumulator description"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		//

		try{

			WebElement row =utils.getAccumulatortablerowbasedonvalues(this.BenftLevelTable,args);
			System.out.println("Test"+row.findElement(By.xpath("//input[contains(@id,'IsMemberAccumReviewed')]")).getAttribute("id"));
			System.out.println("Test"+row.findElement(By.xpath(".//input[contains(@id,'IsAccumAdjustmentRequested')]")).getAttribute("id"));
			row.findElement(By.xpath(".//input[contains(@id,'IsMemberAccumReviewed')]")).click();
			row.findElement(By.xpath(".//input[contains(@id,'IsAccumAdjustmentRequested')]")).click();
			System.out.println(row.getAttribute("pl_index"));
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;

	}

	@FindBy(xpath="//label[contains(text(),'Accumulators Overview')]")
	WebElement tabAccumsOverview;

	@FindBy(xpath="//table[@pl_prop='D_AccumulatorsViewDetails.pxResults']")
	WebElement tblAccumsOverview;

	@FindBy(id="AccumOrder")
	WebElement drpDownSortOption;

	@FindBy(xpath="//span[@data-test-id='20170706115607066655658']")
	WebElement labelProd;

	@FindBy(xpath="//span[@data-test-id='20170706120318092347707']")
	WebElement labelPlan;

	@FindBy(xpath="//button[@data-test-id='201709211625130878429269']//div[contains(text(),'Export to PDF')]")
	WebElement btnExportToPDF;

	@FindBy(xpath="//button[@data-test-id='201709211625130878430424']//div[contains(text(),'Export to Excel')]")
	WebElement btnExportToExcel;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAccumulatorsOverViewTab
	 * #Description: This functionality performs click action on the Accumulator Overview tab in the Accums page
	 * Type: Textbox
	 */
	public boolean clickAccumulatorsOverViewTab() throws InterruptedException
	{
		return utils.clickAnelemnt(this.tabAccumsOverview, "Accumulators", "Accums Overview");	
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorOverviewTableAndClickCheckbox
	 * #Description: This functionality validates the Accumulator Overview table values with actual and expected values in the table and perform click action in the matched row checkbox
	 * Type: Table
	 * Keys: Name#Description#From Thru#Occurs#Days#Amount
	 */
	public boolean validateAccumulatorOverviewTableAndClickCheckbox(String[] tablevalues)
	{
		try
		{
			WebElement row = utils.getProviderResultsBasedOnValues(this.tblAccumsOverview, tablevalues);
			List<WebElement> rowno = row.findElements(By.tagName("input"));
			rowno.get(1).click();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("Accumulators", "validateAccumsOverviewTableAndClickCheckbox", "Error in Validating the Overview table");
			return false;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyAccumulatorsOverviewTabIsDisplayed
	 * #Description: This functionality verifies that the Accumulators OverView tab is displayed in the Accums page
	 * Type: Textbox
	 */
	public boolean verifyAccumulatorsOverviewTabIsDisplayed()
	{
		WebElement element = Driver.pgDriver.findElement(By.xpath("//label[contains(text(),'Accumulators Overview')]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		try
		{
			if(this.tabAccumsOverview.isDisplayed())
			{
				blogger.loginfo("Accumulators Overview tab is Displayed in the Accumulators page");
				System.out.println("Accumulators Overview tab is Displayed in the Accumulators page");
				return true;
			}
			else
			{
				blogger.loginfo("Accumulators Overview tab is not Displayed in the Accumulators page");
				System.out.println("Accumulators Overview tab is not Displayed in the Accumulators page");
				return false;
			}
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("ManageReferralReview", "verifyAccumulatorOverviewTabIsDisplayed", "Accumulator Overview tab is not displayed");
			return false;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyAccumulatorsOverviewTabIsNotDisplayed
	 * #Description: This functionality verifies that the Accumulators OverView tab is not displayed in the Accums page
	 * Type: Textbox
	 */
	public boolean verifyAccumulatorsOverviewTabIsNotDisplayed()
	{
		return utils.isProxyWebelement(tabAccumsOverview);

	}

	/*
	 * @SCU
	 * #CommonMethodWithtArgument: selectSortByOption
	 * #Description: This functionality selects the option given by the user in the Sort by section
	 * Type: Dropdown
	 * Keys: Claim Number#Processed Date
	 */
	public boolean selectSortByOption(String[] option)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownSortOption, option[0], "Accumulators", "Error in Sort By Option");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateProdLabel
	 * #Description: This functionality validates the label present in the Prod section in the Accumulators Overview tab section
	 * #Argument: prodlabel
	 * Type: Textbox
	 */
	public boolean validateProdLabel(String[] prodlabel)	
	{
		return utils.validateLabel(this.labelProd, prodlabel[0]);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validatePlanLabel
	 * #Description: This functionality validates the label present in the Plan section in the Accumulators Overview tab section
	 * #Argument: planlabel
	 * Type: Textbox
	 */
	public boolean validatePlanLabel(String[] planlabel)	
	{
		return utils.validateLabel(this.labelPlan, planlabel[0]);

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickExportToPdfButton
	 * #Description: This functionality clicks the Export to PDF button in the Accumulators page
	 * Type: Textbox
	 */
	public boolean clickExportToPdfButton()
	{
		return utils.clickAnelemnt(this.btnExportToPDF, "Accumulators", "Export To PDF button");

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickExportToExcelButton
	 * #Description: This functionality clicks the Export to Excel button in the Accumulators page
	 * Type: Textbox
	 */
	public boolean clickExportToExcelButton()
	{
		return utils.clickAnelemnt(this.btnExportToExcel, "Accumulators", "Export To Excel button");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoMemberLevel
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Member Level section and expands the pane.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumulatorInfoMemberLevelAndExpandPane(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("level"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;	                              
			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("accumulator description"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		try{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@node_name='MemberLevelAccumulator'] //table[@class='gridTable ']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row=   utils.getAccumulatortablerowbasedonvalues(this.MemLevelTable.get(0),args);
			List<WebElement> rowno = row.findElements(By.tagName("input"));
			rowno.get(1).click();
			rowno.get(3).click();
			return true;
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;

	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoFamilyLevelAndExpandPane
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Family Level section and expands the pane.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumulatorInfoFamilyLevelAndExpandPane(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;		                 
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("level"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;		                              
			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;			                       
			}
			else if(key.toLowerCase().contains("accumulator description"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		try{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@node_name='MemberLevelAccumulator'] //table[@class='gridTable ']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			utils.clickontablerowbasedonvalues(this.MemLevelTable.get(0),args);
			return true;
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{
			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoBenefitLevelAndExpandPane
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Benefit Level section and expands the pane.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumulatorInfoBenefitLevelAndExpandPane(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("primary benefit"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;		                              
			}
			else if(key.toLowerCase().contains("all benefit(s) included"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("accumulator limitation(s)"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;			                       
			}

			else if(key.toLowerCase().contains("type"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;		                       
			}

			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;			                       
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		try{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[@node_name='BenefitLevelAccumulatorOther']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.getAccumulatortablerowbasedonvalues(this.BenefitLevelTable,args);
			List<WebElement> rowno = row.findElements(By.tagName("td"));
			rowno.get(4).click();
			return true;
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}			                 
		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;
	}

	@FindBy(xpath="//table[@pl_prop='.AccuClaimsList']")
	WebElement tblClaimInfoMemLevel;

	public boolean validateClaimInfoMemberLevel(String[] claiminfo)
	{
		try
		{
			return utils.validatetablerowbasedonvalues(tblClaimInfoMemLevel, claiminfo);
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("Accumulators", "validateClaimInfoMemberLevel", "Error in validating claim info table");
			return false;
		}
	}

	public boolean verifyValuePresentInTheCoveragePeriod(String[] arg){
		return utils.selectDropDownbyVisibleString(this.Select_Coverage_Period, arg[0], "View Accumulators", "Coverage Drop Down box");

	}



	//Sprint 3.4

	@FindBy(xpath="//span[contains(text(),'Miscellaneous Accumulators')]")
	WebElement lnkMiscellanousAccumulators;

	@FindBy(xpath="//span[text()='Accumulators in this section are Accumulators that are not associated to the Member, Family, or Benefit but are part of the Contract.']")
	WebElement labelInstructionalText;

	@FindBy(xpath="//table[@pl_prop='.MiscellaneousAccumList']")
	WebElement tblMiscellanousAccums;

	@FindBy(xpath="(//table[@pl_prop='.MiscellaneousAccumList']//img[@data-test-id='20160127122348051611158'])[1]")
	WebElement imgAccumsDiscussedInMiscellanousAccums;

	@FindBy(xpath="(//table[@pl_prop='.MiscellaneousAccumList']//img[@data-test-id='20160127122348051611158'])[2]")
	WebElement imgReviewRequestedInMiscellanousAccums;

	public boolean verifyAccumulatorsDiscussedIndicatorIsDisplayedOnTheGridInMiscellanous()
	{
		return !utils.isProxyWebelement(imgAccumsDiscussedInMiscellanousAccums);
	}

	public boolean verifyAccumulatorsReviewedIndicatorIsDisplayedOnTheGridInMiscellanous()
	{
		return !utils.isProxyWebelement(imgReviewRequestedInMiscellanousAccums);
	}



	public boolean verifyMiscellaneousAccumulatorsSectionIsDisplayed()
	{
		return !utils.isProxyWebelement(lnkMiscellanousAccumulators);
	}


	public boolean clickMiscellaneousAccumulators()
	{
		return utils.clickAnelemnt(lnkMiscellanousAccumulators, "Accumulators", "Miscellaneous Accumulators is clicked");
	}


	public boolean validateTheInstructionalTextUnderMiscellaneousAccumulator()
	{
		return utils.validateLabel(labelInstructionalText, "Accumulators in this section are Accumulators that are not associated to the Member, Family, or Benefit but are part of the Contract.");				
	}

	@FindBy(xpath="(//a[@data-test-id='201602250612150737235685'])[1]")
	WebElement lnkClickExpandCollapseAll;

	public boolean clickExpandCollapseAll()
	{
		return utils.clickAnelemnt(lnkClickExpandCollapseAll, "Accumulators", "Expand/Collapse link");
	}


	public boolean validateMiscellanousAccumulator(String[] tablevalues) throws InterruptedException
	{
		try
		{
			WebElement element = tblMiscellanousAccums;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.returntablerowbasedonvalues(tblMiscellanousAccums, tablevalues);
			List<WebElement> rowValues = row.findElements(By.tagName("input"));
			rowValues.get(1).click();
			rowValues.get(3).click();
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception :"+e);
			err.logcustomerrorwithmessage("Accumulators", "validateMiscellanousAccumulator", "Error in validating Miscellanous Accumulator");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoMemberLevel
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Member Level section and expands the pane.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumsInfoMemberLevelAndExpandPane(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;               
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("level"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;                              
			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("accumulator description"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		try{
			Thread.sleep(3000);
			WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@node_name='MemberLevelAccumulator']//table[@pl_prop='.FamilyLevelAccumList']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row=   utils.getAccumulatortablerowbasedonvalues(this.MemberLevelTable,args);
			List<WebElement> rowno = row.findElements(By.xpath("//td[contains(@class,'expandPane')]"));
			rowno.get(0).click();
			return true;
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;

	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoFamilyLevelAndExpandPane
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Family Level section and expands the pane.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumsInfoFamilyLevelAndExpandPane(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;               
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("level"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;                            
			}
			else if(key.toLowerCase().contains("network"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("accumulator description"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;                      
			}
			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;                   
			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		try{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@node_name='MemberLevelAccumulator'] //table[@class='gridTable ']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.clickontablerowbasedonvalues(this.MemLevelTable.get(0),args);
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;

	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateAccumulatorInfoBenefitLevelAndExpandPane
	 * #Description: This functionality validates the values given by the user and the values in the application for the Accumulator Benefit Level section and expands the pane.
	 * #Argument: args
	 * keys:
	 */
	public boolean validateAccumsInfoBenefitLevelAndExpandPane(String[] args)
	{
		boolean returnvar =true;
		String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("primary benefit"))
			{                    
				returnvar=true;
				level=value.toLowerCase().trim();                      
				continue;	                              
			}
			else if(key.toLowerCase().contains("all benefit(s) included"))
			{
				returnvar=true;
				NW=value.toLowerCase().trim();
				continue;                       
			}
			else if(key.toLowerCase().contains("accumulator limitation(s)"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;                       
			}

			else if(key.toLowerCase().contains("type"))
			{
				returnvar=true;
				desc=value.toLowerCase().trim();
				continue;	                       
			}

			else if(key.toLowerCase().contains("limit"))
			{
				returnvar=true;
				limit=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("accumulated"))
			{
				returnvar=true;
				accums=value.toLowerCase().trim();
				continue;	                       
			}
			else if(key.toLowerCase().contains("remaining"))
			{
				returnvar=true;
				remain=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("start date"))
			{
				returnvar=true;
				startdt=value.toLowerCase().trim();
				continue;		                       
			}
			else if(key.toLowerCase().contains("end date"))
			{
				returnvar=true;
				enddt=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}
		try{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[@node_name='BenefitLevelAccumulatorOther']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.getAccumulatortablerowbasedonvalues(this.BenefitLevelTable,args);
			List<WebElement> rowno = row.findElements(By.tagName("td"));
			rowno.get(4).click();
			return true;
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;

	}

	String parentWindow;

	public boolean validateClaimInfoMemberLevelAndClickOnClaimNumber(String[] claiminfo)
	{
		utils.waitforpageload();
		parentWindow = Driver.pgDriver.getWindowHandle();
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblClaimInfoMemLevel, claiminfo);
			List<WebElement> rowValue = row.findElements(By.tagName("a"));
			rowValue.get(0).click();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("Accumulators", "validateClaimInfoMemberLevelAndClickOnClaimNumber", "Error in validating claim info table");
			return false;
		}
	}

	@FindBy(xpath="//div[@node_name='ShowRestrictedMessage']//p[5]")
	WebElement labelAccessMsg;


	public boolean validateErrorMsgOnClickingRestrictedClaimNumber(String[] args)
	{
		utils.waitforpageload();
		Set<String> childWindow = Driver.pgDriver.getWindowHandles();
		System.out.println("No.ofwindows"+childWindow.size());
		Iterator<String> iterator= childWindow.iterator();
		String parentWindow = iterator.next();
		String childWindow1 = iterator.next();
		Driver.pgDriver.switchTo().window(childWindow1);
		String title = Driver.pgDriver.getTitle();
		System.out.println("Title of the Child Window is: "+title);
		if(title.contains("View Claim Details"))
		{
			System.out.println("View Claim Details launched and the title is: "+ title); 
			String actualMsg = args[0];
			String expectedMsg = labelAccessMsg.getText();
			if(actualMsg.contains(expectedMsg))
			{
				blogger.loginfo("Actual message and expected message for access restriction message is matched");
				System.out.println("Actual message and expected message for access restriction message is matched");
				return true;
			}
			else
			{
				blogger.loginfo("Actual message and expected message for access restriction message is not matched");
				System.out.println("Actual message and expected message for access restriction message is not matched");
				return false;
			}
		}else
		{
			err.logcommonMethodError("GrievanceAndAppeals", "Error in switching to childwindow-TriMed");
			return false;
		}
	}
	@FindBy(xpath="//h3[text()='Claim Details']")
	WebElement labelValidationMsg;


	public boolean validateOnClickingClaimNumberNavigatesToClaimsDetailsWindow(String[] args) throws InterruptedException
	{   
		
		String parentWindow=Driver.pgDriver.getWindowHandle();
	    System.out.println(parentWindow);
		utils.waitforpageload();
		WebElement Clno=Driver.pgDriver.findElement(By.xpath("//a[text()='"+args[0]+"']"));
		utils.clickAnelemnt(Clno,"Accumulators", "Link");
		utils.waitForChildWindowToBeVisible(0);
		Set<String> childWindow = Driver.pgDriver.getWindowHandles();
		System.out.println("No.ofwindows"+childWindow.size());
		Iterator<String> iterator= childWindow.iterator();
		String parentWindow1 = iterator.next();
		String childWindow1 = iterator.next();
		Driver.pgDriver.switchTo().window(childWindow1);
		String title = Driver.pgDriver.getTitle();
		System.out.println("Title of the Child Window is: "+title);
		if(title.contains("View Claim Details"))
		{
			System.out.println("View Claim Details launched and the title is: "+ title); 
			action.moveToElement(labelValidationMsg).perform();
			String actualMsg = labelValidationMsg.getText();
			String expectedMsg = "Claim Details";
			if(actualMsg.contains(expectedMsg))
			{
				blogger.loginfo("Validation was successful");
				System.out.println("Validation was successful");
				return true;
			}
			else
			{
				blogger.loginfo("Validation was unsuccessful");
				System.out.println("Validation was unsuccessful");
				return false;
			}
		}else
		{
			err.logcommonMethodError("GrievanceAndAppeals", "Error in switching to childwindow-TriMed");
			return false;
		}
		
	}

}






