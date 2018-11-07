package com.epam.prj02.logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import com.epam.prj02.bean.Mp3File;

public class OperationWithMp3 {
	private List<Mp3File> mp3FileList = new ArrayList<Mp3File>();

	public List<Mp3File> getFileData(File dir) {
		AudioMp3Parser mp3Parser = new AudioMp3Parser();

		File[] listOfFiles = dir.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				/*
				 * Mp3File mp3Description = new Mp3File();
				 * mp3Description.setName(file.getName());
				 */
				try {
					Mp3File mp3File = mp3Parser.mp3FileParser(file);
					mp3FileList.add(mp3File);
				} catch (IOException | SAXException | TikaException e) {
					e.printStackTrace();
				}
			} else if (file.isDirectory()) {
				getFileData(file);
			}
		}
		return mp3FileList;
	}
}
