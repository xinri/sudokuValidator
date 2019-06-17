package sudoku.field.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class Columns {

  private final List<SudokuCell[]> listOfColumn;

  public Columns(SudokuCell[][] table) {

    listOfColumn = new ArrayList<>();

    for (int column = 0; column < table[0].length; column++) {
      List<SudokuCell> columnCell = new ArrayList<>();
      for (SudokuCell[] sudokuCells : table) {
        columnCell.add(sudokuCells[column]);
      }
      listOfColumn.add(columnCell.toArray(new SudokuCell[0]));
    }
  }

  public List<SudokuCell[]> getListOfColumn() {
    return Collections.unmodifiableList(listOfColumn);
  }
}
