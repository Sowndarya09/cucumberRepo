package automationLib;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ReadFile;
import utils.ErrorLogger;
import utils.SeleniumUtilities;


/**
 * Class To validate the values from the page to that of the transactions brought about after a Call 
 * @author Shardul Negi & Gautham ;)
 *
 *REview  Interaction 
 * @param <K>
 * @param <V>
 */
public class ReviewInteraction extends Driver {


	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(pgDriver,10);
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCreatePromisedAction;
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement1;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement2;

	public static Map<String, String> valuesfromapp = new HashMap<String, String>();
	public static Map<String, String> valuesfromReviewInteractionpg = new HashMap<String, String>();

	BaseLogger blogger=new BaseLogger();
	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public ReviewInteraction()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	/*
	 * Headers for the Page 
	 */
	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Wrap Up Comments')]")
	WebElement headerWrapUpComment;
	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Service Requests Created')]")
	WebElement headerSerRequestCreated;
	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Service Requests Review')]")
	WebElement headerSerRequestReviewdInteraction;
	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Related IQT')]")
	WebElement headerRelatedIQT;
	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Items Discussed During Composite Review')]")
	WebElement headerItemsduringcompositeReview;
	@FindBy(xpath= "//*[@class='header-element header-title'][contains(text(),'Related/Linked Interactions')]")
	WebElement headerLinkdRelatedInteraction;

	/* Review Interaction header values
	 * 
	 * 
	 */
	@FindBy(xpath="//div[@node_name='CPMReviewInteractionWorkHeader']//label[@for='pyID']/parent::div//span")
	WebElement labelInteractionID;
	@FindBy(xpath="//div[@node_name='CPMReviewInteractionWorkHeader']//label[@for='OverallStatus']/parent::div//span")
	WebElement labelInteractionstatus;

	@FindBy(xpath="//div[@node_name='CPMReviewInteractionWorkHeader']//label[@for='ContactName']/parent::div//span")
	WebElement labelInteractionMemberName;

	@FindBy(xpath="//div[@node_name='CPMReviewInteractionWorkHeader']//label[@for='pxCreateOpName']/parent::div//span")
	WebElement labelInteractionUserName;

	//*[text()=' Research and Add Task']

	// Buttons 
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Close']")
	WebElement btnClose;
	@FindBy(xpath="//*[contains(text(),'Research and Add Task')]")
	WebElement btnAddTask;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Refresh']")
	WebElement btnRefresh;

	//CLOSE BUTTON FOR a INTERACTION
	@FindBy(xpath="//div[@node_name='CPMPortalRecent']//a[@data-ctl='Icon']")
	WebElement closecurrenttab;

	/*
	 * Read date from various sources 
	 * 
	 */

	@FindBy(xpath= "//label[@for='WrapUpComments']/parent::div//span")
	WebElement lnkWrapUpcomment;
	@FindBy(xpath= "//*[contains(@class,'inline_grid_quad')]//*[contains(@class,'item-4 remove-all')]//*[contains(@class,'ValueRead')]")
	WebElement lnkContactName;
	@FindBy(xpath= "//*[contains(@class,'inline_grid_quad')]//*[contains(@class,'item-3 remove-all')]//*[contains(@class,'item-1 remove-bottom')]//*[contains(@class,'ValueRead')]")
	WebElement lnkPrimaryTask;
	@FindBy(xpath= "//*[contains(@class,'inline_grid_quad')]//*[contains(@class,'item-3 remove-all')]//*[contains(@class,'item-2 remove-bottom')]//*[contains(@class,'ValueRead')]")
	WebElement lnkCreatedBy;
	@FindBy(xpath= "//*[contains(@class,'inline_grid_quad')]//*[contains(@class,'item-2 remove-all')]//*[contains(@class,'item-2 remove-bottom')]//*[contains(@class,'ValueRead')]")
	WebElement lnkCallBackNo;
	@FindBy(xpath= "//*[contains(@class,'inline_grid_quad')]//*[contains(@class,'item-2 remove-all')]//*[contains(@class,'item-1 remove-bottom')]//*[contains(@class,'ValueRead')]")
	WebElement lnkCreatedON;
	@FindBy(xpath= "//*[contains(@class,'inline_grid_quad')]//*[contains(@class,'item-2 remove-all')]//*[contains(@class,'item-3 remove-bottom')]//*[contains(@class,'ValueRead')]")
	WebElement lnkExt;


