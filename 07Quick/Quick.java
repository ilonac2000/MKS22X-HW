import java.util.*;

/*
-Choose a random element to be a pivot, and partition the array around it. 
-Only partition the elements from start to end inclusive.
-When done returns the index of the final position of the pivot element. (Should be from start to end inclusive)*/
public class Quick{

public static int part(int [] data, int start, int end){
	int pivot = (int)(Math.random() * (end - start + 1)) + start;
	for (int i = start; i <= end; i++){
	while (data[start] < pivot){
		start++;
	}
	while (data[end] > pivot){
		end--;
	}
	if (start <= end){
		int hold = data[start];
		data[start] = data[end];
		data[end] = hold;
	}
	}
	return start;
}

public static int quickselect(int []data, int k){
	int result = -1;
	int start = 0;
	int end = data.length - 1;
	while (result != k){
		result = part(data, start, end);
		if (result < k){
			start = result;
		}
		if (result > k){
			end = result;
		}
	}
	return data[k];
}

/*public static void main(String[]args){
  int[]ary = { 2, 10, 15, 23, 0,  5};
System.out.println(quickselect( ary , 0 )); //would return 0
System.out.println(quickselect( ary , 1 )); //would return 2
System.out.println(quickselect( ary , 2 )); //  would return 5
//System.out.println(quickselect( ary , 3 )); //  would return 10
//System.out.println(quickselect( ary , 4 )); //  would return 15
//System.out.println(quickselect( ary , 5 )); //  would return 23
}*/
}
