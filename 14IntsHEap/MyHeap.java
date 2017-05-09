import java.util.*;

public class MyHeap{
	private int constant;
	private ArrayList<Integer> heaps;	

	public MyHeap(){
		heaps = new ArrayList<Integer>();
		constant = 1;
	}
	public MyHeap(boolean c){
		if (c){
			constant = 1;
		}
		else{
			constant = -1;
		}
		heaps = new ArrayList<Integer>();
			 
	}
	public void add(Integer s){
		heaps.add(s);
		pushUp(heaps.size() - 1);
	}
	public Integer remove(){	
		Integer result = heaps.get(1);
		heaps.set(1, heaps.get(heaps.size() - 1));
		heaps.remove(heaps.size() - 1);
		pushDown(1);
		return result;
	}
	public Integer peek(){
		if (heaps.size() == 0){
	    throw new NoSuchElementException("No such element in peek method");
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
		Integer hold = heaps.get(j);
		heaps.set(j, heaps.get(i));
		heaps.set(i, hold);
	}
}
