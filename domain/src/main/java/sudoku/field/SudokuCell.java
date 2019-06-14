package sudoku.field;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuCell {

  public static final Predicate<SudokuCell> NOT_NULL_PREDICATE =
      cell -> cell.getCellValue() != null;
  private Integer cellValue;
  private final Set<Integer> potentialValue;

  public SudokuCell(Integer cellValue) {

    if (cellValue != null) {
      if (cellValue < 1) {
        throw new IllegalArgumentException("A cell value is lower than 1");
      }

      if (cellValue > 9) {
        throw new IllegalArgumentException("A cell value is greater than 9");
      }
    }

    if (cellValue == null) {
      potentialValue = new HashSet<Integer>() {{
        for (int i = 0; i < 9; i++) {
          add(i + 1);
        }
      }};
    } else {
      potentialValue = null;
    }

    this.cellValue = cellValue;
  }

  public Integer getCellValue() {
    if (cellValue == null && potentialValue.size() == 1) {
      cellValue = potentialValue.iterator().next();
      potentialValue.clear();
    }
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

  public Set<Integer> getSetOfPotentialValue() {
    if (cellValue != null) {
      return null;
    }
    return Collections.unmodifiableSet(potentialValue);
  }

  public boolean removePotentialValue(int value) {
    return potentialValue.remove(value);
  }

  public boolean removePotentialValues(Collection<Integer> values) {
    return potentialValue.removeAll(values);
  }
}
