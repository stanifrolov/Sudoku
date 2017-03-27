package sudoku;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SudokuCellTest {

    @Test
    public void testGetValue(){
        SudokuCell cell = new SudokuCell(0, 1);
        assertEquals(cell.getValue(), 1);
    }
}
