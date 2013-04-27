package objetcs;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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
	
	public void sit() {
		//TODO
	}
}
