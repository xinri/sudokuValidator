package sudoku.field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
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

  @Test
  public void return_null_for_potential_value_when_the_cell_is_not_empty() {
    // given
    SudokuCell sudokuCell = new SudokuCell(4);

    // when
    Set<Integer> result = sudokuCell.getSetOfPotentialValue();

    // then
    assertThat(result).isNull();
  }

  @Test
  public void return_a_set_of_9_elements_when_the_cell_is_empty() {
    // given
    SudokuCell sudokuCell = new SudokuCell(null);

    // when
    Set<Integer> result = sudokuCell.getSetOfPotentialValue();

    // then
    assertThat(sudokuCell.getCellValue()).isNull();
    assertThat(result).contains(1, 2, 3, 4, 5, 6, 7, 8, 9);
  }

  @Test
  public void return_a_set_of_8_elements_when_the_cell_is_empty_and_remove_5() {
    // given
    SudokuCell sudokuCell = new SudokuCell(null);

    // when
    boolean result = sudokuCell.removePotentialValue(5);

    // then
    assertThat(result).isTrue();
    assertThat(sudokuCell.getCellValue()).isNull();
    assertThat(sudokuCell.getSetOfPotentialValue()).contains(1, 2, 3, 4, 6, 7, 8, 9);
  }

  @Test
  public void return_potential_value_into_cell_value_when_there_is_only_one() {
    // given
    SudokuCell sudokuCell = new SudokuCell(null);

    // when
    sudokuCell.removePotentialValue(1);
    sudokuCell.removePotentialValue(2);
    sudokuCell.removePotentialValue(4);
    sudokuCell.removePotentialValue(5);
    sudokuCell.removePotentialValue(6);
    sudokuCell.removePotentialValue(7);
    sudokuCell.removePotentialValue(8);
    sudokuCell.removePotentialValue(9);

    // then
    assertThat(sudokuCell.getCellValue()).isNotNull().isEqualTo(3);
  }
}
