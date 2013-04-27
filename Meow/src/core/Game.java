package core;

import java.util.ArrayList;
import java.util.Iterator;

import objetcs.Object;
import objetcs.Usable;

import org.lwjgl.opengl.Drawable;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import room.Bedroom;
import room.Kitchen;
import room.Lounge;
import room.Room;

public class Game extends BasicGameState
{

	public Map map;
	Room bedroom1, bedroom2, kitchen, lounge;
	String imgBed1 = "rsrc/Bedroom1.png";
	String imgBed2 = "rsrc/Bedroom2.png";
	String imgLounge = "rsrc/Lounge.png";
	String imgKitchen = "rsrc/Kitchen.png";
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		map = new Map();
		bedroom1 = new Bedroom(0, 0, imgBed1);
		map.getRooms().add(bedroom1);
		bedroom2 = new Bedroom(400, 0, imgBed2);
		map.getRooms().add(bedroom2);
		kitchen = new Kitchen(450, 350, imgKitchen);
		map.getRooms().add(kitchen);
		lounge = new Lounge(0, 350, imgLounge);
		map.getRooms().add(lounge);
		
		//Objects
		Usable bed1 = new Usable(bedroom1.getPositionX()+160, bedroom1.getPositionY()+10, 100, 150);
		bedroom1.getObj().add(bed1);
		Usable bed2 = new Usable(bedroom2.getPositionX()+160, bedroom2.getPositionY()+10, 100, 150);
		bedroom2.getObj().add(bed2);
		Usable couch = new Usable(lounge.getPositionX()+10, lounge.getPositionY()+35, 100, 200);
		lounge.getObj().add(couch);
		Object tv = new Object(lounge.getPositionX()+415, lounge.getPositionY()+50, 25, 150);
		lounge.getObj().add(tv);
		Usable bowl = new Usable(kitchen.getPositionX()+10, kitchen.getPositionY()+10, 25, 25);
		kitchen.getObj().add(bowl);
		Object table = new Object(kitchen.getPositionX()+60, kitchen.getPositionY()+85, 200, 100);
		lounge.getObj().add(table);
		Usable oven = new Usable(kitchen.getPositionX()+290, kitchen.getPositionY()+50, 50, 70);
		kitchen.getObj().add(oven);
		
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		for(Room r : map.getRooms())
		{
			r.draw(g);
			for (Object o : r.getObj()) {
				o.draw(g);
			}
		}
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
