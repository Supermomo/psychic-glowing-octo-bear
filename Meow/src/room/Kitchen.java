package room;

import objetcs.Bowl;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import core.Game;
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
		Bowl b = (Bowl) getObj().get(0);
		h.setPositionX(this.getPositionX()+this.getWidth()/2 - (nbHuman-1)*60);
		if(timer + Human.frustration * 500 > 60000){
			b.plein = true;
			timer = 0;
		}
		
		if(Game.cat.getRoom().equals(this) && getObj().get(1).equals(Game.cat.getUsed())){
			Human.frustration += 15;
			Game.cat.setUsed(null);
			Game.cat.goTo(this);
			Game.acuteMeow.play();
		}
	}
	
	@Override
	public void leave(Human h){
		nbHuman--;
		if (!Game.dad.equals(h) && Game.dad.getRoom().equals(this)) {
			Game.dad.setPositionX(Game.dad.getPositionX() + Game.dad.getDebout().getWidth());
		}
		if (!Game.girl.equals(h) && Game.girl.getRoom().equals(this)) {
			Game.girl.setPositionX(Game.girl.getPositionX() + Game.girl.getDebout().getWidth());
		}
		if (!Game.mom.equals(h) && Game.mom.getRoom().equals(this)) {
			Game.mom.setPositionX(Game.mom.getPositionX() + Game.mom.getDebout().getWidth());
		}
	}
}
