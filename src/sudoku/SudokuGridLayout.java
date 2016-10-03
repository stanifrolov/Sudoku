package sudoku;

import javax.swing.JButton;

public class SudokuGridLayout extends javax.swing.JFrame {
	 
	private static final long serialVersionUID = 1L;

	private javax.swing.JPanel gamePanel = new javax.swing.JPanel();
	private javax.swing.JPanel sudokuBoardPanel = new javax.swing.JPanel();
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

        sudokuBoardPanel.setLayout(new java.awt.GridLayout(9, 9));
        gamePanel.add(sudokuBoardPanel);

        navigationPanel.setLayout(new java.awt.GridLayout(5, 1));
        gamePanel.add(navigationPanel);
        
        this.getContentPane().add(gamePanel);
	}

	public void setupSudokuBoard() {
		ButtonListener buttonListener = new ButtonListener();
        for(int i = 0; i < 81; i++) {
            button[i] = new javax.swing.JButton(Integer.toString(i + 1));
            button[i].addActionListener(buttonListener);
            sudokuBoardPanel.add(button[i]);
        }        
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