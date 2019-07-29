package automationLib;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ViewRemit {


	SeleniumUtilities utils = new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(), 20);
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	public ViewRemit() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	
	}

	@FindBy(xpath="//label[@for='ClaimText']/following-sibling::div/span")
	WebElement labelClaimNumber;
	
	@FindBy(xpath="//label[@for='ServiceDates']/following-sibling::div/span")
	WebElement labelDatesOfService;
	
	@FindBy(xpath="//label[@for='ProviderName']/following-sibling::div/span")
	WebElement labelProviderName;
	
	@FindBy(xpath="//label[@for='CheckNumber']/following-sibling::div/span")
	WebElement labelCheckNumber;
	
	@FindBy(id="ClaimText")
	WebElement drpDownClaimNumber;
	
	@FindBy(xpath="//div[@node_name='ViewRemit']//div[contains(text(),'Search')]")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[contains(text(),'OnDemand')]")
	WebElement lnkOnDemand;
	
	@FindBy(xpath="//table[@pl_prop='.ViewRemitSelected.pxResults']//span//a")
	List<WebElement> lnkRemitDate;
	
	//@FindBy(xpath="//div[@node_name='pyCaseActionAreaButtons']//div[contains(text(),'Submit')]")
	@FindBy(xpath="//button[@title='Complete this assignment']//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[@string_type='paragraph']/div/p/span")
	WebElement txtErrorMessage;
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyViewRemitsInfo
	 * #Description: This functionality verifies the Remits information in the View Remit page
	 * #Argument: remitsinfo
	 * Type: Table
	 * keys: Dates Of Service#Provider Name#Check Number#Claim Number
	 */
	public boolean verifyViewRemitsInfo(String[] remitsinfo)
	{
		System.out.println("Entered into the method");
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
			for(String iterator : remitsinfo)
			{
				keyvaluepair = iterator;
				if(!returnvar)
				{
					err.logcommonMethodError("verifyViewRemitsInfo", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				String key = iterator.substring(0, iterator.indexOf(":"));
				String value = iterator.substring(iterator.indexOf(":")+1);
				System.out.println("key " + key + " " + "value  " + value);
	
				if(key.equals("Claim Number")){
					returnvar = this.labelClaimNumber.getText().contains(value);
					continue;}
				else if(key.equals("Dates Of Service")){
					returnvar = this.labelDatesOfService.getText().contains(value);
					continue;}
				else if(key.equals("Provider Name")){
					returnvar = this.labelProviderName.getText().contains(value);
					continue;}
				else if(key.equals("Check Number")){
					returnvar = this.labelCheckNumber.getText().contains(value);
					continue;
				}else{
				err.logcommonMethodError("ViewRemit", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
				}
			}
		if(returnvar)
		{
			System.out.println("View Claim Details verified successfully");
			return true;	
		}
		else
		{
			int tot_i=remitsinfo.length;
			err.logcommonMethodError("ViewRemit", "the value "+remitsinfo[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
		
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectClaimNumber
	 * #Description: This functionality selects the claim number in the Cliam Number drop down in the Remits section.
	 * #Argument: claimnum
	 * Type: Dropdown
	 */
	public boolean selectClaimNumber(String[] claimnum)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownClaimNumber, claimnum[0], "ViewRemit", "Claim Number");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSearchButton
	 * #Description: This functionality performs click action on the Search button in the remits section.
	 * Type: Textbox
	 */
	public boolean clickSearchButton()
	{
		return utils.clickAnelemnt(this.btnSearch, "ViewRemit", "Search");
	}
	
	@FindBy(xpath="//div[@columnlist='.ServiceDates  ']")
	WebElement RemitResults;
	
	public boolean verifyRemitResultDisplayed()
	{
		return !utils.isProxyWebelement(RemitResults);
	}
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickTheRemitDate
	 * #Description: This functionality performs click action on the remit date given by the user in the remits section.
	 * #Argument: date
	 * Type: Textbox
	 */
	public boolean clickTheRemitDate(String[] date)
	{
		utils.waitforpageload();
		if(utils.isProxyWebelement(txtErrorMessage)) {
		for(WebElement e: this.lnkRemitDate){
			if(e.getText().equalsIgnoreCase(date[0])){
				return utils.clickAnelemnt(e, "ViewRemit", "Date");
			}else{
				continue;
			}
		}
		return false;
		}else {
			return utils.setDataIssue(txtErrorMessage.getText());
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSubmitButton
	 * #Description: This functionality performs click action on the Submit button in the remits section.
	 * Type: Textbox
	 */
	public boolean clickSubmitButton()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit, "ViewRemit", "Submit");

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyOnDemand
	 * #Description: This functionality verifies that the On Demand link is present or not in the View Remits page
	 * Type: Textbox
	 */
	public boolean verifyOnDemand()
	{
		return !utils.isProxyWebelement(lnkOnDemand);	
	}

	@FindBy(xpath="//label[contains(text(),'View Remit')]")
	WebElement headerViewRemit;
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigatedToOnDemandLink
	 * #Description: This functionality clicks on the On Demand link and then navigates to the child window and then gets the title and then navigates back to the Parent window.
	 * Type: Textbox
	 */
	public boolean navigatedToOnDemandLink() throws InterruptedException
	{
		String parent = Driver.pgDriver.getWindowHandle();
		System.out.println("Parent Window ID: "+parent);
		if(utils.validateHeader(this.headerViewRemit, "View Remit")){
			if(this.lnkOnDemand.isDisplayed())
			{
				utils.clickAnelemnt(this.lnkOnDemand, "ViewRemit", "OnDemand Link");
				System.out.println(("OnDemand Is Clicked.."));
				Thread.sleep(3000);
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				System.out.println("Parent & Child Window ID: "+handles);
				System.out.println("No.ofwindows"+handles.size());
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				String title = Driver.pgDriver.switchTo().window(childWindow).getTitle().trim();
				System.out.println("Title of the Child Window is: "+title);
				if(title.contains("IBM Content Navigator for On Demand"))
				{
					System.out.println("Clarity Is Launched and the title is: "+ title); 
					Driver.pgDriver.switchTo().window(parent);
					String title1 = Driver.pgDriver.getTitle();
					System.out.println("Title of the Parent Window is: "+title1);
					return true;
				}else
				{
				  err.logcommonMethodError("ViewRemit", "Error in switching to childwindow-Clarity");
				  return false;
				}
			}
			err.logcommonMethodError("ViewRemit", "OnDemand link is not displayed in - View Remit Card");
			return false;	
		}
		err.logcommonMethodError("ViewRemit", "View Remit is not loaded");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyErrorMessage
	 * #Description: This functionality verifies the error message displayed in the View Remit page when user searches for no remits data.
	 * Type: Textbox
	 */
	public boolean verifyErrorMessage()
	{
		String ErrorMsgFromUser = " Remit not found or service is unavailable. Use the OnDemand link to manually search for the remit";
		String ErrorMsgFromApplication = this.txtErrorMessage.getText();
		return utils.isvalueMatch_contain(ErrorMsgFromUser, ErrorMsgFromApplication);
		
	}


}
