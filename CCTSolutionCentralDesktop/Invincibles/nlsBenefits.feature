@CCTSUSTAIN-75517 @test123
Feature: Benefits and cost NLS benefits individual and largeGroup

Scenario Outline: TS_Automation_NLS Benefits

Given logins to the Solution Central Application with given username and password using data (<username>,<password>)...LogIn:logIn
And Select Interaction, search for a member, select first/given member from list and submit then select first/given contract displayed and navigate to task mentioned using data (<Select any Interaction>;<Select Task>;<Provide Details>)...PreCondition:navigateToTaskFunctionalities
And Search Benefit using data (<SearchBenefit>,<reasonRequest>,<Notes>)...BenefitsSelection:benfitDetailVerification
And verify the Interaction Log...BenefitsSelection:benfitDetailIntLogVerification
@majorsit
Examples:
|username|password|Select any Interaction|Select Task      |Provide Details                         |SearchBenefit|reasonRequest               |Notes|
|Af47718|Vinnu@20 |Research              |Benefits and Cost|MemberID:405T65239/MemberFirstName:CLORA|Ambulance    |Request Benefit Verification|testNotes|
|Af47718|Vinnu@20 |Research              |Benefits and Cost|MemberID:894T92607/MemberFirstName:	GANESH|Ambulance  |Request Benefit Verification|testNotes|
