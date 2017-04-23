import java.util.*;
public class MyDeque{
	private String[] deque;
	private int start;
	private int end;
	private int size;

	
	public MyDeque(){
		deque = new String[1];
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
			throw new NullPointerException("can not add null element");
		}
		if (size + 1 >= deque.length){
			makeBigger();
		}
		if (start - 1 < 0){
			start = deque.length - 1;
		}
		deque[start - 1] = x;
		size += 1;
	}
	public void addLast(String x){
		if (x == null){
			throw new NullPointerException("can not add null element");
		}
		if (size + 1 >= deque.length){
			makeBigger();
		}
		if (end + 1 >= deque.length){
			end = 0;
		}
		size += 1;
		deque[end] = x;
	}
	public String removeFirst(){
		String result = " ";
		if (size == 0){
			throw new NoSuchElementException("deque is empty");
		}
		result = deque[start];
		start += 1;
		size -= 1;
		if (start >= deque.length){
			start = 0;
		}
		return result;
	}
	public String removeLast(){
		String result = " ";
		if (size == 0){
			throw new NoSuchElementException("deque is empty");
		}
		result = deque[end];
		if (end - 1 < 0){
			end = deque.length - 1;
		}
		size -= 1;
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
