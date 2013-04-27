package room;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Bedroom extends Room{

	public Bedroom(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public Bedroom(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void action() {
		
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(Color.green);
		g.fillRect(this.getPositionX(), this.getPositionY(), this.getWidth(), this.getHeight());
	}

}
