
Feature: Search functionality


Scenario: Search for a valid product
Given User opens application
When User enters product "HP" in search field
And  User clicks on search button
Then valid products should be displayed in search results


Scenario: Search for non-existing product
Given User opens application
When User enters product "Honda" in search field
And  User clicks on search button
Then Proper text informing the user about no matching products should be displayed