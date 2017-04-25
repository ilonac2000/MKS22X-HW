import java.util.*;
public class StackCalc{
	public static double eval(String s){
		String[] tokens = s.split(" ");
		Stack<String> values = new Stack<String>();
		for (String token : tokens){
			if (isOp(token)){
				values.push(apply(token, " " + values.pop()," " + values.pop()));
			}
			else{
				values.push(token);
			}
		}
		return Double.parseDouble( " " + values.pop());
	}

	private static boolean isOp(String s){
		return (s.equals("+") ||
				s.equals("-") ||
				s.equals("/") ||
				s.equals("*") ||
				s.equals("%"));
	}

	private static String apply(String s, String t, String u){
		String result = " ";
		double a = Double.parseDouble(u);
		double b = Double.parseDouble(t);
		if (s.equals("+")){
			result +=  a + b;
		} 
		else if (s.equals("-")){
			result += a - b;
		}
		else if (s.equals("/")){
			result +=  a / b;
		}
		else if (s.equals("*")){
			result +=  a * b;
		}
		else{
			result +=  a % b;
		}
		return result;
	}

}
