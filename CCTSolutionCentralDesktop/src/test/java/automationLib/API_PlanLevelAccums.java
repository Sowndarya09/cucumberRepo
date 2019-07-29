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



public class API_PlanLevelAccums {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getMemberID(String[] args) throws IOException, InterruptedException{
		String siturl = "https://uat.api.anthem.com/v2/products/benefits/planlevelaccums";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json ="{\"memberCd\":\"10\",\"planType\":\"MED\",\"hcid\":\""+args[0]+"\",\"contractCd\":\"0SDK\",\"sourceSystemId\":\"STAR\",\"groupId\":\"IN\",\"lastQuarterFlag\":\"Y\",\"startDt\":\"2014-01-01\",\"endDt\":\"2014-01-01\"}";		
		System.out.println("Json: "+json);
		parser = api.Posturl(siturl, "apikey", apikey, json);
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
					//e=parser.next();
					if(e!=Event.END_OBJECT) {
						System.out.println(parser.getString());
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
							//parser.next();
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
	
	public boolean validateCostShares(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("costShares")){
				parser.next();
				e=parser.next();
				
				for(String arg:args) {	
					e=parser.next();
					//e=parser.next();
					if(e!=Event.END_OBJECT) {
						System.out.println(parser.getString());
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
							e=parser.next();
							//e=parser.next();
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
