package room;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import core.Game;
import core.Human;

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
	public void action(Human h) {
		nbHuman++;
		h.setPositionX(this.getPositionX()+185);
		h.setPositionY(this.getPositionY()+20);
		if (Game.cat.getRoom().equals(this) && getObj().get(0).equals(Game.cat.getUsed())) {
			Human.frustration += 25;
			Game.cat.setUsed(null);
			Game.cat.goTo(this);
			if(Game.girl != h)
				Game.acuteMeow.play();
		}
	}
	
	@Override
	public void leave(Human h) {
		nbHuman--;
	}
}
