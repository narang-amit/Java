import java.util.*;

public class KnightBoard {

    private int[][] board;
    private int rows,cols;
    private final int[] moveHolder;

    public KnightBoard(int startingRows,int startingCols) {
		if (startingRows < 0 || startingCols < 0) {
		    throw new IllegalArgumentException();
		}
		board = new int[startingRows][startingCols];
		rows = startingRows;
		cols = startingCols;
		moveHolder = new int[] {1,2,1,-2,-1,2,-1,-2,2,1,2,-1,-2,1,-2,-1};
    }
    
    public String toString() {
		String returner = "";
		for (int i = 0; i < board.length;i++) {
		    for (int j = 0; j < board[i].length;j++) {
			if (board[i][j] == 0) {
			    returner += "_ ";
			}
			else {
			    String s = board[i][j] + "";
			    if (s.length() == 1) {
			    	returner += " " + s + " ";
			    }
			    else {
			    	returner += s + " ";
			    }
			}
		    }
		    returner += "\n";
		}
		return returner;
    }

    public boolean solve(int row, int col) {
    	check();
    	if (extraneous(row,col)) {
    		throw new IllegalArgumentException();
    	}
    	return solveAux(row,col,1);
    }

    private boolean solveAux(int row, int col,int move) {
    	if (row >= rows || col >= cols || row < 0 || col < 0) {
    		return false;
    	}
    	if (board[row][col] != 0) {
    		return false;
    	}
    	board[row][col] = move;
    	if (move == rows*cols) {
    		return true;
    	}
    	int m = move +1;
    	boolean success = false;
    	for (int i = 0; i < moveHolder.length; i+= 2) {
    		success = success || solveAux(row+moveHolder[i],col+moveHolder[i+1],move+1);
    	}
    	if (!success) {
    		board[row][col] = 0;
    	}
    	return success;
    }

    public int countSolutions(int row, int col) {
    	check();
    	if (extraneous(row,col)) {
    		throw new IllegalArgumentException();
    	}
    	return countSolutionsAux(row,col,1);
    }
    public int countSolutionsAux(int row, int col, int move) {
    	int total = 0;
    	if (extraneous(row,col)) {
    		return 0;
    	}
    	if (board[row][col] != 0) {
    		return 0;
    	}
    	if (move == rows*cols) {
    		return 1;
    	}
    	for (int i = 0; i < moveHolder.length;i+= 2) {
    		board[row][col] = move;
    		total += countSolutionsAux(row + moveHolder[i],col+moveHolder[i+1],move+1);
    		board[row][col] = 0;
    	}
    	return total;
    }
    private boolean check() {
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j ++) {
    			if (board[i][j] != 0) {
    				throw new IllegalStateException();
    			}
    		}
    	}
    	return true;
    }
    private boolean extraneous(int row, int col) {
    	return (row < 0 || col < 0 || row >= rows || col>= cols);
    }
    public static void main(String[] args) {
	KnightBoard x = new KnightBoard(6,5);
	x.solve(0,0);
	System.out.println(x);
    }
}
