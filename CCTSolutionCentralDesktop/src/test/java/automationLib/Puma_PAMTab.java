package automationLib;

import java.io.IOException;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtilities;
import utils.ErrorLogger;
import utils.BaseLogger;
import utils.DataSet;
import utils.Utilities;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



public class Puma_PAMTab {

	DataSet ds=new DataSet();
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	Utilities comnutils = new Utilities();

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id="PegaGadget0Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public Puma_PAMTab() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(name="$PpyWorkPage$pTimezone")
	WebElement drpDownTimeZone;

	@FindBy(id="Manager")
	WebElement txtManagerID;



	@FindBy(xpath="	//a[contains(@name,'NewApplicationDetails_pyWorkPage')]")
	WebElement iconDelete;

	@FindBy(xpath="//a[@title='Add a row ']")
	WebElement iconAdd;

	@FindBy(id="ApplicationName")
	WebElement drpDownApplicationName;

	@FindBy(xpath="//select[contains(@id,'ProfileName')]")
	WebElement drpDownProfileName;

	@FindBy(xpath="//select[contains(@id,'WorkGroup')]")
	WebElement drpDownWorkGroup;


	@FindBy(xpath="//div[contains(text(),'Save')]")
	WebElement btnSave;

	@FindBy(xpath="//button[@title='Complete the Assignment']")
	WebElement btnSubmit;

	@FindBy(id="submitButton")
	WebElement btnSubmitConfirm;

	@FindBy(xpath="//label[contains(text(),'User ID is successfully Created/Updated')]")
	WebElement labelConfirmationMessage;

	@FindBy(xpath="//button[contains(text(),'Close')]")
	WebElement btnClose;

	/*
	 * @SCU
	 * #Description: Selects the Time Zone and Enters the manager ID
	 * #Arguments: TimeAndManager
	 * Type: Dropdown
	 * Type: Textbox
	 * Keys: Eastern#Central#Mountain#Pacific#Alaska#Hawali#Australian Central#Australian Eastern#Australian Western#Atlantic#Central Europe#Eastern Europe#Greenwich Mean Time#Indian Standard Time#Moscow
	 */
	public boolean selectTimeZoneAndManagerID(String[] args)
	{
		if(this.selectTimeZone(args[0]))
			return this.enterManagerID(args[1]);
		return false;
	}

