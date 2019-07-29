package dataReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import TestDataPOJO.memberdetails;
public class JsonDataParsor {

	private final String customerFilePath = "Data//Data_Json.json";
	private List<memberdetails> memberinfo;
	
	public JsonDataParsor(){
		memberinfo= getmemberdetails();
	}
	
	private List<memberdetails> getmemberdetails() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			memberdetails[] members = gson.fromJson(bufferReader, memberdetails[].class);
			return Arrays.asList(members);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public  final memberdetails getmemberbyusername(String username){
			 //return memberinfo.stream().filter(x -> x.username.equalsIgnoreCase(customerName)).findAny().get();
		for(memberdetails mem : memberinfo) {
			 if(mem.username.equalsIgnoreCase(username)) return mem;
			 }
			 return null;
			 }
	
	public  final memberdetails getmemberbydataid(String dataid){
		 //return memberinfo.stream().filter(x -> x.username.equalsIgnoreCase(customerName)).findAny().get();
	for(memberdetails mem : memberinfo) {
		 if(mem.id.equalsIgnoreCase(dataid)) return mem;
		 }
		 return null;
		 }
	}
	



