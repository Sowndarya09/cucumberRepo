package automationLib;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ViewProgramReview {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	public ViewProgramReview(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	
	
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;
	
	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'View Program')]")	
	WebElement lnkOthrActionsViewProgram;
	
	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Cancel this work')]")	
	WebElement lnkOthrActionsCancelWork;
	
	@FindBy(id="ReasonForViewProgram")
	WebElement drpDownReasonForContact;
	
	@FindBy(id="Notes")
	WebElement txtNotes;
	
	@FindBy(xpath="//span[contains(text(),'Items Discussed During View Programs')]")
	WebElement lnkItemsDiscussed;
	
	@FindBy(xpath="//span[contains(text(),'Document References')]")
	WebElement lnkDocumentReference;
	
	@FindBy(xpath="//input[@id='DCNDocumentIDIndicator2']")
	WebElement txtRefNum2;
	
	@FindBy(xpath="//table[@pl_prop='.DocumentReferenceNumber']//a[contains(text(),'Add')]")
	WebElement lnkAddIcon;
	
	@FindBy(xpath="//select[@id='DocumentReferenceType1']")
	WebElement drpDownRefType1;
	
	@FindBy(xpath="//select[@id='DocumentReferenceType2']")
	WebElement drpDownRefType2;
	
	@FindBy(xpath="//input[@id='DCNDocumentIDIndicator1']")
	WebElement txtRefNum1;
	
	@FindBy(xpath="//table[@pl_prop='.DocumentReferenceNumber']//a[contains(text(),'Delete')]")
	WebElement lnkDeleteIcon;
	
	@FindBy(xpath="//div[@id='DialogContent' and contains(text(), 'You can find Programs')]")
	WebElement txtGuidedMsg;
	
	@FindBy(xpath="//table[starts-with(@pl_prop_class,'Antm-FW-CSFW-Data-AHG-ViewPrograms')]")
	WebElement tblItemsDiscussed;
	
	@FindBy(xpath="//table[starts-with(@pl_prop_class,'Antm-FW-CSFW-Data-AHG-ViewPrograms')]//a[contains(text(),'Next')]")
	WebElement lnkNextItemsDiscussed;
	


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
	 * #Description: This functionality enters the notes in the notes section in the View Program Review page
	 * #Argument: notes
	 * Type: Textbox
	 */
	public boolean enterNotes(String[] notes)
	{
			return utils.enterTextinAnelemnt(this.txtNotes, notes[0], "ViewProgramReview", "Notes");
	}
	
	
	public boolean clickItemsDiscussed()
	{
		return utils.clickAnelemnt(this.lnkItemsDiscussed, "ViewProgramReview", "Item Discussed");
	}
	
	
	public boolean clickDocumentReference()
	{
		return utils.clickAnelemnt(this.lnkDocumentReference, "ViewProgramReview", "Item Scheduled");
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
			//this.clickDocumentReference();
			utils.clickAnelemnt(this.lnkAddIcon, "ViewProgramReview", "Add Document References");
			utils.waitforpageload();
			List<WebElement> l=Driver.pgDriver.findElements(By.xpath("//select[contains(@id,'DocumentReferenceType')]"));
			System.out.println("Size is : "+l.size());
			if(l.size()>1){
				utils.selectDropDownbyVisibleString(this.drpDownRefType2, args[0], "ViewProgramReview", "Reference Type 2");
				utils.enterTextinAnelemnt(this.txtRefNum2, args[1], "ViewProgramReview", "Document Reference Number 2");
				this.txtRefNum2.sendKeys(Keys.TAB);
				return true;
			}else if(l.size()==1){
				utils.selectDropDownbyVisibleString(this.drpDownRefType1, args[0], "ViewProgramReview", "Reference Type 1");
				utils.enterTextinAnelemnt(this.txtRefNum1, args[1], "ViewProgramReview", "Document Reference Number 1");
				this.txtRefNum1.sendKeys(Keys.TAB);
				return true;
			}else{
				System.out.println("Element not found");
				return false;
			}
		}catch(Exception e){
			err.logError("ViewProgramReview", "addDocumentReferences");
			System.out.println("Unable to enter value to field - Reference Type and Document Reference Number"+e);
			return false;
		}
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
		try{
			Driver.pgDriver.findElement(By.xpath("//select[contains(@id,'DocumentReferenceType')]//option[text()='"+args[0]+"'][@selected]")).click();
			Driver.pgDriver.findElement(By.xpath("//input[contains(@id,'DCNDocumentIDIndicator')][@value='"+args[1]+"']")).click();
			return utils.clickAnelemnt(this.lnkDeleteIcon, "ViewProgramReview", "Delete Document References");
		}catch(Exception e){
			err.logError("ViewProgramReview", "deleteDocumentReferences");
			System.out.println("Unable to select field - Reference Type and Document Reference Number"+e);
			return false;
		}
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

	
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToViewProgram
	 * #Description: This functionality navigates to the View Program section from the View Program Review page
	 * Type: Textbox
	 */
	public boolean navigateToViewProgram()
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "View Programs", "View Program Review", "Navigated to View Program");
	}
	

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyThatTheViewProgramInformationIsDisplayedUnderItemsDiscussed
	 * #Description: This functionality verifies the values given by user matches the value present in the Items Discussed table section
	 * #Type: Table
	 * Keys: ProgramName#ProgramNumber
	 */
	public boolean verifyThatTheViewProgramInformationIsDisplayedUnderItemsDiscussed(String[] tablevalues)
	{
		if(clickItemsDiscussed())	
		if (utils.validatetablerowbasedonvalues(this.tblItemsDiscussed, tablevalues))
			return true;
				return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyGuidedDialogisNotPresentInReviewScreen
	 * #Description: This functionality verifies the absence of Guided Dialog box in the View Program Review page
	 * Type: Textbox
	 */
	
	public boolean verifyGuidedDialogisNotPresentInReviewScreen (){	
		return !utils.isProxyWebelement(txtGuidedMsg);
	}
	
	
	@FindBy(xpath="//table[@pl_prop='.IncentiveProgramsReviewed']")
	private WebElement productsTable;
	
	public boolean clickontablerowbasedonvaluesForViewPrograms(WebElement table,String[] tablevalues) throws InterruptedException{
		//String keyvaluepairstring = "Service:Ambulatory Surgical Center - Oral Surgery,Place Of Service:Ambulatory Surgical Center,Network Type:In-Network";

		String[] keyvaleupair = tablevalues;

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =0;
		int i=0;
		//Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		ArrayList<String>    returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");       
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = utils.getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].equalsIgnoreCase(value)){
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);     
					if(columnvalues[j].equalsIgnoreCase(value)){
						k=k+1;
						continue;}
					else{
						index=-1;
						break;
					}
				}
			}

		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if(index!=-1){
			if(allRows.size()>0)
				allRows.get(index).findElements(By.tagName("td")).get(0).click();}
		else return false;   
		System.out.println("The row with the matching arguements" + index);  
		Thread.sleep(1000);
		return true;  
	}

	
	
	public boolean verifyThatTheViewProgramInformationUnderItemsDiscussed(String[] tablevalues) throws InterruptedException
	{
		if(clickItemsDiscussed())
			return clickontablerowbasedonvaluesForViewPrograms(this.productsTable,tablevalues);
		return false;
	}

}
