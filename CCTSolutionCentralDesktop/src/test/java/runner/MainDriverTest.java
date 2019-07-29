package runner;
import java.io.File;
import java.nio.file.CopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import extentmanager.ExtentManager;

@RunWith(Cucumber.class)
@CucumberOptions(
				//plugin={"html:Feature/cucumber-html-report"},
				plugin={"json:Destination/cucumber.json"},
				//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
						//features = "Database_POC",glue={"stepdefinition"},tags={"@DBResearch"})
						//features = "test1",glue={"stepdefinition"},tags={"@CCTSUSTAIN-69451_01"})
						//features = "src\\test\\resources\\features",glue={"stepdefinition"},tags={"@CCTSUSTAIN-39851"})
						//features = "src\\test\\resources\\features_Sprint",glue={"stepdefinition"},tags={"~@CCTSUSTAIN-3165"})
features = "Claim_Redesign_Features",glue={"stepdefinition"},tags={"@RequiresAdjustment"})
									
					

public class MainDriverTest {

	private static final CopyOption REPLACE_EXISTING = null;
	
	public static String buildNumber= System.getProperty("TEST_BUILD");;
	public static String reportName=System.getProperty("TEST_EXECUTION_REPORT");
	public static String reportLocation = "TestExecutionRecords\\" + buildNumber + "\\Reports\\";
	static Date date=new Date();
	//public static ExtentReports reports ;
	//public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter( "_Report1.html");
	@BeforeClass
	public static void setUp() {
		 
		//SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
		
		//String buildNumber = System.getProperty("TEST_BUILD");
		//String reportName = System.getProperty("TEST_EXECUTION_REPORT");
		//String reportLocation = null;
		File report=null;
		
		try {
			if (!reportName.isEmpty() && !buildNumber.isEmpty()) {
				new File ("TestExecutionRecords//" + buildNumber + "//Reports").mkdirs();
				new File ("TestExecutionRecords//" + buildNumber + "//Screenshots").mkdirs();
				timeStamp = reportName;
				//reportLocation = "TestExecutionRecords\\" + buildNumber + "\\Reports\\";
				 
				/* report = new File(reportLocation + timeStamp + "_Report.html");
				
				//if(!report.exists())
					report.createNewFile();*/
					
				
				
				System.out.println("Report Location : " + reportLocation);
			} else {
				reportLocation = "C:\\SolutionCentralEngine\\ExtentReports\\";
				System.out.println("Report Location : " + reportLocation);
			}
		} catch (NullPointerException e) {
			reportLocation = "C:\\SolutionCentralEngine\\ExtentReports\\";
			System.out.println("Report Location : " + reportLocation);
		}
		
		/*catch (IOException e) {
			
			System.out.println("Report is open ");
		}*/
					
		System.out.println("Test Exceution Report : " + reportLocation + timeStamp + "_Report.html");	
		
		/*ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportLocation + timeStamp + "_Report.html");;
		//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter( "_Report1.html");;
		*/
		/*htmlReporter.setAppendExisting(true);	
		reports.attachReporter(htmlReporter);*/
		ExtentManager.createInstance(reportLocation + timeStamp + "First_Report.html");
		
		
			
	}
	
	@AfterClass
	public static void wrapUp() {
		
		
	}
}	
				