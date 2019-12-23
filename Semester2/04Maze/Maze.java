import java.util.*;
import java.io.*;

public class Maze {

	private char[][] maze;
	private final int[] moveList;
	private boolean animate;

	public Maze(String filename) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filename));
		int row, col, numE, numS;
		row = col = numE = numS = 0;
		moveList = new int[] {1,0,0,1,-1,0,0,-1};
		String holder = "";
		while (s.hasNextLine()) {
			holder += s.nextLine();
			row ++;
		}
		col = holder.length()/row;
		maze = new char[row][col];
		for (int i = 0; i < row; i ++) {
			for (int j = 0; j < col; j ++) {
				maze[i][j] = holder.charAt(j+i*col);
				if (maze[i][j] == 'S') {
					numS ++;
				}
				if (maze[i][j] == 'E') {
					numE ++;
				}
			}
		}
		if (numS != 1) {
			System.out.println("Incorrect Start");
			throw new IllegalStateException();
		}
		else if (numE != 1) {
			System.out.println("Incorrect End");
			throw new IllegalStateException();
		}
	}
	private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
     public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

	public int solve() {
		int sRow, sCol;
		sRow = sCol = 0;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] == 'S') {
					sRow = i;
					sCol = j;
					//maze[i][j] = '@';
				}
			}
		}
		return solve(sRow,sCol)-1;
	}

	private int solve(int row, int col) {
		if (maze[row][col] == 'E') {
			return 1;
		}
		else if (maze[row][col] == '#' || maze[row][col] == '@' || maze[row][col] == '.') {
			return 0;
		}
		maze[row][col] = '@';
		for (int i = 0; i < moveList.length; i +=2) {
			int x = solve(row+moveList[i],col+moveList[i+1]);
			if (x >0) {
				return  x;
			}
		}
		maze[row][col] = '.';
		return -1;
	}

	public String toString() {
		String holder = "";
		for (int i = 0; i < maze.length; i ++) {
			for (int j = 0; j < maze[i].length; j++) {
				holder += maze[i][j];
			}
			holder += "\n";
		}
		return holder;
	}
    public static void main(String[] args) {
	try {
	Maze x = new Maze("data1.dat");
	int y = x.solve();
	System.out.println(y);
	System.out.println(x);
    }
	catch (FileNotFoundException e) {
	    System.out.println("" + 234);
	}
    }
}
