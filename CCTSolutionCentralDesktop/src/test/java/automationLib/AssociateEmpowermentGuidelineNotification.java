package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.SeleniumUtilities;

public class AssociateEmpowermentGuidelineNotification {

	SeleniumUtilities utils= new SeleniumUtilities();

	public AssociateEmpowermentGuidelineNotification()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(xpath="//label[contains(text(),'Associate Empowerment Guidelines Notification')]")
	WebElement AssociateEmpowermentGuidelines;
	
	/**This functionality validates whether Associate empowerment Guidelines Notification screen is displayed when we click on claim hyper link
	 * 
	 * @return
	 */
	public boolean validateAssociateEmpowermentGuidelinesNotificationScreenIsDisplayed() {
		utils.waitforpageload();
		return !utils.isProxyWebelement(AssociateEmpowermentGuidelines);
	}
	
	@FindBy(xpath="//label[@data-test-id='2018112809344107648805-Label']")
	WebElement MemberIndicatedQuestion;
	
	@FindBy(id="DidMemberContactPartProvYes")
	WebElement DidMemberContactPartProvYes;
	
	@FindBy(id="DidMemberContactPartProvNo")
	WebElement DidMemberContactPartProvNo;
	
	/**This functionality Select yes or no for the question  Has the member indicated they were unaware of the providers participating status or any other frustration  based on the user input
	 * 
	 * @param args
	 * @return
	 */
	public boolean answerHasTheMemberIndicatedQuestion(String[] args) {
		String actual = MemberIndicatedQuestion.getText().replaceAll("/n", " ");
		System.out.println(actual);
		if(utils.isvalueMatch_contain(actual, "Did the member indicate they saw a participating provider that referred them to this non-participating specialist"))
			if(utils.isvalueMatch_contain(args[0], "Yes"))
				return utils.clickAnelemnt(DidMemberContactPartProvYes, "AssociateEmpowermentGuidelineNotification", "DidMemberContactPartProvYes");
			else
				return utils.clickAnelemnt(DidMemberContactPartProvNo, "AssociateEmpowermentGuidelineNotification", "DidMemberContactPartProvNo");
		return false;
			
	}
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement SubmitButton;
	
	/**This functionality selects the submit button is out of Network Referral Exception Page
	 * 
	 * @return
	 */
	public boolean clickOnSubmit() {
		return utils.clickAnelemnt(SubmitButton, "AssociateEmpowermentGuidelineNotification", "SubmitButton");
	}
	
	/**This functionality validates whether Associate empowerment Guidelines Notification screen is displayed when we click on claim hyper link OON Condittions based on policy state is not satisfied
	 * 
	 * @return
	 */
	public boolean validateAssociateEmpowermentGuidelinesNotificationScreenIsNotDisplayed() {
		utils.waitforpageload();
		return utils.isProxyWebelement(AssociateEmpowermentGuidelines);
	}
	
	@FindBy(xpath="//span[text()='This claim does not meet the criteria to be adjusted as part of the out-of-network referral exception workflow']")
	WebElement ClaimDoesNotMeetCriteriaMessage;
	
	/**This functionality validates whether the respective message this claim does not meet the criteria to be adjusted as part of the out-of-network referral exception workflow is displayed when we give No to the above question Did the member indicate they saw a participating provider that referred them to this non-participating specialist or a participating provider sent their labs to be taken/read by this non-participating lab question
	 * 
	 * @return
	 */
	public boolean validateRespectiveMessageIsDisplayed() {
		return !utils.isProxyWebelement(ClaimDoesNotMeetCriteriaMessage);
	}
	
	
}