	@FindBy(xpath= "//*[contains(@class,'inline_grid_quad')]//*[contains(@class,'item-1 remove-all')]//*[contains(@class,'item-4')]//*[contains(@class,'-1')]//*[contains(@class,'ValueRead')]")
	WebElement lnkServiceRqstStatus;
	@FindBy(xpath= "//*[contains(@class,'inline_grid_quad')]//*[contains(@class,'item-1 remove-all')]//*[contains(@class,'item-4')]//*[contains(@class,'-2')]//*[contains(@class,'ValueRead')]")
	WebElement lnkIQTStatus;

	/**
	 * Tables in the Sheet 
	 */


	@FindBy(xpath= "//*[contains(@datasource,'ItemsDiscussedDuringInteractio')]//table[contains(@class,'ReadOnly')]//table")
	WebElement tableItemsDuringCompositeReview;
	@FindBy(xpath= "//table[contains(@pl_prop,'CasesReviewedDuringInteraction')]")
	WebElement tableserviceReqstDuringInteraction;

	@FindBy(xpath= "//table[contains(@pl_prop,'IQTInquiryList')]")
	WebElement tableIQTList;

	@FindBy(xpath= "//table[contains(@pl_prop,'Linked')]")
	WebElement tableLinkedInteraction;

	@FindBy(xpath="//*[contains(@node_name,'CPMReviewCasesInInteraction')]//table[@id='gridLayoutTable']//table")
	WebElement tableServiceRequestCreated;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Link Interaction']")
	WebElement btnLinkInteration;

	public boolean clickBtnClose()
	{
		return utils.clickAnelemnt(this.btnClose , "REview Interaction", "Close Button");
	}			

	public boolean clickBtnAddTask()
	{
		return utils.clickAnelemnt(this.btnAddTask , "REview Interaction", "ADD Task");
	}	
	public boolean clickBtnRefresh()
	{
		return utils.clickAnelemnt(this.btnRefresh , "REview Interaction", "Refresh");
	}	
	public boolean clicklnkServiceRequest()
	{
		return utils.clickAnelemnt(this.headerSerRequestCreated , "REview Interaction", "Service Request");
	}
	public boolean clickheaderWrapUpComment()
	{
		return utils.clickAnelemnt(this.headerWrapUpComment , "REview Interaction", "Wrap Up");
	}
	public boolean clicklnkItemsduringCompositeReviewt()
	{
		return utils.clickAnelemnt(this.headerItemsduringcompositeReview , "REview Interaction", "Composite Review");
	}
	public boolean clicklnkRelatedIQT()
	{
		return utils.clickAnelemnt(this.headerRelatedIQT , "REview Interaction", "Related IQT");
	}
	public boolean clicklnkServiceRequestReviewed()
	{
		return utils.clickAnelemnt(this.headerSerRequestReviewdInteraction , "REview Interaction", "Serivice Request Review Intearction");
	}


	public boolean clicklnkLinkedRelatedInteraction()
	{
		return utils.clickAnelemnt(this.headerLinkdRelatedInteraction , "REview Interaction", "Linked/Related Interaction");
	}
	// checking  the Value from the sheet 

	// Wrap comment 
	public boolean checkWrapUp()
	{

		if(this.headerWrapUpComment.isDisplayed())
			if(!this.lnkWrapUpcomment.isDisplayed())
				if(this.clickheaderWrapUpComment())
					System.out.println("Clicked on the Service Request header");
			// Comments 
			String str= this.lnkWrapUpcomment.getText().trim();
			return utils.isvalueMatch_contain(str, "Wrap Up comment");
	}




