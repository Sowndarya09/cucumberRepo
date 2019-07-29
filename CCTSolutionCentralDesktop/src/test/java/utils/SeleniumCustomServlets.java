/**
 * 
 */
package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * @author AF67334
 *
 */
public class SeleniumCustomServlets {

	private String hubHostName;
	private int hubPort;
	public String nodeHostName;
	public int nodePort;
	private RemoteWebDriver remoteWebDriver;
	private SessionId sessionID;

	public SeleniumCustomServlets(WebDriver remoteWebDriver, String hubHostName, int hubPort) {
		this.hubHostName = hubHostName;
		this.hubPort = hubPort;
		this.remoteWebDriver = (RemoteWebDriver) remoteWebDriver;

		System.out.println("#SeleniumCustomServlets# Hub Host Name : " + this.hubHostName);
		System.out.println("#SeleniumCustomServlets# Hub Port : " + this.hubPort);

		getNodeInfoForSession();
	}

	public void terminatePirateProcess() {
		HttpClient client = null;
		HttpResponse response = null;
		StringBuilder url = null;

		try {

			url = new StringBuilder();

			url.append("http://");
			url.append(this.nodeHostName);
			url.append(":");
			url.append(this.nodePort);
			url.append("/wd/hub/session/" + sessionID.toString());

			client = HttpClientBuilder.create().build();

			HttpDelete delete = new HttpDelete(url.toString());
			response = client.execute(delete);
			System.out.println("#terminatePirateProcess# Delete Session Response : " + response.toString());
			System.out.println("#terminatePirateProcess# Delete Session Status Line : " + response.getStatusLine().toString());
			System.out.println("#terminatePirateProcess# Delete Session Status Code : " + response.getStatusLine().getStatusCode());

		} catch (Exception ex) {
			System.out.println("#terminatePirateProcess# Exception thrown while deleting the session : " + ex.toString());
		} finally {

			url = null;
			client =null;
			response = null;

			url = new StringBuilder();

			url.append("http://");
			url.append(this.nodeHostName);
			url.append(":");
			url.append(this.nodePort);
			url.append("/extra/TerminatePirateProcess");

			client = HttpClientBuilder.create().build();

			try {
				HttpPost post = new HttpPost(url.toString());
				response = client.execute(post);
				System.out.println("#terminatePirateProcess# Servlet TerminatePirateProcess Response : " + response.toString());
				System.out.println("#terminatePirateProcess# Servlet TerminatePirateProcess Status Line : " + response.getStatusLine().toString());
				System.out.println("#terminatePirateProcess# Servlet TerminatePirateProcess Status Code : " + response.getStatusLine().getStatusCode());
			} catch (Exception ex) {
				System.out.println("#terminatePirateProcess# Exception in invoking the Servlet TerminatePirateProcess");
			} 

		}

	}

	private void getNodeInfoForSession() {

		CloseableHttpClient client = HttpClientBuilder.create().build();
		CloseableHttpResponse response = null;

		try {
			this.sessionID = remoteWebDriver.getSessionId();
			System.out.println("#getNodeInfoForSession# Session ID : " + sessionID.toString());

			URL url = new URL("http://" + this.hubHostName + ":" + this.hubPort + "/grid/api/testsession?session=" + sessionID);
			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST", url.toExternalForm());
			response = client.execute(new HttpHost(this.hubHostName, this.hubPort), r);

			System.out.println("#getNodeInfoForSession# Get Node Session Info Response : " + response.toString());
			System.out.println("#getNodeInfoForSession# Get Node Session Info Status Line : " + response.getStatusLine().toString());
			System.out.println("#getNodeInfoForSession# Get Node Session Info Status Code : " + response.getStatusLine().getStatusCode());

			JsonObject object = extractJson(response.getEntity());
			URL tempUrl = new URL(object.get("proxyId").getAsString());
			this.nodeHostName = tempUrl.getHost();
			this.nodePort = tempUrl.getPort();
		} catch (Exception e) {
			System.out.println("#getNodeInfoForSession# Exception thrown while acquiring remote webdriver node and port info. Root cause  : " + e.toString());
		} finally {
			try {
				if (response != null) {
					response.close();
				} 
			} catch (IOException e) {
				System.out.println("#getNodeInfoForSession# Exeption thrown while closing the response object for getting node session info : " + e.toString());
			}
		}

		System.out.println("#getNodeInfoForSession# Session ID : " + sessionID);
		System.out.println("#getNodeInfoForSession# Node Host Name : " + this.nodeHostName);
		System.out.println("#getNodeInfoForSession# Node Port : " + this.nodePort);

	}

	private JsonObject extractJson(HttpEntity entity) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()))) {
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
			return new JsonParser().parse(builder.toString()).getAsJsonObject();
		}
	}

}
