import java.util.*;

public class MyHeap{
	private int size;
	private int constant;
	private ArrayList<String> heaps;	

	public MyHeap(){
		size = 0;
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
		size = 0;
		heaps = new ArrayList<String>();
			 
	}
	public void add(String s){
		heaps.set(size + 1, s);
		pushUp(size - 1);
	}
	public String remove(){	
		String result = heaps.get(1);
		heaps.set(1, size);
		heaps.size += 1;
		pushDown(size - 1);
		return result;
	}
	public String peek(){
		if ((heap.size() - 1) < 1){
	    throw new NoSuchElementException("No such element in peek method");
		}
		else if ((heap.size() - 1) == 1){
	    	return "Nothing there";
	    }
	    else{
		return heaps.get(1);
		}
	}
	private void pushUp(int index){
		while ((heaps.get(index).compareTo(heaps.get(index / 2)) * constant) < 0){
			switches(index, index / 2);	
			index = index / 2;
		}
	}	
	private void pushDown(int index){
		while ((heaps.get(index).compareTo(heaps.get(index / 2)) * constant) > 0){
			switches(index, index / 2);	
			index = index / 2;
		}
	}
	private void switches(int i, int j){
		String hold = heaps.get(j);
		heaps.set(j, heaps.get(i));
		heaps.set(i, hold);
	}
}