	/**
	 * Service Request Created during Interaction 
	 * @return
	 * @throws Exception 
	 */

	/* Creates interaction till VerifyMember*/

	public boolean CreateInteraction() throws Exception
	{
		PhoneCallMembersearchMember ph=new PhoneCallMembersearchMember();
		ph.searchBySuscriberSSN("222400017,sample".split(","));
		ph.fillNicknameandextension();
		ph.selectMemberbyFirstName("NOWAITPERIOD,sample".split(","));
		Thread.sleep(5000);
		ph.selectContractMemberandSubmit("Yes,sample".split(","));


		VerifyMember vr=new VerifyMember();
		String[] args={"name:NOWA","address:a","dob:/"};
		return vr.verifymemberdetails(args);
	}

	public boolean ValidateReviewInteractionHeaderDetailsandNoItemsDiscussed() throws Exception
	{

		this.CreateInteraction();
		InteractionHeader ir=new InteractionHeader();
		valuesfromapp.put("InteractionID", ir.getInteractionID());

		String membername=ir.getMemberName();
		valuesfromapp.put("membername", membername);

		Header hr=new Header();
		valuesfromapp.put("username", hr.getUserName());
		//valuesfromapp.put("username", "Vig");		

		closecurrentinteraction();
		Home h=new Home();
		h.checkandclickRecentInteraction();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame("PegaGadget1Ifr");

		valuesfromReviewInteractionpg.put("InteractionID",this.labelInteractionID.getText());
		valuesfromReviewInteractionpg.put("membername",this.labelInteractionMemberName.getText());
		valuesfromReviewInteractionpg.put("username",this.labelInteractionUserName.getText());
		System.out.println(valuesfromapp+"-----------"+valuesfromReviewInteractionpg);
		equalMaps(valuesfromapp,valuesfromReviewInteractionpg);
		if(valuesfromapp.equals(valuesfromReviewInteractionpg))
			System.out.println("Both are same");
			if(utils.clickAnelemnt(this.headerSerRequestCreated, "review Interaction", "header link"))
			if(utils.clickAnelemnt(this.headerSerRequestReviewdInteraction, "review Interaction", "header link"))
			if("No Items Discussed".toLowerCase().contains(Driver.pgDriver.findElement(By.xpath("//*[contains(@datasource,'ItemsDiscussedDuringInteractio')]//tr[@id='Grid_NoResults']//td")).getText().toLowerCase()))	
				if("No additional associated service requests".toLowerCase().contains(Driver.pgDriver.findElement(By.xpath("//*[contains(@node_name,'CPMSRCasesReviewedDuringInteraction')]//tr[@id='Grid_NoResults']//td")).getText().toLowerCase()))
					if("No associated service requests".toLowerCase().contains(Driver.pgDriver.findElement(By.xpath("//*[contains(@node_name,'CPMReviewCasesInInteraction')]//tr[@id='Grid_NoResults']//td")).getText().toLowerCase()))
						if("No comments captured".toLowerCase().contains(Driver.pgDriver.findElement(By.xpath("//*[contains(@node_name,'WrapUpComments')]//div[@class='field-item dataValueRead']//span")).getText().toLowerCase()))
							return true;
				return false;
	}
		
	public boolean equalMaps(Map<String, String> valuesfromapp2, Map<String, String> valuesfromReviewInteractionpg2)
	{
		if (valuesfromapp2.size() != valuesfromReviewInteractionpg2.size())
			return false;
		for (String key: valuesfromapp2.keySet())
			if (!valuesfromapp2.get(key).equals(valuesfromReviewInteractionpg2.get(key)))
			{
				err.logError("Review Interaction", "the values in the application and review interaction page doesnt match for the "+key);
				System.out.println("the values in the application and review interaction page doesnt match for the "+key);
				return false;
			}
		System.out.println("Values match");   
		return true;
	}

