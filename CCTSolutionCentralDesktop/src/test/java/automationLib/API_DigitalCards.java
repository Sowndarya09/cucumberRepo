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



public class API_DigitalCards {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getDigitalCards(String[] args) throws IOException, InterruptedException{
		String siturl = "https://uat.api.anthem.com///v1/digitalidcards/memberverification";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json ="{\"hcId\":\""+args[0]+"\",\"sourceSystemId\":\""+args[1]+"\",\"firstNm\":\""+args[2]+"\",\"lastNm\":\""+args[3]+"\"}";
		parser = api.Posturl(siturl, "apikey", apikey, json);
		
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}
		
		return true;
	}
	
	
	public boolean validateAcknowledgementStatus(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("acknowledgementStatus")){
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


}
