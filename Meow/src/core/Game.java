package core;

import java.util.ArrayList;
import java.util.Iterator;

import objetcs.Bed;
import objetcs.Bowl;
import objetcs.Couch;
import objetcs.MicroWave;
import objetcs.Object;
import objetcs.Table;
import objetcs.Tv;
import objetcs.Usable;

import org.lwjgl.opengl.Drawable;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import room.Bedroom;
import room.Kitchen;
import room.Lounge;
import room.Room;

public class Game extends BasicGameState
{

	public Map map;
	private int timer;
	Room bedroom1, bedroom2, kitchen, lounge;
	String imgBed1 = "rsrc/Bedroom1.png";
	String imgBed2 = "rsrc/Bedroom2.png";
	String imgLounge = "rsrc/Lounge.png";
	String imgKitchen = "rsrc/Kitchen.png";
	String television = "rsrc/tv.png";
	String televisionOn = "rsrc/tv-on.png";
	String imgCouch = "rsrc/couch.png";
	String imgManStanding = "rsrc/man_standing.png";
	String imgManSitting = "rsrc/man_sit.png";
	String imgBed = "rsrc/bed.png";
	String imgTable = "rsrc/table.png";
	String imgMicro = "rsrc/microwave.png";
	String imgMicroOn = "rsrc/microwave-on.png";
	String imgBowl = "rsrc/bowl.png";
	
	String imgCat = "rsrc/cat.png";
	
	Image cursor; 
	Image cursorDown;
	Image cursorHover;
	int cursorOffsetx = 30;
	int cursorOffsety = 30;
	
	boolean cursorDownActivated = false;
	boolean cursorUpActivated = false;
	boolean cursorRegularActivated = false;
	
	
	//humans
	private Human dad;
	private Human mom;
	private Human girl;
	
	private Cat cat;
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		map = new Map();
		bedroom1 = new Bedroom(0, 0, imgBed1);
		map.getRooms().add(bedroom1);
		bedroom2 = new Bedroom(400, 0, imgBed2);
		map.getRooms().add(bedroom2);
		kitchen = new Kitchen(450, 350, imgKitchen);
		map.getRooms().add(kitchen);
		lounge = new Lounge(0, 350, imgLounge);
		map.getRooms().add(lounge);
		
		//Objects
		Bed bed1 = new Bed(bedroom1.getPositionX()+160, bedroom1.getPositionY()+10, imgBed);
		bedroom1.getObj().add(bed1);
		Bed bed2 = new Bed(bedroom2.getPositionX()+160, bedroom2.getPositionY()+10, imgBed);
		bedroom2.getObj().add(bed2);
		Couch couch = new Couch(lounge.getPositionX()+10, lounge.getPositionY()+25, imgCouch);
		lounge.getObj().add(couch);
		Tv tv = new Tv(lounge.getPositionX()+415, lounge.getPositionY()+50, television, televisionOn);
		lounge.getObj().add(tv);
		Bowl bowl = new Bowl(kitchen.getPositionX()+10, kitchen.getPositionY()+10, imgBowl);
		kitchen.getObj().add(bowl);
		Table table = new Table(kitchen.getPositionX()+60, kitchen.getPositionY()+85, imgTable);
		kitchen.getObj().add(table);
		MicroWave oven = new MicroWave(kitchen.getPositionX()+270, kitchen.getPositionY()+50, imgMicro, imgMicroOn);
		kitchen.getObj().add(oven);
		
		//humans
		dad = new Human(bedroom1, bedroom1.getPositionX()+bedroom1.getWidth()/2, 
				bedroom1.getPositionY()+bedroom1.getHeight()/2, imgManSitting, imgManStanding, map);
		mom = new Human(bedroom1, bedroom1.getPositionX()+bedroom1.getWidth()/2, 
				bedroom1.getPositionY()+bedroom1.getHeight()/2, imgManSitting, imgManStanding, map);
		girl = new Human(bedroom1, bedroom1.getPositionX()+bedroom1.getWidth()/2, 
				bedroom1.getPositionY()+bedroom1.getHeight()/2, imgManSitting, imgManStanding, map);
		
