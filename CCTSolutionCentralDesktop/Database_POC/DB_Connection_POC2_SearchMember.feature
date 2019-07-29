Feature: TS_DB Connection

@DB
Scenario: TS_DB Connection

And Login to the application...LogIn:logIn
And Create a research Interaction...Header:createNewInteractionResearchmember
And Search using HCID fetched from Database...ResearchMember:searchbyMemberIDUsingDB

