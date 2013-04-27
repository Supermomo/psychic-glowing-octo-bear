package blood;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState 
{
	String fondPath = "./ressources/menu.png";
	Image fond;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		fond = new Image(fondPath);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		fond.draw(0,0, 800, 600);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		Input input = arg0.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER))
        {
        	arg1.enterState(1);
        }
	}

	@Override
	public int getID() {
		return 0;
	}

}
