	import java.util.*;
	import java.io.*;

	public class USACO{
		private static int[][]pasture;
		private static int R;
		private static int C;
		private static int E;
		private static int N;
		private static int D;
		private static int ans;
		private static int R1;
		private static int C1;
		private static int[][] map;
		private static int[][] board;
		private static int start1;
		private static int start2;
		private static int end1;
		private static int end2;
		private static int s;
	    public  USACO(){
	    }
	public int silver(String filename){
		try{
		Scanner scan = new Scanner(new File(filename));
		R1 = scan.nextInt();
		C1 = scan.nextInt();
		map = new int[R1][C1];
		s = scan.nextInt();
		board = new int[R1][C1];
		for(int i = 0; i < R1; i++){
		String l = scan.next();
		for (int j = 0; j < C; j++){
			if (l.charAt(j) == '*'){
				map[i][j] = -1;
				board[i][j] = -1;
				}
			}
		}
		map[scan.nextInt() - 1][scan.nextInt() - 1] = 1;
		start1 = scan.nextInt() - 1;
		start2 = scan.nextInt() - 1;
		for (int t = s; t > 0; t--){
			for (int i = 0; i < R1; i++){
				for (int j = 0; j < C1; j++){
					if (map[i][j] != -1){
						solve(i, j);
					}
				}
			}
			for (int i = 0; i < R1; i++){
				for (int j = 0; j < C1; j++){
					map[i][j] = board[i][j];
				}
			}
		}	
		}
		catch (FileNotFoundException e){
			System.out.println("File Not Found");
			System.exit(1);
		}
		return board[start1][start2];
	}

	public static void solve(int r, int c){
		int result = 0;
		if ((r + 1 < R1) && (map[r + 1][c] != -1)){
			result += map[r + 1][c];
		}
		if ((r - 1 >= 0) && (map[r - 1][c] != -1)){
			result += map[r - 1][c];
		}
		if ((c - 1 >= 0) && (map[r][c - 1] != -1)){
			result += map[r][c - 1];
		}
		if ((c + 1 < C1) && (map[r][c + 1] != -1)){
			result += map[r][c + 1];
		}
		board[r][c] = result;
	}
	    public int bronze(String filename){
	    	ans = 0;
			try{
		    Scanner scan = new Scanner(new File(filename));
		    R = scan.nextInt();
		    C = scan.nextInt();
		    E = scan.nextInt();
		    N = scan.nextInt();
		    pasture = new int[R][C];
		    for (int i = 0 ; i < R ; i++){
			for (int j = 0 ; j < C ; j++){
			    pasture[i][j] = scan.nextInt();
			}
		    }
		    for (int i = 0; i < N; i ++){
		    	int a = scan.nextInt();
		    	int b = scan.nextInt();
		    	D = scan.nextInt();
		    	stomp(a - 1, b - 1, D);
		    }
			}
			catch (FileNotFoundException e){
			System.out.println("File Not Found");
			System.exit(1);
			}
			for (int i = 0; i < R; i++){
				for (int j = 0 ; j < C; j++){
					if (pasture[i][j] < E){
					//pasture[i][j] = Math.abs(pasture[i][j]);
					ans += E - pasture[i][j];
			   		}
				}
			}
			ans = ans * 72 * 72;
			return ans;
		}

		public static void stomp(int r, int c, int down){
			int max = 0; 
			for (int i = 0; i < 3; i++){
			    for (int j = 0; j < 3; j++){
					if (isValid(r + i, c + j) && pasture[r + i][c + j] > max){
				    max = pasture[r + i][c + j];
					}
			    }
			}
			for (int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(isValid(r + i, c +j) && 
					   max - pasture[r + i][c + j] <= D){
						pasture[r + i][c + j] = pasture[r + i][c + j] - (down - (max - pasture[r + i][c + j]));
					}
				}
			}
		}
		public static boolean isValid(int row, int col){
			return ((row >= 0) &&
					(row <= R) &&
					(col >= 0) &&
					(col <= C));
		}
		/*public static void main(String[]args){
		    USACO x = new USACO();
		    //System.out.println(x.bronze("lake1.txt"));
		    System.out.println(x.silver("ctravel.txt"));
		}*/
	}
