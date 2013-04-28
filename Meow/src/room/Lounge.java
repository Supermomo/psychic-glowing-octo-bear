package room;

import objetcs.Tv;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import core.Game;
import core.Human;

public class Lounge extends Room{

	public Lounge(int x, int y) {
		super(x, y);
	}
	
	public Lounge(int x, int y, String image) throws SlickException {
		super(x, y, image);
	}

	public void action(Human h) {
		Tv television = (Tv) getObj().get(1);
		if(!television.isOn())
			television.setOn();
		nbHuman++;
		
		h.setPositionX(this.getPositionX()+30);
		h.setPositionY(this.getPositionY()+45+55*(nbHuman-1));
		h.changePos();
		if (nbHuman > 1 && Game.cat.getRoom().equals(this) && getObj().get(0).equals(Game.cat.getUsed())) {
			Human.frustration += 25;
			Game.cat.setUsed(null);
			Game.cat.goTo(this);
		}
	}
	
	@Override
	public void leave(Human h) {
		nbHuman--;
		if(nbHuman == 0) {
			Tv television = (Tv) getObj().get(1);
			television.setOff();
		}
		h.changePos();
	}
	
}
