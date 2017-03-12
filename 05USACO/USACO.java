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
		    	int a = scan.nextInt() - 1;
		    	int b = scan.nextInt() - 1;
		    	D = scan.nextInt();
		    	stomp(a, b, D);
		    }
			}
			catch (FileNotFoundException e){
			System.out.println("File Not Found");
			System.exit(1);
			}
			for (int i = 0; i < R; i++){
				for (int j = 0 ; j < C; j++){
					if (pasture[i][j] < E){
					ans += (E - pasture[i][j]);
			   		}
				}
			}
			return ans * 72 * 72;
		}

		public static void stomp(int r, int c, int down){
			int max = 0; 
			for (int i = r; i < r + 3 && i < R; i++){
			    for (int j = c; j < c + 3 && j < C; j++){
					if (pasture[i][j] > max){
				    max = pasture[i][j];
					}
			    }
			}
			for (int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(isValid(r + i, c +j) && 
					   pasture[r + i][c + j] > max - D){
						pasture[r + i][c + j] = down - max;
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
		public static void main(String[]args){
		    USACO x = new USACO();
		    System.out.println(x.bronze("lake.txt"));
		    System.out.println(x.bronze("lake2.txt"));
		}
	}
