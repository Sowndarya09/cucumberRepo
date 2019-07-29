Feature: TS_APIAutomation

@DigitalCards @API
Scenario Outline: TS_APIAutomation

And select using data (<HCID>,<SourceSysID>,<Firstname>,<Lastname>)...API_DigitalCards:getDigitalCards
And select using data (<DigitalCardDetails>)...API_DigitalCards:validateAcknowledgementStatus

Examples:
|HCID|SourceSysID|Firstname|Lastname|DigitalCardDetails|
|000A40245|WGS20|BENNETT|SVRCEK|code,name,description|
