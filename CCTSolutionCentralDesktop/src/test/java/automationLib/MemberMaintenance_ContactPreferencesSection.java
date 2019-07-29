package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class MemberMaintenance_ContactPreferencesSection {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	public MemberMaintenance_ContactPreferencesSection() 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);	
	}

	@FindBy(xpath="//*[@data-test-id='20171030025447019450450-Label']")
	WebElement PreferredEmailTitle;

	@FindBy(xpath="//*[@data-test-id='20171030025447019450450']")
	WebElement PreferredEmailValue;

	@FindBy(xpath="//*[@data-test-id='201710300704100073110740-Label']")
	WebElement PreferredAddressTitle;

	@FindBy(xpath="//*[@data-test-id='201710300704100073110740']")
	WebElement PreferredAddressValue;

	@FindBy(xpath="//*[@data-test-id='201710300720320219665110-Label']")
	WebElement PreferredTelephoneTitle;

	@FindBy(xpath="//*[@data-test-id='201710300720320219665110']")
	WebElement PreferredTelephoneValue;

	@FindBy(xpath="//*[@data-test-id='201710300729340579181981-Label']")
	WebElement PreferredTextTitle;

	@FindBy(xpath="//*[@data-test-id='201710300729340579181981']")
	WebElement PreferredTextValue;

	/**This method is used to validate header and values with respect to input given
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateListOfPreferences(String[] args) {
		try {
			Boolean flag = true;
			int count = 0;
			Thread.sleep(1000);
			if(PreferredEmailTitle.isDisplayed() && PreferredAddressTitle.isDisplayed() && PreferredTelephoneTitle.isDisplayed() && PreferredTextTitle.isDisplayed()) {
				blogger.loginfo("PASS: Preference Titles are displayed");
				String keyvaluepair="";
				for(String iterator : args)
				{
					keyvaluepair = iterator;

					String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
					String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();

					if(count==args.length) {
						break;
					}
					if(!flag){
						err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
						return false;
					}
					count++;
					if(utils.isvalueMatch_contain(key, "preferred email"))
						flag = utils.validateLabel(PreferredEmailValue, value);
					else if(utils.isvalueMatch_contain(key, "preferred mailing address"))
						flag = utils.validateLabel(PreferredAddressValue, value);
					else if(utils.isvalueMatch_contain(key, "preferred telephone"))
						flag = utils.validateLabel(PreferredTelephoneValue, value);
					else if(utils.isvalueMatch_contain(key, "preferred text"))
						flag = utils.validateLabel(PreferredTextValue, value);
					else {
						err.logcommonMethodError("Member Composite", "Check your key in your keypair. Make sure you are following the same pattern for input");
						flag = false;
					}
				}

			}else {
				blogger.loginfo("FAIL: Preference Titiles are not displayed");
				return false;
			}

			if(flag==true) {
				blogger.loginfo("PASS: Input and value in application matches");
				return true;
			}else { 
				blogger.loginfo("FAIL: Input or value in application missmatch");
				return false;
			}
		}
		catch(Exception e) {
			err.logError(e, "validateListOfPreferences");
			return false;
		}
	}

	@FindBy(xpath="//*[@data-test-id='20171030090559075632753']")
	WebElement Member_Emails;

	@FindBy(xpath="//*[@data-test-id='20171019041706068031617']")
	WebElement Member_TelephoneNumbers;

	@FindBy(xpath="//*[@data-test-id='20171030073738049474924']")
	WebElement Member_MailingAddress;

	@FindBy(xpath="//*[@text='TEXT']")
	WebElement Member_TextNumber;


	/**This method is used to validate Member Email in Contact information section
	 * 
	 */
	public boolean contactInfo_ValidateMemberEmail() {
		try {
			Thread.sleep(1000);
			if(Member_Emails.isDisplayed())
				blogger.loginfo("PASS: Member_Emails is displayed");
			if(utils.validateLabel(PreferredEmailValue, Member_Emails.getText())) {
				return true;
			}else {
				blogger.loginfo("FAIL: Either PreferredEmailValue or Member_Emails is not present");
				return false;
			}
		}
		catch(Exception e) {
			if(utils.validateLabel(PreferredEmailValue, "")){
				blogger.loginfo("PASS: PreferredEmailValue and Member_Emails is not present");
				return true;
			}else {
				blogger.loginfo("FAIL: Either PreferredEmailValue or Member_Emails is not present");
				return false;
			}
		}
	}

	/**This method is used to validate Member Email in Contact information section
	 * 
	 */
	public boolean contactInfo_ValidateTelePhoneNumber() {
		try {
			Thread.sleep(1000);
			if(Member_TelephoneNumbers.isDisplayed())
				blogger.loginfo("PASS: Member_TelephoneNumbers is displayed");
			if(utils.validateLabel(PreferredTelephoneValue, Member_TelephoneNumbers.getText())) {
				return true;
			}else {
				blogger.loginfo("FAIL: Either PreferredTelephoneValue or Member_TelephoneNumbers is not present");
				return false;
			}
		}
		catch(Exception e) {
			if(utils.validateLabel(PreferredTelephoneValue, "")){
				blogger.loginfo("PASS: PreferredTelephoneValue and Member_TelephoneNumbers is not present");
				return true;
			}else {
				blogger.loginfo("FAIL: Either PreferredTelephoneValue or Member_TelephoneNumbers is not present");
				return false;
			}
		}
	}

	/**This method is used to validate Member Email in Contact information section
	 * 
	 */
	public boolean contactInfo_ValidateMailingAddress() {
		try {
			Thread.sleep(1000);
			if(Member_MailingAddress.isDisplayed())
				blogger.loginfo("PASS: Member_MailingAddress is displayed");
			if(utils.validateLabel(PreferredAddressValue, Member_MailingAddress.getText())) {
				return true;
			}else {
				blogger.loginfo("FAIL: Either PreferredAddressValue or Member_MailingAddress is not present");
				return false;
			}
		}
		catch(Exception e) {
			if(utils.validateLabel(PreferredAddressValue, "")){
				blogger.loginfo("PASS: PreferredAddressValue and Member_MailingAddress is not present");
				return true;
			}else {
				blogger.loginfo("FAIL: Either PreferredAddressValue or Member_MailingAddress is not present");
				return false;
			}
		}
	}

	/**This method is used to validate Member Email in Contact information section
	 * 
	 */
	public boolean contactInfo_ValidatTextNumber() {
		try {
			Thread.sleep(1000);
			if(Member_TextNumber.isDisplayed())
				blogger.loginfo("PASS: Member_TextNumber is displayed");
			if(utils.validateLabel(PreferredTextValue, Member_TextNumber.getText())) {
				return true;
			}else {
				blogger.loginfo("FAIL: Either PreferredTextValue or Member_TextNumber is not present");
				return false;
			}
		}
		catch(Exception e) {
			if(utils.validateLabel(PreferredTextValue, "")){
				blogger.loginfo("PASS: PreferredTextValue and Member_TextNumber is not present");
				return true;
			}else {
				blogger.loginfo("FAIL: Either PreferredTextValue or Member_TextNumber is not present");
				return false;
			}
		}
	}

	@FindBy(xpath="//h3[text()='Preferences']")
	WebElement PreferencesTab;
	/**This method is to navigate to Preferences tab
	 * 
	 */
	public boolean selectPreferencesTab() {
		return utils.clickAnelemnt(PreferencesTab, "MemberMaintenance_ContactPreferencesSection", "PreferencesTab");
	}

	@FindBy(xpath="//*[@data-test-id='20171122131518046468892']//ancestor::tr[@class='oddRow cellCont' or @class='evenRow cellCont']")
	WebElement Preferences_TableRows;

	@FindBy(xpath="//*[@data-test-id='20171122131518046468892']//ancestor::tbody/tr[@class='cellCont']/th")
	WebElement Preferences_TableHeader;

	/**This method is used to verify Preferences table values
	 * @throws InterruptedException 
	 * 
	 */
	public boolean preferences_VerifyTableValues() throws InterruptedException {
		Thread.sleep(2000);
		Boolean flag =false;
		List<WebElement> membersInfoPlan = Preferences_TableRows.findElements(By.xpath("//*[@data-test-id='20171122131518046468892']"));

		String[] memberPlanInfoNHeatltyValues = {"Status Updates (Optional)","New Plans & Offers Available (Optional)","Benefits Update & Legal Info","Explanation of Benefits (EOBs)",
				"Monthly Bill","Payment Reminder (Optional)","Preventative Care Reminders","Health and Wellness Programs and Discounts (Optional)","Health and Wellness Information and Advice (Optional)"};

		if(memberPlanInfoNHeatltyValues.length==membersInfoPlan.size()) {
			for(int i=0;i<membersInfoPlan.size();i++) {
				if(utils.validateLabel(membersInfoPlan.get(i), memberPlanInfoNHeatltyValues[i])) {
					blogger.loginfo("PASS: Values in Application matches the input values "+ memberPlanInfoNHeatltyValues[i]);
					if(utils.validateLabel(membersInfoPlan.get(i), "(Optional)")){
						String clearSelection = "(//*[@data-test-id='20171122131518046468892']//ancestor::tr[@class='oddRow cellCont' or @class='evenRow cellCont'])["+(i+1)+"]/td[7]";
						WebElement clearSelectionElement = Driver.pgDriver.findElement(By.xpath(clearSelection));
						utils.validateLabel(clearSelectionElement, "Clear Selection");
						blogger.loginfo("PASS: Values having Optional also have Clear Selection Option");
						flag=true;
					}else {
						blogger.loginfo("FAIL: Value does not match with input values");
						flag=false;
					}
				}
			}
			if(flag) {
				blogger.loginfo("Verification of Preferences table passed");
				return true;
			}else {
				blogger.loginfo("Verification of Preferences table failed");
				return false;
			}

		}else {
			blogger.loginfo("FAIL: Information on the Member's Plan or Staying Healthy input and application size does not match");
			return false;
		}
	}

	@FindBy(xpath="//*[text()='Apply']")
	WebElement ApplyLink;

	@FindBy(xpath="//*[text()='Yes']")
	WebElement UpdatePreferencePopUp_YesLink;

	public boolean contactInfo_SetMemberEmail(String[] args) {
		if(utils.setAttribute(Member_Emails, "Member_Emails", args[0]))
			if(utils.clickAnelemnt(ApplyLink, "MemberMaintenance_ContactPreferencesSection", "ApplyLink"))
				if(utils.clickAnelemnt(UpdatePreferencePopUp_YesLink, "MemberMaintenance_ContactPreferencesSection", "UpdatePreferencePopUp_YesLink"))
					if(utils.validateLabel(Member_Emails, args[0])) {
						blogger.loginfo("PASS: Email updated");
						return true;
					}
		return false;

	}

	@FindBy(xpath="//*[text()='Demographic Update']")
	WebElement DemographicUpdate;

	public boolean clickOnDemographicUpdateTab() {
		return utils.clickAnelemnt(DemographicUpdate, "MemberMaintenance_ContactPreferencesSection", "DemographicUpdate");

	}

	@FindBy(xpath="//div[text()='Email Address']//ancestor::table[1]")
	WebElement MemberEmails;
	/**
	 * Validate all header column present under Member Email section in Contact Info Section
	 *
	 */
	public boolean validateMemberEmailHeader()
	{
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.MemberEmails);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Preferred");
		valuesGivenManual.add("Email Address");
		valuesGivenManual.add("Email Status");
		valuesGivenManual.add("Source Channel");
		valuesGivenManual.add("Source Origin");
		valuesGivenManual.add("Updated By");
		valuesGivenManual.add("Updated Date Time Stamp");
		valuesGivenManual.add("Actions");

		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			return false;
		}
	}


	@FindBy(xpath="//div[text()='Sales']//ancestor::table[1]")
	WebElement MemberTelephoneNumbers;
	/**
	 *Validate all header column present under Telephone Number section in Contact Info Section
	 *
	 */
	public boolean validateMemberTelephoneNumbersHeader()
	{
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.MemberTelephoneNumbers);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Preferred");
		valuesGivenManual.add("Phone Number");
		valuesGivenManual.add("Sales");
		valuesGivenManual.add("Non-sales");
		valuesGivenManual.add("Reconfirm Consent for Non-sales");
		valuesGivenManual.add("Federal");
		valuesGivenManual.add("State");
		valuesGivenManual.add("Cell");
		valuesGivenManual.add("Updated By");
		valuesGivenManual.add("Updated Date");
		valuesGivenManual.add("Actions");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			return false;
		}
	}

	@FindBy(xpath="//label[@data-test-id='20171106005305003845718']//following::table[1]")
	WebElement MemberTextNumbers;
	/**
	 *Validate all header column present under Member TextNumber section in Contact Info Section
	 *
	 */
	public boolean validateMemberTextNumbersHeader()
	{
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.MemberTextNumbers);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Preferred");
		valuesGivenManual.add("Phone Number");
		valuesGivenManual.add("Source Channel");
		valuesGivenManual.add("Source Origin");
		valuesGivenManual.add("Updated By");
		valuesGivenManual.add("Updated Date");
		valuesGivenManual.add("Actions");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			return false;
		}
	}

	@FindBy(xpath="//label[@data-test-id='20171103063554021555869']//following::table[1]")
	WebElement MemberMailingAddress;
	/**
	 * Validate all header column present under Member Mailing Address section in Contact Info Section
	 * 
	 */
	public boolean validateMemberMailingAddressHeader()
	{
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.MemberMailingAddress);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Preferred");
		valuesGivenManual.add("Mailing Address");
		valuesGivenManual.add("Source Channel");
		valuesGivenManual.add("Source Origin");
		valuesGivenManual.add("Updated By");
		valuesGivenManual.add("Updated Date");
		valuesGivenManual.add("Actions");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			return false;
		}
	}

	@FindBy(xpath="//table[@pl_prop='.PrefInfo']")
	WebElement tblPreference;

	/**
	 * This method allows the users to click hyperlink based on user input related to preference.
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */

	public boolean clickViewHistoryBasedOnUserInput(String[] args) throws InterruptedException
	{
		WebElement row = utils.returntablerowbasedonvalues(tblPreference, args);
		List <WebElement> column =row.findElements(By.xpath("//a[text()='View History']"));
		column.get(0).click();
		return true;
	}



}
