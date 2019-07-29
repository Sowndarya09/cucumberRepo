package automationLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class GuestInformation extends Driver{
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	public GuestInformation()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy (xpath="//div[@node_name='HCGuestComposite']//span[@role='heading'][contains(text(),'Guest Information')]")	
	private WebElement headerForThePage;

	@FindBy(xpath="//div[@node_name='HCGuestComposite']//label[@for='pyFirstName']/parent::div//span")
	WebElement labelGuestCompositeFirstName;


	@FindBy(xpath="//div[@node_name='HCGuestComposite']//label[@for='pyLastName']/parent::div//span")
	WebElement labelGuestCompositeLastName;


	@FindBy(xpath="//div[@node_name='HCGuestComposite']//label[@for='GuestPhoneNumber']/parent::div//span")
	WebElement labelGuestCompositePhone;


	@FindBy(xpath="//div[@node_name='HCGuestComposite']//label[@for='GroupName']/parent::div//span")
	WebElement labelGuestCompositeGroupName;

	@FindBy(xpath="//div[@node_name='HCGuestComposite']//label[@for='GroupNumber']/parent::div//span")
	WebElement labelGuestCompositeGroupNumber;

	@FindBy(xpath="//div[@node_name='HCGuestComposite']//label[@for='DateOfBirth']/parent::div//span")
	WebElement labelGuestCompositeDateofBirth;

	@FindBy(xpath="//div[@node_name='HCGuestComposite']//label[@for='GuestSSN']/parent::div//span")
	WebElement labelGuestCompositeSSN;


	public boolean validateGuestComposite(String[] details)
	{
		boolean returnvar ;
		returnvar = true;

		String keyvaluepair="";
		for(String iterator : details)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("Guest Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("first")){
				returnvar = this.labelGuestCompositeFirstName.getText().toLowerCase().contains(value);
				continue;}
			else if(key.toLowerCase().contains("last")){
				returnvar = this.labelGuestCompositeLastName.getText().toLowerCase().contains(value);
				continue;}

			else if(key.toLowerCase().contains("phone")){
				returnvar = this.labelGuestCompositePhone.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("groupname")){
				returnvar = this.labelGuestCompositeGroupName.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("groupnumber")){
				returnvar = this.labelGuestCompositeGroupNumber.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("dob")){
				returnvar = this.labelGuestCompositeDateofBirth.getText().toLowerCase().contains(value);
				continue;
			}
			else if(key.toLowerCase().contains("ssn")){
				returnvar = this.labelGuestCompositeSSN.getText().toLowerCase().contains(value);
				continue;
			}


			else 
				err.logcommonMethodError("Guest Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}



		if(returnvar)
		{
			System.out.println("Guest Composite genral info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=details.length;
			err.logcommonMethodError("Guest Composite", "the value "+details[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")	
	private WebElement btnAddTAsk;

	public WebElement getbtnAddTAsk()
	{
		return btnAddTAsk;
	}

	public boolean clickbtnAddTask()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");

	}
	@FindBy(xpath="//*[contains(@id,'CPMTaskSearchInput')][1]")
	private WebElement SearchInput;

	public WebElement getchkbxSEacrchInput()
	{
		return SearchInput;
	}

	public boolean setTxtFullContactName(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getchkbxSEacrchInput(), sFullName, "Member Composite", "Application took a long time to load");
	}

	@FindBy(id="po0")
	private WebElement addTaskMenu;

	@FindBy(xpath="//*[@data-test-id='20150527044600067319555' or contains(text(), 'Add task(s)')]")
	private WebElement lnkClickonAddTaskInDropdown;

	public boolean clicklnkClickonLinkafterSettingValue(String args) throws InterruptedException
	{
		boolean flag=false;
		try 
		{
			utils.waitforpageload();
			List<WebElement> allOptions = addTaskMenu.findElements(By.xpath("//a[@data-test-id='2014123005242607302524']"));
			for ( int i=0;i<=allOptions.size();i++) {
				if(allOptions.get(i).getText().contains(args)){
					allOptions.get(i).click();
					Actions action = new Actions(pgDriver);
					action.moveToElement(lnkClickonAddTaskInDropdown);
					JavascriptExecutor executor = (JavascriptExecutor)pgDriver;
					executor.executeScript("arguments[0].click();", lnkClickonAddTaskInDropdown);
					flag=true;
					break;
				}
			}

			if(flag==true) {
				blogger.loginfo(args+" is displayed and Add task is clicked. Navigating to the section");
				return true;
			}else {
				blogger.loginfo(args+" is not displayed");
				err.logError("MemberComposite", "lnkClickonAddTaskInDropdown");
				return false;
			}
		}
		catch(StaleElementReferenceException e )
		{
			blogger.loginfo("Exception: "+e);
			err.logError("StaleElementReferenceException", "lnkClickonAddTaskInDropdown");
			return false;
		}

	}

	public boolean  navigateTOProvider() throws InterruptedException
	{
		Thread.sleep(2000);
		utils.waitforpageload();
		if(this.clickbtnAddTask())
		{
			if(setTxtFullContactName("Provider"))
			{
				if(this.clicklnkClickonLinkafterSettingValue("Provider"))
				{
					blogger.loginfo("Pass : The Value is Provider is entered in the text Field and is navigateed to the required page ");
					return true; 
				}
			}
		}
		blogger.loginfo("Fail : There is some error with naviagted value");
		return false; 

	}  

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Wrap Up']")
	WebElement btnMbrCompositeWrapup;

	public boolean clickwrapUp() throws InterruptedException
	{
		Thread.sleep(1000);
		utils.waitforpageload();
		return utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");
	} 

}
