Feature: Return true

  Scenario: when validating a block with distinct values without empty cell
    Given the creation of blocks with the following table
      | 1 | 2 | 3 | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 8 | 9 | 7 | 8 | 9 |
      | 1 | 2 | 3 | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 8 | 9 | 7 | 8 | 9 |
      | 1 | 2 | 3 | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 8 | 9 | 7 | 8 | 9 |
    When the blocks trigger a validation
    Then the blocks are valid

  Scenario: when validating a block with no distinct values without empty cell in the middle block
    Given the creation of blocks with the following table
      | 1 | 2 | 3 | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 8 | 9 | 7 | 8 | 9 |
      | 1 | 2 | 3 | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 5 | 9 | 7 | 8 | 9 |
      | 1 | 2 | 3 | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 8 | 9 | 7 | 8 | 9 |
    When the blocks trigger a validation
    Then the blocks are invalid