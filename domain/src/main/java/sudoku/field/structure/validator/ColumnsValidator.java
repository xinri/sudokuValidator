package sudoku.field.structure.validator;

import sudoku.field.structure.Columns;

/**
 * @author hlay
 * @version 1.0
 */
public class ColumnsValidator implements DistinctValidator {

  private final Columns columns;

  public ColumnsValidator(Columns columns) {
    this.columns = columns;
  }

  public boolean validate() {
    return DistinctValidator.validateDistinct(columns.getListOfColumn());
  }
}
