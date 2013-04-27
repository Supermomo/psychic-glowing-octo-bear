package core;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import room.Room;

public class Human {
	
	static final int pbedroom1 = 15;
	static final int pbedroom2 = 30;
	static final int pkitchen = 60;
	static final int plounge = 100;
	
	private Room room;
	private int positionX;
	private int positionY;
	private Image image;
	private Map map;
	
	public Human(Room room, int positionX, int positionY, String image, Map map) throws SlickException{
		super();
		this.room = room;
		this.positionX = positionX;
		this.positionY = positionY;
		//TODO this.image = new Image(image);
		this.map = map;
	}

	public void action() {
		room.action();
	}
	
	public void update() {
		Random rand = new Random();
		int randomInt = rand.nextInt(100);
		if (randomInt <= pbedroom1)
			room = map.getRooms().get(0);
		else if (randomInt <= pbedroom2)
			room = map.getRooms().get(1);
		else if (randomInt <= pkitchen)
			room = map.getRooms().get(2);
		else 
			room = map.getRooms().get(3);

		positionX = room.getPositionX()+room.getWidth()/2;
		positionY = room.getPositionY()+room.getHeight()/2;
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
		g.setColor(Color.gray);
		//TODO g.fillRect(this.getPositionX(), this.getPositionY(), image.getWidth(), image.getHeight());
		g.fillRect(this.getPositionX(), this.getPositionY(), 50,50);
	}

}
