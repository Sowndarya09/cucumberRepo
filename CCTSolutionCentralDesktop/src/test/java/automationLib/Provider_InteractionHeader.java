package automationLib;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

public class Provider_InteractionHeader extends Driver {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	public Provider_InteractionHeader()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
	}
	
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(xpath="//img[contains(@src, 'happyinteraction')]")
	WebElement imageInteractionHeaderSmiley;
	
	@FindBy(xpath="//*[@data-test-id='201509171111100835311891']")
	WebElement labelInteractionHeaderProviderfullname;
	
	@FindBy(xpath="//*[@data-test-id='201509180929400234553780']")
	WebElement labelInteractionHeaderProviderID;
	
	@FindBy(xpath="//label[@for='HCIDDisplay']//following-sibling::div//span[@data-test-id='201509180929400234553780']")
	WebElement labelInteractionHeaderMemberName;
	
	@FindBy(xpath="//label[@for='HCIDDisplay']/following::span[@data-test-id='201509180929400234553780']")
	WebElement labelInteractionHeaderMemberId;
	
	@FindBy(xpath="//*[@data-test-id='201509171111100835312438']")
	WebElement labelInteractionHeaderAge;
	
	@FindBy(xpath="//div[@node_name='CPMInteractionHeader']//a[text()='Disclosure Matrix']")
	WebElement lnktextInteractionHeaderDisclosureMatrixLink;
	
	@FindBy(className="PrivacyAlertColor")
	WebElement lnktextInteractionHeaderPrivacyAlert;
	
	@FindBy(xpath="//div[@node_name='CPMInteractionHeader'][text()='Unable to retrieve data. Please try again or contact your system administrator.']")
	WebElement labelInteractionHeaderunabletoretrieve;
		
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Refresh']")
	WebElement btnInteractionHeaderRefresh;
	
	@FindBy(xpath="//div[@node_name='CPMInteractionHeader']//label[@for='MemberPhoneNumber']/parent::div//span")
	WebElement labelInteractionHeaderphone;
	
	@FindBy(xpath="//*[@data-test-id='201509180925340197147539-Label']/../*[@class='field-item dataValueRead']")
	WebElement labelInteractionHeaderLastInteractionDate;
	
	@FindBy(id="CallBackNumber")
	WebElement txtbxInteractionHeaderCallbackNumber;
	
	@FindBy(id="Nickname")
	WebElement txtbxInteractionHeaderNickName;
	
	@FindBy(id="CallBackNumExt")
	WebElement txtbxInteractionHeaderCallBackExtension;
	
	@FindBy(xpath="//img[contains(@data-hover,'ActiveCIRSRecord')]")
	WebElement imgInteractionHeaderprivacyalerticon;

	@FindBy(xpath="//div[@node_name='CPMInteractionHeader']//label[@for='pyID']/parent::div//span")
	WebElement getReviewInteractionID;

	@FindBy(xpath="//label[@for='PolicyState']/following-sibling::div/span")
	WebElement policyState;
	
	public boolean verifyInteractionHeader(String[] iDetails) throws Exception
	 {
		boolean returnvar ;
		returnvar = true;
		
		Thread.sleep(2000); //StaleElement Exception
		//wait.until(ExpectedConditions.visibilityOf(this.labelInteractionHeaderProviderfullname));
			for(String iterator : iDetails)
			{
				String keyvaluepair = iterator;
				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;
				
				}
				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
				System.out.println("key " + key + "value  " + value);
				
				if(key.toLowerCase().contains("provider name")){
					returnvar=utils.validateValueinelement(this.labelInteractionHeaderProviderfullname, value);
				continue;}
				else if(key.toLowerCase().contains("provider id")){
					returnvar=utils.validateValueinelement(this.labelInteractionHeaderProviderID, value);
				continue;}
				else if(key.toLowerCase().contains("member name")){
					returnvar=utils.validateValueinelement(this.labelInteractionHeaderMemberName, value);
				continue;}
				
				else if(key.toLowerCase().contains("member id")){
					returnvar=utils.validateValueinelement(this.labelInteractionHeaderMemberId, value);
				continue;}
				
				
				else if(key.toLowerCase().contains("age")){
					returnvar=utils.validateValueinelement(this.labelInteractionHeaderAge, value);
				continue;
				}
				else if(key.toLowerCase().contains("lastinteraction")){
					returnvar=utils.validateValueinelement(this.labelInteractionHeaderLastInteractionDate, value);
					
				continue;
				}
				else if(key.toLowerCase().contains("phone")){
					returnvar=utils.isvalueMatch_contain(this.labelInteractionHeaderphone.getAttribute("value").toLowerCase(), value.toLowerCase());
				continue;
				}
				else if(key.toLowerCase().contains("nickname")){
					String text=this.txtbxInteractionHeaderNickName.getAttribute("value");
					returnvar=utils.isvalueMatch_contain(text.toLowerCase(), value.toLowerCase());
				continue;
				}
				else if(key.toLowerCase().contains("callbacknumber")){
					System.out.println(this.txtbxInteractionHeaderCallbackNumber.getAttribute("value"));
					returnvar=utils.isvalueMatch_contain(this.txtbxInteractionHeaderCallbackNumber.getAttribute("value").toLowerCase(), value.toLowerCase());
				continue;
				}
				else if(key.toLowerCase().contains("callbackextension")){
					returnvar=utils.isvalueMatch_contain(this.txtbxInteractionHeaderCallBackExtension.getAttribute("value").toLowerCase(), value.toLowerCase());
				continue;
				}
				else if(key.toLowerCase().contains("policy based out of")){
					//System.out.println(this.policyState.getAttribute("value").toLowerCase());
					returnvar=utils.validateLabel(policyState, value);
				continue;
				} 
				
				
				else 
					err.logcommonMethodError("Interaction Header", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				    return false;
				
				
			}
					
		
		
		
		if(returnvar)
		{
			System.out.println("Interaction Header Details checked successfully");
           return true;	
		}
		else
		{
			int tot_i=iDetails.length;
			err.logcommonMethodError("Interaction Header", "the value "+iDetails[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
		
	
		
		
	    
	 }
	
	public String getInteractionID()
	{
		try{
		if(this.getReviewInteractionID.isDisplayed())
		{
		
			System.out.println("Interaction ID is displayed ");
		}
		String id=this.getReviewInteractionID.getText().trim();
		return id;
		}
		catch(Exception e)
		{
			if(this.getReviewInteractionID.isDisplayed())
			{
				System.out.println("Interaction ID is displayed ( catch block: exception handled)");
			}
			String id=this.getReviewInteractionID.getText().trim();
			return id;
		}
	}
	
	public String getProviderName()
	{
		if(this.labelInteractionHeaderProviderfullname.isDisplayed())
		{
			System.out.println("Member Info is checked");
		}
		String name=this.labelInteractionHeaderProviderfullname.getText().trim();
		return name;
	}
	
	public String getUserName()
	{
		if(this.labelInteractionHeaderProviderfullname.isDisplayed())
		{
			System.out.println("Member Info is checked");
		}
		String name=this.labelInteractionHeaderProviderfullname.getText().trim();
		return name;
	}
	
	@FindBy(xpath="//*[@data-test-id='20150113070710091218785']")
	private WebElement contactname;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyContact
	 * #Description:verifys contact field in review interaction page
	 * Type:TextBox
	 */
	
	public boolean verifyContact() throws Exception
	{	
	return utils.validateValueinelement(this.contactname, "Nickname");	
	}
	
	/*
	 * @SCU
	 * #CommonMethodwithArgument:createNewAlert
	 * #Description:verifys contact field in review interaction page
	 * #Arguments:arg
	 * Type:TextBox
	 */

	public boolean verifyContact(String[] arg) throws Exception
	{	
	return utils.validateValueinelement(this.contactname, arg[0]);	
	}
	
	@FindBy(xpath="//*[@data-test-id='2014111304463909631305']")
	WebElement TabValue;
	
	public boolean verifyProviderTabName(String[] args) {
		utils.waitforpageload();
		return utils.isvalueMatch_compareto(TabValue.getText(), args[0]);
	}
	
	@FindBy(xpath="//*[@class='header-title']")
	WebElement ContactInformation;
	
	@FindBy(xpath="//*[text()='Contact Type']")
	WebElement ContactType;

	
	
	public boolean displayContactInformation() {
		return utils.validateLabel(ContactInformation, "Contact Information");
	}
	
	public boolean displayContactType() {
		return !utils.isProxyWebelement(ContactType);
	}
	
	/*Code for validating the message alert*/
	
	@FindBy(xpath="//img[@data-test-id='2017050118070204956744']")
	WebElement hvrMessageAlert;
	
	public boolean validateMessageAlertHover(String[] args)
	{
		Actions action = new Actions(Driver.getPgDriver());
		action.moveToElement(hvrMessageAlert).build().perform();
		
		String actualValue = hvrMessageAlert.getAttribute("aria-label");
		return utils.isvalueMatch_contain(actualValue, args[0]);
	}
	
	/*Clicking on Message Alert*/
	
	Set<String> windowHandles;
	List<String> convertToList = new ArrayList<String>();
	
	
	@FindBy(xpath="//a[@data-test-id='2017050116522603052310'][text()='Message Alerts']")
	WebElement lnkMessageAlert;
	
	@FindBy(xpath="//table[@pl_prop='pgRepPgSubSectionDisplayMessageAlertsBB.pxResults']")
	WebElement tblActive;
	
	@FindBy(xpath="//table[@pl_prop='pgRepPgSubSectionDisplayMessageAlertsBBBB.pxResults']")
	WebElement tblInactivective;
	
	@FindBy(xpath="//span[text()='Inactive Alerts']")
	WebElement expndInactive;
	
	
	public boolean validateMessageAlert(String[] args) throws InterruptedException 
	{
		String values = args[0].replaceAll("<", "").replaceAll(">", "");
		String[] value = values.split(";");
		System.out.println(value[0]);
		System.out.println(value[1]);
		if(utils.clickAnelemnt(lnkMessageAlert, "Composite page", "Message Alert"))
		{
		Thread.sleep(2000);
		windowHandles = Driver.getPgDriver().getWindowHandles();
		convertToList.addAll(windowHandles);
		Driver.getPgDriver().switchTo().window(convertToList.get(1));
		String array = value[0].replaceAll("%", ",");
		String[] arr1 = array.split(",");
		
		String array1 = value[1].replaceAll("%", ",");
		String[] arr2 = array1.split(",");
		
		if(utils.validatetablerowbasedonvalues(tblActive, arr1))
			if(utils.clickAnelemnt(expndInactive, "alerts", "Inactivealerts"))
				if(utils.validatetablerowbasedonvalues(tblInactivective, arr2))
				{
					Driver.getPgDriver().close();
					Driver.getPgDriver().switchTo().window(convertToList.get(0));
				}
				return true;
		}return false;
				
		
	}
	
	//Code for validating the display of Privacy Alert in Provider Interaction Header
	
	@FindBy(xpath="//label[@data-test-id='20160309172148043429830-Label']")
	WebElement privacyAlert;
	
	public boolean validatePrivacyAlert()
	{
		return(!utils.isProxyWebelement(privacyAlert));
	}
	
	//Code for validating the display of Message Alert in Provider Interaction Header
	
	public boolean validateMessageAlertIsDisplayed()
	{
		return(!utils.isProxyWebelement(lnkMessageAlert));
	}
		
	//Code for validating the display of Informational Alert in Provider Interaction Header
		
	@FindBy(xpath="//a[@data-test-id='2016021609070306584948']")
	WebElement informationalAlert;
		
	public boolean validateInformationalAlertIsDisplayed()
	{
		return(!utils.isProxyWebelement(informationalAlert));
	}
	
	
	

/*	public boolean validateActiveMessageAlertPopup(String[] args)
	{
		Driver.getPgDriver().switchTo().window(convertToList.get(1));
		if(utils.validatetablerowbasedonvalues(tblActive, args[0])) {
			Driver.getPgDriver().switchTo().window(convertToList.get(0));
			return true;
		}
		else {
			return false;}
		}
	
	public boolean validateInactiveMessageAlertPopup(String[] args)
	{
		Driver.getPgDriver().switchTo().window(convertToList.get(1));
		if(utils.clickAnelemnt(expndInactive, "alerts", "Inactivealerts"))
		if(utils.validatetablerowbasedonvalues(tblInactivective, args[0])) {
			Driver.getPgDriver().switchTo().window(convertToList.get(0));
			return true;
		}
		return false;
		
		}*/
}
	

	
	

	
	
