package sudoku.field.structure.validator;

import sudoku.field.structure.Blocks;

/**
 * @author hlay
 * @version 1.0
 */
public class BlocksValidator implements DistinctValidator, EstimationValidator {

  private Blocks blocks;

  public BlocksValidator(Blocks blocks) {
    this.blocks = blocks;
  }

  public boolean validate() {
    return DistinctValidator.validateDistinct(blocks.getBlocks()) &&
        EstimationValidator.validateIfHaveAtLeastOneEstimation(blocks.getBlocks())
        /*&& EstimationValidator.validateIfMissedValue(blocks.getBlocks())*/;
  }
}
