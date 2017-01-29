package sudoku;

import java.util.ArrayList;
import java.util.List;

import static sudoku.Constants.NUMBER_OF_COLUMNS;
import static sudoku.Constants.NUMBER_OF_ROWS;

class SudokuChecker {

    int[][] board = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    List<Integer> possibleNumbers = new ArrayList<>();

    SudokuChecker() {
        setupListOfPossibleNumbers();
    }

    void setupListOfPossibleNumbers() {
        for (int i = 0; i < 10; i++) {
            this.possibleNumbers.add(i);
        }
    }

    void setupBoard() {
        Sudoku sudoku = new Sudoku();
        int cellNumber = 0;
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                this.board[i][j] = sudoku.getCellValue(cellNumber);
                cellNumber++;
            }
        }
    }

    void setupBoard(Sudoku sudoku) {
        int cellNumber = 0;
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                this.board[i][j] = sudoku.getCellValue(cellNumber);
                cellNumber++;
            }
        }
    }

    boolean isCorrect() {
        return blocksAreCorrect() && rowsAreCorrect();
    }

    boolean rowsAreCorrect() {
        List<Integer> appearedRowNumbers = new ArrayList<>();
        boolean rowNumberIsValid, rowNumberIsDuplicate;

        List<Integer> appearedColumnNumbers = new ArrayList<>();
        boolean columnNumberIsValid, columnNumberIsDuplicate;

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
                rowNumberIsValid = rowNumberIsPossible(column, row);
                rowNumberIsDuplicate = rowNumberIsDuplicate(row, column, appearedRowNumbers);
                if (rowNumberIsValid && !rowNumberIsDuplicate) {
                    if (this.board[row][column] != 0) {
                        appearedRowNumbers.add(this.board[row][column]);
                    }
                } else {
                    return false;
                }

                columnNumberIsValid = columnNumberIsPossible(column, row);
                columnNumberIsDuplicate = columnNumberIsDuplicate(column, row, appearedColumnNumbers);
                if (columnNumberIsValid && !columnNumberIsDuplicate) {
                    if (this.board[column][row] != 0)
                        appearedColumnNumbers.add(this.board[column][row]);
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
                numberIsValid = this.possibleNumbers.contains(this.board[i][j]);
                numberIsDuplicate = listOfAppearedNumbers.contains(this.board[i][j]);
                if (numberIsValid && !numberIsDuplicate) {
                    if (this.board[i][j] != 0)
                        listOfAppearedNumbers.add(this.board[i][j]);
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
                if (this.board[row][column] != 0)
                    appearedRowNumbers.add(this.board[row][column]);
            } else {
                return false;
            }
        }
        return true;
    }

    boolean rowNumberIsDuplicate(int row, int column, List<Integer> appearedRowNumbers) {
        return appearedRowNumbers.contains(this.board[row][column]);
    }

    boolean rowNumberIsPossible(int row, int column) {
        return this.possibleNumbers.contains(this.board[row][column]);
    }

    boolean columnIsCorrect(int column) {
        List<Integer> appearedColumnNumbers;
        appearedColumnNumbers = new ArrayList<>();
        boolean columnNumberIsPossible, columnNumberIsDuplicate;
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            columnNumberIsPossible = columnNumberIsPossible(row, column);
            columnNumberIsDuplicate = columnNumberIsDuplicate(row, column, appearedColumnNumbers);
            if (columnNumberIsPossible && !columnNumberIsDuplicate) {
                if (this.board[row][column] != 0)
                    appearedColumnNumbers.add(this.board[row][column]);
            } else {
                return false;
            }
        }
        return true;
    }

    boolean columnNumberIsDuplicate(int row, int column, List<Integer> appearedColumnNumbers) {
        return appearedColumnNumbers.contains(this.board[row][column]);
    }

    boolean columnNumberIsPossible(int row, int column) {
        return this.possibleNumbers.contains(this.board[row][column]);
    }

    void printSudokuBoard() {
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

}
