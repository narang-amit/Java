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

    public boolean solveFast(int row, int col) {
        check();
        if (extraneous(row,col)) {
            throw new IllegalArgumentException();
        }
        return solveFastAux(row,col,1);
    }
    public boolean solveFastAux(int row,int col, int move) {
        if (extraneous(row,col)) {
            return false;
        }
        if (board[row][col] != 0) {
            return false;
        }
        board[row][col] = move;
        if (move == rows *cols) {
            return true;
        }
        ArrayList<Integer> moveSet = new ArrayList<Integer>();
        int[][] fastList = fastListMaker();
        for (int i = 0; i <moveHolder.length;i+=2) {
            int x = row +moveHolder[i];
            int y = col + moveHolder[i+1];
            if (!extraneous(x,y)) {
                moveSet.add(x);
                moveSet.add(y);
                moveSet.add(fastList[x][y]);
            }
        }
        //System.out.println(moveSet);
        moveSet = bestMove(moveSet);
        boolean success = false;
        for (int i = 0; i < moveSet.size(); i+= 3) {
            success = success || solveFastAux(moveSet.get(i),moveSet.get(i+1),move+1);
        }
        if (!success) {
            board[row][col] = 0;
        }
        return success;

    }
    // Now has to update bestMove with each move, check for future moves to be less 
    
    private static ArrayList<Integer> bestMove(ArrayList<Integer> holder) {
        for (int i = 2; i < holder.size();i += 3) {
            int curr = i;
            for (int j = i; j < holder.size();j+=3) {
                if (holder.get(j)<holder.get(curr)) {
                    curr = j;
                }
            }
            int s = holder.get(curr);
            int m = holder.get(curr-1);
            int n = holder.get(curr-2);
            holder.set(curr,holder.get(i));
            holder.set(curr-1,holder.get(i-1));
            holder.set(curr-2,holder.get(i-2));
            holder.set(i-1,m);
            holder.set(i-2,n);
            holder.set(i,s);
        }
        return holder;
    }
    //Make code remove possible moves, rather than making it check in fastListMaker because it'll take n^2 each time


    private int[][] fastListMaker() {
        int[][] holder = new int[rows][cols];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j++) {
                int totalMoves = 0;
                for (int cnt = 0; cnt < moveHolder.length; cnt += 2) {
                    if (!extraneous(i +moveHolder[cnt],j+moveHolder[cnt+1])) {
                        totalMoves ++;
                    }
                }
                holder[i][j] = totalMoves;
            }
        }
        return holder;
    }

    public static void main(String[] args) {
        KnightBoard x = new KnightBoard(6,6);
        x.solveFast(0,0);
        System.out.println(x);
    }
}
