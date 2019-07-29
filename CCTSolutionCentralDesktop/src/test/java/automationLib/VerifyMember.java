package automationLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class  VerifyMember extends Driver {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();


	Actions action=new Actions(Driver.pgDriver);
	public VerifyMember()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	//Objects .....................

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;


	@FindBy(className="anthem_theme_header")
	WebElement titleVerificationPageName;

	@FindBy(id= "Nickname")
	WebElement txtbxVerificationNickname;

	@FindBy(id ="CallBackNumber")
	WebElement txtbxVerificationCallbacknumber;

	@FindBy(id="CallBackNumExt")
	WebElement txtbxVerificationCallbackextension;

	//@FindBy(id="IsMemberNameVerified")
	@FindBy(xpath="//*[@data-test-id='201504281329080300410216' or @id='IsMemberNameVerified']")
	WebElement chkbxVerificationMembernameverify;

	@FindBy(id="IsMemberIDVerified")
	WebElement chkbxVerificationMemberidverify;
	//div[contains(text(),'Be patient')]
	@FindBy(id="IsDateOfBirthVerified")
	WebElement chkbxVerificationMemberDOB;

	@FindBy(id="IsSSNVerified")
	WebElement chkbxVerificationMemberSSN;

	@FindBy(id="IsAddressVerified")
	WebElement chkbxVerificationMemberaddress;

	@FindBy(id="IsPhoneNumberVerified")
	WebElement chkbxVerificationMemberphone;

	@FindBy(id="IsPCPNameVerified")
	WebElement chkbxVerificationMemberPCP;

	@FindBy(id="VerifiedMemberDelegatedContact")
	WebElement chkbxVerificationMemberverified;

	@FindBy(id="AssociatedContactName")
	WebElement txtbxVerificationContactname;

	@FindBy(id="AssociatedContactType")
	WebElement txtbxVerificationContacttype;

	@FindBy(id="ContinueValidation")
	WebElement chkbxVerificationContinuewoverify;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnVerificationSubmit;

	@FindBy(id="submitButton")
	WebElement btnVerificationSubmitForEmail;

	@FindBy(id="ModalButtonSubmit")
	WebElement btnMemberCompositeSubmit;

	@FindBy(xpath="//img[contains(text(),'Open CIRS')]")
	WebElement linkVerificationOpenCIRSlink;

	@FindBy(id="IsAnyActiveRecordPresentNo")
	WebElement radioVerificationNoActiveRecords;

	@FindBy(id="IsAnyActiveRecordPresentYes")
	WebElement radioVerificationActiveRecordsPresent;

	@FindBy(id="IsActiveConfidentialCommunicationYes")
	WebElement radioVerificationConfidentialCommunicationYes;

	@FindBy(id="IsActiveConfidentialCommunicationNo")
	WebElement radioVerificationConfidentialCommunicationNo;

	@FindBy(id="IsConfPasswordCorrectNo")
	WebElement RadioVerificationRequestCorrectPasswordYes;

	@FindBy(id="IsConfPasswordCorrectNo")
	WebElement RadioVerificationRequestCorrectPasswordNo;

	@FindBy(id="IsPasswordHintProvidedYes")
	WebElement RadioVerificationSupplyCorrectPasswordYes;

	@FindBy(id="IsPasswordHintProvidedNo")
	WebElement RadioVerificationSupplyCorrectPasswordNo;

	@FindBy(id="IsPasswordHintProvidedNo")
	WebElement RadioVerificationPasswordHintNo;

	@FindBy(id="IsCIRSRecordActiveAndSensitiveNo")
	WebElement RadioVerificationSensitiveServicesNo;

	@FindBy(id="IsThereAnAuthorizedRepRecordYes")
	WebElement RadioVerificationactiveAuthorizedrepresentativeYes;

	@FindBy(id="IsTheContactListedAsAuthRepYes")
	WebElement RadioVerificationContactListedAuthorizedrepresentativeYes;

	//@FindBy(xpath="//label[@for='pyFullName']/parent::div//span")
	@FindBy(xpath="//*[@data-test-id='2015042812583202823964']")
	WebElement labelVerificationfullname;

	@FindBy(id="HasPHIPermissionYes")
	WebElement radioDiscloseYes;

	@FindBy(id="HasPHIPermissionNo")
	WebElement radioDiscloseNo;

	@FindBy(id="HasPHIPermissionContinue Interaction with Member")
	WebElement radioDisclosecontinue;


	//@FindBy(xpath="//label[@for='HCID']/parent::div//span")
	@FindBy(xpath="//*[@data-test-id='201504281304350457121267']")
	WebElement labelVerificationID;

	//@FindBy(xpath="//label[@for='DateOfBirth']/parent::div//span")
	@FindBy(xpath="//*[@data-test-id='201504281304350458122377']")
	WebElement labelVerificationDOB;

	@FindBy(xpath="//label[@for='MemberPhoneNumber']/parent::div/div")
	WebElement labelVerificationphone;

	@FindBy(xpath="//label[@for='SSN']/parent::div/div")
	WebElement labelVerificationSSN;

	@FindBy(xpath="//label[@for='ParticipatingProvider']/parent::div//span")
	WebElement labelVerificationpcp;

	//@FindBy(xpath="//label[@for='MemberAddress']/parent::div//span")
	@FindBy(xpath="//*[@data-test-id='2015042815070504775471']")
	WebElement labelVerificationaddress;

	@FindBy(id="ContinueValidationReasons")
	WebElement dropdownVerificationcannotverifyreason;


	@FindBy(xpath="//label[@for='HasPHIPermission']//span")
	WebElement labelpermissiontodisclose;
	//@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;


	@FindBy (xpath="//*[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement lnkOtherActionExitInteraction;

	@FindBy (xpath="//img[@src='webwb/tool_icon_13690228252.png!!.png']")	
	private WebElement btnImgTool;

	//dialog content used for making sure we are on the correct page

	@FindBy(id="DialogContent")
	WebElement verifyMemberdialogContent;

	@FindBy(id="IsMemberAvailableToSpeakWithNo")
	WebElement radioVerifyMemberisnotAvailable;

	@FindBy(id="IsMemberAvailableToSpeakWithYes")
	WebElement radioVerifyMemberisAvailable;

	@FindBy(id="IsAnyActiveRecordPresentYes")
	WebElement radioVerifyMemberisActiverecordPresent;
	// Tool Mark 
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;
	//getters .....................

	//close button after clicking on configration tools
	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Close')]")
	private WebElement btncloseConfigurationTool;

	//QUESTION-HIPAAA-------------------------------------------------------------------

	@FindBy(xpath="//span[@class='iconRequired standard_iconRequired'][contains(text(),'active records')]")
	WebElement questionactiverecord;

	@FindBy(xpath="//span[@class='iconRequired standard_iconRequired'][contains(text(),'confidential communication record')]")
	WebElement questionconfidentialcommunication;

	@FindBy(xpath="//label[@for='IsConfPasswordCorrect']//span[contains(text(),'supply the correct password')]")
	WebElement questionpassword;

	@FindBy(xpath="//label[@for='IsPasswordHintProvided']//span[contains(text(),'supply the correct password')]")
	WebElement questionpasswordhint;

	@FindBy(xpath="//label[@for='IsCIRSRecordActiveAndSensitive']//span[contains(text(),'active sensitive')]")
	WebElement questionactivesensitive;

	@FindBy(xpath="//label[@for='IsThereAnAuthorizedRepRecord']//span[contains(text(),'active authorized')]")
	WebElement questionactiveauthorized;

	@FindBy(xpath="//label[@for='IsTheContactListedAsAuthRep']//span[contains(text(),'contact listed')]")
	WebElement questioncontactlistedactivesensitive;

	//FROM GUEST CONTACT PAGE

	@FindBy(xpath="//label[@for='AssociatedContactName']/parent::div/span")
	WebElement labelVerifyMemberContactName;

	@FindBy(xpath="//label[@for='SelectedContactType']/parent::div/span")
	WebElement labelVerifyMemberContactType;
	private WebElement txtbxVerificationEmailID;



	public WebElement gettitleVerificationPageName()
	{
		return titleVerificationPageName;

	}
	public WebElement gettxtbxVerificationNickname()
	{
		return txtbxVerificationNickname;

	}

	public WebElement gettxtbxVerificationCallbacknumber()
	{
		return txtbxVerificationCallbacknumber;
	}

	public WebElement gettxtbxVerificationCallbackextension()
	{
		return txtbxVerificationCallbackextension;
	}
	public WebElement getchkbxVerificationMembernameverify()
	{
		return chkbxVerificationMembernameverify;

	}
	public WebElement getchkbxVerificationMemberidverify()
	{
		return chkbxVerificationMemberidverify;
	}
	public WebElement getchkbxVerificationMemberDOB()
	{
		return chkbxVerificationMemberDOB;
	}
	public WebElement getchkbxVerificationMemberaddress()
	{
		return chkbxVerificationMemberaddress;
	}
	public WebElement getchkbxVerificationMemberphone()
	{
		return chkbxVerificationMemberphone;
	}

	public WebElement getchkbxVerificationMemberverified()
	{
		return chkbxVerificationMemberverified;
	}

	public WebElement gettxtbxVerificationContactname()
	{
		return txtbxVerificationContactname;
	}

	public WebElement gettxtbxVerificationContacttype()
	{
		return txtbxVerificationContacttype;
	}

	public WebElement getchkbxVerificationContinuewoverify()
	{
		return chkbxVerificationContinuewoverify;
	}

	public WebElement getbtnVerificationSubmit()
	{
		return btnVerificationSubmit;
	}



	public WebElement getlinkVerificationOpenCIRSlink()
	{
		return linkVerificationOpenCIRSlink ;

	}

	public WebElement getradioVerificationNoActiveRecords()
	{
		return radioVerificationNoActiveRecords;

	}

	public WebElement getradioVerificationActiveRecordsPresent()
	{
		return radioVerificationActiveRecordsPresent;

	}


	public WebElement getBtnOtherActions() {
		return btnOtherActions;
	}
	/// seter--------------------

	public boolean settxtbxVerificationNickname (String [] args){

		return (utils.enterTextinAnelemnt(this.txtbxVerificationNickname, "nickname", "MemberVerify", "Nickname textbox"));

	}

	public boolean settxtbxVerificationCallbacknumber (String [] args){

		return (utils.enterTextinAnelemnt(this.txtbxVerificationCallbacknumber, "phoneno", "MemberVerify", "CallBack number textbox"));

	}

	public boolean clickchkbxVerificationMembernameverify(String[] membername) {

		this.verifymemberName(membername);
		return (utils.clickAnelemnt(this.chkbxVerificationMembernameverify, "MemberVerify", "Member name verify checkbox"));


	}

	public boolean clickchkbxVerificationMemberidverify(String[] memberid) {

		this.verifymemberID(memberid);
		return (utils.clickAnelemnt(this.chkbxVerificationMemberidverify, "MemberVerify", "Member id verify checkbox"));


	}

	public boolean clickchkbxVerificationMemberDOB (String[] DOB){
		this.verifymemberDOB(DOB);
		return (utils.clickAnelemnt(this.chkbxVerificationMemberDOB, "MemberVerify", "Member DOB verify checkbox"));

	}

	public boolean clickchkbxVerificationMemberAddress(String[] address)
	{
		this.verifymemberAddress(address);
		return(utils.clickAnelemnt(this.chkbxVerificationMemberaddress, "MemberVerification", "Member Address"));

	}

	public boolean settxtbxVerificationCallbackextension (String extension){

		return (utils.enterTextinAnelemnt(this.txtbxVerificationCallbackextension,extension, "MemberVerify", "Member CallBack extensioncheckbox"));

	}

	public boolean clickchkbxVerificationMemberphone (String[] phone){
		this.verifymemberphone(phone);
		return (utils.clickAnelemnt(this.chkbxVerificationMemberphone, "MemberVerify", "Member phone checkbox"));	
	}
	public boolean clickchkbxVerificationMemberpcp (String[] pcp){
		this.verifymemberpcp(pcp);
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("scroll(0, 250);");
		//utils.clickAnelemnt(this.chkbxVerificationMemberPCP, "MemberVerify", "Member PCP checkbox");
		return (utils.clickAnelemnt(this.chkbxVerificationMemberPCP, "MemberVerify", "Member PCP checkbox"));	
	}

	public boolean clickchkbxVerificationMemberSSN (String[] ssn){
		this.verifymemberSSN(ssn);
		return (utils.clickAnelemnt(this.chkbxVerificationMemberSSN, "MemberVerify", "Member phone checkbox"));	
	}

	public boolean clickchkbxVerificationMemberverified (){

		return (utils.clickAnelemnt(this.chkbxVerificationMemberverified, "MemberVerify", "Member verified checkbox"));	

	}

	public boolean settxtbxVerificationContractname (String name){
		return (utils.enterTextinAnelemnt(this.txtbxVerificationContactname,name, "MemberVerify", "Member contact name checkbox"));	

	}

	public boolean settxtbxVerificationContacttype (String contacttype){

		return (utils.enterTextinAnelemnt(this.txtbxVerificationContacttype, contacttype,"MemberVerify", "Member contact type checkbox"));	
	}


	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickchkbxVerificationContinuewoverify
	 * Type:Textbox
	 *


	 */
	public boolean clickchkbxVerificationContinuewoverify (){

		return (utils.clickAnelemnt(this.chkbxVerificationContinuewoverify, "MemberVerify", "Continue without verify checkbox"));	

	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:setTextVerificationReason
	 * #Arguments:Dropdown
	 * Type:Dropdown
	 *Keys:Emergency Inferred Representative#Same Day Contact#Unable to verify


	 */
	public boolean setTextVerificationReason(String reason)
	{
		return(utils.selectDropDownbyVisibleString(this.dropdownVerificationcannotverifyreason, reason, "Verify member ", "reason for continue wo validation "));

	}

	public boolean clickbtnVerificationSubmit(){

		return utils.clickAnelemnt(this.btnVerificationSubmit, "MemberVerify", "Continue without verify checkbox");	

	}
	
	
	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;
	
	public void gotoLastIframe(){
		System.out.println("1");
		Driver.getPgDriver().switchTo().defaultContent();
		System.out.println("2");
		
		int i=this.iframes.size();
		System.out.println(i);
		Driver.getPgDriver().switchTo().frame(i-1);
		System.out.println("##########");
	}
	
	public boolean isMemberCompositeReached(){
		utils.waitforpageload();
		try {
			gotoLastIframe();
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			err.logError(e, "unhandled  alert error in switiching frame");
			e.printStackTrace();
		}
		return !utils.isProxyWebelement(tabMbrCompositeMember);

	}
	
	
	public boolean clickOnSubmit(){
		if(utils.clickAnelemnt(btnVerificationSubmit, "SelectContract", "Submit"))
		utils.waitforpageload();
		try {
			return !utils.isServiceDown();
			
		} catch (Exception e) {
			
			System.out.println("Exception occured in service down");
			return false;
		}

	}

	public boolean clicklinkVerificationOpenCIRS()
	{
		return(utils.clickAnelemnt(this.linkVerificationOpenCIRSlink,"Member Verify","CIRS link "));
	}

	public boolean clickradioVerificationActiveRecordsPresent()
	{
		return utils.clickAnelemnt(this.radioVerificationActiveRecordsPresent,"Member Verify","Active Records Yes button  ");
	}

	public boolean clickradioVerificationNoActiveRecords()
	{
		if(!utils.isProxyWebelement(radioVerificationNoActiveRecords))
			return utils.clickAnelemnt(this.radioVerificationNoActiveRecords,"Member Verify","Active Records No Button");
		return false;
	}

	public boolean clickbtnOtherActions()
	{
		return utils.pressEnter(this.getBtnOtherActions(), "Member Verify", "Other actions button");
	}

	public boolean clicklinkexitInteraction()
	{
		utils.clickAnelemnt(this.getBtnOtherActions(), "Member Verify", "Other actions button");
		action.moveToElement(this.lnkOtherActionExitInteraction);
		return utils.clickAnelemnt(this.lnkOtherActionExitInteraction, "Phone Call", "Other Exitinteraction");

	}

	public boolean validateMemberDiscloseInfo()
	{
		wait=new WebDriverWait(Driver.getPgDriver(),2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsMemberAvailableToSpeakWithNo")));
		utils.clickAnelemnt(this.radioVerifyMemberisAvailable, "Verify Member", "radio button");
		utils.clickAnelemnt(this.radioVerificationNoActiveRecords, "Verify Member", "radio button");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsAnyActiveRecordPresentYes")));
		return utils.clickAnelemnt(this.radioDiscloseYes, "Verify Member", "radio button");
		/*Assert.assertEquals(true, this.labelpermissiontodisclose.isDisplayed());
			Assert.assertEquals(true, this.radioDiscloseYes.isDisplayed());
			Assert.assertEquals(true, this.radioDiscloseNo.isDisplayed());*/

	}

	public boolean HippaQuestionsValidateAssociatedContact()
	{
		wait=new WebDriverWait(Driver.getPgDriver(),2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsMemberAvailableToSpeakWithNo")));
		utils.clickAnelemnt(this.radioVerifyMemberisAvailable, "Verify Member", "radio button");
		System.out.println("Radio was availableee");
		if(utils.clickAnelemnt(this.radioVerificationActiveRecordsPresent, "Verify Member", "radio button"))
			if(utils.clickAnelemnt(this.radioVerificationConfidentialCommunicationYes, "Verify Member", "radio button"))
				if(utils.clickAnelemnt(this.RadioVerificationRequestCorrectPasswordNo, "Verify Member", "radio button"))

					/*Assert.assertEquals(true, this.questionactiverecord.isDisplayed());
			Assert.assertEquals(true, this.questionconfidentialcommunication.isDisplayed());
			Assert.assertEquals(true, this.questionpassword.isDisplayed());
			Assert.assertEquals(true, this.questionpasswordhint.isDisplayed());*/

					if(utils.clickAnelemnt(this.radioVerifyMemberisnotAvailable, "Verify Member", "radio button"))
						System.out.println("Radio was availableee");
		if(utils.clickAnelemnt(this.radioVerificationActiveRecordsPresent, "Verify Member", "radio button"))
			if(utils.clickAnelemnt(this.radioVerificationConfidentialCommunicationNo, "Verify Member", "radio button"))
				if(utils.clickAnelemnt(this.RadioVerificationSensitiveServicesNo, "Verify Member", "radio button"))
					if(utils.clickAnelemnt(this.RadioVerificationactiveAuthorizedrepresentativeYes, "Verify Member", "radio button"))
						return utils.clickAnelemnt(this.RadioVerificationContactListedAuthorizedrepresentativeYes, "Verify Member", "radio button");
		return false;

		/*Assert.assertEquals(true, this.questionactiverecord.isDisplayed());
			Assert.assertEquals(true, this.questionconfidentialcommunication.isDisplayed());
			Assert.assertEquals(true, this.questionactiveauthorized.isDisplayed());
			Assert.assertEquals(true, this.questionactivesensitive.isDisplayed());
			Assert.assertEquals(true, this.questioncontactlistedactivesensitive.isDisplayed());*/

	}



	public boolean ValidateMemberVerifyPage()
	{
		if(!utils.isProxyWebelement(this.verifyMemberdialogContent))
		{
			try{
				wait=new WebDriverWait(Driver.getPgDriver(),2);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsMemberAvailableToSpeakWithNo")));
				utils.clickAnelemnt(this.radioVerifyMemberisnotAvailable, "Verify Member", "radio button");
				System.out.println("Radio was available");
				wait=new WebDriverWait(Driver.getPgDriver(),2);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsAnyActiveRecordPresentYes")));
				return utils.clickAnelemnt(this.radioVerificationNoActiveRecords, "Verify Member", "radio button");
			}
			catch(Exception e)
			{
				System.out.println("Radio was not available");
			}
			try{
				wait=new WebDriverWait(Driver.getPgDriver(),2);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsAnyActiveRecordPresentYes")));
				return utils.clickAnelemnt(this.radioVerificationNoActiveRecords, "Verify Member", "radio button");
			}
			catch(Exception e)
			{
				System.out.println("Radio was not available");
				return true;
			}

		}
		else {
			System.out.println("Verify member dialog contecnt");
			return false;
		}


	}

	public boolean checkNicknameandExtension()
	{
		if(this.ValidateMemberVerifyPage())
			if(this.txtbxVerificationNickname.getText().contains("Nickname"))
				if(this.txtbxVerificationCallbacknumber.getText().contains("9789993747"))
					return true;
		return false;
	}

	public boolean checkforContactcannotbevalidatedmsg()
	{
		if(this.ValidateMemberVerifyPage())
			if(utils.clickAnelemnt(this.radioVerificationActiveRecordsPresent, "Verify Member", "radio button"))
				if(utils.clickAnelemnt(this.radioVerificationConfidentialCommunicationYes, "Verify Member", "radio button"))
					if(utils.clickAnelemnt(this.RadioVerificationRequestCorrectPasswordNo, "Verify Member", "radio button"))
						if(utils.clickAnelemnt(this.RadioVerificationPasswordHintNo, "Verify Member", "radio button"))
							return true;
		return false;


	}
	public boolean ValidateDetailsPresent()
	{
		return !utils.isProxyWebelement(chkbxVerificationMembernameverify);
	}

	@FindBy(xpath="//*[@class='pageErrorList layout-noheader-errors']")
	WebElement CIRSErrorMessage;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifymemberdetails
	 * #Arguments:KeyValuePair
	 * Type:Table
	 *Keys:membername#memberid#memberdob#memberaddress#memberphone#pcp#ssn

	 */

	public boolean verifymemberdetails(String [] args) throws InterruptedException
	{
		utils.waitforpageload();
		utils.scrolltomiddle();
		if(this.ValidateDetailsPresent())
		{
			for(int i=0;i<args.length;i++)
			{
				if(args[i].contains("name"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if( this.clickchkbxVerificationMembernameverify(s))
					{
						if(i==args.length-1)
						{
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("id"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if(this.clickchkbxVerificationMemberidverify(s))
					{
						if(i==args.length-1)
						{
							//utils.scrolltomiddle();
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("dob"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if( this.clickchkbxVerificationMemberDOB(s))
					{

						if(i==args.length-1) 
						{
							/*utils.scrolltomiddle();
							if(utils.clickAnelemnt(btnVerificationSubmit, "Member Verify", "submit button ")) {
								if(!utils.isAlertPresent())
								if(utils.isProxyWebelement(CIRSErrorMessage))
									return true;
								else
									utils.setDataIssue(CIRSErrorMessage.getText());*/
							return clickSubmitafterVerification();
							
						}
						continue;
					}
					else
						break;
				}

				else if (args[i].contains("address"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberAddress(s))
					{
						if(i==args.length-1)
						{
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break; 
				}
				else if (args[i].contains("phone"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberphone(s))
					{
						if(i==args.length-1)
						{
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}

				else if (args[i].contains("pcp"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberpcp(s))
					{
						if(i==args.length-1)
						{
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("contact"))
				{
					if(args[i].contains("name"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};

						if(this.verifymembecontactname(s))
						{
							if(i==args.length-1)
							{
								return clickSubmitafterVerification();
							}
							continue;
						}
						else 
							break;


					}
					else if(args[i].contains("type"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};

						if(this.verifymembercontacttype(s))
						{
							if(i==args.length-1)
							{							
								return clickSubmitafterVerification();								
							}
							continue;
						}
						else 
							break;
					}
				}


				else if (args[i].contains("ssn"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberSSN(s))
					{
						if(i==args.length-1)
						{
							//utils.scrolltomiddle();
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}
				else 
				{
					err.logcommonMethodError("MemberVerify", "verifymemberdetails");
				}

			}


			err.logcommonMethodError("MemberVerify", "verifymemberdetails");
			return false;
		}
		
		return true;
	}
public boolean clickSubmitafterVerification(){
	utils.scrolltomiddle();
	if(utils.clickAnelemnt(btnVerificationSubmit, "Member Verify", "submit button "))
		if(!utils.isAlertPresent())
			return true;
		else 
			if(utils.isProxyWebelement(CIRSErrorMessage))				
				utils.setDataIssue(CIRSErrorMessage.getText());
	return false;
}




	public boolean verifyMemberDetailsWithDelegatedContact(String[] contacttype)
	{
		String input="";
		if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "agent"))
		{
			input="Agent/Broker";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "anthem"))
		{
			input="Anthem Associate";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "attorney"))
		{
			input="Attorney";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "parent"))
		{
			input="Parent";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "friend"))
		{
			input="Friend/Relative";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "group business associate"))
		{
			input="Group Business Associate";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "group"))
		{
			input="Group";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "guardian"))
		{
			input="Guardian/Representative";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "insurance"))
		{
			input="Insurance Carriers";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "custodial"))
		{
			input="Custodial Parent";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "provider"))
		{
			input="Provider";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "third"))
		{
			input="Third Party Administrator";
		}
		else if(utils.isvalueMatch_contain(contacttype[0].toLowerCase(), "other"))
		{
			input="Other";
		}
		else
		{
			return false;
		}

		if(this.ValidateMemberVerifyPage())
			if(this.ValidateDetailsPresent())
				if(utils.clickAnelemnt(this.chkbxVerificationMembernameverify, "Verify Member ", "member name check box "))
					if(utils.clickAnelemnt(this.chkbxVerificationMemberidverify, "Verify Member ", "member ID check box "))
						if(utils.clickAnelemnt(this.chkbxVerificationMemberDOB, "Verify Member ", "member DOB check box "))
						{
							JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
							jse.executeScript("scroll(0, 250);");
							if(utils.clickAnelemnt(this.chkbxVerificationMemberverified, "Verify Member ", "member verified check box "))
								if(utils.enterTextinAnelemnt(this.txtbxVerificationContactname, "Contact name ", "Verify Member ", "member contact name textbox "))
									if(utils.selectDropDownbyVisibleString(this.txtbxVerificationContacttype,input, "Verify Member ", "member contact type textbox "))
										if(utils.clickAnelemnt(this.btnVerificationSubmit, "Verify member", "Submit button on Verify member "))
											return true;
						}
						else
							return false;
		return false;
	}

	public boolean DoNotverifymemberdetails(String[] reason)
	{
		String input="";
		if(this.ValidateMemberVerifyPage())
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("scroll(0, 250);");
			if(this.clickchkbxVerificationContinuewoverify())
			{
				if(utils.isvalueMatch_contain(reason[0].toLowerCase(), "emergency"))
				{
					input="Emergency Inferred Representative";
				}
				else if(utils.isvalueMatch_contain(reason[0].toLowerCase(), "same"))
				{
					input="Same Day Contact";
				}
				else if(utils.isvalueMatch_contain(reason[0].toLowerCase(), "unable"))
				{
					input="Unable to verify";
				}
				else
				{
					input="Unable to verify";
				}
				if(this.setTextVerificationReason(input))
				{
					if(this.clickbtnVerificationSubmit())
					{
						return true;
					}
					else
					{
						err.logcommonMethodError("MemberVerify", "verifymemberdetails");
						System.out.println("Not to able to complete verification in without member verfiication page");
						return false;
					}

				}
				else return false;
			}
			else 

				return false;
		}
		return false;
	}


	public boolean verifyValuePresent(String [] args)
	{
		String Valuetobechecked=args[0];
		if(Driver.pgDriver.getPageSource().contains(Valuetobechecked))
			return true;
		else
			return false;


	}

	public boolean verifymemberID(String args[])
	{
		if(this.ValidateDetailsPresent()) {
		waitforpageload();
		String memid=this.labelVerificationID.getText().toString();
		return utils.isvalueMatch_contain(memid, args[0]);
		}
		return true;
	}

	public boolean verifymemberName(String args[])
	{

		String fullname=this.labelVerificationfullname.getText().toString();
		return utils.isvalueMatch_contain(fullname, args[0]);
	}

	public boolean verifymemberDOB(String args[])
	{
		String memberDOB=this.labelVerificationDOB.getText().toString();
		return utils.isvalueMatch_contain(memberDOB, args[0]);
	}

	public boolean verifymemberSSN(String args[])
	{
		String memberSSN=this.labelVerificationSSN.getText().toString();
		String concatmemberSSN=memberSSN.substring(memberSSN.length() - 4);
		return utils.isvalueMatch_contain(concatmemberSSN, args[0]);
	}

	@FindBy(xpath="//a[contains(text(),'Open CIRS')]")
	WebElement lnkOpenCIRS;

	public boolean checkCIRSlink()
	{
		if(this.ValidateMemberVerifyPage())
			return !utils.isProxyWebelement(lnkOpenCIRS);
		return false;
	}

	@FindBy(xpath="//*[@node_name='VerifyContactMemberAvailable']//*[@class='iconRequired Standard_iconRequired']")
	WebElement iconStandard;

	public boolean checkavailabletospeak()
	{
		if(this.ValidateMemberVerifyPage())
			return !utils.isProxyWebelement(iconStandard);
		return false;

	}
	public boolean verifymemberAddress(String args[])
	{
		String memberaddress=this.labelVerificationaddress.getText().toString();
		return utils.isvalueMatch_contain(memberaddress, args[0]);
	}

	public boolean verifymembecontactname(String args[])
	{
		String membername=this.labelVerifyMemberContactName.getText().toString();
		return utils.isvalueMatch_contain(membername, args[0]);
	}

	public boolean verifymembercontacttype(String args[])
	{
		String membercontacttype=this.labelVerifyMemberContactType.getText().toString();
		return utils.isvalueMatch_contain(membercontacttype, args[0]);
	}

	public boolean verifymemberphone(String args[])
	{
		String MemberPhoneNumber=this.labelVerificationphone.getText().toString();
		return utils.isvalueMatch_contain(MemberPhoneNumber, args[0]);
	}

	public boolean verifymemberpcp(String args[])
	{
		String Memberpcp=this.labelVerificationpcp.getText().toString();
		return utils.isvalueMatch_contain(Memberpcp, args[0]);

	}

	public boolean exitInteraction(){
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Exit Interaction", "Verify Member", "Exit Interaction");
	}


	public boolean ValidateMemberVerifyPage(String sHeader)
	{
		if(!utils.isProxyWebelement(this.titleVerificationPageName))
			return utils.validateHeader(titleVerificationPageName, sHeader);
		return false;
	}

	public boolean Validatecheckbox( String[] mDetail)
	{
		if(utils.isvalueMatch_contain(mDetail[0], "name"))
		{
			if(this.chkbxVerificationMembernameverify.isSelected())
			{
				System.out.println("Member Name checkbox is preclicked");
				return true;
			}
			else
			{
				err.logcommonMethodError("Verify member", "SSN is not checked");
				return false;
			} 

		}
		if(utils.isvalueMatch_contain(mDetail[0], "id"))
		{
			if(this.chkbxVerificationMemberidverify.isSelected())
			{
				System.out.println("Member id checkbox is preclicked");
				return true;
			}
			else
			{
				err.logcommonMethodError("Verify member", "SSN is not checked");
				return false;
			} 

		}
		if(utils.isvalueMatch_contain(mDetail[0], "dob"))
		{
			if(this.chkbxVerificationMemberDOB.isSelected())
			{
				System.out.println("Member DOB checkbox is preclicked");
				return true;
			}
			else
			{
				err.logcommonMethodError("Verify member", "SSN is not checked");
				return false;
			}   
		}
		if(utils.isvalueMatch_contain(mDetail[0], "ssn"))
		{
			if(this.chkbxVerificationMemberidverify.isSelected())
			{
				System.out.println("Member Name checkbox is preclicked");
				return true;
			}
			else
			{
				err.logcommonMethodError("Verify member", "SSN is not checked");
				return false;
			}

		}
		return false;



	}



	public boolean pagenavigate(String[] page)
	{
		if(utils.isvalueMatch_contain(page[0], "back"))
		{
			utils.gotoback();
			return true;
		}
		else if(utils.isvalueMatch_contain(page[0], "forward"))
		{
			utils.goforward();
			return true;
		}
		else if(utils.isvalueMatch_contain(page[0], "refresh"))
		{
			utils.refreshthepage();
			return true;
		}
		else
			return false;

	}

	public boolean isConfigurationTools()
	{
		if(!utils.isProxyWebelement(this.btncloseConfigurationTool))
			if(!utils.isProxyWebelement(this.btncloseConfigurationTool))
				return true;
		return false;
	}

	public boolean waitforpageload()
	{

		try{

			Thread.sleep(2000);
			System.out.println("Checking for Loading Icon");
			wait=new WebDriverWait(Driver.getPgDriver(),90);
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[text()='Loading...']")));
			System.out.println("Checkingggg"+System.currentTimeMillis());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));


		}
		catch(Exception e){
			System.out.println("No loading icon. Continue " +e);

		}
		System.out.println("Came out");
		return true;
	}


	public boolean selectConfigurationtools()
	{
		if(utils.clickAnelemnt(this.btnImgTool, "Verify Member ", " Tools Button"))
			if(utils.clickAnelemnt(this.lnkToolConfigurationTools, "Verify member ", "Configuration tools "))
				if(isConfigurationTools())
					if(utils.clickAnelemnt(this.btncloseConfigurationTool, "Verify member", "Close Button"))
						return true;
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: validateEMailID
	 * #Description: This functionality verifies the Email id displayed with the email id entered by the CSR.
	 * Type: Textbox 
	 */
	public boolean validateEMailIDinVerifyMember()
	{
		String txtEmail = txtbxVerificationEmailID.getText();
		String txtEmail1 = txtbxVerificationEmailID.getAttribute("value");
		System.out.println("Emaild Id displayed is: " + txtEmail1);
		return utils.isvalueMatch_contain(txtEmail1, "tester@gmail.com");
	}

	public boolean clickCheckBoxMemberName()
	{
		return utils.clickAnelemnt(this.chkbxVerificationMembernameverify, "VerifyMember", "MemberName Click");
	}

	public boolean clickCheckBoxMemberID()
	{
		return utils.clickAnelemnt(this.chkbxVerificationMemberidverify, "VerifyMember", "MemberName Click");
	}

	public boolean clickCheckBoxMemberDOB()
	{
		return utils.clickAnelemnt(this.chkbxVerificationMemberDOB, "VerifyMember", "MemberName Click");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyMemberDetailsWithoutData
	 * #Description: This functionality clicks the Member Name and the Member DOB and clicks the submit button.
	 * Type: Textbox
	 */
	public boolean verifyMemberDetailsWithoutData()
	{
		try
		{
			//if(clickradioVerificationNoActiveRecords())
			if(!utils.isProxyWebelement(radioVerificationNoActiveRecords))
			{
				if(utils.clickAnelemnt(this.radioVerificationNoActiveRecords,"Member Verify","Active Records No Button"))
				if(clickCheckBoxMemberName())
					if(clickCheckBoxMemberDOB())
						//if(utils.clickAnelemnt(btnVerificationSubmit, "VerifyMember", "Submit"))
						if(clickOnSubmit())
							if(utils.isProxyWebelement(CIRSErrorMessage))
								return true;
							else
								utils.setDataIssue(CIRSErrorMessage.getText());
			return false;
			}
			else
			{
				if(clickCheckBoxMemberName())
					if(clickCheckBoxMemberDOB())
						//if(utils.clickAnelemnt(btnVerificationSubmit, "VerifyMember", "Submit"))
						if(clickOnSubmit())
							if(utils.isProxyWebelement(CIRSErrorMessage))
								return true;
							else
								utils.setDataIssue(CIRSErrorMessage.getText());
			return false;
			}
		}catch(Exception e)
		{
			if(clickCheckBoxMemberName())
				if(clickCheckBoxMemberDOB())
					//if(utils.clickAnelemnt(btnVerificationSubmit, "VerifyMember", "Submit"))
					if(clickOnSubmit())
						if(utils.isProxyWebelement(CIRSErrorMessage))
							return true;
						else
							utils.setDataIssue(CIRSErrorMessage.getText());
			return false;

		}
	}


	//Sprint 4.1

	public boolean verifyMemberVerificationPageIsDisplayedWhenHIPAAVerificationIsIncomplete()
	{
		return !utils.isProxyWebelement(titleVerificationPageName);
	}


	//Sprint 5.1

	@FindBy(id="IsContactNameVerified")
	WebElement chckBxContactFullName;

	public boolean validateContactFullNameIsDisabled()
	{
		boolean bol = chckBxContactFullName.isEnabled();
		System.out.println(bol);
		if(bol==false)
		{
			blogger.loginfo("Contact Full Name checkbox is disbaled");
			System.out.println("Contact Full Name checkbox is disbaled");
			return true;
		}else
		{
			blogger.loginfo("Contact Full Name checkbox is enabled");
			System.out.println("Contact Full Name checkbox is enabled");
			return false;
		}
	}


	@FindBy(xpath="//input[@id='IsAnyActiveRecordPresentYes']")
	WebElement HipaaConfidentialYes;

	@FindBy(xpath="//input[@id='IsAnyActiveRecordPresentNo']")
	WebElement HipaaConfidentialNo;



	public boolean selectMemberHasHIPAAConfidentialInfo(String args[]){
		if(args[0].equalsIgnoreCase("Yes")){
			return utils.clickAnelemnt(HipaaConfidentialYes,"VerifyMember", "HipaaConfidential Yes");
		}else{
			return utils.clickAnelemnt(HipaaConfidentialNo,"VerifyMember", "HipaaConfidential No");
		}

	}

	//Regression Fix


	public boolean clickradioVerificationConfidentialInformationYes()
	{
		return utils.clickAnelemnt(radioVerificationConfidentialCommunicationYes,"VerifyMember","Confidential Information Yes button");
	}

	public boolean clickradioVerificationConfidentialInformationNo()
	{
		return utils.clickAnelemnt(radioVerificationConfidentialCommunicationNo,"VerifyMember","Confidential Information No button");
	}


	public boolean clickradioVerificationRequestPasswordYes()
	{
		return utils.clickAnelemnt(RadioVerificationRequestCorrectPasswordYes,"VerifyMember","Request Password Yes button");
	}

	public boolean clickradioVerificationRequestPasswordNo()
	{
		return utils.clickAnelemnt(RadioVerificationRequestCorrectPasswordNo,"VerifyMember","Request Password No button");
	}

	public boolean clickradioVerificationSupplyPasswordYes()
	{
		return utils.clickAnelemnt(RadioVerificationSupplyCorrectPasswordYes,"VerifyMember","Supply Password Yes button");
	}

	public boolean clickradioVerificationSupplyPasswordNo()
	{
		return utils.clickAnelemnt(RadioVerificationSupplyCorrectPasswordNo,"VerifyMember","Supply Password No button");
	}

	@FindBy(xpath="//div[text()='Continue with verification']")
	WebElement labelContinueWithVerification;

	public boolean validateTheLabelAfterCompletingTheCIRSVerification()
	{
		return utils.validateLabel(labelContinueWithVerification, "Continue with verification");
	}

	public boolean enterVerificationContractnameAndSelectContactType (String[] args){
		if(utils.enterTextinAnelemnt(this.txtbxVerificationContactname, args[0], "VerifyMember", "Member contact name checkbox"));
		if(utils.selectDropDownbyVisibleString(txtbxVerificationContacttype, args[1], "VerifyMember", "Contact Type"))
			return true;
		return false;

	}


	public boolean selectDropDownVerificationReason(String[] reason)
	{
		return utils.selectDropDownbyVisibleString(this.dropdownVerificationcannotverifyreason, reason[0], "Verify member ", "reason for continue wo validation");

	}


	//Sprint 6.1

	@FindBy(xpath="//a[@data-test-id='20181029130055024333938']")
	WebElement verifyCIRSLink;

	@FindBy(id="DialogContent")
	WebElement labelCIRSGuidedDialog;

	@FindBy(xpath="//li[starts-with(text(),'No CIRS Link Accessed')]")
	WebElement labelCIRSErrorMessage;

	@FindBy(id="IsMemberAvailableToSpeakWithYes")
	WebElement IsMemberAvailableToSpeakWithYes;

	@FindBy(id="IsMemberAvailableToSpeakWithNo")
	WebElement IsMemberAvailableToSpeakWithNo;

	@FindBy(id="IsAnyActiveRecordPresentYes")
	WebElement IsAnyActiveRecordPresentYes;

	@FindBy(id="IsAnyActiveRecordPresentNo")
	WebElement IsAnyActiveRecordPresentNo;

	@FindBy(xpath="//div[text()='Submit']")
	WebElement clickSubmit;



	/**This method verifies if CIRS link is displayed on the Verify member page
	 * 
	 * @return
	 */
	public boolean verifyCIRSLinkIsDisplayed()
	{
		return !utils.isProxyWebelement(verifyCIRSLink);
	}


	/**This method validates the CIRS guided dialouge on the page header
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCIRSGuidedDialouge(String[] args) throws InterruptedException {
		utils.waitforpageload();
		String actualText = args[0];
		String expectedText = labelCIRSGuidedDialog.getText().replaceAll("/n", " ");
		return utils.isvalueMatch_contain(actualText, expectedText);
	}


	/**This method validates the error message when submit is clicked without accessing the CIRS link
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCIRSErrorMessage(String[] args) throws InterruptedException {
		utils.waitforpageload();
		return utils.validateLabel(labelCIRSErrorMessage, args[0]);
	}


	/**This method selects if the member is available to speak with Yes or No radio buttons
	 * 
	 * @param args
	 * @return
	 */
	public boolean isMemberAvailableToSpeak(String args[]){
		if(args[0].equalsIgnoreCase("Yes"))

			return utils.clickAnelemnt(this.IsMemberAvailableToSpeakWithYes,"VerifyMember", "IsMemberAvailableToSpeakWithYes");
		else
			return utils.clickAnelemnt(this.IsMemberAvailableToSpeakWithNo,"VerifyMember", "IsMemberAvailableToSpeakWithNo");


	}


	/**This method selects if any active records are found for teh member with Yes or No radio buttons
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectWereAnyActiveRecordsFoundForMember(String args[]){

		if(args[0].equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(this.IsAnyActiveRecordPresentYes,"VerifyMember", "IsAnyActiveRecordPresentYes");
		else
			return utils.clickAnelemnt(this.IsAnyActiveRecordPresentNo,"VerifyMember", "IsAnyActiveRecordPresentNo");


	}



	/**This method clicks submit on the verify member page
	 * 
	 * @return
	 */
	public boolean clickSubmit()
	{
		return utils.clickAnelemnt(clickSubmit,"VerifyMember","Click submit");
	}

	public boolean verifymemberdetailsForEmail(String [] args) throws InterruptedException
	{
		utils.waitforpageload();
		utils.scrolltomiddle();
		if(this.ValidateMemberVerifyPage())
		{
			if(this.ValidateDetailsPresent())
			{
				for(int i=0;i<args.length;i++)
				{
					if(args[i].contains("name"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};

						if( this.clickchkbxVerificationMembernameverify(s))
						{
							if(i==args.length-1)
							{
								/*WebElement element = Driver.pgDriver.findElement(By.id("gbqfd"));
								JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
								executor.executeScript("arguments[0].click();", element);*/
								if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button "))
									return true;
							}
							continue;
						}
						else
							break;
					}
					else if (args[i].contains("id"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};

						if(this.clickchkbxVerificationMemberidverify(s))
						{
							if(i==args.length-1)
							{
								utils.scrolltomiddle();
								if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button "))
									return true;
							}
							continue;
						}
						else
							break;
					}
					else if (args[i].contains("dob"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};
						if( this.clickchkbxVerificationMemberDOB(s))
						{

							if(i==args.length-1) 
							{
								utils.scrolltomiddle();
								if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button ")) {
									if(utils.isProxyWebelement(CIRSErrorMessage))
										return true;
									else
										utils.setDataIssue(CIRSErrorMessage.getText());
								}
							}
							continue;
						}
						else
							break;
					}

					else if (args[i].contains("address"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};
						if(this.clickchkbxVerificationMemberAddress(s))
						{
							if(i==args.length-1)
							{
								utils.scrolltomiddle();
								if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button "))
									return true;
							}
							continue;
						}
						else
							break; 
					}
					else if (args[i].contains("phone"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};
						if(this.clickchkbxVerificationMemberphone(s))
						{
							if(i==args.length-1)
							{
								if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button "))
									return true;
							}
							continue;
						}
						else
							break;
					}

					else if (args[i].contains("pcp"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};
						if(this.clickchkbxVerificationMemberpcp(s))
						{
							if(i==args.length-1)
							{
								if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button "))
									return true;
							}
							continue;
						}
						else
							break;
					}
					else if (args[i].contains("contact"))
					{
						if(args[i].contains("name"))
						{
							String s1=args[i];
							s1 = s1.substring(s1.indexOf(":") + 1);
							String[] s=new String[]{s1};

							if(this.verifymembecontactname(s))
							{
								if(i==args.length-1)
								{
									if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button "))
										return true;
								}
								continue;
							}
							else 
								break;


						}
						else if(args[i].contains("type"))
						{
							String s1=args[i];
							s1 = s1.substring(s1.indexOf(":") + 1);
							String[] s=new String[]{s1};

							if(this.verifymembercontacttype(s))
							{
								if(i==args.length-1)
								{
									if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button "))
										return true;
								}
								continue;
							}
							else 
								break;
						}
					}


					else if (args[i].contains("ssn"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};
						if(this.clickchkbxVerificationMemberSSN(s))
						{
							if(i==args.length-1)
							{
								utils.scrolltomiddle();
								if(utils.clickAnelemnt(btnVerificationSubmitForEmail, "Member Verify", "submit button "))
									return true;
							}
							continue;
						}
						else
							break;
					}
					else 
					{
						err.logcommonMethodError("MemberVerify", "verifymemberdetails");
					}

				}


				err.logcommonMethodError("MemberVerify", "verifymemberdetails");
				return false;
			}
			err.logcommonMethodError("Verify Member", "verifymemberdetails");
			return false;
		}
		err.logcommonMethodError("Verify Member", "verifymemberdetails");
		return false;

	}

	@FindBy(id="headerlabel5638")
	WebElement labelWithoutCIRSDialog;

	public boolean validateCIRSGuidedDialougeIsNotDisplayed(){
		return !utils.isProxyWebelement(labelWithoutCIRSDialog);
	}
	
	/**Clicks on Open CIRS Link
	 * 
	 * @return
	 */
	public boolean clickOnOpenCIRSLink() {
		return utils.clickAnelemnt(lnkOpenCIRS, "Verify Member", "lnkOpenCIRS");
	}
	
	public boolean clickSSNMemberInMemberVerification() {
		if(utils.clickAnelemnt(this.chkbxVerificationMemberSSN, "MemberVerify", "Member phone checkbox"))
			if(clickOnSubmit())
				return true;
		return false;
	
	}
	

	@FindBy (id="Nickname")	
	private WebElement txtbxNickName;
	
	public boolean validateTheContactNameFieldAndValue(String[] args){
		
		return utils.validateLabel(txtbxNickName, args[0]);
	}
	
	public boolean editTheContactName(String[] args){
		
		return utils.enterTextinAnelemnt(txtbxNickName,args[0], "Search Member", "Contact First and Last name");

		}
	
	public boolean verifymemberdetailsForHIPAA(String [] args) throws InterruptedException
	{
		utils.waitforpageload();
		utils.scrolltomiddle();
		if(this.ValidateDetailsPresent())
		{
			for(int i=0;i<args.length;i++)
			{
				if(args[i].contains("name"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if( this.clickchkbxVerificationMembernameverify(s))
					{
						if(i==args.length-1)
						{
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("id"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};

					if(this.clickchkbxVerificationMemberidverify(s))
					{
						if(i==args.length-1)
						{
							//utils.scrolltomiddle();
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("dob"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if( this.clickchkbxVerificationMemberDOB(s))
					{

						if(i==args.length-1) 
						{
							/*utils.scrolltomiddle();
							if(utils.clickAnelemnt(btnVerificationSubmit, "Member Verify", "submit button ")) {
								if(!utils.isAlertPresent())
								if(utils.isProxyWebelement(CIRSErrorMessage))
									return true;
								else
									utils.setDataIssue(CIRSErrorMessage.getText());*/
							return clickSubmitafterVerification();
							
						}
						continue;
					}
					else
						break;
				}

				else if (args[i].contains("address"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberAddress(s))
					{
						if(i==args.length-1)
						{
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break; 
				}
				else if (args[i].contains("phone"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberphone(s))
					{
						if(i==args.length-1)
						{
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}

				else if (args[i].contains("pcp"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberpcp(s))
					{
						if(i==args.length-1)
						{
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}
				else if (args[i].contains("contact"))
				{
					if(args[i].contains("name"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};

						if(this.verifymembecontactname(s))
						{
							if(i==args.length-1)
							{
								return clickSubmitafterVerification();
							}
							continue;
						}
						else 
							break;


					}
					else if(args[i].contains("type"))
					{
						String s1=args[i];
						s1 = s1.substring(s1.indexOf(":") + 1);
						String[] s=new String[]{s1};

						if(this.verifymembercontacttype(s))
						{
							if(i==args.length-1)
							{							
								return clickSubmitafterVerification();								
							}
							continue;
						}
						else 
							break;
					}
				}


				else if (args[i].contains("ssn"))
				{
					String s1=args[i];
					s1 = s1.substring(s1.indexOf(":") + 1);
					String[] s=new String[]{s1};
					if(this.clickchkbxVerificationMemberSSN(s))
					{
						if(i==args.length-1)
						{
							//utils.scrolltomiddle();
							return clickSubmitafterVerification();
						}
						continue;
					}
					else
						break;
				}
				else 
				{
					err.logcommonMethodError("MemberVerify", "verifymemberdetails");
				}

			}


			err.logcommonMethodError("MemberVerify", "verifymemberdetails");
			return false;
		}
		
		return false;
	}
}

