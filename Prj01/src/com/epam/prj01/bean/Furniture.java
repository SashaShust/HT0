package com.epam.prj01.bean;

public class Furniture {
	private String name;
	private double square;
	private double fromSquare;
	private double toSquare;

	public Furniture() {
		super();
	}

	public Furniture(String name, double square) {
		super();
		this.name = name;
		this.square = square;
	}

	public Furniture(String name, double fromSquare, double toSquare) {
		super();
		this.name = name;
		this.fromSquare = fromSquare;
		this.toSquare = toSquare;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public double getFromSquare() {
		return fromSquare;
	}

	public void setFromSquare(double fromSquare) {
		this.fromSquare = fromSquare;
	}

	public double getToSquare() {
		return toSquare;
	}

	public void setToSquare(double toSquare) {
		this.toSquare = toSquare;
	}

	@Override
	public String toString() {
		String result = "Furniture [name=" + name;
		if (square != 0) {
			result += ", square=" + square + "]";
		}
		if (fromSquare != 0 && toSquare != 0) {
			result += ", fromSquare=" + fromSquare + ", toSquare=" + toSquare + "]";
		}
		return result;
	}
}
