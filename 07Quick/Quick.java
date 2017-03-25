import java.util.*;

/*
-Choose a random element to be a pivot, and partition the array around it. 
-Only partition the elements from start to end inclusive.
-When done returns the index of the final position of the pivot element. (Should be from start to end inclusive)*/
public class Quick{

public static void swap(int[] data, int a, int b) {
	int hold = data[a];
	data[a] = data[b];
	data[b] = hold;
}

public static int part(int [] data, int start, int end){
	int pivot = (int)(Math.random() * (end - start)) + start;
	//System.out.println(pivot);
	int hold = data[pivot];
	int lt = start;
	int gt = end - 1;
	int i = start;
	swap(data, start, pivot);
	while (i <= gt){
		if (data[i] == hold){
			i++;
		}
		else if(data[i] < hold){
			swap(data, i, lt);
			i++;
			lt++;
		}
		else{
			swap(data, i, gt);
			gt--;
		}
	}
	return gt;
}

public static int quickselect(int []data, int k){
	return quicksh(data, k, 0, data.length);
}

public static int quicksh(int []a, int k, int start, int end){
	int result = part(a, start, end);
	if (result < k){
		return quicksh(a, k, result + 1, end);
	}
	else if(result > k){
		return quicksh(a, k, start, result);
	}
	else{
		return a[k];
	}

}


public static void quicksort(int[] a){
	qsh(a, 1, a.length);
}

public static int[] qshp(int[] data, int start, int end){
	int pivot = (int)(Math.random() * (end - start)) + start;
	//System.out.println(pivot);
	int hold = data[pivot];
	int lt = start;
	int gt = end - 1;
	int i = start;
	swap(data, start, pivot);
	while (i <= gt){
		if (data[i] == hold){
			i++;
		}
		else if(data[i] < hold){
			swap(data, i, lt);
			i++;
			lt++;
		}
		else{
			swap(data, i, gt);
			gt--;
		}
	}
	int [] result = new int[2];
	result[0] = lt;
	result[1] = gt;
	return result;
}

public static void qsh(int[] data, int start, int end){
	if (start < end){
		int[]result = qshp(data, start, end);
		qsh(data, start, result[0] - 1);
		qsh(data, result[1] + 1, end);
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
    //System.out.println(part(ary, 0, ary.length));
/*System.out.println(quickselect(ary, 0));
System.out.println(quickselect(ary, 1));
System.out.println(quickselect(ary, 2));
System.out.println(quickselect(ary, 3));
System.out.println(quickselect(ary, 4));
System.out.println(quickselect(ary, 5));*/

//System.out.println(part(ary , 0, ary2.length - 1)); 
//quicksort(ary); 
//System.out.println(part( integers , 0, integers.length - 1 ));
   //for (int i : ary) {
   //  System.out.print(i + ", ");
   //} 
 // for (int i : integers) {
   //   System.out.print(i + ", ");
    //}
//System.out.println(quickselect( ary , 2 )); //  would return 5
//System.out.println(quickselect( ary , 3 )); //  would return 10
//System.out.println(quickselect( ary , 4 )); //  would return 15
//System.out.println(quickselect( ary , 5 )); //  would return 23
//}

}
 
