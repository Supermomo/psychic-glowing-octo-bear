package objetcs;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Usable extends Object {
	
	public Usable(int positionX, int positionY, int width, int height) {
		super(positionX,positionY,width,height);
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
