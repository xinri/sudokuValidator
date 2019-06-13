package sudoku.field.valuetype;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class Blocks {

  private List<SudokuCell[][]> listOfBlocks;

  public Blocks(SudokuCell[][] table) {

    if (table.length == 0) {
      throw new IllegalArgumentException("the blocks shouldn't be empty");
    }

    if (table.length % 3 != 0 || table[0].length % 3 != 0) {
      throw new IllegalArgumentException("the blocks should be a one or multiple 3x3 block");
    }

    listOfBlocks = new ArrayList<>();

    for (int row = 0; row < table.length; row += 3) {
      for (int column = 0; column < table[row].length; column += 3) {
        listOfBlocks.add(new SudokuCell[][]
            {
                {table[row][column], table[row][column + 1], table[row][column + 2]},
                {table[row + 1][column], table[row + 1][column + 1], table[row + 1][column + 2]},
                {table[row + 2][column], table[row + 2][column + 1], table[row + 2][column + 2]}
            });
      }
    }
  }

  public boolean validate() {
    return listOfBlocks.stream()
        .map(this::validateBlock)
        .reduce((prevResult, nextResult) -> prevResult && nextResult)
        .orElse(true);
  }

  private boolean validateBlock(SudokuCell[][] block) {
    return Arrays.stream(block).flatMap(Arrays::stream)
        .filter(NOT_NULL_PREDICATE).distinct().count() == Arrays.stream(block)
        .flatMap(Arrays::stream)
        .filter(NOT_NULL_PREDICATE).count();
  }

  public List<SudokuCell[][]> getBlocks() {
    return Collections.unmodifiableList(listOfBlocks);
  }
}
