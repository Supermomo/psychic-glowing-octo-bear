package core;

import objetcs.Usable;
import room.Room;

public class Cat {
	
	private Room room;
	
	public void action(Usable u) {
		u.action();
	}

}
