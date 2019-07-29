package utils;

import automationLib.Driver;
import extentmanager.ExtentManager;
import stepdefinition.stepdefinition; 


public class ErrorLogger extends Driver 
{
	Driver d=new Driver();
	 String errormessage = "";
	 public String getErrormessage(){
		 
		 return ExtentManager.getErrorMessage();
	 }
	 
	 public void setErrormessage(String msg){
		 ExtentManager.setErrorMessage(msg);
	 }

	 public void logremoteNotconnectedError(Exception e) {
		 
			errormessage=e.toString();
			this.setErrormessage(errormessage);
			stepdefinition.logger.info(errormessage);
			stepdefinition.logger.warning("Remote Did not conenct");
			
			
	 }
	public void logError(Exception e,String message) 
	{
		
		String e1=e.toString();
		if(e1.contains("NoSuchElementException"))
		{
		System.out.println("The object for "+message+" field is not found on the page. Either the property has been changed .Kindly take a look" );
		setErrormessage("The object for "+message+" field is not found on the page. Either the property has been changed .Kindly take a look");
		stepdefinition.logger.info(errormessage);
		}
		else if(e1.contains("ElementNotSelectableException"))
		{
			System.out.println("The object for "+message+" field is not selectable.Kindly check the property of the object" );
			setErrormessage("The object for "+message+" field is not selectable.Kindly check the property of the object");
			stepdefinition.logger.info(errormessage);
		}
		else if ( e1.contains("NoAlertPresentException"))
		{
			System.out.println("There is no alert present on the page. kindly check if the object your looking for is present in an alert, popup or a window" );
			setErrormessage("There is no alert present on the page. kindly check if the object your looking for is present in an alert, popup or a window");
			stepdefinition.logger.info(errormessage);
		}
		else if(e1.contains("NoSuchAttributeException"))
		{
			System.out.println("There is no such attribute for the object" +message+ "on the current page" );
			setErrormessage("There is no such attribute for the object" +message+ "on the current page");
			stepdefinition.logger.info(errormessage);
		}
		else if(e1.contains("StaleElementReferenceException"))
		{
		errormessage="Stale element, the element is changing while action is performed, please check"	;
		setErrormessage(errormessage);
		stepdefinition.logger.info(errormessage);
		}
		else if(e1.contains("WebDriverException"))
		{
		errormessage=e1.toString()+message	;
		setErrormessage(errormessage);
		stepdefinition.logger.info(errormessage);
		
		}
		else if (e1.contains("NoSuchWindowException")){
			errormessage=e1.toString()+message;
			setErrormessage(errormessage);	
			stepdefinition.logger.info(errormessage);
		}
		else{
		errormessage= e1.toString()+message;
		setErrormessage(errormessage);	
		stepdefinition.logger.info(errormessage);
		}
		
		this.exitTest(d);
		
		
	}
public void logError(String pageName, String elementname){
	
	System.out.println("Please check the identifer in page " +pageName +"of element "+elementname);
	errormessage ="Please check the identifer in page " +pageName +"of element "+elementname;
	stepdefinition.logger.info(errormessage);
	ExtentManager.setDebugMessage("Potentialassertionerror"+ExtentManager.getDebugMessage());
	this.exitTest(d);
}

public void logError(String pageName){
	
	System.out.println("Either page " +pageName +"is not loaded in the stipulated time or the validation given for page needs to be checked ");
	errormessage ="Either page " +pageName +"is not loaded in the stipulated time or the validation given for page needs to be checked ";
	stepdefinition.logger.info(errormessage);
	this.exitTest(d);
}

public void commonExecutorlogError(String pageorMethodname){
	
	System.out.println(pageorMethodname + " mismatches with the given parameters in Commonexecutor please check to make sure  input xls is correct ");
	errormessage=pageorMethodname + " mismatches with the given parameters in Commonexecutor please check to make sure  input xls is correct ";
	stepdefinition.logger.info(errormessage);
	this.exitTest(d);
}

public void logcommonMethodError(String pagename,String methodname) throws CustomException{
	
	System.out.println("Action: " +methodname+"on page"+pagename+"was not successful");
	if (errormessage.equals(""))
	errormessage ="Action: " +methodname+"on page"+pagename+"was not successful";
	stepdefinition.logger.info(errormessage);
	//resultarray.add("Action: " +methodname+"on page"+pagename+"was not successful")
	//throw new CustomException(errormessage);
	//this.exitTest(d);
}

public void logcustomerrorwithmessage(String pagename,String methodname,String message) throws CustomException{
	
	System.out.println("Action: " +methodname+"on page"+pagename+"was not successful.-> "+message);
	
	errormessage ="Action: " +methodname+"on page"+pagename+"was not successful . ->  "+message;
	stepdefinition.logger.info(errormessage);
	
	//resultarray.add("Action: " +methodname+"on page"+pagename+"was not successful")
	//throw new CustomException(errormessage);
	//this.exitTest(d);
}
public void logerrormessage(String message) throws CustomException{
	
	errormessage =message;
	stepdefinition.logger.info(errormessage);
	
	//resultarray.add("Action: " +methodname+"on page"+pagename+"was not successful")
	//throw new CustomException(errormessage);
	//this.exitTest(d);
}

public void logvaluenotmatch(String actual,String expected) throws CustomException{
	
	errormessage ="EValue:" +expected +"\n"
			+"AValue:" +actual;
	stepdefinition.logger.info(errormessage);
	
	
	//resultarray.add("Action: " +methodname+"on page"+pagename+"was not successful")
	//throw new CustomException(errormessage);
	//this.exitTest(d);
}
public void logvaluenotmatch(String actual,String expected,boolean isServicedown) throws CustomException{
	
	errormessage ="EValue:" +expected +"\n"
			+"AValue:" +actual;
	stepdefinition.logger.info(errormessage);	
	
	//resultarray.add("Action: " +methodname+"on page"+pagename+"was not successful")
	//throw new CustomException(errormessage);
	//this.exitTest(d);
}


public void logcommonMethodError(String pagename,String methodname,Exception exception) throws CustomException{
	
	System.out.println("Action: " +methodname+"on page"+pagename+"was not successful due to "+exception);	
	errormessage ="Action: " +methodname+"on page"+pagename+"was not successful due to "+exception;
	stepdefinition.logger.info(errormessage);	
}


public  void exitTest(Driver d){
	BaseLogger.resultarray.add(errormessage);
	//MainDriverTest.finalresult.add("FAIL");
	//d.pgDriver.close();
	//errormessage ="";
// print the final error message here
	//d.pgDriver.quit();
	//System.exit(0);
}
}
