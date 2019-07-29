Feature: TS_APIAutomation

@Accums @API
Scenario Outline: TS_APIAutomation

And select using data (<MemberCode>,<PlanType>,<HCID>,<ContractCode>,<SourceSystem>,<GroupID>,<StartDate>,<EndDate>)...API_Accumulators:getAccums
And select using data (<AccumsDetails>)...API_Accumulators:validateAccums

Examples:
|MemberCode|PlanType|HCID|ContractCode|SourceSystem|GroupID|StartDate|EndDate|AccumsDetails|
|10|MED|820A40406|1GV0|STAR|IN|2015-01-01|2015-12-31|benefitValue,accumulated,remaining,startDt,endDt,unit,period,benefits|
