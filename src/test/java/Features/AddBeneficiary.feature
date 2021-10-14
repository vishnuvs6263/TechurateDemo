Feature: Login into coporate banking and add beneficiary
Scenario: Login into the application and create beneficiary for account transfers
Given User is on the landing page
|http://41.215.180.245:8085/CorporateBanking/#/landing|
When User login into the application with username password and OTP
|dnmrinti |Test@123|1234|Naga Mohana|
Then Navigate to accounts module and add beneficiary
|Demo Beneficiary User|1234|
