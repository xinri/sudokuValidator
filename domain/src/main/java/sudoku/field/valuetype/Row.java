package sudoku.field.valuetype;

import java.util.Arrays;
import java.util.function.Predicate;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class Row {

  private SudokuCell[] rowCells;

  public Row(SudokuCell[] rowCells) {
    this.rowCells = rowCells;
  }

  public boolean validate() {
    Predicate<SudokuCell> CELL_NOT_NULL = cell -> cell.getCellValue() != null;
    return Arrays.stream(rowCells)
        .filter(CELL_NOT_NULL)
        .distinct().count() == Arrays.stream(rowCells).filter(CELL_NOT_NULL).count();
  }
}
