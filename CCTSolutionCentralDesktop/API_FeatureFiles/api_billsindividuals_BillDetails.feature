Feature: TS_APIAutomation

@bills_BillDetails @API
Scenario Outline: TS_APIAutomation

And gets the memberLookUpID using data (<lookUpId>)...API_BillsIndividuals:getMemberLookUpID
And select using data (<billdetails>)...API_BillsIndividuals:validateBillsDetails

Examples:
|lookUpId|billdetails|
|005M59059|dueDt,billStatus,billStatusDesc|
