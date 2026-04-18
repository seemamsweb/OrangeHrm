Feature: OrangeHRM Login Testing using Excel Data

  Scenario: Login test with Excel data
    Given user is on OrangeHRM login page
    When user login using Excel sheet data
    Then login results should be validated