package sudoku.field.structure.validator;

import sudoku.field.structure.Rows;

/**
 * @author hlay
 * @version 1.0
 */
public class RowsValidator implements DistinctValidator, EstimationValidator {

  private final Rows rows;

  public RowsValidator(final Rows rows) {
    this.rows = rows;
  }

  public boolean validate() {
    return DistinctValidator.validateDistinct(rows.getListOfRow()) &&
        EstimationValidator.validateIfHaveAtLeastOneEstimation(rows.getListOfRow()) &&
        EstimationValidator.validateIfMissedValue(rows.getListOfRow());
  }
}
