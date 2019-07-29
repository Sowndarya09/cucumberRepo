package automationLib;

import java.io.IOException;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import utils.APIUtils;
import utils.BaseLogger;

public class API_ProviderTaxID {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	
	BaseLogger blogger=new BaseLogger();

	public boolean getProviderTaxID(String[] args) throws IOException, InterruptedException {

		String siturl = "https://uat.api.anthem.com/v2/epds/organizations/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";

		String json = "{\"taxId\":\"" + args[0] + "\",\"srcSys\": [\"All\"]}";

		parser = api.Posturl(siturl, "apikey", apikey, json);

		return true;

	}

	public boolean validateProvAddress(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("zipCd")){
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
	
	/*public boolean validateProvAddress(String[] args) throws IOException, InterruptedException {
		// getProviderTaxID(args[0]);
		// String[] keyvalue = args[0].split(":");
		// String key=keyvalue[0];
		// String value=keyvalue[1];
		boolean returnflag = true;
		while (parser.hasNext()) {
			Event e = parser.next();
			if (e == Event.KEY_NAME && parser.getString().equals("provAdrs")) {
				parser.next();
				parser.next();
				while (!(parser.next() == Event.END_OBJECT)) {
					for (String iterator : args) {
						if (!returnflag) {
							return false;
						}
						String key = iterator.substring(0, iterator.indexOf(":"));
						String value = iterator.substring(iterator.indexOf(":") + 1);
						System.out.println("key: "+key+" "+"value:" + value);
						blogger.loginfo("key" + key + "value " + value);
						
						if (parser.getString().equals(key))
							parser.next();
						if (parser.getString().replace(",", "").equals(value)) {
							parser.next();
							returnflag = true;
						} else {
							returnflag = false;
						}

					}
					if (returnflag) {
						blogger.loginfo("API Verification Passed for the Provider Address");
						return true;
					} else {
						blogger.loginfo("API Verification Failed for the Provider Address");
						return false;
					}
				}
			}
		}
		return returnflag;
	}*/
	
	
}
