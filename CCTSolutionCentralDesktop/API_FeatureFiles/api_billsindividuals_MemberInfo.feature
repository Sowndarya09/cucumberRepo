Feature: TS_APIAutomation

@bills_memberInfo @API
Scenario Outline: TS_APIAutomation

And gets the memberLookUpID using data (<lookUpId>)...API_BillsIndividuals:getMemberLookUpID
And select using data (<bills>)...API_BillsIndividuals:validatememberInfo


Examples:
|lookUpId|bills|
|005M59059|certNbr,hcId|
