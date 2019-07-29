package automationLib;
import java.awt.RenderingHints.Key;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import junit.framework.Assert;
import stepdefinition.stepdefinition;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;


/**
 * The class deals with Claims module and the transaction and flow therin 
 * @author Gautham 
 *
 */

public class ManageClaims {

	SeleniumUtilities utils= new SeleniumUtilities();

	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	private WebElement sHeaderSearchForMember;
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement3;
	WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);
	/*@FindBy(xpath="//table[contains(@pl_prop,'D_ClmsSummary.pxResults')]")
	WebElement tableresult;*/

	@FindBy(xpath="//table[contains(@pl_prop,'D_ClmsSummary.pxResults')]")
	WebElement tableresult;



	String contractName="//*[@class='dataValueRead']/nobr/span"; 
	String textverify="iconRequired standard_iconRequired";
	/**
	 * Constructor 	
	 */

	public ManageClaims()
	{
		try{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement3); 
		}catch(Exception e){
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		}
	}




	@FindBy(xpath="//label[@for='pyFullName']/parent::div//span")
	WebElement labelMemberName;
	@FindBy(xpath="//input[contains(@id,'Claim Details')]")
	WebElement rdBtnClaimDetails;
	@FindBy(xpath="//input[contains(@id,'Claim Number')]")
	WebElement rdBtnClaimNumber;

	@FindBy(xpath="//img[contains(@data-hover,'Claims Discussed')]")
	private WebElement searchResulttableHeaderselect;

	@FindBy(xpath="//input[contains(@id,'CheckReviewForContact')]")
	WebElement rdBtnClaimDiscussed;
	@FindBy(xpath="//input[contains(@id,'ClaimAdjustable')]")
	WebElement rdBtnClaimRequiresAdjust;
	@FindBy(id="ServiceFromDate")
	WebElement txtBxServiceFrmDate;
	@FindBy(id="ServiceToDate")
	WebElement txtBxServiceToDate;
	@FindBy(xpath="//input[contains(@id,'TotalChargeAmount')]")
	WebElement txtBxTotalchargeAMt;
	@FindBy(xpath="//input[contains(@id,'ProviderTaxId')]")
	WebElement txtBxProviderTaxId;
	@FindBy(xpath="//input[contains(@id,'SCCF')]")
	WebElement txtBxSCCF;
	@FindBy(xpath="//textarea[contains(@id,'pyNote')]")
	WebElement txtNotes;
	@FindBy(xpath="//input[contains(@id,'NationalProviderIdentification')]")
	WebElement txtBxNationalProviderIdentification;
	@FindBy(xpath="//input[contains(@id,'ConditionSuspenseRejection')]")
	WebElement txtBxConditionSuspenseRejection;
	@FindBy(xpath="//input[contains(@id,'ClaimNumber')]")
	WebElement txtBxClaimNumber;
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Clear Search')]")
	WebElement BtnClearSearch;
	@FindBy(xpath="//*[text()='Submit']")
	WebElement BtnSubmit;

	@FindBy(xpath="//a[contains(@name,'15')]")
	WebElement lnk30Days;
	@FindBy(xpath="//a[contains(@name,'17')]")
	WebElement lnk60Days;
	@FindBy(xpath="//a[contains(@name,'19')]")
	WebElement lnk90Days;
	@FindBy(xpath="//a[contains(@name,'21')]")
	WebElement lnk12Months;
	@FindBy(xpath="//a[contains(@name,'23')]")
	WebElement lnkYTD;

	@FindBy(xpath="//a[contains(text(),'Prior Year')]")
	WebElement lnkPriorYear;

	@FindBy(xpath="//*[contains(@class,'-mid')][contains(text(),'Search')]")
	WebElement BtnSearch;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="//select[contains(@id,'ClaimType')]")
	WebElement selectClaimType;
	@FindBy(xpath="//select[contains(@id,'PayDirection')]")
	WebElement selectPayDirection;

	@FindBy(xpath="//*[contains(text(),'too many claims')]")
	WebElement txtManageClaimsManyClaimsCheck;
	@FindBy(xpath="//*[@aria-label='Page 3']")
	WebElement lnkPage3;
	@FindBy(xpath="//*[@pl_index='75']")
	WebElement txtRow75;

	@FindBy(xpath="//select[contains(@id,'ReasonForAdjustments')]")
	WebElement selectReasonForAdjustments;

	@FindBy(xpath="//*[@id='ERRORTABLE']//*[@id='ERRORMESSAGES_ALL']/ul/li")
	WebElement lnkErrorMessage;

	@FindBy(xpath="//tr[2]/td[@data-attribute-name='Claim<br/>Number']//a")
	WebElement lnkClickonClaimNumber;

	@FindBy(xpath="//table[contains(@pl_prop,'SearchResult')]")
	WebElement tableSearchResult;


	@FindBy(xpath="//*[@class='textIn'][contains(text(),'Line Details')]")
	WebElement lnkClickonLineDetails;
	@FindBy(xpath="//table[contains(@pl_prop,'LinePage')]")
	WebElement tableLineDetails;

	@FindBy(xpath="//*[contains(text(),'PDF')]")
	WebElement btnExportPDF;
	@FindBy(xpath="//*[contains(text(),'Excel')]")
	WebElement btnExportExcel;

	int i=0;

	public boolean clickSearch()
	{
		if(utils.clickAnelemnt(this.BtnSearch, "ManageClaims", "Search Button"))
		{
			try
			{
				if(utils.waitForElementToBeVisible(tblManageClaimsSearchResults))
					return !utils.isProxyWebelement(tblManageClaimsSearchResults);
				else if(utils.waitForElementToBeVisible(redesignTblManageClaimsSearchResults))
					return !utils.isProxyWebelement(redesignTblManageClaimsSearchResults);
				else
					return false;

			}catch(Exception e) {
				stepdefinition.isServicedown=true;
				utils.isServiceDown();
				return false;
			}
		}
		return false;

	}

	public boolean clicklnkExpand()
	{
		return utils.clickAnelemnt(this.lnkExpand , "Manage claims", "Expand");
	}

	public boolean clickbtnExportExcel()
	{
		return utils.clickAnelemnt(this.btnExportExcel , "Manage claims", "Export Excel");
	}

	public boolean clickbtnExportPDF()
	{
		return utils.clickAnelemnt(this.btnExportPDF , "Manage claims", "Export PDF");
	}

	public boolean clickClearSearch()
	{
		return utils.clickAnelemnt(this.BtnClearSearch , "Manage claims", "Clear Search");
	}

	public boolean clicklnk30Days()
	{
		return utils.clickAnelemnt(this.lnk30Days , "Manage claims", "30 Days");
	}

	public boolean clicklnk90Days()
	{
		return utils.clickAnelemnt(this.lnk90Days , "Manage claims", "90 Days ");
	}

	public boolean clicklnk60Days()
	{

		return utils.clickAnelemnt(this.lnk60Days , "Manage claims", "60 Days");
	}

	public boolean clicklnk12Months()
	{

		return utils.clickAnelemnt(this.lnk12Months , "Manage claims", "12 Months");
	}

	public boolean clicklnkYTD()
	{

		return utils.clickAnelemnt(this.lnkYTD , "Manage claims", "lnkYTD");
	}

	public boolean clickSubmit() throws InterruptedException
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit , "Manage claims", "Submit");
	}

	public boolean clicklnkPriorYear()
	{

		return utils.clickAnelemnt(this.lnkPriorYear , "Manage claims", "lnkPriorYear");
	}

	public boolean clickrdBtnClaimDetails()
	{
		return utils.clickAnelemnt(this.rdBtnClaimDetails , "Manage claims", "Claim Details");
	}

	public boolean clickrdBtnClaimNumber()
	{

		return utils.clickAnelemnt(this.rdBtnClaimNumber , "Manage claims", "Claim Number");
	}

	public boolean settxtBxClaimNumber(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.txtBxClaimNumber, sCCBID, "Manage Claim", "Claim No.");

	}

	public boolean settxtBxConditionSuspenseRejection(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.txtBxConditionSuspenseRejection, sCCBID, "Manage Claim", "Condition suspension Rejectionm ");

	}

	public boolean settxtBxNationalProviderIdentification(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.txtBxNationalProviderIdentification, sCCBID, "Manage Claim", "National Provider Identification ");

	}

	public boolean settxtBxProviderTaxIdp(String sCCBID)
	{
		return utils.enterTextinAnelemnt(this.txtBxProviderTaxId, sCCBID, "Manage Claim", "Provide Tax Id");
	}

	public boolean settxtBxSCCF(String sCCBID)
	{
		return utils.enterTextinAnelemnt(this.txtBxSCCF, sCCBID, "Manage Claim", "SCCF");

	}

	public boolean settxtBxServiceFrmDate(String sCCBID)
	{
		utils.enterTextinAnelemnt(this.txtBxServiceFrmDate, " ", "Manage Claim", "From Date ");
		//txtBxServiceFrmDate.clear();
		return utils.enterTextinAnelemnt(this.txtBxServiceFrmDate, sCCBID, "Manage Claim", "From Date ");

	}

	public boolean settxtBxServiceToDate(String sCCBID)
	{
		utils.enterTextinAnelemnt(this.txtBxServiceToDate, " ", "Manage Claim", "From Date ");
		//txtBxServiceToDate.clear();
		return utils.enterTextinAnelemnt(this.txtBxServiceToDate, sCCBID, "Manage Claim", "To Date ");

	}

	public boolean settxtBxTotalchargeAMt(String sCCBID)
	{
		return utils.enterTextinAnelemnt(this.txtBxTotalchargeAMt, sCCBID, "Manage Claim", "Total charge Amt.");
	}


	public boolean settxtBxNotes(String sCCBID)
	{
		return utils.enterTextinAnelemnt(this.txtNotes, sCCBID, "Manage Claim", "Notes");
	}

	public boolean selectClaimType(String sCCBID)
	{

		return utils.selectDropDownbyVisibleString(this.selectClaimType, sCCBID, "Manage Claim", "Type");

	}

	public boolean selectPayDirection(String sCCBID)
	{

		return utils.selectDropDownbyVisibleString(this.selectPayDirection, sCCBID, "Manage Claim", "payee");

	}

	public boolean clickOnClaimNumber(String[] claimnumber)
	{
		utils.waitforpageload();
		String tempxpath="//table[@class='gridTable ']//a[text()='"+claimnumber[0]+"']";
		System.out.println(tempxpath);
		WebElement ele=Driver.pgDriver.findElement(By.xpath(tempxpath));
		return utils.clickAnelemnt(ele, "Manage Claims", "Claim number");
	}

	/**This method is used to search by custom date
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */

	public boolean searchbyCustomDate(String[] args) throws InterruptedException
	{
		//utils.waitforpageload();
		Thread.sleep(3000);
		for(int i=0;i<args.length;i++)
		{

			if(args[i].toLowerCase().contains("start"))
			{
				String s1=args[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				//s1=s1.replaceAll("/", "");
				if( this.settxtBxServiceFrmDate(s1.trim()))
				{

					continue;
				}
				else
					return false;
			}

			else if (args[i].toLowerCase().contains("end"))
			{
				utils.waitforpageload();
				String s1=args[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				//s1=s1.replaceAll("/", "");

				if(this.settxtBxServiceToDate(s1.trim()))
				{

					continue;
				}
				else
					return false;
			}
		}
		return this.clickSearch();

	}


	public boolean morethan75ClaimsErrorMsg()
	{
		try
		{
			wait=new WebDriverWait(Driver.pgDriver,25);
			wait.until(ExpectedConditions.visibilityOf(this.lnkPage3));
			if(this.lnkPage3.isDisplayed())
			{
				action.moveToElement(lnkPage3);
				lnkPage3.click();

				System.out.println("3rd page has been clicked");
				try
				{
					wait=new WebDriverWait(Driver.pgDriver,20);
					wait.until(ExpectedConditions.visibilityOf(this.txtRow75));
					if(this.txtRow75.isDisplayed())
					{
						if(this.txtManageClaimsManyClaimsCheck.isDisplayed())
						{
							System.out.println("Pass : Claim Result shows more than 75 claims");
							return true;

						}
						else
						{
							System.out.println("Fail : Claim Result doesnot shows more than 75 claims");
							return false;
						}
					}
				}

				catch(Exception e)
				{
					System.out.println("Fail : Claim Result doesnt show more than 75 records");
					return false;
				}
			}

		}



		catch(Exception e)
		{

			System.out.println("Fail: Claim Result doesnt not contain any pages");
			return false;

		}
		return false;

	}

	public void  presentDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}

	@FindBy(xpath="//input[contains(@id,'ReviewFor')]")
	WebElement rdBtnClaimDiscussedWContact;

	@FindBy(xpath="//input[contains(@id,'Adjustable')]")
	WebElement rdBtnClaimRequiresAdjustment;

	@FindBy(xpath="//*[@node_name='ViewClaimDetailsMultiple']//label[contains(@for,'ClaimID')]/parent::div//span")
	WebElement lnkClaimNo;
	@FindBy(xpath="//*[@node_name='ViewClaimDetailsMultiple']//label[contains(@for,'ServiceDates')]/parent::div//span")
	WebElement lnkServiceDates;
	@FindBy(xpath="//*[@node_name='ViewClaimDetailsMultiple']//label[contains(@for,'TotalChargedAmount')]/parent::div//span/span")
	WebElement lnkChargedAmount;
	@FindBy(xpath="//*[@node_name='ViewClaimDetailsMultiple']//label[contains(@for,'OrganizationName')]/parent::div//span")
	WebElement lnkOrganizationName;
	@FindBy(xpath="//*[@node_name='ViewClaimDetailsMultiple']//label[contains(@for,'FullName')]/parent::div//span")
	WebElement lnkPatientName;
	@FindBy(xpath="//*[@node_name='ViewClaimDetailsMultiple']//label[contains(@for,'DateOfBirth')]/parent::div//span")
	WebElement lnkDOB;

	@FindBy(xpath="//*[@class='textMiddle']//*[text()='Claim Details']")
	WebElement headerClaimDetails;

	@FindBy(xpath="//*[@class='textMiddle']//*[text()='Line Details']")
	WebElement headerLineDetails;

	@FindBy(xpath="//*[@node_name='ClaimSummaryDetailsMutiLevel']//table[@section_index='1']//*[contains(text(),'Expand')]")
	WebElement lnkExpand;

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ClaimID')]/parent::div//span")
	WebElement lnkCDTableClaimID;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'MemberCode')]/parent::div//span")
	WebElement lnkCDTableMemberCode;


	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[@for='SCCF']/parent::div//span")
	WebElement lnkCDTableSCCF;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ContractCode')]/parent::div//span")
	WebElement lnkCDTaleContractCode;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'dSCCF')]/parent::div//span")
	WebElement lnkCDTableAdjustedSCCF;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ITS')]/parent::div//span")
	WebElement lnkCDTableITS;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'PaidAs')]/parent::div//span")
	WebElement lnkCDTablePaidAs;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'DiagnosisCode')]/parent::div//span")
	WebElement lnkCDTableDiagnosisCode;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ProcessedDate')]/parent::div//span")
	WebElement lnkCDTableProcessedDate;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ReceivedDate')]/parent::div//span")
	WebElement lnkCDTableReceivedDate;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ClaimStatus')]/parent::div//span")
	WebElement lnkCDTableClaim;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ERISA')]/parent::div//span")
	WebElement lnkCDTableERISA;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'IPA')]/parent::div//span")
	WebElement lnkCDTableIPA;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'PMG')]/parent::div//span")
	WebElement lnkCDTablePMG;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'AuthorizationCode')]/parent::div//span")
	WebElement lnkCDTableAuthorisationNumber;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'OriginalClaimNumber')]/parent::div//span")
	WebElement lnkCDTableOriginalClaimNumber;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ClaimImageNo')]/parent::div//span")
	WebElement lnkCDTableClaimImageNo;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:EnterClaimFiltersforSearch
	 * #Arguments:KeyValuePair
	 * Type:Table
	 *Keys:amount#sccf#type#payee
	 */
	public boolean EnterClaimFiltersforSearch(String[] claimFilters)
	{

		for(int i=0;i<claimFilters.length;i++)
		{

			if(claimFilters[i].toLowerCase().contains("amount"))
			{
				String s1=claimFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if( this.settxtBxTotalchargeAMt(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (claimFilters[i].toLowerCase().contains("sccf"))
			{
				String s1=claimFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.settxtBxSCCF(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (claimFilters[i].toLowerCase().contains("code"))
			{
				String s1=claimFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.settxtBxConditionSuspenseRejection(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (claimFilters[i].toLowerCase().contains("type"))
			{
				String s1=claimFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.selectClaimType(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (claimFilters[i].toLowerCase().contains("payee"))
			{
				String s1=claimFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.selectPayDirection(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (claimFilters[i].toLowerCase().contains("tax"))
			{
				String s1=claimFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.settxtBxProviderTaxIdp(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (claimFilters[i].toLowerCase().contains("npi"))
			{
				String s1=claimFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.settxtBxNationalProviderIdentification(s1))
				{

					continue;
				}
				else
					break;
			}	
		}

		if(this.clickSearch())
		{
			this.clickSearch();
			blogger.loginfo("Pass : Search With CustomDate Successful ");
			return true;
		}

		return true;

	}


	/**
	 * Read the hyperlink in the table and Validate if it is appearing or not 
	 * @param el
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean readToolTipSearch(String scheck) throws InterruptedException
	{

		int count1=0;
		List<WebElement> tr_collection1=tableSearchResult.findElements(By.tagName("tr"));
		for(WebElement trElement1 : tr_collection1)
		{
			List<WebElement> td_collection=trElement1.findElements(By.xpath("td"));
			for(WebElement tdElementtd : td_collection)
			{
				if(count1==7 && scheck=="Click")
				{
					String xpath=tdElementtd.getText();
					xpath="//*[contains(text(),'"+xpath+"')]";
					WebElement element= Driver.pgDriver.findElement(By.xpath(xpath));
					element.sendKeys(Keys.ENTER);
					System.out.println("Wait");
					return true;
				}
				System.out.println(tdElementtd.getText());
				System.out.println	(tdElementtd.findElement(By.xpath("//*[contains(@class,'oflowDivM')]")).getText());
				if(count1==7 || count1==9 || count1==17 || count1==7)
				{
					System.out.println(count1+": Is the value check now.");
					this.checkValueQTip(tdElementtd);
					tdElementtd.findElement(By.xpath("//*[contains(@class,'oflowDivM')]")).getText();
				}
				System.out.println(count1++);

			}

		}
		return true;
	}

	public boolean checkToolTipClckClaimNo() throws InterruptedException
	{
		if(this.clickSearch())
			return this.readToolTipSearch("");
		return false;
	}

	public boolean clickOnClaimNumbers() throws InterruptedException
	{
		if(this.clickSearch())
			return this.readToolTipSearch("Check");
		return false;
	}

	public boolean tagClaimRowbyClaimNumber(String[] claimnumber)
	{
		try{
			String tempxpath="//table[@class='gridTable ']//span/a[text()='"+claimnumber[0]+"']//parent::span//parent::div//parent::td//parent::tr//td[2]//input[@type='checkbox']";
			System.out.println(tempxpath);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempxpath)));
			//			Driver.pgDriver.findElement(By.xpath(tempxpath)).click();
			return utils.clickAnelemnt(Driver.pgDriver.findElement(By.xpath(tempxpath)), "Manage Claims", "Claim Number Checkbox");
		}catch(Exception e)
		{
			err.logError("Manage Claims", "Claim check  box tag");
			return false;
		}
	}

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ServiceFromDate')]/parent::div//span")
	WebElement lnkCDTableServiceFromDate;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ServiceToDate')]/parent::div//span")
	WebElement lnkCDTableServiceToDate;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalChargedAmount')]/parent::div//span")
	WebElement lnkCDTableTotalChargedAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'AllowedAmount')]/parent::div//span")
	WebElement lnkCDTableAllowedAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ProviderWriteOffAmount')]/parent::div//span")
	WebElement lnkCDTableProviderWriteOffAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'PaidAmount')]/parent::div//span")
	WebElement lnkCDTablePaidAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'HRAStartingBalance')]/parent::div//span")
	WebElement lnkCDTableHRAStartingBalance;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'HRAEndingBalance')]/parent::div//span")
	WebElement lnkCDTableHRAEndingBalance;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'HRAPaidAmount')]/parent::div//span")
	WebElement lnkCDTableHRAPaidAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'MemberLiabilityAmount')]/parent::div//span")
	WebElement lnkCDTableMemberLiabilityAmount;


	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//span[starts-with(text(),' ')]")
	WebElement lnkCDTableContainsSpace;

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'CheckAmount')]/parent::div//span")
	WebElement lnkPDTableCheckAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'CheckIssueDate')]/parent::div//span")
	WebElement lnkPDTableCheckIssueDate;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'Payee')]/parent::div//span")
	WebElement lnkPDTablePayee;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'CheckNumber')]/parent::div//span")
	WebElement lnkPDTableCheckNumber;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'CheckAddress')]/parent::div//span")
	WebElement lnkPDTableCheckAddress;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'CheckStatus')]/parent::div//span")
	WebElement lnkPDTableCheckStatus;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'CheckStatusDate')]/parent::div//span")
	WebElement lnkPDTableCheckStatusDate;

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'FullName')]/parent::div//span")
	WebElement lnkPntDTableFullName;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'DateOfBirth')]/parent::div//span")
	WebElement lnkPntDTableDateOfBirth;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'PatientAccountNumber')]/parent::div//span")
	WebElement lnkPntDTablePatientAccountNumber;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'Relationship')]/parent::div//span")
	WebElement lnkPntDTableRelationship;

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ProviderName')]/parent::div//span")
	WebElement lnkBPDProviderName;

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TaxID')]/parent::div//span")
	WebElement lnkBPDTaxID;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'NPI')]/parent::div//span")
	WebElement lnkBPDNPI;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'PhoneNumber')]/parent::div//span")
	WebElement lnkBPDPhoneNumber;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'Address')]/parent::div//span")
	WebElement lnkBPDAddress;

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'OrganizationName')]/parent::div//span")
	WebElement lnkRPDOrganizationName;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TaxonomyCode')]/parent::div//span")
	WebElement lnkRPDTaxonomyCode;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'NationalProviderIdentfier')]/parent::div//span")
	WebElement lnkRPDNationalProviderIdentfier;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'PhoneNumber')]/parent::div//span")
	WebElement lnkRPDPhoneNumber;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'AddressLine1')]/parent::div//span")
	WebElement lnkRPDAddressLine1;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'PlanNetworkNumber')]/parent::div//span")
	WebElement lnkRPDPlanNetworkNumber;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'NetworkID')]/parent::div//span")
	WebElement lnkPRDNetworkID;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'Type')]/parent::div//span")
	WebElement lnkPRDType;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'PhoneNumber')]/parent::div//span")
	WebElement lnkPRDPrimarySpeciality;

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'pyTemplateInputBox')]/parent::div//span")
	WebElement lnkMedicarepyMediCrossOver;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'MedicareAssignmentCode')]/parent::div//span")
	WebElement lnkMedicareAssignmentCode;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@data-test-id,'201602160705260545144495-Label')]/parent::div//span")
	WebElement lnkMedicarepyMedicareHicNumber;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalMedicareAllowedAmount')]/parent::div//span")
	WebElement lnkTotalMedicareAllowedAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalMedicareCoinsuranceAmount')]/parent::div//span")
	WebElement lnkTotalMedicareCoinsuranceAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalMedicareDeductibleAmount')]/parent::div//span")
	WebElement lnkTotalMedicareDeductibleAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalMedicarePaidAmount')]/parent::div//span")
	WebElement lnkTotalMedicarePaidAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalMedicareNonCoveredAmount')]/parent::div//span")
	WebElement lnkTotalMedicareNonCoveredAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalMedicareProviderWriteOffAmount')]/parent::div//span")
	WebElement lnkTotalMedicareProviderWriteOffAmount;

	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalOtherInsuranceAllowedAmount')]/parent::div//span")
	WebElement lnkTotalOtherInsuranceAllowedAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'TotalOtherInsurancePaidAmount')]/parent::div//span")
	WebElement lnkTotalOtherInsurancePaidAmount;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'COBIndicator')]/parent::div//span")
	WebElement lnkCOBIndicator;
	@FindBy(xpath="//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'WorkersCompensationIndicator')]/parent::div//span")
	WebElement lnkWorkersCompensationIndicator;



	/**
	 * Line Details Xpath
	 */

	@FindBy(xpath="//label[text()='Line Details']")
	WebElement lnkLineDetails;
	@FindBy(xpath="//tr[@pl_index='1'][contains(@id,'CalculationList')]")
	WebElement lnkLineDetailsRow1;
	@FindBy(xpath="//*[@pl_index='2']")
	WebElement lnkLineDetailsRow2;
	@FindBy(xpath="//*[@pl_index='1']//*[contains(@src,'next')]")
	WebElement lnkLineDetailsRow1Next;
	@FindBy(xpath="//*[@pl_index='2']//*[contains(@src,'next')]")
	WebElement lnkLineDetailsRow2Next;
	@FindBy(xpath="//*[@pl_index='2']//*[contains(@src,'previous')]")
	WebElement lnkLineDetailsRow2Previous;
	@FindBy(xpath="//*[@section_index='1']//*[contains(@for,'TypeOfService')]")
	WebElement lnkLineDetailsRow1NextTypeofService;

	public boolean checkClaimDetails(String[] args)
	{
		for(int i = 0 ; i < args.length ; i ++)
		{
			boolean flag= false;
			if(args[i].contains("First Date of Service"))
			{
				if(this.lnkCDTableServiceFromDate.getText().contains(args[i]))
				{
					flag= true;
				}
			}

			else if(args[i].contains("Last Date of Service"))
			{
				if(this.lnkCDTableServiceToDate.getText().contains(args[i]))
				{
					flag= true;
				}
			}

			else if(args[i].contains("Charged Amount"))
			{
				if(this.lnkCDTableTotalChargedAmount.getText().contains(args[i]))
				{
					flag= true;
				}
			}

			else if(args[i].contains("Allowed Amount"))
			{
				if(this.lnkCDTableAllowedAmount.getText().contains(args[i]))
				{
					flag= true;
				}
			}
			else if(args[i].contains("Write off Amount"))
			{
				if(this.lnkCDTableProviderWriteOffAmount.getText().contains(args[i]))
				{
					flag= true;
				}
			}
			else if(args[i].contains("Paid Amount"))
			{
				if(this.lnkCDTablePaidAmount.getText().contains(args[i]))
				{
					flag= true;
				}
			}
			else if(args[i].contains("Check Issue Date"))
			{
				if(this.lnkPDTableCheckIssueDate.getText().contains(args[i]))
				{
					flag= true;
				}
			}
			else if(args[i].contains("Patient Name"))
			{
				if(this.lnkPatientName.getText().contains(args[i]))
				{
					flag= true;
				}
			}
		}
		return true;
	}



	public boolean clicklnkLineDetails()
	{
		return utils.clickAnelemnt(this.lnkLineDetails , "Manage claims", "Expand");
	}

	public boolean clicklnkLineDetailsRow1()
	{

		return utils.clickAnelemnt(this.lnkLineDetailsRow1 , "Line Details", "Row1");
	}

	public boolean clicklnkLineDetailsRow2()
	{

		return utils.clickAnelemnt(this.lnkLineDetailsRow2 , "Line Details", "Row2");
	}

	public boolean clicklnkLineDetailsRow1Next()
	{

		return utils.clickAnelemnt(this.lnkLineDetailsRow1Next , "Line Details", "Next");
	}

	public boolean clicklnkLineDetailsRow2previous()
	{

		return utils.clickAnelemnt(this.lnkLineDetailsRow2Previous , "Line Details", "Previous");
	}

	/**
	 * Navigate to Line Details tab and check the Value from the Table and all the validation to be done 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean navigateLineDcheck(String[] args) throws InterruptedException
	{
		if(this.clicklnkLineDetails())
			return this.tableClickExpand(this.tableLineDetails, "Expand", args);
		return false;
	}

	/**
	 * Checking whether line details contains next page /previous page links
	 * 
	 */

	public boolean validateNextandPreviousLinkDetails()
	{
		if(this.clicklnkLineDetails())
		{
			if(utils.clickAnelemnt(this.lnkLineDetailsRow1, "linedetails", "row1"))
			{
				utils.clickAnelemnt(this.lnkLineDetailsRow1, "linedetails", "row1");
				utils.clickAnelemnt(this.lnkLineDetailsRow1, "linedetails", "row1");
				System.out.println("Line1 is expanded");

				if(this.lnkLineDetailsRow1Next.isDisplayed())
				{

					this.clicklnkLineDetailsRow1Next();
					this.clicklnkLineDetailsRow1Next();
					this.clicklnkLineDetailsRow1Next();
					System.out.println("Next link is clicked");
				}	 
				else
				{
					System.out.println("Next link is not present on Line1");
					return false;
				}
			}
			else
			{
				System.out.println("Line1 is not displayed"); 
			}
		}
		if(this.lnkLineDetailsRow1NextTypeofService.isDisplayed())
		{

			System.out.println("Line 2 is expanded");
			this.clicklnkLineDetailsRow2previous();
			this.clicklnkLineDetailsRow2previous();
			this.clicklnkLineDetailsRow2previous();
			System.out.println("Line 1 is expanded");
		}
		else
		{
			System.out.println("Line 1 is not  expanded");
		}

		return true;
	}

	/**
	 * Checking Data from teh Expanded sheet and Copying it to the Excel sheet 
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean expandCheckDataAndSubmit(String[] args) throws InterruptedException
	{

		if(this.clicklnkExpand())
		{
			if(!this.lnkBPDNPI.isDisplayed())
			{
				expandCheckDataAndSubmit(args);
			}

			if(this.checkClaimDetails(args))
			{
				System.out.println("Pass : Succ3essfully Validated the Values in the Page ");
			}

			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("scroll(0, 2000);");
			if(this.clickSubmit())
			{
				System.out.println("Pass : Validated all Values and submitted ");
				return true;
			}
		}
		return false;
	}


	public boolean clickrdBtnClaimDiscussed()
	{
		if(utils.clickAnelemnt(this.rdBtnClaimDiscussed , "Manage claims", "Radio button Claim Discussed"))
			return utils.clickAnelemnt(this.btnSubmit, "View Claims", "Submit Button"); 
		return false;
	}

	public boolean clickrdBtnClaimRequiresAdjustment()
	{
		return utils.clickAnelemnt(this.rdBtnClaimRequiresAdjustment , "Manage claims", "Radio button Requiring Adjust");

	}

	/**
	 * Will click on the radio buttion and enter the notes and will eventually navigatre tio the flow 
	 * @return
	 */
	public boolean claimAdjustment()
	{

		if(this.clickrdBtnClaimRequiresAdjustment())
		{
			if(utils.selectDropDownbyVisibleString(this.selectReasonForAdjustments, "Referral", "Claims", "Drop Down"))
			{
				if(this.settxtBxNotes("Enter Notes less then 144 charac"))
				{
					System.out.println("Pass : The claim Adjustment is done and will enter the notes. " );
					return true; 
				}
			}
		}


		return false;
	}


	@FindBy(xpath="//*[@node_name='ViewClaimDetailsMultiple']//label[contains(@for,'ClaimID')]/parent::div//span")
	WebElement lnkClaimId;

	@FindBy(xpath="//select[contains(@id,'PrimaryReasonforBilling')]")
	WebElement selectReasonforContact;
	@FindBy(xpath="//textarea[contains(@id,'ManagerReviewNotes')]")
	WebElement txtBxNotes;
	@FindBy(xpath="//*[contains(@class,'actionTitleBarLabelStyle')]")
	WebElement headerManageClaimsReviews;

	public boolean settxtBxNoteReason(String sFullName)
	{

		return utils.enterTextinAnelemnt(this.txtBxNotes, sFullName, "Manage Claims", "Notes");

	}


	/**
	 * Click on Submit close the Manage Billing Module
	 * @return
	 * @throws InterruptedException 
	 */

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public boolean clickbtnSumbit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.getBtnSubmit(), "Select Associate Contact", "Button Submit");

	}

	public boolean submitManageClaimsReviews() throws InterruptedException
	{
		//wait=new WebDriverWait(Driver.pgDriver,30);
		if(clickbtnSumbit()){
			if(utils.selectDropDownbyVisibleString(this.selectReasonforContact, "Explain how claim processed", "Manage Claims", "Select Reason"))
			{
				if(this.settxtBxNoteReason("Entered the reason for Claims."))
				{
					if(this.clickSubmit())
					{
						System.out.println("Pass: Passed the Flow. ");
						return true;
					}
				}
			}
		}

		return false;
	}



	/**
	 * Line Details Table and check the values 
	 * @param el
	 * @param scheck
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */

	public boolean tableClickExpand(WebElement el,String scheck, String[] args) throws InterruptedException
	{

		boolean flag= false;
		List<WebElement> tr_collection1=el.findElements(By.tagName("tr"));
		for(WebElement trElement1 : tr_collection1)
		{
			List<WebElement> td_collection=trElement1.findElements(By.xpath("td"));
			for(WebElement tdElementtd : td_collection)
			{
				if(scheck.equalsIgnoreCase("Expand"))
				{
					tdElementtd.click();
					flag= true;
					break;

				}
			}
			if(flag)
			{
				break;
			}

		}

		for(int i = 0 ; i < args.length ; i ++)
		{
			flag= false;
			if(args[i].contains("Claim Number"))
			{
				if(this.lnkClaimNo.getText().contains(args[i].split(":")[1].trim()))
				{
					flag= true;
				}
			}

			else if(args[i].contains("Date of Service"))
			{
				if(this.lnkServiceDates.getText().contains(args[i].split(":")[1].trim()))
				{
					flag= true;
				}
			}

			else if(args[i].contains("Charged Amount"))
			{
				if(this.lnkChargedAmount.getText().contains(args[i].split(":")[1].trim()))
				{
					flag= true;
				}
			}

			else if(args[i].contains("Patient Name"))
			{
				if(this.lnkPatientName.getText().contains(args[i].split(":")[1].trim()))
				{
					flag= true;
				}
			}
			else if(args[i].contains("DOB"))
			{
				if(this.lnkDOB.getText().contains(args[i].split(":")[1].trim()))
				{
					flag= true;
				}
			}
			else if(args[i].contains("Rendering Provider Name"))
			{
				if(this.lnkOrganizationName.getText().contains(args[i].split(":")[1].trim()))
				{
					flag= true;
				}
			}
			else if(args[i].contains("Date of Service"))
			{
				if(this.lnkServiceDates.getText().contains(args[i].split(":")[1]))
				{
					flag= true;
				}
			}
			else if(args[i].contains("Date of Service"))
			{
				if(this.lnkServiceDates.getText().contains(args[i].split(":")[1].trim()))
				{
					flag= true;
				}
			}
		}
		return true;
	}

	public boolean checkhoverProcedureCode() throws InterruptedException
	{
		String Procedurecode=null;
		if(this.clicklnkLineDetails())
		{

			if(this.lnkhoverProcedurecode1.getText().isEmpty())
			{
				System.out.println("The xpath for procedurecode1 is empty");
				if(this.lnkhoverProcedurecode2.getText().isEmpty())
				{
					System.out.println("The xpath for procedurecode2 is empty");
					return false;
				}
				else
				{
					Actions action=new Actions(Driver.getPgDriver());
					action.moveToElement(this.lnkhoverProcedurecode2).build().perform();
					Procedurecode=this.lnkhovertextforProcedureCode.getText();
					System.out.println("The value of attribute is : "+Procedurecode); 
				}
			}
			else
			{
				Actions action=new Actions(Driver.getPgDriver());
				action.moveToElement(this.lnkhoverProcedurecode1).build().perform();
				Procedurecode=this.lnkhovertextforProcedureCode.getText();
				System.out.println("The value of attribute is : "+Procedurecode);
			}
		}

		return true;

	}

	@FindBy(xpath="//div[@node_name='ClaimLinePrcdandRevCds']//label[@for='RevenueCode1']/parent::div//span")
	WebElement lnkhoverProcedurecode1;
	@FindBy(xpath="//div[@class='smarttip-content']")
	WebElement lnkhovertextforProcedureCode;
	@FindBy(xpath="//div[@node_name='ClaimLinePrcdandRevCds']//label[@for='ProcedureCode1']/parent::div//span")
	WebElement lnkhoverProcedurecode2;

	@FindBy(xpath="//td[contains(@data-attribute-name,'Member<br/>Liability Amount')]//span[@class='smartInfoNew']")
	WebElement lnkhoverMemberLiability;
	@FindBy(xpath="//div[@class='smartInfoMain']")
	WebElement lnkhoverMemberliabilitytext;

	public boolean checkhoverMemberLiability() throws InterruptedException
	{
		String Procedurecode=null;
		if(this.clicklnkLineDetails())
		{

			Actions action=new Actions(Driver.getPgDriver());
			action.moveToElement(this.lnkhoverMemberLiability).build().perform();
			Procedurecode=this.lnkhoverMemberliabilitytext.getText();
			System.out.println("The value of attribute is : "+Procedurecode);
		}		 

		return true;

	}

	@FindBy(xpath="//div[@node_name='ClaimLineDetails']//label[@for='DiagnosisClassCode']/parent::div//span")
	WebElement lnkDiagnosisClassCode;
	@FindBy(xpath="//div[@node_name='ClaimLineDetails']//label[@for='name']/parent::div//span")
	WebElement lnkDiagnosisCodes;
	@FindBy(xpath="//td[@data-attribute-name='Diagnosis Code']")
	WebElement lnkDiagnosisCodepopup;

	@FindBy(xpath="//div[@node_name='ClaimLineDetails']//label[@for='ReasonCode']/parent::div//span")
	WebElement lnkReasonCode;

	@FindBy(xpath="//div[@role='alert']//span")
	WebElement lnkDiagnosisClasspopup;
	@FindBy(xpath="//td[@data-attribute-name='code']")
	WebElement lnkReasonCodepopup;


	public boolean validateDiagnosisClassCode()
	{
		if(this.clicklnkLineDetails())
		{
			if(utils.clickAnelemnt(this.lnkLineDetailsRow1, "linedetails", "row1"))
			{
				System.out.println("Line1 is expanded");

				if(this.lnkDiagnosisCodes.isDisplayed())
				{

					String parentHandle = Driver.pgDriver.getWindowHandle(); // get the current window handle 
					System.out.println("Current Window Handle: "+parentHandle); 		 

					utils.clickAnelemnt(this.lnkDiagnosisCodes, "linedetails", "DiagnosisClassCode");
					System.out.println("Diagnosis Class Code is selected");
					Set<String> allwindowhandles= Driver.pgDriver.getWindowHandles();
					while(allwindowhandles.size()==1)
					{
						allwindowhandles= Driver.pgDriver.getWindowHandles(); 
						System.out.println("count"+allwindowhandles.size());
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
							System.out.println("Current Window Handle: "+winHandle); 
							if(this.lnkDiagnosisCodepopup.isDisplayed())
							{
								String value=this.lnkDiagnosisCodepopup.getText();
								System.out.println("Value is:" +value);

							}

							String title=Driver.pgDriver.getTitle();
							System.out.println("Page Title is " +title);
							if(title.contains("Diagnosis Code(s)"))
							{
								System.out.println("Page title is Matching : "+title);
							}
							else
							{
								err.logError("Review Pop up Window", "Title ");
								return false;
							}

						}
					}
				}
				else
				{
					System.out.println("Diagnosis Class Code Link is not displayed");
					return false;
				}

			}
			else
			{
				System.out.println("Line Details Row1 is not present");
				return false; 
			}

		}
		return true;

	}

	public boolean validateDiagnosisCode() throws InterruptedException
	{
		if(this.clicklnkLineDetails())
		{
			if(utils.clickAnelemnt(this.lnkLineDetailsRow1, "linedetails", "row1"))
			{
				System.out.println("Line1 is expanded");

				if(this.lnkDiagnosisCodes.isDisplayed())
				{

					String parentHandle = Driver.pgDriver.getWindowHandle(); // get the current window handle 
					System.out.println("Current Window Handle: "+parentHandle); 		 

					utils.clickAnelemnt(this.lnkDiagnosisCodes, "linedetails", "DiagnosisClassCode");

					System.out.println("Diagnosis Class Code is selected");
					Set<String> allwindowhandles= Driver.pgDriver.getWindowHandles();
					while(allwindowhandles.size()==1)
					{
						allwindowhandles= Driver.pgDriver.getWindowHandles(); 
						System.out.println("count"+allwindowhandles.size());
					}

					for(String winHandle : Driver.pgDriver.getWindowHandles()) 
					{ 
						if(winHandle.equalsIgnoreCase(parentHandle)) 
						{
							System.out.println("Current Window Handle same as parent: "+winHandle); 

						}
						else
						{

							Driver.pgDriver.switchTo().window(winHandle);
							System.out.println(Driver.pgDriver.getTitle());
							System.out.println("Current Window Handle: "+winHandle); 

							if(this.lnkDiagnosisCodepopup.isDisplayed())
							{
								String value=this.lnkDiagnosisCodepopup.getText();
								System.out.println("Value is:" +value);
							}
							String title=Driver.pgDriver.getTitle();
							System.out.println("Page Title is " +title);
							if(title.contains("Diagnosis Code(s)"))
							{
								System.out.println("Page title is Matching : "+title);
							}
							else
							{
								err.logError("Review Pop up Window", "Title ");
								return false;
							}
						}
					}

				}
				else
				{
					System.out.println("Diagnosis Class Code Link is not displayed");
					return false;
				}

			}
			else
			{
				System.out.println("Line Details Row1 is not present");
				return false; 
			}

		}
		return true;
	}

	public boolean validateReasonCode() throws InterruptedException
	{
		if(this.clicklnkLineDetails())
		{
			if(utils.clickAnelemnt(this.lnkLineDetailsRow1, "linedetails", "row1"))
			{
				System.out.println("Line1 is expanded");

				if(this.lnkReasonCode.isDisplayed())
				{
					String parentHandle = Driver.pgDriver.getWindowHandle(); // get the current window handle 
					System.out.println("Current Window Handle: "+parentHandle); 		 
					utils.clickAnelemnt(this.lnkReasonCode, "linedetails", "ReasonCode");
					System.out.println("Reason Code is selected");
					Set<String> allwindowhandles= Driver.pgDriver.getWindowHandles();
					while(allwindowhandles.size()==1)
					{
						allwindowhandles= Driver.pgDriver.getWindowHandles(); 
						System.out.println("count"+allwindowhandles.size());
					}

					for(String winHandle : Driver.pgDriver.getWindowHandles()) 
					{ 
						if(winHandle.equalsIgnoreCase(parentHandle)) 
						{
							System.out.println("Current Window Handle same as parent: "+winHandle); 
						}
						else
						{
							Driver.pgDriver.switchTo().window(winHandle);
							System.out.println(Driver.pgDriver.getTitle());
							System.out.println("Current Window Handle: "+winHandle); 

							if(this.lnkReasonCodepopup.isDisplayed())			                        {
								String value=this.lnkReasonCodepopup.getText();
								System.out.println("Value is:" +value);

							}

							String title=Driver.pgDriver.getTitle();
							System.out.println("Page Title is " +title);
							if(title.contains("Reason Code(s)"))
							{
								System.out.println("Page title is Matching : "+title);
							}
							else
							{
								err.logError("Review Pop up Window", "Title ");
								return false;
							}

						}
					}
				}

				else
				{
					System.out.println("Reason Code Link is not displayed");
					return false;
				}

			}
			else
			{
				System.out.println("Line Details Row1 is not present");
				return false; 
			}

		}
		return true;

	}


	/*
	 * String Manuplation and use of the elements from the screen 
	 */
	static int count =0;

	/**
	 * Willl hover and Read the Qtip from the Hovered area
	 * 
	 * 
	 * PS: Since no good soln to tool tip is available in Selenium I have used a work around which will work. 
	 * @param el : It is the element that needs to be hovered over for the tool tip 
	 * @return
	 * @throws InterruptedException 
	 */
	public String checkValueQTip(WebElement el) throws InterruptedException
	{

		String str= null, str1= null;
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("scroll(0, 500);");
		Actions builder = new Actions(Driver.getPgDriver());
		builder.moveToElement(el);
		builder.build().perform();
		Thread.sleep(3000);
		String sValue= this.valueFromInfo(el.getText());
		String sXpath="//*[contains(@aria-label,'"+sValue.trim()+"')]";

		try
		{
			str= Driver.pgDriver.findElement(By.xpath(sXpath)).getText();

			str1= Driver.pgDriver.findElement(By.xpath(sXpath)).getAttribute("aria-label");
		}
		catch(NoSuchElementException e)
		{

			count++;
			if(count<=3)
			{checkValueQTip(el);}
		}
		System.out.println("The hovered Element : "+ str);
		System.out.println("The value of attribute is : "+ str1);
		return str;
	}





	/**
	 * Will extract the value from the table and remove the "." characters 
	 * 
	 * @param str : Will contain the string friom the table 
	 */
	public String valueFromInfo(String str)
	{
		char[] myNameChars = str.toCharArray();
		for(int i = 0;i <str.length(); i ++)
		{
			int j = (int)str.charAt(i);
			if((j>=48) && (j<=57) || (j>64) && (j<=90) || (j>=97) && (j<=122))
			{
				continue;
			}
			else 
			{
				myNameChars[i]=' ';
			}
		}

		str=String.valueOf(myNameChars);
		System.out.println(str.trim()+ ": The Value is ");
		return str;
	}

	public boolean checkIfEmptyonPatientDetails()
	{

		if(utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand"))
		{
			utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand");

			Assert.assertEquals(true,!this.lnkPntDTableFullName.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPntDTableDateOfBirth.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPntDTablePatientAccountNumber.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPntDTableRelationship.getText().isEmpty());
			System.out.println("The fields are displayed with values" );
			return true;
		}
		System.out.println("Fails: One of the field is empty");
		return false;
	}

	public boolean checkIfEmptyonPaymentDetails()
	{

		if(utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand"))
		{
			utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand");

			Assert.assertEquals(true,!this.lnkPDTableCheckAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPDTableCheckIssueDate.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPDTableCheckNumber.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPDTablePayee.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPDTableCheckAddress.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPDTableCheckStatus.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPDTableCheckStatusDate.getText().isEmpty());
			System.out.println("All the fields are displayed with values");
			return true;
		}
		System.out.println("Fails: One of the field is empty");
		return false;
	}

	public boolean checkIfEmptyonClaimDetails()
	{

		if(utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand"))
		{
			utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand");

			Assert.assertEquals(true,!this.lnkCDTableClaimID.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkCDTableMemberCode.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkCDTableSCCF.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkCDTaleContractCode.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableAdjustedSCCF.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableITS.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTablePaidAs.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableDiagnosisCode.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableProcessedDate.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableReceivedDate.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableClaim.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableERISA.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableIPA.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTablePMG.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableAuthorisationNumber.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableOriginalClaimNumber.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableClaimImageNo.getText().isEmpty());
			//			
			System.out.println("All the fields are displayed with values");
			return true;
		}
		System.out.println("Fails: One of the field is empty");
		return false;
	}

	public boolean checkIfEmptyonClaimCalculations() throws InterruptedException
	{

		if(utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand"))
		{
			utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand");
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@param_name,'ClaimSummaryDetailsMutiLevelBB')]//label[contains(@for,'ServiceFromDate')]/parent::div//span")));

			Assert.assertEquals(true,!this.lnkCDTableServiceFromDate.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkCDTableServiceToDate.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkCDTableTotalChargedAmount.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkCDTableAllowedAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableProviderWriteOffAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTablePaidAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableHRAStartingBalance.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableHRAEndingBalance.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableHRAPaidAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkCDTableMemberLiabilityAmount.getText().isEmpty());

			System.out.println("All the fields are displayed with values");
			return true;
		}
		System.out.println("Fails: One of the field is empty");
		return false;
	}

	public boolean checkIfAnyFieldsAreEmpty() 
	{

		if(utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand"))
		{
			utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand");
			try
			{
				Assert.assertEquals(true,!this.lnkCDTableContainsSpace.getText().isEmpty());		
				System.out.println("Fails: One of the field is empty");
				return false;
			}
			catch(Exception e)
			{
				System.out.println("Pass: All the fileds contains value");
				return true;
			}
		}
		return true;
	}

	public boolean checkIfEmptyonRenderingProviderDetails()
	{

		if(utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand"))
		{
			utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand");

			Assert.assertEquals(true,!this.lnkRPDOrganizationName.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkRPDTaxonomyCode.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkRPDNationalProviderIdentfier.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkRPDPhoneNumber.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkRPDAddressLine1.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkRPDPlanNetworkNumber.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPRDNetworkID.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPRDType.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkPRDPrimarySpeciality.getText().isEmpty());

			System.out.println("All the fields are displayed with values");
			return true;
		}
		System.out.println("Fails: One of the field is empty");
		return false;
	}

	public boolean checkIfEmptyonMedicare()
	{

		if(utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand"))
		{
			utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand");

			Assert.assertEquals(true,!this.lnkMedicarepyMediCrossOver.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkMedicareAssignmentCode.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkMedicarepyMedicareHicNumber.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkTotalMedicareAllowedAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkTotalMedicareCoinsuranceAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkTotalMedicareDeductibleAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkTotalMedicarePaidAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkTotalMedicareNonCoveredAmount.getText().isEmpty());
			Assert.assertEquals(true,!this.lnkTotalMedicareProviderWriteOffAmount.getText().isEmpty());

			System.out.println("All the fields are displayed with values");
			return true;
		}
		System.out.println("Fails: One of the field is empty");
		return false;
	}

	public boolean checkIfEmptyonOtherInsurance()
	{

		if(utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand"))
		{
			utils.clickAnelemnt(this.lnkExpand, "claimsdetails", "expand");
			Assert.assertEquals(true,!this.lnkTotalOtherInsuranceAllowedAmount.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkTotalOtherInsurancePaidAmount.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkCOBIndicator.getText().isEmpty());			
			Assert.assertEquals(true,!this.lnkWorkersCompensationIndicator.getText().isEmpty());
			System.out.println("All the fields are displayed with values");
			return true;
		}
		System.out.println("Fails: One of the field is empty");
		return false;
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions ') or contains(text(),'Other Actions ')]")
	WebElement btnOtherActions;

	@FindBy(xpath="//*[@class='menu-item-title'][text()='Search for Image']")
	WebElement lnkSearchForClaimImage;

	@FindBy(xpath="//input[contains(@id,'DCN')]")
	WebElement setTxtCMDocumentControlNumber;

	@FindBy(xpath="//input[contains(@id,'MEMBERCERTNUM')]")
	WebElement setTxtCMMemberNumber;

	@FindBy(xpath="//input[contains(@id,'ClaimNumber')]")
	WebElement setTxtCMClaimNumber;

	@FindBy(xpath="//input[contains(@id,'INQID')]")
	WebElement setTxtCMInquiryId;

	@FindBy(xpath="//input[contains(@id,'ITSSerial')]")
	WebElement setTxtCMItsSccf;

	@FindBy(xpath="//input[contains(@id,'F_DOCNUM')]")
	WebElement setTxtCMDocumentId;

	public boolean clickonOtherAction()
	{
		return utils.clickAnelemnt(this.btnOtherActions, "Manage Claims ", "Other Actions ");
	}

	public boolean clickonSearchForClaimImage()
	{
		return utils.clickAnelemnt(this.lnkSearchForClaimImage, "Manage Claims ", "Search For Claim Image ");
	}

	public boolean settxtCmDcn(String sCCBID)
	{
		return utils.enterTextinAnelemnt(this.setTxtCMDocumentControlNumber, sCCBID, "Manage Claim", "DCN");

	}
	public boolean settxtCmMemberNo(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.setTxtCMMemberNumber, sCCBID, "Manage Claim", "DCN");

	}
	public boolean settxtCmClaimNo(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.setTxtCMClaimNumber, sCCBID, "Manage Claim", "DCN");

	}
	public boolean settxtCmInquiryid(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.setTxtCMInquiryId, sCCBID, "Manage Claim", "DCN");

	}
	public boolean settxtCmItsSccf(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.setTxtCMItsSccf, sCCBID, "Manage Claim", "DCN");

	}
	public boolean settxtCmDocumentId(String sCCBID)
	{

		return utils.enterTextinAnelemnt(this.setTxtCMDocumentId, sCCBID, "Manage Claim", "DCN");

	}

	public boolean searchForClaimImage() 
	{
		if(clickonOtherAction())
			return clickonSearchForClaimImage();
		return false;
	}

	@FindBy(xpath="//table[@pl_prop='ClmImageList.pxResults']")
	public WebElement SearchResultsTable;

	public boolean EnterClaimImageFiltersforSearch(String[] imageFilters)
	{
		String[] s=null;
		for(int i=0;i<imageFilters.length;i++)
		{

			if(imageFilters[i].toLowerCase().contains("dcn"))
			{
				String s1=imageFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s=new String[]{s1};

				if( this.settxtCmDcn(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (imageFilters[i].toLowerCase().contains("member"))
			{
				String s1=imageFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s=new String[]{s1};

				if(this.settxtCmMemberNo(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (imageFilters[i].toLowerCase().contains("claim"))
			{
				String s1=imageFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s=new String[]{s1};

				if(this.settxtCmClaimNo(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (imageFilters[i].toLowerCase().contains("inquiry"))
			{
				String s1=imageFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s=new String[]{s1};

				if(this.settxtCmInquiryid(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (imageFilters[i].toLowerCase().contains("sccf"))
			{
				String s1=imageFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s=new String[]{s1};

				if(this.settxtCmItsSccf(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (imageFilters[i].toLowerCase().contains("document"))
			{
				String s1=imageFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s=new String[]{s1};

				if(this.settxtCmDocumentId(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (imageFilters[i].toLowerCase().contains("npi"))
			{
				String s1=imageFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				s=new String[]{s1};

				if(this.settxtBxNationalProviderIdentification(s1))
				{

					continue;
				}
				else
					break;
			}	
		}

		if(this.clickSearch2())
		{
			System.out.println("Pass : Search With CustomDate Successful ");
			return true;
		}
		return true;
	}

	public boolean validateRowValuesinClaimImageSearch(String[] tablevalues)
	{
		return utils.validateRowValues(this.SearchResultsTable,tablevalues);
	}


	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchClaimNumber
	 * #Description:This method performs search by Claim Number in Manage Claims page and verifies Claim details are opened. 
	 * #Arguments:Claim Number
	 * Type:TextBox
	 */
	public boolean searchClaimNumber(String[] args) 
	{
		if(this.clickrdBtnClaimNumber())
		{		
			if(this.settxtBxClaimNumber(args[0]))
			{
				if(utils.clickAnelemnt(this.BtnSearch, "ManageClaims", "Search Button"))
				{

					System.out.println("Pass : Search With Claim Number Successful ");
					return true;
				}
				else
				{
					System.out.println("Fail : Search With Claim Number Not successful");
				}
			}
		}

		else
		{
			System.out.println("Fail : Claim Number Search button is not clicked");
		}
		return true;
	}

	@FindBy(id="DialogContent")
	private WebElement msgOnEmpowermentDialog;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateEmpowermentDialogInClaims
	 * #Description:This method validates if Empowerment message is displayed in a Guided dialog in View Claims page. 
	 * Type:TextBox
	 */
	public boolean validateEmpowermentDialogInClaims(){
		utils.waitforpageload();
		String expectedMsg ="This claim meets the Anthem Empowerment Guidelines for an Out Of Network Doctor. Go to the authorization task to check for an approved Inpatient preauthorization for the date of service. If there is an approved preauthorization for the date of service the claim can be adjusted. When sending the claim for adjustment add a note � Meets AEG for OON Doctor to be adjusted and process as an INN claim.";
		try{
			String msg = this.msgOnEmpowermentDialog.getText().trim();
			String empowermentMsg = msg.substring(msg.indexOf("\n")+2);
			if(empowermentMsg.trim().equalsIgnoreCase(expectedMsg.trim())){
				System.out.println("Message verified - on View Claims page"+empowermentMsg);
				return true;
			}else{
				System.out.println("Message doesnt match on View Claims page"+empowermentMsg);
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve Empowerment message, on 'on View Claims page"+e);
		}

		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateNoEmpowermentDialogInClaims
	 * #Description:This method validates if no Empowerment message is displayed in a Guided dialog in View Claims page. 
	 * Type:TextBox
	 */
	public boolean validateNoEmpowermentDialogInClaims(){
		utils.waitforpageload();
		String expectedMsg ="This claim meets the Anthem Empowerment Guidelines for an Out Of Network Doctor. Go to the authorization task to check for an approved Inpatient preauthorization for the date of service. If there is an approved preauthorization for the date of service the claim can be adjusted. When sending the claim for adjustment add a note � Meets AEG for OON Doctor to be adjusted and process as an INN claim.";
		try{
			String msg = this.msgOnEmpowermentDialog.getText().trim();
			String empowermentMsg = msg.substring(msg.indexOf("\n")+2);
			if(empowermentMsg.trim().equalsIgnoreCase(expectedMsg.trim())){
				System.out.println("Message verified - on View Claims page"+empowermentMsg);
				return false;
			}else{
				System.out.println("Message doesnt match - Empowerment message isnt displayed on View Claims page"+empowermentMsg);
			}
		}catch(Exception e){
			System.out.println("Unable to retrieve Empowerment message, on 'on View Claims page"+e);
		}

		return true;
	}

	public boolean clickClaimSearch()
	{
		return utils.clickAnelemnt(this.BtnSearch, "Manage Claims", "Search Button");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: searchByClaimNumnber
	 * #Description: This functionality clicks the search by claim number radio button and enters the claim number and then clicks the search button.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean searchByClaimNumber(String[] args)
	{
		utils.waitforpageload();
		if(this.clickrdBtnClaimNumber())
		{
			if(this.settxtBxClaimNumber(args[0]))
			{
				if(this.clickClaimSearch())
				{         
					System.out.println("Pass : Search With Claim Number Successful ");
					utils.waitforpageload();
					return true;
				}
				else
				{
					System.out.println("Fail : Search With Claim Number Not successful");
				}
			}
		}

		else
		{
			System.out.println("Fail : Claim Number Search button is not clicked");
		}
		return true;

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
		if(this.enterStartDate(date[0]))
		{
			if(this.enterEndDate(date[1]))
			{
				System.out.println("Dates Entered");
				return true;
			}
		}
		err.logError("ManageClaims", "Start and End Date Entered Failing");
		return false;

	}

	@FindBy(xpath="//div[@node_name='HCClaimSearchMemEntryFields']//div[contains(text(),'Search')]")
	WebElement btnSearch;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickBtnSearch
	 * #Description: This functionality clicks the search button in the Manage Claims page after user gives the input.
	 * Type:Textbox
	 */
	public boolean clickBtnSearch()
	{
		WebElement element = Driver.pgDriver.findElement(By.xpath("//div[@node_name='HCClaimSearchMemEntryFields']//div[contains(text(),'Search')]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		return utils.clickAnelemnt(this.btnSearch, "ManageClaims", "Search");
	}

	@FindBy(id="CheckReviewForContact1")
	WebElement chkBxFirstRow;

	public boolean clickFirstRowInClaims()
	{
		return utils.clickAnelemnt(this.chkBxFirstRow, "ManageClaims", "First Row Checkbox");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickBtnSubmit
	 * #Description: This functionality clicks the submit button in the Manage Claims page.
	 * Type:Textbox
	 */
	public boolean clickBtnSubmit() throws InterruptedException
	{

		utils.scrolltomiddle();
		action.moveToElement(BtnSubmit);
		/*WebElement element = Driver.pgDriver.findElement(By.xpath("//div[contains(text(),'Submit')]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);*/
		return utils.clickAnelemnt(this.btnSubmit, "ManageClaims", "Submit");

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickTheClaimCheckbox
	 * #Description: This functionality clicks the check box of the given claim number in the claim results section.
	 * #Argument: claimlast4num
	 * Type:Textbox
	 */
	public boolean clickTheClaimCheckbox(String[] claimlast4num) throws InterruptedException
	{
		Thread.sleep(2000);
		String substr = claimlast4num[0];
		WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='D_ClaimSearchResults.HCMemberClaimDetails']"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		String tempxpath = "//table[@pl_prop='D_ClaimSearchResults.HCMemberClaimDetails']//following-sibling::tr/td/div/parent::td[@data-attribute-name='Claim<br/>Number']/div/span/a[text()='"+substr+"']/parent::span/parent::div/parent::td/parent::tr/td/div/input[@type='checkbox']";
		System.out.println("Temp Xpath is: "+tempxpath);
		Driver.pgDriver.findElement(By.xpath(tempxpath)).click();
		Thread.sleep(2000);
		return true;
	}



	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateManageClaims
	 * #Description: This functionality validates the values given by the user with the value present in the table and checkd the claim check box
	 * #Argument: ManageClaimsTable
	 * Type: Table
	 * keys: first date#last date#claim number#billing provider#rendering provider#claim type#total charged amount#received date#processed date#action code#paid date#paid amount#member liablity
	 */


	@FindBy(xpath="//table[@pl_prop='D_ClaimSearchResults.HCMemberClaimDetails']")
	WebElement tblManageClaimsSearchResults;

	public boolean validateManageClaims(String[] args)
	{
		boolean returnvar =true;
		String firstdate= null,lastdate= null, claimnumber = null, billingprovider= null, renderingprovider= null, claimtype= null,totalchargedamount= null,receiveddate=null, processeddate=null,actioncode=null,paiddate=null, paidamount=null, memberliability=null;
		ArrayList<String> expected= new ArrayList<String>();
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateAccumulatorInfoMemberLevel", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("first date"))
			{                    
				returnvar=true;
				firstdate=value.toLowerCase().trim();                      
				continue;

			}
			else if(key.toLowerCase().contains("last date"))
			{
				returnvar=true;
				lastdate=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("claim number"))
			{
				returnvar=true;
				claimnumber=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("billing provider"))
			{
				returnvar=true;
				billingprovider=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("rendering provider"))
			{
				returnvar=true;
				renderingprovider=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("claim type"))
			{
				returnvar=true;
				claimtype=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("total charged amount"))
			{
				returnvar=true;
				totalchargedamount=value.toLowerCase().trim();
				continue;

			}
			else if(key.toLowerCase().contains("received date"))
			{
				returnvar=true;
				receiveddate=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("processed date"))
			{
				returnvar=true;
				processeddate=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("action code"))
			{
				returnvar=true;
				actioncode=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("paid date"))
			{
				returnvar=true;
				paiddate=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("paid amount"))
			{
				returnvar=true;
				paidamount=value.toLowerCase().trim();
				continue;
			}
			else if(key.toLowerCase().contains("member liability"))
			{
				returnvar=true;
				memberliability=value.toLowerCase().trim();
				continue;
			}
			else
			{
				err.logcommonMethodError("ManageClaims", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		if(returnvar)
		{
			System.out.println("No issues in Key value pair");
		}

		try{
			System.out.println("Enterd into Try block");
			WebElement element = this.tableSearchResult;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row =utils.getTablerowbasedonvalues(this.tableSearchResult,args);
			List<WebElement> rowNo = row.findElements(By.tagName("input"));
			rowNo.get(1).click();
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
		}

		if(!returnvar)
		{

			System.out.println("Matching rows not found for given input");      
			return false;
		}
		return true;

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickLnkPriorYear
	 * #Description: This functionality clicks the prior year link in the Manage Claims page
	 * Tupe: Textbox
	 */

	public boolean clickLnkPriorYear() throws InterruptedException
	{
		WebElement element = Driver.pgDriver.findElement(By.xpath("//a[contains(text(),'Prior Year')]"));
		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
		return utils.clickAnelemnt(this.lnkPriorYear , "Manage claims", "lnkPriorYear");
	}

	@FindBy(xpath="//table[contains(@pl_prop,'ClmImageList.pxResults')]")
	WebElement tableresult2;

	public boolean clickSearch2()
	{
		if(utils.clickAnelemnt(this.BtnSearch, "ManageClaims", "Search Button"))
		{
			try
			{
				wait=new WebDriverWait(Driver.pgDriver,15);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'ClmImageList.pxResults')]")));
				if(this.tableresult2.isDisplayed())
				{
					return true; 	 
				}
				else
				{
					clickSearch2();
				}
			}
			catch(Exception e)
			{
				return false;
			}
		}
		else
			return false;

		return false;

	}

	@FindBy(xpath="//img[@data-test-id='2018021318012803091105119']")
	private WebElement hoverImgGAIcon;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyHoverTextForGrievanceAndAppealsIconInManageClaims
	 * #Description:This method validates the hover text displayed on hovering Grievance and Appeals Icon in Manage Claims Page
	 * Type:Textbox
	 */
	public boolean verifyHoverTextForGrievanceAndAppealsIconInManageClaims(){
		try{
			this.hoverImgGAIcon.click();
			String hovertext=this.hoverImgGAIcon.getAttribute("data-hover").toString().toLowerCase();
			System.out.println(hovertext);
			if(hovertext.contains("grievance and appeal")){
				blogger.loginfo("verifyHoverTextForGrievanceAndAppealsIconInManageClaims successful in Manage Claims page");
				return true;
			}else{
				blogger.loginfo("HoverText isnt displayed for GrievanceAndAppealsIcon in Manage Claims page");
				return false;
			}
		}catch(Exception e){
			err.logcommonMethodError("Manage Claims","verifyHoverTextForGrievanceAndAppealsIconInManageClaims"+e);
			blogger.loginfo("Exception occured in Manage Claims - verifyHoverTextForGrievanceAndAppealsIconInManageClaims"+e);
			return false;
		}
	}

	@FindBy(xpath="//table[@pl_prop='D_ClaimSearchResults.HCMemberClaimDetails']")
	private WebElement ClaimResultsTable;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateGAIndicatorInManageClaims
	 * #Description:This method verifies 'Grievance and Appeals indicator' and 'Claim Discussed With Contact' for a 'Claim Number' is autochecked
	 * #Arguments:ManageClaims-GAKey
	 * Type:Textbox
	 */
	public boolean validateGAIndicatorInManageClaims(String args[]){
		try{
			wait=new WebDriverWait(Driver.pgDriver,25);
			String claimlast4=args[0].substring(9);
			claimlast4="..."+claimlast4;
			utils.clickAnelemnt(this.tableSearchResult, "Manage Claims", "ClaimsTaggedForGA");
			String tempxpath="//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']";
			System.out.println(tempxpath);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempxpath)));
			WebElement img = Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']//ancestor::td[@headers='a8']//preceding-sibling::td[@headers='a5']//img"));
			if(img.isDisplayed()){
				blogger.loginfo("Claim has Grievance and/ or Appeal checkbox is checked");
				return true;
			}else{
				blogger.loginfo("Claim has Grievance and/ or Appeal checkbox isnt checked");
				err.logError("Unable to verify - validateGAIndicatorInManageClaims");
				return false;
			}
		}
		catch (Exception e){
			System.out.println("Unable to verify - Claims Tagged For GA - Grievance and Appeal is not checked"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateClaimDiscussedWithContactInManageClaims
	 * #Description:This method selects Claim Discussed With Contact indicator for a 'Claim Number' depending on the ClaimNumber
	 * #Arguments:ManageClaims
	 * Type:Textbox
	 */
	public boolean validateClaimDiscussedWithContactInManageClaims(String args[]){
		try{
			wait=new WebDriverWait(Driver.pgDriver,25);
			String claimlast4=args[0].substring(9);
			claimlast4="..."+claimlast4;
			utils.clickAnelemnt(this.tableSearchResult, "Manage Claims", "ClaimsTagged");
			String tempxpath="//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']";
			System.out.println(tempxpath);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempxpath)));
			WebElement img = Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//span/a[text()='"+claimlast4+"']//ancestor::td[@headers='a8']//preceding-sibling::td//input[contains(@id,'CheckReviewForContact')][@checked]"));
			if(img.isDisplayed()){
				blogger.loginfo("Claim Discussed With Contact CheckBox is checked");
				return true;
			}else{
				blogger.loginfo("Claim Discussed With Contact CheckBox isnt checked");
				err.logError("Unable to verify - validateClaimDiscussedWithContactInManageClaims");
				return false;
			}
		}
		catch (Exception e){
			System.out.println("Unable to verify - ClaimDiscussedWithContact is not checked"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectClaimDiscussedWithContactInManageClaims
	 * #Description:This method selects Claim Discussed With Contact indicator for a 'Claim Number' depending on the claim number
	 * #Arguments:ClaimNumber
	 * Type:Textbox
	 */
	public boolean selectClaimDiscussedWithContactInManageClaims(String args[]){
		try{
			utils.waitforpageload();
			//wait=new WebDriverWait(Driver.pgDriver,25);
			//String claimlast4=args[0].substring(9);
			//claimlast4="..."+claimlast4;
			//ArrayList<String> claimNumberColumn = new ArrayList<String>();
			//System.out.println("-----> modified claim number "+args[0]);
			String tempxpath="//table[@class='gridTable ']//span/a[text()='"+args[0]+"']";
			System.out.println(tempxpath);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tempxpath)));
			Driver.pgDriver.findElement(By.xpath("//table[@class='gridTable ']//span/a[contains(text(),'"+args[0]+"')]/parent::span/parent::div/parent::td/parent::tr//input[@data-ctl='Checkbox']")).click();
			blogger.loginfo("Claim Discussed With Contact CheckBox is checked");
			return true;	
		}
		catch (Exception e){
			System.out.println("Unable to select - Claim Discussed With Contact CheckBox"+e);
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in 'Manage Claims' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmit() throws InterruptedException{
		Thread.sleep(5000);
		utils.scrolltomiddle();
		WebElement element = Driver.pgDriver.findElement(By.xpath("//*[@class='pzbtn-mid'][text()='Submit']"));
		JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		executor.executeScript("arguments[0].click();", element);
		//		return utils.clickAnelemnt(this.btnSubmit,"ManageClaims","Submit Button");
		return true;
	}

	public boolean validatemanageClaims(String[] args)
	{
		utils.waitForElementToBeVisible(tblManageClaimsSearchResults);
		String key = args[0].substring(0, args[0].indexOf(":"));
		String value = args[0].substring(args[0].indexOf(":")+1);
		String[] val = {key+":"+value};
		try{
			System.out.println("Enterd into Try block");
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='D_ClaimSearchResults.HCMemberClaimDetails']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row =utils.getTablerowbasedonvalues(this.tblManageClaimsSearchResults,val);
			List<WebElement> rowNo = row.findElements(By.tagName("input"));
			rowNo.get(1).click();
			return true;
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input in Member Level" + e);
			return false;
		}


	}

	@FindBy(xpath="(//img[@data-test-id='20160127122348051611158'])[3]")
	WebElement imgOneDayGrievance;

	public boolean verifyClaimHasOneDayGrievanceIndicatorIsDisplayed()
	{
		try
		{
			WebElement table = this.tblManageClaimsSearchResults;
			WebElement imgOneDayGrievance = Driver.pgDriver.findElement(By.xpath("(//table[@pl_prop='D_ClaimSearchResults.HCMemberClaimDetails']//img[@data-test-id='20160127122348051611158'])[3]"));
			if(this.imgOneDayGrievance.isDisplayed())
			{
				blogger.loginfo("One Day Grievance Indicator is displayed");
				System.out.println("One Day Grievance Indicator is displayed");
				return true;
			}else
			{
				blogger.loginfo("One Day Grievance Indicator is not displayed");
				System.out.println("One Day Grievance Indicator is not displayed");
				return false;
			}
		}catch(Exception e)
		{
			err.logcommonMethodError("ManageClaims", "verifyClaimHasOneDayGrievanceIndicatorIsDisplayed");
			return false;
		}
	}

	@FindBy(xpath="//span[starts-with(text(),'One or more')]")
	WebElement txtAccessMessage;


	public boolean verifyIfAccessRestrictionErrorMessageIsDisplayed()
	{
		String actualMsg = "One or more restricted claim exists. Connect the contact to Anthem House Account Customer Service at (855) 847-5829 for any questions specific to restricted claims.";
		String expectedMsg = txtAccessMessage.getText();
		if(actualMsg.equalsIgnoreCase(expectedMsg))
		{
			blogger.loginfo("Access Restricted Msg is displayed and it matched");
			System.out.println("Access Restricted Msg is displayed and it matched");
			return true;
		}else
		{
			blogger.loginfo("Access Restricted Msg is displayed and it not matched");
			System.out.println("Access Restricted Msg is displayed and it not matched");
			return false;
		}
	}

	@FindBy(id="CheckReviewForContact3")
	WebElement chkBxRestrictedClaimNumber;

	public boolean clickOnRestrictedClaim()
	{
		return utils.clickAnelemnt(chkBxRestrictedClaimNumber, "ManageClaims", "Check box for Claim");
	}


	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;

	@FindBy(id="CancellationReason")
	WebElement drpdwnCancellationreason;

	public boolean CancelThisWork(String[] cancelreason)
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Review Billing", "Other Actions Button"))
			if(utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Review Billing", "Cancel this Work"))
				if(utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, cancelreason[0], "Cancel Billing", "Cancel reason"))
					if(utils.clickAnelemnt(this.btnSubmit, "cancel Billing", "Submit button on cancel billing"))
						return true;
		return false;
	}

	@FindBy(xpath="//div[@class='smarttip-content']")
	WebElement HoverTextForClaimsIteration;

	/**This functionality validates the Claims Iteration Hover values in the Search Claims Table in Search Claims Page 
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean validateClaimsIterationHover(String[] args) throws InterruptedException {
		utils.waitforpageload();
		action.moveToElement(tblManageClaimsSearchResults);
		String[] tablevalues = args[0].split("-");
		String[] value = args[1].split(":");
		WebElement row = utils.returntablerowbasedonvalues(tblManageClaimsSearchResults, tablevalues);
		WebElement rowNo= row.findElement(By.xpath(".//td//span//span[@data-test-id='201602040633480459100561']"));
		action.moveToElement(rowNo).build().perform();
		Thread.sleep(1000);
		String actual = HoverTextForClaimsIteration.getText();
		return utils.isvalueMatch_contain(actual, value[1]);
	}

	/**This functionality navigates to the SearchClaimsImage page by clicking other actions button  and the SearchClaimsImage button
	 * 
	 * @return
	 */
	public boolean navigatetoSearchClaimsImage() {
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Search for Image", "Manage Claims", "btnOtherActions");
	}

	public boolean verifyClaimIsTaggedForRefundRequest(String[] args) throws InterruptedException
	{
		WebElement row = utils.returntablerowbasedonvalues(tblManageClaimsSearchResults, args);
		List<WebElement> rowNo = row.findElements(By.tagName("td"));
		action.moveToElement(rowNo.get(7));
		if(rowNo.get(7).isSelected())
			return true;
		return false;

	}

	//Compare Claims

	public boolean validateTheClaimDetailsAndClickCompareClaimsChckBx(String[] args) throws InterruptedException
	{
		Thread.sleep(3000);
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblManageClaimsSearchResults, args);
			List<WebElement> rowNo = row.findElements(By.tagName("input"));
			rowNo.get(3).click();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}


	@FindBy(xpath="//table[@pl_prop='D_ClaimSearchResults.HCMemberClaimDetails']")
	WebElement tblManageClaimsSearchResultsRow;


	public boolean validateTheClaimsAndExpandTheRow(String[] args) throws InterruptedException
	{
		Thread.sleep(5000);
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblManageClaimsSearchResultsRow, args);
			List<WebElement> rowNo = row.findElements(By.tagName("td"));
			rowNo.get(0).click();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@FindBy(xpath="//table[@pl_prop='.ClaimDetailsSublist']")
	WebElement tblManageClaimsSubList;

	public boolean validateTheClaimDetailsAndClickCompareClaimsChckBxInSubList(String[] args) throws InterruptedException
	{
		Thread.sleep(3000);
		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblManageClaimsSubList, args);
			List<WebElement> rowNo = row.findElements(By.tagName("input"));
			rowNo.get(3).click();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}



	@FindBy(xpath="//button[@data-test-id='20161121195924019792203']")
	WebElement btnCompareClaims;

	@FindBy(xpath="(//span[@data-test-id='20160128042601028824550'])[1]")
	WebElement labelClaimOne;

	@FindBy(xpath="(//span[@data-test-id='20160128042601028824550'])[2]")
	WebElement labelClaimTwo;

	@FindBy(xpath="//a[contains(text(),'Claim Text')]")
	WebElement linkClaimText;

	@FindBy(xpath="//a[contains(text(),'Claim Edits')]")
	WebElement linkClaimEdits;

	@FindBy(xpath="//a[contains(text(),'Claim Audit')]")
	WebElement linkClaimAudit;

	@FindBy(xpath="//a[contains(text(),'Supporting Details')]")
	WebElement linkSupportingDetails;

	@FindBy(xpath="//a[contains(text(),'Surgical Procedure')]")
	WebElement linkSurgicalProcedure;

	@FindBy(xpath="//a[contains(text(),'Claims Bundling Details')]")
	WebElement linkClaimsBundlingDetails;

	@FindBy(xpath="//a[contains(text(),'Networx Pricing Details')]")
	WebElement linkNetworxPricingDetails;

	@FindBy(xpath="//a[contains(text(),'ITS Specific Details')]'")
	WebElement linkITSSpecificDetails;

	@FindBy(xpath="//a[contains(text(),'Claim Text')]")
	WebElement linkClaimEdit1;

	@FindBy(xpath="//a[contains(text(),'Claim Text')]")
	WebElement linkClaimEdit2;

	@FindBy(xpath="//button[@id='ModalButtonSubmit']")
	WebElement btnSubmitInCompareClaims;



	public boolean clickOnCompareClaimsButonAndValidateTheDetails() throws InterruptedException
	{
		utils.waitforpageload();
		Thread.sleep(3000);
		String parent = Driver.pgDriver.getWindowHandle();
		if(utils.clickAnelemnt(btnCompareClaims,"ManageClaims","Compare Claims"))
		{
			System.out.println(("Next Gen Link Is Clicked.."));
			Set<String> handles = Driver.pgDriver.getWindowHandles();
			System.out.println("No.ofwindows"+handles.size());
			Iterator<String> iterator= handles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Driver.pgDriver.switchTo().window(childWindow);
			String title = Driver.pgDriver.getTitle();
			System.out.println("Title of the Child Window is: "+title);
			Thread.sleep(5000);
			if(title.contains("Manage Claims"))
			{
				if(!utils.isProxyWebelement(labelClaimOne))
					if(!utils.isProxyWebelement(labelClaimTwo))
						if(!utils.isProxyWebelement(linkClaimText))
							if(utils.clickAnelemnt(linkClaimText, "ManageClaims", "Claim Text"))
								if(utils.clickAnelemnt(btnSubmitInCompareClaims, "ManageClaims", "Submit"))
									return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}


	//Sprint 7.3


	@FindBy(xpath="//*[@name='ClaimSearch_D_ClaimsSearch_59']")
	WebElement clickSearchOnManageClaimsPage;

	public boolean clickSearchButton()
	{
		return utils.clickAnelemnt(clickSearchOnManageClaimsPage, "ManageClaims", "clickSearchOnManageClaimsPage");
	}

	@FindBy(xpath="//table[@pl_prop='D_ClmsSummary.pxResults']")
	WebElement redesignTblManageClaimsSearchResults;

	public boolean verifyAndClickClaimReviewedCheckBox(String args[]) 
			throws InterruptedException
	{
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.xpath("//td[starts-with(@class,'expandPane')]//following-sibling::td[1]"));

		rowNo.get(1).click();
		return true;
	}

	public boolean selectPerformNextActionValueAsViewEOB(String args[]) 
			throws InterruptedException
	{
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.xpath("//span[text()='Select...']"));
		return utils.selectValueFromListbyVisibleString(rowNo.get(0), "View / Send EOB", "ManageClaims", "PerformNextAction");
	}

	public boolean selectPerformNextActionValueAsViewAuthorization(String args[]) 
			throws InterruptedException
	{
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.xpath("//span[text()='Select...']"));
		return utils.selectValueFromListbyVisibleString(rowNo.get(0), "View Authorization", "ManageClaims", "PerformNextAction");
	}

	public boolean selectPerformNextActionValueAsViewAccumulator(String args[]) 
			throws InterruptedException
	{
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.xpath("//span[text()='Select...']"));
		return utils.selectValueFromListbyVisibleString(rowNo.get(0), "View Accumulator", "ManageClaims", "PerformNextAction");
	}

	public boolean selectPerformNextActionValueAsViewLimitedLiability(String args[]) 
			throws InterruptedException
	{
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.xpath("//span[text()='Select...']"));
		return utils.selectValueFromListbyVisibleString(rowNo.get(0), "View Limited Liability", "ManageClaims", "PerformNextAction");
	}

	public boolean selectPerformNextActionValueAsViewRemit(String args[]) 
			throws InterruptedException
	{
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.xpath("//span[text()='Select...']"));
		//rowNo.get(0).click();
		return utils.selectValueFromListbyVisibleString(rowNo.get(0), "View Remit", "ManageClaims", "PerformNextAction");
	}

	@FindBy(xpath="(//span[@id='modaldialog_hd_title'])")
	WebElement validateModalWindowHeader;

	public boolean validateTheModelPopUpHeader(String args[])
	{
		return utils.validateLabel(validateModalWindowHeader,args[0]);
	}

	@FindBy(xpath="//button[@data-test-id='201902151036560691763345']")
	WebElement clickCloseOnTheModelPopUp;

	public boolean clickSubmitOrCloseInTheModelPopUp()
	{
		return utils.clickAnelemnt(clickCloseOnTheModelPopUp, "ManageClaims", "clickCloseOnTheModelPopUp");
	}

	@FindBy(xpath="//label[@class='actionTitleBarLabelStyle']")
	WebElement validateSearchForClaimPage;

	public boolean verifySearchForClaimPageIsDisplayed(String args[])
	{
		return utils.validateLabel(validateSearchForClaimPage,args[0]);
	}


	@FindBy(xpath="//button[@data-test-id='20150917174441083821622']")
	WebElement navigateToRequestMgrHelp;

	public boolean clickOtherActionsNavigateToRequestManagerHelp()
	{
		return utils.selectValueFromListbyVisibleString(navigateToRequestMgrHelp,"Request Manager/OE Help", "Search For Claim","navigateToRequestMgrHelp");

	}


	public boolean selectClaimsToCompare(String args[]) 
			throws InterruptedException
	{
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.tagName("input"));
		rowNo.get(3).click();
		return true;
	}


	public boolean verifyCompareClaimsIsDisabledOnManageClaims()
	{

		boolean value = btnCompareClaims.isEnabled();
		if(value==false)
		{
			blogger.loginfo("Compare Claims is disabled");
			return true;
		}
		else
		{
			blogger.loginfo("Compare Claims is not disabled");
			return false;
		}
	}


	public boolean verifyCompareClaimsIsEnabledOnManageClaims()
	{

		boolean value = btnCompareClaims.isEnabled();
		if(value==true)
		{
			blogger.loginfo("Compare Claims is enabled");
			return true;
		}
		else
		{
			blogger.loginfo("Compare Claims is enabled");
			return false;
		}
	}

	@FindBy(xpath="//button[@data-test-id='2019021311591505742818']")
	WebElement SelectDropdown;

	@FindBy(xpath="//table[@pl_prop='.NextActionsList']")
	WebElement NextActionTable;

	@FindBy(xpath="//span[text()='Request Refund']")
	WebElement RequestRefundDropdown;

	public boolean performRequestRefund(String[] args) throws InterruptedException {
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.tagName("td"));
		if(utils.clickAnelemnt(rowNo.get(0), "Manage Claims", "Click on the Expand arrow"))
			if(utils.clickAnelemnt(SelectDropdown, "Manage Claims", "SelectDropdown")) 
				if(utils.clickAnelemnt(RequestRefundDropdown, "Manage Claims", "RequestRefundDropdown"))
					return clickSubmit();		
		return false;
	}

	public boolean expandTheClaim(String[] args) throws InterruptedException{
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.tagName("td"));
		return utils.clickAnelemnt(rowNo.get(0), "Manage Claims", "Click on the Expand arrow");

	}

	@FindBy(xpath="//div[@data-test-id='201904111615110547135363']")
	WebElement InstrucText;

	public boolean validateInstructionalText(String[] args){
		String Expected=args[0];
		String Actual=InstrucText.getText();
		System.out.println(Actual);
		return utils.isvalueMatch_compareto(Actual, Expected);	
	}

	@FindBy(xpath="//button[@data-test-id='201904111615110548136575']")
	WebElement ClickMoreDetails;

	public boolean clickOnMoreDetails(){
		if(ClickMoreDetails.isEnabled())
			return utils.clickAnelemnt(ClickMoreDetails, "Manage Claims", "ClickMoreDetails");
		return false;	
	}

	@FindBy(xpath="//span[text()='Associate Empowerment Guidelines Notification']")
	WebElement AEGheader;

	@FindBy(id="DidMemberContactPartProvYes")
	WebElement MemberContactPartProvYes;

	@FindBy(id="DidMemberContactPartProvNo")
	WebElement MemberContactPartProvNo;

	@FindBy(xpath="//button[@data-test-id='20190416192956024758782']")
	WebElement AEGsubmit;

	@FindBy(xpath="//span[text()='AEG: Claims Review']")
	WebElement AEGreviewHeader;

	public boolean validateAndSubmitAEGNotification(String[] args){
		String sCheckHEader="Associate Empowerment Guidelines Notification";
		if(utils.validateHeader(AEGheader, sCheckHEader))
			if(args[0].equalsIgnoreCase("yes")){
				if(utils.clickAnelemnt(MemberContactPartProvYes, "Manage Claims", "MemberContactPartProvYes"))
				{utils.waitforpageload();
				if(utils.clickAnelemnt(AEGsubmit, "Manage Claims", "AEGsubmit"))
				{utils.waitforpageload();
				return utils.validateHeader(AEGreviewHeader, "AEG: Claims Review");}}}
			else if(args[0].equalsIgnoreCase("no"))
				if (utils.clickAnelemnt(MemberContactPartProvNo, "Manage Claims", "MemberContactPartProvNo"))
					return utils.clickAnelemnt(AEGsubmit, "Manage Claims", "AEGsubmit");
		return false;

	}

	@FindBy(xpath="//label[@for='ClaimID']//following-sibling::div//a")
	WebElement ClaimId;

	@FindBy(xpath="//button[@data-test-id='20190416192956024758782']")
	WebElement ReviewSubmit;

	public boolean validateAEGClaimsReviewScreen(String[] args){
		String Actual="Claim Number:"+ClaimId.getText();
		System.out.println(Actual);
		System.out.println(args[0]);
		if (utils.isvalueMatch_compareto(Actual, args[0]))
			return utils.clickAnelemnt(ReviewSubmit, "Manage Claims", "ReviewSubmit");
		return false;
	}

	@FindBy(xpath="//div[@data-test-id='20181205072120035923555']")
	WebElement BenefitReview;

	public boolean validateBenefitReviewScreen(){
		String Expec="The benefits review functionality of this guided workflow is still being developed. If the member has more specific questions about benefits and cost or accumulators, please launch the Benefits and Cost task to assist them. Please ensure the appropriate contract is selected when reviewing the members benefits as they relate to the claim in question. Otherwise, click Request Adjustment to continue to the next step in this flow.";
		String Actual=BenefitReview.getText();
		return utils.isvalueMatch_compareto(Actual, Expec);
	}

	@FindBy(xpath="//button[@data-test-id='20190416192956024758782']")
	WebElement RequestAdjustmentBtn;

	public boolean clickOnRequestAdjustment(){
		return utils.clickAnelemnt(RequestAdjustmentBtn, "Manage Claims", "RequestAdjustmentBtn");
	}

	@FindBy(xpath="//button[@data-test-id='2019041619312901152266']")
	WebElement CancelBtn;

	public boolean clickCancelAndValidate(){
		return utils.clickAnelemnt(CancelBtn, "Manage Claims", "CancelBtn");
	}

	@FindBy(xpath="//span[@id='headerlabel1282']")
	WebElement ClaimTxtHeader;

	public boolean verifyViewClaimTextScreen(){
		return utils.validateHeader(ClaimTxtHeader, "Claim Text");
	}

	@FindBy(xpath="//button[@data-test-id='20141008160437053510472']")
	WebElement EmpAdjustment;
	public boolean clickOnEmpRequestAdjustment(){
		return utils.clickAnelemnt(EmpAdjustment, "Manage Claims", "EmpReqAdjustBtn");
	}

	@FindBy(xpath="//textarea[@id='pyNote']")
	WebElement EmpNote;

	public boolean validatePreFilledFieldsForEmpowermentFlow(){
		String actual=EmpNote.getText();
		String Expected="Out of Network Claim can be adjusted as an In Network Claim because the referring doctor is an in-network provider for this date of service";
		return utils.isvalueMatch_compareto(actual, Expected);
	}

	@FindBy(xpath="//div[@node_name='HCClaimSearchResultsGandA']//p/..")
	WebElement InstructionalTextForODGAndCADMHC;

	/**
	 * This method validate the instructional text to be displayed for CA member whose company code is 200C on searching any claims in search claim page
	 * @param args
	 * @return
	 */
	public boolean validateInstructionalTextForODGAndCADMHC(String[] args)
	{
		utils.scrolltomiddle();
		String actualText = args[0];
		System.out.println("Actual Text: "+actualText);
		String expectedText = InstructionalTextForODGAndCADMHC.getText().trim();
		String expectedtext1=expectedText.replaceAll("\n","").replaceAll(",", "").replaceAll("\"", "'");
		System.out.println("Expected Text: "+expectedtext1);
		return utils.isvalueMatch_contain(actualText, expectedtext1);

	}

	@FindBy(xpath="//input[@class='checkbox chkBxCtl'][contains(@name,'$pCheckReviewForContact')]")
	WebElement ClaimDiscussedwWthContact;

	/**
	 * This Method validates all the check box related to claim discussed with contact is disabled for member belongs to CA whose company code is 200C
	 * @return
	 */

	public boolean validateClaimDiscussedwWthContacIsDisabled()
	{
		boolean Isdisabled =false;
		List<WebElement> itr = Driver.pgDriver.findElements(By.xpath("//input[@class='checkbox chkBxCtl'][contains(@name,'$pCheckReviewForContact')]")) ;
		for(WebElement we:itr)
		{
			if(!we.isEnabled()){
				Isdisabled =true;
			}else{
				blogger.loginfo("Checkbox is enabled.Please recheck!!");
				return false;
			}
		}
		if(Isdisabled){
			blogger.loginfo("All checkboxes are disabled");
			return true;
		}else
		{
			blogger.loginfo("Checkbox is enabled.Please recheck!!");
			return false;
		}
	}


	@FindBy(xpath="//table[@id='ERRORTABLE']//ul[@class='pageErrorList layout-noheader-errors']")
	WebElement ErrorMessageForCADMHCMember;

	/**
	 * This Method will validate the error message displayed when user click submit button without launching G &A from claim detail page for CA member whose company code is 200C
	 * @param args
	 * @return
	 */
	public boolean validateErrorMessageForCADMHCMember(String[] args)
	{
		String ActualMessage = args[0];
		String ExpectedMessage =ErrorMessageForCADMHCMember.getText();
		System.out.println(ExpectedMessage);
		return utils.isvalueMatch_contain(ActualMessage, ExpectedMessage);

	}
	public boolean clickOnSubmitAfterGandA() throws InterruptedException{
		Thread.sleep(3000);
		Driver.pgDriver.switchTo().defaultContent();
		Driver.pgDriver.switchTo().frame(Iframeelement);
		utils.scrolltomiddle();
		return  utils.clickAnelemnt(this.btnSubmit,"ManageClaims","Submit Button");
	}

	public boolean SelectAllCheckBoxForClaimDiscussedWithContact() throws InterruptedException
	{
		boolean Enabled =false;
		utils.scrolltomiddle();
		List<WebElement> itr = Driver.pgDriver.findElements(By.xpath("//input[@class='checkbox chkBxCtl'][contains(@name,'$pCheckReviewForContact')]")) ;
		for(WebElement we:itr)
		{
			if(utils.clickAnelemnt(we, "Manage claims", "Claim discused with contact"))
			{
				Enabled =true;
			}else{
				blogger.loginfo("Checkbox is notchecked.Please recheck!!");
				return false;
			}
		}
		if(Enabled){
			blogger.loginfo("All checkboxes are checked");
			return true;
		}else
		{
			blogger.loginfo("Checkbox is not checked.Please recheck!!");
			return false;
		}
	}

	/**Validate Search Results are displayed
	 * 
	 * @return
	 */
	public boolean searchResultsDisplayed() {
		return !utils.isProxyWebelement(redesignTblManageClaimsSearchResults);
	}

	@FindBy(xpath="//span[text()='Search Criteria']")
	WebElement LinkSearchCriteria;

	/**Click on clear search button and validate the search results not displayed
	 * 
	 * @return
	 */
	public boolean clickOnClearSearchAndValidate() {
		if(utils.clickAnelemnt(LinkSearchCriteria, "ManageClaims", "LinkSearchCriteria"))
			if(utils.clickAnelemnt(BtnClearSearch, "ManageClaims", "BtnClearSearch"))
				return utils.isProxyWebelement(redesignTblManageClaimsSearchResults);
		return false;

	}

	@FindBy(xpath="//span[text()='View Accumulator']")
	WebElement LinkAccumulator;

	@FindBy(id="modaldialog_hd_title")
	WebElement PopUpHeader;

	@FindBy(xpath="//button[@data-test-id='201902151036560691763345']")
	WebElement CloseButton;

	public boolean selectAnyTask(String[] args, WebElement webelement) throws InterruptedException {
		utils.waitforpageload();	
		WebElement row =utils.getTablerowbasedonvalues(this.redesignTblManageClaimsSearchResults,args);
		List<WebElement> rowNo = row.findElements(By.tagName("td"));
		WebElement element = rowNo.get(19).findElement(By.xpath("//div[text()='Select... ']//img[2]"));
		if(utils.clickAnelemnt(element, "Manage Claims", "SelectDropdown")) 
			return utils.clickAnelemnt(webelement, "Manage Claims", webelement.toString());
		return false;

	}

	public boolean performAccumulatorTaskAndClose(String[] claimnumber) throws InterruptedException {
		if(selectAnyTask(claimnumber, LinkAccumulator))
			if(utils.validateHeader(PopUpHeader, "View Accumulators"))
				return utils.clickAnelemnt(CloseButton, "Manage Claims", "CloseButton");
		return false;
	}

	@FindBy(xpath="//span[text()='View Remit']")
	WebElement LinkViewRemit;

	public boolean performViewRemitTaskAndClose(String[] claimnumber) throws InterruptedException {
		if(selectAnyTask(claimnumber, LinkViewRemit))
			if(utils.validateHeader(PopUpHeader, "View Remit"))
				return utils.clickAnelemnt(CloseButton, "Manage Claims", "CloseButton");
		return false;
	}


	@FindBy(xpath="//span[text()='View EOB']")
	WebElement LinkViewEOB;

	@FindBy(xpath="//div[text()='Submit']")
	WebElement SubmitButtonInViewEOB;

	public boolean performViewEOBTaskAndSubmit(String[] claimnumber) throws InterruptedException {
		if(selectAnyTask(claimnumber, LinkViewEOB))
			if(utils.validateHeader(PopUpHeader, "View EOB"))
				return utils.clickAnelemnt(SubmitButtonInViewEOB, "Manage Claims", "CloseButton");
		return false;
	}

	@FindBy(xpath="//span[text()='View Authorization']")
	WebElement LinkViewAuthorizations;

	public boolean performViewAuthorizationTaskAndClose(String[] claimnumber) throws InterruptedException {
		if(selectAnyTask(claimnumber, LinkViewAuthorizations))
			if(utils.validateHeader(PopUpHeader, "View Authorizations"))
				return utils.clickAnelemnt(SubmitButtonInViewEOB, "Manage Claims", "CloseButton");
		return false;

	}

	@FindBy(xpath="//span[text()='View Limited Liability']")
	WebElement LinkViewLimitedLiability;

	public boolean performViewLimitedLiabilityTaskAndClose(String[] claimnumber) throws InterruptedException {
		if(selectAnyTask(claimnumber, LinkViewLimitedLiability))
			if(utils.validateHeader(PopUpHeader, "View Limited Liability"))
				return utils.clickAnelemnt(SubmitButtonInViewEOB, "Manage Claims", "CloseButton");
		return false;
	}

	@FindBy(xpath="//span[text()='Requires Adjustment']")
	WebElement RequiresAdjustment;

	@FindBy(xpath="//div[text()='Request Adjustment']")
	WebElement ButtonRequestAdjustment;

	public boolean sendClaimsForAdjustment(String[] claimnumber) throws InterruptedException {
		if(selectAnyTask(claimnumber, RequiresAdjustment))
			if(utils.validateHeader(PopUpHeader, "Rejected Claims for Adjustment"))
				if(utils.clickAnelemnt(ButtonRequestAdjustment, "Manage Claims", "ButtonRequestAdjustment"))
				{
					WebElement row1 =utils.getTablerowbasedonvalues(this.NextActionTable,claimnumber);
					List<WebElement> rowNo1 = row1.findElements(By.tagName("td"));
					return !utils.isProxyWebelement(rowNo1.get(2).findElement(By.xpath(".//input[@class='checkbox chkBxCtl']")));
				}
		return false;
	}


}



