package automationLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ManageReferralReview {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	public ManageReferralReview(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	@FindBy(id="ReasonForAlert")
	WebElement drpDownReasonForContact;

	@FindBy(id="Notes")
	WebElement txtNotes;

	@FindBy(xpath="//select[@id='DocumentReferenceType1']")
	WebElement drpDownRefType1;

	@FindBy(xpath="//input[@id='DCNDocumentIDIndicator1']")
	WebElement txtRefNum1;

	@FindBy(xpath="//select[@id='DocumentReferenceType2']")
	WebElement drpDownRefType2;

	@FindBy(xpath="//input[@id='DCNDocumentIDIndicator2']")
	WebElement txtRefNum2;

	@FindBy(xpath="//table[@pl_prop='.DocumentReferenceNumber']//a[contains(text(),'Add')]")
	WebElement lnkAddIcon;

	@FindBy(xpath="//table[@pl_prop='.DocumentReferenceNumber']//a[contains(text(),'Delete')]")
	WebElement lnkDeleteIcon;

	@FindBy(xpath="//table[@pl_prop='.ReferralOverviewList']")
	WebElement tblItemsScheduled;

	@FindBy(xpath="//span[contains(text(),'Items Scheduled During Manage Referrals')]")
	WebElement lnkItemsScheduled;

	@FindBy(xpath="//span[contains(text(),'Document References')]")
	WebElement lnkDocumentReference;

	@FindBy(xpath="//span[contains(text(),'Items Discussed During Manage Referrals')]")
	WebElement lnkItemsDiscussed;

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy(xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Manage Referrals')]")
	WebElement lnkManageReferral;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectReasonForContact
	 * #Description: This functionality selects the value given by the user in the Select Reason For Contact dropdown section.
	 * #Argument: reason
	 * Type: Dropdown
	 * Keys: Sent clinical referral(s)#Reviewed clinical referrals#Reviewed clinical correspondence "
	 */
	public boolean selectReasonForContact(String[] reason)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReasonForContact, reason[0], "ManageReferralReview", "Reason For Contact");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterNotes
	 * #Description: This functionality enters the notes in the notes section in the Manage Referral Review page
	 * #Argument: notes
	 * Type: Textbox
	 */
	public boolean enterNotes(String[] notes)
	{
		return utils.enterTextinAnelemnt(this.txtNotes, notes[0], "ManageReferralReview", "Notes");
	}


	public boolean clickItemsDiscussed()
	{
		return utils.clickAnelemnt(this.lnkItemsDiscussed, "ManageReferralReview", "Item Discussed");
	}

	public boolean clickItemsScheduled()
	{
		return utils.clickAnelemnt(this.lnkItemsScheduled, "ManageReferralReview", "Item Scheduled");
	}

	public boolean clickDocumentReference()
	{
		return utils.clickAnelemnt(this.lnkDocumentReference, "ManageReferralReview", "Item Scheduled");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateTheItemsScheduledInManageReferrals
	 * #Description: This functionality validates the values given by the user with the values present in the Items scheduled table.
	 * #Argument: tablevalues
	 * Type: Table
	 * Keys: Referral Reason#Action / Transfer Outcome#Referral Vendor Program#Call Back Date#Call Back Time
	 */
	public boolean validateTheItemsScheduledInManageReferral(String[] tablevalues) throws InterruptedException
	{
		this.clickItemsScheduled();
		WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.ReferralOverviewList']"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		WebElement row = utils.returntablerowbasedonvalues(tblItemsScheduled, tablevalues);
		List<WebElement> chckBoxes = row.findElements(By.tagName("td"));
		chckBoxes.get(1).click();
		return true;
	}

	@FindBy(xpath="//label[@for='IsReferralHistoryInformation']")
	WebElement labelRefHistoryCheckBox;

	@FindBy(xpath="//label[@for='IsCorrespondenceInfoDiscussed']")
	WebElement labelCorrespondenceCheckBox;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyThatTheReferralHistoryInformationIsDisplyaedUnderItemsDiscussed
	 * #Description: This functionality verifies that the Referral History Information is Displayed under Items discussed section.
	 * Type: Textbox
	 */
	public boolean verifyThatTheReferralHistoryInformationIsDisplyaedUnderItemsDiscussed()
	{
		if(this.clickItemsDiscussed())
			return !utils.isProxyWebelement(labelRefHistoryCheckBox);
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyThatTheReferralHistoryInformationIsDisplyaedUnderItemsDiscussed
	 * #Description: This functionality verifies that the Referral History Information is Displayed under Items discussed section.
	 * Type: Textbox
	 */
	public boolean verifyThatTheCorrespondenceInformationIsDisplyaedUnderItemsDiscussed()
	{
		if(this.clickItemsDiscussed())
			return !utils.isProxyWebelement(labelCorrespondenceCheckBox);
		return false;
	}



	/*
	 * @SCU
	 * #CommonMethodWithArgument: addDocumentReferences
	 * #Description: This functionality clicks the Add Icon in the Document reference section and selects the document reference type and then enters the document reference number.
	 * #Argumnet : Reference Type and Reference Number
	 * Type: Textbox and Dropdown
	 * Keys: Select#DCN#Document ID
	 */
	public boolean addDocumentReferences(String[] args){
		try{
			utils.clickAnelemnt(this.lnkAddIcon, "ManageReferralReview", "Add Document References");
			utils.waitforpageload();
			List<WebElement> l=Driver.pgDriver.findElements(By.xpath("//select[contains(@id,'DocumentReferenceType')]"));
			System.out.println("Size is : "+l.size());
			if(l.size()>1){
				utils.selectDropDownbyVisibleString(this.drpDownRefType2, args[0], "ManageReferralReview", "Reference Type 2");
				utils.enterTextinAnelemnt(this.txtRefNum2, args[1], "ManageReferralReview", "Document Reference Number 2");
				this.txtRefNum2.sendKeys(Keys.TAB);
			}else if(l.size()==1){
				utils.selectDropDownbyVisibleString(this.drpDownRefType1, args[0], "ManageReferralReview", "Reference Type 1");
				utils.enterTextinAnelemnt(this.txtRefNum1, args[1], "ManageReferralReview", "Document Reference Number 1");
				this.txtRefNum1.sendKeys(Keys.TAB);
			}else{
				System.out.println("Element not found");
			}
		}catch(Exception e){
			err.logError("ManageReferralReview", "addDocumentReferences");
			System.out.println("Unable to enter value to field - Reference Type and Document Reference Number"+e);
			return false;
		}
		return true;
	}



	/*
	 * @SCU
	 * #CommonMethodwithArgument: deleteDocumentReferences
	 * #Description: This functionality validate the reference type and the document number of the matched row and then clicks the delete Icon in the Document reference section.
	 * #Arguments:Reference Type and Document Reference Number
	 * Type:Dropdown and Textbox
	 * Keys:DCN#Document ID
	 */
	public boolean deleteDocumentReferences(String[] args){
		Driver.pgDriver.findElement(By.xpath("//select[contains(@id,'DocumentReferenceType')]//option[text()='"+args[0]+"'][@selected]")).click();
		Driver.pgDriver.findElement(By.xpath("//input[contains(@id,'DCNDocumentIDIndicator')][@value='"+args[1]+"']")).click();
		return utils.clickAnelemnt(this.lnkDeleteIcon, "ManageReferralReview", "Delete Document References");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToManageReferral
	 * #Description: This functionality navigates to the Manage Referral section from the Manage Referral Review page
	 * Type: Textbox
	 */
	public boolean navigateToManageReferral()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageReferralReview", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkManageReferral, "ManageReferralReview", "Manage Referral");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on the Submit button in the Manage Referral Review page
	 * #Type: Textbox
	 */
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "ManageReferralReview", "Submit");			
	}

	@FindBy(xpath="//div[@id='DialogContent' and contains(text(), 'You can find Programs')]")
	WebElement txtGuidedMsg;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyGuidedDialogisNotPresentInReviewScreen
	 * #Description: This functionality verifies the absence of Guided Dialog box in the Manage Referral Review page
	 * Type: Textbox
	 */
	public boolean verifyGuidedDialogisNotPresentInReviewScreen (){
		return utils.isProxyWebelement(txtGuidedMsg);
	}
}
