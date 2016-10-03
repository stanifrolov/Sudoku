package sudoku;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SudokuFrame {
	
    public JFrame createSudokoFrame() {
        JFrame sudokuFrame = new JFrame("Sudoku");        
        sudokuFrame.setSize(500, 500);
        
        JPanel panel = new JPanel();
        
        String numbersList[] = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        sudokuFrame.add(panel);
        sudokuFrame.setVisible(true);
        
        return sudokuFrame;
    }
   
}