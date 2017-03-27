package sudoku;


public class SudokuCell {

    private int row;
    private int column;
    private int cellNumber;
    private int value;

    public SudokuCell(){
    }

    public SudokuCell(int row, int column, int value) {
        this.value = value;
        this.row = row;
        this.column = column;
        this.cellNumber = getCellFromRowAndColumn(row, column);
    }

    public SudokuCell(int cellNumber, int value) {
        this.value = value;
        this.cellNumber = cellNumber;
        this.row = getRowFromCellNumber(cellNumber);
        this.column = getColumnFromCellNumber(cellNumber);
    }

    public int getColumnFromCellNumber(int cellNumber) {
        // TODO: 27.03.17 getColumnFromCellNumber
        return 0;
    }

    public int getRowFromCellNumber(int cellNumber) {
        // TODO: 27.03.17 getRowFromCellNumber
        return 0;
    }

    public int getCellFromRowAndColumn(int row, int column) {
        // TODO: 27.03.17 getCellFromRowAndColumn
        return 0;
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
