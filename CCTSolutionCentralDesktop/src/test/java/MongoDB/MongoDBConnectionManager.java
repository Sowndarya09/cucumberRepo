package MongoDB;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnectionManager {
	
	static MongoClient mongoClient =new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	public static MongoClient getMongoCleint(){
	//MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	return mongoClient;
	}
	
	public void setMongoCleint(){
		mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
		}
	public static void closeMongoClient(){
		mongoClient.close();
	}
	
	public DB getDB(String dbName){
		
		@SuppressWarnings("deprecation")
		DB database = MongoDBConnectionManager.getMongoCleint().getDB(dbName);
		
		return database;
	}
	
	

	public static DBCollection getCollection(String database,String collectionname) {
		DBCollection collection = getMongoCleint().getDB(database).getCollection(collectionname);
		return collection;
	}

	
	
	
	
}
