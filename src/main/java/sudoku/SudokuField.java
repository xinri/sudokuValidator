package sudoku;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuField {

  public SudokuField(int[][] tableOfValues) {
    if (tableOfValues.length == 0) {
      throw new IllegalArgumentException("The table is empty");
    }

    if (tableOfValues.length != 9) {
      throw new IllegalArgumentException("The table must have a length of 9");
    }

    if (tableOfValues[0].length != 9) {
      throw new IllegalArgumentException("The table must have a height of 9");
    }
  }

  public boolean validate() {
    return true;
  }
}
