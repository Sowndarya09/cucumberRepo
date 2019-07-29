Feature: MF
	@mf1
	Scenario Outline: MF
	Given login to application...MF_ReflectionLogin:logIn

	And navigate inside mainframe...MF_Login:login
	And Enter Test region using data (<testregion>)...MF_SessionManager:enterTestRegion
	And Enter break statement and navigate to the LOB using data (<LOB>)...MF_SessionManager:enterGroupID
	And Disconnect Mainframe...MF_ReflectionHeader:disconnectSession
	
	Examples:
	|testregion|LOB|
	|IMSW|gencorp c|
		