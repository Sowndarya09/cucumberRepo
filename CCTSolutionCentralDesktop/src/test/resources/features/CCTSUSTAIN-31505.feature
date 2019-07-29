@CCTSUSTAIN-45197
Feature: Wave Initiative 606 - Chips, Facets and CS90 Migrations Needs
	#For members who are migrated to WGS from legacy Chips, Facets and CS90 mainframes and serviced by Anthem CSRs, Solution Central will provide the ability for the CSR to fully service the member  and  perform any tasks within the desktop which are available for LG WGS membership. (note: The CSR will be able to identify that the member is a migrated member and will swivel to the legacy processes and desktop to complete any tasks pre-migration.)

	#Validate the details available at automatic withdrawl section  in the review billing information page
	@CCTSUSTAIN-31505 @CCTSUSTAIN-55085 @CCTSUSTAIN-31776 @CCTSUSTAIN-55938 @Billing @SolutionCentral-RegressionSuite
	Scenario Outline: To check the test case TC_Billing_Fn_3.feature
		Given Login using the credentials in the feature file using data (<username>,<password>)...LogIn:logIn 
	  Given Select Interaction, search for a member, select first member from list and submit then select first contract displayed using data (<Select any Interaction>;<Provide Details>)...PreCondition:navigateToMemberCompositeTabFunctionalities 
		And I would like to navigate manage billing...MemberComposite:navigateTOManageBilling
		And I would like to select...ManageBilling:selectcheckboxBillingInfo
		And I would like to validate using the data (<data4>)...ManageBilling:validateAutomaticWithdrawalSection
		And I would like to submit...ManageBilling:clickOnSubmit
		And I would like to...CompleteBillingReview:completeBillingReviewandSubmitDidNotUnderStandBill
		Then the testcase is passed
		
		@SIT @UAT
			Examples: 
				| username | password | Select any Interaction    |Provide Details| data4    | 
				| WAWID201 | 123456   | Phone|MemberID:381T60371/MemberFirstName:TERRENCE | Start Date:12/10/2014 | 