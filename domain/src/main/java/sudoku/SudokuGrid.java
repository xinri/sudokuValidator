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

  private final SudokuCell[][] table;

  public SudokuGrid(final SudokuGridInitializer table) {
    this.table = table.getCells();
    workOnEmptyCells();
  }

  public boolean validate() {
    return validateRows() && validateColumns() && validateBlocks();
  }

  private void workOnEmptyCells() {
    new Rows(table).workOnEmptyCell();
    new Columns(table).workOnEmptyCell();
    new Blocks(table).workOnEmptyCell();
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
