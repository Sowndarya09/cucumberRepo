package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.apache.commons.collections.CollectionUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import utils.APIUtils;
import utils.BaseLogger;
import utils.Utilities;

public class API_EventValidation {

	static JsonParser parser;
	static JsonParser parser1;
	APIUtils api = new APIUtils();
	Utilities utils = new Utilities();

	public boolean getDetails(String[] arg) throws IOException, InterruptedException {
		String url1 = arg[0];
		String url2 = arg[1];
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD"; 
		parser = api.getUrl(url1, "apikey", apikey);
		parser1 = api.getUrl(url2, "apikey", apikey);
		return  utils.validateKeys(parser, parser1);
	}

	public boolean postDetails(String[] arg) {
		String siturl1 = arg[0];
		String siturl2 = arg[1];
		String json1 = arg[2];
		String json2 = arg[3];
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD"; 
		parser = api.Posturl(siturl1, "apikey", apikey, json1);
		parser1 = api.Posturl(siturl2, "apikey", apikey, json2);
		return  utils.validateKeys(parser, parser1);
	}

	//static BaseLogger blogger=new BaseLogger();

	/*public static void main(String[] args) throws IOException, InterruptedException {
		getProviderTaxID();
		getProviderTaxID1();
		//validateKeys();
		//validateKeysAndValues();
	}*/

	/*public static boolean getProviderTaxID() throws IOException, InterruptedException {

		String siturl = "https://uat.api.anthem.com/v2/pegadesktop/members/eligibility?mbruid=FBD058F906030BA9F87D300793DB2630";
		//String siturl = "https://uat.api.anthem.com//v2/pegadesktop/members/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";

		String json = "{\"mbrLookupId\":\"655t60504\"} ";

		//parser = api.Posturl(siturl, "apikey", apikey, json);
		parser = api.getUrl(siturl, "apikey", apikey);

		return true;

	}*/
	/*
	public static boolean getProviderTaxID1() throws IOException, InterruptedException {

		String siturl = "https://uat.api.anthem.com/v2/pegadesktop/members/eligibility?mbruid=FBD058F906030BA9F87D300793DB2630";
		//String siturl = "https://uat.api.anthem.com//v2/pegadesktop/members/search";
		String apikey = "QAPHtp06TOrFu4Odge3VkXOLeXDz9wXD";

		String json = "{\"mbrLookupId\":\"123456789\"} ";

		//parser1 = api.Posturl(siturl, "apikey", apikey, json);
		parser1 = api.getUrl(siturl, "apikey", apikey);
		return true;

	}*/

	/*public static boolean validateEvent() throws IOException, InterruptedException {
		Event e ;
		Event e1;
		List<String> ls = new ArrayList<String>();
		List<String> ls2 = new ArrayList<String>();
		List<String> ls3;


		String key = "",temp="",key1="";
		while (parser.hasNext() )
		{
			e = parser.next();

			if (e == Event.KEY_NAME ) 
			{
				key =parser.getString();
				if (!temp.isEmpty())
				{
					ls2.add(temp+"_"+key);
				}
				else
				{
					ls2.add(key);

				}
			}
			if(e == Event.START_OBJECT) 
			{
				temp=key;
			}
			if(e == Event.END_OBJECT)
			{
				temp="";
			}

		}

		while (parser1.hasNext() )
		{
			e = parser1.next();

			if (e == Event.KEY_NAME ) 
			{
				key1 =parser1.getString();
				if (!temp.isEmpty())
				{
					ls.add(temp+"_"+key1);
				}
				else
				{
					ls.add(key1);

				}
			}
			if(e == Event.START_OBJECT) 
			{
				temp=key1;
			}
			if(e == Event.END_OBJECT)
			{
				temp="";
			}

		}

		System.out.println("####################");
		System.out.println("parser1 values"+ls.size());
		System.out.println("parser1 values"+ls2.size());
		System.out.println("####################");

		if (ls.equals(ls2)) 
			ls3 = new ArrayList<String>(CollectionUtils.subtract(ls2, ls));
		else if (ls.size()<ls2.size())
			ls3 = new ArrayList<String>(CollectionUtils.subtract(ls2, ls));
		else
			ls3 = new ArrayList<String>(CollectionUtils.subtract(ls, ls2));

		System.out.println(ls3);
		blogger.loginfo("Differences are: "+ls3);
		return true;
	}


	public static boolean validateKeys(JsonParser parser, JsonParser parser1) {
		Boolean flag = true;
		Event e ;
		Event e1;
		while (parser.hasNext() || parser1.hasNext()) {
			e = parser.next();
			e1 = parser1.next();
			if (e == Event.KEY_NAME) {
				if(parser.getString().equals(parser1.getString())) {
					System.out.println("First:"+parser.getString()+"Second:"+parser1.getString());
					blogger.loginfo("First:"+parser.getString()+"Second:"+parser1.getString());
				}else {
					System.out.println("First:"+parser.getString()+"Second:"+parser1.getString()+"No MATCH");
					blogger.loginfo("First:"+parser.getString()+"Second:"+parser1.getString()+"No MATCH");
					flag = false;
					parser1.next();
				}
			}
		}
		return flag;
	}

	public boolean validateKeysAndValues(JsonParser parser, JsonParser parser1){
		Boolean flag = true;
		Event e ;
		Event e1;
		while (parser.hasNext() || parser1.hasNext()) {
			e = parser.next();
			e1 = parser1.next();
			if (e == Event.KEY_NAME && e1 == Event.KEY_NAME) {
				if(parser.getString().equals(parser1.getString()))
				{
					System.out.println("First: "+parser.getString()+" Second: "+parser1.getString()+"Key Matches");
					blogger.loginfo("First: "+parser.getString()+" Second: "+parser1.getString()+"Key Matches");
					e = parser.next();
					e1 = parser1.next();
					if(e == Event.VALUE_STRING && e1 == Event.VALUE_STRING)
					{
						if(parser.getString().equals(parser1.getString()))
						{
							System.out.println("First: "+parser.getString()+" Second: "+parser1.getString()+" Values Matches");
							blogger.loginfo("First: "+parser.getString()+" Second: "+parser1.getString()+" Values Matches");
						}
						else
						{
							System.out.println("First:"+parser.getString()+"Second:"+parser1.getString()+"Values Does Not MATCH");
							blogger.loginfo("First:"+parser.getString()+"Second:"+parser1.getString()+"Values Does Not MATCH");
							flag = false;
						}

					}
				}

				else {
					System.out.println("First:"+parser.getString()+"Second:"+parser1.getString()+"Key Does Not MATCH");
					blogger.loginfo("First:"+parser.getString()+"Second:"+parser1.getString()+"Key Does Not MATCH");
					flag = false;
					parser1.next();
				}
			}
		}


		return flag;		
	}*/


}
