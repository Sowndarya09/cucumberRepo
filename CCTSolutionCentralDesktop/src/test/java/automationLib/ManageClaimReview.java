package automationLib;

import java.util.ArrayList;
import java.util.List;

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

public class ManageClaimReview {

	SeleniumUtilities utils= new SeleniumUtilities();

	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;
	
	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//li[@title='Request Adjustment']")	
	private WebElement lnkOthrActionsRequestAdjusment;

	@FindBy (xpath="//li[@title='Request Manager/OE Help']")	
	private WebElement lnkOthrActionsRequestManagerHelp;

	@FindBy (xpath="//li[@title='View/Send EOB']")	
	private WebElement lnkOthrActionsViewEOB;
	@FindBy (xpath="//li[@title='Send EOB']")	
	private WebElement lnkOthrActionsSendEOB;
	@FindBy (xpath="//li[@title='Search For Claim']")	
	private WebElement lnkOthrActionsSearchForClaim;

	/**
	 * Constructor 	
	 */

	public ManageClaimReview()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		gotoLastIframe();
		/*try{
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}catch(Exception e){
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
		}// change the driver 
*/	}

	
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigatetoRequestAdjusment
	 * #Description: This functionality navigates to the Request Adjustment section from the Manage Claim Review page
	 * Type: Textbox
	 */
	public boolean navigatetoRequestAdjusment(String[] args) throws InterruptedException
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, args[0], "ManageClaimReview", "Request Adjustment");
	}
	
	public boolean navigatetoRequestAdjusmentwithGandAOpen() throws InterruptedException
	{
		utils.waitforpageload();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement2);
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "Request Adjustment", "ManageClaimReview", "Request Adjustment");
	}


	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy (xpath="//li[@title='View Remit']")	
	WebElement lnkOthrActionsViewRemit;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToViewRemit
	 * #Description: This functionality navigates to the View Remit section from the Manage Claim Review page
	 * Type: Textbox
	 */
	public boolean navigateToViewRemit()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ViewClaimDetails", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsViewRemit, "ViewClaimDetails", "View Remit");
		return false;
	}
	
	
	
	/**
	 * This method will allow user to navigate Grievance and appeals task through other action from view claim detail page
	 * @return
	 */
	public boolean navigatetoRequestGrievanceAndAppeals()
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Grievance and App...", "ManageClaimReview", "Request Medical Review");
	}

	@FindBy(xpath="//label[contains(text(),'Manage Claim Review')]")
	WebElement sHeader;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateTheTitleOnClickingSubmit
	 * #Description: This functionality validates the Title of the page displayed after clicking submit in the View Remit page
	 * Type: Textbox
	 */
	public boolean validateTheTitleOnClickingSubmit()
	{
		return utils.validateHeader(sHeader, "Manage Claim Review");
	}

	@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	private WebElement errGAText;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateGAMsgInManageClaimReview
	 * #Description:This method validates message displayed when user submits with 'Grievance and Appeals Indicator' checked, but user doesnt launch 'Grievance and Appeals' task
	 * Type:Textbox
	 */
	public boolean validateGAMsgInManageClaimReview(){
		try{
			String errGAText=this.errGAText.getText().trim();
			System.out.println(errGAText);
			if(errGAText.equalsIgnoreCase("You have tagged Claim(s) indicating a Grievance or Appeal but have not opened a Grievance and Appeal Task. Open the Grievance and Appeal task from the other actions or uncheck the respective claim indicating a 'Grievance or Appeal' from 'View Claim Details' screen and click Submit.")){
				blogger.loginfo("validateGAMsgInManageClaimReview successful in Manage Claims page");
				return true;
			}else{
				err.logcommonMethodError("validateGAMsgInManageClaimReview","Expected GA message doesnt match in Manage Claims Review page");
				return false;
			}
		}catch(Exception e){
			err.logcommonMethodError("Manage Claims Review","validateGAMsgInManageClaimReview"+e);
			blogger.loginfo("Exception occured in Manage Claims  Review- validateGAMsgInManageClaimReview"+e);
			return false;
		}
	}

	@FindBy(xpath="//table[@class='gridTable '][@pl_prop='.ReviewedClaims']")
	private WebElement ClaimsTaggedForGA;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimNumberGATagged
	 * #Description:This method validates the Claim Number tagged with GA Indicator checked.
	 * #Arguments:ClaimNumberTagged
	 * Type:Textbox
	 */
	public boolean validateClaimNumberGATagged(String[] args){  
		try{
			wait=new WebDriverWait(Driver.pgDriver,25);
			String claimlast4=args[0].substring(9);
			claimlast4="..."+claimlast4;
			String tempxpath="//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']";

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempxpath)));
			List<WebElement> img = Driver.pgDriver.findElements(By.xpath("//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']//ancestor::td[@headers='a9']//preceding-sibling::td//img"));
			if(img.get(1).isDisplayed()){
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

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimNumberTagged
	 * #Description:This functionality validates the Claim number tagged or reviewed
	 * #Arguments:ClaimNumberTagged
	 * Type:Textbox
	 */
	public boolean validateClaimNumberTagged(String[] args){
		try{
			wait=new WebDriverWait(Driver.pgDriver,25);
			String claimlast4=args[0].substring(9);
			claimlast4="..."+claimlast4;
			String tempxpath="//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']";

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempxpath)));
			List<WebElement> img = Driver.pgDriver.findElements(By.xpath("//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']//ancestor::td[@headers='a9']//preceding-sibling::td//img"));
			if(img.get(0).isDisplayed()){
				blogger.loginfo("Claim Info Discussed with Contact is checked");
				return true;
			}else{
				blogger.loginfo("Claim Info Discussed with Contact isnt checked");
				err.logError("Unable to verify - Claim Info Discussed with Contact for Review");
				return false;
			}
		}
		catch (Exception e){
			err.logError("Unable to verify - Claim Info Discussed with Contact for Review"+e);
			return false;
		}
	}

	@FindBy(name="$PpyWorkPage$pPrimaryReasonforBilling")
	private WebElement reasonForContact;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectDropDownReasonForContact
	 * #Description:This functionality selects the value in the Reason For Contract drop down
	 * #Arguments:ReasonForContact ClaimType
	 * Type:Dropdown
	 * Keys:Select#Discuss deductible/coinsurance/copay/cost shares#Explain explanation of benefits (EOB)#Explain provider remittance advice (RA)#Explain how claim processed#Explain this letter or payment received#File a claim#Locate claim or payment#Provide additional information#Request an adjustment#Request correspondence or reprint#Update other insurance
	 */
	public boolean selectDropDownReasonForContact(String[] args){
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(this.reasonForContact, args[0], "ManageClaimReview", "Reason for Contact");   

	}

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Search For Claim']")
	private WebElement lnkOtherRequestSearchForClaim;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Medical Review']")
	private WebElement lnkOtherRequestRequestMedicalReview;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Adjustment']")
	private WebElement lnkOtherRequestRequestAdjustment;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Process Claim Image']")
	private WebElement lnkOtherRequestProcessClaimImage;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='View EOB']")
	private WebElement lnkOtherRequestViewEOB;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='View Remit']")
	private WebElement lnkOtherRequestViewRemit;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Perform Adjustment']")
	private WebElement lnkOtherRequestPerformAdjustment;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Send EOB']")
	private WebElement lnkOtherRequestSendEOB;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Grievance and App...']")	
	private WebElement lnkOtherRequestGandA;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Manager/OE Help']")
	private WebElement lnkOtherReqMgrHelp;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderManageClaimReview;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement3;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionsRequestGrievanceandAppeals
	 * #Description: This method clicks on Other Actions and selects Request Grievance and Appeals link
	 * Type:Textbox
	 */
	public boolean clickOtherActionsRequestGrievanceandAppeals(){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageClaimReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherRequestGandA, "ManageClaimReview", "Request Grievance and Appeals"))
			{
				utils.waitforpageload();
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement3);
				return utils.validateHeader(this.sHeaderManageClaimReview,"Grievance and Appeals");
			}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActionsDoesntDisplayRequestGA
	 * #Description: This method clicks on Other Actions and verifies no Request Grievance and Appeals link is displayed
	 * Type:Textbox
	 */
	public boolean verifyOtherActionsDoesntDisplayRequestGA(){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageClaimReview", "Other Actions button"))
		{
			if(utils.clickAnelemnt(this.lnkOtherRequestGandA, "ManageClaimReview", "Request Grievance and Appeals")){
				utils.waitforpageload();
				if(utils.validateHeader(this.sHeaderManageClaimReview,"Grievance and Appeals")){
					err.logError("ManageClaimReview","Able to locate 'Request Grievance and Appeals' in other actions");
					return false;
				}
				return true;
			}
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionRequestManagerHelp
	 * #Description:This method clicks on Other Action and select Request Manager Help 
	 * Type:Textbox
	 */
	public boolean clickOtherActionRequestManagerHelp(){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageClaimReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherReqMgrHelp, "ManageClaimReview", "Request Manager Help"))
				return utils.validateHeader(this.sHeaderManageClaimReview,"Request Manager/OE Help");
		return false;
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in 'Manage Claims Review' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmit() throws InterruptedException{
		Thread.sleep(5000);
		utils.scrolltomiddle();
		try{
			JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
			executor.executeScript("arguments[0].click();", btnSubmit);
			blogger.loginfo("Submit clicked successfully - ManageClaimReview page");
			return true;
		}catch(Exception e){
			err.logcommonMethodError("clickOnSubmit", "Unable to click on Submit button in 'ManageClaimReview' page"+e);
			err.logError(e,"Unable to Submit - ManageClaimReview page");
			return false;
		}
	}

	public boolean clickSubmit()
	{
		return utils.clickAnelemnt(btnSubmit, "Manage Claim Review", "btnSubmit");
		/*try {
		Thread.sleep(10000);
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", btnSubmit);
		blogger.loginfo("Submit clicked successfully - ManageClaimReview page");
		utils.waitforpageload();
		return true;
		}catch(Exception ex) {
			err.logcommonMethodError("clickOnSubmit", "Unable to click on Submit button in 'ManageClaimReview' page"+ex);
			err.logError(ex,"Unable to Submit - ManageClaimReview page");
			return false;
		}*/
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:SelectOptionsInOtherActions
	 * #Description:This method clicks on Other Actions and selects link of user's choice
	 * #Arguments:Other Actions
	 * Type:Dropdown
	 * Keys:Search For Claim#Request Medical Review#Request Adjustment#Request Grievance And Appeals#Request Manager Help#Process Claim Image#View EOB#View Remit#Perform Adjustment#Send EOB
	 */
	public boolean SelectOptionsInOtherActions(String[] args){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageClaimReview", "Other Actions button")) {
			try{
				if(args[0].equalsIgnoreCase("Search For Claim")){
					return utils.clickAnelemnt(this.lnkOtherRequestSearchForClaim, "ManageClaimReview", "Search For Claim");
				}else if(args[0].equalsIgnoreCase("Request Medical Review")){
					return utils.clickAnelemnt(this.lnkOtherRequestRequestMedicalReview, "ManageClaimReview", "Request Medical Review");
				}else if(args[0].equalsIgnoreCase("Request Adjustment")){
					return utils.clickAnelemnt(this.lnkOtherRequestRequestAdjustment, "ManageClaimReview", "Request Adjustment");
				}else if(args[0].equalsIgnoreCase("Process Claim Image")){
					return utils.clickAnelemnt(this.lnkOtherRequestProcessClaimImage, "ManageClaimReview", "Process Claim Image");
				}else if(args[0].equalsIgnoreCase("View EOB")){
					return utils.clickAnelemnt(this.lnkOtherRequestViewEOB, "ManageClaimReview", "View EOB");
				}else if(args[0].equalsIgnoreCase("View Remit")){
					return utils.clickAnelemnt(this.lnkOtherRequestViewRemit, "ManageClaimReview", "View Remit");
				}else if(args[0].equalsIgnoreCase("Perform Adjustment")){
					return utils.clickAnelemnt(this.lnkOtherRequestPerformAdjustment, "ManageClaimReview", "Perform Adjustment");
				}else if(args[0].equalsIgnoreCase("Send EOB")){
					return utils.clickAnelemnt(this.lnkOtherRequestSendEOB, "ManageClaimReview", "Send EOB");
				}else if(args[0].equalsIgnoreCase("Request Grievance and Appeals")){
					return utils.clickAnelemnt(this.lnkOtherRequestGandA, "ManageClaimReview", "Request Grievance and Appeals");
				}else if(args[0].equalsIgnoreCase("Request Manager Help")){
					return utils.clickAnelemnt(this.lnkOtherReqMgrHelp, "ManageClaimReview", "Request Manager Help");
				}else{
					err.logError("ManageClaimReview", "Please check the input to be valid to select from 'Other Actions'");
					return false;
				}
			}
			catch (Exception e){
				err.logError("ManageClaimReview", "SelectOptionsInOtherActions"+e);
				return false;
			}
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:navigateToViewEOB
	 * #Description:This functionality navigates to the View EOB Page from the Manage Claim Review page
	 * Type: Textbox
	 */
	public boolean navigateToViewEOB()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsViewEOB, "Manage Claim Review", "View/Send EOB"))
				return utils.validateHeader(this.sHeaderManageClaimReview, "View/Send EOB");
		return false;

	}

	@FindBy(xpath="//span[text()='EOBs Sent']")
	private WebElement eobSentSection;

	/*	
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyEOBSentSection
	 * #Description:This method verifies EOB sent section displayed in Manage Claims Review page
	 * Type:Textbox
	 */
	public boolean verifyEOBSentSection(){
		return utils.clickAnelemnt(this.eobSentSection, "ManageClaimReview", "EOB Sent Section");
	}

	@FindBy(xpath="//table[@pl_prop='.SentEOBs']")
	private WebElement eobSentTable;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateEOBSentSection
	 * #Description:This method validates data displayed in EOB sent section displayed in Manage Claims Review page
	 * #Arguments:EOBSentDetailsTable
	 * Type:Table
	 * Keys:#Claim Id#Document ID#Type#PDF#Sent To
	 */
	public boolean validateEOBSentSection(String args[]) throws InterruptedException{
		return utils.clickontablerowbasedonvalues(this.eobSentTable,args);	
	}

	@FindBy(xpath="//a[@class='Standard_task']")
	private WebElement serviceReqDetails;

	@FindBy(id="pySearchText")
	WebElement searchText;

	@FindBy(xpath="//i[@class='icons']//*[@name='CPMSearch_pyDisplayHarness_2']")
	WebElement cpmSearchIcon;

	@FindBy(xpath="//a[@data-test-id='20160210145727026023512']")
	WebElement searchResults;

	@FindBy(xpath="//span[text()='Resolved-Completed']")
	WebElement resolveCompletedStatus;

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
	 * #CommonMethodwithoutArgument:clickOnSubmitAndVerifySR
	 * #Description:This method clicks on submit button and performs case search on the SR request ID and validates Email password
	 * Type:Textbox
	 */
	public boolean clickOnSubmitAndVerifySR(){
		try{
			String SR = retrieveServiceReqDetails();
			utils.scrolltomiddle();
			utils.clickAnelemnt(this.btnSubmit, "ManageClaimReview", "Submit Button");
			utils.waitforpageload();
			Driver.getPgDriver().switchTo().defaultContent();
			utils.enterTextinAnelemnt(this.searchText, SR, "ManageClaimReview", "Case Search");
			utils.clickAnelemnt(this.cpmSearchIcon, "ManageClaimReview","Search Icon");
			if(utils.clickAnelemnt(this.searchResults, "ManageClaimReview", "Results Hyperlink")){
				Thread.sleep(4000);
				if(this.resolveCompletedStatus.isDisplayed()){
					System.out.println("SR Status is: Resolved-Completed");
					return true;
				}else{
					err.logError("ManageClaimReview", "SR Status is not Resolved-Completed!!");
					return false;
				}
			}
			else{
				err.logError("ManageClaimReview", "Search results are not available for the SR");
				return false;
			}
		}catch(Exception e){
			err.logError("ManageClaimReview", "Issue in submit and verifying SR details"+e);
			return false;
		}

	}

	@FindBy(xpath="//table[@class='gridTable '][@pl_prop='.SentEOBs']")
	private WebElement SR_EOBSentTable;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateServiceRequestDetails
	 * #Description:This method validates data displayed in EOB sent section displayed in Manage Claims Review page
	 * #Arguments:ContactReason and EOBSent
	 * Type:Dropdown and Table
	 * Keys:#Request Duplicate EOB
	 * Keys:#Claim Id#Document ID#Type#PDF#Sent To
	 */
	public boolean validateServiceRequestDetails(String args[]) throws InterruptedException{
		Driver.getPgDriver().switchTo().defaultContent();
		return utils.clickontablerowbasedonvalues(this.SR_EOBSentTable,args[1]);	
	}

	@FindBy(xpath="//table[@pl_prop='.ReviewedClaims']")
	WebElement tblReviewdClaims;

	@FindBy(xpath="//table[@pl_prop='.ReviewedClaims']")
	WebElement tblItemsReviewed;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateTaggedClaimNumber
	 * #Description: This functionality validates the tagged claims in the claim page in the Review page
	 * #Argument: TaggedClaimNumber
	 * Type: Table
	 * keys: first date#last date#claim number#billing provider#rendering provider#claim type#total charged amount#received date#processed date#action code#paid date#paid amount#member liablity
	 */

	public boolean validateTaggedClaimNumber(String[] tablevalues)
	{
		utils.waitforpageload();
		WebElement element = this.tblItemsReviewed;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.validatetablerowbasedonvalues(this.tblItemsReviewed, tablevalues);
	}

	@FindBy (xpath="//li[@title='Request Medical Review']")	
	private WebElement lnkOthrActionsRequestMedicalReview;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigatetoRequestMedicalReview
	 * #Description: This functionality navigates to the Request Adjustment section from the Manage Claim Review page
	 * Type: Textbox
	 */
	public boolean navigatetoRequestMedicalReview()
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Medical Review", "ManageClaimReview", "Request Medical Review");
	}

	@FindBy(xpath="//table[@pl_prop='.MedicalReviewClaims']")
	WebElement medicalClaimsReviewdTbl;

	@FindBy(xpath="//table[@pl_prop='.DocumentReferencesForClaims']")
	WebElement docReferencesForClaimsTbl;

	@FindBy(xpath="//table[@pl_prop='.ClaimImageList']")
	WebElement itemsDiscussedDuringSearchImageProcessTbl;

	@FindBy(id="pyNote")
	WebElement NotesTxtbox;
	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyClaimNumberForMedicalReview
	 * #Description: This functionality validates the claim number tagged for medical review in the Review page
	 * #Argument:ClaimNumberTaggedForMedicalReview
	 * Type:Table
	 * keys:Claim Number#First Date of Service#Last Date of Service
	 */

	public boolean verifyClaimNumberForMedicalReview(String[] tablevalues)
	{
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);",this.medicalClaimsReviewdTbl);
		return utils.validatetablerowbasedonvalues(this.medicalClaimsReviewdTbl, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyDocumentReferences
	 * #Description: This functionality validates the document references for medical review in the Review page
	 * #Argument:DCNTagged
	 * Type:Table
	 * keys:Reference Type#Document Reference Number
	 */

	public boolean verifyDocumentReferences(String[] tablevalues)
	{
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);",this.docReferencesForClaimsTbl);
		return utils.validatetablerowbasedonvalues(this.docReferencesForClaimsTbl, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyItemsDiscussedDuringSearchImageProcess
	 * #Description: This functionality validates the claim number tagged for medical review in the Review page
	 * #Argument:DCNTaggedForMedicalReview
	 * Type:Table
	 * keys:Document Control Number#Claim Number
	 */

	public boolean verifyItemsDiscussedDuringSearchImageProcess(String[] tablevalues)
	{
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);",this.itemsDiscussedDuringSearchImageProcessTbl);
		return utils.validatetablerowbasedonvalues(this.itemsDiscussedDuringSearchImageProcessTbl, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:enterNotes
	 * #Description: This functionality enters notes in the Review page
	 * #Argument:Notes
	 * Type:Textbox
	 */

	public boolean enterNotes(String[] notes)
	{
		return utils.enterTextinAnelemnt(this.NotesTxtbox, notes[0], "ManageClaimReview", "Notes textbox");
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyRequestGandAOptionIsNotDisplayedInOtherActions
	 * #Description: This method clicks on Other Actions and verifies no Request Grievance and Appeals link is displayed
	 * Type:Textbox
	 */
	public boolean verifyRequestGandAOptionIsNotDisplayedInOtherActions(){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageClaimReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherRequestGandA, "ManageClaimReview", "Request Grievance and Appeals")) {
				utils.waitforpageload();
				return utils.validateHeader(this.sHeaderManageClaimReview,"Grievance and Appeals");
			}
		return false;					
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimNumberGATaggedWithOneDayGrievance
	 * #Description:This method validates the Claim Number tagged with One Day Grievance Indicator checked.
	 * #Arguments:ClaimNumberTagged
	 * Type:Textbox
	 */
	public boolean validateClaimNumberWithOneDayGrievanceGATagged(String[] tablevalues) throws InterruptedException{  
		WebElement row = utils.returntablerowbasedonvalues(tblItemsReviewed, tablevalues);
		WebElement imgOneDayGrievance = row.findElement(By.xpath("//td[7]//img"));
		return !utils.isProxyWebelement(imgOneDayGrievance);
	}

	@FindBy(xpath="//img[@data-test-id='20160127122348051611158']")
	WebElement imgOneDayGrievance;

	public boolean verifyClaimHasOneDayGrievanceIndicatorIsDisplayedInItemsReviewedTable()
	{
		return !utils.isProxyWebelement(imgOneDayGrievance);
	}

	@FindBy (xpath="//li[@title='Send Medical Review']")	
	private WebElement lnkOthrActionsSendMedicalReview;

	public boolean navigatetoSendMedicalReview()
	{
		utils.scrolltomiddle();
		action.moveToElement(btnOtherActions);		
		if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsSendMedicalReview, "Manage Claim Review", "Send Medical Review");
		return false;
	}

	@FindBy(xpath="")
	WebElement lnkItemsDisccusedDuringClaimsSearch;

	@FindBy(xpath="")
	WebElement labelMemberHasOtherCoverage;

	@FindBy(xpath="")
	WebElement labelIsOtherCovergae;


	public boolean verifyAndExpandItemsDiscussedDuringClaimsResearchSection()
	{
		if(!utils.isProxyWebelement(lnkItemsDisccusedDuringClaimsSearch))
		{
			if(utils.clickAnelemnt(lnkItemsDisccusedDuringClaimsSearch, "ManageClaimReview", "Items Disccused during claim search"))
			{
				blogger.loginfo("Items Discussed during Claim Search is present and it is expanded");
				System.out.println("Items Discussed during Claim Search is present and it is expanded");
				return true;
			}
		}
		return false;
	}


	public boolean validateTheItemsDiscussedInClaimsResearch(String[] args)
	{

		System.out.println("Entered into the method");
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + " " + "value  " + value);
			if(utils.isvalueMatch_contain(key,"Member Has Covergae")){
				returnvar = utils.validateLabel(this.labelMemberHasOtherCoverage,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Other Covergae")){
				returnvar = utils.validateLabel(this.labelIsOtherCovergae,value);
				continue;}
			else 
				err.logcommonMethodError("ManageClaimReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}	
		if(returnvar)
		{
			System.out.println("Claim Details Discussed verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ManageClaimReview", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	/**This functionality navigates to the Process Claim Image page by clicking other actions button  and the Process Claim Image button
	 * 
	 * @return
	 */
	public boolean navigatetoProcessClaimImage() {
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Process Claim Image", "Manage Claims", "btnOtherActions");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigatetoRequestManagerHelp
	 * #Description: This functionality navigates to the Request Manager OE from the Manage Claim Review page
	 * Type: Textbox
	 */
	public boolean navigatetoRequestManagerHelp() throws InterruptedException
	{
		Thread.sleep(3000);
		if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsRequestManagerHelp, "Manage Claim Review", "Request Adjustment");
		return false;
	}

	@FindBy(xpath="//Span[text()='Request Refund']")
	WebElement lnkOtherActionsRefundRequest;



	public boolean navigateToRefundRequest()
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Refund", "Manage Claim Review", "Click on Request Refund");
	}


	public boolean verifyOtherActionsDoesntDisplayRefundRequest(){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageClaimReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherActionsRefundRequest, "ManageClaimReview", "Refund Request"))
				return utils.validateHeader(this.sHeaderManageClaimReview,"Refund Request");
		return false;
	}

	/**
	 * This functionality navigates to the Request Manager/OE help from the  Manage Claim Review page
	 * @param args
	 * @return
	 */
	public boolean navigateToRequestManagerHelp(String[] args)
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, args[0], "ManageClaimReview", "Request Manager/OE Help");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigatetoRequestAdjusment
	 * #Description: This functionality navigates to the Request Adjustment section from the Manage Claim Review page
	 * Type: Textbox
	 */
	public boolean navigatetoRequestAdjusment() throws InterruptedException
	{
		utils.scrolltoright();
		if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOthrActionsRequestAdjusment, "Manage Claim Review", "Request Adjustment"))
				return true;
		return false;

	}
	
	@FindBy(xpath="//span[text()='Service Request(s) Status']")
	WebElement InstructionalText;
	
	/**Claims Redesign - validate Instructional Text
	 * 
	 */
	public boolean validateInstructionalText() {
		return !utils.isProxyWebelement(InstructionalText);
	}
	
	@FindBy(xpath="//table[@pl_prop='.ItemsCreatedFromClaims']")
	WebElement SRStatus;
	
	public boolean validateTheSRStatus(String[] args) {
		return utils.validatetablerowbasedonvalues(SRStatus, args);
	}
	
	@FindBy(id="PrimaryReasonforBilling")
	WebElement ReasonForContact;
	
	@FindBy(id="pyNote")
	WebElement Notes;
	
	String[] reasonForContactOptions = {"Discuss deductible/coinsurance/copay/cost shares","Explain explanation of benefits (EOB)","Explain provider remittance advice (RA)","Explain how claim processed","Explain this letter or payment received","File a claim","Provide additional information","Locate claim or payment","Request Duplicate EOB","Request correspondence or reprint","Inquired on Refund","Check Status","Request Status on previous Grievance/Appeal"};
	
	public boolean validateReasonForContactDropdown() {
		ArrayList<String> list = new ArrayList<String>();
		
		for(String arg:reasonForContactOptions) {
			list.add(arg);
		}
		
		return utils.checkvaluesinDropDown(ReasonForContact, list);
	}
	
	public boolean selectReasonForContactAndSubmit(String[] args) {
		if(utils.selectDropDownbyVisibleString(ReasonForContact, args[0], "Manage Claim Review", "ReasonForContact"))
			if(utils.enterTextinAnelemnt(Notes, args[1], "Manage Claim Review", "Notes"))
				return clickSubmit();
		return false;
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
	
	@FindBy(xpath="//table[@pl_prop='.ItemsReviewedInClaimProcess']")
	WebElement TableItemsReviewedDuringManageClaimReview;
	
	public boolean confirmationScreenIsDisplayedWithTaggedClaim(String[] claimnumber) {
		return utils.validatetablerowbasedonvalues(TableItemsReviewedDuringManageClaimReview, claimnumber);
	}
	
	@FindBy(xpath="//table[@pl_prop='.ItemsReviewedInClaimProcess']//*[text()='No items']")
	WebElement NoItemsInItemsReviewedDuringManageClaimReviewTable;
	
	public boolean confirmationScreenIsDisplayedWithoutAnyClaim() {
		return !utils.isProxyWebelement(NoItemsInItemsReviewedDuringManageClaimReviewTable);
	}

	@FindBy(xpath = "//option[text()='Waiting on B2 Response']")
	WebElement WaitingOnBResponse;
  public boolean verifyWaitingOnBResponseInReasonForContact()
  {
	  utils.clickAnelemnt(ReasonForContact, "Manage Claim Review", "ReasonForContact");
	  return !utils.isProxyWebelement(WaitingOnBResponse);
	  
  }
	
	
}
