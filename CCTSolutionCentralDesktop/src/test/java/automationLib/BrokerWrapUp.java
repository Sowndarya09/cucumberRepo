package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerWrapUp {



	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();

	public BrokerWrapUp()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForBroker;

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(xpath="//div[contains(text(),'Other Actions')]")
	WebElement drpDownOtherActions;

	@FindBy(id="CancellationReason")
	WebElement drpDownCancellationReasons;

	@FindBy(id="ReasonForInteraction")
	WebElement drpDownReasonForInteraction;

	@FindBy(id="PrimaryTask")
	WebElement drpDownPrimaryTask;

	@FindBy(id="IsRelatedToPriorInquiryYes")
	WebElement rdoBtnRelatedToPriorInquiryYes;

	@FindBy(id="IsRelatedToPriorInquiryNo")
	WebElement rdoBtnRelatedToPriorInquiryNo;

	@FindBy(id="Comments")
	WebElement txtBxOtherDescription;

	@FindBy(id="WrapUpComments")
	WebElement txtBxWrapUpComments;

	@FindBy(id="$PpyWorkPage$pReasonForInteractionError")
	WebElement imgPrimaryReasonForInteractionFlagError;

	@FindBy(id="$PpyWorkPage$pPrimaryTaskError")
	WebElement imgPrimaryTaskFlagError;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnGrpsubmit;

	/**
	 * This functionality selects the drop down reason in the Cancellation reason drop down in the Wrap Up page
	 * @param args
	 * @return
	 */
	public boolean clickTheReasonInCancellationReasons(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownCancellationReasons, args[0], "BrokerWrapUp", "Cancellation Reasons");
	}

	/**
	 * This functionality navigates to the Cancel the Work from the Other Actions in the Group Search page
	 * @param args
	 * @return
	 */
	public boolean clickCancelThisWorkFromOtherAction(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, args[0], "BrokerWrapUp", "Other Actions --"+args);
	}

	/**
	 * This functionality selects the drop down in the Primary Reason drop down in the Wrap up page
	 * @param args
	 * @return
	 */
	public boolean selectPrimaryReasonOptionInWrapuppage(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownReasonForInteraction, args[0], "BrokerWrapUp", "Interaction");
	}

	/**
	 * This functionality selects the Prior Inquiry Option 'Yes' or 'No' based on the value given by the user
	 * @param args
	 * @return
	 */
	public boolean selectRelatedToPriorInquiryOptionIsPresent(String[] args)
	{
		utils.waitforpageload();
		if(args[0].contains("Yes"))
		{
			return utils.clickAnelemnt(rdoBtnRelatedToPriorInquiryYes, "BrokerWrapUp", "Prior Inquiry -- Yes");
		}else
		{
			return utils.clickAnelemnt(rdoBtnRelatedToPriorInquiryNo, "BrokerWrapUp", "Prior Inquiry -- No");
		}
	}

	/**
	 * This functionality selects the drop down in the Primary Task drop down in the Wrap up page
	 * @param args
	 * @return
	 */
	public boolean selelctPrimaryTaskOptionInWrapupPage(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownPrimaryTask, args[0], "BrokerWrapUp", "Primary Task");
	}

	/**
	 * This functionality enters the text in the Other Description text box in Wrap up page
	 * @param args
	 * @return
	 */
	public boolean enterTextInOtherDescriptionTextBox(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxOtherDescription, args[0], "BrokerWrapUp", "Other Description");
	}

	/**
	 * This functionality enters the text in the comment text box in Wrap up page
	 * @param args
	 * @return
	 */
	public boolean enterTextInCommentsSection(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxWrapUpComments, args[0], "BrokerWrapUp", "Comments");
	}

	/**
	 * This functionality validates that the flag icon is displayed when no details are selected
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateFlagIconDisplayedWhenNoDetilsAreSelected() throws InterruptedException
	{
		if(utils.clickAnelemnt(btnGrpsubmit,"BrokerSearchForGroup","Submit"))
		{
			if(utils.isAlertPresent())
			{
				return !utils.isProxyWebelement(imgPrimaryReasonForInteractionFlagError) && !utils.isProxyWebelement(imgPrimaryTaskFlagError);
			}
		}
		return false;

	}

	/**
	 * This functionality performs click action on the Submit button
	 * @return
	 */
	public boolean clickOnSubmit()
	{
		WebElement element = btnGrpsubmit;
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(btnGrpsubmit,"BrokerSearchForGroup","Submit");

	}

	
	public boolean verifyPreselectPrimaryReasonOptionInWrapupPage(String[] args) throws InterruptedException
	{

		Thread.sleep(5000);
		Select select = new Select(drpDownReasonForInteraction);
		WebElement option = select.getFirstSelectedOption();
		String SelectedText = option.getText();
		if(SelectedText.equalsIgnoreCase(args[0]))	
			return true;
		return false;
	}


	//Sprint 7.1
	
		@FindBy(id="GAndATypeOne Day Grievance")
		WebElement rdoBtnOneDayGrievance;

		@FindBy(id="WasTheDissatisfaction")
		WebElement drpDownWasDissatisafaction;

		@FindBy(id="WasTheDissatRelatedTo")
		WebElement drpDownWasDissatisfactionTo;

		@FindBy(xpath="//div[@data-test-id='20171115123818004825955']")
		WebElement txtInstructionalMsg;

		@FindBy(xpath="//div[@data-test-id='20171115123818004825955'][starts-with(text(),'This is a One Day')]")
		WebElement txtInstructionalMsgOneDayGrievance;

		@FindBy(id="DissatisfiedGrievanceNotes")
		WebElement txtNotes;

		@FindBy(id="IsOneDayGrievanceResolvedYes")
		WebElement rdoBtnOneDayGrievanceYes;

		@FindBy(id="IsOneDayGrievanceResolvedNo")
		WebElement rdoBtnOneDayGrievanceNo;

		
		
		public boolean verifyWasDissatisfactionAndWasDissatisfactionRelatedToDrpDownIsDisplayed()
		{
			try
			{
				if(this.drpDownWasDissatisafaction.isDisplayed() && this.drpDownWasDissatisfactionTo.isDisplayed());
				{
					
					System.out.println("Was Dissatisafction and Was Dissatisafction To drop down is displayed");
					return  true;
				}
			}catch(Exception e)
			{
				err.logcustomerrorwithmessage("GrievanceAndAppeals", "verifyWasDissatisfactionAndWasDissatisfactionRelatedToDrpDownIsDisplayed", "Was Dissatisafction and Was Dissatisfaction To drop down is not displayed");
				return false;
			}
		}

		public boolean selectDissatisafctionDropDownValues(String[] args)
		{
				return utils.selectDropDownbyVisibleString(this.drpDownWasDissatisafaction, args[0], "GrievanceAndAppeals", "Dissatisfaction Drop down");
		}

		public boolean selectDissatisafctionRelatedToDropDownValues(String[] args)
		{
				return utils.selectDropDownbyVisibleString(this.drpDownWasDissatisfactionTo, args[0], "GrievanceAndAppeals", "Dissatisfaction To Drop down");
		}


		public boolean validateInstMessageToSelectGrievance()
		{
			String actualText = "This is a Standard Grievance. Select the Grievance option and complete the Grievance and Appeals task.";
			String expectedText = txtInstructionalMsg.getText();
			System.out.println("Expected msg: "+expectedText);
			if(actualText.equalsIgnoreCase(expectedText))
			{
				
				System.out.println("Actual Text and Expected Text for Instructional Text is validated and matched");
				return true;
			}
			else
			{
				
				System.out.println("Actual Text and Expected Text for Instructional Text is validated and doesn't matched");
				return false;
			}
		}

		public boolean validateInstMessageForUserToCompleteOneDayGrievance()
		{
			String actualText = "This is a One Day (Exempt) Grievance.  If you are not able to close the service request during the interaction keep it in your work list. It will be classified as a one day grievance. Make sure it is closed by the end of the day the next business day. If you are unable to resolve the request by the end of the day the next business day, a Standard Grievance must be opened.";
			String expectedText = txtInstructionalMsgOneDayGrievance.getText();
			System.out.println("Expected msg: "+expectedText);
			if(actualText.equalsIgnoreCase(expectedText))
			{
				
				System.out.println("Actual Text and Expected Text of Instructional Text to complete grievance is validated and matched");
				return true;
			}
			else
			{
				
				System.out.println("Actual Text and Expected Text of Instructional Text to complete grievance is validated and doesn't matched");
				return false;
			}
		}


		public boolean enterNotesInOneDayGrievance(String[] notes)
		{
				return utils.enterTextinAnelemnt(this.txtNotes, notes[0], "GrievanceAndAppeals", "Notes is entered");	    		
		}

		public boolean validatesOneDayGrievanceQuestion(String[] args)
		{
			if((args[0]).trim().equalsIgnoreCase("Yes")){
				return utils.clickAnelemnt(rdoBtnOneDayGrievanceYes, "GrievanceAndAppeals", "rdoBtnOneDayGrievanceYes");
			}else if ((args[0]).trim().equalsIgnoreCase("No")){
				return utils.clickAnelemnt(rdoBtnOneDayGrievanceNo, "GrievanceAndAppeals", "rdoBtnOneDayGrievanceNo");
			}
			return false;
		}

		

		@FindBy(xpath = "//div[contains(text(),'Launch Grievance and Appeals Task')]")
		WebElement lnkGrievanceAndAppealsTask;
		
		public boolean clickLaunchGrievanceAndAppealsTask() {
			return utils.clickAnelemnt(this.lnkGrievanceAndAppealsTask, "WrapUp", "Grievance and Appeals Task");
		}
		
		public boolean WrapUp() throws InterruptedException {
			if(utils.selectDropDownbyIndex(drpDownReasonForInteraction,1, "BrokerWrapUp", "Interaction"))
				if(utils.selectDropDownbyIndex(drpDownPrimaryTask, 1, "BrokerWrapUp", "Primary Task"))
				if(utils.clickAnelemnt(rdoBtnRelatedToPriorInquiryYes, "BrokerWrapUp", "Prior Inquiry -- Yes"))
					if(clickOnSubmit())
						return !utils.isAlertPresent();
			return false;
				
		}
		


/**
 * This functionality checks the dropdown values in Primary Task
 * @return
 */

public boolean verifyDropDownValuesInPrimaryTask(String[] args)
{
	ArrayList<String> al = new ArrayList<String>();
	for(String arg: args)
	{
		al.add(arg);
	}
	return utils.checkvaluesinDropDown(drpDownPrimaryTask, al);
}

@FindBy(id="ProductLOB")
WebElement drpDownLOB;

/**
 * Verifies the drop down values in the LOB Discussed Drop Down
 * @param args
 * @return
 */
public boolean verifyDropDownValuesInProductLOBDiscussed(String[] args)
{
	ArrayList<String> al = new ArrayList<String>();
	for(String arg: args)
	{
		al.add(arg);
	}
	return utils.checkvaluesinDropDown(drpDownLOB, al);
}

public boolean selectProductLOBDiscussedInWrapuppage(String[] args)
{
	return utils.selectDropDownbyVisibleString(drpDownLOB, args[0], "BrokerWrapUp", "LOB Discussed");
}




}
