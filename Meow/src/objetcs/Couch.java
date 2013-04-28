package objetcs;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import room.Lounge;

import core.Cat;

public class Couch extends Usable{

	Image img2;
	boolean isOn;
	
	public Couch(int positionX, int positionY, String imageOff) throws SlickException {
		super(positionX, positionY, imageOff);
	}
	
	@Override
	public void draw(Graphics g){
		g.drawImage(this.getImg(), this.getPositionX(), this.getPositionY());
	}
	
	@Override
	public void action (Cat cat) {
		cat.setUsed(this);	
		cat.setImage(cat.getSleeppingCat2());
		cat.setPositionX(getPositionX()+getWidth()/2 - cat.getImage().getWidth()/2);
		cat.setPositionY(getPositionY()+getHeight()/2 - cat.getImage().getHeight()/2);
	}
}
