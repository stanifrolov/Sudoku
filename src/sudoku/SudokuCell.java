package sudoku;


public class SudokuCell {

    private int row;
    private int column;
    private int cellNumber;
    private int value;

    public SudokuCell(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public SudokuCell(int cellNumber, int value) {
        this.cellNumber = cellNumber;
        this.value = value;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
