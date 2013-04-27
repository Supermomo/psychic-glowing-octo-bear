package room;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import core.Human;

public class Kitchen extends Room{

	public Kitchen(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public Kitchen(int x, int y) {
		super(x, y);
	}
	
	public Kitchen(int x, int y, String image) throws SlickException {
		super(x, y, image);
	}
	
	@Override
	public void action(Human h) {
		nbHuman++;
		h.setPositionX(this.getPositionX()+this.getWidth()/2 - (nbHuman-1)*60);
	}
	
	@Override
	public void leave(Human h){
		nbHuman--;
	}
}
