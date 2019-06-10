package sudoku;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import sudoku.field.valuetype.SudokuTable;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuFieldShould {

  @Test
  public void create_a_sudoku_field_when_the_table_is_a_9x9() {
    // when
    SudokuField result = new SudokuField(new SudokuTable(fillTable(9, 9, 1)));
    // then
    Assertions.assertThat(result).isNotNull();
  }


  private Integer[][] fillTable(int length, int height, int initialValue) {
    Integer[][] filledTable = new Integer[length][height];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < height; j++) {
        filledTable[i][j] = initialValue;
      }
    }

    return filledTable;
  }
}
