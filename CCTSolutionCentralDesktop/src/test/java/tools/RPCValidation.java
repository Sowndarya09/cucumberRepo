package tools;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import automationLib.Driver;
import utils.ExcelUtilities;


public class RPCValidation {

	WebDriver driver = Driver.getPgDriver();


	public void execute(String filename1, String filepath) throws Exception {
		ExcelUtilities excel=new ExcelUtilities();
		ArrayList<String> HCIDList=excel.getColumnDataMainSheet(filename1,"Sheet1", 0);
		print(HCIDList, filepath);	
	}

	public void execute1(String filename1, String filepath) throws Exception {
		ExcelUtilities excel=new ExcelUtilities();
		ArrayList<String> HCIDList=excel.getColumnDataMainSheet(filename1,"Sheet1", 0);
		ArrayList<String> Response=excel.getColumnDataMainSheet(filename1,"Sheet1", 1);

		ArrayList<String> HCIDLists = new ArrayList<String>();
		for(int i=0;i<Response.size();i++) {
			if(Response.get(i).equals("Member Not found"))
				HCIDLists.add(HCIDList.get(i));
		}




		print(HCIDLists, filepath);	
	}

	public static void print(ArrayList<String> HCIDList, String filepath) throws Exception {

		Driver.setPgDriverHeadless("chrome");
		Driver.setUrl("https://ccb-wgs-uat.va.wellpoint.com/RPCTester/BCRPCTester.asp");

		Driver.pgDriver.findElement(By.xpath("//input[@name='userid']")).sendKeys("grpweb1");
		Driver.pgDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("grpweb1");

		Map<String,Map<Integer,Map<String,String>>> finalmap = new HashMap<String,Map<Integer,Map<String,String>>>();

		String hcidvalue = null;

		String[] hcid = HCIDList.toArray(new String[HCIDList.size()]);

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
					mapvalues.put("COMMENTS", "Not in IMSW or IMSN environment");
					mapvalues1.put(2, mapvalues);
					finalmap.put(hcidvalue, mapvalues1);
				}
			}
		}

		System.out.println(finalmap);
		Driver.pgDriver.quit();

		filepath = filepath+"\\RPCResult.xlsx";

		XSSFWorkbook wb=new XSSFWorkbook();
		String sheetName = "Sheet1";
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		XSSFRow activerow;
		XSSFCell activecell;



		activerow=sheet.createRow(0);
		try{
			activerow.getCell(0).setCellValue("HCID");
		}
		catch(NullPointerException e1){
			activerow.createCell(0).setCellValue("HCID");

		}
		try{
			activerow.getCell(1).setCellValue("ENVIRONMENT");
		}
		catch(NullPointerException e1){
			activerow.createCell(1).setCellValue("ENVIRONMENT");

		}

		try{
			activerow.getCell(2).setCellValue("SRCSYS");;
		}
		catch(NullPointerException e1){
			activerow.createCell(2).setCellValue("SRCSYS");

		}

		try{
			activerow.getCell(3).setCellValue("CASE");;
		}
		catch(NullPointerException e1){
			activerow.createCell(3).setCellValue("CASE");

		}

		try{
			activerow.getCell(4).setCellValue("GROUP");;
		}
		catch(NullPointerException e1){
			activerow.createCell(4).setCellValue("GROUP");

		}

		try{
			activerow.getCell(5).setCellValue("HCIDNBR");;
		}
		catch(NullPointerException e1){
			activerow.createCell(5).setCellValue("HCIDNBR");

		}

		try{
			activerow.getCell(6).setCellValue("EIDNBR");;
		}
		catch(NullPointerException e1){
			activerow.createCell(6).setCellValue("EIDNBR");

		}

		int l=0;

		for(int j=0;j<finalmap.size();j++) {
			try {
				Map<Integer, Map<String, String>> map  = finalmap.get(hcid[j]);

				for(int z=0;z<map.size();z++) {
					Map<String,String> resultmap = map.get(z+2);

					try{
						activerow=sheet.getRow(l+1);
						System.out.println(activerow.toString());
					}
					catch(NullPointerException e1){
						activerow=sheet.createRow(l+1);
					}

					System.out.println(z+1);
					try{
						activerow.getCell(0).setCellValue(hcid[j]);
					}
					catch(NullPointerException e1){
						activerow.createCell(0).setCellValue(hcid[j]);
					}

					try{
						activerow.getCell(1).setCellValue(resultmap.get("ENVIRONMENT"));
					}
					catch(NullPointerException e1){
						activerow.createCell(1).setCellValue(resultmap.get("ENVIRONMENT"));

					}

					try{
						activerow.getCell(2).setCellValue(resultmap.get("SRCSYS"));
					}
					catch(NullPointerException e1){
						activerow.createCell(2).setCellValue(resultmap.get("SRCSYS"));
					}

					try{
						activerow.getCell(3).setCellValue(resultmap.get("CASE"));
					}
					catch(NullPointerException e1){
						activerow.createCell(3).setCellValue(resultmap.get("CASE"));
					}

					try{
						activerow.getCell(4).setCellValue(resultmap.get("GROUP"));
					}
					catch(NullPointerException e1){
						activerow.createCell(4).setCellValue(resultmap.get("GROUP"));
					}

					try{
						activerow.getCell(5).setCellValue(resultmap.get("HCIDNBR"));
					}
					catch(NullPointerException e1){
						activerow.createCell(5).setCellValue(resultmap.get("HCIDNBR"));
					}

					try{
						activerow.getCell(6).setCellValue(resultmap.get("EIDNBR"));
					}
					catch(NullPointerException e1){
						activerow.createCell(6).setCellValue(resultmap.get("EIDNBR"));
					}
					try{
						activerow.getCell(7).setCellValue(resultmap.get("COMMENTS"));
					}
					catch(NullPointerException e1){
						activerow.createCell(7).setCellValue(resultmap.get("COMMENTS"));
					}


					l++;
				}



			}catch(NullPointerException e2) {
			}
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(new File(filepath));
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}



	}


}
