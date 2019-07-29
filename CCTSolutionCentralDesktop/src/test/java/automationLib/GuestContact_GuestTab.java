package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class GuestContact_GuestTab {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	Actions action=new Actions(Driver.pgDriver);
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	public GuestContact_GuestTab()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}


	@FindBy(xpath="//span[@data-test-id='201509091044460746122670']")
	WebElement labelGuestContactFirstName;

	@FindBy(xpath="//span[@data-test-id='201509091044460746123799']")
	WebElement labelGuestContactLastName;

	@FindBy(xpath="//span[@data-test-id='201509091044460747124675']")
	WebElement labelGuestContactPhoneNumber;
	
	@FindBy(xpath="//span[@data-test-id='201509091143420807448358']")
	WebElement labelGuestContactSSN;
	

	public boolean verifyGuestContactInformation(String[] guestdetails) throws Exception
	{
		boolean returnvar ;
		returnvar = true;
		utils.waitforpageload();

			for(String iterator : guestdetails)
			{
				String keyvaluepair = iterator;
				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
				if(utils.isvalueMatch_contain(key.toLowerCase(),"first")){
					returnvar = utils.validateLabel(labelGuestContactFirstName,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"last")){
					returnvar = utils.validateLabel(labelGuestContactLastName,value);
					continue;}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"phonenumber")){
					returnvar = utils.validateLabel(labelGuestContactPhoneNumber,value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key.toLowerCase(),"ssn")){
					returnvar = utils.validateLabel(labelGuestContactSSN,value);
					continue;
				}

				else 
					err.logcommonMethodError("GuestContact_GuestTab", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;

			}

		if(returnvar)
		{
			System.out.println("Group management info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=guestdetails.length;
			err.logcommonMethodError("GuestContact_GuestTab", "the value "+guestdetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}


}
