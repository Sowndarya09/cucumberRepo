Feature: TS_APIAutomation

@BillCashDetails_Entity @API
Scenario Outline: TS_APIAutomation

And gets the memberLookUpID using data (<lookUpId>)...API_BillCashDetails:getMemberLookUpID
And select using data (<Entity>)...API_BillCashDetails:validateEntityDetails
Examples:
|lookUpId|Entity|
|005M59059|memberlookupId,memberLookupIdTypeCd,totalAmount,sourceSystemId|
