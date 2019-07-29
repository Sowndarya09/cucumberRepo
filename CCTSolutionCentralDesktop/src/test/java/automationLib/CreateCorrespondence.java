package automationLib;

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

public class CreateCorrespondence extends Driver {
	/**
	 * Methods in the Program 
	 */

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	/**
	 * Constructer for the Create Correspondence class defining the Iframe and the Page Factory  
	 */
	public CreateCorrespondence()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(xpath="//*[text()='Recent Letters']")
	WebElement RecentLetterLink;

	/**This method clicks on Recent Letter Link
	 * @return 
	 * 
	 */
	public boolean clickRecentLetterLink() {
		try {
			RecentLetterTable.isDisplayed();
			blogger.loginfo("PASS: Recent Letter section is displayed");
			return true;
		}
		catch(Exception e) {
			return utils.clickAnelemnt(RecentLetterLink, "CreateCorrespondence", "RecentLetterLink");
		}	
	}

	@FindBy(xpath="//*[@data-test-id='2018032100092509068549']/ancestor::table[@class='gridTable repeatReadWrite']")
	WebElement RecentLetterTable;

	/**Validate the existing Recent Letters present
	 * @return */
	public boolean validateRecentLetters(String[] args) {
		return utils.validatetablerowbasedonvalues(RecentLetterTable, args);
	}

	/**select a given recent letter
	 * @return 
	 * @throws InterruptedException */
	public boolean selectRecentLetter(String[] args) throws InterruptedException {
		return utils.clickontablerowbasedonvalues(RecentLetterTable, args);

	}

	@FindBy(xpath="//input[@id='DefaultTrueFalseYes']")
	WebElement DeliverToDiffAddressYes;

	/**Select RadioButton YES for Deliver To Different Address
	 * @return */
	public boolean selectDeliverToDiffAddressYes() {
		return utils.clickAnelemnt(DeliverToDiffAddressYes, "CreateCorrespondence", "DeliverToDiffAddressYes");
	}

	@FindBy(xpath="//input[@id='DefaultTrueFalseNo']")
	WebElement DeliverToDiffAddressNo;

	/**Select RadioButton NO for Deliver To Different Address
	 * @return */
	public boolean selectDeliverToDiffAddressNo() {
		return utils.clickAnelemnt(DeliverToDiffAddressNo, "CreateCorrespondence", "DeliverToDiffAddressNo");
	}

	@FindBy(xpath="//*[text()='Resend Letter']")
	WebElement ResendLetterButton;
	/**Click on Resend Letter Button
	 * @return */
	public boolean clickResendLetterButton() {
		return utils.clickAnelemnt(ResendLetterButton, "CreateCorrespondence", "ResendLetterButton");
	}

	@FindBy(xpath="//*[@data-test-id='201804022027430535140235']")
	WebElement SuccessSentMsg;

	/**Verify the Success Message which is displayed
	 * @return */
	public boolean verifyLetterSuccessSentMsg() {
		return utils.validateLabel(SuccessSentMsg, "Letter Sent Successfully");
	}

	@FindBy(xpath="")
	WebElement SystemErrorMsg;

	/**Verify the System Error Message which is displayed
	 * @return */
	public boolean verifySystemError() {
		return utils.validateLabel(SystemErrorMsg, "");
	}

	@FindBy(xpath="(//*[@data-test-id='20150910141133055840112']/ancestor::table[@class='gridTable '])[2]")
	WebElement AddressTable;

	/**Select address displayed in the List
	 * @return 
	 * @throws InterruptedException */
	public boolean selectAddress(String[] args) throws InterruptedException {
		utils.waitforpageload();
		return utils.clickontablerowbasedonvalues(AddressTable, args);

	}

	@FindBy(xpath="//*[@data-test-id='201803161038590617233861']")
	WebElement NameTextBox;

	@FindBy(xpath="//*[@data-test-id='201803161038590617233861']")
	WebElement CareOfTextBox;

	@FindBy(xpath="//*[@data-test-id='201801301619240872680925']")
	WebElement StreetAddressTextBox;

	@FindBy(xpath="//*[@data-test-id='201801301619240872683679']")
	WebElement CityTextBox;

	@FindBy(xpath="//*[@id='State']")
	WebElement StateDrpDown;

