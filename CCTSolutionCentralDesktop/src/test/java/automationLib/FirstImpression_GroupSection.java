package automationLib;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class FirstImpression_GroupSection {


	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	
	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;


	public FirstImpression_GroupSection() 
	{
		
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		
	}


	@FindBy(xpath="//label[contains(text(),'Employer Group Name')]")
	WebElement employerGroupNameHeader;

	@FindBy(xpath="//span[contains(text(),'ACCMA')]")
	WebElement employerGroupNameValue;
	
	@FindBy(xpath="//label[contains(text(),'Group Number')]")
	WebElement groupNumberHeader;
	
	@FindBy(xpath="//span[contains(text(),'C21616')]")
	WebElement groupNumberValue;
	
	@FindBy(xpath="//label[contains(text(),'Effective Date')]")
	WebElement effectiveDateHeader;
	
	@FindBy(xpath="//span[contains(text(),'01/01/2000')]")
	WebElement effectiveDateValue;
	
	@FindBy(xpath="//label[contains(text(),'Received Date')]")
	WebElement receivedDateHeader;
	
	@FindBy(xpath="//span[contains(text(),'01/03/2000')]")
	WebElement receivedDateValue;
	
	@FindBy(xpath="//label[contains(text(),'MBU')]")
	WebElement mbuHeader;

	@FindBy(xpath="//span[contains(text(),'66200000')]")
	WebElement mbuValue;

	@FindBy(xpath="//label[contains(text(),'Medical')]")
	WebElement medicalHeader;
	
	@FindBy(xpath="//span[contains(text(),'10/100 PPO 71A')]")
	WebElement medicalValue;
	
	@FindBy(xpath="//label[contains(text(), 'Dental')]")
	WebElement dentalHeader;
	
	@FindBy(xpath="//span[contains(text(),' ')]")
	WebElement dentalValue;
	
	
	@FindBy(xpath="//label[contains(text(),'RX')]")
	WebElement RXHeader;
	
	@FindBy(xpath="//span[contains(text(),'15/10')]")
	WebElement RXValue;
	

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: getGroupNameValue
	 * #Description: This functionality get the Group Name value in the Group section and stores the values.
	 * Type: Textbox
	 */
	

	public HashMap<String,String> storeValuesFromGroupSectionRows()
	{
		
			HashMap<String, String> actualValuesMap = new HashMap<String,String>();
			actualValuesMap.put("Employer Group Name", this.employerGroupNameValue.getText());
			actualValuesMap.put("Group Number", this.groupNumberValue.getText());
			actualValuesMap.put("Effective Date", this.effectiveDateValue.getText());
			actualValuesMap.put("Received Date", this.receivedDateValue.getText());
			actualValuesMap.put("MBU Code", this.mbuValue.getText());
			actualValuesMap.put("Medical", this.medicalValue.getText());
			actualValuesMap.put("Dental", this.dentalValue.getText());
			actualValuesMap.put("RX", this.RXValue.getText());
			return actualValuesMap;

	}
	

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: checkValues
	 * #Description: This functionality compare the values from the two sections.
	 * Type: Textbox
	 */


	public boolean checkValuesFromTwoSections()
	{
 
			try 
			{
				FirstImpression FI = new FirstImpression();
				FI.storevaluesFromSearchRows();
				HashMap<String,String> valuesFromTheSearchTableRow = FI.getValuesFromTheRow();
				HashMap<String,String> valuesFromTheGroupSectionRow = storeValuesFromGroupSectionRows();
				Set<String> keys = valuesFromTheSearchTableRow.keySet();
				int columnCount = 0;
				for(String key:keys)
				{
					System.out.println("The keys are: " + key);
					String testValue = valuesFromTheSearchTableRow.get(key);
					System.out.println("The test values are: " + testValue);
					String actualvalue = valuesFromTheGroupSectionRow.get(key);
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
					err.logError("FirstImpression_GroupSection", "Values in not checked");
					return false;
				}
				
			
			}catch(Exception e)
			{
				err.logError("FirstImpression_GroupSection", "Values doesnt match properly");
				return false;
			}
			
			
	}





}
