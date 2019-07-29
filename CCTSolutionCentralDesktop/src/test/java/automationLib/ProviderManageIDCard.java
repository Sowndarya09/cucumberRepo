package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderManageIDCard extends Driver{



	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();

	public ProviderManageIDCard()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;	

	@FindBy(xpath="//label[contains(text(),'Manage ID Card')]")
	WebElement headerManageIdCard;

	@FindBy(id="IsSelected")
	WebElement chkBoxSelectAll;

	@FindBy(id="FulfillmentMethod")
	WebElement droprDownFullfillment;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="//div[contains(text(),'Order Id card(s)')]")
	private WebElement btnorderIDCardSumbit;

	public boolean verifyHeaderForManageIDCard(){		

		return utils.validateHeader(this.headerManageIdCard, "Manage ID Card");

	}	

	public boolean clickSelectAll(){		

		return utils.clickAnelemnt(this.chkBoxSelectAll, "Manage ID Card","Radio button for select All");

	}

	public boolean clickOrderIDCard(){		

		return utils.clickAnelemnt(this.btnorderIDCardSumbit, "Manage ID Card"," button for OrderID");

	}

	public boolean selectMailFromFullfillmentMethod(){		

		return utils.selectDropDownbyVisibleString(this.droprDownFullfillment, "Mail","Manage ID Card","drop down FullfillmentMethod");

	}

	public boolean clickSubmit(){		

		return utils.clickAnelemnt(this.btnSubmit, "Manage ID Card"," button for Submit");

	}

	public boolean createManageIDCardSubmit(){

		utils.waitforpageload();
		if(this.verifyHeaderForManageIDCard())
			if (this.clickSelectAll()) {
				utils.waitforpageload();
				if(this.selectMailFromFullfillmentMethod())	{
					utils.waitforpageload();
					if(this.clickOrderIDCard()) {
						utils.waitforpageload();
						utils.scrolltomiddle();
						return this.clickSubmit();		
					}						
				}
			}
		return false;			
	}
}













