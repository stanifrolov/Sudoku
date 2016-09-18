import java.util.ArrayList;
import java.util.List;

public class SudokuBlock {
	
	public int[][] block;
	public List<Integer> listOfPossibleNumbers;
	
	public SudokuBlock() {
		create();
		listOfPossibleNumbers = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			this.listOfPossibleNumbers.add(i);
		}
	}
	
	public void create() {
		this.block = new int[3][3];
	}
 
	public void display() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(this.block[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean isCorrect() {
		List<Integer> listOfAppearedNumbers = new ArrayList<Integer>();
		boolean numberIsValid, numberIsDuplicate;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				numberIsValid = this.listOfPossibleNumbers.contains(this.block[i][j]);
				numberIsDuplicate = listOfAppearedNumbers.contains(this.block[i][j]);
				if(numberIsValid && !numberIsDuplicate) {
					if(this.block[i][j] != 0)
						listOfAppearedNumbers.add(this.block[i][j]);
				}
				else {
					return false;
				}
			}
		}
		return true;
	}

}
