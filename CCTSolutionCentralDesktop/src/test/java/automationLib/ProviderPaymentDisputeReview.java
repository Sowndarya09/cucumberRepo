package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderPaymentDisputeReview {
	
	SeleniumUtilities utils= new SeleniumUtilities();

	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	
	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement3;

	public ProviderPaymentDisputeReview()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		try {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement3);
		}catch(Exception e) {
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}
	
	@FindBy(xpath="//*[@data-test-id='201801251040560076186883']")
	WebElement TypeValue;
	
	@FindBy(xpath="//*[@data-test-id='201801091013470060279']")
	WebElement CategoryValue;
	
	@FindBy(xpath="//*[@data-test-id='20180109101347006028258']")
	WebElement SubCategoryValue;
	
	@FindBy(xpath="//*[text()='Line Of Business']/../..//*[@data-test-id='20180109101347006028258']")
	WebElement LineOfBusinessValue;
	
	@FindBy(xpath="//*[@data-test-id='201510091322310162184450']")
	WebElement IssueValue;
	
	@FindBy(xpath="(//*[@data-test-id='201510091322310162184450'])[2]")
	WebElement ExpectedResolutionValue;
	
	@FindBy(xpath="//span[@data-test-id='201811261709030824286536']")
	WebElement EscalationReasonValue;
	
	@FindBy(xpath="//label[text()='Escalate']/../../..//img[@title='Checked']")
	WebElement EscalationValue;
	
	@FindBy(xpath="//label[text()='Is this related to more claims for other members?']/..//img[@title='Checked']")
	WebElement IsRelatedToOtherMembers;
	
	@FindBy(xpath="//label[text()='Is this related to more claims for this member?']/..//img[@title='Checked']")
	WebElement IsRelatedToThisMember;
	
	/**This method validate The Items Discussed During Payment Dispute Review
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateTheItemsDiscussedDuringPaymentDisputeReviewe(String[] args) {
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ProviderPaymentDisputeReview", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"type")){
				returnvar = utils.validateLabel(TypeValue, value);
				continue;}
			else if(utils.isvalueMatch_compareto(key,"category")){
				returnvar = utils.validateLabel(CategoryValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"sub-category")){
				returnvar = utils.validateLabel(SubCategoryValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"line of business")){
				returnvar = utils.validateLabel(LineOfBusinessValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"issue")){
				returnvar = utils.validateLabel(IssueValue, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"resolution")){
				returnvar = utils.validateLabel(ExpectedResolutionValue, value);
				continue;
			}else if(utils.isvalueMatch_contain(key,"escalation reason")) {
				returnvar = utils.validateLabel(EscalationReasonValue, value);
				continue;
			}else if(utils.isvalueMatch_contain(key,"escalate")) {
				if(utils.isvalueMatch_contain("yes", value))
				returnvar = !utils.isProxyWebelement(EscalationValue);
				continue;
			}else if(utils.isvalueMatch_contain(key,"is this related to more claims for other members")) {
				if(utils.isvalueMatch_contain("yes", value))
				returnvar = !utils.isProxyWebelement(IsRelatedToOtherMembers);
				continue;
			}else if(utils.isvalueMatch_contain(key,"is this related to more claims for this member")) {
				if(utils.isvalueMatch_contain("yes", value))
				returnvar = !utils.isProxyWebelement(IsRelatedToThisMember);
				continue;
			}
			else 
				err.logcommonMethodError("ProviderPaymentDisputeReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			blogger.loginfo("Verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("Member Composite", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;
	
	/**This method clicks on submit button
	 * 
	 * @return
	 */
	public boolean clickOnSubmit() {
		utils.scrolltomiddle();
		return utils.clickAnelemnt(SubmitButton, "ProviderPaymentDispute", "SubmitButton");
	}

	/**Holds Script for a minute
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean holdScriptForaMinute() throws InterruptedException {
		Thread.sleep(50000);
		return true;
	}
	
	@FindBy(xpath="//*[@data-test-id='201809281344180664182217']")
	WebElement PDIcon;
	
	@FindBy(xpath="//*[@class='arrow top']/..//div[@id='poc0']")
	WebElement PDHovertext;
	
	/**This functionality validates the Payment Disputes Hover text as Payment Dispute at CLaims Details Grid in Claims Review Page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyPaymentDisputesHoverTextinPDReviewpage() throws InterruptedException {
		String actual = utils.hoverOverElementAndGetText(PDIcon, PDHovertext);
		System.out.println(actual);
		return utils.isvalueMatch_contain(actual, "Payment Dispute");
	}

}
