package csv;

import adapter.CsvFileAdapter;
import adapter.exception.EmptyFileException;
import java.io.IOException;

/**
 * @author hlay
 * @version 1.0
 */
public class Sudoku {

  public static void main(String[] args) {
    if (args.length != 1) {
      errorMessageHandler("Error : the program must be called with 1 filename");
    }

    try {
      if (new CsvFileAdapter().validateFile(args[0])) {
        System.out.println("0");
        System.exit(0);
      }

      errorMessageHandler("Validation error : Invalid Sudoku Grid");
    } catch (EmptyFileException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      errorMessageHandler(e.getMessage());
    } finally {
      errorMessageHandler("");
    }
  }

  private static void errorMessageHandler(final String message) {
    System.out.println("-1");
    System.out.println(message);
    System.exit(-1);
  }
}
