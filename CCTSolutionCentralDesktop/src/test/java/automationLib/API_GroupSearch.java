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



public class API_GroupSearch {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getGroupSearch() throws IOException, InterruptedException{
		String siturl = "https://uat.api.anthem.com/v1/members/group/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json = "{\"grpId\":\"12\",\"limit\":\"300\"}";
		parser = api.Posturl(siturl, "apikey", apikey, json);
		return true;
	}
	
	
	public boolean validateEmployerGroup(String[] args) throws IOException, InterruptedException{
		this.getGroupSearch();
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("employerGrp")){
				for(String arg:args) {
					parser.next();
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
						}else {
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
	
	
	
	public boolean validateStatusCode(String[] args) throws IOException, InterruptedException{
		this.getGroupSearch();
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("statusCd")){
				for(String arg:args) {
					parser.next();
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
						}else {
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
	
	
	public boolean validateProductGroup(String[] args) throws IOException, InterruptedException{
		this.getGroupSearch();
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("productGrp")){
				parser.next();
				for(String arg:args) {
					parser.next();
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
						}else {
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
