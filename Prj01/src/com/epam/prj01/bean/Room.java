package com.epam.prj01.bean;

import java.util.ArrayList;
import java.util.List;

import com.epam.prj01.exception.SpaceUsageTooMuchException;

public class Room {
	private String roomId;
	private double square;
	private int numberOfWindow;
	private List<Furniture> furnitureList = new ArrayList<Furniture>();
	private List<Lightbulb> lightsList = new ArrayList<Lightbulb>();

	public static final int WINDOW_ILUMINANCE = 700;

	public Room() {
		super();
	}

	public Room(String roomId, double square, int numberOfWindow) {
		super();
		this.roomId = roomId;
		this.square = square;
		this.numberOfWindow = numberOfWindow;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		if (square < 1) {
			System.out.println("The area of the room must be greater than 1, please, try again");
		}
		this.square = square;
	}

	public int getNumberOfWindow() {
		return numberOfWindow;
	}

	public void setNumberOfWindow(int numberOfWindow) {
		this.numberOfWindow = numberOfWindow;
	}

	public List<Furniture> getfurnitureList() {
		return furnitureList;
	}

	public void setFurnitureList(List<Furniture> furnitureList) {
		this.furnitureList = furnitureList;
	}

	public List<Lightbulb> getLightList() {
		return lightsList;
	}

	public void setLightList(List<Lightbulb> lights) {
		this.lightsList = lights;
	}

	@Override
	public String toString() {
		String result = "Room :roomId=" + roomId + ", square=" + square + ", numberOfWindow=" + numberOfWindow;
		if ((furnitureList != null) && (furnitureList.size() > 0)) {
			result += ", furniture=" + furnitureList;
		}
		if (lightsList != null && lightsList.size() > 0) {
			result += ", lights=" + lightsList;
		}
		return result;
	}

	public int sumIlluminance() {
		int resultIlluminance = 0;
		if (numberOfWindow > 0) {
			resultIlluminance += (numberOfWindow * WINDOW_ILUMINANCE);
		}
		if ((lightsList != null) && (lightsList.size() > 0)) {
			for (Lightbulb lightbulb : lightsList) {
				resultIlluminance += lightbulb.getIlluminance();
			}
		}
		return resultIlluminance;
	}

	public double sumFurnitureSquare() {
		double resultSumFurnSquare = 0;
		if ((furnitureList != null) && (furnitureList.size() > 0)) {
			for (Furniture furniture : furnitureList) {
				if (furniture.getSquare() > 0) {
					resultSumFurnSquare += furniture.getSquare();
				}
			}
		}
		return resultSumFurnSquare;
	}

	public double sumFromFurnitureSquare() {
		double resultSumFromFurnSquare = 0;
		if ((furnitureList != null) && (furnitureList.size() > 0)) {
			for (Furniture furniture : furnitureList) {
				if (furniture.getFromSquare() > 0) {
					resultSumFromFurnSquare += furniture.getFromSquare();
				}
			}
		}
		return resultSumFromFurnSquare;
	}

	public double sumToFurnitureSquare() {
		double resultSumToFurnSquare = 0;
		if ((furnitureList != null) && (furnitureList.size() > 0)) {
			for (Furniture furniture : furnitureList) {
				if (furniture.getToSquare() > 0) {
					resultSumToFurnSquare += furniture.getToSquare();
				}
			}
		}
		return resultSumToFurnSquare;
	}

	public String describeRoom() {
		String describe = roomId + "\n" + "  Illuminance = " + sumIlluminance();
		if (numberOfWindow > 0) {
			describe += " :" + numberOfWindow + " windows of " + WINDOW_ILUMINANCE + " lux ";
		}
		if ((lightsList != null) && (lightsList.size() > 0)) {
			describe += " bulbs : ";
			for (Lightbulb lightbulb : lightsList) {
				describe += lightbulb.getIlluminance() + ", ";
			}
		}
		describe += "\n" + "  Square = " + square + " m^2 ";
		if ((furnitureList != null) && (furnitureList.size() == 0)) {
			describe += " (free 100%)";
		}
		if ((furnitureList != null) && (furnitureList.size() > 0)) {
			describe += " (" + (sumFurnitureSquare() + sumFromFurnitureSquare()) + " - "
					+ (sumFurnitureSquare() + sumToFurnitureSquare()) + " m^2 are occupied, guaranteed free "
					+ (square - sumFurnitureSquare() - sumToFurnitureSquare()) + " m^2 or "
					+ (square - sumToFurnitureSquare()) + " % of the area)";
		}
		describe += "\n" + "  Furniture: ";
		if ((furnitureList != null) && (furnitureList.size() == 0)) {
			describe += "no" + "\n ";
		}
		if ((furnitureList != null) && (furnitureList.size() > 0)) {
			describe += "\n";
			for (Furniture furniture : furnitureList) {
				if (furniture.getSquare() > 0) {
					describe += "   " + furniture.getName() + "(area " + furniture.getSquare() + " m^2)";
				} else {
					describe += "\n   " + furniture.getName() + "( area from " + furniture.getFromSquare() + " m^2 to "
							+ furniture.getToSquare() + " m^2)";
				}
			}
		}
		return describe;
	}

	public Room addLight(Lightbulb bulb) {
		lightsList.add(bulb);
		return this;
	}

	public Room addFurniture(Furniture f) throws SpaceUsageTooMuchException {
		double furnitureSquare = 0;
		double furnitureToSquare = 0;
		for (Furniture furniture : furnitureList) {
			if (furniture.getSquare() > 0) {
				furnitureSquare += sumFurnitureSquare();
			} else if (furniture.getToSquare() > 0) {
				furnitureToSquare += sumToFurnitureSquare();
			}
		}
		if (furnitureSquare > (square * 0.7) || (furnitureToSquare > (square * 0.7))) {
			throw new SpaceUsageTooMuchException("Error! So much furniture can not be located in this room");
		}
		furnitureList.add(f);
		return this;
	}
	/*
	 * public double[] sumFromToFurnitureSquare() { double[]
	 * resultSumFromToFurnitureSquare = new double[2];
	 * resultSumFromToFurnitureSquare[0] = 0; resultSumFromToFurnitureSquare[1]
	 * = 0; if ((furnitureList != null) && (furnitureList.size() > 0)) { for
	 * (Furniture furniture : furnitureList) { resultSumFromToFurnitureSquare[0]
	 * += furniture.getFromSquare(); resultSumFromToFurnitureSquare[1] +=
	 * furniture.getSquare(); } } return resultSumFromToFurnitureSquare; }
	 */
}
