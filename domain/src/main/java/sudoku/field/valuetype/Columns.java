package sudoku.field.valuetype;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
    boolean isTheSameCount = Arrays.stream(column)
        .filter(NOT_NULL_PREDICATE)
        .distinct().count() == Arrays.stream(column).filter(NOT_NULL_PREDICATE).count();

    boolean isNoSolutionForEmptyCell = Arrays.stream(column).filter(cell -> cell.getCellValue() == null)
        .anyMatch(cell -> cell.getSetOfPotentialValue().isEmpty());

    return isTheSameCount && !isNoSolutionForEmptyCell;
  }

  public void workOnEmptyCell() {
    listOfColumn.forEach(row -> {
      if (Arrays.stream(row).filter(NOT_NULL_PREDICATE).count() > 0) {
        Set<Integer> setToRemove = Arrays.stream(row).
            filter(NOT_NULL_PREDICATE)
            .map(SudokuCell::getCellValue)
            .collect(Collectors.toSet());

        Arrays.stream(row).filter(cell -> cell.getCellValue() == null)
            .forEach(cell -> cell.removePotentialValues(setToRemove));
      }
    });
  }
}
