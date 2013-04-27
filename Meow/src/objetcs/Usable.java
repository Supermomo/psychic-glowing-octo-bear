package objetcs;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Usable extends Object {
	
	public Usable(int positionX, int positionY, int width, int height) {
		super(positionX,positionY,width,height);
	}
	
	public Usable(int positionX, int positionY, String image) throws SlickException {
		super(positionX,positionY,image);
	}

	public void action()
	{
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(this.getPositionX(), this.getPositionY(), this.getWidth(), this.getHeight());
	}
}
