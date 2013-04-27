package objetcs;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Door extends Object {
	
	private boolean open;

	public Door(int positionX, int positionY, String image) throws SlickException {
		super(positionX, positionY, image);
	}

	public boolean isOpen() {
		return open;
	}
	
	@Override
	public void draw(Graphics g){
		if(isOpen())
			this.getImg().rotate(90);
	}

}
