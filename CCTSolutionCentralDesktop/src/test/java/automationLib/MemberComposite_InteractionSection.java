package automationLib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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

public class MemberComposite_InteractionSection{
	WebDriverWait wait;
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	public MemberComposite_InteractionSection()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		//PageFactory.initElements(Driver.getPgDriver(), this);

		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	//TABS__________________________________________________________________________

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Contract']")
	WebElement tabMbrCompositeContract;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Group']")
	WebElement tabMbrCompositeGroup;

	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Interactions']")
	WebElement tabMbrCompositeInteraction;

	@FindBy(xpath="//img[@alt='Loading...']")
	WebElement loadingicon;

	@FindBy(xpath="//label[text()='Loading...']")
	WebElement loadinglabel;


	@FindBy(xpath="//img[contains(@src,'addtask')]")
	WebElement btnMbrCompositeAddTask;

	@FindBy(id="ModalButtonSubmit")
	WebElement btnVerificationSubmit;

	//@FindBy(className="Wrap_up_button pzhc")
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Wrap Up']")
	WebElement btnMbrCompositeWrapup;


	//INTERACTIONS TAB

	//LINKS UNDER INTERACTIOn TAB


	@FindBy(xpath="//div[@title='Disclose Open Service Requests']")
	WebElement lnkMbrCompositeIntOpenServiceReq;

	@FindBy(xpath="//span[text()='Recent Interactions']")
	WebElement lnkMbrCompositeIntRecentInt;

	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']")
	WebElement lnkMbrCompositeIntRecentInqtrack;

	@FindBy(xpath="//span[text()='Related/Linked Interactions']")
	WebElement lnkMbrCompositeIntLinkedInt;                                    //6


	//INTERACTIONS TAB - VIEWALL AND REFRESH BUTTONS



	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']//div[text()='View All']")
	WebElement imgMbrCompositeIntOpenSerReqViewall;

	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']//div[text()='Refresh']")
	WebElement imgMbrCompositeIntOpenSerReqRefresh;

	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']//div[text()='View All']")
	WebElement imgMbrCompositeIntRecentIntViewall;

	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']//div[text()='Refresh']")
	WebElement imgMbrCompositeIntRecentInteractionrefresh;

	@FindBy(xpath="//a[contains(@data-click,'ViewAllInq')][text()='View All']")
	WebElement imgMbrCompositeIntRecentInqtrackViewall;

	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']/parent::div//img[contains(@data-click,'refresh')]")
	WebElement imgMbrCompositeIntRecentInqtrackrefresh;

	@FindBy(xpath="//span[text()='Related/Linked Interactions']/parent::div//img[contains(@data-click,'refresh')]")
	WebElement imgMbrCompositeIntLinkedIntrefresh; 



	//INTERACTION TAB - TABLES

