package MongoDB;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import MongoDB.MongoDBConnectionManager;

public class TestStatus {
	
	String testID="default";
	String testStatus="Yet to Start";
	String testReport = "Not yet available";
	String buildNumber= "Default";
	public  TestStatus(String testID,String testStatus,String buildnumber){
		this.setTestID(testID);
		this.setTestStatus(testStatus);
		//this.setTestReport(testReport);
		this.setBuildNumber(buildnumber);
		this.writenewTest();;
	}
	
	public String getBuildNumber() {
		return buildNumber;
	}
	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}
	public String getTestID() {
		return testID;
	}
	public void setTestID(String testID) {
		this.testID = testID;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	public String getTestReport() {
		return testReport;
	}
	public void setTestReport(String testReport) {
		this.testReport = testReport;
	}
	List<TestStatus> classObj = new ArrayList<TestStatus>();
	public void writenewTest(){
		
		DBObject teststatus = new BasicDBObject("test_id",this.getTestID())
				.append("Status",this.getTestStatus())
				.append("build_Number",this.getBuildNumber());
				//.append("report","location");
		
		MongoDBConnectionManager.getCollection("Build_Status","Build_Status").insert(teststatus);
                }
	
public void updateTest(){
		
		DBObject teststatus = new BasicDBObject("test_id",this.getTestID())
				.append("Status",this.getTestStatus())
				.append("build_Number",this.getBuildNumber());
				//.append("report","location");
		
		//MongoDBConnectionManager.getCollection.insert(teststatus);
		
		MongoDBConnectionManager.getCollection("Build_Status","Build_Status").update(new BasicDBObject("test_id",this.getTestID()),  new BasicDBObject("$set", new BasicDBObject("Status", this.getTestStatus())));
                }
	
}                                        
