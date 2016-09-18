import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
	
	public SudokuBlock[][] board;
	public List<Integer> listOfPossibleNumbers;
	
	public SudokuBoard() {
		create();
	}

	public void create() {
		this.board = new SudokuBlock[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.board[i][j] = new SudokuBlock();
			}
		}
		listOfPossibleNumbers = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			this.listOfPossibleNumbers.add(i);
		}
	}
	
	public void display() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int m = 0; m < 3; m++) {
					for(int n = 0; n < 3; n++) {
						System.out.print(this.board[i][m].block[j][n]);
					}
					System.out.print(' ');
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public boolean isCorrect() {
		return (blocksAreCorrect() && rowsAreCorrect() && columnsAreCorrect());
		
	}
	
	public boolean blocksAreCorrect() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!this.board[i][j].isCorrect())
					return false;
			}
		}
		return true;
	}
	
	public boolean rowsAreCorrect() {
		List<Integer> listOfAppearedNumbers = new ArrayList<Integer>();
		boolean numberIsValid, numberIsDuplicate;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int m = 0; m < 3; m++) {
					for(int n = 0; n < 3; n++) {
						numberIsValid = this.listOfPossibleNumbers.contains(this.board[i][m].block[j][n]);
						numberIsDuplicate = listOfAppearedNumbers.contains(this.board[i][m].block[j][n]);
						if(numberIsValid && !numberIsDuplicate) {
							if(this.board[i][j].block[m][n] != 0)
								listOfAppearedNumbers.add(this.board[i][m].block[j][n]);
						}
						else {
							return false;
						}
					}
				}
				listOfAppearedNumbers.clear();
			}
		}
		return true;
	}
	
	public boolean columnsAreCorrect() {
		List<Integer> listOfAppearedNumbers = new ArrayList<Integer>();
		boolean numberIsValid, numberIsDuplicate;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int m = 0; m < 3; m++) {
					for(int n = 0; n < 3; n++) {
						numberIsValid = this.listOfPossibleNumbers.contains(this.board[m][i].block[n][j]);
						numberIsDuplicate = listOfAppearedNumbers.contains(this.board[m][i].block[n][j]);
						if(numberIsValid && !numberIsDuplicate) {
							if(this.board[m][i].block[n][j] != 0)
								listOfAppearedNumbers.add(this.board[m][i].block[n][j]);
						}
						else {
							return false;
						}
					}
				}
				listOfAppearedNumbers.clear();
			}
		}
		return true;
	}

	


	
	

}
