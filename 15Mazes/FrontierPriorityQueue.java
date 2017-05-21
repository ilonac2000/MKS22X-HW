import java.lang.*;
import java.util.*;

public class FrontierPriorityQueue implements Frontier{
	private PriorityQueue<Location> front = new PriorityQueue<Location>();
	
	public Location next(){
		Location result = front.peek();
		front.remove(result);
		return result; 
	}
	public boolean isEmpty(){
		return (front.size() == 0);
	}
	public void add(Location loc){
		front.add(loc);
	}

}
