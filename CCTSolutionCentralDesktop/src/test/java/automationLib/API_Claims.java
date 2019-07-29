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



public class API_Claims {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getClaims(String[] args) throws IOException, InterruptedException{
		String siturl = "https://sit.api.anthem.com/v2/members/C52ABE68AEB858DDBEDB3BB34D59B01A/claims/998A74D1BB5470A7494CFB3E2118E870?clmseqnbr="+args[0];
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		parser = api.getUrl(siturl, "apikey", apikey);
		
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}
		
		return true;
	}
	
	
	public boolean validatePlanNetworkInd(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("planNetworkInd")){
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
