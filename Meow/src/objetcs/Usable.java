package objetcs;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import core.Cat;

public class Usable extends Object {
	
	public Usable(int positionX, int positionY, int width, int height) {
		super(positionX,positionY,width,height);
	}
	
	public Usable(int positionX, int positionY, String image) throws SlickException {
		super(positionX,positionY,image);
	}

	public void action(Cat cat)
	{
		System.out.println("nothing to do here (calling action())");
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		
		if(getImg()==null){
		g.fillRect(this.getPositionX(), this.getPositionY(), this.getWidth(), this.getHeight());
		}
		else{
			g.drawImage(getImg(), this.getPositionX(), this.getPositionY());
		}
	}
}
