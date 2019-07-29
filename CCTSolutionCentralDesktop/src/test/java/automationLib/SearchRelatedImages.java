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

public class SearchRelatedImages {

	

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.pgDriver);
	
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement;
	
	public SearchRelatedImages()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		//waitforpageload();
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	
	@FindBy(xpath="//button[@data-test-id='201601290707250220580258']//preceding::div[contains(text(),'Search')]")
	WebElement btnSearch;
	
	@FindBy(id="MEMBERCERTNUM")
	WebElement 	txtBoxMemberNumber;
	
	@FindBy(id="DCN")
	WebElement 	txtBoxDCN;
	
	@FindBy(xpath="//table[@pl_prop='ClmImageList.pxResults']")
	WebElement 	imageSearchResultsTable;
	
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement BtnSubmit;
	
	public boolean setMemberNumber(String arg){
		
		return utils.enterTextinAnelemnt(this.txtBoxMemberNumber, arg, "SearchRelatedImages", "setMemberNumber");
		
	}
	
public boolean setDCN(String []arg){
		
		return utils.enterTextinAnelemnt(this.txtBoxDCN, arg[0], "SearchRelatedImages", "setDCN");
		
	}
	
	public boolean clickSearch(){
		
		return utils.clickAnelemnt(this.btnSearch,"SearchRelatedImages", "clickSearch");
	}
	
	public boolean searchByMemberNumber(String[] arg){
		
		if (setMemberNumber(arg[0]))
			if (clickSearch())
				return true;
		return false;		
	}

	/*	
	 * @SCU
	 * #CommonMethodWithArgument:selectFromImageSearchResults
	 * #Description:This functionality selects a particular DCN or Claim from the Image Search Results
	 * #Argument:DCN
	 * Type:Table
	 * Keys:Reference Number#Document Control Number#Member Number#Claim Number#Inquiry ID#ITS SCCF#Document ID#Type#Entry Date
	 */
	public boolean selectFromImageSearchResults(String[] args){
		try{
			utils.waitforpageload();
			WebElement row =utils.returntablerowbasedonvalues(this.imageSearchResultsTable,args);
			row.findElement(By.xpath(".//td[@data-attribute-name='Select']//input[@type='checkbox']")).click();
			return true;
		}
		catch (Exception e){
			err.logError("Entire row not matching for given input DCN / Claim Number - Image Search Results" + e);
			return false;
		}

	}
	
	/*	
	 * @SCU
	 * #CommonMethodWithoutArgument:clickOnSubmit
	 * #Description:This functionality clicks on submit button in Search Related Images page
	 * Type:Textbox
	 */
	public boolean clickOnSubmit()
	{
		utils.scrolltomiddle();
		return utils.clickAnelemnt(this.BtnSubmit, "SearchRelatedImages", "Submit Button");

	}
	
	
}
