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
	    public  USACO(){
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
		    //System.out.println(x.bronze("makelake2.in"));
		    System.out.println(x.bronze("lake1.txt"));
		}*/
	}
