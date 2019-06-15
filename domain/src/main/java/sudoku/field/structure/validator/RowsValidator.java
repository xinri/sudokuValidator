package sudoku.field.structure.validator;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.Arrays;
import sudoku.field.SudokuCell;
import sudoku.field.structure.Rows;

/**
 * @author hlay
 * @version 1.0
 */
public class RowsValidator {

  private final Rows rows;

  public RowsValidator(final Rows rows) {
    this.rows = rows;
  }

  public boolean validate() {
    return rows.getListOfRow().stream()
        .map(this::validateRow)
        .reduce((prevResult, nextResult) -> prevResult && nextResult)
        .orElse(true);
  }

  private boolean validateRow(final SudokuCell[] row) {
    return Arrays.stream(row)
        .filter(NOT_NULL_PREDICATE)
        .distinct().count() == Arrays.stream(row).filter(NOT_NULL_PREDICATE).count();
  }
}
