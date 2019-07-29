package automationLib;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class FirstImpression_InteractionsSection 
{

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;



	public FirstImpression_InteractionsSection() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	@FindBy(xpath="//span[contains(text(),'Open Service Requests')]")
	WebElement clickTxtOpenServiceRequests;

	@FindBy(xpath="//span[contains(text(),'Recent Interactions')]")
	WebElement clickTxtRecentInteractions;

	@FindBy(xpath="//span[contains(text(),'Recent Inquiry Tracking')]")
	WebElement clickTxtRecentInquiryTracking;

	@FindBy(xpath="//table[@pl_prop='D_FIOpenServiceItems.pxResults']")
	WebElement tblOpenServiceRequestsHeaderRow;

	@FindBy(xpath="//table[@pl_prop='D_FIMemberInteractions.pxResults']")
	WebElement tblRecentInteractionsHeaderRow;

	@FindBy(xpath="//table[@pl_prop='D_IQTInquiryList.pxResults']")
	WebElement tblRecentInquiryTrackingHeaderRow;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOpenServiceRequests
	 * #Description: This functionality performs clicking action on Open Service Requests section
	 * Type: Textbox 
	 */
	public boolean clickOpenServiceRequests()
	{
		if(utils.clickAnelemnt(clickTxtOpenServiceRequests, "FirstImpression_InteractionsSection", "Open Service Request"))
			return utils.clickAnelemnt(clickTxtOpenServiceRequests, "FirstImpression_InteractionsSection", "Open Service Request");
		return false;

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickRecentInteractions
	 * #Description: This functionality performs clicking action on Recent Interaction section
	 * Type: Textbox 
	 */

	public boolean clickRecentInteractions()
	{
		if(utils.clickAnelemnt(clickTxtRecentInteractions, "FirstImpression_InteractionsSection", "Recent Interactions"))
			return utils.clickAnelemnt(clickTxtRecentInteractions, "FirstImpression_InteractionsSection", "Recent Interactions");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickRecentInquiryTracking
	 * #Description: This functionality performs clicking action on Recent Inquiry Tracking section
	 * Type: Textbox 
	 */

	public boolean clickRecentInquiryTracking()
	{
		WebElement element = clickTxtRecentInquiryTracking;
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		return utils.clickAnelemnt(clickTxtRecentInquiryTracking, "FirstImpression_InteractionsSection", "Recent Inquiry Tracking");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateOpenServiceRequestsHeaderRowValues
	 * #Description: This functionality performs validating action on the Open Service Requests Header Section
	 * Type: Textbox 
	 */

	public boolean validateOpenServiceRequestsHeaderRowValues() throws InterruptedException 
	{
		//utils.waitforpageload();		
		WebElement element = tblOpenServiceRequestsHeaderRow;
		utils.scrolltomiddle();
//		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
//		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		String[] openReqColHdrs = {"SR-ID ", "Type", "Status", "Interaction Count", "Urgency", "Open Date", "Contact Name"};
		return utils.validateTableRowHeader(tblOpenServiceRequestsHeaderRow, openReqColHdrs);
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateRecentInteractionsHeaderRowValues
	 * #Description: This functionality performs validating action on the Recent Interactions Header Section
	 * Type: Textbox 
	 */

	public boolean validateRecentInteractionsHeaderRowValues() 
	{
	utils.scrolltomiddle();
		WebElement element = tblRecentInteractionsHeaderRow;
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		String[] colHdrs= {" ", "Interaction ID", "Created On", "Created By", " ", "Primary Task", "Contact Name"};
		return utils.validateTableRowHeader(tblRecentInteractionsHeaderRow, colHdrs);
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateRecentInquiryTrackingHeaderRowValues
	 * #Description: This functionality performs validating action on the Recent Inquiry Tracking Header Section
	 * Type: Textbox 
	 */

	public boolean validateRecentInquiryTrackingHeaderRowValues() 
	{
		utils.waitforpageload();
		WebElement element = tblRecentInquiryTrackingHeaderRow;
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		String[] RecentInquiryColHdrs = {"IQT #", "Date Opened", "Status", "Description", "Contact Name"};
		return utils.validateTableRowHeader(tblRecentInquiryTrackingHeaderRow, RecentInquiryColHdrs);

	}



}
