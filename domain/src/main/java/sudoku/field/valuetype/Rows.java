package sudoku.field.valuetype;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class Rows {

  private List<SudokuCell[]> listOfRow;

  public Rows(final SudokuCell[][] table) {
    this.listOfRow = Arrays.stream(table).collect(Collectors.toList());
  }

  public boolean validate() {
    return listOfRow.stream()
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
