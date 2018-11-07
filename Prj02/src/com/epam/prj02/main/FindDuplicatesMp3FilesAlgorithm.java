package com.epam.prj02.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.prj02.bean.Mp3File;

public class FindDuplicatesMp3FilesAlgorithm {

	public List<Mp3File> findMetadataDuplicates(List<Mp3File> literList) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Mp3File file : literList) {
			String key = file.getArtist() + file.getAlbum() + file.getName();
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}

		List<Mp3File> resultList = new ArrayList<Mp3File>(literList);
		for (Mp3File file : literList) {
			String key = file.getArtist() + file.getAlbum() + file.getName();
			if (map.get(key) == 1) {
				resultList.remove(file);
			}
		}

		return resultList;
	}

	private List<String> findMetadataDuplicates1(List<String> literList) {

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
		return literList;
	}
}
