package adapter;

import adapter.exception.EmptyFileException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import sudoku.SudokuGrid;
import sudoku.field.valuetype.SudokuGridInitializer;

/**
 * @author hlay
 * @version 1.0
 */
public class CsvFileAdapter {

  private static final String COMMA_DELIMITER = ",";

  public boolean validateFile(final String csvFileName) throws
      EmptyFileException, IOException, NumberFormatException {

    InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(csvFileName);

    if (resourceAsStream == null) {
      File file = new File(csvFileName);

      if (!file.exists()) {
        throw new FileNotFoundException("The file " + csvFileName + " cannot be found");
      }
      resourceAsStream = new FileInputStream(file);
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {

      String line;
      List<List<Integer>> tableRepresentation = new ArrayList<>();
      while ((line = br.readLine()) != null) {
        String[] values = line.split(COMMA_DELIMITER);

        tableRepresentation.add(
            Arrays.stream(values)
                .map(String::trim)
                .map(value -> value.isEmpty() ? null : Integer.valueOf(value))
                .collect(Collectors.toList()));
      }

      if (tableRepresentation.isEmpty()) {
        throw new EmptyFileException();
      }

      return new SudokuGrid(
          new SudokuGridInitializer(tableRepresentation.stream()
              .map(columns -> columns.stream().toArray(Integer[]::new))
              .toArray(Integer[][]::new)))
          .validate();
    }
  }
}
