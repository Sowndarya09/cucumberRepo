package utils;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cucumber.api.PendingException;
import extentmanager.ExtentManager;

public class DataStore {
	
	

	public static Map<String, String> datamap = new HashMap<String, String>();
	public static ArrayList<String> datalist= null;
	public static Map<String, String> getDatamap() {
		return datamap;
	}
	public static void setDatamap(Map<String, String> datamap) {
		DataStore.datamap = datamap;
	}
	public static ArrayList<String> getDatalist() {
		return datalist;
	}
	public static void setDatalist(ArrayList<String> dataset) {
		DataStore.datalist = dataset;
	}
	public static Map<String, Map<String,String>> masterData = new HashMap<String, Map<String,String>>();

	public static void storeData(String page, String key, String value) {
		page = ExtentManager.getReportName()+"-"+page;
		System.out.println(page);
		BaseLogger blogger = new BaseLogger();
		blogger.loginfo("Stored Data: "+page);
		Map<String, String> pageds = new HashMap<String, String>();
		if(!masterData.containsKey(page)) {	
			pageds.put(key, value);
			masterData.put(page, pageds);
		}
		else
			masterData.get(page).put(key, value);

	}

	private boolean checkData(ArrayList<String> approvedvars, String var) {

		if(approvedvars.contains(var))
			return false;
		return true;	

	}

	public static Map<String, Map<String,String>> getMasterData(){
		return masterData;
	}

	public static String retrieveData(String page, String key)
	{
		page = ExtentManager.getReportName()+"-"+page;
		System.out.println(page);
		BaseLogger blogger = new BaseLogger();
		blogger.loginfo("Retrieved Data: "+page);
		try {
			if(masterData.get(page).get(key)!=null)
				return masterData.get(page).get(key);
			else {
				System.out.println("Please check the variable, since variable is not present in the DataSet");
				throw new PendingException("Data is not stored in the DataSet");
			}

		}
		catch(NullPointerException e) {
			System.out.println("Page Name is not present in the DataSet");
			throw new NullPointerException("Data is not stored in the DataSet");
		}

	}
}