	@FindBy(xpath="//div[@node_name='CPMHCOpenServiceCaseItemsForMemberId']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntOpenSerReq;

	@FindBy(xpath="//div[@node_name='RecentIQTTracking']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntRecentInqTrack;

	@FindBy(xpath="//div[contains(@datasource,'LinkedInteractions')]/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntRelatedIntraction;      
	
	

	//NAVIGATION to OTHER PAGES

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")
	WebElement benefitsandcost;
	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Manage Claims'][@class='Add_task']")
	WebElement manageclaims;

	@FindBy(xpath="//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")
	WebElement promisedactions;

	//ADD TASK button

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Add task(s)']")
	WebElement addtaskbutton;

	//New CHECKBBOX BUTTONS ADDED----------------

	@FindBy(id="MemberInfoReview")
	WebElement chkbxmemberinfodiscussed;

	@FindBy(id="ContractInfoReview")
	WebElement chkbxcontractinfodiscussed;

	@FindBy(id="GroupDetailsInfoReview")
	WebElement chkbxgroupinfodiscussed;

	@FindBy(id="InteractionsInfoReview")
	WebElement chkbxInteractioninfodiscussed;

	//Guided Dialog message

	@FindBy(id="DialogContent")
	WebElement labelGuidedDialog;

	//Checkbox common methods 
	
	
	public boolean verifyGuidedDialogText()
	{
			String message=this.labelGuidedDialog.getText().toString();
			return utils.isvalueMatch_contain(message, "Handle with care. Use the HIPAA Verification & Disclosure Guide link if you need help understanding what you can tell");
	}

	public boolean clickchkbxmemberinfodiscussed()
	{
			if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
				if(utils.clickAnelemnt(this.tabMbrCompositeMember, "Member Composite", "Member tab"))
					if(utils.clickAnelemnt(this.chkbxmemberinfodiscussed, "Member Composite", "Checkbox"))
					return true;
			return false;

	}

	public boolean clickchkbxgroupinfodiscussed()
	{
			if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab"))
				if(utils.clickAnelemnt(this.tabMbrCompositeGroup, "Member Composite", "Group tab"))
					if(utils.clickAnelemnt(this.chkbxgroupinfodiscussed, "Member Composite", "Checkbox"))
						return true;
			return false;

	}

	public boolean clickchkbxcontractinfodiscussed()
	{
			if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab"))
				if(utils.clickAnelemnt(this.tabMbrCompositeContract, "Member Composite", "Contract tab"))
					if(utils.clickAnelemnt(this.chkbxcontractinfodiscussed, "Member Composite", "Checkbox"))
				return true;
			return false;
	}

	public boolean clickchkbxInteractionsinfodiscussed()
	{
			if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
				if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
					if(utils.clickAnelemnt(this.chkbxInteractioninfodiscussed, "Member Composite", "Checkbox"))
				return true;
			return false;
	}






	public boolean clickwrapUp()
	{
		waitforpageload();
		return utils.clickAnelemnt(this.btnMbrCompositeWrapup, "SidePane", "Wrapup");
	}    





	public boolean checkOpenServiceRequestsTable() throws ParseException
	{
		utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{
			if(utils.isProxyWebelement(this.tableMbrCompositeIntOpenSerReq))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeIntOpenServiceReq,"Member Composite "," Open Service Request link ");

			}
			else
			{
				System.out.println("Open Service Request link is already clicked");
			}
			if(utils.isProxyWebelement(this.imgMbrCompositeIntOpenSerReqViewall))
			{
				System.out.println("No View All button");
				return false;
			}
			else if(utils.isProxyWebelement(this.imgMbrCompositeIntOpenSerReqRefresh))
			{
				System.out.println("No Refresh button");
				return false;
			}
			ArrayList<String> Dates = new ArrayList<String>();
			Dates=utils.getcolumnStringFromTableByName(this.tableMbrCompositeIntOpenSerReq, "Open Date");
			int i=2;
			System.out.println(Dates.size());
			if(Dates.size()>7)
			{
				System.out.println("There are more than 5 rows in Open Service request Table.");
				return false;
			}
			for(String iterator:Dates)	
			{

				DateFormat formatter ; 
				Date date1,date2; 
				String date_1=Dates.get(i);
				if(i+1==Dates.size())
				{
					break;
				}
				String date_2=Dates.get(i+1);
				formatter = new SimpleDateFormat("MMMM dd,yyyy");

				date1=formatter.parse(date_1);
				date2=formatter.parse(date_2);
				if(date1.equals(date2))
				{
					i++;
					continue;
				}
				else if(date1.after(date2))
				{
					i++;
					continue;
				}
				else
					System.out.println("THE DATES ARE NOT IN DESCENDING ORDER");
				return false;
			}

		}
		blogger.logMessage("Member Composite ", " Open service request validation ");
		return true;
	}

	public boolean checkRecentInteractionsTable() throws ParseException
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{
			if(utils.isProxyWebelement(this.tableMbrCompositeIntRecentInt))
			{
				utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInt,"Member Composite "," Recent Interactions link ");

			}
			else
			{
				System.out.println("Recent Interactions is already clicked");
			}
			if(utils.isProxyWebelement(this.imgMbrCompositeIntRecentIntViewall))
			{
				System.out.println("No View All button");
				return false;
			}
			else if(utils.isProxyWebelement(this.imgMbrCompositeIntRecentInteractionrefresh))
			{
				System.out.println("No Refresh button");
				return false;
			}
			ArrayList<String> Dates = new ArrayList<String>();
			Dates=utils.getcolumnStringFromTableByName(this.tableMbrCompositeIntRecentInt, "Created On");
			int i=2;
			System.out.println(Dates.size());
			if(Dates.size()>7)
			{
				System.out.println("There are more than 5 rows in Recent Interactions Table.");
				return false;
			}
			for(String iterator:Dates)	
			{

				DateFormat formatter ; 
				Date date1,date2; 
				String date_1=Dates.get(i);
				if(i+1==Dates.size())
				{
					break;
				}
				String date_2=Dates.get(i+1);
				formatter = new SimpleDateFormat("mm/dd/yyyy H:mm a");

				date1=formatter.parse(date_1);
				date2=formatter.parse(date_2);
				if(date1.equals(date2))
				{
					i++;
					continue;
				}
				else if(date1.after(date2))
				{
					i++;
					continue;
				}
				else
					System.out.println("THE DATES ARE NOT IN DESCENDING ORDER");
				return false;
			}

		}
		blogger.logMessage("Member Composite ", " Recent Interactions validation ");
		return true;
	}






	/**
	 * Table with the values of the Search for Service Request for Contracts 
	 */

	@FindBy(xpath="//*[contains(@pl_prop,'ForContractB')]")
	WebElement tableMbrCompositesearchforServiceRequestContracts;
	@FindBy(xpath="//span[contains(text(),'Search for Service Requests for Contract')]")
	WebElement lnkMbrCompositeIntSearchForServiceRequest;

	/**
	 * Table with the values of the Search for Service Request for Contracts  

	 * @return
	 * @throws ParseException
	 */
	public boolean checkSearchForServiceRequestsForContractsTable(String sMethod) throws ParseException
	{
		// Checking if the table is present or not and validating if it is already openened 
		if(utils.isProxyWebelement(this.tableMbrCompositesearchforServiceRequestContracts))
		{
			utils.clickAnelemnt(this.lnkMbrCompositeIntSearchForServiceRequest,"Member Composite "," Search for Service Request for Contract");

		}
		else
		{
			System.out.println("Open Service Request link is already clicked\n\n");
		}
		//Checking if dates are equal 

		// array list top storwe all the values and the dates in the Table 
		ArrayList<String> Dates = new ArrayList<String>();
		// wil save the values in an array list 
		Dates=utils.getcolumnStringFromTableByName(this.tableMbrCompositesearchforServiceRequestContracts, "Open Date");
		int i=2;
		System.out.println(Dates.size());
		if(Dates.size()>7)
		{
			System.out.println("There are more than 5 rows in Open Service request Table.");
			return false;
		}

		// Iterating  the dates from the stored values 
		for(String iterator:Dates)	
		{

			DateFormat formatter ; 
			Date date1,date2;
			Date date3 = null;
			String date_1=Dates.get(i);
			if(i+1==Dates.size())
			{
				break;
			}
			String date_2=Dates.get(i+1);
			formatter = new SimpleDateFormat("MMMM dd,yyyy");

			date1=formatter.parse(date_1);
			date2=formatter.parse(date_2);
			if(date1.equals(date2))
			{
				i++;
				continue;
			}
			if(sMethod=="Last 7 Days"||sMethod=="Last 30 Days"||sMethod=="Last 90 Days")
				if(date1.after(date2))
				{
					i++;
					continue;
				}
				else
					System.out.println("THE DATES ARE NOT IN DESCENDING ORDER");
			return false;
		}

		blogger.logMessage("Member Composite ", " Open service request validation ");
		return true;
	}



	// Checking Dates for the Table 

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Today']")
	WebElement btnServcRequestContractToday;

	public boolean clickServcRequestContractToday (){
		return (utils.clickAnelemnt(this.btnServcRequestContractToday, "MemberVerify", "Click Button today"));

	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Yesterday']")
	WebElement btnServcRequestContractYesterday;

	public boolean clickbtnServcRequestContractYesterday (){
		return (utils.clickAnelemnt(this.btnServcRequestContractYesterday, "MemberVerify", "Click Button Yesterday"));

	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Last 7 Days']")
	WebElement btnServcRequestContractLast7Days;

	public boolean clickbtnServcRequestContractLast7Days (){
		return (utils.clickAnelemnt(this.btnServcRequestContractLast7Days, "MemberVerify", "Click Button Last 7 Days"));

	}
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Last 90 Days']")
	WebElement btnServcRequestContractLast90Days;

	public boolean clickbtnServcRequestContractLast90Days (){
		return (utils.clickAnelemnt(this.btnServcRequestContractLast90Days, "MemberVerify", "Click Button Last 90 Days"));

	}
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Last 30 Days']")
	WebElement btnServcRequestContractLast30Days;

	public boolean clickbtnServcRequestContractLast30Days (){
		return (utils.clickAnelemnt(this.btnServcRequestContractLast30Days, "MemberVerify", "Click Button Last 30 Days"));

	}

	@FindBy(xpath="//*[@id='SearchStartDate']")
	WebElement txtbxStartDate;
	public boolean settxtbxStartDate (String[] args){

		// Checking the header 
		if(utils.validateHeader(this.lnkMbrCompositeIntSearchForServiceRequest, "Search for Service Requests for Contract"))
			try
		{
				return utils.enterTextinAnelemnt(this.txtbxStartDate, args[0], "MemberVerify", "Nickname textbox");
		}
		catch(StaleElementReferenceException e)
		{
			settxtbxStartDate(args);	
		}
		catch(NoSuchElementException e){
			settxtbxStartDate(args);	
		}
		return true;

	}



	// entering the value for the two dates in the pace 
	@FindBy(xpath="//*[@id='SearchEndDate']")
	WebElement txtbxEndtDate;
	public boolean settxtbxEndDate (String[] args){
		try
		{
			return utils.enterTextinAnelemnt(this.txtbxEndtDate, args[0], "MemberVerify", "Nickname textbox");
		}
		catch(StaleElementReferenceException e)
		{
			settxtbxStartDate(args);	
		}
		catch(NoSuchElementException e){
			settxtbxStartDate(args);	
		}
		return true;

	}




	/**
	 * Ente4r the start and end date and the table will check if the dates are alligned in a proper Sequence 
	 * @param args : enter the start and Sto date 
	 * @return
	 * @throws ParseException
	 */
	//*[@id='SearchEndDate']
	public boolean checkDateByClickingButtonsToday(String[] args) throws ParseException
	{
		// click ing on the value for the tab 
		utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab");
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
		{			
			if(this.clickServcRequestContractToday())
			{
				if(this.checkSearchForServiceRequestsForContractsTable(""))
				{
					return true;
				}
			}
		}
		return false;	


	}

	public boolean checkDateByClickingButtonsYesterday(String[] args) throws ParseException
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
			if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
				if(this.clickbtnServcRequestContractYesterday())
					if(this.checkSearchForServiceRequestsForContractsTable(""))
						return true;
		return false;	
	}

	public boolean checkDateByClickingButtonsLast7Days(String args[]) throws ParseException
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
			if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
				if(this.settxtbxStartDate(args))
					if(this.settxtbxEndDate(args))
						if(this.clickbtnServcRequestContractLast7Days())
							if(this.checkSearchForServiceRequestsForContractsTable("Last 7 Days"))
								return true;
		return false;	
	}



	public boolean checkDateByClickingButtonsLast30Days(String[] args) throws ParseException
	{
		if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
			if(utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
				if(this.settxtbxStartDate(args))
					if(this.settxtbxEndDate(args))
						if(this.clickbtnServcRequestContractLast30Days())
							if(this.checkSearchForServiceRequestsForContractsTable("Last 30 Days"))
								return true;
		return false;	
	}
	
	public boolean checkDateByClickingButtonsLast90Days(String[] args) throws ParseException {
		if (utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
			if (utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Interaction tab"))
				if (this.settxtbxStartDate(args))
					if (this.settxtbxEndDate(args))
						if (this.clickbtnServcRequestContractLast90Days())
							if (this.checkSearchForServiceRequestsForContractsTable("Last 90 Days"))
								return true;
		return false;
	}




	//Objects .....................

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")	
	private WebElement btnAddTAsk;
	@FindBy(xpath="//*[contains(@id,'CPMTaskSearchInput')][1]")
	private WebElement SearchInput;

	@FindBy(xpath="//*[@id='$PTaskMenuSearchResults$ppxResults$l1']")
	private WebElement lnkClickonLinkafterSettingValue;



	// Getters 



	public WebElement getchkbxSEacrchInput()
	{
		return SearchInput;
	}

	public WebElement getbtnAddTAsk()
	{
		return btnAddTAsk;
	}
	public WebElement getlnkClickonLinkafterSettingValue()
	{
		return lnkClickonLinkafterSettingValue;
	}
	
	public boolean clickbtnAddTask()
	{
		return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");
	}


	// Set text 
	public boolean setTxtFullContactName(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.getchkbxSEacrchInput(), sFullName, "Member Composite", "Application took a long time to load");
	}


	//click on Selected link 
	public boolean clicklnkClickonLinkafterSettingValue() throws InterruptedException
	{
			Thread.sleep(2000);
			//   utils.PressEnter(this.lnkClickonLinkafterSettingValue, "Member Composite", "Text Box Add Task Options");
			return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValue, "Member Composite", "Text Box Add Task Options");
	}

	/*
	 * Main methods 
	 */
	public boolean  navigateTOPromisedAction() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
			waitforpageload();
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Promised Action'][@class='Add_task']")));
			if(utils.clickAnelemnt(this.promisedactions, "Member Composite", "Promised actions under add task"))
				if(utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))					
					return true; 				
		return false; 

	}
	
	public boolean  navigateTOLimitedLiability() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Limited Liability"))
				if(this.clicklnkClickonLinkafterSettingValue())
					return true; 
		return false; 

	}      


	public boolean navigateTOManageClaims() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")));
			if(utils.clickAnelemnt(this.manageclaims, "Member Composite", "Manage Claims under add task"))
				if(utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
					return true; 
		return false; 
	}

	public boolean  navigateTOAccumulators() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Accumulators"))
				if(this.clicklnkClickonLinkafterSettingValue())					
					return true; 
		return false; 

	}      



	public boolean waitforpageload()
	{
		try{
			Thread.sleep(3000);
			System.out.println("Checking for Loading Icon");
			wait=new WebDriverWait(Driver.getPgDriver(),100);
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
		}
		catch(Exception e){
			System.out.println("No loading icon. Continue " +e);
		}
		System.out.println("Came out");
		return true;
	}

	public boolean  navigateTOBenefitsandCost() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
			waitforpageload();
			wait=new WebDriverWait(Driver.pgDriver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")));
			if(utils.clickAnelemnt(this.benefitsandcost, "Member Composite", "Benefits and cost under add task"))
				if(utils.clickAnelemnt(this.addtaskbutton, "Member composite", "Add task(s) button "))
					return true; 
		return false; 
	}


	public boolean  navigateTOManageBilling() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Manage Enrollment"))
				if(this.clicklnkClickonLinkafterSettingValue())
					return true; 
		return false; 
	}	

	public boolean  navigateTOProvider() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Provider"))
				if(this.clicklnkClickonLinkafterSettingValue())
					return true; 
		return false; 

	}    

	public boolean  navigateTOSearchInventory() throws InterruptedException
	{
		Thread.sleep(2000);
		waitforpageload();
		if(this.clickbtnAddTask())
			if(setTxtFullContactName("Search Inventory"))
				if(this.clicklnkClickonLinkafterSettingValue())
					return true; 
		return false; 
	}

	public void validateAlternateIDhovertext()
	{

	}


	//Sprint 2.1 Code

	@FindBy(xpath = "//table[@pl_prop='D_Member360ViewList.pxResults']")
	WebElement tblMember360View;

	@FindBy(xpath="//div[@node_name='Member360ViewInteraction']//div[contains(text(),'View All')]")
	WebElement btnViewAll;

	/*
	 *  @SCU 
	 *  #CommonMethodWithArgument: validateTheValuesInMember360ViewTable
	 *  #Description: This functionality validates the value in the member 360 view table with the values given by the user 
	 *  Type: Table 
	 *  Keys: Channel#Contact Date#Data Source#Logged By#Contact Name#Contact Type#Purpose#Outcome#Details
	 */
	public boolean validateTheValuesInMember360ViewTable(String[] tablevalues) {
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='D_Member360ViewList.pxResults']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.validatetablerowbasedonvalues(this.tblMember360View, tablevalues);
	}


	/*
	 *  @SCU 
	 *  #CommonMethodWithArgument: clickViewAllBtnInMember360View
	 *  #Description: This functionality performs click action in the View All button in the Member 360 View section 
	 *  Type: Textbox
	 */
	public boolean clickViewAllBtnInMember360View()
	{
			return utils.clickAnelemnt(this.btnViewAll,"MemberComposite_InteractionSection", "View All");	
	}

	/*
	 *  @SCU 
	 *  #CommonMethodWithArgument: validateTheValuesInMember360ViewAllTable
	 *  #Description: This functionality validates the value in the member 360 view all table with the values given by the user 
	 *  Type: Table 
	 *  Keys: Channel#Contact Date#Data Source#Logged By#Contact Name#Contact Type#Purpose#Outcome#Details
	 */
	public boolean validateTheValuesInMember360ViewAllTable(String[] tablevalues)
	{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='D_Member360ViewList.pxResults']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.validatetablerowbasedonvalues(this.tblMember360View, tablevalues);
	}

	@FindBy(xpath="//label[@for='pyID']/following-sibling::div/span")
	WebElement labelInteractionID;

	public static String intID;

	public boolean getInteractionID()
	{
		intID = Driver.pgDriver.findElement(By.xpath("//label[@for='pyID']/following-sibling::div/span")).getText();
		System.out.println("Int ID is: "+intID);
		return true;
	}

	public boolean navigateToTheViewAllFullTableAndCHeckValues(String[] tablevalues)
	{
		getInteractionID();
		utils.scrolltomiddle();
		clickViewAllBtnInMember360View();
		Set<String> handles = Driver.pgDriver.getWindowHandles();
		Iterator<String> iterator= handles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		return validateTheValuesInMember360ViewAllTable(tablevalues);
	}


	@FindBy(xpath="//*[text()='Member 360 View']")
	WebElement Member360View;

	/**Method is to click Member 360 View link*/
	public boolean clickMember360ViewLink() {
		return utils.clickAnelemnt(Member360View, "Member Composite Interaction Section", "Member360View");
	}


	//Sprint 2.4.1

	@FindBy(xpath="//tr[@id='Grid_NoResults']/td")
	WebElement txtInteractionErrorMsg;

	@FindBy(xpath="//iframe[@id='PegaGadget2Ifr']")
	WebElement iframe2;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateMember360TableSortedInDescendingOrder
	 * #Description: This functionality validates the Member 360 Table if the interactions are displayed in descending order based on contact date
	 * Type: Table
	 */

	public boolean validateMember360TableSortedInDescendingOrder(){

		int colindex = 0;
		utils.scrolltomiddle();
		WebDriverWait wait = new WebDriverWait(Driver.pgDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@pl_prop='D_Member360ViewList.pxResults']//tr[1]/th//div[contains(@class,'cellIn')]")));
		List<WebElement> header = Driver.getPgDriver().findElements(By.xpath("//table[@pl_prop='D_Member360ViewList.pxResults']//tr[1]/th//div[contains(@class,'cellIn')]"));
		System.out.println("Headers size is:" + header.size());
		for(int i=1;i<=header.size();i++){
			String headerTitle = Driver.getPgDriver().findElement(By.xpath("//table[@pl_prop='D_Member360ViewList.pxResults']//tr[1]/th["+i+"]//div[contains(@class,'cellIn')]")).getText();
			System.out.println("header titile:"+headerTitle);
			if(headerTitle.contains("Contact Date"))
			{
				colindex = i;
				System.out.println("col index:"+colindex);
				break;
			}
			else
				continue;
		}
		ArrayList<String> dateStringList = utils.getColumnsBasedonIndex(tblMember360View, colindex-1);
		ArrayList<String> dateCopyList = new ArrayList<String>();
		dateCopyList.addAll(dateStringList);
		System.out.println(dateStringList);
		Collections.sort(dateCopyList, Collections.reverseOrder());
		System.out.println(dateCopyList);
		if (dateStringList.equals(dateCopyList)){
			System.out.println("Values are matched in descending order");
		}else{
			err.logcustomerrorwithmessage("MemberComposite_InteractionSection","validateMember360TableSortedInDescendingOrder", "Values are not matched in descending order");
			System.out.println("Values are not matched in descending order");
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyErrorMessageDisplayedForNoInteractions
	 * #Description: This functionality validates the error message displayed when there are no interactions displayed
	 * Type: Textbox 
	 */
	public boolean verifyErrorMessageDisplayedForNoInteractions()
	{
		String ErrorMessage = "No interaction found for the member";
		String ErrorMessageInUI = txtInteractionErrorMsg.getText();
		return utils.isvalueMatch_contain(ErrorMessage, ErrorMessageInUI);
	}

	/*
	 *  @SCU 
	 *  #CommonMethodWithArgument: navigateToTheViewAllFullTableAndCheckTableSortedInDescendingOrder
	 *  #Description: This functionality performs click action in the View All button in the Member 360 View section and navigates to view all window and verifies the table values sorted in descending order. 
	 *  Type: Textbox
	 */
	public boolean navigateToTheViewAllFullTableAndCheckTableSortedInDescendingOrder()
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(Driver.pgDriver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='Member360ViewInteraction']//div[contains(text(),'View All')]")));
			WebElement horizontal_scroll = Driver.getPgDriver().findElement(By.xpath("//div[@node_name='Member360ViewInteraction']//div[contains(text(),'View All')]")); ((JavascriptExecutor) Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
			WebElement button = Driver.getPgDriver().findElement(By.xpath("//div[@node_name='Member360ViewInteraction']//div[contains(text(),'View All')]"));
			//utils.clickAnelemnt(button,"MemberComposite_InteractionSection", "View All");	
			horizontal_scroll.click();
			//Thread.sleep(3000);
			utils.TabHandles("Manage Alerts S-64412");
			validateMember360TableSortedInDescendingOrder();
			utils.TabHandles("CPMHC Interaction Portal");
			return true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			err.logcustomerrorwithmessage("MemberComposite_InteractionSection", "navigateToTheViewAllFullTableAndCheckTableSortedInDescendingOrder", "Error in clicking Member 360 View All button");
			return false;
		}
	}

	@FindBy(xpath="//*[text()='Open Service Requests']/ancestor::*[@id='EXPAND-OUTERFRAME']")
	WebElement OpenServiceRequestTable; 

	public boolean validateServiceExperienceColumnInOpenServiceRequest() {
		String[] tablevalues = {"SR-ID", "Type", "Status", "Interaction Count", "Urgency", "Open Date", "Contact Name", "Service Experience"};
		return utils.validateTableRowHeader(OpenServiceRequestTable, tablevalues);
	}

	public boolean clickInteraction() {
		if (utils.clickAnelemnt(this.tabMbrCompositeInteraction, "Member Composite", "Contract tab"))
			if (waitforpageload())
				return true;
		return false;

	}
	
	public boolean clickOpenServiceRequestLink() {
		return utils.clickAnelemnt(this.lnkMbrCompositeIntOpenServiceReq,"MemberComposite_InteractionSection"," Open Service Request link ");
	}

	public boolean validateRowsInOpenServiceRequest(String[] args) {
		Actions action = new Actions(Driver.pgDriver);
		action.moveToElement(OpenServiceRequestTable);
		try {
		//return utils.validatetablerowbasedonvalues(OpenServiceRequestTable, args);
		String[] keyvaleupair = args;
		System.out.println("Keyvaluepair size is: "+ keyvaleupair.length);
		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][] = new String[keyvaleupair.length][2];
		String[] keys = keyvaleupair;
		int index = 0;
		int i = 0;
		ArrayList<String> returncolumn = new ArrayList<String>();
		int somevalue = 1;
		for (String iterator : keyvaleupair) { 
			keys = iterator.split(":");
			inputcolumnvaluemap[i][0] = keys[0];
			inputcolumnvaluemap[i][1] = keys[1];
			i = i + 1;
			returncolumn = utils.getcolumnStringFromTableByName(OpenServiceRequestTable, keys[0].replaceAll("\n", " "));
			System.out.println("Values in return column: "+returncolumn);
			String[] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
			//System.out.println("Values in columnvaluesmap are: "+ columnvaluesmap.toString());
		}
		int k = 0;
		for (int j = 0; j < returncolumn.size(); j++) {
			if (k == keyvaleupair.length)
				break;
			String column = inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);
			columnvalues[j]= columnvalues[j].toString().replaceAll("\n", "").trim();
			if (columnvalues[j].equalsIgnoreCase(value)) {
				index = j;

				while (k < keyvaleupair.length) {
					column = inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);
					System.out.println("Input value: "+ value + " " + "And the value in the tables are: " + columnvalues[j]);
					if (columnvalues[j].contains(value)) {
						System.out.println("K size is: "+ k);
						k = k + 1;
						continue;
					} else {
						index = -1;
						break;
					}
				}
			}
		}
		List<WebElement> allRows = OpenServiceRequestTable.findElements(By.tagName("tr"));
		if (index != -1) {
			if (allRows.size() > 0)
				//allRows.get(index).click();
				System.out.println("Values matched with the row");
		} else {
			System.out.println("Values doesnt matched with row");
			return false;
		}
		System.out.println("The row with the matching arguements" + index);
		return true;
		}catch(Exception e) {
			blogger.loginfo("Data not present in Application. Please check and update accordingly");
			return false;
		}
	}


	@FindBy(xpath="//*[text()='View All']")
	WebElement ViewAllBtn;

	public boolean clickViewAllLnkOpenServiceRequest() {
		return utils.clickAnelemnt(ViewAllBtn, "MemberComposite_InteractionSection", "ViewAllBtn");
	}

	public boolean clickViewAllLnkRecentInteraction() {
		return utils.clickAnelemnt(ViewAllBtn, "MemberComposite_InteractionSection", "ViewAllBtn");
	}



	@FindBy(xpath="//*[text()='Recent Interactions']/ancestor::*[@id='EXPAND-OUTERFRAME']")
	WebElement RecentInteractionTable; 

	public boolean validateServiceExperienceColumnInRecentInteration() {
		String[] tablevalues = {"","Interaction ID","Created On", "Created By", "Primary Task", "Service Experience", "Contact Name"};
		return utils.validateTableRowHeader(RecentInteractionTable, tablevalues);
	}

	public boolean clickRecentInteractionLink() {
		return utils.clickAnelemnt(this.lnkMbrCompositeIntRecentInt,"MemberComposite_InteractionSection"," Recent Interaction Link");
	}

	public boolean validateRowsInRecentInteration(String[] args) {
		return utils.validatetablerowbasedonvalues(RecentInteractionTable, args);
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

	@FindBy(xpath="//table[@id='gridLayoutTable']")
	WebElement OpenServiceRequestTableNewWindow; 

	public boolean validateHeadersInOpenServiceRequest() {
		this.clickOpenServiceRequestLink();
		waitforpageload();
		String[] tablevalues = {"SR ID", "Type", "Status", "Interaction Count", "Urgency", "Open Date", "Service Experience","Contact Name","Member Name"};
		return utils.validateTableRowHeader(OpenServiceRequestTable, tablevalues);
	}

	public boolean validateHeadersInOpenServiceRequestinNewWindow() {
		String[] tablevalues = {"SR-ID", "Type", "Status", "Interaction Count", "Urgency", "Open Date", "Service Experience","Contact Name"};
		return utils.validateTableRowHeader(OpenServiceRequestTableNewWindow, tablevalues);
	}

	public boolean ValidateHeadersInOpenServiceRequestNewWindow()
	{
		clickViewAllLnkOpenServiceRequest();
		new WebDriverWait(Driver.getPgDriver(),40).until(ExpectedConditions.numberOfWindowsToBe(2));
		utils.TabHandles("Open Service Items By Member");
		return validateHeadersInOpenServiceRequestinNewWindow();			
	}			

	//Sprint 3.3

	@FindBy(xpath="//table[@pl_prop='D_RecentServiceItems.pxResults']")
	WebElement tblOpenServiceLink;

	@FindBy(xpath="//table[@pl_prop='D_MemberInteractions.pxResults']")
	WebElement tblRecentInteractions;


	public boolean validateIfTheInteractionIsMaskedInOpenServiceRequestLinkTable(String[] tablevalues)
	{
		try
		{
			WebElement element = tblOpenServiceLink;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.returntablerowbasedonvalues(tblOpenServiceLink, tablevalues);
			List<WebElement> rowvalue = row.findElements(By.tagName("a"));
			String bol = rowvalue.get(0).getAttribute("disabled");
			System.out.println("Bol value is: "+bol);
			if(bol.contains("true"))
			{
				System.out.println("Interaction ID is masked");
				return true;
			}
			else
			{
				System.out.println("Interaction ID is not masked");
				return false;
			}

		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
			err.logcustomerrorwithmessage("SearchInventory", "validateIfTheInteractionIsMaskedInOpenServiceRequestLinkTable", "Error in validating Interaction table");
			return false;
		}
	}

	public boolean validateIfTheInteractionIsNotMaskedInOpenServiceRequestLinkTable(String[] tablevalues)
	{
		try
		{
			WebElement element = tblOpenServiceLink;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.returntablerowbasedonvalues(tblOpenServiceLink, tablevalues);
			List<WebElement> rowvalue = row.findElements(By.tagName("a"));
			rowvalue.get(0).click();
			return true;

		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
			err.logcustomerrorwithmessage("SearchInventory", "validateIfTheInteractionIsNotMaskedInOpenServiceRequestLinkTable", "Error in validating Interaction table");
			return false;
		}
	}


	public boolean validateIfTheInteractionIsMaskedInRecentInteractionsTable(String[] tablevalues)
	{
		try
		{
			WebElement element = tblRecentInteractions;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.returntablerowbasedonvalues(tblRecentInteractions, tablevalues);
			List<WebElement> rowvalue = row.findElements(By.tagName("a"));
			String bol = rowvalue.get(0).getAttribute("disabled");
			System.out.println("Bol value is: "+bol);
			if(bol.contains("true"))
			{
				System.out.println("Interaction ID is masked");
				return true;
			}
			else
			{
				System.out.println("Interaction ID is not masked");
				return false;
			}

		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
			err.logcustomerrorwithmessage("SearchInventory", "validateIfTheInteractionIsMaskedInRecentInteractionsTable", "Error in validating Interaction table");
			return false;
		}
	}

	public boolean validateIfTheInteractionIsNotMaskedInRecentInteractionsTable(String[] tablevalues)
	{
		try
		{
			WebElement element = tblRecentInteractions;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row = utils.returntablerowbasedonvalues(tblRecentInteractions, tablevalues);
			List<WebElement> rowvalue = row.findElements(By.tagName("a"));
			rowvalue.get(0).click();
			return true;

		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
			err.logcustomerrorwithmessage("SearchInventory", "validateIfTheInteractionIsNotMaskedInRecentInteractionsTable", "Error in validating Interaction table");
			return false;
		}
	}

	//Sprint 3.4

	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']")
	WebElement lnkRecentInquiryTracking;

	@FindBy(xpath="//span[starts-with(text(),'Access to Inquiry')]")
	WebElement txtAccessMsgInRecentInquiryTracking;

	public boolean clickRecentInquiryTracking()
	{
		return utils.clickAnelemnt(lnkRecentInquiryTracking, "MemberComposite_InteractionSection", "REcent Inquiry LInk");
	}

	public boolean verifyIfAccessRestrictionErrorMessageIsDisplayed(String[] args)
	{
		String actualText = args[0];
		String expectedText = txtAccessMsgInRecentInquiryTracking.getText();
		return utils.isvalueMatch_contain(actualText, expectedText);
	}

	public boolean ValidateIfPreviousInteractionIsPresentInMember360(String[] args)
	{
		String interactionval = "Interaction ID:"+Header.InteractionIDvalue;
		blogger.loginfo(interactionval);
		action.moveToElement(tblMember360View);
		return utils.validatetablerowbasedonvalues(tblMember360View, interactionval);
	}
	
	@FindBy(xpath="//table[@pl_prop='D_RecentServiceItems.pxResults']//a[@data-test-id='20160210145727026023512']")
	WebElement FirstSRIDInOpenServiceRequest;
	/**This functionality validates if the particular Interaction belonging to the restricted Contract is masked without having to give any input
	 * 
	 * @param tablevalues
	 * @return
	 */
	public boolean validateIfTheInteractionIsMaskedWithoutInput()
	{
			WebElement element = tblOpenServiceLink;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			String bol = FirstSRIDInOpenServiceRequest.getAttribute("disabled");
			System.out.println("Bol value is: "+bol);
			if(bol.contains("true"))
			{
				blogger.loginfo("Interaction ID is masked");
				return true;
			}
			else
			{
				blogger.loginfo("Interaction ID is not masked");
				return false;
			}
	}
	
	// X-paths and Methods related to Recent Interactions section [to expand the first row under Recent Interactions and to validate the Header]
	
	@FindBy(xpath="//div[@node_name='CPMHCRecentInteractionsByMemberId']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntRecentInt;
	
	@FindBy(xpath="(//div[@node_name='CPMHCRecentInteractionsByMemberId']/parent::div//table[@id='gridLayoutTable']/..//..//span[@class='expandRowDetails'])[1]")
	WebElement clickRecentIntFirstRow;
		
	@FindBy(xpath="//div[@node_name='DisplayOpenServiceRequests']/parent::span//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntOpenSerReqUnderRecentInt;
	
	public boolean validateColumnHeadersInRecentInteractions() {
		String[] tablevalues = {" ","Interaction ID","Created On", "Created By", "Primary Task", "Service Experience", "Contact Name"};
		return utils.validateTableRowHeader(tableMbrCompositeIntRecentInt, tablevalues);
	}
	
	public boolean clickRecentInteractionsFirstRow() {
			if (utils.clickAnelemnt(clickRecentIntFirstRow, "Member Composite", "Interactions Tab")) {
				return true;
			} else {
				return false;
			}
	}
	
	public boolean validateColumnHeadersInRecentInteractionsOpenServiceReq() {
		String[] tablevalues = {"Service Request ID","Type","Status","Member Name","Current Assignment"};
		return utils.validateTableRowHeader(tableMbrCompositeIntOpenSerReqUnderRecentInt, tablevalues);
	}	
	
	
	// X-paths and Methods related to Claim Activity section [to expand the section and to validate the Header]

	@FindBy(xpath = "//div[@title='Disclose Claim Activity in the last 30 days']")
	WebElement claimActivityExpandIcon;

	@FindBy(xpath = "//span[text()='Claim Activity in the last 30 days']")
	WebElement claimActivityTab;
	
	@FindBy(xpath="//div[@node_name='RecentClaimsActivity']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntClaimActivity;
	
	public boolean clickClaimActivity() {
		if (!utils.isProxyWebelement(claimActivityExpandIcon)) {
			blogger.loginfo("PASS:Claim Activity is collapsed by default");
			if (utils.clickAnelemnt(claimActivityTab, "Member Composite", "Interactions Tab")) {
				return true;
			} else {
				blogger.loginfo("Failed to click Claim Activity");
				return false;
			}
		} else {
			blogger.loginfo("Failed to click Claim Activity");
			return false;
		}
	}
	
	public boolean validateColumnHeadersInClaimActivity() {
		String[] tablevalues = {"Claim ID","Date of Service", "Received Date", "Processed Date", "Action Code", "Rendering Provider","Status"};
		return utils.validateTableRowHeader(tableMbrCompositeIntClaimActivity, tablevalues);
	}
	
	// X-paths and Methods related to Correspondence Activity section [to expand the section and to validate the Header]
	
	@FindBy(xpath = "//div[@title='Disclose Correspondence Activity in the last 30 days']")
	WebElement correspondenceActivityExpandIcon;

	@FindBy(xpath = "//span[text()='Correspondence Activity in the last 30 days']")
	WebElement correspondenceActivityTab;
	
	@FindBy(xpath="//div[@node_name='RecentCorrespondenceActivity']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableMbrCompositeIntCorrespondenceActivity;	
		
	
	public boolean clickCorrespondenceActivity() {
		if (!utils.isProxyWebelement(correspondenceActivityExpandIcon)) {
			blogger.loginfo("PASS:Correspondence Activity is collapsed by default");
			if (utils.clickAnelemnt(correspondenceActivityTab, "Member Composite", "Interactions Tab")) {
				return true;
			} else {
				blogger.loginfo("Failed to click Correspondence Activity");
				return false;
			}
		} else {
			blogger.loginfo("Failed to click Correspondence Activity");
			return false;
		}
	}
	
	public boolean validateColumnHeadersInCorrespondenceActivity() {
		String[] tablevalues = {"Correspondence Type","Date Sent", "Description", "Sent To"};
		return utils.validateTableRowHeader(tableMbrCompositeIntCorrespondenceActivity, tablevalues);
	}	
	

}
