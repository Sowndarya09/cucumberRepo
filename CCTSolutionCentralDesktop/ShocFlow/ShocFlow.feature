Feature: Validate that the Process Claim image along with SHOC Flow

	#Validate that the Process Claim image along with SHOC Flow
	@ShocFlow 
	Scenario Outline: Validate that the Process Claim image 
				And Select Interaction, Set NPI and search, select first/given provider from list and submit then Add Task. For Member verification set Member ID and search,select first/given member from list and submit, select first/given contract displayed using data (<Select any Interaction>;<Provider Details>;<Member Details>;<Select Task>)...PreCondition:navigateToTaskFunctionalitiesForProviderFlow
				And  This functionality navigates to the SearchClaimsImage page by clicking other actions button  and the SearchClaimsImage button...ProviderManageClaims:navigatetoSearchClaimsImage
				And Enters the DCN in the Search for Image Page using data (<DCN Number>)...ProviderSearchforImage:enterDCNAndSearch
				And Selects the first Claim Image Record and Submit...ProviderSearchforImage:tagFirstClaimImageAndSubmit
				And  This functionality navigates to the Process Claim Image page by clicking other actions button  and the Process Claim Image button...ProviderManageClaimReview:navigatetoProcessClaimImage
				And This functionality Selects the Requested action options from the dropdown using data (<requested Action>)...ProviderProcessClaimImage:requestedAction
				And Clicks yes in the Records Provide to Anthem...ProviderProcessClaimImage:clickYesInProvideRecordsToAnthem
				And Enters Provider Details and Processing Details using data (<Provider and Processing Details>)...ProviderProcessClaimImage:enterProviderNProcessingDetails
				And Selects all the  the options from the Verify Claim Image Page...ProviderProcessClaimImage:selectAllOptions
				And Clicks on Automate Button...ProviderProcessClaimImage:clickAutomate
				And This functionality fetched the SR from the Recent work list table...Home:fetchSRFromRecentWorklist
				And Search SR in Case Search...Header:searchSRInCaseSearchUsingFetchSR
				And Validate Activity Log using data (<Activity Log details>)...ReviewServiceRequest:validateActiveLogTable
				And Click on Reference Number Link...ReviewServiceRequest:clickOnReferenceNumberLink
				And Get All Service Request Details...ReviewServiceRequest:getProvideProcessingDetails
				And Launch Exela Application and Login using data (<username>,<password>,<System Location>)...ExelaApplication:launchExelaAndLogin
				And Click on Upload Link...ExelaApplication:clickUploadLink
				And Select Document Type, Enter CoverSheet Information and Clicks Submit...ExelaApplication:enterCoverSheetInfoFromServiceReqDetails
				 
				Examples: 
				|Select any Interaction|Provider Details|Member Details|Select Task|DCN Number|requested Action|Provider and Processing Details|Activity Log details|username|password|System Location|
				|Phone|NPI:1234567893/State:GA|MemberID:087T60439|Manage Claims|123456789|Submit Direct Claim|Rendering Provider Name:Sownd,Rendering Provider NPI:1234567893,Received Date:12/11/2018,Processing System:California,Date of Service:12/11/2018,Total Charges:12|Activity:RobotProcessWB - Process Claim Image|PANDY.GOKUL@ANTHEM.COM|Robotics123$$|Wellpoint West|
	