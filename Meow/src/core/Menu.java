package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState 
{
	String fondPath = "rsrc/menu.png";
	Image fond;
	String strSong = "rsrc/menu.ogg";
	Music sound;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		fond = new Image(fondPath);
		sound = new Music(strSong);
		sound.loop();
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		fond.draw(0,0, 860, 660);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		Input input = arg0.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER))
        {
        	arg1.enterState(1, new FadeOutTransition(), new FadeInTransition());
        	sound.stop();
        }
	}

	@Override
	public int getID() {
		return 0;
	}

}
