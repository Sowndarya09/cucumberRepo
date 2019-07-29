package utils;

import java.util.ArrayList;
import java.util.List;

import org.seleniumhq.jetty9.server.session.DatabaseAdaptor;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import MongoDB.MongoDBConnectionManager;

public class MongoTrial {
	
	
	public static void main(String[] args){
		
		MongoClient mongoclient= null;
		DB database = null;
		DBCollection collection =null;
		DBObject testStatus,Build = null;
		
		MongoDBConnectionManager conn = new MongoDBConnectionManager();
		mongoclient = MongoDBConnectionManager.getMongoCleint();
		//database=conn.getDB(mongoclient,"teststatus");
		collection = conn.getCollection("Build_Status","Build_Status");
		List<DBObject> builds = new ArrayList<>();
		List<DBObject> tests = new ArrayList<>();		
		
		testStatus = new BasicDBObject("test_id","CCTSUSTAIN-1234")
										.append("Status","Running")
										.append("build_Number", "1234")
										.append("report","location");
		/*tests.add(testStatus);
		
		testStatus = new BasicDBObject("_id","CCTSUSTAIN-1234")
				.append("Status","Running");
		tests.add(testStatus);
		testStatus.put("Status","Pass");
	
		
		Build= new BasicDBObject("_id","1234").append("tests", tests);
		builds.add(Build);
		Build=Build= new BasicDBObject("_id","3456").append("tests", tests);
		builds.add(Build);*/
		//List<Integer> books = Arrays.asList(27464, 747854);
		
		
		//DBObject query = new BasicDBObject("test	_id", "CCTSUSTAIN-1234");
		                            
		//testStatus=cursor.curr();
		//collection.insert(testStatus);
		
		DBCursor cursor = collection.find(new BasicDBObject("tests._id","CCTSUSTAIN-1234"));
		collection.update(new BasicDBObject("test_id","CCTSUSTAIN-1234"),  new BasicDBObject("$set", new BasicDBObject("Status", "Fail")));
		System.out.println(collection.findOne());
	//collection.insert(builds)	;
	conn.closeMongoClient();
		                          
	}
	

}
