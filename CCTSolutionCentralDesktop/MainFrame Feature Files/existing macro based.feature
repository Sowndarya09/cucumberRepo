Feature: MF
	@macro
	Scenario Outline: MF
	Given login to application using data (<username>,<password>)...MF_Login:loginToWebApplication
	And navigate inside mainframe using data (<region>,<username_1>,<password_1>)...MF_Login:enterLoginCredForMainFrame
	And Select macro using data (<macro>)...MF_SessionManager:runMacro
	
	Examples:
	|username|password|region|username_1|password_1|macro|
	|af72532|sownd$11|l tpxc|af63207|domain@1|Claims Inquiry|
		