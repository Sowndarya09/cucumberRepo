package automationLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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

public class ProviderBenefitsAndCost extends Driver {
	
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	
	public ProviderBenefitsAndCost ()
	{
		
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(),40),this);
		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;

	//Guided dialogue
	
	@FindBy(xpath="//div[@data-test-id='20180619134743010338413']")
	WebElement HB1353Dis;
	
	@FindBy(xpath="//u[text()='Quote Disclaimer']//following::div[@data-test-id='20180619134743010338413']")
	WebElement QuoteDisclaimer;
	
	@FindBy(xpath="//u[text()='Quote Nervous & Mental (parity & non-parity) Disclaimer']//following::div[@data-test-id='20180619134743010338413']")
	WebElement NervousDisclaimer;
	
	@FindBy(xpath="//input[@id='IsQuoteDisclaimer'][@type='checkbox']")
	WebElement checkBoxQuoteDisclaimer;
	
	@FindBy(xpath="	//input[@id='IsCaliforniaDisclaimer'][@type='checkbox']")
	WebElement checkBoxQuoteNervousDisclaimer;
	
	@FindBy(xpath="	//input[@id='IsHB1353Disclaimer'][@type='checkbox']")
	WebElement checkBoxHB1353Disclaimer;
	
	
	@FindBy(xpath = "//*[@class='fieldset-legend']//*[contains(text(),'Required for an MTM')]")
	private WebElement labelRequiredforMTM;
	@FindBy(className = "actionTitleBarLabelStyle")
	private WebElement sHeaderManageBilling;

	@FindBy(xpath = "//*[@node_name='pyGridPaginator']//table[@role='presentation']/tbody//*[contains(@class,'ValueWrite')]/nobr")
	WebElement checkPagePagination;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']")
	WebElement tableDentalPlanLevelCoverage;

	@FindBy(xpath = "//img[@alt='Loading...']")
	WebElement loadingicon;

	@FindBy(xpath = "//li//span[contains(text(),'Access Documents')]")
	private WebElement lnkOthrActionsAccessDocuments;

	@FindBy(xpath = "//*[@class='pzbtn-mid'][contains(text(),'Other actions') or contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Cancel this work']")
	private WebElement lnkOtherCancelThisWork;

	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Access Documents']")
	private WebElement lnkOtherAccessDocuments;

	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Estimate Your Cost']")
	private WebElement lnkOtherEstimateCost;

	@FindBy(xpath = "//li[@title='Flexible Spending']")
	private WebElement lnkOtherFlexibleSpending;

	@FindBy(xpath = "//li[@title='Benefit selection']")
	private WebElement lnkOtherBenefitSelection;

	@FindBy(xpath = "//*[@class='menu-item-title'][text()='View Historical Benefits']")
	private WebElement lnkOtherHistoricalBenefits;

	@FindBy(xpath = "//*[@class='menu-item-title'][text()='View Wellness Programs']")
	private WebElement lnkOtherWellnessprograms;

	// Other Toold
	@FindBy(xpath = "//img[contains(@src,'tool_icon_')]")
	private WebElement btnImgTool;

	// Tool Mark
	@FindBy(xpath = "//*[@class='menu-item-title'][text()='View History']")
	private WebElement lnkToolViewHistory;
	@FindBy(xpath = "//*[@class='menu-item-title'][text()='Configuration Tools']")
	private WebElement lnkToolConfigurationTools;

	// Help
	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()=' Help']")
	private WebElement btnHelp;

	@FindBy(id = "CancellationReason")
	WebElement drpdwnCancellationreason;
	@FindBy(xpath = "//input[@id='DateOfService']")
	WebElement txtbxBenefitsSelectionDateofService;

	@FindBy(xpath = "//input[@id='BenefitSearch']")
	WebElement txtbxBenefitsSelectionBenefitSearch;

	@FindBy(xpath = "//span[text()='Advanced Search']")
	WebElement labelBenefitsSelectionAdvancedSearch;

	@FindBy(id = "InNetwork")
	WebElement chkbxBenefitsSelectionInNetwork;
	@FindBy(id = "OutOfNetwork")
	WebElement chkbxBenefitsSelectionOutofNetwork;

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Search']")
	WebElement btnBenefitsSelectionSearch;

	@FindBy(xpath = "//*[@node_name='pyGridPaginator']//table[@role='presentation']/tbody//*[contains(@class,'ValueWrite')]/nobr")
	WebElement noofpages;

	@FindBy(xpath = "//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//*[@class='content-inner ']/p/span/span[contains(@style,'color:#FF000')]")
	WebElement sErrorMessageSearchWrongDate;

	@FindBy(xpath = "//*[@class='actionTitleBarLabelStyle']")
	WebElement sHeaderBenefitSelection;

	// TAGGING BENEFIT ELEMENTS

	@FindBy(id = "TagMTMAttributes")
	WebElement chkbxBenefitsMTMTag;

	@FindBy(id = "TagExclusions")
	WebElement chkbxBenefitsExclusionTag;

	@FindBy(id = "TagInclusions")
	WebElement chkbxBenefitsInclusionsTag;

	@FindBy(id = "TagConditions")
	WebElement chkbxBenefitsConditionsTag;

	@FindBy(id = "TagAssociatedBenefitDetails")
	WebElement chkbxBenefitsAssociatedBenefitTag;

	// BROWSE TAB_----------------------------------------------------------

	@FindBy(xpath = "//a[@id='TABANCHOR']//label[contains(text(),'Browse')]")
	WebElement tabBenefitsSelectionBrowse;

	@FindBy(xpath = "//div[@node_name='BrowseBenefitsIndexMode']//label[contains(text(),'Medical')]")
	WebElement tabBenefitsSelectionBrowseMedical;

	@FindBy(xpath = "//div[@node_name='BrowseBenefitsIndexMode']//label[contains(text(),'Pharmacy')]")
	WebElement tabBenefitsSelectionBrowsePharmacy;

	@FindBy(xpath = "//div[@node_name='BrowseBenefitsIndexMode']//label[contains(text(),'Dental')]")
	WebElement tabBenefitsSelectionBrowseDental;

	@FindBy(xpath = "//div[@node_name='BrowseBenefitsIndexMode']//label[contains(text(),'Vision')]")
	WebElement tabBenefitsSelectionBrowseVision;

	@FindBy(xpath = "//div[@section_index='3']//*[@node_name='BrowseBenefitsAllorAlpha']//*[contains(text(),'All Categories')]")
	WebElement linkBenefitsSelectionBrowseMedicalAllCategories;

	@FindBy(xpath = "//div[@section_index='4'][contains(@id,'BenefitsIndexMode')]//*[@node_name='BrowseBenefitsAllorAlpha']//*[contains(text(),'All Categories')]")
	WebElement linkBenefitsSelectionBrowsePharmacyAllCategories;

	@FindBy(xpath = "//div[@section_index='6']//*[@node_name='BrowseBenefitsAllorAlpha']//*[contains(text(),'All Categories')]")
	WebElement linkBenefitsSelectionBrowseVisionAllCategories;

	@FindBy(xpath = "//div[@section_index='5']//*[@node_name='BrowseBenefitsAllorAlpha']//*[contains(text(),'All Categories')]")
	WebElement linkBenefitsSelectionBrowseDentalAllCategories;

	@FindBy(xpath = "//div[@section_index='3']//*[@node_name='BrowseBenefitsAllorAlpha']//*[contains(text(),'X')]")
	WebElement linkBenefitsSelectionBrowseMedicalCategory;

	@FindBy(xpath = "//div[@section_index='4'][contains(@id,'BenefitsIndexMode')]//*[@node_name='BrowseBenefitsAllorAlpha']//*[contains(text(),'X')]")
	WebElement linkBenefitsSelectionBrowsePharmacyCategory;

	@FindBy(xpath = "//div[@section_index='6']//*[@node_name='BrowseBenefitsAllorAlpha']//*[contains(text(),'X')]")
	WebElement linkBenefitsSelectionBrowseVisionCategory;

	@FindBy(xpath = "//div[@section_index='5']//*[@node_name='BrowseBenefitsAllorAlpha']//*[contains(text(),'X')]")
	WebElement linkBenefitsSelectionBrowseDentalCategory;

	@FindBy(xpath = "//div[@section_index='6']//div[@title='Hide Plan Level Coverage']")
	WebElement imgBenefitsSelectionVisionPlanLevelCoverageexpand;

	@FindBy(xpath = "//div[@section_index='3']//div[@title='Hide Plan Level Coverage']")
	WebElement imgBenefitsSelectionMedicalPlanLevelCoverageexpand;

	@FindBy(xpath = "//div[@section_index='4']//div[@title='Hide Plan Level Coverage']")
	WebElement imgBenefitsSelectionPharmacyPlanLevelCoverageexpand;

	@FindBy(xpath = "//div[@section_index='5']//div[@title='Hide Plan Level Coverage']")
	WebElement imgBenefitsSelectionDentalPlanLevelCoverageexpand;

	@FindBy(xpath = "//div[@section_index='6']//div[@title='Disclose Benefit Level Coverage']")
	WebElement imgBenefitsSelectionVisionBenefitLevelCoverageexpand;

	@FindBy(xpath = "//div[@section_index='3']//div[@title='Disclose Benefit Level Coverage']")
	WebElement imgBenefitsSelectionMedicalBenefitLevelCoverageexpand;

	@FindBy(xpath = "//div[@section_index='4']//div[@title='Disclose Benefit Level Coverage']")
	WebElement imgBenefitsSelectionPharmacyBenefitLevelCoverageexpand;

	@FindBy(xpath = "//div[@section_index='5']//div[@title='Disclose Benefit Level Coverage']")
	WebElement imgBenefitsSelectionDentalBenefitLevelCoverageexpand;

	// MEDICAL--------------------------------------------------------------------------------------

	// DEDUCTIBLE...
	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[3]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkDeductibleIndividual;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[3]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkDeductibleIndividual;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[4]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkDeductibleFamily;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[4]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkDeductibleFamily;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[5]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkDeductibleCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[5]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkDeductibleCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[6]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkDeductibleCarryOver;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[6]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkDeductibleCarryOver;

	// OUT of POCKET .....

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[8]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkOOPIndividual;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[8]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkOOPIndividual;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[9]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkOOPFamily;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[9]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkOOPFamily;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[10]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkOOPCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[10]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkOOPCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[11]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkOOPCarryOver;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[11]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkOOPCarryOver;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[12]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkCoInsurance;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[12]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkCoInsurance;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[13]//td[@headers='a4']")
	WebElement BrowseMedicalInNetworkLifetimeMaximum;

	@FindBy(xpath = "//div[@section_index='3']//table[@pl_prop='.PlanBenefitsList']//tr[13]//td[@headers='a7']")
	WebElement BrowseMedicaloutofNetworkLifetimeMaximum;

	// PHARMACY------------------------------------------------------------------------------------------

	// DEDUCTIBLE...
	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[3]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkDeductibleIndividual;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[3]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkDeductibleIndividual;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[4]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkDeductibleFamily;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[4]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkDeductibleFamily;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[5]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkDeductibleCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[5]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkDeductibleCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[6]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkDeductibleCarryOver;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[6]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkDeductibleCarryOver;

	// OUT of POCKET .....

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[8]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkOOPIndividual;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[8]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkOOPIndividual;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[9]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkOOPFamily;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[9]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkOOPFamily;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[10]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkOOPCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[10]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkOOPCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[11]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkOOPCarryOver;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[11]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkOOPCarryOver;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[12]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkCoInsurance;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[12]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkCoInsurance;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[13]//td[@headers='a4']")
	WebElement BrowsePharmacyInNetworkLifetimeMaximum;

	@FindBy(xpath = "//div[@section_index='4']//table[@pl_prop='.PlanBenefitsList']//tr[13]//td[@headers='a7']")
	WebElement BrowsePharmacyoutofNetworkLifetimeMaximum;

	// DENTAL-----------------------------------------------------------------------------------------

	// DEDUCTIBLE...
	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[3]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkDeductibleIndividual;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[3]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkDeductibleIndividual;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[4]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkDeductibleFamily;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[4]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkDeductibleFamily;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[5]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkDeductibleCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[5]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkDeductibleCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[6]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkDeductibleCarryOver;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[6]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkDeductibleCarryOver;

	// OUT of POCKET .....

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[8]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkOOPIndividual;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[8]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkOOPIndividual;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[9]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkOOPFamily;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[9]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkOOPFamily;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[10]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkOOPCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[10]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkOOPCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[11]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkOOPCarryOver;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[11]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkOOPCarryOver;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[12]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkCoInsurance;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[12]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkCoInsurance;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[23]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkLifetimeMaximum;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[23]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkLifetimeMaximum;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[13]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkPediatricOrtho;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[14]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkPediatricMajor;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[15]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkEndpperiooral;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[16]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkdiagonistic;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[17]//td[@headers='a4']")
	WebElement BrowseDentalInNetworkPediatricBasic;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[18]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkPediatricOrtho;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[19]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkPediatricMajor;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[20]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkEndpperiooral;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[21]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkdiagonistic;

	@FindBy(xpath = "//div[@section_index='5']//table[@pl_prop='.PlanBenefitsList']//tr[22]//td[@headers='a7']")
	WebElement BrowseDentaloutofNetworkPediatricBasic;

	// VISION-----------------------------------------------------------------------------------------

	// DEDUCTIBLE...
	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[3]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkDeductibleIndividual;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[3]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkDeductibleIndividual;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[4]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkDeductibleFamily;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[4]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkDeductibleFamily;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[5]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkDeductibleCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[5]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkDeductibleCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[6]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkDeductibleCarryOver;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[6]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkDeductibleCarryOver;

	// OUT of POCKET .....

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[8]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkOOPIndividual;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[8]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkOOPIndividual;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[9]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkOOPFamily;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[9]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkOOPFamily;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[10]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkOOPCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[10]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkOOPCrossAccumulationrule;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[11]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkOOPCarryOver;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[11]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkOOPCarryOver;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[12]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkCoInsurance;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[12]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkCoInsurance;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[13]//td[@headers='a4']")
	WebElement BrowseVisionInNetworkLifetimeMaximum;

	@FindBy(xpath = "//div[@section_index='6']//table[@pl_prop='.PlanBenefitsList']//tr[13]//td[@headers='a7']")
	WebElement BrowseVisionoutofNetworkLifetimeMaximum;

	@FindBy(xpath = "//*[@node_name='ShowBenfitDetailsData']//*[@class='field-item dataLabelWrite']")
	WebElement txtBrowseBenefitSelectionDoesnotExist;

	@FindBy(xpath = "//*[@node_name='DisplayBenefitResults']//span[contains(@style,'color: rg')]")
	WebElement txtBrowseBenefitSelectionMembernotactive;

	@FindBy(xpath = "//*[@node_name='MbrBenefitsInsight']//em")
	WebElement txtBrowseBenefitSelectionRefresh;

	@FindBy(xpath = "//*[@node_name='ShowBenfitDetailsData']//table[contains(@pl_prop,'BenefitLevelDetails')]")
	WebElement tableBrowseBenefitSelectionExpandedBenefit;

	@FindBy(xpath = "//*[@node_name='MbrBenefitsInsightStart']//div[contains(text(),'not included')]")
	WebElement txtBrowseStandAlonemessage;

	@FindBy(xpath = "//span[contains(text(),'Member not active on the date of service entered.')]")
	WebElement lblMemberNotActive;

	public WebElement getTxtbxBenefitsSelectionDateofService() {
		return txtbxBenefitsSelectionDateofService;
	}

	public WebElement gettxtbxBenefitsSelectionBenefitSearch() {
		return txtbxBenefitsSelectionBenefitSearch;
	}

	public WebElement getsHeaderManageBilling() {
		return sHeaderManageBilling;
	}

	// enter value in text box
	public boolean settxtbxDateofService(String sDate) throws InterruptedException {
		try {
			if(utils.setAttribute(this.txtbxBenefitsSelectionDateofService, "value", sDate))
				if(utils.setAttribute(this.txtbxBenefitsSelectionDateofService, "data-value", sDate))
					return utils.pressEnter(this.txtbxBenefitsSelectionDateofService, "Benefit Selection", "Date");
		} catch (StaleElementReferenceException e) {
			return this.settxtbxDateofService(sDate);
		} catch (NoSuchElementException e) {
			return this.settxtbxDateofService(sDate);
		}
		return false;
	}

	int numoftries = 0;

	public boolean settxtbxBenefitSearch(String sDate) throws InterruptedException {
		numoftries += 1;
		if (numoftries <= 3)
			try {
				if (utils.enterTextinAnelemnt(this.gettxtbxBenefitsSelectionBenefitSearch(), sDate, "Benefit Selection","Text Box Date of Service")) {
					return utils.clickAnelemnt(this.txtbxBenefitsSelectionDateofService, "Benefit Selection", "Date Field");
				}
			} catch (StaleElementReferenceException e) {
				return this.settxtbxBenefitSearch(sDate);
			} catch (NoSuchElementException e) {
				return this.settxtbxBenefitSearch(sDate);
			}
		numoftries = 0;
		return false;
	}

	@FindBy(xpath = "//div[@node_name='DisplayBenefitResults']//*[contains(text(),'Benefits shown are for contract')]/parent::p//strong ")
	WebElement BenefitContractDetailLine;

	/**
	 * Validating Values for the table in the dropDown
	 * 
	 * @param sData
	 * @return
	 * @throws InterruptedException
	 */
	public boolean tableValidatValuesforPopulatedValues(String sData) throws InterruptedException {
		try {
			Thread.sleep(5000);
			return utils.getcolumnStringFromTableByNamesetofElements(this.tableCheckBenefit, sData, 3);
		} catch (StaleElementReferenceException e) {

			// In case this exception comes for more then 3 times the loop will break
			if (count == 3) {
				return false;
			}
			return this.settxtbxBenefitSearch(sData);
		}
	}

	// checking if on entering three variablethe dropdown is getting populated
	@FindBy(xpath = "//table[contains(@pl_prop,'SearchSuggestions')]")
	WebElement tableCheckBenefit;

	public boolean clickgetBtnSearch() {
		numoftries += 1;
		if (numoftries <= 3)
			if (utils.clickAnelemnt(this.btnBenefitsSelectionSearch, "Benefit Selection", "Search Button")) {
				try {
					if (!utils.isProxyWebelement(lblMemberNotActive)) {
						blogger.loginfo("Member Not acive message displayed");
						stepdefinition.isServicedown = true;
						return false;
					}
					if (this.tableBenefit.isDisplayed()) {
						return true;
					} else {
						clickgetBtnSearch();
					}
				} catch (Exception e) {
					clickgetBtnSearch();
					return false;
				}
			} else
				return false;
		numoftries = 0;

		blogger.loginfo("Benefits were not returned");
		return false;

	}

	public boolean clickgetBtnSubmit() {
		return utils.clickAnelemnt(btnSubmit, "ProviderBenefitsAndCost", "Submit");
	}

	// Taking value as a constant that would break out in case the same is repeated
	// 7 times.
	public int count = 0;

	/**
	 * Check value of the 3 digits if it populates the table with values
	 * 
	 * @param sData
	 *            : the three words with which we have to select the value
	 * @return
	 * @throws InterruptedException
	 */
	public boolean sCheckBenefitDropDownPopulatedon3Digits(String sData) throws InterruptedException {
		// enter three digits and check if the dropdown is getting populated
		if (this.settxtbxBenefitSearch(sData.substring(0, 3)))
			// check the Table for the value
			if (this.tableValidatValuesforPopulatedValues(sData))
				return true;
				blogger.loginfo("Pass : The table fetches the Values \n\n");
		return false;
	}

	public boolean CheckBenefitsRowBasedOnNWTypeService(String[] sData) throws Exception {
		String category = sData[0], service = sData[1], network = sData[2];
		boolean returnvar = true;
		utils.waitforpageload();
		// enter three digits and check if the dropdown is getting populated
		
		if (this.settxtbxBenefitSearch(category)) {
			this.getTxtbxBenefitsSelectionDateofService().click();
			if (this.clickgetBtnSearch()) {
				if (this.checkValueinParticularRow(network, service)) {
					int i = 2;
					String s1, s2;
					while (returnvar && i < sData.length)

					{
						try {
							i++;
							s1 = sData[i];
							s2 = sData[i];
							s1 = s1.substring(s1.indexOf(":") + 1).toLowerCase();
						} catch (ArrayIndexOutOfBoundsException e) {
							break;

						}
						switch (s2.substring(0, s2.indexOf(":"))) {
						case "place": {
							returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(3).toLowerCase(), s1);
							continue;
						}
						case "copay": {
							returnvar = utils.isvalueMatch_contain(
									sValuesforSingleBenefit.get(5).replaceAll(",", "").toLowerCase(), s1);
							continue;
						}
						case "deductible-individual": {
							returnvar = utils.isvalueMatch_contain(
									sValuesforSingleBenefit.get(6).replaceAll(",", "").toLowerCase(), s1);
							continue;
						}
						case "deductible-family":

						{
							returnvar = utils.isvalueMatch_contain(
									sValuesforSingleBenefit.get(7).replaceAll(",", "").toLowerCase(), s1);
							continue;
						}

						case "outofpocket-individual": {
							returnvar = utils.isvalueMatch_contain(
									sValuesforSingleBenefit.get(8).replaceAll(",", "").toLowerCase(), s1);
							continue;
						}
						case "outofpocket-family": {
							returnvar = utils.isvalueMatch_contain(
									sValuesforSingleBenefit.get(9).replaceAll(",", "").toLowerCase(), s1);
							continue;
						}
						case "planpays": {
							returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(10).toLowerCase(), s1);
							continue;
						}

						case "memberpays": {
							returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(11).toLowerCase(), s1);
							continue;
						}

						case "exclusions": {
							returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(12).toLowerCase(), s1);
							continue;
						}

						case "inclusions": {
							returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(13).replaceAll(".", "")
									.replaceAll(" ", "").toLowerCase(), s1.replaceAll(".", "").replaceAll(" ", ""));
							continue;
						}

						case "referral": {
							returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(14).toLowerCase(), s1);
							continue;
						}

						case "authorization": {
							returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(15).toLowerCase(), s1);
							continue;
						}

						case "limit": {
							returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(16).toLowerCase(), s1);
							utils.clickAnelemnt(this.chkbxBenefitsMTMTag, "Benefit Selection", "MTM Tag ");
							continue;
						}

						default: {
							returnvar = false;
							break;
						}
						}
						i++;

					}
					return returnvar;
				}
			}
		}

		return false;
	}

	@FindBy(xpath = "//img[contains(@alt,'Loading..')]")
	WebElement LoadingIcon;

	public boolean checkforpageload() {
		int count = 0;
		try {
			if (this.LoadingIcon.isDisplayed()) {
				count++;
				wait = new WebDriverWait(Driver.pgDriver, 20);
				wait.until(ExpectedConditions.visibilityOf(this.btnSubmit));

				return true;
			} else {
				return true;
			}
		} catch (Exception e) {
			if (count > 0) {
				blogger.loginfo("Applcation took a long time to load");
				return false;
			} else
				return true;
		}

	}

	/**
	 * Negetive testing in the case fo error message for a faulty Date, enter a date
	 * less then 01/01/2016
	 * 
	 * @param sData
	 * @return
	 * @throws InterruptedException
	 */
	public boolean errorMessageonSelectingDateLessthenJan2016(String[] sData) throws InterruptedException {

		if (utils.validateHeader(this.sHeaderBenefitSelection, "Benefit selection")) {
			// enter the value in the dropdown which needs to be searched with
			if (this.settxtbxBenefitSearch(sData[0])) {
				if (this.clickgetBtnSearch()) {
					Thread.sleep(4000);
					this.checkforpageload();
					// There can usually two types of error, depending on teh dates, so the values
					// will be saved in two variables accordingly and the entered value wil be
					// [present there
					boolean error1 = utils.validateHeader(this.sErrorMessageSearchWrongDate,
							"Benefit search is not available for dates of service prior to 1/1/2016. Use other actions to View Historical Benefits for the selected Date of Service.");
					boolean error2 = utils.validateHeader(this.sErrorMessageSearchWrongDate,
							"Member not active on the date of service entered.");
					// Check the values of the error message in the page
					if ((error1 = true) || (error2 = true)) {
						if (this.clickgetBtnSubmit()) {
							// Accept the alert
							Thread.sleep(2000);
							if (Driver.pgDriver.switchTo().alert().getText().trim().equalsIgnoreCase(
									"No benefits details were quoted and selected in this interaction. Do you want to submit?")) {
								Driver.pgDriver.switchTo().alert().accept();
								Driver.pgDriver.switchTo().parentFrame();
								blogger.loginfo("Pass : The table fetches the Values \n\n");
								return true;
							}
						}
					}

				}
			}
		}

		return false;
	}

	// Check for the Next Page

	@FindBy(xpath = "//*[@title='Disclose Advanced Search']")
	WebElement lnkAdvancedeSearch;

	@FindBy(xpath = "//input[@id='InNetwork']")
	WebElement chkbxInNetwork;

	@FindBy(xpath = "//input[@id='OutOfNetwork']")
	WebElement chkbxOutNetwork;

	@FindBy(xpath = "//input[@id='OutOfNetwork']")
	WebElement txt;

	/*
	 * Click on an Elemnet Advqanced Search
	 */
	public boolean clickLnkAdvancedSearch() {
		return utils.clickAnelemnt(this.lnkAdvancedeSearch, "Benefit Selection", "Search Button");
	}

	String labelHeaders = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'fieldset-legend')]";

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'content-inline_grid_5')]//*[contains(@class,'item-5')]//table[@role='presentation']")
	WebElement tableOutofPocketMaxm;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'content-inline_grid_5')]//*[contains(@class,'item-1')]//table[@role='presentation']")
	WebElement tableDeductibletMaxm;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'content-inline_grid_5')]//*[contains(@class,'item-2')]//*[contains(@class,'JustifyStyle')]")
	WebElement sRequiredForMTMCopayment;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'content-inline_grid_5')]//*[contains(@class,'item-3')]//*[contains(@class,'JustifyStyle')]")
	WebElement sRequiredForMTMPlanPays;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'content-inline_grid_5')]//*[contains(@class,'item-4')]//*[contains(@class,'JustifyStyle')]")
	WebElement sRequiredForMTMMemberPays;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//input[contains(@class,'chkBx')]")
	WebElement chkbxMTMComplaints;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'inline_grid_triple')]/*[contains(@class,'item-1')]//*[contains(@class,'dataValueRead')]")
	WebElement checkLabelReferralRequired;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'inline_grid_triple')]/*[contains(@class,'item-2')]//*[contains(@class,'dataValueRead')]")
	WebElement checkLabelAuthorizationRequired;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'inline_grid_triple')]/*[contains(@class,'item-3')]//*[contains(@class,'dataValueRead')]")
	WebElement checkLabelLimitsRequired;

	@FindBy(xpath = "//*[@node_name='ShowBenfitDetailsData']//a[contains(@data-click,'Plan Level Coverage')]")
	WebElement lnkBenefitSelectionplanlevelcoverage;

	@FindBy(xpath = "//*[@node_name='ShowBenfitDetailsData']//a[@href='#Top']")
	WebElement lnkBenefitSelectionBacktoTop;

	// Exclusion
	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-2')]//input[contains(@class,'chkBx')]")
	WebElement chkbxExclusiondiscussed;

	@FindBy(xpath = "//*[@base_ref='BenefitInqResults.pxResults(1)']//*[contains(@class,'content-item content-sub_section item-2')]//input[contains(@class,'chkBx')]")
	WebElement chkbxInclusion;

	@FindBy(xpath = "//*[contains(@base_ref,'Results(1)')]//*[contains(@class,'content-item content-sub_section item-4')]//input[contains(@class,'chkBx')]")
	WebElement chkbx;

	// Table with the value

	@FindBy(xpath = "//table[contains(@pl_prop,'BenefitInq')]")
	WebElement tableBenefit;

	// Values above the table
	@FindBy(xpath = "//*[contains(text(),'Benefits shown are for contract')]")
	WebElement valueBenefitForContract;

	@FindBy(xpath = "//*[contains(text(),'effective')]")
	WebElement valueeffectiveDate;

	@FindBy(xpath = "/*[contains(text(),'for this')]")
	WebElement valueAnthemText;

	@FindBy(xpath = "//*[@title='Next Page']")
	WebElement NextPage;

	/**
	 * Check the value which populates above the table for value
	 * 
	 * @param args
	 * @return
	 */
	public boolean checkValuefromSearchforValues(String[] args) {
		// Checking First Value in the Search Result
		if (this.valueBenefitForContract.getText().trim().contentEquals(args[0].split(":")[1]))
			if (this.valueBenefitForContract.getText().trim().contentEquals(args[1].split(":")[1]))
				if (this.valueBenefitForContract.getText().trim().contentEquals(args[2].split(":")[1]))
					return true;
		return false;
	}

	Map<String, ArrayList<String>> sdataValueSheet = new TreeMap<String, ArrayList<String>>();
	ArrayList<String> sValueExcelSheet = new ArrayList<String>();
	ArrayList<String> sValuesforSingleBenefit = new ArrayList<String>();

	// Check the Values of the contents in the DropDown from the table
	String[] sValueExcel = new String[200];

	int iCount = 0;

	/**
	 * Check the value in side the expanded value with each value from the table
	 * heading
	 * 
	 * @param iRow
	 * @return
	 */
	public boolean checkValueTableUnderEachHeading(int iRow) {
		// checking Value of each Value in the table
		/**
		 * @param xpathCopayment
		 *            : Xpath for Copayment
		 * @param xpathPlanPays
		 *            : Xpath for Plan Pays for each Row expand
		 * @param xpathMemberPays
		 *            : Xpath for Member Pays
		 */
		try {

			new WebDriverWait(Driver.pgDriver, 10)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
		}

		catch (Exception e) {
			blogger.loginfo("No loading icon. Continue ");
		}
		String benefitpresent = "//*[@node_name='DisplayMTMAttributes']//*[@class='header-title']";
		String xpathCopayment = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//label[@for='CoPayment']/parent::div//div//span[@data-ctl='Text']";
		String xpathPlanPays = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//label[@for='PlanCoInsurance']/parent::div//div//span[@data-ctl='Text']";
		String xpathMemberPays = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//label[@for='CoInsurance']/parent::div//div//span[@data-ctl='Text']";
		String DeductibleIndMax = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//div[@node_name='DisplayDeductibleMaximum']//tr[1]//td[@class='dataValueRead']//span";
		String DeductibleFamilyMax = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//div[@node_name='DisplayDeductibleMaximum']//tr[2]//td[@class='dataValueRead']//span";
		String outofpocketmax = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//div[@node_name='DisplayOutOfPocketMaximum']//tr[1]//td[@class='dataValueRead']//span";
		String outofpocketmin = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//div[@node_name='DisplayOutOfPocketMaximum']//tr[2]//td[@class='dataValueRead']//span";
		int iPlanPays = 0;

		if (utils.isvalueMatch_contain(Driver.pgDriver.findElement(By.xpath(benefitpresent)).getText().toString(),
				"Required")) {
			try {
				// get text for Copayment
				sValueExcelSheet.add(Driver.pgDriver.findElement(By.xpath(xpathCopayment)).getText());
				sValuesforSingleBenefit.add(Driver.pgDriver.findElement(By.xpath(xpathCopayment)).getText());
			} catch (Exception e) {
				sValuesforSingleBenefit.add("");
			}
			try {
				sValuesforSingleBenefit.add(Driver.pgDriver.findElement(By.xpath(DeductibleIndMax)).getText());
			} catch (Exception e) {
				sValuesforSingleBenefit.add("");
			}
			try {
				sValuesforSingleBenefit.add(Driver.pgDriver.findElement(By.xpath(DeductibleFamilyMax)).getText());
			} catch (Exception e) {
				sValuesforSingleBenefit.add("");
			}

			try {
				sValuesforSingleBenefit.add(Driver.pgDriver.findElement(By.xpath(outofpocketmax)).getText());
			} catch (Exception e) {
				sValuesforSingleBenefit.add("");
			}
			try {
				sValuesforSingleBenefit.add(Driver.pgDriver.findElement(By.xpath(outofpocketmin)).getText());
			} catch (Exception e) {
				sValuesforSingleBenefit.add("");
			}
		} else {
			sValuesforSingleBenefit.add("");
			sValuesforSingleBenefit.add("");
			sValuesforSingleBenefit.add("");
			sValuesforSingleBenefit.add("");
			sValuesforSingleBenefit.add("");
			sValuesforSingleBenefit.add("");

		}
		// Logic for Member Pays and Plan Pays
		try {
			String sPlanPays = Driver.pgDriver.findElement(By.xpath(xpathPlanPays)).getText().split("%")[0];
			sValueExcelSheet.add(sPlanPays);
			sValuesforSingleBenefit.add(sPlanPays);
			iPlanPays = Integer.parseInt(sPlanPays);
		} catch (Exception e) {
			sValuesforSingleBenefit.add("");
		}

		try {
			String sMemberPays = Driver.pgDriver.findElement(By.xpath(xpathMemberPays)).getText().split("%")[0];

			int iMemberPays = Integer.parseInt(sMemberPays);
			sValueExcelSheet.add(sMemberPays);
			sValuesforSingleBenefit.add(sMemberPays);
			if ((iPlanPays + iMemberPays) == 100) {
				blogger.loginfo("Continue");
			} else {
				err.logError("Benefit Selection", "Benefit Details - Member and plan pays does not add up to 100");
				return false;
			}
		} catch (Exception e) {

			sValuesforSingleBenefit.add("");
		}

		// Print the value of the three strings in an Array in the sheet
		String xpathExclusion = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//*[contains(@class,'content-item content-sub_section item-2')]//*[contains(@class,'content-field item-1')]//*[contains(@class,'Read')]";
		String xpathInclusion = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//*[contains(@class,'content-item content-sub_section item-3')]//*[contains(@class,'content-field item-1')]//*[contains(@class,'Read')]";
		String xpathConditions = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//*[contains(@class,'content-item content-sub_section item-4')]//*[contains(@class,'content-field item-1')]//*[contains(@class,'Read')]";

		try {
			sValueExcelSheet.add(Driver.pgDriver.findElement(By.xpath(xpathExclusion)).getText());
			sValueExcelSheet.add(Driver.pgDriver.findElement(By.xpath(xpathInclusion)).getText());
			sValuesforSingleBenefit.add(Driver.pgDriver.findElement(By.xpath(xpathExclusion)).getText());
			sValuesforSingleBenefit.add(Driver.pgDriver.findElement(By.xpath(xpathInclusion)).getText());
			// sValueExcelSheet.add(Driver.pgDriver.findElement(By.xpath(xpathConditions)).getText());
		} catch (Exception e) {
			sValuesforSingleBenefit.add("");
			sValuesforSingleBenefit.add("");
		}

		String xpathReferral_Authorization_Limit = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
				+ ")']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'item-2')]//*[contains(@class,'field item-1')]//*[contains(@class,'ValueRead')]/span";
		List<WebElement> allTags = Driver.pgDriver.findElements(By.xpath(xpathReferral_Authorization_Limit));
		// Referral Authorization and Limit to be displayed from the table

		for (WebElement tag : allTags) {
			sValueExcelSheet.add(tag.getText());
			sValuesforSingleBenefit.add(tag.getText());
		}

		// Here plan and Member Pays have a relation in accordance to the scene

		/**
		 * 
		 * Checking teh Value of both Pcket Maximim and Deductible Maximum from teh
		 * tables in the page
		 * 
		 * @param xpathPocketMaxm:
		 *            Xpath for Pocket Maximum values in Dollars
		 * @param xpathDeductibleMaxm
		 *            : Xpath for Deductibable Maximum tabel in dollars
		 */
		try {
			String xpathPocketMaxm = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
					+ ")']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'content-inline_grid_5')]//*[contains(@class,'item-5')]//table[@role='presentation']";
			// check value from Maxm Pocket and Deductible Maxm
			String xpathDeductibleMaxm = "//*[@base_ref='BenefitInqResults.pxResults(" + iRow
					+ ")']//*[contains(@class,'content-item content-sub_section item-1')]//*[contains(@class,'content-inline_grid_5')]//*[contains(@class,'item-1')]//table[@role='presentation']";

			this.tableValueBenefitfromMaxm(Driver.pgDriver.findElement(By.xpath(xpathPocketMaxm)));
			this.tableValueBenefitfromMaxm(Driver.pgDriver.findElement(By.xpath(xpathDeductibleMaxm)));
		} catch (Exception e) {
			blogger.loginfo("Xpath not found");
		}
		for (int i = 0; i < sValuesforSingleBenefit.size(); i++)
			blogger.loginfo("Item no " + i + " " + sValuesforSingleBenefit.get(i));
		return true;
	}

	/**
	 * Method to fetch the values from the table and get the value in each Row and
	 * expand the value as well for each Row
	 * 
	 * @param sTable
	 * @return
	 */
	public boolean tableValueBenefitfromMaxm(WebElement sTable) {
		List<WebElement> allRows = sTable.findElements(By.tagName("tr"));
		if (allRows.size() > 0) {
			// Navigating through all the rows and checking the value of the correct Row
			for (WebElement row : allRows) {
				int iRow1 = 0;
				List<WebElement> allColsByRow = row.findElements(By.tagName("td"));
				{
					for (WebElement col : allColsByRow) {
						iRow1++;

						if (iRow1 == 2) {
							sValueExcelSheet.add(col.getText());
							sValueExcel[iCount++] = col.getText();
							blogger.loginfo("Amount from the table: " + col.getText());
						}
					}
				}

			}

		}
		return false;
	}

	public boolean searchBenefit(String[] Benefit) throws InterruptedException {
		if (this.settxtbxBenefitSearch(Benefit[0]))
		{
			this.getTxtbxBenefitsSelectionDateofService().click();
			return this.clickgetBtnSearch();
				
			} 
			return false;
	}

	public boolean enterTheSearchCriteriaAndTableAppear(String[] args) throws Exception {

		if (this.settxtbxBenefitSearch(args[0])) {
			this.getTxtbxBenefitsSelectionDateofService().click();
			if (this.clickgetBtnSearch()) 
				if (this.checkValuewithTableRowHeadings()) 
					return true;
				}
		return false;
	}

	public boolean checkValuewithTableRowHeadings() throws Exception {
		FileInputStream file = new FileInputStream("C:/SolutionCentralEngine/BenefitsPage.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheet("Sheet1");
		Thread.sleep(5000);
		int j = 1;
		Thread.sleep(5000);
		int loopcount = 1;
		String loopiterator = "";
		try {
			loopiterator = noofpages.getText().toString();
			int stringLength = loopiterator.length();
			char lastCar2 = loopiterator.trim().charAt(stringLength - 1);
			int lastChar = Integer.parseInt(String.valueOf(lastCar2));
			loopcount = lastChar;
		} catch (Exception e) {
			loopiterator = null;
		}

		if (loopiterator == null)
			loopcount = 1;

		int rows = 1;

		for (int numPage = 0; numPage < loopcount; numPage++) {
			if (numPage > 0) {
				try {
					Actions action = new Actions(Driver.pgDriver);
					action.doubleClick(this.NextPage).perform();
					utils.clickAnelemnt(this.NextPage, "Benefits", "Next Button");
				} catch (Exception e) {
					blogger.loginfo("Not found");
					return true;
				}
			}

			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("scroll(0, -250);");
			Thread.sleep(3000);
			List<WebElement> allRows = tableBenefit.findElements(By.tagName("tr"));

			if (allRows.size() > 9) {
				err.logError("More than 9 rows ", "Benefit result table - The number of rows is more than 10");
				return false;
			}
			if (allRows.size() > 0) {
				// Navigating through all the rows and checking the value of the correct Row

				for (WebElement row : allRows) {
					int iRow1 = 0;
					List<WebElement> allColsByRow = row.findElements(By.tagName("td"));
					{
						// Check the Value from the column in the list
						for (WebElement col : allColsByRow) {
							sValueExcelSheet.add(col.getText());
							sValueExcel[iCount++] = col.getText();
						}

						// Click the drop down from the table for each row
						for (WebElement col : allColsByRow) {
							// click the first Value
							if (iRow1++ == 0) {
								col.click();
								Thread.sleep(3000);
								checkValueTableUnderEachHeading(rows++);
								Thread.sleep(4000);
								col.click();
								break;
							}

						}

					}
				}
			}
		}

		int k = 0;
		XSSFRow row1 = sheet.createRow(j);
		for (int i = 0; i < sValueExcelSheet.size(); i++) {
			try {

				XSSFCell cell = row1.createCell(k);
				cell.setCellValue(sValueExcelSheet.get(i));
				if (i % 18 == 0) {
					j++;
					row1 = sheet.createRow(j);
					k = 0;

				}
				k++;

			}

			catch (Exception e) {
				blogger.loginfo("Fail due to " + e);
				file.close();
			}

		}

		FileOutputStream outfile = new FileOutputStream("C:/SolutionCentralEngine/BenefitsPage.xlsx");
		wb.write(outfile);
		outfile.flush();
		outfile.close();
		return true;
	}

	// Check Value from the table with each Row
	/**
	 * This table will be called again and again for each row Value check and after
	 * checking will open the Bracket to check value in that row.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean checkValueinParticularRow(String NWType, String Service) throws Exception {
		try {

			try {
				wait = new WebDriverWait(Driver.pgDriver, 10);
				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//table[contains(@pl_prop,'BenefitInq')]")));
			} catch (Exception e) {
				utils.clickAnelemnt(this.btnBenefitsSelectionSearch, "Benefit Selection", "Benefits table");

			}
			int loopcount = 1;
			String loopiterator = "";
			try {
				loopiterator = noofpages.getText().toString();
				int stringLength = loopiterator.length();
				char lastCar2 = loopiterator.trim().charAt(stringLength - 1);
				int lastChar = Integer.parseInt(String.valueOf(lastCar2));
				loopcount = lastChar;
			} catch (Exception e) {
				loopiterator = null;
			}

			if (loopiterator == null)
				loopcount = 1;

			int rows = 1;

			JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
			jse.executeScript("scroll(0, -250);");
			Thread.sleep(3000);
			List<WebElement> allRows = tableBenefit.findElements(By.tagName("tr"));
			int rowcount = 0;
			if (allRows.size() > 0) {
				// Navigating through all the rows and checking the value of the correct Row
				int iRow1 = 0;
				for (WebElement row : allRows) {
					rowcount++;
					if (utils.isvalueMatch_contain(row.getText().toString().toLowerCase(), NWType.toLowerCase())) {
						if (utils.isvalueMatch_contain(row.getText().toString().toLowerCase(), Service.toLowerCase())) {
							break;
						}
					}
				}
				WebElement row = allRows.get(rowcount - 1);

				List<WebElement> allColsByRow = row.findElements(By.tagName("td"));
				{
					// Check the Value from the column in the list
					for (WebElement col : allColsByRow) {
						sValuesforSingleBenefit.add(col.getText());
					}

					// Click the drop down from the table for each row
					for (WebElement col : allColsByRow) {
						// click the first Value
						if (iRow1++ == 0) {
							col.click();
							Thread.sleep(3000);
							checkValueTableUnderEachHeading(rowcount - 1);
							Thread.sleep(4000);
							utils.takescreenshot( "benefitvalues");
							col.click();
							break;
						}
					}
				}
			}
		}

		catch (Exception e) {
			blogger.loginfo("Fail due to " + e);
			return false;

		}

		return true;
	}

	@FindBy(xpath = "//*[contains(text(),'Benefits shown are for contract')]/parent::p//strong")
	private List<WebElement> benfitdetail;

	/*
	 * @SCU #CommonMethodwithArgument:validateBenefitDetailLine #Arguments: values
	 * should be passed as comma separated parameters,as in order of UI
	 * -'Contractcode,startdate,enddate,productname,text'. Type:Text Description:
	 * This method verifies that Benefits selection message is displayed.
	 */

	public boolean validateBenefitDetailLine(String[] details) throws Exception {
		utils.waitforpageload();
		String LineDetails = null;
		Boolean returnvar = true;
		String keyvaluepair = "";
		for (String iterator : details) {
			if (!returnvar) {
				err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
						+ " Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			utils.waitforpageload();
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if (key.toLowerCase().contains("code")) {
				returnvar = utils.validateValueinelement(benfitdetail.get(0), value, "BenefitSelection",
						"ccontractcode");
				continue;
			} else if (key.toLowerCase().contains("start")) {
				returnvar = utils.validateValueinelement(benfitdetail.get(2), value, "BenefitSelection", "startdate");
				continue;
			}

			else if (key.toLowerCase().contains("end")) {
				returnvar = utils.validateValueinelement(benfitdetail.get(3), value, "BenefitSelection", "enddate");
				continue;
			} else if (key.toLowerCase().contains("name")) {
				returnvar = utils.validateValueinelement(benfitdetail.get(4), value, "BenefitSelection", "productname");
				continue;
			} else if (key.toLowerCase().contains("text")) {
				returnvar = utils.validateValueinelement(benfitdetail.get(5), value, "BenefitSelection", "producttext");
				continue;
			}

			else
				err.logcommonMethodError("Benefit selection",
						"Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;

		}

		if (returnvar) {
			System.out.println("Benefit selection info checked Successfully");
			return true;
		} else {
			int tot_i = details.length;
			err.logcommonMethodError("Member Composite",
					"the value " + details[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}

	}

	public boolean checkAdvancedSearchResultinTable(String[] NetworkType) throws InterruptedException {
		String benefit = null, nwvalue = null;
		Boolean returnvar = true;
		for (String iterator : NetworkType) {
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();

			if (utils.isvalueMatch_contain(key.toLowerCase(), "benefit")) {
				benefit = value.toLowerCase();
				continue;
			} else if (utils.isvalueMatch_contain(key.toLowerCase(), "network")) {
				nwvalue = value.toLowerCase();
				continue;
			}
		}

		settxtbxBenefitSearch(benefit);
		if (utils.clickAnelemnt(this.lnkAdvancedeSearch, "Benefit Selection", "Advanced Search")) {
			if (utils.isvalueMatch_contain(nwvalue.toLowerCase(), "in")) {
				utils.clickAnelemnt(this.chkbxInNetwork, "Benefit Selection", "InNetwork checkbox");
			} else
				utils.clickAnelemnt(this.chkbxOutNetwork, "Benefit Selection", "OutNetwork checkbox");
		} else {
			return false;
		}
		clickgetBtnSearch();
		List<WebElement> allRows = tableBenefit.findElements(By.tagName("tr"));

		for (int i = 2; i < allRows.size(); i++) {
			if (Driver.pgDriver
					.findElement(By.xpath("//*[@pl_prop='BenefitInqResults.pxResults']//tr[" + i + "]//td[5]//span"))
					.getText().contains("In")) {
				blogger.loginfo("validation Done");
				continue;
			} else
				return false;
		}
		return true;

	}

	/*
	 * @SCU #CommonMethodwithoutArgument:validateAlertMessagewhenSubmit
	 * #Description: This functionality validates the Alert Message displayed when
	 * user performs submit action on the Benefits selection section Type:Textbox
	 */
	public boolean validateAlertMessagewhenSubmit() throws InterruptedException {
		if(settxtbxBenefitSearch("AMBULANCE"))
		if(clickgetBtnSearch())
		{
		String alert = "";
		try {
			clickgetBtnSubmit();
			WebDriverWait wait = new WebDriverWait(Driver.pgDriver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			alert = Driver.pgDriver.switchTo().alert().getText();
		} catch (NoAlertPresentException e1) {
			blogger.loginfo("Catch Statement");
		}

		if (utils.isvalueMatch_contain(alert.toLowerCase(),
				"no benefits details were quoted and selected in this interaction")) {
			Driver.pgDriver.switchTo().alert().accept();
			return true;
		} else
			return false;
		}
		return false;

	}

	public boolean navigatetoFlexibleSpending() {
		if (utils.clickAnelemnt(this.btnOtherActions, "Benefit Selection", "Other Actions button"))
			if(utils.clickAnelemnt(this.btnOtherActions, "Benefit Selection", "Other Actions button"))
				return utils.clickAnelemnt(this.lnkOtherFlexibleSpending, "Benefit Selection", "Links");
			return false;
	}

	public boolean navigatetoBenefitSelection() {
		if (utils.clickAnelemnt(this.btnOtherActions, "Benefit Selection", "Other Actions button"))
			if(utils.clickAnelemnt(this.btnOtherActions, "Benefit Selection", "Other Actions button"))
				if (utils.clickAnelemnt(this.lnkOtherBenefitSelection, "Benefit Selection", "Links"))
					return true;
			return false;
	}

	public boolean validateTaggedbenefitsonBenefitsReview() throws InterruptedException, IOException {

		if(utils.setAttribute(this.txtbxBenefitsSelectionDateofService, "value", "09/28/2016"))
		if(utils.setAttribute(this.txtbxBenefitsSelectionDateofService, "data-value", "9/28/2016"))

		if(settxtbxBenefitSearch("AMBULANCE"))
		clickgetBtnSearch();
		List<WebElement> allRows = tableBenefit.findElements(By.tagName("tr"));
		allRows = tableBenefit.findElements(By.tagName("tr"));

		for (WebElement row : allRows) {
			if (utils.validateLabel(row, "Water")) {
				List<WebElement> allColsByRow = row.findElements(By.tagName("td"));
				for (WebElement col : allColsByRow) {
					sValuesforSingleBenefit.add(col.getText());
				}

				row.click();
				if (utils.clickAnelemnt(this.chkbxBenefitsMTMTag, "Benefit Selection", "MTM Tag ")) {
					if (utils.clickAnelemnt(this.chkbxBenefitsInclusionsTag, "Benefit Selection", "Inclusion Tag ")) {
						break;
					}
				} else
					return false;
				break;
			} else
				continue;
		}

		utils.setAttribute(this.txtbxBenefitsSelectionDateofService, "value", "09/28/2016");
		utils.setAttribute(this.txtbxBenefitsSelectionDateofService, "data-value", "9/28/2016");
		settxtbxBenefitSearch("Medical Supplies");

		clickgetBtnSearch();
		allRows = tableBenefit.findElements(By.tagName("tr"));

		for (WebElement row : allRows) {
			if (utils.validateLabel(row, "Medical")) {
				List<WebElement> allColsByRow = row.findElements(By.tagName("td"));
				for (WebElement col : allColsByRow) {
					sValuesforSingleBenefit.add(col.getText());
				}

				row.click();
				if (utils.clickAnelemnt(this.chkbxBenefitsConditionsTag, "Benefit Selection", "Conditions Tag ")) {
					if (utils.clickAnelemnt(this.chkbxBenefitsAssociatedBenefitTag, "Benefit Selection",
							"AssociateBenefit Tag ")) {
						break;
					}
				} else
					return false;
				break;
			} else
				continue;
		}
		clickgetBtnSubmit();
		return true;
	}

	public boolean CancelBenefit(String[] cancelreason) {
		if (utils.clickAnelemnt(this.btnOtherActions, "Review Billing", "Other Actions Button")) {
			if (utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Review Billing", "Cancel this Work")) {
				if (utils.validateHeader(this.getsHeaderManageBilling(), "Cancel this work")) {
					if (utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, cancelreason[0],
							"Cancel Billing", "Cancel reason")) {
						if (utils.clickAnelemnt(this.btnSubmit, "cancel Billing", "Submit button on cancel billing"))
							;
						return true;
					} else
						return false;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	@SuppressWarnings("deprecation")
	public boolean Browse_validatePresenceofTabsCoverageCategories() {
		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit Selection-Browse", "Browse tab")) {
			// MEDICAL
			if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseMedical, "Benefit Selection-Browse",
					"Medical tab")) {
				Assert.assertEquals(true, this.linkBenefitsSelectionBrowseMedicalAllCategories.isDisplayed());
				Assert.assertEquals(true, this.linkBenefitsSelectionBrowseMedicalCategory.isDisplayed());

			} else {
				err.logError("Benefit Selectioin Browse", "Medical");
				return false;
			}
			// DENTAL
			if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseDental, "Benefit Selection-Browse", "Dental tab")) {
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseDental, "Benefit Selection-Browse", "Dental tab");
				Assert.assertEquals(true, this.linkBenefitsSelectionBrowseDentalAllCategories.isDisplayed());
				Assert.assertEquals(true, this.linkBenefitsSelectionBrowseDentalCategory.isDisplayed());

			} else {
				err.logError("Benefit Selection Browse", "Dental");
				return false;
			}

			// VISION
			if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseVision, "Benefit Selection-Browse", "Vision tab")) {
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseVision, "Benefit Selection-Browse", "Vision tab");
				Assert.assertEquals(true, this.linkBenefitsSelectionBrowseVisionAllCategories.isDisplayed());
				Assert.assertEquals(true, this.linkBenefitsSelectionBrowseVisionCategory.isDisplayed());

			} else {
				err.logError("Benefit Selection Browse", "Vision");
				return false;
			}

			// PHARMACY
			if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowsePharmacy, "Benefit Selection-Browse",
					"Pharmacy tab")) {
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowsePharmacy, "Benefit Selection-Browse",
						"Pharmacy tab");
				Assert.assertEquals(true, this.linkBenefitsSelectionBrowsePharmacyAllCategories.isDisplayed());
				Assert.assertEquals(true, this.linkBenefitsSelectionBrowsePharmacyCategory.isDisplayed());

			} else {
				err.logError("Benefit Selection Browse", "Pharmacy");
				return false;
			}

			return true;
		} else
			return false;

	}

	public boolean Browse_validateMedicalPlanLevelCoverage(String[] planleveldetails) {
		boolean returnvar = true;
		utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit selection", "Browse");
		utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit selection", "Browse");

		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseMedical, "Benefit selection", "Medical tab")) {
			String keyvaluepair = "";
			for (String iterator : planleveldetails) {
				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();

				if (utils.isvalueMatch_contain(key.toLowerCase(), "deductible")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowseMedicalInNetworkDeductibleIndividual, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowseMedicalInNetworkDeductibleFamily, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowseMedicalInNetworkDeductibleCrossAccumulationrule,
									value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowseMedicalInNetworkDeductibleCarryOver, value);
							continue;
						}

					}

					else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkDeductibleIndividual, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkDeductibleFamily, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(
									this.BrowseMedicaloutofNetworkDeductibleCrossAccumulationrule, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkDeductibleCarryOver, value);
							continue;
						}

					}

				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "oop")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowseMedicalInNetworkOOPIndividual, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowseMedicalInNetworkOOPFamily, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowseMedicalInNetworkOOPCrossAccumulationrule, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowseMedicalInNetworkOOPCarryOver, value);
							continue;
						}

					}

					else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkOOPIndividual, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkOOPFamily, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkOOPCrossAccumulationrule,
									value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkOOPCarryOver, value);
							continue;
						}

					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowseMedicalInNetworkCoInsurance, value);
						continue;
					}
				}

				else if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowseMedicalInNetworkCoInsurance, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "lifetime")) {
						returnvar = utils.validateLabel(this.BrowseMedicalInNetworkLifetimeMaximum, value);
						continue;
					}
				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkCoInsurance, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "lifetime")) {
						returnvar = utils.validateLabel(this.BrowseMedicaloutofNetworkLifetimeMaximum, value);
						continue;
					}
				}

				else
					err.logcommonMethodError("Benefit selection",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;

			}

		} else
			err.logError("Benefit Selection", "Medical tab ");

		if (returnvar) {
			blogger.loginfo("Plan Level Benefit info checked Successfully");
			return true;
		} else {
			int tot_i = planleveldetails.length;
			err.logcommonMethodError("Benefit Selection", "the value " + planleveldetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}

	}

	public boolean Browse_validatePharmacyPlanLevelCoverage(String[] planleveldetails) {
		boolean returnvar = true;

		utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit selection", "Browse");
		utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit selection", "Browse");

		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowsePharmacy, "Benefit selection", "Pharmacy tab")) {
			String keyvaluepair = "";
			for (String iterator : planleveldetails) {
				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();

				if (utils.isvalueMatch_contain(key.toLowerCase(), "deductible")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkDeductibleIndividual, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkDeductibleFamily, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkDeductibleCrossAccumulationrule,
									value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkDeductibleCarryOver, value);
							continue;
						}

					}

					else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkDeductibleIndividual, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkDeductibleFamily, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(
									this.BrowsePharmacyoutofNetworkDeductibleCrossAccumulationrule, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkDeductibleCarryOver, value);
							continue;
						}

					}

				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "oop")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkOOPIndividual, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkOOPFamily, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkOOPCrossAccumulationrule,
									value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkOOPCarryOver, value);
							continue;
						}

					}

					else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkOOPIndividual, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkOOPFamily, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkOOPCrossAccumulationrule,
									value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkOOPCarryOver, value);
							continue;
						}

					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkCoInsurance, value);
						continue;
					}
				}

				else if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkCoInsurance, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "lifetime")) {
						returnvar = utils.validateLabel(this.BrowsePharmacyInNetworkLifetimeMaximum, value);
						continue;
					}
				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkCoInsurance, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "lifetime")) {
						returnvar = utils.validateLabel(this.BrowsePharmacyoutofNetworkLifetimeMaximum, value);
						continue;
					}
				}

				else
					err.logcommonMethodError("Benefit selection",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;

			}

		} else
			err.logError("Benefit Selection", "Medical tab ");

		if (returnvar) {
			blogger.loginfo("Plan Level Benefit info checked Successfully");
			return true;
		} else {
			int tot_i = planleveldetails.length;
			err.logcommonMethodError("Benefit Selection", "the value " + planleveldetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU #CommonMethodwithoutArgument:clickonBrowse #Description: This
	 * functionality performs clicking on the Browse option in the Benefits
	 * Selection section Type:Textbox
	 */
	public boolean clickonBrowse() {
		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit Selection", "Browse tab"))
			if(utils.isProxyWebelement(lblMemberNotActive))
				return true;
			return false;
	}

	public boolean Browse_validateVisionPlanLevelCoverage(String[] planleveldetails) {
		boolean returnvar = true;

		utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit selection", "Browse");
		utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit selection", "Browse");

		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseVision, "Benefit selection", "Vision tab")) {
			String keyvaluepair = "";
			for (String iterator : planleveldetails) {
				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();

				if (utils.isvalueMatch_contain(key.toLowerCase(), "deductible")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowseVisionInNetworkDeductibleIndividual, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowseVisionInNetworkDeductibleFamily, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowseVisionInNetworkDeductibleCrossAccumulationrule,
									value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowseVisionInNetworkDeductibleCarryOver, value);
							continue;
						}

					}

					else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkDeductibleIndividual, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkDeductibleFamily, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils
									.validateLabel(this.BrowseVisionoutofNetworkDeductibleCrossAccumulationrule, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkDeductibleCarryOver, value);
							continue;
						}

					}

				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "oop")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowseVisionInNetworkOOPIndividual, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowseVisionInNetworkOOPFamily, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowseVisionInNetworkOOPCrossAccumulationrule, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowseVisionInNetworkOOPCarryOver, value);
							continue;
						}

					}

					else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkOOPIndividual, value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkOOPFamily, value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkOOPCrossAccumulationrule,
									value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkOOPCarryOver, value);
							continue;
						}

					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowseVisionInNetworkCoInsurance, value);
						continue;
					}
				}

				else if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowseVisionInNetworkCoInsurance, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "lifetime")) {
						returnvar = utils.validateLabel(this.BrowseVisionInNetworkLifetimeMaximum, value);
						continue;
					}
				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkCoInsurance, value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "lifetime")) {
						returnvar = utils.validateLabel(this.BrowseVisionoutofNetworkLifetimeMaximum, value);
						continue;
					}
				}

				else
					err.logcommonMethodError("Benefit selection",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;

			}

		} else
			err.logError("Benefit Selection", "Medical tab ");

		if (returnvar) {
			blogger.loginfo("Plan Level Benefit info checked Successfully");
			return true;
		} else {
			int tot_i = planleveldetails.length;
			err.logcommonMethodError("Benefit Selection", "the value " + planleveldetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}

	}

	public boolean Browse_validateDentalPlanLevelCoverage(String[] planleveldetails) {
		boolean returnvar = true;

		utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit selection", "Browse");
		utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit selection", "Browse");

		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseDental, "Benefit selection", "Dental tab")) {
			String keyvaluepair = "";
			for (String iterator : planleveldetails) {
				if (!returnvar) {
					err.logcommonMethodError("Member Composite", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();

				if (utils.isvalueMatch_contain(key.toLowerCase(), "deductible")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = this.BrowseDentalInNetworkDeductibleIndividual.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = this.BrowseDentalInNetworkDeductibleFamily.getText().toLowerCase()
									.contains(value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = this.BrowseDentalInNetworkDeductibleCrossAccumulationrule.getText()
									.toLowerCase().contains(value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = this.BrowseDentalInNetworkDeductibleCarryOver.getText().toLowerCase()
									.contains(value);
							continue;
						}

					}

					else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = this.BrowseDentaloutofNetworkDeductibleIndividual.getText().toLowerCase()
									.contains(value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = this.BrowseDentaloutofNetworkDeductibleFamily.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = this.BrowseDentaloutofNetworkDeductibleCrossAccumulationrule.getText()
									.toLowerCase().contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = this.BrowseDentaloutofNetworkDeductibleCarryOver.getText().toLowerCase()
									.contains(value);
							continue;
						}

					}

				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "oop")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = this.BrowseDentalInNetworkOOPIndividual.getText().toLowerCase().contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = this.BrowseDentalInNetworkOOPFamily.getText().toLowerCase().contains(value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = this.BrowseDentalInNetworkOOPCrossAccumulationrule.getText().toLowerCase()
									.contains(value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = this.BrowseDentalInNetworkOOPCarryOver.getText().toLowerCase().contains(value);
							continue;
						}

					}

					else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "individual")) {
							returnvar = this.BrowseDentaloutofNetworkOOPIndividual.getText().toLowerCase()
									.contains(value);
							continue;
						}

						else if (utils.isvalueMatch_contain(key.toLowerCase(), "family")) {
							returnvar = this.BrowseDentaloutofNetworkOOPFamily.getText().toLowerCase().contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "accumu")) {
							returnvar = this.BrowseDentaloutofNetworkOOPCrossAccumulationrule.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "carry")) {
							returnvar = this.BrowseDentaloutofNetworkOOPCarryOver.getText().toLowerCase()
									.contains(value);
							continue;
						}

					}

				}

				else if (utils.isvalueMatch_contain(key.toLowerCase(), "innetwork")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "insurance")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "ortho")) {
							returnvar = this.BrowseDentalInNetworkPediatricOrtho.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "major")) {
							returnvar = this.BrowseDentalInNetworkPediatricMajor.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "oral")) {
							returnvar = this.BrowseDentalInNetworkEndpperiooral.getText().toLowerCase().contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "preventive")) {
							returnvar = this.BrowseDentalInNetworkdiagonistic.getText().toLowerCase().contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "basic")) {
							returnvar = this.BrowseDentalInNetworkPediatricBasic.getText().toLowerCase()
									.contains(value);
							continue;
						}
					}
				}

				else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "insurance")) {
						if (utils.isvalueMatch_contain(key.toLowerCase(), "ortho")) {
							returnvar = this.BrowseDentaloutofNetworkPediatricOrtho.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "major")) {
							returnvar = this.BrowseDentaloutofNetworkPediatricMajor.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "oral")) {
							returnvar = this.BrowseDentaloutofNetworkEndpperiooral.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "preventive")) {
							returnvar = this.BrowseDentaloutofNetworkdiagonistic.getText().toLowerCase()
									.contains(value);
							continue;
						} else if (utils.isvalueMatch_contain(key.toLowerCase(), "basic")) {
							returnvar = this.BrowseDentaloutofNetworkPediatricBasic.getText().toLowerCase()
									.contains(value);
							continue;
						}
					}
				}

				else if (utils.isvalueMatch_contain(key.toLowerCase(), "lifetime")) {
					returnvar = this.BrowseDentalInNetworkLifetimeMaximum.getText().toLowerCase().contains(value);
					continue;
				}

				else if (utils.isvalueMatch_contain(key.toLowerCase(), "out")) {
					if (utils.isvalueMatch_contain(key.toLowerCase(), "coinsurance")) {
						returnvar = this.BrowseDentaloutofNetworkCoInsurance.getText().toLowerCase().contains(value);
						continue;
					} else if (utils.isvalueMatch_contain(key.toLowerCase(), "lifetime")) {
						returnvar = this.BrowseDentaloutofNetworkLifetimeMaximum.getText().toLowerCase()
								.contains(value);
						continue;
					}
				}

				else
					err.logcommonMethodError("Benefit selection",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;

			}

		} else
			err.logError("Benefit Selection", "Medical tab ");

		if (returnvar) {
			blogger.loginfo("Plan Level Benefit info checked Successfully");
			return true;
		} else {
			int tot_i = planleveldetails.length;
			err.logcommonMethodError("Benefit Selection", "the value " + planleveldetails[tot_i - 1].toString()
					+ " doesnt match with the one in application");
			return false;
		}

	}

	/*
	 * @SCU #CommonMethodwithArgument:clickonMedicalAlphabet #Description: This
	 * functionality navigates to the Benefits Selection section and in that user
	 * selects Browse tab continuing with clicking on Medical tab and then get the
	 * specify medical alphabet text and then clicks the Medical Alphabet.
	 * #Arguments:Alphabet Type:Textbox
	 */

	public boolean clickonMedicalAlphabet(String[] alphabet) {
		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit Selection", "Browse Tab")) {
			if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseMedical, "Benefit Selection", "Medical Tab")) {
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseMedical, "Benefit Selection", "Medical Tab");
				String indexalpha = alphabet[0].toString().toUpperCase();
				try {
					wait = new WebDriverWait(Driver.pgDriver, 10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[@node_name='BrowseBenefitsAllorAlpha']//a[contains(@data-click,'Mode="
									+ indexalpha + "')][text()='" + indexalpha + "']")));
					String exxpath = "//div[@node_name='BrowseBenefitsAllorAlpha']//a[contains(@data-click,'Mode="
							+ indexalpha + "')][text()='" + indexalpha + "']";
					wait = new WebDriverWait(Driver.pgDriver, 10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(exxpath)));
					Driver.pgDriver.findElement(By.xpath(exxpath)).click();
					return true;
				} catch (Exception e) {
					blogger.loginfo("cannot find the alphabet " + e);
					return !utils.isServiceDown();
				}
			} else {
				err.logError("Benefit Selection", "Medical TAB ");
				return !utils.isServiceDown();
			}
		} else {
			err.logError("Benefit Selection", "Browse TAB ");
			return !utils.isServiceDown();
		}
	}

	/*
	 * @SCU #CommonMethodwithArgument:clickonPharmacyAlphabet #Description: This
	 * functionality navigates to the Benefits Selection section and in that user
	 * selects Browse tab continuing with clicking on Pharmacy tab and then get the
	 * specify pharmacy alphabet text and then clicks the Pharmacy Alphabet.
	 * #Arguments:Alphabet Type:Textbox
	 */
	public boolean clickonPharmacyAlphabet(String[] alphabet) {
		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit Selection", "Browse Tab")) {
			if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowsePharmacy, "Benefit Selection", "Pharmacy Tab")) {
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowsePharmacy, "Benefit Selection", "Pharmacy Tab");
				String indexalpha = alphabet[0].toString().toUpperCase();
				try {

					Driver.pgDriver.findElement(By.xpath(
							"//div[@section_index='4'][contains(@id,'BenefitsIndexMode')]//a[contains(@data-click,'Mode="
									+ indexalpha + "')]"))
							.click();
					return true;
				} catch (Exception e) {
					blogger.loginfo("cannot find the alphabet");
					return false;
				}
			}

			else {
				err.logError("Benefit Selection", "Pharmacy TAB ");
				return false;
			}
		} else {
			err.logError("Benefit Selection", "Browse TAB ");
			return false;
		}
	}

	/*
	 * @SCU #CommonMethodwithArgument:clickonDentalAlphabet #Description: This
	 * functionality navigates to the Benefits Selection section and in that user
	 * selects Browse tab continuing with clicking on Dental tab and then get the
	 * specify dental alphabet text and then clicks the Dental Alphabet.
	 * #Arguments:Alphabet Type:Textbox
	 */
	public boolean clickonDentalAlphabet(String[] alphabet) {
		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit Selection", "Browse Tab")) {
			if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseDental, "Benefit Selection", "Dental Tab")) {
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseDental, "Benefit Selection", "Dental Tab");
				String indexalpha = alphabet[0].toString().toUpperCase();
				try {
					// wait=new WebDriverWait(Driver.pgDriver,5);
					// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@section_index='5']//div[@title='Hide
					// Plan Level Coverage']")));
					Driver.pgDriver
							.findElement(By.xpath(
									"//div[@section_index='5']//a[contains(@data-click,'Mode=" + indexalpha + "')]"))
							.click();
					return true;
				} catch (Exception e) {
					blogger.loginfo("cannot find the alphabet");
					return false;
				}
			} else {
				err.logError("Benefit Selection", "Dental TAB ");
				return false;
			}
		} else {
			err.logError("Benefit Selection", "Browse TAB ");
			return false;
		}
	}

	/*
	 * @SCU #CommonMethodwithArgument:clickonVisionAlphabet #Description: This
	 * functionality navigates to the Benefits Selection section and in that user
	 * selects Browse tab continuing with clicking on Vision tab and then get the
	 * specify vision alphabet text and then clicks the Vision Alphabet.
	 * #Arguments:Alphabet Type:Textbox
	 */
	public boolean clickonVisionAlphabet(String[] alphabet) {
		if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "Benefit Selection", "Browse Tab")) {
			if (utils.clickAnelemnt(this.tabBenefitsSelectionBrowseVision, "Benefit Selection", "Vision Tab")) {
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseVision, "Benefit Selection", "Vision Tab");

				String indexalpha = alphabet[0].toString().toUpperCase();
				try {
					Driver.pgDriver
							.findElement(By.xpath(
									"//div[@section_index='6']//a[contains(@data-click,'Mode=" + indexalpha + "')]"))
							.click();
					return true;
				} catch (Exception e) {
					return false;
				}
			} else {
				err.logError("Benefit Selection", "Vision TAB ");
				return false;
			}
		} else {
			err.logError("Benefit Selection", "Browse TAB ");
			return false;
		}
	}

	/*
	 * @SCU #CommonMethodwithArgument:clickBenefitBasedontext #Description: This
	 * functionality performs the clicking action on the Benefit section based on
	 * the user specified value. #Arguments:BenefitName Type:Textbox
	 */
	public boolean clickBenefitBasedontext(String[] benefitname) {
		try {
			Thread.sleep(1000);
			String benefit = benefitname[0];
			// *[contains(text(),'Mammogram')]/ancestor::td/preceding-sibling::td[contains(@class,'expandPane')]
			Driver.pgDriver.findElement(By.xpath("//*[contains(text(),'" + benefit
					+ "')]/ancestor::td/preceding-sibling::td[contains(@class,'expandPane')]")).click();
			return true;
		}

		catch (Exception e) {
			blogger.loginfo("Not able to click due to " + e);
			return !utils.isServiceDown();
		}
	}

	public boolean tagMedicalPlanLevelCoverage(String[] network) {
		try {
			String key = null, value = null;

			for (String iterator : network) {

				try {
					key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
					value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				} catch (Exception e) {
					key = iterator;
					value = iterator;

				}

				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseMedical, "Benefit Slection", "Pharmacy tab");
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseMedical, "Benefit Slection", "Pharmacy tab");
				wait = new WebDriverWait(Driver.pgDriver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@section_index='3']//*[@id='TagPlanLevelInNetwork']")));
				if (value.toLowerCase().contains("in") || key.toLowerCase().contains("in"))
					Driver.pgDriver.findElement(By.xpath("//div[@section_index='3']//*[@id='TagPlanLevelInNetwork']"))
							.click();
				else if (value.toLowerCase().contains("out") || key.toLowerCase().contains("out"))
					Driver.pgDriver
							.findElement(By.xpath("//div[@section_index='3']//*[@id='TagPlanLevelOutOfNetwork']"))
							.click();
				else {
					blogger.loginfo("Not valid input");
					return false;
				}

			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean tagPharmacyPlanLevelCoverage(String[] network) {
		try {
			String key = null, value = null;

			for (String iterator : network) {

				try {
					key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
					value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				} catch (Exception e) {
					key = iterator;
					value = iterator;

				}

				utils.clickAnelemnt(this.tabBenefitsSelectionBrowsePharmacy, "Benefit Slection", "Pharmacy tab");
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowsePharmacy, "Benefit Slection", "Pharmacy tab");
				wait = new WebDriverWait(Driver.pgDriver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[@section_index='4'][contains(@id,'BenefitsIndexMode')]//*[@id='TagPlanLevelInNetwork']")));
				if (value.toLowerCase().contains("in") || key.toLowerCase().contains("in"))
					Driver.pgDriver.findElement(By.xpath(
							"//div[@section_index='4'][contains(@id,'BenefitsIndexMode')]//*[@id='TagPlanLevelInNetwork']"))
							.click();
				else if (value.toLowerCase().contains("out") || key.toLowerCase().contains("out"))
					Driver.pgDriver.findElement(By.xpath(
							"//div[@section_index='4'][contains(@id,'BenefitsIndexMode')]//*[@id='TagPlanLevelOutOfNetwork']"))
							.click();
				else {
					blogger.loginfo("Not valid input");
					return false;
				}

			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean tagDentalPlanLevelCoverage(String[] network) {
		try {
			String key = null, value = null;

			for (String iterator : network) {

				try {
					key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
					value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				} catch (Exception e) {
					key = iterator;
					value = iterator;

				}

				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseDental, "Benefit Slection", "Dental tab");
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseDental, "Benefit Slection", "Dental tab");
				wait = new WebDriverWait(Driver.pgDriver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@section_index='5']//*[@id='TagPlanLevelInNetwork']")));
				if (value.toLowerCase().contains("in") || key.toLowerCase().contains("in"))
					Driver.pgDriver.findElement(By.xpath("//div[@section_index='5']//*[@id='TagPlanLevelInNetwork']"))
							.click();
				else if (value.toLowerCase().contains("out") || key.toLowerCase().contains("out"))
					Driver.pgDriver
							.findElement(By.xpath("//div[@section_index='5']//*[@id='TagPlanLevelOutOfNetwork']"))
							.click();
				else {
					blogger.loginfo("Not valid input");
					return false;
				}

			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean tagVisionPlanLevelCoverage(String[] network) {

		try {
			String key = null, value = null;

			for (String iterator : network) {

				try {
					key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
					value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();
				} catch (Exception e) {
					key = iterator;
					value = iterator;

				}

				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseVision, "Benefit Slection", "Pharmacy tab");
				utils.clickAnelemnt(this.tabBenefitsSelectionBrowseVision, "Benefit Slection", "Pharmacy tab");
				wait = new WebDriverWait(Driver.pgDriver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@section_index='6']//*[@id='TagPlanLevelInNetwork']")));
				if (value.toLowerCase().contains("in") || key.toLowerCase().contains("in"))
					Driver.pgDriver.findElement(By.xpath("//div[@section_index='6']//*[@id='TagPlanLevelInNetwork']"))
							.click();
				else if (value.toLowerCase().contains("out") || key.toLowerCase().contains("out"))
					Driver.pgDriver
							.findElement(By.xpath("//div[@section_index='6']//*[@id='TagPlanLevelOutOfNetwork']"))
							.click();
				else {
					blogger.loginfo("Not valid input");
					return false;
				}

			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public boolean validateNotesSectionsunderBenefits()

	{
		Assert.assertEquals(true,
				!Driver.pgDriver
						.findElement(By.xpath("//*[@class='content-item content-paragraph item-3   ']//li//span"))
						.getText().isEmpty());
		return true;
	}

	@SuppressWarnings("deprecation")
	public boolean validateLinksunderBenefits() {
		Assert.assertEquals(true, this.lnkBenefitSelectionplanlevelcoverage.isDisplayed());
		Assert.assertEquals(true, this.lnkBenefitSelectionBacktoTop.isDisplayed());
		return true;
	}

	public boolean checkforBenefitDoesnotExistmessage() {
		if (this.txtBrowseBenefitSelectionDoesnotExist.getText().contains(
				"Benefit details do not exist at this level. Select a specific sub-category from the below values"))
			return true;
		else {
			err.logError("Benefit Selection", "Browse- Benefit does not exist message ");
			return false;
		}

	}

	public boolean checkforMembernotActivemessage() throws InterruptedException {
		if(settxtbxDateofService("01/01/1991"))
		wait = new WebDriverWait(Driver.pgDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='MbrBenefitsInsight']//em")));
		if(utils.clickAnelemnt(txtBrowseBenefitSelectionRefresh, "ProviderBenefitAndCost", "Refresh"))
			if(utils.isvalueMatch_contain(txtBrowseBenefitSelectionMembernotactive.getText(), "Member not active on the date of service entered."))
				return true;
			return false;
	}

	/*
	 * @SCU #CommonMethodwithArgument:checkvalueinExpandedBenefitLevelCoverage
	 * #Description: This functionality validates the values present in the Benefit
	 * Selection Expanded Benefit table. #Arguments:Row Values in Comma Seperated
	 * Formated Type:Textbox
	 */
	public boolean checkvalueinExpandedBenefitLevelCoverage(String[] tablevalues) {
		if (utils.validateBenefitRowValues(this.tableBrowseBenefitSelectionExpandedBenefit, tablevalues))
				return true;
			return false;
	}

	public boolean Browse_validateStandAloneMessage(String[] Plan) {
		String value = Plan[0].substring(Plan[0].indexOf(":") + 1).toLowerCase();
		if (value.toLowerCase().contains("dent"))
			if (this.txtBrowseStandAlonemessage.getText()
					.contains("dental coverage not included with medical benefits, refer to appropriate dental "))
				return true;
			else
				return false;

		else if (value.toLowerCase().contains("visi"))
			if (this.txtBrowseStandAlonemessage.getText()
					.contains("vision coverage not included with medical benefits, refer to appropriate vision plan"))
				return true;
			else
				return false;
		else {
			err.logError("Benefit Selection", "Enter proper input");
			return false;
		}

	}

	/*
	 * @SCU #CommonMethodwithoutArgument:navigatetoAccessDocuments #Description:
	 * This functionality navigates to the Access Documents section from the Billing
	 * review section. Type:Textbox
	 */

	public boolean navigatetoAccessDocuments() {
	
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Access Documnets", "ProviderBenefitsAndCost", "Access Documents");
	}

	@FindBy(xpath = "//label[contains(text(),'Benefits Overview')][@class='textIn']")
	WebElement lblBenefitsOverview;
	/*
	 * @SCU #CommonMethodwithoutArgument:verifyBenefitsOverviewTabDisplay
	 * Type:Textbox Description: To verify "Benefits Overview" tab is displayed on
	 * Benefit selection page for LG
	 */
	@FindBy(xpath = "//*[data-test-id='20170615160747015554884']")
	WebElement benefitslabel;

	public boolean verifyBenefitsOverviewTabDisplay() {
		wait = new WebDriverWait(Driver.pgDriver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//label[contains(text(),'Benefit selection')][@class='actionTitleBarLabelStyle']")));
		if (utils.validateHeader(this.sHeaderBenefitSelection, "Benefit selection")) {
			if (utils.validateLabel(this.lblBenefitsOverview, "Benefits Overview")) {
				clickBenefitsOverview();
				if (utils.isProxyWebelement(benefitslabel))
					return true;
				else
					return false;
			} else
				err.logError("Benefit Selection", "Benefits Overview tab is not displayed for the LG ");
			return false;
		} else
			err.logError("Benefit Selection", "Benefit selection tab is not displayed. ");
		return false;
	}

	@FindBy(xpath = "//input[@id='DateOfService']")
	WebElement dateOfService;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(text(),'Search')]")
	WebElement searchBtn;

	@FindBy(xpath = "//label[contains(text(),'Search')][@class='textIn']")
	WebElement lblSearchBnft;

	/*
	 * @SCU #CommonMethodwithoutArgument:retrieveDateOfService Type:Textbox
	 * Description: To retrieve and verify Date of Service value - which is
	 * displayed, is defaulted to Current date.
	 */
	public boolean retrieveDateOfService() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String dateOfService = Driver.pgDriver.findElement(By.xpath("//input[@id='DateOfService']"))
				.getAttribute("value").trim();
		if (this.lblSearchBnft.isDisplayed() && this.searchBtn.isDisplayed()) {
			blogger.loginfo("Benefit Selection page defaults to: Search Tab and Search button is displayed on load");
			if (dateFormat.format(date).equalsIgnoreCase(dateOfService)) {
				blogger.loginfo("Date of Service is defaulted to the current date:" + dateOfService);
				return true;
			} else
				err.logError("Benefit Selection", "Date of Service did not default to the current date. ");
			return false;
		} else
			err.logError("Benefit Selection", "Search Tab and Search button is not displayed on load");
		return false;
	}

	@FindBy(xpath = "//input[@id='DateOfService']")
	private WebElement dateOfServiceTxtbox;

	/*
	 * @SCU #CommonMethodwithArgument:manuallyEnterDateOfService
	 * Arguments:DateOfService - Valid date Type:Textbox Description: To manually
	 * enter and verify Date of Service field accepts the following values - Past,
	 * Current and Future Dates. Also this method validates the date format passed
	 * in MM/dd/yyy format.
	 */
	public boolean manuallyEnterDateOfService(String[] arg) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		// Read the date parameter from script
		String tDate = arg[0].toString();
		// Read the default date displayed in UI -Current date.
		utils.waitforpageload();
		String dateOfService = dateOfServiceTxtbox.getAttribute("value").trim();
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		Actions action = new Actions(Driver.pgDriver);
		action.moveToElement(this.dateOfService).click().sendKeys(selectAll, Keys.BACK_SPACE).build().perform();
		// Replace current date which is displayed in UI.
		utils.enterTextinAnelemnt(this.dateOfService, tDate, "BenefitSelection", "Date Of Service");
		action.click(this.dateOfService).sendKeys(Keys.TAB).perform();
		utils.waitforpageload();
		if (!dateOfServiceTxtbox.getAttribute("value").trim().isEmpty()) {
			try {
				// Validation by entering a Past date
				if (sdf.parse(tDate).before(sdf.parse(dateOfService))) {
					blogger.loginfo("Date of Service entered is a date from the Past:" + tDate + "\n");
					return true;
				}
				// Validation by entering Future date
				else if (sdf.parse(tDate).after(sdf.parse(dateOfService))) {
					blogger.loginfo("Date of Service entered is a date in the Future:" + tDate + "\n");
					return true;
				}
				// Validation by entering current date
				else {
					blogger.loginfo("Date of Service entered is current date:" + tDate + "\n");
					return true;
				}
			} catch (ParseException e) {
				err.logError("Benefit Selection", "Exception occured in parsing the Date");
				e.printStackTrace();
				return false;
			}
		} else
			err.logError("Benefit Selection", "DateOfService value is refreshed");
		return false;

	}

	/*
	 * @SCU #CommonMethodwithArgument:patternValidationDateOfService
	 * Arguments:DateOfService - Valid date Type:Textbox Description: Also this
	 * method validates the date format passed in MM/dd/yyy format.
	 */
	public boolean patternValidationDateOfService(String[] arg) {
		// Read the date parameter from script
		String tDate = arg[0].toString();
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		Actions action = new Actions(Driver.pgDriver);
		action.moveToElement(this.dateOfService).click().sendKeys(selectAll, Keys.BACK_SPACE).build().perform();
		// Replace current date which is displayed in UI.
		utils.enterTextinAnelemnt(this.dateOfService, tDate, "BenefitSelection", "Date Of Service");
		action.click(this.dateOfService).sendKeys(Keys.TAB).perform();
		pgDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String replacedDate = Driver.pgDriver.findElement(By.xpath("//input[@id='DateOfService']"))
				.getAttribute("value").trim();
		if (Pattern.matches("[0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4}", replacedDate)) {
			blogger.loginfo("Replaced by date:" + replacedDate + "\n");
			return true;
		} else {
			err.logError("Benefit Selection", "DateOfService value doesnt match pattern");
			return false;
		}
	}

	@FindBy(xpath = "//*[@id='PegaRULESErrorFlag']")
	WebElement errLblDOS;

	/*
	 * @SCU #CommonMethodwithArgument:invalidDateOfService Arguments:DateOfService -
	 * Invalid date Type:Textbox Description: This method validates - that error
	 * message is displayed when invalid/incorrect date is passed to Date of Service
	 * Field
	 */
	public boolean invalidDateOfService(String[] arg) {
		// Read the incorrect date parameter from script
		String tDate = arg[0].toString();
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		Actions action = new Actions(Driver.pgDriver);
		action.moveToElement(this.dateOfService).click().sendKeys(selectAll, Keys.BACK_SPACE).build().perform();
		// Replace current date which is displayed in UI.
		utils.enterTextinAnelemnt(this.dateOfService, tDate, "BenefitSelection", "Date Of Service");
		action.click(this.dateOfService).sendKeys(Keys.TAB).perform();
		wait = new WebDriverWait(Driver.pgDriver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='PegaRULESErrorFlag']")));
		String replacedDate = this.dateOfService.getAttribute("value").trim();
		if (pgDriver
				.findElement(By.xpath("//*[@id='PegaRULESErrorFlag'][contains(text(),'is not a valid date value')]"))
				.isDisplayed()) {
			blogger.loginfo("Invalid date format is entered:" + replacedDate + "\n");
			return true;
		} else {
			blogger.loginfo("Valid Date format is entered!");
			err.logError("Benefit Selection", "Valid Date format is entered, negative test - Hence script failed");
			return false;
		}
	}

	@FindBy(xpath = "//a[@id='TABANCHOR']//label[contains(text(),'Benefits Overview')]")
	WebElement labelBenefitOverview;

	/*
	 * @SCU #CommonMethodwithoutArgument:clickBenefitsOverview Type:Textbox
	 * Description: This method clicks on Benefits Overview tab - Benefit selection
	 */
	public boolean clickBenefitsOverview() {

		if (utils.validateLabel(this.labelBenefitOverview, "Benefits Overview")) {
			utils.clickAnelemnt(this.labelBenefitOverview, "Benefit Selection", "Benefits Overview");
			utils.waitforpageload();
			blogger.loginfo("Successsfully clicked Benefits Overview tab" + "\n");
			return true;
		} else {
			blogger.loginfo("Unable to locate and click Benefits Overview tab");
			err.logError("Benefit Selection", "Unable to locate and click Benefits Overview tab ");
			return false;
		}
	}

	@FindBy(xpath = "//span[contains(text(),'Benefits shown are for contract')]")
	WebElement lblBOContract;

	/*
	 * @SCU #CommonMethodwithArgument:checkDOSContractDetails
	 * #Arguments:MemberInfo-KeyValuePair Type:Table
	 * Keys:ccode#ceffdate#ctermdate#contract# Description: This method validates
	 * benefits for the member based on the current Date of Service. "Benefits shown
	 * are for contract<Contract Code>, effective <Contract Segment Effective Date>
	 * to <Contract Segment Term Date> for this <Contract Name>"
	 */
	public boolean checkDOSContractDetails(String[] args) {
		boolean returnvar;
		String ccode = "", ceffdate = "", ctermdate = "";
		String contractValues[] = null;
		returnvar = true;
		if (utils.validateLabel(this.lblBenefitsOverview, "Benefits Overview")) {
			String keyvaluepair = "";
			for (String iterator : args) {
				if (!returnvar) {
					err.logcommonMethodError("Benefits Selection", "Check your " + keyvaluepair
							+ " Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":") + 1).toLowerCase();

				if (utils.isvalueMatch_contain(key.toLowerCase(), "ccode")) {
					ccode = value.trim();
					returnvar = this.lblBOContract.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					continue;
				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "ceffdate")) {
					ceffdate = value.trim();
					returnvar = this.lblBOContract.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					continue;
				}

				else if (utils.isvalueMatch_contain(key.toLowerCase(), "ctermdate")) {
					ctermdate = value.trim();
					returnvar = this.lblBOContract.getText().toLowerCase().trim().contains(value.toLowerCase().trim());
					continue;
				} else if (utils.isvalueMatch_contain(key.toLowerCase(), "contract")) {
					contractValues = value.split("-");
					returnvar = this.lblBOContract.getText().toLowerCase().trim()
							.contains(contractValues[0].toLowerCase().trim())
							&& this.lblBOContract.getText().toLowerCase().trim()
									.contains(contractValues[1].toLowerCase().trim());
					continue;
				} else
					err.logcommonMethodError("Benefits Selection",
							"Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

		} else
			err.logError("Benefits Selection", "Benefits Overview tab");

		if (returnvar) {
			String target = "Benefits shown are for contract " + ccode + ", effective " + ceffdate + " to " + ctermdate
					+ " for this " + contractValues[0] + ", " + contractValues[1] + ".";
			if (this.lblBOContract.getText().equalsIgnoreCase(target))
				blogger.loginfo("Benefits Overview tab info checked Successfully");
			return true;
		} else {
			int tot_i = args.length;
			err.logcommonMethodError("Benefits Selection",
					"the value " + args[tot_i - 1].toString() + " doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath = "//div[text()='Benefits Admin']")
	WebElement lblBenefitsAdmin;

	@FindBy(xpath = "//div[text()='Benefits']")
	WebElement lblBenefits;

	@FindBy(linkText = "Major Category")
	WebElement majorCategoryLink;

	@FindBy(linkText = "Benefits Notes")
	WebElement benefitsNotesLink;

	@FindBy(xpath = "//div[text()='Benefits']//ancestor::div[@id='CT']")
	WebElement benefitsSection;

	@FindBy(xpath = "//div[text()='Benefits Admin']//ancestor::div[@id='CT']")
	WebElement benefitsAdminSection;

	@FindBy(xpath = "//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable ']")
	WebElement benefitsTbl;

	@FindBy(xpath = "//div[text()='Benefits Admin']//ancestor::div[@id='CT']//table[@class='gridTable ']")
	WebElement benefitsAdminTbl;

	/*
	 * @SCU #CommonMethodwithArgument:verifybenefitsAndBenefitsAdminColHeader
	 * #Arguments:Column headers should be passed as comma separated parameters,as
	 * in order of UI -'Contract Benefit Layout,Network,Value,Accum,Note'. Type:Text
	 * Description: This method verifies that Benefits and Benefits Admin tables are
	 * displayed, when user clicks on Benefits Overview tab. Also validates the
	 * column headers for Benefits and Benefits Admin sections.
	 */
	public boolean verifybenefitsAndBenefitsAdminColHeader(String[] args) {
		String space = " ";
		StringBuilder input = new StringBuilder();
		blogger.loginfo("Newly constructed Input:"
				+ input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",")
						.append(args[2]).append(",").append(args[3]).append(",").append(args[4]).toString());
		String colHdrs[] = input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",")
				.append(args[2]).append(",").append(args[3]).append(",").append(args[4]).toString().split(",");
		if (utils.validateLabel(this.lblBenefits, "Benefits")
				&& utils.validateLabel(this.lblBenefitsAdmin, "Benefits Admin")) {
			if (utils.validateTableRowHeader(this.benefitsTbl, colHdrs)
					&& utils.validateTableRowHeader(this.benefitsAdminTbl, colHdrs)) {
				return true;
			}
			err.logError("BenefitsSelection",
					"Column headers do not match in- Benefits & Benefits Admin sections - Benefits Overview tab");
			return false;
		} else
			err.logError("BenefitsSelection",
					"Benefits & Benefits Admin sections are not displayed in UI - Benefits Overview tab");
		return false;
	}

	// webelements

	@FindBy(xpath = "//span[@data-test-id='20170615134626066739666']")
	private WebElement ContractBenefitLayout;

	@FindBy(xpath = "//div[text()='Benefits Admin']//ancestor::div[@id='CT']//table[@class='gridTable ']/preceding::a[text()='Show All']")
	private WebElement benefitShowAll;

	@FindBy(xpath = "//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable ']//span[@data-test-id='20170615134626066739666']")
	private List<WebElement> benefitContractBenefitLayout;

	@FindBy(xpath = "//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable ']//span[@data-test-id='20170615162452075610919']")
	private List<WebElement> benefitNetwork;

	@FindBy(xpath = "//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable ']//span[@data-test-id='201706151624520757106938']")
	private List<WebElement> benefitValue;

	@FindBy(xpath = "//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable ']//span[@data-test-id='201706151624520757103527']")
	private List<WebElement> benefitAccum;

	/*
	 * @SCU #CommonMethodwithArgument:checkRowunderBenefitsTable #Arguments:benefit
	 * table row values should be passed as comma separated parameters,as in order
	 * of UI -'Contract Benefit Layout,Network,Value,Accum'. Type:Text Description:
	 * This method verifies that Benefits table row value are displayed. Also
	 * validates Row values for Benefits table
	 */

	public boolean checkRowunderBenefitsTable(String[] args) throws InterruptedException {

		try {
			int i = 0;
			try {
				utils.clickAnelemnt(this.benefitShowAll, "BenefitSelection", "benefitShowAll");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("benefitShowAll is not present");
			}
			utils.waitforpageload();

			// List<WebElement> ContractBenefitLayout =
			// Driver.getPgDriver().findElements(By.xpath("//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable
			// ']//span[@data-test-id='20170615134626066739666']"));
			// List<WebElement> Network =
			// Driver.getPgDriver().findElements(By.xpath("//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable
			// ']//span[@data-test-id='20170615162452075610919']"));
			// List<WebElement> Value =
			// Driver.getPgDriver().findElements(By.xpath("//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable
			// ']//span[@data-test-id='201706151624520757106938']"));
			// List<WebElement> Accum =
			// Driver.getPgDriver().findElements(By.xpath("//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable
			// ']//span[@data-test-id='201706151624520757103527']"));
			//
			ArrayList<String> ContractBenefitLayoutarray = new ArrayList<>();
			ArrayList<String> Networkarray = new ArrayList<>();
			ArrayList<String> Valuearray = new ArrayList<>();
			ArrayList<String> Accumarray = new ArrayList<>();

			for (WebElement web : benefitContractBenefitLayout) {
				String text = web.getText();
				System.out.println(text);
				ContractBenefitLayoutarray.add(text);
			}

			for (WebElement web : benefitNetwork) {
				String text = web.getText();
				System.out.println(text);
				Networkarray.add(text);
			}

			for (WebElement web : benefitValue) {
				String text = web.getText();
				System.out.println(text);
				Valuearray.add(text);
			}

			for (WebElement web : benefitAccum) {
				String text = web.getText();
				System.out.println(text);
				Accumarray.add(text);
			}

			if (ContractBenefitLayoutarray.contains(args[0])) {
				i = ContractBenefitLayoutarray.indexOf(args[0]);

				if (utils.isvalueMatch_contain(Networkarray.get(i), args[1])) {
					System.out.println(Networkarray.get(i) + "matches " + args[1]);

					if (utils.isvalueMatch_contain(Valuearray.get(i), args[2])) {
						System.out.println(Valuearray.get(i) + "matches   " + args[2]);
						if (args.length > 3) {
							if (utils.isvalueMatch_contain(Accumarray.get(i), args[3])) {
								return true;
							}

							err.logError("BenefitsSelection",
									args[3] + "the input value does not match in the table values" + Accumarray.get(i));

						} else
							return true;
					}
					err.logError("BenefitsSelection",
							args[2] + "the input value does not match in the table values" + Valuearray.get(i));
				}

				err.logError("BenefitsSelection",
						args[1] + "the input value does not match in the table values" + Networkarray.get(i));

			}

			err.logError("BenefitsSelection", "Benefit table verification failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			j++;
			if (j == 1) {
				checkRowunderBenefitsTable(args);
				return true;
			}
		}

		return false;

	}

	@FindBy(xpath = "//div[text()='Benefits']//ancestor::div[@id='CT']//table[@class='gridTable ']/following::a[text()='Show All']")
	private WebElement benefitAdminShowAll;

	@FindBy(xpath = "//div[text()='Benefits Admin']//ancestor::div[@id='CT']//table[@class='gridTable ']//span[@data-test-id='20170615134626066739666']")
	private List<WebElement> benefitAdminContractBenefitLayout;

	@FindBy(xpath = "//div[text()='Benefits Admin']//ancestor::div[@id='CT']//table[@class='gridTable ']//span[@data-test-id='20170615162452075610919']")
	private List<WebElement> benefitAdminNetwork;

	@FindBy(xpath = "//div[text()='Benefits Admin']//ancestor::div[@id='CT']//table[@class='gridTable ']//span[@data-test-id='201706151624520757106938']")
	private List<WebElement> benefitAdminValue;

	@FindBy(xpath = "//div[text()='Benefits Admin']//ancestor::div[@id='CT']//table[@class='gridTable ']//span[@data-test-id='201706151624520757103527']")
	private List<WebElement> benefitAdminAccum;

	int j = 0;

	/*
	 * @SCU #CommonMethodwithArgument:checkRowunderBenefitsAdminTable
	 * #Arguments:benefit admin table row values should be passed as comma separated
	 * parameters,as in order of UI -'Contract Benefit Layout,Network,Value,Accum'.
	 * Type:Text Description: This method verifies that Benefits admin table row
	 * value are displayed. Also validates Row values for Benefits admin table
	 */

	public boolean checkRowunderBenefitsAdminTable(String[] args) throws InterruptedException {

		try {
			int i = 0;
			try {
				utils.clickAnelemnt(this.benefitAdminShowAll, "BenefitSelection", "benefitShowAll");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("benefitAdminShowAll is not present");
			}
			utils.waitforpageload();
			// List<WebElement> ContractBenefitLayout =
			// Driver.getPgDriver().findElements(By.xpath("//div[text()='Benefits
			// Admin']//ancestor::div[@id='CT']//table[@class='gridTable
			// ']//span[@data-test-id='20170615134626066739666']"));
			// List<WebElement> Network =
			// Driver.getPgDriver().findElements(By.xpath("//div[text()='Benefits
			// Admin']//ancestor::div[@id='CT']//table[@class='gridTable
			// ']//span[@data-test-id='20170615162452075610919']"));
			// List<WebElement> Value =
			// Driver.getPgDriver().findElements(By.xpath("//div[text()='Benefits
			// Admin']//ancestor::div[@id='CT']//table[@class='gridTable
			// ']//span[@data-test-id='201706151624520757106938']"));
			// List<WebElement> Accum =
			// Driver.getPgDriver().findElements(By.xpath("//div[text()='Benefits
			// Admin']//ancestor::div[@id='CT']//table[@class='gridTable
			// ']//span[@data-test-id='201706151624520757103527']"));
			// //
			ArrayList<String> ContractBenefitLayoutarray = new ArrayList<>();
			ArrayList<String> Networkarray = new ArrayList<>();
			ArrayList<String> Valuearray = new ArrayList<>();
			ArrayList<String> Accumarray = new ArrayList<>();

			for (WebElement web : benefitAdminContractBenefitLayout) {
				String text = web.getText();
				System.out.println(text);
				ContractBenefitLayoutarray.add(text);
			}

			for (WebElement web : benefitAdminNetwork) {
				String text = web.getText();
				System.out.println(text);
				Networkarray.add(text);
			}

			for (WebElement web : benefitAdminValue) {
				String text = web.getText();
				System.out.println(text);
				Valuearray.add(text);
			}

			for (WebElement web : benefitAdminAccum) {
				String text = web.getText();
				System.out.println(text);
				Accumarray.add(text);
			}

			if (ContractBenefitLayoutarray.contains(args[0])) {
				i = ContractBenefitLayoutarray.indexOf(args[0]);

				if (utils.isvalueMatch_contain(Networkarray.get(i), args[1])) {
					System.out.println(Networkarray.get(i) + "matches " + args[1]);

					if (utils.isvalueMatch_contain(Valuearray.get(i), args[2])) {
						System.out.println(Valuearray.get(i) + "matches   " + args[2]);
						if (args.length > 3) {
							if (utils.isvalueMatch_contain(Accumarray.get(i), args[3])) {
								return true;
							}

							err.logError("BenefitsSelection",
									args[3] + "the input value does not match in the table values" + Accumarray.get(i));
							return false;
						} else
							return true;
					}
					err.logError("BenefitsSelection",
							args[2] + "the input value does not match in the table values" + Valuearray.get(i));
					return false;
				}

				err.logError("BenefitsSelection",
						args[1] + "the input value does not match in the table values" + Networkarray.get(i));
				return false;
			} else {
				err.logError("BenefitsSelection", "Benefit admin table verification failed");
				return false;
			}

		} catch (StaleElementReferenceException e) {
			j++;
			if (j == 1) {
				checkRowunderBenefitsAdminTable(args);
				return true;
			}
		}

		return false;

	}

	/*
	 * @SCU #CommonMethodwithoutArgument:verifyBenefitsOverviewTabIsNotDisplayed
	 * Type:Textbox Description: To verify "Benefits Overview" tab is not displayed
	 * on Benefit selection page
	 */
	public boolean verifyBenefitsOverviewTabIsNotDisplayed() {
		wait = new WebDriverWait(Driver.pgDriver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//label[contains(text(),'Benefit selection')][@class='actionTitleBarLabelStyle']")));
		if (utils.validateHeader(this.sHeaderBenefitSelection, "Benefit selection")) {
			try {
				if (!utils.validateLabel(this.lblBenefitsOverview, "Benefits Overview")) {
					System.out.println("Benefits Overview tab is not displayed in UI:");
					return true;
				} else
					err.logError("Benefit Selection", "Benefits Overview tab is Displayed");
				return false;
			} catch (NoSuchElementException e) {
				System.out.println("Benefits Overview tab is not displayed in UI:");
				return true;
			}
		} else
			err.logError("Benefit Selection", "Benefit selection tab is not displayed. ");
		return false;
	}

	public boolean ClickchkbxBenefitsMTMTag() {

		utils.clickAnelemnt(this.chkbxBenefitsMTMTag, "Benefit Selection", "MTM Tag ");
		utils.waitforpageload();
		clickgetBtnSubmit();
		return true;

	}

	// Sprint 3.1

	@FindBy(xpath = "//span[contains(text(),'Related Plan Accumulators')]")
	WebElement lnkRelatedPlanAccums;

	@FindBy(xpath = "//span[contains(text(),'Related Benefit Accumulators')]")
	WebElement lnkRelatedBenefitAccums;

	@FindBy(xpath = "//div[@node_name='BenefitAccumulators']//span[@data-test-id='20170615115925059917443']")
	WebElement labelContractCodeInBenefitAccums;

	@FindBy(xpath = "//div[@node_name='BenefitAccumulators']//span[@data-test-id='20170615115925060018342']")
	WebElement labelCoveragePeriodInBenefitAccums;

	@FindBy(xpath = "//table[@pl_prop='.BenefitLevelAccumList']")
	WebElement tblBenefitLevelTableInBenefitAccums;

	@FindBy(xpath = "//div[@node_name='PlanAccumulators']//span[@data-test-id='20170615115925059917443']")
	WebElement labelContractCodeInPlanAccums;

	@FindBy(xpath = "//div[@node_name='PlanAccumulators']//span[@data-test-id='20170615115925060018342']")
	WebElement labelCoveragePeriodInPlanccums;

	@FindBy(xpath = "//table[contains(@param_name,'EXPANDEDSubSectionMemberLevelAccumulator')]//table[@pl_prop='.FamilyLevelAccumList']")
	WebElement tblMemberLevlInPlanAccums;

	@FindBy(xpath = "//table[contains(@param_name,'EXPANDEDSubSectionFamilyLevelAccumulator')]//table[@pl_prop='.FamilyLevelAccumList']")
	WebElement tblFamilyLevelInPlanAccums;
	
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyRelatedBenefitAccumulatorIsDisplayed
	 * #Description: Verifies that the Benefit Accumulator link is displayed or not under Browse section
	 * Type: Textbox
	 */
	
	public boolean verifyRelatedBenefitAccumulatorsIsDisplayed()
	{
		try
		{
			WebElement element = this.lnkRelatedBenefitAccums;
     		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			this.lnkRelatedBenefitAccums.isDisplayed();
			blogger.loginfo("Related Benefit Accumulator link is displayed");
			System.out.println("Related Benefit Accumulator link is displayed");
			return true;
		}catch(Exception e)
		{
			blogger.loginfo("Related Benefit Accumulator link is not displayed");
			System.out.println("Related Benefit Accumulator link is not displayed");
			err.logcustomerrorwithmessage("BenefitsSelection", "verifyRelatedBenefitAccumulatorIsDisplayed", "Related Benefit Accums link is not displayed");
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyRelatedPlanAccumulatorIsDisplayed
	 * #Description: Verifies that the Plan Accumulator link is displayed or not under Browse section
	 * Type: Textbox
	 */
	public boolean verifyRelatedPlanAccumulatorsIsDisplayed()
	{
		try
		{
			WebElement element = this.lnkRelatedPlanAccums;
     		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			this.lnkRelatedPlanAccums.isDisplayed();
			blogger.loginfo("Related Plan Accumulator link is displayed");
			System.out.println("Related Plan Accumulator link is displayed");
			return true;
		}catch(Exception e)
		{
			blogger.loginfo("Related Plan Accumulator link is not displayed");
			System.out.println("Related Plan Accumulator link is not displayed");
			err.logcustomerrorwithmessage("BenefitsSelection", "verifyRelatedPlanAccumulatorIsDisplayed", "Related Plan Accums link is not displayed");
			return false;
		}
	}
	
	public boolean clickRelatedBenefitAccums()
	{
		return utils.clickAnelemnt(this.lnkRelatedBenefitAccums, "BenefitSelection", "Benefit Accums Link");
	}
	
	public boolean clickRelatedPlanAccums()
	{
		return utils.clickAnelemnt(this.lnkRelatedPlanAccums, "BenefitSelection", "Plan Accums Link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateContractCodeValueInBenefitAccums
	 * #Description: Validate the Contract Code Value In Benefit Accums section
	 * Type: Textbox
	 */
	public boolean validateContractCodeValueInBenefitAccums(String[] args)
	{
		try
		{
			this.clickRelatedBenefitAccums();
			utils.validateLabel(this.labelContractCodeInBenefitAccums, args[0]);
			this.clickRelatedBenefitAccums();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("BenefitsSelection", "validateContractCodeValueInBenefitAccums", "Contract Code Value mis match");
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateContractCodeValueInPlanAccums
	 * #Description: Validate the Contract Code Value In Plan Accums section
	 * Type: Textbox
	 */
	public boolean validateContractCodeValueInPlanAccums(String[] args)
	{
		try
		{
			this.clickRelatedPlanAccums();
			utils.validateLabel(this.labelContractCodeInPlanAccums, args[0]);
			this.clickRelatedPlanAccums();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("BenefitsSelection", "validateContractCodeValueInPlanAccums", "Contract Code Value mis match");
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateCoveragePeriodValueInBenefitAccums
	 * #Description: Validate the Coverage Period Value In Benefit Accums section
	 * Type: Textbox
	 */
	public boolean validateCoveragePeriodValueInBenefitAccums(String[] args)
	{
		try
		{
			this.clickRelatedBenefitAccums();
			utils.validateLabel(this.labelCoveragePeriodInBenefitAccums, args[0]);
			this.clickRelatedBenefitAccums();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("BenefitsSelection", "validateCoveragePeriodValueInBenefitAccums", "Coverage Period Value mis match");
			return false;
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateCoveragePeriodValueInPlanAccums
	 * #Description: Validate the Coverage Period Value In Plan Accums section
	 * Type: Textbox
	 */
	public boolean validateCoveragePeriodValueInPlanAccums(String[] args)
	{
		try
		{
			this.clickRelatedPlanAccums();
			utils.validateLabel(this.labelCoveragePeriodInPlanccums, args[0]);
			this.clickRelatedPlanAccums();
			return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("BenefitsSelection", "validateCoveragePeriodValueInPlanAccums", "Coverage Period Value mis match");
			return false;
		}
	}
	
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectMemberLevelAccumulators
	 * #Description: Validates the row given by the user with the row present in the Member Level table and then tags the respective accumulators
	 * #Argument: MemberLevel-Keyvaluepair
	 * Type:Table
	 * Keys: Network#Accumulator Description#Limit#Accumulated#Remaining#Start Date#End Date
	 */
	public boolean selectMemberLevelAccumulator(String[] args)
	{
		try
		{
			this.clickRelatedPlanAccums();
			boolean returnvar =true;
	          String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
	          ArrayList<String> expected= new ArrayList<String>();
	          checkforpageload();
	          for(String iterator : args)
	          {
	                 String keyvaluepair = iterator;
	                 if(!returnvar)
	                 {
	                       err.logcommonMethodError("selectMemberLevelAccumulator", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
	                       return false;
	                 
	                 }
	                 String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
	                 String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
	                 System.out.println("key " + key + "value  " + value);
	                 
	                 if(key.toLowerCase().contains("level"))
	                 {                    
	                                     returnvar=true;
	                                     level=value.toLowerCase().trim();                      
	                                     continue;
	                              
	                 }
	                 else if(key.toLowerCase().contains("network"))
	                 {
	                              returnvar=true;
	                              NW=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("accumulator description"))
	                 {
	                              returnvar=true;
	                              desc=value.toLowerCase().trim();
	                               continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("limit"))
	                 {
	                              returnvar=true;
	                              limit=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("accumulated"))
	                 {
	                              returnvar=true;
	                              accums=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("remaining"))
	                 {
	                              returnvar=true;
	                              remain=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("start date"))
	                 {
	                              returnvar=true;
	                              startdt=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("end date"))
	                 {
	                              returnvar=true;
	                              enddt=value.toLowerCase().trim();
	                              continue;
	                 }
	                 else
	                 {
	                 err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
	              return false;
	                 }
	          }
	                 if(returnvar)
	                 {
	                 System.out.println("No issues in Key value pair");
	                 }
			WebElement element = this.tblMemberLevlInPlanAccums;
     		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
     		WebElement row= utils.getProviderResultsBasedOnValues(this.tblMemberLevlInPlanAccums,args);
     		List<WebElement> rowno = row.findElements(By.tagName("input"));
     		rowno.get(1).click();
     		
     		return true;
		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
			err.logcustomerrorwithmessage("BenefitsSelection","selectMemberLevelAccumulators" , "Error in Selecting the Member Level Accumulators");
			return false;
			
		}
	}
	
	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectFamilyLevelAccumulators
	 * #Description: Validates the row given by the user with the row present in the Family Level table and then tags the respective accumulators
	 * #Argument: FamilyLevel-Keyvaluepair
	 * Type:Table
	 * Keys: Network#Accumulator Description#Limit#Accumulated#Remaining#Start Date#End Date
	 */
	public boolean selectFamilyLevelAccumulator(String[] args)
	{
		try
		{
		
			this.clickRelatedPlanAccums();
			boolean returnvar =true;
	          String level= null,NW= null,desc = null,limit= null,accums= null,remain= null,startdt= null,enddt=null;
	          ArrayList<String> expected= new ArrayList<String>();
	          checkforpageload();
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
	                 
	                 if(key.toLowerCase().contains("level"))
	                 {                    
	                                     returnvar=true;
	                                     level=value.toLowerCase().trim();                      
	                                     continue;
	                              
	                 }
	                 else if(key.toLowerCase().contains("network"))
	                 {
	                              returnvar=true;
	                              NW=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("accumulator description"))
	                 {
	                              returnvar=true;
	                              desc=value.toLowerCase().trim();
	                               continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("limit"))
	                 {
	                              returnvar=true;
	                              limit=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("accumulated"))
	                 {
	                              returnvar=true;
	                              accums=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("remaining"))
	                 {
	                              returnvar=true;
	                              remain=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("start date"))
	                 {
	                              returnvar=true;
	                              startdt=value.toLowerCase().trim();
	                              continue;
	                       
	                 }
	                 else if(key.toLowerCase().contains("end date"))
	                 {
	                              returnvar=true;
	                              enddt=value.toLowerCase().trim();
	                              continue;
	                 }
	                 else
	                 {
	                 err.logcommonMethodError("Accumulators", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
	              return false;
	                 }
	          }
	                 if(returnvar)
	                 {
	                 System.out.println("No issues in Key value pair");
	                 }
			WebElement element = this.tblFamilyLevelInPlanAccums;
     		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
     		WebElement row=   utils.getProviderResultsBasedOnValues(this.tblFamilyLevelInPlanAccums,args);
     		List<WebElement> rowno = row.findElements(By.tagName("input"));
     		rowno.get(1).click();
     		return true;
		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
			err.logcustomerrorwithmessage("BenefitsSelection","selectFamilyLevelAccumulators" , "Error in Selecting the Family Level Accumulators");
			return false;
			
		}
	}
	
	
	public boolean clickBtnSubmitInBrowse() throws InterruptedException
	{
		try
		{
		WebElement element = this.btnSubmit;
 		((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		utils.clickAnelemnt(btnSubmit, "BenefitsSelection", "Submit button");
		Thread.sleep(3000);
		Driver.pgDriver.switchTo().alert().accept();
		return true;
		}catch(Exception e)
		{
			err.logcustomerrorwithmessage("BenefitsSelection", "clickBtnSubmitInBrowse", "Error in clicking Submit");
			return false;
		}
	}
		

	public boolean verifyHB1353Disclaimer()
	{
		String disclaimer = HB1353Dis.getText();
		System.out.println("Discliamer  " + disclaimer);
		utils.validateLabel(HB1353Dis, "Eligibility is contingent on payment of the premium due and the eligibility cannot be confirmed for the period that the premium is outstanding.");
		return true;
	}
	
	public boolean verifyQuoteDisclaimer()
	{
		utils.waitForElementToBeVisible(QuoteDisclaimer);
		String Qdisclaimer = QuoteDisclaimer.getText();
		System.out.println("Discliamer  " + Qdisclaimer);
		utils.validateLabel(QuoteDisclaimer, "Verification of Benefits or coverage is not a guarantee of eligibility or payment. Actual payment is based on terms and conditions of the plan.");
		return true;
	}
	
	public boolean verifyQuoteNervousDisclaimer()
	{
		String Qndisclaimer = NervousDisclaimer.getText();
		System.out.println("Discliamer  " + Qndisclaimer);
		return utils.isvalueMatch_contain(Qndisclaimer, "I must tell you information mandated by the state of California. Benefits for treatment of Severe Mental Illness of enrollees will be provided at the same levels of coverage as coverage for other medical diagnosis. All other nervous and mental conditions will be covered as follows: (CCA would quote the benefit as the contract states).");
	}
	
	public boolean clickQuoteDisclaimer()
	{
		return utils.clickAnelemnt(checkBoxQuoteDisclaimer, "ProvierBenefitsandcost", "Quote disclaimer");
	}
	
	public boolean clickQuoteNervousDisclaimer()
	{
	
		return utils.clickAnelemnt(checkBoxQuoteNervousDisclaimer, "ProvierBenefitsandcost", "Quote Nervous disclaimer");
		
	}
	
	public boolean clickHB1353Disclaimer()
	{
	
		return utils.clickAnelemnt(checkBoxHB1353Disclaimer, "ProvierBenefitsandcost", "HB1353 disclaimer");
		
	}
	
	
}


