package automationLib;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.gargoylesoftware.htmlunit.javascript.host.Symbol;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CreateMessageAlert {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());
	public static String total_updated;

	@FindBy(id="PegaGadget0Ifr")
	WebElement Iframeelement;
	
	public CreateMessageAlert(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="AlertSearchTypeHCID")
	private WebElement at_PolicyHCIDNumber;
	
	@FindBy(id="AlertSearchTypeGROUPNUMBER")
	private WebElement at_GroupNumber;
	
	@FindBy(id="AlertSearchTypeCONTRACTCODE")
	private WebElement at_ContractCode;
	
	@FindBy(id="AlertSearchTypeHCIDNAME")
	private WebElement at_MemHCIDAndMemName;
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectAlertType
	 * #Description:This method selects a particular alert type to be created
	 * #Arguments:Alert Type
	 * Type:Dropdown
	 * Keys:Policy (HCID) Number#Group Number#Contract Code#Member HCID and Member Name
	 */
	public boolean selectAlertType(String args[]){
	try{
		if(args[0].equalsIgnoreCase("Policy (HCID) Number")){
			return utils.clickAnelemnt(this.at_PolicyHCIDNumber, "CreateMessageAlert", "Policy (HCID) Number");
		}else if(args[0].equalsIgnoreCase("Group Number")){
			return utils.clickAnelemnt(this.at_GroupNumber, "CreateMessageAlert", "Group Number");	
		}else if(args[0].equalsIgnoreCase("Contract Code")){
			return utils.clickAnelemnt(this.at_ContractCode, "CreateMessageAlert", "Contract Code");	
		}else if(args[0].equalsIgnoreCase("Member HCID and Member Name")){
			return utils.clickAnelemnt(this.at_MemHCIDAndMemName, "CreateMessageAlert", "Member HCID and Member Name");	
		}else{
			System.out.println("Incorrect argument passed - doesnt match with UI fields"+args[0]);
			return false;
		}		
		}catch(Exception e){
		err.logError("CreateMessageAlert", "unable to select the Alert Type"+args[0]+"with exception:"+e);
		return false;
		}
	}
	
	@FindBy(xpath="//*[contains(@data-ui-meta,'Paragraph')]//p//span")
	WebElement instText;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateInstTxtforHCID
	 * #Description:This method validates the instructional text when Policy HCID Number is selected
	 * Type:TextBox
	 */
	public boolean validateInstTxtforHCID(){
		String hcidTxt="To create an alert for one Policy (HCID) Number, use the text box. To create an alert for multiple Policy (HCID) Numbers,use the Choose File button to import a file of Policy (HCID) Numbers.";
		String insTxt = instText.getText().replace("\n","").trim();
		return utils.isvalueMatch_contain(hcidTxt, insTxt);
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateInstTxtforGroupNumber
	 * #Description:This method validates the instructional text when Group Number is selected
	 * Type:TextBox
	 */
	public boolean validateInstTxtforGroupNumber(){
		String groupNoTxt="To create an alert for one Group Number, use the text box. To create an alert for multiple Group Numbers,use the Choose File button to import a file of Group Numbers.";
		String insTxt = instText.getText().replace("\n","").trim();
			return utils.isvalueMatch_contain(groupNoTxt, insTxt);
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateInstTxtforContractCode
	 * #Description:This method validates the instructional text when Contract Code is selected
	 * Type:TextBox
	 */
	public boolean validateInstTxtforContractCode(){
		String contractCodeTxt="To create an alert for one Contract Code, use the text box. To create an alert for multiple Contract Codes,use the Choose File button to import a file of Contract Codes.";
		String insTxt = instText.getText().replace("\n","").trim();
		return utils.isvalueMatch_contain(contractCodeTxt, insTxt);
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateNoInstTxtforMemberHCIDAndMemberName
	 * #Description:This method validates the no instructional text is displayed when Member HCID and Member Name is selected
	 * Type:TextBox
	 */
	public boolean validateNoInstTxtforMemberHCIDAndMemberName(){
		return !utils.isProxyWebelement(instText);
	}
	
	@FindBy(id="HCID")
	private WebElement hcid_TxtBox;
	
	@FindBy(id="ContractCode")
	private WebElement contractCode_TxtBox;
	
	@FindBy(id="GroupNumber")
	private WebElement groupNumber_TxtBox;
	
	@FindBy(id="HCID")
	private WebElement memhcidName_TxtBox;
	
	@FindBy(xpath="//button[@name='CreateAlertCore_TempNewAlert_18']//child::div[text()='Search']")
	private WebElement search_Btn;
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterPolicyHCIDNumber
	 * #Description:This method enters the Policy HCID Number in CreateMessageAlert page
	 * #Arguments:Policy HCID Number
	 * Type:TextBox
	 */
	public boolean enterPolicyHCIDNumber(String args[]){
		return utils.enterTextinAnelemnt(this.hcid_TxtBox, args[0], "CreateMessageAlert", "Policy HCID Number");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterGroupNumber
	 * #Description:This method enters the Group Number in CreateMessageAlert page
	 * #Arguments:Group Number
	 * Type:TextBox
	 */
	public boolean enterGroupNumber(String args[]){
			return utils.enterTextinAnelemnt(this.groupNumber_TxtBox, args[0], "CreateMessageAlert", "Group Number");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterContractCode
	 * #Description:This method enters the Contract Code in CreateMessageAlert page
	 * #Arguments:Contract Code
	 * Type:TextBox
	 */
	public boolean enterContractCode(String args[]){
			return utils.enterTextinAnelemnt(this.contractCode_TxtBox, args[0], "CreateMessageAlert", "Contract Code");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchByMemberHCIDAndMemberName
	 * #Description:This method enters the MemberHCID And MemberName and performs search in CreateMessageAlert page
	 * #Arguments:Member HCID And MemberName
	 * Type:TextBox
	 */
	public boolean searchByMemberHCIDAndMemberName(String args[]) {
			if(utils.enterTextinAnelemnt(this.memhcidName_TxtBox, args[0], "CreateMessageAlert", "Member HCID And MemberName")){
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].click();", search_Btn); 
			return true;
			}
			
					//utils.clickAnelemnt(this.search_Btn, "CreateMessageAlert", "Search");
			return false;	
		
	}
	
	@FindBy(xpath="//div[contains(@gpropindex,'HCMemberContactListPpxResults')]//table[@class='gridTable '][@pl_prop='HCMemberContactList.pxResults']")
	private WebElement memSearchList_Tbl;
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectMemberByName
	 * #Description:This method selects a member returned by MemberHCID And MemberName search
	 * #Arguments:Member Details
	 * Type:Table
	 * Keys:First Name#Last Name#Date of Birth#Relationship
	 */
	public boolean selectMemberByName(String args[]) throws InterruptedException{
		return utils.clickontablerowbasedonvalues(this.memSearchList_Tbl,args);
	}
	
	@FindBy(id="AlertStartDate")
	private WebElement alertStartDate;
	
	@FindBy(id="AlertEndDate")
	private WebElement alertEndDate;
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterStartAndEndDate
	 * #Description:This method enters start and end date on Create Message Alert screen
	 * #Arguments:Start Date and End Date
	 * Type:TextBox
	 */
	public boolean enterStartAndEndDate(String args[]){
		if(utils.enterTextinAnelemnt(this.alertStartDate, args[0], "CreateMessageAlert", "Start Date"))
		return utils.enterTextinAnelemnt(this.alertEndDate, args[1], "CreateMessageAlert", "End Date");
		return false;		
	
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Add All']")
	WebElement addAll;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:addAllInWorkGroups
	 * #Description:This method clicks on Add All button under Workgroups - Audience
	 * Type:TextBox
	 */
	public boolean addAllInWorkGroups(){
		try{
		List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//*[@class='pzbtn-mid'][text()='Add All']"));
		tables.get(0).click();
		utils.waitforpageload();
		return true;
		}catch(Exception e){
			System.out.println("Exception occured in addAllInWorkGroups"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:addAllInWorkGroupManagers
	 * #Description:This method clicks on Add All button under Workgroup Manager section
	 * Type:TextBox
	 */
	public boolean addAllInWorkGroupManagers(){
		try{
		List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//*[@class='pzbtn-mid'][text()='Add All']"));
		tables.get(1).click();
		utils.waitforpageload();
		return true;
		}catch(Exception e){
			System.out.println("Exception occured in addAllInWorkGroupManagers"+e);
			return false;
		}
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Remove All']")
	WebElement removeAll;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:removeAllInWorkGroups
	 * #Description:This method clicks on Remove All button under Workgroups - Audience
	 * Type:TextBox
	 */
	public boolean removeAllInWorkGroups(){
		try{
		List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//*[@class='pzbtn-mid'][text()='Remove All']"));
		tables.get(0).click();
		utils.waitforpageload();
		return true;
		}catch(Exception e){
			System.out.println("Exception occured in removeAllInWorkGroups"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:removeAllInWorkGroupManagers
	 * #Description:This method clicks on Remove All button under Workgroup Manager section
	 * Type:TextBox
	 */
	public boolean removeAllInWorkGroupManagers(){
		try{
		List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//*[@class='pzbtn-mid'][text()='Remove All']"));
		tables.get(1).click();
		utils.waitforpageload();
		return true;
		}catch(Exception e){
			System.out.println("Exception occured in removeAllInWorkGroupManagers"+e);
			return false;
		}
	}
	
	@FindBy(xpath="//*[@gpropindex='PAvailableOperatorsList1']//table[@class='gridTable '][@prim_page='D_SolutionCentralWorkGroups']")
	WebElement workgroupsAvailableTable;
	
	@FindBy(xpath="//*[@gpropindex='PSelectedOperatorsList1']//table[@class='gridTable '][@prim_page='D_SolutionCentralWorkGroups']")
	WebElement workgroupsSelectedTable;
	
	@FindBy(xpath="//*[@gpropindex='PAvailableOperatorsList1']//table[@class='gridTable '][@prim_page='TempWGManagersList']")
	WebElement workgroupsManagerAvailableTable;
	
	@FindBy(xpath="//*[@gpropindex='PSelectedOperatorsList1']//table[@class='gridTable '][@prim_page='TempWGManagersList']")
	WebElement workgroupsManagerSelectedTable;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:addSelectAudienceInWorkGroup
	 * #Description:This method selects particular audiences in Workgroup
	 * #Arguments:Workgroup audience
	 * Type:TextBox
	 */
	public boolean addSelectAudienceInWorkGroup(String args[]){
		try{
		for(String wrkgrp:args){
			WebElement selectaudience = Driver.pgDriver.findElement(By.xpath("//*[@gpropindex='PAvailableOperatorsList1']//table[@class='gridTable '][@prim_page='D_SolutionCentralWorkGroups']//tr/td//span[text()='"+wrkgrp+"']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", selectaudience);
			selectaudience.click();
			utils.waitforpageload();
		}
		}catch(Exception e){
			System.out.println("Exception occured in while selecting a workgroup audience: addSelectAudienceInWorkGroup"+e);
			return false;
		}
		return true;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:addSelectWorkGroupManagers
	 * #Description:This method selects particular managers in Workgroup
	 * #Arguments:Workgroup Manager
	 * Type:TextBox
	 */
	public boolean addSelectWorkGroupManagers(String args[]){
		try{
			for(String wrkgrp:args){
				WebElement selectmanager = Driver.pgDriver.findElement(By.xpath("//*[@gpropindex='PAvailableOperatorsList1']//table[@class='gridTable '][@prim_page='TempWGManagersList']//tr/td//span[text()='"+wrkgrp+"']"));
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", selectmanager);
				selectmanager.click();
				utils.waitforpageload();
			}
			}catch(Exception e){
				System.out.println("Exception occured in while selecting a workgroup manager: addSelectWorkGroupManagers"+e);
				return false;
			}
			return true;
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:removeSelectAudienceInWorkGroup
	 * #Description:This method selects and removes particular audiences in Workgroup
	 * #Arguments:Workgroup audience
	 * Type:TextBox
	 */
	public boolean removeSelectAudienceInWorkGroup(String args[]){
		try{
			for(String wrkgrp:args){
				WebElement selectaudience = Driver.pgDriver.findElement(By.xpath("//*[@gpropindex='PSelectedOperatorsList1']//table[@class='gridTable '][@prim_page='D_SolutionCentralWorkGroups']//tr/td//span[text()='"+wrkgrp+"']"));
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", selectaudience);
				selectaudience.click();
				utils.waitforpageload();
			}
			}catch(Exception e){
				System.out.println("Exception occured in while removing a workgroup audience: removeSelectAudienceInWorkGroup"+e);
				return false;
			}
		return true;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:removeSelectWorkGroupManagers
	 * #Description:This method selects and removes particular managers in Workgroup
	 * #Arguments:Workgroup Manager
	 * Type:TextBox
	 */
	public boolean removeSelectWorkGroupManagers(String args[]){
		try{
			for(String wrkgrp:args){
				WebElement selectmanager = Driver.pgDriver.findElement(By.xpath("//*[@gpropindex='PSelectedOperatorsList1']//table[@class='gridTable '][@prim_page='TempWGManagersList']//tr/td//span[text()='"+wrkgrp+"']"));
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", selectmanager);
				selectmanager.click();
				utils.waitforpageload();
			}
			}catch(Exception e){
				System.out.println("Exception occured in while removing a workgroup manager: removeSelectWorkGroupManagers"+e);
				return false;
			}
			return true;
	}
	
	@FindBy(id="AlertTitle")
	private WebElement alertTitleTxtBox;
	
	@FindBy(xpath="//body[@title='This is a rich text editor control.']")
	private WebElement alertMsgBox;

	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement IframeAlert;
	
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterAlertTitle
	 * #Description:This method enters Alert Title in Create Message Alert page.
	 * #Arguments:Alert Title
	 * Type:TextBox
	 */
	public boolean enterAlertTitle(String args[]){
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", this.alertTitleTxtBox);
		if(utils.enterTextinAnelemnt(this.alertTitleTxtBox, args[0], "CreateMessageAlert", "Alert Title")) {
		this.alertTitleTxtBox.sendKeys(Keys.TAB);
		return true;
		}
		return false;	
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:enterAlertMessage
	 * #Description:This method enters Alert Message in Create Message Alert page.
	 * #Arguments:Alert Message
	 * Type:TextBox
	 */
	public boolean enterAlertMessage(String args[]){
			Driver.getPgDriver().switchTo().frame(IframeAlert);
			return utils.enterTextinAnelemnt(this.alertMsgBox,args[0], "CreateMessageAlert", "Alert Message Body");
	}
	
	@FindBy(id="ModalButtonSubmit")
	private WebElement BtnSave;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:saveAlert
	 * #Description:This method clicks on Save button inorder to save the  Alert details
	 * Type:TextBox
	 */
	public boolean saveAlert(){
			
			//WebElement BtnSave = driver.findElement(By.id("ModalButtonSubmit"));
			//JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].click();", BtnSave); 
			//executor.executeScript("arguments[0].click(); , BtnSave); 
			return true;
			//return utils.clickAnelemnt(this.BtnSave, "CreateMessageAlert", "Save Button");
	}
	
	@FindBy(id="$PTempNewAlert$ppyFileName")
	private WebElement chooseFileInput;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Load']")
	private WebElement BtnLoad;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Cancel']")
	private WebElement BtnCancel;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyFileUploadSection
	 * #Description:This method verifies if file upload section is displayed for Policy HCID Number, Group number and Contract code selection.
	 * Type:TextBox
	 */
	public boolean verifyFileUploadSection(){
		try{
			if(this.chooseFileInput.isDisplayed() && this.BtnLoad.isDisplayed() && this.BtnCancel.isDisplayed()){
				System.out.println("FileUploadSection is displayed");
				return true;				
			}else {
				System.out.println("FileUploadSection is not displayed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured in verifyFileUploadSection"+e);
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyNoFileUploadSection
	 * #Description:This method verifies no file upload section is displayed for MemberHCID and MemberName selection.
	 * Type:TextBox
	 */
	public boolean verifyNoFileUploadSection(){
		try{
			if(this.chooseFileInput.isDisplayed() && this.BtnLoad.isDisplayed()){
				System.out.println("FileUploadSection is displayed");
				return false;				
			}else {
				System.out.println("FileUploadSection is not displayed");
				return true;
			}
		}catch(Exception e){
			System.out.println("Exception occured in verifyNoFileUploadSection"+e);
			return true;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:userAttachesBulkFile
	 * #Description:This method allows the user to upload the bulk file
	 * Type:TextBox
	 */
	public boolean userAttachesBulkFile(){
		try{
			this.chooseFileInput.click();
			String text = "C:\\Users\\AF55091\\Desktop\\TestData.xlsx";
		    StringSelection stringSelection = new StringSelection(text);
		    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    clipboard.setContents(stringSelection, stringSelection);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			return true;
		}catch(Exception e){
			System.out.println("Exception occured in userAttachesBulkFile"+e);
			return false;
		}
	}
	
	
	@FindBy(xpath="//*[@gpropindex='AlertsListPpxResults2']//table[@class='gridTable ']")
	private WebElement hcidDataTbl;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:loadBulkUpload
	 * #Description:This method allows the user to click on Load button for bulk upload
	 * Type:TextBox
	 */
	public boolean loadBulkUpload(){
		try{
			utils.clickAnelemnt(this.BtnLoad, "CreateMessageAlert", "Load Button");
			utils.waitforpageload();
			boolean s = Driver.pgDriver.findElement(By.xpath("//*[@gpropindex='AlertsListPpxResults2']//table[@class='gridTable ']")).isDisplayed();
			ArrayList<String> HCIDList = new ArrayList<String>();
			FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\AF55091\\Desktop\\TestData.xlsx"));
			Workbook excelWB = new XSSFWorkbook(inputStream);
			Sheet excelSheet = excelWB.getSheet("Sheet1");
			int rowCount = excelSheet.getLastRowNum()-excelSheet.getFirstRowNum();
		    System.out.println("Row count:"+rowCount);
			for (int i = 0; i < rowCount; i++) {
				Row row = excelSheet.getRow(i+1);
				HCIDList.add(row.getCell(0).getStringCellValue());
		    }
			inputStream.close();
			System.out.println("HCIDs in the list:"+HCIDList);
			if(s){
				System.out.println("Table is visible:"+s);
				for(String hcid:HCIDList){
					try{
						WebElement e =	Driver.pgDriver.findElement(By.xpath("//*[@gpropindex='AlertsListPpxResults2']//table[@class='gridTable ']//tr/td[contains(@data-ui-meta,'.HCIDGrpNbrContractCd')]//span[contains(text(),'"+hcid+"')]"));
						e.click();
						System.out.println("HCID is present in UI:"+hcid);
					}catch(Exception e){
						System.out.println("HCID is not present in UI:"+hcid+"with Exception"+e);
						return false;
					}
				}
			return true;
			}else{
				System.out.println("Table is Invisible");
			return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured in loadBulkUpload"+e);
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:cancelBulkUpload
	 * #Description:This method allows the user to cancel the bulk upload
	 * Type:TextBox
	 */
	public boolean cancelBulkUpload(){
			return utils.clickAnelemnt(this.BtnCancel, "CreateMessageAlert", "Cancel Fileupload Button");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyExportToExcel
	 * #Description:This method allows the user to click on Export to Excel button for bulk upload
	 * Type:TextBox
	 */
	public boolean verifyExportToExcel(){
		return !utils.isProxyWebelement(BtnExportToExcel);
	}
	
	@FindBy(xpath="//a[@title='Next Page']")
	WebElement nextLink;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyIfPaginationIsDisplayed
	 * #Description:This method allows the user to to verify if pagination appear for more than 25 records on page
	 * Type:TextBox
	 */
	public boolean verifyIfPaginationIsDisplayed(){
		return !utils.isProxyWebelement(nextLink);
	}

	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionAlertsPreviewB']//span[@role='heading']")
	WebElement hdr_in_CMA;
	
	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionAlertsPreviewB']//div[text()='Total Uploaded']")
	WebElement lbl_TotUploaded;
	
	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionAlertsPreviewB']//div[text()='Total Updated']")
	WebElement lbl_TotUpdated;
	
	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionAlertsPreviewB']//div[text()='Total Failed']")
	WebElement lbl_TotFailed;
	
	@FindBy(xpath="//*[@param_name='EXPANDEDSubSectionAlertsPreviewB']//div[text()='Total Duplicates']")
	WebElement lbl_TotDuplicates;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyHCIDsUpdatedSection
	 * #Description:This method verifies the message displayed in the HCIDs updated section
	 * Type:TextBox
	 */
	public boolean verifyHCIDsUpdatedSection(){
		try{
			if(this.hdr_in_CMA.getText().trim().equalsIgnoreCase("Policy (HCID) Numbers Updated")){
				System.out.println("'Policy (HCID) Numbers Updated' header is displayed");
				List<WebElement> data = Driver.pgDriver.findElements(By.xpath("//*[@param_name='EXPANDEDSubSectionAlertsPreviewB']//div[text()='Total Uploaded']//parent::div//parent::div//following-sibling::div//span[@class='leftJustifyStyle']"));
				total_updated = data.get(1).getText();
				if(this.lbl_TotUploaded.isDisplayed() && this.lbl_TotUpdated.isDisplayed() && this.lbl_TotFailed.isDisplayed() && this.lbl_TotDuplicates.isDisplayed()){
					System.out.println("'Total Uploaded','Total Updated','Total Failed' and 'Total Duplicates' labels are displayed");
					return true;
				}else{
					return false;
				}
			}else{
				System.out.println("'Policy (HCID) Numbers Updated' header is not displayed in UI, but this:"+this.hdr_in_CMA.getText().trim());
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured in verifyHCIDsUpdatedSection"+e);
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyGroupNoUpdatedSection
	 * #Description:This method verifies the message displayed in the Group Number updated section
	 * Type:TextBox
	 */
	public boolean verifyGroupNoUpdatedSection(){
		try{
			if(this.hdr_in_CMA.getText().trim().equalsIgnoreCase("Group Numbers Updated")){
				System.out.println("'Group Numbers Updated' header is displayed");
				List<WebElement> data = Driver.pgDriver.findElements(By.xpath("//*[@param_name='EXPANDEDSubSectionAlertsPreviewB']//div[text()='Total Uploaded']//parent::div//parent::div//following-sibling::div//span[@class='leftJustifyStyle']"));
				total_updated = data.get(1).getText();
				if(this.lbl_TotUploaded.isDisplayed() && this.lbl_TotUpdated.isDisplayed() && this.lbl_TotFailed.isDisplayed() && this.lbl_TotDuplicates.isDisplayed()){
					System.out.println("'Total Uploaded','Total Updated','Total Failed' and 'Total Duplicates' labels are displayed");
					return true;
				}else{
					return false;
				}
			}else{
				System.out.println("'Group Number' header is not displayed in UI, but this:"+this.hdr_in_CMA.getText().trim());
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured in verifyGroupNoUpdatedSection"+e);
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyContractCodeUpdatedSection
	 * #Description:This method verifies the message displayed in the Contract Code updated section
	 * Type:TextBox
	 */
	public boolean verifyContractCodeUpdatedSection(){
		try{
			if(this.hdr_in_CMA.getText().trim().equalsIgnoreCase("Contract Codes Updated")){
				System.out.println("'Contract Codes Updated' header is displayed");
				List<WebElement> data = Driver.pgDriver.findElements(By.xpath("//*[@param_name='EXPANDEDSubSectionAlertsPreviewB']//div[text()='Total Uploaded']//parent::div//parent::div//following-sibling::div//span[@class='leftJustifyStyle']"));
				total_updated = data.get(1).getText();
				if(this.lbl_TotUploaded.isDisplayed() && this.lbl_TotUpdated.isDisplayed() && this.lbl_TotFailed.isDisplayed() && this.lbl_TotDuplicates.isDisplayed()){
					System.out.println("'Total Uploaded','Total Updated','Total Failed' and 'Total Duplicates' labels are displayed");
					return true;
				}else{
					return false;
				}
			}else{
				System.out.println("'Contract Codes Updated' header is not displayed in UI, but this:"+this.hdr_in_CMA.getText().trim());
				return false;
			}
			
		}catch(Exception e){
			System.out.println("Exception occured in verifyContractCodeUpdatedSection"+e);
			return false;
		}
	}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Create']")
	WebElement BtnCreateMessageAlert;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Cancel']")
	WebElement BtnCancelMessageAlert;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Export to Excel')]")
	WebElement BtnExportToExcel; 
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:createMessageAlert
	 * #Description:This method allows the user to click on save and create a new message alert
	 * Type:TextBox
	 */
	public boolean createMessageAlert(){
			return utils.clickAnelemnt(this.BtnCreateMessageAlert, "CreateMessageAlert", "Create");
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:cancelMessageAlert
	 * #Description:This method allows the user to cancel changes made on new message alert
	 * Type:TextBox
	 */
	public boolean cancelMessageAlert(){
			return utils.clickAnelemnt(this.BtnCancelMessageAlert, "CreateMessageAlert", "Cancel");
	}
	
	@FindBy(xpath="//*[contains(@data-ui-meta,'ConfirmAlertMessage')]//span")
	WebElement confirmAlertMsg;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateInstTxtforHCIDPostUpload
	 * #Description:This method allows the user to verify instructional text post HCID upload
	 * Type:TextBox
	 */
	public boolean validateInstTxtforHCIDPostUpload(){
			String confirmTxt = "This alert will be applied to the "+total_updated+"  Policy (HCID) Numbers from the file";
			return utils.validateLabel(confirmAlertMsg, confirmTxt);
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateInstTxtforGroupNumberPostUpload
	 * #Description:This method allows the user to verify instructional text post GroupNo upload
	 * Type:TextBox
	 */
	public boolean validateInstTxtforGroupNumberPostUpload(){
			String confirmTxt = "This alert will be applied to the "+total_updated+"  Group Numbers from the file";
			return utils.validateLabel(confirmAlertMsg, confirmTxt);
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateInstTxtforContractCodePostUpload
	 * #Description:This method allows the user to verify instructional text post Contract Code upload
	 * Type:TextBox
	 */
	public boolean validateInstTxtforContractCodePostUpload(){
			String confirmTxt = "This alert will be applied to the "+total_updated+"  Contract Codes from the file";
			return utils.validateLabel(confirmAlertMsg, confirmTxt);
	}
	
	@FindBy(xpath="//span[text()='Please enter a valid 9 Digit Alpha Numeric Member ID']")
	WebElement ErrorMessageForHCIDGreaterThan9Digit;
	
	
	public boolean validateErrorMessageForHCIDGreaterThan9Digit()
	{
		utils.waitforpageload();
		return !utils.isProxyWebelement(ErrorMessageForHCIDGreaterThan9Digit);	
	}
	
	@FindBy(id="AlertSearchTypeTINNPI")
	WebElement TINorNPiRadioButton;

	public boolean selectTinOrNpiRadioButton(){
		
		return utils.clickAnelemnt(TINorNPiRadioButton, "CreateMessageAlert", "TINorNPiRadioButton");
	}
	
	@FindBy(id="ProviderID")
	WebElement TINORNPItxtBox;
	
	@FindBy(xpath="//button[@data-test-id='2015082811210004244498']")
	WebElement SearchBtn;
	
	public boolean searchTINOrNPI(String[] args) throws InterruptedException {
		 
			if(utils.enterTextinAnelemnt(TINORNPItxtBox, args[0],"CreateMessageAlert","TINORNPItxtBox"))
				
					utils.scrolltomiddle();
			
					return utils.clickAnelemnt(SearchBtn, "CreateMessageAlert", "SearchBtn");
						

	}
	@FindBy(id="CaseOrTaskIcon")
	WebElement radioButton;
	
	public boolean selectfirstProvider(){
		return utils.clickAnelemnt(radioButton, "SelectMember", "Radio button -	firstRowofselectMembertable");
			
}
	@FindBy(id="AlertStartDate")
	WebElement StartDateTxtBX;
	
	@FindBy(id="AlertEndDate")
	WebElement EndDateTxtBX;
	
	@FindBy(xpath="//label[text()='Select Workgroups Managers']//preceding::div[text()='Add All']")
	WebElement SltAudAddAllBtn;
	
	@FindBy(xpath="//label[text()='Select Workgroups Managers']//following::div[text()='Add All']")
	WebElement SltMGRAddAllBtn;
	
	public boolean enterStartDateAndENDDate(String[] args) throws InterruptedException
	{
		
			if(utils.enterTextinAnelemnt(StartDateTxtBX, args[0], "CreateMessageAlert", "StartDateTxtBX")) 
				Thread.sleep(3000);
				if(utils.enterTextinAnelemnt(EndDateTxtBX, args[1], "CreateMessageAlert", "EndDateTxtBX"))
					utils.scrolltomiddle();
					if(utils.clickAnelemnt(SltAudAddAllBtn, "CreateMessageAlert", "SltAudAddAllBtn"))
					Thread.sleep(3000);
					return utils.clickAnelemnt(SltMGRAddAllBtn, "CreateMessageAlert", "SltMGRAddAllBtn");			
		}
	
@FindBy(id="AlertTitle")
WebElement AlertTittletxtbx;
@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
WebElement iframe2;
@FindBy(xpath="//body[@title='This is a rich text editor control.']")
WebElement AlertMsgtxtbx;
@FindBy(xpath ="//td[@class='buttonTdMiddle']//button[@id='ModalButtonSubmit']")
WebElement SaveBtn;

public boolean enterAlertTittleAndAlertMessage(String[] args)
{
	
		if(utils.enterTextinAnelemnt(AlertTittletxtbx, args[0], "CreateMessageAlert", "AlertTittletxtbx"))
			Driver.pgDriver.switchTo().frame(iframe2);
			if(utils.clickAnelemnt(AlertMsgtxtbx, "CreateMessageAlert", "AlertMsgtxtbx"))
			if(utils.enterTextinAnelemnt(AlertMsgtxtbx, args[1], "CreateMessageAlert", "AlertMsgtxtbx")){
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement);
				return this.saveAlert();
			}
		return false;
	}

@FindBy(xpath="//span[text()='Alert Sub Type']")
WebElement AlrttypeLable;

public boolean validateAlertSubTypeandRadioButtonsareAvailable(){
	return !utils.isProxyWebelement(AlrttypeLable);
}

@FindBy(id="AlertSubTypeWGMgr")
WebElement WgroupMGRRadioBTN;

public boolean selectWorkGroupManagerRadioButton(){
	return utils.clickAnelemnt(WgroupMGRRadioBTN, "CreateMessageAlert", "WgroupMGRRadioBTN");
}


@FindBy(id="AlertSubTypeWGSkill")
WebElement WgroupSkillRadioBTN;

public boolean selectWorkGroupSkillRadioButton(){
	return utils.clickAnelemnt(WgroupSkillRadioBTN, "CreateMessageAlert", "WgroupSkillRadioBTN");
}

@FindBy(xpath="//label[text()='Select Workgroups Skills']")
WebElement WGSKillsLable;

public boolean verifySelectWorkgroupsSkillslable()
{ if(utils.waitForElementToBeVisible(WGSKillsLable))
	return !utils.isProxyWebelement(WGSKillsLable);
return true;
}

@FindBy(xpath="//label[text()='Select Workgroups Managers']")
WebElement WGMGRLable;

public boolean verifySelectWorkgroupsManagerslable(){
	if(utils.waitForElementToBeVisible(WGMGRLable))
	return !utils.isProxyWebelement(WGMGRLable);
	return true;
}

@FindBy(xpath="//label[text()='Select Workgroups Skills']//following::table[@pl_prop='.AvailableSkillsList']")
WebElement WGSKillListTabel;

public boolean validateSkillsListBasedOnWorkGroup(String args[]){
	
	//return utils.validatetablerowbasedonvalues(WGSKillListTabel, tablevalues);
List<WebElement> UISKillsList= Driver.pgDriver.findElements(By.xpath("//label[text()='Select Workgroups Skills']//following::table[@pl_prop='.AvailableSkillsList']//tr"));
System.out.println(UISKillsList.size());
ArrayList<String> value=new ArrayList<String>();
for(WebElement element: UISKillsList)  
{
	String tempval=element.getText();
	tempval=tempval.trim();
	value.add(tempval);
}
 value.remove(0);
 System.out.println(value);
 ArrayList<String> valuesfromargs=new ArrayList<String>();
 for(String arg:args){
	System.out.println("The values: "+arg);
	valuesfromargs.add(arg);
	}
System.out.println(valuesfromargs);
if(valuesfromargs.equals(value)){
System.out.println("Matched");
return true;
}
else 
	return false;
}
}







