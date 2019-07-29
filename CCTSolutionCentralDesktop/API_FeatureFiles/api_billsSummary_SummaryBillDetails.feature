Feature: TS_APIAutomation

@summary_SummaryBillsDetails @API
Scenario Outline: TS_APIAutomation

And gets the memberLookUpID using data (<summaryId>)...API_BillsSummary:getSummaryGroupID
And select using data (<billdetails>)...API_BillsSummary:validateSummaryBillsDetails

Examples:
|summaryId|billdetails|
|762611|stateBusinessCd,mbuCd,billFreqCd|

