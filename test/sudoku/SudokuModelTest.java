package sudoku;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SudokuModelTest {

    private SudokuModel sudokuModel;

    @Before
    public void setUp() {
        sudokuModel = new SudokuModel();
    }

    @Test
    public void testGetColumnFromCellNumber() {
        assertEquals(sudokuModel.getColumnFromCell(0), 0);
        assertEquals(sudokuModel.getColumnFromCell(80), 8);
        assertEquals(sudokuModel.getColumnFromCell(42), 4);
        assertEquals(sudokuModel.getColumnFromCell(36), 3);
        assertEquals(sudokuModel.getColumnFromCell(57), 0);
        assertEquals(sudokuModel.getColumnFromCell(23), 7);
    }

    @Test
    public void testGetRowFromCellNumber() {
        assertEquals(sudokuModel.getRowFromCell(0), 0);
        assertEquals(sudokuModel.getRowFromCell(80), 8);
        assertEquals(sudokuModel.getRowFromCell(42), 5);
        assertEquals(sudokuModel.getRowFromCell(36), 3);
        assertEquals(sudokuModel.getRowFromCell(57), 7);
        assertEquals(sudokuModel.getRowFromCell(23), 1);
    }

    @Test
    public void testGetBoxFromCellNumber() {
        assertEquals(sudokuModel.getBoxFromCell(0), 0);
        assertEquals(sudokuModel.getBoxFromCell(8), 0);
        assertEquals(sudokuModel.getBoxFromCell(80), 8);
        assertEquals(sudokuModel.getBoxFromCell(36), 4);
        assertEquals(sudokuModel.getBoxFromCell(57), 6);
        assertEquals(sudokuModel.getBoxFromCell(42), 4);
        assertEquals(sudokuModel.getBoxFromCell(23), 2);
    }

    @Test
    public void testInitSudokuBoard() {
        for (int i = 0; i < Constants.NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < Constants.NUMBER_OF_COLUMNS; j++) {
                assertEquals(sudokuModel.getCellAt(i, j), 0);
            }
        }
    }

}
