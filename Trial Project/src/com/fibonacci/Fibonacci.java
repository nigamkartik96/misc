package com.fibonacci;

public class Fibonacci {

	public long fibonacci(int n) {
		long a = 1, b = 1, i, c;

		if (n <= 0) {
			return 0;
		}
		if (n == 1 && n == 2) {
			return 1;
		}

		for (i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}

		return b;

		// 0 1 1 2 3 5 8 13 21
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.fibonacci(10));
	}

}
