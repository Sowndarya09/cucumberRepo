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



public class API_EthinicityRace {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getEthinicityRace(String[] args) throws IOException, InterruptedException{
		String muid = getMemberUID(args);
		
		String siturl = "https://sit.api.anthem.com/v1/pegadesktop/members/ethnicityrace";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json = "{\"mbrUid\":\""+muid+"\",\"attribute\": [{\"attributeType\":\"Race\",\"attributeCd\":{\"code\":\""+args[2]+"\",\"name\":\""+args[3]+"\"}}]}";
		parser = api.Posturl(siturl, "apikey", apikey, json);
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

	
	
	public boolean validateEthinicityRace(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
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

		return flag;
	}

}
