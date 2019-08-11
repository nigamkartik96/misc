package com.prime;

public class ArrangeInPowers {

	public static void main(String[] args) {
		int a[] = { 64, 81, 32, 125, 49 };

		printPrimeArray(a, a.length);
	}

	public static void printPrimeArray(int[] a, int n) {
		int b[] = new int[n];
		int prime;
		for (int i = 0; i < n; i++) {
			prime = getPrimeFactor(a[i]);
			b[i] = getPower(prime, a[i]);
		}

		// Selection Sort
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (b[i] > b[j]) {
					int temp = b[i];
					b[i] = b[j];
					b[j] = temp;

					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(a[i] + " Power: " + b[i]);
		}
	}

	public static int getPrimeFactor(int a) {
		int prime = 0;
		for (int i = 2; i <= a / 2; i++) {
			if (a % i == 0) {
				if (isPrime(i)) {
					prime = i;
					break;
				}
			}
		}
		return prime;
	}

	public static boolean isPrime(int i) {
		if (i == 2) {
			return true;
		}

		for (int j = 2; j <= i / 2; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

	public static int getPower(int prime, int num) {
		int count = 0;
		while (num % prime == 0) {
			count++;
			num = num / prime;
		}
		return count;
	}
}
