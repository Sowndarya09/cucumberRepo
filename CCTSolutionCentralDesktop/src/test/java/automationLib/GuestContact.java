package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;
/**
 * Objects for Class Guest Conatct 
 * @author Shardul Negi
 *
 */
public class GuestContact extends Driver{


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	Actions action=new Actions(Driver.pgDriver);
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	public GuestContact()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy (className="anthem_theme_header")	
	private WebElement headerForThePage;
	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Submit']")	
	private WebElement buttonSubmit;



	@FindBy (id="pyFirstName")	
	private WebElement pGuestContactFirstName;
	@FindBy (id="pyLastName")	
	private WebElement pGuestContactLastName;
	@FindBy (id="GuestPhoneNumber")	
	private WebElement pGuestContactPhoneNo;
	@FindBy (id="GroupName")	
	private WebElement pGuestContactGroupName;
	@FindBy (id="GroupNumber")	
	private WebElement pGuestContactGroupNo;
	@FindBy (id="DateOfBirthText")	
	private WebElement pGuestContactDOB;
	@FindBy (id="GuestSSN")	
	private WebElement pGuestContactSSN;


	public WebElement getpGuestContactFirstName() {
		return pGuestContactFirstName;
	}
	public WebElement getpGuestContactLastName() {
		return pGuestContactLastName;
	}
	public WebElement getpGuestContactPhoneNo() {
		return pGuestContactPhoneNo;
	}
	public WebElement getpGuestContactGroupName() {
		return pGuestContactGroupName;
	}
	public WebElement getpGuestContactGroupNo() {
		return pGuestContactGroupNo;
	}
	public WebElement getpGuestContactDOB() {
		return pGuestContactDOB;
	}
	public WebElement getpGuestContactSSN() {
		return pGuestContactSSN;
	}
	public WebElement getHeaderForThemePage() {
		return headerForThePage;
	}
	public WebElement getBtnSubmit() {
		return buttonSubmit;
	}

	public boolean checkHeaderGuestContact()
	{
		if("Guest Contact".contains(this.getHeaderForThemePage().getText().trim()))
		{
			return true;
		}
		else
		{
			return false; 
		}
	}

	public boolean clickButtonSubmitButton()
	{
		return utils.clickAnelemnt(this.getBtnSubmit(), "Exit Interaction ", "Button to Click");

	}

	public boolean setGrpCnctSSN(String sGCSSN)
	{
		return utils.enterTextinAnelemnt(this.getpGuestContactSSN(), sGCSSN, "Group Contact- Guest Info", "TextBoxSSN");

	}

	public boolean setGrpCnctLastName(String sLstName)
	{
		return utils.enterTextinAnelemnt(this.getpGuestContactLastName(), sLstName, "Group Contact- Guest Info", "TextBoxLastName");

	}

	public boolean setGrpCnctFirstName(String sFrstNAme)
	{
		return utils.enterTextinAnelemnt(this.getpGuestContactFirstName(), sFrstNAme, "Group Contact- Guest Info", "TextBoxFirstName");

	}

	public boolean setGrpCnctPhone(String sPhn)
	{
		return utils.enterTextinAnelemnt(this.getpGuestContactPhoneNo(), sPhn, "Group Contact- Guest Info", "TextBoxPhone");

	}

	public boolean setGrpCnctGroupName(String sGrpName)
	{
		return utils.enterTextinAnelemnt(this.getpGuestContactGroupName(), sGrpName, "Group Contact- Guest Info", "TextBoxGroupName");

	}

	public boolean setGrpCnctGroupID(String sGrpID)
	{
		return utils.enterTextinAnelemnt(this.getpGuestContactGroupNo(), sGrpID, "Group Contact- Guest Info", "TextBoxSGroupID");

	}

	@FindBy(xpath="//span[@class='iconError dynamic-icon-error']")
	WebElement ErroMsg;

	public boolean setGrpCnctDOB(String sCntDOB)
	{
		if(utils.clickAnelemnt(this.getpGuestContactDOB(), "Guest Contact", "DOB"))
			if(utils.enterTextinAnelemnt(this.getpGuestContactDOB(), sCntDOB, "Group Contact- Guest Info", "TextBoxDOB"))
				if(utils.isProxyWebelement(ErroMsg))
					return true;
				else
					return utils.enterTextinAnelemnt(this.getpGuestContactDOB(), sCntDOB, "Group Contact- Guest Info", "TextBoxDOB");
		return false;

	}

