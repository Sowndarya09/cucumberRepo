package automationLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderComposite_InteractionSection extends Driver{


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();

	public ProviderComposite_InteractionSection()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		//PageFactory.initElements(Driver.getPgDriver(), this);
		System.out.println("provider comp constructor");
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;
	
	@FindBy(xpath="//span[text()='Open Service Requests']")
	WebElement lnkMbrCompositeIntOpenServiceReq;
	
	public boolean clickOpenServiceRequestLink() {
		return utils.clickAnelemnt(this.lnkMbrCompositeIntOpenServiceReq,"Provider Composite "," Open Service Request link ");
	}
	
	@FindBy(xpath="//*[text()='View All']")
	WebElement ViewAll;
	
	public boolean clickViewAllLnkOpenServiceRequest() {
		try{
			boolean flag = OpenServiceRequestTable.isDisplayed();
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement2);
			}
			
		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
		}
		return utils.clickAnelemnt(ViewAll,"Provider Composite "," View All Link ");
	}
	
	public boolean clickViewAllLnkRecentInteraction() {
		return utils.clickAnelemnt(ViewAll,"Provider Composite "," View All Link ");
	}
	
	public boolean validateRowsInOpenServiceRequest(String[] args) {

		try{
			boolean flag = OpenServiceRequestTable.isDisplayed();
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement2);
			}
			
		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
		}
		return utils.validatetablerowbasedonvalues(OpenServiceRequestTable, args);
	}
	
	@FindBy(id="gridLayoutTable")
	WebElement PopupTable;
	
	public boolean validateRowsInOpenServiceRequestPopUp(String[] args) {
		boolean flag;
		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		String subWindowHandler = null;

		Set<String> handles = Driver.pgDriver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		flag = utils.validatetablerowbasedonvalues(PopupTable, args);
		Driver.pgDriver.switchTo().window(parentWindowHandler); 
		return flag;
		
	}
	
	@FindBy(xpath="//*[@data-test-id='201509132340070272164209']/ancestor::table[@id='gridLayoutTable']")
	WebElement OpenServiceRequestTable; 
	
	public boolean validateServiceExperienceColumnInOpenServiceRequest() {
		
		try{
			boolean flag = OpenServiceRequestTable.isDisplayed();
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement2);
			}
			
		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
		}
		
		String[] tablevalues = {"SR-ID", "Type", "Status", "Interaction Count", "Urgency", "Open Date", "Service Experience", "Caller Name"};
		return utils.validateTableRowHeader(OpenServiceRequestTable, tablevalues);
	}
	
	@FindBy(xpath="//*[text()='Interaction ID']/ancestor::table[@id='gridLayoutTable']")
	WebElement RecentInteractionTable; 
	
	public boolean validateServiceExperienceColumnInRecentInteration() {
		try{
			boolean flag = RecentInteractionTable.isDisplayed();
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement2);
			}
			
		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
		}
		String[] tablevalues = {"","Interaction ID","Created On", "Created By","", "Primary Task", "Service Experience", "Caller Name"};
		return utils.validateTableRowHeader(RecentInteractionTable, tablevalues);
	}
	
	public boolean validateRowsInRecentInteration(String[] args) {
		try{
			boolean flag = RecentInteractionTable.isDisplayed();
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement2);
			}
			
		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement2);
		}
		return utils.validatetablerowbasedonvalues(RecentInteractionTable, args);
	}
	
	public boolean validateRowsInRecentInterationPopUp(String[] args) {
		boolean flag;
		String parentWindowHandler = Driver.pgDriver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		Driver.pgDriver.switchTo().window(subWindowHandler);
		flag = utils.validatetablerowbasedonvalues(PopupTable, args);
		Driver.pgDriver.switchTo().window(parentWindowHandler); 
		return flag;
		
	}
	
	@FindBy(xpath="//*[text()='Interactions discussed with contact']")
	WebElement InteractionsDiscussedWithContact;
	
	public boolean displayInteractionsDiscussedWithContactCheckbox() {
		return !utils.isProxyWebelement(InteractionsDiscussedWithContact);
	}
	
	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']")
	WebElement inquiryTracker;
	
	
	public boolean expandRecentInquiryTracking()
	{
		return utils.clickAnelemnt(inquiryTracker, "Interaction tab - provider composite", "expand Inquiry tracking");
	}
	
	@FindBy(xpath="//div[@data-test-id='201808312312480146216750']")
	WebElement errorMsg;
	
	public boolean verifyRecentInquiryTrackingisBlank() {
		String text = errorMsg.getText();
		String actualText = "A Member/Policy must be selected.";
		return utils.isvalueMatch_contain(text, actualText);
	}
	
	@FindBy(xpath="//table[@pl_prop_class='Antm-FW-CSFW-Data-IQTInquiry']//tr[@id='Grid_NoResults']")
	WebElement tblnqTracking;

	public boolean validateNoInquiryTrackingMessage()
	{
	String text = tblnqTracking.getText();
	String actualText = "No Inquiry Tracking Records found for this policy";
	return utils.isvalueMatch_contain(text, actualText);
	}
	
	@FindBy(xpath="//table[@pl_prop_class='Antm-FW-CSFW-Data-IQTInquiry']")
	WebElement tblInquiryTracking;

	
	public boolean validateRecentInquiryTrackingDetails(String[] args)
	{
		return utils.validatetablerowbasedonvalues(tblInquiryTracking, args);
	}
	
	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']//following::button[@data-test-id='20150916191400067155890']")
	WebElement btnViewAll;
	
	public boolean clickViewAllInRecentInquiryTracking()
	{
		return utils.clickAnelemnt(btnViewAll, "Interaction tab - provider composite", "View all button");
	}
	
	static String parentWindow,switchedWin;

	public boolean validateRecentInquiryTrackingDetailsInViewAllWindow(String[] args)
	{
		boolean flag=false;
		parentWindow = pgDriver.getWindowHandle();
		Set<String> allWindows = pgDriver.getWindowHandles();
		List<String> windowSwitch = new ArrayList<String>();
		windowSwitch.addAll(allWindows);
		int size = allWindows.size();
		switchedWin = windowSwitch.get(size-1);
		pgDriver.switchTo().window(switchedWin);
		flag = utils.validatetablerowbasedonvalues(tblInquiryTracking, args);
		pgDriver.switchTo().window(parentWindow);
		return flag;		
	}
	
	@FindBy(xpath="//button[@data-test-id='201512080043460660114874']")
	WebElement btnLoadMore;
	
	public boolean clickLoadMoreDataInViewAllWindow() {
		boolean flag=false;
		pgDriver.switchTo().window(switchedWin);
		flag= utils.clickAnelemnt(btnLoadMore, "View all - inquiry tracking", "load more button");
		pgDriver.switchTo().window(parentWindow);
		return flag;
	}
	
	public boolean clickCloseinViewAll() {
		pgDriver.switchTo().window(switchedWin).close();
		pgDriver.switchTo().window(parentWindow);
		if(pgDriver.getWindowHandle().contains(parentWindow))
		{
			return true;
		}else
		{
			System.out.println("The parent window is not switched");
			return false;
		}
		
	}
	
}







