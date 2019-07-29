package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class CorrespondenceSRReview extends Driver {

	/**
	 * Methods in the Program 
	 */
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	WebDriverWait wait=new WebDriverWait(Driver.getPgDriver(),20);
	BaseLogger blogger = new BaseLogger();
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Correspondence class defining the Iframe and the Page Factory  
	 */
	public CorrespondenceSRReview() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}


	@FindBy(xpath="//*[@data-test-id='20160310125546027711757']")
	WebElement ReasonForContact;

	@FindBy(xpath="//*[@data-test-id='2016031012554602781281']")
	WebElement Notes;

	/**Validates Reason for Contact and Notes
	 * 
	 */
	public boolean verifyReasonForContactAndNotes(String[] args) {
		boolean returnvar ;
		returnvar = true;
		String keyvaluepair="";	
		for(String iterator : args)
		{
			keyvaluepair = iterator;
			if(!returnvar)
			{
				err.logcommonMethodError("CorrespondenceSRReview", "Check your "+keyvaluepair+" Either Your input is wrong or the value found on application is incorrect");
				return false;
			}
			String key = iterator.substring(0, iterator.indexOf(":"));
			String value = iterator.substring(iterator.indexOf(":")+1);

			if(utils.isvalueMatch_contain(key,"ReasonForContact")){
				returnvar = utils.validateLabel(ReasonForContact, value);
				continue;}
			else if(utils.isvalueMatch_contain(key,"Notes")){
				returnvar = utils.validateLabel(this.Notes,value);
				continue;
			}

			else 
				err.logcommonMethodError("CorrespondenceSRReview", "Check your key in yourkeypair. Make sure you are following the same pattern for input");
			return false;
		}

		if(returnvar){
			blogger.loginfo("PASS: Reason For contact and Notes Verified successfully");
			return true;	
		}else{
			blogger.loginfo("CorrespondenceSRReview", "FAIL: The value doesnt match with the one in application");
			return false;
		}
	}

	@FindBy(xpath="//*[@data-test-id='20180319005640055067500']/ancestor::table[@class='gridTable ']")
	WebElement LetterSentTable;
	
	/**Validates the letters sent
	 * 
	 */
	public boolean verifyLetterSent(String[] args) {
		String[] keyvaleupair = args;
		System.out.println("Keyvaluepair size is: "+ keyvaleupair.length);
		Hashtable<String, String[]> columnvaluesmap = new Hashtable<String, String[]>();
		String inputcolumnvaluemap[][] = new String[keyvaleupair.length][2];
		String[] keys = keyvaleupair;
		int index = 0;
		int i = 0;
		ArrayList<String> returncolumn = new ArrayList<String>();
		int somevalue = 1;
		for (String iterator : keyvaleupair) { 
			keys = iterator.split(":");
			inputcolumnvaluemap[i][0] = keys[0];
			inputcolumnvaluemap[i][1] = keys[1];
			i = i + 1;
			returncolumn = utils.getcolumnStringFromTableByName(LetterSentTable, keys[0]);
			System.out.println("Values in return column: "+returncolumn);
			String[] values = new String[returncolumn.size()];
			columnvaluesmap.put(keys[0], returncolumn.toArray(values));
		}
		int k = 0;
		for (int j = 0; j < returncolumn.size(); j++) {
			if (k == keyvaleupair.length)
				break;
			String column = inputcolumnvaluemap[k][0];
			String value = inputcolumnvaluemap[k][1];
			String[] columnvalues = columnvaluesmap.get(column);
			if (columnvalues[j].contains(value)) {
				index = j;
				
				while (k < keyvaleupair.length) {
					column = inputcolumnvaluemap[k][0];
					value = inputcolumnvaluemap[k][1];
					columnvalues = columnvaluesmap.get(column);
					System.out.println("Input value: "+ value + " " + "And the value in the tables are: " + columnvalues[j]);
					if (columnvalues[j].contains(value)) {
						System.out.println("K size is: "+ k);
						k = k + 1;
						continue;
					} else {
						index = -1;
						break;
					}
				}
			}
		}
		List<WebElement> allRows = LetterSentTable.findElements(By.tagName("tr"));
		if (index != -1) {
			if (allRows.size() > 0)
			System.out.println("Values matched with the row");
		} else {
			System.out.println("Values doesnt matched with row");
			return false;
		}
		System.out.println("The row with the matching arguements" + index);
		return true;
	}

}
