package sudoku.field.structure.validator;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import sudoku.field.SudokuCell;
import sudoku.field.structure.estimation.EstimationUpdater;

public class EstimationValidatorShould {


  @Test
  public void return_true_when_there_is_no_empty_cell() {
    // given
    List<SudokuCell[]> listOfCells = Arrays.asList(new SudokuCell[]{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, (new SudokuCell[]{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }));

    EstimationUpdater estimationUpdater = new EstimationUpdater(listOfCells);
    estimationUpdater.update();

    // when
    boolean result = EstimationValidator.validateIfMissedValue(listOfCells);

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_false_when_there_is_no_possibility_to_have_3() {
    // given
    SudokuCell emptyCell_2 = new SudokuCell(null);
    SudokuCell emptyCell_3 = new SudokuCell(null);
    SudokuCell emptyCell_7 = new SudokuCell(null);

    List<SudokuCell[]> listOfCells = Arrays.asList(new SudokuCell[]{
        new SudokuCell(1), emptyCell_2, emptyCell_3,
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        emptyCell_7, new SudokuCell(8), new SudokuCell(9)
    }, (new SudokuCell[]{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }));

    EstimationUpdater estimationUpdater = new EstimationUpdater(listOfCells);
    estimationUpdater.update();

    emptyCell_2.removePotentialValue(3);
    emptyCell_3.removePotentialValue(3);
    emptyCell_7.removePotentialValue(3);

    // when
    boolean result = EstimationValidator.validateIfMissedValue(listOfCells);

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void return_true_when_there_is_a_possibility_for_each_number() {
    // given
    SudokuCell emptyCell_2 = new SudokuCell(null);
    SudokuCell emptyCell_3 = new SudokuCell(null);
    SudokuCell emptyCell_7 = new SudokuCell(null);

    List<SudokuCell[]> listOfCells = Arrays.asList(new SudokuCell[]{
        new SudokuCell(1), emptyCell_2, emptyCell_3,
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        emptyCell_7, new SudokuCell(8), new SudokuCell(9)
    }, (new SudokuCell[]{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }));

    EstimationUpdater estimationUpdater = new EstimationUpdater(listOfCells);
    estimationUpdater.update();

    // when
    boolean result = EstimationValidator.validateIfMissedValue(listOfCells);

    // then
    assertThat(result).isTrue();
  }
}