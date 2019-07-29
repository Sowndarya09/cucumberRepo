package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ProviderVerifyMember extends Driver {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	public ProviderVerifyMember()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		utils.waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;


	@FindBy(className="anthem_theme_header")
	WebElement titleVerificationPageName;

	@FindBy(id= "Nickname")
	WebElement txtbxVerificationNickname;

	@FindBy(id ="CallBackNumber")
	WebElement txtbxVerificationCallbacknumber;

	@FindBy(id="CallBackNumExt")
	WebElement txtbxVerificationCallbackextension;

	@FindBy(id="IsMemberNameVerified")
	WebElement chkbxVerificationMembernameverify;

	@FindBy(id="IsMemberIDVerified")
	WebElement chkbxVerificationMemberidverify;
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

	@FindBy(xpath="//*[text()='Submit']")
	WebElement btnVerificationSubmit;

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
	WebElement RadioVerificationSupplyCorrectPasswordNo;

	@FindBy(id="IsPasswordHintProvidedNo")
	WebElement RadioVerificationPasswordHintNo;

	@FindBy(id="IsCIRSRecordActiveAndSensitiveNo")
	WebElement RadioVerificationSensitiveServicesNo;

	@FindBy(id="IsThereAnAuthorizedRepRecordYes")
	WebElement RadioVerificationactiveAuthorizedrepresentativeYes;

	@FindBy(id="IsTheContactListedAsAuthRepYes")
	WebElement RadioVerificationContactListedAuthorizedrepresentativeYes;

	@FindBy(xpath="//label[@for='pyFullName']/parent::div//span")
	WebElement labelVerificationfullname;

	@FindBy(id="HasPHIPermissionYes")
	WebElement radioDiscloseYes;

	@FindBy(id="HasPHIPermissionNo")
	WebElement radioDiscloseNo;

	@FindBy(id="HasPHIPermissionContinue Interaction with Member")
	WebElement radioDisclosecontinue;

	@FindBy(xpath="//label[@for='HCID']/parent::div//span")
	WebElement labelVerificationID;

	@FindBy(xpath="//label[@for='DateOfBirth']/parent::div//span")
	WebElement labelVerificationDOB;

	@FindBy(xpath="//label[@for='MemberPhoneNumber']/parent::div/div")
	WebElement labelVerificationphone;

	@FindBy(xpath="//label[@for='SSN']/parent::div/div")
	WebElement labelVerificationSSN;

	@FindBy(xpath="//label[@for='ParticipatingProvider']/parent::div//span")
	WebElement labelVerificationpcp;

	@FindBy(xpath="//label[@for='MemberAddress']/parent::div//span")
	WebElement labelVerificationaddress;

	@FindBy(id="ContinueValidationReasons")
	WebElement dropdownVerificationcannotverifyreason;


	@FindBy(xpath="//label[@for='HasPHIPermission']//span")
	WebElement labelpermissiontodisclose;
	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;


	@FindBy (xpath="//*[@class='menu-item-title'][text()='Exit Interaction']")	
	private WebElement lnkOtherActionExitInteraction;

	@FindBy (xpath="//img[@src='webwb/tool_icon_13690228252.png!!.png']")	
	private WebElement btnImgTool;


	@FindBy(xpath ="//div[contains(text(),'Be patient')]")
	WebElement verifyMemberdialogContent;

	@FindBy(id="IsMemberAvailableToSpeakWithNo")
	WebElement radioVerifyMemberisnotAvailable;

	@FindBy(id="IsMemberAvailableToSpeakWithYes")
	WebElement radioVerifyMemberisAvailable;

	@FindBy(id="IsAnyActiveRecordPresentYes")
	WebElement radioVerifyMemberisActiverecordPresent;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View History']")	
	private WebElement lnkToolViewHistory;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Configuration Tools']")	
	private WebElement lnkToolConfigurationTools;
	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Close')]")
	private WebElement btncloseConfigurationTool;

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

	@FindBy(xpath="//label[@for='AssociatedContactName']/parent::div/span")
	WebElement labelVerifyMemberContactName;

	@FindBy(xpath="//label[@for='SelectedContactType']/parent::div/span")
	WebElement labelVerifyMemberContactType;



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

		return (utils.clickAnelemnt(this.btnVerificationSubmit, "MemberVerify", "Continue without verify checkbox"));	

	}

	public boolean clicklinkVerificationOpenCIRS()
	{
		return(utils.clickAnelemnt(this.linkVerificationOpenCIRSlink,"Member Verify","CIRS link "));
	}

	public boolean clickradioVerificationActiveRecordsPresent()
	{
		return(utils.clickAnelemnt(this.radioVerificationActiveRecordsPresent,"Member Verify","Active Records Yes button  "));
	}

	public boolean clickradioVerificationNoActiveRecords()
	{
		return(utils.clickAnelemnt(this.radioVerificationNoActiveRecords,"Member Verify","Active Records No Button"));
	}

	public boolean clickbtnOtherActions()
	{
		return utils.pressEnter(this.getBtnOtherActions(), "Member Verify", "Other actions button");
	}

	public boolean clicklinkexitInteraction()
	{
		if(utils.clickAnelemnt(this.getBtnOtherActions(), "Member Verify", "Other actions button")) {
			action.moveToElement(this.lnkOtherActionExitInteraction);
			return utils.clickAnelemnt(this.lnkOtherActionExitInteraction, "Phone Call", "Other Exitinteraction");
		}
		return false;

	}

	public boolean validateMemberDiscloseInfo()
	{

		try{
			wait=new WebDriverWait(Driver.getPgDriver(),2);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsMemberAvailableToSpeakWithNo")));
			if(utils.clickAnelemnt(this.radioVerifyMemberisAvailable, "Verify Member", "radio button"))
				if(utils.clickAnelemnt(this.radioVerificationNoActiveRecords, "Verify Member", "radio button"))
					if(utils.clickAnelemnt(this.radioDiscloseYes, "Verify Member", "radio button")) {
						Assert.assertEquals(true, this.labelpermissiontodisclose.isDisplayed());
						Assert.assertEquals(true, this.radioDiscloseYes.isDisplayed());
						Assert.assertEquals(true, this.radioDiscloseNo.isDisplayed());
						Assert.assertEquals(true, this.radioDisclosecontinue.isDisplayed());
						return true;
					}
			return false;
		}
		catch(Exception e)
		{
			err.logError("Verify Member", "Member disclose message not present ont he screen");
			return false;
		}
	}

	public boolean HippaQuestionsValidateAssociatedContact()
	{
		try{
			wait=new WebDriverWait(Driver.getPgDriver(),2);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsMemberAvailableToSpeakWithNo")));
			utils.clickAnelemnt(this.radioVerifyMemberisAvailable, "Verify Member", "radio button");
			System.out.println("Radio was availableee");
			this.radioVerificationActiveRecordsPresent.click();
			this.radioVerificationConfidentialCommunicationYes.click();
			this.RadioVerificationSupplyCorrectPasswordNo.click();

			Assert.assertEquals(true, this.questionactiverecord.isDisplayed());
			Assert.assertEquals(true, this.questionconfidentialcommunication.isDisplayed());
			Assert.assertEquals(true, this.questionpassword.isDisplayed());
			Assert.assertEquals(true, this.questionpasswordhint.isDisplayed());

			utils.clickAnelemnt(this.radioVerifyMemberisnotAvailable, "Verify Member", "radio button");
			System.out.println("Radio was availableee");
			this.radioVerificationActiveRecordsPresent.click();
			this.radioVerificationConfidentialCommunicationNo.click();
			this.RadioVerificationSensitiveServicesNo.click();
			this.RadioVerificationactiveAuthorizedrepresentativeYes.click();
			this.RadioVerificationContactListedAuthorizedrepresentativeYes.click();

			Assert.assertEquals(true, this.questionactiverecord.isDisplayed());
			Assert.assertEquals(true, this.questionconfidentialcommunication.isDisplayed());
			Assert.assertEquals(true, this.questionactiveauthorized.isDisplayed());
			Assert.assertEquals(true, this.questionactivesensitive.isDisplayed());
			Assert.assertEquals(true, this.questioncontactlistedactivesensitive.isDisplayed());


			return true;
		}
		catch(Exception e)
		{
			err.logError("Verify Member", "Hippa Questions not present ont he screen");
			return false;
		}

	}



	public boolean ValidateMemberVerifyPage()
	{
		if(!utils.isProxyWebelement(this.verifyMemberdialogContent))
		{
			try{
				wait=new WebDriverWait(Driver.getPgDriver(),2);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsMemberAvailableToSpeakWithNo")));
				if(utils.clickAnelemnt(this.radioVerifyMemberisnotAvailable, "Verify Member", "radio button")) {
					System.out.println("Radio was available");
					wait=new WebDriverWait(Driver.getPgDriver(),2);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsAnyActiveRecordPresentYes")));
					return utils.clickAnelemnt(this.radioVerificationNoActiveRecords, "Verify Member", "radio button");
				}
				return false;
			}
			catch(Exception e)
			{
				System.out.println("Radio was not available");
			}

			try{
				wait=new WebDriverWait(Driver.getPgDriver(),2);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IsAnyActiveRecordPresentYes")));
				utils.clickAnelemnt(this.radioVerificationNoActiveRecords, "Verify Member", "radio button");
				System.out.println("Radio was available");
				Thread.sleep(2000);
				return true;
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
		{
			if(this.txtbxVerificationNickname.getText().contains("Nickname"))
			{
				if(this.txtbxVerificationCallbacknumber.getText().contains("9789993747"))
					return true;
				else
				{
					err.logError("Verify Member", "Callback number does not contain the value present in the search member page");
					return false;
				}
			}
			else
			{
				err.logError("Verify Member", "Nick name does not contain the value present in the search member page");
				return false;
			}
		}
		return true;
	}

	public boolean checkforContactcannotbevalidatedmsg()
	{
		if(this.ValidateMemberVerifyPage())
		{
			this.radioVerificationActiveRecordsPresent.click();
			this.radioVerificationConfidentialCommunicationYes.click();
			this.RadioVerificationSupplyCorrectPasswordNo.click();
			this.RadioVerificationPasswordHintNo.click();
			try{
				wait=new WebDriverWait(Driver.pgDriver,2);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='HIPAASpecialAuthorization']//*[contains(text(),'Continue to exi')]")));
				return true;
			}
			catch(Exception e)
			{
				err.logError("VerifyMember", "No continue to exit interaction message appears.");
				return false;
			}
		}
		return false;


	}
	public boolean ValidateDetailsPresent()
	{
		return !utils.isProxyWebelement(chkbxVerificationMembernameverify);
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifymemberdetails
	 * #Arguments:memberdetails-KeyValuePair
	 * Type:Table
	 *Keys:membername#memberid#memberdob#memberaddress#memberphone#pcp#ssn

	 */

	public boolean verifyMemberDetailsAndSubmit(String [] args)
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
							utils.waitforpageload();
							utils.scrolltomiddle();
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
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
							utils.waitforpageload();
							utils.scrolltomiddle();
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
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
							utils.waitforpageload();
							utils.scrolltomiddle();
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
								return true;
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
							utils.waitforpageload();
							utils.scrolltomiddle();
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
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
							utils.waitforpageload();
							utils.scrolltomiddle();
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
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
							utils.waitforpageload();
							utils.scrolltomiddle();
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
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
								utils.waitforpageload();
								utils.scrolltomiddle();
								if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
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
								utils.waitforpageload();
								utils.scrolltomiddle();
								if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
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
							if(utils.clickAnelemnt(this.btnVerificationSubmit, "Member Verify", "submit button "))
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
					System.out.println( " Sorry, there is no attribute present as "+args[i]);
				}

			}


			err.logcommonMethodError("MemberVerify", "verifymemberdetails");
			System.out.println("Not to able to complete verification");
			return false;
		}


		err.logcommonMethodError("Verify Member", "verifymemberdetails");
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

		String memid=this.labelVerificationID.getText().toString();
		if(memid.contains(args[0]))
		{
			return true;
		}
		else
			return false;


	}

	public boolean verifymemberName(String args[])
	{

		String fullname=this.labelVerificationfullname.getText().toString();
		if(fullname.contains(args[0]))
		{
			return true;
		}
		else
			return false;

	}

	public boolean verifymemberDOB(String args[])
	{
		String memberDOB=this.labelVerificationDOB.getText().toString();
		if(memberDOB.contains(args[0]))
		{
			return true;
		}
		else
			return false;

	}

	public boolean verifymemberSSN(String args[])
	{
		String memberSSN=this.labelVerificationSSN.getText().toString();
		String concatmemberSSN=memberSSN.substring(memberSSN.length() - 4);
		if(concatmemberSSN.contains(args[0]))
		{
			return true;
		}
		else
			return false;

	}

	public boolean checkCIRSlink()
	{
		return this.ValidateMemberVerifyPage();
	}

	public boolean checkavailabletospeak()
	{
		return this.ValidateMemberVerifyPage();
	}
	public boolean verifymemberAddress(String args[])
	{
		String memberaddress=this.labelVerificationaddress.getText().toString();
		return memberaddress.contains(args[0]);

	}

	public boolean verifymembecontactname(String args[])
	{
		String memberaddress=this.labelVerifyMemberContactName.getText().toString();
		return memberaddress.contains(args[0]);

	}

	public boolean verifymembercontacttype(String args[])
	{
		String memberaddress=this.labelVerifyMemberContactType.getText().toString();
		return memberaddress.contains(args[0]);

	}

	public boolean verifymemberphone(String args[])
	{
		String MemberPhoneNumber=this.labelVerificationphone.getText().toString();
		return MemberPhoneNumber.contains(args[0]);

	}

	public boolean verifymemberpcp(String args[])
	{
		String Memberpcp=this.labelVerificationpcp.getText().toString();
		return Memberpcp.contains(args[0]);

	}

	public boolean exitInteraction(){

		if(this.clickbtnOtherActions())
			return this.clicklinkexitInteraction();	
		return false;
	}


	public boolean ValidateMemberVerifyPage(String sHeader)
	{
		if(!utils.isProxyWebelement(this.titleVerificationPageName))
			return sHeader.contains(titleVerificationPageName.getText());
		return false;
	}

	public boolean Validatecheckbox( String[] mDetail)
	{
		if(mDetail[0].toLowerCase().contains("name"))
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

		if(mDetail[0].toLowerCase().contains("id"))
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

		if(mDetail[0].toLowerCase().contains("dob"))
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

		if(mDetail[0].toLowerCase().contains("ssn"))
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
		if(page[0].toLowerCase().contains("back"))
		{
			utils.gotoback();
			return true;
		}
		else
			if(page[0].toLowerCase().contains("forward"))
			{
				utils.goforward();
				return true;
			}
		if(page[0].toLowerCase().contains("refresh"))
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
		{
			if(this.btncloseConfigurationTool.isDisplayed())
			{
				return true;
			}
			System.out.println("Configuration Appears");
		}
		return true;
	}

	public boolean verifyMemberDetailsWithoutData()
	{
		boolean flag = false;	
		if(utils.clickAnelemnt(this.chkbxVerificationMembernameverify, "ProviderVerifyMember", "chkbxVerificationMembernameverify"))
			if(utils.clickAnelemnt(this.chkbxVerificationMemberDOB, "ProviderVerifyMember", "chkbxVerificationMemberDOB"))
				if(utils.clickAnelemnt(btnVerificationSubmit, "ProviderVerifyMember", "btnVerificationSubmit"))
					flag= true;

		if(flag) {
			blogger.loginfo("PASS: verifyMemberDetailsWithoutData successful");
			return true;
		}
		else {
			blogger.loginfo("FAIL: verifyMemberDetailsWithoutData not successful");
			return false;
		}
	}



}

