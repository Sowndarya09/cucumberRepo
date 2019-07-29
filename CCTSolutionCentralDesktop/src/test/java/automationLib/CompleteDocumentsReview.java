package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CompleteDocumentsReview {
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(xpath="//select[@id='ReasonForContact']")
	WebElement drpdwnReasonforContact;
	
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Submit']")	
	private WebElement btnSubmit;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	public CompleteDocumentsReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	
	public boolean checkReasonforContact(String[] value)
	{
		utils.waitForElementToBeVisible(drpdwnReasonforContact);
		return utils.selectDropDownbyVisibleString(this.drpdwnReasonforContact, value[0], "CompleteDocuemntsReview", "Reason for Contract Drop Down Button");
	}
	
	public boolean ClickonSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "CompleteDocuemntsReview", "Submit Button");
	}
	
	
//	@FindBy(xpath="//table[@pl_prop='.EOCTrackerList']")
	@FindBy(xpath="//table[@pl_prop='.AccessDocuments.RevenueCodeDetails']")
	WebElement tblxyz;
	public boolean validateEOCRequestMmadeDuringAccessDocumentsSection(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(tblxyz,tablevalues);
	}
}