		bedroom1.setHumans(3);
		cat = new Cat(lounge, lounge.getPositionX()+lounge.getWidth(), 
				lounge.getPositionY()+lounge.getHeight(), imgCat);
		
		//cursor
		cursor = new Image("rsrc/paw.png");
		cursorDown = new Image("rsrc/paw_down.png");
		cursorHover = new Image("rsrc/paw_up.png");
		
		arg0.setMouseCursor(cursor, cursorOffsetx, cursorOffsety);
		cursorRegularActivated = true;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		for(Room r : map.getRooms())
		{
			r.draw(g);
			for (Object o : r.getObj()) {
				o.draw(g);
			}
		}
		dad.draw(g);
		mom.draw(g);
		girl.draw(g);
		cat.draw(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		timer += arg2;
		if (timer > 10000) {
			dad.getRoom().leave(dad);
			mom.getRoom().leave(mom);
			girl.getRoom().leave(girl);
			dad.update();
			mom.update();
			girl.update();
			timer = 0;
			/*dad.getRoom().action(dad);
			mom.getRoom().action(mom);
			girl.getRoom().action(girl);*/
		}
		
		if(arg0.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			
			if(!cursorDownActivated){
				arg0.setMouseCursor(cursorDown, cursorOffsetx, cursorOffsety);
				cursorDownActivated = true;
				cursorRegularActivated = false;
				cursorUpActivated = false;
			}
			int roomIndex = getClickedRoom(arg0.getInput().getMouseX(), arg0.getInput().getMouseY());
			
			if(roomIndex == -1){
				
				System.out.println("Unusable room !");
				
			}else{
				
				Room ro = map.getRooms().get(roomIndex);
				
				if(roomIndex == map.getRooms().indexOf(cat.getRoom())){
					
					int objIndex = getClickedObject(arg0.getInput().getMouseX(), 
							arg0.getInput().getMouseY(), ro);
					
					if (objIndex == -1) {
						System.out.println("Unusable object !");
					}else {
						
						try {
							cat.action((Usable)ro.getObj().get(objIndex));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				} else {
					cat.goTo(ro);
				}

				
			}

		}else if(checkIfHover(arg0.getInput().getMouseX(), arg0.getInput().getMouseY())){
			if(!cursorUpActivated){
				
				arg0.setMouseCursor(cursorHover, cursorOffsetx, cursorOffsety);
				cursorDownActivated = false;
				cursorRegularActivated = false;
				cursorUpActivated = true;
			}
			
		}else {
			if(!cursorRegularActivated){
				
				arg0.setMouseCursor(cursor, cursorOffsetx, cursorOffsety);
				cursorDownActivated = false;
				cursorRegularActivated = true;
				cursorUpActivated = false;
				
			}
		}
		
	}
	
	private boolean checkIfHover(int cursorX, int cursorY){
		
		for(Room room : this.map.getRooms()){
			
			if (cursorX > room.getPositionX() && cursorX < room.getPositionX() + room.getWidth()
					&&
					cursorY > room.getPositionY() && cursorY < room.getPositionY() + room.getHeight()){
				
				for(Object obj : room.getObj()){
					
					if(cursorX > obj.getPositionX() && cursorX < obj.getPositionX() + obj.getWidth()
							&&
							cursorY > obj.getPositionY() && cursorY < obj.getPositionY() + obj.getHeight()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private int getClickedRoom(int cursorX, int cursorY){
		
		for(Room room : this.map.getRooms()){
			
			if (cursorX > room.getPositionX() && cursorX < room.getPositionX() + room.getWidth()
					&&
					cursorY > room.getPositionY() && cursorY < room.getPositionY() + room.getHeight()){
				
				return map.getRooms().indexOf(room);
			}
		}
		return -1;
	}
	
	private int getClickedObject(int cursorX, int cursorY, Room room) {
		for(Object obj : room.getObj()){
			
			if(cursorX > obj.getPositionX() && cursorX < obj.getPositionX() + obj.getWidth()
					&&
					cursorY > obj.getPositionY() && cursorY < obj.getPositionY() + obj.getHeight()){
				
				return room.getObj().indexOf(obj);
			}
		}
		return -1;
	}

}
