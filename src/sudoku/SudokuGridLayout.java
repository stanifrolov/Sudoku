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

	private JPanel gamePanel = new JPanel();
	private JPanel sudokuBoardPanel = new JPanel();
	private JPanel[] sudokuBoxPanel = new JPanel[NUMBER_OF_BOXES];
	private JPanel navigationPanel = new JPanel();

	public JButton[] cellButton = new JButton[NUMBER_OF_CELLS];
	private JButton checkSudokuButton = new JButton();

	public SudokuGridLayout() { 
		this.setTitle("Sudoku");
		setup();
	}

	public void showLayout() {
		this.setSize(900, 500);
		this.setVisible(true);
	}

	private void setup() {
		setupPanels();
		setupSudokuBoard();
		setupNavigation();
	}

	private void setupPanels() {
		gamePanel.setLayout(new java.awt.GridLayout(1, 2));

		setupSudokuBoardPanel();
		setupNavigationPanel();

		this.getContentPane().add(gamePanel);
	}
	
	private void setupSudokuBoard() {
		setupBoxPanel();
		setupCellButtons();
	}
	
	private void setupNavigation() {
		ButtonListener buttonListener = new ButtonListener();
		checkSudokuButton.setText("Check Sudoku");
		checkSudokuButton.addActionListener(buttonListener);
		navigationPanel.add(checkSudokuButton);
	}
	
	private void setupSudokuBoardPanel() {
		sudokuBoardPanel.setLayout(new java.awt.GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
		setSeperationOfBoxes();
		gamePanel.add(sudokuBoardPanel);
	}
	
	private void setupNavigationPanel() {
		navigationPanel.setLayout(new java.awt.GridLayout(5, 1));
		gamePanel.add(navigationPanel);
	}
	
	private void setupBoxPanel() {
		for(int i = 0; i < NUMBER_OF_BOXES; i++) {        	
			sudokuBoxPanel[i] = new JPanel();
			sudokuBoxPanel[i].setLayout(new java.awt.GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
			sudokuBoardPanel.add(sudokuBoxPanel[i]);
		}
	}
	
	private void setupCellButtons() {
		ButtonListener buttonListener = new ButtonListener();
		int boxNumber;
		for(int i = 0; i < NUMBER_OF_CELLS; i++) {
			cellButton[i] = new javax.swing.JButton(Integer.toString(i));
			cellButton[i].addActionListener(buttonListener);
			
			boxNumber = getBoxNumberFromCell(i);
			sudokuBoxPanel[boxNumber].add(cellButton[i]);
		}
	}

	private void setSeperationOfBoxes() {
		GridLayout sudokuBoardLayout = (GridLayout) sudokuBoardPanel.getLayout();
		sudokuBoardLayout.setHgap(5);
		sudokuBoardLayout.setVgap(5);
	}

	private int getBoxNumberFromCell(int cellNumber) {
		return cellNumber/NUMBER_OF_BOXES;
	}

	class ButtonListener implements java.awt.event.ActionListener {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			if(e.getSource() == checkSudokuButton) {
				System.out.println("Check Sudoku Button has been clicked.");
			}
			for (int i = 0; i < NUMBER_OF_CELLS; i++) {
				if(e.getSource() == cellButton[i]){
					System.out.println("Button " + i + " has been clicked.");
				}
			}
		}

	}

}