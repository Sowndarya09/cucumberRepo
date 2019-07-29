package automationLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.chrono.IsoEra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

/**
 * Page class for Manage Billing navigated from Member Composite page 
 * @author AF02876
 *
 */
public class ManageBilling extends Driver {

	DataSet ds=new DataSet();
	BaseLogger blogger=new BaseLogger();
	Actions action = new Actions(Driver.pgDriver);
	/**
	 * Methods in the Program df
	 */

	ErrorLogger err= new ErrorLogger();
	public WebElement getsHeaderManageBilling() {
		return sHeaderManageBilling;
	}

	public WebElement getIframeelement() {
		return Iframeelement;
	}

	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}

	public WebElement getLnkOtherCancelThisWork() {
		return lnkOtherCancelThisWork;
	}

	public WebElement getBtnImgTool() {
		return btnImgTool;
	}

	public WebElement getLnkToolViewHistory() {
		return lnkToolViewHistory;
	}

	public WebElement getLnkToolConfigurationTools() {
		return lnkToolConfigurationTools;
	}

	public WebElement getBtnHelp() {
		return btnHelp;
	}

	public WebElement getLnkHeaderBillingSummary() {
		return lnkHeaderBillingSummary;
	}

	public WebElement getLnkHeaderHistory() {
		return lnkHeaderHistory;
	}

	public WebElement getLnkWebInsureExchangeManager() {
		return lnkWebInsureExchangeManager;
	}

	public WebElement getHeaderAutomaticWithdrawal() {
		return headerAutomaticWithdrawal;
	}

	public WebElement getLnkOnDemand() {
		return lnkOnDemand;
	}

	public WebElement getLnkTranscentra() {
		return lnkTranscentra;
	}

	public WebElement getSelectHCID() {
		return selectHCID;
	}

	public WebElement getSelectCoverageType() {
		return selectCoverageType;
	}

	public WebElement getBtnRetrieveTransactions() {
		return btnRetrieveTransactions;
	}

	public WebElement getBtnRetrieveBillsLetters() {
		return btnRetrieveBillsLetters;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getTableBillingSummaryBillID() {
		return tableBillingSummaryBillID;
	}

	public WebElement getTableBillingSummaryBillMisc() {
		return tableBillingSummaryBillMisc;
	}

	public WebElement getTableBillingUmmaryAutomaticWithdrawal() {
		return tableBillingSummaryAutomaticWithdrawal;
	}

	public WebElement getlnkHeaderSummaryBillDetails() {
		return lnkHeaderSummaryBillDetails;
	}


	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderManageBilling;

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 * @throws IOException 
	 */
	public ManageBilling() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;

	@FindBy(id="CancellationReason")
	WebElement drpdwnCancellationreason;

	@FindBy (xpath="//img[contains(@src,'tool_icon_')]")	
	private WebElement btnImgTool;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()=' Help']")	
	private WebElement btnHelp;

	@FindBy (xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'BillingHistory')]")	
	private WebElement tableBillingHistoryWeb;

	@FindBy(xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'TransactionHistoryList')][contains(@grid_ref_page,'pxResults(1)')]")
	private WebElement tableBillingHistoryTransactionTable1;

	@FindBy(xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'TransactionHistoryList')][contains(@grid_ref_page,'pxResults(2)')]")
	private WebElement tableBillingHistoryTransactionTable2;

	@FindBy(xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'TransactionHistoryList')][contains(@grid_ref_page,'pxResults(3)')]")
	private WebElement tableBillingHistoryTransactionTable3;

	@FindBy(xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'TransactionHistoryList')][contains(@grid_ref_page,'pxResults(3)')]")
	private WebElement tableBillingHistoryTransactionTable4;

	@FindBy(xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'TransactionHistoryList')][contains(@grid_ref_page,'pxResults(4)')]")
	private WebElement tableBillingHistoryTransactionTable5;

	@FindBy(xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'TransactionHistoryList')][contains(@grid_ref_page,'pxResults(5)')]")
	private WebElement tableBillingHistoryTransactionTable6;

	@FindBy(xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'TransactionHistoryList')][contains(@grid_ref_page,'pxResults(6)')]")
	private WebElement tableBillingHistoryTransactionTable7;

	@FindBy(xpath="//table[contains(@class,'gridTable')][contains(@pl_prop,'TransactionHistoryList')][contains(@grid_ref_page,'pxResults(7)')]")
	private WebElement tableBillingHistoryTransactionTable8;

	@FindBy(id="SelectCoverageType")
	WebElement dropdownMangeBillingCoverageType;

	@FindBy (xpath="//*[@class='textIn'][text()='Billing Summary']")	
	private WebElement lnkHeaderBillingSummary;
	@FindBy (xpath="//*[@class='textIn'][text()='History']")	
	private WebElement lnkHeaderHistory;

	@FindBy(linkText="WebInsure Exchange Manager (WEM)")
	private WebElement lnkWebInsureExchangeManager;

	@FindBy (xpath="//*[@class='textIn'][contains(text(),'Summary Bill Details')]")	
	private WebElement lnkHeaderSummaryBillDetails;

	@FindBy(xpath="	//*[@class='header-element header-title'][text()='Automatic Withdrawal']")
	private WebElement headerAutomaticWithdrawal;

	@FindBy(linkText="OnDemand")
	private WebElement lnkOnDemand;

	@FindBy(linkText="Transcentra")
	private WebElement lnkTranscentra;

	@FindBy(name="$PBillingSummaryDetails$pSelectHCID")
	private WebElement selectHCID;

	@FindBy(name="$PBillingSummaryDetails$pSelectCoverageType")
	private WebElement selectCoverageType;

	@FindBy(xpath="//div[text()='Retrieve Transactions']")
	private WebElement btnRetrieveTransactions;

	@FindBy(xpath="//button[contains(@name,'BillSummaryHistory')]//div[text()='Retrieve History']")
	private WebElement btnRetrieveHistory;

	@FindBy(xpath="//*[text()='Retrieve Bills and Letters']")
	private WebElement btnRetrieveBillsLetters;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="//*[contains(@data-node-id,'BillingSummary1')]")
	private WebElement tableBillingSummaryBillID; 

	@FindBy(xpath="//*[contains(@data-node-id,'BillingSummary3')]")
	private WebElement tableBillingSummaryBillMisc; 

	@FindBy(xpath="//*[text()='Automatic Withdrawal']")
	private WebElement linkAutomaticWithdrawal;

	@FindBy(xpath="//label[@data-test-id='201510050925510413119654']")
	private WebElement lblautomaticWithdrawlsectionAccount;


	@FindBy(xpath="//*[contains(@data-node-id,'BillingSummaryAutomaticWithdrawal')]")
	private WebElement tableBillingSummaryAutomaticWithdrawal; 

	@FindBy(id="SelectHCID")
	private WebElement drpdwnBillingSummarySelectHCID;

	@FindBy(id="SelectCoverageType")
	private WebElement drpdwnBillingSummaryCoverageType;

	@FindBy(id="BillingSummaryReview")
	WebElement chkbxManageBillingInformation;


	@FindBy(xpath="//div[@node_name='TransactionsHistoryWrapper']/parent::div//table[@id='gridLayoutTable']//table[contains(@class,gridTable)]")
	WebElement tableBillingSummaryTransactionHistory;

	@FindBy(xpath="//div[@node_name='BillsAndLetters']/parent::div//table[@id='gridLayoutTable']")
	WebElement tableBillingSummaryBillsandLetters;

	@FindBy(id="TransactionHistoryReview")
	WebElement chkbxManageBillingTransactionHistoryReview;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'PaymentAmount')]/following-sibling::div")
	WebElement labelBillingTHPaymentAmount;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'PaymentStatus')]/following-sibling::div")
	WebElement labelBillingTHPaymentStatus;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'PaymentID')]/following-sibling::div")
	WebElement labelBillingTHPaymentID;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'MethodOfPayment')]/following-sibling::div")
	WebElement labelBillingTHPaymentMethod;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'SourceOfPayment')]/following-sibling::div")
	WebElement labelBillingTHPaymentSource;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'LineOfBusiness')]/following-sibling::div")
	WebElement labelBillingTHLOB;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'ReceivedDate')]/following-sibling::div")
	WebElement labelBillingTHReceivedDate;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'ProcessedDate')]/following-sibling::div")
	WebElement labelBillingTHProcessesDate;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'CheckNumber')]/following-sibling::div")
	WebElement labelBillingTHCheckNumber;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'ConfirmationNumber')]/following-sibling::div")
	WebElement labelBillingTHConfNumber;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'AdjustmentTypeCategory')]/following-sibling::div/span")
	WebElement labelBillingTHAdjustmenttype;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'AdjustmentAmount')]/following-sibling::div/span")
	WebElement labelBillingTHAdjustmentAmount;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'AdjustmentProcessedDate')]/following-sibling::div/span")
	WebElement labelBillingTHAdjustmentProcessedDate;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'AdjustmentDescription')]/following-sibling::div/span")
	WebElement labelBillingTHAdjustmentDescription;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'FromPolicy')]/following-sibling::div/span")
	WebElement labelBillingTHAdjustmentFromPolicy;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'ToPolicy')]/following-sibling::div/span")
	WebElement labelBillingTHAdjustmentToPolicy;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'FromGroup')]/following-sibling::div/span")
	WebElement labelBillingTHAdjustmentFromGroup;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'ToGroup')]/following-sibling::div/span")
	WebElement labelBillingTHAdjustmentToGroup;

	@FindBy(id="BillsandLettersReview")
	WebElement chkbxManageBillingBillsandlettersReview;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'Charges')]/following-sibling::div")
	WebElement labelBillingSummaryBPCharges;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'CurrentDueDate')]/following-sibling::div")
	WebElement labelBillingSummaryBPDueDate;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'BalanceForward')]/following-sibling::div")
	WebElement labelBillingSummaryBPBalanceForward;


	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'Subsidy')]/following-sibling::div")
	WebElement labelBillingSummaryBPSubsidy;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'AmountDue')]/following-sibling::div")
	WebElement labelBillingSummaryBPDueAmount;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'PayFromTo')]/following-sibling::div")
	WebElement labelBillingSummaryBPPayFromTo;

	@FindBy(xpath="//tr[@expanded='true']//label[contains(@for,'BillDate')]/following-sibling::div")
	WebElement labelBillingSummaryBPBillDate;

	@FindBy(xpath="//img[contains(@alt,'Loading..')]")
	WebElement LoadingIcon;

	public boolean checkforpageload()
	{
		int count=0;
		try
		{
			if(this.LoadingIcon.isDisplayed())
			{
				count++;
				wait=new WebDriverWait(Driver.pgDriver,20);
				wait.until(ExpectedConditions.visibilityOf(this.tableBillingSummaryBillID));

				return true;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			if(count>0)
			{
				System.out.println("Applcation took a long time to load");
				return false;
			}
			else
				return true;
		}

	}

	public String removeCommas(ArrayList<String> Billvalue,int indexval)
	{
		String amountwithoutcommas;
		if(Billvalue.get(indexval).contains(","))
			amountwithoutcommas=Billvalue.get(indexval).replace(",","");
		else
			amountwithoutcommas=Billvalue.get(indexval);
		return amountwithoutcommas;
	}

	public String removeCommas(String textwithcomma)
	{
		String amountwithoutcomma;
		if(textwithcomma.contains(","))
			amountwithoutcomma=textwithcomma.replace(",","");
		else
			amountwithoutcomma=textwithcomma;
		return amountwithoutcomma;
	}

	public boolean validateBillingInfoSection1(String[] BillingInfo) throws IOException
	{
		utils.waitforpageload();
		if(!utils.isServiceDown()){
			ArrayList<String> checkbox= new ArrayList<String>();
			ArrayList<String> BillItem= new ArrayList<String>();
			ArrayList<String> Billvalue= new ArrayList<String>();
			BillItem=utils.getColumnsBasedonIndex(this.tableBillingSummaryBillID,1);
			Billvalue=utils.getColumnsBasedonIndex(this.tableBillingSummaryBillID,3);

			boolean returnvar =true;
			int indexval;
			String amountwithoutcommas;
			for(String iterator : BillingInfo)
			{
				String keyvaluepair = iterator;
				if(!returnvar)
				{
					err.logcommonMethodError("Manage Billing", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(key.toLowerCase().contains("summary bill id"))
				{				 
					indexval=BillItem.indexOf("Summary Bill ID");
					//System.out.println(indexval);
					System.out.println(Billvalue.get(indexval));
					System.out.println(value);
					returnvar=utils.isvalueMatch_contain(Billvalue.get(indexval),value);
					continue;
				}
				else if(key.toLowerCase().contains("member is enrolled in summary bill")){
					indexval=BillItem.indexOf("Member is enrolled in summary bill");
					returnvar=utils.isvalueMatch_contain(Billvalue.get(indexval),value);
					continue;
				}
				else if(key.toLowerCase().contains("due date")){
					indexval=BillItem.indexOf("Current Due Date");	
					System.out.println(Billvalue.get(indexval));
					System.out.println(value);
					returnvar=utils.isvalueMatch_contain(Billvalue.get(indexval),value);
					continue;
				}
				else if(key.toLowerCase().contains("premium")){
					indexval=BillItem.indexOf("Premium");
					amountwithoutcommas=removeCommas(Billvalue,indexval);	
					System.out.println(amountwithoutcommas);
					System.out.println(value);
					returnvar=utils.isvalueMatch_contain(amountwithoutcommas,value);
					continue;
				}
				else if(key.toLowerCase().contains("fees")){
					indexval=BillItem.indexOf("Fees");				
					amountwithoutcommas=removeCommas(Billvalue,indexval);	
					System.out.println(amountwithoutcommas);
					System.out.println(value);
					returnvar=utils.isvalueMatch_contain(amountwithoutcommas,value);				
					continue;
				}
				else if(key.toLowerCase().contains("charges")){
					indexval=BillItem.indexOf("Charges");
					amountwithoutcommas=removeCommas(Billvalue,indexval);				
					returnvar=utils.isvalueMatch_contain(amountwithoutcommas,value);				
					continue;
				}
				else if(key.toLowerCase().contains("subsidy")){
					indexval=BillItem.indexOf("Subsidy");
					amountwithoutcommas=removeCommas(Billvalue,indexval);
					returnvar=utils.isvalueMatch_contain(amountwithoutcommas,value);				
					continue;
				}
				else if(key.toLowerCase().contains("balance forward")){
					indexval=BillItem.indexOf("Balance Forward");
					amountwithoutcommas=removeCommas(Billvalue,indexval);
					returnvar=utils.isvalueMatch_contain(amountwithoutcommas,value);				
					continue;
				}
				else if(key.toLowerCase().contains("statement amount")){
					indexval=BillItem.indexOf("Statement Amount");
					amountwithoutcommas=removeCommas(Billvalue,indexval);
					returnvar=utils.isvalueMatch_contain(amountwithoutcommas,value);

					continue;
				}
				else if(key.toLowerCase().contains("applied payment")){
					indexval=BillItem.indexOf("Applied Payments");
					amountwithoutcommas=removeCommas(Billvalue,indexval);
					returnvar=utils.isvalueMatch_contain(amountwithoutcommas,value);				
					continue;
				}
				else if(key.toLowerCase().contains("amount due")){
					indexval=BillItem.indexOf("Amount Due");
					amountwithoutcommas=removeCommas(Billvalue,indexval);
					returnvar=utils.isvalueMatch_contain(amountwithoutcommas,value);				
					continue;
				}


				err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}	
			if(returnvar)
			{
				System.out.println("BillingInfo checked Successfully");

				utils.clickAnelemnt(this.chkbxManageBillingInformation, "Manage Billing ", " Billing Info Check box ");
				return true;	
			}
			else
			{
				int tot_i=BillingInfo.length;
				err.logcommonMethodError("Member Composite", "the value "+BillingInfo[tot_i-1].toString()+" doesnt match with the one in application");
				return false;
			}
		}
		return false;

	}


	public boolean validateBillingInfoSection2(String[] BillingInfo)
	{

		ArrayList<String> BillItem= new ArrayList<String>();
		ArrayList<String> Billvalue= new ArrayList<String>();
		utils.waitforpageload();	
		BillItem=utils.getColumnsBasedonIndex(this.tableBillingSummaryBillMisc,1);
		Billvalue=utils.getColumnsBasedonIndex(this.tableBillingSummaryBillMisc,2);;

		if(!utils.isServiceDown())
		{
			boolean returnvar =true;
			int indexval;
			String amountwithoutcommas;
			for(String iterator : BillingInfo)
			{
				String keyvaluepair = iterator;
				if(!returnvar)
				{
					err.logcommonMethodError("Manage Billing", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(key.toLowerCase().contains("billing status"))
				{
					if(BillItem.get(1).toLowerCase().contains(value));
					{
						returnvar= true;
						continue;
					}
				}
				else if(key.toLowerCase().contains("bill date")){
					indexval=BillItem.indexOf("Bill Date");
					if(Billvalue.get(indexval).contains(value))
					{
						returnvar=true;

						continue;}
				}
				else if(key.toLowerCase().contains("pay from")){
					indexval=BillItem.indexOf("Pay From - To");

					System.out.println(Billvalue.get(indexval));
					if(Billvalue.get(indexval).contains(value))
					{
						returnvar=true;

						continue;}
				}

				else if(key.toLowerCase().contains("paid to date"))
				{
					indexval=BillItem.indexOf("Paid To Date");

					if(Billvalue.get(indexval).contains(value))
					{
						returnvar=true;

						continue;}
				}
				else if(key.toLowerCase().contains("unapplied payments")){
					indexval=BillItem.indexOf("Unapplied Payments");
					returnvar=utils.isvalueMatch_contain(Billvalue.get(indexval).toLowerCase(),value);					
					continue;
				}
				else if(key.toLowerCase().contains("last payment")){
					indexval=BillItem.indexOf("Amount of Last Payment");
					amountwithoutcommas=removeCommas(Billvalue,indexval);

					if(amountwithoutcommas.toLowerCase().contains(value))
					{
						returnvar=true;

						continue;}
				}
				else if(key.toLowerCase().contains("bill frequency")){
					indexval=BillItem.indexOf("Bill Frequency");
					amountwithoutcommas=removeCommas(Billvalue,indexval);

					if(amountwithoutcommas.toLowerCase().contains(value))
					{
						returnvar=true;

						continue;}
				}
				else if(key.toLowerCase().contains("applied days")){
					indexval=BillItem.indexOf("Applied Days");

					amountwithoutcommas=removeCommas(Billvalue,indexval);
					if(amountwithoutcommas.toLowerCase().contains(value))
					{
						returnvar=true;

						continue;}
				}
				else if(key.toLowerCase().contains("applied months")){
					indexval=BillItem.indexOf("Applied Months");
					amountwithoutcommas=removeCommas(Billvalue,indexval);
					if(amountwithoutcommas.toLowerCase().contains(value))
					{
						returnvar=true;

						continue;}
				}
				else if(key.toLowerCase().contains("grace months")){
					indexval=BillItem.indexOf("Grace Months");
					amountwithoutcommas=removeCommas(Billvalue,indexval);
					if(amountwithoutcommas.toLowerCase().contains(value))
					{
						returnvar=true;

						continue;}
				}


				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}	
			if(returnvar)
			{
				System.out.println("BillingInfosection2 checked Successfully");
				return true;	
			}
			else
			{
				int tot_i=BillingInfo.length;
				err.logcommonMethodError("Member Composite", "the value "+BillingInfo[tot_i-1].toString()+" doesnt match with the one in application");
				return false;
			}	
		}
		else 
			return false;

	}


	public boolean selectcheckboxTransactionHistory() throws IOException
	{
		utils.waitforpageload();
		if(!utils.isServiceDown())
			if(utils.clickAnelemnt(this.chkbxManageBillingTransactionHistoryReview, "Manage Billing", "Transaction History checkbox"))
			{
				ds.DataStore("TransactionHistory", "Transaction History discussed with contact");
				return true;
			}
			else
				return false;
		return false;
	}

	static ArrayList<String> BillsAndLettersValue;

	public boolean selectcheckboxBillsAndLetters() throws IOException
	{
		BillsAndLettersValue = new ArrayList<String>();
		utils.waitforpageload();
		if(!utils.isServiceDown()){
			if(utils.clickAnelemnt(this.chkbxManageBillingBillsandlettersReview, "Manage Billing", "Bills and Letters checkbox"))
			{
				BillsAndLettersValue.add("Bills and Letters discussed with contact");
				return true;
			}
		}
		return false;
	}

	public boolean selectcheckboxBillingInfo() throws IOException
	{
		utils.waitforpageload();
		if(!utils.isServiceDown())
			if(utils.clickAnelemnt(this.chkbxManageBillingInformation, "Manage Billing", "Billing Info checkbox"))
			{
				ds.DataStore("BillingInfo", "Billing Information discussed with contact");
				return true;
			}
		return false;
	}

	public boolean deselectcheckboxTransactionHistory() throws IOException
	{
		if(this.chkbxManageBillingTransactionHistoryReview.isSelected())
		{
			if(utils.clickAnelemnt(this.chkbxManageBillingTransactionHistoryReview, "Manage Billing", "Transaction History checkbox"))
			{
				ds.DataStore("DeselectTransactionHistory", "Transaction History discussed with contact unchecked");
				return true;
			}
			else
				return false;
		}
		else
		{
			System.out.println("Already deselected");
			return true;
		}
	}

	public boolean deselectcheckboxBillsAndLetters() throws IOException
	{
		if(this.chkbxManageBillingBillsandlettersReview.isSelected())
		{
			if(utils.clickAnelemnt(this.chkbxManageBillingBillsandlettersReview, "Manage Billing", "Bills and Letters checkbox"))
			{
				ds.DataStore("DeselectBillsandLetters", "Bills and Letters discussed with contact unchecked");
				return true;
			}
			else
				return false;
		}
		else
		{
			System.out.println("Already deselected");
			return true;
		}
	}

	public boolean deselectcheckboxBillingInfo() throws IOException
	{
		if(this.chkbxManageBillingInformation.isSelected())
		{
			if(utils.clickAnelemnt(this.chkbxManageBillingInformation, "Manage Billing", "Billing Info checkbox"))
			{
				ds.DataStore("DeselectBillingInfo", "Billing Information discussed with contact unchecked");
				return true;
			}
			else
				return false;
		}
		else
		{
			System.out.println("Already deselected");
			return true;
		}
	}


	public boolean validateAutomaticWithdrawalSection(String[] details)
	{
		ArrayList<String> BillItem= new ArrayList<String>();
		ArrayList<String> Billvalue= new ArrayList<String>();
		if(!utils.isServiceDown())
		{
			action.moveToElement(linkAutomaticWithdrawal);
			if(utils.clickAnelemnt(this.linkAutomaticWithdrawal, "Manage Billing", "Automatic WithDrwal")) {
				utils.waitforpageload();
				if (!utils.isProxyWebelement(lblautomaticWithdrawlsectionAccount))
				{
					BillItem=utils.getColumnsBasedonIndex(this.tableBillingSummaryAutomaticWithdrawal,0);
					Billvalue=utils.getColumnsBasedonIndex(this.tableBillingSummaryAutomaticWithdrawal,2);
					boolean returnvar =true;
					int indexval;
					String amountwithoutcommas;
					for(String iterator : details)
					{
						String keyvaluepair = iterator;
						if(!returnvar)
						{
							err.logcommonMethodError("Manage Billing", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
							return false;
						}
						String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
						String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
						System.out.println("key " + key + "value  " + value);
						if(key.toLowerCase().contains("account number"))
						{
							returnvar =utils.isvalueMatch_contain(BillItem.get(1), value);
							continue;
						}
						else if(key.toLowerCase().contains("token id")){
							indexval=BillItem.indexOf("Token ID");
							returnvar = utils.isvalueMatch_contain(Billvalue.get(indexval),value);
							continue;
						}
						else if(key.toLowerCase().contains("pull date")){
							indexval=BillItem.indexOf("Pull Date");
							System.out.println(Billvalue.get(indexval));
							if(Billvalue.get(indexval).contains(value))
							{
								returnvar=true;
								continue;}
						}

						else if(key.toLowerCase().contains("start date"))
						{
							indexval=BillItem.indexOf("Start Date");
							if(Billvalue.get(indexval).contains(value))
							{
								returnvar=true;
								continue;}
						}
						else if(key.toLowerCase().contains("end date")){
							indexval=BillItem.indexOf("End Date");
							if(Billvalue.get(indexval).toLowerCase().contains(value))
							{
								returnvar=true;
								continue;}
						}
						err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
						return false;
					}	
					if(returnvar)
					{
						System.out.println("AutomaticWithdrawalSection checked Successfully");
						return true;	
					}
					else
					{
						int tot_i=details.length;
						err.logcommonMethodError("Member Composite", "the value "+details[tot_i-1].toString()+" doesnt match with the one in application");
						return false;
					}	

				}
			}
		}
		return false;
	}

	public boolean setHCIDandCoverageType(String[] details)
	{
		if(utils.selectDropDownbyVisibleString(this.drpdwnBillingSummarySelectHCID, details[0], "Manage Billing", "HCID Drop Down box"))
		{
			if(utils.selectDropDownbyVisibleString(this.drpdwnBillingSummarySelectHCID, details[1], "Manage Billing", "Coverage Drop Down box"))
				return true;
		}
		return false;
	}

	@FindBy(xpath="//*[@data-test-id='2015100723244500663634']")
	List<WebElement> iconExpandButtonInHistroytable;

	@FindBy(xpath="//*[@data-test-id='201511051408330762186874']")
	List<WebElement> datecolumnInHistorytable;

	@FindBy(xpath="//*[@data-test-id='2015100723244500663634']")
	List<WebElement> iconExpandButtonInHistoryInnertable;

	@FindBy(xpath="//*[@data-test-id='20151004192312081340983']")
	List<WebElement> datecolumnInHistoryInnertable;

	public boolean validateTransactionHistorybasedonDate(String[] dateanddetails) throws InterruptedException
	{
		int indexval=0;
		int tempcount=0;
		utils.waitforpageload();
		if(!utils.isServiceDown())
		{

			if(utils.clickAnelemnt(this.btnRetrieveTransactions, "Manage billing ", " retrieve transaction button "))
			{

				String datevalue = dateanddetails[0].substring(dateanddetails[0].indexOf(":")+1);

				List<WebElement> expandbutton= new ArrayList<WebElement>();
				ArrayList<String> DateVal= new ArrayList<String>();
				utils.waitforpageload();
				expandbutton=this.iconExpandButtonInHistroytable;
				List<WebElement> dateColumn = new ArrayList<WebElement>();
				dateColumn=this.datecolumnInHistorytable;
				for(int i=0;i<dateColumn.size();i++)
				{ 
					System.out.println("Content text is : " + dateColumn.get(i).getText());

					if(dateColumn.get(i).getText().contains(datevalue))
					{  
						indexval++;
						utils.clickAnelemnt(expandbutton.get(i), "Manage Billing ", "Transaction History table ");
						indexval=i;
						tempcount++;

					}


				}
				if(indexval==0)
				{
					System.out.println("Data Value doesnt match");
					return false;
				}
				if(tempcount<0)
				{
					System.out.println("Table is empty");

					err.logError("Manage Billing ", "table is empty ");
					return false;
				}

				dateColumn=this.datecolumnInHistoryInnertable;
				expandbutton=this.iconExpandButtonInHistoryInnertable;
				datevalue=dateanddetails[1].substring(dateanddetails[0].indexOf(":")+1);
				for(int i=0;i<dateColumn.size();i++)
				{ 
					System.out.println("Content text is : " + dateColumn.get(i).getText());

					if(dateColumn.get(i).getText().contains(datevalue))
					{  
						indexval++;
						utils.clickAnelemnt(expandbutton.get(i), "Manage Billing ", "Transaction History table ");
						indexval=i;
						tempcount++;
					}
				}
				if(indexval==0)
				{
					System.out.println("Data Value doesnt match");
					return false;
				}
				if(tempcount<0)
				{
					System.out.println("Table is empty");

					err.logError("Manage Billing ", "table is empty ");
					return false;
				}				

				boolean returnvar=true;
				String keyvaluepair="";
				utils.waitforpageload();
				for(int i=1;i<dateanddetails.length;i++)
				{
				String amountwithoutcommas="";
				if(!returnvar)
				{
					err.logcommonMethodError("Manage Billing ", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				keyvaluepair = dateanddetails[i];

				if(keyvaluepair.contains("Date"))
				{
					continue;

				}
				String iterator =dateanddetails[i];
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				wait = new WebDriverWait(Driver.getPgDriver(),5);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@expanded='true']//label[contains(@for,'PaymentStatus')]/following-sibling::div")));

				if(key.toLowerCase().contains("status")){
					returnvar=utils.validateLabel(labelBillingTHPaymentStatus, value);
					continue;}
				else if(key.toLowerCase().contains("amount")){
					amountwithoutcommas=removeCommas(this.labelBillingTHPaymentAmount.getText());
					returnvar = amountwithoutcommas.toLowerCase().contains(value);
					continue;}

				else if(key.toLowerCase().contains("id")){
					returnvar=utils.validateLabel(this.labelBillingTHPaymentID, value);
					continue;
				}
				else if(key.toLowerCase().contains("method")){
					returnvar = utils.validateLabel(this.labelBillingTHPaymentMethod,value);
					continue;
				}
				else if(key.toLowerCase().contains("source")){
					returnvar = utils.validateLabel(this.labelBillingTHPaymentSource,value);
					continue;
				}

				else if(key.toLowerCase().contains("lob")){
					returnvar = utils.validateLabel(this.labelBillingTHLOB,value);
					continue;
				}
				else if(key.toLowerCase().contains("received")){
					returnvar = utils.validateLabel(this.labelBillingTHReceivedDate,value);
					continue;
				}
				else if(key.toLowerCase().contains("processed")){
					returnvar =utils.validateLabel(this.labelBillingTHProcessesDate,value);
					continue;
				}
				else if(key.toLowerCase().contains("number")){
					returnvar =utils.validateLabel(this.labelBillingTHCheckNumber,value);
					continue;
				}
				else if(key.toLowerCase().contains("groupnumber")){
					returnvar =utils.validateLabel(this.labelBillingTHConfNumber,value);
					continue;
				}
				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				}
				if(returnvar)
				{
					System.out.println("Subscriber info verified successfully");
					return true;	
				}
				else
				{
					int tot_i=dateanddetails.length;
					err.logcommonMethodError("Member Composite", "the value "+dateanddetails[tot_i-1].toString()+" doesnt match with the one in application");
					return false;
				}
			}	
			else
			{
				err.logError("Manage Billing ", " Retrieve transactions Button ");
			}
			return false;
		}
		else 
			return false;
	}

	public boolean validateTransactionbasedonDate(String[] dateanddetails) throws InterruptedException
	{
		int indexval=0;
		int tempcount=0;
		utils.waitforpageload();
		if(!utils.isServiceDown())
		{

			if(utils.clickAnelemnt(this.btnRetrieveTransactions, "Manage billing ", " retrieve transaction button "))
			{

				String datevalue = dateanddetails[0].substring(dateanddetails[0].indexOf(":")+1);

				ArrayList<WebElement> expandbutton= new ArrayList<WebElement>();
				ArrayList<String> DateVal= new ArrayList<String>();
				utils.waitforpageload();
				expandbutton=utils.getcolumnWebelemntFromTable(this.tableBillingSummaryTransactionHistory,0,"img");

				ArrayList<String> dateColumn = new ArrayList<String>();
				dateColumn=utils.getcolumnStringFromTablefrRT(this.tableBillingSummaryTransactionHistory, "Date");
				for(int i=0;i<dateColumn.size();i++)
				{ 
					System.out.println("Content text is : " + dateColumn.get(i));

					if(dateColumn.get(i).contains(datevalue))
					{  
						indexval++;
						utils.clickAnelemnt(expandbutton.get(i), "Manage Billing ", "Transaction History table ");

						indexval=i;
						tempcount++;
					}
				}
				if(indexval==0)
				{
					System.out.println("Data Value doesnt match");
					return false;
				}
				if(tempcount<0)
				{
					System.out.println("Table is empty");

					err.logError("Manage Billing ", "table is empty ");
					return false;
				}

				boolean returnvar=true;
				String keyvaluepair="";
				for(String iterator : dateanddetails)
				{utils.waitforpageload();
				String amountwithoutcommas="";
				if(!returnvar)
				{
					err.logcommonMethodError("Manage Billing ", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;
				if(keyvaluepair.contains("Date"))
				{
					continue;

				}

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				wait = new WebDriverWait(Driver.getPgDriver(),5);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@expanded='true']//label[contains(@for,'PaymentStatus')]/following-sibling::div")));

				if(key.toLowerCase().contains("status")){
					returnvar=utils.validateLabel(labelBillingTHPaymentStatus, value);
					continue;}
				else if(key.toLowerCase().contains("amount")){
					amountwithoutcommas=removeCommas(this.labelBillingTHPaymentAmount.getText());
					returnvar = amountwithoutcommas.toLowerCase().contains(value);
					continue;}

				else if(key.toLowerCase().contains("id")){
					returnvar=utils.validateLabel(this.labelBillingTHPaymentID, value);
					continue;
				}
				else if(key.toLowerCase().contains("method")){
					returnvar = utils.validateLabel(this.labelBillingTHPaymentMethod,value);
					continue;
				}
				else if(key.toLowerCase().contains("source")){
					returnvar = utils.validateLabel(this.labelBillingTHPaymentSource,value);
					continue;
				}

				else if(key.toLowerCase().contains("lob")){
					returnvar = utils.validateLabel(this.labelBillingTHLOB,value);
					continue;
				}
				else if(key.toLowerCase().contains("received")){
					returnvar = utils.validateLabel(this.labelBillingTHReceivedDate,value);
					continue;
				}
				else if(key.toLowerCase().contains("processed")){
					returnvar =utils.validateLabel(this.labelBillingTHProcessesDate,value);
					continue;
				}
				else if(key.toLowerCase().contains("number")){
					returnvar =utils.validateLabel(this.labelBillingTHCheckNumber,value);
					continue;
				}
				else if(key.toLowerCase().contains("groupnumber")){
					returnvar =utils.validateLabel(this.labelBillingTHConfNumber,value);
					continue;
				}

				else 
					err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");

				}
				if(returnvar)
				{
					System.out.println("Subscriber info verified successfully");
					return true;	
				}
				else
				{
					int tot_i=dateanddetails.length;
					err.logcommonMethodError("Member Composite", "the value "+dateanddetails[tot_i-1].toString()+" doesnt match with the one in application");
					return false;
				}
			}	
			else
			{
				err.logError("Manage Billing ", " Retrieve transactions Button ");
			}
			return false;

		}
		else 
			return false;
	}

	public boolean validateBillsandLettersbasedonDate(String[] dateanddetails) throws InterruptedException
	{
		int indexval=0;
		int tempcount=0;
		utils.waitforpageload();
		if(!utils.isServiceDown())
		{
			if(utils.clickAnelemnt(this.btnRetrieveBillsLetters, "Manage billing ", " retrieve transaction button "))
			{
				utils.waitforpageload();
				String datevalue = dateanddetails[0].substring(dateanddetails[0].indexOf(":")+1);

				ArrayList<WebElement> expandbutton= new ArrayList<WebElement>();
				ArrayList<String> DateVal= new ArrayList<String>();
				expandbutton=utils.getcolumnWebelemntFromTable(this.tableBillingSummaryBillsandLetters,0,"img");

				ArrayList<String> dateColumn = new ArrayList<String>();
				dateColumn=utils.getcolumnStringFromTablefrRT(this.tableBillingSummaryBillsandLetters, "Generated Date");
				for(int i=0;i<dateColumn.size();i++)
				{ 
					System.out.println("Content text is : " + dateColumn.get(i));

					if(dateColumn.get(i).contains(datevalue))
					{  
						indexval++;
						utils.clickAnelemnt(expandbutton.get(i), "Manage Billing ", "Transaction History table ");
						indexval=i;
						tempcount++;

					}
				}

				if(indexval==0)
				{
					System.out.println("Data Value doesnt match");
					return false;
				}
				if(tempcount<0)
				{
					System.out.println("Table is empty");

					err.logError("Manage Billing ", "table is empty ");
				}

				boolean returnvar=true;
				String keyvaluepair="";
				for(String iterator : dateanddetails)
				{
					String amountwithoutcommas="";
					if(!returnvar)
					{
						err.logcommonMethodError("Manage Billing ", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
						return false;

					}
					keyvaluepair = iterator;
					if(keyvaluepair.contains("Date"))
					{
						continue;

					}
					String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
					String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
					System.out.println("key " + key + "value  " + value);

					wait = new WebDriverWait(Driver.getPgDriver(),5);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@expanded='true']//label[contains(@for,'Charges')]/following-sibling::div")));

					if(key.toLowerCase().contains("charges")){
						amountwithoutcommas=removeCommas(this.labelBillingSummaryBPCharges.getText()).toLowerCase();

						returnvar = amountwithoutcommas.contains(value);
						continue;}
					else if(key.toLowerCase().contains("due date")){
						amountwithoutcommas=removeCommas(this.labelBillingSummaryBPDueDate.getText());
						returnvar = amountwithoutcommas.toLowerCase().contains(value);
						continue;}

					else if(key.toLowerCase().contains("balance forward")){
						returnvar = this.labelBillingSummaryBPBalanceForward.getText().toLowerCase().contains(value);
						continue;
					}
					else if(key.toLowerCase().contains("subsidy")){
						amountwithoutcommas=removeCommas(this.labelBillingSummaryBPSubsidy.getText()).toLowerCase();
						returnvar = amountwithoutcommas.contains(value);
						continue;
					}
					else if(key.toLowerCase().contains("amount due")){
						returnvar = this.labelBillingSummaryBPDueAmount.getText().toLowerCase().contains(value);
						continue;
					}

					else if(key.toLowerCase().contains("pay from")){
						returnvar = this.labelBillingSummaryBPPayFromTo.getText().toLowerCase().contains(value);
						continue;
					}
					else if(key.toLowerCase().contains("bill date")){
						returnvar = this.labelBillingSummaryBPBillDate.getText().toLowerCase().contains(value);
						continue;
					}
					else 
						err.logcommonMethodError("Member Composite", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				}
				if(returnvar)
				{
					System.out.println("Subscriber info verified successfully");
					return true;	
				}
				else
				{
					int tot_i=dateanddetails.length;
					err.logcommonMethodError("Member Composite", "the value "+dateanddetails[tot_i-1].toString()+" doesnt match with the one in application");
					return false;
				}
			}	
			else
			{
				err.logError("Manage Billing ", " Retrieve transactions Button ");
			}
			return false;
		}
		else 
			return false;
	}

	public boolean selectCoverageType(String[] coverage)
	{
		return (utils.selectDropDownbyVisibleString(this.dropdownMangeBillingCoverageType, coverage[0], "Manage billing " , "Coverage Drop Down "));
	}

	public boolean clickOnSubmit() throws InterruptedException
	{
		boolean flag = false;
		Thread.sleep(2000);
		action.moveToElement(btnSubmit);
		if(!utils.isServiceDown()) {
			utils.scrolltomiddle();
			flag = utils.clickAnelemnt(this.btnSubmit, "Submit ", "Submit button ")	;
			if(flag && !utils.validateHeader(sHeaderManageBilling, "Review Billing Information"))
				return true;
			else {
				jse.executeScript("arguments[0].click();",btnSubmit);
				return true;
			}
		}
		else 
			return false;
	}

	public boolean clickLnkWebInsureExchangeManager()
	{
		return utils.clickAnelemnt(this.getLnkWebInsureExchangeManager(), "Manage Billing ", "Web Exchange Manager")	;
	}

	public boolean clickLnkOnDemand()
	{

		return utils.clickAnelemnt(this.getLnkOnDemand(), "Manage Billing ", "On Demand")	;
	}

	public boolean clickLnkTranscentra()
	{

		return utils.clickAnelemnt(this.getLnkTranscentra(), "Manage Billing ", "Transcentra")	;
	}

	public boolean clickbtnRetrieveHistory()
	{
		try{
			if(utils.clickAnelemnt(this.lnkHeaderHistory, "Manage Billing ", "History tab"))
				utils.clickAnelemnt(this.lnkHeaderHistory, "Manage Billing ", "History tab");
			if(utils.clickAnelemnt(this.btnRetrieveHistory, "Manage Billing ", "Retrieve History Button"))
				return true;
		}
		catch(StaleElementReferenceException e)
		{
			clickbtnRetrieveHistory();
		}
		return false;
	}

	public boolean clickbtnRetrieveSummaryBillDetailsHistory()
	{
		return utils.clickAnelemnt(this.btnRetrieveSummaryBillDetails, "Manage Billing ", "Retrieve summary Bill Button")	;
	}

	public boolean clickLnkHistory()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(this.getLnkHeaderHistory(), "Manage Billing ", "History")	;
	}

	public boolean clickLnkSummaryBillDetails()
	{
		ArrayList<String> Billvalue= new ArrayList<String>();
		Billvalue=utils.getColumnsBasedonIndex(this.tableBillingSummaryBillID,3);
		if(!Billvalue.get(0).isEmpty())
			return utils.clickAnelemnt(this.getlnkHeaderSummaryBillDetails(), "Manage Billing ", "Summary Bil Details")	;
		return false;
	}

	public boolean clickBtnRetrieveSummaryBillDetails()
	{
		return utils.clickAnelemnt(this.btnRetrieveSummaryBillDetails, "Manage Billing ", "Summary Bil Details")	;
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(), 'Summary Bill Details')]")
	private WebElement btnRetrieveSummaryBillDetails;

	@FindBy(xpath="//select[contains(@name,'SelectCoveragePeriod')]")
	private WebElement drpDownSelectCoveragePeriod;

	@FindBy(xpath="//select[contains(@name,'WorkPage$pSelectHCID')]")
	private WebElement dropDownHistorySelectHCID;

	@FindBy(xpath="//select[contains(@name,'WorkPage$pSelectHCID')]//option[@selected='']")
	private WebElement drpDownSelectHCIDSelected;

	@FindBy(xpath="//select[contains(@name,'$PpyWorkPage$pSelectCoverageType')]")
	private WebElement dropDownHistorySelectCoverageType;

	@FindBy(xpath="//select[contains(@name,'$PpyWorkPage$pSelectCoverageType')]//option[@selected='']")
	private WebElement drpDownCoverageTypeSelected;

	@FindBy(xpath="//select[contains(@name,'SelectCoveragePeriod')]//option[@selected='']")
	private WebElement drpDownCoveragePeriodSelected;

	@FindBy(xpath="//select[contains(@id,'SelectDueDate')]")
	private WebElement dropDownHistorySelectDueDate;

	@FindBy(xpath="//select[contains(@name,'SelectDueDate')]//option[@selected='']")
	private WebElement drpDownSelectDueDate;

	/**
	 * Select teh drop down
	 * @param svisibleString
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean selectDropDownSelectHCID(String svisibleString) throws InterruptedException, AWTException
	{

		System.out.println(svisibleString);       
		if(utils.selectDropDownbyVisibleString(this.dropDownHistorySelectHCID, svisibleString, "Manage Billing ", "HCID Drop Down"))
			return (!utils.isProxyWebelement(this.drpDownSelectHCIDSelected));
		return false;
	}
	public boolean selectDropDownSelectDewDate(String svisibleString) throws InterruptedException, AWTException
	{
		String arr[]= new String[2];
		arr=svisibleString.split(":");
		if(utils.selectDropDownbyVisibleString(this.dropDownHistorySelectDueDate, arr[1].trim(), "Manage Billing ", "HCID Drop Down"))
			return (!utils.isProxyWebelement(this.drpDownSelectDueDate));
		return false;
	}
	public boolean selectDropDownSelectCoverageType(String svisibleString) throws InterruptedException, AWTException
	{
		System.out.println(svisibleString); 
		if(utils.selectDropDownbyVisibleString(this.dropDownHistorySelectCoverageType, svisibleString, "Manage Billing ", "CoverageType Drop Down"))
			return (!utils.isProxyWebelement(this.drpDownCoverageTypeSelected));
		return false;
	}


	public boolean selectDropDownSelectCoveragePeriod(String svisibleString) throws InterruptedException, AWTException
	{
		String arr[]= new String[2];
		arr=svisibleString.split(":");
		jse.executeScript("scroll(500, 0);");
		return utils.selectDropDownbyVisibleString(this.drpDownSelectCoveragePeriod, arr[1], "Manage Billing ", "Coverage Period Drop Down");
	}

	JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;

	/**
	 * Select teh drop down
	 * @param svisibleString
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public boolean checkSummaryBillsTabBasedonSummaryId()
	{
		ArrayList<String> Billvalue= new ArrayList<String>();
		Billvalue=utils.getColumnsBasedonIndex(this.tableBillingSummaryBillID,3);
		if(!Billvalue.get(0).isEmpty())
		{
			return utils.clickAnelemnt(this.lnkHeaderSummaryBillDetails, "Manage Billing ", "Summary Bill tab ");
		}
		else if(Billvalue.get(0).isEmpty())
		{
			try
			{
				wait=new WebDriverWait(Driver.getPgDriver(),1);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='textIn'][contains(text(),'Summary Bill Details')]")));
				return false;
			}
			catch(Exception e)
			{
				System.out.println("Bill value is empty. And the summary bill tab is not present");
				return true;
			}
		}
		else
		{
			err.logError("Manage Billing", "Summary bil details tab check ");
			return false;
		}

	}


	/**
	 * Click on History and navigate by clicking on the drop Downs and navigating till submit 
	 * @param sData : Data in the DropDowns 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean checkHistoryandSubmit(String[] sData) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderManageBilling(),"Review Billing Information"))
			if(this.clickLnkHistory())
				if(this.selectDropDownSelectHCID(sData[0]))
					if(this.selectDropDownSelectCoverageType(sData[1]))
						if(this.clickbtnRetrieveHistory())
							if(this.getcolumnStringFromTableByName())
								return this.clickOnSubmit();
		return false;
	}

	public boolean getcolumnStringFromTableByName()
	{
		try
		{
			WebElement table_element = Driver.getPgDriver().findElement(By.xpath("//table[@class='gridTable '][contains(@pl_prop,'BillingHistory')]"));
			List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
			System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
			int row_num,col_num;
			row_num=1;
			for(WebElement trElement : tr_collection)
			{
				if(tr_collection.size()>0)
				{
					List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
					System.out.println("NUMBER OF COLUMNS="+td_collection.size());
					col_num=1;
					System.out.println(trElement.getText());
					for(WebElement tdElement : td_collection)
					{
						System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
						col_num++;
					}
					row_num++;
				}
			}


		}
		catch(StaleElementReferenceException e)
		{
			getcolumnStringFromTableByName();
		}
		return true;
	}

	@FindBy(xpath="//*[@class='formDiv labelLessSpc']/h1")
	private WebElement headerWebinsureExchangeManagerSignIn;

	@FindBy(xpath="//*[contains(text(),'User')]")
	private WebElement headerWebinsureExchangeManagerUserName;

	@FindBy(xpath="//*[contains(text(),'Password')]")
	private WebElement headerWebinsureExchangeManagerPassword;
	@FindBy(xpath="//*[contains(@id,'LoginButton_label')]")
	private WebElement headerWebinsureExchangeManagerLogin;
	@FindBy(xpath="//*[@class='title']")
	private WebElement headerOnDemandTitle;
	@FindBy(xpath="//*[@class='productName']")
	private WebElement headerOnDemandPageHEaderIBM;
	@FindBy(xpath="//*[contains(@for,'LoginPane_username')]")
	private WebElement headerOnDemandPageUserName;
	@FindBy(xpath="//*[contains(@id,'0_LoginPane_LoginButton_label')]")
	private WebElement headerOnDemandPageLogin;
	@FindBy(xpath="//*[@for='userName']")
	private WebElement labelTranscentraUserName;
	@FindBy(xpath="//*[contains(@pl_prop,'SummaryBillDetails')]")
	WebElement tableRetrieveBillingSummaryDetails;
	/**
	 * Checking the headers and the link in the page for the transcentra link 
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean verifyTranscentra() throws InterruptedException
	{
		utils.waitforpageload();
		try {
			utils.waitForChildWindowToBeVisible(2);
			return utils.TabHandles("https://view2.regulusgroup.com/view2/Login.html");
		}catch(Exception e) {
			utils.refreshPage();
			return utils.TabHandles("https://view2.regulusgroup.com/view2/Login.html");
		}
	}

	public boolean verifyOnDemand() throws InterruptedException
	{
		return utils.TabHandles("https://webi-prod.corp.anthem.com/navigator/");
	}
	public boolean verifyWebinsureExchangeManager() throws InterruptedException
	{
		if(utils.TabHandles("https://wem.anthem.com/login"))
			if(utils.validateHeader(this.headerWebinsureExchangeManagerSignIn,"Sign In"))
				if(utils.validateHeader(this.headerWebinsureExchangeManagerUserName, "User Name"))
					if(utils.validateHeader(this.headerWebinsureExchangeManagerPassword, "Password"))
						return !utils.isProxyWebelement(headerWebinsureExchangeManagerLogin);
		return false;
	}



	/**
	 * Navigate to WebInsureExchangeManager
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean checkWebinsureExchangeManager() throws InterruptedException
	{
		if(utils.validateHeader(this.getsHeaderManageBilling(),"Review Billing Information"))
			if(this.clickLnkWebInsureExchangeManager())
				return this.verifyWebinsureExchangeManager();
		return false;
	}

	/**
	 * Check the link On Demand 
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean checkOnDemand() throws InterruptedException
	{
		if(utils.validateHeader(this.getsHeaderManageBilling(),"Review Billing Information"))
			if(this.clickLnkOnDemand())
				return this.verifyOnDemand();
		return false;
	}
	/**
	 * Check the link Transcentra 
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean checkTranscentra() throws InterruptedException
	{
		boolean flag =false;
		utils.waitforpageload();
		if(utils.validateHeader(this.getsHeaderManageBilling(),"Review Billing Information"))
		{
			if(clickLnkTranscentra())
			{
				Thread.sleep(3000);
				flag = verifyTranscentra();		
			}

			if(!flag) {
				Driver.getPgDriver().close();
				if(clickLnkTranscentra())
					return verifyTranscentra();		
			}
		}
		return flag;
	}

	public boolean clickHistoryandClickDropDowns(String[] sData ) throws InterruptedException, AWTException
	{
		String HCID= sData[0].substring(sData[0].indexOf(":")+1);
		if(utils.validateHeader(this.getsHeaderManageBilling(),"Review Billing Information"))
			if(this.clickLnkHistory())
				if(this.selectDropDownSelectHCID(HCID))
					if(utils.selectDropDownbyIndex(this.dropDownHistorySelectCoverageType, 0, "Review Billing Information", "Review Billing Information"))
						return this.clickbtnRetrieveHistory();
		return false;
	}


	public boolean clickSummaryBillDetailsandRetrievesummary(String[] sData ) throws InterruptedException, AWTException
	{
		if(utils.validateHeader(this.getsHeaderManageBilling(),"Review Billing Information"))
			if(this.clickLnkSummaryBillDetails())
				if(this.selectDropDownSelectDewDate(sData[0]))
					return this.clickbtnRetrieveSummaryBillDetailsHistory();
		return false;
	}

	public boolean validateHistorybasedonDateandClickonExpand(String[] dateanddetails) throws InterruptedException
	{
		int indexval=0;
		int tempcount=0;

		System.out.println("Enter the Field");
		utils.waitforpageload();
		if(!utils.isServiceDown())
		{
			if(this.clickLnkHistory())
				this.clickLnkHistory();

			utils.clickAnelemnt(this.btnRetrieveHistory, "Manage billing ", " retrieve transaction button ");
			Thread.sleep(5000);
			utils.waitforpageload();
			String datevalue = dateanddetails[0].substring(dateanddetails[0].indexOf(":")+1);

			ArrayList<WebElement> parentexpandbutton,childTransactionexpandbutton,billsexpandbutton= new ArrayList<WebElement>();
			ArrayList<String> DateVal,paymenttype,billtype= new ArrayList<String>();
			parentexpandbutton=utils.getcolumnWebelemntFromTable(this.tableBillingHistoryWeb,0,"img");
			System.out.println("Stopped");
			int tablecount=1;
			for(int i=1;i<parentexpandbutton.size();i++)
			{ 
				parentexpandbutton=utils.getcolumnWebelemntFromTable(this.tableBillingHistoryWeb,0,"img");
				utils.clickAnelemnt(parentexpandbutton.get(i), "Manage Billing ", "Transaction History table ");
				utils.waitforpageload();
				String xpaath="//*[contains(@pl_prop,'Transaction')][@grid_ref_page='BillingHistoryList.pxResults("+(tablecount)+")']";
				String xpaath1="//*[contains(@pl_prop,'Bills')][@grid_ref_page='BillingHistoryList.pxResults("+(tablecount)+")']";
				int transactionrowcount=Driver.pgDriver.findElements(By.xpath("//*[contains(@pl_prop,'Transaction')][@grid_ref_page='BillingHistoryList.pxResults("+tablecount+")']//img[contains(@src,'validatecolumn')]")).size();
				if(transactionrowcount==0)
				{
					utils.clickAnelemnt(parentexpandbutton.get(i), "Manage Billing ", "Transaction History table ");
				}

				billsexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath1)),0,"img");
				childTransactionexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath)),0,"i");

				int billsandlettersrowcount=Driver.pgDriver.findElements(By.xpath("//*[contains(@pl_prop,'Bills')][@grid_ref_page='BillingHistoryList.pxResults("+tablecount+")']//img[contains(@src,'validatecolumn')]")).size();
				System.out.println(transactionrowcount);
				paymenttype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath)),4);
				billtype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath1)),4);
				for(int j=1;j<=transactionrowcount;j++)
				{
					if(j>1)
					{
						utils.clickAnelemnt(this.btnRetrieveHistory, "Manage Billing", "Button Summary Details");
						utils.waitforpageload();
						parentexpandbutton=utils.getcolumnWebelemntFromTable(this.tableBillingHistoryWeb,0,"img");
						utils.clickAnelemnt(parentexpandbutton.get(i), "Manage Billing ", "Transaction History table ");
						utils.waitforpageload();
						paymenttype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath)),4);
						billtype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath1)),4);
						billsexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath1)),0,"img");
						childTransactionexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath)),0,"i");
					}
					if(j%2==0)
					{
						j++;
						utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
						j--;
					}
					else
					{
						utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
					}
					Thread.sleep(2000);
					System.out.println(paymenttype);
					if(paymenttype.get(j-1).contains("Adjustment"))
					{
						System.out.println(this.labelBillingTHAdjustmenttype.getText());
						if(!this.labelBillingTHAdjustmenttype.getText().isEmpty())
						{
							if(!this.labelBillingTHAdjustmentAmount.getText().isEmpty())
							{
								if(!this.labelBillingTHAdjustmentDescription.getText().isEmpty())
								{
									if(!this.labelBillingTHAdjustmentProcessedDate.getText().isEmpty())
									{
										if(j%2==0)
										{
											j++;
											utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
											j--;
										}
										else
										{
											utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
										}
										continue;
									}

									else
									{
										System.out.println(" Processed Date is Empty");
										return false;
									}
								}
								else 
								{
									System.out.println("Adjusmtent Description is empty");
									return false;
								}
							}
							else
							{
								System.out.println("Adjusmtent Amount is empty");
								return false;
							}
						}
						else
						{
							System.out.println("Before failing"+this.labelBillingTHAdjustmenttype.getText());
							System.out.println("Adjustment type is empty");
							return false;
						}
					}
					else
					{
						System.out.println("Else part");
					}


				}
				for(int j=1;j<=billsandlettersrowcount;j++)
				{
					if(j>1)
					{
						utils.clickAnelemnt(this.btnRetrieveHistory, "Manage Billing", "Button Summary Details");
						utils.waitforpageload();
						parentexpandbutton=utils.getcolumnWebelemntFromTable(this.tableBillingHistoryWeb,0,"img");
						utils.clickAnelemnt(parentexpandbutton.get(i), "Manage Billing ", "Transaction History table ");
						utils.waitforpageload();
						paymenttype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath)),4);
						billtype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath1)),4);
						billsexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath1)),0,"img");
						childTransactionexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath)),0,"i");
					}
					if(j%2==0)
					{
						j++;
						utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
						j--;
					}
					else
					{
						utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
					}
					utils.clickAnelemnt(billsexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
					Thread.sleep(2000);
					System.out.println("CHECKPOINTTTTTTTTTTTTTT j  value "+j);
					if(billtype.get(j-1).contains("Bill"))
					{
						if(!this.labelBillingSummaryBPCharges.getText().isEmpty())
						{
							if(!this.labelBillingSummaryBPBillDate.getText().isEmpty())
							{
								if(!this.labelBillingSummaryBPDueDate.getText().isEmpty())
								{
									i++;
									continue;
								}
								else 
								{
									System.out.println("Adjusmtent Description is empty");
									return false;
								}
							}
							else
							{
								System.out.println("Adjusmtent Amount is empty");
								return false;
							}
						}
						else
						{
							System.out.println("Adjustment Charges is empty");
							return false;
						}
					}
					else
					{
						System.out.println("Parent table is Empty");
					}


				}
				System.out.println("Done");
				tablecount++;
				utils.clickAnelemnt(this.btnRetrieveHistory, "Manage Billing", "History Tab");
				System.out.println("ddd");
				if(tempcount<0)
				{
					System.out.println("Table is empty");
					err.logError("Manage Billing ", "table is empty ");
					return false;
				}
			}
			return true;

		}
		else 
			return false;
	}


	public boolean validateSummaryBillPagebasedonDateandClickonExpand() throws InterruptedException
	{
		int indexval=0;
		int tempcount=0;
		utils.waitforpageload();
		System.out.println("Enter the Field");
		if(!utils.isServiceDown())
		{
			utils.clickAnelemnt(this.lnkHeaderSummaryBillDetails, "ManageBilling", "Header-Summary");
			if(utils.clickAnelemnt(this.lnkHeaderSummaryBillDetails, "ManageBilling", "Header-Summary"))
			{
				utils.waitforpageload();

				ArrayList<WebElement> parentexpandbutton,childTransactionexpandbutton,billsexpandbutton= new ArrayList<WebElement>();
				ArrayList<String> DateVal,paymenttype,billtype= new ArrayList<String>();

				System.out.println("Stopped");
				int tablecount=1;
				ArrayList<WebElement> expandbutton= new ArrayList<WebElement>();

				parentexpandbutton=utils.getcolumnWebelemntFromTable(this.tableRetrieveBillingSummaryDetails,0,"img");
				System.out.println("Stopped");
				ArrayList<String> dateColumn = new ArrayList<String>();
				for(int i=1;i<parentexpandbutton.size();i++)
				{ 
					parentexpandbutton=utils.getcolumnWebelemntFromTable(this.tableRetrieveBillingSummaryDetails,0,"img");
					utils.clickAnelemnt(parentexpandbutton.get(i), "Manage Billing ", "Transaction History table ");
					System.out.println("paretexpandbutton values is ----------------------" +parentexpandbutton);

					utils.waitforpageload();
					String xpaath="//*[contains(@pl_prop,'Transaction')][@grid_ref_page='SummaryBillDetails.pxResults("+(tablecount)+")']";
					String xpaath1="//*[contains(@pl_prop,'Bills')][@grid_ref_page='SummaryBillDetails.pxResults("+(tablecount)+")']";
					int transactionrowcount=Driver.pgDriver.findElements(By.xpath("//*[contains(@pl_prop,'Transaction')][@grid_ref_page='SummaryBillDetails.pxResults("+tablecount+")']//img[contains(@src,'validatecolumn')]")).size();
					if(transactionrowcount==0)
					{
						utils.clickAnelemnt(parentexpandbutton.get(i), "Manage Billing ", "Transaction History table ");

					}

					billsexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath1)),0,"img");
					childTransactionexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath)),0,"i");

					int billsandlettersrowcount=Driver.pgDriver.findElements(By.xpath("//*[contains(@pl_prop,'Bills')][@grid_ref_page='SummaryBillDetails.pxResults("+tablecount+")']//img[contains(@src,'validatecolumn')]")).size();
					System.out.println(transactionrowcount);
					paymenttype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath)),4);
					billtype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath1)),4);
					for(int j=1;j<=transactionrowcount;j++)
					{
						if(j>1)
						{
							utils.clickAnelemnt(this.btnRetrieveSummaryBillDetails, "Manage Billing", "Button Summary Details");
							utils.waitforpageload();
							parentexpandbutton=utils.getcolumnWebelemntFromTable(this.tableRetrieveBillingSummaryDetails,0,"img");
							utils.clickAnelemnt(parentexpandbutton.get(i), "Manage Billing ", "Transaction History table ");
							utils.waitforpageload();
							paymenttype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath)),4);
							billtype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath1)),4);
							billsexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath1)),0,"img");
							childTransactionexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath)),0,"i");
						}
						if(j%2==0)
						{
							j++;
							utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
							j--;
						}
						else
						{
							utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
						}


						Thread.sleep(2000);
						if(paymenttype.get(j-1).contains("Adjustment"))
						{
							if(!this.labelBillingTHAdjustmenttype.getText().isEmpty())
							{
								if(!this.labelBillingTHAdjustmentAmount.getText().isEmpty())
								{
									if(!this.labelBillingTHAdjustmentDescription.getText().isEmpty())
									{
										if(!this.labelBillingTHAdjustmentProcessedDate.getText().isEmpty())
										{
											utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
											continue;	
										}

										else
										{
											System.out.println(" Processed Date is Empty");
											return false;
										}
									}
									else 
									{
										System.out.println("Adjusmtent Description is empty");
										return false;
									}
								}
								else
								{
									System.out.println("Adjusmtent Amount is empty");
									return false;
								}
							}
							else
							{
								System.out.println("Adjustment type is empty");
								return false;
							}
						}
						else
						{

						}


					}
					for(int j=1;j<=billsandlettersrowcount;j++)
					{
						if(j>1)
						{
							utils.clickAnelemnt(this.btnRetrieveHistory, "Manage Billing", "Button Summary Details");
							utils.waitforpageload();
							parentexpandbutton=utils.getcolumnWebelemntFromTable(this.tableRetrieveBillingSummaryDetails,0,"img");
							utils.clickAnelemnt(parentexpandbutton.get(i), "Manage Billing ", "Transaction History table ");
							utils.waitforpageload();
							paymenttype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath)),4);
							billtype=utils.getColumnsBasedonIndex(Driver.pgDriver.findElement(By.xpath(xpaath1)),4);
							billsexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath1)),0,"img");
							childTransactionexpandbutton=utils.getcolumnWebelemntFromTable(Driver.pgDriver.findElement(By.xpath(xpaath)),0,"i");
						}
						if(j%2==0)
						{
							j++;
							utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
							j--;
						}
						else
						{
							utils.clickAnelemnt(childTransactionexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
						}

						utils.clickAnelemnt(billsexpandbutton.get(j), "Manage Billing", "History - transaction Inner table");
						Thread.sleep(2000);
						if(billtype.get(j-1).contains("Bill"))
						{
							if(!this.labelBillingSummaryBPCharges.getText().isEmpty())
							{
								if(!this.labelBillingSummaryBPBillDate.getText().isEmpty())
								{
									if(!this.labelBillingSummaryBPDueDate.getText().isEmpty())
									{
										i++;
										continue;
									}
									else 
									{
										System.out.println("Adjusmtent Description is empty");
										return false;
									}
								}
								else
								{
									System.out.println("Adjusmtent Amount is empty");
									return false;
								}
							}
							else
							{
								System.out.println("Adjustment Charges is empty");
								return false;
							}
						}
						else
						{
							err.logError("Manage Billing", "Bill Table inside sumary bill");

							System.out.println("Parent table is Empty");
							return false;
						}


					}
					System.out.println("Done");
					tablecount++;
					utils.clickAnelemnt(this.btnRetrieveSummaryBillDetails, "Manage Billing", "History Tab");
					System.out.println("ddd");

					if(tempcount<0)
					{
						System.out.println("Table is empty");

						err.logError("Manage Billing ", "table is empty ");
						return false;
					}
				}
			}

			return true;
		}
		else 
			return false;
	}

	public boolean CancelBilling(String[] cancelreason)
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Review Billing", "Other Actions Button"))
			if(utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Review Billing", "Cancel this Work"))
				if(utils.validateHeader(this.getsHeaderManageBilling(),"Cancel this work"))
					if(utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, cancelreason[0], "Cancel Billing", "Cancel reason"))
						return utils.clickAnelemnt(this.btnSubmit, "cancel Billing", "Submit button on cancel billing");
		return false;
	}

	@FindBy(linkText="Member Payment CSR Portal")
	private WebElement lnkCSRPortal;

	@FindBy(xpath="//input[@name='continueId']")
	private WebElement BtnLogin;

	@FindBy(id="txtSaliLogInUsername")
	private WebElement csrUsernameTxtbox;

	@FindBy(id="txtSaliLogInPassword")
	private WebElement csrPwdTxtbox;

	@FindBy(xpath="//a[text()='Member Payment CSR']")
	private WebElement csrLoginLabel;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDisplayOfCSRPortalLink
	 * Type:TextBox
	 * Description:Verify CSR Portal link is added to Manage Billing task
	 */
	public boolean verifyDisplayOfCSRPortalLink(){
		utils.waitforpageload();
		if(!utils.isServiceDown())
		{
			if(utils.validateHeader(this.sHeaderManageBilling, "Review Billing Information")){
				try{
					if(this.lnkCSRPortal.isDisplayed()){
						utils.clickAnelemnt(this.lnkCSRPortal, "Manage Billing", "CSR Portal Link");
						System.out.println("CSR Portal link is added to Manage Billing task and user clicks the link");
						Set<String> handles = Driver.pgDriver.getWindowHandles();
						Iterator<String> iterator = handles.iterator();
						String parentWindow = iterator.next();
						String childWindow = iterator.next();
						String title = Driver.pgDriver.switchTo().window(childWindow).getTitle().trim();
						if(title.contains("Member Pay - CSR")){
							if(this.csrLoginLabel.isDisplayed() && this.csrUsernameTxtbox.isDisplayed() && this.csrPwdTxtbox.isDisplayed()){
								System.out.println("CSR Portal is launched - Title is"+ title); 
							}else{
								System.out.println("CSR Portal fields are not displayed"+ title);
								return false;
							}
						}else{
							err.logcommonMethodError("Manage Billing", "Error in switching to childwindow");
							return false;
						}
						return true;
					}
				}catch(Exception e){
					err.logcommonMethodError("Manage Billing", "CSR Portal Link is not displayed in Manage Billing Task");
					return false;}
			}
			err.logcommonMethodError("Manage Billing", "Review Billing Information page is not loaded");
			return false;
		}
		return false;
	}	


	@FindBy(id="ServiceFromDate")
	WebElement txtStartDate;

	@FindBy(id="ServiceToDate")
	WebElement txtEndDate;

	public boolean enterStartDate(String date)
	{
		return utils.enterTextinAnelemnt(this.txtStartDate, date, "ManageBilling", "Start Date");
	}

	public boolean enterEndDate(String date)
	{
		return utils.enterTextinAnelemnt(this.txtEndDate, date, "ManageBilling", "End Date");
	}

	/*
	 *@SCU
	 *#CommonMethodWithArgument: enterStartAndEndDate
	 *#Description: This functionality enters the Start and End Date in the Dates Section
	 *#Argument: date
	 *Type: Textbox
	 */
	public boolean enterStartAndEndDate(String[] date)
	{
		utils.waitforpageload();
		if(this.enterStartDate(date[0]))
		{
			utils.waitforpageload();
			if(this.enterEndDate(date[1]))
			{
				System.out.println("Dates Entered");
				return true;
			}
		}
		err.logError("ManageBilling", "Start and End Date Entered Failing");
		return false;

	}


	@FindBy(xpath="//div[contains(text(),'Generate Premium Payment Report')]")
	WebElement btnPremiumPaymentReport;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickPremiumPaymentReport
	 * #Description: This functionality performs click action on the Premium Payment Report button
	 * Type: Textbox
	 */
	public boolean clickPremiumPaymentReport()
	{
		return utils.clickAnelemnt(this.btnPremiumPaymentReport, "ManageBilling", "Premium Payment Report Button");
	}

	@FindBy(id="SendReportAsEmailtrue")
	WebElement rdoBtnYesInEmail;

	@FindBy(id="SendReportAsEmailfalse")
	WebElement rdoBtnNoInEmail;

	@FindBy(id="MemberEmailID")
	WebElement txtEmailAddress;

	@FindBy(xpath="//div[@node_name='PaymentHistoryExport']//div[contains(text(),'Send by email')]")
	WebElement btnSendForEmail;

	@FindBy(xpath="//div[@node_name='PaymentHistoryExport']//div[contains(text(),'Preview')]")
	WebElement btnPreview;

	@FindBy(xpath="//div[@node_name='PaymentHistoryExport']//div[contains(text(),'Export to PDF')]")
	WebElement btnExportToPDF;

	@FindBy(id="MemberName")
	WebElement txtMemberName;

	@FindBy(id="AddressLine1")
	WebElement txtAddressLine1;

	@FindBy(id="AddressLine2")
	WebElement txtAddressLine2;

	@FindBy(id="pyCity")
	WebElement txtCity;

	@FindBy(id="pyState")
	WebElement drpDownState;

	@FindBy(id="pyPostalCode")
	WebElement txtZipCode;

	@FindBy(xpath="//div[@node_name='PaymentHistoryExport']//div[contains(text(),'Cancel')]")
	WebElement btnCancel;

	@FindBy(xpath="//div[@node_name='PaymentHistoryExport']//div[contains(text(),'Clear')]")
	WebElement btnClear;

	@FindBy(xpath="//div[@node_name='PaymentHistoryExport']//div[contains(text(),'Reset')]")
	WebElement btnReset;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickYesForEmail
	 * #Description: This functionality performs click Yes Option in the Email Selection
	 * Type: Textbox
	 */
	public boolean clickYesForEmail()
	{
		return utils.clickAnelemnt(this.rdoBtnYesInEmail, "ManageBilling", "Yes Option in Email");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickNoForEmail
	 * #Description: This functionality performs click No Option in the Email Selection
	 * Type: Textbox
	 */
	public boolean clickNoForEmail()
	{
		return utils.clickAnelemnt(this.rdoBtnNoInEmail, "ManageBilling", "Yes Option in Email");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSendByEmailOption
	 * #Description: This functionality performs click Option in the Send By Email button
	 * Type: Textbox
	 */
	public boolean clickSendByEmailOption()
	{
		return utils.clickAnelemnt(this.btnSendForEmail, "ManageBilling", "Send For Email");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterEmailAddress
	 * #Description: This functionality enters the email to send the premium report in the email section.
	 * Argument: email
	 * Type: Textbox
	 */
	public boolean enterEmailAddress(String[] email)
	{
		if(utils.enterTextinAnelemnt(this.txtEmailAddress, email[0], "Manage Billing", "Email Address")) {
			txtEmailAddress.sendKeys(Keys.TAB);
			return true;
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeMemberName
	 * #Description: This functionality modifies the member name in the Generate Premium Payment Report Section.
	 * Argument: memname
	 * Type: Textbox
	 */
	public boolean changeMemberName(String[] memname)
	{
		return utils.enterTextinAnelemnt(this.txtMemberName, memname[0], "ManageBilling", "Member Name");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeAddressLine1
	 * #Description: This functionality modifies the address line 1 in the Generate Premium Payment Report Section.
	 * Argument: addline1
	 * Type: Textbox
	 */
	public boolean changeAddressLine1(String[] addline1)
	{
		return utils.enterTextinAnelemnt(this.txtAddressLine1, addline1[0], "ManageBilling", "Address Line 1");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeAddressLine2
	 * #Description: This functionality modifies the address line 2 in the Generate Premium Payment Report Section.
	 * Argument: addline2
	 * Type: Textbox
	 */
	public boolean changeAddressLine2(String[] addline2)
	{
		return utils.enterTextinAnelemnt(this.txtAddressLine2, addline2[0], "ManageBilling", "Address Line 2");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeCity
	 * #Description: This functionality modifies the city in the Generate Premium Payment Report Section.
	 * Argument: city
	 * Type: Textbox
	 */
	public boolean changeCity(String[] city)
	{
		return utils.enterTextinAnelemnt(this.txtCity, city[0], "ManageBilling", "City");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeState
	 * #Description: This functionality modifies the state in the Generate Premium Payment Report Section.
	 * Argument: state
	 * Type: Textbox
	 */
	public boolean changeState(String[] state)
	{
		return utils.enterTextinAnelemnt(this.drpDownState, state[0], "ManageBilling", "State");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: changeZipCode
	 * #Description: This functionality modifies the zip code in the Generate Premium Payment Report Section.
	 * Argument: zipcode
	 * Type: Textbox
	 */
	public boolean changeZipCode(String[] zipcode)
	{
		if(utils.enterTextinAnelemnt(this.txtZipCode, zipcode[0], "ManageBilling", "Zip Code")) {
			txtZipCode.sendKeys(Keys.TAB);
			return true;
		}
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCancelInPremiumReport
	 * #Description: This functionality performs click action in the Cancel button in Premium Report Page.
	 * Type: Textbox
	 */
	public boolean clickCancelInPremiumReport()
	{
		return utils.clickAnelemnt(this.btnCancel, "ManageBilling", "Cancel");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickClearInPremiumReport
	 * #Description: This functionality performs click action in the Clear button in Premium Report Page.
	 * Type: Textbox
	 */
	public boolean clickClearInPremiumReport()
	{
		return utils.clickAnelemnt(this.btnClear, "ManageBilling", "Clear");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickResetInPremiumReport
	 * #Description: This functionality performs click action in the Reset button in Premium Report Page.
	 * Type: Textbox
	 */
	public boolean clickResetInPremiumReport()
	{
		return utils.clickAnelemnt(this.btnReset, "ManageBilling", "Reset");
	}

	public boolean clickPreviewButton()
	{
		return utils.clickAnelemnt(this.btnPreview, "ManageBilling", "Preview");
	}

	String ParentWindow;

	public boolean clickExportToPDFButton()
	{
		ParentWindow = Driver.pgDriver.getWindowHandle();
		System.out.println("Parent Window: "+ParentWindow);
		return utils.clickAnelemnt(this.btnExportToPDF, "ManageBilling", "Export");

	}

	public boolean cancelTheDownload() throws AWTException
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
		return true;


	}

	@FindBy(xpath="//label[@for='pyTemplateInputBox2']/following::a/img")
	WebElement chkBoxFirstRowInBilling;

	public boolean clickFirstRowInBilling()
	{
		return utils.clickAnelemnt(this.chkBoxFirstRowInBilling, "ManageBilling", "First Row");
	}


	@FindBy(name="$PpyWorkPage$pSelectHCID")
	WebElement drpDownHCID;

	@FindBy(name="$PpyWorkPage$pSelectCoverageType")
	WebElement drpDownCoverageType;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectHCIDInBilling
	 * #Description: This functionality selects the value from the HCID drop down in the Manage Billing page
	 * #Argument: hcid
	 * Type: Textbox
	 */
	public boolean selectHCIDInBilling(String[] hcid)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownHCID, hcid[0], "ManageBilling", "HCID");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectCoverageTypeInBilling
	 * #Description: This functionality selects the value from the Coverage Type drop down in the Manage Billing page
	 * #Argument: covergaeType
	 * Type: Textbox
	 */
	public boolean selectCoverageTypeInBilling(String[] covergaeType)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownCoverageType, covergaeType[0], "ManageBilling", "Coverage Type");
	}

	public boolean clickIESave() throws AWTException, Exception {
		Thread.sleep(20000);
		Runtime.getRuntime().exec("C:\\Users\\AF56975\\Desktop\\AutoIT\\IESave1.exe");
		return true;
	}



	@FindBy(xpath="//label[@data-test-id='20181024155247071811410']/span")
	WebElement labelPasswordField;

	@FindBy(xpath="//input[@id='IsPasswordProvided']")
	WebElement checkboxPasswordProvided;

	/**
	 * To validate the check box is selected by user on providing the password for Premium payment report to the user during conversation
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean clickPasswordProvidedtoContactCheckbox() throws InterruptedException
	{
		WebElement element = Driver.pgDriver.findElement(By.xpath("//input[@id='IsPasswordProvided']"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		if(utils.clickAnelemnt(checkboxPasswordProvided, "Manage Billing", "PasswordProvidedcheckbox"))
			return true;
		return false;
	}

}






