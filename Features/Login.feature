Feature: Validation of login functionality
@tag1
Scenario: Login functionality validation1
When I login into stockAccounting Url on Chrome Browser
When I click Reset Button on Login Page
And I enter admin and master in UserNameField and PasswordField
When I click on Login Button
When I wait for LogoutLink
Then I validate the title of the home Page and close the Browser

@tag2
Scenario Outline: Login functionality validation2
When I login into stockAccounting Url on "<browser>"
When I click Reset Button on Login Page
And I enter "<username>" and "<password>"
When I click on Login Button
When I wait for LogoutLink
Then I validate the title of the home Page and close the Browser

Examples:

|browser|username|password|
|chrome|admin|master|
|chrome|admin|master|
|chrome|admin|master|
