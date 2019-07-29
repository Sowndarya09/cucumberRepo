package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefinition.stepdefinition;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrowseBenefits extends Driver{

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderBrowseBenefits;

	@FindBy(id="ContractCode")
	private WebElement contractCode_TxtBox;

	@FindBy(id="pyState")
	private WebElement state_Drpdown;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement BtnSubmit;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Retrieve Benefits']")
	private WebElement BtnRetrieveBenefits;

	@FindBy(xpath="//table[@pl_prop='.PlanBenefitsListForChoice']")
	private WebElement tblchoicelevelBenefits;
	@FindBy(xpath="//*[@data-test-id='20141007100658002943834']")
	private WebElement lblnextchoicelevelbenefits;


	public BrowseBenefits(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	public boolean RetrieveBenefits(String args[]){
		wait=new WebDriverWait(Driver.pgDriver,25);
		wait.until(ExpectedConditions.visibilityOf(this.BtnRetrieveBenefits));
		try{
			if(utils.validateHeader(sHeaderBrowseBenefits, "Browse Benefits")){
				System.out.println("Browse Benefits page is displayed");
				utils.enterTextinAnelemnt(this.contractCode_TxtBox, args[0], "BrowseBenefits", "Contract Code");
				if(!args[1].equals("null"))
					utils.selectDropDownbyVisibleString(this.state_Drpdown, args[1], "BrowseBenefits", "State");
				utils.clickAnelemnt(this.BtnRetrieveBenefits, "BrowseBenefits", "Retrieve Benefits");
				return true;
			}else 
				return false;
		}catch(Exception e){
			System.out.println("Browse Benefits page: Issue with element in RetrieveBenefits method"+e);
			return false;
		}
	}

	@FindBy(xpath="//a[@id='TABANCHOR']//label[contains(text(),'Browse')]")
	WebElement tabBrowseBenefitsBrowse;

	@FindBy(xpath="//div[@node_name='BrowseBenefitsIndexMode']//label[contains(text(),'Medical')]")
	WebElement tabBrowseBenefitsMedical;


	public boolean clickonMedicalAlphabet(String alphabet[]) throws InterruptedException{
		Thread.sleep(5000);
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.tabBrowseBenefitsBrowse, "BrowseBenefits", "Browse Tab"))
		{
			if(utils.clickAnelemnt(this.tabBrowseBenefitsMedical, "BrowseBenefits", "Medical Tab"))
			{
				utils.clickAnelemnt(this.tabBrowseBenefitsMedical, "BrowseBenefits", "Medical Tab");
				String indexalpha=alphabet[0].toString().toUpperCase();
				try
				{
					System.out.println("//div[@node_name='BrowseBenefitsAllorAlpha']//a[contains(@data-click,'Mode="+indexalpha+"')][text()='"+indexalpha+"']");
					String exxpath="//div[@node_name='BrowseBenefitsAllorAlpha']//a[contains(@data-click,'Mode="+indexalpha+"')][text()='"+indexalpha+"']";
					wait=new WebDriverWait(Driver.pgDriver,60);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(exxpath)));
					Driver.pgDriver.findElement(By.xpath(exxpath)).click();
					return true;
				}
				catch(Exception e)
				{
					System.out.println("cannot find the alphabet "+e);
					return false;
				}
			}
			else
			{
				err.logError("BrowseBenefits", "Medical TAB ");
				return false;
			}
		}
		else
		{
			err.logError("BrowseBenefits", "Browse TAB ");
			return false;
		}
	}

	public boolean clickBenefitBasedontext(String[] benefitname)
	{
		utils.waitforpageload();
		try
		{
			String benefit=benefitname[0];
			try {
				Driver.pgDriver.findElement(By.xpath("//*[contains(text(),'"+benefit+"')]/ancestor::td/preceding-sibling::td[contains(@class,'expandPane')]")).click();
				return true;
			} catch (NoSuchElementException e) {
				stepdefinition.isServicedown=true;
				e.printStackTrace();
				return false;
			}
		}

		catch(Exception e)
		{
			System.out.println("Not able to click due to "+e);
			return false;
		}
	}


	@FindBy(xpath="//*[@node_name='ShowBenfitDetailsData']//table[contains(@pl_prop,'BenefitLevelDetails')]")
	WebElement tableBrowseBenefitSelectionExpandedBenefit;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:checkvalueinExpandedBenefitLevelCoverage
	 * #Arguments:Row Values in Comma Separated Format
	 * Type:Textbox
	 */
	public boolean checkvalueinExpandedBenefitLevelCoverage(String[] tablevalues) throws InterruptedException
	{
		Thread.sleep(1000);
		action.moveToElement(tableBrowseBenefitSelectionExpandedBenefit);
		if(utils.validateBenefitRowValues(this.tableBrowseBenefitSelectionExpandedBenefit,tablevalues))
			return true;
		else
			return false;
	}

	ArrayList<String> valuesInRowBasedOnAlphabet = new ArrayList<String>();

	public ArrayList<String>  storeRowValuesBasedOnTextInAlphabet()
	{

		utils.scrolltomiddle();
		WebElement table = Driver.pgDriver.findElement(By.xpath("//div[@id='pyFlowActionHTML']//table[@pl_prop='.IndexList']//table[@pl_prop='.IndexList']"));
		List<WebElement> allrows = table.findElements(By.tagName("tr"));
		System.out.println("Row Count is: "+ allrows.size());
		int rowcount = allrows.size();
		for(int i=1;i<=rowcount;i++)
		{
			String rowvalues = Driver.pgDriver.findElement(By.xpath("//div[@id='pyFlowActionHTML']//table[@pl_prop='.IndexList']//table[@pl_prop='.IndexList']//tr["+i+"]")).getText();
			valuesInRowBasedOnAlphabet.add(rowvalues.replaceAll("\n", "").trim());
		}
		System.out.println("Values in the array in Store Method: "+valuesInRowBasedOnAlphabet);
		return valuesInRowBasedOnAlphabet;
	}


	public boolean verifyBenefitValues(String[] input)
	{
		String userInput = input[0];
		String[] inputValues = userInput.split(",");
		System.out.println("Values in the input are: "+ userInput);
		ArrayList<String> valuesInApplication = storeRowValuesBasedOnTextInAlphabet();
		System.out.println("Values in the array in the Benefit Method: "+valuesInApplication);
		for(String item : inputValues )
		{
			System.out.println("Value in Item is: "+item);
			if(!valuesInApplication.contains(item))
				return false;
		}

		return true;
	}

	public boolean clickBenefitBasedontextWithSameText(String[] benefitname)
	{
		utils.waitforpageload();
		try
		{
			String benefit=benefitname[0];
			Driver.pgDriver.findElement(By.xpath("//*[(text()='"+benefit+"')]/ancestor::td/preceding-sibling::td[contains(@class,'expandPane')]//following::tr//*[(text()='"+benefit+"')]/ancestor::td/preceding-sibling::td[contains(@class,'expandPane')]")).click();
			return true;
		}

		catch(Exception e)
		{
			System.out.println("Not able to click due to "+e);
			return false;
		}
	}  

	@FindBy(xpath="//label[contains(text(),'Medicare Supplement')]")
	WebElement tabMedicareSupplement;

	@FindBy(xpath="//label[contains(text(),'Medicare Advantage')]")
	WebElement tabMedicareAdvantage;

	@FindBy(xpath="//div[@node_name='BrowseBenefitsIndexMode']/table/tbody/tr/td/following-sibling::td/nobr/p")
	WebElement txtBenefitMessage;

	@FindBy(xpath="//a[@id='TABANCHOR']//label[contains(text(),'Browse')]")
	WebElement tabBenefitsSelectionBrowse;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickMedicareSupplement
	 * #Description: This functionality performs click action on the Medicare Supplement header.
	 * Type: Textbox
	 */
	public boolean clickMedicareSupplement()
	{
		return utils.clickAnelemnt(this.tabMedicareSupplement, "BrowseBenefits", "Medicare Supplement");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickMedicareAdvantage
	 * #Description: This functionality performs click action on the Medicare Advantage header.
	 * Type: Textbox
	 */
	public boolean clickMedicareAdvantage()
	{
		return utils.clickAnelemnt(this.tabMedicareAdvantage, "BrowseBenefits", "Medicare Advantage");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnAlphabetInMedicareSupplement
	 * #Description: This functionality performs click action on the Alphabet given by the user in the Medicare Supplement header.
	 * #Argument: alphabet
	 * Type: Textbox
	 */
	public boolean clickOnAlphabetInMedicareSupplement(String[] alphabet)
	{
		if(utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "BenefitSelection", "Browse Tab"))
		{
			if(utils.clickAnelemnt(this.tabMedicareSupplement, "BenefitSelection", "Medicare Supplement"))
			{
				utils.clickAnelemnt(this.tabMedicareSupplement, "BenefitSelection", "Medicare Supplement");
				String indexalpha=alphabet[0].toString().toUpperCase();
				try
				{
					System.out.println("//div[@node_name='BrowseBenefitsAllorAlpha']//a[contains(@name,'BrowseBenefitsAllorAlpha_pyWorkPage')][text()='"+indexalpha+"']");
					Driver.pgDriver.findElement(By.xpath("//div[@node_name='BrowseBenefitsAllorAlpha']//a[contains(@name,'BrowseBenefitsAllorAlpha_pyWorkPage')][text()='"+indexalpha+"']")).click();
					return true;
				}
				catch(Exception e)
				{
					System.out.println("cannot find the alphabet "+e);
					return false;
				}
			}
			else
			{
				err.logError("Benefit Selection", "Medical TAB ");
				return false;
			}
		}
		else
		{
			err.logError("Benefit Selection", "Browse TAB ");
			return false;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnAlphabetInMedicareAdvantage
	 * #Description: This functionality performs click action on the Alphabet given by the user in the Medicare Advantage header.
	 * #Argument: alphabet
	 * Type: Textbox
	 */
	public boolean clickOnAlphabetInMedicareAdvantage(String[] alphabet)
	{
		if(utils.clickAnelemnt(this.tabBenefitsSelectionBrowse, "BenefitSelection", "Browse Tab"))
		{
			if(utils.clickAnelemnt(this.tabMedicareAdvantage, "BenefitSelection", "Medicare Advantage"))
			{
				utils.clickAnelemnt(this.tabMedicareAdvantage, "BenefitSelection", "Medicare Advantage");
				String indexalpha=alphabet[0].toString().toUpperCase();
				try
				{
					System.out.println("//div[@node_name='BrowseBenefitsAllorAlpha']//a[contains(@name,'BrowseBenefitsAllorAlpha_pyWorkPage')][text()='"+indexalpha+"']");
					Driver.pgDriver.findElement(By.xpath("//div[@node_name='BrowseBenefitsAllorAlpha']//a[contains(@name,'BrowseBenefitsAllorAlpha_pyWorkPage')][text()='"+indexalpha+"']")).click();
					return true;
				}
				catch(Exception e)
				{
					System.out.println("cannot find the alphabet "+e);
					return false;
				}
			}
			else
			{
				err.logError("Benefit Selection", "Medical TAB ");
				return false;
			}
		}
		else
		{
			err.logError("Benefit Selection", "Browse TAB ");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateBenefitMessageDisplayed
	 * #Description: This functionality validates the benefit message displayed in the Browse Section.
	 * #Argument: message
	 * Type: Textbox
	 */
	public boolean validateBenefitMessageDisplayed(String[] message)
	{
		String benefitMessageUser = message[0];
		System.out.println("Message Given by User: "+benefitMessageUser);
		String benefitMessageFromUI = this.txtBenefitMessage.getText().replaceAll(",", "").replaceAll("  ", " ");
		System.out.println("Message from the Application: "+benefitMessageFromUI);
		if(benefitMessageUser.equalsIgnoreCase(benefitMessageFromUI))
		{
			System.out.println("Message Given by the User and the Message displayed in the application matched");
			return true;
		}
		else
		{
			System.out.println("Message Given by the User and the Message displayed in the application doesnt match");
			return false;
		}
	}

	public boolean check_row_under_Choice_Benefits(String[] args) throws InterruptedException{
		boolean returnvar=false;
		ArrayList<String> choiceBenefits= null;
		int i=0;
		boolean isNextDisplayed = this.lblnextchoicelevelbenefits.isDisplayed();
		while(isNextDisplayed){
			choiceBenefits=utils.getColumnsBasedonIndex(tblchoicelevelBenefits, 0);
			if(choiceBenefits.contains(args[0])){
				i=choiceBenefits.indexOf(args[0]);
				returnvar =true;
				break;}
			else {
				utils.clickAnelemnt(lblnextchoicelevelbenefits, "page", "element");
				utils.waitforpageload();
				isNextDisplayed = this.lblnextchoicelevelbenefits.isDisplayed();
			}

		}

		String s = utils.getColumnsBasedonIndex(tblchoicelevelBenefits, 5).get(i);
		String s1 = utils.getColumnsBasedonIndex(tblchoicelevelBenefits, 8).get(i);
		if(utils.getColumnsBasedonIndex(tblchoicelevelBenefits, 5).get(i).equals(args[1]))
			if (utils.getColumnsBasedonIndex(tblchoicelevelBenefits, 8).get(i).equals(args[2]))
				return true;
		return false;
	}

	@FindBy(xpath="//table[@pl_prop='.PlanBenefitsList']")
	WebElement tblPlanLevelBenefitsuptoChoice;

	@FindBy(xpath="//table[@pl_prop='.PlanBenefitsList']//div[contains(text(),'CoInsurance')]//..//..//..//td")
	List<WebElement> cellsIncoisurancerow;

	public boolean validateMedicalCoinsurance(String[] args){

		utils.waitforpageload();
		utils.scrolltomiddle();

		ArrayList<String> firstColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 0);
		ArrayList<String> InnetworkColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 3);
		ArrayList<String> outNetworkColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 6);
		int i=firstColumnValues.indexOf(args[0]);

		if(i!=-1)					
			if(utils.isvalueMatch_contain(InnetworkColumnValues.get(i),args[1]))	

				if(utils.isvalueMatch_contain(outNetworkColumnValues.get(i), args[2]))		

					return true;						
		err.logerrormessage("Coinsurance is not displayed");
		return false;
	}

	/*
	 * This method  can be used to check any plan level benefits information ,
	 * send the benefit section needs to be checked and the in network and outnetwork values 
	 * as comma seperated values
	 */

	public boolean Browse_validateMedicalPlanLevelCoverage(String[] args){

		utils.waitforpageload();

		ArrayList<String> firstColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 0);
		ArrayList<String> InnetworkColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 3);
		ArrayList<String> outNetworkColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 6);
		int i=firstColumnValues.indexOf(args[0]);

		if(i!=-1)					
			if(utils.isvalueMatch_contain(InnetworkColumnValues.get(i),args[1]))	

				if(utils.isvalueMatch_contain(outNetworkColumnValues.get(i), args[2]))		

					return true;						
		err.logerrormessage("Coinsurance is not displayed");
		return false;
	}

	public boolean validateBenefitMaximum(String[] args) {

		utils.waitforpageload();
		utils.scrolltomiddle();

		ArrayList<String> firstColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 0);
		ArrayList<String> InnetworkColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 3);
		ArrayList<String> outNetworkColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 6);
		int i=firstColumnValues.indexOf(args[0]);

		if(i!=-1)					
			if(utils.isvalueMatch_contain(InnetworkColumnValues.get(i),args[1]))	
				if(utils.isvalueMatch_contain(outNetworkColumnValues.get(i), args[2]))		
					return true;
		err.logerrormessage("BenefitMaximum is not displayed");
		return false;
	}

	public boolean checkFirstColumnValueinExpandedBenefitLevelCoverage(String[] tablevalues)
	{
		WebElement srchResults = tableBrowseBenefitSelectionExpandedBenefit;
		List<WebElement> allRows = srchResults.findElements(By.tagName("tr"));
		Boolean varstate=false;
		for (WebElement row : allRows) {
			List<WebElement> allColsByRow=null;
			try
			{
				allColsByRow =row.findElements(By.tagName("td"));
				System.out.println(allColsByRow.size());
				for(int i=0;i<allColsByRow.size();i++)
				{
					if(allColsByRow.get(1).getText().trim().equalsIgnoreCase(tablevalues[0].trim())) {
						System.out.println(allColsByRow.get(1).getText() +"Matched"+tablevalues[0].trim());
						blogger.loginfo(allColsByRow.get(1).getText() +"Matched"+tablevalues[0].trim());
						varstate=true;
					}
					else
						break;
				}
			}catch(Exception e)	{
				continue;
			}

		}
		if(!varstate)
		{
			err.logError("Benefit Selection", "Values dont match with the expected ones");
			return false;

		}
		else
			return true;
	}

	@FindBy(id="DateOfService")
	WebElement txtboxDateOfService;

	public boolean enterDateOfService(String[] arg) {
		return utils.enterTextinAnelemnt(this.txtboxDateOfService, arg[0], "BrowseBenefits", "txtbox DateOfService");
	}

	public boolean clickBenefitBasedontextSubText(String[] benefitname)
	{
		utils.waitforpageload();
		try
		{
			String benefit=benefitname[0];
			Driver.pgDriver.findElement(By.xpath("//*[@id='modaldialog_con']//*[contains(text(),'"+benefit+"')]/ancestor::td/preceding-sibling::td[contains(@class,'expandPane')]")).click();
			return true;
		}

		catch(Exception e)
		{
			System.out.println("Not able to click due to "+e);
			return false;
		}
	}

	public boolean validateBenefitsNotDisplayedinPlanLevel(String[] args) {
		boolean benefits =true;

		ArrayList<String> firstColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 0);
		int deductiblevalue=firstColumnValues.indexOf("Deductible");
		int opmvalue=firstColumnValues.indexOf("Out of Pocket Maximum");
		int coninsvalue=firstColumnValues.indexOf("CoInsurance");
		int benefitmaxvalue=firstColumnValues.indexOf("Benefit Maximum");

		for(String benefit: args) {

			String key = benefit.substring(0, benefit.indexOf(":"));
			String value = benefit.substring(benefit.indexOf(":")+1);

			if(key.startsWith("Deductible")) {
				for(int i=deductiblevalue;i<opmvalue;i++) {
					String firstcolumn = "//table[@pl_prop='.PlanBenefitsList']//tr["+i+"]//td";
					if(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText().equalsIgnoreCase(value)){
						benefits = false;
						break;
					}
				}
			}else if(key.startsWith("Out of Pocket Maximum")) {
				for(int i=opmvalue;i<coninsvalue;i++) {
					String firstcolumn = "//table[@pl_prop='.PlanBenefitsList']//tr["+i+"]//td";
					if(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText().equalsIgnoreCase(value)){
						benefits = false;
						break;
					}
				}
			}

			else if(key.startsWith("CoInsurance")) {
				for(int i=coninsvalue;i<benefitmaxvalue;i++) {
					String firstcolumn = "//table[@pl_prop='.PlanBenefitsList']//tr["+i+"]//td";
					if(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText().equalsIgnoreCase(value)){
						benefits = false;
						break;
					}
				}
			}

			else if(key.startsWith("Benefit Maximum")) {
				for(int i=benefitmaxvalue;i<firstColumnValues.size();i++) {
					String firstcolumn = "//table[@pl_prop='.PlanBenefitsList']//tr["+i+"]";
					if(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText().equalsIgnoreCase(value)){
						benefits = false;
						break;
					}
				}
			}
			else {
				blogger.loginfo("Check input value");
				benefits = false;
			}

		}
		if(!benefits) {
			blogger.loginfo("FAIL: Benefit is present");
			return false;
		}else {
			blogger.loginfo("PASS: Benefit is not present");
			return true;
		}
	}

	public boolean validateBenefitsrowsDisplayedinPlanLevel(String[] args) {
		boolean benefits =true;
		utils.waitforpageload();
		ArrayList<String> firstColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 0);
		ArrayList<String> InnetworkColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 3);
		ArrayList<String> outNetworkColumnValues = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 8);
		int deductiblevalue=firstColumnValues.indexOf("Deductible");
		int opmvalue=firstColumnValues.indexOf("Out of Pocket Maximum");
		int coninsvalue=firstColumnValues.indexOf("CoInsurance");
		ArrayList<String> outNetworkColumnValues1 = utils.getColumnsBasedonIndex(tblPlanLevelBenefitsuptoChoice, 8);
		int benefitmaxvalue=firstColumnValues.indexOf("Benefit Maximum");

		for(String benefit: args) {
			if(!benefits) {
				blogger.loginfo("FAIL: Input value not matching with application");
				return false;
			}
			benefits = false;
			String key = benefit.substring(0, benefit.indexOf(":"));
			String value = benefit.substring(benefit.indexOf(":")+1);
			String[] values = value.split("/");

			if(key.startsWith("Deductible")) {
				for(int i=deductiblevalue;i<=opmvalue;i++) {
					String firstcolumn = "//table[@pl_prop='.PlanBenefitsList']//tr["+i+"]//td";
					System.out.println(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText());
					if(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText().equalsIgnoreCase(values[0])) {
						if(InnetworkColumnValues.get(i-1).trim().equalsIgnoreCase(values[1])) 
							if(outNetworkColumnValues.get(i-3).trim().equalsIgnoreCase(values[2])) {
								blogger.loginfo("Passed Deductible Validation");
								benefits = true;
								continue;
							}
					}
				}
			}else if(key.startsWith("Out of Pocket Maximum")) {
				for(int i=opmvalue;i<=coninsvalue;i++) {
					String firstcolumn = "//table[@pl_prop='.PlanBenefitsList']//tr["+i+"]//td";
					System.out.println(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText());
					if(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText().equalsIgnoreCase(values[0])){
						if(utils.isvalueMatch_contain(InnetworkColumnValues.get(i-1),values[1]))	
							if(outNetworkColumnValues.get(i-3).equalsIgnoreCase(values[2])) {
								blogger.loginfo("Passed Out of Pocket Maximum Validation");
								benefits = true;
								continue;
							}
					}
				}
			}

			else if(key.startsWith("CoInsurance")) {
				for(int i=coninsvalue;i<=benefitmaxvalue;i++) {
					String firstcolumn = "//table[@pl_prop='.PlanBenefitsList']//tr["+i+"]//td";
					if(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText().equalsIgnoreCase(values[0])){
						if(InnetworkColumnValues.get(i-1).equalsIgnoreCase(values[1]))	
							if(outNetworkColumnValues.get(i-3).equalsIgnoreCase(values[2])) {
								blogger.loginfo("Passed CoInsurance Validation");
								benefits = true;
								continue;
							}
					}
				}
			}

			else if(key.startsWith("Benefit Maximum")) {
				for(int i=benefitmaxvalue;i<=firstColumnValues.size();i++) {
					String firstcolumn = "//table[@pl_prop='.PlanBenefitsList']//tr["+i+"]//td";
					System.out.println(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText());
					if(Driver.pgDriver.findElement(By.xpath(firstcolumn)).getText().equalsIgnoreCase(values[0])){
						if(InnetworkColumnValues.get(i-1).equalsIgnoreCase(values[1]))	
							if(outNetworkColumnValues.get(i-3).equalsIgnoreCase(values[2])) {
								blogger.loginfo("Passed Benefit Maximum Validation");
								benefits = true;
								continue;
							}
					}
				}
			}
			else {
				blogger.loginfo("Check input value");
				benefits = false;
			}

		}
		if(benefits) {
			blogger.loginfo("PASS: Benefit is present");
			return true;
		}else {
			blogger.loginfo("FAIL: Benefit is not present");
			return false;
		}
	}

	@FindBy(xpath="//*[@pl_prop='.PlanBenefitsListForHealthyRewards']")
	WebElement HealthyRewards;

	public boolean validateHealthyRewardsAndAnnualAllocationBenefits(String[] args) throws InterruptedException {
		Thread.sleep(2000);
		ArrayList<String> firstColumnValues = utils.getColumnsBasedonIndex(HealthyRewards, 0);
		ArrayList<String> InnetworkColumnValues = utils.getColumnsBasedonIndex(HealthyRewards, 3);
		ArrayList<String> outNetworkColumnValues = utils.getColumnsBasedonIndex(HealthyRewards, 6);
		int i=firstColumnValues.indexOf(args[0]);

		if(i!=-1)					
			if(utils.isvalueMatch_contain(InnetworkColumnValues.get(i),args[1]))	
				if(utils.isvalueMatch_contain(outNetworkColumnValues.get(i), args[2]))		
					return true;						
		err.logerrormessage("Healthy Rewards is not displayed");

		return false;
	}

	@FindBy(xpath="//*[text()='Benefit Level Coverage']")
	WebElement BenefitLevelCoverageLnk;

	public boolean expandBenefitLevelCoverage() {
		return utils.clickAnelemnt(BenefitLevelCoverageLnk, "BrowseBenefits", "BenefitLevelCoverageLnk");
	}

	@FindBy(xpath="//*[@data-test-id='20160727215506032216726']")
	List<WebElement> BenefitLevelHeader;

	public boolean verifyBenefitNotDuplicated() {
		Boolean flag = true;
		List<String> benefitheader = new ArrayList<String>();
		for(int i=0; i<BenefitLevelHeader.size();i++)
			benefitheader.add(BenefitLevelHeader.get(i).getText());


		for(int j=0; j<BenefitLevelHeader.size();j++) {
			int occurrences = 0;
			for(int i=0; i<BenefitLevelHeader.size();i++){
				System.out.println(BenefitLevelHeader.get(i).getText()+"\n");
				System.out.println(BenefitLevelHeader.get(j).getText()+"\n");
				if(BenefitLevelHeader.get(i).getText().equalsIgnoreCase(BenefitLevelHeader.get(j).getText())){
					occurrences++;
					if(occurrences == 2) {
						flag =  false;
					}
				}
			}
		}

		return flag;
	}

	@FindBy(xpath="//table[@pl_prop='.BenefitLevelDetails']")
	WebElement tblBenefitLevelDetails;

	public boolean validateInNetworkValues(String[] args) {

		utils.waitforpageload();
		utils.scrolltomiddle();

		ArrayList<String> firstColumnValues = utils.getColumnsBasedonIndex(tblBenefitLevelDetails, 1);
		ArrayList<String> InnetworkColumnValues = utils.getColumnsBasedonIndex(tblBenefitLevelDetails, 2);
		int i=firstColumnValues.indexOf(args[0]);

		if(i!=-1)		{
			System.out.println(InnetworkColumnValues.get(i).replaceAll("\n", "")+"\n");
			System.out.println(args[1]+"\n");
			if(utils.isvalueMatch_contain(InnetworkColumnValues.get(i).replaceAll("\n", ""),args[1]))		
				return true;
		}

		err.logerrormessage("BenefitMaximum is not displayed");
		return false;


	}

	@FindBy(xpath="//*[@id='_popOversContainer']//*[@data-test-id='2017071018434900935124']")
	WebElement NotesSectionPopUpText;

	@FindBy(xpath="//table[@pl_prop='.PlanBenefitsListForChoice']")
	WebElement ChoiceLevelBenefitTable;

	public boolean CLick_and_check_Choice_Benefits_Notes(String[] args) {
		Boolean flag = false;
		ArrayList<String> firstColumnValues = getColumnsBasedonIndexToVerifyNotesSection(ChoiceLevelBenefitTable, 1);
		int i=firstColumnValues.indexOf(args[0]);
		if(i!=-1)		{
			i = i+2;
			String element = "//table[@pl_prop='.PlanBenefitsListForChoice']//tr["+i+"]//table//tr//td[1]";
			System.out.println(element);
			action.moveToElement(Driver.pgDriver.findElement(By.xpath(element))).doubleClick().build().perform();
			String notesvalue = NotesSectionPopUpText.getText().replaceAll("\n", "").replaceAll(",", " ").replaceAll("\"", "");
			System.out.println(notesvalue+"\n");
			System.out.println(args[1]);
			if(notesvalue.equalsIgnoreCase(args[1])) 
				flag=true;
		}else {
			boolean isNextDisplayed = lblnextchoicelevelbenefits.isDisplayed();
			while(isNextDisplayed){
				ArrayList<String> choiceBenefits=utils.getColumnsBasedonIndex(ChoiceLevelBenefitTable, 1);
				if(choiceBenefits.contains(args[0])){
					i=choiceBenefits.indexOf(args[0]);
					flag = CLick_and_check_Choice_Benefits_Notes(args);
					break;
				}else {
					utils.clickAnelemnt(lblnextchoicelevelbenefits, "page", "element");
					utils.waitforpageload();
				}

			}
		}
		return flag;
	}

	public ArrayList<String> getColumnsBasedonIndexToVerifyNotesSection(WebElement tbl, int columnNo){

		WebElement srchResults = tbl;
		List<WebElement> allRows = srchResults.findElements(By.tagName("table"));
		int columnindex=columnNo;
		ArrayList<String> resultarray = new ArrayList<String>();
		if (allRows.size() > 0){		
			for (WebElement row : allRows) {
				try{
					List<WebElement> allColsByRow =row.findElements(By.tagName("td"));
					if(allColsByRow.size()>0)	
						resultarray.add(allColsByRow.get(columnindex).getText());
				}
				catch(Exception e){				}						
			}

		}
		return resultarray;
	}

	@FindBy(xpath="//span[@class='textMiddle']/label[text()='Browse']")
	WebElement BrowseTab;

	/**Click on the browse tab
	 * 
	 * @return
	 */
	public boolean clickBrowseTab() {
		utils.waitforpageload();
		return utils.clickAnelemnt(BrowseTab, "BrowseBenefits", "BrowseTab");
	}
}
