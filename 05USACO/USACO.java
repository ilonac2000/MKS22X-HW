import java.util.*;
	import java.io.*;

	public class USACO{
		private static int[][]pasture;
		private static int R;
		private static int C;
		private static int E;
		private static int N;
	    public  USACO(){
	    }
	    public int bronze(String filename){
	    int[][] pasture;
		int R,C,E,N;
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
		    int row,col,dec;
		    while (scan.hasNextLine()){
			row = scan.nextInt();
			col = scan.nextInt();
			dec = scan.nextInt();
			int max = 0; 
			for (int i = row; i < row + 3 && i < R; row++){
			    for (int j = col; j < col + 3 && j < C; j++){
					if (pasture[i][j] > max){
				    max = pasture[i][j];
					}
			    }
			}
			for (int i = row; i < row + 3 && i < R; i++){
			    for (int j = col; j < col + 3 && j < C; j++){
					if (pasture[i][j] > max - dec){
				    pasture[i][j] = max - dec;
					}
			    }
			}
		    }
		    int ans = 0;
			//System.out.print(ans);
		    for (int i = 0 ; i < pasture.length; i++){
				for (int j = 0 ; j < pasture[0].length; j++){
			    	if (pasture[i][j] < E){
					ans += (E - pasture[i][j]);
			   		}
				}
			}
			result =  ans * 72 * 72;
		}
		catch (FileNotFoundException e){
			System.out.println("File Not Found");
			System.exit(0);
		}
		return result;
	}
		public static void main(String[]args){
		    USACO x = new USACO();
		    System.out.println(x.bronze("lake.txt"));
		}
	}
