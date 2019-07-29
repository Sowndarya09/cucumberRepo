Feature: TS_APIAutomation

@MemberSummary @API
Scenario Outline: TS_APIAutomation

And gets the member Summary details using data (<username>)...API_MemberPortal:getMemberSummaryDetails
And validate using data (<keys>)...API_MemberPortal:validateSummaryDetails
Examples:
|username|keys|
|~SIT3SB003T92127CA|code,name,description|
