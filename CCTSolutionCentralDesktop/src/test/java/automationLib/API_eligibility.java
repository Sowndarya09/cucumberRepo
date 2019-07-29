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



public class API_eligibility {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getEligibility(String[] args) throws IOException, InterruptedException{
		String muid = getMemberUID(args);

		String siturl = "https://uat.api.anthem.com/v2/pegadesktop/members/eligibility?mbruid="+muid;
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		parser = api.getUrl(siturl, "apikey", apikey);
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}
		return true;
	}

	public String getMemberUID(String[] args) throws IOException, InterruptedException {
		JsonParser parser1;
		String siturl = "https://uat.api.anthem.com//v2/pegadesktop/members/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json = "{\"mbrLookupId\":\""+args[0]+"\"} ";
		parser1 = api.Posturl(siturl, "apikey", apikey, json);
		String memberuid = null;
		while(parser1.hasNext()){
			Event e=parser1.next();
			if(e==Event.KEY_NAME && parser1.getString().equals("mbrUid")){
				parser1.next();
				memberuid = parser1.getString();
				parser1.next();
				if(e==Event.KEY_NAME && parser1.getString().equals("firstNm")){
					parser1.next();
					if(parser1.getString().equals(args[1]))
						return memberuid;
				}

			}
		}
		return memberuid;
	}


	public boolean validateRaceCode(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("raceCd")){
				for(String arg:args) {
					parser.next();
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						if(parser.getString().equals(arg)) {
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
						}else {
							blogger.loginfo("Values Mismatch: "+arg);
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
