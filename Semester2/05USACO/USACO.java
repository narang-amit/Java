//Because I had missed this entire week (strep throat), much of this lab did not make sense.
// Luckily, Peter Jin, Robin Han, and Jerry Sun from Period 9 helped me understand the problems/approaches we covered in class.
import java.util.*;
import java.io.*;

public class USACO {
	
	public static int bronze(String filename){
		int[][] lake;

		int ans = 0;

		try {
			Scanner scan = new Scanner(new File(filename));
			
			int R = scan.nextInt();
			int C = scan.nextInt();
			int E = scan.nextInt();
			int N = scan.nextInt();

			lake = new int [R][C];
			for (int i = 0; i < R; i++){
				for (int j = 0; j < C; j++){
					lake[i][j] = scan.nextInt();
				}
			}
      		ArrayList<Integer> holder;
			for (int cnt=0; cnt<N; cnt++) {
				int R_s = scan.nextInt()-1;
				int C_s = scan.nextInt()-1;
				int D_s = scan.nextInt();
        
				for (int inc = 0; inc <D_s; inc++) {
					holder = new ArrayList<Integer>();
					for (int r = R_s; r < R+1; r++){
						for (int c = C_s; c < C; c++){
							if (r-R_s<3 && c-C_s<3) {
								holder.add(lake[r][c]);
							}
						}
					}

					int x = holder.remove(0);

					for (int i : holder) {
						if (i > x) {
							x = i;
						}
					}

					for(int r = R_s; r < R+1; r++){
						for (int c = C_s; c < C; c++){
							if (r-R_s<3 && c-C_s<3 && lake[r][c] == x) {
								lake[r][c]--;
							}
						}
					}
				}
			}
			for (int i = 0; i < lake.length; i++){
				for (int j = 0; j < lake[i].length; j++){
					if (lake[i][j] < E){
						ans += E - lake[i][j];
					}
				}
			}
			ans *= 5184;

		}


		catch (FileNotFoundException e) {
			System.out.println("No such file");
		}

		return ans;
	}

	 public static int silver(String filename){
        char[][] ground; 
        int[][][] maze;
		int ans = 0;
        int[] x = new int[] {1,-1,0,0};
		int[] y = new int[] {0,0,1,-1};
		int r1,r2,c1,c2;
		int m,n,t;
		try{
			Scanner scan = new Scanner(new File(filename));
			String[] line = scan.nextLine().split("\\s+");
			m = Integer.parseInt(line[0]);
			n = Integer.parseInt(line[1]);
			t = Integer.parseInt(line[2]);
			ground = new char[m+1][n+1];
			maze = new int[m][n][t+1];
			for (int i = 0; i < m; i ++) {
				String str = scan.nextLine();
				for (int j = 0; j< n; j ++) {
					ground[i][j] = str.charAt(j);
					maze[i][j][0] = 0;
				}
			}
			line = scan.nextLine().split("\\s+");
			r1 = Integer.parseInt(line[0])-1;
			c1 = Integer.parseInt(line[1])-1;
			r2 = Integer.parseInt(line[2])-1;
			c2 = Integer.parseInt(line[3])-1;
			maze[r1][c1][0] = 1;
			for (int i = 0; i <t; i ++) {
				for (int j = 0; j < m; j ++) {
					for (int k = 0; k < n; k ++) {
						for (int l = 0; l < 4; l ++) {
							int xMove = j + x[l];
							int yMove = k + y[l];
							if (xMove >= 0 && xMove < m && yMove >= 0 && yMove < n) {
								if (ground[xMove][yMove] != '*') {
									maze[j][k][i+1] += maze[xMove][yMove][i];
								}
							}
						}
					}
				}
			}
			ans = maze[r2][c2][t];
		}
	catch(FileNotFoundException e){
	    System.out.println("No such file");
	}
	return ans;
    }

public static void main(String[] args) {
	USACO test = new USACO();
		System.out.println(bronze("makelake.in"));
		System.out.println(silver("ctravel.in"));
}
}
