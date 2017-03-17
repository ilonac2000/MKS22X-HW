import java.util.*;

/*
-Choose a random element to be a pivot, and partition the array around it. 
-Only partition the elements from start to end inclusive.
-When done returns the index of the final position of the pivot element. (Should be from start to end inclusive)*/
public class Quick{

public static int part(int [] data, int start, int end){
	int pivot = (int)(Math.random() * (end - start + 1)) + start;
	pivot = data[pivot];
	//System.out.println(data[pivot]);
	while (start < end){
	while (data[start] < pivot){
		start++;
	}
	while (data[end] > pivot){
		end--;
	}
	if (start < end){
		int hold = data[start];
		data[start] = data[end];
		data[end] = hold;
	}
	}
	return end;
}

/*public static int quickselect(int []data, int k){
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
}*/

public static void main(String[]args){
  Random r = new Random();
  int[]ary = { 0, -1, -5, -3, -4, -2};
  int[]ary2 = { 0, 0, -5, 0, -4, 0};
  int[] integers = new int[1];
   for (int i = 0; i < integers.length; i++) {
    integers[i] = r.nextInt();
    }

System.out.println(part(ary2 , 0, ary2.length - 1)); 
//System.out.println(part( integers , 0, integers.length - 1 ));
   for (int i : ary2) {
      System.out.print(i + ", ");
    } 
  /* for (int i : integers) {
      System.out.print(i + ", ");
    } */
//System.out.println(quickselect( ary , 2 )); //  would return 5
//System.out.println(quickselect( ary , 3 )); //  would return 10
//System.out.println(quickselect( ary , 4 )); //  would return 15
//System.out.println(quickselect( ary , 5 )); //  would return 23
}
}
