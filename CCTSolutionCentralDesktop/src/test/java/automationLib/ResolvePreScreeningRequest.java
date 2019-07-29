package automationLib;

import java.io.IOException;
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

public class ResolvePreScreeningRequest {
	
	
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());
	
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	/**
	 * Constructor for the RequestAccumulatorReview class defining the Iframe and the Page Factory  
	 */
	public ResolvePreScreeningRequest() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	
	//Sprint 3.4
	

		@FindBy(xpath="//table[@pl_prop='.MiscellaneousAccumList']")
		WebElement tblMiscellanousAccumulator;
		
		@FindBy(xpath="//span[contains(text(),'Miscellaneous Accumulators')]")
		WebElement lnkMiscellanousAccumulators;
		
		public boolean verifyMiscellaneousAccumulatorsSectionIsDisplayed()
		{
				return !utils.isProxyWebelement(lnkMiscellanousAccumulators);
		}
		
		/*	
		 * @SCU
		 * #CommonMethodWithArgument:validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment
		 * #Description:This functionality validates the Miscellanous Accumulator tagged or reviewed.
		 * #Argument:MiscellanousAccumsLevelTagged
		 * Type:Table
		 * Keys:Name#Description#From Thru#Unit#Amount
		 */
		public boolean validateAccumulatorsDiscussedWithContactAndRequestedForAdjustment(String args[]){
			try{
			
				WebElement row =utils.returntablerowbasedonvalues(this.tblMiscellanousAccumulator,args);
				List<WebElement> chkbox = row.findElements(By.xpath("//td//img[@class='checkbox chkBxCtl']"));
				if(chkbox.get(0).isDisplayed()){
					System.out.println("Review Requested is checked");
					return true;
				}
			}
			catch (Exception e){
				System.out.println("Entire row not matching for given input Accumulator -FamilyLevel" + e);
				return false;
			}
			return false;
		}
}
