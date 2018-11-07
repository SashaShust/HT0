package com.epam.prj02.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.prj02.bean.Mp3File;

public class HTMLGenerator {
	static Logger logger = LogManager.getLogger(HTMLGenerator.class);
	public static final String DEFAULT = "N/A";

	public StringBuilder buildHTML(List<Mp3File> mp3FileList) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>").append("<html>").append("<head>").append("<title>HTML GENERATOR</title>")
				.append("</head>").append("<body>").append("<table border='1'>");
		for (Mp3File mp3File : mp3FileList) {
			String artist = (mp3File.getArtist() != null) ? mp3File.getArtist() : DEFAULT;
			String album = (mp3File.getAlbum() != null) ? mp3File.getAlbum() : DEFAULT;
			String name = (mp3File.getName() != null) ? mp3File.getName() : DEFAULT;
			double duration = (mp3File.getDuration() != 0) ? mp3File.getDuration() : 0;
			String path = (mp3File.getPath() != null) ? mp3File.getPath() : DEFAULT;
			sb.append("<tr><td>").append(artist).append("</td><td>").append(album).append("</td><td>").append(name)
					.append("</td><td>").append(duration).append("</td><td>").append(path).append("</td></tr>");
		}
		sb.append("</table>").append("</body>").append("</html>");
		return sb;
	}

	public void generateHTMLFile(String mp3) {
		File file = new File("C:\\Test\\mp3List.html");
		FileWriter writer = null;
		try {
			file.createNewFile();
			System.out.println("File created! ");
			writer = new FileWriter(file);
			writer.write(mp3);
		} catch (IOException e) {
			logger.error("Error at the time of generating html File", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e1) {
					logger.error("Error at the time of generating html File", e1);
				}
			}
		}
	}
}
