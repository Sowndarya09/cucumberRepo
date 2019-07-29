Feature: TS_APIAutomation

@Claims @API
Scenario Outline: TS_APIAutomation

And select using data (<ClaimNumber>)...API_Claims:getClaims
And select using data (<PlanNetworkDetails>)...API_Claims:validatePlanNetworkInd

Examples:
|ClaimNumber|PlanNetworkDetails|
|999|code,shortDesc,longDesc|
