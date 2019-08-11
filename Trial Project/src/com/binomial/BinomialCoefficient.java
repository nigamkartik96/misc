package com.binomial;

public class BinomialCoefficient {

	public static void main(String[] args) {
		System.out.println(binomial(5, 2));
	}

	static int binomial(int n, int k) {
		int[] c = new int[k + 1];
		c[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, k); j > 0; j--) {
				System.out.print(j + " ");
				c[j] = c[j] + c[j - 1];
			}
			System.out.println("\n" + c[k]);
		}
		return c[k];
	}

}
