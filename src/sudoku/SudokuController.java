package sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static sudoku.Constants.NUMBER_OF_CELLS;
import static sudoku.Constants.NUMBER_OF_POSSIBLE_NUMBERS;

class SudokuController implements ActionListener {

    private SudokuModel sudokuModel;
    private SudokuView sudokuView;
    private SudokuChecker sudokuChecker;

    SudokuController() {
        this.sudokuModel = new SudokuModel();
        this.sudokuView = new SudokuView();
        this.sudokuChecker = new SudokuChecker(this);

        this.sudokuView.addController(this);
    }

    void showSudoku() {
        sudokuView.showLayout();
    }

    int getCellAt(int row, int column) {
        return sudokuModel.getCellAt(row, column);
    }

    void setCellAt(int row, int column, int value) {
        sudokuModel.setCellAt(row, column, value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sudokuView.getCheckSudokuButton()) {
            if (sudokuChecker.isCorrect()) {
                System.out.println("SudokuModel is valid.");
                return;
            } else {
                System.out.println("SudokuModel is not valid.");
                return;
            }
        }

        for (int cell = 0; cell < NUMBER_OF_CELLS; cell++) {
            JButton btn = sudokuView.getCellButtons()[cell];
            if (e.getSource() == btn) {
                System.out.println("Button " + cell + " has been clicked.");
                return;
            }
        }

        for (int cell = 0; cell < NUMBER_OF_CELLS; cell++) {
            for (int i = 0; i < NUMBER_OF_POSSIBLE_NUMBERS; i++) {
                JButton btn = sudokuView.getCellDropdownButtons()[cell][i];
                if (e.getSource() == btn) {
                    System.out.println("DropdownButton " + i + " in the cell " + cell +  " has been clicked.");
                    sudokuModel.setCell(cell, i);
                    return;
                }
            }
        }

    }

}
