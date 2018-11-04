package com.epam.prj01.bean;

import java.util.HashMap;
import java.util.Map;

public class Building {
	private String buildingID;
	private Map<String, Room> building = new HashMap<String, Room>();

	public Building() {
		super();
	}

	public Building(String buildingID, Map<String, Room> building) {
		super();
		this.buildingID = buildingID;
		this.building = building;
	}

	public Map<String, Room> getBuilding() {
		return building;
	}

	public void setBuilding(Map<String, Room> building) {
		this.building = building;
	}

	public String getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(String buildingID) {
		this.buildingID = buildingID;
	}

	@Override
	public String toString() {
		return "Building [buildingID=" + buildingID + ", building=" + building + "]";
	}

	public Building addRoom(Room room) {
		building.put(room.getRoomId(), room);
		return this;
	}

	public Room getRoom(String roomId) {
		return building.get(roomId);
	}

	public String describe() {
		String describe = buildingID + "\n ";
		if ((building != null) && (building.size() > 0)) {
			for (String key : building.keySet()) {
				Room room = building.get(key);
				describe += room.describeRoom();
			}
		}
		return describe;

	}
}
