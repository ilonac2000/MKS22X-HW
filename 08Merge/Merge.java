import java.util.*;

public class Merge{
/*  if ...base case...
   stop!
  else
   int[]left = copy of the left side;
   int[]right = copy of the right side;
   mergesort(left)
   mergesort(right)
   mergeTheTwoHalvesIntoTheOriginalArray
*/

public static void mergesort(int[]ary){
	if (ary.length > 1){
		int size = ary.length / 2;
		int[]left = new int[size];
		int[]right = new int[ary.length - size];
		for (int i = 0; i < size; i++){
			left[i] = ary[i];
		}
		for (int j = size; j < ary.length; j++){
			right[j - size] = ary[j];
		}
		mergesort(left);
		mergesort(right);
		merge(left, right, ary);	
	}
}

public static void merge(int[]a,int[]b,int[]destination){
   int dest = 0;
   int i = 0;
   int j = 0;
   while (i < a.length && j < b.length){
   		if (a[i] <= b[j]){
   			destination[dest] = a[i];
   			dest++;
   			i++;

   		}
   		else{
   			destination[dest] = b[j];
   			dest++;
   			j++;
   		}
   	}
   	if (i < a.length){
   		destination[dest] = a[i];
   		dest++;
   		i++;
   	}
   	if (j < b.length){
   		destination[dest] = b[j];
   		dest++;
   		j++;
   	}
}
/*public static void main(String[]args){
	Random r = new Random();
	int[]ary = { 0, 1, 5, 3, 4, 2};
  	int[]ary2 = { 0, 0, -5, 0, -4, 0};
  	int[] integers = new int[6];
  	int[] integers2 = new int[6];
   	for (int i = 0; i < integers.length; i++) {
    	integers[i] = r.nextInt();
    }
    for (int i = 0; i < integers.length; i++){
    	integers2[i] = integers[i];
    }
  	mergesort(integers);
  	Arrays.sort(integers2);
  	for (int i : integers) {
     System.out.print(i + ", ");
   	}   	
   	System.out.println("!!!!!!!!!!!!!!!!!");
   	for (int i : integers2) {
     System.out.print(i + ", ");
   	} 
}*/
}
