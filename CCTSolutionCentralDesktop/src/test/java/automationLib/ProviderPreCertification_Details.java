package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ProviderPreCertification_Details
{
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	public ProviderPreCertification_Details()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(xpath="//*[text()='Procedure']/ancestor::table[@id='gridLayoutTable']")
	WebElement PreCertDetailsTable;
	public boolean validateUMRuleDetailsTable(String[] tablevalues) {
		return utils.validatetablerowbasedonvalues(PreCertDetailsTable, tablevalues);
	}

	@FindBy(xpath="//div[@class='smarttip-content']")
	WebElement HoverText;

	/**This functionality validates the Provider Specialty code Description on hover in Precertification Details Page
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean validateHoverTextInProviderSpecialtyCodeDescription(String[] args) throws InterruptedException {
		String[] tablevalues = args[0].split(",");
		WebElement row = utils.returntablerowbasedonvalues(PreCertDetailsTable, tablevalues);
		WebElement rowNo = row.findElement(By.xpath(".//td[7]//span"));
		rowNo.click();
		Thread.sleep(1000);
		String text = HoverText.getText();
		System.out.println(text);
		return utils.isvalueMatch_contain(text, args[1]);
	}

	@FindBy(xpath="//div[@id='modaldialog_con']")
	WebElement PopUp;

	/**This method Search and click the Diagnosis Class Code entered in Text Box at Pre-Certification Details page
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickOnDiagnosisClassCode(String[] args) throws InterruptedException {
		String[] diagnosisclasscode = ("Diagnosis Class:"+args[0]).split(",");
		WebElement row = utils.returntablerowbasedonvalues(PreCertDetailsTable, diagnosisclasscode);
		WebElement rowNo = row.findElement(By.xpath(".//td//a[@data-test-id='20180801235628094785528']"));
		rowNo.click();
		Thread.sleep(1000);
		return !utils.isProxyWebelement(PopUp);
	}

	@FindBy(xpath="//div[text()='Diagnosis Code']/ancestor::table[@id='bodyTbl_right']")
	WebElement DiagnosisCodeTable;
	
	@FindBy(xpath="//div[text()='Code Range']/ancestor::table[@id='bodyTbl_right']")
	WebElement ClassCodeDetailsTable;

	/**This method validates the Diagnosis Class Code values entered in Diagnosis Class Code pop-up at Pre-Certification Details page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateDiagnosisClassCodeValuesInPopup(String[] args) {
		boolean flag = false;

		for(int i=0;i<args.length;i++) {
			String[] diagnosisclasscode = ("Diagnosis Code:"+args[i]).split(",");
			flag = utils.validatetablerowbasedonvalues(DiagnosisCodeTable, diagnosisclasscode);
			if(!flag)
				return false;
		}
		return true;
	}
	
	/**This method Search and click the Limit Class Code entered in Text Box at Pre-Certification Details
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickLimitClassCode(String[] args) throws InterruptedException {
		String[] diagnosisclasscode = ("Limit Class Low-High:"+args[0]).split(",");
		WebElement row = utils.returntablerowbasedonvalues(PreCertDetailsTable, diagnosisclasscode);
		WebElement rowNo = row.findElement(By.xpath(".//td//a[@data-test-id='20171107164512062893531']"));
		rowNo.click();
		Thread.sleep(1000);
		return !utils.isProxyWebelement(PopUp);
	}
	
	/**This functionality validates the Limit Class Code table values at Pre-Certification Details page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateLimitClassCodeValuesInPopup(String[] args) {
		return utils.validatetablerowbasedonvalues(DiagnosisCodeTable, args);

	}
	
	/**This method Search and click the Service Class Code entered in Text Box at Pre-Certification Details page
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickOnServiceClassCode(String[] args) throws InterruptedException {
		String[] diagnosisclasscode = ("Service Class Low-High:"+args[0]).split(",");
		WebElement row = utils.returntablerowbasedonvalues(PreCertDetailsTable, diagnosisclasscode);
		WebElement rowNo = row.findElement(By.xpath(".//td//a[@data-test-id='20171107164512062896588']"));
		rowNo.click();
		Thread.sleep(1000);
		return !utils.isProxyWebelement(PopUp);
	}
	
	/**This method Search and click the Procedure Class Code entered in Text Box at Pre-Certification Details
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateServiceClassCodeValuesInPopup(String[] args) {
		return utils.validatetablerowbasedonvalues(ClassCodeDetailsTable, args);

	}
	
	/**This method Search and click the Procedure Class Code entered in Text Box at Pre-Certification Details page
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickOnProcedureClassCode(String[] args) throws InterruptedException {
		String[] diagnosisclasscode = ("Procedure Class:"+args[0]).split(",");
		WebElement row = utils.returntablerowbasedonvalues(PreCertDetailsTable, diagnosisclasscode);
		WebElement rowNo = row.findElement(By.xpath(".//td//a[@data-test-id='20180802000648071588944']"));
		rowNo.click();
		Thread.sleep(1000);
		return !utils.isProxyWebelement(PopUp);

	}
	
	@FindBy(xpath="//div[text()='Procedure Code']/ancestor::table[@id='bodyTbl_right']")
	WebElement ProcedureCodeTable;
	
	/**This method validates the Procedure Class Code values entered in Procedure Class Code Pop-up at Pre-Certification Details page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateProcedureClassCodeValuesInPopup(String[] args) {
		boolean flag = false;

		for(int i=0;i<args.length;i++) {
			String[] diagnosisclasscode = ("Procedure Code:"+args[i]).split(",");
			flag = utils.validatetablerowbasedonvalues(ProcedureCodeTable, diagnosisclasscode);
			if(!flag)
				return false;
		}
		return true;

	}
	

	@FindBy(xpath="//img[@src='webwb/tool_icon_13690228252.png!!.png']")
	WebElement wrenchicon;
	public boolean validateWrenchIconIsNotPresent()
	{
		return utils.isProxyWebelement(wrenchicon);
	}
	
	public boolean validateWrenchIconIsPresent()
	{
		return !utils.isProxyWebelement(wrenchicon);
	}
   
	@FindBy(xpath="//div[text()='Submit']")
	WebElement submit;
	public boolean clickSubmit()
	{
		return utils.clickAnelemnt(submit,"ProviderPrecertification_Details","submit");
	}

}
