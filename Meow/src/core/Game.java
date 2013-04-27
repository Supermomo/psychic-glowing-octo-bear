package core;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		map = new Map();
		bedroom1 = new Bedroom(0, 0, 400, 250);
		map.getRooms().add(bedroom1);
		bedroom2 = new Bedroom(400, 0, 400, 250);
		map.getRooms().add(bedroom2);
		kitchen = new Kitchen(450, 350, 350, 250);
		map.getRooms().add(kitchen);
		lounge = new Lounge(0, 350, 450, 250);
		map.getRooms().add(lounge);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		for(Room r : map.getRooms())
			g.fillRect(r.getPositionX(), r.getPositionY(), r.getWidth(), r.getHeight());
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
