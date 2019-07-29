package automationLib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class UpdatePCP {
WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);
	
	public UpdatePCP()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	ErrorLogger err=new ErrorLogger();
	SeleniumUtilities utils=new SeleniumUtilities();
	Provider pr=new Provider();
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(xpath="//input[@id='pyTemplateCheckbox']/parent::span//label")
	WebElement LabelMemberName;
	
	@FindBy(xpath="//table[@class='gridTable ']//td[@data-attribute-name='PCP Name']")
	WebElement labelTablePCPName;
	
	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Update PCP')]")
	WebElement btnUpdatePCP;
	
	@FindBy(id="CaseOrTaskIcon")
	WebElement radiobtnSelectPCp;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	
	@FindBy(id="PCPUpdateReason")
	WebElement drpdwnUpdateReason;
	
	@FindBy(xpath="//div[contains(@columnlist,'PCPUpdateMessage')]//table[@class='gridTable ']//td[@data-attribute-name='Result & Next Action']//span")
	WebElement labelPCPUpdateMessage;
	
	@FindBy(id="PCPUpdateIDtrue")
	WebElement radioEnterPCPID;
	
	@FindBy(id="PCPUpdateIDText")
	WebElement txtbxnterPCPID;
	
	@FindBy(xpath="//button[@disabled='']//div[text()='Update PCP']")
	WebElement disabledUpdatePCP;

	
	@FindBy(xpath="//div[@node_name='UpdatePCPWrapper']//span[contains(text(),'Is the member currently in a course of treatment with their current Primary Care Physician')]")
	WebElement labelMemberunderTreatment;
	
	@FindBy(id="IsCurrentlyUnderTreatmentYes")
	WebElement radioCurrentlyunderTreatmentYes;
	
	@FindBy(id="IsCurrentlyUnderTreatmentNo")
	WebElement radioCurrentlyunderTreatmentNo;
	
	public boolean SelectfromListandUpdatePCP()
	{
			System.out.println("Compare "+this.labelTablePCPName.getText().toString()+" with"+pr.ProviderName);
			if(utils.isvalueMatch_contain(labelTablePCPName.getText().toString(), pr.ProviderName))
				if(utils.clickAnelemnt(this.radiobtnSelectPCp, "UpdatePCP", "Radio button of Member"))
					if(utils.selectDropDownbyVisibleString(this.drpdwnUpdateReason, "Member Request", "UpdatePCP", "Drop Down for PCP update Reason "))
						if(utils.isProxyWebelement(this.radioCurrentlyunderTreatmentYes))
							if(utils.clickAnelemnt(this.radioCurrentlyunderTreatmentYes,"Member Composite "," Contract address link "))
								return utils.clickAnelemnt(this.btnUpdatePCP, "UpdatePCP", "Update PCP button");
			return false;
		
	}
	
	public boolean enterPCPID(String PCPID)
	{
			if(utils.clickAnelemnt(this.radioEnterPCPID, "UpdatePCP", "Enter PCP id radio button"))
				if(utils.enterTextinAnelemnt(this.txtbxnterPCPID,PCPID, "UpdatePCP", "Enter PCP id radio button"))
					return true;
				return false;
	}
	
	public boolean checkPCPUpdateSuccessMessage()
	{
			return utils.isvalueMatch_contain(labelPCPUpdateMessage.getText().toString(), "pcp updated");
	}
	
	public boolean checkPCPUpdateFailureMessage()
	{
		return utils.isvalueMatch_contain(labelPCPUpdateMessage.getText().toString().toLowerCase(), "pcp cannot be updated");
	}
	
	public boolean checkCurrentCourseofTreatmentMsg()
	{
			if(!utils.isProxyWebelement(labelMemberunderTreatment))
				if(utils.clickAnelemnt(this.radioCurrentlyunderTreatmentYes, "UpdatePCP", "Yes Radio button"))
					return utils.clickAnelemnt(this.radioCurrentlyunderTreatmentNo, "UpdatePCP", "No Radio button");
				return false;		
	}
	
	
	public boolean clickbtnSubmit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit, "UpdatePCP", "Submit button");
	}
	
	public boolean EnterandUpdatePCP(String[] PCPID)
	{
		if(this.enterPCPID(PCPID[0]))
			if(utils.selectDropDownbyVisibleString(this.drpdwnUpdateReason, "Member Request", "UpdatePCP", "Drop Down for PCP update Reason "))
					if(utils.isProxyWebelement(this.radioCurrentlyunderTreatmentYes))
						if(utils.clickAnelemnt(this.radioCurrentlyunderTreatmentYes,"Member Composite "," Contract address link "))
							if(utils.clickAnelemnt(this.btnUpdatePCP, "UpdatePCP", "UpdatePCP button"))
								if(this.disabledUpdatePCP.isDisplayed())
									return true;
			return false;
	}
	
	
	@FindBy (id="IsSelected")	
	private WebElement selectAllMemberCheckBox;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectAllMembersInUpdatePCP
	 * #Description: This method clicks on Select All member in Update PCP screen.
	 * Type:Textbox
	 */
	public boolean selectAllMembersInUpdatePCP(){
			return utils.clickAnelemnt(this.selectAllMemberCheckBox, "UpdatePCP", "Select All checkbox");
	}
	
	@FindBy (xpath="//table[@pl_prop='.TaggedPCPProviderList']")	
	private WebElement selectNewPCPTable;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectNewPCPToUpdate
	 * #Description: This method selects the PCP detail to be updated in New PCP update table.
	 * #Arguments:PCP Table
	 * Type:Table
	 * Keys:PCP ID#PCP Name#Address#Phone Number
	 */
	public boolean selectNewPCPToUpdate(String args[]) throws InterruptedException{
			return utils.clickontablerowbasedonvalues(this.selectNewPCPTable, args);
	}
	
	@FindBy (id="PCPUpdateReason")	
	private WebElement reasonForPCPUpdate;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectReasonForPCPUpdate
	 * #Description: This method selects the reason for PCP update.
	 * #Arguments:ReasonForPCPUpdate
	 * Type:Dropdown
	 * Keys:#Have Never Seen or Didn't Accept Doctor#Patient has moved#Doctor too Far Away#Unsatisfied with Doctors Quality#Unsatisfied with Doctors Service#Unsatisfied with Doctor because of Language or Gender#Can't be seen in a timely manner#Patients age is inappropriate#Doctor no longer available#Open Enrollment#Doctor Request#Doctor Not Accepting New Patients at this time#Doctor terminated with plan#Doctor Panel Full#Doctor is deceased#Doctor only treats childer age 0 - 12#Rollover Correction#Doctor Sanctions#Member Request#Member Complaint - Waiting too long in office#Member Complaint - No service received after hours#Member Complaint - Long wait for Refferal#Bad Access, Hours Parking, Inability to speak with doctor#BCBS Assigned PCP, The member wishes to change#Used only by membership for new member PCP#PCP has disenrolled the member by request#Concerns about the office environment (QA)#PCP non-compliance (LMM)#One-time retro PCP change#Preference, not happy with current PCP#Quality of care concern over/under treatment#Perception of PCP insensitivity, bad bedside manner#Perception of PCP staff, rudeness or concerns#PCP has been terminated or is self-terminating#Only used by membership, did not select PCP#BCBS Assigned PCP, due to invalid or no PCP#Conversion (tax id or demographic change)#PMG/IPX System rollover#No Reason Given
	 */
	public boolean selectReasonForPCPUpdate(String args[]){
			return utils.selectDropDownbyVisibleString(this.reasonForPCPUpdate, args[0], "UpdatePCP", "Reason For Update - Dropdown");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnUpdatePCP
	 * #Description:This method clicks on  Update PCP button in UpdatePCP page.
	 * Type:Textbox
	 */
	public boolean clickOnUpdatePCP(){
			JavascriptExecutor jse=(JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("arguments[0].scrollIntoView(true);", btnUpdatePCP);
			return utils.clickAnelemnt(this.btnUpdatePCP, "UpdatePCP", "UpdatePCP button");
			
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on Submit button in Complete Provider Review page.
	 * Type:Textbox
	 */
	public boolean clickOnSubmit(){
			utils.scrolltomiddle();
			return utils.clickAnelemnt(this.btnSubmit, "UpdatePCP", "Submit Button");
	}
}
