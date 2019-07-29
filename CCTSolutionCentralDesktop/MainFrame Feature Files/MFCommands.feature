@CCTSUSTAIN-61849
Feature: To validate the table headers for the previous cliams adjustment grid on the view claim details page
Scenario Outline: TS_Automation_Jan2019_6.4_58600_AdjustmentSRsMember_01

Given login into the mainframe using data (<args>)...MF_Login:loginToWebApplication
And Enters the credentials to mainframe using data (<cred>)...MF_Login:enterCommandForMainFrame
And clicks F1 key...MF_Commands:pressF1KeyInMF
And clicks F3 key...MF_Commands:pressF3KeyInMF
And clicks F1 key...MF_Commands:pressF1KeyInMF
And clicks F4 key...MF_Commands:pressF4KeyInMF
#And clicks F3 key...MF_Commands:pressF3KeyForLogOffInMF
And clicks F1 key...MF_Commands:pressF1KeyInMF
And clicks F8 key...MF_Commands:pressF8KeyInMF
And clicks F7 key...MF_Commands:pressF7KeyInMF
And clicks F10 key...MF_Commands:pressF10KeyInMF
And clicks F11 key...MF_Commands:pressF11KeyInMF
And clicks F3 key...MF_Commands:pressF3KeyInMF



Examples: 
|args|cred|	
|af56975,Winter@123,web-CA|l tpxc|
