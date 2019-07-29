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

	public class ManageAlertReview {

		SeleniumUtilities utils = new SeleniumUtilities();
		ErrorLogger err=new ErrorLogger();
		BaseLogger blogger = new BaseLogger();
		Home home = new Home();
		Actions action=new Actions(Driver.getPgDriver());

		@FindBy(id="PegaGadget2Ifr")
		WebElement Iframeelement;
		
		public ManageAlertReview(){
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}

		
		
		@FindBy(id="ReasonForAHGContact")
		WebElement drpDownReasonForContact;
		
		@FindBy(id="Notes")
		WebElement txtNotes;
		
		@FindBy(id="DocumentReferenceType1")
		WebElement drpDownRefType;
		
		@FindBy(id="")
		WebElement txtRefNum;
		
		@FindBy(xpath="//a[contains(text(),'Add')]")
		WebElement lnkAddIcon;
		
		@FindBy(xpath="//a[contains(text(),'Delete')]")
		WebElement lnkDeleteIcon;
		
		@FindBy(xpath="//span[contains(text(),'Items Reviewed During Manage Alerts')]")
		WebElement lnkItemsReviewed;
		
		@FindBy(xpath="//table[@pl_prop='.ReferralOverviewList']")
		WebElement tblItemsScheduled;
		
		@FindBy(xpath="//table[@pl_prop='D_AHGAlerts.pxResults']")
		WebElement tblItemsReviewed;
		
		@FindBy(xpath="//span[contains(text(),'Items Scheduled During Manage Referrals')]")
		WebElement lnkItemsScheduled;
		
		@FindBy(xpath="//span[contains(text(),'Items Discussed During Manage Referrals')]")
		WebElement lnkItemsDiscussed;
		
		@FindBy(xpath="//div[contains(text(),'Other actions')]")
		WebElement drpDownOtherActions;
		
		@FindBy(xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Referral Details')]")
		WebElement lnkManageReferral;
		
		@FindBy(xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Manage Alerts')]")
		WebElement lnkManageAlerts;
		
		@FindBy(xpath="//div[contains(text(),'Submit')]")
		WebElement btnSubmit;
		
		@FindBy(xpath="//div[@id='DialogContent' and contains(text(), 'You can find Programs')]")
		WebElement txtGuidedMsg;
		
		
		/*
		 * @SCU
		 * #CommonMethodWithArgument: selectReasonForContact
		 * #Description: This functionality selects the Reason For Contact drop down values in the Manage Alert Review page
		 * #Argument: reason
		 * Type: Dropdown
		 * Keys: Reviewed alerts#Sent clinical referral(s)#Reviewed Clinical referrals#Reviewed clinical correspondence
		 */
		public boolean selectReasonForContact(String[] reason)
		{
				return utils.selectDropDownbyVisibleString(this.drpDownReasonForContact, reason[0], "ManageAlertReview", "Reason For Contact");
		}
		
		
		/*
		 * @SCU
		 * #CommonMethodWithArgument: enterNotes
		 * #Description: This functionality enter the Notes text in the Notes section in the Manage Alert Review page
		 * #Argument: notes
		 * Type: Textbox
		 */
		public boolean enterNotes(String[] notes)
		{
				return utils.enterTextinAnelemnt(this.txtNotes, notes[0], "ManageReferralReview", "Notes");
		}
		
		
		public boolean selectDocumentRefType(String[] type)
		{
				return utils.selectDropDownbyVisibleString(this.drpDownRefType, type[0], "ManageAlertReview", "Reference Type");
		}
		
		public boolean enterReferenceNumber(String[] num)
		{
				return utils.enterTextinAnelemnt(this.txtRefNum, num[0], "ManageAlertReview", "Ref Num");
		}
		
		public boolean clickItemsDiscussed()
		{
			return utils.clickAnelemnt(this.lnkItemsDiscussed, "ManageReferralReview", "Item Discussed");
		}
		
		public boolean clickItemsScheduled()
		{
			return utils.clickAnelemnt(this.lnkItemsScheduled, "ManageAlertReview", "Item Scheduled");
		}
		
		public boolean clickItemsReviewed()
		{
			return utils.clickAnelemnt(this.lnkItemsReviewed, "ManageAlertReview", "Item Reviewed");
		}
		
		/*
		 * @SCU
		 * #CommonMethodWithArgument: validateTheItemsScheduledInManageReferrals
		 * #Description: This functionality expands the Items Scheduled in Manage Alerts review screen and then validates the table values with the value given by the user and with the values available in table
		 * #Argument: tablevalues
		 * #Type: Table
		 * Keys: Referral Reason#Action/Transfer Outcome#Referral Vendor Program#Call Back Date#Call Back Time
		 */
		public boolean validateTheItemsScheduledInManageReferrals(String[] tablevalues) throws InterruptedException
		{
			if(this.clickItemsScheduled())
			return utils.validatetablerowbasedonvalues(this.tblItemsScheduled, tablevalues);
			return false;
		}
		
		/*
		 * @SCU
		 * #CommonMethodWithArgument: validateTheItemsReviewedInManageAlerts
		 * #Description: This functionality expands the Items Reviewed in Manage Alerts review screen and then validates the table values with the value given by the user and with the values available in table
		 * #Argument: tablevalues
		 * #Type: Table
		 * Keys: Alert Type#Outcome
		 */
		public boolean validateTheItemsReviewedInManageAlerts(String[] tablevalues) throws InterruptedException
		{
			if(this.clickItemsReviewed())
			return utils.validatetablerowbasedonvalues(this.tblItemsReviewed, tablevalues);
			return false;
		}
		
		/*
		 * @SCU
		 * #CommonMethodWithoutArgument: clickOnSubmit
		 * #Description: This functionality performs click action on the Submit button in the Manage Alert Review page
		 * #Type: Textbox
		 */
		public boolean clickOnSubmit()
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("arguments[0].click()", btnSubmit);
			return true;
		}
		
		/*
		 * @SCU
		 * #CommonMethodWithoutArgument: verifyGuidedDialogisNotPresentInReviewScreen
		 * #Description: This functionality verifies the absence of Guided Dialog box in the Manage Alert Review page
		 * Type: Textbox
		 */
		
		public boolean verifyGuidedDialogisNotPresentInReviewScreen (){
			return !utils.isProxyWebelement(txtGuidedMsg);
			}

		@FindBy(xpath = "//select[@name='$PpyWorkPage$pGuidedDecisionSupportForAHG']")
		WebElement drpDownGuidedDecisionSupport;
		
		/*
		 * @SCU
		 * #CommonMethodWithArgument: clickPromotionalRegistrations
		 * #Description: This functionality performs click action on the check box of the promotional registrations given by the user using data
		 * Type: Textbox
		 */
		public boolean clickPromotionalRegistrations (String[] promotionalregistrations) 
		{
			String xpath = "//span[contains(text(),'"+promotionalregistrations[0]+"')]//ancestor::td[@headers='a2']//preceding-sibling::td//input[@type='checkbox']";
			System.out.println("xpath is: " + xpath);
			utils.waitforpageload();
			Driver.pgDriver.findElement(By.xpath(xpath)).click();
			return true;
		}
		
		
		/*
		 * @SCU
		 * #CommonMethodWithArgument: clickEducationalOpportunities
		 * #Description: This functionality performs click action on the check box of the educational opportunities given by the user using data
		 * Type: Textbox
		 */
		public boolean clickEducationalOpportunities (String[] EducationalOpportunities)
		{
			String xpath = "//span[contains(text(),'"+EducationalOpportunities[0]+"')]//ancestor::td[@headers='a2']//preceding-sibling::td//input[@type='checkbox']";
			System.out.println("xpath is: " + xpath);
			utils.waitforpageload();
			Driver.pgDriver.findElement(By.xpath(xpath)).click();
			return true;
		}
		
		/*
		 * @SCU
		 * #CommonMethodWithArgument: selectDrpDownGuidedDecisionSupport
		 * #Description: This functionality selects the drop down values in the Guided Decision section
		 * #Argument: drpdown
		 * Type: Drop down
		 * key:
		 */
		
		public boolean selectTheGuidedDecisionSupport (String[] drpdown)
		{
				return utils.selectDropDownbyVisibleString(drpDownGuidedDecisionSupport, drpdown[0], "drpDownGuidedDecisionSupport", "Manage alert Review");
		}
		
		@FindBy(id="DiscussDependentAlertsYes")
		WebElement rdoBtnDependentValuesYes;
		
		@FindBy(id="DiscussDependentAlertsNo")
		WebElement rdoBtnDependentValuesNo;
		
		@FindBy(xpath="//*[text()='Name']/ancestor::table[@class='gridTable ']")
		WebElement tblAlertsDependentTable;
		
		public boolean clickYesOrNoInDependentAlerts(String[] args)
		{
			if(args[0].contains("Yes")){
				return utils.clickAnelemnt(this.rdoBtnDependentValuesYes, "ManageAlertReview", "Dependent Value Yes Radio Btn");
			}
			else if(args[0].contains("No")){
				return utils.clickAnelemnt(this.rdoBtnDependentValuesNo, "ManageAlertReview", "Dependent Value No Radio Btn");
			}
				return false;
		}
		
		public boolean verifyAlertsTableIsDisplayed()
		{
			return !utils.isProxyWebelement(tblAlertsDependentTable);
		}


		public boolean verifyAlertsDependentTableValues(String[] tablevalues)
		{
				return utils.validatetablerowbasedonvalues(this.tblAlertsDependentTable, tablevalues);
		}
		
		public boolean verifyAlertsTableIsNotplayed()
		{
			return utils.isProxyWebelement(tblAlertsDependentTable);
		}
	}
