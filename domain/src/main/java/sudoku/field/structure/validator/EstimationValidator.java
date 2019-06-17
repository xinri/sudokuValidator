package sudoku.field.structure.validator;

import static sudoku.field.SudokuCell.CELL_NOT_NULL_PREDICATE;
import static sudoku.field.SudokuCell.CELL_NULL_PREDICATE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public interface EstimationValidator {

  static boolean validateIfHaveAtLeastOneEstimation(final List<SudokuCell[]> listOfCells) {
    return !listOfCells.stream()
        .flatMap(Arrays::stream)
        .filter(CELL_NULL_PREDICATE)
        .anyMatch(cell -> cell.getSetOfPotentialValue().size() == 0);
  }

  static boolean validateIfMissedValue(final List<SudokuCell[]> listOfCells) {
    Set<Integer> setOfAllValues = IntStream.rangeClosed(1, 9)
        .mapToObj(Integer::valueOf)
        .collect(Collectors.toSet());

    return listOfCells.stream()
        .map(cells -> {
          Set<Integer> valueToCheck = new HashSet<>(setOfAllValues);

          valueToCheck.removeAll(Arrays.stream(cells)
              .filter(CELL_NOT_NULL_PREDICATE)
              .map(SudokuCell::getCellValue)
              .collect(Collectors.toSet()));

          // return true if there is no value that can be found
          return valueToCheck.stream()
              .allMatch(value -> !Arrays.stream(cells)
                  .anyMatch(cell ->
                      cell.getCellValue() == null && !cell.getSetOfPotentialValue().contains(value))
              );
        }).reduce((oldValue, newValue) -> oldValue && newValue).get();
  }
}
