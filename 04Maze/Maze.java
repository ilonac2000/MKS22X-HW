import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private int startr;
    private int startc;
    private boolean s;
    private boolean end;
    private String l;


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
          Scanner sc1 = new Scanner(new File(filename));
          //System.out.println("scanned");
          int lines = 0;
          while(sc1.hasNextLine()){
              l = sc1.nextLine();
              lines += 1;
            }
          //System.out.println(total);
          //System.out.println(lines);
          maze = new char[lines][l.length()];
          Scanner sc = new Scanner(new File(filename));
          while(sc.hasNextLine()){
            for (int i = 0; i < lines; i++){
            String line = sc.nextLine();
            //System.out.println(line);
            //System.out.println(sc.next());
          
            for(int j = 0; j < l.length(); j++){
              
             //for(int k = 0; k < line.length(); k++){
            //char c = sc.next().charAt(k);
                char c = line.charAt(j);
             // System.out.print(c);
             // total = total.substring(1);
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
              //}
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
        //System.out.println(maze.toString());
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
       //if (isValid(row, col)){
        if (maze[row][col] == 'E'){
            return true;
        }
       if (isValid(row, col)){
          maze[row][col] = '@';
           if(solve(row - 1, col) || 
             (solve(row, col + 1)) ||
             (solve(row, col - 1)) ||
             solve(row + 1, col)){
              return true;
          }    
          maze[row][col] = '.';
          //return false;
         }
        // }
        //COMPLETE SOLVE
        return false; //so it compiles
    }

    private boolean isValid(int row, int col){
      return ((row < maze.length) &&
              (row >= 0) &&
              (col >= 0) &&
              (col < maze[0].length) &&
              (maze[row][col] == ' ') 
             //&& (maze[row][col] != '.')
              );
    }

    public String toString(){
      String result = "";
      for (int r = 0; r < maze.length; r++){
        for (int c = 0; c < maze[0].length; c++){
          result += maze[r][c];
        }
        result += '\n';
      }
      return result;
    }

    /*public static void main(String[]args){
        Maze f;
        f = new Maze("data3.dat");//true animates the maze.
        
        //f.setAnimate(false);
        System.out.println(f);
        f.solve();

       System.out.println(f);
    }*/

}
