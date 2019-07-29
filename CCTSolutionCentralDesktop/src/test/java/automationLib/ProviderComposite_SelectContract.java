package automationLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

import automationLib.Home;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;


public class ProviderComposite_SelectContract  extends Driver {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	WebDriverWait wait;

	public ProviderComposite_SelectContract() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		//PageFactory.initElements(Driver.getPgDriver(), this);

		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	@FindBy(xpath= "//span[contains(text(), 'Select Contract')]")
	WebElement lblSelectContractTitle;
	@FindBy(id= "$PHCMemberPolicyList$ppxResults$l1")
	WebElement trFirstrowoftable;

	@FindBy(xpath= "//*[@data-test-id='20160304053605032428479' or @data-test-id='2015021306370007097332']")//Added for Pega upgrade
	WebElement btnSubmit;
	@FindBy(xpath= "//tr[@id='$PHCMemberPolicyList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstRow;
	@FindBy(xpath= "//tr[@id='$PHCMemberPolicyList$ppxResults$l1'][contains(@class,'notFocused')]")
	WebElement trFirstRowNothighlighted;

	@FindBy (xpath="//span[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement lnkOtherActionExitInteraction;

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions') or contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//span[@class='menu-item-title'][text()='Search Member']")	
	private WebElement lnkOtherActionSearchMember;

	@FindBy (xpath="//*[@class='gridTable '][@id='bodyTbl_right'][contains(@pl_prop,'HCMemberPolicyList')]")	
	private WebElement tblSelectContract;

	@FindBy(xpath="//*[@data-test-id='2016030618392102366999']")
	private WebElement btnrefresh;


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectfirstContract
	 * 
	 */
	int i=0;
	public boolean selectfirstContract(){
		i+=1;
		try {
			if(utils.clickAnelemnt(rdoFirstRow, "SelectContract", "Radio button -firstRowofselectContracttable")){
				if(this.clickTitle())
					if (this.clickSubmit())
						return true;
			}
			else {	
				if(!utils.isProxyWebelement(btnrefresh))
					utils.clickAnelemnt(btnrefresh, "Select Contract", "refereshbutton");
				if(i<=3)
					return selectfirstContract();			
			}
		} catch (Exception e) {
			if (i<=3){
				if(!utils.isProxyWebelement(btnrefresh)){
					utils.clickAnelemnt(btnrefresh, "Select Contract", "refereshbutton");
				}
				return selectfirstContract();
			}
		}
		return false;

	}
	/*
	 * Selecting exit intearction , Ideally to complete the test case need to use the validatePage
	 * method in teh ExitInteraction Class
	 */
	public boolean selectExitInteraction(){
		if(this.clickOtheractions())
			return this.clickExitInteraction();
		return false;
	}

	/*
	 * Selecting exit intearction , Ideally to complete the test case need to use the validatePage
	 * method in the corresponding "Searchmember" Page
	 */
	public boolean selectSearchmember(){
		if(this.clickOtheractions())
			return this.clickSearchmember();
		return false;
	}
	/*
	 * vaidating we are in teh correct page by validating the heading of the page
	 */
	public boolean validatePage(){
		return utils.validateLabel(lblSelectContractTitle, "Select");
	}
	/*
	 * Pressing enter on teh submit button
	 */



	public boolean clickSubmit(){
		utils.scrolltomiddle();
		if( utils.pressEnter(btnSubmit, "SelectContract", "Submit"))
		try {
			return !utils.isServiceDown();
			
		} catch (Exception e) {
			
			System.out.println("Exception occured in service down");
			return false;
		}
	return false;	
	}

	public boolean clickTitle(){
		return utils.clickAnelemnt(lblSelectContractTitle, "SelectContract", "Title");
	}
	public boolean clickOtheractions(){
		return utils.clickAnelemnt(this.btnOtherActions, "selectContract", "Btn Other actions");
	}

	public boolean clickExitInteraction(){
		return utils.clickAnelemnt(this.lnkOtherActionExitInteraction, "selectContract", "Btn Other actions");
	}
	public boolean clickSearchmember(){
		return utils.clickAnelemnt(lnkOtherActionSearchMember, "SelectContract", "OtheractionsSearchMember");
	}
	/*
	 * method to use any number of key value pairs for selecting the row on the table
	 * clicking on the title while entering the page to un select default selection of first row
	 * @param "ColumnHeader1:value1,ColumnHeader2:value2"
	 * param Example: "Status:Active,Coverage Type:Medical,Contract Effective Period:11/01/2015 - Active"
	 * 
	 */


	/* @SCU
	 * #CommonMethodwithArgument:selectContractbasedonvalues
	 * #Arguments:KeyValuePair
	 * Type:Table
	 *Keys:status#

	 */

	public boolean selectContractbasedonvalues(String[] value) throws InterruptedException {
		if (this.clickTitle())
			if( utils.clickontablerowbasedonvalues(this.tblSelectContract, value))
				return this.clickSubmit();
		return false;
	}

	@FindBy(name="$PpyWorkPage$pContactEmailID")
	WebElement txtbxEmailID;
	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateEMailIDinSelectContract
	 * #Description: This functionality verifies the Email id displayed with the email id entered by the CSR.
	 * Type: Textbox 
	 */
	public boolean validateEMailIDinSelectContract()
	{
		String txtEmail1 = txtbxEmailID.getAttribute("value");
		return utils.isvalueMatch_contain(txtEmail1, "tester@gmail.com");
	} 





	//Sprint 2.1 Changes

	@FindBy(id="//table[@pl_prop='HCMemberPolicyList.pxResults']//tr/td[@tabindex='0']/input")
	WebElement rdoBtnDisabled;

	public boolean verifyRdoBtnDisabledForNonWGSStarMember()
	{
		return utils.isProxyWebelement(rdoBtnDisabled);
	}	

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on the Submit button in the Select Contract page
	 * #type: Textbox
	 */
	public boolean clickOnSubmit()
	{
			return utils.clickAnelemnt(this.btnSubmit, "ManageAlert", "Submit");
	}

	@FindBy(xpath="(//span[@id='ERRORMESSAGES_ALL'][@class='errorText']//li[contains(text(),'Contract source system is not available in Solution Central.')])[1]")
	WebElement txtErrorMessageForNonWGSStarMember;

	public boolean verifyErrorMessageForNonWGSStarMember()
	{
			String ErrorMessageInUI = this.txtErrorMessageForNonWGSStarMember.getText();
			String ErrorMessageGivenByUser = " ";
			return utils.isvalueMatch_contain(ErrorMessageInUI, ErrorMessageGivenByUser);
	}


	//Sprint 2.2 Code

	@FindBy(id="//table[@pl_prop='HCMemberPolicyList.pxResults']//tr/td[@tabindex='0']/input")
	WebElement rdoButtonDisabled;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyRdoButtonDisabledForNonWGSStarMember
	 * #Description: This functionality verifies that radio button ins enabled or disabled in the Select Contract page for Non WGS and Star member
	 * Type: Textbox
	 */
	public boolean verifyRdoButtonDisabledForNonWGSStarMember()
	{
		return utils.isProxyWebelement(rdoBtnDisabled);
	}



	@FindBy(xpath="(//div[@node_name='HCMemberPolicySearchResultsLV']//a[contains(text(),' Expand/Collapse All')])[1]")
	WebElement lnkExpandCollapseAll;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickExpandCollapseAll
	 * #Description: This functionality performs click action on the Expand and collapse all link in the Select Contract page
	 * Type: Textbox
	 */
	public boolean clickExpandCollapseAll()
	{
			return utils.clickAnelemnt(this.lnkExpandCollapseAll, "SelectContract", "Expand Collapse All");		
	}

	@FindBy(xpath="//table[@pl_prop='.Coverages']")
	WebElement tblSubTableOfSelectedContracts;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifySelectedContractsSubTable
	 * #Description: This functionality validates the input values given by the user with the values present in the Sub Contract table
	 * #Argument: tablevlaues
	 * Type: Table
	 * Keys: Eligibility Effective Date#Eligibility End Date#Contract Code
	 */
	public boolean verifySelectedContractsSubTable(String[] tablevalues) throws InterruptedException
	{
		return utils.validatetablerowbasedonvalues(tblSubTableOfSelectedContracts, tablevalues);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectExpandPaneByContracts
	 * #Description: This functionality validates the input values given by the user with the values present in the Sub Contract table
	 * Type: Table
	 * Keys: Relationship#Status#Coverage Type#Contract Effective Period#Employer Group Name#Product Group Number#Source
	 */
	public boolean selectExpandPaneByContracts(String[] args)
	{
		try{
			//utils.clickontablerowbasedonvalues(this.limitedLiabilityTable, args);
			WebElement element = Driver.pgDriver.findElement(By.xpath("//*[@class='gridTable '][@id='bodyTbl_right'][contains(@pl_prop,'HCMemberPolicyList')]"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.getTablerowbasedonvalues(this.tblSelectContract, args);
			row.findElement(By.xpath(".//td//span[@alt='press enter to expand row']")).click();
			row.findElement(By.xpath(".//input[@id='CaseOrTaskIcon']")).click();
			return true;

		}catch(Exception e){
			return false;	
		}

	}

	@FindBy(xpath="//tr[@id='$PHCMemberPolicyList$ppxResults$l1']")
	WebElement rdoFirstRowForNascoMember;

	public boolean selectFirstContractForNasco()
	{
		return utils.clickAnelemnt(this.rdoFirstRowForNascoMember, "SelectContract", "First row");
	}

	@FindBy(xpath="//span[@id='ERRORMESSAGES_ALL'][@class='errorText']//li[contains(text(),'Access to Small Group WGS Contract is unavailable in Solution Central at this time')]")
	WebElement SmallGrpWGSErrorMessage;

	/**This method is used to verify that no error message is displayed when loggin in ACA central using small grp member
	 * 
	 * @return
	 */
	public boolean verifyNoErrorMsgDisplayedForWGSMember() {
		return utils.isProxyWebelement(SmallGrpWGSErrorMessage);
	}

	public boolean selectContract(String[] args) {
		int j;
		int count =0;
		ArrayList<String> list = new ArrayList<String>();
		String[] val = {"Coverage Type","Employer Group Name","Status","Relationship","Source","Product Group", "Effective Period","Product Group Number"};
		try {
			String[] value = args[2].split("/");
			for(int i=0;i<val.length;i++) {
				j = utils.getIndexValueOfStringArray(value,val[i]);
				if(j != 0) {
					list.add(value[j]);
					count++;
				}
			}
			if(count>0) {
				String[] contractvalues = new String[list.size()];
				contractvalues = list.toArray(contractvalues);
				selectContractbasedonvalues(contractvalues);

			}else {
				selectfirstContract();
			}
			return true;

		}
		catch(ArrayIndexOutOfBoundsException e) {
			selectfirstContract();
			return true;
			
		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}
	}
	
	@FindBy(xpath="//div[@node_name='DisplayBreakinCoverage']//div[@data-test-id='201803071633130281154883']//p//span//em")
	WebElement breakInCoverageText;
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:breakInCoverageText
	 * #Description:This method validates the break in coverage text for a specific contract selected
	 * Type:Textbox
	 */
	public boolean breakInCoverageText(){
		String breakInCoverage="Note: If there is a possible break in coverage, there is a change in the contract code or view historical data prior to 2015 – log into CCB to validate.";
		String actualMsg = breakInCoverageText.getText().trim();
		return utils.isvalueMatch_contain(breakInCoverage, actualMsg);
	}
	
	
	@FindBy(xpath="//span[text()='Access to ']/parent::p")
	private WebElement errorMessageForUnauthorizedUser;
	
	public boolean verifyErrorMessageForUnauthorizedUsers() throws Exception
	{
		return utils.validateValueinelement(this.errorMessageForUnauthorizedUser, "Access to Capital One Financial Corporation member is not permitted. Connect the contact to Capital One Financial Corporation Customer Service at (844) 390-4133");
	}
	
	
	//Sprint 4.1
	
	public boolean verifySelectContractIsDisplayedOnSElectingYesForMemberContract()
	{
			return utils.validateHeader(lblSelectContractTitle, "Select Contract");
	}
	
	@FindBy(xpath="//div[contains(@class,'content-item content-paragraph item-1')]//span")
	WebElement InstructionalText;
	
	/**Verify the text is displayed in UI
	 * 
	 */
	public boolean validateInstructionalText(String[] args) {
		String actual = InstructionalText.getText().replaceAll("\n", " ");
		System.out.println(actual);
		System.out.println(args[0]);
		
		return utils.isvalueMatch_contain(actual, args[0]);
	}
	
	/**This functionality verifies that the radio button is not displayed in this page
	 * 
	 * @return
	 */
	public boolean verifyRadioButtonIsNotDisplayed() {
		return utils.isProxyWebelement(rdoFirstRow);
	}
	
}

