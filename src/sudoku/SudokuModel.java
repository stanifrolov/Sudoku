package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static sudoku.Constants.*;

class Sudoku extends JFrame {

    static final long serialVersionUID = 1L;

    JPanel gamePanel = new JPanel();
    JPanel sudokuBoardPanel = new JPanel();
    JPanel[] sudokuBoxPanel = new JPanel[NUMBER_OF_BOXES];
    JPanel navigationPanel = new JPanel();

    JButton[] cellButton = new JButton[NUMBER_OF_CELLS];
    JButton checkSudokuButton = new JButton();

    Sudoku() {
        this.setTitle("Sudoku");
        setup();
    }

    void startSudoku() {
        showLayout();
    }

    void showLayout() {
        this.setSize(900, 500);
        this.setVisible(true);
    }

    void setup() {
        setupPanels();
        setupSudokuBoard();
        setupNavigation();
    }

    void setupPanels() {
        gamePanel.setLayout(new java.awt.GridLayout(1, 2));

        setupSudokuBoardPanel();
        setupNavigationPanel();

        this.getContentPane().add(gamePanel);
    }

    void setupSudokuBoard() {
        setupBoxPanel();
        setupCellButtons();
    }

    void setupNavigation() {
        ButtonListener buttonListener = new ButtonListener();
        checkSudokuButton.setText("Check Sudoku");
        checkSudokuButton.addActionListener(buttonListener);
        navigationPanel.add(checkSudokuButton);
    }

    void setupSudokuBoardPanel() {
        sudokuBoardPanel.setLayout(new GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
        setSeparationOfBoxes();
        gamePanel.add(sudokuBoardPanel);
    }

    void setupNavigationPanel() {
        navigationPanel.setLayout(new GridLayout(5, 1));
        gamePanel.add(navigationPanel);
    }

    void setupBoxPanel() {
        for (int i = 0; i < NUMBER_OF_BOXES; i++) {
            sudokuBoxPanel[i] = new JPanel();
            sudokuBoxPanel[i].setLayout(new GridLayout(ORDER_OF_SUDOKU, ORDER_OF_SUDOKU));
            sudokuBoardPanel.add(sudokuBoxPanel[i]);
        }
    }

    void setupCellButtons() {
        ButtonListener buttonListener = new ButtonListener();
        int boxNumber;
        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            cellButton[i] = new JButton(Integer.toString(i));
            cellButton[i].addActionListener(buttonListener);
            cellButton[i].setText(" ");

            final JPopupMenu menu = new JPopupMenu();
            for (int j = 1; j < 10; j++) {
                JButton btn = new JButton(Integer.toString(j));
                btn.setActionCommand("number");
                btn.addActionListener(buttonListener);
                menu.add(btn);
                int finalI1 = i;
                int finalJ = j;
                btn.addActionListener(ev -> {
                    menu.setVisible(false);
                    cellButton[finalI1].setText(Integer.toString(finalJ));
                });
            }

            int finalI = i;
            cellButton[i].addActionListener(ev -> {
                menu.show(cellButton[finalI], 15, 15);
            });

            boxNumber = getBoxNumberFromCell(i);
            sudokuBoxPanel[boxNumber].add(cellButton[i]);
        }
    }

    void setSeparationOfBoxes() {
        GridLayout sudokuBoardLayout = (GridLayout) sudokuBoardPanel.getLayout();
        sudokuBoardLayout.setHgap(5);
        sudokuBoardLayout.setVgap(5);
    }

    int getBoxNumberFromCell(int cellNumber) {
        return cellNumber / NUMBER_OF_BOXES;
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
        return cellButton[cellNumber].getText();
    }

    Sudoku getOuter() {
        return Sudoku.this;
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == checkSudokuButton) {
                SudokuChecker sudokuChecker = new SudokuChecker();
                sudokuChecker.setupBoard(getOuter());
                if (sudokuChecker.isCorrect()) {
                    System.out.println("Sudoku is valid.");
                } else {
                    System.out.println("Sudoku is not valid.");
                }
            }

            if (e.getActionCommand().contentEquals("number")) {
//                System.out.println("Number was clicked");
            }

            for (int i = 0; i < NUMBER_OF_CELLS; i++) {
                if (e.getSource() == cellButton[i]) {
//                    System.out.println("Button " + i + " has been clicked.");
                }
            }
        }

    }

}