import java.util.*;

public class MyHeap{
	private int size;
	private int constant;
	private ArrayList<String> heaps;	

	public MyHeap(){
		size = 0;
		heaps = new ArrayList<String>();
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
		pushUp(size + 1);
	}
	public String remove(){	
		String result = heaps.get(1);
		heaps.set(1, size);
		heaps.size += 1;
		return result;
	}
	public String peek(){
		return heaps.get(1);
	}
	private void pushUp(int index){
		while ((heaps.get(index).compareTo(heaps.get(index / 2)) * constant) < 0){
			switch(index, index / 2);	
		}
	}	
	private void pushDown(int index){
		
	}

	private void switch(int i, int j){
		
	}
}
