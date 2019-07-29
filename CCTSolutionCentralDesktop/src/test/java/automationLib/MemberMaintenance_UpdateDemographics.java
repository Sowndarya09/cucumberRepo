package automationLib;

import java.util.List;

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

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class MemberMaintenance_UpdateDemographics {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(),20);

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;


	public MemberMaintenance_UpdateDemographics() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	@FindBy(id="Race")
	WebElement raceDrpdown;

	@FindBy(id="Ethnicity")
	WebElement ethnicityDrpdown;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Update']")
	private WebElement btnUpdate;

	@FindBy(xpath="//div[@class='field-item dataLabelWrite privacyalert_dataLabelWrite']")
	private WebElement msgText;

	@FindBy(xpath="//p//span[@style='color:#FF0000;']//span")
	private WebElement addressUpdateTxt;

	@FindBy(xpath="//p//span[contains(@style,'color')]")
	private WebElement addressUpdateTxtFailure;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions') or contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Member Maintenance']")	
	private WebElement lnkOtherMemberMaintenance;

	@FindBy(xpath="//p//em")
	List<WebElement> nationalMemberTextInfo;

	String selectAll = Keys.chord(Keys.CONTROL,"a");
	Actions action = new Actions(Driver.pgDriver);

	/*
	 * @SCU
	 * #CommonMethodWithArgument:updateRace
	 * #Description: This functionality updates the Race value in UpdateDemographics page.
	 * #Argument:Race
	 * Type:Textbox 
	 */
	public boolean updateRace(String args[]){
		try{
			action.moveToElement(this.raceDrpdown).click().sendKeys(selectAll,Keys.DELETE).build().perform();
			utils.enterTextinAnelemnt(this.raceDrpdown, args[0], "UpdateDemographics", "Race");
			this.ethnicityDrpdown.sendKeys(Keys.TAB);
			return true;
		}catch(Exception e){
			err.logError("UpdateDemographics", "Unable to edit Race field due to"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:updateEthnicity
	 * #Description: This functionality updates the Ethnicity value in UpdateDemographics page.
	 * #Argument:Ethnicity
	 * Type:Textbox 
	 */
	public boolean updateEthnicity(String args[]){
		try{
			action.moveToElement(this.ethnicityDrpdown).click().sendKeys(selectAll,Keys.DELETE).build().perform();
			utils.enterTextinAnelemnt(this.ethnicityDrpdown, args[0], "UpdateDemographics", "Ethnicity");
			this.ethnicityDrpdown.sendKeys(Keys.TAB);
			return true;
		}catch(Exception e){
			err.logError("UpdateDemographics", "Unable to edit Ethnicity field due to"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:clickOnUpdate
	 * #Description: This functionality clicks on update button in UpdateDemographics page.
	 * Type:Textbox 
	 */
	public boolean clickOnUpdate(){
		return utils.clickAnelemnt(this.btnUpdate,"UpdateDemographics", "Update Button");
	}
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:verifyMessageOnUpdate
	 * #Description: This functionality verifies the message being displayed after user clicks on update button in UpdateDemographics page.
	 * Type:Textbox 
	 */
	public boolean verifyMessageOnUpdate(){

		try{
			String successMsg = "Race and ethnicity updated successfully. NOTE: This Race and Ethnicity change will not be immediately displayed under the Demographic Update and Member Composite.";
			String failureMsg = "System Error -  Race and Ethnicity cannot be updated, due to technical reason. Note: Open a \"\"Promised Action\" and create a task reminder to attempt to update Race and Ethnicity at a later time.";
			System.out.println(successMsg);
			String actualMsg = msgText.getText().trim().replaceAll("\n"," ");
			System.out.println(actualMsg);
			if(actualMsg.equalsIgnoreCase(successMsg)){
				blogger.loginfo("Message is verified successfully");
				return true;
			}else if(actualMsg.equalsIgnoreCase(failureMsg)){
				blogger.loginfo(this.msgText.getText().trim() +"is displayed");
				return true;
			}else {
				blogger.loginfo("Message is not displayed");
				return false;
			}
		}catch(Exception e){
			err.logError("UpdateDemographics", "Unable to verifyMessageOnUpdate due to"+e);
			return false;
		}
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:navigateToMemberMaintenance
	 * #Description:This functionality navigates user back to Member Maintenance page.
	 * Type:Textbox 
	 */
	public boolean 	navigateToMemberMaintenance()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "UpdateDemographics", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOtherMemberMaintenance, "UpdateDemographics", "Member Maintenance");
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:selectMemberToUpdate
	 * #Description: This functionality selects the desired member value in UpdateDemographics page.
	 * #Argument:MemberFullName
	 * Type:Textbox 
	 */
	public boolean selectMemberToUpdate(String args[]){
		try{
			utils.waitforpageload();
			Driver.pgDriver.findElement(By.xpath("//span[text()='"+args[0]+"']//ancestor::td[@headers='a3']//preceding-sibling::td//input[@type='checkbox']")).click();
			return true;
		}catch(Exception e){
			err.logError("selectMemberToUpdate", "Unable to select member checkbox"+ args[0] +"due to "+ e);
			return false;
		}
	}

	BaseLogger blogger = new BaseLogger();
	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyMemberDependantIsDisabled
	 * #Description: This functionality verifies the desired member value is disabled in UpdateDemographics page.
	 * #Argument:MemberDependant
	 * Type:Textbox 
	 */
	public boolean verifyMemberDependantIsDisabled(String args[]){
		utils.waitforpageload();
		try{
			String value = Driver.pgDriver.findElement(By.xpath("//span[text()='"+args[0]+"']//ancestor::td[@headers='a3']//preceding-sibling::td//input[@type='checkbox']")).getAttribute("disabled");
			if(value.equalsIgnoreCase("true")){
				blogger.loginfo("Checkbox is disabled for the member:"+ args[0]);
				return true;
			}else{
				err.logError("verifyMemberDependantIsDisabled", "Checkbox is enabled for the member:"+ args[0]);
				return false;				
			}
		}catch(Exception e){
			err.logError("verifyMemberDependantIsDisabled", "Unable to retrieve the entered the member name"+ args[0] +"due to "+ e);
			return false;
		}
	}

	@FindBy(id="CareOf")
	WebElement InCareOfValue;

	@FindBy(id="AddressLine1")
	WebElement AddressLine1;

	@FindBy(id="pyCity")
	WebElement CityValue;

	@FindBy(id="pyState")
	WebElement StateDropdown;

	@FindBy(id="pyPostalCode")
	WebElement ZipCodeValue;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:updateAddress
	 * #Description:This functionality updates the address for a member in Update Demographics.
	 * #Arguments:ToUpdateAddress
	 * Type:Table
	 * Keys:In Care Of#Address#City#State#Zip Code
	 */
	public boolean updateAddress(String args[])
	{
		boolean returnvar =true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("updateAddress", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.contains("In Care Of")){			
				returnvar=true;
				action.moveToElement(this.InCareOfValue).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.InCareOfValue, value, "UpdateDemographics", "In Care Of");				
				continue;

			}else if(key.contains("Address")){
				returnvar=true;
				action.moveToElement(this.AddressLine1).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.AddressLine1, value, "UpdateDemographics", "Address Line 1");		
				continue;

			}else if(key.contains("City")){
				returnvar=true;
				action.moveToElement(this.CityValue).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.CityValue, value, "UpdateDemographics", "City");		
				continue;

			}else if(key.contains("State")){
				returnvar=true;
				utils.selectDropDownbyVisibleString(this.StateDropdown, value, "UpdateDemographics", "State");		
				continue;

			}else if(key.contains("Zip Code")){
				returnvar=true;
				action.moveToElement(this.ZipCodeValue).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.ZipCodeValue, value, "UpdateDemographics", "Zip Code");		
				continue;
			}else{
				err.logcommonMethodError("UpdateDemographics", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		return true;
	}

	@FindBy(id="PhoneNumber")
	WebElement PhoneNumberTxt;

	@FindBy(id="PhoneNumberExt")
	WebElement ExtTxt;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:updatePhoneNumber
	 * #Description:This functionality updates the phone number and extension for a member in Update Demographics.
	 * #Arguments:ToUpdatePhone
	 * Type:Table
	 * Keys:Phone#Ext
	 */
	public boolean updatePhoneNumber(String args[])
	{
		boolean returnvar =true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("updatePhoneNumber", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.contains("Phone")){			
				returnvar=true;
				action.moveToElement(this.PhoneNumberTxt).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.PhoneNumberTxt, value, "UpdateDemographics", "Phone Number");				
				continue;

			}else if(key.contains("Ext")){
				returnvar=true;
				action.moveToElement(this.ExtTxt).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.ExtTxt, value, "UpdateDemographics", "Phone Number Extension");		
				continue;

			}else{
				err.logcommonMethodError("UpdateDemographics", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}
		return true;
	}

	@FindBy(xpath="//*[contains(text(),'Address update failed')]")
	WebElement errorMessaage;

	@FindBy(xpath="//*[contains(text(),'Address updated successfully')]")
	WebElement successMessaage;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:verifyAddressUpdateMessage
	 * #Description: This functionality verifies the message being displayed after user clicks on update button in UpdateDemographics page.
	 * Type:Textbox 
	 */
	public boolean verifyAddressUpdateMessage(){
		utils.waitforpageload();
		String successMsg = "Address updated successfully. NOTE : This address/phone number will not be displayed under the Demographic Update.";
		String techError="Address update failed due to technical reason";
		try{
			if(successMessaage.isDisplayed())
			{
				blogger.loginfo(successMessaage.getText()+"is displayed");
				if(utils.isvalueMatch_compareto(successMessaage.getText().replaceAll("\n", ""), successMsg));
				System.out.println(this.successMessaage.getText().trim() +" is displayed");
				return true;
			}
			else if(errorMessaage.isDisplayed()){
				blogger.loginfo(errorMessaage.getText()+"is displayed");
				if(utils.isvalueMatch_compareto(errorMessaage.getText(), techError))
					System.out.println(errorMessaage.getText().trim() +" is displayed");
				return false;
			}
		}catch(Exception e){

			if(errorMessaage.isDisplayed()){
				blogger.loginfo(errorMessaage.getText()+"is displayed");
				System.out.println(errorMessaage.getText().trim() +" is displayed");
				return true;
			}
			else{
				err.logError(this.addressUpdateTxtFailure.getText().trim());
				err.logError("UpdateDemographics", "Unable to verifyAddressUpdateMessage due to 'Address update failed due to Exception'"+e);
				return false;
			}
		}
		return false;
	}

	@FindBy(xpath="//p//span//em")
	List<WebElement> cantUpdateText;
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:verifyPhoneAndFaxCannotBeUpdatedMessage
	 * #Description: This method verifies the message that phone and fax number cannot be updated by direct employer in UpdateDemographics page.
	 * Type:Textbox 
	 */
	public boolean verifyPhoneAndFaxCannotBeUpdatedMessage(){
		String cannotUpdateText1 = "The phone number cannot be updated directly by the member.";
		String cannotUpdateText2 = "Advise member to  update their phone number with their employer.";
		try{
			if(this.cantUpdateText.get(0).getText().trim().equalsIgnoreCase(cannotUpdateText1) && (this.cantUpdateText.get(1).getText().trim().equalsIgnoreCase(cannotUpdateText2))){
				System.out.println(this.cantUpdateText.get(0).getText().trim() +" is displayed");
				System.out.println(this.cantUpdateText.get(1).getText().trim() +" is displayed");
				return true;
			}else{
				err.logError(this.cantUpdateText.get(0).getText().trim() +" is displayed");
				err.logError(this.cantUpdateText.get(1).getText().trim() +" is displayed");
				return false;
			}
		}catch(Exception e){
			err.logError("UpdateDemographics", "Unable to verifyPhoneAndFaxCannotBeUpdatedMessage isnt displayed"+e);
			return false;
		}
	}
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement BtnSubmit;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:clickOnSubmit
	 * #Description: This method clicks on submit button in UpdateDemographics page.
	 * Type:Textbox 
	 */
	public boolean clickOnSubmit() throws InterruptedException
	{
		Thread.sleep(5000);
		return utils.clickAnelemnt(this.BtnSubmit, "UpdateDemographics", "Button to click Submit");
	}

	@FindBy(xpath="//label[@data-test-id='20170410140140057787842-Label']")
	WebElement changeAddrForRequestingIDCard;
	@FindBy(id="AddressChangeYes")
	WebElement addressChangeYesRdo;
	@FindBy(id="AddressChangeNo")
	WebElement addressChangeNoRdo;

	@FindBy(xpath="//input[@id='AddressChangeYes'][@pn='.AddressChange']")
	WebElement addressChangeYesRdoChecked;
	@FindBy(xpath="//input[@id='AddressChangeNo'][@pn='.AddressChange']")
	WebElement addressChangeNoRdoChecked;

	/*
	 * @SCU
	 * #CommonMethodWithArgument:changeAddressForRequestingIDCard
	 * #Description:This method allows the user to select - Do you need to change address for requesting ID Card in UpdateDemographics page.
	 * #Arguments:ChangeAddress
	 * Type:Textbox 
	 */
	public boolean changeAddressForRequestingIDCard(String args[])
	{
		wait.until(ExpectedConditions.visibilityOf(this.changeAddrForRequestingIDCard));
		if(args[0].equalsIgnoreCase("Yes")){
			return utils.clickAnelemnt(this.addressChangeYesRdo, "changeAddressForRequestingIDCard", "Do you need to change address for requesting ID Card - Yes");
		}else{
			return utils.clickAnelemnt(this.addressChangeNoRdo, "changeAddressForRequestingIDCard", "Do you need to change address for requesting ID Card - No");
		}
	}

	@FindBy(xpath="//div[@swp='.AddressChange']//b")
	List<WebElement> addressChangeMsg;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:verifyUseOtherActionsMsg
	 * #Description:This method verifies the message 'Use Other Actions - Request Update Demographics to send an address change request' in UpdateDemographics page.
	 * Type:Textbox 
	 */
	public boolean verifyUseOtherActionsMsg()
	{
		String useOtherActionMsg = "Use Other Actions - Request Update Demographics to send an address change request";
		String updateAddrThruEmployer = "Remind member to update address through their employer.";
		utils.waitforpageload();
		if(this.addressChangeMsg.get(0).getText().trim().equalsIgnoreCase(useOtherActionMsg) && this.addressChangeYesRdoChecked.isDisplayed()){
			return true;
		}else if(this.addressChangeMsg.get(1).getText().trim().equalsIgnoreCase(updateAddrThruEmployer) && this.addressChangeNoRdoChecked.isDisplayed()){
			return true;
		}else{
			err.logError(" -verifyUseOtherActionsMsg isnt displayed in UpdateDemographics page- ");
			return false;
		}
	}
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Update Demographi...']")	
	private WebElement lnkOtherRequestUpdateDemographics;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeader;

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:clickOtherActionsRequestUpdateDemographics
	 * #Description:This method clicks on Other Actions and select 'Request Update Demographics'
	 * Type:Textbox 
	 */
	public boolean clickOtherActionsRequestUpdateDemographics()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "UpdateDemographics", "Other Actions button"))
		{

			if(utils.clickAnelemnt(this.lnkOtherRequestUpdateDemographics, "UpdateDemographics", "Request Update Demographics"))
			{
				utils.waitforpageload();
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement);
				if(utils.validateHeader(this.sHeader,"Request Update Demographics"))
					return true;
			}
		}
		return false;
	}

	@FindBy(xpath="//div[@id='$PpyWorkPage$pDemographicUpdate$ppyPostalCodeError']//span")
	WebElement errMsgZipCode;
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:verifyZipCodeValidation
	 * #Description: This functionality verifies the zip code validation to accept 5 digits and is not empty.
	 * Type:Textbox 
	 */
	public boolean verifyZipCodeValidation(){
		utils.waitforpageload();
		String blankZipCodeMsg="Value cannot be blank";
		String lessZipCodeMsg="** Must be a 5-digit numeric value.";
		try{
			String zipCode =this.ZipCodeValue.getAttribute("maxlength").toString();
			int zipCodeActLength =this.ZipCodeValue.getAttribute("value").trim().length();
			if(zipCodeActLength==0){
				if(this.errMsgZipCode.getText().trim().equalsIgnoreCase(blankZipCodeMsg)){
					blogger.loginfo("Zip Code entered is blank");
					return true;
				}else{
					err.logError("verifyZipCodeValidation", "Zip code being blank - doesnt match the expected validation message"+blankZipCodeMsg);
					return false;
				}
			}else if(zipCodeActLength<Integer.parseInt(zipCode)){
				if(this.errMsgZipCode.getText().trim().equalsIgnoreCase(lessZipCodeMsg)){
					blogger.loginfo("Zip Code entered is less than 5 digits:"+zipCodeActLength);
					return true;
				}else{
					err.logError("verifyZipCodeValidation", "Zip code entered is less than 5 digits - doesnt match the expected validation message"+lessZipCodeMsg);
					return false;
				}
			}else if(zipCodeActLength==Integer.parseInt(zipCode)){
				blogger.loginfo("Zip Code entered is 5 digits:"+this.ZipCodeValue.getText().trim());
				return true;
			}else{
				err.logError("Zip Code entered is greater than 5 digits:"+this.ZipCodeValue.getText().trim());
				return false;
			}
		}catch(Exception e){
			err.logError("verifyZipCodeValidation", "Error in retrieving zipcode due to "+ e);
			return false;
		}
	}

	/**Update Address and validate the success message
	 * 
	 * @param args
	 * @return
	 */
	public boolean updateAddressAndValidate(String args[])
	{
		boolean returnvar =true;
		for(String iterator : args)
		{
			String keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("updateAddress", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(key.contains("In Care Of")){			
				returnvar=true;
				action.moveToElement(this.InCareOfValue).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.InCareOfValue, value, "UpdateDemographics", "In Care Of");				
				continue;

			}else if(key.contains("Address")){
				returnvar=true;
				action.moveToElement(this.AddressLine1).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.AddressLine1, value, "UpdateDemographics", "Address Line 1");		
				continue;

			}else if(key.contains("City")){
				returnvar=true;
				action.moveToElement(this.CityValue).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.CityValue, value, "UpdateDemographics", "City");		
				continue;

			}else if(key.contains("State")){
				returnvar=true;
				utils.selectDropDownbyVisibleString(this.StateDropdown, value, "UpdateDemographics", "State");		
				continue;

			}else if(key.contains("Zip Code")){
				returnvar=true;
				action.moveToElement(this.ZipCodeValue).click().sendKeys(selectAll,Keys.DELETE).build().perform();
				utils.enterTextinAnelemnt(this.ZipCodeValue, value, "UpdateDemographics", "Zip Code");		
				continue;
			}else{
				err.logcommonMethodError("UpdateDemographics", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}
		}

		if(clickOnUpdate()) {
			if(returnvar && verifyAddressUpdateMessage())
				return true;
		}
		return false;
	}

}
