package tools;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EHubDataExtractor {
	
	static Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DB_Validation db = new DB_Validation();
		map = db.fetchDataFromDB("UATMember", "select distinct * from ehub_mbr_sds.memberinsights WHERE ROWNUM <= 3");
		writeToExcel(map);
	}
	
	public static void writeToExcel(Map<String, ArrayList<String>> map) {
		
		System.out.println(map);
		
		
		
		XSSFWorkbook wb=new XSSFWorkbook();
		String sheetName = "Sheet1";
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		XSSFRow activerow;
		XSSFCell activecell;


		for(int j=0;j<map.size();j++) {
		activerow=sheet.createRow(0);
		try{
			//activerow.getCell(0).setCellValue(map.);
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
		}

		
		
	}

}
