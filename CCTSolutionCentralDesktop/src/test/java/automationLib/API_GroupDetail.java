package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.apache.poi.util.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;



import utils.APIUtils;
import utils.BaseLogger;



public class API_GroupDetail {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getGroupDetail(String[] args) throws IOException, InterruptedException{
		String siturl = "https://uat.api.anthem.com//v2/group/details";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json = "{\"grpId\": \""+args[0]+"\",\"srcSysId\": \""+args[1]+"\",\"subscriberId\": \""+args[2]+"\",\"subgrpId\": \""+args[3]+"\"}";

		parser = api.Posturl(siturl, "apikey", apikey, json);
		Thread.sleep(1000);
		System.out.println();
		
		if(parser==null)
			return false;
		return true;
	}


	public boolean validateClaimsAddress(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("claimsAddress")){
				for(String arg:args) {
					parser.next();
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						if(parser.getString().equals(arg)) {
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

	public boolean validatePolicyStateCd(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("policyStateCd")){
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

	public boolean validateEligibilityStateCode(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("elgbltySttsCd")){
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
