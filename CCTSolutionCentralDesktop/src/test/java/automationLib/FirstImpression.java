package automationLib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class FirstImpression {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	
	 Random rand = new Random(); 

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	WebDriverWait wait;

	public FirstImpression() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	private HashMap<String, String> valuesFromTheRow;

	String MessageOnceGroupNameClicked;



	public HashMap<String, String> getValuesFromTheRow() {
		return valuesFromTheRow;
	}

	public void setValuesFromTheRow(HashMap<String, String> valuesFromTheRow) {
		this.valuesFromTheRow = valuesFromTheRow;
	}

	@FindBy(id="Nickname")
	WebElement txtBxEnterNickname;

	@FindBy(id="SSNLast4")
	WebElement txtBxEnterSSN;

	@FindBy(id="LastName")
	WebElement txtBxEnterLastname;

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Search')]")
	WebElement clickMemberSearchinFirstImpression;

	@FindBy(xpath="//div[starts-with(text(),'Interactions not found')]")
	WebElement getInteractionMessage;

	@FindBy(xpath="//table[@pl_prop='D_FIGroups.pxResults']")
	WebElement tblfirstImpressionGroupResultsHeaderRow;

	@FindBy(xpath="//tr[@id='$PD_FIGroups$ppxResults$l1']")
	WebElement firstSearchRowvalues;

	@FindBy(id="GroupName")
	WebElement txtBxEnterGroupName;

	@FindBy(xpath="//*[@data-test-id='20171020021531058963281']//*[contains(text(),'Search')]")
	WebElement clickGroupSearchinFirstImpression;

	@FindBy(xpath="//span[contains(text(),'VSP PLAN A ALSO INCLUDED')]")
	WebElement getContractInformationOnceGroupNameClicked;


	@FindBy(xpath="//span[contains(text(),'ACCMA')]")
	WebElement employerGroupNameValue;

	@FindBy(xpath="//span[contains(text(),'C21616')]")
	WebElement groupNumberValue;

	@FindBy(xpath="//span[contains(text(),'01/01/2000')]")
	WebElement effectiveDateValue;

	@FindBy(xpath="//span[contains(text(),'01/03/2000')]")
	WebElement receivedDateValue;

	@FindBy(xpath="//span[contains(text(),'66200000')]")
	WebElement mbuCodeValue;


	@FindBy(xpath="//span[contains(text(),'10/100 PPO 71A')]")
	WebElement medicalValue;


	@FindBy(xpath="//span[contains(text(),' ')]")
	WebElement dentalValue;

	@FindBy(xpath="//span[contains(text(),'15/10')]")
	WebElement rxValue;

	@FindBy(id="ContractCode")
	WebElement txtBxEnterContractCode;

	@FindBy(id="FirstName")
	WebElement txtBxEnterFirstName;

	@FindBy(id="PhoneNumber")
	WebElement txtBxEnterPhoneNumber;

	@FindBy(id="DateOfBirth")
	WebElement txtBxEnterDateOfBirth;

	@FindBy(id="AddressLine1")
	WebElement txtBxEnterAddress;

	@FindBy(id="pyCity")
	WebElement txtBxEnterCity;

	@FindBy(id="pyState")
	WebElement drpDownSelectState;

	@FindBy(id="ZipCode")
	WebElement txtBxEnterZipCode;

	@FindBy(id="PolicyState")
	WebElement drpDownselectPolicyState;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement clickBtnSubmit;

	@FindBy(xpath="//a[contains(text(),'2')]")
	WebElement lnkclickPageNoToNavigateToNextpage;

	@FindBy(name="DependentInformation_pyWorkPage.FirstImpression_25")
	WebElement lnkTxtAdd;

	@FindBy(id="MemberRelation1")
	WebElement drpDownDependentSelection;

	@FindBy(id="FirstName1")
	WebElement txtDependentFirstName;

	@FindBy(id="LastName1")
	WebElement txtDependentLastName;

	@FindBy(id="DateOfBirth1")
	WebElement txtDependentDOB;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterNickname
	 * #Description: This functionality enters the nick name in the first impression section
	 * Type: Textbox
	 */

	public boolean enterNickname()
	{
			return utils.enterTextinAnelemnt(txtBxEnterNickname, "nick", "First Impression", "Nick name entered");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterSSN
	 * #Description: This functionality enters the SSN number in the first impression section
	 * #Argument: SSNNum
	 * Type: Text
	 */
	public boolean enterSSN(String[] SSNNum)
	{
			return utils.enterTextinAnelemnt(txtBxEnterSSN, SSNNum[0], "FirstImpression", "SSN Num entered");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterLastname
	 * #Description: This functionality enters the Last name in the first impression section
	 * #Argument: Lastname
	 * Type: Text
	 */

	public boolean enterLastname(String[] Lastname)
	{
			return utils.enterTextinAnelemnt(txtBxEnterLastname, Lastname[0], "FirstImpression", "Last name entered");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickMemberSearchInFirstImpression
	 * #Description: This functionality clicks the member name search button in the first impression section
	 * Type: Textbox
	 */
	public boolean clickMemberSearchInFirstImpression()
	{	
			return utils.clickAnelemnt(clickMemberSearchinFirstImpression, "FirstImpression", "Member Search button Clicked");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArguments: enterMandatoryDetailsNickSSNLastAndSearch
	 * #Description: This functionality enters the mandatory details like Nick name, SSN, & Last name in the respective section
	 * #Arguments: nickname, SSN, lastname
	 * Type: Textbox
	 */
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	LocalDate localDate = LocalDate.now(); 
	String Tdate=dtf.format(localDate );

	public boolean enterMandatoryDetailsAndSearch(String[] mandatoryDetails)
	{
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";
		  int randint1 = rand.nextInt(10000); 
		  System.out.println("Rand Int: "+randint1);
		  String ssn = Integer.toString(randint1);
		  System.out.println("SSN: "+ssn);
		for(String iterator : mandatoryDetails)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("First Impression", "Check your "+keyvaluepair+" whether your input is wrong");
				return false;
			}
			keyvaluepair = iterator;				
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			System.out.println("key " + key + "value  " + value);

			if(key.toLowerCase().contains("nickname"))
			{
				returnvar = utils.enterTextinAnelemnt(txtBxEnterNickname, value, "First Immpression", "NickName");
				continue;
			}
			else if(key.toLowerCase().contains("last"))
			{
				returnvar = utils.enterTextinAnelemnt(txtBxEnterLastname, value, "First Immpression", "LastName");
				continue;
			}
			else if(key.toLowerCase().contains("ssn"))
			{
				returnvar = utils.enterTextinAnelemnt(txtBxEnterSSN, ssn, "First Immpression", "SSN");
				continue;
			}
			
		}
		if(this.clickMemberSearchInFirstImpression())
		{
			returnvar = true;
		}
		else
		{
			returnvar = false;
		}
		if(returnvar)
		{
			System.out.println("Mandatory Details Entered Successfully");
			return true;	
		}
		else
		{
			err.logcommonMethodError("First Impression", "Mandatory Details Entering is failed");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateInteractionMessage
	 * #Description: This functionality validates the interaction message displayed after search is clicked in the first impression section 
	 * Type: Textbox
	 */

	public boolean validateInteractionMessage()
	{
			String InteractionMessage = getInteractionMessage.getText();
			System.out.println("The Interaction message displayed is: " + InteractionMessage);
			return utils.isvalueMatch_contain(InteractionMessage, "Interactions not found. Select the First Impression group that the member wants to discuss");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: getRowNoInTableAndNavigateToNextpage
	 * #Description: This functionality get the total no.of rows in the table and if the row no is the maximum no then it navigates to the next page
	 * Type: Textbox
	 */

	public boolean getRowNoInTableAndNavigateToNextpage()
	{
		List<WebElement> allRows = tblfirstImpressionGroupResultsHeaderRow.findElements(By.tagName("tr"));
		int rowCount = allRows.size();
		System.out.println("No.of.Rows in the table are: " + rowCount);
		if(rowCount==26)
			return utils.clickAnelemnt(lnkclickPageNoToNavigateToNextpage, "First Impression", "No is clicked to navigate to the next page");
		return false;


	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: enterGroupNameAndClickSearch
	 * #Description: This functionality enters the group name in the text box field and performs click action on search button
	 * Type: Textbox
	 */

	public boolean enterGroupNameAndClickSearch(String[] groupname) throws InterruptedException
	{
		if(utils.enterTextinAnelemnt(this.txtBxEnterGroupName, groupname[0], "FirstImpresion", "Group Name entered"))
			return utils.clickAnelemnt(this.clickGroupSearchinFirstImpression, "FirstImpression", "Group Search button Clicked");
		return false;			

	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterGroupName
	 * #Description: This functionality enters the group name in the First Impression group section
	 * Type: Text
	 */

	public boolean enterGroupName(String groupname)
	{
			return utils.enterTextinAnelemnt(txtBxEnterGroupName, groupname, "FirstImpresion", "Group Name entered");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickGroupSearchInFirstImpression
	 * #Description: This functionality clicks the group name search button in the first impression section
	 * Type: Textbox
	 */
	public boolean clickGroupSearchInFirstImpression()
	{
			return utils.clickAnelemnt(clickGroupSearchinFirstImpression, "FirstImpression", "Group Search button Clicked");
	}


	public boolean clickTheEnteredGroupRowValue(String[] tablevalues) throws InterruptedException
	{
		utils.waitforpageload();	
		return utils.clickontablerowbasedonvalues(tblfirstImpressionGroupResultsHeaderRow, tablevalues);
	}


	public boolean getContractInformationOnceGroupNameClicked()
	{
			MessageOnceGroupNameClicked = getContractInformationOnceGroupNameClicked.getText();
			System.out.println("Message displayed once group name clicked is:" + MessageOnceGroupNameClicked);
			return true;
	}


	public String getMessageOnceGroupNameClicked() 
	{
		return MessageOnceGroupNameClicked;
	}

	public void setMessageOnceGroupNameClicked(String messageOnceGroupNameClicked) 
	{
		MessageOnceGroupNameClicked = messageOnceGroupNameClicked;
	}

	public boolean storevaluesFromSearchRows()
	{
		this.valuesFromTheRow = new HashMap<String,String>();
		this.valuesFromTheRow.put("Employer Group Name", this.employerGroupNameValue.getText());
		this.valuesFromTheRow.put("Group Number", this.groupNumberValue.getText());
		this.valuesFromTheRow.put("Effective Date", this.effectiveDateValue.getText());
		this.valuesFromTheRow.put("Received Date", this.receivedDateValue.getText());
		this.valuesFromTheRow.put("MBU Code", this.mbuCodeValue.getText());
		this.valuesFromTheRow.put("Medical", this.medicalValue.getText());
		this.valuesFromTheRow.put("Dental", this.dentalValue.getText());
		this.valuesFromTheRow.put("RX", this.rxValue.getText());
		System.out.println("The values in the HashMap are: " + valuesFromTheRow);
		return true;

	}


	/*
	 * @SCU
	 * #CommonMethodWithArguments: inputTextField
	 * #Description: This functionality enters the details in the input fields
	 * #Arguments: fieldName, value, pageName, message
	 * Type: Text
	 */

	public boolean inputTextField(WebElement fieldName, String value, String pageName, String message)
	{
		return utils.enterTextinAnelemnt(fieldName, value, pageName, message);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArguments: selectFromDropDown
	 * #Description: This functionality selects the details in the drop down section
	 * #Arguments: fieldName, value, pageName, message
	 * Type: Text
	 */
	public boolean selectFromDropDown(WebElement fieldName, String value, String pageName, String message)
	{
			return utils.selectDropDownbyVisibleString(fieldName, value, pageName, message);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArguments: enterMandatoryDetails
	 * #Description: This functionality enters the mandatory details in the respective section
	 * Type: Textbox
	 */

	public boolean enterMandatoryDetails()
	{
		if(!inputTextField(txtBxEnterFirstName, "Tester", "First Impression", "First Name Entered"))
			return false;
		if(!inputTextField(txtBxEnterPhoneNumber, "0123456789", "First Impression", "Phone Number Entered"))
			return false;
		if(!inputTextField(txtBxEnterDateOfBirth, "01/01/1989", "First Impression", "Date Of Birth Entered"))
			return false;
		if(!inputTextField(txtBxEnterAddress, "Florence Ave", "First Impression", "Address Entered"))
			return false;
		if(!inputTextField(txtBxEnterCity, "Los Angeles", "First Impression", "City Entered"))
			return false;
		if(!selectFromDropDown(drpDownSelectState, "CA", "First Impression", "State Selected"))
			return false;
		if(!inputTextField(txtBxEnterZipCode, "90001", "First Impression", "Zip Code Entered"))
			return false;
		if(!selectFromDropDown(drpDownselectPolicyState, "CA", "First Impression", "Policy State Selected"))
			return false;
		return clickBtnSubmit();

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickBtnSubmit
	 * #Description: This functionality performs the submit action on the first impression page
	 * Type: Textbox
	 */

	public boolean clickBtnSubmit(){
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.clickBtnSubmit, "FirstImpresion", "Submit");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterContractCode
	 * #Description: This functionality enters the contract code in the first impression details section
	 * #Argument: concode
	 * Type: Textbox
	 */
	public boolean enterContractCode(String[] concode)
	{
		return utils.enterTextinAnelemnt(txtBxEnterContractCode, concode[0], "First Impression", "Contract Code");	
	}


	public boolean getEnteredContractCode()
	{
		String ConCode = txtBxEnterContractCode.getAttribute("value");
		System.out.println("Entered Contract code value is: " + ConCode);
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAddDependent
	 * #Description: This functionality performs the click action on the Add Dependent button.
	 * Type: Textbox
	 */
	public boolean clickAddDependent()
	{
			utils.scrolltomiddle();
			return utils.clickAnelemnt(lnkTxtAdd, "First Impression", "Add");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectDependentDrpDown
	 * #Description: This functionality selects the value in the Dependent drop down section
	 * #Argument: dependentdrpdown
	 * Type: Dropdown
	 * keys: Spouse#Son#Daughter
	 */

	public boolean selectDependentDrpDown(String[] dependentdrpdown)
	{
			return utils.selectDropDownbyVisibleString(drpDownDependentSelection,dependentdrpdown[0] , "First Impression", "Dependent Drop Dowwn");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterDependentMandatoryDetails
	 * #Description: This functionality enters the mandatory details in the dependent selection
	 * #Argument: editMandatoryDetails
	 * Type: T
	 * keys: firstname#lastname#dateofbirth
	 */
	public boolean enterDependentMandatoryDetails(String[] editMandatoryDetails)
	{
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : editMandatoryDetails)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("FirstImpression_Composite", "Check your "+keyvaluepair+" whether your input is wrong");
				return false;
			}
			keyvaluepair = iterator;				
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);
			if(key.toLowerCase().contains("firstname"))
			{
				returnvar = this.inputTextField(txtDependentFirstName, value, "FirstImpression_Composite", "Dependent FirstName");
				continue;
			}
			else if(key.toLowerCase().contains("lastname"))
			{
				returnvar = this.inputTextField(txtDependentLastName, value, "FirstImpression_Composite", "Dependent LastName");
				continue;
			}
			else if(key.toLowerCase().contains("dateofbirth"))
			{
				returnvar = this.inputTextField(txtDependentDOB, value, "FirstImpression_Composite", "Dependent DOB");
				continue;
			}
		}
		if(returnvar)
		{
			System.out.println("Dependent Mandatory Details Entered Successfully");
			return true;	
		}
		else
		{
			err.logcommonMethodError("FirstImpression_Composite", "Mandatory Details Entering is failed");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterDependentFirstName
	 * #Description: This functionality enters the dependent first name in the dependent section
	 * #Argument: depfirstname
	 * Type: Textbox
	 */
	public boolean enterDependentFirstName(String[] depfirstname)
	{
			return utils.enterTextinAnelemnt(txtDependentFirstName, depfirstname[0], "First Impression", "Dependent First Name");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterDependentLastName
	 * #Description: This functionality enters the dependent last name in the dependent section
	 * #Argument: deplastname
	 * Type: Textbox
	 */
	public boolean enterDependentLastName(String[] deplastname)
	{
			return utils.enterTextinAnelemnt(txtDependentLastName, deplastname[0], "First Impression", "Dependent Last Name");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterDependentDOB
	 * #Description: This functionality enters the dependent DOB in the dependent section
	 * #Argument: depDOB
	 * Type: Textbox
	 */
	public boolean enterDependentDOB(String[] depDOB)
	{
			return utils.enterTextinAnelemnt(txtDependentDOB, depDOB[0], "First Impression", "Dependent DOB");
	}
}





