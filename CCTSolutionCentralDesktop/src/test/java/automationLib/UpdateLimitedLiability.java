package automationLib;

import java.io.IOException;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;





public class UpdateLimitedLiability extends Driver {

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(id="ReasonForContact")
	private WebElement ReasonForContact;

	@FindBy(xpath="//a[@data-test-id='2018013007443202375576']/img")
	private WebElement AddLL;

	@FindBy(xpath="//a[@data-test-id='20180130152549099311261']/img")
	private WebElement DeleteLL;

	@FindBy(id="OtherLimitedLiability")
	private WebElement OtherLimitedLiability;

	@FindBy(id="SpecialityType")
	private WebElement SelectLLtype;

	@FindBy(id="EffectiveDate")
	private WebElement EffectiveDate;

	@FindBy(id="ExpiryDate")
	private WebElement EndDate;

	@FindBy(xpath="//input[@data-test-id='20180130153048040026629']")
	private WebElement ProviderID;

	@FindBy(id="LimitedLiabilityText")
	private WebElement LimitedLiabilityText;

	@FindBy(xpath="//textarea[@id='pyNote']")
	private WebElement NotesBox;

	@FindBy(xpath="//div[text()='Submit']")
	private WebElement SubmitButton;

	@FindBy(xpath="//div[text()='Update']")
	private WebElement UpdateButton;

	@FindBy(xpath="//input[@data-test-id='201801301619240871679404']")
	private WebElement Name;

	@FindBy(xpath="//input[@data-test-id='201801301900250166600564']")
	private WebElement Zipcode;

	@FindBy(xpath="//input[@data-test-id='201801301538550280107891']")
	private WebElement DiagnosisStartRange;

	@FindBy(xpath="//input[@data-test-id='20180130153941045845736']")
	private WebElement DiagnosisEndRange;

	@FindBy(xpath="//a[@data-test-id='20180130153941045841510']")
	private WebElement AddRange;



	public UpdateLimitedLiability() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	//DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Accumulators acc=new Accumulators();
	Actions action=new Actions(Driver.getPgDriver());



	public boolean selectReasonForContact(String[] args)
	{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReasonForContact")));
			return utils.selectDropDownbyVisibleString(this.ReasonForContact, args[0], "UpdateLimitedLiability", "Reason for Contact");
	}

	public boolean ClickonAddLL()
	{
			return utils.clickAnelemnt(AddLL, "UpdateLimitedLiability", "AddLL");
	}


	public boolean validateDeleteButton()
	{
			return utils.clickAnelemnt(DeleteLL, "UpdateLimitedLiability", "AddLL");
	}


	public boolean selectOtherLimitedLiabiltyvalues(String[] args)
	{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OtherLimitedLiability")));
			return utils.selectDropDownbyVisibleString(this.OtherLimitedLiability, args[0], "UpdateLimitedLiability", "OtherLimitedLiability");
	}


	public boolean selectLLType(String[] args)
	{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SpecialityType")));
			return utils.selectDropDownbyVisibleString(this.SelectLLtype, args[0], "UpdateLimitedLiability", "selectLLType");
	}

	public boolean enterEffectiveDate(String[] args)
	{
			wait=new WebDriverWait(Driver.pgDriver,10);
			return utils.enterTextinAnelemnt(EffectiveDate, args[0], "UpdateLimitedLiability", "EffectiveDate");
	}

	public boolean enterEndDate(String[] args)
	{
			return utils.enterTextinAnelemnt(EndDate, args[0], "UpdateLimitedLiability", "EndDate");
	}

	public boolean enterProviderID(String[] args)
	{
		Select se = new Select(SelectLLtype);
		//System.out.println(se.getFirstSelectedOption().getText() +" Result of this     ");
			if(utils.isvalueMatch_contain(se.getFirstSelectedOption().getText(), "CLM")|| utils.isvalueMatch_contain(se.getFirstSelectedOption().getText(), "NOA"))
				return utils.enterTextinAnelemnt(ProviderID, args[0], "UpdateLimitedLiability", "ProviderID");
			return false;	
	}



	public boolean enterName(String[] args)
	{
			return utils.enterTextinAnelemnt(Name, args[0], "UpdateLimitedLiability", "Name");
	}

	public boolean enterZipcode(String[] args)
	{
			return utils.enterTextinAnelemnt(Zipcode , args[0], "UpdateLimitedLiability", "Zipcode");
	}

	public boolean clickAddDiagnosisRange()
	{
			JavascriptExecutor executor = (JavascriptExecutor)pgDriver;
			executor.executeScript("arguments[0].click();", AddRange);
			return utils.clickAnelemnt(AddRange, "UpdateLimitedLiability", "Addrange")	;	
	}



