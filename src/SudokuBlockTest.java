import static org.junit.Assert.*;
import org.junit.Test;

public class SudokuBlockTest {
	
	@Test
	public void testBlockIsCorrect() {
		SudokuBlock sb = new SudokuBlock();
		sb.block[1][1] = 1;
		sb.block[1][2] = 2;
		assertTrue(sb.isCorrect());
	}
	
	@Test
	public void testBlockHasDuplicate() {
		SudokuBlock sb = new SudokuBlock();
		sb.block[1][1] = 1;
		sb.block[1][2] = 1;
		assertFalse(sb.isCorrect());
	}

	
}