	/**
	 * Entering the three texts with Mandatory details, depends on the manual tester to test either ways, 
	 * will return false in turn all three details are not entered. 
	 * @param sData: Contains an Array to be entered which will provide three details namely {First Name, Last Name and Phone Number} as the input 
	 * @return
	 */

	public boolean enterMandatoryDetails(String[] sData)
	{
		if(checkHeaderGuestContact())
			if(setGrpCnctFirstName(sData[0]))
				if(setGrpCnctLastName(sData[1]))
					if(setGrpCnctPhone(sData[2]))
						if(setGrpCnctGroupID(sData[3]))
							if(setGrpCnctGroupName(sData[4]))
								if(setGrpCnctSSN(sData[5]))
									return setGrpCnctDOB(sData[6]);
		return false;
	}

	/**
	 * Filling the details of the not requiered Fields
	 * @param sData: Data will be provided anyways {Group ID, Group Name, SSN , DOB}
	 * @return
	 */

	public boolean enterOtherFieldDetails(String[] sData)
	{
		if(checkHeaderGuestContact())
			if(setGrpCnctGroupID(sData[0]))
				if(setGrpCnctGroupName(sData[1]))
					if(setGrpCnctSSN(sData[2]))
						if(setGrpCnctDOB(sData[3]))
							return true;
		return false;
	}


	/**
	 * Entering the details in the Fields and Clicking on submit 
	 * @param sDataMandatory: enter the mandatory values from the user
	 * @param sOthers: enter the details from not mandatory fields
	 * @return
	 */
	public boolean enterDetailsandSubmit(String[] sDataMandatory)
	{
		if(enterMandatoryDetails(sDataMandatory))
			return clickButtonSubmitButton();
		return false;

	}

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Guest Contact']")	
	private WebElement lnkOtherActionsGuestContact;

	public SeleniumUtilities getUtils() {
		return utils;
	}

	public WebElement getLnkOtherActionsGuestContact() {
		return lnkOtherActionsGuestContact;
	}

	public WebElement getLnkOtherActionExitInteraction() {
		return lnkOtherActionExitInteraction;
	}

