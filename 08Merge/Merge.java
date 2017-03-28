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
		size = ary.length / 2
		int[]left = new int[size];
		int[]right = new int[ary.length - size];
		for (int i = 0; i < size; i++){
			left[i] = ary[i];
		}
		for (int j = size; j < ary.length, j++){
			right[j - size] = ary[j];
		}
		mergesort(left);
		mergesort(right);
		merge(left, right, ary);	
	}
}



void merge(int[]a,int[]b,int[]destination){
   merge(left, right, inputArray);
    }

}
