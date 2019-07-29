Feature: TS_APIAutomation

@Accum_Benefit_Names @API
Scenario Outline: TS_APIAutomation

And gets the memberLookUpID using data (<contractcode>)...API_AccumBenefitNames:getAccumsDetails
And select using data (<CostShares>)...API_AccumBenefitNames:validateCostShares
Examples:
|contractcode|CostShares|
|0SDK|coverageLevel,networkParticipation,desc,type|
