public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    private void addQueen(int r, int c){
        for(int i = 0; i < board.length; i++){
            board[r][i] += 1;
        } 
        for(int i = 0; i < board.length; i++){
            board[i][c] += 1;
        } 
        for (int i = 0; i < board.length - c; i++){
            board[r + i][c + i] += 1;
        }
        for (int i = 0; c - i > -1; i++){
            board[r - i][c - i] += 1;
        }
        for (int i = 0; c - i > -1; i++){
            board[r - i][c + i] += 1;
        }
        for (int i = 0; c - i > -1; i++){
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
        for (int i = 0; i < board.length - c; i++){
            board[r + i][c + i] -= 1;
        }
        for (int i = 0; c - i > -1; i++){
            board[r - i][c - i] -= 1;
        }
        for (int i = 0; c - i > -1; i++){
            board[r - i][c + i] -= 1;
        }
        for (int i = 0; c - i > -1; i++){
            board[r + i][c - i] -= 1;
        }
        board[r][c] = 0;
    } 

    public String toString(){
        String result = "";
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++){
                result += board[r][c] + "  ";
            }
        result += '\n';
        }
        return result;
    }

public static void main(String[]args){
    QueenBoard q = new QueenBoard(4);
    q.addQueen(1,1);
    System.out.println(q);
    q.removeQueen(1,1);
    System.out.println(q);
}
}
