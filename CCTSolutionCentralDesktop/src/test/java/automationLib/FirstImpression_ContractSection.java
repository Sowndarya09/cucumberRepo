package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class FirstImpression_ContractSection {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;


	public FirstImpression_ContractSection() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}


	@FindBy(xpath="//span[contains(text(),'VSP PLAN A ALSO INCLUDED')]")
	WebElement contractInformationMessage;

	@FindBy(xpath="//span[contains(text(),'15E0')]")
	WebElement contractCode;

	@FindBy(xpath="//div[contains(text(),'Switch Contract Code')]")
	WebElement btnSwitchContractCode;

	@FindBy(id="SwitchContractCode")
	WebElement txtBoxEnterContractCode;

	@FindBy(id="ModalButtonSubmit")
	WebElement btnFirstImpEditSave;

	@FindBy(id="ModalButtonCancel")
	WebElement btnFirstImpEditCancel;

	/*
	 * @SCU
	 * #CommonMethodWithoutArguement: verifyContractInformationMessage
	 * #Description: This functionality verifies the the contract information message displayed in the contract section
	 * Type: Text
	 */

	public boolean verifyContractInformationMessage()
	{
		FirstImpression FI = new FirstImpression();
		FI.getContractInformationOnceGroupNameClicked();
		String ContractInformationInGroupSearch = FI.getMessageOnceGroupNameClicked();
		String ContractInformationMessageinContract = this.contractInformationMessage.getText();
		System.out.println("Contract Information Message displyed: "+ ContractInformationMessageinContract);
		return utils.isvalueMatch_contain(ContractInformationInGroupSearch, ContractInformationMessageinContract);
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArguement: verifyContractCode
	 * #Description: This functionality verifies the the contract code displayed in the contract section
	 * Type: Text
	 */
	public boolean verifyContractCode()
	{
		return utils.validateLabel(contractCode, "15E0");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSwitchContractTab
	 * #Description: This functionality performs click action on Switch Contract Tab
	 * Type: Textbox
	 */

	public boolean clickSwitchContractTab()
	{
		return utils.clickAnelemnt(btnSwitchContractCode, "FirstImpression_Contract", "Switch Contract Code");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterSwitchContractCode
	 * #Description: This functionality enters the contract code to switch the contract code in the alert under the Contract Section.
	 * #Argument: contractcode
	 * Type: Textbox
	 */
	public boolean enterSwitchContractCode(String[] contractcode)
	{
		return utils.enterTextinAnelemnt(txtBoxEnterContractCode, contractcode[0],"FirstImpression_Contract", "Entering Switch Contract Code");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickSaveContractCode
	 * #Description: This functionality performs click action on Save button on the switch contract code alert section.
	 * Type: Textbox
	 */
	public boolean clickSaveContractCode()
	{
		return utils.clickAnelemnt(btnFirstImpEditSave, "FirstImpression_Composite", "Save Button");
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickCancelContractCode
	 * #Description: This functionality performs click action on cancel button on the switch contract code alert section.
	 * Type: Textbox
	 */
	public boolean clickCancelContractCode()
	{
		return utils.clickAnelemnt(btnFirstImpEditCancel, "FirstImpression_Composite", "Cancel Button");
	}

}
