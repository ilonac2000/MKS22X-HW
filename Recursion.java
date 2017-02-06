public class Recursion{ 
 public static String name(){
  return "Cherepakhina,Ilona";
 }
 public static double sqrt(double n){
  return sq(n, n);
 } 
 public static double sq(double n, double result){
  if (n < 0){
  	throw IllegalArgumentExcpetion("No negatives");
  }
  if ((n * n).isCloseEnough(result)){
	return n;
  }
  else{
  	double newN = ((1 / 2) * ((result / n) + n));
  	return sq(newN, result);
  }
 }
 private static boolean isCloseEnough(double a, double b){
 	return (((Math.abs(a - b) / ((a+b) / 2)) * 100) < .00000000001);
 }
public static void main(String[] args) {
  //System.out.println(nestParen());
	}
}


