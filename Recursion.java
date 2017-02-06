public class Recursion{ 
 public static String name(){
  return "Cherepakhina,Ilona";
 }
 public static double sqrt(double n){
  return sq(n, n);
 } 
 public static double sq(double n, double result){};
 private static boolean isCloseEnough(double a, double b){
 	return (((math.abs(a - b) / ((a+b) / 2)) * 100) < .00000000001);
 }
}
