package utils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataSet 
{
	int flag=0;
	public static Map<String, String> data = new HashMap<String, String>();
	public static ArrayList<String> dataset= null;
	//MainDriverTest.arguementsColumn;
	ExcelUtilities excel=new ExcelUtilities();
	String multidata="String";
			//excel.getValuefromCell(MainDriverTest.currentpath, "Environment", 1,3 );
	String datakey="String";
			//excel.getValuefromCell(MainDriverTest.currentpath, "Environment", 1,4 );
	
	ArrayList<String> DataKeys,HCIDList,FullNameList,LastNameList,FirstNameList,AddressList,DOBList,SSNList,EIDList;
	String DATASHEET,HCID,FullName,LastName,FirstName,Address,DOB,SSN,EID;
	int datacount=2;
	
	public  DataSet() throws IOException
	{
		try{
			if(flag==0)
			{
				if(true)
						//excel.getValuefromCell()MainDriverTest.currentpath,"Testcase",1,4).contains("DATASHEET"))
				{
					DATASHEET="ACTIVE";
					getDatafromDatasheet();
					
				}
				else
					DATASHEET="NOT-ACTIVE";
			}
			flag=1;
		
		}
		catch(Exception e)
		{
		System.out.println("exception "+e );
		}
				
		
	}

	public String getDatsheetStatus()
	{
		return DATASHEET;
		
	}
	public String getHCID()
	{
		return HCID;
	}
	
	public String getFullName()
	{
		return FullName;
	}
	
	public String getLastName()
	{
		return LastName;
	}
	
	public String getFirstName()
	{
		return FirstName;
	}
	
	public String getAddress()
	{
		return Address;
	}
	
	public String getDOB()
	{
		return DOB;
	}
	
	public String getSSN()
	{
		return SSN;
	}
	
	public String getEID()
	{
		return EID;
	}
	
	public void setHCID(int rowno)
	{
		HCID=HCIDList.get(rowno);
	}
	public void setSSN(int rowno)
	{
		SSN=SSNList.get(rowno);
	}
	public void setFullName(int rowno)
	{
		FullName=FullNameList.get(rowno);
	}
	public void setLastName(int rowno)
	{
		LastName=FullNameList.get(rowno);
	}
	public void setAddress(int rowno)
	{
		Address=AddressList.get(rowno);
	}
	public void setDOB(int rowno)
	{
		DOB=DOBList.get(rowno);
	}
	public void setEID(int rowno)
	{
		EID=EIDList.get(rowno);
	}
	public void setFirstName(int rowno)
	{
		FirstName=FirstNameList.get(rowno);
	}
	 public int getDataCount()
	 {
		 if(multidata.toLowerCase().contains("no")||multidata.isEmpty())
			 return 2;
		 else
			 
		 return datacount;
	 }
	
	 public String DataKey()
	 {
		 return datakey;
	 }
	
	public ArrayList<String> getresultarray()
	{
		
		return dataset;
	}
	
	public ArrayList<String> getresultarray(int datarow)
	{
		setHCID(datarow);
		setFullName(datarow);
		setLastName(datarow);
		setFirstName(datarow);
		setAddress(datarow);
		setDOB(datarow);
		setSSN(datarow);
		setEID(datarow);
		assigndatatoarguementsColumn(dataset);
		return dataset;
	}
	
	public String getMultidata()
	{
		return multidata;
	}

	
	public void getDatafromDatasheet() throws IOException
	{
		HCIDList=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 1);
		FullNameList=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 2);
		LastNameList=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 3);
		FirstNameList=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 4);
		AddressList=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 5);
		DOBList=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 6);
		SSNList=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 7);
		EIDList=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 8);
		datacount=HCIDList.size();
		if(multidata.toLowerCase().contains("no"))
		{
	    DataKeys=excel.getColumnData("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data", 0);	
	    int rowno=DataKeys.indexOf(datakey);
	    getresultarray(rowno);
		}
	}
	
	public void DataStore(String key,String value) throws IOException
	{
		
	      data.put(key, value);
	      System.out.println("datastore "+data);
	      	
	}
	
	public String getStoredData(String key)
	{
		System.out.println("getStored Data "+data);
		String valuetocheck=data.get(key);
		return valuetocheck;
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
	
//	public ArrayList<String> assignvaluefromdatasheet() throws IOException
//	{
//		
//		setHCID(excel.getValuefromCell("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data",1,0));
//		setFullName(excel.getValuefromCell("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data",1,1));
//		setLastName(excel.getValuefromCell("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data",1,2));
//		setFirstName(excel.getValuefromCell("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data",1,3));
//		setAddress(excel.getValuefromCell("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data",1,4));
//		setDOB(excel.getValuefromCell("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data",1,5));
//		setSSN(excel.getValuefromCell("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data",1,6));
//		setEID(excel.getValuefromCell("C:\\SolutionCentralEngine\\DataSheet.xlsx","Data",1,7));
//
//		assigndatatoarguementsColumn(dataset);
//		return dataset;
//
//		
//	}
	public  int countOccurrences(String parameters, char colon)
	{
	    int count = 0;
	    for (int i=0; i < parameters.length(); i++)
	    {
	        if (parameters.charAt(i) == colon)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	

	public ArrayList<String> assigndatatoarguementsColumn(ArrayList<String> argumentscolumn)
	{
		int count=-1;
		for(String iterator : dataset)
		{
			count++;
		if(iterator.contains(":"))
		{
			int columncount=countOccurrences(iterator,',');
			if(columncount<1)
			{
			String columnName = iterator.substring(0,iterator.indexOf(":"));
			iterator=columnName;
			}
			else
			{
			String value=seperatecsvalues(iterator);
			dataset.set(count, value);
			continue;
			
			
			}
		}
		
				if(iterator.toLowerCase().contains("hcid"))
				{
				  String temp=getHCID();
				  iterator=iterator+":"+temp;
				  dataset.set(count, iterator);
				  
				}
				else if(iterator.toLowerCase().contains("ssn"))
				{
					 String temp=getSSN();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
					
				}
				else if(iterator.toLowerCase().contains("dob"))
				{
					 String temp=getDOB();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
				}
				else if(iterator.toLowerCase().contains("eid"))
				{
					 String temp=getEID();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
				}
				else if(iterator.toLowerCase().contains("firstname"))
				{
					 String temp=getFirstName();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
				}
				else if(iterator.toLowerCase().contains("lastname"))
				{
					 String temp=getLastName();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
				}
				else if(iterator.toLowerCase().contains("fullname"))
				{
					String temp=getFullName();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
				}
				else if(iterator.toLowerCase().contains("address"))
				{
					String temp=getAddress();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
				}
				else if(iterator.toLowerCase().contains("membername"))
				{
					String temp=getFullName();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
				}
				else if(iterator.toLowerCase().contains("memberid"))
				{
					String temp=getHCID();
					  iterator=iterator+":"+temp;
					  dataset.set(count, iterator);
				}
				
				
			}
			
			
		
		return dataset;
	}
	
	public String seperatecsvalues(String iteratorcsv)
	{
		String finalString="";
		int noofkeyvaluepairs=countOccurrences(iteratorcsv,',');
		ArrayList<String> sublist = new ArrayList<String>(Arrays.asList(iteratorcsv.split(",")));
		
			int subcount=-1;
		for(String iterator:sublist)
		{
			subcount++;
			if(iterator.contains(":"))
			{
				
				String columnName = iterator.substring(0,iterator.indexOf(":"));
				iterator=columnName;
			}
			
			if(iterator.toLowerCase().contains("hcid"))
			{
				
			  String temp=getHCID();
			  iterator=iterator+":"+temp;
			  sublist.set(subcount, iterator);
			  
			}
			else if(iterator.toLowerCase().contains("ssn"))
			{
				 String temp=getSSN();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
				
			}
			else if(iterator.toLowerCase().contains("dob"))
			{
				 String temp=getDOB();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
			}
			else if(iterator.toLowerCase().contains("eid"))
			{
				 String temp=getEID();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
			}
			else if(iterator.toLowerCase().contains("firstname"))
			{
				 String temp=getFirstName();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
			}
			else if(iterator.toLowerCase().contains("lastname"))
			{
				 String temp=getLastName();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
			}
			else if(iterator.toLowerCase().contains("fullname"))
			{
				String temp=getFullName();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
			}
			else if(iterator.toLowerCase().contains("address"))
			{
				String temp=getAddress();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
			}
			else if(iterator.toLowerCase().contains("membername"))
			{
				String temp=getFullName();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
			}
			else if(iterator.toLowerCase().contains("memberid"))
			{
				String temp=getHCID();
				  iterator=iterator+":"+temp;
				  sublist.set(subcount, iterator);
			}
			
			
		}
		for(int i=0;i<sublist.size();i++)
		{
			finalString=finalString+sublist.get(i)+',';
		}
		finalString = finalString.substring(0, finalString.length()-1);
		return finalString;
	}
	
}