	@FindBy(xpath="//button[@id='ModalButtonSubmit']")
	WebElement btnModalSubmit;

	public boolean closecurrentinteraction() throws InterruptedException
	{
			Thread.sleep(2000);
			if(utils.clickAnelemnt(closecurrenttab, "ReviewInteraction", "Close"))
				if(utils.clickAnelemnt(btnModalSubmit, "ReviewInteraction", "Submit"))
					return true;
			return false;
	}


	public boolean ValidateSRcreatedandWrapupComments() throws Exception
	{
		ArrayList<String> resolvedvalue=new ArrayList<String>();
		this.CreateInteraction();	
		MemberComposite mc=new MemberComposite();
		mc.clickchkbxcontractinfodiscussed();
		mc.navigateTOBenefitsandCost();
		BenefitsSelection bs=new BenefitsSelection();
		bs.clickonBrowse();
		bs.checkforpageload();
		bs.clickgetBtnSubmit();
		wait.until(ExpectedConditions.alertIsPresent());
		Driver.pgDriver.switchTo().alert().accept();
		CompleteBenefitsReview cbr=new CompleteBenefitsReview();
		cbr.RequestBenefitVerficationSubmit();
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		mc.clickwrapUp();
		WrapUp wr=new WrapUp();
		wr.clickWrapUpBenefitsandCostSubmit();
		Header hr=new Header();
		String nameofthecreator=hr.getUserName();

		Home h=new Home();
		h.checkandclickRecentInteraction();

		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame("PegaGadget1Ifr");
		utils.clickAnelemnt(this.headerSerRequestCreated, "review Interaction", "header link");
		utils.clickAnelemnt(this.headerSerRequestReviewdInteraction, "review Interaction", "header link");

		DateFormat formatter ; 
		Date todaydate=new Date();
		formatter = new SimpleDateFormat("MM/dd/yyyy");

		String datecheck=formatter.format(todaydate);
		System.out.println(datecheck);
		if(this.labelInteractionstatus.getText().contains("Resolved"))
			if(this.lnkWrapUpcomment.getText().contains("Wrap Up Comment"))
			{
				String[] rowvalue1={"","S-","NOWAITPERIOD CANCEL","Benefits and Co","Resolved-Completed",nameofthecreator,datecheck,datecheck};

				if(utils.validateRowValues(this.tableServiceRequestCreated,rowvalue1))
					resolvedvalue=utils.getcolumnStringFromTableByName(this.tableServiceRequestCreated, "resolved ");
					System.out.println("Resolved val "+resolvedvalue+"datecheck "+datecheck);
					if(resolvedvalue.get(1).contains(datecheck))
						return true;
				}
			return false;

	}

	public boolean ValidateServiceRequestsCreated() throws Exception
	{
		if(this.ValidateSRcreatedandWrapupComments())
		{
			String[] rowvalueItemsDuring={"NOWAITPERIOD","0TK9","Contract information discussed with contact"};
			if(utils.validateRowValues(this.tableItemsDuringCompositeReview, rowvalueItemsDuring))
				return true;
		}
				return false;
			
	}

	public boolean ValidateServiceRequestsReviewed() throws Exception
	{
		ArrayList<String> resolvedvalue=new ArrayList<String>();
		this.CreateInteraction();	
		MemberComposite mc=new MemberComposite();
		mc.ClickonRecentServiceRequest();
		String SRreviewed=mc.getRecentSRID();
		String SRtype=mc.getRecentSRType();
		String SRstatus=mc.getRecentSRStatus();
		String[] rowvalueItemsDuring={"",SRreviewed,"NOWAITPERIOD",SRtype,SRstatus,"","/",""};
		Driver.pgDriver.switchTo().defaultContent();
		closecurrentinteraction();
		Home h=new Home();
		h.checkandclickRecentInteraction();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame("PegaGadget1Ifr");
		utils.clickAnelemnt(this.headerSerRequestReviewdInteraction, "review Interaction", "header link");
		utils.validateRowValues(this.tableserviceReqstDuringInteraction, rowvalueItemsDuring);
		if(Driver.pgDriver.findElement(By.xpath("//table[contains(@pl_prop,'CasesReviewedDuringInteraction')]//a")).getText().contains(SRreviewed))
			return true;
			return false;

	}

