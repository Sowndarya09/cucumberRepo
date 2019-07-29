package automationLib;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.MainframeUtilities;
import utils.SeleniumUtilities;

public class MF_MemberAddressEnquiry {
	
	public  MF_MemberAddressEnquiry(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	}
	
	
	SeleniumUtilities utils = new SeleniumUtilities();
	MainframeUtilities mf=new MainframeUtilities();
	Actions action=new Actions(Driver.pgDriver);
	
	public WebElement id;
	
	//@FindBy(xpath = "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]/div[14]/span")
	@FindBy(xpath="//div[@class='screen']//div[14]/span")
	List<WebElement> NameValue;
	
	//@FindBy(xpath = "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]/div[12]/span")
	@FindBy(xpath="//div[@class='screen']//div[12]/span")
	List<WebElement> AddressValue;
	
	//@FindBy(xpath = "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]/div[13]/span")
	@FindBy(xpath="//div[@class='screen']//div[13]/span")
	List<WebElement> CityValue;
	
	public String getPagelevelXpath(){
		//return "//*[@id='zfe']/div[3]/div/div[2]/div[4]/div/div[1]/div/div[1]/div/div[3]";
		return "div[@class='screen']";
	}
	
	public WebElement id(){

		id= mf.getWebElement("3", "47");
		return id;
	}
	
	public boolean enterMemberID(String[] args) throws InterruptedException {
		//Thread.sleep(5000);
		mf.enterText(this.id(), args[0] +Keys.ENTER);
		return true;
	}
	
	public boolean validateAddress(String[] args) throws InterruptedException {
		//Thread.sleep(10000);
		String careof = mf.retrieveTextwithlength(NameValue, 6, 11);
		String address = mf.retrieveTextwithlength(AddressValue, 6, 11);
		String city = mf.retrieveTextwithlength(CityValue, 6, 11);
		System.out.println("Care OF"+careof);
		System.out.println("Address"+address);
		System.out.println("City"+city);
		
		boolean returnvar =true;
		
		for(String iterator : args)
		{
			if(!returnvar)
			{
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.contains("In Care Of")){			
				returnvar=utils.isvalueMatch_contain(careof,value);				
				continue;

			}else if(key.contains("Address")){
				returnvar=utils.isvalueMatch_contain(address,value);		
				continue;

			}else if(key.contains("City")){
				returnvar=	utils.isvalueMatch_contain(city,value);	
				continue;
			}else{
				return false;
			}
		}
		
		return returnvar;
	}

}
