package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import automationLib.Driver;
import utils.ExcelUtilities;

public class Validation {

	public void execute(String filename1) throws Exception {
		ExcelUtilities excel=new ExcelUtilities();
		ArrayList<String> HCIDList=excel.getColumnDataMainSheet(filename1,"Sheet1", 0);
		Map<String,String> hcidmap = validateinAPI(HCIDList);

		Map<String, Map<Integer, Map<String, String>>> rpcmap = validateinRPC(hcidmap);

		writeInExcel(hcidmap,rpcmap,filename1);
	}
	
	
	public void writeInExcel(Map<String, String> hcidmap, Map<String, Map<Integer, Map<String, String>>> rpcmap, String filename1) throws IOException {


		FileInputStream fsIP = new FileInputStream(filename1);
		XSSFWorkbook wb=new XSSFWorkbook(fsIP);
		String sheetName = "Result";
		XSSFSheet sheet;
		XSSFRow activerow;
		sheet = wb.createSheet(sheetName);
		activerow=sheet.createRow(0);
		
		try{
			activerow.getCell(0).setCellValue("HCID");
		}
		catch(NullPointerException e1){
			activerow.createCell(0).setCellValue("HCID");

		}
		
		try{
			activerow.getCell(1).setCellValue("Available in Ehub");
		}
		catch(NullPointerException e1){
			activerow.createCell(1).setCellValue("Available in Ehub");

		}
		
		try{
			activerow.getCell(2).setCellValue("Environment");
		}
		catch(NullPointerException e1){
			activerow.createCell(2).setCellValue("Environment");

		}
		
		try{
			activerow.getCell(3).setCellValue("SRCSYS");;
		}
		catch(NullPointerException e1){
			activerow.createCell(3).setCellValue("SRCSYS");

		}

		try{
			activerow.getCell(4).setCellValue("CASE");;
		}
		catch(NullPointerException e1){
			activerow.createCell(4).setCellValue("CASE");

		}

		try{
			activerow.getCell(5).setCellValue("GROUP");;
		}
		catch(NullPointerException e1){
			activerow.createCell(5).setCellValue("GROUP");

		}

		try{
			activerow.getCell(6).setCellValue("HCIDNBR");;
		}
		catch(NullPointerException e1){
			activerow.createCell(6).setCellValue("HCIDNBR");

		}

		try{
			activerow.getCell(7).setCellValue("EIDNBR");
		}
		catch(NullPointerException e1){
			activerow.createCell(7).setCellValue("EIDNBR");

		}
		
		try{
			activerow.getCell(8).setCellValue("COMMENTS");;
		}
		catch(NullPointerException e1){
			activerow.createCell(8).setCellValue("COMMENTS");

		}

		int i=1;

		for(Map.Entry<String,String> entry:hcidmap.entrySet()) {
			activerow=sheet.createRow(i);



			if(entry.getValue().equals("No")) {

					Map<Integer, Map<String, String>> map  = rpcmap.get(entry.getKey());

					for(int z=0;z<map.size();z++) {
						Map<String,String> resultmap = map.get(z+2);
						activerow=sheet.getRow(i);
						
						if(activerow==null)
							activerow=sheet.createRow(i);
						

						try {
							activerow.getCell(0).setCellValue(entry.getKey());
						}catch(NullPointerException e1){
							activerow.createCell(0).setCellValue(entry.getKey());

						}		
						try{
							activerow.getCell(1).setCellValue(entry.getValue());
						}catch(NullPointerException e1){
							activerow.createCell(1).setCellValue(entry.getValue());

						}

						try{
							activerow.getCell(2).setCellValue(resultmap.get("ENVIRONMENT"));
						}
						catch(NullPointerException e1){
							activerow.createCell(2).setCellValue(resultmap.get("ENVIRONMENT"));
						}


						try{
							activerow.getCell(3).setCellValue(resultmap.get("SRCSYS"));
						}
						catch(NullPointerException e1){
							activerow.createCell(3).setCellValue(resultmap.get("SRCSYS"));
						}

						try{
							activerow.getCell(4).setCellValue(resultmap.get("CASE"));
						}
						catch(NullPointerException e1){
							activerow.createCell(4).setCellValue(resultmap.get("CASE"));
						}

						try{
							activerow.getCell(5).setCellValue(resultmap.get("GROUP"));
						}
						catch(NullPointerException e1){
							activerow.createCell(5).setCellValue(resultmap.get("GROUP"));
						}

						try{
							activerow.getCell(6).setCellValue(resultmap.get("HCIDNBR"));
						}
						catch(NullPointerException e1){
							activerow.createCell(6).setCellValue(resultmap.get("HCIDNBR"));
						}

						try{
							activerow.getCell(7).setCellValue(resultmap.get("EIDNBR"));
						}
						catch(NullPointerException e1){
							activerow.createCell(7).setCellValue(resultmap.get("EIDNBR"));
						}
						try{
							activerow.getCell(8).setCellValue(resultmap.get("COMMENTS"));
						}
						catch(NullPointerException e1){
							activerow.createCell(8).setCellValue(resultmap.get("COMMENTS"));
						}	
						i++;
				}
			}else {
				try {
					activerow.getCell(0).setCellValue(entry.getKey());
				}catch(NullPointerException e1){
					activerow.createCell(0).setCellValue(entry.getKey());

				}		
				try{
					activerow.getCell(1).setCellValue(entry.getValue());
				}catch(NullPointerException e1){
					activerow.createCell(1).setCellValue(entry.getValue());

				}
				i++;
			}
		}



		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(new File(filename1));
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}





	}

	public Map<String, Map<Integer, Map<String, String>>> validateinRPC(Map<String, String> map) throws Exception {

		ArrayList<String> HCIDLists = new ArrayList<String>();

		for(Map.Entry<String,String> entry:map.entrySet()) {
			if(entry.getValue().equalsIgnoreCase("No"))
				HCIDLists.add(entry.getKey());
		}


		Driver.setPgDriverHeadless("chrome");
		Driver.setUrl("https://ccb-wgs-uat.va.wellpoint.com/RPCTester/BCRPCTester.asp");

		Driver.pgDriver.findElement(By.xpath("//input[@name='userid']")).sendKeys("grpweb1");
		Driver.pgDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("grpweb1");

		Map<String,Map<Integer,Map<String,String>>> finalmap = new HashMap<String,Map<Integer,Map<String,String>>>();

		String hcidvalue = null;

		String[] hcid = HCIDLists.toArray(new String[HCIDLists.size()]);

		for(int i=0;i<hcid.length;i++) {
			hcidvalue = hcid[i];

			Map<Integer,Map<String,String>> mapvalues1 = new HashMap<Integer,Map<String,String>>();

			Select se1 = new Select(Driver.pgDriver.findElement(By.name("environment")));
			se1.selectByValue("USRT");

			Driver.pgDriver.findElement(By.xpath("//*[text()='Key Fields >>']/../..//table//td[text()='CERT: ']/..//input")).clear();
			Driver.pgDriver.findElement(By.xpath("//*[text()='Key Fields >>']/../..//table//td[text()='CERT: ']/..//input")).sendKeys(hcidvalue);

			Driver.pgDriver.findElement(By.xpath("//input[@value='Submit']")).click();
			Thread.sleep(1000);
			try {
				Driver.pgDriver.findElement(By.xpath("//strong[text()='Results']/../../following-sibling::table"));
				List<WebElement> element = Driver.pgDriver.findElements(By.xpath("//strong[text()='Results']/../../following-sibling::table//*[text()='COMPANYCODE']/../../..//td"));
				System.out.println(element.size());
				for(int j=2;j<=element.size();j++) {
					Map<String,String> mapvalues = new HashMap<String,String>();

					mapvalues.put("ENVIRONMENT", "IMSN");

					String srcsyselement = "//strong[text()='Results']/../../following-sibling::table//*[text()='SRCSYS']/../../..//td["+j+"]//font";
					String srcsys = Driver.pgDriver.findElement(By.xpath(srcsyselement)).getText();
					mapvalues.put("SRCSYS", srcsys);

					String casevalueelement = "//strong[text()='Results']/../../following-sibling::table//*[text()='CASE']/../../..//td["+j+"]//font";
					String casevalue = Driver.pgDriver.findElement(By.xpath(casevalueelement)).getText();
					mapvalues.put("CASE", casevalue);

					String groupelement = "//strong[text()='Results']/../../following-sibling::table//*[text()='GROUP']/../../..//td["+j+"]//font";
					String group = Driver.pgDriver.findElement(By.xpath(groupelement)).getText();
					mapvalues.put("GROUP", group);

					String hcidnumberelement = "//strong[text()='Results']/../../following-sibling::table//*[text()='HCIDNBR']/../../..//td["+j+"]//font";
					String hcidnumber = Driver.pgDriver.findElement(By.xpath(hcidnumberelement)).getText();
					mapvalues.put("HCIDNBR", hcidnumber);

					String eidnumberelement = "//strong[text()='Results']/../../following-sibling::table//*[text()='EIDNBR']/../../..//td["+j+"]//font";
					String eidnumber = Driver.pgDriver.findElement(By.xpath(eidnumberelement)).getText();
					mapvalues.put("EIDNBR", eidnumber);

					mapvalues1.put(j, mapvalues);
				}

				finalmap.put(hcidvalue, mapvalues1);
			}catch(NoSuchElementException e) {
				try {

					Select se = new Select(Driver.pgDriver.findElement(By.name("environment")));
					se.selectByValue("UNIT");

					Driver.pgDriver.findElement(By.xpath("//*[text()='Key Fields >>']/../..//table//td[text()='CERT: ']/..//input")).clear();
					Driver.pgDriver.findElement(By.xpath("//*[text()='Key Fields >>']/../..//table//td[text()='CERT: ']/..//input")).sendKeys(hcidvalue);

					Driver.pgDriver.findElement(By.xpath("//input[@value='Submit']")).click();
					Thread.sleep(1000);

					Driver.pgDriver.findElement(By.xpath("//strong[text()='Results']/../../following-sibling::table"));
					List<WebElement> element = Driver.pgDriver.findElements(By.xpath("//strong[text()='Results']/../../following-sibling::table//*[text()='COMPANYCODE']/../../..//td"));
					System.out.println(element.size());
					for(int j=2;j<=element.size();j++) {
						Map<String,String> mapvalues = new HashMap<String,String>();

						mapvalues.put("ENVIRONMENT", "IMSW");

						String srcsyselement = "//strong[text()='Results']/../../following-sibling::table//*[text()='SRCSYS']/../../..//td["+j+"]//font";
						String srcsys = Driver.pgDriver.findElement(By.xpath(srcsyselement)).getText();
						mapvalues.put("SRCSYS", srcsys);

						String casevalueelement = "//strong[text()='Results']/../../following-sibling::table//*[text()='CASE']/../../..//td["+j+"]//font";
						String casevalue = Driver.pgDriver.findElement(By.xpath(casevalueelement)).getText();
						mapvalues.put("CASE", casevalue);

						String groupelement = "//strong[text()='Results']/../../following-sibling::table//*[text()='GROUP']/../../..//td["+j+"]//font";
						String group = Driver.pgDriver.findElement(By.xpath(groupelement)).getText();
						mapvalues.put("GROUP", group);

						String hcidnumberelement = "//strong[text()='Results']/../../following-sibling::table//*[text()='HCIDNBR']/../../..//td["+j+"]//font";
						String hcidnumber = Driver.pgDriver.findElement(By.xpath(hcidnumberelement)).getText();
						mapvalues.put("HCIDNBR", hcidnumber);

						String eidnumberelement = "//strong[text()='Results']/../../following-sibling::table//*[text()='EIDNBR']/../../..//td["+j+"]//font";
						String eidnumber = Driver.pgDriver.findElement(By.xpath(eidnumberelement)).getText();
						mapvalues.put("EIDNBR", eidnumber);

						mapvalues1.put(j, mapvalues);
					}

					finalmap.put(hcidvalue, mapvalues1);


				}catch(NoSuchElementException e1) {
					Map<String,String> mapvalues = new HashMap<String,String>();
					mapvalues.put("COMMENTS", "Not available in ehub, IMSN and IMSW");
					mapvalues1.put(2, mapvalues);
					finalmap.put(hcidvalue, mapvalues1);
				}
			}
		}

		System.out.println(finalmap);
		Driver.pgDriver.quit();

		return finalmap;


	}

	public Map<String, String> validateinAPI(ArrayList<String> hCIDList) {
		Map<String,String> map = new HashMap<String, String>();

		String[] args = hCIDList.toArray(new String[hCIDList.size()]);
		for(int j=1;j<args.length;j++) {
			String uaturl = "https://uat.api.anthem.com/v3/pegadesktop/members/search";	
			String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
			String json ="{\"limit\":\"129\",\"mbrLookupId\":\""+args[j]+"\"}";

			try {

				URL url=null;
				url = new URL(uaturl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
				conn.setRequestProperty("apikey",  "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD");

				conn.setDoOutput(true);
				conn.setDoInput(true);


				OutputStream os = conn.getOutputStream();
				os.write(json.getBytes("UTF-8"));
				os.close();


				if (conn.getResponseCode() != 200) {
					map.put(args[j], "No");
				}else {
					map.put(args[j], "Yes");
				}



			}    catch (Exception e) {

				e.printStackTrace();

			} 	
		}
		System.out.println(map);
		return map;

	}


}
