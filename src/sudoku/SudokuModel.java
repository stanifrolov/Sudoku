package sudoku;

import java.util.Observable;
import static sudoku.Constants.*;

public class SudokuModel extends Observable {

    private int[][] sudokuBoard = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    SudokuModel() {
        this.addObserver(new SudokuView());
        initSudokuBoard();
    }

    SudokuModel(SudokuView sudokuView) {
        this.addObserver(sudokuView);
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
        this.setChanged();
        this.notifyObservers();
    }

    void setCell(int cellNumber, int value) {
        int row = getRowFromCell(cellNumber);
        int column = getColumnFromCell(cellNumber);
        setCellAt(row, column, value);
    }

    int getRowFromCell(int cellNumber) {
        int box = getBoxFromCell(cellNumber);
        int firstRowOfBox = getFirstRowOfBox(box);
        return firstRowOfBox + (cellNumber / 3 % 3);
    }

    int getFirstRowOfBox(int box) {
        return (box / 3) + (2*(box / 3));
    }

    int getColumnFromCell(int cellNumber) {
        int box = getBoxFromCell(cellNumber);
        int firstColumnOfBox = getFirstColumnOfBox(box);
        return firstColumnOfBox + (cellNumber % 3);
    }

    int getFirstColumnOfBox(int box) {
        return (box % 3) + (2*(box % 3));
    }

    int getBoxFromCell(int cellNumber) {
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