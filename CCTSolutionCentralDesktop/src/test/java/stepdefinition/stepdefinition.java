package stepdefinition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import MongoDB.TestStatus;
import automationLib.Driver;
import automationLib.InteractionHeader;
import automationLib.LaunchPega;
import automationLib.MF_ReflectionHeader;
import automationLib.MemberComposite;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import extentmanager.ExtentManager;
import utils.BaseLogger;
import utils.CustomException;
import utils.ErrorLogger;
import utils.ExecutionEngine;
import utils.SeleniumUtilities;
import utils.Utilities;

public class stepdefinition {

	ErrorLogger err=new ErrorLogger();
	//ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Date date = new Date();
	public static int executionTime;
	ExecutionEngine exec = new ExecutionEngine();
	public static String ID;
	



	String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(date);
	public static long startTime, endtime;
	

	public  String name="";
	
	ExtentReports reports = ExtentManager.getInstance();
	TestStatus mongotest; 
	public static ExtentTest  logger;
	public static boolean isServicedown=false;
	public static boolean isDataIssue=false;
	SeleniumUtilities utils ;
	Utilities comnutils;
	CustomException exptn;	
	WebDriver driver = Driver.getPgDriver();
	Actions action;	
	public static ArrayList<String> screenshotpath=new ArrayList<String>();
	DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	/**
	 * @param scenario
	 * @throws Exception
	 */
	@Before
	public void before(Scenario scenario) throws Exception
	{
	
	isServicedown=false;
		logger=blogger.completeBeforeScenariologging(scenario);		
		this.comnutils = new Utilities();
		String browser =  comnutils.getPropertyvalue("browser");
		System.out.println("browser"+browser);
		String runtype = comnutils.getPropertyvalue("runtype");
		String ip = "Local";
		System.out.println("runtype"+runtype);

		boolean defectflag = false;
//		for(String tags:tagnames){
//			if(tags.contains("Defect"))	{
//				defectflag = true;
//				blogger.loginfo("Defect: "+tags);
//				ExtentManager.setTeststatus("Defect: "+tags);
//				break;
//			}
//		}
		
		if(!defectflag) {


			if (runtype.equalsIgnoreCase("Grid")){
				ip = comnutils.getPropertyvalue("ip");

			}

			Driver.setPgDriver(browser,runtype,ip);

			if (runtype.equalsIgnoreCase("Grid")){
				String scenarioID = scenario.getId(); 




				System.out.println("#SCENARIO#" + scenarioID + "#BEFORE# Scenario ID - " + scenario.getId());
				System.out.println("#SCENARIO#" + scenarioID + "#BEFORE# Scenario Name - " + scenario.getName());
				System.out.println("#SCENARIO#" + scenarioID + "#BEFORE# Scenario Status - " + scenario.getStatus());
			}

			
			LaunchPega lnchpega = new LaunchPega();
			
			String env = System.getProperty("TEST_ENVIRONMENT");
			
			try{ if(!env.equals(null)){
				System.out.println("From Bamboo Variable");
				lnchpega.launchPega(env);
				}
			else{
				
				System.out.println("if failed, taking from property file");
				lnchpega.launchPega(comnutils.getPropertyvalue("environment"));  
			}  }catch(NullPointerException e)  {
				
				env=comnutils.getPropertyvalue("environment").trim();
				lnchpega.launchPega(env);
				//System.out.println("environemnet is not set in system environemnet as well as in property file");

				//lnchpega.launchPega(comnutils.getPropertyvalue("environment"));

			}   
			
			if(!env.contains("API"))
			this.utils = new SeleniumUtilities();    
			//this.action=new Actions(Driver.getPgDriver()); 
			//ExtentManager.setTeststatus("Running");

			
			

		}

	}


