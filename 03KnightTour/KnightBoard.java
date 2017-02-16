ppublic class KnightBoard{
    private int[][]board;
    private int[]x = {2, 2, 1, 1, -1, -1, -2, -2};
    private int[]y = {1, -1, 2, -2, 2, -2, 1, -1};
    private int l;
    private int h; 

    public KnightBoard(int startingRows,int startingCols){
    board = new int[startingRows][startingCols];
    l = startingRows;
    h = startingCols; 
	}

    public boolean solveh(int r, int c, int level){
	System.out.println(r);	
	System.out.println(c);
	System.out.println(level);		
	if (level >= l * h){
	    return true;
	}
	if (isValid(r, c)){
	    for (int i = 0; i < 8; i++){
		if(solveh(r + x[i],c + y[i], level + 1)){
		board[r][c] = level;
		return true;
		}
	}
	}
	return false;
    }
    
    public boolean isValid(int r, int c){
	return ((r < l) && (r > 0) &&
		(c < h) && (c > 0) &&
		(board[r][c] == 0));
    }

    public void solve(){
	if (!(solveh(0 , 1, 1))){
	    solveh(0, 2, 1);
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