	public boolean ValidateLinkInteractionsTable() throws Exception
	{

		this.CreateInteraction();	
		MemberComposite mc=new MemberComposite();
		mc.LinkRecentInteraction();
		String intid=mc.getRecentInteractionID();
		Driver.pgDriver.switchTo().defaultContent();
		closecurrentinteraction();
		Home h=new Home();
		h.checkandclickRecentInteraction();
		ArrayList<String> interactionid=new ArrayList<String>();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame("PegaGadget1Ifr");
		utils.clickAnelemnt(this.headerLinkdRelatedInteraction, "Review Interaction", "Linked Interaction Header");
		interactionid=utils.getcolumnStringFromTableByName(this.tableLinkedInteraction, "Interaction ID");
		System.out.println("Hello"+interactionid.get(1)+intid);
		if(interactionid.get(1).contains(intid))
			if(utils.isProxyWebelement(this.btnLinkInteration))
			return true;	
		return false;

	}

	public boolean ValidaterelatedIQTandMultipleSR() throws Exception
	{
		this.CreateInteraction();	
		MemberComposite mc=new MemberComposite();
		mc.navigateTOManageClaims();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(this.Iframeelement1);
		mc.navigatetoExternalSearch();
		ExternalSearch es=new ExternalSearch();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(this.Iframeelement2);
		es.clickbtnSubmit();
		Driver.pgDriver.switchTo().defaultContent();
		closecurrentinteraction();
		Home h=new Home();
		h.checkandclickRecentInteraction();
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame("PegaGadget1Ifr");

		if(utils.clickAnelemnt(this.headerSerRequestCreated, "review Interaction", "header link"))
		if(utils.clickAnelemnt(this.headerSerRequestReviewdInteraction, "review Interaction", "header link"))
		if(this.labelInteractionstatus.getText().contains("Open"))
		{

			ArrayList<String> temp,resolvedstatus=new ArrayList<String>();
			temp=utils.getcolumnStringFromTableByName(this.tableServiceRequestCreated, "Service Request");
			resolvedstatus=utils.getcolumnStringFromTableByName(this.tableServiceRequestCreated, "Resolved");
			System.out.println(""+temp+resolvedstatus);
			try{
				if(temp.get(1).contains("External Search")||temp.get(2).contains("Manage Clai"))
				{
					System.out.println("Order is perfect");
					//return true;
				}
				else
				{
					System.out.println("Wrong order in table");
					return false;
				}
				if(resolvedstatus.get(1).contains("/")||resolvedstatus.get(2).isEmpty())
					return true;
			}
			catch(NullPointerException e)
			{
				System.out.println("Something wrong with the arraylist values . table values might be less than expected");
				return false;
			}
			catch(Exception e)
			{
				System.out.println(e+"Something wrong with the arraylist values . table values might be less than expected");
				return false;
			}


		}
		else
			return false;
		return false;
	}

	/*
	 * 
	 * mc.navigateTOPromisedAction();

		Driver.pgDriver.switchTo().defaultContent();
		closecurrentinteraction();
		Home h=new Home();
		Driver.pgDriver.switchTo().defaultContent();
		h.sHeaderHome.click();
		Header hr=new Header();
		hr.createNewInteractionPhoneCallmember();
		this.CreateInteraction();
	 */


	@FindBy(linkText="Interaction Summary")
	private WebElement linkInteractionSummary;

	public boolean validate_Interaction_Summary_Link(){
		utils.waitforpageload();
		return !utils.isProxyWebelement(linkInteractionSummary);

	}

	@FindBy(linkText="Interaction Overview")
	private WebElement linkInteractionOverview;

