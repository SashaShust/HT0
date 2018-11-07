package com.epam.prj02.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.prj02.bean.Mp3File;
import com.epam.prj02.logic.FindDuplicatesCheckSumAlgorithm;
import com.epam.prj02.logic.HTMLGenerator;
import com.epam.prj02.logic.OperationWithMp3;

public class Main {

	static Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		// logger.error("error");

		OperationWithMp3 operationWithMp3 = new OperationWithMp3();
		File folder = new File("c:\\test\\mp3\\");

		List<Mp3File> mp3FileList = operationWithMp3.getFileData(folder);

		HTMLGenerator htmlGenerator = new HTMLGenerator();
		StringBuilder sbMp3 = htmlGenerator.buildHTML(mp3FileList);
		String mp3 = sbMp3.toString();
		htmlGenerator.generateHTMLFile(mp3);

		// -----------------Leave only files with equal checkSum
		FindDuplicatesCheckSumAlgorithm checkSum = new FindDuplicatesCheckSumAlgorithm();
		List<Mp3File> resultFileList = checkSum.findCheckSumDuplicates(mp3FileList);
		logger.info("-------Task 2.1--------");
		for (Mp3File mp3File : resultFileList) {
			System.out.println(mp3File);
			logger.info(mp3File);
		}
		// -----------------Leave only files with duplicate metadata
		FindDuplicatesMp3FilesAlgorithm alg = new FindDuplicatesMp3FilesAlgorithm();
		List<Mp3File> result = alg.findMetadataDuplicates(mp3FileList);
		logger.info("-------Task 2.2--------");
		for (Mp3File mp3File : result) {
			System.out.println(mp3File);
			logger.info(mp3File);
		}

	}

	public static List<Mp3File> createTestData() {
		List<Mp3File> mp3FileList = new ArrayList<Mp3File>();

		mp3FileList.add(new Mp3File("The Beatles", "Help!", "Help!", 3, "Path", "CheckSum"));
		mp3FileList.add(new Mp3File("The Beatles", "Help!", "The Night Before", 3.2, "Path", "CheckSum1"));
		mp3FileList.add(new Mp3File("The Beatles", "Help!", "Another Girl", 3.1, "Path", "CheckSum2"));

		mp3FileList.add(new Mp3File("The Beatles", "Let It Be", "Two of Us", 2.8, "Path", "CheckSum1"));
		mp3FileList.add(new Mp3File("The Beatles", "Let It Be", "Across the Universe", 3.3, "Path", "CheckSum"));
		mp3FileList.add(new Mp3File("The Beatles", "Let It Be", "Maggie Mae", 3.7, "Path", "CheckSum1"));

		mp3FileList.add(new Mp3File("Rammstein", "Mutter", "Links 2-3-4", 3.3, "Path", "CheckSum"));
		mp3FileList.add(new Mp3File("Rammstein", "Mutter", "Sonne", 4.3, "Path", "CheckSum2"));
		mp3FileList.add(new Mp3File("Rammstein", "Mutter", "Mutter", 3.29, "Path", "CheckSum2"));

		mp3FileList.add(new Mp3File("Rammstein", "Rosenrot", "Benzin", 3.46, "Path", "CheckSum1" + ""));
		mp3FileList.add(new Mp3File("Rammstein", "Rosenrot", "Rosenrot", 3.5, "Path", "CheckSum"));
		mp3FileList.add(new Mp3File("Rammstein", "Rosenrot", "Feuer und Wasser", 5.2, "Path", "CheckSum"));
		return mp3FileList;
	}
}
