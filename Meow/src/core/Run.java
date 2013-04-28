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
			AppGameContainer app = new AppGameContainer(new Holder("Meooooooooooow !!!"));
			app.setDisplayMode(860, 660, false);
			app.setTargetFrameRate(60);
			app.setVerbose(false);
			app.setShowFPS(false);
			app.start();
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}

}
