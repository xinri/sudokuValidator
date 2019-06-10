package step;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import sudoku.SudokuField;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuStep {

  private SudokuField sudokuField;
  private boolean validationResult;

  @Given("the sudoku table")
  public void theSudokuTable(DataTable table) {
    int[][] sudokuTable = new int[9][9];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sudokuTable[i][j] = Integer.valueOf(table.cell(i, j));
      }
    }

    sudokuField = new SudokuField(sudokuTable);
  }

  @When("validate the table")
  public void validateTheTable() {
    validationResult = sudokuField.validate();
  }

  @Then("the table is valid")
  public void theTableIsValid() {
    assertThat(validationResult).isTrue();
  }

  @Then("the table is not valid")
  public void theTableIsNotValid() {
    assertThat(validationResult).isFalse();
  }
}
