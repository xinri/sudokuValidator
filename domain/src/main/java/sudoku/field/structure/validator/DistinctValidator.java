package sudoku.field.structure.validator;

import static sudoku.field.SudokuCell.CELL_NOT_NULL_PREDICATE;

import java.util.Arrays;
import java.util.List;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public interface DistinctValidator {

  boolean validate();

  static boolean validateDistinct(final List<SudokuCell[]> listOfCells) {
    return listOfCells.stream()
        .map(DistinctValidator::validateOneLine)
        .reduce((prevResult, nextResult) -> prevResult && nextResult)
        .orElse(true);
  }

  static boolean validateOneLine(final SudokuCell[] cells) {
    return Arrays.stream(cells)
        .filter(CELL_NOT_NULL_PREDICATE)
        .distinct().count() == Arrays.stream(cells).filter(CELL_NOT_NULL_PREDICATE).count();
  }
}
