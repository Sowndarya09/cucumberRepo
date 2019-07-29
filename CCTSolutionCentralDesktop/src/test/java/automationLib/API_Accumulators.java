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



public class API_Accumulators {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();



	public boolean getAccums(String[] args) throws IOException, InterruptedException {
		String siturl = "https://uat.api.anthem.com//v2/products/benefits/accums";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json = "{\"memberCd\":\""+args[0]+"\",\"planType\":\""+args[1]+"\",\"hcid\":\""+args[2]+"\",\"contractCd\":\""+args[3]+"\",\"sourceSystemId\":\""+args[4]+"\",\"groupId\":\""+args[5]+"\",	\"startDt\":\""+args[6]+"\",\"endDt\":\""+args[7]+"\"}  ";
		parser = api.Posturl(siturl, "apikey", apikey, json);
		
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}
		
		return true;
	}


	public boolean validateAccums(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("accums")){
				parser.next();
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
				break;
			}
		}

		return flag;
	}


}
