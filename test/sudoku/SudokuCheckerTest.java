package sudoku;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class SudokuCheckerTest {

    private SudokuChecker sudokuChecker;
    private SudokuController sudokuController;

    @Before
    public void setUp() {
        sudokuChecker =  new SudokuChecker();
        sudokuController = sudokuChecker.getSudokuController();
    }

    @Test
    public void testIsCorrect(){
        sudokuController.setCellAt(0, 0, 1);
        sudokuController.setCellAt(4, 0, 1);
        assertTrue(sudokuChecker.blocksAreCorrect());
        assertFalse(sudokuChecker.columnIsCorrect(0));
        assertFalse(sudokuChecker.rowsAndColumnsAreCorrect());
        assertFalse(sudokuChecker.isCorrect());
    }

    @Test
    public void testRowsHaveDuplicate() {
        sudokuController.setCellAt(0, 0, 1);
        sudokuController.setCellAt(0, 1, 1);
        assertFalse(sudokuChecker.rowIsCorrect(0));
    }

    @Test
    public void testRowsWithoutDuplicate() {
        sudokuController.setCellAt(0, 0, 1);
        sudokuController.setCellAt(1, 0, 1);
        assertTrue(sudokuChecker.rowIsCorrect(0));
    }

    @Test
    public void testColumnsHaveDuplicate() {
        sudokuController.setCellAt(0, 0, 1);
        sudokuController.setCellAt(1, 0, 1);
        assertFalse(sudokuChecker.columnIsCorrect(0));
    }

    @Test
    public void testColumnsWithoutDuplicate() {
        sudokuController.setCellAt(0, 0, 1);
        sudokuController.setCellAt(1, 1, 1);
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
        sudokuController.setCellAt(randomRow, randomColumnOfFirst, randomNumber);
        int randomColumnOfSecond= rand.nextInt(9);
        while(randomColumnOfFirst == randomColumnOfSecond) {
            randomColumnOfSecond= rand.nextInt(9);
        }
        sudokuController.setCellAt(randomRow, randomColumnOfSecond, randomNumber);
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
        sudokuController.setCellAt(randomRowOfFirst, randomColumn, randomNumber);
        int randomRowOfSecond= rand.nextInt(9);
        while(randomRowOfFirst == randomRowOfSecond) {
            randomRowOfSecond = rand.nextInt(9);
        }
        sudokuController.setCellAt(randomRowOfSecond, randomColumn, randomNumber);
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
        sudokuController.setCellAt(randomRowOfFirst, randomColumnOfFirst, randomNumber);
        int randomRowOfSecond= rand.nextInt(9);
        while(randomRowOfFirst == randomRowOfSecond) {
            randomRowOfSecond= rand.nextInt(9);
        }
        int randomColumnOfSecond= rand.nextInt(9);
        while(randomColumnOfFirst == randomColumnOfSecond) {
            randomColumnOfSecond= rand.nextInt(9);
        }
        sudokuController.setCellAt(randomRowOfSecond, randomColumnOfSecond, randomNumber);
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
        sudokuController.setCellAt(row, column, randomNumber);
        sudokuController.setCellAt(row, column + 1, randomNumber);
        assertTrue(sudokuChecker.columnIsCorrect(column));
        assertTrue(sudokuChecker.columnIsCorrect(column + 1));
        assertFalse(sudokuChecker.rowIsCorrect(row));
        assertFalse(sudokuChecker.blockIsCorrect(row, column));
        assertFalse(sudokuChecker.isCorrect());
    }

}
