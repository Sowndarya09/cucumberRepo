package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResolveRefundRequest {
	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	public ResolveRefundRequest()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	
	
	
	@FindBy(xpath="//select[@id='RACResponse']")
	WebElement RACTeamResponse;
	
	
	public boolean selectRACTeamResponse(String[] args)
	{
			return utils.selectDropDownbyVisibleString(RACTeamResponse, args[0], "ResolveRefundRequest", "RAC Team Response");	
	}
	
	@FindBy(xpath="//select[@id='ReasonForSending']")
	WebElement ReasonForSending ;
	
	
	
	public boolean selectReasonForSending(String[] args)
	{
			return utils.selectDropDownbyVisibleString(ReasonForSending, args[0], "ResolveRefundRequest", "Reason For Pending");	
	}
	
	@FindBy(xpath="//textarea[@id='Notes']")
	WebElement NotesTxtbox ;
	
	public boolean enterNotes(String[] notes)
	{
			return utils.enterTextinAnelemnt(this.NotesTxtbox, notes[0], "ResolveRefundRequest", "Notes textbox");
	}
	
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement Clicksubmit ;
	
	public boolean clickOnSubmit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(Clicksubmit, "ResolveClaimAdjustmentRequest", "Submit");

	}
	
	
	
	@FindBy(xpath="//table[@pl_prop='.BillingTeamNotesList']")
	WebElement tableActivityLog ;
	
	public boolean validateActivityLogTable(String[] values)
	{
		if(utils.validateRowValues(tableActivityLog, values))
			return true;
		else
			return false;

	}
	
	//Sprint 6.3 
	@FindBy(id="ReasonForSending")
	WebElement  pmtTypeCheckWrite;
	
	@FindBy(id="ReasonForSending")
	WebElement  pmtTypeWGS;
	
	
	/**
	 * This method verifies the pmt type checkwrite values is not displayed in the reason for sending
	 * @return
	 */
	 
	public boolean verifypmtTypeCheckWriteIsNotDisplayedInReasonForSending(){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Pmt Type CheckWrite");

		if(utils.checkvaluesinDropDown(pmtTypeCheckWrite,arr))
			return false;
		else
			return true;
	}

	/**
	 * This method verifies the pmt type WGS values is not displayed in the reason for sending
	 * @return
	 */
	public boolean verifypmtTypeWGSIsNotDisplayedInReasonForSending(){

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("pmt Type WGS");

		if(utils.checkvaluesinDropDown(pmtTypeWGS,arr))
			return false;
		else
			return true;
	}	



}



