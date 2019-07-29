package automationLib;

import java.io.IOException;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import utils.APIUtils;
import utils.BaseLogger;

public class API_ProviderNPI_OrganizationSearch {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	
	BaseLogger blogger=new BaseLogger();

	public boolean getProviderNPI(String[] args) throws IOException, InterruptedException {

		String siturl = "https://uat.api.anthem.com/v2/epds/organizations/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";

		String json = "{\"npiId\":[\"" + args[0] + "\"],\"srcSys\": [\"All\"]}";

		parser = api.Posturl(siturl, "apikey", apikey, json);

		return true;

	}

	public boolean validateProvAddress(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("provAdrs")){
				parser.next();
				parser.next();
				for(String arg:args) {
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						if(parser.getString().equals(arg)) {
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
						}else {
							blogger.loginfo("Values Mismatch: "+arg);
							flag = false;
						}
						
						parser.next();
						if(!parser.getString().equals("")) {
							blogger.loginfo("Response: "+parser.getString());
						}else {
							blogger.loginfo("Values is Empty");
							flag = false;
						}
					}else {
						blogger.loginfo("Values not present in Response: "+arg);
						flag = false;
					}
				}
				break;
			}
		}

		return flag;
	}
	
	public boolean validateProvAddressZipCode(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("zipCd")){
				parser.next();
				for(String arg:args) {
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						if(parser.getString().equals(arg)) {
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
						}else {
							blogger.loginfo("Values Mismatch: "+arg);
							flag = false;
						}
						parser.next();
						if(!parser.getString().equals("")) {
							blogger.loginfo("Response: "+parser.getString());
						}else {
							blogger.loginfo("Values is Empty");
							flag = false;
						}
					}else {
						blogger.loginfo("Values not present in Response: "+arg);
						flag = false;
					}
				}
				break;
			}
		}

		return flag;
	}
}
