package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class Administration{

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget0Ifr")
	WebElement Iframeelement;

	public Administration(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(xpath="//img[contains(@alt,'Loading..')]")
	private WebElement LoadingIcon;

	@FindBy(xpath="//div[@class='tStrCntr']//ul[contains(@class,'headerTabsList')]")
	private WebElement adminTabHdr;

	@FindBy(xpath="//a[@tabtitle='Manager/Skill Admin']")
	private WebElement managerSkillAdmHdr;

	@FindBy(xpath="//div[@class='header-content']//span[@role='heading']")
	private WebElement manageSearchAddUpdtHdr;

	/**This method allows the user to click on Manager Skill Admin tab
	 * 
	 * @return
	 */
	public boolean clickManagerSkillAdminTab(){
		utils.waitforpageload();
		if(this.managerSkillAdmHdr.isDisplayed()){
			utils.clickAnelemnt(this.managerSkillAdmHdr, "Administration", "Manager/Skill Admin");
			return utils.validateHeader(this.manageSearchAddUpdtHdr, "Manage Search/Add/Update");
		}
		return false;
	}


	@FindBy(xpath="//span[text()='Search By Manager']")
	private WebElement searchByManagerHdr;

	@FindBy(id="ManagerIDSkillSearch")
	private WebElement managerUserIdTxtBox;

	@FindBy(id="ManagerNameSkillSearch")
	private WebElement managerNameTxtBox;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Search']")
	private WebElement searchByManagerBtn;

	@FindBy(xpath="//table[@pl_prop='AdminSkillResultSet.pxResults']")
	private WebElement resultsTableAdmin;

	@FindBy(xpath="//table[@pl_prop='MgrSkillData.pxResults']")
	private WebElement resultsTable;

	@FindBy(xpath="//button[@name='ManagerSkillUpdate_D_SkillAdmin_5'][@disabled]")
	private WebElement updateBtnDisabled;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Update']")
	private WebElement updateBtn;

	@FindBy(xpath="//a[@data-test-id='20160518003511003097868']")
	private WebElement WorkBasket;

	@FindBy(id="PolicyState")
	private WebElement PolicyState;

	@FindBy(xpath="//*[@name='ManagerSkillSearch_D_SkillAdmin_11']")
	private WebElement searchBtn;

	@FindBy(xpath="//button[@name='ManagerSkillUpdate_D_SkillAdmin_5'][@disabled]")
	WebElement ManagerSkillUpdateDisabled;

	/**This method allows the user to search by Manager UserID
	 * 
	 * @param mID
	 * @return
	 */
	public boolean searchByManagerUserId(String[] mID){
		if(utils.clickAnelemnt(searchByManagerHdr, "Administration", "searchByManagerHdr"))
			if(utils.enterTextinAnelemnt(managerUserIdTxtBox, mID[0], "Administration", "Manager User ID")) {
				this.managerUserIdTxtBox.sendKeys(Keys.TAB);
				List<WebElement> searchbtn = Driver.pgDriver.findElements(By.xpath("//*[@class='pzbtn-mid'][text()='Search']"));
				searchbtn.get(1).click();
			}
		utils.waitforpageload();
		return !utils.isProxyWebelement(ManagerSkillUpdateDisabled);
	}

	/**This method allows the user to search by Manager Name
	 * 
	 * @param mName
	 * @return
	 */
	public boolean searchByManagerName(String[] mName){

		if(utils.clickAnelemnt(searchByManagerHdr, "Administration", "Search By Manager"))
			if(utils.enterTextinAnelemnt(managerNameTxtBox, mName[0], "Administration", "Manager Name")) {
				List<WebElement> searchbtn = Driver.pgDriver.findElements(By.xpath("//*[@class='pzbtn-mid'][text()='Search']"));
				searchbtn.get(1).click();
			}
		return !utils.isProxyWebelement(updateBtnDisabled);
	}

	/**This method validates the column headers which is displayed upon search
	 * 
	 * @param input
	 * @return
	 */
	public boolean validateColHeaders(String[] input){
		ArrayList<String> headerrow = new ArrayList<String>();
		ArrayList<String> invalidColHdr = new ArrayList<String>();
		headerrow=utils.getheaderrowFromTable(resultsTable);

		ArrayList<String> colList = new ArrayList<String>(Arrays.asList(input));
		for(String s:colList){
			if(headerrow.contains(s)){
				System.out.println("Column header is present"+s);
			}else{
				System.out.println("Column header is not present"+s);
				invalidColHdr.add(s);
			}
		}
		if(invalidColHdr.size()>0){
			err.logError("Administration", "Invalid entries were found in dataset: Column Header");
			return false;
		}
		return true;
	}


	/**This method allows the user to search by Manager skill on Workbasket and State attributes
	 * 
	 * @param args
	 * @return
	 */
	public boolean searchbyManagerSkill(String[] args){
		if(utils.selectDropDownbyVisibleString(this.WorkBasket, args[0], "Administration", "WorkBasket"))
			if(utils.selectDropDownbyVisibleString(this.PolicyState, args[1], "Administration", "Policy State")) {
				List<WebElement> searchbtn = Driver.pgDriver.findElements(By.xpath("//*[@class='pzbtn-mid'][text()='Search']"));
				searchbtn.get(0).click();
			}
		utils.waitforpageload();
		return !utils.isProxyWebelement(updateBtn);
	}

	/**This method validates if search criteria rendered in results is valid
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateSearchResults(String[] args) throws InterruptedException{
		return utils.clickontablerowbasedonvalues(resultsTable,args);
	}

	@FindBy(id="ManagerID")
	private WebElement auManagerID;

	@FindBy(id="EffectiveDt")
	private WebElement auEffectiveDt;

	/**This method performs Update depending on the Manager User ID and Effective Date
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean performAddUpdateManagerSkill(String[] args) throws InterruptedException{
		if(utils.enterTextinAnelemnt(this.auManagerID, args[0], "Administration", "Manager User ID"))
			if(utils.enterTextinAnelemnt(this.auEffectiveDt, args[1], "Administration", "Effective Date"))
				return utils.clickAnelemnt(searchBtn, "Administration", "Search");
		return false;

	}

	@FindBy(xpath="//label[text()='Manage Alerts']")
	private WebElement manageAlertTab;

	/**This method allows the user to click and navigate to Manage Alerts section
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickManageAlertsTab() throws InterruptedException{
		return utils.clickAnelemnt(this.manageAlertTab, "Administration", "Manage	Alerts");
	}

	@FindBy(id="ClaimsSpecialty")
	private WebElement ClaimsSpecialtyDrpDown;

	/**This method verifies values displayed in Claims speciality dropdown
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyValueInClaimsSpeciality(String args[]){
		try{
			ArrayList<String> values=new ArrayList<String>();
			for(String value:args)
			{
				value=value.toLowerCase().trim();
				values.add(value);
			}
			return utils.checkvaluesinDropDown(this.ClaimsSpecialtyDrpDown,values);
		}catch(Exception e){
			return false;
		}
	}

	@FindBy(xpath="//label[text()='Operator Maintenance']")
	private WebElement operatorMaintenanceTab;

	/**This method allows the user to click on Operator Maintenance tab
	 * 
	 * @return
	 */
	public boolean clickOperatorMaintenanceTab(){
		action.moveToElement(operatorMaintenanceTab);
		return utils.clickAnelemnt(this.operatorMaintenanceTab, "Administration", "Operator Maintenance");
	}
	@FindBy(id="OperatorToUpdate")
	private WebElement operatorToUpdateTxtBox;

	/**This method allows the user to enter the Operator details to be updated in Operator Maintenance tab
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectOperatorToUpdate(String args[]){
		if(utils.enterTextinAnelemnt(this.operatorToUpdateTxtBox, args[0], "Administration", "OperatorToUpdate")) {
			operatorToUpdateTxtBox.sendKeys(Keys.TAB);
			return true;
		}
		return false;
	}

	@FindBy(xpath="//div[contains(text(),'ACA Claims')]")
	WebElement wrkgrpACAClaims;

	@FindBy(xpath="//div[contains(text(),'Non ACA/Local Claims')]")
	WebElement wrkgrpNonACAClaims;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Remove All']")
	WebElement removeAllBtn;

	@FindBy(xpath="//table[@pl_prop='.AvailableSkills'][@class='gridTable ']//tr/td//span")
	List<WebElement> availableSkills;

	/**This method verifies the skill entered by user is listed in the workbasket skill in Operator Maintenance
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifySkillInWorkbasket(String args[]){
		try{
			for(WebElement e:availableSkills){
				if(e.getText().trim().equalsIgnoreCase(args[0])){
					blogger.loginfo("Actual Value matched : "+e.getText().trim()+" with the expected value "+args[0]);
					return true;
				}else{
					blogger.loginfo("Text didnt match in UI:"+e.getText().trim()+" With the expected "+args[0]);
					return false;
				}
			}
		}catch(Exception e){
			err.logError("Administration", "verifySkillInWorkbasket failed");
			return false;
		}
		return false;
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()=' Export to Excel']")
	private WebElement btnExportToExcel;

	/**This method verifies Export to Excel button being displayed when search results are rendered
	 * 
	 * @return
	 */
	public boolean verifyExportToExcel(){
		return !utils.isProxyWebelement(btnExportToExcel);
	}

	/**This method verifies Export to Excel button is not displayed when search results are not rendered or Is Empty
	 * 
	 * @return
	 */
	public boolean verifyNoExportToExcel(){
		return utils.isProxyWebelement(btnExportToExcel);
	}

	/**This method allows the user to select and save the excel to be downloaded
	 * 
	 * @return
	 */
	public boolean openExcelDownload(){	
		err.logError("Administration", "openExcelDownload failed");
		return false;

	}

	/**This method validates the fields and data displayed in excelsheet matches with the search results data queried or rendered upon
	 * 
	 * @return
	 */
	public boolean validateExcelDownloadData(){
		err.logError("Administration", "validateExcelDownloadData failed");
		return false;
	}


	@FindBy(xpath="//a[@tabtitle='My Workbaskets']")
	private WebElement myWorkBasketTab;

	/**This functionality verifies 'My Workbaskets' is not displayed for CSR users in the Home page
	 * 
	 * @return
	 */
	public boolean validateMyWorkBasketIsNotDisplayed(){
		return utils.isProxyWebelement(myWorkBasketTab);
	}

	/**This functionality verifies 'My Workbaskets' is displayed for CSR Manager user and clicks on the same in the Home page
	 * 
	 * @return
	 */
	public boolean validateMyWorkBasketIsDisplayed(){
		return !utils.isProxyWebelement(myWorkBasketTab);
	}

	@FindBy(id="PropertyForParameters")
	WebElement viewQueueDrpdown;

	/**This functionality clicks and verifies the value displayed in 'View Queue dropdown'under MyWorkbasket
	 * 
	 * @param args
	 * @return
	 */
	public boolean checkValueInViewQueueDrpdown(String args[]){
		if(utils.clickAnelemnt(this.viewQueueDrpdown, "Administration", "View Queue Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			return utils.checkvaluesinDropDown(this.viewQueueDrpdown,dropdownValues);
		}
		return false;
	}

	@FindBy(xpath="//select[@id='pyWorkBasketName']")
	List<WebElement> AddWorkBasket;

	/**This method verifies values displayed in Workbasket dropdown in Manage Skills page
	 * 
	 * @param args
	 * @return
	 */


	public boolean verifyValueInWorkBasket(String args[]){
		if(utils.clickAnelemnt(this.WorkBasket, "Administration", "WorkBasket Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			for(WebElement e:AddWorkBasket){
				return utils.checkvaluesinDropDown(e, dropdownValues);
			}
		}
		return false;
	}

	@FindBy(id="")
	private WebElement GrievanceAndAppealsSkillsDrpdown;

	/**This method verifies values displayed in Grievance And Appeals Skills dropdown in Manage Skills page
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyValueInGrievanceAndAppealsSkills(String args[]){
		if(utils.clickAnelemnt(this.GrievanceAndAppealsSkillsDrpdown, "Administration", "GrievanceAndAppealsSkills Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			return utils.checkvaluesinDropDown(this.GrievanceAndAppealsSkillsDrpdown,dropdownValues);
		}
		return false;
	}

	/**This method allows the user to validate workbasket for an Operator to hold Grievance and Appeals Standard and Expedited workbasket in Home page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateWorkbasketForGAUser(String args[]){
		if(utils.clickAnelemnt(this.viewQueueDrpdown, "Administration", "View Queue Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			return utils.checkvaluesinDropDown(this.viewQueueDrpdown,dropdownValues);
		}
		return false;
	}

	@FindBy(xpath="//div[@data-test-id='20170810161920030575337']")
	private List<WebElement> currentRoleOrProfile_Workgroup;

	/**This functionality verifies the CurrentRoleOrProfile value displayed in Operator Maintenance
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyCurrentRoleOrProfile(String args[]){
		return utils.isvalueMatch_contain(this.currentRoleOrProfile_Workgroup.get(0).getText().trim(),args[0]);	
	}

	/**This functionality clicks and verifies CurrentWorkGroup value displayed in Operator Maintenance
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyCurrentWorkGroup(String args[]){
		return utils.isvalueMatch_contain(this.currentRoleOrProfile_Workgroup.get(1).getText().trim(),args[0]);	
	}

	@FindBy(id="pyWorkBasketName")
	private List<WebElement> selectWorkBasket;

	/**This functionality clicks on adding workbasket and verifies GA Standard and GA Expedited workbaskets displayed in Operator Maintenance
	 * 
	 * @return
	 */
	public boolean verifyGAWorkbasketsInOperatorMaintenance(){
		String GAWorkbasketsInOprMaint[]= {"Grievance and Appeals Expedited","Grievance and Appeals Standard"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(GAWorkbasketsInOprMaint));
		action.moveToElement(this.selectWorkBasket.get(0)).click().build().perform();
		return utils.checkvaluesinDropDown(this.selectWorkBasket.get(0), al);	
	}

	@FindBy(xpath="//table[@pl_prop='.SelectedSkills']//tr//td//span")
	List<WebElement> selectedSkills;


	@FindBy(id="FundingType")
	private WebElement FundingTypeDropdown;

	/**This functionality verifies that the Funding type drop down is displayed in the Operator Maintenance section
	 * 
	 * @return
	 */
	public boolean verifyFundingTypeDropdownIsDisplayed(){
		return utils.clickAnelemnt(this.FundingTypeDropdown, "Administration", "Funding Type Dropdown");
	}

	/**This functionality selects the value given by the user in the Funding type drop down in the Operator Maintenance section
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectFundingTypeDropdown(String args[]){
		if(utils.clickAnelemnt(this.FundingTypeDropdown, "Administration", "Funding Type Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			if(utils.checkvaluesinDropDown(this.FundingTypeDropdown,dropdownValues))
				return utils.selectDropDownbyVisibleString(this.FundingTypeDropdown, args[0], "Administration", "Funding Type Dropdown");
		}
		return false;
	}

	@FindBy(id="GandAType")
	private WebElement GandATypeDropdown;

	/**This functionality verifies that the G and A type drop down is displayed in the Operator Maintenance section
	 * 
	 * @return
	 */
	public boolean verifyGandATypeDropdownIsDisplayed(){
		return utils.clickAnelemnt(this.GandATypeDropdown, "Administration", "GandA Type Dropdown");
	}

	/**This functionality selects the value given by the user in the G and A type drop down in the Operator Maintenance section
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectGandATypeDropdown(String args[]){

		if(utils.clickAnelemnt(this.GandATypeDropdown, "Administration", "GandA Type Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			if(utils.checkvaluesinDropDown(this.GandATypeDropdown,dropdownValues))
				return utils.selectDropDownbyVisibleString(this.GandATypeDropdown, args[0], "Administration", "GandA Type Dropdown");
		}
		return false;

	}
	@FindBy(id="GAGroup")
	private WebElement GroupType;

	/**This functionality selects the value given by the user in the Group type drop down in the Operator Maintenance section
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectGroupTypeDropdown(String args[]){

		if(utils.clickAnelemnt(this.GroupType, "Administration", "Group Type Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			if(utils.checkvaluesinDropDown(this.GroupType,dropdownValues))
				return utils.selectDropDownbyVisibleString(this.GroupType, args[0], "Administration", "Group Type Dropdown");
		}
		return false;
	}

	@FindBy(id="GALineofBusiness")
	private WebElement LOBType;

	/**This functionality verifies that the LOB type drop down is displayed in the Operator Maintenance section
	 * 
	 * @return
	 */
	public boolean verifyLineOfBusinessTypeDropdownIsDisplayed(){
		return utils.clickAnelemnt(this.LOBType, "Administration", "LOB Type Dropdown");
	}

	/**This functionality selects the value given by the user in the LOB type drop down in the Operator Maintenance section
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectLOBTypeDropdown(String args[]){
		try{
			utils.clickAnelemnt(this.LOBType, "Administration", "LOB Type Dropdown");
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			utils.checkvaluesinDropDown(this.LOBType,dropdownValues);
			return utils.selectDropDownbyVisibleString(this.LOBType, args[0], "Administration", "LOB Type Dropdown");
		}catch(Exception e){
			err.logError("Value didnt matched with input:"+args[0]+" in LOB Type Dropdown");
			return false;
		}

	}
	@FindBy(id="BehaviorHS")
	private WebElement BehavioralHealthSkills;

	/**This functionality selects the value given by the user in the Behavioral Health type drop down in the Operator Maintenance section
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectBehavioralHealthTypeDropdown(String args[]){
		try{
			utils.clickAnelemnt(this.BehavioralHealthSkills, "Administration", "Behavioral Health Skills Dropdown");
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			utils.checkvaluesinDropDown(this.BehavioralHealthSkills,dropdownValues);
			return utils.selectDropDownbyVisibleString(this.BehavioralHealthSkills, args[0], "Administration", "Behavioral Health Skills Dropdown");
		}catch(Exception e){
			err.logError("Value didnt matched with input:"+args[0]+" in Behavioral Health Skills Dropdown");
			return false;
		}

	}

	@FindBy(id="GandAPharmacySkill")
	WebElement drpDownPharmacySkills;

	/**This functionality verifies that the Pharmacy skill drop down is displayed in the Work basket
	 * 
	 * @return
	 */
	public boolean verifyPharmacySkillsDropDownIsDisplayed()
	{
		return !utils.isProxyWebelement(drpDownPharmacySkills);
	}

	/**This functionality selects the input given by the user in Pharmacy skill drop down in the Work basket
	 * 
	 * @param pharskills
	 * @return
	 */
	public boolean selectPharmacySkillDropDown(String[] pharskills)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownPharmacySkills, pharskills[0], "Administration", "Pharmacy Skill drop down is selected");
	}

	/**This method selects values displayed in Workbasket dropdown in Manage Skills page
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectValueInWorkBasket(String[] args)
	{
		return utils.selectDropDownbyVisibleString(WorkBasket, args[0], "Administration", "Selects Work Basket");
	}

	/**This functionality verifies that the G and A type drop down is Not displayed in the Manage skill admin section
	 * 
	 * @return
	 */
	public boolean verifyGandATypeDropdownIsNotDisplayed(){
		return utils.isProxyWebelement(GandATypeDropdown);
	}

	/**This functionality verifies that the Group drop down is Not displayed in the Manage skill admin section
	 * 
	 * @return
	 */
	public boolean verifyGroupDropdownIsNotDisplayed(){
		return utils.isProxyWebelement(GroupType);
	}

	/**This functionality verifies that the Funding type drop down is Not displayed in the Manage skill admin section
	 * 
	 * @return
	 */
	public boolean verifyFundingTypeDropdownIsNotDisplayed(){
		return utils.isProxyWebelement(FundingTypeDropdown);
	}

	/**This functionality verifies that the Pharmacy Skills drop down is Not displayed in the Manage skill admin section
	 * 
	 * @return
	 */
	public boolean verifyPharmacySkillsDropdownIsNotDisplayed()
	{
		return utils.isProxyWebelement(drpDownPharmacySkills);
	}

	/**This functionality verifies that the GrouLine Of Business drop down is Not displayed in the Manage skill admin section
	 * 
	 * @return
	 */
	public boolean verifyLineOfBusinessDropdownIsNotDisplayed()
	{
		return utils.isProxyWebelement(LOBType);
	}

	/**This functionality verifies that the Behavioral Health drop down is Not displayed in the Manage skill admin section
	 * 
	 * @return
	 */
	public boolean verifyBehavioralHealthDropdownIsNotDisplayed()
	{
		return utils.isProxyWebelement(BehavioralHealthSkills);
	}

	@FindBy(id="WorkBasket")
	WebElement drpDownWorkBasket;

	@FindBy(id="GALineofBusiness")
	WebElement drpDownLineOfBusiness;

	/**This functionality verifies that Small group and Large group enrollment and billing review workbasket is displayed in the workbasket drop down in the Manage/Skill admin page
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifySGAndLGEnrollmentAndBillingReviewWBisDisplayedInWBDropdown(String[] args)
	{
		ArrayList<String> ar1 = new ArrayList<String>();
		ar1.add(args[0]);
		return utils.checkvaluesinDropDown(drpDownWorkBasket, ar1 );
	}

	/**This functionality verifies that Small group and Large group enrollment and billing urgent workbasket is displayed in the workbasket drop down in the Manage/Skill admin page
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifySGAndLGEnrollmentAndBillingUrgentWBisDisplayedInWBDropdown(String[] args)
	{
		ArrayList<String> ar2 = new ArrayList<String>();
		ar2.add(args[0]);
		return utils.checkvaluesinDropDown(drpDownWorkBasket, ar2 );
	}

	/**This functionality verifies that E and B Small group skill is displayed in the LOB type drop down in the Manage/Skill admin page
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyEAndBSGSkillIsDisplayedInLineOfBusinessDropdown(String[] args)
	{
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(args[0]);
		return utils.checkvaluesinDropDown(drpDownLineOfBusiness, ar );

	}

	@FindBy(id="LargeGroupSkills")
	WebElement drpDownLargeGroupSkills;

	/**This method verifies values displayed in Large Group skills dropdown
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyValueInLargeGroupSkills(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add(args[0]);
		return utils.checkvaluesinDropDown(drpDownLargeGroupSkills, al);
	}


	@FindBy(id="PaymentTypeSkill")
	WebElement drpDownPaymentTypeSkills;

	/**This method verifies the payment type skills dropdown and the values
	 * 
	 * @param args
	 * @return
	 */

	public boolean validateValueInPaymentTypeSkillsDropdown(String[] args)
	{	
		ArrayList<String> al = new ArrayList<String>();
		for(String arg : args)
		{
			al.add(arg);
		}
		return utils.checkvaluesinDropDown(drpDownPaymentTypeSkills, al);
	}

	@FindBy(xpath="//table[@pl_prop='.SelectedSkills'][@class='gridTable ']//tr")
	List<WebElement> tblSelectedSkills;

	public boolean verifySkillInSelectedList(String[] args)
	{

		try{
			System.out.println(tblSelectedSkills.size());
			for(WebElement e:tblSelectedSkills){
				System.out.println(e.getText());
				if(utils.validateLabel(e, args[0])) {
				//if(tempval.equalsIgnoreCase(args[0])){
					blogger.loginfo("Actual Value matched : "+e.getText().trim()
							+" with the expected value "+args[0]); return true;
				}else{
					blogger.loginfo("Text didnt match in UI:"+e.getText().trim()
							+" With the expected "+args[0]); continue; 
				}

			}
		}catch(Exception e){
			err.logError("Administration", "verifySkillInWorkbasket failed");
			return false;
		}
		return false;


	}

	public boolean verifySkillInAvailableList(String[] args)
	{

		try{

			List<WebElement> lists = Driver.pgDriver.findElements(By.xpath("//table[@pl_prop='.AvailableSkills'][@class='gridTable ']//tr/td//div//span"));
			for(WebElement e:lists){	
				String tempval=e.getText().trim();
				if(tempval.equalsIgnoreCase(args[0])){
					blogger.loginfo("Actual Value matched : "+e.getText().trim()+" with the expected value "+args[0]);
					return true;
				}else{
					blogger.loginfo("Text didnt match in UI:"+e.getText().trim()+" With the expected "+args[0]);
					continue;
				}
			}
		}catch(Exception e){
			err.logError("Administration", "verifySkillInWorkbasket failed");
			return false;
		}
		return false;


	}

	public boolean clickSkillInAvailableList(String[] args)
	{

		String xpath = "//table[@pl_prop='.SelectedSkills'][@class='gridTable ']//tr/td//div//span[text()='"+args[0]+"']";
		System.out.println("Xpath value: "+xpath);
		WebElement value = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.SelectedSkills'][@class='gridTable ']//tr/td//div//span[text()='"));
		if(value.isDisplayed())
		{
			value.click();
			return true;
		}else
		{
			return false;
		}
	}

	@FindBy(xpath="//*[text()='Remove All']")
	WebElement removeAll;

	@FindBy(xpath="//table[@pl_prop='.AvailableSkills']/tbody/tr/td/div/span")
	List<WebElement> allSkills;

	/**
	 * This Method used to Display all the skills available under Add/remove skills under Operator maintenance in Administration portal
	 * @return
	 * @throws InterruptedException
	 */


	public boolean displayAllSkills() throws InterruptedException
	{
		utils.clickAnelemnt(removeAll,"Administration","RemoveAll");
		utils.waitforpageload();
		int i=0;
		for(WebElement e:availableSkills){
			i++;
			System.out.println(e.getText());
		}
		System.out.println("Total Number of skills"+i);
		return true;
	}

	public boolean Addskill(String[] args) throws InterruptedException
	{
	displayAllSkills();
	String state= args[0];
	 String	tempxpath ="//table[@pl_prop='.AvailableSkills']/tbody/tr/td/div/span[text()='"+state+"']";
	 WebElement ele=Driver.pgDriver.findElement(By.xpath(tempxpath));
	 return utils.clickAnelemnt(ele, "Administration", "Add skills");
	}
	
	@FindBy(xpath="//div[text()='Save']")
	WebElement SaveButton;
	
	public boolean clickSave()
	{
		return utils.clickAnelemnt(SaveButton, "Administration", "Save");
	}

	@FindBy(id="//select[@id='pyWorkBasketName']")
	WebElement allWorkBaskets;

	@FindBy(xpath="//span/a[@title='Add item ']")
	WebElement addWorkBasket;


	@FindBy(xpath="//a[text()='+ Create New Alert']")
	WebElement CreateAlertLink;
	
	/**
	 * This Method allows user to click on create alert link present in search for alert page"
	 * 
	 */
	
	public boolean navigateTocreateAlert()
	{
		return utils.clickAnelemnt(CreateAlertLink, "Administration", "Create Alert");
	}

	
	@FindBy(id="WorkBasket")
	WebElement WorkBasketDropDown;
	
	
	
	public boolean selectValueInWorkBasketDropDown(String args[]){
		if(utils.clickAnelemnt(this.WorkBasketDropDown, "Administration", "Work basket Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			if(utils.checkvaluesinDropDown(this.WorkBasketDropDown,dropdownValues))
				return utils.selectDropDownbyVisibleString(this.WorkBasketDropDown, args[0], "Administration", "Work basket Dropdown");
		}
		return false;
	}

	
	
	@FindBy(xpath="//select[@id='GALineofBusiness']")
	WebElement LoBDropDown;
	
	@FindBy(xpath="//select[@id='GALineofBusiness']")
	List<WebElement> selectlob;
	
	
	
	public boolean verifyLOBSkillsDropDownValues(String args[]){
		if(utils.clickAnelemnt(this.LoBDropDown, "Administration", "GA LOB Dropdown")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			for(WebElement e:selectlob){
				return utils.checkvaluesinDropDown(e, dropdownValues);
			}
		}
		return false;
	}


	@FindBy(id="HCCustomerType")
	WebElement ConstituentTypeDropDown;
	
	public boolean verifyConstituenttypeDropdownIsDisplayed(){
	return	!utils.isProxyWebelement(ConstituentTypeDropDown);
	}
	
	
	public boolean selectConstituenttypeDropdown(String args[]){
		if(utils.clickAnelemnt(this.ConstituentTypeDropDown, "Administration", "Constituent Type Drop Down")) {
			ArrayList<String> dropdownValues = new ArrayList<String>(Arrays.asList(args));
			if(utils.checkvaluesinDropDown(this.ConstituentTypeDropDown,dropdownValues))
				return utils.selectDropDownbyVisibleString(this.ConstituentTypeDropDown, args[0], "Administration", "Constituent Type Drop Down");
		}
		return false;
	}


	
	
}
