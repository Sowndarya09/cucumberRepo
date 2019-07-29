Feature: MF
	@mf1
	Scenario: MF
	Given login to application...MF_ReflectionLogin:logIn
	And navigate inside mainframe...MF_Login:login
	And i enter...MF_SessionManager:getText
	And Disconnect Mainframe...MF_ReflectionHeader:disconnectSession

#	And Enter Test region using data (<testregion>)...MF_SessionManager:enterTestRegion
#	And Enter break statement and navigate to the LOB using data (<LOB>)...MF_SessionManager:enterGroupID
#	And Navigate to Address Update Page using data (<GenCorpProfileOption>)...MF_GenCorpProfile:enterProfileOption
#	And I get invisible element...MF_GenCorpProfile:getText
#	And Navigate to Address Update Page using data (<MemEnqOption>)...MF_MemberEnquiry:enterProfileOption
#	And Navigate to Address Update Page using data (<MemEnqOption_1>)...MF_MemberEnquiry:enterProfileOption
#	And Navigate to Address Update Page using data (<MemberID>)...MF_MemberAddressEnquiry:enterMemberID
#	And Validate the Address...MF_MemberAddressEnquiry using data (<Address>)...MF_MemberAddressEnquiry:validateAddress
#	And Disconnect Mainframe...MF_ReflectionHeader:disconnectSession
#	
#	Examples:
#	|testregion|LOB|GenCorpProfileOption|MemEnqOption|MemEnqOption_1|MemberID|Address|
#	|IMSW|gencorp c|KK|M2|AI|N00479526|In Care Of:ONA 123,Address:9470323 DO|
		