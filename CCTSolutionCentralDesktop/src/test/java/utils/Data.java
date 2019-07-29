package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Data
{
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath;

	public Data() throws Exception
	{
		xlFilePath = System.getProperty("user.dir")+"\\Data.xlsx";
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}


	public boolean setCellDatas(String string, ArrayList<HashMap<String, ArrayList<String>>> finalarry) {

		int count=0;

		try
		{
			sheet = workbook.getSheet(string);
			HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
			for(int l=0;l<finalarry.size();l++) {
				map = finalarry.get(l);

				for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
					String key = entry.getKey().toString();
					row = sheet.getRow(count);
					if(row==null)
						row = sheet.createRow(count);



					System.out.println(key);

					ArrayList<String> value = entry.getValue();
					for(int i=0;i<value.size();i++){
						row = sheet.getRow(count);
						if(row==null)
							row = sheet.createRow(count);

						cell = row.getCell(2);
						if(cell == null)
							cell = row.createCell(2);
						cell.setCellValue(key);

						cell = row.getCell(3);
						if(cell == null)
							cell = row.createCell(3);

						cell.setCellValue(value.get(i));
						count++;
						System.out.println(value.get(i));
					} 
					System.out.println("key, " + key + " value " + value);
				}

				System.out.println(finalarry.size());
				System.out.println(finalarry.get(1).size());
			}

			fos = new FileOutputStream(xlFilePath);
			workbook.write(fos);
			fos.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return  false;
		}
		return true;

	}
}