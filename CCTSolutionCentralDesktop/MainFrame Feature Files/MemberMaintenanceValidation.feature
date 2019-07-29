Feature: Change data in Member Maintenance and validate the updated data in Mainframe 
	@mf22
	Scenario Outline: Change data in Member Maintenance and validate the updated data in Mainframe
	
	Given  Select Interaction, search for a member, select first/given member from list and submit then select first/given contract displayed and navigate to task mentioned using data (<Select any Interaction>;<Select Task>;<Provide Details>)...PreCondition:navigateToTaskFunctionalities
	And Clicks on the Update Address Link...MemberMaintenance:ClicklinkUpdateAddress
	And Update the Address and Submit, then validate the success message displayed as updated successfully using data (<Update Address>)...MemberMaintenance_UpdateDemographics:updateAddressAndValidate
	
	And Launch Mainframe Application...MF_ReflectionLogin:launchMainFrameReflectionApp
	Given login to application...MF_ReflectionLogin:logIn
	And navigate inside mainframe...MF_Login:login
	And Enter Test region using data (<testregion>)...MF_SessionManager:enterTestRegion
	And Enter break statement and navigate to the LOB using data (<LOB>)...MF_SessionManager:enterGroupID
	
	And Navigate to Address Update Page using data (<GenCorpProfileOption>)...MF_GenCorpProfile:enterProfileOption
	And I get invisible element...MF_GenCorpProfile:getText
	And Navigate to Address Update Page using data (<MemEnqOption>)...MF_MemberEnquiry:enterProfileOption
	And Navigate to Address Update Page using data (<MemEnqOption_1>)...MF_MemberEnquiry:enterProfileOption
	And Navigate to Address Update Page using data (<MemberID>)...MF_MemberAddressEnquiry:enterMemberID
	And Validate the Address...MF_MemberAddressEnquiry using data (<Address>)...MF_MemberAddressEnquiry:validateAddress
	
	And Disconnect Mainframe...MF_ReflectionHeader:disconnectSession
	
	Examples:
	|Select any Interaction|Select Task|Provide Details|Update Address|testregion|LOB|GenCorpProfileOption|MemEnqOption|MemEnqOption_1|MemberID|Address|
	|Research|Member Maintenance|MemberID:N00479526|In Care Of:Careof111,Address:ADDRESS123|IMSN|gencorp c|KK|M2|AI|N00479526|In Care Of:Careof111,Address:ADDRESS123|
#	|Research|Member Maintenance|MemberID:141t60013|In Care Of:Careof111,Address:ADDRESS123|IMSN|gencorp c|KK|M2|AI|141t60013|In Care Of:Careof111,Address:ADDRESS123|
	|Research|Member Maintenance|MemberID:019T90616|In Care Of:Careof111,Address:ADDRESS123|IMSN|gencorp c|KK|M2|AI|2222228J5|In Care Of:Careof111,Address:ADDRESS123|
	|Research|Member Maintenance|MemberID:003T90407|In Care Of:Careof111,Address:ADDRESS123|IMSN|gencorp c|KK|M2|AI|238T91327|In Care Of:Careof111,Address:ADDRESS123|
	|Research|Member Maintenance|MemberID:091T90627|In Care Of:Careof111,Address:ADDRESS123|IMSN|gencorp c|KK|M2|AI|620T91314|In Care Of:Careof111,Address:ADDRESS123|
	|Research|Member Maintenance|MemberID:N00479526|In Care Of:Careof111,Address:ADDRESS123|IMSN|gencorp c|KK|M2|AI|296T95968|In Care Of:Careof111,Address:ADDRESS123|
	