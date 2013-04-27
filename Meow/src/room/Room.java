package room;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Human;

import objetcs.Object;

public class Room {
	
	private ArrayList<Object> obj;
	private int positionX;
	private int positionY;
	private Image img;
	int nbHuman;
	
	public Room(int x, int y, int w, int h) {
		positionX = x;
		positionY = y;
		obj = new ArrayList<Object>();
	}
	
	public Room(int x, int y)
	{
		positionX = x;
		positionY = y;
		obj = new ArrayList<Object>();
		nbHuman = 0;
	}
	
	public Room(int x, int y, String image) throws SlickException{
		this(x,y);
		img = new Image(image);
	}
	
	public void action(Human h) {
		
	}
	
	public void leave(Human h) {
		
	}
	
	public int getHumans(){
		return nbHuman;
	}
	
	public void setHumans(int v){
		nbHuman = v;
	}
	
	public void draw(Graphics g){
		g.drawImage(img, this.positionX, this.positionY);
	}

	public ArrayList<Object> getObj() {
		return obj;
	}

	public void setObj(ArrayList<Object> obj) {
		this.obj = obj;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getWidth() {
		return img.getWidth();
	}

	public int getHeight() {
		return img.getHeight();
	}

	public Image getImg() {
		return img;
	}

}
