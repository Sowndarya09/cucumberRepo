package automationLib;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerManageClaims {


	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();
	
	WebDriverWait wait;

	public BrokerManageClaims()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		utils.waitforpageload();
	}

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForBroker;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="ContactType")
	WebElement drpDownContactType;
	
	@FindBy(id="ServiceFromDate")
	WebElement txtBxServiceFrmDate;
	@FindBy(id="ServiceToDate")
	WebElement txtBxServiceToDate;
	
	@FindBy(xpath="//input[contains(@id,'SCCF')]")
	WebElement txtBxSCCF;
	
	@FindBy(xpath="(//button[@data-test-id='201601290707250220580258'])[1]")
	WebElement btnSearch;
	
	@FindBy(xpath="//table[@pl_prop='D_ClaimSearchResults.HCMemberClaimDetails']")
	WebElement tblManageClaims;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	
	public boolean settxtBxServiceFrmDate(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.txtBxServiceFrmDate, sCCBID, "Manage Claim", "From Date ");

	}public boolean settxtBxServiceToDate(String sCCBID)
	{
		utils.clickAnelemnt(this.txtBxSCCF, "Manage Claims", "End Text box");
		try{
			if(utils.enterTextinAnelemnt(this.txtBxServiceToDate, sCCBID, "Manage Claim", "To Date "))
			{
				utils.clickAnelemnt(this.txtBxSCCF, "Manage Claims", "End Text box");
				return true;
			}

		}catch(Exception e){
			return utils.enterTextinAnelemnt(this.txtBxServiceToDate, sCCBID, "Manage Claim", "To Date ");
		}
		utils.clickAnelemnt(this.txtBxSCCF, "Manage Claims", "End Text box");
		return false;
	}
	
	int i=0;
	public boolean clickSearch()
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.btnSearch, "ManageClaims", "Search Button"))
		{
			try
			{
				wait=new WebDriverWait(Driver.pgDriver,15);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'HCMemberClaimDetails')]")));
				if(this.tblManageClaims.isDisplayed())
				{
					return true; 	 
				}
				else
				{
					i++;
					if(i<4){
					clickSearch();
					return true;
					}
				}
			}
			catch(Exception e)
			{
				i++;
				if(i<4){
					clickSearch();
					return true;
				}

			}
		}
		else
			return false;

		return false;

	}
	
	/**
	 * This functionality enters the from date and end date to search the claim
	 * @param args
	 * @return
	 */
	public boolean searchbyCustomDate(String[] args)
	{
		utils.waitforpageload();
		for(int i=0;i<args.length;i++)
		{

			if(args[i].toLowerCase().contains("start"))
			{
				String s1=args[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s1=s1.replaceAll("/", "");
				if( this.settxtBxServiceFrmDate(s1.trim()))
				{

					continue;
				}
				else
					return false;
			}

			else if (args[i].toLowerCase().contains("end"))
			{
				utils.waitforpageload();
				String s1=args[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s1=s1.replaceAll("/", "");

				if(this.settxtBxServiceToDate(s1.trim()))
				{

					continue;
				}
				else
					return false;
			}
		}
		return this.clickSearch();

	}
	
	/**
	 * This functionality clicks on the claim number given by the user in the claim search results section
	 * @param claimnumber
	 * @return
	 */
	public boolean clickOnClaimNumber(String[] claimnumber)
	{
		try
		{
		utils.waitforpageload();
		WebElement element1 = this.tblManageClaims;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element1);
		String tempxpath="//table[@class='gridTable ']//a[text()='"+claimnumber[0]+"']";
		System.out.println(tempxpath);
		Driver.pgDriver.findElement(By.xpath(tempxpath)).click();
		return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("BrokerManageClaims", "clickOnClaimNumber", "Error in clicking claim number: "+e);
			return false;
		}
	
	}

	/**
	 * This functionality validates the claims data given by the user and then tags the claim of the validated row
	 * @param args
	 * @return
	 */
	public boolean validateManageClaims(String[] args)
	{
		utils.waitforpageload();
		boolean returnvar =true;
		String firstdate= null,lastdate= null, claimnumber = null, billingprovider= null, renderingprovider= null, claimtype= null,totalchargedamount= null,receiveddate=null, processeddate=null,actioncode=null,paiddate=null, paidamount=null, memberliability=null;
		ArrayList<String> expected= new ArrayList<String>();
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

			if(key.toLowerCase().contains("first date"))
			{                    
				returnvar=true;
				firstdate=value.toLowerCase().trim();                      
				continue;

			}
			else if(key.toLowerCase().contains("last date"))
			{
				returnvar=true;
				lastdate=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("claim number"))
			{
				returnvar=true;
				claimnumber=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("billing provider"))
			{
				returnvar=true;
				billingprovider=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("rendering provider"))
			{
				returnvar=true;
				renderingprovider=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("claim type"))
			{
				returnvar=true;
				claimtype=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("total charged amount"))
			{
				returnvar=true;
				totalchargedamount=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("received date"))
			{
				returnvar=true;
				receiveddate=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("processed date"))
			{
				returnvar=true;
				processeddate=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar=true;
				actioncode=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("paid date"))
			{
				returnvar=true;
				paiddate=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("paid amount"))
			{
				returnvar=true;
				paidamount=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("member liability"))
			{
				returnvar=true;
				memberliability=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("ManageClaims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}

		try{
			System.out.println("Enterd into Try block");
			WebElement element = this.tblManageClaims;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row =utils.getTablerowbasedonvalues(this.tblManageClaims,args);
			List<WebElement> rowNo = row.findElements(By.tagName("input"));
			rowNo.get(1).click();
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
			return false;
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;
	
	}

	/**
	 * This functionality clicks on the submit button in the Broker Manage Claims page
	 * @return
	 */
	public boolean clickOnSumbit()
	{
		return utils.clickAnelemnt(btnSubmit, "Select Associate Contact", "Button Submit");

	}



}
