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

public class SearchforImage {

	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;

	public SearchforImage()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		utils.gotoLastIframe(iframes);
	}

	@FindBy(id="ClaimNumber")
	WebElement ClaimNumberTextBox;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Search')]")
	WebElement SearchButton;

	@FindBy(xpath="//*[text()='Select']/ancestor::*[@class='gridTable repeatReadWrite']")
	WebElement ImageSearchResultsTable;

	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;


	@FindBy(id="DCN")
	WebElement DCNTextBox;
	
	@FindBy(id="ProcessClaimImageRequiredYes")
	WebElement RadioButtonProcessClaimImageRequiredYes;
	
	@FindBy(id="ProcessClaimImageRequiredNo")
	WebElement RadioButtonProcessClaimImageRequiredNo;

	/**Enters the DCN in the Search for Image Page
	 * 
	 * @return
	 */
	public boolean enterDCNAndSearch(String[] args) {
		utils.waitforpageload();
		if(utils.enterTextinAnelemnt(DCNTextBox, args[0], "SearchforImage", "DCNTextBox"))
			return utils.clickAnelemnt(SearchButton, "SearchforImage", "SearchButton");
		return false;
	}

	@FindBy(xpath="//*[text()='Select']/ancestor::*[@class='gridTable repeatReadWrite']//input[@type='checkbox']")
	WebElement ImageSearchResultsCheckbox;

	/**Selects the first Claim Image Record and Submit
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean tagFirstClaimImageAndSubmit() throws InterruptedException {
		utils.waitforpageload();
		action.moveToElement(ImageSearchResultsTable);
		if(utils.clickAnelemnt(ImageSearchResultsCheckbox, "SearchforImage", "ImageSearchResultsCheckbox"))
			return utils.clickAnelemnt(SubmitButton, "SearchforImage", "SubmitButton");
		return false;
	}
	
	public boolean selectYesOrNoToProcessClaimImage(String[] args) {
		utils.waitforpageload();
		action.moveToElement(RadioButtonProcessClaimImageRequiredYes);
		if(utils.isvalueMatch_contain(args[0], "Yes"))
			return utils.clickAnelemnt(RadioButtonProcessClaimImageRequiredYes, "SearchforImage", "RadioButtonProcessClaimImageRequiredYes");
		else if(utils.isvalueMatch_contain(args[0], "No"))
			return utils.clickAnelemnt(RadioButtonProcessClaimImageRequiredNo, "SearchforImage", "RadioButtonProcessClaimImageRequiredNo");
		return false;
	}
	

	@FindBy(xpath="//*[text()='Process Claim Image']")
	WebElement ButtonProcessClaimImage;
	
	public boolean tagFirstClaimImageAndProcessClaimImage() throws InterruptedException {
		action.moveToElement(ImageSearchResultsTable);
		if(utils.clickAnelemnt(ImageSearchResultsCheckbox, "SearchforImage", "ImageSearchResultsCheckbox"))
			if(utils.clickAnelemnt(ButtonProcessClaimImage, "SearchforImage", "ButtonProcessClaimImage"))
				return isMemberCompositeReached();
		return false;
	}
	
	@FindBy(xpath="//div[@node_name='CPMCompositesContainer']//div[@role='tablist']//h3[text()='Member']")
	WebElement tabMbrCompositeMember;
	
	public boolean isMemberCompositeReached(){
		utils.waitforpageload();
		return !utils.isProxyWebelement(tabMbrCompositeMember);
	}


}
