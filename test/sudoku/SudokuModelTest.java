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
        assertEquals(sudokuModel.getColumnFromCell(57), 0);
        assertEquals(sudokuModel.getColumnFromCell(36), 3);
        assertEquals(sudokuModel.getColumnFromCell(42), 3);
        assertEquals(sudokuModel.getColumnFromCell(73), 7);
        assertEquals(sudokuModel.getColumnFromCell(23), 8);
        assertEquals(sudokuModel.getColumnFromCell(80), 8);
    }

    @Test
    public void testGetFirstColumnOfLastThreeBoxes() throws Exception {
        assertEquals(sudokuModel.getFirstColumnOfBox(6), 0);
        assertEquals(sudokuModel.getFirstColumnOfBox(7), 3);
        assertEquals(sudokuModel.getFirstColumnOfBox(8), 6);
    }

    @Test
    public void testGetFirstColumnOfMiddleThreeBoxes() throws Exception {
        assertEquals(sudokuModel.getFirstColumnOfBox(3), 0);
        assertEquals(sudokuModel.getFirstColumnOfBox(4), 3);
        assertEquals(sudokuModel.getFirstColumnOfBox(5), 6);
    }

    @Test
    public void testGetFirstColumnOfFirstThreeBoxes() throws Exception {
        assertEquals(sudokuModel.getFirstColumnOfBox(0), 0);
        assertEquals(sudokuModel.getFirstColumnOfBox(1), 3);
        assertEquals(sudokuModel.getFirstColumnOfBox(2), 6);
    }

    @Test
    public void testGetRowFromCellNumber() {
        assertEquals(sudokuModel.getRowFromCell(0), 0);
        assertEquals(sudokuModel.getRowFromCell(23), 1);
        assertEquals(sudokuModel.getRowFromCell(36), 3);
        assertEquals(sudokuModel.getRowFromCell(42), 5);
        assertEquals(sudokuModel.getRowFromCell(57), 7);
        assertEquals(sudokuModel.getRowFromCell(80), 8);
    }

    @Test
    public void testGetFirstRowOfLastThreeBoxes() throws Exception {
        assertEquals(sudokuModel.getFirstRowOfBox(6), 6);
        assertEquals(sudokuModel.getFirstRowOfBox(7), 6);
        assertEquals(sudokuModel.getFirstRowOfBox(8), 6);
    }

    @Test
    public void testGetFirstRowOfMiddleThreeBoxes() throws Exception {
        assertEquals(sudokuModel.getFirstRowOfBox(3), 3);
        assertEquals(sudokuModel.getFirstRowOfBox(4), 3);
        assertEquals(sudokuModel.getFirstRowOfBox(5), 3);
    }

    @Test
    public void testGetFirstRowOfFirstThreeBoxes() throws Exception {
        assertEquals(sudokuModel.getFirstRowOfBox(0), 0);
        assertEquals(sudokuModel.getFirstRowOfBox(1), 0);
        assertEquals(sudokuModel.getFirstRowOfBox(2), 0);
    }

    @Test
    public void testGetBoxFromCellNumber() {
        assertEquals(sudokuModel.getBoxFromCell(0), 0);
        assertEquals(sudokuModel.getBoxFromCell(8), 0);
        assertEquals(sudokuModel.getBoxFromCell(23), 2);
        assertEquals(sudokuModel.getBoxFromCell(36), 4);
        assertEquals(sudokuModel.getBoxFromCell(42), 4);
        assertEquals(sudokuModel.getBoxFromCell(57), 6);
        assertEquals(sudokuModel.getBoxFromCell(80), 8);
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
