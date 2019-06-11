package sudoku;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import sudoku.field.valuetype.SudokuTable;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuGridShould {

  @Test
  public void create_a_sudoku_field_when_the_table_is_a_9x9() {
    // when
    SudokuGrid result = new SudokuGrid(new SudokuTable(fillTable(9, 9, 1)));
    // then
    assertThat(result).isNotNull();
  }

  @Test
  public void return_true_when_each_rows_have_distinct_value() {
    // given
    final Integer[][] table = {
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9}
    };

    SudokuGrid grid = new SudokuGrid(new SudokuTable(table));

    // when
    boolean result = grid.validateRows();

    // then
    assertThat(result).isTrue();
  }


  @Test
  public void return_true_when_each_rows_have_distinct_value_and_a_hole() {
    // given
    final Integer[][] table = {
        {1, 2, 3, 4, 5, 6, 7, 8, null},
        {1, 2, 3, 4, 5, 6, 7, null, 9},
        {1, 2, 3, 4, 5, 6, null, 8, 9},
        {1, 2, 3, 4, 5, null, 7, 8, 9},
        {1, 2, 3, 4, null, 6, 7, 8, 9},
        {1, 2, 3, null, 5, 6, 7, 8, 9},
        {1, 2, null, 4, 5, 6, 7, 8, 9},
        {1, null, 3, 4, 5, 6, 7, 8, 9},
        {null, 2, 3, 4, 5, 6, 7, 8, 9}
    };

    SudokuGrid grid = new SudokuGrid(new SudokuTable(table));

    // when
    boolean result = grid.validateRows();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_false_when_one_row_has_a_same_value() {
    // given
    SudokuGrid grid = new SudokuGrid(
        new SudokuTable(fillTable(9, 9, 1)));

    // when
    boolean result = grid.validateRows();

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void return_true_when_each_column_have_distinct_value() {
    // given
    Integer[][] table = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1},
        {2, 2, 2, 2, 2, 2, 2, 2, 2},
        {3, 3, 3, 3, 3, 3, 3, 3, 3},
        {4, 4, 4, 4, 4, 4, 4, 4, 4},
        {5, 5, 5, 5, 5, 5, 5, 5, 5},
        {6, 6, 6, 6, 6, 6, 6, 6, 6},
        {7, 7, 7, 7, 7, 7, 7, 7, 7},
        {8, 8, 8, 8, 8, 8, 8, 8, 8},
        {9, 9, 9, 9, 9, 9, 9, 9, 9}
    };

    SudokuGrid grid = new SudokuGrid(new SudokuTable(table));

    // when
    boolean result = grid.validateColumns();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_true_when_each_column_have_distinct_value_and_a_hole() {
    // given
    Integer[][] table = {
        {null, 1, 1, 1, 1, 1, 1, 1, 1},
        {2, null, 2, 2, 2, 2, 2, 2, 2},
        {3, 3, null, 3, 3, 3, 3, 3, 3},
        {4, 4, 4, null, 4, 4, 4, 4, 4},
        {5, 5, 5, 5, null, 5, 5, 5, 5},
        {6, 6, 6, 6, 6, null, 6, 6, 6},
        {7, 7, 7, 7, 7, 7, null, 7, 7},
        {8, 8, 8, 8, 8, 8, 8, null, 8},
        {9, 9, 9, 9, 9, 9, 9, 9, null}
    };

    SudokuGrid grid = new SudokuGrid(new SudokuTable(table));

    // when
    boolean result = grid.validateColumns();

    // then
    assertThat(result).isTrue();
  }


  @Test
  public void return_false_when_one_column_has_a_same_value() {
    // given
    SudokuGrid grid = new SudokuGrid(
        new SudokuTable(fillTable(9, 9, 1)));

    // when
    boolean result = grid.validateColumns();

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void return_true_when_each_3x3_blocks_have_different_values() {
    // given
    final Integer[][] table = {
        {1, 2, 3, 1, 2, 3, 1, 2, 3},
        {4, 5, 6, 4, 5, 6, 4, 5, 6},
        {7, 8, 9, 7, 8, 9, 7, 8, 9},
        {1, 2, 3, 1, 2, 3, 1, 2, 3},
        {4, 5, 6, 4, 5, 6, 4, 5, 6},
        {7, 8, 9, 7, 8, 9, 7, 8, 9},
        {1, 2, 3, 1, 2, 3, 1, 2, 3},
        {4, 5, 6, 4, 5, 6, 4, 5, 6},
        {7, 8, 9, 7, 8, 9, 7, 8, 9}
    };

    SudokuGrid grid = new SudokuGrid(new SudokuTable(table));

    // when ans then
    for (int blockNumber = 0; blockNumber < 9; blockNumber++) {
      assertThat(grid.validateBlock(blockNumber)).isTrue();
    }
  }

  @Test
  public void return_true_when_each_3x3_blocks_have_different_values_with_a_hole() {
    // given
    final Integer[][] table = {
        {null, 2, 3, 1, null, 3, 1, 2, null},
        {4, 5, 6, 4, 5, 6, 4, 5, 6},
        {7, 8, 9, 7, 8, 9, 7, 8, 9},
        {1, 2, 3, 1, 2, 3, 1, 2, 3},
        {null, 5, 6, 4, null, 6, 4, 5, null},
        {7, 8, 9, 7, 8, 9, 7, 8, 9},
        {1, 2, 3, 1, 2, 3, 1, 2, 3},
        {4, 5, 6, 4, 5, 6, 4, 5, 6},
        {null, 8, 9, 7, null, 9, 7, 8, null}
    };

    SudokuGrid grid = new SudokuGrid(new SudokuTable(table));

    // when ans then
    for (int blockNumber = 0; blockNumber < 9; blockNumber++) {
      assertThat(grid.validateBlock(blockNumber)).isTrue();
    }
  }

  @Test
  public void return_false_when_each_3x3_blocks_have_a_same_value() {
    // given
    final Integer[][] table = {
        {1, 1, 3, 1, 2, 1, 1, 2, 3},
        {4, 5, 6, 4, 5, 6, 1, 5, 6},
        {7, 8, 9, 7, 8, 9, 7, 8, 9},
        {1, 2, 3, 1, 2, 3, 1, 2, 3},
        {4, 1, 6, 4, 5, 1, 4, 5, 6},
        {7, 8, 9, 7, 8, 9, 1, 8, 9},
        {1, 2, 3, 1, 2, 3, 2, 2, 3},
        {4, 5, 6, 4, 5, 6, 4, 5, 6},
        {7, 1, 9, 7, 1, 9, 7, 8, 9}
    };

    SudokuGrid grid = new SudokuGrid(new SudokuTable(table));

    // when and then
    for (int blockNumber = 0; blockNumber < 9; blockNumber++) {
      assertThat(grid.validateBlock(blockNumber)).isFalse();
    }
  }

  private Integer[][] fillTable(int length, int height, int initialValue) {
    Integer[][] filledTable = new Integer[height][length];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < height; j++) {
        filledTable[i][j] = initialValue;
      }
    }

    return filledTable;
  }
}
