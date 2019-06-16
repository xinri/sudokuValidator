package sudoku.field.structure.estimation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class EstimationUpdaterShould {

  @Test
  public void should_not_modify_empty_cell_when_we_cannot_estimate_its_value() {
    // given
    SudokuCell emptyCell = new SudokuCell(null);
    List<SudokuCell[]> listOfCells = Arrays.asList(
        new SudokuCell[]{
            new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
            new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
            new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
        }, new SudokuCell[]{
            new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
            new SudokuCell(null), emptyCell, new SudokuCell(6),
            new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
        });

    EstimationUpdater estimationUpdater = new EstimationUpdater(listOfCells);
    // when
    estimationUpdater.update();

    // then
    assertThat(emptyCell.getCellValue()).isNull();
  }

  @Test
  public void should_modify_empty_cell_when_we_can_estimate_its_value() {
    // given
    SudokuCell emptyCell = new SudokuCell(null);

    List<SudokuCell[]> listOfCells = Arrays.asList(
        new SudokuCell[]{
            new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
            new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
            new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
        }, new SudokuCell[]{
            new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
            new SudokuCell(4), emptyCell, new SudokuCell(6),
            new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
        });
    EstimationUpdater estimationUpdater = new EstimationUpdater(listOfCells);

    // when
    estimationUpdater.update();

    // then
    assertThat(emptyCell.getCellValue()).isNotNull().isEqualTo(5);
  }

}
