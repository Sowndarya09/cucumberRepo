package automationLib;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import extentmanager.ExtentManager;
import utils.APIUtils;
import utils.BaseLogger;
import utils.ErrorLogger;

public class API_ProviderNPI_PractitionersSearch {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	Boolean flag;
	int count=0;

	public boolean getProviderNPI(String[] args) throws IOException, InterruptedException{

		String url = "https://uat.api.anthem.com/v2/epds/practitioners/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		String json = "{\"npiId\":\"" + args[0] + "\",\"srcSys\": [\"All\"]}";

		parser = api.Posturl(url, "apikey", apikey, json);

		/**Verify API in 10 Seconds Gap and returns warning if issue exists*/
		if(parser==null) {
			count++;
			Thread.sleep(10000); //10 sec sleep
			if(count>=3) {
				err.logerrormessage("service down-unable to retrive data");
				ExtentManager.setTeststatus("Warning - Service Down");
				return false;
			}
			flag = getProviderNPI(args);
			return flag;
		}

		return true;
	}

	public boolean validateProvAddress(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("provAdrs")){
				parser.next();
				parser.next();
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
		}

		return flag;
	}

	public boolean validateProvAddressZipCode(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("zipCd")){
				parser.next();
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
		}

		return flag;
	}


	public boolean validateSpeciality(String[] args){
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("specialty")){
				parser.next();
				parser.next();
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
		}

		return flag;
	}
}
