package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static sudoku.Constants.NUMBER_OF_CELLS;
import static sudoku.Constants.NUMBER_OF_POSSIBLE_NUMBERS;

public class SudokuController implements ActionListener {

    private SudokuModel sudokuModel;
    private SudokuView sudokuView;
    private SudokuChecker sudokuChecker = new SudokuChecker(this);

    SudokuController(SudokuModel sudokuModel, SudokuView sudokuView) {
        this.sudokuModel = sudokuModel;
        this.sudokuView = sudokuView;
    }

    SudokuController() {
        this.sudokuModel = new SudokuModel();
        this.sudokuView = new SudokuView();
    }

    public SudokuModel getSudokuModel() {
        return sudokuModel;
    }

    public void setSudokuModel(SudokuModel sudokuModel) {
        this.sudokuModel = sudokuModel;
    }

    public SudokuView getSudokuView() {
        return sudokuView;
    }

    public void setSudokuView(SudokuView sudokuView) {
        this.sudokuView = sudokuView;
    }

    public void showSudoku() {
        sudokuView.showLayout();
    }

    public int getCellAt(int row, int column) {
        return sudokuModel.getCellAt(row, column);
    }

    public void setCellAt(int row, int column, int value) {
        sudokuModel.setCellAt(row, column, value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sudokuView.getCheckSudokuButton()) {
            if (sudokuChecker.isCorrect()) {
                System.out.println("SudokuModel is valid.");
            } else {
                System.out.println("SudokuModel is not valid.");
            }
            return;
        }

        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            if (e.getSource() == sudokuView.getCellButtons()[i]) {
                System.out.println("Button " + i + " has been clicked.");
                return;
            }
        }

        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            for (int j = 0; j < NUMBER_OF_POSSIBLE_NUMBERS; j++) {
                if (e.getSource() == sudokuView.getCellDropdownButtons()[i][j]) {
                    System.out.println("DropdownButton " + (j + 1) + " in the cell " + i +  " has been clicked.");
                    sudokuModel.setCellAt(i, j + 1);
                    return;
                }
            }
        }

    }

}
