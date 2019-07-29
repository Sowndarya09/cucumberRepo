package automationLib;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;



public class SearchInventory
{

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderLimited;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Load More Data')]")
	private WebElement btnLoadMoreData;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Load More Data')]//img")
	private WebElement chkLoadData;
	@FindBy(linkText="Next")
	public WebElement lnkNext;

	@FindBy(xpath="//input[@id='ClaimNumber']")
	public WebElement claimno;
	@FindBy(xpath="//div[@class='pzbtn-mid'][text()='Search']")
	public WebElement SrchButton;
	@FindBy(xpath="//button[@name='SearchByCriteria_pyWorkPage_23']//*[@class='pzbtn-mid'][contains(text(),'Clear Search')]//img")
	public WebElement ClrSrchButton;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement BtnSubmit;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;
	@FindBy(id="CancellationReason")
	WebElement drpdwnCancellationreason;
	@FindBy(xpath="//*[@class='radioTable']//input[@id='SearchForCriteriaService Requests']")
	public WebElement RadioSR;
	@FindBy(xpath="//*[@class='radioTable']//input[@id='SearchForCriteriaInteractions']")
	public WebElement RadioInteraction;
	@FindBy(xpath="//*[@class='radioTable']//input[@id='SearchForCriteriaInquiry Tracking']")
	public WebElement RadioInqry;

	//Expand prop of each table
	@FindBy(xpath="//div[@id='CT']/div[@param_name='EXPANDEDSubSectionSearchByCriteriaBBBBBB~pzLayout_6']")
	public WebElement expandSR;

	@FindBy(xpath="//div[@id='CT']/div[@param_name='EXPANDEDSubSectionSearchByCriteriaBBBBBBBB~pzLayout_8']")
	public WebElement expandInt;
	@FindBy(xpath="//div[@id='CT']/div[@param_name='EXPANDEDSubSectionSearchByCriteriaBBBBBBBBB~pzLayout_9']")
	public WebElement expandInq;

	//results table
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT' and @columnlist=' .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']")
	public WebElement ResultsTableSR;
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']")
	public WebElement ResultsTableInt;
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']")
	public WebElement ResultsTableIquiry;
	//child window objects
	@FindBy(xpath="//table[@class='containerBody']")
	WebElement childWindowTable;
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Close']")
	WebElement ChildCloseWindow;
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span")
	WebElement txtStatusInq;

	@FindBy(xpath="//div[@rdname='ServiceItem_SearchByCriteria']//*[@aria-label='Page 1']")
	WebElement linkPage1;
	@FindBy(xpath="//*[@rdname='InteractionsByClaimNumber']//*[@aria-label='Page 2']")
	WebElement linkPage2;
	@FindBy(xpath="//div[@rdname='ServiceItem_SearchByCriteria']//*[@aria-label='Page 4']")
	WebElement linkPage4;

	@FindBy(xpath="//th[@data-attribute-name='Open Date']//span[@title='Click to sort']")
	WebElement ArrowToSortOpenDtSR;
	@FindBy(xpath="//th[@data-attribute-name='Created On']//span[@title='Click to sort']")
	WebElement ArrowToSortCreatedDtInt;
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//th[@data-attribute-name='Status']//div[@class='cellIn '][text()='Status']")
	WebElement ToSortStatusInq;
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT' and @columnlist=' .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//th[@data-attribute-name='Status']")
	WebElement ToSortStatusSR;

	@FindBy(xpath="//span[@title='Click to sort' and @class=' pointerStyle ']")
	WebElement ArrowToSortOpenedDtInq1;
	@FindBy(xpath="//span[@title='Click to sort' and @class=' pointerStyle DESC']")
	WebElement ArrowToSortOpenedDtInq2;
	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Open Date']//span")
	WebElement OpenDtStart;
	@FindBy(xpath="//div[@rdname='ServiceItem_SearchByCriteria']//a[text()='Next']")
	WebElement linkNextSR;

	@FindBy(xpath="//*[@data-test-id='201605050416420534463347']")
	List <WebElement> tblcolumnopendate;

	@FindBy(xpath="//label[@data-test-id='20141007100011081143780']/a[text()='Next']")
	WebElement labelNext;

	@FindBy(xpath="//*[@data-test-id='201605050416420531460647']")
	List <WebElement> tblcolumnstatus;


	public SearchInventory() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	Actions action=new Actions(Driver.getPgDriver());	



