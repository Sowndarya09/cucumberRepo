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



public class API_AccumBenefitNames {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getAccumsDetails(String[] args) throws IOException, InterruptedException{
		String siturl = "https://uat.api.anthem.com/v1/products/benefits/accumsbenefitnames";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json ="{\"requestDt\":\"\",\"contractCd\":\""+args[0]+"\",\"planType\":\"MED\",\"startDt\":\"2015-01-01\",\"endDt\":\"2015-12-31\",\"accums\": [{\"accumNm\":\"FOOPNPOC\"},{\"accumNm\":\"COBEXP\"},{\"accumNm\":\"OINOOP\"}]}";
	
		System.out.println("Json: "+json);
		parser = api.Posturl(siturl, "apikey", apikey, json);
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}
		
		return true;
	}
	
	
	public boolean validateCostShares(String[] args) throws IOException, InterruptedException{
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("costShares")){
				e=parser.next();
				for(String arg:args) {
					parser.next();
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						System.out.println(parser.getString());
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
