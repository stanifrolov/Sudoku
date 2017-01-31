package sudoku;

public class Main {

    public static void main(String[] args) {
        SudokuModel sudokuModel = new SudokuModel();
        SudokuView sudokuView = new SudokuView();
        SudokuController sudokuController = new SudokuController(sudokuModel, sudokuView);
        sudokuView.addController(sudokuController);
        sudokuController.showSudoku();
    }
}
