import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuBoardTest {

	@Test
	public void testRowsHaveDuplicate() {
		SudokuBoard sboard = new SudokuBoard();
		sboard.board[0][0].block[0][0] = 1;
		sboard.board[0][0].block[0][2] = 1;
		assertFalse(sboard.rowsAreCorrect());
	}
	
	@Test
	public void testRowsWithoutDuplicate() {
		SudokuBoard sboard = new SudokuBoard();
		sboard.board[1][1].block[1][1] = 1;
		sboard.board[2][1].block[1][2] = 1;
		assertTrue(sboard.rowsAreCorrect());	
	}
	
	@Test
	public void testColumsHaveDuplicate() {
		SudokuBoard sboard = new SudokuBoard();
		sboard.board[0][0].block[0][0] = 1;
		sboard.board[2][0].block[1][0] = 1;
		assertFalse(sboard.columnsAreCorrect());
	}
	
	@Test
	public void testColumsWithoutDuplicate() {
		SudokuBoard sboard = new SudokuBoard();
		sboard.board[0][0].block[0][0] = 1;
		sboard.board[1][1].block[0][0] = 1;
		sboard.display();
		assertTrue(sboard.columnsAreCorrect());
		
	}

}
