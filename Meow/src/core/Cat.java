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
	private Image sitCat;
	private Image longCat;
	private Image displayImage;
	private int faim;
	private int sommeil;
	public int timer;
	
	public Cat(Room room, int positionX, int positionY, String image, String image2) throws SlickException {
		super();
		this.room = room;
		this.positionX = positionX;
		this.positionY = positionY;
		this.sitCat = new Image(image);
		this.longCat = new Image(image2);
		this.displayImage = this.sitCat;
		this.positionX -= this.sitCat.getWidth();
		this.positionY -= this.sitCat.getHeight();
		sommeil = 50;
		faim = 50;
	}

	public void goTo(Room room) {
		displayImage = sitCat;
		this.room = room;
		this.positionX = room.getPositionX() + room.getWidth();
		this.positionY = room.getPositionY() + room.getHeight();
		this.positionX -= this.displayImage.getWidth();
		this.positionY -= this.displayImage.getHeight();
	}
	
	public void minusFaim(){
		if(faim > 0)
			faim--;
	}
	
	public void minusSommeil(){
		if(sommeil > 0)
			sommeil--;
	}
	
	public void action(Usable u) {
		displayImage = sitCat;
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
		return displayImage;
	}
	
	public void setImage(Image image) {
		if (image.equals(longCat))
			displayImage = longCat;
		else
			displayImage = sitCat;
	}

	public Image getSitCat() {
		return sitCat;
	}

	public Image getLongCat() {
		return longCat;
	}

	public void draw(Graphics g){
		g.drawImage(this.getImage(), this.getPositionX(), this.getPositionY());
	}

}
