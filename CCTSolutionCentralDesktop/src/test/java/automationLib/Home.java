package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataStore;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.ReadFile;
import utils.SeleniumUtilities;

public class Home extends Driver {

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSearchForMember;

	@FindBy(id="PegaGadget0Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement1;

	@FindBy(id="CPMAssignmentsSearchText")
	WebElement txtboxSearchInteraction;

	@FindBy(name="CPMSearchMyWork_pyDisplayHarness_2")
	WebElement btnsearch;

	@FindBy(xpath="//*[contains(text(),'Manager tools')]")
	WebElement lnkManagerTools;
	public Home()
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	SeleniumUtilities utils = new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);

	@FindBy(xpath="//*[text()='Home']")
	WebElement sHeaderHome;
	@FindBy(xpath="//*[contains(@class,'header')]//*[text()='My Recent Work']")
	private WebElement sHeaderMyRecentTabs;
	@FindBy(xpath="//li[@title='My Workbaskets']")
	private WebElement sHeaderMyWorkBasket;

	@FindBy(xpath="//*[contains(@class,'header')]//*[text()='My Worklist']")
	private WebElement sHeaderMyWorkList;

	@FindBy(xpath="//table[contains(@pl_prop,'MyRecentWork')]")
	private WebElement tableRecentworks;

	@FindBy(xpath="//table[contains(@pl_prop,'MyWorkBasketList')]")
	private WebElement tableMyWorkBasket;

	@FindBy(xpath="//img[contains(@alt,'Loading..')]")
	WebElement LoadingIcon;

	@FindBy(linkText ="Dashboard")
	WebElement homeDashboard;

