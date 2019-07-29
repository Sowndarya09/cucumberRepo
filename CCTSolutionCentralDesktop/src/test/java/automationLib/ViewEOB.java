package automationLib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class ViewEOB {


	SeleniumUtilities utils = new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(), 20);
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	public ViewEOB() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		gotoLastIframe();

	}


	@FindBy(xpath="//label[@for='ServiceDates']/following-sibling::div/span")
	WebElement labelDatesOfService;


	@FindBy(id="ClaimText")
	WebElement drpDownClaimNumber;

	@FindBy(xpath="//div[@node_name='ViewRemit']//div[contains(text(),'Search')]")
	WebElement btnSearch;

	@FindBy(xpath="//a[contains(text(),'OnDemand')]")
	WebElement lnkOnDemand;

	@FindBy(xpath="//table[@pl_prop='.ViewRemitSelected.pxResults']//td/div/span/a[contains(text(),'11/13/2017')]")
	WebElement lnkRemitDate;

	//@FindBy(xpath="//div[@node_name='pyCaseActionAreaButtons']//div[contains(text(),'Submit')]")
	@FindBy(xpath="//button[@title='Complete this assignment']//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="//div[@string_type='paragraph']/div/p/span")
	WebElement txtErrorMessage;

	@FindBy(xpath="//label[contains(text(),'View Remit')]")
	WebElement headerViewRemit;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSearchButton
	 * #Description: This functionality performs click action on the Search button in the EOB section.
	 * Type: Textbox
	 */
	public boolean clickSearchButton()
	{
		return utils.clickAnelemnt(this.btnSearch, "ViewEOB", "Search");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSubmitButton
	 * #Description: This functionality performs click action on the Submit button in the EOB section.
	 * Type: Textbox
	 */
	public boolean clickSubmitButton()
	{
		return utils.clickAnelemnt(this.btnSubmit, "ViewRemit", "Submit");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyOnDemand
	 * #Description: This functionality verifies that the On Demand link is present or not in the View EOB page
	 * Type: Textbox
	 */
	public boolean verifyOnDemand()
	{
		return !utils.isProxyWebelement(lnkOnDemand);
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigatedToOnDemandLink
	 * #Description: This functionality clicks on the On Demand link and then navigates to the child window and then gets the title and then navigates back to the Parent window.
	 * Type: Textbox
	 */
	public boolean navigatedToOnDemandLink() throws InterruptedException
	{
		String parent = Driver.pgDriver.getWindowHandle();
		System.out.println("Parent Window ID: "+parent);
		if(utils.validateHeader(this.headerViewRemit, "View EOB")){
			if(this.lnkOnDemand.isDisplayed())
			{
				utils.clickAnelemnt(this.lnkOnDemand, "ViewEOB", "OnDemand Link");
				System.out.println(("OnDemand Is Clicked.."));
				Thread.sleep(3000);
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				System.out.println("Parent & Child Window ID: "+handles);
				System.out.println("No.ofwindows"+handles.size());
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				String title = Driver.pgDriver.switchTo().window(childWindow).getTitle().trim();
				System.out.println("Title of the Child Window is: "+title);
				if(title.contains("IBM Content Navigator for On Demand"))
				{
					System.out.println("On Demand Is Launched and the title is: "+ title); 
					Driver.pgDriver.switchTo().window(parent);
					String title1 = Driver.pgDriver.getTitle();
					System.out.println("Title of the Parent Window is: "+title1);
					return true;
				}else
				{
					err.logcommonMethodError("ViewEOB", "Error in switching to childwindow-On Demand");
					return false;
				}
			}
			err.logcommonMethodError("ViewEOB", "OnDemand link is not displayed in - View EOB page");
			return false;	
		}
		err.logcommonMethodError("ViewEOB", "View EOB is not loaded");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyErrorMessage
	 * #Description: This functionality verifies the error message displayed in the View EOB page when user searches for no EOB data.
	 * Type: Textbox
	 */
	public boolean verifyErrorMessage()
	{
		String ErrorMsgFromUser = "Service is not available. Use the OnDemand link to manually search for the EOB";
		String ErrorMsgFromApplication = this.txtErrorMessage.getText();
		return utils.isvalueMatch_contain(ErrorMsgFromUser, ErrorMsgFromApplication);
	}

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderViewEOB;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Email EOB']")
	private WebElement emailEOBLink;
	@FindBy(xpath="//a[@data-test-id='201802280900120484139502'][@disabled]")
	private WebElement emailEOBLinkDisabled;
	@FindBy(xpath="//table[@pl_prop='.ReviewedClaims']")
	private WebElement claimNumberTable;


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyEmailEOBLink
	 * #Description:This functionality verifies the display of Email EOB Link in the View EOB Page
	 * Type:TextBox
	 */
	public boolean verifyEmailEOBLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderViewEOB, "View/Send EOB"))
			return !utils.isProxyWebelement(emailEOBLink);
		return false;
	}

	public static String pdfPassword;
	@FindBy(xpath="//a[@class='Standard_task']")
	private WebElement serviceReqDetails;
	public WebElement getServiceReqDetails() {
		return serviceReqDetails;
	}


	public String retrieveServiceReqDetails()
	{
		String srText = this.getServiceReqDetails().getText().trim();
		String srDetails = srText.substring(srText.indexOf("(")+1,srText.indexOf(")")).trim();
		System.out.println("Service Request created is:"+srDetails);
		return srDetails;
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickEmailEOBLink
	 * #Description:This functionality clicks on Email EOB Link in the View EOB Page
	 * Type:TextBox
	 */
	public boolean clickEmailEOBLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderViewEOB, "View/Send EOB")) {
			pdfPassword = retrieveServiceReqDetails();
			return utils.clickAnelemnt(this.emailEOBLink, "ViewEOB", "Email EOB Link");
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyEmailEOBLinkDisabled
	 * #Description:This functionality verifies the Email EOB Link is disabled in the View EOB Page
	 * Type:TextBox
	 */
	public boolean verifyEmailEOBLinkDisabled(){
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderViewEOB, "View/Send EOB"))
			return !utils.isProxyWebelement(emailEOBLinkDisabled);
		return false;
	}

	@FindBy(xpath="//table[@pl_prop='.MemberClaim.ClaimDetailsSublist']//tr//td[@data-attribute-name='Claim Number']//span//a")
	private List<WebElement> claimNumberList;
	@FindBy(xpath="//table[@pl_prop='.MemberClaim.ClaimDetailsSublist']//tr//td[@data-attribute-name='Date(s) of Service']//span")
	private List<WebElement> DateofServiceList;
	private HashMap<String, String> claimAndDOSDetails;

	@FindBy(xpath="//table[@pl_prop='.MemberClaim.ClaimDetailsSublist']//td[@data-attribute-name='Claim Number']//span")
	private List<WebElement> claimNumberReviewList;
	@FindBy(xpath="//table[@pl_prop='.MemberClaim.ClaimDetailsSublist']//td[@data-attribute-name='Date(s) of Service']//span")
	private List<WebElement> DateofServiceReviewList;
	private HashMap<String, String> claimAndDOSReviewDetails;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateDisplayedEOBInUI
	 * #Description:This functionality validates the EOB details in the View EOB page and the details populated in Email EOB page
	 * Type:TextBox
	 */
	public boolean validateDisplayedEOBInUI(){
		try{
			this.claimAndDOSDetails = new HashMap<String, String>();
			for(int i=0;i<=claimNumberList.size();i++){
				this.claimAndDOSDetails.put(claimNumberList.get(i).getText(),DateofServiceList.get(i).getText());
			}
			System.out.println("Values in View/Send EOB screen"+claimAndDOSDetails);

			utils.clickAnelemnt(this.emailEOBLink, "ViewEOB", "Email EOB Link");

			for(int i=0;i<=claimNumberReviewList.size();i++){
				this.claimAndDOSReviewDetails.put(claimNumberReviewList.get(i).getText(),DateofServiceReviewList.get(i).getText());
			}
			System.out.println("Values in View/Send EOB screen"+claimAndDOSReviewDetails);

			Set<String> keys = claimAndDOSDetails.keySet();
			Set<String> reviewkeys = claimAndDOSReviewDetails.keySet();
			if(keys.size()==reviewkeys.size()){
				for(String key:keys)
				{
					System.out.println("The Claim Number in ViewEOB screen is: " + key);
					String testValue = claimAndDOSDetails.get(key);
					System.out.println("The 'Date of service' in ViewEOB screen is:" + testValue);
					String actualvalue = claimAndDOSReviewDetails.get(key);
					System.out.println("The 'Date of service' in ViewEOB pop-up is:" + actualvalue);
					if(utils.isvalueMatch_contain(testValue, actualvalue))
					{
						System.out.println("Values matched for Claim Number:"+key);
					}
					else{
						System.out.println("Values mismatched/not available for Claim Number in pop-up screen:"+key);
						return false;
					}

				}	}else{
					err.logError("validateDisplayedEOBInUI", "The UI values returned in View EOB and Send EOB pop-ups are not equal");
					return false;
				}
		}catch(Exception e){
			err.logError("validateDisplayedEOBInUI", "Values mismatch in View EOB and Send EOB pop-ups - Values doesnt match properly");
			return false;
		}
		return true;
	}

	@FindBy(xpath="//table[@pl_prop='.MemberClaim.ClaimDetailsSublist']//td//input[contains(@id,'CaseOrTaskIcon')]")
	private List<WebElement> claimNumberReviewRadioBtn;

	@FindBy(xpath="//table[@pl_prop='.MemberClaim.ClaimDetailsSublist']//td//input[contains(@id,'CaseOrTaskIcon')][@checked]")
	private WebElement claimNumberReviewRadioBtnChecked;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateOneDefaultEOBChecked
	 * #Description:This functionality validates the EOB detail is checked by default in Email EOB page, if a single detail is populated
	 * Type:TextBox
	 */
	public boolean validateOneDefaultEOBChecked(){
		if(this.claimNumberReviewList.size()==1)
			return !utils.isProxyWebelement(claimNumberReviewRadioBtnChecked);
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectEOBsToEmail
	 * #Description:This functionality selects the EOB details to be checked in Email EOB page
	 * #Arguments:Select EOBs
	 * Type:TextBox
	 */
	public boolean selectEOBsToEmail(String args[]){
		utils.waitforpageload();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+args[0]+"']//ancestor::td[@data-attribute-name='Claim Number']")));
		//Driver.pgDriver.findElement(By.xpath("//tr[@data-gargs='[\""+args[0]+"\"]']//input")).click();
		WebElement xpath = Driver.pgDriver.findElement(By.xpath("//span[text()='"+args[0]+"']//ancestor::td[@data-attribute-name='Claim Number']//preceding-sibling::td//input"));
		return utils.clickAnelemnt(xpath, "ViewEOB", "EOB To mail");

	}

	@FindBy(id="MemberEmailID")
	private WebElement emailRecipient;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyEmailReceipientPopulated
	 * #Description:This functionality verifies the email id pre-populated in Email EOB page
	 * #Arguments:EmailID
	 * Type:TextBox
	 */
	public boolean verifyEmailReceipientPopulated(String args[]){
		String expectedText = emailRecipient.getText().trim();
		String actualText = args[0];
		return utils.isvalueMatch_contain(actualText, expectedText);
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterEmailReceipient
	 * #Description:This functionality enters the value to email id field in Email EOB page
	 * #Arguments:EmailID
	 * Type:TextBox
	 */
	public boolean enterEmailReceipient(String args[]){
		utils.waitforpageload();
		return utils.enterTextinAnelemnt(this.emailRecipient, args[0], "ViewEOB", "Email receipient");
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Send Email']")
	private WebElement sendEmailBtn;
	@FindBy(xpath="//button[@data-test-id='2018022815045107204865'][@disabled]")
	private WebElement sendEmailBtnDisabled;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Close']")
	private WebElement closeBtn;
	@FindBy(xpath="//span[contains(text(),'Email has been sent')]")
	private WebElement mailSentText;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSendEmail
	 * #Description:This functionality clicks on Send Email button in Email EOB screen
	 * Type:TextBox
	 */
	public boolean clickOnSendEmail(){
		utils.waitforpageload();
		return utils.clickAnelemnt(this.sendEmailBtn, "ViewEOB", "Send Email");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifySendEmailIsDisabled
	 * #Description:This method verifies the SendEmail button is disabled in the View EOB Page
	 * Type: Textbox
	 */
	public boolean verifySendEmailIsDisabled()
	{
		try{
			boolean bol = this.sendEmailBtnDisabled.isDisplayed();
			System.out.println("Send Email Button disabled is: "+ bol);
			if(bol=true){
				System.out.println("Send Email in View EOB pop-up is disabled");
				return true;
			}else{
				err.logError("verifySendEmailIsDisabled", "Send Email in View EOB pop-up is enabled");
				return false;
			}
		}catch(Exception e){
			err.logError("verifySendEmailIsDisabled", "Unable to retrieve or lcoate the element::Send Email in View EOB pop-up"+e);
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnClose
	 * #Description:This functionality clicks on Close button in Email EOB screen
	 * Type:TextBox
	 */
	public boolean clickOnClose(){
		return utils.clickAnelemnt(this.closeBtn, "ViewEOB", "Close Button");
	}

	@FindBy(xpath="//label[@for='AttachmentPassword']//following-sibling::div//span[@data-test-id='20180228153756017028203']")
	private WebElement emailPWD;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validatePDFPassword
	 * #Description:This functionality validated the PDF password generated in Email EOB screen
	 * Type:TextBox
	 */
	public boolean validatePDFPassword(){
		String anthemPwd = "anthem"+pdfPassword.substring(pdfPassword.length()-4);
		String actualText = emailPWD.getText().trim();
		return utils.isvalueMatch_contain(actualText, anthemPwd);
	}

	@FindBy(xpath="//p//span[contains(text(),'EOB document is not available')]")
	private WebElement noEOBDocsMsg;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyNoEOBDocumentMsgIsDisplayed
	 * #Description:This method validates the EOB message displayed when no documents are available
	 * Type:TextBox
	 */
	public boolean verifyNoEOBDocumentMsgIsDisplayed(){

		return !utils.isProxyWebelement(noEOBDocsMsg);
	}

	//Sprint 7.1

	@FindBy(xpath="//div[@data-test-id='201901221403150988443959']")
	WebElement ErrorMsgMoreThanFiveRecords;
	/**
	 * This method validates the guided dialog displayed when more than 5 EOB records is selected
	 * @param args
	 * @return
	 */
	public boolean validateErrorMessageWhenMoreThanFiveRecordsSelected(String[] args)
	{
		return utils.isvalueMatch_contain(args[0], ErrorMsgMoreThanFiveRecords.getText().replaceAll("\n", ""));
	}

	@FindBy(xpath="")
	WebElement ResponseMessage;
	/**
	 * This method validates the response message on the View EOB page
	 * @param args
	 * @return
	 */
	public boolean validateTheResponseMessage(String[] args)
	{
		return utils.isvalueMatch_contain(args[0], ResponseMessage.getText().replaceAll("\n", ""));
	}


	/**
	 * THis method selects the check box of the given claim number in the view eob table
	 */

	@FindBy(xpath="//table[@pl_prop='.MemberClaim.ClaimDetailsSublist']")
	WebElement tblViewEOB;



	public boolean selectClaimNumberToEmailEOB(String[] tablevalues) throws InterruptedException
	{
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblViewEOB, tablevalues);
			List<WebElement> chckBox = row.findElements(By.tagName("input"));
			chckBox.get(1).click();
			return true;
		}catch(Exception e)
		{
			return false;
		}

	}
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;

	public void gotoLastIframe(){
		System.out.println("1");
		Driver.getPgDriver().switchTo().defaultContent();
		System.out.println("2");
		
		int i=this.iframes.size();
		System.out.println(i);
		Driver.getPgDriver().switchTo().frame(i-1);
		System.out.println("##########");
	}
}
