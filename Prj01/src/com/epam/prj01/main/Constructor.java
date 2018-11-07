package com.epam.prj01.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.prj01.bean.Building;
import com.epam.prj01.bean.Furniture;
import com.epam.prj01.bean.Lightbulb;
import com.epam.prj01.bean.Room;
import com.epam.prj01.exception.IlluminanceTooMuchException;
import com.epam.prj01.exception.SpaceUsageTooMuchException;

public class Constructor {

	static Logger logger = LogManager.getLogger(Constructor.class);

	public static void main(String[] args) {
		System.out.println("--------TEST---------");
		testSuccessBuildingCreating();
		System.out.println("--------TEST---------");
		testExceedRoomSquer();
		System.out.println("--------TEST---------");
	}

	public static void testSuccessBuildingCreating() {

		Room room_1 = new Room("Room 1", 150, 2);
		Room room_2 = new Room("Room 2", 0.1, 4);
		Room room_3 = new Room("Room 3", 220, 1);
		Room room_4 = new Room("Room 4", 280, 3);
		Room room_5 = new Room("Room 5", 420, 6);

		Map<String, Room> roomMapCollection = new HashMap<String, Room>();
		roomMapCollection.put(room_1.getRoomId(), room_1);
		roomMapCollection.put(room_2.getRoomId(), room_2);

		try {
			Building building = new Building("Building 1", roomMapCollection);
			building.addRoom(room_3).addRoom(room_4).addRoom(room_5);
			building.getRoom(room_1.getRoomId()).addLight(new Lightbulb(150)).addLight(new Lightbulb(100));
			building.getRoom(room_5.getRoomId()).addFurniture(new Furniture("secretaire", 3))
					.addFurniture(new Furniture("armchair", 1, 2));

			System.out.println("--------");
			System.out.println(building.describe());
			System.out.println("--------");
			System.out.println(room_1);
			System.out.println(room_5);
			System.out.println(building);
		} catch (SpaceUsageTooMuchException | IlluminanceTooMuchException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testExceedRoomSquer() {

		Room room_1 = new Room("Room 1", 150, 2);
		Room room_2 = new Room("Room 2", 0.1, 4);
		Room room_3 = new Room("Room 3", 220, 1);
		Room room_4 = new Room("Room 4", 280, 3);
		Room room_5 = new Room("Room 5", 4, 6);

		Map<String, Room> roomMapCollection = new HashMap<String, Room>();
		roomMapCollection.put(room_1.getRoomId(), room_1);
		roomMapCollection.put(room_2.getRoomId(), room_2);
		// ??
		try {
			Building building = new Building("Building 1", roomMapCollection);
			building.addRoom(room_3).addRoom(room_4).addRoom(room_5);
			building.getRoom(room_1.getRoomId()).addLight(new Lightbulb(150)).addLight(new Lightbulb(100));
			building.getRoom(room_5.getRoomId()).addFurniture(new Furniture("secretaire", 3))
					.addFurniture(new Furniture("armchair", 1, 2));
		} catch (SpaceUsageTooMuchException | IlluminanceTooMuchException e) {
			logger.error(e.getMessage());
			System.out.println(e.getMessage());

		}
	}
}
