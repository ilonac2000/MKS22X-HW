import java.lang.*;
import java.util.*;

public class MazeSolver{
	private Maze board;
	private boolean animated;
	private Frontier front;
	private boolean aS;
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
			aS = false;
		}
		else if (i == 1){
			//BFS
			front = new QueueFrontier();
			aS = false;
		}
		else if (i == 2){
			//BestFirst
			front = new FrontierPriorityQueue();
			aS = false;
		}
		else if (i == 3){
			//A*
			front = new FrontierPriorityQueue();
			aS = true; 
		}
		else{
			throw new IllegalArgumentException("Needs a vaue solve choice");
		}
	front.add(board.getStart());
	while(!(front.isEmpty())){
		Location now = front.next();
		if (dist(now, board.getEnd()) == 0){
			board.set(now.getRow(), now.getCol(), 'E');
		}
		while(now.getPrev() != null){
			now = now.getPrev();
			board.set(now.getRow(), now.getCol(), '@');
		}
		board.set(now.getRow(), now.getCol(), 'S');
	int r = now.getRow();
	int c = now.getCol();
	if (isValid(r + 1, c)){
		front.add(new Location(r + 1, c, now, dist(r + 1, c, board.getStart()),
										  dist(r + 1, c, board.getEnd()), aS));
		board.set(r + 1, c, '?');
	}
	if (isValid(r - 1, c)){
		front.add(new Location(r - 1, c, now, dist(r - 1, c, board.getStart()),
										  dist(r - 1, c, board.getEnd()), aS));
		board.set(r - 1, c, '?');
	}
	if (isValid(r, c + 1)){
		front.add(new Location(r, c + 1, now, dist(r, c + 1, board.getStart()),
										  dist(r, c + 1, board.getEnd()), aS));
		board.set(r, c + 1, '?');
	}
	if (isValid(r, c - 1)){
		front.add(new Location(r, c - 1, now, dist(r, c - 1, board.getStart()),
										  dist(r, c  - 1, board.getEnd()), aS));
		board.set(r, c - 1, '?');
	}
	}	
	}

	public boolean isValid(int r, int c){
		return (board.get(r, c) != '#');
	}
	public int dist(Location a, Location b){
		int r = Math.abs(a.getRow() - b.getRow());
		int c = Math.abs(a.getCol() - b.getCol());
		return r + c;
	}
	public int dist(int a, int b, Location e){
		int r = Math.abs(a - e.getRow());
		int c = Math.abs(b - e.getCol());
		return r + c;
	}
	public String toString(){
		if (animated){
			return board.toString(50);
		}
		else{
			return board.toString();
		}
	}
}	
