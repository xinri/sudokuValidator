package sudoku.field;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuCell {

  public static final Predicate<SudokuCell> NOT_NULL_PREDICATE = cell -> cell.getCellValue()
      != null;
  private final Integer cellValue;

  public SudokuCell(Integer cellValue) {

    if (cellValue != null) {
      if (cellValue < 1) {
        throw new IllegalArgumentException("A cell value is lower than 1");
      }

      if (cellValue > 9) {
        throw new IllegalArgumentException("A cell value is greater than 9");
      }
    }

    this.cellValue = cellValue;
  }

  public Integer getCellValue() {
    return cellValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SudokuCell)) {
      return false;
    }
    SudokuCell that = (SudokuCell) o;
    return Objects.equals(cellValue, that.cellValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cellValue);
  }
}
