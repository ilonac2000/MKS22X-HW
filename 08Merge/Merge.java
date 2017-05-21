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
    merge(ary, 0, ary.length - 1); 
}

public static void merge(int[] ary, int a, int b){
  if (b > a){
      int mid = (a + b) / 2;
      merge(ary, a, mid);
      merge(ary, mid + 1, b);
      msh(ary, a, mid, mid + 1, b);
  }
}
public static void msh(int[] ary, int a, int b, int x, int y){
  int size = (y - a) + 1;
  int hold = 0;
  int i = a;
  int[] dest = new int[size];
  while ((a <= b) && (x <= y) && (hold < size)){
    if (ary[a] <= ary[x]){ 
      dest[hold] = ary[a];
      a++;
      hold++;
    }
    else{
      dest[hold] = ary[x];
      x++;
      hold++;
    }
  }
  while (b >= a){
      dest[hold] = ary[a];
      a++;
      hold++;
  }
  while(y >= x){
      dest[hold] = ary[x];
      x++;
      hold++;
    }
  for (int m = 0; m < size; m++){
    ary[i] = dest[m];
    i++;
  }
}
}
