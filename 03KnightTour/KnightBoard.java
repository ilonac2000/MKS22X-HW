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
        if (level ==  l * h){
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

    public boolean check(){
        for (int r = 0; r < l; r++){
            for (int c = 0; c < h; c++){
                if (board[r][c] != 0){
                    return true;
                }
            }
        }
        return false;
    }
//create the board in the specifics
    public String toString(){
        if (h < l){
        return "Larger number for columns, smaller number for rows";
        }
        boolean checked = check();
        String result = "";
        for (int r = 0; r < l; r++){
            for (int c = 0; c < h; c++){
                if (checked){
                board[r][c] += 1;
                }
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
}
