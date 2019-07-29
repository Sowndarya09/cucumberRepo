Feature: TS_APIAutomation

@Eligibility @API
Scenario Outline: TS_APIAutomation

And select using data (<MemberUID>)...API_eligibility:getEligibility
And select using data (<RaceCode>)...API_eligibility:validateRaceCode

Examples:
|MemberUID|RaceCode|
|655t60504,MART|code,name,description|
