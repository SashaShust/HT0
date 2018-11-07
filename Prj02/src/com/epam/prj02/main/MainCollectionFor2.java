package com.epam.prj02.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainCollectionFor2 {

	public static void main(String[] args) {
		/*
		 * String liter = "a, b, c, a, d, a, c, e"; String[] literArray =
		 * liter.split(", ");
		 */
		List<String> literList = new ArrayList<String>();
		literList.add("a");
		literList.add("b");
		literList.add("a");
		literList.add("c");
		literList.add("d");
		literList.add("a");
		literList.add("c");
		literList.add("a");

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String string : literList) {
			if (!map.containsKey(string)) {
				map.put(string, 1);
			} else {
				map.put(string, map.get(string) + 1);
			}
		}

		List<String> resultList = new ArrayList<String>(literList);
		for (String string : literList) {
			if (map.get(string) == 1) {
				resultList.remove(string);
			}
		}

		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}

		for (String string : resultList) {
			System.out.print(string + " ");
		}

	}
}
