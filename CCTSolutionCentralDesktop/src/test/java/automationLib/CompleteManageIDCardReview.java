package automationLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CompleteManageIDCardReview {


	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	WebDriverWait wait;
	public CompleteManageIDCardReview() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}


	@FindBy(xpath="//select[@id='ReasonForRequest']")
	WebElement drpDownReasonForRequest;

	@FindBy(xpath="//textarea[@name='$PpyWorkPage$pNotes']")
	WebElement txtNotes;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectReasonForRequestOption
	 * #Description: This functionality selects the reason for request option in the complete manage id card review page 
	 * #Argument: requestoption
	 * keys: Select#Discuss Details on ID Card#Request ID Card
	 */
	public boolean selectReasonForRequestOption(String[] requestoption)
	{
		return utils.selectDropDownbyVisibleString(drpDownReasonForRequest, requestoption[0], "CompleteManageIDCardReview", "Reason for Request option");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterNotes
	 * #Description: This functionality enters the notes in the respective section in Complete Manage ID card review page
	 * #Argument: notes
	 * Type: Textbox
	 */
	public boolean enterNotes(String[] notes)
	{
		if(utils.enterTextinAnelemnt(txtNotes, notes[0], "CompleteManageIDCardReview", "Notes"))
			return this.clickSubmitBtn(); 
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSubmitBtn
	 * #Description: Clicks the Submit button in the Manage ID Card Review page
	 * #Type: Textbox
	 */
	public boolean clickSubmitBtn()
	{
		return utils.clickAnelemnt(btnSubmit, "CompleteManageIDCardReview", "Submit");		
	}

	@FindBy(xpath="//*[@data-test-id='201610261418360678135302']")
	WebElement StatusMessage;

	public boolean verifyStatusMessage(String args[]) {
		return utils.validateLabel(StatusMessage, args[0]);
	}

	@FindBy(xpath="//table[@pl_prop='.VirtualIDCardList']")
	WebElement VirtualIDCardList;

	public boolean validateVirtualIDcardViewedandSentforcontacts(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(VirtualIDCardList,tablevalues);

	}
}
