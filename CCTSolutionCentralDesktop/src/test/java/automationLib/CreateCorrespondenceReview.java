package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CreateCorrespondenceReview extends Driver {

	/**
	 * Methods in the Program 
	 */
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(),20);
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Correspondence class defining the Iframe and the Page Factory  
	 */
	public CreateCorrespondenceReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="ReasonForContact")
	WebElement ReasonForContact;

	@FindBy(id="Notes")
	WebElement NotesSection;

	/**This method validates the dropdown values displayed for Reason for Contact and enter Notes  description on create correspondence Review page.
	 * 
	 */
	public boolean selectReasonForContactAndNotes(String[] args) {
		boolean flag;
		String value[] = args[0].split(";");
		flag = utils.selectDropDownbyVisibleString(ReasonForContact, value[0], "CreateCorrespondenceReview", "ReasonForContact");
		if(flag) {
			blogger.loginfo("ReasonForContact Dropdown selected");
			return utils.enterTextinAnelemnt(NotesSection, value[1], "CreateCorrespondenceReview", "NotesSection");

		}else {
			blogger.loginfo("ReasonForContact Dropdown not selected");
			return false;
		}
	}

	@FindBy(xpath="//div[text()='Submit']")
	WebElement SubmitButton;

	/**Clicks submit button in Create Correspondence Review Page
	 * @return 
	 * 
	 */
	public boolean clickSubmitButton() {
		return utils.clickAnelemnt(SubmitButton,"CreateCorrespondenceReview", "SubmitButton" );
	}

	@FindBy(xpath="//*[text()='Other actions ']")
	WebElement OtherActions;

	@FindBy(xpath="//span[text()='Create Correspondence']")
	WebElement CreatCorrespondenceLink;

	public boolean navigateToCreateCorrespondenceFromOtherActions() {
		if(utils.clickAnelemnt(OtherActions, "CreateCorrespondenceReview", "OtherActions" ))
			return utils.clickAnelemnt(CreatCorrespondenceLink, "CreateCorrespondenceReview", "CreatCorrespondenceLink" );
		return false;
	}

}
