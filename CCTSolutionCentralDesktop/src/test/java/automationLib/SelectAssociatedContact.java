package automationLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.steadystate.css.parser.selectors.SyntheticElementSelectorImpl;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;
/**
 * Class for Wrap Up Page
 * @author AF02876
 *
 */
public class SelectAssociatedContact extends Driver {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	/**
	 * Constructor for Initializing and Switching to the respecting driver 
	 * 
	 */
	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForMember;
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	String contractName="//*[@class='dataValueRead']/nobr/span"; 
	String textverify="iconRequired standard_iconRequired";

	/**
	 * Constructor with all the details
	 */
	public SelectAssociatedContact()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 50), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	/*
	 * Slecting all objetcs from the page 
	 */
	@FindBy(className="anthem_theme_header")
	private WebElement pgeHeader;
	@FindBy(xpath="//input[contains(@id,'SelectedContactTypeQuick')]")
	private WebElement rdBtnQuickContact;
	@FindBy(xpath="//input[contains(@id,'SelectedContactTypeMember')]")
	private WebElement rdBtnMemberContact;


	@FindBy(id="CallBackNumExt")
	private WebElement txtBoxExtension;


	// table 
	@FindBy(xpath="//table[contains(@pl_prop,'D_MembersOnContract')]")
	private WebElement searchResulttable;
	@FindBy(xpath="//th//div[text()='Select']")
	private WebElement searchResulttableHeaderselect;

	@FindBy(id="Nickname")
	private WebElement txtBoxNickname;

	@FindBy(id="CallBackNumber")
	private WebElement txtBoxCallBackNo;

	@FindBy(xpath="//input[@id='AssociatedContactName']")
	private WebElement txtBoxContactFullName;


	@FindBy(xpath="//select[@id='AssociatedContactType']")
	private WebElement drpDownQuickContactType;

	@FindBy(id="BrokerTaxID")
	private WebElement drpDownbrkrFirmname;

	@FindBy(id="GroupAdmins")
	private WebElement drpDownGroupAdmins;

	@FindBy(id="AssociatedContactRole")
	private WebElement drpDownAssociatedContactRole;
	// Linked to Drop Down 

	//Agent/ Broker AgencyName

	@FindBy(id="AssociatedContactType")
	private WebElement txtBxQuickContactType;

	@FindBy(xpath="//*[contains(@class,'header-title')][text()='Must capture:']")
	private WebElement headerMustCapture;
	@FindBy(xpath="//*[contains(@class,'header-title')][text()='Must Verify:']")
	private WebElement headerMustVerify;
	@FindBy(id="AgencyName")
	private WebElement txtBxAgencyName;
	@FindBy(id="AgencyNumber")
	private WebElement txtBxAgencyNumber;

	// Common Objects for all methods 
	@FindBy(xpath="//input[@id='IsVerReqAgenAdd']")
	private WebElement chkboxVerballyReqstAddress;
	@FindBy(xpath="//input[@id='IsVerReqAgenPhone']")
	private WebElement chboxVerballyReqstPhone;

	@FindBy(id="IsBrokerTaxIDVerified")
	private WebElement chkboxBrokerID;

	@FindBy(xpath="//input[@name='$PtmpBrokerPhoneList$ppxResults$l1$ppySelected'][@id='pySelected1']")
	private WebElement chkboxFirstPhone;

	@FindBy(xpath="//input[@name='$PtmpBrokerAddressList$ppxResults$l1$ppySelected'][@id='pySelected1']")
	private WebElement chkboxFirstAddress;


	@FindBy(id="IsVerReqAgenAdd")
	WebElement chckBxBrokerAddress;
	
	@FindBy(id="IsVerReqAgenPhone")
	WebElement chckBxBrokerPhone;
	
	
	/*
	 * Anthem elements from the Page 
	 */



	// Anthem Associate 
	@FindBy(id="IsVerifiedAnthemAssociatedYes")
	WebElement rdoBtVerifiedAssociateYes;
	@FindBy(id="IsVerifiedAnthemAssociatedNo")
	private WebElement rdoBtVerifiedAssociateNo;

	// Attorney 
	@FindBy(id="ContactTypeAttorney")
	private WebElement txtBxNameofFirm;
	//Custodial Parent
	//Parent
	//Friend/Reletive


	//Provider 
	@FindBy(id="ProviderFirstName")
	private WebElement txtBxProviderName;
	@FindBy(id="ProviderNumber")
	private WebElement txtBxProviderNumber;

	@FindBy(id="IsVerReqProviderAdd")
	private WebElement chkBtVerifiedAddress;
	@FindBy(id="IsVerReqProviderPhone")
	private WebElement chkBtVerifiedPhoneNumber;


	//Third Party Administrator
	@FindBy(id="ThirdPartyAdmin")
	private WebElement txtBxThirdPartyAdmin;

	//Group 
	@FindBy (xpath="//*[@id='GroupAdmins']")
	private WebElement drpGroupAdmin;
	@FindBy(xpath="//input[@id='IsGroupNumberVerified']")
	private WebElement chkboxVerifiedGroupNo;
	@FindBy(xpath="//input[@id='IsGroupNameVerified']")
	private WebElement chkBoxVerifiedGroupName;
	@FindBy(xpath="//*[@id='IsVerContactFullName']")
	private WebElement chkBoxVerifiedGrpHealthPlan;

	@FindBy(xpath="//input[@id='IsQCPhoneNumberVerified']")
	private WebElement chkBoxVerifiedGroupPhoneNo;
	//Other 
	@FindBy(id="OtherContactTypeRelation")
	private WebElement txtBxContctTypeRelation;
	@FindBy(id="OtherContactBusinessName")
	private WebElement txtBxContctBusinessName;

	//Group Business Associates

	@FindBy(id="GroupBAName")
	private WebElement txtBoxCompany_AgencyName;
	@FindBy(id="IsQCPhoneNumberVerified")
	private WebElement rdoBtVerifiedPhoneNumber;
	@FindBy(id="PhoneNumber")
	private WebElement txtBxPhoneNumber;
	//Guardian Representative




	//Insurance Carriers has 17 more heading to it which will come under this 
	@FindBy(id="pyCompany")
	private WebElement txtBxNameInsurancePlan;
	@FindBy(id="AssociatedContactRole")
	private WebElement drpDownContactRole;


	// Government Rep, Department of HHS Workers Comp, Fed State Local Govt, 
	@FindBy(id="InsuranceTaxID")
	private WebElement txtBxInsuranceTaxID;
	@FindBy(id="IsVerReqPlanPhone")
	private WebElement rdoBtVerbalRequestAddress;
	@FindBy(id="IsVerReqPlanPhone")
	private WebElement rdoBtVerbalRequestPhone;

	// BSBSA plan
	@FindBy(id="SCCFNumber")
	private WebElement txtBxSCCFNumber;
	@FindBy(id="PlanID")
	private WebElement txtBxPlanID;



	@FindBy(xpath="//*[@title='show feedback']")
	private WebElement lnkShowFeedBack;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Search Member']")	
	private WebElement lnkOtherActionsGuestContact;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement lnkOtherActionExitInteraction;

	// Other Toold 
	@FindBy (xpath="//img[contains(@src,'tool_icon_')]")	
	private WebElement btnImgTool;

	// Tool Mark 
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;
	// Help 

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;

	@FindBy(id="DialogContent")
	private WebElement msgDialougeContent;

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(id="AssociatedContactType")
	private WebElement drpdownquickContactType;




	/*
	 * Getters for the Page
	 */
	public ErrorLogger getErr() {
		return err;
	}

	public WebElement getsHeaderSearchForMember() {
		return sHeaderSearchForMember;
	}

	public WebElement getIframeelement() {
		return Iframeelement;
	}

	public String getContractName() {
		return contractName;
	}

	public String getTextverify() {
		return textverify;
	}

	public WebElement getPgeHeader() {
		return pgeHeader;
	}

	public WebElement getRdBtnQuickContact() {
		return rdBtnQuickContact;
	}

	public WebElement getRdBtnMemberContact() {
		return rdBtnMemberContact;
	}

	public WebElement getTxtBoxExtension() {
		return txtBoxExtension;
	}

	public WebElement getSearchResulttable() {
		return searchResulttable;
	}

	public WebElement getSearchResulttableHeaderselect() {
		return searchResulttableHeaderselect;
	}

	public WebElement getTxtBoxNickname() {
		return txtBoxNickname;
	}

	public WebElement getTxtBoxCallBackNo() {
		return txtBoxCallBackNo;
	}

	public WebElement getTxtBoxContactFullName() {
		return txtBoxContactFullName;
	}

	public WebElement getDrpDownQuickContactType() {
		return drpDownQuickContactType;
	}

	public WebElement getTxtBxQuickContactType() {
		return txtBxQuickContactType;
	}

	public WebElement getHeaderMustCapture() {
		return headerMustCapture;
	}

	public WebElement getHeaderMustVerify() {
		return headerMustVerify;
	}

	public WebElement getTxtBxAgencyName() {
		return txtBxAgencyName;
	}

	public WebElement getTxtBxAgencyNumber() {
		return txtBxAgencyNumber;
	}

	public WebElement getChkboxVerballyReqstAddress() {
		return chkboxVerballyReqstAddress;
	}

	public WebElement getChboxVerballyReqstPhone() {
		return chboxVerballyReqstPhone;
	}



	public WebElement getRdoBtVerifiedAssociateYes() {
		return rdoBtVerifiedAssociateYes;
	}

	public WebElement getRdoBtVerifiedAssociateNo() {
		return rdoBtVerifiedAssociateNo;
	}

	public WebElement getTxtBxNameofFirm() {
		return txtBxNameofFirm;
	}

	public WebElement getTxtBxProviderName() {
		return txtBxProviderName;
	}

	public WebElement getTxtBxProviderNumber() {
		return txtBxProviderNumber;
	}

	public WebElement getChkBtVerifiedAddress() {
		return chkBtVerifiedAddress;
	}

	public WebElement getChkBtVerifiedPhoneNumber() {
		return chkBtVerifiedPhoneNumber;
	}

	public WebElement getTxtBxThirdPartyAdmin() {
		return txtBxThirdPartyAdmin;
	}

	public WebElement getChkboxVerifiedGroupNo() {
		return chkboxVerifiedGroupNo;
	}

	public WebElement getChkBoxVerifiedGroupName() {
		return chkBoxVerifiedGroupName;
	}

	public WebElement getTxtBxContctTypeRelation() {
		return txtBxContctTypeRelation;
	}

	public WebElement getTxtBxContctBusinessName() {
		return txtBxContctBusinessName;
	}

	public WebElement getTxtBoxCompany_AgencyName() {
		return txtBoxCompany_AgencyName;
	}

	public WebElement getRdoBtVerifiedPhoneNumber() {
		return rdoBtVerifiedPhoneNumber;
	}

	public WebElement getTxtBxPhoneNumber() {
		return txtBxPhoneNumber;
	}

	public WebElement getTxtBxNameInsurancePlan() {
		return txtBxNameInsurancePlan;
	}

	public WebElement getDrpDownContactRole() {
		return drpDownContactRole;
	}
	public WebElement getDrpDownGroupAdmin() {
		return  drpGroupAdmin;
	}

	public WebElement getTxtBxInsuranceTaxID() {
		return txtBxInsuranceTaxID;
	}

	public WebElement getRdoBtVerbalRequestAddress() {
		return rdoBtVerbalRequestAddress;
	}

	public WebElement getRdoBtVerbalRequestPhone() {
		return rdoBtVerbalRequestPhone;
	}

	public WebElement getTxtBxSCCFNumber() {
		return txtBxSCCFNumber;
	}

	public WebElement getTxtBxPlanID() {
		return txtBxPlanID;
	}

	public WebElement getLnkShowFeedBack() {
		return lnkShowFeedBack;
	}

	public WebElement getLnkOtherActionsGuestContact() {
		return lnkOtherActionsGuestContact;
	}

	public WebElement getLnkOtherActionExitInteraction() {
		return lnkOtherActionExitInteraction;
	}

	public WebElement getBtnImgTool() {
		return btnImgTool;
	}

	public WebElement getLnkToolViewHistory() {
		return lnkToolViewHistory;
	}

	public WebElement getLnkToolConfigurationTools() {
		return lnkToolConfigurationTools;
	}

	public WebElement getBtnHelp() {
		return btnHelp;
	}

	public WebElement getMsgDialougeContent() {
		return msgDialougeContent;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement gettblSearchresult() {
		return this.searchResulttable;
	}

	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}





	/**
	 * Checking the value of the name of the searched element
	 * @param sName: Enter the Last/ First Name that is to be searched, note this is Case sepecific 
	 * @return
	 */
	public boolean checkContractName(String sName)
	{
		// Since the Id is pointing on two elements with same address, we will loop all the elements and check with each element 
		List<WebElement> contractNames=Driver.pgDriver.findElements(By.xpath(contractName));

		for(WebElement we :contractNames )
		{
			// will check if the provided 
			if(we.toString().trim().contains(sName))
			{

				return true; 
			}
		}


		return false;


	}


	/**
	 * Checking the value of the name of the searched element
	 * @param sName: Enter the Last/ First Name that is to be searched, note this is Case sepecific 
	 * @return
	 */
	public boolean headerEntry(String sName)
	{
		// Since the Id is pointing on two elements with same address, we will loop all the elements and check with each element 
		List<WebElement> TextNames=Driver.pgDriver.findElements(By.xpath(textverify));

		for(WebElement we :TextNames )
		{
			// will check if the provided 
			if(we.toString().trim().contains("Was the associate verified in the directory/email?"))
			{

				return true; 
			}
		}


		return false;


	}

	/**
	 * Search a table using the column name 	
	 * @param columnName
	 * @return
	 */
	public ArrayList<String> getsearchResultbyColumn(String columnName){
		ArrayList<String> returnColumn =new ArrayList<String>();

		try
		{
			returnColumn=utils.getcolumnStringFromTableByName(this.gettblSearchresult(), columnName);
		}
		catch(StaleElementReferenceException e)
		{
			getsearchResultbyColumn(columnName);
		}

		return returnColumn;
	}

	public boolean clickbtnOtherActions()
	{

		return utils.clickAnelemnt(this.getBtnOtherActions(), "Phone Call", "Other actions button");

	}

	/**
	 * Implicit wait for wating for the element in the page 
	 */

	public void waitForSubmit()
	{
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(this.btnSubmit));
	}



	/**
	 * Common methods in the Program 
	 */

	/*
	 * setting Text Boxes values  
	 */

	/**
	 * Checking the value from the text box in the text boxes
	 * @return
	 */
	public boolean checktxtNixkName()
	{
		System.out.println(this.getTxtBoxNickname().getAttribute("value"));
		if(utils.getValuefromTextBox(this.getTxtBoxNickname(),  "Select Associate Contact", "NickName ").trim().equalsIgnoreCase("Nickname"))
		{
			System.out.println("Pass  :  The Text Field in the box matches with that of the Provided Data \n\n");

			return true;
		}
		return false;
	}
	public boolean checktxtCallBackNo()
	{
		if(utils.getValuefromTextBox(this.getTxtBoxCallBackNo(),  "Select Associate Contact", "CallBack Numbber").trim().equalsIgnoreCase("(123) 456-7890"))
		{
			System.out.println("Pass  :  The Text Field in the box matches with that of the Provided Data \n\n");
			return true;
		}
		return false;

	}

	/*
	 * Clicking on radio buttons and Check Boxes 
	 * 
	 */

	public boolean clickrbtnVerbalRequestPhone()
	{
		return utils.clickAnelemnt(this.getRdoBtVerbalRequestPhone(), "Select Associate Contact", "Radio Buttoon  Verify Associate");
	}
	public boolean clickrbtnVerbalRequestAddress()
	{
		return utils.clickAnelemnt(this.getRdoBtVerbalRequestAddress(), "Select Associate Contact", "Radio Buttoon  Verify Associate");
	}

	public boolean clickrbtnVerifiedAssociateYes()
	{
		return utils.clickAnelemnt(this.getRdoBtVerifiedAssociateYes(), "Select Associate Contact", "Radio Buttoon  Verify Associate");
	}

	public boolean clickrbtnVerifiedAssociateNo()
	{
		return utils.clickAnelemnt(this.getRdoBtVerifiedAssociateNo(), "Select Associate Contact", "Radio Buttoon  Verify Associate");
	}
	public boolean clickrbtnMemberonContact()
	{
		return utils.clickAnelemnt(this.getRdBtnMemberContact(), "Select Associate Contact", "Radio Buttoon  Member on Contact");
	}


	public boolean clickbtnSubmit()
	{
		utils.scrolltomiddle();
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);", btnSubmit);		
		return utils.clickAnelemnt(this.getBtnSubmit(), "Select Associate Contact", "Button Submit");

	}

	int count = 0;
	public boolean clickrbtnQuickContact()
	{

		try
		{
			return utils.clickAnelemnt(this.getRdBtnQuickContact(), "Select Associate Contact", "Radio Buttoon  Quick Contact");
		}
		catch(StaleElementReferenceException e)
		{
			if(count++==3){
				return false;
			}
			clickrbtnQuickContact();
		}
		return false;
	}


	public boolean clickchckBoxesVerballyRequestAddress()
	{
		return utils.clickAnelemnt(this.getChkboxVerballyReqstAddress(), "Select Associate Contact", "Check Boxes Verbally request address ");

	}


	public boolean clickchckBoxesVerballyRequestAddressLawFirm()
	{
		return utils.clickAnelemnt(this.getChkbxVerballyRequestAddressLaw(), "Select Associate Contact", "Check Boxes Verbally request address ");
	}

	public boolean clickchckGroupNo()
	{
		WebDriverWait some_element = new WebDriverWait(getPgDriver(),100); 
		some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='IsGroupNumberVerified']")));
		return utils.clickAnelemnt(chkboxVerifiedGroupNo, "SelectAssociatedContact", "Verified Group No Check Box");

	}

	public boolean clickchckGroupName()
	{
		return utils.clickAnelemnt(chkBoxVerifiedGroupName, "SelectAssociatedContact", "Verified Group Name Check Box");
	}
	
	public boolean clickchckGrpHealthPlan()
	{
		return utils.clickAnelemnt(chkBoxVerifiedGrpHealthPlan, "SelectAssociatedContact", "Verified Group Health Plan Check Box");
	}

	public boolean clickchckGroupPhoneNo()
	{
		WebDriverWait some_element = new WebDriverWait(getPgDriver(),100); 
		some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='IsGroupNumberVerified']")));
		return utils.clickAnelemnt(chkBoxVerifiedGroupPhoneNo, "SelectAssociatedContact", "Verified Group Phone No Check Box");
	}

	public boolean clickchckBoxesVerballyRequestNumberLawFirm()
	{
		return utils.clickAnelemnt(this.getChkbxVerballyRequestNumberLaw(), "Select Associate Contact", "Check Boxes Verbally request address ");
	}
	
	public boolean clickchckBoxesVerballyRequestAgency_BrokerNumber()
	{
		return utils.clickAnelemnt(this.getChboxVerballyReqstPhone(), "Select Associate Contact", "Check Boxes Verbally request address ");
	}
	/*
	 * Filling Textboxes
	 */

	public boolean setTxtInsuranceTaxID(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxInsuranceTaxID(), sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");
	}
	
	public boolean setTxtThirdPartyAdminName(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxThirdPartyAdmin(), sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");
	}
	
	public boolean setTxtNameInsurancePlan(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxNameInsurancePlan(), sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");
	}
	public boolean setTxtProvidersNumber(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxProviderNumber(), sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");
	}
	public boolean setTxtProvidersName(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxProviderName(), sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");
	}
	public boolean setTxtGroupBusinessAssociatePhoneNo(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxPhoneNumber(), sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");
	}
	public boolean setTxtCompany_AgencyName(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBoxCompany_AgencyName(), sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");
	}
	public boolean setTxtNameofFirm(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxNameofFirm(), sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");
	}
	public boolean setTxtFullContactName(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBoxContactFullName(), sFullName, "Select Associate Contact", "Text Box Full  Name");

	}
	public boolean setTxtAgencyBrokersName(String sAgencyName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxAgencyName(), sAgencyName, "Select Associate Contact", "Text Box Full  Name");

	}
	public boolean setTxtAgencyBrokersNumber(String sNumber)
	{
		return utils.enterTextinAnelemnt(this.getTxtBxAgencyNumber(), sNumber, "Select Associate Contact", "Text Box Full  Name");

	}
	public boolean clicklinkexitInteraction() throws InterruptedException
	{
		Thread.sleep(10000);
		return utils.clickAnelemnt(this.lnkOtherActionExitInteraction, "Guest Contact", "Other Exitinteraction");
	}

	/**
	 * Selecting the Elements from the Drop down 
	 * @param sReason
	 * @return
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */

	public boolean selectDropDownQuickContactRole(String sReason) throws InterruptedException, AWTException
	{

		Thread.sleep(5000);
		Select sel= new Select(this.getDrpDownQuickContactType());
		sel.selectByVisibleText(sReason);
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		return true;
	}

	/**
	 * Selecting the Elements from the Drop down 
	 * @param sReason
	 * @return
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */

	public boolean selectDropDownInsuranceCarriersContactRoleTab(int iDropdownSelect) throws InterruptedException, AWTException
	{
		Thread.sleep(2000);
		this.txtBoxContactFullName.click();
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		utils.pressDownnTimes(iDropdownSelect);
		robot.keyPress(KeyEvent.VK_ENTER);
		return true;
	}

	public boolean selectDropDownQuickContactRoleUsingClick(int iDropdownSelect) throws InterruptedException, AWTException
	{

		this.txtBoxContactFullName.click();
		Thread.sleep(2000);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		utils.pressDownnTimes(iDropdownSelect);
		robot.keyPress(KeyEvent.VK_ENTER);
		return true;
	}

	@FindBy(xpath="//select[@id='AssociatedContactType']")
	WebElement drpDownAsociatedContactType;
	
	public boolean selectDropDownQuickContactRoleUsingTab(String sReason) throws InterruptedException
	{

		Thread.sleep(5000);
		return utils.selectDropDownbyVisibleString(drpDownAsociatedContactType, "Agent/Broker", "Select Associated Contact Name", "Agent/Broker");
	}
	public boolean selectDropDownQuickContactRoleValue(String sOption) throws InterruptedException
	{

		Thread.sleep(5000);
		Select sel= new Select(this.getDrpDownQuickContactType());
		sel.selectByValue(sOption);	
		return true;
	}


	@FindBy(xpath="//Select[@id='AssociatedContactType']//option[@selected='']")
	private WebElement drpDownCommunucationChannelSelected;
	public boolean selectDropDownCommunicationChannel(String svisibleString) throws InterruptedException, AWTException
	{
		if(utils.selectDropDownbyVisibleString(this.drpDownQuickContactType, svisibleString, "Create Promised action", "Communication Channel"))
			return !utils.isProxyWebelement(this.drpDownCommunucationChannelSelected);
		return false;
	}




	@FindBy(xpath="//*[@id='AssociatedContactRole']")
	private WebElement drpDownQuickContactRole;
	//*[@id='AssociatedContactRole']
	@FindBy(xpath="//Select[@id='AssociatedContactRole']//option[@selected='']")
	private WebElement drpDownContactRoles;
	@FindBy(xpath="//*[@id='GroupAdmins']/option[@selected='']")
	private WebElement drpDownGroupAdminValue;

	public boolean selectDropDownContactRole(String svisibleString) throws InterruptedException, AWTException
	{
		if(utils.selectDropDownbyVisibleString(this.drpDownQuickContactRole, svisibleString, "Create Promised action", "Communication Channel"))
			return (!utils.isProxyWebelement(this.drpDownContactRoles));
		return false;
	}
	
	@FindBy(xpath="//select[@id='GroupAdmins']")
	WebElement drpDownGroupAdmin;
	
	@FindBy(xpath="//select[@id='BrokerTaxID']")
	WebElement drpDownBrokerTaxID;
	
	public boolean selectDropDownGroupAdminUsingTab(String sReason) throws InterruptedException
	{

		Thread.sleep(5000);
		return utils.selectDropDownbyVisibleString(drpDownGroupAdmin, "Contact not on file", "Select Associated Contact", "Contact not on file");
	}
	public boolean selectDropDownBrokerFirmNameUsingTab(String sReason) throws InterruptedException
	{

		Thread.sleep(5000);
		return utils.selectDropDownbyVisibleString(drpDownBrokerTaxID, "Contact not on file", "Select Associated Contact", "Contact not on file");
	}





	/**
	 * Select value from the drop down on selecting the value from Quick Contact type for Agent Broker 
	 * @param sData
	 * @return
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	@FindBy(xpath ="//div[contains(text(),'Relax.')]")
	WebElement verifyMemberdialogContent;
	public boolean validateHeader()
	{
		if(!utils.isProxyWebelement(this.verifyMemberdialogContent))
				return true;
			return false;

	}



	/*
	 * Main Methods for selecting the value from drop Down 
	 */
	/**
	 * Select value from the drop down on selecting the value from Quick Contact type for Agent Broker 
	 * @param sData
	 * @return
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public boolean selectQuickContactAgentBroker(String[] sData) throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Agent/Broker", "QUickContact", "Drpdownquickcontact"))
						if(utils.selectDropDownbyVisibleString(drpDownbrkrFirmname, "Contact not on file","Select assicated contact", "Drpwpn brkr firm name"))
							if(setTxtAgencyBrokersName(sData[0])) 
								if(setTxtAgencyBrokersNumber(sData[1]))
									if(utils.isvalueMatch_contain(headerMustCapture.getText().trim(), "Must capture:"))
									{
										JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
										jse.executeScript("scroll(0, 250);");
										if(clickbtnSubmit())
											return true;
										}
		return false;
	}


	/**
	 * Select value from the drop down on selecting the value from Quick Contact type for Agent Broker 
	 * @param sData
	 * @return
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public boolean selectQuickContactAgentBrokerVrifyVerbally() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Agent/Broker", "QUickContact", "Drpdownquickcontact"))
						{
						JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
						jse.executeScript("scroll(0, 250);");					
						if((utils.selectDropDownbyVisibleString(drpDownbrkrFirmname, "Contact not on file", "QUickContact", "drpDownbrkrFirmname")))
							if(clickchckBoxesVerballyRequestAddress())
								if(clickchckBoxesVerballyRequestAgency_BrokerNumber())
									if(clickbtnSubmit())
										return true;
									}
		return false;
	}


	/**
	 * Select value from the drop down on selecting the value from Quick Contact type for ANthem Associate  
	 * @param sData
	 * @return
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public boolean selectQuickContactAnthemAssociateYes() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Anthem Associate", "QUickContact", "Drpdownquickcontact"))
						if(clickrbtnVerifiedAssociateYes()) 
							if(clickbtnSubmit())
								return true;
		return false;
	}



	public boolean selectQuickContactAnthemAssociateNo() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Anthem Associate", "QUickContact", "Drpdownquickcontact"))
						if(clickrbtnVerifiedAssociateNo()) 
							if(clickbtnSubmit())
								return true;
		return false;
	}
	
	/**
	 * For Reletive /Friend
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public boolean selectQuickContactFriendReletive() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
			if(setTxtFullContactName("Alan Drewmore"))
				if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Friend/Relative", "QuickContact", "Drpdownquickcontact - Friend/Relative"))
					if(clickbtnSubmit())
						return true;
		return false;
	}

	/**
	 * For Parent
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean selectQuickContactParent() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(this.selectDropDownCommunicationChannel("Parent"))
						if(clickbtnSubmit())
							return true;
		return false;
	}
	
	/**
	 * For Guardian Representative 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean selectQuickContactGuardian_Representative() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Guardian/Representative", "QuickContact", "Drpdownquickcontact - Guardian/Representative"))
						if(clickbtnSubmit())
							return true;
		return false;
	}


	/**
	 * For Custodian Parent 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean selectQuickContactCustodialParent() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					Thread.sleep(4000);
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Custodial Parent", "QuickContact", "Drpdownquickcontact - Custodial Parent"))
						if(clickbtnSubmit())
							return true;
		return false;
	}

	@FindBy(id="IsVerReqLawAdd")
	private WebElement chkbxVerballyRequestAddressLaw;
	@FindBy(id="IsVerReqLawPhone")
	private WebElement chkbxVerballyRequestNumberLaw;

	public SeleniumUtilities getUtils() {
		return utils;
	}

	public WebElement getChkbxVerballyRequestAddressLaw() {
		return chkbxVerballyRequestAddressLaw;
	}

	public WebElement getChkbxVerballyRequestNumberLaw() {
		return chkbxVerballyRequestNumberLaw;
	}

	/**
	 * For Attorney 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean selectQuickContactCustodialAttorney() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Attorney", "QUickContact", "Drpdownquickcontact"))
						if(this.headerMustCapture.getText().trim().equalsIgnoreCase("Must capture:"))
							if(this.setTxtNameofFirm("Dallays Paralegal"))
							{
								JavascriptExecutor jse=(JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("arguments[0].scrollIntoView(true);", chkbxVerballyRequestAddressLaw);
								if(this.clickchckBoxesVerballyRequestAddressLawFirm())
									if(this.clickchckBoxesVerballyRequestNumberLawFirm())
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}

	/**
	 * Group 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean selectQuickContactCustodialGroup() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Group", "QuickContact", "Drpdownquickcontact - Group"))
						if(utils.selectDropDownbyVisibleString(drpDownGroupAdmins, "Contact not on file", "QuickContact", "drpDownGroupAdmins"))
							if(this.clickchckGrpHealthPlan())
								if(this.clickchckGroupNo())
									if(this.clickchckGroupName())
										if(clickbtnSubmit())
											return true;
		return false;
	}

	/**
	 * Group Business Associate 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public boolean selectQuickContactCustodialGroupBusinessAssociate() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(this.contactRoleTable, "Group Business Associate", "SelectAssociatedContact", "Dropdown contactrole"))
						if(this.setTxtCompany_AgencyName("Bains and Company"))
						{
							JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
						jse.executeScript("scroll(0, 250);");
						if(this.clickchckGroupPhoneNo())
							if(this.setTxtGroupBusinessAssociatePhoneNo("8884526266"))
								if(this.clickchckGroupName())
									if(this.clickchckGroupNo())
									{
										jse.executeScript("scroll(0, 250);");
										if(clickbtnSubmit())
											return true;
										}
									}
		return false;
	}
	
	/**
	 * Custodial Provider
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public boolean selectQuickContactCustodialProvider() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(this.contactRoleTable, "Provider", "SelectAssociatedContact", "Dropdown - Provider"))
						if(this.setTxtProvidersName("Marshall Ericson"))
							if(this.setTxtProvidersNumber("8884526266"))
								if(clickbtnSubmit())
									return true;
		return false;
	}

	/**
	 * Contact Third Party Custodian for Third Party Administrator 
	 * 	
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean selectQuickContactCustodialThirdPartyAdmin() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(this.drpDownQuickContactType, "Third Party Administrator", "SelectAssociatedContact", "Dropdown - Third Party Administrator"))
						if(this.setTxtThirdPartyAdminName("KPMG Auditing"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 500);");
								if(this.clickchckGroupNo())
									if(this.clickchckGroupName())
									{
										jse.executeScript("scroll(0, 500);");
										if(clickbtnSubmit())
											return true;
										}
							}
		return false;
	}



	@FindBy(id="AssociatedContactType")
	private WebElement contactRoleTable;
	/*
	 * Insurance carriers 
	 */


	public boolean selectQuickContactCustodialInsuranceCarriersGovtRep() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(utils.selectDropDownbyVisibleString(this.contactRoleTable, "Insurance Carriers", "SelectAssociatedContact", "Dropdown contactrole"))
					if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
						if(this.selectDropDownContactRole("Government Rep"))					
							if(setTxtFullContactName("Alan Drewmore"))
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
		return false;
	}





	public boolean selectQuickContactCustodialInsuranceCarriersDeptOfHSS() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("Department of HHS"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}


	public boolean selectQuickContactCustodialInsuranceCarriersWorkersComp() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("Worker's Comp"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
						
		return false;
	}


	public boolean selectQuickContactCustodialInsuranceCarriersFederalStaeLocal() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("Federal/State/Local Gov't"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}



	public boolean selectQuickContactCustodialInsuranceCarriersHumanResource() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("Human Resources"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}

	public boolean selectQuickContactCustodialInsuranceCarriersSSAdminBehalfofMem() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("SS Admin on behalf of a member"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
										}
		return false;
	}

	public boolean selectQuickContactCustodialInsuranceCarriersPlantBenefitRep() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("Plant Benefit Rep (Non URMBT)"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}




	public boolean selectQuickContactCustodialInsuranceCarriersUnionBenefitRep() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("Union Benefit Rep (Non URMBT)"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}								
		return false;
	}


	@FindBy(id="AssociatedContactType")
	private WebElement quickContactType;

	public boolean selectQuickContactCustodialInsuranceCarriersEmployerRep() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(utils.selectDropDownbyVisibleString(this.quickContactType, "Insurance Carriers", "SelectAssociatedContact", "quickContactTypen dropdown"))
					if(this.selectDropDownContactRole("Employer Reps (incl. URMBT)"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}

	public boolean selectQuickContactCustodialInsuranceCarriersPlanBenefitRep() throws InterruptedException, AWTException
	{

		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("SS Admin on behalf of a member"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}

	public boolean selectQuickContactCustodialInsuranceCarriersOtherHealthInsurance() throws InterruptedException, AWTException
	{

		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("Other Health Insurance"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}

	public boolean selectQuickContactCustodialInsuranceCarriersLongTermdisability() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.selectDropDownContactRole("Long Term Disability"))
						if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}
	
	public boolean selectQuickContactCustodialInsuranceCarriersAutoInsurance() throws InterruptedException, AWTException
	{

		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(setTxtFullContactName("Alan Drewmore"))
					if(utils.selectDropDownbyVisibleString(drpDownQuickContactType, "Insurance Carriers", "QuickContact", "Drpdownquickcontact - Insurance Carriers"))
						if(utils.selectDropDownbyVisibleString(drpDownAssociatedContactRole, "Auto Insurance", "QuickContact", "drpDownAssociatedContactRole"))
							if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
								if(setTxtFullContactName("Alan Drewmore"))
								{
									JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
									jse.executeScript("scroll(0, 250);");
									if(this.clickrbtnVerbalRequestPhone())
										if(this.setTxtInsuranceTaxID("8884526266"))
											if(clickbtnSubmit())
												return true;
								}
		return false;
	}



	public boolean selectQuickContactCustodialInsuranceCarriersMedicatedStaff() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
						if(this.selectDropDownContactRole("CMS/Medicare/Medicaid Staff"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceTaxID("8884526266"))
										if(clickbtnSubmit())
											return true;
							}
		return false;
	}



	public boolean setTxtInsuranceSCIFID(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.txtInsuranceSCIFID, sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");

	}
	public boolean setTxtInsurancePlanID(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.txtInsurancPlanID, sFullName, "Select Associate Contact", "Text Box Full  Firm Name ");

	}
	@FindBy(xpath="//input[@id='SCCFNumber']")
	WebElement txtInsuranceSCIFID;
	//input[@id='PlanID']

	@FindBy(xpath="//input[@id='PlanID']")
	WebElement txtInsurancPlanID;


	public boolean selectQuickContactCustodialInsuranceCarriersBCBSAPlan() throws InterruptedException, AWTException
	{
		if(this.validateHeader())
			if(clickrbtnQuickContact())
				if(selectDropDownQuickContactRoleUsingClick(9))
					if(this.setTxtNameInsurancePlan("Aviava Life Insurance"))
						if(this.selectDropDownContactRole("BCBSA Plan"))
							if(setTxtFullContactName("Alan Drewmore"))
							{
								JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
								jse.executeScript("scroll(0, 250);");
								if(this.clickrbtnVerbalRequestPhone())
									if(this.setTxtInsuranceSCIFID("4526214"))
											if(clickbtnSubmit())
												return true;
											}
		return false;
	}


	/**
	 * Select Member of contact and Submit the result 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean selectMemberonContractSubmit(String[] args) throws InterruptedException
	{
		if(this.validateHeader())
			if(this.clickrbtnMemberonContact())
				if(this.selectMemberbyFirstName(args))
					if(this.clickbtnSubmit())
						return true;
		return false;
	}



	/**
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectMemberbyFirstName(String[] args) throws InterruptedException
	{


		Thread.sleep(5000);
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=getsearchResultbyColumn("First Name");

		if(this.clickselectColumnRadioButton(utils.returnindexofelemntinanarray(firstnameColumn, args[0])))
			return true;
		else 
			err.logcommonMethodError("Phone call Search member", "selectMemberbyFirstName");
		return false;

	}
	public boolean clickselectColumnRadioButton (int row){
		ArrayList<WebElement> select = utils.getcolumnWebelemntFromTable(this.gettblSearchresult(),"input" );
		if(utils.clickAnelemnt(select.get(row),"Select Associate Contact","resutlt table radio")){
			/*	row+=11;
			String rBtn="/*[contains(@name,'l"+row+"$ppySelected')]";
			Driver.pgDriver.findElement(By.xpath(rBtn))*/;
			return true;
		}
		else 
			return false;
	}

	public boolean exitInteraction() throws InterruptedException{
		if(this.validateHeader())
			if(this.clickbtnOtherActions())
				if(this.clicklinkexitInteraction())	
					return true;
			return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:enterContactFullName
	 * #Description:This method enters the Contact Full Name for the Quick Contact Type
	 * #Argument:ContactFullName
	 * Type:Textbox
	 */
	public boolean enterContactFullName(String[] sFullName)
	{
		return utils.enterTextinAnelemnt(this.getTxtBoxContactFullName(), sFullName[0], "Select Associate Contact", "Text Box Full  Name");

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:chooseQuickContactType
	 * #Description:This method selects the Quick Contact Type value from the dropdown listed.
	 * #Argument:QuickContactType and BrokerFirm
	 * Type:Dropdown
	 * Keys:Agent/Broker#Anthem Associate#Attorney#Custodial Parent#Friend/Relative#Group#Group Business Associate#Guardian/Representative#Insurance Carriers#Parent#Provider#Third Party Administrator#Other
	 */
	public boolean chooseQuickContactType(String args[]){
			return utils.selectDropDownbyVisibleString(this.drpDownQuickContactType, args[0].replaceAll("-or-","/"), "SelectAssociatedContact", "Quick Contact Type Dropdown");
	}

	@FindBy(id="IsBrokerTaxIDVerified")
	WebElement brokerTaxIDVerifiedChkbox;
	/*
	 * @SCU
	 * #CommonMethodWithArgument:selectBrokerOrFirmName
	 * #Description:This method selects the Broker Or FirmName value from the dropdown listed.
	 * #Argument:BrokerOrFirmName
	 * Type:Dropdown
	 * Keys:Contact not on file
	 */
	public boolean selectBrokerOrFirmName(String args[]){
			utils.scrolltomiddle();
			return utils.selectDropDownbyVisibleString(this.drpDownbrkrFirmname, args[0], "SelectAssociatedContact", " Broker Or FirmName Dropdown");
	}


	//Regression Fix


	public boolean selectDropDownQuickContactRoleForCustodial(String iDropdownSelect) throws InterruptedException, AWTException
	{
		return utils.selectDropDownbyVisibleString(this.drpdownquickContactType, iDropdownSelect, "SelectAssociatedContact", "Custo Dial");
	}


	//Sprint 4.1

	@FindBy(xpath="//span[text()='HIPAA Verification']")
	WebElement labelHippaVerification;

	@FindBy(id="IsMemberIDVerified")
	WebElement chckBxMemberId;

	@FindBy(id="IsMemberNameVerified")
	WebElement chckBxName;

	@FindBy(id="IsDateOfBirthVerified")
	WebElement chckBxDOB;

	@FindBy(id="IsPhoneNumberVerified")
	WebElement chckBxPhone;

	@FindBy(xpath="//*[@data-test-id='201504281304350457121267']")
	WebElement labelVerificationID;

	@FindBy(xpath="//*[@data-test-id='201504281304350458122377']")
	WebElement labelVerificationDOB;

	@FindBy(xpath="//*[@data-test-id='2015042815070504775471']")
	WebElement labelVerificationphone;

	@FindBy(xpath="//*[@data-test-id='2015042812583202823964']")
	WebElement labelVerificationfullname;

	@FindBy(xpath="//*[text()='Submit']")
	WebElement btnVerificationSubmit;



	public boolean verifySelectAssociateContractIsDisplayedOnSElectingNoForMemberContract()
	{
			return utils.validateHeader(sHeaderSearchForMember, "Select Associated Contact");
	}


	public boolean verifyHIPAAVerificationIsDisplayedInSelectAssociatedContact()
	{
		return !utils.isProxyWebelement(labelHippaVerification);
	}

	public boolean verifymemberID(String args[])
	{
		String memid=this.labelVerificationID.getText().toString();
		return utils.isvalueMatch_contain(memid, args[0]);
	}

	public boolean verifymemberName(String args[])
	{

		String fullname=this.labelVerificationfullname.getText().toString();
		return utils.isvalueMatch_contain(fullname, args[0]);
	}

	public boolean verifymemberDOB(String args[])
	{
		String memberDOB=this.labelVerificationDOB.getText().toString();
		return utils.isvalueMatch_contain(memberDOB, args[0]);
	}

	public boolean verifymemberPhone(String args[])
	{
		String memberPhone=this.labelVerificationphone.getText().toString();
		return utils.isvalueMatch_contain(memberPhone, args[0]);
	}

	public boolean ValidateDetailsPresent()
	{
		return !utils.isProxyWebelement(chckBxName);
	}

	public boolean clickchkbxVerificationMembernameverify(String[] membername) {

		if(verifymemberName(membername))
			return utils.clickAnelemnt(this.chckBxName, "SelectAssociatedContact", "Member name verify checkbox");
		return false;
	}

	public boolean clickchkbxVerificationMemberidverify(String[] memberid) {

		if(verifymemberID(memberid))
			return utils.clickAnelemnt(this.chckBxMemberId, "SelectAssociatedContact", "Member id verify checkbox");
		return false;


	}

	public boolean clickchkbxVerificationMemberDOB (String[] DOB){
		if(verifymemberDOB(DOB))
			return utils.clickAnelemnt(this.chckBxDOB, "SelectAssociatedContact", "Member DOB verify checkbox");
		return false;

	}

	public boolean clickchkbxVerificationMemberphone (String[] phone){
		if(verifymemberPhone(phone))
			return utils.clickAnelemnt(this.chckBxPhone, "SelectAssociatedContact", "Member {hone verify checkbox");
		return false;

	}



	public boolean selectHIPAAverificationDetails(String [] args)
	{
		utils.waitforpageload();
		if(this.ValidateDetailsPresent())
		{
			for(int i=0;i<args.length;i++)
			{
				if(args[i].contains("name"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if( this.clickchkbxVerificationMembernameverify(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("id"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if(this.clickchkbxVerificationMemberidverify(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("dob"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if( this.clickchkbxVerificationMemberDOB(s))
					{

						if(i==args.length-1) 
						{
							if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("phone"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberphone(s))
					{
						if(i==args.length-1)
						{
							if(utils.clickAnelemnt(btnVerificationSubmit, "SelectAssociatedContact", "submit button "))
								return true;
						}
						continue;
					}
					else
						break;
				}

				else 
				{
					err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
				}

			}


			err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
			return false;
		}


		err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
		return false;

	}

	public boolean selectMemberonContract()
	{
		return utils.clickAnelemnt(rdBtnMemberContact, "SelectAssociatedContact", "Member On Contract Rdo Btn");
	}

	public boolean	verifyBrokerDetails(){
			if(utils.clickAnelemnt(chckBxBrokerAddress, "Select AssociatedContact","FirstPhone"))
				if(utils.clickAnelemnt(chckBxBrokerPhone, "Select AssociatedContact","FirstAddress"))
					return true;
		return false;


	}
	
	//Sprint 5.1
	
	@FindBy(id="IsContactNameVerified")
	WebElement chckBxContactFullName;
	
	public boolean validateAndClickContactFullNameTextBox()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(chckBxContactFullName, "SelectAssociatedContact", "Contcat Full Name check box");
	}
	
	public boolean	selectBrokerID(){
		utils.waitForElementToBeVisible(chkboxBrokerID);
		return utils.clickAnelemnt(chkboxBrokerID, "Select AssociatedContact","BrokerID");
	}
	


}





