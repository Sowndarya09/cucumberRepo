Feature: TS_APIAutomation

@summary_MemberData @API
Scenario Outline: TS_APIAutomation

And gets the memberLookUpID using data (<summaryId>)...API_BillsSummary:getSummaryGroupID
And select using data (<memData>)...API_BillsSummary:validateMemberData

Examples:
|summaryId|memData|
|762611|summaryGroupId,sourceSystemId,mamTotalAmtDue|

