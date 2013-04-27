package objetcs;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tv extends Usable{

	Image img2;
	boolean isOn;
	
	public Tv(int positionX, int positionY, String imageOff, String imageOn) throws SlickException {
		super(positionX, positionY, imageOff);
		img2 = new Image(imageOn);
		isOn = false;
	}
	
	@Override
	public void draw(Graphics g){
		if(isOn)
			g.drawImage(img2, this.getPositionX(), this.getPositionY());
		else
			g.drawImage(this.getImg(), this.getPositionX(), this.getPositionY());
	}
	
	public void setOn(){
		isOn = true;
	}
	
	public void setOff(){
		isOn = false;
	}
	
	public boolean isOn(){
		return isOn;
	}

}
