package sudoku.field.structure.validator;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.Arrays;
import java.util.List;
import sudoku.field.SudokuCell;
import sudoku.field.structure.Columns;

/**
 * @author hlay
 * @version 1.0
 */
public class ColumnsValidator {

  private final List<SudokuCell[]> listOfColumn;

  public ColumnsValidator(Columns columns) {
    listOfColumn = columns.getListOfColumn();
  }

  public boolean validate() {
    return listOfColumn.stream()
        .map(this::validateColumn)
        .reduce((prevResult, nextResult) -> prevResult && nextResult)
        .orElse(true);
  }

  private boolean validateColumn(final SudokuCell[] column) {
    return Arrays.stream(column)
        .filter(NOT_NULL_PREDICATE)
        .distinct().count() == Arrays.stream(column).filter(NOT_NULL_PREDICATE).count();
  }
}
