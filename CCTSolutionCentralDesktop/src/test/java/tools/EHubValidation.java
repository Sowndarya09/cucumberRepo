package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utils.ExcelUtilities;

public class EHubValidation {

	public void execute(String filename1, String filename2) throws IOException {
		ExcelUtilities excel=new ExcelUtilities();
		ArrayList<String> HCIDList=excel.getColumnDataMainSheet(filename1,"Sheet1", 0);
		print(HCIDList,filename2);
	}


	public static void print(ArrayList<String> HCIDList, String filename2) throws FileNotFoundException {

		filename2 = filename2+"\\eHUBResult.xlsx";

		Map<String,String> map = new HashMap<String, String>();

		String[] args = HCIDList.toArray(new String[HCIDList.size()]);
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
					map.put(args[j], "Member Not found");
				}else {
					map.put(args[j], "Member Found");
				}



			}    catch (Exception e) {

				e.printStackTrace();

			} 	
		}


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
			activerow.getCell(1).setCellValue("Response");;
		}
		catch(NullPointerException e1){
			activerow.createCell(1).setCellValue("Response");

		}

		int i=0;
		for (Map.Entry<String, String> e : map.entrySet()) {
			String key = e.getKey();
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
				activerow.getCell(0).setCellValue(key);
			}
			catch(NullPointerException e1){
				activerow.createCell(0).setCellValue(key);

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
			fileOut = new FileOutputStream(new File(filename2));
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}




	}



}
