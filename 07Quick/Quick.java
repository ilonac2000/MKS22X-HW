import java.util.*;

/*
-Choose a random element to be a pivot, and partition the array around it. 
-Only partition the elements from start to end inclusive.
-When done returns the index of the final position of the pivot element. (Should be from start to end inclusive)*/
public class Quick{

public static void swap(int[] data, int a, int b) {
	int hold = data[b];
	data[b] = data[a];
	data[a] = hold;
}

public static int part(int [] data, int start, int end){
	int pivot = (int)(Math.random() * (end - start + 1)) + start;
	int hold = data[pivot];
	//System.out.println(data[pivot]);
	data[pivot] = data[0];
	//pivot = hold;
	data[0] = hold;
	int lt = start;
	int gt = end;
	int i = lt;
	while (i <= gt){
		if (data[i] == pivot){
			i++;
		}
		else if(data[i] < pivot){
			swap(data, i, lt);
			i++;
			lt++;
		}
		else{
			swap(data, i, gt);
			gt--;
		}
	}
	//System.out.println("!!!!!!!!!!!!!!!");
	//System.out.println(gt);
	swap(data, pivot, gt);
	//System.out.println("!!!!!!!!!!!!!!!");
	//System.out.println(pivot);
	return gt;
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

public static void quicksort(int[] a){
	qsh(a, 0, a.length - 1);
}

public static void qsh(int[] data, int start, int end){
	int pivot = (int)(Math.random() * (end - start + 1)) + start;
	int hold = data[pivot];
	//System.out.println(data[pivot]);
	data[pivot] = data[0];
	pivot = hold;
	data[0] = pivot;
	int lt = start;
	int gt = end;
	int i = 0;
	while (i <= gt){
		if (data[i] == pivot){
			i++;
		}
		else if(data[i] < pivot){
			swap(data, i, lt);
			i++;
			lt++;
		}
		else{
			swap(data, i, gt);
			gt--;
		}
	}
	if (start >= end){
		qsh(data, start, lt);
		qsh(data, gt, end);
	}
}

/*public static void main(String[]args){
  Random r = new Random();
  int[]ary = { 0, 1, 5, 3, 4, 2};
  int[]ary2 = { 0, 0, -5, 0, -4, 0};
  int[] integers = new int[1];
   for (int i = 0; i < integers.length; i++) {
    integers[i] = r.nextInt();
    }
System.out.println(quickselect(ary, 0));
System.out.println(quickselect(ary, 1));
System.out.println(quickselect(ary, 2));
System.out.println(quickselect(ary, 3));
System.out.println(quickselect(ary, 4));
System.out.println(quickselect(ary, 5));
//System.out.println(part(ary , 0, ary2.length - 1)); 
quicksort(ary); 
//System.out.println(part( integers , 0, integers.length - 1 ));
   for (int i : ary) {
      System.out.print(i + ", ");
    } 
  /* for (int i : integers) {
      System.out.print(i + ", ");
    } */
//System.out.println(quickselect( ary , 2 )); //  would return 5
//System.out.println(quickselect( ary , 3 )); //  would return 10
//System.out.println(quickselect( ary , 4 )); //  would return 15
//System.out.println(quickselect( ary , 5 )); //  would return 23
//}
}*/
}
 
