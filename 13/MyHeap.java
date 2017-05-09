import java.util.*;

public class MyHeap{
	private int constant;
	private ArrayList<String> heaps;	

	public MyHeap(){
		heaps = new ArrayList<String>();
		constant = 1;
	}
	public MyHeap(boolean c){
		if (c){
			constant = 1;
		}
		else{
			constant = -1;
		}
		heaps = new ArrayList<String>();
			 
	}
	public void add(String s){
		heaps.add(s);
		pushUp(heaps.size() - 1);
	}
	public String remove(){	
		String result = heaps.get(1);
		heaps.set(1, heaps.get(heaps.size() - 1));
		heaps.remove(heaps.size() - 1);
		pushDown(1);
		return result;
	}
	public String peek(){
		if (heaps.size() == 0){
	    throw new NoSuchElementException("No such element in peek method");
		}
		else if ((heaps.size() - 1) == 1){
	    	return "There is nothing there, add first please";
	    }
	    else{
		return heaps.get(1);
		}
	}
	private void pushUp(int index){
		while ((index / 2 > 0) &&
				(heaps.get(index).compareTo(heaps.get(index / 2)) * constant) < 0){
			switches(index, index / 2);	
			index = index / 2;
		}
	}	
	private void pushDown(int index){
		while ((index * 2 < heaps.size()) &&
				(heaps.get(index).compareTo(heaps.get(index * 2)) * constant) < 0){
			switches(index, index * 2);	
			index = index * 2;
		}
	}
	private void switches(int i, int j){
		String hold = heaps.get(j);
		heaps.set(j, heaps.get(i));
		heaps.set(i, hold);
	}
}
