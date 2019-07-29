package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderSelectContract {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	WebDriverWait wait;

	public ProviderSelectContract() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

		Driver.getPgDriver().switchTo().defaultContent();
		//Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		utils.gotoLastIframe(iframes);
	}

	@FindBy(id = "PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;
	
	@FindBy(id="PegaGadget3Ifr")
	WebElement Iframeelement3;

	@FindBy(xpath = "//label[text()='                    Select Contract           ']")
	WebElement lblSelectContractTitle;
	@FindBy(id = "$PHCMemberPolicyList$ppxResults$l1")
	WebElement trFirstrowoftable;
	@FindBy(xpath="//button[@data-test-id='20160304053605032428479']")
	WebElement btnSubmit;
	@FindBy(xpath = "//tr[@id='$PHCMemberPolicyList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoFirstRow;
	@FindBy(xpath = "//tr[@id='$PHCMemberPolicyList$ppxResults$l1'][contains(@class,'notFocused')]")
	WebElement trFirstRowNothighlighted;

	@FindBy(xpath = "//span[@class='menu-item-title'][text()='Exit Interaction']")
	private WebElement lnkOtherActionExitInteraction;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(text(),'Other Actions')]")
	private WebElement btnOtherActions;

	@FindBy(xpath = "//span[@class='menu-item-title'][text()='Search Member']")
	private WebElement lnkOtherActionSearchMember;

	@FindBy(xpath = "//*[@class='gridTable '][@id='bodyTbl_right'][contains(@pl_prop,'HCMemberPolicyList')]")
	private WebElement tblSelectContract;

	public boolean selectfirstContract() {

			if (utils.clickAnelemnt(rdoFirstRow, "SelectContract", "Radio button -firstRowofselectContracttable"))
				return this.clickSubmit();
		return false;

	}

	/*
	 * Selecting exit intearction , Ideally to complete the test case need to
	 * use the validatePage method in teh ExitInteraction Class
	 */
	public boolean selectExitInteraction() {
		if (this.clickOtheractions())
			return this.clickExitInteraction();
		return false;
	}

	/*
	 * Selecting exit intearction , Ideally to complete the test case need to
	 * use the validatePage method in the corresponding "Searchmember" Page
	 */
	public boolean selectSearchmember() {
		if (this.clickOtheractions())
			return this.clickSearchmember();
		return false;
	}

	/*
	 * vaidating we are in teh correct page by validating the heading of the
	 * page
	 */
	public boolean validatePage() {
		return utils.validateLabel(lblSelectContractTitle, "Select");
	}

	/*
	 * Pressing enter on teh submit button
	 */
	public boolean clickSubmit() {
		utils.waitforpageload();
		utils.scrolltomiddle();
		return utils.clickAnelemnt(btnSubmit, "SelectContract", "Submit");

	}

	public boolean clickTitle() {
		return utils.clickAnelemnt(lblSelectContractTitle, "SelectContract", "Title");
	}

	public boolean clickOtheractions() {
		return utils.clickAnelemnt(this.btnOtherActions, "selectContract", "Btn Other actions");
	}

	public boolean clickExitInteraction() {
		return utils.clickAnelemnt(this.lnkOtherActionExitInteraction, "selectContract", "Btn Other actions");
	}

	public boolean clickSearchmember() {
		return utils.clickAnelemnt(lnkOtherActionSearchMember, "SelectContract", "OtheractionsSearchMember");
	}

	/*
	 * @SCU #CommonMethodwithArgument:selectContractbasedonvalues
	 * #Arguments:SelectContract-KeyValuePair Type:Table Keys:status#
	 * 
	 */

	public boolean selectContractbasedonvalues(String[] value) throws InterruptedException {
		if (this.clickTitle())
			if (utils.clickontablerowbasedonvalues(this.tblSelectContract, value))
				return this.clickSubmit();
		return false;
	}

	public boolean selectContract(String[] args) {
		int j;
		int count =0;
		ArrayList<String> list = new ArrayList<String>();
		String[] val = {"Coverage Type","Employer Group Name","Status","Relationship","Source","Product Group", "Effective Period","Product Group Number"};
		try {
			String[] value = args[2].split("/");
			for(int i=0;i<val.length;i++) {
				j = utils.getIndexValueOfStringArray(value,val[i]);
				if(j != 0) {
					list.add(value[j]);
					count++;
				}
			}
			if(count>0) {
				String[] contractvalues = new String[list.size()];
				contractvalues = list.toArray(contractvalues);
				selectContractbasedonvalues(contractvalues);

			}else {
				selectfirstContract();
			}
			return true;

		}
		catch(ArrayIndexOutOfBoundsException e) {
			selectfirstContract();
			return true;

		}
		catch(Exception e) {
			err.logError("Exception occured  "+e);
			return false;
		}
	}
	@FindBy(xpath="//div[text()='Transfer Interaction']")
	WebElement TrnsIntBtn;
	//Validates that the Transfer Interaction BTN Available at the Select Contract screen for phone call provider flow
	public boolean validateTransferInteractionBTNAvailable(){
		return !utils.isProxyWebelement(TrnsIntBtn);
	}
	//Validates that the Transfer Interaction BTN is not Available at the Select Contract screen for Research provider flow
	public boolean validateTransferInteractionBTNNotAvailable(){
		return utils.isProxyWebelement(TrnsIntBtn);
	}
	
}
