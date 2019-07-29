package tools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Create_new_FF {

	public String generateFeatureFile (String filename3, String filename4) throws IOException, URISyntaxException {

		String parameters=getDataFromExcel(filename4);
		String filepath = generateNewFeature(parameters, filename3);
		return filepath;

	}

	@SuppressWarnings("resource")
	private static String generateNewFeature(String parameters, String filename3) throws IOException {
		File file = new File(filename3);
		String filename = file.getName();
		String filepath = file.getParent();
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st,newFilecontent=""; 
		while ((st = br.readLine()) != null) 
		{

			if(st.contains("Examples"))
			{
				newFilecontent=newFilecontent+"Examples:\n"+parameters;
				break;
			}
			else
				newFilecontent=newFilecontent+st+"\n";

		}

		String[] ff = filename.split("\\.");


		String finalFilename = filepath+"\\"+ff[0]+"_new."+ff[1];


		BufferedWriter bw = null;
		FileWriter fw = new FileWriter(finalFilename);
		bw = new BufferedWriter(fw);
		bw.write(newFilecontent);
		bw.close();
		fw.close();
		return finalFilename;
	}


	public static String getDataFromExcel(String excelFile) throws IOException
	{

		InputStream ExcelFileToRead = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet=wb.getSheetAt(0);

		XSSFRow row;
		XSSFCell cell;
		String data="";
		Iterator rows = sheet.rowIterator();
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next(); 
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
					data=data+"|"+cell.getStringCellValue().toString();
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.println(cell.getCellType());
					System.out.print(cell.getNumericCellValue()+" ");
					double a= cell.getNumericCellValue();
					String b=Double.toString(a);
					data=data+"|"+b;
				}
				else
				{
				}
			}
			System.out.println("\n");
			data=data+"|\n";
		}
		System.out.println(data);
		return data;
	}



}
