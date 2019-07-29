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

public class ProviderSearchforImage {

	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);

	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;

	public ProviderSearchforImage()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(Iframeelement);
	}

	@FindBy(id="ClaimNumber")
	WebElement ClaimNumberTextBox;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Search')]")
	WebElement SearchButton;

	/**This functionality enters the Claim Number in the Search for Image Page and click on search
	 * 
	 * @return
	 */
	public boolean enterClaimNumberAndSearch(String[] args) {
		if(utils.enterTextinAnelemnt(ClaimNumberTextBox, args[0], "ProviderSearchforImage", "ClaimNumberTextBox"))
			return utils.clickAnelemnt(SearchButton, "ProviderSearchforImage", "SearchButton");
		return false;
	}

	@FindBy(xpath="//*[text()='Select']/ancestor::*[@class='gridTable repeatReadWrite']")
	WebElement ImageSearchResultsTable;

	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;

	/**This functionality clicks the corresponding Claim Image Record checkbox in the Image Search Result Table and click submit
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean tagClaimImageAndSubmit(String[] args) throws InterruptedException {
		utils.waitforpageload();
		action.moveToElement(ImageSearchResultsTable);
		WebElement row = utils.returntablerowbasedonvalues(ImageSearchResultsTable, args);
		List<WebElement> ls = row.findElements(By.tagName("input"));
		ls.get(1).click();
		return utils.clickAnelemnt(SubmitButton, "ProviderSearchforImage", "SubmitButton");	
	}

	@FindBy(id="DCN")
	WebElement DCNTextBox;

	/**Enters the DCN in the Search for Image Page
	 * 
	 * @return
	 */
	public boolean enterDCNAndSearch(String[] args) {
		if(utils.enterTextinAnelemnt(DCNTextBox, args[0], "ProviderSearchforImage", "DCNTextBox"))
			return utils.clickAnelemnt(SearchButton, "ProviderSearchforImage", "SearchButton");
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
		if(utils.clickAnelemnt(ImageSearchResultsCheckbox, "ProviderSearchforImage", "ImageSearchResultsCheckbox"))
			return utils.clickAnelemnt(SubmitButton, "MemberSearchforImage", "SubmitButton");
		return false;
	}


}
