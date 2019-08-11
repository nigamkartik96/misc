package com.pattern;

import java.util.*;

class WordMap {
	public static void main(String[] args) {
		TreeMap<String, Integer> wordMap = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		String temp;
		int times = sc.nextInt();
		for (int i = 1; i <= times; i++) {
			sc = new Scanner(System.in);
			temp = sc.nextLine();
			String s[] = temp.split(" ");
			for (String sTemp : s) {
				System.out.println(sTemp);
				if (wordMap.get(sTemp.trim()) != null)
					wordMap.put(sTemp, wordMap.get(sTemp) + 1);
				else {
					wordMap.put(sTemp, 1);
				}
			}
			// System.out.println(wordMap);
			TreeMap<String, Integer> map = (TreeMap<String, Integer>) sortedMap(wordMap);
			System.out.println(map);
			System.out.println(map.firstKey());
		}
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortedMap(final Map<K, V> treeMap) {
		Comparator<K> valueComparator = new Comparator<K>() {

			@Override
			public int compare(K o1, K o2) {
				int compare = treeMap.get(o1).compareTo(treeMap.get(o2));
				if (compare == 0) {
					return 1;
				} else
					return -1 * compare;
			}
		};

		Map<K, V> map = new TreeMap<>(valueComparator);
		map.putAll(treeMap);
		return map;
	}
}