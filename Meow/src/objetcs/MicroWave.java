package objetcs;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Cat;

public class MicroWave extends Usable {
	
	private Image imageOn;
	private boolean isOn;

	public MicroWave(int positionX, int positionY, String imageOff, String imageOn) throws SlickException {
		super(positionX, positionY, imageOff);
		this.imageOn = new Image(imageOn);
	}
	
	public void draw(Graphics g){
		if(isOn)
			g.drawImage(imageOn, this.getPositionX(), this.getPositionY());
		else
			g.drawImage(this.getImg(), this.getPositionX(), this.getPositionY());
	}
	
	public void setOn(){
		isOn = true;
	}
	
	public void setOff(){
		isOn = false;
	}
	
	@Override
	public void action(Cat cat) {
		cat.setPositionX(getPositionX() - cat.getImage().getWidth());
		cat.setPositionY(getPositionY() - cat.getImage().getHeight()/2);
	}

}
