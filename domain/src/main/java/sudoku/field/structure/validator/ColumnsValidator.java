package sudoku.field.structure.validator;

import sudoku.field.structure.Columns;

/**
 * @author hlay
 * @version 1.0
 */
public class ColumnsValidator implements DistinctValidator, EstimationValidator {

  private final Columns columns;

  public ColumnsValidator(Columns columns) {
    this.columns = columns;
  }

  public boolean validate() {
    return DistinctValidator.validateDistinct(columns.getListOfColumn()) &&
        EstimationValidator.validateIfHaveAtLeastOneEstimation(columns.getListOfColumn()) &&
        EstimationValidator.validateIfMissedValue(columns.getListOfColumn());
  }
}
