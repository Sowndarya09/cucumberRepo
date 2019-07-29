package extentmanager;

import java.util.Collection;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
    
    static ExtentReports extent;
    static String reportname;
    static String teststatus;
    static String debugMessage;
    public static String getErrorMessage() {
		return errorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		ExtentManager.errorMessage = errorMessage;
	}

	static String errorMessage;
    public static String getDebugMessage() {
		return debugMessage;
	}

	public static void setDebugMessage(String debugMessage) {
		ExtentManager.debugMessage = debugMessage;
	}

	static int executionTime;
   // static String tagNames;
    static String module ="NotDefined";
    static Collection <String> tagNames;
    static ExtentTest logger;
	public static String getTagNames() {
		//String[] moduleName ={"Benefits","Billing","claims","SelectAssociatedContact","ManageIDCard","Manage_Claims","Grievance&Appeal","ManageInsurance"};
		String[] moduleName = {"AccessDocuments","Accumulators","Billing","Benefitperiod","Benefits","Billing","Billing&Enrollment",
				"CDHP","Chat","CreateCorrespondence","Employeestatus","ExitInteractions","FI_IQT","Grievance&Appeal","Groupsearch","GuestContact",
				"InteractionHeader","LimitedLiability","LimitedLiabilityReview","LookUpCode","ManageClaims","ManageIDCard","MemberComposite",
				"MemberMaintenance","Pre-Certification","PromisedActions","Provider","RequestClaimAdjustment","RequestManagerHelp","RestrictedAcces",
				"ReviewSR","SearchBuClaimNumber","SearchInventory","SearchMember","SelectAssociatedContact","WrapUp","smoketest"};
		
		for(String tags:tagNames){
			if(tags.contains("CCTSUSTAIN"))	
				continue;
				 for(String mod:moduleName)
				 { 
					 if(tags.contains(mod))
						 module =mod;
				
				 }
			
				}
		return module;
	}

	public static void setTagNames(Collection<String> tagnames) {
		ExtentManager.tagNames=tagnames;
		
		 
		
	}

	public static int getExecutionTime() {
		return executionTime;
	}

	public static void setExecutionTime(int executionTime) {
		ExtentManager.executionTime = executionTime;
	}

	public static ExtentReports getInstance() {
        return extent;
    }
    
    public static void setreportname(String name) {
    	reportname = name.substring(name.lastIndexOf("\\")+1).replace(".html","");
       
    }
    public static String getReportName(){
    	return reportname;
    }
    public static void setTeststatus(String status){
    	System.out.println(status);
    	teststatus =status;
    }
    
    public static String getTeststatus(){
    	return teststatus ;
    }
    
  public static String getModuleName(String tags) {
	  
	
	  return module;
  } 
    
    public static ExtentReports createInstance(String fileName) {
    	setreportname(fileName);
    	setTeststatus("Running");
    	setDebugMessage("");
    	setErrorMessage("Default");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        htmlReporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);        
        return extent;
    }

	public static void setLogger(ExtentTest logger) {
	ExtentManager.logger=logger;
		
	}

	public static ExtentTest getLogger() {
		
		return logger;
	}
    
}