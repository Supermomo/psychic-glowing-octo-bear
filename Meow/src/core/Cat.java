package core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import objetcs.Usable;
import room.Room;

public class Cat {
	
	private Room room;
	private Usable used;
	private int positionX;
	private int positionY;
	private Image sitCat;
	private Image longCat;
	private Image sleeppingCat;
	private Image sleeppingCat2;
	private Image displayImage;
	private int faim;
	private int sommeil;
	public int timer;
	
	public Cat(Room room, int positionX, int positionY, String image, String image2, String image3, String image4) throws SlickException {
		super();
		this.room = room;
		this.positionX = positionX;
		this.positionY = positionY;
		this.sitCat = new Image(image);
		this.longCat = new Image(image2);
		this.sleeppingCat = new Image(image3);
		this.sleeppingCat2 = new Image(image4);
		this.displayImage = this.sitCat;
		this.positionX -= this.sitCat.getWidth() + 40;
		this.positionY -= this.sitCat.getHeight() + 20;
		sommeil = 50;
		faim = 50;
	}

	public void goTo(Room room) {
		displayImage = sitCat;
		this.room = room;
		this.used = null;
		this.positionX = room.getPositionX() + room.getWidth();
		this.positionY = room.getPositionY() + room.getHeight();
		this.positionX -= this.displayImage.getWidth() + 40;
		this.positionY -= this.displayImage.getHeight() + 20;
	}
	
	public void minusFaim(){
		if(faim > 0)
			faim--;
	}
	
	public void plusFaim() {
		if (faim > 75) {
			faim = 100;
		} else 
			faim += 25;
	}
	
	public void plusFaim(int i) {
		if (faim + i > 100) {
			faim = 100;
		} else 
			faim += i;
	}
	
	public void minusSommeil(){
		if(sommeil > 0)
			sommeil--;
	}
	
	public void plusSommeil(int i) {
		if (sommeil < 100)
			sommeil+= i;
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
		displayImage = image;
	}

	public Image getSitCat() {
		return sitCat;
	}

	public Image getLongCat() {
		return longCat;
	}

	public Image getSleeppingCat() {
		return sleeppingCat;
	}

	public Image getSleeppingCat2() {
		return sleeppingCat2;
	}

	public Usable getUsed() {
		return used;
	}
	
	public int getSommeil(){
		return sommeil;
	}
	
	public int getHunger(){
		return faim;
	}

	public void setUsed(Usable used) {
		this.used = used;
	}

	public void draw(Graphics g){
		g.drawImage(this.getImage(), this.getPositionX(), this.getPositionY());
	}

}
