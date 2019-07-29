package automationLib;

import utils.SeleniumUtilities;

public class LaunchSolutionCentral {
	
	String pegaDev  		="https://solutioncentral.dev.va.antheminc.com/public/login.html";
	String pegaSIT1 		="https://solutioncentral.sit.va.antheminc.com/public/login.html";
	String pegaSIT2 		="https://solutioncentral.uat.va.antheminc.com/public/login.html";
	String pegaTraining 	="https://solutioncentral.train.va.antheminc.com/public/login.html";
	String pegaPerformance  ="https://solutioncentral.perf.va.antheminc.com/public/login.html";
	String pegaCI = "https://va10n40610.wellpoint.com:8443/prweb/PRServlet";
	String pegaURL;
	String envPath;
	
	public String getPegaURL() {
		return pegaURL;
	}

	public void setPegaURL(String pegaURL) {
		this.pegaURL = pegaURL;
	}

	/*
	 * @2123SCU
	 * #CommonMethodwithArgument:SC_UAT
	 * #Arguments:browsers
	 * Type:Dropdown
	 * Keys:IE,Chrome
	 */
	
	
	/*
	 * @121SCU
	 * #CommonMethodwithArgument:SC_SIT
	 * #Arguments:browsers
	 * Type:Dropdown
	 * Keys:IE,Chrome
	 */
	
	
	public void LaunchSolutionCentral(String env){
		//SeleniumUtilities utils = new SeleniumUtilities();
if(env.equalsIgnoreCase("SIT"))
		this.setPegaURL(pegaSIT1);
else if(env.equalsIgnoreCase("UAT"))
	this.setPegaURL(pegaSIT2);
else if(env.equalsIgnoreCase("CI"))
	this.setPegaURL(pegaCI);
		Driver.getPgDriver().get(this.getPegaURL());
	    //utils.waitForPageLoaded(60);
	    Driver.getPgDriver().manage().window().maximize();
	    String str = Driver.getPgDriver().getCurrentUrl();
	    System.out.println("The current URL is " + str);
	}
public String getEnvpath(String env){
	
	
	return envPath;              
	
}
	
}
