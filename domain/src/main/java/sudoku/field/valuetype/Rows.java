package sudoku.field.valuetype;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class Rows {

  private static final Predicate<SudokuCell> CELL_NOT_NULL = cell -> cell.getCellValue() != null;
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
        .filter(CELL_NOT_NULL)
        .distinct().count() == Arrays.stream(row).filter(CELL_NOT_NULL).count();
  }
}