	public boolean validate_Interaction_Overview_Link(){
		utils.waitforpageload();
		try {
			return utils.clickAnelemnt(this.linkInteractionSummary, "ReviewInteraction", "linkInteractionSummary");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (linkInteractionOverview.isDisplayed()){
				return true;
			}
			else
				err.logError("ReviewInteraction:linkInteractionOverview is not displayed");
			return false;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			err.logError("ReviewInteraction:linkInteractionOverview is not displayed");
			return false;
		}

	}

	@FindBy(xpath="//*[@class='content-item content-field item-1   ']//*[@data-test-id='2015092601500402014442']")
	WebElement InteractionID;

	@FindBy(xpath="//*[@class='content-item content-field item-1   ']//*[@data-test-id='2015092601500402014442']")
	WebElement labelServiceFromDate;

	@FindBy(xpath="//*[@class='content-item content-field item-1 remove-bottom-spacing   ']//*[@data-test-id='2015092601500402014442']")
	WebElement CreatedOn;

	@FindBy(xpath="//*[@data-test-id='20150926015004020141507']")
	WebElement CreatedBy;

	public boolean ValidateInteractionDetails(String[] args) {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("ReviewInteractions", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"InteractionID")){
				returnvar = utils.validateLabel(InteractionID, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Status")){
				returnvar = utils.validateLabel(labelServiceFromDate,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"CreatedOn")){
				returnvar = utils.validateLabel(CreatedOn,value);
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"CreatedBy")){
				returnvar = utils.validateLabel(CreatedBy,value);
				continue;
			}
			else 
				err.logcommonMethodError("Review Interaction", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;


		}
		if(returnvar)
		{
			return true;	
		}
		else
		{
	
			err.logcommonMethodError("Review Interaction", "the value doesnt match with the one in application");
			return false;
		}

	}
	
	@FindBy(xpath="//*[@data-test-id='20160103160331001953614']")
	WebElement WrapUpComments;
	
	public boolean ValidateWrapUpComments(String[] args) {
		return utils.validateLabel(WrapUpComments, args[0]);
	}
	
	@FindBy(xpath="//*[text()='Service Requests Reviewed during Interaction']")
	WebElement ServiceRequestReviewLink;
	
	@FindBy(xpath="//*[text()='Provider Name']/ancestor::table[@class='gridTable ']")
	WebElement ServiceRequestReviewTable;
	
	public boolean ValidateServiceRequestsReviewedDuringInteraction(String args[]) {
		utils.clickAnelemnt(ServiceRequestReviewLink, "ReviewInteraction", "ServiceRequestReviewLink");
		return utils.validatetablerowbasedonvalues(ServiceRequestReviewTable, args);
	}
	
	@FindBy(xpath="//*[text()='Contact Name']")
	WebElement ContactNameLbl;
	
	public boolean displayContactName() {
		return !utils.isProxyWebelement(ContactNameLbl);
	}
	
	public boolean clickItemsDiscussedDuringViewProgram()
	{
		return utils.clickAnelemnt(this.lnkItemsDiscussed, "ViewProgramReview", "Item Discussed");
	}
	
	@FindBy(xpath="//table[@pl_prop='.IncentiveProgramsReviewed']")
	private WebElement productsTable;
	
	public boolean verifyThatTheViewProgramInformationUnderItemsDiscussed(String[] tablevalues) throws InterruptedException
	{
		    Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);// change the driver 
			if(this.clickItemsDiscussedDuringViewProgram())
			return utils.clickontablerowbasedonvalues(this.productsTable,tablevalues);
		return false;
	}
	
	@FindBy(xpath="//*[contains(text(),'Items Discussed During View Programs')]")
	WebElement lnkItemsDiscussed;
	
	@FindBy(xpath="//a[@data-test-id='2017050116522603052310'][text()='Message Alerts']")
	WebElement lnkMessageAlert;

	public boolean validateMessageAlert()
	{
		return(!utils.isProxyWebelement(lnkMessageAlert));
		
	}
	
	
}

