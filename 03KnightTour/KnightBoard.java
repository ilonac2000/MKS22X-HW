public class KnightBoard{
    private int[][]board;
    private int[]x = {2, 2, 1, 1, -1, -1, -2, -2};
    private int[]y = {1, -1, 2, -2, 2, -2, 1, -1};
    private int l;
    private int h; 

//Create the board
    public KnightBoard(int startingRows,int startingCols){
    board = new int[startingRows][startingCols];
    l = startingRows;
    h = startingCols; 
    }

//Helper function to solve
    public boolean solveh(int r, int c, int level){
   // System.out.println(r);  
   // System.out.println(c);
   // System.out.println(level);      
        if (level == l * h){
            return true;
        }
        for (int i = 0; i < 8; i++){
          if (isValid(r + x[i], c + y[i])){
            board[r + x[i]][c + y[i]] = level;
            if(solveh(r + x[i],c + y[i], level + 1)){
                return true;
            }
           else{
                board[r + x[i]][c + y[i]] = 0;
               }
            }
        }
        return false;
    }

//Is the square on the board and is it empty
    public boolean isValid(int r, int c){
    return ((r < l) && (r >= 0) &&
        (c < h) && (c >= 0) &&
        (board[r][c] == 0));
    }

//calls helper function starting at the first row and first column
    public void solve(){
    solveh(0 , 0, 1);
    }

//create the board in the specifics
    public String toString(){
        if (h < l){
        return "Larger number for rows, smaller number for columns";
        }
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
    /*public static void main(String[]args){
    KnightBoard q = new KnightBoard(7, 7);
    q.solve();
    System.out.println(q);
}*/
}
