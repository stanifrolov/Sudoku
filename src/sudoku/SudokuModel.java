package sudoku;

import static sudoku.Constants.*;

public class SudokuModel {

    private int[][] sudokuBoard = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    SudokuModel() {
        initSudokuBoard();
    }

    private void initSudokuBoard() {
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                sudokuBoard[i][j] = 0;
            }
        }
    }

    int getCellAt(int row, int column) {
        return sudokuBoard[row][column];
    }

    void setCellAt(int row, int column, int value) {
        sudokuBoard[row][column] = value;
    }

    int getCellAt(int cellNumber) {
        return getCellAt(getRowFromCell(cellNumber), getColumnFromCell(cellNumber));
    }

    void setCellAt(int cellNumber, int value) {
        sudokuBoard[getRowFromCell(cellNumber)][getColumnFromCell(cellNumber)] = value;
    }

    public int getColumnFromCell(int cellNumber) {
        return  0;
    }

    public int getRowFromCell(int cellNumber) {
        int box = getBoxFromCell(cellNumber);
        return box + (cellNumber % 9);
    }

    public int getBoxFromCell(int cellNumber) {
        return cellNumber / 9;
    }

    public int[][] getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(int[][] sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public SudokuModel getSudokuModel() {
        return SudokuModel.this;
    }

}