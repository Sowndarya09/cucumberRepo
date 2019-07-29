Feature: TS_APIAutomation

@Contacts @API
Scenario Outline: TS_Automation

And select using data (<MemberID>,<Firstname>)...API_Contacts:getContacts
And select using data (<Phone Type>)...API_Contacts:validatePhoneType

Examples:
|MemberID|Firstname|Phone Type|
|655t60504|MORT|code,name,description|
