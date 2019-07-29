package utils;

import java.io.IOException;

//import com.anthem.crypt.Authenticator;
//import com.anthem.crypt.EncryptCredentials;
//import com.anthem.selenium.Utility;
//import com.anthem.selenium.constants.ApplicationConstants;
//import com.gargoylesoftware.htmlunit.javascript.host.crypto.Crypto;


public class JiraResult {
	
	public void runCurl(String cmd){
		Runtime runtime = Runtime.getRuntime();
		try {
			Process p =runtime.exec(cmd);
			try {
					p.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	public void uploadResult()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("curl -H \"Content-Type: application/json\" -X POST -u ");
		sb.append("ab87347");
		sb.append(":");
		sb.append("Chettan@marriage");
		sb.append(" --data @");
		sb.append("Destination\\cucumber.json");
		sb.append(" https://jira.anthem.com/rest/raven/1.0/import/execution/cucumber -k");
		System.out.println(sb);
		runCurl(sb.toString());
	}
	 
}