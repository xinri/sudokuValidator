package sudoku.field.structure;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import sudoku.field.SudokuCell;

public class RowsShould {

  @Test
  public void return_a_list_of_row_when_the_row_are_created_with_an_array_of_sudoku_cell() {
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
    List<SudokuCell[]> result = rows.getListOfRow();

    // then
    List<SudokuCell[]> expectedListOfRow = Arrays.asList(
        new SudokuCell[]{
            new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
            new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
            new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
        },
        new SudokuCell[]{
            new SudokuCell(1), new SudokuCell(2), new SudokuCell(3),
            new SudokuCell(4), new SudokuCell(5), new SudokuCell(6),
            new SudokuCell(7), new SudokuCell(8), new SudokuCell(9)
        });

    assertThat(result).containsExactlyElementsOf(expectedListOfRow);
  }
}