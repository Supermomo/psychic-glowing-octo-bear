package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class KilledByOven extends BasicGameState{

	Image fond;
	Music sound;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		fond = new Image("rsrc/micro_kill.png");
		sound = new Music("rsrc/girlDeath.ogg");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		fond.draw(0, 0, 860, 660);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		if(!sound.playing()){
			sound.loop();
		}
		
		Input input = arg0.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER))
        {
        	arg1.enterState(4, new FadeOutTransition(), new FadeInTransition());
        	sound.stop();
        }
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

}
