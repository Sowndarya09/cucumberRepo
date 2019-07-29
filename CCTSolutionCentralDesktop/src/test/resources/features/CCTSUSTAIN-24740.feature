Feature: This feature is for creating a member

	#Create a research member
	@CCTSUSTAIN-24740 @CCTSUSTAIN-24741 @Smoketest @CCTSUSTAIN-31766 @CCTSUSTAIN-31776
	Scenario Outline: Create Research member
		Given Login using the credentials in the feature file using data (<username>,<password>)...LogIn:logIn 
		Given Select Interaction, search for a member, select first member from list and submit then select first contract displayed using data (<Select any Interaction>;<Provide Details>)...PreCondition:navigateToMemberCompositeTabFunctionalities
		And I would like to navigate manage billing...MemberComposite:navigateTOManageBilling
		And click on submit in Manage Billing...ManageBilling:clickOnSubmit
		Then the testcase is passed
		
		@SIT @majorsit
		Examples: 
		|username|password|Select any Interaction|Provide Details|      
		|WAWID201|123456|Research| MemberID:801374653/MemberFirstName:GLEN|

		
		@CI @majorci
		Examples: 
		|username|password|Select any Interaction|Provide Details|      
		|WAWID201|123456|Research| MemberID:381T60371/MemberFirstName:TERRENCE|
		
		
		@UAT @majorstg @minorsit @minorstg @minorci
		Examples:
		|username|password|Select any Interaction|Provide Details|      
		|WAWID201|123456|Research| MemberID:381T60371/MemberFirstName:TERRENCE|
		
		@TRAIN
		Examples: 
		|username|password|Select any Interaction|Provide Details|      
		|WAWID201|123456|Research| MemberID:381T60371/MemberFirstName:TERRENCE|
		
		
		@PERF
		Examples: 
		|username|password|Select any Interaction|Provide Details|      
		|WAWID201|123456|Research| MemberID:381T60371/MemberFirstName:TERRENCE|
		
		
		@PROD
		Examples: 
		|username|password|Select any Interaction|Provide Details|      
		|WAWID201|123456|Research| MemberID:381T60371/MemberFirstName:TERRENCE|
		
	
