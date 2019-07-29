package automationLib;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class LimitedLiabilityReview extends Driver
{
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderLL;
	@FindBy(xpath="//Select[@id='ReasonForContact']")
	private WebElement RsnFrContact;
	@FindBy(xpath="//textarea[@id='Notes']")
	private WebElement notes;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	WebElement BtnSubmit;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='View Limited Liability']")	
	private WebElement lnkOtherViewLL;
	@FindBy (xpath="//li[@title='Request Manager/OE Help']")	
	private WebElement lnkOtherReqMgrHelp;
	@FindBy (xpath="//*[@class='menu-item-title'][text()='Update Limited Liability']")	
	private WebElement lnkOtherUpdtLL;

	public LimitedLiabilityReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}

	DataSet ds=new DataSet();
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Accumulators acc=new Accumulators();
	Actions action=new Actions(Driver.getPgDriver());

	public WebElement getHeader()
	{
		return sHeaderLL;
	}

	public boolean selectDropdownReasonForContact(String sReason)
	{
		return utils.selectDropDownbyVisibleString(this.RsnFrContact, sReason, "Limited Liability Review ", "Drop Down to select the value");
	}

	public boolean setTxtNotes(String notes)
	{
		return utils.enterTextinAnelemnt(this.notes, notes, "Limited Liability Review ", "Text Box for entering ?Notes");

	}

	public boolean clickBtnSubmit()
	{
		utils.waitforpageload();
		if(utils.clickAnelemnt(this.BtnSubmit, "Limited Liability Review", "Submit Button"))
			return isMemberCompositeReached();
		return false;
	}

	public boolean validateHeader(WebElement header)
	{
		utils.waitforpageload();
		if(header.isDisplayed())
		{
			if(header.getText().trim().equalsIgnoreCase("Limited Liability Review"))
			{
				System.out.println("Pass : The header matches the specks and is displayed as required. \n\n");
				return true ;
			}
		}
		err.logError("The header does not match the specified text.");
		return false; 
	}

	public boolean LimitedLiabilityReviewandSubmit_Explain_how_claim_processed()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Explain how claim processed"))
				if(this.setTxtNotes("Test"))	
					return this.clickBtnSubmit();
		return false ;
	}

	public boolean LimitedLiabilityReviewandSubmit_Explain_letter_payment_received()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Explain this letter or payment received"))
				if(this.setTxtNotes("Test"))	
					return this.clickBtnSubmit();
		return false ;
	}

	public boolean LimitedLiabilityReviewandSubmit_Provide_additional_info()
	{
		if(this.validateHeader(this.getHeader()))
			if(this.selectDropdownReasonForContact("Provide additional information"))
				if(this.setTxtNotes("Test"))	
					return this.clickBtnSubmit();
		return false ;
	}

	public boolean navigatetoViewLimitedLiability()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Limited Liability Review", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOtherViewLL, "Limited Liability Review", " View Limited Liability");
		return false;

	}

	public boolean navigatetoUpdateLimitedLiability()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Limited LiabilityLiability", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherUpdtLL, "Limited Liability Review", "Update Limited Liability"))
				return utils.validateHeader(this.getHeader(),"Update Limited Liability");
		return false;
	}

	public boolean navigatetoRequestManagerHelp()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Limited Liability Review", "Other Actions button"))
			if(utils.clickAnelemnt(this.lnkOtherReqMgrHelp, "Limited Liability Review", "Request Manager Help"))
				return true;
		return false;
	}

	/**This method is to calculate whether Notes section can have upto 500 charcs
	 * 
	 * @return
	 */
	public boolean validateLimitedLiabReviewNotes500chars()
	{
		String actual=notes.getAttribute("maxlength");
		return utils.isvalueMatch_contain(actual, "3000");
	}

	@FindBy (xpath="//span[text()='Update Limited Liability' and text()!='Update Limited Liability Review']")	
	private WebElement renameUpdateLL;

	@FindBy(xpath="//td[2]/input[contains(@id, 'PTaggedLimitedLiabilities')]/../../descendant::span[@data-hover]")
	private WebElement hoverType;

	@FindBy(xpath="//span[contains(text(),'Update Limited Liability')]")
	private WebElement updateLLTable;


	public boolean verifyRenameReviewSection(){
		try{
			Driver.pgDriver.findElement(By.xpath("//span[text()='Update Limited Liability' and text()!='Update Limited Liability Review']"));
			return true;
		}
		catch(NoSuchElementException e){
			err.logcustomerrorwithmessage("Limited Liability Review", "verifyRenameReviewSection","Update limited liability rename is not successful");
			return false;
		}
	}

	public boolean verifyCollapseUpdateLimitedLiabilityPageGrid(){
		try{
			Driver.pgDriver.findElement(By.xpath("//div[@title='Disclose Update Limited Liability']/following-sibling::div/span[text()='Update Limited Liability']"));
			return true;
		}
		catch(NoSuchElementException e){
			err.logcustomerrorwithmessage("Limited Liability Review", "verifyCollapseUpdateLimitedLiabilityPageGrid","Update limited liability grid is not collapsed by default");
			return false;
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyHoverTextForTypeColumn
	 * #Description:This method validates the the hover text is getting displayed for the type column under update limited liability filed
	 * Type:Textbox
	 */
	public boolean verifyHoverTextForTypeColumn(String text){
		try{
			utils.clickAnelemnt(updateLLTable, "Limited Liability Review", "Update Limited Liability table");
			this.hoverType.click();
			String hovertext=this.hoverType.getAttribute("data-hover").toString().toLowerCase();
			System.out.println(hovertext);
			if(hovertext.equalsIgnoreCase(text)){
				blogger.loginfo("verifyHoverTextForTypeColumn successful in Limited Liability Review page");
				return true;
			}else{
				blogger.loginfo("HoverText isnt displayed for type column in Limited Liability Review page");
				return false;
			}
		}catch(Exception e){
			err.logcommonMethodError("Limited Liability Review","verifyHoverTextForTypeColumn"+e);
			blogger.loginfo("Exception occured in Limited Liability Review - verifyHoverTextForTypeColumn"+e);
			return false;
		}
	}
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;
	
	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;
	
	public boolean isMemberCompositeReached(){
		utils.waitforpageload();
		try {
			utils.gotoLastIframe(iframes);
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			err.logError(e, "unhandled  alert error in switiching frame");
			e.printStackTrace();
		}
		return !utils.isProxyWebelement(tabMbrCompositeMember);
		
	}

}
