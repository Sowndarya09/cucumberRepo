Feature: TS_APIAutomation

@Benefit @API
Scenario Outline: TS_Automation

And select using data (<EOCValues>)...API_getbenefitsSearch:getbenefitsSearch
And select using data (<EOCValues>)...API_getbenefitsSearch:validatebenefitEOCvalues

Examples:
|EOCValues|
|Deductible_Individual_In-Network:$7350|
