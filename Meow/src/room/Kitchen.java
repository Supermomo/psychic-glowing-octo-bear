package room;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Kitchen extends Room{

	public Kitchen(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public Kitchen(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void action() {
		
	}

	@Override
	public void draw(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(this.getPositionX(), this.getPositionY(), this.getWidth(), this.getHeight());
	}
}
