package com.subset;

public class SubSet {

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;

		if (isSubsetSum(n, sum, set)) {
			System.out.println("Found a subset with the given sum");
		} else {
			System.out.println("Not Found");
		}
	}

	public static boolean isSubsetSum(int n, int sum, int[] set) {

		if (sum == 0) {
			return true;
		}
		if (n == 0 && sum != 0) {
			return false;
		}

		if (set[n - 1] > sum) {
			return isSubsetSum(n - 1, sum, set);
		}

		return isSubsetSum(n - 1, sum, set) || isSubsetSum(n, sum - set[n - 1], set);
	}

}
