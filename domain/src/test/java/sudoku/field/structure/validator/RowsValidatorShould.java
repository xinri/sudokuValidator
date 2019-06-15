package sudoku.field.structure.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import sudoku.field.SudokuCell;
import sudoku.field.structure.Rows;

public class RowsValidatorShould {

  @Test
  public void return_true_when_there_is_no_duplicate_value() {
    // given
    RowsValidator rowsValidator = new RowsValidator(new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }}));

    // when
    boolean result = rowsValidator.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_false_when_there_is_duplicate_value() {
    // given
    RowsValidator rowsValidator = new RowsValidator(new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }}));

    // when
    boolean result = rowsValidator.validate();

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void return_true_when_there_is_a_empty_cell_with_no_duplicate_value() {
    // given
    RowsValidator rowsValidator = new RowsValidator(new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(null), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }}));

    // when
    boolean result = rowsValidator.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_true_when_there_is_2_empty_cells_with_no_duplicate_value() {
    // given
    RowsValidator rowsValidator = new RowsValidator(new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(null), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(null), new SudokuCell(9)
    }}));

    // when
    boolean result = rowsValidator.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_false_when_there_is_a_empty_cell_with_duplicate_value() {
    // given
    RowsValidator rowsValidator = new RowsValidator(new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(null), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(2), new SudokuCell(9)
    }}));

    // when
    boolean result = rowsValidator.validate();

    // then
    assertThat(result).isFalse();
  }
}