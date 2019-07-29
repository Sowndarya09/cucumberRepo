package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.stream.JsonParser;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Medisys_API_POC {




	public void mainMethod(File filepath, String gbdurl) throws IOException {
		HashMap<File,String> map = new HashMap<File,String>();
		File[] listOfFiles = filepath.listFiles();
		APIUtils utils = new APIUtils();

		for(int i=0;i<listOfFiles.length;i++) {
			System.out.println(listOfFiles[i]);
			String json = convertXmlToOneLineString(listOfFiles[i]);
			System.out.println(json);
			boolean bol=false;
			//String siturl = "https://uats-gbd-soa-services.anthem.com:443/MedisysWS-v1/nextresponse";
			String url = gbdurl;
			String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
			//bol = Posturl(url, "Basic",  json, apikey);
			bol = utils.Posturl(url, "Basic",  apikey, json);
			String result;
			if(bol)
				result="Processed";
			else
				result="Not Processed";

			map.put(listOfFiles[i], result);
		}

		printInExcel(map,filepath);


	}

	public static String convertXmlToOneLineString(File filepath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		//StringBuilder sb = new StringBuilder();
		String finalstring = "";

		while((line=br.readLine())!= null){
			// sb.append(line.trim());
			finalstring += line;
		}

		return finalstring;
	}

	public static Reader reader;
	public static  boolean Posturl(String apiurl,String authtype, String json, String apikey) 
	{
		String surl = apiurl;
		boolean bol = false;
		try {
			URL url = new URL(surl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();	    
			conn.setReadTimeout(15000);
			conn.setConnectTimeout(30000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			if(authtype.equalsIgnoreCase("Basic"))
				conn.setRequestProperty("Authorization", "Basic " + apikey);
			else 
				conn.setRequestProperty("apikey", apikey);
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

	public void printInExcel(HashMap<File,String> map, File filepath) {
		XSSFWorkbook wb=new XSSFWorkbook();
		String sheetName = "Sheet1";
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		XSSFRow activerow;
		XSSFCell activecell;



		activerow=sheet.createRow(0);
		try{
			activerow.getCell(0).setCellValue("File Name");
		}
		catch(NullPointerException e1){
			activerow.createCell(0).setCellValue("File Name");

		}
		try{
			activerow.getCell(1).setCellValue("Status");;
		}
		catch(NullPointerException e1){
			activerow.createCell(1).setCellValue("Status");

		}

		int i=0;
		for (Entry<File, String> e : map.entrySet()) {
			File key = e.getKey();
			String value = e.getValue();
			try{
				activerow=sheet.getRow(i+1);
				System.out.println(activerow.toString());
			}
			catch(NullPointerException e1){
				activerow=sheet.createRow(i+1);
			}

			System.out.println(i+1);
			try{
				activerow.getCell(0).setCellValue(key.getName());
			}
			catch(NullPointerException e1){
				activerow.createCell(0).setCellValue(key.getName());

			}
			try{
				activerow.getCell(1).setCellValue(value);;
			}
			catch(NullPointerException e1){
				activerow.createCell(1).setCellValue(value);

			}

			i++;
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(new File(filepath+"\\Log.xlsx"));
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
