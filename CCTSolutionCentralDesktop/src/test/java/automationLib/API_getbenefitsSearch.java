package automationLib;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;



import utils.APIUtils;



public class API_getbenefitsSearch {
	
	static JsonParser parser;
	
	APIUtils api = new APIUtils();
	public boolean getbenefitsSearch(String[] args){
		
		String siturl = "https://sit.api.anthem.com//v1/products/sensentia/benefits/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		JSONObject jobj = new JSONObject();
		
		jobj.put("Date_Of_Service", "03/01/2018");
		jobj.put("Member_Dependent", "M");
		jobj.put("version", "1");
		jobj.put("Model", "2ESG");
		jobj.put("Gender", "Female");
		jobj.put("Inquiry", "Ambulance");
		
		/*for(int i=0;i<args.length;i++)
			{String[] values = args[i].split(":");
		jobj.put(values[0], values[1]);
		
			}
		jobj.put("Provider_type", "");	*/
		String json  = JSONValue.toJSONString(jobj);
		System.out.println(json);
		parser = api.Posturl(siturl, "apikey", apikey, json);		
		return true;
				
	}
	
	public boolean validatebenefitEOCvalues(String[] args){
		String[] keyvalue = args[0].split(":");
		String key=keyvalue[0];
		String value=keyvalue[1];
		boolean returnflag=false;		
		//this.getbenefitsSearch();
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("EOC_Information")){
				parser.next();
				while(!(parser.next()==Event.END_OBJECT ))	{
					if(parser.getString().equals(key))
						parser.next();
					if(parser.getString().replace(",","").equals(value))
						returnflag=true;
				System.out.println(parser.getString());
				
				}
				
				
			}
		}
		return returnflag;
	}

}
