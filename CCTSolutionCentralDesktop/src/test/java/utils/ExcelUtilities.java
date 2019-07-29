package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	static int firstemptycell,count=0;

	public String searchtheexcel(String name,File file) throws IOException
	{
		File[] list = file.listFiles();
		if (list != null) {
			for (File fil : list) {
				String path = null;
				if (fil.isDirectory()) {
					path = searchtheexcel(name, fil);
					if (path != null) {
						return path;
					}
				} else if (fil.getName().contains(name)) {
					path =fil.getAbsolutePath();
					if (path != null) {
						return path;
					}
				}
			}
		}
		return null; // nothing found
	}


	public static void readXLSFile() throws IOException
	{

		InputStream ExcelFileToRead = new FileInputStream("C:\\TestSheet\\Test.xlsx");
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet=wb.getSheetAt(0);

		HSSFRow row;
		HSSFCell cell;
		Iterator rows = sheet.rowIterator();
		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.next(); 
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}
	}
	public static void writeXLSFile() throws IOException {
		String excelFileName = "C:/Test.xls";//name of excel file
		String sheetName = "Sheet1";//name of sheet
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName) ;
		//iterating r number of rows
		for (int r=0;r < 5; r++ )
		{
			HSSFRow row = sheet.createRow(r);
			//iterating c number of columns
			for (int c=0;c < 5; c++ )
			{
				HSSFCell cell = row.createCell(c);
				cell.setCellValue("Cell "+r+" "+c);
			}
		}
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}




	public static void readXLSXFile() throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream("C:\\TestSheet\\Test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook();
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;
		Iterator rows = sheet.rowIterator();
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();

			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();

				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");

				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}
	}
	public void writeXLSXFile(String FileName,ArrayList<String> testcase,ArrayList<String> page, ArrayList<String> actions,ArrayList<String> arguements, ArrayList<String> result) throws IOException {
		Date date = new Date();
		String resultExcel = FileName;//name of excel file
		String sheetName = "Result";//name of sheet
		int indexoflastslash = FileName.lastIndexOf("\\");
		String testcaseName= FileName.substring(indexoflastslash+1,FileName.length()-5 );
		String folder = FileName.substring(0,indexoflastslash);
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
		System.out.println(timeStamp);
		resultExcel = folder+"\\"+testcaseName+"_result_"+timeStamp+".xlsx";
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;
		//iterating r number of rows
		try{		
			for (int r=0;r< actions.size(); r++ )
			{
				XSSFRow row = sheet.createRow(r);
				//iterating c number of columns
				for (int c=0;c < 5; c++ )
				{
					XSSFCell cell = row.createCell(c);
					if (c==0)
						cell.setCellValue(testcase.get(r));
					if (c==1)
						cell.setCellValue(page.get(r));
					if (c==2)
						cell.setCellValue(actions.get(r));
					if (c==3)
						cell.setCellValue(arguements.get(r));
					if (c==4)
						cell.setCellValue(result.get(r));


				}
			}
			FileOutputStream fileOut = new FileOutputStream(resultExcel);
			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}

		catch(Exception e)
		{
			FileOutputStream fileOut = new FileOutputStream(resultExcel);
			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}
	}
	//		public  ArrayList<String> getColumnData(String filename, String Sheetname,Integer columnIndex) throws IOException
	//		{
	//		InputStream ExcelFileToRead = new FileInputStream(filename);
	//		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
	//		XSSFWorkbook test = new XSSFWorkbook();
	//		//XSSFSheet sheet = wb.getSheetAt(0);
	//		XSSFSheet sheet = wb.getSheet(Sheetname);
	//		XSSFRow row;
	//		XSSFCell cell;
	//		ArrayList<String> columndata = null;
	//		Iterator rows = sheet.rowIterator();
	//		columndata = new ArrayList<String>();
	//		
	//		if (columnIndex==3)
	//		{
	//		for(Row r : sheet) {
	//		   Cell c = r.getCell(columnIndex);
	//		   if(c != null) {
	//			  // System.out.println(c);
	//			   if(c.getCellType()==Cell.CELL_TYPE_STRING)
	//			   {
	//				   if(c.getStringCellValue().contains("No Arguments"))
	//			    	  {
	//			    		  columndata.add("");
	//			    	  }
	//			    	  else
	//			    	  {
	//			    	  columndata.add(c.getStringCellValue());
	//			    	  }
	//				   //columndata.add(c.getStringCellValue());
	//			   }
	//		      if(c.getCellType() == Cell.CELL_TYPE_FORMULA) {
	//		    	
	//		    	  
	//		    	  if(c.getStringCellValue().contains("No Arguments"))
	//		    	  {
	//		    		  columndata.add("");
	//		    	  }
	//		    	  else
	//		    	  {
	//		    	  columndata.add(c.getStringCellValue());
	//		    	  }
	//		      }
	//		      
	//		      
	//		      }
	//		   
	//		}
	//		}
	//		else
	//		{
	//			for(Row r : sheet) {
	//				   Cell c = r.getCell(columnIndex);
	//				   if(c != null){
	//				   String celval=c.getStringCellValue();
	//				   if(celval.isEmpty())
	//				   {
	//					   break;
	//				   }
	//					   else
	//					   {
	//					  // System.out.println(c);
	//				      if(c.getCellType() == Cell.CELL_TYPE_STRING)
	//				      {
	//				    	  columndata.add(c.getStringCellValue());
	//				      }
	//				      else if (c.getCellType()==Cell.CELL_TYPE_BLANK)
	//				      {
	//				    	  columndata.add("");
	//				      }
	//				         
	//				      
	//				   }
	//				   				
	//				}
	//			}
	//		}
	//			
	////		
	//		return columndata;
	//		}

	@SuppressWarnings("null")
	public  ArrayList<String> getColumnData(String filename, String Sheetname,Integer columnIndex) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(filename);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook();
		XSSFSheet sheet = wb.getSheet(Sheetname);
		XSSFRow row;
		XSSFCell cell;
		ArrayList<String> columndata = null;
		Iterator rows = sheet.rowIterator();
		columndata = new ArrayList<String>();


		if (columnIndex==3)
		{
			for(Row r : sheet) {
				Cell c = r.getCell(columnIndex);
				if(c != null) {
					// System.out.println(c);
					if(c.getCellType()==Cell.CELL_TYPE_STRING)
					{
						columndata.add(c.getStringCellValue());
					}
					if(c.getCellType() == Cell.CELL_TYPE_FORMULA) {

						String cl=c.getStringCellValue().toString();
						if(c.getStringCellValue().contains("No Arguments"))
						{
							columndata.add("");
						}
						else
						{
							columndata.add(c.getStringCellValue());
						}
					}

				}

			}
		}
		else
		{
			int d;
			for(Row r : sheet) {

				Cell c = r.getCell(columnIndex);

				if(c==null)
				{	   
					d=r.getRowNum();
					if(columnIndex!=0)
					{
						count=r.getRowNum();
						break;
					}

					if((columnIndex==0)&&(d<count))

					{

						columndata.add("");
					}
					else
						break;
				}
				else
				{
					String celval=c.getStringCellValue();
					if(celval.isEmpty())
					{
						d=c.getRowIndex();
						if(columnIndex!=0)
						{
							count=c.getRowIndex();
							break;
						}

						if((columnIndex==0)&&(d<count))

						{

							columndata.add("");
						}

						else
							break;
					}
					else
					{
						// System.out.println(c);
						if(c.getCellType() == Cell.CELL_TYPE_STRING)
						{
							columndata.add(c.getStringCellValue());
						}
						else if (c.getCellType()==Cell.CELL_TYPE_BLANK)
						{
							columndata.add("");
						}


					}

				}
			}
		}

		//System.out.println(columndata);
		return columndata;
	}




	public  ArrayList<String> getColumnDataMainSheet(String filename, String Sheetname,Integer columnIndex) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(filename);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheet(Sheetname);
		XSSFRow row;
		XSSFCell cell;
		ArrayList<String> columndata = null;
		Iterator rows = sheet.rowIterator();
		columndata = new ArrayList<String>();
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();

			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();

				if (cell.getColumnIndex() == columnIndex)
				{



					if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
					{
						//System.out.print(cell.getStringCellValue()+" ");
						columndata.add(cell.getStringCellValue());

					}
					else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
					{
						//System.out.print(cell.getNumericCellValue()+" ");
						double num = cell.getNumericCellValue();
						BigDecimal bd = new BigDecimal(num);
						long lonVal = bd.longValue();
						String value = String.valueOf(lonVal);
						value = value.replace(".", "");
						columndata.add(value);

					}

				}

			}
			//System.out.println(columndata);
		}
		//wb.close();
		return columndata;
	}


	public  ArrayList<String> getColumnDatafromspecificsheet(Integer columnIndex, String sheetname) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream("C:\\TestSheet\\Test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook();
		//XSSFSheet sheet = wb.getSheetAt(0);

		XSSFSheet sheet = wb.getSheet(sheetname);
		XSSFRow row;
		XSSFCell cell;
		ArrayList<String> columndata = null;
		Iterator rows = sheet.rowIterator();
		columndata = new ArrayList<String>();
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();

			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();

				if (cell.getColumnIndex() == columnIndex)
				{



					if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
					{
						//System.out.print(cell.getStringCellValue()+" ");
						columndata.add(cell.getStringCellValue());

					}
					else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
					{
						//System.out.print(cell.getNumericCellValue()+" ");
						columndata.add(cell.getStringCellValue());

					}
					else
					{
						//need to Handle Boolean, Formula, Errors
						columndata.add("");
					}
				}

			}
			//System.out.println(columndata);
		}

		return columndata;
	}


	public String getValuefromCell(String filename, String Sheetname,int rowno,int colno) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(filename);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheet(Sheetname);
		XSSFRow row=sheet.getRow(rowno);
		String value;
		try{
			value=row.getCell(colno).getStringCellValue();
		}
		catch(Exception e){
			value="";
		}
		// wb.close();
		return value;

	}

	public  void addColumninExcel(String FileName, ArrayList<String> columndata) throws IOException {
		Date date = new Date();
		String resultExcel = FileName;//name of excel file
		String sheetName = "Result";//name of sheet
		int indexoflastslash = FileName.lastIndexOf("\\");
		String testcaseName= FileName.substring(indexoflastslash+1,FileName.length()-5 );
		String folder = FileName.substring(0,indexoflastslash);
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
		System.out.println(timeStamp);
		resultExcel = folder+"\\"+testcaseName+"_resut.xlsm";
		FileInputStream inputFile  = new FileInputStream(FileName);
		XSSFWorkbook wb = new XSSFWorkbook(FileName);
		//XSSFSheet worksheet = wb.getSheetAt(0);
		XSSFSheet worksheet = wb.getSheet("Testcase");
		XSSFRow row ;//= worksheet.getRow(0);
		XSSFCell cell ;//= row.createCell(4);
		XSSFCellStyle stylered = this.returnRed(wb);
		XSSFCellStyle styleblue = this.returnBlue(wb);
		XSSFCellStyle stylegreen = this.returnGreen(wb);
		XSSFCellStyle stylegrey = this.returnGrey(wb);
		//cell.setCellValue(columndata.get(0));
		for (int r=0;r<columndata.size();r++)
		{
			row = worksheet.getRow(r);
			//iterating c number of columns

			cell = row.createCell(4);

			if(columndata.get(r).equals("Result")){

				cell.setCellValue( columndata.get(r));
				//cell.setCellStyle(styleblue);
			}
			else if(columndata.get(r).equals("Not Exceuted")){

				cell.setCellValue( columndata.get(r));
				//cell.setCellStyle(stylegrey);

			}

			else if(columndata.get(r).equals("Passed")){

				cell.setCellValue( columndata.get(r));
				//cell.setCellStyle(stylegreen);
			}
			else {

				cell.setCellValue( columndata.get(r));
				//cell.setCellStyle(stylered);
			}

		}

		FileOutputStream fileOut = new FileOutputStream(resultExcel);
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	public XSSFCellStyle returnBlue(XSSFWorkbook wb){

		// Aqua background
		XSSFCellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);
		return style;
	}


	public XSSFCellStyle returnGreen(XSSFWorkbook wb){

		// Aqua background
		XSSFCellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);
		return style;
	}

	public XSSFCellStyle returnGrey(XSSFWorkbook wb){

		// Aqua background
		XSSFCellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);
		return style;
	}

	public XSSFCellStyle returnRed(XSSFWorkbook wb){

		// Aqua background
		XSSFCellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);
		return style;
	}
	/*


			    // Orange "foreground", foreground being the fill foreground not the font color.
			    style = wb.createCellStyle();
			    style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
			    style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			    cell = row.createCell((short) 2);
			    cell.setCellValue("X");
			    cell.setCellStyle(style);
	 */

	// Write the output to a file
	/* FileOutputStream fileOut = new FileOutputStream("C:\\Users\\ab87347\\Documents\\ExcelCheck.xls");
			    wb.write(fileOut);
			    fileOut.close();
	 */
	//}



}



