package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Holder extends StateBasedGame
{

	public Holder(String title) {
		super(title);
	}
	
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException 
	{
		this.addState(new Menu());
		this.addState(new Game());
		this.enterState(0);
	}

}
