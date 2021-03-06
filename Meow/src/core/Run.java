package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try 
		{
			String [] refs ={"rsrc/cat_16.png","rsrc/cat_32.png"}; 
			AppGameContainer app = new AppGameContainer(new Holder("Curiosity"));
			app.setDisplayMode(860, 660, false);
			app.setTargetFrameRate(60);
			app.setVerbose(true);
			app.setShowFPS(false);
			app.setIcons(refs);
			app.start();
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}

}
