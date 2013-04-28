package objetcs;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Cat;

public class Bowl extends Usable {

	Image img2;
	public boolean plein;
	
	public Bowl(int positionX, int positionY, String image, String plein) throws SlickException {
		super(positionX, positionY, image);
		img2 = new Image(plein);
	}
	
	@Override
	public void action(Cat cat) {
		cat.setUsed(this);
		cat.setImage(cat.getLongCat());
		cat.setPositionX(getPositionX() + getWidth());
		cat.setPositionY(getPositionY());
		cat.plusFaim();
	}
	
	public boolean isPlein(){
		return plein;
	}
	
	@Override
	public void draw(Graphics g){
		if(plein)
			g.drawImage(img2, this.getPositionX(), this.getPositionY());
		else
			g.drawImage(getImg(), this.getPositionX(), this.getPositionY());
	}
	
}
