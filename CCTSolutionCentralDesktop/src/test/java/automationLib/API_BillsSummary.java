package automationLib;

import java.io.IOException;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import utils.APIUtils;
import utils.BaseLogger;

public class API_BillsSummary {

	static JsonParser parser;

	APIUtils api = new APIUtils();
	
	BaseLogger blogger=new BaseLogger();

	
	public boolean getSummaryGroupID(String[] args) throws IOException, InterruptedException {

		String siturl = "https://sit.api.anthem.com/v1/bills/summary";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";

		String json = "{\"summaryGroupId\":\""+args[0]+"\",\"sourcesystemid\":\"STAR\"}";

		System.out.println("Json: "+json);
		parser = api.Posturl(siturl, "apikey", apikey, json);
		System.out.println("Parser: "+parser);
		
		if(parser==null) {
			blogger.loginfo("FAIL: Paser return's a null value");
			return false;
		}

		return true;

	}


	public boolean validateMemberData(String[] args) throws IOException, InterruptedException {/*
	//	this.getMemberLookUpID();
		boolean returnflag = true;
		Event e;
		String[] keyvalue = args[0].split(":");
		while (parser.hasNext()) {
			e = parser.next();
			if (e == Event.KEY_NAME && parser.getString().equals("memberData")) {
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
			if(e==Event.KEY_NAME && parser.getString().equals("memberData")){
				System.out.println("First: "+parser.getString()+"Key Matches");
				blogger.loginfo("First: "+parser.getString()+"Key Matches");
				parser.next();
				for(String arg:args) {
					parser.next();
					if(e!=Event.END_OBJECT) {
						//parser.next();
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
	


	public boolean validateSummaryBillsDetails(String[] args) throws IOException, InterruptedException {
	/*//	this.getMemberLookUpID();
		boolean returnflag = true;
		Event e;
		//String[] keyvalue = args[0].split(":");
		while (parser.hasNext()) {
			e = parser.next();
			//e = parser.next();
			if (e == Event.KEY_NAME && parser.getString().equals("summaryBillDetails")) {
				System.out.println("First: "+parser.getString()+"Key Matches");
				blogger.loginfo("First: "+parser.getString()+"Key Matches");
				parser.next();
				//parser.next();
				while (!(parser.next() == Event.END_OBJECT)) {
					for (String iterator : args) {
						if (!returnflag) {
							return false;
						}
						e = parser.next();
						//e = parser.next();
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
						System.out.println("API Verification Passed for the Summary Bills Info");
						blogger.loginfo("API Verification Passed for the Summary Bills Info");
						return true;
					} else {
						System.out.println("API Verification Failed for the Summary Bills Info");
						blogger.loginfo("API Verification Failed for the Summary Bills Info");
						return false;
					}
				}
			}
		}
		return returnflag;*/
		

		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("summaryBillDetails")){
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

	
	public boolean validateSummaryPaymentDetails(String[] args) throws IOException, InterruptedException {
		
		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("paymentDetails")){
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

	
	public boolean validateBillsDetails(String[] args) throws IOException, InterruptedException {
		//	this.getMemberLookUpID();
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
			return returnflag;
		}


	public boolean validatesummaryIndividualBillsInfo(String[] args)
	{

		

		Boolean flag = true;
		while(parser.hasNext()){
			Event e=parser.next();
			if(e==Event.KEY_NAME && parser.getString().equals("individualBillDetails")){
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
