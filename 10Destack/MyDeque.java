import java.util.*;
public class MyDeque{
	private String[] deque;
	private int start;
	private int end;
	private int size;

	
	public MyDeque(){
		deque = new String[];
		start = 0;
		end = -1;
	}
	private void makeBigger(){
		String[] news = new String[deque.length * 2];
		for (int i = 0; i < size; i++){
			int current  = i + start;
			if(current < deque.length){
				news[i] = deque[current];
			}
			else{
				news[i] = deque[current - deque.length];
			}
		}
		deque = news;
		start = 0;
		end = size - 1;
	}
	public void addFirst(String x){
		if (x == null){
			throw new NullPointerException("specified element is null");
		}
		if (end == deque.length - 1){
			makeBigger();
		}

		}
	}
	public void addLast(String x){

	}
	public String removeFirst(){
		String result = " ";

		return result;
	}
	public String removeLast(){
		String result = " ";

		return result;
	}
	public String getFirst(){
		String result = " ";

		return result;
	}
	public String getLast(){
		String result = " ";

		return result;
	}
}

