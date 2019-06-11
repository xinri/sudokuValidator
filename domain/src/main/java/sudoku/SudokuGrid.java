package sudoku;

import java.util.HashSet;
import java.util.Set;
import sudoku.field.SudokuCell;
import sudoku.field.valuetype.SudokuTable;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuGrid {

  public static final int MAX_SIZE = 9;
  private final SudokuCell[][] table;

  public SudokuGrid(final SudokuTable table) {
    this.table = table.getCells();
  }

  public boolean validate() {
    boolean result = validateRows() && validateColumns();
    for (int i = 0; i < MAX_SIZE; i++) {
      result &= validateBlock(i);
    }

    return result;
  }

  boolean validateRows() {

    for (int row = 0; row < MAX_SIZE; row++) {
      Set<Integer> existingNumber = new HashSet<>();

      for (int column = 0; column < MAX_SIZE; column++) {
        Integer cellValue = table[row][column].getCellValue();
        if (existingNumber.contains(cellValue)) {
          return false;
        }

        existingNumber.add(cellValue);
      }
    }

    return true;
  }

  boolean validateColumns() {
    for (int column = 0; column < MAX_SIZE; column++) {
      Set<Integer> existingNumber = new HashSet<>();

      for (int row = 0; row < MAX_SIZE; row++) {
        Integer cellValue = table[row][column].getCellValue();
        if (existingNumber.contains(cellValue)) {
          return false;
        }

        existingNumber.add(cellValue);
      }
    }

    return true;
  }

  boolean validateBlock(int blockNumber) {
    HashSet<Integer> existingElement = new HashSet<>();

    int posX, posY;

    if (blockNumber < 3) {
      posX = blockNumber * 3;
      posY = 0;
    } else if (blockNumber >= 3 && blockNumber < 6) {
      posX = (blockNumber - 3) * 3;
      posY = 3;
    } else {
      posX = (blockNumber - 6) * 3;
      posY = 6;
    }

    SudokuCell[][] block = new SudokuCell[3][3];

    for (int row = 0; row < 3; row++) {
      for (int column = 0; column < 3; column++) {
        block[row][column] = table[row + posY][column + posX];
      }
    }

    for (int row = 0; row < 3; row++) {
      for (int column = 0; column < 3; column++) {
        Integer cellValue = block[row][column].getCellValue();
        if (existingElement.contains(cellValue)) {
          return false;
        }
        existingElement.add(cellValue);
      }
    }

    return true;
  }
}
