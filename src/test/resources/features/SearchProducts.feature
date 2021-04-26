Feature: product search
  As a: customer
  I want: to have product search
  So that: I can find required product

  Scenario Outline: Search when any product isn't found
    Given Customer is on page with url homepage 'home.page.url'
    When Customer performs search for '<searched item>'
    Then any product isn't found
    And Page title contains this

    Examples:
    |     searched item       |
    | dr dy dydxfy dxy xdy dx |
    | stswe ewt ww4e tywer ty |

  Scenario Outline: Search when product is found
    Given Customer is on page with url homepage 'home.page.url'
    When Customer performs search for '<searched item>'
    Then product is found

    Examples:
      | searched item |
      | lego          |
      | LOL           |

