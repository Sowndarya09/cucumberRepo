package tools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Create_Excel_File {

	public void writeToExcelSheet(String filename1, String filename2) throws IOException {

		writeToExcel(getColumns(filename1),filename2);
	}

	@SuppressWarnings("resource")
	private static ArrayList<String> getColumns(String feature) throws IOException {
		File file = new File(feature);
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		ArrayList<String> array = new ArrayList<String>();

		String st,newFilecontent="",columns=""; 
		String a[]=new String[100];
		while ((st = br.readLine()) != null) 
		{

			if(st.contains("Examples:"))
			{
				while ((st = br.readLine()) != null) 
				{
					columns=st;
					columns=columns.trim();
					array.add(columns);
				}
			}
			else
				newFilecontent=newFilecontent+st+"\n";

		}
		return array;

	}

	static int i=0;

	private static void writeToExcel(ArrayList<String> array, String excelFileName) throws IOException {
		File file = new File(excelFileName);
		String pathname = file.getParent();
		String featureFileName = file.getName();

		featureFileName = featureFileName.replaceAll("feature", "csv");

		String finalFileName = pathname+"\\"+featureFileName;

		System.out.println(finalFileName);

		String sheetName = "Sheet1";
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		for(int j=0;j<array.size();j++) {
			String[] a = array.get(j).split("\\|");



			XSSFRow row = sheet.createRow(i);
			for (int c=1;c < a.length; c++ )
			{
				XSSFCell cell = row.createCell(c-1);
				cell.setCellValue(a[c].trim());
			}
			i++;
		}
		FileOutputStream fileOut = new FileOutputStream(finalFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();


	}
}
