package sudoku.field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuCellShould {

  @Test
  public void throw_an_exception_when_the_cell_has_a_value_lower_than_1() {
    // when and then
    assertThatThrownBy(() -> new SudokuCell(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("A cell value is lower than 1");
  }

  @Test
  public void throw_an_exception_when_the_cell_has_a_value_greater_than_9() {
    // when and then
    assertThatThrownBy(() -> new SudokuCell(10))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("A cell value is greater than 9");
  }

  @Test
  public void return_a_sudokuCell_when_the_number_is_between_1_and_9() {
    // when and then
    for (int i = 1; i < 10; i++) {
      assertThat(new SudokuCell(i)).isNotNull();
    }
  }

  @Test
  public void return_a_sudokuCell_when_the_number_is_null() {
    // when and then
    assertThat(new SudokuCell(null)).isNotNull();
  }
}