	public boolean waitforpageload()
	{

		try{
			Thread.sleep(2000);
			System.out.println("Checking if Loading icon is present");
			WebDriverWait wait = new WebDriverWait(Driver.getPgDriver(),20);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));

		}
		catch(Exception e){
			System.out.println("Loading icon exceeded time out ");

		}
		System.out.println("Came out");
		return true;
	}


	public WebElement getHeader()
	{
		return sHeaderLimited;
	}
	public boolean ClickLoadMoreData()
	{
		WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);
		wait.until(ExpectedConditions.visibilityOf(this.btnLoadMoreData));
		utils.clickAnelemnt(btnLoadMoreData, "Limited Liability", "Load More Data Button");
		return true;
	}
	@FindBy(xpath="//button[@name='ViewLimitedLiability_DataPage_161']")
	public WebElement ButtonProp;

	public boolean ClickUntilLastPage()
	{
		//click Load More data button un till last page
		try
		{
			//this.chkLoadData.getAttribute("disabled").equals("disabled");
			this.ButtonProp.getAttribute("disabled").equals("");

		}
		catch(Exception e)
		{
			this.ClickLoadMoreData();
			ClickUntilLastPage();
		}

		return true;
	}
	public boolean EnterClaimNumber(String[] DCN)
	{
		return utils.enterTextinAnelemnt(this.claimno, DCN[0], "Search Inventory ", "Text Box for entering claim number");


	}
	public boolean SearchByServiceRequest()
	{

		utils.clickAnelemnt(this.RadioSR,"Search Inventory", "Service request Radio Button");
		return utils.clickAnelemnt(this.SrchButton, "Search Inventory", "Search Button");


	}
	public boolean SearchByInteraction()
	{
		utils.clickAnelemnt(this.RadioInteraction,"Search Inventory", "Interactions Radio Button");
		return utils.clickAnelemnt(this.SrchButton, "Search Inventory", "Search Button");

	}
	public boolean SearchByInquiryTracking()
	{
		utils.clickAnelemnt(this.RadioInqry,"Search Inventory", "Inquiry tracking Radio Button");
		return utils.clickAnelemnt(this.SrchButton, "Search Inventory", "Search Button");

	}

	public boolean validateRadiobuttons(){

		if(utils.clickAnelemnt(this.RadioSR,"Search Inventory", "Service request Radio Button")){
			if(utils.clickAnelemnt(this.RadioInteraction,"Search Inventory", "Interactions Radio Button")){
				if(utils.clickAnelemnt(this.RadioInqry,"Search Inventory", "Inquiry tracking Radio Button")){
					return true;
				}else return false;
			}else return false;
		}else return false;
	}



	public boolean ClearSearch()
	{
		return utils.clickAnelemnt(this.ClrSrchButton, "Search Inventory", "Clear Search Button");
	}
	public boolean clickButtonSubmit()
	{
		if(utils.clickAnelemnt(this.BtnSubmit, "Search Inventory", "Button to click Submit")) {
			utils.waitforpageload();
		return true;
		}
		return false;
	}
	public boolean CancelSearchInventory(String[] cancelreason)
	{
		boolean returnvar=true;
		String reason=null;
		for(String iterator : cancelreason)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("Search Inventory", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("reason"))
			{			
				returnvar=true;
				reason=value.toLowerCase().trim();
				if(reason.contains("error"))
					reason="Created in Error";
				else if(reason.contains("request"))
					reason="Contact Withdrew Request";
				else if(reason.contains("duplicate"))
					reason="Duplicate";
				else if(reason.contains("end"))
					reason="interaction Ended";
				else
				{
					err.logcommonMethodError("Cancel Search Inventory", "Check your Reason for Cancellation");
				}
				continue;

			}

			else
			{
				err.logcommonMethodError("Cancel Search Inventory", "Check your key in your keypair. Make sure you are following the same pattern for input");
				return false;
			}

		}
		if(utils.clickAnelemnt(this.btnOtherActions, "Search Inventory", "Other Actions Button"))
		{
			if(utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Search Inventory", "Cancel this Work"))
			{
				if(utils.validateHeader(this.getHeader(),"Cancel this work"))
				{
					if(utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, reason, "Cancel Search Inventory", "Cancel reason"))
					{
						if(utils.clickAnelemnt(this.BtnSubmit, "Cancel Search Inventory", "Submit button on cancel Search Inventory"));
						return true;
					}
					else
						return false;
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	
	public boolean ValidateServiceRequest() throws InterruptedException
	{


		if(GetFirstHyperlinkSR(this.ResultsTableSR)){
			return true;

		}
		else
		{
			err.logError("Results table displaying in collapsed mode");
			return false;

		}


	}
	public boolean GetFirstHyperlinkSR(WebElement tb) throws InterruptedException
	{
		WebElement srchResults = tb;

		WebElement allColsByRow =srchResults.findElement(By.xpath("//td[@data-attribute-name='SR-ID']//a"));

		String id=allColsByRow.getText();

		System.out.println("ID is : "+id);
		return this.click_handle_PopWindow(allColsByRow, "View Service Item Details", "Search Inventory", "First Hyperlink");//element 2 to be the entire table
		

	}

	public boolean GetFirstHyperlinkInt(WebElement tb) throws InterruptedException
	{
		WebElement srchResults = tb;

		WebElement allColsByRow =srchResults.findElement(By.xpath("//td[@data-attribute-name='Interaction ID']//a"));

		String id=allColsByRow.getText();

		System.out.println("ID is : "+id);
		this.click_handle_PopWindow(allColsByRow,id, "Search Inventory", "First Hyperlink");//element 2 to be the entire table
		return true;

	}

	public boolean GetFirstHyperlinkInq(WebElement tb) throws InterruptedException
	{
		WebElement srchResults = tb;

		WebElement allColsByRow =srchResults.findElement(By.xpath("//a[@title='IQT Number']"));

		String id=allColsByRow.getText();

		System.out.println("ID is : "+id);
		this.click_handle_PopWindow(allColsByRow, "View Inquiry Tracking (IQT) Details", "Search Inventory", "First Hyperlink");//element 2 to be the entire table
		return true;

	}

	public boolean click_handle_PopWindow(WebElement el,String id,String pgname,String elename) throws InterruptedException 
	{ 
		String parentHandle = Driver.pgDriver.getWindowHandle(); // get the current window handle 

		System.out.println("Current Window Handle: "+parentHandle); 
		//utils.clickAnelemnt(el, pgname, elename);
		utils.clickAnelemnt(el, pgname, elename);
		System.out.println("Element clicked"); 
		//Thread.sleep(6000);
		Set<String> allwindowhandles= Driver.pgDriver.getWindowHandles();
		while(allwindowhandles.size()==1)
		{
			allwindowhandles= Driver.pgDriver.getWindowHandles(); 
			//System.out.println("count"+allwindowhandles.size());
		}

		for(String winHandle : Driver.pgDriver.getWindowHandles()) 
		{ 
			if(winHandle.equalsIgnoreCase(parentHandle)) 
			{
				Driver.pgDriver.getWindowHandles().remove(winHandle);
				System.out.println("Current Window Handle same as parent: "+winHandle); 
			}
			else
			{

				Driver.pgDriver.switchTo().window(winHandle);
				// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				System.out.println("Current Window Handle: "+winHandle); 
				String title=Driver.pgDriver.getTitle();
				System.out.println("Page Title is " +title);
				if(title.contains(id))
				{
					System.out.println("Page title is Matching : "+title);
					return true;
				}
				else
				{
					err.logError("Review Pop up Window", "Title ");
					return false;
				}

			}
		}
		//Driver.pgDriver.switchTo().window(parentHandle);
		//utils.clickAnelemnt(el, "src", "parent click");
		return true;

	} 
	public boolean ValidateInteraction() throws InterruptedException
	{


		if(GetFirstHyperlinkInt(this.ResultsTableInt)){

			return true;
		}
		else
		{
			err.logError("Results table displaying in collapsed mode");
			return false;

		}

	}
	public boolean ValidateInquiry() throws InterruptedException
	{

		if(GetFirstHyperlinkInq(this.ResultsTableIquiry)){
			return true;
		}
		else
		{
			err.logError("Results table displaying in collapsed mode");
			return false;

		}


	}
	public boolean ValidateHeadersSR(String[] args)

	{
		this.waitforpageload();
		WebElement srchResults = this.ResultsTableSR;
		WebElement allRows = srchResults.findElement(By.tagName("tr"));


		List<WebElement> allColsByRow=null;

		allColsByRow =allRows.findElements(By.tagName("th"));
		System.out.println("Size of headers : "+allColsByRow.size());

		for(int i=1;i<=allColsByRow.size();i++)
		{
			String val= allColsByRow.get(i-1).getAttribute("data-attribute-name").trim().toLowerCase();
			if(val.equalsIgnoreCase(args[i-1]))
			{
				System.out.println(val);
			}

			else
			{
				System.out.println(val);
				System.out.println("Header Name not matching");
				return false;
			}


		}

		return true;



	}
	public boolean ValidateHeadersInteraction(String[] args)
	{
		this.waitforpageload();
		WebElement srchResults = this.ResultsTableInt;
		WebElement allRows = srchResults.findElement(By.tagName("tr"));


		List<WebElement> allColsByRow=null;

		allColsByRow =allRows.findElements(By.tagName("th"));
		System.out.println("Size of headers : "+allColsByRow.size());

		for(int i=1;i<=allColsByRow.size();i++)
		{
			String val= allColsByRow.get(i-1).getAttribute("data-attribute-name").trim().toLowerCase();
			if(val.equalsIgnoreCase(args[i-1]))
			{
				System.out.println(val);
			}

			else
			{
				System.out.println(val);
				System.out.println("Header Name not matching");
				return false;
			}


		}

		return true;
	}



	public boolean ValidateHeadersInquiry(String[] args)
	{
		this.waitforpageload();
		WebElement srchResults = this.ResultsTableIquiry;
		WebElement allRows = srchResults.findElement(By.tagName("tr"));


		List<WebElement> allColsByRow=null;

		allColsByRow =allRows.findElements(By.tagName("th"));
		System.out.println("Size of headers : "+allColsByRow.size());

		for(int i=1;i<=allColsByRow.size();i++)
		{
			String val= allColsByRow.get(i-1).getText().trim().toLowerCase();
			if(val.equalsIgnoreCase(args[i-1]))
			{
				System.out.println(val);
			}
			else
			{
				System.out.println(val);
				System.out.println("Header Name not matching");
				return false;
			}



		}
		return true;

	}

	public boolean validatePaginationSR(){

		List<WebElement> allColsByRow =Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist=' .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td//a"));

		int RowCount=allColsByRow.size();

		System.out.println("RowCount is : "+RowCount);
		if(RowCount==25)

			return true;
		else if(RowCount<25)
		{
			err.logError("No. of records are less than 25. Pagination should be 25 records");

			return false;
		}

		else
		{
			err.logError("No. of records exceeded. Pagination should be 25 records");

			return false;
		}


	}

	public boolean validatePaginationInt(){

		List<WebElement> allColsByRow =Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']//td//a"));

		int RowCount=allColsByRow.size();

		System.out.println("RowCount is : "+RowCount);
		if(RowCount==25)
		{
			if(this.linkPage2.isDisplayed()){
				return true;
			}
			else return false;
		}


		else if(RowCount<25)
		{
			err.logError("No. of records are less than 25. Pagination should be 25 records");

			return false;
		}

		else if(RowCount>25)
		{
			err.logError("No. of records exceeded. Pagination should be 25 records");

			return false;
		}

		else{

			return false;
		}

	}

	public boolean validatePaginationInq(){


		List<WebElement> allColsByRow =Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td//a"));

		int RowCount=allColsByRow.size();

		System.out.println("RowCount is : "+RowCount);
		if(RowCount==7)
		{

			return true;

		}


		else if(RowCount<7)
		{
			err.logError("No. of records are less than 7. Pagination should be 7 records");

			return false;
		}

		else if(RowCount>7)
		{
			err.logError("No. of records exceeded. Pagination should be 7 records");

			return false;
		}

		else{

			return false;
		}

	}



	public boolean validateStatusInq(){


		List<WebElement> allColsByRow =Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));

		System.out.println("No of results :"+allColsByRow.size());
		int iterator = 0;
		for (WebElement Row : allColsByRow) {

			String status = Row.getText();
			System.out.println("status is "+status);
			if(status.equalsIgnoreCase("closed")||status.equalsIgnoreCase("pended")||status.equalsIgnoreCase("open")||status.equalsIgnoreCase("routed"))

				iterator++;
		}return true;

	}

	public boolean validateCreatedOnDtFormatInt(){


		List<WebElement> allColsByRow =Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Created On']//span"));

		System.out.println("No of results :"+allColsByRow.size());
		int iterator = 0;
		for (WebElement Row : allColsByRow) {

			String CreatedOnDate = Row.getText();
			System.out.println("CreatedOnDate is "+CreatedOnDate);
			SimpleDateFormat date = new SimpleDateFormat("MM/DD/YYYY");
			try{
				date.parse(CreatedOnDate);
			}
			catch(ParseException pe)
			{
				System.out.println("Exception is "+pe);
			}
			iterator++;
		}return true;

	}

	public boolean validateCreatedOnDtFormatSR(){


		List <WebElement> OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Open Date']//span"));

		System.out.println("No of results :"+OpenDates.size());
		int iterator = 0;
		for (WebElement Row : OpenDates) {

			String CreatedOnDate = Row.getText();
			System.out.println("CreatedOnDate is "+CreatedOnDate);
			SimpleDateFormat date = new SimpleDateFormat("MM/DD/YYYY");
			try{
				date.parse(CreatedOnDate);
			}
			catch(ParseException pe)
			{
				System.out.println("Exception is "+pe);
			}
			iterator++;
		}return true;

	}

	public boolean validateCreatedOnDtFormatInq(){


		List <WebElement> OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@headers='a2']//span"));

		System.out.println("No of results :"+OpenDates.size());
		int iterator = 0;
		for (WebElement Row : OpenDates) {

			String CreatedOnDate = Row.getText();
			System.out.println("CreatedOnDate is "+CreatedOnDate);
			SimpleDateFormat date = new SimpleDateFormat("MM/DD/YYYY");
			try{
				date.parse(CreatedOnDate);
			}
			catch(ParseException pe)
			{
				System.out.println("Exception is "+pe);
			}
			iterator++;
		}return true;

	}

	public boolean sortbyDateInt() throws ParseException, InterruptedException {

		ArrayList<String> ExpectedCreatedDate = this.getCreatedDatesBeforeSortInt();
		ArrayList<String> CreatedDateAfterSort = this.getCreatedDatesAfterSortInt();

		for(int i =0;i<ExpectedCreatedDate.size();i++){
			for(int j =0;j<CreatedDateAfterSort.size();j++){

				if(ExpectedCreatedDate.get(i).equals(CreatedDateAfterSort.get(j))){
					return true;

				}
				else
					return false;

			}
		}
		return true;

	}

	public ArrayList<String> getCreatedDatesBeforeSortInt() throws ParseException, InterruptedException{

		List <WebElement> Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='InteractionsByClaimNumber']//a[contains(@aria-label,'Page')]"));
		int  pageCount = Pages.size();
		System.out.println("Number of pages :"+pageCount);
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();

		for (int i=0;i<pageCount;i++)
		{
			Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='InteractionsByClaimNumber']//a[contains(@aria-label,'Page')]"));
			Pages.get(i).click();

			List <WebElement> CreatedDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Created On']//span"));
			for(int j=0;j<CreatedDates.size();j++)
			{
				CreatedDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Created On']//span"));
				resultarray.add(CreatedDates.get(j).getText());

			}
			System.out.println(resultarray);


		}
		System.out.println("Before Sort : "+resultarray);
		Collections.reverse(resultarray);
		System.out.println("After reverse : "+resultarray);

		return resultarray;
	}

	public ArrayList<String> getCreatedDatesAfterSortInt() throws ParseException, InterruptedException{

		List <WebElement> Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='InteractionsByClaimNumber']//a[contains(@aria-label,'Page')]"));
		int  pageCount = Pages.size();
		System.out.println("Number of pages :"+pageCount);
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();

		Pages.get(0).click();

		utils.clickAnelemnt(this.ArrowToSortCreatedDtInt, "Search Inventory", "Created On Date Sort arrow button");
		WebDriverWait wait1 = new WebDriverWait(Driver.getPgDriver(),20);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//th[@data-attribute-name='Created On']//span[@class='pointerStyle DESC ']")));


		List <WebElement> CreatedDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Created On']//span"));
		for(int j=0;j<CreatedDates.size();j++)
		{
			CreatedDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Created On']//span"));
			resultarray.add(CreatedDates.get(j).getText());

		}
		for (int i=1;i<pageCount;i++)
		{
			Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='InteractionsByClaimNumber']//a[contains(@aria-label,'Page')]"));
			Pages.get(i).click();

			CreatedDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Created On']//span"));
			for(int j=0;j<CreatedDates.size();j++)
			{


				CreatedDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pxCreateDateTime .pxCreateOpName .PrimaryTask .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Created On']//span"));
				resultarray.add(CreatedDates.get(j).getText());

			}
			System.out.println(resultarray);


		}
		System.out.println("After Sort: "+resultarray);


		return resultarray;
	}

	public boolean sortbyDateSR()  {
		utils.scrolltomiddle();
		ArrayList<String> BeforesortOpenDate=new ArrayList<String>();
		ArrayList<String> AfterSortOpendate=new ArrayList<String>();
		boolean returnvar=false;

		for(WebElement iter:tblcolumnopendate)
			BeforesortOpenDate.add(iter.getText());

		blogger.loginfo("Before Sort: " +BeforesortOpenDate);
		System.out.println("Before Sort: " +BeforesortOpenDate);
		utils.clickAnelemnt(this.ArrowToSortOpenDtSR, "Search Inventory", "Open Date Sort arrow button");
		utils.waitforpageload();
		WebDriverWait wait= new WebDriverWait(Driver.pgDriver, 10);
		boolean isNextDisplayed = this.labelNext.isDisplayed();
		while(isNextDisplayed)
		{
			try {
			utils.waitforpageload();
			utils.clickAnelemnt(this.labelNext,"Searchinventory","Next");
			try{
				wait.until(ExpectedConditions.visibilityOf(labelNext));
				isNextDisplayed=true;
			}catch(TimeoutException e){
				isNextDisplayed=false;
			}


		} catch (StaleElementReferenceException e) {
			utils.waitforpageload();
			continue;
		}
		}

		for(WebElement iter:tblcolumnopendate)
			AfterSortOpendate.add(iter.getText());
		
		blogger.loginfo("After Sort: " +AfterSortOpendate);
		System.out.println("After Sort: " +AfterSortOpendate);
		Collections.reverse(AfterSortOpendate);
		blogger.loginfo("After Sort After reverse:" +AfterSortOpendate);
		for(int i=0;i<AfterSortOpendate.size();i++)
			returnvar=AfterSortOpendate.get(i).equals(BeforesortOpenDate.get(i));


		if(returnvar)
			blogger.loginfo("Open dates were sorted properly");

		else
			err.logerrormessage("opendates were not sorted properly");

		return returnvar;


	}

	public ArrayList<String> getOpenDatesBeforeSortSR() throws ParseException, InterruptedException{

		List <WebElement> Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='ServiceItem_SearchByCriteria']//a[contains(@aria-label,'Page')]"));
		int  pageCount = Pages.size();
		System.out.println("Number of pages :"+pageCount);
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();

		for (int i=0;i<pageCount;i++)
		{
			Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='ServiceItem_SearchByCriteria']//a[contains(@aria-label,'Page')]"));
			Pages.get(i).click();

			List <WebElement> OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Open Date']//span"));
			for(int j=0;j<OpenDates.size();j++)
			{
				OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Open Date']//span"));
				resultarray.add(OpenDates.get(j).getText());

			}
			System.out.println(resultarray);


		}
		System.out.println("Before Sort : "+resultarray);
		Collections.reverse(resultarray);
		System.out.println("After reverse : "+resultarray);

		return resultarray;
	}

	public ArrayList<String> getOpenDatesAfterSortSR() throws ParseException, InterruptedException{

		List <WebElement> Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='ServiceItem_SearchByCriteria']//a[contains(@aria-label,'Page')]"));
		int  pageCount = Pages.size();
		System.out.println("Number of pages :"+pageCount);
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();

		Pages.get(0).click();

		utils.clickAnelemnt(this.ArrowToSortOpenDtSR, "Search Inventory", "Open Date Sort arrow button");
		WebDriverWait wait1 = new WebDriverWait(Driver.getPgDriver(),20);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//th[@data-attribute-name='Open Date']//span[@class='pointerStyle DESC ']")));


		List <WebElement> OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Open Date']//span"));
		for(int j=0;j<OpenDates.size();j++)
		{
			OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Open Date']//span"));
			resultarray.add(OpenDates.get(j).getText());

		}
		for (int i=1;i<pageCount;i++)
		{
			Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='ServiceItem_SearchByCriteria']//a[contains(@aria-label,'Page')]"));
			Pages.get(i).click();

			OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Open Date']//span"));
			for(int j=0;j<OpenDates.size();j++)
			{

				OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Open Date']//span"));

				resultarray.add(OpenDates.get(j).getText());

			}
			System.out.println(resultarray);


		}
		System.out.println("After Sort: "+resultarray);


		return resultarray;
	}

	public boolean sortbyDateInq() throws ParseException, InterruptedException {

		ArrayList<String> ExpectedOpenDate = this.getOpenDatesBeforeSortInq();
		ArrayList<String> OpenDateAfterSort = this.getOpenDatesAfterSortInq();

		for(int i =0;i<ExpectedOpenDate.size();i++){
			for(int j =0;j<OpenDateAfterSort.size();j++){

				if(ExpectedOpenDate.get(i).equals(OpenDateAfterSort.get(j))){
					return true;

				}
				else
					return false;

			}
		}
		return true;

	}

	public ArrayList<String> getOpenDatesBeforeSortInq() throws ParseException, InterruptedException{


		ArrayList<String> resultarray = new ArrayList<String>();


		List <WebElement> OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@headers='a2']//span"));
		for(int j=0;j<OpenDates.size();j++)
		{
			//	OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@headers='a2']//span"));
			resultarray.add(OpenDates.get(j).getText());

		}	
		System.out.println("Before Sort : "+resultarray);
		Collections.reverse(resultarray);
		System.out.println("After reverse : "+resultarray);

		return resultarray;
	}

	public ArrayList<String> getOpenDatesAfterSortInq() throws ParseException, InterruptedException{

		ArrayList<String> resultarray = new ArrayList<String>();


		utils.clickAnelemnt(this.ArrowToSortOpenedDtInq1, "Search Inventory", "Open Date Sort arrow button");

		//	utils.clickAnelemnt(this.ArrowToSortOpenedDtInq2, "Search Inventory", "Open Date Sort arrow button");


		List <WebElement> OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@headers='a2']//span"));
		for(int j=0;j<OpenDates.size();j++)
		{
			OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@headers='a2']//span"));
			resultarray.add(OpenDates.get(j).getText());

		}
		System.out.println("After Sort: "+resultarray);


		return resultarray;
	}


	public boolean sortbyStatusInq() throws ParseException, InterruptedException {

		ArrayList<String> ExpectedStatus = this.getStatusBeforeSortInq();
		ArrayList<String> StatusAfterSort = this.getStatusAfterSortInq();

		for(int i =0;i<ExpectedStatus.size();i++){
			for(int j =0;j<StatusAfterSort.size();j++){

				if(ExpectedStatus.get(i).equals(StatusAfterSort.get(j))){
					return true;

				}
				else
					return false;

			}
		}
		return true;

	}

	public ArrayList<String> getStatusBeforeSortInq() throws ParseException, InterruptedException{


		ArrayList<String> resultarray = new ArrayList<String>();

		utils.clickAnelemnt(this.ToSortStatusInq, "Search Inventory", "Status heading click");
		this.waitforpageload();

		List<WebElement> Status =Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));
		for(int j=0;j<Status.size();j++)
		{
			//	OpenDates = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@headers='a2']//span"));
			resultarray.add(Status.get(j).getText());

		}	
		System.out.println("Before Sort : "+resultarray);
		Collections.reverse(resultarray);
		System.out.println("After reverse : "+resultarray);

		return resultarray;
	}

	public ArrayList<String> getStatusAfterSortInq() throws ParseException, InterruptedException{

		ArrayList<String> resultarray = new ArrayList<String>();

		utils.clickAnelemnt(this.ToSortStatusInq, "Search Inventory", "Status heading click");

		//	utils.clickAnelemnt(this.ArrowToSortOpenedDtInq2, "Search Inventory", "Open Date Sort arrow button");


		List<WebElement> Status =Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));
		for(int j=0;j<Status.size();j++)
		{
			Status =Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.InquiryNumber .OpenDate .Status .InquiryName .CustomerName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));
			resultarray.add(Status.get(j).getText());

		}	
		System.out.println("After Sort: "+resultarray);


		return resultarray;
	}

	public boolean sortbyStatusSR() throws ParseException, InterruptedException {

		ArrayList<String> BeforesortStatus=new ArrayList<String>();

		ArrayList<String> AfterSortstatus=new ArrayList<String>();
		boolean returnvar=false;
		utils.clickAnelemnt(this.ToSortStatusSR, "Search Inventory", "Status sort arrow button");
		utils.waitforpageload();
		for(WebElement iter:tblcolumnstatus)
			BeforesortStatus.add(iter.getText());

		//System.out.println("Before Sort: " +BeforesortStatus);
		utils.clickAnelemnt(this.ToSortStatusSR, "Search Inventory", "Status sort arrow button");
		utils.waitforpageload();
		WebDriverWait wait= new WebDriverWait(Driver.pgDriver, 10);
		boolean isNextDisplayed = this.labelNext.isDisplayed();
		while(isNextDisplayed)
		{try {
			utils.waitforpageload();
			utils.clickAnelemnt(this.labelNext,"Searchinventory","Next");
			try{
				wait.until(ExpectedConditions.visibilityOf(labelNext));
				isNextDisplayed=true;
			}catch(TimeoutException e){
				isNextDisplayed=false;
			}


		} catch (StaleElementReferenceException e) {
			utils.waitforpageload();
			continue;

		}
		}

		for(WebElement iter:tblcolumnstatus)
			AfterSortstatus.add(iter.getText());
		System.out.println("After Sort: " +AfterSortstatus);
		Collections.reverse(AfterSortstatus);
		System.out.println("After Sort After reverse:" +AfterSortstatus);
		for(int i=0;i<AfterSortstatus.size();i++)
			returnvar=AfterSortstatus.get(i).equals(BeforesortStatus.get(i));							

		if(returnvar)
			blogger.loginfo("status were sorted properly");

		else
			err.logerrormessage("status were not sorted properly");

		return returnvar;


	}

	public ArrayList<String> getStatusBeforeSortSR() throws ParseException, InterruptedException{

		List <WebElement> Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='ServiceItem_SearchByCriteria']//a[contains(@aria-label,'Page')]"));
		int  pageCount = Pages.size();
		System.out.println("Number of pages :"+pageCount);
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();
		//utils.clickAnelemnt(this.ToSortStatusSR, "Search Inventory", "Status SR click");
		for (int i=0;i<pageCount;i++)
		{
			Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='ServiceItem_SearchByCriteria']//a[contains(@aria-label,'Page')]"));
			Pages.get(i).click();

			List <WebElement> Status = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));
			for(int j=0;j<Status.size();j++)
			{
				Status = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));
				resultarray.add(Status.get(j).getText());

			}
			System.out.println(resultarray);


		}
		System.out.println("Before Sort : "+resultarray);
		Collections.reverse(resultarray);
		System.out.println("After reverse : "+resultarray);

		return resultarray;
	}

	public ArrayList<String> getStatusAfterSortSR() throws ParseException, InterruptedException{

		List <WebElement> Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='ServiceItem_SearchByCriteria']//a[contains(@aria-label,'Page')]"));
		int  pageCount = Pages.size();
		System.out.println("Number of pages :"+pageCount);
		int iterator =0;
		ArrayList<String> resultarray = new ArrayList<String>();

		Pages.get(0).click();

		utils.clickAnelemnt(this.ToSortStatusSR, "Search Inventory", "Status Sort SR");
		this.waitforpageload();

		List <WebElement> Status = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));
		for(int j=0;j<Status.size();j++)
		{
			Status = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));
			resultarray.add(Status.get(j).getText());

		}
		for (int i=1;i<pageCount;i++)
		{
			Pages = Driver.pgDriver.findElements(By.xpath("//div[@rdname='ServiceItem_SearchByCriteria']//a[contains(@aria-label,'Page')]"));
			Pages.get(i).click();

			Status = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));
			for(int j=0;j<Status.size();j++)
			{

				Status = Driver.pgDriver.findElements(By.xpath("//div[@id='PEGA_GRID_CONTENT' and @columnlist='.pyID .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//td[@data-attribute-name='Status']//span"));

				resultarray.add(Status.get(j).getText());

			}
			System.out.println(resultarray);


		}
		System.out.println("After Sort: "+resultarray);


		return resultarray;
	}



	//Sprint 3.3

	@FindBy(xpath="//span[contains(text(),'Access to Inquiry')]")
	WebElement labelAccessMsg;

	@FindBy(xpath="//table[@pl_prop='pgRepPgSubSectionSearchByCriteriaBBBBBB.pxResults']")
	WebElement tblInteractionList;

	public boolean verifyIfAccessRestrictionErrorMessageIsDisplayed()
	{
		try
		{
			utils.waitforpageload();
			labelAccessMsg.isDisplayed();
			blogger.loginfo("Access Message is displayed");
			System.out.println("Access Message is displayed");
			return true;

		}catch(Exception e)
		{
			blogger.loginfo("Access Message is not displayed");
			System.out.println("Access Message is not displayed");
			return false;
		}
	}

	public boolean validateAccessRestrictionMessage()
	{
		String actualText = "Access to Inquiry Tracking is restricted. Only Authorized users can view this information";
		String expectedText = labelAccessMsg.getText();
		if(actualText.equalsIgnoreCase(expectedText))
		{
			blogger.loginfo("Access Message is validated and it is as expected");
			System.out.println("Access Message is validated and it is as expected");
			return true;
		}else
		{
			blogger.loginfo("Access Message is validated and it is not as expected");
			System.out.println("Access Message is validated and it is not as expected");
			return false;
		}
	}

	public boolean validateIfTheInteractionIsMasked(String[] tablevalues)
	{
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblInteractionList, tablevalues);
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
			err.logcustomerrorwithmessage("SearchInventory", "validateIfTheInteractionIsMasked", "Error in validating Interaction table");
			return false;
		}
	}

	@FindBy(xpath="//div[@id='PEGA_GRID_CONTENT' and @columnlist=' .pyLabel .pyStatusWork .InteractionCount .pxUrgencyWork .pxCreateDateTime .ContactName  ']//table[@class='gridTable ']//a[@data-test-id='20160210145727026023512']")
	List<WebElement> SRIDLink;

	@FindBy(xpath="//a[text()='Close Window']")
	WebElement CloseWindowInPopup;

	public boolean clickSRIDAndValidate() throws InterruptedException {
		boolean flag = false;
		if(utils.clickAnelemnt(SRIDLink.get(1), "SearchInventory", "SRIDLink")) {
			Thread.sleep(1000);
			String parentWindowHandler = Driver.pgDriver.getWindowHandle();
			String subWindowHandler = null;
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("Number"+handles.size());
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
				subWindowHandler = iterator.next();
			}
			Driver.pgDriver.switchTo().window(subWindowHandler);
			String title = Driver.pgDriver.getTitle();
			System.out.println("Title: "+title);
			System.out.println("subWindowHandler"+subWindowHandler);
			action.moveToElement(CloseWindowInPopup);
			flag = utils.clickAnelemnt(CloseWindowInPopup, "SearchInventory", "CloseWindowInPopup");
			Driver.pgDriver.switchTo().window(parentWindowHandler);
		}
		return flag;
	}
	public boolean clickFirstSRIDInTable() throws InterruptedException {
		
	return	utils.clickAnelemnt(SRIDLink.get(1), "SearchInventory", "SRIDLink");
	}
	
	@FindBy(xpath="//table[@pl_prop='pgRepPgSubSectionSearchByCriteriaBBBBBBB.pxResults']//a[@data-test-id='20160210145727026023512']")
	List<WebElement> interactionID;
	
	public boolean clickFirstInteractionIDInTable() throws InterruptedException {
		
		return	utils.clickAnelemnt(interactionID.get(1), "SearchInventory", "interactionID");
		}
}
