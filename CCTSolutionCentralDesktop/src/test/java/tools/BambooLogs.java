package tools;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class BambooLogs {
	
	public void logs(String file) throws FileNotFoundException, IOException {
		
		//String file ="C:\\Users\\AF72532\\Desktop\\BambooLogs\\plan-75340822-REG-591.log";
		
		File filepath = new File(file);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
	    while ((line = reader.readLine()) != null) {
		//  while ((TAG_REGEX.matcher(reader.readLine())) != null) {
		    final Matcher matcher = TAG_REGEX.matcher(line);
		    while (matcher.find()) {
		    	testIDValues.add(matcher.group(0));
		    	//moduleNameValues.add(matcher.group(2));
		    	//testStatus.add(matcher.group(3));
		    }
	    }
		
		 printInExcel(testIDValues,moduleNameValues,testStatus,new File(filepath.getParent()));
		}
	
	
	
	//private static final Pattern TAG_REGEX = Pattern.compile("<TestID>(.+?)</TestID><ModuleName>(.+?)</ModuleName><TestStatus>(.+?)</TestStatus>", Pattern.DOTALL);
	private static final Pattern TAG_REGEX = Pattern.compile("<TestInfo>(.+?)</TestInfo>", Pattern.DOTALL);
	
	public String xmlTags() {
		return null;
		
	}
	

    final static List<String> testIDValues = new ArrayList<String>();
    final static List<String> moduleNameValues = new ArrayList<String>();
    final static List<String> testStatus = new ArrayList<String>();

	
	public static void printInExcel(List<String> testIDValues,List<String> moduleNameValues,List<String> testStatus, File filepath) {
		XSSFWorkbook wb=new XSSFWorkbook();
		String sheetName = "Sheet1";
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		XSSFRow activerow;
		XSSFCell activecell;



		activerow=sheet.createRow(0);
		try{
			activerow.getCell(0).setCellValue("Test ID");
		}
		catch(NullPointerException e1){
			activerow.createCell(0).setCellValue("Test ID");

		}
		try{
			activerow.getCell(1).setCellValue("Module Name");;
		}
		catch(NullPointerException e1){
			activerow.createCell(1).setCellValue("Module Name");

		}
		try{
			activerow.getCell(2).setCellValue("Test Status");;
		}
		catch(NullPointerException e1){
			activerow.createCell(2).setCellValue("Test Status");

		}

		for (int i=0;i<testIDValues.size();i++) {
			
			try{
				activerow=sheet.getRow(i+1);
				System.out.println(activerow.toString());
			}
			catch(NullPointerException e1){
				activerow=sheet.createRow(i+1);
			}

			//System.out.println(i);
			try{
				activerow.getCell(0).setCellValue(testIDValues.get(i));
			}
			catch(NullPointerException e1){
				activerow.createCell(0).setCellValue(testIDValues.get(i));

			}
			try{
				activerow.getCell(1).setCellValue(moduleNameValues.get(i));;
			}
			catch(NullPointerException e1){
				activerow.createCell(1).setCellValue(moduleNameValues.get(i));

			}
			
			try{
				activerow.getCell(2).setCellValue(testStatus.get(i));;
			}
			catch(NullPointerException e1){
				activerow.createCell(2).setCellValue(testStatus.get(i));

			}

		
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(new File(filepath+"\\Result.xlsx"));
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
