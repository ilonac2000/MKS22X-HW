public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

   public void solve(){
        solveH(0);
    }

    public boolean solveH(int c){
        if (c >= board.length){
            return true;
        }
        for (int i = 0; i < board.length; i++){
            if (isValid(i, c)){
                addQueen(i, c);
                if(solveH(c + 1)){
                    return true;
                }
                else{
                    removeQueen(i, c);
                }
            }
        }
        return false;
    }

    public boolean isValid(int r, int c){
       return (board[r][c] == 0);
    }
    private void addQueen(int r, int c){
        for(int i = 0; i < board.length; i++){
            board[r][i] += 1;
        } 
        for(int i = 0; i < board.length; i++){
            board[i][c] += 1;
        } 
        for (int i = 0; (i + c < board.length) && (i + r < board.length); i++){
            board[r + i][c + i] += 1;
        }
        for (int i = 0; (c - i > -1) && (r - i > -1); i++){
            board[r - i][c - i] += 1;
        }
        for (int i = 0; (c + i < board.length) && (r - i > -1); i++){
            board[r - i][c + i] += 1;
        }
        for (int i = 0; (c - i > -1) && (r + i < board.length); i++){
            board[r + i][c - i] += 1;
        }
        board[r][c] = -1;
    }   

    private void removeQueen(int r, int c){
        for(int i = 0; i < board.length; i++){
            board[r][i] -= 1;
        } 
        for(int i = 0; i < board.length; i++){
            board[i][c] -= 1;
        } 
        for (int i = 0; (i + c < board.length) && (i + r < board.length); i++){
            board[r + i][c + i] -= 1;
        }
        for (int i = 0; (c - i > -1) && (r - i > -1); i++){
            board[r - i][c - i] -= 1;
        }
        for (int i = 0; (c + i < board.length) && (r - i > -1); i++){
            board[r - i][c + i] -= 1;
        }
        for (int i = 0; (c - i > -1) && (r + i < board.length); i++){
            board[r + i][c - i] -= 1;
        }
        board[r][c] = 0;
    }   
    public String toString(){
        String result = "";
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board.length; c++){
                if(board[r][c] == -1){
                    result += "Q" + " ";
                }
                else{
                    result += "_" + " ";
                }
            }
        result += '\n';
        }
        return result;
    }

public static void main(String[]args){
    QueenBoard q = new QueenBoard(4);
   // q.addQueen(1,1);
   // System.out.println(q.isValid(1,2));
    q.solve();
    System.out.println(q);
}
}

    //private void removeQueen(int r, int c)
