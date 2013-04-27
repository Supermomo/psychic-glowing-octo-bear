package core;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import room.Room;

public class Human {
	
	private Room room;
	private int positionX;
	private int positionY;
	private Image image;
	private Map map;
	
	public Human(Room room, int positionX, int positionY, Image image, Map map) {
		super();
		this.room = room;
		this.positionX = positionX;
		this.positionY = positionY;
		this.image = image;
		this.map = map;
	}

	public void action() {
		room.action();
	}
	
	public void update() {
		Random rand = new Random();
		int randomInt = rand.nextInt(4);
		room = map.getRooms().get(randomInt);
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


	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(this.getPositionX(), this.getPositionY(), image.getWidth(), image.getHeight());
	}

}