	//public int i;
	@FindBy(xpath="//input[@data-test-id='201801301538550280107891']")
	List<WebElement> startRange;

	@FindBy(xpath="//input[@data-test-id='20180130153941045845736']")
	List<WebElement> EndRange;

	public boolean validateDignosisValues()
	{
		try{
			int val1 = LimitedLiability.al.size();
			int val2 = startRange.size();

			int z=0;
			if(val1==val2)
			{
				int i=0;
				for (String range : LimitedLiability.al) {


					String value[] = ((String) range).split("-");
					int j=value.length;

					if(value[z].trim().equalsIgnoreCase(startRange.get(i).getAttribute("value").trim()) && value[z+1].trim().equalsIgnoreCase(EndRange.get(i).getAttribute("value").trim()))
					{
						blogger.loginfo("Diagnosis range is verfied successfully");
						i++;
						return true;
						
					}
					else
					{
						blogger.loginfo("Diagnosis range is not matching with existing values");
						err.logError("UpdateLimitedLiability", "Diagnosis range is not matching with existing values");
						return false;
					}
										
				}
			}
		}
			catch(Exception e)
			{
				blogger.loginfo("Diagnosis range is not matching with existing values");
				err.logError("UpdateLimitedLiability", "Diagnosis range is not matching with existing values");
			}
			return false;
		}



		public boolean EnterDiagnosisRange(String[] args) 
		{
				String fromrange[] = args[0].split(":");
				String endrange[] =args[1].split(":");
				for(int i=1;i<6;i++){
					clickAddDiagnosisRange();
					//TODO - need to modify the element
					String start="(//input[@data-test-id='201801301538550280107891'])"+"["+i+"]";
					//String start="DiagnosisStartRange"+i;
					WebElement DiagnosisStartRange_mod =pgDriver.findElement(By.xpath(start));
					String End="(//input[@data-test-id='20180130153941045845736'])"+"["+i+"]";
					//String End="DiagnosisEndRange"+i;
					WebElement DiagnosisEndRange_mod =pgDriver.findElement(By.xpath(End));
					if(utils.enterTextinAnelemnt(DiagnosisStartRange_mod, fromrange[1], "UpdateLimitedLiability", "DiagnosisStartRange"))
						if(utils.enterTextinAnelemnt(DiagnosisEndRange_mod, endrange[1], "UpdateLimitedLiability", "DiagnosisEndRange"))
							return true;
				}
				return false;
		}

		public boolean verifyAddLLDisable()
		{
				System.out.println("AddLL Diagnosis range is disabled"+AddRange.getAttribute("tabindex"));
				System.out.println("value");
				if(AddRange.getAttribute("tabindex").equalsIgnoreCase("-1")){
					blogger.loginfo("AddLL Diagnosis range is disabled");
					return true;
				}else{
					blogger.loginfo("AddLL Diagnosis range isn not disabled");
					return false;
				}
		}

		public boolean enterLimitedLaibilityText(String[] args)
		{
				return utils.enterTextinAnelemnt(LimitedLiabilityText , args[0], "UpdateLimitedLiability", "LimitedLiabilityText");
		}

		public boolean enterNotes(String[] args)
		{
				return utils.enterTextinAnelemnt(NotesBox , args[0], "UpdateLimitedLiability", "NotesBox");			
		}

		public boolean clickUpdateButton()
		{
				return utils.clickAnelemnt(UpdateButton, "UpdateLimitedLiability", "UpdateButton");
		}


		public boolean clickSubmitButton()
		{
				return utils.clickAnelemnt(SubmitButton, "UpdateLimitedLiability", "SubmitButton");
		}

		@FindBy(xpath="//input[@data-test-id='201801301619240872680925']")
		private WebElement enterStreetaddress;

		public boolean enterStreetaddress(String[] args)
		{
				return utils.enterTextinAnelemnt(enterStreetaddress , args[0], "UpdateLimitedLiability", "enterStreetaddress");
		}
		
		
		//sprint 3.4
		
		@FindBy(id="ReasonForContact")
		WebElement drpDownReasonForContact;
		public boolean verifyReasonForContactIsRemoved() {
			return utils.isProxyWebelement(drpDownReasonForContact);
		}
		
		@FindBy(xpath="//div[contains(@class,'float-left')]//div[contains(text(),'Update')]")
		WebElement btnUpdateReposition;
		
		public boolean verifyRepositionTheUpdateButton(){
			return !utils.isProxyWebelement(btnUpdateReposition);
		}

	}
