package automationLib;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;





public class ProviderUpdateLimitedLiability extends Driver {

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(xpath="//a[@data-test-id='2018013007443202375576']/img")
	private WebElement AddLL;




	public ProviderUpdateLimitedLiability() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Accumulators acc=new Accumulators();
	Actions action=new Actions(Driver.getPgDriver());


	/**Cliks on AddLL
	 * 
	 * @return
	 */
	public boolean clickOnAdd()
	{
		return utils.clickAnelemnt(AddLL, "UpdateLimitedLiability", "AddLL");
	}
	
	@FindBy(id="ReasonForContact")
	WebElement ReasonForContact;
	
	@FindBy(id="OtherLimitedLiability")
	WebElement OtherLimitedLiability;
	
	@FindBy(id="SpecialityType")
	WebElement SpecialityType;
	
	@FindBy(id="EffectiveDate")
	WebElement EffectiveDate;
	
	@FindBy(id="ExpiryDate")
	WebElement ExpiryDate;
	
	@FindBy(id="ProviderID")
	WebElement ProviderID;
	
	@FindBy(xpath="//*[@data-test-id='20180130153941045841510']//img")
	WebElement AddLink;
	
	@FindBy(id="DiagnosisStartRange1")
	WebElement DiagnosisStartRange1;
	
	@FindBy(id="DiagnosisEndRange1")
	WebElement DiagnosisEndRange1;
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement Submit;

	/**Fills required Values
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean requiredValuesForADDLimitedLiability() throws InterruptedException {
		if(utils.selectDropDownbyIndex(ReasonForContact, 1, "ProviderUpdateLimitedLiability", "ReasonForContact"))
			if(utils.selectDropDownbyIndex(OtherLimitedLiability, 1, "ProviderUpdateLimitedLiability", "OtherLimitedLiability"))
				if(utils.selectDropDownbyIndex(SpecialityType, 1, "ProviderUpdateLimitedLiability", "SpecialityType"))
					if(utils.enterTextinAnelemnt(EffectiveDate, "10/08/2018", "ProviderUpdateLimitedLiability", "EffectiveDate"))
						if(utils.enterTextinAnelemnt(ExpiryDate, "10/08/2018", "ProviderUpdateLimitedLiability", "ExpiryDate"))
							if(utils.enterTextinAnelemnt(ProviderID, "1234567893", "ProviderUpdateLimitedLiability", "ProviderID"))
								if(utils.clickAnelemnt(AddLink, "ProviderUpdateLimitedLiability", "AddLink"))
									if(utils.enterTextinAnelemnt(DiagnosisStartRange1, "1", "ProviderUpdateLimitedLiability", "DiagnosisStartRange1"))
										if(utils.enterTextinAnelemnt(DiagnosisEndRange1, "1", "ProviderUpdateLimitedLiability", "DiagnosisEndRange1"))
											return utils.clickAnelemnt(Submit, "ProviderUpdateLimitedLiability", "Submit");
		return false;
	}
}
