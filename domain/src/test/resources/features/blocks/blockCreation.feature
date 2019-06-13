Feature: blocks creation

  Scenario: blocks creation with table that is empty
    Then throw an exception with the message "the blocks shouldn't be empty" with the following table
      |

  Scenario: blocks creation with table that has a 2x3 size
    Then throw an exception with the message "the blocks should be a one or multiple 3x3 block" with the following table
      | 1 | 2 |
      | 3 | 4 |
      | 6 | 7 |


  Scenario: blocks creation with table that has a 3x2 size (not a module 3)
    Then throw an exception with the message "the blocks should be a one or multiple 3x3 block" with the following table
      | 1 | 2 | 3 |
      | 4 | 5 | 6 |

  Scenario: blocks creation with a correct table (3x3)
    When the creation of blocks with the following table
      | 1 | 2 | 3 |
      | 4 | 5 | 6 |
      | 7 | 8 | 9 |
    Then verify 1 blocks are created

  Scenario: blocks creation with a correct table horizontally (6x3)
    When the creation of blocks with the following table
      | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 8 | 9 |
    Then verify 2 blocks are created


  Scenario: blocks creation with a correct table vertically (3x6)
    When the creation of blocks with the following table
      | 1 | 2 | 3 |
      | 4 | 5 | 6 |
      | 7 | 8 | 9 |
      | 1 | 2 | 3 |
      | 4 | 5 | 6 |
      | 7 | 8 | 9 |
    Then verify 2 blocks are created

  Scenario: blocks creation with a correct table (6x6)
    When the creation of blocks with the following table
      | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 8 | 9 |
      | 1 | 2 | 3 | 1 | 2 | 3 |
      | 4 | 5 | 6 | 4 | 5 | 6 |
      | 7 | 8 | 9 | 7 | 8 | 9 |
    Then verify 4 blocks are created