	public boolean selectTimeZone(String timezone)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownTimeZone, timezone, "AA_PAMTab", "Time Zone");
	}

	public boolean enterManagerID(String manager)
	{
		return utils.enterTextinAnelemnt(this.txtManagerID, manager, "AA_PAMTab", "Manager");
	}

	public boolean clickDeleteIcon()
	{
		return utils.clickAnelemnt(this.iconDelete, "AA_PAMTab", "Delete Icon");

	}

	public boolean clickAddIcon()
	{
		return utils.clickAnelemnt(this.iconAdd, "AA_PAMTab", "Add Icon");

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectApplicationNameProfileNameAndGroupName
	 * #Description: Selects Application Name, Profile Name and Group Name is selected for the user
	 * #Arguments: AppNameProfNameGrpName
	 * Type: Dropdown
	 * Keys: Select#Solution Central
	 * Keys: 834 Complex Maintenance#834 Maintenance#834 Simple Maintenance#Billing Associate#Billing Associate - Distribution & Monitoring#Billing Manager/OE#Bus System Administrator#Claims Associate#Claims Associate - Distribution & Monitoring#Claims Manager/OE#CSR (Advanced)# CSR (Intermediate)#CSR (Novice)#Employer Service Rep#Enrollment Associate#Enrollment Associate - Distribution & Monitoring#Enrollment Manager/OE#Grievance/Appeal Associate#IPAssociate#IPManager/OE#Manager#OE#Program & Product Management#Provide CSR#Quality Auditor#Trainer#UPCAssociate#UPCManager/OE
	 * Keys: ACA Customer Service#Large GroupLocal Customer Service#National Customer Service#Provider Custoer Service  
	 */
	public boolean selectApplicationNameProfileNameAndGroupName(String[] args)
	{
		if(this.selectApplicationName(args[0]))
			if(this.selectProfileName(args[1]))
				if(this.selectWorkGroupName(args[2]))
				{
					System.out.println("Application Name, Profile Name and Group Name is selected");
					blogger.loginfo("Application Name, Profile Name and Group Name is selected");
					return true;
				}
		return false;
	}


	public boolean selectApplicationName(String appName)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownApplicationName, appName, "AA_PAMTab", "Application Name");
	}

	public boolean selectProfileName(String profName)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownProfileName, profName, "AA_PAMTab", "Profile Name");
	}

	public boolean selectWorkGroupName(String workgrpName)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownWorkGroup, workgrpName, "AA_PAMTab", "Work Group Name");
	}

	public boolean clickSave()
	{
		return utils.clickAnelemnt(this.btnSave, "AA_PAMTab", "Save");
	}

	public boolean clickSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "AA_PAMTab", "Submit");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSaveAndSubmit
	 * #Description: Clicks Save to save the skills modified and then Submit
	 * Type: Textbox
	 */
	public boolean clickSaveAndSubmit() 
	{
		if(this.clickSave())
			return this.clickSubmit();
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSubmitConfirm
	 * #Description: Clicks Submit to confirm the skills modified/created
	 * Type: Textbox
	 */
	public boolean clickSubmitConfirm()
	{
		return utils.clickAnelemnt(this.btnSubmitConfirm, "AA_PAMTab", "Submit Confirm");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyTheSubmissionMessage
	 * #Description: Verifies the message displayed once the profile is created/updated
	 * Type: Textbox
	 */
	public boolean verifyTheSubmissionMessage()
	{
		String actualMessage = labelConfirmationMessage.getText();
		String expectedMessage = "User ID is successfully Created/Updated";
		return utils.isvalueMatch_contain(actualMessage, expectedMessage);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickClose
	 * #Description: Clicks close to finish the skills modified/created
	 * Type: Textbox
	 */
	public boolean clickClose()
	{
		return utils.clickAnelemnt(this.btnClose, "AA_PAMTab", "Close");
	}


	@FindBy(xpath="//*[@pl_prop='.AvailableSkills']//tr//td//span")
	List<WebElement> availableSkills;


	@FindBy(xpath="//*[@pl_prop='.OperatorSkills']//tr//td//span")
	List<WebElement> selectedSkills;

	@FindBy(xpath="//div[contains(text(),'Remove all')]")
	WebElement btnRemoveAll;

	public boolean clickRemoveAll()
	{
		return utils.clickAnelemnt(this.btnRemoveAll, "AA_PAMTab", "Remove All");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyAvailableSkillsAndAddTheSkill
	 * #Description: Verifies the Skills in Available skill section and clicks the matched skill given by the user
	 * #Argument: AvailableSkill
	 * Type: Textbox
	 */
	public boolean  verifyAvailableSkillsAndAddTheSkill(String[] args)
	{
		try{
			this.clickRemoveAll();
			utils.waitforpageload();
			for(WebElement e:availableSkills){
				System.out.println("Availablr Skills: "+e);
				if(e.getText().trim().equalsIgnoreCase(args[0])){
					blogger.loginfo("Actual Value matched : "+e.getText().trim()+" with the expected value "+args[0]);
					System.out.println("Text match in UI: "+e.getText().trim()+" with the expected "+args[0]);
					utils.waitforpageload();
					e.click();
					System.out.println("Skill "+e+ "is clciked");
					blogger.loginfo("Skill "+e+ "is clciked");
					return true;
				}else{
					System.out.println("Text didnt match in UI:"+e.getText().trim()+" With the expected "+args[0]);
				}
			}
		}catch(Exception e){
			err.logError("AA_PAMTab", "verifyAvailableSkillsAndAddTheSkill");
			return false;
		}
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifySelectedSkills
	 * #Description: Verifies the Skills in Selected skill section given by the user
	 * #Argument: SelectedSkill
	 * Type: Textbox
	 */
	public boolean  verifySelectedSkills(String[] args)
	{
		try{
			for(WebElement e:selectedSkills){
				System.out.println("Selected Skills: "+e);
				if(e.getText().trim().equalsIgnoreCase(args[0])){
					blogger.loginfo("Actual Value matched : "+e.getText().trim()+" with the expected value "+args[0]);
					System.out.println("Text match in UI: "+e.getText().trim()+" with the expected "+args[0]);
					return true;
				}else{
					System.out.println("Text didnt match in UI:"+e.getText().trim()+" With the expected "+args[0]);
				}
			}
		}catch(Exception e){
			err.logError("AA_PAMTab", "verifySelectedSkills");
			return false;
		}
		return false;
	}
}