	public WebElement getLnkOtherActionExternalSearch() {
		return lnkOtherActionExternalSearch;
	}

	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}

	public boolean clickbtnOtherActions()
	{
		return utils.clickAnelemnt(this.getBtnOtherActions(), "Phone Call", "Other actions button");
	}
	public boolean clicklinkexitInteraction() throws InterruptedException
	{
		return utils.clickAnelemnt(this.lnkOtherActionExitInteraction, "Guest Contact", "Other Exitinteraction");
	}

	@FindBy (xpath="//div[@class='menu-panel-wrapper']/following::span[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement lnkOtherActionExitInteraction;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='External Search']")	
	private WebElement lnkOtherActionExternalSearch;

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;


	public boolean exitInteraction() throws InterruptedException{
		utils.waitforpageload();
		if(this.clickbtnOtherActions())
			return this.clicklinkexitInteraction();	
		return false;
	}

	public boolean enterMandatoryDetailsInGuestContact(String[] sData)
	{
		if(checkHeaderGuestContact())
			if(setGrpCnctFirstName(sData[0]))
				if(setGrpCnctLastName(sData[1]))
					if(setGrpCnctPhone(sData[2]))
						if(setGrpCnctSSN(sData[3]))
							return true;
		return false;
	}

	@FindBy(xpath="//h3[contains(text(),'Guest')]")
	WebElement tabGuest;

	@FindBy(xpath="//h3[contains(text(),'Interactions')]")
	WebElement tabInteractions;

	public boolean clickGuestTab()
	{
		return utils.clickAnelemnt(tabGuest, "GuestContact", "Guest");
	}

	public boolean clickInteractionsTab()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(tabInteractions, "GuestContact", "Interactions");
	}

	/**This functionality navigates to the Exit Interaction page by clicking other actions button  and the Exit interaction button
	 * 
	 * @return
	 */
	public boolean navigateToExitInteraction()
	{
		if(this.clickbtnOtherActions())
			if(this.clickExitInteraction())
				return true;
		return false;


	}

	@FindBy(xpath="//span[contains(text(),'Exit Interaction')]")
	WebElement exitInteraction; 

	public boolean clickExitInteraction()
	{
		return utils.clickAnelemnt(this.exitInteraction, "Guest Contact", "Clicks Exit Interaction");
	}

	@FindBy(id="IsEAPInteractionYes")
	WebElement IsEAPInteractionYes;

	@FindBy(id="IsEAPInteractionNo")
	WebElement IsEAPInteractionNo;


	/**This functionality Select yes or no for the question is the call regarding EAP with the member based on the user input
	 * 
	 * @return
	 */
	public boolean answerIsTheCallRegardingEAP(String[] args) {
		if(args[0].equalsIgnoreCase("yes"))
			return utils.clickAnelemnt(IsEAPInteractionYes, "GuestContact", "IsEAPInteractionYes");
		else
			return utils.clickAnelemnt(IsEAPInteractionNo, "GuestContact", "IsEAPInteractionNo");
	}

	@FindBy(id="GuestPhoneNumber")
	WebElement GuestPhoneNumber;

	/**This functionality enters whether First name,last name,phone number,date of birth,group name,group number in EAP Contact information
	 * 
	 * @param sData
	 * @return
	 */
	public boolean enterEAPContactInformation(String[] sData) {
		if(checkHeaderGuestContact())
			if(setGrpCnctFirstName(sData[0]))
				if(setGrpCnctLastName(sData[1]))
					if(setGrpCnctDOB(sData[2]))
						if(setGrpCnctGroupName(sData[3]))
							if(setGrpCnctGroupID(sData[4]))
								if(utils.enterTextinAnelemnt(GuestPhoneNumber, sData[5], "GuestContact", "GuestPhoneNumber"))
									return true;
		return false;

	}

	@FindBy(id="AddressLine1")
	WebElement AddressLine1;

	@FindBy(id="AddressLine2")
	WebElement AddressLine2;

	@FindBy(id="pyCity")
	WebElement City;

	@FindBy(id="pyState")
	WebElement State;

	@FindBy(id="pyPostalCode")
	WebElement ZipCode;

	/**This functionality enters the Address line 1,Address line 2,City,zipcode and selects state from State drop down field in Contact address section
	 * 
	 * @param args
	 * @return
	 */
	public boolean enterContactAddress(String[] args) {
		if(utils.selectDropDownbyVisibleString(State, args[0], "GuestContact", "State"))
			if(utils.enterTextinAnelemnt(AddressLine1, args[1], "GuestContact", "AddressLine1"))
				if(utils.enterTextinAnelemnt(AddressLine2, args[2], "GuestContact", "AddressLine2"))
					if(utils.enterTextinAnelemnt(City, args[3], "GuestContact", "City"))
						if(utils.enterTextinAnelemnt(ZipCode, args[4], "GuestContact", "ZipCode"))
							return true;
		return false;
	}

	@FindBy(id="IsTheGuestEmployeeYes")
	WebElement IsTheGuestEmployeeYes;

	@FindBy(id="IsTheGuestEmployeeNo")
	WebElement IsTheGuestEmployeeNo;

	/**This functionality selects Yes Or No for the question are you the employee
	 * 
	 * @param args
	 * @return
	 */
	public boolean answerAreYouTheEmployee(String[] args) {
		if(args[0].equalsIgnoreCase("yes"))
			return utils.clickAnelemnt(IsTheGuestEmployeeYes, "GuestContact", "IsTheGuestEmployeeYes");
		else
			return utils.clickAnelemnt(IsTheGuestEmployeeNo, "GuestContact", "IsTheGuestEmployeeNo");
	}
	@FindBy(id="RelationshipCode")
	WebElement relationshiptotheemployee;
	/**This functionality selects the respective value from relation ship employee dropdown field
	 * 
	 * @param args
	 * @return
	 */

	public boolean selectRelationshiptotheemployeeForNonEmployee(String[] args) {
		if(utils.selectDropDownbyVisibleString(relationshiptotheemployee, args[0], "GuestContact", "Relationship to the Employee"))
			return true;
		return false;
	}
	@FindBy(id="EmployeeFirstName")
	WebElement txtboxempfirstname;
	@FindBy(id="EmployeeLastName")
	WebElement txtboxemplastname;
	@FindBy(id="EmployeeDateOfBirth")
	WebElement txtboxempdob;
	/**This functionality This functionality enters EAP Employee informations such as Employee name and employee date of birth in the EAP Employee information section  
	 * 
	 * @param args
	 * @return
	 */

	public boolean enterEAPEmployeeInformation(String[] args)
	{
		if(utils.enterTextinAnelemnt(txtboxempfirstname, args[0], "GuestContact", "Employee First Name"))
			if(utils.enterTextinAnelemnt(txtboxemplastname, args[1], "GuestContact", "Employee Last Name"))
				if(utils.enterTextinAnelemnt(txtboxempdob, args[2], "GuestContact", "Employee Date Of Birth"))
					return true;
		return false;
	}


}



