package automationLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class GroupDetailsReview {



	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;



	public GroupDetailsReview() 
	{

		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}


	@FindBy(id="ContactReason")
	WebElement drpDownReasonForContact;

	@FindBy(xpath="//textarea[@name='$PpyWorkPage$pNotes']")
	WebElement txtNotes;

	@FindBy(xpath="//span[contains(text(),'Group Details Reviewed with Contact on Group Search')]")
	WebElement lnkGroupDetailsReviewedWithContact;

	@FindBy(xpath="//span[contains(text(),'Benefits Reviewed With Contact on Benefits Overview')]")
	WebElement lnkBenefitsReviewedWithContactOnBenefitsReview;

	@FindBy(xpath="//table[@pl_prop='.ReviewedGroups']")
	WebElement tblGroupDetailsReviewWithContact;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[1]//following-sibling::td//span")
	WebElement employerGroupNameValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[2]//following-sibling::td//span")
	WebElement employerGoupNumberValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[4]//following-sibling::td//span")
	WebElement employerGroupStatusValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[5]//following-sibling::td//span")
	WebElement productGroupNumberValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[6]//following-sibling::td//span")
	WebElement productGroupEffectiveDateValue;

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[7]//following-sibling::td//span")
	WebElement productTypeValue;	

	@FindBy(xpath="//tr[@id='$PGroupSearchList$ppxResults$l1']//td[8]//following-sibling::td//span")
	WebElement contractCodeValue;


	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement btnSubmit;


	@FindBy(xpath="//table[@pl_prop='.ReviewedBenefitsContingency']")
	WebElement tblBenfitsOverviewReview;



	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectReasonForContactOption
	 * #Description: This functionality selects the reason for contact option in the complete manage id card review page 
	 * #Argument: contactoption
	 * Type: DropDown
	 * keys: Select#New Member#Change in Policy/Plan#Open Enrollment Question#Other
	 */
	public boolean selectReasonForContactOption(String[] contactoption) throws InterruptedException
	{
		Thread.sleep(2000);
		return utils.selectDropDownbyVisibleString(drpDownReasonForContact, contactoption[0], "GroupDetailsReview", "Reason for Contact option");
	}

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterNotes
	 * #Description: This functionality enters the notes in the respective section in Complete Manage ID card review page
	 * #Argument: notes
	 * Type: Textbox
	 */
	public boolean enterNotes(String[] notes)
	{
		return utils.enterTextinAnelemnt(txtNotes, notes[0], "GroupDetailsReview", "Notes");
	}


	public boolean clickLinkGroupDetailsReviewedWithContact()
	{
		return utils.clickAnelemnt(lnkGroupDetailsReviewedWithContact, "GroupDetailsAndBenefitsSelection", "Group Details Link");
	}

	public boolean clickLinkBenefitsReviewedWithContactOnBenefitsReview()
	{
		return utils.clickAnelemnt(lnkBenefitsReviewedWithContactOnBenefitsReview, "GroupDetailsAndBenefitsSelection", "Benefits Overview Review Lnk");
	}

	public HashMap<String,String> storeValuesFromGroupDetailsReviewRows()
	{

		HashMap<String, String> actualValuesMap = new HashMap<String,String>();
		actualValuesMap.put("Employer Group Name", this.employerGroupNameValue.getText());
		actualValuesMap.put("Employer Group Number", this.employerGoupNumberValue.getText());
		actualValuesMap.put("Employer Group Status", this.employerGroupStatusValue.getText());
		actualValuesMap.put("Product Group Number", this.productGroupNumberValue.getText());
		actualValuesMap.put("Product Group Effective Date", this.productGroupEffectiveDateValue.getText());
		actualValuesMap.put("Product Type", this.productTypeValue.getText());
		actualValuesMap.put("Contract Code", this.contractCodeValue.getText());
		return actualValuesMap;

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: checkValuesFromGroupSearchAndGroupReviewSections
	 * #Description: This functionality check the values from the Group Search Rows and the Group Details Rows sections
	 * Type: Textbox
	 */
	public boolean checkValuesFromGroupSearchAndGroupReviewSections()
	{
		try 
		{
			GroupSearch GS = new GroupSearch();
			GS.storeValuesFromGroupSearchRows();
			HashMap<String,String> valuesFromTheGroupSearchTableRow = GS.getValuesFromGroupSearchRow();
			HashMap<String,String> valuesFromTheGroupDetailsReviewRow = storeValuesFromGroupDetailsReviewRows();
			Set<String> keys = valuesFromTheGroupSearchTableRow.keySet();
			int columnCount = 0;
			for(String key:keys)
			{
				System.out.println("The keys are: " + key);
				String testValue = valuesFromTheGroupSearchTableRow.get(key);
				System.out.println("The test values are: " + testValue);
				String actualvalue = valuesFromTheGroupSearchTableRow.get(key);
				System.out.println("The actual values are: " + actualvalue);
				if(testValue.equals(actualvalue))
				{
					columnCount++;
				}
			}
			if(columnCount==8)
			{
				System.out.println("Values in both the section are same");
				return true;
			}
			else
			{
				err.logError("GroupDetailsReview", "Values in not checked");
				return false;
			}
		}catch(Exception e)
		{
			err.logError("GroupDetailsReview", "Values doesnt match properly");
			return false;
		}	
	}


	public List<String> getCategoriesFromTable(WebElement table, List<String> selectionList)
	{
		System.out.println("Entered into the Table Method");
		List<String> displayList = new ArrayList<String>();
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		System.out.println("Size of All Rows is: " +allRows.size());
		System.out.println("Values in allRows is: "+ allRows);
		if(allRows.size() > 0)
		{
			for(WebElement row : allRows)
			{
				List<WebElement> allColsByRow = row.findElements(By.tagName("td"));
				if(allColsByRow.size() > 0)
				{
					System.out.println("Size of the allcols row is:" + allColsByRow.size());
					System.out.println("All cols row value is: "+ allColsByRow);
					displayList.add(allColsByRow.get(1).getText() + "-" + allColsByRow.get(0).getText());
				}
			}
		}
		System.out.println("Display List is: "+ displayList);
		return displayList;	
	}


	public boolean checkCategoriesAndSelection(String[] inputValues)
	{
		GroupDetailsAndBenefitsSelection GD = new GroupDetailsAndBenefitsSelection();
		List<String> selectedList = GD.getSelectedCategoriesCheckBoxes(inputValues);
		System.out.println("Values in Selected List are: "+ selectedList);
		this.clickLinkBenefitsReviewedWithContactOnBenefitsReview();
		List<String> tableList = getCategoriesFromTable(tblBenfitsOverviewReview, selectedList);
		System.out.println("Values in table List are: "+ tableList);
		for(String item : selectedList)
		{
			if(!tableList.contains(item))
			{
				return false;
			}
		}
		return true;
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickBtnSubmit
	 * #Description: This functionality clicks the submit button in the Group Details Review page
	 * Type: Textbox
	 */
	public boolean clickBtnSubmit()
	{
		return utils.clickAnelemnt(btnSubmit, "GroupDetailsReview", "Submit");
	}

}
