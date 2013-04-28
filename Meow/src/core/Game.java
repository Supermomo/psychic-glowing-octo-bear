package core;

import java.io.IOException;
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

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.opengl.Drawable;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.CursorLoader;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

import room.Bedroom;
import room.Kitchen;
import room.Lounge;
import room.Room;

public class Game extends BasicGameState
{

	public Map map;

	private int mouseTimer;
	
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
	String imgMomSitting = "rsrc/mom_sit.png";
	String imgMomStanding = "rsrc/mom.png";
	String imgGirlSitting = "rsrc/girl_sit.png";
	String imgGirlStanding = "rsrc/girl.png";
	String imgBed = "rsrc/bed.png";
	String imgTable = "rsrc/table.png";
	String imgMicro = "rsrc/microwave.png";
	String imgMicroOn = "rsrc/microwave-on.png";
	String imgBowl = "rsrc/bowl.png";
	String imgBowlEmpty = "rsrc/bowl_empty.png";
	
	String imgCat = "rsrc/cat.png";
	String imgCatLong = "rsrc/cat_long.png";
	String sleeppingCat = "rsrc/cat_sleeping.png";
	String sleeppingCat2 = "rsrc/cat_sleeping2.png";
	
	String imgBackground = "rsrc/background.png";
	
	String imgFaim = "rsrc/hunger.png";
	String imgSleep = "rsrc/sleep.png";
	String imgAnger = "rsrc/anger.png";
	
	String imgDanger = "rsrc/danger.png";
	
	Image background;
	
	Image sleep;
	Image anger;
	Image hunger;
	Image danger;
	
	Image cursor; 
	Image cursorDown;
	Image cursorHover;
	int cursorOffsetx = 30;
	int cursorOffsety = 30;
	
	boolean cursorDownActivated = false;
	boolean cursorUpActivated = false;
	boolean cursorRegularActivated = false;
	
	Cursor Cregular;
	Cursor CUp;
	Cursor CDown;
	
	//humans
	public static Human dad;
	public static Human mom;
	public static Human girl;
	
	public static Cat cat;
	public boolean catIsDead;
	
	Sound normalMeow;
	public static Sound acuteMeow;
	Sound death;
	Music mainMusic;
	
	
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
		
		//Jauge
		anger = new Image(imgAnger);
		hunger = new Image(imgFaim);
		sleep = new Image(imgSleep);
		danger = new Image(imgDanger);
		catIsDead = false;
		
		//Objects
		Bed bed1 = new Bed(bedroom1.getPositionX()+160, bedroom1.getPositionY()+10, imgBed);
		bedroom1.getObj().add(bed1);
		Bed bed2 = new Bed(bedroom2.getPositionX()+160, bedroom2.getPositionY()+10, imgBed);
		bedroom2.getObj().add(bed2);
		Couch couch = new Couch(lounge.getPositionX()+10, lounge.getPositionY()+25, imgCouch);
		lounge.getObj().add(couch);
		Tv tv = new Tv(lounge.getPositionX()+415, lounge.getPositionY()+50, television, televisionOn);
		lounge.getObj().add(tv);
		Bowl bowl = new Bowl(kitchen.getPositionX()+10, kitchen.getPositionY()+10, imgBowlEmpty, imgBowl);
		kitchen.getObj().add(bowl);
		Table table = new Table(kitchen.getPositionX()+60, kitchen.getPositionY()+85, imgTable);
		kitchen.getObj().add(table);
		MicroWave oven = new MicroWave(kitchen.getPositionX()+270, kitchen.getPositionY()+50, imgMicro, imgMicroOn);
		kitchen.getObj().add(oven);
		
		//humans
		dad = new Human(lounge, lounge.getPositionX()+lounge.getWidth()/2, 
				lounge.getPositionY()+lounge.getHeight()/2, imgManSitting, imgManStanding, map);
		lounge.action(dad);
		mom = new Human(bedroom1, bedroom1.getPositionX()+bedroom1.getWidth()/2, 
				bedroom1.getPositionY()+bedroom1.getHeight()/2, imgMomSitting, imgMomStanding, map);
		girl = new Human(bedroom2, bedroom2.getPositionX()+bedroom2.getWidth()/2, 
				bedroom2.getPositionY()+bedroom2.getHeight()/2, imgGirlSitting, imgGirlStanding, map);
		
		bedroom1.setHumans(1);
		bedroom2.setHumans(1);
		
		cat = new Cat(lounge, lounge.getPositionX()+lounge.getWidth(), 
				lounge.getPositionY()+lounge.getHeight(), imgCat, imgCatLong, sleeppingCat, sleeppingCat2);
		
