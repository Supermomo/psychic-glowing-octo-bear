package room;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Bedroom extends Room{

	public Bedroom(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public Bedroom(int x, int y) {
		super(x, y);
	}
	
	public Bedroom(int x, int y, String image) throws SlickException {
		super(x, y, image);
	}
	
	@Override
	public void action() {
		
	}
}
