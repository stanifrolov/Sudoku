package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static sudoku.Constants.*;

class SudokuView extends JFrame {

    static final long serialVersionUID = 1L;
    private JPanel gamePanel = new JPanel();

    private JPanel sudokuBoardPanel = new JPanel();

    private JPanel navigationPanel = new JPanel();
    private JPanel[] sudokuBoxPanel = new JPanel[NUMBER_OF_BOXES];
    private JButton checkSudokuButton = new JButton();
    private JButton[] cellButtons = new JButton[NUMBER_OF_CELLS];

    private JButton[][] cellDropdownButtons = new JButton[NUMBER_OF_CELLS][NUMBER_OF_POSSIBLE_NUMBERS];

    private static final int DROPDOWN_POS_X = 15;
    private static final int DROPDOWN_POS_Y = 15;
    private static final int BOARD_LAYOUT_GAP = 5;

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

    private void setupSudokuBoardPanel() {
        sudokuBoardPanel.setLayout(new GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
        setSeparationOfBoxes();

        gamePanel.add(sudokuBoardPanel);
    }

    private void setSeparationOfBoxes() {
        GridLayout sudokuBoardLayout = (GridLayout) sudokuBoardPanel.getLayout();

        sudokuBoardLayout.setHgap(BOARD_LAYOUT_GAP);
        sudokuBoardLayout.setVgap(BOARD_LAYOUT_GAP);
    }

    private void setupNavigationPanel() {
        navigationPanel.setLayout(new GridLayout(5, 1));

        gamePanel.add(navigationPanel);
    }

    private void setupSudokuBoard() {
        setupBoxPanel();
        setupCellButtons();
    }

    private void setupBoxPanel() {
        for (int i = 0; i < NUMBER_OF_BOXES; i++) {
            sudokuBoxPanel[i] = new JPanel();
            sudokuBoxPanel[i].setLayout(new GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
            sudokuBoardPanel.add(sudokuBoxPanel[i]);
        }
    }

    private void setupCellButtons() {
        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            cellButtons[i] = new JButton(Integer.toString(i));
            cellButtons[i].setText(" ");

            final JPopupMenu menu = new JPopupMenu();
            setupCellDropdownButtons(i, menu);

            int final_i = i;
            cellButtons[i].addActionListener(ev -> {
                menu.show(cellButtons[final_i], DROPDOWN_POS_X, DROPDOWN_POS_Y);
            });

            int boxNumber = getBoxFromCell(i);
            sudokuBoxPanel[boxNumber].add(cellButtons[i]);
        }
    }

    private void setupCellDropdownButtons(int cell, JPopupMenu menu) {
        for (int i = 0; i < NUMBER_OF_POSSIBLE_NUMBERS; i++) {
            cellDropdownButtons[cell][i] = new JButton(Integer.toString(i));
            cellDropdownButtons[cell][i].setText(Integer.toString(i));
            cellDropdownButtons[cell][i].setActionCommand("cellDropdownButton");
            menu.add(cellDropdownButtons[cell][i]);

            int final_i = i;
            cellDropdownButtons[cell][i].addActionListener((ActionEvent ev) -> {
                menu.setVisible(false);
                cellButtons[cell].setText(Integer.toString(final_i));
            });
        }
    }

    private int getBoxFromCell(int cellNumber) {
        return cellNumber / NUMBER_OF_BOXES;
    }

    private void setupNavigation() {
        checkSudokuButton.setText("Check SudokuModel");
        navigationPanel.add(checkSudokuButton);
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

    void showLayout() {
        this.setSize(900, 500);
        this.setVisible(true);
    }

    int getCellValue(int cellNumber) {
        String cellValue = getCellText(cellNumber);
        if (!cellValue.equals(" ")) {
            return Integer.parseInt(getCellText(cellNumber));
        } else {
            return 0;
        }
    }

    String getCellText(int cellNumber) {
        return cellButtons[cellNumber].getText();
    }

    JButton getCheckSudokuButton() {
        return checkSudokuButton;
    }

    JButton[] getCellButtons() {
        return cellButtons;
    }

    JButton[][] getCellDropdownButtons() {
        return cellDropdownButtons;
    }

}
