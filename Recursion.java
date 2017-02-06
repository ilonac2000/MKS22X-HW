public class Recursion{ 
 public static String name(){
  return "Cherepakhina,Ilona";
 }
 public static double sqrt(double n){
  return sq(n, n);
 } 
 public static double sq(double n, double result){
  if (n < 0){
  	throw new IllegalArgumentException("Can not be negative");
  }
  if (isCloseEnough(n * n, result)){
	//System.out.println(n);
	//System.out.println(result);
	return n;
  }
  else{
  	return sq(((1.0 / 2) * ((result / n) + n)), result);
  }
 }
 private static boolean isCloseEnough(double a, double b){
 	if ((a == 0 ) && (b == 0)){ 
 		return true;
 	}
 	return (((Math.abs(a - b) / ((a+b) / 2)) * 100) < .00000000001);
 }
public static void main(String[] args) {
  //System.out.println(sqrt(100));
	System.out.println(sqrt(0.05));
	//System.out.println(isCloseEnough(100, 100));
	//System.out.println(isCloseEnough(100.123123, 100.1231111));
	//System.out.println(isCloseEnough(1000000000, 1));

 // System.out.println(sqrt(1));
	//System.out.println(sqrt(0));
  //System.out.println(isCloseEnough(0, 0));
  //System.out.println(sqrt(-10));
  //System.out.println(sqrt(25.6));
	}
}


