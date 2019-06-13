Create a command line tool (running on jvm) for validating a standard 9x9 Sudoku puzzle:

Command line: validate.bat puzzleName.txt

File format: csv format each line representing a row e.g.:

```
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
```

The program should return 0 (VALID) or non-zero (INVALID) value with an error text on stdout (in case of
an invalid solution or file).

### INSTRUCTION


## In order to build, please use 

mvn clean install 

## in order to generate report

mvn surefire-report:report

## in order to launch

As it said, please use validate.bat or validate.sh

