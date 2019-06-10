package sudoku.field.valuetype;

import java.util.Arrays;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuTable {

  private final SudokuCell[][] cells;

  public SudokuTable(final Integer[][] cells) {
    if (cells.length == 0) {
      throw new IllegalArgumentException("The table is empty");
    }

    if (cells.length != 9) {
      throw new IllegalArgumentException("The table must have a length of 9");
    }

    if (cells[0].length != 9) {
      throw new IllegalArgumentException("The table must have a height of 9");
    }

    this.cells = Arrays.stream(cells)
        .map(row -> Arrays.stream(row).map(SudokuCell::new).toArray(SudokuCell[]::new))
        .toArray(SudokuCell[][]::new);
  }

  public SudokuCell[][] getCells() {
    return cells.clone();
  }
}
