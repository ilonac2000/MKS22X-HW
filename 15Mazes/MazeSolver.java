import java.lang.*;
import java.lang.*;
import java.util.*;

public class MazeSolver{
	private Maze board;
	private boolean animated;
	private Frontier front;
	private ArrayList<Location> poss = new ArrayList<Location>();

	public void MazeSolver(String filename){
		animated = false;
		board = new Maze(filename);
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
			front = new QueueFrontier();
		}
		if (i == 2){
			//BestFirst
			front = new FrontierPriorityQueue();
		}
		if (i == 3){
			//A*
			front = new FrontierPriorityQueue();
		}
	front.add(board.getStart());
	shp();
	}

	public void shp(){
		while(!(front.isEmpty())){
			Location nexts = front.next();
			int r = nexts.getRow();
			int c = nexts.getCol();
			board.set(r, c, '.');
			Location x = new Location(r + 1, c, nexts,  false);
			if (isValid(x)){
				poss.add(x);
			}
			x = new Location(r, c + 1, board.getEnd(), false);
			if (isValid(x)){
				poss.add(x);
			}
			x = new Location(r - 1, c, board.getEnd(), false);
			if (isValid(x)){
				poss.add(x);
			}
			x = new Location(r, c - 1, board.getEnd(), false);
			if (isValid(x)){
				poss.add(x);
			}
		}
	}

	public boolean isValid(Location y){
		return (y.getRow() < board.length &&
				y.getCol() < board[0].length &&
				y.get() != '#');
	}

}	
