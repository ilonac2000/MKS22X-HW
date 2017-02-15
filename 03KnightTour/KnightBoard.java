public class KnightBoard{
    private int[][]board;
    private int l;
    private int h; 

    public KnightBoard(int startingRows,int startingCols){
    board = new int[startingRows][startingCols];
    l = startingRows;
    h = startingCols;
    }

    public boolean solveh(int r, int c, int level){
	if (level == l * h){
	    return true;
	}
	if (isValid(r, c)){
	    board[r][c] = level;
	    if ((solveh(r + 1, c + 2, level + 1)) || 
		(solveh(r + 2, c + 1, level + 1)) ||
		(solveh(r - 1, c - 2, level + 1)) ||
		(solveh(r - 2, c - 1, level + 1)) ||
		(solveh(r + 1, c - 2, level + 1)) ||
		(solveh(r - 1, c + 2, level + 1)) ||
		(solveh(r + 2, c - 1, level + 1)) ||
		(solveh(r - 2, c + 1, level + 1))){
		return true;
	    }
	    board[r][c] = 0;
	}
	return false;
    }
    
    public boolean isValid(int a, int b){
	return (board[a][b] == 0);
    }

    public void solve(){
	if (!(solveh(0 , 1, 0 ))){
	    solveh(0, 2, 0);
	}
    }

    public String toString(){
        String result = "";
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board.length; c++){
                if(board[r][c] < 10){
                    result += " " + board[r][c] + " ";
                }
                else{
                    result += board[r][c] + " ";
                }
            }
        result += '\n';
        }
        return result;
    }
    public static void main(String[]args){
    KnightBoard q = new KnightBoard(5, 5);
    q.solve();
    System.out.println(q);
}
}

