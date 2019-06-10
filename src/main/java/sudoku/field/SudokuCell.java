package sudoku.field;

import java.util.Optional;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuCell {

  private final Optional<Integer> cellValue;

  public SudokuCell(Integer cellValue) {

    if (cellValue != null) {
      if (cellValue < 1) {
        throw new IllegalArgumentException("A cell value is lower than 1");
      }

      if (cellValue > 9) {
        throw new IllegalArgumentException("A cell value is greater than 9");
      }
    }

    this.cellValue = Optional.ofNullable(cellValue);
  }

  public Optional<Integer> getCellValue() {
    return cellValue;
  }
}
