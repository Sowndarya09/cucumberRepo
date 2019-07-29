package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class SecureMessageMember_SelectContract {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	WebDriverWait wait;

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;
	/**
	 * Constructer for the Create Promised Action class defining the Iframe and the Page Factory  
	 * @throws IOException 
	 */
	public SecureMessageMember_SelectContract() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver

	}

	@FindBy(className="anthem_theme_header")
	private WebElement sHeaderSelectContract;

	@FindBy(xpath="//*[text()='Select Contract']")
	WebElement labelSelectContractHeader;

	@FindBy(id="SecureMessageRefNum")
	WebElement txtBxRefNum;

	@FindBy(xpath="//table[@pl_prop='HCMemberPolicyList.pxResults']")
	WebElement tblSelectContract;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;


	@FindBy (id="Nickname")	
	private WebElement txtbxNickName;
	@FindBy (id="CallBackNumber")	
	private WebElement txtbxCallBackNumber;
	@FindBy (id="CallBackNumExt")	
	private WebElement txtbxCallBackNumExt;
	@FindBy (id="pyFirstName")
	private WebElement txtbxOtherActionsGuestFirstName;

	@FindBy(xpath="//tr[@id='$PHCMemberPolicyList$ppxResults$l1']//input[@id='CaseOrTaskIcon']")
	WebElement rdoBtnFirstRow;




	public boolean validateIfContractSelectionScreenAppears()
	{
		return !utils.isProxyWebelement(labelSelectContractHeader);
	}


	public boolean validateSecureMessageRefNuminSelectContract(String[] args)
	{
		String actualText= args[0];
		String expectedText = txtBxRefNum.getAttribute("value");
		return utils.isvalueMatch_contain(actualText, expectedText);

	}

	public boolean validateIfCertainFieldsAreNotPresent()
	{
		return utils.isProxyWebelement(txtbxNickName) && utils.isProxyWebelement(txtbxCallBackNumber) && utils.isProxyWebelement(txtbxCallBackNumExt);
	}

	public boolean selectSubmit()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(btnSubmit, "SecureMessageMember_SelectContract", "Submit");
	}

	public boolean selectfirstContract()
	{
		return utils.clickAnelemnt(rdoBtnFirstRow, "SecureMessageMember_SelectContract", "First Contract");
	}


   
@FindBy(xpath="//div[@id='DialogContent']")
WebElement labelGuidedDialog;

	public boolean validateGuidedDialog(String[] args){
		String message=labelGuidedDialog.getText().replaceAll("\n", "");
		return utils.isvalueMatch_contain(message, args[0]);
	}
	
	
	
}




 























