package sudoku.field.valuetype;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.ArrayList;
import java.util.Arrays;
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
