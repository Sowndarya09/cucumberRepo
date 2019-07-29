package automationLib;

import java.io.IOException;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import utils.APIUtils;
import utils.BaseLogger;

public class API_MemberPortal {

	static JsonParser parser;
	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();
	
	public boolean getMemberSummaryDetails(String[] args) throws IOException, InterruptedException{
		String apiurl = "https://uat.api.anthem.com/v7/cp/members/summary?usernm="+args[0];
		String apikey = "8rtdWIrQKfbz9Rd9AgAHMNDV7w4VTvyi";
	
		parser = api.getUrl(apiurl, "apikey", apikey);
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}
		
		return true;
	}
	
	
	public boolean validateSummaryDetails(String[] args) throws IOException, InterruptedException{
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("underwritingStateCd")){
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
				break;
			}
		}
		return flag;
	}
	
	
	
}
