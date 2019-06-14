package sudoku.field.valuetype;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import sudoku.field.SudokuCell;

/**
 * @author hlay
 * @version 1.0
 */
public class ColumnsShould {

  @Test
  public void return_true_when_there_is_no_duplicate_value() {
    // given
    Columns columns = new Columns(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(2), new SudokuCell(3), new SudokuCell(4),
        new SudokuCell(5), new SudokuCell(6), new SudokuCell(7),
        new SudokuCell(8), new SudokuCell(9), new SudokuCell(1)
    }});

    // when
    boolean result = columns.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_false_when_there_is_duplicate_value() {
    // given
    Columns columns = new Columns(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(2), new SudokuCell(3), new SudokuCell(4),
        new SudokuCell(5), new SudokuCell(5), new SudokuCell(7),
        new SudokuCell(8), new SudokuCell(9), new SudokuCell(1)
    }});

    // when
    boolean result = columns.validate();

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void return_true_when_there_is_a_empty_cell_with_no_duplicate_value() {
    // given
    Columns columns = new Columns(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(2), new SudokuCell(3), new SudokuCell(4),
        new SudokuCell(5), new SudokuCell(6), new SudokuCell(7),
        new SudokuCell(8), new SudokuCell(null), new SudokuCell(1)
    }});

    // when
    boolean result = columns.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_true_when_there_is_2_empty_cells_with_no_duplicate_value() {
    // given
    Columns columns = new Columns(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(2), new SudokuCell(3), new SudokuCell(4),
        new SudokuCell(5), new SudokuCell(null), new SudokuCell(7),
        new SudokuCell(8), new SudokuCell(null), new SudokuCell(1)
    }});

    // when
    boolean result = columns.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_false_when_there_is_a_empty_cell_with_duplicate_value() {
    // given
    Columns columns = new Columns(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(null), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(2), new SudokuCell(9)
    }});

    // when
    boolean result = columns.validate();

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void should_not_modify_empty_cell_when_we_cannot_estimate_its_value() {
    // given
    SudokuCell emptyCell = new SudokuCell(null);
    Columns columns = new Columns(new SudokuCell[][]{
        {new SudokuCell(1), new SudokuCell(1) },
        {new SudokuCell(2), new SudokuCell(2) },
        {emptyCell,                 new SudokuCell(3) },
        {new SudokuCell(4), new SudokuCell(4) },
        {new SudokuCell(null), new SudokuCell(5) },
        {new SudokuCell(6), new SudokuCell(6) },
        {new SudokuCell(7), new SudokuCell(7) },
        {new SudokuCell(8), new SudokuCell(8) },
        {new SudokuCell(9), new SudokuCell(9) },
    });

    // when
    columns.workOnEmptyCell();

    // then
    assertThat(emptyCell.getCellValue()).isNull();
  }

  @Test
  public void should_modify_empty_cell_when_we_can_estimate_its_value() {
    // given
    SudokuCell emptyCell = new SudokuCell(null);

    Columns columns = new Columns(new SudokuCell[][]{
        {new SudokuCell(1), new SudokuCell(1) },
        {new SudokuCell(2), new SudokuCell(2) },
        {new SudokuCell(3), new SudokuCell(3) },
        {new SudokuCell(4), new SudokuCell(4) },
        {emptyCell,                 new SudokuCell(5) },
        {new SudokuCell(6), new SudokuCell(6) },
        {new SudokuCell(7), new SudokuCell(null) },
        {new SudokuCell(8), new SudokuCell(8) },
        {new SudokuCell(9), new SudokuCell(9) },
    });

    // when
    columns.workOnEmptyCell();

    // then
    assertThat(emptyCell.getCellValue()).isNotNull().isEqualTo(5);
  }
}
