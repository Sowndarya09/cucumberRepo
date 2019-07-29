package utils;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import automationLib.Driver;
import automationLib.InteractionHeader;
import cucumber.api.Scenario;
import extentmanager.ExtentManager;
import stepdefinition.stepdefinition;

public class BaseLogger {
	
	 
public static ArrayList<String> resultarray = new ArrayList<String>();
private Utilities comnutils;
private long startTime;
ExtentReports reports = ExtentManager.getInstance();
ExtentTest logger;
	
public void setResultArray(int index, String value){
	
	//resultarray.set(index, value);
	resultarray.add(index,value);
}

	
	public void logMessage(String pgname, String elementname){
		
		System.out.println("Action on page:" +pgname+ " &obejct:" +elementname+" is completed successfully");
		//stepdefinition.logger.info("Action on page:" +pgname+ " &obejct:" +elementname+" is completed successfully");
			}
public void logtestcasesucces(String testcase){
		
		System.out.println("Successfully executed: " +testcase);
		
			}
public void logCommonMethodSuccessMessage(String pgname, String methodname){
	System.out.println("Commonmethod:" +pgname+ " &obejct:" +methodname+" is completed successfully");
	
	resultarray.add("Passed");
}
public void logCommonMethodSuccessMessage(String msg,ExtentTest logger){
	//System.out.println("Commonmethod:" +pgname+ " &obejct:" +methodname+" is completed successfully");
	
	logger.pass( msg);
	/*String imagepath = utils.takescreenshot("dummy","dummy" );
	if (imagepath!=null)
		try {
			logger.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	resultarray.add("Passed");
}
public void logCommonMethodfailure(String msg,ExtentTest logger){
		logger.pass( msg);
	}
public void loginfo(String message){
stepdefinition.logger.info(message)	;
}

public void logserviceDown(){
loginfo("Service Down/Data issue");	
stepdefinition.isServicedown=true;
}

public void logserviceDownForBrowserNotInvoked(){
loginfo("Browser not invoked..");	
stepdefinition.isServicedown=true;
}

public void loginfo(String expected, String actual){
stepdefinition.logger.info("EValue:" +expected +"\n"
		+"AValue:" +actual)	;
}

public void lognotexecuted(int start,int end, int lastrowinexcel){
	if(!(end==0)){
	for (int i=start;i<end;i++)	
	resultarray.add("Not Exceuted");
    SeleniumUtilities.screenshotpath.add("Not Executed");
	}
	else{
		for (int i=start;i<=lastrowinexcel;i++)	
			resultarray.add("Not Executed");
		SeleniumUtilities.screenshotpath.add("Not Executed");
	}
}
public ExtentTest completeBeforeScenariologging(Scenario scenario){
	System.out.println("Scenario ID " +scenario.getSourceTagNames());
	System.out.println("Scenario Name" +scenario.getName());
	String temp=scenario.getId().split(";")[1];
	Collection <String>  tagnames=scenario.getSourceTagNames();
	ExtentManager.setTagNames(tagnames);	
	String name=scenario.getId().split(";")[0];
	this.comnutils = new Utilities();
	/* Commenting out mongo options till the real time report is setup
	mongotest= new TestStatus(name, "Running",System.getProperty("TEST_BUILD"));
	mongotest.updateBuild();
	mongotest.writenewBuild();
	 */
	//mongotest.setTestStatus("running");

	if (name.length()<1)
		name=temp.replaceAll("-"," ");				

	DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	startTime = System.nanoTime();
	System.out.println("Start time#####" +startTime);
	stepdefinition.executionTime=300;
ExtentTest logger=reports.createTest(name,temp.replaceAll("-"," "));
ExtentManager.setTeststatus("Running");
ExtentManager.setExecutionTime(0);
ExtentManager.setDebugMessage("None");
ExtentManager.setLogger(logger);
	return logger;
	}



public void completeAfterScenariologging(Scenario scenario){
	ExtentManager.setTeststatus(scenario.getStatus());
	if(ExtentManager.getTeststatus()!="Fail"){
		//ExtentManager.setTeststatus("Pass");
		ExtentManager.setExecutionTime(stepdefinition.executionTime);
	}
	reports.flush();
	long endtime = System.nanoTime();

	System.out.println("<BuildNumber>"+System.getProperty("TEST_BUILD")+"</BuildNumber>"+"<BuildStartTime>"+System.getProperty("TEST_EXECUTION_REPORT")+"</BuildStartTime>"
			+"<TestID>"+ExtentManager.getReportName()+"</TestID>"+"<ModuleName>"+ExtentManager.getTagNames()+"</ModuleName>"
			+"<TestStatus>"+ExtentManager.getTeststatus()+
			"</TestStatus>"+"<TestExecutionTime>"+stepdefinition.executionTime+
			"</TestExecutionTime>"+"<TestElapsedtime>"+((endtime-startTime)/1000000000)+"</TestElapsedtime>"
			+"<TestReport>https://va10n40601.wellpoint.com/public/SC-QA/" + System.getProperty("TEST_TYPE") + "TestExecutionResults/" + System.getProperty("TEST_NAME") + "/" + System.getProperty("TEST_ENVIRONMENT") + "/" + System.getProperty("TEST_EXECUTION_REPORT") + "_" + System.getProperty("TEST_BUILD") + "/DetailedReport/" + ExtentManager.getReportName() + ".html" + "</TestReport>"   
			+"<DebugMessage>"+ExtentManager.getDebugMessage()+"</DebugMessage>"
			+"<MemberID>"+InteractionHeader.getmemberID+"</MemberID>"
			+"<InteractionID>"+InteractionHeader.getInteractionID()+"</InteractionID>"
			);

	String scenarioID = scenario.getId();  
	System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Scenario ID - " + scenario.getId());
	System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Scenario Name - " + scenario.getName());
	System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Scenario Status - " + scenario.getStatus());

	try {
		Driver.getPgDriver().close();
		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Browser Closed.");

		Driver.getPgDriver().quit();
		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Driver Quit.");

		if(comnutils.getPropertyvalue("runtype").equals("Grid")) {
			try {
				Driver.customServlet.terminatePirateProcess();
				System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Process(s) terminated.");
			}catch(NullPointerException e) {
				System.out.println("Driver NullPointer: "+e);
			}
		}

		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Scenario execution is complete.");

		if(comnutils.getPropertyvalue("runtype").equals("Grid"))

		{

			Driver.getPgDriver().close();
			System.out.println("#SCENARIO#" + scenarioID + "#AFTER# Browser Closed.");

			Driver.getPgDriver().quit();
			System.out.println("#SCENARIO#" + scenarioID + "#AFTER# Driver Quit.");

			Driver.customServlet.terminatePirateProcess();
			System.out.println("#SCENARIO#" + scenarioID + "#AFTER# Process(s) terminated.");
			System.out.println("#AFTER SCENARIO#" + scenarioID + "# Scenario execution is complete.");
		}
	}catch(WebDriverException e) {
		System.out.println("WebDriverException: "+e);
	}

}
}
