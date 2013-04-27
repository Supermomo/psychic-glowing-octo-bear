package room;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Lounge extends Room{

	public Lounge(int x, int y) {
		super(x, y);
	}
	
	public Lounge(int x, int y, String image) throws SlickException {
		super(x, y, image);
	}

	@Override
	public void action() {
		//TODO
	}
	
}
