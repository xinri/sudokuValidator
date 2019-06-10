package sudoku;

import sudoku.field.valuetype.SudokuTable;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuGrid {

  private final SudokuTable table;

  public SudokuGrid(final SudokuTable table) {
    this.table = table;
  }

  public boolean validate() {
    return true;
  }
}
