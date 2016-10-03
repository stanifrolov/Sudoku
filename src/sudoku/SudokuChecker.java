package sudoku;

import java.util.ArrayList;
import java.util.List;

import static sudoku.Constants.NUMBER_OF_ROWS;
import static sudoku.Constants.NUMBER_OF_COLUMNS;

public class SudokuChecker {
	
	public int[][] board = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	public List<Integer> possibleNumbers = new ArrayList<Integer>();
	
	public SudokuChecker() {
		setupListOfPossibleNumbers();
	}

	public void setupListOfPossibleNumbers() {
		for(int i = 0; i < 10; i++) {
			this.possibleNumbers.add(i);
		}
	}

	public void setupBoard() {
		Sudoku sudoku = new Sudoku();
		int cellNumber = 0;
		for(int i = 0; i < NUMBER_OF_ROWS; i++) {
			for(int j = 0; j < NUMBER_OF_COLUMNS; j++) {				
				this.board[i][j] = sudoku.getCellValue(cellNumber);
				cellNumber++;
			}
		}
	}
	
	public boolean isCorrect() {
		List<Integer> appearedRowNumbers =  new ArrayList<Integer>();
		List<Integer> appearedColumnNumbers = new ArrayList<Integer>();
		boolean rowNumberIsValid, columnNumberIsValid, rowNumberIsDuplicate, columnNumberIsDuplicate;
		for(int i = 0; i < NUMBER_OF_ROWS; i++) {
			for(int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				rowNumberIsValid = this.possibleNumbers.contains(this.board[i][j]);
				rowNumberIsDuplicate = appearedRowNumbers.contains(this.board[i][j]);
				if(rowNumberIsValid && !rowNumberIsDuplicate) {
					if(this.board[i][j] != 0)
						appearedRowNumbers.add(this.board[i][j]);
				}
				else {
					return false;
				}
				columnNumberIsValid = this.possibleNumbers.contains(this.board[j][i]);
				columnNumberIsDuplicate = appearedColumnNumbers.contains(this.board[j][i]);
				if(columnNumberIsValid && !columnNumberIsDuplicate) {
					if(this.board[j][i] != 0)
						appearedColumnNumbers.add(this.board[j][i]);
				}
				else {
					return false;
				}
			}
			appearedRowNumbers.clear();
			appearedColumnNumbers.clear();
		}
		return (true && blocksAreCorrect());
	}
	
	public boolean blocksAreCorrect() {
		boolean blocksAreCorrect = true;
		for(int i = 0; i < NUMBER_OF_ROWS; i = i + 3) {
			for(int j = 0; j < NUMBER_OF_COLUMNS; j = j + 3) {
				blocksAreCorrect = blocksAreCorrect && blockIsCorrect(i,j);
				if(!blocksAreCorrect)
					return false;
			}
		}
		return true;
	}
	
	public boolean blockIsCorrect(int row, int column) {
		int rowStart = 3*Math.round(row/3);
		int columnStart = 3*Math.round(column/3);
		List<Integer> listOfAppearedNumbers = new ArrayList<Integer>();
		boolean numberIsValid, numberIsDuplicate;
		for(int i = rowStart; i < rowStart + 3; i++) {
			for(int j = columnStart; j < columnStart + 3; j++) {
				numberIsValid = this.possibleNumbers.contains(this.board[i][j]);
				numberIsDuplicate = listOfAppearedNumbers.contains(this.board[i][j]);
				if(numberIsValid && !numberIsDuplicate) {
					if(this.board[i][j] != 0)
						listOfAppearedNumbers.add(this.board[i][j]);
				}
				else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean rowIsCorrect(int row) {
		List<Integer> appearedRowNumbers =  new ArrayList<Integer>();
		boolean rowNumberIsValid, rowNumberIsDuplicate;
		for(int j = 0; j < 9; j++) {
			rowNumberIsValid = this.possibleNumbers.contains(this.board[row][j]);
			rowNumberIsDuplicate = appearedRowNumbers.contains(this.board[row][j]);
			if(rowNumberIsValid && !rowNumberIsDuplicate) {
				if(this.board[row][j] != 0)
					appearedRowNumbers.add(this.board[row][j]);
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public boolean columnIsCorrect(int column) {
		
		List<Integer> appearedColumnNumbers =  new ArrayList<Integer>();
		boolean columnNumberIsValid, columnNumberIsDuplicate;
		for(int i = 0; i < 9; i++) {
			columnNumberIsValid = this.possibleNumbers.contains(this.board[i][column]);
			columnNumberIsDuplicate = appearedColumnNumbers.contains(this.board[i][column]);
			if(columnNumberIsValid && !columnNumberIsDuplicate) {
				if(this.board[i][column] != 0)
					appearedColumnNumbers.add(this.board[i][column]);
			}
			else {
				return false;
			}
		}
		return true;
	}
			
}
