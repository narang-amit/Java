// I had trouble visualizing the tail recursion(only for solve()), so I looked through some online resources from help 
// and used the online Python code as an inspiration.

import java.util.*;

public class QueenBoard {

    private int[][] board;

    public QueenBoard(int size) {
		board = new int[size][size];
    }

    private boolean addQueen(int r, int c) {
		if (!(r < board.length && c < board.length) || board[r][c] != 0) {
		    return false;
		}
		else {
		    for (int i = 0;i < board[r].length;i++) {
				board[r][i] ++;
				board[i][c] ++;
		    }
		    int x, y;
		    for (int ri = -1; ri <= 1; ri +=2) {
		    	for (int ci = -1; ci <=1; ci += 2) {
		    		x = r;
		   	 		y = c; 
		    		while (x>= 0 && x < board.length && y >= 0 && y < board.length) {
		    			board[x][y] ++;
		    			x += ri;
		    			y += ci;
		    		}
		    	}
		    }
		    board[r][c] = -1;
		    return true;
		}
    }

    private boolean removeQueen(int r, int c) {
    	if (!(r < board.length && c < board.length) || board[r][c] != -1) {
    		return false;
    	}
    	else {
    		for (int i = 0; i < board[r].length; i++) {
    			board[r][i] --;
    			board[i][c] --;
    		}
    		int x, y;
		    for (int ri = -1; ri <= 1; ri +=2) {
		    	for (int ci = -1; ci <=1; ci += 2) {
		    		x = r;
		   	 		y = c; 
		    		while (x>= 0 && x < board.length && y >= 0 && y < board.length) {
		    			board[x][y] --;
		    			x += ri;
		    			y += ci;
		    		}
		    	}
		    }
    		board[r][c] = 0;
    		return true;
    	}
    }

    public String toString() {

		String[][] holder = new String[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board.length; j++) {
			if (board[i][j] == -1) {
			    holder[i][j] = "Q";
			}
			else {
			    holder[i][j] = "_";
			}
		    }
		}
		String hold = "";
		for (int i = 0; i < board.length;i ++) {
			for (int j = 0; j < board.length; j++) {
				hold += holder[i][j];
				hold += " ";
			}
			hold += "\n";
		}
		return hold;
    }

    public boolean solve() {
		if (!startValue()) {
		    throw new IllegalStateException();
		}
		solveAux(this,0);
		return true;
	}

	public boolean solveAux(QueenBoard Qboard, int col) {
		if (col >= Qboard.length()) {
			return true;
		}
		for (int i = 0; i < Qboard.length(); i ++) {
			if (Qboard.addQueen(i, col)) {
				if (solveAux(Qboard,col+1)) {
					return true;
				}
				else {
					Qboard.removeQueen(i,col);
				}
			}
		}
		return false;
	}

    public int countSolutions() {
		if (!startValue()) {
		    throw new IllegalStateException();
		}
		return countSolutionsAux(this,0);
    }
    public int countSolutionsAux(QueenBoard Qboard, int col) {
    	int total = 0;
    	if (col >= Qboard.length()) {
    		return 1;
    	}
    	for (int i = 0; i < Qboard.length(); i ++) {
    		if (Qboard.addQueen(i,col)) {
    			total += countSolutionsAux(Qboard,col+1);
    			Qboard.removeQueen(i,col);
    		}
    	}
    	return total;
    }
    private int length() {
    	return board.length;
    }

    private boolean startValue() {
		for (int i = 0; i < board.length; i++) {
		    for (int j =0; j < board[i].length;j++) {
			if (board[i][j] != 0) {
			    return false;
				}
		    }
		}
		return true;
    }

    public static void main(String[] args) {
	QueenBoard x = new QueenBoard(16);
	System.out.println(x.countSolutions());
    }
}
