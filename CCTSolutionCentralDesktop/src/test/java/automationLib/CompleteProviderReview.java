package automationLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CompleteProviderReview {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	private WebDriverWait wait;


	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement IframeElement3;

	@FindBy(id="PegaGadget1Ifr")
	private WebElement IframeElement1;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="//table[@pl_prop='.TaggedProviderList']//th[@sortfield='.TagGandA']//img")
	private WebElement hoverImgGAIcon;

	@FindBy(xpath="//table[@pl_prop='.TaggedProviderList']")
	private WebElement reviewTaggedProviderTable;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteProviderReview;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Grievance and App...']")	
	private WebElement lnkOtherRequestGandA;

	@FindBy (id="ReasonForRequest")	
	private WebElement dropdownReasonForContact;

	public CompleteProviderReview()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateReasonForContact
	 * #Description:This method validates the Reason for contact in Complete Provider Review page
	 * #Arguments:Reason for contact
	 * Type:Dropdown
	 * Keys:Request List of Providers#Confirm Provider Participating Status#Request PCP Change#Discuss Provider Termination Letter/Notification
	 */
	public boolean validateReasonForContact(String args[])
	{
		return utils.selectDropDownbyVisibleString(this.dropdownReasonForContact, args[0], "CompleteProviderReview ", "Reason for contact dropdown");
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectReasonForContact
	 * #Description:This method select the Reason for contact in Complete Provider Review page
	 * #Arguments:Reason for contact
	 * Type:Dropdown
	 * Keys:Request List of Providers#Confirm Provider Participating Status#Request PCP Change#Discuss Provider Termination Letter/Notification
	 */
	public boolean selectReasonForContact(String sReason[])
	{
		return utils.selectDropDownbyVisibleString(this.dropdownReasonForContact, sReason[0], "CompleteProviderReview ", "Reason for contact dropdown");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateProviderReviewedWithContact
	 * #Description: This method validates the Provider details reviewed with contact section
	 * #Arguments:Providers Reviewed
	 * Type:Table
	 * Keys:Care Provider#Distance#Location#In/Out Network
	 */
	public boolean validateProviderReviewedWithContact(String args[]){
		try{
			WebElement row = utils.getProviderResultsBasedOnValues(this.reviewTaggedProviderTable,args);
			List<WebElement> rowNo = row.findElements(By.tagName("td"));
			rowNo.get(0).click();
			return true;
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given Provider input" + e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateProviderReviewedAndGrievanceWithContact
	 * #Description:This method validates the Provider details reviewed with contact and Grievance tagged with Contact
	 * #Arguments:Providers Reviewed
	 * Type:Table
	 * Keys:Care Provider#Distance#Location#In/Out Network
	 */
	public boolean validateProviderReviewedAndGrievanceWithContact(String args[]){
		try{
			WebElement row =utils.getProviderResultsBasedOnValues(this.reviewTaggedProviderTable,args);
			System.out.println(row.getAttribute("pl_index"));
			List<WebElement> chkBox = row.findElements(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')]//img"));
			if(chkBox.get(1).isDisplayed()){
				System.out.println("Grievance and Appeal is checked");
			}
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given Provider input" + e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionsRequestGrievanceandAppeals
	 * #Description: This method clicks on Other Actions and selects Request Grievance and Appeals link
	 * Type:Textbox
	 */
	public boolean clickOtherActionsRequestGrievanceandAppeals(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteProviderReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherRequestGandA, "CompleteProviderReview", "Request Grievance and Appeals"))
			{
				utils.waitforpageload();
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.IframeElement3);
				if(utils.validateHeader(this.sHeaderCompleteProviderReview,"Grievance and Appeals"))
					return true;
			}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyHoverTextInGrievanceAndAppealsIcon
	 * #Description:This method validates the hover text displayed on hovering Grievance and Appeals Icon in Provider details reviewed with contact section
	 * Type:Textbox
	 */
	public boolean verifyHoverTextInGrievanceAndAppealsIcon(){
		String hovertext=this.hoverImgGAIcon.getAttribute("data-hover").toString().toLowerCase();
		return utils.isvalueMatch_contain(hovertext, "grievance and appeal");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on Submit button in Complete Provider Review page.
	 * Type:Textbox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltoright();
		return utils.clickAnelemnt(this.btnSubmit, "CompleteProviderReview", "Submit Button");
	}

	@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	WebElement errMsg;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateMsgOnSubmit
	 * #Description:This method validates the message displayed - When CSR tags particular provider for 'Member has Grievance and/ or Appeal for this provider' but does not open 'Grievance and Appeal' from Other Actions and try to click Submit.
	 * Type:Textbox
	 */
	public boolean validateMsgOnSubmit(){
		utils.waitforpageload();
		String msgTxt = "No GandA Launch:You have tagged 'Member has requested a Grievance and/ or Appeal against this provider but has not opened Grievance and Appeal Task. Open the Grievance and Appeal task from the other actions or uncheck the respective provider from 'Member has requested Grievance and/ or Appeal against this provider' option and click Submit.";
		return utils.validateLabel(errMsg, msgTxt);
	}

	@FindBy(xpath="//*[@id='DialogContent'][contains(text(),'Review Member, Contract, Group, and Interaction details and History. Switch the Member or Contract in focus from the correct tabs.')]")
	WebElement memCompositeDialogTxt;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateNoMsgOnSubmit
	 * #Description:This method validates the no message displayed - When CSR tags particular provider for 'Provider details discussed with the contact' and try to submit on Complete Provider Review.
	 * Type:Textbox
	 */
	public boolean validateNoMsgOnSubmit(){
		utils.waitforpageload();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(IframeElement1);
		return !utils.isProxyWebelement(memCompositeDialogTxt);
	}

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Update PCP']")	
	private WebElement lnkOtherUpdatePCP;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionsUpdatePCP
	 * #Description: This method clicks on Other Actions and selects Update PCP link
	 * Type:Textbox
	 */
	public boolean clickOtherActionsUpdatePCP(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteProviderReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherUpdatePCP, "CompleteProviderReview", "Update PCP link"))
			{
				utils.waitforpageload();
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement);
				if(utils.validateHeader(this.sHeaderCompleteProviderReview,"Update PCP"))
					return true;
			}
		return false;
	}

	@FindBy(xpath="//table[@pl_prop='.UpdatePCPMembers']//span[@data-test-id='2017032915312803702862']")
	List<WebElement> updatedPCPTable;

	public boolean checkPCPUpdateSuccessMessage()
	{
		try{
			if(this.updatedPCPTable.get(0).getText().toString().toLowerCase().contains("pcp updated"))
				return true;
			else
			{
				err.logError("CompleteProviderReview", "Successful message not found");
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Exception "+e);
			err.logError("CompleteProviderReview", "Successful message not found");
			return false;		
		}
	}

	public boolean checkPCPUpdateFailureMessage()
	{
		try{
			System.out.println(this.updatedPCPTable.get(0).getText().toString().toLowerCase());
			if(this.updatedPCPTable.get(0).getText().toString().toLowerCase().contains("pcp cannot be updated"))
				return true;
			else
			{
				err.logError("CompleteProviderReview", "Not updated message not found");
				return false;
			}
		}catch(Exception e)
		{
			err.logError("CompleteProviderReview", "Not updated message not found");
			return false;		
		}
	}

	@FindBy(xpath="//li[@title='Grievance and Appeals']")
	WebElement lnkGandAOption;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyRequestGandAOptionIsNotDisplayed
	 * #Description: Verifies that the Request Grievance and Appeal option is not available in Other Actions in Provider Review page
	 * #Type: Textbox
	 */
	public boolean verifyRequestGandAOptionIsNotDisplayed()
	{
		utils.clickAnelemnt(this.btnOtherActions, "CompleteProviderReview", "Other Actions");
		return utils.isProxyWebelement(lnkGandAOption);
	}
}
