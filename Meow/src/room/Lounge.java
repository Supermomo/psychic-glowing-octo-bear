package room;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Lounge extends Room{
	
	public Lounge(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	public Lounge(int x, int y) {
		super(x, y);
	}

	@Override
	public void action() {
		
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.fillRect(this.getPositionX(), this.getPositionY(), this.getWidth(), this.getHeight());
	}
	
}
