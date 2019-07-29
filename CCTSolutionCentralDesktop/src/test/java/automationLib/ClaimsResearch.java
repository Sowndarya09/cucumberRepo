package automationLib;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ClaimsResearch {



	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	public ClaimsResearch()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	@FindBy(xpath="//span[@data-test-id='20180718183035041623107']")
	WebElement labelStatus;

	@FindBy(xpath="//span[@data-test-id='20180718183035041724296']")
	WebElement labelActionCode;

	@FindBy(xpath="//span[@data-test-id='2018071818303504172566']")
	WebElement labelRejectReason;

	@FindBy(xpath="//table[@pl_prop='D_OtherInsurance.pxResults']")
	WebElement tblUpdateOtherInsuranceinClaimsSearch;

	@FindBy(id="MemberHasOtherCoverageYes")
	WebElement rdoBtnYesInMemberHasCoverage;

	@FindBy(id="MemberHasOtherCoverageNo")
	WebElement rdoBtnNoInMemberHasCoverage;

	@FindBy(id="IsOtherCoverage")
	WebElement drpDownIsOtherCoverage;

	@FindBy(xpath="//span[starts-with(text(),'Submit this request')]")
	WebElement labelStaticMessageForMemberHasNoCovergae;

	@FindBy(xpath="//span[starts-with(text(),'The other insurance')]")
	WebElement labelStaticMessageForPrimaryCoverage;

	@FindBy(xpath="//span[starts-with(text(),'Submit this request')]")
	WebElement labelStaticMessageForSecondaryMessage;

	@FindBy(xpath="//span[starts-with(text(),'Verify with the contact')]")
	WebElement labelNotListedStaticMessage;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;

	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;


	public boolean verifyTheStatusAndActionCodeAndRejectReason(String[] args)
	{
		System.out.println("Entered into the method");
		utils.waitforpageload();
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("verifyClaimDetails", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + " " + "value  " + value);
			if(utils.isvalueMatch_contain(key,"Status")){

				returnvar = utils.validateLabel(this.labelStatus,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Action Code")){

				returnvar = utils.validateLabel(this.labelActionCode,value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Reject Reason")){	
				returnvar = utils.validateLabel(this.labelRejectReason,value);
				continue;
			}
			else 
				err.logcommonMethodError("ClaimsResearch", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}	
		if(returnvar)
		{
			System.out.println("Rejected Claim Details verified successfully");
			return true;	
		}
		else
		{
			int tot_i=args.length;
			err.logcommonMethodError("ClaimsResearch", "the value "+args[tot_i-1].toString()+" doesnt match with the one in application");
			return false;
		}
	}


	public boolean validateOtherInsuranceColumnHeadersGrid()
	{

		ArrayList<String> valuesFromApp = new ArrayList<String>();
		valuesFromApp = utils.getheaderrowFromTable(this.tblUpdateOtherInsuranceinClaimsSearch);
		System.out.println("Values from the App: "+ valuesFromApp);
		ArrayList<String> valuesGivenManual = new ArrayList<String>();
		valuesGivenManual.add("");
		valuesGivenManual.add("Type");
		valuesGivenManual.add("Effective Date");
		valuesGivenManual.add("End Date");
		valuesGivenManual.add("Reason Code");
		valuesGivenManual.add("Description");
		System.out.println("Values Given Manually: "+valuesGivenManual);
		if(valuesFromApp.equals(valuesGivenManual))
		{
			System.out.println("Values Matched");
			blogger.loginfo("Table Headers Matched");
			return true;
		}
		else
		{
			System.out.println("Values doesnt Matched");
			blogger.loginfo("Table Headers doesn't Matched");
			return false;
		}
	}


	public boolean selectMemberHasOtherCoverage(String[] args)
	{
		if(args[0].contains("Yes"))
			return utils.clickAnelemnt(rdoBtnYesInMemberHasCoverage, "ClaimsResearch", "Yes Radio Button in Member Has Other Coverage");
		return utils.clickAnelemnt(rdoBtnNoInMemberHasCoverage, "ClaimsResearch", "No Radio Button in Member Has Other Coverage");
	}

	public boolean selectIsOtherCoverage(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownIsOtherCoverage, args[0], "ClaimsResearch", "Other Coverage drop down");
	}

	public boolean verifyMemberHasNoOtherCoverageStaticMessage(String[] args)
	{
		String expectedText = args[0];
		String actualText = labelStaticMessageForMemberHasNoCovergae.getText().replaceAll(",", "");
		return utils.isvalueMatch_contain(actualText, expectedText);
	}

	public boolean verifyPrimaryCoverageStaticTextMessage(String[] args)
	{
		return utils.validateLabel(labelStaticMessageForPrimaryCoverage, args[0]);
	}

	public boolean verifySecondaryCoverageStaticTextMessage(String[] args)
	{
		return utils.validateLabel(labelStaticMessageForSecondaryMessage, args[0]);
	}


	public boolean verifyNotListedCoverageStaticTextMessage(String[] args)
	{
		String actualText = args[0];
		System.out.println("Actual: "+actualText);
		String expectedText = labelNotListedStaticMessage.getText().replaceAll(",", "").replaceAll("\n", "");
		System.out.println("Expected: "+expectedText);
		return utils.isvalueMatch_contain(actualText, expectedText);
	}


	public boolean verifyAndClickClaimDetailsOnOtherActions(String[] args)
	{
		return utils.selectValueFromListbyVisibleString(drpDownOtherActions, args[0], "ClaimsResearch", "Claim Details");
	}

	public boolean clickSubmit()
	{
		return utils.clickAnelemnt(btnSubmit, "ClaimsResearch", "Submit");
	}
}