		//cursor
		/*cursor = new Image("rsrc/paw.png");
		cursorDown = new Image("rsrc/paw_down.png");
		cursorHover = new Image("rsrc/paw_up.png");*/
		
		try {
			
			Cregular = CursorLoader.get().getCursor("rsrc/paw.png", cursorOffsetx, cursorOffsety);
			CUp = CursorLoader.get().getCursor("rsrc/paw_up.png", cursorOffsetx, cursorOffsety);
			CDown = CursorLoader.get().getCursor("rsrc/paw_down.png", cursorOffsetx, cursorOffsety);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		arg0.setMouseCursor(Cregular, cursorOffsetx, cursorOffsety);
		cursorRegularActivated = true;
		
		dad.timer = 7000;
		mom.timer = 4000;
		girl.timer = 0;
		
		mouseTimer = 0;
		
		background = new Image(imgBackground);
	    
	    normalMeow = new Sound("rsrc/normalMeow.ogg");
	    acuteMeow = new Sound("rsrc/acute.ogg");
	    death = new Sound("rsrc/cuteMeow.ogg");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		
		g.drawImage(background, -1, 0);
		
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
		
		if(cat.getHunger() < 20)
			g.drawImage(danger, 80, 600);
		g.setColor(Color.green);
		g.fillRect(150, 600, 40+1.5f*cat.getHunger(), 60);
		g.drawImage(hunger, 150, 600);
		
		if(cat.getSommeil() < 20)
			g.drawImage(danger, 430, 600);
		g.setColor(Color.blue);
		g.fillRect(500, 600, 40+1.5f*cat.getSommeil(), 60);
		g.drawImage(sleep, 500, 600);
		
		if(Human.frustration > 80)
			g.drawImage(danger, 800, 130);
		g.setColor(Color.red);
		g.fillRect(800, 200, 60, 10+1.5f*Human.frustration);
		g.drawImage(anger, 800, 200);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		if(mainMusic == null){
			//music 
			mainMusic = new Music("rsrc/main.ogg");
		    mainMusic.loop();
		}
		
		if(girl.getRoom() == cat.getRoom() && girl.getRoom().getHumans() == 1){
			death.play();
			end(arg1);
		}
		
		if(Human.frustration >= 100) {
			death.play();
			end(arg1);
		}
		
		mouseTimer += arg2;
		
		dad.timer += arg2;
		mom.timer += arg2;
		girl.timer += arg2;
		cat.timer += arg2;
		kitchen.timer += arg2;
		
		if (dad.timer > 10000) {
			dad.getRoom().leave(dad);
			dad.update();
			dad.timer = 0;
		}
		
		if (mom.timer > 10000) {
			mom.getRoom().leave(mom);
			mom.update();
			mom.timer = 0;
		}
		
		if (girl.timer > 10000) {
			girl.getRoom().leave(girl);
			girl.update();
			girl.timer = 0;
		}
		
		if(!catIsDead){
			if(arg0.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && mouseTimer > 500){
				mouseTimer = 0;
				if(!cursorDownActivated){
					arg0.setMouseCursor(CDown, cursorOffsetx, cursorOffsety);
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
								if (!((cat.getRoom() instanceof Lounge && cat.getRoom().getHumans() > 1)
										|| (cat.getRoom() instanceof Bedroom && cat.getRoom().getHumans() > 0))) {
									cat.action((Usable)ro.getObj().get(objIndex));
									if(normalMeow.playing()){
										normalMeow.stop();
									}
									normalMeow.play();
								}
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
					
					arg0.setMouseCursor(CUp, cursorOffsetx, cursorOffsety);
					cursorDownActivated = false;
					cursorRegularActivated = false;
					cursorUpActivated = true;
				}
				
			}else {
				if(!cursorRegularActivated){
					
					arg0.setMouseCursor(Cregular, cursorOffsetx, cursorOffsety);
					cursorDownActivated = false;
					cursorRegularActivated = true;
					cursorUpActivated = false;
					
				}
			}
			
			// Gestion du cat
			if(cat.timer > 2000)
			{
				cat.minusFaim();
				cat.minusSommeil();
				if (cat.getUsed() instanceof Bed) {
					cat.plusSommeil(3);
				}
				if (cat.getUsed() instanceof Couch) {
					cat.plusSommeil(2);
				}
				cat.timer = 0;
				if(Human.frustration > 0)
					Human.frustration--;
				if(cat.getSommeil() == 0)
					catIsDead = true;
				if(cat.getHunger() == 0)
					catIsDead = true;
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
	
	private void end(StateBasedGame sbg){
		if(Human.frustration < 100)
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
		else
			sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
		mainMusic.stop();
	}

}
