package automationLib;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderWrapUp extends Driver  {



	SeleniumUtilities utils= new SeleniumUtilities();
	Actions action=new Actions(Driver.pgDriver);
	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForMember;
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	BaseLogger logger=new BaseLogger();

	ErrorLogger err=new ErrorLogger();


	String contractName="//*[@class='dataValueRead']/nobr/span"; 
	String textverify="iconRequired standard_iconRequired";
	/**
	 * Constructor 	
	 */

	public ProviderWrapUp()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	@FindBy(id="DialogContent")
	private WebElement pgeHEaderMessage;

	@FindBy(xpath="//div[@node_name='CPMPortalRecent']//a[@data-ctl='Icon']")
	WebElement closecurrenttab;

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	public WebElement getsHeaderSearchForMember() {
		return sHeaderSearchForMember;
	}


	public WebElement getIframeelement() {
		return Iframeelement;
	}


	public String getContractName() {
		return contractName;
	}


	public String getTextverify() {
		return textverify;
	}


	public WebElement getPgeHEaderMessage() {
		return pgeHEaderMessage;
	}


	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}


	public WebElement getLnkOtherCancelThisWork() {
		return lnkOtherCancelThisWork;
	}


	public WebElement getBtnImgTool() {
		return btnImgTool;
	}


	public WebElement getLnkToolViewHistory() {
		return lnkToolViewHistory;
	}


	public WebElement getLnkToolConfigurationTools() {
		return lnkToolConfigurationTools;
	}


	public WebElement getBtnHelp() {
		return btnHelp;
	}


	public WebElement getDrpDownReasonforInteraction() {
		return drpDownReasonforInteraction;
	}


	public WebElement getDrpDownPrimaryTask() {
		return drpDownPrimaryTask;
	}


	public WebElement getTagNameWrapUpConsole() {
		return tagNameWrapUpConsole;
	}


	public WebElement getRdBtnPriorInquiryYes() {
		return rdBtnPriorInquiryYes;
	}


	public WebElement getRdBtnPriorInquiryNo() {
		return rdBtnPriorInquiryNo;
	}


	public WebElement getCheckLabelText() {
		return checkLabelText;
	}


	public WebElement getTxtBoxWrapUpComments() {
		return txtBoxWrapUpComments;
	}


	public WebElement getBtnSubmit() {
		return btnSubmit;
	}


	public String getsUserExperience() {
		return sUserExperience;
	}


	public WebElement getBtnUserExperience() {
		return btnUserExperience;
	}


	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;

	@FindBy (xpath="//img[contains(@src,'tool_icon_')]")	
	private WebElement btnImgTool;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;

	@FindBy(id="ReasonForInteraction")
	private WebElement drpDownReasonforInteraction;

	@FindBy(id="PrimaryTask")
	private WebElement drpDownPrimaryTask;

	@FindBy(xpath="//*[contains(@class,'standard_iconRequired')]")
	private WebElement tagNameWrapUpConsole;

	@FindBy(id="IsRelatedToPriorInquiryYes")
	private WebElement rdBtnPriorInquiryYes;
	@FindBy(id="IsRelatedToPriorInquiryNo")
	private WebElement rdBtnPriorInquiryNo;

	@FindBy(xpath="//*[contains(@class,'field-item dataLabelForWrite')]")
	private WebElement checkLabelText;

	@FindBy(id="WrapUpComments")
	private WebElement txtBoxWrapUpComments;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	String sUserExperience=null;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnUserExperience;


	@FindBy(xpath="//span[text()='Just a reminder, a CCB window is still open']")
	WebElement CCBOpenWarning;
	/**
	 * To click on the images from 1 to 10 in the page barring the no 10 which will conflict between 0 and 10 
	 * @param sNumber : no accoring to rating 
	 * 
	 * @return
	 */
	public boolean clickOnUserExperience(String sNumber)
	{
		sUserExperience="//a[contains(@data-click,'"+sNumber+"')]";
		Driver.pgDriver.findElement(By.xpath(sUserExperience)).click();
		return true;
	}


	/*
	 * Checks in General Information 
	 */


	/**
	 * Click on Cancel this work from Other Actions drop Down 
	 * @return
	 */
	public boolean clickCancelThisWork()
	{
		if(utils.clickAnelemnt(this.getBtnOtherActions(), "Wrap Up ", "Other actions button")) {
			action.moveToElement(this.lnkOtherCancelThisWork);
			return utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Wrap Up", "Cancel This Work");
		}
		return false;

	}

	@FindBy(xpath="//*[contains(@class,'oflowDivM')]")
	private WebElement lnkAddTaskOption;

	public WebElement getLnkAddTaskOption() {
		return lnkAddTaskOption;
	}


	public WebElement getTxtboxAddTask() {
		return txtboxAddTask;
	}

	@FindBy(xpath="//input[@id='CPMTaskSearchInput']")
	private WebElement txtboxAddTask;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")
	private WebElement btnAddTask;
	public WebElement getBtnAddTask() {
		return btnAddTask;
	}

	@FindBy(xpath="//*[contains(@class,'pzbtn-mid')][text()='Wrap Up']")
	private WebElement lnkWrapUp;
	@FindBy(xpath="//*[contains(@class,'anthem_theme_header')][text()='Wrap Up']")
	private WebElement hHeader;

	public boolean clickWrapUp()
	{
		return utils.clickAnelemnt(this.lnkWrapUp, "Wrap Up", "Wrap Up");
	}

	public boolean clickrdBtnNo()
	{
		return utils.clickAnelemnt(this.rdBtnPriorInquiryNo, "Wrap Up", "Wrap Up");
	}

	public boolean clickrdbtnYes()
	{
		return utils.clickAnelemnt(this.rdBtnPriorInquiryYes, "Wrap Up", "Wrap Up");
	}

	public boolean clickBtnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "Wrap Up", "Wrap Up");
	}

	public boolean selectDropDownReaonsForInteraction(String svisibleString) throws InterruptedException, AWTException
	{
		try
		{
			return utils.selectDropDownbyVisibleString(this.getDrpDownReasonforInteraction(), svisibleString, "Wrap Up ", "Communication Channel");
		}
		catch(StaleElementReferenceException e)
		{
			return selectDropDownReaonsForInteraction(svisibleString);
		}
	}
	@FindBy(xpath="//*[contains(@node_name,'NPSRatingInWrapUp')]//*[contains(@data-click,5)]")
	private WebElement interactionExperience;

	public boolean clickExperience5()
	{
		return utils.clickAnelemnt(this.interactionExperience, "Wrap Up", "Wrap Up");
	}
	public boolean selectDropDownReaonsPrimaryTask(String svisibleString) throws InterruptedException, AWTException
	{

		try
		{
			return utils.selectDropDownbyVisibleString(this.getDrpDownPrimaryTask(), svisibleString, "Wrap Up", "Communication Channel");
		}
		catch(StaleElementReferenceException e)
		{
			return selectDropDownReaonsPrimaryTask(svisibleString);
		}
	}




	public boolean selectDropDownPrimaryReasonsForInteraction(String[] svisibleString)
			throws InterruptedException, AWTException {
		return utils.selectDropDownbyVisibleString(this.getDrpDownReasonforInteraction(), svisibleString[0], "WrapUp ",
				"Primary Task");
	}

	/*
	 * @SCU #CommonMethodWithArgument: selectDropDownReasonsPrimaryTask
	 * #Description: This functionality selects the drop down reason for the
	 * primary task by getting the input from the user. #Argument: Reason for
	 * Primary Task Type: Dropdown keys: Select#Call Transfer#Eligibility#Other
	 */
	public boolean selectDropDownReasonsPrimaryTask(String[] svisibleString) throws InterruptedException, AWTException {
		return utils.selectDropDownbyVisibleString(this.getDrpDownPrimaryTask(), svisibleString[0], "WrapUp",
				"Primary Task");
	}



	@FindBy(id="WrapUpComments")
	private WebElement txtBxWrapUpComments;
	@FindBy(xpath="//*[contains(@id,'Comments')]")
	private WebElement txtBxComments;

	public boolean setWrapUpcomments(String sCCBID)
	{
		return utils.enterTextinAnelemnt(this.txtBxWrapUpComments, sCCBID, "Wrap Up ", "Comments");

	}

	public boolean settxtBxCommentsOther(String sCCBID)
	{
		return utils.enterTextinAnelemnt(this.txtBxComments, sCCBID, "Wrap Up ", "Comments");
	}

	public boolean enterWrapUpcomments(String[] sCCBID)
	{
		return utils.enterTextinAnelemnt(this.txtBxWrapUpComments, sCCBID[0], "Wrap Up ", "Comments");
	}

	/**
	 * Will navigate to Wrap Up Page and fill in the details with User Experience as 5 and submit following with entry 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public boolean clickWrapUpEligibilitySubmit() throws InterruptedException, AWTException
	{
		if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			if(this.selectDropDownReaonsPrimaryTask("Eligibility"))	
				if(this.clickrdBtnNo())
					if(this.clickExperience5())
						if(this.setWrapUpcomments("Wrap Up Comment"))
							return this.clickBtnSubmit();
		return false;
	}

	public boolean clickWrapUpBenefitsandCostSubmit() throws InterruptedException, AWTException
	{
		if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			if(this.selectDropDownReaonsPrimaryTask("Call Transfer"))	
				if(this.clickrdBtnNo())
					if(this.clickExperience5())
						if(this.setWrapUpcomments("Wrap Up Comment"))
							return this.clickBtnSubmit();
		return false;
	}

	public boolean clickWrapUpManageBillingSubmit() throws InterruptedException, AWTException
	{
		if(this.utils.validateHeader(this.hHeader, "Wrap Up"))
			if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if(this.selectDropDownReaonsPrimaryTask("Manage Billing"))	
					if(this.clickrdBtnNo())
						if(this.clickExperience5())
							if(this.setWrapUpcomments("Wrap Up Comment"))
								return this.clickBtnSubmit();
		return false;
	}




	/**
	 * Check the value in the field and Wrap up the session and submit , one should be navigated to the base home page 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean clickWrapUpCallTransferSubmit() throws InterruptedException, AWTException
	{
		if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			if(this.selectDropDownReaonsPrimaryTask("Call Transfer"))	
				if(this.clickrdBtnNo())
					if(this.clickExperience5())
						if(this.setWrapUpcomments("Wrap Up Comment"))
							return this.clickBtnSubmit();
		return false;
	}

	public boolean clickWrapUpOtherstSubmit() throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.hHeader, "Wrap Up"))
			if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
				if(this.selectDropDownReaonsPrimaryTask("Other"))	
					if(this.clickrdBtnNo())
						if(this.clickExperience5())
							if(this.settxtBxCommentsOther("Cash and Promised Action"))
								if(this.setWrapUpcomments("Wrap Up Comment"))
									return this.clickBtnSubmit();
		return false;

	}






	/**
	 * Will navigate to Wrap Up Page and fill in the details with User Experience as 5 and submit following with entry 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public boolean clickWrapUpEligibilitySubmitYes() throws InterruptedException, AWTException
	{
		if(this.utils.validateHeader(this.hHeader, "Wrap Up"))
		{
			if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			{
				if(this.selectDropDownReaonsPrimaryTask("Eligibility"))	
				{
					if(this.clickrdbtnYes())
					{
						if(this.clickExperience5())
						{
							if(this.setWrapUpcomments("Wrap Up Comment"))
							{
								if(this.clickBtnSubmit())
								{
									System.out.println("Pass : Successful in submitting the value of wrap and navigated to the Home Page");
									return true;
								}
							}
						}
					}
				}

			}
		}


		System.out.println("Fail : Not Successful in submitting the value of wrap and failed to navigate to the Home Page");
		return false;
	}

	public boolean clickWrapUpBenefitsandCostSubmitYes() throws InterruptedException, AWTException
	{
		if(this.utils.validateHeader(this.hHeader, "Wrap Up"))
		{
			if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			{
				if(this.selectDropDownReaonsPrimaryTask("Eligibility"))	
				{
					if(this.clickrdbtnYes())
					{
						if(this.clickExperience5())
						{
							if(this.setWrapUpcomments("Wrap Up Comment"))
							{
								if(this.clickBtnSubmit())
								{
									System.out.println("Pass : Successful in submitting the value of wrap and navigated to the Home Page");
									return true;
								}
							}
						}
					}
				}

			}
		}


		System.out.println("Fail : Not Successful in submitting the value of wrap and failed to navigate to the Home Page");
		return false;
	}

	public boolean clickWrapUpandCloseInteraction() throws InterruptedException, AWTException
	{
		if(this.utils.validateHeader(this.hHeader, "Wrap Up"))
		{
			if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			{
				if(this.selectDropDownReaonsPrimaryTask("Eligibility"))	
				{
					if(this.clickrdbtnYes())
					{
						if(this.clickExperience5())
						{
							if(this.setWrapUpcomments("Wrap Up Comment"))
							{
								if(this.clickBtnSubmit())
								{
									this.closecurrentinteraction();
									System.out.println("Pass : Successful in submitting the value of wrap and navigated to the Home Page");
									return true;
								}
							}
						}
					}
				}

			}
		}


		System.out.println("Fail : Not Successful in submitting the value of wrap and failed to navigate to the Home Page");
		return false;
	}

	public void closecurrentinteraction()
	{
		try{

			Thread.sleep(2000);
			this.closecurrenttab.click();
			Thread.sleep(2000);
			Driver.pgDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click();
		}
		catch(Exception e)
		{
			System.out.println(e+" exception occured. retrying");
			closecurrentinteraction();
		}
	}

	public boolean clickWrapUpManageBillingSubmitYes() throws InterruptedException, AWTException
	{
		if(this.utils.validateHeader(this.hHeader, "Wrap Up"))
		{
			if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			{
				if(this.selectDropDownReaonsPrimaryTask("Manage Billing"))	
				{
					if(this.clickrdbtnYes())
					{
						if(this.clickExperience5())
						{
							if(this.setWrapUpcomments("Wrap Up Comment"))
							{
								if(this.clickBtnSubmit())
								{
									System.out.println("Pass : Successful in submitting the value of wrap and navigated to the Home Page");
									return true;
								}
							}
						}
					}
				}

			}
		}


		System.out.println("Fail : Not Successful in submitting the value of wrap and failed to navigate to the Home Page");
		return false;
	}
	public boolean clickWrapUpCallTransferSubmitYes() throws InterruptedException, AWTException
	{
		Thread.sleep(5000);
		if(this.utils.validateHeader(this.hHeader, "Wrap Up"))
		{
			if(this.selectDropDownReaonsForInteraction("Requested help with a claim"))
			{
				if(this.selectDropDownReaonsPrimaryTask("Call Transfer"))	
				{
					if(this.clickrdbtnYes())
					{
						if(this.clickExperience5())
						{
							if(this.setWrapUpcomments("Lee Child"))
							{
								if(this.clickBtnSubmit())
								{
									System.out.println("Pass : Successful in submitting the value of wrap and navigated to the Home Page");
									return true;
								}
							}
						}
					}
				}

			}
		}


		System.out.println("Fail : Not Successful in submitting the value of wrap and failed to navigate to the Home Page");
		return false;
	}


	public boolean clickOnSubmit() {
		utils.scrolltomiddle();
		WebElement element = Driver.pgDriver.findElement(By.xpath("//div[contains(text(),'Submit')]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(this.btnSubmit, "Member Composite - WrapUp", "Submit");
	}


	public boolean clickWrapUpOtherstSubmitYes() throws InterruptedException, AWTException
	{
		try{		

			if(this.utils.validateHeader(this.hHeader, "Wrap Up"))
			{
				if(this.selectDropDownReaonsForInteraction("Requested claim information"))
				{
					if(this.selectDropDownReaonsPrimaryTask("Other"))	
					{
						if(this.clickrdbtnYes())
						{
							if(this.settxtBxCommentsOther("Cash and Promised Action"))
							{ 
								if(this.setWrapUpcomments("Wrap Up Comment"))
								{
									if(this.clickBtnSubmit())
									{
										System.out.println("Pass : Successful in submitting the value of wrap and navigated to the Home Page");
										return true;
									}
								}
							}
						}
					}

				}
			}
			System.out.println("Fail : Not Successful in submitting the value of wrap and failed to navigate to the Home Page");
			return false;
		}

		catch(Exception e)
		{
			System.out.println("Catch");
		}
		return true;
	}

	public boolean checkCCBopenAlertMessage()
	{
		return !utils.isProxyWebelement(CCBOpenWarning);
	}

	@FindBy(xpath="//span[contains(text(),'Would the caller be willing to participate in a Voice of the Customer e-mail survey?')]")
	WebElement validateProviderSurveyQuestion;

	/**This methods validates the survey question on the wrap up page
	 * 
	 * @return
	 */
	public boolean validateTheProviderSurveyQuestionInWrapUp()
	{
		return utils.validateHeader(validateProviderSurveyQuestion,"Would the caller be willing to participate in a Voice of the Customer e-mail survey?");
	}

	@FindBy (id="ProviderSurveyConfirmationNo")	
	private WebElement emailSurveyNo;

	@FindBy (id="ProviderSurveyConfirmationYes")	
	private WebElement emailSurveyYes;


	/**
	 * This method selects if the member needs to take email survey
	 * @param args
	 * @return
	 */
	public boolean selectYesOrNoForProviderSurveyQuestion(String args[]){

		if(args[0].equalsIgnoreCase("Yes")){
			return	utils.clickAnelemnt(emailSurveyYes,"ProviderWrapUp", "email survey Yes");
		}
		else
		{
			return	utils.clickAnelemnt(emailSurveyNo,"ProviderWrapUp", "email survey No");
		}

	}

	/** This method enters caller email address
	 * 
	 */

	@FindBy (xpath="//input[@id='CallerEmailAddress']")	
	private WebElement enterEmailId;

	public boolean enterCallersEmailAddress(String[] email)
	{
		return utils.enterTextinAnelemnt(enterEmailId, email[0], "ProviderWrapUp", "Caller email address");
	}


	@FindBy(id="ERRORMESSAGES_ALL")
	WebElement softWarningPCIMessage;


	/** This method validates the PCI compliance soft warning message
	 * 
	 * @return
	 */

	public boolean validatePCIDataSoftWarningMessage()
	{
		return !utils.isProxyWebelement(softWarningPCIMessage);

	}
}








