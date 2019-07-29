package automationLib;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;


public class ManageSpecialityProductReviewScreen {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement2;

	public ManageSpecialityProductReviewScreen(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement2);
		}catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}

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

	@FindBy(xpath="//span[contains(text(),'Document References')]")
	WebElement lnkDocumentReference;

	@FindBy(xpath="//span[contains(text(),'Items Discussed During Manage Employee Assistance Program Review')]")
	WebElement lnkItemsDiscussed;

	@FindBy(id="ReasonForSpecialtyProductContact")
	WebElement drpDownReasonForContact;

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Go Back')]")	
	WebElement lnkOthrActionsGoBack;

	public boolean selectTheReasonForContact(String[] reason)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownReasonForContact, reason[0], "ManageSpecialityProductReviewScreen", "Reason For Contact");
	}

	/**This functionality clicks the document references in Manage Speciality contract review page
	 * 
	 * @return
	 */
	public boolean clickDocumentReference()
	{
		return utils.clickAnelemnt(this.lnkDocumentReference, "ManageSpecialityProductReviewScreen", "Item Scheduled");
	}

	public boolean addDocumentReferences(String[] args){
		try{
			utils.clickAnelemnt(this.lnkAddIcon, "ManageSpecialityProductReviewScreen", "Add Document References");
			utils.waitforpageload();
			List<WebElement> l=Driver.pgDriver.findElements(By.xpath("//select[contains(@id,'DocumentReferenceType')]"));
			System.out.println("Size is : "+l.size());
			if(l.size()>1){
				utils.selectDropDownbyVisibleString(this.drpDownRefType2, args[0], "ManageSpecialityProductReviewScreen", "Reference Type 2");
				utils.enterTextinAnelemnt(this.txtRefNum2, args[1], "ManageSpecialityProductReviewScreen", "Document Reference Number 2");
				this.txtRefNum2.sendKeys(Keys.TAB);
			}else if(l.size()==1){
				utils.selectDropDownbyVisibleString(this.drpDownRefType1, args[0], "ManageSpecialityProductReviewScreen", "Reference Type 1");
				utils.enterTextinAnelemnt(this.txtRefNum1, args[1], "ManageSpecialityProductReviewScreen", "Document Reference Number 1");
				this.txtRefNum1.sendKeys(Keys.TAB);
			}else{
				System.out.println("Element not found");
			}
		}catch(Exception e){
			err.logError("ManageSpecialityProductReviewScreen", "addDocumentReferences");
			System.out.println("Unable to enter value to field - Reference Type and Document Reference Number"+e);
			return false;
		}
		return true;
	}


	public boolean clickItemsDiscussed()
	{
		return utils.clickAnelemnt(this.lnkItemsDiscussed, "ManageSpecialityProductReviewScreen", "Item Discussed");
	}


	/** Description:This method  click the GOBACK  from the other actions 
	 * 
	 * @return
	 */
	public boolean navigateToTaskByOtherActionsDropDown()
	{
		if(utils.clickAnelemnt(this.drpDownOtherActions, "ManageSpecialityProductReviewScreen", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsGoBack, "ManageSpecialityProductReviewScre", "Go Back");
		return false;
	}

	@FindBy(xpath="//*[@data-test-id='20180919141917013090641']")
	WebElement ItemDiscussedSpecialitySystemLink;

	/**This methods verifies the items discussed during Respective task  Section is displayed correctly in Manage Speciality Product Review Screen
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyItemsDiscussed() {
		return !utils.isProxyWebelement(ItemDiscussedSpecialitySystemLink);
	}

	@FindBy(xpath="//*[@data-test-id='20180924235905021015251']")
	WebElement TrackYID;

	/**This functionality enters the A track Y ID number  as Y18-1234567 which is available only For Employee  in the Text box field in Manage Specialty  product  review page
	 * 
	 * @param notes
	 * @return
	 */
	public boolean enterA_Track_Y_Id() {
		return utils.enterTextinAnelemnt(TrackYID, "Y18-12345678", "ManageSpecialityProductReviewScre", "TrackYID");
	}

	@FindBy(id="Notes")
	WebElement Notes;

	/**This functionality enter notes in the Notes section
	 * 
	 * @param args
	 * @return
	 */
	public boolean enterNotes(String[] args) {
		return utils.enterTextinAnelemnt(Notes, args[0], "ManageSpecialityProductReviewScre", "Notes");
	}

	public boolean validateTaskIsLaunchedByOtherActions(String[] args) {
		utils.waitforpageload();
		String task = "//*[@class='actionTitleBarLabelStyle'][contains(text(),'"+args[0]+"')]";
		WebElement element = Driver.pgDriver.findElement(By.xpath(task));
		return !utils.isProxyWebelement(element);
	}

	@FindBy(xpath="//*[text()='Other actions ']")
	WebElement OtherActions;

	public boolean navigateToTaskByOtherActionsDropDown(String[] args) {
		return utils.selectValueFromListbyVisibleString(OtherActions, args[0], "ManageSpecialityProductReviewScre", "OtherActions");
	}

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	public boolean clickSubmitButton()
	{
		return utils.clickAnelemnt(btnSubmit,"ManageSpecialityProductReviewScreen", "SubmitButton");
	}



}
