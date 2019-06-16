Feature: Validation that is at the limit

  Scenario: Unsolvable Box (number 4 that cannot be use in the middle 3x3 box)
    Given the sudoku table
      |   | 9 |   | 3 |   |   |   |   | 1 |
      |   |   |   |   | 8 |   |   | 4 | 6 |
      |   |   |   |   |   |   | 8 |   |   |
      | 4 |   | 5 |   | 6 |   |   | 3 |   |
      |   |   | 3 | 2 | 7 | 5 | 6 |   |   |
      |   | 6 |   |   | 1 |   | 9 |   | 4 |
      |   |   | 1 |   |   |   |   |   |   |
      | 5 | 8 |   |   | 2 |   |   |   |   |
      | 2 |   |   |   |   | 7 |   | 6 |   |
    When validate the table
    Then the table is not valid

  Scenario: Unsolvable square
    Given the sudoku table
      |   |   | 9 |   | 2 | 8 | 7 |   |   |
      | 8 |   | 6 |   |   | 4 |   |   | 5 |
      |   |   | 3 |   |   |   |   |   | 4 |
      | 6 |   |   |   |   |   |   |   |   |
      |   | 2 |   | 7 | 1 | 3 | 4 | 5 |   |
      |   |   |   |   |   |   |   |   | 2 |
      | 3 |   |   |   |   |   | 5 |   |   |
      | 9 |   |   | 4 |   |   | 8 |   | 7 |
      |   |   | 1 | 2 | 5 |   | 3 |   |   |
    When validate the table
    Then the table is not valid

  Scenario: Unsolvable column (middle column cannot use 2)
    Given the sudoku table
      |   |   |   |   | 4 | 1 |   |   |   |
      |   | 6 |   |   |   |   |   | 2 |   |
      |   |   | 2 |   |   |   |   |   |   |
      | 3 | 2 |   | 6 |   |   |   |   |   |
      |   |   |   |   | 5 |   |   | 4 | 1 |
      | 7 |   |   |   |   |   |   |   | 2 |
      |   |   |   |   |   |   | 2 | 3 |   |
      |   | 4 | 8 |   |   |   |   |   |   |
      | 5 |   | 1 |   |   | 2 |   |   |   |
    When validate the table
    Then the table is not valid

  Scenario: Unsolvable row (middle row cannot use 1)
    Given the sudoku table
      | 9 |   |   | 1 |   |   |   |   | 4 |
      |   | 1 | 4 |   | 3 |   | 8 |   |   |
      |   |   | 3 |   |   |   |   | 9 |   |
      |   |   |   | 7 |   | 8 |   |   | 1 |
      | 8 |   |   |   |   | 3 |   |   |   |
      |   |   |   |   |   |   |   | 3 |   |
      |   | 2 | 1 |   |   |   |   | 7 |   |
      |   |   | 9 |   | 4 |   | 5 |   |   |
      | 5 |   |   |   | 1 | 6 |   |   | 3 |
    When validate the table
    Then the table is not valid