	@After
	public void afterScenario(Scenario scenario) throws IOException {
	
		try
		{
		if(!utils.isProxyWebelement(MF_ReflectionHeader.disconnect))
			MF_ReflectionHeader.disconnectSession();	
		}catch(NullPointerException e)
		{
			
		}
		blogger.completeAfterScenariologging(scenario);
	
		
		
	}
	


	



	@When("^(.*) \"([^\"]*)\" ((?!data).)* \"([^\"]*)\"(.*)$")
	//And I call the "createNewInteractionResearchmember" method on the "Header" page
	public void executeMethod(String whatever,String methodname,String Whtever,String classname,String whtever)  throws Throwable{
		String imagepath;
		System.out.println(" without data");
		String loginfo= whatever+methodname.substring(0);
				utils.logMethodResultAndAttachScreenShot(methodname, classname, loginfo,exec.executeMethod("automationLib."+classname, methodname));

	}
	

	@When("^(.*) \"([^\"]*)\" (.*data) \\(([^\"]*)\\) (.*) \"([^\"]*)\"(.*)$")
	public void executeMethod(String whatever, String methodname,String wteverbeforedata,String arlistconvert,String wtverbeforepage,String classname,String whatevaftrpage) throws IOException,Throwable  {
		String imagepath;
		System.out.println("Data");
		String[] arlist=arlistconvert.split(",");
		String loginfo= whatever+methodname.substring(0);
		utils.logMethodResultAndAttachScreenShot(methodname, classname, loginfo,exec.executeMethod("automationLib."+classname, methodname, arlist));
		
	}




	//Phase 2 work in progress
	@When("(.*data) \\(([^\"]*)\\)([^.*:)\"]*)([^\"]*)$")
	//@When("^([^\"]*)(.*data) \\(([^\"]*)\\)([^.*:)\"]*)([^\"]*)$")
	//(username,password,key1:value1;key2:value2,dropdown)
	public void execute(String wtver,String arlistconvert, String wat,String methodname) throws Throwable{

		System.out.println("Entry");
		//Driver.setPgDriver("ie");
		//Driver.openSIT();
		String imagepath;		
		String[] arlist=arlistconvert.split(",");
		//String[] arlist=arlistconvert.split(",");
		//String page = methodname.substring(0, methodname.indexOf(":"));
		String page = methodname.substring(methodname.indexOf("...")+3, methodname.indexOf(":"));
		String method = methodname.substring(methodname.indexOf(":")+1);
		System.out.println("Page: " + page + "method: " + method);
		String loginfo=wtver+arlistconvert+methodname.substring(0, methodname.indexOf("..."));
		utils.logMethodResultAndAttachScreenShot(method, page, loginfo,exec.executeMethod("automationLib."+page, method, arlist));
		
		}
	

	//@When("^([^\"]*) ([:]*)$")
	//@When("^([^\"]*) ([:]*)([^\"]*)$")
	//@When("(.*data)([^.*:)\"]*)([^\"]*)$")
	//@When("/^((?!data).)*$/ ([^.*:)\"]*)([^\"]*)$")
	@When("^([^\"\\(]*)$")
	//@When("^([^\"\\(]*) ([^.*:)\"]*)([^\"]*)$")
	//@When("(.*:)([^\"]*)$")
	public void execute(String methodname) throws Throwable{

		if(methodname.contains("application is opened"))
		{
			System.out.println("Skipping application is opened on the browser"); 
		}else if(methodname.contains("testcase is passed"))
		{
			System.out.println("Testcase passed");
		}
		else{
			System.out.println("Entry new");
			String page = methodname.substring(methodname.indexOf("...")+3, methodname.indexOf(":"));
			String method = methodname.substring(methodname.indexOf(":")+1);
			String imagepath;
			System.out.println("Page " + page + "method  " + method);
			String loginfo=methodname.substring(0, methodname.indexOf("..."));
			utils.logMethodResultAndAttachScreenShot(method, page, loginfo,exec.executeMethod("automationLib."+page, method));
			
		}


	

}
}
