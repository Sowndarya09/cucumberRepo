package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerComposite_AgencyTab {

	SeleniumUtilities utils = new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();
	Actions action = new Actions(Driver.pgDriver);

	public BrokerComposite_AgencyTab()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	@FindBy(xpath="//h3[text()='Agency']")
	WebElement AgencyTab;

	@FindBy(xpath="//span[text()='Agency Information']")
	WebElement LnkAgencyInfo;

	@FindBy(xpath="//span[text()='Anthem Contacts']")
	WebElement LnkAnthemContacts;

	@FindBy(xpath="//*[@data-test-id='20180828231249081467158-Label']")
	WebElement LabelTINEncrypted;

	@FindBy(xpath="//*[@data-test-id='20180828231249081570657-Label']")
	WebElement LabelTINUnEncrypted;

	@FindBy(xpath="//*[@data-test-id='20180828231249081468848-Label']")
	WebElement LabelName;


	@FindBy(xpath="//*[@data-test-id='2019020512422602764208-Label']")
	WebElement LabelType;


	@FindBy(xpath="//*[@data-test-id='201902051525540048257265-Label']")
	WebElement LabelAddress;

	@FindBy(xpath="//*[@data-test-id='20190205140037090119866-Label']")
	WebElement LabelPhoneNumber;

	@FindBy(xpath="//*[@data-test-id='20190205140115015822671-Label']")
	WebElement LabelEmailAddress;
	
	@FindBy(xpath="//*[@data-test-id='20180828231249081467158']")
	WebElement LabelValueTINEncrypted;

	@FindBy(xpath="//*[@data-test-id='20180828231249081570657']")
	WebElement LabelValueTINUnEncrypted;

	@FindBy(xpath="//*[@data-test-id='20180828231249081468848']")
	WebElement LabelValueName;


	@FindBy(xpath="//*[@data-test-id='2019020512422602764208']")
	WebElement LabelValueType;


	@FindBy(xpath="//*[@data-test-id='201902051525540048257265']")
	WebElement LabelValueAddress;

	@FindBy(xpath="//*[@data-test-id='20190205140037090119866']")
	WebElement LabelValuePhoneNumber;

	@FindBy(xpath="//*[@data-test-id='20190205140115015822671']")
	WebElement LabelValueEmailAddress;

	@FindBy(xpath="//*[text()='State']/ancestor::table[@id='bodyTbl_right']")
	WebElement TableAnthemContacts;

	/**This functionality validates Agency Information feild section lables like TINEncrypted TINUnencrypted Name Type Address PhoneNumber EmailAddress
	 * 
	 * @return
	 */
	public boolean verifyAgencyInfoSectionLables() {
		if(!utils.isProxyWebelement(LnkAgencyInfo) && !utils.isProxyWebelement(LabelTINEncrypted)
				&& !utils.isProxyWebelement(LabelTINUnEncrypted) && !utils.isProxyWebelement(LabelName)
				&& !utils.isProxyWebelement(LabelType) && !utils.isProxyWebelement(LabelAddress)
				&& !utils.isProxyWebelement(LabelPhoneNumber) && !utils.isProxyWebelement(LabelEmailAddress)){
			blogger.loginfo("Agency Information field section lables like TINEncrypted TINUnencrypted Name Type Address PhoneNumber EmailAddress are present");
			return true;
		}
		return false;
	}

	/**This functionality validates Agency Anthem contact Information feild section lables
	 * 
	 * @return
	 */
	public boolean verifyAgencyAnthemContactSectionLables() {
		String[] tablevalues = {"State", "Name", "Type", "Market", "LOB Type"};
		return utils.validateTableRowHeader(TableAnthemContacts, tablevalues );
	}

	/**This functionality validates Agency information under Agency tab in TIN/SSN flow
	 * 
	 * @return
	 */
	public boolean verifyAgencyInfoUnderAgencyTab(String[] args) {
		boolean returnvar = true;
		String keyvaluepair="";
		for(String iterator : args)
		{
			if(!returnvar)
			{
				err.logcommonMethodError("Broker Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;

			}
			keyvaluepair = iterator;
			String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
			String value = iterator.substring(iterator.indexOf(":")+1).toLowerCase();
			
			if(utils.isvalueMatch_contain(key, "tinencrypted")) {
				returnvar = utils.validateLabel(LabelValueTINEncrypted,value);
				continue;
			}else if(utils.isvalueMatch_contain(key, "tinunencrypted")) {
				returnvar = utils.validateLabel(LabelValueTINUnEncrypted,value);
				continue;
			}else if(utils.isvalueMatch_contain(key, "name")) {
				returnvar = utils.validateLabel(LabelValueName,value);
				continue;
			}else if(utils.isvalueMatch_contain(key, "type")) {
				returnvar = utils.validateLabel(LabelValueType,value);
				continue;
			}else if(utils.isvalueMatch_contain(key, "phonenumber")) {
				returnvar = utils.validateLabel(LabelValuePhoneNumber,value);
				continue;
			}else if(utils.isvalueMatch_compareto(key, "address")) {
				returnvar = utils.validateLabel(LabelValueAddress,value);
				continue;
			}else if(utils.isvalueMatch_compareto(key, "emailaddress")) {
				returnvar = utils.validateLabel(LabelValueEmailAddress,value);
				continue;
			}
			else
				return false;
		}
		return returnvar;

	}

	/**This functionality validates Agency's Anthem contact information under Agency tab in TIN/SSN flow
	 * 
	 * @return
	 */
	public boolean verifyAgencysAnthemContactInfoUnderAgencyTab(String[] args) {
		action.moveToElement(TableAnthemContacts);
		return utils.validatetablerowbasedonvalues(TableAnthemContacts, args);
	}
	
	/**This functionality validates that agency tab is not diplayed in groupadmin flow
	 * 
	 * @return
	 */
	public boolean verifyAgencyTabIsNotDisplayedInGroupAdminFlow() {
		return utils.isProxyWebelement(AgencyTab);
	}
}
