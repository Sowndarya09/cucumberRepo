package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class FirstImpression_Composite {


	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	WebDriverWait wait;
	public FirstImpression_Composite() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}


	@FindBy(xpath="//h3[contains(text(),'Group')]")
	WebElement groupHeader;

	@FindBy(xpath="//h3[contains(text(),'Contract')]")
	WebElement contractHeader;

	@FindBy(xpath="//h3[contains(text(),'Interactions')]")
	WebElement interactionsHeader;

	@FindBy(xpath="//div[contains(text(),'Edit')]")
	WebElement btnEdit;

	@FindBy(name="$PpyWorkPage$pFirstImpression$pFirstName")
	WebElement txtBoxFirstImpFirstName;

	@FindBy(name="$PpyWorkPage$pFirstImpression$pPhoneNumber")
	WebElement txtBoxFirstImpPhoneNo;

	@FindBy(name="$PpyWorkPage$pFirstImpression$pDateOfBirth")
	WebElement txtBoxFirstImpDOB;

	@FindBy(name="$PpyWorkPage$pFirstImpression$pAddressLine1")
	WebElement txtBoxFirstImpAddressLine1;

	@FindBy(name="$PpyWorkPage$pFirstImpression$ppyCity")
	WebElement txtBoxFirstImpCity;

	@FindBy(name="$PpyWorkPage$pFirstImpression$ppyState")
	WebElement drpDownFirstImpState;

	@FindBy(name="$PpyWorkPage$pFirstImpression$pZipCode")
	WebElement txtBoxFirstImpZipCode;

	@FindBy(name="$PpyWorkPage$pFirstImpression$pPolicyState")
	WebElement drpDownFirstImpPolicyState;

	@FindBy(name="$PpyWorkPage$pFirstImpression$pDependentInformation$l1$pMemberRelation")
	WebElement drpDownFirstImpDependentSelection;

	@FindBy(id="FirstName1")
	WebElement txtBoxFirstImpDependentFirstName;

	@FindBy(id="LastName1")
	WebElement txtBoxFirstImpDependentLastName;

	@FindBy(id="DateOfBirth1")
	WebElement txtBoxFirstImpDependentDOB;

	@FindBy(id="ModalButtonSubmit")
	WebElement btnFirstImpEditSave;

	@FindBy(id="ModalButtonCancel")
	WebElement btnFirstImpEditCancel;

	@FindBy (xpath="//button[@name='CPMInteractionDriver_D_Interaction_3']//div[contains(text(),'Add Task')]")	
	WebElement btnAddTAsk;

	@FindBy(xpath="//input[contains(@id,'CPMTaskSearchInput')]")
	WebElement SearchInput;

	@FindBy(xpath="//*[@id='$PTaskMenuSearchResults$ppxResults$l1']")
	WebElement lnkClickonLinkafterSettingValue;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickGroupHeader
	 * #Description: This functionality clicks the Group Header in the Member Composite Page
	 * Type: Textbox
	 */
	public boolean clickGroupHeader()
	{
		return utils.clickAnelemnt(this.groupHeader, "FirstImpression_MemberComposite", "Group Header Clicked");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickContractHeader
	 * #Description: This functionality clicks the Group Header in the Member Composite Page
	 * Type: Textbox
	 */
	public boolean clickContractHeader()
	{
		return utils.clickAnelemnt(this.contractHeader, "FirstImpression_MemberComposite", "Contract Header Clicked");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickInteractionsHeader
	 * #Description: This functionality clicks the Interactions Header in the Member Composite Page
	 * Type: Textbox
	 */
	public boolean clickInteractionsHeader()
	{
		return utils.clickAnelemnt(this.interactionsHeader, "FirstImpression_MemberComposite", "Interaction Header Clicked");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickEdit
	 * #Description: This functionality performs click action on the Edit button
	 * Type: Textbox
	 */
	public boolean clickEdit()
	{
		return utils.clickAnelemnt(btnEdit, "FirstImpression_Composite", "Edit Button");
	}

	public boolean inputTextField(WebElement fieldName, String value, String pageName, String message)
	{
		return utils.enterTextinAnelemnt(fieldName, value, pageName, message);
	}

	public boolean selectFromDropDown(WebElement fieldName, String value, String pageName, String message)
	{
		return utils.selectDropDownbyVisibleString(fieldName, value, pageName, message);
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterEditMandatoryDetails
	 * #Description: This functionality enters the values in the Mandatory details in the edit section
	 * #Argument: editMandatoryDetails
	 * Type: Textbox
	 * keys: firstname#phonenumber#dateofbirth#street#city#state#zipcode
	 */
	public boolean enterEditFirstImpMandatoryDetails(String[] editMandatoryDetails)
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
				returnvar = utils.enterTextinAnelemnt(txtBoxFirstImpFirstName, value, "First Immpression", "First Name");
				continue;
			}
			else if(key.toLowerCase().contains("phonenumber"))
			{
				returnvar = utils.enterTextinAnelemnt(txtBoxFirstImpPhoneNo, value, "First Immpression", "Phone No");
				continue;
			}
			else if(key.toLowerCase().contains("dateofbirth"))
			{
				returnvar = utils.enterTextinAnelemnt(txtBoxFirstImpDOB, value, "First Immpression", "Date of Birth");
				continue;
			}
			else if(key.toLowerCase().contains("street"))
			{
				returnvar = utils.enterTextinAnelemnt(txtBoxFirstImpAddressLine1, value, "First Immpression", "Street");
				continue;
			}
			else if(key.toLowerCase().contains("city"))
			{
				returnvar = utils.enterTextinAnelemnt(txtBoxFirstImpCity, value, "First Immpression", "City");
				continue;
			}
			else if(key.toLowerCase().contains("zipcode"))
			{
				returnvar = utils.enterTextinAnelemnt(txtBoxFirstImpZipCode, value, "First Immpression", "Zip Code");
				continue;
			}
		}
		if(returnvar)
		{
			System.out.println("Mandatory Details Entered Successfully");
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
	 * #CommonMethodWithArgument: editSelectState
	 * #Description: This functionality selects the State in the first impression edit section
	 * #Argument: state
	 * keys: AK#AL#AR#AZ#CA#CO#CT#DC#DE#FL#GA#HI#IA#ID#IL#IN#KS#KY#LA#MAMD#ME#MI#MN#MO#MS#MT#NC#ND#NE#NH#NJ#NM#NV#NY#OH#OK#OR#PA#RI#SC#SD#TN#TX#UT#VA#VT#WA#WIWV#WY
	 */
	public boolean editSelectState(String[] state)
	{
		return utils.selectDropDownbyVisibleString(drpDownFirstImpState, state[0], "FirstImpression_Composite", "State");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: editSelectPolicyState
	 * #Description: This functionality selects the policy State in the first impression edit section
	 * #Argument: policystate
	 * keys: CA#CO#CT#GA#IN#KY#ME#MO#NH#NV#NY#OH#VA#WI
	 */
	public boolean editSelectPolicyState(String[] policystate)
	{
		return utils.selectDropDownbyVisibleString(drpDownFirstImpPolicyState, policystate[0], "FirstImpression_Composite", "Policy State");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectEditDependentSelection
	 * #Description: This functionality selects the dependent selection in the first impression edit section.
	 * #Argument: depselection
	 * Type: Dropdown
	 * keys: Spouse#Son#Daughter 
	 */
	public boolean selectEditDependentSelection(String[] depselection)
	{
		return utils.selectDropDownbyVisibleString(drpDownFirstImpDependentSelection, depselection[0], "FirstImpression_Composite", "Dependent Selection");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterEditDependentMandatoryDetails
	 * #Description: This functionality enters the mandatory details in the dependent selection
	 * #Argument: editMandatoryDetails
	 * Type: Textbox
	 * keys: firstname#lastname#dateofbirth
	 */

	public boolean enterEditDependentMandatoryDetails(String[] editMandatoryDetails)
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
				returnvar = this.inputTextField(txtBoxFirstImpDependentFirstName, value, "FirstImpression_Composite", "Dependent FirstName");
				continue;
			}
			else if(key.toLowerCase().contains("lastname"))
			{
				returnvar = this.inputTextField(txtBoxFirstImpDependentLastName, value, "FirstImpression_Composite", "Dependent LastName");
				continue;
			}
			else if(key.toLowerCase().contains("dateofbirth"))
			{
				returnvar = this.inputTextField(txtBoxFirstImpDependentDOB, value, "FirstImpression_Composite", "Dependent DOB");
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


	public boolean clickSave()
	{
		return utils.clickAnelemnt(btnFirstImpEditSave, "FirstImpression_Composite", "Save Button");
	}

	public boolean clickCancel()
	{
		return utils.clickAnelemnt(btnFirstImpEditCancel, "FirstImpression_Composite", "Cancel Button");
	}

	public boolean clickbtnAddTask()
	{
		return utils.clickAnelemnt(btnAddTAsk, "Member Composite ", "Add Task Button ");
	}

	public boolean setTxtFullContactName(String sFullName)
	{
		return utils.enterTextinAnelemnt(SearchInput, sFullName, "Member Composite", "Application took a long time to load");

	}

	public boolean clicklnkClickonLinkafterSettingValue() throws InterruptedException
	{
		Thread.sleep(2000);
		return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValue, "Member Composite", "Text Box Add Task Options");
	}

	public boolean  navigateTOBenefitsandCost() throws InterruptedException{
		Thread.sleep(2000);
		if(this.clickbtnAddTask())
		{
			wait=new WebDriverWait(Driver.pgDriver,25);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pyOverlayTemplate']//a[@title='Benefits and Cost'][@class='Add_task']")));
			if(setTxtFullContactName("Benefits and Cost"))
				return this.clicklnkClickonLinkafterSettingValue();
		}
		return false;
	}

}
