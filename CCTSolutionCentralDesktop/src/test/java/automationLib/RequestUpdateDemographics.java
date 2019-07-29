package automationLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class RequestUpdateDemographics {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(),20);
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeader;
	
	public RequestUpdateDemographics() 
	{
		
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement BtnSubmit;
	
	@FindBy(xpath="//button[@data-test-id='2018021513581709047759']")
	WebElement BtnOK;
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:clickOnSubmit
	 * #Description: This method clicks on submit button in RequestUpdateDemographics page.
	 * Type:Textbox 
	 */
	public boolean clickOnSubmit()
	{
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(this.BtnSubmit, "RequestUpdateDemographics", "Button to click Submit"))
		wait.until(ExpectedConditions.visibilityOf(this.BtnOK));
		return utils.clickAnelemnt(this.BtnOK, "RequestUpdateDemographics", "Button to click OK");
	}
	
	@FindBy(id="SelectNextAction")
	WebElement NextActionDrpdown;
	
	@FindBy(id="AddressLine1")
	private WebElement AddressLine;
	
	@FindBy(id="pyCity")
	private WebElement CityValue;
	
	@FindBy(id="pyState")
	private WebElement StateDropdown;
	
	@FindBy(id="pyPostalCode")
	private WebElement ZipCodeValue;
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument:selectNextAction
	 * #Description:This method allows the user to select - Next action from dropdown	
	 * #Arguments:NextAction
	 * Type:Dropdown
	 * Keys:Update Clarity#
	 */
	public boolean selectNextAction(String args[])
	{
		return utils.selectDropDownbyVisibleString(this.NextActionDrpdown, args[0],"RequestUpdateDemographics", "Next Action");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument:addressOverride
	 * #Description:This method allows the enter mandatory address values to be overriden in RequestUpdateDemographics
	 * #Arguments:AdressDetails
	 * Type:Table
	 * Keys:Address#City#State#Zip Code
	 */
	public boolean addressOverride(String args[])
	{
		boolean returnvar =true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("addressOverride", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);
			
			if(key.contains("Address")){
					returnvar=true;
					utils.enterTextinAnelemnt(this.AddressLine, value, "UpdateDemographics", "Address Line 1");		
					continue;
				
			}else if(key.contains("City")){
				returnvar=true;

				utils.enterTextinAnelemnt(this.CityValue, value, "UpdateDemographics", "City");		
				continue;
			
			}else if(key.contains("State")){
			returnvar=true;
			utils.selectDropDownbyVisibleString(this.StateDropdown, value, "UpdateDemographics", "State");		
			continue;
		
			}else if(key.contains("Zip Code")){
				returnvar=true;
				utils.enterTextinAnelemnt(this.ZipCodeValue, value, "UpdateDemographics", "Zip Code");		
			continue;
			}else{
			err.logcommonMethodError("RequestUpdateDemographics", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
		    return false;
			}
		}
		return true;
	}
	
	@FindBy(xpath="//button[@data-test-id='2018021513581709047759']")
	WebElement btnOK;
	
	public boolean clickOkBtn()
	{
		return utils.clickAnelemnt(btnOK, "RequestUpdateDemographics", "OK");
	}
}
