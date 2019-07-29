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

public class ProviderManageClaimReview {

	SeleniumUtilities utils= new SeleniumUtilities();

	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//*[contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//span[text()='Request Adjustment/Pend']")
	private WebElement lnkOthrActionsRequestAdjusment;
	@FindBy (xpath="//li[@title='View/Send EOB']")	
	private WebElement lnkOthrActionsViewEOB;
	@FindBy (xpath="//li[@title='Send EOB']")	
	private WebElement lnkOthrActionsSendEOB;
	@FindBy (xpath="//li[@title='Search For Claim']")	
	private WebElement lnkOthrActionsSearchForClaim;

	public ProviderManageClaimReview()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigatetoRequestAdjusment
	 * #Description: This functionality navigates to the Request Adjustment section from the Manage Claim Review page
	 * Type: Textbox
	 */
	public boolean navigatetoRequestAdjusment()
	{
		/*utils.scrolltomiddle();
		if(utils.clickAnelemnt(btnOtherActions, "ProviderManageClaimREview", "btnOtherActions"))
			return utils.clickAnelemnt(lnkOtherRequestRequestAdjustment, "ProviderManageClaimREview", "lnkOtherRequestRequestAdjustment");
		return false;*/
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Adjustment/Pend", "ProviderManageClaimREview", "Request Adjustment/Pend");
        
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

	@FindBy(id="PrimaryReasonforBilling")
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

	@FindBy (xpath="//*[contains(text(),'Request Adjustment')]")
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

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Manager Help']")	
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
		try{
			if(utils.clickAnelemnt(this.btnOtherActions, "ManageClaimReview", "Other Actions button"))
			{
				try{
					if(utils.clickAnelemnt(this.lnkOtherRequestGandA, "ManageClaimReview", "Request Grievance and Appeals")){
						utils.waitforpageload();
						if(utils.validateHeader(this.sHeaderManageClaimReview,"Grievance and Appeals")){
							err.logError("ManageClaimReview","Able to locate 'Request Grievance and Appeals' in other actions");
							return false;
						}
						else
							return true;
					}
				}catch(Exception e){
					blogger.loginfo("ManageClaimReview - Unable to locate 'Request Grievance and Appeals' in other actions"+e);
				}
			}
		}catch(Exception e){
			err.logError("ManageClaimReview","Unable to click 'Other actions'");
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
			{
				utils.waitforpageload();
				return utils.validateHeader(this.sHeaderManageClaimReview,"Request Manager Help");
			}
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
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit,"ManageClaimReview","Submit Button");
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
		utils.clickAnelemnt(this.btnOtherActions, "ManageClaimReview", "Other Actions button");
		try{
			if(args[0].equalsIgnoreCase("Search For Claim")){
				utils.clickAnelemnt(this.lnkOtherRequestSearchForClaim, "ManageClaimReview", "Search For Claim");
				return true;
			}else if(args[0].equalsIgnoreCase("Request Medical Review")){
				utils.clickAnelemnt(this.lnkOtherRequestRequestMedicalReview, "ManageClaimReview", "Request Medical Review");
				return true;
			}else if(args[0].equalsIgnoreCase("Request Adjustment")){
				utils.clickAnelemnt(this.lnkOtherRequestRequestAdjustment, "ManageClaimReview", "Request Adjustment");
				return true;
			}else if(args[0].equalsIgnoreCase("Process Claim Image")){
				utils.clickAnelemnt(this.lnkOtherRequestProcessClaimImage, "ManageClaimReview", "Process Claim Image");
				return true;
			}else if(args[0].equalsIgnoreCase("View EOB")){
				utils.clickAnelemnt(this.lnkOtherRequestViewEOB, "ManageClaimReview", "View EOB");
				return true;
			}else if(args[0].equalsIgnoreCase("View Remit")){
				utils.clickAnelemnt(this.lnkOtherRequestViewRemit, "ManageClaimReview", "View Remit");
				return true;
			}else if(args[0].equalsIgnoreCase("Perform Adjustment")){
				utils.clickAnelemnt(this.lnkOtherRequestPerformAdjustment, "ManageClaimReview", "Perform Adjustment");
				return true;
			}else if(args[0].equalsIgnoreCase("Send EOB")){
				utils.clickAnelemnt(this.lnkOtherRequestSendEOB, "ManageClaimReview", "Send EOB");
				return true;
			}else if(args[0].equalsIgnoreCase("Request Grievance and Appeals")){
				utils.clickAnelemnt(this.lnkOtherRequestGandA, "ManageClaimReview", "Request Grievance and Appeals");
				return true;
			}else if(args[0].equalsIgnoreCase("Request Manager Help")){
				utils.clickAnelemnt(this.lnkOtherReqMgrHelp, "ManageClaimReview", "Request Manager Help");
				return true;
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

	@FindBy(xpath="//table[@class='gridTable '][@pl_prop='.SentEOBs']")
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

	@FindBy(xpath="")
	private WebElement SR_ContactReason;

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
		WebElement element = this.tblItemsReviewed;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.validatetablerowbasedonvalues(this.tblReviewdClaims, tablevalues);
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
		if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsRequestMedicalReview, "Manage Claim Review", "Request Medical Review");
		return false;
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
			return utils.isProxyWebelement(lnkOtherRequestGandA);
		return false;
	}

	@FindBy(xpath="//table[@pl_prop_class='Antm-FW-CSFW-Data-Claim']//th[5]//img[@data-test-id='20160204063348045687300']")
	WebElement claimIterationNo;

	public boolean validateIterationIndicatorisDisplayedinThirdColumn() {
		return utils.isProxyWebelement(claimIterationNo);
	}

	/**This functionality navigates to the Process Claim Image page by clicking other actions button  and the Process Claim Image button
	 * 
	 * @return
	 */
	public boolean navigatetoProcessClaimImage() {
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Process Claim Image", "Manage Claims", "btnOtherActions");
	}

	@FindBy (xpath="//li[@title='Request Manager/OE Help']")	
	private WebElement lnkOthrActionsRequestManagerHelp;

	/**This functionality navigates to the Request Manager or OE help page by clicking Other actions button
	 * 
	 * @return
	 */
	public boolean navigatetoRequestManagerorOEHelp() {
		if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsRequestManagerHelp, "Manage Claim Review", "Request Adjustment");
		return false;
	}

