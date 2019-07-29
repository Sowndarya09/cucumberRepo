Feature: 

	
	@CCTSUSTAIN-31504 @CCTSUSTAIN-39020 @CCTSUSTAIN-31776 @Billing @SolutionCentral-RegressionSuite @node2 @parallel
	Scenario Outline: Test case creates Mange billing task and navigates to RequestEnrollment and check values in ReasonforContract in the RequestEnrollmentandBillingAction page 
		Given The application is opened on the browser
		When I call the "logIn" method with data (<username>,<password>) on the "LogIn" page
		And I call the "createNewInteractionResearchmember" method on the "Header" page
		And I call the "searchbyMemberID" method with data (<data1>) on the "ResearchMember" page
		And I call the "selectMemberbyFirstName" method with data (<data2>) on the "ResearchMember" page
		And I call the "selectSubmit" method on the "ResearchMember" page
		And I call the "selectfirstContract" method on the "SelectContract" page
		And I call the "navigateTOManageBilling" method on the "MemberComposite" page
		And I call the "clickOnSubmit" method on the "ManageBilling" page
		And I call the "navigatetoRequestEnrollment" method on the "CompleteBillingReview" page
		And I call the "BillingApplyInitialPaymentsUrgent" method on the "RequestEnrollmentandBillingAction" page
		Then the testcase is passed
		
			@SIT @UAT
			Examples: 
				| username | password | data1     | data2    | data3                   | 
				| WAWID201 | 123456   | 381T60371 | TERRENCE | Did not understand bill | 