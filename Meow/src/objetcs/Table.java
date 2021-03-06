package objetcs;

import org.newdawn.slick.SlickException;

import core.Cat;

public class Table extends Usable {

	public Table(int positionX, int positionY, String image)
			throws SlickException {
		super(positionX, positionY, image);
	}
	
	@Override
	public void action(Cat cat) {
		cat.setImage(cat.getSleeppingCat());
		cat.setUsed(this);
		cat.setPositionX(getPositionX()+getWidth()/2 - cat.getImage().getWidth()/2);
		cat.setPositionY(getPositionY()+getHeight()/2 - cat.getImage().getHeight()/2 - 25);
	}

}
