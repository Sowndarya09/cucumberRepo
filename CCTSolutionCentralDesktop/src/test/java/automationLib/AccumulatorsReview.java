package automationLib;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtilities;
import utils.ErrorLogger;
import utils.BaseLogger;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccumulatorsReview extends Driver
{
	@FindBy(xpath="//Select[@id='PrimaryReasonforBilling']")
	private WebElement RsnFrContact;
	@FindBy(xpath="//textarea[@id='pyNote']")
	private WebElement notes;
	@FindBy(xpath= "//*[@class='layout-body clearfix']/table/tbody/tr[1]/td[2]")
	WebElement Contract_Code_revw;
	@FindBy(xpath= "//*[@class='layout-body clearfix']/table/tbody/tr[2]/td[2]")
	WebElement Covrge_Prd_revw;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionReviewMemberAccumInfoBBB']")
	private WebElement MemLvlTable;
	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionReviewMemberAccumInfoBBBBB']")
	private WebElement FamLvlTable;
	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionReviewMemberAccumInfoBBBBBBB']")
	private WebElement BenLvlTable;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement BtnSubmit;

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View Accumulators']")	
	private WebElement lnkOtherViewAccums;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Manager Help']")	
	private WebElement lnkOtherReqMgrHelp;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Accumulator Sync']")	
	private WebElement lnkOtherReqAccmsSync;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Accumulator Update']")	
	private WebElement lnkOtherReqAccumsUpdate;
	@FindBy(xpath="//*[@class='oflowDivM ']")
	private WebElement TaggedChkBoxes;
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderAccums;
	@FindBy(xpath="//select[@id='PrimaryReasonforBilling']")
	private WebElement dropdownReasonForContact;
	@FindBy(id="pyNote")
	private WebElement txtBoxNotes;

	public WebElement getHeader()
	{
		return sHeaderAccums;
	}
	public boolean selectDropdownReasonForContact(String sReason)
	{
		return utils.selectDropDownbyVisibleString(this.dropdownReasonForContact, sReason, "Accumulators Review ", "Drop Down to select the value");
	}
	public boolean validateHeader(WebElement header)
	{
		if(header.isDisplayed())
		{
			if(header.getText().trim().equalsIgnoreCase("Accumulators Review"))
			{
				System.out.println("Pass : The header matches the specks and is displayed as required. \n\n");
				return true ;
			}
		}
		err.logError("The header does not match the specified text.");
		return false; 
	}
	public boolean setTxtNotes(String notes)
	{
		return utils.enterTextinAnelemnt(this.txtBoxNotes, notes, "Accumulators Review ", "Text Box for entering ?Notes");
	}
	
	public boolean clickgetBtnSubmit()
	{

		return utils.clickAnelemnt(this.BtnSubmit, "Accumulators Review", "Submit Button");
	}
	
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Accumulators class defining the Iframe and the Page Factory  
	 */
	public AccumulatorsReview() throws IOException
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
	Accumulators acc=new Accumulators();
	Actions action=new Actions(Driver.getPgDriver());
	@SuppressWarnings("unchecked")
	public boolean validatetaggedcheckboxesBenefitLevel()
	{
		ArrayList<String> actual = new ArrayList<String>();
		ArrayList<String> expected=new ArrayList<String>(); 
		List<WebElement> count=null;
		Boolean returnvar=true;
		String xpath1=null;
			
		 try
		 {
			 wait=new WebDriverWait(Driver.pgDriver,20);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@param_name='EXPANDEDSubSectionReviewMemberAccumInfoBBBBBBB']")));
			
		 }
		 catch(Exception e)
		 {
			 System.out.println("Tagged element not found in Accumulator review screen");
			 returnvar=false;
		 }
		 xpath1="(//div[@param_name='EXPANDEDSubSectionReviewMemberAccumInfoBBBBBBB']//*[@title='True'])";
		 count=Driver.pgDriver.findElements(By.xpath(xpath1));
		 if(!(count.isEmpty()))
		 {
			 for(int i=2;i<=8;i++)
			 {
				 for(int j=1;j<=count.size();j++)
				 {
					 String xpath2="(//div[@param_name='EXPANDEDSubSectionReviewMemberAccumInfoBBBBBBB']//*[@class='gridTable ']//td["+i+"])[position()="+j+"]";
					 WebElement ele=Driver.pgDriver.findElement(By.xpath(xpath2));
						String toStore=ele.getText().toLowerCase().trim();
						actual.add(toStore);
						returnvar=true;
				 }
			 }
				 actual.removeAll(Arrays.asList(null,""));
			    expected=acc.rowelements;
			    expected.removeAll(Arrays.asList(null,""));
			    if(expected.equals(actual))
				{
					System.out.println("Pass:actual and expected values are  matching");
					return true;
				}
				else
				{
					 err.logError("Tagged values are not matching ");
					return false;
				}
		 }
		 else
		 {
			 if(acc.rowelements.isEmpty())
			 {
				 System.out.println("None of the items tagged");
				 returnvar=true;
			 }
			 else
			 returnvar=false;
		 }
		 if(!returnvar)
				
		 {
			
			 err.logError("Benefit Level Accumulators Table doesnot contain any value ");
			return false;
		}
		return true;
	}
	public boolean validatetaggedcheckboxes()
	{
		ArrayList<String> actual = new ArrayList<String>();
		ArrayList<String> expected=new ArrayList<String>(); 
		List<WebElement> count=null;
		Boolean returnvar=true;
		String xapth1=null;	
		 try{
			 wait=new WebDriverWait(Driver.pgDriver,20);
			 xapth1="//*[@class='work_identifier']";
		
		 }
		 catch(Exception e)
		 {
			 System.out.println("Tagged element not found in Accumulator review screen");
			 returnvar=false;
		 }
		 count=Driver.pgDriver.findElements(By.xpath(xapth1));
		 if(!(count.isEmpty()))
		 {		 
		for(WebElement e:count)
		{
			String val=e.getText().toLowerCase().trim();
			actual.add(val);
		}
		    System.out.println("Actual Array:"+actual);
		    expected=acc.rowelements;
		    System.out.println("Expected from screen:"+acc.rowelements);
		    if(expected.equals(actual))
			{
				System.out.println("Pass:actual and expected values are  matching");
				return true;
			}
			else
			{
				System.out.println("Fail:actual and expected values are not matching");
				return false;
			}
		 }
		 else
		 {
			 if(acc.rowelements.isEmpty())
			 {
				 System.out.println("None of the items tagged from Accums screen");
				 returnvar=true;
			 }
			 else
			 {
				 System.out.println("None of the items tagged");
				
			 returnvar=false;
			 }
		 }
		 if(!returnvar)			
		 {
			
			 err.logError("Accumulators Table doesnot contain any value ");
			return false;
		}
		return true;
	}
	
	public boolean navigatetoViewAccumulators()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Accumulators Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherViewAccums, "Accumulators Review", "View Accumulators"))
				if(utils.validateHeader(this.getHeader(),"View Accumulators"))
					return true;

			return false;
	}
	
	
	public boolean navigatetoRequestManagerHelp()
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Manager/OE Help", "AccumulatorsReview", "Request Manager Help");
	}
	
	
	public boolean navigatetoRequestAccumulatorSync()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Accumulators Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherReqAccmsSync, "Accumulators Review", "Request Accumulator Sync"))
				if(utils.validateHeader(this.getHeader(),"Request Accumulator Sync"))
					return true;
			return false;
	}
	
	
	public boolean navigatetoRequestAccumulatorUpdatec()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Accumulators Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherReqAccumsUpdate, "Accumulators Review", "Request Accumulator Update"))
				if(utils.validateHeader(this.getHeader(),"Request Accumulator Update"))
					return true;
			return false;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_Discuss_Ded_Coins_Copay()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Discuss deductible/coinsurance/copay/cost shares"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_ExplainEOB()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Explain explanation of benefits (EOB)"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_ExplainClaimProcess()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Explain how claim processed"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_Explain_letter_payment()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Explain this letter or payment received"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_FileClaim()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("File a claim"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_Locate_Claim_payment()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Locate claim or payment"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_ProvideAddntlInfo()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Provide additional information"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_ReqAdjustment()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Request an adjustment"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_ReqCorrespond_Reprint()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Request correspondence or reprint"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}
	
	
	public boolean AccumulatorsReviewandSubmit_UpdateOtherIns()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Update other insurance"))
				if(this.setTxtNotes("Test"))	
					if(this.clickgetBtnSubmit())
						return true; 
		err.logError("The header does not match the specified text.");
		return false ;
	}

	    @FindBy(xpath="//span[contains(text(),'Request Accumulator Revie...')]")
		WebElement lnkOtherReqAccumsReview;
		
		/*
		 * @SCU
		 * #CommonMethodWithoutArgument: navigatetoRequestAccumulatorReview
		 * #Description: This functionality navigates to the Request Accumulator Review Section from the Accumulator Review page
		 * Type: Textbox
		 */
		public boolean navigatetoRequestAccumulatorReview()
		{
			return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Accumulator Revie...", "AccumulatorReview", "Request Accumulator Review");
		}

		@FindBy(xpath="//table[@pl_prop='.FamilyLevelAccumList']")
		private List<WebElement> AccumMemberLevelTable;
		
		
		/*	
		 * @SCU
		 * #CommonMethodWithArgument:validateAccumMemberLevelTagged
		 * #Description:This functionality validates the member level Accumulator tagged or reviewed.
		 * #Argument:AccumMemberLevelTagged
		 * Type:Table
		 * Keys:Network#Accumulator Description#Limit#Accumulated#Remaining
		 */
		public boolean validateAccumMemberLevelTagged(String args[]){
			try{
				utils.waitforpageload();
				WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.FamilyLevelAccumList']"));
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
				WebElement row =utils.returntablerowbasedonvalues(this.AccumMemberLevelTable.get(0),args);
				List<WebElement> chkbox = row.findElements(By.xpath("//td//img[@class='checkbox chkBxCtl']"));
				if(chkbox.get(0).isDisplayed()){
					System.out.println("Review Requested is checked");
				}
			}
			catch (Exception e){
				System.out.println("Entire row not matching for given input Accumulator -MemberLevel" + e);
				return false;
			}
		return true;
		}
		/*	
		 * @SCU
		 * #CommonMethodWithArgument:validateAccumFamilyLevelTagged
		 * #Description:This functionality validates the Family level Accumulator tagged or reviewed.
		 * #Argument:AccumFamilyLevelTagged
		 * Type:Table
		 * Keys:Network#Accumulator Description#Limit#Accumulated#Remaining
		 */
		public boolean validateAccumFamilyLevelTagged(String args[]) throws InterruptedException{
			try{
				utils.waitforpageload();
				WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.FamilyLevelAccumList']"));
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
				WebElement row =utils.returntablerowbasedonvalues(this.AccumMemberLevelTable.get(1),args);
				List<WebElement> chkbox = row.findElements(By.xpath("//td//img[@class='checkbox chkBxCtl']"));
				if(chkbox.get(0).isDisplayed()){
					System.out.println("Review Requested is checked");
				}
			}
			catch (Exception e){
				utils.waitforpageload();
				WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.FamilyLevelAccumList']"));
				((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
				WebElement row =utils.returntablerowbasedonvalues(this.AccumMemberLevelTable.get(3),args);
				List<WebElement> chkbox = row.findElements(By.xpath("//td//img[@class='checkbox chkBxCtl']"));
				if(chkbox.get(0).isDisplayed()){
					System.out.println("Review Requested is checked");
				}
			}
		return true;
		}
		
		@FindBy(xpath="//table[@pl_prop='.MiscellaneousAccumList']")
		WebElement tblMiscellanousAccumulator;
		
		@FindBy(xpath="//span[contains(text(),'Miscellaneous Accumulators')]")
		WebElement lnkMiscellanousAccumulators;
		
		public boolean verifyMiscellaneousAccumulatorsSectionIsDisplayed()
		{
			return !utils.isProxyWebelement(lnkMiscellanousAccumulators);
		}
		
		/*	
		 * @SCU
		 * #CommonMethodWithArgument:validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment
		 * #Description:This functionality validates the Miscellanous Accumulator tagged or reviewed.
		 * #Argument:MiscellanousAccumsLevelTagged
		 * Type:Table
		 * Keys:Network#Accumulator Description#Limit#Accumulated#Remaining
		 */
		public boolean validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment(String args[]){
			try{
			
				WebElement row =utils.returntablerowbasedonvalues(this.tblMiscellanousAccumulator,args);
				List<WebElement> chkbox = row.findElements(By.xpath("//td//img[@class='checkbox chkBxCtl']"));
				if(chkbox.get(0).isDisplayed()){
					System.out.println("Review Requested is checked");
				}
			}
			catch (Exception e){
				System.out.println("Entire row not matching for given input Accumulator -FamilyLevel" + e);
				return false;
			}
		return true;
		}
	
		@FindBy (xpath="//li[@title='Request Manager/OE Help']")	
		private WebElement lnkOthrActionsRequestManagerHelp;

		/**This functionality navigates to the Request Manager or OE help page by clicking Other actions button
		 * 
		 * @return
		 */
		public boolean navigatetoRequestManagerorOEHelp() {
			if(utils.clickAnelemnt(this.btnOtherActions, "Manage Claim Review", "Other Actions button"))
				return utils.clickAnelemnt(this.lnkOthrActionsRequestManagerHelp, "Manage Claim Review", "Request Adjustment");
			return false;
		}
		
		@FindBy(xpath="(//*[contains(text(),'Coverage Period : 08/15/2017 - 08/14/2018')]//following::table[@pl_prop='.FamilyLevelAccumList'])[1]")
		WebElement tableMemberLevelForCovPeriod2017To2018;
		
}
