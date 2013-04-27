package blood;

import java.awt.Font;
import java.io.File;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Score extends BasicGameState 
{
	UnicodeFont font;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		font = new UnicodeFont("./ressources/stonehen.ttf", 45, false, false);
		font.addAsciiGlyphs();
		font.getEffects().add(new ColorEffect(java.awt.Color.GRAY));
		font.loadGlyphs();
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException 
	{
		font.drawString( 380, 250, "Bravo !\nGwenn Aubert\nMatthieu Maugard" );
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		Input input = arg0.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER))
        {
        	arg1.enterState(0);
        }
	}

	@Override
	public int getID() {
		return 2;
	}

}
