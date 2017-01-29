package sudoku;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class SudokuCheckerTest {

    public SudokuChecker sudokuChecker;

    @Before
    public void setUp() {
        sudokuChecker = new SudokuChecker();
    }

    @Test
    public void testIsCorrect(){
        sudokuChecker.board[0][2] = 1;
        sudokuChecker.board[4][2] = 1;
        assertTrue(sudokuChecker.blocksAreCorrect());
        assertFalse(sudokuChecker.columnIsCorrect(2));
        assertFalse(sudokuChecker.isCorrect());
    }

    @Test
    public void testRowsHaveDuplicate() {
        sudokuChecker.board[0][0] = 1;
        sudokuChecker.board[0][1] = 1;
        assertFalse(sudokuChecker.rowIsCorrect(0));
    }

    @Test
    public void testRowsWithoutDuplicate() {
        sudokuChecker.board[0][0] = 1;
        sudokuChecker.board[1][0] = 1;
        assertTrue(sudokuChecker.rowIsCorrect(0));
    }

    @Test
    public void testColumnsHaveDuplicate() {
        sudokuChecker.board[0][0] = 1;
        sudokuChecker.board[1][0] = 1;
        assertFalse(sudokuChecker.columnIsCorrect(0));
    }

    @Test
    public void testColumnsWithoutDuplicate() {
        sudokuChecker.board[0][0] = 1;
        sudokuChecker.board[1][1] = 1;
        assertTrue(sudokuChecker.columnIsCorrect(0));

    }

    @Test
    public void testRowIsCorrect() {
        Random rand = new Random();
        int randomRow = rand.nextInt(9);
        int randomColumnOfFirst = rand.nextInt(9);
        int randomNumber = rand.nextInt(10);
        while(randomNumber == 0) {
            randomNumber = rand.nextInt(10);
        }
        sudokuChecker.board[randomRow][randomColumnOfFirst] = randomNumber;
        int randomColumnOfSecond= rand.nextInt(9);
        while(randomColumnOfFirst == randomColumnOfSecond) {
            randomColumnOfSecond= rand.nextInt(9);
        }
        sudokuChecker.board[randomRow][randomColumnOfSecond] = randomNumber;
        assertFalse(sudokuChecker.rowIsCorrect(randomRow));
    }

    @Test
    public void testColumnIsCorrect() {
        Random rand = new Random();
        int randomRowOfFirst = rand.nextInt(9);
        int randomColumn = rand.nextInt(9);
        int randomNumber = rand.nextInt(10);
        while(randomNumber == 0) {
            randomNumber = rand.nextInt(10);
        }
        sudokuChecker.board[randomRowOfFirst][randomColumn] = randomNumber;
        int randomRowOfSecond= rand.nextInt(9);
        while(randomRowOfFirst == randomRowOfSecond) {
            randomRowOfSecond= rand.nextInt(9);
        }
        sudokuChecker.board[randomRowOfSecond][randomColumn] = randomNumber;
        assertFalse(sudokuChecker.columnIsCorrect(randomColumn));
    }

    @Test
    public void testDifferentRandomRowAndColumn() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(10);
        while(randomNumber == 0) {
            randomNumber = rand.nextInt(10);
        }
        int randomRowOfFirst = rand.nextInt(9);
        int randomColumnOfFirst = rand.nextInt(9);
        sudokuChecker.board[randomRowOfFirst][randomColumnOfFirst] = randomNumber;
        int randomRowOfSecond= rand.nextInt(9);
        while(randomRowOfFirst == randomRowOfSecond) {
            randomRowOfSecond= rand.nextInt(9);
        }
        int randomColumnOfSecond= rand.nextInt(9);
        while(randomColumnOfFirst == randomColumnOfSecond) {
            randomColumnOfSecond= rand.nextInt(9);
        }
        sudokuChecker.board[randomRowOfSecond][randomColumnOfSecond] = randomNumber;
        if(!sudokuChecker.blocksAreCorrect()) {
            assertFalse(sudokuChecker.blocksAreCorrect());
            assertFalse(sudokuChecker.isCorrect());
        } else {
            assertTrue(sudokuChecker.blocksAreCorrect());
            assertTrue(sudokuChecker.isCorrect());
        }
    }

    @Test
    public void testDuplicateNumberInBlock() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(10);
        while(randomNumber == 0) {
            randomNumber = rand.nextInt(10);
        }
        int row = rand.nextInt(9);
        int column = rand.nextInt(9);
        while(column % 3 == 2) {
            column = rand.nextInt(9);
        }
        sudokuChecker.board[row][column] = randomNumber;
        sudokuChecker.board[row][column + 1] = randomNumber;
        assertTrue(sudokuChecker.columnIsCorrect(column));
        assertTrue(sudokuChecker.columnIsCorrect(column + 1));
        assertFalse(sudokuChecker.rowIsCorrect(row));
        assertFalse(sudokuChecker.blockIsCorrect(row, column));
        assertFalse(sudokuChecker.isCorrect());
    }

    @Test
    public void testSetupBoard() {
        sudokuChecker.setupBoard();
        for(int i = 0; i < Constants.NUMBER_OF_ROWS; i++) {
            for(int j = 0; j < Constants.NUMBER_OF_COLUMNS; j++) {
                assertEquals(sudokuChecker.board[i][j], 0);
            }
        }
    }

}
