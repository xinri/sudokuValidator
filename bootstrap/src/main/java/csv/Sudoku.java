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
      System.out.println("Error : the program must be called with 1 filename");
      System.exit(-1);
    }

    try {
      if (new CsvFileAdapter().validateFile(args[0])) {
        System.exit(0);
      }

      System.out.println("Validation error, the table has errors");
      System.exit(-1);
    } catch (EmptyFileException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } finally {
      System.exit(-1);
    }
  }
}
