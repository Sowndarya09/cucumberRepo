package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderManageAuthorizationReview {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	public ProviderManageAuthorizationReview()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyManageAuthorizationReviewPage
	 * #Description:This functionality verifies user is in Manage Authorization Review Page.
	 * Type:Textbox
	 */
	public boolean verifyManageAuthorizationReviewPage(){
		utils.waitforpageload();
		return utils.validateHeader(this.sHeaderManageAuthorizationReview, "Manage Authorization Review");
	}

	@FindBy(id="REASONFORSR")
	private WebElement reasonForContact;

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectReasonForContact
	 * #Description:This functionality selects the value in the Reason For Contact drop down.
	 * #Arguments:ReasonForContact
	 * Type:Dropdown
	 * Keys:Select#Check status on approved authorization#Check status on closed authorization#Check status on denied authorization#Check status on open authorization#Check status on pending authorization
	 */
	public boolean selectReasonForContact(String[] args){
		return utils.selectDropDownbyVisibleString(this.reasonForContact, args[0], "ManageAuthorizationReview", "Reason for Contact");
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Grievance and App...']")	
	private WebElement lnkOtherRequestGandA;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Request Manager Help']")	
	private WebElement lnkOtherReqMgrHelp;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderManageAuthorizationReview;

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement3;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionsRequestGrievanceandAppeals
	 * #Description: This method clicks on Other Actions and selects Request Grievance and Appeals link
	 * Type:Textbox
	 */
	public boolean clickOtherActionsRequestGrievanceandAppeals(){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageAuthorizationReview", "Other Actions button"))
		{
			if(utils.clickAnelemnt(this.lnkOtherRequestGandA, "ManageAuthorizationReview", "Request Grievance and Appeals"))
			{
				utils.waitforpageload();
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.getPgDriver().switchTo().frame(this.Iframeelement3);
				if(utils.validateHeader(this.sHeaderManageAuthorizationReview,"Grievance and Appeals"))
					return true;
			}
		}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActionsDoesntDisplayRequestGA
	 * #Description: This method clicks on Other Actions and verifies no Request Grievance and Appeals link is displayed
	 * Type:Textbox
	 */
	public boolean verifyOtherActionsDoesntDisplayRequestGA(){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageAuthorizationReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherRequestGandA, "ManageAuthorizationReview", "Request Grievance and Appeals")){
				utils.waitforpageload();
				return !utils.validateHeader(this.sHeaderManageAuthorizationReview,"Grievance and Appeals");
			}
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOtherActionRequestManagerHelp
	 * #Description:This method clicks on Other Action and select Request Manager Help 
	 * Type:Textbox
	 */
	public boolean clickOtherActionRequestManagerHelp(){
		if(utils.clickAnelemnt(this.btnOtherActions, "ManageAuthorizationReview", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherReqMgrHelp, "ManageAuthorizationReview", "Request Manager Help"))
				return utils.validateHeader(this.sHeaderManageAuthorizationReview,"Request Manager Help");
		return false;
	}

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in 'Manage Authorization Review' page.
	 * Type:TextBox
	 */
	public boolean clickOnSubmit(){
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.btnSubmit,"ManageAuthorizationReview","Submit Button");
	}

	@FindBy(xpath="//span[text()='Items Reviewed During Manage Authorization Review']")
	private WebElement ItemsDiscussedForManageAuthorizationReview;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnItemsDiscussed
	 * #Description:This functionality clicks on 'Items Reviewed During Manage Authorization Review' in Manage Authorization Review Page.
	 * Type:Textbox
	 */
	public boolean clickOnItemsDiscussed(){
		return utils.clickAnelemnt(this.ItemsDiscussedForManageAuthorizationReview, "ManageAuthorizationReview", "Items Reviewed During Manage Authorization Review");
	}

	@FindBy(xpath="//table[@pl_prop='.ReviewedAuthorizations']")
	private WebElement AuthorizationDiscussedTable;

	@FindBy(xpath="//span[contains(text(),'Items Reviewed During Manage Authorization Review')]")
	WebElement lnkItemsReviewed;

	public boolean clickItesmReviewed()
	{
		return utils.clickAnelemnt(this.lnkItemsReviewed, "ProviderManageAuthorizationReview", "Link");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:validateAuthorizationDiscussedTagged
	 * #Description:This functionality validates the Authorization number tagged or reviewed.
	 * #Argument:AuthorizationNumberTagged
	 * Type:Table
	 * Keys:Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean validateAuthorizationDiscussedTagged(String[] args) throws InterruptedException 
	{
		try{
			this.clickItesmReviewed();
			WebElement row =utils.getProviderResultsBasedOnValues(this.AuthorizationDiscussedTable,args);
			row.findElement(By.xpath(".//td[@tabindex='0']//img")).click();		
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input AuthorizationNumber" + e);
			return false;
		}
		return true;
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument:validateAuthorizationNumberWithGATagged
	 * #Description:This method validates the Authorization Number tagged with GA Indicator checked
	 * #Argument:AuthorizationNumberTagged
	 * Type:Table
	 * Keys:Authorization Number#Authorization Type#Requesting Provider#Service Provider Location#Status#Status Date
	 */
	public boolean validateAuthorizationNumberWithGATagged(String[] args) throws InterruptedException 
	{
		try{
			WebElement row =utils.getProviderResultsBasedOnValues(this.AuthorizationDiscussedTable,args);
			row.findElement(By.xpath(".//td[@headers='a2']//img")).click();
		}
		catch (Exception e){
			System.out.println("Entire row not matching for given input AuthorizationNumber" + e);
			return false;
		}
		return true;
	}

	@FindBy(xpath="//table[@id='ERRORTABLE']//td//span[@id='ERRORMESSAGES_ALL']//li")
	private WebElement errGAText;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateGAMsgInManageAuthorizationReview
	 * #Description:This method validates message displayed when user submits with 'Grievance and Appeals Indicator' checked, but user doesnt launch 'Grievance and Appeals' task
	 * Type:Textbox
	 */
	public boolean validateGAMsgInManageAuthorizationReview(){
		try{
			String errGAText=this.errGAText.getText().trim();
			System.out.println(errGAText);
			if(errGAText.equalsIgnoreCase("No GandA Launch:You have tagged 'Member has requested a Grievance or Appeal' for Pre-Authorization(s) or Referral(s) but have not opened a Grievance and Appeal Task. Open the Grievance and Appeal task from the other actions or uncheck the respective Pre-Authorization(s) or Referral(s) from having 'Grievance or Appeal' from 'View Authorization' screen and click Submit.")){
				blogger.loginfo("validateGAMsgInManageAuthorizationReview successful in Manage Authorization Review page");
				return true;
			}else{
				err.logcommonMethodError("validateGAMsgInManageAuthorizationReview","Expected GA message doesnt match in Manage Authorization Review page");
				return false;
			}
		}catch(Exception e){
			err.logcommonMethodError("Manage Authorization Review","validateGAMsgInManageAuthorizationReview"+e);
			blogger.loginfo("Exception occured in Manage Authorization  Review- validateGAMsgInManageAuthorizationReview"+e);
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyOtherActionsDoesntDisplayRequestGAForProvider
	 * #Description: This method clicks on Other Actions and verifies no Request Grievance and Appeals link is displayed
	 * Type:Textbox
	 */
	public boolean verifyOtherActionsDoesntDisplayRequestGAForProvider(){

		if(utils.clickAnelemnt(this.btnOtherActions, "ManageAuthorizationReview", "Other Actions button"))
			return utils.isProxyWebelement(lnkOtherRequestGandA);
		return false;
	}
}
