package sudoku.field.valuetype;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuGridInitializerShould {

  @Test
  public void throw_an_exception_when_the_table_is_empty() {
    // when and then
    assertThatThrownBy(() -> new SudokuGridInitializer(new Integer[][]{}))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("The table is empty");
  }

  @Test
  public void throw_an_exception_when_the_table_length_is_not_9() {
    // when and then
    assertThatThrownBy(() -> new SudokuGridInitializer(fillTable(8, 9, 1)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("The table must have a length of 9");
  }

  @Test
  public void throw_an_exception_when_the_table_height_is_not_9() {
    // when and then
    assertThatThrownBy(() -> new SudokuGridInitializer(fillTable(9, 8, 1)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("The table must have a height of 9");
  }

  @Test
  public void create_sudoku_cells_when_the_table_is_a_9x9() {
    // when
    SudokuGridInitializer result = new SudokuGridInitializer(fillTable(9, 9, 1));
    // then
    assertThat(result).isNotNull();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        assertThat(result.getCells()[i][j].getCellValue()).isEqualTo(1);
      }
    }
  }

  @Test
  public void create_sudoku_cells_when_the_table_is_a_9x9_with_a_hole() {
    // when
    Integer[][] cells = fillTable(9, 9, 1);
    cells[0][5] = null;
    cells[5][5] = null;
    cells[8][8] = null;

    SudokuGridInitializer result = new SudokuGridInitializer(cells);
    // then
    assertThat(result).isNotNull();
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
