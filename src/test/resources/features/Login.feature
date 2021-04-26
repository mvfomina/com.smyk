Feature: login
  As a: customer
  I want: to be able to login with correct credentials only
  So that: I can login to the site

  Scenario: Try to login without inserting email and password
    Given Customer is on login page
    When Customer proceed with login with empty email and password
    Then Customer isn't able to login

  Scenario Outline: Try to login with incorrect email and password
    Given Customer is on login page
    When Customer proceed with login with incorrect '<email>' and '<password>'
    Then Customer isn't able to login with incorrect credentials
    Examples:
      | email               | password |
      | gkig@fff.com        | sdf      |
      | aht.test0@gmail.com | sdgsdg   |

  Scenario Outline: Login with correct credentials
    Given Customer is on login page
    When Customer proceed with login with correct '<email>' and '<password>'
    Then Customer is able to login
    Examples:
      | email               | password        |
      | aht.test0@gmail.com | Qwerty123456!   |

