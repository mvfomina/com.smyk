Feature: basket
  As a: customer
  I want: to have basket implemented
  So that: I can add products to the basket

  Scenario: Message if basket is empty
    Given Customer is on page with url homepage - 'home.page.url'
    When Customer open basket
    Then message about empty basket is shown

  Scenario Outline: Add product to basket
    Given Customer is on page with url homepage - 'home.page.url'
    When Customer adds '<product>' to the basket
    And Customer open basket
    Then product is shown in the basket

    Examples:
    | product |
    | lego    |
    | lol     |

  Scenario Outline: Remove product from the basket
    Given Customer is on page with url homepage - 'home.page.url'
    When Customer adds '<product>' to the basket
    And Customer open basket
    And Customer remove product
    Then message about empty basket is shown

    Examples:
      | product |
      | lego    |
