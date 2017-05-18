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
	/*public static void main(String [ ] args){
		Location x = new Location(2, 3, null, 10, 10, true);
		Location y = new Location(2, 4, null, 14, 9, true);
		System.out.println(x.compareTo(y));
		System.out.println(" ");		
		
		Location x1 = new Location(2, 3, null, 100, 100, true);
		Location y1 = new Location(2, 4, null, 9, 14, true);
		System.out.println(x1.compareTo(y1));
		System.out.println(" ");

		Location x2 = new Location(2, 3, null, 10, 10, false);
		Location y2 = new Location(2, 4, null, 14, 9, false);
		System.out.println(x2.compareTo(y2));
		System.out.println(" ");

		Location x3 = new Location(2, 3, null, 10, 10, false);
		Location y3 = new Location(2, 4, null, 9, 14, false);	
		System.out.println(x3.compareTo(y3));
		System.out.println(" ");
	}*/
 
}
