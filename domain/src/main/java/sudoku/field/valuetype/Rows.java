package sudoku.field.valuetype;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class Rows {

  private List<SudokuCell[]> listOfRow;

  public Rows(final SudokuCell[][] table) {
    this.listOfRow = Arrays.stream(table).collect(Collectors.toList());
  }

  public void workOnEmptyCell() {
    listOfRow.forEach(row -> {
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

  public boolean validate() {
    return listOfRow.stream()
        .map(this::validateRow)
        .reduce((prevResult, nextResult) -> prevResult && nextResult)
        .orElse(true);
  }

  private boolean validateRow(final SudokuCell[] row) {
    boolean isTheSameCount = Arrays.stream(row)
        .filter(NOT_NULL_PREDICATE)
        .distinct().count() == Arrays.stream(row).filter(NOT_NULL_PREDICATE).count();

    boolean isNoSolutionForEmptyCell = Arrays.stream(row).filter(cell -> cell.getCellValue() == null)
        .anyMatch(cell -> cell.getSetOfPotentialValue().isEmpty());

    return isTheSameCount && !isNoSolutionForEmptyCell;
  }
}
