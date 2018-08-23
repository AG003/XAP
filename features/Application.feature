Feature: Test Xavient application
  
  Scenario: Test login with valid credentials
    Given open chrome and start application
    When enter valid "uname"
    And enter valid password
    Then user should login successfully
    And skip your contribution
    And logout successfully
   
   
