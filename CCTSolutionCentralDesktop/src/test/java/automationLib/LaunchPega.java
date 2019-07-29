package automationLib;

import utils.BaseLogger;
import utils.SeleniumUtilities;



public class LaunchPega {
	
	String pegaDev  		="https://solutioncentral.dev.va.antheminc.com/public/login.html";
	String pegaSIT1 		="https://solutioncentral.sit.va.antheminc.com/public/login.html";
	String pegaSIT2 		="https://solutioncentral.uat.va.antheminc.com/public/login.html";
	String pegaTraining 	="https://solutioncentral.train.va.antheminc.com/public/login.html";
	String pegaPerformance  ="https://solutioncentral.perf.hb.antheminc.com/prweb/sso";
			//"https://solutioncentral.perf.va.antheminc.com/public/login.html";
	String pegaCI = "https://va10n40610.wellpoint.com:8443/prweb/PRServlet";
	String pegaupgrade1 = "https://solutioncentral.pegasds.va.antheminc.com:1024/public/login.html";
	String pegaupgrade2= "https://va33dlvpeg302.wellpoint.com:8787/prweb/PRServlet";
//	String Offcycle = "https://solutioncentral.pegasd.va.antheminc.com:1024/prweb/sso";
	String Offcycle = "https://solutioncentral.offcyclestg.antheminc.com:1024/prweb/sso";
	String SIT_PRIME = "https://va33tlvihs328.wellpoint.com:1024/prweb/sso";
	String HAS ="https://VA33TLVIHS353.wellpoint.com/prweb";
	String Peganew ="https://solutioncentral.pegasds.va.antheminc.com:1024/prweb/sso/";
	String Portal = "http://30.118.128.18:8080/prweb/PRServlet";
	//String peganewco = "https://va33dlvpeg317.wellpoint.com:8444/prweb/PRServlet/";
	
	//String peganewco = "https://va33dlvihs321.wellpoint.com:1025/prweb/";
	
	String peganewco = "https://va33tlvihs441.wellpoint.com:1025/prweb/";
	
	String puma = "https://beaconqa.corp.agp.ads/prweb/PRServletLDAP2/beEBp4uRVTogorRwSwWqbOtn9IL2fwdI*/!STANDARD";
	String pegaURL;
	String envPath;
	String prod ="https://solutioncentral.antheminc.com/prweb/sso/drc6IS9uuupODtFWD5ZU65zhPdDKtfO30eUPnDeaiMtiFg0AwyCklw%5B%5B*/!STANDARD?";
	String majorsit = "https://solutioncentral.majorsit.antheminc.com:1024/public/login.html";
	String majorstg = "https://solutioncentral.majorstg.antheminc.com:1024/public/login.html";
	String majorci = "https://solutioncentral.majorci.antheminc.com:8489/prweb/jadoBWQuXLrCIlaJeq5WTQ1qPlPdhG5B*/!STANDARD?";
	String minorci= "https://solutioncentral.minorci.antheminc.com:8488/prweb/jadoBWQuXLrCIlaJeq5WTQ1qPlPdhG5B*/!STANDARD?";
	String minorsit = "https://solutioncentral.minorsit.antheminc.com/public/login.html";
	String minorstg = "https://solutioncentral.minorstg.antheminc.com/public/login.html";
	String MF = "https://zfe.wellpoint.com:7443/zfe/";
	String TrainHB="https://va33tlvihs352.wellpoint.com/prweb/sso";
	
	String dev = "https://solutioncentral.dev.va.antheminc.com/prweb/jadoBWQuXLrCIlaJeq5WTQ1qPlPdhG5B*/!STANDARD";
	
	String Sandbox = "https://va33tlvihs303.wellpoint.com:1025/prweb/sso/";
	
	BaseLogger blogger = new BaseLogger();

	
	public String getPegaURL() {
		return pegaURL;
	}

	public void setPegaURL(String pegaURL) {
		this.pegaURL = pegaURL;
	}
	
	public void launchPega(String env){
		//SeleniumUtilities utils = new SeleniumUtilities();
		if (env.equalsIgnoreCase("SIT"))
			this.setPegaURL(pegaSIT1);
		else if (env.equalsIgnoreCase("UAT"))
			this.setPegaURL(pegaSIT2);
		else if (env.equalsIgnoreCase("CI"))
			this.setPegaURL(pegaCI);
		else if (env.equalsIgnoreCase("Upgrade"))
			this.setPegaURL(pegaupgrade1);
		else if (env.equalsIgnoreCase("TRAIN"))
			this.setPegaURL(pegaTraining);
		else if (env.equalsIgnoreCase("PERF"))
			this.setPegaURL(pegaPerformance);
		else if (env.equalsIgnoreCase("PUMA"))
			this.setPegaURL(puma);		
		else if (env.equalsIgnoreCase("Offcycle"))
			this.setPegaURL(Offcycle);
		else if (env.equalsIgnoreCase("NEWCO"))
			this.setPegaURL(peganewco);
		else if (env.equalsIgnoreCase("prod"))
			this.setPegaURL(prod);
		else if (env.equalsIgnoreCase("SIT_PRIME"))
			this.setPegaURL(SIT_PRIME);
		else if (env.equalsIgnoreCase("HAS"))
			this.setPegaURL(HAS);
		else if (env.equalsIgnoreCase("majorsit"))
			this.setPegaURL(majorsit);
		else if (env.equalsIgnoreCase("majorstg"))
			this.setPegaURL(majorstg);
		else if (env.equalsIgnoreCase("majorci"))
			this.setPegaURL(majorci);
		else if (env.equalsIgnoreCase("minorci"))
			this.setPegaURL(minorci);
		else if (env.equalsIgnoreCase("minorsit"))
			this.setPegaURL(minorsit);
		else if (env.equalsIgnoreCase("minorstg"))
			this.setPegaURL(minorstg);
		else if (env.equalsIgnoreCase("MF"))
			this.setPegaURL(MF);
		else if(env.equalsIgnoreCase("Pega7.3"))
			this.setPegaURL(Peganew);
		else if (env.equalsIgnoreCase("Dev"))
			this.setPegaURL(dev);
		else if (env.equalsIgnoreCase("TrainHB"))
			this.setPegaURL(TrainHB);
		else if (env.equalsIgnoreCase("Portal"))
			this.setPegaURL(Portal);
		else if (env.equalsIgnoreCase("API"))
			this.setPegaURL("");
		else if (env.equalsIgnoreCase("Sandbox"))
			this.setPegaURL(Sandbox);
		



		try {
			Driver.getPgDriver().get(this.getPegaURL());
		    Driver.getPgDriver().manage().window().maximize();
		    String str = Driver.getPgDriver().getCurrentUrl();
		    System.out.println("The current URL is " + str);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			blogger.logserviceDownForBrowserNotInvoked();			
		}
	    //utils.waitForPageLoaded(60);
	}
	
	public String getEnvpath(String env){
		return envPath;              
	}
	
}
