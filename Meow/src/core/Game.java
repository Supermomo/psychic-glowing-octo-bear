package core;

import java.util.ArrayList;
import java.util.Iterator;

import objetcs.Couch;
import objetcs.Object;
import objetcs.Tv;
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
	private int timer;
	Room bedroom1, bedroom2, kitchen, lounge;
	String imgBed1 = "rsrc/Bedroom1.png";
	String imgBed2 = "rsrc/Bedroom2.png";
	String imgLounge = "rsrc/Lounge.png";
	String imgKitchen = "rsrc/Kitchen.png";
	String television = "rsrc/tv.png";
	String televisionOn = "rsrc/tv-on.png";
	String imgCouch = "rsrc/couch.png";
	String imgHuman = "rsrc/"; //TODO
	Image cursor; 
	Image cursorDown;
	
	//humans
	private Human dad;
	
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
		Couch couch = new Couch(lounge.getPositionX()+10, lounge.getPositionY()+25, imgCouch);
		lounge.getObj().add(couch);
		Tv tv = new Tv(lounge.getPositionX()+415, lounge.getPositionY()+50, television, televisionOn);
		lounge.getObj().add(tv);
		Usable bowl = new Usable(kitchen.getPositionX()+10, kitchen.getPositionY()+10, 25, 25);
		kitchen.getObj().add(bowl);
		Object table = new Object(kitchen.getPositionX()+60, kitchen.getPositionY()+85, 200, 100);
		lounge.getObj().add(table);
		Usable oven = new Usable(kitchen.getPositionX()+290, kitchen.getPositionY()+50, 50, 70);
		kitchen.getObj().add(oven);
		
		//humans
		dad = new Human(lounge, lounge.getPositionX()+lounge.getWidth()/2, 
				lounge.getPositionY()+lounge.getHeight()/2, imgHuman, map);
		
		cursor = new Image("rsrc/paw.png");
		cursorDown = new Image("rsrc/paw_down.png");
		arg0.setMouseCursor(cursor, 10, 10);
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
		dad.draw(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		timer += arg2;
		if (timer > 10000) {
			dad.update();
			timer = 0;
		}
		
		if(arg0.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			arg0.setMouseCursor(cursorDown, 10, 10);
		} else {
			arg0.setMouseCursor(cursor, 10, 10);
		}
		
		
	}

}
