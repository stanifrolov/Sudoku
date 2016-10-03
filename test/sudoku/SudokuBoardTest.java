package sudoku;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SudokuBoardTest {
	
	SudokuBoard sudokuBoard;
	
	@Before
	public void setUp() {
		sudokuBoard = new SudokuBoard();
	}

	@Test
	public void testRowsHaveDuplicate() {
		sudokuBoard.board[0][0] = 1;
		sudokuBoard.board[0][1] = 1;
		assertFalse(sudokuBoard.rowIsCorrect(0));
	}
	
	@Test
	public void testRowsWithoutDuplicate() {
		sudokuBoard.board[0][0] = 1;
		sudokuBoard.board[1][0] = 1;
		assertTrue(sudokuBoard.rowIsCorrect(0));
	}
	
	@Test
	public void testColumsHaveDuplicate() {
		sudokuBoard.board[0][0] = 1;
		sudokuBoard.board[1][0] = 1;
		assertFalse(sudokuBoard.columnIsCorrect(0));
	}
	
	@Test
	public void testColumsWithoutDuplicate() {
		sudokuBoard.board[0][0] = 1;
		sudokuBoard.board[1][1] = 1;
		assertTrue(sudokuBoard.columnIsCorrect(0));
		
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
		sudokuBoard.board[randomRow][randomColumnOfFirst] = randomNumber;
		int randomColumnOfSecond= rand.nextInt(9);
		while(randomColumnOfFirst == randomColumnOfSecond) {
			randomColumnOfSecond= rand.nextInt(9);			
		}
		sudokuBoard.board[randomRow][randomColumnOfSecond] = randomNumber;
		assertFalse(sudokuBoard.rowIsCorrect(randomRow));
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
		sudokuBoard.board[randomRowOfFirst][randomColumn] = randomNumber;
		int randomRowOfSecond= rand.nextInt(9);
		while(randomRowOfFirst == randomRowOfSecond) {
			randomRowOfSecond= rand.nextInt(9);			
		}
		sudokuBoard.board[randomRowOfSecond][randomColumn] = randomNumber;
		assertFalse(sudokuBoard.columnIsCorrect(randomColumn));
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
		sudokuBoard.board[randomRowOfFirst][randomColumnOfFirst] = randomNumber;
		int randomRowOfSecond= rand.nextInt(9);
		while(randomRowOfFirst == randomRowOfSecond) {
			randomRowOfSecond= rand.nextInt(9);			
		}
		int randomColumnOfSecond= rand.nextInt(9);
		while(randomColumnOfFirst == randomColumnOfSecond) {
			randomColumnOfSecond= rand.nextInt(9);			
		}
		sudokuBoard.board[randomRowOfSecond][randomColumnOfSecond] = randomNumber;
		if(!sudokuBoard.blocksAreCorrect()) {
			assertFalse(sudokuBoard.isCorrect());			
		}
		else {
			assertTrue(sudokuBoard.isCorrect());
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
		sudokuBoard.board[row][column] = randomNumber;
		sudokuBoard.board[row][column + 1] = randomNumber;
		assertTrue(sudokuBoard.columnIsCorrect(column));
		assertTrue(sudokuBoard.columnIsCorrect(column + 1));
		assertFalse(sudokuBoard.rowIsCorrect(row));
		assertFalse(sudokuBoard.blockIsCorrect(row, column));
		assertFalse(sudokuBoard.isCorrect());
	}
	
}
