package automationLib;

import java.io.IOException;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import utils.APIUtils;
import utils.BaseLogger;

public class API_UtilityTables {

	
	
	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getUtilityParser() throws IOException, InterruptedException{
		String siturl = "https://sit.api.anthem.com/v1/wgs20/utility/tables";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json ="{\"tableReadArray\": [{\"fieldNm\":\"EOB\",\"fieldKey\":\"66\",\"sourceCd\":\"DDC KEYED CLAIM\"},{\"fieldNm\":\"EOB\",\"fieldKey\":\"67\",\"sourceCd\":\"DDC KEYED CLAIM\"},{\"fieldNm\":\"TYPEOFSERVICE\",\"fieldKey\":\"08\"},{\"fieldNm\":\"PLACEOFSERVICE\",\"fieldKey\":\"81\"}]}";
		System.out.println("Json: "+json);
		parser = api.Posturl(siturl, "apikey", apikey, json);
		return true;
	}
	
	
	public boolean validateUtilityTableValues(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("tableResponseArray")){
				parser.next();
				e=parser.next();
				for(String arg:args) {
					
					e=parser.next();
					if(e!=Event.END_OBJECT) {
						System.out.println(parser.getString());
						if(parser.getString().trim().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
							e=parser.next();
						}else {
							//System.out.println("Response: "+parser.getString()+" Input: "+args[0]);
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
