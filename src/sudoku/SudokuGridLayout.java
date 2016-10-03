package sudoku;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static sudoku.Constants.NUMBER_OF_BOXES;
import static sudoku.Constants.NUMBER_OF_CELLS;
import static sudoku.Constants.ORDER_OF_SUDOKU;;

public class SudokuGridLayout extends JFrame {

	private static final long serialVersionUID = 1L;

	private javax.swing.JPanel gamePanel = new javax.swing.JPanel();
	private javax.swing.JPanel sudokuBoardPanel = new javax.swing.JPanel();
	private javax.swing.JPanel[] sudokuBoxPanel = new javax.swing.JPanel[NUMBER_OF_BOXES];
	private javax.swing.JPanel navigationPanel = new javax.swing.JPanel();

	private javax.swing.JButton[] button = new javax.swing.JButton[NUMBER_OF_CELLS];

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

		setupSudokuBoardPanel();
		setupNavigationPanel();

		this.getContentPane().add(gamePanel);
	}
	
	public void setupSudokuBoard() {
		setupBoxPanel();
		setupButtons();
	}
	
	public void setupNavigation() {
		JButton newGameButton = new JButton("Check Sudoku");   
		navigationPanel.add(newGameButton);
	}
	
	public void setupSudokuBoardPanel() {
		sudokuBoardPanel.setLayout(new java.awt.GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
		setSeperationOfBoxes();
		gamePanel.add(sudokuBoardPanel);
	}
	
	public void setupNavigationPanel() {
		navigationPanel.setLayout(new java.awt.GridLayout(5, 1));
		gamePanel.add(navigationPanel);
	}
	
	public void setupBoxPanel() {
		for(int i = 0; i < NUMBER_OF_BOXES; i++) {        	
			sudokuBoxPanel[i] = new JPanel();
			sudokuBoxPanel[i].setLayout(new java.awt.GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
			sudokuBoardPanel.add(sudokuBoxPanel[i]);
		}
	}
	
	public void setupButtons() {
		ButtonListener buttonListener = new ButtonListener();
		int boxNumber;
		for(int i = 0; i < NUMBER_OF_CELLS; i++) {
			button[i] = new javax.swing.JButton(Integer.toString(i + 1));
			button[i].addActionListener(buttonListener);
			
			boxNumber = getBoxNumberFromCell(i);
			sudokuBoxPanel[boxNumber].add(button[i]);
		}
	}

	public void setSeperationOfBoxes() {
		GridLayout sudokuBoardLayout = (GridLayout) sudokuBoardPanel.getLayout();
		sudokuBoardLayout.setHgap(5);
		sudokuBoardLayout.setVgap(5);
	}

	public int getBoxNumberFromCell(int cellNumber) {
		return cellNumber/NUMBER_OF_BOXES;
	}

	class ButtonListener implements java.awt.event.ActionListener {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			for (int i = 0; i < NUMBER_OF_CELLS; i++) {
				if(e.getSource() == button[i]){
					System.out.println("Button " + (i + 1) + " wurde geklickt.");
				}
			}
		}

	}

}