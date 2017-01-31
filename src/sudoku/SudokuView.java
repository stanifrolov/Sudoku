package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static sudoku.Constants.*;

public class SudokuView extends JFrame {

    static final long serialVersionUID = 1L;

    private JPanel gamePanel = new JPanel();
    private JPanel sudokuBoardPanel = new JPanel();
    private JPanel navigationPanel = new JPanel();
    private JPanel[] sudokuBoxPanel = new JPanel[NUMBER_OF_BOXES];

    private JButton checkSudokuButton = new JButton();
    private JButton[] cellButtons = new JButton[NUMBER_OF_CELLS];
    private JButton[][] cellDropdownButtons = new JButton[NUMBER_OF_CELLS][NUMBER_OF_POSSIBLE_NUMBERS];

    SudokuView() {
        this.setTitle("Sudoku Game");
        setup();
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
        checkSudokuButton.setText("Check SudokuModel");
        navigationPanel.add(checkSudokuButton);
    }

    private void setupSudokuBoardPanel() {
        sudokuBoardPanel.setLayout(new GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
        setSeparationOfBoxes();
        gamePanel.add(sudokuBoardPanel);
    }

    private void setupNavigationPanel() {
        navigationPanel.setLayout(new GridLayout(5, 1));
        gamePanel.add(navigationPanel);
    }

    private void setupBoxPanel() {
        for (int i = 0; i < NUMBER_OF_BOXES; i++) {
            sudokuBoxPanel[i] = new JPanel();
            sudokuBoxPanel[i].setLayout(new GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
            sudokuBoardPanel.add(sudokuBoxPanel[i]);
        }
    }

    private void setupCellButtons() {
        int boxNumber;
        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            cellButtons[i] = new JButton(Integer.toString(i));
//            cellButtons[i].setText(Integer.toString(i));
            cellButtons[i].setText(" ");

            final JPopupMenu menu = new JPopupMenu();
            for (int j = 0; j < NUMBER_OF_POSSIBLE_NUMBERS; j++) {
                cellDropdownButtons[i][j] = new JButton(Integer.toString(j));
                cellDropdownButtons[i][j].setText(Integer.toString(j));
                cellDropdownButtons[i][j].setActionCommand("cellDropdownButton");
                menu.add(cellDropdownButtons[i][j]);
                int finalI1 = i;
                int finalJ = j;
                cellDropdownButtons[i][j].addActionListener(ev -> {
                    menu.setVisible(false);
                    cellButtons[finalI1].setText(Integer.toString(finalJ));
                });
            }

            int finalI = i;
            cellButtons[i].addActionListener(ev -> {
                menu.show(cellButtons[finalI], 15, 15);
            });

            boxNumber = getBoxFromCell(i);
            sudokuBoxPanel[boxNumber].add(cellButtons[i]);
        }
    }

    private void setSeparationOfBoxes() {
        GridLayout sudokuBoardLayout = (GridLayout) sudokuBoardPanel.getLayout();
        sudokuBoardLayout.setHgap(5);
        sudokuBoardLayout.setVgap(5);
    }

    void showLayout() {
        this.setSize(900, 500);
        this.setVisible(true);
    }

    public int getCellValue(int cellNumber) {
        String cellValue = getCellText(cellNumber);
        if (!cellValue.equals(" ")) {
            return Integer.parseInt(getCellText(cellNumber));
        } else {
            return 0;
        }
    }

    private String getCellText(int cellNumber) {
        return cellButtons[cellNumber].getText();
    }

    private int getBoxFromCell(int cellNumber) {
        return cellNumber / NUMBER_OF_BOXES;
    }

    JButton getCheckSudokuButton() {
        return checkSudokuButton;
    }

    JButton[] getCellButtons() {
        return cellButtons;
    }

    public JButton[][] getCellDropdownButtons() {
        return cellDropdownButtons;
    }

    void addController(ActionListener controller) {
        checkSudokuButton.addActionListener(controller);
        for (JButton btn : cellButtons) {
            btn.addActionListener(controller);
        }
        for (JButton[] cellButton : cellDropdownButtons) {
            for (JButton btn : cellButton) {
                btn.addActionListener(controller);
            }
        }
    }

}
