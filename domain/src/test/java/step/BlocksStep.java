package step;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import sudoku.field.SudokuCell;
import sudoku.field.structure.Blocks;

/**
 * @author hlay
 * @version 1.0
 */
public class BlocksStep {

  private Blocks blocks;
  private boolean validationResult;

  @Given("^the creation of blocks with the following table$")
  public void createBlocks(DataTable dataTable) {
    SudokuCell[][] sudokuCells = dataTable.asLists()
        .stream()
        .map(rows -> rows.stream()
            .map(String::trim)
            .map(row -> "".equals(row) ? null : Integer.valueOf(row))
            .map(SudokuCell::new)
            .toArray(SudokuCell[]::new)
        ).toArray(SudokuCell[][]::new);

    blocks = new Blocks(sudokuCells);
  }

  @When("^the blocks trigger a validation$")
  public void validateBlock() {
    validationResult = blocks.validate();
  }

  @Then("^the blocks are valid$")
  public void assertBlocksAreValid() {
    assertThat(validationResult).isTrue();
  }

  @Then("^the blocks are invalid$")
  public void theBlocksAreInvalid() {
    assertThat(validationResult).isFalse();
  }

  @Then("throw an exception with the message {string} with the following table")
  public void throwAnExceptionWithTheMessageWithTheFollowingTable(String message,
      DataTable dataTable) {

    assertThatThrownBy(() -> createBlocks(dataTable))
        .isExactlyInstanceOf(IllegalArgumentException.class)
        .hasMessage(message);
  }


  @Then("verify {int} blocks are created")
  public void verifyBlocksAreCreated(int nbBlocs) {
    assertThat(blocks.getBlocks()).hasSize(nbBlocs);
  }
}
