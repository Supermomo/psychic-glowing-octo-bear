package objetcs;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Cat;

public class Bowl extends Usable {

	public Bowl(int positionX, int positionY, String image) throws SlickException {
		super(positionX, positionY, image);
	}
	
	@Override
	public void action(Cat cat) {
		cat.setPositionX(getPositionX() + getWidth());
		cat.setPositionY(getPositionY() - cat.getImage().getHeight()/2);
	}
	
}
