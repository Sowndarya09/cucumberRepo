package automationLib;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResolveGrievanceAndAppeals {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;
	
	@FindBy(xpath="//label[contains(text(),'Resolve Grievance and Appeals')]")
	private WebElement resolveGALbl;
	
	@FindBy(xpath="//label[contains(text(),'Was the dissatisfaction')]")
	private WebElement dissatisfactionLbl;
	
	@FindBy(xpath="//label[contains(text(),'Was the dissatisfaction related to')]")
	private WebElement dissatisfactionrelatedToLbl;
	
	@FindBy(xpath="//label[contains(text(),'Response')]")
	private WebElement responseLbl;
	
	@FindBy(id="nextAction")
	private WebElement nextActionDrpdown;
	
	@FindBy(xpath="//label[contains(text(),'Notes')]")
	private WebElement notesLbl;
	
	@FindBy(xpath="//label[contains(text(),'Notes')]//span")
	private WebElement notesTxtBox;
	
	@FindBy(xpath="//label[contains(text(),'unableToResolveTxt')]//span")
	private WebElement unableToResolveTxt;
	
	@FindBy(xpath="//label[contains(text(),'Grievance and Appeals Review')]")
	private WebElement GAReviewLbl;
	
	@FindBy(xpath="//table[@prop='Grievance and Appeals Review']")
	private WebElement GAReviewTbl;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	
	public ResolveGrievanceAndAppeals(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyResolveGrievanceAndAppealsPage
	 * #Description:To verify user is navigated to "Resolve Grievance And Appeals" page and its relevant sections are displayed.
	 * Type:Textbox
	 */
	public boolean verifyResolveGrievanceAndAppealsPage(){
		//ResolveBillingActions
		if(utils.validateHeader(this.resolveGALbl, "Resolve Billing Actions")){
		System.out.println("ResolveBillingActions - Resolve Billing Actions page is displayed");
		}else{
		err.logcommonMethodError("ResolveBillingActions", "Resolve Billing Actions page is not loaded");
		return false;}
		
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		try{
			if(this.dissatisfactionLbl.isDisplayed()){System.out.println("'Was the Dissatisfaction' label is displayed");}
		}catch(Exception e){
			err.logError("ResolveGrievanceAndAppeals", "'Was the Dissatisfaction' label is not displayed");
			System.out.println("Exception occured:'Was the Dissatisfaction' label is not displayed"+e);
			fieldsNotPresent.add("Was the Dissatisfaction");
		}
		
		try{
			if(this.dissatisfactionrelatedToLbl.isDisplayed()){System.out.println("'Was the Dissatisfaction Related To' label is displayed");}
		}catch(Exception e){
			err.logError("ResolveGrievanceAndAppeals", "'Was the Dissatisfaction Related To' label is not displayed");
			System.out.println("Exception occured:'Was the Dissatisfaction Related To' label is not displayed"+e);
			fieldsNotPresent.add("Was the Dissatisfaction Related To");
		}
		
		try{
			if(this.responseLbl.isDisplayed()){System.out.println("'Response' label is displayed");}
		}catch(Exception e){
			err.logError("ResolveGrievanceAndAppeals", "'Response' label is not displayed");
			System.out.println("Exception occured:'Response' label is not displayed"+e);
			fieldsNotPresent.add("Response");
		}
		
		try{
			if(this.notesLbl.isDisplayed()){System.out.println("'Notes' label is displayed");}
		}catch(Exception e){
			err.logError("ResolveGrievanceAndAppeals", "'Notes' label is not displayed");
			System.out.println("Exception occured:'Notes' label is not displayed"+e);
			fieldsNotPresent.add("Notes");
		}
		
		try{
			if(this.GAReviewLbl.isDisplayed()){System.out.println("'Grievance and Appeals Review' label is displayed");}
		}catch(Exception e){
			err.logError("ResolveGrievanceAndAppeals", "'Grievance and Appeals Review' label is not displayed");
			System.out.println("Exception occured:'Grievance and Appeals Review' label is not displayed"+e);
			fieldsNotPresent.add("Grievance and Appeals Review");
		}
		
		if(fieldsNotPresent.size()>0){
			System.out.println("Fields not present in 'Resolve Grievance and Appeals' page"+fieldsNotPresent);
			return false;
		}
		return true;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectNextAction
	 * #Description:This method selects 'Next Action' dropdown in 'Resolve Grievance And Appeals' page. 
	 * #Arguments:selectNextAction
	 * Type:Dropdown
	 * Keys:Resolved Request#Unable to Resolve Request
	 */
	public boolean selectNextAction(String[] args) throws InterruptedException{
		String msg="If you are not able to close the service request by the end of the day the next business day – In your service request in the \"Select Next Action\" dropdown select \"Unable to Resolve Request\" and click submit.  Log into CCB and open in IQT and go to the G & A Routing Work Path for instructions for routing as a Standard Grievance."; 
			if(utils.selectDropDownbyVisibleString(this.nextActionDrpdown, args[0],"ResolveGrievanceAndAppeals", "Select Next Action"))
			if(args[0].equalsIgnoreCase("Resolved Request"))
				return !utils.isProxyWebelement(notesTxtBox);
			else if(utils.isvalueMatch_contain(args[0], "Unable to Resolve Request"))
				if(utils.isvalueMatch_contain(unableToResolveTxt.getText(), msg))
					return true;
		return false;
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateGrievanceAndAppealsReviewInfo
	 * #Description:This method validates a particular 'Review Grievance And Appeals Info', depending on the parameters passed for selection. 
	 * #Arguments:GrievanceAndAppealsReview-KeyValuePair
	 * Type:Table
	 * Keys:Create Date#Created By#Notes#Activity
	 */
	public boolean validateGrievanceAndAppealsReviewInfo(String[] args) throws InterruptedException{
		if(utils.clickAnelemnt(this.GAReviewLbl, "ResolveGrievanceAndAppeals", "Grievance and Appeals Review"))
			if(utils.clickontablerowbasedonvalues(this.GAReviewTbl,args))
				return true;
		else
			return false;
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateSelectNextActionDrpdown
	 * #Description:This method validates the dropdown values displayed for 'Select Next Action' on 'Resolve Grievance And Appeals' page.
	 * Type:TextBox
	 */
	public boolean validateSelectNextActionDrpdown(){
		String action[] = {"Resolved Request","Unable to Resolve Request"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(action));
		if(utils.checkvaluesinDropDown(this.nextActionDrpdown,al))
			return true;
		else
			return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmitInResolveGA
	 * #Description:This method clicks on submit button in 'Resolve Grievance And Appeals' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmitInResolveGA(){
		return utils.clickAnelemnt(this.btnSubmit, "ResolveGrievanceAndAppeals", "Submit");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:fillDetailsInResolveGrievanceAndAppeals
	 * #Description:This method enters required details in 'Resolve Grievance And Appeals' page. 
	 * #Arguments:Select Next Action and Notes
	 * Type:Dropdown and TextBox
	 * Keys:Resolved Request#Unable to Resolve Request
	 */
	public boolean fillDetailsInResolveGrievanceAndAppeals(String[] args) throws InterruptedException{
		if(utils.selectDropDownbyVisibleString(this.nextActionDrpdown, args[0],"ResolveGrievanceAndAppeals", "Select Next Action"))
			if(utils.enterTextinAnelemnt(this.notesTxtBox, args[1],"ResolveGrievanceAndAppeals", "Notes"))
				return true;
			return false;
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'External Search')]")
	private WebElement lnkExternalSearch;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActions
	 * #Description:This method verifies 'Other Actions' section is displayed on 'Resolve Grievance And Appeals' page
	 * Type:TextBox
	 */
	public boolean verifyOtherActions(){
		return !utils.isProxyWebelement(btnOtherActions);
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigatetoExternalSearch
	 * #Description:This method verifies 'External search' is displayed in 'Other Actions' section 'Resolve Grievance And Appeals' page
	 * Type:TextBox
	 */
	public boolean navigatetoExternalSearch()
	{
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "External Search", "ResolveGrievanceAndAppeals", "External Search");
	}
}
