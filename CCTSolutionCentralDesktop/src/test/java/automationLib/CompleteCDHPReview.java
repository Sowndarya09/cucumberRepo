package automationLib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CompleteCDHPReview {
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the CompleteCDHPReview class defining the Iframe and the Page Factory  
	 */
	public CompleteCDHPReview() throws IOException
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

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCDHPReview;

	/*
	 *@SCU
	 *#CommonMethodwithoutArgument:validateCDHPReviewPage
	 *#Description:This method validates if 'Complete CDHP Review Page' is displayed.
	 *Type:Textbox
	 */
	public boolean validateCDHPReviewPage(){
		utils.waitforpageload();
		return utils.validateHeader(this.sHeaderCDHPReview, "Complete CDHP Review");
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(id="ReasonForCDHP")
	private WebElement reasonForContactCDHP;

	@FindBy(xpath="//*[text()='Items Reviewed During CDHP Review']")
	private WebElement itemsReviewedDuringCDHPReviewLbl;

	@FindBy(xpath="//div[text()='Anthem CDH link was accessed']//parent::div//parent::div[@string_type='label']//preceding-sibling::div//img")
	private WebElement anthemcdhlinkAccessed;

	@FindBy(xpath="//div[text()='Tier I / Tier II Document link was accessed']//parent::div//parent::div[@string_type='label']//preceding-sibling::div//img")
	private WebElement tier1or2linkAccessed;

	@FindBy(xpath="//div[text()='Consumer Account Database (CAD) was accessed']//parent::div//parent::div[@string_type='label']//preceding-sibling::div//img")
	private WebElement cadlinkAccessed;

	@FindBy(id="EducateMemberFSAYes")
	WebElement rdoBtnEducateMemberFSAYes;

	@FindBy(id="EducateMemberFSANo")
	WebElement rdoBtnEducateMemberFSANo;

	/*
	 *@SCU
	 *#CommonMethodwithArgument:completeCDHPReviewPage
	 *#Description: This method enters 'Reason for Contact' and performs Submit in Complete CDHP Review Page.
	 *#Arguments:Reason for Contact
	 *Type:Dropdown
	 *Keys:Discuss Consumer Driven Health Plan Account#Request/Activate CDH Debit Card#Request Account Transaction Details
	 */
	public boolean completeCDHPReviewPage(String args[]){
		if(utils.selectDropDownbyVisibleString(reasonForContactCDHP, args[0], "CompleteCDHPReview", "Reason for Contact"))
			if(utils.clickAnelemnt(rdoBtnEducateMemberFSANo, "CompleteCDHPReview", "Educate Member - No"))
				if(utils.clickAnelemnt(btnSubmit, "CompleteCDHPReview", "Submit"))
					return true;
		return false;
	}

	@FindBy(xpath="//table[@pl_prop='.AccountSummary']")
	WebElement tblItemsReviewed;


	/*
	 *@SCU
	 *#CommonMethodwithArgument:validateItemsDiscussedDuringCDHPReview
	 *#Description: This method validates if 'Items Discussed During CDHP Review' in Complete CDHP Review Page.
	 *#Arguments:ItemDiscussed
	 *Type:Table
	 *Keys:Anthem CDH link was accessed#Tier I / Tier II Document link was accessed#Consumer Account Database (CAD) was accessed
	 */
	public boolean validateItemsDiscussedDuringCDHPReview(String tablevalues[]){	
		return utils.validatetablerowbasedonvalues(tblItemsReviewed, tablevalues);
	}

	@FindBy(xpath="//*[contains(@gpropindex,'PAccountSummary')]//table[@class='gridTable ']")
	WebElement CDHPAccountsLevelTable;

	@FindBy(xpath="//*[contains(@gpropindex,'PTransactionSummary')]//table[@class='gridTable ']")
	WebElement CDHPTransactionLevelTable;

	@FindBy(xpath="//*[contains(@gpropindex,'PTaggedItems')]//table[@class='gridTable ']")
	WebElement infoDiscussedFromSectionsTable;


	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyCDHPAccountLevelInfoIsTagged
	 * #Description:This method selects validates a particular 'Consumer Driven Health Plan Account Info' is checked/tagged selected. 
	 * #Arguments:CDHPAccountLevel-KeyValuePair
	 * Type:Table
	 * Keys:#Account Description#Status#Effective Date#Plan Start Date#Plan End Date
	 */
	public boolean verifyCDHPAccountLevelInfoIsTagged(String args[]){
		try{
			WebElement row =utils.getAccumulatortablerowbasedonvalues(this.CDHPAccountsLevelTable,args);
			row.findElement(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')]//img")).click();
			System.out.println(row.getAttribute("pl_index"));		
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input CDHP -in Account Level" + e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyCDHPTransactionLevelInfoIsTagged
	 * #Description:This method selects validates a particular 'Transaction Account Info' is checked/tagged selected. 
	 * #Arguments:CDHPTransactionLevel-KeyValuePair
	 * Type:Table
	 * Keys:#Transaction Date#Service Start Date#Account#Claimant#Type#Description#Status#Transaction Amount
	 */
	public boolean verifyCDHPTransactionLevelInfoIsTagged(String args[]){
		try{
			WebElement row =utils.getTablerowbasedonvalues(this.CDHPTransactionLevelTable,args);
			row.findElement(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')]//img")).click();
			row.click();
			if(compareTransactionDetails())
				if(compareAdjudicationDetails())
					if(compareClaimComments())
						if(compareReimbursementDetails())
							return compareClaimLineDetails();

		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input CDHP -in Transaction Level" + e);
			return false;
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateInformationDiscussedFromSections
	 * #Description:This method selects and validates the sections discussed from the contact. 
	 * #Arguments:InformationDiscussed
	 * Type:Table
	 * Keys:#Summary Information discussed with contact#Custodian Bank Information discussed with contact#Cards Information discussed with contact#Transaction Information discussed with contact
	 */
	public boolean validateInformationDiscussedFromSections(String args[]){
		boolean returnvar;
		returnvar = true;
		String summaryInfo[]={"Information Discussed from sections:Summary Information discussed with contact"};
		String transactionInfo[]={"Information Discussed from sections:Transaction Information discussed with contact"};
		String custodianInfo[]={"Information Discussed from sections:Custodian Bank Information discussed with contact"};
		String cardInfo[]={"Information Discussed from sections:Cards Information discussed with contact"};
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateInformationDiscussedFromSections", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);
			WebElement row;
			if(key.toLowerCase().contains("summary information")){
				if(value.equalsIgnoreCase("yes")){	
					try {
						if(utils.clickontablerowbasedonvalues(this.infoDiscussedFromSectionsTable,summaryInfo)){
							returnvar = true;
						}else{
							System.out.println("Summary Information discussed with contact is not displayed");
							return false;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(value.equalsIgnoreCase("no")){
					try {
						if(utils.clickontablerowbasedonvalues(this.infoDiscussedFromSectionsTable,summaryInfo)){
							return false;
						}else{
							System.out.println("Summary Information discussed with contact is not displayed");
							returnvar = true;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Check your value in yourkeypair:Summary Information discussed with contact. Make sure you enter either 'Yes or No' pattern for input");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("custodian bank information")){
				if(value.equalsIgnoreCase("yes")){
					try {
						if(utils.clickontablerowbasedonvalues(this.infoDiscussedFromSectionsTable,custodianInfo)){
							returnvar = true;
						}else{
							System.out.println("Custodian Information discussed with contact is not displayed");
							return false;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(value.equalsIgnoreCase("no")){
					try {
						if(utils.clickontablerowbasedonvalues(this.infoDiscussedFromSectionsTable,custodianInfo)){
							return false;
						}else{
							System.out.println("Custodian Bank Information discussed with contact is not displayed");
							returnvar = true;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Check your value in yourkeypair:Custodian Bank Information discussed with contact. Make sure you enter either 'Yes or No' pattern for input");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("cards information")){

				if(value.equalsIgnoreCase("yes")){
					try {
						if(utils.clickontablerowbasedonvalues(this.infoDiscussedFromSectionsTable,cardInfo)){
							returnvar = true;
						}else{
							System.out.println("Card Information discussed with contact is not displayed");
							return false;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(value.equalsIgnoreCase("no")){
					try {
						if(utils.clickontablerowbasedonvalues(this.infoDiscussedFromSectionsTable,cardInfo)){
							return false;
						}else{
							System.out.println("Card Information discussed with contact is not displayed");
							returnvar = true;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Check your value in yourkeypair:Card Information discussed with contact. Make sure you enter either 'Yes or No' pattern for input");
					return false;
				}
				continue;}
			else if(key.toLowerCase().contains("transaction information")){
				if(value.equalsIgnoreCase("yes")){					
					try {
						if(utils.clickontablerowbasedonvalues(this.infoDiscussedFromSectionsTable,transactionInfo)){
							returnvar = true;
						}else{
							System.out.println("Transaction Information discussed with contact is not displayed");
							return false;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(value.equalsIgnoreCase("no")){
					try {
						if(utils.clickontablerowbasedonvalues(this.infoDiscussedFromSectionsTable,transactionInfo)){
							return false;
						}else{
							System.out.println("Transaction Information discussed with contact is not displayed");
							returnvar = true;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Check your value in yourkeypair:Transaction Information discussed with contact. Make sure you enter either 'Yes or No' pattern for input");
					return false;
				}
				continue;}
			else 
				err.logcommonMethodError("CompleteCDHPReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar)
		{
			System.out.println("CompleteCDHPReview -validateInformationDiscussedFromSections section info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("CompleteCDHPReview", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//label[contains(text(),'Account Description')]/following-sibling::div/span")
	private WebElement txt_acct_description;

	@FindBy(xpath="//label[contains(text(),'Account Type')]/following-sibling::div/span")
	private WebElement txt_acct_type;

	@FindBy(xpath="//label[contains(text(),'Status')]/following-sibling::div/span")
	private WebElement txt_status;

	@FindBy(xpath="//label[contains(text(),'Effective Date')]/following-sibling::div/span")
	private WebElement txt_eff;

	@FindBy(xpath="//label[contains(text(),'Plan Start Date')]/following-sibling::div/span")
	private WebElement txt_start;

	@FindBy(xpath="//label[contains(text(),'Plan End Date')]/following-sibling::div/span")
	private WebElement txt_end;

	@FindBy(xpath="//label[contains(text(),'Last Date of Spending')]/following-sibling::div/span")
	private WebElement txt_ld_of_spending;


	@FindBy(xpath="//label[contains(text(),'Last Date to Submit Claims')]/following-sibling::div/span")
	private WebElement txt_ld_for_submitclaims;

	@FindBy(xpath="//label[contains(text(),'Fund Rollover Rule')]/following-sibling::div/span")
	private WebElement txt_fund_rollover_rule;

	@FindBy(xpath="//label[contains(text(),'Fund Rollover Percentage(%)')]/following-sibling::div/span")
	private WebElement txt_fund_rollover_percentage;

	@FindBy(xpath="//label[contains(text(),'Fund Rollover Cap')]/following-sibling::div/span")
	private WebElement txt_fund_rollover_cap;

	@FindBy(xpath="//label[contains(text(),'Fund Rollover Date')]/following-sibling::div/span")
	private WebElement txt_fund_rollover_date;

	@FindBy(xpath="//label[contains(text(),'Annual Election')]/following-sibling::div/span")
	private WebElement txt_annual_election;

	@FindBy(xpath="//label[contains(text(),'Contribution YTD')]/following-sibling::div/span")
	private WebElement txt_contribution_ytd;

	@FindBy(xpath="//label[contains(text(),'Incentives Deposits')]/following-sibling::div/span")
	private WebElement txt_incentives_deposits;

	@FindBy(xpath="//label[contains(text(),'Rollover Deposits')]/following-sibling::div/span")
	private WebElement txt_rollover_deposit;

	@FindBy(xpath="//label[contains(text(),'Available Balance')]/following-sibling::div/span")
	private WebElement txt_available_balance;

	@FindBy(xpath="//label[contains(text(),'Holds')]/following-sibling::div/span")
	private WebElement txt_holds;

	@FindBy(xpath="//label[contains(text(),'Disbursable Balance')]/following-sibling::div/span")
	private WebElement txt_disbursable_balance;

	@FindBy(xpath="//label[contains(text(),'Balance Due')]/following-sibling::div/span")
	private WebElement txt_balance_due;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateSummaryInfoDiscussed
	 * #Description:This method validates the Summary Info section discussed from the contact. 
	 * #Arguments:SummaryDiscussed
	 * Type:Table
	 * Keys:#acct_description#acct_type#status#eff#start#end#ld_of_spending#ld_for_submitclaims#fund_rollover_rule#fund_rollover_percentage#fund_rollover_cap#fund_rollover_date#annual_election#contribution_ytd#incentives_deposits#rollover_deposit#available_balance#holds#disbursable_balance#balance_due#member_pay#contribution_ytd
	 */
	public boolean validateSummaryInfoDiscussed(String args[]){
		boolean returnvar;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateSummaryInfoDiscussed", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.equalsIgnoreCase("acct_description")){
				try{
					returnvar = this.txt_acct_description.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Account Description' CDHP - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("acct_type")){
				try{
					returnvar = this.txt_acct_type.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Account Type' CDHP - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("status")){
				try{
					returnvar = this.txt_status.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Status'in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("eff")){
				try{
					returnvar = this.txt_eff.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Effective Date' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("start")){
				try{
					returnvar = this.txt_start.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Plan Start Date' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("end")){
				try{
					returnvar = this.txt_end.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Plan End Date' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("ld_of_spending")){
				try{
					returnvar = this.txt_ld_of_spending.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Last Date of Spending' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("ld_for_submitclaims")){
				try{
					returnvar = this.txt_ld_for_submitclaims.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Last Date To Submit Claims' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("fund_rollover_rule")){
				try{
					returnvar = this.txt_fund_rollover_rule.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Fund RollOver Rule' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("fund_rollover_percentage")){
				try{
					returnvar = this.txt_fund_rollover_percentage.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Fund RollOver Percentage' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("fund_rollover_cap")){
				try{
					returnvar = this.txt_fund_rollover_cap.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Fund RollOver CAP' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("fund_rollover_date")){
				try{
					returnvar = this.txt_fund_rollover_date.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Fund RollOver Date' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("annual_election")){
				try{
					returnvar = this.txt_annual_election.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Annual Election' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("contribution_ytd")){
				try{
					returnvar = this.txt_contribution_ytd.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Contribution YTD' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("incentives_deposits")){
				try{
					returnvar = this.txt_incentives_deposits.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Incentives Deposits' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("rollover_deposit")){
				try{
					returnvar = this.txt_rollover_deposit.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'RollOver Deposit' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("available_balance")){
				try{
					returnvar = this.txt_available_balance.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Available Balance' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("holds")){
				try{
					returnvar = this.txt_holds.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Holds' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("disbursable_balance")){
				try{
					returnvar = this.txt_disbursable_balance.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Disbursable Balance' in - Summary Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("balance_due")){
				try{
					returnvar = this.txt_balance_due.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Balance Due' in - Summary Tab");
					return false;
				}
				continue;}
			else 
				err.logcommonMethodError("CompleteCDHPReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		if(returnvar)
		{
			System.out.println("CompleteCDHPReview -Summary tab info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("CompleteCDHPReview", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}

	}

	@FindBy(xpath="//label[text()='HSA Account Number']/following-sibling::div/span")
	private WebElement txt_hsaAcctNo;

	@FindBy(xpath="//label[text()='HSA Bank Name']/following-sibling::div/span")
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
	 * #CommonMethodwithArgument:validateCustodianInfoDiscussed
	 * #Description:This method validates the Custodian Bank section discussed from the contact. 
	 * #Arguments:CustodianBankDiscussed
	 * Type:Table
	 * Keys:#hsaAcctNo#hsaBankName#tot_cont_ytd#empl_cont_ytd#total_Contributed_Current_yr#reportable_HSA_Contributions#employee_Contributions_Prior_yr#employer_Contributions_Prior_yr#total_Contributions_Prior_yr#reportable_HS_Contributions_Prior_yr#distributions_Current_yr#distributions_Prior_yr#investmentBalance#thresholdtoInvest#amount_Available_to_Invest
	 */
	public boolean validateCustodianBankDiscussed(String args[]){
		boolean returnvar;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("validateCustodianBankDiscussed", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
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
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'HSA Account Number' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("hsaBankName")){

				try{
					returnvar = this.txt_hsaBankName.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'HSA Bank Name' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("tot_cont_ytd")){
				try{
					returnvar = this.txt_tot_cont_ytd.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Total Contributions YTD' CDHP - Custodian Bank Tab");
					return false;
				}	
				continue;}
			else if(key.equalsIgnoreCase("empl_cont_ytd")){
				try{
					returnvar = this.txt_empl_cont_ytd.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Employer Contributions YTD' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("total_Contributed_Current_yr")){
				try{
					returnvar = this.txt_Total_Contributed_Current_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Total Contributed Current Year' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("reportable_HSA_Contributions")){

				try{
					returnvar = this.txt_Reportable_HSA_Contributions.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Reportable HSA Contributions' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("employee_Contributions_Prior_yr")){

				try{
					returnvar = this.txt_Employee_Contributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Employee Contributions Prior Year' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("employer_Contributions_Prior_yr")){

				try{
					returnvar = this.txt_Employer_Contributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Employer Contributions Prior Year' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("total_Contributions_Prior_yr")){

				try{
					returnvar = this.txt_Total_Contributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Total Contributions Prior Year' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("reportable_HS_Contributions_Prior_yr")){

				try{
					returnvar = this.txt_Reportable_HS_Contributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Reportable HSA Contributions Prior Year' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("distributions_Current_yr")){

				try{
					returnvar = this.txt_Distributions_Current_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Distributions Current Year' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("distributions_Prior_yr")){

				try{
					returnvar = this.txt_Distributions_Prior_Year.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Distributions Prior Year' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("investmentBalance")){

				try{
					returnvar = this.txt_InvestmentBalance.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Investment Balance' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("thresholdtoInvest")){

				try{
					returnvar = this.txt_ThresholdtoInvest.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Threshold to Invest' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else if(key.equalsIgnoreCase("amount_Available_to_Invest")){

				try{
					returnvar = this.txt_Amount_Available_to_Invest.getText().toLowerCase().trim().replace(",","").contains(value.toLowerCase().trim());
				}catch(Exception e){
					err.logError("CompleteCDHPReview", "Exception occured while retrieving 'Amount Available to Invest' CDHP - Custodian Bank Tab");
					return false;
				}
				continue;}
			else 
				err.logcommonMethodError("CompleteCDHPReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input - CustodianBank");
			return false;
		}

		if(returnvar)
		{
			System.out.println("CompleteCDHPReview -validated CustodianBank tab info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("CompleteCDHPReview", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//*[contains(@gpropindex,'PCardInfo')]//table[@class='gridTable ']")
	private WebElement cardInformation_Tbl;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCardInfoDiscussed
	 * #Description:This method validates the Card Info section discussed from the contact. 
	 * #Arguments:CardInfoDiscussed
	 * Type:Table
	 * Keys:#First Name#Last Name#Card#Status#Mailed Date
	 */
	public boolean validateCardInfoDiscussed(String args[]){
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
				err.logError("CompleteCDHPReview", "Table row values do not match- Please check key-value pair");
				return false;}
		}catch(Exception e){
			err.logError("CompleteCDHPReview", "Exception occured in 'validateCardInfoDiscussed' method");
			return false;
		}
	}

	private HashMap<String, String> transactionSummaryReviewed;

	public HashMap<String, String> getTransactionSummaryReviewed() {
		return transactionSummaryReviewed;
	}
	public void setTransactionSummaryReviewed(
			HashMap<String, String> transactionSummaryReviewed) {
		this.transactionSummaryReviewed = transactionSummaryReviewed;
	}

	private HashMap<String, String> adjudicationDetailsReviewed;

	public HashMap<String, String> getAdjudicationDetailsReviewed() {
		return adjudicationDetailsReviewed;
	}
	public void setAdjudicationDetailsReviewed(
			HashMap<String, String> adjudicationDetailsReviewed) {
		this.adjudicationDetailsReviewed = adjudicationDetailsReviewed;
	}

	private HashMap<String, String> claimCommentsReviewed;
	public HashMap<String, String> getClaimCommentsReviewed() {
		return claimCommentsReviewed;
	}
	public void setClaimCommentsReviewed(
			HashMap<String, String> claimCommentsReviewed) {
		this.claimCommentsReviewed = claimCommentsReviewed;
	}

	private HashMap<String, String> reimbursementDetailsReviewed;
	public HashMap<String, String> getReimbursementDetailsReviewed() {
		return reimbursementDetailsReviewed;
	}
	public void setReimbursementDetailsReviewed(
			HashMap<String, String> reimbursementDetailsReviewed) {
		this.reimbursementDetailsReviewed = reimbursementDetailsReviewed;
	}

	private HashMap<String, String> claimLineDetailsReviewed;

	public HashMap<String, String> getClaimLineDetailsReviewed() {
		return claimLineDetailsReviewed;
	}
	public void setClaimLineDetailsReviewed(
			HashMap<String, String> claimLineDetailsReviewed) {
		this.claimLineDetailsReviewed = claimLineDetailsReviewed;
	}

	private HashMap<String, String> cardTransactionDetailsReviewed;
	public HashMap<String, String> getCardTransactionDetailsReviewed() {
		return cardTransactionDetailsReviewed;
	}
	public void setCardTransactionDetailsReviewed(
			HashMap<String, String> cardTransactionDetailsReviewed) {
		this.cardTransactionDetailsReviewed = cardTransactionDetailsReviewed;
	}

	@FindBy(xpath="//span[text()='Transaction Details']")
	private WebElement lbl_TransactionDetails;

	@FindBy(xpath="//span[@id][contains(text(),'Adjudication Details')]")
	private WebElement hdrAdjudicationDetails;

	@FindBy(xpath="//span[@id][contains(text(),'Claim Comments')]")
	private WebElement hdrClaimComments;

	@FindBy(xpath="//span[@id][contains(text(),'Reimbursement Details')]")
	private WebElement hdrReimbursementDetails;

	@FindBy(xpath="//span[@id][contains(text(),'Provider Payment Details')]")
	private WebElement	hdrProviderPaymentDetails;

	@FindBy(xpath="//label[contains(text(),'Plan Year')]/following-sibling::div/span")
	private WebElement txt_plan_year;

	@FindBy(xpath="//label[contains(text(),'Merchant / Provider Name')]/following-sibling::div/span")
	private WebElement txt_merchant_name;

	@FindBy(xpath="//label[contains(text(),'Account Type')]/following-sibling::div/span")
	private WebElement txt_account_type;

	@FindBy(xpath="//label[contains(text(),'Account Posting Date')]/following-sibling::div/span")
	private WebElement txt_account_postingdate;

	@FindBy(xpath="//label[contains(text(),'Balance After the Transaction')]/following-sibling::div/span")
	private WebElement txt_balance;

	@FindBy(xpath="//label[contains(text(),'Merchant Category code')]/following-sibling::div/span")
	private WebElement txt_MCC;

	public HashMap<String, String> retrieveValuesFromTransactionSummaryDetails(){
		this.transactionSummaryReviewed = new HashMap<String,String>();
		this.lbl_TransactionDetails.click();
		this.transactionSummaryReviewed.put("Plan Year", this.txt_plan_year.getText());
		this.transactionSummaryReviewed.put("Merchant / Provider Name", this.txt_merchant_name.getText());
		this.transactionSummaryReviewed.put("Merchant Category code", this.txt_MCC.getText());
		this.transactionSummaryReviewed.put("Account Type", this.txt_account_type.getText());
		this.transactionSummaryReviewed.put("Account Posting Date", this.txt_account_postingdate.getText());
		this.transactionSummaryReviewed.put("Balance After the Transaction", this.txt_balance.getText());
		System.out.println("The values in the Transaction Details HashMap are: " + transactionSummaryReviewed);
		return transactionSummaryReviewed;
	}

	@FindBy(xpath="//label[contains(text(),'Service Dates')]/following-sibling::div/span")
	private WebElement txt_service_dates;

	@FindBy(xpath="//label[contains(text(),'Service Type')]/following-sibling::div/span")
	private WebElement txt_service_type;

	@FindBy(xpath="//label[contains(text(),'Service Detail Desc')]/following-sibling::div/span")
	private WebElement txt_service_details_desc;

	@FindBy(xpath="//label[contains(text(),'Approved')]/following-sibling::div/span")
	private WebElement txt_Approved;

	@FindBy(xpath="//label[text()='Pended']/following-sibling::div/span")
	private WebElement txt_pended;

	@FindBy(xpath="//label[text()='Denied']/following-sibling::div/span")
	private WebElement txt_denied;

	@FindBy(xpath="//label[text()='Excluded']/following-sibling::div/span")
	private WebElement txt_excluded;

	@FindBy(xpath="//label[text()='Applied to Account Deductible']/following-sibling::div/span")
	private WebElement txt_applied_to_account_Deductible;

	@FindBy(xpath="//label[text()='Offset']/following-sibling::div/span")
	private WebElement txt_offset;

	@FindBy(xpath="//label[text()='Low Funds']/following-sibling::div/span")
	private WebElement txt_low_funds;

	@FindBy(xpath="//label[text()='Total Amount']/following-sibling::div/span")
	private WebElement txt_total_amount;

	@FindBy(xpath="//label[text()='Eligible']/following-sibling::div/span")
	private WebElement txt_eligible;

	public HashMap<String, String> retrieveValuesFromAdjudicationDetails(){
		this.adjudicationDetailsReviewed = new HashMap<String,String>();
		this.hdrAdjudicationDetails.click();
		this.adjudicationDetailsReviewed.put("Service Dates", this.txt_service_dates.getText());
		this.adjudicationDetailsReviewed.put("Service Type", this.txt_service_type.getText());
		this.adjudicationDetailsReviewed.put("Service Detail Description", this.txt_service_details_desc.getText());
		this.adjudicationDetailsReviewed.put("Total Amount", this.txt_total_amount.getText());
		this.adjudicationDetailsReviewed.put("Pended", this.txt_pended.getText());
		this.adjudicationDetailsReviewed.put("Denied", this.txt_denied.getText());
		this.adjudicationDetailsReviewed.put("Excluded", this.txt_excluded.getText());
		this.adjudicationDetailsReviewed.put("Eligible", this.txt_eligible.getText());
		this.adjudicationDetailsReviewed.put("Applied to Account Deductible", this.txt_applied_to_account_Deductible.getText());
		this.adjudicationDetailsReviewed.put("Offset", this.txt_offset.getText());
		this.adjudicationDetailsReviewed.put("Low Funds", this.txt_low_funds.getText());
		this.adjudicationDetailsReviewed.put("Approved", this.txt_Approved.getText());
		System.out.println("The values in the Adjudication Details HashMap are: " + adjudicationDetailsReviewed);
		return adjudicationDetailsReviewed;
	}

	@FindBy(xpath="//label[text()='Denial Reason']/following-sibling::div/span")
	private WebElement txt_denial_reason;

	@FindBy(xpath="//label[text()='Denied Comment']/following-sibling::div/span")
	private WebElement txt_denial_comment;

	@FindBy(xpath="//label[text()='Pended Reason']/following-sibling::div/span")
	private WebElement txt_pended_reason;

	@FindBy(xpath="//label[text()='Pended Comment']/following-sibling::div/span")
	private WebElement txt_pended_comment;

	public HashMap<String, String> retrieveValuesFromClaimComments(){
		this.claimCommentsReviewed = new HashMap<String,String>();
		this.hdrClaimComments.click();
		this.claimCommentsReviewed.put("Denial Reason", this.txt_denial_reason.getText());
		this.claimCommentsReviewed.put("Denied Comment", this.txt_denial_comment.getText());
		this.claimCommentsReviewed.put("Pended Reason", this.txt_pended_reason.getText());
		this.claimCommentsReviewed.put("Pended Comment", this.txt_pended_comment.getText());
		System.out.println("The values in the Claim Comments HashMap are: " + claimCommentsReviewed);
		return claimCommentsReviewed;
	}

	@FindBy(xpath="//label[text()='Reimbursement Date']/following-sibling::div/span")
	private WebElement txt_reimb_date;

	@FindBy(xpath="//label[text()='Reimbursement Method']/following-sibling::div/span")
	private WebElement txt_reimb_method;

	@FindBy(xpath="//label[text()='Amount Reimbursed']/following-sibling::div/span")
	private WebElement txt_amount_reimb;

	@FindBy(xpath="//label[text()='Reissued Check']/following-sibling::div/span")
	private WebElement txt_reissued_check;

	@FindBy(xpath="//label[text()='Check / Trace Number']/following-sibling::div/span")
	private WebElement txt_check_trace_no;

	public HashMap<String, String> retrieveValuesFromReimbursementDetails(){
		this.reimbursementDetailsReviewed = new HashMap<String,String>();
		this.hdrReimbursementDetails.click();
		this.reimbursementDetailsReviewed.put("Reimbursement Date", this.txt_reimb_date.getText());
		this.reimbursementDetailsReviewed.put("Reimbursement Method", this.txt_reimb_method.getText());
		this.reimbursementDetailsReviewed.put("Amount Reimbursed", this.txt_amount_reimb.getText());
		this.reimbursementDetailsReviewed.put("Reissued Check", this.txt_reissued_check.getText());
		this.reimbursementDetailsReviewed.put("Check / Trace Number", this.txt_check_trace_no.getText());
		System.out.println("The values in the ReimbursementDetails HashMap are: " + reimbursementDetailsReviewed);
		return reimbursementDetailsReviewed;
	}

	@FindBy(xpath="//span[contains(text(),'Claim Line Details')]")
	private WebElement hdrClaimLineDetails;

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

	public HashMap<String, String> retrieveValuesFromClaimLineDetails(){
		this.claimLineDetailsReviewed = new HashMap<String,String>();
		this.hdrClaimLineDetails.click();
		this.claimLineDetailsReviewed.put("Billed Amount Requested", this.txt_billed_amt_request.getText());
		this.claimLineDetailsReviewed.put("Billed Amount Reimbursed", this.txt_billed_amt_reimb.getText());
		this.claimLineDetailsReviewed.put("Allowed Amount Requested", this.txt_allowed_amt_request.getText());
		this.claimLineDetailsReviewed.put("Allowed Amount Reimbursed", this.txt_allowed_amt_reimb.getText());
		this.claimLineDetailsReviewed.put("Insurance Paid Amount Requested", this.txt_ins_paid_amt_request.getText());
		this.claimLineDetailsReviewed.put("Insurance Paid Amount Reimbursed", this.txt_ins_paid_amt_reimb.getText());
		this.claimLineDetailsReviewed.put("Deductible Requested", this.txt_deduct_amt_request.getText());
		this.claimLineDetailsReviewed.put("Deductible Reimbursed", this.txt_deduct_amt_reimb.getText());
		this.claimLineDetailsReviewed.put("Coinsurance Requested", this.txt_coIns_amt_request.getText());
		this.claimLineDetailsReviewed.put("Coinsurance Reimbursed", this.txt_coIns_amt_reimb.getText());
		this.claimLineDetailsReviewed.put("CoPay Requested", this.txt_copay_amt_request.getText());
		this.claimLineDetailsReviewed.put("CoPay Reimbursed", this.txt_copay_amt_reimb.getText());
		this.claimLineDetailsReviewed.put("Benefit Max Met Requested", this.txt_bene_met_maxrequest.getText());
		this.claimLineDetailsReviewed.put("Benefit Max Met Reimbursed", this.txt_bene_met_maxreimb.getText());
		this.claimLineDetailsReviewed.put("Referenced Based Benefit Excess Requested", this.txt_rbb_excess_request.getText());
		this.claimLineDetailsReviewed.put("Referenced Based Benefit Excess Reimbursed", this.rbb_excess_reimb.getText());
		this.claimLineDetailsReviewed.put("Above Reasonable and Customary Requested", this.txt_above_RC_request.getText());
		this.claimLineDetailsReviewed.put("Above Reasonable and Customary Reimbursed", this.txt_above_RC_reimb.getText());
		this.claimLineDetailsReviewed.put("Not Covered Requested", this.txt_notcovered_amt_request.getText());
		this.claimLineDetailsReviewed.put("Not Covered Reimbursed", this.txt_notcovered_amt_reimb.getText());
		System.out.println("The values in the ClaimLine Details HashMap are: " + claimLineDetailsReviewed);
		return claimLineDetailsReviewed;
	}

	@FindBy(xpath="//span[text()='Card Transaction Details']")
	private WebElement lbl_CardTransactionDetails;

	@FindBy(xpath="//label[contains(text(),'Settlement Date')]/following-sibling::div/span")
	private WebElement txt_SettlementDate;

	@FindBy(xpath="//label[contains(text(),'Merchant ID')]/following-sibling::div/span")
	private WebElement txt_MerchantID;

	@FindBy(xpath="//label[contains(text(),'Terminal ID')]/following-sibling::div/span")
	private WebElement txt_TerminalID;

	@FindBy(xpath="//label[contains(text(),'Terminal Name')]/following-sibling::div/span")
	private WebElement txt_TerminalName;

	@FindBy(xpath="//label[contains(text(),'Terminal City')]/following-sibling::div/span")
	private WebElement txt_TerminalCity;

	@FindBy(xpath="//label[contains(text(),'Terminal State')]/following-sibling::div/span")
	private WebElement txt_TerminalState;

	@FindBy(xpath="//label[contains(text(),'Total Transaction Amount')]/following-sibling::div/span")
	private WebElement txt_TotalTransactionAmount;

	@FindBy(xpath="//label[contains(text(),'Ineligible Amount')]/following-sibling::div/span")
	private WebElement txt_IneligibleAmount;

	@FindBy(xpath="//label[contains(text(),'Ineligible Reason')]/following-sibling::div/span")
	private WebElement txt_IneligibleReason;

	public HashMap<String, String> retrieveValuesFromCardTransactionDetails(){
		this.cardTransactionDetailsReviewed = new HashMap<String,String>();
		this.lbl_CardTransactionDetails.click();
		this.cardTransactionDetailsReviewed.put("Settlement Date", this.txt_SettlementDate.getText());
		this.cardTransactionDetailsReviewed.put("Merchant ID", this.txt_MerchantID.getText());
		this.cardTransactionDetailsReviewed.put("Terminal ID", this.txt_TerminalID.getText());
		this.cardTransactionDetailsReviewed.put("Terminal Name", this.txt_TerminalName.getText());
		this.cardTransactionDetailsReviewed.put("Terminal City", this.txt_TerminalCity.getText());
		this.cardTransactionDetailsReviewed.put("Terminal State", this.txt_TerminalState.getText());
		this.cardTransactionDetailsReviewed.put("Total Transaction Amount", this.txt_TotalTransactionAmount.getText());
		this.cardTransactionDetailsReviewed.put("Ineligible Amount", this.txt_IneligibleAmount.getText());
		this.cardTransactionDetailsReviewed.put("Ineligible Reason", this.txt_IneligibleReason.getText());
		System.out.println("The values in the Card Transaction Details HashMap are: " + cardTransactionDetailsReviewed);
		return cardTransactionDetailsReviewed;
	}

	public boolean compareTransactionDetails()
	{
		try 
		{
			ConsumerDrivenHealthPlan cdhp = new ConsumerDrivenHealthPlan();
			cdhp.getValuesFromTransactionSummaryDetails();
			HashMap<String,String> cdhpTransactionSummary = cdhp.getTransactionSummaryDetails();
			HashMap<String,String> cdhpTransactionSummaryReview = retrieveValuesFromTransactionSummaryDetails();
			Set<String> keys = cdhpTransactionSummary.keySet();
			for(String key:keys)
			{
				System.out.println("The keys in TransactionSummary is: " + key);
				String testValue = cdhpTransactionSummary.get(key);
				System.out.println("The value for corresponding Key in TransactionSummary:" + testValue);
				String actualvalue = cdhpTransactionSummaryReview.get(key);
				System.out.println("The value for corresponding Key in TransactionSummary Review page:" + actualvalue);
				if(testValue.equals(actualvalue))
				{
					System.out.println("Values matched for:"+key);
				}
				else{
					System.out.println("Values mismatched for:"+key);
					return false;
				}

			}	

		}catch(Exception e)
		{
			err.logError("CompleteCDHPReview", "Transaction Details - Values doesnt match properly");
			return false;
		}
		return true;
	}

	public boolean compareAdjudicationDetails()
	{
		try 
		{
			ConsumerDrivenHealthPlan cdhp = new ConsumerDrivenHealthPlan();
			cdhp.getValuesFromAdjudicationDetails();
			HashMap<String,String> cdhpAdjudicationDetails = cdhp.getAdjudicationDetails();
			HashMap<String,String> cdhpAdjudicationDetailsReview = retrieveValuesFromAdjudicationDetails();
			Set<String> keys = cdhpAdjudicationDetails.keySet();
			for(String key:keys)
			{
				System.out.println("The keys in AdjudicationDetails is: " + key);
				String testValue = cdhpAdjudicationDetails.get(key);
				System.out.println("The value for corresponding Key in AdjudicationDetails:" + testValue);
				String actualvalue = cdhpAdjudicationDetailsReview.get(key);
				System.out.println("The value for corresponding Key in AdjudicationDetails Review page:" + actualvalue);
				if(testValue.equals(actualvalue))
				{
					System.out.println("Values matched for:"+key);
				}
				else{
					System.out.println("Values mismatched for:"+key);
					return false;
				}

			}	

		}catch(Exception e)
		{
			err.logError("compareAdjudicationDetails", "Adjudication Details - Values doesnt match properly");
			return false;
		}
		return true;
	}

	public boolean compareClaimComments()
	{
		try 
		{
			ConsumerDrivenHealthPlan cdhp = new ConsumerDrivenHealthPlan();
			cdhp.getValuesFromClaimComments();
			HashMap<String,String> cdhpClaimComments = cdhp.getClaimComments();
			HashMap<String,String> cdhpClaimCommentsReview = retrieveValuesFromClaimComments();
			Set<String> keys = cdhpClaimComments.keySet();
			for(String key:keys)
			{
				System.out.println("The keys in ClaimComments is: " + key);
				String testValue = cdhpClaimComments.get(key);
				System.out.println("The value for corresponding Key in ClaimComments:" + testValue);
				String actualvalue = cdhpClaimCommentsReview.get(key);
				System.out.println("The value for corresponding Key in ClaimComments Review page:" + actualvalue);
				if(testValue.equals(actualvalue))
				{
					System.out.println("Values matched for:"+key);
				}
				else{
					System.out.println("Values mismatched for:"+key);
					return false;
				}

			}	

		}catch(Exception e)
		{
			err.logError("compareClaimComments", "ClaimComments - Values doesnt match properly");
			return false;
		}
		return true;
	}
	public boolean compareReimbursementDetails()
	{
		try 
		{
			ConsumerDrivenHealthPlan cdhp = new ConsumerDrivenHealthPlan();
			cdhp.getValuesFromReimbursementDetails();
			HashMap<String,String> cdhpReimbursementDetails = cdhp.getReimbursementDetails();
			HashMap<String,String> cdhpReimbursementDetailsReview = retrieveValuesFromReimbursementDetails();
			Set<String> keys = cdhpReimbursementDetails.keySet();
			for(String key:keys)
			{
				System.out.println("The keys in ReimbursementDetails is: " + key);
				String testValue = cdhpReimbursementDetails.get(key);
				System.out.println("The value for corresponding Key in ReimbursementDetails:" + testValue);
				String actualvalue = cdhpReimbursementDetailsReview.get(key);
				System.out.println("The value for corresponding Key in ReimbursementDetails Review page:" + actualvalue);
				if(testValue.equals(actualvalue))
				{
					System.out.println("Values matched for:"+key);
				}
				else{
					System.out.println("Values mismatched for:"+key);
					return false;
				}

			}	

		}catch(Exception e)
		{
			err.logError("compareReimbursementDetails", "Reimbursement Details - Values doesnt match properly");
			return false;
		}
		return true;
	}

	public boolean compareClaimLineDetails()
	{
		try 
		{
			ConsumerDrivenHealthPlan cdhp = new ConsumerDrivenHealthPlan();
			cdhp.getValuesFromClaimLineDetails();
			HashMap<String,String> cdhpClaimLineDetails = cdhp.getClaimLineDetails();
			HashMap<String,String> cdhpClaimLineDetailsReview = retrieveValuesFromClaimLineDetails();
			Set<String> keys = cdhpClaimLineDetails.keySet();
			for(String key:keys)
			{
				System.out.println("The keys in ClaimLineDetails is: " + key);
				String testValue = cdhpClaimLineDetails.get(key);
				System.out.println("The value for corresponding Key in ClaimLineDetails:" + testValue);
				String actualvalue = cdhpClaimLineDetailsReview.get(key);
				System.out.println("The value for corresponding Key in ClaimLineDetails Review page:" + actualvalue);
				if(testValue.equals(actualvalue))
				{
					System.out.println("Values matched for:"+key);
				}
				else{
					System.out.println("Values mismatched for:"+key);
					return false;
				}

			}	

		}catch(Exception e)
		{
			err.logError("compareClaimLineDetails", "ClaimLineDetails - Values doesnt match properly");
			return false;
		}
		return true;
	}

	public boolean compareCardTransactionDetails()
	{
		try 
		{
			ConsumerDrivenHealthPlan cdhp = new ConsumerDrivenHealthPlan();
			cdhp.getValuesFromCardTransactionDetails();
			HashMap<String,String> cdhpCardTransactionDetails = cdhp.getCardTransactionDetails();
			HashMap<String,String> cdhpCardTransactionDetailsReview = retrieveValuesFromCardTransactionDetails();
			Set<String> keys = cdhpCardTransactionDetails.keySet();
			for(String key:keys)
			{
				System.out.println("The keys in CardTransaction Details is: " + key);
				String testValue = cdhpCardTransactionDetails.get(key);
				System.out.println("The value for corresponding Key in CardTransaction Details:" + testValue);
				String actualvalue = cdhpCardTransactionDetailsReview.get(key);
				System.out.println("The value for corresponding Key in CardTransactionDetails Review page:" + actualvalue);
				if(testValue.equals(actualvalue))
				{
					System.out.println("Values matched for:"+key);
				}
				else{
					System.out.println("Values mismatched for:"+key);
					return false;
				}
			}	
		}catch(Exception e)
		{
			err.logError("compareCardTransactionDetails", "CardTransactionDetails - Values doesnt match properly");
			return false;
		}
		return true;
	}

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteCDHP;
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Manager Help']")	
	private WebElement lnkOtherReqMgrHelp;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View Consumer Driven Heal...']")	
	private WebElement lnkOtherCDHPAccounts;

	public WebElement getHeader()
	{
		return sHeaderCompleteCDHP;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionReviewCDHPInformation
	 * #Description:This method clicks on Other Action and select Review CDHP Information 
	 * Type:Textbox
	 */
	public boolean clickOtherActionReviewCDHPInformation(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteCDHPReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherCDHPAccounts, "CompleteCDHPReview", "View Consumer Driven Health Plan Accounts"))
				if(utils.validateHeader(this.sHeaderCompleteCDHP,"View Consumer Driven Health Plan Accounts"))
					return true;
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionRequestManagerHelp
	 * #Description:This method clicks on Other Action and select Request Manager Help 
	 * Type:Textbox
	 */
	public boolean clickOtherActionRequestManagerHelp(){
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Manager/OE Help", "CompleteCDHPReview", "Request Manager Help");
	}

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Grievance and App...']")	
	private WebElement lnkOtherRequestGandA;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement3;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionsRequestGrievanceandAppeals
	 * #Description: This method clicks on Other Actions and selects Request Grievance and Appeals link
	 * Type:Textbox
	 */
	public boolean clickOtherActionsRequestGrievanceandAppeals(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteProviderReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherRequestGandA, "CompleteProviderReview", "Request Grievance and Appeals"))
			{
				utils.waitforpageload();
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement3);
				if(utils.validateHeader(this.sHeaderCDHPReview,"Grievance and Appeals"))
					return true;
			}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActionsDoesntDisplayRequestGA
	 * #Description: This method clicks on Other Actions and verifies no Request Grievance and Appeals link is displayed
	 * Type:Textbox
	 */
	public boolean verifyOtherActionsDoesntDisplayRequestGA(){
		if(utils.clickAnelemnt(this.btnOtherActions, "CompleteProviderReview", "Other Actions button"))
			return !utils.isProxyWebelement(lnkOtherRequestGandA);
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCDHPTagged
	 * #Description: This method validates the CDHP Accounts tagged or reviewed.
	 * #Arguments:CDHPTagged
	 * Type:Table
	 * Keys:#Account Description#Status#Effective Date#Plan Start Date#Plan End Date
	 */
	public boolean validateCDHPAccountTagged(String args[]){
		try{
			WebElement row =utils.getAccumulatortablerowbasedonvalues(this.CDHPAccountsLevelTable,args);
			row.findElement(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')]//img")).click();
			System.out.println(row.getAttribute("pl_index"));		
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input CDHP -in Account Level" + e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateCDHPandGATagged
	 * #Description: This method validates the CDHP Accounts tagged with GA Indicator checked.
	 * #Arguments:CDHPGATagged
	 * Type:Table
	 * Keys:#Account Description#Status#Effective Date#Plan Start Date#Plan End Date
	 */
	public boolean validateCDHPAccountandGATagged(String args[]){
		try{
			WebElement row =utils.getAccumulatortablerowbasedonvalues(this.CDHPAccountsLevelTable,args);
			row.findElement(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')]//img")).click();
			row.findElement(By.xpath(".//td[contains(@data-attribute-name,'.pyTemplateInputBox')][@headers='a3']//img")).click();
			System.out.println(row.getAttribute("pl_index"));		
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input CDHP -in Account Level" + e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in 'Complete CDHP Review' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
		try{
			this.btnSubmit.click();
			if(utils.isAlertPresent()){
				System.out.println("Submit clicked successfully - & alert is handled on Complete CDHP Review page");
				return true;
			}
			else{
				System.out.println("Submit clicked successfully - & no alert is present on Complete CDHP Review page");
				return true;
			}

		}catch(Exception e){
			err.logcommonMethodError("clickOnSubmitInCDHP", "Unable to click on Submit button in 'Complete CDHP Review' page"+e);
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
		String errGAText=this.errGAText.getText().trim().replace("“", "");
		System.out.println(errGAText);
		String expectedGAText = "You have tagged one of the Consumer Driven Health Plan Account(s) on the Consumer Driven Health Plan task' having a Grievance and/ or Appeal request but have not opened a Grievance and Appeal Task. Open the Grievance and Appeal task from the other actions or uncheck the respective Consumer Driven Health Plan Account on 'View Consumer Driven Health Plan Accounts' being requested for Grievance and/ or Appeal and click Submit.";
		if(errGAText.equalsIgnoreCase(expectedGAText)){
			System.out.println("validateGAMsgInCDHP successful in CDHP page");
			return true;
		}else{
			err.logcommonMethodError("validateGAMsgInCDHP","Expected GA message doesnt match in CDHP page");
			return false;
		}
	}

	public boolean selectReasonForContact(String args[]){
		return utils.selectDropDownbyVisibleString(this.reasonForContactCDHP, args[0], "CompleteCDHPReview", "Reason for Contact");
	}


	@FindBy(id="EducateMemberFSAYes")
	private WebElement IsMemberEducatedRegardingFSAYes;

	@FindBy(id="EducateMemberFSANo")
	private WebElement IsMemberEducatedRegardingFSANo;

	@FindBy(id="EducatedFSAAbout")
	private WebElement MemberEducationDropdown;

	public boolean selectIfMemberEducatedRegardingFSAProgram(String args[]){
		if(args[0].equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(IsMemberEducatedRegardingFSAYes,"CompleteCDHPReview", "IsMemberEducatedOnFSA Yes");
		else
			return	utils.clickAnelemnt(IsMemberEducatedRegardingFSANo,"CompleteCDHPReview", "IsMemberEducatedOnFSA No");
	}

	public boolean selectMemberEducationDropdown(String[] args){
		utils.waitforpageload();
		return utils.selectDropDownbyVisibleString(MemberEducationDropdown, args[0], "CompleteCDHPReview", "Member Education Dropdown");   

	}


	public boolean completeCDHPReviewPageWithoutSubmit(String args[]){
		if(utils.selectDropDownbyVisibleString(reasonForContactCDHP, args[0], "CompleteCDHPReview", "Reason for Contact"))
			if(utils.clickAnelemnt(rdoBtnEducateMemberFSANo, "CompleteCDHPReview", "Educate Member - No"))
				return true;
		return false;
	}

	@FindBy(id="pyNote")
	WebElement txtBxNotes;

	public boolean enterNotes(String[] args)
	{
		return utils.enterTextinAnelemnt(txtBxNotes, args[0], "CompleteEnrollmentAndBillingReview", "Notes");
	}

	@FindBy(id="ERRORMESSAGES_ALL")
	WebElement softWarningPCIMessage;

	/** This method validates the PCI compliance soft warning message
	 * 
	 * @return
	 */

	public boolean validatePCIDataSoftWarningMessage()
	{
		return !utils.isProxyWebelement(softWarningPCIMessage);
	}
}

