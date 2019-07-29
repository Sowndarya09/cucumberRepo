package automationLib;

import java.io.IOException;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import utils.APIUtils;
import utils.BaseLogger;

public class API_BillsIndividuals {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	
	BaseLogger blogger=new BaseLogger();

	
	public boolean getMemberLookUpID(String[] args) throws IOException, InterruptedException {

		String siturl = "https://sit.api.anthem.com/v1/bills/individual";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";

		String json = "{\"mbrlkupid\":\""+args[0]+"\",\"mbrlkupidtypcd\":\"S\",\"startDt\":\"\",\"enddt\":\"\",\"sourcesystemid\":\"STAR\",\"subgroupid\":\"1GB800\"}";

		System.out.println("Json: "+json);
		parser = api.Posturl(siturl, "apikey", apikey, json);
		System.out.println("Parser: "+parser);
		
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}

		return true;

	}


	public boolean validatememberInfo(String[] args) throws IOException, InterruptedException {
	//	this.getMemberLookUpID();
		/*boolean returnflag = true;
		Event e;
		String[] keyvalue = args[0].split(":");
		while (parser.hasNext()) {
			e = parser.next();
			if (e == Event.KEY_NAME && parser.getString().equals("memberInfo")) {
				System.out.println("First: "+parser.getString()+"Key Matches");
				blogger.loginfo("First: "+parser.getString()+"Key Matches");
				parser.next();
				while (!(parser.next() == Event.END_OBJECT)) {
					for (String iterator : args) {
						if (!returnflag) {
							return false;
						}
						e = parser.next();
						String key = iterator.substring(0, iterator.indexOf(":"));
						String value = iterator.substring(iterator.indexOf(":") + 1);
						System.out.println("key: "+key+" "+"value:" + value);
						blogger.loginfo("key" + key + "value " + value);
						
						if (parser.getString().equals(key))
						parser.next();
						if (parser.getString().replace(",", "").equals(value)) {
							returnflag = true;
						} else {
							returnflag = false;
						}
					}
					if (returnflag) {
						System.out.println("API Verification Passed for the Member Info");
						blogger.loginfo("API Verification Passed for the Member Info");
						return true;
					} else {
						System.out.println("API Verification Failed for the Member Info");
						blogger.loginfo("API Verification Failed for the Member Info");
						return false;
					}
				}
			}
		}
		return returnflag;
		
*/	
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("memberInfo")){
				parser.next();
				for(String arg:args) {
					parser.next();
					if(e!=Event.END_OBJECT) {
						System.out.println(parser.getString());
						if(parser.getString().equals(arg)) {
							System.out.println("Response: "+parser.getString()+" Input: "+arg);
							blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
							parser.next();
						}else {
							blogger.loginfo("Values Mismatch: "+arg);
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

	
	
	public boolean validateBillsDetails(String[] args) throws IOException, InterruptedException {
		/*//	this.getMemberLookUpID();
			boolean returnflag = true;
			Event e;
			//String[] keyvalue = args[0].split(":");
			while (parser.hasNext()) {
				e = parser.next();
				if (e == Event.KEY_NAME && parser.getString().equals("duesDetails")) {
					System.out.println("First: "+parser.getString()+"Key Matches");
					blogger.loginfo("First: "+parser.getString()+"Key Matches");
					parser.next();
					while (!(parser.next() == Event.END_OBJECT)) {
						for (String iterator : args) {
							if (!returnflag) {
								return false;
							}
							e = parser.next();
							String key = iterator.substring(0, iterator.indexOf(":"));
							String value = iterator.substring(iterator.indexOf(":") + 1);
							System.out.println("key: "+key+" "+"value:" + value);
							blogger.loginfo("key" + key + "value " + value);					
							if (parser.getString().equals(key))
							parser.next();
							if (parser.getString().replace(",", "").equals(value)) {
								returnflag = true;
							} else {
								returnflag = false;
							}
						}
						if (returnflag) {
							System.out.println("API Verification Passed for the Bills Info");
							blogger.loginfo("API Verification Passed for the Bills Info");
							return true;
						} else {
							System.out.println("API Verification Failed for the Bills Info");
							blogger.loginfo("API Verification Failed for the Bills Info");
							return false;
						}
					}
				}
			}
			return returnflag;*/
			
			Boolean flag = true;
			while(parser.hasNext()){
				Event e=parser.next();
				if(e==Event.KEY_NAME && parser.getString().equals("duesDetails")){
					parser.next();
					for(String arg:args) {
						parser.next();
						if(e!=Event.END_OBJECT) {
							System.out.println(parser.getString());
							if(parser.getString().equals(arg)) {
								System.out.println("Response: "+parser.getString()+" Input: "+arg);
								blogger.loginfo("Response: "+parser.getString()+" Input: "+arg);
								parser.next();
							}else {
								blogger.loginfo("Values Mismatch: "+arg);
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
