package com.epam.prj02.bean;

public class Mp3File {
	private String artist;
	private String album;
	private String name;
	private double duration;
	private String path;

	public Mp3File() {
		super();
	}

	public Mp3File(String artist, String album, String name, double duration, String path) {
		super();
		this.artist = artist;
		this.album = album;
		this.name = name;
		this.duration = duration;
		this.path = path;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Mp3File [artist=" + artist + ", album=" + album + ", name=" + name + ", duration=" + duration
				+ ", path=" + path + "]";
	}

}
