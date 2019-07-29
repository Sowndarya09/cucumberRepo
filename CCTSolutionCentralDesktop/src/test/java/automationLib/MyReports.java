package automationLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class MyReports {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget0Ifr")
	WebElement Iframeelement;

	public MyReports(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	@FindBy(xpath="//*[@title='Inventory Reports']")
	WebElement InventoryReportsLink;

	public boolean clickOnInventoryReports(){
		return utils.clickAnelemnt(InventoryReportsLink, "MyReports", "InventoryReportsLink");

	}
	@FindBy(xpath="//*[@title='Interaction Inventory']")
	WebElement InteractionInventoryLink;
	public boolean clickOnInteractionInventoryReport(){
		return utils.clickAnelemnt(InteractionInventoryLink, "MyReports", "InteractionInventoryLink");
	}

	@FindBy(xpath="//*[text()='Service Request Inventory']")
	WebElement ServiceRequestInventoryLink;
	public boolean clickOnServiceRequestInventoryReport(){
		return utils.clickAnelemnt(ServiceRequestInventoryLink, "MyReports", "ServiceRequestInventoryLink");
	}

	@FindBy(xpath="//*[text()='Service Request Workbasket Receipts']")
	WebElement ServiceRequestWorkbasketReceiptLink;
	public boolean clickOnServiceRequestWorkBasketReceiptsReport(){
		return utils.clickAnelemnt(ServiceRequestWorkbasketReceiptLink, "MyReports", "ServiceRequestWorkbasketReceiptLink");
	}

	@FindBy(xpath="//*[@id='$PpyReportContentPage$ppyReportDefinition$ppyUI$ppyBody$ppyUIFilters$ppyFilter$l9']//button[@title='Select Values']")
	WebElement SelectValuesLink;

	@FindBy(xpath="//tr[@id='$PpyReportContentPage$ppyReportDefinition$ppyUI$ppyBody$ppyUIFilters$ppyFilter$l6']//button[contains(@title,'Select Values')]")
	WebElement SelectValuesLink1;

	@FindBy(xpath="//*[@id='$PpyReportContentPage$ppyReportDefinition$ppyUI$ppyBody$ppyUIFilters$ppyFilter$l8']//button[@title='Select Values']")
	WebElement SelectValuesLink2;

	public boolean clickOnSelectValuesButtonAtHCCustomerTypeFilter() throws InterruptedException{
		Boolean flag = false;
		if(!utils.isProxyWebelement(SelectValuesLink1))
			flag = utils.clickAnelemnt(SelectValuesLink1, "MyReports", "SelectValuesLink");
		else if(!utils.isProxyWebelement(SelectValuesLink2))
			flag = utils.clickAnelemnt(SelectValuesLink2, "MyReports", "SelectValuesLink");
		else
			flag = utils.clickAnelemnt(SelectValuesLink, "MyReports", "SelectValuesLink");
		return flag;

	}

	@FindBy(xpath="//*[contains(text(),'Member')]/..//*[@type='checkbox']")
	WebElement MemberCheckBox;

	@FindBy(xpath="//*[contains(text(),'Provider')]/..//*[@type='checkbox']")
	WebElement ProviderCheckBox;

	@FindBy(id="ModalButtonSubmit")
	WebElement SubmitButtonInPopup;

	@FindBy(xpath="//*[text()='  Submit ']")
	WebElement SubmitButton;

	public boolean CheckMemberCheckBoxAtSelectValuesPopUp() {

		return utils.clickAnelemnt(MemberCheckBox, "MyReports", "MemberCheckBox");
	}

	public boolean CheckProviderCheckBoxAtSelectValuesPopUp() {

		return utils.clickAnelemnt(ProviderCheckBox, "MyReports", "MemberCheckBox");
	}

	public boolean ClickOnSUbmitAtSelectValuesPopUp() {
		return utils.clickAnelemnt(SubmitButtonInPopup, "MyReports", "SubmitButtonInPopup");
	}

	public boolean ClickOnSUbmitAtAllFiltersPage() {
		return utils.clickAnelemnt(SubmitButton, "MyReports", "SubmitButton");
	}

	public boolean selectMemberValueAndVerify() throws InterruptedException {

		boolean flag = false;
		Thread.sleep(4000);
		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("Number"+handles.size());
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
			System.out.println("subWindowHandler"+subWindowHandler);
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		Thread.sleep(2000);
		if(clickOnSelectValuesButtonAtHCCustomerTypeFilter())
			if(CheckMemberCheckBoxAtSelectValuesPopUp())
				if(ClickOnSUbmitAtSelectValuesPopUp()) {
					Thread.sleep(2000);
					if(validateMemberIsSelected())
						if(ClickOnSUbmitAtAllFiltersPage())
							flag = true;
				}
		return flag;
	}

	public boolean selectProviderValueAndVerify() throws InterruptedException {

		boolean flag = false;
		Thread.sleep(4000);
		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("Number"+handles.size());
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
			System.out.println("subWindowHandler"+subWindowHandler);
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		Thread.sleep(2000);
		if(clickOnSelectValuesButtonAtHCCustomerTypeFilter())
			if(CheckProviderCheckBoxAtSelectValuesPopUp())
				if(ClickOnSUbmitAtSelectValuesPopUp()) {
					Thread.sleep(2000);
					if(validateProviderIsSelected())
						if(ClickOnSUbmitAtAllFiltersPage())
							flag = true;
				}
		return flag;
	}

	public boolean selectMemberAndProviderValueAndVerify() throws InterruptedException {

		boolean flag = false;
		Thread.sleep(4000);
		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("Number"+handles.size());
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
			System.out.println("subWindowHandler"+subWindowHandler);
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		Thread.sleep(4000);
		if(clickOnSelectValuesButtonAtHCCustomerTypeFilter())
			if(CheckProviderCheckBoxAtSelectValuesPopUp() && CheckMemberCheckBoxAtSelectValuesPopUp())
				if(ClickOnSUbmitAtSelectValuesPopUp()) {
					Thread.sleep(2000);
					if(validateMemberAndProviderIsSelected())
						if(ClickOnSUbmitAtAllFiltersPage())
							flag = true;
				}
		return flag;
	}

	@FindBy(xpath="//*[@name='$PpyReportContentPage$ppyReportDefinition$ppyUI$ppyBody$ppyUIFilters$ppyFilter$l9$ppyFilterValue']")
	WebElement ValueSectionTextBox;

	@FindBy(xpath="//*[@name='$PpyReportContentPage$ppyReportDefinition$ppyUI$ppyBody$ppyUIFilters$ppyFilter$l6$ppyFilterValue']")
	WebElement ValueSectionTextBox1;

	@FindBy(xpath="//*[@name='$PpyReportContentPage$ppyReportDefinition$ppyUI$ppyBody$ppyUIFilters$ppyFilter$l8$ppyFilterValue']")
	WebElement ValueSectionTextBox2;

	public boolean validateMemberIsSelected() {
		boolean flag= false;
		if(!utils.isProxyWebelement(ValueSectionTextBox))
			flag= ValueSectionTextBox.getAttribute("value").contains("Member");
		else if(!utils.isProxyWebelement(ValueSectionTextBox2))
			flag= ValueSectionTextBox2.getAttribute("value").contains("Member");
		else
			flag= ValueSectionTextBox1.getAttribute("value").contains("Member");
		return flag;
	}

	public boolean validateProviderIsSelected() {
		boolean flag= false;
		if(!utils.isProxyWebelement(ValueSectionTextBox))
			flag= ValueSectionTextBox.getAttribute("value").contains("Provider");
		else if(!utils.isProxyWebelement(ValueSectionTextBox2))
			flag= ValueSectionTextBox2.getAttribute("value").contains("Provider");
		else
			flag= ValueSectionTextBox1.getAttribute("value").contains("Provider");
		return flag;

	}

	public boolean validateMemberAndProviderIsSelected() {

		boolean flag= false;
		if(!utils.isProxyWebelement(ValueSectionTextBox))
			flag= ValueSectionTextBox.getAttribute("value").contains("\"Member\",\"Provider\"");
		else if(!utils.isProxyWebelement(ValueSectionTextBox2))
			flag= ValueSectionTextBox2.getAttribute("value").contains("\"Member\",\"Provider\"");
		else
			flag= ValueSectionTextBox1.getAttribute("value").contains("\"Member\",\"Provider\"");
		return flag;
	}

	@FindBy(xpath="(//a[@data-test-id='20141006144255036853503'])[1]")
	WebElement lnkOperatirSkills;

	@FindBy(xpath="//a[text()='Export to PDF']")
	WebElement lnkExport;


	public boolean clickOperatorBySkills()
	{
		return utils.clickAnelemnt(lnkOperatirSkills, "MyReports", "Operator Skill");
	}

	public boolean navigateToTheReportWindowAndClickExportToPDF() throws InterruptedException
	{


		boolean flag = false;
		Thread.sleep(4000);
		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		System.out.println("Number"+handles.size());
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
			System.out.println("subWindowHandler"+subWindowHandler);
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		Thread.sleep(2000);
		return utils.clickAnelemnt(lnkExport, "MyReports", "Export");

	}

	public boolean clickOpenInPDF() throws AWTException
	{

		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		return true;
	}


	//Sprint 4.4

	@FindBy(xpath="//a[@data-test-id='2014092907352606604177'][text()='Floor support']")
	WebElement FloorSupportReportsLink;

	@FindBy(xpath="//a[@data-test-id='20141006144255036853503'][contains(text(),'User Skill assignments')]")
	WebElement lnkUserSkillAssignment;

	@FindBy(id="pyWorkGroup")
	WebElement drpdownFloorsupportReportWorkGroup;

	@FindBy(xpath="//tr[contains(@id,'$PpgRepPgSubSectionWorkGroupAndManagerFilters3$ppxResults')]")
	WebElement FloorsupportReportReportingManager;

	@FindBy(xpath="//button[@class='buttonTdButton']")
	WebElement submitInFloorSupportPopUp;


	public boolean clickOnFloorSupportReport()
	{
		return utils.clickAnelemnt(FloorSupportReportsLink, "MyReports", "FloorSupportReportsLink");
	}

	public boolean clickOnUserSkillAssignmentWorkGroupOrManager()
	{
		return utils.clickAnelemnt(lnkUserSkillAssignment, "MyReports", "lnkUserSkillAssignment");
	}

	public boolean selectWorkGroupForFloorSupportReport(String[] args)
	{
		try{
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+handles.size());
			Iterator<String> iterator= handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow);
			String title = Driver.pgDriver.getTitle();
			System.out.println("Title of the Child Window is: "+title);
			if(title.contains("pzRRDisplayCustomFilterSection")){
				System.out.println("Window switched");
				if(utils.selectDropDownbyVisibleString(drpdownFloorsupportReportWorkGroup, args[0], "PopUp Window", "drpdownFloorsupportReportWorkGroup"))
					return utils.clickAnelemnt(submitInFloorSupportPopUp, "MyReports", "submitInFloorSupportPopUp");
			}else{
				System.out.println("Window switched failed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured::"+e);
			return false;
		}
		return false;
	}

	public boolean selectReportingManagerForFloorSupportReport(String[] args)
	{
		try{
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+handles.size());
			Iterator<String> iterator= handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow);
			String title = Driver.pgDriver.getTitle();
			System.out.println("Title of the Child Window is: "+title);
			if(title.contains("pzRRDisplayCustomFilterSection")){
				System.out.println("Window switched");
				if(utils.enterTextinAnelemnt(FloorsupportReportReportingManager, args[0], "PopUp Window", "FloorsupportReportReportingManager"))
					if(utils.clickAnelemnt(FloorsupportReportReportingManager, "PopUp Window", "FloorsupportReportReportingManager"))
						return utils.clickAnelemnt(submitInFloorSupportPopUp, "MyReports", "submitInFloorSupportPopUp");
			}else{
				System.out.println("Window switched failed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception occured::"+e);
			return false;
		}
		return false;
	}


}
