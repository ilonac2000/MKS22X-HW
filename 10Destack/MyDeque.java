import java.util.*;
public class MyDeque{
	private String[] deque;
	private int start;
	private int end;
	private int size;

	
	public MyDeque(){
		deque = new String[1];
		start = 0;
		end = 0;
		size = 0;
	}
	private void makeBigger(){
		String[] news = new String[deque.length * 2];
		for (int i = 0; i < size; i++){
			int current  = (i + start) %  deque.length;
			news[i] = deque[current];
		}
		deque = news;
		start = 0;
		end = size - 1;
	}
	public void addFirst(String x){
		if (x == null){
			throw new NullPointerException("can not add null element");
		}
		else if (size + 1 >= deque.length){
			makeBigger();
		}
		else if (size > 0){
			if (start == 0){
				start = deque.length - 1;
			}
			else{
				start = start - 1;
			}
		}
		deque[start] = x;
		size += 1;
	}
	public void addLast(String x){
		if (x == null){
			throw new NullPointerException("can not add null element");
		}
		else if (size + 1 >= deque.length){
			makeBigger();
		}
		else if (size > 0){
			end = (end + 1) % deque.length;
		}
		deque[end + 1] = x;
		size += 1;
	}
	public String removeFirst(){
		String result = " ";
		if (size == 0){
			throw new NoSuchElementException("deque is empty");
		}
		result = deque[start];
		deque[start] = null;
		size -= 1;
		start = (start + 1) % deque.length;
		return result;
	}
	public String removeLast(){
		String result = " ";
		if (size == 0){
			throw new NoSuchElementException("deque is empty");
		}
		result = deque[end];
		deque[end] = null;
		if (end - 1 < 0){
			end = deque.length - 1;
		}
		else{
			end-= 1;
		}
		size -= 1;
		return result;
	}
	public String getFirst(){
		if (size == 0){
			throw new NoSuchElementException("deque is empty");
		}
		String result = deque[start];
		return result;
	}
	public String getLast(){
			if (size == 0){
			throw new NoSuchElementException("deque is empty");
		}
		String result = deque[end];
		return result;
	}
}
