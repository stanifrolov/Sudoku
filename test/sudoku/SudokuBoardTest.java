package sudoku;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class SudokuBoardTest {

	@Test
	public void testRowsHaveDuplicate() {
		SudokuBoard sboard = new SudokuBoard();
		sboard.board[0][0] = 1;
		sboard.board[0][1] = 1;
		assertFalse(sboard.rowIsCorrect(0));
	}
	
	@Test
	public void testRowsWithoutDuplicate() {
		SudokuBoard sboard = new SudokuBoard();
		sboard.board[0][0] = 1;
		sboard.board[1][0] = 1;
		assertTrue(sboard.rowIsCorrect(0));
	}
	
	@Test
	public void testColumsHaveDuplicate() {
		SudokuBoard sboard = new SudokuBoard();
		sboard.board[0][0] = 1;
		sboard.board[1][0] = 1;
		assertFalse(sboard.columnIsCorrect(0));
	}
	
	@Test
	public void testColumsWithoutDuplicate() {
		SudokuBoard sboard = new SudokuBoard();
		sboard.board[0][0] = 1;
		sboard.board[1][1] = 1;
		assertTrue(sboard.columnIsCorrect(0));
		
	}
	
	@Test
	public void testRowIsCorrect() {
		SudokuBoard sboard = new SudokuBoard();
		Random rand = new Random();
		int randomRow = rand.nextInt(9);
		int randomColumnOfFirst = rand.nextInt(9);
		int randomNumber = rand.nextInt(10);
		while(randomNumber == 0) {
			randomNumber = rand.nextInt(10);			
		}
		sboard.board[randomRow][randomColumnOfFirst] = randomNumber;
		int randomColumnOfSecond= rand.nextInt(9);
		while(randomColumnOfFirst == randomColumnOfSecond) {
			randomColumnOfSecond= rand.nextInt(9);			
		}
		sboard.board[randomRow][randomColumnOfSecond] = randomNumber;
		assertFalse(sboard.rowIsCorrect(randomRow));
	}
	
	@Test
	public void testColumnIsCorrect() {
		SudokuBoard sboard = new SudokuBoard();
		Random rand = new Random();
		int randomRowOfFirst = rand.nextInt(9);
		int randomColumn = rand.nextInt(9);
		int randomNumber = rand.nextInt(10);
		while(randomNumber == 0) {
			randomNumber = rand.nextInt(10);			
		}
		sboard.board[randomRowOfFirst][randomColumn] = randomNumber;
		int randomRowOfSecond= rand.nextInt(9);
		while(randomRowOfFirst == randomRowOfSecond) {
			randomRowOfSecond= rand.nextInt(9);			
		}
		sboard.board[randomRowOfSecond][randomColumn] = randomNumber;
		assertFalse(sboard.columnIsCorrect(randomColumn));
	}
	
	@Test
	public void testDifferentRandomRowAndColumn() {		
		SudokuBoard sboard = new SudokuBoard();
		Random rand = new Random();
		int randomNumber = rand.nextInt(10);
		while(randomNumber == 0) {
			randomNumber = rand.nextInt(10);			
		}
		int randomRowOfFirst = rand.nextInt(9);
		int randomColumnOfFirst = rand.nextInt(9);
		sboard.board[randomRowOfFirst][randomColumnOfFirst] = randomNumber;
		int randomRowOfSecond= rand.nextInt(9);
		while(randomRowOfFirst == randomRowOfSecond) {
			randomRowOfSecond= rand.nextInt(9);			
		}
		int randomColumnOfSecond= rand.nextInt(9);
		while(randomColumnOfFirst == randomColumnOfSecond) {
			randomColumnOfSecond= rand.nextInt(9);			
		}
		sboard.board[randomRowOfSecond][randomColumnOfSecond] = randomNumber;
		if(!sboard.blocksAreCorrect()) {
			assertFalse(sboard.isCorrect());			
		}
		else {
			assertTrue(sboard.isCorrect());
		}
	}
	
	@Test
	public void testDuplicateNumberInBlock() {
		SudokuBoard sboard = new SudokuBoard();
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
		sboard.board[row][column] = randomNumber;
		sboard.board[row][column + 1] = randomNumber;
		assertTrue(sboard.columnIsCorrect(column));
		assertTrue(sboard.columnIsCorrect(column + 1));
		assertFalse(sboard.rowIsCorrect(row));
		assertFalse(sboard.blockIsCorrect(row, column));
		assertFalse(sboard.isCorrect());
	}
	
}
