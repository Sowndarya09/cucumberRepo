package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderCompleteManageIDCardReview extends Driver{
	
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();

	public ProviderCompleteManageIDCardReview()
	{
		
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		//PageFactory.initElements(Driver.getPgDriver(), this);
		System.out.println("ProviderCompleteManageIDCardReview constructor");
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		System.out.println("ProviderCompleteManageIDCardReview frame sithced");
	}

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//label[contains(text(),'Complete Manage ID Card Review')]")
	WebElement headerCompleteManageIdCard;
	
	@FindBy(id="Notes")
	WebElement txtBoxNotes;
	
	@FindBy(id="ReasonForRequest")
	WebElement droprDownReasonForRequest;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	
	
	
	public boolean verifyHeaderForCompleteManageIDCardReview(){	
		return utils.validateHeader(this.headerCompleteManageIdCard, "Manage ID Card");		
	}	
	
	public boolean setNotes(){		
		return utils.enterTextinAnelemnt(this.txtBoxNotes, "Manage ID Card","Manage ID Card Review","Radio button for select All");		
	}
	
	public boolean selectReasonForContactRequestIDCard(){		
		return utils.selectDropDownbyVisibleString(this.droprDownReasonForRequest, "Request ID Card","Manage ID Card Review","drop down FullfillmentMethod");		
	}
	
	public boolean clickSubmit(){		
		return utils.clickAnelemnt(this.btnSubmit, "Manage ID Card review"," button for Submit");		
	}
	
	
	
	
	public boolean createManageIDCardReviewAndSubmit(){
		waitforpageload();
		if(this.verifyHeaderForCompleteManageIDCardReview())
			waitforpageload();
				if (this.selectReasonForContactRequestIDCard())
					waitforpageload();
					if(this.setNotes())	{
						waitforpageload();
						return this.clickSubmit();		
					}						
		return false;			
	}
	
	
	
	
	
	public boolean waitforpageload()
	{		
			try{
				Thread.sleep(3000);
				System.out.println("Checking for Loading Icon");
				wait=new WebDriverWait(Driver.getPgDriver(),100);
				System.out.println("Checkingggg"+System.currentTimeMillis());
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
				System.out.println("Checkingggg"+System.currentTimeMillis());
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
				System.out.println("Checkingggg"+System.currentTimeMillis());
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));					
			}
			catch(Exception e){
				System.out.println("No loading icon. Continue " +e);
			}
			System.out.println("Came out");
			return true;
	}
	
	
	
	
}




