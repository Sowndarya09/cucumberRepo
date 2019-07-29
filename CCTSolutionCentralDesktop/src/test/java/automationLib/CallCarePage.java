package automationLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ReadFile;
import utils.SeleniumUtilities;

public class CallCarePage {


	JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
	public CallCarePage() throws InterruptedException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();

		Thread.sleep(10000);
		if(TabHandles("https://ccb-wgs"))
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.iframeElement);
			Driver.pgDriver.findElement(By.cssSelector("#wrapup"));
			System.out.println("Successfully Navigated to the required Page ");
		}
	}
	@FindBy(name="menu")
	WebElement iframeElement;

	@FindBy(name="data")
	WebElement iframeElement2;

	@FindBy(xpath="//area[contains(@href,'wrapup()')]")
	WebElement lnkWrapUp;

	static String inquirynumber,scidfromccb;

	@FindBy(xpath="//*[@name='wrapupbody']//table[@cellspacing='2']")
	WebElement tableWrapUp;
	@FindBy(xpath="//input[@name='wuanalysis']")
	WebElement txtBxAnalysisWrapup;
	@FindBy(xpath="//input[@name='updatebutton']")
	WebElement btnUpdate;
	@FindBy(xpath="//*[@value='Y'][@name='wusend']")
	WebElement rdBtnSendYes;

	@FindBy(xpath="//*[text()='Submit']")
	WebElement btnSubmit;

	@FindBy(xpath="//th[contains(text(),'Inquiry')]/following-sibling::td")
	WebElement labelinqno;

	@FindBy(xpath="//th[contains(text(),'Solution Central')]/following-sibling::td")
	WebElement labelSCid;

	public boolean SelectInquiry() throws InterruptedException, AWTException
	{

		System.out.println("Start Select Query  ");
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.iframeElement2);
		Driver.pgDriver.findElement(By.xpath("//*[@name='wuanalysis']")).click();
		Driver.pgDriver.findElement(By.xpath("//*[@name='wuanalysis']")).sendKeys(Keys.TAB);
		;
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);

		System.out.println("Press Enter ");
		JavascriptExecutor js = null;

		try 
		{
			Driver.pgDriver.findElement(By.xpath("//*[contains(@href,'wuanalysis')]//img[contains(@src,'lookup')]")).click();
		}
		catch(Exception e )
		{
			System.out.println(e);	
		}

		if(TabHandles("wrapupIQTCodes"))
		{
			Driver.getPgDriver().switchTo().defaultContent();
			System.out.println("Check 1");
			Thread.sleep(5000);
			try
			{
				Driver.pgDriver.findElement(By.xpath("//*[@id='form1']/table//*[contains(@href,'AD')]/strong")).click();
				Thread.sleep(2000);
				if(TabHandles("wrapupIQTCodes"))
				{
					Driver.pgDriver.findElement(By.xpath("//*[@id='form1']/table//*[contains(@href,'AD')]/strong")).sendKeys(Keys.ENTER);}

			}
			catch(Exception e)
			{
				System.out.println(e+ "Double Cushion");
			}
			System.out.println("Successfully Navigated to the required Page ");
		}
		return false;
	}


	public boolean clickbtnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit , "Task Queue Pagge", "check box Member Info ");
	}
	public boolean settxtBxToWrapUp(String sCCBID)
	{
		System.out.println(sCCBID+"entered");
		return utils.enterTextinAnelemnt(this.txtBxAnalysisWrapup, sCCBID, "Wrap Up ", "Comments");

	}

	public boolean clickrdBtnSendYes()
	{
		return utils.clickAnelemnt(this.rdBtnSendYes , "Task Queue Pagge", "check box Member Info ");
	}
	public boolean clickbtnUpdate()
	{

		try
		{	
			if(TabHandles("https://ccb-wgs"))
			{
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.iframeElement2);
			}
			System.out.println(": Pass : Clicked on Update ");
			utils.clickAnelemnt(this.btnUpdate , "Task Queue Pagge", "Update Button");
		}
		catch(Exception e )
		{
			System.out.println(e);
		}
		return false;

	}

	public boolean TabHandles(String sUrl ) throws InterruptedException {

		ArrayList<String> windowHandles = new ArrayList<String>(Driver.pgDriver.getWindowHandles());

		for (String window:windowHandles){
			System.out.println(Driver.pgDriver.switchTo().window(window) );
			if(Driver.pgDriver.getCurrentUrl().contains(sUrl))
			{
				System.out.println(Driver.pgDriver.getTitle());
				return true;
			}
			Thread.sleep(3000);
		}
		return false;
	}


	/**
	 * Handling Alert from the Page
	 * @return
	 */
	public boolean readAlertOk()
	{
		try
		{
			Thread.sleep(3000);
			Alert alert= Driver.pgDriver.switchTo().alert();
			if(alert.getText().contains("STOP")){
			}

			alert.accept();
			System.out.println("Pass : Clicked on Alert OK");
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e +"No Alert.  Navigate Further");
		}

		return false;
	}

	SeleniumUtilities utils= new SeleniumUtilities();
	/**
	 * 
	 * Click on Wrap Up bu using Enter 
	 * @return
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean clickWrapUp() throws AWTException, InterruptedException
	{
		System.out.println("start : Click on Wrap Up ");
		this.lnkWrapUp.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		try{
			Driver.pgDriver.findElement(By.xpath("//*[@id='wrapup']")).click();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);

		try{
			System.out.println("Start ");
			Driver.pgDriver.findElement(By.xpath("//*[@id='wrapup']"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}Thread.sleep(5000);
		return true;
	}


	/**
	 * For checking teh Value of the Inquiry no and Interaction ID, teh table is provided so we extract the value from that 
	 * @param sTextceck
	 * @return
	 * @throws IOException
	 */
	public boolean getInquiryNumber() throws IOException
	{
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.iframeElement2);
		inquirynumber=labelinqno.getText();
		scidfromccb=labelSCid.getText();
		System.out.println("Callcarepage"+inquirynumber+scidfromccb+"");

		return true;	
	}






	/*
	 * Will click on the arap up and exit after checking in all the values 
	 */
	public boolean UpdateWrapUpExit(String[] args) throws AWTException, InterruptedException, IOException
	{

		System.out.println("============================================Start: Entered the Page of Call Care and executing the method for Wrap Up======================");
		if(this.clickWrapUp())
		{
			if(this.getInquiryNumber())
			{
				if(this.clickrdBtnSendYes())
				{
					if(this.settxtBxToWrapUp(args[1]))
					{
						if(this.clickbtnUpdate())
						{
							if(this.readAlertOk())
							{			
								if(utils.TabHandles("solutioncentral"))
								{
									return true;
								}
							}
						}
					}
				}
			}

			System.out.println("Fail : Not successful in one or more field and not able to navigate back to cash page, check if the values entered were OK.");
			return false;
		}

		return false;

	}

	public boolean validateCCBMandatoryAlertandCCBOpenAlert() throws AWTException, InterruptedException, IOException
	{
		System.out.println("============================================Start: Entered the Page of Call Care and executing the method for Wrap Up======================");
		if(this.clickWrapUp())
		{
			if(this.getInquiryNumber())
			{

				if(this.clickbtnUpdate())
				{
					if(this.readAlertOk())
					{
						System.out.println(Driver.pgDriver.getPageSource().toString());
						if(Driver.pgDriver.getPageSource().contains("ANALYSIS CODE IS REQUIRED"))
							System.out.println("Error code checked.Pass");
						else
						{
							System.out.println("Error message not found");
							return false;
						}
						System.out.println("Pass : Successfully clicked on OK and able to navigate back to cash page if the values entered were OK.");
						if(utils.TabHandles("solutioncentral"))
						{

							return true;
						}
					}

				}

			}
		}
		System.out.println("Fail : Not successful in one or more field and not able to navigate back to cash page, check if the values entered were OK.");
		return false;
	}

}
