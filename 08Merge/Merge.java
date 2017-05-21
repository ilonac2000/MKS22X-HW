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
      int i = ((a + b) / 2) + 1;
      merge(ary, a, mid);
      merge(ary, i, b);
      msh(ary, a, mid, i, b);
  }
}
public static void msh(int[] ary, int a, int b, int x, int y){
  int size = (y - a) + 1;
  int hold = 0;
  int let = 0;
  int i = a;
  int j = x; 
  int[] dest = new int[size];
  while (a <= b && x <= y){
    if (ary[a] <= ary[b]){ 
      dest[hold] = ary[a];
      a++;
    }
    else{
      dest[hold] = ary[x];
      x++;
    }
    hold++;
  }
  if (a > b){
    for(int n = b; n < y + 1; n++){
      dest[hold] = ary[n];
      hold++;
    }
  }
  else{
    for (int m = a; m < b + 1; m++){
      dest[hold] = ary[m];
      hold++;
    }
  }
  for (int m = i; m < b + 1; m++){
    ary[m] = dest[let];
    let++;
  }
  for (int n = j; n < y + 1; n++){
    ary[n] = dest[let];
    let++;
  }
}
}
