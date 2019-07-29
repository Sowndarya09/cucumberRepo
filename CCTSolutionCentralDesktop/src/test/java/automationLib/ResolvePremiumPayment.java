package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResolvePremiumPayment{

	SeleniumUtilities utils = new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(), 20);
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

public ResolvePremiumPayment() throws IOException
{
	PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	if(!utils.checkIfErrorPage())
	{
		utils.refreshthepage();
	}
	Driver.getPgDriver().switchTo().defaultContent();
	Driver.getPgDriver().switchTo().frame(this.Iframeelement);

}

@FindBy(id="PremiumPaymentTeamResponse")
private WebElement drpPremiumPaymentTeamResponse;

@FindBy(id="pyNote")
private WebElement epyNote;


@FindBy(xpath="//div[contains(text(),'Submit')]")
private WebElement btnSubmit;


 public boolean PremiumPaymentReportTeamResponse(String[] paymentreporttype) 
 {		
	return utils.selectDropDownbyVisibleString(this.drpPremiumPaymentTeamResponse, paymentreporttype[0], "PremiumPaymentReport", "Reason For Contact");
 }
 

 
 public boolean enterNotes(String args[])
 {		
	return 	utils.enterTextinAnelemnt(this.epyNote, args[0], "RequestClaimsMedicalReview", "Notes textarea");
 }

	
public boolean clickSubmitBtn()
{
	return 	utils.clickAnelemnt(this.btnSubmit, "PremiumPaymentReport", "Submit");
}
}


