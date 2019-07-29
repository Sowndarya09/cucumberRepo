Feature: Research Member With DB Integrated

@DBResearch
Scenario: Research Member With DB Integrated

Given Login into the application...LogIn:logIn
And Create new Research Member interaction...Header:createNewInteractionResearchmember
And Search Member using DataBase...ResearchMember:searchbyMemberIDUsingDB


