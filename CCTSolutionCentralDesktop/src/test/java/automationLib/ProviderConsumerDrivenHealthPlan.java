package automationLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ProviderConsumerDrivenHealthPlan extends Driver{
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	
	@FindBy(id="PegaGadget0Ifr")
	WebElement Iframeelement0;
	
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement1;
	
	
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCDHP;

	@FindBy(xpath="//label[contains(text(),'View Consumer Driven Health Plan Accounts')][@class='actionTitleBarLabelStyle']")
	private WebElement viewCDHPAcctsHdr;
	
	@FindBy(linkText="Anthem CDH")
	private WebElement anthemCDHLink;
	
	@FindBy(linkText="Tier 1 / Tier 2 Document")
	private WebElement tier1_tier2DocLink;
	
	@FindBy(linkText="Customer Account Database (CAD)")
	private WebElement cadLink;
	
	/**
	 * Constructor for the ConsumerDrivenHealthPlan class defining the Iframe and the Page Factory  
	 */
	public ProviderConsumerDrivenHealthPlan() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 30), this);
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
	
	/*
	 *@SCU
	 *#CommonMethodwithoutArgument:validateCDHPViewPage
	 *Type:Textbox
	 *Description:This method verifies if headers and links - Anthem CDH, Tier1/Tier2 Document, CAD links are properly displayed when page is loaded
	 */
	public boolean validateCDHPViewPage(){
		utils.waitforpageload();
			if(utils.validateHeader(this.sHeaderCDHP, "View Consumer Driven Health Plan Accounts"))
				return !utils.isProxyWebelement(anthemCDHLink) && !utils.isProxyWebelement(tier1_tier2DocLink) && !utils.isProxyWebelement(cadLink);
			return false;
				
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDisplayOfTier1OrTier2DocumentLink
	 * Type:TextBox
	 * Description: This method verifies if Tier1/Tier2 Document link is displayed on the "View Consumer Driven Health Plan Accounts" page
	 * and user clicks on it - to navigate Knowledge Library which would help CSR to answer CDHP related inquiries coming from member on call.
	 */
	public boolean verifyDisplayOfTier1OrTier2DocumentLink() throws InterruptedException, AWTException{
		String parent = Driver.pgDriver.getWindowHandle();
		if(utils.validateHeader(this.sHeaderCDHP, "View Consumer Driven Health Plan Accounts"))
		{
			if(this.tier1_tier2DocLink.isDisplayed()){
				utils.clickAnelemnt(this.tier1_tier2DocLink, "ConsumerDrivenHealthPlan", "Tier1 / Tier2 Document");
				System.out.println("Tier1 / Tier2 Document link is added to 'ConsumerDrivenHealthPlan' task and user clicks the link");
				Robot ro=new Robot();
				Thread.sleep(10000);
				ro.keyPress(KeyEvent.VK_TAB);
				ro.keyRelease(KeyEvent.VK_TAB);
				ro.keyPress(KeyEvent.VK_TAB);
				ro.keyRelease(KeyEvent.VK_TAB);
				ro.keyPress(KeyEvent.VK_TAB);
				ro.keyRelease(KeyEvent.VK_TAB);
				ro.keyPress(KeyEvent.VK_ENTER);	
				ro.keyRelease(KeyEvent.VK_ENTER);	
				utils.waitforpageload();
				Set<String> Windows=Driver.pgDriver.getWindowHandles();
				System.out.println("THe window Size is: "+Windows.size());	
				int j=1;
				try {
					for (String window:Windows){				
						Driver.pgDriver.switchTo().window(window);
						System.out.println("The "+j+"st window switched");
						j++;
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String title = Driver.pgDriver.getTitle().trim();
				System.out.println(title);
				//Need to update the title of the page - newly opened Knowledge Library
				if(title.contains("Anthem Tier 1 and Tier 2 Calls Chart")){
					System.out.println("Knowledge Library is launched - Title is"+ title); 
					return true;
				 }else{
				  err.logcommonMethodError("ConsumerDrivenHealthPlan", "Error in switching to childwindow-Tier1/Tier2");
				  return false;
				 }
			}
			err.logcommonMethodError("ConsumerDrivenHealthPlan", "Tier1 / Tier2 Document link is not displayed in - View Consumer Driven Health Plan Accounts");
			return false;
		}
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "View Consumer Driven Health Plan Accounts page is not loaded");
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDisplayOfCADLink
	 * Type:TextBox
	 * Description: This method verifies if 'Consumer Access Database (CAD)' link is displayed on the "View Consumer Driven Health Plan Accounts" page
	 * and user clicks on it - to navigate to the CAD (Anthem.com Emulator) tool so that CSR can assist a member with online navigation steps to access their CDHP details.
	 */
	public boolean verifyDisplayOfCADLink() throws InterruptedException{
		if(utils.validateHeader(this.sHeaderCDHP, "View Consumer Driven Health Plan Accounts")){
			if(this.cadLink.isDisplayed()){
				utils.clickAnelemnt(this.cadLink, "ConsumerDrivenHealthPlan", "Consumer Access Database (CAD)");
				System.out.println("Consumer Access Database (CAD) link is added to 'CDHP' page and user clicks the link");
				utils.waitforpageload();
				Set<String> Windows=Driver.pgDriver.getWindowHandles();
				System.out.println("THe window Size is: "+Windows.size());	
				int i=1;
				try {
					for (String window:Windows){				
						Driver.pgDriver.switchTo().window(window);
						System.out.println("The "+i+"st window switched");
						i++;
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				utils.waitforpageload();
				String title = Driver.pgDriver.getTitle().trim();
				//Need to update the title of the page - newly opened Knowledge Library
				if(title.contains("Application Login")){
					System.out.println("Consumer Access Database (CAD) is launched - Title is"+ title); 
					int j=1;
					try {
						for (String window:Windows){				
							Driver.pgDriver.switchTo().window(window);
							System.out.println("The "+i+"st window switched");
							break;
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return true;
				 }else{
				  err.logcommonMethodError("ConsumerDrivenHealthPlan", "Error in switching to childwindow -CAD");
				  return false;
				 }
			}
			err.logcommonMethodError("ConsumerDrivenHealthPlan", "Consumer Access Database (CAD) link is not displayed in - View Consumer Driven Health Plan Accounts");
			return false;
		}
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "View Consumer Driven Health Plan Accounts page is not loaded");
		return false;
	}
	
	@FindBy(xpath="//*[text()='Consumer Driven Health Plan Accounts']")
	WebElement lblCDHPAccounts;
	@FindBy(xpath="//*[contains(@gpropindex,'D_CDHPAccountSummaryPpxResults')]//table[@class='gridTable ']")
	WebElement CDHPAccountsLevelTable;
	@FindBy(id="Grid_NoResults")
	WebElement noResultsGrid;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCDHPAccountsColHeader
	 * #Arguments:Column headers should be passed as comma separated parameters as in order of UI -"Account Description,Status,Effective Date,Plan Start Date,Plan End Date".
	 * Type:Text
	 * Description: This method verifies that if Consumer Driven Health Plan Accounts - table grid is displayed and its column headers are validated.
	 */
	public boolean validateCDHPAccountsColHeader(String[] args){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.CDHPAccountsLevelTable);
		String space = " , , , ";
		StringBuilder input = new StringBuilder();
		String colHdrs[] = input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).toString().split(",");
		if(this.lblCDHPAccounts.isDisplayed() && this.CDHPAccountsLevelTable.isDisplayed()){
			if(utils.validateTableRowHeader(this.CDHPAccountsLevelTable, colHdrs)){
			blogger.loginfo("Column Headers in UI matched with user data- Consumer Driven Health Plan Accounts Table");
			try{
				if(!utils.isProxyWebelement(noResultsGrid)){
					blogger.loginfo("Thr grid displays - No Items");
					return true;
				}
			}catch(Exception e){
				blogger.loginfo("Thr grid displays data");
				return true;				
			}
		}
			err.logError("ConsumerDrivenHealthPlan", "Column headers do not match in- Consumer Driven Health Plan Accounts Table");
			return false;
		}else
			err.logError("ConsumerDrivenHealthPlan", "Consumer Driven Health Plan Accounts and table sections are not displayed in UI");
		return false;
	}
	
	@FindBy(xpath="//label[contains(text(),'Summary')]")
	WebElement lblSummaryTab;
	@FindBy(xpath="//label[contains(text(),'Transactions')]")
	WebElement lblTransactionTab;
	@FindBy(xpath="//span[@id='TABSPAN']//label[@inanchor][contains(text(),'Custodian Bank')]")
	WebElement lblCustodianBankTab;
	//@FindBy(xpath="//span[@id='TABSPAN']//label[@inanchor][contains(text(),'Card Info')]")
	@FindBy(xpath="//a[@id='TABANCHOR'][@tabtitle='Card Information']")
	WebElement lblCardInfoTab;
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectCDHPAccountLevelInfo
	 * #Description:This method selects a particular 'Consumer Driven Health Plan Account Info', depending on the parameters passed for selection. 
	 * #Arguments:CDHPAccountLevel-KeyValuePair
	 * Type:Table
	 * Keys:#Account Description#Status#Effective Date#Plan Start Date#Plan End Date
	 */
	public boolean selectCDHPAccountLevelInfo(String[] args) throws InterruptedException{
		boolean returnvar =true;
		String desc = null,status= null,effdt= null,startdt= null,enddt=null;
		ArrayList<String> expected= new ArrayList<String>();
		utils.waitforpageload();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("selectCDHPAccountLevelInfo", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			
			if(key.toLowerCase().contains("description"))
			{			
						returnvar=true;
						desc=value.toLowerCase().trim();				
						continue;	
			}
			else if(key.toLowerCase().contains("status"))
			{
					returnvar=true;
					status=value.toLowerCase().trim();
					continue;
				
			}
			else if(key.toLowerCase().contains("eff"))
			{
					returnvar=true;
					effdt=value.toLowerCase().trim();
					continue;
				
			}
			else if(key.toLowerCase().contains("start"))
			{
					returnvar=true;
					startdt=value.toLowerCase().trim();
					continue;
			}
			else if(key.toLowerCase().contains("end"))
			{
					returnvar=true;
					enddt=value.toLowerCase().trim();
					continue;
			}
			else
			{
			err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
		    return false;
			}
		}
			if(returnvar)
			{
			System.out.println("No issues in Key value pair: \nAccount Description:"+desc+"\nStatus:"+status+"\nEffective date"+effdt+"\nPlan Start Date:"+startdt+"\nPlan EndDate:"+enddt);
			}
		
			try{
				if(utils.clickontablerowbasedonvalues(this.CDHPAccountsLevelTable,args)){
					if(!utils.isProxyWebelement(lblSummaryTab)){
					}else
					System.out.println("Summary Tab is not displayed by default on page load - CDHP Account level info");
				}
			}
			
			catch (NoSuchElementException e){
				if(utils.clickontablerowbasedonvalues(this.CDHPAccountsLevelTable,args)){
					if(!utils.isProxyWebelement(lblSummaryTab)){
					System.out.println("Summary Tab is displayed by default on page load - When user clicks on CDHP Account level info");
					}else
					System.out.println("Summary Tab is not displayed by default on page load - CDHP Account level info");
				}
			}
			
			catch (Exception e){
				System.out.println("Entire row not matching for given input CDHP -in Account Level" + e);
			}
			
			
		if(!returnvar)
		 {
			 System.out.println("Matching rows not found for given input");	
			 return false;
		}
		return true;	
	}
	
	//Xpaths for capturing labels and fields in Summary tab.
	@FindBy(xpath="//label[contains(text(),'Account Description')]")
	private WebElement lbl_acct_description;
	@FindBy(xpath="//label[contains(text(),'Account Description')]/following-sibling::div/span")
	private WebElement txt_acct_description;
	
	@FindBy(xpath="//label[contains(text(),'Account Type')]")
	private WebElement lbl_acct_type;
	@FindBy(xpath="//label[contains(text(),'Account Type')]/following-sibling::div/span")
	private WebElement txt_acct_type;
	
	@FindBy(xpath="//label[contains(text(),'Status')]")
	private WebElement lbl_status;
	@FindBy(xpath="//label[contains(text(),'Status')]/following-sibling::div/span")
	private WebElement txt_status;
	
	@FindBy(xpath="//label[contains(text(),'Effective Date')]")
	private WebElement lbl_eff;
	@FindBy(xpath="//label[contains(text(),'Effective Date')]/following-sibling::div/span")
	private WebElement txt_eff;
	
	@FindBy(xpath="//label[contains(text(),'Plan Start Date')]")
	private WebElement lbl_start;
	@FindBy(xpath="//label[contains(text(),'Plan Start Date')]/following-sibling::div/span")
	private WebElement txt_start;
	
	@FindBy(xpath="//label[contains(text(),'Plan End Date')]")
	private WebElement lbl_end;
	@FindBy(xpath="//label[contains(text(),'Plan End Date')]/following-sibling::div/span")
	private WebElement txt_end;
	
	@FindBy(xpath="//label[contains(text(),'Last Date of Spending')]")
	private WebElement lbl_ld_of_spending;
	@FindBy(xpath="//label[contains(text(),'Last Date of Spending')]/following-sibling::div/span")
	private WebElement txt_ld_of_spending;
	
	
	@FindBy(xpath="//label[contains(text(),'Last Date to Submit Claims')]")
	private WebElement lbl_ld_for_submitclaims;
	@FindBy(xpath="//label[contains(text(),'Last Date to Submit Claims')]/following-sibling::div/span")
	private WebElement txt_ld_for_submitclaims;
	
	@FindBy(xpath="//label[contains(text(),'Fund Rollover Rule')]")
	private WebElement lbl_fund_rollover_rule;
	@FindBy(xpath="//label[contains(text(),'Fund Rollover Rule')]/following-sibling::div/span")
	private WebElement txt_fund_rollover_rule;
	
	@FindBy(xpath="//label[contains(text(),'Fund Rollover Percentage(%)')]")
	private WebElement lbl_fund_rollover_percentage;
	@FindBy(xpath="//label[contains(text(),'Fund Rollover Percentage(%)')]/following-sibling::div/span")
	private WebElement txt_fund_rollover_percentage;
	
	@FindBy(xpath="//label[contains(text(),'Fund Rollover Cap')]")
	private WebElement lbl_fund_rollover_cap;
	@FindBy(xpath="//label[contains(text(),'Fund Rollover Cap')]/following-sibling::div/span")
	private WebElement txt_fund_rollover_cap;
	
	@FindBy(xpath="//label[contains(text(),'Fund Rollover Date')]")
	private WebElement lbl_fund_rollover_date;
	@FindBy(xpath="//label[contains(text(),'Fund Rollover Date')]/following-sibling::div/span")
	private WebElement txt_fund_rollover_date;
	
	@FindBy(xpath="//label[contains(text(),'Annual Election')]")
	private WebElement lbl_annual_election;
	@FindBy(xpath="//label[contains(text(),'Annual Election')]/following-sibling::div/span")
	private WebElement txt_annual_election;
	
	@FindBy(xpath="//label[contains(text(),'Contribution YTD')]")
	private WebElement lbl_contribution_ytd;
	@FindBy(xpath="//label[contains(text(),'Contribution YTD')]/following-sibling::div/span")
	private WebElement txt_contribution_ytd;
	
	@FindBy(xpath="//label[contains(text(),'Incentives Deposits')]")
	private WebElement lbl_incentives_deposits;
	@FindBy(xpath="//label[contains(text(),'Incentives Deposits')]/following-sibling::div/span")
	private WebElement txt_incentives_deposits;
	
	@FindBy(xpath="//label[contains(text(),'Rollover Deposits')]")
	private WebElement lbl_rollover_deposit;
	@FindBy(xpath="//label[contains(text(),'Rollover Deposits')]/following-sibling::div/span")
	private WebElement txt_rollover_deposit;
	
	@FindBy(xpath="//label[contains(text(),'Available Balance')]")
	private WebElement lbl_available_balance;
	@FindBy(xpath="//label[contains(text(),'Available Balance')]/following-sibling::div/span")
	private WebElement txt_available_balance;
	
	@FindBy(xpath="//label[contains(text(),'Holds')]")
	private WebElement lbl_holds;
	@FindBy(xpath="//label[contains(text(),'Holds')]/following-sibling::div/span")
	private WebElement txt_holds;
	
	@FindBy(xpath="//label[contains(text(),'Disbursable Balance')]")
	private WebElement lbl_disbursable_balance;
	@FindBy(xpath="//label[contains(text(),'Disbursable Balance')]/following-sibling::div/span")
	private WebElement txt_disbursable_balance;
	
	@FindBy(xpath="//label[contains(text(),'Balance Due')]")
	private WebElement lbl_balance_due;
	@FindBy(xpath="//label[contains(text(),'Balance Due')]/following-sibling::div/span")
	private WebElement txt_balance_due;
	
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateSummaryTabInCDHPAccountPlan
	 * #Description:This method validated the fields in Summary Tab for a particular 'Consumer Driven Health Plan Account Info'. 
	 * #Arguments:CDHPAccountLevelSummaryTab-KeyValuePair
	 * Type:Table
	 * Keys:#acct_description#acct_type#status#eff#start#end#ld_of_spending#ld_for_submitclaims#fund_rollover_rule#fund_rollover_percentage#fund_rollover_cap#fund_rollover_date#annual_election#contribution_ytd#incentives_deposits#rollover_deposit#available_balance#holds#disbursable_balance#balance_due#member_pay#contribution_ytd
	 */
	public boolean validateSummaryTabInCDHPAccountPlan(String[] args){
		utils.clickAnelemnt(this.lblSummaryTab, "ConsumerDrivenHealthPlan", "Summary Tab");
		utils.waitforpageload();
		boolean returnvar;
		String acct_description = "",acct_type="",status="",eff="",start="",end="",ld_of_spending="",ld_for_submitclaims= "";
		String fund_rollover_rule="",fund_rollover_percentage="",fund_rollover_cap="",fund_rollover_date="";
		String annual_election_contribution_ytd="",incentives_deposits="",rollover_deposit="";
		String available_balance="",holds="",disbursable_balance="",balance_due="",member_pay="";
		returnvar = true;
		if(utils.validateLabel(this.lblSummaryTab, "Summary"))
		{
			String keyvaluepair="";
			for(String iterator : args)
			{
				if(!returnvar)
				{
					err.logcommonMethodError("validateSummaryTabInCDHPAccountPlan", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				 keyvaluepair = iterator;
				
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(key.equalsIgnoreCase("acct_description")){
					acct_description = value.trim();
					try{
						returnvar = this.txt_acct_description.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Account Description' CDHP - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("acct_type")){
					acct_type = value.trim();
					try{
						returnvar = this.txt_acct_type.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Account Type' CDHP - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("status")){
					status = value.trim();
					try{
						returnvar = this.txt_status.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Status'in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("eff")){
					eff = value.trim();
					try{
						returnvar = this.txt_eff.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Effective Date' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("start")){
					start = value.trim();
					try{
						returnvar = this.txt_start.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Plan Start Date' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("end")){
					end = value.trim();
					try{
						returnvar = this.txt_end.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Plan End Date' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("ld_of_spending")){
					ld_of_spending = value.trim();
					try{
						returnvar = this.txt_ld_of_spending.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Last Date of Spending' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("ld_for_submitclaims")){
					ld_for_submitclaims = value.trim();
					try{
						returnvar = this.txt_ld_for_submitclaims.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Last Date To Submit Claims' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("fund_rollover_rule")){
					fund_rollover_rule = value.trim();
					try{
						returnvar = this.txt_fund_rollover_rule.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Fund RollOver Rule' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("fund_rollover_percentage")){
					fund_rollover_percentage = value.trim();
					try{
						returnvar = this.txt_fund_rollover_percentage.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Fund RollOver Percentage' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("fund_rollover_cap")){
					fund_rollover_cap = value.trim();
					try{
						returnvar = this.txt_fund_rollover_cap.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Fund RollOver CAP' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("fund_rollover_date")){
					fund_rollover_date = value.trim();
					try{
						returnvar = this.txt_fund_rollover_date.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Fund RollOver Date' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("annual_election")){
					annual_election_contribution_ytd = value.trim();
					try{
						returnvar = this.txt_annual_election.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Annual Election' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("contribution_ytd")){
					annual_election_contribution_ytd = value.trim();
					try{
						returnvar = this.txt_contribution_ytd.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Contribution YTD' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("incentives_deposits")){
					incentives_deposits = value.trim();
					try{
						returnvar = this.txt_incentives_deposits.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Incentives Deposits' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("rollover_deposit")){
					rollover_deposit = value.trim();
					try{
						returnvar = this.txt_rollover_deposit.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'RollOver Deposit' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("available_balance")){
					available_balance = value.trim();
					try{
						returnvar = this.txt_available_balance.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Available Balance' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("holds")){
					holds = value.trim();
					try{
						returnvar = this.txt_holds.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Holds' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("disbursable_balance")){
					disbursable_balance = value.trim();
					try{
						returnvar = this.txt_disbursable_balance.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Disbursable Balance' in - Summary Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("balance_due")){
					balance_due = value.trim();
					try{
						returnvar = this.txt_balance_due.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Balance Due' in - Summary Tab");
							return false;
						}
					continue;}
				else 
					err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		}else
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab");

		if(returnvar)
		{
			System.out.println("ConsumerDrivenHealthPlan -Summary tab info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}
	
	@FindBy(xpath="//div[text()='Account Information']")
	private WebElement lbl_AccountInformation_section;
	
	@FindBy(xpath="//div[text()='Rollover Information']")
	private WebElement lbl_RolloverInformation_section;
	
	@FindBy(xpath="//div[text()='Contribution Information']")
	private WebElement lbl_ContributionInformation_section;
	
	@FindBy(xpath="//div[text()='Balance Information']")
	private WebElement lbl_BalanceInformation_section;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateSectionsDisplayedInSummaryTabOfCDHPAccount
	 * #Description:This method validated the labels and sections displayed in Summary Tab for a particular 'Consumer Driven Health Plan Account Info'. 
	 * Type:TextBox
	 */
	public boolean validateSectionsDisplayedInSummaryTabOfCDHPAccount(){
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		utils.clickAnelemnt(this.lblSummaryTab, "ConsumerDrivenHealthPlan", "Summary Tab");
			try{
				if(this.lbl_acct_description.isDisplayed()){System.out.println("Account Description is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Account Description label is not displayed");
				System.out.println("Account Description label is not displayed"+e);
				fieldsNotPresent.add("Account Description");
			}	
			
			try{
				if(this.lbl_acct_type.isDisplayed()){System.out.println("Account Type is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Account Type label is not displayed");
				System.out.println("Account Type label is not displayed"+e);
				fieldsNotPresent.add("Account Type");
			}
			
			try{
				if(this.lbl_status.isDisplayed()){System.out.println("Status is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Status label is not displayed");
				System.out.println("Status label is not displayed"+e);
				fieldsNotPresent.add("Status");
			}	

			try{
				if(this.lbl_eff.isDisplayed()){System.out.println("Effective Date is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Effective Date label is not displayed");
				System.out.println("Effective Date label is not displayed"+e);
				fieldsNotPresent.add("Effective Date");
			}
			
			try{
				if(this.lbl_start.isDisplayed()){System.out.println("Plan Start Date is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Plan Start Date label is not displayed");
				System.out.println("Plan Start Date label is not displayed"+e);
				fieldsNotPresent.add("Plan Start Date");
			}
			
			try{
				if(this.lbl_end.isDisplayed()){System.out.println("Plan End Date is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Plan End Date is not displayed");
				System.out.println("Plan End Date is not displayed"+e);
				fieldsNotPresent.add("Plan End Date");
			}					

			try{
				if(this.lbl_ld_of_spending.isDisplayed()){System.out.println("Last date of Spending is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Last date of Spending label is not displayed");
				System.out.println("Last date of Spending label is not displayed"+e);
				fieldsNotPresent.add("Last date of Spending");
			}
			
			try{
				if(this.lbl_ld_for_submitclaims.isDisplayed()){System.out.println("Last Date to Submit Claims is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Last date to Submit Claims label is not displayed");
				System.out.println("Last date to Submit Claims label is not displayed"+e);
				fieldsNotPresent.add("Last date to Submit Claims");
			}
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.lbl_RolloverInformation_section);				
			try{
				if(this.lbl_fund_rollover_rule.isDisplayed()){System.out.println("Fund RollOver Rule is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Fund RollOver Rule- label is not displayed");
				System.out.println("Fund RollOver Rule- label is not displayed"+e);
				fieldsNotPresent.add("Fund RollOver Rule");
			}
			
			try{
				if(this.lbl_fund_rollover_percentage.isDisplayed()){System.out.println("Fund RollOver Percentage is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Fund RollOver Percentage- label is not displayed");
				System.out.println("Fund RollOver Percentage- label is not displayed"+e);
				fieldsNotPresent.add("Fund RollOver Percentage");
			}
			
			try{
				if(this.lbl_fund_rollover_cap.isDisplayed()){System.out.println("Fund RollOver Cap is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Fund RollOver Cap label is not displayed");
				System.out.println("Fund RollOver Cap label is not displayed"+e);
				fieldsNotPresent.add("Fund RollOver Cap");
			}
					
			try{
				if(this.lbl_fund_rollover_date.isDisplayed()){System.out.println("Fund RollOver date is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Fund RollOver date label is not displayed");
				System.out.println("Fund RollOver date label is not displayed"+e);
				fieldsNotPresent.add("Fund RollOver date");
			}
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.lbl_ContributionInformation_section);
			try{
				if(this.lbl_annual_election.isDisplayed()){System.out.println("Annual Election is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Annual Election is not displayed");
				System.out.println("Annual Election is not displayed"+e);
				fieldsNotPresent.add("Annual Election");
			}
			try{
				if(this.lbl_contribution_ytd.isDisplayed()){System.out.println("Contribution YTD is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Contribution YTD is not displayed");
				System.out.println("Contribution YTD is not displayed"+e);
				fieldsNotPresent.add("Contribution YTD");
			}
			try{
				if(this.lbl_contribution_ytd.isDisplayed()){System.out.println("Contribution YTD is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Contribution YTD label is not displayed");
				System.out.println("Contribution YTD label is not displayed"+e);
				fieldsNotPresent.add("Contribution YTD");
			}
			
			try{
				if(this.lbl_incentives_deposits.isDisplayed()){System.out.println("Incentives Deposits is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Incentives Deposits  label is not displayed");
				System.out.println("Incentives Deposits  label is not displayed"+e);
				fieldsNotPresent.add("Incentives Deposits");
			}
				
			try{
				if(this.lbl_rollover_deposit.isDisplayed()){System.out.println("Rollover Deposit is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Rollover Deposit  label is not displayed");
				System.out.println("Rollover Deposit  label is not displayed"+e);
				fieldsNotPresent.add("Rollover Deposit");
			}	
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.lbl_BalanceInformation_section);				
			try{
				if(this.lbl_available_balance.isDisplayed()){System.out.println("Available Balance is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Available Balance label is not displayed");
				System.out.println("Available Balance label is not displayed"+e);
				fieldsNotPresent.add("Available Balance");
			}	
				
			try{
				if(this.lbl_holds.isDisplayed()){System.out.println("Holds is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Holds label is not displayed");
				System.out.println("Holds label is not displayed"+e);
				fieldsNotPresent.add("Holds");
			}
				
			try{
				if(this.lbl_disbursable_balance.isDisplayed()){System.out.println("Disbursable Balance is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Disbursable Balance label is not displayed");
				System.out.println("Disbursable Balance label is not displayed"+e);
				fieldsNotPresent.add("Disbursable Balance");
			}	
			
			try{
				if(this.lbl_balance_due.isDisplayed()){System.out.println("Balance Due is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Summary tab - Balance Due label is not displayed");
				System.out.println("Balance Due label is not displayed"+e);
				fieldsNotPresent.add("Balance Due");
			}
				
			if(fieldsNotPresent.size()>0){
				System.out.println("Fields not present in Summary Tab section:"+fieldsNotPresent);
				return false;
			}
			return true;
	}
	
	@FindBy(xpath="//span[text()='Transaction Summary']")
	private WebElement lbl_transactionSummary;	
	@FindBy(xpath="//table[@pl_prop='D_CDHPTXInfo.pxResults']")
	private WebElement transactionsSummary_Tbl;	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyTransactionTableColHeader
	 * #Description: This method verifies that column headers in Transactions sub-tables are displayed, when user clicks on Transactions tab in CDHP Account Plan.
	 * #Arguments:Transaction table headers -"Service Start Date,Transaction Date,Account,Claimant,Claim # - Claim Line,Type,Description,Status,Transaction Amount".
	 * Type:TextBox
	 */
	public boolean verifyTransactionTableColHeader(String[] args){
	utils.clickAnelemnt(this.lblTransactionTab, "ConsumerDrivenHealthPlan", "Transactions tab");
	String space = " , , , ";
	StringBuilder input = new StringBuilder();
	String colHdrs[] = input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).append(",").append(args[5]).append(",").append(args[6]).append(",").append(args[7]).append(",").append(args[8]).toString().split(",");
		if(utils.validateLabel(this.lblTransactionTab, "Transactions")){
			if(utils.validateTableRowHeader(this.transactionsSummary_Tbl, colHdrs)){
			return true;
			}
			err.logError("ConsumerDrivenHealthPlan", "Column headers do not match in- Transactions Summary sections -  - Transactions tab - CDHP");
			return false;
		}else
			err.logError("ConsumerDrivenHealthPlan", "Transactions Summary section is not displayed in UI - Transactions tab - CDHP");
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateTransactionTableInCDHPAccountPlan
	 * #Description:This method selects the row for matching key-value pair in Transactions Tab for a particular 'Consumer Driven Health Plan Account Info'. 
	 * #Arguments:CDHPAccountLevelTransactions-KeyValuePair
	 * Type:Table
	 * Keys:#Transaction Date#Service Start Date#Account#Claimant#Type#Description#Status#Transaction Amount
	 */
	public boolean validateTransactionTableInCDHPAccountPlan(String[] args){
		utils.clickAnelemnt(this.lblTransactionTab, "ConsumerDrivenHealthPlan", "Transactions tab");
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
		}
		try{
		if(utils.clickontablerowbasedonvalues(this.transactionsSummary_Tbl, args)){
			return true;}
		else{
			err.logError("ConsumerDrivenHealthPlan", "Table row values do not match- Please check key-value pair");
			return false;}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "Exception occured in 'validateTransactionTableInCDHPAccountPlan' method");
			return false;
		}
	}
	@FindBy(xpath="//span[text()='Transaction Details']")
	private WebElement lbl_TransactionDetails;
	@FindBy(xpath="//label[contains(text(),'Plan Year')]")
	private WebElement lbl_PlanYear;
	
	@FindBy(xpath="//label[contains(text(),'Plan Year')]/following-sibling::div/span")
	private WebElement txt_plan_year;

	@FindBy(xpath="//label[contains(text(),'Merchant / Provider Name')]")
	private WebElement lbl_MerchantProviderName;
	@FindBy(xpath="//label[contains(text(),'Merchant / Provider Name')]/following-sibling::div/span")
	private WebElement txt_merchant_name;
	
	@FindBy(xpath="//label[contains(text(),'Account Type')]")
	private WebElement lbl_AccountType;
	@FindBy(xpath="//label[contains(text(),'Account Type')]/following-sibling::div/span")
	private WebElement txt_account_type;
	
	@FindBy(xpath="//label[contains(text(),'Account Posting Date')]")
	private WebElement lbl_AccountPostingDate;
	@FindBy(xpath="//label[contains(text(),'Account Posting Date')]/following-sibling::div/span")
	private WebElement txt_account_postingdate;
	
	@FindBy(xpath="//label[contains(text(),'Balance After the Transaction')]")
	private WebElement lbl_BalAftTransaction;
	@FindBy(xpath="//label[contains(text(),'Balance After the Transaction')]/following-sibling::div/span")
	private WebElement txt_balance;
	
	@FindBy(xpath="//label[contains(text(),'Merchant Category code')]")
	private WebElement lbl_MCC;
	@FindBy(xpath="//label[contains(text(),'Merchant Category code')]/following-sibling::div/span")
	private WebElement txt_MCC;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateLblsInTransactionDetails
	 * #Description:This method validates the Labels/fields present in Transaction Details section. 
	 * Type:TextBox
	 */
	public boolean validateLblsInTransactionDetails(){
		utils.waitforpageload();
	((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.lbl_TransactionDetails);
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		try{
			if(this.lbl_TransactionDetails.isDisplayed()){System.out.println("Transaction Details section Header is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Transaction Details section Header is not displayed");
			System.out.println("Exception occured:Transaction Details section Header is not displayed"+e);
			fieldsNotPresent.add("Transaction Details section Header");
		}
		
		try{
			if(this.lbl_PlanYear.isDisplayed()){System.out.println("Plan Year is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Plan Year label is not displayed");
			System.out.println("Exception occured:Plan Year label is not displayed"+e);
			fieldsNotPresent.add("Plan Year");
		}
		try{
			if(this.lbl_MerchantProviderName.isDisplayed()){System.out.println("Merchant/Provider Name is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Merchant/Provider Name is not displayed");
			System.out.println("Exception occured:Merchant/Provider Name is not displayed"+e);
			fieldsNotPresent.add("Merchant/Provider Name");
		}	
		try{	
			if(this.lbl_AccountType.isDisplayed()){System.out.println("Account Type is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Account Type label is not displayed");
			System.out.println("Exception occured:Account Type label is not displayed"+e);
			fieldsNotPresent.add("Account Type");
		}	
		try{	
			if(this.lbl_AccountPostingDate.isDisplayed()){System.out.println("Account Posting date is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Account Posting date label is not displayed");
			System.out.println("Exception occured:Account Posting date label is not displayed"+e);
			fieldsNotPresent.add("Account Posting Date");
		}
		try{
			if(this.lbl_BalAftTransaction.isDisplayed()){System.out.println("Balance After the Transaction is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Balance After the Transaction label is not displayed");
			System.out.println("Exception occured:Balance After the Transaction label is not displayed"+e);
			fieldsNotPresent.add("Balance After Transaction");
		}
		try{
			if(this.lbl_MCC.isDisplayed()){System.out.println("MCC is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - MCC label is not displayed");
			System.out.println("Exception occured:MCC label is not displayed"+e);
			fieldsNotPresent.add("MCC");
		}
		
		if(fieldsNotPresent.size()>0){
			System.out.println("Fields not present in Transaction Details section"+fieldsNotPresent);
			return false;
		}
		return true;
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateTransactionDetails
	 * #Description:This method validates the fields present in Transaction Details section. 
	 * #Arguments:TransactionDetails-KeyValuePair
	 * Type:Table
	 * Keys:#plan_year#merchant_name#account_type#account_postingdate#balance#mcc
	 */
	public boolean validateTransactionDetails(String[] args){
	boolean returnvar;
	returnvar = true;
	String plan_year="",merchant_name="",hsa_type="",hsa_postingdate="",balance="",mcc="";
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateTransactionDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			 keyvaluepair = iterator;
			
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("plan_year")){
				plan_year = value.trim();
				try{
				returnvar = this.txt_plan_year.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Plan Year' CDHP - Transaction Details section");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("merchant_name")){
				merchant_name = value.trim();
				try{
					returnvar = this.txt_merchant_name.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Merchant/Provider Name' CDHP - Transaction Details section");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("account_type")){
				hsa_type = value.trim();
				try{
					returnvar = this.txt_account_type.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Account Type' CDHP - Transaction Details section");
						return false;
					}	
				continue;}
			else if(key.toLowerCase().contains("account_postingdate")){
				hsa_postingdate = value.trim();
				try{
					returnvar = this.txt_account_postingdate.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Account Posting Date' CDHP - Transaction Details section");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("balance")){
				balance = value.trim();
				try{
					returnvar = this.txt_balance.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Balance After Transaction' CDHP - Transaction Details section");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("mcc")){
				mcc = value.trim();
				try{
					returnvar = this.txt_MCC.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'MCC' CDHP - Transaction Details section");
						return false;
					}
				continue;}
			else 
				err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

	if(returnvar)
	{
		System.out.println("ConsumerDrivenHealthPlan -TransactionDetails tab info checked Successfully");
		return true;	
	}
	else
	{
		int tot_i=args.length;
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
		return false;
	}

}

	@FindBy(xpath="//span[@id][contains(text(),'Adjudication Details')]")
	private WebElement hdrAdjudicationDetails;
	
	@FindBy(xpath="//span[@id][contains(text(),'Claim Comments')]")
	private WebElement hdrClaimComments;
	
	@FindBy(xpath="//span[@id][contains(text(),'Reimbursement Details')]")
	private WebElement hdrReimbursementDetails;
	
	@FindBy(xpath="//span[@id][contains(text(),'Provider Payment Details')]")
	private WebElement	hdrProviderPaymentDetails;
	
	@FindBy(xpath="//span[@id][contains(text(),'Claim Line Details')]")
	private WebElement hdrClaimLineDetails;
	
	@FindBy(xpath="//label[contains(text(),'Service Dates')]")
	private WebElement lbl_service_dates;
	@FindBy(xpath="//label[contains(text(),'Service Dates')]/following-sibling::div/span")
	private WebElement txt_service_dates;
	
	@FindBy(xpath="//label[contains(text(),'Service Type')]")
	private WebElement lbl_service_type;
	@FindBy(xpath="//label[contains(text(),'Service Type')]/following-sibling::div/span")
	private WebElement txt_service_type;
	
	@FindBy(xpath="//label[contains(text(),'Service Detail Desc')]")
	private WebElement lbl_service_details_desc;
	@FindBy(xpath="//label[contains(text(),'Service Detail Desc')]/following-sibling::div/span")
	private WebElement txt_service_details_desc;
	
	@FindBy(xpath="//label[contains(text(),'Approved')]")
	private WebElement lbl_Approved;
	@FindBy(xpath="//label[contains(text(),'Approved')]/following-sibling::div/span")
	private WebElement txt_Approved;
	
	@FindBy(xpath="//label[text()='Pended']")
	private WebElement lbl_pended;
	@FindBy(xpath="//label[text()='Pended']/following-sibling::div/span")
	private WebElement txt_pended;
	
	@FindBy(xpath="//label[text()='Denied']")
	private WebElement lbl_denied;
	@FindBy(xpath="//label[text()='Denied']/following-sibling::div/span")
	private WebElement txt_denied;
	
	@FindBy(xpath="//label[text()='Excluded']")
	private WebElement lbl_excluded;
	@FindBy(xpath="//label[text()='Excluded']/following-sibling::div/span")
	private WebElement txt_excluded;
	
	@FindBy(xpath="//label[text()='Applied to Account Deductible']")
	private WebElement lbl_applied_to_account_Deductible;
	@FindBy(xpath="//label[text()='Applied to Account Deductible']/following-sibling::div/span")
	private WebElement txt_applied_to_account_Deductible;
	
	@FindBy(xpath="//label[text()='Offset']")
	private WebElement lbl_offset;
	@FindBy(xpath="//label[text()='Offset']/following-sibling::div/span")
	private WebElement txt_offset;
	
	@FindBy(xpath="//label[text()='Low Funds']")
	private WebElement lbl_low_funds;
	@FindBy(xpath="//label[text()='Low Funds']/following-sibling::div/span")
	private WebElement txt_low_funds;
	
	@FindBy(xpath="//label[text()='Total Amount']")
	private WebElement lbl_total_amount;
	@FindBy(xpath="//label[text()='Total Amount']/following-sibling::div/span")
	private WebElement txt_total_amount;
	
	@FindBy(xpath="//label[text()='Eligible']")
	private WebElement lbl_eligible;
	@FindBy(xpath="//label[text()='Eligible']/following-sibling::div/span")
	private WebElement txt_eligible;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateLblsInAdjudicationDetails
	 * #Description:This method validates the Labels/fields present in Adjudication Details section. 
	 * Type:TextBox
	 */
	
	@FindBy(xpath="//span[contains(text(),'Adjudication Details')]")
	private WebElement tablehdrAdjudicationDetails;
	
	
	public boolean validateLblsInAdjudicationDetails(){
		utils.clickAnelemnt(this.tablehdrAdjudicationDetails, "ConsumerDrivenHealthPlan", "Adjudication Details");
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		try{
			if(this.lbl_service_dates.isDisplayed()){System.out.println("Service Dates is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Service Dates label is not displayed");
			System.out.println("Exception occured:Service Dates label is not displayed"+e);
			fieldsNotPresent.add("Service Dates");
		}
		try{
			if(this.lbl_service_type.isDisplayed()){System.out.println("Service Type is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Service Type label is not displayed");
			System.out.println("Exception occured:Service Type label is not displayed"+e);
			fieldsNotPresent.add("Service Type");
		}
		try{
			if(this.lbl_service_details_desc.isDisplayed()){System.out.println("Service Detail Desc is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Service Detail Desc label is not displayed");
			System.out.println("Exception occured:Service Detail Desc label is not displayed"+e);
			fieldsNotPresent.add("Service Detail Desc");
		}
		try{
			if(this.lbl_pended.isDisplayed()){System.out.println("Pended is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Pended label is not displayed");
			System.out.println("Exception occured:Pended label is not displayed"+e);
			fieldsNotPresent.add("Pended");
		}
		try{
			if(this.lbl_denied.isDisplayed()){System.out.println("Denied is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Denied label is not displayed");
			System.out.println("Exception occured:Denied label is not displayed"+e);
			fieldsNotPresent.add("Denied");
		}
		try{
			if(this.lbl_excluded.isDisplayed()){System.out.println("Excluded is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Excluded label is not displayed");
			System.out.println("Exception occured:Excluded label is not displayed"+e);
			fieldsNotPresent.add("Excluded");
		}
		
		try{
			if(this.lbl_applied_to_account_Deductible.isDisplayed()){System.out.println("Applied to Account Deductible is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Applied to Account Deductible label is not displayed");
			System.out.println("Exception occured:Applied to Account Deductible label is not displayed"+e);
			fieldsNotPresent.add("Applied to Account Deductible");
		}
		
		try{
			if(this.lbl_offset.isDisplayed()){System.out.println("Offset is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Offset label is not displayed");
			System.out.println("Exception occured:Offset label is not displayed"+e);
			fieldsNotPresent.add("Offset");
		}
		
		try{
			if(this.lbl_low_funds.isDisplayed()){System.out.println("Low Funds is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Low Funds label is not displayed");
			System.out.println("Exception occured:Low Funds label is not displayed"+e);
			fieldsNotPresent.add("Low Funds");
		}
		
		try{
			if(this.lbl_total_amount.isDisplayed()){System.out.println("Total Amount is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Total Amount label is not displayed");
			System.out.println("Exception occured:Total Amount label is not displayed"+e);
			fieldsNotPresent.add("Total Amount");
		}
		
		try{
			if(this.lbl_eligible.isDisplayed()){System.out.println("Eligible is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Eligible label is not displayed");
			System.out.println("Exception occured:Eligible label is not displayed"+e);
			fieldsNotPresent.add("Eligible");
		}
		
		try{
			if(this.lbl_Approved.isDisplayed()){System.out.println("Approved is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Adjudication Details section -Approved label is not displayed");
			System.out.println("Exception occured:Approved label is not displayed"+e);
			fieldsNotPresent.add("Approved");
		}
		
		if(fieldsNotPresent.size()>0){
			System.out.println("Fields not present in AdjudicationDetails section"+fieldsNotPresent);
			return false;
		}
		return true;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateAdjudicationDetails
	 * #Description:This method validates the fields present in Adjudication Details section -in Transaction Tab. 
	 * #Arguments:AdjudicationDetails-KeyValuePair
	 * Type:Table
	 * Keys:#service_dates#service_type#service_details_description#total_amount#pended#denied#excluded#eligible#applied_to_account_Deductible#offset#low_funds#approved
	 */
	public boolean validateAdjudicationDetails(String[] args){
		utils.clickAnelemnt(this.hdrAdjudicationDetails, "ConsumerDrivenHealthPlan", "Adjudication Details");
		boolean returnvar;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateAdjudicationDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			 keyvaluepair = iterator;
			
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("service_dates")){
				try{
				returnvar = this.txt_service_dates.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Service Dates' Adjudication Details section -in Transaction Tab");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("service_type")){
				try{
					returnvar = this.txt_service_type.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Service Type' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("service_details_description")){
				try{
					returnvar = this.txt_service_details_desc.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Service Details Description' Adjudication Details section -in Transaction Tab");
						return false;
					}	
				continue;}
			else if(key.toLowerCase().contains("total_amount")){
				try{
					returnvar = this.txt_total_amount.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Total Amount' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("pended")){
				try{
					returnvar = this.txt_pended.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Pended' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("denied")){
				try{
					returnvar = this.txt_denied.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Denied' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("excluded")){
				try{
					returnvar = this.txt_excluded.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Excluded' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("eligible")){
				try{
					returnvar = this.txt_eligible.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Eligible' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("applied_to_account_deductible")){
				try{
					returnvar = this.txt_applied_to_account_Deductible.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Applied to account Deductible' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("offset")){
				try{
					returnvar = this.txt_offset.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Offset' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("low_funds")){
				try{
					returnvar = this.txt_low_funds.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Low Funds' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("approved")){
				try{
					returnvar = this.txt_Approved.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Approved' Adjudication Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else 
				err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

	if(returnvar)
	{
		System.out.println("ConsumerDrivenHealthPlan -Adjudication Details tab info checked Successfully");
		return true;	
	}
	else
	{
		int tot_i=args.length;
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
		return false;
	}
}

	@FindBy(xpath="//label[text()='Denial Reason']")
	private WebElement lbl_denial_reason;
	@FindBy(xpath="//label[text()='Denial Reason']/following-sibling::div/span")
	private WebElement txt_denial_reason;
	
	@FindBy(xpath="//label[text()='Denied Comment']")
	private WebElement lbl_denial_comment;
	@FindBy(xpath="//label[text()='Denied Comment']/following-sibling::div/span")
	private WebElement txt_denial_comment;
	
	@FindBy(xpath="//label[text()='Pended Reason']")
	private WebElement lbl_pended_reason;
	@FindBy(xpath="//label[text()='Pended Reason']/following-sibling::div/span")
	private WebElement txt_pended_reason;
	
	@FindBy(xpath="//label[text()='Pended Comment']")
	private WebElement lbl_pended_comment;
	@FindBy(xpath="//label[text()='Pended Comment']/following-sibling::div/span")
	private WebElement txt_pended_comment;
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateLblsInClaimComments
	 * #Description:This method validates the Labels/fields present in Claim Comments section. 
	 * Type:TextBox
	 */
	
	@FindBy(xpath="//span[contains(text(),'Claim Comments')]")
	private WebElement tablehdrClaimComments;
	
	public boolean validateLblsInClaimComments(){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.tablehdrClaimComments);
		utils.clickAnelemnt(this.tablehdrClaimComments, "ConsumerDrivenHealthPlan", "Claim Comments");
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		try{
			if(this.lbl_denial_reason.isDisplayed()){System.out.println("Denial Reason is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Claim Comments section -Denial Reason label is not displayed");
			System.out.println("Exception occured:Denial Reason label is not displayed"+e);
			fieldsNotPresent.add("Denial Reason");
		}
		try{
			if(this.lbl_denial_comment.isDisplayed()){System.out.println("Denied Comment is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Claim Comments section -Denied Comment label is not displayed");
			System.out.println("Exception occured:Denied Comment label is not displayed"+e);
			fieldsNotPresent.add("Denied Comment");
		}
		try{
			if(this.lbl_pended_reason.isDisplayed()){System.out.println("Pended Reason is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Claim Comments section -Pended Reason label is not displayed");
			System.out.println("Exception occured:Pended Reason label is not displayed"+e);
			fieldsNotPresent.add("Pended Reason");
		}
		try{
			if(this.lbl_pended_comment.isDisplayed()){System.out.println("Pended Comment is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Claim Comments section -Pended Comment label is not displayed");
			System.out.println("Exception occured:Pended Comment label is not displayed"+e);
			fieldsNotPresent.add("Pended Comment");
		}
		
		if(fieldsNotPresent.size()>0){
			System.out.println("Fields not present in Claim Comments section"+fieldsNotPresent);
			return false;
		}
		return true;
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimComments
	 * #Description:This method validates the fields present in Claim Comments section -in Transaction Tab.
	 * #Arguments:ClaimComments-KeyValuePair
	 * Type:Table
	 * Keys:#denial_reason#denial_comment#pended_reason#pended_comment

	 */
	public boolean validateClaimComments(String[] args){
		utils.clickAnelemnt(this.hdrClaimComments, "ConsumerDrivenHealthPlan", "Claim Comments");
		boolean returnvar;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateClaimComments", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			 keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("denial_reason")){
				try{
				returnvar = this.txt_denial_reason.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Denial Reason' Claim Comments section -in Transaction Tab");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("denial_comment")){
				try{
					returnvar = this.txt_denial_comment.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Denial Comment' Claim Comments section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("pended_reason")){
				try{
					returnvar = this.txt_pended_reason.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Pended Reason' Claim Comments section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("pended_comment")){
				try{
					returnvar = this.txt_pended_comment.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Pended Comment' Claim Comments section -in Transaction Tab");
						return false;
					}
				continue;}
				else 
				err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input - validateClaimComments");
			return false;
		}
	if(returnvar)
	{
		System.out.println("ConsumerDrivenHealthPlan - validated ClaimComments tab info checked Successfully");
		return true;	
	}
	else
	{
		int tot_i=args.length;
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
		return false;
	}
	}
	
	@FindBy(xpath="//label[text()='Reimbursement Date']")
	private WebElement lbl_reimb_date;
	@FindBy(xpath="//label[text()='Reimbursement Date']/following-sibling::div/span")
	private WebElement txt_reimb_date;
	
	@FindBy(xpath="//label[text()='Reimbursement Method']")
	private WebElement lbl_reimb_method;
	@FindBy(xpath="//label[text()='Reimbursement Method']/following-sibling::div/span")
	private WebElement txt_reimb_method;
	
	@FindBy(xpath="//label[text()='Amount Reimbursed']")
	private WebElement lbl_amount_reimb;
	@FindBy(xpath="//label[text()='Amount Reimbursed']/following-sibling::div/span")
	private WebElement txt_amount_reimb;
	
	@FindBy(xpath="//label[text()='Reissued Check']")
	private WebElement lbl_reissued_check;
	@FindBy(xpath="//label[text()='Reissued Check']/following-sibling::div/span")
	private WebElement txt_reissued_check;
	
	@FindBy(xpath="//label[text()='Check / Trace Number']")
	private WebElement lbl_check_trace_no;
	@FindBy(xpath="//label[text()='Check / Trace Number']/following-sibling::div/span")
	private WebElement txt_check_trace_no;
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateLblsInReimbursementDetails
	 * #Description:This method validates the Labels/fields present in Reimbursement Details section. 
	 * Type:TextBox
	 */
	
	@FindBy(xpath="//span[contains(text(),'Reimbursement Details')]")
	private WebElement tableReimbursementDetails;
	
	public boolean validateLblsInReimbursementDetails(){
		//((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.hdrReimbursementDetails);
		utils.clickAnelemnt(this.tableReimbursementDetails, "ConsumerDrivenHealthPlan", "Reimbursement Details");
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		try{
			if(this.lbl_reimb_date.isDisplayed()){System.out.println("Reimbursement Date is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Reimbursement Details section -Reimbursement Date label is not displayed");
			System.out.println("Exception occured:Reimbursement Date label is not displayed"+e);
			fieldsNotPresent.add("Reimbursement Date");
		}
		try{
			if(this.lbl_reimb_method.isDisplayed()){System.out.println("Reimbursement Method is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Reimbursement Details section -Reimbursement Method label is not displayed");
			System.out.println("Exception occured:Reimbursement Method label is not displayed"+e);
			fieldsNotPresent.add("Reimbursement Method");
		}
		try{
			if(this.lbl_amount_reimb.isDisplayed()){System.out.println("Amount Reimbursed is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Reimbursement Details section -Amount Reimbursed label is not displayed");
			System.out.println("Exception occured: Amount Reimbursed label is not displayed"+e);
			fieldsNotPresent.add("Amount Reimbursed");
		}
		
		try{
			if(this.lbl_reissued_check.isDisplayed()){System.out.println("Reissued Check is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Reimbursement Details section -Reissued Check label is not displayed");
			System.out.println("Exception occured:Reissued Check label is not displayed"+e);
			fieldsNotPresent.add("Reissued Check");
		}
		
		try{
			if(this.lbl_check_trace_no.isDisplayed()){System.out.println("Check / Trace Number is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Reimbursement Details section -Check / Trace Number label is not displayed");
			System.out.println("Exception occured:Check / Trace Number label is not displayed"+e);
			fieldsNotPresent.add("Check / Trace Number");
		}
		
		if(fieldsNotPresent.size()>0){
			System.out.println("Fields not present in Reimbursement Details section"+fieldsNotPresent);
			return false;
		}
		return true;
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateReimbursementDetails
	 * #Description:This method validates the fields present in Reimbursement Details section -in Transaction Tab.
	 * #Arguments:ReimbursementDetails-KeyValuePair
	 * Type:Table
	 * Keys:#reimb_date#reimb_method#amount_reimb#reissued_check#check_trace_no
	 */
	public boolean validateReimbursementDetails(String[] args){
		utils.clickAnelemnt(this.hdrReimbursementDetails, "ConsumerDrivenHealthPlan", "Reimbursement Details");
		boolean returnvar;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateReimbursementDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			 keyvaluepair = iterator;
			
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("reimb_date")){
				try{
				returnvar = this.txt_reimb_date.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Reimbursement Date' Reimbursement Details section -in Transaction Tab");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("reimb_method")){
				try{
					returnvar = this.txt_reimb_method.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Reimbursement Method' Reimbursement Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("amount_reimb")){
				try{
					returnvar = this.txt_amount_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Amount Reimbursed' Reimbursement Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("reissued_check")){
				try{
					returnvar = this.txt_reissued_check.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Reissued Check' Reimbursement Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("check_trace_no")){
				try{
					returnvar = this.txt_check_trace_no.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Check / Trace Number' Reimbursement Details section -in Transaction Tab");
						return false;
					}
				continue;}	
				else 
				err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input - Reimbursement Details");
			return false;
		}

	if(returnvar)
	{
		System.out.println("ConsumerDrivenHealthPlan - validated Reimbursement Details tab info checked Successfully");
		return true;	
	}
	else
	{
		int tot_i=args.length;
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
		return false;
	}
		
	}
	
	@FindBy(xpath="//label[text()='Provider Name']")
	private WebElement lbl_provider_name;
	@FindBy(xpath="//label[text()='Provider Name']/following-sibling::div/span")
	private WebElement txt_provider_name;
	
	@FindBy(xpath="//label[text()='Address 1']")
	private WebElement lbl_address1;
	@FindBy(xpath="//label[text()='Address 1']/following-sibling::div/span")
	private WebElement txt_address1;
	
	@FindBy(xpath="//label[text()='Address 2']")
	private WebElement lbl_address2;
	@FindBy(xpath="//label[text()='Address 2']/following-sibling::div/span")
	private WebElement txt_address2;
	
	@FindBy(xpath="//label[text()='City']")
	private WebElement lbl_city;
	@FindBy(xpath="//label[text()='City']/following-sibling::div/span")
	private WebElement txt_city;
	
	@FindBy(xpath="//label[text()='State']")
	private WebElement lbl_state;
	@FindBy(xpath="//label[text()='State']/following-sibling::div/span")
	private WebElement txt_state;
	
	@FindBy(xpath="//label[text()='Zipcode']")
	private WebElement lbl_zipcode;
	@FindBy(xpath="//label[text()='Zipcode']/following-sibling::div/span")
	private WebElement txt_zipcode;
	

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateLblsInProviderPaymentDetails
	 * #Description:This method validates the Labels/fields present in Provider Payment Details section. 
	 * Type:TextBox
	 */
	
	@FindBy(xpath="//span[text()='Provider Payment Details']")
	private WebElement	tableProviderPaymentDetails;
	
	public boolean validateLblsInProviderPaymentDetails(){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.tableProviderPaymentDetails);
		utils.clickAnelemnt(this.tableProviderPaymentDetails, "ConsumerDrivenHealthPlan", "Provider Payment Details");
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		try{
			if(this.lbl_provider_name.isDisplayed()){System.out.println("Provider Name is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Provider Payment Details section -Provider Name label is not displayed");
			System.out.println("Exception occured:Provider Name label is not displayed"+e);
			fieldsNotPresent.add("Provider Name");
		}
		try{
			if(this.lbl_address1.isDisplayed()){System.out.println("Address 1 is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Provider Payment Details section -Address 1 label is not displayed");
			System.out.println("Exception occured:Address 1 label is not displayed"+e);
			fieldsNotPresent.add("Address 1");
		}
		try{
			if(this.lbl_address2.isDisplayed()){System.out.println("Address 2 is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Provider Payment Details section -Address 2 label is not displayed");
			System.out.println("Exception occured:Address 2 label is not displayed"+e);
			fieldsNotPresent.add("Address 2");
		}	
		try{
			if(this.lbl_city.isDisplayed()){System.out.println("City is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Provider Payment Details section -City label is not displayed");
			System.out.println("Exception occured:City label is not displayed"+e);
			fieldsNotPresent.add("City");
		}
		try{
			if(this.lbl_state.isDisplayed()){System.out.println("State is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Provider Payment Details section -State label is not displayed");
			System.out.println("Exception occured:State label is not displayed"+e);
			fieldsNotPresent.add("State");
		}
		try{
			if(this.lbl_zipcode.isDisplayed()){System.out.println("Zipcode is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Provider Payment Details section -Zipcode label is not displayed");
			System.out.println("Exception occured:Zipcode label is not displayed"+e);
			fieldsNotPresent.add("Zipcode");
		}	
		if(fieldsNotPresent.size()>0){
			System.out.println("Fields not present in Provider Payment Details section"+fieldsNotPresent);
			return false;
		}
		return true;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateProviderPaymentDetails
	 * #Description:This method validates the fields present in Provider Payment Details section -in Transaction Tab.
	 * #Arguments:ProviderPaymentDetails-KeyValuePair
	 * Type:Table
	 * Keys:#provider_name#address1#address2#city#state#zipcode
	 */
	public boolean validateProviderPaymentDetails(String[] args){
		//utils.clickAnelemnt(this.hdrProviderPaymentDetails, "ConsumerDrivenHealthPlan", "Provider Details");
		boolean returnvar;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateProviderPaymentDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("provider_name")){
				try{
				returnvar = this.txt_provider_name.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Provider Name' Provider Payment Details section -in Transaction Tab");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("address1")){
				try{
					returnvar = this.txt_address1.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Address1' Provider Payment Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("address2")){
				try{
					returnvar = this.txt_address2.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Address2' Provider Payment Details section -in Transaction Tab");
						return false;
					}	
				continue;}
			else if(key.toLowerCase().contains("city")){
				try{
					returnvar = this.txt_city.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'City' Provider Payment Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("state")){
				try{
					returnvar = this.txt_state.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'State' Provider Payment Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("zipcode")){
				try{
					returnvar = this.txt_zipcode.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Zipcode' Provider Payment Details section -in Transaction Tab");
						return false;
					}
				continue;}	
				else 
				err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

	if(returnvar)
	{
		System.out.println("ConsumerDrivenHealthPlan - Provider Payment Details tab info checked Successfully");
		return true;	
	}
	else
	{
		int tot_i=args.length;
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
		return false;
	}
		
	}

	@FindBy(xpath="//span[text()='Billed Amount']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_billed_amt_request;
	
	@FindBy(xpath="//span[text()='Billed Amount']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_billed_amt_reimb;
	
	@FindBy(xpath="//span[text()='Allowed Amount']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_allowed_amt_request;
	
	@FindBy(xpath="//span[text()='Allowed Amount']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_allowed_amt_reimb;
	
	@FindBy(xpath="//span[text()='Insurance Paid Amount']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_ins_paid_amt_request;
	
	@FindBy(xpath="//span[text()='Insurance Paid Amount']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_ins_paid_amt_reimb;
	
	@FindBy(xpath="//span[text()='Deductible']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_deduct_amt_request;
	
	@FindBy(xpath="//span[text()='Deductible']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_deduct_amt_reimb;
	
	@FindBy(xpath="//span[text()='Coinsurance']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_coIns_amt_request;
	
	@FindBy(xpath="//span[text()='Coinsurance']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_coIns_amt_reimb;
	
	@FindBy(xpath="//span[text()='CoPay']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_copay_amt_request;
	
	@FindBy(xpath="//span[text()='CoPay']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_copay_amt_reimb;
	
	@FindBy(xpath="//span[text()='Benefit Max Met']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_bene_met_maxrequest;
	
	@FindBy(xpath="//span[text()='Benefit Max Met']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_bene_met_maxreimb;
	
	@FindBy(xpath="//span[text()='Referenced Based Benefit Excess']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_rbb_excess_request;
	
	@FindBy(xpath="//span[text()='Referenced Based Benefit Excess']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement rbb_excess_reimb;
	
	@FindBy(xpath="//span[text()='Above Reasonable and Customary ']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_above_RC_request;
	
	@FindBy(xpath="//span[text()='Above Reasonable and Customary ']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_above_RC_reimb;
	
	@FindBy(xpath="//span[text()='Not Covered']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Requested']//span")
	private WebElement txt_notcovered_amt_request;
	
	@FindBy(xpath="//span[text()='Not Covered']//ancestor::td[@data-attribute-name='Amount']//following-sibling::td[@data-attribute-name='Reimbursed']//span")
	private WebElement txt_notcovered_amt_reimb;
	
	@FindBy(xpath="//table[@pl_prop='.ClaimLineDetails']")
	private WebElement claimLineDetailsTbl;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateLblsInClaimLineDetails
	 * #Description:This method validates the Labels/fields present in Claim Line Details section.
	 * Type:TextBox
	 */
	public boolean validateLblsInClaimLineDetails(){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.hdrClaimLineDetails);
		String args[]= {"Billed Amount","Allowed Amount","Insurance Paid Amount","Deductible","Coinsurance","CoPay","Benefit Max Met","Referenced Based Benefit Excess","Above Reasonable and Customary","Not Covered"};
		if(utils.clickAnelemnt(this.hdrClaimLineDetails, "ConsumerDrivenHealthPlan", "Claim Line Details"))
			if(validateRowValuesInClaimTable(this.claimLineDetailsTbl, args))
			return true;
		else
			System.out.println("Labels mismatch In Claim Line Details section >> CDHP-Transaction tab");
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimLineDetails
	 * #Description:This method validates the fields present in Claim Line Details section -in Transaction Tab.
	 * #Arguments:ClaimLineDetails-KeyValuePair
	 * Type:Table
	 * Keys:#billed_amt_request#billed_amt_reimb#allowed_amt_request#allowed_amt_reimb#ins_paid_amt_request#ins_paid_amt_reimb#deduct_amt_request#deduct_amt_reimb#coIns_amt_request#coIns_amt_reimb#copay_amt_request#copay_amt_reimb#bene_met_maxrequest#bene_met_maxreimb#rbb_excess_request#rbb_excess_reimb#above_RC_request#above_RC_reimb#notcovered_amt_request#notcovered_amt_reimb
	 */
	public boolean validateClaimLineDetails(String[] args){
		utils.clickAnelemnt(this.hdrClaimLineDetails, "ConsumerDrivenHealthPlan", "Claim Line Details");
		boolean returnvar;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateClaimLineDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			 keyvaluepair = iterator;
			
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("billed_amt_request")){
				try{
				returnvar = this.txt_billed_amt_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Billed Amount Requested' Claim Line Details section -in Transaction Tab");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("billed_amt_reimb")){
				try{
				returnvar = this.txt_billed_amt_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Billed Amount Reimbursed' Claim Line Details section -in Transaction Tab");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("allowed_amt_request")){
				try{
					returnvar = this.txt_allowed_amt_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Allowed Amount Requested' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("allowed_amt_reimb")){
				try{
					returnvar = this.txt_allowed_amt_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Allowed Amount Reimbursed' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("ins_paid_amt_request")){
				try{
					returnvar = this.txt_ins_paid_amt_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Insurance Paid Amount Requested' Claim Line Details section -in Transaction Tab");
						return false;
					}	
				continue;}
			else if(key.toLowerCase().contains("ins_paid_amt_reimb")){
				try{
					returnvar = this.txt_ins_paid_amt_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Insurance Paid Amount Reimbursed' Claim Line Details section -in Transaction Tab");
						return false;
					}	
				continue;}
			else if(key.toLowerCase().contains("deduct_amt_request")){
				try{
					returnvar = this.txt_deduct_amt_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Deductible Amount Requested' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("deduct_amt_reimb")){
				try{
					returnvar = this.txt_deduct_amt_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Deductible Amount Reimbursed' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("coins_amt_request")){
				try{
					returnvar = this.txt_coIns_amt_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'CoInsurance Amount Requested' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("coins_amt_reimb")){
				try{
					returnvar = this.txt_coIns_amt_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'CoInsurance Amount Reimbursed' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("copay_amt_request")){
				try{
					returnvar = this.txt_copay_amt_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Copay Amount Requested' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("copay_amt_reimb")){
				try{
					returnvar = this.txt_copay_amt_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Copay Amount Reimbursed' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("bene_met_maxrequest")){
				try{
					returnvar = this.txt_bene_met_maxrequest.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Benefits Met Max Requested' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
			else if(key.toLowerCase().contains("bene_met_maxreimb")){
				try{
					returnvar = this.txt_bene_met_maxreimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Benefits Met Max Reimbursed' Claim Line Details section -in Transaction Tab");
						return false;
					}
				continue;}
				else if(key.toLowerCase().contains("rbb_excess_request")){
					try{
						returnvar = this.txt_rbb_excess_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'RBB Excess Requested' Claim Line Details section -in Transaction Tab");
							return false;
						}
					continue;}
				else if(key.toLowerCase().contains("rbb_excess_reimb")){
					try{
						returnvar = this.rbb_excess_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'RBB Excess Reimbursed' Claim Line Details section -in Transaction Tab");
							return false;
						}
					continue;}
				else if(key.toLowerCase().contains("above_rc_request")){
					try{
						returnvar = this.txt_above_RC_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Above R & C Requested' Claim Line Details section -in Transaction Tab");
							return false;
						}
					continue;}
				else if(key.toLowerCase().contains("above_rc_reimb")){
					try{
						returnvar = this.txt_above_RC_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Above R & C Reimbursed' Claim Line Details section -in Transaction Tab");
							return false;
						}
					continue;}
				else if(key.toLowerCase().contains("notcovered_amt_request")){
					try{
						returnvar = this.txt_notcovered_amt_request.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Not Covered Amount Requested' Claim Line Details section -in Transaction Tab");
							return false;
						}
					continue;}
				else if(key.toLowerCase().contains("notcovered_amt_reimb")){
					try{
						returnvar = this.txt_notcovered_amt_reimb.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Not Covered Amount Reimbursed' Claim Line Details section -in Transaction Tab");
							return false;
						}
					continue;}
				else 
				err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

	if(returnvar)
	{
		System.out.println("ConsumerDrivenHealthPlan -Claim Line Details tab info checked Successfully");
		return true;	
	}
	else
	{
		int tot_i=args.length;
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
		return false;
	}

}
	
	@FindBy(xpath="Custodian Bank")
	private WebElement lblCustodianBank;
	
	@FindBy(xpath="//label[@for='ExternalAcctID'][text()='HSA Account Number']/following-sibling::div/span")
	private WebElement txt_hsaAcctNo;
	
	@FindBy(xpath="//label[@for='BankName'][text()='HSA Bank Name']/following-sibling::div/span")
	private WebElement txt_hsaBankName;
	
	@FindBy(xpath="//label[text()='Total Contributions YTD']/following-sibling::div/span")
	private WebElement txt_tot_cont_ytd;
	
	@FindBy(xpath="//label[text()='Employer Contributions YTD']/following-sibling::div/span")
	private WebElement txt_empl_cont_ytd;
	
	@FindBy(xpath="//label[text()='Total Contributed Current Year']/following-sibling::div/span")
	private WebElement txt_Total_Contributed_Current_Year;
	
	@FindBy(xpath="//label[text()='Reportable HSA Contributions']/following-sibling::div/span")
	private WebElement txt_Reportable_HSA_Contributions;
	
	@FindBy(xpath="//label[text()='Employee Contributions Prior Year']/following-sibling::div/span")
	private WebElement txt_Employee_Contributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Employer Contributions Prior Year']/following-sibling::div/span")
	private WebElement txt_Employer_Contributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Total Contributions Prior Year']/following-sibling::div/span")
	private WebElement txt_Total_Contributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Reportable HSA Contributions Prior Year']/following-sibling::div/span")
	private WebElement txt_Reportable_HS_Contributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Distributions Current Year']/following-sibling::div/span")
	private WebElement txt_Distributions_Current_Year;
	
	@FindBy(xpath="//label[text()='Distributions Prior Year']/following-sibling::div/span")
	private WebElement txt_Distributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Investment Balance']/following-sibling::div/span")
	private WebElement txt_InvestmentBalance;
	
	@FindBy(xpath="//label[text()='Threshold to Invest']/following-sibling::div/span")
	private WebElement txt_ThresholdtoInvest;
	
	@FindBy(xpath="//label[text()='Amount Available to Invest']/following-sibling::div/span")
	private WebElement txt_Amount_Available_to_Invest;
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCustodianBank
	 * #Description:This method validates the fields present in Custodian Bank section. 
	 * #Arguments:CustodianBank-KeyValuePair
	 * Type:Table
	 * Keys:#hsaAcctNo#hsaBankName#tot_cont_ytd#empl_cont_ytd#total_Contributed_Current_yr#reportable_HSA_Contributions#employee_Contributions_Prior_yr#employer_Contributions_Prior_yr#total_Contributions_Prior_yr#reportable_HS_Contributions_Prior_yr#distributions_Current_yr#distributions_Prior_yr#investmentBalance#thresholdtoInvest#amount_Available_to_Invest
	 */
	public boolean validateCustodianBank(String[] args){
	utils.clickAnelemnt(this.lblCustodianBankTab, "ConsumerDrivenHealthPlan", "Custodian Bank");
	utils.waitforpageload();
	boolean returnvar;
	returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateCustodianBank", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			 keyvaluepair = iterator;
			
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.equalsIgnoreCase("hsaAcctNo")){
				try{
				returnvar = this.txt_hsaAcctNo.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'HSA Account Number' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("hsaBankName")){
		
				try{
					returnvar = this.txt_hsaBankName.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'HSA Bank Name' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("tot_cont_ytd")){
				try{
					returnvar = this.txt_tot_cont_ytd.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Total Contributions YTD' CDHP - Custodian Bank Tab");
						return false;
					}	
				continue;}
			else if(key.equalsIgnoreCase("empl_cont_ytd")){
				try{
					returnvar = this.txt_empl_cont_ytd.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Employer Contributions YTD' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("total_Contributed_Current_yr")){
				try{
					returnvar = this.txt_Total_Contributed_Current_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Total Contributed Current Year' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("reportable_HSA_Contributions")){
				
				try{
					returnvar = this.txt_Reportable_HSA_Contributions.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Reportable HSA Contributions' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("employee_Contributions_Prior_yr")){
				
				try{
					returnvar = this.txt_Employee_Contributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Employee Contributions Prior Year' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("employer_Contributions_Prior_yr")){
				
				try{
					returnvar = this.txt_Employer_Contributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Employer Contributions Prior Year' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("total_Contributions_Prior_yr")){
				
				try{
					returnvar = this.txt_Total_Contributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Total Contributions Prior Year' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("reportable_HS_Contributions_Prior_yr")){
				
				try{
					returnvar = this.txt_Reportable_HS_Contributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Reportable HSA Contributions Prior Year' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("distributions_Current_yr")){
				
				try{
					returnvar = this.txt_Distributions_Current_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Distributions Current Year' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("distributions_Prior_yr")){
				
				try{
					returnvar = this.txt_Distributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Distributions Prior Year' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("investmentBalance")){
				
				try{
					returnvar = this.txt_InvestmentBalance.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Investment Balance' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("thresholdtoInvest")){
				
				try{
					returnvar = this.txt_ThresholdtoInvest.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Threshold to Invest' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else if(key.equalsIgnoreCase("amount_Available_to_Invest")){
				
				try{
					returnvar = this.txt_Amount_Available_to_Invest.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
					}catch(Exception e){
						err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Amount Available to Invest' CDHP - Custodian Bank Tab");
						return false;
					}
				continue;}
			else 
				err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input - CustodianBank");
			return false;
		}

	if(returnvar)
	{
		System.out.println("ConsumerDrivenHealthPlan -validated CustodianBank tab info checked Successfully");
		return true;	
	}
	else
	{
		int tot_i=args.length;
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
		return false;
	}

}
	
	@FindBy(xpath="//label[@for='IsCDHPReviewed'][text()='Cards information discussed with contact']")
	private WebElement lblCardInfoDiscussedWithContact;
	
	
	@FindBy(xpath="//table[@pl_prop='D_CDHPCardInfo.pxResults']")
	private WebElement cardInformation_Tbl;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyCardInformationHeaders
	 * #Description:This method verifies the fields and headers present in Card Information table. 
	 * #Arguments:Card Info headers -"First Name,Last Name,Card # - Last 4 Digits,Status,Mailed Date"
	 * Type:TextBox
	 */
	public boolean verifyCardInformationHeaders(String[] args){
		utils.clickAnelemnt(this.lblCardInfoTab, "ConsumerDrivenHealthPlan", "Card Information");
		utils.waitforpageload();
		String space = " ";
		StringBuilder input = new StringBuilder();
		System.out.println("Newly constructed Input:"+input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).toString());
		String colHdrs[] = input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).append(",").append(args[4]).toString().split(",");
		try{
			if(!utils.isProxyWebelement(lblCardInfoDiscussedWithContact) && (!utils.isProxyWebelement(reviewChkBox))){
				System.out.println("'Cards information discussed with contact' is displayed");
			}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -CARD Info tab - 'Cards information discussed with contact' is displayed' label is not displayed");
			System.out.println(" 'Cards information discussed with contact' is displayed"+e);
		}

			if(utils.validateTableRowHeader(this.cardInformation_Tbl, colHdrs)){
			System.out.println("Column Headers in UI matched with user data CDHP- Card Information - section");
			return true;
			}
			err.logError("ConsumerDrivenHealthPlan", "Column headers do not match in- Card Information - section");
			return false;
			
		}
		
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCardInformationInCDHP
	 * #Description:This method selects the row for matching key-value pair in Card Information Tab for a particular 'Consumer Driven Health Plan Account Info'. 
	 * #Arguments:CardInformation-KeyValuePair
	 * Type:Table
	 * Keys:#First Name#Last Name#Card#Status#Mailed Date
	 */
	public boolean validateCardInformationInCDHP(String[] args) throws InterruptedException{		
		Thread.sleep(4000);
		utils.clickAnelemnt(this.lblCardInfoTab, "ConsumerDrivenHealthPlan", "Card Information");
				for(String iterator : args)
			{
				String keyvaluepair = iterator;
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
			}
			try{
			if(utils.clickontablerowbasedonvalues(this.cardInformation_Tbl, args)){
				System.out.println("Column Row matched with user data CDHP- Card Information table");
				return true;}
			else{
				err.logError("ConsumerDrivenHealthPlan", "Table row values do not match- Please check key-value pair");
				return false;}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "Exception occured in 'validateCardInformationInCDHP' method");
				return false;
			}
		}
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions') or contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;
	@FindBy(xpath="//a[@class='Standard_task']")
	private WebElement serviceReqDetails;

	public WebElement getServiceReqDetails() {
		return serviceReqDetails;
	}
	
	@FindBy(id="CancellationReason")
	WebElement drpdwnCancellationreason;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement BtnSubmit;
	@FindBy(id="pySearchText")
	WebElement searchText;
	@FindBy(xpath="//i[@class='icons']//*[@name='CPMSearch_pyDisplayHarness_2']")
	WebElement cpmSearchIcon;
	@FindBy(xpath="//a[@data-test-id='20160210145727026023512']")
	WebElement searchResults;
	@FindBy(xpath="//span[text()='Resolved-Cancelled']")
	WebElement cancelStatus;
	public String retrieveServiceReqDetails()
	{
		String srText = this.getServiceReqDetails().getText().trim();
		String srDetails = srText.substring(srText.indexOf("(")+1,srText.indexOf(")")).trim();
		System.out.println("Service Request created is:"+srDetails);
		return srDetails;
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:cancelCDHPTask
	 * #Description:This method is used to cancel CDHP Task and verify request status 'Resolved- Cancelled' is  through Case-search. 
	 * #Arguments:Cancellation Reason
	 * Type:Dropdown
	 * Keys:#Created in Error#Duplicate#Interaction Ended#Contact Withdrew Request
	 */
	public boolean cancelCDHPTask(String[] args) throws InterruptedException{
		String SR = retrieveServiceReqDetails();
		utils.waitforpageload();
		utils.clickAnelemnt(this.btnOtherActions, "ConsumerDrivenHealthPlan", "Other Actions");
		utils.clickAnelemnt(this.lnkOtherCancelThisWork, "ConsumerDrivenHealthPlan", "Cancel this work");
		if(utils.validateHeader(this.sHeaderCDHP, "Cancel this work")){
			utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, args[0], "ConsumerDrivenHealthPlan", "Cancellation Reason");
			utils.clickAnelemnt(this.BtnSubmit, "ConsumerDrivenHealthPlan", "Submit");
			//Then user performs case-search
			Driver.getPgDriver().switchTo().defaultContent();
			utils.enterTextinAnelemnt(this.searchText, SR, "ConsumerDrivenHealthPlan", "Case Search");
			utils.clickAnelemnt(this.cpmSearchIcon, "ConsumerDrivenHealthPlan","Search Icon");
			if(utils.clickAnelemnt(this.searchResults, "ConsumerDrivenHealthPlan", "Results Hyperlink")){
				Thread.sleep(4000);
				if(!utils.isProxyWebelement(cancelStatus)){
					System.out.println("SR Status is: Resolved-Cancelled");
				return true;
				}else{
					err.logError("ConsumerDrivenHealthPlan", "SR Status is not Cancelled!!");
					return false;
				}
			}
			else{
				err.logError("ConsumerDrivenHealthPlan", "Search results are not available for the SR");
				return false;
			}
		}
		err.logError("ConsumerDrivenHealthPlan", "Cancel this work - page is not available to user");
		return false;
	}
	
	@FindBy(xpath="//label[@for='IsCDHPReviewed'][text()='Custodian Bank information discussed with contact']")
	private WebElement lblCustBankInfoDiscussedWithContact;
	
	@FindBy(id="IsCDHPReviewed")
	private WebElement reviewChkBox;
	
	@FindBy(xpath="//label[text()='HSA Account Number']")
	private WebElement lbl_hsaAcctNo;
	
	@FindBy(xpath="//label[text()='HSA Bank Name']")
	private WebElement lbl_hsaBankName;
	
	@FindBy(xpath="//div[text()='Contributions Summary']")
	private WebElement lblContributionsSummary;
	
	@FindBy(xpath="//div[text()='Distributions Summary']")
	private WebElement lblDistributionsSummary;
	
	@FindBy(xpath="//div[text()='Investment Summary']")
	private WebElement lblInvestmentSummary;
	
	@FindBy(xpath="//label[text()='Total Contributions YTD']")
	private WebElement lbl_tot_cont_ytd;
	
	@FindBy(xpath="//label[text()='Employer Contributions YTD']")
	private WebElement lbl_empl_cont_ytd;
	
	@FindBy(xpath="//label[text()='Total Contributed Current Year']")
	private WebElement lbl_Total_Contributed_Current_Year;
	
	@FindBy(xpath="//label[text()='Reportable HSA Contributions']")
	private WebElement lbl_Reportable_HSA_Contributions;
	
	@FindBy(xpath="//label[text()='Employee Contributions Prior Year']")
	private WebElement lbl_Employee_Contributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Employer Contributions Prior Year']")
	private WebElement lbl_Employer_Contributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Total Contributions Prior Year']")
	private WebElement lbl_Total_Contributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Reportable HSA Contributions Prior Year']")
	private WebElement lbl_Reportable_HS_Contributions_Prior_Year;
	
		
	@FindBy(xpath="//label[text()='Distributions Current Year']")
	private WebElement lbl_Distributions_Current_Year;
	
	@FindBy(xpath="//label[text()='Distributions Prior Year']")
	private WebElement lbl_Distributions_Prior_Year;
	
	@FindBy(xpath="//label[text()='Investment Balance']")
	private WebElement lbl_InvestmentBalance;
	
	@FindBy(xpath="//label[text()='Threshold to Invest']")
	private WebElement lbl_ThresholdtoInvest;
	
	@FindBy(xpath="//label[text()='Amount Available to Invest']")
	private WebElement lbl_Amount_Available_to_Invest;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateSectionsDisplayedInCustodianBankTab
	 * #Description:This method validated the labels and sections displayed in Custodian Bank Tab for a particular 'Consumer Driven Health Plan Account Info'. 
	 * Type:TextBox
	 */
	public boolean validateSectionsDisplayedInCustodianBankTab(){
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		utils.clickAnelemnt(this.lblCustodianBankTab, "ConsumerDrivenHealthPlan", "Custodian Bank Tab");
		
		try{
			if(this.lblCustBankInfoDiscussedWithContact.isDisplayed() && this.reviewChkBox.isDisplayed()){
				System.out.println("'Custodian Bank information discussed with contact' is displayed");
			}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - 'Custodian Bank information discussed with contact' label is not displayed");
			System.out.println(" 'Custodian Bank information discussed with contact' label is not displayed"+e);
			fieldsNotPresent.add("Custodian Bank information discussed with contact");
		}
			
			try{
				if(this.lbl_hsaAcctNo.isDisplayed()){System.out.println("'HSA Account Number' is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - 'HSA Account Number' label is not displayed");
				System.out.println(" 'HSA Account Number' label is not displayed"+e);
				fieldsNotPresent.add("HSA Account Number");
			}	
			
			try{
				if(this.lbl_hsaBankName.isDisplayed()){System.out.println("'HSA Bank Name' is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - 'HSA Bank Name' label is not displayed");
				System.out.println(" 'HSA Bank Name' label is not displayed"+e);
				fieldsNotPresent.add("HSA Bank Name");
			}
			
			try{
				if(this.lblContributionsSummary.isDisplayed()){System.out.println("'Contributions Summary' is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - 'Contributions Summary' label is not displayed");
				System.out.println(" 'Contributions Summary' label is not displayed"+e);
				fieldsNotPresent.add("Contributions Summary");
			}
			
			try{
				if(this.lbl_tot_cont_ytd.isDisplayed()){System.out.println("Total Contributions YTD: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Total Contributions YTD label is not displayed");
				System.out.println(" 'Total Contributions YTD' label is not displayed"+e);
				fieldsNotPresent.add("Total Contributions YTD");
			}

			try{
				if(this.lbl_empl_cont_ytd.isDisplayed()){System.out.println("Employer Contributions YTD: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Employer Contributions YTD: label is not displayed");
				System.out.println("Employer Contributions YTD label is not displayed"+e);
				fieldsNotPresent.add("Employer Contributions YTD");
			}
			
			try{
				if(this.lbl_Total_Contributed_Current_Year.isDisplayed()){System.out.println("Total Contributed Current Year: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Total Contributed Current Year: label is not displayed");
				System.out.println("Total Contributed Current Year label is not displayed"+e);
				fieldsNotPresent.add("Total Contributed Current Year");
			}
			
			try{
				if(this.lbl_Reportable_HSA_Contributions.isDisplayed()){System.out.println("Reportable HSA Contributions: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Reportable HSA Contributions: label is not displayed");
				System.out.println("Reportable HSA Contributions label is not displayed"+e);
				fieldsNotPresent.add("Reportable HSA Contributions");
			}
						
			try{
				if(this.lbl_Employee_Contributions_Prior_Year.isDisplayed()){System.out.println("Employee Contributions Prior Year: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Employee Contributions Prior Year: label is not displayed");
				System.out.println("Employee Contributions Prior Year label is not displayed"+e);
				fieldsNotPresent.add("Employee Contributions Prior Year");
			}
			
			try{
				if(this.lbl_Employer_Contributions_Prior_Year.isDisplayed()){System.out.println("Employer Contributions Prior Year: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Employer Contributions Prior Year: label is not displayed");
				System.out.println("Employer Contributions Prior Year label is not displayed"+e);
				fieldsNotPresent.add("Employer Contributions Prior Year");
			}
			
			try{
				if(this.lbl_Total_Contributions_Prior_Year.isDisplayed()){System.out.println("Total Contributions Prior Year: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Total Contributions Prior Year: label is not displayed");
				System.out.println("Total Contributions Prior Year label is not displayed"+e);
				fieldsNotPresent.add("Total Contributions Prior Year");
			}

			try{
				if(this.lbl_Reportable_HS_Contributions_Prior_Year.isDisplayed()){System.out.println("Reportable HSA Contributions Prior Year: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Reportable HSA Contributions Prior Year: label is not displayed");
				System.out.println("Reportable HSA Contributions Prior Year label is not displayed"+e);
				fieldsNotPresent.add("Reportable HSA Contributions Prior Year");
			}

			try{
				if(this.lblContributionsSummary.isDisplayed()){System.out.println("'Distributions Summary' is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - 'Distributions Summary' label is not displayed");
				System.out.println(" 'Distributions Summary' label is not displayed"+e);
				fieldsNotPresent.add("Distributions Summary");
			}
			
			try{
				if(this.lbl_Distributions_Current_Year.isDisplayed()){System.out.println("Distributions Current Year: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Distributions Current Year: label is not displayed");
				System.out.println("Distributions Current Year label is not displayed"+e);
				fieldsNotPresent.add("Distributions Current Year");
			}

			try{
				if(this.lbl_Distributions_Prior_Year.isDisplayed()){System.out.println("Distributions Prior Year: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab -Distributions Prior Year : label is not displayed");
				System.out.println("Distributions Prior Year label is not displayed"+e);
				fieldsNotPresent.add("Distributions Prior Year");
			}
			
			try{
				if(this.lblContributionsSummary.isDisplayed()){System.out.println("'Investment Summary' is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - 'Investment Summary' label is not displayed");
				System.out.println(" 'Investment Summary' label is not displayed"+e);
				fieldsNotPresent.add("Investment Summary");
			}
			
			try{
				if(this.lbl_InvestmentBalance.isDisplayed()){System.out.println("Investment Balance: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Investment Balance: label is not displayed");
				System.out.println("Investment Balance label is not displayed"+e);
				fieldsNotPresent.add("Investment Balance");
			}

			try{
				if(this.lbl_ThresholdtoInvest.isDisplayed()){System.out.println("Threshold to Invest: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Threshold to Invest: label is not displayed");
				System.out.println("Threshold to Invest label is not displayed"+e);
				fieldsNotPresent.add("Threshold to Invest");
			}

			try{
				if(this.lbl_Amount_Available_to_Invest.isDisplayed()){System.out.println("Amount Available to Invest: is displayed");}
			}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "CDHP -Custodian Bank tab - Amount Available to Invest: label is not displayed");
				System.out.println("Amount Available to Invest label is not displayed"+e);
				fieldsNotPresent.add("Amount Available to Invest");
			}
			
		
			if(fieldsNotPresent.size()>0){
				System.out.println("Fields not present in Custodian Bank Tab section:"+fieldsNotPresent);
				return false;
			}
			return true;
	}
	
	public boolean validateRowValuesInClaimTable(WebElement tbl,String[] tablevalues)
	{	
	       List<WebElement> allRows = tbl.findElements(By.tagName("tr"));
	       ArrayList<String> claimTblList= new ArrayList<String>(Arrays.asList(tablevalues));
	       System.out.println(tablevalues+"Size  "+tablevalues.length);
	       for (WebElement row : allRows) {
	                     List<WebElement> allColsByRow=null;
	                     try
	                     {
	                     allColsByRow =row.findElements(By.tagName("td"));

	           if(claimTblList.contains(allColsByRow.get(0).getText()))
	           {
	        	   System.out.println("Values match:"+allColsByRow.get(0).getText());
	           }else{
	        	   System.out.println("Values missing in datatable:"+allColsByRow.get(0).getText());
	     			 err.logError("validateRowValuesInClaimTable", "Values dont match");
	     			 return false;
	           }
	       } catch(Exception e)
           {
          	 continue;
           }
	   }
	  return true;
	}
	
	//Sprint-6.2 Orion
	@FindBy(linkText="Lites")
	private WebElement litesLink;
	
	@FindBy(xpath="//*[text()='This member has a Lumenous CDH product, click on the below links to access the corresponding applications']")
	private WebElement lumenousProductText;
	
	@FindBy(xpath="//*[text()='This member does not have an Anthem CDH account as of 'current date'']")
	private WebElement nonAnthem_nonLumenousText;
	
	@FindBy(xpath="//b[text()='Search Results']")
	private WebElement memberViewText;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyLitesLinkDisplayForLumenousCDHPAcct
	 * #Description:This method verifies if Lites link is displayed for a Lumenous CDHP Account
	 * Type:TextBox
	 */
	public boolean verifyLitesLinkDisplayForLumenousCDHPAcct(){
		utils.waitforpageload();
		if(utils.validateHeader(this.sHeaderCDHP, "View Consumer Driven Health Plan Accounts")){
			try{
				if(this.litesLink.isDisplayed()){
					blogger.loginfo("Pass : Lites link is displayed for this Lumenous CDHP Account");
					return true;
				}
			}catch(Exception e){
				blogger.loginfo("Fail : Lites link is not displayed for this Lumenous CDHP Account"+e);
				err.logError("verifyLitesLinkDisplayForLumenousCDHPAcct", "Lites link is not displayed for this CDHP account");
				return false;
			}
		}
		err.logError("verifyLitesLinkDisplayForLumenousCDHPAcct", "External Search lblHdr is not displayed");
		return false;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyNoLitesLinkDisplay
	 * #Description:This method verifies if No Lites link is displayed for a CDHP Account
	 * Type:TextBox
	 */
	public boolean verifyNoLitesLinkDisplay(){
		if(utils.validateHeader(this.sHeaderCDHP, "View Consumer Driven Health Plan Accounts")){
			try{
				if(!utils.isProxyWebelement(litesLink)){
					blogger.loginfo("Fail : Lites link is displayed for this CDHP Account");
					err.logError("verifyNoLitesLinkDisplay", "Lites link is displayed for this CDHP account");
					return false;
				}
			}catch(Exception e){
				blogger.loginfo("Pass : Lites link is not displayed for this CDHP Account"+e);
				return true;
			}
		}
		return false;
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnLitesLinkForLumenousCDHPAcct
	 * #Description:In this method,Lites link is clicked and we verify Member view is populated in default when SSO is implemented 
	 * Type:TextBox
	 */
	public boolean clickOnLitesLinkForLumenousCDHPAcct() throws InterruptedException{
		//utils.clickAnelemnt(this.litesLink, "ConsumerDrivenHealthPlan", "Lites Link");
		action.moveToElement(this.litesLink).click().build().perform();
		System.out.println("Lites link is clicked");		
		//TODO	
//		Thread.sleep(5000);
		new WebDriverWait(Driver.getPgDriver(),40).until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+handles.size());
			Iterator<String> iterator= handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow);
			String title = Driver.pgDriver.getTitle();
		//Need to update the title of the page - Lites >> External Search
		if(title.contains("Search")){
			System.out.println("Lites >> External Search is launched - Title is"+ title); 
			try{
				if(!utils.isProxyWebelement(memberViewText)){
					System.out.println("Pass : Member Search Page is displayed when clicked on Lites hyperlink");
				return true;}
			}catch(Exception e){
				System.out.println("Fail : Member Search Page is not displayed for this Lumenous CDHP Account"+e);
				err.logError("clickOnLitesLinkForLumenousCDHPAcct", "Member Search Page is not displayed,when clicked on Lites hyperlink");
			}
		 }else{
		System.out.println("Lites >> The page - Title is"+ title);
		  err.logError("ConsumerDrivenHealthPlan", "clickOnLitesLinkForLumenousCDHPAcct");
		 }
	return false;	
	}
		
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyMemberWithNonAnthemNonLumenousAccount
	 * #Description:This method validates if appropriate message is displayed when Member has no active Anthem CDHP or Lumenous CDHP enrollments
	 * Type:TextBox
	 */
	public boolean verifyMemberWithNonAnthemNonLumenousAccount(){
		LocalDate today = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM");
		String month = today.format(f);
		utils.validateHeader(this.sHeaderCDHP, "View Consumer Driven Health Plan Accounts");
		List<WebElement> msg = Driver.pgDriver.findElements(By.xpath("//em/span"));
		try{
			
			String msgTxt1="This member doesn’t have Anthem CDH or Lumenous as of "+month+" "+today.getDayOfMonth()+", "+ today.getYear()+", "+"go to the vendor information section on the contract tab";
			String msgTxt2="under the member composite to find to see if the member has another CDHP vendor to refer the member to."; 
			if(msg.get(0).getText().trim().equalsIgnoreCase(msgTxt1) && msg.get(1).getText().trim().equalsIgnoreCase(msgTxt2)){
				System.out.println("Pass : The following message is displayed::\n"+msg.get(0).getText().trim().concat(msg.get(1).getText().trim()));
				return true;
			}else{
				System.out.println("Fail : Mismatch: The following message is displayed::\n"+msg.get(0).getText().trim().concat(msg.get(1).getText().trim()));
				return false;
			}
		}catch(Exception e){
			System.out.println("Fail : Message is not displayed"+e);
			err.logError("verifyMemberWithNonAnthemNonLumenousAccount", "This member does not have an Anthem CDH or Lumenous account as of 'current date' is not displayed");
			return false;
		}
	
		
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyMemberWithNonAnthemLumenousAccount
	 * #Description:This method validates if appropriate message is displayed when Member has no active Anthem account but Lumenous CDHP enrollments.
	 * Type:TextBox
	 */
	public boolean verifyMemberWithNonAnthemLumenousAccount(){
		utils.waitforpageload();
		LocalDate today = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM");
		String month = today.format(f);
		String expectedMsg = "This member does not have Anthem CDH account as of "+month+" "+today.getDayOfMonth()+", "+ today.getYear()+". "+"For Lumenous CDHP information, click on the below link to access the corresponding application.";
		utils.waitforpageload();
		String msgText1 = Driver.pgDriver.findElement(By.xpath("//span/i[starts-with(text(),'This member')]")).getText().trim()+" "+month+" "+today.getDayOfMonth()+", "+ today.getYear()+". ";
		String msgText2 = Driver.pgDriver.findElement(By.xpath("//em/span")).getText().trim().replace("<br>","").replace("\n"," ");
		String actual=msgText1.concat(msgText2);
		if(utils.isvalueMatch_compareto(actual, expectedMsg)){
			System.out.println("Pass : The following message is displayed::\n"+msgText1.concat(msgText2));
			return true;
		}
		else{
			System.out.println("Fail : Mismatch: The following message is displayed::\n"+msgText1.concat(msgText2));
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyMemberWithAnthemLumenousAccount
	 * #Description:This method verifies that no message is displayed when Member has active Anthem CDHP or Lumenous CDHP enrollments
	 * Type:TextBox
	 */
	public boolean verifyMemberWithAnthemLumenousAccount(){
		return !utils.isProxyWebelement(nonAnthem_nonLumenousText);
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyDisplayofAnthemCDHlink
	 * #Description: This method verifies if 'AnthemCDH' link is displayed on the "View CDHP" page and user clicks on it - to navigate to the WCA SSO Consumer Service.
	 * Type:TextBox
	 */
	public boolean verifyDisplayofAnthemCDHlink(){
		if(utils.validateHeader(this.sHeaderCDHP, "View Consumer Driven Health Plan Accounts")){
			try{
				if(!utils.isProxyWebelement(anthemCDHLink)){
				if(utils.clickAnelemnt(this.anthemCDHLink, "ConsumerDrivenHealthPlan", "Anthem CDH"))
				System.out.println("Anthem CDH link is added to 'CDHP' page and user clicks the link");
				//String parentWindow = Driver.pgDriver.getWindowHandle();
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				int counter =1;
				while (handles.size()<2){
					handles = Driver.pgDriver.getWindowHandles();
					counter++;
					if (counter>5)
					break;
					
					
				}
					
				Iterator<String> iterator = handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				Driver.pgDriver.switchTo().window(childWindow);
				String title = Driver.pgDriver.getTitle().trim();
				//Need to update the title of the page - newly opened Knowledge Library
				if(title.contains("WCA SSO Consumer Service")){
					System.out.println("Anthem CDH is launched - Title is"+ title); 
					return true;
				 }else{
				  err.logcommonMethodError("ConsumerDrivenHealthPlan", "Error in switching to childwindow -Anthem CDH");
				  return false;
				 }
			}}catch(Exception e){
				err.logError("ConsumerDrivenHealthPlan", "Error in handling childwindow:"+e);
				return false;
			}
		}
		err.logcommonMethodError("ConsumerDrivenHealthPlan", "View Consumer Driven Health Plan Accounts page is not loaded");
		return false;
	}
	
	//Sprint 6.3 - Story - 31056
	@FindBy(xpath="//span[text()='Card Transaction Details']")
	private WebElement lbl_CardTransactionDetails;
	
	@FindBy(xpath="//label[contains(text(),'Settlement Date')]")
	private WebElement lbl_SettlementDate;
	@FindBy(xpath="//label[contains(text(),'Settlement Date')]/following-sibling::div/span")
	private WebElement txt_SettlementDate;
	
	@FindBy(xpath="//label[contains(text(),'Merchant ID')]")
	private WebElement lbl_MerchantID;
	@FindBy(xpath="//label[contains(text(),'Merchant ID')]/following-sibling::div/span")
	private WebElement txt_MerchantID;
	
	@FindBy(xpath="//label[contains(text(),'Terminal ID')]")
	private WebElement lbl_TerminalID;
	@FindBy(xpath="//label[contains(text(),'Terminal ID')]/following-sibling::div/span")
	private WebElement txt_TerminalID;
	
	@FindBy(xpath="//label[contains(text(),'Terminal Name')]")
	private WebElement lbl_TerminalName;
	@FindBy(xpath="//label[contains(text(),'Terminal Name')]/following-sibling::div/span")
	private WebElement txt_TerminalName;
	
	@FindBy(xpath="//label[contains(text(),'Terminal City')]")
	private WebElement lbl_TerminalCity;
	@FindBy(xpath="//label[contains(text(),'Terminal City')]/following-sibling::div/span")
	private WebElement txt_TerminalCity;
	
	@FindBy(xpath="//label[contains(text(),'Terminal State')]")
	private WebElement lbl_TerminalState;
	@FindBy(xpath="//label[contains(text(),'Terminal State')]/following-sibling::div/span")
	private WebElement txt_TerminalState;
	
	@FindBy(xpath="//label[contains(text(),'Total Transaction Amount')]")
	private WebElement lbl_TotalTransactionAmount;
	@FindBy(xpath="//label[contains(text(),'Total Transaction Amount')]/following-sibling::div/span")
	private WebElement txt_TotalTransactionAmount;
	
	@FindBy(xpath="//label[contains(text(),'Ineligible Amount')]")
	private WebElement lbl_IneligibleAmount;
	@FindBy(xpath="//label[contains(text(),'Ineligible Amount')]/following-sibling::div/span")
	private WebElement txt_IneligibleAmount;
	
	@FindBy(xpath="//label[contains(text(),'Ineligible Reason')]")
	private WebElement lbl_IneligibleReason;
	@FindBy(xpath="//label[contains(text(),'Ineligible Reason')]/following-sibling::div/span")
	private WebElement txt_IneligibleReason;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateLblsInCardTransactionDetails
	 * #Description:This method validates labels displayed in Card Transaction Details section. 
	 * Type:TextBox
	 */
	public boolean validateLblsInCardTransactionDetails(){
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.lbl_CardTransactionDetails);
		utils.clickAnelemnt(this.lbl_CardTransactionDetails, "CDHP", "Card Transaction Details");
		ArrayList<String> fieldsNotPresent = new ArrayList<String>();
		try{
			if(this.lbl_CardTransactionDetails.isDisplayed()){System.out.println("Card Transaction Details section Header is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Card Transaction Details section Header is not displayed");
			System.out.println("Exception occured:Card Transaction Details section Header is not displayed"+e);
			fieldsNotPresent.add("Card Transaction Details section Header");
		}
		
		try{
			if(this.lbl_SettlementDate.isDisplayed()){System.out.println("Settlement Date is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab -Settlement Date label is not displayed");
			System.out.println("Exception occured:Settlement Date label is not displayed"+e);
			fieldsNotPresent.add("Settlement Date");
		}
		
		try{
			if(this.lbl_MerchantID.isDisplayed()){System.out.println("Merchant ID is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Merchant ID label is not displayed");
			System.out.println("Exception occured:Merchant ID label is not displayed"+e);
			fieldsNotPresent.add("Merchant ID");
		}
		
		try{
			if(this.lbl_TerminalID.isDisplayed()){System.out.println("Terminal ID is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Terminal ID label is not displayed");
			System.out.println("Exception occured:Terminal ID label is not displayed"+e);
			fieldsNotPresent.add("Terminal ID");
		}
		
		try{
			if(this.lbl_TerminalName.isDisplayed()){System.out.println("Terminal Name is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Terminal Name label is not displayed");
			System.out.println("Exception occured:Terminal Name label is not displayed"+e);
			fieldsNotPresent.add("Terminal Name");
		}
		
		try{
			if(this.lbl_TerminalCity.isDisplayed()){System.out.println("Terminal City is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Terminal City label is not displayed");
			System.out.println("Exception occured:Terminal City label is not displayed"+e);
			fieldsNotPresent.add("Terminal City");
		}
		
		try{
			if(this.lbl_TerminalState.isDisplayed()){System.out.println("Terminal State is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Terminal State label is not displayed");
			System.out.println("Exception occured:Terminal State label is not displayed"+e);
			fieldsNotPresent.add("Terminal State");
		}
		
		try{
			if(this.lbl_TotalTransactionAmount.isDisplayed()){System.out.println("Total Transaction Amount is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Total Transaction Amount label is not displayed");
			System.out.println("Exception occured:Total Transaction Amount label is not displayed"+e);
			fieldsNotPresent.add("Total Transaction Amount");
		}
		
		try{
			if(this.lbl_IneligibleAmount.isDisplayed()){System.out.println("Ineligible Amount is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Ineligible Amount label is not displayed");
			System.out.println("Exception occured:Ineligible Amount label is not displayed"+e);
			fieldsNotPresent.add("Ineligible Amount");
		}
		
		try{
			if(this.lbl_IneligibleReason.isDisplayed()){System.out.println("Ineligible Reason is displayed");}
		}catch(Exception e){
			err.logError("ConsumerDrivenHealthPlan", "CDHP -Transaction tab - Ineligible Reason label is not displayed");
			System.out.println("Exception occured:Ineligible Reason label is not displayed"+e);
			fieldsNotPresent.add("Ineligible Reason");
		}		
		
		if(fieldsNotPresent.size()>0){
			System.out.println("Fields not present in Card Transaction Details section"+fieldsNotPresent);
			return false;
		}
		return true;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCardTransactionDetails
	 * #Description:This method validates values displayed in Card Transaction Details section. 
	 * #Arguments:CDHPCardTransactionDetails-KeyValuePair
	 * Type:Table
	 * Keys:Settlement Date#Merchant ID#Terminal ID#Terminal Name#Terminal City#Terminal State#Total Transaction Amount#Ineligible Amount#Ineligible Reason
	 */
	public boolean validateCardTransactionDetails(String[] args){
		utils.waitforpageload();
		boolean returnvar;
		returnvar = true;
		if(utils.validateLabel(this.lbl_CardTransactionDetails, "Card Transaction Details"))
		{
			String keyvaluepair="";
			for(String iterator : args)
			{
				if(!returnvar)
				{
					err.logcommonMethodError("validateCardTransactionDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				 keyvaluepair = iterator;
				
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);

				if(key.equalsIgnoreCase("Settlement Date")){
					try{
						returnvar = this.txt_SettlementDate.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Settlement Date' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("Merchant ID")){
					try{
						returnvar = this.txt_MerchantID.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Merchant ID' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("Terminal ID")){
					try{
						returnvar = this.txt_TerminalID.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Terminal ID' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("Terminal Name")){
					try{
						returnvar = this.txt_TerminalName.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Terminal Name' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("Terminal City")){
					try{
						returnvar = this.txt_TerminalCity.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Terminal City' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("Terminal State")){
					try{
						returnvar = this.txt_TerminalState.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Terminal State' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("Total Transaction Amount")){
					try{
						returnvar = this.txt_TotalTransactionAmount.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Total Transaction Amount' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("Ineligible Amount")){
					try{
						returnvar = this.txt_IneligibleAmount.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Ineligible Amount' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else if(key.equalsIgnoreCase("Ineligible Reason")){
					try{
						returnvar = this.txt_IneligibleReason.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
						}catch(Exception e){
							err.logError("ConsumerDrivenHealthPlan", "Exception occured while retrieving 'Ineligible Reason' in - Card Transaction Details Tab");
							return false;
						}
					continue;}
				else 
					err.logcommonMethodError("ConsumerDrivenHealthPlan", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		}else
			err.logError("ConsumerDrivenHealthPlan", "CDHP-Card Transaction Details tab is not displayed");

		if(returnvar)
		{
			System.out.println("ConsumerDrivenHealthPlan-Card Transaction Details tab info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ConsumerDrivenHealthPlan", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateExternalSearchPageIsDisplayedForISG
	 * #Description:This method validates if External Search page is launched for Individual and Small Group Business, while adding CDHP Task.
	 * Type:TextBox
	 */
	public boolean validateExternalSearchPageIsDisplayedForISG(){
		utils.waitforpageload();
		return utils.validateHeader(this.sHeaderCDHP, "External Search");
	 }
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateToBeTaggedMsgOnSubmit
	 * #Description:This method validates the message displayed, when user clicks on submit without selecting a CDHP Account.
	 * Type:TextBox
	 */
	public boolean validateToBeTaggedMsgOnSubmit(){
		utils.waitforpageload();
		return utils.clickAnelemnt(this.btnSubmit, "ConsumerDrivenHealthPlan", "Submit");
	 }

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectCDHPAccount
	 * #Description:This method selects a particular 'Consumer Driven Health Plan Account', depending on the parameters passed for selection. 
	 * #Arguments:CDHPAccount-KeyValuePair
	 * Type:Table
	 * Keys:#Account Description#Status#Effective Date#Plan Start Date#Plan End Date
	 */
	public boolean selectCDHPAccount(String[] args){
			try{
				//utils.clickontablerowbasedonvalues(this.CDHPAccountsLevelTable,args);
				WebElement row =utils.getAccumulatortablerowbasedonvalues(this.CDHPAccountsLevelTable,args);
				row.findElement(By.xpath(".//input[contains(@id,'IsCDHPReviewed')]")).click();
				row.click();
				System.out.println(row.getAttribute("pl_index"));
				return true;
			}
			catch (Exception e){
				System.out.println("Entire row not matching for given input CDHP -in Account Level" + e);
				return false;
			}
	
	}
	@FindBy(xpath="//table[@pl_prop='D_CDHPTXInfo.pxResults']//div[text()='Service Start Date']")
	private WebElement lbl_ServiceStartDate;
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectTransactionInCDHPAccount
	 * #Description:This method selects a particular  transaction in 'CDHP Account', depending on the parameters passed for selection. 
	 * #Arguments:Transaction-KeyValuePair
	 * Type:Table
	 * Keys:#Transaction Date#Service Start Date#Account#Claimant#Type#Description#Status#Transaction Amount
	 */
	public boolean selectTransactionInCDHPAccount(String[] args){
			try{
				Thread.sleep(2000);
				utils.clickAnelemnt(this.lblTransactionTab, "ConsumerDrivenHealthPlan", "Transactions tab");
				utils.waitforpageload();
				((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.transactionsSummary_Tbl);
				action.moveToElement(lbl_ServiceStartDate).click().build().perform();
				WebElement transaction =utils.getTablerowbasedonvalues(this.transactionsSummary_Tbl,args);
				action.moveToElement(transaction).build().perform();
				transaction.findElement(By.xpath(".//input[contains(@id,'IsTXItemDiscussed')]")).click();
				transaction.click();
				utils.waitforpageload();
				return true;
				//utils.PressEnter(transaction, "CDHP", "transaction row");
				//System.out.println(transaction.getAttribute("pl_index"));
			}
			catch (Exception e){
				System.out.println("Entire row not matching for given input CDHP -in Transaction Level" + e);
				return false;
			}
	
	}
	
	@FindBy(id="IsTxDetailsReviewed")
	WebElement txCheckBox;
	
	@FindBy(id="IsSummaryInfoReviewed")
	WebElement summaryCheckBox;
	
	@FindBy(id="IsCardInfoReviewed")
	WebElement cardInfoCheckBox;
	
	@FindBy(id="IsCustodianBankReviewed")
	WebElement custBankCheckBox;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:checkSummaryInformationDiscussedWithContact
	 * #Description:This method checks the checkbox displayed under Summary tab.
	 * Type:TextBox
	 */
	public boolean checkSummaryInformationDiscussedWithContact(){
		if(utils.clickAnelemnt(this.lblSummaryTab, "ConsumerDrivenHealthPlan", "Summary Tab"))
		utils.waitforpageload();
			return utils.clickAnelemnt(this.summaryCheckBox, "ConsumerDrivenHealthPlan", "Summary information discussed with contact");
	 }
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:uncheckSummaryInformationDiscussedWithContact
	 * #Description:This method unchecks the checkbox displayed under Summary tab.
	 * Type:TextBox
	 */
	public boolean uncheckSummaryInformationDiscussedWithContact(){
			return utils.clickAnelemnt(this.summaryCheckBox, "ConsumerDrivenHealthPlan", "Summary information discussed with contact");
	 }
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:checkTransactionInformationDiscussedWithContact
	 * #Description:This method checks the checkbox displayed under Transaction tab.
	 * Type:TextBox
	 */
	public boolean checkTransactionInformationDiscussedWithContact(){
			if(utils.clickAnelemnt(this.txCheckBox, "ConsumerDrivenHealthPlan", "Transaction information discussed with contact"))
			//Retrieve values from respective section and save in Hashmap, inorder to verify in Review Page.
			if(getValuesFromTransactionSummaryDetails())
			return getValuesFromCardTransactionDetails();
			return false;
	 }
		
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:uncheckTransactionInformationDiscussedWithContact
	 * #Description:This method unchecks the checkbox displayed under Transaction tab.
	 * Type:TextBox
	 */
	public boolean uncheckTransactionInformationDiscussedWithContact(){
			return utils.clickAnelemnt(this.txCheckBox, "ConsumerDrivenHealthPlan", "Transaction information discussed with contact");
	 }
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:checkCustodianBankInfoDiscussedWithContact
	 * #Description:This method checks the checkbox displayed under Custodian Bank tab.
	 * Type:TextBox
	 */
	public boolean checkCustodianBankInfoDiscussedWithContact(){
		if(utils.clickAnelemnt(this.lblCustodianBankTab, "ConsumerDrivenHealthPlan", "Custodian Bank"))
		utils.waitforpageload();
			return utils.clickAnelemnt(this.custBankCheckBox, "ConsumerDrivenHealthPlan", "Custodian Bank information discussed with contact");
	 }
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:uncheckCustodianBankInfoDiscussedWithContact
	 * #Description:This method unchecks the checkbox displayed under Custodian Bank tab.
	 * Type:TextBox
	 */
	public boolean uncheckCustodianBankInfoDiscussedWithContact(){
			return utils.clickAnelemnt(this.custBankCheckBox, "ConsumerDrivenHealthPlan", "Custodian Bank information discussed with contact");
	 }
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:checkCardInformationDiscussedWithContact
	 * #Description:This method checks the checkbox displayed under Card Information tab.
	 * Type:TextBox
	 */
	public boolean checkCardInformationDiscussedWithContact(){
		utils.clickAnelemnt(this.lblCardInfoTab, "ConsumerDrivenHealthPlan", "Card Information");
		utils.waitforpageload();
			return utils.clickAnelemnt(this.cardInfoCheckBox, "ConsumerDrivenHealthPlan", "Cards information discussed with contact");
	 }
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:uncheckCardInformationDiscussedWithContact
	 * #Description:This method unchecks the checkbox displayed under Card Information tab.
	 * Type:TextBox
	 */
	public boolean uncheckCardInformationDiscussedWithContact(){
			return utils.clickAnelemnt(this.cardInfoCheckBox, "ConsumerDrivenHealthPlan", "Cards information discussed with contact");
	 }

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmitInCDHP
	 * #Description:This method clicks on submit button in 'CDHP' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmitInCDHP(){
		utils.scrolltomiddle();
	try{
		this.btnSubmit.click();
		if(utils.isAlertPresent()){
			System.out.println("Submit clicked successfully - & alert is handled on Consumer Driven Health Plan page");
			return true;
		}
		else{
			System.out.println("Submit clicked successfully - & no alert is present on Consumer Driven Health Plan page");
			return true;
		}
	}catch(Exception e){
		err.logcommonMethodError("clickOnSubmitInCDHP", "Unable to click on Submit button in 'Consumer Driven Health Plan' page"+e);
		return false;
		}
	}
	
	private HashMap<String, String> transactionSummaryDetails;
	public HashMap<String, String> getTransactionSummaryDetails() {
		return transactionSummaryDetails;
	}

	public void setTransactionSummaryDetails(HashMap<String, String> transactionSummaryDetails) {
		this.transactionSummaryDetails = transactionSummaryDetails;
	}
	
	private HashMap<String, String> adjudicationDetails;
	public HashMap<String, String> getAdjudicationDetails() {
		return adjudicationDetails;
	}

	public void setAdjudicationDetails(HashMap<String, String> adjudicationDetails) {
		this.adjudicationDetails = adjudicationDetails;
	}
	private HashMap<String, String> claimComments;
	public HashMap<String, String> getClaimComments() {
		return claimComments;
	}

	public void setClaimComments(HashMap<String, String> claimComments) {
		this.claimComments = claimComments;
	}

	private HashMap<String, String> reimbursementDetails;
	public HashMap<String, String> getReimbursementDetails() {
		return reimbursementDetails;
	}

	public void setReimbursementDetails(HashMap<String, String> reimbursementDetails) {
		this.reimbursementDetails = reimbursementDetails;
	}

	private HashMap<String, String> claimLineDetails;
	public HashMap<String, String> getClaimLineDetails() {
		return claimLineDetails;
	}

	public void setClaimLineDetails(HashMap<String, String> claimLineDetails) {
		this.claimLineDetails = claimLineDetails;
	}
	private HashMap<String, String> cardTransactionDetails;
	
	public HashMap<String, String> getCardTransactionDetails() {
		return cardTransactionDetails;
	}

	public void setCardTransactionDetails(
			HashMap<String, String> cardTransactionDetails) {
		this.cardTransactionDetails = cardTransactionDetails;
	}

	public boolean getValuesFromTransactionSummaryDetails(){
		this.transactionSummaryDetails = new HashMap<String,String>();
		this.lbl_TransactionDetails.click();
		this.transactionSummaryDetails.put("Plan Year", this.txt_plan_year.getText());
		this.transactionSummaryDetails.put("Merchant / Provider Name", this.txt_merchant_name.getText());
		this.transactionSummaryDetails.put("Merchant Category code", this.txt_MCC.getText());
		this.transactionSummaryDetails.put("Account Type", this.txt_account_type.getText());
		this.transactionSummaryDetails.put("Account Posting Date", this.txt_account_postingdate.getText());
		this.transactionSummaryDetails.put("Balance After the Transaction", this.txt_balance.getText());
		System.out.println("The values in the Transaction Details HashMap are: " + transactionSummaryDetails);
		return true;
	}
	
	public boolean getValuesFromAdjudicationDetails(){
		this.adjudicationDetails = new HashMap<String,String>();
		this.hdrAdjudicationDetails.click();
		this.adjudicationDetails.put("Service Dates", this.txt_service_dates.getText());
		this.adjudicationDetails.put("Service Type", this.txt_service_type.getText());
		this.adjudicationDetails.put("Service Detail Description", this.txt_service_details_desc.getText());
		this.adjudicationDetails.put("Total Amount", this.txt_total_amount.getText());
		this.adjudicationDetails.put("Pended", this.txt_pended.getText());
		this.adjudicationDetails.put("Denied", this.txt_denied.getText());
		this.adjudicationDetails.put("Excluded", this.txt_excluded.getText());
		this.adjudicationDetails.put("Eligible", this.txt_eligible.getText());
		this.adjudicationDetails.put("Applied to Account Deductible", this.txt_applied_to_account_Deductible.getText());
		this.adjudicationDetails.put("Offset", this.txt_offset.getText());
		this.adjudicationDetails.put("Low Funds", this.txt_low_funds.getText());
		this.adjudicationDetails.put("Approved", this.txt_Approved.getText());
		System.out.println("The values in the Adjudication Details HashMap are: " + adjudicationDetails);
		return true;
	}
	
	public boolean getValuesFromClaimComments(){
		this.claimComments = new HashMap<String,String>();
		this.hdrClaimComments.click();
		this.claimComments.put("Denial Reason", this.txt_denial_reason.getText());
		this.claimComments.put("Denied Comment", this.txt_denial_comment.getText());
		this.claimComments.put("Pended Reason", this.txt_pended_reason.getText());
		this.claimComments.put("Pended Comment", this.txt_pended_comment.getText());
		System.out.println("The values in the Claim Comments HashMap are: " + claimComments);
		return true;
	}
	
	public boolean getValuesFromReimbursementDetails(){
		this.reimbursementDetails = new HashMap<String,String>();
		this.hdrReimbursementDetails.click();
		this.reimbursementDetails.put("Reimbursement Date", this.txt_reimb_date.getText());
		this.reimbursementDetails.put("Reimbursement Method", this.txt_reimb_method.getText());
		this.reimbursementDetails.put("Amount Reimbursed", this.txt_amount_reimb.getText());
		this.reimbursementDetails.put("Reissued Check", this.txt_reissued_check.getText());
		this.reimbursementDetails.put("Check / Trace Number", this.txt_check_trace_no.getText());
		System.out.println("The values in the ReimbursementDetails HashMap are: " + reimbursementDetails);
		return true;
	}
	
	public boolean getValuesFromClaimLineDetails(){
		this.claimLineDetails = new HashMap<String,String>();
		this.hdrClaimLineDetails.click();
		this.claimLineDetails.put("Billed Amount Requested", this.txt_billed_amt_request.getText());
		this.claimLineDetails.put("Billed Amount Reimbursed", this.txt_billed_amt_reimb.getText());
		this.claimLineDetails.put("Allowed Amount Requested", this.txt_allowed_amt_request.getText());
		this.claimLineDetails.put("Allowed Amount Reimbursed", this.txt_allowed_amt_reimb.getText());
		this.claimLineDetails.put("Insurance Paid Amount Requested", this.txt_ins_paid_amt_request.getText());
		this.claimLineDetails.put("Insurance Paid Amount Reimbursed", this.txt_ins_paid_amt_reimb.getText());
		this.claimLineDetails.put("Deductible Requested", this.txt_deduct_amt_request.getText());
		this.claimLineDetails.put("Deductible Reimbursed", this.txt_deduct_amt_reimb.getText());
		this.claimLineDetails.put("Coinsurance Requested", this.txt_coIns_amt_request.getText());
		this.claimLineDetails.put("Coinsurance Reimbursed", this.txt_coIns_amt_reimb.getText());
		this.claimLineDetails.put("CoPay Requested", this.txt_copay_amt_request.getText());
		this.claimLineDetails.put("CoPay Reimbursed", this.txt_copay_amt_reimb.getText());
		this.claimLineDetails.put("Benefit Max Met Requested", this.txt_bene_met_maxrequest.getText());
		this.claimLineDetails.put("Benefit Max Met Reimbursed", this.txt_bene_met_maxreimb.getText());
		this.claimLineDetails.put("Referenced Based Benefit Excess Requested", this.txt_rbb_excess_request.getText());
		this.claimLineDetails.put("Referenced Based Benefit Excess Reimbursed", this.rbb_excess_reimb.getText());
		this.claimLineDetails.put("Above Reasonable and Customary Requested", this.txt_above_RC_request.getText());
		this.claimLineDetails.put("Above Reasonable and Customary Reimbursed", this.txt_above_RC_reimb.getText());
		this.claimLineDetails.put("Not Covered Requested", this.txt_notcovered_amt_request.getText());
		this.claimLineDetails.put("Not Covered Reimbursed", this.txt_notcovered_amt_reimb.getText());
		System.out.println("The values in the ClaimLine Details HashMap are: " + claimLineDetails);
		return true;
	}
	
	public boolean getValuesFromCardTransactionDetails(){
		this.cardTransactionDetails = new HashMap<String,String>();
		this.lbl_CardTransactionDetails.click();
		this.cardTransactionDetails.put("Settlement Date", this.txt_SettlementDate.getText());
		this.cardTransactionDetails.put("Merchant ID", this.txt_MerchantID.getText());
		this.cardTransactionDetails.put("Terminal ID", this.txt_TerminalID.getText());
		this.cardTransactionDetails.put("Terminal Name", this.txt_TerminalName.getText());
		this.cardTransactionDetails.put("Terminal City", this.txt_TerminalCity.getText());
		this.cardTransactionDetails.put("Terminal State", this.txt_TerminalState.getText());
		this.cardTransactionDetails.put("Total Transaction Amount", this.txt_TotalTransactionAmount.getText());
		this.cardTransactionDetails.put("Ineligible Amount", this.txt_IneligibleAmount.getText());
		this.cardTransactionDetails.put("Ineligible Reason", this.txt_IneligibleReason.getText());
		System.out.println("The values in the Card Transaction Details HashMap are: " + cardTransactionDetails);
		return true;
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectGAInCDHPAccount
	 * #Description:This method selects Grievance and Appeals indicator for a 'Consumer Driven Health Plan Account', depending on the parameters passed for selection. 
	 * #Arguments:CDHP-GAAccount-Key
	 * Type:Table
	 * Keys:#Account Description#Status#Effective Date#Plan Start Date#Plan End Date
	 */
	public boolean selectGAInCDHPAccount(String[] args){
			try{
				//utils.clickontablerowbasedonvalues(this.CDHPAccountsLevelTable,args);
				WebElement row =utils.getAccumulatortablerowbasedonvalues(this.CDHPAccountsLevelTable,args);
				//To update the identifier for GA checkbox
				row.findElement(By.xpath(".//input[contains(@id,'TagGandA')]")).click();
				row.click();
				System.out.println(row.getAttribute("pl_index"));		
				return true;
			}
			catch (Exception e){
				System.out.println("Entire row not matching for given input CDHP -in GA Account Level" + e);
				return false;
			}	
	}
	
	@FindBy(xpath="//img[@data-test-id='20160127122348051611158']")
	private WebElement hoverImgGAIcon;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyHoverTextInCDHPGrievanceAndAppealsIcon
	 * #Description:This method validates the hover text displayed on hovering Grievance and Appeals Icon in CDHP Page
	 * Type:Textbox
	 */
	public boolean verifyHoverTextInCDHPGrievanceAndAppealsIcon(){
		try{
			this.hoverImgGAIcon.click();
			String hovertext=this.hoverImgGAIcon.getAttribute("data-hover").toString().toLowerCase();
			System.out.println(hovertext);
			if(hovertext.contains("grievance and appeal")){
				System.out.println("verifyHoverTextInCDHPGrievanceAndAppealsIcon successful in CDHP page");
				return true;
			}else{
				System.out.println("HoverText isnt displayed for GrievanceAndAppealsIcon in CDHP page");
				return false;
			}
		}catch(Exception e){
			err.logcommonMethodError("CDHP","verifyHoverTextInCDHPGrievanceAndAppealsIcon"+e);
			System.out.println("Exception occured in CDHP - verifyHoverTextInCDHPGrievanceAndAppealsIcon"+e);
			return false;
		}
	
	}
	
	@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	private WebElement errGAText;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateGAMsgInCDHP
	 * #Description:This method validates message being displayed if 'Grievance and Appeals Indicator' is checked, but no CDHP account is not selected - inhibits user from proceeding to CDHP Review Page
	 * Type:Textbox
	 */
	public boolean validateGAMsgInCDHP(){
		try{
			String errGAText=this.errGAText.getText().trim();
			System.out.println(errGAText);
			if(errGAText.equalsIgnoreCase("You have either tagged Grievance and Appeal, Account Summary, Transactions, Transaction Details, Bank Information, or Card Information under an Account as being discussed. Tag the associated Account and Transaction if applicable and click Submit.")){
				System.out.println("validateGAMsgInCDHP successful in CDHP page");
				return true;
			}else{
				err.logcommonMethodError("validateGAMsgInCDHP","Expected GA message doesnt match in CDHP page");
				return false;
			}
		}catch(Exception e){
			err.logcommonMethodError("CDHP","validateGAMsgInCDHP"+e);
			System.out.println("Exception occured in CDHP - validateGAMsgInCDHP"+e);
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:nextPageOfTransactionTable
	 * #Description:This method selects a navigates the user to a particular page in transaction records for a 'CDHP Account'. 
	 * #Arguments:pageNo
	 * Type:Textbox
	 * Keys:#Transaction Date#Service Start Date#Account#Claimant#Type#Description#Status#Transaction Amount
	 */
	public boolean nextPageOfTransactionTable(String[] args){
			try{
				//utils.clickontablerowbasedonvalues(this.transactionsSummary_Tbl,args);
				utils.clickAnelemnt(this.lblTransactionTab, "ConsumerDrivenHealthPlan", "Transactions tab");
				utils.waitforpageload();
				//TODO - Replace driver.findElement ->> temporary regression fix
				Driver.pgDriver.findElement(By.xpath("//a[@aria-label='Page "+args[0]+"'][text()='"+args[0]+" ']")).click();
				utils.waitforpageload();
				return true;
			}catch(Exception e){
				err.logcommonMethodError("CDHP","nextPageOfTransactionTable"+e);
				System.out.println("Exception occured in CDHP - nextPageOfTransactionTable"+e);
				return false;
				}
			}
}
