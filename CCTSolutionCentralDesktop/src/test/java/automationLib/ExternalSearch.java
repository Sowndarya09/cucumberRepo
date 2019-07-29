package automationLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ExternalSearch {
	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	static String SCid;
	public ExternalSearch() throws InterruptedException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		InteractionHeader ih=new InteractionHeader();
		Thread.sleep(5000);
		SCid=ih.getInteractionID();
		Driver.getPgDriver().switchTo().defaultContent();

		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	@FindBy(id="CcbLogEventYes")
	WebElement radioLogEvent;

	@FindBy(id="CcbOperatorId")
	WebElement txtbtOperatorId;

	@FindBy(id="CcbLocationName")
	WebElement txtbtCCBLocation;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Launch CCB']")
	private WebElement btnLaunchCCB;

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickbtnSubmit
	 * Type:Textbox

	 */

	public boolean clickbtnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "External Search", "submit btn");
	}

	public boolean clickonLaunchCCB()
	{
		return utils.clickAnelemnt(this.btnLaunchCCB, "External Search", "submit btn");
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:launchCCB
	 * #Arguments:launchCCB-KeyValuePair
	 * Type:Table
	 *Keys:id#location

	 */
	public boolean launchCCB(String[] args)
	{
		boolean returnvar ;
		returnvar = true;
		utils.clickAnelemnt(this.radioLogEvent, "ExternalSearch", "radiobtn");
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);
			if(key.toLowerCase().contains("location")){
				try{
					utils.waitforpageload();
					utils.selectDropDownbyVisibleString(this.txtbtCCBLocation, value, "External Search", "CCB location");
				}catch(Exception e)
				{
					err.logcommonMethodError("External search", "Either the element is not present or the values under the drop down are not loaded . Kindly check on the element");
				}
				continue;
			}
			else if(key.toLowerCase().contains("id")){
				try{
					utils.enterTextinAnelemnt(this.txtbtOperatorId, value, "External Search", "TextBox");
				}catch(Exception e)
				{
					utils.enterTextinAnelemnt(this.txtbtOperatorId, value, "External Search", "TextBox");
				}
				continue;}
			
			else 
				err.logcommonMethodError("ExternalSearch", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		return clickonLaunchCCB();
	}
		
	

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderES;
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyExternalSearchPage
	 * #Description:This method verifies if user is on External Search page.
	 * Type:TextBox
	 */
	public boolean verifyExternalSearchPage() throws InterruptedException{
		utils.waitforpageload();
		return utils.validateHeader(this.sHeaderES, "External Search");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on submit button in External Search screen.
	 * Type:TextBox
	 */
	public boolean clickOnSubmit(){
		return utils.clickAnelemnt(this.btnSubmit, "ExternalSearch", "Submit");
	}
	
	@FindBy(xpath="//a[text()='Anthem Blue Cross']")
	WebElement lnkAnthemBlueCross;
	
	@FindBy(xpath="//a[text()='Anthem Blue Cross and Blue Shield']")
	WebElement lnkAnthemBlueCrossAndBlueShield;
	
	@FindBy(xpath="//a[text()='Blue Cross and Blue Shield of Georgia']")
	WebElement lnkBlueCrossAndBlueShieldOfGeorgia;
	
	@FindBy(xpath="//a[text()='ESI - Medco']")
	WebElement lnkESIMedco;
	
	@FindBy(xpath="//a[text()='ESI - Medco6']")
	WebElement lnkESIMedco6;
	
	@FindBy(xpath="//a[text()='Empire Blue Cross/Empire Blue Cross Blue Shield']")
	WebElement lnkEmpireBlue;
	
	
	
	public boolean verifyExternalLinks()
	{
		return !utils.isProxyWebelement(lnkAnthemBlueCross) && !utils.isProxyWebelement(lnkAnthemBlueCrossAndBlueShield) && !utils.isProxyWebelement(lnkBlueCrossAndBlueShieldOfGeorgia) && !utils.isProxyWebelement(lnkESIMedco) && !utils.isProxyWebelement(lnkESIMedco6) && !utils.isProxyWebelement(lnkEmpireBlue);
	}
	
	
	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyExternalLinksForCashTaskl
	 * #Description:This method verifies that the external links for cash task is available.
	 */
	
	@FindBy(xpath="(//a[@data-test-id='20151230143442079611359'])[1]")
	WebElement lnkCashPro;
	
	@FindBy(xpath="(//a[@data-test-id='20151230143442079611359'])[2]")
	WebElement lnkCheckInquiry;
	
	@FindBy(xpath="(//a[@data-test-id='20151230143442079611359'])[3]")
	WebElement lnkOnDemand;
	
	@FindBy(xpath="(//a[@data-test-id='20151230143442079611359'])[3]")
	WebElement lnkPersonix;
	
	
	
	public boolean verifyExternalLinksForCashTask()
	{
		return !utils.isProxyWebelement(lnkCashPro)  && !utils.isProxyWebelement(lnkCheckInquiry) && !utils.isProxyWebelement(lnkOnDemand) && !utils.isProxyWebelement(lnkPersonix);
	}


}
