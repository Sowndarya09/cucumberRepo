
package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class Provider_RequestClaimAdjustment extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	public Provider_RequestClaimAdjustment()

	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}



	/**
	 * 
	 * Webelements to be used in program
	 */
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement1;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement3;

	@FindBy(className="[Header_nav'][text()=' Phone Call']")
	private WebElement sHeaderPhoneCallTab;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: addclaimadjustment
	 * #Description: This functionality Add the claim Text by selecting the drop down value by index as '3' and clicking the Add button
	 */

	@FindBy(xpath="//a[@data-test-id='201603170553400905315601']")
	WebElement AddButton;

	public boolean addclaimadjustment()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(AddButton, "Provider_RequestClaimAdjustment", "AddButton");

	}

	@FindBy(id="SelectNextAction")
	WebElement drpdwnnextaction;

	public boolean chooseSelectNextAction(String[] args) {
		return utils.selectDropDownbyVisibleString(drpdwnnextaction, args[0], "Provider_RequestClaimAdjustment", "drpdwnnextaction");
	}

	@FindBy(id="ReasonForUrgency")
	WebElement ReasonForUrgency;

	public boolean validatePIREscalationAvailableInReseaonforUrgencydropdown() {

		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("PIR Escalation");
		return utils.checkvaluesinDropDown(ReasonForUrgency, valuestobechecked );
	}

	public boolean validateReseaonforUrgencydropdown() {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		valuestobechecked.add("Irate Member/Broker/Provider");
		return utils.checkvaluesinDropDown(ReasonForUrgency, valuestobechecked );
	}

	@FindBy(id="ClaimID")
	WebElement drpdwnclaimnumber;

	@FindBy(id="ReasonForAdjustments")
	WebElement drpdwnreasonforadjustment;

	@FindBy(id="PrimaryReasonforBilling")
	WebElement reasonForContact;

	@FindBy(id="ClaimsVirtualPodAssociate")
	WebElement drpdwnVirtualpodassociate;
	
	@FindBy(id="ReasonForPending")
	WebElement ReasonForPending;

	public boolean fillRequiredDetails(String [] RequiredDetails)
	{

		Boolean flag = true;
		try
		{

			for(String iterator:RequiredDetails)
			{
				if(!flag) {
					blogger.loginfo("Actual and Expected result doest not match.");
					return false;
				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1);
				System.out.println("key " + key + "value  " + value);

				if(key.toLowerCase().contains("claimn"))
				{
					flag =utils.selectDropDownbyVisibleString(drpdwnclaimnumber, value.toUpperCase(), "RequestClaimAdjustemnt", "claim number drp down");
				}else if(key.toLowerCase().contains("reasonforcontact"))
				{
					utils.selectDropDownbyVisibleString(reasonForContact, value, "RequestClaimAdjustemnt", "reasonForContact");
				}
				else if(key.toLowerCase().contains("reasonforadjustment"))
				{
					flag =utils.selectDropDownbyVisibleString(drpdwnreasonforadjustment, value, "RequestClaimAdjustemnt", "Reason for adjustment");
				}
				else if(key.toLowerCase().contains("action"))
				{
					flag =utils.selectDropDownbyVisibleString(drpdwnnextaction, value, "RequestClaimAdjustemnt", "Next Action DropDown");
				}
				else if (key.toLowerCase().contains("assoc"))
				{
					flag =utils.enterTextinAnelemnt(drpdwnVirtualpodassociate, value, "RequestClaimAdjustemnt", "Next Action DropDown");
				}
				else if (key.toLowerCase().contains("reasonforurgency"))
				{
					flag = utils.selectDropDownbyVisibleString(ReasonForUrgency, value, "RequestClaimAdjustemnt", "ReasonForUrgency");
				}
				else if (key.toLowerCase().contains("pend"))
				{
					flag = utils.selectDropDownbyVisibleString(ReasonForPending, value, "RequestClaimAdjustemnt", "ReasonForUrgency");
				}

			}
			System.out.println("Value selections done");
			return true;

		}

		catch(Exception e)
		{
			System.out.println("catch block "+ e);
			return false;
		}
	}

	@FindBy(xpath="//*[contains(@id,'ReturntoCSR')]")
	WebElement OverrideCheckbox;

	/**This functionality clicks the Override default routing checkbox in the Request Claim Adjustment page
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickOverrideDefaultRoutingCheckbox() throws InterruptedException {
		Thread.sleep(1000);
		return utils.clickAnelemnt(OverrideCheckbox, "RequestClaimAdjustment", "OverrideCheckbox");
	}

	@FindBy(id="ReasonForOverride")
	WebElement ReasonForOverride;

	/**This functionality chooses the Reason For Override from the dropdown
	 * 
	 * @return
	 */
	public boolean selectReasonForOveride(String[] args) {
		utils.waitForElementToBeVisible(ReasonForOverride);
		return utils.selectDropDownbyVisibleString(ReasonForOverride, args[0], "RequestClaimAdjustment", "ReasonForOverride");
	}

	@FindBy (xpath="//*[text()='Submit']")	
	private WebElement btnSubmit;

	/**This functionality makes user to click submit on the Request Claim Adjustment page
	 * 
	 * @return
	 */
	public boolean clickonSubmit()
	{
		utils.scrolltomiddle();
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);", btnSubmit);
		return utils.clickAnelemnt(this.btnSubmit, "RequestClaimAdjustment", "Submit button");
	}
	
	
	
	@FindBy(id="ReasonForPending")
	WebElement drpdwnPend;
	

	
	public boolean verifyPendReasonOptions(String[] args)
	{
		ArrayList<String> drpDownValues = new ArrayList<String>();
		for(String value:args)
		{
			drpDownValues.add(value);
		}
		return utils.checkvaluesinDropDown(drpdwnPend, drpDownValues);
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
	public boolean verifyPaymentDisputesHoverTextinClaimAdjustMentPage() throws InterruptedException {
		String actual = utils.hoverOverElementAndGetText(PDIcon, PDHovertext);
		System.out.println(actual);
		return utils.isvalueMatch_contain(actual, "Payment Dispute");
	}

}



