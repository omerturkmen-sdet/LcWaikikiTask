Feature: Product Adding Feature

  @wip
  Scenario Outline: User should be able to order any product
    Given user on the LC WAIKIKI page
    Then title should contain "LC Waikiki"
    When user select any "<sub-category>" from "<category>"
    Then title should contain "<category> <sub-category>"
    And user click any product
    Then user should land on product page
    And user add product to cart
    And user navigate to cart
    Then user should see the product added
    And user navigate back to home page
    Then title should contain "LC Waikiki"
    Examples:
      | sub-category | category |
      | Tişört       | ERKEK    |

