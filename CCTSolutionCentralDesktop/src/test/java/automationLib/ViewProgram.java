package automationLib;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ViewProgram {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="PegaGadget4Ifr")
	WebElement Iframeelement1;

	public ViewProgram(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}


	@FindBy(xpath="//a[contains(text(),'View Program Benefits Guide')]")
	WebElement lnkViewPrmBenefitsLink;

	@FindBy(xpath="//a[contains(text(),'Access HMC')]")
	WebElement lnkViewAccessHMCLink;

	@FindBy(xpath="xpath of the Program Name")
	WebElement labelProgramName;

	@FindBy(xpath="xpath of the Program Number")
	WebElement labelProgramNumber;

	@FindBy(xpath="xpath of the Trasnfer Number")
	WebElement labelTransferNumber;

	@FindBy(xpath="xpath of the Hours Of Business")
	WebElement labelHoursOfBusiness;

	@FindBy(xpath="xpath of the Case Number")
	WebElement labelCaseNumber;

	@FindBy(xpath="xpath of the Case Owner")
	WebElement labelCaseOwner;

	@FindBy(xpath="xpath of the Case Status")
	WebElement labelCaseStatus;

	@FindBy(xpath="xpath of the Case Reason")
	WebElement labelCaseReason;

	@FindBy(xpath="xpath of the Contact Reason")
	WebElement labelLastContactReason;

	@FindBy(xpath="xpath of the Contact date")
	WebElement labelLastContactDate;

	@FindBy(xpath="xpath of the Contact Attempt status")
	WebElement labelLastContactAttemptStatus;

	@FindBy(xpath="Program Eligibility Member Checkbox")
	WebElement chkBxProgramEligibility;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Manage Referrals')]")	
	WebElement lnkOthrActionsManageReferral;

	@FindBy (xpath="//ul[contains(@id,'pyNavigation')]//span[contains(text(),'Cancel this work')]")	
	WebElement lnkOthrActionsCancelWork;

	@FindBy(xpath="//table[@pl_prop='D_EligibleProgramsList.pxResults']")
	WebElement tblViewEligibleProgram;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyViewProgramBenefitsGuideLinkIsDisplayed
	 * #Description: This functionality verifies that the View Program Benefits Link is not displayed or not in the View Program page.
	 * Type: Textbox
	 */
	public boolean verifyViewProgramBenefitsGuideLinkIsDisplayed()
	{
		return !utils.isProxyWebelement(lnkViewPrmBenefitsLink);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyViewAccessHMCLinkIsDisplayed
	 * #Description: This functionality verifies that the View Access HMC Link is not displayed or not in the View Program page.
	 * Type: Textbox
	 */
	public boolean verifyAccessHMCLinkIsDisplayed()
	{
		return !utils.isProxyWebelement(lnkViewPrmBenefitsLink);
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickPgmEligibilityMemberCheckbox
	 * #Description: This functionality performs click action on the Program Eligibility member cehck box.
	 * Type: Textbox
	 */
	public boolean clickPgmEligibilityMemberCheckbox()
	{
			return utils.clickAnelemnt(this.chkBxProgramEligibility, "ViewProgram", "Program Eligibility Checkbox");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on the Submit button in the View Program page
	 * #type: Textbox
	 */
	public boolean clickOnSubmit()
	{
			return utils.clickAnelemnt(this.btnSubmit, "ViewProgram", "Submit");
	}



	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: navigateToReferralFromOtherActions
	 * #Description: This functionality navigates to the Manage Referral section from the View Program page
	 * Type: Textbox
	 */
	public boolean navigateToReferralFromOtherActions()
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, "Manage Referral", "ViewProgram", "Navigated to Manage Referral");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCancelWorkAndCancelTheWork
	 * #Description: This functionality navigates to the cancel work section from the View Program page and cancels the work
	 * Type: Textbox
	 */
	public boolean clickCancelWorkAndCancelTheWork()
	{
		boolean flag=false;
			if(utils.clickAnelemnt(drpDownOtherActions, "ViewProgram", "Other Actions button"))
				if(utils.clickAnelemnt(this.lnkOthrActionsCancelWork, "ViewProgram", "Cancel Work"))
					if(clickOnSubmit())
						flag= true;
		return flag;
	}


	@FindBy(xpath="//a[contains(text(),'Next')]")
	WebElement lnkNext;

	public boolean verifyTheViewProgramInfoDisplayed(String[] tablevalues)
	{
		try{
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='D_EligibleProgramsList.pxResults']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement row =utils.getTablerowbasedonvalues(this.tblViewEligibleProgram,tablevalues);
			List<WebElement> chckBoxes = row.findElements(By.tagName("input"));
			chckBoxes.get(1).click();
			return true;
		}
		catch (Exception e){
			WebElement element = Driver.pgDriver.findElement(By.xpath("//a[contains(text(),'Next')]"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			if(lnkNext.isDisplayed())
			{
				lnkNext.click();
				return verifyTheViewProgramInfoDisplayed(tablevalues);
			}
			else
			{
				System.out.println("Entire row not matching for given input in Member Level" + e);
				return false;
			}
		}
	}



	@FindBy(xpath="//div[@id='DialogContent' and contains(text(), 'You can find Programs')]")
	WebElement txtGuidedDialog;

	@FindBy(xpath ="//div[@id='CT']/a[@disabled and @class='Add_task' and @title = 'View Programs']")
	WebElement addTasksViewPrograms;

	@FindBy (xpath="//*[@class='pzbtn-mid'][contains(text(),'Add Task')]")	
	private WebElement btnAddTAsk;

	public WebElement getbtnAddTAsk()
	{
		return btnAddTAsk;
	}

	public boolean clickbtnAddTask() throws InterruptedException
	{
		Thread.sleep(30000);
		return utils.clickAnelemnt(this.getbtnAddTAsk(), "Member Composite ", "Add Task Button ");

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateTheGuidedDialogIsPresent
	 * #Description: This functionality verifies the presence of guided dialog in View Programs.
	 * #Arguments:Member Name
	 * Type: Textbox
	 */

	public boolean validateTheGuidedDialogIsPresent(String[] args) {
		String actualguidedDialogText = "You can find Programs for " + args[0] + " here." + "\n"
				+"View Program Benefits Guide for more details" + "\n"
				+"Search Program name and program details.";
		String expectedguidedDialogText = txtGuidedDialog.getText().trim(); 
		return utils.isvalueMatch_contain(actualguidedDialogText, expectedguidedDialogText);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyTheViewProgramTaskIsDisabled
	 * #Description: This functionality verifies the View Program task is disabled for the second time.
	 * a
	 */

	public boolean verifyTheViewProgramTaskIsDisabled() throws InterruptedException {
		if(clickbtnAddTask())
			return !utils.isProxyWebelement(addTasksViewPrograms);
		return false;
	}

	//Sprint 3.3

	@FindBy(xpath="//div[@node_name='CPMCoachingTipDialogWrapper']//div[@id='DialogContent']")
	WebElement labelGuidedDialog;


	public boolean validateTheGuidedDialogInViewPrograms(String[] args)
	{
			String actualText = "You can find Programs for " + args[0] + " here. Health Management Corporation (HMC) search program name and program details.";
			String expectedText = labelGuidedDialog.getText().replaceAll("\n", " ");
			return utils.isvalueMatch_contain(actualText, expectedText);	
	}


	@FindBy(linkText="Access Chip Rewards")
	private WebElement linkAccessChipRewards;

	@FindBy(linkText="Access Hallmark")
	private WebElement linkAccessHallmark;

	@FindBy(xpath="//div[text()='Unable to determine Incentive Program']")
	private WebElement errorMessasgeIncentive;

	@FindBy(id="DialogContent")
	private WebElement DialogContent;


	public boolean verifyAnthemChipRewardsLink()
	{
		if (utils.clickAnelemnt(this.linkAccessChipRewards, "View program", "linkAccessChipRewards"))
		{
			new WebDriverWait(Driver.getPgDriver(),30).until(ExpectedConditions.numberOfWindowsToBe(2));
			return utils.switchToLastWindow();
		}
		return false;		
	}


	public boolean verifyAccessHallmarkLink()
	{
		if (utils.clickAnelemnt(this.linkAccessHallmark, "View program", "linkAccessChipRewards"))
		{
			new WebDriverWait(Driver.getPgDriver(),30).until(ExpectedConditions.numberOfWindowsToBe(2));
			return utils.switchToLastWindow();
		}
		return false;		
	}

	public boolean verifyIncentiveErrorMessage()
	{
		return !utils.isProxyWebelement(errorMessasgeIncentive);
	}

	public boolean VerifyDialogContentForNonAHGMembers(String[] arg)
	{
		String expected="You can find Health and Wellness Programs for "+arg[0]+" here. Access Health and Wellness Program details.";
		String actual = DialogContent.getText();
		return utils.isvalueMatch_contain(actual, expected);
	}

	
	@FindBy(xpath="//span[@data-test-id='20180712122950058728627']")
	private WebElement incentivevendorname;
	
	@FindBy(xpath="//span[@data-test-id='20180712122950058829246']")
	private WebElement incentiveflag;
	
	@FindBy(xpath="//span[@data-test-id='20180712122950058830391']")
	private WebElement hpcc;
	
	@FindBy(xpath="//span[@data-test-id='20180712122950058831214']")
	private WebElement rewarddeliverytype;
	
	

	public boolean verifyViewProgramsInfo(String[] details) throws Exception
	{
		boolean returnvar ;
		returnvar = true ;
		

			for(String iterator : details)
			{
				String keyvaluepair = iterator;
				if(!returnvar)
				{
					err.logcommonMethodError("View Programs", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
				if(utils.isvalueMatch_contain(key, "incentivevendorname")){
					returnvar =utils.validateValueinelement(this.incentivevendorname, value);
					continue;}
				else if(utils.isvalueMatch_contain(key, "incentiveflag")){
					returnvar =utils.validateValueinelement(this.incentiveflag, value);
					continue;}
				else if(utils.isvalueMatch_contain(key, "hpcc")){
					returnvar =utils.validateValueinelement(this.hpcc, value);
					continue;
				}
				else if(utils.isvalueMatch_contain(key, "rewarddeliverytype")){
					returnvar =utils.validateValueinelement(this.rewarddeliverytype, value);
					continue;		
				}
				else 
					err.logcommonMethodError("View Program", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;

			}

		if(returnvar)
		{
			System.out.println("view programs info checked Successfully");
			return true;	
		}
		else
		{
			int tot_i=details.length;
			err.logcommonMethodError("View Program", "the value "+details[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}


	}

	//@FindBy(xpath="//label[@data-test-id='20180717104554060595531']/parent::nobr/parent::td/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div/table")
	@FindBy(xpath="//table[@pl_prop='.pxResults']")
	private WebElement productsTable;
	
	
	//@FindBy(xpath="//label[@data-test-id='2018071710514306497397']/parent::nobr/parent::td/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div/table")
	@FindBy(xpath="(//table[@pl_prop='.pxResults'])[2]")
	private WebElement programsTable;
	
	//@FindBy(xpath="//label[@data-test-id='20180717105432044193303']/parent::nobr/parent::td/parent::tr/parent::tbody/parent::table/parent::div/following-sibling::div/table")
	@FindBy(xpath="(//table[@pl_prop='.pxResults'])[3]")
	private WebElement activitiesTable;
	
		
	public boolean clickAndValidateProductTable(String[] arg) throws InterruptedException
	{
		try
		{
		 WebElement row = utils.returntablerowbasedonvalues(productsTable, arg);
		 List<WebElement> chckBx = row.findElements(By.tagName("td"));
		 chckBx.get(0).click();
		 return true;
		}catch(Exception e)
		{
			blogger.loginfo("Error in Selecting Checkbox");
			return false;
		}
	}
	
	public boolean clickAndValidateProgramsTable(String[] arg) throws InterruptedException
	{
		try
		{
		 WebElement row = utils.returntablerowbasedonvalues(programsTable, arg);
		 List<WebElement> chckBx = row.findElements(By.tagName("td"));
		 chckBx.get(0).click();
		 return true;
		}catch(Exception e)
		{
			blogger.loginfo("Error in Selecting Checkbox");
			return false;
		}
	}
	
	public boolean clickAndValidatActivitiesTable(String[] arg) throws InterruptedException
	{
		try
		{
		 WebElement row = utils.returntablerowbasedonvalues(activitiesTable, arg);
		 List<WebElement> chckBx = row.findElements(By.tagName("td"));
		 chckBx.get(0).click();
		 return true;
		}catch(Exception e)
		{
			blogger.loginfo("Error in Selecting Checkbox");
			return false;
		}
	}
	
	
	public boolean SelectProductTableInfo(WebElement table,String[] tablevalues) throws InterruptedException
	{
		
		String[] keyvaleupair = tablevalues;

		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][]= new String[keyvaleupair.length][2];
		String[] keys =keyvaleupair;

		int index =0;
		int i=0;
		//Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		ArrayList<String>    returncolumn = new ArrayList<String>();
		int somevalue=1;

		for(String iterator: keyvaleupair){

			keys = iterator.split(":");       
			inputcolumnvaluemap[i][0]=keys[0];
			inputcolumnvaluemap[i][1]=keys[1];
			i=i+1;
			returncolumn = utils.getcolumnStringFromTableByName(table,keys[0]);
			String [] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k=0;
		for(int j=0;j<returncolumn.size();j++){
			if(k==keyvaleupair.length)
				break;
			String column= inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);

			if(columnvalues[j].equalsIgnoreCase(value)){
				index=j;
				while(k<keyvaleupair.length){
					column= inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);     
					if(columnvalues[j].equalsIgnoreCase(value)){
						k=k+1;
						continue;}
					else{
						index=-1;
						break;
					}
				}
			}

		}
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		if(index!=-1){
			if(allRows.size()>0)
				allRows.get(index).findElements(By.tagName("input")).get(1).click();}
		else return false;   
		System.out.println("The row with the matching arguements" + index);  
		Thread.sleep(1000);
		return true;  
	

	}
	
	
	public boolean selectProductTable(String[] args) throws InterruptedException
	{		 
		try
		{
		 WebElement row = utils.returntablerowbasedonvalues(productsTable, args);
		 List<WebElement> chckBx = row.findElements(By.tagName("input"));
		 chckBx.get(1).click();
		 return true;
		}catch(Exception e)
		{
			blogger.loginfo("Error in Selecting Checkbox");
			return false;
		}
	}
	
	
}
