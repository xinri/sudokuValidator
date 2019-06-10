package sudoku;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuFieldShould {

  @Test
  public void throw_an_exception_when_the_table_is_empty() {
    // when and then
    assertThatThrownBy(() -> new SudokuField(new int[][]{}))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("The table is empty");
  }

  @Test
  public void throw_an_exception_when_the_table_length_is_not_9() {
    // when and then
    assertThatThrownBy(() -> new SudokuField(fillTable(8, 9, 1)))
    .isInstanceOf(IllegalArgumentException.class)
    .hasMessage("The table must have a length of 9");
  }

  @Test
  public void throw_an_exception_when_the_table_height_is_not_9() {
    // when and then
    assertThatThrownBy(() -> new SudokuField(fillTable(9, 8, 1)))
    .isInstanceOf(IllegalArgumentException.class)
    .hasMessage("The table must have a height of 9");
  }

  @Test
  public void create_a_sudoku_field_when_the_table_is_a_9x9() {
    // when
    SudokuField result = new SudokuField(fillTable(9, 9, 1));
    // then
    Assertions.assertThat(result).isNotNull();
  }


  private int[][] fillTable(int length, int height, int initialValue) {
    int[][] filledTable = new int[length][height];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < height; j++) {
        filledTable[i][j] = initialValue;
      }
    }

    return filledTable;
  }
}
