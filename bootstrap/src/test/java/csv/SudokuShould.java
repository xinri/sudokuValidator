package csv;

import static org.assertj.core.api.Assertions.assertThat;

import csv.ExitDeniedSecurityManager.ExitSecurityException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author hlay
 * @version 1.0
 */
public class SudokuShould {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;
  private final ExitDeniedSecurityManager exitSecManager = new ExitDeniedSecurityManager();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
    System.setSecurityManager(exitSecManager);
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  // FIXME : test exit with -1 => need to find a solution in order to no break maven test
  @Ignore
  @Test
  public void return_error_file_when_the_main_is_called_without_a_filename() {

    try {
      Sudoku.main(new String[]{});
    } catch (ExitSecurityException e) {
      assertThat(outContent.toString()).isEqualTo("-1" + System.lineSeparator() +
          "Error : the program must be called with 1 filename" + System.lineSeparator());
      assertThat(e.getStatus()).isEqualTo(-1);
    }
  }
}

