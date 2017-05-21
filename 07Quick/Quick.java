import java.util.*;

/*
-Choose a random element to be a pivot, and partition the array around it. 
-Only partition the elements from start to end inclusive.
-When done returns the index of the final position of the pivot element. (Should be from start to end inclusive)*/
public class Quick{

public static int[] part(int [] data, int start, int end){
	int pivot = ((int)(start + (Math.random() * (end - start + 1))));
	int need = data[pivot];
	//System.out.println(pivot);
	int[] hold = new int[data.length];
	int lt = start;
	int gt = end;
	for (int i = start; i <= end; i++){
		if (data[i] < need){
			hold[lt] = data[i];
			lt++;
		}
		else if(data[i] > data[pivot]){
			hold[gt] = data[i];
			gt--;
		}
	}
	for(int j = lt; j <= gt; j++){
		hold[j] = need;
	}
	for (int k = start; k <= end; k++){
		data[k] = hold[k];
	}
	int[] result = new int[2];
	result[0] = lt - 1;
	result[1] = gt + 1;
	return result;
}


public static int quickselect(int []data, int k){
	return quicksh(data, k - 1, 0, data.length - 1);
}

public static int quicksh(int []a, int k, int start, int end){
	int[] result = part(a, start, end);
	if ((result[0] <= k) && result[1] >= k){
		return a[result[0]];
	}
	else if(result[0] > k){
		return quicksh(a, k, start, result[0] - 1);
	}
	else{
		return quicksh(a, k, result[1] + 1, end);
	}
}


public static void quicksort(int[] a){
	qsh(a, 0, a.length - 1);
}

public static void qsh(int[] data, int start, int end){
	if (start < end){
		int[] p = part(data, start, end);
		qsh(data, start, p[0]);
		qsh(data, p[1], end);
		}
	}

}