	@FindBy(xpath="//*[@data-test-id='201801301900250166600564']")
	WebElement ZipCodeTextBox;

	/**Select Other option displayed in address list and Fill the necessary fields displayed*/
	public boolean selectOtherAddressRadioButtonAndFillDetails(String[] args) throws InterruptedException {
		try {
			utils.clickontablerowbasedonvalues(AddressTable, "Type:Other");

			boolean returnvar ;
			returnvar = true;
			for(String iterator : args)
			{
				String keyvaluepair="";

				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
					return false;

				}
				keyvaluepair = iterator;

				String key = iterator.substring(0, iterator.indexOf(":")).toLowerCase();
				String value = iterator.substring(iterator.indexOf(":")+1);

				if(utils.isvalueMatch_contain(key,"name")) {
					returnvar = utils.setAttribute(NameTextBox, "value", value);
					continue;}
				else if(utils.isvalueMatch_contain(key,"care of")) {
					returnvar = utils.setAttribute(CareOfTextBox, "value", value);
					continue;}
				else if(utils.isvalueMatch_contain(key,"address")) {
					returnvar = utils.setAttribute(StreetAddressTextBox, "value", value);
					continue;}
				else if(utils.isvalueMatch_contain(key,"city/state")) {
					returnvar = utils.setAttribute(CityTextBox, "value", value);
					continue;}
				else if(utils.isvalueMatch_contain(key,"state")) {
					returnvar = utils.selectDropDownbyVisibleString(StateDrpDown, value, "CreateCorrespondence", "StateDrpDown");
					continue;}
				else if(utils.isvalueMatch_contain(key,"zip code")) {
					returnvar = utils.setAttribute(ZipCodeTextBox, "value", value);
					continue;}
				else 
					err.logcommonMethodError("CreateCorrespondence", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
				return false;
			}

			if(returnvar){
				blogger.loginfo("PASS: Select Other address and fill detials");
				return true;	
			}else{
				blogger.loginfo("Create Correspondence", "FAIL: The value doesnt match with the one in application");
				return false;
			}
		}catch(Exception e) {
			err.logError("Create Correspondence"+e);
			return false;
		}
	}

	@FindBy(xpath="//*[text()='Send A New Letter'")
	WebElement SendLetterLink;

	/**This method clicks on Send A New Letter
	 * @return */
	public boolean clickSendANewLetter() {
		if(utils.isProxyWebelement(LetterDropdown))
			return utils.clickAnelemnt(SendLetterLink, "CreateCorrespondence", "SendLetterLink");
		return true;
	}

	@FindBy(id="LetterName")
	WebElement LetterDropdown;

	@FindBy(id="ClaimID")
	WebElement DCNDropdown;

	/**Selects Letter name from Letter Dropdown and DCN claim number from DCN dropdown*/
	public boolean selectLetterNameAndDCN(String[] arg) {
		try {
			String[] args = arg[0].split(";");
			boolean flag = false;
			String letterdrpdown = args[0].substring(args[0].indexOf(":")+1);
			flag = utils.selectDropDownbyVisibleString(LetterDropdown, letterdrpdown, "CreateCorrespondenceReview", "ReasonForContact");
			blogger.loginfo("Letter DropDown is Selected");
			if(args.length==2) {
				String dcndrpdown = args[1].substring(args[1].indexOf(":")+1);
				flag = utils.selectDropDownbyVisibleString(DCNDropdown, dcndrpdown, "CreateCorrespondenceReview", "ReasonForContact");
				blogger.loginfo("DCN DropDown is Selected");
			}
			return flag;
		}catch(Exception e) {
			err.logError("CreateCorrespondence"+e);
			return false;
		}
	}

	@FindBy(xpath="//*[@id='DialogContent'][text()='         You can initiate a letter for a member here.']")
	WebElement GuidedDialogText;

	/**Verify Text in Guided Dialog Text Box
	 * @return */
	public boolean verifyGuidedDialogText() {
		return utils.validateLabel(GuidedDialogText, "You can initiate a letter for a member here");
	}

	@FindBy(xpath="//div[text()='Submit']")
	WebElement SubmitButton;

	/**This method is to click on Submit Button*/
	public boolean clickSubmitButton() {
		utils.scrolltomiddle();
		return utils.clickAnelemnt(SubmitButton,"Create Correspondence","SubmitButton");
	}

