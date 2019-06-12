package sudoku.field.valuetype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class Columns {

  private static final Predicate<SudokuCell> CELL_NOT_NULL = cell -> cell.getCellValue() != null;
  private final List<SudokuCell[]> listOfColumn;

  public Columns(SudokuCell[][] table) {

    listOfColumn = new ArrayList<>();

    for (int column = 0; column < table[0].length; column++) {
      List<SudokuCell> columnCell = new ArrayList<>();
      for (int row = 0; row < table.length; row++) {
        columnCell.add(table[row][column]);
      }
      listOfColumn.add(columnCell.stream().toArray(SudokuCell[]::new));
    }
  }

  public boolean validate() {
    return listOfColumn.stream()
        .map(this::validateColumn)
        .reduce((prevResult, nextResult) -> prevResult && nextResult)
        .orElse(true);
  }

  private boolean validateColumn(final SudokuCell[] column) {
    return Arrays.stream(column)
        .filter(CELL_NOT_NULL)
        .distinct().count() == Arrays.stream(column).filter(CELL_NOT_NULL).count();
  }
}
