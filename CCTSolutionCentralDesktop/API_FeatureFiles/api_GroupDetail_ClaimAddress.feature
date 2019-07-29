Feature: TS_APIAutomation

@GroupDetails @API
Scenario Outline: TS_APIAutomation

And select using data (<GroupID>,<SourceSysID>,<SubscriberID>,<SubGrpID>)...API_GroupDetail:getGroupDetail
And select using data (<AccumsDetails>)...API_GroupDetail:validateClaimsAddress

Examples:
|GroupID|SourceSysID|SubscriberID|SubGrpID|AccumsDetails|
|201049|WGS20|GRB003030|201049M1A0|adrsLn1Txt,ctyNm,stCd|
