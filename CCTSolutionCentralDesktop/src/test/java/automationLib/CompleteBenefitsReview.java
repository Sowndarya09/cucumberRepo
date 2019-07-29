package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CompleteBenefitsReview {

	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	public CompleteBenefitsReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	@FindBy(xpath="//table[@pl_prop='.TaggedBenefitsList']")
	private WebElement tableBenefitreviewTaggedBenefits;
	@FindBy(xpath="//table[@pl_prop='.BrowseTagList']")
	private WebElement tableBrowseBenefitTaggedBenefits;
	ArrayList<String> sValuesforSingleBenefit= new ArrayList<String>();
	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	private WebElement btnOtherActions;
	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Submit')]")
	private WebElement btnSubmit;
	@FindBy (xpath="//li//span[contains(text(),'Access Documents')]")	
	private WebElement lnkOthrActionsAccessDocuments;
	@FindBy (xpath="//li//span[contains(text(),'Request Manager/OE Help')]")	
	private WebElement lnkOthrActionsRequestManagerHelp;
	@FindBy(id="ReasonForRequest")
	WebElement drpdwnReasonforRequest;
	@FindBy(xpath="//div[@aria-label='Disclose Benefits Reviewed With Contact on Search']/div[1]")
	WebElement BenRevcontSearch;
	@FindBy(xpath="//table[contains(@pl_prop,'.TaggedBenefitsList')]")
	WebElement tblBenSearchTag;


	public boolean checkTaggedBenefitsfromSelection()
	{
		List<WebElement> allRows = tableBenefitreviewTaggedBenefits.findElements(By.tagName("tr"));
		for(WebElement row:allRows)
		{
			utils.clickAnelemnt(BenRevcontSearch, "CompleteBenefitsReview", "Benefitssearchtag");
			List<WebElement> allColsByRow =row.findElements(By.tagName("td"));
			for(WebElement col :allColsByRow )
			{
				System.out.println("Column Value:"+col.getText());
				sValuesforSingleBenefit.add(col.getText());
			}
		}

		if(sValuesforSingleBenefit.get(1).contains("Ambulance"))
			if(sValuesforSingleBenefit.get(2).contains("Water"))
				if(sValuesforSingleBenefit.get(3).contains("Ambulance"))
					if(sValuesforSingleBenefit.get(4).contains("In"))
						if(sValuesforSingleBenefit.get(6).contains("DME"))
							if(sValuesforSingleBenefit.get(7).contains("DME"))
								if(sValuesforSingleBenefit.get(8).contains("Any"))
									if(sValuesforSingleBenefit.get(9).contains("Network"))
										System.out.println("The column values are perfect");
									else
										return false;



		Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.TaggedBenefitsList']//tr[2]")).click();
		Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='.TaggedBenefitsList']//tr[4]")).click();
		List<WebElement> taggedvalues=Driver.pgDriver.findElements(By.xpath("//table[@pl_prop='.TaggedBenefitsList']//*[@node_name='DisplayTaggedBenefits']"));

		String ambulance=taggedvalues.get(0).getText();
		String medicalsupply=taggedvalues.get(1).getText();

		if(ambulance.contains("Deductible")&&taggedvalues.contains("Inclusions"))
		{
			System.out.println("First Row check compelte");
		}
		else
		{
			err.logError("Benefits Reviews", "Tagged eleemnt - 1st row for AMBULANCE is wrong");
			return false;
		}

		if(medicalsupply.contains("Conditions")&&taggedvalues.contains("Associated"))
		{
			System.out.println("Second Row check compelte");
		}

		else
		{
			err.logError("Benefits Reviews", "Tagged eleemnt - 2st row  for medical supplies is wrong");
			return false;
		}
		return true;
	}

	public boolean checkBrowseTaggedBenefits(String[] tablevalues)
	{
		utils.validateRowValues(this.tableBrowseBenefitTaggedBenefits,tablevalues);
		return true;
	}
	public boolean navigatetoRequestManagerHelp() throws InterruptedException
	{
		utils.waitforpageload();
		return utils.selectValueFromListbyVisibleString(btnOtherActions, "Request Manager/OE Help", "CompleteBenefitsReview", "Request Manager Help");
	}

	public boolean navigatetoAccessDocuments()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Billing Review", "Other Actions button"))
			return utils.clickAnelemnt(this.lnkOthrActionsAccessDocuments, "Access Documents", "Links");
		return false;
	}

	public boolean RequestBenefitVerficationSubmit()
	{
		if(utils.clickAnelemnt(this.drpdwnReasonforRequest, "Samp", "Samp"))
			if(utils.selectDropDownbyVisibleString(this.drpdwnReasonforRequest, "Request Benefit Verification", "Complete Benefits Review ", "Request Benefit Verification-option"))
				return utils.clickAnelemnt(this.btnSubmit, "Request Benefit Verification", "Submit button");
		return false;
	}

	public boolean DisputeBenefitCoverageSubmit()
	{
		if(utils.selectDropDownbyVisibleString(this.drpdwnReasonforRequest, "Dispute Benefit Coverage", "Complete Benefits Review ", "Request Benefit Verification-option"))
			return utils.clickAnelemnt(this.btnSubmit, "Request Benefit Verification", "Submit button");
		return false;
	}

	public boolean RequestDocumentationSubmit()
	{
		if(utils.selectDropDownbyVisibleString(this.drpdwnReasonforRequest, "Request Documentation", "Complete Benefits Review ", "Request Benefit Verification-option"))
			return utils.clickAnelemnt(this.btnSubmit, "Request Benefit Verification", "Submit button");
		return false;
	}

	@FindBy(xpath="//div[@node_name='DisplayTaggedBenefits']//p[2]/strong")
	WebElement txtauthorization;

	public boolean checkTaggedBenefitsfromSearch(String[] sData) throws InterruptedException
	{
		List<WebElement> allRows = tableBenefitreviewTaggedBenefits.findElements(By.tagName("tr"));

		for(WebElement row:allRows)
		{
			utils.clickAnelemnt(BenRevcontSearch, "CompleteBenefitsReview", "Benefitssearchtag");
			List<WebElement> allColsByRow =row.findElements(By.tagName("td"));
			for(WebElement col :allColsByRow )
			{
				System.out.println("Column Value:"+col.getText());
				sValuesforSingleBenefit.add(col.getText());
			}
		}
		System.out.println(sData[0]);
		if(utils.clickontablerowbasedonvalues(this.tableBenefitreviewTaggedBenefits, sData[0]))
		{
			System.out.println("Table clicked");
			int i=2;
			String s1,s2;
			boolean returnvar=true;
			while(returnvar && i<sData.length)

			{ try {
				i++;
				s1=sData[i];
				s2=sData[i];
				s1 = s1.substring(s1.indexOf(":") + 1).toLowerCase();
			} catch (ArrayIndexOutOfBoundsException e) {
				break;

			}
			switch (s2.substring(0, s2.indexOf(":"))) {

			case "authorization" :
			{
				returnvar = utils.isvalueMatch_contain(txtauthorization.getText().toLowerCase(),s1);
				continue;					 
			}

			case "limit" :
			{
				returnvar = utils.isvalueMatch_contain(sValuesforSingleBenefit.get(16).toLowerCase(),s1);
				continue;			 
			}

			default:{
				returnvar =false;
				break;
			}
			} 
			i++;  

			}
			return returnvar;
		}
		return true;
	}

	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionFamilyLevelAccumulatorReviewBB~pzLayout_1']//table[@pl_prop='.FamilyLevelAccumList']")
	WebElement tblMemberLevelTaggedAccums;

	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionFamilyLevelAccumulatorReviewBBBB~pzLayout_3']//table[@pl_prop='.FamilyLevelAccumList']")
	WebElement tblFamilyLevelTaggedAccums;

	@FindBy(xpath="//span[contains(text(),'Items discussed with contact on Browse for Related Accumulators')]")
	WebElement lnkItemsDiscussed;

	public boolean clickItesmDiuscussed()
	{
		return utils.clickAnelemnt(this.lnkItemsDiscussed, "clickItesmDiuscussed", "Items Discussed for Tagged Accums");
	}

	public boolean validateTaggedMemberLevelAccums(String[] args)
	{
		if(this.clickItesmDiuscussed()) {
			WebElement element = this.tblMemberLevelTaggedAccums;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.validatetablerowbasedonvalues(this.tblMemberLevelTaggedAccums, args);
		}
		return false;

	}


	public boolean validateTaggedFamilyLevelAccums(String[] args)
	{
		if(this.clickItesmDiuscussed()) {
			WebElement element = this.tblFamilyLevelTaggedAccums;
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			return utils.validatetablerowbasedonvalues(this.tblFamilyLevelTaggedAccums, args);
		}
		return false;
	}


	public boolean selectReasonForContact(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpdwnReasonforRequest, args[0], "CompleteBenefitsReview", "Reason For Contact");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickOnSubmit
	 * #Description: This functionality performs click action on the Submit button in the View Program Review page
	 * #type: Textbox
	 */
	public boolean clickOnSubmit()
	{
		return utils.clickAnelemnt(this.btnSubmit, "ViewProgramReview", "Submit");
	}


}

