package core;

import java.util.ArrayList;

import room.Room;

public class Map {
	
	private ArrayList<Room> rooms;

	public Map(){
		rooms = new ArrayList<Room>();
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	
}
