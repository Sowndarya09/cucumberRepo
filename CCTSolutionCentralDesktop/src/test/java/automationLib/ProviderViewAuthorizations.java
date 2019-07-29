package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.impl.xs.SubstitutionGroupHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ProviderViewAuthorizations {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);
	Actions action=new Actions(Driver.pgDriver);
	public ProviderViewAuthorizations()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 30), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		System.out.println("Navigated to frame 2");
	}

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//div[@node_name='ViewAuthorizations']//a[text()='MAS']")
	WebElement lnkViewAuthorizationMAS;

	@FindBy(xpath="//div[@node_name='ViewAuthorizations']//a[text()='Worknet']")
	WebElement lnkViewAuthorizationWorknet;

	@FindBy(xpath="//div[@node_name='AuthorizationSearchResults']//table[@class='gridTable ']")
	WebElement tableAuthorizationResults;

	@FindBy(xpath="//div[@node_name='ViewAuthorizations']//label[@for='pyFullName']/parent::div//div//span")
	WebElement labelMemberName;

	@FindBy(xpath="//table[@pl_prop='D_Authorizations.pxResults']")
	WebElement tblCaseLevelDetails;

	@FindBy(xpath="//tr[@id='$PD_Authorizations_pa3238678627057338pz$ppxResults$l1']//span[@class='expandRowDetails']")
	WebElement lnkExpandServiceLevelDetails;

	@FindBy(xpath="//table[@pl_prop='.AuthorizationServiceDetails']")
	WebElement tblServiceLevelDetails;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickonAuthorizationNumber
	 * #Description: This functionality clicks on the Authorization number by getting the input from the user.
	 * #Argument: Authorization Number
	 * Type: Textbox
	 */
	public boolean clickonAuthorizationNumber(String[] AuthorizationNumber)
	{
		try{
			String dynamicxpath="//table[@pl_prop='D_Authorizations.pxResults']//a[@data-test-id='201705092338250213198772'][text()='"+AuthorizationNumber[0]+"']";
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicxpath)));
			WebElement element=Driver.pgDriver.findElement(By.linkText(AuthorizationNumber[0]));
			action.moveToElement(element).click().build().perform();
			utils.pressEnter(element, "ViewAuthorizations", "Authorization Number link");
			utils.waitforpageload();
			return true;
		}
		catch(Exception e)
		{
			err.logError("Failed due to "+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnWorkNetLink
	 * #Description: This functionality clicks on the WorkNet Link in the View Authorizations Page
	 * Type: Textbox
	 */
	public boolean clickOnWorkNetLink()
	{
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", lnkViewAuthorizationWorknet);
		return utils.TabHandles("worknet.internal.das");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnMASLink
	 * #Description: This functionality clicks on the MAS Link in the View Authorization Page
	 * Type: Textbox
	 */
	public boolean clickOnMASLink()
	{	
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", lnkViewAuthorizationMAS);
		return utils.TabHandles("pd2.secure.wellpoint.com");
	}


	public boolean validateMemberName(String[] name)
	{
		if(this.labelMemberName.getText().toLowerCase().contains(name[0].toLowerCase()))
			return true;
		else
			return false;
	}

	public boolean validateAuthorizationTablebyRow(String[] rowvalues)
	{
		String headervalues=",Number,Authorization Type,Requesting Provider,Location,Status,Date";
		String[] headerValues=headervalues.toLowerCase().split(",");

		if(utils.validateTableRowHeader(this.tableAuthorizationResults, headerValues))
		{
			System.out.println("Checking row value");
			return utils.validateRowValues(this.tableAuthorizationResults, rowvalues);
		}
		else
			return false;
	}


	public boolean clickArrowServiceLevelDetails()
	{
		return utils.clickAnelemnt(lnkExpandServiceLevelDetails, "ViewAuthorizations", "Arrow");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateCaseLevelDetailsTable
	 * #Description: This functionality validates the Case Level Details Table with the values present in the application and given by the user
	 * #Argument: caseLevelDetails
	 * Type: Table
	 * keys: Creation Date#Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean validateCaseLevelDetailsTable(String[] caseleveldetails) 
	{
		return utils.validatetablerowbasedonvalues(this.tblCaseLevelDetails, caseleveldetails);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateCaseLevelDetailsTableRowandClickExpand
	 * #Description: This functionality validates the Case Level Details Table with the values present in the application and given by the user and click on the expand icon
	 * #Argument: caseLevelDetails
	 * Type: Table
	 * keys: Creation Date#Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean validateCaseLevelDetailsTableRowandClickExpand(String[] tablevalues) throws InterruptedException
	{

		WebElement tablerow = utils.returntablerowbasedonvalues(tblCaseLevelDetails, tablevalues);
		List<WebElement> rowCol = tablerow.findElements(By.tagName("td"));
		if(rowCol.size()>0)
		{
			rowCol.get(3).click();
			blogger.loginfo("Expand is clicked");
			return true;
		}
		return false;
	}


	public boolean validateServiceLevelDetailsTable(String[] serviceleveldetails) 
	{
		return utils.validatetablerowbasedonvalues(this.tblServiceLevelDetails, serviceleveldetails);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateServiceLevelDetailsTableRowandClickAuthNum
	 * #Description: This functionality validates the Service Level Details Table with the values present in the application and given by the user and click on the expand icon
	 * #Argument: serviceleveldetails
	 * Type: Table
	 * keys: Service From Date#Service To Date#Authorization Number#Service Provider#Service Provider Location#Record type#Pre Auth Type#Authorization Type#Status
	 */
	public boolean validateServiceLevelDetailsTableRowandClickAuthNum(String[] serviceleveldetails) throws InterruptedException 
	{
		WebElement tablerow = utils.returntablerowbasedonvalues(tblServiceLevelDetails, serviceleveldetails);
		List<WebElement> rowCol = tablerow.findElements(By.tagName("td"));
		if(rowCol.size()>0)
		{
			rowCol.get(2).click();
			System.out.println("Auth Num is clicked");
			return true;
		}
		return false;
	}

	BaseLogger blogger = new BaseLogger();

	@FindBy(xpath="//img[@data-test-id='20160127122348051611158']")
	private WebElement hoverImgGAIcon;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderViewAuthorizations;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyGAHoverTextInViewAuthorization
	 * #Description:This method verifies display of Grievance and Appeals Indicator and Hover text displayed in the View Authorization page
	 * Type:Textbox
	 */
	public boolean verifyGAHoverTextInViewAuthorization(){
		try{
			if(utils.validateHeader(sHeaderViewAuthorizations, "View Authorizations")){
				this.hoverImgGAIcon.click();
				String hovertext=this.hoverImgGAIcon.getAttribute("data-hover").toString().toLowerCase();
				System.out.println(hovertext);
				if(hovertext.contains("grievance and appeal")){
					blogger.loginfo("verifyGAHoverTextInViewAuthorization successful in View Authorizations page");
					return true;
				}else{
					blogger.loginfo("HoverText isnt displayed for GrievanceAndAppealsIcon in View Authorizations page");
					return false;
				}
			}else return false;
		}catch(Exception e){
			err.logError("ViewAuthorizations","verifyGAHoverTextInViewAuthorization"+e);
			blogger.loginfo("Exception occured in ViewAuthorizations - verifyGAHoverTextInViewAuthorization"+e);
			return false;
		}
	}

	@FindBy(xpath="//table[@pl_prop='D_Authorizations.pxResults']")
	private WebElement authorizationResults;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:selectAuthorizationDiscussedWithContact
	 * #Description:This functionality selects the 'Authorization Discussed with Contact' checkbox in View Authorization page
	 * #Argument:AuthorizationDetail
	 * Type:Table
	 * Keys:Creation Date#Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean selectAuthorizationDiscussedWithContact(String[] args) throws InterruptedException 
	{
		try{
			utils.waitforpageload();
			WebElement result = utils.getProviderResultsBasedOnValues(this.authorizationResults,args);
			result.findElement(By.xpath(".//input[contains(@id,'CheckReviewForContact')]")).click();
			System.out.println("Authorization Result matched::Successfully matched details and Authorization Info Discussed is checked");
		}catch(Exception e){
			err.logcommonMethodError("ViewAuthorizations","selectAuthorizationDiscussedWithContact"+e);
			System.out.println("Exception occured in selectAuthorizationDiscussedWithContact"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:selectGAIndicatorInAuthorization
	 * #Description:This functionality selects the GA Indicator checkbox in View Authorization page
	 * #Argument:AuthorizationDetail
	 * Type:Table
	 * Keys:Creation Date#Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean selectGAIndicatorInAuthorization(String[] args) throws InterruptedException 
	{
		try{
			utils.waitforpageload();
			WebElement result = utils.getProviderResultsBasedOnValues(this.authorizationResults,args);
			result.findElement(By.xpath(".//input[contains(@id,'TagGandA')]")).click();
			System.out.println("Authorization Result matched::Successfully matched details and Authorization Info with GA Indicator is checked");
		}catch(Exception e){
			err.logcommonMethodError("ViewAuthorizations","selectGAIndicatorInAuthorization"+e);
			System.out.println("Exception occured in selectGAIndicatorInAuthorization"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyAuthorizationDiscussedAndGAIndication
	 * #Description:This functionality verifies the GA Indicator and Authorization Discussed with contact checked in View Authorization page
	 * #Argument:AuthorizationCheck
	 * Type:Table
	 * Keys:Creation Date#Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean verifyAuthorizationDiscussedAndGAIndication(String[] args) throws InterruptedException 
	{

		try{
			utils.waitforpageload();
			WebElement result = utils.getProviderResultsBasedOnValues(this.authorizationResults,args);
			if(result.findElement(By.xpath(".//td//input[contains(@id,'CheckReviewForContact')][@checked]")).isDisplayed() && result.findElement(By.xpath(".//td//input[contains(@id,'TagGandA')][@checked]")).isDisplayed()){
				blogger.loginfo("Authorization Result matched:: Authorization Info Discussed and Authorization with GA Indicator is checked");
			}

		}catch(Exception e){
			err.logError("ViewAuthorizations","verifyAuthorizationDiscussedAndGAIndication"+e);
			System.out.println("Exception occured:: Authorization Info Discussed and Authorization with GA Indicator isnt checked"+e);
			return false;
		}
		return true;
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in 'View Authorizations' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit,"ViewAuthorizations","Submit Button");
	}

	@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	private WebElement errText;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateErrMsgInViewAuthorization
	 * #Description:This method validates message displayed when user selects with 'Grievance and Appeals Indicator' checked, but user doesnt select 'Authorization Detail Info' checked
	 * Type:Textbox
	 */
	public boolean validateErrMsgInViewAuthorization(){
		try{
			String errText=this.errText.getText().trim();
			System.out.println(errText);
			if(errText.equalsIgnoreCase("You have tagged 'Member has requested a Grievance or Appeal' for Pre-Authorization(s) or Referral(s) for Grievance or Appeal but not as being discussed. Either tag the same record for being discussed or uncheck the respective Pre-Authorization(s) or Referral(s) from having 'Grievance or Appeal' from 'View Authorization' screen and click Submit.")){
				blogger.loginfo("validateErrMsgInViewAuthorization successful in View Authorization page");
				return true;
			}else{
				err.logcommonMethodError("validateErrMsgInViewAuthorization","Expected  message doesnt match in View Authorization page");
				return false;
			}
		}catch(Exception e){
			err.logcommonMethodError("ViewAuthorizations","validateErrMsgInViewAuthorization"+e);
			blogger.loginfo("Exception occured in View Authorizations - validateErrMsgInViewAuthorization"+e);
			return false;
		}
	}

	@FindBy(linkText = "Pulse")
	private WebElement pulseLink;

	public boolean clickAndVeifyPulseLink(){
		if(utils.pressEnter(this.pulseLink, "ViewAuthorizations", "pulse link")) {
			utils.waitforpageload();
			new WebDriverWait(Driver.getPgDriver(),20).until(ExpectedConditions.numberOfWindowsToBe(2));
			return utils.TabHandles("pulse.antheminc.com/webcenter/portal");
		}
		return false;

	}

	@FindBy(xpath="//img[@data-test-id='20160127122348051611158']")
	WebElement gAndAIndicator;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyNoGandAIndicatorIsDisplayed
	 * #Description: This method clicks on Other Actions and verifies no Request Grievance and Appeals link is displayed
	 * Type:Textbox
	 */
	public boolean verifyNoGandAIndicatorIsDisplayed(){
		return utils.isProxyWebelement(gAndAIndicator);
	}

}
