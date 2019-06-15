package sudoku.field.structure;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

  public List<SudokuCell[]> getListOfRow() {
    return Collections.unmodifiableList(listOfRow);
  }
}
