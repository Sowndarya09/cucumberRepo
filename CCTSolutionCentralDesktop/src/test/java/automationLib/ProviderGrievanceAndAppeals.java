package automationLib;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.steadystate.css.parser.selectors.SyntheticElementSelectorImpl;

import utils.BaseLogger;
import utils.Data;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderGrievanceAndAppeals{

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement1;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderGA;

	@FindBy(linkText="G & A Routing")
	private WebElement ga_RoutingLink;

	@FindBy(linkText="MAGI")
	private WebElement magiLink;

	@FindBy(linkText="MCW")
	private WebElement mcwLink;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="msgOnGrievanceAndAppealsSubmit")
	private WebElement msgOnGrievanceAndAppealsSubmit;

	@FindBy(id="WasTheDissatisfaction")
	private WebElement wasTheDissatisfaction;

	@FindBy(id="WasTheDissatRelatedTo")
	private WebElement wasTheDissatisfactionRelatedTo;

	@FindBy(xpath="//select[@id='GACategory']")
	WebElement drpdwnGACategory;

	@FindBy(xpath="//select[@id='GASubCategory']")
	WebElement drpdwnGAsubCategory;
	@FindBy(xpath="//select[@id='GACategory']//option")
	List<WebElement> drpdwnoptionsGACategory;

	@FindBy(xpath="//select[@id='GASubCategory']//option")
	List<WebElement> drpdwnoptionsGAsubCategory;

	@FindBy(id="AppealTypeClinical")
	WebElement rdoClinical;


	DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);

	/**
	 * Constructor for the GrievanceAndAppeals class defining the Iframe and the Page Factory  
	 */
	public ProviderGrievanceAndAppeals() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}catch(Exception e){
			System.out.println("Exception in costructor");
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyGARoutingLink
	 * #Description:This method verifies if G and A Routing Link is displayed on 'Grievance And Appeals' task
	 * Type:TextBox
	 */
	public boolean verifyGARoutingLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderGA, "Grievance and Appeals")){
			System.out.println("Grievance and Appeals page is loaded");
			try{
				if(this.ga_RoutingLink.isDisplayed()){
					System.out.println("G&A Routing link is displayed");
					return true;
				}
			}catch(Exception e){
				err.logcommonMethodError("GrievanceAndAppeals", "G&A Routing link is not displayed");
			}
		}else{
			err.logcommonMethodError("GrievanceAndAppeals", "Grievance and Appeals page is not loaded");
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyMAGILink
	 * #Description:This method verifies if MAGI Link is displayed on 'Grievance And Appeals' task
	 * Type:TextBox
	 */
	public boolean verifyMAGILink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderGA, "Grievance and Appeals")){
			System.out.println("Grievance and Appeals page is loaded");
			try{
				if(this.magiLink.isDisplayed()){
					System.out.println("MAGI link is displayed");
					return true;
				}
			}catch(Exception e){
				err.logcommonMethodError("GrievanceAndAppeals", "MAGI link is not displayed");
			}
		}else{
			err.logcommonMethodError("GrievanceAndAppeals", "Grievance and Appeals page is not loaded");
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyMCWLink
	 * #Description:This method verifies if MCW Link is displayed on 'Grievance And Appeals' task
	 * Type:TextBox
	 */
	public boolean verifyMCWLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderGA, "Grievance and Appeals")){
			System.out.println("Grievance and Appeals page is loaded");
			try{
				if(this.mcwLink.isDisplayed()){
					System.out.println("MCW link is displayed");
					return true;
				}
			}catch(Exception e){
				err.logcommonMethodError("GrievanceAndAppeals", "MCW link is not displayed");
			}
		}else{
			err.logcommonMethodError("GrievanceAndAppeals", "Grievance and Appeals page is not loaded");
		}
		return false;
	}

	/*	 * @SCU
	 * #CommonMethodwithoutArgument:verifyFieldsInGrievanceAppealsTask
	 * #Description:This method verifies if 'Was the dissatisfaction and Was the dissatisfaction related to' are displayed on 'Grievance And Appeals' task
	 * Type:TextBox
	 */
	public boolean verifyFieldsInGrievanceAppealsTask() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderGA, "Grievance and Appeals")){
			System.out.println("Grievance and Appeals page is loaded");
			try{
				if(this.wasTheDissatisfaction.isDisplayed() && this.wasTheDissatisfactionRelatedTo.isDisplayed()){
					System.out.println("Was the dissatisfaction and Was the dissatisfaction related to: fields are displayed");
					return true;
				}
			}catch(Exception e){
				err.logcommonMethodError("GrievanceAndAppeals", "Was the dissatisfaction and Was the dissatisfaction related to: fields are not displayed");
			}
		}else{
			err.logcommonMethodError("GrievanceAndAppeals", "Grievance and Appeals page is not loaded");
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActions
	 * #Description:This method verifies 'Other Actions' section is displayed on 'Grievance And Appeals' task
	 * Type:TextBox
	 */
	public boolean verifyOtherActions(){
		return !utils.isProxyWebelement(btnOtherActions);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickByDefaultSubmit
	 * #Description:This method clicks on default submit button without entering mandatory fields in GrievanceAndAppeals screen.
	 * Type:TextBox
	 */
	public boolean clickByDefaultSubmit(){
		if(utils.clickAnelemnt(this.btnSubmit, "GrievanceAndAppeals", "Submit")) {
			Driver.pgDriver.switchTo().alert().accept();
			return true;
		}
		return false;
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:validateMsgOnGrievanceAndAppealsSubmit
	 * #Description:This method validates the message displayed, when user doesn't choose 'Was the dissatisfaction' and 'related to' questions but performs submit button in Grievance task.
	 * Type:TextBox
	 */
	public boolean validateMsgOnGrievanceAndAppealsSubmit(){
		String expectedMsg = "";
		try{
			String errMsg = this.msgOnGrievanceAndAppealsSubmit.getText().trim();
			if(errMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - on GrievanceAndAppeals page"+errMsg);
				return true;
			}else{
				System.out.println("Message doesnt match while submit - on GrievanceAndAppeals page"+errMsg);
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve message, on 'GrievanceAndAppeals' page"+e);
		}
		return false;
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:checkValuesInWasTheDissatisfactionField
	 * #Description:This function validates the questions displayed for the field - 'Was the dissatisfaction' in Grievance and Appeals task.
	 * Type:TextBox
	 */
	public boolean checkValuesInWasTheDissatisfactionField(){
		String[] wasTheDissatisfaction = {"About service from Anthem or a provider?","About membership/eligibility?","About a claim issue?","Out of Network Referral","Pre-Authorization"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(wasTheDissatisfaction));
		return utils.checkvaluesinDropDown(this.wasTheDissatisfaction,al);
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:checkDissatisfactionValuesForServiceOrProviderIssue
	 * #Description:This function validates the options for 'Was the dissatisfaction related to' field when 'About service from Anthem or a Provider?' is chosen.
	 * Type:TextBox
	 */
	public boolean checkDissatisfactionValuesForServiceOrProviderIssue(){
		utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, "About service from Anthem or a provider?", "GrievanceAndAppeals", "Was The Dissatisfaction");
		String[] dissatisfactionRelatedTo = {"Telephone Wait Time","Website Access Issue","Timeliness for provider directory, ID cards, EOCs","Access to Care","Simple Premium Payment Issues (credit card declines, NSF fees, paymnet not processed - Individual Only","HIPAA Privacy Allegation Violation","Quality of Service Against Provider","Quality of Care Against Provider"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(dissatisfactionRelatedTo));
		return utils.checkvaluesinDropDown(this.wasTheDissatisfactionRelatedTo,al);
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:checkDissatisfactionValuesForMembershipOrEligiblityIssue
	 * #Description:This function validates the options for 'Was the dissatisfaction related to' field when 'About membership/eligibility' is chosen.
	 * Type:TextBox
	 */
	public boolean checkDissatisfactionValuesForMembershipOrEligiblityIssue(){
		utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, "About membership/eligibility?", "GrievanceAndAppeals", "Was The Dissatisfaction");
		String[] dissatisfactionRelatedTo = {"Improper current or future Cancellation of Policy (Applies to Individual On Exchange, Off Exchange, Legacy, and Stand Alone Dental Plans only)","Proper current or future Cancellation of Policy (Applies to Individual On Exchange, Off Exchange, Legacy, and Stand Alone)","Rate Increase","Effective/Cancellation Date","Coordination of Benefits","COBRA"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(dissatisfactionRelatedTo));
		return utils.checkvaluesinDropDown(this.wasTheDissatisfactionRelatedTo,al);
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:checkDissatisfactionValuesForClaimIssue
	 * #Description:This function validates the options for 'Was the dissatisfaction related to' field when 'About a claim issue' is chosen.
	 * Type:TextBox
	 */
	public boolean checkDissatisfactionValuesForClaimIssue(){
		utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, "About a claim issue?", "GrievanceAndAppeals", "Was The Dissatisfaction");
		String[] dissatisfactionRelatedTo = {"A claim issue that you are able to resolve (MRU, HMO, ITS, CDHP, COB, Foreign, Dental Pricing, etc.)","Coverage Dispute","Medical Necessity","Experimental or Investigational Treatment","Pharmacy/Medical Accumulators","Out of Pocket/Deductible"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(dissatisfactionRelatedTo));
		return utils.checkvaluesinDropDown(this.wasTheDissatisfactionRelatedTo,al);
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:checkDissatisfactionValuesForOutOfNetworkReferral
	 * #Description:This function validates 'Was the dissatisfaction related to' field is disabled when 'Out Of Network Referral' is chosen.
	 * Type:TextBox
	 */
	public boolean checkDissatisfactionValuesForOutOfNetworkReferral(){
		utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, "Out of Network Referral", "GrievanceAndAppeals", "Was The Dissatisfaction");
		if(this.wasTheDissatisfactionRelatedTo.getAttribute("disabled").equalsIgnoreCase("true")){
			System.out.println("'Was The Dissatisfaction Related To' field is disabled for 'Out Of Network Referral' question");
			return true;
		}else{
			err.logError("GrievanceAndAppeals", "'Was The Dissatisfaction Related To' field is not disabled for 'Out Of Network Referral' question");
			return false;
		}
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:checkDissatisfactionValuesForPreAuthorization
	 * #Description:This function validates the options for 'Was the dissatisfaction related to' field when 'Pre-Authorization' is chosen.
	 * Type:TextBox
	 */
	public boolean checkDissatisfactionValuesForPreAuthorization(){
		utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, "Pre-Authorization", "GrievanceAndAppeals", "Was The Dissatisfaction");
		String[] dissatisfactionRelatedTo = {"Anthem Pre-Authorization","Vendor Issues that you are able to resolve (NIA, AIM, ESI, etc.)"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(dissatisfactionRelatedTo));
		return utils.checkvaluesinDropDown(this.wasTheDissatisfactionRelatedTo,al);
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectServiceOrProviderIssue
	 * #Description:This method selects Dissatisfaction and Related To fields depending on the user input.  
	 * #Arguments:Was the dissatisfaction - Was the dissatisfaction related to
	 * Type:Dropdown
	 * Keys:#About service from Anthem or a provider?
	 * Keys:Telephone Wait Time#Website Access Issue#Timeliness for provider directory, ID cards, EOCs#Access to Care#Simple Premium Payment Issues (credit card declines, NSF fees, paymnet not processed - Individual Only#HIPAA Privacy Allegation Violation#Quality of Service Against Provider#Quality of Care Against Provider
	 */
	public boolean selectServiceOrProviderIssue(String[] args){
		if(utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, args[0], "GrievanceAndAppeals", "Was The Dissatisfaction"))
			return utils.selectDropDownbyVisibleString(this.wasTheDissatisfactionRelatedTo, args[1], "GrievanceAndAppeals", "Was The Dissatisfaction Related To");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectMembershipOrEligiblityIssue
	 * #Description:This method selects Dissatisfaction and Related To fields depending on the user input.
	 * #Arguments:Was the dissatisfaction - Was the dissatisfaction related to
	 * Type:Dropdown
	 * Keys:#About membership/eligibility?
	 * Keys:Improper current or future Cancellation of Policy (Applies to Individual On Exchange, Off Exchange, Legacy, and Stand Alone Dental Plans only)#Proper current or future Cancellation of Policy (Applies to Individual On Exchange, Off Exchange, Legacy, and Stand Alone)#Rate Increase#Effective/Cancellation Date#Coordination of Benefits#COBRA
	 */
	public boolean selectMembershipOrEligiblityIssue(String[] args){
		if(utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, args[0], "GrievanceAndAppeals", "Was The Dissatisfaction"))
			return utils.selectDropDownbyVisibleString(this.wasTheDissatisfactionRelatedTo, args[1], "GrievanceAndAppeals", "Was The Dissatisfaction Related To");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectClaimIssue
	 * #Description:This method selects Dissatisfaction and Related To fields depending on the user input.
	 * #Arguments:Was the dissatisfaction - Was the dissatisfaction related to
	 * Type:Dropdown
	 * Keys:#About a claim issue?
	 * Keys:A claim issue that you are able to resolve (MRU, HMO, ITS, CDHP, COB, Foreign, Dental Pricing, etc.)#Coverage Dispute#Medical Necessity#Experimental or Investigational Treatment#Pharmacy/Medical Accumulators#Out of Pocket/Deductible
	 */
	public boolean selectClaimIssue(String[] args){
		if(utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, args[0], "GrievanceAndAppeals", "Was The Dissatisfaction"))
			return utils.selectDropDownbyVisibleString(this.wasTheDissatisfactionRelatedTo, args[1], "GrievanceAndAppeals", "Was The Dissatisfaction Related To");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectPreAuthorizationIssue
	 * #Description:This method selects Dissatisfaction and Related To fields depending on the user input.
	 * #Arguments:Was the dissatisfaction - Was the dissatisfaction related to
	 * Type:Dropdown
	 * Keys:#Pre-Authorization
	 * Keys:Anthem Pre-Authorization#Vendor Issues that you are able to resolve (NIA, AIM, ESI, etc.)
	 */
	public boolean selectPreAuthorizationIssue(String[] args){
		if(utils.selectDropDownbyVisibleString(this.wasTheDissatisfaction, args[0], "GrievanceAndAppeals", "Was The Dissatisfaction"))
			return utils.selectDropDownbyVisibleString(this.wasTheDissatisfactionRelatedTo, args[1], "GrievanceAndAppeals", "Was The Dissatisfaction Related To");
		return false;
	}

	@FindBy(id="DialogContent")
	private WebElement msgOnGrievanceDialog;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateGuidedDialogInGrievanceAndAppeals
	 * #Description:This method validates if Grievance and Appeals message is displayed in a Guided dialog in GA page. 
	 * Type:TextBox
	 */
	public boolean validateGuidedDialogInGrievanceAndAppeals(){
		String expectedMsg ="Use the Grievance and Appeals task to determine if this should be considered a One Day Grievance or a Standard Grievance. Follow on screen prompts to ensure that the grievance is routed correctly.";
		try{
			String grievanceMsg = this.msgOnGrievanceDialog.getText().trim();
			if(grievanceMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - on  Grievance and Appeals page"+grievanceMsg);
				return true;
			}else{
				System.out.println("Message doesnt match on  Grievance and Appeals page"+grievanceMsg);
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve Grievance message on  Grievance and Appeals page"+e);
		}
		return false;
	}

	@FindBy(xpath="//div[contains(text(),'This is a One Day (Exempt)')]")
	private WebElement oneDayGrievanceTxt;

	@FindBy(xpath="//span[text()='Were you able to resolve the member’s complaint during your interaction ?']")
	private WebElement resolveMemComplaintQues;
	@FindBy(id="IsOneDayGrievanceResolvedYes")
	private WebElement resolveMemComplaintYesRdo;
	@FindBy(id="IsOneDayGrievanceResolvedNo")
	private WebElement resolveMemComplaintNoRdo;
	@FindBy(xpath="//span[text()='Notes']")
	private WebElement notesLbl;
	@FindBy(id="DissatisfiedGrievanceNotes")
	private WebElement notesTxt;

	@FindBy(xpath="//div[contains(text(),'This is a standard Grievance Log')]")
	private WebElement standardGrievanceTxt;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateOneDayGrievanceSection
	 * #Description:This method validates if One Day Grievance section and message is displayed in GA page. 
	 * Type:TextBox
	 */
	public boolean validateOneDayGrievanceSection(){
		String expectedMsg ="This is a One Day (Exempt) Grievance.  If you are not able to close the service request during the interaction keep it in your work list. It will be classified as a one day grievance. Make sure it is closed by the end of the day the next business day. If you are unable to resolve the request by the end of the day the next business day, a Standard Grievance must be opened.";
		try{
			String grievanceMsg = this.oneDayGrievanceTxt.getText().trim();
			if(grievanceMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - on  OneDayGrievanceSection - Grievance&Appeals page"+grievanceMsg);
			}else{
				System.out.println("Message doesnt match on  OneDayGrievanceSection - Grievance&Appeals page"+grievanceMsg);
				return false;
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve One Day Grievance text on Grievance&Appeals page"+e);
			return false;
		}
		try{
			if(this.resolveMemComplaintQues.isDisplayed() && this.resolveMemComplaintYesRdo.isDisplayed() && this.resolveMemComplaintNoRdo.isDisplayed() && this.notesLbl.isDisplayed()){
				System.out.println("Resolve Member Complaint Question with Yes/No radio options & Notes section is Displayed");
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve One Day Grievance - Resolve Member Complaint Question with Yes/No radio options & Notes section"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateStandardGrievanceSection
	 * #Description:This method validates if Standard Grievance message is displayed in GA page. 
	 * Type:TextBox
	 */
	public boolean validateStandardGrievanceSection(){
		String expectedMsg ="This is a standard Grievance Log into CCB and open an IQT and go to the G&A Routing Work Path link for instructions for routing as a Standard Grievance.";
		try{
			String grievanceMsg = this.standardGrievanceTxt.getText().trim();
			if(grievanceMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - on  StandardGrievance - Grievance&Appeals page"+grievanceMsg);
			}else{
				System.out.println("Message doesnt match on  StandardGrievance - Grievance&Appeals page"+grievanceMsg);
				return false;
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve Standard Grievance text on Grievance&Appeals page"+e);
			return false;
		}
		try{
			if(this.resolveMemComplaintQues.isDisplayed() && this.resolveMemComplaintYesRdo.isDisplayed() && this.resolveMemComplaintNoRdo.isDisplayed() && this.notesLbl.isDisplayed()){
				System.out.println("Issue: For Standard Grievance - Resolve Member Complaint Question with Yes/No radio options & Notes section is Displayed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve One Day Grievance - Resolve Member Complaint Question with Yes/No radio options & Notes section"+e);

		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:fillOneDayGrievanceFields
	 * #Description:This method fills input to One Day Grievance fields - Resolve Member Complaint and Notes.
	 * #Arguments:Resolve Member Complaint - Notes
	 * Type:TextBox
	 */
	public boolean fillOneDayGrievanceFields(String[] args){
		try{
			if((args[0]).trim().equalsIgnoreCase("Yes")){
				utils.clickAnelemnt(this.resolveMemComplaintYesRdo, "GrievanceAndAppeals", "Radio Button for Yes");
			}else if ((args[0]).trim().equalsIgnoreCase("No")){
				utils.clickAnelemnt(this.resolveMemComplaintNoRdo, "GrievanceAndAppeals", "Radio Button for No");
			}else{
				System.out.println("Please enter valid option to select - either Yes or No");
				return false;
			}
			return utils.enterTextinAnelemnt(this.notesTxt, args[1], "GrievanceAndAppeals", "Notes text");
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "fillOneDayGrievanceFields"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickGARoutingLink
	 * #Description:This method clicks on G and A Routing Link is displayed on Grievance And Appeals task
	 * Type:TextBox
	 */
	public boolean clickGARoutingLink(){
		utils.clickAnelemnt(this.ga_RoutingLink, "GrievanceAndAppeals", "G & A Routing Link");
		try{
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			String title = Driver.pgDriver.switchTo().window(childWindow).getTitle().trim();
			String url = Driver.pgDriver.switchTo().window(childWindow).getCurrentUrl();
			System.out.println("No.of windows opened"+handles.size()+"\nTitle"+title+"\nURL"+url);
			if(title.contains("Performance Support Team - WorkPaths Tool")){
				System.out.println("Window switched");
			}else{
				System.out.println("Window switched failed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured::"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickMAGILink
	 * #Description:This method clicks on MAGI Link is displayed on Grievance And Appeals task
	 * Type:TextBox
	 */
	public boolean clickMAGILink(){
		utils.clickAnelemnt(this.magiLink, "GrievanceAndAppeals", "MAGI Link");
		try{
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			String title = Driver.pgDriver.switchTo().window(childWindow).getTitle().trim();
			String url = Driver.pgDriver.switchTo().window(childWindow).getCurrentUrl();
			System.out.println("No.of windows opened"+handles.size()+"\nTitle"+title+"\nURL"+url);
			if(title.contains("PCT | Process Communication Tracking")){
				System.out.println("Window switched");
			}else{
				System.out.println("Window switched failed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured::"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickMCWLink
	 * #Description:This method clicks on MCW Link is displayed on Grievance And Appeals task
	 * Type:TextBox
	 */
	public boolean clickMCWLink(){
		utils.clickAnelemnt(this.mcwLink, "GrievanceAndAppeals", "MCW Link");
		try{
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			String title = Driver.pgDriver.switchTo().window(childWindow).getTitle();
			String url = Driver.pgDriver.switchTo().window(childWindow).getCurrentUrl();
			System.out.println("No.of windows opened"+handles.size()+"\nTitle"+title+"\nURL"+url);
			if(title.contains("MCW Development Links")){
				System.out.println("Window switched");
			}else{
				System.out.println("Window switched failed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured::"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateCCBExternalSearchPageIsNotDisplayed
	 * #Description:This method validates if CCB External launch page is not displayed when user opens Grievance and Appeals Task
	 * Type:TextBox
	 */
	public boolean validateCCBExternalSearchPageIsNotDisplayed(){
		utils.waitforpageload();
		return utils.validateHeader(this.sHeaderGA, "External Search");
	}

	@FindBy(xpath="//div[@title='Disclose Previous Grievance and Appeals Tasks for Member']")
	private WebElement collapseIndicator;

	@FindBy(xpath="//div[@title='Hide Previous Grievance and Appeals Tasks for Member']")
	private WebElement expandIndicator;

	@FindBy(xpath="//span[@id][text()='Previous Grievance and Appeals Tasks for Member']")
	private WebElement prvGATaskHeader;


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyPrvGATasksforMemberCollapseByDefault
	 * #Description:This method verifies Previous Grievance and Appeals Tasks for Member section is displayed collapsed
	 * Type:TextBox
	 */
	public boolean verifyPrvGATasksforMemberCollapseByDefault(){
		return this.collapseIndicator.isDisplayed() && this.prvGATaskHeader.isDisplayed();
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickExpandPrvGATasksforMember
	 * #Description:This method clicks on expand the Previous Grievance and Appeals Tasks for Member section
	 * Type:TextBox
	 */
	public boolean clickExpandPrvGATasksforMember(){
		if(this.collapseIndicator.isDisplayed())
			return utils.clickAnelemnt(this.collapseIndicator, "GrievanceAndAppeals", "Expand image click");
		return false;	
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickCollapsePrvGATasksforMember
	 * #Description:This method clicks on collapse the Previous Grievance and Appeals Tasks for Member section
	 * Type:TextBox
	 */
	public boolean clickCollapsePrvGATasksforMember(){
		if(this.expandIndicator.isDisplayed())
			return utils.clickAnelemnt(this.expandIndicator, "GrievanceAndAppeals", "Collape image click");
		return false;	
	}

	@FindBy(xpath="//table[@pl_prop='pgRepPgSubSectionGAndASRsForContractB.pxResults']")
	private WebElement prvGATable;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyColHeadersInPreviousGATasksForMember
	 * #Description:This method verifies the column headers in the previous Grievance and Appeals Task section
	 * Type:TextBox
	 */
	public boolean verifyColHeadersInPreviousGATasksForMember(){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.prvGATable);
		String args[]={"SR-ID","Type","Status","Interaction Count","Urgency","Open Date","Contact Name","Member Name"};
		StringBuilder input = new StringBuilder();
		String colHdrs[] = input.append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).append(",").append(args[5]).append(",").append(args[6]).append(",").append(args[7]).toString().split(",");
		return utils.validateTableRowHeader(this.prvGATable, colHdrs);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateGuidedDialogueMsgInGrievanceAndAppeals
	 * #Description:This method validates if Grievance and Appeals message is displayed in a Guided dialog in Grievance and Appeals Task
	 * Type:TextBox
	 */
	public boolean validateGuidedDialogueMsgInGrievanceAndAppeals(){
		String expectedMsg ="You can initiate a Grievance or Appeal below for Manage Enrollment and Billing, Manage ID Cards, Benefits and Cost, and Manage Pharmacy. You must initiate a Grievance or Appeal through the other actions for Manage Authorizations, Manage Claims, Manage Other Insurance, Provider and Accumulators through the task itself.";
		try{
			String grievanceMsg = this.msgOnGrievanceDialog.getText().replace("\n"," ").trim();
			if(grievanceMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - on  Grievance and Appeals page"+grievanceMsg);
				return true;
			}else{
				System.out.println("Message doesnt match on  Grievance and Appeals page"+grievanceMsg);
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve Grievance message on  Grievance and Appeals page"+e);
		}

		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyPreviousGATasksForContact
	 * #Description:This method verifies if previous Grievance and Appeals Task section is displayed and clicks to expand the table
	 * Type:TextBox
	 */
	public boolean verifyPreviousGATasksForContact(){
		if(this.prvGATaskHeader.isDisplayed())
			return utils.clickAnelemnt(this.collapseIndicator, "GrievanceAndAppeals", "Expand Icon");
		return false;	
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validatePreviousGATasksForContact
	 * #Description:This method validates the previous GA request details in the previous Grievance and Appeals Task section
	 * #Arguments:Prev-GATask
	 * Type:Table
	 * Keys:#SR-ID#Type#Status#Interaction Count#Urgency#Open Date#Contact Name#Member Name
	 */
	public boolean validatePreviousGATasksForContact(String[] args) throws InterruptedException{
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);
		}

		return utils.clickontablerowbasedonvalues(this.prvGATable, args);
	}

	@FindBy(xpath="//span[text()='Select Type:']")
	private WebElement selectTypeLbl;

	@FindBy(id="GAndATypeGrievance")
	private WebElement typeGrievance;

	@FindBy(id="GAndATypeAppeal")
	private WebElement typeAppeal;

	@FindBy(id="GAndATypeRoute to G&A with Unknown Type")
	private WebElement typeUnknown;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectTypeInGATask
	 * #Description:This method selects one of the following options 'Grievance','Appeal' or 'Route to GA with Unknown Type' in the Grievance and Appeals Task
	 * #Arguments:Select Type
	 * Type:Dropdown
	 * Keys:Grievance#Appeal#Route to GA with Unknown Type
	 */
	public boolean selectTypeInGATask(String[] args){
		if(args[0].contains("Grievance")){
			return utils.clickAnelemnt(this.typeGrievance, "GrievanceAndAppeals", "Grievance Radio Btn");
		}
		else if(args[0].contains("Appeal")){
			return utils.clickAnelemnt(this.typeAppeal, "GrievanceAndAppeals", "Appeals Radio Btn");
		}
		else if(args[0].contains("Unknown")){
			return utils.clickAnelemnt(this.typeUnknown, "GrievanceAndAppeals", "Route to G&A with Unknown Type");
		}
		else{
			return false;
		}
	}

	@FindBy(id="CorporateReceivedDate")
	WebElement corpReceivedDate;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDefaultCorporateReceivedDate
	 * #Description:This method verifies if the date populated in 'Corporate Received date' field defaults to current date in the Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean verifyDefaultCorporateReceivedDate(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate currentDate = LocalDate.now();
		String todayDateTime = currentDate.format(formatter);
		System.out.println("Current day:Today:"+todayDateTime);
		String defaultDateInUI = this.corpReceivedDate.getAttribute("value").trim();
		if(defaultDateInUI.matches(todayDateTime)){
			System.out.println("Default value in UI:"+defaultDateInUI+" matched with Todays Date:"+todayDateTime);
			return true;
		}else{
			System.out.println("Default value in UI:"+defaultDateInUI+"doesnt match with Todays Date:"+todayDateTime);
			err.logError("GrievanceAndAppeals", "verifyDefaultCorporateReceivedDate");
			return false;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterCorporateReceivedDate
	 * #Description:This method enters date to the field 'Corporate Received date' in the Grievance and Appeals Task
	 * #Arguments:CorporateReceivedDate
	 * Type:Textbox
	 */
	public boolean enterCorporateReceivedDate(String[] args){
		String selectAll = Keys.chord(Keys.CONTROL,"a");
		Actions action = new Actions(Driver.pgDriver); 
		action.moveToElement(this.corpReceivedDate).click().sendKeys(selectAll,Keys.BACK_SPACE).build().perform();
		if(utils.enterTextinAnelemnt(this.corpReceivedDate, args[0], "GrievanceAndAppeals", "Corporate Received Date")) {
			this.corpReceivedDate.sendKeys(Keys.TAB);
			return true;
		}
		return false;
	}

	@FindBy(id="GACategory")
	WebElement GACategoryDrpdown;

	@FindBy(id="GASubCategory")
	WebElement GASubCategoryDrpdown;

	@FindBy(id="GAReason")
	WebElement GAReasonDrpdown;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:chooseCategory
	 * #Description:This method allows the user to choose a Category in the Grievance and Appeals Task
	 * #Arguments:Category
	 * Type:Dropdown
	 * Keys:To be decided#A#B#C
	 */
	public boolean chooseCategory(String[] args){
		return utils.selectDropDownbyVisibleString(this.GACategoryDrpdown, args[0], "GrievanceAndAppeals", "Category");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:chooseSubCategory
	 * #Description:This method allows the user to choose a subCategory in the Grievance and Appeals Task
	 * #Arguments:subCategory
	 * Type:Dropdown
	 * Keys:To be decided#A#B#C
	 */
	public boolean chooseSubCategory(String[] args){
		return utils.selectDropDownbyVisibleString(this.GASubCategoryDrpdown, args[0], "GrievanceAndAppeals", "SubCategory");
	}

	@FindBy(id="IsExpeditedAppeal")
	WebElement isExpeditedAppealChkBox;

	@FindBy(xpath="//label[@for='IsExpeditedAppeal'][text()='Expedited Appeal?']")
	WebElement isExpeditedAppealLbl;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyExpeditedAppeal
	 * #Description:This method verifies 'Expedited Appeal' field is displayed when 'Appeal' type is chosen in the Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean verifyExpeditedAppeal(){
		try{
			if(this.isExpeditedAppealChkBox.isDisplayed() && this.isExpeditedAppealLbl.isDisplayed()){
				System.out.println("'Expedited Appeal' field is displayed when 'Appeal' type is chosen");
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "verifyExpeditedAppeal");;
			System.out.println("Issue in validating to field - Expedited Appeal"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyNoExpeditedAppealDisplay
	 * #Description:This method verifies 'Expedited Appeal' field is not displayed when 'Grievance' type is chosen in the Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean verifyNoExpeditedAppealDisplay(){
		try{
			if(this.isExpeditedAppealChkBox.isDisplayed() && this.isExpeditedAppealLbl.isDisplayed()){
				System.out.println("'Expedited Appeal' field is displayed when 'Appeal' type is chosen");
				err.logError("GrievanceAndAppeals", "verifyNoExpeditedAppealDisplay");
			}
		}catch(Exception e){
			System.out.println("Negative validation to field - Expedited Appeal is not displayed"+e);
			return true;
		}
		return false;
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:checkExpeditedAppeal
	 * #Description:This method checks 'Expedited Appeal' field displayed in the Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean checkExpeditedAppeal(){
		return utils.clickAnelemnt(this.isExpeditedAppealChkBox, "GrievanceAndAppeals", "Expedited Appeal?");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectExpeditedAppealReason
	 * #Description:This method allows user to choose value in 'Expedited Appeal' reason field displayed in the Grievance and Appeals Task
	 * #Arguments:ExpeditedReason
	 * Type:Dropdown
	 * Keys:To be decided#A#B#C
	 */
	public boolean selectExpeditedAppealReason(String[] args){
		return utils.selectDropDownbyVisibleString(this.GAReasonDrpdown, args[0], "GrievanceAndAppeals", "Expedited Reason");
	}

	public WebElement msg1OnNationalContract(){
		List<WebElement> text1 = Driver.getPgDriver().findElements(By.xpath("//div[@class='content-inner ']//p/span"));
		return text1.get(0);
	}

	public WebElement msg2OnNationalContract(){
		List<WebElement> text1 = Driver.getPgDriver().findElements(By.xpath("//div[@class='content-inner ']//p/span"));
		return text1.get(1);
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateMsgOnNationalContract
	 * #Description:This method validates the message displayed when LOB of Contract is National and Policy State of Contract in focus is not 'CA' in Grievance and Appeals Task
	 * #Arguments:PolicyState
	 * Type:Textbox
	 */
	public boolean validateMsgOnNationalContract(String[] args){
		utils.waitforpageload();
		try{
			String msg1 = msg1OnNationalContract().getText().trim();
			String msg2 = msg2OnNationalContract().getText().trim().replaceAll("\n"," ");
			String L1 = "For National accounts in the state of "+args[0]+"  Grievance and Appeal request must sent in writing.  Advise the member to send their grievance and/or appeal request to:";
			String L2 = "Anthem Grievance and Appeals P.O. Box 54159 Los Angeles, CA 90054 In the request the member must include there Identification Number, the reason for their complaint and their expected resolution to the complaint.";

			if(msg1.equalsIgnoreCase(L1) && msg2.equalsIgnoreCase(L2)){
				System.out.println("Message displayed in UI"+ msg1OnNationalContract().getText().trim()+"\n"+msg2OnNationalContract().getText().trim());
				return true;
			}
			else{
				System.out.println("Message displayed isnt the expected one"+ msg1OnNationalContract().getText().trim()+"\n"+msg2OnNationalContract().getText().trim());
				return false;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "validateMsgOnNationalContract");
			System.out.println("Unable to retrieve message on NationalContract"+e);
			return false;
		}		
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateNoMsgOnNationalCAContract
	 * #Description:This method validates no message is displayed when LOB of Contract is National and Policy State of Contract in focus is 'CA' in Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean validateNoMsgOnNationalCAContract(){
		utils.waitforpageload();
		try{
			String msg1 = msg1OnNationalContract().getText().trim();
			String msg2 = msg2OnNationalContract().getText().trim().replaceAll("\n"," ");
			String L1 = "For National accounts in the state of CA  Grievance and Appeal request must sent in writing.  Advise the member to send their grievance and/or appeal request to:";
			String L2 = "Anthem Grievance and Appeals P.O. Box 54159 Los Angeles, CA 90054 In the request the member must include there Identification Number, the reason for their complaint and their expected resolution to the complaint.";

			if(msg1.equalsIgnoreCase(L1) && msg2.equalsIgnoreCase(L2)){
				System.out.println("Message displayed in UI"+ msg1OnNationalContract().getText().trim()+"\n"+msg2OnNationalContract().getText().trim());
				return false;
			}
			else{
				err.logError("GrievanceAndAppeals", "validateNoMsgOnNationalCAContract");
				System.out.println("Message displayed isnt the expected one"+ msg1OnNationalContract().getText().trim()+"\n"+msg2OnNationalContract().getText().trim());
				return false;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "validateNoMsgOnNationalCAContract");
			System.out.println("Unable to retrieve message on National CA Contract"+e);
			return true;
		}		
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifySelectTypeIsNotDisplayed
	 * #Description:This method verifies the following SelectType options 'Grievance','Appeal' or 'Route to GA with Unknown Type' are not displayed
	 * Type:Textbox
	 */
	public boolean verifySelectTypeIsNotDisplayed(){
		try{
			if(this.selectTypeLbl.isDisplayed() && this.typeGrievance.isDisplayed() && this.typeAppeal.isDisplayed() && this.typeUnknown.isDisplayed()){
				System.out.println("Select Type is displayed");
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "verifySelectTypeIsNotDisplayed");
			System.out.println("Negative Test:::Select Type is not displayed"+e);
			return true;
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method allows the user to click on Submit in Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
		try{
			utils.clickAnelemnt(this.btnSubmit, "GrievanceAndAppeals", "Submit button");
			System.out.println("Submit button in Grievance And Appeals is clicked");
			if(utils.isAlertPresent()){
				System.out.println("Submit clicked successfully - & alert is handled on Grievance And Appeals page");
				return true;
			}
			else{
				System.out.println("Submit clicked successfully - & no alert is present on Grievance And Appeals page");
				return true;
			}		
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "clickOnSubmit");
			System.out.println("Unable to click on Submit button in Grievance And Appeals"+e);
			return false;
		}
	}

	@FindBy(id="GALevel")
	private WebElement GALevelDrpdown;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectLevel
	 * #Description:This method selects the Level if the Appeal is Level 1 or Level 2 in Grievance and Appeals Task
	 * #Arguments:Level
	 * Type:Dropdown
	 * Keys:Level 1#Level 2
	 */
	public boolean selectLevel(String[] args){
		return utils.selectDropDownbyVisibleString(this.GALevelDrpdown, args[0], "GrievanceAndAppeals", "Level");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyLevel2DisabledForWIorVA
	 * #Description:This method verifies for WI or VA state if the Appeal is selected then Level 2 option is disabled in Grievance and Appeals Task
	 * #Arguments:Level
	 * Type:Dropdown
	 * Keys:Level 1#Level 2
	 */
	public boolean verifyLevel2DisabledForWIorVA(String[] args){
		try{
			System.out.println("Dropdown value Level :: is"+args[0]);
			Driver.pgDriver.findElement(By.xpath("//select[@id='GALevel']/option[@value='"+args[0]+"']")).click();
			return false;
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "verifyLevel2DisabledForWIorVA");
			System.out.println("Unable to retrieve value to field -"+args[0]+e);
			return true;
		}
	}

	@FindBy(id="GAMemberIssue")
	private WebElement GAMemberIssueTxtBox;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:describeMemberIssue
	 * #Description:This method allows the user to enter describing the member issue in 3000 characters in the Grievance and Appeals Task
	 * #Arguments:MemberIssue
	 * Type:Textbox
	 */
	public boolean describeMemberIssue(String[] args){
		if(this.GAMemberIssueTxtBox.getAttribute("maxlength").equalsIgnoreCase("3000"))
			return utils.enterTextinAnelemnt(this.GAMemberIssueTxtBox, args[0], "GrievanceAndAppeals", "Member Issue");
		return false;
	}
	@FindBy(id="GAMemberExpectedResolution")
	private WebElement GAMemberExpectedResolutionTxtBox;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:describeMemberExpectedResolution
	 * #Description:This method allows the user to enter describing the members expected resolution in 3000 characters in the Grievance and Appeals Task
	 * #Arguments:ExpectedResolution
	 * Type:Textbox
	 */
	public boolean describeMemberExpectedResolution(String[] args){
		if(this.GAMemberExpectedResolutionTxtBox.getAttribute("maxlength").equalsIgnoreCase("3000"))
			return utils.enterTextinAnelemnt(this.GAMemberExpectedResolutionTxtBox, args[0], "GrievanceAndAppeals", "Member Expected Resolution");
		return false;
	}

	@FindBy(xpath="//span[@id][text()='Document References']")
	private WebElement docReferencesSection;

	@FindBy(xpath="//*[@title='Disclose Document References']")
	private WebElement docRefExpandSection;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDocumentReferences
	 * #Description:This method allows the user to verify if Document Reference Section is displayed in Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean verifyDocumentReferences(){
		try{
			Driver.pgDriver.findElement(By.xpath("//span[text()='Document References']")).click();
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "verifyDocumentReferences");
			System.out.println("Unable to verify field - Document References"+e);
			return false;
		}
		return true;
	}

	@FindBy(xpath="//a[text()=' Add']")
	private WebElement addDocRefLink;

	@FindBy(xpath="//select[@id='DocumentReferenceType1']")
	private WebElement docRefType1;

	@FindBy(xpath="//input[@id='DCNDocumentIDIndicator1']")
	private WebElement docRefNo1;

	@FindBy(xpath="//select[@id='DocumentReferenceType2']")
	private WebElement docRefType2;

	@FindBy(xpath="//input[@id='DCNDocumentIDIndicator2']")
	private WebElement docRefNo2;

	@FindBy(xpath="//a[text()=' Delete']")
	private WebElement delDocRefLink;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:addDocumentReferences
	 * #Description:This method adds respective Document references in Grievance and Appeals Task
	 * #Arguments:Reference Type and Document Reference Number
	 * Type:Dropdown and Textbox
	 * Keys:DCN#Document ID
	 */
	public boolean addDocumentReferences(String[] args){
		if(utils.clickAnelemnt(this.addDocRefLink, "GrievanceAndAppeals", "Add Document References")) {
			utils.waitforpageload();
			List<WebElement> l=Driver.pgDriver.findElements(By.xpath("//select[contains(@id,'DocumentReferenceType')]"));
			if(l.size()>1){
				if(utils.selectDropDownbyVisibleString(this.docRefType2, args[0], "GrievanceAndAppeals", "Reference Type 2"))
					if(utils.enterTextinAnelemnt(this.docRefNo2, args[1], "GrievanceAndAppeals", "Document Reference Number 2")) {
						this.docRefNo2.sendKeys(Keys.TAB);
						return true;
					}
			}else if(l.size()==1){
				if(utils.selectDropDownbyVisibleString(this.docRefType1, args[0], "GrievanceAndAppeals", "Reference Type 1"))
					if(utils.enterTextinAnelemnt(this.docRefNo1, args[1], "GrievanceAndAppeals", "Document Reference Number 1")) {
						this.docRefNo1.sendKeys(Keys.TAB);
						return true;
					}
			}
		}
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:deleteDocumentReferences
	 * #Description:This method deletes respective Document references in Grievance and Appeals Task
	 * #Arguments:Reference Type and Document Reference Number
	 * Type:Dropdown and Textbox
	 * Keys:DCN#Document ID
	 */
	public boolean deleteDocumentReferences(String[] args){
		Driver.pgDriver.findElement(By.xpath("//select[contains(@id,'DocumentReferenceType')]//option[text()='"+args[0]+"'][@selected]")).click();
		Driver.pgDriver.findElement(By.xpath("//input[contains(@id,'DCNDocumentIDIndicator')][@value='"+args[1]+"']")).click();
		return utils.clickAnelemnt(this.delDocRefLink, "GrievanceAndAppeals", "Delete Document References");
	}

	@FindBy(xpath="//div[@class='content-inner ']//p/span")
	WebElement insuredOrIndText;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateMsgOnFullyInsuredOrIndividualContract
	 * #Description:This method validates the message displayed when Funding Type is Fully Insured or LOB is Individual and poliy state being MO,WI,CO or NV in Grievance and Appeals Task
	 * #Arguments:PolicyState and CompanyCode
	 * Type:Textbox
	 */
	public boolean validateMsgOnFullyInsuredOrIndividualContract(String[] args){
		try{
			utils.waitforpageload();
			String L1 = "For the state of "+args[0]+"  Grievance and Appeal request must sent in writing.  Advise the member to send their grievance and/or appeal request to "+args[1]+".  In the request the member must include there Identification Number, the reason for their complaint and their expected resolution to the complaint.";
			String msg = this.insuredOrIndText.getText().trim();
			if(msg.equalsIgnoreCase(L1)){
				System.out.println("Message displayed in UI"+this.insuredOrIndText.getText().trim()+"\n");
				return true;
			}else{
				System.out.println("Message displayed isnt the expected one"+this.insuredOrIndText.getText().trim()+"\nExpected msg is::"+L1);
				return false;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "validateMsgOnFullyInsuredOrIndividualContract");
			System.out.println(""+e);
			return false;
		}
	}

	@FindBy(xpath="//table[@pl_prop='.TaggedProviderList']")
	private WebElement reviewTaggedProviderTable;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateProvidersReviewedWithContact
	 * #Description:This method validates the 'Providers Reviewed With Contact' section displayed as part of Grievance and Appeals SR
	 * #Arguments:Providers Reviewed
	 * Type:Table
	 * Keys:Care Provider#Distance#Location#In/Out Network
	 */
	public boolean validateProvidersReviewedWithContact(String[] args) throws InterruptedException{
		WebElement row =utils.getProviderResultsBasedOnValues(this.reviewTaggedProviderTable,args);
		System.out.println(row.getAttribute("pl_index"));
		List<WebElement> chkBox = row.findElements(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')]//img"));
		if(chkBox.get(1).isDisplayed()){
			return true;
		}
		return false;
	}

	@FindBy(xpath="//table[@class='gridTable '][@pl_prop='.AccountSummary']")
	private WebElement CDHPAccountsLevelTable;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCDHPandGATagged
	 * #Description: This method validates the CDHP Accounts tagged with GA Indicator checked.
	 * #Arguments:CDHPGATagged
	 * Type:Table
	 * Keys:#Account Description#Status#Effective Date#Plan Start Date#Plan End Date
	 */
	public boolean validateCDHPAccountandGATagged(String args[]) throws InterruptedException{	
		WebElement row =utils.getProviderResultsBasedOnValues(this.CDHPAccountsLevelTable,args);
		List<WebElement> GAchkBox = row.findElements(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')][@headers='a3']//img"));
		if(GAchkBox.get(0).isDisplayed()){
			return true;
		}
		return false;
	}

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;

	@FindBy (id="CancellationReason")	
	private WebElement cancelDrpdown;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:cancelThisWork
	 * #Description:This method verifies 'Cancel this Work' is displayed in 'Grievance And Appeals' page and user enters Cancellation reason
	 * #Arguments:CancellationReason
	 * Type:Dropdown
	 * Keys:Created in Error#Contact Withdrew Request#Duplicate#Interaction Ended
	 */
	public boolean cancelThisWork(String args[]){
		if(utils.clickAnelemnt(this.btnOtherActions, "GrievanceAndAppeals", "Other Actions"))
			if(utils.clickAnelemnt(this.lnkOtherCancelThisWork, "GrievanceAndAppeals", "Cancel This Work")) {
				utils.waitforpageload();
				if(utils.selectDropDownbyVisibleString(this.cancelDrpdown, args[0], "GrievanceAndAppeals", "Cancellation Reason"))
					return utils.clickAnelemnt(this.btnSubmit, "GrievanceAndAppeals", "Submit button");
			}
		return false;

	}


	@FindBy(xpath="//table[@class='gridTable '][@pl_prop='.ReviewedClaims']")
	private WebElement ClaimsTaggedForGA;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimsWithGATagged
	 * #Description:This method validates the 'Claims tagged for G&A' section displayed as part of Grievance and Appeals SR
	 * #Arguments:Claims Tagged
	 * Type:Textbox
	 */
	public boolean validateClaimsWithGATagged(String[] args){
		try{
			wait=new WebDriverWait(Driver.pgDriver,25);
			String claimlast4=args[0].substring(9);
			claimlast4="..."+claimlast4;
			String tempxpath="//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']";

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempxpath)));
			List<WebElement> img = Driver.pgDriver.findElements(By.xpath("//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']//ancestor::td[@headers='a9']//preceding-sibling::td//img"));
			if(img.get(0).isDisplayed() && img.get(1).isDisplayed()){
				blogger.loginfo("Grievance and Appeal is checked");
				return true;
			}else{
				blogger.loginfo("Grievance and Appeal isnt checked");
				err.logError("Unable to verify - Grievance and Appeal for Review");
				return false;
			}
		}
		catch (Exception e){
			System.out.println("Unable to verify - Claims Tagged For GA Review - Grievance and Appeal is not checked"+e);
			return false;
		}
	}

	@FindBy(xpath="//table[@pl_prop='.ReviewedAuthorizations']")
	private WebElement AuthorizationDiscussedTable;

	/*	
	 * @SCU
	 * #CommonMethodWithArgument:validateAuthorizationWithGATagged
	 * #Description:This functionality validates the Authorization number tagged or reviewed.
	 * #Argument:AuthorizationNumberWithGATagged
	 * Type:Table
	 * Keys:Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean validateAuthorizationWithGATagged(String[] args) throws InterruptedException 
	{
		try{
			WebElement row =utils.getProviderResultsBasedOnValues(this.AuthorizationDiscussedTable,args);
			if(row.findElement(By.xpath(".//td[@tabindex='0']//img[@title='Checked']")).isDisplayed() && row.findElement(By.xpath(".//td[@headers='a2']//img[@title='Checked']")).isDisplayed()){
				blogger.loginfo("Authorization Result matched:: Authorization Info Discussed and Authorization with GA Indicator is checked");
			}	
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input AuthorizationNumber" + e);
			return false;
		}
		return true;
	}

	//div[@data-node-id='AccessDocumentsGandA']//div[@string_type='paragraph']//p//span
	@FindBy(xpath="//div[@class='content-inner ']//p/span")
	WebElement writeUpASO;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateASOMsgInGATask
	 * #Description:This method validates the message displayed when funding type of Contract is ASO and Contract is in focus is MO,WI,CO or NV to guide the user in Grievance and Appeals Task
	 * #Arguments:PolicyState
	 * Type:Textbox
	 */
	public boolean validateASOMsgInGATask(String[] args){
		try{
			utils.waitforpageload();
			String L1 = "For the state of "+args[0]+" Grievance and Appeal request must sent in writing unless otherwise stated in the member's policy. Please consult the Evidence of Coverage (EOC) to see if the member's policy allows for verbal grievance and appeals.";
			String msg = this.writeUpASO.getText().trim();
			if(msg.equalsIgnoreCase(L1)){
				System.out.println("Message displayed in UI "+this.writeUpASO.getText().trim()+"\n");
				blogger.loginfo("Message displayed in UI and given by the user matched");
				return true;
			}else{
				System.out.println("Message displayed isnt the expected one "+this.writeUpASO.getText().trim()+"\nExpected msg is::"+L1);
				blogger.loginfo("Message displayed in UI and given by the user does not matched");
				return false;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "ASO Msg In GA Task is not displayed");
			System.out.println(""+e);
			return false;
		}
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateNoASOMsgInGATask
	 * #Description:This method validates no message being displayed when funding type of Contract is ASO and Contract is in focus is not in MO,WI,CO or NV
	 * #Arguments:PolicyState
	 * Type:Textbox
	 */
	public boolean validateNoASOMsgInGATask(String[] args){
		try{
			utils.waitforpageload();
			String L1 = "For the state of "+args[0]+" Grievance and Appeal request must sent in writing unless otherwise stated in the member's policy. Please consult the Evidence of Coverage (EOC) to see if the member's policy allows for verbal grievance and appeals.";
			String msg = this.writeUpASO.getText().trim();
			if(msg.equalsIgnoreCase(L1)){
				System.out.println("Message displayed in UI"+this.writeUpASO.getText().trim()+"\n");
				return false;
			}else{
				System.out.println("Message displayed isnt the expected one"+this.writeUpASO.getText().trim()+"\nExpected msg is::"+L1);
				return true;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "validateNoASOMsgInGATask");
			System.out.println(""+e);
			return true;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDisplayOfEOCLink
	 * Type:TextBox
	 * Description: This method validates the display of EOC Link in Grievance and Appeals Task
	 * and user clicks on it - to navigate to the CAD (Anthem.com Emulator) tool so that CSR can assist a member with online navigation steps to access their CDHP details.
	 */
	@FindBy(xpath="//a[@data-test-id='20160320111031086816437']")
	WebElement eocLink;

	public boolean verifyDisplayOfEOCLink() throws InterruptedException, AWTException{

		if(utils.validateHeader(this.eocLink, "Evidence of Coverage (EOC)"))
		{
			if(this.eocLink.isDisplayed()){
				utils.clickAnelemnt(eocLink, "Grivenace and Appeals", "Evidence of Coverage (EOC)");
				System.out.println("Document Type link is added to 'Grivenace and Appeals' task and user clicks the link");

				utils.waitforpageload();
				Set<String> Windows=Driver.pgDriver.getWindowHandles();
				System.out.println("THe window Size is: "+Windows.size());    
				int i=1;
				try {
					for (String window:Windows){                           
						Driver.pgDriver.switchTo().window(window);
						System.out.println("The "+i+"st window switched");
						i++;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				utils.waitforpageload();

				String title = Driver.pgDriver.getTitle().trim();
				System.out.println(title);
				if(title.contains("EOC")){
					System.out.println("WGS Large Group Evidence of Coverage (EOC) is launched - Title is"+ title); 
					return true;
				}else{
					err.logError("Grivenace and Appeals", "Error in switching to childwindow-EOC");
					return false;
				}
			}
			err.logError("Grivenace and Appeals", "EOC link is not displayed in - Grivenace and Appeals");
			return false;
		}
		System.out.println("EOC link is not displayed");
		err.logError("Grivenace and Appeals", "EOC link is not displayed");
		return false;
	}
	@FindBy(xpath="//span[text()='Verbal Grievance and Appeals allowed per the EOC:']")
	WebElement verbalQuestion;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateASOMsgInGATask
	 * #Description:This method validates the message displayed when funding type of Contract is ASO and Contract is in focus is MO,WI,CO or NV to guide the user in Grievance and Appeals Task
	 * Type:Textbox
	 */
	public boolean verifyDisplayOfVerbalGAAllowedPerEOC(){
		String expectedMsg = "Verbal Grievance and Appeals allowed per the EOC:";
		try{
			String errMsg = this.verbalQuestion.getText().trim();
			if(errMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - on GrievanceAndAppeals page"+errMsg);
				return true;
			}else{
				System.out.println("Message doesnt match while submit - on GrievanceAndAppeals page"+errMsg);
			}
		}catch(Exception e){
			err.logError("Unable to retrieve message, on 'GrievanceAndAppeals' page"+e);
		}
		return false;
	}

	@FindBy(xpath="//span[text()='Verbal Grievance and Appeals allowed per the EOC:']")
	private WebElement selectVerbalGALbl;

	@FindBy(id="IsVerbalGandAAllowedYes")
	private WebElement valueYes;

	@FindBy(id="IsVerbalGandAAllowedNo")
	private WebElement valueNo;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectVerbalEOCAllowed
	 * #Description:This method allows user to select 'Verbal GA allowed per EOC' as 'Yes or No'.
	 * #Arguments:VerbalEOCAllowed
	 * Type:Dropdown
	 * Keys:Yes#No
	 */
	public boolean selectVerbalEOCAllowed(String[] args){
		if(args[0].contains("Yes")){
			return utils.clickAnelemnt(this.valueYes, "Grievance and Appeals", "Verbal EOC Allowed");
		}
		else if(args[0].contains("No")){
			return utils.clickAnelemnt(this.valueNo, "Grievance and Appeals", "Verbal EOC Allowed");
		}
		return false;
	}

	@FindBy(xpath="//input[@id='IsVerbalGandAAllowedNo']//following::div[@class='content-inner ']//p")
	WebElement msgEOCForVerbalText;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateEOCMsgForVerbalAppealsNotAllowed
	 * #Description:This method verifies EOC message displayed when verbal appeals are not allowed.
	 * #Arguments:PolicyState and CompanyCode
	 * Type:Textbox
	 */
	public boolean validateEOCMsgForVerbalAppealsNotAllowed(String[] args){
		try{
			utils.waitforpageload();
			String L1 = "For the state of "+args[0]+"  Grievance and Appeal request must sent in writing. Advise the member to send their grievance and/or appeal request to "+args[1]+". In the request the member must include their Identification Number the reason for their complaint and their expected resolution to the complaint.";
			String msg = this.msgEOCForVerbalText.getText().replaceAll(",", "").trim();
			System.out.println("Msg: "+msg);
			System.out.println("L1: "+L1);
			if(msg.equalsIgnoreCase(L1)){
				blogger.loginfo("Message displayed in UI and given by the user matched");
				System.out.println("Message displayed in UI and given by the user matched");
				return true;
			}else{
				blogger.loginfo("Message displayed in UI and given by the user doesn't matched");
				System.out.println("Message displayed in UI and given by the user doesn't matched");
				return false;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "validateEOCMsgForVerbalAppealsNotAllowed");
			System.out.println(""+e);
			return false;
		}
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateNoEOCMsgForVerbalAppeals
	 * #Description:This method verifies no EOC message displayed when verbal appeals are allowed.
	 * #Arguments:PolicyState and CompanyCode
	 * Type:Textbox
	 */
	public boolean validateNoEOCMsgForVerbalAppeals(String[] args){
		try{
			utils.waitforpageload();
			String L1 = "For the state of "+args[0] +" Grievance and Appeal request must sent in writing. Advise the member to send their grievance and/or appeal request to "+args[1]+". In the request the member must include their Identification Number, the reason for their complaint and their expected resolution to the complaint.";
			String msg = this.msgEOCForVerbalText.getText().trim();
			if(msg.equalsIgnoreCase(L1)){
				System.out.println("Message displayed in UI"+this.msgEOCForVerbalText.getText().trim()+"\n");
				return false;
			}else{
				System.out.println("Message displayed isnt the expected one"+this.msgEOCForVerbalText.getText().trim()+"\nExpected msg is::"+L1);
				return false;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "validateNoEOCMsgForVerbalAppeals");
			System.out.println(""+e);
			return true;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:chooseGrievanceCategory
	 * #Description:This method allows the user to choose a Category for 'Grievance' Type in the Grievance and Appeals Task
	 * #Arguments:GrievanceCategory
	 * Type:Dropdown
	 * Keys:Access#Appeal Process#Attitude/Service#Benefit Cost Share#Billing#Billing -and- Finance#Claim#Cost Share#Coverage Determination Process#Cultural/Linguistic/Language Barrier#Discrimination#Dose Optimization#Enrollment -and- Billing#Enrollment/Disenrollment#Exception Process#Facility Appearance#Facility/Office Appearance#Failure to Notify of G-and-A Process#Fraud and Abuse#HIPAA#Incorrect Quantity Received#Late Enrollment Penalty#Low Income Subsidy#Marketing#Office Appearance#Parity#Plan/Benefit Information Not Received#Practioner Office Site#Premium Issue#Prior Auth Process#Prior Authorization Process#Process#Sales#Staff Behavior#Unsatisfactory Interaction#Wrong Info Provided#Accuracy of Filling Prescription#Administration of Incorrect Medication#Against Medical Advice#Assault#Care Coordination#Care Inappropriate#Complication of Treatment#Continuity or Coordination of Care#Delay in Authorization#Delay in Care Treatment#Delay in Writing Prescription#Delivery Issue#Drug Interactions#Extension#Failure to Expedite#HIPAA#Inadequate or Lack of Discharge Planning#Inappropriate Diagnostic Testing/Procedures#Lack of Appropriate Consultation#Medication Error#Miscommunication#Misdiagnosis#Pharmacist Would Not Fill Medication#Provider Type Inconsistent with Diagnosis#Referral Refusal#Refusal to Write Prescription Requested#Serious Self Harm#Suicide#Therapeutic Substitutions#Unexpected Outcome#Universal Precautions#Variance in Obtaining Test Results#Writing Incorrect Prescription
	 */
	public boolean chooseGrievanceCategory(String[] args){
		if(args[0].contains("-and-")){
			args[0].replaceAll("-and-", "&");	
		}else{
			System.out.println("Category chosen is :: "+args[0]);
		}
		return utils.selectDropDownbyVisibleString(this.GACategoryDrpdown, args[0], "GrievanceAndAppeals", "Category");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:chooseGrievanceSubCategory
	 * #Description:This method allows the user to choose a sub-Category for 'Grievance' Type in the Grievance and Appeals Task
	 * #Arguments:GrievanceSubCategory
	 * Type:Dropdown
	 * Keys:Adequacy of Office Hours#Adequate Office Hours#After Hours Access#Appointment Availability#Care Instructions#Closed Panel#Cultural#Delay#Delay in Delivery#Distance to Provider#Fax Access#Geographic Availability#Handicap Access#Internet#IP/PMG Delayed#IVR - Integrated Voice Response#Linguistics#Medical Records#Network Access#Network Disruption#Non Panel Provider#Open Access to Specialties#Out of Network#Patient Abandonment#Phone Access#Phone Wait Time#Physical Accessibility#Physical/Handicap Access#Referral Issues#Timely Access (CA Only)#Wait Time#Facility Staff#Inappropriate Response#Practioner#Rudeness#Staff Behavior#Staff Qualification#Unsatisfactory Interaction#Untimely Service#N/A#Applied Incorrect Coinsurance#Applied Incorrect Copayment#Applied Incorrect Deductible#Billing#Payment Dispute#Reimbursement Delay#Administrative Fee Issues#Balance Billing#Overcharging#Payment Accuracy#Payment Delay#Wrong Payee#Coinsurance#Coordination of Benefits#Copayment#Coverage Gap#Deductible#Maximum Allowable#Opt Out (SR)#Out of Pocket Maximum#Ethnicity/Cultural#Language#Age#Disability#Discrimination#Gender#Insurance#Race#Religion#Sexual Implication#Weight#Billing#COBRA#Coverage Determination Process#Enrollment/Disenrollment#Late Enrollment Penalty#Premium Issue#Rescission#Adequacy of Treatment Record Keeping#Adequacy of Waiting Room or Examining Room Space#Physical Appearance Cleanliness#Confidentiality/Privacy#Access to Records#Accounting of Disclosure#Confidential Communications#Privacy Violation#Request to Amend Protected Health Information#Restrict Disclosure#Applied in Error#Not Removed Timely#Appeal Process#Case Management Process#Disease Management Process#Grievance Process#Prior Authorization Process#Underwriting Process#Utilization Management Process#Agent Handling#Sales#Statement of Misrepresentation#Inappropriate Response#Miscommunication#Physician Incentive#Referral Delay#Referral Refusal#Refusal to Expedite Appeal/Grievance#Sexual Implication#Unclear Resolution#Incorrect Dosage Given#Incorrect Prescription Label Instructions#Incorrect Quantity Given#Wrong Medication#Damaged#Delay#Not Received#Adverse Drug Reaction#Allergic Reaction
	 */
	public boolean chooseGrievanceSubCategory(String[] args){
		if(args[0].contains("-and-")){
			args[0].replaceAll("-and-", "&");	
		}else{
			System.out.println("subCategory chosen is :: "+args[0]);
		}
		return utils.selectDropDownbyVisibleString(this.GASubCategoryDrpdown, args[0], "GrievanceAndAppeals", "SubCategory");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:chooseAppealCategory
	 * #Description:This method allows the user to choose a Category for 'Appeal' Type in the Grievance and Appeals Task
	 * #Arguments:AppealCategory
	 * Type:Dropdown
	 * Keys:Ambulance#Benefit Exclusion#Benefit Limitation#Centers of Excellence#Claim#Contract#Cosmetic#Custodial#Diagnostic Testing#Durable Medical Equipment#Educational Programs#Emergency Room#Exclusion#Home Health#Hospital Based Provider (SSB)#Infertility#Inpatient Admission#Maternity#Medical Procedures#Modifier#Neonatal Intensive Care#Opt Out (SR)#Pre Existing#Precertification#Precertification/ Pre Authorization#Precertification/Prior Authorization#Prior Authorization (SSB)#Referral#Second Opinion#Skilled Nursing#Surgical Procedure#Therapy#Untimely Filing of Appeal
	 */
	public boolean chooseAppealCategory(String[] args){
		if(args[0].contains("-and-")){
			args[0].replaceAll("-and-", "&");	
		}else{
			System.out.println("Category chosen is :: "+args[0]);
		}
		return utils.selectDropDownbyVisibleString(this.GACategoryDrpdown, args[0], "GrievanceAndAppeals", "Category");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:chooseAppealSubCategory
	 * #Description:This method allows the user to choose a sub-Category for 'Appeal' Type in the Grievance and Appeals Task
	 * #Arguments:AppealSubCategory
	 * Type:Dropdown
	 * Keys:Air Ambulance#Critical Care Transport#Ground Ambulance#Supplies#Comfort / Convenience Item#Contract Exclusion#Opt Out (SR)#Pre Ex#Regulatory Exclusion#Surgical Procedure#Vision#Benefit Limitation#Bariatric#Bariatric - Travel#Transplant#Authorization#Billing Dispute#California Only#Claims Editing#Cost Share#Disputing C-and-R Rates#Duplicate Claim#Multiple Services/Same Day#Out of Network#Timely Filing#Contract Allowance#Payor Claim Process Allowance Error#Recoding#NA#Genetic#Laboratory#Preventive vs Diagnostic#Radiology#Equipment#Orthotic#Prosthetic#Supply#Diabetic#Morbid Obesity#Nutritional Counseling#Emergency Room#Emergency Room Professional Services#Emergency Triage (Medicaid)#Contract Exclusion#Regulatory Exclusion#Diabetic Teaching#Home Assessment#Home Health#Hospice#Infusion Services#Therapy#Wound Care#Ambulance#Anesthesiologist#Cardiologist#Emergency Room Physician#Hospitalist/Physician#Laboratory#Pathologist#Radiologist#Administrative Days (SSB)#Length of Stay#Level of Care#Neonatal Intensive Care#Private Room#Rehabilitation#Skilled Nursing#Educational Program#Educational Programs#Length of Stay#Level of Care#Surrogate/Midwife#Dental#Diagnosis vs Treatment (i.e. TMJ, Autism, etc)#Hearing#Medical#Medical vs Nervous/Mental#Vision#Assistant Surgeon Eligibility/Non Eligibility 31#Distinct Procedural Service#Multiple Procedures#Other Bundling Edits#Professional Component#Reduction of Intensity of E-and-M Codes#Reduction of Intensity of Non E-and-M Codes#Sep Ident E-and-M Same Provider Same Day#Separate Identifiable E-and-M Same Provider Same Day#Surgical Team#Therapies/Modalities Per Date of Service#Two Surgeons#Unrelated E-and-M Same Provider Post Op#Unusual Anesthesia#Unusual Procedural Services#Length of Stay#Level of Care#Denied#Not Obtained#Cardiac#Cosmetic vs Medical#Dental#Ear, Nose -and- Throat#Eye#General Surgery#Implants#Neurological#Obstetrics/Gynecology#Orthopedic#Transplant#Urology#Acupuncture#Cardiac Rehabilitation#Chiropractic#Infusion#Neuro Rehabilitation#Occupational#Physical#Speech
	 */
	public boolean chooseAppealSubCategory(String[] args){
		if(args[0].contains("-and-")){
			args[0].replaceAll("-and-", "&");	
		}else{
			System.out.println("subCategory chosen is :: "+args[0]);
		}
		return utils.selectDropDownbyVisibleString(this.GASubCategoryDrpdown, args[0], "GrievanceAndAppeals", "SubCategory");
	}

	@FindBy(xpath="//div[contains(@data-hover,'showSmartTip')]//p//span")
	private WebElement instTextForMemAddress;
	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyInstTxtForMemberAddress
	 * #Description:This method allows the user to verify the instructional text is displayed for Member address in Grievance and Appeal Task
	 * Type:TextBox
	 */
	public boolean verifyInstTxtForMemberAddress(){
		String expectedMsg="Any correspondence related to the grievance or appeal will be mailed to the home address on file. Confirm the address with the contact.";
		try{
			String errMsg = this.instTextForMemAddress.getText().trim();
			if(errMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - instructional text is displayed for Member addres"+errMsg);
				return true;
			}else{
				System.out.println("instructional text doesnt match - on GrievanceAndAppeals page"+errMsg);
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve instructional text for member address, on 'GrievanceAndAppeals' page"+e);
		}
		return false;
	}

	@FindBy(xpath="//div[contains(@data-hover,'showSmartTip')]//p//span//img")
	private WebElement hoverImgMemAddrIcon;

	@FindBy(xpath="//div[contains(@data-hover,'showSmartTip')]//p//span//img//ancestor::div[contains(@data-hover,'showSmartTip')]")
	private WebElement hoverImgMemAddrIconTooltip;
	/*	
	 * @SCU
	 * #CommonMethodwithArgument:validateMemAddrOnHoveringInsTxtIcon
	 * #Description:This method validates whether member address is displayed when user hovers on the Icon for Instructional text in Grievance and Appeal Task
	 * #Arguments:MemberAddress
	 * Type:TextBox
	 */
	public boolean validateMemAddrOnHoveringInsTxtIcon(){
		try{
			String hoverTextExpected="If an address change is needed, launch the Member Maintenance task to complete the address change prior to submitting the Grievance and Appeal.";
			action.moveToElement(hoverImgMemAddrIcon).click().build().perform();
			String hoverTextActual=this.hoverImgMemAddrIconTooltip.getAttribute("data-hover").toString();
			if(hoverTextActual.contains(hoverTextExpected)){
				System.out.println("validateMemAddrOnHoveringInsTxtIcon successful in GA page");
				return true;
			}else{
				System.out.println("HoverText isnt displayed for Member Address hover Icon in GA page");
				return false;
			}
		}catch(Exception e){
			err.logcommonMethodError("GA","validateMemAddrOnHoveringInsTxtIcon"+e);
			System.out.println("Exception occured in GA - validateMemAddrOnHoveringInsTxtIcon"+e);
			return false;
		}
	}

	@FindBy(id="GandAIncidentStartDate")
	private WebElement incidentStartDate;

	@FindBy(xpath="//*[@data-test-id='2016012803055703183717743-Label']//span[text()='Incident Start Date']")
	private WebElement incidentStartDateLbl;

	@FindBy(id="GandAIncidentEndDate")
	private WebElement incidentEndDate;

	@FindBy(xpath="//*[@data-test-id='2016012803055703183717743-Label']//span[text()='Incident End Date']")
	private WebElement incidentEndDateLbl;
	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyIncidentStartAndEndDate
	 * #Description:This method verifies display of Incident Start and Incident End date in Grievance and Appeal Task
	 * Type:TextBox
	 */
	public boolean verifyIncidentStartAndEndDate(){
		if(utils.validateHeader(this.sHeaderGA, "Grievance And Appeals")){
			try{
				if(this.incidentStartDateLbl.isDisplayed() && this.incidentEndDateLbl.isDisplayed()){
					blogger.loginfo("Pass : Incident Start and Incident End date is present in Grievance and Appeal Task");
					return true;
				}
			}catch(Exception e){
				blogger.loginfo("Fail : Incident Start and Incident End date is not present in Grievance and Appeal Task"+e);
				err.logError("verifyIncidentStartAndEndDate", "Incident Start and Incident End date is not present in Grievance and Appeal Task");
				return false;
			}
		}
		err.logError("verifyIncidentStartAndEndDate", "Grievance And Appeal lblHdr is not displayed");
		return false;
	}

	/*	
	 * @SCU
	 * #CommonMethodwithArgument:enterIncidentStartAndEndDate
	 * #Description:This method enters value to Incident Start and Incident End date in Grievance and Appeal Task
	 * #Arguments:IncidentStartDate and IncidentEndDate
	 * Type:TextBox
	 */
	public boolean enterIncidentStartAndEndDate(String args[]){
		if(utils.enterTextinAnelemnt(this.incidentStartDate, args[0], "GrievanceAndAppeals", "IncidentStartDate")) {
			utils.waitforpageload();
			return utils.enterTextinAnelemnt(this.incidentEndDate, args[1], "GrievanceAndAppeals", "IncidentEndDate");
		}
		return false;
	}

	@FindBy(xpath="//*[@data-test-id='201801091013470060279-Label']//span[text()='Is the member in collections?']")
	private WebElement IsMemberInCollectionsLbl;

	@FindBy(id="IsMemberInCollectionsYes")
	private WebElement IsMemberInCollectionsYes;

	@FindBy(id="IsMemberInCollectionsNo")
	private WebElement IsMemberInCollectionsNo;
	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyIsMemberInCollections
	 * #Description:This method verifies display of 'Is the Member In Collections' with Yes and No options in Grievance and Appeal Task
	 * Type:TextBox
	 */
	public boolean verifyIsMemberInCollections(){
		try{
			if(this.IsMemberInCollectionsLbl.isDisplayed() && this.IsMemberInCollectionsYes.isDisplayed() && this.IsMemberInCollectionsNo.isDisplayed()){
				blogger.loginfo("Pass : 'Is the Member In Collections' with Yes and No options is present in Grievance and Appeal Task");
				return true;
			}else 
				return false;
		}catch(Exception e){
			blogger.loginfo("Fail : 'Is the Member In Collections' with Yes and No options is not present in Grievance and Appeal Task"+e);
			err.logError("verifyIsMemberInCollections", "'Is the Member In Collections' with Yes and No options is not present in Grievance and Appeal Task");
			return false;
		}
	}

	/*	
	 * @SCU
	 * #CommonMethodwithArgument:selectIsMemberInCollection
	 * #Description:This method selects radio 'Is the Member In Collections' with Yes or No options in Grievance and Appeal Task
	 * #Arguments:IsMemberInCollection
	 * Type:Dropdown
	 * Keys:Yes#No
	 */
	public boolean selectIsMemberInCollection(String args[]){
		if(args[0].equalsIgnoreCase("Yes")){
			return utils.clickAnelemnt(this.IsMemberInCollectionsYes,"GrievanceAndAppeals", "IsMemberInCollection Yes");
		}else{
			return utils.clickAnelemnt(this.IsMemberInCollectionsNo,"GrievanceAndAppeals", "IsMemberInCollection No");
		}
	}

	@FindBy(id="NameofCollectionAgency")
	private WebElement Name_of_Collection_Agency_TxtBox;

	@FindBy(id="ContactAtAgency")
	private WebElement Contact_at_Agency_TxtBox;

	@FindBy(id="AgencyPhoneNumber")
	private WebElement Phone_Number_TxtBox;

	@FindBy(id="AgencyAccountNumber")
	private WebElement Account_Number_TxtBox;

	/*	
	 * @SCU
	 * #CommonMethodwithArgument:enterValuesIfMemberInCollectionIsYes
	 * #Description:This method enters value to fields - 'Name of Collection Agency' 'Contact at Agency' 'Phone Number' 'Account Number' if 'Is the Member In Collections' is chosen as Yes in GandA Task
	 * #Arguments:MemberInCollection
	 * Type:Table
	 * Keys:Name of Collection Agency#Contact at Agency#Phone Number#Account Number
	 */
	public boolean enterValuesIfMemberInCollectionIsYes(String args[]){
		try{
			boolean returnvar=true;         
			for(String iterator : args)
			{
				String keyvaluepair = iterator;
				if(!returnvar)
				{
					err.logcommonMethodError("enterValuesIfMemberInCollectionIsYes", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				String key = iterator.substring(0, iterator.indexOf(":"));
				String value = iterator.substring(iterator.indexOf(":")+1);
				System.out.println("key " + key + "value  " + value);
				if(key.equalsIgnoreCase("Name of Collection Agency")){
					try{
						utils.enterTextinAnelemnt(this.Name_of_Collection_Agency_TxtBox, value, "GrievanceAndAppeals", "Name of Collection Agency");
						returnvar = true;
					}catch(Exception e){
						err.logError("GrievanceAndAppeals", "Exception occured while entering value to field 'Name of Collection Agency'");
						returnvar = false;
					}
					continue;}
				else if(key.equalsIgnoreCase("Contact at Agency")){
					try{
						utils.enterTextinAnelemnt(this.Contact_at_Agency_TxtBox, value, "GrievanceAndAppeals", "Contact at Agency");
						returnvar = true;	
					}catch(Exception e){
						err.logError("GrievanceAndAppeals", "Exception occured while entering value to field 'Contact at Agency'");
						returnvar = false;
					}
					continue;}
				else if(key.equalsIgnoreCase("Phone Number")){
					try{
						utils.enterTextinAnelemnt(this.Phone_Number_TxtBox, value, "GrievanceAndAppeals", "Phone Number");
						returnvar = true;	
					}catch(Exception e){
						err.logError("GrievanceAndAppeals", "Exception occured while entering value to field 'Phone Number'");
						returnvar = false;
					}
					continue;}
				else if(key.equalsIgnoreCase("Account Number")){
					try{
						utils.enterTextinAnelemnt(this.Account_Number_TxtBox, value, "GrievanceAndAppeals", "Account Number");
						returnvar = true;	
					}catch(Exception e){
						err.logError("GrievanceAndAppeals", "Exception occured while entering value to field 'Account Number'");
						returnvar = false;
					}
					continue;}
				else{
					err.logcommonMethodError("GrievanceAndAppeals", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
					returnvar = false;
				}
			}
			if(returnvar)
			{
				System.out.println("No issues in Key value pair");
				return true;
			}else{
				System.out.println("Issues in Entering value - Name of Collection Agency#Contact at Agency#Phone Number#Account Number ");
				return false;
			}

		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "Unable to enter value to the field IsMemberInCollection 'Yes'::"+e);
			return false;
		}
	}

	public boolean	verifyCategoryandSubcategory() throws Exception{
		utils.waitforpageload();
		utils.clickAnelemnt(rdoClinical, "GA", "Radio Clinical");
		ArrayList<HashMap<String, ArrayList<String>>> finalarry= new ArrayList<HashMap<String, ArrayList<String>>>();
		HashMap<String, ArrayList<String>> listKVP = new HashMap<String,ArrayList<String>>();
		utils.waitforpageload();
		Select category= new Select( Driver.pgDriver.findElement(By.id("GACategory")));	
		List<WebElement> categoryvalues =category.getOptions();
		ArrayList<String> keys= new ArrayList<>();
		for(int i=1;i<categoryvalues.size();i++)
			keys.add(categoryvalues.get(i).getText());
		int size=0;

		for(int k=0;k<keys.size();k++){		
			ArrayList<String> subactegoryvalues= new ArrayList<String>() ;
			category= new Select( this.GACategoryDrpdown);
			category.selectByIndex(k+1);
			utils.waitforpageload();
			Select selcesubcategory= new Select(this.GASubCategoryDrpdown);
			selcesubcategory.selectByIndex(1);
			List<WebElement> subcategory =selcesubcategory.getOptions();
			for(int j=1;j<subcategory.size();j++)
				subactegoryvalues.add(subcategory.get(j).getText());		
			listKVP.put(keys.get(k), subactegoryvalues);
			finalarry.add(listKVP);
			listKVP=new HashMap<String,ArrayList<String>>();
		}
		System.out.println(listKVP.size());
		System.out.println(keys.size());
		System.out.println(size);
		for(int i=0;i<finalarry.size();i++)
			System.out.println(finalarry.get(i));
		Data dt = new Data();
		dt.setCellDatas("Sheet1",finalarry);
		return true;	
	}

	/*	
	 * @SCU
	 * #CommonMethodwithArgument:verifyNoCompanyMsgWhenVerbalAppealsIsNo
	 * #Description:This method verifies a message being displayed when verbal appeals is chosen as 'No' and company name is blank
	 * #Arguments:PolicyState
	 * Type:Textbox
	 */
	public boolean verifyNoCompanyMsgWhenVerbalAppealsIsNo(String args[]){
		String expectedMsg = "For the state of "+args[0]+" Grievance and Appeal request must sent in writing. Check the EOC to see where they should send their appeal. In the request the member must include their Identification Number, the reason for their complaint and their expected resolution to the complaint.";
		try{
			String noCompanyCodeMsg = this.msgEOCForVerbalText.getText().trim();
			if(noCompanyCodeMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - on GrievanceAndAppeals page - when verbal appeals is chosen as 'No' and company name is blank:: "+noCompanyCodeMsg);
				blogger.loginfo("Message in UI and given by the user matched");
				return true;
			}else{
				err.logError("Message doesnt match - on GA page - when verbal appeals is chosen as 'No' and company name is blank::"+noCompanyCodeMsg);
				blogger.loginfo("Message in UI and given by the user doesn't matched");
				return false;
			}
		}catch(Exception e){
			err.logError("Unable to retrieve message, when verbal appeals is chosen as 'No' and company name is blank"+e);
			return false;
		}
	}

	@FindBy(xpath="//*[@data-test-id='201801091336160978109315-Label']//span[text()='Appeal Type:']")
	private WebElement AppealTypeLbl;

	@FindBy(id="AppealTypeAdministrative")
	private WebElement Appeal_AdministrativeRdoBtn;

	@FindBy(id="AppealTypeClinical")
	private WebElement Appeal_ClinicalRdoBtn;

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyAppealType
	 * #Description:This method verifies display of 'Appeal Type' with Administrative and Clinical options in Grievance and Appeal Task
	 * Type:Textbox
	 */
	public boolean verifyAppealType(){
		try{
			if(this.AppealTypeLbl.isDisplayed() && this.Appeal_AdministrativeRdoBtn.isDisplayed() && this.Appeal_ClinicalRdoBtn.isDisplayed()){
				System.out.println("'Appeal Type' with Administrative and Clinical options in Grievance and Appeal Task is displayed");
				return true;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "'Appeal Type' with Administrative and Clinical options in Grievance and Appeal Task is not displayed"+e);
		}
		return false;
	}

	/*	
	 * @SCU
	 * #CommonMethodwithArgument:selectAppealType
	 * #Description:This method verifies selects 'Appeal Type' either as Administrative and Clinical options in Grievance and Appeal Task
	 * #Arguments:AppealType
	 * Type:Dropdown
	 * Keys:Administrative#Clinical
	 */
	public boolean selectAppealType(String args[]){
		if(args[0].contains("Administrative")){
			return utils.clickAnelemnt(this.Appeal_AdministrativeRdoBtn, "GrievanceAndAppeals", "Appeal type - AdministrativeRdoBtn");
		}else if(args[0].contains("Clinical")){
			return utils.clickAnelemnt(this.Appeal_ClinicalRdoBtn, "GrievanceAndAppeals", "Appeal type - Clinical RdoBtn");
		}else{
			return false;
		}
	}

	@FindBy(xpath="//*[@data-test-id='201801091013470060279-Label']//span[text()='Service Type']")
	private WebElement ServiceTypeLbl;

	@FindBy(id="GandAServTypeNoParent")
	private WebElement ServiceTypeDrpdown;

	@FindBy(xpath="//select[@id='GandAServiceType'][@disabled]")
	private WebElement ServiceTypeDrpdownDisabled;

	@FindBy(xpath="//select[@id='GandAServiceType']//option[@value='Pre-Service'][@selected]")
	private WebElement selectServiceTypePreService;

	@FindBy(xpath="//select[@id='GandAServiceType']//option[@value='Post-Service'][@selected]")
	private WebElement selectServiceTypePostService;


	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyServiceTypeForAppeal
	 * #Description:This method verifies display of 'Service Type' for Appeal with 'Pre-Service' and 'Post-Service' as dropdown options
	 * Type:Textbox
	 */
	public boolean verifyServiceTypeForAppeal(){
		utils.waitforpageload();
		String args[] = {"Pre-Service","Post-Service"};
		ArrayList<String> serviceType = new ArrayList<String>(Arrays.asList(args));
		WebElement ServiceTypeDrpdown = Driver.pgDriver.findElement(By.id("GandAServiceType"));
		action.moveToElement(ServiceTypeDrpdown).click().build().perform();
		return utils.checkvaluesinDropDown(ServiceTypeDrpdown, serviceType);
	}

	/*	
	 * @SCU
	 * #CommonMethodwithArgument:selectServiceTypeForAppeal
	 * #Description:This method selects value for 'Service Type' for Appeal with 'Pre-Service' and 'Post-Service' as dropdown options
	 * #Arguments:ServiceType
	 * Type:Dropdown
	 * Keys:Pre-Service#Post-Service
	 */
	public boolean selectServiceTypeForAppeal(String args[]){
		return utils.selectDropDownbyVisibleString(this.ServiceTypeDrpdown, args[0], "GrievanceAndAppeals", "Service Type dropdown");
	}

	/*	
	 * @SCU
	 * #CommonMethodwithArgument:validateServiceTypeSelected
	 * #Description:This method validates the value selected for 'Service Type' for Appeal either as 'Pre-Service' and 'Post-Service'
	 * #Arguments:ServiceTypeSelected
	 * Type:Dropdown
	 * Keys:Pre-Service#Post-Service
	 */
	public boolean validateServiceTypeSelected(String args[]){
		if(args[0].contains("Pre-Service")){
			try{
				if(this.selectServiceTypePreService.isDisplayed()){
					System.out.println("'Service Type' with Pre-Service option is selected");
					return true;
				}
			}catch(Exception e){
				err.logError("GrievanceAndAppeals", "'Service Type' with Pre-Service option is not selected  and displayed"+e);
			}
			return false;
		}else if(args[0].contains("Post-Service")){
			try{
				if(this.selectServiceTypePostService.isDisplayed()){
					System.out.println("'Service Type' with Post-Service option is selected");
					return true;
				}
			}catch(Exception e){
				err.logError("GrievanceAndAppeals", "'Service Type' with Post-Service option is not selected and displayed"+e);
			}
			return false;
		}else{
			System.out.println("Enter valid value to select ServiceType");
			return false;
		}
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyServiceTypeIsDisabled
	 * #Description:This method verifies 'Service Type' for Appeal is disabled
	 * Type:Textbox
	 */
	public boolean verifyServiceTypeIsDisabled(){
		try{
			if(this.ServiceTypeDrpdownDisabled.isDisplayed()){
				System.out.println("Service Type Dropdown is displayed disabled");
				return true;
			}
		}catch(Exception e){
			err.logError("GrievanceAndAppeals", "Service Type Dropdown is not disabled"+e);
		}
		return false;
	}

	@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	private WebElement errGAText;
	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:validateExpeditedErrorMsg
	 * #Description:This method validates the Expedited error message being displayed, when 'Is this Expedited Appeal' question for ASO members is answered as 'Yes' and Expedited Appeal option is not selected
	 * Type:Textbox
	 */
	public boolean validateExpeditedErrorMsg(String args[]){
		String expectedMsg = "";
		try{
			String errMsg = this.errGAText.getText().trim();
			if(errMsg.equalsIgnoreCase(expectedMsg)){
				System.out.println("Message verified - when 'Is this Expedited Appeal' question for ASO members is answered as 'Yes' and Expedited Appeal option is not selected"+errMsg);
				return true;
			}else{
				err.logError("Message doesnt match while when 'Is this Expedited Appeal' question for ASO members is answered as 'Yes' and Expedited Appeal option is not selected"+errMsg);
			}
		}catch(Exception e){
			err.logError("Unable to retrieve ExpeditedError message - when 'Is this Expedited Appeal' question for ASO members is answered as 'Yes' and Expedited Appeal option is not selected, on 'GrievanceAndAppeals' page"+e);
		}
		return false;
	}

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyAlertToEnterFlaggedValues
	 * #Description:This method verifies alert prompt is displayed when no mandatory fields are entered,but proceeded to submit
	 * Type:Textbox
	 */
	public boolean verifyAlertToEnterFlaggedValues(){
		try{ 
			Alert a = new WebDriverWait(Driver.pgDriver, 20).until(ExpectedConditions.alertIsPresent());
			if(a!=null){
				System.out.println("Alert is present");
				Driver.pgDriver.switchTo().alert().accept();
				return true;
			}else{
				throw new Throwable();
			}
		} 
		catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false; 
		} 
	}

	@FindBy(xpath="//div[@node_name='GAAtegoryAndSubCategory']//p")
	WebElement txtWrittingMessageForVA;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateWritingMessageDisplayedForVAExpedited
	 * #Description: This functionality validates that the Writing message for VA member is displayed in the Grievance and Appeals page
	 * Type: Textbox
	 */
	public boolean validateWritingMessageDisplayedForVAExpedited()
	{
		try
		{
			String actualmsg = "The member's request for an Expedited Appeal must be done in writing and can be faxed to 866-273-3692 or sent in writing to Anthem Blue Cross Blue Shield, PO Box 27401, Richmond, VA 23279, Mail drop VA2002-N160. Inform the caller to include the member‘s identification number, a description of the member's issue and what the member’s expected outcome should be.";
			String expectedmsg = txtWrittingMessageForVA.getText();
			if(actualmsg.contains(expectedmsg))
			{
				blogger.loginfo("Actual message and expected message for VA Writing message is matched");
				System.out.println("Actual message and expected message for VA Writing message is matched");
				return true;
			}
			else
			{
				blogger.loginfo("Actual message and expected message for VA Writing message doesn't matched");
				System.out.println("Actual message and expected message for VA Writing message doesn't matched");
				return false;
			}
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("GrievanceAndAppeals", "validateWritingMessageDisplayedForVAExpedited", "Writing message for VA is not displayed");
			return false;

		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateWritingMessageIsNotDisplayedForNoVAExpedited
	 * #Description: This functionality validates that the Writing message for VA member is not displayed in the Grievance and Appeals page
	 * Type: Textbox
	 */
	public boolean validateWritingMessageIsNotDisplayedForNonVAExpedited()
	{
		return utils.isProxyWebelement(txtWrittingMessageForVA);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateNoASOMsgIsDisplayedInGATask
	 * #Description:This method validates that the ASO message is not displayed in the GA Task for CA member
	 * Type:Textbox
	 */
	public boolean validateNoASOMsgIsDisplayedInGATask(){
		return utils.isProxyWebelement(writeUpASO);
	}

	@FindBy(id="IsBehavioralHealth")
	WebElement chkBxBehaviorHealth;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickBehavioralHealthChckBox
	 * #Description:This functionality performs click action on the Behavioral Health Check box in the G and A page
	 * Type:Textbox
	 */
	public boolean clickBehavioralHealthChckBox()
	{
		return utils.clickAnelemnt(this.chkBxBehaviorHealth, "GrievanceAndAppeals", "Behavioral Health");
	}

	@FindBy(xpath="//div[@node_name='InWritingGandAMessageProvider']//p")
	WebElement txtWritingMessage;

	public boolean verifyGandAMessageForProviderInGandATask()
	{
		String actualmsg = "For providers that are requesting a grievance or appeal either on the members behalf or they are disputing it on their own behalf the request must sent in writing. Advise the provider to send their grievance and/or appeal request to: Anthem Grievance and Appeals P.O. Box 4310 Woodland Hills CA 91365";
		String expectedmsg = this.txtWritingMessage.getText().replaceAll("\n", " ");
		if(actualmsg.contains(expectedmsg))
		{
			blogger.loginfo("Writing message of actual and expected matched");
			System.out.println("Writing message of actual and expected matched");
			return true;
		}else
		{
			blogger.loginfo("Writing message of actual and expected doesn't matched");
			System.out.println("Writing message of actual and expected doesn't matched");
			return false;
		}
	}

	@FindBy(xpath="//div[@node_name='InWritingGandAMessageProvider']//p")
	WebElement txtAddressInWrittingMessage;

	@FindBy(xpath="//span[contains(text(),'For providers that are')]")
	WebElement txtInstructionalMsgForProviderFlow;



	public boolean validateTheAddressOnTheGAndATaskPageForProviderFlow(String[] args)
	{

		String actualText = args[0];
		System.out.println("Actual Text: "+actualText);
		String expectedText = txtAddressInWrittingMessage.getText().replaceAll("\n", " ").replaceAll(",", "");
		String expectedTextAfterSubstring = expectedText.substring(expectedText.indexOf(":")+1).trim();
		System.out.println("Expected Text: "+expectedTextAfterSubstring);
		if(actualText.equalsIgnoreCase(expectedTextAfterSubstring))
		{
			blogger.loginfo("Expected Address is displayed in the G and A page through Provider Flow and it matched");
			System.out.println("Expected Address is displayed in the G and A page through Provider Flow and it matched");
			return true;
		}else
		{
			blogger.loginfo("Expected Address is displayed in the G and A page through Provider Flow and it not matched");
			System.out.println("Expected Address is displayed in the G and A page through Provider Flow and it not matched");
			return false;
		}

	}


	public boolean validateTheProviderInstructionalTextMsgInGA(String[] args)
	{
		String actualText = args[0];
		System.out.println("Actual Text: "+actualText);
		String expectedText = txtInstructionalMsgForProviderFlow.getText().trim();
		System.out.println("Expected Text: "+expectedText);
		if(actualText.equalsIgnoreCase(expectedText))
		{
			blogger.loginfo("Instructional Text is displayed in the G and A page through Provider Flow and it is as expected");
			System.out.println("Instructional Text is displayed in the G and A page through Provider Flow and it is as expected");
			return true;
		}else
		{
			blogger.loginfo("Instructional Text is displayed in the G and A page through Provider Flow and not matched");
			System.out.println("Instructional Text is displayed in the G and A page through Provider Flow and not matched");
			return false;
		}

	}

}

