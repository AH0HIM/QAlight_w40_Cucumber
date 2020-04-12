Feature: github login

  @q
  Scenario: login with  username and password in table
    Given user is on github homepage
    When user login to site
      | Login     | Password |
      | Lena      | pass     |
    Then user is displayed login screen


  @q
  Scenario: 2222ogin without username and password
    Given user is on github homepage
    When user input login login to the login field
    When user input password password to the login field
    When user clicks on Sign in button
    Then user is displayed login screen



  Scenario: 2111ogin without username and password
    Given user is on github homepage
    When user clicks on Sign in button
    Then user is displayed login screen

  @ignore
  Scenario: 2333ogin without username and password
    Given user is on github homepage
    When user clicks on Sign in button
    Then user is displayed login screen