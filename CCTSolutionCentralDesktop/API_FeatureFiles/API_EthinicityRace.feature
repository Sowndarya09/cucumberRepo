Feature: TS_APIAutomation

@EthinicityRace @API
Scenario Outline: TS_APIAutomation

And select using data (<MemberID>,<Firstname>,<code>,<name>)...API_EthinicityRace:getEthinicityRace
And select using data (<EthinicityRaceValues>)...API_EthinicityRace:validateEthinicityRace

Examples:
|MemberID|Firstname|code|name|EthinicityRaceValues|
|655t60504|MORT|10041|AMERICAN INDIAN|code,name,description|
