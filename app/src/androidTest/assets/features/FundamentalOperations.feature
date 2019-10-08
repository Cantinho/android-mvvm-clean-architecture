Feature: Fundamental operations
  @smoke
  @e2e
  Scenario Outline: Addiction
    Given I start the application
    When I put a valid value in first text field <value1>
    And I put a valid value in second text field <value2>
    And I click on addiction button
    Then I expect to see the result <result>
    Examples:
      | value1  | value2  | result  |
      |    10   |    10   |    20   |
      |   -10   |   -10   |   -20   |
      |    20   |   -20   |     0   |
      |   -20   |    20   |     0   |
      |   -20   |    10   |   -10   |
      |    20   |   -10   |    10   |

  @smoke
  @e2e
  Scenario Outline: Subtraction
    Given I start the application
    When I put a valid value in first text field <value1>
    And I put a valid value in second text field <value2>
    And I click on subtraction button
    Then I expect to see the result <result>
    Examples:
      | value1  | value2  | result  |
      |    10   |    20   |   -10   |
      |    20   |    10   |    10   |
      |    20   |    20   |     0   |
      |   -10   |   -10   |   -20   |
      |   -20   |    10   |   -10   |
      |    20   |   -10   |    10   |

  @smoke
  @e2e
  Scenario Outline: Multiplication
    Given I start the application
    When I put a valid value in first text field <value1>
    And I put a valid value in second text field <value2>
    And I click on multiplication button
    Then I expect to see the result <result>
    Examples:
      | value1  | value2  | result  |
      |     0   |    20   |     0   |
      |     1   |    20   |    20   |
      |    10   |    20   |   200   |
      |   -10   |     2   |   -20   |
      |    10   |    -2   |   -20   |
      |   -10   |    -2   |    20   |

  @smoke
  @e2e
  Scenario Outline: Division
    Given I start the application
    When I put a valid value in first text field <value1>
    And I put a valid value in second text field <value2>
    And I click on division button
    Then I expect to see the result <result>
    Examples:
      | value1  | value2  | result  |
      |    20   |    10   |     2   |
      |    10   |    20   |   0.5   |
      |   -10   |     2   |    -5   |
      |    10   |    -2   |    -5   |
      |   -10   |    -2   |     5   |
      |    20   |    20   |     1   |
      |    10   |     3   |     3.3333   |
      |    10   |   0.5   |     20   |
      |   0.5   |    10   |     0.05   |
      |   0.25   |   0.5   |    1,25   |
      |   0.25   |    0   |    Division by zero is not possible   |