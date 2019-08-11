package com.pattern;

import java.util.Scanner;

public class Depth {

	public static void main(String[] args) {

		// System.out.println((int) (Math.log(8) / Math.log(2) + 1e-10));
		StringBuilder s = new StringBuilder("1213121212");
		/*
		 * String check = "312";
		 * 
		 * StringBuilder s1 = new StringBuilder(s.substring(1));
		 * 
		 * String sTemp = s1.reverse().toString(); int a = Integer.parseInt(check); int
		 * b = Integer.parseInt(sTemp); if (a == b) { System.out.println("true"); } else
		 * { System.out.println("false"); }
		 */
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int e = sc.nextInt();

		int size = e * 2;
		String tempValue = "";
		for (int i = 1; i <= size; i++) {
			tempValue += sc.next();
		}
		s = new StringBuilder(tempValue);
		System.out.println(s);
		tempValue = "";
		for (int i = 1; i <= size; i++) {
			tempValue += sc.next();
		}
		StringBuilder check = new StringBuilder(tempValue);
		System.out.println(check);
		System.out.println(check.substring(1));
	}

}