	@FindBy(xpath="//*[@data-test-id='2018032910521400941864']")
	List<WebElement> LabelElements;

	@FindBy(xpath="//*[@data-test-id='2018032910521400941864']/ancestor::table[@id='gridLayoutTable']//input[not(contains(@type,'hidden'))]")
	List<WebElement> ValueElements;

	/**Verify fields are pre populated in Letter Details section*/
	public boolean verifyPrePopulatedFieldsInLetterDetailsSection(String[] args) {
		try {
			boolean returnvar ;
			returnvar = true;
			int count = 0;
			for(int i=0;i<args.length;i++) 
			{
				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check Either Your input is wrong or the value found on application is incorrect");
					return false;
				}
				String key = args[i].substring(0, args[i].indexOf(":")).toLowerCase();
				String value = args[i].substring(args[i].indexOf(":")+1);
				for(int j=0;j<LabelElements.size();j++) {
					returnvar = false;
					String label = LabelElements.get(j).getText();
					if(utils.isvalueMatch_compareto(key,label)) {
						System.out.println(ValueElements.get(j).getAttribute("value"));
						returnvar = utils.isvalueMatch_compareto(ValueElements.get(j).getAttribute("value"),value);
						count++;
						break;
					}
				}	
			}
			if(returnvar && count==args.length){
				blogger.loginfo("PASS: Values are prepopulated");
				return true;	
			}else{
				blogger.loginfo("Create Correspondence", "FAIL: Values are not prepopulated");
				return false;
			}
		}catch(Exception e) {
			err.logError("Create Correspondence"+e);
			return false;
		}
	}


	@FindBy(xpath="//*[text()='Send Letter']")
	WebElement SendLetterButton;
	
	/**Click on Send Letter Button
	 * @return */
	public boolean clickOnSendLetterInLetterDetailsSection() {
		return utils.clickAnelemnt(SendLetterButton, "CreateCorrespondence", "SendLetterButton");
	}

	/**Verify fields present in Letter Details section*/
	public boolean setValuesInFieldsInLetterDetailsSection(String[] args) {
		try {
			boolean returnvar ;
			returnvar = true;
			int count = 0;
			for(int i=0;i<args.length;i++) 
			{
				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check Either Your input is wrong or the value found on application is incorrect");
					return false;

				}

				String key = args[i].substring(0, args[i].indexOf(":")).toLowerCase();
				String value = args[i].substring(args[i].indexOf(":")+1);
				for(int j=0;j<LabelElements.size();j++) {
					returnvar = false;
					String label = LabelElements.get(j).getText();
					if(utils.isvalueMatch_compareto(key,label)) {
						System.out.println(ValueElements.get(j).getAttribute("value"));
						ValueElements.get(j).clear();
						ValueElements.get(j).sendKeys(value);
						returnvar = true;
						count++;
						break;
					}
				}	
			}

			if(returnvar && count==args.length){
				blogger.loginfo("PASS: Values are set in the Fields");
				return true;	
			}else{
				blogger.loginfo("Create Correspondence", "FAIL: Values are not set in the Fields");
				return false;
			}
		}catch(Exception e) {
			err.logError("Create Correspondence"+e);
			return false;
		}
	}

	/**Verify Field Name present in Letter Details Section*/
	public boolean verifyFieldNameInLetterDetailsSection(String[] args) {
		try {
			boolean returnvar ;
			returnvar = true;
			int count = 0;
			for(int i=0;i<args.length;i++) 
			{
				if(!returnvar)
				{
					err.logcommonMethodError("Member Composite", "Check Either Your input is wrong or the value found on application is incorrect");
					return false;

				}

				String key = args[i];
				for(int j=0;j<LabelElements.size();j++) {
					returnvar = false;
					String label = LabelElements.get(j).getText();
					System.out.println(key+label);
					if(utils.isvalueMatch_compareto(key,label)) {
						returnvar=true;
						count++;
						break;
					}
				}	
			}

			if(returnvar && count==args.length){
				blogger.loginfo("PASS: Values are prepopulated");
				return true;	
			}else{
				blogger.loginfo("Create Correspondence", "FAIL: Values are not prepopulated");
				return false;
			}
		}catch(Exception e) {
			err.logError("Create Correspondence"+e);
			return false;
		}
	}
}
