package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;



import utils.APIUtils;
import utils.BaseLogger;



public class API_MemberSearch {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getMemberLookUpID(String[] args) throws IOException, InterruptedException{
		String siturl = "https://uat.api.anthem.com/v3/pegadesktop/members/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json ="{\"limit\":\"129\",\"mbrLookupId\":\""+args[0]+"\"}";
		parser = api.Posturl(siturl, "apikey", apikey, json);
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}
		return true;
	}
	
	
	public boolean validateMemberDetails(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("members")){
				parser.next();
				e=parser.next();
				for(String arg:args) {
					
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						System.out.println(parser.getString());
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
							e=parser.next();
						}else {
							//System.out.println("Response: "+parser.getString()+" Input: "+args[0]);
							blogger.loginfo(parser.getString()+" Values Mismatch: "+arg);
							flag = false;
						}
					}else {
						blogger.loginfo("Values not present in Response: "+arg);
						flag = false;
					}
				}
			}
		}

		return flag;
		
	}
	
	public boolean validateGenderCode(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("genderCd")){
				for(String arg:args) {
					parser.next();
					e=parser.next();
					//e=parser.next();
					if(e!=Event.END_OBJECT) {
						System.out.println(parser.getString());
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
							//parser.next();
						}else {
							//System.out.println("Response: "+parser.getString()+" Input: "+args[0]);
							blogger.loginfo(parser.getString()+" Values Mismatch: "+arg);
							flag = false;
						}
					}else {
						blogger.loginfo("Values not present in Response: "+arg);
						flag = false;
					}
				}
			}
		}

		return flag;
		
	}
	
	
	
	public boolean validateRelationShipCode(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("relationshipCd")){
				for(String arg:args) {
					parser.next();
					e=parser.next();
					//e=parser.next();
					if(e!=Event.END_OBJECT) {
						System.out.println(parser.getString());
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+args);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
							//parser.next();
						}else {
							//System.out.println("Response: "+parser.getString()+" Input: "+args[0]);
							blogger.loginfo(parser.getString()+" Values Mismatch: "+arg);
							flag = false;
						}
					}else {
						blogger.loginfo("Values not present in Response: "+arg);
						flag = false;
					}
				}
			}
		}

		return flag;
		
	}


}
