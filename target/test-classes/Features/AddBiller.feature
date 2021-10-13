Feature: Login into coporate banking login, add biller and beneficiary
Scenario: Verify the dashboard page
Given User is on the landing page
|http://41.215.180.245:8085/CorporateBanking/#/landing|
When User login into the application with username password and OTP
|dnmrinti |Test@123|1234|Naga Mohana|
Then Navigate to payments module and add biller
Then user is able to add beneficiary
