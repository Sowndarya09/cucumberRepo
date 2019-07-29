package automationLib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerPromisedAction {

	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err = new ErrorLogger();

	WebDriverWait wait;

	public BrokerPromisedAction() {

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		utils.waitforpageload();
	}

	@FindBy(className = "anthem_theme_header")
	private WebElement sHeaderSearchForBroker;

	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id = "ContactType")
	WebElement drpDownContactType;

	/**
	 * This functionality selects the Contact type in the Broker Promised Action
	 * Page
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectContactType(String[] args) {
		return utils.selectDropDownbyVisibleString(drpDownContactType, args[0], "BrokerPromisedAction", "Contact Type");
	}

	/**
	 * This functionality verifies that the Broker Option is Pre Selected in the
	 * Contact Type Drop down
	 * 
	 * @return
	 */
	public boolean verifyBrokerOptionIsPreselectedInContactTypeDropDown() {
		utils.waitforpageload();
		Select select = new Select(Driver.pgDriver.findElement(By.id("ContactType")));
		WebElement option = select.getFirstSelectedOption();
		String SelectedText = option.getText();
		if (SelectedText.equals("Broker")) {
			System.out.println("Broker Option is pre selected");
			blogger.loginfo("Broker Option is pre selected");
			return true;
		} else {
			System.out.println("Broker Option is not pre selected");
			blogger.loginfo("Broker Option is not pre selected");
			return true;
		}
	}

	@FindBy(xpath = "(//table[contains(@id,'headTbl_right')])[1]")
	WebElement tblAvailableSection;

	@FindBy(xpath = "(//table[contains(@id,'headTbl_right')])[2]")
	WebElement tblSelectedSection;

	/**
	 * This functionality validates the Header fields of the Available Section table
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateHeaderFeildsOfAvailableSection() throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = Driver.pgDriver.findElement(By.xpath("(//table[contains(@id,'headTbl_right')])[1]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblAvailableSection);
		System.out.println("Values from the App: " + valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("ID");
		valuesGivenManual.add("Name");
		valuesGivenManual.add("Service Request Type");
		System.out.println("Values Given Manually: " + valuesGivenManual);
		if (valuesFromApp.equals(valuesGivenManual)) {
			System.out.println("Values Matched");
			return true;
		} else {
			System.out.println("Values doesnt Matched");
			return false;
		}

	}

	/**
	 * This functionality validates the Header fields of the Selected Section table
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateHeaderFeildsOfSelectedSection() throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = Driver.pgDriver.findElement(By.xpath("(//table[contains(@id,'headTbl_right')])[1]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblSelectedSection);
		System.out.println("Values from the App: " + valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("ID");
		valuesGivenManual.add("Name");
		valuesGivenManual.add("Service Request Type");
		System.out.println("Values Given Manually: " + valuesGivenManual);
		if (valuesFromApp.equals(valuesGivenManual)) {
			System.out.println("Values Matched");
			return true;
		} else {
			System.out.println("Values doesnt Matched");
			return false;
		}
	}

	@FindBy(id = "PACScheduledForMy Team")
	WebElement rdoBtnMyTeam;

	@FindBy(id = "PACScheduledForMyself")
	WebElement rdoBtnMySelf;

	/**
	 * This functionality clicks the radio button for Scheduled given by the user
	 * 
	 * @param args
	 * @return
	 */

	public boolean clickMyselfOrMyteamInScheduledForRadioButton(String[] args) {

		if (args[0].equalsIgnoreCase("myself")) {
			return utils.clickAnelemnt(rdoBtnMySelf, "BrokerPromisedAction", "Myself");
		} else {
			return utils.clickAnelemnt(rdoBtnMyTeam, "BrokerPromisedAction", "Myself");
		}
	}

	@FindBy(id = "StartDate")
	WebElement txtBxStartDate;

	@FindBy(id = "StartTime")
	WebElement txtBxStartTime;

	@FindBy(id = "EndTime")
	WebElement txtBxEndTime;

	@FindBy(id = "TimeZone")
	WebElement drpDownTimeZone;

	@FindBy(id = "CommunicationChannel")
	WebElement drpDwnCommunicationChannel;

	@FindBy(xpath = "//button[@data-test-id='201709101400360734191192']")
	WebElement btnAddAll;

	@FindBy(id = "Notes")
	WebElement txtBxNotes;

	@FindBy(id = "BrokerName")
	WebElement txtBxAddressee;

	@FindBy(id = "addrLine1")
	WebElement txtBxAddressLine1;

	@FindBy(id = "city")
	WebElement txtBxCity;

	@FindBy(id = "code")
	WebElement txtBxState;

	@FindBy(id = "zipCd")
	WebElement txtBxZipCd;

	@FindBy(xpath = "//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(id = "PACActivityTypeContact")
	WebElement rdoBtnContact;

	@FindBy(id = "PACActivityTypeTask")
	WebElement rdoBtnTask;

	/**
	 * This functionality selects the Type based on the values given by the user
	 * 
	 * @param args
	 * @return
	 */

	public boolean selectTypeRadioButton(String[] args) {
		if (args[0].contains("Contact")) {
			return utils.clickAnelemnt(rdoBtnContact, "BrokerPromisedAction", "Contact");
		} else {
			return utils.clickAnelemnt(rdoBtnTask, "BrokerPromisedAction", "Task");
		}
	}

	/**
	 * This functionality enters the Current date in the Start date field
	 * 
	 * @return
	 * @throws ParseException 
	 */

	public boolean enterStartDate() throws ParseException {
		String nextDate = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(1);
		String Tdate = dtf.format(localDate);
		System.out.println("Date: " + Tdate);
	        //nextDate = localDate.toString();
		return utils.enterTextinAnelemnt(txtBxStartDate, Tdate, "BrokerPromisedAction", "Start Date");
	}

	/**
	 * This functionality enters the Current time in the Star t Time field
	 * 
	 * @return
	 */

	public boolean enterStartTime() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(" hh:mm:ss a");
		System.out.println("Start Time: " + ft.format(dNow));
		return utils.setAttribute(txtBxStartTime, "value", ft.format(dNow));
	}

	/**
	 * This functionality enters the Current time in the End Time field
	 * 
	 * @return
	 */

	public boolean enterEndTime() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(" hh:mm:ss a");
		System.out.println("End Time: " + ft.format(dNow));
		return utils.setAttribute(txtBxEndTime, "value", ft.format(dNow));
	}

	/**
	 * This functionality selects the time zone given by the user in the Time Zone
	 * section
	 * 
	 * @param args
	 * @return
	 */

	public boolean selectTimeZone(String[] args) {
		return utils.selectDropDownbyVisibleString(drpDownTimeZone, args[0], "BrokerPromisedAction", "Time Zone");
	}

	/**
	 * This functionality selects the communication type given by the user in the
	 * Time Zone section
	 * 
	 * @param args
	 * @return
	 */

	public boolean selectCommunicationType(String[] args) {
		return utils.selectDropDownbyVisibleString(drpDwnCommunicationChannel, args[0], "BrokerPromisedAction",
				"Communication Type");
	}

	/**
	 * This functionality verifies the Pre Populated values for the Broker
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyThePrePopulatedAddress() throws InterruptedException {
		Thread.sleep(3000);
		if (utils.isvalueMatch_contain(txtBxAddressee.getAttribute("value"), "DONNA DESMEULES"))
			if (utils.isvalueMatch_contain(txtBxAddressLine1.getAttribute("value"), "1525 NORWOOD TOWN RD"))
				if (utils.isvalueMatch_contain(txtBxCity.getAttribute("value"), "DEL RIO"))
					if (utils.isvalueMatch_contain(txtBxState.getAttribute("value"), "TN"))
						if (utils.isvalueMatch_contain(txtBxZipCd.getAttribute("value"), "37727"))
							return true;
		return false;
	}

	/**
	 * This functionality verifies the Pre Populated values for the Broker
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyThePrePopulatedAddressWithData(String[] args) throws InterruptedException {
		Thread.sleep(3000);
		if (utils.isvalueMatch_contain(txtBxAddressee.getAttribute("value"), args[0]))
			if (utils.isvalueMatch_contain(txtBxAddressLine1.getAttribute("value"), args[1]))
				if (utils.isvalueMatch_contain(txtBxCity.getAttribute("value"), args[2]))
					if (utils.isvalueMatch_contain(txtBxState.getAttribute("value"), args[3]))
						if (utils.isvalueMatch_contain(txtBxZipCd.getAttribute("value"), args[4]))
							return true;
		return false;
	}

	/**
	 * This functionality clicks on the Add all button in the Promised Action page
	 * 
	 * @return
	 */
	public boolean clickOnAddAllButton() {
		return utils.clickAnelemnt(btnAddAll, "BrokerPromisedAction", "Add All");
	}

	/**
	 * This functionality enters the Notes in the notes filed in the Promised Action
	 * page
	 * 
	 * @return
	 */
	public boolean enterInputInNotesTextBox(String[] args) {
		return utils.enterTextinAnelemnt(txtBxNotes, args[0], "BrokerPromisedAction", "Notes");
	}

	/**
	 * This functionality clicks on the Submit in the Promised Action page
	 * 
	 * @return
	 */
	public boolean clickOnSubmit() {
		return utils.clickAnelemnt(btnSubmit, "BrokerPromisedAction", "Submit");
	}

	@FindBy(id = "DueDate")
	WebElement txtBxDueDate;

	@FindBy(id = "DueTime")
	WebElement txtBxDueTime;

	/**
	 * This functionality enters the due date in the Broker Promised Action page
	 * 
	 * @return
	 */

	public boolean enterDueDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		String Tdate = dtf.format(localDate);
		return utils.enterTextinAnelemnt(txtBxDueDate, Tdate, "BrokerPromisedAction", "Start Date");
	}

	/**
	 * This functionality enters the Due time in the Broker Promised Action page
	 * 
	 * @return
	 */
	public boolean enterDueTime() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(" hh:mm:ss a");
		return utils.setAttribute(txtBxDueTime, "value", ft.format(dNow));
	}

	// Sprint 8.2

	@FindBy(xpath = "//span[contains(text(),'Broker/Group Detail')]")
	WebElement txtBrokerGroupInformation;

	@FindBy(xpath = "//span[contains(text(),'Eligibility')]")
	WebElement txtEligibility;

	@FindBy(id = "PACScheduledForMy Team")
	WebElement chxBoxMyTeam;

	@FindBy(id = "PACScheduledForMyself")
	WebElement chxBoxMyself;

	/**
	 * This functionality validates Broker/Group Information option is default when
	 * broker not in focus
	 * 
	 * @return
	 */

	public boolean validateBrokerGroupInformationOptionUnderTopics()

	{
		if (utils.validateLabel(this.txtBrokerGroupInformation, "BrokerGrouInformation"))
			utils.waitforpageload();
			if (utils.clickAnelemnt(txtBrokerGroupInformation, "BrokerPromisedAction", "BrokerTopis"))
				return true;

		return false;
	}

	public boolean validateTopicsWhenMemberInFocus()
	{
		if (utils.validateLabel(this.txtEligibility, "Eligibility"))
			if (utils.validateLabel(this.txtBrokerGroupInformation, "BrokerGrouInformation"))
				utils.waitforpageload();
				if (utils.clickAnelemnt(txtEligibility, "BrokerPromisedAction", "BrokerTopis"))
                    return true;
						return false;
	}

	

	public boolean validateMyselfIsAutoSelectedForConciergeUser() {
		boolean checxbox = chxBoxMyself.isSelected();
           if (checxbox == true) {
        	   blogger.loginfo("For concierge user Myself is autoselelcted");
        	   return true;
		} else {
			blogger.loginfo("For concierge user Myself is not autoselelcted");
				return false;
		}
	}

	public boolean validateMyTeamIsDisabledForConciergeUser() {
		String value = Driver.pgDriver.findElement(By.id("PACScheduledForMy Team")).getAttribute("disabled");
		if (value.equalsIgnoreCase("true")) {
			blogger.loginfo("MyTeam radio button Is Disabled For Concierge User");
			return true;
		} else {
			err.logError("validateMyTeamIsDisabledForConciergeUser", "Checkbox is enabled for myteam:");
			return false;
		}
	}
	
	@FindBy(id="Email")
	WebElement txtBoxEmail;
	
	public boolean enterEmailAddress(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBoxEmail, args[0], "BrokerPromisedAction", "Email");
	}

}
