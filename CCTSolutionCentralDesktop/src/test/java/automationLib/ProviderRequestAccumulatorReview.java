
package automationLib;

import java.io.IOException;

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


public class ProviderRequestAccumulatorReview {

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(xpath="addHyperlink")
	private WebElement addLink;

	@FindBy(xpath="addAccumulatorDropdown")
	private WebElement addAccDrpdown;

	@FindBy(id="ReasonForReview")
	private WebElement reviewReason;

	@FindBy(xpath="nextActionDropdown")
	private WebElement nextAction;

	@FindBy(xpath="urgentRequestCheckbox")
	private WebElement urgentRequest;

	@FindBy(xpath="RequestExceptionReviewRadio")
	private WebElement reqExceptionReview;

	@FindBy(xpath="UrgentReasonDropdown")
	private WebElement urgentReason;

	@FindBy(xpath="//div[@node_name='RequestAccumulatorAdjustmentOptions']//textarea[@id='pyNote']")
	private WebElement notes;


	public WebElement getAddLink() {
		return addLink;
	}

	public WebElement getAddAccDrpdown() {
		return addAccDrpdown;
	}

	public WebElement getReviewReason() {
		return reviewReason;
	}

	public WebElement getNextAction() {
		return nextAction;
	}

	public WebElement getUrgentRequest() {
		return urgentRequest;
	}

	public WebElement getReqExceptionReview() {
		return reqExceptionReview;
	}

	public WebElement getUrgentReason() {
		return urgentReason;
	}

	public WebElement getNotes() {
		return notes;
	}


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	/**
	 * Constructor for the RequestAccumulatorReview class defining the Iframe and the Page Factory  
	 */
	public ProviderRequestAccumulatorReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:addAccumulatorAdjustment
	 * #Arguments:Textbox
	 * Description:Select the Accumulators for Adjustment
	 */
	public boolean addAccumulatorAdjustment(String[] args){
		if(utils.clickAnelemnt(this.getAddLink(), "RequestAccumulatorReview", "Add"))
			return utils.selectDropDownbyVisibleString(this.getAddAccDrpdown(), args[0], "RequestAccumulatorReview", "Add Accumulator");
		return false;
	} 


	/*
	 * @SCU
	 * #CommonMethodwithArgument:submitStandardAccumAdjustment
	 * #Arguments:reviewreason, nextaction and notes
	 * Type:Text
	 * Description:Enter mandatory fields(Reason for review and notes), Select Next action-Send for Adjustment, Urgent- Unchecked, Exception - NO
	 */
	public boolean submitStandardAccumAdjustment(String[] args){
		if(utils.selectDropDownbyVisibleString(this.getReviewReason(), args[0], "Request Accumulator Review", "Reason for Review"))
			if(utils.selectDropDownbyVisibleString(this.getNextAction(), args[1], "Request Accumulator Review", "Next action"))
				if(utils.clickAnelemnt(this.getReqExceptionReview(), "Request Accumulator Review", "Request Exception review"))
					return utils.enterTextinAnelemnt(this.getNotes(),args[1], "Request Accumulator Review ", "Notes Section");
		return false;

	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:submitUrgentAccumAdjustment
	 * #Arguments:reviewreason, nextaction, urgentreason and notes
	 * Type:Text
	 * Description:Enter mandatory fields(Reason for review and notes), Select Next action-Send for Adjustment, Urgent- Checked, Reason-Any value, Exception - NO
	 */
	public boolean submitUrgentAccumAdjustment(String[] args){
		if(utils.selectDropDownbyVisibleString(this.getReviewReason(), args[0], "Request Accumulator Review", "Reason for Review"))
			if(utils.selectDropDownbyVisibleString(this.getNextAction(), args[1], "Request Accumulator Review", "Next action"))
				if(utils.clickAnelemnt(this.getUrgentRequest(), "Request Accumulator Review", "Urgent request checkbox"))
					if(utils.clickAnelemnt(this.getReqExceptionReview(), "Request Accumulator Review", "Request Exception review"))
						if(utils.selectDropDownbyVisibleString(this.getUrgentReason(), args[2], "Request Accumulator Review", "Urgent Reason"))
							return utils.enterTextinAnelemnt(this.getNotes(),args[3], "Request Accumulator Review ", "Notes Section");
		return false;

	}

	@FindBy(xpath="//div[@node_name='RequestAccumulatorsAdjustmentwrapper']//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	public boolean selectValuesInReasonforReview()
	{
		return utils.selectDropDownbyVisibleString(this.reviewReason, "Accumulator Credit Transfer (policy to policy)", "RequestAccumulatorReview", "Reason for Review");
	}

	public boolean enterNotes()
	{
		return utils.enterTextinAnelemnt(this.notes, "Notes Entered", "RequestAccumulatorReview", "Notes");
	}

	public boolean clickBtnSubmit()
	{
		WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@node_name='RequestAccumulatorsAdjustmentwrapper']//div[contains(text(),'Submit')]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(this.btnSubmit, "RequestAccumulatorReview", "Submit");
	}

	public boolean SubmitInRequestAccumulatorsReview()
	{
		if(selectValuesInReasonforReview())
			if(enterNotes())
				return clickBtnSubmit();
		return false;
	}

	/**
	 * Selects values in Reason for Review drop down by getting the input from the user
	 * @param args
	 * @return
	 */
	public boolean selectValuesInReasonforReview(String[] args)
	{
		return utils.selectDropDownbyVisibleString(this.reviewReason,  args[0], "RequestAccumulatorReview", "Reason for Review");
	}

}



