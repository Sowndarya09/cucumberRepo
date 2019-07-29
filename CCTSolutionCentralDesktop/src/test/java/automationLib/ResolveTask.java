package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ResolveTask {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement1;

	public ResolveTask(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
	}


	@FindBy(id="PAResolutionOutcome")
	WebElement drpDownSelectResolutionTask;
	
	@FindBy(id="TimeZone")
	WebElement drpDownSelectTimeZone;
	
	@FindBy(id="DueDate")
	WebElement txtDueDate;
	
	@FindBy(id="DueTime")
	WebElement txtDueTime;
	
	@FindBy(xpath="//table[@id='headTbl_right9']")
	WebElement tblAvailableTable;
	
	@FindBy(xpath="//table[@pl_prop='.SelectedSRsListPATopic']")
	WebElement tblSelectedTable;
	
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[@id='$PpyWorkPage$pDueDateError']//span[@id='PegaRULESErrorFlag']")
	WebElement labelErrorMsgInDueDate;
	
	@FindBy(xpath="//div[@id='$PpyWorkPage$pDueTimeError']//span[@id='PegaRULESErrorFlag']")
	WebElement labelErrorMsgInDueTime;
	
	@FindBy(id="Notes")
	WebElement txtNotes;
	
	
	
	public boolean selectResolutionInResolveTask(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownSelectResolutionTask, args[0], "ResolveTask", "Resolution Task");
		
	}
	
	public boolean selectTimeZoneInResolveTask(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownSelectTimeZone, args[0], "ResolveTask", "Time Zone");
	}
	
	public boolean enterDueDate(String[] args) throws InterruptedException
	{
		
		Thread.sleep(3000);
		txtDueDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),args[0]);
		return true;
	}
	
	public boolean enterDueDateForWeekends(String[] args) throws InterruptedException
	{
		
		Thread.sleep(3000);
		txtDueDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),args[0],Keys.TAB);
		return true;
	}
	
	public boolean enterDueDateForHolidays(String[] args) throws InterruptedException
	{
		
		Thread.sleep(3000);
		txtDueDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),args[0],Keys.TAB);
		return true;
	}
	
	public boolean enterDueTime(String[] args) throws InterruptedException
	{
		Thread.sleep(3000);
		txtDueTime.clear();
		utils.enterTextinAnelemnt(txtDueTime, args[0], "ResolveTask", "Due Date");
		txtDueTime.sendKeys(Keys.TAB);
		return true;
	}
	
	String expectedText;
	
	public boolean validateTheSelectedTable(String[] tablevalues)
	{
		
			WebElement row = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.SelectedSRsListPATopic']"));
			List<WebElement> rowValues = row.findElements(By.tagName("td"));
			for(WebElement row1: rowValues)
			{
				expectedText = row1.getText();
			}

			//String expectedText = rowValues.toString();
			System.out.println("Expected Text: "+expectedText);
			return utils.isvalueMatch_contain(expectedText, tablevalues[0]);
	}
	
	public boolean validateTheAvailableTable(String[] tablevalues)
	{
			return utils.validateRowValues(tblAvailableTable, tablevalues);
	}
	
	
	public boolean validateTheErrorMsgOnClickingSubmitInDueDate(String[] msg)
	{
		 return utils.validateLabel(labelErrorMsgInDueDate, msg[0]);
	}
	
	@FindBy(xpath="//div[@data-test-id='2015110415560803062633']")
	WebElement labelErrorMsgInDueDateForWeekends;
	
	@FindBy(xpath="//div[@data-test-id='2015110415560803062633']")
	WebElement labelErrorMsgInDueDateForHolidays;
	
	@FindBy(id="ModalButtonSubmit")
	WebElement btnConfirm;
	
	public boolean validateTheErrorMsgOnClickingSubmitInDueDateForWeekends(String[] msg)
	{

		  if(utils.validateLabel(labelErrorMsgInDueDateForWeekends, msg[0]))
			  if(utils.clickAnelemnt(btnConfirm, "validateTheErrorMsgOnClickingSubmitInDueDateForWeekends", "Confirm"))
				  return true;
			return false;
	}
	
	public boolean validateTheErrorMsgOnClickingSubmitInDueDateForHolidays(String[] msg)
	{
		 if( utils.validateLabel(labelErrorMsgInDueDateForHolidays, msg[0]))
			 if(utils.clickAnelemnt(btnConfirm, "validateTheErrorMsgOnClickingSubmitInDueDateForHolidays", "Confirm"))
				 return true;
			return false;
	}
	
	
	public boolean validateTheErrorMsgOnClickingSubmitInDueTime(String[] msg)
	{
		 return utils.validateLabel(labelErrorMsgInDueTime, msg[0]);
	}
	
	public boolean enterNotes(String[] notes)
	{
		return utils.enterTextinAnelemnt(txtNotes, notes[0], "ResolveTask", "Notes Entered");
	}
	
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method allows the user to click on Submit in Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean clickOnSubmit() throws InterruptedException{
		Thread.sleep(2000);
		utils.scrolltomiddle();
			return utils.clickAnelemnt(this.btnSubmit, "ResolveOneDayGrievanceAndAppeals", "Submit button");
		
	}





	}