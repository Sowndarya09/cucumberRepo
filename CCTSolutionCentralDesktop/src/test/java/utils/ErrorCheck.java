package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automationLib.Driver;

public class ErrorCheck extends Driver  {


	/**
	 * Error in case of the blank spaces in the Page 
	 * @param sErrorMessage: Check the error message from the sheet 
	 * @param sNumberofBlanks : Will ask the paramenter being checked for the error
	 * @return
	 */

	public List<WebElement> getErrorLinksforBlankSpaceOneField(String sErrorMessage, String  sFieldCheck){	
		List<WebElement> finalPwdBoxes =new ArrayList<WebElement>();

		String xpath= null;
		// creating Xpath for the field to be checked for value
  
		if(sFieldCheck.equalsIgnoreCase("DOB")){
			xpath="//*[@id='$PpyWorkPage$pSearchString"+sFieldCheck+"TextError']";
		}
		else
		{
			xpath="//*[@id='$PpyWorkPage$pSearchString"+sFieldCheck+"Error']";
		}

		WebElement sErrorText= Driver.getPgDriver().findElement(By.xpath(xpath));
		if(sErrorText.getAttribute("title").trim().equalsIgnoreCase(sErrorMessage)){System.out.println("Pass: The required Error Messsage appears for :: "+sFieldCheck);}

		List<WebElement> pwdBoxes = Driver.getPgDriver().findElements(By.xpath(xpath));
		for (WebElement i : pwdBoxes) {
			System.out.println(i.getText());
			if(i.getText().equalsIgnoreCase("Value cannot be blank")){
				finalPwdBoxes.add(i);
				if(i.getText().trim().equalsIgnoreCase(sErrorMessage)){System.out.println("Pass: The required Error Messsage appears :: "+sFieldCheck);}


			}


		}
		//if(count==sFieldCheck.length){System.out.println("Number of blanks is equal to the presented value");}
		return finalPwdBoxes;
	}



	/**
	 * The error message at the top of the page when the parameters are wrong 
	 * @param sErrorMessage : error message page to demonstrate the error and check if the error mesage matches the text given in the specs
	 * 
	 * @return
	 */


	public String tabReturnErrorMessage(String[] sErrorMessage)
	{
		int count = 0 ;
		List<WebElement> allElements = Driver.pgDriver.findElements(By.xpath("//*[contains(@class,'layout-noheader-errors')]/li")); 

		for (WebElement element: allElements) {
			if(element.getText().trim().equalsIgnoreCase(sErrorMessage[count++]))
			{
				System.out.println("The matching text is :: "+element.getText());
			}
		}
		return null;
	}






	/**
	 * Error in case of the blank spaces in the Page 
	 * @param sErrorMessage: Check the error message from the sheet 
	 * @param sNumberofBlanks : Will ask the paramenter being checked for the error
	 * @return
	 */

	public List<WebElement> getErrorLinksforBlankSpaceAllValueBlank(String sErrorMessage, String[]  sFieldCheck , String sPageNAme){	
		List<WebElement> finalPwdBoxes =new ArrayList<WebElement>();

		String xpath= null;
		// creating Xpath for the field to be checked for value
		for(int j=0; j< sFieldCheck.length;j ++)
		{
			// for phone member Page and Research Page used the ID to check if the error has been 
			if(sPageNAme.equalsIgnoreCase("Phone Member")||sPageNAme.equalsIgnoreCase("Research"))
			{



				if(sFieldCheck[j].equalsIgnoreCase("DOB")){
					xpath="//*[@id='$PpyWorkPage$pSearchString"+sFieldCheck+"TextError']";
				}
				else
				{
					xpath="//*[@id='$PpyWorkPage$pSearchString"+sFieldCheck+"Error']";
				}
			}

			
			// For different pages Guest Contact 
			else if(sPageNAme.equalsIgnoreCase("Guest Contact"))
			{
				xpath="//*[@id='$PpyWorkPage$pGuest$ppy"+sFieldCheck+"Error']";

			}

			List<WebElement> sBlankMessages = Driver.getPgDriver().findElements(By.xpath(xpath));

			for (WebElement i : sBlankMessages) {
				if(i.getAttribute("title").equalsIgnoreCase("Value cannot be blank")){
					finalPwdBoxes.add(i);
					if(i.getAttribute("title").trim().equalsIgnoreCase(sErrorMessage)){System.out.println("Matches");}


					System.out.println(i.getText());
				}


			}
		}
		//if(count==sFieldCheck.length){System.out.println("Number of blanks is equal to the presented value");}
		return finalPwdBoxes;
	}




}
