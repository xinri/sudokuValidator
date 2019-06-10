package adapter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import adapter.exception.EmptyFileException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author hlay
 * @version 1.0
 */
public class CsvFileAdapterShould {

  @Test
  public void throw_an_exception_when_the_file_does_not_exist() {
    assertThatThrownBy(
        () -> new CsvFileAdapter().validateFile("notExistingFile.txt"))
        .isInstanceOf(FileNotFoundException.class)
        .hasMessage("The file notExistingFile.txt cannot be found");
  }

  @Test
  public void throw_an_exception_when_the_file_is_empty() {
    // when and then
    assertThatThrownBy(() -> new CsvFileAdapter().validateFile("emptyFile.txt"))
        .isInstanceOf(EmptyFileException.class)
        .hasMessage("The file is empty");
  }

  @Test
  public void throw_an_exception_when_the_file_contains_not_number_value() {
    // when and then
    assertThatThrownBy(
        () -> new CsvFileAdapter().validateFile("containsNotNumberValue.txt"))
        .isExactlyInstanceOf(NumberFormatException.class)
        .hasMessage("For input string: \"a\"");
  }

  @Test
  public void throw_an_exception_when_the_file_has_not_the_correct_size() {
    // when and then
    assertThatThrownBy(
        () -> new CsvFileAdapter().validateFile("gridNotCorrectSize.txt"))
          .isExactlyInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void return_false_for_a_non_valid_file() throws IOException, EmptyFileException {
    // when
    boolean result = new CsvFileAdapter().validateFile("nonValidFile.txt");

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void return_true_for_a_valid_file() throws IOException, EmptyFileException {
    // when
    boolean result = new CsvFileAdapter().validateFile("validFile.txt");

    // then
    assertThat(result).isTrue();
  }

  // TODO : uncomment after having the answer
  @Ignore
  @Test
  public void return_true_for_a_valid_file_with_a_hole() throws IOException, EmptyFileException {
    // when
    boolean result = new CsvFileAdapter().validateFile("validFileWithAHole.txt");

    // then
    assertThat(result).isTrue();
  }
}
