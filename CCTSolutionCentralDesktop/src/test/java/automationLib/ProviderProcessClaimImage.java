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

public class ProviderProcessClaimImage {

	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	public ProviderProcessClaimImage()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement);
	}

	@FindBy(id="ReasonforContact")
	WebElement ReasonforContact;

	/**This functionality Selects the reason for Contact options from the dropdown
	 * 
	 * @return
	 */
	public boolean reasonForContact(String[] args) {
		return utils.selectDropDownbyVisibleString(ReasonforContact, args[0], "ProcessClaimImage", "ReasonforContact");
	}

	@FindBy(id="RequestedAction")
	WebElement RequestedAction;

	/**This functionality Selects the Requested action options from the dropdown
	 * 
	 * @return
	 */
	public boolean requestedAction(String[] args) {
		return utils.selectDropDownbyVisibleString(RequestedAction, args[0], "ProcessClaimImage", "RequestedAction");
	}

	@FindBy(id="ReasonForUrgency")
	WebElement ReasonForUrgency;
	
	

	/**This functionality validates the reason for urgency dropdown options are available or not
	 * 
	 * @return
	 */
	
	@FindBy(id="ePACTProviderLocation")
	WebElement ePACTproviderlocation;
	
	public boolean ePACTproviderlocation(String[] args) {
		return utils.selectDropDownbyVisibleString(ePACTproviderlocation, args[0], "ProcessClaimImage", "ePACTproviderlocation");
	}
	
	//8selects the provider location
	
	@FindBy(id="TypeofProvider")
	WebElement TypeofProvider;
	
	public boolean TypeofProvider(String[] args) {
		return utils.selectDropDownbyVisibleString(TypeofProvider, args[0], "ProcessClaimImage", "providertype");
	}
	
	//select the provider type
	
	
	public boolean ValidateReasonForUrgencyDropDownValuses(String[] args) {
		ArrayList<String> valuestobechecked = new ArrayList<String>();
		for(String value:args) {
			valuestobechecked.add(value);
		}

		return utils.checkvaluesinDropDown(ReasonForUrgency, valuestobechecked);
	}

	@FindBy(xpath="//*[text()='Submit']")
	WebElement Submit;

	/**Click Submit
	 * 
	 */
	public boolean clickSubmit() {
		return utils.clickAnelemnt(Submit, "ProcessClaimImage", "Submit");
	}

	@FindBy(id="ProviderRecognizedNo_rdi_1")
	WebElement ProviderRecognizedNo;

	public boolean clickNoInProvideRecordsToAnthem()
	{
		return utils.clickAnelemnt(ProviderRecognizedNo, "ProviderProcessClaimImage", "Rdo Btn Provide to Anthem Record");
	}

	@FindBy(id="ProviderRecognizedYes_rdi_1")
	WebElement ProviderRecognizedYes;
	
	
	
	/**Click no in provider option

	/**Clicks yes in the Records Provide to Anthem
	 * 
	 * @return
	 */
	public boolean clickYesInProvideRecordsToAnthem()
	{
		return utils.clickAnelemnt(ProviderRecognizedYes, "ProviderProcessClaimImage", "Rdo Btn Provide to Anthem Record");
	}

	@FindBy(id="RenderingProviderName")
	WebElement RenderingProviderName;

	@FindBy(id="NationalProviderIdentifier")
	WebElement NationalProviderIdentifier;

	@FindBy(id="TermDate")
	WebElement TermDate;

	@FindBy(id="ProvState")
	WebElement ProvState;

	@FindBy(id="DisplayEffectiveDate")
	WebElement FilterModifiedDate;
	
	@FindBy(id="AllowedAmt")
	WebElement AllowedAmt;
	

	@FindBy(id="AllowedAmount")
	WebElement charges;
	
	@FindBy(id="OrganizationName")
	WebElement Organizationname;
	
	@FindBy(id="TIN")
	WebElement TIN;
	
	@FindBy(id="NPI")
	WebElement NPIID;
	
	@FindBy(id="ProvAddress")
	WebElement ProvAddress;
	
	@FindBy(id="ProvCity")
	WebElement ProvCity;
	
	@FindBy(id="State")
	WebElement State;
	
	@FindBy(id="Provzipcode")
	WebElement Provzipcode;

	/**Enters Provider Details and Processing Details
	 * 
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean enterProviderNProcessingDetails(String[] args) throws InterruptedException {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("ProviderProcessClaimImage", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;

			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1);
			System.out.println("key " + key + "value  " + value);

			if(utils.isvalueMatch_contain(key, "rendering provider name")) {
				returnvar = utils.enterTextinAnelemnt(RenderingProviderName,value,"ProviderProcessClaimImage","RenderingProviderName");
				continue;}
			else if(utils.isvalueMatch_contain(key,"provider npi")){
				returnvar = utils.enterTextinAnelemnt(NPIID,value,"ProviderProcessClaimImage","NPIID");
				continue;}
			else if(utils.isvalueMatch_contain(key,"received date")){
				utils.waitforpageload();				
				returnvar = utils.enterTextinAnelemnt(TermDate,value,"ProviderProcessClaimImage","TermDate");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"processing system")){
				returnvar = utils.selectDropDownbyVisibleString(ProvState, value, "ProviderProcessClaimImage", "ProvState");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"date of service")){				
				utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(FilterModifiedDate,value,"ProviderProcessClaimImage","FilterModifiedDate");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"total charges")){				
				utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(charges,value,"ProviderProcessClaimImage","charges");
				continue;
			}
			
			/*	utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(charges,value,"ProviderProcessClaimImage","charges");
				continue;
			}*/
		else if(utils.isvalueMatch_contain(key,"organization name")){				
				utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(Organizationname,value,"ProviderProcessClaimImage","Organizationname");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"provider taxid")){				
				utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(TIN,value,"ProviderProcessClaimImage","TIN");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"provider npi")){				
				utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(NPIID,value,"ProviderProcessClaimImage","NPIID");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"address")){				
				utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(ProvAddress,value,"ProviderProcessClaimImage","ProvAddress");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"city")){				
				utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(ProvCity,value,"ProviderProcessClaimImage","ProvCity");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"state")){
				returnvar = utils.selectDropDownbyVisibleString(State, value, "ProviderProcessClaimImage", "State");
				continue;
			}
			else if(utils.isvalueMatch_contain(key,"zipcode")){				
				utils.waitforpageload();
				returnvar = utils.enterTextinAnelemnt(Provzipcode,value,"ProviderProcessClaimImage","Provzipcode");
				continue;
			}
			
			else 
				err.logcommonMethodError("ProviderProcessClaimImage", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}
		return returnvar;
	}
	
	
	@FindBy(xpath="//*[@data-test-id='20160322220747064557314']")
	List<WebElement> AllOptionsItem;

	/**Selects all the  the options from the Verify Claim Image Page
	 * 
	 * @return
	 */
	public boolean selectAllOptions() {
		boolean flag = false;
		for(WebElement item:AllOptionsItem) {
			flag = utils.clickAnelemnt(item, "VerifyClaimImage", "AllOptionsItem");
			if(!flag)
				return false;
		}
		return flag;
	}
	
	@FindBy(xpath="//div[text()=' Automate']")
	WebElement AutomateButton;
	
	/**Clicks on Automate Button
	 * 
	 */
	public boolean clickAutomate() {
		return utils.clickAnelemnt(AutomateButton, "ProcessClaimImage", "AutomateButton");
	}
	
}
