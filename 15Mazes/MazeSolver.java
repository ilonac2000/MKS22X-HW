import java.lang.*;
import java.util.*;

public class MazeSolver{
	private Maze board;
	private boolean animated;
	private Frontier front;


	public void MazeSolver(String filename){
		this(filename, false);
	}
	public void MazeSolver(String filename, boolean animate){
		animated = animate;
		board = new Maze(filename);
	}

	public void solve(){
		solve(1);
	} 

	public void solve(int i){
		if (i == 0){
			//DFS
			front = new StackFrontier();
		}
		if (i == 1){
			//BFS
			front = new StackFrontier();
		}
		if (i == 2){
			//BestFirst
			front = new StackFrontier();
		}
		if (i == 3){
			//A*
			front = new StackFrontier();
		}
	}
}
