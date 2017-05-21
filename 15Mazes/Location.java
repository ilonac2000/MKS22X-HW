import java.lang.*;

public class Location implements Comparable<Location>{
	private int row;
	private int col;
	private int DTG;
	private int DTS;
	private Location prev;
	private boolean a;

	public Location(int r, int c, Location previous, int dist, int goal, boolean aStar){
		row = r;
		col = c;
		prev = previous;
		DTS = dist;
		DTG = goal;
		a = aStar;
	}
	public int compareTo(Location other){
		if (a){
			int one = DTS + DTG;
			int two = other.DTS + other.DTG;
			return one - two;
		}
		else{
		 	return DTG - other.DTG;
		}
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	public int getDTG(){
		return DTG;
	}
	public int getDTS(){
		return DTS;
	}
}
