package com.epam.prj02.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.prj02.bean.Mp3File;

public class AudioMp3Parser {
	public Mp3File mp3FileParser(File file) throws IOException, SAXException, TikaException {
		// Mp3File mp3File = new Mp3File();

		// String fileLocation = "C:/test/mp3/Sleepmakeswaves.mp3";
		Mp3File mp3File = null;
		InputStream input = null;
		try {
			input = new FileInputStream(file);
			DefaultHandler handler = new DefaultHandler();
			Metadata metadata = new Metadata();
			Parser parser = new Mp3Parser();
			ParseContext parseCtx = new ParseContext();
			parser.parse(input, (org.xml.sax.ContentHandler) handler, metadata, parseCtx);

			System.out.println("----------------------------------------------");
			// List all metadata
			String[] metadataNames = metadata.names();

			for (String name : metadataNames) {
				System.out.println(name + ": " + metadata.get(name));
			}

			// Retrieve the necessary info from metadata
			// Names - title, xmpDM:artist etc. - mentioned below may differ
			// based
			System.out.println("----------------------------------------------");

			String artist = metadata.get("xmpDM:artist");
			String album = metadata.get("xmpDM:album");
			String name = metadata.get("title");
			String textDuration = metadata.get("xmpDM:duration");
			// file.length();

			FileInputStream fis = new FileInputStream(file);
			String checkSum = DigestUtils.md5Hex(fis);
			fis.close();

			double duration = Double.parseDouble(textDuration);

			mp3File = new Mp3File(artist, album, name, duration, file.getAbsolutePath(), checkSum);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return mp3File;
	}
}
