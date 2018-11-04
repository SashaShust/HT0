package com.epam.prj01.bean;

public class Lightbulb {
	private int illuminance;

	public Lightbulb() {
		super();
	}

	public Lightbulb(int illuminance) {
		super();
		this.illuminance = illuminance;
	}

	public int getIlluminance() {
		return illuminance;
	}

	public void setIlluminance(int illuminance) {
		this.illuminance = illuminance;
	}

	@Override
	public String toString() {
		return "Lightbulb [illuminance=" + illuminance + "]";
	}
}
