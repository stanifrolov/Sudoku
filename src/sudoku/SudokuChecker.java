package sudoku;

import java.util.ArrayList;
import java.util.List;

import static sudoku.Constants.NUMBER_OF_COLUMNS;
import static sudoku.Constants.NUMBER_OF_ROWS;

class SudokuChecker {

    private SudokuController sudokuController;
    private List<Integer> possibleNumbers = new ArrayList<>();

    SudokuChecker(SudokuController sudokuController) {
        this.sudokuController = sudokuController;
        setupListOfPossibleNumbers();
    }

    SudokuChecker() {
        this.sudokuController = new SudokuController();
        setupListOfPossibleNumbers();
    }

    private void setupListOfPossibleNumbers() {
        for (int i = 0; i < 10; i++) {
            this.possibleNumbers.add(i);
        }
    }

    private boolean columnNumberIsDuplicate(int row, int column, List<Integer> appearedColumnNumbers) {
        return appearedColumnNumbers.contains(sudokuController.getCellAt(row, column));
    }

    private boolean columnNumberIsPossible(int row, int column) {
        return this.possibleNumbers.contains(sudokuController.getCellAt(row, column));
    }

    private boolean rowNumberIsDuplicate(int row, int column, List<Integer> appearedRowNumbers) {
        return appearedRowNumbers.contains(sudokuController.getCellAt(row, column));
    }

    private boolean rowNumberIsPossible(int row, int column) {
        return this.possibleNumbers.contains(sudokuController.getCellAt(row, column));
    }

    SudokuController getSudokuController() {
        return sudokuController;
    }

    void printSudokuBoard() {
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
                System.out.print(sudokuController.getCellAt(row, column));
            }
            System.out.println();
        }
    }

    public void setSudokuController(SudokuController sudokuController) {
        this.sudokuController = sudokuController;
    }

    boolean isCorrect() {
        return rowsAndColumnsAreCorrect() && blocksAreCorrect();
    }

    boolean rowsAndColumnsAreCorrect() {
        List<Integer> appearedRowNumbers = new ArrayList<>();
        boolean rowNumberIsValid, rowNumberIsDuplicate;

        List<Integer> appearedColumnNumbers = new ArrayList<>();
        boolean columnNumberIsValid, columnNumberIsDuplicate;

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
                rowNumberIsValid = rowNumberIsPossible(column, row);
                rowNumberIsDuplicate = rowNumberIsDuplicate(row, column, appearedRowNumbers);
                if (rowNumberIsValid && !rowNumberIsDuplicate) {
                    int currentRowNumber = sudokuController.getCellAt(row, column);
                    if (currentRowNumber != 0) {
                        appearedRowNumbers.add(currentRowNumber);
                    }
                } else {
                    return false;
                }

                columnNumberIsValid = columnNumberIsPossible(column, row);
                columnNumberIsDuplicate = columnNumberIsDuplicate(column, row, appearedColumnNumbers);
                if (columnNumberIsValid && !columnNumberIsDuplicate) {
                    int currentColumnNumber = sudokuController.getCellAt(column, row);
                    if (currentColumnNumber != 0)
                        appearedColumnNumbers.add(currentColumnNumber);
                } else {
                    return false;
                }
            }
            appearedRowNumbers.clear();
            appearedColumnNumbers.clear();
        }
        return true;
    }

    boolean blocksAreCorrect() {
        boolean blocksAreCorrect;
        for (int row = 0; row < NUMBER_OF_ROWS; row = row + 3) {
            for (int column = 0; column < NUMBER_OF_COLUMNS; column = column + 3) {
                blocksAreCorrect = blockIsCorrect(row, column);
                if (!blocksAreCorrect) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean blockIsCorrect(int row, int column) {
        int rowStart = 3 * Math.round(row / 3);
        int columnStart = 3 * Math.round(column / 3);
        List<Integer> listOfAppearedNumbers = new ArrayList<>();
        boolean numberIsValid, numberIsDuplicate;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = columnStart; j < columnStart + 3; j++) {
                int currentNumber = sudokuController.getCellAt(i, j);
                numberIsValid = this.possibleNumbers.contains(currentNumber);
                numberIsDuplicate = listOfAppearedNumbers.contains(currentNumber);
                if (numberIsValid && !numberIsDuplicate) {
                    if (currentNumber != 0)
                        listOfAppearedNumbers.add(currentNumber);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    boolean rowIsCorrect(int row) {
        List<Integer> appearedRowNumbers = new ArrayList<>();
        boolean rowNumberIsValid, rowNumberIsDuplicate;
        for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
            rowNumberIsValid = rowNumberIsPossible(row, column);
            rowNumberIsDuplicate = rowNumberIsDuplicate(row, column, appearedRowNumbers);
            if (rowNumberIsValid && !rowNumberIsDuplicate) {
                if (sudokuController.getCellAt(row, column) != 0)
                    appearedRowNumbers.add(sudokuController.getCellAt(row, column));
            } else {
                return false;
            }
        }
        return true;
    }

    boolean columnIsCorrect(int column) {
        List<Integer> appearedColumnNumbers;
        appearedColumnNumbers = new ArrayList<>();
        boolean columnNumberIsPossible, columnNumberIsDuplicate;
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            columnNumberIsPossible = columnNumberIsPossible(row, column);
            columnNumberIsDuplicate = columnNumberIsDuplicate(row, column, appearedColumnNumbers);
            if (columnNumberIsPossible && !columnNumberIsDuplicate) {
                if (sudokuController.getCellAt(row, column) != 0)
                    appearedColumnNumbers.add(sudokuController.getCellAt(row, column));
            } else {
                return false;
            }
        }
        return true;
    }

}
