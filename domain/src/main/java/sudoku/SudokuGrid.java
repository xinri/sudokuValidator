package sudoku;

import sudoku.field.SudokuCell;
import sudoku.field.valuetype.Blocks;
import sudoku.field.valuetype.Columns;
import sudoku.field.valuetype.Rows;
import sudoku.field.valuetype.SudokuGridInitializer;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuGrid {

  public static final int MAX_SIZE = 9;
  private final SudokuCell[][] table;

  public SudokuGrid(final SudokuGridInitializer table) {
    this.table = table.getCells();
  }

  public boolean validate() {
    return validateRows() && validateColumns() && validateBlocks();
  }

  private boolean validateRows() {
    return new Rows(table).validate();
  }

  private boolean validateColumns() {
    return new Columns(table).validate();
  }

  private boolean validateBlocks() {
    return new Blocks(table).validate();
  }
}
