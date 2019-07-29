package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class CompareFeatureFiles {

	static BufferedReader reader1;
	static BufferedReader reader2;

	 static ArrayList<String> al = new ArrayList<String>();
	 static ArrayList<String> al1 = new ArrayList<String>();
	
	
	
	static ArrayList<String> tempList = new ArrayList<String>(al1);
	
	static ArrayList<String> tempList1 = new ArrayList<String>(al);
	
	static HashMap<String,String> map1 = new HashMap<String,String>();
	
	static String first;
	
	static String second;
	
	 CompareFilesCopy cfc = new CompareFilesCopy();
	 
		boolean foundString = false;

	public void compare() throws IOException {
		
		//File directory = new File("C:\\Users\\AF56975\\Documents\\Compare");
		File directory = new File(ImportExport.filePath12);


		
		//File directory1 = new File("C:\\Users\\AF56975\\Documents\\Compare1");
		File directory1 = new File(ImportExport.filePath13);


		File[] fList = directory.listFiles();
		//System.out.println("File: ");
		for (File file : fList) {
			al.add(file.getName());
		}
		//System.out.println(al.toString());

		File[] fList1 = directory1.listFiles();
		//System.out.println("File 1: ");
		for (File file1 : fList1) {
			al1.add(file1.getName());

		}
		


		for (int i = 0; i < al.size(); i++) {
			first = al.get(i);
			String value = null;
			//System.out.println("First: " + first);
			for (int j = 0; j < al1.size(); j++) {
				second = al1.get(j);
				//System.out.println("Second: " + second);
				if (first.equals(second)) {				
					 foundString = true; 		 
					 if(foundString)
					tempList.add(second);
					 value = "Matched";
					 break;
				} else {
					value = "Not Matched";
					continue;
				}
			}
			map1.put(first, value);
		}
		
		
		for (int i = 0; i < al1.size(); i++) {
			first = al1.get(i);
			String value = null;
			System.out.println("First: " + first);
			for (int j = 0; j < al.size(); j++) {
				second = al.get(j);
				System.out.println("Second: " + second);
				if (first.equals(second)) {				
					 value = "Matched";
					 break;
				} else {
					value = "Not Matched";
					continue;
				}
			}
			map1.put(first, value);
		}
	
		System.out.println("Values in Temp List: ");
		
		for(int k = 0; k < tempList.size(); k++)
		{
			
			System.out.println(tempList.get(k));
		}
		
		
		
		System.out.println("Values in Map1 : ");
		for (Entry<String, String> entry : map1.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
	

	}

	

	public static void main(String[] args) throws IOException {
		CompareFeatureFiles cf = new CompareFeatureFiles();
		cf.compare();
	}

}
