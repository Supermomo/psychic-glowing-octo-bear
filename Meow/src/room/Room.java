package room;

import java.util.ArrayList;

import org.newdawn.slick.Image;

import objetcs.Object;

public class Room {
	
	ArrayList<Object> obj;
	int PositionX;
	int PositionY;
	Image img;
	
	public Room(int x, int y)
	{
		PositionX = x;
		PositionY = y;
	}

}
