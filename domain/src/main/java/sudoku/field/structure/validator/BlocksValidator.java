package sudoku.field.structure.validator;

import static sudoku.field.SudokuCell.NOT_NULL_PREDICATE;

import java.util.Arrays;
import java.util.List;
import sudoku.field.SudokuCell;
import sudoku.field.structure.Blocks;

/**
 * @author hlay
 * @version 1.0
 */
public class BlocksValidator {

  private List<SudokuCell[]> listOfBlocks;

  public BlocksValidator(Blocks blocks) {
    listOfBlocks = blocks.getBlocks();
  }

  public boolean validate() {
    return listOfBlocks.stream()
        .map(this::validateBlock)
        .reduce((prevResult, nextResult) -> prevResult && nextResult)
        .orElse(true);
  }

  private boolean validateBlock(SudokuCell[] block) {
    return Arrays.stream(block)
        .filter(NOT_NULL_PREDICATE).distinct().count() == Arrays.stream(block)
        .filter(NOT_NULL_PREDICATE).count();
  }
}
