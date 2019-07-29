Feature: TS_APIAutomation

@summary_IndividualBillsInfo @API
Scenario Outline: TS_APIAutomation

And gets the memberLookUpID using data (<summaryId>)...API_BillsSummary:getSummaryGroupID
And select using data (<billdetails>)...API_BillsSummary:validatesummaryIndividualBillsInfo

Examples:
|summaryId|billdetails|
|762611|mbrlkupid,hcId,prodGroupNbr|
#prodGroupNbr|
#mbrlkupid,
