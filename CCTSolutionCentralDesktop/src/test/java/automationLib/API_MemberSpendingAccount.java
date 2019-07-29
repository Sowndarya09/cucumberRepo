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



public class API_MemberSpendingAccount {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	BaseLogger blogger = new BaseLogger();

	public boolean getMemberSpendingAccount() throws IOException, InterruptedException{
		String siturl = "https://uat.api.anthem.com/v1/castlight/members/spendingaccounts/contexts";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";
		//String json = "{\"serviceType\":"",\"reason\":\"Durable Medical Equipment\",\"methodOfReceipt\":\"Phone\",\"createdByUserId\":\"AE02650\",\"requestTypeCategory\":\"Member Services\",\"comments\":\"d| sd\",\"requestType\":\"\",\"benefitType\":\"\",\"isExternalResolutionPartial\":\"true\",\"priority\":\"Standard\",\"requestLevel\":\"Appeal\",\"subReason\":\"Orthotic\",\"documentsCount\":\"0\",\"receivedDateTime\":\"20180724T191304.370 GMT\",\"createdByUserName\":\"Murahari Thatikonda\",\"application\":\"Solution Central\",\"externalResolutionComments\":\"d\",\"member\":{\"isMemberInsystemOfRecord\":\"true\",\"firstName\":\"CARL\",\"lastName\":\"TOBAR\",\"address\":{\"zip\":\"20148\",\"phoneNumber\":\"6325897412\",\"addrLine2\":"","city":"ASHBURN","addrLine1":"144 TRAJENDA","state":"VA"},"policyState":"CT","systemOfRecord":"STAR","dateOfBirth":"07/21/1999","ID":"889T90020","isAddressOverride":"","lob":"Commercial","isMemberInCollection":"false"},"requestCategory":"Administrative","requestBy":"Member","extReqId":"S-1956008"}";
		String json ="{\"hcId\":\"207T90630\",\"sourceSystemId\":\"WGS20\",\"groupId\":\"NY5412G256\"}";
	
		System.out.println("Json: "+json);
		parser = api.Posturl(siturl, "apikey", apikey, json);
		return true;
	}
	
	
	public boolean validateContexts(String[] args) throws IOException, InterruptedException{
		this.getMemberSpendingAccount();
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			//e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("groupId")){
				for(String arg:args) {
					parser.next();
					e=parser.next();
					//e=parser.next();
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
	
	
	


}
