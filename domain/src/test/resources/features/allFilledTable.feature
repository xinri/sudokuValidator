Feature: Completely filled sudoku case

  Scenario: When all cells are correctly filled
    Given the sudoku table
      | 8 | 2 | 5 | 4 | 7 | 1 | 3 | 9 | 6 |
      | 1 | 9 | 4 | 3 | 2 | 6 | 5 | 7 | 8 |
      | 3 | 7 | 6 | 9 | 8 | 5 | 2 | 4 | 1 |
      | 5 | 1 | 9 | 7 | 4 | 3 | 8 | 6 | 2 |
      | 6 | 3 | 2 | 5 | 9 | 8 | 4 | 1 | 7 |
      | 4 | 8 | 7 | 6 | 1 | 2 | 9 | 3 | 5 |
      | 2 | 6 | 3 | 1 | 5 | 9 | 7 | 8 | 4 |
      | 9 | 4 | 8 | 2 | 6 | 7 | 1 | 5 | 3 |
      | 7 | 5 | 1 | 8 | 3 | 4 | 6 | 2 | 9 |
    When validate the table
    Then the table is valid

  Scenario: Another solution When all cells are correctly filled
    Given the sudoku table
      | 6 | 3 | 9 | 5 | 7 | 4 | 1 | 8 | 2 |
      | 5 | 4 | 1 | 8 | 2 | 9 | 3 | 7 | 6 |
      | 7 | 8 | 2 | 6 | 1 | 3 | 9 | 5 | 4 |
      | 1 | 9 | 8 | 4 | 6 | 7 | 5 | 2 | 3 |
      | 3 | 6 | 5 | 9 | 8 | 2 | 4 | 1 | 7 |
      | 4 | 2 | 7 | 1 | 3 | 5 | 8 | 6 | 9 |
      | 9 | 5 | 6 | 7 | 4 | 8 | 2 | 3 | 1 |
      | 8 | 1 | 3 | 2 | 9 | 6 | 7 | 4 | 5 |
      | 2 | 7 | 4 | 3 | 5 | 1 | 6 | 9 | 8 |
    When validate the table
    Then the table is valid

  Scenario: The sudoku table is only filled with 1
    Given the sudoku table
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
      | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
    When validate the table
    Then the table is not valid

  Scenario: The sudoku table with rows and columns distinct but blocks not valid
    Given the sudoku table
      | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
      | 2 | 3 | 4 | 1 | 1 | 1 | 8 | 9 | 1 |
      | 3 | 4 | 5 | 1 | 1 | 8 | 9 | 1 | 2 |
      | 4 | 5 | 6 | 1 | 8 | 9 | 1 | 2 | 3 |
      | 5 | 6 | 7 | 8 | 9 | 1 | 2 | 3 | 4 |
      | 6 | 7 | 8 | 9 | 1 | 2 | 3 | 4 | 5 |
      | 7 | 8 | 9 | 1 | 2 | 3 | 4 | 5 | 6 |
      | 8 | 9 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
      | 9 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
    When validate the table
    Then the table is not valid

  Scenario: The sudoku table had only last block wrong
    Given the sudoku table
      | 6 | 3 | 9 | 5 | 7 | 4 | 1 | 8 | 2 |
      | 5 | 4 | 1 | 8 | 2 | 9 | 3 | 7 | 6 |
      | 7 | 8 | 2 | 6 | 1 | 3 | 9 | 5 | 4 |
      | 1 | 9 | 8 | 4 | 6 | 7 | 5 | 2 | 3 |
      | 3 | 6 | 5 | 9 | 8 | 2 | 4 | 1 | 7 |
      | 4 | 2 | 7 | 1 | 3 | 5 | 8 | 6 | 9 |
      | 9 | 5 | 6 | 7 | 4 | 8 | 2 | 3 | 1 |
      | 8 | 1 | 3 | 2 | 9 | 6 | 7 | 4 | 5 |
      | 2 | 7 | 4 | 3 | 5 | 1 | 6 | 9 | 5 |
    When validate the table
    Then the table is not valid