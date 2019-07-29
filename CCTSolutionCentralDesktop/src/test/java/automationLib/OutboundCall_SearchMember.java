package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class OutboundCall_SearchMember {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;


	public OutboundCall_SearchMember(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement);
	}

	@FindBy(id="MemberSearchTypeMember ID")
	WebElement rBtnMID;

	@FindBy (id="SearchStringMemberID")	
	WebElement txtbxMemberID;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Search']")	
	WebElement btnSearchforMSearch;

	/**This functionality Searches for the member using the member ID given by the user. This functionality  clicks on the search by member id radio, enters the member id and clicks on search button
	 * 
	 * @param sMemberID
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchbyMemberID(String[] sMemberID) throws InterruptedException
	{
		if(utils.clickAnelemnt(rBtnMID, "OutboundCall_SearchMember", "Radio MemberId"))
			if(utils.enterTextinAnelemnt(txtbxMemberID, sMemberID[0], "OutboundCall_SearchMember", "Text Box SubscriberID"))
				return utils.clickAnelemnt(btnSearchforMSearch, "OutboundCall_SearchMember", "Button Search");

		return false;
	}

	@FindBy(xpath= "//*[@id='$PHCMemberContactList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstMemberRow;

	@FindBy (xpath="//*[@class='pzbtn-mid'][text()='Submit']")	
	private WebElement btnSubmit;

	/**This functionality selects the first member row in the member search result table
	 * 
	 * @return
	 */
	public boolean selectfirstMember(){
		return utils.clickAnelemnt(rdoFirstMemberRow, "SelectMember", "Radio button -	firstRowofselectMembertable");	
	}

	@FindBy (id="Nickname")	
	private WebElement txtbxNickName;

	@FindBy (id="CallBackNumber")	
	private WebElement txtbxCallBackNumber;

	@FindBy(id="TCPAResponseAccept")
	WebElement radioBestNumberAccept;

	@FindBy(id="TCPAResponseDecline")
	WebElement radioDeclineNumberAccept;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Guest Contact']")	
	WebElement GuestContact;

	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Other actions') or contains(text(),'Other Actions')]")
	WebElement OtherActions;

	/**This functionality enters the nickname as 'Nickname' and phone number as '1234567890' given by the user
	 * 
	 * @return
	 */
	public boolean fillNicknameandextension(){

		if(utils.enterTextinAnelemnt(txtbxNickName, "NickName", "Phone Call", "Text Box NickName"))
			if (utils.enterTextinAnelemnt(txtbxCallBackNumber, "0123654789", "Phone Call", "Text Box Call Back No."))
				return utils.clickAnelemnt(this.radioBestNumberAccept, "Phone Call-Member Search", "Accept best phone radio");
		return false;
	}

	@FindBy(xpath="//div[@id='DialogContent']")
	WebElement DialogContent;

	/**This functionality verifies the expected guided dialog text present in member search page for outbound interaction
	 * 
	 * @return
	 */
	public boolean verifyTheguidedDialogTextInMemberSearch() {
		return !utils.isProxyWebelement(DialogContent);
	}

	/**This functionality Validates whether Guestcontact  is not present in Other actions dropdown box of the search member page
	 * 
	 * @return
	 */
	public boolean validateWhetherTheGuestContactIsNotDisplayedInOtherActions() {
		if(utils.clickAnelemnt(OtherActions, "", "OtherActions"))
			return utils.isProxyWebelement(GuestContact);
		return false;
	}


	@FindBy(id="IsContactMemberYes")
	private WebElement rBtnContactMemberYes;

	@FindBy(id="IsContactMemberNo")
	private WebElement rBtnContactMemberNo;

	@FindBy(xpath="//span[@class='iconRequired Standard_iconRequired'][contains(text(),'Is Contact the')]")
	WebElement  labelIscontacttheselected;

	public boolean clickrbtnPhoneMemberContactmemberYes()
	{
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("window.scrollBy(0,900)","");
		return utils.clickAnelemnt(this.rBtnContactMemberYes, "Phone Call", "Radio Button for Contact Member yes");
	}

	public boolean clickrbtnPhoneMemberContactmemberNo()
	{
		JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
		jse.executeScript("window.scrollBy(0,450)","");
		return utils.clickAnelemnt(rBtnContactMemberNo, "Phone Call", "Radio Button for Contact Member no");
	}
	
	
	@FindBy(id="IsConnectedToMemberYes")
	private WebElement rBtnConnectMemberYes;
	
	
	public boolean clickrbtnConnectWithMemberYes() throws InterruptedException
	{
		utils.waitforpageload();
		if(!utils.isProxyWebelement(rBtnConnectMemberYes))
			return utils.clickAnelemnt(this.rBtnConnectMemberYes, "Phone Call", "Radio Button for Contact Member yes");
		else
		{
			JavascriptExecutor jse = (JavascriptExecutor)Driver.pgDriver;
			jse.executeScript("window.scrollBy(0,900)","");
			return utils.clickAnelemnt(this.rBtnConnectMemberYes, "Phone Call", "Radio Button for Contact Member yes");
		}
	} 


	/**This functionality Select yes or no from the select contract member option based on the user input
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectContactMemberYesOrNo(String[] args) {
		if(args[0].equalsIgnoreCase("Yes")) 
			return clickrbtnPhoneMemberContactmemberYes();
		else
			return clickrbtnPhoneMemberContactmemberNo();
	}

	@FindBy(xpath="//*[text()='HIPAA Verification']")
	WebElement labelHippaVerification;

	/**This functionality verifies the HIPAA verification section is displayed...OutboundCall_SearchMember
	 * 
	 * @return
	 */
	public boolean verifyHIPAAVerificationIsDisplayedInMemberSearch()
	{
		return !utils.isProxyWebelement(labelHippaVerification);
	}

	@FindBy(id="IsMemberNameVerified")
	WebElement chckBxName;

	@FindBy(id="IsMemberIDVerified")
	WebElement chckBxMemberId;

	@FindBy(id="IsDateOfBirthVerified")
	WebElement chckBxDOB;


	@FindBy(id="IsPhoneNumberVerified")
	WebElement chckBxPhone;

	public boolean ValidateDetailsPresent(){
return !utils.isProxyWebelement(chckBxName);
	}

	public boolean clickchkbxVerificationMembernameverify(String[] membername) {
		return utils.clickAnelemnt(chckBxName, "SelectAssociatedContact", "Member name verify checkbox");
	}

	public boolean clickchkbxVerificationMemberidverify(String[] memberid) {
		return utils.clickAnelemnt(chckBxMemberId, "SelectAssociatedContact", "Member id verify checkbox");
	}

	public boolean clickchkbxVerificationMemberDOB (String[] DOB){
		return (utils.clickAnelemnt(chckBxDOB, "SelectAssociatedContact", "Member DOB verify checkbox"));
	}


	public boolean clickchkbxVerificationMemberphone (String[] phone){
		return (utils.clickAnelemnt(chckBxPhone, "SelectAssociatedContact", "Member {hone verify checkbox"));
	}

	/**This functionality selects the HIPAA details by clicking on the check box
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectHIPAAverificationDetails(String[] args) {
		utils.waitforpageload();
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
							return true;
						}
						continue;
					}
					else
						break;
				}

				else 
				{
					err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
				}

			}


			err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
			return false;
		}


		err.logcommonMethodError("SelectAssociatedContact", "selectHIPAAverificationDetails");
		return false;


	}

	/**This functionality clicks on the submit button in the Outbound Call page
	 * 
	 * @return
	 */
	public boolean selectSubmit() {
		return utils.clickAnelemnt(btnSubmit, "Research Member", "Submit");
	}


	
	
	public boolean searchAndSubmitOutboundMember(String[] args) throws InterruptedException {
		Boolean flag = false;
		try {
			String[] value = args[2].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			if(searchbyMemberID(memberid)) {
				int i = utils.getIndexValueOfStringArray(value,"MemberFirstName");
				if(i != 0) {
					String[] firstname = value[i].substring(value[i].indexOf(":")+1).split(",");
					flag = selectMemberbyFirstName(firstname);
				}else {
					flag = selectfirstMember();
				}
				if(flag)
					if(fillNicknameandextension())
						if(clickrbtnConnectWithMemberYes())
							if(clickrbtnPhoneMemberContactmemberYes())
							if(selectHIPAAverificationDetails())
								return selectSubmit();
			}
			return false;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			String[] value = args[1].split("/");
			int j = utils.getIndexValueOfStringArray(value,"MemberID");
			String[] memberid = value[j].substring(value[j].indexOf(":")+1).split(",");
			if(searchbyMemberID(memberid)) {
				int i = utils.getIndexValueOfStringArray(value,"MemberFirstName");
				if(i != 0) {
					String[] firstname = value[i].substring(value[i].indexOf(":")+1).split(",");
					flag = selectMemberbyFirstName(firstname);
				}else {
					flag = selectfirstMember();
				}
				if(flag)
					if(fillNicknameandextension())
						if(clickrbtnConnectWithMemberYes())
						if(clickrbtnPhoneMemberContactmemberYes())
							if(selectHIPAAverificationDetails())
								return selectSubmit();
			}
			return false;

		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}
	}
	
	public boolean selectHIPAAverificationDetails()
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.chckBxName, "PhoneCallMemberSearchMember", "Member name verify checkbox"))
			if(utils.clickAnelemnt(this.chckBxDOB, "PhoneCallMemberSearchMember", "Member DOB verify checkbox"))
				if(chckBxName.isSelected() && chckBxMemberId.isSelected() && chckBxDOB.isSelected()) {
					return true;
				}
				else {
					if(!chckBxName.isSelected())
						utils.clickAnelemnt(this.chckBxName, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					if(!chckBxMemberId.isSelected() && chckBxMemberId.isEnabled())
						utils.clickAnelemnt(this.chckBxMemberId, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					if(!chckBxDOB.isSelected())
						utils.clickAnelemnt(this.chckBxDOB, "PhoneCallMemberSearchMember", "Member name verify checkbox");
					return chckBxName.isSelected() && chckBxDOB.isSelected();
				}

		return false;

	}
	
	@FindBy(xpath="//table[contains(@pl_prop,'HCMemberContactList.pxResults')]")
	private WebElement searchResulttable;
	
	public boolean selectMemberbyFirstName(String[] args) throws InterruptedException {
		List<WebElement> rowCol = null;
		utils.waitforpageload();
		String[] ar = ("First Name:"+args[0]).split("-");
		WebElement tablerow = utils.returntablerowbasedonvalues(searchResulttable, ar);
		rowCol = tablerow.findElements(By.xpath(".//input[@type='radio']"));
		return utils.clickAnelemnt(rowCol.get(0), "Select Member", "Radio Button");
	
	}

	
}
