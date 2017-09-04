package revision.dp;

import java.util.*;

// 1 1 2 3 5 8
public class FibonacciDP {
	
	int[] fib = null;

	public int fibonacci(int n) {
		
		if (n < 0)
			throw new IllegalArgumentException("Invalid arguments");
		fib = new int[n+1];
		
		for (int i=0;i<=n;i++) {
			fib[i]=-1;
		}
		return process(n);
	}

	public int process(int n) {
		if (n <= 1) {
			if (fib[n]==-1)
				fib[n]=n;
			return fib[n];
		}
		if (fib[n]==-1) {
			fib[n]=process(n-1)+process(n-2);
		}
		return fib[n];

	}

	public static void main(String[] argv) {

		FibonacciDP fDP = new FibonacciDP();
		System.out.println("fib(0):"+fDP.fibonacci(0));
		System.out.println("fib(1):"+fDP.fibonacci(1));
		System.out.println("fib(2):"+fDP.fibonacci(2));
		System.out.println("fib(5):"+fDP.fibonacci(5));
		System.out.println("fib(6):"+fDP.fibonacci(6));

	}

}