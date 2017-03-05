import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private int startr;
    private int startc;
    private boolean s;
    private boolean end;
    private String total;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)
      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
      s = false;
      end = false;
      setAnimate(false);
      load(filename);
    }

    private void load(String filename){
      try {
          Scanner sc = new Scanner(new File(filename));
          //System.out.println("scanned");
          int lines = 0;
          while(sc.hasNextLine()){
              total += sc.nextLine();
              lines += 1;
            }
          //System.out.println(total);
          //System.out.println(lines);
          maze = new char[lines][lines];
          for (int i = 0; i < lines; i++){
            for(int j = 0; j < lines; j++){
              char c = total.charAt(0);
              //System.out.println(c);
              total = total.substring(1);
              maze[i][j] = c;
              if(c == 'S'){
                startr = i;
                //System.out.println(startr);
                startc = j;
                //System.out.println(startc);
                s = true;
              }
              if(c == 'E'){
                end = true;
              }
            }
          }
        }
        catch (FileNotFoundException e){
          System.out.println("File Does Not Exist");
          System.exit(0);
        }
        if (!(s || end)){
          System.out.println("File Does Not Contain a Start/End");
          System.exit(0);
        }
    }
  
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            //Initialize starting row and startint col with the location of the S. 
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:
      A solved maze has a path marked with '@' from S to E.
      Returns true when the maze is solved,
      Returns false when the maze has no solution.
      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
        if (isValid(row, col) && maze[row][col] == 'E'){
            return true;
        }
        if (isValid(row, col)){
          maze[row][col] = '@';
          if(solve(row + 1, col)){
              return true;
          }
          if(solve(row, col + 1)){
              return true;
          }
          else{
            maze[row][col] = '.';
              }
          }
        //COMPLETE SOLVE
        return false; //so it compiles
    }

    private boolean isValid(int row, int col){
      return ((row < maze.length) &&
              (col < maze.length) &&
              (maze[row][col] != '#'));
    }

    public String toString(){
      String result = "";
      for (int r = 0; r < maze.length; r++){
        for (int c = 0; c < maze.length; c++){
          result += maze[r][c];
        }
      }
      return result;
    }

    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.
        
        //f.setAnimate(false);
        f.solve();

       System.out.println(f);
    }

}