	public boolean checkforpageload()
	{
		int count=0;
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			System.out.println(this.Iframeelement.getText());
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			wait=new WebDriverWait(Driver.pgDriver,20);
			wait.until(ExpectedConditions.visibilityOf(this.homeDashboard));
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Applcation took a long time to load");
			return false;
		}

	}


	public boolean clickTabHome()
	{
		Driver.getPgDriver().switchTo().defaultContent();
		return utils.clickAnelemnt(this.sHeaderHome, "Home Page ", "Home Tab");

	}

	public boolean clickTabMyRecentTabs()
	{
		utils.waitforpageload();
		wait=new WebDriverWait(Driver.pgDriver,20);
		wait.until(ExpectedConditions.visibilityOf(this.sHeaderMyRecentTabs));
		wait.until(ExpectedConditions.elementToBeClickable(this.sHeaderMyRecentTabs));
		return utils.clickAnelemnt(this.sHeaderMyRecentTabs, "Home Page ", "My recent work Tab");

	}

	public boolean clickTabMyWorkBasket()
	{
		utils.waitforpageload();
		utils.waitForElementToBeVisible(sHeaderMyWorkBasket);
		return utils.clickAnelemnt(this.sHeaderMyWorkBasket, "Home Page ", "Work Basket");

	}

	public boolean clickTabMyWorkList()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(this.sHeaderMyWorkList, "Home Page ", "Work List");

	}

	/**
	 * Navigate to REcent Tab from the Home Page 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean navigateToMyRecentTabs() throws InterruptedException
	{
		if(this.clickTabHome())
		{
			utils.waitforpageload();
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			if(this.checkforpageload())
			{

				if(this.clickTabMyRecentTabs())
				{
					System.out.println("Pass : Successfully Navigated to My Recent Tabs ");
				}
				return true;
			}
		}
		System.out.println("Fail : Not able to naviugate to My recent tab");
		return false;
	}

	ErrorLogger err= new ErrorLogger();

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateToPromisedActionFromWorkBasketusingID
	 * #Description: This functionality navigates to the promised action by getting the value ID from the table and selecting the drop down value 'Customer Service Review WB' and click the valueID in the workbasket table
	 * Type:Textbox
	 */
	public boolean navigateToPromisedActionFromWorkBasketusingID() throws InterruptedException
	{
		System.out.println("=======================================Start: Click on ID from Work Basket and Navigate to Promised Action=========================== ");
		if(this.navigateToMyRecentTabs())
		{
			String valueID=getIDfromTableRecentWork("Promised Action");
			System.out.println("The Value of the ID from Recent work page is:"+ valueID );
			if(this.navigateToMyWorkBasket())
			{
				if(this.selectdropDownViewForQueue("Customer Service Review WB"))
				{
					//if(this.searchbyInteractionNumber(valueID))
					if(this.clickIDfromTableWorkBasket(valueID))
					{
						System.out.println("Pass : Successfully clicked on Promised Action from Work Basket ");
						System.out.println("=======================================Stop: Click on ID from Work Basket and Navigate to Promised Action=========================== ");

						return true;
					}
				}
			}
		}
		System.out.println("Fail : Not Successful clicked on Promised Action from Work Basket");
		System.out.println("=======================================Stop: Click on ID from Work Basket and Navigate to Promised Action=========================== ");

		return false;	
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateToPromisedActionFromMyWorkListusingID
	 * #Description: This functionality navigates to the promised action by getting the value ID from the Recent work table and then navigates to the MyworkList and search the interaction number by entering the valueID  
	 * Type:Textbox
	 */
	public boolean navigateToPromisedActionFromMyWorkListusingID() throws InterruptedException
	{
		System.out.println("=======================================Start: Click on ID from My WorkList and Navigate to Promised Action=========================== ");
		if(this.navigateToMyRecentTabs())
		{
			String valueID=getIDfromTableRecentWork("Promised Action");
			System.out.println("The Value of the ID from Recent work page is:"+ valueID );
			if(this.navigateToMyWorkList())
			{
				if(this.searchbyInteractionNumber(valueID))
				{
					System.out.println("Pass : Successfully clicked on Promised Action from Work List ");
					System.out.println("=======================================Stop: Click on ID from  My WorkList and Navigate to Promised Action=========================== ");

					return true;
				}
			}
		}
		System.out.println("Fail : Not Successful clicked on Promised Action from Work List");
		System.out.println("=======================================Stop: Click on ID from  My WorkList and Navigate to Promised Action=========================== ");

		return false;	
	}

	public String getIDfromTableRecentWork(String sType)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]")));
		WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]"));
		List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
		int row_num;
		row_num=1;
		outer:
			for(WebElement trElement : tr_collection)
			{
				List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
				List<WebElement> td_collectionHeader=trElement.findElements(By.xpath("th"));
				for(WebElement tdElement : td_collection)
				{
					if(tdElement.getText().trim().equalsIgnoreCase(sType))
					{
						for(WebElement tdElementID : td_collection)
						{
							return tdElementID.getText();
						}
					}
				}
				row_num++;
			} 
		return null;

	}

	public boolean clickInteractionIDFromRecentWork() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]")));
		WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]"));
		List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
		for(WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
			for(WebElement tdElementID : td_collection)
			{
				ReadFile readFile= new ReadFile();


				if(tdElementID.getText().contains("S-"))
				{
					String sID=tdElementID.getText();
					for(WebElement tdElementID1 : td_collection)
					{

						if(tdElementID1.getText().trim().equalsIgnoreCase("Promised Action"))
						{

							readFile.writeOver("PromisedActionServiceRqst"+"Promised Action"+"$PromisedActionServiceRqst");
							readFile.writeOver("Recent Work P: "+"Promised Action"+"$Recent Work P");	
						}
						else if(tdElementID1.getText().trim().equalsIgnoreCase("Cash"))
						{
							readFile.writeOver("CashServiceRqst"+"Promised Action"+"$PCashServiceRqst");

							readFile.writeOver("Recent Work C: "+"Cash"+"$Recent Work C");	
						}
						else if(tdElementID1.getText().trim().contains("Cash"))
						{
							readFile.writeOver("Recent Work C: "+"Cash"+"$Recent Work C");	
						}
					}
				}



				if(tdElementID.getText().contains("I-"))
				{
					tdElementID.click();
					System.out.println("PAss : Succesfully clicked on the First Interaction ID ");
					return true;
				}
				break;
			}
		}

		return false;
	}

	String xpathNextWorkBasketListPage="//*[contains(@rdname,'CPMWorkGroupBasketWorkList')]//*[contains(@class,'gridActionAlignRight')]//table[@id='grid-desktop-paginator']//*[contains(text(),'Next')]";
	String xpathNextMyWorlistNext="//*[contains(@datasource,'UserWorkList_1')]//*[contains(@class,'gridActionAlignRight')]//table[@id='grid-desktop-paginator']//*[contains(text(),'Next')]";

	/**
	 * Click on the ID from the Table in work basket with the ID extracted from My Recent Works Tab
	 * @param sID : ID taken from My Recent works
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickIDfromTableWorkBasket(String sID) throws InterruptedException
	{
		boolean sStateofPass = false;
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'MyWorkBasketList')]")));
		WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'MyWorkBasketList')]"));
		List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
		for(WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
			for(WebElement tdElement : td_collection)
			{
				if(tdElement.getText().trim().equalsIgnoreCase(sID))
				{
					tdElement.click();
					Driver.pgDriver.findElement(By.linkText(sID)).click();
					System.out.println("Pass : Succesfully clicked on ID link in Work Basket Tab");
					sStateofPass= true;
					return true;
				}
				break;
			}
		} 

		if(!sStateofPass)
		{	
			try
			{
				Driver.pgDriver.findElement(By.xpath(xpathNextWorkBasketListPage)).click();
				sStateofPass=clickIDfromTableWorkBasket(sID);
				clickIDfromTableWorkBasket(sID);
				if(sStateofPass)
				{
					System.out.println("======================================Stop: Click ID value from Work list table ============================= ");
					System.out.println("Pass : Succesfully clicked on ID link in Work Basket Tab");
					return true;
				}

			}
			catch(NoSuchElementException e)
			{
				System.out.println("Fail : Not able to click on ID link in Work Basket Tab");
				System.out.println("Next button is not present now. ");
				sStateofPass= false;

			}

			System.out.println("======================================Start: Click ID value from Work list table ============================= ");
		}
		return false;
	}


	public boolean clickIDfromTableWorkList(String sID) throws InterruptedException
	{
		System.out.println("======================================Start: Click ID value from Work list table ============================= ");
		boolean sStateofPass=false;
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'UserWorkList')]")));
		WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'UserWorkList')]"));
		List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));

		for(WebElement trElement : tr_collection)
		{

			List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
			for(WebElement tdElement : td_collection)
			{
				if(tdElement.getText().trim().equalsIgnoreCase(sID))
				{
					System.out.println("Pass : Succesfully clicked on ID link in Work Basket Tab");
					sStateofPass= true;
					return utils.clickAnelemnt(tdElement,"Home","tdElement");
				}
				break;
			}
		} 

		try
		{
			Driver.pgDriver.findElement(By.xpath(xpathNextMyWorlistNext)).click();
			sStateofPass=clickIDfromTableWorkList(sID);
			if(sStateofPass)
			{
				System.out.println("======================================Stop: Click ID value from Work list table ============================= ");
				System.out.println("Pass : Succesfully clicked on ID link in Work Basket Tab");
				return true;
			}

		}
		catch(NoSuchElementException e)
		{
			System.out.println("Fail : Not able to click on ID link in Work Basket Tab");
			System.out.println("Next button is not present now. ");
			sStateofPass= false;

		}

		return false;
	}

	/**
	 * Navigate to My work Baskets from the Home Page to check the value
	 * @return
	 */
	public boolean navigateToMyWorkBasket()
	{
		if(this.clickTabHome())
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			if(this.checkforpageload())
			{
				if(this.clickTabMyWorkBasket())
				{
					System.out.println("Pass : Successfully Navigated to My Work Basket ");
				}
				return true;
			}
		}
		System.out.println("Fail : Not able to naviugate to My Work Basket");
		return false;
	}

	public boolean navigateToMyWorkList()
	{
		if(this.clickTabHome())
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			if(this.checkforpageload())
			{
				if(this.clickTabMyWorkList())
				{
					System.out.println("Pass : Successfully Navigated to My Work List ");
				}
				return true;
			}
		}
		System.out.println("Fail : Not able to naviugate to My Work List");
		return false;
	}


	@FindBy(xpath="//*[@id='PropertyForParameters']")
	WebElement dropDownViewForQueue;

	@FindBy(xpath="//Select[@id='PropertyForParameters']//option[@selected='']")
	private WebElement dropDownViewForQueueSelected;

	/**
	 * Select Dropdown 
	 * @param visibletext
	 * @param date
	 * @return
	 */
	public boolean selectdropDownViewForQueue(String visibletext) 
	{
		if(utils.selectDropDownbyVisibleString(this.dropDownViewForQueue, visibletext, "Home Page", "View for Queue"))
			return (!utils.isProxyWebelement(this.dropDownViewForQueueSelected));
		return false;
	}

	public boolean selectMemberbyFirstName(String[] args){
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=getsearchResultbyColumn("Type");
		if(this.clickselectColumnRadioButton(utils.returnindexofelemntinanarray(firstnameColumn, args[0])))
			return true;
		else 
			return false;
	}

	public ArrayList<String> getsearchResultbyColumn(String columnName){
		ArrayList<String> returnColumn =new ArrayList<String>();
		returnColumn=utils.getcolumnStringFromTableByName(this.tableRecentworks, columnName);
		return returnColumn;
	}

	public boolean clickOnID()
	{
		ArrayList<String> firstnameColumn = new ArrayList<String>();
		firstnameColumn=getsearchResultbyColumn("First Name");
		return true;
	}

	@FindBy(xpath="//table[contains(@pl_prop,'MyRecentWork')]//th//div[text()='ID']")
	private WebElement gettblSearchresultheaderselect;

	public boolean clickselectColumnRadioButton (int row){
		ArrayList<WebElement> select = utils.getcolumnWebelemntFromTable(this.tableRecentworks,"input" );
		if(utils.clickAnelemnt(select.get(row),"Home Page ","Click ID"))
			return true;
		else 
			return false;
	}

	@FindBy(xpath="//*[contains(@class,'content-inline_middle')]//*[contains(@class,'RecentTab')]/*[contains(@class,'item-2')]//*[contains(@class,'Value')]")
	WebElement closePresentTab;

	public boolean checkmyrecentWork()
	{
		checkforpageload();
		String id=getMostRecentID();
		if(id==null)
			return true;
		String[] tablevalues=new String[]{id,"Look"};

		if(!utils.validateRowValues(this.tableRecentworks, tablevalues))
			return true;
		else
			return false;

	}

	public String getMostRecentID()
	{
		this.clickTabMyRecentTabs();
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]")));
		WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]"));
		List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
		for(WebElement trElement : tr_collection)
		{
			List<WebElement> th_collection=trElement.findElements(By.xpath("th"));
			List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
			if(th_collection.size()>0)
				continue;
			if(td_collection.isEmpty())
				return null;
			if(td_collection.get(0).getText().contains("S-"))
			{
				String sID=td_collection.get(0).getText();
				return sID;
			}
		}
		return null;
	}



	public boolean checkandclickRecentSR()
	{
		Driver.getPgDriver().switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),5);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Home']")));
			Driver.pgDriver.findElement(By.xpath("//a[text()='Home']")).click();
		}
		catch(Exception e)
		{
			Driver.pgDriver.findElement(By.xpath("//a[text()='Home']")).click();
		}
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		this.clickTabMyRecentTabs();
		wait = new WebDriverWait(Driver.getPgDriver(),20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]")));
		WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]"));
		List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
		for(WebElement trElement : tr_collection)
		{
			List<WebElement> th_collection=trElement.findElements(By.xpath("th"));
			List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
			if(th_collection.size()>0)
				continue;

			if(td_collection.isEmpty())
			{
				System.out.println("Table is empty");
				return false;
			}
			System.out.println(td_collection.size());
			if(td_collection.get(0).getText().contains("S-"))
			{
				System.out.println("the table value     --->"+td_collection.get(1).getText());
				td_collection.get(0).click();
				return true;
			}

		}
		return false;
	}

	public boolean checkandclickRecentInteraction()
	{

		Driver.getPgDriver().switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),5);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Home']")));
			Driver.pgDriver.findElement(By.xpath("//a[text()='Home']")).click();
		}
		catch(Exception e)
		{
			Driver.pgDriver.findElement(By.xpath("//a[text()='Home']")).click();
		}
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		this.clickTabMyRecentTabs();
		wait = new WebDriverWait(Driver.getPgDriver(),20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]")));
		WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'MyRecentWork')]"));
		List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
		for(WebElement trElement : tr_collection)
		{
			List<WebElement> th_collection=trElement.findElements(By.xpath("th"));
			List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
			if(th_collection.size()>0)
				continue;

			if(td_collection.isEmpty())
			{
				System.out.println("Table is empty");
				return false;
			}
			System.out.println(td_collection.size());
			if(td_collection.get(0).getText().contains("I-"))
			{

				System.out.println("the table value     --->"+td_collection.get(1).getText());
				td_collection.get(0).click();
				return true;
			}
		}
		return false;

	}

	public boolean searchbyInteractionNumber1(String[] args)
	{
		if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, args[0], "Home", "Search Box"))
		{
			if(utils.clickAnelemnt(this.btnsearch, "Home", "Search Button"))
			{
				System.out.println("The SR is entered and searched");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Search Link is Performed");
			}
			return true;
		}else	
			err.logcustomerrorwithmessage("Home","searchSRInTHeWorkBasket","SR num did not entered or searched");
		return false;	
	}

	public boolean searchbyInteractionNumber(String RId) throws InterruptedException
	{

		if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, RId, "Home", "Search Box"))
		{
			if(utils.clickAnelemnt(this.btnsearch, "Home", "Search Button"))
			{
				Thread.sleep(5000);
				WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'WorkList')]"));
				List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
				System.out.println("Collection.size is"+tr_collection.size());
				for(WebElement trElement : tr_collection)
				{
					List<WebElement> th_collection=trElement.findElements(By.xpath("th"));
					List<WebElement> td_collection=trElement.findElements(By.xpath("td"));


					System.out.println(td_collection.size());
					try{
						if(td_collection.get(0).getText().contains("S-"))
						{

							System.out.println("the table value     --->"+td_collection.get(1).getText());
							td_collection.get(0).click();
							return true;
						}
					}catch(Exception e)
					{
						System.out.println("End for loop");
					}
				}

			}

		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigatetoManagerTools
	 * #Description:Navigating to teh manger tools page by clicking on the hyperlink  
	 * Type:Textbox
	 */
	public boolean navigatetoManagerTools(){
		return utils.clickAnelemnt(this.lnkManagerTools, "home", "managertools link");
	}

	@FindBy(xpath="//div[text()='Get Most Urgent']")
	WebElement workListGetMostUrgentBtn;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickGetMostUrgent
	 * #Description:This method clicks on 'Get Most Urgent' button in MyWorklist page.
	 * Type:TextBox
	 */
	public boolean clickGetMostUrgent(){
		return utils.clickAnelemnt(this.workListGetMostUrgentBtn, "Home", "Get Most Urgent Button");
	}

	@FindBy(xpath="//a[contains(@data-click,'CPMHCInteractionPortalTools')]")
	private WebElement toolsTab;

	@FindBy(xpath="//a[contains(@data-click,'BrowseBenefits')]")
	private WebElement browseBenefitsLink;

	@FindBy(xpath="//*[text()='Search for Interactions']")
	private WebElement SearchforInteractions;

	@FindBy(xpath="//*[@data-test-id='2015092013113000865822'][contains(text(),'Links')]")
	WebElement lnkLinks;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigatetoBrowseBenefits
	 * #Description:This methods allows the user to click on Tools tab and navigate to Browse Benefits page
	 * Type:Textbox
	 */
	public boolean navigatetoBrowseBenefits()
	{
		Driver.getPgDriver().switchTo().defaultContent();
		if(utils.pressEnter(this.lnkLinks, "Home", "Tools Button"))
			return utils.pressEnter(this.browseBenefitsLink, "Home", "Browse Benefits");
		return false;
	}

	@FindBy(id="SearchBySRClaim Number")
	WebElement ClaimNumRadioBtn;

	public boolean navigatetoSearchByClaimNumber()
	{
		Driver.getPgDriver().switchTo().defaultContent();
		if(utils.pressEnter(this.lnkLinks, "Home", "Tools Button"))
			if(utils.pressEnter(this.SearchforInteractions, "Home", "Search By Claim Number"))
				return utils.clickAnelemnt(ClaimNumRadioBtn,  "Home", "Search By Claim Number");
		return false;

	}

	@FindBy(xpath="//a[@tabtitle='My Daily Productivity']")
	private WebElement dailyProdTab;

	@FindBy(xpath="//*[contains(@data-ui-meta,'OperatorID.pyUserIdentifier')]//label[text()='My User ID:']")
	private WebElement userIdLbl;

	@FindBy(xpath="//*[contains(@data-ui-meta,'OperatorID.pyUserIdentifier')]//span")
	private WebElement userIdTxt;

	@FindBy(xpath="//*[contains(@data-ui-meta,'pxCreateDateTime')]//label[text()='Date:']")
	private WebElement dateLbl;

	@FindBy(xpath="//*[contains(@data-ui-meta,'pxCreateDateTime')]//span")
	private WebElement dateTxt;

	@FindBy(xpath="//span[text()='Interaction Level Productivity']")
	private WebElement interactionLvlProdLbl;

	@FindBy(xpath="//span[text()='Service Request Level Productivity']")
	private WebElement srLvlProdLbl;

	@FindBy(xpath="//*[contains(@gpropindex,'D_DailyProudctivitySummaryPpxResults1')]//table[@class='gridTable '][@pl_prop='D_DailyProudctivitySummary.pxResults']")
	private WebElement dailyProdTbl;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDailyProductivityTab
	 * #Description:This method allows the user to verify My Daily Productivity tab is displayed for all logged in users in Dashboard page
	 * Type:Textbox
	 */
	public boolean verifyDailyProductivityTab(){
		return !utils.isProxyWebelement(dailyProdTab);
	}

	@FindBy(xpath="//ol[@title='Currently open']//a")
	private WebElement dailyProdTabDrpdown;

	@FindBy(xpath="//*[contains(text(),'My Daily Prod...')]")
	private WebElement dailyProdTabDisplay;

	@FindBy(xpath="//*[contains(text(),'My Daily Prod')]")
	private WebElement DailyProdTab;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigatetoMyDailyProductivityTab
	 * #Description:This method allows the user to click and navigate to My Daily Productivity tab
	 * Type:Textbox
	 */
	public boolean navigatetoMyDailyProductivityTab(){
		//if(utils.clickAnelemnt(this.dailyProdTabDrpdown, "Home","My Daily Productivity drpdown list"))
		if(!utils.isProxyWebelement(dailyProdTabDisplay))	
			return utils.clickAnelemnt(this.DailyProdTab, "Home","My Daily Productivity");
		else if(!utils.isProxyWebelement(DailyProdTab))
			return utils.clickAnelemnt(DailyProdTab, "Home","My Daily Productivity");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyLblsInDailyProductivityTab
	 * #Description:This method allows the user to verify labels displayed in My Daily Productivity tab
	 * Type:Textbox
	 */
	public boolean verifyLblsInDailyProductivityTab(){
		try{
			List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//*[contains(@gpropindex,'D_DailyProudctivitySummaryPpxResults1')]//table[@class='gridTable '][@pl_prop='D_DailyProudctivitySummary.pxResults']"));
			if(this.userIdLbl.isDisplayed() && this.dateLbl.isDisplayed() && this.interactionLvlProdLbl.isDisplayed() && this.srLvlProdLbl.isDisplayed() && tables.get(0).isDisplayed() && tables.get(1).isDisplayed()){
				System.out.println("The following labels are displayed in My Daily Productivity Tab - UserId, Date, InteractionLevel Productivity table,ServiceLevel Productivity table is displayed");
			}
		}catch(Exception e){
			err.logError("Home", "Exception occured in verifyLblsInDailyProductivityTab method"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyTotalNoOfInteractions
	 * #Description:This method allows the user to verify the total no. of Interactions
	 * Type:Textbox
	 */
	public boolean verifyTotalNoOfInteractions(){
		List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//*[contains(@gpropindex,'D_DailyProudctivitySummaryPpxResults1')]//table[@class='gridTable '][@pl_prop='D_DailyProudctivitySummary.pxResults']"));
		List<WebElement> allRows = tables.get(0).findElements(By.tagName("tr"));
		ArrayList<Integer> resultarray = new ArrayList<Integer>();
		for(WebElement row:allRows){
			List<WebElement> allColsByRow =row.findElements(By.xpath(".//td[@data-attribute-name='Number of Interactions']//span[@class='centerJustifyStyle']"));
			if(allColsByRow.size()>0){
				System.out.println(allColsByRow.get(0).getText());
				resultarray.add(Integer.valueOf(allColsByRow.get(0).getText()));
			}else{
				System.out.println("Rows are not returned");
				continue;
			}
		}
		int sum = 0;
		for (int i: resultarray) {
			sum += i;
		}
		System.out.println("Total value is"+ sum);
		String tot_no_of_sr = Driver.pgDriver.findElement(By.xpath("//div[@class='gridActionBottom']//td[@class='dataValueRead']//span[@class='leftJustifyStyle']")).getText();
		if(sum == Integer.parseInt(tot_no_of_sr)){
			System.out.println("Total Number of Interactions"+tot_no_of_sr);
			return true;
		}else{
			return false;
		}
	}

	@FindBy(xpath="//*[contains(@gpropindex,'D_DailyProudctivitySummaryPpxResults1')]//table[@class='gridTable '][@pl_prop='D_DailyProudctivitySummary.pxResults']")
	private List<WebElement> tables;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyTotalNoOfServiceRequests
	 * #Description:This method allows the user to verify the total no. of Service Requests
	 * Type:Textbox
	 */
	public boolean verifyTotalNoOfServiceRequests(){
		utils.waitforpageload();
		List<WebElement> allRows = tables.get(1).findElements(By.tagName("tr"));
		ArrayList<Integer> resultarray = new ArrayList<Integer>();
		List<WebElement> allColsByRow = Driver.pgDriver.findElements(By.xpath(".//td[@data-attribute-name='Number of Service Requests']//span[@class='centerJustifyStyle']"));
		for(WebElement row:allColsByRow){
			if(allColsByRow.size()>0){
				System.out.println(row.getText());
				resultarray.add(Integer.valueOf(row.getText()));
			}else{
				System.out.println("Rows are not returned");
				continue;
			}
		}
		int sum = 0;
		for (int i: resultarray) {
			sum += i;
		}
		System.out.println("Total value is"+ sum);
		String tot_no_of_sr = Driver.pgDriver.findElement(By.xpath("//div[@class='gridActionBottom']//td[@class='dataValueRead']//span[@class='centerJustifyStyle']")).getText();
		if(sum == Integer.parseInt(tot_no_of_sr)){
			System.out.println("Total Number of Service Requests"+tot_no_of_sr);
			return true;
		}else{
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: searchInteractionfromWorkList
	 * #Description: This functionality enter the SR ID in the the search section and then clicks the search button.
	 * #Argument: SRId
	 * Type: Textbox
	 */
	public boolean searchInteractionfromWorkList(String[] SRId)
	{
		if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, SRId[0], "Home", "Search Box"))
			return utils.clickAnelemnt(this.btnsearch, "Home", "Search Button");
		return false;
	}
	
	
	public boolean searchInteractionInWorkList()
	{
		utils.waitforpageload();
		String ID =MemberComposite_SecureMessageSection.getInteractionID;
		if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, ID , "Home", "Search Box"))
		return utils.clickAnelemnt(this.btnsearch, "Home", "Search Button");
		return false;
	}

	public boolean validateRowandClickInteractionID() throws InterruptedException
	{
		String InteractionID = MemberComposite_SecureMessageSection.getInteractionID;
		String tablevalues[] = ("ID:"+InteractionID).split(" ");
		Thread.sleep(1000);
		System.out.println("Waiting for table load");  
		/*WebElement tablerow = utils.returntablerowbasedonvalues(tblWorklist, tablevalues );
		List<WebElement> rowCol = tablerow.findElements(By.tagName("td"));
		if(rowCol.size()>0)
		{
			rowCol.get(0).click();
			System.out.println("Inteaction - ID is clicked");
			return true;
		}
		return true;*/
		
		
		System.out.println("Waiting for table load");  
		WebElement tablerow = utils.getProviderResultsBasedOnValues(this.tblWorklist, tablevalues);
		List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
		utils.clickAnelemnt(rowCol.get(0),"Home", "Search Button");
	//	rowCol.get(0).click();
		return true;
	}



	@FindBy(xpath="//table[contains(@pl_prop,'pgRepPgSubSectionpyUserWorkList')]")
	WebElement tblWorklist;

	@FindBy(xpath="//table[@pl_prop='pgRepPgSubSectionCPMMyWorkBasketListBBBBBBBBBBBBBBBB.pxResults']")
	WebElement tblWorkBasket2;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateRowandClickSRID
	 * #Description: This functionality validates the Worklist table row and then clicks the SR ID in the Worklist table.
	 * #Argument: tablevalues
	 * Type: Table
	 * keys: ID#Urgency#Goal#Instructions#Category#Member Name
	 */
	public boolean validateRowandClickSRID(String[] tablevalues) throws InterruptedException
	{
		WebElement tablerow = utils.returntablerowbasedonvalues(tblWorklist, tablevalues);
		List<WebElement> rowCol = tablerow.findElements(By.tagName("td"));
		if(rowCol.size()>0)
		{
			rowCol.get(0).click();
			System.out.println("SR - ID is clicked");
			return true;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: searchInteractionfromWorkListAfterUpdating
	 * #Description: This functionality enter the SR ID in the the search section and then clicks the search button.
	 * #Argument: SRId
	 * Type: Textbox
	 */
	public boolean searchInteractionfromWorkListAfterUpdating(String[] SRId)
	{
		Driver.pgDriver.findElement(By.id("CPMAssignmentsSearchText")).clear();
		if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, SRId[0], "Home", "Search Box"))
			return utils.clickAnelemnt(this.btnsearch, "Home", "Search Button");
		return false;

	}

	@FindBy(linkText="Administration")
	private WebElement adminTab;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:navigateTOAdmin
	 * Type:Textbox
	 * Description: To click on Administration tab - Manager
	 */
	public boolean navigateTOAdmin()
	{
		if(utils.validateHeader(this.adminTab, "Administration")){
			return utils.clickAnelemnt(this.adminTab, "Administration","Administration");
		}
		return false;
	}

	@FindBy(id="pySearchText")
	WebElement searchText;

	@FindBy(xpath="//i[@class='icons']//*[@name='CPMSearch_pyDisplayHarness_2']")
	WebElement cpmSearchIcon;

	@FindBy(xpath="//table[@class='gridTable ']//a[@title='Click here to open the object']")
	WebElement searchResults;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchInteractionFromCaseSearch
	 * #Description: This method enters Service Request/Interaction number in Case SearchBox and clicks on the results hyperlink from Search results.
	 * #Arguments:ServiceRequestNo Or Interaction Number
	 * Type:TextBox
	 */
	public boolean searchInteractionFromCaseSearch(String[] args){
		Driver.getPgDriver().switchTo().defaultContent();
		if(utils.enterTextinAnelemnt(this.searchText, args[0], "HomePage", "Case Search"))
			if(utils.clickAnelemnt(this.cpmSearchIcon, "HomePage","Search Icon"))
				return utils.clickAnelemnt(this.searchResults, "HomePage", "Results Hyperlink");
		return false;		
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchRequestfromWorkList
	 * #Description:This method allows user to search on Service Request number in SearchBox in MyWorkList
	 * #Arguments:ServiceRequestNo
	 * Type:TextBox
	 */
	public boolean searchRequestfromWorkList(String[] args) throws InterruptedException
	{
		if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, args[0], "Home", "Search Box"))
			if(utils.clickAnelemnt(this.btnsearch, "Home", "Search Button"))
			{
				WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'WorkList')]")));
				WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[contains(@pl_prop,'WorkList')]"));
				List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
				for(WebElement trElement : tr_collection)
				{
					List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
					for(WebElement tdElement : td_collection)
					{
						if(tdElement.getText().trim().equalsIgnoreCase(args[0]))
						{
							System.out.println("Pass : Service Request is returned in Work List Tab"+tdElement.getText().trim());
							return true;
						}
						break;
					}
				} 
			}
		return false;
	}


	@FindBy(xpath="//table[contains(@pl_prop,'WorkList')]")
	WebElement workListTable;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateRequestDetailsInWorkList
	 * #Description:This method allows user to validate the fields returned from Search criteria in MyWorkList
	 * #Arguments:WorklistTable-KeyValuePair
	 * Type:Table
	 * Keys:ID#Urgency#Goal#Instructions#Category#Member Name
	 */
	public boolean validateRequestDetailsInWorkList(String[] args) throws InterruptedException{
		return utils.clickontablerowbasedonvalues(this.workListTable,args);
	}

	@FindBy(id="PropertyForParameters")
	WebElement dropDownForViewQueued;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickMyWorkbasketsTab
	 * #Description: This functionality performs click action  on the MyWork baskets tab in the Home page
	 * Type: Textbox
	 */
	public boolean clickMyWorkbasketsTab() throws InterruptedException
	{
		Thread.sleep(2000);
		action.moveToElement(sHeaderMyWorkBasket);
		return utils.clickAnelemnt(this.sHeaderMyWorkBasket, "Home Page ", "Work Basket");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectViewQueuedDropdown
	 * #Description: This functionality selects the value given by the user in the View Queue drop down in Worknasket page
	 * Type: Dropdown
	 * Keys: Grievance and Appeals Expedited#Grievance and Appeals Standard
	 */
	public boolean selectViewQueuedDropdown(String[] visibletext) throws InterruptedException 
	{
		//Thread.sleep(10000);
		utils.waitForElementToBeVisible(dropDownForViewQueued);
		return utils.selectDropDownbyVisibleString(this.dropDownForViewQueued, visibletext[0], "Home", "View for Queue");
	}

	@FindBy(xpath="//table[contains(@pl_prop,'pgRepPgSubSectionCPMMyWorkBasketList')]")
	WebElement tblWorkBasket;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateRowandClickSRIDInWorkBasket
	 * #Description: This functionality validates the Work basket table row and then clicks the SR ID in the workbasket table.
	 * #Argument: tablevalues
	 * Type: Table
	 * keys: ID#Urgency#Type#Appeal Type#Policy State#Line of Business#Funding Type#Group#Source
	 */
	public boolean validateRowandClickSRIDInWorkBasket(String[] tablevalues) throws InterruptedException
	{
		try
		{
			System.out.println("Entered method");
			Thread.sleep(1000);
			WebElement tablerow = utils.returntablerowbasedonvalues(tblWorkBasket, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
			rowCol.get(0).click();
			return true;

		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
			err.logcommonMethodError("Home", "validateRowandClickSRIDInWorkBasket");
			return false;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateTheWorkbasketHeader
	 * #Description: This functionality validates the header row of the Work basket header table
	 * Type: Textbox
	 */
	public boolean validateTheWorkbasketHeader()
	{

		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblWorkBasket);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("ID");
		valuesGivenManual.add("Urgency");
		valuesGivenManual.add("Type");
		valuesGivenManual.add("Appeal Type");
		valuesGivenManual.add("Policy State");
		valuesGivenManual.add("Line of Business");
		valuesGivenManual.add("Funding Type");
		valuesGivenManual.add("Group");
		valuesGivenManual.add("Source");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			blogger.loginfo("All values for fields matched with table values");
			System.out.println("Values Matched");
			return true;
		}
		else
		{
			blogger.loginfo("All values for fields not matched with table values");
			System.out.println("Values doesnt Matched");
			return false;

		}
	}

	@FindBy(xpath="//*[contains(@class,'header')]//*[text()='My Team']")
	WebElement sHeaderMyTeam;

	@FindBy(xpath="//*[contains(@class,'header')]//*[text()='My Daily Productivity']")
	WebElement sHeaderMyDailyProductivity;

	@FindBy(xpath="Get Most Urgent")
	WebElement sHeaderGMU;

	public boolean verifyMyWorkListIsDisplayed()
	{
		return !utils.isProxyWebelement(sHeaderMyWorkList);
	}

	public boolean verifyMyWorkTeamIsDisplayed()
	{
		return !utils.isProxyWebelement(sHeaderMyTeam);

	}

	public boolean verifyMyDailyProductivityIsDisplayed()
	{
		return !utils.isProxyWebelement(sHeaderMyDailyProductivity);
	}


	public boolean verifyMyWorkBasketsIsDisplayed()
	{
		return !utils.isProxyWebelement(sHeaderMyWorkBasket);
	}


	public boolean verifyMyRecentWorkIsDisplayed()
	{
		return !utils.isProxyWebelement(sHeaderMyRecentTabs);
	}

	public boolean verifyTheWorkTabsAreDisplayedInHome()
	{
		if(this.verifyMyWorkListIsDisplayed())
			if(this.verifyMyWorkBasketsIsDisplayed())
				if(this.verifyMyWorkTeamIsDisplayed())
					if(this.verifyMyDailyProductivityIsDisplayed())
						return this.verifyMyRecentWorkIsDisplayed();
		return false;
	}

	@FindBy(xpath="//tr[@id='$PpgRepPgSubSectionCPMMyRecentWorkB$ppxResults$l1']//a[@data-test-id='20160210145727026023512']")
	private WebElement recentSR;

	@FindBy(xpath="//*[@data-node-id='CPMMyRecentWork']//*[text()='Manage Claims']/../../../..//a[@data-test-id='20160210145727026023512']")
	WebElement ManageClaimsRecenstSR;
	@FindBy(xpath="//*[@data-node-id='CPMMyRecentWork']//*[text()='Phone Call']/../../../..//a[@data-test-id='20160210145727026023512']")
	WebElement InteractionID;
	@FindBy(xpath="//a[@title='Click here to open the object' and text()]")
	private WebElement lnkrecentSR;

	public static String recentSRname;
	public static String recentIntractionname;
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: fetchSRFromRecentWorklist
	 * #Description: This functionality captures latest SR from My Recent work tab
	 * Type: Textbox
	 */	
	int count=0;
	public boolean fetchSRFromRecentWorklist()
	{
		utils.waitforpageload();
		try {
			Thread.sleep(2000);
			MemberComposite mc = new MemberComposite();
			String srid = mc.getSRIDFromTaskList();
			System.out.println("SR ID from MemberComposite: "+srid);
			if(!srid.contains("Claims")) {
				recentSRname = srid.substring(srid.indexOf("(")+1,srid.indexOf(")")).trim();
				System.out.println("SRID: "+recentSRname);
				DataStore.storeData("Home", "SR ID", recentSRname);
				navigateToMyRecentTabs();
			}else {
				utils.waitforpageload();
				navigateToMyRecentTabs();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOf(ManageClaimsRecenstSR));
				recentSRname = ManageClaimsRecenstSR.getText();
				DataStore.storeData("Home", "SR ID", recentSRname);
			}
			System.out.println("*********Recent SR is---" + recentSRname);
			blogger.loginfo("Recent SR is " + recentSRname);
		} catch (Exception e) {
			System.out.println("Unable to Fetch SR");
			err.logcustomerrorwithmessage("Home","fetchSRFromRecentWorklist","Did not fetched SR");
			if(count<1) {
				count++;
				return fetchSRFromRecentWorklist();
			}
			return false;
		}
		return true;
	}
	
	public boolean fetchIntearctionFromMyRecentWork()
	{
		utils.waitforpageload();
		try {
			Thread.sleep(2000);
			
		{
				navigateToMyRecentTabs();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOf(InteractionID));
				recentIntractionname = InteractionID.getText();
				DataStore.storeData("Home", "Interaction ID", recentIntractionname);
			}
			System.out.println("*********Recent Interaction is---" + recentIntractionname);
			blogger.loginfo("Recent Interaction is " + recentIntractionname);
		} catch (Exception e) {
			System.out.println("Unable to Fetch Interaction");
			err.logcustomerrorwithmessage("Home","fetchInteractionFromRecentWorklist","Did not fetched SR");
			if(count<1) {
				count++;
				return fetchIntearctionFromMyRecentWork();
			}
			return false;
		}
		return true;
	}

	public boolean searchSRInTHeWorkBasket(){
		if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, recentSRname, "Home", "Search Box"))
			return utils.clickAnelemnt(this.btnsearch, "Home", "Search Button");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyThatTheSRIsDisplayedInWorkList
	 * #Description: Verifies that the SR is displayed in the Worklist table
	 * Type: Table
	 * Keys: ID#Urgency#Goal#Instructions#Category#Member Name
	 */
	public boolean verifyThatTheSRIsDisplayedInWorkList(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(this.tblWorklist, tablevalues);
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: verifyThatTheSRIsDisplayedInWorkBasket
	 * #Description: Verifies that the SR is displayed in the WorkBasket table
	 * Type: Table
	 * Keys: ID#Urgency#Goal#Category#Status#Instructions
	 */
	public boolean verifyThatTheSRIsDisplayedInWorkBasket(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(this.tblWorkBasket, tablevalues);
	}

	public boolean validateRowandClickSRIDInWorkBasket() throws InterruptedException
	{
		try
		{
			System.out.println("String Value is: "+MemberComposite.SRIDAfterSubstring);
			System.out.println("Entered method");
			String args[] = MemberComposite.SRIDAfterSubstring.split(",");
			searchInteractionfromWorkListAfterUpdating(args);
			String tablevalues[] = ("ID:"+args[0]).split(",");
			Thread.sleep(1000);
			WebElement tablerow = utils.getProviderResultsBasedOnValues(tblWorkBasket, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
			rowCol.get(0).click();
			return true;

		}catch(Exception e)
		{
			err.logcommonMethodError("Home", "validateRowandClickSRIDInWorkBasket");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR
	 * #Description: Validates the SR displayed in the WorkBasket table by getting the SR ID from the Rescent work and click the SR
	 * Type: Textbox
	 */
	public boolean validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR() throws InterruptedException
	{
		try
		{
			System.out.println("String Value is: "+recentSRname);
			String args[] = recentSRname.split(",");
			String tablevalues[] = ("ID:"+args[0]).split(",");
			Thread.sleep(1000);
			System.out.println("Waiting for table load");  
			WebElement tablerow = utils.getProviderResultsBasedOnValues(this.tblWorkBasket, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
			rowCol.get(0).click();
			return true;

		}
		catch(NullPointerException e)
		{
			err.logError(e, "validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR, SR Table is empty for the search result");
			return false;
		}
		catch(Exception e)
		{
			err.logcommonMethodError("Home", "validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateRowandClickSRIDInWorkListByGettingSRIDFromFetchSR
	 * #Description: Validates the SR displayed in the WorkList table by getting the SR ID from the Rescent work and click the SR
	 * Type: Textbox
	 */
	public boolean validateRowandClickSRIDInWorkListByGettingSRIDFromFetchSR() throws InterruptedException
	{
		try
		{
			System.out.println("String Value is: "+recentSRname);
			String args[] = recentSRname.split(",");
			String tablevalues[] = ("ID:"+args[0]).split(",");
			Thread.sleep(1000);
			System.out.println("Waiting for table load");  
			WebElement tablerow = utils.returntablerowbasedonvalues(this.tblWorklist, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
			rowCol.get(0).click();
			return true;

		}catch(Exception e)
		{
			err.logcommonMethodError("Home", "validateRowandClickSRIDInWorkListByGettingSRIDFromFetchSR");
			return false;
		}

	}

	public boolean selectdropDownViewQueueFor(String[] visibletext) 
	{
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(this.dropDownViewForQueue, visibletext[0], "Home Page", "View for Queue");

	}

	public boolean validateRowandClickClaimNumberInWorkList(String[] tablevalues ) throws InterruptedException
	{
		WebElement tablerow = utils.getTablerowbasedonvalues(this.tblWorkBasket2, tablevalues);
		List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
		rowCol.get(1).click();
		new WebDriverWait(Driver.getPgDriver(),30).until(ExpectedConditions.numberOfWindowsToBe(2));
		return utils.TabHandles("Manage Claims");

	}

	@FindBy(xpath="//table[@pl_prop_class='Antm-FW-CSFW-Data-Notes']")
	private WebElement table;

	@FindBy(xpath="//tr[@id='$PpgRepPgSubSectionCPMMyWorkBasketListBBBBBBBBBBBBBBBBBB$ppxResults$l1']//a[@data-test-id='20160210145727026023512']")
	private WebElement SRworkbasket;

	public boolean SelectSRfromworkbasket(String[] value)
	{
		if(this.fetchSRFromRecentWorklist())
			if(this.navigateToMyWorkBasket())
				if(this.selectdropDownViewQueueFor(value))
					if(this.searchSRInTHeWorkBasket())
						return utils.clickAnelemnt(this.SRworkbasket, "Home Page ", "Home Tab");
		return false;
	}

	public boolean validateHomeScreenIsDisplayedOnClickingYesInOneDayGrievanceQuestion()
	{
		utils.waitforpageload();
		Driver.pgDriver.switchTo().defaultContent();
		return !utils.isProxyWebelement(sHeaderHome);
	}

	@FindBy(linkText="Dashboard")
	private WebElement Dashboard;

	@FindBy(linkText="My Reports")
	private WebElement MyReports;

	@FindBy(linkText="Manager tools")
	private WebElement Managertools;

	@FindBy(linkText="Administration")
	private WebElement Administration;

	@FindBy(linkText="Inventory Search")
	private WebElement InventorySearch;


	public boolean verifyDashboardIsDisplayed()
	{    
		return !utils.isProxyWebelement(Dashboard);
	}

	public boolean verifyMyReportsIsDisplayed()
	{    
		return !utils.isProxyWebelement(MyReports);
	}

	public boolean verifyAdministrationIsDisplayed()
	{  
		return !utils.isProxyWebelement(Administration);
	}

	public boolean verifyInventorySearchIsDisplayed()
	{    
		return !utils.isProxyWebelement(InventorySearch);
	}

	public boolean VerifyAnthmCSWGSAccessGroupRole()
	{
		if (this.verifyInventorySearchIsDisplayed())
			if(this.verifyAdministrationIsDisplayed())
				if(this.verifyMyReportsIsDisplayed())
					if(this.verifyDashboardIsDisplayed())
						return true;
		return false;
	}

	public boolean searchInteractionfromSearchBar(String[] args) throws InterruptedException {
		return searchbyInteractionNumber(args[0]);
	}

	public boolean verifyPendingReasonColumnHeadersForENBUserWorkList()
	{
		System.out.println("Entered");
		utils.clickAnelemnt(this.sHeaderMyWorkList, "Home", "Worklist");
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblWorklist);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("ID");
		valuesGivenManual.add("Urgency");
		valuesGivenManual.add("Goal");
		valuesGivenManual.add("Claim Number");
		valuesGivenManual.add("HCID");
		valuesGivenManual.add("Member Name");
		valuesGivenManual.add("Pending Reason");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Values in the ENB Worklist table is matched with the values expected");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Values in the ENB Worklist table is not matched with the values expected");
			return false;
		}
	}


	public boolean verifyPendingReasonForENBUserWorkList(String[] tablevalues)
	{
		if(utils.clickAnelemnt(this.sHeaderMyWorkList, "Home", "Worklist"))
			return utils.validatetablerowbasedonvalues(this.tblWorklist, tablevalues);
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: fetchSRFromRecentWorklist
	 * #Description: This functionality captures latest SR from My Recent work tab
	 * Type: Textbox
	 */	
	public boolean searchSRInTHeWorkList(){
		utils.waitforpageload();
		if(utils.clickAnelemnt(sHeaderMyWorkList, "Home", "My Work List"))
			if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, recentSRname, "Home", "Search Box"))
				return utils.clickAnelemnt(this.btnsearch, "Home", "Search Button");
		return false;
	}

	public boolean verifyBHColumnHeadersForGandAWorkbaskets()
	{
		System.out.println("Entered");
		utils.clickAnelemnt(this.sHeaderMyWorkBasket, "Home", "Workbasket");
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblWorkBasket);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("ID");
		valuesGivenManual.add("Urgency");
		valuesGivenManual.add("Type");
		valuesGivenManual.add("Appeal Type");
		valuesGivenManual.add("Policy State");
		valuesGivenManual.add("Line of Business");
		valuesGivenManual.add("Funding Type");
		valuesGivenManual.add("Group");
		valuesGivenManual.add("BH");
		valuesGivenManual.add("Pharmacy");
		valuesGivenManual.add("Source");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Values in the GandA workbasket table is matched with the values expected");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Values in the GandA workbasket table is not matched with the values expected");
			return false;
		}
	}



	public boolean verifyPharmacyColumnHeadersForGandAWorkbaskets()
	{
		System.out.println("Entered");
		utils.clickAnelemnt(this.sHeaderMyWorkBasket, "Home", "Workbasket");
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblWorkBasket);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("ID");
		valuesGivenManual.add("Urgency");
		valuesGivenManual.add("Type");
		valuesGivenManual.add("Appeal Type");
		valuesGivenManual.add("Policy State");
		valuesGivenManual.add("Line of Business");
		valuesGivenManual.add("Funding Type");
		valuesGivenManual.add("Group");
		valuesGivenManual.add("BH");
		valuesGivenManual.add("Pharmacy");
		valuesGivenManual.add("Source");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Values in the GandA workbasket table is matched with the values expected");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Values in the GandA workbasket table is not matched with the values expected");
			return false;
		}
	} 


	public boolean verifyOneDayGrievanceColumnHeadersForClaimsWorkbaskets()
	{
		utils.clickAnelemnt(this.sHeaderMyWorkBasket, "Home", "Workbasket");
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblWorkBasket);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("ID");
		valuesGivenManual.add("Urgency");
		valuesGivenManual.add("Goal");
		valuesGivenManual.add("HCID");
		valuesGivenManual.add("Category");
		valuesGivenManual.add("Status");
		valuesGivenManual.add("One Day Grievance");
		valuesGivenManual.add("Claim Number");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Values in the GandA workbasket table is matched with the values expected");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Values in the GandA workbasket table is not matched with the values expected");
			return false;
		}
	} 


	public boolean verifyValuesInGandAWorkbasketsUnderTheColumnHeaders(String[] tablevalues)
	{
		if(utils.clickAnelemnt(this.sHeaderMyWorkBasket, "Home", "Workbasket"))
			return utils.validatetablerowbasedonvalues(this.tblWorkBasket, tablevalues);
		return false;

	}

	@FindBy(xpath="//*[@pl_prop_class='Antm-CS-WGS-Work']")
	WebElement RecentWorklistTable;

	public boolean validateRowsUsingSRIDInMyRecentWorkTab(String[] args) {
		args[0] = "ID:"+ProviderComposite.SRIDAfterSubstring;
		return utils.validatetablerowbasedonvalues(RecentWorklistTable, args);
	}

	public boolean validateRowsUsingInteractionIDInMyRecentWorkTab(String[] args) {
		args[0] ="ID:"+Header.InteractionIDvalue;
		System.out.println(args[0]);
		return utils.validatetablerowbasedonvalues(RecentWorklistTable, args);
	}

	public boolean validateRowandClickSRIDInWorkList(String[] tablevalues) throws InterruptedException
	{
		try
		{
			System.out.println("Entered method");
			WebElement tablerow = utils.getProviderResultsBasedOnValues(tblWorklist, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("td"));
			rowCol.get(0).click();
			return true;

		}catch(Exception e)
		{
			err.logcommonMethodError("Home", "validateRowandClickSRIDInWorkBasket");
			return false;
		}

	}

	@FindBy(xpath="//div[text()='No work assigned']")
	private WebElement noWorkAssigned;


	public boolean verifyNoWorkAssignedisPresent()
	{
		return !utils.isProxyWebelement(noWorkAssigned);
	}

	@FindBy(xpath="//*[@data-test-id='20160211001132080411721']")
	WebElement MyReportsTab;

	public boolean navigateTOMyReports()
	{		
		return	utils.clickAnelemnt(this.MyReportsTab, "MyReports","MyReports");
	}

	public boolean clickTabMyDailyProductivity()
	{
		wait=new WebDriverWait(Driver.pgDriver,20);
		wait.until(ExpectedConditions.visibilityOf(this.sHeaderMyDailyProductivity));
		return utils.clickAnelemnt(this.sHeaderMyDailyProductivity, "Home Page ", "My Daily Productivity");
	}

	public boolean navigateToMyDailyProductivity()
	{
		if(this.clickTabHome())
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			if(this.checkforpageload())
				return this.clickTabMyDailyProductivity();
		}
		return false;
	}

	@FindBy(id="headerlabel8120")
	WebElement ServiceRequestLevelProductivityForYesterday;

	public boolean verifyServiceRequestLevelProductivityForYesterday() throws Exception
	{
		return utils.validateValueinelement(ServiceRequestLevelProductivityForYesterday, "Service Request Level Productivity For Yesterday");

	}

	@FindBy(id="headerlabel232")
	WebElement ServiceRequestLevelProductivityForToday;

	public boolean verifyServiceRequestLevelProductivityForToday() throws Exception
	{
		utils.scrolltomiddle();
		return utils.validateValueinelement(ServiceRequestLevelProductivityForToday, "Service Request Level Productivity For Today");
	}

	public boolean navigateToHome()
	{
		return clickTabHome();
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR
	 * #Description: Validates the SR displayed in the WorkBasket table by getting the SR ID from the Rescent work and click the SR
	 * Type: Textbox
	 */
	public boolean validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSRExceptClaims() throws InterruptedException
	{
		try
		{
			String args = MemberComposite.SRIDAfterSubstring;
			System.out.println("SR Name: "+args);
			String tablevalues[] = ("ID:"+args).split(",");
			Thread.sleep(1000);
			System.out.println("Waiting for table load");  
			WebElement tablerow = utils.getProviderResultsBasedOnValues(this.tblWorkBasket, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
			rowCol.get(0).click();
			return true;

		}catch(Exception e)
		{
			err.logcommonMethodError("Home", "validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateRowandClickSRIDInWorkListByGettingSRIDFromFetchSR
	 * #Description: Validates the SR displayed in the WorkList table by getting the SR ID from the Rescent work and click the SR
	 * Type: Textbox
	 */
	public boolean validateRowandClickSRIDInWorkListByGettingSRIDFromFetchSRExceptCliams() throws InterruptedException
	{
		try
		{
			String args = MemberComposite.SRIDAfterSubstring;
			System.out.println("SR Name: "+args);
			String tablevalues[] = ("ID:"+args).split(",");
			Thread.sleep(1000);
			System.out.println("Waiting for table load");  
			WebElement tablerow = utils.returntablerowbasedonvalues(this.tblWorklist, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
			rowCol.get(0).click();
			return true;
		}catch(Exception e)
		{
			err.logcommonMethodError("Home", "validateRowandClickSRIDInWorkListByGettingSRIDFromFetchSR");
			return false;
		}

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: searchSRInTHeWorkBasket
	 * #Description: This functionality enters the latest SR captured from Recent worklist tab and clicks the search button and then clicks the SR link from the results.
	 * Type: Textbox
	 */		

	public boolean searchSRInTHeWorkBasketExceptClaims(){
		System.out.println("SR: "+MemberComposite.SRIDAfterSubstring);
		if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, MemberComposite.SRIDAfterSubstring, "Home", "Search Box"))
			return utils.clickAnelemnt(this.btnsearch, "Home", "Search Button");	
		return false;	
	}


	public boolean searchSRInTHeWorkListExceptClaims(){
		utils.waitforpageload();
		utils.waitForElementToBeVisible(sHeaderMyWorkList);
		if(utils.clickAnelemnt(this.sHeaderMyWorkList, "Home", "My Work List"))
			if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, MemberComposite.SRIDAfterSubstring, "Home", "Search Box"))
				return utils.clickAnelemnt(this.btnsearch, "Home", "Search Button");
		return false;	
	}

	/**
	 * Validates that the MyWorkList, MyWorkBasket, MyRecentWork, MyDailyProductivity tabs are available for the Manager role
	 * @return
	 */
	public boolean validateMyWorklistMyWorkBasketsMyRecentWorkMyDailyProductivityTabsAvailable()
	{
		if(!utils.isProxyWebelement(sHeaderMyRecentTabs))
			if(!utils.isProxyWebelement(sHeaderMyWorkBasket))
				if(!utils.isProxyWebelement(sHeaderMyWorkList))
					if(!utils.isProxyWebelement(sHeaderMyDailyProductivity))
						return true;
		return false;
	}

	/**
	 * Validates that MyWorkBasket tab is not displayed other than the Manager role
	 * @return
	 */
	public boolean validateMyWorklistMyRecentWorkMyDailyProductivityTabsAvailable()
	{
		if(!utils.isProxyWebelement(sHeaderMyRecentTabs))
			if(!utils.isProxyWebelement(sHeaderMyWorkList))
				if(!utils.isProxyWebelement(sHeaderMyDailyProductivity))
					return true;
		return false;
	}

	/**
	 * Validates that GMU button is displayed
	 * @return
	 */
	public boolean verifyGMUButtonIsDisplayed()
	{
		return !utils.isProxyWebelement(workListGetMostUrgentBtn);
	}

	/**
	 * Validates the  View Queue drop down values for No Voice CSR
	 * @param args
	 * @return
	 */
	public boolean validateViewQueueValuesForNovoiceCSR(String[] args)
	{	
		ArrayList<String> al = new ArrayList<String>();
		for(String arg : args)
		{
			al.add(arg);
		}
		return utils.checkvaluesinDropDown(dropDownForViewQueued, al);
	}

	/**
	 * Validates the View Queue drop down values for Intermediate CSR
	 * @param args
	 * @return
	 */
	public boolean validateViewQueueValuesForIntermediateCSR(String[] args)
	{	
		ArrayList<String> al = new ArrayList<String>();
		for(String arg : args)
		{
			al.add(arg);
		}
		return utils.checkvaluesinDropDown(dropDownForViewQueued, al);
	}

	/**
	 *  Validates the View Queue drop down values for Advanced CSR
	 * @param args
	 * @return
	 */
	public boolean validateViewQueueValuesForAdvancedCSR(String[] args)
	{	
		ArrayList<String> al = new ArrayList<String>();
		for(String arg : args)
		{
			al.add(arg);
		}
		return utils.checkvaluesinDropDown(dropDownForViewQueued, al);
	}

	/**
	 *  Validates the View Queue drop down values for OE
	 * @param args
	 * @return
	 */
	public boolean validateViewQueueValuesForOE(String[] args)
	{	
		ArrayList<String> al = new ArrayList<String>();
		for(String arg : args)
		{
			al.add(arg);
		}
		return utils.checkvaluesinDropDown(dropDownForViewQueued, al);
	}

	/**
	 *  Validates the View Queue drop down values for Manager
	 * @param args
	 * @return
	 */
	public boolean validateViewQueueValuesForManager(String[] args)
	{	
		ArrayList<String> al = new ArrayList<String>();
		for(String arg : args)
		{
			al.add(arg);
		}
		return utils.checkvaluesinDropDown(dropDownForViewQueued, al);
	}

	@FindBy(xpath="//table[@pl_prop='pgRepPgSubSectionCPMMyRecentWorkB.pxResults']")
	WebElement tblRecentWork;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateRowandClickSRIDInRescentWorkByGettingSRIDFromFetchSR
	 * #Description: Validates the SR displayed in the Recent Work table by getting the SR ID from the Rescent work and click the SR
	 * Type: Textbox
	 */
	public boolean validateRowandClickSRIDInRescentWorkByGettingSRIDFromFetchSR() throws InterruptedException
	{
		try
		{
			System.out.println("String Value is: "+recentSRname);
			String args[] = recentSRname.split(",");
			String tablevalues[] = ("ID:"+args[0]).split(",");
			Thread.sleep(1000);
			System.out.println("Waiting for table load");  
			WebElement tablerow = utils.getProviderResultsBasedOnValues(this.tblRecentWork, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
			rowCol.get(0).click();
			return true;

		}catch(NullPointerException e)
		{
			err.logError(e, "Work basket table Empty");
			return false;
		}catch(Exception e)
		{
			err.logcommonMethodError("Home", "validateRowandClickSRIDInRescentWorkByGettingSRIDFromFetchSR");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateRowandClickSRIDInRescentWorkByGettingSRIDFromFetchSR
	 * #Description: Validates the SR displayed in the Recent Work table by getting the SR ID from the Rescent work and click the SR
	 * Type: Textbox
	 */
	public boolean validateRowandClickSRIDInRescentWorkByGettingSRIDFromFetchSRForOpen() throws InterruptedException
	{
		try
		{
			System.out.println("String Value is: "+recentSRname);
			String args[] = recentSRname.split(",");
			String tablevalues[] = ("ID:"+args[0]).split(",");
			Thread.sleep(1000);
			System.out.println("Waiting for table load");  
			WebElement tablerow = utils.getProviderResultsBasedOnValues(this.tblRecentWork, tablevalues);
			List<WebElement> rowCol = tablerow.findElements(By.tagName("a"));
			rowCol.get(0).click();
			Driver.pgDriver.switchTo().alert().accept();
			return true;

		}catch(Exception e)
		{
			err.logcommonMethodError("Home", "validateRowandClickSRIDInRescentWorkByGettingSRIDFromFetchSR");
			return false;
		}

	}


	public boolean searchSRInTHeRecentWork(){
		utils.waitforpageload();
		if(utils.clickAnelemnt(sHeaderMyRecentTabs, "Home", "My Work List"))
			if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, recentSRname, "Home", "Search Box"))
				return utils.clickAnelemnt(this.btnsearch, "Home", "Search Button");
		return false;	
	}

	@FindBy(xpath="//label[@for='BrokerName']//following-sibling::div//span[@data-test-id='201509171111100835311891']")
	WebElement labelBrokerNameValue;

	@FindBy(xpath="//label[@for='AgencyTIN']//following-sibling::div//span[@data-test-id='201509180929400234553780']")
	WebElement labelTINValue;

	@FindBy(xpath="//label[@for='CAParentID']//following-sibling::div//a[@data-test-id='20160220155047038739106']")
	WebElement linkInteractionIDValue;

	@FindBy(xpath="//label[@for='pyFullName']//following-sibling::div//span[@data-test-id='201509171111100835311891']")
	WebElement labelMemberNameValue;

	@FindBy(xpath="//label[@for='HCIDDisplay']//following-sibling::div//span[@data-test-id='201509180929400234553780']")
	WebElement labelMemberIDValue;

	@FindBy(xpath="//label[@for='Age']//following-sibling::div//span[@data-test-id='201509171111100835312438']")
	WebElement labelAgeValue;

	@FindBy(xpath="//label[@for='PolicyState']//following-sibling::div//span[@data-test-id='20160220155047038739106']")
	WebElement labelPolicyBasedOutValue;


	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForResearchInteraction()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(linkInteractionIDValue))
					if(!utils.isProxyWebelement(labelMemberNameValue))
						if(!utils.isProxyWebelement(labelMemberIDValue))
							if(!utils.isProxyWebelement(labelAgeValue))
								if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
									return true;

		return false;
	}



	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForEmailInteraction()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(linkInteractionIDValue))
					if(!utils.isProxyWebelement(labelMemberNameValue))
						if(!utils.isProxyWebelement(labelMemberIDValue))
							if(!utils.isProxyWebelement(labelAgeValue))
								if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
									return true;

		return false;
	}


	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForEmailInteractionForOpen()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(labelMemberNameValue))
					if(!utils.isProxyWebelement(labelMemberIDValue))
						if(!utils.isProxyWebelement(labelAgeValue))
							return true;

		return false;
	}

	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForPhoneInteractionForOpen()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(labelMemberNameValue))
					if(!utils.isProxyWebelement(labelMemberIDValue))
						if(!utils.isProxyWebelement(labelAgeValue))
							if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
								return true;

		return false;
	}



	public boolean validateAllTheLabelsPresentInTheInteractionHeaderForPhoneInteraction()
	{
		if(!utils.isProxyWebelement(labelBrokerNameValue))
			if(!utils.isProxyWebelement(labelTINValue))
				if(!utils.isProxyWebelement(linkInteractionIDValue))
					if(!utils.isProxyWebelement(labelMemberNameValue))
						if(!utils.isProxyWebelement(labelMemberIDValue))
							if(!utils.isProxyWebelement(labelAgeValue))
								if(!utils.isProxyWebelement(labelPolicyBasedOutValue))
									return true;

		return false;
	}

	public boolean validateAlertPopUpInPaymentDispute()
	{
		String alerttext = Driver.pgDriver.switchTo().alert().getText();
		if(utils.isvalueMatch_contain(alerttext,"Grievance and Appeals/Payment Dispute"))

			return utils.isAlertPresent(); 
		return false;
	}

	@FindBy(xpath="//table[contains(@pl_prop,'pgRepPgSubSectionCPMMyWorkBasketList')]")
	WebElement WorkBasketResult;
	
	@FindBy(xpath="//table[contains(@pl_prop,'pgRepPgSubSectionpyUserWorkListB.pxResults')]//a[@data-test-id='20160210145727026023512']")
	WebElement WorkListResult;

	public boolean searchAndSelectSRFromWorkBasket(String[] args) throws InterruptedException {
		if(clickMyWorkbasketsTab())
			if(selectViewQueuedDropdown(args))
				if(searchSRInTHeWorkBasket()) {
					Thread.sleep(3000);
					if(!utils.isProxyWebelement(WorkBasketResult)) {
						return validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR();

					}else {
						if(MemberComposite_PolicySection.policystate.isEmpty()) {
							String[] nopolicyfrontofficeWBname = ("Customer Service No Policy State").split("-");
							if(selectViewQueuedDropdown(nopolicyfrontofficeWBname)) 
								if(searchSRInTHeWorkBasket()) {
									Thread.sleep(3000);
									if(!utils.isProxyWebelement(WorkBasketResult)) {
										blogger.loginfo("WB in Customer Service No Policy State");
										if(validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR())
											if(utils.setServiceDown("SR Moved to No Policy State Work Basket - Front Office"))
												return false;
									}else {
										String[] nopolicyWBname1 = (args[0]+" No Policy State").split("-");
										if(selectViewQueuedDropdown(nopolicyWBname1)) 
											if(searchSRInTHeWorkBasket()) {
												Thread.sleep(3000);
												if(!utils.isProxyWebelement(WorkBasketResult)) {
													blogger.loginfo("WB No Policy State");
													if(validateRowandClickSRIDInWorkBasketByGettingSRIDFromFetchSR())
														if(utils.setServiceDown("SR Moved to No Policy State Work Basket - Back Office"))
															return false;
												}
											}
									}
									return false;
								}
							return false;
						}
						blogger.loginfo("Policy state is not blank and SR ID is not present in the WB");
						return false;
					}

				}

		blogger.loginfo("SR is not Present in WorkBasket");
		return false;

	}
	
	public boolean searchAndSelectSRFromWorkList() throws InterruptedException {
		if(clickTabMyWorkList())
			if(searchSRInTHeWorkList()) {
					Thread.sleep(1000);
					if(!utils.isProxyWebelement(WorkListResult)) {
						return validateRowandClickSRIDInWorkListByGettingSRIDFromFetchSR();
					}else {
						if(MemberComposite_PolicySection.policystate.isEmpty()) {
							if(utils.setServiceDown("SR Moved to No Policy State Work Basket - Front Office"))
								return false;
						}
						blogger.loginfo("Policy state is not blank and SR ID is not present in the Worklist");
						return false;
					}

				}

		blogger.loginfo("SR is not Present in WorkBasket");
		return false;

	}
	
	@FindBy(xpath="//a[text()='Administration']")
	WebElement AdministrationTab;
	
	public boolean clickAdministrationTab(){
		return utils.clickAnelemnt(AdministrationTab, "Home", "AdministrationTab");
		
	}
	
	@FindBy(xpath="//table[contains(@pl_prop,'pgRepPgSubSectionpyUserWorkListB')]//tr[@class='oddRow cellCont']//td")
	WebElement IntID;
	
	public boolean searchandOpenInteractionfromTheWorkList(){
		utils.waitforpageload();
		if(utils.clickAnelemnt(sHeaderMyWorkList, "Home", "My Work List"))
			if(utils.enterTextinAnelemnt(this.txtboxSearchInteraction, recentIntractionname, "Home", "Search Box"))
				if( utils.clickAnelemnt(this.btnsearch, "Home", "Search Button"))
						return utils.clickAnelemnt(IntID, "Home", "IntID");
		
		return false;
	}

}



