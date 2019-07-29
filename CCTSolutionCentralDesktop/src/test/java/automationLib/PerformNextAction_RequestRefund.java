package automationLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class PerformNextAction_RequestRefund {
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	ErrorLogger err = new ErrorLogger();
	WebDriverWait wait;

	public PerformNextAction_RequestRefund()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		utils.gotoLastIframe(iframes);
	}

	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;
	
	@FindBy(id="IsDependentSR")
	WebElement DependencyChkBox;
	
	@FindBy(id="SelectDependentSR")
	WebElement SelectDependent;
	
	@FindBy(xpath="//button[@data-test-id='20170430123625027137382']")
	WebElement Refresh;
	
	@FindBy(xpath="//button[@data-test-id='2019040517203608417519']")
	WebElement SubmitButton;
	
	@FindBy(id="ReasonForContact")
	WebElement ResonForContact;
	
	@FindBy(xpath="//span[text()='Request Refund']")
	WebElement RequestClaimsRefundRecovery;
	
	
	public boolean expandRequestClaimsRefundRecovery(){
		utils.waitforpageload();
		if(utils.clickAnelemnt(RequestClaimsRefundRecovery, "PerformNextAction_RequestRefund", "RequestAdjustment"))
		return !utils.isProxyWebelement(DependencyChkBox);
		return false;
	}
	
	public boolean selectDependencyTaskCheckbox(){
		if(utils.clickAnelemnt(DependencyChkBox, "PerformNextAction_RequestRefund", "DependencyChkBox"))
			return true;
		return false;
	}
	
	public boolean validatePrimaryTaskIsDisplayed(){
		return !(utils.isProxyWebelement(SelectDependent));
	}
	
	@FindBy(xpath="//button[@title='RefreshPrimaryTaskDropDown']")
	WebElement Hover;
	
	public boolean validateRefreshButtonHover(){
		String Expected="RefreshPrimaryTaskDropDown";
		//String actual=utils.hoverOverElementAndGetText(Refresh, Hover);
		//return utils.isvalueMatch_compareto(actual, Expected);	
		
		action.moveToElement(Refresh).perform();
		String actual = Hover.getAttribute("title");
		System.out.println(actual);
		return utils.isvalueMatch_compareto(actual, Expected);	
		
	}
	
	public boolean clickSubmit() {
		utils.scrolltomiddle();
		return utils.clickAnelemnt(SubmitButton, "PerformNextAction_RequestRefund", "SubmitButton");
	}
	
	public boolean clickSubmitAndValidateAlert() {
		utils.scrolltomiddle();
		if(utils.clickAnelemnt(SubmitButton, "PerformNextAction_RequestRefund", "SubmitButton")){
			if (utils.isAlertPresent())
		Driver.pgDriver.switchTo().defaultContent();
			return true;
			}
		return false;
	}
	
	public boolean verifyDependencyTaskErrorMessage(){
		Alert alert=Driver.pgDriver.switchTo().alert();
		String Actual=alert.getText();
		String Expected="Please correct flagged fields before submitting the form!";
		return utils.isvalueMatch_compareto(Actual, Expected);
	}
	
	public boolean selectReasonForContact(String[] args){
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(this.ResonForContact, args[0], "PerformNextAction_RequestRefund", "Reason for Contact");
	
	}
	
	@FindBy (xpath="//input[@id='CheckClearedNo']")	
	private WebElement HasTheCheckClearedNo;

	@FindBy (xpath="//input[@id='CheckClearedYes']")	
	private WebElement HasTheCheckClearedYes;
	
	public boolean selectCheckClearedRadioButton(String[] args){
		if(args[0].equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(HasTheCheckClearedYes,"PerformNextAction_RequestRefund", "HasTheCheckCleared Yes");
		else
			return utils.clickAnelemnt(HasTheCheckClearedNo,"PerformNextAction_RequestRefund", "HasTheCheckCleared No");
	}
	
	@FindBy(xpath="//*[@data-test-id='201809241239240178206501']")
	WebElement InstructionalText;
	
	public boolean verifyCheckClearanceErrorMessage(){
		String Expected="";
		System.out.println(InstructionalText.getText());
		return utils.validateLabel(InstructionalText, Expected);
	}
	
	public boolean verifyReasonForContactDropdownValues(){
		String[] drpDown = {"Select","Disputed Refund","Inquired on Refund","Requested Refund"};
		ArrayList<String> al = new ArrayList<String>();
		for(String arg : drpDown)
		{
			al.add(arg);
		}	
		wait=new WebDriverWait(Driver.pgDriver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$pRefundRequest$pReasonForContact"))); 
		return utils.checkvaluesinDropDown(ResonForContact, al);
	}
	
	public boolean verifyRequestedActionDropdownValues(){
		String[] drpDown = {"Select..","Claims Paid in Error or Non-Covered Services Were Paid","Medicare/Coordination of Benefits (COB) and Claim Paid Out of Order","Corrected/Resubmitted Claims Received or Claims Billed in Error","Dispute Previous Refund Request","Duplicate Payments","Inquire on Previous Refund Request","Members Cost Share Incorrectly Applied","Paid Wrong Provider","Pricing Errors","Re-Adjust Previous Refund Request","Other"};	
		ArrayList<String> al = new ArrayList<String>();
		for(String arg : drpDown)
		{
			al.add(arg);
		}	
		wait=new WebDriverWait(Driver.pgDriver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$pRefundRequest$pRequestedAction"))); 
		return utils.checkvaluesinDropDown(RequestedAction, al);
	}
	
	@FindBy(name="$PpyWorkPage$pRefundRequest$pRequestedAction")
	private WebElement RequestedAction;
	
	public boolean selectRequestedAction(String[] args){
			return utils.selectDropDownbyVisibleString(RequestedAction, args[0], "PerformNextAction_RequestRefund", "Requested Action");   	
	}
	
	@FindBy (xpath="//span[text()='Is this for a Full or Partial Refund?']")	
	private WebElement IsThisForAFullOrPartialRefund;

	@FindBy (xpath="//input[@id='FullPartialRefundFull']")	
	private WebElement FullRefund;
	
	@FindBy (xpath="//input[@id='FullPartialRefundPartial']")	
	private WebElement PartialRefund;
	
	public boolean selectFullOrPartialRefund(String[] args) throws InterruptedException{
		Thread.sleep(3000);
		utils.scrolltomiddle();
		System.out.println("Entered");
		/*WebElement element = FullRefund;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);*/
		if(args[0].contains("Full")){
			return utils.clickAnelemnt(FullRefund, "PerformNextAction_RequestRefund", "Full Radio Btn");
		}
		else if(args[0].contains("Partial")){
			return utils.clickAnelemnt(PartialRefund, "PerformNextAction_RequestRefund", "Partial Radio Btn");
		}
		else{
			System.out.println("Enter valid value to Select Refund Type");
			return false;
		}
	}
	
	@FindBy (xpath="//table[@pl_prop='.RefundRequestedClaims']")
	private WebElement ItemsReviewed;
	
	public boolean validateItemsReviewedDuringRefundRequest(String[] args){
		return utils.validatetablerowbasedonvalues(ItemsReviewed, args);
	}
	
	@FindBy(xpath="//h3[text()='Claim Details']")
	WebElement labelValidationMsg;
	
	public boolean verifyClaimDetailsIsOpened(String[] args) throws InterruptedException
	{   
			
			String parentWindow=Driver.pgDriver.getWindowHandle();
		    System.out.println(parentWindow);
			utils.waitforpageload();
			WebElement Clno=Driver.pgDriver.findElement(By.xpath("//a[text()='"+args[0]+"']"));
			utils.clickAnelemnt(Clno,"PerformNextAction_RequestRefund", "Link");
			utils.waitForChildWindowToBeVisible(0);
			Set<String> childWindow = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+childWindow.size());
			Iterator<String> iterator= childWindow.iterator();
			String parentWindow1 = iterator.next();
			String childWindow1 = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow1);
			String title = Driver.pgDriver.getTitle();
			System.out.println("Title of the Child Window is: "+title);
			if(title.contains("View Claim Details"))
			{
				System.out.println("View Claim Details launched and the title is: "+ title); 
				action.moveToElement(labelValidationMsg).perform();
				String actualMsg = labelValidationMsg.getText();
				String expectedMsg = "Claim Details";
				if(actualMsg.contains(expectedMsg))
				{
					blogger.loginfo("Validation was successful");
					System.out.println("Validation was successful");
					return true;
				}	
			}
			return false;
			
		}


}
