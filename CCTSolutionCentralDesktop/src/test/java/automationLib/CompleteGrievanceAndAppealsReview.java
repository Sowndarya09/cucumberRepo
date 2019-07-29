package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CompleteGrievanceAndAppealsReview {

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement0;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement1;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCGAR;

	@FindBy(id="ReasonForContact")
	private WebElement reasonForContact;

	@FindBy(id="pyNote")
	private WebElement notesTxt;

	@FindBy(xpath="//button[@title='Complete this assignment']")
	private WebElement btnSubmit;

	DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	/**
	 * Constructor for the CompleteGrievanceAndAppealsReview class defining the Iframe and the Page Factory  
	 */
	public CompleteGrievanceAndAppealsReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);// change the driver to point subTask
		}catch(Exception e){
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateCompleteGrievanceAndAppealsReview
	 * #Description:This method validate if user is on 'Complete Grievance And Appeals Review' page
	 * Type:TextBox
	 */
	public boolean validateCompleteGrievanceAndAppealsReview() throws InterruptedException{
		utils.waitforpageload();
		return utils.validateHeader(this.sHeaderCGAR, "Complete Grievance And Appeals Review");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateGrievanceAndAppealsReview
	 * #Description:This method validate if user is on 'Grievance And Appeals Review' page
	 * Type:TextBox
	 */
	public boolean validateGrievanceAndAppealsReview() throws InterruptedException{
		utils.waitforpageload();
		return utils.validateHeader(this.sHeaderCGAR, "Grievance and Appeal Review");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:completeGrievanceAndAppealsReviewDetails
	 * #Description:This method fills the details 'Reason for Contact and Notes' on 'Complete Grievance And Appeals Review' page.
	 * #Arguments:'Reason for Contact' and 'Notes'
	 * Type:Dropdown and TextBox
	 * Keys:Discuss dissatisfaction with Anthem#Discuss dissatisfaction with a Provider#Discuss dissatisfaction with membership/eligibility#Discuss dissatisfaction with a claim issue#Discuss dissatisfaction with an Out of Network Referral#Discuss dissatisfaction with a Pre-Authorization
	 */
	public boolean completeGrievanceAndAppealsReviewDetails(String args[]){
		if(utils.selectDropDownbyVisibleString(this.reasonForContact, args[0], "CompleteGrievanceAndAppealsReview", "Reason for Contact"))
			return utils.enterTextinAnelemnt(this.notesTxt, args[1], "CompleteGrievanceAndAppealsReview", "Notes");
		return false;
	}
	
	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;
	
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
	
	public boolean isMemberCompositeReached(){
		utils.waitforpageload();
		try {
			gotoLastIframe();
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			err.logError(e, "unhandled  alert error in switiching frame");
			e.printStackTrace();
		}
		return !utils.isProxyWebelement(tabMbrCompositeMember);

	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmitInCGAR
	 * #Description:This method clicks on submit button in 'Complete Grievance And Appeals Review' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmitInCGAR(){

		if(utils.clickAnelemnt(btnSubmit, "Complete Grievance And Appeals Review page", "btnSubmit"))
				return isMemberCompositeReached();
		return false;
	}
	
	public boolean clickOnSubmit(){

		return utils.clickAnelemnt(btnSubmit, "Complete Grievance And Appeals Review page", "btnSubmit");
		

	}
		/*
		 * try{ WebElement element = this.btnSubmit; ((JavascriptExecutor)
		 * Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);",
		 * element); JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		 * executor.executeScript("arguments[0].click();", element); System.out.
		 * println("Submit clicked successfully - on Complete Grievance And Appeals Review page"
		 * ); return true; }catch(Exception e){
		 * err.logcommonMethodError("clickOnSubmitInCGAR",
		 * "Unable to click on Submit button in Complete Grievance And Appeals Review page"
		 * +e); return false; }
		 */

/*//		try{
//			WebElement element = this.btnSubmit;
//			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
//           JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
//			executor.executeScript("arguments[0].click();", element);
//			//System.out.println("Submit clicked successfully - on Complete Grievance And Appeals Review page");
//			//return true;
//			if(utils.clickAnelemnt(this.btnSubmit, "Request Enrollment and Billing Action", "Submit Button"))
//				return isMemberCompositeReached();
//			return false;
//		}catch(Exception e){
//			err.logcommonMethodError("clickOnSubmitInCGAR", "Unable to click on Submit button in Complete Grievance And Appeals Review page"+e);
//			return false;
//		}
//	
*/

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateReasonForContactDrpdown
	 * #Description:This method validates the dropdown values displayed for 'Reason for Contact' on 'Complete Grievance And Appeals Review' page.
	 * Type:TextBox
	 */
	public boolean validateReasonForContactDrpdown(){
		String reason[] = {"Discuss dissatisfaction with Anthem","Discuss dissatisfaction with a Provider","Discuss dissatisfaction with membership/eligibility","Discuss dissatisfaction with a claim issue","Discuss dissatisfaction with an Out of Network Referral","Discuss dissatisfaction with a Pre-Authorization"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(reason));
		return utils.checkvaluesinDropDown(this.reasonForContact,al);
	}

	@FindBy(xpath="//span[text()='Items Discussed During Grievance and Appeals Review']")
	private WebElement lbl_ItemsDiscussedDuringGAReview;

	@FindBy(xpath="//*[@for='WasTheDissatisfaction']//parent::div//div/span")
	private WebElement txt_WastheDissatisfaction;

	@FindBy(xpath="//*[@for='WasTheDissatRelatedTo']//parent::div//div/span")
	private WebElement txt_WastheDissatisfactionRelatedTo;

	@FindBy(xpath="//*[@for='IsOneDayGrievanceResolved']//parent::div//div/span")
	private WebElement txt_ResolveMemberComplaint;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyItemsDiscussedDuringGAReview
	 * #Description:This method verifies 'Items Discussed during Grievance and Appeals Review' on 'Complete Grievance And Appeals Review' page.
	 * #Arguments:DissatisfactionReason-KeyValuePair
	 * Type:Table
	 * Keys:Was the Dissatisfaction#Was the Dissatisfaction related to#Resolve Member Complaint
	 */
	public boolean verifyItemsDiscussedDuringGAReview(String args[]){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.lbl_ItemsDiscussedDuringGAReview);
		boolean returnvar;
		returnvar = true;
		if(utils.validateLabel(this.lbl_ItemsDiscussedDuringGAReview, "Items Discussed During Grievance and Appeals Review"))
		{
			String keyvaluepair="";
			for(String iterator : args)
			{
				if(!returnvar)
				{
					err.logcommonMethodError("verifyItemsDiscussedDuringGAReview", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(key.equalsIgnoreCase("Was the Dissatisfaction")){
					try{
						returnvar = this.txt_WastheDissatisfaction.getText().toLowerCase().trim().equalsIgnoreCase(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("verifyItemsDiscussedDuringGAReview", "Exception occured while retrieving 'Was the Dissatisfaction' in - Items Discussed During Grievance and Appeals Review");
						return false;
					}
					continue;}
				else if(key.equalsIgnoreCase("Was the Dissatisfaction related to")){
					try{
						returnvar = this.txt_WastheDissatisfactionRelatedTo.getText().toLowerCase().trim().equalsIgnoreCase(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("verifyItemsDiscussedDuringGAReview", "Exception occured while retrieving 'Was the Dissatisfaction related to' in - Items Discussed During Grievance and Appeals Review");
						return false;
					}
					continue;}
				else if(key.equalsIgnoreCase("Resolve Member Complaint")){
					try{
						returnvar = this.txt_ResolveMemberComplaint.getText().toLowerCase().trim().equalsIgnoreCase(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("verifyItemsDiscussedDuringGAReview", "Exception occured while retrieving 'Resolve Member Complaint' in - Items Discussed During Grievance and Appeals Review");
						return false;
					}
					continue;}
				else 
					err.logcommonMethodError("verifyItemsDiscussedDuringGAReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		}else
			err.logError("CompleteGrievanceAndAppealsReview", "ItemsDiscussedDuringGAReview section is not displayed");

		if(returnvar)
		{
			System.out.println("CompleteGrievanceAndAppealsReview- ItemsDiscussedDuringGAReview info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("CompleteGrievanceAndAppealsReview", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActions
	 * #Description:This method verifies 'Other Actions' section is displayed on 'Complete Grievance And Appeals Review' page
	 * Type:TextBox
	 */
	public boolean verifyOtherActions(){
		return !utils.isProxyWebelement(btnOtherActions);
	}

	@FindBy(xpath="//span[@data-test-id='201801251040560076186883']")
	private WebElement Type;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Category']//following-sibling::div//span")
	private WebElement Category;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Sub-Category']//following-sibling::div//span")
	private WebElement subCategory;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Corporate Received Date']//following-sibling::div//span")
	private WebElement corpReceivedDate;

	@FindBy(xpath="//div[@node_name='GAndAReviewItems']//label[text()='Expedited Appeal?']//following-sibling::div")
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

	@FindBy(xpath="//span[text()='Document References']")
	private WebElement DocReferencesTable;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateDocumentReferences
	 * #Description:This method validates Document References during GAReview on Complete Grievance And Appeals Review page
	 * #Arguments:Doc References
	 * Type:Table
	 * Keys:#Reference Type#Document Reference Number
	 */
	public boolean validateDocumentReferences(String args[]){
		Driver.pgDriver.findElement(By.xpath("//span[text()='Document References']")).click();
		System.out.println("Document References Section is displayed");
		utils.waitforpageload();
		boolean returnvar = true;
		String reference_type = "",doc_reference_no="";
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateDocumentReferences", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.equalsIgnoreCase("Reference Type")){
				reference_type = value.trim();
				returnvar = true;
				continue;}
			else if(key.equalsIgnoreCase("Document Reference Number")){
				doc_reference_no = value.trim();
				returnvar = true;
				continue;}
			else{
				err.logcommonMethodError("CompleteGrievanceAndAppealsReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				returnvar = false;
			}
		}
		try{
			if(Driver.pgDriver.findElement(By.xpath("//span[text()='"+reference_type+"']//ancestor::td[@data-attribute-name='Reference Type']//following-sibling::td[@data-attribute-name='Document Reference Number']//span[text()='"+doc_reference_no+"']")).isDisplayed()){
				returnvar = true;
			}
		}catch(Exception e){
			err.logcommonMethodError("CompleteGrievanceAndAppealsReview", "validateDocumentReferences"+e);
			return false;
		}
		return returnvar;

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
	public boolean validateProvidersReviewedWithContact(String args[]){
		try{
			WebElement row =utils.getProviderResultsBasedOnValues(this.reviewTaggedProviderTable,args);
			System.out.println(row.getAttribute("pl_index"));
			List<WebElement> chkBox = row.findElements(By.xpath("//td[contains(@data-attribute-name,'.pyTemplateInputBox')]//img"));
			if(chkBox.get(1).isDisplayed()){
				System.out.println("Grievance and Appeal is checked");
			}
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given Provider input" + e);
			return false;
		}
		return true;
	}

	@FindBy(xpath="//table[@pl_prop='.AccountSummary'][@class='gridTable ']")
	private WebElement CDHPAccountsLevelTable;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCDHPAccountandGATagged
	 * #Description:This method validates the CDHP Accounts tagged with GA Indicator checked.
	 * #Arguments:CDHPGATagged
	 * Type:Table
	 * Keys:Account Description#Status#Effective Date#Plan Start Date#Plan End Date
	 */
	public boolean validateCDHPAccountandGATagged(String args[]){
		try{
			WebElement row =utils.getProviderResultsBasedOnValues(this.CDHPAccountsLevelTable,args);
			List<WebElement> GAchkbox = row.findElements(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')][@headers='a3']//img"));
			if(GAchkbox.get(0).isDisplayed()){
				System.out.println("Grievance and Appeal is checked");
			}
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input CDHP -in Account Level" + e);
			return false;
		}
		return true;
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
	public boolean validateAuthorizationWithGATagged(String args[]){
		try{
			WebElement row =utils.getProviderResultsBasedOnValues(this.AuthorizationDiscussedTable,args);
			List<WebElement> GAchkbox = row.findElements(By.xpath(".//td[@headers='a2']//img"));
			if(GAchkbox.get(0).isDisplayed()){
				System.out.println("Grievance and Appeal is checked");
			}
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input Authorization" + e);
			return false;
		}
		return true;
	}

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Grievance and Appeals']")	
	private WebElement lnkOtherGrievanceAndAppeals;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Manager Help']")	
	private WebElement lnkOtherReqMgrHelp;
	@FindBy (xpath="//input[@id='GAAckLetterRequestedNo']")
	private WebElement AcknowledgeLetterNo;
	@FindBy (xpath="//input[@id='GAAckLetterRequestedYes']")
	private WebElement AcknowledgeLetterYes;
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActionsRequestManagerHelp
	 * #Description:This method verifies Other Actions section  displays 'Request Manager Help' on Complete Grievance And Appeals Review page
	 * Type:Textbox
	 */
	public boolean verifyOtherActionsRequestManagerHelp(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteGrievanceAndAppealsReview", "Other Actions button"))
			return !utils.isProxyWebelement(lnkOtherReqMgrHelp);
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActionsGrievanceAndAppeals
	 * #Description:This method verifies Other Actions section  displays 'Grievance And Appeals' on Complete Grievance And Appeals Review page
	 * Type:Textbox
	 */
	public boolean verifyOtherActionsGrievanceAndAppeals(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteGrievanceAndAppealsReview", "Other Actions button"))
			return !utils.isProxyWebelement(lnkOtherGrievanceAndAppeals);
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectReasonForContactAndNotes
	 * #Description:This method fills the details 'Reason for Contact and Notes' on 'Complete Grievance And Appeals Review' page.
	 * #Arguments:'Reason for Contact' and 'Notes'
	 * Type:Dropdown and TextBox
	 * Keys:Discuss dissatisfaction with Anthem#Discuss dissatisfaction with a Provider#Discuss dissatisfaction with membership/eligibility#Discuss dissatisfaction with a claim issue#Discuss dissatisfaction with an Out of Network Referral#Discuss dissatisfaction with a Pre-Authorization#Filed a grievance#Filed an appeal#Status request
	 */
	public boolean selectReasonForContactAndNotes(String args[]) throws Exception{
		utils.waitforpageload();
		Thread.sleep(2000);
		try {
		if(utils.selectDropDownbyVisibleString(this.reasonForContact, args[0], "CompleteGrievanceAndAppealsReview", "Reason for Contact"))
			if(utils.enterTextinAnelemnt(this.notesTxt, args[1], "CompleteGrievanceAndAppealsReview", "Notes"))
				if(args[2].equalsIgnoreCase("Yes")){
					return utils.clickAnelemnt(AcknowledgeLetterYes,"CompleteGrievanceAndAppealsReview", "AcknowledgeLetter Yes");
				}else{
					return utils.clickAnelemnt(AcknowledgeLetterNo,"CompleteGrievanceAndAppealsReview", "AcknowledgeLetter No");
				}
		}catch(ArrayIndexOutOfBoundsException ex) {
			return true;
		}
		return false;
	}

	@FindBy(xpath="//div[@node_name='InWritingGandAMessage']//p")
	WebElement txtWrittingMessageForVA;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateWritingMessageDisplayedForVAExpedited
	 * #Description: This functionality validates that the Writing message for VA member is displayed in the Grievance and Appeals page
	 * Type: Textbox
	 */
	public boolean validateWritingMessageDisplayedForVAExpedited()
	{
		String actualmsg = "The member's request for an Expedited Appeal must be done in writing and can be faxed to 866-273-3692 or sent in writing to Anthem Blue Cross Blue Shield, PO Box 27401, Richmond, VA 23279, Mail drop VA2002-N160. Inform the caller to include the member‘s identification number, a description of the member's issue and what the member’s expected outcome should be.";
		String expectedmsg = txtWrittingMessageForVA.getText();
		return utils.isvalueMatch_contain(actualmsg, expectedmsg);
	}

	@FindBy(xpath="//label[@data-test-id='20180320104807059220532-Label']")
	WebElement insTxtForCA;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyCorrespondenceInstTextForCAMem
	 * #Description: This functionality validates the instructional text displayed about correspondence in the review page for CA member
	 * Type: Textbox
	 */
	public boolean verifyCorrespondenceInstTextForCAMem()
	{
		String expectedMsg="Enter the correspondence SR-ID for the acknowledgement letter you created for this Grievance or Appeal request(Required)";
		String dispMsg = this.insTxtForCA.getText().trim();
		return utils.isvalueMatch_contain(expectedMsg, dispMsg);
	}

	@FindBy(xpath="//input[@data-test-id='20180320104807059220532']")
	WebElement inputSRID;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterSRID
	 * #Description:This method enter SR ID to the field 'Enter the correspondence SR-ID for the acknowledgement letter you created for this Grievance or Appeal request' in the Complete Grievance and Appeals Review 
	 * #Arguments:SRID
	 * Type:Textbox
	 */
	public boolean enterSRID(String[] args){
		if(this.inputSRID.getAttribute("maxlength").equalsIgnoreCase("20"))
			return utils.enterTextinAnelemnt(this.inputSRID, args[0], "Complete GrievanceAndAppeals Review", "SR ID");
		return false;
	}

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Create Correspondence']")   
	private WebElement lnkOtherCreateCorrespondence;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActionsCreateCorrespondence
	 * #Description:This method verifies Other Actions section  displays 'CreateCorrespondence' on Complete Grievance And Appeals Review page
	 * Type:Textbox
	 */
	public boolean verifyOtherActionsCreateCorrespondence(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteGrievanceAndAppealsReview", "Other Actions button"))
			return !utils.isProxyWebelement(lnkOtherCreateCorrespondence);
		return false;
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyNoCreateCorrespondenceForNonCAMemInOtherActions
	 * #Description:This method verifies Other Actions section  not displays 'CreateCorrespondence' on Complete Grievance And Appeals Review page
	 * Type:Textbox
	 */
	public boolean verifyNoCreateCorrespondenceForNonCAMemInOtherActions(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteGrievanceAndAppealsReview", "Other Actions button"))
			return utils.isProxyWebelement(lnkOtherCreateCorrespondence);
		return false;
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateToCreateCorrespondenceForCAMemInOtherActions
	 * #Description:This method navigates to the Corrrespondence page from Complete Grievance And Appeals Review page
	 * Type:Textbox
	 */
	public boolean navigateToCreateCorrespondenceForCAMemInOtherActions(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteGrievanceAndAppealsReview", "Other Actions button"))
			if(!utils.isProxyWebelement(lnkOtherCreateCorrespondence))
				return  utils.clickAnelemnt(this.lnkOtherCreateCorrespondence, "CompleteGrievanceAndAppealsReview", "Other Actions button");
		return false;
	}

	@FindBy(xpath="//span[@data-test-id='201711151513110065276622']")
	private WebElement wasdissatisfaction;

	@FindBy(xpath="//span[@data-test-id='201711151513110065277122']")
	private WebElement wasdissatisfactionrelatedto;

	@FindBy(xpath="//span[@data-test-id='201711151513110065278265']")
	private WebElement memberscomplaint;


	public boolean validateItemsDiscussedInGAReviewSectionForDissatisfaction(String args[]){
		utils.waitforpageload();
		boolean returnvar = true;
		String dissatisfaction = "",dissatisfactionrelatedto="",memberscomplaint="";
		String was_dissatisfaction="",was_dissatisfaction_related="",members_complaint="";
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateItemsDiscussedInGAReviewSectionForDissatisfaction", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.equalsIgnoreCase("Was Dissatisfaction")){
				was_dissatisfaction = value.trim();
				if(was_dissatisfaction.equalsIgnoreCase(this.wasdissatisfaction.getText().trim())){
					returnvar = true;
					System.out.println("Dissatisfaction matched with user input");
					continue;
				}else{
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSectionForDissatisfaction", "Dissatisfaction mis-matched with user input");
				}
			}else if(key.equalsIgnoreCase("Was Dissatisfaction Related To")){
				was_dissatisfaction_related = value.trim();
				if(was_dissatisfaction_related.equalsIgnoreCase(this.wasdissatisfactionrelatedto.getText().trim())){
					returnvar = true;
					System.out.println("Dissatisfaction Related To matched with user input");
					continue;
				}else{
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSectionForDissatisfaction", "Dissatisfaction Related To mis-matched with user input");
				}
			}else if(key.equalsIgnoreCase("Members Complaint")){
				members_complaint = value.trim();
				if(members_complaint.equalsIgnoreCase(this.memberscomplaint.getText().trim())){
					returnvar = true;
					System.out.println("Members Complaint matched with user input");
					continue;
				}else{
					returnvar = false;
					err.logcommonMethodError("validateItemsDiscussedInGAReviewSectionForDissatisfaction", "Members Complaint mis-matched with user input");
				}
			}
			else{
				err.logcommonMethodError("validateItemsDiscussedInGAReviewSectionForDissatisfaction", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				returnvar = false;
			}
		}

		return returnvar;
	}

	@FindBy(xpath="//div[@gpropindex='PReviewedClaims1']//table[@pl_prop='.ReviewedClaims']")
	WebElement tblClaimsTaggedInGA;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimsWithTaggedGA
	 * #Description:This method validates the 'Claims tagged forvalidateClaimsWithGATagged G&A' section displayed as part of Grievance and Appeals SR
	 * #Arguments:Claims Tagged
	 * Type:Textbox
	 */
	public boolean validateClaimsWithTaggedGA(String[] tablevalues){
		WebElement element = this.tblClaimsTaggedInGA;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.validatetablerowbasedonvalues(this.tblClaimsTaggedInGA, tablevalues);
	}


	@FindBy(xpath="")
	WebElement imgOneDayGrievanceIndicator;

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


	@FindBy(xpath="//table[@pl_prop='.ReviewedClaims']//img[@data-test-id='20160127122348051611158']")
	WebElement imgOneDayGrievance;

	public boolean verifyClaimHasOneDayGrievanceIndicatorIsDisplayedInItemsReviewedTable()
	{
		WebElement table = this.tblClaimsTaggedInGA;
		WebElement imgOneDayGrievance = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.ReviewedClaims']//img[@data-test-id='20160127122348051611158']"));
		return !utils.isProxyWebelement(imgOneDayGrievance);
	}

	@FindBy(xpath="//label[@for='GAAckLetterRequested']")
	WebElement labelGAAckLetter;

	@FindBy(id="GAAckLetterRequestedNo")
	WebElement rdoBtnInAckLetterNo;

	@FindBy(id="GAAckLetterRequestedYes")
	WebElement rdoBtnInAckLetterYes;

	@FindBy(xpath="//table[@pl_prop='D_GACorrSentLettersByMemberID.pxResults']")
	WebElement tblAckLetter;

	@FindBy(xpath="//div[contains(text(),'Refresh')]")
	WebElement btnRefresh;

	public boolean verifyTheCorrespondenceMessageIsDisplayed()
	{
		return !utils.isProxyWebelement(labelGAAckLetter);
	}

	public boolean verifyRefreshButtonIsDisplayed()
	{
		return !utils.isProxyWebelement(btnRefresh);
	}

	public boolean selectYesOrNoInCorrespndanceMessageQuestion(String[] args)
	{
		if(args[0].contains("Yes"))
		{
			return utils.clickAnelemnt(rdoBtnInAckLetterYes, "CompleteGrievanceAndAppeals", "Yes in Ack Letter");
		}else if(args[0].contains("No"))
		{
			return utils.clickAnelemnt(rdoBtnInAckLetterNo, "CompleteGrievanceAndAppeals", "No in Ack Letter");
		}
		return false;
	}

	public boolean clickOnRefreshButton()
	{
		return utils.clickAnelemnt(btnRefresh, "CompleteGrievanceAndAppeals", "Refresh button");
	}


	public boolean validateTheLettersTableAndSelectCorrespondingRadioButton(String[] tablevalues)
	{
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblAckLetter, tablevalues);
			List<WebElement> rowValue = row.findElements(By.tagName("td"));
			rowValue.get(0).click();
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception e: "+e);
			err.logcustomerrorwithmessage("CompleteGrievanceAndAppeals", "validateLetterTableAndSelectTheRespectiveLetter", "Error in Selecting Letters");
			return false;
		}
	}


	@FindBy (xpath="//li//span[contains(text(),'Request Manager Help')]")	
	private WebElement lnkOthrActionsRequestManagerHelp;

	public boolean navigatetoRequestManagerHelp()
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Manager/OE Help", "CompleteGrievanceAndAppealsReview", "Request Manager Help");
	}

	@FindBy(xpath="//span[contains(text(),'You have indicated that the Grievance and Appeal is related to a Claim')]")
	WebElement ClaimsTextMessage;

	@FindBy(xpath="//div[@node_name='GAndAReview']//p//span")
	WebElement AuthorizationTextMessage;

	@FindBy(xpath="//a[@class='Suggested_task']")
	WebElement ManageClaimsSuggestedTask;

	@FindBy(xpath="//a[@class='Suggested_task']")
	WebElement ManageAuthorizationsSuggestedTask;

	public boolean validateTheClaimText(String[] args)
	{
		String actualText = args[0];
		System.out.println("Actual Text: "+actualText);
		String expectedText = ClaimsTextMessage.getText().replaceAll(",", " ").trim();
		System.out.println("Expected Text: "+expectedText);
		return utils.isvalueMatch_contain(actualText, expectedText);

	}


	public boolean validateTheAuthorizationText(String[] args)
	{
		String actualText = args[0];
		System.out.println("Actual Text: "+actualText);
		String expectedText = AuthorizationTextMessage.getText().replaceAll(",", " ").trim();
		System.out.println("Expected Text: "+expectedText);
		return utils.isvalueMatch_contain(actualText, expectedText);   			
	}

	public boolean verifyManageClaimsSuggestedTaskIsDisplayed()
	{
		return !utils.isProxyWebelement(ManageClaimsSuggestedTask);
	}

	public boolean verifyManageAuthorizationsSuggestedTaskIsDisplayed()
	{
		return !utils.isProxyWebelement(ManageAuthorizationsSuggestedTask);
	}


	@FindBy(xpath="//span[contains(text(),'All provider post-service')]")
	WebElement ProviderMedAppealText;

	public boolean validateTheProviderMedicalAppealInstText(String[] args) {
		System.out.println(ProviderMedAppealText.getText());
		return utils.validateLabel(ProviderMedAppealText, args[0]);
	}


	/**
	 * This functionality navigates to the Request Manager/OE help from the complete grievance and appeals Review page
	 * @param args
	 * @return
	 */
	public boolean selectRequestManagerHelpFromOtherActions() throws InterruptedException
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Manager/OE Help", "GrievanceAndAppealsReview", "Request Manager/OE Help");
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Wrap Up']")
	WebElement btnMbrCompositeWrapup;
	
	public boolean clickwrapUpafterODGClaimTask() {
		utils.waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
	  //  Driver.getPgDriver().switchTo().frame(this.Iframeelement0);
	    return utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");
	}
	
	
}


