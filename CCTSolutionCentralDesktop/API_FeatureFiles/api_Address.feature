Feature: TS_APIAutomation

@Address @API
Scenario Outline: TS_APIAutomation

And select using data (<MemberUID>)...API_Address:getAddress
And select using data (<AddressTypeCode>)...API_Address:validateAddressTypeCd

Examples:
|MemberUID|AddressTypeCode|
|655t60504,MART|code,name,description|
