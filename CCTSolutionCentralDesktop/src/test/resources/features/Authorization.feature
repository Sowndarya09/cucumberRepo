Feature: Authorization Details 

@Authorisation @CCTSUSTAIN-31776
Scenario Outline: Authorization Details 
	Given This functionality logins to the Solution Central Application with given username and password using data (<username>,<password>)...LogIn:logIn 
	And Select Interaction, search for a member, select first/given member from list and submit then select first/given contract displayed and navigate to task mentioned using data (<Select any Interaction>;<Select Task>;<Provide Details>)...PreCondition:navigateToTaskFunctionalities 
	And This functionality clicks on the Authorization number in the View Authorization page using data (<Authorization Number>)...ViewAuthorizations:clickonAuthorizationNumber 
	And This functionality validates the View Authorization General Information in the View  Authorization Details section using data (<ViewAuthorizationGeneralDetails>)...ViewAuthorizationDetails:verifyViewAuthorizationDetailsInfo 
	And This clicks on the Authorization Details tab in the View Authorization Details page...ViewAuthorizationDetails:clickAuthorizationDetails 
	
	
	@SIT @UAT
	Examples: 
		|username|password|Select any Interaction|Select Task|Provide Details|Authorization Number|ViewAuthorizationGeneralDetails|
		|WAWID201|123456|Research|Manage Authorizations|MemberID:700A07636,MemberFirstName:Vinson|0320030682|Authorization Number:0320030682,Status Date:12/21/2018,Service Provider Location:Cleveland Clinic Transplant,Authorization Type:INPATIENT,Pre Auth Type:Medical,Status:Certified in Total,Status Date:12/21/2018,Patient Name:VINSON DAVID,Patient DOB:01/01/1970,Contract Code:1210|         
