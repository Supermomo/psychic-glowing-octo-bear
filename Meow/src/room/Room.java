package room;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import objetcs.Object;

public class Room {
	
	private ArrayList<Object> obj;
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private Image img;
	
	public Room(int x, int y, int w, int h) {
		positionX = x;
		positionY = y;
		width = w;
		height = h;
		obj = new ArrayList<Object>();
	}
	
	public Room(int x, int y)
	{
		positionX = x;
		positionY = y;
		obj = new ArrayList<Object>();
	}
	
	public Room(int x, int y, String image) throws SlickException{
		this(x,y);
		img = new Image(image);
	}
	
	public void action() {
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
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}

}
