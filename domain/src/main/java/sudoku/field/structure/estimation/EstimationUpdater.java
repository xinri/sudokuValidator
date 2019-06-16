package sudoku.field.structure.estimation;

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
public class EstimationUpdater {

  private List<SudokuCell[]> listOfCells;

  public EstimationUpdater(List<SudokuCell[]> listOfCells) {
    this.listOfCells = listOfCells;
  }

  public void update() {
    listOfCells.forEach(row -> {
      if (Arrays.stream(row).filter(NOT_NULL_PREDICATE).count() > 0) {
        Set<Integer> setToRemove = Arrays.stream(row).
            filter(NOT_NULL_PREDICATE)
            .map(SudokuCell::getCellValue)
            .collect(Collectors.toSet());

        Arrays.stream(row).filter(cell -> cell.getCellValue() == null)
            .forEach(cell -> {
              setToRemove.forEach(toRemove -> cell.removePotentialValue(toRemove));
              if (cell.getSetOfPotentialValue().size() == 1) {
                cell.setCellValue(cell.getSetOfPotentialValue().iterator().next());
              }
            });
      }
    });
  }
}