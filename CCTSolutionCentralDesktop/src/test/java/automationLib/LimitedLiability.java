package automationLib;

import java.util.Collections;
import java.util.HashMap;
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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class LimitedLiability extends Driver
{
	DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderLimited;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Load More Data')]")
	private WebElement btnLoadMoreData;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Load More Data')]//img")
	private WebElement chkLoadData;
	@FindBy(linkText="Next")
	public WebElement lnkNext;
	@FindBy(xpath="//*[@class='gridTable ']")
	public WebElement table;
	@FindBy(xpath="//*[@class='gridTable ']//*[@data-attribute-name='Type']//div[@class='oflowDivM ']")
	public WebElement table_Type;
	@FindBy(xpath="//*[@class='gridTable ']//*[@data-attribute-name='Effective Date']//div[@class='oflowDivM ']")
	public WebElement table_EffDt;
	@FindBy(xpath="//*[@class='gridTable ']//*[@data-attribute-name='End Date']//div[@class='oflowDivM ']")
	public WebElement table_EndDt;
	@FindBy(xpath="//*[@class='gridTable ']//*[@data-attribute-name='Reason Code']//div[@class='oflowDivM ']")
	public WebElement table_RsnCd;
	@FindBy(xpath="//*[@class='gridTable ']//*[@data-attribute-name='Description']//div[@class='oflowDivM ']")
	public WebElement table_Desc;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement BtnSubmit;
	@FindBy(id="CancellationReason")
	WebElement drpdwnCancellationreason;
	@FindBy(xpath= "//tr[@expanded='true']//*[@pl_prop='.Address']")
	public WebElement DiagTable;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;

	@FindBy(xpath="//table[contains(@pl_prop,'D_LimitedLiabilityList.LimitedLiabilityList')]")
	WebElement tableLimitedLiability;


	@FindBy(xpath="//span[@title='press enter to expand row']")
	WebElement ExpandRow;

	public static String value[];

	public LimitedLiability() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	public WebElement getHeader()
	{
		return sHeaderLimited;
	}

	public boolean ClickLoadMoreData()
	{
		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOf(this.btnLoadMoreData));
		return utils.clickAnelemnt(btnLoadMoreData, "Limited Liability", "Load More Data Button");
	}

	@FindBy(xpath="//button[contains(@data-click,'LimitedLiabilityData')]")
	public WebElement ButtonProp;

	/**This method is used to click Load more until last page
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean ClickUntilLastPage() throws InterruptedException
	{
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			this.ButtonProp.getAttribute("disabled").equals("");

		}
		catch(Exception e)
		{
			Thread.sleep(1000); 
			this.ClickLoadMoreData();
			ClickUntilLastPage();
		}
		return true;
	}

	@FindBy(linkText="Next")
	WebElement NextLink;

	@FindBy(xpath="//*[@id='pyGridActivePage']")
	WebElement PageNumber;

	/**Thi smethod is to validate Limited Liability table data
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean validateLimitedLiability(String[] args) throws InterruptedException
	{
		utils.waitforpageload();
		this.ClickUntilLastPage();
		String exptype=null,expeffdt=null,expenddt=null;
		boolean returnvar=true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("View Limited Liability", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();

			if(key.toLowerCase().contains("type"))
			{			
				returnvar=true;
				exptype=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("eff"))
			{
				returnvar=true;
				expeffdt=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("end"))
			{
				returnvar=true;
				expenddt=value.toLowerCase().trim();
				continue;

			}
			else
			{
				err.logcommonMethodError("View Limited Liability", "Check your key in your keypair. Make sure you are following the same pattern for input");
				returnvar= false;
				return false;
			}
		}

	utils.waitforpageload();

		int num=1;
		Boolean linkval=true;;
		try
		{
			NextLink.isDisplayed();
		}
		catch(NoSuchElementException e)
		{
			linkval=false;

		}
		if(linkval)
		{
			WebElement element = Driver.pgDriver.findElement(By.linkText("Next"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			if(this.lnkNext.isDisplayed())
			{
				String pgno=PageNumber.getAttribute("aria-label");
				pgno=pgno.substring(pgno.length()-1);
				num=Integer.parseInt(pgno);
			}
		}

		Boolean val=null;
		for(int pagenum=1;pagenum<=num;pagenum++)
		{
			args[0]=exptype;
			args[1]=expeffdt;
			args[2]=expenddt;

			Thread.sleep(1000); //Stale Element exception
			val=this.validateRowValues(this.tableLimitedLiability, args,pagenum);
			if(val)
				break;

		}
		if(exptype.contains("cob"))
		{
			this.ValidateFieldsLLCOB();
		}
		else if(exptype.contains("spi"))
		{
			this.ValidateFieldsLLSPI();
		}
		else if(exptype.contains("tpl"))
		{
			this.ValidateFieldsLLTPL();		
		}
		else if(exptype.contains("wcp"))
		{
			this.ValidateFieldsLLWCP();
		}
		else if(exptype.contains("med"))
		{
			this.ValidateFieldsLLMED();
		}
		else if(exptype.contains("alt"))
		{
			this.ValidateFieldsLLALT();
		}
		else if(exptype.contains("rec"))
		{
			this.ValidateFieldsLLREC();
		}
		else if(exptype.contains("trm"))
		{
			this.ValidateFieldsLLTRM();
		}
		else 
		{
			err.logError("Entered Input should match with below LL types\n1.Med 2.COB 3.ALT 4.TPL 5.WCP 6.REC 7.TRM 8.SPI ");
			return false;
		}

		return true;
	}

	/**This method is to validate rows and click on the same
	 * 
	 * @param tbl
	 * @param tablevalues
	 * @param pagenum
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean validateRowValues(WebElement tbl,String[] tablevalues,int pagenum) 
	{
		WebElement srchResults = tbl;
		ArrayList headerrow= utils.getheaderrowFromTable(tbl);
		boolean returnvar2=true;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		for (WebElement row : allRows) 
		{
			List<WebElement> allColsByRow=null;
			try
			{
				allColsByRow =row.findElements(By.tagName("td"));
				for(int i=0;i<allColsByRow.size();i++)
				{
					if(allColsByRow.get(headerrow.indexOf("Type")).getText().toLowerCase().contains(tablevalues[0]))
					{
						if(allColsByRow.get(headerrow.indexOf("Effective Date")).getText().toLowerCase().contains(tablevalues[1]))
						{
							if(allColsByRow.get(headerrow.indexOf("End Date")).getText().toLowerCase().contains(tablevalues[2]))
							{
								WebElement triangle=allColsByRow.get(0);
								utils.clickAnelemnt(triangle, "View Limited Liability", "Expand ");
								try{
									wait=new WebDriverWait(Driver.pgDriver,10);
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@expanded='true']//div[@id='CT']//*[@class='content-inner ']//*[@class='field-item dataValueRead']")));
								}catch(Exception e)
								{
									utils.clickAnelemnt(triangle, "View Limited Liability", "Expand ");
								}
								Thread.sleep(100);
								return true;
							}
							else
								break;
						}
						else
							break;
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
		if(returnvar2)
		{
			blogger.loginfo("Value not found in Pagenumber"+pagenum);
			if(this.lnkNext.isDisplayed())
			{
				utils.clickAnelemnt(this.lnkNext, "View Limited Liability", "Next Link");
				return false;
			}
			else
			{
				err.logError("Entered Input Not matching with Any of the Rows");
				return false;
			}

		}
		return true;
	}


	public boolean clickButtonSubmit()
	{
		JavascriptExecutor jse=(JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView(true);", BtnSubmit);
		return utils.clickAnelemnt(this.BtnSubmit, "View Limited Liability", "Button to click Submit");
	}
	public boolean CancelLimitedLiability(String[] cancelreason)
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
					err.logcommonMethodError("Cancel Limited Liability", "Check your Reason for Cancellation");
				}
				continue;

			}

			else
			{
				err.logcommonMethodError("Cancel Limited Liability", "Check your key in your keypair. Make sure you are following the same pattern for input");
				return false;
			}

		}
		if(utils.clickAnelemnt(this.btnOtherActions, "Limited Liability", "Other Actions Button"))
		{
			if(utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Limited Liability", "Cancel this Work"))
			{
				if(utils.validateHeader(this.getHeader(),"Cancel this work"))
				{
					if(utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, reason, "Cancel Limited Liability", "Cancel reason"))
					{
						if(utils.clickAnelemnt(this.BtnSubmit, "Cancel Limited Liability", "Submit button on cancel Limited Liability"));
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

	public boolean ValidateFieldsLLCOB()
	{
		String xpath="//tr[@expanded='true']//div[@id='CT']//*[@class='content-inner ']//*[@class='field-item dataValueRead']/span";

		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		List<WebElement> count=Driver.pgDriver.findElements(By.xpath(xpath));
		for(int i=1;i<=count.size();i++)
		{
			String xp="(//tr[@expanded='true']//div[@id='CT']//*[@class='content-inner ']//div[@class='field-item dataValueRead']/span)[position()="+i+"]";

			WebElement e=Driver.pgDriver.findElement(By.xpath(xp));		


			String a=e.getText().toLowerCase().toString();
			System.out.println(i+":"+a);
			if(a.startsWith(" "))
			{
				err.logError("One of the Field is Blank");
				return false;
			}
		}

		return true;
	}

	public boolean ValidateFieldsLLSPI()
	{
		String xpath="//tr[@expanded='true']//*[@class='content-inner ']//*[@class='field-item dataValueRead']";
		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		List<WebElement> count=Driver.pgDriver.findElements(By.xpath(xpath));
		for(int i=1;i<=count.size();i++)
		{
			String xp="(//tr[@expanded='true']//*[@class='content-inner ']//*[@class='field-item dataValueRead']/span)[position()="+i+"]";
			WebElement e=Driver.pgDriver.findElement(By.xpath(xp));
			String a=e.getText().toLowerCase().toString();
			System.out.println(i+":"+a);
			if(i==1)
			{
				if(a.isEmpty())
				{
					err.logError("SPI Subtype field is Blank");
					return false;
				}
			}
			if(a.startsWith(" "))
			{
				err.logError("One of the Field is Blank");
				return false;
			}
		}
		return validateDiagnosisRangesOneCol(this.DiagTable);
	}

	public boolean ValidateFieldsLLMED()
	{

		String xpath="//tr[@expanded='true']//*[@class='field-item dataValueRead']/span";
		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		List<WebElement> count=Driver.pgDriver.findElements(By.xpath(xpath));

		for(int i=1;i<=count.size();i++)
		{
			String xp="(//tr[@expanded='true']//*[@class='field-item dataValueRead']/span)[position()="+i+"]";
			WebElement e=Driver.pgDriver.findElement(By.xpath(xp));
			String a=e.getText().toLowerCase().toString();
			System.out.println(i+":"+a);
			if(a.startsWith(" "))
			{
				err.logError("One of the Field is Blank");
				return false;
			}
		}
		return true;
	}

	public boolean ValidateFieldsLLALT()
	{

		String xpath="//tr[@expanded='true']//*[@class='field-item dataValueRead']/span";
		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		List<WebElement> count=Driver.pgDriver.findElements(By.xpath(xpath));

		for(int i=1;i<=count.size();i++)
		{
			String xp="(//tr[@expanded='true']//*[@class='field-item dataValueRead']/span)[position()="+i+"]";
			WebElement e=Driver.pgDriver.findElement(By.xpath(xp));
			String a=e.getText().toLowerCase().toString();
			System.out.println(i+":"+a);
			if(a.startsWith(" "))
			{
				err.logError("One of the Field is Blank");
				return false;
			}
		}

		return true;
	}

	public boolean ValidateFieldsLLREC()
	{

		String xpath="//tr[@expanded='true']//*[@class='field-item dataValueRead']";
		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		List<WebElement> count=Driver.pgDriver.findElements(By.xpath(xpath));

		for(int i=1;i<=count.size();i++)
		{
			String xp="(//tr[@expanded='true']//*[@class='field-item dataValueRead']/span)[position()="+i+"]";
			WebElement e=Driver.pgDriver.findElement(By.xpath(xp));
			String a=e.getText().toLowerCase().toString();
			System.out.println(i+":"+a);
			if(a.startsWith(" "))
			{
				err.logError("One of the Field is Blank");
				return false;
			}
		}
		return this.validateDiagnosisRangesOneCol(this.DiagTable);
	}

	public boolean ValidateFieldsLLTRM()
	{
		String xpath="//tr[@expanded='true']//*[@class='field-item dataValueRead']";
		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		List<WebElement> count=Driver.pgDriver.findElements(By.xpath(xpath));

		for(int i=1;i<=count.size();i++)
		{
			String xp="(//tr[@expanded='true']//*[@class='field-item dataValueRead']/span)[position()="+i+"]";
			WebElement e=Driver.pgDriver.findElement(By.xpath(xp));
			String a=e.getText().toLowerCase().toString();
			System.out.println(i+":"+a);
			if(a.startsWith(" "))
			{
				err.logError("One of the Field is Blank");
				return false;
			}
		}
		return this.validateDiagnosisRangesOneCol(this.DiagTable);
	}

	public boolean ValidateFieldsLLWCP()
	{
		String xpath="//tr[@expanded='true']//*[@class='field-item dataValueRead']";
		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		List<WebElement> count=Driver.pgDriver.findElements(By.xpath(xpath));

		for(int i=1;i<=count.size();i++)
		{
			String xp="(//tr[@expanded='true']//*[@class='field-item dataValueRead']/span)[position()="+i+"]";
			WebElement e=Driver.pgDriver.findElement(By.xpath(xp));
			String a=e.getText().toLowerCase().toString();
			System.out.println(i+":"+a);
			if(a.startsWith(" "))
			{
				err.logError("One of the Field is Blank");
				return false;
			}
		}
		return this.validateDiagnosisRangesFiveCol(this.DiagTable);
	}

	public boolean ValidateFieldsLLTPL()
	{

		String xpath="//tr[@expanded='true']//*[@class='field-item dataValueRead']";
		wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		List<WebElement> count=Driver.pgDriver.findElements(By.xpath(xpath));

		for(int i=1;i<=count.size();i++)
		{
			String xp="(//tr[@expanded='true']//*[@class='field-item dataValueRead']/span)[position()="+i+"]";
			WebElement e=Driver.pgDriver.findElement(By.xpath(xp));
			String a=e.getText().toLowerCase().toString();
			System.out.println(i+":"+a);
			if(a.startsWith(" "))
			{
				err.logError("One of the Field is Blank");
				return false;
			}
		}
		return this.validateDiagnosisRangesFiveCol(this.DiagTable);
	}

	public boolean validateDiagnosisRangesOneCol(WebElement tb)
	{
		WebElement srchResults = tb;

		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		for (WebElement row : allRows) 
		{
			List<WebElement> allColsByRow=null;
			try
			{
				allColsByRow =row.findElements(By.tagName("td"));
				for(int i=1;i<=allColsByRow.size();i++)
				{

					String a1=allColsByRow.get(0).getText().toLowerCase();
					System.out.println(a1);
					if(a1.startsWith(" "))
					{
						err.logError("One of the Field is Blank");
						return false;
					}
					if(a1.isEmpty())
					{
						err.logError("One of the Field is Blank");
						return false;
					}

				}
			}
			catch(Exception e)
			{
				continue;
			}
		}
		return true;
	}

	public boolean validateDiagnosisRangesFiveCol(WebElement tb)
	{
		WebElement srchResults = tb;

		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		for (WebElement row : allRows) 
		{
			List<WebElement> allColsByRow=null;
			try
			{
				allColsByRow =row.findElements(By.tagName("td"));

				for(int i=1;i<=allColsByRow.size();i++)
				{
					System.out.println(allColsByRow.get(0).getText().toLowerCase());
					System.out.println(allColsByRow.get(1).getText().toLowerCase());
					System.out.println(allColsByRow.get(2).getText().toLowerCase());
					System.out.println(allColsByRow.get(3).getText().toLowerCase());
					System.out.println(allColsByRow.get(4).getText().toLowerCase());

					if(allColsByRow.get(0).getText().toLowerCase().isEmpty())
					{
						err.logError("Diagnosis Range Field is Blank");
						return false;
					}
					if(allColsByRow.get(1).getText().toLowerCase().isEmpty())
					{
						err.logError("Type of contanct Field is Blank");
						return false;
					}
					if(allColsByRow.get(2).getText().toLowerCase().isEmpty())
					{
						err.logError("contact name  Field is Blank");
						return false;
					}
					if(allColsByRow.get(3).getText().toLowerCase().isEmpty())
					{
						err.logError("phone number Field is Blank");
						return false;
					}
					if(allColsByRow.get(4).getText().toLowerCase().isEmpty())
					{
						err.logError("Phone Extension Field is Blank");
						return false;
					}
				}
			}
			catch(Exception e)
			{
				continue;
			}
		}
		return true;
	}

	public static ArrayList<String> al;

	@FindBy(xpath="//table[@pl_prop='D_LimitedLiabilityList.LimitedLiabilityList']")
	WebElement limitedLiabilityTable;

	public boolean selectRadioButtonByType(String[] args)
	{
		al = new ArrayList<String>();
		try{
			WebElement row = utils.getProviderResultsBasedOnValues(this.limitedLiabilityTable, args);
			row.findElement(By.xpath(".//input[@id='CaseOrTaskIcon']")).click();

			WebElement table = utils.getProviderResultsBasedOnValues(this.limitedLiabilityTable, args);
			table.findElement(By.xpath(".//span[@title='press enter to expand row']")).click();
			for(WebElement we:this.Diagnosistablevalues){
				System.out.println(al.add(we.getText()));
			}
			System.out.println(al);
			return true;

		}catch(Exception e){
			return false;	
		}

	}

	@FindBy(xpath="//td[@data-attribute-name='Diagnosis Range(s)']/div/span[@data-test-id='20160217061326025923908']")
	List<WebElement> Diagnosistablevalues;

	@FindBy(xpath="(//button[contains(@name,'ViewLimitedLiability_pyWork')])[last()]")
	WebElement clearBtn;


	@FindBy(xpath="//table[@pl_prop='D_LimitedLiabilityList.LimitedLiabilityList']")
	WebElement tblViewLimitedLiability;


	public boolean displayClearButtonandClick(){
		return utils.clickAnelemnt(clearBtn, "View Limited Liability", "Clear Button");
	}

	public boolean donotDisplayClearButton(){
		Driver.pgDriver.findElement(By.xpath("(//button[contains(@name,'ViewLimitedLiability_pyWork') and @disabled])[last()]"));
		return true;
	}


	public boolean selectARecord(String[] tablevalues) throws InterruptedException
	{
		WebElement row = utils.returntablerowbasedonvalues(tblViewLimitedLiability, tablevalues);
		List<WebElement> rowValue = row.findElements(By.tagName("input"));
		rowValue.get(0).click();
		return true;
	}






}
