package automationLib;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProviderAccumulator extends Driver
{
	//USING PAGE FACTORY --

	@FindBy(xpath= "//*[@node_name='ViewAccumulatorsLatest']/table/tbody//*[@class='dataValueRead']")
	private WebElement Contract_Code;
	@FindBy(xpath= "//select[@id='AccumCoveragePeriod']")//drop down
	WebElement Select_Coverage_Period;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Go']")
	WebElement BtnGo;
	//@FindBy(xpath="//*[@class='pzbtn-img'][text()=' Expand/Collapse All'][@title='Expand all']") //Expand and Collapse link
	@FindBy(xpath="//*[text()=' Expand/Collapse All']")
	WebElement lnktxt_Expand_Collapse;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement BtnSubmit;

	//tables
	@FindBy(xpath="//div[@node_name='MemberLevelAccumulator']")
	WebElement MemberLevelTable;
	@FindBy(xpath=("//*[@node_name='FamilyLevelAccumulator']"))
	WebElement FamilyLevelTable;
	@FindBy(xpath=("//*[@node_name='BenefitLevelAccumulatorOther']"))
	WebElement BenefitLevelTable;

	//other actions
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

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement2;


	/**
	 * Constructor for the Accumulators class defining the Iframe and the Page Factory  
	 */
	public ProviderAccumulator() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
		try{
			//check for header
			wait=new WebDriverWait(Driver.pgDriver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'View Accumulators')][@class='actionTitleBarLabelStyle']")));
			utils.validateHeader(this.sHeaderAccums, "View Accumulators");

		}catch(Exception e){
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);// change the driver
		}
	}

	DataSet ds=new DataSet();
	public static ArrayList<String>  rowelements=new ArrayList<String>();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	//frame 
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


	//change the Coverage period

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectDrpdwnCoveragePeriod
	 * #Arguments:CoveragePeriod-KeyValuePair
	 * Type:Table
	 *Keys:from#to

	 */
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
			//return true;
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
		//System.out.println("Go button clicked");
		return utils.clickAnelemnt(this.getBtnGo(), "View Accumulators", "Button to click Go");

	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickButtonSubmit
	 * Type:Textbox


	 */
	public boolean clickButtonSubmit()
	{
		WebElement element = Driver.pgDriver.findElement(By.xpath("//*[@class='pzbtn-mid'][text()='Submit']"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(this.BtnSubmit, "ProviderAccumulators", "Button to click Submit");
	}
	//PAGE LOADING .....................................
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

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateAccumsInfoMemberLevel
	 * #Arguments:AccumsMemberLevel-KeyValuePair
	 * Type:Table
	 *Keys:level#network#description#limit#start#date
	 */
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
		//System.out.println(col);
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
			// TODO Auto-generated catch block
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
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:tagAllAccumsMemberLevel
	 * Type:Textbox


	 */
	public boolean tagAllAccumsMemberLevel() throws IOException
	{

		Boolean returnvar1=true;
		List<WebElement> count=null;
		try{
			wait=new WebDriverWait(Driver.pgDriver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='MemberLevelAccumulator']//*[contains(@id,'IsMemberAccum')]")));
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
			if(utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Accumulators", "Cancel this Work"))
				if(utils.validateHeader(this.getHeader(),"Cancel this work"))
					if(utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, reason, "Cancel Accumulators", "Cancel reason"))
						return utils.clickAnelemnt(this.BtnSubmit, "Cancel Accumulators", "Submit button on cancel Accumulators");
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
					//System.out.println("no");
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

	///Changes Start here -Prarthana KS

	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Member Level')]")
	private WebElement hdrMemLvl;

	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Family Level')]")
	private WebElement hdrFamilyLvl;

	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Benefit Level')]")
	private WebElement hdrBenefitLvl;

	public boolean ExpandAll()
	{
		utils.clickAnelemnt(this.lnktxt_Expand_Collapse, "Accumulators", "Expand and collapse Link");
		String col=this.lnktxt_Expand_Collapse.getAttribute("isexpanded").toLowerCase();
		//System.out.println(col);
		if(col.contains("true"))
		{
			//Verify the only headers and tables are displayed
			if(this.MemberLevelTable.isDisplayed() && this.FamilyLevelTable.isDisplayed() && this.BenefitLevelTable.isDisplayed())
				System.out.println("Results are displaying Expanded mode");
			return true;
		}
		else{
			System.out.println("Results are displaying Collapse mode");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateAccumulatorInfoMemberLevel
	 * #Arguments:AccumsMemberLevel-KeyValuePair
	 * Type:Table
	 *Keys:level#network#description#limit#start#date
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
			selectAccumulatorInMemberLevelTable(this.MemberLevelTable,args);
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


	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateAccumulatorInfoFamilyLevel
	 * #Arguments:AccumsFamilyLevel-KeyValuePair
	 * Type:Table
	 *Keys:level#network#description#limit#start#date
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
			WebElement row =utils.returntablerowbasedonvalues(this.FamilyLevelTable,args );
			row.click();
			List<WebElement> allcolumns = row.findElements(By.tagName("td"));

			if(allcolumns.size()>0)
				allcolumns.get(0).click();
			else return false;	
			//WebElement column= row.findElement(By.xpath("//td[@title='press enter to expand row']"));
			//column.click();		
			System.out.println(row.getAttribute("pl_index"));
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level");
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");	
			return false;
		}
		return true;
	}

	//@FindBy(xpath=("//*[@node_name='pyGridPaginator']//table"))
	@FindBy(xpath=("//*[@pl_prop='.AccuClaimsList']"))
	WebElement claimLevelTable;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimInfoMemberLevel
	 * #Arguments:ClaimDetailsMemberLevel-KeyValuePair
	 * Type:Table
	 *Keys:claim number#processed date#accumulated amount#occurrences#type#reason#notes
	 */
	public boolean validateClaimInfoMemberLevel(String[] args)
	{
		boolean returnvar =true;
		String claimno= null,pdate= null,accamount = null,occurrences= null,type= null,reason= null,notes= null;
		ArrayList<String> expected= new ArrayList<String>();
		checkforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateClaimInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("claim number"))
			{			
				returnvar=true;
				claimno=value.toLowerCase().trim();				
				continue;

			}
			else if(key.toLowerCase().contains("processed date"))
			{
				returnvar=true;
				pdate=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("accumulated amount"))
			{
				returnvar=true;
				accamount=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("occurrences"))
			{
				returnvar=true;
				occurrences=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("type"))
			{
				returnvar=true;
				type=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("reason"))
			{
				returnvar=true;
				reason=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("notes"))
			{
				returnvar=true;
				notes=value.toLowerCase().trim();
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
			WebElement row =utils.returntablerowbasedonvalues(this.claimLevelTable,args );
			row.click();
			List<WebElement> allcolumns = row.findElements(By.tagName("td"));

			if(allcolumns.size()>0)
				allcolumns.get(0).click();
			else return false;	
			System.out.println(row.getAttribute("pl_index"));
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Claim Member Level");
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");	
			return false;
		}
		return true;
	}

	@FindBy(xpath="//*[text()='Submit']")
	WebElement submitBtn;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickSubmitOnViewAccumulators
	 * Type:Textbox 
	 * Description: Clicking on Submit in View Accumulators page
	 */
	public boolean clickSubmitOnViewAccumulators() throws InterruptedException
	{
		String header=Driver.getPgDriver().findElement(By.xpath("//label[@class='actionTitleBarLabelStyle']")).getText().toString().trim();
		if(header.contains("View Accumulators")){
			action.moveToElement(submitBtn);
			if(utils.clickAnelemnt(this.submitBtn , "Accumulators", "Submit"))
				if(Driver.getPgDriver().findElement(By.xpath("//label[@class='actionTitleBarLabelStyle']")).getText().toString().trim().contains("Accumulators Review"))
					System.out.println("Submit on View Accumulators page: successful");
			return true;

		}else{
			err.logcommonMethodError("Accumulators","Submission failed in View Accumulators Page");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickSubmitOnAccumulatorsReview
	 * Type:Textbox 
	 * Description: Clicking on Submit in Accumulators Review page
	 */
	public boolean clickSubmitOnAccumulatorsReview() throws InterruptedException
	{
		String header=Driver.getPgDriver().findElement(By.xpath("//label[@class='actionTitleBarLabelStyle']")).getText().toString().trim();
		if(header.contains("Accumulators Review")){
			utils.clickAnelemnt(this.submitBtn , "Accumulators", "Submit");
			if(Driver.getPgDriver().findElement(By.xpath("//label[@class='actionTitleBarLabelStyle']")).getText().toString().trim().contains("View Claim Details"))
				System.out.println("Submit on AccumulatorReview page: successful");
			return true;
		}else{
			err.logcommonMethodError("Accumulators","Submission failed in Accumulators Review Page");
			return false;
		}
	}


	@FindBy(xpath="//*[@node_name='MemberLevelAccumulator']//table//input[@id='IsMemberAccumReviewed2_rdi_1']")
	WebElement mLevelAccumDiscussed;

	@FindBy(xpath="//*[@node_name='FamilyLevelAccumulator']//*[@id='IsMemberAccumReviewed1_rdi_1']")
	WebElement fLevelAccumDiscussed;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectMemberLevelAccDiscussed
	 * Type:Checkbox
	 * Description: Selecting a row Member Level in Accumulators page
	 */
	public boolean selectMemberLevelAccDiscussed()
	{ 
		try{
			//Select the row - Accumulator discussed, Review Requested.
			System.out.println("Selection of checkbox Member Level: successful");
			return true;
		}catch(Exception e){
			err.logcommonMethodError("Accumulators","Selection of checkbox Member Level:Failed in Accumulators page");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectFamilyLevelAccDiscussed
	 * Type:Checkbox
	 * Description: Selecting a row Family Level in Accumulators page
	 */
	public boolean selectFamilyLevelAccDiscussed()
	{
		try{
			//Select the row - Accumulator discussed, Review Requested.
			System.out.println("Selection of checkbox Family Level: successful");
			return true;
		}catch(Exception e){
			err.logcommonMethodError("Accumulators","Selection of checkbox Family Level:Failed in Accumulators page");
			return false;
		}
	}



	@FindBy(id="IsAccumAdjustmentRequested2_rdi_1")
	WebElement chkBoxFirstInMemberLevel;

	public boolean clickFirstCheckBoxInMemberLevel() 
	{
		if (utils.clickAnelemnt(this.chkBoxFirstInMemberLevel, "Accumulator", "Member Level Check Box"))
			return clickButtonSubmit();
		return false;
	}





}





