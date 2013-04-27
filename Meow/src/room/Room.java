package room;

import java.util.ArrayList;

import org.newdawn.slick.Image;

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
	}
	
	public Room(int x, int y)
	{
		positionX = x;
		positionY = y;
	}
	
	public void action() {
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
