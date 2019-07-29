Feature:
@MF
Scenario Outline: CCTSUSTAIN-31744.feature


Given The application is opened on the browser
When i login "logIn" on "MF_ReflectionLogin" page
When i do "login" on the "MF_Login" page
#When I call the "disconnectSession" method with on the "MF_Login" page


	
@SIT @UAT
Examples: 
		
|username|password|data1|data2|keyvaluepair1|data3| 
		
|WAWID202|123456|816A40378|LEONARDA|startdate:01012015,enddate:12312015|memberno:11111111| 