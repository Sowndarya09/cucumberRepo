package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extentmanager.ExtentManager;

import MongoDB.TestStatus; 


public class CustomException extends RuntimeException {
	//SeleniumUtilities utils = new SeleniumUtilities();
	
	
	public  CustomException(String msg){
		//super(msg);
		automationLib.Driver.killCloseDriver();
		System.out.println(msg);
		
	}
	public  CustomException(String msg,ExtentReports reports,ExtentTest logger,TestStatus mongotest){
		System.out.println("Custom Exception");
		if(!(ExtentManager.getTeststatus().contains("Warning")))
		{
		logger.fail( "The Test Case failed due to "+msg);
		ExtentManager.setTeststatus("Fail");
		}
		else
			logger.warning(ExtentManager.getTeststatus());
		//mongotest.setTestStatus("Fail");
		
		//reports.endTest(logger);
		//reports.flush();
		//SeleniumUtilities.setResultInJira(stepdefinition.startTime, stepdefinition.endtime, "CCTSUSTAIN-9392", false);
		//automationLib.Driver.killCloseDriver();
		System.out.println(msg); 
}
	
	public  CustomException(String msg,ExtentReports reports,ExtentTest logger){
		System.out.println("Custom Exception");
		if(!(ExtentManager.getTeststatus().contains("Pending"))){
		logger.fail( "The Test Case failed due to "+msg);
		ExtentManager.setTeststatus("Fail");
		}
		
		else
			logger.warning(ExtentManager.getTeststatus());
		//mongotest.setTestStatus("Fail");
		
		//reports.endTest(logger);
		//reports.flush();
		//SeleniumUtilities.setResultInJira(stepdefinition.startTime, stepdefinition.endtime, "CCTSUSTAIN-9392", false);
		//automationLib.Driver.killCloseDriver();
		System.out.println(msg); 
}
	
	public  CustomException(String msg,boolean isServiceDown,ExtentReports reports,ExtentTest logger,TestStatus mongotest){
		//super(msg);
		if(isServiceDown){
			logger.warning("Service down/Data issue");
			ExtentManager.setTeststatus("Warning");
			//mongotest.setTestStatus("Fail -Possible service down");
				}
		else{
			logger.fail("Test case failed");
			ExtentManager.setTeststatus("Fail");
			//mongotest.setTestStatus("Fail");
			}
		
		
		//reports.flush();
		//automationLib.Driver.killCloseDriver();
		System.out.println(msg);
		
	}
	
	public  CustomException(String msg,boolean isServiceDown,ExtentReports reports,ExtentTest logger){
		//super(msg);
		if(isServiceDown){
			logger.warning("Service down/Data issue");
			ExtentManager.setTeststatus("Warning");
			System.out.println();
			//mongotest.setTestStatus("Fail -Possible service down");
			}
		else{
			logger.fail("Test case failed");
			ExtentManager.setTeststatus("Fail");
			//mongotest.setTestStatus("Fail");
			}
		
		
		//reports.flush();
		//automationLib.Driver.killCloseDriver();
		System.out.println(msg);
		
	}
}
