import java.util.*;

public class Recursion {

	public int fact(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		else if (n == 0) {
			return 1;
		}
		return n * fact(n-1);
	}
	
	public int fib(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (n < 2) {
			return n;
		}
		return helperFib(0,1,n);
	}

	public int helperFib(int fib1, int fib2, int cnt) {
		if (cnt == 0) {
			return fib1;
		}
		return helperFib(fib2,fib2+fib1,cnt-1);
	}

	public double sqrt(double n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (n == 0) {
			return 0.0;
		}
		return sqrtHelper(n,1.0);
	}

	public double sqrtHelper(double n, double guess) {
		double upperBound = 1.00001*n;
		double lowerBound = .999999*n;
		double guessSq = guess *guess;
		if (guessSq < upperBound && guessSq > lowerBound) {
			return guess;
		}
		double guessPrime = (n / guess + guess) /2;
		return sqrtHelper(n,guessPrime);
	}

	/*public static void main(String[] args) {
		Recursion x = new Recursion();
		System.out.println(x.fib(0));
		System.out.println(x.fib(1));
		System.out.println(x.fib(2));
		System.out.println(x.fib(3));
		System.out.println(x.fib(4));
		System.out.println(x.fib(6));
	}
	*/
}