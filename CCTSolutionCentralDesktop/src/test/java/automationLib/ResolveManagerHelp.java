package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
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

public class ResolveManagerHelp {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement1;
	
	public ResolveManagerHelp(){
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
	
	
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//select[@id='RouteHelpWithCaseResponse']")
	WebElement drpDownNextActions;
	
	@FindBy (xpath="//select[@id='RoutingOperatorName']")	
	WebElement drpDownWorkBasket;
	
	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Cancel this work')]")	
	WebElement lnkOthrActionsCancelWork;
	
	
	@FindBy(id="Notes")
	WebElement txtNotes;
	
	@FindBy(xpath = "(//iframe[contains(@name,'PegaGadget') and contains(@id,'PegaGadget') and contains(@src,'prweb/sso')])[6]")
	WebElement iframeN;
	
	
	
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectNextAction
	 * #Description: This functionality selects the value given by the user in the Select Next ACtion in dropdown section.
	 * #Argument: reason
	 * Type: Dropdown
	 * Keys: 
	 */
	public boolean selectNextAction(String[] reason)
	{
		return	utils.selectDropDownbyVisibleString(this.drpDownNextActions, reason[0], "ManageReferralReview", "Reason For Contact");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectWorkBasketInRequestMangerHelp
	 * #Description: This functionality selects the value given by the user in the Select Workbasket dropdown section.
	 * #Argument: reason
	 * Type: Dropdown
	 * Keys: 
	 */
	
	public boolean selectWorkBasketInRequestMangerHelp(String[] reason)
	{
			WebDriverWait wait = new WebDriverWait(Driver.pgDriver, 10);
			wait.until(ExpectedConditions.visibilityOf(drpDownWorkBasket));
			return utils.selectDropDownbyVisibleString(this.drpDownWorkBasket, reason[0], "ResolveMangerHelp", "Select Workbasket");
	}

	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterNotes
	 * #Description: This functionality enters the notes in the notes section in the Resolve Manager Help page
	 * #Argument: notes
	 * Type: Textbox
	 */
	public boolean enterNotes(String[] notes)
	{
		utils.waitforpageload();
		return utils.enterTextinAnelemnt(txtNotes, notes[0], "ResolveMangerHelp", "Notes");
	}
	
	@FindBy(id="RoutingOperatorName")
	WebElement txtoperator;
	
	/*
	 * #CommonMethodWithArgument: enterOperator
	 * #Description: This functionality enters the operator id in the operator section in the Resolve Manager Help page
	 * #Argument: notes
	 * Type: Textbox
	 */
	public boolean enterOperator(String[] operator)
	{
		utils.waitforpageload();
		return utils.enterTextinAnelemnt(txtoperator, operator[0], "ResolveMangerHelp", "Notes");
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on the Submit button in the View Program Review page
	 * #type: Textbox
	 */
	public boolean clickOnSubmit()
	{
			return utils.clickAnelemnt(this.btnSubmit, "ViewProgramReview", "Submit");
	}

	
	//Sprint 3.3
	
	//Sprint 3.3
	
	
		@FindBy(xpath="//span[@data-test-id='201801251040560076186883']")
		private WebElement Type;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Category']//following-sibling::div//span")
		private WebElement Category;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Sub-Category']//following-sibling::div//span")
		private WebElement subCategory;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Corporate Received Date']//following-sibling::div//span")
		private WebElement corpReceivedDate;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Expedited?']//following-sibling::div//span")
		private WebElement Expedited;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Reason']//following-sibling::div//span")
		private WebElement ExpeditedReason;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Appeal Type']//following-sibling::div//span")
		private WebElement AppealType;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Incident Start Date']//following-sibling::div//span")
		private WebElement IncidentStartDate;
		
		@FindBy(xpath="//label[@for='IsBehavioralHealth']//following-sibling::div//img[@title='Checked']")
		private WebElement BehavioralHealth;
		
		@FindBy(xpath="//label[@for='IsPharmacy']//following-sibling::div//img[@title='Checked']")
		private WebElement Pharmacy;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Name of Medicine']//following-sibling::div//span")
		private WebElement MedicineName;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Dosage of the Medicine']//following-sibling::div//span")
		private WebElement MedicineDosage;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Incident End Date']//following-sibling::div//span")
		private WebElement IncidentEndDate;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Is the member in Collections']//following-sibling::div//span")
		private WebElement IsthememberinCollections;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Service Type']//following-sibling::div//span")
		private WebElement ServiceType;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Name of Collection Agency']//following-sibling::div//span")
		private WebElement NameofCollectionAgency;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Contact at Agency']//following-sibling::div//span")
		private WebElement ContactatAgency;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Phone Number']//following-sibling::div//span")
		private WebElement PhoneNumber;
		
		@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Account Number']//following-sibling::div//span")
		private WebElement AccountNumber;
		
		@FindBy(xpath="//span[@data-test-id='201801251050410516192922']")
		private WebElement memberIssue;
		
		@FindBy(xpath="//span[@data-test-id='20180125105041051619338']")
		private WebElement memberResolution;

	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateItemsDiscussedInGAReviewSection
	 * #Description:This method validates Items Discussed during Grievance and Appeals Review on Complete Grievance And Appeals Review page like Type,Category,Sub-Category,Level,Corporate Recieved Date,Expedited,Reason,Member Issue,Member Resolution
	 * #Arguments:ItemsDiscussed
	 * Type:Table
	 * Keys:Type#Appeal Type#Incident Start Date#Incident End Date#Category#Sub-Category#Service Type#Corporate Recieved Date#Expedited#Expedited Reason#Member Issue#Member Resolution#Is the member in Collections#Name of Collection Agency#Contact at Agency#Phone Number#Account Number
	 */
	public boolean validateItemsDiscussedInGAReviewSection(String args[]){
		utils.waitforpageload();
		boolean returnvar = true;
		String type = "",category="",subcategory="",corporateReceivedDate="",expedited="",reason="",level="",member_issue="",member_resolution="",behavioral_health="",pharmacy="",name_of_medicine="",dosage_of_medicine="";
		String appeal_type="",incident_start="",incident_end="",service_type="",mem_in_collection="",nameOfCollectionAgency="",contactAtAgency="",phoneNumber="",accountNumber="";
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			 keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.equalsIgnoreCase("Type")){
				type = value.trim();
				if(type.equalsIgnoreCase(this.Type.getText().trim())){
				returnvar = true;
				System.out.println("Type matched with user input");
				continue;
				}else{
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Type mis-matched with user input");
				}
			}else if(key.equalsIgnoreCase("Appeal Type")){
				appeal_type = value.trim();
				if(appeal_type.equalsIgnoreCase(this.AppealType.getText().trim())){
					returnvar = true;
					System.out.println("Appeal Type matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Appeal Type mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Incident Start Date")){
				incident_start = value.trim();
				if(incident_start.equalsIgnoreCase(this.IncidentStartDate.getText().trim())){
					returnvar = true;
					System.out.println("Incident Start Date matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Incident Start Date mis-matched with user input");
					}
			}
			else if(key.equalsIgnoreCase("Behavioral Health")){
				try
				{
					Pharmacy.isDisplayed();
					blogger.loginfo("Behavioral Health Checkbox is Displayed");
					System.out.println("Behavioral Health Checkbox is Displayed");
					return true;
				}catch(Exception e)
				{
					blogger.loginfo("Behavioral Health Checkbox is not Displayed");
					System.out.println("Behavioral Health Checkbox is not Displayed");
					return false;
				}
			}
			else if(key.equalsIgnoreCase("Pharmacy")){
				try
				{
					Pharmacy.isDisplayed();
					blogger.loginfo("Pharmacy Checkbox is Displayed");
					System.out.println("Pharmacy Checkbox is Displayed");
					return true;
				}catch(Exception e)
				{
					blogger.loginfo("Pharmacy Checkbox is not Displayed");
					System.out.println("Pharmacy Checkbox is not Displayed");
					return false;
				}
			}else if(key.equalsIgnoreCase("Name of Medicine")){
				name_of_medicine = value.trim();
				if(name_of_medicine.equalsIgnoreCase(this.MedicineName.getText().trim())){
					returnvar = true;
					System.out.println("Medicine Name matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Medicine Name mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Dosage of The Medicine")){
				dosage_of_medicine = value.trim();
				if(dosage_of_medicine.equalsIgnoreCase(this.MedicineDosage.getText().trim())){
					returnvar = true;
					System.out.println("Medicine Dosage matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Medicine Dosage mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Incident End Date")){
				incident_end = value.trim();
				if(incident_end.equalsIgnoreCase(this.IncidentEndDate.getText().trim())){
					returnvar = true;
					System.out.println("Incident End Date matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Incident End Date mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Service Type")){
				service_type = value.trim();
				if(service_type.equalsIgnoreCase(this.ServiceType.getText().trim())){
					returnvar = true;
					System.out.println("Service Type matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Service Type mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Category")){
				category = value.trim();
				if(category.equalsIgnoreCase(this.Category.getText().trim())){
					returnvar = true;
					System.out.println("Category matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Category mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Sub-Category")){
				subcategory = value.trim();
				if(subcategory.equalsIgnoreCase(this.subCategory.getText().trim())){
					returnvar = true;
					System.out.println("subCategory matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "subCategory mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Corporate Recieved Date")){
				corporateReceivedDate = value.trim();
				if(corporateReceivedDate.equalsIgnoreCase(this.corpReceivedDate.getText().trim())){
					returnvar = true;
					System.out.println("corpReceivedDate matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "corpReceivedDate mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Expedited")){
				expedited = value.trim();
				if(expedited.equalsIgnoreCase(this.Expedited.getText().trim())){
					returnvar = true;
					System.out.println("Expedited matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Expedited mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Expedited Reason")){
				reason = value.trim();
				if(reason.equalsIgnoreCase(this.ExpeditedReason.getText().trim())){
					returnvar = true;
					System.out.println("ExpeditedReason matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "ExpeditedReason mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Is the member in Collections")){
				mem_in_collection = value.trim();
				if(mem_in_collection.equalsIgnoreCase(this.IsthememberinCollections.getText().trim())){
					returnvar = true;
					System.out.println("Is the member in Collections matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Is the member in Collections mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Name of Collection Agency")){
				nameOfCollectionAgency = value.trim();
				if(nameOfCollectionAgency.equalsIgnoreCase(this.NameofCollectionAgency.getText().trim())){
					returnvar = true;
					System.out.println("Name of Collection Agency matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Name of Collection Agency mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Contact at Agency")){
				contactAtAgency = value.trim();
				if(contactAtAgency.equalsIgnoreCase(this.ContactatAgency.getText().trim())){
					returnvar = true;
					System.out.println("Contact at Agency matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Contact at Agency mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Phone Number")){
				phoneNumber = value.trim();
				if(phoneNumber.equalsIgnoreCase(this.PhoneNumber.getText().trim())){
					returnvar = true;
					System.out.println("Phone Number matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Phone Number mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Account Number")){
				accountNumber = value.trim();
				if(accountNumber.equalsIgnoreCase(this.AccountNumber.getText().trim())){
					returnvar = true;
					System.out.println("Account Number matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Account Number mis-matched with user input");
					}
			}else if(key.equalsIgnoreCase("Member Issue")){
				member_issue = value.trim();
				if(member_issue.equalsIgnoreCase(this.memberIssue.getText().trim())){
					returnvar = true;
					System.out.println("memberIssue matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "memberIssue mis-matched with user input");
					}	
			}
			else if(key.equalsIgnoreCase("Member Resolution")){
				member_resolution = value.trim();
				if(member_resolution.equalsIgnoreCase(this.memberResolution.getText().trim())){
					returnvar = true;
					System.out.println("memberResolution matched with user input");
					continue;
					}else{
						returnvar = false;
						err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "memberResolution mis-matched with user input");
					}
			}
			else{
				err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				returnvar = false;
			}
		}
		
		if(returnvar){
			System.out.println("validateItemsDiscussedInGAReviewSection: All values for fields matched with user input");
			return true;
		}else{
			err.logcommonMethodError("validateItemsDiscussedInGAReviewSection", "Couldnt match GA review fields");
			return false;
		}
	}
	
	
	@FindBy(xpath = "//input[@data-test-id='20160107002905035566203']")
	WebElement EnterOperatorID;
	
	
	
	public boolean enterOperatorID(String[] operatorID)
	{
		try
		{
		
			utils.enterTextinAnelemnt(EnterOperatorID, operatorID[0], "ResolveManageHelp", "Operator ID");
			EnterOperatorID.sendKeys(Keys.TAB);
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("Resolve Manager Help", "enterOperatorID", "Operator ID is not entered");
			return false;
		}
	}
	
	@FindBy(xpath = "//select[@id='RoutingOperatorName']")
	WebElement EnterWorkbasket;
	
	
	
	public boolean enterWorkbasket(String[] workBasket)
	{
			return utils.selectDropDownbyVisibleString(EnterWorkbasket, workBasket[0],  "ResolveManageHelp", "Workbasket");
	}
	// Sprint 4.2

		@FindBy(xpath = "//span[text()='Items Discussed During Manage Enrollment & Billing Review']")
		WebElement itemsDiscussedSectionEAndB;

		@FindBy(xpath = "//div[@title='Disclose Items Discussed During Manage Enrollment & Billing Review']//i[@class='icon icon-openclose']")
		WebElement collapseIndicator;

		@FindBy(xpath = "")
		WebElement collapseIndicatorEnrollment;

		@FindBy(xpath = "")
		WebElement collapseIndicatorBilling;

		@FindBy(xpath = "(//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png'])[1]")
		WebElement enrollmentInfoCheck;

		@FindBy(xpath = "//span[starts-with(text(),'To send this information')]")
		WebElement enrollmentInstText;
		
		@FindBy(xpath = "//img[@src='webwb/cpmexpressiconcheckmark_11148911623.png!!.png']")
		WebElement billingInfoCheck;

		@FindBy(xpath = "//span[contains(text(),'You will')]")
		WebElement billingInstText;

		public boolean verifyItemsDiscusseDuringManageEAndBReviewSectionIsCollapsed() {
				return this.collapseIndicator.isDisplayed() && this.itemsDiscussedSectionEAndB.isDisplayed();
		}

		public boolean expandTheItemsDiscusseDuringManageEAndBReviewSection() {		
			return !utils.isProxyWebelement(collapseIndicator);
		}

		public boolean expandTheEnrollmentRelatedEnquirySection() {
			return !utils.isProxyWebelement(collapseIndicatorEnrollment);
		}

		public boolean expandTheBillingRelatedEnquirySection() {	
			return !utils.isProxyWebelement(collapseIndicatorBilling);
		}

		public boolean verifyEnrollmentInfoDiscussedTextAndEnrollmentInstructionalTextIsDisplayed() {
				if (this.enrollmentInfoCheck.isDisplayed() && this.enrollmentInstText.isDisplayed())
				{
					String actualText = "To send this information to the Enrollment and Billing area use Request Enrollment and Billing Actions from Other Actions on Complete Enrollment and Billing Review screen.";
					String expectedText = enrollmentInstText.getText().replaceAll(",", "").trim();
					return utils.isvalueMatch_contain(actualText, expectedText);
				}
					return false;

		}
		
		
		 
		public boolean verifyBillingInfoDiscussedTextAndBillingInstructionalTextIsDisplayed() {
				if (this.billingInfoCheck.isDisplayed() && this.billingInstText.isDisplayed()) {
					String actualText = " You will need to contact the group administrator for any billing questions the member has keep the member on the call while you call the group because they will need to validate the member is on the phone with you before they can discuss any billing information with you and the member.";
					String expectedText = billingInstText.getText().replaceAll(",", "").trim();
					return utils.isvalueMatch_contain(actualText, expectedText);
				}
				return false;
		}
		
		@FindBy(id="PolicyState")
		WebElement PolicyState;
		
		/**Select the Policy state available in Dropdown in the resolve manager help
	     * 
	      */

		
		public boolean AssignPolicyState(String[] state)
		{
			return	utils.selectDropDownbyVisibleString(PolicyState, state[0], "Resolve Manager Help", "PolicyState");
	
		}
		
		@FindBy(xpath="//button[@data-test-id='20150917174441083819198']")
		WebElement lnkToolsIcon;
	
		
		
		public boolean clickOnToolsIcon()
		{
			return utils.clickAnelemnt(lnkToolsIcon, "ResolveManagerHelp", "Tools Icon");
		}
		
		
		public boolean clickOnViewSkillsOption()
		{
			return utils.selectValueFromListbyVisibleString(lnkToolsIcon, "View Skills", "ResolveManagerHelp", "View Skills");
		}
		
		@FindBy(xpath="//table[@pl_prop='tmpSkills.pxResults']")
		WebElement tblViewSkills;
		
		
		public boolean  verifySkillIsPresent(String[] args)
		{
			return utils.validatetablerowbasedonvalues(tblViewSkills, args);
		}

		
		
}
