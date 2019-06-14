package sudoku.field.valuetype;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import sudoku.field.SudokuCell;

public class RowsShould {

  @Test
  public void return_true_when_there_is_no_duplicate_value() {
    // given
    Rows rows = new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }});

    // when
    boolean result = rows.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_false_when_there_is_duplicate_value() {
    // given
    Rows rows = new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }});

    // when
    boolean result = rows.validate();

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void return_true_when_there_is_a_empty_cell_with_no_duplicate_value() {
    // given
    Rows rows = new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(null), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }});

    // when
    boolean result = rows.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_true_when_there_is_2_empty_cells_with_no_duplicate_value() {
    // given
    Rows rows = new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(null), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(null), new SudokuCell(9)
    }});

    // when
    boolean result = rows.validate();

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void return_false_when_there_is_a_empty_cell_with_duplicate_value() {
    // given
    Rows rows = new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(null), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(2), new SudokuCell(9)
    }});

    // when
    boolean result = rows.validate();

    // then
    assertThat(result).isFalse();
  }


  @Test
  public void should_not_modify_empty_cell_when_we_cannot_estimate_its_value() {
    // given
    SudokuCell emptyCell = new SudokuCell(null);
    Rows rows = new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(null), emptyCell, new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }});

    // when
    rows.workOnEmptyCell();

    // then
    assertThat(emptyCell.getCellValue()).isNull();
  }

  @Test
  public void should_modify_empty_cell_when_we_can_estimate_its_value() {
    // given
    SudokuCell emptyCell = new SudokuCell(null);
    Rows rows = new Rows(new SudokuCell[][]{{
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
    }, {
        new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
        new SudokuCell(4), emptyCell, new SudokuCell(6),
        new SudokuCell(7), new SudokuCell(5), new SudokuCell(9)
    }});

    // when
    rows.workOnEmptyCell();

    // then
    assertThat(emptyCell.getCellValue()).isNotNull().isEqualTo(8);
  }
}