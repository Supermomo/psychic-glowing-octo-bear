package core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import objetcs.Usable;
import room.Room;

public class Cat {
	
	private Room room;
	private int positionX;
	private int positionY;
	private Image image;
	
	public Cat(Room room, int positionX, int positionY, String image) throws SlickException {
		super();
		this.room = room;
		this.positionX = positionX;
		this.positionY = positionY;
		this.image = new Image(image);
		this.positionX -= this.image.getWidth();
		this.positionY -= this.image.getHeight();
	}

	public void goTo(Room room) {
		this.room = room;
		this.positionX = room.getPositionX() + room.getWidth();
		this.positionY = room.getPositionY() + room.getHeight();
		this.positionX -= this.image.getWidth();
		this.positionY -= this.image.getHeight();
	}
	
	public void action(Usable u) {
		u.action(this);
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

	public Image getImage() {
		return image;
	}

	public void draw(Graphics g){
		g.drawImage(this.getImage(), this.getPositionX(), this.getPositionY());
	}

}
