Feature: Logout feature

Scenario: Verify logout function
Given Admin user is logged in with valid credentials
When Admin clicks on the logout in the menu bar
Then Admin should be redirected to login page

Scenario: Verify back button function 
Given Admin is in login page
When Admin clicks  browser back button
Then Admin should receive error message