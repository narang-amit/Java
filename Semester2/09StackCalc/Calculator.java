import java.lang.*;
import java.util.*;

public class Calculator {

    public static double eval(String str) {
    	String[] holder = str.split("\\s+");
    	String stringy = "+/-*%";
    	Stack stack = new Stack();
    	for (int i = 0; i < holder.length; i++) {
    		String t = holder[i];
    		if (stringy.contains(t)) {
    			double v1 = stack.pop();
    			double v2 = stack.pop();
    			if (t.equals("+")) {
    				stack.push(v1+v2);
    			}
    			else if (t.equals("-")) {
    				stack.push(v2-v1);
    			}
    			else if (t.equals("*")) {
    				stack.push(v1*v2);
    			}
    			else if (t.equals("/")) {
    				stack.push(v2/v1);
    			}
    			else {
    				stack.push(v2%v1);
    			}
    		}
    		else {
    			Double d = Double.parseDouble(t);
    			stack.push(d);
    		}
    	}
    	return stack.pop();
	}

	public static void main(String[] args){
		System.out.println(eval("1"));// is 12.0
		System.out.println(eval("11 3 - 4 + 2.5 *"));// is 30.0
		System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //is 893.0
	}
}
