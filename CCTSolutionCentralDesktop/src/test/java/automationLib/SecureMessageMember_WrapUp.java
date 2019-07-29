package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class SecureMessageMember_WrapUp {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	WebDriverWait wait;

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;
	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 * @throws IOException 
	 */
	public SecureMessageMember_WrapUp() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver

	}
	
	@FindBy(id="CancelReason")
	WebElement drpDownReasonForWrapUp;
	
	@FindBy(id="ReasonForInteraction")
	WebElement drpDownReasonForInteraction;
	
	@FindBy(id="PrimaryTask")
	WebElement drpDownPrimaryTask;
	
	@FindBy(id="IsRelatedToPriorInquiryYes")
	WebElement rdoBtnRelatedToPriorInquiryYes;
	
	@FindBy(id="IsRelatedToPriorInquiryNo")
	WebElement rdoBtnRelatedToPriorInquiryNo;
	
	@FindBy(id="IsSendingAttachmentYes")
	WebElement rdoBtnSendAttachmentYes;
	
	@FindBy(id="IsSendingAttachmentNo")
	WebElement rdoBtnSendAttachmentNo;
	
	@FindBy(id="IsDocNameMatchingRequestYes")
	WebElement rdoBtnDocNameMatchingYes;
	
	@FindBy(id="IsDocNameMatchingRequestNo")
	WebElement rdoBtnDocNameMatchingNo;
	
	@FindBy(id="IsDocHCIDMatchingRequestYes")
	WebElement rdoBtnHCIDMatchingRequestYes;
	
	@FindBy(id="IsDocHCIDMatchingRequestNo")
	WebElement rdoBtnHCIDMatchingRequestNo;
	
	@FindBy(id="IsAttachmentDeletedFromFolderYes")
	WebElement rdoBtnAttachmentDeletedFromFolderYes;
	
	@FindBy(id="IsAttachmentDeletedFromFolderNo")
	WebElement rdoBtnAttachmentDeletedFromFolderNo;
	
	@FindBy(id="IsFormBlankConfirmedYes")
	WebElement rdoBtnFormBlankConfirmedYes;
	
	@FindBy(id="IsFormBlankConfirmedNo")
	WebElement rdoBtnFormBlankConfirmedNo;
	
	
	
	public boolean verifyIfContactFailedValidationIsTheDefaultValue()
	{
		Select select = new Select(drpDownReasonForWrapUp);
		WebElement option = select.getFirstSelectedOption();
		String actualText = option.getText();
		String expectedText = "Contact failed validation";
		return utils.isvalueMatch_contain(actualText, expectedText);
	}
	
	public boolean selectValuesForReasonForInteractionAndPrimaryTaskAndInquiryIndicator()
	{
		if(utils.selectDropDownbyVisibleString(drpDownReasonForInteraction, "Requested help with a claim", "SecureMessageMember_WrapUp", "Reason For Interaction"))
			if(utils.selectDropDownbyVisibleString(drpDownPrimaryTask, "Eligibility", "SecureMessageMember_WrapUp", "Eligibility"))
				if(utils.clickAnelemnt(rdoBtnRelatedToPriorInquiryYes, "SecureMessageMember_WrapUp", "Related Inquiry Indicator - Yes"))		
							return true;
		return false;
		
	}

	public boolean fillValuesForSendingAnAttachmentQuestion()
	{
		if(utils.clickAnelemnt(rdoBtnSendAttachmentYes, "SecureMessageMember_WrapUp", "Send Attachment - Yes"))
			if(utils.clickAnelemnt(rdoBtnDocNameMatchingYes, "SecureMessageMember_WrapUp", "Name Match - Yes"))
				if(utils.clickAnelemnt(rdoBtnHCIDMatchingRequestYes, "SecureMessageMember_WrapUp", "HCID Match - Yes"))
					if(utils.clickAnelemnt(rdoBtnAttachmentDeletedFromFolderYes, "SecureMessageMember_WrapUp", "Deleted From folder - Yes"))
						if(utils.clickAnelemnt(rdoBtnFormBlankConfirmedYes, "SecureMessageMember_WrapUp", "Form Blank - Yes"))
							return true;
		return false;
	}

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;
	
	public boolean clickOnSubmit()
	{
	return utils.clickAnelemnt(btnSubmit, "SecureMessageMember_SelectContract", "Submit");
	}




}
