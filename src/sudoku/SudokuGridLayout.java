package sudoku;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class SudokuGridLayout extends javax.swing.JFrame {
	 
	private static final long serialVersionUID = 1L;

	private javax.swing.JPanel gamePanel = new javax.swing.JPanel();
	private javax.swing.JPanel sudokuBoardPanel = new javax.swing.JPanel();
	private javax.swing.JPanel[] sudokuBoxPanel = new javax.swing.JPanel[9];
	private javax.swing.JPanel navigationPanel = new javax.swing.JPanel();
 
    private javax.swing.JButton[] button = new javax.swing.JButton[81];
 
    public SudokuGridLayout() { 
        this.setTitle("Sudoku");
    	
    	setup();
        
    	this.setSize(900, 500);
        this.setVisible(true);
    }

	public void setup() {
		setupPanels();
		setupSudokuBoard();
        setupNavigation();
	}
	
	public void setupPanels() {
		gamePanel.setLayout(new java.awt.GridLayout(1, 2));
		
		GridLayout sudokuBoardLayout = new GridLayout(3, 3);
		sudokuBoardLayout.setHgap(5);
		sudokuBoardLayout.setVgap(5);
        sudokuBoardPanel.setLayout(sudokuBoardLayout);
        gamePanel.add(sudokuBoardPanel);
        
        navigationPanel.setLayout(new java.awt.GridLayout(5, 1));
        gamePanel.add(navigationPanel);
        
        for(int i = 0; i < 9; i++) {        	
        	sudokuBoxPanel[i] = new JPanel();
        	sudokuBoxPanel[i].setLayout(new java.awt.GridLayout(3, 3));
        	sudokuBoardPanel.add(sudokuBoxPanel[i]);
        }
        
        this.getContentPane().add(gamePanel);
	}

	public void setupSudokuBoard() {;
		ButtonListener buttonListener = new ButtonListener();
		int boxNumber;
        for(int i = 0; i < 81; i++) {
            button[i] = new javax.swing.JButton(Integer.toString(i + 1));
            button[i].addActionListener(buttonListener);
            
            boxNumber = getBoxNumberFromCell(i);
            sudokuBoxPanel[boxNumber].add(button[i]);
        }
	}

	public int getBoxNumberFromCell(int cellNumber) {
		return cellNumber/9;
	}
    
	public void setupNavigation() {
    	JButton newGameButton = new JButton("Check Sudoku");   
    	navigationPanel.add(newGameButton);
    }
 
    class ButtonListener implements java.awt.event.ActionListener {
    	
        public void actionPerformed(java.awt.event.ActionEvent e) {
            for (int i = 0; i < 81; i++) {
                if(e.getSource() == button[i]){
                    System.out.println("Button " + (i + 1) + " wurde geklickt.");
                }
            }
        }
        
    }
    
}