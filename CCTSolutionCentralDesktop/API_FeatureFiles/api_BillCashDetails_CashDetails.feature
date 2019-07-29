Feature: TS_APIAutomation

@BillCashDetails_CashDetails @API
Scenario Outline: TS_APIAutomation

And gets the memberLookUpID using data (<lookUpId>)...API_BillCashDetails:getMemberLookUpID
And select using data (<CashDetails>)...API_BillCashDetails:validateCashDetails
Examples:
|lookUpId|CashDetails|
|005M59059|checkId,status,statusDesc,subGroup|
