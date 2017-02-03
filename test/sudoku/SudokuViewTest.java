package sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuViewTest {

    private SudokuView sudokuView;

    @BeforeEach
    void setUp() {
        sudokuView = new SudokuView();
    }

    @Test
    void testGetCellValue() {
        assertEquals(sudokuView.getCellValue(0), 0);
        assertEquals(sudokuView.getCellValue(80), 0);
    }

    @Test
    void getCellText() {
        assertEquals(sudokuView.getCellText(0), " ");
        assertEquals(sudokuView.getCellText(80), " ");
    }

}
