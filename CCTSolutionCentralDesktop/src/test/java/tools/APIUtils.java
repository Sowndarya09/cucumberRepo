package tools;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.json.Json;
import javax.json.stream.JsonParser;


public class APIUtils {



	public  JsonParser Posturl(String apiurl,String authtype,String apikey) throws IOException
	{
		JsonParser parser = null;
		String surl = apiurl;
		String response="";String getresponse = "";
		try {
			URL url = new URL(surl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setReadTimeout(15000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("POST");
			if(authtype.equalsIgnoreCase("Basic"))
				conn.setRequestProperty("Authorization", "Basic " + apikey);
			else 
				conn.setRequestProperty("apikey", apikey);	
			conn.setDoInput(true);
			conn.setDoOutput(true);		       
			OutputStream os = conn.getOutputStream();
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(os, "UTF-8"));
			writer.flush();
			writer.close();
			os.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			else {
				InputStream in = conn.getInputStream();  
				Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
				parser = Json.createParser(reader);
				
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return parser;
	}   

	static String parservalue;
	public static Reader reader;
	
	public  boolean Posturl(String apiurl,String authtype, String authkey,String json) 
	{
		JsonParser parser = null;
		String surl = apiurl;
		boolean bol = false;
		
		try {
			URL url = new URL(surl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();	    
			conn.setReadTimeout(15000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			if(authtype.equalsIgnoreCase("Basic"))

				conn.setRequestProperty("Authorization", "Basic ");
			else 
				conn.setRequestProperty("apikey", authkey);	
			conn.setDoInput(true);
			conn.setDoOutput(true);	
			
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			os.close();
			System.out.println(conn.getResponseCode());
			if (conn.getResponseCode() != 202) {
				bol=false;
			}
			else {
				bol=true;	
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return bol;
	}  


	public  JsonParser getUrl(String apiurl,String authtype,String apikey) throws IOException, InterruptedException    
	{	

		JsonParser parser = null;
		InputStream in =null;
		try {
			URL urlget = new URL(apiurl);

			HttpURLConnection conn = (HttpURLConnection) urlget.openConnection();
			conn.setReadTimeout(15000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if(authtype.equalsIgnoreCase("Basic"))
				conn.setRequestProperty("Authorization", "Basic " + apikey);
			else 
				conn.setRequestProperty("apikey", apikey);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			if (conn.getResponseCode() != 200) {
				InputStream s = conn.getErrorStream();
				reader = new InputStreamReader(s, StandardCharsets.UTF_8);
				
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			else {
				in = conn.getInputStream();
				reader = new InputStreamReader(in, StandardCharsets.UTF_8);
				parser = Json.createParser(reader);
			}
		} catch (IOException e1) {
			System.out.println(e1.toString());
		}              

		int intValueOfChar;
		String targetString = "";

		return parser;

	}
	
	/** Below Methods are to draft an email
	 * 
	 * @param str
	 * @return
	 */
	private static final String urlEncode(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	} 

	public Boolean sendEmail( String ccAddress,
			String bccAddress, String from, String subject,
			String body, String recipients) throws IOException, URISyntaxException{
		Boolean messageSent = false;
		
		Properties properties = new Properties();

		properties.setProperty("mail.smtp.host","smtpinternal.wellpoint.com");
		

		String uristr = String.format("mailto:%s?subject=%s&body=%s",
				join(",", recipients), // use semicolon ";" for Outlook!
				urlEncode(subject),
				urlEncode(body));
		urlEncode(from);

		Desktop.getDesktop().browse(new URI(uristr));
		
		/*Desktop desktop;
		if (Desktop.isDesktopSupported() 
		    && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
		  URI mailto = new URI("mailto:AF23096@anthem.com");
		 
		  desktop.mail(mailto);
		 
		} else {
		  // TODO fallback to some Runtime.	exec(..) voodoo?
		  throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
		}

		try {

			message.setFrom(new InternetAddress(fromAddress));
		
			if (toAddress != null) {
				Message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(toAddress));
			}
			if (ccAddress != null) {
				message.setRecipients(Message.RecipientType.CC,
						InternetAddress.parse(ccAddress));
			}
			if (bccAddress != null) {
				message.setRecipients(Message.RecipientType.BCC,
						InternetAddress.parse(bccAddress));
			}

			message.setSubject(subject);
			
			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(body, "text/html; charset=utf-8");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodyPart);
			 
			message.setContent(multipart);
			
		message.setContent(body, "text/html; charset=utf-8");
		}*/
		return messageSent;
	}

	private static Object join(String string, String recipients) {
		// TODO Auto-generated method stub
		return recipients;
	}

}