	/**This functionality check and select Submit Payment Dispute from reason For Contact dropdown in Manage Claims review page
	 * 
	 * @return
	 */
	public boolean checkAndSelectSubmitPaymentDisputeFromReasonForContact() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Submit Payment Dispute");
		return utils.checkvaluesinDropDown(reasonForContact, valuestobechecked);

	}

	@FindBy(xpath="//div[@class='menu-panel-wrapper']//*[text()='Submit Payment Dispute']")
	WebElement SubmitPaymentDispute;

	/**Navigate to submit payment dispute
	 * 
	 * @return
	 */
	public boolean navigateToSubmitPaymentDispute() {
		utils.scrolltoright();
		if(utils.clickAnelemnt(btnOtherActions, "Manage Claim Review", "btnOtherActions"))
			return utils.clickAnelemnt(SubmitPaymentDispute, "Manage Claim Review", "SubmitPaymentDispute");
		return false;
	}

	@FindBy(xpath="//*[@data-test-id='201809281344180664182217']")
	WebElement PDIcon;

	@FindBy(xpath="//*[@class='arrow top']/..//div[@id='poc0']")
	WebElement PDHovertext;

	public boolean verifyPaymentDisputesHoverTextinClaimsReview() throws InterruptedException {
		String actual = utils.hoverOverElementAndGetText(PDIcon, PDHovertext);
		System.out.println(actual);
		return utils.isvalueMatch_contain(actual, "Payment Dispute");
	}
	
	
	public boolean checkAndSelectSubmitPaymentDisputeFromOtherActions()
	{
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Submit Payment Dispute", "ProviderManageClaimReview", "Payment Dispute");
	}
}
