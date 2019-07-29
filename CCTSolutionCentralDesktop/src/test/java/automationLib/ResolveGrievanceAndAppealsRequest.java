package automationLib;

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

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ResolveGrievanceAndAppealsRequest {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement1;

	public ResolveGrievanceAndAppealsRequest(){
		try
		{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}


	@FindBy(id="ReviewerCSResponse")
	WebElement drpDownGandATeamResponse;

	@FindBy(id="SourceSystem")
	WebElement txtBxSourceSystem;

	@FindBy(id="GandASourceSystemId")
	WebElement txtBxSourceSystemID;

	@FindBy(id="GAResolveCaseDescription")
	WebElement txtBxCaseDescription;

	@FindBy(id="GandAResolveDueDate")
	WebElement txtBxDueDate;

	@FindBy(id="Notes")
	WebElement txtBxNotes;

	//@FindBy(xpath="//table[@pl_prop='.GandANotesList']")
	@FindBy(xpath="//table[@pl_prop='.BillingTeamNotesList']")
	WebElement tblActivityLog;

	@FindBy(xpath="//span[@data-test-id='201801251040560076186883']")
	WebElement labelType;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Appeal Type']//following-sibling::div//span")
	WebElement labelAppealType;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Category']//following-sibling::div//span")
	WebElement labelCategory;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Sub-Category']//following-sibling::div//span")
	WebElement labelSubCategory;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Corporate Received Date']//following-sibling::div//span")
	WebElement labelCorpReceivedDate;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Name of Medicine']//following-sibling::div//span")
	WebElement labelMedicineName;
	
	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Dosage of the Medicine']//following-sibling::div//span")
	WebElement labelMedicineDosage;
	
	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Pharmacy']//following-sibling::div//img[@title='Checked']")
	WebElement imgPharmacy;
	
	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Behavioral Health']//following-sibling::div//img[@title='Checked']")
	WebElement imgBehavioralHealth;
	
	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Incident Start Date']//following-sibling::div//span")
	WebElement labelIncidentStartDate;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Incident End Date']//following-sibling::div//span")
	WebElement labelIncidentEndDate;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Expedited?']//following-sibling::div//span")
	WebElement labelExpedited;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Reason']//following-sibling::div//span")
	WebElement labelExpeditedReason;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Level']//following-sibling::div//span")
	WebElement Level;

	@FindBy(xpath="//span[@data-test-id='201801251050410516192922']")
	WebElement memberIssue;

	@FindBy(xpath="//span[@data-test-id='20180125105041051619338']")
	WebElement memberResolution;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[@for='IsMemberInCollections']//following-sibling::div")
	WebElement labelIsTheMemberInCollections;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[@for='NameofCollectionAgency']//following-sibling::div")
	WebElement labelNameOfCollectionAgency;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[@for='ContactAtAgency']//following-sibling::div")
	WebElement labelContcatAtAgency;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[@for='AgencyPhoneNumber']//following-sibling::div")
	WebElement labelPhoneNumber;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[@for='AgencyAccountNumber']//following-sibling::div")
	WebElement labelAgencyAccountNumber;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	WebElement labelResolveGrievanceandAppealsRequest;

	@FindBy(id="$PpyWorkPage$pGAResolveCaseDescription_counter")
	WebElement labelCasedDescriptionCounter;





	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyCaseDescriptionFieldIsDisplayed
	 * #Description: This functionality verifies that the Case description field is present or not in the Resolve G & A request page
	 * Type: Textbox
	 */
	public boolean verifyCaseDescriptionFieldIsDisplayed()
	{
			utils.waitforpageload();
			WebElement element = Driver.pgDriver.findElement(By.id("GAResolveCaseDescription"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return !utils.isProxyWebelement(txtBxCaseDescription);
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyDueDateFieldIsDisplayed
	 * #Description: This functionality verifies that the due date field is present or not in the Resolve G & A request page
	 * Type: Textbox
	 */
	public boolean verifyDueDateFieldIsDisplayed()
	{
			utils.waitforpageload();
			WebElement element = Driver.pgDriver.findElement(By.id("GandAResolveDueDate"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return !utils.isProxyWebelement(txtBxDueDate);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterCaseDescriptionTextInputAndValidateMaxLimit
	 * #Description: This functionality enters the date in the Case description field and then validates that max limit is reached
	 * #Argument: Case Description
	 * Type: Textbox
	 */
	public boolean enterCaseDescriptionTextInputAndValidateMaxLimit(String[] args)
	{

			Driver.pgDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			if(utils.enterTextinAnelemnt(this.txtBxCaseDescription, args[0], "ResolveGrievanceAndAppealsRequest", "Notes"))
				if(utils.validateLabel(labelCasedDescriptionCounter, "0")) 
					return true;	
			return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterSourceSystemNameTextInput
	 * #Description: This functionality enters the name in the source system name field
	 * #Argument: Source Name
	 * Type: Textbox
	 */
	public boolean enterSourceSystemNameTextInput(String[] args)
	{
			WebElement element = Driver.pgDriver.findElement(By.id("SourceSystem"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.enterTextinAnelemnt(this.txtBxSourceSystem, args[0], "ResolveGrievanceAndAppealsRequest", "Source System Name");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterSourceSystemIDTextInput
	 * #Description: This functionality enters the id in the source system id field
	 * #Argument: Source ID
	 * Type: Textbox
	 */
	public boolean enterSourceSystemIDTextInput(String[] args)
	{
			WebElement element = Driver.pgDriver.findElement(By.id("SourceSystem"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.enterTextinAnelemnt(this.txtBxSourceSystemID, args[0], "ResolveGrievanceAndAppealsRequest", "Source System ID");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterDueDateTextInput
	 * #Description: This functionality enters the date in the Case description field and then validates that max limit is reached
	 * #Argument: Due Date
	 * Type: Textbox
	 */
	public boolean enterDueDateTextInput(String[] args)
	{
			return utils.enterTextinAnelemnt(this.txtBxDueDate, args[0], "ResolveGrievanceAndAppealsRequest", "Due Date");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectGandATeamResponse
	 * #Description: This functionality selects the input given by the user in the G and A team response drop down section
	 * #Argument: GandATeamResponse
	 * Type: Dropdown
	 * Keys: Request Additional Information#Request Complete#Requested in Error
	 */
	public boolean selectGandATeamResponse(String[] team)
	{
			return utils.selectDropDownbyVisibleString(this.drpDownGandATeamResponse, team[0], "ResolveGrievanceAndAppealsRequest", "G & A Response Drop down");	
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterNotesInGandARequestAndValidateMaxLimit
	 * #Description: This functionality enters the notes in the notes field and then validates that max limit is reached
	 * #Argument: Notes
	 * Type: Textbox
	 */
	public boolean enterNotesInGandARequestAndValidateMaxLimit(String[] args)
	{
			return utils.enterTextinAnelemnt(this.txtBxNotes, args[0], "ResolveGrievanceAndAppealsRequest", "Notes");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateActivityLogTable
	 * #Description: This functionality validates the value given by the user with the value present in the Activity log table
	 * #Argument: Activity Log - Keyvaluepair
	 * Type: Table
	 * Keys: Created Date#Created By#Notes#Activity
	 */
	public boolean validateActivityLogTable(String[] tablevalues)
	{
			WebElement element = this.tblActivityLog;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			System.out.println("Entered");
			return utils.validatetablerowbasedonvalues(this.tblActivityLog, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on the Submit button in the Resolve Grievance and Appeals request page
	 * Type: Textbox
	 */
	public boolean clickOnSubmit()
	{
			return utils.clickAnelemnt(this.btnSubmit, "ResolveGrievanceAndAppealsRequest", "Submit");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateItemsDiscussedInGAResolveRequestSection
	 * #Description: This functionality validates the value given by the user with the value present in the Items reviewed section
	 * #Argument: ItemsDiscussed
	 * Type: Table
	 * Keys: Type#Appeal Type#Incident Start Date#Incident End Date#Category#Sub-Category#Corporate Received Date
	 */
	public boolean validateItemsDiscussedInGAResolveRequestSection(String[] args)
	{
		//((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.lbl_ItemsDiscussedDuringGAReview);
		boolean returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("verifyItemsReviewedDuringGandATask", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);


			if(utils.isvalueMatch_compareto(key,"Type")){
				returnvar = utils.validateLabel(this.labelType,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Appeal Type")){
				returnvar = utils.validateLabel(this.labelAppealType,value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"Category")){
				returnvar = utils.validateLabel(this.labelCategory,value);			
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Sub Category")){
				returnvar = utils.validateLabel(this.labelSubCategory,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Corp Received Date")){
				returnvar = utils.validateLabel(this.labelCorpReceivedDate,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Incident Start Date")){
				returnvar = utils.validateLabel(this.labelIncidentStartDate,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Incident End Date")){
				returnvar = utils.validateLabel(this.labelIncidentEndDate,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Name of Medicine")){
				returnvar = utils.validateLabel(this.labelMedicineName,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Dosage of the Medicine")){
				returnvar = utils.validateLabel(this.labelMedicineDosage,value);
				continue;
			}
			else if(utils.isvalueMatch_compareto(key,"Behavioral Health")){
				try
				{
					imgBehavioralHealth.isDisplayed();
					blogger.loginfo("Behavioral Health Checkbox is Displayed");
					System.out.println("Behavioral Health Checkbox is Displayed");
					return true;
				}catch(Exception e)
				{
					blogger.loginfo("Behavioral Checkbox is not Displayed");
					System.out.println("Behavioral Checkbox is not Displayed");
					return false;
				}
			}
			else if(utils.isvalueMatch_compareto(key,"Pharmacy")){
				try
				{
					imgPharmacy.isDisplayed();
					blogger.loginfo("Pharmacy Checkbox is Displayed");
					System.out.println("Pharmacy Checkbox is Displayed");
					return true;
				}catch(Exception e)
				{
					blogger.loginfo("Pharmacy Checkbox is not Displayed");
					System.out.println("Pharmacy Checkbox is not Displayed");
					return false;
				}
			}
		}

		if(returnvar){
			blogger.loginfo("All values for fields matched with user input");
			System.out.println("verifyItemsReviewedDuringGandATask: All values for fields matched with user input");
			return true;
		}else{
			err.logcommonMethodError("verifyItemsReviewedDuringGandATask", "Couldnt match GA Task fields");
			return false;
		}


	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyNoInMemberCollections
	 * #Description: This functionality validates the value given by the user with the value present in the member collection no section
	 * #Argument: MemberCollectionNo
	 * Type: Table
	 * Keys: Is the member in Collections
	 */
	public boolean verifyNoInMemberCollections(String[] args)
	{
		boolean returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("verifyItemsReviewedDuringGandATask", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(utils.isvalueMatch_contain(key,"Satisfaction")){
				returnvar = utils.validateLabel(this.labelIsTheMemberInCollections,value);
				continue;
			}

		}
		if(returnvar){
			blogger.loginfo("All values for fields matched with user input");
			System.out.println("verifyNoInMemberCollections: All values for fields matched with user input");
			return true;
		}else{
			err.logcommonMethodError("verifyNoInMemberCollections", "Couldnt match GA Task fields");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyYesInMemberCollectionsWithQuestions
	 * #Description: This functionality validates the value given by the user with the value present in the Member Collection Yes section
	 * #Argument: MemberCollectionYes
	 * Type: Table
	 * Keys: Is the member in Collections#Name of Collection Agency#Contact at Agency#Phone Number#Account Number
	 */
	public boolean verifyYesInMemberCollectionsWithQuestions(String[] args)
	{

		boolean returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("verifyItemsReviewedDuringGandATask", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(utils.isvalueMatch_contain(key,"Satisfaction")){
				returnvar = utils.validateLabel(this.labelIsTheMemberInCollections,value);
				continue;
			}

			if(utils.isvalueMatch_contain(key,"Satisfaction")){
				returnvar = utils.validateLabel(this.labelIsTheMemberInCollections,value);
				continue;
			}

			if(utils.isvalueMatch_contain(key,"Collection Agency")){
				returnvar = utils.validateLabel(this.labelNameOfCollectionAgency,value);
				continue;
			}

			if(utils.isvalueMatch_contain(key,"Contcat Agency")){
				returnvar = utils.validateLabel(this.labelContcatAtAgency,value);
				continue;
			}

			if(utils.isvalueMatch_contain(key,"Phone Number")){
				returnvar = utils.validateLabel(this.labelPhoneNumber,value);
				continue;
			}

			if(utils.isvalueMatch_contain(key,"Account Number")){
				returnvar = utils.validateLabel(this.labelAgencyAccountNumber,value);
				continue;
			}
		}
		if(returnvar){
			blogger.loginfo("All values for fields matched with user input");
			System.out.println("verifyYesInMemberCollectionsWithQuestions: All values for fields matched with user input");
			return true;
		}else{
			err.logcommonMethodError("verifyYesInMemberCollectionsWithQuestions", "Couldnt match GA Task fields");
			return false;
		}


	}
	
	//Sprint 3.2
	
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderResolveGA;
	
	@FindBy(linkText="G & A Routing")
	private WebElement ga_RoutingLink;
	
	@FindBy(linkText="MAGI")
	private WebElement magiLink;
	
	@FindBy(linkText="MCW")
	private WebElement mcwLink;
	
	@FindBy(linkText="NextGen")
	WebElement lnkNextGen;
	
	@FindBy(linkText="ECC")
	WebElement lnkECC; 
	
	@FindBy(linkText="WMDS")
	WebElement lnkWMDS;
	
	@FindBy(linkText="TriMed")
	WebElement lnkTriMed;
	
	
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyGARoutingLink
	 * #Description:This method verifies if G and A Routing Link is displayed on 'Grievance And Appeals' task
	 * Type:TextBox
	 */
	public boolean verifyGARoutingLink() throws InterruptedException{
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request"))
			if(!utils.isProxyWebelement(ga_RoutingLink))
					return true;
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
		if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request"))
			if(!utils.isProxyWebelement(magiLink))
					return true;
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
		if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request"))
			if(!utils.isProxyWebelement(mcwLink))
					return true;
		return false;
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickGARoutingLink
	 * #Description:This method clicks on G and A Routing Link is displayed on Grievance And Appeals task
	 * Type:TextBox
	 */
	public boolean clickGARoutingLink(){
		utils.clickAnelemnt(this.ga_RoutingLink, "GrievanceAndAppeals", "G & A Routing Link");
		//https://applications.antheminc.com/sites/pstools/WorkPaths/CA_CommGA_WP.html
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
			return true;
		}else{
			System.out.println("Window switched failed");
			return false;
		}
		}catch(Exception e){
			System.out.println("Exception occured::"+e);
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickMAGILink
	 * #Description:This method clicks on MAGI Link is displayed on Grievance And Appeals task
	 * Type:TextBox
	 */
	public boolean clickMAGILink(){
		utils.clickAnelemnt(this.magiLink, "GrievanceAndAppeals", "MAGI Link");
		//http://magi.wellpoint.com/
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
				return true;
			}else{
				System.out.println("Window switched failed");
				return false;
			}
			}catch(Exception e){
				System.out.println("Exception occured::"+e);
				return false;
			}
	}

	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickMCWLink
	 * #Description:This method clicks on MCW Link is displayed on Grievance And Appeals task
	 * Type:TextBox
	 */
	public boolean clickMCWLink(){
		utils.clickAnelemnt(this.mcwLink, "GrievanceAndAppeals", "MCW Link");
		//http://mcwdevl
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
					return true;
				}else{
					System.out.println("Window switched failed");
					return false;
				}
				}catch(Exception e){
					System.out.println("Exception occured::"+e);
					return false;
				}
	}
	
	
	
			
			/*
			 * @SCU
			 * #CommonMethodwithoutArgument:verifyNextGenLink
			 * #Description:This method verifies if Next Gen Link is displayed on 'Grievance And Appeals' task
			 * Type:TextBox
			 */
			public boolean verifyNextGenLink() throws InterruptedException{
				utils.waitforpageload();
				if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request"))
					if(!utils.isProxyWebelement(lnkNextGen))
							return true;
				return false;
			}
			
			/*
			 * @SCU
			 * #CommonMethodwithoutArgument:verifyECCLink
			 * #Description:This method verifies if ECC Link is displayed on 'Grievance And Appeals' task
			 * Type:TextBox
			 */
			public boolean verifyECCLink() throws InterruptedException{
				utils.waitforpageload();
				if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request"))
					if(!utils.isProxyWebelement(lnkECC))
							return true;
				return false;
			}
			
			
			/*
			 * @SCU
			 * #CommonMethodwithoutArgument:verifyWMDSLink
			 * #Description:This method verifies if WMDS Link is displayed on 'Grievance And Appeals' task
			 * Type:TextBox
			 */
			public boolean verifyWMDSLink() throws InterruptedException{
				utils.waitforpageload();
				if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request"))
					if(!utils.isProxyWebelement(lnkWMDS))
						return true;
				return false;
			}
			
			
			/*
			 * @SCU
			 * #CommonMethodwithoutArgument:verifyTriMedLink
			 * #Description:This method verifies if TRi Med Link is displayed on 'Grievance And Appeals' task
			 * Type:TextBox
			 */
			public boolean verifyTriMedLink() throws InterruptedException{
				utils.waitforpageload();
				if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request"))
					if(!utils.isProxyWebelement(lnkTriMed))
							return true;
				return false;
			}
			
			
			public boolean clickNextGenLink()
			{
				String parent = Driver.pgDriver.getWindowHandle();
				if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request")){
					if(this.lnkNextGen.isDisplayed())
					{
						utils.clickAnelemnt(this.lnkNextGen, "GrievanceAndAppeals", "Next Gen Link");
						System.out.println(("Next Gen Link Is Clicked.."));
						Set<String> handles = Driver.pgDriver.getWindowHandles();
						System.out.println("No.ofwindows"+handles.size());
						Iterator<String> iterator= handles.iterator();
						String parentWindow = iterator.next();
						String childWindow = iterator.next();
						Driver.pgDriver.switchTo().window(childWindow);
						String title = Driver.pgDriver.getTitle();
						System.out.println("Title of the Child Window is: "+title);
						if(title.contains("Pega 7"))
						{
							System.out.println("Next Gen is launched and the title is: "+ title); 
							return true;
						}else
						{
						  err.logcommonMethodError("GrievanceAndAppeals", "Error in switching to childwindow-Next Gen");
						  return false;
						}
					}
					err.logcommonMethodError("GrievanceAndAppeals", "Next Gen is not displayed in - Grievance and Appeals");
					return false;	
				}
				err.logcommonMethodError("GrievanceAndAppeals", "Grievance and Appeals is not loaded");
				return false;
			}
			
			
			public boolean clickECCLink()
			{
				String parent = Driver.pgDriver.getWindowHandle();
				if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request")){
					if(this.lnkECC.isDisplayed())
					{
						utils.clickAnelemnt(this.lnkECC, "GrievanceAndAppeals", "ECC Link");
						System.out.println(("ECC Link Is Clicked.."));
						Set<String> handles = Driver.pgDriver.getWindowHandles();
						System.out.println("No.ofwindows"+handles.size());
						Iterator<String> iterator= handles.iterator();
						String parentWindow = iterator.next();
						String childWindow = iterator.next();
						Driver.pgDriver.switchTo().window(childWindow);
						String title = Driver.pgDriver.getTitle();
						System.out.println("Title of the Child Window is: "+title);
						if(title.contains("MyCitrix"))
							System.out.println("ECC is launched and the title is: "+ title); 
							return true;
				
			}
				}
				return false;
			}
		    
			
			public boolean clickWMDSLink()
			{
				String parent = Driver.pgDriver.getWindowHandle();
				if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request")){
					if(this.lnkWMDS.isDisplayed())
					{
						utils.clickAnelemnt(this.lnkWMDS, "GrievanceAndAppeals", "WMDS Link");
						System.out.println(("WMDS Link Is Clicked.."));
						Set<String> handles = Driver.pgDriver.getWindowHandles();
						System.out.println("No.ofwindows"+handles.size());
						Iterator<String> iterator= handles.iterator();
						String parentWindow = iterator.next();
						String childWindow = iterator.next();
						Driver.pgDriver.switchTo().window(childWindow);
						String title = Driver.pgDriver.getTitle();
						System.out.println("Title of the Child Window is: "+title);
						if(title.contains("MyCitrix"))
							return true;
						}
					}
				return false;
			}
			
			
			public boolean clickTriMedLink()
			{
				String parent = Driver.pgDriver.getWindowHandle();
				if(utils.validateHeader(this.sHeaderResolveGA, "Resolve Grievance and Appeals Request")){
					if(this.lnkTriMed.isDisplayed())
					{
						utils.clickAnelemnt(this.lnkTriMed, "GrievanceAndAppeals", "TriMed Link");
						System.out.println(("TriMed Link Is Clicked.."));
						Set<String> handles = Driver.pgDriver.getWindowHandles();
						System.out.println("No.ofwindows"+handles.size());
						Iterator<String> iterator= handles.iterator();
						String parentWindow = iterator.next();
						String childWindow = iterator.next();
						Driver.pgDriver.switchTo().window(childWindow);
						String title = Driver.pgDriver.getTitle();
						System.out.println("Title of the Child Window is: "+title);
						if(title.contains("MyCitrix"))
							System.out.println("WMDS is launched and the title is: "+ title); 
							return true;
					}
				}
				return false;
			}
		    
			
			//Sprint 3.3
			
			 @FindBy(xpath="")
			 	WebElement imgOneDayGrievanceIndicator;
			    
			    @FindBy(xpath="//table[@pl_prop='.ReviewedClaims']")
			    WebElement tblClaimsTaggedInGA;
			 	
			 	/*
			     * @SCU
			     * #CommonMethodwithArgument:validateClaimNumberGATaggedWithOneDayGrievance
			     * #Description:This method validates the Claim Number tagged with One Day Grievance Indicator checked.
			     * #Arguments:ClaimNumberTagged
			     * Type:Textbox
			     */
			     public boolean validateClaimNumberWithOneDayGrievanceGATagged(String[] tablevalues) throws InterruptedException{  
				 	 		WebElement row = utils.returntablerowbasedonvalues(tblClaimsTaggedInGA, tablevalues);
				 	 		WebElement imgOneDayGrievance = row.findElement(By.xpath("//td[7]//img"));
				 	 		return !utils.isProxyWebelement(imgOneDayGrievance);
				 	     }
			     
			     @FindBy(xpath="//img[@data-test-id='20160127122348051611158']")
			     WebElement imgOneDayGrievance;
			     
			     public boolean verifyClaimHasOneDayGrievanceIndicatorIsDisplayedInItemsReviewedTable()
			     {
				 			WebElement table = this.tblClaimsTaggedInGA;
				 			WebElement imgOneDayGrievance = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.ReviewedClaims']//img[@data-test-id='20160127122348051611158']"));
				 			return !utils.isProxyWebelement(imgOneDayGrievance);
				     }
			     
			     
			     @FindBy(xpath="//label[@data-test-id='20180529153016058232580-Label']//following-sibling::div")
			     WebElement labelAcknowledgeGAQue;
			     
			     @FindBy(xpath="//span[text()='Service Request Details']")
			     WebElement lnkServiceRequestDetails;
			     
			     public boolean validateYesOrNoInGA(String[] args)
			     {
			    	 if(utils.clickAnelemnt(lnkServiceRequestDetails, "ResolveGrievanceAndAppealsRequest", "Service Request Details"))
			    	 {
			    	 WebElement element = Driver.pgDriver.findElement(By.xpath("//label[@data-test-id='20180529153016058232580-Label']//following-sibling::div"));
			    	 ((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			    	 utils.waitforpageload();
			    	 return utils.validateLabel(labelAcknowledgeGAQue, args[0]);
			    	 }
			    		 return false;
			     }
			     
			     
			     @FindBy(xpath="//a[@data-test-id='20180320104807059220532']")
			     WebElement lnkSRID;
			     
			     @FindBy(xpath="//span[@data-test-id='201805301503200313225107']")
			     WebElement labelLetterName;
			     
			     @FindBy(xpath="//span[@data-test-id='20180321000925090686214']")
			     WebElement labelLetterSentDate;
			     
			     @FindBy(xpath="//span[@data-test-id='201805301503200313227473']")
			     WebElement labelLetterAddress;
			     
			     
			     public boolean validateSelectedLetterInTheResolveGARequestPage(String[] args)
			     {
			 		//((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.lbl_ItemsDiscussedDuringGAReview);
			 		boolean returnvar = true;
			 		String keyvaluepair="";
			 		for(String iterator : args)
			 		{
			 			if(!returnvar)
			 			{
			 				err.logcommonMethodError("verifyItemsReviewedDuringGandATask", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
			 				return false;
			 			}
			 			keyvaluepair = iterator;
			 			String key = iterator.substring(0, iterator.indexOf(":"));
			 			String value = iterator.substring(iterator.indexOf(":")+1);
			 			System.out.println("key " + key + "value  " + value);
			 			if(utils.isvalueMatch_compareto(key,"ID")){
			 				returnvar = utils.validateLabel(this.lnkSRID,value);
			 				continue;
			 			}
			 			else if(utils.isvalueMatch_compareto(key,"Name")){
			 				returnvar = utils.validateLabel(this.labelLetterName,value);
			 				continue;}
			 			else if(utils.isvalueMatch_compareto(key,"Date")){
			 				returnvar = utils.validateLabel(this.labelLetterSentDate,value);			
			 				continue;
			 			}
			 			else if(utils.isvalueMatch_compareto(key,"Address")){
			 				returnvar = utils.validateLabel(this.labelLetterAddress,value);
			 				continue;
			 			}
			 		}
			 		if(returnvar){
			 			blogger.loginfo("All values for fields matched with user input");
			 			System.out.println("validateSelectedLetterInTheResolveGARequestPage: All values for fields matched with user input");
			 			return true;
			 		}else{
			 			err.logcommonMethodError("validateSelectedLetterInTheResolveGARequestPage", "Couldnt match GA Task fields");
			 			return false;
			 		}
			     }


}