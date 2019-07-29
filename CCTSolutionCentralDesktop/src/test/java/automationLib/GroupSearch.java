package automationLib;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class GroupSearch {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	public GroupSearch() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}


	private HashMap<String, String> valuesFromGroupSearchRow;

	public HashMap<String, String> getValuesFromGroupSearchRow() {
		return valuesFromGroupSearchRow;
	}

	public void setValuesFromGroupSearchRow(HashMap<String, String> valuesFromGroupSearchRow) {
		this.valuesFromGroupSearchRow = valuesFromGroupSearchRow;
	}


	@FindBy(id="GroupSearchByGroupName")
	WebElement rdoBtnEmployerGroupName;

	@FindBy(id="GroupSearchByGroupNumber")
	WebElement rdoBtnEmployerGroupNumber;


	@FindBy(id="EmployerGroupName")
	WebElement txtBxEmployerGroupName;

	@FindBy(id="EmployerGroupNumber")
	WebElement txtBxEmployerGroupNumber;

	@FindBy(id="GroupSearchFiltersActive")
	WebElement rdoBtnActive;

	@FindBy(id="GroupSearchFiltersShow All")
	WebElement rdoBtnShowAll;


	@FindBy(xpath="//button[@name='GroupSearch_pyWorkPage_18']//div[contains(text(),'Search')]")
	WebElement btnSearch;

	@FindBy(xpath="//button[@name='GroupSearch_pyWorkPage_19']//div[contains(text(),'Clear')]")
	WebElement btnClear;

	@FindBy(xpath= "xpath of the first listed value")
	WebElement lnkClickonLinkafterSettingValue;

	@FindBy(xpath="xpath for Employer Group Name value")
	WebElement labelGroupSearchEmployerGroupName;

	@FindBy(xpath="xpath for Employer Group Number")
	WebElement labelGroupSearchEmployerGroupNumber;

	@FindBy(xpath="xpath for Employer Group Staus")
	WebElement labelGroupSearchEmployerGroupStatus;

	@FindBy(xpath="xpath for Product Group Number")
	WebElement labelGroupSearchProductGroupNumber;

	@FindBy(xpath="xpath for Product Group Effective Date")
	WebElement labelGroupSearchProductGroupEffectiveDate;

	@FindBy(xpath="xpath for Product Type")
	WebElement labelGroupSearchProductType;

	@FindBy(xpath="xpath for Contract Code")
	WebElement labelGroupSearchContractCode;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy (xpath="//table[@pl_prop='GroupSearchList.pxResults']")	
	private WebElement tblGroupSearch;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[2]//div//span")
	WebElement employerGroupNameValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[4]//div//span")
	WebElement employerGoupNumberValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[5]//div//span")
	WebElement employerGroupStatusValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[6]//div//span")
	WebElement productGroupNameValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[8]//div//span")
	WebElement productGroupNumberValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[9]//div//span")
	WebElement productGroupEffectiveDateValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[10]//div//span")
	WebElement productTypeValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[11]//div//span")
	WebElement contractCodeValue;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickRdoBtnEmployerGroupName
	 * #Description: This functionality performs click action on the Employer Group Name radio button.
	 * Type: Textbox
	 */

	public boolean clickRdoBtnEmployerGroupName()
	{
		return utils.clickAnelemnt(rdoBtnEmployerGroupName, "Group Search", "Employer Group Name Radio Button");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickRdoBtnEmployerGroupNumber
	 * #Description: This functionality performs click action on the Employer Group Number radio button.
	 * Type: Textbox
	 */
	public boolean clickRdoBtnEmployerGroupNumber()
	{
		return utils.clickAnelemnt(rdoBtnEmployerGroupNumber, "Group Search", "Employer Group Number Radio Button");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterEmployerGroupName
	 * #Description: This functionality enters the Employer Group Name in the respective section
	 * #Arguments: Employer Group Name
	 * Type: Textbox
	 */
	public boolean enterEmployerGroupName(String[] groupName)
	{
		return utils.enterTextinAnelemnt(txtBxEmployerGroupName, groupName[0], "Group Search", "Employer Group Name");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterEmployerGroupNumber
	 * #Description: This functionality enters the Employer Group Number in the respective section
	 * #Arguments: Employer Group Number
	 * Type: Textbox
	 */
	public boolean enterEmployerGroupNumber(String[] groupNumber)
	{
		return utils.enterTextinAnelemnt(txtBxEmployerGroupNumber, groupNumber[0], "Group Search", "Employer Group Number");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickRdoBtnActive
	 * #Description: This functionality performs click action on the Active radio button.
	 * Type: Textbox
	 */
	public boolean clickRdoBtnActive()
	{
		return utils.clickAnelemnt(rdoBtnActive, "Group Search", "Active");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickRdoBtnShowAll
	 * #Description: This functionality performs click action on the ShowwAll radio button.
	 * Type: Textbox
	 */
	public boolean clickRdoBtnShowAll()
	{
		return utils.clickAnelemnt(rdoBtnShowAll, "Group Search", "Show All");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSearchBtn
	 * #Description: This functionality performs click action on the Search button.
	 * Type: Textbox
	 */
	public boolean clickSearch()
	{
		return utils.clickAnelemnt(btnSearch, "Group Search", "Search");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickClearBtn
	 * #Description: This functionality performs click action on the Clear button.
	 * Type: Textbox
	 */
	public boolean clickClear()
	{
		return utils.clickAnelemnt(btnClear, "Group Search", "Clear");
	}

	public boolean clicklnkClickonLinkafterSettingValue() throws InterruptedException
	{	
		Thread.sleep(2000);
		return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValue, "Member Composite", "Text Box Add Task Options");	
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickGroupNameRdoBtnAndEnterGroupName
	 * #Description: This functionality performs clicking action on the Employer Group Name radio button and enter the group name in the group name section and clicks the first displayed value.
	 * Argument: Emp Group Name
	 * Type: Textbox
	 */
	public boolean clickGroupNameRdoBtnAndEnterGroupName(String[] groupName) throws InterruptedException
	{
		if(clickRdoBtnEmployerGroupName())
			if(enterEmployerGroupName(groupName))
				if(this.clicklnkClickonLinkafterSettingValue())
					return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickGroupNumberRdoBtnAndEnterGroupNumber
	 * #Description: This functionality performs clicking action on the Employer Group Number radio button and enter the group number in the group name section and clicks the first displayed value.
	 * Argument: Emp Group Number
	 * Type: Textbox
	 */
	public boolean clickGroupNumberRdoBtnAndEnterGroupNumber(String[] groupNumber) throws InterruptedException
	{
		if(clickRdoBtnEmployerGroupNumber())
			if(enterEmployerGroupNumber(groupNumber))
				if(this.clicklnkClickonLinkafterSettingValue())
					return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSubmit
	 * #Description: This functionality performs the clicking action on the submit button
	 * Type: Textbox
	 */
	public boolean clickSubmit()
	{
		return utils.clickAnelemnt(btnSubmit, "Group Search", "Submit");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectGroupSearchRowBasedOnValues
	 * #Description: This functionality validates the row values in the group search row and selects the row based on the values
	 * #Argument: Value
	 * Type: Table
	 * keys: #Employer Group Name#Employer Group Number#Employer Group Status#Product Group Number#Product Group Effective Date#Product Type#Contract Code
	 */

	public boolean selectGroupSearchRowBasedOnValues(String[] value) throws InterruptedException
	{
		WebElement grpsearchtable = Driver.pgDriver.findElement(By.xpath ("//table[@pl_prop='GroupSearchList.pxResults']"));
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", grpsearchtable);
		return utils.clickontablerowbasedonvalues(this.tblGroupSearch, value);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: storeValuesFromGroupSearchRows
	 * #Description: This functionality stores the values from the Group Search list table based on the group name/number given by the user.
	 * Type: Textbox
	 */
	public boolean storeValuesFromGroupSearchRows()
	{
		this.valuesFromGroupSearchRow = new HashMap<String,String>();
		this.valuesFromGroupSearchRow.put("Employer Group Name", this.employerGroupNameValue.getText());
		this.valuesFromGroupSearchRow.put("Employer Group Number", this.employerGoupNumberValue.getText());
		this.valuesFromGroupSearchRow.put("Employer Group Status", this.employerGroupStatusValue.getText());
		this.valuesFromGroupSearchRow.put("Product Group Name", this.productGroupNameValue.getText());
		this.valuesFromGroupSearchRow.put("Product Group Number", this.productGroupNumberValue.getText());
		this.valuesFromGroupSearchRow.put("Product Group Effective Date", this.productGroupEffectiveDateValue.getText());
		this.valuesFromGroupSearchRow.put("Product Type", this.productTypeValue.getText());
		this.valuesFromGroupSearchRow.put("Contract Code", this.contractCodeValue.getText());
		System.out.println("The values in the HashMap are: " + valuesFromGroupSearchRow);
		return true;

	}


}
