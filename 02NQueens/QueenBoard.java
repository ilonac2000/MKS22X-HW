public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
    board = new int[size][size];
    }

    //find the 1st solution it can and stop, 
    //this updates the board to be displayed in toString()
    public void solve(){
        solveH(0);
    }

    //Helper function for the solve() function
    private boolean solveH(int c){
        if (c == board.length){
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

    private boolean countH(int c){
        if (c == board.length){
            return true;
        }
        for (int i = 0; i < board.length; i++){
            if (isValid(i, c)){
                addQueen(i, c);
                if (countH(c + 1)){
                    solutionCount = solutionCount + 1;
                }
                removeQueen(i, c);
            }
        }
        return false;
    }

    //look for all solutions,
    //update the instance variable solutionCount to reflect the number found
    public void countSolutions(){
        countH(0);
    }
 
    //return the number of solutions, 
    //or -1 if the solver was never run.
    public int getSolutionCount(){
        if ((solutionCount == 0)){
            if ((board.length == 3) || (board.length == 2)){
                return 0;
            }
            return -1;
        }
        else{
            return solutionCount;
        }
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

/*public static void main(String[]args){
    QueenBoard q = new QueenBoard(1);
    // q.addQueen(1,1);
    q.solve();
      System.out.println(q);
   // q.countSolutions();
    //System.out.println(q.getSolutionCount());
        QueenBoard r = new QueenBoard(2);
    // q.addQueen(1,1);
    r.solve();
       System.out.println(r);
    //r.countSolutions();
    //System.out.println(r.getSolutionCount());
        QueenBoard s = new QueenBoard(4);
    // q.addQueen(1,1);
   s.solve();
       System.out.println(s);
//   s.countSolutions();
   // System.out.println(s.getSolutionCount());
}*/
}
