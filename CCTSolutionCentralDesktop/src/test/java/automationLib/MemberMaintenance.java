package automationLib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class MemberMaintenance {



	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	public MemberMaintenance() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}


	@FindBy(xpath="(//a[@data-test-id='20171003073021092212915'])[1]")
	WebElement linkUpdateAddress;

	@FindBy(xpath="//button[@name='MemberAddressHistory_pyWorkPage_208']")
	WebElement btnUpdateAddress;

	@FindBy(xpath="xpath to click Add Phone Number")
	WebElement btnAddPhoneNum;

	@FindBy(xpath="//button[@name='MemberAddressHistory_pyWorkPage_208']")
	WebElement btnUpdatePhoneNum;

	@FindBy(xpath="Xpath to select type")
	WebElement drpDownType;

	@FindBy(xpath="xpath to enter Address")
	WebElement txtAddress;

	@FindBy(xpath="xpath to select state")
	WebElement drpDownState;

	@FindBy(xpath="xpath to select county")
	WebElement drpDownCounty;

	@FindBy(xpath="xpath to enter Zipcode 5 digits")
	WebElement txtZipCode5digits;

	@FindBy(xpath="xpath to enter zipcode 4 digits")
	WebElement txtZipCode4digits;

	@FindBy(xpath="xpath to click add button")
	WebElement btnAdd;

	@FindBy(xpath="xpath to click close button")
	WebElement btnClose;

	@FindBy(xpath="xpath to click delete button")
	WebElement btnDelete;

	@FindBy(xpath="xpath to click Same as address")
	WebElement chkBoxSameAsAddress;

	@FindBy(xpath="xpath to select type for phone/fax")
	WebElement drpDownPhone;

	@FindBy(xpath="xpath to enter Address")
	WebElement txtPhoneNo;

	@FindBy(xpath="//div[contains(text(),'Update')]")
	WebElement btnUpdate;

	@FindBy(xpath="xpath to click sort icon")
	WebElement drpSortIcon;

	@FindBy(xpath=" //div[text()='Address Line 1']//ancestor::table[1]")
	WebElement tblAddressHistory;

	@FindBy(xpath="//table[@pl_prop='.PhoneHistory']")
	WebElement tblPhoneHistory;

	public boolean ClicklinkUpdateAddress()
	{
		return utils.clickAnelemnt(this.linkUpdateAddress, "MemberMaintenance", "Add Address Button");
	}

	public boolean clickAddPhoneNum()
	{
		return utils.clickAnelemnt(this.btnAddPhoneNum, "MemberMaintenance", "Add Phone Num Button");
	}

	public boolean clickUpdateAddress()
	{
		return utils.clickAnelemnt(this.btnUpdateAddress, "MemberMaintenance", "Update Address button");
	}

	@FindBy(xpath="//table[@pl_prop='.PhoneCommunication']")
	WebElement tblPhoneandFax;

	public boolean clickUpdatePhoneNum(String[] args) throws InterruptedException
	{

		try
		{
			WebElement row = utils.returntablerowbasedonvalues(tblPhoneandFax, args);
			List<WebElement> SelectRow = row.findElements(By.tagName("a"));
			SelectRow.get(0).click();
			System.out.println("Update phone number is successfully clicked");
			return true;
		}
		catch(Exception e){
			err.logError("clcik update for phone number and fax is unsuccessful: "+e);
			return false;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectMemberNameCheckBox
	 * #Description: This functionality selects the member name to add or update address or phone number
	 * #Argument: membername
	 * Type: Textbox
	 */
	public boolean selectMemberNameCheckBox(String[] membername)
	{

		String xpath = "//span[contains(text(),'"+membername[0]+"')]//parent::td//parent::tr//*[@type='checkbox']";
		System.out.println("xpath is: " + xpath);
		utils.waitforpageload();
		Driver.pgDriver.findElement(By.xpath(xpath)).click();
		return true;

	}

	public boolean selectType(String args)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownType, args, "MemberMaintenance", "Type");
	}

	public boolean selectState(String args)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownState, args, "MemberMaintenance", "State");
	}

	public boolean selectCounty(String args)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownState, args, "MemberMaintenance", "County");
	}

	public boolean enterAddress(String args)
	{
		return utils.enterTextinAnelemnt(this.txtAddress, args, "MemberMaintenance", "Address");
	}

	public boolean enterZipCode5Digit(String args)
	{
		return utils.enterTextinAnelemnt(this.txtZipCode5digits, args, "MemberMaintenance", "Zipcode 5 Digit");
	}

	public boolean enterZipCode4Digit(String args)
	{
		return utils.enterTextinAnelemnt(this.txtZipCode4digits, args, "MemberMaintenance", "Zipcode 4 digit");
	}

	public boolean clickAddButton()
	{
		return utils.clickAnelemnt(this.btnAdd, "MemberMaintenance", "Add button");
	}

	public boolean clickUpdateButton()
	{
		return utils.clickAnelemnt(this.btnUpdate, "MemberMaintenance", "Update button");
	}

	public boolean clickCloseButton()
	{
		return utils.clickAnelemnt(this.btnClose, "MemberMaintenance", "Close button");
	}

	public boolean clickDeleteButton()
	{
		return utils.clickAnelemnt(this.btnDelete, "MemberMaintenance", "Delete button");
	}

	public boolean selectPhoneOrFax(String args)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownPhone, args, "MemberMaintenance", "Phone/Fax");
	}

	public boolean enterPhoneNum(String args)
	{
		return utils.enterTextinAnelemnt(this.txtPhoneNo, args, "MemberMaintenance", "Phone No");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterAddressAndZipCode
	 * #Description: This functionality enters the address and zip code for the selected member in the address section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean enterAddressAndZipCode(String[] args)
	{
		if(this.enterAddress(args[0]))
			if(this.enterZipCode5Digit(args[1]))
				return this.enterZipCode4Digit(args[2]);
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: addAddressForTheMember
	 * #Description: This functionality adds the address for the selected member in the address section
	 * #Argument: args
	 * Type: Textbox
	 */

	public boolean addAddressForTheMember(String[] args)
	{	
		if(this.ClicklinkUpdateAddress())
		{
			if(this.selectType(args[0]))
			{
				if(this.enterAddress(args[1]))
				{
					if(this.enterZipCode5Digit(args[2]))
					{
						if(this.enterZipCode4Digit(args[3]))
						{
							if(this.selectState(args[4]))
							{
								if(this.selectCounty(args[5]))
								{
									if(this.clickAddButton())
									{
										System.out.println("Member Address is added");
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		err.logError("MemberMaintenance", "Member Address Adding is failed");
		return false;

	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: updateAddressForTheMember
	 * #Description: This functionality updates the address for the selected member in the address section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean updateAddressForTheMember(String[] args)
	{	
		if(this.ClicklinkUpdateAddress())
		{
			if(this.selectType(args[0]))
			{
				if(this.enterAddress(args[1]))
				{
					if(this.enterZipCode5Digit(args[2]))
					{
						if(this.enterZipCode4Digit(args[3]))
						{
							if(this.selectState(args[4]))
							{
								if(this.selectCounty(args[5]))
								{
									if(this.clickUpdateButton())
									{
										System.out.println("Member Address is updated");
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		err.logError("MemberMaintenance", "Member Address updating is failed");
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: addPhoneNumForMember
	 * #Description: This functionality adds the phone number for the selected member in the phone number section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean addPhoneNumForMember(String[] args)
	{
		if(this.clickAddPhoneNum())
		{
			if(this.selectPhoneOrFax(args[0]))
			{
				if(this.enterPhoneNum(args[1]))
				{
					if(this.clickAddButton())
					{
						System.out.println("Member Phone Num is added");
						return true;
					}
				}
			}
		}
		err.logError("MemberMaintenance", "Member Phone Num adding is failed");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: updatePhoneNumForMember
	 * #Description: This functionality updates the phone number for the selected member in the phone number section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean updatePhoneNumForMember(String[] args)
	{
		if(this.clickAddPhoneNum())
		{
			if(this.selectPhoneOrFax(args[0]))
			{
				if(this.enterPhoneNum(args[1]))
				{
					if(this.clickUpdateButton())
					{
						System.out.println("Member Phone Num is added");
						return true;
					}
				}
			}
		}
		err.logError("MemberMaintenance", "Member Phone Num updating is failed");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickCloseWhileAddPhoneNumForMember
	 * #Description: This functionality clicks the close button after adding the phone number for the selected member in the phone number section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean clickCloseWhileAddPhoneNumForMember(String[] args)
	{
		if(this.clickAddPhoneNum())
		{
			if(this.selectPhoneOrFax(args[0]))
			{
				if(this.enterPhoneNum(args[1]))
				{
					if(this.clickCloseButton())
					{
						System.out.println("Member Phone Num is not added");
						return true;
					}
				}
			}
		}
		err.logError("MemberMaintenance", "Member Phone Num not adding is failed");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickCloseWhileUpdatePhoneNumForMember
	 * #Description: This functionality clicks the close button after updating the phone number for the selected member in the phone number section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean clickCloseWhileUpdatePhoneNumForMember(String[] args)
	{
		if(this.clickAddPhoneNum())
		{
			if(this.selectPhoneOrFax(args[0]))
			{
				if(this.enterPhoneNum(args[1]))
				{
					if(this.clickCloseButton())
					{
						System.out.println("Member Phone Num is not updated");
						return true;
					}
				}
			}
		}
		err.logError("MemberMaintenance", "Member Phone Num not updating is failed");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickCloseWhileAddAddressForTheMember
	 * #Description: This functionality clicks the close button after adding the address for the selected member in the address section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean clickCloseWhileAddAddressForTheMember(String[] args)
	{	
		if(this.ClicklinkUpdateAddress())
		{
			if(this.selectType(args[0]))
			{
				if(this.enterAddress(args[1]))
				{
					if(this.enterZipCode5Digit(args[2]))
					{
						if(this.enterZipCode4Digit(args[3]))
						{
							if(this.selectState(args[4]))
							{
								if(this.selectCounty(args[5]))
								{
									if(this.clickCloseButton())
									{
										System.out.println("Member Address is not added");
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		err.logError("MemberMaintenance", "Member Address closing is failed");
		return false;

	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickCloseWhileUpdateAddressForTheMember
	 * #Description: This functionality clicks the close button after updating the address for the selected member in the address section
	 * #Argument: args
	 * Type: Textbox
	 */
	public boolean clickCloseWhileUpdateAddressForTheMember(String[] args)
	{	
		if(this.ClicklinkUpdateAddress())
		{
			if(this.selectType(args[0]))
			{
				if(this.enterAddress(args[1]))
				{
					if(this.enterZipCode5Digit(args[2]))
					{
						if(this.enterZipCode4Digit(args[3]))
						{
							if(this.selectState(args[4]))
							{
								if(this.selectCounty(args[5]))
								{
									if(this.clickCloseButton())
									{
										System.out.println("Member Address is not added");
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		err.logError("MemberMaintenance", "Member Address closing is failed");
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickOnTheSortIcon
	 * #Description: This functionality clicks on the Sort Icon in the application.
	 * Type: Textbox
	 */
	public boolean clickOnTheSortIcon()
	{
		return utils.clickAnelemnt(this.drpSortIcon, "MemberMaintenance", "Sort Icon");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: sortTheTypeColumnValues
	 * #Description: This functionality retrieves the value from the application and then sort the value.
	 * #Argument: columnName
	 * Type: Textbox
	 */
	public boolean isColumnValuesSorted(String[] columnName)
	{
		ArrayList<String> columnList = new ArrayList<String>();
		columnList = utils.getcolumnStringFromTableByName(this.tblAddressHistory, columnName[0]);
		System.out.println("Values in the list before sort: "+ columnList);
		ArrayList<String> actualColumnList = new ArrayList<String>(columnList);
		Collections.sort(columnList, Collections.reverseOrder());
		System.out.println("Values in the list after sort: "+ columnList);
		return columnList.equals(actualColumnList);
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyAddressHeaderRowTable
	 * #Description: This functionality validates the header row of the Member Address History table
	 * Type: Textbox
	 */
	public boolean verifyAddressHeaderRowTable()
	{
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblAddressHistory);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("");
		valuesGivenManual.add("Type");
		valuesGivenManual.add("Address Line 1");
		valuesGivenManual.add("Address Line 2");
		valuesGivenManual.add("City");
		valuesGivenManual.add("State");
		valuesGivenManual.add("Zip Code");
		valuesGivenManual.add("County");
		valuesGivenManual.add("");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		return valuesFromApp.equals(valuesGivenManual);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyPhoneAddressHeaderTable
	 * #Description: This functionality validates the header row of the Member Phone History table
	 * Type: Textbox
	 */
	public boolean verifyPhoneAddressHeaderTable()
	{
		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblPhoneHistory);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("Type");
		valuesGivenManual.add("Phone Number");
		valuesGivenManual.add("Updated By");
		valuesGivenManual.add("Updated Date");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		return valuesFromApp.equals(valuesGivenManual);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: checkUpdateAddressButton
	 * #Description: This functionality checks whether the update address button is enabled or disabled.
	 * Type: Textbox 
	 */
	public boolean checkUpdateAddressButton()
	{
		return this.btnUpdateAddress.isEnabled();
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: checkUpdatePhoneNumberButton
	 * #Description: This functionality checks whether the update phone number button is enabled or disabled.
	 * Type: Textbox 
	 */
	public boolean checkUpdatePhoneNumberButton()
	{
		return this.btnUpdatePhoneNum.isEnabled();	
	}

	@FindBy(xpath="//div[contains(text(),'Add/Update Language')]")
	WebElement btnAddUpdateLanguage;

	@FindBy(xpath="//div[@node_name='RaceAndEthnicityMaintenance']//a[@data-test-id='20171003073021092212915'][text()='Update']")
	WebElement btnUpdateRaceAndEthinicity;

	@FindBy(xpath="//span[@role='heading'][text()='Race and Ethnicity']")
	WebElement raceAndEthnicitySection;

	@FindBy(id="SpokenLanguage")
	WebElement txtSpokenLanguage;

	@FindBy(id="WrittenLanguage")
	WebElement txtWrittenLanguage;

	@FindBy(id="SpokenLanguage")
	WebElement txtRace;

	@FindBy(id="WrittenLanguage")
	WebElement txtEthnicity;

	@FindBy(xpath="//*[@id='$PD_LanguageList$ppxResults$l1']")
	WebElement lnkClickonLinkafterSettingValueForSpokenLanguage;

	@FindBy(xpath="//*[@id='$PD_LanguageList$ppxResults$l130']")
	WebElement lnkClickonLinkafterSettingValueForWrittenLanguage;

	@FindBy(xpath="//button[contains(@name,'UpdateLanguage_MemberPreferences')]//div[contains(text(),'Update')]")
	WebElement btnAddUpdateInLanguage;

	@FindBy(xpath="//button[contains(@name,'UpdateLanguage_MemberPreferences')]//div[contains(text(),'Close')]")
	WebElement btnCloseInLanguage;

	@FindBy(xpath="//div[@node_name='RaceAndEthnicityMaintenance']//a")
	WebElement btnUpdateInRaceAndEthnicity;

	@FindBy(xpath="//button[@data-test-id='20180125213049051369379']//div[contains(text(),'Close')]")
	WebElement btnCloseInRaceAndEthnicity;

	@FindBy(xpath="//div[@data-test-id='20161103134931086139307']")
	WebElement txtMessageForAddUpdateLanguage;

	@FindBy(xpath="//label[@data-test-id='201801260137330073174427-Label']/span")
	WebElement labelRace;

	@FindBy(xpath="//label[@data-test-id='201801260137330073176483-Label']/span")
	WebElement labelEthnicity;

	@FindBy(xpath="//span[@id='headerlabel4680']")
	WebElement labelTitleOfRaceAndEthnicity;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: btnAddUpdateLanguage
	 * #Description: This functionality checks whether the add update language button is enabled or disabled.
	 * Type: Textbox 
	 */
	public boolean checkAddUpdateLanguageButton()
	{
		return this.btnAddUpdateLanguage.isEnabled();	
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: checkUpdateRaceAndEthnicityButton
	 * #Description: This functionality checks whether the update Race and Ethnicity button is enabled or disabled.
	 * Type: Textbox 
	 */
	public boolean checkUpdateRaceAndEthnicityButton()
	{
		return this.btnUpdateRaceAndEthinicity.isEnabled();
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAddUpdateLanguageButton
	 * #Description: This functionality clicks the Add Update Language button in Member Maintenance Section.
	 * Type: Textbox 
	 */
	public boolean clickAddUpdateLanguageButton()
	{
		return utils.clickAnelemnt(this.btnAddUpdateLanguage, "MemberManitenance", "Add Update Language");

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAddUpdateEthnicityButton
	 * #Description: This functionality clicks the Add Update Ethnicity button in Member Maintenance Section.
	 * Type: Textbox 
	 */
	public boolean clickAddUpdateEthnicityButton()
	{
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.raceAndEthnicitySection);
		return utils.clickAnelemnt(this.btnUpdateRaceAndEthinicity, "MemberManitenance", "Update Ethnicity");
	}

	@FindBy(xpath="//div[@node_name='RaceAndEthnicityMaintenance']//label[text()='Race']//following-sibling::div//span")
	WebElement raceValue;

	@FindBy(xpath="//div[@node_name='RaceAndEthnicityMaintenance']//label[text()='Ethnicity']//following-sibling::div//span")
	WebElement ethnicityValue;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:validateRaceAndEthnicitySection
	 * #Description:This functionality validates the Race and Ethnicity section in Member Maintenance Section.
	 * #Arguments:RaceAndEthnicityKey
	 * Type:Table
	 * Keys:Race#Ethnicity
	 */
	public boolean validateRaceAndEthnicitySection(String args[])
	{
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.raceAndEthnicitySection);
		boolean returnvar =true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("validateRaceAndEthnicitySection", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.contains("Race"))
			{			
				returnvar=true;
				utils.isvalueMatch_contain(this.raceValue.getText().trim(),value);				
				continue;

			}
			else if(key.contains("Ethnicity"))
			{
				returnvar=true;
				utils.isvalueMatch_contain(this.ethnicityValue.getText().trim(),value);	
				continue;

			}
			else
			{
				err.logcommonMethodError("MemberMaintenance", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		return true;
	}


	@FindBy(xpath="//table[@pl_prop='.Address']")
	WebElement memberAddressTbl;

	@FindBy(xpath="//table[@pl_prop='.PhoneCommunication']")
	WebElement memberPhoneAndFaxTbl;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:clickUpdateMemberAddress
	 * #Description:This functionality validates and updates Member address in Member Maintenance page.
	 * #Arguments:MemberAddress
	 * Type:Table
	 * Keys:Type#Address Line 1#Address Line 2#City#State#Zip Code#County
	 */
	public boolean clickUpdateMemberAddress(String args[]) throws InterruptedException
	{
		utils.waitforpageload();
		try{
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.memberAddressTbl);
			WebElement row = utils.getTablerowbasedonvalues(this.memberAddressTbl, args);
			row.findElement(By.xpath(".//a[text()='Update']")).click();
			utils.waitforpageload();
			return true;
		}catch(Exception e){
			err.logError("Member address couldnt be updated" + e);
			return false;
		}
	}

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaders;

	@FindBy(xpath="//table[@pl_prop='D_MemberHistory.pxResults']")
	private WebElement addressPhoneHistoryTable;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:clickViewHistoryMemberAddress
	 * #Description:This functionality validates and click on View History Member address in Member Maintenance page.
	 * #Arguments:ViewHistoryMemberAddress
	 * Type:Table
	 * Keys:Type#Address Line 1#Address Line 2#City#State#Zip Code#County
	 * Keys:Type#In Care Of#Address#City#State#Zip Code#County#Postal Code#Updated By#Updated Date
	 */
	public boolean clickViewHistoryMemberAddress(String args[]) throws InterruptedException
	{
		utils.waitforpageload();
		((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.memberAddressTbl);
		WebElement row = utils.getTablerowbasedonvalues(this.memberAddressTbl, args);
		row.findElement(By.xpath(".//a[text()='View History']")).click();
		if(utils.validateHeader(this.sHeaders, "Address/Phone History"))
			return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyViewMemAddressHistoryIsntDisplayed
	 * #Description:This functionality verifies View History Member address isnt displayed in Member Maintenance page.
	 * #Arguments:ViewHistoryMemberAddress
	 * Type:Table
	 * Keys:Type#Address Line 1#Address Line 2#City#State#Zip Code#County
	 */
	public boolean verifyViewMemAddressHistoryIsntDisplayed(String args[]) throws InterruptedException
	{
		utils.waitforpageload();
		try{
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.memberAddressTbl);
			WebElement row = utils.getTablerowbasedonvalues(this.memberAddressTbl, args);
			if(row.findElement(By.xpath(".//a[text()='View History']")).isDisplayed())
				return true;
			return false;
		}catch(Exception e){
			err.logError("View History link in Member address section isnt displayed Member Maintenance page" + e);
			return true;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:clickUpdateMemberPhoneAndFax
	 * #Description:This functionality validates and updates Member Phone and Fax in Member Maintenance page.
	 * #Arguments:MemberPhoneAndFax
	 * Type:Table
	 * Keys:Type#Number
	 */
	public boolean clickUpdateMemberPhoneAndFax(String args[]) throws InterruptedException
	{
		try{
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.memberPhoneAndFaxTbl);
			WebElement row = utils.getTablerowbasedonvalues(this.memberPhoneAndFaxTbl, args);
			row.findElement(By.xpath("//a[text()='Update']")).click();
			return true;
		}catch(Exception e){
			err.logError("Member Phone and Fax couldnt be updated" + e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:clickViewHistoryMemberPhoneAndFax
	 * #Description::This functionality validates and click on View History - Member Phone and Fax in Member Maintenance page.
	 * #Arguments:MemberPhoneAndFax
	 * Type:Table
	 * Keys:Type#Number
	 */
	public boolean clickViewHistoryMemberPhoneAndFax(String args[]) throws InterruptedException
	{
		utils.waitforpageload();
		try{
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.memberPhoneAndFaxTbl);
			WebElement row = utils.getTablerowbasedonvalues(this.memberPhoneAndFaxTbl, args);
			row.findElement(By.xpath(".//a[text()='View History']")).click();
			if(utils.validateHeader(this.sHeaders, "Address/Phone History")){
				System.out.println("View History navigated to Address/Phone History page");
				return true;
			}else{
				err.logError("View History didnt navigate to Address/Phone History page");
				return false;
			}
		}catch(Exception e){
			err.logError("View History in Member address couldnt be clicked and validated" + e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyViewPhoneAndFaxHistoryIsntDisplayed
	 * #Description:This functionality verifies View History Phone and fax isnt displayed in Member Maintenance page.
	 * #Arguments:ViewHistoryPhoneAndFax
	 * Type:Table
	 * Keys:Type#Number
	 */
	public boolean verifyViewPhoneAndFaxHistoryIsntDisplayed(String args[]) throws InterruptedException
	{
		utils.waitforpageload();
		try{
			((JavascriptExecutor)Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",this.memberPhoneAndFaxTbl);
			WebElement row = utils.getTablerowbasedonvalues(this.memberPhoneAndFaxTbl, args);
			if(row.findElement(By.xpath(".//a[text()='View History']")).isDisplayed()){
				System.out.println("View History link in Phone and fax section is displayed Member Maintenance page");
			}
			return false;
		}catch(Exception e){
			err.logError("View History link in Phone and fax section isnt displayed Member Maintenance page" + e);
			return true;
		}
	}
	public WebElement enterLanguageInSpokenLanguage()
	{
		return txtSpokenLanguage;
	}

	public WebElement enterLanguageInWrittenLanguage()
	{
		return txtWrittenLanguage;
	}

	public boolean setTxtFullNameForSpokenLanguage(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.enterLanguageInSpokenLanguage(), sFullName, "MemberMaintenance", "Element is not entered in the Spoken Language");

	}

	public boolean setTxtFullNameForWrittenLanguage(String args)
	{
		return utils.enterTextinAnelemnt(this.enterLanguageInWrittenLanguage(), args, "MemberMaintenance", "Element is not entered in the Written Language");

	}

	public boolean setTxtFullNameForRace(String sFullName)
	{
		return utils.enterTextinAnelemnt(this.enterLanguageInSpokenLanguage(), sFullName, "MemberMaintenance", "Element is not entered in the Race");
	}

	public boolean setTxtFullNameForEthnicity(String args)
	{
		return utils.enterTextinAnelemnt(this.enterLanguageInWrittenLanguage(), args, "MemberMaintenance", "Element is not entered in the Ethnicity");

	}
	public boolean clicklnkClickonLinkafterSettingValue() throws InterruptedException
	{
		Thread.sleep(2000);
		return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValueForWrittenLanguage, "MemberMaintenance", "First Element is not clicked");		
	}


	public boolean clicklnkClickonLinkafterSettingValueForWrittenLanguage() throws InterruptedException
	{
		Thread.sleep(2000);
		return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValueForWrittenLanguage, "MemberMaintenance", "First Element is not clicked");		

	}

	public boolean clicklnkClickonLinkafterSettingValueForSpokenLanguage() throws InterruptedException
	{
		Thread.sleep(2000);
		return utils.clickAnelemnt(this.lnkClickonLinkafterSettingValueForSpokenLanguage, "MemberMaintenance", "First Element is not clicked");		
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectAddUpdateWriitenLanguage
	 * #Description: This functionality enters the written language and selects the entered written language.
	 * Type: Textbox 
	 */

	public boolean selectAddUpdateWrittenLanguage(String[] args) throws InterruptedException
	{
		Driver.pgDriver.findElement(By.id("WrittenLanguage")).clear();
		if(setTxtFullNameForWrittenLanguage(args[0]))
		{
			if(this.clicklnkClickonLinkafterSettingValueForWrittenLanguage())
			{
				System.out.println("Pass : The Value is entered in the text Field and selected the entered value");
				return true; 
			}
		}	
		System.out.println("Fail : There is some error with naviagted value");
		return false; 
	}



	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectAddUpdateSpokenLanguage
	 * #Description: This functionality enters the Spoken language and selects the entered Spoken language.
	 * Type: Textbox 
	 */

	public boolean selectAddUpdateSpokenLanguage(String[] args) throws InterruptedException
	{
		Driver.pgDriver.findElement(By.id("SpokenLanguage")).clear();
		if(setTxtFullNameForSpokenLanguage(args[0]))
		{
			if(this.clicklnkClickonLinkafterSettingValueForSpokenLanguage())
			{
				System.out.println("Pass : The Value is entered in the text Field and selected the entered value");
				return true; 
			}
		}	
		System.out.println("Fail : There is some error with selecting the entered value");
		return false; 
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAddUpdateButtonInAddUpdateLanguage
	 * #Description: This functionality clicks the Add/Update button in the Add/Update Language section.
	 * Type: Textbox 
	 */
	public boolean clickAddUpdateButtonInAddUpdateLanguage()
	{
		return utils.clickAnelemnt(this.btnAddUpdateInLanguage, "MemberMaintenance", "Add Update Button");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCloseButtonInAddUpdateLanguage
	 * #Description: This functionality clicks the close button in the Add/Update Language section.
	 * Type: Textbox 
	 */
	public boolean clickCloseButtonInAddUpdateLanguage()
	{
		return utils.clickAnelemnt(this.btnCloseInLanguage, "MemberMaintenance", "Close Button");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyMessageDisplayedForAddUpdateLanguage
	 * #Description: This functionality verifies the message displayed after updating the language.
	 * Type: Textbox 
	 */
	public boolean verifyMessageDisplayedForAddUpdateLanguage()
	{
		String ErrorMsgInUI = txtMessageForAddUpdateLanguage.getText();
		String SuccessMsgInUI = txtMessageForAddUpdateLanguage.getText();

		String ErrorMsgInFromUser = "Language update failed due to technical reason";
		String SuccessMsgInFromUser = "Language has been updated successfully";

		return SuccessMsgInUI.contains(SuccessMsgInFromUser);

	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectAddUpdateWriitenLanguage
	 * #Description: This functionality enters the written language and selects the entered written language.
	 * Type: Textbox 
	 */

	public boolean selectTheEnteredRace(String[] args) throws InterruptedException
	{
		if(setTxtFullNameForRace(args[0]))
			return this.clicklnkClickonLinkafterSettingValue();
		return false; 
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectAddUpdateSpokenLanguage
	 * #Description: This functionality enters the Spoken language and selects the entered Spoken language.
	 * Type: Textbox 
	 */

	public boolean selectTheEnteredEthnicity(String[] args) throws InterruptedException
	{
		if(setTxtFullNameForEthnicity(args[0]))
			return this.clicklnkClickonLinkafterSettingValue();
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickUpdateButtonInRaceEthnicity
	 * #Description: This functionality clicks the Update button in the update Race and Ethnicity section.
	 * Type: Textbox 
	 */
	public boolean clickUpdateButtonInRaceEthnicity()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnUpdateInRaceAndEthnicity, "MemberMaintenance", "Update Button");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCloseButtonInRaceEthnicity
	 * #Description: This functionality clicks the close button in the update Race and Ethnicity section.
	 * Type: Textbox 
	 */
	public boolean clickCloseButtonInRaceEthnicity()
	{
		return utils.clickAnelemnt(this.btnCloseInRaceAndEthnicity, "MemberMaintenance", "Close Button");
	}

	@FindBy(xpath="//a[contains(text(),'Add')]")
	WebElement lnkAdd;

	@FindBy(xpath="//select[contains(@id,'EmailType1')]")
	WebElement drpDownEmailType1;

	@FindBy(xpath="//table[@pl_prop='.EmailList']//input[contains(@id,'Email1')]")
	WebElement txtEmail1;

	@FindBy(xpath="//select[contains(@id,'EmailType2')]")
	WebElement drpDownEmailType0;

	@FindBy(xpath="//table[@pl_prop='.EmailList']//input[contains(@id,'Email2')]")
	WebElement txtEmail0;

	@FindBy(xpath="//div[@data-test-id='20161103134931086139307']")
	WebElement txtErrorMsgInEmail;

	@FindBy(xpath="//div[@data-test-id='20161103134931086139307']")
	WebElement txtSuccessMsgInEmail;

	@FindBy(xpath="//*[@id='PreferenceValue1']")
	WebElement drpDownPreferenceValue;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;

	@FindBy(xpath="//div[contains(text(),'Demographic')]")
	WebElement txtGuidedDialogInMemberMaintenance;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickAddButtonAndEnterEmailDetails
	 * #Description: This functionality add the email given by the user by selecting the type of the email in mail section and entering the email in the email section
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean clickAddButtonAndEnterEmailDetails(String[] args)
	{
		try{
			utils.clickAnelemnt(this.lnkAdd, "MemberMaintenance", "Add Email");
			List<WebElement> l=Driver.pgDriver.findElements(By.xpath("//select[contains(@id,'EmailType')]"));
			int sizeNo = l.size();
			Driver.pgDriver.findElement(By.xpath("//select[contains(@id,'EmailType"+sizeNo+"')]")).sendKeys(args[0]);
			Driver.pgDriver.findElement(By.xpath("//span[text()='"+args[0]+"']//ancestor::td[@headers='a2']//following-sibling::td[@headers='a4']//img[@data-test-id='201708142133160073190796']")).click();	
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(Driver.pgDriver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+args[0]+"']//ancestor::td[@headers='a2']//following-sibling::td[@headers='a3']/div/span/input[@data-test-id='201602282126240407223475']")));
			Driver.pgDriver.findElement(By.xpath("//span[text()='"+args[0]+"']//ancestor::td[@headers='a2']//following-sibling::td[@headers='a3']/div/span/input[@data-test-id='201602282126240407223475']")).sendKeys(args[1]);
		}catch(Exception e){
			err.logError("MemberMaintenance", "Add Email");
			System.out.println("Unable to enter value to field - Email Type and Email ID"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickUpdateAndVerifyErrorMsg
	 * #Description: This functionality clicks the Update button in the Member Maintenance section and verify the error message displayed.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean clickUpdateAndVerifyErrorMsg(String[] args)
	{
		String ErrorMessageFromUser = args[0];
		System.out.println("Message From User is: "+ErrorMessageFromUser);
		String ErrorMessageInUI = txtErrorMsgInEmail.getText();
		System.out.println("Message in UI: "+ErrorMessageInUI);
		return ErrorMessageInUI.equalsIgnoreCase(ErrorMessageFromUser);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickUpdateAndVerifySuccessMsg
	 * #Description: This functionality clicks the Update button in the Member Maintenance section and verify the success message displayed.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean clickUpdateAndVerifySuccessMsg(String[] args)
	{

		clickUpdateButton();
		System.out.println("Update button is clicked");
		String SuccessMessageFromUser = args[0];
		System.out.println("Message From User is: "+SuccessMessageFromUser);
		String SuccesssMessageInUI = txtErrorMsgInEmail.getText().replaceAll("\n", "");

		System.out.println("Message in UI: "+SuccesssMessageInUI);
		return SuccesssMessageInUI.contains(SuccessMessageFromUser);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyAlertMessage
	 * #Description: This functionality clicks the submit button in the Member Maintenance section without updating the changes made and verify the alert message displayed.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean verifyAlertMessage(String[] alertmsg)
	{
		String AlertMsgFromUser = alertmsg[0];
		Driver.pgDriver.switchTo().alert();
		String AlertMessage = Driver.pgDriver.switchTo().alert().getText();
		System.out.println("Alert Message Displayed in UI is: "+AlertMessage);
		if(AlertMsgFromUser.equalsIgnoreCase(AlertMessage))
		{
			System.out.println("Alert Message is Validated");
			return true;
		}
		else
		{
			System.out.println("Alert Message Validation is Failed");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyLabelRace
	 * #Description: This functionality verifies the label race displayed in the Race section.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean validateTheLabelRace(String[] args)
	{
		String labelFromUser= args[0];
		System.out.println("User: "+labelFromUser);
		String labelInUI = this.labelRace.getText();
		System.out.println(labelInUI);
		if(labelInUI.equalsIgnoreCase(labelFromUser))
		{
			System.out.println("Label Race in the UI and given by the User matched.");
			return true;
		}
		else
		{
			System.out.println("Label Race in the UI and given by the User doesnt matched.");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyLabelEthnicity
	 * #Description: This functionality verifies the label Ethnicity displayed in the Ethnicity section.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean validateTheLabelEthnicity(String[] args)
	{
		String labelFromUser= args[0];
		System.out.println("User: "+labelFromUser);
		String labelInUI = this.labelEthnicity.getText();
		System.out.println(labelInUI);
		if(labelInUI.equalsIgnoreCase(labelFromUser))
		{
			System.out.println("Label Etnicity in the UI and given by the User matched.");
			return true;
		}
		else
		{
			System.out.println("Label Ethnicity in the UI and given by the User doesnt matched.");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateTheTitleOfTheRaceAndEthnicity
	 * #Description: This functionality verifies the title label displayed in the Race and Ethnicity section.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean validateTheTitleOfTheRaceAndEthnicity(String[] args)
	{
		String labelFromUser= args[0];
		String labelInUI = this.labelTitleOfRaceAndEthnicity.getText();
		if(labelInUI.contains(labelFromUser))
		{
			System.out.println("Label Title in the UI and given by the User matched.");
			return true;
		}
		else
		{
			System.out.println("Label Title in the UI and given by the User doesnt matched.");
			return false;
		}

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyPreferencesIsDisabled
	 * #Description: This functionality verifies that the Preferences drop down is enabled or not.
	 * Type: Textbox 
	 */
	public boolean verifyPreferencesIsDisabled()
	{
		String value =drpDownPreferenceValue.getAttribute("disabled");
		return utils.isvalueMatch_compareto(value, "true");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: selectValueInPreferences
	 * #Description: This functionality selects the value from the Preferences drop down in Member Maintenance section.
	 * Type: Textbox 
	 */
	public boolean selectValueInPreferences(String[] args)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownPreferenceValue, args[0], "MemberMaintenance", "Preference value");

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on submit button in the Member Maintenance section.
	 * Type: Textbox 
	 */
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "MemberMaintenance", "Submit");
	}


	public boolean deleteEmailInEmailSection(String[] args)
	{
		try{
			List<WebElement> l=Driver.pgDriver.findElements(By.xpath("//select[contains(@id,'EmailType')]"));
			int sizeNo = l.size();
			Driver.pgDriver.findElement(By.xpath("//select[contains(@id,'EmailType"+sizeNo+"')]")).sendKeys(args[0]);
			Thread.sleep(3000);
			Driver.pgDriver.findElement(By.xpath("//span[text()='"+args[0]+"']//ancestor::td[@headers='a2']//following-sibling::td[@headers='a4']//img")).click();			
			Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.EmailList']//input[contains(@id,'Email"+sizeNo+"')]")).sendKeys(args[1]);
		}catch(Exception e){
			err.logError("MemberMaintenance", "Add Email");
			System.out.println("Unable to enter value to field - Email Type and Email ID"+e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateTheGuidedMsgInMemberMaintenance
	 * #Description: This functionality validates the guided message displayed in the Member Maintenance section with the message given by the user.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean validateTheGuidedMsgInMemberMaintenance(String[] args)
	{
		String guidedmessagefromuser = args[0];
		String guidedmessagefromUI = this.txtGuidedDialogInMemberMaintenance.getText().replaceAll(",", "");
		if(guidedmessagefromuser.contains(guidedmessagefromUI))
		{
			System.out.println("Guided dialog message given by the user and in UI matched");
			return true;
		}
		else
		{
			System.out.println("Guided dialog message given by the user and in UI doesnt matched");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: validateTheErrorMessageOnClickingSubmit
	 * #Description: This functionality validates the error message displayed in the Member Maintenance section with the message given by the user.
	 * #Argument: args
	 * Type: Textbox 
	 */
	public boolean validateTheErrorMessageOnClickingSubmit(String[] args)
	{
		String guidedmessagefromuser = args[0];
		String guidedmessagefromUI = this.txtGuidedDialogInMemberMaintenance.getText().replaceAll(",", "");
		if(guidedmessagefromuser.contains(guidedmessagefromUI))
		{
			System.out.println("Error message given by the user and in UI matched");
			return true;
		}
		else
		{
			System.out.println("Error message given by the user and in UI doesnt matched");
			return false;
		}
	}

	@FindBy(xpath="//li[@title='Contact Preferences']")
	WebElement ContactPreferenceLink;

	/**This method is used to select contact preference tab
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean selectContactPreferenceTab() throws InterruptedException {
		utils.clickAnelemnt(ContactPreferenceLink, "Member Maintenance", "ContactPreferenceLink");
		return !utils.isServiceDown();
	}

	public boolean verifyErrorMessage(String[] args) {
		return utils.validateLabel(txtErrorMsgInEmail, args[0]);
	}

	@FindBy(xpath="//*[@data-test-id='20180322213819090461498']")
	WebElement UpdateLink;

	public boolean clickUpdateLink() {
		return utils.clickAnelemnt(UpdateLink, "Member Maintenance", "UpdateLink");
	}

	@FindBy(xpath="//input[@data-test-id='20171030090559075632753']")
	WebElement txtboxEmailAddress;

	@FindBy(xpath="//div[@node_name='CommercialEmailUpdateLinks']//a[@data-test-id='20171003073021092211521']")
	WebElement applyEmailAddress;

	@FindBy(xpath="//span[@data-test-id='20171030025447019450450']")
	WebElement updatePreferenceYes;

	public boolean updateMemberEmailAddress(String[] arg) throws InterruptedException{

		if(this.selectContactPreferenceTab())
			if(utils.enterTextinAnelemnt(this.txtboxEmailAddress, arg[0], "Member Maintenance", "member address txtbox"))
				if( utils.clickAnelemnt(this.applyEmailAddress,"Member Maintenance", "UpdateLink"))
					if(utils.clickAnelemnt(this.updatePreferenceYes,"Member Maintenance", "UpdateLink"))
						return true;
		return false;
	}

	public boolean verifyPrefferedEmail(String[] arg) throws Exception{

		return utils.validateValueinelement(this.updatePreferenceYes, arg[0]);

	}

	@FindBy(xpath="//label[text()='Demographic Update']")
	public WebElement demograpicupdate;

	public boolean clickDemograpicupdate(){
		return utils.clickAnelemnt(this.demograpicupdate, "Member Maintenance", "UpdateLink");
	}

	@FindBy(xpath="//table[@pl_prop='.Address']")
	public WebElement tableMemberAddress;

	@FindBy(xpath="//table[@pl_prop='.PhoneCommunication']")
	public WebElement tableMemberPhoneAndFax;

	public boolean validateMemberAddressInformation(String[] memaddress) throws InterruptedException
	{
		this.clickDemograpicupdate();
		utils.waitforpageload();
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", tableMemberAddress);
		return utils.validatetablerowbasedonvalues(this.tableMemberAddress,memaddress);
	}

	public boolean validatePhoneInformation(String[] memaddress) throws InterruptedException
	{
		this.clickDemograpicupdate();
		utils.waitforpageload();
		JavascriptExecutor jse = (JavascriptExecutor) Driver.pgDriver;
		jse.executeScript("arguments[0].scrollIntoView();", tableMemberPhoneAndFax);		
		return utils.validatetablerowbasedonvalues(this.tableMemberPhoneAndFax,memaddress);
	}

	@FindBy(xpath="//input[@id='AddressChangeNo']")
	public WebElement selectNoRadioButton;

	public boolean selectNoRadioButton()
	{
		return utils.clickAnelemnt(selectNoRadioButton, "Member Maintenance", "SelectNo Radio Button");
	}

	@FindBy(xpath="//*[contains(text(),'Remind member to update address through the marketplace.')]")
	public WebElement GuidanceMsgMarketplace;

	public boolean verifyGuidanceMsgMarketplace()
	{
		System.out.println("Method is entered");
		String Actualtext = GuidanceMsgMarketplace.getText();
		System.out.println(Actualtext);
		String Expectedtext ="Remind member to update address through the marketplace.";
		System.out.println(Expectedtext);
		if(Actualtext.equalsIgnoreCase(Expectedtext)){
			System.out.println("Test case is passed");
			blogger.loginfo("PASS: GuidanceMsgMarketplace is verified successfully");
			return true;
		}
		else
		{
			blogger.loginfo("Fail: GuidanceMsgMarketplace is not verified successfully");
			return false;

		}
	}





}
